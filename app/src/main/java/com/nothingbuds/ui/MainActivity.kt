package com.nothingbuds.ui

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nothingbuds.calibration.NotificationPermission
import com.nothingbuds.data.BudsRepository
import com.nothingbuds.service.BudsService
import com.nothingbuds.ui.screens.CalibrationScreen
import com.nothingbuds.ui.screens.DeviceListScreen
import com.nothingbuds.ui.screens.EQScreen
import com.nothingbuds.ui.screens.ExtrasScreen
import com.nothingbuds.ui.screens.GestureScreen
import com.nothingbuds.ui.screens.HomeScreen
import com.nothingbuds.ui.screens.SettingsScreen
import com.nothingbuds.ui.theme.NothingEarbudsTheme

class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private var budsService: BudsService? = null
    private var isBound by mutableStateOf(false)

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            Log.d(TAG, "Service connected")
            val localBinder = binder as? BudsService.LocalBinder
            budsService = localBinder?.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(TAG, "Service disconnected")
            budsService = null
            isBound = false
        }
    }

    private val permissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        // Bluetooth is independent of notifications: only BLUETOOTH_CONNECT decides whether the
        // service can run. A denied POST_NOTIFICATIONS must not block earbud functionality.
        val btGranted = permissions[Manifest.permission.BLUETOOTH_CONNECT]
            ?: hasBluetoothConnectPermission()
        Log.d(TAG, "Bluetooth CONNECT granted=$btGranted")
        if (btGranted) {
            startAndBindService()
        }
    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        Log.d(TAG, "POST_NOTIFICATIONS granted=$granted")
        getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
            .edit().putBoolean(NotificationPermission.PREF_ASKED, true).apply()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")

        requestPermissions()

        setContent {
            NothingEarbudsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    // One source of truth — the service writes into it whether we are bound or not.
                    val state by BudsRepository.state.collectAsState()

                    NavHost(
                        navController = navController,
                        startDestination = "home"
                    ) {
                        composable("home") {
                            HomeScreen(
                                state = state,
                                onNavigateToDevices = { navController.navigate("devices") },
                                onNavigateToEQ = {
                                    if (state.isConnected) {
                                        navController.navigate("eq")
                                    }
                                },
                                onNavigateToSettings = { navController.navigate("settings") },
                                onNavigateToExtras = { navController.navigate("extras") },
                                onSetAncMode = { mode -> budsService?.setAncMode(mode) },
                                onToggleInEar = { enabled -> budsService?.setInEarDetection(enabled) },
                                onToggleLowLatency = { enabled -> budsService?.setLowLatencyMode(enabled) },
                                onSetBassBoost = { enabled, level ->
                                    budsService?.setBassBoost(enabled, level)
                                },
                                onToggleSpatialAudio = { enabled ->
                                    budsService?.setSpatialAudio(enabled)
                                },
                                onToggleLhdc = { enabled -> budsService?.setLhdc(enabled) },
                                onToggleDual = { enabled -> budsService?.setDual(enabled) },
                                onSetDetailEnhancement = { enabled, level ->
                                    budsService?.setDetailEnhancement(enabled, level)
                                },
                                onFindMyEarbuds = { side, play -> budsService?.findMyEarbuds(side, play) },
                                onDisconnect = { budsService?.disconnect() }
                            )
                        }

                        composable("devices") {
                            val pairedDevices = remember(isBound) {
                                budsService?.getPairedDevices() ?: emptyList()
                            }
                            val connectedAdapters = remember(isBound, state.isConnected) {
                                budsService?.getConnectedDevices() ?: emptySet()
                            }

                            DeviceListScreen(
                                pairedDevices = pairedDevices,
                                currentState = state,
                                connectedAdapters = connectedAdapters,
                                onDeviceSelected = { device ->
                                    Log.d(TAG, "Device selected: ${device.name}")
                                    budsService?.connect(device.address)
                                    saveLastDevice(device.address)
                                    navController.popBackStack()
                                },
                                onBack = { navController.popBackStack() }
                            )
                        }

                        composable("eq") {
                            EQScreen(
                                state = state,
                                onSetPreset = { preset -> budsService?.setEqPreset(preset) },
                                onSetDiracEq = { level -> budsService?.setDiracEq(level) },
                                onSetDiracCustomEq = { bass, mid, treble -> budsService?.setDiracCustomEq(bass, mid, treble) },
                                onSetCustomEq = { bands -> budsService?.setCustomEq(bands) },
                                onApplyMyEq = { budsService?.applyMyEq() },
                                onBack = { navController.popBackStack() }
                            )
                        }

                        composable("calibration") {
                            CalibrationScreen(
                                state = state,
                                onSetAncMode = { mode -> budsService?.setAncMode(mode) },
                                onSetDiracCustomEq = { bass, mid, treble -> budsService?.setDiracCustomEq(bass, mid, treble) },
                                onSaveMyEq = { bass, mid, treble -> budsService?.saveMyEq(bass, mid, treble) },
                                onApplyMyEq = { budsService?.applyMyEq() },
                                onBack = { navController.popBackStack() }
                            )
                        }

                        composable("settings") {
                            SettingsScreen(
                                onBack = { navController.popBackStack() }
                            )
                        }

                        composable("extras") {
                            ExtrasScreen(
                                state = state,
                                onBack = { navController.popBackStack() },
                                onNavigateToGestures = { navController.navigate("gestures") },
                                onSetConnectDevice = { mac -> budsService?.setConnectDevice(mac) },
                                onSetAutoPowerOff = { minutes -> budsService?.setAutoPowerOff(minutes) },
                                onSetCaseLedColor = { color -> budsService?.setCaseLedColor(color) },
                                onStartFitTest = { budsService?.startFitTest() },
                                onNavigateToEq = { navController.navigate("eq") },
                                onToggleCalibration = { enabled -> budsService?.setPersonalSoundCalibration(enabled) },
                                onNavigateToCalibration = { navController.navigate("calibration") },
                            )
                        }

                        composable("gestures") {
                            GestureScreen(
                                state = state,
                                onBack = { navController.popBackStack() },
                                onSetGesture = { side, type, action ->
                                    budsService?.setGesture(side, type, action)
                                },
                            )
                        }
                    }
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
        if (hasBluetoothConnectPermission()) {
            startAndBindService()
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        if (isBound) {
            unbindService(serviceConnection)
            isBound = false
            budsService = null
        }
    }

    private fun hasBluetoothConnectPermission(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.S ||
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.BLUETOOTH_CONNECT
                ) == android.content.pm.PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        val permissions = mutableListOf<String>()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            // Connected devices / pairing only need CONNECT; SCAN is not used anywhere in the app.
            permissions.add(Manifest.permission.BLUETOOTH_CONNECT)
        }

        if (permissions.isNotEmpty()) {
            permissionLauncher.launch(permissions.toTypedArray())
        } else {
            startAndBindService()
        }

        // Notification permission is independent: it only affects whether the foreground-service
        // notification is visible and must not gate Bluetooth functionality. Asked once;
        // a denial never blocks the app.
        val notifGranted = ContextCompat.checkSelfPermission(
            this, Manifest.permission.POST_NOTIFICATIONS
        ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        if (NotificationPermission.shouldRequest(
                Build.VERSION.SDK_INT, notifGranted,
                prefs.getBoolean(NotificationPermission.PREF_ASKED, false)
            )
        ) {
            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    private fun startAndBindService() {
        Log.d(TAG, "startAndBindService")
        val intent = Intent(this, BudsService::class.java)
        ContextCompat.startForegroundService(this, intent)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun saveLastDevice(address: String) {
        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("last_device_address", address).apply()
    }
}
