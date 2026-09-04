package com.nothingbuds.model

import com.nothingbuds.entities.Gesture

/**
 * Per-model capability database, recovered from the Nothing X decompile (DEVICE_TYPE/pid list)
 * and the independent ear-web cross-reference. Used to gate which features/gestures/EQ the UI shows
 * for the connected product.
 *
 * pid -> product from re/findings-deep-dive.md §2 + re/ear-web-cross-reference.md §13.
 * NOTE: capabilities marked with `null` for known-unknown features; the UI hides unsupported rows.
 */
data class ModelCapabilities(
    val pid: String,
    val name: String,
    val anc: Boolean = false,
    val baselineAnc: Boolean = false,       // has ANC, but no smart/personalized
    val smartAnc: Boolean = false,
    val personalizedAnc: Boolean = false,
    val eq: Boolean = false,
    val advancedEq: Boolean = false,
    val customEq: Boolean = false,          // 3-band custom (±6 dB)
    val diracEq: Boolean = false,           // uses 0xC050/0xF01D listening-mode EQ
    val spatial: Boolean = false,
    val game: Boolean = false,
    val wearDetect: Boolean = false,
    val dualDevice: Boolean = false,
    val volume: Boolean = false,
    val autoPowerOff: Boolean = false,
    val boxLed: Boolean = false,            // case LED control
    val mimi: Boolean = false,
    val lhdc: Boolean = false,
    val highVolumeGain: Boolean = false,
    val bassBoost: Boolean = false,
    val bassEnhancer: Boolean = false,
    val findEar: Boolean = true,
    val fitTest: Boolean = false,
    val caseControl: Boolean = false,
    val caseGestures: List<String> = emptyList(),
    val gestureTypes: Set<Int> = emptySet(),
    val gestureOps: Map<Int, List<Int>> = emptyMap(), // gestureType -> allowed operation ids
    val ancModes: List<Int> = emptyList()    // wire bytes
)

object ModelDatabase {
    private const val E1 = 0x01
    private const val MID = 0x02
    private const val LOW = 0x03
    private const val ADAP = 0x04
    private const val OFF = 0x05
    private const val TRANS = 0x07

    private val fullAnc = listOf(OFF, TRANS, LOW, E1, MID, ADAP)
    private val simpleAnc = listOf(OFF, LOW, E1)

    private val commonGestures =
        Gesture.TYPE_DOUBLE to listOf(Gesture.OP_VOLUME_DOWN, Gesture.OP_VOLUME_UP, Gesture.OP_SKIP_BACK, Gesture.OP_SKIP_FORWARD, Gesture.OP_VOICE)

    private val models = mapOf(
        "B181" to ModelCapabilities(  // Nothing Ear (1)
            pid = "B181", name = "Nothing Ear (1)",
            anc = true, eq = true, game = true, wearDetect = true,
            findEar = true, boxLed = true, autoPowerOff = true, volume = true,
            ancModes = fullAnc,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD)
        ),
        "B157" to ModelCapabilities(  // Ear (stick)
            pid = "B157", name = "Nothing Ear (stick)",
            eq = false, autoPowerOff = true, findEar = true,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD),
            caseControl = true, caseGestures = listOf("Double tap", "Squeeze")
        ),
        "B155" to ModelCapabilities(  // Ear (2)
            pid = "B155", name = "Nothing Ear (2)",
            anc = true, personalizedAnc = true, eq = true, advancedEq = true, customEq = true,
            game = true, wearDetect = true, dualDevice = true, volume = true,
            autoPowerOff = true, lhdc = true, fitTest = true, findEar = true,
            bassBoost = true, ancModes = fullAnc,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD, Gesture.TYPE_DOUBLE_PRESS_HOLD),
            gestureOps = mapOf(
                Gesture.TYPE_DOUBLE to listOf(8, 9, 11),
                Gesture.TYPE_TRIPLE to listOf(8, 9, 11),
                Gesture.TYPE_PRESS_HOLD to listOf(1, 10, 18, 19, 11, 20, 21, 22),
                Gesture.TYPE_DOUBLE_PRESS_HOLD to listOf(1, 10, 18, 19, 11, 20, 21, 22)
            ),
            caseControl = true, caseGestures = listOf("Double tap", "Press & hold")
        ),
        "B162" to ModelCapabilities(  // Ear (a)
            pid = "B162", name = "Nothing Ear (a)",
            anc = true, eq = true, advancedEq = true, customEq = true, game = true,
            wearDetect = true, autoPowerOff = true, findEar = true, bassBoost = true,
            lhdc = true, ancModes = fullAnc,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD, Gesture.TYPE_DOUBLE_PRESS_HOLD),
            gestureOps = mapOf(
                Gesture.TYPE_DOUBLE to listOf(8, 9, 11),
                Gesture.TYPE_TRIPLE to listOf(8, 9, 11),
                Gesture.TYPE_PRESS_HOLD to listOf(1, 10, 18, 19, 11, 20, 21, 22),
                Gesture.TYPE_DOUBLE_PRESS_HOLD to listOf(1, 10, 18, 19, 11, 20, 21, 22)
            )
        ),
        "B163" to ModelCapabilities(  // CMF Buds Pro
            pid = "B163", name = "CMF Buds Pro",
            anc = true, eq = true, advancedEq = true, customEq = true,
            wearDetect = true, autoPowerOff = true, findEar = true, ancModes = fullAnc
        ),
        "B164" to ModelCapabilities(  // CMF Neckband Pro
            pid = "B164", name = "CMF Neckband Pro",
            anc = true, eq = true, findEar = true, ancModes = simpleAnc
        ),
        "B168" to ModelCapabilities(  // CMF Buds
            pid = "B168", name = "CMF Buds",
            anc = true, eq = true, diracEq = true, customEq = true,
            game = true, wearDetect = true, autoPowerOff = true, findEar = true,
            bassBoost = true, bassEnhancer = true, ancModes = fullAnc,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD, Gesture.TYPE_DOUBLE_PRESS_HOLD),
            gestureOps = mapOf(
                Gesture.TYPE_DOUBLE to listOf(8, 9, 11),
                Gesture.TYPE_TRIPLE to listOf(8, 9, 11),
                Gesture.TYPE_PRESS_HOLD to listOf(1, 10, 18, 19, 11, 20, 21, 22),
                Gesture.TYPE_DOUBLE_PRESS_HOLD to listOf(1, 10, 18, 19, 11, 20, 21, 22)
            )
        ),
        "B171" to ModelCapabilities(  // Nothing Ear (2024)
            pid = "B171", name = "Nothing Ear (2024)",
            anc = true, smartAnc = true, eq = true, advancedEq = true, customEq = true,
            spatial = true, game = true, wearDetect = true, dualDevice = true, volume = true,
            autoPowerOff = true, lhdc = true, mimi = true, findEar = true, fitTest = true,
            bassBoost = true, bassEnhancer = true,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD),
            gestureOps = mapOf(
                Gesture.TYPE_DOUBLE to listOf(8, 9, 11),
                Gesture.TYPE_TRIPLE to listOf(8, 9, 11),
                Gesture.TYPE_PRESS_HOLD to listOf(1, 10, 18, 19, 11, 20, 21, 22)
            ),
            ancModes = fullAnc
        ),
        "B172" to ModelCapabilities(  // CMF Buds Pro 2
            pid = "B172", name = "CMF Buds Pro 2",
            anc = true, smartAnc = true, eq = true, diracEq = true, customEq = true,
            game = true, wearDetect = true, autoPowerOff = true, lhdc = true, mimi = true,
            findEar = true, fitTest = true, bassBoost = true,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD, Gesture.TYPE_DOUBLE_PRESS_HOLD),
            gestureOps = mapOf(
                Gesture.TYPE_DOUBLE to listOf(8, 9, 11, 40),
                Gesture.TYPE_TRIPLE to listOf(8, 9, 11),
                Gesture.TYPE_PRESS_HOLD to listOf(1, 10, 18, 19, 11, 20, 21, 22, 40)
            ),
            caseControl = true,
            caseGestures = listOf("Play / pause", "Volume up", "Volume down"),
            ancModes = fullAnc
        ),
        "B174" to ModelCapabilities(  // Nothing Ear (open)
            pid = "B174", name = "Nothing Ear (open)",
            eq = true, game = true, wearDetect = true, autoPowerOff = true, findEar = true,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD)
        ),
        "B173" to ModelCapabilities(  // Ear Three
            pid = "B173", name = "Nothing Ear (3)",
            anc = true, smartAnc = true, eq = true, spatial = true, game = true,
            wearDetect = true, dualDevice = true, volume = true, autoPowerOff = true,
            findEar = true, ancModes = fullAnc,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD, Gesture.TYPE_DOUBLE_PRESS_HOLD)
        ),
        "B183" to ModelCapabilities(  // Hitmontop
            pid = "B183", name = "Nothing Ear",
            anc = true, eq = true, game = true, wearDetect = true, autoPowerOff = true,
            findEar = true, ancModes = fullAnc,
            gestureTypes = setOf(Gesture.TYPE_DOUBLE, Gesture.TYPE_TRIPLE, Gesture.TYPE_PRESS_HOLD)
        ),
        "B175" to ModelCapabilities(  // Forretress / Headphone Pro
            pid = "B175", name = "Nothing Headphone Pro",
            anc = true, boxLed = true, findEar = true,
            caseControl = true, caseGestures = listOf("Squeeze", "Press & hold"),
            ancModes = simpleAnc
        )
    )

    /** Returns capabilities for a pid string; unknown pids get a generic empty model. */
    fun forPid(pid: String?): ModelCapabilities = models[pid] ?: ModelCapabilities(pid = pid ?: "?", name = pid ?: "Unknown")

    /** Best-effort product id derived from a model name string (firmware GET_DEVICE_MODEL). */
    fun pidFromName(model: String): String? {
        val m = model.uppercase()
        return when {
            m.contains("EAR (1") || m.contains("EAR (ONE") -> "B181"
            m.contains("STICK") -> "B157"
            m.contains("EAR (2") -> "B155"
            m.contains("EAR (A") -> "B162"
            m.contains("CMF BUDS PRO 2") -> "B172"
            m.contains("CMF BUDS PRO") -> "B163"
            m.contains("CMF NECKBAND") -> "B164"
            m.contains("CMF BUDS") -> "B168"
            m.contains("EAR (OPEN") || m.contains("EAR OPEN") -> "B174"
            m.contains("CMF") && m.contains("NECK") -> "B164"
            m.contains("EAR (3") || m.contains("EAR THREE") -> "B173"
            m.contains("HEADPHONE") || m.contains("PRO") -> "B175"
            m.contains("2024") || m.contains("EAR (2024") -> "B171"
            m.contains("EAR") or (m.isEmpty() && m != "?") -> "B183"
            else -> null
        }
    }
}
