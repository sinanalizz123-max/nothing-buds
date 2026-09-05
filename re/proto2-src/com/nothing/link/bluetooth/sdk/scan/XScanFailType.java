package com.nothing.link.bluetooth.sdk.scan;

import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XScanFailType.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\b\u0003\u0004\u0005\u0006\u0007\b\t\nB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\b\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "", "()V", "AlReadyScanning", "BleDisable", "BluetoothUnable", "GPSDisable", "NoBluetoothPermission", "ScanError", "UnInitManager", "UnSupportBle", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$AlReadyScanning;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$BleDisable;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$BluetoothUnable;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$GPSDisable;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$NoBluetoothPermission;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$ScanError;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$UnInitManager;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$UnSupportBle;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XScanFailType {
    public /* synthetic */ XScanFailType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: XScanFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$BluetoothUnable;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BluetoothUnable extends XScanFailType {
        public static final BluetoothUnable INSTANCE = new BluetoothUnable();

        private BluetoothUnable() {
            super(null);
        }

        public String toString() {
            return "BluetoothUnable";
        }
    }

    private XScanFailType() {
    }

    /* JADX INFO: compiled from: XScanFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$UnInitManager;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnInitManager extends XScanFailType {
        public static final UnInitManager INSTANCE = new UnInitManager();

        private UnInitManager() {
            super(null);
        }

        public String toString() {
            return "NoInitManager";
        }
    }

    /* JADX INFO: compiled from: XScanFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$UnSupportBle;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnSupportBle extends XScanFailType {
        public static final UnSupportBle INSTANCE = new UnSupportBle();

        private UnSupportBle() {
            super(null);
        }

        public String toString() {
            return "UnSupportBle";
        }
    }

    /* JADX INFO: compiled from: XScanFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$BleDisable;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BleDisable extends XScanFailType {
        public static final BleDisable INSTANCE = new BleDisable();

        private BleDisable() {
            super(null);
        }

        public String toString() {
            return "BleDisable";
        }
    }

    /* JADX INFO: compiled from: XScanFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$GPSDisable;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GPSDisable extends XScanFailType {
        public static final GPSDisable INSTANCE = new GPSDisable();

        private GPSDisable() {
            super(null);
        }

        public String toString() {
            return "GPSDisable";
        }
    }

    /* JADX INFO: compiled from: XScanFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$NoBluetoothPermission;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NoBluetoothPermission extends XScanFailType {
        public static final NoBluetoothPermission INSTANCE = new NoBluetoothPermission();

        private NoBluetoothPermission() {
            super(null);
        }

        public String toString() {
            return "NoBlePermission";
        }
    }

    /* JADX INFO: compiled from: XScanFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$AlReadyScanning;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AlReadyScanning extends XScanFailType {
        public static final AlReadyScanning INSTANCE = new AlReadyScanning();

        private AlReadyScanning() {
            super(null);
        }

        public String toString() {
            return "AlReadyScanning ";
        }
    }

    /* JADX INFO: compiled from: XScanFailType.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType$ScanError;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "errorCode", "", "throwable", "", "(ILjava/lang/Throwable;)V", "getErrorCode", "()I", "getThrowable", "()Ljava/lang/Throwable;", "component1", "component2", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ScanError extends XScanFailType {
        private final int errorCode;
        private final Throwable throwable;

        public static /* synthetic */ ScanError copy$default(ScanError scanError, int i, Throwable th, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = scanError.errorCode;
            }
            if ((i2 & 2) != 0) {
                th = scanError.throwable;
            }
            return scanError.copy(i, th);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getErrorCode() {
            return this.errorCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        public final ScanError copy(int errorCode, Throwable throwable) {
            return new ScanError(errorCode, throwable);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ScanError)) {
                return false;
            }
            ScanError scanError = (ScanError) other;
            return this.errorCode == scanError.errorCode && Intrinsics.areEqual(this.throwable, scanError.throwable);
        }

        public int hashCode() {
            int iHashCode = Integer.hashCode(this.errorCode) * 31;
            Throwable th = this.throwable;
            return iHashCode + (th == null ? 0 : th.hashCode());
        }

        public ScanError(int i, Throwable th) {
            super(null);
            this.errorCode = i;
            this.throwable = th;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public String toString() {
            int i = this.errorCode;
            Throwable th = this.throwable;
            return "errorCode " + i + ", throwable:" + (th != null ? th.getMessage() : null);
        }
    }
}
