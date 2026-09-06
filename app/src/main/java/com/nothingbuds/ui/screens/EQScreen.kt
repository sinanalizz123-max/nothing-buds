package com.nothingbuds.ui.screens

import android.util.Log
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
    onSetPreset: (EqPreset, String) -> Unit,
    onSetDiracEq: (Int, String) -> Unit,
    onSetCustomEq: (IntArray, String) -> Unit,
    onSetDiracCustomEq: (Int, Int, Int, String) -> Unit,
    onBack: () -> Unit
) {
    var customBands by remember { mutableStateOf(state.customEq.copyOf()) }
    var diracBands by remember { mutableStateOf(state.diracCustomEq.copyOf()) }
    val isDirac = state.deviceModel?.hasDiracEq == true
    var showDiracUnavailable by remember { mutableStateOf(false) }
    var eqActionSeq by remember { mutableStateOf(0) }
    fun nextAid(): String {
        eqActionSeq += 1
        return "A$eqActionSeq"
    }
    val selectedLabel = if (isDirac) {
        diracRowName(DiracEqPreset.fromLevel(state.diracEq))
    } else {
        getPresetDisplayName(state.eqPreset)
    }
    val customVisible = state.deviceModel?.hasCustomEq == true &&
        (!isDirac || DiracEqPreset.fromLevel(state.diracEq) == DiracEqPreset.CUSTOM)

    LaunchedEffect(Unit) {
        Log.d("EQ_UI", "[EQ_UI] screen opened model=${state.deviceModel?.id} " +
            "diracCapable=$isDirac eqPreset=${state.eqPreset} diracEq=${state.diracEq} " +
            "selected=$selectedLabel")
    }
    DisposableEffect(Unit) {
        onDispose {
            Log.d("EQ_UI", "[EQ_UI] screen leaves model=${state.deviceModel?.id}")
        }
    }
    LaunchedEffect(selectedLabel) {
        Log.d("EQ_UI", "[EQ_UI] UI selection updated=$selectedLabel")
    }
    LaunchedEffect(customVisible) {
        Log.d("EQ_UI", "[EQ_UI] Custom panel visible=$customVisible")
    }

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
                "Pick a preset; the earbuds apply the curve instantly.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            if (isDirac) {
                // One EQ list on Dirac-capable models (B172/B168): Dirac is simply the
                // first preset. Every row writes through SET_DIRAC_EQ (0xF01D).
                diracRowOrder.forEach { preset ->
                    EqPresetRow(
                        name = diracRowName(preset),
                        description = getDiracPresetDescription(preset),
                        isSelected = DiracEqPreset.fromLevel(state.diracEq) == preset,
                        enabled = true,
                        onClick = {
                            val aid = nextAid()
                            val prev = DiracEqPreset.fromLevel(state.diracEq)
                            val index = diracRowOrder.indexOf(preset)
                            Log.d("EQ_UI", "[EQ][$aid] User selected ${diracRowName(preset)}")
                            Log.d("EQ_UI", "[EQ][$aid] previous=${diracRowName(prev)} " +
                                "requested=${diracRowName(preset)} type=${preset.type} " +
                                "index=$index changed=${prev != preset}")
                            if (preset == DiracEqPreset.OPTEO && state.lhdc) {
                                // Matches the official app: tapping Dirac while LDAC is on
                                // shows the "…is unavailable while LDAC is on" dialog and does not
                                // send anything to the earbuds.
                                Log.d("EQ_UI", "[EQ][$aid] Dirac row blocked by LDAC (no TX)")
                                showDiracUnavailable = true
                            } else {
                                onSetDiracEq(preset.type, aid)
                            }
                        }
                    )
                }
            } else {
                EqPreset.entries.forEach { preset ->
                    EqPresetRow(
                        name = getPresetDisplayName(preset),
                        description = getPresetDescription(preset),
                        isSelected = state.eqPreset == preset,
                        enabled = true,
                        onClick = {
                            val aid = nextAid()
                            val index = EqPreset.entries.indexOf(preset)
                            Log.d("EQ_UI", "[EQ][$aid] User selected ${getPresetDisplayName(preset)}")
                            Log.d("EQ_UI", "[EQ][$aid] previous=${getPresetDisplayName(state.eqPreset)} " +
                                "requested=${getPresetDisplayName(preset)} " +
                                "index=$index changed=${state.eqPreset != preset}")
                            onSetPreset(preset, aid)
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Custom EQ
            if (state.deviceModel?.hasCustomEq == true &&
                (!isDirac || DiracEqPreset.fromLevel(state.diracEq) == DiracEqPreset.CUSTOM)
            ) {
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
                        if (isDirac) {
                            // Dirac Custom is exactly 3 bands (Bass/Mid/Treble, -6..+6),
                            // written through SET_CUSTOM_EQ (0xF041).
                            val diracLabels = listOf("Bass", "Mid", "Treble")

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                diracLabels.forEachIndexed { index, label ->
                                    Column(
                                        modifier = Modifier.weight(1f),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        EqBandSlider(
                                            value = diracBands[index],
                                            onValueChange = { newValue ->
                                                val old = diracBands[index]
                                                diracBands = diracBands.copyOf().also {
                                                    it[index] = newValue
                                                }
                                                Log.d("EQ_UI", "[EQ_UI] Dirac Custom $label: $old -> $newValue " +
                                                    "current={bass=${diracBands[0]},mid=${diracBands[1]},treble=${diracBands[2]}} " +
                                                    "atLimit=${newValue == 6 || newValue == -6}")
                                            },
                                            onValueChangeFinished = {
                                                val aid = nextAid()
                                                Log.d("EQ_UI", "[EQ][$aid] Dirac Custom action " +
                                                    "current={bass=${diracBands[0]},mid=${diracBands[1]},treble=${diracBands[2]}}")
                                                onSetDiracCustomEq(diracBands[0], diracBands[1], diracBands[2], aid)
                                            }
                                        )

                                        Spacer(modifier = Modifier.height(8.dp))

                                        Text(
                                            label,
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                                            textAlign = TextAlign.Center
                                        )
                                    }
                                }
                            }

                            Spacer(modifier = Modifier.height(16.dp))

                            OutlinedButton(
                                onClick = {
                                    val aid = nextAid()
                                    diracBands = IntArray(3) { 0 }
                                    Log.d("EQ_UI", "[EQ][$aid] Dirac Custom reset current={bass=0,mid=0,treble=0}")
                                    onSetDiracCustomEq(0, 0, 0, aid)
                                },
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            ) {
                                Text("Reset")
                            }
                        } else {
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
                                                val old = customBands[index]
                                                customBands = customBands.copyOf().also {
                                                    it[index] = newValue
                                                }
                                                Log.d("EQ_UI", "[EQ_UI] Advanced Custom band $index ($freq): " +
                                                    "$old -> $newValue atLimit=${newValue == 6 || newValue == -6}")
                                            },
                                            onValueChangeFinished = {
                                                val aid = nextAid()
                                                Log.d("EQ_UI", "[EQ][$aid] Advanced Custom action " +
                                                    "current={${customBands.joinToString()}}")
                                                onSetCustomEq(customBands, aid)
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
                                    val aid = nextAid()
                                    customBands = IntArray(8) { 0 }
                                    Log.d("EQ_UI", "[EQ][$aid] Advanced Custom reset")
                                    onSetCustomEq(customBands, aid)
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

    if (showDiracUnavailable) {
        AlertDialog(
            onDismissRequest = { showDiracUnavailable = false },
            confirmButton = {
                TextButton(onClick = { showDiracUnavailable = false }) { Text("OK") }
            },
            title = { Text("Dirac unavailable") },
            text = { Text("Dirac is unavailable while the LDAC/LHDC codec is on. Turn the codec off to use Dirac; the other presets are unaffected.") }
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

private fun diracRowName(preset: DiracEqPreset): String =
    if (preset == DiracEqPreset.OPTEO) "Dirac" else preset.displayName

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

/** One EQ list on Dirac-capable models: Dirac first, then the genre presets. */
internal val diracRowOrder = listOf(
    DiracEqPreset.OPTEO,
    DiracEqPreset.POP,
    DiracEqPreset.ROCK,
    DiracEqPreset.CLASSICAL,
    DiracEqPreset.ELECTRONIC,
    DiracEqPreset.ENHANCE_VOCALS,
    DiracEqPreset.CUSTOM
)