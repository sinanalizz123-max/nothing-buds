package com.nothingbuds.ui.screens

import android.annotation.SuppressLint
import android.bluetooth.BluetoothManager
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CallSplit
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.HighQuality
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lightbulb
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.TouchApp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.graphics.Color
import com.nothingbuds.ui.components.LiquidToggle
import com.kyant.backdrop.backdrops.LayerBackdrop
import com.nothingbuds.ui.theme.GlassScreenRoot
import com.nothingbuds.ui.theme.LiquidTheme
import com.nothingbuds.ui.theme.LocalAppBackdrop
import com.nothingbuds.ui.theme.glassCard
import com.nothingbuds.ui.theme.liquidGlass
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.PacketBuilder

/**
 * The reverse-engineered extras the official app hides behind per-model support checks: gesture
 * controls, multipoint, LHDC codec, auto power-off, case LED colour, detail enhancement and the
 * ear-tip seal test.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtrasScreen(
    state: EarbudsState,
    onBack: () -> Unit,
    onNavigateToGestures: () -> Unit,
    onSetConnectDevice: (String) -> Unit,
    onSetAutoPowerOff: (Int) -> Unit,
    onSetCaseLedColor: (Int) -> Unit,
    onStartFitTest: () -> Unit,
    onToggleCalibration: (Boolean) -> Unit,
    onNavigateToCalibration: () -> Unit,
) {
    val context = LocalContext.current
    val bluetoothAdapter = remember {
        (context.getSystemService(Context.BLUETOOTH_SERVICE) as? BluetoothManager)?.adapter
    }

    @SuppressLint("MissingPermission")
    fun dualDeviceName(mac: String): String? {
        if (bluetoothAdapter == null) return null
        return try {
            bluetoothAdapter.getRemoteDevice(mac)?.name
        } catch (e: Exception) {
            null
        }
    }

    GlassScreenRoot {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("More") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        },
        containerColor = Color.Transparent,
    ) { padding ->
        if (!state.isConnected) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    "Connect your earbuds to unlock these controls.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(32.dp),
                )
            }
            return@Scaffold
        }

        val model = state.deviceModel

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Per-model gating follows the official app: unknown devices get the common extras,
            // and a known model only sees the commands it actually answers.
            if (model == null || model.hasGestureControl) {
                SectionCard("Gesture controls", Icons.Default.TouchApp) {
                    SettingRow(
                        title = "Touch controls",
                        subtitle = gestureSummary(state),
                        icon = Icons.Default.TouchApp,
                    ) {
                        FilledTonalButton(onClick = onNavigateToGestures) {
                            Text("Configure")
                        }
                    }
                }
            }

            if ((model == null || model.hasDual) &&
                state.dualDevice && state.dualDevices.isNotEmpty()
            ) {
                SectionCard("Multipoint", Icons.Default.CallSplit) {
                    Text(
                        "Paired devices",
                        style = MaterialTheme.typography.titleSmall,
                        modifier = Modifier.padding(bottom = 8.dp),
                    )
                        state.dualDevices.forEachIndexed { index, device ->
                            if (index > 0) Spacer(Modifier.height(4.dp))
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onSetConnectDevice(device.mac) }
                                    .padding(vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(
                                        dualDeviceName(device.mac) ?: "Unknown device",
                                        style = MaterialTheme.typography.bodyMedium
                                    )
                                    Text(
                                        if (device.flags != 0) {
                                            "Firmware status: ${device.flags}"
                                        } else {
                                            "Tap to make active"
                                        },
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    )
                                }
                            }
                        }
                    }
                }

            // Dirac Opteo is a preset row inside the equalizer screen (0xC050/0xF01D), not an
            // extra — so it is not surfaced here, exactly like the other EQ profiles.

            if (model == null || model.hasAutoPowerOff) {
                SectionCard("Power", Icons.Default.PowerSettingsNew) {
                    SettingRow(
                        title = "Auto power off",
                        subtitle = "When idle with no audio playing",
                        icon = Icons.Default.PowerSettingsNew,
                    ) {}
                    Spacer(Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        POWER_OFF_OPTIONS.forEach { minutes ->
                            FilterChip(
                                selected = state.autoPowerOffMinutes == minutes,
                                onClick = { onSetAutoPowerOff(minutes) },
                                label = { Text(powerOffLabel(minutes)) },
                            )
                        }
                    }
                }
            }

            // Box LED is advertised only on the Nothing Ear (1) — newer cases (CMF Buds Pro 2)
            // carry a physical rotary/mode dial instead, so never offer it for unknown models.
            if (model?.hasCaseLed == true) {
                SectionCard("Case LED", Icons.Default.Lightbulb) {
                    Text(
                        "Box LED colour",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                    Text(
                        "Nothing Ear (1) only — the colour of the light ring on the charging case.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(top = 4.dp),
                    )
                    Spacer(Modifier.height(12.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        CASE_LED_COLORS.forEach { color ->
                            CaseLedSwatch(
                                color = color,
                                selected = state.caseLedColor == color,
                                onClick = { onSetCaseLedColor(color) },
                            )
                        }
                    }
                }
            }

            SectionCard("Experimental", Icons.Default.Info) {
                SettingRow(
                    title = "Personal Sound Calibration",
                    subtitle = "Experimental listening test",
                    icon = Icons.Default.Info,
                ) {
                    LiquidToggle(
                        checked = state.calibrationEnabled,
                        onCheckedChange = onToggleCalibration,
                    )
                }
                if (state.calibrationEnabled) {
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = onNavigateToCalibration) {
                        Text("Start calibration")
                    }
                }
            }

            if (model == null || model.hasEarTipFitTest) {
                SectionCard("Ear-tip fit test", Icons.Default.Mic) {
                    Text(
                        "Place your earbuds in your ears before starting the test.",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = onStartFitTest) {
                        Icon(Icons.Default.Hearing, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("Start test")
                    }
                    state.fitTestResult?.let { result ->
                        Spacer(Modifier.height(16.dp))
                        FitResultRow("Left", result.left)
                        Spacer(Modifier.height(8.dp))
                        FitResultRow("Right", result.right)
                    }
                }
            }

            Spacer(Modifier.height(32.dp))
        }
        }
    }
    }
}

/** Two options pickers share this mapping with [GestureScreen]. */
data class GestureAction(val id: Int, val label: String)

val GESTURE_ACTIONS = listOf(
    GestureAction(1, "No action"),
    GestureAction(2, "Play / pause"),
    GestureAction(3, "Answer call"),
    GestureAction(8, "Skip back"),
    GestureAction(9, "Skip forward"),
    GestureAction(10, "Noise control"),
    GestureAction(11, "Voice assistant"),
    GestureAction(17, "Game mode"),
    GestureAction(18, "Volume up"),
    GestureAction(19, "Volume down"),
    GestureAction(20, "Noise control · NC"),
    GestureAction(21, "Noise control · Transparency"),
    GestureAction(22, "Noise control · Transparency + NC"),
    GestureAction(23, "Volume control"),
    GestureAction(25, "Answer call + mute"),
    GestureAction(26, "Decline call"),
)

private fun actionLabel(id: Int): String =
    GESTURE_ACTIONS.find { it.id == id }?.label ?: "Unknown"

private fun gestureSummary(state: EarbudsState): String {
    if (state.gestures.isEmpty()) return "Double tap, press and hold"
    val bySide = state.gestures.groupBy { it.side }
    val parts = mutableListOf<String>()
    bySide[PacketBuilder.SIDE_LEFT]?.let { slots ->
        if (slots.isNotEmpty()) parts.add("Left: ${actionLabel(slots.first().action)}")
    }
    bySide[PacketBuilder.SIDE_RIGHT]?.let { slots ->
        if (slots.isNotEmpty()) parts.add("Right: ${actionLabel(slots.first().action)}")
    }
    return parts.joinToString(" · ")
}

private val POWER_OFF_OPTIONS = listOf(0, 10, 20, 30, 60)

private fun powerOffLabel(minutes: Int): String =
    if (minutes == 0) "Off" else "$minutes min"

internal val DETAIL_LEVELS = listOf(
    1 to "Low",
    2 to "Mid",
    3 to "High",
)

private val CASE_LED_COLORS = listOf(
    0xFFFFFFFF.toInt(),
    0xFFFF0000.toInt(),
    0xFFFF8800.toInt(),
    0xFFFFFF00.toInt(),
    0xFF00FF00.toInt(),
    0xFF00FFFF.toInt(),
    0xFF0000FF.toInt(),
    0xFFFF00FF.toInt(),
)

@Composable
private fun CaseLedSwatch(color: Int, selected: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(36.dp)
            .then(if (selected) Modifier.border(3.dp, MaterialTheme.colorScheme.primary, CircleShape) else Modifier)
            .background(androidx.compose.ui.graphics.Color(color), CircleShape)
            .clickable(onClick = onClick)
    )
}

private val FIT_RESULT_LABELS = listOf("Good seal", "Adjust fit", "Re-seat earbuds")

@Composable
private fun FitResultRow(label: String, code: Int) {
    val status = FIT_RESULT_LABELS.getOrElse(code) { "Unknown" }
    val color = when (code) {
        0 -> MaterialTheme.colorScheme.primary
        1 -> MaterialTheme.colorScheme.tertiary
        else -> MaterialTheme.colorScheme.error
    }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(label, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.weight(1f))
        Text(status, style = MaterialTheme.typography.bodyLarge, color = color)
    }
}

// ---- Building blocks (kept local to this file, mirroring home) -------------------------------

@Composable
private fun SectionCard(
    title: String,
    icon: ImageVector,
    content: @Composable ColumnScope.() -> Unit,
) {
    val backdrop = LocalAppBackdrop.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .then(
                if (backdrop != null) Modifier.liquidGlass(backdrop, LiquidTheme.CardShape)
                else Modifier
            ),
        colors = CardDefaults.cardColors(
            containerColor = if (backdrop != null) Color.Transparent else MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = LiquidTheme.CardShape,
        border = if (LocalAppBackdrop.current != null)
                BorderStroke(1.dp, LiquidTheme.GlassBorder) else null,
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, contentDescription = null, modifier = Modifier.size(18.dp))
                Spacer(Modifier.width(8.dp))
                Text(title, style = MaterialTheme.typography.titleMedium)
            }
            Spacer(Modifier.height(16.dp))
            content()
        }
    }
    Spacer(Modifier.height(12.dp))
}

@Composable
private fun SettingRow(
    title: String,
    subtitle: String,
    icon: ImageVector,
    trailing: @Composable () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            icon,
            contentDescription = null,
            modifier = Modifier.size(22.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(title, style = MaterialTheme.typography.bodyLarge)
            Text(
                subtitle,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }
        trailing()
    }
}