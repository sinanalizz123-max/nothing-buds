package com.nothingbuds.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import com.kyant.backdrop.backdrops.LayerBackdrop
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.DiracEqPreset
import com.nothingbuds.protocol.EqPreset
import com.nothingbuds.ui.components.EqDragSlider
import com.nothingbuds.ui.theme.LiquidTheme
import com.nothingbuds.ui.theme.LocalAppBackdrop
import com.nothingbuds.ui.theme.glassCard
import com.nothingbuds.ui.theme.kyantDialogGlass
import com.nothingbuds.ui.theme.liquidGlass
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

private val DIRAC_BAND_LABELS = listOf("Bass", "Mid", "Treble")

private val EQ_FREQUENCY_LABELS = listOf("60", "150", "400", "1k", "2.4k", "6k", "10k", "16k")

private val REGULAR_EQ_PRESETS = EqPreset.entries.filter { it != EqPreset.CUSTOM }

@Composable
fun EqPopupOverlay(
    state: EarbudsState,
    onSetPreset: (EqPreset) -> Unit,
    onSetDiracEq: (Int) -> Unit,
    onSetCustomEq: (IntArray) -> Unit,
    onSetDiracCustomEq: (Int, Int, Int) -> Unit,
    onApplyMyEq: () -> Unit,
    onDismiss: () -> Unit,
    backdrop: LayerBackdrop? = LocalAppBackdrop.current,
) {
    var shown by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) { shown = true }
    val scale by animateFloatAsState(
        targetValue = if (shown) 1f else 0.92f,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 400f),
        label = "popupScale"
    )
    val alpha by animateFloatAsState(
        targetValue = if (shown) 1f else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "popupAlpha"
    )
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.35f * alpha))
            .clickable(onClick = onDismiss),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .wrapContentHeight()
                .heightIn(max = maxHeight * 0.8f)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                    this.alpha = alpha
                }
                .then(
                    if (backdrop != null) Modifier.kyantDialogGlass(backdrop)
                    else Modifier
                ),
            colors = CardDefaults.cardColors(
                containerColor = if (backdrop != null) Color.Transparent else MaterialTheme.colorScheme.surfaceContainer
            ),
            shape = RoundedCornerShape(28.dp),
            border = if (LocalAppBackdrop.current != null)
                BorderStroke(1.dp, LiquidTheme.GlassBorder) else null,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Equalizer",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                EqSelectorContent(
                    state = state,
                    onSetPreset = onSetPreset,
                    onSetDiracEq = onSetDiracEq,
                    onSetCustomEq = onSetCustomEq,
                    onSetDiracCustomEq = onSetDiracCustomEq,
                    onApplyMyEq = onApplyMyEq
                )
            }
        }
    }
}

@Composable
private fun EqSelectorContent(
    state: EarbudsState,
    onSetPreset: (EqPreset) -> Unit,
    onSetDiracEq: (Int) -> Unit,
    onSetCustomEq: (IntArray) -> Unit,
    onSetDiracCustomEq: (Int, Int, Int) -> Unit,
    onApplyMyEq: () -> Unit
) {
    var customBands by remember { mutableStateOf(state.customEq.copyOf()) }
    var diracBands by remember { mutableStateOf(state.diracCustomEq.copyOf()) }
    val isDirac = state.deviceModel?.hasDiracEq == true
    var showDiracUnavailable by remember { mutableStateOf(false) }
    val myEqShown = showMyEqTile(isDirac, state.calibrationEnabled, state.myEq)
    val showCustomEditor = state.deviceModel?.hasCustomEq == true &&
        ((isDirac && DiracEqPreset.fromLevel(state.diracEq) == DiracEqPreset.CUSTOM) ||
            (!isDirac && state.eqPreset == EqPreset.CUSTOM))

    Column(modifier = Modifier.fillMaxWidth()) {
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
                    tiles = diracRegularRowOrder.map { preset ->
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
                EqTileGrid(
                    tiles = REGULAR_EQ_PRESETS.map { preset ->
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

            // Custom EQ editor shows only while the Custom preset is selected.
            if (showCustomEditor) {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    "Custom EQ",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .then(
                            LocalAppBackdrop.current?.let { Modifier.liquidGlass(it, LiquidTheme.CardShape) }
                                ?: Modifier
                        ),
                    colors = CardDefaults.cardColors(
                        containerColor = if (LocalAppBackdrop.current != null) Color.Transparent
                        else MaterialTheme.colorScheme.surfaceContainer
                    ),
                    border = if (LocalAppBackdrop.current != null)
                BorderStroke(1.dp, LiquidTheme.GlassBorder) else null,
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        if (isDirac) {
                            // Dirac Custom is exactly 3 bands (Bass/Mid/Treble, -6..+6),
                            // written through SET_CUSTOM_EQ (0xF041).

                            if (LocalAppBackdrop.current == null) {
                                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                    DIRAC_BAND_LABELS.forEachIndexed { index, label ->
                                        EqBandRow(
                                            label = label,
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
                                    }
                                }
                            } else
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly
                            ) {
                                DIRAC_BAND_LABELS.forEachIndexed { index, label ->
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

                        if (LocalAppBackdrop.current == null) {
                            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                EQ_FREQUENCY_LABELS.forEachIndexed { index, freq ->
                                    EqBandRow(
                                        label = freq,
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
                                }
                            }
                        } else
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            EQ_FREQUENCY_LABELS.forEachIndexed { index, freq ->
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

    if (showDiracUnavailable) {
        AlertDialog(
            onDismissRequest = { showDiracUnavailable = false },
            containerColor = if (LocalAppBackdrop.current != null) LiquidTheme.DialogBg
            else MaterialTheme.colorScheme.surfaceContainer,
            confirmButton = {
                TextButton(onClick = { showDiracUnavailable = false }) { Text("OK") }
            },
            title = { Text("Dirac unavailable") },
            text = { Text("Dirac is unavailable while the LDAC/LHDC codec is on. Turn the codec off to use Dirac; the other presets are unaffected.") }
        )
    }
}

@Composable
private fun EqBandRow(
    label: String,
    value: Int,
    onValueChange: (Int) -> Unit,
    onValueChangeFinished: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(56.dp)
        )
        Slider(
            value = value.toFloat(),
            onValueChange = { onValueChange(it.toInt()) },
            onValueChangeFinished = onValueChangeFinished,
            valueRange = -6f..6f,
            steps = 11,
            modifier = Modifier.weight(1f)
        )
        Text(
            "${if (value > 0) "+" else ""}$value",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(40.dp),
            textAlign = TextAlign.End
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
            .then(
                LocalAppBackdrop.current?.let { Modifier.liquidGlass(it, LiquidTheme.CardShape) }
                    ?: Modifier
            ),
        colors = CardDefaults.cardColors(
            containerColor = if (LocalAppBackdrop.current != null) Color.Transparent
            else if (isSelected) MaterialTheme.colorScheme.primaryContainer
            else MaterialTheme.colorScheme.surfaceContainer
        ),
        border = if (LocalAppBackdrop.current != null) BorderStroke(
            1.dp,
            if (isSelected) LiquidTheme.Accent else LiquidTheme.GlassBorder
        ) else null,
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
                color = if (isSelected) {
                    if (LocalAppBackdrop.current != null) LiquidTheme.Accent
                    else MaterialTheme.colorScheme.onPrimaryContainer
                } else MaterialTheme.colorScheme.onSurface,
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

internal val diracRegularRowOrder = diracRowOrder.filter { it != DiracEqPreset.CUSTOM }
