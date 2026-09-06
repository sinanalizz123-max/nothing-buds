package com.nothingbuds.data

import com.nothingbuds.protocol.AncMode
import com.nothingbuds.protocol.EqPreset
import com.nothingbuds.protocol.ResponseParser

/**
 * Represents the current state of connected earbuds.
 */
data class EarbudsState(
    val isConnected: Boolean = false,
    val deviceName: String = "",
    /** Stable Bluetooth MAC of the connected earbuds, used for identity in events. */
    val deviceAddress: String = "",
    val deviceModel: DeviceModel? = null,
    val battery: ResponseParser.BatteryStatus = ResponseParser.BatteryStatus(),
    val ancMode: AncMode = AncMode.OFF,
    /** ANC level the earbuds return to when ANC is switched back on. */
    val ancLevel: AncMode = AncMode.HIGH,
    val eqPreset: EqPreset = EqPreset.BALANCED,
    val customEq: IntArray = IntArray(8) { 0 },
    val inEarDetection: Boolean = true,
    val lowLatencyMode: Boolean = false,
    val enhancedBass: Boolean = false,
    /** Bass boost strength; the earbuds expose a level, not just an on/off. */
    val bassLevel: Int = 0,
    val spatialAudio: Boolean = false,
    val gestures: List<ResponseParser.GestureSlot> = emptyList(),
    val dualDevice: Boolean = false,
    val dualDevices: List<ResponseParser.DualDevice> = emptyList(),
    /** Dirac Opteo EQ preset id (0..5 named, 6 custom); only meaningful on Dirac models. */
    val diracEq: Int = 0,
    val lhdc: Boolean = false,
    /** 0 means the earbuds never power themselves off. */
    val autoPowerOffMinutes: Int = 0,
    /** Case LED color as ARGB, Ear (1) only. */
    val caseLedColor: Int = 0,
    val detailEnhancement: Boolean = false,
    /** Detail enhancement intensity, 1 = Low .. 3 = High. */
    val detailEnhancementLevel: Int = 1,
    /** Ear-tip seal result pushed by the earbuds after a fit test. */
    val fitTestResult: ResponseParser.FitResult? = null,
    val firmwareVersion: String = "",
    val configuration: String = "",
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EarbudsState
        return isConnected == other.isConnected &&
                deviceName == other.deviceName &&
                deviceAddress == other.deviceAddress &&
                deviceModel == other.deviceModel &&
                battery == other.battery &&
                ancMode == other.ancMode &&
                ancLevel == other.ancLevel &&
                eqPreset == other.eqPreset &&
                customEq.contentEquals(other.customEq) &&
                inEarDetection == other.inEarDetection &&
                lowLatencyMode == other.lowLatencyMode &&
                enhancedBass == other.enhancedBass &&
                bassLevel == other.bassLevel &&
                spatialAudio == other.spatialAudio &&
                gestures == other.gestures &&
                dualDevice == other.dualDevice &&
                dualDevices == other.dualDevices &&
                diracEq == other.diracEq &&
                lhdc == other.lhdc &&
                autoPowerOffMinutes == other.autoPowerOffMinutes &&
                caseLedColor == other.caseLedColor &&
                detailEnhancement == other.detailEnhancement &&
                detailEnhancementLevel == other.detailEnhancementLevel &&
                fitTestResult == other.fitTestResult &&
                firmwareVersion == other.firmwareVersion &&
                configuration == other.configuration
    }

    override fun hashCode(): Int {
        var result = isConnected.hashCode()
        result = 31 * result + deviceName.hashCode()
        result = 31 * result + deviceAddress.hashCode()
        result = 31 * result + (deviceModel?.hashCode() ?: 0)
        result = 31 * result + battery.hashCode()
        result = 31 * result + ancMode.hashCode()
        result = 31 * result + ancLevel.hashCode()
        result = 31 * result + eqPreset.hashCode()
        result = 31 * result + customEq.contentHashCode()
        result = 31 * result + inEarDetection.hashCode()
        result = 31 * result + lowLatencyMode.hashCode()
        result = 31 * result + enhancedBass.hashCode()
        result = 31 * result + bassLevel
        result = 31 * result + spatialAudio.hashCode()
        result = 31 * result + gestures.hashCode()
        result = 31 * result + dualDevice.hashCode()
        result = 31 * result + dualDevices.hashCode()
        result = 31 * result + diracEq
        result = 31 * result + lhdc.hashCode()
        result = 31 * result + autoPowerOffMinutes
        result = 31 * result + caseLedColor
        result = 31 * result + detailEnhancement.hashCode()
        result = 31 * result + detailEnhancementLevel
        result = 31 * result + (fitTestResult?.hashCode() ?: 0)
        result = 31 * result + firmwareVersion.hashCode()
        result = 31 * result + configuration.hashCode()
        return result
    }
}

/**
 * Device model information.
 */
data class DeviceModel(
    val id: String,           // e.g., "B184"
    val name: String,         // e.g., "CMF Buds 2 Plus"
    val fastPairIds: List<String>,
    val hasAnc: Boolean,
    val hasTransparency: Boolean,
    val hasEnhancedBass: Boolean,
    val hasCustomEq: Boolean,
    val hasLowLatency: Boolean,
    val hasInEarDetection: Boolean,
    val hasGestureControl: Boolean,
    val usesListeningMode: Boolean = false,  // B172, B168, B179, B184, B185 use listening mode
    val hasAdaptiveAnc: Boolean = false,     // Some devices support adaptive ANC
    val hasDual: Boolean = false,            // multipoint
    val hasDiracEq: Boolean = false,         // Dirac Opteo EQ — B172/B168 only
    val hasLhdc: Boolean = false,            // LHDC/LDAC codec toggle
    val hasDetailEnhancement: Boolean = false,
    val hasBassEnhancer: Boolean = false,     // "Ultra bass" via 0xC053/0xF057 — B172 only
    val hasCaseLed: Boolean = false,         // box LED colour — Ear (1) only
    val hasSmartDial: Boolean = false,       // case rotary dial (supportSmartDial) — B172 only
    val hasEarTipFitTest: Boolean = false,
    val hasAutoPowerOff: Boolean = true,
)

/**
 * Known device models from ear-web.
 */
object DeviceModels {

    val CMF_BUDS_2_PLUS = DeviceModel(
        id = "B184",
        name = "CMF Buds 2 Plus",
        fastPairIds = listOf("4AEB6E", "5C587F"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = true,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        usesListeningMode = true,
        hasAdaptiveAnc = true,
        hasDual = true,
        hasLhdc = true,
        hasDetailEnhancement = true,
        hasEarTipFitTest = true,
    )

    val CMF_BUDS_2 = DeviceModel(
        id = "B179",
        name = "CMF Buds 2",
        fastPairIds = listOf("19EF24", "FF2AB0", "D9AB5D"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = true,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        usesListeningMode = true,
        hasAdaptiveAnc = true,
        hasDetailEnhancement = true,
        hasEarTipFitTest = true,
    )

    val CMF_BUDS_PRO_2 = DeviceModel(
        id = "B172",
        name = "CMF Buds Pro 2",
        fastPairIds = listOf("F29566", "CA36A6", "A7B220", "2B353E"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = true,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        usesListeningMode = true,
        hasAdaptiveAnc = true,
        hasDual = true,
        hasDiracEq = true,
        hasLhdc = true,
        hasDetailEnhancement = true,
        hasBassEnhancer = true,
        hasEarTipFitTest = true,
        hasSmartDial = true,
    )

    val CMF_BUDS_PRO = DeviceModel(
        id = "B163",
        name = "CMF Buds Pro",
        fastPairIds = listOf("5F8F82", "ADD2C4", "2EB1CA"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = false,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
    )

    val CMF_BUDS = DeviceModel(
        id = "B168",
        name = "CMF Buds",
        fastPairIds = listOf("150A27", "ACCE54", "D35E18"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = true,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        usesListeningMode = true,
        hasAdaptiveAnc = true,
        hasDiracEq = true,
    )

    val CMF_BUDS_2A = DeviceModel(
        id = "B185",
        name = "CMF Buds 2a",
        fastPairIds = listOf("70F8E3", "ED5412"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = true,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        usesListeningMode = true,
        hasAdaptiveAnc = true,
    )

    val NOTHING_EAR_1 = DeviceModel(
        id = "B181",
        name = "Nothing Ear (1)",
        fastPairIds = listOf("31D53D", "624011"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = false,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        hasCaseLed = true,
    )

    val NOTHING_EAR_2 = DeviceModel(
        id = "B155",
        name = "Nothing Ear (2)",
        fastPairIds = listOf("DEE8C0", "ACC520"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = false,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        hasDual = true,
        hasLhdc = true,
        hasDetailEnhancement = true,
        hasEarTipFitTest = true,
    )

    val NOTHING_EAR = DeviceModel(
        id = "B171",
        name = "Nothing Ear",
        fastPairIds = listOf("A20444", "FEB1C7"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = false,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
    )

    val NOTHING_EAR_A = DeviceModel(
        id = "B162",
        name = "Nothing Ear (a)",
        fastPairIds = listOf("03464E", "5E3FBC", "8B6380"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = false,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        hasDual = true,
        hasLhdc = true,
        hasDetailEnhancement = true,
        hasEarTipFitTest = true,
    )

    val NOTHING_EAR_STICK = DeviceModel(
        id = "B157",
        name = "Nothing Ear (stick)",
        fastPairIds = listOf("1016DD"),
        hasAnc = false,
        hasTransparency = false,
        hasEnhancedBass = false,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
    )

    val NOTHING_EAR_OPEN = DeviceModel(
        id = "B174",
        name = "Nothing Ear (open)",
        fastPairIds = listOf("FC3AAF"),
        hasAnc = false,
        hasTransparency = false,
        hasEnhancedBass = false,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = true,
        hasGestureControl = true,
        hasEarTipFitTest = true,
    )

    val CMF_NECKBAND_PRO = DeviceModel(
        id = "B164",
        name = "CMF Neckband Pro",
        fastPairIds = listOf("4DFC4A", "26C190", "AE35FD"),
        hasAnc = true,
        hasTransparency = true,
        hasEnhancedBass = false,
        hasCustomEq = true,
        hasLowLatency = true,
        hasInEarDetection = false,
        hasGestureControl = false,
    )

    val ALL_MODELS = listOf(
        CMF_BUDS_2_PLUS,
        CMF_BUDS_2,
        CMF_BUDS_PRO_2,
        CMF_BUDS_PRO,
        CMF_BUDS,
        CMF_BUDS_2A,
        NOTHING_EAR_1,
        NOTHING_EAR_2,
        NOTHING_EAR,
        NOTHING_EAR_A,
        NOTHING_EAR_STICK,
        NOTHING_EAR_OPEN,
        CMF_NECKBAND_PRO,
    )

    /**
     * Name/id → model, precomputed once so lookups don't rescan and re-lowercase every call.
     */
    private val byName: Map<String, DeviceModel> by lazy {
        buildMap {
            for (model in ALL_MODELS) {
                put(model.name.lowercase(), model)
                put(model.id.lowercase(), model)
            }
        }
    }

    /**
     * Fast Pair id (upper-cased) → model, also precomputed once.
     */
    private val byFastPairId: Map<String, DeviceModel> by lazy {
        ALL_MODELS
            .flatMap { model -> model.fastPairIds.map { it.uppercase() to model } }
            .toMap()
    }

    /**
     * Find device model by Bluetooth device name. Exact matches are a map hit; a substring pass
     * is kept as a fallback for names that include extra words (e.g. "CMF Buds 2 Plus (LE)") and
     * picks the LONGEST matching model name so "CMF Buds 2a ..." cannot match plain "CMF Buds 2".
     */
    fun findByName(name: String): DeviceModel? {
        val lowerName = name.lowercase()
        byName[lowerName]?.let { return it }

        var best: DeviceModel? = null
        var bestLen = 0
        for (model in ALL_MODELS) {
            val modelName = model.name.lowercase()
            if (lowerName.contains(modelName)) {
                if (modelName.length > bestLen) {
                    best = model
                    bestLen = modelName.length
                }
            }
        }
        return best
    }

    /**
     * Loose name heuristic for the case where the device is not in [ALL_MODELS]: a Nothing/CMF
     * product shows one of these words in its Bluetooth name.
     */
    fun looksLikeEarbuds(name: String?): Boolean {
        if (name == null) return false
        val lower = name.lowercase()
        return lower.contains("nothing") || lower.contains("cmf") || lower.contains("ear")
    }

    /**
     * Find device model by Fast Pair ID.
     */
    fun findByFastPairId(id: String): DeviceModel? =
        byFastPairId[id.uppercase()]
}
