package com.nothing.base.util.ext;

import android.util.SparseArray;
import androidx.exifinterface.media.ExifInterface;
import com.nothing.base.util.BigDecimalUtil;
import com.nothing.news_service.network.NewsNetworkManager;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: DataExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0001\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\b\u001a\u0019\u0010\t\u001a\u0004\u0018\u00010\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\u000b\u001a\u0012\u0010\f\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0004\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0001\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0086\u0004\u001a\n\u0010\u0012\u001a\u00020\u0004*\u00020\u0016\u001a\n\u0010\u0012\u001a\u00020\u0004*\u00020\u001a\u001a\u001e\u0010\u001b\u001a\u00020\u0002*\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u001a(\u0010\u001c\u001a\u00020\u0016*\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u001d\u001a\u00020\u0002\u001a\u001e\u0010\u001e\u001a\u00020\u001a*\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u001a\u001e\u0010\u001f\u001a\u00020\u0010*\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u001a$\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\b*\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u0002\u001a:\u0010#\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020$0\b*\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u0002\u001a\u001c\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040$0\b*\u00020\u0004\u001aJ\u0010'\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020(0\b*\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u0002\u001a:\u0010,\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020(*\u00020\u00042\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u0002\u001a&\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\b*\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\u00022\n\u0010/\u001a\u00020.\"\u00020\u0002\u001af\u00100\u001a\b\u0012\u0004\u0012\u0002H201\"\b\b\u0000\u00102*\u000203*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020$0\b28\u00104\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(9\u0012\u0006\u0012\u0004\u0018\u0001H205\u001a\u0012\u0010:\u001a\u00020\u0015*\u00020\u00042\u0006\u0010;\u001a\u00020\u0004\u001a\n\u0010<\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010=\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010>\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010?\u001a\u00020\u0015*\u00020\u00012\u0006\u0010@\u001a\u00020\u0001\"\u000e\u0010\u0017\u001a\u00020\u0002X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\u0002X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0002X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006A"}, d2 = {"toHexString", "", "", "contentToHexString", "", "macString", "capitalizedString", "toStr", "", "getIntOrNull", "index", "([BI)Ljava/lang/Integer;", "getIntOrZero", "getInt16", "offset", "getLongOrZero", "", "toMD5", "toByteArray", "length", MimeTypesReaderMetKeys.MATCH_MASK_ATTR, "", "", "EIGHT", "SEVEN", "TWO", "", "toInt", "toFloat", "decimalPoint", "toDouble", "toLong", "toValues", "sizeLen", "valueLen", "toPairs", "Lkotlin/Pair;", "keyLen", "toPairsByte", "toTriples", "Lkotlin/Triple;", "firstLen", "secondLen", "thirdLen", "toTriple", "toMultiValues", "", "len", "toSparseArray", "Landroid/util/SparseArray;", ExifInterface.GPS_DIRECTION_TRUE, "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "key", "value", "startWith", "temp", "firstUpper", "hexToInt", "textCapSentences", "compareVersion", "targetStr", "nt_ear_GoogleStoreRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class DataExtKt {
    private static final int EIGHT = 8;
    private static final int SEVEN = 7;
    private static final int TWO = 2;

    public static final boolean mask(int i, int i2) {
        return (i & i2) != 0;
    }

    public static final String toHexString(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("0x%02X", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String contentToHexString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, new Function1() { // from class: com.nothing.base.util.ext.DataExtKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DataExtKt.contentToHexString$lambda$0(((Byte) obj).byteValue());
            }
        }, 24, (Object) null) + "(size:" + bArr.length + ")";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence contentToHexString$lambda$0(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String macString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return ArraysKt.joinToString$default(bArr, (CharSequence) TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.nothing.base.util.ext.DataExtKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DataExtKt.macString$lambda$1(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence macString$lambda$1(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String capitalizedString(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return firstUpper(str);
    }

    public static final String toStr(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int iIntValue = ((Number) obj).intValue();
            if (i != 0) {
                sb.append(",");
            }
            sb.append(iIntValue);
            i = i2;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final Integer getIntOrNull(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte orNull = ArraysKt.getOrNull(bArr, i);
        if (orNull != null) {
            return Integer.valueOf(orNull.byteValue() & 255);
        }
        return null;
    }

    public static final int getIntOrZero(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte orNull = ArraysKt.getOrNull(bArr, i);
        if (orNull != null) {
            return orNull.byteValue() & 255;
        }
        return 0;
    }

    public static final int getInt16(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return (bArr[i] & 255) | (bArr[i + 1] << 8);
    }

    public static final long getLongOrZero(byte[] bArr, int i) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Byte orNull = ArraysKt.getOrNull(bArr, i);
        if (orNull != null) {
            return ((long) orNull.byteValue()) & 255;
        }
        return 0L;
    }

    public static final String toMD5(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        byte[] bArrDigest = MessageDigest.getInstance(NewsNetworkManager.MD5).digest(bArr);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.nothing.base.util.ext.DataExtKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DataExtKt.toMD5$lambda$3(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toMD5$lambda$3(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String toMD5(String str) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance(NewsNetworkManager.MD5);
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
        return ArraysKt.joinToString$default(bArrDigest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: com.nothing.base.util.ext.DataExtKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DataExtKt.toMD5$lambda$4(((Byte) obj).byteValue());
            }
        }, 30, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence toMD5$lambda$4(byte b) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static /* synthetic */ byte[] toByteArray$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 2;
        }
        return toByteArray(i, i2);
    }

    public static final byte[] toByteArray(int i, int i2) {
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                i >>= 8;
            }
            bArr[i3] = (byte) (i & 255);
        }
        return bArr;
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

    public static final byte[] toByteArray(float f) {
        byte[] bArrArray = ByteBuffer.allocate(4).putFloat(f).array();
        Intrinsics.checkNotNull(bArrArray);
        ArraysKt.reverse(bArrArray);
        return bArrArray;
    }

    public static final byte[] toByteArray(double d) {
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d);
        byte[] bArr = new byte[8];
        for (int i = 0; i < 8; i++) {
            bArr[i] = (byte) ((jDoubleToRawLongBits >> (i * 8)) & 255);
        }
        return bArr;
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

    public static /* synthetic */ float toFloat$default(byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 0;
        }
        if ((i4 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i4 & 4) != 0) {
            i3 = 2;
        }
        return toFloat(bArr, i, i2, i3);
    }

    public static final float toFloat(byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i > ArraysKt.getLastIndex(bArr)) {
            return 0.0f;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(ArraysKt.copyOfRange(bArr, i, Math.min(bArr.length, i2 + i)));
        byte[] bArrArray = byteBufferWrap.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        ArraysKt.reverse(bArrArray);
        byteBufferWrap.rewind();
        return BigDecimalUtil.toFloat(String.valueOf(byteBufferWrap.getFloat()), i3);
    }

    public static /* synthetic */ double toDouble$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return toDouble(bArr, i, i2);
    }

    public static final double toDouble(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        if (i > ArraysKt.getLastIndex(bArr)) {
            return 0.0d;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(ArraysKt.copyOfRange(bArr, i, Math.min(bArr.length, i2 + i)));
        long j = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j |= ((long) byteBufferWrap.get(i3)) << (i3 * 8);
        }
        return Double.longBitsToDouble(j);
    }

    public static /* synthetic */ long toLong$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        return toLong(bArr, i, i2);
    }

    public static final long toLong(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        long longOrZero = 0;
        if (i > ArraysKt.getLastIndex(bArr)) {
            return 0L;
        }
        if (i2 <= 1) {
            return getLongOrZero(bArr, i);
        }
        IntProgression intProgressionReversed = RangesKt.reversed(RangesKt.until(i, Math.min(bArr.length, i2 + i)));
        int first = intProgressionReversed.getFirst();
        int last = intProgressionReversed.getLast();
        int step = intProgressionReversed.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                longOrZero = (longOrZero << 8) | getLongOrZero(bArr, first);
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        return longOrZero;
    }

    public static /* synthetic */ List toValues$default(byte[] bArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        return toValues(bArr, i, i2);
    }

    public static final List<Integer> toValues(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i3 = toInt(bArr, 0, i);
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            arrayList.add(Integer.valueOf(toInt(bArr, (i4 * i2) + i, i2)));
        }
        return arrayList;
    }

    public static /* synthetic */ List toPairs$default(byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 1;
        }
        if ((i4 & 2) != 0) {
            i2 = 1;
        }
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        return toPairs(bArr, i, i2, i3);
    }

    public static final List<Pair<Integer, Integer>> toPairs(byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i4 = toInt(bArr, 0, i);
        int i5 = i2 + i3;
        ArrayList arrayList = new ArrayList(i4);
        for (int i6 = 0; i6 < i4; i6++) {
            int i7 = (i6 * i5) + i;
            arrayList.add(TuplesKt.to(Integer.valueOf(toInt(bArr, i7, i2)), Integer.valueOf(toInt(bArr, i7 + i2, i3))));
        }
        return arrayList;
    }

    public static final List<Pair<Integer, byte[]>> toPairsByte(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int intOrZero = getIntOrZero(bArr, 0);
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (i < intOrZero) {
            int intOrZero2 = getIntOrZero(bArr, i);
            int intOrZero3 = getIntOrZero(bArr, i + 1);
            int i2 = i + 2;
            int i3 = intOrZero3 + i2;
            arrayList.add(TuplesKt.to(Integer.valueOf(intOrZero2), ArraysKt.copyOfRange(bArr, i2, i3)));
            i = i3;
        }
        return arrayList;
    }

    public static /* synthetic */ List toTriples$default(byte[] bArr, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = 1;
        }
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = 1;
        }
        return toTriples(bArr, i, i2, i3, i4);
    }

    public static final List<Triple<Integer, Integer, Integer>> toTriples(byte[] bArr, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        int i5 = i != 0 ? toInt(bArr, 0, i) : 1;
        int i6 = i2 + i3 + i4;
        ArrayList arrayList = new ArrayList(i5);
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = (i7 * i6) + i;
            int i9 = toInt(bArr, i8, i2);
            int i10 = i8 + i2;
            arrayList.add(new Triple(Integer.valueOf(i9), Integer.valueOf(toInt(bArr, i10, i3)), Integer.valueOf(toInt(bArr, i10 + i3, i4))));
        }
        return arrayList;
    }

    public static /* synthetic */ Triple toTriple$default(byte[] bArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = 1;
        }
        if ((i4 & 2) != 0) {
            i2 = 1;
        }
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        return toTriple(bArr, i, i2, i3);
    }

    public static final Triple<Integer, Integer, Integer> toTriple(byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new Triple<>(Integer.valueOf(toInt(bArr, 0, i)), Integer.valueOf(toInt(bArr, i, i2)), Integer.valueOf(toInt(bArr, i + i2, i3)));
    }

    public static /* synthetic */ List toMultiValues$default(byte[] bArr, int i, int[] iArr, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return toMultiValues(bArr, i, iArr);
    }

    public static final List<int[]> toMultiValues(byte[] bArr, int i, int... len) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(len, "len");
        int i2 = toInt(bArr, 0, i);
        int iSum = ArraysKt.sum(len);
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (i3 * iSum) + i;
            int length = len.length;
            int[] iArr = new int[length];
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = toInt(bArr, CollectionsKt.sumOfInt(ArraysKt.take(len, i5)) + i4, len[i5]);
            }
            arrayList.add(iArr);
        }
        return arrayList;
    }

    public static final <T> SparseArray<T> toSparseArray(List<Pair<Integer, Integer>> list, Function2<? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        SparseArray<T> sparseArray = new SparseArray<>();
        for (Pair<Integer, Integer> pair : list) {
            T tInvoke = action.invoke(pair.getFirst(), pair.getSecond());
            if (tInvoke != null) {
                sparseArray.put(pair.getFirst().intValue(), tInvoke);
            }
        }
        return sparseArray;
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

    public static final String firstUpper(String str) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            strValueOf = CharsKt.titlecase(cCharAt, ROOT);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        StringBuilder sbAppend = sb.append((Object) strValueOf);
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    public static final int hexToInt(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Integer.parseInt(str, CharsKt.checkRadix(16));
    }

    public static final String textCapSentences(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        String str2 = str;
        int i = 0;
        List listSplit$default = StringsKt.split$default((CharSequence) str2, new String[]{StringUtils.SPACE}, false, 0, 6, (Object) null);
        StringBuilder sb = new StringBuilder();
        for (Object obj : listSplit$default) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str3 = (String) obj;
            if (i > 0 && str3.length() > 0) {
                sb.append(StringUtils.SPACE);
            }
            sb.append(firstUpper(str3));
            i = i2;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public static final boolean compareVersion(String str, String targetStr) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(targetStr, "targetStr");
        String str2 = str;
        if (str2.length() == 0 || Intrinsics.areEqual(str, "0")) {
            return false;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str2, new String[]{"."}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            Integer intOrNull = StringsKt.toIntOrNull((String) it.next());
            arrayList.add(Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0));
        }
        ArrayList arrayList2 = arrayList;
        if (arrayList2.size() <= 3) {
            return false;
        }
        String str3 = targetStr;
        if (str3.length() == 0) {
            return true;
        }
        List listSplit$default2 = StringsKt.split$default((CharSequence) str3, new String[]{"."}, false, 0, 6, (Object) null);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default2, 10));
        Iterator it2 = listSplit$default2.iterator();
        while (it2.hasNext()) {
            Integer intOrNull2 = StringsKt.toIntOrNull((String) it2.next());
            arrayList3.add(Integer.valueOf(intOrNull2 != null ? intOrNull2.intValue() : 0));
        }
        ArrayList arrayList4 = arrayList3;
        if (arrayList4.size() <= 3) {
            return true;
        }
        Integer num = (Integer) CollectionsKt.getOrNull(arrayList2, 0);
        int iIntValue = num != null ? num.intValue() : 0;
        Integer num2 = (Integer) CollectionsKt.getOrNull(arrayList2, 1);
        int iIntValue2 = num2 != null ? num2.intValue() : 0;
        Integer num3 = (Integer) CollectionsKt.getOrNull(arrayList2, 2);
        int iIntValue3 = num3 != null ? num3.intValue() : 0;
        Integer num4 = (Integer) CollectionsKt.getOrNull(arrayList2, 3);
        int iIntValue4 = num4 != null ? num4.intValue() : 0;
        Integer num5 = (Integer) CollectionsKt.getOrNull(arrayList4, 0);
        int iIntValue5 = num5 != null ? num5.intValue() : 0;
        Integer num6 = (Integer) CollectionsKt.getOrNull(arrayList4, 1);
        int iIntValue6 = num6 != null ? num6.intValue() : 0;
        Integer num7 = (Integer) CollectionsKt.getOrNull(arrayList4, 2);
        int iIntValue7 = num7 != null ? num7.intValue() : 0;
        Integer num8 = (Integer) CollectionsKt.getOrNull(arrayList4, 3);
        return iIntValue == iIntValue5 && iIntValue2 == iIntValue6 && (iIntValue3 > iIntValue7 || (iIntValue3 == iIntValue7 && iIntValue4 >= (num8 != null ? num8.intValue() : 0)));
    }
}
