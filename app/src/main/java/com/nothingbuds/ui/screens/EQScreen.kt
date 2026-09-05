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
    onSetDiracEq: (Int) -> Unit,
    onBack: () -> Unit
) {
    var customBands by remember { mutableStateOf(state.customEq.copyOf()) }
    var selectedPreset by remember { mutableStateOf(state.eqPreset) }
    var selectedDirac by remember { mutableStateOf(state.diracEq) }

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
            // Dirac Opteo EQ is the equalizer for Dirac models (CMF Buds Pro 2 / CMF Buds). It is
            // mutually exclusive with the LHDC codec, so it is hidden while the codec is active.
            if (state.deviceModel?.hasDiracEq == true) {
                Text(
                    "Dirac Opteo",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                if (state.lhdc) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    ) {
                        Text(
                            "Unavailable while the LHDC codec is on. Turn it off under More to use the Dirac equalizer.",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                } else {
                    DIRAC_PRESETS.forEach { (level, label) ->
                        EqPresetItemGeneric(
                            label = label,
                            description = "Dirac Opteo preset",
                            isSelected = selectedDirac == level,
                            onClick = {
                                selectedDirac = level
                                onSetDiracEq(level)
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Preset selection for non-Dirac models (Dirac models only answer their own EQ).
            if (state.deviceModel?.hasDiracEq != true) {
                Text(
                    "Presets",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                EqPreset.entries.forEach { preset ->
                    EqPresetItem(
                        preset = preset,
                        isSelected = selectedPreset == preset,
                        onClick = {
                            selectedPreset = preset
                            onSetPreset(preset)
                        }
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }

            // Custom EQ
            if (state.deviceModel?.hasCustomEq == true && state.deviceModel?.hasDiracEq != true) {
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
                                    // Slider (vertical)
                                    EqBandSlider(
                                        value = customBands[index],
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EqPresetItem(
    preset: EqPreset,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                NothingRed.copy(alpha = 0.2f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isSelected,
                onClick = onClick,
                colors = RadioButtonDefaults.colors(
                    selectedColor = NothingRed
                )
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(
                    getPresetDisplayName(preset),
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    getPresetDescription(preset),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
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

        Slider(
            value = value.toFloat(),
            onValueChange = { onValueChange(it.toInt()) },
            onValueChangeFinished = onValueChangeFinished,
            valueRange = -6f..6f,
            steps = 11,
            modifier = Modifier
                .height(120.dp)
                .width(40.dp),
            colors = SliderDefaults.colors(
                thumbColor = NothingRed,
                activeTrackColor = NothingRed
            )
        )
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

/**
 * Dirac Opteo preset levels 0..5 (named) + 6 custom. The exact display names are model-specific
 * (recovered from the official app only as "Dirac Opteo"), so the numeric order is shown until a
 * per-model name table is recovered.
 */
private val DIRAC_PRESETS = listOf(
    0 to "Opteo preset 0",
    1 to "Opteo preset 1",
    2 to "Opteo preset 2",
    3 to "Opteo preset 3",
    4 to "Opteo preset 4",
    5 to "Opteo preset 5",
    6 to "Custom",
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EqPresetItemGeneric(
    label: String,
    description: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) {
                NothingRed.copy(alpha = 0.2f)
            } else {
                MaterialTheme.colorScheme.surface
            }
        ),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = isSelected,
                onClick = onClick,
                colors = RadioButtonDefaults.colors(
                    selectedColor = NothingRed
                )
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column {
                Text(label, style = MaterialTheme.typography.titleSmall)
                Text(
                    description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
