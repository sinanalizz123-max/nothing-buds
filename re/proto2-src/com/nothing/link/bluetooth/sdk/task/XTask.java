package com.nothing.link.bluetooth.sdk.task;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.records.metadata.DeviceTypes;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
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

/* JADX INFO: compiled from: XTask.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u000b\b\u0016\u0018\u0000 m2\u00020\u0001:\u0001mB\u00d3\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012+\b\u0002\u0010\u0010\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011\u00a2\u0006\u0002\b\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u000b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0006\u0010L\u001a\u00020\u0005J\u0011\u0010M\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010NJ\u0006\u0010O\u001a\u00020\u0003J\b\u0010P\u001a\u0004\u0018\u00010EJ\u000e\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u0003J\u000e\u0010S\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u0005J\u0006\u0010U\u001a\u00020\u0003J\u0010\u0010V\u001a\u00020\u000b2\b\u0010W\u001a\u0004\u0018\u00010XJ\u0006\u0010Y\u001a\u00020\u000bJ\u0006\u0010Z\u001a\u00020\u000bJ\u0006\u0010[\u001a\u00020\u000bJ\u0006\u0010\\\u001a\u00020\u000bJ\u0006\u0010]\u001a\u00020\u000bJ\u0006\u0010^\u001a\u00020_J\u000e\u0010`\u001a\u00020_2\u0006\u0010T\u001a\u00020\u0005J\u000e\u0010a\u001a\u00020_2\u0006\u0010b\u001a\u00020cJ\u0006\u0010d\u001a\u00020_J\u0006\u0010e\u001a\u00020_J\u0006\u0010f\u001a\u00020_J\u0010\u0010g\u001a\u00020_2\b\u0010h\u001a\u0004\u0018\u00010EJ\u000e\u0010i\u001a\u00020_2\u0006\u0010b\u001a\u00020cJ\u0006\u0010j\u001a\u00020_J\u0006\u0010k\u001a\u00020_J\b\u0010l\u001a\u00020\u0003H\u0016R\u000e\u0010\u001e\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R6\u0010\u0010\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0011\u00a2\u0006\u0002\b\u0013X\u0082\u000e\u00f8\u0001\u0000\u00a2\u0006\u0004\n\u0002\u0010#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010-\"\u0004\b9\u0010/R\u001a\u0010\u0018\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010 \"\u0004\b;\u0010\"R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00105\"\u0004\b=\u00107R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001a\u0010\u001c\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010 \"\u0004\bC\u0010\"R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010)\"\u0004\bG\u0010+R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006n"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/task/XTask;", "", "command", "", "currentPackage", "", "totalPackage", "durationTimeMillis", "", "operateInterval", "callInMainThread", "", "autoDoNextTask", "data", "", "ignoreFrame", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "writeCallback", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;", "device", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "needUpdate", "mockResponse", "retryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "successWithComplete", "(Ljava/lang/String;IIJJZZ[BZLkotlin/jvm/functions/Function2;Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;Z[BLjava/util/concurrent/atomic/AtomicInteger;Z)V", "atomicStatus", "getAutoDoNextTask", "()Z", "setAutoDoNextTask", "(Z)V", "Lkotlin/jvm/functions/Function2;", "getCommand", "()Ljava/lang/String;", "setCommand", "(Ljava/lang/String;)V", "getCurrentPackage", "()I", "setCurrentPackage", "(I)V", "getData", "()[B", "setData", "([B)V", "getDevice", "()Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "setDevice", "(Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;)V", "getDurationTimeMillis", "()J", "setDurationTimeMillis", "(J)V", "getMockResponse", "setMockResponse", "getNeedUpdate", "setNeedUpdate", "getOperateInterval", "setOperateInterval", "getRetryCount", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setRetryCount", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "getSuccessWithComplete", "setSuccessWithComplete", "taskJob", "Lkotlinx/coroutines/Job;", "getTotalPackage", "setTotalPackage", "getWriteCallback", "()Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;", "setWriteCallback", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;)V", "currentStatus", "doTask", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentStatusDesc", "getJob", "getPackageLog", "reason", "getStatusDesc", NotificationCompat.CATEGORY_STATUS, "getUniqueId", "isMatchTask", "xCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "isNotSuccess", "isReady", "isRunning", "isSuccess", "isWaiting", "setCancel", "", "setCurrentStatus", "setFailed", "error", "", "setFlushing", "setReady", "setSuccess", "setTaskJob", "job", "setTimeout", "setWaiting", "setWriting", "toString", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XTask {
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
    private Function2<? super XTask, ? super Continuation<? super Boolean>, ? extends Object> block;
    private boolean callInMainThread;
    private String command;
    private int currentPackage;
    private byte[] data;
    private XBluetoothDevice device;
    private long durationTimeMillis;
    private boolean ignoreFrame;
    private byte[] mockResponse;
    private boolean needUpdate;
    private long operateInterval;
    private AtomicInteger retryCount;
    private boolean successWithComplete;
    private Job taskJob;
    private int totalPackage;
    private XWriteCallback writeCallback;

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.task.XTask$doTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: XTask.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XTask", f = "XTask.kt", i = {}, l = {208, 212}, m = "doTask", n = {}, s = {})
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
            return XTask.this.doTask(this);
        }
    }

    public XTask(String command, int i, int i2, long j, long j2, boolean z, boolean z2, byte[] bArr, boolean z3, Function2<? super XTask, ? super Continuation<? super Boolean>, ? extends Object> function2, XWriteCallback xWriteCallback, XBluetoothDevice xBluetoothDevice, boolean z4, byte[] bArr2, AtomicInteger atomicInteger, boolean z5) {
        Intrinsics.checkNotNullParameter(command, "command");
        this.command = command;
        this.currentPackage = i;
        this.totalPackage = i2;
        this.durationTimeMillis = j;
        this.operateInterval = j2;
        this.callInMainThread = z;
        this.autoDoNextTask = z2;
        this.data = bArr;
        this.ignoreFrame = z3;
        this.block = function2;
        this.writeCallback = xWriteCallback;
        this.device = xBluetoothDevice;
        this.needUpdate = z4;
        this.mockResponse = bArr2;
        this.retryCount = atomicInteger;
        this.successWithComplete = z5;
        this.atomicStatus = new AtomicInteger(0);
    }

    public /* synthetic */ XTask(String str, int i, int i2, long j, long j2, boolean z, boolean z2, byte[] bArr, boolean z3, Function2 function2, XWriteCallback xWriteCallback, XBluetoothDevice xBluetoothDevice, boolean z4, byte[] bArr2, AtomicInteger atomicInteger, boolean z5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 1 : i, (i3 & 4) != 0 ? 1 : i2, (i3 & 8) != 0 ? 0L : j, (i3 & 16) != 0 ? 100L : j2, (i3 & 32) != 0 ? false : z, (i3 & 64) != 0 ? true : z2, (i3 & 128) != 0 ? null : bArr, (i3 & 256) != 0 ? false : z3, (i3 & 512) != 0 ? null : function2, (i3 & 1024) != 0 ? null : xWriteCallback, (i3 & 2048) != 0 ? null : xBluetoothDevice, (i3 & 4096) != 0 ? true : z4, (i3 & 8192) != 0 ? null : bArr2, (i3 & 16384) != 0 ? null : atomicInteger, (i3 & 32768) != 0 ? false : z5);
    }

    public final String getCommand() {
        return this.command;
    }

    public final void setCommand(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.command = str;
    }

    public final int getCurrentPackage() {
        return this.currentPackage;
    }

    public final void setCurrentPackage(int i) {
        this.currentPackage = i;
    }

    public final int getTotalPackage() {
        return this.totalPackage;
    }

    public final void setTotalPackage(int i) {
        this.totalPackage = i;
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

    public final boolean getAutoDoNextTask() {
        return this.autoDoNextTask;
    }

    public final void setAutoDoNextTask(boolean z) {
        this.autoDoNextTask = z;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final void setData(byte[] bArr) {
        this.data = bArr;
    }

    public final XWriteCallback getWriteCallback() {
        return this.writeCallback;
    }

    public final void setWriteCallback(XWriteCallback xWriteCallback) {
        this.writeCallback = xWriteCallback;
    }

    public final XBluetoothDevice getDevice() {
        return this.device;
    }

    public final void setDevice(XBluetoothDevice xBluetoothDevice) {
        this.device = xBluetoothDevice;
    }

    public final boolean getNeedUpdate() {
        return this.needUpdate;
    }

    public final void setNeedUpdate(boolean z) {
        this.needUpdate = z;
    }

    public final byte[] getMockResponse() {
        return this.mockResponse;
    }

    public final void setMockResponse(byte[] bArr) {
        this.mockResponse = bArr;
    }

    public final AtomicInteger getRetryCount() {
        return this.retryCount;
    }

    public final void setRetryCount(AtomicInteger atomicInteger) {
        this.retryCount = atomicInteger;
    }

    public final boolean getSuccessWithComplete() {
        return this.successWithComplete;
    }

    public final void setSuccessWithComplete(boolean z) {
        this.successWithComplete = z;
    }

    public final String getUniqueId() {
        return this.command + "(" + this.currentPackage + "/" + this.totalPackage + ")";
    }

    public final String getPackageLog(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        return "command:" + this.command + ",package:" + this.currentPackage + "/" + this.totalPackage + ",reason:" + reason + ",data:[" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, this.data, false, 2, null) + "]}";
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
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String message = error.getMessage();
            String str = message;
            if (str == null || str.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str2 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            FileLog.print$default(fileLog, 6, str2, tag, message + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.e(tag + strComponent1, message + StringUtils.SPACE + strComponent2);
            }
        }
    }

    public final void setTimeout(Throwable error) {
        Intrinsics.checkNotNullParameter(error, "error");
        setCurrentStatus(7);
    }

    public final void setWaiting() {
        if (isSuccess()) {
            return;
        }
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

    public final boolean isWaiting() {
        return currentStatus() == 3;
    }

    public final boolean isSuccess() {
        return currentStatus() == 4;
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
            Function2<? super XTask, ? super Continuation<? super Boolean>, ? extends Object> function2 = this.block;
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

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.task.XTask$doTask$3, reason: invalid class name */
    /* JADX INFO: compiled from: XTask.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XTask$doTask$3", f = "XTask.kt", i = {}, l = {209}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XTask.this.new AnonymousClass3(continuation);
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
                Function2 function2 = XTask.this.block;
                if (function2 != null) {
                    XTask xTask = XTask.this;
                    this.label = 1;
                    obj = function2.invoke(xTask, this);
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

    public final boolean isMatchTask(XCommand xCommand) {
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
        if (this.ignoreFrame) {
            return StringsKt.startsWith$default(this.command, xCommand.getCommand(), false, 2, (Object) null);
        }
        ArrayList<String> response = xCommand.getResponse();
        ArrayList<String> arrayList = response;
        if (arrayList == null || arrayList.isEmpty() || !response.contains(this.command)) {
            return StringsKt.equals(this.command, XCommand.getCommand$default(xCommand, false, 1, null), true);
        }
        return true;
    }

    public String toString() {
        return "command:" + this.command + ",package:" + this.currentPackage + "/" + this.totalPackage + ",ignoreFrame:" + this.ignoreFrame + ",status:" + getStatusDesc(this.atomicStatus.get()) + ",autoDoNextTask:" + this.autoDoNextTask + ",callInMainThread:" + this.callInMainThread + ",operateInterval:" + this.operateInterval + ",durationTimeMillis:" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, this.data, false, 2, null);
    }
}
