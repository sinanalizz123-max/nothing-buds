package com.nothing.link.bluetooth.sdk.task;

import android.util.Log;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
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
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XCommonTaskQueue.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XCommonTaskQueue$sendTask$taskJob$1", f = "XCommonTaskQueue.kt", i = {}, l = {84, 86}, m = "invokeSuspend", n = {}, s = {})
final class XCommonTaskQueue$sendTask$taskJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ XCommonTask $task;
    int label;
    final /* synthetic */ XCommonTaskQueue this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XCommonTaskQueue$sendTask$taskJob$1(XCommonTask xCommonTask, XCommonTaskQueue xCommonTaskQueue, Continuation<? super XCommonTaskQueue$sendTask$taskJob$1> continuation) {
        super(2, continuation);
        this.$task = xCommonTask;
        this.this$0 = xCommonTaskQueue;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XCommonTaskQueue$sendTask$taskJob$1(this.$task, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((XCommonTaskQueue$sendTask$taskJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0053, code lost:
    
        if (kotlinx.coroutines.TimeoutKt.withTimeout(r7.$task.getDurationTimeMillis(), new com.nothing.link.bluetooth.sdk.task.XCommonTaskQueue$sendTask$taskJob$1.AnonymousClass1(r7.this$0, r7.$task, null), r7) == r0) goto L15;
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
            if (DelayKt.delay(this.$task.getOperateInterval(), this) != coroutine_suspended) {
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
        this.$task.setFlushing();
        this.label = 2;
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.task.XCommonTaskQueue$sendTask$taskJob$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: XCommonTaskQueue.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XCommonTaskQueue$sendTask$taskJob$1$1", f = "XCommonTaskQueue.kt", i = {}, l = {93, 96}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XCommonTask $task;
        int label;
        final /* synthetic */ XCommonTaskQueue this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(XCommonTaskQueue xCommonTaskQueue, XCommonTask xCommonTask, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = xCommonTaskQueue;
            this.$task = xCommonTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$task, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:45:0x01db A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:46:0x01dd  */
        /* JADX WARN: Code duplicated, block: B:47:0x01e7  */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x01d8, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r18.$task.getDurationTimeMillis(), r18) == r1) goto L44;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objDoTask;
            boolean zBooleanValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.this$0.taskList.contains(this.$task) && this.$task.isReady()) {
                    Logger logger = Logger.INSTANCE;
                    XCommonTaskQueue xCommonTaskQueue = this.this$0;
                    XCommonTask xCommonTask = this.$task;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "(" + xCommonTaskQueue.getTag() + ") " + xCommonTask.getUniqueId() + " flush start ";
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
                    this.label = 1;
                    objDoTask = this.$task.doTask(this);
                    if (objDoTask != coroutine_suspended) {
                        zBooleanValue = ((Boolean) objDoTask).booleanValue();
                        if (!this.$task.getNeedWait()) {
                            if (zBooleanValue) {
                                this.this$0.cancelJobWhenSuccess(this.$task, "task done");
                            } else {
                                XCommonTaskQueue xCommonTaskQueue2 = this.this$0;
                                XCommonTask xCommonTask2 = this.$task;
                                xCommonTaskQueue2.cancelJobWhenFailed(xCommonTask2, xCommonTask2.getUniqueId() + " flush failed!");
                            }
                        } else if (zBooleanValue) {
                            this.this$0.cancelJobWhenSuccess(this.$task, "task done");
                        } else {
                            XCommonTaskQueue xCommonTaskQueue3 = this.this$0;
                            XCommonTask xCommonTask3 = this.$task;
                            xCommonTaskQueue3.cancelJobWhenFailed(xCommonTask3, xCommonTask3.getUniqueId() + " flush failed!");
                        }
                    }
                    return coroutine_suspended;
                }
                XCommonTaskQueue xCommonTaskQueue4 = this.this$0;
                XCommonTask xCommonTask4 = this.$task;
                xCommonTaskQueue4.cancelJobWhenFailed(xCommonTask4, "task not ready or not in taskList,task:" + xCommonTask4);
                return Unit.INSTANCE;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                objDoTask = obj;
                zBooleanValue = ((Boolean) objDoTask).booleanValue();
                if (!this.$task.getNeedWait() && zBooleanValue) {
                    Logger logger2 = Logger.INSTANCE;
                    XCommonTask xCommonTask5 = this.$task;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str4 = xCommonTask5.getUniqueId() + " wait callback ,be careful need deal it";
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
                    this.label = 2;
                } else if (zBooleanValue) {
                    this.this$0.cancelJobWhenSuccess(this.$task, "task done");
                } else {
                    XCommonTaskQueue xCommonTaskQueue5 = this.this$0;
                    XCommonTask xCommonTask6 = this.$task;
                    xCommonTaskQueue5.cancelJobWhenFailed(xCommonTask6, xCommonTask6.getUniqueId() + " flush failed!");
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
}
