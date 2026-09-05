package com.nothing.device;

import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.log.NTLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: IOTDevicePageDataAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/nothing/device/IOTDevicePageDataAction;", "", "iotDevice", "Lcom/nothing/device/IOTDevice;", "<init>", "(Lcom/nothing/device/IOTDevice;)V", "getHomePageData", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IOTDevicePageDataAction {
    private final IOTDevice iotDevice;

    public IOTDevicePageDataAction(IOTDevice iotDevice) {
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        this.iotDevice = iotDevice;
    }

    public void getHomePageData() {
        NTLog.d("send_command_source getHomePageData");
        TWSDevice twsDevice = this.iotDevice.getTwsDevice();
        if (twsDevice != null) {
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.battery(twsDevice), false, (byte[]) null, 0, 7, (Object) null);
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.firmwareVersion(twsDevice), false, (byte[]) null, 0, 7, (Object) null);
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.earphoneStatus(twsDevice), false, (byte[]) null, 0, 7, (Object) null);
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.keyConfiguration(twsDevice), false, (byte[]) null, 0, 7, (Object) null);
            if (IOTDevice.isSupportAnc$default(this.iotDevice, null, 1, null)) {
                TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.noiseReduction$default(twsDevice, null, 1, null), false, (byte[]) null, 0, 7, (Object) null);
            }
            if (this.iotDevice.isSupportUtc()) {
                TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.utcTime(twsDevice), false, (byte[]) null, 0, 7, (Object) null);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.device.IOTDevicePageDataAction$getHomePageData$2, reason: invalid class name */
    /* JADX INFO: compiled from: IOTDevicePageDataAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.device.IOTDevicePageDataAction$getHomePageData$2", f = "IOTDevicePageDataAction.kt", i = {}, l = {39, 40}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return IOTDevicePageDataAction.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.device.IOTDevicePageDataAction.AnonymousClass2.AnonymousClass1(r5.this$0, null), r5) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(1500L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.device.IOTDevicePageDataAction$getHomePageData$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: IOTDevicePageDataAction.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.device.IOTDevicePageDataAction$getHomePageData$2$1", f = "IOTDevicePageDataAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ IOTDevicePageDataAction this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(IOTDevicePageDataAction iOTDevicePageDataAction, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = iOTDevicePageDataAction;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TWSDevice twsDevice = this.this$0.iotDevice.getTwsDevice();
                    if (twsDevice != null && TWSDeviceExtKt.battery(twsDevice).getLiveData().getValue() == null) {
                        TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.battery(twsDevice), false, (byte[]) null, 0, 7, (Object) null);
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
