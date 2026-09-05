package com.nothingbuds.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BatteryFull
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.Bluetooth
import androidx.compose.material.icons.filled.Equalizer
import androidx.compose.material.icons.filled.GraphicEq
import androidx.compose.material.icons.filled.Hearing
import androidx.compose.material.icons.filled.HearingDisabled
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SpatialAudio
import androidx.compose.material.icons.filled.Speed
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.AncMode
import com.nothingbuds.protocol.DiracEqPreset
import com.nothingbuds.protocol.PacketBuilder
import kotlin.math.roundToInt

/** The three top-level listening modes; ANC levels are a second row under it. */
private enum class ListeningMode(val label: String) {
    ANC("ANC"),
    TRANSPARENCY("Transparency"),
    OFF("Off"),
}

private val ANC_LEVELS = listOf(
    AncMode.ADAPTIVE to "Adaptive",
    AncMode.HIGH to "High",
    AncMode.MID to "Mid",
    AncMode.LOW to "Low",
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun HomeScreen(
    state: EarbudsState,
    onNavigateToDevices: () -> Unit,
    onNavigateToEQ: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToExtras: () -> Unit,
    onSetAncMode: (AncMode) -> Unit,
    onToggleInEar: (Boolean) -> Unit,
    onToggleLowLatency: (Boolean) -> Unit,
    onSetBassBoost: (Boolean, Int) -> Unit,
    onToggleSpatialAudio: (Boolean) -> Unit,
    onFindMyEarbuds: (Int, Boolean) -> Unit,
    onDisconnect: () -> Unit,
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        rememberTopAppBarState()
    )

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = {
                    Text(state.deviceName.ifEmpty { "Earbuds" })
                },
                actions = {
                    IconButton(onClick = onNavigateToSettings) {
                        Icon(Icons.Default.Settings, contentDescription = "Settings")
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { padding ->
        if (!state.isConnected) {
            NotConnected(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                onNavigateToDevices = onNavigateToDevices,
            )
            return@Scaffold
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = androidx.compose.foundation.layout.PaddingValues(
                start = 16.dp, end = 16.dp, bottom = 32.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            item { BatteryCard(state) }

            item {
                ListeningModeCard(
                    state = state,
                    onSetAncMode = onSetAncMode,
                )
            }

            item {
                SoundCard(
                    state = state,
                    onNavigateToEQ = onNavigateToEQ,
                    onSetBassBoost = onSetBassBoost,
                    onToggleSpatialAudio = onToggleSpatialAudio,
                )
            }

            item {
                BehaviourCard(
                    state = state,
                    onToggleInEar = onToggleInEar,
                    onToggleLowLatency = onToggleLowLatency,
                )
            }

            item {
                FindCard(onFindMyEarbuds = onFindMyEarbuds)
            }

            item {
                MoreCard(onNavigateToExtras = onNavigateToExtras)
            }

            item {
                DeviceFooter(state = state, onDisconnect = onDisconnect)
            }
        }
    }
}

// ---- Battery ---------------------------------------------------------------------------------

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
private fun BatteryCard(state: EarbudsState) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = MaterialTheme.shapes.extraLarge,
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            SectionLabel("Battery", Icons.Default.BatteryFull)
            Spacer(Modifier.height(20.dp))
            // Left and right sit on the outside where they read as a pair, with the case between
            // them — and drawn smaller and muted, because it is the least urgent of the three.
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom,
            ) {
                BatteryCell("Left", state.battery.left, state.battery.leftCharging, primary = true)
                BatteryCell("Case", state.battery.case, state.battery.caseCharging, primary = false)
                BatteryCell("Right", state.battery.right, state.battery.rightCharging, primary = true)
            }
        }
    }
}

/**
 * A battery drawn as a battery: rounded cell with a cap, filling from the bottom.
 *
 * @param primary the earbuds are what the user actually cares about, so they are drawn larger and
 *   in the accent colour while the case stays muted.
 */
@Composable
private fun BatteryCell(
    label: String,
    level: Int,
    charging: Boolean,
    primary: Boolean,
) {
    // Same size for all three: the case is set apart by colour alone, not by being shrunk.
    val width = 58.dp
    val height = 104.dp

    val known = level >= 0
    val low = known && level <= 15
    val fillColor = when {
        !known -> MaterialTheme.colorScheme.surfaceVariant
        low -> MaterialTheme.colorScheme.error
        primary -> MaterialTheme.colorScheme.primary
        // Muted on purpose: the case matters least, so it recedes without changing shape or size.
        else -> MaterialTheme.colorScheme.secondaryContainer
    }
    val outlineColor = if (primary) {
        MaterialTheme.colorScheme.onSurface
    } else {
        MaterialTheme.colorScheme.outline
    }
    val trackColor = MaterialTheme.colorScheme.surfaceContainerHighest

    // Level changes are pushed by the earbuds, so animate rather than snap.
    val fraction by animateFloatAsState(
        targetValue = if (known) level / 100f else 0f,
        animationSpec = MaterialTheme.motionScheme.slowSpatialSpec(),
        label = "batteryFill",
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .width(width)
                .height(height),
            contentAlignment = Alignment.Center,
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                val capWidth = size.width * 0.38f
                val capHeight = size.height * 0.06f
                val bodyTop = capHeight
                val bodyHeight = size.height - capHeight
                val stroke = size.width * 0.055f
                val corner = CornerRadius(size.width * 0.22f, size.width * 0.22f)

                // Cap
                drawRoundRect(
                    color = outlineColor,
                    topLeft = Offset((size.width - capWidth) / 2f, 0f),
                    size = Size(capWidth, capHeight * 1.6f),
                    cornerRadius = CornerRadius(capHeight, capHeight),
                )

                // Empty body
                drawRoundRect(
                    color = trackColor,
                    topLeft = Offset(0f, bodyTop),
                    size = Size(size.width, bodyHeight),
                    cornerRadius = corner,
                )

                // Fill, growing from the bottom
                if (fraction > 0f) {
                    val inset = stroke * 1.6f
                    val innerHeight = bodyHeight - inset * 2
                    val fillHeight = innerHeight * fraction.coerceIn(0f, 1f)
                    drawRoundRect(
                        color = fillColor,
                        topLeft = Offset(inset, bodyTop + inset + (innerHeight - fillHeight)),
                        size = Size(size.width - inset * 2, fillHeight),
                        cornerRadius = CornerRadius(size.width * 0.16f, size.width * 0.16f),
                    )
                }

                // Outline last so it stays crisp over the fill
                drawRoundRect(
                    color = outlineColor,
                    topLeft = Offset(stroke / 2f, bodyTop + stroke / 2f),
                    size = Size(size.width - stroke, bodyHeight - stroke),
                    cornerRadius = corner,
                    style = Stroke(width = stroke),
                )
            }

            // The number sits over the fill once the cell is more than about half full, so it
            // has to flip to the fill's own content colour to stay readable.
            val numberColor = if (fraction > 0.45f) {
                contentColorFor(fillColor)
            } else {
                MaterialTheme.colorScheme.onSurface
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                if (charging) {
                    Icon(
                        Icons.Default.Bolt,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp),
                        tint = numberColor,
                    )
                }
                Text(
                    text = if (known) "$level" else "–",
                    style = MaterialTheme.typography.titleLarge,
                    color = numberColor,
                )
            }
        }

        Spacer(Modifier.height(10.dp))
        Text(
            text = label,
            style = MaterialTheme.typography.labelLarge,
            color = if (primary) {
                MaterialTheme.colorScheme.onSurface
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            },
        )
    }
}

// ---- Listening mode --------------------------------------------------------------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListeningModeCard(
    state: EarbudsState,
    onSetAncMode: (AncMode) -> Unit,
) {
    val model = state.deviceModel
    if (model != null && !model.hasAnc) return

    val hasTransparency = model == null || model.hasTransparency
    val modes = buildList {
        add(ListeningMode.ANC)
        if (hasTransparency) add(ListeningMode.TRANSPARENCY)
        add(ListeningMode.OFF)
    }

    val selected = when {
        state.ancMode == AncMode.OFF -> ListeningMode.OFF
        state.ancMode == AncMode.TRANSPARENCY -> ListeningMode.TRANSPARENCY
        else -> ListeningMode.ANC
    }

    SectionCard(title = "Listening mode", icon = Icons.Default.Hearing) {
        SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
            modes.forEachIndexed { index, mode ->
                SegmentedButton(
                    selected = selected == mode,
                    onClick = {
                        onSetAncMode(
                            when (mode) {
                                // Returning to ANC picks up the level the earbuds remember.
                                ListeningMode.ANC ->
                                    state.ancLevel.takeIf { it.isAnc } ?: AncMode.HIGH
                                ListeningMode.TRANSPARENCY -> AncMode.TRANSPARENCY
                                ListeningMode.OFF -> AncMode.OFF
                            }
                        )
                    },
                    shape = SegmentedButtonDefaults.itemShape(index, modes.size),
                    icon = {},
                ) {
                    Text(mode.label)
                }
            }
        }

        AnimatedVisibility(visible = selected == ListeningMode.ANC) {
            Column {
                Spacer(Modifier.height(12.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    ANC_LEVELS.forEach { (mode, label) ->
                        if (mode == AncMode.ADAPTIVE && model?.hasAdaptiveAnc == false) return@forEach
                        FilterChip(
                            selected = state.ancMode == mode,
                            onClick = { onSetAncMode(mode) },
                            label = { Text(label) },
                        )
                    }
                }
            }
        }
    }
}

// ---- Sound -----------------------------------------------------------------------------------

@Composable
private fun SoundCard(
    state: EarbudsState,
    onNavigateToEQ: () -> Unit,
    onSetBassBoost: (Boolean, Int) -> Unit,
    onToggleSpatialAudio: (Boolean) -> Unit,
) {
    SectionCard(title = "Sound", icon = Icons.Default.GraphicEq) {
        SettingRow(
            title = "Equalizer",
            subtitle = if (state.deviceModel?.hasDiracEq == true) {
                DiracEqPreset.fromLevel(state.diracEq).displayName
            } else {
                state.eqPreset.name.lowercase().replaceFirstChar { it.uppercase() }
            },
            icon = Icons.Default.Equalizer,
        ) {
            FilledTonalButton(onClick = onNavigateToEQ) { Text("Adjust") }
        }

        val model = state.deviceModel
        if (model == null || model.hasEnhancedBass) {
            Spacer(Modifier.height(4.dp))
            SettingRow(
                // The official app calls this Ultra bass; matching its wording avoids confusion
                // when comparing the two apps side by side.
                title = "Ultra bass",
                subtitle = if (state.enhancedBass) "Level ${state.bassLevel}" else "Off",
                icon = Icons.Default.Tune,
            ) {
                Switch(
                    checked = state.enhancedBass,
                    onCheckedChange = { onSetBassBoost(it, state.bassLevel) },
                )
            }

            AnimatedVisibility(visible = state.enhancedBass) {
                // Local state keeps the slider smooth; the earbuds only hear the final value.
                var draft by remember(state.bassLevel) {
                    mutableFloatStateOf(state.bassLevel.toFloat())
                }
                Slider(
                    value = draft,
                    onValueChange = { draft = it },
                    onValueChangeFinished = { onSetBassBoost(true, draft.roundToInt()) },
                    valueRange = 1f..PacketBuilder.BASS_LEVEL_MAX.toFloat(),
                    steps = PacketBuilder.BASS_LEVEL_MAX - 2,
                    modifier = Modifier.padding(horizontal = 4.dp),
                )
            }
        }

        Spacer(Modifier.height(4.dp))
        SettingRow(
            title = "Spatial audio",
            subtitle = if (state.spatialAudio) "On" else "Off",
            icon = Icons.Default.SpatialAudio,
        ) {
            Switch(checked = state.spatialAudio, onCheckedChange = onToggleSpatialAudio)
        }
    }
}

// ---- Behaviour -------------------------------------------------------------------------------

@Composable
private fun BehaviourCard(
    state: EarbudsState,
    onToggleInEar: (Boolean) -> Unit,
    onToggleLowLatency: (Boolean) -> Unit,
) {
    SectionCard(title = "Behaviour", icon = Icons.Default.Speed) {
        val model = state.deviceModel

        if (model == null || model.hasInEarDetection) {
            SettingRow(
                title = "In-ear detection",
                subtitle = "Pause when you take an earbud out",
                icon = Icons.Default.Hearing,
            ) {
                Switch(checked = state.inEarDetection, onCheckedChange = onToggleInEar)
            }
        }

        if (model == null || model.hasLowLatency) {
            Spacer(Modifier.height(4.dp))
            SettingRow(
                title = "Low latency",
                subtitle = "Less audio delay while gaming",
                icon = Icons.Default.Speed,
            ) {
                Switch(checked = state.lowLatencyMode, onCheckedChange = onToggleLowLatency)
            }
        }
    }
}

// ---- Find ------------------------------------------------------------------------------------

@Composable
private fun FindCard(onFindMyEarbuds: (Int, Boolean) -> Unit) {
    var ringing by remember { mutableStateOf(0) }
    var confirming by remember { mutableStateOf(0) }

    SectionCard(title = "Find my earbuds", icon = Icons.Default.NotificationsActive) {
        Text(
            "Plays a loud tone. Take the earbuds out first.",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(Modifier.height(12.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(
                PacketBuilder.SIDE_LEFT to "Left",
                PacketBuilder.SIDE_RIGHT to "Right",
            ).forEach { (side, label) ->
                if (ringing == side) {
                    Button(
                        onClick = {
                            onFindMyEarbuds(side, false)
                            ringing = 0
                        },
                        modifier = Modifier.weight(1f),
                    ) { Text("Stop") }
                } else if (confirming == side) {
                    Button(
                        onClick = {
                            onFindMyEarbuds(side, true)
                            ringing = side
                            confirming = 0
                        },
                        modifier = Modifier.weight(1f),
                    ) { Text("Sure?") }
                } else {
                    OutlinedButton(
                        onClick = { confirming = side },
                        modifier = Modifier.weight(1f),
                    ) { Text(label) }
                }
            }
        }
    }
}

// ---- More -----------------------------------------------------------------------------------

@Composable
private fun MoreCard(onNavigateToExtras: () -> Unit) {
    SectionCard(title = "More", icon = Icons.Default.MoreHoriz) {
        SettingRow(
            title = "Advanced controls",
            subtitle = "Gestures, dual device, LHDC, case light, ear-tip fit test",
            icon = Icons.Default.Tune,
        ) {
            FilledTonalButton(onClick = onNavigateToExtras) { Text("Open") }
        }
    }
}

// ---- Footer ----------------------------------------------------------------------------------

@Composable
private fun DeviceFooter(state: EarbudsState, onDisconnect: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = listOfNotNull(
                state.deviceModel?.id,
                state.firmwareVersion.takeIf { it.isNotEmpty() }?.let { "Firmware $it" },
            ).joinToString(" · "),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Spacer(Modifier.height(8.dp))
        OutlinedButton(onClick = onDisconnect) { Text("Disconnect") }
    }
}

// ---- Disconnected ----------------------------------------------------------------------------

@Composable
private fun NotConnected(
    modifier: Modifier = Modifier,
    onNavigateToDevices: () -> Unit,
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(32.dp),
        ) {
            Icon(
                Icons.Default.HearingDisabled,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
            Spacer(Modifier.height(16.dp))
            Text(
                "No earbuds connected",
                style = MaterialTheme.typography.titleLarge,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(8.dp))
            Text(
                "Connect them in Bluetooth settings, then pick them here.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
            Spacer(Modifier.height(24.dp))
            Button(onClick = onNavigateToDevices) {
                Icon(Icons.Default.Bluetooth, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                Text("Choose device")
            }
        }
    }
}

// ---- Building blocks -------------------------------------------------------------------------

@Composable
private fun SectionCard(
    title: String,
    icon: ImageVector,
    content: @Composable androidx.compose.foundation.layout.ColumnScope.() -> Unit,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
        ),
        shape = MaterialTheme.shapes.extraLarge,
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            SectionLabel(title, icon)
            Spacer(Modifier.height(16.dp))
            content()
        }
    }
}

@Composable
private fun SectionLabel(title: String, icon: ImageVector) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(18.dp))
        Spacer(Modifier.width(8.dp))
        Text(title, style = MaterialTheme.typography.titleMedium)
    }
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
