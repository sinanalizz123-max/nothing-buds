package com.nothing.base.util.pipeline;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PipelineRunnablePool.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\u0010\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0017J\b\u0010\u0012\u001a\u00020\u0002H\u0017J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\"\u0010\u0012\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0004R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/nothing/base/util/pipeline/PipelineRunnablePool;", "Lcom/nothing/base/util/pipeline/Pool;", "Lcom/nothing/base/util/pipeline/PipelineRunnable;", "initialSize", "", "maxSize", "<init>", "(II)V", "mIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "clear", "", "free", "pipelineRunnable", "freeAll", "list", "", "newObject", "obtain", "runnable", "Ljava/lang/Runnable;", "name", "", "weight", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PipelineRunnablePool extends Pool<PipelineRunnable> {
    private final AtomicInteger mIndex;

    public PipelineRunnablePool(int i, int i2) {
        super(i, i2);
        this.mIndex = new AtomicInteger(1);
    }

    @Override // com.nothing.base.util.pipeline.Pool
    public synchronized void clear() {
        super.clear();
    }

    @Override // com.nothing.base.util.pipeline.Pool
    public synchronized void free(PipelineRunnable pipelineRunnable) {
        super.free(pipelineRunnable);
    }

    @Override // com.nothing.base.util.pipeline.Pool
    public void freeAll(List<? extends PipelineRunnable> list) {
        super.freeAll(list);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nothing.base.util.pipeline.Pool
    @Deprecated(message = "")
    public PipelineRunnable newObject() {
        throw new RuntimeException("call newObject(Runnable, String) method instead.");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.nothing.base.util.pipeline.Pool
    @Deprecated(message = "")
    public PipelineRunnable obtain() {
        throw new RuntimeException("call obtain(Runnable, String, int) method instead.");
    }

    public final synchronized PipelineRunnable obtain(Runnable runnable, String name) {
        return obtain(runnable, name, 0);
    }

    public final synchronized PipelineRunnable obtain(Runnable runnable, String name, int weight) {
        PipelineRunnable pipelineRunnable;
        if (this.freeObjects.size() == 0) {
            String strValueOf = String.valueOf(this.mIndex.getAndIncrement());
            String str = name;
            name = (str == null || str.length() == 0) ? strValueOf : strValueOf + "_" + name;
            pipelineRunnable = new PipelineRunnable();
        } else {
            Object objPop = this.freeObjects.pop();
            Intrinsics.checkNotNull(objPop, "null cannot be cast to non-null type com.nothing.base.util.pipeline.PipelineRunnable");
            pipelineRunnable = (PipelineRunnable) objPop;
        }
        pipelineRunnable.init(runnable, name, weight);
        return pipelineRunnable;
    }
}
