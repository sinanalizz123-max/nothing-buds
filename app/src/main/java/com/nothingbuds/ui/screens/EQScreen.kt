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
import androidx.compose.foundation.BorderStroke
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.DiracEqPreset
import com.nothingbuds.protocol.EqPreset
import com.nothingbuds.ui.components.EqDragSlider
import com.nothingbuds.ui.theme.AmbientBackground
import com.nothingbuds.ui.theme.LiquidTheme
import com.nothingbuds.ui.theme.glassCard
import kotlin.math.roundToInt

internal fun eqTileColumns(maxWidthDp: Int): Int = (maxWidthDp / 112).coerceIn(2, 4)

internal fun showMyEqTile(isDirac: Boolean, calibrationEnabled: Boolean, myEq: IntArray?): Boolean =
    isDirac && calibrationEnabled && myEq != null

internal fun eqRowSubtitle(
    isDirac: Boolean,
    diracEq: Int,
    eqPresetName: String,
    myEqShown: Boolean
): String = when {
    myEqShown -> "My EQ"
    isDirac -> DiracEqPreset.fromLevel(diracEq).displayName
    else -> eqPresetName
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EQScreen(
    state: EarbudsState,
    onSetPreset: (EqPreset) -> Unit,
    onSetDiracEq: (Int) -> Unit,
    onSetCustomEq: (IntArray) -> Unit,
    onSetDiracCustomEq: (Int, Int, Int) -> Unit,
    onApplyMyEq: () -> Unit,
    onBack: () -> Unit
) {
    var customBands by remember { mutableStateOf(state.customEq.copyOf()) }
    var diracBands by remember { mutableStateOf(state.diracCustomEq.copyOf()) }
    val isDirac = state.deviceModel?.hasDiracEq == true
    var showDiracUnavailable by remember { mutableStateOf(false) }
    val myEqShown = showMyEqTile(isDirac, state.calibrationEnabled, state.myEq)

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
        },
        containerColor = Color.Transparent
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            AmbientBackground()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Text(
                "Pick a preset; the earbuds apply the curve instantly.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(bottom = 12.dp)
            )

            if (isDirac) {
                // One EQ list on Dirac-capable models (B172/B168): Dirac is simply the
                // first preset. Every row writes through SET_DIRAC_EQ (0xF01D).
                val selected = DiracEqPreset.fromLevel(state.diracEq)
                EqTileGrid(
                    tiles = diracRowOrder.filter { it != DiracEqPreset.CUSTOM }.map { preset ->
                        EqTileData(
                            label = diracRowName(preset),
                            description = getDiracPresetDescription(preset),
                            isSelected = selected == preset,
                            onClick = {
                                if (preset == DiracEqPreset.OPTEO && state.lhdc) {
                                    // Matches the official app: tapping Dirac while LDAC is on
                                    // shows the "…is unavailable while LDAC is on" dialog and does
                                    // not send anything to the earbuds.
                                    showDiracUnavailable = true
                                } else {
                                    onSetDiracEq(preset.type)
                                }
                            }
                        )
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    EqPresetTile(
                        label = diracRowName(DiracEqPreset.CUSTOM),
                        description = getDiracPresetDescription(DiracEqPreset.CUSTOM),
                        isSelected = selected == DiracEqPreset.CUSTOM && !state.myEqActive,
                        onClick = { onSetDiracEq(DiracEqPreset.CUSTOM.type) },
                        modifier = Modifier.weight(if (myEqShown) 2f else 1f)
                    )
                    if (myEqShown) {
                        EqPresetTile(
                            label = "My EQ",
                            description = "Your calibration profile",
                            isSelected = state.myEqActive,
                            onClick = onApplyMyEq,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            } else {
                val regular = EqPreset.entries.filter { it != EqPreset.CUSTOM }
                EqTileGrid(
                    tiles = regular.map { preset ->
                        EqTileData(
                            label = getPresetDisplayName(preset),
                            description = getPresetDescription(preset),
                            isSelected = state.eqPreset == preset,
                            onClick = { onSetPreset(preset) }
                        )
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                EqPresetTile(
                    label = getPresetDisplayName(EqPreset.CUSTOM),
                    description = getPresetDescription(EqPreset.CUSTOM),
                    isSelected = state.eqPreset == EqPreset.CUSTOM,
                    onClick = { onSetPreset(EqPreset.CUSTOM) },
                    modifier = Modifier.fillMaxWidth()
                )
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
                    modifier = Modifier
                        .fillMaxWidth()
                        .glassCard(),
                    colors = CardDefaults.cardColors(
                        containerColor = LiquidTheme.GlassBg
                    ),
                    border = BorderStroke(1.dp, LiquidTheme.GlassBorder),
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
                                        EqDragSlider(
                                            value = diracBands[index],
                                            onValueChange = { newValue ->
                                                diracBands = diracBands.copyOf().also {
                                                    it[index] = newValue
                                                }
                                            },
                                            onValueChangeFinished = {
                                                onSetDiracCustomEq(diracBands[0], diracBands[1], diracBands[2])
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
                                    diracBands = IntArray(3) { 0 }
                                    onSetDiracCustomEq(0, 0, 0)
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
                                        EqDragSlider(
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
        }
    }

    if (showDiracUnavailable) {
        AlertDialog(
            onDismissRequest = { showDiracUnavailable = false },
            containerColor = LiquidTheme.DialogBg,
            confirmButton = {
                TextButton(onClick = { showDiracUnavailable = false }) { Text("OK") }
            },
            title = { Text("Dirac unavailable") },
            text = { Text("Dirac is unavailable while the LDAC/LHDC codec is on. Turn the codec off to use Dirac; the other presets are unaffected.") }
        )
    }
}

private data class EqTileData(
    val label: String,
    val description: String,
    val isSelected: Boolean,
    val onClick: () -> Unit
)

@Composable
private fun EqTileGrid(tiles: List<EqTileData>) {
    BoxWithConstraints(modifier = Modifier.fillMaxWidth()) {
        val columns = eqTileColumns(maxWidth.value.roundToInt())
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            tiles.chunked(columns).forEach { row ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    row.forEach { tile ->
                        EqPresetTile(
                            label = tile.label,
                            description = tile.description,
                            isSelected = tile.isSelected,
                            onClick = tile.onClick,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    repeat(columns - row.size) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
private fun EqPresetTile(
    label: String,
    description: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .padding(vertical = 0.dp)
            .glassCard(),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) LiquidTheme.AccentGlow
            else LiquidTheme.GlassBg
        ),
        border = BorderStroke(
            1.dp,
            if (isSelected) LiquidTheme.Accent else LiquidTheme.GlassBorder
        ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                label,
                style = MaterialTheme.typography.titleSmall,
                color = if (isSelected) LiquidTheme.Accent else MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                description,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
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
