package com.nothing.link.bluetooth.sdk.scan;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.UnDefinedException;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingParser;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBleScan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0015"}, d2 = {"com/nothing/link/bluetooth/sdk/scan/XBleScan$scanCallback$1", "Landroid/bluetooth/le/ScanCallback;", "callResult", "", "scanResult", "Landroid/bluetooth/le/ScanResult;", "checkSameData", "", "it", "isMatchDeviceName", "device", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "onBatchScanResults", "results", "", "onScanFailed", "errorCode", "", "onScanResult", "callbackType", "result", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBleScan$scanCallback$1 extends ScanCallback {
    final /* synthetic */ XBleScan this$0;

    XBleScan$scanCallback$1(XBleScan xBleScan) {
        this.this$0 = xBleScan;
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanResult(int callbackType, ScanResult result) {
        super.onScanResult(callbackType, result);
        if (this.this$0.getIsScanning().get() && result != null) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new XBleScan$scanCallback$1$onScanResult$1$1(this, result, null), 3, null);
        }
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onBatchScanResults(List<ScanResult> results) {
        super.onBatchScanResults(results);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkSameData(ScanResult it) {
        ConcurrentLinkedQueue<XBluetoothDevice> results = this.this$0.getResults();
        if ((results instanceof Collection) && results.isEmpty()) {
            return false;
        }
        for (XBluetoothDevice xBluetoothDevice : results) {
            ScanRecord scanRecord = it.getScanRecord();
            if (Arrays.equals(scanRecord != null ? scanRecord.getBytes() : null, xBluetoothDevice.getScanRecord())) {
                return true;
            }
        }
        return false;
    }

    public final void callResult(ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(scanResult, "scanResult");
        Bundle scanRecordBundle = this.this$0.getScanRecordBundle(scanResult);
        if (scanRecordBundle != null) {
            if (!this.this$0.getPaired() || scanRecordBundle.getBoolean(NothingParser.IS_PAIRED)) {
                XBluetoothDevice xBluetoothDeviceScanResultToBleDevice = BleUtil.INSTANCE.scanResultToBleDevice(scanResult, scanRecordBundle);
                if (!this.this$0.getFilterAddress().isEmpty()) {
                    if (this.this$0.getFilterAddress().containsKey(xBluetoothDeviceScanResultToBleDevice.getRealAddress())) {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "scan with specify device:" + xBluetoothDeviceScanResultToBleDevice;
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
                        this.this$0.filterData(xBluetoothDeviceScanResultToBleDevice);
                        return;
                    }
                    return;
                }
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "scanResult: " + xBluetoothDeviceScanResultToBleDevice;
                    String str5 = str4;
                    if (str5 != null && str5.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str6 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                        FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                if (!this.this$0.getMXBluetoothManager().getBluetoothConfig().getScanDeviceNames().isEmpty()) {
                    if (isMatchDeviceName(xBluetoothDeviceScanResultToBleDevice)) {
                        this.this$0.filterData(xBluetoothDeviceScanResultToBleDevice);
                        return;
                    }
                    return;
                }
                this.this$0.filterData(xBluetoothDeviceScanResultToBleDevice);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0067  */
    /* JADX WARN: Code duplicated, block: B:20:0x007f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:? A[LOOP:0: B:8:0x002c->B:21:?, LOOP_END, SYNTHETIC] */
    public final boolean isMatchDeviceName(XBluetoothDevice device) {
        String upperCase;
        String upperCase2;
        Intrinsics.checkNotNullParameter(device, "device");
        String deviceName = device.getDeviceName();
        String str = deviceName;
        if (str != null && str.length() != 0) {
            ArrayList<String> scanDeviceNames = this.this$0.getMXBluetoothManager().getBluetoothConfig().getScanDeviceNames();
            XBleScan xBleScan = this.this$0;
            for (String str2 : scanDeviceNames) {
                if (xBleScan.getMXBluetoothManager().getBluetoothConfig().getContainScanDeviceName()) {
                    String upperCase3 = deviceName.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                    String upperCase4 = str2.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
                    if (!StringsKt.contains$default((CharSequence) upperCase3, (CharSequence) upperCase4, false, 2, (Object) null)) {
                        upperCase = deviceName.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        upperCase2 = str2.toUpperCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                        if (Intrinsics.areEqual(upperCase, upperCase2)) {
                        }
                    }
                } else {
                    upperCase = deviceName.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    upperCase2 = str2.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    if (Intrinsics.areEqual(upperCase, upperCase2)) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.bluetooth.le.ScanCallback
    public void onScanFailed(int errorCode) {
        super.onScanFailed(errorCode);
        UnDefinedException unDefinedException = new UnDefinedException("\u626b\u63cf\u5931\u8d25\uff0c\u8bf7\u67e5\u9a8c[android.bluetooth.le.ScanCallback\u9519\u8bef\u7801]", null, 2, null);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String message = unDefinedException.getMessage();
            String str = message;
            if (str != null && str.length() != 0) {
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
        XScanCallback mXScanCallback = this.this$0.getMXScanCallback();
        if (mXScanCallback != null) {
            mXScanCallback.callScanFail(new XScanFailType.ScanError(errorCode, unDefinedException));
        }
    }
}
