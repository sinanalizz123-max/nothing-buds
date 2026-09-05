package com.nothing.base.util.ext;

import android.content.res.Resources;
import android.util.Log;
import com.antonkarpenko.ffmpegkit.FFmpegKitFlutterPlugin;
import com.nothing.base.util.Logger;
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
import kotlinx.coroutines.TimeoutKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ContextExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.base.util.ext.ContextExtKt$navBarHeight$1", f = "ContextExt.kt", i = {}, l = {431}, m = "invokeSuspend", n = {}, s = {})
final class ContextExtKt$navBarHeight$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ Resources $this_navBarHeight;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContextExtKt$navBarHeight$1(Resources resources, Continuation<? super ContextExtKt$navBarHeight$1> continuation) {
        super(2, continuation);
        this.$this_navBarHeight = resources;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ContextExtKt$navBarHeight$1(this.$this_navBarHeight, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((ContextExtKt$navBarHeight$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX INFO: renamed from: com.nothing.base.util.ext.ContextExtKt$navBarHeight$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContextExt.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.base.util.ext.ContextExtKt$navBarHeight$1$1", f = "ContextExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ Resources $this_navBarHeight;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Resources resources, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_navBarHeight = resources;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_navBarHeight, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
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
            int identifier = this.$this_navBarHeight.getIdentifier("navigation_bar_height", "dimen", FFmpegKitFlutterPlugin.PLATFORM_NAME);
            Logger logger = Logger.INSTANCE;
            Resources resources = this.$this_navBarHeight;
            Logger logger2 = logger;
            String tag = logger2.getTAG();
            int depth = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str = "sure navbar navBarHeight:" + identifier + "," + resources.getDimensionPixelSize(identifier);
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger2.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return Boxing.boxInt((identifier <= 0 || !ContextExtKt.getHasNavBar(this.$this_navBarHeight)) ? 0 : this.$this_navBarHeight.getDimensionPixelSize(identifier));
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
        Object objWithTimeout = TimeoutKt.withTimeout(1500L, new AnonymousClass1(this.$this_navBarHeight, null), this);
        return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
    }
}
