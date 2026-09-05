package com.nothing.protocol;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.BtWidgetRefreshGate;
import com.nothing.base.util.Logger;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.broadcase.callback.BluetoothConnectInterface;
import com.nothing.broadcase.ext.BluetoothDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.helper.SppConnectHelper;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: SPPConnect.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000?\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\r\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\t\b\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0014\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018H\u0002J\u0006\u0010\u001d\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000e\u00a8\u0006 "}, d2 = {"Lcom/nothing/protocol/SPPConnect;", "", "<init>", "()V", "coroutineIO", "Lkotlinx/coroutines/CoroutineScope;", "deleteAction", "Lkotlin/Function1;", "", "", "registerBroadcast", "action", "bluetoothConnectInterface", "com/nothing/protocol/SPPConnect$bluetoothConnectInterface$1", "Lcom/nothing/protocol/SPPConnect$bluetoothConnectInterface$1;", "isClassicConnected", "", "device", "Landroid/bluetooth/BluetoothDevice;", "isBondDevice", "isA2dpConnected", "getBluetoothDevice", "address", "findDevice", "Lcom/nothing/protocol/device/TWSDevice;", "deviceAddress", "removeBond", "removeDevice", "twsDevice", "release", "Companion", "Provider", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SPPConnect {
    public static final long CONNECT_DELAY = 300;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static SPPConnect instance = Provider.INSTANCE.getHolder();
    private final SPPConnect$bluetoothConnectInterface$1 bluetoothConnectInterface;
    private final CoroutineScope coroutineIO = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    private Function1<? super String, Unit> deleteAction;

    public static final SPPConnect getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX INFO: compiled from: SPPConnect.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058\u0006@BX\u0087\u000e\u00a2\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/nothing/protocol/SPPConnect$Companion;", "", "<init>", "()V", "value", "Lcom/nothing/protocol/SPPConnect;", "instance", "getInstance$annotations", "getInstance", "()Lcom/nothing/protocol/SPPConnect;", "CONNECT_DELAY", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        private Companion() {
        }

        public final SPPConnect getInstance() {
            return SPPConnect.instance;
        }
    }

    /* JADX INFO: compiled from: SPPConnect.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/protocol/SPPConnect$Provider;", "", "<init>", "()V", "holder", "Lcom/nothing/protocol/SPPConnect;", "getHolder", "()Lcom/nothing/protocol/SPPConnect;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Provider {
        public static final Provider INSTANCE = new Provider();
        private static final SPPConnect holder = new SPPConnect();

        private Provider() {
        }

        public final SPPConnect getHolder() {
            return holder;
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.nothing.protocol.SPPConnect$bluetoothConnectInterface$1] */
    public SPPConnect() {
        ?? r0 = new BluetoothConnectInterface() { // from class: com.nothing.protocol.SPPConnect$bluetoothConnectInterface$1
            @Override // com.nothing.broadcase.callback.BluetoothConnectInterface
            public void onConnectStateChanged(BluetoothDevice device, int state, int preState) {
                Intrinsics.checkNotNullParameter(device, "device");
            }

            @Override // com.nothing.broadcase.callback.BluetoothConnectInterface
            public void onNewDevice(BluetoothDevice device) {
                Intrinsics.checkNotNullParameter(device, "device");
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "Add new equipment SpUtils select mac:" + SpUtils.INSTANCE.getSelectDeviceMac();
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                com.nothing.link.bluetooth.sdk.util.Logger logger2 = com.nothing.link.bluetooth.sdk.util.Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true) && "Add new equipment".length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 3, str4, tag2, "Add new equipment " + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, "Add new equipment " + strComponent4);
                    }
                }
            }

            @Override // com.nothing.broadcase.callback.BluetoothConnectInterface
            public void onDeleteDevice(BluetoothDevice device) {
                Intrinsics.checkNotNullParameter(device, "device");
                SPPConnect companion = SPPConnect.INSTANCE.getInstance();
                String address = device.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                SPPConnect.INSTANCE.getInstance().removeDevice(companion.findDevice(address));
                Function1 function1 = this.this$0.deleteAction;
                if (function1 != null) {
                    String address2 = device.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
                    function1.invoke(address2);
                }
            }

            @Override // com.nothing.broadcase.callback.BluetoothConnectInterface
            public void onBluetoothOpened() {
                com.nothing.link.bluetooth.sdk.util.Logger logger = com.nothing.link.bluetooth.sdk.util.Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "Turn on the bluetooth switch".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "Turn on the bluetooth switch " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "Turn on the bluetooth switch " + strComponent2);
                    }
                }
                SppConnectHelper.INSTANCE.getInstance().openBluetooth();
                Application application = AppGlobals.INSTANCE.get();
                Intrinsics.checkNotNull(application);
                BtWidgetRefreshGate.requestFreshWidget(application, "SPPConnect.onBluetoothOpened");
            }

            @Override // com.nothing.broadcase.callback.BluetoothConnectInterface
            public void onBluetoothClosed() {
                com.nothing.link.bluetooth.sdk.util.Logger logger = com.nothing.link.bluetooth.sdk.util.Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "Turn off the bluetooth switch".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "Turn off the bluetooth switch " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "Turn off the bluetooth switch " + strComponent2);
                    }
                }
                SppConnectHelper.INSTANCE.getInstance().closeBluetooth();
                Application application = AppGlobals.INSTANCE.get();
                Intrinsics.checkNotNull(application);
                BtWidgetRefreshGate.requestFreshWidget(application, "SPPConnect.onBluetoothClosed");
            }
        };
        this.bluetoothConnectInterface = r0;
        BluetoothBroadcast.INSTANCE.getInstance().register((BluetoothConnectInterface) r0);
    }

    public final void registerBroadcast(Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.deleteAction = action;
    }

    public final boolean isClassicConnected(BluetoothDevice device) {
        String address;
        if (device == null || (address = device.getAddress()) == null || address.length() == 0) {
            return false;
        }
        return BluetoothBroadcast.INSTANCE.getInstance().isClassicConnected(device);
    }

    public final boolean isBondDevice(BluetoothDevice device) {
        String address;
        if (device == null || (address = device.getAddress()) == null || address.length() == 0 || !BluetoothBroadcast.INSTANCE.getInstance().hasPermission()) {
            return false;
        }
        return BluetoothDeviceExtKt.isBondedState(device);
    }

    public final boolean isA2dpConnected(BluetoothDevice device) {
        String address;
        if (device == null || (address = device.getAddress()) == null || address.length() == 0) {
            return false;
        }
        return BluetoothBroadcast.INSTANCE.getInstance().isA2dpConnected(device);
    }

    public final BluetoothDevice getBluetoothDevice(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return BluetoothBroadcast.INSTANCE.getInstance().getBluetoothDevice(address);
    }

    public final TWSDevice findDevice(String deviceAddress) {
        Intrinsics.checkNotNullParameter(deviceAddress, "deviceAddress");
        return SppConnectHelper.INSTANCE.getInstance().obtainDevice(deviceAddress);
    }

    public final boolean removeBond(BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        String address = device.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        removeDevice(findDevice(address));
        return BluetoothBroadcast.INSTANCE.getInstance().removeBond(device);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeDevice(TWSDevice twsDevice) {
        SppConnectHelper.INSTANCE.getInstance().removeDevice(twsDevice);
    }

    public final void release() {
        this.deleteAction = null;
    }
}
