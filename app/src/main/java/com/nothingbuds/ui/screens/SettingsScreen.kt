package com.nothingbuds.ui.screens

import android.Manifest
import android.app.Activity
import android.app.StatusBarManager
import android.content.ComponentName
import android.content.pm.PackageManager
import android.content.Intent
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.SystemClock
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.nothingbuds.R
import com.nothingbuds.data.BudsRepository
import com.nothingbuds.data.CompanionPairing
import com.nothingbuds.qs.AncTileService
import com.nothingbuds.service.BudsService
import com.nothingbuds.ui.components.LiquidToggle
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE) }

    var autoConnect by remember { mutableStateOf(prefs.getBoolean("auto_connect", true)) }
    var showNotification by remember { mutableStateOf(prefs.getBoolean("show_notification", true)) }
    var isAssociated by remember { mutableStateOf(CompanionPairing.isAssociated(context)) }
    var showNotifRationale by remember { mutableStateOf(false) }

    fun hasNotifPermission(): Boolean =
        Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU ||
            ContextCompat.checkSelfPermission(
                context, Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED

    fun applyHub(enabled: Boolean) {
        showNotification = enabled
        prefs.edit().putBoolean("show_notification", enabled).apply()
        // Repost immediately instead of waiting for the next state change.
        runCatching {
            context.startService(
                Intent(context, BudsService::class.java)
                    .setAction(BudsService.ACTION_REFRESH_NOTIFICATION)
            )
        }
    }

    val notifPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        // A denial must not crash anything or falsely enable the hub.
        applyHub(granted)
    }

    // The system device picker hands back an IntentSender we have to launch ourselves.
    val associationLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartIntentSenderForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            CompanionPairing.startObserving(context)
            isAssociated = CompanionPairing.isAssociated(context)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Settings") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
        ) {
            // Connection settings
            SettingsSection(title = "Connection") {
                SettingsSwitch(
                    title = "Auto-connect",
                    subtitle = "Connect to last device on startup",
                    icon = Icons.Default.Bluetooth,
                    checked = autoConnect,
                    onCheckedChange = {
                        autoConnect = it
                        prefs.edit().putBoolean("auto_connect", it).apply()
                    }
                )
            }

            // Notification settings
            SettingsSection(title = "Notifications") {
                SettingsSwitch(
                    title = "Quick-toggle hub",
                    subtitle = if (showNotification) {
                        "Battery and mode buttons in the shade"
                    } else {
                        "Hidden — Android still shows a silent placeholder while connected"
                    },
                    icon = Icons.Default.Notifications,
                    checked = showNotification,
                    onCheckedChange = { enabled ->
                        if (enabled && !hasNotifPermission()) {
                            // The hub needs notification permission to be visible:
                            // explain why before requesting.
                            showNotifRationale = true
                        } else {
                            applyHub(enabled)
                        }
                    }
                )
            }

            if (showNotifRationale) {
                AlertDialog(
                    onDismissRequest = { showNotifRationale = false },
                    confirmButton = {
                        TextButton(onClick = {
                            showNotifRationale = false
                            notifPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                        }) { Text("Allow Notifications") }
                    },
                    dismissButton = {
                        TextButton(onClick = { showNotifRationale = false }) { Text("Not Now") }
                    },
                    title = { Text("Notifications permission") },
                    text = { Text("This feature uses notifications to let you know when an action or background operation needs your attention.") }
                )
            }

            // Quick access
            SettingsSection(title = "Quick access") {
                SettingsItem(
                    title = "Add Quick Settings tile",
                    subtitle = "Cycle ANC · Transparency · Off from the shade",
                    icon = Icons.Default.Tune,
                    onClick = onClick@{
                        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                            Toast.makeText(
                                context,
                                "Add the tile by editing your Quick Settings panel",
                                Toast.LENGTH_LONG
                            ).show()
                            return@onClick
                        }
                        val statusBar = context.getSystemService(StatusBarManager::class.java)
                        statusBar?.requestAddTileService(
                            ComponentName(context, AncTileService::class.java),
                            context.getString(R.string.tile_label),
                            android.graphics.drawable.Icon.createWithResource(
                                context,
                                R.drawable.ic_anc
                            ),
                            context.mainExecutor
                        ) { }
                    }
                )

                SettingsItem(
                    title = "Follow earbuds automatically",
                    subtitle = if (isAssociated) {
                        "Paired — notification follows the connection"
                    } else {
                        "Pair once so the hub appears only while connected"
                    },
                    icon = Icons.Default.Watch,
                    onClick = onClick@{
                        if (!CompanionPairing.isSupported()) {
                            Toast.makeText(
                                context,
                                "Needs Android 12 or newer",
                                Toast.LENGTH_LONG
                            ).show()
                            return@onClick
                        }
                        val activity = context as? Activity ?: return@onClick
                        CompanionPairing.requestAssociation(
                            activity = activity,
                            onIntentSender = { sender ->
                                associationLauncher.launch(
                                    IntentSenderRequest.Builder(sender).build()
                                )
                            },
                            onFailure = { error ->
                                Toast.makeText(
                                    context,
                                    error?.toString() ?: "Pairing failed",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        )
                    }
                )
            }

            // About section
            var versionTaps by rememberSaveable { mutableStateOf(0) }
            var lastVersionTap by remember { mutableStateOf(0L) }
            val scope = rememberCoroutineScope()

            SettingsSection(title = "About") {
                SettingsItem(
                    title = "Version",
                    subtitle = "1.0.0 (tap 7× to export logs)",
                    icon = Icons.Default.Info,
                    onClick = {
                        val now = SystemClock.elapsedRealtime()
                        versionTaps = if (now - lastVersionTap > 1500) 1 else versionTaps + 1
                        lastVersionTap = now
                        if (versionTaps >= 7) {
                            versionTaps = 0
                            scope.launch {
                                Toast.makeText(context, "Exporting logs…", Toast.LENGTH_SHORT).show()
                                exportLogs(context)
                            }
                        }
                    }
                )

                SettingsItem(
                    title = "Open Source",
                    subtitle = "This app is open source",
                    icon = Icons.Default.Code
                )

                SettingsItem(
                    title = "Protocol",
                    subtitle = "Based on ear-web reverse engineering",
                    icon = Icons.Default.Memory
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Credits
            Text(
                "Made with ❤️ for Nothing & CMF users",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
            )
        }
    }
}

@Composable
private fun SettingsSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            title,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            )
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                content()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
private fun SettingsSwitch(
    title: String,
    subtitle: String,
    icon: ImageVector,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LiquidToggle(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
private fun SettingsItem(
    title: String,
    subtitle: String,
    icon: ImageVector,
    onClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .then(if (onClick != null) Modifier.clickable(onClick = onClick) else Modifier)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

/** Gathers our app's logcat, header, and last known earbuds state into a shareable file. */
private suspend fun exportLogs(context: Context) {
    val appTags = setOf(
        "BudsService", "MainActivity", "NothingBudsApp", "BudsCompanionService",
        "BootReceiver", "BluetoothConnectionReceiver", "AncTileService"
    )

    val body = withContext(kotlinx.coroutines.Dispatchers.IO) {
        try {
            val process = Runtime.getRuntime().exec(arrayOf("logcat", "-d", "-v", "threadtime"))
            val logs = process.inputStream.bufferedReader().useLines { lines ->
                lines.filter { line ->
                    appTags.any { line.contains(" $it ") || line.contains(" $it:") } ||
                        line.contains("nothingbuds")
                }.joinToString("\n")
            }
            process.waitFor()
            logs
        } catch (e: Exception) {
            "logcat unavailable: ${e.message}"
        }
    }

    val header = buildString {
        val version = try {
            val pm = context.packageManager
            pm.getPackageInfo(context.packageName, 0).versionName
        } catch (e: Exception) {
            "?"
        }
        appendLine("Nothing Buds log export")
        appendLine("time: ${SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Date())}")
        appendLine("app version: $version")
        appendLine("android: ${Build.VERSION.RELEASE} (SDK ${Build.VERSION.SDK_INT}, ${Build.MANUFACTURER} ${Build.MODEL})")
        val state = BudsRepository.state.value
        appendLine("earbuds: ${state.deviceName} ${state.deviceAddress} model=${state.deviceModel?.id} connected=${state.isConnected} fw=${state.firmwareVersion}")
        appendLine("battery: ${state.battery}")
        appendLine("anc=${state.ancMode}, eq=${state.eqPreset}, dirac=${state.diracEq}, customEq=${state.customEq.joinToString(",")}")
        appendLine("bass=${state.enhancedBass}/level=${state.bassLevel}, spatial=${state.spatialAudio}, lhdc=${state.lhdc}, dual=${state.dualDevice}")
        appendLine("lowLatency=${state.lowLatencyMode}, inEar=${state.inEarDetection}, powerOff=${state.autoPowerOffMinutes}min")
        appendLine("prefs: ${context.getSharedPreferences("earbuds_prefs", Context.MODE_PRIVATE).all}")
        appendLine()
        appendLine("--- logcat ---")
        appendLine(body)
    }

    val dir = File(context.getExternalFilesDir(null), "logs").apply { mkdirs() }
    val file = File(dir, "nothingbuds_${SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())}.log")
    val written = runCatching { file.writeText(header) }.isSuccess

    val uri = runCatching {
        FileProvider.getUriForFile(context, "com.nothingbuds.fileprovider", file)
    }.getOrNull()

    if (!written || uri == null) {
        Toast.makeText(context, "Failed to export logs", Toast.LENGTH_LONG).show()
        return
    }

    val share = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_STREAM, uri)
        putExtra(Intent.EXTRA_SUBJECT, "Nothing Buds logs")
        addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
        if (context !is Activity) addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    runCatching {
        context.startActivity(Intent.createChooser(share, "Share Nothing Buds logs"))
    }.onFailure {
        Toast.makeText(context, "Export failed: ${it.message}", Toast.LENGTH_LONG).show()
    }
}
