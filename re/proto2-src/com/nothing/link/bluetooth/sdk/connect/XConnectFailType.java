package com.nothing.link.bluetooth.sdk.connect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XConnectFailType.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0015\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0015\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,\u00a8\u0006-"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "", "()V", "AlreadyConnecting", "BluetoothUnable", "BoundTimeOut", "ConnectException", "ConnectTimeOut", "DeviceBusy", "EncryptionChange", "GPSDisable", "InvokeFailed", "KeyMissingPaired", "NoBluetoothPermission", "NullableBluetoothDevice", "PageTimeout", "ScanNullableBluetoothDevice", "UnBound", "UnSupportBle", "Unknown", "UserCancel", "UserFailed", "XBluetoothDeviceDisable", "connectPeerPaired", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$AlreadyConnecting;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$BluetoothUnable;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$BoundTimeOut;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$ConnectException;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$ConnectTimeOut;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$DeviceBusy;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$EncryptionChange;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$GPSDisable;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$InvokeFailed;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$KeyMissingPaired;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$NoBluetoothPermission;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$NullableBluetoothDevice;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$PageTimeout;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$ScanNullableBluetoothDevice;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$UnBound;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$UnSupportBle;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$Unknown;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$UserCancel;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$UserFailed;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$XBluetoothDeviceDisable;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$connectPeerPaired;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XConnectFailType {
    public /* synthetic */ XConnectFailType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$UserCancel;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UserCancel extends XConnectFailType {
        public static final UserCancel INSTANCE = new UserCancel();

        private UserCancel() {
            super(null);
        }

        public String toString() {
            return "UserCancel 1";
        }
    }

    private XConnectFailType() {
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$UserFailed;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UserFailed extends XConnectFailType {
        public static final UserFailed INSTANCE = new UserFailed();

        private UserFailed() {
            super(null);
        }

        public String toString() {
            return "UserFailed 9";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$UnBound;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnBound extends XConnectFailType {
        public static final UnBound INSTANCE = new UnBound();

        private UnBound() {
            super(null);
        }

        public String toString() {
            return "UnBound";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$BoundTimeOut;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BoundTimeOut extends XConnectFailType {
        public static final BoundTimeOut INSTANCE = new BoundTimeOut();

        private BoundTimeOut() {
            super(null);
        }

        public String toString() {
            return "BoundTimeOut";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$PageTimeout;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PageTimeout extends XConnectFailType {
        public static final PageTimeout INSTANCE = new PageTimeout();

        private PageTimeout() {
            super(null);
        }

        public String toString() {
            return "PageTimeout";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$GPSDisable;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class GPSDisable extends XConnectFailType {
        public static final GPSDisable INSTANCE = new GPSDisable();

        private GPSDisable() {
            super(null);
        }

        public String toString() {
            return "GPSDisable";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$BluetoothUnable;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BluetoothUnable extends XConnectFailType {
        public static final BluetoothUnable INSTANCE = new BluetoothUnable();

        private BluetoothUnable() {
            super(null);
        }

        public String toString() {
            return "BluetoothUnable";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$NullableBluetoothDevice;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NullableBluetoothDevice extends XConnectFailType {
        public static final NullableBluetoothDevice INSTANCE = new NullableBluetoothDevice();

        private NullableBluetoothDevice() {
            super(null);
        }

        public String toString() {
            return "NullableBluetoothDevice";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$UnSupportBle;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class UnSupportBle extends XConnectFailType {
        public static final UnSupportBle INSTANCE = new UnSupportBle();

        private UnSupportBle() {
            super(null);
        }

        public String toString() {
            return "UnSupportBle";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$XBluetoothDeviceDisable;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class XBluetoothDeviceDisable extends XConnectFailType {
        public static final XBluetoothDeviceDisable INSTANCE = new XBluetoothDeviceDisable();

        private XBluetoothDeviceDisable() {
            super(null);
        }

        public String toString() {
            return "BleDisable";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$NoBluetoothPermission;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class NoBluetoothPermission extends XConnectFailType {
        public static final NoBluetoothPermission INSTANCE = new NoBluetoothPermission();

        private NoBluetoothPermission() {
            super(null);
        }

        public String toString() {
            return "NoBluetoothPermission";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$ConnectException;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ConnectException extends XConnectFailType {
        private final Throwable throwable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConnectException(Throwable throwable) {
            super(null);
            Intrinsics.checkNotNullParameter(throwable, "throwable");
            this.throwable = throwable;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }

        public String toString() {
            return "ConnectException " + this.throwable.getMessage();
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$ConnectTimeOut;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ConnectTimeOut extends XConnectFailType {
        public static final ConnectTimeOut INSTANCE = new ConnectTimeOut();

        private ConnectTimeOut() {
            super(null);
        }

        public String toString() {
            return "ConnectTimeOut";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$AlreadyConnecting;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class AlreadyConnecting extends XConnectFailType {
        public static final AlreadyConnecting INSTANCE = new AlreadyConnecting();

        private AlreadyConnecting() {
            super(null);
        }

        public String toString() {
            return "AlreadyConnecting";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$ScanNullableBluetoothDevice;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ScanNullableBluetoothDevice extends XConnectFailType {
        public static final ScanNullableBluetoothDevice INSTANCE = new ScanNullableBluetoothDevice();

        private ScanNullableBluetoothDevice() {
            super(null);
        }

        public String toString() {
            return "ScanNullableBluetoothDevice";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$InvokeFailed;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class InvokeFailed extends XConnectFailType {
        public static final InvokeFailed INSTANCE = new InvokeFailed();

        private InvokeFailed() {
            super(null);
        }

        public String toString() {
            return "InvokeFailed";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$connectPeerPaired;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class connectPeerPaired extends XConnectFailType {
        public static final connectPeerPaired INSTANCE = new connectPeerPaired();

        private connectPeerPaired() {
            super(null);
        }

        public String toString() {
            return "connectPeerPaired";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$KeyMissingPaired;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class KeyMissingPaired extends XConnectFailType {
        public static final KeyMissingPaired INSTANCE = new KeyMissingPaired();

        private KeyMissingPaired() {
            super(null);
        }

        public String toString() {
            return "KeyMissingPaired";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$EncryptionChange;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class EncryptionChange extends XConnectFailType {
        public static final EncryptionChange INSTANCE = new EncryptionChange();

        private EncryptionChange() {
            super(null);
        }

        public String toString() {
            return "EncryptionChange";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$DeviceBusy;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DeviceBusy extends XConnectFailType {
        public static final DeviceBusy INSTANCE = new DeviceBusy();

        private DeviceBusy() {
            super(null);
        }

        public String toString() {
            return "DeviceBusy";
        }
    }

    /* JADX INFO: compiled from: XConnectFailType.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType$Unknown;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "()V", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Unknown extends XConnectFailType {
        public static final Unknown INSTANCE = new Unknown();

        private Unknown() {
            super(null);
        }

        public String toString() {
            return "Unknown";
        }
    }
}
