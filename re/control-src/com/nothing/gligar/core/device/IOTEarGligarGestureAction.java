package com.nothing.gligar.core.device;

import android.util.Log;
import com.nothing.base.util.Logger;
import com.nothing.device.GesturesItem;
import com.nothing.device.IOTDeviceGestureAction;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: IOTEarGligarGestureAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/gligar/core/device/IOTEarGligarGestureAction;", "Lcom/nothing/device/IOTDeviceGestureAction;", "<init>", "()V", "createGestureList", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTEarGligarGestureAction extends IOTDeviceGestureAction {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ArrayList<GesturesItem> caseGestures = CollectionsKt.arrayListOf(new GesturesItem(1, R.string.single_press, "lottie/gligar_single_case.json", "lottie/gligar_single_case.json", R.drawable.control_ic_index_one, R.drawable.control_ic_index_one), new GesturesItem(2, R.string.double_press, "lottie/gligar_double_case.json", "lottie/gligar_double_case.json", R.drawable.control_ic_index_two, R.drawable.control_ic_index_two_sub), new GesturesItem(3, R.string.triple_press, "lottie/gligar_triple_case.json", "lottie/gligar_triple_case.json", R.drawable.control_ic_index_three, R.drawable.control_ic_index_three_sub), new GesturesItem(7, R.string.press_hold, "lottie/gligar_press_hold_case.json", "lottie/gligar_press_hold_case.json", R.drawable.control_ic_index_tap_hold, R.drawable.control_ic_index_tap_hold), new GesturesItem(10, R.string.rotate, "lottie/gligar_rotate_case.json", "lottie/gligar_rotate_case.json", R.drawable.control_ic_rotate, R.drawable.control_ic_rotate), new GesturesItem(15, R.string.double_press_hold, "", "", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold));

    public IOTEarGligarGestureAction() {
        createGestureList();
    }

    /* JADX INFO: compiled from: IOTEarGligarGestureAction.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bR!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/nothing/gligar/core/device/IOTEarGligarGestureAction$Companion;", "", "<init>", "()V", "caseGestures", "Ljava/util/ArrayList;", "Lcom/nothing/device/GesturesItem;", "Lkotlin/collections/ArrayList;", "getCaseGestures", "()Ljava/util/ArrayList;", "createOrangeGesture", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArrayList<GesturesItem> getCaseGestures() {
            return IOTEarGligarGestureAction.caseGestures;
        }

        public final List<GesturesItem> createOrangeGesture() {
            return CollectionsKt.arrayListOf(new GesturesItem(2, R.string.control_double_tap, "lottie/gligar_double_left.json", "lottie/gligar_double_right.json", R.drawable.control_ic_index_two, R.drawable.control_ic_index_two_sub), new GesturesItem(3, R.string.control_triple_tap, "lottie/gligar_triple_tap_left.json", "lottie/gligar_triple_tap_right.json", R.drawable.control_ic_index_three, R.drawable.control_ic_index_three_sub), new GesturesItem(7, R.string.control_tap_hold, "lottie/gligar_tap_hold_left.json", "lottie/gligar_tap_hold_right.json", R.drawable.control_ic_index_tap_hold, R.drawable.control_ic_index_tap_hold), new GesturesItem(8, R.string.double_tap_hole, "lottie/gligar_double_hold_left.json", "lottie/gligar_double_hold_right.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub), new GesturesItem(9, R.string.double_tap_hole, "lottie/gligar_double_hold_left.json", "lottie/gligar_double_hold_right.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub), new GesturesItem(0, R.string.control_slide_on_system, "", "", R.drawable.control_ic_slide_on_system, R.drawable.control_ic_slide_on_system), new GesturesItem(15, R.string.double_press_hold, "", "", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold));
        }
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0086  */
    @Override // com.nothing.device.IOTDeviceGestureAction
    public void createGestureList() {
        GesturesItem gesturesItem;
        GesturesItem gesturesItem2;
        GesturesItem gesturesItem3;
        GesturesItem gesturesItem4;
        char c;
        GesturesItem gesturesItem5 = new GesturesItem(2, R.string.control_double_tap, "lottie/gligar_double_left_red.json", "lottie/gligar_double_right_red.json", R.drawable.control_ic_index_two, R.drawable.control_ic_index_two_sub);
        GesturesItem gesturesItem6 = new GesturesItem(3, R.string.control_triple_tap, "lottie/gligar_triple_tap_left_red.json", "lottie/gligar_triple_tap_right_red.json", R.drawable.control_ic_index_three, R.drawable.control_ic_index_three_sub);
        GesturesItem gesturesItem7 = new GesturesItem(7, R.string.control_tap_hold, "lottie/gligar_tap_hold_left_red.json", "lottie/gligar_tap_hold_right_red.json", R.drawable.control_ic_index_tap_hold, R.drawable.control_ic_index_tap_hold);
        GesturesItem gesturesItem8 = new GesturesItem(8, R.string.double_tap_hole, "lottie/gligar_double_hold_left_red.json", "lottie/gligar_double_hold_right_red.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub);
        GesturesItem gesturesItem9 = new GesturesItem(9, R.string.double_tap_hole, "lottie/gligar_double_hold_left_red.json", "lottie/gligar_double_hold_right_red.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub);
        GesturesItem gesturesItem10 = new GesturesItem(0, R.string.control_slide_on_system, "", "", R.drawable.control_ic_slide_on_system, R.drawable.control_ic_slide_on_system);
        GesturesItem gesturesItem11 = new GesturesItem(15, R.string.double_press_hold, "", "", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "corsola gesture init gesture action gesture size:" + getGesturesList().size();
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                gesturesItem = gesturesItem5;
                gesturesItem2 = gesturesItem6;
                gesturesItem3 = gesturesItem7;
                gesturesItem4 = gesturesItem8;
                c = 1;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                gesturesItem = gesturesItem5;
                gesturesItem2 = gesturesItem6;
                gesturesItem3 = gesturesItem7;
                gesturesItem4 = gesturesItem8;
                c = 1;
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            gesturesItem = gesturesItem5;
            gesturesItem2 = gesturesItem6;
            gesturesItem3 = gesturesItem7;
            gesturesItem4 = gesturesItem8;
            c = 1;
        }
        ArrayList<GesturesItem> gesturesList = getGesturesList();
        GesturesItem[] gesturesItemArr = new GesturesItem[7];
        gesturesItemArr[0] = gesturesItem;
        gesturesItemArr[c] = gesturesItem2;
        gesturesItemArr[2] = gesturesItem3;
        gesturesItemArr[3] = gesturesItem4;
        gesturesItemArr[4] = gesturesItem9;
        gesturesItemArr[5] = gesturesItem10;
        gesturesItemArr[6] = gesturesItem11;
        gesturesList.addAll(CollectionsKt.arrayListOf(gesturesItemArr));
    }
}
