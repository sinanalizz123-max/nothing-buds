package com.nothing.link.bluetooth.sdk.connect.spp;

import android.util.Log;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import io.flutter.plugin.editing.SpellCheckPlugin;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XSppStickReader.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\"\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004\u00a8\u0006\u001b"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/spp/XSppStickReader;", "", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;)V", "lastCache", "", "getParser", "()Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "setParser", "parseToListCommand", "", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "connectUUID", "", "byteArray", "printSplitLog", "", SpellCheckPlugin.START_INDEX_KEY, "", SpellCheckPlugin.END_INDEX_KEY, "totalSize", "packet", "printStickLog", "stickPackage", "readByteArray", "readLength", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XSppStickReader {
    private byte[] lastCache;
    private XByteArrayParser parser;

    public XSppStickReader(XByteArrayParser parser) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.parser = parser;
    }

    public final XByteArrayParser getParser() {
        return this.parser;
    }

    public final void setParser(XByteArrayParser xByteArrayParser) {
        Intrinsics.checkNotNullParameter(xByteArrayParser, "<set-?>");
        this.parser = xByteArrayParser;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0033  */
    public final List<XCommand> readByteArray(String connectUUID, int readLength, byte[] byteArray) {
        String str;
        String str2;
        String str3;
        byte[] byteArray2 = byteArray;
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        Intrinsics.checkNotNullParameter(byteArray2, "byteArray");
        Logger logger = Logger.INSTANCE;
        boolean zCanWrite = XBluetoothManager.INSTANCE.get().canWrite(byteArray2);
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(zCanWrite)) {
            String str4 = "<- Receive SPP [" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, byteArray2, false, 2, null) + "](" + readLength + ")";
            String str5 = str4;
            if (str5 == null || str5.length() == 0) {
                str2 = StringUtils.SPACE;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                if (zCanWrite) {
                    FileLog fileLog = FileLog.INSTANCE;
                    String str6 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    String str7 = str4 + StringUtils.SPACE + strComponent2;
                    str3 = strComponent1;
                    str2 = StringUtils.SPACE;
                    str = str4;
                    FileLog.print$default(fileLog, 3, str6, tag, str7, null, 16, null);
                } else {
                    str = str4;
                    str2 = StringUtils.SPACE;
                    str3 = strComponent1;
                }
                if (logger.isDebug()) {
                    Log.i(tag + str3, str + str2 + strComponent2);
                }
            }
        } else {
            str2 = StringUtils.SPACE;
        }
        byte[] bArr = this.lastCache;
        int length = bArr != null ? bArr.length : 0;
        if (length > 0) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str8 = "cacheSize " + length + ",cacheData:" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, this.lastCache, false, 2, null);
                String str9 = str8;
                if (str9 != null && str9.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str10 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    FileLog.print$default(fileLog2, 3, str10, tag2, str8 + str2 + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str8 + str2 + strComponent4);
                    }
                }
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteArray2.length + length);
                byte[] bArr2 = this.lastCache;
                if (bArr2 != null) {
                    byteBufferAllocate.put(bArr2);
                }
                byteBufferAllocate.put(byteArray2);
                byte[] bArrArray = byteBufferAllocate.array();
                Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
                try {
                    Result.m6347constructorimpl(Unit.INSTANCE);
                    byteArray2 = bArrArray;
                } catch (Throwable th) {
                    th = th;
                    byteArray2 = bArrArray;
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m6347constructorimpl(ResultKt.createFailure(th));
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return parseToListCommand(connectUUID, byteArray2);
    }

    public final List<XCommand> parseToListCommand(String connectUUID, byte[] byteArray) {
        byte[] data;
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        ArrayList arrayList = new ArrayList();
        int length = byteArray.length;
        int i = 0;
        while (true) {
            XCommand receiveCommand = this.parser.getReceiveCommand(connectUUID, i, byteArray);
            int length2 = receiveCommand != null ? receiveCommand.getLength() : 0;
            if (receiveCommand != null && receiveCommand.isValid()) {
                arrayList.add(receiveCommand);
                i += length2;
                if (i >= length) {
                    break;
                }
                printSplitLog(i, length2, length, receiveCommand.getData());
            } else {
                if (receiveCommand == null || !receiveCommand.hasStickData()) {
                    break;
                }
                data = receiveCommand.getData();
                printStickLog(i, length, data);
                this.lastCache = data;
                return arrayList;
            }
        }
        data = null;
        this.lastCache = data;
        return arrayList;
    }

    private final void printStickLog(int startIndex, int totalSize, byte[] stickPackage) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Receive split stickPackage[" + startIndex + "," + totalSize + "]:" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, stickPackage, false, 2, null);
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

    private final void printSplitLog(int startIndex, int endIndex, int totalSize, byte[] packet) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Receive split packet[" + startIndex + "," + endIndex + "] totalSize=" + totalSize + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + BleUtil.bytesToHex$default(BleUtil.INSTANCE, packet, false, 2, null);
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
