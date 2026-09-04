package com.nothingbuds

import android.annotation.SuppressLint
import android.app.Application
import android.bluetooth.BluetoothDevice
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.nothingbuds.ble.BleManager
import com.nothingbuds.ble.DeviceScanCallback
import com.nothingbuds.model.ModelCapabilities
import com.nothingbuds.model.ModelDatabase
import com.nothingbuds.protocol.CommandRegistry
import com.nothingbuds.protocol.PacketParser
import com.nothingbuds.entities.Anc
import com.nothingbuds.entities.BatteryStatus
import com.nothingbuds.entities.Firmware
import com.nothingbuds.entities.Latency
import com.nothingbuds.entities.Wire
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class DeviceInfo(
    val model: String = "",
    val pid: String = "",
    val firmware: String = "",
    val batteryLeft: Int = -1,
    val batteryRight: Int = -1,
    val batteryCase: Int = -1,
    val ancMode: Int = -1,
    val lowLatency: Boolean = false
)

@SuppressLint("MissingPermission")
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val bleManager = BleManager(application)

    private val _deviceInfo = MutableStateFlow(DeviceInfo())
    val deviceInfo: StateFlow<DeviceInfo> = _deviceInfo

    private val _scannedDevices = MutableStateFlow<List<BluetoothDevice>>(emptyList())
    val scannedDevices: StateFlow<List<BluetoothDevice>> = _scannedDevices

    private val _isScanning = MutableStateFlow(false)
    val isScanning: StateFlow<Boolean> = _isScanning

    private val _connected = MutableStateFlow(false)
    val connected: StateFlow<Boolean> = _connected

    private val _bluetoothEnabled = MutableStateFlow(bleManager.isBluetoothEnabled())
    val bluetoothEnabled: StateFlow<Boolean> = _bluetoothEnabled

    private val _bondedDevices = MutableStateFlow(bleManager.pairedDevices)
    val bondedDevices: StateFlow<List<BluetoothDevice>> = _bondedDevices

    private val deviceMap = mutableMapOf<String, BluetoothDevice>()

    private val _caps = MutableStateFlow(ModelCapabilities(pid = "?", name = "Unknown"))
    val caps: StateFlow<ModelCapabilities> = _caps

    init {
        viewModelScope.launch {
            bleManager.connectionState.collect { isConnected ->
                _connected.value = isConnected
                if (isConnected) refreshAll()
            }
        }
        viewModelScope.launch {
            bleManager.bluetoothEnabled.collect { enabled ->
                _bluetoothEnabled.value = enabled
                if (enabled) _bondedDevices.value = bleManager.pairedDevices
            }
        }
        viewModelScope.launch {
            bleManager.isScanning.collect { s -> _isScanning.value = s }
        }
        viewModelScope.launch {
            bleManager.receivedPackets.collect { raw -> handlePacket(raw) }
        }
    }

    private fun refreshAll() {
        requestDeviceModel()
        requestFirmware()
        requestBattery()
        requestAncMode()
        requestLowLatency()
    }

    private fun applyCapabilities(model: String) {
        val pid = ModelDatabase.pidFromName(model) ?: _deviceInfo.value.pid
        _caps.value = ModelDatabase.forPid(pid)
        _deviceInfo.update { it.copy(model = model, pid = pid) }
    }

    fun refreshBondedDevices() {
        _bondedDevices.value = bleManager.pairedDevices
    }

    fun startScan() {
        deviceMap.clear()
        _scannedDevices.value = emptyList()
        _isScanning.value = true
        bleManager.startScan(object : DeviceScanCallback {
            override fun onDeviceFound(device: BluetoothDevice) {
                val address = device.address ?: return
                synchronized(deviceMap) {
                    deviceMap[address] = device
                    _scannedDevices.value = deviceMap.values.toList()
                }
            }
            override fun onScanStopped() { _isScanning.value = false }
            override fun onScanFailed(errorCode: Int) {
                _isScanning.value = false
            }
        })
    }

    fun stopScan() {
        bleManager.stopScan()
        _isScanning.value = false
    }

    fun connect(device: BluetoothDevice) {
        stopScan()
        bleManager.connect(device)
    }

    fun disconnect() {
        bleManager.disconnect()
        _connected.value = false
        _deviceInfo.value = DeviceInfo()
    }

    fun sendCommand(command: Int, payload: ByteArray) {
        val packet = com.nothingbuds.protocol.PacketBuilder.build(command, payload)
        bleManager.sendPacket(packet)
    }

    fun requestDeviceModel() = sendCommand(CommandRegistry.GET_DEVICE_MODEL, byteArrayOf())
    fun requestFirmware() = sendCommand(CommandRegistry.GET_HOST_VERSION_DEVICE, byteArrayOf())
    fun requestBattery() = sendCommand(CommandRegistry.GET_BATTERY_LEVEL, byteArrayOf())
    fun requestAncMode() = sendCommand(CommandRegistry.GET_CURRENT_NOISE_RED, byteArrayOf(1))
    fun requestLowLatency() = sendCommand(CommandRegistry.GET_HOST_LAG_MODE, byteArrayOf())

    fun setAnc(wireMode: Int) =
        sendCommand(CommandRegistry.SET_CURRENT_NOISE_RED, Anc.setPayload(wireMode))

    fun setEqPreset(level: Int) =
        sendCommand(CommandRegistry.SET_EQ_MODE, com.nothingbuds.entities.Eq.setPresetPayload(level))

    fun setLowLatency(on: Boolean) =
        sendCommand(CommandRegistry.SET_LAG_MODE, Latency.setPayload(on))

    fun findLeft(on: Boolean) = ring(com.nothingbuds.entities.FindEar.LEFT, on)
    fun findRight(on: Boolean) = ring(com.nothingbuds.entities.FindEar.RIGHT, on)
    fun findStop() = sendCommand(
        CommandRegistry.SET_WHERE_AM_I,
        com.nothingbuds.entities.FindEar.stopPayload(_deviceInfo.value.pid == "B181")
    )
    private fun ring(side: Int, on: Boolean) =
        sendCommand(
            CommandRegistry.SET_WHERE_AM_I,
            com.nothingbuds.entities.FindEar.ringPayload(_deviceInfo.value.pid == "B181", side, on)
        )

    @Suppress("UNUSED_PARAMETER")
    fun setEqFromPreset(level: Int) = setEqPreset(level)

    private fun handlePacket(raw: ByteArray) {
        val packet = PacketParser.parse(raw) ?: return
        val payload = packet.payload
        when (packet.command) {
            CommandRegistry.GET_DEVICE_MODEL -> {
                val model = String(payload).trim()
                applyCapabilities(model)
            }
            CommandRegistry.GET_HOST_VERSION_DEVICE -> {
                Firmware.parse(payload)?.let { _deviceInfo.update { d -> d.copy(firmware = it) } }
            }
            CommandRegistry.EVENT_BATTERY_CHANGED,
            CommandRegistry.GET_BATTERY_LEVEL -> {
                val b = BatteryStatus.parse(payload)
                _deviceInfo.update {
                    it.copy(batteryLeft = b.leftPercent, batteryRight = b.rightPercent, batteryCase = b.casePercent)
                }
            }
            CommandRegistry.GET_CURRENT_NOISE_RED,
            CommandRegistry.EVENT_NOISE_RED_LEVEL_CHG -> {
                Anc.parseCurrentMode(payload)?.let { mode ->
                    _deviceInfo.update { it.copy(ancMode = mode) }
                }
            }
            CommandRegistry.GET_HOST_LAG_MODE,
            CommandRegistry.EVENT_GAME_MODE_CHANGED -> {
                val on = payload.firstOrNull()?.toInt() == 1
                _deviceInfo.update { it.copy(lowLatency = on) }
            }
            CommandRegistry.GET_ADAPTIVE_EQ_MODE,
            CommandRegistry.GET_EQ_MODE -> {
                // EQ preset state tracked implicitly; nothing to store in the simple UI.
            }
            else -> { /* unhandled */ }
        }
    }

    override fun onCleared() {
        bleManager.close()
        super.onCleared()
    }
}
