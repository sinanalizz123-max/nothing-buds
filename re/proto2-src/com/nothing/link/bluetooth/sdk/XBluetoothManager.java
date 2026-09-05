package com.nothing.link.bluetooth.sdk;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.nothing.link.bluetooth.sdk.config.XBluetoothConfig;
import com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper;
import com.nothing.link.bluetooth.sdk.device.BoundListener;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.device.XBluetoothHashMap;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.link.bluetooth.sdk.scan.ScanFactory;
import com.nothing.link.bluetooth.sdk.scan.XScan;
import com.nothing.link.bluetooth.sdk.scan.XScanType;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBluetoothManager.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020 J\u0006\u00101\u001a\u00020 J\u000e\u00100\u001a\u00020 2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u0004\u0018\u00010%2\u0006\u00105\u001a\u00020%J\u0010\u00106\u001a\u0004\u0018\u00010%2\u0006\u00105\u001a\u00020%J\u000e\u00107\u001a\n\u0012\u0004\u0012\u000209\u0018\u000108J&\u0010:\u001a\"\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u000209\u0018\u00010\u001ej\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u000209\u0018\u0001`!J\u0006\u0010;\u001a\u00020\u001aJ\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u000209J\u000e\u0010<\u001a\u00020=2\u0006\u0010?\u001a\u00020@J\u000e\u0010<\u001a\u00020=2\u0006\u0010A\u001a\u00020%J\f\u0010B\u001a\b\u0012\u0004\u0012\u00020%0CJ\u0006\u0010D\u001a\u00020\u001aJ\u0006\u0010E\u001a\u00020\u001aJ\u0012\u0010F\u001a\u00020,2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010HJ\u0018\u0010I\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010J\u001a\u0004\u0018\u00010\bJ\u0006\u0010K\u001a\u00020.J\u0016\u0010L\u001a\u00020.2\u0006\u0010M\u001a\u00020%2\u0006\u0010N\u001a\u00020&J\u000e\u0010O\u001a\u00020 2\u0006\u0010A\u001a\u00020%J\u0010\u0010P\u001a\u00020 2\b\u0010A\u001a\u0004\u0018\u00010%J\u0006\u0010Q\u001a\u00020.J\u0006\u0010R\u001a\u00020.J\u000e\u0010S\u001a\u00020.2\u0006\u0010M\u001a\u00020%R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u001ej\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 `!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R6\u0010$\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0\u001ej\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&`!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;", "", "()V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "bluetoothConfig", "Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig;", "getBluetoothConfig", "()Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig;", "setBluetoothConfig", "(Lcom/nothing/link/bluetooth/sdk/config/XBluetoothConfig;)V", "bluetoothManager", "Landroid/bluetooth/BluetoothManager;", "getBluetoothManager", "()Landroid/bluetooth/BluetoothManager;", "setBluetoothManager", "(Landroid/bluetooth/BluetoothManager;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "defaultScope", "Lkotlinx/coroutines/CoroutineScope;", "deviceLruHashMap", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothHashMap;", "ignoreLogPrefix", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ioScope", "mainScope", "removeBoundListener", "", "Lcom/nothing/link/bluetooth/sdk/device/BoundListener;", "getRemoveBoundListener", "()Ljava/util/HashMap;", "setRemoveBoundListener", "(Ljava/util/HashMap;)V", "xScanImpl", "Lcom/nothing/link/bluetooth/sdk/scan/XScan;", "addIgnorePrefix", "", "prefix", "canWrite", "bluetoothUnEnable", "byteArray", "", "getBluetoothAlias", "realMac", "getBluetoothName", "getBoundDevice", "", "Landroid/bluetooth/BluetoothDevice;", "getConnectedDevice", "getDefaultScope", "getDevice", "Lcom/nothing/link/bluetooth/sdk/device/XConnectorDevice;", "bluetoothDevice", "bleDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "address", "getDeviceMaps", "", "getIOScope", "getMainScope", "getScan", "scanType", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "init", "config", "onDestroy", "registerBoundListener", "key", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeBound", "removeBoundNoCallback", "sppCloseSocket", "stopAndReleaseScan", "unRegisterBoundListener", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBluetoothManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<XBluetoothManager> singleInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<XBluetoothManager>() { // from class: com.nothing.link.bluetooth.sdk.XBluetoothManager$Companion$singleInstance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final XBluetoothManager invoke() {
            return new XBluetoothManager();
        }
    });
    private BluetoothManager bluetoothManager;
    private Context context;
    private XScan xScanImpl;
    private XBluetoothConfig bluetoothConfig = XBluetoothConfig.INSTANCE.getDefaultBleOptions();
    private final CoroutineScope mainScope = CoroutineScopeKt.MainScope();
    private final CoroutineScope ioScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    private final CoroutineScope defaultScope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
    private final HashMap<Integer, Boolean> ignoreLogPrefix = new HashMap<>();
    private XBluetoothHashMap deviceLruHashMap = new XBluetoothHashMap(this.bluetoothConfig.getMaxConnectNum());
    private HashMap<String, BoundListener> removeBoundListener = new HashMap<>();

    public final BluetoothManager getBluetoothManager() {
        return this.bluetoothManager;
    }

    public final void setBluetoothManager(BluetoothManager bluetoothManager) {
        this.bluetoothManager = bluetoothManager;
    }

    public final BluetoothAdapter getBluetoothAdapter() {
        if (Build.VERSION.SDK_INT >= 30) {
            BluetoothManager bluetoothManager = this.bluetoothManager;
            if (bluetoothManager != null) {
                return bluetoothManager.getAdapter();
            }
            return null;
        }
        return BluetoothAdapter.getDefaultAdapter();
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final XBluetoothConfig getBluetoothConfig() {
        return this.bluetoothConfig;
    }

    public final void setBluetoothConfig(XBluetoothConfig xBluetoothConfig) {
        Intrinsics.checkNotNullParameter(xBluetoothConfig, "<set-?>");
        this.bluetoothConfig = xBluetoothConfig;
    }

    public final CoroutineScope getMainScope() {
        return this.mainScope;
    }

    /* JADX INFO: renamed from: getIOScope, reason: from getter */
    public final CoroutineScope getIoScope() {
        return this.ioScope;
    }

    public final CoroutineScope getDefaultScope() {
        return this.defaultScope;
    }

    /* JADX INFO: compiled from: XBluetoothManager.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/XBluetoothManager$Companion;", "", "()V", "singleInstance", "Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;", "getSingleInstance", "()Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;", "singleInstance$delegate", "Lkotlin/Lazy;", "get", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final XBluetoothManager getSingleInstance() {
            return (XBluetoothManager) XBluetoothManager.singleInstance$delegate.getValue();
        }

        public final XBluetoothManager get() {
            return getSingleInstance();
        }
    }

    public final void init(Context context, XBluetoothConfig config) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        if (config == null) {
            config = XBluetoothConfig.INSTANCE.getDefaultBleOptions();
        }
        this.bluetoothConfig = config;
        Logger.initDebugFlag(context, config.getEnableLog());
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.bluetoothManager = (BluetoothManager) ContextCompat.getSystemService(applicationContext, BluetoothManager.class);
        getBluetoothAdapter();
        this.deviceLruHashMap.updateMaxSize(this.bluetoothConfig.getMaxConnectNum());
        XBTReceiverHelper.INSTANCE.get().onCreate();
        addIgnorePrefix(29, false);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "init success  " + getBluetoothAdapter();
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
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

    public final boolean bluetoothUnEnable() {
        BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        boolean z = false;
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            z = true;
        }
        return !z;
    }

    public final List<String> getDeviceMaps() {
        return this.deviceLruHashMap.getDeviceMaps();
    }

    public final Set<BluetoothDevice> getBoundDevice() {
        BluetoothAdapter bluetoothAdapter;
        if (!BleUtil.INSTANCE.checkBluetoothPermissions() || bluetoothUnEnable() || (bluetoothAdapter = getBluetoothAdapter()) == null) {
            return null;
        }
        return bluetoothAdapter.getBondedDevices();
    }

    public final HashMap<String, BoundListener> getRemoveBoundListener() {
        return this.removeBoundListener;
    }

    public final void setRemoveBoundListener(HashMap<String, BoundListener> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.removeBoundListener = map;
    }

    public final void registerBoundListener(String key, BoundListener listener) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.removeBoundListener.put(key, listener);
    }

    public final void unRegisterBoundListener(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.removeBoundListener.remove(key);
    }

    public final void addIgnorePrefix(int prefix, boolean canWrite) {
        this.ignoreLogPrefix.put(Integer.valueOf(prefix), Boolean.valueOf(canWrite));
    }

    public final boolean canWrite(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (byteArray.length == 0) {
            return true;
        }
        return Intrinsics.areEqual((Object) this.ignoreLogPrefix.get(Integer.valueOf(byteArray[0])), (Object) true);
    }

    public final boolean removeBound(String address) {
        boolean zAreEqual;
        Intrinsics.checkNotNullParameter(address, "address");
        Set<BluetoothDevice> boundDevice = getBoundDevice();
        boolean z = false;
        if (boundDevice != null) {
            loop0: while (true) {
                zAreEqual = false;
                for (BluetoothDevice bluetoothDevice : boundDevice) {
                    if (Intrinsics.areEqual(bluetoothDevice.getAddress(), address)) {
                        try {
                            Method method = bluetoothDevice.getClass().getMethod("removeBond", new Class[0]);
                            method.setAccessible(true);
                            zAreEqual = Intrinsics.areEqual(method.invoke(bluetoothDevice, new Object[0]), (Object) true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                break loop0;
            }
            z = zAreEqual;
        }
        Iterator<Map.Entry<String, BoundListener>> it = this.removeBoundListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().removeBind(address, z);
        }
        return z;
    }

    public final boolean removeBoundNoCallback(String address) {
        Set<BluetoothDevice> boundDevice = getBoundDevice();
        if (boundDevice == null) {
            return false;
        }
        while (true) {
            boolean zAreEqual = false;
            for (BluetoothDevice bluetoothDevice : boundDevice) {
                if (Intrinsics.areEqual(bluetoothDevice.getAddress(), address)) {
                    try {
                        Method method = bluetoothDevice.getClass().getMethod("removeBond", new Class[0]);
                        method.setAccessible(true);
                        zAreEqual = Intrinsics.areEqual(method.invoke(bluetoothDevice, new Object[0]), (Object) true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            return zAreEqual;
        }
    }

    public final HashMap<String, BluetoothDevice> getConnectedDevice() {
        if (BleUtil.INSTANCE.checkBluetoothPermissions() && !bluetoothUnEnable()) {
            return XBTReceiverHelper.getConnectedDevice$default(XBTReceiverHelper.INSTANCE.get(), false, 1, null);
        }
        return null;
    }

    public final String getBluetoothAlias(String realMac) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        if (!BleUtil.INSTANCE.checkBluetoothPermissions() || bluetoothUnEnable()) {
            return null;
        }
        BluetoothAdapter bluetoothAdapter = INSTANCE.get().getBluetoothAdapter();
        BluetoothDevice remoteDevice = bluetoothAdapter != null ? bluetoothAdapter.getRemoteDevice(realMac) : null;
        if (remoteDevice == null) {
            return "";
        }
        try {
            Method method = remoteDevice.getClass().getMethod("getAlias", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(remoteDevice, new Object[0]);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String getBluetoothName(String realMac) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        if (!BleUtil.INSTANCE.checkBluetoothPermissions() || bluetoothUnEnable()) {
            return null;
        }
        BluetoothAdapter bluetoothAdapter = INSTANCE.get().getBluetoothAdapter();
        BluetoothDevice remoteDevice = bluetoothAdapter != null ? bluetoothAdapter.getRemoteDevice(realMac) : null;
        if (remoteDevice == null) {
            return "";
        }
        try {
            return remoteDevice.getName();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ XScan getScan$default(XBluetoothManager xBluetoothManager, XScanType xScanType, int i, Object obj) {
        if ((i & 1) != 0) {
            xScanType = null;
        }
        return xBluetoothManager.getScan(xScanType);
    }

    public final XScan getScan(XScanType scanType) {
        XScan xScan = this.xScanImpl;
        if (xScan != null && scanType != null && !Intrinsics.areEqual(xScan.getScanType().toString(), scanType.toString())) {
            stopAndReleaseScan();
        }
        if (this.xScanImpl == null) {
            XScan xScanCreateScanImpl = ScanFactory.INSTANCE.createScanImpl(scanType);
            this.xScanImpl = xScanCreateScanImpl;
            if (xScanCreateScanImpl != null) {
                xScanCreateScanImpl.onCreate();
            }
        }
        XScan xScan2 = this.xScanImpl;
        Intrinsics.checkNotNull(xScan2);
        return xScan2;
    }

    public final void stopAndReleaseScan() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "release scan!".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "release scan! " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "release scan! " + strComponent2);
            }
        }
        XScan xScan = this.xScanImpl;
        if (xScan != null) {
            xScan.stopScan();
            xScan.onDestroy();
            this.xScanImpl = null;
        }
    }

    public final XConnectorDevice getDevice(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return this.deviceLruHashMap.getOrPut(address);
    }

    public final XConnectorDevice getDevice(XBluetoothDevice bleDevice) {
        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
        return this.deviceLruHashMap.getOrPut(bleDevice);
    }

    public final XConnectorDevice getDevice(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
        return this.deviceLruHashMap.getOrPut(bluetoothDevice);
    }

    public final void onDestroy() {
        this.deviceLruHashMap.onDestroy();
    }

    public final void sppCloseSocket() {
        Iterator<T> it = getDeviceMaps().iterator();
        while (it.hasNext()) {
            getDevice((String) it.next()).sppCloseSocket();
        }
    }
}
