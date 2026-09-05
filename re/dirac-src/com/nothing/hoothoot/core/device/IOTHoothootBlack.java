package com.nothing.hoothoot.core.device;

import com.nothing.base.router.device.DeviceColor;
import com.nothing.donphan.core.device.IOTDonphan;
import com.nothing.donphan.core.device.IOTEarDonphanPageData;
import com.nothing.ear.R;
import kotlin.Metadata;

/* JADX INFO: compiled from: IOTHoothootBlack.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/nothing/hoothoot/core/device/IOTHoothootBlack;", "Lcom/nothing/donphan/core/device/IOTDonphan;", "<init>", "()V", "isSupportInEarDetect", "", "isSupportDirac", "isSupportNews", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTHoothootBlack extends IOTDonphan {
    @Override // com.nothing.donphan.core.device.IOTDonphan, com.nothing.device.IOTDevice
    public boolean isSupportDirac() {
        return false;
    }

    @Override // com.nothing.device.IOTDevice
    public boolean isSupportInEarDetect() {
        return false;
    }

    @Override // com.nothing.device.IOTDevice
    public boolean isSupportNews() {
        return true;
    }

    public IOTHoothootBlack() {
        super(DeviceColor.BLACK, IOTProductDeviceHoothoot.EAR_ID, IOTProductDeviceHoothoot.PRODUCT_ID);
        setDeviceNameAllUpCase(true);
        setLeftImage(R.drawable.hoothoot_black_left);
        setRightImage(R.drawable.hoothoot_black_right);
        setOsLeftImage(R.drawable.hoothoot_black_left);
        setOsRightImage(R.drawable.hoothoot_black_right);
        setOsDisconnectedImage(R.drawable.hoothoot_black_disconnect);
        setGuideLottieJson("lottie/donphan_onboarding_white.json");
        setPageData(new IOTEarDonphanPageData(this));
    }
}
