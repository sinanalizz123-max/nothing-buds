package com.nothing.link.bluetooth.sdk.connect.ble;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.SendChannel;

/* JADX INFO: compiled from: OrderedTaskExecutor.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ/\u0010\u000e\u001a\u00020\b2\u001c\u0010\u000f\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/ble/OrderedTaskExecutor;", "", "()V", "job", "Lkotlinx/coroutines/Job;", "taskQueue", "Lkotlinx/coroutines/channels/Channel;", "Lcom/nothing/link/bluetooth/sdk/connect/ble/OrderedTaskExecutor$TaskWrapper;", "", "awaitShutdown", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shutdown", "start", "submit", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TaskWrapper", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class OrderedTaskExecutor {
    private Job job;
    private Channel<TaskWrapper<Boolean>> taskQueue = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.OrderedTaskExecutor$submit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OrderedTaskExecutor.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.OrderedTaskExecutor", f = "OrderedTaskExecutor.kt", i = {0}, l = {37, 38}, m = "submit", n = {"wrapper"}, s = {"L$0"})
    static final class C08751 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08751(Continuation<? super C08751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OrderedTaskExecutor.this.submit(null, this);
        }
    }

    public final void start() {
        if (this.job == null) {
            this.taskQueue = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
            this.job = BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(null), 3, null);
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "OrderedTaskExecutor start".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "OrderedTaskExecutor start " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "OrderedTaskExecutor start " + strComponent2);
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.OrderedTaskExecutor$start$1, reason: invalid class name */
    /* JADX INFO: compiled from: OrderedTaskExecutor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.OrderedTaskExecutor$start$1", f = "OrderedTaskExecutor.kt", i = {1}, l = {17, 19}, m = "invokeSuspend", n = {"wrapper"}, s = {"L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OrderedTaskExecutor.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x004b  */
        /* JADX WARN: Code duplicated, block: B:20:0x0055  */
        /* JADX WARN: Code duplicated, block: B:27:0x0085  */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x006a, code lost:
        
            if (r6 == r0) goto L23;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x006a -> B:24:0x006d). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ChannelIterator it;
            ChannelIterator channelIterator;
            TaskWrapper taskWrapper;
            Object objHasNext;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = OrderedTaskExecutor.this.taskQueue.iterator();
                this.L$0 = it;
                this.L$1 = null;
                this.label = 1;
                objHasNext = it.hasNext(this);
                if (objHasNext != coroutine_suspended) {
                    channelIterator = it;
                    obj = objHasNext;
                    if (((Boolean) obj).booleanValue()) {
                        taskWrapper = (TaskWrapper) channelIterator.next();
                        Function1 block = taskWrapper.getBlock();
                        this.L$0 = channelIterator;
                        this.L$1 = taskWrapper;
                        this.label = 2;
                        obj = block.invoke(this);
                    } else {
                        return Unit.INSTANCE;
                    }
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ChannelIterator channelIterator2 = (ChannelIterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                channelIterator = channelIterator2;
                if (((Boolean) obj).booleanValue()) {
                    taskWrapper = (TaskWrapper) channelIterator.next();
                    Function1 block2 = taskWrapper.getBlock();
                    this.L$0 = channelIterator;
                    this.L$1 = taskWrapper;
                    this.label = 2;
                    obj = block2.invoke(this);
                } else {
                    return Unit.INSTANCE;
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                taskWrapper = (TaskWrapper) this.L$1;
                channelIterator = (ChannelIterator) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception unused) {
                    it = channelIterator;
                    taskWrapper.complete(Boxing.boxBoolean(false));
                    this.L$0 = it;
                    this.L$1 = null;
                    this.label = 1;
                    objHasNext = it.hasNext(this);
                    if (objHasNext != coroutine_suspended) {
                        channelIterator = it;
                        obj = objHasNext;
                        if (((Boolean) obj).booleanValue()) {
                            taskWrapper = (TaskWrapper) channelIterator.next();
                            Function1 block3 = taskWrapper.getBlock();
                            this.L$0 = channelIterator;
                            this.L$1 = taskWrapper;
                            this.label = 2;
                            obj = block3.invoke(this);
                        } else {
                            return Unit.INSTANCE;
                        }
                    }
                    return coroutine_suspended;
                }
            }
            taskWrapper.complete(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
            it = channelIterator;
            this.L$0 = it;
            this.L$1 = null;
            this.label = 1;
            objHasNext = it.hasNext(this);
            if (objHasNext != coroutine_suspended) {
                channelIterator = it;
                obj = objHasNext;
                if (((Boolean) obj).booleanValue()) {
                    taskWrapper = (TaskWrapper) channelIterator.next();
                    Function1 block4 = taskWrapper.getBlock();
                    this.L$0 = channelIterator;
                    this.L$1 = taskWrapper;
                    this.label = 2;
                    obj = block4.invoke(this);
                } else {
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object submit(Function1<? super Continuation<? super Boolean>, ? extends Object> function1, Continuation<? super Boolean> continuation) {
        C08751 c08751;
        TaskWrapper<Boolean> taskWrapper;
        if (continuation instanceof C08751) {
            c08751 = (C08751) continuation;
            if ((c08751.label & Integer.MIN_VALUE) != 0) {
                c08751.label -= Integer.MIN_VALUE;
            } else {
                c08751 = new C08751(continuation);
            }
        } else {
            c08751 = new C08751(continuation);
        }
        Object obj = c08751.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08751.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = this.job;
            if (job == null || !job.isActive()) {
                this.job = null;
                start();
            }
            TaskWrapper<Boolean> taskWrapper2 = new TaskWrapper<>(function1);
            Channel<TaskWrapper<Boolean>> channel = this.taskQueue;
            c08751.L$0 = taskWrapper2;
            c08751.label = 1;
            if (channel.send(taskWrapper2, c08751) != coroutine_suspended) {
                taskWrapper = taskWrapper2;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return obj;
        }
        taskWrapper = (TaskWrapper) c08751.L$0;
        ResultKt.throwOnFailure(obj);
        c08751.L$0 = null;
        c08751.label = 2;
        Object objAwait = taskWrapper.await(c08751);
        return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
    }

    public final void shutdown() {
        Job job = this.job;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        SendChannel.DefaultImpls.close$default(this.taskQueue, null, 1, null);
        this.job = null;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "OrderedTaskExecutor shutdown".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "OrderedTaskExecutor shutdown " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "OrderedTaskExecutor shutdown " + strComponent2);
            }
        }
    }

    public final Object awaitShutdown(Continuation<? super Unit> continuation) {
        Job job = this.job;
        if (job == null) {
            return Unit.INSTANCE;
        }
        Object objJoin = job.join(continuation);
        return objJoin == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objJoin : Unit.INSTANCE;
    }

    /* JADX INFO: compiled from: OrderedTaskExecutor.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B&\u0012\u001c\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\f\u001a\u00028\u0000H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014R,\u0010\u0003\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/ble/OrderedTaskExecutor$TaskWrapper;", ExifInterface.GPS_DIRECTION_TRUE, "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "deferred", "Lkotlinx/coroutines/CompletableDeferred;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "complete", "", "result", "(Ljava/lang/Object;)V", "completeExceptionally", "e", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class TaskWrapper<T> {
        private final Function1<Continuation<? super T>, Object> block;
        private final CompletableDeferred<T> deferred;

        /* JADX WARN: Multi-variable type inference failed */
        public TaskWrapper(Function1<? super Continuation<? super T>, ? extends Object> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            this.block = block;
            this.deferred = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        }

        public final Function1<Continuation<? super T>, Object> getBlock() {
            return this.block;
        }

        public final void complete(T result) {
            this.deferred.complete(result);
        }

        public final void completeExceptionally(Throwable e) {
            Intrinsics.checkNotNullParameter(e, "e");
            this.deferred.completeExceptionally(e);
        }

        public final Object await(Continuation<? super T> continuation) {
            return this.deferred.await(continuation);
        }
    }
}
