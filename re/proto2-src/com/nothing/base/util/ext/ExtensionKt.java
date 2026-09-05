package com.nothing.base.util.ext;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Extension.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u0012\u0012\u0004\u0012\u0002H\u00020\u0003j\b\u0012\u0004\u0012\u0002H\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\b\u001a\u001e\u0010\u0007\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b\u00a8\u0006\f"}, d2 = {"addAll", "", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "data", "", "refresh", "Landroidx/lifecycle/MutableLiveData;", "", "action", "Lkotlin/Function0;", "nt_ear_GoogleStoreRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ExtensionKt {
    public static final /* synthetic */ <T> void addAll(ArrayList<T> arrayList, Object data) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        ArrayList arrayList2 = null;
        List list = data instanceof List ? (List) data : null;
        if (list != null) {
            ArrayList arrayList3 = new ArrayList();
            for (T t : list) {
                Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
                if (t instanceof Object) {
                    arrayList3.add(t);
                }
            }
            arrayList2 = arrayList3;
        }
        ArrayList arrayList4 = arrayList2;
        if (arrayList4 == null || arrayList4.isEmpty()) {
            return;
        }
        arrayList.addAll(arrayList4);
    }

    public static final void refresh(MutableLiveData<Boolean> mutableLiveData, Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        synchronized (mutableLiveData) {
            mutableLiveData.postValue(true);
            action.invoke();
            mutableLiveData.postValue(false);
            Unit unit = Unit.INSTANCE;
        }
    }
}
