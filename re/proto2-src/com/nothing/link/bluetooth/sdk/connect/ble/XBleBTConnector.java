package com.nothing.link.bluetooth.sdk.connect.ble;

import com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector;
import kotlin.Metadata;

/* JADX INFO: compiled from: XBleBTConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleBTConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleConnector;", "()V", "createRelationConnector", "Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTConnector;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XBleBTConnector extends XBleConnector {
    public XBleBTConnector() {
        super(null, null, 3, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public XBTConnector createRelationConnector() {
        return new XBTConnector();
    }
}
