package com.nothing.os.device.bluetooth;

import android.app.Application;
import android.util.Log;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ViewModelExtKt;
import com.nothing.broadcase.ext.BluetoothDeviceExtKt;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import com.nothing.os.device.bluetooth.adapter.HeaderInfoEntity;
import com.nothing.os.device.bluetooth.adapter.NormalItemViewModel;
import com.nothing.protocol.SPPConnect;
import com.nothing.protocol.helper.SppConnectHelper;
import com.nothing.xservicecore.XDevice;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: AirPodsViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u0017\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001b"}, d2 = {"Lcom/nothing/os/device/bluetooth/AirPodsViewModel;", "Lcom/nothing/os/device/bluetooth/BluetoothDetailViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "lastXDevice", "Lcom/nothing/xservicecore/XDevice;", "getLastXDevice", "()Lcom/nothing/xservicecore/XDevice;", "setLastXDevice", "(Lcom/nothing/xservicecore/XDevice;)V", "airPodsViewModel", "Lcom/nothing/os/device/bluetooth/adapter/NormalItemViewModel;", "getAirPodsViewModel", "()Lcom/nothing/os/device/bluetooth/adapter/NormalItemViewModel;", "airPodsViewModel$delegate", "Lkotlin/Lazy;", "refresh", "", "updateConnectStatusChange", "device", "", "updateHeaderInfo", "headerInfoEntity", "Lcom/nothing/os/device/bluetooth/adapter/HeaderInfoEntity;", "xDevice", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AirPodsViewModel extends BluetoothDetailViewModel {

    /* JADX INFO: renamed from: airPodsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy airPodsViewModel;
    private XDevice lastXDevice;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AirPodsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.airPodsViewModel = LazyKt.lazy(new Function0() { // from class: com.nothing.os.device.bluetooth.AirPodsViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AirPodsViewModel.airPodsViewModel_delegate$lambda$1(this.f$0);
            }
        });
    }

    public final XDevice getLastXDevice() {
        return this.lastXDevice;
    }

    public final void setLastXDevice(XDevice xDevice) {
        this.lastXDevice = xDevice;
    }

    public final NormalItemViewModel getAirPodsViewModel() {
        return (NormalItemViewModel) this.airPodsViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NormalItemViewModel airPodsViewModel_delegate$lambda$1(AirPodsViewModel airPodsViewModel) {
        NormalItemViewModel normalItemViewModel = new NormalItemViewModel(1320);
        normalItemViewModel.getTitle().set(ViewModelExtKt.getString(airPodsViewModel, R.string.os_device_select_model));
        return normalItemViewModel;
    }

    @Override // com.nothing.os.device.bluetooth.BluetoothDetailViewModel
    public void refresh() {
        getListViewModels().clear();
        getListViewModels().add(getHeaderViewModel());
        if (!BluetoothDeviceExtKt.hasBluetoothPermission(ViewModelExtKt.getApplicationContext(this))) {
            getListViewModels().add(getPermissionViewModel());
        }
        getListViewModels().add(getUseForViewModel());
        getListViewModels().add(getAboutViewModel());
        getListViewModels().add(getBluetoothViewModel());
        getListViewModels().addAll(getProfilesViewModels());
        getListViewModels().add(getAirPodsViewModel());
        getListDataLiveData().setValue(getListViewModels());
    }

    public final void updateConnectStatusChange(String device) {
        updateHeaderInfo(this.lastXDevice, device);
    }

    @Override // com.nothing.os.device.bluetooth.BluetoothDetailViewModel
    public void updateHeaderInfo(HeaderInfoEntity headerInfoEntity) {
        super.updateHeaderInfo(headerInfoEntity);
        updateHeaderInfo(this.lastXDevice, getMacAddress());
    }

    public final void updateHeaderInfo(XDevice xDevice, String device) {
        boolean zAreEqual;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "updateHeaderInfo " + xDevice;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (xDevice != null) {
            this.lastXDevice = xDevice;
            getHeaderViewModel().getLeftCharging().set(Boolean.valueOf(xDevice.isLeftCharging()));
            getHeaderViewModel().getRightCharging().set(Boolean.valueOf(xDevice.isRightCharging()));
            getHeaderViewModel().getCaseCharging().set(Boolean.valueOf(xDevice.isCaseCharging()));
            getHeaderViewModel().getConnectEnable().set(true);
            getHeaderViewModel().getDisConnectEnable().set(true);
            if (!SppConnectHelper.INSTANCE.getInstance().isPermissions()) {
                zAreEqual = Intrinsics.areEqual((Object) getHeaderViewModel().getDefaultConnectedStatus(), (Object) true);
            } else {
                zAreEqual = SPPConnect.INSTANCE.getInstance().isClassicConnected(device != null ? BluetoothDeviceExtKt.toBluetoothDevice(device) : null);
            }
            boolean z = false;
            boolean z2 = zAreEqual && xDevice.getLeftBattery() > 0 && xDevice.getLeftImage() != null;
            getHeaderViewModel().getLeftBatteryVisible().set(Boolean.valueOf(z2));
            getHeaderViewModel().getLeftVisible().set(Boolean.valueOf(z2));
            Triple<String, String, String> tripleBatterInfo = batterInfo(Integer.valueOf(xDevice.getLeftBattery()), Integer.valueOf(xDevice.getCaseBattery()), Integer.valueOf(xDevice.getRightBattery()));
            if (z2) {
                getHeaderViewModel().getLeftBattery().set(tripleBatterInfo.getFirst());
                getHeaderViewModel().getLeftLevel().set(xDevice.getLeftBattery());
            }
            boolean z3 = zAreEqual && xDevice.getCaseBattery() > 0;
            getHeaderViewModel().getCaseVisible().set(true);
            if (z3) {
                getHeaderViewModel().getCaseBatteryVisible().set(true);
                getHeaderViewModel().getCaseBattery().set(tripleBatterInfo.getSecond());
                getHeaderViewModel().getCaseLevel().set(xDevice.getCaseBattery());
            } else if (!zAreEqual) {
                getHeaderViewModel().getCaseBatteryVisible().set(false);
            }
            if (zAreEqual && xDevice.getRightBattery() > 0 && xDevice.getRightImage() != null) {
                z = true;
            }
            getHeaderViewModel().getRightBatteryVisible().set(Boolean.valueOf(z));
            getHeaderViewModel().getRightVisible().set(Boolean.valueOf(z));
            if (z) {
                getHeaderViewModel().getRightBattery().set(tripleBatterInfo.getThird());
                getHeaderViewModel().getRightLevel().set(xDevice.getRightBattery());
            }
            getHeaderViewModel().getConnectVisible().set(Boolean.valueOf(!zAreEqual));
            getHeaderViewModel().getDisConnectVisible().set(Boolean.valueOf(zAreEqual));
            getHeaderViewModel().getCaseTextVisible().set(Boolean.valueOf(zAreEqual));
            if (!Intrinsics.areEqual(getHeaderViewModel().getLeftImageUri().get(), xDevice.getLeftImage())) {
                getHeaderViewModel().getLeftImageUri().set(xDevice.getLeftImage());
            }
            if (!Intrinsics.areEqual(getHeaderViewModel().getRightImageUri().get(), xDevice.getRightImage())) {
                getHeaderViewModel().getRightImageUri().set(xDevice.getRightImage());
            }
            if (zAreEqual) {
                if (!Intrinsics.areEqual(getHeaderViewModel().getCaseUri().get(), xDevice.getBoxImage())) {
                    getHeaderViewModel().getCaseUri().set(xDevice.getBoxImage());
                }
            } else if (!Intrinsics.areEqual(getHeaderViewModel().getCaseUri().get(), xDevice.getGlobalSmallImage())) {
                getHeaderViewModel().getCaseUri().set(xDevice.getGlobalSmallImage());
            }
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "classicConnected " + zAreEqual + " hasRightBattery " + z + " hasCaseBattery " + z3 + " hasLeftBattery" + z2;
                String str5 = str4;
                if (str5 == null || str5.length() == 0) {
                    return;
                }
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                }
            }
        }
    }
}
