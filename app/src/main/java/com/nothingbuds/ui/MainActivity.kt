package com.nothingbuds.ui

import android.Manifest
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import com.nothingbuds.util.AppLog
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
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
import com.nothingbuds.ui.screens.EqPopupOverlay
import com.nothingbuds.ui.screens.ExtrasScreen
import com.nothingbuds.ui.screens.GestureScreen
import com.nothingbuds.ui.screens.HomeScreen
import com.nothingbuds.ui.screens.SettingsScreen
import com.nothingbuds.ui.theme.LocalGlassEnabled
import com.nothingbuds.ui.theme.NothingEarbudsTheme
import com.nothingbuds.ui.theme.UiTheme
import com.nothingbuds.ui.theme.appBackdropSource
import com.nothingbuds.ui.theme.rememberAppBackdrop

class MainActivity : ComponentActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private var budsService: BudsService? = null
    private var isBound by mutableStateOf(false)

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, binder: IBinder?) {
            AppLog.d(TAG, "Service connected")
            val localBinder = binder as? BudsService.LocalBinder
            budsService = localBinder?.getService()
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            AppLog.d(TAG, "Service disconnected")
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
        AppLog.d(TAG, "Bluetooth CONNECT granted=$btGranted")
        if (btGranted) {
            startAndBindService()
        }
    }

    private val notificationPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        AppLog.d(TAG, "POST_NOTIFICATIONS granted=$granted")
        getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
            .edit().putBoolean(NotificationPermission.PREF_ASKED, true).apply()
        syncHubToNotificationPermission(granted)
    }

    private fun isNotifGranted(): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
            ContextCompat.checkSelfPermission(
                this, Manifest.permission.POST_NOTIFICATIONS
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED

    private fun syncHubToNotificationPermission(granted: Boolean) {
        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        val enabled = NotificationPermission.resolveHubEnabled(
            granted,
            prefs.getBoolean("hub_user_set", false),
            prefs.getBoolean("show_notification", false)
        )
        prefs.edit().putBoolean("show_notification", enabled).apply()
        if (enabled) {
            runCatching {
                startService(
                    Intent(this, BudsService::class.java)
                        .setAction(BudsService.ACTION_REFRESH_NOTIFICATION)
                )
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        AppLog.d(TAG, "onCreate")

        requestPermissions()

        setContent {
            var uiTheme by remember {
                mutableStateOf(
                    UiTheme.parse(
                        getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
                            .getString(UiTheme.PREF_KEY, null)
                    )
                )
            }
            NothingEarbudsTheme(darkTheme = uiTheme != UiTheme.MATERIAL_LIGHT) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    // One source of truth — the service writes into it whether we are bound or not.
                    val state by BudsRepository.state.collectAsState()
                    var showEqPopup by remember { mutableStateOf(false) }

                    CompositionLocalProvider(
                        LocalGlassEnabled provides (uiTheme == UiTheme.LIQUID_GLASS)
                    ) {
                        Box(modifier = Modifier.fillMaxSize()) {
                            val popupBackdrop = rememberAppBackdrop()
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .then(
                                        if (showEqPopup && uiTheme == UiTheme.LIQUID_GLASS) {
                                            Modifier.appBackdropSource(popupBackdrop)
                                        } else Modifier
                                    )
                            ) {
                                NavHost(
                                    navController = navController,
                                    startDestination = "home"
                                ) {
                        composable("home") {
                            HomeScreen(
                                state = state,
                                onNavigateToDevices = { navController.navigate("devices") },
                                onShowEqPopup = { showEqPopup = true },
                                onSetPreset = { preset -> budsService?.setEqPreset(preset) },
                                onSetDiracEq = { level -> budsService?.setDiracEq(level) },
                                onSetCustomEq = { bands -> budsService?.setCustomEq(bands) },
                                onSetDiracCustomEq = { bass, mid, treble -> budsService?.setDiracCustomEq(bass, mid, treble) },
                                onApplyMyEq = { budsService?.applyMyEq() },
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
                                    AppLog.d(TAG, "Device selected: ${device.name}")
                                    budsService?.connect(device.address)
                                    saveLastDevice(device.address)
                                    navController.popBackStack()
                                },
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
                                uiTheme = uiTheme,
                                onThemeChange = { selected ->
                                    uiTheme = selected
                                    getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
                                        .edit().putString(UiTheme.PREF_KEY, selected.name).apply()
                                },
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
                if (showEqPopup) {
                    EqPopupOverlay(
                        state = state,
                        onSetPreset = { preset -> budsService?.setEqPreset(preset) },
                        onSetDiracEq = { level -> budsService?.setDiracEq(level) },
                        onSetCustomEq = { bands -> budsService?.setCustomEq(bands) },
                        onSetDiracCustomEq = { bass, mid, treble -> budsService?.setDiracCustomEq(bass, mid, treble) },
                        onApplyMyEq = { budsService?.applyMyEq() },
                        onDismiss = { showEqPopup = false },
                        backdrop = if (uiTheme == UiTheme.LIQUID_GLASS) popupBackdrop else null
                    )
                }
            }
        }
    }
    }
    }
    }

    override fun onStart() {
        super.onStart()
        AppLog.d(TAG, "onStart")
        if (hasBluetoothConnectPermission()) {
            startAndBindService()
        }
    }

    override fun onStop() {
        super.onStop()
        AppLog.d(TAG, "onStop")
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
        // a denial never blocks the app. A grant auto-enables the hub unless chosen otherwise.
        val notifGranted = isNotifGranted()
        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        if (NotificationPermission.shouldRequest(
                Build.VERSION.SDK_INT, notifGranted,
                prefs.getBoolean(NotificationPermission.PREF_ASKED, false)
            )
        ) {
            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            syncHubToNotificationPermission(notifGranted)
        }
    }

    private fun startAndBindService() {
        AppLog.d(TAG, "startAndBindService")
        val intent = Intent(this, BudsService::class.java)
        ContextCompat.startForegroundService(this, intent)
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
    }

    private fun saveLastDevice(address: String) {
        val prefs = getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE)
        prefs.edit().putString("last_device_address", address).apply()
    }
}
