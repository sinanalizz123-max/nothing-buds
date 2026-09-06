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
import com.nothingbuds.calibration.CalibrationAncController
import com.nothingbuds.calibration.CalibrationTones
import com.nothingbuds.calibration.SystemEq
import com.nothingbuds.calibration.ThresholdTracker
import com.nothingbuds.calibration.TonePlayer
import com.nothingbuds.calibration.generateMyEq
import androidx.compose.ui.graphics.Color
import com.nothingbuds.data.EarbudsState
import com.nothingbuds.protocol.AncMode
import com.nothingbuds.ui.components.GlassButton
import com.nothingbuds.ui.components.ProgressRing
import com.nothingbuds.ui.theme.GlassScreenRoot

private enum class CalibrationStep { INSTRUCTIONS, TESTING, RESULT }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalibrationScreen(
    state: EarbudsState,
    onSetAncMode: (AncMode) -> Unit,
    onSetDiracCustomEq: (Int, Int, Int) -> Unit,
    onSaveMyEq: (Int, Int, Int) -> Unit,
    onApplyMyEq: () -> Unit,
    onBack: () -> Unit
) {
    var step by remember { mutableStateOf(CalibrationStep.INSTRUCTIONS) }
    var freqIndex by remember { mutableStateOf(0) }
    var tracker by remember { mutableStateOf(ThresholdTracker()) }
    var trialProgress by remember { mutableStateOf(0f) }
    var thresholds by remember { mutableStateOf(mapOf<Int, Float>()) }
    var ancNotice by remember { mutableStateOf<String?>(null) }
    var failure by remember { mutableStateOf<String?>(null) }
    var applied by remember { mutableStateOf(false) }
    val player = remember { TonePlayer() }
    val hasAnc = state.deviceModel?.hasAnc != false
    val ancController = remember {
        CalibrationAncController(hasAnc = hasAnc, set = onSetAncMode)
    }
    val isDiracCustom = state.deviceModel?.hasDiracEq == true &&
        state.deviceModel?.hasCustomEq == true

    DisposableEffect(Unit) {
        onDispose {
            player.stop()
            ancController.finish()
        }
    }

    fun stopTest() {
        player.stop()
        ancController.finish()
        onBack()
    }

    fun advanceTest() {
        val freqs = CalibrationTones.FREQUENCIES_HZ
        val freq = freqs[freqIndex]
        if (tracker.isDone) {
            thresholds = thresholds + (freq to tracker.threshold)
            if (freqIndex + 1 >= freqs.size) {
                player.stop()
                ancController.finish()
                step = CalibrationStep.RESULT
            } else {
                freqIndex += 1
                tracker = ThresholdTracker()
                trialProgress = 0f
            }
        } else {
            player.setVolume(tracker.level)
        }
    }

    GlassScreenRoot {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Personal Sound Calibration") },
                navigationIcon = {
                    IconButton(onClick = { stopTest() }) {
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (step) {
                CalibrationStep.INSTRUCTIONS -> {
                    Text(
                        "Experimental",
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Before you begin:",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    val instructions = listOf(
                        "Find a quiet place.",
                        "Wear the earbuds normally and make sure they fit properly.",
                        "Keep environmental noise as low as possible.",
                        "This is an experimental listening calibration, NOT a medical hearing test.",
                        "Results can vary depending on the earbuds, fit, volume, environment, and phone.",
                        "The feature may not work correctly on every device/earbud model."
                    )
                    instructions.forEach { line ->
                        Text(
                            "•  $line",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        GlassButton(text = "Cancel", primary = false, onClick = onBack)
                        GlassButton(text = "Continue", primary = true, onClick = {
                            ancNotice = ancController.begin(state.ancMode)
                            freqIndex = 0
                            tracker = ThresholdTracker()
                            thresholds = emptyMap()
                            applied = false
                            failure = null
                            trialProgress = 0f
                            step = CalibrationStep.TESTING
                        })
                    }
                }

                CalibrationStep.TESTING -> {
                    val freqs = CalibrationTones.FREQUENCIES_HZ
                    val freq = freqs[freqIndex]
                    ancNotice?.let {
                        Text(
                            it,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    ProgressRing(
                        progress = trialProgress,
                        centerText = "$freq",
                        unit = "Hz"
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Frequency ${freqIndex + 1} of ${freqs.size}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Can you hear the tone?",
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Center
                    )
                    LaunchedEffect(freqIndex) {
                        try {
                            player.play(freq, tracker.level)
                        } catch (e: Exception) {
                            failure = "Could not play the test tone (${e.message}). Stopping safely."
                        }
                    }
                    failure?.let {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            it,
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        GlassButton(
                            text = "I Hear It",
                            primary = true,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                tracker.answer(heard = true)
                                trialProgress = tracker.progressFraction
                                advanceTest()
                            }
                        )
                        GlassButton(
                            text = "I Don't Hear It",
                            primary = false,
                            modifier = Modifier.weight(1f),
                            onClick = {
                                tracker.answer(heard = false)
                                trialProgress = tracker.progressFraction
                                advanceTest()
                            }
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    GlassButton(
                        text = "Stop Test",
                        primary = false,
                        onClick = { stopTest() }
                    )
                }

                CalibrationStep.RESULT -> {
                    val (bass, mid, treble) = generateMyEq(thresholds)
                    Text("My EQ", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        "Experimental listening profile. Preview it before applying.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    MyEqValueRow("Bass", bass)
                    MyEqValueRow("Mid", mid)
                    MyEqValueRow("Treble", treble)
                    Spacer(modifier = Modifier.height(16.dp))
                    val systemEq = SystemEq.status() as SystemEq.Status.Unsupported
                    Text(
                        "System EQ: not supported on this device. ${systemEq.reason}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    if (!isDiracCustom) {
                        Text(
                            "This device has no supported Buds Custom path for My EQ, " +
                                "so it can only be previewed here.",
                            color = MaterialTheme.colorScheme.error,
                            textAlign = TextAlign.Center
                        )
                    } else if (!applied) {
                        GlassButton(
                            text = "Apply to Buds EQ",
                            primary = true,
                            onClick = {
                                onSaveMyEq(bass, mid, treble)
                                onApplyMyEq()
                                applied = true
                            }
                        )
                    } else {
                        Text(
                            "Applied to Buds EQ. Find it as My EQ in the Equalizer.",
                            color = MaterialTheme.colorScheme.tertiary,
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    GlassButton(text = "Done", primary = false, onClick = onBack)
                }
            }
        }
        }
    }
    }
}

@Composable
private fun MyEqValueRow(label: String, value: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, style = MaterialTheme.typography.bodyLarge)
        Text(
            "${if (value > 0) "+" else ""}$value",
            style = MaterialTheme.typography.titleMedium
        )
    }
    Spacer(modifier = Modifier.height(4.dp))
}
