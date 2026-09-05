package com.nothing.link.bluetooth.sdk.scan;

import kotlin.Metadata;

/* JADX INFO: compiled from: ScanFactory.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/ScanFactory;", "", "()V", "createScanImpl", "Lcom/nothing/link/bluetooth/sdk/scan/XScan;", "scanType", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ScanFactory {
    public static final ScanFactory INSTANCE = new ScanFactory();

    private ScanFactory() {
    }

    public static /* synthetic */ XScan createScanImpl$default(ScanFactory scanFactory, XScanType xScanType, int i, Object obj) {
        if ((i & 1) != 0) {
            xScanType = null;
        }
        return scanFactory.createScanImpl(xScanType);
    }

    public final XScan createScanImpl(XScanType scanType) {
        if (scanType instanceof XScanType.BLE) {
            return new XBleScan();
        }
        if (scanType instanceof XScanType.BT) {
            return new XBTScan();
        }
        if (scanType instanceof XScanType.Combination) {
            return new XCombinationScan();
        }
        return new XBleScan();
    }
}
