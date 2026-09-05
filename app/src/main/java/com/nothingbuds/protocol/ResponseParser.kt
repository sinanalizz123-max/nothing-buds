package com.nothingbuds.protocol

import android.util.Log

/**
 * Parses responses from Nothing/CMF earbuds.
 */
object ResponseParser {

    private const val TAG = "ResponseParser"
    private const val HEADER_SIZE = 8
    private const val MIN_PACKET_SIZE = HEADER_SIZE + 2 // Header + CRC

    data class BatteryStatus(
        val left: Int = -1,           // -1 means disconnected
        val right: Int = -1,
        val case: Int = -1,
        val leftCharging: Boolean = false,
        val rightCharging: Boolean = false,
        val caseCharging: Boolean = false
    ) {
        val isLeftConnected: Boolean get() = left >= 0
        val isRightConnected: Boolean get() = right >= 0
        val isCaseConnected: Boolean get() = case >= 0
    }

    data class ParsedResponse(
        val command: Int,
        val payload: ByteArray
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false
            other as ParsedResponse
            return command == other.command && payload.contentEquals(other.payload)
        }

        override fun hashCode(): Int {
            var result = command
            result = 31 * result + payload.contentHashCode()
            return result
        }
    }

    /**
     * Parse raw bytes into a response.
     * Returns null if the packet is invalid.
     */
    fun parse(data: ByteArray): ParsedResponse? {
        if (data.size < MIN_PACKET_SIZE) {
            Log.w(TAG, "Packet too small: ${data.size} bytes")
            return null
        }

        // Check magic bytes
        if (data[0] != 0x55.toByte()) {
            Log.w(TAG, "Invalid magic byte: ${data[0]}")
            return null
        }

        val command = (data[3].toInt() and 0xFF) or ((data[4].toInt() and 0xFF) shl 8)
        val payloadLength = data[5].toInt() and 0xFF

        if (data.size < HEADER_SIZE + payloadLength + 2) {
            Log.w(TAG, "Packet truncated: expected ${HEADER_SIZE + payloadLength + 2}, got ${data.size}")
            return null
        }

        val payload = data.copyOfRange(HEADER_SIZE, HEADER_SIZE + payloadLength)

        // Verify CRC (optional, for debugging)
        val dataWithoutCrc = data.copyOfRange(0, HEADER_SIZE + payloadLength)
        val expectedCrc = CRC16.calculate(dataWithoutCrc)
        val actualCrc = (data[HEADER_SIZE + payloadLength].toInt() and 0xFF) or
                ((data[HEADER_SIZE + payloadLength + 1].toInt() and 0xFF) shl 8)

        if (expectedCrc != actualCrc) {
            Log.w(TAG, "CRC mismatch: expected $expectedCrc, got $actualCrc")
            // Continue anyway, some devices have buggy CRC
        }

        return ParsedResponse(command, payload)
    }

    /**
     * Parse battery status from response payload.
     */
    fun parseBattery(payload: ByteArray): BatteryStatus {
        if (payload.isEmpty()) {
            return BatteryStatus()
        }

        val connectedDevices = payload[0].toInt() and 0xFF
        var left = -1
        var right = -1
        var case = -1
        var leftCharging = false
        var rightCharging = false
        var caseCharging = false

        val batteryMask = 0x7F     // Lower 7 bits = battery level
        val chargingMask = 0x80   // Bit 7 = charging

        for (i in 0 until connectedDevices) {
            val offset = 1 + (i * 2)
            if (offset + 1 >= payload.size) break

            val deviceId = payload[offset].toInt() and 0xFF
            val batteryByte = payload[offset + 1].toInt() and 0xFF
            val batteryLevel = batteryByte and batteryMask
            val isCharging = (batteryByte and chargingMask) != 0

            when (deviceId) {
                0x02 -> { // Left
                    left = batteryLevel
                    leftCharging = isCharging
                }
                0x03 -> { // Right
                    right = batteryLevel
                    rightCharging = isCharging
                }
                0x04 -> { // Case
                    case = batteryLevel
                    caseCharging = isCharging
                }
                0x06 -> { // Stereo (single value for both)
                    left = batteryLevel
                    right = batteryLevel
                    leftCharging = isCharging
                    rightCharging = isCharging
                }
            }
        }

        return BatteryStatus(left, right, case, leftCharging, rightCharging, caseCharging)
    }

    /**
     * ANC state as the earbuds report it in the 0x401E reply and the unsolicited 0xE003 push.
     *
     * The payload is a list of 3-byte groups `[group, value, 0x00]`, verified against a
     * CMF Buds 2 Plus (B184):
     *   group 0x01 = the mode in effect  (0x05 off, 0x07 transparency, 0x01..0x04 ANC levels)
     *   group 0x02 = the ANC level to return to, which keeps its value while off/transparency
     */
    data class AncState(
        val mode: AncMode,
        val ancLevel: AncMode,
    )

    /**
     * Parse the grouped ANC payload. Falls back to reading a bare `[_, value]` pair so older
     * firmware that answers without groups still works.
     */
    fun parseAncState(payload: ByteArray): AncState? {
        if (payload.size < 2) return null

        var mode: AncMode? = null
        var level: AncMode? = null

        if (payload.size >= 3 && payload.size % 3 == 0) {
            for (offset in payload.indices step 3) {
                val group = payload[offset].toInt() and 0xFF
                val value = payload[offset + 1].toInt() and 0xFF
                when (group) {
                    0x01 -> mode = AncMode.fromValue(value)
                    0x02 -> level = AncMode.fromValue(value)
                }
            }
        }

        if (mode == null) {
            mode = AncMode.fromValue(payload[1].toInt() and 0xFF)
        }

        return AncState(mode, level ?: mode)
    }




    /**
     * Parse EQ preset from response payload.
     */
    fun parseEq(payload: ByteArray): EqPreset {
        if (payload.isEmpty()) {
            return EqPreset.BALANCED
        }
        val eqValue = payload[0].toInt() and 0xFF
        return EqPreset.fromValue(eqValue)
    }

    /**
     * Parse firmware version from response payload.
     */
    fun parseFirmware(payload: ByteArray): String {
        if (payload.size < 4) {
            return "Unknown"
        }
        return "${payload[0].toInt() and 0xFF}.${payload[1].toInt() and 0xFF}." +
                "${payload[2].toInt() and 0xFF}.${payload[3].toInt() and 0xFF}"
    }

    /**
     * Parse in-ear detection status from response payload.
     */
    fun parseInEar(payload: ByteArray): Boolean {
        if (payload.isEmpty()) {
            return false
        }
        return (payload[0].toInt() and 0xFF) == 1
    }

    /**
     * Low latency answers `1` for on and `2` for off, matching what the write takes.
     */
    fun parseLatency(payload: ByteArray): Boolean {
        if (payload.isEmpty()) return false
        return (payload[0].toInt() and 0xFF) == 1
    }

    /** Bass boost reports `[enabled, level]`. */
    data class BassBoost(val enabled: Boolean, val level: Int)

    fun parseBassBoost(payload: ByteArray): BassBoost? {
        if (payload.isEmpty()) return null
        val enabled = (payload[0].toInt() and 0xFF) == 1
        // The firmware echoes whatever it was given, including values the official app never
        // sends, so anything outside the supported range is pulled back into it.
        val level = if (payload.size > 1) {
            (payload[1].toInt() and 0xFF).coerceIn(1, PacketBuilder.BASS_LEVEL_MAX)
        } else {
            1
        }
        return BassBoost(enabled, level)
    }

    /** In-ear detection rides along in the extra-features report as `[0x01, 0x01, on]`. */
    fun parseInEarFromExtraFeatures(payload: ByteArray): Boolean? {
        if (payload.size >= 3 && payload.size % 3 == 0) {
            for (offset in payload.indices step 3) {
                if ((payload[offset].toInt() and 0xFF) == 0x01 &&
                    (payload[offset + 1].toInt() and 0xFF) == 0x01
                ) {
                    return (payload[offset + 2].toInt() and 0xFF) == 1
                }
            }
            return null
        }
        return payload.lastOrNull()?.let { (it.toInt() and 0xFF) == 1 }
    }

    /** Firmware and serial come back as a NUL-padded ASCII string. */
    fun parseAsciiString(payload: ByteArray): String =
        payload.takeWhile { it != 0.toByte() }.toByteArray().toString(Charsets.US_ASCII).trim()

    /**
     * Parse custom EQ bands from response payload.
     * Returns array of 8 values (-6 to +6 dB).
     */
    fun parseCustomEq(payload: ByteArray): IntArray {
        if (payload.size < 8) {
            return IntArray(8) { 0 }
        }
        return IntArray(8) { i ->
            (payload[i].toInt() and 0xFF) - 6 // Convert 0-12 to -6 to +6
        }
    }

    /**
     * One gesture slot read back from the key-configuration report.
     *
     * The wire layout per slot is `[device, common, type, action]`: device 2 = left / 3 = right,
     * type is the trigger (double tap, triple tap, press-and-hold, …) and action the operation.
     */
    data class GestureSlot(
        val side: Int,
        val type: Int,
        val action: Int,
    )

    /**
     * The GET_KEY_CONFIGURATION reply is `[count, (device, common, type, action)...]`; anything
     * that does not fit the fixed 4-byte slots is dropped rather than misreported.
     */
    fun parseGestures(payload: ByteArray): List<GestureSlot> {
        if (payload.size < 1) return emptyList()
        val count = payload[0].toInt() and 0xFF
        val result = ArrayList<GestureSlot>(count.coerceAtMost(payload.size / 4))
        for (i in 0 until count) {
            val offset = 1 + i * 4
            if (offset + 3 >= payload.size) break
            result.add(
                GestureSlot(
                    side = payload[offset].toInt() and 0xFF,
                    type = payload[offset + 2].toInt() and 0xFF,
                    action = payload[offset + 3].toInt() and 0xFF,
                )
            )
        }
        return result
    }

    /**
     * Case LED report: `[count, ?, (R, G, B)...]`. The first byte after the count does not map to
     * a documented field, so it is skipped and each LED is read as a 3-byte RGB triple.
     */
    fun parseCaseLed(payload: ByteArray): List<Int> {
        if (payload.size < 2) return emptyList()
        val count = payload[0].toInt() and 0xFF
        val result = ArrayList<Int>(count)
        for (i in 0 until count) {
            val offset = 2 + i * 3
            if (offset + 2 >= payload.size) break
            val r = payload[offset].toInt() and 0xFF
            val g = payload[offset + 1].toInt() and 0xFF
            val b = payload[offset + 2].toInt() and 0xFF
            result.add(0xFF000000.toInt() or (r shl 16) or (g shl 8) or b)
        }
        return result
    }

    /** BasicBoolean replies (`1` == on), shared by dual enable and spatial-style toggles. */
    fun parseBoolean(payload: ByteArray): Boolean {
        if (payload.isEmpty()) return false
        return (payload[0].toInt() and 0xFF) == 1
    }

    /**
     * A single multipoint device from the dual-device list. Each entry is 7 bytes: a 6-byte MAC
     * and then a type/role byte. `isConnected` marks the device that is currently reporting a
     * link; `isCurrent` the one actively outputting audio.
     */
    data class DualDevice(
        val id: Int,
        val mac: String,
        val isConnected: Boolean,
    )

    /**
     * GET_DUAL_DEVICE_LIST reply is a count byte followed by 7-byte entries `[MAC x6, type]`.
     * The type byte is only trusted to *suggest* status (historically ambiguous), so it is read
     * as `isConnected` for display without ever driving the enabled toggle.
     */
    fun parseDualDeviceList(payload: ByteArray): List<DualDevice> {
        if (payload.size < 1) return emptyList()
        val count = payload[0].toInt() and 0xFF
        val result = ArrayList<DualDevice>(count.coerceAtMost((payload.size - 1) / 7))
        for (i in 0 until count) {
            val offset = 1 + i * 7
            if (offset + 6 >= payload.size) break
            val macBytes = payload.copyOfRange(offset, offset + 6)
            val type = payload[offset + 6].toInt() and 0xFF
            val mac = macBytes.joinToString(":") { "%02X".format(it) }
            result.add(DualDevice(id = i, mac = mac, isConnected = type != 0))
        }
        return result
    }

    /** Dirac Opteo EQ answers a BasicInt preset id (0..5 named, 6 custom). */
    fun parseDiracEq(payload: ByteArray): Int {
        if (payload.isEmpty()) return 0
        return (payload[0].toInt() and 0xFF).coerceIn(0, PacketBuilder.DIRAC_LEVEL_MAX)
    }

    /** LHDC answers a BasicInt; any non-zero value means the codec is on. */
    fun parseLhdc(payload: ByteArray): Boolean {
        if (payload.isEmpty()) return false
        return (payload[0].toInt() and 0xFF) != 0
    }

    /** Auto power-off is a BasicInt carrying minutes. */
    fun parsePowerOff(payload: ByteArray): Int {
        if (payload.isEmpty()) return 0
        return payload[0].toInt() and 0xFF
    }

    /**
     * Detail enhancement reports `[enabled, level]`. The level byte has no meaning while
     * disabled. Some firmware answers a bare single byte, so a short payload still works.
     */
    data class DetailEnhancement(val enabled: Boolean, val level: Int)

    fun parseDetailEnhancement(payload: ByteArray): DetailEnhancement {
        if (payload.isEmpty()) return DetailEnhancement(false, 1)
        val enabled = (payload[0].toInt() and 0xFF) == 1
        val level = if (payload.size > 1) {
            (payload[1].toInt() and 0xFF).coerceIn(1, PacketBuilder.DETAIL_LEVEL_MAX)
        } else {
            1
        }
        return DetailEnhancement(enabled, level)
    }

    /** Ear-tip fit result pushed by the earbuds: (left, right), 0 good, 1 adjust, 2 re-seat. */
    data class FitResult(val left: Int, val right: Int)

    fun parseFitResult(payload: ByteArray): FitResult? {
        if (payload.size < 2) return null
        return FitResult(
            left = payload[0].toInt() and 0xFF,
            right = payload[1].toInt() and 0xFF,
        )
    }
}
