package com.nothing.link.bluetooth.sdk.device;

import androidx.collection.LruCache;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LruCacheImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ6\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\b\u00028\u00002\b\u0010\u000e\u001a\u0004\b\u00028\u00012\b\u0010\u000f\u001a\u0004\u0018\u00018\u0001H\u0014\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b9\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/device/LruCacheImpl;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Landroidx/collection/LruCache;", "maxSize", "", "removeAction", "Lkotlin/Function1;", "", "(ILkotlin/jvm/functions/Function1;)V", "entryRemoved", "evicted", "", "key", "oldValue", "newValue", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LruCacheImpl<T, R> extends LruCache<T, R> {
    private final Function1<R, Unit> removeAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public LruCacheImpl(int i, Function1<? super R, Unit> removeAction) {
        super(i);
        Intrinsics.checkNotNullParameter(removeAction, "removeAction");
        this.removeAction = removeAction;
    }

    @Override // androidx.collection.LruCache
    protected void entryRemoved(boolean evicted, T key, R oldValue, R newValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        super.entryRemoved(evicted, key, oldValue, newValue);
        this.removeAction.invoke(oldValue);
    }
}
