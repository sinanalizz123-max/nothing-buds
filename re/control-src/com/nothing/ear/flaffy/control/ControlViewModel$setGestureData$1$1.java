package com.nothing.ear.flaffy.control;

import androidx.media3.extractor.ts.TsExtractor;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.spp.BaseSppProtocol;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ControlViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.ear.flaffy.control.ControlViewModel$setGestureData$1$1", f = "ControlViewModel.kt", i = {}, l = {135, TsExtractor.TS_STREAM_TYPE_DTS_HD}, m = "invokeSuspend", n = {}, s = {})
final class ControlViewModel$setGestureData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ControlOperationViewModel $dialogItemViewModel;
    final /* synthetic */ ControlConfigurationEntity.Operation $it;
    final /* synthetic */ ControlGestureViewModel $viewModel;
    int label;
    final /* synthetic */ ControlViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ControlViewModel$setGestureData$1$1(ControlViewModel controlViewModel, ControlOperationViewModel controlOperationViewModel, ControlConfigurationEntity.Operation operation, ControlGestureViewModel controlGestureViewModel, Continuation<? super ControlViewModel$setGestureData$1$1> continuation) {
        super(2, continuation);
        this.this$0 = controlViewModel;
        this.$dialogItemViewModel = controlOperationViewModel;
        this.$it = operation;
        this.$viewModel = controlGestureViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ControlViewModel$setGestureData$1$1(this.this$0, this.$dialogItemViewModel, this.$it, this.$viewModel, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ControlViewModel$setGestureData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006f, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.ear.flaffy.control.ControlViewModel$setGestureData$1$1.AnonymousClass1(r4, r11.this$0, r11.$dialogItemViewModel, r11.$viewModel, null), r11) == r0) goto L15;
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
            this.this$0.synGestureData(this.$dialogItemViewModel, this.$it, this.$viewModel);
            this.label = 1;
            obj = BaseSppProtocol.setGestureData$default(this.this$0.getProtocol(), this.$it, this.$dialogItemViewModel.getOperation(), 0, this, 4, null);
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
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        this.label = 2;
    }

    /* JADX INFO: renamed from: com.nothing.ear.flaffy.control.ControlViewModel$setGestureData$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.flaffy.control.ControlViewModel$setGestureData$1$1$1", f = "ControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ControlOperationViewModel $dialogItemViewModel;
        final /* synthetic */ boolean $result;
        final /* synthetic */ ControlGestureViewModel $viewModel;
        int label;
        final /* synthetic */ ControlViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, ControlViewModel controlViewModel, ControlOperationViewModel controlOperationViewModel, ControlGestureViewModel controlGestureViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = z;
            this.this$0 = controlViewModel;
            this.$dialogItemViewModel = controlOperationViewModel;
            this.$viewModel = controlGestureViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$result, this.this$0, this.$dialogItemViewModel, this.$viewModel, continuation);
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
                this.this$0.setVisibleOrGoneNoiseSubItems(this.$dialogItemViewModel, Intrinsics.areEqual(this.$viewModel.isLeft().get(), Boxing.boxBoolean(true)));
                this.$viewModel.onClickSelectedOperation(this.this$0.context, this.$dialogItemViewModel);
            }
            return Unit.INSTANCE;
        }
    }
}
