package com.nothing.link.bluetooth.sdk.connect.ble;

import android.bluetooth.BluetoothDevice;
import com.nothing.link.bluetooth.sdk.connect.XBondConnector;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;

/* JADX INFO: compiled from: XBleAudioConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u000e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J*\u0010\u000f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleAudioConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleConnector;", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;)V", "getConnectorType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "onA2DPChange", "", "device", "Landroid/bluetooth/BluetoothDevice;", "a2dpConnect", "", "headsetConnect", "onHeadSetChange", "onLeAudioChange", "leAudioConnect", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBleAudioConnector extends XBleConnector {
    /* JADX WARN: Multi-variable type inference failed */
    public XBleAudioConnector() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XBleAudioConnector(XByteArrayParser parser) {
        super(parser, null, 2, null);
        Intrinsics.checkNotNullParameter(parser, "parser");
    }

    public /* synthetic */ XBleAudioConnector(XDefaultParser xDefaultParser, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new XDefaultParser() : xDefaultParser);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public XConnectType getConnectorType() {
        return XConnectType.LEAudio.INSTANCE;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onLeAudioChange(BluetoothDevice device, boolean leAudioConnect, boolean a2dpConnect, boolean headsetConnect) {
        if (leAudioConnect) {
            XBondConnector.checkParameterAndStartConnectJob$default(this, false, null, 1, null);
        } else {
            XBaseBleConnector.onBleDisconnected$default(this, "leAudio disconnect!", null, null, 6, null);
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onA2DPChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (headsetConnect || a2dpConnect) {
            return;
        }
        XBTReceiverHelper mBTHelper = getMBTHelper();
        XBluetoothDevice mBleDevice = getMBleDevice();
        if (mBTHelper.isLeConnected(mBleDevice != null ? mBleDevice.getDeviceInfo() : null)) {
            return;
        }
        XBaseBleConnector.onBleDisconnected$default(this, "a2dp disconnected", null, null, 6, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onHeadSetChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (headsetConnect || a2dpConnect) {
            return;
        }
        XBTReceiverHelper mBTHelper = getMBTHelper();
        XBluetoothDevice mBleDevice = getMBleDevice();
        if (mBTHelper.isLeConnected(mBleDevice != null ? mBleDevice.getDeviceInfo() : null)) {
            return;
        }
        XBaseBleConnector.onBleDisconnected$default(this, "a2dp disconnected", null, null, 6, null);
    }
}
