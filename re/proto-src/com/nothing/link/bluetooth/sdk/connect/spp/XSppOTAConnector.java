package com.nothing.link.bluetooth.sdk.connect.spp;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.task.XTask;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XSppOTAConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\"\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\"\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J6\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0018H\u0016J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0018H\u0016\u00a8\u0006\""}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/spp/XSppOTAConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/spp/XBaseSppConnector;", "connectUUID", "", ViewKey.TAG, "channel", "", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "(Ljava/lang/String;Ljava/lang/String;ILcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;)V", "getConnectorType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "onA2DPChange", "", "device", "Landroid/bluetooth/BluetoothDevice;", "a2dpConnect", "", "headsetConnect", "onHeadSetChange", "parserWriterCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "taskId", "dataArray", "", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printReceiverLog", "command", "byteArray", "printWriterLog", "receiveByteArray", "readLength", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XSppOTAConnector extends XBaseSppConnector {
    public XSppOTAConnector() {
        this(null, null, 0, null, 15, null);
    }

    public /* synthetic */ XSppOTAConnector(String str, String str2, int i, XDefaultParser xDefaultParser, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "66666666-6666-6666-6666-666666666666" : str, (i2 & 2) != 0 ? "SppOTAWriter" : str2, (i2 & 4) != 0 ? 13 : i, (i2 & 8) != 0 ? new XDefaultParser() : xDefaultParser);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XSppOTAConnector(String connectUUID, String tag, int i, XByteArrayParser parser) {
        super(connectUUID, tag, i, parser);
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(parser, "parser");
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public XConnectType getConnectorType() {
        return XConnectType.SppOTA.INSTANCE;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector
    public void receiveByteArray(int readLength, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (readLength > 0) {
            receiveCallbackCommand(getTaskQueue("TAG").getTaskList(), getParser().getOTAReceiveCommand(byteArray), new Function2<XTask, XCommand, Boolean>() { // from class: com.nothing.link.bluetooth.sdk.connect.spp.XSppOTAConnector.receiveByteArray.1
                @Override // kotlin.jvm.functions.Function2
                public final Boolean invoke(XTask xTask, XCommand xCommand) {
                    Intrinsics.checkNotNullParameter(xTask, "xTask");
                    return Boolean.valueOf(xTask.isMatchTask(xCommand));
                }
            });
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector
    public XCommand parserWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        return getParser().getOTAWriterResponseCommand(taskId, dataArray, resIds);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printWriterLog(XCommand command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        String strBytesToHex$default = BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null);
        if (strBytesToHex$default.length() > 300) {
            strBytesToHex$default = strBytesToHex$default.substring(0, 300);
            Intrinsics.checkNotNullExpressionValue(strBytesToHex$default, "substring(...)");
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "-> Write command=" + command.getCommand() + getParser().getOTACommandDescribe(command.getCommand()) + ",[" + ((Object) strBytesToHex$default) + "](" + byteArray.length + ")";
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

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printReceiverLog(String command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "<- Receive command=" + command + getParser().getOTACommandDescribe(command) + ",[" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null) + "](" + byteArray.length + ")";
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

    @Override // com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onHeadSetChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (getProfileType() == 0) {
            if (headsetConnect || a2dpConnect) {
                return;
            }
            onSppDisconnected();
            return;
        }
        if (getProfileType() != 1 || headsetConnect) {
            return;
        }
        onSppDisconnected();
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onA2DPChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (getProfileType() == 0) {
            if (a2dpConnect || headsetConnect) {
                return;
            }
            onSppDisconnected();
            return;
        }
        if (getProfileType() != 2 || a2dpConnect) {
            return;
        }
        onSppDisconnected();
    }
}
