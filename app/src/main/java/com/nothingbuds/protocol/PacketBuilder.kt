package com.nothingbuds.protocol

import java.util.concurrent.atomic.AtomicInteger

/**
 * Builds packets for Nothing/CMF earbuds protocol.
 *
 * Packet structure:
 * - Header (8 bytes): [0x55, 0x60, 0x01, cmd_low, cmd_high, len_low, len_high, op_id]
 * - Length bytes 5..6 are a 16-bit little-endian payload size (see re/SMART_DIAL.md)
 * - Payload (variable)
 * - CRC16 (2 bytes, little-endian)
 */
object PacketBuilder {

    private val operationId = AtomicInteger(0)

    /**
     * Build a packet with the given command and payload.
     */
    fun build(command: Int, payload: ByteArray = byteArrayOf()): ByteArray {
        val opId = operationId.incrementAndGet() and 0xFF
        if (opId >= 250) {
            operationId.set(0)
        }

        val header = byteArrayOf(
            0x55.toByte(),                          // Magic byte 1
            0x60.toByte(),                          // Magic byte 2
            0x01.toByte(),                          // Protocol version
            (command and 0xFF).toByte(),            // Command low byte
            ((command shr 8) and 0xFF).toByte(),    // Command high byte
            (payload.size and 0xFF).toByte(),       // Payload length low byte
            ((payload.size shr 8) and 0xFF).toByte(), // Payload length high byte (LE 16-bit)
            opId.toByte()                           // Operation ID
        )

        val dataWithoutCrc = header + payload
        val crc = CRC16.calculate(dataWithoutCrc)
        val crcBytes = CRC16.toBytes(crc)

        return dataWithoutCrc + crcBytes
    }

    /**
     * Build a packet from a hex string payload.
     */
    fun buildFromHex(command: Int, hexPayload: String): ByteArray {
        val payload = if (hexPayload.isEmpty()) {
            byteArrayOf()
        } else {
            hexPayload.chunked(2).map { it.toInt(16).toByte() }.toByteArray()
        }
        return build(command, payload)
    }

    // Convenience methods, payload shapes taken from the official app (see re/SMART_DIAL.md, re/)

    fun readBattery(): ByteArray = build(Commands.READ_BATTERY)

    fun readAnc(): ByteArray = build(Commands.READ_ANC)

    fun readEq(): ByteArray = build(Commands.READ_EQ)

    fun readFirmware(): ByteArray = build(Commands.READ_FIRMWARE)

    fun readConfiguration(): ByteArray = build(Commands.READ_CONFIGURATION)

    fun readExtraFeatures(): ByteArray = build(Commands.READ_EXTRA_FEATURES)

    fun readLowLatency(): ByteArray = build(Commands.READ_LOW_LATENCY)

    fun readBassBoost(): ByteArray = build(Commands.READ_BASS_BOOST)

    fun readBassEnhancer(): ByteArray = build(Commands.READ_BASS_ENHANCER)

    fun readSpatialAudio(): ByteArray = build(Commands.READ_SPATIAL_AUDIO)

    fun readAdvancedEqValues(): ByteArray = build(Commands.READ_ADVANCED_EQ_VALUES)

    fun readSupportedFeatures(): ByteArray = build(Commands.READ_SUPPORTED_FEATURES)

    fun readDeviceModel(): ByteArray = build(Commands.READ_DEVICE_MODEL)

    fun readGestures(): ByteArray = build(Commands.READ_GESTURES)

    fun readDual(): ByteArray = build(Commands.READ_DUAL)

    fun readDualDeviceList(): ByteArray = build(Commands.READ_DUAL_DEVICE_LIST, byteArrayOf(0))

    fun readDiracEq(): ByteArray = build(Commands.READ_DIRAC_EQ)

    fun readLhdc(): ByteArray = build(Commands.READ_LHDC)

    fun readPowerOff(): ByteArray = build(Commands.READ_POWER_OFF)

    fun readCaseLed(): ByteArray = build(Commands.READ_CASE_LED)

    fun readDetailEnhancement(): ByteArray = build(Commands.READ_DETAIL_ENHANCEMENT)

    /** `[0x01, mode, 0x00]` */
    fun setAnc(mode: AncMode): ByteArray =
        build(Commands.SET_ANC, byteArrayOf(0x01, mode.value, 0x00))

    /** `[preset, 0x00]` — the official app sends the preset plus a trailing zero byte. */
    fun setEq(preset: EqPreset): ByteArray =
        build(Commands.SET_EQ, byteArrayOf(preset.value, 0x00))

    /** `[0x01, 0x01, enabled]` — in-ear detection sits in the "extra features" command. */
    fun setInEarDetection(enabled: Boolean): ByteArray =
        build(Commands.SET_EXTRA_FEATURES, byteArrayOf(0x01, 0x01, if (enabled) 1 else 0))

    /** `[1]` enables, `[2]` disables — not a plain boolean. */
    fun setLowLatency(enabled: Boolean): ByteArray =
        build(Commands.SET_LOW_LATENCY, byteArrayOf(if (enabled) 1 else 2))

    /**
     * Bass boost sends `[value, selected]` (BassBoostItem, CONFIRMED): a 0..100 strength followed by
     * the on/off flag. The official app's seekbar is 0-100; the app-level UI hierarchy here is 1..5,
     * so the level is scaled linearly before it goes on the wire.
     */
    fun setBassBoost(enabled: Boolean, level: Int): ByteArray =
        build(
            Commands.SET_BASS_BOOST,
            byteArrayOf(
                if (enabled) bassValueForLevel(level) else 0,
                if (enabled) 1 else 0
            )
        )

    /**
     * "Ultra bass" on Espeon (CMF Buds Pro 2): `[switch, value]` (EQReimburse, CONFIRMED), with
     * the same 0..100 strength the boost command uses.
     */
    fun setBassEnhancer(enabled: Boolean, level: Int): ByteArray =
        build(
            Commands.SET_BASS_ENHANCER,
            byteArrayOf(
                if (enabled) 1 else 0,
                if (enabled) bassValueForLevel(level) else 0
            )
        )

    /** `[on]`, or `[on, headTracking]` where the device supports head tracking. */
    fun setSpatialAudio(enabled: Boolean, headTracking: Boolean? = null): ByteArray {
        val payload = if (headTracking == null) {
            byteArrayOf(if (enabled) 1 else 0)
        } else {
            byteArrayOf(if (enabled) 1 else 0, if (headTracking) 1 else 0)
        }
        return build(Commands.SET_SPATIAL_AUDIO, payload)
    }

    /** `[on]` */
    fun setSmartAnc(enabled: Boolean): ByteArray =
        build(Commands.SET_SMART_ANC, byteArrayOf(if (enabled) 1 else 0))

    /** `[mode]` */
    fun setScenarioMode(mode: Int): ByteArray =
        build(Commands.SET_SCENARIO_MODE, byteArrayOf(mode.toByte()))

    /** `[level]` */
    fun setPersonalizedAnc(level: Int): ByteArray =
        build(Commands.SET_PERSONALIZED_ANC, byteArrayOf(level.toByte()))

    /**
     * Gesture slot write, one slot per packet. Payload `[count, device, button, gesture, action]`
     * matches `ControlConfigurationEntity.obtainDataPacket()`: the slot count then each
     * `Operation(device, button, gesture, operation)`. [side] is 2 left / 3 right / 4 case,
     * [gestureType] the trigger (2 double tap, 3 triple tap, 7 press-and-hold, 9 double-tap-hold,
     * 10 rotate, 15 double-press-hold) and [action] the operation id (8 skip back, 9 skip forward,
     * 11 voice assistant, 18/19 volume up/down, 10/20/21/22 noise control variants, 1 no action, …).
     */
    fun setGesture(side: Int, gestureType: Int, action: Int): ByteArray =
        build(
            Commands.SET_GESTURES,
            byteArrayOf(0x01, side.toByte(), 0x01, gestureType.toByte(), action.toByte())
        )

    /** Multipoint: `[1]` on, `[0]` off. */
    fun setDual(enabled: Boolean): ByteArray =
        build(Commands.SET_DUAL, byteArrayOf(if (enabled) 1 else 0))

    /** LHDC/LDAC codec: `[1]` on, `[0]` off. */
    fun setLhdc(enabled: Boolean): ByteArray =
        build(Commands.SET_LHDC, byteArrayOf(if (enabled) 1 else 0))

    /**
     * Switch which paired device multipoint is actively using. The wire wants the 6-byte MAC of
     * the target device followed by an enable flag; the flag is `1` to make it current.
     */
    fun setConnectDevice(mac: ByteArray, enable: Boolean = true): ByteArray {
        val payload = ByteArray(7)
        for (i in 0 until minOf(6, mac.size)) payload[i] = mac[i]
        payload[6] = if (enable) 1 else 0
        return build(Commands.SET_CONNECT_DEVICE, payload)
    }

    /**
     * Dirac Opteo EQ: `[level, 0x00]` where 0..5 are the named presets and 6 selects custom,
     * matching the ear-web Dirac models (`setListeningMode(level)` sends `0xF01D` with payload
     * `[level, 0x00]`).
     */
    fun setDiracEq(level: Int): ByteArray =
        build(
            Commands.SET_DIRAC_EQ,
            byteArrayOf(level.coerceIn(0, DIRAC_LEVEL_MAX).toByte(), 0x00)
        )

    /**
     * Auto power-off, in minutes as a BasicInt. 0 means the earbuds stay on indefinitely; the
     * option values shown by the official app (10/20/30/60) are picked there, not on the wire.
     */
    fun setAutoPowerOff(minutes: Int): ByteArray =
        build(Commands.SET_POWER_OFF, byteArrayOf(minutes.coerceAtLeast(0).toByte()))

    /**
     * Case LED colour (Ear (1) across all five slots). [color] is an ARGB int; the wire wants
     * `[count, (idx, R, G, B) x 5]` and ignores alpha.
     */
    fun setCaseLedColor(color: Int): ByteArray {
        val payload = ByteArray(1 + 5 * 4)
        payload[0] = 0x05
        for (i in 0 until 5) {
            val base = 1 + i * 4
            payload[base] = (i + 1).toByte()
            payload[base + 1] = ((color shr 16) and 0xFF).toByte()   // R
            payload[base + 2] = ((color shr 8) and 0xFF).toByte()    // G
            payload[base + 3] = (color and 0xFF).toByte()            // B
        }
        return build(Commands.SET_CASE_LED, payload)
    }

    /**
     * Ear-tip seal check; the result is pushed back on PUSH_EAR_TIP_FIT. The official app sends
     * the same `[0x01]` this leaks into the "leak detect" command.
     */
    fun startFitTest(): ByteArray =
        build(Commands.SET_FIT_TEST, byteArrayOf(0x01))

    /**
     * Detail enhancement: `[enabled, level]` where level follows the official app's
     * Low/Mid/High labels (1/2/3). Models that only answer a bare on/off ignore the second byte.
     */
    fun setDetailEnhancement(enabled: Boolean, level: Int = 1): ByteArray =
        build(
            Commands.SET_DETAIL_ENHANCEMENT,
            byteArrayOf(if (enabled) 1 else 0, level.coerceIn(1, DETAIL_LEVEL_MAX).toByte())
        )

    /**
     * Ring an earbud. `side` follows the battery ids: 0x02 left, 0x03 right, 0x05 means "both",
     * which the official app sends without the side byte.
     */
    fun findDevice(side: Int, play: Boolean): ByteArray {
        val onOff: Byte = if (play) 1 else 0
        val payload = if (side == SIDE_SINGLE) {
            byteArrayOf(onOff)
        } else {
            byteArrayOf(side.toByte(), onOff)
        }
        return build(Commands.SET_FIND_DEVICE, payload)
    }

    fun setUtcTime(): ByteArray {
        val timestamp = System.currentTimeMillis() / 1000
        val payload = byteArrayOf(
            (timestamp and 0xFF).toByte(),
            ((timestamp shr 8) and 0xFF).toByte(),
            ((timestamp shr 16) and 0xFF).toByte(),
            ((timestamp shr 24) and 0xFF).toByte()
        )
        return build(Commands.SET_UTC_TIME, payload)
    }

    /**
     * Custom EQ bands, sent through the advanced-EQ command.
     * @param bands gain per band in dB, clamped to the range the earbuds accept
     */
    fun setCustomEq(bands: IntArray): ByteArray {
        val payload = bands
            .map { (it + EQ_GAIN_OFFSET).coerceIn(0, EQ_GAIN_OFFSET * 2).toByte() }
            .toByteArray()
        return build(Commands.SET_ADVANCED_EQ_VALUES, payload)
    }

    const val SIDE_LEFT = 0x02
    const val SIDE_RIGHT = 0x03
    const val SIDE_BOTH = 0x06
    /**
     * The charging case acts as its own gesture device in the key-configuration report. Each slot
     * is `[device, button, gesture, operation]` (ControlConfigurationEntity.Operation); the device
     * byte is 2 left / 3 right / 4 case (CONFIRMED from espeon `ControlItemViewModel.convertOptions()`
     * and the case-lock row `Operation(4, 1, 15, 40)`).
     */
    const val SIDE_CASE = 0x04
    /** Single-earpiece products (headphones) use this, and then the side byte is left out. */
    const val SIDE_SINGLE = 0x05
    /** The official app offers five steps; the firmware itself echoes anything it is given. */
    const val BASS_LEVEL_MAX = 5

    /** Maps the app's 1..5 slider step to the 0..100 strength the wire expects. */
    private fun bassValueForLevel(level: Int): Byte =
        (level.coerceIn(0, BASS_LEVEL_MAX) * 20).coerceIn(0, 100).toByte()
    /** Detail enhancement intensity steps: Low, Mid and High. */
    const val DETAIL_LEVEL_MAX = 3
    /** Dirac Opteo preset ids run 0..5 (named) with 6 reserved for custom. */
    const val DIRAC_LEVEL_MAX = 6
    private const val EQ_GAIN_OFFSET = 6
}
