package com.nothing.base.util.pipeline;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: PipelineRunnable.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\t\b\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\u0010\"\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010#\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020 H\u0016J\u0010\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0002X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\b\"\u0004\b\u0016\u0010\u0017R$\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/nothing/base/util/pipeline/PipelineRunnable;", "Lcom/nothing/base/util/pipeline/Pool$Poolable;", "Ljava/lang/Runnable;", "<init>", "()V", "id", "", "getId", "()Ljava/lang/String;", "mPipeLine", "Lcom/nothing/base/util/pipeline/Pipeline;", "getMPipeLine", "()Lcom/nothing/base/util/pipeline/Pipeline;", "setMPipeLine", "(Lcom/nothing/base/util/pipeline/Pipeline;)V", "mTask", "getMTask", "()Ljava/lang/Runnable;", "setMTask", "(Ljava/lang/Runnable;)V", "mThreadName", "getMThreadName", "setMThreadName", "(Ljava/lang/String;)V", "value", "", "weight", "getWeight", "()I", "setWeight", "(I)V", "init", "", "runnable", "name", "reset", "run", "setPipeLine", "pipeline", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PipelineRunnable implements Pool.Poolable, Runnable {
    public static final String TAG = "AsyTskExecutor";
    private final String id = "Transaction_" + COUNTER.getAndIncrement();
    private Pipeline mPipeLine;
    private Runnable mTask;
    private String mThreadName;
    private int weight;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicInteger COUNTER = new AtomicInteger(0);
    public static final PipelineRunnablePool TASK_POOL = new PipelineRunnablePool(8, 24);

    public final String getId() {
        return this.id;
    }

    protected final Pipeline getMPipeLine() {
        return this.mPipeLine;
    }

    protected final void setMPipeLine(Pipeline pipeline) {
        this.mPipeLine = pipeline;
    }

    protected final Runnable getMTask() {
        return this.mTask;
    }

    protected final void setMTask(Runnable runnable) {
        this.mTask = runnable;
    }

    protected final String getMThreadName() {
        return this.mThreadName;
    }

    protected final void setMThreadName(String str) {
        this.mThreadName = str;
    }

    public final int getWeight() {
        return this.weight;
    }

    protected final void setWeight(int i) {
        this.weight = i;
    }

    public final void init(Runnable runnable, String name, int weight) {
        this.mTask = runnable;
        this.mThreadName = name;
        this.weight = weight;
    }

    @Override // com.nothing.base.util.pipeline.Pool.Poolable
    public void reset() {
        synchronized (this) {
            init(null, null, 0);
            this.mPipeLine = null;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Pipeline pipeline;
        Runnable runnable;
        String str;
        String name;
        synchronized (this) {
            pipeline = this.mPipeLine;
            runnable = this.mTask;
            str = this.mThreadName;
            Unit unit = Unit.INSTANCE;
        }
        if (TextUtils.isEmpty(str)) {
            name = null;
        } else {
            Thread threadCurrentThread = Thread.currentThread();
            name = threadCurrentThread.getName();
            threadCurrentThread.setName(name + "_" + ((Object) str));
        }
        if (runnable != null) {
            try {
                runnable.run();
            } finally {
                if (name != null) {
                    Thread.currentThread().setName(name);
                }
                if (pipeline != null) {
                    pipeline.next();
                }
                TASK_POOL.free(this);
            }
        }
        if (name != null) {
            Thread.currentThread().setName(name);
        }
    }

    public final void setPipeLine(Pipeline pipeline) {
        this.mPipeLine = pipeline;
    }

    /* JADX INFO: compiled from: PipelineRunnable.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/nothing/base/util/pipeline/PipelineRunnable$Companion;", "", "<init>", "()V", "COUNTER", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCOUNTER", "()Ljava/util/concurrent/atomic/AtomicInteger;", "TAG", "", "TASK_POOL", "Lcom/nothing/base/util/pipeline/PipelineRunnablePool;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        protected final AtomicInteger getCOUNTER() {
            return PipelineRunnable.COUNTER;
        }
    }
}
