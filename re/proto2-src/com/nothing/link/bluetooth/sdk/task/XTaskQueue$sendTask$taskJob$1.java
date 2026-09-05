package com.nothing.link.bluetooth.sdk.task;

import android.util.Log;
import com.google.android.exoplayer2.Renderer;
import com.nothing.link.bluetooth.sdk.connect.CompleteException;
import com.nothing.link.bluetooth.sdk.connect.FlushException;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XTaskQueue.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XTaskQueue$sendTask$taskJob$1", f = "XTaskQueue.kt", i = {}, l = {85, Renderer.MSG_SET_WAKEUP_LISTENER}, m = "invokeSuspend", n = {}, s = {})
final class XTaskQueue$sendTask$taskJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ XTask $task;
    int label;
    final /* synthetic */ XTaskQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XTaskQueue$sendTask$taskJob$1(XTask xTask, XTaskQueue xTaskQueue, Continuation<? super XTaskQueue$sendTask$taskJob$1> continuation) {
        super(2, continuation);
        this.$task = xTask;
        this.this$0 = xTaskQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XTaskQueue$sendTask$taskJob$1(this.$task, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((XTaskQueue$sendTask$taskJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(r20.$task.getDurationTimeMillis(), new com.nothing.link.bluetooth.sdk.task.XTaskQueue$sendTask$taskJob$1.AnonymousClass1(r20.$task, r20.this$0, null), r20) == r1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0139, code lost:
    
        if (r2 == r1) goto L31;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object objDoTask;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$task.getDurationTimeMillis() <= 0) {
                this.$task.setDurationTimeMillis(this.this$0.getOperateTime());
            }
            if (this.$task.getDurationTimeMillis() > 0) {
                this.label = 1;
            } else {
                Logger logger = Logger.INSTANCE;
                XTaskQueue xTaskQueue = this.this$0;
                XTask xTask = this.$task;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "(" + xTaskQueue.getTag() + ") " + xTask.getUniqueId() + " flush start no duration ";
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                this.label = 2;
                objDoTask = this.$task.doTask(this);
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
            objDoTask = obj;
            if (((Boolean) objDoTask).booleanValue()) {
                Logger logger2 = Logger.INSTANCE;
                XTaskQueue xTaskQueue2 = this.this$0;
                XTask xTask2 = this.$task;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "(" + xTaskQueue2.getTag() + ") " + xTask2.getUniqueId() + " flush success no duration,taskList(" + xTaskQueue2.taskList.size() + ")";
                    String str5 = str4;
                    if (str5 != null && str5.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str6 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                        FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
            } else {
                throw new FlushException(this.$task.getUniqueId() + " flush failed no duration!");
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.task.XTaskQueue$sendTask$taskJob$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: XTaskQueue.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XTaskQueue$sendTask$taskJob$1$1", f = "XTaskQueue.kt", i = {}, l = {86, 93}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XTask $task;
        int label;
        final /* synthetic */ XTaskQueue this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(XTask xTask, XTaskQueue xTaskQueue, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$task = xTask;
            this.this$0 = xTaskQueue;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$task, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0162, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r17.$task.getDurationTimeMillis(), r17) == r1) goto L38;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objDoTask;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                objDoTask = this.$task.doTask(this);
                if (objDoTask != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                objDoTask = obj;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            if (((Boolean) objDoTask).booleanValue()) {
                XTask xTask = (XTask) CollectionsKt.firstOrNull(this.this$0.taskList.list());
                Logger logger = Logger.INSTANCE;
                XTaskQueue xTaskQueue = this.this$0;
                XTask xTask2 = this.$task;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "(" + xTaskQueue.getTag() + ") " + xTask2.getUniqueId() + " flush success,first:" + (xTask != null ? xTask.getCommand() : null) + ",taskList(" + xTaskQueue.taskList.size() + "),status:" + xTask2.getCurrentStatusDesc();
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                if (xTask == null && !this.$task.isWaiting()) {
                    throw new CompleteException("done no need wait");
                }
                this.label = 2;
            } else {
                throw new FlushException(this.$task.getUniqueId() + " flush failed!");
            }
        }
    }
}
