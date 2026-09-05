package com.nothing.os.device.cache;

import android.app.Application;
import android.util.Log;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.Logger;
import com.nothing.earbase.os.cache.MacCacheDao;
import com.nothing.earbase.os.cache.MacCacheDataBase;
import com.nothing.earbase.os.cache.entity.MacCacheEntity;
import com.nothing.log.FileLog;
import com.nothing.os.device.earpods.core.AirPodsModel;
import com.nothing.os.device.earpods.core.PodsBattery;
import com.nothing.os.device.earpods.data.BasePods;
import com.nothing.os.device.earpods.data.PodsItem;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: MacCachePodsManager.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0010\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\rR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/os/device/cache/MacCachePodsManager;", "", "<init>", "()V", "macCacheDao", "Lcom/nothing/earbase/os/cache/MacCacheDao;", "getMacCacheDao", "()Lcom/nothing/earbase/os/cache/MacCacheDao;", "macCacheDao$delegate", "Lkotlin/Lazy;", "saveAirpods", "", "address", "", "podsBattery", "Lcom/nothing/os/device/earpods/core/PodsBattery;", "updateAirpodsModel", "", "macCacheEntity", "Lcom/nothing/earbase/os/cache/entity/MacCacheEntity;", "reverseAddress", "getAirpods", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MacCachePodsManager {
    public static final MacCachePodsManager INSTANCE = new MacCachePodsManager();

    /* JADX INFO: renamed from: macCacheDao$delegate, reason: from kotlin metadata */
    private static final Lazy macCacheDao = LazyKt.lazy(new Function0() { // from class: com.nothing.os.device.cache.MacCachePodsManager$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return MacCachePodsManager.macCacheDao_delegate$lambda$0();
        }
    });

    private MacCachePodsManager() {
    }

    private final MacCacheDao getMacCacheDao() {
        return (MacCacheDao) macCacheDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MacCacheDao macCacheDao_delegate$lambda$0() {
        MacCacheDataBase.Companion companion = MacCacheDataBase.INSTANCE;
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        return companion.getInstance(application).getMacDao();
    }

    /* JADX WARN: Code duplicated, block: B:103:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:88:0x026c  */
    /* JADX WARN: Code duplicated, block: B:90:0x0271  */
    /* JADX WARN: Code duplicated, block: B:92:0x0276  */
    /* JADX WARN: Code duplicated, block: B:96:0x028d  */
    public final boolean saveAirpods(String address, PodsBattery podsBattery) {
        boolean z;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        PodsItem casePod;
        PodsItem rightPod;
        PodsItem leftPod;
        PodsItem casePod2;
        PodsItem casePod3;
        PodsItem rightPod2;
        PodsItem rightPod3;
        PodsItem leftPod2;
        PodsItem leftPod3;
        AirPodsModel model;
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(podsBattery, "podsBattery");
        BasePods pods = podsBattery.getPods();
        String modelName = (pods == null || (model = pods.getModel()) == null) ? null : model.getModelName();
        String str3 = modelName;
        if (str3 == null || str3.length() == 0) {
            return true;
        }
        String upperCase = address.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String strReverseAddress = reverseAddress(upperCase);
        MacCacheEntity airpods = getMacCacheDao().getAirpods(strReverseAddress);
        BasePods pods2 = podsBattery.getPods();
        int battery = (pods2 == null || (leftPod3 = pods2.getLeftPod()) == null) ? -1 : leftPod3.getBattery();
        BasePods pods3 = podsBattery.getPods();
        int i = (pods3 == null || (leftPod2 = pods3.getLeftPod()) == null || leftPod2.isConnected()) ? battery : -1;
        BasePods pods4 = podsBattery.getPods();
        int battery2 = (pods4 == null || (rightPod3 = pods4.getRightPod()) == null) ? -1 : rightPod3.getBattery();
        BasePods pods5 = podsBattery.getPods();
        int i2 = (pods5 == null || (rightPod2 = pods5.getRightPod()) == null || rightPod2.isConnected()) ? battery2 : -1;
        BasePods pods6 = podsBattery.getPods();
        int battery3 = (pods6 == null || (casePod3 = pods6.getCasePod()) == null) ? -1 : casePod3.getBattery();
        BasePods pods7 = podsBattery.getPods();
        int i3 = (pods7 == null || (casePod2 = pods7.getCasePod()) == null || casePod2.isConnected()) ? battery3 : -1;
        if (airpods == null) {
            MacCacheEntity macCacheEntity = new MacCacheEntity(strReverseAddress, modelName, 0, 1, i, i2, i3, null, 0, 0L, 896, null);
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "MacCacheManager Save scanResult Airpods " + macCacheEntity;
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace = logger2.getTrace(depth2);
                    String strComponent3 = trace.component1();
                    String strComponent4 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str6 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            getMacCacheDao().saveEntity(macCacheEntity);
            z = true;
            airpods = macCacheEntity;
        } else {
            if (!Intrinsics.areEqual(airpods.getFirmwareVersion(), "1")) {
                airpods.setModelId(modelName);
            } else {
                if (!Intrinsics.areEqual(modelName, airpods.getModelId())) {
                    Logger logger3 = Logger.INSTANCE;
                    String tag3 = logger3.getTAG();
                    int depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true)) {
                        String str7 = "MacCacheManager modelName:" + modelName + ",entityModelId:" + airpods.getModelId();
                        String str8 = str7;
                        if (str8 != null && str8.length() != 0) {
                            Pair<String, String> trace2 = logger3.getTrace(depth3);
                            String strComponent5 = trace2.component1();
                            String strComponent6 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str9 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                            FileLog.print$default(fileLog2, 5, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.w(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                            }
                        }
                    }
                    z = false;
                }
                if (i != -1) {
                    airpods.setLeftBattery(i);
                }
                if (i2 != -1) {
                    airpods.setRightBattery(i2);
                }
                if (i3 != -1) {
                    airpods.setCaseBattery(i3);
                }
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str = "MacCacheManager update scanResult Airpods " + airpods;
                    str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace3 = logger.getTrace(depth);
                        strComponent1 = trace3.component1();
                        strComponent2 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str10 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                        FileLog.print$default(fileLog3, 4, str10, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                airpods.setTimestap(System.currentTimeMillis());
                getMacCacheDao().updateEntity(airpods);
            }
            z = true;
            if (i != -1) {
                airpods.setLeftBattery(i);
            }
            if (i2 != -1) {
                airpods.setRightBattery(i2);
            }
            if (i3 != -1) {
                airpods.setCaseBattery(i3);
            }
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "MacCacheManager update scanResult Airpods " + airpods;
                str2 = str;
                if (str2 != null) {
                    Pair<String, String> trace4 = logger.getTrace(depth);
                    strComponent1 = trace4.component1();
                    strComponent2 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str11 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                    FileLog.print$default(fileLog4, 4, str11, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            airpods.setTimestap(System.currentTimeMillis());
            getMacCacheDao().updateEntity(airpods);
        }
        BasePods pods8 = podsBattery.getPods();
        if (pods8 != null && (leftPod = pods8.getLeftPod()) != null) {
            leftPod.setCacheBattery(Integer.valueOf(i));
        }
        BasePods pods9 = podsBattery.getPods();
        if (pods9 != null && (rightPod = pods9.getRightPod()) != null) {
            rightPod.setCacheBattery(Integer.valueOf(i2));
        }
        BasePods pods10 = podsBattery.getPods();
        if (pods10 != null && (casePod = pods10.getCasePod()) != null) {
            casePod.setCacheBattery(Integer.valueOf(airpods.getCaseBattery()));
        }
        return z;
    }

    public final void updateAirpodsModel(MacCacheEntity macCacheEntity) {
        if (macCacheEntity != null) {
            INSTANCE.getMacCacheDao().updateEntity(macCacheEntity);
        }
    }

    private final String reverseAddress(String address) {
        String upperCase = address.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        List listSplit$default = StringsKt.split$default((CharSequence) upperCase, new String[]{TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER}, false, 0, 6, (Object) null);
        StringBuilder sb = new StringBuilder();
        Iterator it = CollectionsKt.reversed(listSplit$default).iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final MacCacheEntity getAirpods(String address) {
        String str = address;
        if (str == null || str.length() == 0) {
            return null;
        }
        MacCacheEntity airpods = getMacCacheDao().getAirpods(reverseAddress(address));
        if (airpods != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "MacCacheManager Get Airpods from db: " + airpods;
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
        }
        return airpods;
    }
}
