package com.nothing.link.bluetooth.sdk.task;

import android.util.Log;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.CompleteException;
import com.nothing.link.bluetooth.sdk.connect.ReleaseException;
import com.nothing.link.bluetooth.sdk.connect.TimeoutCancelException;
import com.nothing.link.bluetooth.sdk.connect.UnDefinedException;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XCommonTaskQueue.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u001a\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0002J\u001a\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0010J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0006\u0010\u001d\u001a\u00020\u0019J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004R2\u0010\n\u001a&\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f \r*\u0012\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f\u0018\u00010\u000e0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskQueue;", "", ViewKey.TAG, "", "(Ljava/lang/String;)V", "mCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getTag", "()Ljava/lang/String;", "setTag", "taskList", "", "Lcom/nothing/link/bluetooth/sdk/task/XCommonTask;", "kotlin.jvm.PlatformType", "", "addTask", "", "task", "autoRunNextTask", "cancelJobWhenFailed", "message", "cancelJobWhenSuccess", "cancelTaskByCommand", "command", "isSuccess", "", "clear", "getOperateTime", "", "hasTask", "initLoop", "removeTask", "sendTask", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XCommonTaskQueue {
    private CoroutineScope mCoroutineScope;
    private String tag;
    private final List<XCommonTask> taskList;

    /* JADX WARN: Multi-variable type inference failed */
    public XCommonTaskQueue() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public XCommonTaskQueue(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.taskList = Collections.synchronizedList(new LinkedList());
        initLoop();
    }

    public /* synthetic */ XCommonTaskQueue(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    public final String getTag() {
        return this.tag;
    }

    public final void setTag(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tag = str;
    }

    private final void initLoop() {
        this.mCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "(" + this.tag + ") total(" + this.taskList.size() + "), initLoop";
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
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

    public final synchronized void addTask(XCommonTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "(" + this.tag + ") total(" + this.taskList.size() + "), add task:" + task;
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
        task.setReady();
        this.taskList.add(task);
        if (this.taskList.size() == 1) {
            sendTask(task);
        }
    }

    public final boolean hasTask() {
        List<XCommonTask> taskList = this.taskList;
        Intrinsics.checkNotNullExpressionValue(taskList, "taskList");
        return !taskList.isEmpty();
    }

    private final long getOperateTime() {
        long operateMillisTimeOut = XBluetoothManager.INSTANCE.get().getBluetoothConfig().getOperateMillisTimeOut();
        if (operateMillisTimeOut <= 0) {
            return 10000L;
        }
        return operateMillisTimeOut;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void sendTask(final XCommonTask task) {
        if (this.mCoroutineScope == null) {
            initLoop();
        }
        if (task.getDurationTimeMillis() <= 0) {
            task.setDurationTimeMillis(getOperateTime());
        }
        CoroutineScope coroutineScope = this.mCoroutineScope;
        Job jobLaunch$default = coroutineScope != null ? BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new XCommonTaskQueue$sendTask$taskJob$1(task, this, null), 3, null) : null;
        task.setTaskJob(jobLaunch$default);
        if (jobLaunch$default != null) {
            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.task.XCommonTaskQueue.sendTask.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Object objM6347constructorimpl;
                    Object objM6347constructorimpl2;
                    Object objM6347constructorimpl3;
                    Unit unit = null;
                    if (th instanceof TimeoutCancellationException) {
                        AtomicInteger retryCount = task.getRetryCount();
                        if ((retryCount != null ? retryCount.get() : 0) > 0) {
                            AtomicInteger retryCount2 = task.getRetryCount();
                            int iDecrementAndGet = retryCount2 != null ? retryCount2.decrementAndGet() : 0;
                            Logger logger = Logger.INSTANCE;
                            XCommonTask xCommonTask = task;
                            String tag = logger.getTAG();
                            int depth = logger.getDepth();
                            if (logger.isCanLogger(true)) {
                                String str = xCommonTask.getUniqueId() + " task timeout,but need retry! retryCount:" + (iDecrementAndGet + 1) + StringUtils.SPACE + xCommonTask;
                                String str2 = str;
                                if (!(str2 == null || str2.length() == 0)) {
                                    Pair<String, String> trace = logger.getTrace(depth);
                                    String strComponent1 = trace.component1();
                                    String strComponent2 = trace.component2();
                                    FileLog fileLog = FileLog.INSTANCE;
                                    String str3 = logger.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                    FileLog.print$default(fileLog, 5, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                    if (logger.isDebug()) {
                                        Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                    }
                                }
                            }
                            this.sendTask(task);
                            return;
                        }
                        XCommonTask xCommonTask2 = task;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            Logger logger2 = Logger.INSTANCE;
                            String tag2 = logger2.getTAG();
                            int depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(true)) {
                                String str4 = "Timed out " + xCommonTask2.getUniqueId() + ", state:" + xCommonTask2.getCurrentStatusDesc() + ",reason:" + ((TimeoutCancellationException) th).getMessage();
                                String str5 = str4;
                                if (!(str5 == null || str5.length() == 0)) {
                                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                                    String strComponent3 = trace2.component1();
                                    String strComponent4 = trace2.component2();
                                    FileLog fileLog2 = FileLog.INSTANCE;
                                    String str6 = logger2.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                    FileLog.print$default(fileLog2, 6, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                                    if (logger2.isDebug()) {
                                        Log.e(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                                    }
                                }
                            }
                            TimeoutCancelException timeoutCancelException = new TimeoutCancelException(((TimeoutCancellationException) th).getMessage());
                            xCommonTask2.setTimeout(timeoutCancelException);
                            XCommonTaskCallback callback = xCommonTask2.getCallback();
                            if (callback != null) {
                                callback.callFail(xCommonTask2.getDevice(), timeoutCancelException);
                                unit = Unit.INSTANCE;
                            }
                            Result.m6347constructorimpl(unit);
                        } catch (Throwable th2) {
                            Result.Companion companion2 = Result.INSTANCE;
                            Result.m6347constructorimpl(ResultKt.createFailure(th2));
                        }
                        this.autoRunNextTask(task);
                        return;
                    }
                    if (th instanceof CompleteException) {
                        XCommonTask xCommonTask3 = task;
                        XCommonTaskQueue xCommonTaskQueue = this;
                        try {
                            Result.Companion companion3 = Result.INSTANCE;
                            Logger logger3 = Logger.INSTANCE;
                            String tag3 = logger3.getTAG();
                            int depth3 = logger3.getDepth();
                            if (logger3.isCanLogger(true)) {
                                String str7 = "(" + xCommonTaskQueue.getTag() + ") task done!" + xCommonTask3.getUniqueId() + ",message:" + ((CompleteException) th).getMessage();
                                String str8 = str7;
                                if (!(str8 == null || str8.length() == 0)) {
                                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                                    String strComponent5 = trace3.component1();
                                    String strComponent6 = trace3.component2();
                                    FileLog fileLog3 = FileLog.INSTANCE;
                                    String str9 = logger3.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                    FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                                    if (logger3.isDebug()) {
                                        Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                                    }
                                }
                            }
                            XCommonTaskCallback callback2 = xCommonTask3.getCallback();
                            if (callback2 != null) {
                                callback2.callSuccess(xCommonTask3.getDevice(), true, "");
                                unit = Unit.INSTANCE;
                            }
                            objM6347constructorimpl3 = Result.m6347constructorimpl(unit);
                        } catch (Throwable th3) {
                            Result.Companion companion4 = Result.INSTANCE;
                            objM6347constructorimpl3 = Result.m6347constructorimpl(ResultKt.createFailure(th3));
                        }
                        XCommonTaskQueue xCommonTaskQueue2 = this;
                        XCommonTask xCommonTask4 = task;
                        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl3);
                        if (thM6350exceptionOrNullimpl != null) {
                            Logger logger4 = Logger.INSTANCE;
                            String tag4 = logger4.getTAG();
                            int depth4 = logger4.getDepth();
                            if (logger4.isCanLogger(true)) {
                                String str10 = "(" + xCommonTaskQueue2.getTag() + ") task done!" + xCommonTask4.getUniqueId() + ",CompleteException message:" + thM6350exceptionOrNullimpl.getMessage();
                                String str11 = str10;
                                if (!(str11 == null || str11.length() == 0)) {
                                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                                    String strComponent7 = trace4.component1();
                                    String strComponent8 = trace4.component2();
                                    FileLog fileLog4 = FileLog.INSTANCE;
                                    String str12 = logger4.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                                    FileLog.print$default(fileLog4, 5, str12, tag4, str10 + StringUtils.SPACE + strComponent8, null, 16, null);
                                    if (logger4.isDebug()) {
                                        Log.w(tag4 + strComponent7, str10 + StringUtils.SPACE + strComponent8);
                                    }
                                }
                            }
                        }
                        this.autoRunNextTask(task);
                        return;
                    }
                    if (th instanceof CancellationException) {
                        this.removeTask(task);
                        XCommonTask xCommonTask5 = task;
                        XCommonTaskQueue xCommonTaskQueue3 = this;
                        try {
                            Result.Companion companion5 = Result.INSTANCE;
                            Logger logger5 = Logger.INSTANCE;
                            String tag5 = logger5.getTAG();
                            int depth5 = logger5.getDepth();
                            if (logger5.isCanLogger(true)) {
                                String str13 = "(" + xCommonTaskQueue3.getTag() + ") task cancel!" + xCommonTask5.getUniqueId() + ",message:" + ((CancellationException) th).getMessage();
                                String str14 = str13;
                                if (!(str14 == null || str14.length() == 0)) {
                                    Pair<String, String> trace5 = logger5.getTrace(depth5);
                                    String strComponent9 = trace5.component1();
                                    String strComponent10 = trace5.component2();
                                    FileLog fileLog5 = FileLog.INSTANCE;
                                    String str15 = logger5.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                                    FileLog.print$default(fileLog5, 5, str15, tag5, str13 + StringUtils.SPACE + strComponent10, null, 16, null);
                                    if (logger5.isDebug()) {
                                        Log.w(tag5 + strComponent9, str13 + StringUtils.SPACE + strComponent10);
                                    }
                                }
                            }
                            XCommonTaskCallback callback3 = xCommonTask5.getCallback();
                            if (callback3 != null) {
                                callback3.callFail(xCommonTask5.getDevice(), th);
                                unit = Unit.INSTANCE;
                            }
                            objM6347constructorimpl2 = Result.m6347constructorimpl(unit);
                        } catch (Throwable th4) {
                            Result.Companion companion6 = Result.INSTANCE;
                            objM6347constructorimpl2 = Result.m6347constructorimpl(ResultKt.createFailure(th4));
                        }
                        XCommonTaskQueue xCommonTaskQueue4 = this;
                        XCommonTask xCommonTask6 = task;
                        Throwable thM6350exceptionOrNullimpl2 = Result.m6350exceptionOrNullimpl(objM6347constructorimpl2);
                        if (thM6350exceptionOrNullimpl2 != null) {
                            Logger logger6 = Logger.INSTANCE;
                            String tag6 = logger6.getTAG();
                            int depth6 = logger6.getDepth();
                            if (logger6.isCanLogger(true)) {
                                String str16 = "(" + xCommonTaskQueue4.getTag() + ") task done!" + xCommonTask6.getUniqueId() + ",CancellationException message:" + thM6350exceptionOrNullimpl2.getMessage();
                                String str17 = str16;
                                if (!(str17 == null || str17.length() == 0)) {
                                    Pair<String, String> trace6 = logger6.getTrace(depth6);
                                    String strComponent11 = trace6.component1();
                                    String strComponent12 = trace6.component2();
                                    FileLog fileLog6 = FileLog.INSTANCE;
                                    String str18 = logger6.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str18, "format(...)");
                                    FileLog.print$default(fileLog6, 5, str18, tag6, str16 + StringUtils.SPACE + strComponent12, null, 16, null);
                                    if (logger6.isDebug()) {
                                        Log.w(tag6 + strComponent11, str16 + StringUtils.SPACE + strComponent12);
                                    }
                                }
                            }
                        }
                        this.autoRunNextTask(task);
                        return;
                    }
                    XCommonTask xCommonTask7 = task;
                    XCommonTaskQueue xCommonTaskQueue5 = this;
                    try {
                        Result.Companion companion7 = Result.INSTANCE;
                        Logger logger7 = Logger.INSTANCE;
                        String tag7 = logger7.getTAG();
                        int depth7 = logger7.getDepth();
                        if (logger7.isCanLogger(true)) {
                            String str19 = "(" + xCommonTaskQueue5.getTag() + ") task error!" + xCommonTask7.getUniqueId() + ",message:" + (th != null ? th.getMessage() : null);
                            String str20 = str19;
                            if (!(str20 == null || str20.length() == 0)) {
                                Pair<String, String> trace7 = logger7.getTrace(depth7);
                                String strComponent13 = trace7.component1();
                                String strComponent14 = trace7.component2();
                                FileLog fileLog7 = FileLog.INSTANCE;
                                String str21 = logger7.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str21, "format(...)");
                                FileLog.print$default(fileLog7, 5, str21, tag7, str19 + StringUtils.SPACE + strComponent14, null, 16, null);
                                if (logger7.isDebug()) {
                                    Log.w(tag7 + strComponent13, str19 + StringUtils.SPACE + strComponent14);
                                }
                            }
                        }
                        XCommonTaskCallback callback4 = xCommonTask7.getCallback();
                        if (callback4 != null) {
                            callback4.callFail(xCommonTask7.getDevice(), new UnDefinedException(th != null ? th.getMessage() : null, null, 2, null));
                            unit = Unit.INSTANCE;
                        }
                        objM6347constructorimpl = Result.m6347constructorimpl(unit);
                    } catch (Throwable th5) {
                        Result.Companion companion8 = Result.INSTANCE;
                        objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th5));
                    }
                    XCommonTaskQueue xCommonTaskQueue6 = this;
                    XCommonTask xCommonTask8 = task;
                    Throwable thM6350exceptionOrNullimpl3 = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
                    if (thM6350exceptionOrNullimpl3 != null) {
                        Logger logger8 = Logger.INSTANCE;
                        String tag8 = logger8.getTAG();
                        int depth8 = logger8.getDepth();
                        if (logger8.isCanLogger(true)) {
                            String str22 = "(" + xCommonTaskQueue6.getTag() + ") task done!" + xCommonTask8.getUniqueId() + ",else message:" + thM6350exceptionOrNullimpl3.getMessage();
                            String str23 = str22;
                            if (!(str23 == null || str23.length() == 0)) {
                                Pair<String, String> trace8 = logger8.getTrace(depth8);
                                String strComponent15 = trace8.component1();
                                String strComponent16 = trace8.component2();
                                FileLog fileLog8 = FileLog.INSTANCE;
                                String str24 = logger8.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str24, "format(...)");
                                FileLog.print$default(fileLog8, 5, str24, tag8, str22 + StringUtils.SPACE + strComponent16, null, 16, null);
                                if (logger8.isDebug()) {
                                    Log.w(tag8 + strComponent15, str22 + StringUtils.SPACE + strComponent16);
                                }
                            }
                        }
                    }
                    this.autoRunNextTask(task);
                }
            });
        }
    }

    public final void cancelTaskByCommand(String command, boolean isSuccess) {
        Intrinsics.checkNotNullParameter(command, "command");
        List<XCommonTask> taskList = this.taskList;
        Intrinsics.checkNotNullExpressionValue(taskList, "taskList");
        XCommonTask xCommonTask = (XCommonTask) CollectionsKt.firstOrNull((List) taskList);
        if (xCommonTask != null) {
            if (isSuccess) {
                cancelJobWhenSuccess(xCommonTask, "cancel success " + command);
            } else {
                cancelJobWhenFailed(xCommonTask, "cancel failed " + command + StringUtils.SPACE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoRunNextTask(XCommonTask task) {
        Object objM6347constructorimpl;
        Unit unit;
        boolean autoDoNextTask = task.getAutoDoNextTask();
        removeTask(task);
        if (autoDoNextTask) {
            try {
                Result.Companion companion = Result.INSTANCE;
                List<XCommonTask> taskList = this.taskList;
                Intrinsics.checkNotNullExpressionValue(taskList, "taskList");
                XCommonTask xCommonTask = (XCommonTask) CollectionsKt.firstOrNull((List) taskList);
                if (xCommonTask != null) {
                    sendTask(xCommonTask);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                objM6347constructorimpl = Result.m6347constructorimpl(unit);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
            if (thM6350exceptionOrNullimpl != null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "(" + this.tag + ") auto run next task! onFailure  " + thM6350exceptionOrNullimpl.getMessage();
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        return;
                    }
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
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeTask(XCommonTask task) {
        Object objM6347constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (this.taskList.contains(task)) {
                this.taskList.remove(task);
            }
            objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "(" + this.tag + ") removeTask onFailure  " + thM6350exceptionOrNullimpl.getMessage();
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelJobWhenFailed(XCommonTask task, String message) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "(" + this.tag + ") flush " + task + " failed,reason:" + message;
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
        CancellationException cancellationException = new CancellationException(message);
        task.setFailed(cancellationException);
        Job taskJob = task.getTaskJob();
        if (taskJob != null) {
            taskJob.cancel(cancellationException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelJobWhenSuccess(XCommonTask task, String message) {
        task.setSuccess();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "(" + this.tag + ") flush " + task + " success";
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
        CompleteException completeException = new CompleteException(message);
        Job taskJob = task.getTaskJob();
        if (taskJob != null) {
            taskJob.cancel((CancellationException) completeException);
        }
    }

    public final void clear() {
        Job taskJob;
        List<XCommonTask> taskList = this.taskList;
        Intrinsics.checkNotNullExpressionValue(taskList, "taskList");
        synchronized (taskList) {
            Iterator<XCommonTask> it = this.taskList.iterator();
            while (it.hasNext()) {
                XCommonTask next = it.next();
                next.setCancel();
                if (next != null && (taskJob = next.getTaskJob()) != null) {
                    taskJob.cancel((CancellationException) new ReleaseException("clear"));
                }
                it.remove();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.taskList.clear();
        CoroutineScope coroutineScope = this.mCoroutineScope;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.mCoroutineScope = null;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "clear ".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "clear  " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "clear  " + strComponent2);
            }
        }
    }
}
