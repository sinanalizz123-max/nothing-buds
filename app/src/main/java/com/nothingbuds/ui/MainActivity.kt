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
import com.nothingbuds.data.BudsRepository
import com.nothingbuds.service.BudsService
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
        val allGranted = permissions.values.all { it }
        Log.d(TAG, "Permissions result: allGranted=$allGranted")
        if (allGranted) {
            startAndBindService()
        }
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
                                onSetCustomEq = { bands -> budsService?.setCustomEq(bands) },
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
                                onToggleDual = { enabled -> budsService?.setDual(enabled) },
                                onSetConnectDevice = { mac -> budsService?.setConnectDevice(mac) },
                                onToggleLhdc = { enabled -> budsService?.setLhdc(enabled) },
                                onSetAutoPowerOff = { minutes -> budsService?.setAutoPowerOff(minutes) },
                                onSetCaseLedColor = { color -> budsService?.setCaseLedColor(color) },
                                onSetDetailEnhancement = { enabled, level ->
                                    budsService?.setDetailEnhancement(enabled, level)
                                },
                                onStartFitTest = { budsService?.startFitTest() },
                                onNavigateToEq = { navController.navigate("eq") },
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
        startAndBindService()
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

    private fun requestPermissions() {
        val permissions = mutableListOf<String>()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            permissions.add(Manifest.permission.BLUETOOTH_CONNECT)
            permissions.add(Manifest.permission.BLUETOOTH_SCAN)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissions.add(Manifest.permission.POST_NOTIFICATIONS)
        }

        if (permissions.isNotEmpty()) {
            permissionLauncher.launch(permissions.toTypedArray())
        } else {
            startAndBindService()
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
