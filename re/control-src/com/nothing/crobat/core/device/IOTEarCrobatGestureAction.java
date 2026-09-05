package com.nothing.crobat.core.device;

import android.util.Log;
import com.nothing.base.util.Logger;
import com.nothing.device.GesturesItem;
import com.nothing.device.IOTDeviceGestureAction;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: IOTEarCrobatGestureAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/nothing/crobat/core/device/IOTEarCrobatGestureAction;", "Lcom/nothing/device/IOTDeviceGestureAction;", "<init>", "()V", "createGestureList", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTEarCrobatGestureAction extends IOTDeviceGestureAction {
    public IOTEarCrobatGestureAction() {
        createGestureList();
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0086  */
    @Override // com.nothing.device.IOTDeviceGestureAction
    public void createGestureList() {
        GesturesItem gesturesItem;
        GesturesItem gesturesItem2;
        GesturesItem gesturesItem3;
        GesturesItem gesturesItem4;
        char c;
        GesturesItem gesturesItem5 = new GesturesItem(2, R.string.double_press, "lottie/crobat_controls_doublepress_dot.json", "lottie/crobat_controls_doublepress_dot.json", R.drawable.control_ic_index_two, R.drawable.control_ic_index_two_sub);
        GesturesItem gesturesItem6 = new GesturesItem(3, R.string.triple_press, "lottie/crobat_control_triplepress_dot.json", "lottie/crobat_control_triplepress_dot.json", R.drawable.control_ic_index_three, R.drawable.control_ic_index_three_sub);
        GesturesItem gesturesItem7 = new GesturesItem(1, R.string.single_press, "", "", R.drawable.control_ic_index_one, R.drawable.control_ic_index_one);
        GesturesItem gesturesItem8 = new GesturesItem(10, R.string.rotate, "", "", R.drawable.control_ic_rotate, R.drawable.control_ic_rotate);
        GesturesItem gesturesItem9 = new GesturesItem(7, R.string.press_hold, "lottie/crobat_controls_pressandhold_dot.json", "lottie/crobat_controls_pressandhold_dot.json", R.drawable.control_ic_index_tap_hold, R.drawable.control_ic_index_tap_hold);
        GesturesItem gesturesItem10 = new GesturesItem(13, R.string.double_press, "", "", R.drawable.control_ic_index_two, R.drawable.control_ic_index_two_sub);
        GesturesItem gesturesItem11 = new GesturesItem(14, R.string.press_hold, "", "", R.drawable.control_ic_index_tap_hold, R.drawable.control_ic_index_tap_hold);
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
