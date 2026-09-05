package com.nothing.device;

import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: compiled from: IOTDeviceGestureAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/nothing/device/IOTDeviceGestureAction;", "", "<init>", "()V", "gesturesList", "Ljava/util/ArrayList;", "Lcom/nothing/device/GesturesItem;", "Lkotlin/collections/ArrayList;", "getGesturesList", "()Ljava/util/ArrayList;", "createGestureList", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IOTDeviceGestureAction {
    private final ArrayList<GesturesItem> gesturesList = new ArrayList<>();

    public void createGestureList() {
    }

    public final ArrayList<GesturesItem> getGesturesList() {
        return this.gesturesList;
    }
}
