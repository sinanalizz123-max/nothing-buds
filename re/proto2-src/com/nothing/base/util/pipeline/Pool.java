package com.nothing.base.util.pipeline;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Pool.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u001cB\u001d\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\u0010\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0017\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0019H\u0016J\r\u0010\u001b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0011R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t8\u0004X\u0085\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/base/util/pipeline/Pool;", ExifInterface.GPS_DIRECTION_TRUE, "", "initialSize", "", "maxSize", "<init>", "(II)V", "freeObjects", "Ljava/util/ArrayDeque;", "max", "peak", "getPeak", "()I", "setPeak", "(I)V", "newObject", "()Ljava/lang/Object;", "clear", "", "free", "obj", "(Ljava/lang/Object;)V", "freeAll", "list", "", "getFree", "obtain", "Poolable", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Pool<T> {
    protected final ArrayDeque<T> freeObjects;
    private final int max;
    private int peak;

    /* JADX INFO: compiled from: Pool.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/nothing/base/util/pipeline/Pool$Poolable;", "", "reset", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Poolable {
        void reset();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Pool() {
        int i = 0;
        this(i, i, 3, null);
    }

    public Pool(int i) {
        this(i, 0, 2, null);
    }

    public abstract T newObject();

    public Pool(int i, int i2) {
        this.freeObjects = new ArrayDeque<>(i);
        this.max = i2;
    }

    public /* synthetic */ Pool(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 16 : i, (i3 & 2) != 0 ? Integer.MAX_VALUE : i2);
    }

    public final int getPeak() {
        return this.peak;
    }

    public final void setPeak(int i) {
        this.peak = i;
    }

    public void clear() {
        this.freeObjects.clear();
    }

    public void free(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("object cannot be null.");
        }
        if (this.freeObjects.size() < this.max) {
            this.freeObjects.add(obj);
            this.peak = Math.max(this.peak, this.freeObjects.size());
        }
        if (obj instanceof Poolable) {
            ((Poolable) obj).reset();
        }
    }

    public void freeAll(List<? extends T> list) {
        if (list == null) {
            throw new IllegalArgumentException("object cannot be null.".toString());
        }
        ArrayDeque<T> arrayDeque = this.freeObjects;
        int i = this.max;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            T t = list.get(i2);
            if (t != null) {
                if (arrayDeque.size() < i) {
                    arrayDeque.add(t);
                }
                if (t instanceof Poolable) {
                    ((Poolable) t).reset();
                }
            }
        }
        this.peak = Math.max(this.peak, arrayDeque.size());
    }

    public final int getFree() {
        return this.freeObjects.size();
    }

    public T obtain() {
        if (this.freeObjects.isEmpty()) {
            return newObject();
        }
        return this.freeObjects.pop();
    }
}
