package com.nothing.link.bluetooth.sdk.connect;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: XConnectType.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0005\u0006\u0007\b\t\nB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "", "()V", "getType", "", "BLE", "BT", "BleOTA", "LEAudio", "SPP", "SppOTA", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$BLE;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$BT;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$BleOTA;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$LEAudio;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$SPP;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$SppOTA;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XConnectType {
    public /* synthetic */ XConnectType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public int getType() {
        return 0;
    }

    private XConnectType() {
    }

    /* JADX INFO: compiled from: XConnectType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$BLE;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "()V", "getType", "", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BLE extends XConnectType {
        public static final BLE INSTANCE = new BLE();

        @Override // com.nothing.link.bluetooth.sdk.connect.XConnectType
        public int getType() {
            return 1;
        }

        private BLE() {
            super(null);
        }

        public String toString() {
            return "(BLE)";
        }
    }

    /* JADX INFO: compiled from: XConnectType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$SPP;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "()V", "getType", "", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SPP extends XConnectType {
        public static final SPP INSTANCE = new SPP();

        @Override // com.nothing.link.bluetooth.sdk.connect.XConnectType
        public int getType() {
            return 2;
        }

        private SPP() {
            super(null);
        }

        public String toString() {
            return "(SPP)";
        }
    }

    /* JADX INFO: compiled from: XConnectType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$BT;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "()V", "getType", "", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BT extends XConnectType {
        public static final BT INSTANCE = new BT();

        @Override // com.nothing.link.bluetooth.sdk.connect.XConnectType
        public int getType() {
            return 3;
        }

        private BT() {
            super(null);
        }

        public String toString() {
            return "(BT)";
        }
    }

    /* JADX INFO: compiled from: XConnectType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$BleOTA;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "()V", "getType", "", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class BleOTA extends XConnectType {
        public static final BleOTA INSTANCE = new BleOTA();

        @Override // com.nothing.link.bluetooth.sdk.connect.XConnectType
        public int getType() {
            return 4;
        }

        private BleOTA() {
            super(null);
        }

        public String toString() {
            return "(BleOTA)";
        }
    }

    /* JADX INFO: compiled from: XConnectType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$LEAudio;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "()V", "getType", "", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LEAudio extends XConnectType {
        public static final LEAudio INSTANCE = new LEAudio();

        @Override // com.nothing.link.bluetooth.sdk.connect.XConnectType
        public int getType() {
            return 5;
        }

        private LEAudio() {
            super(null);
        }

        public String toString() {
            return "(LEAudio)";
        }
    }

    /* JADX INFO: compiled from: XConnectType.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectType$SppOTA;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "()V", "getType", "", "toString", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SppOTA extends XConnectType {
        public static final SppOTA INSTANCE = new SppOTA();

        @Override // com.nothing.link.bluetooth.sdk.connect.XConnectType
        public int getType() {
            return 6;
        }

        private SppOTA() {
            super(null);
        }

        public String toString() {
            return "(SppOTA)";
        }
    }
}
