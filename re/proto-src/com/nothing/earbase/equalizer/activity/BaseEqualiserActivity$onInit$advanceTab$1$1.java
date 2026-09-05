package com.nothing.earbase.equalizer.activity;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import com.nothing.base.view.BaseFragment;
import com.nothing.core.entity.AdvanceCustomEQEntity;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: BaseEqualiserActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.earbase.equalizer.activity.BaseEqualiserActivity$onInit$advanceTab$1$1", f = "BaseEqualiserActivity.kt", i = {0, 0}, l = {484, 269, 270}, m = "invokeSuspend", n = {"entity", "needUpdate$iv"}, s = {"L$0", "I$0"})
final class BaseEqualiserActivity$onInit$advanceTab$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BaseEqualiserActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseEqualiserActivity$onInit$advanceTab$1$1(BaseEqualiserActivity baseEqualiserActivity, Continuation<? super BaseEqualiserActivity$onInit$advanceTab$1$1> continuation) {
        super(2, continuation);
        this.this$0 = baseEqualiserActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseEqualiserActivity$onInit$advanceTab$1$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseEqualiserActivity$onInit$advanceTab$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0106  */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x011e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.equalizer.activity.BaseEqualiserActivity$onInit$advanceTab$1$1.AnonymousClass2(r20.this$0, null), r20) == r1) goto L50;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQMode;
        Object objSyncSetResponse$default;
        AdvanceCustomEQEntity advanceCustomEQEntity;
        TWSDeviceBuilder tWSDeviceBuilder;
        int i;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<AdvanceCustomEQEntity> advanceCustomEQLiveData = this.this$0.getViewModel().getAdvanceCustomEQLiveData();
            AdvanceCustomEQEntity value = advanceCustomEQLiveData != null ? advanceCustomEQLiveData.getValue() : null;
            TWSDevice tWSDevice = this.this$0.getViewModel().getTWSDevice();
            if (tWSDevice == null || (tWSDeviceBuilderAdvanceCustomEQMode = TWSDeviceExtKt.advanceCustomEQMode(tWSDevice, AdvanceCustomEQEntity.Mode.ON)) == null) {
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                if (DelayKt.delay(200L, this) != coroutine_suspended) {
                    this.label = 3;
                }
            } else {
                int setCommand = tWSDeviceBuilderAdvanceCustomEQMode.getSetCommand();
                this.L$0 = value;
                this.L$1 = tWSDeviceBuilderAdvanceCustomEQMode;
                this.I$0 = 0;
                this.label = 1;
                objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderAdvanceCustomEQMode.getTwsDevice(), setCommand, tWSDeviceBuilderAdvanceCustomEQMode.getSetPayload(), tWSDeviceBuilderAdvanceCustomEQMode.getTimeOut(), tWSDeviceBuilderAdvanceCustomEQMode.getIsNeedFsn(), false, tWSDeviceBuilderAdvanceCustomEQMode.getMockResponse(), this, 16, null);
                if (objSyncSetResponse$default != coroutine_suspended) {
                    advanceCustomEQEntity = value;
                    tWSDeviceBuilder = tWSDeviceBuilderAdvanceCustomEQMode;
                    i = 0;
                }
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            int i3 = this.I$0;
            TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) this.L$1;
            AdvanceCustomEQEntity advanceCustomEQEntity2 = (AdvanceCustomEQEntity) this.L$0;
            ResultKt.throwOnFailure(obj);
            advanceCustomEQEntity = advanceCustomEQEntity2;
            tWSDeviceBuilder = tWSDeviceBuilder2;
            i = i3;
            objSyncSetResponse$default = obj;
        } else if (i2 == 2) {
            ResultKt.throwOnFailure(obj);
            this.label = 3;
        } else {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        Message message = (Message) objSyncSetResponse$default;
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
            if (advanceCustomEQEntity != null) {
                advanceCustomEQEntity.setModel(AdvanceCustomEQEntity.Mode.ON);
            }
            byte[] bArrObtainDataPacket = advanceCustomEQEntity != null ? advanceCustomEQEntity.obtainDataPacket() : null;
            Message message2 = (Message) liveDataCommand$default.getValue();
            if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrObtainDataPacket);
                if (message2 != null) {
                    message2.setPayload(bArrObtainDataPacket);
                    if (i != 0) {
                        tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message2);
                    }
                }
            }
        }
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (DelayKt.delay(200L, this) != coroutine_suspended) {
            this.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.activity.BaseEqualiserActivity$onInit$advanceTab$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: BaseEqualiserActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.activity.BaseEqualiserActivity$onInit$advanceTab$1$1$2", f = "BaseEqualiserActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ BaseEqualiserActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BaseEqualiserActivity baseEqualiserActivity, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = baseEqualiserActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Fragment fragment = this.this$0.getFragmentList().get(1);
            Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.nothing.base.view.BaseFragment<*>");
            ((BaseFragment) fragment).onResumeLazy(1);
            return Unit.INSTANCE;
        }
    }
}
