package com.nothingbuds.entities

import com.nothingbuds.protocol.CommandRegistry
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Feature entities + wire-byte payload builders/parsers for confirmed Nothing TWS features.
 *
 * Payload layouts recovered from the official decompile + independent ear-web cross-reference
 * (authoritative: re/findings.md, re/ear-web-cross-reference.md). Anything not confirmed is kept
 * OUT of this file and marked UNKNOWN at the UI/VM boundary.
 */

object Wire {
    // --- ANC mode wire bytes (ear-web CONFIRMED) ---
    const val ANC_ON: Int = -1
    @JvmStatic val ANC_OFF: Int = 0x05
    const val ANC_HIGH = 0x01
    const val ANC_MID = 0x02
    const val ANC_LOW = 0x03
    const val ANC_ADAPTIVE = 0x04
    const val ANC_TRANSPARENCY = 0x07

    @JvmStatic val ancNames = mapOf(
        ANC_OFF to "Off",
        ANC_TRANSPARENCY to "Transparency",
        ANC_LOW to "Low",
        ANC_HIGH to "High",
        ANC_MID to "Mid",
        ANC_ADAPTIVE to "Adaptive"
    )

    @JvmStatic val ancOrder = listOf(ANC_OFF, ANC_TRANSPARENCY, ANC_LOW, ANC_HIGH, ANC_MID, ANC_ADAPTIVE)
}

/** Battery snapshot (0xC007 / 0xE001). */
data class BatteryStatus(
    val leftPercent: Int = -1,
    val leftCharging: Boolean = false,
    val rightPercent: Int = -1,
    val rightCharging: Boolean = false,
    val casePercent: Int = -1,
    val caseCharging: Boolean = false
) {
    companion object {
        fun parse(payload: ByteArray): BatteryStatus {
            var out = BatteryStatus()
            val count = payload.getOrNull(0)?.toInt() ?: 0
            var i = 0
            while (i < count) {
                val id = payload.getOrNull(1 + i * 2)?.toInt() ?: break
                val lvl = payload.getOrNull(2 + i * 2)?.toInt() ?: break
                val pct = lvl and 0x7F
                val chg = (lvl and 0x80) != 0
                out = when (id) {
                    2 -> out.copy(leftPercent = pct, leftCharging = chg)
                    3 -> out.copy(rightPercent = pct, rightCharging = chg)
                    4 -> out.copy(casePercent = pct, caseCharging = chg)
                    else -> out
                }
                i++
            }
            return out
        }
    }
}

/** ANC current mode (0xC01E / 0xF00F). Wire bytes from Wire. */
object Anc {
    fun setPayload(wireMode: Int): ByteArray = byteArrayOf(0x01, wireMode.toByte(), 0x00)
    fun parseCurrentMode(payload: ByteArray): Int? = payload.getOrNull(1)?.toInt()
}

/**
 * EQ.
 * - Preset EQ non-Dirac (0xC01F read / 0xF010 set): SET payload [level, 0x00].
 * - Dirac (0xC050 read / 0xF01D set): SET payload [level, 0x00].
 */
object Eq {
    const val DIRAC_GET = 0xC050
    const val DIRAC_SET = 0xF01D

    val presetNames = listOf("Balanced", "More Voice", "More Treble", "More Bass")
    const val PRESET_CUSTOM = 5
    const val PRESET_ADVANCED = 6

    fun setPresetPayload(level: Int): ByteArray = byteArrayOf(level.toByte(), 0x00)

    // Custom EQ (0xC044 / 0xF041): 53-byte float32-LE 3-band template.
    // Wire band order != UI [bass, mid, treble]; ear-web sends [mid, treble, bass].
    fun buildCustomEq(bass: Float, mid: Float, treble: Float): ByteArray {
        val values = listOf(mid, treble, bass) // ui->wire permutation
        val buf = ByteBuffer.allocate(53).order(ByteOrder.LITTLE_ENDIAN)
        buf.put(0x03)
        buf.putFloat(-(values.maxOrNull() ?: 0f))
        for (v in values) {
            buf.putFloat(v)                    // band float32 LE
            buf.put(ByteArray(9))              // remaining 13-byte band padding
        }
        return buf.array()
    }

    // Advanced EQ enable (0xF04F) payload [0x01, 0x00] confirmed.
    fun advancedEnabledPayload(on: Boolean): ByteArray = byteArrayOf(if (on) 0x01 else 0x00, 0x00)
}

/** Bass boost / enhancer (0xC04E / 0xF051). byte1 = level*2 on wire. */
object Bass {
    fun setPayload(enabled: Boolean, level: Int): ByteArray =
        byteArrayOf(if (enabled) 0x01 else 0x00, (level.coerceIn(0, 100) * 2).toByte())
}

/**
 * Gestures (0xC018 read / 0xF003 set).
 * SET payload [0x01, device, 0x01, type, action]; device 2=left 3=right.
 */
data class GestureEntry(val device: Int, val common: Int, val type: Int, val action: Int)

object Gesture {
    // gestureType -> operation options
    const val TYPE_DOUBLE = 2
    const val TYPE_TRIPLE = 3
    const val TYPE_PRESS_HOLD = 7
    const val TYPE_DOUBLE_PRESS_HOLD = 9

    // operation ids
    const val OP_NO_ACTION = 1
    const val OP_VOLUME_DOWN = 6
    const val OP_VOLUME_UP = 7
    const val OP_SKIP_BACK = 8
    const val OP_SKIP_FORWARD = 9
    const val OP_ANC_ALL = 10
    const val OP_VOICE = 11
    const val OP_ANC_NC_OFF = 20
    const val OP_ANC_TRANSP_OFF = 21
    const val OP_ANC_TRANSP_NC = 22

    val opNames = mapOf(
        OP_NO_ACTION to "No action",
        2 to "Play / pause",
        3 to "Answer call",
        OP_VOLUME_DOWN to "Volume down",
        OP_VOLUME_UP to "Volume up",
        OP_SKIP_BACK to "Skip back",
        OP_SKIP_FORWARD to "Skip forward",
        OP_ANC_ALL to "Noise control",
        OP_VOICE to "Voice assistant",
        OP_ANC_NC_OFF to "Anc: NC + Off",
        OP_ANC_TRANSP_OFF to "Anc: Transparency + Off",
        OP_ANC_TRANSP_NC to "Anc: Transparency + NC"
    )

    fun parse(payload: ByteArray): List<GestureEntry> {
        val count = payload.getOrNull(0)?.toInt() ?: 0
        return (0 until count).mapNotNull { i ->
            val o = 1 + i * 4
            if (o + 3 >= payload.size) null
            else GestureEntry(
                device = payload[o].toInt(),
                common = payload[o + 1].toInt(),
                type = payload[o + 2].toInt(),
                action = payload[o + 3].toInt()
            )
        }
    }

    fun setPayload(device: Int, type: Int, action: Int): ByteArray =
        byteArrayOf(0x01, device.toByte(), 0x01, type.toByte(), action.toByte())
}

/** Find earbud (0xF002 SET_WHERE_AM_I). */
object FindEar {
    const val LEFT = 2
    const val RIGHT = 3

    fun ringPayload(isEar1: Boolean, side: Int?, on: Boolean): ByteArray =
        if (isEar1) byteArrayOf(if (on) 0x01 else 0x00)
        else byteArrayOf(side?.toByte() ?: 0, if (on) 0x01 else 0x00)

    fun stopPayload(isEar1: Boolean) = if (isEar1) byteArrayOf(0x00) else byteArrayOf(0x00)
}

/** Ear-tip fit test (0xF014 SET_LEAK_DETECT [0x01]; result 0xE00D payload[8]/[9]). */
object FitTest {
    fun startPayload(): ByteArray = byteArrayOf(0x01)
    val resultNames = mapOf(0 to "Good", 1 to "Adjust", 2 to "Re-seat")
    fun parseLeft(payload: ByteArray): Int? = payload.getOrNull(0)?.toInt()
    fun parseRight(payload: ByteArray): Int? = payload.getOrNull(1)?.toInt()
}

/** Low latency (0xC041 / 0xF040) payload [1,0] on / [2,0] off. */
object Latency {
    fun setPayload(on: Boolean): ByteArray = byteArrayOf((if (on) 1 else 2).toByte(), 0x00)
}

/** ExtraFeatureStatus (0xC00E / 0xF004) — [count, type, enable]. */
object ExtraFeatureStatus {
    fun setPayload(type: Int, enable: Boolean): ByteArray =
        byteArrayOf(0x01, type.toByte(), if (enable) 0x01 else 0x00)

    /** In-ear / wear-detect status lives at payload[10]. */
    fun inEarEnabled(payload: ByteArray): Boolean? =
        payload.getOrNull(10)?.let { it == 0x01.toByte() }?.takeIf { _ -> true }
}

/** Personalized ANC (0xC020 / 0xF011). status payload[8]; SET [0x01]/[0x00]. */
object PersonalizedAnc {
    fun setPayload(on: Boolean): ByteArray = byteArrayOf(if (on) 0x01 else 0x00)
}

/** Case LED RGB (0xC017 / 0xF00D) — Ear (1) only. [count,(idx,R,G,B)x5]. */
data class CaseLedColor(val rgb: List<Int>) {
    companion object {
        fun parse(payload: ByteArray): CaseLedColor? {
            val count = payload.getOrNull(0)?.toInt() ?: return null
            val values = (0 until count).mapNotNull { i ->
                val o = 2 + i * 3
                if (o + 2 >= payload.size) null else rgb(payload[o].toInt(), payload[o + 1].toInt(), payload[o + 2].toInt())
            }
            return CaseLedColor(values)
        }
        fun rgb(r: Int, g: Int, b: Int): Int = ((r and 0xFF) shl 16) or ((g and 0xFF) shl 8) or (b and 0xFF)
    }
}

object CaseLed {
    fun setPayload(rgbByLed: List<Int>): ByteArray {
        val buf = ByteArray(1 + rgbByLed.size * 4)
        buf[0] = rgbByLed.size.toByte()
        rgbByLed.forEachIndexed { i, c ->
            val o = 1 + i * 4
            buf[o] = (i + 1).toByte()
            buf[o + 1] = ((c shr 16) and 0xFF).toByte()
            buf[o + 2] = ((c shr 8) and 0xFF).toByte()
            buf[o + 3] = (c and 0xFF).toByte()
        }
        return buf
    }
}

/** Firmware version (0xC042). len@payload[5], ASCII@payload[8..]. */
object Firmware {
    fun parse(payload: ByteArray): String? {
        val len = payload.getOrNull(5)?.toInt() ?: return null
        val start = 8
        if (start + len > payload.size) return null
        return String(payload, start, len, Charsets.US_ASCII)
    }
}
