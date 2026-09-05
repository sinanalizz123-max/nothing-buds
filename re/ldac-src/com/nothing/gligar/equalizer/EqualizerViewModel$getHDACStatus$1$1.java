package com.nothing.gligar.equalizer;

import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.BasicInt;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import com.nothing.protocol.device.TWSDevice;
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

/* JADX INFO: compiled from: EqualizerViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.gligar.equalizer.EqualizerViewModel$getHDACStatus$1$1", f = "EqualizerViewModel.kt", i = {}, l = {170, 174}, m = "invokeSuspend", n = {}, s = {})
final class EqualizerViewModel$getHDACStatus$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TWSDevice $this_apply;
    final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
    int label;
    final /* synthetic */ EqualizerViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EqualizerViewModel$getHDACStatus$1$1(TWSDevice tWSDevice, EqualizerViewModel equalizerViewModel, EqualizerTypeViewModel equalizerTypeViewModel, Continuation<? super EqualizerViewModel$getHDACStatus$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = tWSDevice;
        this.this$0 = equalizerViewModel;
        this.$typeViewModel = equalizerTypeViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EqualizerViewModel$getHDACStatus$1$1(this.$this_apply, this.this$0, this.$typeViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EqualizerViewModel$getHDACStatus$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.gligar.equalizer.EqualizerViewModel$getHDACStatus$1$1.AnonymousClass1(r13.this$0, r13.$typeViewModel, null), r13) == r0) goto L23;
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
            obj = TWSDevice.sendMessageSync$default(this.$this_apply, ProtocolConstant.Query.GET_LHDC_COMMANDS, null, false, false, null, null, this, 62, null);
            if (obj != coroutine_suspended) {
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
        Message message = (Message) obj;
        BasicInt basicInt = message != null ? (BasicInt) message.obtainPayload(BasicInt.class) : null;
        if (basicInt == null || basicInt.getValue() != 0) {
            this.label = 2;
        } else {
            this.this$0.sendEqModelData(this.$typeViewModel);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.gligar.equalizer.EqualizerViewModel$getHDACStatus$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.gligar.equalizer.EqualizerViewModel$getHDACStatus$1$1$1", f = "EqualizerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
        int label;
        final /* synthetic */ EqualizerViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EqualizerViewModel equalizerViewModel, EqualizerTypeViewModel equalizerTypeViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = equalizerViewModel;
            this.$typeViewModel = equalizerTypeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$typeViewModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.getNeedHDACWarning().postValue(new WarnEqualizerTypeViewModel(true, this.$typeViewModel));
            return Unit.INSTANCE;
        }
    }
}
