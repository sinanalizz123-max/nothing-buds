package com.nothing.link.bluetooth.sdk.task;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.records.metadata.DeviceTypes;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XCommonTask.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000b\b\u0016\u0018\u0000 V2\u00020\u0001:\u0001VB\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012+\b\u0002\u0010\n\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b\u00a2\u0006\u0002\b\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0006\u00108\u001a\u000209J\u0011\u0010:\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010;J\u0006\u0010<\u001a\u00020\u0003J\b\u0010=\u001a\u0004\u0018\u000107J\u000e\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u000209J\b\u0010@\u001a\u00020\u0003H\u0016J\u0012\u0010A\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0006\u0010D\u001a\u00020\bJ\u0006\u0010E\u001a\u00020\bJ\u0006\u0010F\u001a\u00020\bJ\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020H2\u0006\u0010?\u001a\u000209J\u000e\u0010J\u001a\u00020H2\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020HJ\u0006\u0010N\u001a\u00020HJ\u0006\u0010O\u001a\u00020HJ\u0010\u0010P\u001a\u00020H2\b\u0010Q\u001a\u0004\u0018\u000107J\u000e\u0010R\u001a\u00020H2\u0006\u0010K\u001a\u00020LJ\u0006\u0010S\u001a\u00020HJ\u0006\u0010T\u001a\u00020HJ\b\u0010U\u001a\u00020\u0003H\u0016R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR6\u0010\n\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u000b\u00a2\u0006\u0002\b\rX\u0082\u000e\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0014\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010+\"\u0004\b1\u0010-R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006W"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/task/XCommonTask;", "", "command", "", "durationTimeMillis", "", "operateInterval", "callInMainThread", "", "autoDoNextTask", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "callback", "Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskCallback;", "device", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "retryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "needWait", "(Ljava/lang/String;JJZZLkotlin/jvm/functions/Function2;Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskCallback;Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;Ljava/util/concurrent/atomic/AtomicInteger;Z)V", "atomicStatus", "getAutoDoNextTask", "()Z", "setAutoDoNextTask", "(Z)V", "Lkotlin/jvm/functions/Function2;", "getCallInMainThread", "setCallInMainThread", "getCallback", "()Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskCallback;", "setCallback", "(Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskCallback;)V", "getCommand", "()Ljava/lang/String;", "setCommand", "(Ljava/lang/String;)V", "getDevice", "()Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "setDevice", "(Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;)V", "getDurationTimeMillis", "()J", "setDurationTimeMillis", "(J)V", "getNeedWait", "setNeedWait", "getOperateInterval", "setOperateInterval", "getRetryCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setRetryCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "taskJob", "Lkotlinx/coroutines/Job;", "currentStatus", "", "doTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentStatusDesc", "getJob", "getStatusDesc", NotificationCompat.CATEGORY_STATUS, "getUniqueId", "isMatchTask", "xCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "isNotSuccess", "isReady", "isRunning", "setCancel", "", "setCurrentStatus", "setFailed", "error", "", "setFlushing", "setReady", "setSuccess", "setTaskJob", "job", "setTimeout", "setWaiting", "setWriting", "toString", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XCommonTask {
    public static final int TASK_CANCEL = 5;
    public static final int TASK_FAILED = 6;
    public static final int TASK_FLUSHING = 1;
    public static final int TASK_READY = 0;
    public static final int TASK_SUCCESS = 4;
    public static final int TASK_TIMEOUT = 7;
    public static final int TASK_WAITING = 3;
    public static final int TASK_WRITING = 2;
    private AtomicInteger atomicStatus;
    private boolean autoDoNextTask;
    private Function2<? super XCommonTask, ? super Continuation<? super Boolean>, ? extends Object> block;
    private boolean callInMainThread;
    private XCommonTaskCallback callback;
    private String command;
    private XBluetoothDevice device;
    private long durationTimeMillis;
    private boolean needWait;
    private long operateInterval;
    private AtomicInteger retryCount;
    private Job taskJob;

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.task.XCommonTask$doTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: XCommonTask.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XCommonTask", f = "XCommonTask.kt", i = {}, l = {157, 161}, m = "doTask", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XCommonTask.this.doTask(this);
        }
    }

    public XCommonTask(String command, long j, long j2, boolean z, boolean z2, Function2<? super XCommonTask, ? super Continuation<? super Boolean>, ? extends Object> function2, XCommonTaskCallback xCommonTaskCallback, XBluetoothDevice xBluetoothDevice, AtomicInteger atomicInteger, boolean z3) {
        Intrinsics.checkNotNullParameter(command, "command");
        this.command = command;
        this.durationTimeMillis = j;
        this.operateInterval = j2;
        this.callInMainThread = z;
        this.autoDoNextTask = z2;
        this.block = function2;
        this.callback = xCommonTaskCallback;
        this.device = xBluetoothDevice;
        this.retryCount = atomicInteger;
        this.needWait = z3;
        this.atomicStatus = new AtomicInteger(0);
    }

    public /* synthetic */ XCommonTask(String str, long j, long j2, boolean z, boolean z2, Function2 function2, XCommonTaskCallback xCommonTaskCallback, XBluetoothDevice xBluetoothDevice, AtomicInteger atomicInteger, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 100L : j2, (i & 8) != 0 ? false : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? null : function2, (i & 64) != 0 ? null : xCommonTaskCallback, (i & 128) != 0 ? null : xBluetoothDevice, (i & 256) == 0 ? atomicInteger : null, (i & 512) != 0 ? false : z3);
    }

    public final String getCommand() {
        return this.command;
    }

    public final void setCommand(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.command = str;
    }

    public final long getDurationTimeMillis() {
        return this.durationTimeMillis;
    }

    public final void setDurationTimeMillis(long j) {
        this.durationTimeMillis = j;
    }

    public final long getOperateInterval() {
        return this.operateInterval;
    }

    public final void setOperateInterval(long j) {
        this.operateInterval = j;
    }

    public final boolean getCallInMainThread() {
        return this.callInMainThread;
    }

    public final void setCallInMainThread(boolean z) {
        this.callInMainThread = z;
    }

    public final boolean getAutoDoNextTask() {
        return this.autoDoNextTask;
    }

    public final void setAutoDoNextTask(boolean z) {
        this.autoDoNextTask = z;
    }

    public final XCommonTaskCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(XCommonTaskCallback xCommonTaskCallback) {
        this.callback = xCommonTaskCallback;
    }

    public final XBluetoothDevice getDevice() {
        return this.device;
    }

    public final void setDevice(XBluetoothDevice xBluetoothDevice) {
        this.device = xBluetoothDevice;
    }

    public final AtomicInteger getRetryCount() {
        return this.retryCount;
    }

    public final void setRetryCount(AtomicInteger atomicInteger) {
        this.retryCount = atomicInteger;
    }

    public final boolean getNeedWait() {
        return this.needWait;
    }

    public final void setNeedWait(boolean z) {
        this.needWait = z;
    }

    public String getUniqueId() {
        return this.command + StringUtils.SPACE;
    }

    public final void setCurrentStatus(int status) {
        this.atomicStatus.set(status);
    }

    public final String getCurrentStatusDesc() {
        return getStatusDesc(currentStatus());
    }

    public final String getStatusDesc(int status) {
        if (status == 0) {
            return "TASK_READY";
        }
        if (status == 1) {
            return "TASK_FLUSHING";
        }
        if (status == 2) {
            return "TASK_WRITING";
        }
        if (status == 3) {
            return "TASK_WAITING";
        }
        if (status == 4) {
            return "TASK_SUCCESS";
        }
        if (status == 6) {
            return "TASK_FAILED";
        }
        if (status == 7) {
            return "TASK_TIMEOUT";
        }
        return DeviceTypes.UNKNOWN;
    }

    public final void setReady() {
        setCurrentStatus(0);
    }

    public final void setFlushing() {
        setCurrentStatus(1);
    }

    public final void setWriting() {
        if (currentStatus() == 3) {
            return;
        }
        setCurrentStatus(2);
    }

    public final void setCancel() {
        setCurrentStatus(5);
    }

    public final void setFailed(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        setCurrentStatus(6);
    }

    public final void setTimeout(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        setCurrentStatus(7);
    }

    public final void setWaiting() {
        setCurrentStatus(3);
    }

    public final void setSuccess() {
        setCurrentStatus(4);
    }

    public final int currentStatus() {
        return this.atomicStatus.get();
    }

    public final boolean isRunning() {
        return currentStatus() == 1 || currentStatus() == 2 || currentStatus() == 3;
    }

    public final boolean isReady() {
        return currentStatus() == 0 || currentStatus() == 1;
    }

    public final boolean isNotSuccess() {
        return (currentStatus() == 4 || currentStatus() == 5 || currentStatus() == 6 || currentStatus() == 7) ? false : true;
    }

    public final void setTaskJob(Job job) {
        this.taskJob = job;
    }

    /* JADX INFO: renamed from: getJob, reason: from getter */
    public final Job getTaskJob() {
        return this.taskJob;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00eb, code lost:
    
        if (r15 == r1) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object doTask(Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objInvoke = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(objInvoke);
            Function2<? super XCommonTask, ? super Continuation<? super Boolean>, ? extends Object> function2 = this.block;
            if (function2 == null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "task not impl,please impl block!".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 6, str, tag, "task not impl,please impl block! " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, "task not impl,please impl block! " + strComponent2);
                    }
                }
                return Boxing.boxBoolean(false);
            }
            if (!this.callInMainThread) {
                if (function2 != null) {
                    anonymousClass1.label = 2;
                    objInvoke = function2.invoke(this, anonymousClass1);
                }
                return Boxing.boxBoolean(z);
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(null);
            anonymousClass1.label = 1;
            Object objWithContext = BuildersKt.withContext(main, anonymousClass3, anonymousClass1);
            if (objWithContext != coroutine_suspended) {
                return objWithContext;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(objInvoke);
            return objInvoke;
        }
        if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objInvoke);
        if (((Boolean) objInvoke).booleanValue()) {
            z = true;
        }
        return Boxing.boxBoolean(z);
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.task.XCommonTask$doTask$3, reason: invalid class name */
    /* JADX INFO: compiled from: XCommonTask.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XCommonTask$doTask$3", f = "XCommonTask.kt", i = {}, l = {158}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XCommonTask.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = false;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = XCommonTask.this.block;
                if (function2 != null) {
                    XCommonTask xCommonTask = XCommonTask.this;
                    this.label = 1;
                    obj = function2.invoke(xCommonTask, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Boxing.boxBoolean(z);
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (((Boolean) obj).booleanValue()) {
                z = true;
            }
            return Boxing.boxBoolean(z);
        }
    }

    public boolean isMatchTask(XCommand xCommand) {
        if (xCommand == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "isMatchTask false ,because xcommand is null".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "isMatchTask false ,because xcommand is null " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "isMatchTask false ,because xcommand is null " + strComponent2);
                }
            }
            return false;
        }
        return StringsKt.equals(this.command, XCommand.getCommand$default(xCommand, false, 1, null), true);
    }

    public String toString() {
        return "command:" + this.command + ",status:" + getStatusDesc(this.atomicStatus.get()) + ",autoDoNextTask:" + this.autoDoNextTask + ",callInMainThread:" + this.callInMainThread + ",operateInterval:" + this.operateInterval + "}";
    }
}
