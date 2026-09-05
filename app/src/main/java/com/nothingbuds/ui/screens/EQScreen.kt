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
    onSetDiracEq: (Int) -> Unit,
    onBack: () -> Unit
) {
    var customBands by remember { mutableStateOf(state.customEq.copyOf()) }
    var selectedPreset by remember { mutableStateOf(state.eqPreset) }
    var diracEnabled by remember { mutableStateOf(state.diracEq >= 1) }

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
            // Dirac Opteo is just another EQ mode for Dirac models (CMF Buds Pro 2 / CMF Buds): one of the
            // radio entries below, selected at a time. It is greyed out while the LDAC codec is on.
            Text(
                "Equalizer",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            EqPreset.entries.forEach { preset ->
                EqPresetItem(
                    preset = preset,
                    isSelected = selectedPreset == preset && !diracEnabled,
                    onClick = {
                        diracEnabled = false
                        selectedPreset = preset
                        onSetPreset(preset)
                    }
                )
            }

            if (state.deviceModel?.hasDiracEq == true) {
                if (state.lhdc) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = false,
                                onClick = null,
                                enabled = false
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(
                                    "Dirac Opteo",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Text(
                                    "Disabled while the LDAC codec is on",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                } else {
                    EqPresetItemGeneric(
                        label = "Dirac Opteo",
                        description = "One of the equalizer modes",
                        isSelected = diracEnabled,
                        onClick = {
                            diracEnabled = true
                            onSetDiracEq(1)
                        }
                    )
                }
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
                                    // Slider (vertical)
                                    EqBandSlider(
                                        value = customBands[index],
                                        onValueChange = { newValue ->
                                            customBands = customBands.copyOf().also {
                                                it[index] = newValue
                                            }
                                        },
                                        onValueChangeFinished = {
                                            diracEnabled = false
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
                                diracEnabled = false
                                selectedPreset = EqPreset.CUSTOM
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
                    activeTrackColor = NothingRed
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
