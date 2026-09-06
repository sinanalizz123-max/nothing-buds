package com.nothingbuds.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.DiracEqPreset
import com.nothingbuds.protocol.EqPreset
import com.nothingbuds.ui.theme.NothingRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EQScreen(
    state: EarbudsState,
    onSetPreset: (EqPreset) -> Unit,
    onSetDiracEq: (Int) -> Unit,
    onSetCustomEq: (IntArray) -> Unit,
    onBack: () -> Unit
) {
    var customBands by remember { mutableStateOf(state.customEq.copyOf()) }
    val isDirac = state.deviceModel?.hasDiracEq == true
    var showDiracUnavailable by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Equalizer") },
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
                .padding(16.dp)
        ) {
            Text(
                "Equalizer",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                if (isDirac) {
                    "Dirac Opteo is one equalizer mode. The presets below use the standard equalizer; Dirac Opteo is the mode that shares the wire with the LDAC codec."
                } else {
                    "Pick a preset; the earbuds apply the curve instantly."
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            // Standard EQ presets (SET_EQ, 0xF010). On Dirac-capable models (B172/B168) these
            // still go through the normal equalizer; only the Dirac Opteo row below talks to the
            // Dirac EQ command (0xF01D).
            EqPreset.entries.forEach { preset ->
                EqPresetRow(
                    name = getPresetDisplayName(preset),
                    description = getPresetDescription(preset),
                    isSelected = state.eqPreset == preset &&
                        !(preset == EqPreset.BALANCED && diracModeActive(state.diracEq, state.eqPreset)),
                    enabled = true,
                    onClick = { onSetPreset(preset) }
                )
            }

            if (isDirac) {
                val target = eqRowTarget(isOpteoRow = true, lhdcActive = state.lhdc)
                EqPresetRow(
                    name = DiracEqPreset.OPTEO.displayName,
                    description = getDiracPresetDescription(DiracEqPreset.OPTEO),
                    isSelected = diracModeActive(state.diracEq, state.eqPreset),
                    enabled = true,
                    onClick = {
                        when (target) {
                            EqRowTarget.SET_DIRAC_EQ -> {
                                // Only the Dirac Opteo row writes through the Dirac EQ command
                                // (0xF01D, level 0); the standard presets above never do.
                                onSetDiracEq(DiracEqPreset.OPTEO.type)
                            }
                            EqRowTarget.DIRAC_UNAVAILABLE -> {
                                // Matches the official app: tapping Dirac Opteo while LDAC is on
                                // shows the "…is unavailable while LDAC is on" dialog and does not
                                // send anything to the earbuds.
                                showDiracUnavailable = true
                            }
                            else -> Unit
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Custom EQ
            if (state.deviceModel?.hasCustomEq == true) {
                Text(
                    "Custom EQ",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        // Frequency labels
                        val frequencies = listOf("60", "150", "400", "1k", "2.4k", "6k", "10k", "16k")

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            frequencies.forEachIndexed { index, freq ->
                                Column(
                                    modifier = Modifier.weight(1f),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    EqBandSlider(
                                        value = customBands[index],
                                        onValueChange = { newValue ->
                                            customBands = customBands.copyOf().also {
                                                it[index] = newValue
                                            }
                                        },
                                        onValueChangeFinished = {
                                            onSetCustomEq(customBands)
                                        }
                                    )

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Text(
                                        freq,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Reset button
                        OutlinedButton(
                            onClick = {
                                customBands = IntArray(8) { 0 }
                                onSetCustomEq(customBands)
                            },
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("Reset")
                        }
                    }
                }
            }
        }
    }

    if (showDiracUnavailable) {
        AlertDialog(
            onDismissRequest = { showDiracUnavailable = false },
            confirmButton = {
                TextButton(onClick = { showDiracUnavailable = false }) { Text("OK") }
            },
            title = { Text("Dirac Opteo unavailable") },
            text = { Text("Dirac Opteo is unavailable while the LDAC/LHDC codec is on. Turn the codec off to use Dirac Opteo; the other presets are unaffected.") }
        )
    }
}

@Composable
private fun EqPresetRow(
    name: String,
    description: String,
    isSelected: Boolean,
    enabled: Boolean,
    onClick: () -> Unit
) {
    val contentColor = if (enabled) MaterialTheme.colorScheme.onSurface
    else MaterialTheme.colorScheme.onSurfaceVariant

    val itemContent: @Composable ColumnScope.() -> Unit = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isSelected,
                onClick = onClick,
                enabled = enabled,
                colors = RadioButtonDefaults.colors(
                    selectedColor = NothingRed,
                    disabledSelectedColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    disabledUnselectedColor = MaterialTheme.colorScheme.outlineVariant
                )
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    name,
                    style = MaterialTheme.typography.titleSmall,
                    color = contentColor
                )
                Text(
                    description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }

    val containerColor = when {
        !enabled -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f)
        isSelected -> NothingRed.copy(alpha = 0.2f)
        else -> MaterialTheme.colorScheme.surface
    }

    if (enabled) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(containerColor = containerColor),
            onClick = onClick,
            content = itemContent
        )
    } else {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            colors = CardDefaults.cardColors(containerColor = containerColor),
            content = itemContent
        )
    }
}

@Composable
private fun EqBandSlider(
    value: Int,
    onValueChange: (Int) -> Unit,
    onValueChangeFinished: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "${if (value > 0) "+" else ""}$value",
            style = MaterialTheme.typography.labelSmall,
            color = if (value != 0) NothingRed else MaterialTheme.colorScheme.onSurfaceVariant
        )

        Box(
            modifier = Modifier
                .width(40.dp)
                .height(120.dp),
            contentAlignment = Alignment.Center
        ) {
            Slider(
                value = value.toFloat(),
                onValueChange = { onValueChange(it.toInt()) },
                onValueChangeFinished = onValueChangeFinished,
                valueRange = -6f..6f,
                steps = 11,
                modifier = Modifier
                    .width(120.dp)
                    .height(36.dp)
                    .graphicsLayer { rotationZ = 90f },
                colors = SliderDefaults.colors(
                    thumbColor = NothingRed,
                    activeTrackColor = NothingRed,
                    disabledThumbColor = MaterialTheme.colorScheme.outlineVariant,
                    disabledActiveTrackColor = MaterialTheme.colorScheme.outlineVariant
                )
            )
        }
    }
}

private fun getPresetDisplayName(preset: EqPreset): String {
    return when (preset) {
        EqPreset.BALANCED -> "Balanced"
        EqPreset.MORE_BASS -> "More Bass"
        EqPreset.MORE_TREBLE -> "More Treble"
        EqPreset.VOICE -> "Voice"
        EqPreset.CUSTOM -> "Custom"
    }
}

private fun getPresetDescription(preset: EqPreset): String {
    return when (preset) {
        EqPreset.BALANCED -> "Flat frequency response"
        EqPreset.MORE_BASS -> "Enhanced low frequencies"
        EqPreset.MORE_TREBLE -> "Enhanced high frequencies"
        EqPreset.VOICE -> "Optimized for podcasts and calls"
        EqPreset.CUSTOM -> "Your custom equalizer settings"
    }
}

private fun getDiracPresetDescription(preset: DiracEqPreset): String {
    return when (preset) {
        DiracEqPreset.OPTEO -> "The Dirac tuned profile; unavailable while LDAC is on"
        DiracEqPreset.POP -> "Bright mid-range for vocals and pop"
        DiracEqPreset.ROCK -> "Punchy low-mid response"
        DiracEqPreset.CLASSICAL -> "Wide, natural staging"
        DiracEqPreset.ELECTRONIC -> "Extra sub and treble sparkle"
        DiracEqPreset.ENHANCE_VOCALS -> "Voice-focused curve"
        DiracEqPreset.CUSTOM -> "Your custom curve stored on the earbuds"
    }
}

internal enum class EqRowTarget {
    SET_DIRAC_EQ,
    DIRAC_UNAVAILABLE,
    DO_NOTHING
}

internal fun eqRowTarget(isOpteoRow: Boolean, lhdcActive: Boolean): EqRowTarget {
    return if (isOpteoRow) {
        if (lhdcActive) {
            EqRowTarget.DIRAC_UNAVAILABLE
        } else {
            EqRowTarget.SET_DIRAC_EQ
        }
    } else {
        EqRowTarget.DO_NOTHING
    }
}

internal fun diracModeActive(diracEq: Int, eqPreset: EqPreset): Boolean {
    return diracEq == DiracEqPreset.OPTEO.type && eqPreset == EqPreset.BALANCED
}