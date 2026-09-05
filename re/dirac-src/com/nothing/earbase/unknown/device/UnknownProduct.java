package com.nothing.earbase.unknown.device;

import android.util.Log;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import com.nothing.base.util.Logger;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.earbase.unknown.entity.CustomEQ;
import com.nothing.earbase.unknown.entity.UnknownConfigs;
import com.nothing.earbase.unknown.entity.UnknownFunction;
import com.nothing.log.FileLog;
import com.nothing.ota.entity.OTAProcess;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: UnknownProduct.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014J6\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001eJ\b\u0010 \u001a\u00020\u0003H\u0016J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\u0006\u0010$\u001a\u00020\u001eJ\n\u0010%\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\u0006\u0010(\u001a\u00020\u001eJ\b\u0010)\u001a\u00020\u001eH\u0002J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\u0006\u0010,\u001a\u00020\u0012J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u0003H\u0016J\b\u00100\u001a\u00020\u001eH\u0016J\b\u00101\u001a\u00020\u001eH\u0016J\b\u00102\u001a\u00020\u001eH\u0016J\u001c\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u000205042\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0006\u00106\u001a\u00020\u001eJ\u0006\u00107\u001a\u00020\u001eJ\b\u00108\u001a\u0004\u0018\u00010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/nothing/earbase/unknown/device/UnknownProduct;", "Lcom/nothing/device/IOTProductDevice;", "type", "", "<init>", "(I)V", "getType", "()I", "configs", "Lcom/nothing/earbase/unknown/entity/UnknownConfigs;", "getConfigs", "()Lcom/nothing/earbase/unknown/entity/UnknownConfigs;", "setConfigs", "(Lcom/nothing/earbase/unknown/entity/UnknownConfigs;)V", "cachedLastConfigs", "Lcom/nothing/earbase/unknown/entity/UnknownFunction;", "configsVersion", "initProductConfigs", "", "fastPairs", "", "", "addIotDevice", "fastPairId", "left", "right", DeviceEarImage.DISCONNECT_EAR_IMAGE, "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSupportANC", "", "isSupportExplore", "getSupportANCLevel", "hasAncWeak", "hasAncSmart", "hasAncMid", "hasThrough", "getOtaConfigs", "isCommonOTA", "isSDKOTA", "diracByPowered", "isCaseOTA", "isComboOTA", "hasNewFirFunction", "setWidgetAction", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "getTwsDeviceType", "essentialSpaceSync", "eqMutuallyExclusive", "spaceEqExclusive", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "isSupportDiracEq", "isHasDiracEqInfo", "getLastConfigs", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnknownProduct extends IOTProductDevice {
    private UnknownFunction cachedLastConfigs;
    private UnknownConfigs configs;
    private int configsVersion = -1;
    private final int type;

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.device.UnknownProduct$addIotDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: UnknownProduct.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.device.UnknownProduct", f = "UnknownProduct.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {69, ExerciseSessionRecord.EXERCISE_TYPE_WALKING, 89}, m = "addIotDevice", n = {"this", "fastPairId", "left", "right", DeviceEarImage.DISCONNECT_EAR_IMAGE, "iotDevice", "fastPairId", "left", "right", DeviceEarImage.DISCONNECT_EAR_IMAGE, "left", "right", DeviceEarImage.DISCONNECT_EAR_IMAGE}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UnknownProduct.this.addIotDevice(null, null, null, null, null, this);
        }
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasNewFirFunction() {
        return false;
    }

    public UnknownProduct(int i) {
        this.type = i;
        setStereo(i == 6 || i == 7);
        setAction(new UnknownProductAction());
        setWidgetAction(new UnknownWidgetAction());
        setProtocol(new UnknownProtocol(i));
    }

    public final int getType() {
        return this.type;
    }

    public final UnknownConfigs getConfigs() {
        return this.configs;
    }

    public final void setConfigs(UnknownConfigs unknownConfigs) {
        this.configs = unknownConfigs;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0111  */
    public final void initProductConfigs(UnknownConfigs configs, List<String> fastPairs) {
        Iterator it;
        Intrinsics.checkNotNullParameter(configs, "configs");
        Intrinsics.checkNotNullParameter(fastPairs, "fastPairs");
        boolean z = true;
        if (configs.getConfigs().isEmpty()) {
            Logger logger = Logger.INSTANCE;
            Logger logger2 = Logger.INSTANCE;
            Logger logger3 = logger;
            String tag = logger3.getTAG();
            int depth = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str = "unknown_widget initProductConfigs error: configs is empty for productId:" + configs.getId();
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    return;
                }
                return;
            }
            return;
        }
        setProductId(configs.getId());
        if (!fastPairs.isEmpty()) {
            Iterator it2 = fastPairs.iterator();
            while (it2.hasNext()) {
                String str4 = (String) it2.next();
                if (str4.length() > 0) {
                    UnknownDevice unknownDevice = new UnknownDevice();
                    unknownDevice.setModelId(str4);
                    unknownDevice.setProductId(configs.getId());
                    Logger logger4 = Logger.INSTANCE;
                    Logger logger5 = Logger.INSTANCE;
                    Logger logger6 = logger4;
                    String tag2 = logger6.getTAG();
                    int depth2 = logger6.getDepth();
                    if (logger6.isCanLogger(z)) {
                        String str5 = "unknown_widget_projectId initProductConfigs fastPairId:" + str4 + ",productId:" + unknownDevice.getProductId();
                        String str6 = str5;
                        if (str6 == null || str6.length() == 0) {
                            it = it2;
                        } else {
                            Pair<String, String> trace2 = logger6.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str7 = logger6.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                            it = it2;
                            FileLog.print$default(fileLog2, 3, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger6.isDebug()) {
                                Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                            }
                        }
                    } else {
                        it = it2;
                    }
                    getDeviceList().add(unknownDevice);
                } else {
                    it = it2;
                }
                it2 = it;
                z = true;
            }
        }
        this.configs = configs;
        this.cachedLastConfigs = null;
        this.configsVersion = -1;
        Logger logger7 = Logger.INSTANCE;
        Logger logger8 = Logger.INSTANCE;
        Logger logger9 = logger7;
        String tag3 = logger9.getTAG();
        int depth3 = logger9.getDepth();
        if (logger9.isCanLogger(true)) {
            String str8 = "unknown_widget initProductConfigs type:" + this.type + ", productId:" + configs.getId() + ", configsSize:" + configs.getConfigs().size();
            String str9 = str8;
            if (str9 == null || str9.length() == 0) {
                return;
            }
            Pair<String, String> trace3 = logger9.getTrace(depth3);
            String strComponent5 = trace3.component1();
            String strComponent6 = trace3.component2();
            FileLog fileLog3 = FileLog.INSTANCE;
            String str10 = logger9.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
            FileLog.print$default(fileLog3, 3, str10, tag3, str8 + StringUtils.SPACE + strComponent6, null, 16, null);
            if (logger9.isDebug()) {
                Log.i(tag3 + strComponent5, str8 + StringUtils.SPACE + strComponent6);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0459 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:0x045a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:0x03a3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0393 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    /* JADX WARN: Code duplicated, block: B:86:0x0399 A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:14:0x004e, B:84:0x0393, B:86:0x0399, B:88:0x03a3, B:97:0x0441, B:91:0x03c0, B:94:0x03cc, B:96:0x0418, B:83:0x0382), top: B:114:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x03be A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:91:0x03c0 A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:14:0x004e, B:84:0x0393, B:86:0x0399, B:88:0x03a3, B:97:0x0441, B:91:0x03c0, B:94:0x03cc, B:96:0x0418, B:83:0x0382), top: B:114:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x0418 A[Catch: Exception -> 0x0055, TryCatch #0 {Exception -> 0x0055, blocks: (B:14:0x004e, B:84:0x0393, B:86:0x0399, B:88:0x03a3, B:97:0x0441, B:91:0x03c0, B:94:0x03cc, B:96:0x0418, B:83:0x0382), top: B:114:0x0036 }] */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x037e, code lost:
    
        if (((com.nothing.earbase.unknown.device.UnknownDevice) r9).setNewEarImage(r2, r3, r4, r7) == r8) goto L99;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addIotDevice(String str, String str2, String str3, String str4, String str5, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object next;
        UnknownDevice unknownDevice;
        UnknownProduct unknownProduct;
        Iterator it;
        String str6;
        String str7;
        IOTDevice iOTDevice;
        Logger logger;
        String tag;
        int depth;
        String strComponent1;
        String strComponent2;
        String str8 = str;
        String str9 = str2;
        String str10 = str3;
        String str11 = str4;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (str8.length() == 0) {
                    Logger logger2 = Logger.INSTANCE;
                    Logger logger3 = Logger.INSTANCE;
                    Logger logger4 = logger2;
                    String tag2 = logger4.getTAG();
                    int depth2 = logger4.getDepth();
                    if (logger4.isCanLogger(true) && "unknown_widget_download_url addIotDevice error: fastPairId is empty".length() != 0) {
                        Pair<String, String> trace = logger4.getTrace(depth2);
                        String strComponent3 = trace.component1();
                        String strComponent4 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str12 = logger4.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                        FileLog.print$default(fileLog, 3, str12, tag2, "unknown_widget_download_url addIotDevice error: fastPairId is empty " + strComponent4, null, 16, null);
                        if (logger4.isDebug()) {
                            Log.i(tag2 + strComponent3, "unknown_widget_download_url addIotDevice error: fastPairId is empty " + strComponent4);
                        }
                    }
                    return Unit.INSTANCE;
                }
                Logger logger5 = Logger.INSTANCE;
                Logger logger6 = Logger.INSTANCE;
                Logger logger7 = logger5;
                String tag3 = logger7.getTAG();
                int depth3 = logger7.getDepth();
                if (logger7.isCanLogger(true)) {
                    String str13 = "unknown_widget_download_url addIotDevice projectId:" + getProductId() + ",fastPairId:" + str8;
                    String str14 = str13;
                    if (str14 != null && str14.length() != 0) {
                        Pair<String, String> trace2 = logger7.getTrace(depth3);
                        String strComponent5 = trace2.component1();
                        String strComponent6 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str15 = logger7.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                        FileLog.print$default(fileLog2, 3, str15, tag3, str13 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger7.isDebug()) {
                            Log.i(tag3 + strComponent5, str13 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                Iterator<T> it2 = getDeviceList().iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!Intrinsics.areEqual(((IOTDevice) next).getModelId(), str8));
                IOTDevice iOTDevice2 = (IOTDevice) next;
                if (iOTDevice2 == null) {
                    Logger logger8 = Logger.INSTANCE;
                    Logger logger9 = Logger.INSTANCE;
                    Logger logger10 = logger8;
                    String tag4 = logger10.getTAG();
                    int depth4 = logger10.getDepth();
                    if (logger10.isCanLogger(true) && "unknown_widget_download_url list not contain add".length() != 0) {
                        Pair<String, String> trace3 = logger10.getTrace(depth4);
                        String strComponent7 = trace3.component1();
                        String strComponent8 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str16 = logger10.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str16, "format(...)");
                        FileLog.print$default(fileLog3, 3, str16, tag4, "unknown_widget_download_url list not contain add " + strComponent8, null, 16, null);
                        if (logger10.isDebug()) {
                            Log.i(tag4 + strComponent7, "unknown_widget_download_url list not contain add " + strComponent8);
                        }
                    }
                    unknownDevice = new UnknownDevice();
                    unknownDevice.setModelId(str8);
                    unknownDevice.setProductId(getProductId());
                    unknownDevice.setDeviceName(str5);
                    setDeviceName(str5);
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = str8;
                    anonymousClass1.L$2 = str9;
                    anonymousClass1.L$3 = str10;
                    anonymousClass1.L$4 = str11;
                    anonymousClass1.L$5 = unknownDevice;
                    anonymousClass1.label = 1;
                    if (unknownDevice.setNewEarImage(str9, str10, str11, anonymousClass1) != coroutine_suspended) {
                        unknownProduct = this;
                        Boxing.boxBoolean(unknownProduct.getDeviceList().add(unknownDevice));
                        it = IOTDeviceManager.INSTANCE.queryCacheMacDeviceByFastPairId(str8).iterator();
                        String str17 = str11;
                        str6 = str9;
                        str7 = str17;
                        while (it.hasNext()) {
                            iOTDevice = (IOTDevice) it.next();
                            if (iOTDevice instanceof UnknownDevice) {
                                Logger logger11 = Logger.INSTANCE;
                                Logger logger12 = Logger.INSTANCE;
                                logger = logger11;
                                tag = logger11.getTAG();
                                depth = logger11.getDepth();
                                if (!logger.isCanLogger(true)) {
                                    Pair<String, String> trace4 = logger.getTrace(depth);
                                    strComponent1 = trace4.component1();
                                    strComponent2 = trace4.component2();
                                    FileLog fileLog4 = FileLog.INSTANCE;
                                    String str18 = logger.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str18, "format(...)");
                                    FileLog.print$default(fileLog4, 3, str18, tag, "unknown_widget_download_url update iot device cache mac" + StringUtils.SPACE + strComponent2, null, 16, null);
                                    if (logger.isDebug()) {
                                        Log.i(tag + strComponent1, "unknown_widget_download_url update iot device cache mac" + StringUtils.SPACE + strComponent2);
                                    }
                                }
                                anonymousClass1.L$0 = str6;
                                anonymousClass1.L$1 = str10;
                                anonymousClass1.L$2 = str7;
                                anonymousClass1.L$3 = it;
                                anonymousClass1.L$4 = null;
                                anonymousClass1.L$5 = null;
                                anonymousClass1.label = 3;
                                if (((UnknownDevice) iOTDevice).setNewEarImage(str6, str10, str7, anonymousClass1) == coroutine_suspended) {
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    iOTDevice2.setModelId(str8);
                    iOTDevice2.setProductId(getProductId());
                    iOTDevice2.setDeviceName(str5);
                    setDeviceName(str5);
                    Logger logger13 = Logger.INSTANCE;
                    Logger logger14 = Logger.INSTANCE;
                    Logger logger15 = logger13;
                    String tag5 = logger15.getTAG();
                    int depth5 = logger15.getDepth();
                    if (logger15.isCanLogger(true) && "unknown_widget_download_url list add image".length() != 0) {
                        Pair<String, String> trace5 = logger15.getTrace(depth5);
                        String strComponent9 = trace5.component1();
                        String strComponent10 = trace5.component2();
                        FileLog fileLog5 = FileLog.INSTANCE;
                        String str19 = logger15.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str19, "format(...)");
                        FileLog.print$default(fileLog5, 3, str19, tag5, "unknown_widget_download_url list add image " + strComponent10, null, 16, null);
                        if (logger15.isDebug()) {
                            Log.i(tag5 + strComponent9, "unknown_widget_download_url list add image " + strComponent10);
                        }
                    }
                    if (iOTDevice2 instanceof UnknownDevice) {
                        anonymousClass1.L$0 = str8;
                        anonymousClass1.L$1 = str9;
                        anonymousClass1.L$2 = str10;
                        anonymousClass1.L$3 = str11;
                        anonymousClass1.label = 2;
                    }
                    it = IOTDeviceManager.INSTANCE.queryCacheMacDeviceByFastPairId(str8).iterator();
                    String str110 = str11;
                    str6 = str9;
                    str7 = str110;
                    while (it.hasNext()) {
                        iOTDevice = (IOTDevice) it.next();
                        if (iOTDevice instanceof UnknownDevice) {
                            Logger logger16 = Logger.INSTANCE;
                            Logger logger17 = Logger.INSTANCE;
                            logger = logger16;
                            tag = logger16.getTAG();
                            depth = logger16.getDepth();
                            if (!logger.isCanLogger(true)) {
                                Pair<String, String> trace6 = logger.getTrace(depth);
                                strComponent1 = trace6.component1();
                                strComponent2 = trace6.component2();
                                FileLog fileLog6 = FileLog.INSTANCE;
                                String str111 = logger.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str111, "format(...)");
                                FileLog.print$default(fileLog6, 3, str111, tag, "unknown_widget_download_url update iot device cache mac" + StringUtils.SPACE + strComponent2, null, 16, null);
                                if (logger.isDebug()) {
                                    Log.i(tag + strComponent1, "unknown_widget_download_url update iot device cache mac" + StringUtils.SPACE + strComponent2);
                                }
                            }
                            anonymousClass1.L$0 = str6;
                            anonymousClass1.L$1 = str10;
                            anonymousClass1.L$2 = str7;
                            anonymousClass1.L$3 = it;
                            anonymousClass1.L$4 = null;
                            anonymousClass1.L$5 = null;
                            anonymousClass1.label = 3;
                            if (((UnknownDevice) iOTDevice).setNewEarImage(str6, str10, str7, anonymousClass1) == coroutine_suspended) {
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            } else {
                if (i == 1) {
                    UnknownDevice unknownDevice2 = (UnknownDevice) anonymousClass1.L$5;
                    String str20 = (String) anonymousClass1.L$4;
                    str10 = (String) anonymousClass1.L$3;
                    String str21 = (String) anonymousClass1.L$2;
                    String str22 = (String) anonymousClass1.L$1;
                    unknownProduct = (UnknownProduct) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str11 = str20;
                    str9 = str21;
                    unknownDevice = unknownDevice2;
                    str8 = str22;
                    Boxing.boxBoolean(unknownProduct.getDeviceList().add(unknownDevice));
                    it = IOTDeviceManager.INSTANCE.queryCacheMacDeviceByFastPairId(str8).iterator();
                    String str112 = str11;
                    str6 = str9;
                    str7 = str112;
                } else if (i == 2) {
                    String str23 = (String) anonymousClass1.L$3;
                    String str24 = (String) anonymousClass1.L$2;
                    String str25 = (String) anonymousClass1.L$1;
                    String str26 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    str11 = str23;
                    str8 = str26;
                    str10 = str24;
                    str9 = str25;
                    it = IOTDeviceManager.INSTANCE.queryCacheMacDeviceByFastPairId(str8).iterator();
                    String str113 = str11;
                    str6 = str9;
                    str7 = str113;
                } else {
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) anonymousClass1.L$3;
                    str7 = (String) anonymousClass1.L$2;
                    str10 = (String) anonymousClass1.L$1;
                    str6 = (String) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    iOTDevice = (IOTDevice) it.next();
                    if (iOTDevice instanceof UnknownDevice) {
                        Logger logger18 = Logger.INSTANCE;
                        Logger logger19 = Logger.INSTANCE;
                        logger = logger18;
                        tag = logger18.getTAG();
                        depth = logger18.getDepth();
                        if (!logger.isCanLogger(true) && "unknown_widget_download_url update iot device cache mac".length() != 0) {
                            Pair<String, String> trace7 = logger.getTrace(depth);
                            strComponent1 = trace7.component1();
                            strComponent2 = trace7.component2();
                            FileLog fileLog7 = FileLog.INSTANCE;
                            String str114 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str114, "format(...)");
                            FileLog.print$default(fileLog7, 3, str114, tag, "unknown_widget_download_url update iot device cache mac" + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, "unknown_widget_download_url update iot device cache mac" + StringUtils.SPACE + strComponent2);
                            }
                        }
                        anonymousClass1.L$0 = str6;
                        anonymousClass1.L$1 = str10;
                        anonymousClass1.L$2 = str7;
                        anonymousClass1.L$3 = it;
                        anonymousClass1.L$4 = null;
                        anonymousClass1.L$5 = null;
                        anonymousClass1.label = 3;
                        if (((UnknownDevice) iOTDevice).setNewEarImage(str6, str10, str7, anonymousClass1) == coroutine_suspended) {
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        } catch (Exception e) {
            Logger logger20 = Logger.INSTANCE;
            Logger logger21 = Logger.INSTANCE;
            Logger logger22 = logger20;
            String tag6 = logger22.getTAG();
            int depth6 = logger22.getDepth();
            if (logger22.isCanLogger(true)) {
                String str27 = "unknown_widget_download_url update cache error: " + e.getMessage();
                String str28 = str27;
                if (str28 != null && str28.length() != 0) {
                    Pair<String, String> trace8 = logger22.getTrace(depth6);
                    String strComponent11 = trace8.component1();
                    String strComponent12 = trace8.component2();
                    FileLog fileLog8 = FileLog.INSTANCE;
                    String str29 = logger22.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str29, "format(...)");
                    FileLog.print$default(fileLog8, 3, str29, tag6, str27 + StringUtils.SPACE + strComponent12, null, 16, null);
                    if (logger22.isDebug()) {
                        Log.i(tag6 + strComponent11, str27 + StringUtils.SPACE + strComponent12);
                    }
                }
            }
        }
    }

    public final boolean isSupportANC() {
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            UnknownFunction lastConfigs = getLastConfigs();
            String str = "unknown_widget isSupportAnc:" + (lastConfigs != null ? Boolean.valueOf(lastConfigs.isSupportANC()) : null);
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        UnknownFunction lastConfigs2 = getLastConfigs();
        if (lastConfigs2 != null) {
            return lastConfigs2.isSupportANC();
        }
        return false;
    }

    public final boolean isSupportExplore() {
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            UnknownFunction lastConfigs = getLastConfigs();
            String str = "unknown_widget isSupportExplore:" + (lastConfigs != null ? Boolean.valueOf(lastConfigs.isSupportExplore()) : null);
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        UnknownFunction lastConfigs2 = getLastConfigs();
        if (lastConfigs2 != null) {
            return lastConfigs2.isSupportExplore();
        }
        return false;
    }

    @Override // com.nothing.device.IOTProductDevice
    public int getSupportANCLevel() {
        UnknownFunction lastConfigs = getLastConfigs();
        if (lastConfigs == null) {
            return 0;
        }
        Integer ancLevel = lastConfigs.getAncLevel();
        int iIntValue = ancLevel != null ? ancLevel.intValue() : 0;
        int i = (iIntValue & 2) != 0 ? 1 : 0;
        if ((iIntValue & 4) != 0) {
            i++;
        }
        if ((iIntValue & 8) != 0) {
            i++;
        }
        int i2 = i > 0 ? i + 1 : 0;
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str = "unknown_widget_systemui getSupportANCLevel ancLevel:" + iIntValue + ", count:" + i + ", result:" + i2;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return i2;
    }

    private final boolean hasAncWeak() {
        Integer ancLevel;
        UnknownFunction lastConfigs = getLastConfigs();
        return (((lastConfigs == null || (ancLevel = lastConfigs.getAncLevel()) == null) ? 0 : ancLevel.intValue()) & 4) == 4;
    }

    private final boolean hasAncSmart() {
        Integer ancLevel;
        UnknownFunction lastConfigs = getLastConfigs();
        return (((lastConfigs == null || (ancLevel = lastConfigs.getAncLevel()) == null) ? 0 : ancLevel.intValue()) & 8) == 8;
    }

    private final boolean hasAncMid() {
        Integer ancLevel;
        UnknownFunction lastConfigs = getLastConfigs();
        return (((lastConfigs == null || (ancLevel = lastConfigs.getAncLevel()) == null) ? 0 : ancLevel.intValue()) & 2) == 2;
    }

    public final boolean hasThrough() {
        Integer ancLevel;
        UnknownFunction lastConfigs = getLastConfigs();
        return (((lastConfigs == null || (ancLevel = lastConfigs.getAncLevel()) == null) ? 0 : ancLevel.intValue()) & 16) == 16;
    }

    private final UnknownFunction getOtaConfigs() {
        UnknownFunction unknownFunction;
        UnknownConfigs unknownConfigs = this.configs;
        if (unknownConfigs == null) {
            return null;
        }
        List<UnknownFunction> configs = unknownConfigs.getConfigs();
        if (configs.isEmpty()) {
            return null;
        }
        int size = configs.size();
        do {
            size--;
            if (-1 < size) {
                unknownFunction = configs.get(size);
                if (unknownFunction.getOtaProtocol() != null) {
                    break;
                }
            } else {
                return getLastConfigs();
            }
        } while (unknownFunction.getOtaPacketType() == null);
        return unknownFunction;
    }

    private final boolean isCommonOTA() {
        Integer otaProtocol;
        UnknownFunction otaConfigs = getOtaConfigs();
        int iIntValue = (otaConfigs == null || (otaProtocol = otaConfigs.getOtaProtocol()) == null) ? 0 : otaProtocol.intValue();
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str = "unknown_widget_ota isCommonOTA otaProtocol:" + iIntValue;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return iIntValue < 4;
    }

    private final boolean isSDKOTA() {
        Integer otaProtocol;
        UnknownFunction otaConfigs = getOtaConfigs();
        int iIntValue = (otaConfigs == null || (otaProtocol = otaConfigs.getOtaProtocol()) == null) ? 0 : otaProtocol.intValue();
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str = "unknown_widget_ota isSDKOTA otaProtocol:" + iIntValue + ", project:" + getProductId();
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return iIntValue == 4;
    }

    public final boolean diracByPowered() {
        Integer diracByPowered;
        UnknownFunction lastConfigs = getLastConfigs();
        int iIntValue = (lastConfigs == null || (diracByPowered = lastConfigs.getDiracByPowered()) == null) ? 0 : diracByPowered.intValue();
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str = "unknown_widget_eq is diracByPowered:" + iIntValue;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return iIntValue == 1;
    }

    private final boolean isCaseOTA() {
        Integer otaPacketType;
        UnknownFunction otaConfigs = getOtaConfigs();
        int iIntValue = (otaConfigs == null || (otaPacketType = otaConfigs.getOtaPacketType()) == null) ? 0 : otaPacketType.intValue();
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str = "unknown_widget_ota isCaseOTA otaPacketType:" + iIntValue;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return iIntValue == 2;
    }

    private final boolean isComboOTA() {
        Integer otaPacketType;
        UnknownFunction otaConfigs = getOtaConfigs();
        int iIntValue = (otaConfigs == null || (otaPacketType = otaConfigs.getOtaPacketType()) == null) ? 0 : otaPacketType.intValue();
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str = "unknown_widget_ota isComboOTA otaPacketType:" + iIntValue;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return iIntValue == 3;
    }

    public final void setWidgetAction() {
        setWidgetAction(new UnknownWidgetAction());
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        if (isCaseOTA()) {
            return new UnknownCaseOTAProcess();
        }
        if (isComboOTA()) {
            return new UnknownComboOTAProcess();
        }
        if (isSDKOTA()) {
            return new UnknownSDKOTAProcess();
        }
        return new UnknownCommonOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    /* JADX INFO: renamed from: getTwsDeviceType, reason: from getter */
    public int getType() {
        return this.type;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean essentialSpaceSync() {
        Boolean boolIsSupportEssentialSpace;
        UnknownFunction lastConfigs = getLastConfigs();
        if (lastConfigs == null || (boolIsSupportEssentialSpace = lastConfigs.isSupportEssentialSpace()) == null) {
            return false;
        }
        return boolIsSupportEssentialSpace.booleanValue();
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean eqMutuallyExclusive() {
        UnknownFunction lastConfigs = getLastConfigs();
        if (lastConfigs != null) {
            return lastConfigs.isExclusive();
        }
        return false;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean spaceEqExclusive() {
        UnknownFunction lastConfigs = getLastConfigs();
        if (lastConfigs != null) {
            return lastConfigs.isSpaceEqExclusive();
        }
        return false;
    }

    @Override // com.nothing.device.IOTProductDevice
    public Pair<Float, Float> getSimpleCustomEQParameter(int type) {
        Double qLow;
        Double freqLow;
        Double qPeak;
        Double freqPeak;
        Double qHigh;
        Double freqHigh;
        Double qLow2;
        Double freqLow2;
        UnknownFunction lastConfigs = getLastConfigs();
        CustomEQ customEQ = lastConfigs != null ? lastConfigs.getCustomEQ() : null;
        float fDoubleValue = 0.8f;
        float fDoubleValue2 = 140.0f;
        if (type == 0) {
            if (customEQ != null && (freqLow = customEQ.getFreqLow()) != null) {
                fDoubleValue2 = (float) freqLow.doubleValue();
            }
            Float fValueOf = Float.valueOf(fDoubleValue2);
            if (customEQ != null && (qLow = customEQ.getQLow()) != null) {
                fDoubleValue = (float) qLow.doubleValue();
            }
            return TuplesKt.to(fValueOf, Float.valueOf(fDoubleValue));
        }
        if (type == 1) {
            return TuplesKt.to(Float.valueOf((customEQ == null || (freqPeak = customEQ.getFreqPeak()) == null) ? 980.0f : (float) freqPeak.doubleValue()), Float.valueOf((customEQ == null || (qPeak = customEQ.getQPeak()) == null) ? 0.7f : (float) qPeak.doubleValue()));
        }
        if (type == 2) {
            return TuplesKt.to(Float.valueOf((customEQ == null || (freqHigh = customEQ.getFreqHigh()) == null) ? 6900.0f : (float) freqHigh.doubleValue()), Float.valueOf((customEQ == null || (qHigh = customEQ.getQHigh()) == null) ? 1.0f : (float) qHigh.doubleValue()));
        }
        if (customEQ != null && (freqLow2 = customEQ.getFreqLow()) != null) {
            fDoubleValue2 = (float) freqLow2.doubleValue();
        }
        Float fValueOf2 = Float.valueOf(fDoubleValue2);
        if (customEQ != null && (qLow2 = customEQ.getQLow()) != null) {
            fDoubleValue = (float) qLow2.doubleValue();
        }
        return TuplesKt.to(fValueOf2, Float.valueOf(fDoubleValue));
    }

    public final boolean isSupportDiracEq() {
        UnknownFunction lastConfigs = getLastConfigs();
        if (lastConfigs != null) {
            return lastConfigs.isDiracEq();
        }
        return false;
    }

    public final boolean isHasDiracEqInfo() {
        UnknownFunction lastConfigs = getLastConfigs();
        if (lastConfigs != null) {
            return lastConfigs.isDiracInfo();
        }
        return false;
    }

    public final UnknownFunction getLastConfigs() {
        int size;
        UnknownConfigs unknownConfigs = this.configs;
        if (unknownConfigs == null || (size = unknownConfigs.getConfigs().size()) == 0) {
            return null;
        }
        UnknownFunction unknownFunction = this.cachedLastConfigs;
        if (unknownFunction != null && this.configsVersion == size) {
            return unknownFunction;
        }
        UnknownFunction unknownFunction2 = unknownConfigs.getConfigs().get(size - 1);
        this.cachedLastConfigs = unknownFunction2;
        this.configsVersion = size;
        return unknownFunction2;
    }
}
