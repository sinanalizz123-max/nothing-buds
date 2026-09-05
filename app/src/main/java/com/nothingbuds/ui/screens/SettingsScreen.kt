package com.nothingbuds.ui.screens

import android.app.Activity
import android.app.StatusBarManager
import android.content.ComponentName
import android.content.Intent
import android.content.Context
import android.os.Build
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.nothingbuds.R
import com.nothingbuds.data.CompanionPairing
import com.nothingbuds.qs.AncTileService
import com.nothingbuds.service.BudsService

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
            SettingsSection(title = "About") {
                SettingsItem(
                    title = "Version",
                    subtitle = "1.0.0",
                    icon = Icons.Default.Info
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

        Switch(
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
