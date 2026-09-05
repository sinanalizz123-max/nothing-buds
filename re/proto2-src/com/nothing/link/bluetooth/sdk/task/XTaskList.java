package com.nothing.link.bluetooth.sdk.task;

import android.util.Log;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XTaskList.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\bJ\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\f0\u0014J\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\u0018\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\b\u0010\u001b\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/task/XTaskList;", "", "()V", "list", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/nothing/link/bluetooth/sdk/task/XTask;", "waitList", "add", "", "element", "clear", "contains", "", "task", "containsTaskId", "taskId", "", "firstFlushing", "firstOrNull", "action", "Lkotlin/Function1;", "listAllWait", "moveToRunList", "moveToWaitList", "remove", "size", "", "toString", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XTaskList {
    private final ConcurrentLinkedQueue<XTask> list = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<XTask> waitList = new ConcurrentLinkedQueue<>();

    public final ConcurrentLinkedQueue<XTask> list() {
        return this.list;
    }

    public final XTask firstOrNull(Function1<? super XTask, Boolean> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Iterator<XTask> it = this.list.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            XTask next = it.next();
            Intrinsics.checkNotNull(next);
            if (action.invoke(next).booleanValue()) {
                return next;
            }
        }
        return null;
    }

    public final ConcurrentLinkedQueue<XTask> listAllWait() {
        return this.waitList;
    }

    public final void add(XTask element) {
        Intrinsics.checkNotNullParameter(element, "element");
        this.list.add(element);
    }

    public final void moveToWaitList(XTask element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (!element.isSuccess()) {
            if (!this.waitList.contains(element)) {
                this.waitList.add(element);
            }
            if (this.list.contains(element)) {
                this.list.remove(element);
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = element.getUniqueId() + " move to WaitList, waitList(" + this.waitList.size() + "),runList(" + this.list.size() + ")";
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
                    return;
                }
                return;
            }
            return;
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = element.getUniqueId() + " ignore move to WaitList,is success, waitList(" + this.waitList.size() + "),runList(" + this.list.size() + ")";
            String str5 = str4;
            if (str5 == null || str5.length() == 0) {
                return;
            }
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

    public final void moveToRunList(XTask element) {
        Intrinsics.checkNotNullParameter(element, "element");
        element.setReady();
        if (this.waitList.contains(element)) {
            this.waitList.remove(element);
        }
        this.list.add(element);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "move to RunList, waitList(" + this.waitList.size() + "),runList(" + this.list.size() + ")";
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

    public final void remove(XTask element) {
        if (this.list.contains(element)) {
            this.list.remove(element);
        }
        if (this.waitList.contains(element)) {
            this.waitList.remove(element);
        }
    }

    public final int size() {
        return this.list.size();
    }

    public final boolean contains(XTask task) {
        return this.list.contains(task);
    }

    public final void clear() {
        if (!this.list.isEmpty() || !this.waitList.isEmpty()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "clear task queue list(" + this.list.size() + "),waitList(" + this.waitList.size() + ")!";
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
        }
        this.waitList.clear();
        this.list.clear();
    }

    public final XTask firstFlushing() {
        Object next;
        Iterator<T> it = this.list.iterator();
        while (it.hasNext()) {
            next = it.next();
            XTask xTask = (XTask) next;
            if (xTask.currentStatus() == 1 || xTask.currentStatus() == 2) {
                return (XTask) next;
            }
        }
        next = null;
        return (XTask) next;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:12:0x002a A[RETURN] */
    public final boolean containsTaskId(String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        for (Object obj : this.list) {
            if (Intrinsics.areEqual(((XTask) obj).getUniqueId(), taskId)) {
                if (obj != null) {
                    return true;
                }
                return false;
            }
        }
        obj = null;
        if (obj != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "list[" + this.list + "],wait[" + this.waitList + "]";
    }
}
