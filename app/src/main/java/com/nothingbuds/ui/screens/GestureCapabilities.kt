package com.nothingbuds.ui.screens

import com.nothingbuds.protocol.PacketBuilder

import android.content.Context
import android.os.Build
import com.nothingbuds.protocol.PacketBuilder

interface DefaultOp {
    /** @param button 10 for the Elekid "magic" / "Nothing button"; 0 otherwise. */
    fun get(context: Context, side: Int, button: Int): Int
}

class FixedDefault(val op: Int) : DefaultOp {
    override fun get(context: Context, side: Int, button: Int) = op
}

class SideDependentDefault(val left: Int, val right: Int) : DefaultOp {
    override fun get(context: Context, side: Int, button: Int) =
        if (side == PacketBuilder.SIDE_LEFT) left else right
}

/** Nothing-OS dependent default: [nothingOs] when running on NothingOS, [other] otherwise. */
class OsDependentDefault(val nothingOs: Int, val other: Int) : DefaultOp {
    override fun get(context: Context, side: Int, button: Int) =
        if (Build.MANUFACTURER.equals("Nothing", ignoreCase = true)) nothingOs else other
}

/**
 * One gesture slot of a device: the wire trigger [type] and the label [GestureScreen] shows.
 */
data class GestureSlot(val type: Int, val label: String)

/**
 * The gesture configuration surface of one product family, taken from the decompiled Nothing X
 * `ControlItemViewModel.convertOptions()` for each model (see `re/control-src/com/nothing/…`).
 *
 * - [slots] are the earbud trigger rows shown for left/right (wire type ids, source `SUPPORT_GESTURES`
 *   filtered to the rows that carry operations; type 15 rows are rendered arrow-only).
 * - [operations] maps an earbud trigger type to the operations the model actually offers, in source
 *   order.
 * - [defaults] maps an earbud trigger type to its source-derived default operation (see
 *   `setDefaultOperation` in each model's `ControlItemViewModel`).
 * - [caseSlots]/[caseOperations]/[caseDefaults] are the charging-case rows for smart-dial products
 *   (Espeon/Heracross).
 *
 * A model family must never fall back to the union of every operation: the official app only ever
 * shows the arrays below.
 */
data class GestureProfile(
    val slots: List<GestureSlot>,
    val operations: Map<Int, List<Int>>,
    val defaults: Map<Int, DefaultOp>,
    val caseSlots: List<GestureSlot> = emptyList(),
    val caseOperations: Map<Int, List<Int>> = emptyMap(),
    val caseDefaults: Map<Int, DefaultOp> = emptyMap(),
) {
    /** Operations allowed for [side]/[type]; empty for arrow-only or fixed rows. */
    fun operationsFor(side: Int, type: Int): List<Int> =
        if (side == PacketBuilder.SIDE_CASE) caseOperations[type].orEmpty()
        else operations[type].orEmpty()

    /** Default operation id from the decompiled source (`setDefaultOperation`). */
    fun defaultFor(side: Int, type: Int, context: Context, button: Int = 0): Int =
        (if (side == PacketBuilder.SIDE_CASE) caseDefaults[type] else defaults[type])
            ?.get(context, side, button) ?: 1
}

/**
 * Central model-id → gesture capability lookup. Product ids are the values from the source
 * `IOTProductDevice*` classes (`PRODUCT_ID = "B172"`, …), which match the app's connected model id.
 * Models not present in the decompiled set get a conservative common-denominator profile: never the
 * full operation union.
 */
object GestureCapabilities {

    fun profileFor(modelId: String?): GestureProfile = PROFILES[modelId] ?: FALLBACK

    // ---- Espeon (CMF Buds Pro 2, B172) — preserved exactly; also Heracross (B187) reuses it -----

    /**
     * Ear rows `{2,3,7,9,15}`: DOUBLE {2,8,9,11}+1, TRIPLE {8,9,11}+1, NO_CLOSE {22,11}+1,
     * LONG_PRESS {18,19,11}+1 and the arrow-only type 15. Case rows (smart dial):
     * single {2,9,8,11,17}+1, press-hold {22,11,17}+1, double (single list + {3,25,1}),
     * triple (single list + {26,1}), rotate {23,1}, case-lock 15.
     */
    val ESPEON = GestureProfile(
        slots = slots(2, 3, 7, 9, 15),
        operations = mapOf(
            2 to listOf(2, 8, 9, 11, 1),
            3 to listOf(8, 9, 11, 1),
            7 to listOf(22, 11, 1),
            9 to listOf(18, 19, 11, 1),
            15 to emptyList(),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
            9 to FixedDefault(1),
        ),
        caseSlots = caseSlots(1, 2, 3, 7, 10, 15),
        caseOperations = mapOf(
            1 to listOf(2, 9, 8, 11, 17, 1),
            7 to listOf(22, 11, 17, 1),
            2 to listOf(2, 9, 8, 11, 17, 1, 3, 25, 1),
            3 to listOf(2, 9, 8, 11, 17, 1, 26, 1),
            10 to listOf(23, 1),
            15 to emptyList(),
        ),
        caseDefaults = mapOf(
            1 to FixedDefault(1),
            2 to FixedDefault(1),
            3 to FixedDefault(1),
            7 to FixedDefault(1),
            10 to FixedDefault(1),
        ),
    )

    // ---- Girafarig (CMF Buds 2, B179) / Gligar — same rows, AI-news op 31 unconditional ----------

    val GIRAFARIG = GestureProfile(
        slots = slots(2, 3, 7, 9, 15),
        operations = mapOf(
            2 to listOf(2, 8, 9, 11, 31, 1),
            3 to listOf(8, 9, 11, 31, 1),
            7 to listOf(22, 11, 31, 1),
            9 to listOf(18, 19, 11, 31, 1),
            15 to emptyList(),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
            9 to FixedDefault(1),
        ),
    )

    // ---- Corsola (CMF Buds Pro, B163) — the only family that advertises a type-8 row -------------

    val CORSOLA = GestureProfile(
        slots = slots(2, 3, 7, 8, 9),
        operations = mapOf(
            2 to listOf(2, 8, 9, 11),
            3 to listOf(8, 9, 11),
            7 to listOf(10, 11),
            8 to listOf(18, 19, 11, 1),
            9 to listOf(18, 19, 11, 1),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
            8 to FixedDefault(1),
            9 to FixedDefault(1),
        ),
    )

    // ---- Donphan (CMF Buds, B168) / Hoothoot (CMF Buds 2a, B185) ----------------------------------

    val DONPHAN = GestureProfile(
        slots = slots(2, 3, 7, 9),
        operations = mapOf(
            2 to listOf(2, 8, 9, 11),
            3 to listOf(8, 9, 11),
            7 to listOf(10, 11),
            9 to listOf(18, 19, 11),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
            9 to FixedDefault(1),
        ),
    )

    // ---- Crobat (CMF Neckband Pro, B164) ---------------------------------------------------------

    val CROBAT = GestureProfile(
        slots = slots(2, 3, 7),
        operations = mapOf(
            2 to listOf(8, 9, 11),
            3 to listOf(8, 9, 11),
            7 to listOf(10),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
        ),
    )

    // ---- Elekid (B170) — single-button control: press-and-hold only ------------------------------

    val ELEKID = GestureProfile(
        slots = slots(2, 3, 7),
        operations = mapOf(
            2 to listOf(8, 9, 11),
            3 to listOf(8, 9, 11),
            7 to listOf(10, 11, 1),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
        ),
    )

    // ---- Ear (1) [B181] — double tap is informational, triple {8,9,1}, hold {10,1} ---------------

    val EAR_ONE = GestureProfile(
        slots = slots(3, 7),
        operations = mapOf(
            3 to listOf(8, 9, 1),
            7 to listOf(10, 1),
        ),
        defaults = mapOf(
            3 to FixedDefault(9),
            7 to FixedDefault(10),
        ),
    )

    // ---- Ear (2) [B155] --------------------------------------------------------------------------

    val EAR_TWO = GestureProfile(
        slots = slots(2, 3, 7, 9),
        operations = mapOf(
            2 to listOf(8, 9, 11),
            3 to listOf(8, 9, 11),
            7 to listOf(10, 18, 19, 11),
            9 to listOf(10, 18, 19, 11, 1),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
            9 to FixedDefault(1),
        ),
    )

    // ---- Ear (stick) [B157] — no ANC, so hold and double-hold swap to volume ops ------------------

    val EAR_STICK = GestureProfile(
        slots = slots(2, 3, 7, 9),
        operations = mapOf(
            2 to listOf(8, 9, 11),
            3 to listOf(8, 9, 11),
            7 to listOf(18, 19, 11),
            9 to listOf(1, 18, 19, 11),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(10),
            9 to FixedDefault(1),
        ),
    )

    // ---- Ear (a) [B162] / Ear (2) second gen [B171 twins] ------------------------------------------

    val EAR_COLOR = GestureProfile(
        slots = slots(2, 3, 7, 9),
        operations = mapOf(
            2 to listOf(8, 9, 11),
            3 to listOf(8, 9, 11),
            7 to listOf(10, 18, 19, 11),
            9 to listOf(10, 18, 19, 11, 1),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
            9 to FixedDefault(1),
        ),
    )

    // ---- Ear (open) [B174] — no ANC, AI-news op 31 in the arrays ----------------------------------

    val EAR_FLAFFY = GestureProfile(
        slots = slots(2, 3, 7, 9),
        operations = mapOf(
            2 to listOf(8, 9, 11, 31),
            3 to listOf(8, 9, 11, 31),
            7 to listOf(18, 19, 11, 31),
            9 to listOf(18, 19, 11, 31, 1),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to SideDependentDefault(19, 18), // left=vol+, right=vol-
            9 to FixedDefault(1),
        ),
    )

    // ---- Nothing Ear [B171] — same arrays as Ear (a) ----------------------------------------------

    val EAR_TWOS = GestureProfile(
        slots = slots(2, 3, 7, 9),
        operations = mapOf(
            2 to listOf(8, 9, 11),
            3 to listOf(8, 9, 11),
            7 to listOf(10, 18, 19, 11),
            9 to listOf(10, 18, 19, 11, 1),
        ),
        defaults = mapOf(
            2 to FixedDefault(9),
            3 to FixedDefault(8),
            7 to FixedDefault(22),
            9 to FixedDefault(1),
        ),
    )

    // ---- Unknown models: no defaults, no operations exposed --------------------------------------

    val FALLBACK = GestureProfile(
        slots = emptyList(),
        operations = emptyMap(),
        defaults = emptyMap(),
    )

    private val PROFILES: Map<String, GestureProfile> = mapOf(
        "B172" to ESPEON,   // CMF Buds Pro 2
        "B187" to ESPEON,   // Heracross — reuses the Espeon gesture action (IOTProductDeviceHeracross)
        "B179" to GIRAFARIG, // CMF Buds 2 (Gligar shares Girafarig's mapping)
        "B163" to CORSOLA,  // CMF Buds Pro
        "B168" to DONPHAN,  // CMF Buds
        "B185" to DONPHAN,  // CMF Buds 2a (Hoothoot reuses Donphan)
        "B164" to CROBAT,   // CMF Neckband Pro
        "B170" to ELEKID,
        "B181" to EAR_ONE,  // Nothing Ear (1)
        "B155" to EAR_TWO,  // Nothing Ear (2)
        "B157" to EAR_STICK, // Nothing Ear (stick)
        "B162" to EAR_COLOR, // Nothing Ear (a)
        "B174" to EAR_FLAFFY, // Nothing Ear (open)
        "B171" to EAR_TWOS, // Nothing Ear
    )

    private fun slots(vararg types: Int): List<GestureSlot> =
        types.map { GestureSlot(it, slotLabel(it)) }

    private fun caseSlots(vararg types: Int): List<GestureSlot> =
        types.map { GestureSlot(it, caseLabel(it)) }

    private fun slotLabel(type: Int): String = when (type) {
        2 -> "Double tap"
        3 -> "Triple tap"
        7 -> "Tap & hold"
        8 -> "Double tap & hold"
        9 -> "Double tap & hold"
        15 -> "Double press & hold"
        else -> "Gesture $type"
    }

    private fun caseLabel(type: Int): String = when (type) {
        1 -> "Single press"
        2 -> "Double press"
        3 -> "Triple press"
        7 -> "Press & hold"
        10 -> "Rotate smart dial"
        15 -> "Double press & hold"
        else -> "Press $type"
    }
}