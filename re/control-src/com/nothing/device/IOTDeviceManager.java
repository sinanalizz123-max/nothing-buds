package com.nothing.device;

import android.util.Log;
import com.google.android.exoplayer2.Renderer;
import com.nothing.broadcase.util.BleBroadcastParseUtil;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.earbase.unknown.NewSkuDevice;
import com.nothing.earbase.unknown.device.UnknownDevice;
import com.nothing.earbase.unknown.device.UnknownProduct;
import com.nothing.earbase.unknown.entity.DeviceMapping;
import com.nothing.earbase.unknown.entity.DeviceMappingCache;
import com.nothing.earbase.unknown.entity.UnknownConfigs;
import com.nothing.earbase.unknown.entity.WhiteListConfigCache;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.protocol.SPPConnect;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.helper.SppConnectHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: IOTDeviceManager.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u001f\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007J\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0006J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b!J\u0012\u0010\"\u001a\u0004\u0018\u00010\t2\b\u0010 \u001a\u0004\u0018\u00010\u0006J\u0012\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010$\u001a\u0004\u0018\u00010\u0006J\u0012\u0010%\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\u0012\u0010&\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006J\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\t0(R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006)"}, d2 = {"Lcom/nothing/device/IOTDeviceManager;", "", "<init>", "()V", "cacheMacAddressDevice", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/device/IOTDevice;", "cacheProductDevice", "Lcom/nothing/device/IOTProductDevice;", "getCacheProductDevice", "()Ljava/util/concurrent/ConcurrentHashMap;", "allFastPairMap", "getAllFastPairMap", "addProductDevice", "", "product", "addUnkwonProductDevice", "addAddressDevice", "device", "queryCacheMacDeviceByFastPairId", "", "fastPairId", "getAndCreateIOTDevice", "macAddress", "modelId", "removeMacAddressDevice", "getIOTDeviceByMacAddress", "getProductByMacAddress", "address", "getProductByModelId", "evictUnknownProductIfNativeExists", "productId", "evictUnknownProductIfNativeExists$nt_ear_GoogleStoreRelease", "getProductByProductId", "getProductByBluetoothName", "name", "getNativeTemplateForModelId", "getInfoByModelId", "getAllIOTDevice", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTDeviceManager {
    public static final IOTDeviceManager INSTANCE = new IOTDeviceManager();
    private static final ConcurrentHashMap<String, IOTDevice> cacheMacAddressDevice = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, IOTProductDevice> cacheProductDevice = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, String> allFastPairMap = new ConcurrentHashMap<>();

    private IOTDeviceManager() {
    }

    public final ConcurrentHashMap<String, IOTProductDevice> getCacheProductDevice() {
        return cacheProductDevice;
    }

    public final ConcurrentHashMap<String, String> getAllFastPairMap() {
        return allFastPairMap;
    }

    public final void addProductDevice(IOTProductDevice product) {
        Intrinsics.checkNotNullParameter(product, "product");
        product.initDevice();
        cacheProductDevice.put(product.getProductId(), product);
        BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().putAll(product.getProductDeviceMap());
    }

    public final void addUnkwonProductDevice(IOTProductDevice product) {
        Intrinsics.checkNotNullParameter(product, "product");
        ConcurrentHashMap<String, IOTProductDevice> concurrentHashMap = cacheProductDevice;
        IOTProductDevice iOTProductDevice = concurrentHashMap.get(product.getProductId());
        if (iOTProductDevice != null && !(iOTProductDevice instanceof UnknownProduct)) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "unknown_widget addUnkwonProductDevice skip: native product already exists for productId=" + product.getProductId();
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
                    return;
                }
                return;
            }
            return;
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "unknown_widget addUnkwonProductDevice productId:" + product.getProductId();
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
        concurrentHashMap.put(product.getProductId(), product);
    }

    public final void addAddressDevice(IOTDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        cacheMacAddressDevice.put(device.getMacAddress(), device);
    }

    public final List<IOTDevice> queryCacheMacDeviceByFastPairId(String fastPairId) {
        Intrinsics.checkNotNullParameter(fastPairId, "fastPairId");
        Collection<IOTDevice> collectionValues = cacheMacAddressDevice.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (Intrinsics.areEqual(((IOTDevice) obj).getModelId(), fastPairId)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:162:0x06c2  */
    /* JADX WARN: Code duplicated, block: B:32:0x010c  */
    /* JADX WARN: Code duplicated, block: B:76:0x0375  */
    public final IOTDevice getAndCreateIOTDevice(String macAddress, String modelId) {
        String projectIdByModelIdFast;
        String projectId;
        WhiteListConfigCache whiteListConfigByProductId;
        DeviceMapping deviceMapping;
        String leftImageUrl;
        String rightImageUrl;
        String globalImageUrl;
        UnknownProduct unknownProduct;
        String str;
        IOTDevice iOTDevice;
        IOTDevice iOTDevice2;
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        if (macAddress.length() == 0 || modelId.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "unknown_widget ignore add device is " + modelId + "," + macAddress + StringUtils.SPACE;
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return null;
        }
        ConcurrentHashMap<String, IOTDevice> concurrentHashMap = cacheMacAddressDevice;
        IOTDevice iOTDevice3 = concurrentHashMap.get(macAddress);
        if (Intrinsics.areEqual(iOTDevice3 != null ? iOTDevice3.getModelId() : null, modelId)) {
            IOTDevice nativeTemplateForModelId = getNativeTemplateForModelId(modelId);
            if (((iOTDevice3 instanceof UnknownDevice) || (iOTDevice3 instanceof NewSkuDevice)) && nativeTemplateForModelId != null) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str5 = "unknown_widget correct cache: replace with native device " + modelId + "," + macAddress;
                    String str6 = str5;
                    if (str6 == null || str6.length() == 0) {
                        iOTDevice = nativeTemplateForModelId;
                        iOTDevice2 = iOTDevice3;
                    } else {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        iOTDevice = nativeTemplateForModelId;
                        String str7 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        iOTDevice2 = iOTDevice3;
                        FileLog.print$default(fileLog2, 3, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                        }
                    }
                } else {
                    iOTDevice = nativeTemplateForModelId;
                    iOTDevice2 = iOTDevice3;
                }
                IOTDevice iOTDevice4 = (IOTDevice) iOTDevice.getClass().newInstance();
                if (iOTDevice4 != null) {
                    if (iOTDevice.getOverrideDeviceName()) {
                        iOTDevice4.setDeviceName(iOTDevice.getDeviceName());
                    }
                    iOTDevice4.setMacAddress(macAddress);
                    iOTDevice4.setModelId(modelId);
                    iOTDevice4.setProductId(iOTDevice.getProductId());
                    iOTDevice4.addAllGesturesItem(iOTDevice.getGestureList());
                    iOTDevice4.setMyMacAddress(macAddress);
                    concurrentHashMap.remove(macAddress);
                    addAddressDevice(iOTDevice4);
                    evictUnknownProductIfNativeExists$nt_ear_GoogleStoreRelease(iOTDevice.getProductId());
                    return iOTDevice4;
                }
            } else {
                iOTDevice2 = iOTDevice3;
            }
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str8 = "unknown_widget already has " + modelId + "," + macAddress + StringUtils.SPACE;
                String str9 = str8;
                if (str9 != null && str9.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str10 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    FileLog.print$default(fileLog3, 3, str10, tag3, str8 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str8 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            return iOTDevice2;
        }
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true)) {
            String str11 = "unknown_widget GetAndCreateIOTDevice --> " + macAddress + StringUtils.SPACE + modelId;
            String str12 = str11;
            if (str12 != null && str12.length() != 0) {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str13 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                FileLog.print$default(fileLog4, 3, str13, tag4, str11 + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, str11 + StringUtils.SPACE + strComponent8);
                }
            }
        }
        IOTDevice infoByModelId = getInfoByModelId(modelId);
        if (infoByModelId != null) {
            IOTDevice iOTDevice5 = (IOTDevice) infoByModelId.getClass().newInstance();
            Logger logger5 = Logger.INSTANCE;
            String tag5 = logger5.getTAG();
            int depth5 = logger5.getDepth();
            if (logger5.isCanLogger(true)) {
                String str14 = "unknown_widget getProductResourceByModelId product id:" + infoByModelId.getProductId();
                String str15 = str14;
                if (str15 == null || str15.length() == 0) {
                    str = "format(...)";
                } else {
                    Pair<String, String> trace5 = logger5.getTrace(depth5);
                    String strComponent9 = trace5.component1();
                    String strComponent10 = trace5.component2();
                    FileLog fileLog5 = FileLog.INSTANCE;
                    String str16 = logger5.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str16, "format(...)");
                    str = "format(...)";
                    FileLog.print$default(fileLog5, 3, str16, tag5, str14 + StringUtils.SPACE + strComponent10, null, 16, null);
                    if (logger5.isDebug()) {
                        Log.i(tag5 + strComponent9, str14 + StringUtils.SPACE + strComponent10);
                    }
                }
            } else {
                str = "format(...)";
            }
            if (infoByModelId.getOverrideDeviceName()) {
                iOTDevice5.setDeviceName(infoByModelId.getDeviceName());
            }
            iOTDevice5.setMacAddress(macAddress);
            iOTDevice5.setModelId(modelId);
            iOTDevice5.setProductId(infoByModelId.getProductId());
            if ((iOTDevice5 instanceof UnknownDevice) || (iOTDevice5 instanceof NewSkuDevice)) {
                com.nothing.link.utils.Logger logger6 = com.nothing.link.utils.Logger.INSTANCE;
                Logger logger7 = Logger.INSTANCE;
                if (logger6.getDebug()) {
                    Log.d(logger6.getLogTag(logger7), "unknown_widget_projectId " + infoByModelId.getProductId() + " device is unknown or newSku");
                }
                if ((infoByModelId instanceof UnknownDevice) || (infoByModelId instanceof NewSkuDevice)) {
                    com.nothing.link.utils.Logger logger8 = com.nothing.link.utils.Logger.INSTANCE;
                    Logger logger9 = Logger.INSTANCE;
                    if (logger8.getDebug()) {
                        Log.d(logger8.getLogTag(logger9), "unknown_widget_sku it is unknown or newSku");
                    }
                    BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass8(iOTDevice5, infoByModelId, null), 3, null);
                }
                if ((iOTDevice5 instanceof NewSkuDevice) && (infoByModelId instanceof NewSkuDevice)) {
                    NewSkuDevice newSkuDevice = (NewSkuDevice) infoByModelId;
                    ((NewSkuDevice) iOTDevice5).setDeviceConfigs(newSkuDevice.getIsHasAdvanceEQ(), newSkuDevice.getAncLevelNumber(), newSkuDevice.getProductId(), newSkuDevice.getDeviceName());
                }
            }
            iOTDevice5.addAllGesturesItem(infoByModelId.getGestureList());
            iOTDevice5.setMyMacAddress(macAddress);
            Intrinsics.checkNotNull(iOTDevice5);
            addAddressDevice(iOTDevice5);
            Logger logger10 = Logger.INSTANCE;
            String tag6 = logger10.getTAG();
            int depth6 = logger10.getDepth();
            if (logger10.isCanLogger(true)) {
                String str17 = "unknown_widget create new device " + iOTDevice5;
                String str18 = str17;
                if (str18 != null && str18.length() != 0) {
                    Pair<String, String> trace6 = logger10.getTrace(depth6);
                    String strComponent11 = trace6.component1();
                    String strComponent12 = trace6.component2();
                    FileLog fileLog6 = FileLog.INSTANCE;
                    String str19 = logger10.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str19, str);
                    FileLog.print$default(fileLog6, 3, str19, tag6, str17 + StringUtils.SPACE + strComponent12, null, 16, null);
                    if (logger10.isDebug()) {
                        Log.i(tag6 + strComponent11, str17 + StringUtils.SPACE + strComponent12);
                    }
                }
            }
            return iOTDevice5;
        }
        Integer num = null;
        DeviceMapping mappingByModelId = DeviceMappingCache.INSTANCE.getMappingByModelId(modelId);
        UnknownDevice unknownDevice = new UnknownDevice();
        unknownDevice.setMacAddress(macAddress);
        unknownDevice.setModelId(modelId);
        if ((mappingByModelId == null || (projectIdByModelIdFast = mappingByModelId.getProjectId()) == null) && (projectIdByModelIdFast = DeviceMappingCache.INSTANCE.getProjectIdByModelIdFast(modelId)) == null) {
            projectIdByModelIdFast = "unknown";
        }
        unknownDevice.setProductId(projectIdByModelIdFast);
        if (mappingByModelId != null && (deviceType = mappingByModelId.getDeviceType()) != null) {
            num = deviceType;
        } else if (mappingByModelId != null && (projectId = mappingByModelId.getProjectId()) != null && (whiteListConfigByProductId = DeviceMappingCache.INSTANCE.getWhiteListConfigByProductId(projectId)) != null) {
            Integer deviceType = whiteListConfigByProductId.getDeviceType();
            num = deviceType;
        }
        unknownDevice.setDeviceInfo(num);
        if (mappingByModelId != null) {
            IOTDeviceManager iOTDeviceManager = INSTANCE;
            if (iOTDeviceManager.getProductByProductId(mappingByModelId.getProjectId()) == null) {
                Integer deviceType2 = mappingByModelId.getDeviceType();
                UnknownProduct unknownProduct2 = new UnknownProduct(deviceType2 != null ? deviceType2.intValue() : 1);
                unknownProduct2.setProductId(mappingByModelId.getProjectId());
                WhiteListConfigCache whiteListConfigByProductId2 = DeviceMappingCache.INSTANCE.getWhiteListConfigByProductId(mappingByModelId.getProjectId());
                if (whiteListConfigByProductId2 == null || whiteListConfigByProductId2.getConfigs().isEmpty()) {
                    deviceMapping = mappingByModelId;
                    unknownProduct = unknownProduct2;
                } else {
                    unknownProduct2.initProductConfigs(new UnknownConfigs(mappingByModelId.getProjectId(), whiteListConfigByProductId2.getConfigs()), CollectionsKt.listOf(modelId));
                    Logger logger11 = Logger.INSTANCE;
                    String tag7 = logger11.getTAG();
                    int depth7 = logger11.getDepth();
                    if (logger11.isCanLogger(true)) {
                        String str20 = "unknown_widget init configs from cache projectId=" + mappingByModelId.getProjectId();
                        String str21 = str20;
                        if (str21 == null || str21.length() == 0) {
                            deviceMapping = mappingByModelId;
                            unknownProduct = unknownProduct2;
                        } else {
                            Pair<String, String> trace7 = logger11.getTrace(depth7);
                            String strComponent13 = trace7.component1();
                            String strComponent14 = trace7.component2();
                            FileLog fileLog7 = FileLog.INSTANCE;
                            deviceMapping = mappingByModelId;
                            String str22 = logger11.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str22, "format(...)");
                            unknownProduct = unknownProduct2;
                            FileLog.print$default(fileLog7, 3, str22, tag7, str20 + StringUtils.SPACE + strComponent14, null, 16, null);
                            if (logger11.isDebug()) {
                                Log.i(tag7 + strComponent13, str20 + StringUtils.SPACE + strComponent14);
                            }
                        }
                    } else {
                        deviceMapping = mappingByModelId;
                        unknownProduct = unknownProduct2;
                    }
                }
                iOTDeviceManager.addUnkwonProductDevice(unknownProduct);
                Logger logger12 = Logger.INSTANCE;
                String tag8 = logger12.getTAG();
                int depth8 = logger12.getDepth();
                if (logger12.isCanLogger(true)) {
                    String str23 = "unknown_widget ensure UnknownProduct in cache projectId=" + deviceMapping.getProjectId() + " for twsDevice";
                    String str24 = str23;
                    if (str24 != null && str24.length() != 0) {
                        Pair<String, String> trace8 = logger12.getTrace(depth8);
                        String strComponent15 = trace8.component1();
                        String strComponent16 = trace8.component2();
                        FileLog fileLog8 = FileLog.INSTANCE;
                        String str25 = logger12.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str25, "format(...)");
                        FileLog.print$default(fileLog8, 3, str25, tag8, str23 + StringUtils.SPACE + strComponent16, null, 16, null);
                        if (logger12.isDebug()) {
                            Log.i(tag8 + strComponent15, str23 + StringUtils.SPACE + strComponent16);
                        }
                    }
                }
            } else {
                deviceMapping = mappingByModelId;
            }
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        } else {
            deviceMapping = mappingByModelId;
        }
        if (deviceMapping != null && (((leftImageUrl = deviceMapping.getLeftImageUrl()) != null && leftImageUrl.length() != 0) || (((rightImageUrl = deviceMapping.getRightImageUrl()) != null && rightImageUrl.length() != 0) || ((globalImageUrl = deviceMapping.getGlobalImageUrl()) != null && globalImageUrl.length() != 0)))) {
            String leftImageUrl2 = deviceMapping.getLeftImageUrl();
            String str26 = leftImageUrl2 == null ? "" : leftImageUrl2;
            String rightImageUrl2 = deviceMapping.getRightImageUrl();
            String str27 = rightImageUrl2 == null ? "" : rightImageUrl2;
            String globalImageUrl2 = deviceMapping.getGlobalImageUrl();
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass11(unknownDevice, str26, str27, globalImageUrl2 == null ? str26 : globalImageUrl2, null), 3, null);
        }
        unknownDevice.setMyMacAddress(macAddress);
        UnknownDevice unknownDevice2 = unknownDevice;
        addAddressDevice(unknownDevice2);
        Logger logger13 = Logger.INSTANCE;
        String tag9 = logger13.getTAG();
        int depth9 = logger13.getDepth();
        if (logger13.isCanLogger(true)) {
            String str28 = "unknown_widget create UnknownDevice from cache mac=" + macAddress + " modelId=" + modelId;
            String str29 = str28;
            if (str29 != null && str29.length() != 0) {
                Pair<String, String> trace9 = logger13.getTrace(depth9);
                String strComponent17 = trace9.component1();
                String strComponent18 = trace9.component2();
                FileLog fileLog9 = FileLog.INSTANCE;
                String str30 = logger13.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str30, "format(...)");
                FileLog.print$default(fileLog9, 3, str30, tag9, str28 + StringUtils.SPACE + strComponent18, null, 16, null);
                if (logger13.isDebug()) {
                    Log.i(tag9 + strComponent17, str28 + StringUtils.SPACE + strComponent18);
                }
            }
        }
        return unknownDevice2;
    }

    /* JADX INFO: renamed from: com.nothing.device.IOTDeviceManager$getAndCreateIOTDevice$8, reason: invalid class name */
    /* JADX INFO: compiled from: IOTDeviceManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.device.IOTDeviceManager$getAndCreateIOTDevice$8", f = "IOTDeviceManager.kt", i = {}, l = {Renderer.MSG_SET_WAKEUP_LISTENER}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ IOTDevice $device;
        final /* synthetic */ IOTDevice $templateDevice;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass8(IOTDevice iOTDevice, IOTDevice iOTDevice2, Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
            this.$device = iOTDevice;
            this.$templateDevice = iOTDevice2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass8(this.$device, this.$templateDevice, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (((DeviceEarImage) this.$device).setNewEarImage(((DeviceEarImage) this.$templateDevice).getLeftUrl(), ((DeviceEarImage) this.$templateDevice).getRightUrl(), ((DeviceEarImage) this.$templateDevice).getDisconnectUrl(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.device.IOTDeviceManager$getAndCreateIOTDevice$11, reason: invalid class name */
    /* JADX INFO: compiled from: IOTDeviceManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.device.IOTDeviceManager$getAndCreateIOTDevice$11", f = "IOTDeviceManager.kt", i = {}, l = {150}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ UnknownDevice $device;
        final /* synthetic */ String $disconnect;
        final /* synthetic */ String $left;
        final /* synthetic */ String $right;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(UnknownDevice unknownDevice, String str, String str2, String str3, Continuation<? super AnonymousClass11> continuation) {
            super(2, continuation);
            this.$device = unknownDevice;
            this.$left = str;
            this.$right = str2;
            this.$disconnect = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass11(this.$device, this.$left, this.$right, this.$disconnect, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$device.setNewEarImage(this.$left, this.$right, this.$disconnect, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void removeMacAddressDevice(String macAddress) {
        TWSDevice twsDevice;
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        int iDeleteAll = DatabaseUtils.INSTANCE.getProfileDao().deleteAll(macAddress);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "deleteAllProfileData " + iDeleteAll;
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
        IOTDevice iOTDeviceRemove = cacheMacAddressDevice.remove(macAddress);
        if (iOTDeviceRemove == null || (twsDevice = iOTDeviceRemove.getTwsDevice()) == null) {
            return;
        }
        SppConnectHelper.INSTANCE.getInstance().removeDevice(twsDevice);
        SPPConnect.INSTANCE.getInstance().removeBond(twsDevice.getDevice());
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0063  */
    /* JADX WARN: Code duplicated, block: B:43:0x0151  */
    /* JADX WARN: Code duplicated, block: B:65:0x022c  */
    public final IOTDevice getIOTDeviceByMacAddress(String macAddress) {
        IOTDevice iOTDevice;
        DeviceItem deviceItem;
        IOTDevice iOTDevice2;
        ConcurrentHashMap<String, IOTDevice> concurrentHashMap;
        IOTDevice nativeTemplateForModelId;
        String str = macAddress;
        if (str == null || str.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "unknown_widget ignore getIOTDeviceByMacAddress macAddress is NULL".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str2 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog, 3, str2, tag, "unknown_widget ignore getIOTDeviceByMacAddress macAddress is NULL " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "unknown_widget ignore getIOTDeviceByMacAddress macAddress is NULL " + strComponent2);
                }
            }
            return null;
        }
        ConcurrentHashMap<String, IOTDevice> concurrentHashMap2 = cacheMacAddressDevice;
        IOTDevice iOTDevice3 = concurrentHashMap2.get(macAddress);
        String modelId = iOTDevice3 != null ? iOTDevice3.getModelId() : null;
        if (modelId == null || modelId.length() == 0) {
            iOTDevice3 = null;
        }
        if (iOTDevice3 == null || !((iOTDevice3 instanceof UnknownDevice) || (iOTDevice3 instanceof NewSkuDevice))) {
            iOTDevice = iOTDevice3;
            deviceItem = null;
            iOTDevice2 = iOTDevice;
        } else {
            String modelId2 = ((DeviceEarImage) iOTDevice3).getModelId();
            if (modelId2.length() <= 0 || (nativeTemplateForModelId = getNativeTemplateForModelId(modelId2)) == null) {
                iOTDevice = iOTDevice3;
                deviceItem = null;
            } else {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str3 = "unknown_widget getIOTDeviceByMacAddress correct cache: " + modelId2 + "," + macAddress;
                    String str4 = str3;
                    if (str4 == null || str4.length() == 0) {
                        iOTDevice = iOTDevice3;
                        deviceItem = null;
                    } else {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        deviceItem = null;
                        String str5 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        iOTDevice = iOTDevice3;
                        FileLog.print$default(fileLog2, 3, str5, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                        }
                    }
                } else {
                    iOTDevice = iOTDevice3;
                    deviceItem = null;
                }
                IOTDevice iOTDevice4 = (IOTDevice) nativeTemplateForModelId.getClass().newInstance();
                if (iOTDevice4 != null) {
                    if (nativeTemplateForModelId.getOverrideDeviceName()) {
                        iOTDevice4.setDeviceName(nativeTemplateForModelId.getDeviceName());
                    }
                    iOTDevice4.setMacAddress(macAddress);
                    iOTDevice4.setModelId(modelId2);
                    iOTDevice4.setProductId(nativeTemplateForModelId.getProductId());
                    iOTDevice4.addAllGesturesItem(nativeTemplateForModelId.getGestureList());
                    iOTDevice4.setMyMacAddress(macAddress);
                    concurrentHashMap2.remove(macAddress);
                    addAddressDevice(iOTDevice4);
                    evictUnknownProductIfNativeExists$nt_ear_GoogleStoreRelease(nativeTemplateForModelId.getProductId());
                    iOTDevice2 = iOTDevice4;
                }
            }
            iOTDevice2 = iOTDevice;
        }
        if (iOTDevice2 != null) {
            return iOTDevice2;
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str6 = "unknown_widget getIOTDeviceByMacAddress macAddress: " + macAddress;
            String str7 = str6;
            if (str7 != null && str7.length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str8 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                FileLog.print$default(fileLog3, 3, str8, tag3, str6 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str6 + StringUtils.SPACE + strComponent6);
                }
            }
        }
        List<DeviceItem> deviceItem2 = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(macAddress);
        DeviceItem deviceItem3 = deviceItem2 != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem2) : deviceItem;
        if (deviceItem3 == null) {
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true)) {
                String str9 = "unknown_widget getIOTDeviceByMacAddress deviceItem is null for macAddress: " + macAddress;
                String str10 = str9;
                if (str10 == null || str10.length() == 0) {
                    concurrentHashMap = concurrentHashMap2;
                } else {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str11 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                    concurrentHashMap = concurrentHashMap2;
                    FileLog.print$default(fileLog4, 3, str11, tag4, str9 + StringUtils.SPACE + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag4 + strComponent7, str9 + StringUtils.SPACE + strComponent8);
                    }
                }
            } else {
                concurrentHashMap = concurrentHashMap2;
            }
            getAndCreateIOTDevice(macAddress, "");
        } else {
            concurrentHashMap = concurrentHashMap2;
            String modelId3 = deviceItem3.getModelId();
            String str12 = modelId3 != null ? modelId3 : "";
            Logger logger5 = Logger.INSTANCE;
            String tag5 = logger5.getTAG();
            int depth5 = logger5.getDepth();
            if (logger5.isCanLogger(true)) {
                String str13 = "unknown_widget getIOTDeviceByMacAddress deviceItem.modelId: " + str12;
                String str14 = str13;
                if (str14 != null && str14.length() != 0) {
                    Pair<String, String> trace5 = logger5.getTrace(depth5);
                    String strComponent9 = trace5.component1();
                    String strComponent10 = trace5.component2();
                    FileLog fileLog5 = FileLog.INSTANCE;
                    String str15 = logger5.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                    FileLog.print$default(fileLog5, 3, str15, tag5, str13 + StringUtils.SPACE + strComponent10, null, 16, null);
                    if (logger5.isDebug()) {
                        Log.i(tag5 + strComponent9, str13 + StringUtils.SPACE + strComponent10);
                    }
                }
            }
            getAndCreateIOTDevice(macAddress, str12);
        }
        IOTDevice iOTDevice5 = concurrentHashMap.get(macAddress);
        if (iOTDevice5 == null) {
            Logger logger6 = Logger.INSTANCE;
            String tag6 = logger6.getTAG();
            int depth6 = logger6.getDepth();
            if (logger6.isCanLogger(true)) {
                String str16 = "unknown_widget getIOTDeviceByMacAddress failed to create device for macAddress: " + macAddress + ", modelId may be missing";
                String str17 = str16;
                if (str17 != null && str17.length() != 0) {
                    Pair<String, String> trace6 = logger6.getTrace(depth6);
                    String strComponent11 = trace6.component1();
                    String strComponent12 = trace6.component2();
                    FileLog fileLog6 = FileLog.INSTANCE;
                    String str18 = logger6.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str18, "format(...)");
                    FileLog.print$default(fileLog6, 3, str18, tag6, str16 + StringUtils.SPACE + strComponent12, null, 16, null);
                    if (logger6.isDebug()) {
                        Log.i(tag6 + strComponent11, str16 + StringUtils.SPACE + strComponent12);
                    }
                }
                return iOTDevice5;
            }
        } else {
            String modelId4 = iOTDevice5.getModelId();
            if (modelId4 != null && modelId4.length() != 0) {
                return iOTDevice5;
            }
            Logger logger7 = Logger.INSTANCE;
            String tag7 = logger7.getTAG();
            int depth7 = logger7.getDepth();
            if (logger7.isCanLogger(true)) {
                String str19 = "unknown_widget getIOTDeviceByMacAddress device created but modelId is null or empty for macAddress: " + macAddress;
                String str20 = str19;
                if (str20 != null && str20.length() != 0) {
                    Pair<String, String> trace7 = logger7.getTrace(depth7);
                    String strComponent13 = trace7.component1();
                    String strComponent14 = trace7.component2();
                    FileLog fileLog7 = FileLog.INSTANCE;
                    String str21 = logger7.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str21, "format(...)");
                    FileLog.print$default(fileLog7, 3, str21, tag7, str19 + StringUtils.SPACE + strComponent14, null, 16, null);
                    if (logger7.isDebug()) {
                        Log.i(tag7 + strComponent13, str19 + StringUtils.SPACE + strComponent14);
                    }
                }
            }
        }
        return iOTDevice5;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0109  */
    public final IOTProductDevice getProductByMacAddress(String address) {
        String str;
        IOTDevice iOTDevice;
        Object next;
        DeviceMapping deviceMapping;
        IOTProductDevice productByProductId;
        String str2 = address;
        if (str2 == null || str2.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "unknown_widget getProductByMacAddress address is null or empty".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, "unknown_widget getProductByMacAddress address is null or empty " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "unknown_widget getProductByMacAddress address is null or empty " + strComponent2);
                }
            }
            return null;
        }
        DeviceMapping mappingByModelId = DeviceMappingCache.INSTANCE.getMappingByModelId(address);
        if (mappingByModelId != null && mappingByModelId.getProjectId().length() > 0 && (productByProductId = getProductByProductId(mappingByModelId.getProjectId())) != null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "unknown_widget getProductByMacAddress found via cache, address=" + address + ", projectId=" + mappingByModelId.getProjectId();
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
            return productByProductId;
        }
        IOTDevice iOTDeviceByMacAddress = getIOTDeviceByMacAddress(address);
        String modelId = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getModelId() : null;
        String str7 = modelId;
        if (str7 == null || str7.length() == 0) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str8 = "unknown_widget getProductByMacAddress modelId is null or empty for address: " + address + ", device: " + iOTDeviceByMacAddress;
                String str9 = str8;
                if (str9 == null || str9.length() == 0) {
                    iOTDevice = iOTDeviceByMacAddress;
                    str = null;
                } else {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str10 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    str = null;
                    iOTDevice = iOTDeviceByMacAddress;
                    FileLog.print$default(fileLog3, 3, str10, tag3, str8 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str8 + StringUtils.SPACE + strComponent6);
                    }
                }
            } else {
                iOTDevice = iOTDeviceByMacAddress;
                str = null;
            }
            if (iOTDevice != null) {
                Iterator<T> it = DeviceMappingCache.INSTANCE.getDeviceMappings().iterator();
                do {
                    if (!it.hasNext()) {
                        next = str;
                        break;
                    }
                    next = it.next();
                    deviceMapping = (DeviceMapping) next;
                    if (Intrinsics.areEqual(deviceMapping.getModelId(), address)) {
                        break;
                    }
                } while (!Intrinsics.areEqual(deviceMapping.getFastPairId(), address));
                DeviceMapping deviceMapping2 = (DeviceMapping) next;
                String modelId2 = deviceMapping2 != null ? deviceMapping2.getModelId() : str;
                if (modelId2 != null) {
                    Logger logger4 = Logger.INSTANCE;
                    String tag4 = logger4.getTAG();
                    int depth4 = logger4.getDepth();
                    if (logger4.isCanLogger(true)) {
                        String str11 = "unknown_widget getProductByMacAddress found modelId from cache: " + modelId2;
                        String str12 = str11;
                        if (str12 != null && str12.length() != 0) {
                            Pair<String, String> trace4 = logger4.getTrace(depth4);
                            String strComponent7 = trace4.component1();
                            String strComponent8 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str13 = logger4.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                            FileLog.print$default(fileLog4, 3, str13, tag4, str11 + StringUtils.SPACE + strComponent8, null, 16, null);
                            if (logger4.isDebug()) {
                                Log.i(tag4 + strComponent7, str11 + StringUtils.SPACE + strComponent8);
                            }
                        }
                    }
                    return getProductByModelId(modelId2);
                }
            }
        }
        return getProductByModelId(modelId);
    }

    public final IOTProductDevice getProductByModelId(String modelId) {
        Object next;
        IOTProductDevice productByProductId;
        String str = modelId;
        if (str == null || str.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "unknown_widget ignore getIOTDeviceByModelId model is NULL or empty".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str2 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog, 3, str2, tag, "unknown_widget ignore getIOTDeviceByModelId model is NULL or empty " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "unknown_widget ignore getIOTDeviceByModelId model is NULL or empty " + strComponent2);
                }
            }
            return null;
        }
        Collection<IOTProductDevice> allIOTDevice = getAllIOTDevice();
        ArrayList arrayList = new ArrayList();
        for (Object obj : allIOTDevice) {
            HashSet<IOTDevice> deviceList = ((IOTProductDevice) obj).getDeviceList();
            if (!(deviceList instanceof Collection) || !deviceList.isEmpty()) {
                Iterator<T> it = deviceList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((IOTDevice) it.next()).getModelId(), modelId)) {
                        arrayList.add(obj);
                        break;
                    }
                }
            }
        }
        ArrayList arrayList2 = arrayList;
        Iterator it2 = arrayList2.iterator();
        do {
            if (!it2.hasNext()) {
                next = null;
                break;
            }
            next = it2.next();
        } while (((IOTProductDevice) next) instanceof UnknownProduct);
        IOTProductDevice iOTProductDevice = (IOTProductDevice) next;
        if (iOTProductDevice == null) {
            iOTProductDevice = (IOTProductDevice) CollectionsKt.firstOrNull((List) arrayList2);
        }
        if (iOTProductDevice != null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str3 = "unknown_widget getIOTDeviceByModelId " + modelId + " found product (native first), projectId=" + iOTProductDevice.getProductId();
                String str4 = str3;
                if (str4 != null && str4.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str5 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    FileLog.print$default(fileLog2, 3, str5, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            if (!(iOTProductDevice instanceof UnknownProduct) && iOTProductDevice.getProductId().length() > 0) {
                cacheProductDevice.put(iOTProductDevice.getProductId(), iOTProductDevice);
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str6 = "unknown_widget getIOTDeviceByModelId force cache native only for productId=" + iOTProductDevice.getProductId();
                    String str7 = str6;
                    if (str7 != null && str7.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str8 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                        FileLog.print$default(fileLog3, 3, str8, tag3, str6 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, str6 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                DeviceMappingCache.INSTANCE.removeMappingByModelId(modelId);
                DeviceMappingCache.INSTANCE.saveModelToProjectMap(modelId, iOTProductDevice.getProductId());
            }
            return iOTProductDevice;
        }
        String projectIdByModelIdFast = DeviceMappingCache.INSTANCE.getProjectIdByModelIdFast(modelId);
        if (projectIdByModelIdFast == null || (productByProductId = getProductByProductId(projectIdByModelIdFast)) == null) {
            return null;
        }
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true)) {
            String str9 = "unknown_widget getIOTDeviceByModelId " + modelId + " found via DeviceMappingCache, projectId=" + projectIdByModelIdFast;
            String str10 = str9;
            if (str10 != null && str10.length() != 0) {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str11 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                FileLog.print$default(fileLog4, 3, str11, tag4, str9 + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, str9 + StringUtils.SPACE + strComponent8);
                }
            }
        }
        return productByProductId;
    }

    public final void evictUnknownProductIfNativeExists$nt_ear_GoogleStoreRelease(String productId) {
        Object next;
        Intrinsics.checkNotNullParameter(productId, "productId");
        if (productId.length() != 0 && (cacheProductDevice.get(productId) instanceof UnknownProduct)) {
            Iterator<T> it = getAllIOTDevice().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                IOTProductDevice iOTProductDevice = (IOTProductDevice) next;
                if (Intrinsics.areEqual(iOTProductDevice.getProductId(), productId) && !(iOTProductDevice instanceof UnknownProduct)) {
                    break;
                }
            }
            IOTProductDevice iOTProductDevice2 = (IOTProductDevice) next;
            if (iOTProductDevice2 != null) {
                cacheProductDevice.put(productId, iOTProductDevice2);
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "unknown_widget evict UnknownProduct for productId=" + productId + ", keep native only";
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
    }

    public final IOTProductDevice getProductByProductId(String productId) {
        Object obj = null;
        if (productId != null && productId.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "unknown_widget ignore getProductDeviceByProductId productId is NULL".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "unknown_widget ignore getProductDeviceByProductId productId is NULL " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "unknown_widget ignore getProductDeviceByProductId productId is NULL " + strComponent2);
                }
            }
            return null;
        }
        for (Object obj2 : getAllIOTDevice()) {
            if (Intrinsics.areEqual(((IOTProductDevice) obj2).getProductId(), productId)) {
                obj = obj2;
                break;
            }
        }
        IOTProductDevice iOTProductDevice = (IOTProductDevice) obj;
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str2 = "unknown_widget getProductDeviceByProductId " + productId + StringUtils.SPACE + iOTProductDevice;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        return iOTProductDevice;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x00bc  */
    public final IOTProductDevice getProductByBluetoothName(String name) {
        Object obj;
        Iterator it;
        boolean z = true;
        if (name != null && name.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "ignore getProductByBluetoothName bluetoothName is NULL".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "ignore getProductByBluetoothName bluetoothName is NULL " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "ignore getProductByBluetoothName bluetoothName is NULL " + strComponent2);
                }
            }
            return null;
        }
        Iterator it2 = getAllIOTDevice().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            Object next = it2.next();
            IOTProductDevice iOTProductDevice = (IOTProductDevice) next;
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(z)) {
                String str2 = "isEarDevice getProductByBluetoothName bluetoothName:" + iOTProductDevice.getBluetoothName();
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    it = it2;
                } else {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    it = it2;
                    FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                    }
                }
            } else {
                it = it2;
            }
            if (Intrinsics.areEqual(iOTProductDevice.getBluetoothName(), name) || Intrinsics.areEqual(iOTProductDevice.getHelpDeviceName(), name)) {
                obj = next;
                break;
            }
            it2 = it;
            z = true;
        }
        IOTProductDevice iOTProductDevice2 = (IOTProductDevice) obj;
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str5 = "getProductByBluetoothName " + name + StringUtils.SPACE + iOTProductDevice2;
            String str6 = str5;
            if (str6 != null && str6.length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str7 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                FileLog.print$default(fileLog3, 3, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                }
            }
        }
        return iOTProductDevice2;
    }

    public final IOTDevice getNativeTemplateForModelId(String modelId) {
        String str = modelId;
        IOTDevice iOTDevice = null;
        Object obj = null;
        iOTDevice = null;
        if (str != null && str.length() != 0) {
            IOTProductDevice productByModelId = getProductByModelId(modelId);
            if (productByModelId == null || (productByModelId instanceof UnknownProduct)) {
                return null;
            }
            for (Object obj2 : productByModelId.getDeviceList()) {
                IOTDevice iOTDevice2 = (IOTDevice) obj2;
                if (Intrinsics.areEqual(iOTDevice2.getModelId(), modelId) && !(iOTDevice2 instanceof UnknownDevice) && !(iOTDevice2 instanceof NewSkuDevice)) {
                    obj = obj2;
                    break;
                }
            }
            iOTDevice = (IOTDevice) obj;
            if (iOTDevice != null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str2 = "unknown_widget getNativeTemplateForModelId " + modelId + " -> " + iOTDevice;
                    String str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str4 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                        FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
            }
        }
        return iOTDevice;
    }

    public final IOTDevice getInfoByModelId(String modelId) {
        Object next;
        Object next2;
        if (modelId != null && modelId.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "unknown_widget ignore getInfoByModelId model is NULL".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "unknown_widget ignore getInfoByModelId model is NULL " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "unknown_widget ignore getInfoByModelId model is NULL " + strComponent2);
                }
            }
            return null;
        }
        Collection<IOTProductDevice> allIOTDevice = getAllIOTDevice();
        for (IOTProductDevice iOTProductDevice : allIOTDevice) {
            if (!(iOTProductDevice instanceof UnknownProduct)) {
                Iterator<T> it = iOTProductDevice.getDeviceList().iterator();
                do {
                    if (!it.hasNext()) {
                        next2 = null;
                        break;
                    }
                    next2 = it.next();
                } while (!Intrinsics.areEqual(((IOTDevice) next2).getModelId(), modelId));
                IOTDevice iOTDevice = (IOTDevice) next2;
                if (iOTDevice != null) {
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str2 = "unknown_widget getProductResourceByModelId device (native) is " + iOTDevice;
                        String str3 = str2;
                        if (str3 != null && str3.length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str4 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                            FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                            }
                        }
                    }
                    return iOTDevice;
                }
            }
        }
        Iterator<IOTProductDevice> it2 = allIOTDevice.iterator();
        while (it2.hasNext()) {
            Iterator<T> it3 = it2.next().getDeviceList().iterator();
            do {
                if (!it3.hasNext()) {
                    next = null;
                    break;
                }
                next = it3.next();
            } while (!Intrinsics.areEqual(((IOTDevice) next).getModelId(), modelId));
            IOTDevice iOTDevice2 = (IOTDevice) next;
            if (iOTDevice2 != null) {
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str5 = "unknown_widget getProductResourceByModelId device is " + iOTDevice2;
                    String str6 = str5;
                    if (str6 != null && str6.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str7 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        FileLog.print$default(fileLog3, 3, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                return iOTDevice2;
            }
        }
        return null;
    }

    public final Collection<IOTProductDevice> getAllIOTDevice() {
        ConcurrentHashMap<String, IOTProductDevice> concurrentHashMap = cacheProductDevice;
        if (concurrentHashMap.isEmpty()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "unknown_widget getAllIOTDevice cache empty".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "unknown_widget getAllIOTDevice cache empty " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "unknown_widget getAllIOTDevice cache empty " + strComponent2);
                }
            }
        }
        Collection<IOTProductDevice> collectionValues = concurrentHashMap.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        return collectionValues;
    }
}
