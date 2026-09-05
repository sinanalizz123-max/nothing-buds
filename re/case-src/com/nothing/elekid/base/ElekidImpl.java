package com.nothing.elekid.base;

import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.nothing.base.model.Battery;
import com.nothing.earbase.os.base.BaseNothingEarImpl;
import com.nothing.earbase.os.cache.MacCacheManager;
import com.nothing.earbase.os.cache.entity.MacCacheEntity;
import com.nothing.earbase.ota.entity.DeviceBattery;
import com.nothing.os.device.DeviceConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ElekidImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB5\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\u0011H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J$\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/nothing/elekid/base/ElekidImpl;", "Lcom/nothing/earbase/os/base/BaseNothingEarImpl;", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "modelId", "", "address", "<init>", "(Landroid/os/RemoteCallbackList;Landroid/os/Handler;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/String;)V", "getOlderFirmwareVersion", "", "action", "Lkotlin/Function1;", "getExtraFunctionList", "Landroid/os/Bundle;", "firmwareVersion", "extras", "parseBattery", "macAddress", "battery", "Lcom/nothing/earbase/ota/entity/DeviceBattery;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ElekidImpl extends BaseNothingEarImpl {
    public static final int THREE = 3;

    @Override // com.nothing.earbase.os.base.BaseNothingEar
    public Bundle getExtraFunctionList(String firmwareVersion, Bundle extras) {
        Intrinsics.checkNotNullParameter(firmwareVersion, "firmwareVersion");
        Intrinsics.checkNotNullParameter(extras, "extras");
        return null;
    }

    @Override // com.nothing.earbase.os.base.BaseNothingEarImpl
    public void getOlderFirmwareVersion(Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ElekidImpl(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String address) {
        super(callbacks, handler, coroutineScope, modelId, address);
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(address, "address");
    }

    @Override // com.nothing.earbase.os.base.BaseNothingEarImpl
    public Bundle parseBattery(String macAddress, DeviceBattery battery, String modelId) {
        Intrinsics.checkNotNullParameter(battery, "battery");
        MacCacheEntity nothingEar$default = MacCacheManager.getNothingEar$default(MacCacheManager.INSTANCE, macAddress, false, 2, null);
        int caseBattery = nothingEar$default != null ? nothingEar$default.getCaseBattery() : -1;
        if (caseBattery == -10 || caseBattery == 0) {
            caseBattery = -1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("device_address", macAddress);
        Battery left = battery.getLeft();
        int battery2 = left != null ? left.getBattery() : -1;
        Battery right = battery.getRight();
        int battery3 = right != null ? right.getBattery() : -1;
        Battery stereo = battery.getStereo();
        if (stereo != null) {
            caseBattery = stereo.getBattery();
        }
        if (caseBattery != -1 && nothingEar$default != null) {
            nothingEar$default.setCaseBattery(caseBattery);
        }
        if (battery2 != -1 && nothingEar$default != null) {
            nothingEar$default.setLeftBattery(battery2);
        }
        if (battery3 != -1 && nothingEar$default != null) {
            nothingEar$default.setRightBattery(battery3);
        }
        bundle.putInt(DeviceConstant.KEY_BATTERY_LEFT, battery2);
        bundle.putInt(DeviceConstant.KEY_BATTERY_RIGHT, battery3);
        bundle.putInt(DeviceConstant.KEY_BATTERY_CASE, caseBattery);
        MacCacheManager.INSTANCE.updateNothingEntity(nothingEar$default);
        return bundle;
    }
}
