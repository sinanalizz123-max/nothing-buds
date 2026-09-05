package com.nothing.base.util.pipeline;

import android.text.TextUtils;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScheduleTimer.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0000\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0013"}, d2 = {"Lcom/nothing/base/util/pipeline/ScheduleTimer;", "", "<init>", "()V", "workTimer", "Ljava/util/Timer;", "getWorkTimer", "()Ljava/util/Timer;", "setWorkTimer", "(Ljava/util/Timer;)V", "schedule", "Ljava/util/TimerTask;", "runnable", "Ljava/lang/Runnable;", "str", "", "j", "", "Task", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScheduleTimer {
    private Timer workTimer = new Timer("ScheduleTimer", true);

    public final Timer getWorkTimer() {
        return this.workTimer;
    }

    public final void setWorkTimer(Timer timer) {
        Intrinsics.checkNotNullParameter(timer, "<set-?>");
        this.workTimer = timer;
    }

    /* JADX INFO: compiled from: ScheduleTimer.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/base/util/pipeline/ScheduleTimer$Task;", "Ljava/util/TimerTask;", "<init>", "()V", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "threadName", "", "getThreadName", "()Ljava/lang/String;", "setThreadName", "(Ljava/lang/String;)V", "run", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Task extends TimerTask {
        public Runnable runnable;
        private String threadName;

        public final Runnable getRunnable() {
            Runnable runnable = this.runnable;
            if (runnable != null) {
                return runnable;
            }
            Intrinsics.throwUninitializedPropertyAccessException("runnable");
            return null;
        }

        public final void setRunnable(Runnable runnable) {
            Intrinsics.checkNotNullParameter(runnable, "<set-?>");
            this.runnable = runnable;
        }

        public final String getThreadName() {
            return this.threadName;
        }

        public final void setThreadName(String str) {
            this.threadName = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            Class<?> cls;
            if (getRunnable() != null) {
                if (TextUtils.isEmpty(this.threadName)) {
                    Runnable runnable = getRunnable();
                    this.threadName = (runnable == null || (cls = runnable.getClass()) == null) ? null : cls.getName();
                }
                AsyncTaskExecutor.INSTANCE.getInstance().execute(this.threadName, getRunnable());
            }
        }
    }

    public final TimerTask schedule(Runnable runnable, String str, long j) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Task task = new Task();
        task.setRunnable(runnable);
        task.setThreadName(str);
        Task task2 = task;
        this.workTimer.schedule(task2, j);
        return task2;
    }
}
