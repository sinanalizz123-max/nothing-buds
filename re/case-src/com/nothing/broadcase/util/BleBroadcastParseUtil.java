package com.nothing.broadcase.util;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.ParcelUuid;
import android.util.Log;
import com.nothing.base.util.Logger;
import com.nothing.broadcase.entity.NTRemoteConfigDevice;
import com.nothing.broadcase.model.BleBroadcastModel;
import com.nothing.broadcase.model.BluetoothBroadcastModel;
import com.nothing.caseble.PeerLinkAdvParser;
import com.nothing.ear.one.core.device.IOTProductDeviceEarOne;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingParser;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BleBroadcastParseUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010#\u001a\u0004\u0018\u00010\u001e2\b\u0010$\u001a\u0004\u0018\u00010%JB\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020(0'2\b\u0010)\u001a\u0004\u0018\u00010\u000e2\u0006\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u000e2\b\u0010.\u001a\u0004\u0018\u00010\u000eH\u0002J\u0012\u0010/\u001a\u0004\u0018\u00010,2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u00100\u001a\u00020\u000e2\u0006\u00101\u001a\u00020,H\u0002J\u0006\u00102\u001a\u00020(J\f\u00103\u001a\b\u0012\u0004\u0012\u00020!04J\u0014\u00105\u001a\b\u0012\u0004\u0012\u000206042\u0006\u00103\u001a\u00020!J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000eH\u0002J\u0010\u0010:\u001a\u0002082\u0006\u0010;\u001a\u00020\u000eH\u0002J\u0014\u0010<\u001a\u0002082\f\u0010=\u001a\b\u0012\u0004\u0012\u00020!04R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T\u00a2\u0006\u0002\n\u0000R-\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0011j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082T\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001e0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u001d\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020!0\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019\u00a8\u0006>"}, d2 = {"Lcom/nothing/broadcase/util/BleBroadcastParseUtil;", "", "<init>", "()V", "HEX_FF", "", "HEX_0", "HEX_2", "HEX_3", "HEX_4", "HEX_8", "HEX_C", "HEX_FORMAT", "EAR_WHITE", "", "EAR_BLACK", "deviceModelMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getDeviceModelMap", "()Ljava/util/HashMap;", "remoteConfigMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/nothing/broadcase/entity/NTRemoteConfigDevice;", "getRemoteConfigMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "MANUFACTURER_IDs", "getMANUFACTURER_IDs", "SERVER_UUID", "bleScanList", "Lcom/nothing/broadcase/model/BleBroadcastModel;", "getBleScanList", "bluetoothList", "Landroid/bluetooth/BluetoothDevice;", "getBluetoothList", "parseData", "record", "Landroid/bluetooth/le/ScanResult;", "matchRemoteConfigDevice", "Lkotlin/Pair;", "", "mac", "modelId", "serviceData", "", "productId", "colorId", "getManufacturerByte", "byteArrayToString", "bytes", "isNotEmptyBluetooth", "bluetoothDevice", "", "matchDevice", "Lcom/nothing/broadcase/model/BluetoothBroadcastModel;", "blueListRemoveItem", "", "address", "bleListRemoveItem", "deviceMac", "addBluetoothDevice", "list", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BleBroadcastParseUtil {
    public static final String EAR_BLACK = "0101";
    public static final String EAR_WHITE = "0102";
    private static final int HEX_0 = 0;
    private static final int HEX_2 = 2;
    private static final int HEX_3 = 3;
    private static final int HEX_4 = 4;
    private static final int HEX_8 = 8;
    private static final int HEX_C = 12;
    private static final int HEX_FF = 255;
    private static final int HEX_FORMAT = 16;
    private static final String SERVER_UUID = "0000fe2c-0000-1000-8000-00805f9b34fb";
    public static final BleBroadcastParseUtil INSTANCE = new BleBroadcastParseUtil();
    private static final HashMap<String, String> deviceModelMap = new HashMap<>();
    private static final ConcurrentHashMap<String, NTRemoteConfigDevice> remoteConfigMap = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Integer, Integer> MANUFACTURER_IDs = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, BleBroadcastModel> bleScanList = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, BluetoothDevice> bluetoothList = new ConcurrentHashMap<>();

    private BleBroadcastParseUtil() {
    }

    public final HashMap<String, String> getDeviceModelMap() {
        return deviceModelMap;
    }

    public final ConcurrentHashMap<String, NTRemoteConfigDevice> getRemoteConfigMap() {
        return remoteConfigMap;
    }

    public final ConcurrentHashMap<Integer, Integer> getMANUFACTURER_IDs() {
        return MANUFACTURER_IDs;
    }

    public final ConcurrentHashMap<String, BleBroadcastModel> getBleScanList() {
        return bleScanList;
    }

    public final ConcurrentHashMap<String, BluetoothDevice> getBluetoothList() {
        return bluetoothList;
    }

    /* JADX WARN: Code duplicated, block: B:108:0x0369  */
    /* JADX WARN: Code duplicated, block: B:86:0x0265  */
    /* JADX WARN: Code duplicated, block: B:92:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:95:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:97:0x0303  */
    /* JADX WARN: Multi-variable type inference failed */
    public final BleBroadcastModel parseData(ScanResult record) {
        ScanRecord scanRecord;
        Map<ParcelUuid, byte[]> serviceData;
        byte[] bArr;
        BleBroadcastModel bleBroadcastModel;
        Object obj;
        String str;
        String str2;
        String str3;
        int length;
        byte[] bArr2;
        Object obj2;
        Object obj3;
        Object objSubstring;
        Object obj4;
        String str4;
        HashMap<String, String> map;
        Logger logger;
        String tag;
        int depth;
        String str5;
        String str6;
        boolean z;
        String strComponent1;
        String strComponent2;
        String strByteArrayToString;
        if (record == null || (scanRecord = record.getScanRecord()) == null || (serviceData = scanRecord.getServiceData()) == null || (bArr = serviceData.get(ParcelUuid.fromString(SERVER_UUID))) == null) {
            return null;
        }
        HashMap<String, String> map2 = deviceModelMap;
        BleBroadcastParseUtil bleBroadcastParseUtil = INSTANCE;
        String upperCase = bleBroadcastParseUtil.byteArrayToString(bArr).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        Object obj5 = (String) map2.get(upperCase);
        if (obj5 == null) {
            obj5 = "";
        }
        byte[] manufacturerByte = getManufacturerByte(record);
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            bleBroadcastModel = null;
            String str7 = "getRemoteConfig head size:" + MANUFACTURER_IDs.size();
            String str8 = str7;
            if (str8 == null || str8.length() == 0) {
                obj = obj5;
                str = "format(...)";
                str2 = StringUtils.SPACE;
            } else {
                Pair<String, String> trace = logger2.getTrace(depth2);
                String strComponent3 = trace.component1();
                String strComponent4 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                obj = obj5;
                String str9 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                String str10 = str7 + StringUtils.SPACE + strComponent4;
                str2 = StringUtils.SPACE;
                str = "format(...)";
                FileLog.print$default(fileLog, 3, str9, tag2, str10, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str7 + str2 + strComponent4);
                }
            }
        } else {
            obj = obj5;
            str = "format(...)";
            str2 = StringUtils.SPACE;
            bleBroadcastModel = null;
        }
        if (manufacturerByte != null) {
            strByteArrayToString = bleBroadcastParseUtil.byteArrayToString(manufacturerByte);
        } else {
            str3 = bleBroadcastModel;
        }
        if (str3 != 0) {
            str3 = strByteArrayToString;
            length = str3.length();
        } else {
            str3 = strByteArrayToString;
            length = 0;
        }
        String str11 = "0000";
        String str12 = "00";
        if (length >= 12) {
            if (str3 != 0) {
                objSubstring = str3.substring(str3.length() - 12, str3.length());
                Intrinsics.checkNotNullExpressionValue(objSubstring, "substring(...)");
            } else {
                objSubstring = bleBroadcastModel;
            }
            if (str3 != 0) {
                String strSubstring = str3.substring(4, 8);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                if (strSubstring != null) {
                    String upperCase2 = strSubstring.toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
                    if (upperCase2 != null) {
                        str11 = upperCase2;
                    }
                }
            }
            String str13 = (CharSequence) obj;
            if (str13.length() == 0) {
                if (!Intrinsics.areEqual(str11, IOTProductDeviceEarOne.EAR_COLOR_BLACK_DISCONNECT)) {
                    String str14 = map2.get(str11);
                    if (str14 == null) {
                        str14 = "";
                    }
                    String str15 = str14;
                    if (str15.length() == 0) {
                        if (str3 != 0) {
                            String strSubstring2 = str3.substring(2, 4);
                            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                            if (strSubstring2 != null) {
                                String upperCase3 = strSubstring2.toUpperCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
                                if (upperCase3 != null) {
                                    str12 = upperCase3;
                                }
                            }
                        }
                        Logger logger3 = Logger.INSTANCE;
                        String tag3 = logger3.getTAG();
                        int depth3 = logger3.getDepth();
                        if (logger3.isCanLogger(true)) {
                            obj4 = "";
                            String str16 = "ble broadcast data colorId:" + ((Object) str11) + ((Object) str12);
                            String str17 = str16;
                            if (!(str17 == null || str17.length() == 0)) {
                                Pair<String, String> trace2 = logger3.getTrace(depth3);
                                String strComponent5 = trace2.component1();
                                String strComponent6 = trace2.component2();
                                FileLog fileLog2 = FileLog.INSTANCE;
                                bArr2 = manufacturerByte;
                                String str18 = logger3.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str18, str);
                                FileLog.print$default(fileLog2, 3, str18, tag3, str16 + str2 + strComponent6, null, 16, null);
                                if (logger3.isDebug()) {
                                    Log.i(tag3 + strComponent5, str16 + str2 + strComponent6);
                                }
                            }
                            logger = Logger.INSTANCE;
                            tag = logger.getTAG();
                            depth = logger.getDepth();
                            if (logger.isCanLogger(true)) {
                                str5 = "parseModelId :productId  " + ((Object) str11) + " colorId " + ((Object) str12) + " ," + ((Object) map2.get(new StringBuilder().append((Object) str11).append((Object) str12).toString())) + " ,mac=" + objSubstring;
                                str6 = str5;
                                if (str6 != null || str6.length() == 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    Pair<String, String> trace3 = logger.getTrace(depth);
                                    strComponent1 = trace3.component1();
                                    strComponent2 = trace3.component2();
                                    FileLog fileLog3 = FileLog.INSTANCE;
                                    String str19 = logger.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str19, str);
                                    FileLog.print$default(fileLog3, 4, str19, tag, str5 + str2 + strComponent2, null, 16, null);
                                    if (logger.isDebug()) {
                                        Log.i(tag + strComponent1, str5 + str2 + strComponent2);
                                    }
                                }
                            }
                            str15 = map2.get(new StringBuilder().append((Object) str11).append((Object) str12).toString());
                        } else {
                            obj4 = "";
                        }
                        bArr2 = manufacturerByte;
                        logger = Logger.INSTANCE;
                        tag = logger.getTAG();
                        depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            str5 = "parseModelId :productId  " + ((Object) str11) + " colorId " + ((Object) str12) + " ," + ((Object) map2.get(new StringBuilder().append((Object) str11).append((Object) str12).toString())) + " ,mac=" + objSubstring;
                            str6 = str5;
                            if (str6 != null) {
                                z = true;
                            } else {
                                z = true;
                            }
                            if (!z) {
                                Pair<String, String> trace4 = logger.getTrace(depth);
                                strComponent1 = trace4.component1();
                                strComponent2 = trace4.component2();
                                FileLog fileLog4 = FileLog.INSTANCE;
                                String str110 = logger.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str110, str);
                                FileLog.print$default(fileLog4, 4, str110, tag, str5 + str2 + strComponent2, null, 16, null);
                                if (logger.isDebug()) {
                                    Log.i(tag + strComponent1, str5 + str2 + strComponent2);
                                }
                            }
                        }
                        str15 = map2.get(new StringBuilder().append((Object) str11).append((Object) str12).toString());
                    } else {
                        obj4 = "";
                        bArr2 = manufacturerByte;
                    }
                    str13 = str15;
                    if (str13 == null) {
                    }
                    obj2 = objSubstring;
                } else {
                    obj4 = "";
                    bArr2 = manufacturerByte;
                    if (str3 != 0) {
                        String strSubstring3 = str3.substring(0, 4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                        if (strSubstring3 != null) {
                            String upperCase4 = strSubstring3.toUpperCase(Locale.ROOT);
                            Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
                            str4 = upperCase4;
                        } else {
                            str4 = bleBroadcastModel;
                        }
                    } else {
                        str4 = bleBroadcastModel;
                    }
                    Logger logger4 = Logger.INSTANCE;
                    String tag4 = logger4.getTAG();
                    int depth4 = logger4.getDepth();
                    if (logger4.isCanLogger(true)) {
                        map = map2;
                        String str20 = "Ear one parseModelId :productId  " + ((Object) str11) + " connectAndColorId " + str4 + " ," + map2.get(str4) + str2;
                        String str21 = str20;
                        if (!(str21 == null || str21.length() == 0)) {
                            Pair<String, String> trace5 = logger4.getTrace(depth4);
                            String strComponent7 = trace5.component1();
                            String strComponent8 = trace5.component2();
                            FileLog fileLog5 = FileLog.INSTANCE;
                            String str22 = logger4.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str22, str);
                            FileLog.print$default(fileLog5, 4, str22, tag4, str20 + str2 + strComponent8, null, 16, null);
                            if (logger4.isDebug()) {
                                Log.i(tag4 + strComponent7, str20 + str2 + strComponent8);
                            }
                        }
                    } else {
                        map = map2;
                    }
                    Object obj6 = (String) map.get(str4);
                    if (obj6 != null) {
                        obj3 = obj6;
                    }
                    obj2 = objSubstring;
                }
                obj3 = obj4;
                obj2 = objSubstring;
            } else {
                bArr2 = manufacturerByte;
            }
            obj3 = str13;
            obj2 = objSubstring;
        } else {
            bArr2 = manufacturerByte;
            obj2 = bleBroadcastModel;
            obj3 = obj;
        }
        String str23 = str12;
        Logger logger5 = Logger.INSTANCE;
        String tag5 = logger5.getTAG();
        int depth5 = logger5.getDepth();
        if (logger5.isCanLogger(true)) {
            Object upperCase5 = bleBroadcastParseUtil.byteArrayToString(bArr).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase5, "toUpperCase(...)");
            String str24 = "Ble data:" + str3 + " mac:" + obj2 + "  modelId:" + obj3 + "\uff0cfastPair:" + upperCase5;
            String str25 = str24;
            if (!(str25 == null || str25.length() == 0)) {
                Pair<String, String> trace6 = logger5.getTrace(depth5);
                String strComponent9 = trace6.component1();
                String strComponent10 = trace6.component2();
                FileLog fileLog6 = FileLog.INSTANCE;
                String str26 = logger5.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str26, str);
                FileLog.print$default(fileLog6, 3, str26, tag5, str24 + str2 + strComponent10, null, 16, null);
                if (logger5.isDebug()) {
                    Log.i(tag5 + strComponent9, str24 + str2 + strComponent10);
                }
            }
        }
        String str27 = obj2;
        Pair<String, Boolean> pairMatchRemoteConfigDevice = matchRemoteConfigDevice(str27, (String) obj3, bArr, str11, str23);
        String first = pairMatchRemoteConfigDevice.getFirst();
        if (first.length() == 0) {
            return bleBroadcastModel;
        }
        boolean zBooleanValue = pairMatchRemoteConfigDevice.getSecond().booleanValue();
        ScanRecord scanRecord2 = record.getScanRecord();
        BleBroadcastModel bleBroadcastModel2 = new BleBroadcastModel(str27, first, null, bArr2, scanRecord2 != null ? scanRecord2.getDeviceName() : bleBroadcastModel, zBooleanValue);
        if (zBooleanValue) {
            bleBroadcastModel2.setRemoteConfigDevice(remoteConfigMap.get(first));
        }
        ConcurrentHashMap<String, BleBroadcastModel> concurrentHashMap = bleScanList;
        String mac = bleBroadcastModel2.getMac();
        Intrinsics.checkNotNull(mac);
        concurrentHashMap.put(mac, bleBroadcastModel2);
        return bleBroadcastModel2;
    }

    private final Pair<String, Boolean> matchRemoteConfigDevice(String mac, String modelId, byte[] serviceData, String productId, String colorId) {
        String fastPairId;
        String fastPairId2;
        String str = mac;
        String str2 = "";
        if (str == null || str.length() == 0) {
            return TuplesKt.to("", false);
        }
        if (modelId.length() == 0) {
            String upperCase = INSTANCE.byteArrayToString(serviceData).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            ConcurrentHashMap<String, NTRemoteConfigDevice> concurrentHashMap = remoteConfigMap;
            NTRemoteConfigDevice nTRemoteConfigDevice = concurrentHashMap.get(upperCase);
            if (nTRemoteConfigDevice == null || (fastPairId = nTRemoteConfigDevice.getFastPairId()) == null) {
                fastPairId = "";
            }
            if (fastPairId.length() == 0) {
                NTRemoteConfigDevice nTRemoteConfigDevice2 = concurrentHashMap.get(productId + colorId);
                if (nTRemoteConfigDevice2 != null && (fastPairId2 = nTRemoteConfigDevice2.getFastPairId()) != null) {
                    str2 = fastPairId2;
                }
                fastPairId = str2;
            }
            return TuplesKt.to(fastPairId, Boolean.valueOf(fastPairId.length() > 0));
        }
        return TuplesKt.to(modelId, false);
    }

    private final byte[] getManufacturerByte(ScanResult record) {
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = MANUFACTURER_IDs;
        Integer numValueOf = Integer.valueOf(NothingParser.NOTHING_MANUFACTURER_ID_NEW);
        concurrentHashMap.put(numValueOf, numValueOf);
        Integer numValueOf2 = Integer.valueOf(PeerLinkAdvParser.MANUFACTURER_ID_CB0C);
        concurrentHashMap.put(numValueOf2, numValueOf2);
        concurrentHashMap.put(65535, 65535);
        Set<Integer> setKeySet = concurrentHashMap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        byte[] manufacturerSpecificData = null;
        for (Integer num : setKeySet) {
            if (manufacturerSpecificData == null || manufacturerSpecificData.length == 0) {
                ScanRecord scanRecord = record.getScanRecord();
                if (scanRecord != null) {
                    Intrinsics.checkNotNull(num);
                    manufacturerSpecificData = scanRecord.getManufacturerSpecificData(num.intValue());
                } else {
                    manufacturerSpecificData = null;
                }
                if (manufacturerSpecificData != null) {
                    if (!(manufacturerSpecificData.length == 0)) {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "MANUFACTURER_IDs hit " + num;
                            String str2 = str;
                            if (str2 != null && str2.length() != 0) {
                                Pair<String, String> trace = logger.getTrace(depth);
                                String strComponent1 = trace.component1();
                                String strComponent2 = trace.component2();
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
                }
            }
        }
        return manufacturerSpecificData;
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

    public final boolean isNotEmptyBluetooth() {
        return !bluetoothList.isEmpty();
    }

    public final List<BluetoothDevice> bluetoothDevice() {
        ConcurrentHashMap<String, BluetoothDevice> concurrentHashMap = bluetoothList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, BluetoothDevice> entry : concurrentHashMap.entrySet()) {
            if (entry.getKey().length() > 0) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((BluetoothDevice) ((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    public final List<BluetoothBroadcastModel> matchDevice(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
        ArrayList arrayList = new ArrayList();
        String address = bluetoothDevice.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        Iterator it = StringsKt.split$default((CharSequence) address, new String[]{TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER}, false, 0, 6, (Object) null).iterator();
        String str = "";
        while (it.hasNext()) {
            str = ((String) it.next()) + ((Object) str);
        }
        ConcurrentHashMap<String, BleBroadcastModel> concurrentHashMap = bleScanList;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, BleBroadcastModel> entry : concurrentHashMap.entrySet()) {
            if (StringsKt.equals(entry.getKey(), str, true)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (!linkedHashMap.isEmpty()) {
            String address2 = bluetoothDevice.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
            blueListRemoveItem(address2);
            arrayList.add(new BluetoothBroadcastModel(bluetoothDevice, (BleBroadcastModel) CollectionsKt.first(linkedHashMap.values())));
            bleListRemoveItem(str);
        } else {
            bluetoothList.put(bluetoothDevice.getAddress(), bluetoothDevice);
        }
        ConcurrentHashMap<String, BluetoothDevice> concurrentHashMap2 = bluetoothList;
        if (!concurrentHashMap2.isEmpty()) {
            for (Map.Entry<String, BluetoothDevice> entry2 : concurrentHashMap2.entrySet()) {
                BluetoothDevice value = entry2.getValue();
                Iterator it2 = StringsKt.split$default((CharSequence) entry2.getKey(), new String[]{TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER}, false, 0, 6, (Object) null).iterator();
                String str2 = "";
                while (it2.hasNext()) {
                    str2 = ((String) it2.next()) + ((Object) str2);
                }
                ConcurrentHashMap<String, BleBroadcastModel> concurrentHashMap3 = bleScanList;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry<String, BleBroadcastModel> entry3 : concurrentHashMap3.entrySet()) {
                    if (StringsKt.equals(entry3.getKey(), str2, true)) {
                        linkedHashMap2.put(entry3.getKey(), entry3.getValue());
                    }
                }
                if (!linkedHashMap2.isEmpty()) {
                    arrayList.add(new BluetoothBroadcastModel(value, (BleBroadcastModel) CollectionsKt.first(linkedHashMap2.values())));
                    BleBroadcastParseUtil bleBroadcastParseUtil = INSTANCE;
                    bleBroadcastParseUtil.bleListRemoveItem(str2);
                    bleBroadcastParseUtil.blueListRemoveItem(str2);
                }
            }
        }
        return arrayList;
    }

    private final void blueListRemoveItem(String address) {
        Iterator<Map.Entry<String, BluetoothDevice>> it = bluetoothList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, BluetoothDevice> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (Intrinsics.areEqual(address, next.getKey())) {
                it.remove();
            }
        }
    }

    private final void bleListRemoveItem(String deviceMac) {
        Iterator<Map.Entry<String, BleBroadcastModel>> it = bleScanList.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, BleBroadcastModel> next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            if (Intrinsics.areEqual(deviceMac, next.getKey())) {
                it.remove();
            }
        }
    }

    public final void addBluetoothDevice(List<BluetoothDevice> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        for (BluetoothDevice bluetoothDevice : list) {
            bluetoothList.put(bluetoothDevice.getAddress(), bluetoothDevice);
        }
    }
}
