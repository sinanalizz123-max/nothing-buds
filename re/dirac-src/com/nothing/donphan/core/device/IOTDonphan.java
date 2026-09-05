package com.nothing.donphan.core.device;

import com.nothing.base.router.device.DeviceColor;
import com.nothing.device.IOTDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: IOTDonphan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/donphan/core/device/IOTDonphan;", "Lcom/nothing/device/IOTDevice;", "color", "Lcom/nothing/base/router/device/DeviceColor;", "modelId", "", "productId", "<init>", "(Lcom/nothing/base/router/device/DeviceColor;Ljava/lang/String;Ljava/lang/String;)V", "isSupportDual", "", "getANCLevel", "", "address", "isBassBoost", "isCmfText", "isSupportEqualizer", "isSupportDirac", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class IOTDonphan extends IOTDevice {
    @Override // com.nothing.device.IOTDevice
    public int getANCLevel(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return 5;
    }

    @Override // com.nothing.device.IOTDevice
    public boolean isBassBoost() {
        return true;
    }

    @Override // com.nothing.device.IOTDevice
    public boolean isCmfText() {
        return true;
    }

    @Override // com.nothing.device.IOTDevice
    public boolean isSupportDirac() {
        return true;
    }

    @Override // com.nothing.device.IOTDevice
    public boolean isSupportDual() {
        return true;
    }

    @Override // com.nothing.device.IOTDevice
    public boolean isSupportEqualizer() {
        return false;
    }

    public /* synthetic */ IOTDonphan(DeviceColor deviceColor, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(deviceColor, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IOTDonphan(DeviceColor color, String modelId, String productId) {
        super(color, modelId, productId);
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(productId, "productId");
    }
}
