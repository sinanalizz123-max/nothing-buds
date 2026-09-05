package com.nothing.link.bluetooth.sdk.connect.spp;

import android.util.Log;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.task.XTask;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XSppConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J6\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bj\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\fH\u0016J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u001dH\u0016J\u0018\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001dH\u0016R!\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000bj\b\u0012\u0004\u0012\u00020\u0003`\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/spp/XSppConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/spp/XBaseSppConnector;", "connectUUID", "", ViewKey.TAG, "channel", "", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "(Ljava/lang/String;Ljava/lang/String;ILcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;)V", "ignoreCommand", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getIgnoreCommand", "()Ljava/util/ArrayList;", "reader", "Lcom/nothing/link/bluetooth/sdk/connect/spp/XSppStickReader;", "addIgnoreCommand", "", "command", "getConnectorType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "initParams", "device", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "parserWriterCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "taskId", "dataArray", "", "resIds", "printReceiverLog", "byteArray", "printWriterLog", "receiveByteArray", "readLength", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XSppConnector extends XBaseSppConnector {
    private final ArrayList<String> ignoreCommand;
    private XSppStickReader reader;

    public XSppConnector() {
        this(null, null, 0, null, 15, null);
    }

    public /* synthetic */ XSppConnector(String str, String str2, int i, XDefaultParser xDefaultParser, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "AEAC4A03-DFF5-498F-843A-34487CF133EB" : str, (i2 & 2) != 0 ? "SppWriter" : str2, (i2 & 4) != 0 ? 15 : i, (i2 & 8) != 0 ? new XDefaultParser() : xDefaultParser);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XSppConnector(String connectUUID, String tag, int i, XByteArrayParser parser) {
        super(connectUUID, tag, i, parser);
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.ignoreCommand = CollectionsKt.arrayListOf("29");
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void initParams(XBluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        super.initParams(device);
        this.reader = new XSppStickReader(getParser());
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public XConnectType getConnectorType() {
        return XConnectType.SPP.INSTANCE;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector
    public void receiveByteArray(int readLength, byte[] byteArray) {
        List<XCommand> listEmptyList;
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        XSppStickReader xSppStickReader = this.reader;
        if (xSppStickReader == null || (listEmptyList = xSppStickReader.readByteArray(getConnectUUID(), readLength, byteArray)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Iterator<T> it = listEmptyList.iterator();
        while (it.hasNext()) {
            receiveCallbackCommand(getTaskQueue("TAG").getTaskList(), (XCommand) it.next(), new Function2<XTask, XCommand, Boolean>() { // from class: com.nothing.link.bluetooth.sdk.connect.spp.XSppConnector$receiveByteArray$1$1
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
        return getParser().getWriterCommand(taskId, dataArray, resIds);
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
            String str = "-> Write command=" + command.getCommand() + getParser().getCommandDescribe(command.getCommand()) + ",[" + ((Object) strBytesToHex$default) + "](" + byteArray.length + ")";
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

    public final ArrayList<String> getIgnoreCommand() {
        return this.ignoreCommand;
    }

    public final void addIgnoreCommand(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        if (this.ignoreCommand.contains(command)) {
            return;
        }
        this.ignoreCommand.add(command);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printReceiverLog(String command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (this.ignoreCommand.contains(command)) {
            return;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "<- Receive command=" + command + getParser().getCommandDescribe(command) + ",[" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null) + "](" + byteArray.length + ")";
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
