package com.nothing.base.util.ext;

import android.content.res.Resources;
import com.antonkarpenko.ffmpegkit.FFmpegKitFlutterPlugin;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: compiled from: ContextExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.base.util.ext.ContextExtKt$statusBarHeight$1", f = "ContextExt.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, s = {})
final class ContextExtKt$statusBarHeight$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Resources $this_statusBarHeight;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContextExtKt$statusBarHeight$1(Resources resources, Continuation<? super ContextExtKt$statusBarHeight$1> continuation) {
        super(2, continuation);
        this.$this_statusBarHeight = resources;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContextExtKt$statusBarHeight$1(this.$this_statusBarHeight, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((ContextExtKt$statusBarHeight$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.nothing.base.util.ext.ContextExtKt$statusBarHeight$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContextExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.base.util.ext.ContextExtKt$statusBarHeight$1$1", f = "ContextExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ Resources $this_statusBarHeight;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Resources resources, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_statusBarHeight = resources;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_statusBarHeight, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            int identifier = this.$this_statusBarHeight.getIdentifier("status_bar_height", "dimen", FFmpegKitFlutterPlugin.PLATFORM_NAME);
            return Boxing.boxInt(identifier > 0 ? this.$this_statusBarHeight.getDimensionPixelSize(identifier) : 0);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        ResultKt.throwOnFailure(obj);
        this.label = 1;
        Object objWithTimeout = TimeoutKt.withTimeout(1500L, new AnonymousClass1(this.$this_statusBarHeight, null), this);
        return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
    }
}
