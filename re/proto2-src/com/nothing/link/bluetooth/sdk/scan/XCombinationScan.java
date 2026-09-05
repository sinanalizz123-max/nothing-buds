package com.nothing.link.bluetooth.sdk.scan;

import android.util.Log;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XCombinationScan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001f\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\b\u000b2\u0006\u0010\f\u001a\u00020\tJ\u001f\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\b\u000b2\u0006\u0010\f\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J_\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0017\u0010\u001a\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u00a2\u0006\u0002\b\u000b2\u0019\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\n\u0018\u00010\b\u00a2\u0006\u0002\b\u000bH\u0016\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XCombinationScan;", "Lcom/nothing/link/bluetooth/sdk/scan/XScan;", "()V", "bleScan", "Lcom/nothing/link/bluetooth/sdk/scan/XBleScan;", "btScan", "Lcom/nothing/link/bluetooth/sdk/scan/XBTScan;", "bleScanCallBack", "Lkotlin/Function1;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanCallback;", "", "Lkotlin/ExtensionFunctionType;", "callback", "btScanCallBack", "getScanType", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "onCreate", "onDestroy", "startInternal", "startScan", "", "scanMillisTimeOut", "", "scanRetryCount", "", "scanRetryInterval", "xScanCallback", "bluetoothFlowCallback", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Z", "stop", "stopScan", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XCombinationScan extends XScan {
    private XBleScan bleScan = new XBleScan();
    private XBTScan btScan = new XBTScan();

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void startInternal() {
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void stop() {
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void onCreate() {
        super.onCreate();
        this.bleScan.onCreate();
        this.btScan.onCreate();
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public XScanType getScanType() {
        return XScanType.Combination.INSTANCE;
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void onDestroy() {
        super.onDestroy();
        this.bleScan.onDestroy();
        this.btScan.onDestroy();
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public boolean startScan(final Long scanMillisTimeOut, final Integer scanRetryCount, final Long scanRetryInterval, final Function1<? super XScanCallback, Unit> xScanCallback, Function1<? super XBluetoothFlowCallBack, Unit> bluetoothFlowCallback) {
        Intrinsics.checkNotNullParameter(xScanCallback, "xScanCallback");
        XScanCallback xScanCallback2 = new XScanCallback();
        xScanCallback.invoke(xScanCallback2);
        if (bluetoothFlowCallback != null) {
            XBluetoothFlowCallBack xBluetoothFlowCallBack = new XBluetoothFlowCallBack();
            bluetoothFlowCallback.invoke(xBluetoothFlowCallBack);
            setMXBluetoothFlowCallBack(xBluetoothFlowCallBack);
        }
        if (!this.bleScan.startScan(scanMillisTimeOut, scanRetryCount, scanRetryInterval, bleScanCallBack(xScanCallback2), new Function1<XBluetoothFlowCallBack, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan$startScan$started$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XBluetoothFlowCallBack xBluetoothFlowCallBack2) {
                invoke2(xBluetoothFlowCallBack2);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XBluetoothFlowCallBack startScan) {
                Intrinsics.checkNotNullParameter(startScan, "$this$startScan");
                final XCombinationScan xCombinationScan = this.this$0;
                final Long l = scanMillisTimeOut;
                final Integer num = scanRetryCount;
                final Long l2 = scanRetryInterval;
                final Function1<XScanCallback, Unit> function1 = xScanCallback;
                startScan.onRequestPermission(new Function1<Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan$startScan$started$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Boolean, ? extends Unit> function2) {
                        invoke2((Function1<? super Boolean, Unit>) function2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Function1<? super Boolean, Unit> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        XBluetoothFlowCallBack mXBluetoothFlowCallBack = xCombinationScan.getMXBluetoothFlowCallBack();
                        if (mXBluetoothFlowCallBack != null) {
                            final XCombinationScan xCombinationScan2 = xCombinationScan;
                            final Long l3 = l;
                            final Integer num2 = num;
                            final Long l4 = l2;
                            final Function1<XScanCallback, Unit> function2 = function1;
                            mXBluetoothFlowCallBack.callRequestPermission(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.startScan.started.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z) {
                                    if (z) {
                                        XScan.startScan$default(xCombinationScan2, l3, num2, l4, function2, null, 16, null);
                                    }
                                }
                            });
                        }
                    }
                });
                final XCombinationScan xCombinationScan2 = this.this$0;
                final Long l3 = scanMillisTimeOut;
                final Integer num2 = scanRetryCount;
                final Long l4 = scanRetryInterval;
                final Function1<XScanCallback, Unit> function2 = xScanCallback;
                startScan.onRequestGps(new Function1<Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan$startScan$started$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Boolean, ? extends Unit> function3) {
                        invoke2((Function1<? super Boolean, Unit>) function3);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Function1<? super Boolean, Unit> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        XBluetoothFlowCallBack mXBluetoothFlowCallBack = xCombinationScan2.getMXBluetoothFlowCallBack();
                        if (mXBluetoothFlowCallBack != null) {
                            final XCombinationScan xCombinationScan3 = xCombinationScan2;
                            final Long l5 = l3;
                            final Integer num3 = num2;
                            final Long l6 = l4;
                            final Function1<XScanCallback, Unit> function3 = function2;
                            mXBluetoothFlowCallBack.callRequestGps(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.startScan.started.1.2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z) {
                                    if (z) {
                                        XScan.startScan$default(xCombinationScan3, l5, num3, l6, function3, null, 16, null);
                                    }
                                }
                            });
                        }
                    }
                });
                final XCombinationScan xCombinationScan3 = this.this$0;
                final Long l5 = scanMillisTimeOut;
                final Integer num3 = scanRetryCount;
                final Long l6 = scanRetryInterval;
                final Function1<XScanCallback, Unit> function3 = xScanCallback;
                startScan.onRequestBluetooth(new Function1<Function1<? super Boolean, ? extends Unit>, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan$startScan$started$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Function1<? super Boolean, ? extends Unit> function4) {
                        invoke2((Function1<? super Boolean, Unit>) function4);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Function1<? super Boolean, Unit> it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        XBluetoothFlowCallBack mXBluetoothFlowCallBack = xCombinationScan3.getMXBluetoothFlowCallBack();
                        if (mXBluetoothFlowCallBack != null) {
                            final XCombinationScan xCombinationScan4 = xCombinationScan3;
                            final Long l7 = l5;
                            final Integer num4 = num3;
                            final Long l8 = l6;
                            final Function1<XScanCallback, Unit> function4 = function3;
                            mXBluetoothFlowCallBack.callRequestBluetoothOpen(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.startScan.started.1.3.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                                    invoke(bool.booleanValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(boolean z) {
                                    if (z) {
                                        XScan.startScan$default(xCombinationScan4, l7, num4, l8, function4, null, 16, null);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        })) {
            return false;
        }
        XScan.startScan$default(this.btScan, scanMillisTimeOut, scanRetryCount, scanRetryInterval, btScanCallBack(xScanCallback2), null, 16, null);
        return true;
    }

    public final Function1<XScanCallback, Unit> btScanCallBack(final XScanCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new Function1<XScanCallback, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.btScanCallBack.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XScanCallback xScanCallback) {
                invoke2(xScanCallback);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XScanCallback xScanCallback) {
                Intrinsics.checkNotNullParameter(xScanCallback, "$this$null");
                final XScanCallback xScanCallback2 = callback;
                xScanCallback.onScanStart(new Function0<Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.btScanCallBack.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true) && "bt onScanStart".length() != 0) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            FileLog.print$default(fileLog, 3, str, tag, "bt onScanStart " + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, "bt onScanStart " + strComponent2);
                            }
                        }
                        xScanCallback2.callScanStart();
                    }
                });
                xScanCallback.onScanResult(new Function2<XBluetoothDevice, Integer, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.btScanCallBack.1.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Integer num) {
                        invoke(xBluetoothDevice, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(XBluetoothDevice bleDevice, int i) {
                        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "bt device:" + bleDevice + ",count:" + i;
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
                });
                xScanCallback.onScanComplete(new Function2<List<XBluetoothDevice>, List<XBluetoothDevice>, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.btScanCallBack.1.3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(List<XBluetoothDevice> list, List<XBluetoothDevice> list2) {
                        invoke2(list, list2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<XBluetoothDevice> bleDeviceList, List<XBluetoothDevice> bleDeviceDuplicateRemovalList) {
                        Intrinsics.checkNotNullParameter(bleDeviceList, "bleDeviceList");
                        Intrinsics.checkNotNullParameter(bleDeviceDuplicateRemovalList, "bleDeviceDuplicateRemovalList");
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "bt onScanComplete ,size:" + bleDeviceList.size() + ",filter size:" + bleDeviceDuplicateRemovalList.size();
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
                });
                final XScanCallback xScanCallback3 = callback;
                xScanCallback.onScanFail(new Function1<XScanFailType, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.btScanCallBack.1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(XScanFailType xScanFailType) {
                        invoke2(xScanFailType);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(XScanFailType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "bt onScanFail :" + it;
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
                        xScanCallback3.callScanFail(it);
                    }
                });
                final XCombinationScan xCombinationScan = this;
                final XScanCallback xScanCallback4 = callback;
                xScanCallback.onLeScanDuplicateRemoval(new Function2<XBluetoothDevice, Integer, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.btScanCallBack.1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Integer num) {
                        invoke(xBluetoothDevice, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(XBluetoothDevice bleDevice, int i) {
                        Object next;
                        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
                        Iterator<T> it = xCombinationScan.bleScan.getDuplicateRemovalResults().iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (!Intrinsics.areEqual(((XBluetoothDevice) next).getRealAddress(), bleDevice.getRealAddress()));
                        XBluetoothDevice xBluetoothDevice = (XBluetoothDevice) next;
                        if (xBluetoothDevice != null) {
                            XScanCallback xScanCallback5 = xScanCallback4;
                            Logger logger = Logger.INSTANCE;
                            String tag = logger.getTAG();
                            int depth = logger.getDepth();
                            if (logger.isCanLogger(true)) {
                                String str = "bt scanResult match :" + xBluetoothDevice;
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
                            xScanCallback5.callLeScan(xBluetoothDevice, i);
                        }
                    }
                });
            }
        };
    }

    public final Function1<XScanCallback, Unit> bleScanCallBack(final XScanCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new Function1<XScanCallback, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.bleScanCallBack.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XScanCallback xScanCallback) {
                invoke2(xScanCallback);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XScanCallback xScanCallback) {
                Intrinsics.checkNotNullParameter(xScanCallback, "$this$null");
                final XScanCallback xScanCallback2 = callback;
                xScanCallback.onScanStart(new Function0<Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.bleScanCallBack.1.1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true) && "Ble onScanStart".length() != 0) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            FileLog.print$default(fileLog, 3, str, tag, "Ble onScanStart " + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, "Ble onScanStart " + strComponent2);
                            }
                        }
                        xScanCallback2.callScanStart();
                    }
                });
                xScanCallback.onScanResult(new Function2<XBluetoothDevice, Integer, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.bleScanCallBack.1.2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Integer num) {
                        invoke(xBluetoothDevice, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(XBluetoothDevice bleDevice, int i) {
                        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "Ble onScanResult device:" + bleDevice + ",count:" + i;
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
                });
                xScanCallback.onScanComplete(new Function2<List<XBluetoothDevice>, List<XBluetoothDevice>, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.bleScanCallBack.1.3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(List<XBluetoothDevice> list, List<XBluetoothDevice> list2) {
                        invoke2(list, list2);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<XBluetoothDevice> bleDeviceList, List<XBluetoothDevice> bleDeviceDuplicateRemovalList) {
                        Intrinsics.checkNotNullParameter(bleDeviceList, "bleDeviceList");
                        Intrinsics.checkNotNullParameter(bleDeviceDuplicateRemovalList, "bleDeviceDuplicateRemovalList");
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "Ble onScanComplete ,size:" + bleDeviceList.size() + ",filter size:" + bleDeviceDuplicateRemovalList.size();
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
                });
                final XScanCallback xScanCallback3 = callback;
                xScanCallback.onScanFail(new Function1<XScanFailType, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.bleScanCallBack.1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(XScanFailType xScanFailType) {
                        invoke2(xScanFailType);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(XScanFailType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "Ble onScanFail :" + it;
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
                        xScanCallback3.callScanFail(it);
                    }
                });
                final XCombinationScan xCombinationScan = this;
                final XScanCallback xScanCallback4 = callback;
                xScanCallback.onLeScanDuplicateRemoval(new Function2<XBluetoothDevice, Integer, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XCombinationScan.bleScanCallBack.1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Integer num) {
                        invoke(xBluetoothDevice, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(XBluetoothDevice bleDevice, int i) {
                        Object next;
                        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
                        Iterator<T> it = xCombinationScan.btScan.getDuplicateRemovalResults().iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                        } while (!Intrinsics.areEqual(((XBluetoothDevice) next).getRealAddress(), bleDevice.getRealAddress()));
                        XBluetoothDevice xBluetoothDevice = (XBluetoothDevice) next;
                        if (xBluetoothDevice != null) {
                            XScanCallback xScanCallback5 = xScanCallback4;
                            Logger logger = Logger.INSTANCE;
                            String tag = logger.getTAG();
                            int depth = logger.getDepth();
                            if (logger.isCanLogger(true)) {
                                String str = "Ble scanResult match :" + xBluetoothDevice;
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
                            xScanCallback5.callLeScan(bleDevice, i);
                        }
                    }
                });
            }
        };
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.XScan
    public void stopScan() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getScanType() + " call stopScan";
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 6, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        this.bleScan.stopScan();
        this.btScan.stopScan();
    }
}
