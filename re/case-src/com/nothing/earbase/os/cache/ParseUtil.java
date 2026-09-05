package com.nothing.earbase.os.cache;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.ParcelUuid;
import android.util.Log;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.Logger;
import com.nothing.broadcase.ext.BluetoothDeviceExtKt;
import com.nothing.broadcase.util.BleBroadcastParseUtil;
import com.nothing.caseble.PeerLinkAdvParser;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.one.core.device.IOTProductDeviceEarOne;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingParser;
import com.nothing.log.FileLog;
import com.nothing.xservicecore.DeviceParser;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ParseUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u0017J.\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0005\u0018\u00010%2\u0006\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010\u0017H\u0007J&\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0005\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010)H\u0007J2\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0017\u0018\u00010+2\b\u0010\"\u001a\u0004\u0018\u00010\u00172\b\u0010,\u001a\u0004\u0018\u00010\u00172\u0006\u0010-\u001a\u00020\u0017H\u0002J\u0010\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u000200H\u0002J\u001a\u00101\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u00172\b\u00102\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0019X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R*\u0010\u001d\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u001ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0017`\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/nothing/earbase/os/cache/ParseUtil;", "", "<init>", "()V", "HEX_FF", "", "HEX_0", "HEX_1", "HEX_2", "HEX_3", "HEX_4", "HEX_5", "HEX_6", "HEX_7", "HEX_8", "HEX_9", "HEX_A", "HEX_C", "HEX_14", "HEX_15", "HEX_16", "HEX_FORMAT", "SERVER_UUID", "", "MANUFACTURER_IDs", "", "[Ljava/lang/Integer;", "CODE_1526423822", "CODE_2014990", "undefineDevice", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "isSupportAnc", "", "modelId", "address", "parseData", "Lkotlin/Triple;", "serviceData", "manufacturerStr", "record", "Landroid/bluetooth/le/ScanResult;", "checkIsUndefine", "Lkotlin/Pair;", "modelIdOrProductId", "from", "byteArrayToString", "bytes", "", "isNothingDevice", "name", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ParseUtil {
    private static final int CODE_1526423822 = 1526423822;
    private static final int CODE_2014990 = 2014990;
    private static final int HEX_0 = 0;
    private static final int HEX_1 = 1;
    private static final int HEX_14 = 20;
    private static final int HEX_15 = 21;
    private static final int HEX_16 = 22;
    private static final int HEX_2 = 2;
    private static final int HEX_3 = 3;
    private static final int HEX_4 = 4;
    private static final int HEX_5 = 5;
    private static final int HEX_6 = 6;
    private static final int HEX_7 = 7;
    private static final int HEX_8 = 8;
    private static final int HEX_9 = 9;
    private static final int HEX_A = 10;
    private static final int HEX_C = 12;
    private static final int HEX_FF = 255;
    private static final int HEX_FORMAT = 16;
    public static final ParseUtil INSTANCE = new ParseUtil();
    private static final Integer[] MANUFACTURER_IDs = {Integer.valueOf(NothingParser.NOTHING_MANUFACTURER_ID_NEW), Integer.valueOf(PeerLinkAdvParser.MANUFACTURER_ID_CB0C), 65535};
    private static final String SERVER_UUID = "0000fe2c-0000-1000-8000-00805f9b34fb";
    private static final HashMap<Integer, String> undefineDevice;

    private ParseUtil() {
    }

    static {
        RouterFactory.INSTANCE.initDeviceRouter();
        undefineDevice = MapsKt.hashMapOf(new Pair(Integer.valueOf(CODE_1526423822), "undefine"), new Pair(Integer.valueOf(CODE_2014990), "undefine"));
    }

    public final boolean isSupportAnc(String modelId, String address) {
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(address, "address");
        IOTDevice infoByModelId = IOTDeviceManager.INSTANCE.getInfoByModelId(modelId);
        return infoByModelId != null && infoByModelId.isSupportAnc(address);
    }

    @JvmStatic
    public static final Triple<String, String, Integer> parseData(String serviceData, String manufacturerStr) {
        Intrinsics.checkNotNullParameter(serviceData, "serviceData");
        return new Triple<>("", "", 0);
    }

    /* JADX WARN: Code duplicated, block: B:119:0x0276 A[Catch: all -> 0x03cd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x002a, B:16:0x0062, B:18:0x006e, B:20:0x0074, B:57:0x0160, B:28:0x0081, B:30:0x0087, B:32:0x008d, B:34:0x0095, B:38:0x009b, B:43:0x00a3, B:46:0x00bf, B:48:0x00d9, B:54:0x00e5, B:56:0x0135, B:58:0x0164, B:60:0x016c, B:63:0x0177, B:68:0x0183, B:72:0x019a, B:82:0x01b2, B:84:0x01bd, B:87:0x01cd, B:89:0x01d9, B:91:0x01e7, B:93:0x01ed, B:99:0x01f9, B:101:0x0201, B:112:0x0261, B:114:0x0265, B:119:0x0276, B:102:0x0223, B:105:0x0235, B:110:0x0242, B:111:0x025f, B:120:0x0282, B:122:0x0288, B:129:0x0296, B:134:0x02a7, B:137:0x02c9, B:151:0x03a4, B:140:0x02e5, B:142:0x0323, B:148:0x032e, B:150:0x0379), top: B:160:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:165:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x007e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0081 A[Catch: all -> 0x03cd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x002a, B:16:0x0062, B:18:0x006e, B:20:0x0074, B:57:0x0160, B:28:0x0081, B:30:0x0087, B:32:0x008d, B:34:0x0095, B:38:0x009b, B:43:0x00a3, B:46:0x00bf, B:48:0x00d9, B:54:0x00e5, B:56:0x0135, B:58:0x0164, B:60:0x016c, B:63:0x0177, B:68:0x0183, B:72:0x019a, B:82:0x01b2, B:84:0x01bd, B:87:0x01cd, B:89:0x01d9, B:91:0x01e7, B:93:0x01ed, B:99:0x01f9, B:101:0x0201, B:112:0x0261, B:114:0x0265, B:119:0x0276, B:102:0x0223, B:105:0x0235, B:110:0x0242, B:111:0x025f, B:120:0x0282, B:122:0x0288, B:129:0x0296, B:134:0x02a7, B:137:0x02c9, B:151:0x03a4, B:140:0x02e5, B:142:0x0323, B:148:0x032e, B:150:0x0379), top: B:160:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0087 A[Catch: all -> 0x03cd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x002a, B:16:0x0062, B:18:0x006e, B:20:0x0074, B:57:0x0160, B:28:0x0081, B:30:0x0087, B:32:0x008d, B:34:0x0095, B:38:0x009b, B:43:0x00a3, B:46:0x00bf, B:48:0x00d9, B:54:0x00e5, B:56:0x0135, B:58:0x0164, B:60:0x016c, B:63:0x0177, B:68:0x0183, B:72:0x019a, B:82:0x01b2, B:84:0x01bd, B:87:0x01cd, B:89:0x01d9, B:91:0x01e7, B:93:0x01ed, B:99:0x01f9, B:101:0x0201, B:112:0x0261, B:114:0x0265, B:119:0x0276, B:102:0x0223, B:105:0x0235, B:110:0x0242, B:111:0x025f, B:120:0x0282, B:122:0x0288, B:129:0x0296, B:134:0x02a7, B:137:0x02c9, B:151:0x03a4, B:140:0x02e5, B:142:0x0323, B:148:0x032e, B:150:0x0379), top: B:160:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x008c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0095 A[Catch: all -> 0x03cd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x002a, B:16:0x0062, B:18:0x006e, B:20:0x0074, B:57:0x0160, B:28:0x0081, B:30:0x0087, B:32:0x008d, B:34:0x0095, B:38:0x009b, B:43:0x00a3, B:46:0x00bf, B:48:0x00d9, B:54:0x00e5, B:56:0x0135, B:58:0x0164, B:60:0x016c, B:63:0x0177, B:68:0x0183, B:72:0x019a, B:82:0x01b2, B:84:0x01bd, B:87:0x01cd, B:89:0x01d9, B:91:0x01e7, B:93:0x01ed, B:99:0x01f9, B:101:0x0201, B:112:0x0261, B:114:0x0265, B:119:0x0276, B:102:0x0223, B:105:0x0235, B:110:0x0242, B:111:0x025f, B:120:0x0282, B:122:0x0288, B:129:0x0296, B:134:0x02a7, B:137:0x02c9, B:151:0x03a4, B:140:0x02e5, B:142:0x0323, B:148:0x032e, B:150:0x0379), top: B:160:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0098  */
    /* JADX WARN: Code duplicated, block: B:37:0x009a  */
    /* JADX WARN: Code duplicated, block: B:40:0x009e  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a3 A[Catch: all -> 0x03cd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x002a, B:16:0x0062, B:18:0x006e, B:20:0x0074, B:57:0x0160, B:28:0x0081, B:30:0x0087, B:32:0x008d, B:34:0x0095, B:38:0x009b, B:43:0x00a3, B:46:0x00bf, B:48:0x00d9, B:54:0x00e5, B:56:0x0135, B:58:0x0164, B:60:0x016c, B:63:0x0177, B:68:0x0183, B:72:0x019a, B:82:0x01b2, B:84:0x01bd, B:87:0x01cd, B:89:0x01d9, B:91:0x01e7, B:93:0x01ed, B:99:0x01f9, B:101:0x0201, B:112:0x0261, B:114:0x0265, B:119:0x0276, B:102:0x0223, B:105:0x0235, B:110:0x0242, B:111:0x025f, B:120:0x0282, B:122:0x0288, B:129:0x0296, B:134:0x02a7, B:137:0x02c9, B:151:0x03a4, B:140:0x02e5, B:142:0x0323, B:148:0x032e, B:150:0x0379), top: B:160:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bf A[Catch: all -> 0x03cd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x002a, B:16:0x0062, B:18:0x006e, B:20:0x0074, B:57:0x0160, B:28:0x0081, B:30:0x0087, B:32:0x008d, B:34:0x0095, B:38:0x009b, B:43:0x00a3, B:46:0x00bf, B:48:0x00d9, B:54:0x00e5, B:56:0x0135, B:58:0x0164, B:60:0x016c, B:63:0x0177, B:68:0x0183, B:72:0x019a, B:82:0x01b2, B:84:0x01bd, B:87:0x01cd, B:89:0x01d9, B:91:0x01e7, B:93:0x01ed, B:99:0x01f9, B:101:0x0201, B:112:0x0261, B:114:0x0265, B:119:0x0276, B:102:0x0223, B:105:0x0235, B:110:0x0242, B:111:0x025f, B:120:0x0282, B:122:0x0288, B:129:0x0296, B:134:0x02a7, B:137:0x02c9, B:151:0x03a4, B:140:0x02e5, B:142:0x0323, B:148:0x032e, B:150:0x0379), top: B:160:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00e5 A[Catch: all -> 0x03cd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x002a, B:16:0x0062, B:18:0x006e, B:20:0x0074, B:57:0x0160, B:28:0x0081, B:30:0x0087, B:32:0x008d, B:34:0x0095, B:38:0x009b, B:43:0x00a3, B:46:0x00bf, B:48:0x00d9, B:54:0x00e5, B:56:0x0135, B:58:0x0164, B:60:0x016c, B:63:0x0177, B:68:0x0183, B:72:0x019a, B:82:0x01b2, B:84:0x01bd, B:87:0x01cd, B:89:0x01d9, B:91:0x01e7, B:93:0x01ed, B:99:0x01f9, B:101:0x0201, B:112:0x0261, B:114:0x0265, B:119:0x0276, B:102:0x0223, B:105:0x0235, B:110:0x0242, B:111:0x025f, B:120:0x0282, B:122:0x0288, B:129:0x0296, B:134:0x02a7, B:137:0x02c9, B:151:0x03a4, B:140:0x02e5, B:142:0x0323, B:148:0x032e, B:150:0x0379), top: B:160:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x0135 A[Catch: all -> 0x03cd, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x000e, B:8:0x0014, B:10:0x001a, B:13:0x002a, B:16:0x0062, B:18:0x006e, B:20:0x0074, B:57:0x0160, B:28:0x0081, B:30:0x0087, B:32:0x008d, B:34:0x0095, B:38:0x009b, B:43:0x00a3, B:46:0x00bf, B:48:0x00d9, B:54:0x00e5, B:56:0x0135, B:58:0x0164, B:60:0x016c, B:63:0x0177, B:68:0x0183, B:72:0x019a, B:82:0x01b2, B:84:0x01bd, B:87:0x01cd, B:89:0x01d9, B:91:0x01e7, B:93:0x01ed, B:99:0x01f9, B:101:0x0201, B:112:0x0261, B:114:0x0265, B:119:0x0276, B:102:0x0223, B:105:0x0235, B:110:0x0242, B:111:0x025f, B:120:0x0282, B:122:0x0288, B:129:0x0296, B:134:0x02a7, B:137:0x02c9, B:151:0x03a4, B:140:0x02e5, B:142:0x0323, B:148:0x032e, B:150:0x0379), top: B:160:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0198  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:90:0x01e5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [T, java.lang.Object] */
    @JvmStatic
    public static final Triple<String, String, Integer> parseData(ScanResult record) {
        ScanRecord scanRecord;
        Map<ParcelUuid, byte[]> serviceData;
        byte[] bArr;
        boolean z;
        T t;
        String upperCase;
        String upperCase2;
        T t2;
        ScanRecord scanRecord2;
        T manufacturerSpecificData;
        byte[] bArr2;
        boolean z2;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        boolean z3;
        boolean z4;
        synchronized (ParseUtil.class) {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            if (record != null && (scanRecord = record.getScanRecord()) != null && (serviceData = scanRecord.getServiceData()) != null && (bArr = serviceData.get(ParcelUuid.fromString(SERVER_UUID))) != null) {
                ParseUtil parseUtil = INSTANCE;
                String upperCase3 = parseUtil.byteArrayToString(bArr).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(upperCase3);
                Pair<Integer, String> pairCheckIsUndefine = parseUtil.checkIsUndefine((String) objectRef2.element, upperCase3, "serviceData");
                Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
                Integer[] numArr = MANUFACTURER_IDs;
                int length = numArr.length;
                int i = 0;
                while (true) {
                    z = true;
                    if (i >= length) {
                        break;
                    }
                    int iIntValue = numArr[i].intValue();
                    if (objectRef3.element == 0) {
                        scanRecord2 = record.getScanRecord();
                        if (scanRecord2 != null) {
                            manufacturerSpecificData = scanRecord2.getManufacturerSpecificData(iIntValue);
                        } else {
                            manufacturerSpecificData = 0;
                        }
                        objectRef3.element = manufacturerSpecificData;
                        bArr2 = (byte[]) objectRef3.element;
                        if (bArr2 == null) {
                            z2 = false;
                        } else {
                            if (bArr2.length == 0) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                        }
                        if (z2) {
                            Logger logger2 = Logger.INSTANCE;
                            logger = logger2;
                            tag = logger2.getTAG();
                            depth = logger2.getDepth();
                            if (!logger.isCanLogger(true)) {
                                str = "MANUFACTURER_IDs hit " + iIntValue;
                                str2 = str;
                                if (str2 != null && str2.length() != 0) {
                                    z = false;
                                }
                                if (z) {
                                    Pair<String, String> trace = logger.getTrace(depth);
                                    strComponent1 = trace.component1();
                                    strComponent2 = trace.component2();
                                    FileLog fileLog = FileLog.INSTANCE;
                                    String str3 = logger.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                    FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                    if (logger.isDebug()) {
                                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                    }
                                }
                            }
                        }
                    } else {
                        byte[] bArr3 = (byte[]) objectRef3.element;
                        if (bArr3 == null) {
                            z4 = false;
                        } else {
                            if (bArr3.length == 0) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                        }
                        if (z4) {
                            scanRecord2 = record.getScanRecord();
                            if (scanRecord2 != null) {
                                manufacturerSpecificData = scanRecord2.getManufacturerSpecificData(iIntValue);
                            } else {
                                manufacturerSpecificData = 0;
                            }
                            objectRef3.element = manufacturerSpecificData;
                            bArr2 = (byte[]) objectRef3.element;
                            if (bArr2 == null) {
                                z2 = false;
                            } else {
                                if (bArr2.length == 0) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (!z3) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            }
                            if (z2) {
                                Logger logger3 = Logger.INSTANCE;
                                logger = logger3;
                                tag = logger3.getTAG();
                                depth = logger3.getDepth();
                                if (!logger.isCanLogger(true)) {
                                    str = "MANUFACTURER_IDs hit " + iIntValue;
                                    str2 = str;
                                    if (str2 != null) {
                                        z = false;
                                    }
                                    if (z) {
                                        Pair<String, String> trace2 = logger.getTrace(depth);
                                        strComponent1 = trace2.component1();
                                        strComponent2 = trace2.component2();
                                        FileLog fileLog2 = FileLog.INSTANCE;
                                        String str4 = logger.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                                        FileLog.print$default(fileLog2, 4, str4, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                        if (logger.isDebug()) {
                                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i++;
                }
                byte[] bArr4 = (byte[]) objectRef3.element;
                String strByteArrayToString = bArr4 != null ? INSTANCE.byteArrayToString(bArr4) : null;
                if ((strByteArrayToString != null ? strByteArrayToString.length() : 0) >= 12) {
                    if (strByteArrayToString != null) {
                        String strSubstring = strByteArrayToString.substring(strByteArrayToString.length() - 12, strByteArrayToString.length());
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        if (strSubstring != null) {
                            t = strSubstring;
                        } else {
                            t = "";
                        }
                    } else {
                        t = "";
                    }
                    objectRef.element = t;
                    if (((CharSequence) objectRef.element).length() == 0) {
                        return null;
                    }
                    if (strByteArrayToString != null) {
                        String strSubstring2 = strByteArrayToString.substring(4, 8);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        if (strSubstring2 != null) {
                            upperCase = strSubstring2.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                        } else {
                            upperCase = null;
                        }
                    } else {
                        upperCase = null;
                    }
                    if (strByteArrayToString != null) {
                        String strSubstring3 = strByteArrayToString.substring(2, 4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                        if (strSubstring3 != null) {
                            upperCase2 = strSubstring3.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                        } else {
                            upperCase2 = null;
                        }
                    } else {
                        upperCase2 = null;
                    }
                    CharSequence charSequence = (CharSequence) objectRef2.element;
                    if (charSequence == null || charSequence.length() == 0) {
                        if (Intrinsics.areEqual(upperCase, IOTProductDeviceEarOne.EAR_COLOR_BLACK_DISCONNECT)) {
                            String strSubstring4 = strByteArrayToString.substring(0, 4);
                            Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                            String upperCase4 = strSubstring4.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
                            t2 = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(upperCase4);
                        } else {
                            String str5 = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(upperCase);
                            if (str5 == null) {
                                str5 = "";
                            }
                            String str6 = str5;
                            if (str6.length() == 0) {
                                str6 = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(upperCase + upperCase2);
                            }
                            t2 = str6;
                        }
                        objectRef2.element = t2;
                        if (pairCheckIsUndefine != null) {
                            if (pairCheckIsUndefine.getSecond().length() == 0) {
                                pairCheckIsUndefine = INSTANCE.checkIsUndefine((String) objectRef2.element, upperCase, "productId");
                            }
                        } else {
                            pairCheckIsUndefine = INSTANCE.checkIsUndefine((String) objectRef2.element, upperCase, "productId");
                        }
                    }
                }
                CharSequence charSequence2 = (CharSequence) objectRef2.element;
                if (charSequence2 == null || charSequence2.length() == 0) {
                    if (pairCheckIsUndefine != null) {
                        if (pairCheckIsUndefine.getSecond().length() > 0) {
                            MacCacheManager.saveNothing$default(MacCacheManager.INSTANCE, (String) objectRef.element, pairCheckIsUndefine.getSecond(), pairCheckIsUndefine.getFirst().intValue(), false, 8, null);
                        }
                    }
                    return null;
                }
                Logger logger4 = Logger.INSTANCE;
                ParseUtil parseUtil2 = INSTANCE;
                Logger logger5 = logger4;
                String tag2 = logger4.getTAG();
                int depth2 = logger4.getDepth();
                if (logger5.isCanLogger(true)) {
                    String str7 = "scanRecord  HEX_FF:mac:" + objectRef.element + ",serviceData:" + parseUtil2.byteArrayToString(bArr) + ",manufacturerStr:" + strByteArrayToString + ",modelId:" + objectRef2.element;
                    String str8 = str7;
                    if (str8 != null && str8.length() != 0) {
                        z = false;
                    }
                    if (!z) {
                        Pair<String, String> trace3 = logger5.getTrace(depth2);
                        String strComponent3 = trace3.component1();
                        String strComponent4 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str9 = logger5.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                        FileLog.print$default(fileLog3, 4, str9, tag2, str7 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger5.isDebug()) {
                            Log.i(tag2 + strComponent3, str7 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                MacCacheManager.saveNothing$default(MacCacheManager.INSTANCE, (String) objectRef.element, (String) objectRef2.element, 0, false, 8, null);
                return new Triple<>(objectRef.element, objectRef2.element, 0);
            }
            return null;
        }
    }

    private final Pair<Integer, String> checkIsUndefine(String modelId, String modelIdOrProductId, String from) {
        if (modelId != null && modelId.length() > 0) {
            return null;
        }
        int iHashCode = modelIdOrProductId != null ? modelIdOrProductId.hashCode() : 0;
        String str = undefineDevice.get(Integer.valueOf(iHashCode));
        if (str == null) {
            return null;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "ParseUtil : " + from + " get modelId is null ,modelIdOrProductId :" + modelIdOrProductId + " undefineModelId :" + str + " modelCode:" + iHashCode;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 4, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return TuplesKt.to(Integer.valueOf(iHashCode), str);
    }

    private final String byteArrayToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String string = Integer.toString(b & 255, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            if (string.length() < 2) {
                string = "0" + string;
            }
            sb.append(string);
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    public final boolean isNothingDevice(String address, String name) {
        String str;
        String strReplace$default;
        Object obj = null;
        BluetoothDevice bluetoothDevice = address != null ? BluetoothDeviceExtKt.toBluetoothDevice(address) : null;
        if (!BluetoothDeviceExtKt.isNothingAudioAddress(address) && ((address == null || !DeviceParser.isNothingDevice(address)) && (bluetoothDevice == null || !BluetoothDeviceExtKt.isNothingDevice(bluetoothDevice)))) {
            return false;
        }
        for (Object obj2 : IOTDeviceManager.INSTANCE.getAllIOTDevice()) {
            IOTProductDevice iOTProductDevice = (IOTProductDevice) obj2;
            if (name != null) {
                str = name;
                strReplace$default = StringsKt.replace$default(str, StringUtils.SPACE, "", false, 4, (Object) null);
            } else {
                str = name;
                strReplace$default = null;
            }
            if (StringsKt.equals$default(strReplace$default, "Nothing" + iOTProductDevice.getDeviceName(), false, 2, null)) {
                obj = obj2;
                break;
            }
            name = str;
        }
        return obj != null;
    }
}
