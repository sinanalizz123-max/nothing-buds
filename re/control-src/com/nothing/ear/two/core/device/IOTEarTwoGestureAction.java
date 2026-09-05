package com.nothing.ear.two.core.device;

import com.nothing.device.GesturesItem;
import com.nothing.device.IOTDeviceGestureAction;
import com.nothing.ear.R;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: compiled from: IOTEarTwoGestureAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/nothing/ear/two/core/device/IOTEarTwoGestureAction;", "Lcom/nothing/device/IOTDeviceGestureAction;", "<init>", "()V", "createGestureList", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTEarTwoGestureAction extends IOTDeviceGestureAction {
    public IOTEarTwoGestureAction() {
        createGestureList();
    }

    @Override // com.nothing.device.IOTDeviceGestureAction
    public void createGestureList() {
        getGesturesList().addAll(CollectionsKt.arrayListOf(new GesturesItem(1, R.string.control_single_press, "", "", R.drawable.control_ic_index_one, R.drawable.control_ic_index_one), new GesturesItem(2, R.string.control_double_press, "lottie/ear_two_double_pinch_left.json", "lottie/ear_two_double_pinch_right.json", R.drawable.control_ic_index_two, R.drawable.control_ic_index_two_sub), new GesturesItem(3, R.string.control_triple_press, "lottie/ear_two_triple_pinch_left.json", "lottie/ear_two_triple_pinch_right.json", R.drawable.control_ic_index_three, R.drawable.control_ic_index_three_sub), new GesturesItem(7, R.string.control_press_hold, "lottie/ear_two_pinch_hold_left.json", "lottie/ear_two_pinch_hold_right.json", R.drawable.control_ic_index_tap_hold, R.drawable.control_ic_index_tap_hold_sub), new GesturesItem(9, R.string.control_double_press_hold, "lottie/ear_two_double_pinch_hold_left.json", "lottie/ear_two_double_pinch_hold_right.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub)));
    }
}
