package com.nothing.base.util.pipeline;

import java.util.ArrayList;
import java.util.concurrent.Executor;
import kotlin.Metadata;

/* JADX INFO: compiled from: TransactionPipeline.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\u0006\u0010\n\u001a\u00020\t\u00a8\u0006\u000b"}, d2 = {"Lcom/nothing/base/util/pipeline/TransactionPipeline;", "Lcom/nothing/base/util/pipeline/StandardPipeline;", "str", "", "executor", "Ljava/util/concurrent/Executor;", "<init>", "(Ljava/lang/String;Ljava/util/concurrent/Executor;)V", "next", "", "nextTransaction", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TransactionPipeline extends StandardPipeline {
    public TransactionPipeline(String str, Executor executor) {
        super(str, executor);
    }

    @Override // com.nothing.base.util.pipeline.StandardPipeline, com.nothing.base.util.pipeline.Pipeline
    public int next() {
        ArrayList<PipelineRunnable> arrayList = this.mTasks;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final int nextTransaction() {
        return super.next();
    }
}
