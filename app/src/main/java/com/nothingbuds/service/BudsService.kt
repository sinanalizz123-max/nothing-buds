package com.nothingbuds.service

import android.Manifest
import android.app.Service
import android.bluetooth.BluetoothA2dp
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothProfile
import android.bluetooth.BluetoothSocket
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Binder
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.core.app.ActivityCompat
import com.nothingbuds.data.BudsRepository
import com.nothingbuds.data.DeviceModels
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.AncMode
import com.nothingbuds.protocol.Commands
import com.nothingbuds.protocol.EqPreset
import com.nothingbuds.protocol.PacketBuilder
import com.nothingbuds.protocol.ResponseParser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.UUID

class BudsService : Service() {

    companion object {
        private const val TAG = "BudsService"
        private const val NOTIFICATION_ID = 1
        private const val CONNECT_GRACE_MS = 20_000L
        private const val COMMAND_GAP_MS = 200L
        private const val STATE_SAVE_DEBOUNCE_MS = 3_000L
        private const val NOTIF_THROTTLE_MS = 500L
        private const val CONNECT_MAX_ATTEMPTS = 3
        private const val CONNECT_RETRY_BASE_MS = 1_500L
        private const val RECONNECT_INITIAL_DELAY_MS = 2_000L
        private const val RECONNECT_MAX_BACKOFF_MS = 8_000L
        private const val RECONNECT_MAX_ATTEMPTS = 50
        private const val REBOOT_TONE_MS = 500L

        // Nothing/CMF SPP UUID
        val SPP_UUID: UUID = UUID.fromString("aeac4a03-dff5-498f-843a-34487cf133eb")

        // Action constants
        const val ACTION_CONNECT = "com.nothingbuds.ACTION_CONNECT"
        const val ACTION_DISCONNECT = "com.nothingbuds.ACTION_DISCONNECT"
        const val ACTION_SET_ANC = "com.nothingbuds.ACTION_SET_ANC"
        const val ACTION_CYCLE_ANC = "com.nothingbuds.ACTION_CYCLE_ANC"
        const val ACTION_REFRESH_NOTIFICATION = "com.nothingbuds.ACTION_REFRESH_NOTIFICATION"
        const val ACTION_SEND_RAW = "com.nothingbuds.ACTION_SEND_RAW"
        const val ACTION_SEND_COMMAND = "com.nothingbuds.ACTION_SEND_COMMAND"
        const val EXTRA_DEVICE_ADDRESS = "device_address"
        const val EXTRA_ANC_MODE = "anc_mode"
        const val EXTRA_RAW_HEX = "raw_hex"
        const val EXTRA_COMMAND_HEX = "command_hex"
        const val EXTRA_PAYLOAD_HEX = "payload_hex"
    }

    private val binder = LocalBinder()
    private val serviceScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private var bluetoothSocket: BluetoothSocket? = null
    private var inputStream: InputStream? = null
    private var outputStream: OutputStream? = null
    private var readJob: Job? = null
    private var pollJob: Job? = null
    private var writeJob: Job? = null
    private var saveJob: Job? = null
    private var notifThrottleJob: Job? = null
    private var notifPending = false
    private var a2dpProfile: BluetoothA2dp? = null
    private var isConnecting = false  // Prevent multiple connection attempts
    private var isDestroying = false  // Avoid stopSelf() while already tearing down
    private var reconnectJob: Job? = null
    private var disconnectRequestedByUser = false

    /**
     * Serializes writes to the socket. Every caller enqueues here and a single writer coroutine
     * drains it, so packets can never interleave or reorder even when the QS tile, the notification
     * hub and the UI all fire at once. The gap between commands is enforced here, not by callers.
     */
    private val commandChannel = Channel<ByteArray>(Channel.UNLIMITED)



    /** Single source of truth, shared with the tile and the UI. */
    val state: StateFlow<EarbudsState> = BudsRepository.state

    private lateinit var notificationHelper: NotificationHelper

    // Bluetooth connection state receiver
    private val bluetoothReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                BluetoothDevice.ACTION_ACL_CONNECTED -> {
                    val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE, BluetoothDevice::class.java)
                    } else {
                        @Suppress("DEPRECATION")
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    }
                    device?.let { onDeviceConnected(it) }
                }
                BluetoothDevice.ACTION_ACL_DISCONNECTED -> {
                    val device = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE, BluetoothDevice::class.java)
                    } else {
                        @Suppress("DEPRECATION")
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    }
                    device?.let { onDeviceDisconnected(it) }
                }
            }
        }
    }

    private val profileListener = object : BluetoothProfile.ServiceListener {
        override fun onServiceConnected(profile: Int, proxy: BluetoothProfile) {
            if (profile == BluetoothProfile.A2DP) {
                a2dpProfile = proxy as BluetoothA2dp
                // Check for already connected devices
                checkConnectedDevices()
            }
        }

        override fun onServiceDisconnected(profile: Int) {
            if (profile == BluetoothProfile.A2DP) {
                a2dpProfile = null
            }
        }
    }

    inner class LocalBinder : Binder() {
        fun getService(): BudsService = this@BudsService
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service created")

        reconnectJob?.cancel()
        reconnectJob = null
        disconnectRequestedByUser = false

        // Load saved state to show last known values while connecting
        loadSavedState()?.let { savedState ->
            Log.d(TAG, "Loaded saved state: ${savedState.deviceName}, ANC=${savedState.ancMode}")
            BudsRepository.set(savedState)
        }

        notificationHelper = NotificationHelper(this)
        // A foreground service must post something immediately; this placeholder is replaced by the
        // real hub once connected, and pulled entirely if no earbuds show up.
        startForeground(NOTIFICATION_ID, notificationHelper.createConnectingNotification())

        // Register for Bluetooth events
        val filter = IntentFilter().apply {
            addAction(BluetoothDevice.ACTION_ACL_CONNECTED)
            addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED)
        }
        registerReceiver(bluetoothReceiver, filter)

        // Get A2DP profile to check connected devices
        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        bluetoothManager.adapter?.getProfileProxy(this, profileListener, BluetoothProfile.A2DP)

        // Also check immediately for connected devices
        serviceScope.launch {
            delay(1000) // Give time for profile to connect
            // First try to connect to saved device
            val savedAddress = getSavedDeviceAddress()
            if (savedAddress != null && !BudsRepository.state.value.isConnected) {
                Log.d(TAG, "Trying to connect to saved device: $savedAddress")
                connect(savedAddress)
            } else {
                checkConnectedDevices()
            }

            // Nothing answered within the grace period AND there is no saved device worth waiting on:
            // don't leave a dangling "Connecting…" notification behind. With a saved device the
            // reconnect loop keeps waiting for it (reboots are normal on codec/dual changes).
            delay(CONNECT_GRACE_MS)
            if (!BudsRepository.state.value.isConnected && getSavedDeviceAddress() == null) {
                Log.d(TAG, "No earbuds connected within grace period, stopping")
                stopNotification()
            }
        }
    }

    private fun getSavedDeviceAddress(): String? {
        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        return prefs.getString("last_device_address", null)
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand: ${intent?.action}")
        when (intent?.action) {
            ACTION_CONNECT -> {
                val address = intent.getStringExtra(EXTRA_DEVICE_ADDRESS)
                if (address != null) {
                    connect(address)
                }
            }
            ACTION_DISCONNECT -> {
                disconnect()
            }
            ACTION_SET_ANC -> {
                val mode = intent.getStringExtra(EXTRA_ANC_MODE)
                    ?.let { name -> AncMode.entries.find { it.name == name } }
                if (mode != null) setAncMode(mode)
            }
            ACTION_CYCLE_ANC -> {
                cycleAncMode()
            }
            ACTION_REFRESH_NOTIFICATION -> {
                updateNotification()
            }
            ACTION_SEND_RAW -> {
                intent.getStringExtra(EXTRA_RAW_HEX)?.let { hex ->
                    sendCommand(hex.hexToBytes())
                }
            }
            ACTION_SEND_COMMAND -> {
                val command = intent.getStringExtra(EXTRA_COMMAND_HEX)?.toIntOrNull(16)
                if (command != null) {
                    val payload = intent.getStringExtra(EXTRA_PAYLOAD_HEX).orEmpty()
                    sendCommand(PacketBuilder.build(command, payload.hexToBytes()))
                }
            }
            else -> {
                // No specific action, check for connected devices
                checkConnectedDevices()
            }
        }
        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(TAG, "Service destroyed")
        isDestroying = true
        reconnectJob?.cancel()
        reconnectJob = null
        try {
            unregisterReceiver(bluetoothReceiver)
        } catch (e: Exception) {
            Log.e(TAG, "Error unregistering receiver", e)
        }

        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        a2dpProfile?.let {
            bluetoothManager.adapter?.closeProfileProxy(BluetoothProfile.A2DP, it)
        }

        disconnect()
        serviceScope.cancel()
        super.onDestroy()
    }

    private fun checkConnectedDevices() {
        if (!hasBluetoothPermission()) {
            Log.w(TAG, "No Bluetooth permission")
            return
        }

        // Check A2DP connected devices first
        a2dpProfile?.connectedDevices?.forEach { device ->
            Log.d(TAG, "A2DP connected device: ${device.name}")
            if (isNothingDevice(device) && !BudsRepository.state.value.isConnected) {
                Log.d(TAG, "Found Nothing/CMF device via A2DP: ${device.name}")
                connect(device.address)
                return
            }
        }

        // A2DP is the authoritative "actually connected right now" signal. There is deliberately no
        // bonded-device fallback here: a still-paired but long-sold pair of earbuds within range
        // would otherwise be auto-connected, which only confuses the device picker.
    }

    private fun onDeviceConnected(device: BluetoothDevice) {
        if (!hasBluetoothPermission()) return

        Log.d(TAG, "Device connected: ${device.name}")
        if (isNothingDevice(device) && !BudsRepository.state.value.isConnected) {
            Log.d(TAG, "Nothing/CMF device connected, establishing SPP connection...")
            // Small delay to let the device settle
            serviceScope.launch {
                delay(2000)
                connect(device.address)
            }
        }
    }

    private fun onDeviceDisconnected(device: BluetoothDevice) {
        if (!hasBluetoothPermission()) return

        Log.d(TAG, "Device disconnected: ${device.name}")
        // Match on the stable MAC rather than the mutable Bluetooth name.
        if (BudsRepository.state.value.deviceAddress == device.address) {
            Log.d(TAG, "Our connected device disconnected")
            softDisconnect()
        }
    }

    private fun isNothingDevice(device: BluetoothDevice): Boolean {
        if (!hasBluetoothPermission()) return false
        return DeviceModels.looksLikeEarbuds(device.name)
    }

    fun connect(deviceAddress: String) {
        serviceScope.launch {
            // Prevent multiple simultaneous connection attempts
            if (isConnecting) {
                Log.d(TAG, "Already connecting, ignoring...")
                return@launch
            }

            if (BudsRepository.state.value.isConnected) {
                Log.d(TAG, "Already connected")
                return@launch
            }

            isConnecting = true

            val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
            val bluetoothAdapter = bluetoothManager.adapter

            if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled) {
                Log.e(TAG, "Bluetooth not available or not enabled")
                isConnecting = false
                return@launch
            }

            if (!hasBluetoothPermission()) {
                Log.e(TAG, "Missing Bluetooth permission")
                isConnecting = false
                return@launch
            }

            try {
                val device = bluetoothAdapter.getRemoteDevice(deviceAddress)
                var connected = false
                for (attempt in 1..CONNECT_MAX_ATTEMPTS) {
                    if (BudsRepository.state.value.isConnected) {
                        connected = true
                        break
                    }
                    if (attempt > 1) {
                        Log.d(TAG, "Retry $attempt/$CONNECT_MAX_ATTEMPTS")
                        delay(CONNECT_RETRY_BASE_MS * (attempt - 1))
                    }
                    try {
                        if (connectToDevice(device)) {
                            connected = true
                            break
                        }
                    } catch (e: Exception) {
                        // connectToDevice cleans up its local socket; log and back off.
                        Log.w(TAG, "Connect attempt $attempt/$CONNECT_MAX_ATTEMPTS failed", e)
                    }
                }
                if (!connected) {
                    Log.w(TAG, "All connect attempts exhausted")
                    softDisconnect()
                }
            } catch (e: Exception) {
                Log.e(TAG, "Failed to connect", e)
                updateState { it.copy(isConnected = false) }
            } finally {
                isConnecting = false
            }
        }
    }

    private suspend fun connectToDevice(device: BluetoothDevice): Boolean {
        if (!hasBluetoothPermission()) return false

        try {
            Log.d(TAG, "Connecting to ${device.name} (${device.address})")

            // Wait a bit for the audio connection to stabilize
            delay(1000)

            // Try multiple connection methods
            var connected = false

            // Method 1: Standard SPP UUID
            if (!connected) {
                try {
                    Log.d(TAG, "Trying SPP UUID connection...")
                    bluetoothSocket = device.createRfcommSocketToServiceRecord(SPP_UUID)
                    bluetoothSocket?.connect()
                    connected = true
                    Log.d(TAG, "SPP UUID connection successful")
                } catch (e: Exception) {
                    Log.w(TAG, "SPP UUID connection failed: ${e.message}")
                    bluetoothSocket?.close()
                    bluetoothSocket = null
                }
            }

            // Method 2: Insecure RFCOMM
            if (!connected) {
                try {
                    Log.d(TAG, "Trying insecure RFCOMM connection...")
                    bluetoothSocket = device.createInsecureRfcommSocketToServiceRecord(SPP_UUID)
                    bluetoothSocket?.connect()
                    connected = true
                    Log.d(TAG, "Insecure RFCOMM connection successful")
                } catch (e: Exception) {
                    Log.w(TAG, "Insecure RFCOMM connection failed: ${e.message}")
                    bluetoothSocket?.close()
                    bluetoothSocket = null
                }
            }

            // Method 3: Reflection fallback (port 1)
            if (!connected) {
                try {
                    Log.d(TAG, "Trying reflection fallback...")
                    val method = device.javaClass.getMethod("createRfcommSocket", Int::class.java)
                    bluetoothSocket = method.invoke(device, 1) as BluetoothSocket
                    bluetoothSocket?.connect()
                    connected = true
                    Log.d(TAG, "Reflection fallback connection successful")
                } catch (e: Exception) {
                    Log.w(TAG, "Reflection fallback failed: ${e.message}")
                    bluetoothSocket?.close()
                    bluetoothSocket = null
                }
            }

            if (!connected) {
                Log.w(TAG, "All connection methods failed")
                return false
            }
            Log.d(TAG, "Socket connected!")

            inputStream = bluetoothSocket?.inputStream
            outputStream = bluetoothSocket?.outputStream

            val deviceModel = DeviceModels.findByName(device.name ?: "")

            updateState {
                it.copy(
                    isConnected = true,
                    deviceName = device.name ?: "Unknown",
                    deviceAddress = device.address,
                    deviceModel = deviceModel
                )
            }
            disconnectRequestedByUser = false

            updateNotification()

            // Start reading responses, then the single writer that drains the command queue.
            startReadLoop()
            startWriteLoop()

            // Initialize device
            initializeDevice()

            // Start polling for status updates
            startPollLoop()

            // Save last connected device
            saveLastDevice(device.address)

            return true

        } catch (e: Exception) {
            Log.e(TAG, "Connection failed: ${e.message}", e)
            // Tear down any partial socket so a retry starts from a clean slate. The caller
            // decides whether to retry or give up, so we do not stop the service here.
            try {
                bluetoothSocket?.close()
            } catch (ignored: IOException) {
            }
            bluetoothSocket = null
            inputStream = null
            outputStream = null
            return false
        }
    }

    fun disconnect() {
        disconnectRequestedByUser = true
        reconnectJob?.cancel()
        reconnectJob = null
        isConnecting = false
        Log.d(TAG, "Disconnecting...")
        readJob?.cancel()
        pollJob?.cancel()
        writeJob?.cancel()
        // Drop anything still queued so stale commands from this session are never replayed onto
        // the next connection (which would misalign the request/response operation ids).
        while (commandChannel.tryReceive().isSuccess) {
            // drain
        }

        try {
            inputStream?.close()
            outputStream?.close()
            bluetoothSocket?.close()
        } catch (e: IOException) {
            Log.e(TAG, "Error closing socket", e)
        }

        inputStream = null
        outputStream = null
        bluetoothSocket = null


        updateState { EarbudsState() }
        stopNotification()
    }

    /**
     * Tears down the SPP socket after the buds dropped out from under us (ACL loss or a socket
     * error) but keeps the foreground service alive and quietly retries the saved device, because
     * switching codec or dual mode reboots the buds and they come straight back at the OS level.
     */
    private fun softDisconnect() {
        reconnectJob?.cancel()
        isConnecting = false
        Log.d(TAG, "Soft disconnect - scheduling reconnect")
        readJob?.cancel()
        pollJob?.cancel()
        writeJob?.cancel()
        // Drop anything still queued so stale commands are never replayed onto the next connection.
        while (commandChannel.tryReceive().isSuccess) {
            // drain
        }

        try {
            inputStream?.close()
            outputStream?.close()
            bluetoothSocket?.close()
        } catch (e: IOException) {
            Log.e(TAG, "Error closing socket", e)
        }

        inputStream = null
        outputStream = null
        bluetoothSocket = null

        updateState { it.copy(isConnected = false) }

        val savedAddress = getSavedDeviceAddress()
        if (savedAddress == null || disconnectRequestedByUser) {
            stopNotification()
            return
        }

        // Keep the foreground hub up with a "Connecting…" label so the user sees we are still
        // waiting on the buds instead of silently shutting down.
        startForeground(NOTIFICATION_ID, notificationHelper.createConnectingNotification())

        reconnectJob = serviceScope.launch {
            var attempt = 0
            var nextDelay = RECONNECT_INITIAL_DELAY_MS
            while (isActive && !disconnectRequestedByUser && attempt < RECONNECT_MAX_ATTEMPTS) {
                delay(nextDelay)
                if (BudsRepository.state.value.isConnected) break

                val adapter =
                    (getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter
                val saved = getSavedDeviceAddress()
                if (adapter != null && adapter.isEnabled && saved != null && hasBluetoothPermission()) {
                    attempt++
                    Log.d(TAG, "Reconnect attempt $attempt/$RECONNECT_MAX_ATTEMPTS -> $saved")
                    connect(saved)
                }
                nextDelay = minOf(RECONNECT_MAX_BACKOFF_MS, nextDelay + RECONNECT_INITIAL_DELAY_MS)
            }
            if (!BudsRepository.state.value.isConnected) {
                Log.d(TAG, "Reconnect attempts exhausted, going quiet")
                stopNotification()
            }
        }
    }

    /**
     * The hub is only meaningful while earbuds are attached, so the notification — and the service
     * with it — goes away on disconnect. It comes back through the ACL/companion triggers.
     */
    private fun stopNotification() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            stopForeground(STOP_FOREGROUND_REMOVE)
        } else {
            @Suppress("DEPRECATION")
            stopForeground(true)
        }
        notificationHelper.cancel(NOTIFICATION_ID)
        if (!isDestroying) stopSelf()
    }

    private fun startReadLoop() {
        readJob = serviceScope.launch {
            val readBuffer = ByteArray(1024)
            // Reused working buffer + how many of its leading bytes are currently meaningful.
            // Appending and draining move bytes in place instead of concatenating new arrays each
            // read, which was O(n^2) across a burst of small packets.
            var acc = ByteArray(1024)
            var accLen = 0

            while (isActive && inputStream != null) {
                try {
                    val bytesRead = inputStream?.read(readBuffer) ?: -1
                    if (bytesRead > 0) {
                        Log.d(TAG, "Received $bytesRead bytes")

                        if (accLen + bytesRead > acc.size) {
                            acc = acc.copyOf(maxOf(acc.size * 2, accLen + bytesRead))
                        }
                        System.arraycopy(readBuffer, 0, acc, accLen, bytesRead)
                        accLen += bytesRead

                        // Process complete packets (start with 0x55)
                        packetLoop@ while (true) {
                            var start = -1
                            for (i in 0 until accLen) {
                                if (acc[i] == 0x55.toByte()) {
                                    start = i
                                    break
                                }
                            }
                            if (start < 0) {
                                accLen = 0
                                break
                            }
                            // Drop any leading noise bytes that precede the next 0x55.
                            if (start > 0) {
                                System.arraycopy(acc, start, acc, 0, accLen - start)
                                accLen -= start
                            }

                            // Check if we have enough data for header
                            if (accLen < 8) break

                            val payloadLen = acc[5].toInt() and 0xFF
                            val packetLen = 8 + payloadLen + 2 // header + payload + crc
                            if (accLen < packetLen) break

                            val packet = acc.copyOf(packetLen)
                            System.arraycopy(acc, packetLen, acc, 0, accLen - packetLen)
                            accLen -= packetLen

                            handleResponse(packet)
                        }
                    } else if (bytesRead < 0) {
                        Log.w(TAG, "Read returned -1, connection closed")
                        if (isActive) softDisconnect()
                        break
                    }
                } catch (e: IOException) {
                    if (isActive) {
                        Log.e(TAG, "Read error: ${e.message}")
                        softDisconnect()
                    }
                    break
                }
            }
        }
    }

    private fun startPollLoop() {
        pollJob = serviceScope.launch {
            while (isActive && BudsRepository.state.value.isConnected) {
                delay(30000) // Poll every 30 seconds
                if (BudsRepository.state.value.isConnected) {
                    Log.d(TAG, "Polling status...")
                    sendCommand(PacketBuilder.readBattery())
                    sendCommand(PacketBuilder.readAnc())
                }
            }
        }
    }

    private suspend fun initializeDevice() {
        Log.d(TAG, "Initializing device...")
        // Order mirrors the official app: identity first, then the settings the UI shows.
        val opening = listOf(
            PacketBuilder.readBattery(),
            PacketBuilder.readAnc(),
            PacketBuilder.readFirmware(),
            PacketBuilder.readConfiguration(),
            PacketBuilder.readSupportedFeatures(),
            PacketBuilder.readEq(),
            PacketBuilder.readExtraFeatures(),
            PacketBuilder.readLowLatency(),
            PacketBuilder.readBassBoost(),
            PacketBuilder.readSpatialAudio(),
            PacketBuilder.setUtcTime(),
        )

        // Reverse-engineered extras. Their reads are gated on what the model is known to answer;
        // an unknown device gets the gesture read too because most models have it, and every read
        // is fire-and-forget so an unsupported command is simply ignored by the firmware.
        val model = BudsRepository.state.value.deviceModel
        val extras = buildList {
            if (model == null || model.hasGestureControl) add(PacketBuilder.readGestures())
            if (model == null || model.hasDual) {
                add(PacketBuilder.readDual())
                add(PacketBuilder.readDualDeviceList())
            }
            if (model == null || model.hasDiracEq) add(PacketBuilder.readDiracEq())
            if (model == null || model.hasLhdc) add(PacketBuilder.readLhdc())
            if (model == null || model.hasAutoPowerOff) add(PacketBuilder.readPowerOff())
            if (model == null || model.hasCaseLed) add(PacketBuilder.readCaseLed())
            if (model == null || model.hasDetailEnhancement) add(PacketBuilder.readDetailEnhancement())
        }

        (opening + extras).forEach { packet ->
            sendCommand(packet)
        }
    }

    private fun handleResponse(data: ByteArray) {
        val response = ResponseParser.parse(data) ?: return

        Log.d(TAG, "Parsed response - command: 0x${response.command.toString(16)}, payload: ${response.payload.toHexString()}")

        when (response.command) {
            Commands.RESPONSE_BATTERY, Commands.RESPONSE_PUSH_BATTERY, Commands.PUSH_BATTERY -> {
                val battery = ResponseParser.parseBattery(response.payload)
                Log.d(TAG, "Battery: L=${battery.left}%, R=${battery.right}%, Case=${battery.case}%")
                updateState { it.copy(battery = battery) }
                updateNotification()
            }

            Commands.RESPONSE_ANC, Commands.RESPONSE_PUSH_ANC, Commands.PUSH_ANC -> {
                val ancState = ResponseParser.parseAncState(response.payload)
                if (ancState != null) {
                    Log.d(TAG, "ANC state: mode=${ancState.mode}, level=${ancState.ancLevel}")
                    updateState { it.copy(ancMode = ancState.mode, ancLevel = ancState.ancLevel) }
                    updateNotification()
                }
            }

            Commands.ACK_SET_ANC -> {
                val status = response.payload.firstOrNull()?.toInt() ?: 0
                Log.d(TAG, "SET_ANC ack status=$status")
                if (status == 0) {
                    // The earbuds push the new state right after, but ask anyway so a rejected
                    // write cannot leave the UI showing something that never took effect.
                    sendCommand(PacketBuilder.readAnc())
                }
            }

            Commands.RESPONSE_EQ -> {
                val eqPreset = ResponseParser.parseEq(response.payload)
                Log.d(TAG, "EQ Preset: $eqPreset")
                updateState { it.copy(eqPreset = eqPreset) }
            }

            Commands.RESPONSE_FIRMWARE -> {
                val firmware = ResponseParser.parseAsciiString(response.payload)
                    .ifEmpty { ResponseParser.parseFirmware(response.payload) }
                Log.d(TAG, "Firmware: $firmware")
                updateState { it.copy(firmwareVersion = firmware) }
            }

            Commands.RESPONSE_CONFIGURATION -> {
                val configuration = ResponseParser.parseAsciiString(response.payload)
                Log.d(TAG, "Configuration: $configuration")
                updateState { it.copy(configuration = configuration) }
            }

            Commands.RESPONSE_EXTRA_FEATURES -> {
                val inEar = ResponseParser.parseInEarFromExtraFeatures(response.payload)
                Log.d(TAG, "In-Ear Detection: $inEar")
                if (inEar != null) updateState { it.copy(inEarDetection = inEar) }
            }

            Commands.RESPONSE_LOW_LATENCY -> {
                val latency = ResponseParser.parseLatency(response.payload)
                Log.d(TAG, "Low Latency: $latency")
                updateState { it.copy(lowLatencyMode = latency) }
            }

            Commands.RESPONSE_BASS_BOOST -> {
                val bass = ResponseParser.parseBassBoost(response.payload)
                Log.d(TAG, "Bass boost: $bass")
                if (bass != null) {
                    updateState { it.copy(enhancedBass = bass.enabled, bassLevel = bass.level) }
                }
            }

            Commands.RESPONSE_SPATIAL_AUDIO -> {
                val enabled = response.payload.firstOrNull()?.toInt() == 1
                Log.d(TAG, "Spatial audio: $enabled")
                updateState { it.copy(spatialAudio = enabled) }
            }

            Commands.RESPONSE_ADVANCED_EQ_VALUES -> {
                val bands = ResponseParser.parseCustomEq(response.payload)
                Log.d(TAG, "Custom EQ: ${bands.joinToString()}")
                updateState { it.copy(customEq = bands) }
            }

            Commands.RESPONSE_GESTURES -> {
                val gestures = ResponseParser.parseGestures(response.payload)
                Log.d(TAG, "Gestures: ${gestures.joinToString { "side=${it.side} type=${it.type} act=${it.action}" }}")
                updateState { it.copy(gestures = gestures) }
            }

            Commands.RESPONSE_DUAL -> {
                val dual = ResponseParser.parseBoolean(response.payload)
                Log.d(TAG, "Dual device: $dual")
                updateState { it.copy(dualDevice = dual) }
            }

            Commands.RESPONSE_DUAL_DEVICE_LIST -> {
                val devices = ResponseParser.parseDualDeviceList(response.payload)
                Log.d(TAG, "Dual device list: ${devices.joinToString { it.mac }}")
                updateState { it.copy(dualDevices = devices) }
            }

            Commands.RESPONSE_DIRAC_EQ -> {
                val dirac = ResponseParser.parseDiracEq(response.payload)
                Log.d(TAG, "Dirac EQ: preset=$dirac")
                updateState { it.copy(diracEq = dirac) }
            }

            Commands.ACK_SET_DUAL -> {
                Log.d(TAG, "SET_DUAL ack")
                // The earbuds restart after a dual toggle; re-read the list once it is back.
                sendCommand(PacketBuilder.readDualDeviceList())
            }

            Commands.ACK_SET_CONNECT_DEVICE -> {
                Log.d(TAG, "SET_CONNECT_DEVICE ack")
                sendCommand(PacketBuilder.readDualDeviceList())
            }

            Commands.ACK_SET_DIRAC_EQ -> {
                Log.d(TAG, "SET_DIRAC_EQ ack")
                sendCommand(PacketBuilder.readDiracEq())
            }

            Commands.RESPONSE_LHDC -> {
                val lhdc = ResponseParser.parseLhdc(response.payload)
                Log.d(TAG, "LHDC: $lhdc")
                updateState { it.copy(lhdc = lhdc) }
            }

            Commands.RESPONSE_POWER_OFF -> {
                val minutes = ResponseParser.parsePowerOff(response.payload)
                Log.d(TAG, "Auto power off: $minutes min")
                updateState { it.copy(autoPowerOffMinutes = minutes) }
            }

            Commands.RESPONSE_CASE_LED -> {
                val colors = ResponseParser.parseCaseLed(response.payload)
                Log.d(TAG, "Case LED colors: ${colors.size}")
                // Only remember a color when the report actually carried any LEDs.
                if (colors.isNotEmpty()) {
                    updateState { it.copy(caseLedColor = colors.first()) }
                }
            }

            Commands.RESPONSE_DETAIL_ENHANCEMENT -> {
                val detail = ResponseParser.parseDetailEnhancement(response.payload)
                Log.d(TAG, "Detail enhancement: enabled=${detail.enabled} level=${detail.level}")
                updateState {
                    it.copy(detailEnhancement = detail.enabled, detailEnhancementLevel = detail.level)
                }
            }

            Commands.PUSH_EAR_TIP_FIT, Commands.RESPONSE_PUSH_EAR_TIP_FIT -> {
                val fit = ResponseParser.parseFitResult(response.payload)
                if (fit != null) {
                    Log.d(TAG, "Ear-tip fit result: left=${fit.left} right=${fit.right}")
                    updateState {
                        it.copy(fitTestResult = fit)
                    }
                }
            }

            else -> {
                Log.d(TAG, "Unhandled response 0x${response.command.toString(16)}: " +
                        response.payload.toHexString())
            }
        }
    }

    /**
     * Enqueues a packet for the single writer. Non-blocking: callers fire and forget. Writes are
     * serialized and spaced by [COMMAND_GAP_MS] in [startWriteLoop].
     */
    private fun sendCommand(packet: ByteArray) {
        commandChannel.trySend(packet)
    }

    /**
     * Settings that make the earbuds reboot themselves (dual connection, codec changes) play a
     * short tone first so the user hears the change coming, then send the command. The device
     * drops offline briefly while it restarts — that is normal and not an error.
     */
    private fun sendChangeWithTone(buildPacket: () -> ByteArray) {
        playTone()
        sendCommand(buildPacket())
    }

    private fun playTone() {
        try {
            val tone = ToneGenerator(AudioManager.STREAM_MUSIC, 60)
            tone.startTone(ToneGenerator.TONE_PROP_BEEP, REBOOT_TONE_MS.toInt())
            serviceScope.launch {
                delay(REBOOT_TONE_MS + 100)
                tone.release()
            }
        } catch (e: Exception) {
            Log.w(TAG, "Could not play tone: ${e.message}")
        }
    }

    /**
     * The one coroutine allowed to write to the socket. Drains the queue in order, keeping the
     * gap between packets so the earbuds have time to answer and the request/response operation
     * ids stay correlated. Dies with the link on a write error.
     */
    private fun startWriteLoop() {
        writeJob = serviceScope.launch {
            for (packet in commandChannel) {
                if (!BudsRepository.state.value.isConnected) {
                    Log.d(TAG, "Dropping queued command, not connected")
                    continue
                }
                try {
                    Log.d(TAG, "Sending: ${packet.toHexString()}")
                    outputStream?.write(packet)
                    outputStream?.flush()
                } catch (e: IOException) {
                    // A dead socket only surfaced on reads before, so putting an earbud in the case
                    // left the app claiming to be connected until something tried to read.
                    Log.e(TAG, "Send failed, dropping the link: ${e.message}")
                    disconnect()
                    break
                }
                delay(COMMAND_GAP_MS)
            }
        }
    }

    // Public methods for controlling earbuds

    fun setAncMode(mode: AncMode) {
        Log.d(TAG, "Setting ANC mode: $mode")
        sendCommand(PacketBuilder.setAnc(mode))
        // Optimistically update state
        updateState { it.copy(ancMode = mode) }
        updateNotification()
    }

    /** ANC -> Transparency -> Off -> ANC, shared by the notification hub and the QS tile. */
    fun cycleAncMode() {
        val current = BudsRepository.state.value
        setAncMode(
            AncMode.cycle(
                current = current.ancMode,
                hasTransparency = current.deviceModel?.hasTransparency ?: true,
                ancLevel = current.ancLevel
            )
        )
    }

    fun setEqPreset(preset: EqPreset) {
        Log.d(TAG, "Setting EQ preset: $preset")
        sendCommand(PacketBuilder.setEq(preset))
        updateState { it.copy(eqPreset = preset) }
    }

    fun setCustomEq(bands: IntArray) {
        Log.d(TAG, "Setting custom EQ: ${bands.joinToString()}")
        sendCommand(PacketBuilder.setCustomEq(bands))
        updateState { it.copy(customEq = bands, eqPreset = EqPreset.CUSTOM) }
    }

    fun setInEarDetection(enabled: Boolean) {
        Log.d(TAG, "Setting in-ear detection: $enabled")
        sendCommand(PacketBuilder.setInEarDetection(enabled))
        updateState { it.copy(inEarDetection = enabled) }
    }

    /**
     * Assign [action] to a gesture slot. [side] is 2 (left) or 3 (right), [type] is the trigger
     * (double tap, press-and-hold, …). State is updated optimistically so the picker reflects the
     * choice immediately; the next poll reconciles it with what the earbuds actually kept.
     */
    fun setGesture(side: Int, type: Int, action: Int) {
        Log.d(TAG, "Setting gesture: side=$side type=$type action=$action")
        if (side == PacketBuilder.SIDE_CASE) {
            // Case controls live on the case firmware and the case reboots to apply them.
            sendChangeWithTone { PacketBuilder.setGesture(side, type, action) }
        } else {
            sendCommand(PacketBuilder.setGesture(side, type, action))
        }
        updateState { state ->
            val rest = state.gestures.filterNot { it.side == side && it.type == type }
            state.copy(gestures = rest + ResponseParser.GestureSlot(side, type, action))
        }
    }

    fun setDual(enabled: Boolean) {
        Log.d(TAG, "Setting dual device: $enabled")
        sendChangeWithTone { PacketBuilder.setDual(enabled) }
        updateState { it.copy(dualDevice = enabled) }
        Log.d(TAG, "Dual toggle requires the earbuds to reboot; device will drop offline briefly")
    }

    /** Switch which paired device multipoint is actively using. */
    fun setConnectDevice(mac: String) {
        Log.d(TAG, "Switching dual device to $mac")
        sendCommand(PacketBuilder.setConnectDevice(mac.hexToBytes()))
    }

    fun setDiracEq(level: Int) {
        Log.d(TAG, "Setting Dirac EQ: $level")
        sendCommand(PacketBuilder.setDiracEq(level))
        updateState { it.copy(diracEq = level) }
    }

    fun setLhdc(enabled: Boolean) {
        Log.d(TAG, "Setting LHDC: $enabled")
        sendChangeWithTone { PacketBuilder.setLhdc(enabled) }
        updateState { it.copy(lhdc = enabled) }
        Log.d(TAG, "Codec change requires the earbuds to reboot; device will drop offline briefly")
    }

    fun setAutoPowerOff(minutes: Int) {
        Log.d(TAG, "Setting auto power off: $minutes")
        sendCommand(PacketBuilder.setAutoPowerOff(minutes))
        updateState { it.copy(autoPowerOffMinutes = minutes) }
    }

    fun setCaseLedColor(color: Int) {
        Log.d(TAG, "Setting case LED color: #%06x".format(color and 0xFFFFFF))
        sendCommand(PacketBuilder.setCaseLedColor(color))
        updateState { it.copy(caseLedColor = color) }
    }

    fun setDetailEnhancement(enabled: Boolean, level: Int) {
        Log.d(TAG, "Setting detail enhancement: enabled=$enabled level=$level")
        sendCommand(PacketBuilder.setDetailEnhancement(enabled, level))
        updateState { it.copy(detailEnhancement = enabled, detailEnhancementLevel = level) }
    }

    /** Triggers a seal check; the earbuds answer with PUSH_EAR_TIP_FIT. */
    fun startFitTest() {
        Log.d(TAG, "Starting ear-tip fit test")
        sendCommand(PacketBuilder.startFitTest())
        updateState { it.copy(fitTestResult = null) }
    }

    fun setLowLatencyMode(enabled: Boolean) {
        Log.d(TAG, "Setting low latency: $enabled")
        sendCommand(PacketBuilder.setLowLatency(enabled))
        updateState { it.copy(lowLatencyMode = enabled) }
    }

    /**
     * Bass boost is a level, not a switch. Turning it on without a level restores the last one,
     * which is what the official app does.
     *
     * Spatial audio and bass boost are mutually exclusive in firmware: with spatial audio on the
     * earbuds acknowledge a bass write and then ignore it, so spatial audio is switched off first
     * rather than leaving the user with a slider that does nothing.
     */
    fun setBassBoost(enabled: Boolean, level: Int = BudsRepository.state.value.bassLevel) {
        val effectiveLevel = if (enabled && level <= 0) 1 else level
        Log.d(TAG, "Setting bass boost: enabled=$enabled level=$effectiveLevel")

        if (enabled && BudsRepository.state.value.spatialAudio) {
            Log.d(TAG, "Spatial audio blocks bass boost, turning it off first")
            sendCommand(PacketBuilder.setSpatialAudio(false))
            updateState { it.copy(spatialAudio = false) }
        }

        sendCommand(PacketBuilder.setBassBoost(enabled, effectiveLevel))
        updateState { it.copy(enhancedBass = enabled, bassLevel = effectiveLevel) }
    }

    /** Enabling spatial audio drops bass boost, matching what the firmware enforces anyway. */
    fun setSpatialAudio(enabled: Boolean) {
        Log.d(TAG, "Setting spatial audio: $enabled")
        sendCommand(PacketBuilder.setSpatialAudio(enabled))
        updateState { it.copy(spatialAudio = enabled) }

        if (enabled && BudsRepository.state.value.enhancedBass) {
            Log.d(TAG, "Bass boost cannot run alongside spatial audio, turning it off")
            sendCommand(PacketBuilder.setBassBoost(false, BudsRepository.state.value.bassLevel))
            updateState { it.copy(enhancedBass = false) }
        }
    }

    /**
     * Find my earbuds - plays a loud sound.
     * @param side 0 = stop, 1 = left, 2 = right
     * @param play true = start ringing, false = stop
     */
    fun findMyEarbuds(side: Int, play: Boolean = true) {
        Log.d(TAG, "Find my earbuds: side=$side, play=$play")
        if (side == 0 || !play) {
            // Stop both sides; the writer spaces them out.
            sendCommand(PacketBuilder.findDevice(1, false))
            sendCommand(PacketBuilder.findDevice(2, false))
        } else {
            sendCommand(PacketBuilder.findDevice(side, true))
        }
    }

    fun refreshStatus() {
        sendCommand(PacketBuilder.readBattery())
        sendCommand(PacketBuilder.readAnc())
    }

    private fun updateState(update: (EarbudsState) -> EarbudsState) {
        BudsRepository.update(update)
        // Debounce disk persistence: earbud pushes (battery, ANC) arrive frequently, and there is
        // no point writing SharedPreferences for every one of them.
        if (BudsRepository.state.value.isConnected) {
            saveJob?.cancel()
            saveJob = serviceScope.launch {
                delay(STATE_SAVE_DEBOUNCE_MS)
                saveState()
            }
        }
    }

    /**
     * Repositions the hub notification, throttled. A burst of responses (battery + ANC pushes at
     * init, or a mode change) would otherwise rebuild the RemoteViews once per packet; this
     * coalesces them to one immediate publish plus at most one trailing publish per window.
     */
    private fun updateNotification() {
        if (notifThrottleJob?.isActive == true) {
            notifPending = true
            return
        }
        publishNotification()
        notifThrottleJob = serviceScope.launch {
            delay(NOTIF_THROTTLE_MS)
            if (notifPending) {
                notifPending = false
                publishNotification()
            }
        }
    }

    private fun publishNotification() {
        val notification = notificationHelper.createNotification(BudsRepository.state.value)
        notificationHelper.updateNotification(NOTIFICATION_ID, notification)
    }

    private fun hasBluetoothPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) ==
                    PackageManager.PERMISSION_GRANTED
        } else {
            true
        }
    }

    private fun saveLastDevice(address: String) {
        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("last_device_address", address).apply()
    }

    /**
     * Save current state to SharedPreferences for persistence across app restarts.
     */
    private fun saveState() {
        val state = BudsRepository.state.value
        if (!state.isConnected) return

        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        prefs.edit().apply {
            putString("last_device_name", state.deviceName)
            putString("last_device_model_id", state.deviceModel?.id)
            putInt("last_anc_mode", state.ancMode.ordinal)
            putInt("last_eq_preset", state.eqPreset.ordinal)
            putBoolean("last_in_ear", state.inEarDetection)
            putBoolean("last_low_latency", state.lowLatencyMode)
            putBoolean("last_enhanced_bass", state.enhancedBass)
            putBoolean("last_dual", state.dualDevice)
            putBoolean("last_lhdc", state.lhdc)
            putInt("last_dirac_eq", state.diracEq)
            putInt("last_auto_power_off", state.autoPowerOffMinutes)
            putBoolean("last_detail_enhancement", state.detailEnhancement)
            putInt("last_detail_enhancement_level", state.detailEnhancementLevel)
            putInt("last_battery_left", state.battery.left)
            putInt("last_battery_right", state.battery.right)
            putInt("last_battery_case", state.battery.case)
            apply()
        }
        Log.d(TAG, "State saved: ANC=${state.ancMode}, EQ=${state.eqPreset}")
    }

    /**
     * Load saved state from SharedPreferences.
     * Used to show last known state while reconnecting.
     */
    private fun loadSavedState(): EarbudsState? {
        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        val deviceName = prefs.getString("last_device_name", null) ?: return null
        val modelId = prefs.getString("last_device_model_id", null)

        val deviceModel = if (modelId != null) {
            DeviceModels.ALL_MODELS.find { it.id == modelId }
        } else null

        val ancOrdinal = prefs.getInt("last_anc_mode", 0)
        val eqOrdinal = prefs.getInt("last_eq_preset", 0)

        return EarbudsState(
            isConnected = false,  // Will be set to true when actually connected
            deviceName = deviceName,
            deviceModel = deviceModel,
            ancMode = AncMode.entries.getOrElse(ancOrdinal) { AncMode.OFF },
            eqPreset = EqPreset.entries.getOrElse(eqOrdinal) { EqPreset.BALANCED },
            inEarDetection = prefs.getBoolean("last_in_ear", true),
            lowLatencyMode = prefs.getBoolean("last_low_latency", false),
            enhancedBass = prefs.getBoolean("last_enhanced_bass", false),
            dualDevice = prefs.getBoolean("last_dual", false),
            lhdc = prefs.getBoolean("last_lhdc", false),
            diracEq = prefs.getInt("last_dirac_eq", 0),
            autoPowerOffMinutes = prefs.getInt("last_auto_power_off", 0),
            detailEnhancement = prefs.getBoolean("last_detail_enhancement", false),
            detailEnhancementLevel = prefs.getInt("last_detail_enhancement_level", 1),
            battery = ResponseParser.BatteryStatus(
                left = prefs.getInt("last_battery_left", -1),
                right = prefs.getInt("last_battery_right", -1),
                case = prefs.getInt("last_battery_case", -1)
            )
        )
    }

    fun getConnectedDevices(): Set<String> {
        if (!hasBluetoothPermission()) return emptySet()

        return a2dpProfile?.connectedDevices
            ?.filter { isNothingDevice(it) }
            ?.map { it.address }
            ?.toSet()
            ?: emptySet()
    }

    fun getPairedDevices(): List<BluetoothDevice> {
        if (!hasBluetoothPermission()) return emptyList()

        val bluetoothManager = getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        val bluetoothAdapter = bluetoothManager.adapter ?: return emptyList()

        return bluetoothAdapter.bondedDevices
            .filter { device -> isNothingDevice(device) }
            .toList()
    }

    private fun ByteArray.toHexString(): String {
        return joinToString("") { "%02x".format(it) }
    }

    private fun String.hexToBytes(): ByteArray {
        val clean = filter { !it.isWhitespace() }
        if (clean.isEmpty()) return ByteArray(0)
        return clean.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
    }
}
