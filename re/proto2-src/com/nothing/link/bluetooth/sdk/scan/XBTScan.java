package com.nothing.link.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.content.IntentCompat;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBTScan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0003J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\b\u0010\u0013\u001a\u00020\u000eH\u0017J\b\u0010\u0014\u001a\u00020\u000eH\u0017R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0005\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XBTScan;", "Lcom/nothing/link/bluetooth/sdk/scan/XScan;", "()V", "scanReceiver", "com/nothing/link/bluetooth/sdk/scan/XBTScan$scanReceiver$1", "Lcom/nothing/link/bluetooth/sdk/scan/XBTScan$scanReceiver$1;", "checkNotNothingDevice", "", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "checkSameData", "getScanType", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "onCreate", "", "onDestroy", "onFoundDevice", "intent", "Landroid/content/Intent;", "startInternal", "stop", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBTScan extends XScan {
    private XBTScan$scanReceiver$1 scanReceiver = new BroadcastReceiver() { // from class: com.nothing.link.bluetooth.sdk.scan.XBTScan$scanReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent != null ? intent.getAction() : null;
            if (action != null) {
                int iHashCode = action.hashCode();
                if (iHashCode == -1780914469) {
                    if (action.equals("android.bluetooth.adapter.action.DISCOVERY_FINISHED")) {
                        Logger logger = Logger.INSTANCE;
                        XBTScan xBTScan = this.this$0;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = xBTScan.getScanType() + StringUtils.SPACE + intent.getAction();
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
                        if (this.this$0.getIsScanning().get()) {
                            Logger logger2 = Logger.INSTANCE;
                            String tag2 = logger2.getTAG();
                            int depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(true) && "system auto finish bt scan,then start again.".length() != 0) {
                                Pair<String, String> trace2 = logger2.getTrace(depth2);
                                String strComponent3 = trace2.component1();
                                String strComponent4 = trace2.component2();
                                FileLog fileLog2 = FileLog.INSTANCE;
                                String str4 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                                FileLog.print$default(fileLog2, 4, str4, tag2, "system auto finish bt scan,then start again. " + strComponent4, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.i(tag2 + strComponent3, "system auto finish bt scan,then start again. " + strComponent4);
                                }
                            }
                            this.this$0.startInternal();
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (iHashCode != 6759640) {
                    if (iHashCode == 1167529923 && action.equals("android.bluetooth.device.action.FOUND")) {
                        Logger logger3 = Logger.INSTANCE;
                        XBTScan xBTScan2 = this.this$0;
                        String tag3 = logger3.getTAG();
                        int depth3 = logger3.getDepth();
                        if (logger3.isCanLogger(true)) {
                            String str5 = xBTScan2.getScanType() + StringUtils.SPACE + intent.getAction();
                            String str6 = str5;
                            if (str6 != null && str6.length() != 0) {
                                Pair<String, String> trace3 = logger3.getTrace(depth3);
                                String strComponent5 = trace3.component1();
                                String strComponent6 = trace3.component2();
                                FileLog fileLog3 = FileLog.INSTANCE;
                                String str7 = logger3.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                FileLog.print$default(fileLog3, 3, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                                if (logger3.isDebug()) {
                                    Log.i(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                                }
                            }
                        }
                        this.this$0.onFoundDevice(intent);
                        return;
                    }
                    return;
                }
                if (action.equals("android.bluetooth.adapter.action.DISCOVERY_STARTED")) {
                    Logger logger4 = Logger.INSTANCE;
                    XBTScan xBTScan3 = this.this$0;
                    String tag4 = logger4.getTAG();
                    int depth4 = logger4.getDepth();
                    if (logger4.isCanLogger(true)) {
                        String str8 = xBTScan3.getScanType() + StringUtils.SPACE + intent.getAction();
                        String str9 = str8;
                        if (str9 == null || str9.length() == 0) {
                            return;
                        }
                        Pair<String, String> trace4 = logger4.getTrace(depth4);
                        String strComponent7 = trace4.component1();
                        String strComponent8 = trace4.component2();
                        FileLog fileLog4 = FileLog.INSTANCE;
                        String str10 = logger4.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                        FileLog.print$default(fileLog4, 3, str10, tag4, str8 + StringUtils.SPACE + strComponent8, null, 16, null);
                        if (logger4.isDebug()) {
                            Log.i(tag4 + strComponent7, str8 + StringUtils.SPACE + strComponent8);
                        }
                    }
                }
            }
        }
    };

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public XScanType getScanType() {
        return XScanType.BT.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFoundDevice(Intent intent) {
        BluetoothDevice bluetoothDevice = (BluetoothDevice) IntentCompat.getParcelableExtra(intent, "android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getScanType() + " onFoundDevice " + bluetoothDevice;
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
        if (bluetoothDevice != null) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new XBTScan$onFoundDevice$2$1(this, bluetoothDevice, bluetoothDevice, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkNotNothingDevice(BluetoothDevice bluetoothDevice) {
        int majorDeviceClass;
        BluetoothClass bluetoothClass = bluetoothDevice.getBluetoothClass();
        if (bluetoothClass != null && (512 == (majorDeviceClass = bluetoothClass.getMajorDeviceClass()) || 256 == majorDeviceClass || 1536 == majorDeviceClass)) {
            return true;
        }
        ArrayList<String> scanDeviceAddressesPrefix = getMXBluetoothManager().getBluetoothConfig().getScanDeviceAddressesPrefix();
        if (!scanDeviceAddressesPrefix.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : scanDeviceAddressesPrefix) {
                String address = bluetoothDevice.getAddress();
                Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                if (StringsKt.startsWith$default(address, (String) obj, false, 2, (Object) null)) {
                    arrayList.add(obj);
                }
            }
            if (arrayList.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkSameData(BluetoothDevice bluetoothDevice) {
        ConcurrentLinkedQueue<XBluetoothDevice> results = getResults();
        if ((results instanceof Collection) && results.isEmpty()) {
            return false;
        }
        Iterator<T> it = results.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((XBluetoothDevice) it.next()).getRealAddress(), bluetoothDevice.getAddress())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void startInternal() {
        XScanCallback mXScanCallback = getMXScanCallback();
        if (mXScanCallback != null) {
            mXScanCallback.callScanStart();
        }
        BluetoothAdapter bluetoothAdapter = getMXBluetoothManager().getBluetoothAdapter();
        Boolean boolValueOf = bluetoothAdapter != null ? Boolean.valueOf(bluetoothAdapter.startDiscovery()) : null;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "startDiscovery " + boolValueOf;
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

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void stop() {
        if (getMXBluetoothManager().getBluetoothAdapter() == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "stop bt bluetoothAdapter is null ,maybe XBluetoothManager is not init!".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 5, str, tag, "stop bt bluetoothAdapter is null ,maybe XBluetoothManager is not init! " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.w(tag + strComponent1, "stop bt bluetoothAdapter is null ,maybe XBluetoothManager is not init! " + strComponent2);
                    return;
                }
                return;
            }
            return;
        }
        if (getMXBluetoothManager().bluetoothUnEnable()) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "stop bt  bluetooth is unavailable!".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 5, str2, tag2, "stop bt  bluetooth is unavailable! " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.w(tag2 + strComponent3, "stop bt  bluetooth is unavailable! " + strComponent4);
                    return;
                }
                return;
            }
            return;
        }
        if (!BleUtil.INSTANCE.isPermission(getMContext())) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "stop bt  context has no permission!".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog3, 5, str3, tag3, "stop bt  context has no permission! " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.w(tag3 + strComponent5, "stop bt  context has no permission! " + strComponent6);
                    return;
                }
                return;
            }
            return;
        }
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true) && "stop cancelDiscovery".length() != 0) {
            Pair<String, String> trace4 = logger4.getTrace(depth4);
            String strComponent7 = trace4.component1();
            String strComponent8 = trace4.component2();
            FileLog fileLog4 = FileLog.INSTANCE;
            String str4 = logger4.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog4, 4, str4, tag4, "stop cancelDiscovery " + strComponent8, null, 16, null);
            if (logger4.isDebug()) {
                Log.i(tag4 + strComponent7, "stop cancelDiscovery " + strComponent8);
            }
        }
        BluetoothAdapter bluetoothAdapter = getMXBluetoothManager().getBluetoothAdapter();
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        onDestroy();
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void onCreate() {
        Object objM6347constructorimpl;
        super.onCreate();
        try {
            Result.Companion companion = Result.INSTANCE;
            Context mContext = getMContext();
            if (mContext != null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "onCreate registerReceiver".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 4, str, tag, "onCreate registerReceiver " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "onCreate registerReceiver " + strComponent2);
                    }
                }
                XBTScan$scanReceiver$1 xBTScan$scanReceiver$1 = this.scanReceiver;
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_STARTED");
                intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
                intentFilter.addAction("android.bluetooth.device.action.FOUND");
                Unit unit = Unit.INSTANCE;
                mContext.registerReceiver(xBTScan$scanReceiver$1, intentFilter);
            } else {
                mContext = null;
            }
            objM6347constructorimpl = Result.m6347constructorimpl(mContext);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String message = thM6350exceptionOrNullimpl.getMessage();
                String str2 = message;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str3 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog2, 6, str3, tag2, message + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.e(tag2 + strComponent3, message + StringUtils.SPACE + strComponent4);
                }
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void onDestroy() {
        Object objM6347constructorimpl;
        super.onDestroy();
        try {
            Result.Companion companion = Result.INSTANCE;
            Context mContext = getMContext();
            if (mContext != null) {
                mContext.unregisterReceiver(this.scanReceiver);
            } else {
                mContext = null;
            }
            objM6347constructorimpl = Result.m6347constructorimpl(mContext);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String message = thM6350exceptionOrNullimpl.getMessage();
                String str = message;
                if (str == null || str.length() == 0) {
                    return;
                }
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str2 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog, 6, str2, tag, message + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.e(tag + strComponent1, message + StringUtils.SPACE + strComponent2);
                }
            }
        }
    }
}
