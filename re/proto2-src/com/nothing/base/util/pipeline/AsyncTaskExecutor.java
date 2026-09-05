package com.nothing.base.util.pipeline;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tekartik.sqflite.Constant;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AsyncTaskExecutor.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 >2\u00020\u0001:\u0001>B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0012J\u001e\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%J\u0018\u0010&\u001a\u00020'2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010!\u001a\u00020\"J\u0018\u0010(\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0012J \u0010(\u001a\u00020'2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020%J \u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0012J(\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010$\u001a\u00020%J\u0010\u0010.\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\u0012J.\u0010/\u001a\u0006\u0012\u0002\b\u0003002\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104J6\u00105\u001a\u0006\u0012\u0002\b\u0003002\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u00106\u001a\u0002022\u0006\u00107\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104J \u00108\u001a\u0002092\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u00101\u001a\u000202J6\u0010:\u001a\u0006\u0012\u0002\b\u0003002\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u00106\u001a\u0002022\u0006\u00107\u001a\u0002022\b\u00103\u001a\u0004\u0018\u000104J\u000e\u0010;\u001a\u00020'2\u0006\u0010<\u001a\u00020\u0017J\u0006\u0010=\u001a\u00020'R\u0014\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000f\u0010\u0003R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0014\u0010\u0003R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010*\u001a\u00020+8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010-\u00a8\u0006?"}, d2 = {"Lcom/nothing/base/util/pipeline/AsyncTaskExecutor;", "", "<init>", "()V", "PARALLEL_EXECUTOR", "Ljava/util/concurrent/ThreadPoolExecutor;", "getPARALLEL_EXECUTOR$annotations", "scheduledExecutor", "Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "getScheduledExecutor", "()Ljava/util/concurrent/ScheduledThreadPoolExecutor;", "setScheduledExecutor", "(Ljava/util/concurrent/ScheduledThreadPoolExecutor;)V", "SCHEDULED_TIMER", "Lcom/nothing/base/util/pipeline/ScheduleTimer;", "getSCHEDULED_TIMER$annotations", "SERIAL_EXECUTORS", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/base/util/pipeline/StandardPipeline;", "getSERIAL_EXECUTORS$annotations", "mGlobalStandardPipline", "mRunnableWrapper", "Lcom/nothing/base/util/pipeline/RunnableWrapper;", "mTransactionExecutor", "Lcom/nothing/base/util/pipeline/TransactionPipeline;", "globalStandardPipline", "getGlobalStandardPipline", "()Lcom/nothing/base/util/pipeline/StandardPipeline;", "transactionExecutor", "getTransactionExecutor", "()Lcom/nothing/base/util/pipeline/TransactionPipeline;", "addTransaction", "runnable", "Ljava/lang/Runnable;", "name", "weight", "", Constant.METHOD_EXECUTE, "", "executeSerially", "str", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "removeTransaction", "schedule", "Ljava/util/concurrent/ScheduledFuture;", "delay", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "scheduleAtFixedRate", "initialDelay", TypedValues.CycleType.S_WAVE_PERIOD, "scheduleTimer", "Ljava/util/TimerTask;", "scheduleWithFixedDelay", "setRunnableWrapper", "runnableWrapper", "shutdown", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsyncTaskExecutor {
    private static int CORE_POOL_SIZE = 0;
    private static int CPU_COUNT = 0;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAXIMUM_POOL_SIZE;
    private static final String NAME_GLOBAL_STANDARD_PIPELINE = "GlobalStandardPipeline";
    public static final String TAG = "AsyTskExecutor";
    private static final ThreadFactory THREADFACTORY;
    private static final int availableProcessors;
    private static final AsyncTaskExecutor instance;
    private volatile ThreadPoolExecutor PARALLEL_EXECUTOR;
    private final ScheduleTimer SCHEDULED_TIMER;
    private final ConcurrentHashMap<String, StandardPipeline> SERIAL_EXECUTORS;
    private StandardPipeline mGlobalStandardPipline;
    private volatile RunnableWrapper mRunnableWrapper;
    private TransactionPipeline mTransactionExecutor;
    private volatile ScheduledThreadPoolExecutor scheduledExecutor;

    private static /* synthetic */ void getPARALLEL_EXECUTOR$annotations() {
    }

    private static /* synthetic */ void getSCHEDULED_TIMER$annotations() {
    }

    private static /* synthetic */ void getSERIAL_EXECUTORS$annotations() {
    }

    private AsyncTaskExecutor() {
        int i = CORE_POOL_SIZE;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        ThreadFactory threadFactory = THREADFACTORY;
        this.PARALLEL_EXECUTOR = new ThreadPoolExecutor(i, i, 3L, timeUnit, linkedBlockingQueue, threadFactory);
        this.scheduledExecutor = new ScheduledThreadPoolExecutor(CORE_POOL_SIZE, threadFactory);
        this.SCHEDULED_TIMER = new ScheduleTimer();
        this.SERIAL_EXECUTORS = new ConcurrentHashMap<>();
        this.scheduledExecutor.setKeepAliveTime(10L, TimeUnit.MILLISECONDS);
        this.scheduledExecutor.allowCoreThreadTimeOut(true);
        this.scheduledExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        this.PARALLEL_EXECUTOR.allowCoreThreadTimeOut(true);
        this.PARALLEL_EXECUTOR.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    }

    public final ScheduledThreadPoolExecutor getScheduledExecutor() {
        return this.scheduledExecutor;
    }

    public final void setScheduledExecutor(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        Intrinsics.checkNotNullParameter(scheduledThreadPoolExecutor, "<set-?>");
        this.scheduledExecutor = scheduledThreadPoolExecutor;
    }

    /* JADX INFO: compiled from: AsyncTaskExecutor.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/base/util/pipeline/AsyncTaskExecutor$Companion;", "", "<init>", "()V", "availableProcessors", "", "CORE_POOL_SIZE", "getCORE_POOL_SIZE$annotations", "CPU_COUNT", "NAME_GLOBAL_STANDARD_PIPELINE", "", "TAG", "THREADFACTORY", "Ljava/util/concurrent/ThreadFactory;", "getTHREADFACTORY$annotations", "MAXIMUM_POOL_SIZE", "getMAXIMUM_POOL_SIZE", "()I", "instance", "Lcom/nothing/base/util/pipeline/AsyncTaskExecutor;", "getInstance", "()Lcom/nothing/base/util/pipeline/AsyncTaskExecutor;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static /* synthetic */ void getCORE_POOL_SIZE$annotations() {
        }

        private static /* synthetic */ void getTHREADFACTORY$annotations() {
        }

        private Companion() {
        }

        public final int getMAXIMUM_POOL_SIZE() {
            return AsyncTaskExecutor.MAXIMUM_POOL_SIZE;
        }

        public final AsyncTaskExecutor getInstance() {
            return AsyncTaskExecutor.instance;
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        availableProcessors = iAvailableProcessors;
        CORE_POOL_SIZE = iAvailableProcessors + 1;
        CPU_COUNT = iAvailableProcessors;
        THREADFACTORY = new ThreadFactory() { // from class: com.nothing.base.util.pipeline.AsyncTaskExecutor$Companion$THREADFACTORY$1
            private final AtomicInteger mCount = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                Thread thread = new Thread(runnable, "AsyTskExecutor_" + this.mCount.incrementAndGet());
                thread.setPriority(1);
                return thread;
            }
        };
        MAXIMUM_POOL_SIZE = (CPU_COUNT * 3) + 1;
        instance = new AsyncTaskExecutor();
    }

    private final StandardPipeline getGlobalStandardPipline() {
        StandardPipeline standardPipeline = this.mGlobalStandardPipline;
        if (standardPipeline != null) {
            return standardPipeline;
        }
        synchronized (this) {
            StandardPipeline standardPipeline2 = this.mGlobalStandardPipline;
            if (standardPipeline2 != null) {
                return standardPipeline2;
            }
            StandardPipeline standardPipeline3 = new StandardPipeline(NAME_GLOBAL_STANDARD_PIPELINE, new ThreadPoolExecutor(1, 1, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.nothing.base.util.pipeline.AsyncTaskExecutor$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    return AsyncTaskExecutor._get_globalStandardPipline_$lambda$1$lambda$0(runnable);
                }
            }));
            this.mGlobalStandardPipline = standardPipeline3;
            Intrinsics.checkNotNull(standardPipeline3);
            standardPipeline3.start();
            return this.mGlobalStandardPipline;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread _get_globalStandardPipline_$lambda$1$lambda$0(Runnable runnable) {
        Thread thread = new Thread(runnable, "QN_SERIAL_EXECUTOR");
        thread.setPriority(1);
        return thread;
    }

    private final TransactionPipeline getTransactionExecutor() {
        TransactionPipeline transactionPipeline = this.mTransactionExecutor;
        if (transactionPipeline != null) {
            return transactionPipeline;
        }
        synchronized (this) {
            TransactionPipeline transactionPipeline2 = this.mTransactionExecutor;
            if (transactionPipeline2 != null) {
                return transactionPipeline2;
            }
            TransactionPipeline transactionPipeline3 = new TransactionPipeline("TransactionPipeline", this.PARALLEL_EXECUTOR);
            this.mTransactionExecutor = transactionPipeline3;
            Intrinsics.checkNotNull(transactionPipeline3);
            transactionPipeline3.start();
            return this.mTransactionExecutor;
        }
    }

    public final String addTransaction(Runnable runnable, String name) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        PipelineRunnable pipelineRunnableObtain = PipelineRunnable.TASK_POOL.obtain(runnable, name);
        TransactionPipeline transactionExecutor = getTransactionExecutor();
        Intrinsics.checkNotNull(transactionExecutor);
        transactionExecutor.addTask(pipelineRunnableObtain);
        return pipelineRunnableObtain.getId();
    }

    public final String addTransaction(Runnable runnable, String name, int weight) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Intrinsics.checkNotNullParameter(name, "name");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        PipelineRunnable pipelineRunnableObtain = PipelineRunnable.TASK_POOL.obtain(runnable, name, weight);
        TransactionPipeline transactionExecutor = getTransactionExecutor();
        Intrinsics.checkNotNull(transactionExecutor);
        transactionExecutor.addTask(pipelineRunnableObtain);
        return pipelineRunnableObtain.getId();
    }

    public final void execute(String name, Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        this.PARALLEL_EXECUTOR.execute(PipelineRunnable.TASK_POOL.obtain(runnable, name));
    }

    public final void executeSerially(Runnable runnable, String name) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        StandardPipeline globalStandardPipline = getGlobalStandardPipline();
        Intrinsics.checkNotNull(globalStandardPipline);
        globalStandardPipline.addTask(PipelineRunnable.TASK_POOL.obtain(runnable, name));
    }

    public final void executeSerially(Runnable runnable, String name, int weight) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        StandardPipeline globalStandardPipline = getGlobalStandardPipline();
        Intrinsics.checkNotNull(globalStandardPipline);
        globalStandardPipline.addTask(PipelineRunnable.TASK_POOL.obtain(runnable, name, weight));
    }

    public final void executeSerially(String str, Runnable runnable, String name) {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        if (TextUtils.isEmpty(str) || StringsKt.equals(str, NAME_GLOBAL_STANDARD_PIPELINE, true)) {
            StandardPipeline globalStandardPipline = getGlobalStandardPipline();
            Intrinsics.checkNotNull(globalStandardPipline);
            globalStandardPipline.addTask(PipelineRunnable.TASK_POOL.obtain(runnable, name));
        } else {
            StandardPipeline standardPipeline = this.SERIAL_EXECUTORS.get(str);
            if (standardPipeline == null) {
                standardPipeline = new StandardPipeline(str, this.PARALLEL_EXECUTOR);
                standardPipeline.start();
                this.SERIAL_EXECUTORS.put(str, standardPipeline);
            }
            standardPipeline.addTask(PipelineRunnable.TASK_POOL.obtain(runnable, name));
        }
    }

    public final void executeSerially(String str, Runnable runnable, String name, int weight) {
        Intrinsics.checkNotNullParameter(str, "str");
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        if (TextUtils.isEmpty(str) || StringsKt.equals(str, NAME_GLOBAL_STANDARD_PIPELINE, true)) {
            StandardPipeline globalStandardPipline = getGlobalStandardPipline();
            Intrinsics.checkNotNull(globalStandardPipline);
            globalStandardPipline.addTask(PipelineRunnable.TASK_POOL.obtain(runnable, name, weight));
        } else {
            StandardPipeline standardPipeline = this.SERIAL_EXECUTORS.get(str);
            if (standardPipeline == null) {
                standardPipeline = new StandardPipeline(str, this.PARALLEL_EXECUTOR);
                standardPipeline.start();
                this.SERIAL_EXECUTORS.put(str, standardPipeline);
            }
            standardPipeline.addTask(PipelineRunnable.TASK_POOL.obtain(runnable, name, weight));
        }
    }

    public final Executor getExecutor() {
        return this.PARALLEL_EXECUTOR;
    }

    public final void removeTransaction(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("The parameter id can't be empty.".toString());
        }
        TransactionPipeline transactionExecutor = getTransactionExecutor();
        Intrinsics.checkNotNull(transactionExecutor);
        transactionExecutor.nextTransaction();
    }

    public final ScheduledFuture<?> schedule(Runnable runnable, String name, long delay, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        ScheduledFuture<?> scheduledFutureSchedule = this.scheduledExecutor.schedule(PipelineRunnable.TASK_POOL.obtain(runnable, name), delay, timeUnit);
        Intrinsics.checkNotNullExpressionValue(scheduledFutureSchedule, "schedule(...)");
        return scheduledFutureSchedule;
    }

    public final ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, String name, long initialDelay, long period, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        ScheduledFuture<?> scheduledFutureScheduleAtFixedRate = this.scheduledExecutor.scheduleAtFixedRate(PipelineRunnable.TASK_POOL.obtain(runnable, name), initialDelay, period, timeUnit);
        Intrinsics.checkNotNullExpressionValue(scheduledFutureScheduleAtFixedRate, "scheduleAtFixedRate(...)");
        return scheduledFutureScheduleAtFixedRate;
    }

    public final TimerTask scheduleTimer(Runnable runnable, String name, long delay) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        return this.SCHEDULED_TIMER.schedule(runnable, name, delay);
    }

    public final ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, String name, long initialDelay, long period, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        if (TextUtils.isEmpty(name)) {
            throw new IllegalArgumentException("The parameter threadName can't be empty.".toString());
        }
        RunnableWrapper runnableWrapper = this.mRunnableWrapper;
        if (runnableWrapper != null) {
            runnable = runnableWrapper.wrapRunnable(runnable);
        }
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay = this.scheduledExecutor.scheduleWithFixedDelay(PipelineRunnable.TASK_POOL.obtain(runnable, name), initialDelay, period, timeUnit);
        Intrinsics.checkNotNullExpressionValue(scheduledFutureScheduleWithFixedDelay, "scheduleWithFixedDelay(...)");
        return scheduledFutureScheduleWithFixedDelay;
    }

    public final void setRunnableWrapper(RunnableWrapper runnableWrapper) {
        Intrinsics.checkNotNullParameter(runnableWrapper, "runnableWrapper");
        this.mRunnableWrapper = runnableWrapper;
    }

    public final void shutdown() {
        TransactionPipeline transactionExecutor = getTransactionExecutor();
        Intrinsics.checkNotNull(transactionExecutor);
        transactionExecutor.stop();
        StandardPipeline globalStandardPipline = getGlobalStandardPipline();
        Intrinsics.checkNotNull(globalStandardPipline);
        globalStandardPipline.stop();
        for (StandardPipeline standardPipeline : this.SERIAL_EXECUTORS.values()) {
            Intrinsics.checkNotNullExpressionValue(standardPipeline, "next(...)");
            standardPipeline.stop();
        }
        this.PARALLEL_EXECUTOR.shutdown();
        this.scheduledExecutor.shutdown();
    }
}
