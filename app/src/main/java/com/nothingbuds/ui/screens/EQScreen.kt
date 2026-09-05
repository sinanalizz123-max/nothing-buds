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
import com.nothingbuds.protocol.EqPreset
import com.nothingbuds.ui.theme.NothingRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EQScreen(
    state: EarbudsState,
    onSetPreset: (EqPreset) -> Unit,
    onSetCustomEq: (IntArray) -> Unit,
    onBack: () -> Unit
) {
    var customBands by remember { mutableStateOf(state.customEq.copyOf()) }
    var selectedPreset by remember { mutableStateOf(state.eqPreset) }

    val isDirac = state.deviceModel?.hasDiracEq == true
    // Dirac models (B172/B168) run the Dirac Opteo EQ as their whole equalizer, and like the
    // official app, that equalizer is unavailable while the LDAC/LHDC codec is on.
    val eqLocked = isDirac && state.lhdc

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
                if (isDirac) "Equalizer — Dirac Opteo" else "Equalizer",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                if (isDirac) {
                    "Presets are applied through the Dirac Opteo equalizer."
                } else {
                    "Pick a preset; the earbuds apply the curve instantly."
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            if (eqLocked) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            "Equalizer disabled",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Text(
                            "Dirac Opteo is unavailable while the LDAC/LHDC codec is on.\nTurn the codec off to use the equalizer.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            EqPreset.entries.forEach { preset ->
                EqPresetItem(
                    preset = preset,
                    isSelected = selectedPreset == preset,
                    enabled = !eqLocked,
                    onClick = {
                        selectedPreset = preset
                        onSetPreset(preset)
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
                        if (eqLocked) {
                            Text(
                                "Custom EQ is also part of Dirac Opteo and stays off while the codec is on.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )
                        } else if (isDirac) {
                            Text(
                                "The CMF Buds Pro 2's custom curve is a 3-band Dirac curve (wire format still being validated); picking Custom recalls the stored curve from the earbuds.",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant,
                                modifier = Modifier.padding(bottom = 12.dp)
                            )
                        }

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
                                    // Slider (vertical)
                                    EqBandSlider(
                                        value = customBands[index],
                                        enabled = !eqLocked,
                                        onValueChange = { newValue ->
                                            customBands = customBands.copyOf().also {
                                                it[index] = newValue
                                            }
                                        },
                                        onValueChangeFinished = {
                                            selectedPreset = EqPreset.CUSTOM
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
                                selectedPreset = EqPreset.CUSTOM
                                onSetCustomEq(customBands)
                            },
                            enabled = !eqLocked,
                            modifier = Modifier.align(Alignment.CenterHorizontally)
                        ) {
                            Text("Reset")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EqPresetItem(
    preset: EqPreset,
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
                    getPresetDisplayName(preset),
                    style = MaterialTheme.typography.titleSmall,
                    color = contentColor
                )
                Text(
                    getPresetDescription(preset),
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
    enabled: Boolean,
    onValueChange: (Int) -> Unit,
    onValueChangeFinished: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "${if (value > 0) "+" else ""}$value",
            style = MaterialTheme.typography.labelSmall,
            color = if (value != 0 && enabled) {
                NothingRed
            } else {
                MaterialTheme.colorScheme.onSurfaceVariant
            }
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
                enabled = enabled,
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
