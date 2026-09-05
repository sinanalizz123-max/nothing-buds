package com.nothing.core.ext;

import android.util.Base64;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.entity.AdvanceCustomEQEntity;
import com.nothing.core.entity.ClarityBoostEntity;
import com.nothing.core.entity.EQEntity;
import com.nothing.core.entity.EQModeEntity;
import com.nothing.core.entity.MidUnitAdvanceCustomEQModeEntity;
import com.nothing.core.entity.SimpleEQEntity;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TWSDeviceExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\u001a\u001b\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\u001b\u0010\u0018\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u001a\u001a\u001b\u0010\u001b\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\n\u0010\u001d\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010\u001e\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010\u001f\u001a\u00020\u0013*\u00020\u0014\u001a\u0012\u0010 \u001a\u00020\u0013*\u00020\u00142\u0006\u0010!\u001a\u00020\"\u001a\u001b\u0010#\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u001a\u001a\n\u0010$\u001a\u00020\u0013*\u00020\u0014\u001a\u001b\u0010%\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\u0014\u0010&\u001a\u00020\u0013*\u00020\u00142\b\b\u0002\u0010'\u001a\u00020(\u001a \u0010)\u001a\u00020\u0013*\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u00012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010+\u001a'\u0010,\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u00a2\u0006\u0002\u00100\u001a\u0016\u00101\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u00102\u001a\u0004\u0018\u000103\u001a \u00104\u001a\u00020\u0013*\u00020\u00142\b\b\u0002\u0010*\u001a\u00020\u00012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010+\u001a\u0016\u00105\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010'\u001a\u0004\u0018\u000106\u001a\u0016\u00107\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010'\u001a\u0004\u0018\u000108\u001a\u001b\u00109\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\u0014\u0010:\u001a\u00020\u0013*\u00020\u00142\b\b\u0002\u00107\u001a\u00020\u0001\u001a'\u00109\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010<\u001a'\u0010=\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010<\u001a\u001b\u0010>\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u001a\u001a\u001b\u0010?\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\n\u0010@\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010A\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010B\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010C\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010D\u001a\u00020\u0013*\u00020\u0014\u001a\u001b\u0010E\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a'\u0010F\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010H\u001a'\u0010I\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010<\u001a\u001b\u0010J\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u001a\u001a\n\u0010K\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010L\u001a\u00020\u0013*\u00020\u0014\u001a\u0014\u0010M\u001a\u00020\u0013*\u00020\u00142\b\b\u0002\u00107\u001a\u00020\u0001\u001a\u001b\u0010N\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\u001b\u0010O\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0002\u0010\u001a\u001a\u001a\u0010P\u001a\u00020\u0013*\u00020\u00142\u0006\u0010Q\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u001b\u0010R\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010S\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\n\u0010T\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010U\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010V\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010W\u001a\u00020\u0013*\u00020\u0014\u001a\u001b\u0010X\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\u001b\u0010Y\u001a\u00020\u0013*\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0002\u0010\u0017\u001a\n\u0010Z\u001a\u00020\u0013*\u00020\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006["}, d2 = {"ZERO", "", "ONE", "TWO", "THREE", "FOUR", "FIVE", "MILLIS_UNIT", "GET_DIRAC_OPTEO_EQ", "SET_DIRAC_OPTEO_EQ", "SET_ADVANCE_CUSTOM_EQ_MODE", "SET_ADVANCE_CUSTOM_EQ_VALUE", "SET_SIMPLE_CUSTOM_EQ", "SET_EQ_MODE", "GET_ADVANCE_CUSTOM_EQ_MODE", "GET_ADVANCE_CUSTOM_EQ_VALUE", "GET_SIMPLE_CUSTOM_EQ", "GET_EQ_MODE", "LHDC", "Lcom/nothing/protocol/device/TWSDeviceBuilder;", "Lcom/nothing/protocol/device/TWSDevice;", "enable", "", "(Lcom/nothing/protocol/device/TWSDevice;Ljava/lang/Boolean;)Lcom/nothing/protocol/device/TWSDeviceBuilder;", "thirdSound", "value", "(Lcom/nothing/protocol/device/TWSDevice;Ljava/lang/Integer;)Lcom/nothing/protocol/device/TWSDeviceBuilder;", "mimiSwitch", "isEnable", "mimiIntensity", "mimiPreset", "mimiFetchLevel", "mimiPresetPayLoad", "payload", "", "personalizedAnc", "calibration", "lhdc", "advanceCustomEQMode", "entity", "Lcom/nothing/core/entity/AdvanceCustomEQEntity$Mode;", "advanceCustomEQValue", "profileIndex", "Lcom/nothing/core/entity/EQEntity;", "clarityBoost", "enabled", "level", "Lcom/nothing/core/entity/ClarityBoostEntity$Level;", "(Lcom/nothing/protocol/device/TWSDevice;Ljava/lang/Boolean;Lcom/nothing/core/entity/ClarityBoostEntity$Level;)Lcom/nothing/protocol/device/TWSDeviceBuilder;", "midUnitAdvanceCustomEQMode", "mode", "Lcom/nothing/core/entity/MidUnitAdvanceCustomEQModeEntity$Mode;", "midUnitAdvanceCustomEQValue", "simpleCustomEQ", "Lcom/nothing/core/entity/SimpleEQEntity;", "eqMode", "Lcom/nothing/core/entity/EQModeEntity$Mode;", "lowSoundSwitch", "diracOpteoEQ", "switch", "(Lcom/nothing/protocol/device/TWSDevice;Ljava/lang/Boolean;Ljava/lang/Integer;)Lcom/nothing/protocol/device/TWSDeviceBuilder;", "bassBoostSwitch", "dual", "spatialAudioSwitch", "battery", "firmwareVersion", "earphoneStatus", "utcTime", "remoteConfiguration", "lagMode", "spatialAudio", "head", "(Lcom/nothing/protocol/device/TWSDevice;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/nothing/protocol/device/TWSDeviceBuilder;", "bassBoost", "scenarioMode", "keyConfiguration", "customEQValue", "eQMode", "extraFeatureStatus", "noiseReduction", "whereAmI", "deviceType", "debugInfo", "isOpen", "upgradeCapability", "remoteColor", "supportFeature", "deviceModel", "smartAnc", "smartFree", "mutuallyExclusive", "nt_ear_GoogleStoreRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TWSDeviceExtKt {
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int GET_ADVANCE_CUSTOM_EQ_MODE = 49228;
    private static final int GET_ADVANCE_CUSTOM_EQ_VALUE = 49229;
    public static final int GET_DIRAC_OPTEO_EQ = 49232;
    private static final int GET_EQ_MODE = 49183;
    private static final int GET_SIMPLE_CUSTOM_EQ = 49220;
    private static final int MILLIS_UNIT = 1000;
    private static final int ONE = 1;
    private static final int SET_ADVANCE_CUSTOM_EQ_MODE = 61519;
    private static final int SET_ADVANCE_CUSTOM_EQ_VALUE = 61520;
    public static final int SET_DIRAC_OPTEO_EQ = 61469;
    private static final int SET_EQ_MODE = 61456;
    private static final int SET_SIMPLE_CUSTOM_EQ = 61505;
    private static final int THREE = 3;
    private static final int TWO = 2;
    private static final int ZERO = 0;

    public static /* synthetic */ TWSDeviceBuilder LHDC$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return LHDC(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder LHDC(TWSDevice tWSDevice, Boolean bool) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_LHDC_COMMANDS);
        tWSDeviceBuilder.setSetPayload(DataExtKt.toByteArray$default(Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : 0, 0, 1, (Object) null));
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_LHDC_COMMANDS);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder thirdSound$default(TWSDevice tWSDevice, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return thirdSound(tWSDevice, num);
    }

    public static final TWSDeviceBuilder thirdSound(TWSDevice tWSDevice, Integer num) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_3D_SOUND);
        tWSDeviceBuilder.setSetPayload(num != null ? DataExtKt.toByteArray$default(num.intValue(), 0, 1, (Object) null) : null);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_3D_MODE);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder mimiSwitch$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return mimiSwitch(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder mimiSwitch(TWSDevice tWSDevice, Boolean bool) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_MIMI_ENABLE);
        tWSDeviceBuilder.setSetPayload(DataExtKt.toByteArray$default(Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : 0, 0, 1, (Object) null));
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_MIMI_ENABLE);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder mimiIntensity(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setCommand(ProtocolConstant.Set.SET_MIMI_INTENSITY);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_MIMI_INTENSITY);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder mimiPreset(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setCommand(ProtocolConstant.Set.SET_MIMI_PRESET_ID);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_MIMI_PRESET_ID);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder mimiFetchLevel(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_MIMI_FITTING_TECH_LEVEL);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder mimiPresetPayLoad(TWSDevice tWSDevice, String payload) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        Intrinsics.checkNotNullParameter(payload, "payload");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_MIMI_PRESET_PAYLOAD);
        tWSDeviceBuilder.setSetPayload(Base64.decode(payload, 0));
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder personalizedAnc$default(TWSDevice tWSDevice, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return personalizedAnc(tWSDevice, num);
    }

    public static final TWSDeviceBuilder personalizedAnc(TWSDevice tWSDevice, Integer num) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_PERSONALIZED);
        tWSDeviceBuilder.setSetPayload(num != null ? new byte[]{(byte) num.intValue()} : null);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_PERSONALIZED_ANC);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder calibration(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_CALIBRATION);
        tWSDeviceBuilder.setSetPayload(new byte[]{1});
        tWSDeviceBuilder.setNeedFsn(false);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder lhdc$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return lhdc(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder lhdc(TWSDevice tWSDevice, Boolean bool) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_LHDC_COMMANDS);
        tWSDeviceBuilder.setSetPayload(DataExtKt.toByteArray$default(Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : 0, 0, 1, (Object) null));
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_LHDC_COMMANDS);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder advanceCustomEQMode$default(TWSDevice tWSDevice, AdvanceCustomEQEntity.Mode mode, int i, Object obj) {
        if ((i & 1) != 0) {
            mode = AdvanceCustomEQEntity.Mode.ON;
        }
        return advanceCustomEQMode(tWSDevice, mode);
    }

    public static final TWSDeviceBuilder advanceCustomEQMode(TWSDevice tWSDevice, AdvanceCustomEQEntity.Mode entity) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(SET_ADVANCE_CUSTOM_EQ_MODE);
        tWSDeviceBuilder.setSetPayload(DataExtKt.toByteArray$default(entity.getValue(), 0, 1, (Object) null));
        tWSDeviceBuilder.getCommand(GET_ADVANCE_CUSTOM_EQ_MODE);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder advanceCustomEQValue$default(TWSDevice tWSDevice, int i, EQEntity eQEntity, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 255;
        }
        if ((i2 & 2) != 0) {
            eQEntity = null;
        }
        return advanceCustomEQValue(tWSDevice, i, eQEntity);
    }

    public static final TWSDeviceBuilder advanceCustomEQValue(TWSDevice tWSDevice, int i, EQEntity eQEntity) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(SET_ADVANCE_CUSTOM_EQ_VALUE);
        tWSDeviceBuilder.setSetPayload(eQEntity != null ? eQEntity.obtainDataPacket() : null);
        tWSDeviceBuilder.setGetCommand(GET_ADVANCE_CUSTOM_EQ_VALUE);
        tWSDeviceBuilder.setGetPayload(DataExtKt.toByteArray$default(i, 0, 1, (Object) null));
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder clarityBoost$default(TWSDevice tWSDevice, Boolean bool, ClarityBoostEntity.Level level, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            level = null;
        }
        return clarityBoost(tWSDevice, bool, level);
    }

    public static final TWSDeviceBuilder clarityBoost(TWSDevice tWSDevice, Boolean bool, ClarityBoostEntity.Level level) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_DETAIL_ENHANCEMENT);
        byte bAreEqual = Intrinsics.areEqual((Object) bool, (Object) true);
        if (level == null) {
            level = ClarityBoostEntity.Level.MID;
        }
        tWSDeviceBuilder.setSetPayload(new byte[]{bAreEqual, (byte) level.getValue()});
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_DETAIL_ENHANCEMENT);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder midUnitAdvanceCustomEQMode$default(TWSDevice tWSDevice, MidUnitAdvanceCustomEQModeEntity.Mode mode, int i, Object obj) {
        if ((i & 1) != 0) {
            mode = null;
        }
        return midUnitAdvanceCustomEQMode(tWSDevice, mode);
    }

    public static final TWSDeviceBuilder midUnitAdvanceCustomEQMode(TWSDevice tWSDevice, MidUnitAdvanceCustomEQModeEntity.Mode mode) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_THIRD_DRIVER_ADVANCE_CUSTOM_EQ_MODE);
        if (mode == null) {
            mode = MidUnitAdvanceCustomEQModeEntity.Mode.OFF;
        }
        tWSDeviceBuilder.setSetPayload(new byte[]{(byte) mode.getValue()});
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_THIRD_DRIVER_ADVANCE_CUSTOM_EQ_MODE);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder midUnitAdvanceCustomEQValue$default(TWSDevice tWSDevice, int i, EQEntity eQEntity, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 255;
        }
        if ((i2 & 2) != 0) {
            eQEntity = null;
        }
        return midUnitAdvanceCustomEQValue(tWSDevice, i, eQEntity);
    }

    public static final TWSDeviceBuilder midUnitAdvanceCustomEQValue(TWSDevice tWSDevice, int i, EQEntity eQEntity) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_THIRD_DRIVER_ADVANCE_CUSTOM_EQ_VALUE);
        tWSDeviceBuilder.setSetPayload(eQEntity != null ? eQEntity.obtainDataPacket() : null);
        tWSDeviceBuilder.setGetCommand(ProtocolConstant.Query.GET_THIRD_DRIVER_ADVANCE_CUSTOM_EQ_VALUE);
        tWSDeviceBuilder.setGetPayload(DataExtKt.toByteArray$default(i, 0, 1, (Object) null));
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder simpleCustomEQ$default(TWSDevice tWSDevice, SimpleEQEntity simpleEQEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            simpleEQEntity = null;
        }
        return simpleCustomEQ(tWSDevice, simpleEQEntity);
    }

    public static final TWSDeviceBuilder simpleCustomEQ(TWSDevice tWSDevice, SimpleEQEntity simpleEQEntity) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(61505);
        tWSDeviceBuilder.setSetPayload(simpleEQEntity != null ? simpleEQEntity.obtainDataPacket() : null);
        tWSDeviceBuilder.getCommand(49220);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder eqMode$default(TWSDevice tWSDevice, EQModeEntity.Mode mode, int i, Object obj) {
        if ((i & 1) != 0) {
            mode = EQModeEntity.Mode.FLAT_OR_BALANCED;
        }
        return eqMode(tWSDevice, mode);
    }

    public static final TWSDeviceBuilder eqMode(TWSDevice tWSDevice, EQModeEntity.Mode mode) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(61456);
        tWSDeviceBuilder.setSetPayload(mode != null ? DataExtKt.toByteArray$default(mode.getValue(), 0, 1, (Object) null) : null);
        tWSDeviceBuilder.getCommand(49183);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder lowSoundSwitch$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return lowSoundSwitch(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder lowSoundSwitch(TWSDevice tWSDevice, Boolean bool) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_BASS_BOOST);
        if (bool != null) {
            bool.booleanValue();
            bArr = new byte[]{bool.booleanValue(), 5};
        } else {
            bArr = null;
        }
        tWSDeviceBuilder.setSetPayload(bArr);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_BASS_BOOST);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder diracOpteoEQ$default(TWSDevice tWSDevice, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return diracOpteoEQ(tWSDevice, i);
    }

    public static final TWSDeviceBuilder diracOpteoEQ(TWSDevice tWSDevice, int i) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(SET_DIRAC_OPTEO_EQ);
        tWSDeviceBuilder.setSetPayload(DataExtKt.toByteArray$default(i, 0, 1, (Object) null));
        tWSDeviceBuilder.getCommand(GET_DIRAC_OPTEO_EQ);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder lowSoundSwitch$default(TWSDevice tWSDevice, Boolean bool, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        return lowSoundSwitch(tWSDevice, bool, num);
    }

    public static final TWSDeviceBuilder lowSoundSwitch(TWSDevice tWSDevice, Boolean bool, Integer num) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_BASS_BOOST);
        if (bool != null) {
            bool.booleanValue();
            bArr = new byte[]{bool.booleanValue(), num != null ? (byte) num.intValue() : (byte) 0};
        } else {
            bArr = null;
        }
        tWSDeviceBuilder.setSetPayload(bArr);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_BASS_BOOST);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder bassBoostSwitch$default(TWSDevice tWSDevice, Boolean bool, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        return bassBoostSwitch(tWSDevice, bool, num);
    }

    public static final TWSDeviceBuilder bassBoostSwitch(TWSDevice tWSDevice, Boolean bool, Integer num) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_BASS_BOOST);
        if (bool != null) {
            bool.booleanValue();
            bArr = new byte[]{bool.booleanValue(), num != null ? (byte) num.intValue() : (byte) 0};
        } else {
            bArr = null;
        }
        tWSDeviceBuilder.setSetPayload(bArr);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_BASS_BOOST);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder dual$default(TWSDevice tWSDevice, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return dual(tWSDevice, num);
    }

    public static final TWSDeviceBuilder dual(TWSDevice tWSDevice, Integer num) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_DUAL_ENABLE);
        tWSDeviceBuilder.setSetPayload(num != null ? new byte[]{(byte) num.intValue()} : null);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_DUAL_ENABLE);
        tWSDeviceBuilder.notifyCommand(ProtocolConstant.Notification.EVENT_DUAL_DEVICE_CONNECT_STATE);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder spatialAudioSwitch$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return spatialAudioSwitch(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder spatialAudioSwitch(TWSDevice tWSDevice, Boolean bool) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_SPATIAL_AUDIO);
        if (bool != null) {
            bool.booleanValue();
            bArr = new byte[]{bool.booleanValue()};
        } else {
            bArr = null;
        }
        tWSDeviceBuilder.setSetPayload(bArr);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_SPATIAL_AUDIO);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder battery(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(49159);
        tWSDeviceBuilder.notifyCommand(57345);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder firmwareVersion(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(49218);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder earphoneStatus(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(49162);
        tWSDeviceBuilder.notifyCommand(57346);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder utcTime(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        byte[] byteArray$default = DataExtKt.toByteArray$default(System.currentTimeMillis() / ((long) 1000), 0, 1, (Object) null);
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_HOST_UTC_TIME);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_UTC_TIME);
        tWSDeviceBuilder.setSetPayload(byteArray$default);
        tWSDeviceBuilder.setMockResponse(byteArray$default);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder remoteConfiguration(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_REMOTE_CONFIGURATION);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder lagMode$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return lagMode(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder lagMode(TWSDevice tWSDevice, Boolean bool) {
        byte[] byteArray$default;
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_LAG_MODE);
        if (Intrinsics.areEqual((Object) bool, (Object) true)) {
            byteArray$default = DataExtKt.toByteArray$default(1, 0, 1, (Object) null);
        } else {
            byteArray$default = DataExtKt.toByteArray$default(2, 0, 1, (Object) null);
        }
        tWSDeviceBuilder.setSetPayload(byteArray$default);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_HOST_LAG_MODE);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder spatialAudio$default(TWSDevice tWSDevice, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        return spatialAudio(tWSDevice, bool, bool2);
    }

    public static final TWSDeviceBuilder spatialAudio(TWSDevice tWSDevice, Boolean bool, Boolean bool2) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_SPATIAL_AUDIO);
        tWSDeviceBuilder.setSetPayload(bool2 == null ? new byte[]{Intrinsics.areEqual((Object) bool, (Object) true)} : new byte[]{Intrinsics.areEqual((Object) bool, (Object) true), Intrinsics.areEqual((Object) bool2, (Object) true)});
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_SPATIAL_AUDIO);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder bassBoost$default(TWSDevice tWSDevice, Boolean bool, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        return bassBoost(tWSDevice, bool, num);
    }

    public static final TWSDeviceBuilder bassBoost(TWSDevice tWSDevice, Boolean bool, Integer num) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_BASS_BOOST);
        if (bool != null) {
            bool.booleanValue();
            bArr = new byte[]{bool.booleanValue(), num != null ? (byte) num.intValue() : (byte) 0};
        } else {
            bArr = null;
        }
        tWSDeviceBuilder.setSetPayload(bArr);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_BASS_BOOST);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder scenarioMode$default(TWSDevice tWSDevice, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return scenarioMode(tWSDevice, num);
    }

    public static final TWSDeviceBuilder scenarioMode(TWSDevice tWSDevice, Integer num) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_SCENARIO_MODE);
        tWSDeviceBuilder.setSetPayload(num != null ? new byte[]{(byte) num.intValue()} : null);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_SCENARIO_MODE);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder keyConfiguration(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_KEY_CONFIGURATION);
        tWSDeviceBuilder.setCommand(ProtocolConstant.Set.SET_KEY_CONFIGURATION);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder customEQValue(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setCommand(61505);
        tWSDeviceBuilder.getCommand(49220);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder eQMode$default(TWSDevice tWSDevice, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return eQMode(tWSDevice, i);
    }

    public static final TWSDeviceBuilder eQMode(TWSDevice tWSDevice, int i) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(61456);
        tWSDeviceBuilder.setSetPayload(DataExtKt.toByteArray$default(i, 0, 1, (Object) null));
        tWSDeviceBuilder.getCommand(49183);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder extraFeatureStatus$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return extraFeatureStatus(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder extraFeatureStatus(TWSDevice tWSDevice, Boolean bool) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_EXTRA_FEATURE_STATUS);
        tWSDeviceBuilder.setSetPayload(new byte[]{1, 1, Intrinsics.areEqual((Object) bool, (Object) true)});
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder noiseReduction$default(TWSDevice tWSDevice, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = 0;
        }
        return noiseReduction(tWSDevice, num);
    }

    public static final TWSDeviceBuilder noiseReduction(TWSDevice tWSDevice, Integer num) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setGetCommand(49182);
        tWSDeviceBuilder.setGetPayload(new byte[]{3});
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_CURRENT_NOISE_REDUCTION);
        tWSDeviceBuilder.setSetPayload(num != null ? new byte[]{1, (byte) num.intValue(), 0} : null);
        tWSDeviceBuilder.notifyCommand(57347);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder whereAmI(TWSDevice tWSDevice, int i, boolean z) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_WHERE_AM_I);
        if (i == 5) {
            bArr = new byte[]{z ? (byte) 1 : (byte) 0};
        } else {
            bArr = new byte[]{(byte) i, z ? (byte) 1 : (byte) 0};
        }
        tWSDeviceBuilder.setSetPayload(bArr);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder debugInfo$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return debugInfo(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder debugInfo(TWSDevice tWSDevice, Boolean bool) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Debug.GET_DEBUG_INFO);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Debug.CHANGE_LEVEL);
        tWSDeviceBuilder.setSetPayload(new byte[]{Intrinsics.areEqual((Object) bool, (Object) true), 4, 0});
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder upgradeCapability(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_UPGRADE_CAPABILITY);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder remoteColor(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_REMOTE_COLOR_ID);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder supportFeature(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_SUPPORTED_FEATURE);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder deviceModel(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_DEVICE_MODEL);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder smartAnc$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return smartAnc(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder smartAnc(TWSDevice tWSDevice, Boolean bool) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_SMART_ANC_MODE);
        tWSDeviceBuilder.setSetPayload(DataExtKt.toByteArray$default(Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : 0, 0, 1, (Object) null));
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_SMART_ANC_MODE);
        return tWSDeviceBuilder;
    }

    public static /* synthetic */ TWSDeviceBuilder smartFree$default(TWSDevice tWSDevice, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        return smartFree(tWSDevice, bool);
    }

    public static final TWSDeviceBuilder smartFree(TWSDevice tWSDevice, Boolean bool) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.setSetCommand(ProtocolConstant.Set.SET_SMART_FREE_MODE);
        tWSDeviceBuilder.setSetPayload(DataExtKt.toByteArray$default(Intrinsics.areEqual((Object) bool, (Object) true) ? 1 : 0, 0, 1, (Object) null));
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_SMART_FREE_MODE);
        return tWSDeviceBuilder;
    }

    public static final TWSDeviceBuilder mutuallyExclusive(TWSDevice tWSDevice) {
        Intrinsics.checkNotNullParameter(tWSDevice, "<this>");
        TWSDeviceBuilder tWSDeviceBuilder = new TWSDeviceBuilder(tWSDevice);
        tWSDeviceBuilder.getCommand(ProtocolConstant.Query.GET_MUTUALLY_EXCLUSIVE);
        return tWSDeviceBuilder;
    }
}
