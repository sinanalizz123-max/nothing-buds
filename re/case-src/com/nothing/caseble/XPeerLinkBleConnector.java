package com.nothing.caseble;

import android.util.Log;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XPeerLinkBleConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J$\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J6\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0014H\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/nothing/caseble/XPeerLinkBleConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleConnector;", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", ViewKey.TAG, "", "<init>", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;Ljava/lang/String;)V", "setUuids", "", "serviceUuid", "writeUuid", "notifyUuid", "initParams", "device", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "parserWriterCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "taskId", "dataArray", "", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printWriterLog", "command", "byteArray", "printReceiverLog", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class XPeerLinkBleConnector extends XBleConnector {
    /* JADX WARN: Multi-variable type inference failed */
    public XPeerLinkBleConnector() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ XPeerLinkBleConnector(XCaseBleParser xCaseBleParser, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new XCaseBleParser() : xCaseBleParser, (i & 2) != 0 ? "PeerLink" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XPeerLinkBleConnector(XByteArrayParser parser, String tag) {
        super(parser, tag);
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(tag, "tag");
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
        if (getServiceUUID().length() == 0) {
            setServiceUUID(NtPeerLinkBleUuids.SERVICE_UUID);
        }
        if (getWriteUUID().length() == 0) {
            setWriteUUID(NtPeerLinkBleUuids.WRITE_UUID);
        }
        if (getNotifyUUID().length() == 0) {
            setNotifyUUID(NtPeerLinkBleUuids.NOTIFY_UUID);
        }
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
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[PeerLink] -> Write " + getTag() + " [" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null) + "](" + byteArray.length + ")";
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

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector, com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printReceiverLog(String command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[PeerLink] <- Receive " + getTag() + " [" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null) + "](" + byteArray.length + ")";
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
}
