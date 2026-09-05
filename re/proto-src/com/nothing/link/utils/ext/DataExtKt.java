package com.nothing.link.utils.ext;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: DataExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\n\u0010\u0002\u001a\u00020\u0003*\u00020\u0004\u001a\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u0007\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\n*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u0012\u0010\u000b\u001a\u00020\f*\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004\u001a\u0014\u0010\u000e\u001a\u00020\u0004*\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0001\u001a\n\u0010\u000e\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0010\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\u0010\u001a\u00020\u0003*\u00020\u0001\u001a\u001e\u0010\u0011\u001a\u00020\u0001*\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"MASK_BYTE", "", "contentToHexString", "", "", "getIntOrNull", "index", "([BI)Ljava/lang/Integer;", "getIntOrZero", "getLongOrZero", "", "startWith", "", "temp", "toByteArray", "length", "toHexString", "toInt", "offset", "nothinglink-utils_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DataExtKt {
    public static final int MASK_BYTE = 255;

    public static final String contentToHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) new Function1<Byte, CharSequence>() { // from class: com.nothing.link.utils.ext.DataExtKt.contentToHexString.1
            public final CharSequence invoke(byte b) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
                return str;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Byte b) {
                return invoke(b.byteValue());
            }
        }, 24, (Object) null) + "(size:" + bArr.length + ")";
    }

    public static /* synthetic */ int toInt$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return toInt(bArr, i, i2);
    }

    public static final int toInt(byte[] bArr, int i, int i2) {
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

    public static final int getIntOrZero(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte orNull = ArraysKt.getOrNull(bArr, i);
        if (orNull != null) {
            return orNull.byteValue() & 255;
        }
        return 0;
    }

    public static final Integer getIntOrNull(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte orNull = ArraysKt.getOrNull(bArr, i);
        if (orNull != null) {
            return Integer.valueOf(orNull.byteValue() & 255);
        }
        return null;
    }

    public static final boolean startWith(byte[] bArr, byte[] temp) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(temp, "temp");
        if (bArr.length < temp.length) {
            return false;
        }
        int length = temp.length;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != temp[i]) {
                return false;
            }
        }
        return true;
    }

    public static final String toHexString(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("0x%02X", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(format, *args)");
        return str;
    }

    public static /* synthetic */ byte[] toByteArray$default(long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 4;
        }
        return toByteArray(j, i);
    }

    public static final byte[] toByteArray(long j, int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                j >>= 8;
            }
            bArr[i2] = (byte) (255 & j);
        }
        return bArr;
    }

    public static final long getLongOrZero(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte orNull = ArraysKt.getOrNull(bArr, i);
        if (orNull != null) {
            return ((long) orNull.byteValue()) & 255;
        }
        return 0L;
    }

    public static final String toHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        String str = "";
        for (byte b : bArr) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
            str = str + str2;
        }
        return str;
    }

    public static final byte[] toByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            String strSubstring = str.substring(i2, i2 + 2);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            bArr[i] = (byte) Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
        }
        return bArr;
    }
}
