package com.nothing.link.bluetooth.sdk.connect;

import android.bluetooth.BluetoothDevice;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XBluetoothDeviceStateChange.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH&J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\r\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J*\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0016J\"\u0010\u0017\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J*\u0010\u0018\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XBluetoothDeviceStateChange;", "", "aclStateChanged", "", "device", "Landroid/bluetooth/BluetoothDevice;", "connected", "", "actionEncryptionChange", "isSecure", "getMacAddress", "", "keyMissingChanged", "matchDeviceEvent", "onA2DPChange", "a2dpConnect", "headsetConnect", "onBluetoothChange", NotificationCompat.CATEGORY_STATUS, "", "onBondStatusChange", "preStatus", "reason", "onHeadSetChange", "onLeAudioChange", "leAudioConnect", "profileConnectedChanged", "profile", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface XBluetoothDeviceStateChange {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    void aclStateChanged(BluetoothDevice device, boolean connected);

    void actionEncryptionChange(BluetoothDevice device, boolean isSecure);

    String getMacAddress();

    void keyMissingChanged(BluetoothDevice device, boolean connected);

    boolean matchDeviceEvent(BluetoothDevice device);

    void onA2DPChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect);

    void onBluetoothChange(int status);

    void onBondStatusChange(BluetoothDevice device, int status, int preStatus, int reason);

    void onHeadSetChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect);

    void onLeAudioChange(BluetoothDevice device, boolean leAudioConnect, boolean a2dpConnect, boolean headsetConnect);

    void profileConnectedChanged(int profile, boolean connected);

    /* JADX INFO: compiled from: XBluetoothDeviceStateChange.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XBluetoothDeviceStateChange$Companion;", "", "()V", "IGNORE_ADDRESS", "", "getIGNORE_ADDRESS", "()Ljava/lang/String;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String IGNORE_ADDRESS = "IGNORE_ADDRESS";

        private Companion() {
        }

        public final String getIGNORE_ADDRESS() {
            return IGNORE_ADDRESS;
        }
    }

    /* JADX INFO: compiled from: XBluetoothDeviceStateChange.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void aclStateChanged(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, BluetoothDevice bluetoothDevice, boolean z) {
        }

        public static void actionEncryptionChange(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, BluetoothDevice bluetoothDevice, boolean z) {
        }

        public static void keyMissingChanged(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, BluetoothDevice bluetoothDevice, boolean z) {
        }

        public static void onA2DPChange(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, BluetoothDevice bluetoothDevice, boolean z, boolean z2) {
        }

        public static void onBluetoothChange(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, int i) {
        }

        public static void onBondStatusChange(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, BluetoothDevice bluetoothDevice, int i, int i2, int i3) {
        }

        public static void onHeadSetChange(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, BluetoothDevice bluetoothDevice, boolean z, boolean z2) {
        }

        public static void onLeAudioChange(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, BluetoothDevice bluetoothDevice, boolean z, boolean z2, boolean z3) {
        }

        public static void profileConnectedChanged(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, int i, boolean z) {
        }

        public static boolean matchDeviceEvent(XBluetoothDeviceStateChange xBluetoothDeviceStateChange, BluetoothDevice bluetoothDevice) {
            return Intrinsics.areEqual(bluetoothDevice != null ? bluetoothDevice.getAddress() : null, xBluetoothDeviceStateChange.getMacAddress()) || Intrinsics.areEqual(xBluetoothDeviceStateChange.getMacAddress(), XBluetoothDeviceStateChange.INSTANCE.getIGNORE_ADDRESS());
        }
    }
}
