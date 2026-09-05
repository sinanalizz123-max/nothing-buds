package com.nothing.corsola.core.device;

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

/* JADX INFO: compiled from: IOTEarCorsolaGestureAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/corsola/core/device/IOTEarCorsolaGestureAction;", "Lcom/nothing/device/IOTDeviceGestureAction;", "<init>", "()V", "createGestureList", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTEarCorsolaGestureAction extends IOTDeviceGestureAction {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public IOTEarCorsolaGestureAction() {
        createGestureList();
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0075  */
    @Override // com.nothing.device.IOTDeviceGestureAction
    public void createGestureList() {
        char c;
        GesturesItem gesturesItem;
        GesturesItem gesturesItem2;
        GesturesItem gesturesItem3;
        GesturesItem gesturesItem4 = new GesturesItem(2, R.string.control_double_tap, "lottie/corsola_double_tap_left.json", "lottie/corsola_double_tap_right.json", R.drawable.control_ic_index_two, R.drawable.control_ic_index_two_sub);
        GesturesItem gesturesItem5 = new GesturesItem(3, R.string.control_triple_tap, "lottie/corsola_triple_tap_left.json", "lottie/corsola_triple_tap_right.json", R.drawable.control_ic_index_three, R.drawable.control_ic_index_three_sub);
        GesturesItem gesturesItem6 = new GesturesItem(7, R.string.control_tap_hold, "lottie/corsola_tap_hold_left.json", "lottie/corsola_tap_hold_right.json", R.drawable.control_ic_index_tap_hold, R.drawable.control_ic_index_tap_hold);
        GesturesItem gesturesItem7 = new GesturesItem(8, R.string.double_tap_hole, "lottie/corsola_double_tap_hold_left.json", "lottie/corsola_double_tap_hold_right.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub);
        GesturesItem gesturesItem8 = new GesturesItem(9, R.string.double_tap_hole, "lottie/corsola_double_tap_hold_left.json", "lottie/corsola_double_tap_hold_right.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub);
        GesturesItem gesturesItem9 = new GesturesItem(0, R.string.control_slide_on_system, "", "", R.drawable.control_ic_slide_on_system, R.drawable.control_ic_slide_on_system);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "corsola gesture init gesture action gesture size:" + getGesturesList().size();
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                gesturesItem3 = gesturesItem4;
                gesturesItem2 = gesturesItem5;
                gesturesItem = gesturesItem6;
                c = 1;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                c = 1;
                gesturesItem = gesturesItem6;
                gesturesItem2 = gesturesItem5;
                gesturesItem3 = gesturesItem4;
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            gesturesItem3 = gesturesItem4;
            gesturesItem2 = gesturesItem5;
            gesturesItem = gesturesItem6;
            c = 1;
        }
        ArrayList<GesturesItem> gesturesList = getGesturesList();
        GesturesItem[] gesturesItemArr = new GesturesItem[6];
        gesturesItemArr[0] = gesturesItem3;
        gesturesItemArr[c] = gesturesItem2;
        gesturesItemArr[2] = gesturesItem;
        gesturesItemArr[3] = gesturesItem7;
        gesturesItemArr[4] = gesturesItem8;
        gesturesItemArr[5] = gesturesItem9;
        gesturesList.addAll(CollectionsKt.arrayListOf(gesturesItemArr));
    }

    /* JADX INFO: compiled from: IOTEarCorsolaGestureAction.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/corsola/core/device/IOTEarCorsolaGestureAction$Companion;", "", "<init>", "()V", "createOrangeGesture", "", "Lcom/nothing/device/GesturesItem;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<GesturesItem> createOrangeGesture() {
            return CollectionsKt.arrayListOf(new GesturesItem(2, R.string.control_double_tap, "lottie/corsola_orange_double_tap_left.json", "lottie/corsola_orange_double_tap_right.json", R.drawable.control_ic_index_two, R.drawable.control_ic_index_two_sub), new GesturesItem(3, R.string.control_triple_tap, "lottie/corsola_orange_triple_tap_left.json", "lottie/corsola_orange_triple_tap_right.json", R.drawable.control_ic_index_three, R.drawable.control_ic_index_three_sub), new GesturesItem(7, R.string.control_tap_hold, "lottie/corsola_orange_tap_hold_left.json", "lottie/corsola_orange_tap_hold_right.json", R.drawable.control_ic_index_tap_hold, R.drawable.control_ic_index_tap_hold), new GesturesItem(8, R.string.double_tap_hole, "lottie/corsola_orange_double_tap_hold_left.json", "lottie/corsola_orange_double_tap_hold_right.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub), new GesturesItem(9, R.string.double_tap_hole, "lottie/corsola_orange_double_tap_hold_left.json", "lottie/corsola_orange_double_tap_hold_right.json", R.drawable.control_ic_index_double_tap_hold, R.drawable.control_ic_index_double_tap_hold_sub), new GesturesItem(0, R.string.control_slide_on_system, "", "", R.drawable.control_ic_slide_on_system, R.drawable.control_ic_slide_on_system));
        }
    }
}
