package com.nothing.link.bluetooth.sdk.scan;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: XScanType.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "", "()V", "BLE", "BT", "Combination", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType$BLE;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType$BT;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType$Combination;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XScanType {
    public /* synthetic */ XScanType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: XScanType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanType$BLE;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BLE extends XScanType {
        public static final BLE INSTANCE = new BLE();

        private BLE() {
            super(null);
        }

        public String toString() {
            return "(BLE)";
        }
    }

    private XScanType() {
    }

    /* JADX INFO: compiled from: XScanType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanType$BT;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BT extends XScanType {
        public static final BT INSTANCE = new BT();

        private BT() {
            super(null);
        }

        public String toString() {
            return "(BT)";
        }
    }

    /* JADX INFO: compiled from: XScanType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanType$Combination;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Combination extends XScanType {
        public static final Combination INSTANCE = new Combination();

        private Combination() {
            super(null);
        }

        public String toString() {
            return "(Combination)";
        }
    }
}
