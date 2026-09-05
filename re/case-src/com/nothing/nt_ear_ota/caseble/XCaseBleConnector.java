package com.nothing.nt_ear_ota.caseble;

import android.util.Log;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;

/* JADX INFO: compiled from: XCaseBleConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J$\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J6\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u000bH\u0016J\u0018\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u000bH\u0016\u00a8\u0006 "}, d2 = {"Lcom/nothing/nt_ear_ota/caseble/XCaseBleConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleConnector;", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", ViewKey.TAG, "", "<init>", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;Ljava/lang/String;)V", "opcodeOf", "", "bytes", "", "setUuids", "", "serviceUuid", "writeUuid", "notifyUuid", "initParams", "device", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "parserWriterCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "taskId", "dataArray", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printWriterLog", "command", "byteArray", "printReceiverLog", "Companion", "nt_ear_ota_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XCaseBleConnector extends XBleConnector {
    private static final String TAG = "NtEarOtaCaseBle";

    /* JADX WARN: Multi-variable type inference failed */
    public XCaseBleConnector() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ XCaseBleConnector(XCaseBleParser xCaseBleParser, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new XCaseBleParser() : xCaseBleParser, (i & 2) != 0 ? TAG : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XCaseBleConnector(XByteArrayParser parser, String tag) {
        super(parser, tag);
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    private final int opcodeOf(byte[] bytes) {
        if (bytes.length == 0) {
            return -1;
        }
        return bytes[0] & 255;
    }

    public final void setUuids(String serviceUuid, String writeUuid, String notifyUuid) {
        if (serviceUuid != null) {
            if (serviceUuid.length() <= 0) {
                serviceUuid = null;
            }
            if (serviceUuid != null) {
                setServiceUUID(serviceUuid);
            }
        }
        if (writeUuid != null) {
            if (writeUuid.length() <= 0) {
                writeUuid = null;
            }
            if (writeUuid != null) {
                setWriteUUID(writeUuid);
            }
        }
        if (notifyUuid != null) {
            if (notifyUuid.length() <= 0) {
                notifyUuid = null;
            }
            if (notifyUuid != null) {
                setNotifyUUID(notifyUuid);
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector, com.nothing.link.bluetooth.sdk.connect.XConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void initParams(XBluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        super.initParams(device);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector, com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector
    public XCommand parserWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        return getParser().getWriterCommand(taskId, dataArray, resIds);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector, com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printWriterLog(XCommand command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (opcodeOf(byteArray) == 133) {
            return;
        }
        Log.d(TAG, "-> Write " + getTag() + " [" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null) + "](" + byteArray.length + ")");
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector, com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printReceiverLog(String command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Log.d(TAG, "<- Receive " + getTag() + " [" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null) + "](" + byteArray.length + ")");
    }
}
