package com.nothing.ear.two.control;

import android.util.Log;
import androidx.databinding.ObservableArrayList;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.Logger;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
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
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.ear.two.control.ControlViewModel$setGestureData$1$1", f = "ControlViewModel.kt", i = {}, l = {143, 144}, m = "invokeSuspend", n = {}, s = {})
final class ControlViewModel$setGestureData$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ControlOperationViewModel $dialogItemViewModel;
    final /* synthetic */ ControlConfigurationEntity.Operation $it;
    final /* synthetic */ ControlGestureViewModel $viewModel;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ControlViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ControlViewModel$setGestureData$1$1(ControlOperationViewModel controlOperationViewModel, ControlConfigurationEntity.Operation operation, ControlGestureViewModel controlGestureViewModel, ControlViewModel controlViewModel, Continuation<? super ControlViewModel$setGestureData$1$1> continuation) {
        super(2, continuation);
        this.$dialogItemViewModel = controlOperationViewModel;
        this.$it = operation;
        this.$viewModel = controlGestureViewModel;
        this.this$0 = controlViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ControlViewModel$setGestureData$1$1 controlViewModel$setGestureData$1$1 = new ControlViewModel$setGestureData$1$1(this.$dialogItemViewModel, this.$it, this.$viewModel, this.this$0, continuation);
        controlViewModel$setGestureData$1$1.L$0 = obj;
        return controlViewModel$setGestureData$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ControlViewModel$setGestureData$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0074  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x017c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.ear.two.control.ControlViewModel$setGestureData$1$1.AnonymousClass2(r20.this$0, r5, r20.$dialogItemViewModel, r20.$viewModel, null), r20) == r1) goto L33;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        boolean z;
        boolean z2;
        Object gestureData$default;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean zIsNoiseOperation = this.$dialogItemViewModel.isNoiseOperation(this.$it.getOperation());
            ControlOperationViewModel controlOperationViewModel = this.$dialogItemViewModel;
            boolean zIsNoiseOperation2 = controlOperationViewModel.isNoiseOperation(controlOperationViewModel.getOperation());
            ObservableArrayList<CommonBindingMoreType> rightGestureData = Intrinsics.areEqual(this.$viewModel.isLeft().get(), Boxing.boxBoolean(true)) ? this.this$0.getRightGestureData() : this.this$0.getLeftGestureData();
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "setGestureData --> source=" + zIsNoiseOperation + " target=" + zIsNoiseOperation2;
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    z2 = zIsNoiseOperation;
                    z = zIsNoiseOperation2;
                } else {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    z = zIsNoiseOperation2;
                    z2 = zIsNoiseOperation;
                    FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            } else {
                z2 = zIsNoiseOperation;
                z = zIsNoiseOperation2;
            }
            if (z && !z2) {
                this.this$0.syncTargetNoiseMode(rightGestureData, this.$it, this.$dialogItemViewModel);
            }
            this.label = 1;
            gestureData$default = BaseSppProtocol.setGestureData$default(this.this$0.getProtocol(), this.$it, this.$dialogItemViewModel.getOperation(), 0, this, 4, null);
            if (gestureData$default != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            gestureData$default = obj;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        boolean zBooleanValue = ((Boolean) gestureData$default).booleanValue();
        this.label = 2;
    }

    /* JADX INFO: renamed from: com.nothing.ear.two.control.ControlViewModel$setGestureData$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: ControlViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.two.control.ControlViewModel$setGestureData$1$1$2", f = "ControlViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ControlOperationViewModel $dialogItemViewModel;
        final /* synthetic */ boolean $result;
        final /* synthetic */ ControlGestureViewModel $viewModel;
        int label;
        final /* synthetic */ ControlViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ControlViewModel controlViewModel, boolean z, ControlOperationViewModel controlOperationViewModel, ControlGestureViewModel controlGestureViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = controlViewModel;
            this.$result = z;
            this.$dialogItemViewModel = controlOperationViewModel;
            this.$viewModel = controlGestureViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$result, this.$dialogItemViewModel, this.$viewModel, continuation);
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
            this.this$0.addScore(this.$result);
            if (this.$result) {
                this.this$0.setVisibleOrGoneNoiseSubItems(this.$dialogItemViewModel, Intrinsics.areEqual(this.$viewModel.isLeft().get(), Boxing.boxBoolean(true)));
                this.$viewModel.onClickSelectedOperation(this.this$0.context, this.$dialogItemViewModel);
            }
            return Unit.INSTANCE;
        }
    }
}
