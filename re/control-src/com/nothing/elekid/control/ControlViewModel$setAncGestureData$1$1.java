package com.nothing.elekid.control;

import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.spp.BaseSppProtocol;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ControlViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.elekid.control.ControlViewModel$setAncGestureData$1$1", f = "ControlViewModel.kt", i = {}, l = {260, 261, 268}, m = "invokeSuspend", n = {}, s = {})
final class ControlViewModel$setAncGestureData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ControlOperationViewModel $dialogItemViewModel;
    final /* synthetic */ ControlConfigurationEntity.Operation $it;
    final /* synthetic */ int $operation;
    final /* synthetic */ ControlItemViewModel $viewModel;
    int label;
    final /* synthetic */ ControlViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ControlViewModel$setAncGestureData$1$1(ControlViewModel controlViewModel, ControlConfigurationEntity.Operation operation, int i, ControlItemViewModel controlItemViewModel, ControlOperationViewModel controlOperationViewModel, Continuation<? super ControlViewModel$setAncGestureData$1$1> continuation) {
        super(2, continuation);
        this.this$0 = controlViewModel;
        this.$it = operation;
        this.$operation = i;
        this.$viewModel = controlItemViewModel;
        this.$dialogItemViewModel = controlOperationViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ControlViewModel$setAncGestureData$1$1(this.this$0, this.$it, this.$operation, this.$viewModel, this.$dialogItemViewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ControlViewModel$setAncGestureData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007d, code lost:
    
        if (r12.this$0.syncGestureData(r12.$viewModel, r12.$it, r12.$dialogItemViewModel, r12.$operation, r12) == r0) goto L20;
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
            obj = BaseSppProtocol.setGestureData$default(this.this$0.getProtocol(), this.$it, this.$operation, 0, this, 4, null);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.label = 3;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(zBooleanValue, this.$it, this.$operation, this.$dialogItemViewModel, null), this) != coroutine_suspended) {
            this.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.nothing.elekid.control.ControlViewModel$setAncGestureData$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.control.ControlViewModel$setAncGestureData$1$1$1", f = "ControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ControlOperationViewModel $dialogItemViewModel;
        final /* synthetic */ ControlConfigurationEntity.Operation $it;
        final /* synthetic */ int $operation;
        final /* synthetic */ boolean $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, ControlConfigurationEntity.Operation operation, int i, ControlOperationViewModel controlOperationViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = z;
            this.$it = operation;
            this.$operation = i;
            this.$dialogItemViewModel = controlOperationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$result, this.$it, this.$operation, this.$dialogItemViewModel, continuation);
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
            if (this.$result) {
                this.$it.setOperation(this.$operation);
                this.$dialogItemViewModel.setOperation(this.$operation);
                this.$dialogItemViewModel.convertAnc(this.$operation, false);
            }
            return Unit.INSTANCE;
        }
    }
}
