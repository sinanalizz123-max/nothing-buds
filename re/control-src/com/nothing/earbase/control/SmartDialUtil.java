package com.nothing.earbase.control;

import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.protocol.device.TWSDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SmartDialUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\n"}, d2 = {"Lcom/nothing/earbase/control/SmartDialUtil;", "", "<init>", "()V", "checkSmartDial", "", "address", "", "markShowSmartDial", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SmartDialUtil {
    public static final SmartDialUtil INSTANCE = new SmartDialUtil();

    private SmartDialUtil() {
    }

    public final boolean checkSmartDial(String address) {
        TWSDevice twsDevice;
        Intrinsics.checkNotNullParameter(address, "address");
        List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(address);
        DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
        if (deviceItem2 != null && !deviceItem2.getSmartDialTips()) {
            IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(address);
            if (productByMacAddress != null && !productByMacAddress.supportSmartDial()) {
                deviceItem2.setSmartDialTips(true);
                DatabaseUtils.INSTANCE.getDeviceDao().updateDeviceItem(deviceItem2);
                return false;
            }
            IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
            if (iOTDeviceByMacAddress != null && (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) != null && twsDevice.isConnected()) {
                return true;
            }
        }
        return false;
    }

    public final void markShowSmartDial(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(address);
        DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
        if (deviceItem2 != null) {
            deviceItem2.setSmartDialTips(true);
            DatabaseUtils.INSTANCE.getDeviceDao().updateDeviceItem(deviceItem2);
        }
    }
}
