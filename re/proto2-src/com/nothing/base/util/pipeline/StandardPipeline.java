package com.nothing.base.util.pipeline;

import android.util.Log;
import com.tekartik.sqflite.Constant;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StandardPipeline.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\tJ\u001c\u0010)\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010)\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u00142\b\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010,\u001a\u00020-H\u0016J\u0006\u0010.\u001a\u00020-J\u0010\u0010/\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010\tJ\t\u00100\u001a\u00020-H\u0096\u0002J\u0012\u00101\u001a\u00020'2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u00102\u001a\u00020-H\u0016J\b\u00103\u001a\u00020-H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010%8\u0004X\u0085\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/nothing/base/util/pipeline/StandardPipeline;", "Lcom/nothing/base/util/pipeline/Pipeline;", "str", "", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/lang/String;Ljava/util/concurrent/Executor;)V", "mActive", "Lcom/nothing/base/util/pipeline/PipelineRunnable;", "getMActive", "()Lcom/nothing/base/util/pipeline/PipelineRunnable;", "setMActive", "(Lcom/nothing/base/util/pipeline/PipelineRunnable;)V", "mExecutor", "getMExecutor", "()Ljava/util/concurrent/Executor;", "setMExecutor", "(Ljava/util/concurrent/Executor;)V", "mIdleListener", "Ljava/lang/Runnable;", "getMIdleListener", "()Ljava/lang/Runnable;", "setMIdleListener", "(Ljava/lang/Runnable;)V", "mIsStart", "", "getMIsStart", "()Z", "setMIsStart", "(Z)V", "mName", "getMName", "()Ljava/lang/String;", "setMName", "(Ljava/lang/String;)V", "mTasks", "Ljava/util/ArrayList;", "addIdleListener", "", "runnable", "addTask", "pipelineRunnable", "name", "weight", "", "doStart", Constant.METHOD_EXECUTE, "next", "setExecutor", "start", "stop", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class StandardPipeline implements Pipeline {
    private PipelineRunnable mActive;
    private Executor mExecutor;
    private Runnable mIdleListener;
    private volatile boolean mIsStart;
    private String mName;
    protected final ArrayList<PipelineRunnable> mTasks;

    /* JADX WARN: Multi-variable type inference failed */
    public StandardPipeline(String str) {
        this(str, null, 2, 0 == true ? 1 : 0);
    }

    public StandardPipeline(String str, Executor executor) {
        this.mTasks = new ArrayList<>();
        this.mIsStart = false;
        if (str == null || str.length() == 0) {
            this.mName = "StandardPipeline";
        } else {
            this.mName = str;
        }
        this.mExecutor = executor;
    }

    public /* synthetic */ StandardPipeline(String str, Executor executor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : executor);
    }

    protected final PipelineRunnable getMActive() {
        return this.mActive;
    }

    protected final void setMActive(PipelineRunnable pipelineRunnable) {
        this.mActive = pipelineRunnable;
    }

    protected final Executor getMExecutor() {
        return this.mExecutor;
    }

    protected final void setMExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    protected final Runnable getMIdleListener() {
        return this.mIdleListener;
    }

    protected final void setMIdleListener(Runnable runnable) {
        this.mIdleListener = runnable;
    }

    protected final boolean getMIsStart() {
        return this.mIsStart;
    }

    protected final void setMIsStart(boolean z) {
        this.mIsStart = z;
    }

    public final String getMName() {
        return this.mName;
    }

    public final void setMName(String str) {
        this.mName = str;
    }

    @Override // com.nothing.base.util.pipeline.Pipeline
    public void addIdleListener(Runnable runnable) {
        if (runnable == null) {
            this.mIdleListener = null;
        } else if (this.mIdleListener == null) {
            this.mIdleListener = runnable;
        }
    }

    public final void addTask(PipelineRunnable pipelineRunnable) {
        Intrinsics.checkNotNullParameter(pipelineRunnable, "pipelineRunnable");
        if (this.mTasks == null) {
            throw new RuntimeException("The StandardPipeline has already stopped.");
        }
        pipelineRunnable.setPipeLine(this);
        synchronized (this.mTasks) {
            int i = 0;
            if (!this.mTasks.isEmpty()) {
                int size = this.mTasks.size() - 1;
                while (size >= 0) {
                    if (pipelineRunnable.getWeight() <= this.mTasks.get(size).getWeight()) {
                        size++;
                        break;
                    }
                    size--;
                }
                if (size >= 0) {
                    i = size;
                }
            }
            this.mTasks.add(i, pipelineRunnable);
            Unit unit = Unit.INSTANCE;
        }
        if (this.mIsStart) {
            doStart();
        }
    }

    @Override // com.nothing.base.util.pipeline.Pipeline
    public void addTask(Runnable runnable, String name) {
        addTask(runnable, name, 0);
    }

    @Override // com.nothing.base.util.pipeline.Pipeline
    public void addTask(Runnable runnable, String name, int weight) {
        addTask(PipelineRunnable.TASK_POOL.obtain(runnable, name, weight));
    }

    public final int doStart() {
        if (this.mActive == null) {
            return next();
        }
        return 0;
    }

    public final void execute(PipelineRunnable pipelineRunnable) {
        if (pipelineRunnable != null) {
            Executor executor = this.mExecutor;
            if (executor != null) {
                Intrinsics.checkNotNull(executor);
                executor.execute(pipelineRunnable);
                return;
            }
            throw new RuntimeException("The StandardPipeline's Executor is null.");
        }
    }

    @Override // com.nothing.base.util.pipeline.Pipeline
    public int next() {
        ArrayList<PipelineRunnable> arrayList = this.mTasks;
        if (arrayList == null) {
            return 0;
        }
        int size = arrayList.size();
        synchronized (this.mTasks) {
            if (!this.mTasks.isEmpty()) {
                this.mActive = this.mTasks.remove(0);
            } else {
                this.mActive = null;
            }
            Unit unit = Unit.INSTANCE;
        }
        PipelineRunnable pipelineRunnable = this.mActive;
        if (pipelineRunnable != null) {
            execute(pipelineRunnable);
            return size;
        }
        Runnable runnable = this.mIdleListener;
        this.mIdleListener = null;
        if (runnable != null) {
            try {
                runnable.run();
                return size;
            } catch (Throwable th) {
                Log.w("AsyTskExecutor", th);
            }
        }
        return size;
    }

    @Override // com.nothing.base.util.pipeline.Pipeline
    public void setExecutor(Executor executor) {
        this.mExecutor = executor;
    }

    @Override // com.nothing.base.util.pipeline.Pipeline
    public int start() {
        if (this.mExecutor == null) {
            throw new RuntimeException("StandardPipeline start failed : The StandardPipeline's Executor is null.");
        }
        this.mIsStart = true;
        return doStart();
    }

    @Override // com.nothing.base.util.pipeline.Pipeline
    public int stop() {
        this.mIsStart = false;
        ArrayList<PipelineRunnable> arrayList = this.mTasks;
        if (arrayList == null) {
            return 0;
        }
        int size = arrayList.size();
        this.mTasks.clear();
        return size;
    }
}
