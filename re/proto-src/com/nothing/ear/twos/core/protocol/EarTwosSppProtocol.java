package com.nothing.ear.twos.core.protocol;

import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.ear.twos.core.device.IOTProductDeviceEarTwos;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.log.NTLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: EarTwosSppProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0007J\u0006\u0010\u001d\u001a\u00020\u0007J\u0016\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u0006\u0010 \u001a\u00020\u0007J\u0006\u0010!\u001a\u00020\u0007J\u0016\u0010\"\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u0007\u00a8\u0006%"}, d2 = {"Lcom/nothing/ear/twos/core/protocol/EarTwosSppProtocol;", "Lcom/nothing/earbase/spp/BaseSppProtocol;", "address", "", "<init>", "(Ljava/lang/String;)V", "get3DMode", "", "set3DMode", "", "value", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMimiEnable", "Lcom/nothing/protocol/model/Message;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setMimiEnable", "isEnable", "getMimiIntensity", "setMimiIntensity", "intensity", "", "getMimiPresetId", "setMimiPresetId", "presetId", "getMimiFittingFetchLevel", "setMimiPresetPayLoad", "payload", "getOverwriteEqProfile", "getPersonalizedANC", "setPersonalizedANC", "syncSetCalibration", "getDetailPageData", "getDualEnable", "setDualEnable", "syncUtcTime", "getConfiguration", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarTwosSppProtocol extends BaseSppProtocol {

    /* JADX INFO: renamed from: com.nothing.ear.twos.core.protocol.EarTwosSppProtocol$set3DMode$1, reason: invalid class name */
    /* JADX INFO: compiled from: EarTwosSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.twos.core.protocol.EarTwosSppProtocol", f = "EarTwosSppProtocol.kt", i = {}, l = {31}, m = "set3DMode", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EarTwosSppProtocol.this.set3DMode(0, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.ear.twos.core.protocol.EarTwosSppProtocol$setDualEnable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarTwosSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.twos.core.protocol.EarTwosSppProtocol", f = "EarTwosSppProtocol.kt", i = {}, l = {94}, m = "setDualEnable", n = {}, s = {})
    static final class C06291 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06291(Continuation<? super C06291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EarTwosSppProtocol.this.setDualEnable(0, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.ear.twos.core.protocol.EarTwosSppProtocol$setPersonalizedANC$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarTwosSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.twos.core.protocol.EarTwosSppProtocol", f = "EarTwosSppProtocol.kt", i = {}, l = {76}, m = "setPersonalizedANC", n = {}, s = {})
    static final class C06301 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C06301(Continuation<? super C06301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EarTwosSppProtocol.this.setPersonalizedANC(0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarTwosSppProtocol() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ EarTwosSppProtocol(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public EarTwosSppProtocol(String str) {
        super(str, IOTProductDeviceEarTwos.EAR_ID);
    }

    public final void get3DMode() {
        TWSDeviceBuilder tWSDeviceBuilderThirdSound$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderThirdSound$default = TWSDeviceExtKt.thirdSound$default(tWSDevice, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderThirdSound$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object set3DMode(int i, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderThirdSound;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object sync$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderThirdSound = TWSDeviceExtKt.thirdSound(tWSDevice, Boxing.boxInt(i))) == null) {
                zBooleanValue = false;
            } else {
                anonymousClass1.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderThirdSound, null, anonymousClass1, 1, null);
                if (sync$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync$default);
        zBooleanValue = ((Boolean) sync$default).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final Object getMimiEnable(Continuation<? super Message> continuation) {
        TWSDeviceBuilder tWSDeviceBuilderMimiSwitch$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderMimiSwitch$default = TWSDeviceExtKt.mimiSwitch$default(tWSDevice, null, 1, null)) == null) {
            return null;
        }
        return TWSDeviceBuilder.getSyncResponse$default(tWSDeviceBuilderMimiSwitch$default, null, continuation, 1, null);
    }

    public final void setMimiEnable(boolean isEnable) {
        TWSDeviceBuilder tWSDeviceBuilderMimiSwitch;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderMimiSwitch = TWSDeviceExtKt.mimiSwitch(tWSDevice, Boolean.valueOf(isEnable))) == null) {
            return;
        }
        TWSDeviceBuilder.setASync$default(tWSDeviceBuilderMimiSwitch, null, 1, null);
    }

    public final Object getMimiIntensity(Continuation<? super Message> continuation) {
        TWSDeviceBuilder tWSDeviceBuilderMimiIntensity;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderMimiIntensity = TWSDeviceExtKt.mimiIntensity(tWSDevice)) == null) {
            return null;
        }
        return TWSDeviceBuilder.getSyncResponse$default(tWSDeviceBuilderMimiIntensity, null, continuation, 1, null);
    }

    public final void setMimiIntensity(double intensity) {
        TWSDeviceBuilder tWSDeviceBuilderMimiIntensity;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderMimiIntensity = TWSDeviceExtKt.mimiIntensity(tWSDevice)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderMimiIntensity, false, DataExtKt.toByteArray((float) intensity), 0, 4, (Object) null);
    }

    public final Object getMimiPresetId(Continuation<? super Message> continuation) {
        TWSDeviceBuilder tWSDeviceBuilderMimiPreset;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderMimiPreset = TWSDeviceExtKt.mimiPreset(tWSDevice)) == null) {
            return null;
        }
        return TWSDeviceBuilder.getSyncResponse$default(tWSDeviceBuilderMimiPreset, null, continuation, 1, null);
    }

    public final void setMimiPresetId(String presetId) {
        TWSDeviceBuilder tWSDeviceBuilderMimiPreset;
        Intrinsics.checkNotNullParameter(presetId, "presetId");
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderMimiPreset = TWSDeviceExtKt.mimiPreset(tWSDevice)) == null) {
            return;
        }
        byte[] bytes = presetId.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderMimiPreset, false, bytes, 0, 4, (Object) null);
    }

    public final Object getMimiFittingFetchLevel(Continuation<? super Message> continuation) {
        TWSDeviceBuilder tWSDeviceBuilderMimiFetchLevel;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderMimiFetchLevel = TWSDeviceExtKt.mimiFetchLevel(tWSDevice)) == null) {
            return null;
        }
        return TWSDeviceBuilder.getSyncResponse$default(tWSDeviceBuilderMimiFetchLevel, null, continuation, 1, null);
    }

    public final void setMimiPresetPayLoad(String payload) {
        TWSDeviceBuilder tWSDeviceBuilderMimiPresetPayLoad;
        Intrinsics.checkNotNullParameter(payload, "payload");
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderMimiPresetPayLoad = TWSDeviceExtKt.mimiPresetPayLoad(tWSDevice, payload)) == null) {
            return;
        }
        TWSDeviceBuilder.setASync$default(tWSDeviceBuilderMimiPresetPayLoad, null, 1, null);
    }

    public final void getOverwriteEqProfile() {
        TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
        TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice, 0, 1, null)) != null) {
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
        }
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 == null || (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice2)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderCustomEQValue, false, (byte[]) null, 0, 7, (Object) null);
    }

    public final void getPersonalizedANC() {
        TWSDeviceBuilder tWSDeviceBuilderPersonalizedAnc$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderPersonalizedAnc$default = TWSDeviceExtKt.personalizedAnc$default(tWSDevice, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderPersonalizedAnc$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setPersonalizedANC(int i, Continuation<? super Boolean> continuation) {
        C06301 c06301;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderPersonalizedAnc;
        if (continuation instanceof C06301) {
            c06301 = (C06301) continuation;
            if ((c06301.label & Integer.MIN_VALUE) != 0) {
                c06301.label -= Integer.MIN_VALUE;
            } else {
                c06301 = new C06301(continuation);
            }
        } else {
            c06301 = new C06301(continuation);
        }
        Object sync$default = c06301.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c06301.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderPersonalizedAnc = TWSDeviceExtKt.personalizedAnc(tWSDevice, Boxing.boxInt(i))) == null) {
                zBooleanValue = false;
            } else {
                c06301.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderPersonalizedAnc, null, c06301, 1, null);
                if (sync$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync$default);
        zBooleanValue = ((Boolean) sync$default).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final Object syncSetCalibration(Continuation<? super Message> continuation) {
        TWSDeviceBuilder tWSDeviceBuilderCalibration;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderCalibration = TWSDeviceExtKt.calibration(tWSDevice)) == null) {
            return null;
        }
        return TWSDeviceBuilder.setSyncResponse$default(tWSDeviceBuilderCalibration, null, continuation, 1, null);
    }

    public final void getDetailPageData() {
        TWSDeviceBuilder tWSDeviceBuilderLagMode$default;
        TWSDeviceBuilder tWSDeviceBuilderExtraFeatureStatus$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderExtraFeatureStatus$default = TWSDeviceExtKt.extraFeatureStatus$default(tWSDevice, null, 1, null)) != null) {
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderExtraFeatureStatus$default, false, (byte[]) null, 0, 7, (Object) null);
        }
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 == null || (tWSDeviceBuilderLagMode$default = TWSDeviceExtKt.lagMode$default(tWSDevice2, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderLagMode$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    public final void getDualEnable() {
        TWSDeviceBuilder tWSDeviceBuilderDual$default;
        NTLog.d("Support List getDualEnable callback support");
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderDual$default = TWSDeviceExtKt.dual$default(tWSDevice, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderDual$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setDualEnable(int i, Continuation<? super Boolean> continuation) {
        C06291 c06291;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderDual;
        if (continuation instanceof C06291) {
            c06291 = (C06291) continuation;
            if ((c06291.label & Integer.MIN_VALUE) != 0) {
                c06291.label -= Integer.MIN_VALUE;
            } else {
                c06291 = new C06291(continuation);
            }
        } else {
            c06291 = new C06291(continuation);
        }
        Object sync$default = c06291.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c06291.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderDual = TWSDeviceExtKt.dual(tWSDevice, Boxing.boxInt(i))) == null) {
                zBooleanValue = false;
            } else {
                c06291.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderDual, null, c06291, 1, null);
                if (sync$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync$default);
        zBooleanValue = ((Boolean) sync$default).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final void syncUtcTime() {
        TWSDeviceBuilder tWSDeviceBuilderUtcTime;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderUtcTime = TWSDeviceExtKt.utcTime(tWSDevice)) == null) {
            return;
        }
        TWSDeviceBuilder.setASync$default(tWSDeviceBuilderUtcTime, null, 1, null);
    }

    public final void getConfiguration() {
        TWSDeviceBuilder tWSDeviceBuilderRemoteConfiguration;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderRemoteConfiguration = TWSDeviceExtKt.remoteConfiguration(tWSDevice)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderRemoteConfiguration, false, (byte[]) null, 0, 7, (Object) null);
    }
}
