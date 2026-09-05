package com.nothingbuds.protocol

/**
 * Command table for the Nothing/CMF earbuds SPP protocol.
 *
 * Recovered from the official Nothing X app and verified against a CMF Buds 2 Plus — see
 * `docs/PROTOCOL.md`. Commands are 16-bit values sent little-endian.
 *
 * A reply always carries the request command with bit 15 cleared, so `0xC007` is answered by
 * `0x4007` and `0xF00F` by `0x700F`. Use [responseOf] instead of hardcoding reply constants.
 */
object Commands {

    /** Requests have bit 15 set; the reply echoes the command without it. */
    const val MASK_RESPONSE: Int = 0x7FFF

    fun responseOf(command: Int): Int = command and MASK_RESPONSE

    // ---- Reads ------------------------------------------------------------------------------

    const val READ_BATTERY: Int = 0xC007
    const val READ_EARPHONE_STATUS: Int = 0xC00A
    const val READ_POWER_OFF: Int = 0xC011         // auto power-off time
    const val READ_SUPPORTED_FEATURES: Int = 0xC00D
    const val READ_EXTRA_FEATURES: Int = 0xC00E      // in-ear detection lives here
    /** Configuration blob: the app calls it a serial number, a B184 answers "2,2,<firmware>". */
    const val READ_CONFIGURATION: Int = 0xC006
    const val READ_DEVICE_MODEL: Int = 0xC01C
    const val READ_ANC: Int = 0xC01E
    const val READ_EQ: Int = 0xC01F
    const val READ_PERSONALIZED_ANC: Int = 0xC020
    const val READ_CASE_LED: Int = 0xC017          // box LED colour, Ear (1) only
    const val READ_GESTURES: Int = 0xC018
    const val READ_DUAL: Int = 0xC027              // multipoint
    const val READ_DUAL_DEVICE_LIST: Int = 0xC028 // connected/past multipoint devices
    const val READ_LHDC: Int = 0xC029
    const val READ_DIRAC_EQ: Int = 0xC050          // Dirac Opteo EQ (B172/B168)
    const val READ_UTC_TIME: Int = 0xC03F
    const val READ_LOW_LATENCY: Int = 0xC041
    const val READ_FIRMWARE: Int = 0xC042
    const val READ_BASS_BOOST: Int = 0xC04E
    const val READ_BASS_ENHANCER: Int = 0xC053   // "Ultra bass", Espeon (B172)
    const val READ_SPATIAL_AUDIO: Int = 0xC04F
    const val READ_SMART_FREE: Int = 0xC054
    const val READ_SMART_ANC: Int = 0xC055
    const val READ_DETAIL_ENHANCEMENT: Int = 0xC069
    const val READ_ADVANCED_EQ_MODE: Int = 0xC06C
    const val READ_ADVANCED_EQ_VALUES: Int = 0xC06D
    const val READ_SCENARIO_MODE: Int = 0xC071

    // ---- Writes -----------------------------------------------------------------------------

    const val SET_FIND_DEVICE: Int = 0xF002          // "whereAmI" — rings the earbuds
    const val SET_GESTURES: Int = 0xF003
    const val SET_EXTRA_FEATURES: Int = 0xF004       // in-ear detection
    const val SET_UTC_TIME: Int = 0xF00A
    const val SET_POWER_OFF: Int = 0xF00B            // auto power-off time
    const val SET_CASE_LED: Int = 0xF00D             // box LED RGB, Ear (1) only
    const val SET_ANC: Int = 0xF00F
    const val SET_EQ: Int = 0xF010
    const val SET_PERSONALIZED_ANC: Int = 0xF011
    /** Starts the seal/leak check that reports through PUSH_EAR_TIP_FIT. */
    const val SET_FIT_TEST: Int = 0xF014
    const val SET_DUAL: Int = 0xF01A                 // multipoint on/off
    const val SET_CONNECT_DEVICE: Int = 0xF01B       // switch active dual device (MAC + flag)
    const val SET_LHDC: Int = 0xF01C
    const val SET_DIRAC_EQ: Int = 0xF01D             // Dirac Opteo preset/custom
    const val SET_LOW_LATENCY: Int = 0xF040
    const val SET_BASS_BOOST: Int = 0xF051
    const val SET_BASS_ENHANCER: Int = 0xF057
    const val SET_SPATIAL_AUDIO: Int = 0xF052
    const val SET_SMART_FREE: Int = 0xF058
    const val SET_SMART_ANC: Int = 0xF059
    const val SET_DETAIL_ENHANCEMENT: Int = 0xF069
    const val SET_ADVANCED_EQ_MODE: Int = 0xF06C
    const val SET_ADVANCED_EQ_VALUES: Int = 0xF06D
    const val SET_SCENARIO_MODE: Int = 0xF075

    // ---- Unsolicited pushes -----------------------------------------------------------------

    /** The earbuds announce a battery change on their own. */
    const val PUSH_BATTERY: Int = 0xE001

    /** Sent whenever the listening mode changes, including from a touch gesture. */
    const val PUSH_ANC: Int = 0xE003

    /** Ear-tip fit test result. */
    const val PUSH_EAR_TIP_FIT: Int = 0xE00D

    // ---- Derived reply codes, for readable `when` branches -----------------------------------

    val RESPONSE_BATTERY: Int = responseOf(READ_BATTERY)
    val RESPONSE_ANC: Int = responseOf(READ_ANC)
    val RESPONSE_EQ: Int = responseOf(READ_EQ)
    val RESPONSE_FIRMWARE: Int = responseOf(READ_FIRMWARE)
    val RESPONSE_EXTRA_FEATURES: Int = responseOf(READ_EXTRA_FEATURES)
    val RESPONSE_LOW_LATENCY: Int = responseOf(READ_LOW_LATENCY)
    val RESPONSE_BASS_BOOST: Int = responseOf(READ_BASS_BOOST)
    val RESPONSE_BASS_ENHANCER: Int = responseOf(READ_BASS_ENHANCER)
    val RESPONSE_SPATIAL_AUDIO: Int = responseOf(READ_SPATIAL_AUDIO)
    val RESPONSE_ADVANCED_EQ_VALUES: Int = responseOf(READ_ADVANCED_EQ_VALUES)
    val RESPONSE_CONFIGURATION: Int = responseOf(READ_CONFIGURATION)
    val RESPONSE_GESTURES: Int = responseOf(READ_GESTURES)
    val RESPONSE_CASE_LED: Int = responseOf(READ_CASE_LED)
    val RESPONSE_DUAL: Int = responseOf(READ_DUAL)
    val RESPONSE_DUAL_DEVICE_LIST: Int = responseOf(READ_DUAL_DEVICE_LIST)
    val RESPONSE_LHDC: Int = responseOf(READ_LHDC)
    val RESPONSE_DIRAC_EQ: Int = responseOf(READ_DIRAC_EQ)
    val RESPONSE_POWER_OFF: Int = responseOf(READ_POWER_OFF)
    val RESPONSE_DETAIL_ENHANCEMENT: Int = responseOf(READ_DETAIL_ENHANCEMENT)
    val RESPONSE_PUSH_BATTERY: Int = responseOf(PUSH_BATTERY)
    val RESPONSE_PUSH_ANC: Int = responseOf(PUSH_ANC)
    val RESPONSE_PUSH_EAR_TIP_FIT: Int = responseOf(PUSH_EAR_TIP_FIT)

    val ACK_SET_ANC: Int = responseOf(SET_ANC)
    val ACK_SET_EQ: Int = responseOf(SET_EQ)
    val ACK_SET_BASS_BOOST: Int = responseOf(SET_BASS_BOOST)
    val ACK_SET_BASS_ENHANCER: Int = responseOf(SET_BASS_ENHANCER)
    val ACK_SET_LOW_LATENCY: Int = responseOf(SET_LOW_LATENCY)
    val ACK_SET_EXTRA_FEATURES: Int = responseOf(SET_EXTRA_FEATURES)
    val ACK_SET_SPATIAL_AUDIO: Int = responseOf(SET_SPATIAL_AUDIO)
    val ACK_SET_DUAL: Int = responseOf(SET_DUAL)
    val ACK_SET_CONNECT_DEVICE: Int = responseOf(SET_CONNECT_DEVICE)
    val ACK_SET_DIRAC_EQ: Int = responseOf(SET_DIRAC_EQ)
}

/**
 * Listening modes, as sent in byte 1 of the [Commands.SET_ANC] payload and reported back in
 * group 0x01 of the ANC report.
 */
enum class AncMode(val value: Byte) {
    OFF(0x05),
    LOW(0x03),
    MID(0x02),
    HIGH(0x01),
    ADAPTIVE(0x04),
    TRANSPARENCY(0x07);

    val isAnc: Boolean get() = this != OFF && this != TRANSPARENCY

    companion object {
        /** Value → mode, precomputed so the hot response path is an O(1) map lookup. */
        private val BY_VALUE: Map<Int, AncMode> by lazy { entries.associateBy { it.value.toInt() } }

        fun fromValue(value: Int): AncMode = BY_VALUE[value] ?: OFF

        /**
         * Quick-toggle cycle used by the notification hub and the Quick Settings tile:
         * ANC -> Transparency -> Off -> ANC.
         *
         * @param ancLevel which ANC step to jump to when turning ANC back on.
         */
        fun cycle(current: AncMode, hasTransparency: Boolean, ancLevel: AncMode = HIGH): AncMode {
            return when (current) {
                OFF -> if (ancLevel.isAnc) ancLevel else HIGH
                TRANSPARENCY -> OFF
                else -> if (hasTransparency) TRANSPARENCY else OFF
            }
        }
    }
}

/**
 * EQ presets for [Commands.SET_EQ]. Values follow the official app's `initSimpleEQItem()`
 * (CONFIRMED): 0 Balanced, 1 More Voice, 2 More Treble, 3 More Bass, 5 Custom. The declared
 * order also drives the order they are shown in the equalizer screen.
 */
enum class EqPreset(val value: Byte) {
    BALANCED(0x00),
    MORE_BASS(0x03),
    MORE_TREBLE(0x02),
    VOICE(0x01),
    CUSTOM(0x05);

    companion object {
        /** Value → preset, precomputed for O(1) lookups. */
        private val BY_VALUE: Map<Int, EqPreset> by lazy { entries.associateBy { it.value.toInt() } }

        fun fromValue(value: Int): EqPreset = BY_VALUE[value] ?: BALANCED
    }
}
