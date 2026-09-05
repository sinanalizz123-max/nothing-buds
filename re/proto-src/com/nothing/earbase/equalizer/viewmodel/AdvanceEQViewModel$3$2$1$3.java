package com.nothing.earbase.equalizer.viewmodel;

import com.nothing.core.entity.EQEntity;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: AdvanceEQViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.AdvanceEQViewModel$3$2$1$3", f = "AdvanceEQViewModel.kt", i = {}, l = {122, 127}, m = "invokeSuspend", n = {}, s = {})
final class AdvanceEQViewModel$3$2$1$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ AdvanceEQViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdvanceEQViewModel$3$2$1$3(AdvanceEQViewModel advanceEQViewModel, Continuation<? super AdvanceEQViewModel$3$2$1$3> continuation) {
        super(2, continuation);
        this.this$0 = advanceEQViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdvanceEQViewModel$3$2$1$3(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AdvanceEQViewModel$3$2$1$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r3, r5, r6) == r0) goto L23;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQValue$default;
        Message message;
        EQEntity eQEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TWSDevice tWSDevice = this.this$0.getTWSDevice();
            if (tWSDevice != null && (tWSDeviceBuilderAdvanceCustomEQValue$default = TWSDeviceExtKt.advanceCustomEQValue$default(tWSDevice, 0, null, 2, null)) != null) {
                this.label = 1;
                obj = TWSDeviceBuilder.getSyncResponse$default(tWSDeviceBuilderAdvanceCustomEQValue$default, null, this, 1, null);
                if (obj != coroutine_suspended) {
                    message = (Message) obj;
                    if (message != null) {
                        AdvanceEQViewModel advanceEQViewModel = this.this$0;
                        eQEntity.setTotalGain(advanceEQViewModel.getTotalGain());
                        advanceEQViewModel.sendProfileDataToDevice(eQEntity);
                        MainCoroutineDispatcher main = Dispatchers.getMain();
                        AdvanceEQViewModel$3$2$1$3$1$1 advanceEQViewModel$3$2$1$3$1$1 = new AdvanceEQViewModel$3$2$1$3$1$1(advanceEQViewModel, eQEntity, null);
                        this.L$0 = eQEntity;
                        this.label = 2;
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            message = (Message) obj;
            if (message != null && (eQEntity = (EQEntity) message.obtainPayload(EQEntity.class)) != null) {
                AdvanceEQViewModel advanceEQViewModel2 = this.this$0;
                eQEntity.setTotalGain(advanceEQViewModel2.getTotalGain());
                advanceEQViewModel2.sendProfileDataToDevice(eQEntity);
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                AdvanceEQViewModel$3$2$1$3$1$1 advanceEQViewModel$3$2$1$3$1$2 = new AdvanceEQViewModel$3$2$1$3$1$1(advanceEQViewModel2, eQEntity, null);
                this.L$0 = eQEntity;
                this.label = 2;
            }
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
