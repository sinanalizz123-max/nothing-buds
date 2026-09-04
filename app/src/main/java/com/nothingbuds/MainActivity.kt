package com.nothingbuds

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import com.nothingbuds.entities.Wire
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.nothingbuds.ui.theme.MyApplicationTheme

private val Bg = Color(0xFF21201F)
private val Card = Color(0xFF1B1D1F)
private val Accent = Color(0xFFE82525)
private val Muted = Color(0xFF9CA3AF)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme(darkTheme = true, dynamicColor = false) {
                Surface(modifier = Modifier.fillMaxSize(), color = Bg) {
                    NothingBudsApp()
                }
            }
        }
    }
}

@SuppressLint("InlinedApi", "MissingPermission")
@Composable
fun NothingBudsApp() {
    val context = LocalContext.current
    val viewModel: MainViewModel = viewModel()

    val connected by viewModel.connected.collectAsStateWithLifecycle()
    val isScanning by viewModel.isScanning.collectAsStateWithLifecycle()
    val bluetoothEnabled by viewModel.bluetoothEnabled.collectAsStateWithLifecycle()
    val scannedDevices by viewModel.scannedDevices.collectAsStateWithLifecycle()
    val bondedDevices by viewModel.bondedDevices.collectAsStateWithLifecycle()
    val deviceInfo by viewModel.deviceInfo.collectAsStateWithLifecycle()

    val requiredPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        listOf(Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT)
    } else {
        listOf(Manifest.permission.BLUETOOTH, Manifest.permission.BLUETOOTH_ADMIN)
    }

    var hasPermissions by remember {
        mutableStateOf(requiredPermissions.all {
            ContextCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
        })
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { results ->
        hasPermissions = results.values.all { it }
        if (hasPermissions) {
            viewModel.refreshBondedDevices()
            viewModel.startScan()
        } else {
            Toast.makeText(context, "Bluetooth permission is required", Toast.LENGTH_LONG).show()
        }
    }

    val enableBluetooth = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }

    // Ask for permission on first open.
    LaunchedEffect(Unit) {
        if (!hasPermissions) {
            permissionLauncher.launch(requiredPermissions.toTypedArray())
        }
    }

    Scaffold(containerColor = Bg) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Nothing Buds", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace)
            Spacer(Modifier.height(4.dp))
            Text(
                if (connected) "Connected to ${deviceInfo.model.ifEmpty { "buds" }}" else "Not connected",
                color = if (connected) Color(0xFF4CD964) else Accent,
                fontSize = 13.sp
            )
            Spacer(Modifier.height(16.dp))

            when {
                connected -> ControlScreen(viewModel, deviceInfo)
                !hasPermissions -> CenterText("Grant Bluetooth permission to continue")
                !bluetoothEnabled -> EnableBluetoothScreen(onEnableBluetooth = {
                    enableBluetooth.launch(Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE))
                })
                else -> ConnectScreen(
                    isScanning = isScanning,
                    devices = scannedDevices,
                    bondedDevices = bondedDevices,
                    onScan = viewModel::startScan,
                    onStopScan = viewModel::stopScan,
                    onConnect = viewModel::connect
                )
            }
        }
    }
}

@Composable
private fun CenterText(text: String) {
    Spacer(Modifier.height(60.dp))
    Text(text, color = Muted, fontSize = 14.sp, textAlign = TextAlign.Center)
}

@Composable
private fun EnableBluetoothScreen(onEnableBluetooth: () -> Unit) {
    Spacer(Modifier.height(60.dp))
    Text("Bluetooth is off", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    Spacer(Modifier.height(10.dp))
    Button(
        onClick = onEnableBluetooth,
        colors = ButtonDefaults.buttonColors(containerColor = Accent, contentColor = Color.White),
        shape = RoundedCornerShape(50)
    ) {
        Text("Enable Bluetooth", fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun ConnectScreen(
    isScanning: Boolean,
    devices: List<BluetoothDevice>,
    bondedDevices: List<BluetoothDevice>,
    onScan: () -> Unit,
    onStopScan: () -> Unit,
    onConnect: (BluetoothDevice) -> Unit
) {
    Spacer(Modifier.height(24.dp))
    Text("Connect your buds", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    Spacer(Modifier.height(8.dp))
    Text("Put the buds out of the case, close to this phone", color = Muted, fontSize = 13.sp, textAlign = TextAlign.Center)
    Spacer(Modifier.height(20.dp))

    Button(
        onClick = { if (isScanning) onStopScan() else onScan() },
        colors = ButtonDefaults.buttonColors(containerColor = Accent, contentColor = Color.White),
        shape = RoundedCornerShape(50),
        contentPadding = PaddingValues(horizontal = 40.dp, vertical = 12.dp),
        enabled = !isScanning
    ) {
        if (isScanning) {
            CircularProgressIndicator(color = Color.White, strokeWidth = 2.dp, modifier = Modifier.size(18.dp))
            Spacer(Modifier.width(10.dp))
            Text("Scanning…", fontWeight = FontWeight.Bold)
        } else {
            Text("Scan for devices", fontWeight = FontWeight.Bold)
        }
    }
    Spacer(Modifier.height(20.dp))

    val all = remember(bondedDevices, devices) {
        val seen = linkedSetOf<String>()
        (bondedDevices + devices).filter { it.address != null && seen.add(it.address) }
    }

    if (all.isEmpty()) {
        Text(
            if (isScanning) "Searching…" else "No devices found",
            color = Muted,
            fontSize = 13.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    } else {
        Text("DEVICES", color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        all.forEach { device ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Card)
                    .clickable { onConnect(device) }
                    .padding(14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(device.name ?: "Unknown", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Medium)
                    Text(device.address, color = Muted, fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                }
                Text("Connect →", color = Accent, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.height(8.dp))
        }
    }
}

@Composable
private fun ControlScreen(viewModel: MainViewModel, deviceInfo: DeviceInfo) {
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        BatteryCard(deviceInfo)
        AncCard(deviceInfo, setAnc = viewModel::setAnc)
        EqCard(setEq = viewModel::setEqPreset)
        LatencyCard(deviceInfo, setLatency = viewModel::setLowLatency)
        FindCard(viewModel)
        DeviceCard(deviceInfo)

        Button(
            onClick = viewModel::disconnect,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7F1D1D), contentColor = Color.White),
            shape = RoundedCornerShape(50),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Disconnect", fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
private fun CardBox(content: @Composable ColumnScope.() -> Unit) {
    androidx.compose.material3.Card(
        colors = androidx.compose.material3.CardDefaults.cardColors(containerColor = Card),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth()
    ) { Column(Modifier.padding(14.dp), content = content) }
}

@Composable
private fun Row2(title: String, value: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(title, color = Muted, fontSize = 13.sp)
        Text(value, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun BatteryCard(info: DeviceInfo) {
    CardBox {
        Text("BATTERY", color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(10.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            Bud(pct = info.batteryLeft, label = "Left")
            Bud(pct = info.batteryRight, label = "Right")
        }
        Spacer(Modifier.height(10.dp))
        Row2("Case", if (info.batteryCase in 0..100) "${info.batteryCase}%" else "—")
    }
}

@Composable
private fun Bud(pct: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(if (pct in 0..100) "$pct%" else "—", color = Color.White, fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Text(label, color = Muted, fontSize = 11.sp)
    }
}

@Composable
private fun AncCard(info: DeviceInfo, setAnc: (Int) -> Unit) {
    CardBox {
        Text("NOISE CONTROL", color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Off" to Wire.ANC_OFF, "Transparency" to Wire.ANC_TRANSPARENCY, "Noise cancelling" to Wire.ANC_HIGH)
                .forEach { (label, mode) ->
                    val active = when (mode) {
                        Wire.ANC_OFF -> info.ancMode == Wire.ANC_OFF
                        Wire.ANC_TRANSPARENCY -> info.ancMode == Wire.ANC_TRANSPARENCY
                        else -> info.ancMode == Wire.ANC_HIGH || info.ancMode == Wire.ANC_MID ||
                            info.ancMode == Wire.ANC_LOW || info.ancMode == Wire.ANC_ADAPTIVE
                    }
                    Pill(label, active, onClick = { setAnc(mode) }, modifier = Modifier.weight(1f))
                }
        }
    }
}

@Composable
private fun EqCard(setEq: (Int) -> Unit) {
    CardBox {
        Text("EQUALIZER", color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf("Balanced" to 0, "More Bass" to 3, "More Treble" to 2, "Voice" to 1)
                .forEach { (label, value) -> Pill(label, false, onClick = { setEq(value) }, modifier = Modifier.weight(1f)) }
        }
    }
}

@Composable
private fun LatencyCard(info: DeviceInfo, setLatency: (Boolean) -> Unit) {
    CardBox {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Low latency (game mode)", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Medium)
            Switch(
                checked = info.lowLatency,
                onCheckedChange = setLatency,
                colors = SwitchDefaults.colors(checkedThumbColor = Color.White, checkedTrackColor = Color(0xFF7F1D1D))
            )
        }
    }
}

@Composable
private fun FindCard(viewModel: MainViewModel) {
    CardBox {
        Text("FIND MY BUDS", color = Muted, fontSize = 11.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(12.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Pill("Ring Left", false, onClick = { viewModel.findLeft(true) }, modifier = Modifier.weight(1f))
            Pill("Ring Right", false, onClick = { viewModel.findRight(true) }, modifier = Modifier.weight(1f))
            Pill("Stop", false, onClick = viewModel::findStop, modifier = Modifier.weight(1f))
        }
    }
}

@Composable
private fun DeviceCard(info: DeviceInfo) {
    CardBox {
        Row2("Model", info.model.ifEmpty { "Unknown" })
        Spacer(Modifier.height(6.dp))
        Row2("Firmware", info.firmware.ifEmpty { "—" })
        Spacer(Modifier.height(6.dp))
        Row2("Product ID", info.pid.ifEmpty { "—" })
    }
}

@Composable
private fun Pill(label: String, active: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier) {
    androidx.compose.material3.Surface(
        color = if (active) Color.White else Color.Black,
        shape = RoundedCornerShape(50),
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .clickable(onClick = onClick)
    ) {
        Text(
            label,
            color = if (active) Color.Black else Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 9.dp)
                .fillMaxWidth()
        )
    }
}
