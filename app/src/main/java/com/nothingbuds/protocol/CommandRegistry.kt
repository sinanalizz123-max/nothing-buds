package com.nothingbuds.protocol

/**
 * Command constants recovered from the official Nothing X 3.8.0 decompile
 * (see re/official-command-table.md — the authoritative spec).
 *
 * Encoding: 16-bit command = base | index.
 *   Query   = 0xC000 (device -> app responses, read)
 *   Set     = 0xF000 (app -> device requests, write)
 *   Notify  = 0xE000 (unsolicited device events)
 *   Debug   = 0xFC00
 */
object CommandRegistry {
    // ---------- Query (GET) base 0xC000 ----------
    const val GET_PROTOCOL_VERSION = 0xC001
    const val GET_FIND_EAR_STATE = 0xC002
    const val GET_REMOTE_MTU = 0xC003
    const val GET_REMOTE_VID = 0xC004
    const val GET_REMOTE_DEVICE_IDENTIFICATION = 0xC005
    const val GET_REMOTE_CONFIGURATION = 0xC006
    const val GET_REMOTE_BATTERY_LEVEL = 0xC007
    const val GET_UPGRADE_CAPABILITY = 0xC008
    const val GET_SUPPORTED_GESTURE = 0xC009
    const val GET_EARPHONE_STATUS = 0xC00A
    const val GET_REMOTE_EXTRA_VERSION_CODE = 0xC00B
    const val GET_REMOTE_COLOR_ID = 0xC00C
    const val GET_SUPPORTED_FEATURE = 0xC00D
    const val GET_EXTRA_FEATURE_STATUS = 0xC00E
    const val GET_EQ_ID = 0xC00F
    const val GET_HIGH_VOLUME_GAIN_LEVEL = 0xC010
    const val GET_AUTO_POWER_OFF_TIME = 0xC011
    const val GET_EARPHONE_CONNECTED_STATUS = 0xC013
    const val GET_VOLUME = 0xC014
    const val GET_CODEC_CAPABILITY = 0xC015
    const val GET_MANUFACTURE = 0xC016
    const val GET_BOX_LED_COLOR = 0xC017
    const val GET_KEY_CONFIGURATION = 0xC018
    const val GET_DEVICE_WORKING_STATUS = 0xC019
    const val GET_DEVICE_MODEL = 0xC01C
    const val GET_NOISE_REDUCTION_CONFIGURATION = 0xC01D
    const val GET_CURRENT_NOISE_REDUCTION = 0xC01E
    const val GET_EQ_MODE = 0xC01F
    const val GET_PERSONALIZED_ANC = 0xC020
    const val GET_PERSONALIZED_NOISE_VALUE = 0xC021
    const val GET_MIMI_ENABLE = 0xC022
    const val GET_MIMI_INTENSITY = 0xC023
    const val GET_MIMI_PRESET_ID = 0xC024
    const val GET_MIMI_FITTING_TECH_LEVEL = 0xC025
    const val GET_3D_MODE = 0xC026
    const val GET_DUAL_ENABLE = 0xC027
    const val GET_DUAL_DEVICE_LIST = 0xC028
    const val GET_LHDC_COMMANDS = 0xC029
    const val GET_SUPPORTED_NOTIFICATION = 0xC03D
    const val GET_REGISTERED_NOTIFICATION = 0xC03E
    const val GET_HOST_UTC_TIME = 0xC03F
    const val GET_HOST_LAG_MODE = 0xC041
    const val GET_HOST_VERSION_DEVICE = 0xC042
    const val GET_ADAPTIVE_EQ_MODE = 0xC043
    const val GET_CUSTOM_EQ_VALUE = 0xC044
    const val GET_BASS_BOOST = 0xC04E
    const val GET_SPATIAL_AUDIO = 0xC04F
    const val GET_ANC_FIR_MODE = 0xC051
    const val GET_BASS_ENHANCER_MODE = 0xC053
    const val GET_SMART_FREE_MODE = 0xC054
    const val GET_SMART_ANC_MODE = 0xC055
    const val GET_LE_SWITCH = 0xC056
    const val GET_SYSTEM_AUDIO = 0xC057
    const val GET_HEADTRACK_START = 0xC058
    const val GET_LE_AUDIO_CONNECT_MODE = 0xC059
    const val GET_BOX_VERSION = 0xC05C
    const val GET_MUTUALLY_EXCLUSIVE = 0xC062
    const val GET_SKY_WALK_SUPPORT = 0xC063
    const val GET_DETAIL_ENHANCEMENT = 0xC069
    const val GET_THIRD_DRIVER_ADV_CUSTOM_EQ_MODE = 0xC06C
    const val GET_THIRD_DRIVER_ADV_CUSTOM_EQ_VALUE = 0xC06D
    const val GET_SCENARIO_MODE = 0xC071

    // ---------- Set base 0xF000 ----------
    const val SET_PROTOCOL_ACTIVATED = 0xF001
    const val SET_WHERE_AM_I = 0xF002
    const val SET_KEY_CONFIGURATION = 0xF003
    const val SET_EXTRA_FEATURE_STATUS = 0xF004
    const val SET_EQ_STATUS = 0xF007
    const val SET_HIGH_VOLUME_GAIN_LEVEL = 0xF008
    const val SET_UTC_TIME = 0xF00A
    const val SET_AUTO_POWER_OFF_TIME = 0xF00B
    const val SET_BOX_LED_COLOR = 0xF00D
    const val SET_NOISE_REDUCTION_CONFIGURATION = 0xF00E
    const val SET_CURRENT_NOISE_REDUCTION = 0xF00F
    const val SET_EQ_MODE = 0xF010
    const val SET_PERSONALIZED = 0xF011
    const val SET_CALIBRATION = 0xF012
    const val SET_CALIBRATION_FORCE = 0xF013
    const val SET_LEAK_DETECT = 0xF014
    const val SET_MIMI_ENABLE = 0xF015
    const val SET_MIMI_INTENSITY = 0xF016
    const val SET_MIMI_PRESET_PAYLOAD = 0xF017
    const val SET_MIMI_PRESET_ID = 0xF018
    const val SET_3D_SOUND = 0xF019
    const val SET_DUAL_ENABLE = 0xF01A
    const val SET_CONNECT_DEVICE = 0xF01B
    const val SET_LHDC_COMMANDS = 0xF01C
    const val SET_LAG_MODE = 0xF040
    const val SET_CUSTOM_EQ = 0xF041
    const val SET_ADAPTIVE_EQ = 0xF042
    const val SET_BASS_BOOST = 0xF051
    const val SET_SPATIAL_AUDIO = 0xF052
    const val SET_FIR_ANC_MODE = 0xF053
    const val SET_BASS_ENHANCER_MODE = 0xF057
    const val SET_SMART_FREE_MODE = 0xF058
    const val SET_SMART_ANC_MODE = 0xF059
    const val SET_LE_SWITCH_MODEL = 0xF05A
    const val SET_SYSTEM_AUDIO = 0xF05B
    const val SET_ESSENTIAL_SPACE_STATUS = 0xF062
    const val SET_DETAIL_ENHANCEMENT = 0xF069
    const val SET_THIRD_DRIVER_ADV_CUSTOM_EQ_MODE = 0xF06C
    const val SET_THIRD_DRIVER_ADV_CUSTOM_EQ_VALUE = 0xF06D
    const val SET_SCENARIO_MODE = 0xF075
    const val SET_ADVANCE_CUSTOM_EQ_MODE = 0xF04F
    const val GET_ADVANCE_CUSTOM_EQ_MODE = 0xC04C
    const val RESTORE_FACTORY_SETTING = 0xF03D
    const val REGISTER_NOTIFICATION = 0xF03E
    const val UNREGISTER_NOTIFICATION = 0xF03F

    // ---------- Notify base 0xE000 ----------
    const val EVENT_BATTERY_CHANGED = 0xE001
    const val EVENT_DEVICE_STATUS_CHANGED = 0xE002
    const val EVENT_NOISE_REDUCTION_LEVEL_CHANGED = 0xE003
    const val EVENT_GAME_MODE_CHANGED = 0xE005
    const val EVENT_DUAL_DEVICE_SWITCH_STATE = 0xE006
    const val EVENT_WORKING_STATUS_CHANGE = 0xE009
    const val EVENT_LED_COLOR_SYNC_NOTIFICATION = 0xE00B
    const val EVENT_PERSONALIZE_SYNC_NOTIFICATION = 0xE00C
    const val EVENT_TIP_FIT_RESULT = 0xE00D

    // ---------- Legacy aliases used by the original skeleton ----------
    const val GET_BATTERY_LEVEL = GET_REMOTE_BATTERY_LEVEL
    const val GET_CURRENT_NOISE_RED = GET_CURRENT_NOISE_REDUCTION
    const val SET_CURRENT_NOISE_RED = SET_CURRENT_NOISE_REDUCTION
    const val EVENT_NOISE_RED_LEVEL_CHG = EVENT_NOISE_REDUCTION_LEVEL_CHANGED

    // ---------- ExtraFeatureStatus feature type enum (types 1..22) ----------
    object ExtraFeature {
        const val SMART_ANC = 1
        const val NOISE_LEVEL = 2
        const val REAL_TIME_ANC_ANIMATION = 3
        const val FIND_NEW_VERSION = 4
        const val BASIC_RUNTIME_ACTIVITY = 5
        const val NEGATIVE_ONE_HEART_RATE = 6
        const val LEAK_DETECTION = 7
        const val MIMI_HEARING_PROFILES = 8
        const val SPATIAL_MODE = 9
        const val HIGH_VOLUME_UPGRADE = 10
        const val CONNECT_PRIORITY = 11
        const val MULTI_DEVICE_SWITCH = 12
        const val LOCAL_VOICE_RECORDING = 13
        const val BISTO = 14
        const val SCP_UPDATE = 15
        const val TIP_FIT_TEST = 16
        const val SMART_CASE_AUDIO = 17
        const val SMART_CASE_MIC = 18
        const val SMART_CASE_SWITCH = 19
        const val SKY_WALK = 20
        const val DETAILED_EQ = 21
        const val FOTA_TEST = 22
    }
}
