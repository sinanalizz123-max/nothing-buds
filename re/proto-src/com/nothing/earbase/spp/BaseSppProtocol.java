package com.nothing.earbase.spp;

import androidx.health.connect.client.records.ExerciseSessionRecord;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.earbase.anc.entity.DeviceNoiseReduction;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: BaseSppProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0014J\u0016\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\u0014J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0014J&\u0010!\u001a\u00020\u00102\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%H\u0086@\u00a2\u0006\u0002\u0010&J(\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\u001a2\b\b\u0002\u0010*\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010-\u001a\u00020\u0014J\u0010\u0010.\u001a\u0004\u0018\u00010\u001eH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010/\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u00100\u001a\u00020\u00142\u0006\u00101\u001a\u00020\u0010J\u0010\u00102\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u000104J\u0016\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u001aH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u001e\u00107\u001a\u00020\u00102\u0006\u00108\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u00109R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n\u00a8\u0006:"}, d2 = {"Lcom/nothing/earbase/spp/BaseSppProtocol;", "", "address", "", "modelID", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getModelID", "setModelID", "getTWSDevice", "Lcom/nothing/protocol/device/TWSDevice;", "setLagMode", "", "enable", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setCustomEQValue", "", "byteArray", "", "getEQMode", "setEQMode", "eqMode", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCustomEqValue", "getGestureData", "Lcom/nothing/protocol/model/Message;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGestureDataAsync", "resetGestureData", "operations", "Ljava/util/ArrayList;", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setGestureData", "it", "operation", "button", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setEarDetect", "getNoiseReduction", "getSynNoiseReduction", "setLowModeSend", "setDebugInfo", "isOpen", "updateCacheAnc", "noiseReduction", "Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;", "setNoiseReduction", "value", "updateWhereAmI", "deviceType", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseSppProtocol {
    private String address;
    private String modelID;

    /* JADX INFO: renamed from: com.nothing.earbase.spp.BaseSppProtocol$resetGestureData$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.spp.BaseSppProtocol", f = "BaseSppProtocol.kt", i = {}, l = {58}, m = "resetGestureData", n = {}, s = {})
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
            return BaseSppProtocol.this.resetGestureData(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.spp.BaseSppProtocol$setEQMode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.spp.BaseSppProtocol", f = "BaseSppProtocol.kt", i = {}, l = {39}, m = "setEQMode", n = {}, s = {})
    static final class C07081 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07081(Continuation<? super C07081> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseSppProtocol.this.setEQMode(0, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.spp.BaseSppProtocol$setEarDetect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.spp.BaseSppProtocol", f = "BaseSppProtocol.kt", i = {}, l = {70}, m = "setEarDetect", n = {}, s = {})
    static final class C07091 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07091(Continuation<? super C07091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseSppProtocol.this.setEarDetect(false, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.spp.BaseSppProtocol$setGestureData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.spp.BaseSppProtocol", f = "BaseSppProtocol.kt", i = {}, l = {66}, m = "setGestureData", n = {}, s = {})
    static final class C07101 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07101(Continuation<? super C07101> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseSppProtocol.this.setGestureData(null, 0, 0, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.spp.BaseSppProtocol$setLowModeSend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.spp.BaseSppProtocol", f = "BaseSppProtocol.kt", i = {}, l = {ExerciseSessionRecord.EXERCISE_TYPE_YOGA}, m = "setLowModeSend", n = {}, s = {})
    static final class C07111 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07111(Continuation<? super C07111> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseSppProtocol.this.setLowModeSend(false, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.spp.BaseSppProtocol$setNoiseReduction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.spp.BaseSppProtocol", f = "BaseSppProtocol.kt", i = {}, l = {95}, m = "setNoiseReduction", n = {}, s = {})
    static final class C07121 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07121(Continuation<? super C07121> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseSppProtocol.this.setNoiseReduction(0, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.spp.BaseSppProtocol$updateWhereAmI$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseSppProtocol.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.spp.BaseSppProtocol", f = "BaseSppProtocol.kt", i = {}, l = {102}, m = "updateWhereAmI", n = {}, s = {})
    static final class C07131 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C07131(Continuation<? super C07131> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseSppProtocol.this.updateWhereAmI(0, false, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseSppProtocol() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public Object setLagMode(boolean z, Continuation<? super Boolean> continuation) {
        return setLagMode$suspendImpl(this, z, continuation);
    }

    public BaseSppProtocol(String str, String str2) {
        this.address = str;
        this.modelID = str2;
    }

    public /* synthetic */ BaseSppProtocol(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getModelID() {
        return this.modelID;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    public final void setModelID(String str) {
        this.modelID = str;
    }

    public final TWSDevice getTWSDevice() {
        String str = this.address;
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress((str == null || str.length() == 0) ? SpUtils.INSTANCE.getSelectDeviceMac() : this.address);
        if (iOTDeviceByMacAddress != null) {
            return iOTDeviceByMacAddress.getTwsDevice();
        }
        return null;
    }

    static /* synthetic */ Object setLagMode$suspendImpl(BaseSppProtocol baseSppProtocol, boolean z, Continuation<? super Boolean> continuation) {
        TWSDeviceBuilder tWSDeviceBuilderLagMode;
        TWSDevice tWSDevice = baseSppProtocol.getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderLagMode = TWSDeviceExtKt.lagMode(tWSDevice, Boxing.boxBoolean(z))) == null) {
            return null;
        }
        Object sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderLagMode, null, continuation, 1, null);
        return sync$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sync$default : (Boolean) sync$default;
    }

    public final void setCustomEQValue(byte[] byteArray) {
        TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice)) == null) {
            return;
        }
        tWSDeviceBuilderCustomEQValue.setASync(byteArray);
    }

    public final void getEQMode() {
        TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice, 0, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setEQMode(int i, Continuation<? super Boolean> continuation) {
        C07081 c07081;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        if (continuation instanceof C07081) {
            c07081 = (C07081) continuation;
            if ((c07081.label & Integer.MIN_VALUE) != 0) {
                c07081.label -= Integer.MIN_VALUE;
            } else {
                c07081 = new C07081(continuation);
            }
        } else {
            c07081 = new C07081(continuation);
        }
        Object sync = c07081.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c07081.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(sync);
            TWSDevice tWSDevice = getTWSDevice();
            zBooleanValue = false;
            if (tWSDevice != null && (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice, 0, 1, null)) != null) {
                byte[] byteArray$default = DataExtKt.toByteArray$default(i, 0, 1, (Object) null);
                c07081.label = 1;
                sync = tWSDeviceBuilderEQMode$default.setSync(byteArray$default, c07081);
                if (sync == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync);
        zBooleanValue = ((Boolean) sync).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final void getCustomEqValue() {
        TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderCustomEQValue, false, (byte[]) null, 0, 7, (Object) null);
    }

    public final Object getGestureData(Continuation<? super Message> continuation) {
        TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(tWSDevice)) == null) {
            return null;
        }
        return TWSDeviceBuilder.getSyncResponse$default(tWSDeviceBuilderKeyConfiguration, null, continuation, 1, null);
    }

    public final void getGestureDataAsync() {
        TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(tWSDevice)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderKeyConfiguration, false, (byte[]) null, 0, 7, (Object) null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resetGestureData(ArrayList<ControlConfigurationEntity.Operation> arrayList, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
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
        Object sync = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(sync);
            ControlConfigurationEntity controlConfigurationEntity = new ControlConfigurationEntity(arrayList);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(tWSDevice)) == null) {
                zBooleanValue = false;
            } else {
                byte[] bArrObtainDataPacket = controlConfigurationEntity.obtainDataPacket();
                anonymousClass1.label = 1;
                sync = tWSDeviceBuilderKeyConfiguration.setSync(bArrObtainDataPacket, anonymousClass1);
                if (sync == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync);
        zBooleanValue = ((Boolean) sync).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public static /* synthetic */ Object setGestureData$default(BaseSppProtocol baseSppProtocol, ControlConfigurationEntity.Operation operation, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setGestureData");
        }
        if ((i3 & 4) != 0) {
            i2 = -1;
        }
        return baseSppProtocol.setGestureData(operation, i, i2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setGestureData(ControlConfigurationEntity.Operation operation, int i, int i2, Continuation<? super Boolean> continuation) {
        C07101 c07101;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
        if (continuation instanceof C07101) {
            c07101 = (C07101) continuation;
            if ((c07101.label & Integer.MIN_VALUE) != 0) {
                c07101.label -= Integer.MIN_VALUE;
            } else {
                c07101 = new C07101(continuation);
            }
        } else {
            c07101 = new C07101(continuation);
        }
        Object sync = c07101.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c07101.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(sync);
            if (i2 == -1) {
                i2 = operation.getButton();
            }
            ControlConfigurationEntity controlConfigurationEntity = new ControlConfigurationEntity(new ControlConfigurationEntity.Operation(operation.getDevice(), i2, operation.getGesture(), i));
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(tWSDevice)) == null) {
                zBooleanValue = false;
            } else {
                byte[] bArrObtainDataPacket = controlConfigurationEntity.obtainDataPacket();
                c07101.label = 1;
                sync = tWSDeviceBuilderKeyConfiguration.setSync(bArrObtainDataPacket, c07101);
                if (sync == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync);
        zBooleanValue = ((Boolean) sync).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setEarDetect(boolean z, Continuation<? super Boolean> continuation) {
        C07091 c07091;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderExtraFeatureStatus;
        if (continuation instanceof C07091) {
            c07091 = (C07091) continuation;
            if ((c07091.label & Integer.MIN_VALUE) != 0) {
                c07091.label -= Integer.MIN_VALUE;
            } else {
                c07091 = new C07091(continuation);
            }
        } else {
            c07091 = new C07091(continuation);
        }
        Object sync$default = c07091.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07091.label;
        if (i == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderExtraFeatureStatus = TWSDeviceExtKt.extraFeatureStatus(tWSDevice, Boxing.boxBoolean(z))) == null) {
                zBooleanValue = false;
            } else {
                c07091.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderExtraFeatureStatus, null, c07091, 1, null);
                if (sync$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync$default);
        zBooleanValue = ((Boolean) sync$default).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final void getNoiseReduction() {
        TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(tWSDevice, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderNoiseReduction$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    public final Object getSynNoiseReduction(Continuation<? super Message> continuation) {
        TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(tWSDevice, null, 1, null)) == null) {
            return null;
        }
        return TWSDeviceBuilder.getSyncResponse$default(tWSDeviceBuilderNoiseReduction$default, null, continuation, 1, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setLowModeSend(boolean z, Continuation<? super Boolean> continuation) {
        C07111 c07111;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderLagMode;
        if (continuation instanceof C07111) {
            c07111 = (C07111) continuation;
            if ((c07111.label & Integer.MIN_VALUE) != 0) {
                c07111.label -= Integer.MIN_VALUE;
            } else {
                c07111 = new C07111(continuation);
            }
        } else {
            c07111 = new C07111(continuation);
        }
        Object sync$default = c07111.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07111.label;
        if (i == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderLagMode = TWSDeviceExtKt.lagMode(tWSDevice, Boxing.boxBoolean(z))) == null) {
                zBooleanValue = false;
            } else {
                c07111.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderLagMode, null, c07111, 1, null);
                if (sync$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync$default);
        zBooleanValue = ((Boolean) sync$default).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final void setDebugInfo(boolean isOpen) {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            TWSDeviceExtKt.debugInfo(tWSDevice, Boolean.valueOf(isOpen));
        }
    }

    public final void updateCacheAnc(DeviceNoiseReduction noiseReduction) {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(tWSDevice, null, 1, null);
            if (tWSDeviceBuilderNoiseReduction$default != null) {
                TWSDeviceBuilder.updateCache$default(tWSDeviceBuilderNoiseReduction$default, noiseReduction != null ? noiseReduction.obtainDataPacket() : null, false, false, 6, null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setNoiseReduction(int i, Continuation<? super Boolean> continuation) {
        C07121 c07121;
        boolean zBooleanValue;
        TWSDeviceBuilder tWSDeviceBuilderNoiseReduction;
        if (continuation instanceof C07121) {
            c07121 = (C07121) continuation;
            if ((c07121.label & Integer.MIN_VALUE) != 0) {
                c07121.label -= Integer.MIN_VALUE;
            } else {
                c07121 = new C07121(continuation);
            }
        } else {
            c07121 = new C07121(continuation);
        }
        Object sync$default = c07121.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c07121.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderNoiseReduction = TWSDeviceExtKt.noiseReduction(tWSDevice, Boxing.boxInt(i))) == null) {
                zBooleanValue = false;
            } else {
                c07121.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderNoiseReduction, null, c07121, 1, null);
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

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object updateWhereAmI(int i, boolean z, Continuation<? super Boolean> continuation) {
        C07131 c07131;
        TWSDeviceBuilder tWSDeviceBuilderWhereAmI;
        if (continuation instanceof C07131) {
            c07131 = (C07131) continuation;
            if ((c07131.label & Integer.MIN_VALUE) != 0) {
                c07131.label -= Integer.MIN_VALUE;
            } else {
                c07131 = new C07131(continuation);
            }
        } else {
            c07131 = new C07131(continuation);
        }
        Object sync$default = c07131.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c07131.label;
        boolean z2 = false;
        if (i2 == 0) {
            ResultKt.throwOnFailure(sync$default);
            TWSDevice tWSDevice = getTWSDevice();
            if (tWSDevice != null && (tWSDeviceBuilderWhereAmI = TWSDeviceExtKt.whereAmI(tWSDevice, i, z)) != null) {
                c07131.label = 1;
                sync$default = TWSDeviceBuilder.setSync$default(tWSDeviceBuilderWhereAmI, null, c07131, 1, null);
                if (sync$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(z2);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(sync$default);
        if (((Boolean) sync$default).booleanValue()) {
            z2 = true;
        }
        return Boxing.boxBoolean(z2);
    }
}
