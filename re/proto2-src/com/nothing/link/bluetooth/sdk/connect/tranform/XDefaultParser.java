package com.nothing.link.bluetooth.sdk.connect.tranform;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: XDefaultParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J6\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0012H\u0016J\"\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0016J6\u0010\u0017\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\f2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0012H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u0016*\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016J\n\u0010\u001b\u001a\u00020\u0005*\u00020\u0016J\u001e\u0010\u001c\u001a\u00020\u0016*\u00020\f2\b\b\u0002\u0010\u001d\u001a\u00020\u00162\b\b\u0002\u0010\u001e\u001a\u00020\u0016R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006 "}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/tranform/XDefaultParser;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "()V", "otaMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getOtaMap", "()Ljava/util/HashMap;", "getOTAReceiveCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "byteArray", "", "getOTAWriterResponseCommand", "taskId", "dataArray", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getReceiveCommand", "uuid", "index", "", "getWriterCommand", "initOTAMap", "", "getIntOrZero", "toHexString", "toInt", "offset", "length", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XDefaultParser implements XByteArrayParser {
    public static final int DEFAULT_SOF = 85;
    public static final int MASK_BYTE = 255;
    private static final int MASK_CRC = 32;
    private static final int MASK_REQUEST_CMD = 32768;
    private final HashMap<String, String> otaMap = new HashMap<>();

    public XDefaultParser() {
        initOTAMap();
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public String getCommandDescribe(String str) {
        return XByteArrayParser.DefaultImpls.getCommandDescribe(this, str);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public String getOTACommandDescribe(String str) {
        return XByteArrayParser.DefaultImpls.getOTACommandDescribe(this, str);
    }

    public final HashMap<String, String> getOtaMap() {
        return this.otaMap;
    }

    public void initOTAMap() {
        this.otaMap.put("0x80", "0x81");
        this.otaMap.put("0x82", "0x83");
        this.otaMap.put("0x85", "0x8B");
        this.otaMap.put("0x88", "0x84");
        this.otaMap.put("0x86", "0x87");
        this.otaMap.put("0x8C", "0x8D");
        this.otaMap.put("0x8E", "0x8F");
        this.otaMap.put("0x89", "0x8A");
        this.otaMap.put("0x90", "0x91");
        this.otaMap.put("0x92", "0x93");
        this.otaMap.put("0x97", "0x98");
        this.otaMap.put("0x99", "0x9A");
        this.otaMap.put("0x9D", "0x9D");
        this.otaMap.put("0x9B", "0x9B");
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getReceiveCommand(String uuid, int index, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        if (toInt(byteArray, index, 1) != 85) {
            return null;
        }
        int length = byteArray.length;
        if (length < index + 8) {
            return new XCommand(null, 0, 0, true, 0, 0, 0, ArraysKt.copyOfRange(byteArray, index, byteArray.length), uuid, null, 631, null);
        }
        int i = toInt(byteArray, index + 1, 2);
        int i2 = toInt(byteArray, index + 3, 2) | 32768;
        boolean z = (i & 32) != 0;
        int i3 = toInt(byteArray, index + 5, 2);
        int i4 = toInt(byteArray, index + 7, 1);
        int i5 = i3 + 8;
        if (i5 != length && z) {
            i5 = i3 + 10;
        }
        return new XCommand(toHexString(i2), i4, i5, false, i3, 0, 0, ArraysKt.copyOfRange(byteArray, index, Math.min(index + i5, length)), uuid, null, TypedValues.MotionType.TYPE_DRAW_PATH, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        if (dataArray.length < 8) {
            return new XCommand(null, 0, 0, false, 0, 0, 0, null, null, null, 1023, null);
        }
        int i = toInt(dataArray, 3, 2);
        int i2 = toInt(dataArray, 5, 2);
        return new XCommand(taskId == null ? toHexString(i) : taskId, toInt(dataArray, 7, 1), dataArray.length, false, i2, 0, 0, dataArray, null, resIds, 360, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getOTAWriterResponseCommand(String taskId, byte[] dataArray, ArrayList<String> resIds) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        String hexString = toHexString(getIntOrZero(dataArray, 0));
        String str = this.otaMap.get(hexString);
        if (str != null) {
            hexString = str;
        }
        Intrinsics.checkNotNull(hexString);
        String str2 = hexString;
        if (taskId != null) {
            str2 = taskId;
        }
        return new XCommand(str2, 0, 0, false, 0, 0, 0, dataArray, null, resIds, 382, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser
    public XCommand getOTAReceiveCommand(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        return new XCommand(toHexString(getIntOrZero(byteArray, 0)), 0, 0, false, 0, 0, 0, byteArray, null, null, 894, null);
    }

    public final String toHexString(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("0x%02X", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static /* synthetic */ int toInt$default(XDefaultParser xDefaultParser, byte[] bArr, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toInt");
        }
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return xDefaultParser.toInt(bArr, i, i2);
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
        IntProgression intProgressionReversed = RangesKt.reversed(RangesKt.until(i, Math.min(bArr.length, i2 + i)));
        int first = intProgressionReversed.getFirst();
        int last = intProgressionReversed.getLast();
        int step = intProgressionReversed.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                intOrZero = (intOrZero << 8) | getIntOrZero(bArr, first);
                if (first == last) {
                    break;
                }
                first += step;
            }
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
}
