package com.nothingbuds.calibration

import com.nothingbuds.protocol.AncMode
import kotlin.math.roundToInt

object CalibrationTones {
    val FREQUENCIES_HZ = listOf(250, 500, 1000, 2000, 4000, 8000)
    const val START_LEVEL = 0.3f
    const val MAX_LEVEL = 0.5f
    const val MIN_LEVEL = 0.02f
    const val STEP = 0.1f
    const val MAX_TRIALS = 8
    const val REQUIRED_REVERSALS = 3
}

class ThresholdTracker {
    var level: Float = CalibrationTones.START_LEVEL
        private set
    private var trials = 0
    private var reversals = 0
    private var lastDirection = 0
    private val reversalLevels = mutableListOf<Float>()

    val isDone: Boolean
        get() = reversals >= CalibrationTones.REQUIRED_REVERSALS || trials >= CalibrationTones.MAX_TRIALS

    val progressFraction: Float
        get() = (trials.toFloat() / CalibrationTones.MAX_TRIALS).coerceIn(0f, 1f)

    fun answer(heard: Boolean): Float {
        trials += 1
        val direction = if (heard) -1 else 1
        if (lastDirection != 0 && direction != lastDirection) {
            reversals += 1
            reversalLevels.add(level)
        }
        lastDirection = direction
        level = (level + direction * CalibrationTones.STEP)
            .coerceIn(CalibrationTones.MIN_LEVEL, CalibrationTones.MAX_LEVEL)
        return level
    }

    val threshold: Float
        get() = if (reversalLevels.isEmpty()) level
        else reversalLevels.takeLast(3).average().toFloat()
}

fun generateMyEq(thresholds: Map<Int, Float>): Triple<Int, Int, Int> {
    fun avg(vararg freqs: Int): Double =
        freqs.map { thresholds.getValue(it).toDouble() }.average()
    val bass = avg(250, 500)
    val mid = avg(1000, 2000)
    val treble = avg(4000, 8000)
    val reference = minOf(bass, mid, treble)
    fun gain(value: Double): Int =
        ((value - reference) * 20.0).roundToInt().coerceIn(0, 6)
    return Triple(gain(bass), gain(mid), gain(treble))
}

class CalibrationAncController(
    private val hasAnc: Boolean,
    private val set: (AncMode) -> Unit
) {
    private var saved: AncMode? = null
    var didSwitch = false
        private set

    fun begin(current: AncMode?): String? {
        if (!hasAnc) {
            return "This device has no Noise Control switching; the test continues without it."
        }
        saved = current
        set(AncMode.HIGH)
        didSwitch = true
        return null
    }

    fun finish() {
        if (didSwitch) {
            saved?.let(set)
            didSwitch = false
        }
    }
}

object SystemEq {
    sealed interface Status {
        data class Unsupported(val reason: String) : Status
    }

    fun status(): Status = Status.Unsupported(
        "No app-controllable system-level EQ path exists for Bluetooth output on this device."
    )
}

object NotificationPermission {
    const val PREF_ASKED = "notif_permission_asked"

    fun shouldRequest(sdkInt: Int, granted: Boolean, askedBefore: Boolean): Boolean =
        sdkInt >= 33 && !granted && !askedBefore

    fun resolveHubEnabled(granted: Boolean, userSet: Boolean, current: Boolean): Boolean =
        if (userSet) current else granted
}
