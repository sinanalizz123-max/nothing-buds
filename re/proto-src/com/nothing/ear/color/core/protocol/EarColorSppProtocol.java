package com.nothing.ear.color.core.protocol;

import android.util.Log;
import com.nothing.base.util.Logger;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.ear.color.core.device.IOTProductDeviceEarColor;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EarColorSppProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u0007J\u0006\u0010\u000e\u001a\u00020\u0007J\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0007J\u0006\u0010\u0014\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u0016\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007\u00a8\u0006\u0018"}, d2 = {"Lcom/nothing/ear/color/core/protocol/EarColorSppProtocol;", "Lcom/nothing/earbase/spp/BaseSppProtocol;", "address", "", "<init>", "(Ljava/lang/String;)V", "get3DMode", "", "set3DMode", "", "value", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOverwriteEqProfile", "getPersonalizedANC", "setPersonalizedANC", "syncSetCalibration", "Lcom/nothing/protocol/model/Message;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetailPageData", "getDualEnable", "setDualEnable", "syncUtcTime", "getConfiguration", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarColorSppProtocol extends BaseSppProtocol {

    /* JADX INFO: renamed from: com.nothing.ear.color.core.protocol.EarColorSppProtocol$set3DMode$1, reason: invalid class name */
    /* JADX INFO: compiled from: EarColorSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.color.core.protocol.EarColorSppProtocol", f = "EarColorSppProtocol.kt", i = {}, l = {26}, m = "set3DMode", n = {}, s = {})
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
            return EarColorSppProtocol.this.set3DMode(0, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.ear.color.core.protocol.EarColorSppProtocol$setDualEnable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarColorSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.color.core.protocol.EarColorSppProtocol", f = "EarColorSppProtocol.kt", i = {}, l = {57}, m = "setDualEnable", n = {}, s = {})
    static final class C05011 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C05011(Continuation<? super C05011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EarColorSppProtocol.this.setDualEnable(0, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.ear.color.core.protocol.EarColorSppProtocol$setPersonalizedANC$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarColorSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.color.core.protocol.EarColorSppProtocol", f = "EarColorSppProtocol.kt", i = {}, l = {39}, m = "setPersonalizedANC", n = {}, s = {})
    static final class C05021 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C05021(Continuation<? super C05021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EarColorSppProtocol.this.setPersonalizedANC(0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EarColorSppProtocol() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ EarColorSppProtocol(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public EarColorSppProtocol(String str) {
        super(str, IOTProductDeviceEarColor.EAR_ID);
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
        C05021 c05021;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderPersonalizedAnc;
        if (continuation instanceof C05021) {
            c05021 = (C05021) continuation;
            if ((c05021.label & Integer.MIN_VALUE) != 0) {
                c05021.label -= Integer.MIN_VALUE;
            } else {
                c05021 = new C05021(continuation);
            }
        } else {
            c05021 = new C05021(continuation);
        }
        Object sync$default = c05021.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c05021.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderPersonalizedAnc = TWSDeviceExtKt.personalizedAnc(tWSDevice, Boxing.boxInt(i))) == null) {
                zBooleanValue = false;
            } else {
                c05021.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderPersonalizedAnc, null, c05021, 1, null);
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
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "Support List getDualEnable callback support".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "Support List getDualEnable callback support " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "Support List getDualEnable callback support " + strComponent2);
            }
        }
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderDual$default = TWSDeviceExtKt.dual$default(tWSDevice, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderDual$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setDualEnable(int i, Continuation<? super Boolean> continuation) {
        C05011 c05011;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderDual;
        if (continuation instanceof C05011) {
            c05011 = (C05011) continuation;
            if ((c05011.label & Integer.MIN_VALUE) != 0) {
                c05011.label -= Integer.MIN_VALUE;
            } else {
                c05011 = new C05011(continuation);
            }
        } else {
            c05011 = new C05011(continuation);
        }
        Object sync$default = c05011.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c05011.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderDual = TWSDeviceExtKt.dual(tWSDevice, Boxing.boxInt(i))) == null) {
                zBooleanValue = false;
            } else {
                c05011.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderDual, null, c05011, 1, null);
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
