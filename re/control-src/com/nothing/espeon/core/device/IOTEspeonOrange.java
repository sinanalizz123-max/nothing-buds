package com.nothing.espeon.core.device;

import com.nothing.base.router.device.DeviceColor;
import com.nothing.device.GesturesItem;
import com.nothing.ear.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IOTEspeonOrange.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/nothing/espeon/core/device/IOTEspeonOrange;", "Lcom/nothing/espeon/core/device/IOTEspeon;", "<init>", "()V", "addAllGesturesItem", "", "gestures", "", "Lcom/nothing/device/GesturesItem;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTEspeonOrange extends IOTEspeon {
    public IOTEspeonOrange() {
        super(DeviceColor.ORANGE, IOTProductDeviceEspeon.EAR_ORANGE_ID, "B172");
        setDeviceNameAllUpCase(true);
        setLeftImage(R.drawable.espeon_orange_left);
        setRightImage(R.drawable.espeon_orange_right);
        setCaseImage(R.drawable.os_espeon_orange_case);
        setOsLeftImage(R.drawable.os_espeon_orange_left);
        setOsRightImage(R.drawable.os_espeon_orange_right);
        setOsDisconnectedImage(R.drawable.os_espeon_orange_disconnect);
        setGuideLottieJson("lottie/espeon_white_onboarding.json");
        setPageData(new IOTEarEspeonPageData(this));
    }

    @Override // com.nothing.device.IOTDevice
    public void addAllGesturesItem(List<GesturesItem> gestures) {
        Intrinsics.checkNotNullParameter(gestures, "gestures");
        getGestureList().addAll(IOTEarEspeonGestureAction.INSTANCE.createOrangeGesture());
    }
}
