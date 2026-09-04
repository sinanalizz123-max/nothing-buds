package com.nothingbuds.ble

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.bluetooth.BluetoothSocket
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import androidx.core.content.ContextCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.UUID

interface DeviceScanCallback {
    fun onDeviceFound(device: BluetoothDevice)
    fun onScanStopped() = Unit
    fun onScanFailed(errorCode: Int) = Unit
}

/**
 * Bluetooth classic SPP transport for Nothing / CMF earbuds.
 *
 * Uses the same transport as the independent, working `ear-web` implementation:
 * an RFCOMM/SPP socket on UUID AEAC4A03-DFF5-498F-843A-34487CF133EB carrying the raw
 * Nothing frame stream. Classic discovery (`startDiscovery`) does NOT require the
 * location permission that BLE scanning needs.
 */
@SuppressLint("MissingPermission")
class BleManager(context: Context) {
    private val appContext = context.applicationContext
    private val tag = "BleManager"
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    private val bluetoothAdapter: BluetoothAdapter? =
        (appContext.getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager).adapter

    private val sppUuid = UUID.fromString("aeac4a03-dff5-498f-843a-34487cf133eb")

    private var socket: BluetoothSocket? = null
    private var inputStream: InputStream? = null
    private var outputStream: OutputStream? = null
    private var scanReceiver: BluetoothDiscoverCallback? = null

    private val _receivedPackets = MutableSharedFlow<ByteArray>(extraBufferCapacity = 4)
    val receivedPackets: SharedFlow<ByteArray> = _receivedPackets

    private val _connectionState = MutableSharedFlow<Boolean>(extraBufferCapacity = 1)
    val connectionState: SharedFlow<Boolean> = _connectionState

    private val _bluetoothEnabled = MutableStateFlow(runCatching { bluetoothAdapter?.isEnabled == true }.getOrDefault(false))
    val bluetoothEnabled: StateFlow<Boolean> = _bluetoothEnabled

    private val _isScanning = MutableStateFlow(false)
    val isScanning: StateFlow<Boolean> = _isScanning

    private val writeChannel = Channel<ByteArray>(Channel.UNLIMITED)
    private val readBuffer = ByteArrayOutputStream()

    private var receiverRegistered = false

    private val bluetoothStateReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (BluetoothAdapter.ACTION_STATE_CHANGED != intent.action) return
            val state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, BluetoothAdapter.ERROR)
            _bluetoothEnabled.value = state == BluetoothAdapter.STATE_ON
            if (state == BluetoothAdapter.STATE_OFF) {
                stopScan()
                disconnect()
                _connectionState.tryEmit(false)
            }
        }
    }

    init {
        ContextCompat.registerReceiver(
            appContext,
            bluetoothStateReceiver,
            IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED),
            ContextCompat.RECEIVER_EXPORTED
        )
        receiverRegistered = true

        // Serialize outbound writes on a single writer coroutine.
        scope.launch {
            for (packet in writeChannel) {
                val out = outputStream
                if (out == null) {
                    log("Dropping packet because SPP is not connected")
                    continue
                }
                try {
                    out.write(packet)
                    out.flush()
                } catch (e: Exception) {
                    log("Write failed: ${e.message}")
                }
                delay(40)
            }
        }
    }

    fun startScan(callback: DeviceScanCallback) {
        val adapter = bluetoothAdapter
        if (adapter == null || !runCatching { adapter.isEnabled }.getOrDefault(false)) {
            callback.onScanFailed(SCAN_ERROR_BLUETOOTH_DISABLED)
            return
        }
        runCatching { if (adapter.isDiscovering) adapter.cancelDiscovery() }
        val receiver = BluetoothDiscoverCallback(callback)
        scanReceiver = receiver
        ContextCompat.registerReceiver(
            appContext,
            receiver,
            IntentFilter(BluetoothDevice.ACTION_FOUND),
            ContextCompat.RECEIVER_EXPORTED
        )
        ContextCompat.registerReceiver(
            appContext,
            receiver,
            IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED),
            ContextCompat.RECEIVER_EXPORTED
        )
        if (!adapter.startDiscovery()) {
            unregisterScanReceiver()
            _isScanning.value = false
            callback.onScanFailed(SCAN_ERROR_DISCOVERY_FAILED)
        } else {
            _isScanning.value = true
        }
    }

    private inner class BluetoothDiscoverCallback(
        private val callback: DeviceScanCallback
    ) : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            when (intent.action) {
                BluetoothDevice.ACTION_FOUND -> {
                    val device: BluetoothDevice? =
                        intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                    device?.let(callback::onDeviceFound)
                }
                BluetoothAdapter.ACTION_DISCOVERY_FINISHED -> {
                    _isScanning.value = false
                    callback.onScanStopped()
                }
            }
        }
    }

    fun stopScan() {
        runCatching { bluetoothAdapter?.cancelDiscovery() }
        unregisterScanReceiver()
        _isScanning.value = false
    }

    fun isBluetoothEnabled(): Boolean =
        runCatching { bluetoothAdapter?.isEnabled == true }.getOrDefault(false)

    val pairedDevices: List<BluetoothDevice>
        get() = runCatching {
            bluetoothAdapter?.bondedDevices?.filter { it.type == BluetoothDevice.DEVICE_TYPE_CLASSIC }
                ?: emptyList()
        }.getOrDefault(emptyList())

    private fun unregisterScanReceiver() {
        val receiver = scanReceiver
        scanReceiver = null
        if (receiver != null) {
            runCatching { appContext.unregisterReceiver(receiver) }.onFailure { }
        }
    }

    fun connect(device: BluetoothDevice) {
        disconnect()
        scope.launch {
            runCatching { bluetoothAdapter?.cancelDiscovery() }
            _connectionState.tryEmit(false)
            var sock: BluetoothSocket? = null
            try {
                sock = device.createRfcommSocketToServiceRecord(sppUuid)
                socket = sock
                sock.connect()
                inputStream = sock.inputStream
                outputStream = sock.outputStream
                _connectionState.tryEmit(true)
                val buf = ByteArray(4096)
                while (true) {
                    val n = inputStream?.read(buf) ?: -1
                    if (n <= 0) break
                    handleIncoming(buf.copyOfRange(0, n))
                }
            } catch (e: Exception) {
                log("SPP connect/read failed: ${e.message}")
            } finally {
                socket = null
                inputStream = null
                outputStream = null
                if (sock != null) {
                    runCatching { sock.close() }
                }
                _connectionState.tryEmit(false)
            }
        }
    }

    fun sendPacket(data: ByteArray) {
        if (!writeChannel.trySend(data.copyOf()).isSuccess) {
            log("Failed to queue packet")
        }
    }

    fun disconnect() {
        runCatching { bluetoothAdapter?.cancelDiscovery() }
        stopScan()
        val sock = socket
        socket = null
        inputStream = null
        outputStream = null
        synchronized(readBuffer) { readBuffer.reset() }
        if (sock != null) {
            runCatching { sock.close() }
        }
        _connectionState.tryEmit(false)
    }

    fun close() {
        stopScan()
        disconnect()
        writeChannel.close()
        scope.cancel()
        if (receiverRegistered) {
            runCatching { appContext.unregisterReceiver(bluetoothStateReceiver) }.onFailure { }
            receiverRegistered = false
        }
    }

    /**
     * Reassemble the raw byte stream into complete protocol frames.
     * Frame header (8 bytes): [0x55, ctrl(2), cmdLE(2), lenLE(2), seq].
     * len(bytes 5-6 LE) = payload length; crc flag = control & 0x20.
     */
    private fun handleIncoming(data: ByteArray) {
        if (data.isEmpty()) return
        val packets = mutableListOf<ByteArray>()
        synchronized(readBuffer) {
            readBuffer.write(data)
            val raw = readBuffer.toByteArray()
            readBuffer.reset()

            var offset = 0
            while (offset < raw.size) {
                while (offset < raw.size && raw[offset] != SOF.toByte()) offset++
                if (raw.size - offset < HEADER_SIZE) break

                val payloadLength =
                    (raw[offset + 5].toInt() and 0xFF) or
                        ((raw[offset + 6].toInt() and 0xFF) shl 8)
                val hasCrc = (raw[offset + 1].toInt() and CRC_FLAG) != 0
                val totalLength = HEADER_SIZE + payloadLength + if (hasCrc) CRC_SIZE else 0

                if (raw.size - offset < totalLength) break
                packets += raw.copyOfRange(offset, offset + totalLength)
                offset += totalLength
            }

            if (offset < raw.size) readBuffer.write(raw, offset, raw.size - offset)
        }
        packets.forEach { packet ->
            if (!_receivedPackets.tryEmit(packet)) {
                log("Dropped received packet because the event buffer is full")
            }
        }
    }

    private fun log(message: String) {
        Log.d(tag, message)
    }

    private companion object {
        const val HEADER_SIZE = 8
        const val CRC_SIZE = 2
        const val CRC_FLAG = 0x20
        const val SOF = 0x55
        const val SCAN_ERROR_BLUETOOTH_DISABLED = -1
        const val SCAN_ERROR_DISCOVERY_FAILED = -2
    }
}
