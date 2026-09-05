package com.nothing.link.bluetooth.sdk.connect.ble;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.util.Log;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.caseble.NtPeerLinkBleUuids;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.task.XTask;
import com.nothing.link.bluetooth.sdk.task.XTaskQueue;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBleConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\"\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J6\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00112\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0018\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0011H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBaseBleConnector;", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", ViewKey.TAG, "", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;Ljava/lang/String;)V", "initParams", "", "device", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "onNotifyCharacteristicChanged", "gatt", "Landroid/bluetooth/BluetoothGatt;", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "value", "", "parserWriterCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "taskId", "dataArray", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "printReceiverLog", "command", "byteArray", "printWriterLog", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XBleConnector extends XBaseBleConnector {
    /* JADX WARN: Multi-variable type inference failed */
    public XBleConnector() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ XBleConnector(XDefaultParser xDefaultParser, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new XDefaultParser() : xDefaultParser, (i & 2) != 0 ? "BleWriter" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XBleConnector(XByteArrayParser parser, String tag) {
        super(parser, tag);
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(tag, "tag");
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void initParams(XBluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        super.initParams(device);
        setWriteUUID(NtPeerLinkBleUuids.WRITE_UUID);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector
    public XCommand parserWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        return getParser().getWriterCommand(taskId, dataArray, resIds);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onNotifyCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] value) {
        Object objM6347constructorimpl;
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(value, "value");
        String string = characteristic.getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        XTaskQueue taskQueue = getTaskQueue(string);
        try {
            Result.Companion companion = Result.INSTANCE;
            XByteArrayParser parser = getParser();
            String string2 = characteristic.getUuid().toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            objM6347constructorimpl = Result.m6347constructorimpl(parser.getReceiveCommand(string2, 0, value));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = getTag() + " parser error " + thM6350exceptionOrNullimpl.getMessage() + "!";
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
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
        if (Result.m6353isFailureimpl(objM6347constructorimpl)) {
            objM6347constructorimpl = null;
        }
        XCommand xCommand = (XCommand) objM6347constructorimpl;
        if (xCommand == null || xCommand.getCommand().length() == 0) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = getTag() + " command is null ,parser error!";
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str6 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            xCommand = new XCommand(ExternalParsersConfigReaderMetKeys.PARSER_TAG, 0, 0, false, 0, 0, 0, value, null, null, 894, null);
        }
        receiveCallbackCommand(taskQueue.getTaskList(), xCommand, new Function2<XTask, XCommand, Boolean>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector.onNotifyCharacteristicChanged.2
            @Override // kotlin.jvm.functions.Function2
            public final Boolean invoke(XTask xTask, XCommand xCommand2) {
                Intrinsics.checkNotNullParameter(xTask, "xTask");
                return Boolean.valueOf(xTask.isMatchTask(xCommand2));
            }
        });
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printWriterLog(XCommand command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "-> Write " + getTag() + " command=" + command.getCommand() + getParser().getCommandDescribe(command.getCommand()) + ",[" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null) + "](" + byteArray.length + ")";
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
            String str = "<- Receive " + getTag() + " command=" + command + getParser().getCommandDescribe(command) + ",[" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray, false, 2, null) + "](" + byteArray.length + ")";
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
