package com.nothing.donphan.core.device;

import android.util.Log;
import com.nothing.base.router.device.DeviceColor;
import com.nothing.base.util.Logger;
import com.nothing.device.GesturesItem;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: IOTDonphanOrange.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/nothing/donphan/core/device/IOTDonphanOrange;", "Lcom/nothing/donphan/core/device/IOTDonphan;", "<init>", "()V", "addAllGesturesItem", "", "gestures", "", "Lcom/nothing/device/GesturesItem;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTDonphanOrange extends IOTDonphan {
    public IOTDonphanOrange() {
        super(DeviceColor.ORANGE, IOTProductDeviceDonphan.EAR_ORANGE_ID, "B168");
        setDeviceNameAllUpCase(true);
        setLeftImage(R.drawable.donphan_orange_left);
        setRightImage(R.drawable.donphan_orange_right);
        setOsLeftImage(R.drawable.os_donphan_orange_left);
        setOsRightImage(R.drawable.os_donphan_orange_right);
        setOsDisconnectedImage(R.drawable.os_donphan_orange_disconnect);
        setGuideLottieJson("lottie/donphan_onboarding_orange.json");
        setPageData(new IOTEarDonphanPageData(this));
    }

    @Override // com.nothing.device.IOTDevice
    public void addAllGesturesItem(List<GesturesItem> gestures) {
        Intrinsics.checkNotNullParameter(gestures, "gestures");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "corsola gesture addAllGesturesItem".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "corsola gesture addAllGesturesItem " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "corsola gesture addAllGesturesItem " + strComponent2);
            }
        }
        getGestureList().addAll(IOTEarDonphanGestureAction.INSTANCE.createOrangeGestureList());
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str2 = "corsola gesture addAllGesturesItem gestureList size:" + getGestureList().size();
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                return;
            }
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str4 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
            }
        }
    }
}
