package com.nothing.crobat.core.protocol;

import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.crobat.core.device.IOTProductDeviceCrobat;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.log.NTLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CrobatSppProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/crobat/core/protocol/CrobatSppProtocol;", "Lcom/nothing/earbase/spp/BaseSppProtocol;", "address", "", "<init>", "(Ljava/lang/String;)V", "getDetailPageData", "", "getDebugPageData", "getConfiguration", "syncUtcTime", "getDualEnable", "setDualEnable", "", "value", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CrobatSppProtocol extends BaseSppProtocol {

    /* JADX INFO: renamed from: com.nothing.crobat.core.protocol.CrobatSppProtocol$setDualEnable$1, reason: invalid class name */
    /* JADX INFO: compiled from: CrobatSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.crobat.core.protocol.CrobatSppProtocol", f = "CrobatSppProtocol.kt", i = {}, l = {42}, m = "setDualEnable", n = {}, s = {})
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
            return CrobatSppProtocol.this.setDualEnable(0, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CrobatSppProtocol() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ CrobatSppProtocol(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public CrobatSppProtocol(String str) {
        super(str, IOTProductDeviceCrobat.EAR_ID);
    }

    public final void getDetailPageData() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            TWSDevice.sendCommands$default(tWSDevice, new int[]{ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS, ProtocolConstant.Query.GET_HOST_LAG_MODE}, false, false, 6, null);
        }
    }

    public final void getDebugPageData() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            TWSDevice.sendCommands$default(tWSDevice, new int[]{ProtocolConstant.Debug.GET_DEBUG_INFO}, false, false, 6, null);
        }
    }

    public final void getConfiguration() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            TWSDevice.sendMessage$default(tWSDevice, ProtocolConstant.Query.GET_REMOTE_CONFIGURATION, null, false, false, null, null, 0, 126, null);
        }
    }

    public final void syncUtcTime() {
        long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            TWSDevice.sendMessage$default(tWSDevice, ProtocolConstant.Set.SET_UTC_TIME, DataExtKt.toByteArray$default(jCurrentTimeMillis, 0, 1, (Object) null), false, false, null, null, 0, 124, null);
        }
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
        AnonymousClass1 anonymousClass1;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderDual;
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
            if (tWSDevice == null || (tWSDeviceBuilderDual = TWSDeviceExtKt.dual(tWSDevice, Boxing.boxInt(i))) == null) {
                zBooleanValue = false;
            } else {
                anonymousClass1.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderDual, null, anonymousClass1, 1, null);
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
}
