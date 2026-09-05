package com.nothing.protocol.helper;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.os.Build;
import com.nothing.base.util.AppGlobals;
import com.nothing.link.utils.ext.ContextExtKt;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.ProtocolModel;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: compiled from: SppConnectHelper.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0002\u0019\u001aB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\r\u001a\u0004\u0018\u00010\u0007J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0013J\u0006\u0010\u0018\u001a\u00020\u0013R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/nothing/protocol/helper/SppConnectHelper;", "", "<init>", "()V", "twsDeviceCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/protocol/device/TWSDevice;", "isPermissions", "", "checkPermissions", "checkPermissionsS", "obtainDevice", "device", "Landroid/bluetooth/BluetoothDevice;", "protocolModel", "Lcom/nothing/protocol/model/ProtocolModel;", "deviceAddress", "removeDevice", "", "unRegister", "callBack", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "closeBluetooth", "openBluetooth", "Companion", "Provider", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SppConnectHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SppConnectHelper instance = Provider.INSTANCE.getHolder();
    private final ConcurrentHashMap<String, TWSDevice> twsDeviceCache = new ConcurrentHashMap<>();

    public static final SppConnectHelper getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: compiled from: SppConnectHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058\u0006@BX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/nothing/protocol/helper/SppConnectHelper$Companion;", "", "<init>", "()V", "value", "Lcom/nothing/protocol/helper/SppConnectHelper;", "instance", "getInstance$annotations", "getInstance", "()Lcom/nothing/protocol/helper/SppConnectHelper;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final SppConnectHelper getInstance() {
            return SppConnectHelper.instance;
        }
    }

    /* JADX INFO: compiled from: SppConnectHelper.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/protocol/helper/SppConnectHelper$Provider;", "", "<init>", "()V", "holder", "Lcom/nothing/protocol/helper/SppConnectHelper;", "getHolder", "()Lcom/nothing/protocol/helper/SppConnectHelper;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Provider {
        public static final Provider INSTANCE = new Provider();
        private static final SppConnectHelper holder = new SppConnectHelper();

        private Provider() {
        }

        public final SppConnectHelper getHolder() {
            return holder;
        }
    }

    public final boolean isPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return checkPermissionsS();
        }
        return checkPermissions();
    }

    private final boolean checkPermissions() {
        Application application = AppGlobals.INSTANCE.get();
        if (application != null) {
            return ContextExtKt.checkSelfPermission(application, "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION");
        }
        return false;
    }

    private final boolean checkPermissionsS() {
        Application application = AppGlobals.INSTANCE.get();
        if (application != null) {
            return ContextExtKt.checkSelfPermission(application, "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT");
        }
        return false;
    }

    public final synchronized TWSDevice obtainDevice(BluetoothDevice device, ProtocolModel protocolModel) {
        TWSDevice tWSDevice;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(protocolModel, "protocolModel");
        tWSDevice = this.twsDeviceCache.get(device.getAddress());
        if (tWSDevice == null) {
            tWSDevice = new TWSDevice(device, protocolModel);
            this.twsDeviceCache.put(device.getAddress(), tWSDevice);
        }
        return tWSDevice;
    }

    public final synchronized TWSDevice obtainDevice(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        return this.twsDeviceCache.get(deviceAddress);
    }

    public final synchronized void removeDevice(TWSDevice device) {
        if (device == null) {
            return;
        }
        device.release();
        ConcurrentHashMap<String, TWSDevice> concurrentHashMap = this.twsDeviceCache;
        TypeIntrinsics.asMutableMap(concurrentHashMap).remove(device.getAddress());
    }

    public final synchronized void unRegister(TWSDevice.Callback callBack) {
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        Iterator<Map.Entry<String, TWSDevice>> it = this.twsDeviceCache.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().unregister(callBack);
        }
    }

    public final void closeBluetooth() {
        Iterator<Map.Entry<String, TWSDevice>> it = this.twsDeviceCache.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().disconnect();
        }
    }

    public final void openBluetooth() {
        Iterator<Map.Entry<String, TWSDevice>> it = this.twsDeviceCache.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().openBluetooth();
        }
    }
}
