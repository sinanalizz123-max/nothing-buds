package com.nothing.link.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Bundle;
import android.os.ParcelUuid;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.config.XBluetoothConfig;
import com.nothing.link.bluetooth.sdk.scan.parser.IParser;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBleScan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0017J\b\u0010\u001a\u001a\u00020\u0017H\u0017R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0005R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XBleScan;", "Lcom/nothing/link/bluetooth/sdk/scan/XScan;", "()V", "scanCallback", "com/nothing/link/bluetooth/sdk/scan/XBleScan$scanCallback$1", "Lcom/nothing/link/bluetooth/sdk/scan/XBleScan$scanCallback$1;", "scanFilters", "Ljava/util/ArrayList;", "Landroid/bluetooth/le/ScanFilter;", "Lkotlin/collections/ArrayList;", "scanSetting", "Landroid/bluetooth/le/ScanSettings;", "scanner", "Landroid/bluetooth/le/BluetoothLeScanner;", "checkParameters", "", "getScanRecordBundle", "Landroid/os/Bundle;", "scanResult", "Landroid/bluetooth/le/ScanResult;", "getScanType", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "onCreate", "", "onDestroy", "startInternal", "stop", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBleScan extends XScan {
    private ScanSettings scanSetting;
    private BluetoothLeScanner scanner;
    private final ArrayList<ScanFilter> scanFilters = new ArrayList<>();
    private final XBleScan$scanCallback$1 scanCallback = new XBleScan$scanCallback$1(this);

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public boolean checkParameters() {
        boolean zCheckParameters = super.checkParameters();
        boolean zIsBleSupport = BleUtil.INSTANCE.isBleSupport(getMContext());
        if (!zIsBleSupport) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "ble disable!".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 5, str, tag, "ble disable! " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.w(tag + strComponent1, "ble disable! " + strComponent2);
                }
            }
            XScanCallback mXScanCallback = getMXScanCallback();
            if (mXScanCallback != null) {
                mXScanCallback.callScanFail(XScanFailType.BleDisable.INSTANCE);
            }
        }
        return zCheckParameters && zIsBleSupport;
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public XScanType getScanType() {
        return XScanType.BLE.INSTANCE;
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void onCreate() {
        super.onCreate();
        BluetoothAdapter bluetoothAdapter = getMXBluetoothManager().getBluetoothAdapter();
        this.scanner = bluetoothAdapter != null ? bluetoothAdapter.getBluetoothLeScanner() : null;
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void startInternal() {
        Object objM6347constructorimpl;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.scanFilters.clear();
            XBluetoothConfig bluetoothConfig = getMXBluetoothManager().getBluetoothConfig();
            Iterator<T> it = bluetoothConfig.getScanServiceUuids().iterator();
            while (it.hasNext()) {
                this.scanFilters.add(new ScanFilter.Builder().setServiceUuid(ParcelUuid.fromString((String) it.next())).build());
            }
            Iterator<T> it2 = bluetoothConfig.getScanDeviceAddresses().iterator();
            while (it2.hasNext()) {
                this.scanFilters.add(new ScanFilter.Builder().setDeviceAddress((String) it2.next()).build());
            }
            Iterator<T> it3 = bluetoothConfig.getScanManufacturerIds().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                } else {
                    this.scanFilters.add(new ScanFilter.Builder().setManufacturerData(((Number) it3.next()).intValue(), new byte[0]).build());
                }
            }
            ScanSettings.Builder builder = new ScanSettings.Builder();
            builder.setCallbackType(1);
            this.scanSetting = builder.setScanMode(2).build();
            XScanCallback mXScanCallback = getMXScanCallback();
            if (mXScanCallback != null) {
                mXScanCallback.callScanStart();
            }
            if (BleUtil.INSTANCE.checkBluetoothPermissions()) {
                BluetoothLeScanner bluetoothLeScanner = this.scanner;
                boolean z = bluetoothLeScanner == null;
                if (bluetoothLeScanner == null) {
                    BluetoothAdapter bluetoothAdapter = getMXBluetoothManager().getBluetoothAdapter();
                    this.scanner = bluetoothAdapter != null ? bluetoothAdapter.getBluetoothLeScanner() : null;
                }
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "start scan... " + this.scanFilters.size() + " scannerIsNull\uff1a" + z + ",reInit: " + (this.scanner == null);
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
                BluetoothLeScanner bluetoothLeScanner2 = this.scanner;
                if (bluetoothLeScanner2 != null) {
                    bluetoothLeScanner2.startScan(this.scanFilters, this.scanSetting, this.scanCallback);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
            } else {
                XScanCallback mXScanCallback2 = getMXScanCallback();
                if (mXScanCallback2 != null) {
                    mXScanCallback2.callScanFail(XScanFailType.NoBluetoothPermission.INSTANCE);
                }
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true) && "parameters error : NoBluetoothPermission".length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 6, str4, tag2, "parameters error : NoBluetoothPermission" + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.e(tag2 + strComponent3, "parameters error : NoBluetoothPermission" + StringUtils.SPACE + strComponent4);
                    }
                }
                unit = Unit.INSTANCE;
            }
            objM6347constructorimpl = Result.m6347constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str5 = "parameters error : " + thM6350exceptionOrNullimpl.getMessage();
                String str6 = str5;
                if (str6 != null && str6.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str7 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    FileLog.print$default(fileLog3, 6, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.e(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            XScanCallback mXScanCallback3 = getMXScanCallback();
            if (mXScanCallback3 != null) {
                mXScanCallback3.callScanFail(new XScanFailType.ScanError(-1, thM6350exceptionOrNullimpl));
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void onDestroy() {
        super.onDestroy();
        this.scanFilters.clear();
        this.scanSetting = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:15:0x0066  */
    public final Bundle getScanRecordBundle(ScanResult scanResult) {
        Iterator it;
        ArrayList<IParser> arrayList;
        ArrayList<Integer> scanManufacturerIds = getMXBluetoothManager().getBluetoothConfig().getScanManufacturerIds();
        ArrayList<IParser> scanRecordParsers = getMXBluetoothManager().getBluetoothConfig().getScanRecordParsers();
        if (!scanManufacturerIds.isEmpty() && !scanRecordParsers.isEmpty()) {
            ScanRecord scanRecord = scanResult.getScanRecord();
            if (scanRecord == null) {
                return null;
            }
            Iterator it2 = scanManufacturerIds.iterator();
            while (it2.hasNext()) {
                int iIntValue = ((Number) it2.next()).intValue();
                byte[] manufacturerSpecificData = scanRecord.getManufacturerSpecificData(iIntValue);
                if (manufacturerSpecificData != null) {
                    String strBytesToHex = BleUtil.INSTANCE.bytesToHex(manufacturerSpecificData, false);
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "manufactureStr -> " + ((Object) strBytesToHex) + StringUtils.SPACE + iIntValue + StringUtils.SPACE;
                        String str2 = str;
                        if (str2 == null || str2.length() == 0) {
                            it = it2;
                            arrayList = scanRecordParsers;
                        } else {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            it = it2;
                            arrayList = scanRecordParsers;
                            FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    } else {
                        it = it2;
                        arrayList = scanRecordParsers;
                    }
                    Iterator<T> it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        Bundle rVar = ((IParser) it3.next()).parser(strBytesToHex, iIntValue, scanResult);
                        if (rVar != null) {
                            return rVar;
                        }
                    }
                } else {
                    it = it2;
                    arrayList = scanRecordParsers;
                }
                scanRecordParsers = arrayList;
                it2 = it;
            }
            return null;
        }
        return getNullBundle();
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void stop() {
        Object objM6347constructorimpl;
        Unit unit;
        if (getMXBluetoothManager().getBluetoothAdapter() == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "stop ble bluetoothAdapter is null ,maybe XBluetoothManager is not init!".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 5, str, tag, "stop ble bluetoothAdapter is null ,maybe XBluetoothManager is not init! " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.w(tag + strComponent1, "stop ble bluetoothAdapter is null ,maybe XBluetoothManager is not init! " + strComponent2);
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
            if (logger2.isCanLogger(true) && "stop ble  bluetooth is unavailable!".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 5, str2, tag2, "stop ble  bluetooth is unavailable! " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.w(tag2 + strComponent3, "stop ble  bluetooth is unavailable! " + strComponent4);
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
            if (logger3.isCanLogger(true) && "stop ble  context has no permission!".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog3, 5, str3, tag3, "stop ble  context has no permission! " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.w(tag3 + strComponent5, "stop ble  context has no permission! " + strComponent6);
                    return;
                }
                return;
            }
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            BluetoothLeScanner bluetoothLeScanner = this.scanner;
            if (bluetoothLeScanner != null) {
                bluetoothLeScanner.stopScan(this.scanCallback);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            objM6347constructorimpl = Result.m6347constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true)) {
                String message = thM6350exceptionOrNullimpl.getMessage();
                String str4 = message;
                if (str4 == null || str4.length() == 0) {
                    return;
                }
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str5 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                FileLog.print$default(fileLog4, 6, str5, tag4, message + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.e(tag4 + strComponent7, message + StringUtils.SPACE + strComponent8);
                }
            }
        }
    }
}
