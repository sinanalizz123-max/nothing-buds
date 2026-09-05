package com.nothing.nt_ble;

import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WatchCommandParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J6\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000eH\u0016J\"\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J6\u0010\u0013\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000eH\u0016J\u0014\u0010\u0014\u001a\u00020\n*\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u0012J\u001e\u0010\u0016\u001a\u00020\u0012*\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00122\b\b\u0002\u0010\u0018\u001a\u00020\u0012J\u0012\u0010\u0019\u001a\u00020\u0012*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/nt_ble/WatchCommandParser;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "<init>", "()V", "getOTAReceiveCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "byteArray", "", "getOTAWriterResponseCommand", "taskId", "", "dataArray", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getReceiveCommand", "uuid", "index", "", "getWriterCommand", "toHexString", "padTo", "toInt", "offset", "length", "getIntOrZero", "getCommandDescribe", "command", "getOTACommandDescribe", "nt_ble_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class WatchCommandParser implements XByteArrayParser {
    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getOTAReceiveCommand(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return new XCommand("ota_res", 0, 0, false, 0, 0, 0, byteArray, null, null, 894, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getOTAWriterResponseCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        if (taskId == null) {
            taskId = "ota_write";
        }
        return new XCommand(taskId, 0, 0, false, 0, 0, 0, dataArray, null, resIds, 382, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getReceiveCommand(String uuid, int index, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        int length = byteArray.length;
        int i = toInt(byteArray, index, 1);
        if (i != 245) {
            return new XCommand(String.valueOf(i), 0, length, false, length, 1, 1, byteArray, uuid, null, 522, null);
        }
        int i2 = toInt(byteArray, index + 1, 2);
        return new XCommand(toHexString$default(this, toInt(byteArray, index + 3, 2), 0, 1, null) + "_" + toHexString$default(this, toInt(byteArray, index + 9, 2), 0, 1, null), 0, i2 + 11, false, i2, toInt(byteArray, index + 5, 2), toInt(byteArray, index + 7, 2), byteArray, uuid, null, 522, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        String str;
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        int length = dataArray.length;
        int i = toInt(dataArray, 1, 2);
        int i2 = toInt(dataArray, 3, 2);
        int i3 = toInt(dataArray, 5, 2);
        int i4 = toInt(dataArray, 7, 2);
        int i5 = toInt(dataArray, 9, 2);
        ArraysKt.copyOfRange(dataArray, 0, Math.min(11, length));
        if (taskId == null) {
            str = toHexString$default(this, i2, 0, 1, null) + "_" + toHexString$default(this, i5, 0, 1, null);
        } else {
            str = taskId;
        }
        return new XCommand(str, 0, length, false, i, i3, i4, dataArray, null, resIds, 266, null);
    }

    public static /* synthetic */ String toHexString$default(WatchCommandParser watchCommandParser, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toHexString");
        }
        if ((i3 & 1) != 0) {
            i2 = 4;
        }
        return watchCommandParser.toHexString(i, i2);
    }

    public final String toHexString(int i, int i2) {
        String string = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
        String upperCase = string.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return "0x" + StringsKt.padStart(upperCase, i2, '0');
    }

    public static /* synthetic */ int toInt$default(WatchCommandParser watchCommandParser, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toInt");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return watchCommandParser.toInt(bArr, i, i2);
    }

    public final int toInt(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int intOrZero = 0;
        if (i > ArraysKt.getLastIndex(bArr)) {
            return 0;
        }
        if (i2 <= 1) {
            return getIntOrZero(bArr, i);
        }
        int iMin = Math.min(bArr.length, i2 + i);
        while (i < iMin) {
            intOrZero = getIntOrZero(bArr, i) | (intOrZero << 8);
            i++;
        }
        return intOrZero;
    }

    public final int getIntOrZero(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte orNull = ArraysKt.getOrNull(bArr, i);
        if (orNull != null) {
            return orNull.byteValue() & 255;
        }
        return 0;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public String getCommandDescribe(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        String str = CommandDescribe.INSTANCE.getWatchDescribeMap().get(command);
        if (str == null) {
            str = "";
        }
        return str.length() > 0 ? ",desc=" + str : "";
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public String getOTACommandDescribe(String command) {
        Intrinsics.checkNotNullParameter(command, "command");
        String str = CommandDescribe.INSTANCE.getWatchOtaDescribeMap().get(command);
        if (str == null) {
            str = "";
        }
        return str.length() > 0 ? ",desc=" + str : "";
    }
}
