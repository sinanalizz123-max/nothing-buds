package com.nothing.earbase.ota.slice;

import android.app.Application;
import android.os.Binder;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NetworkUtils;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.database.entity.OTAFirmware;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.earbase.base.NothingDevice;
import com.nothing.earbase.base.NothingDeviceManager;
import com.nothing.earbase.ota.entity.ServerFirmware;
import com.nothing.log.FileLog;
import com.nothing.log.NTLog;
import com.nothing.network.core.ApiResult;
import com.nothing.network.core.load.NetworkLoadRepo;
import com.nothing.ota.OTAFileHelper;
import com.nothing.ota.device.OTADevice;
import com.nothing.ota.entity.ServerCheckItem;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: OTASliceBinder.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 :2\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"J\u0016\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020&H\u0082@\u00a2\u0006\u0002\u0010'J\u001c\u0010(\u001a\u00020\u001b2\b\b\u0002\u0010)\u001a\u00020\u001f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\"J\u0010\u0010+\u001a\u00020\u001b2\b\b\u0002\u0010,\u001a\u00020\u001fJ\u0006\u0010-\u001a\u00020\u001bJ\u001e\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u001fH\u0082@\u00a2\u0006\u0002\u00101J\u001e\u00102\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u001fH\u0082@\u00a2\u0006\u0002\u00101J&\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u0011052\u0006\u00106\u001a\u0002072\b\b\u0002\u00108\u001a\u00020\u001fH\u0002J\u0006\u00109\u001a\u00020\u001bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/nothing/earbase/ota/slice/OTASliceBinder;", "Landroid/os/Binder;", "<init>", "()V", "coroutineIo", "Lkotlinx/coroutines/CoroutineScope;", "workManager", "Landroidx/work/WorkManager;", "getWorkManager", "()Landroidx/work/WorkManager;", "workManager$delegate", "Lkotlin/Lazy;", "currentWorkRequest", "Landroidx/work/OneTimeWorkRequest;", "currentRemoteJobId", "Ljava/util/UUID;", "currentFirmware", "Lcom/nothing/database/entity/OTAFirmware;", "twsCallBack", "Lcom/nothing/earbase/ota/slice/TWSSliceCallBack;", "otaCallBack", "Lcom/nothing/earbase/ota/slice/OTADeviceCallBack;", "currentNothingDevice", "Lcom/nothing/earbase/base/NothingDevice;", "updateStatus", "", "setUpdateStatus", "", NotificationCompat.CATEGORY_STATUS, "printUpdateStatus", "isStart", "", "startSliceOTA", "address", "", "startRealSliceOTA", "startDownloadFirmware", "serverFirmware", "Lcom/nothing/earbase/ota/entity/ServerFirmware;", "(Lcom/nothing/earbase/ota/entity/ServerFirmware;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startTransferOTAData", "isLocal", "filePath", "stopOTA", "isClearMD5", "notifyDeviceToStop", "notifyDeviceToUpgrade", "device", "isReady", "(Lcom/nothing/earbase/base/NothingDevice;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyDeviceFindNewVersion", "isDownload", "checkStatus", "Lkotlin/Pair;", "checkItem", "Lcom/nothing/ota/entity/ServerCheckItem;", "isBin", "onDestroy", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTASliceBinder extends Binder {
    public static final int PROGRESS_MAX = 100;
    public static final int STATUS_CHECKING = 1;
    public static final int STATUS_CHECK_ERROR = 3;
    public static final int STATUS_CHECK_IS_UPDATED = 10;
    public static final int STATUS_CHECK_NEED_TO_UPDATE = 2;
    public static final int STATUS_DOWNLOADING = 5;
    public static final int STATUS_DOWNLOAD_ERROR = 6;
    public static final int STATUS_DOWNLOAD_START = 4;
    public static final int STATUS_DOWNLOAD_SUCCESS = 7;
    public static final int STATUS_DOWNLOAD_SUCCESS_HAS_LOCAL = 8;
    public static final int STATUS_NONE = 0;
    public static final int STATUS_TRANSMISSION_ERROR = 11;
    public static final int STATUS_TRANSMISSION_START = 9;
    public static final int STATUS_TRANSMISSION_SUCCESS = 12;
    private static final int TIME_UNIT = 1000;
    private CoroutineScope coroutineIo;
    private OTAFirmware currentFirmware;
    private NothingDevice currentNothingDevice;
    private UUID currentRemoteJobId;
    private OneTimeWorkRequest currentWorkRequest;
    private OTADeviceCallBack otaCallBack;
    private TWSSliceCallBack twsCallBack;
    private int updateStatus;

    /* JADX INFO: renamed from: workManager$delegate, reason: from kotlin metadata */
    private final Lazy workManager = LazyKt.lazy(new Function0() { // from class: com.nothing.earbase.ota.slice.OTASliceBinder$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return OTASliceBinder.workManager_delegate$lambda$0();
        }
    });

    /* JADX INFO: renamed from: com.nothing.earbase.ota.slice.OTASliceBinder$notifyDeviceFindNewVersion$1, reason: invalid class name */
    /* JADX INFO: compiled from: OTASliceBinder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.slice.OTASliceBinder", f = "OTASliceBinder.kt", i = {0, 0}, l = {TypedValues.AttributesType.TYPE_PATH_ROTATE}, m = "notifyDeviceFindNewVersion", n = {"this", "isDownload"}, s = {"L$0", "Z$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OTASliceBinder.this.notifyDeviceFindNewVersion(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.slice.OTASliceBinder$notifyDeviceToUpgrade$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OTASliceBinder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.slice.OTASliceBinder", f = "OTASliceBinder.kt", i = {0, 0}, l = {309}, m = "notifyDeviceToUpgrade", n = {"this", "isReady"}, s = {"L$0", "Z$0"})
    static final class C07051 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C07051(Continuation<? super C07051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OTASliceBinder.this.notifyDeviceToUpgrade(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.slice.OTASliceBinder$startDownloadFirmware$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OTASliceBinder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.slice.OTASliceBinder", f = "OTASliceBinder.kt", i = {0, 0, 0, 2, 2, 2, 3, 3}, l = {192, 200, 231, 232}, m = "startDownloadFirmware", n = {"this", "serverFirmware", "$this$startDownloadFirmware_u24lambda_u247", "this", "$this$startDownloadFirmware_u24lambda_u247", NotificationCompat.CATEGORY_STATUS, "this", NotificationCompat.CATEGORY_STATUS}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C07061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        int label;
        /* synthetic */ Object result;

        C07061(Continuation<? super C07061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OTASliceBinder.this.startDownloadFirmware(null, this);
        }
    }

    private final WorkManager getWorkManager() {
        return (WorkManager) this.workManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WorkManager workManager_delegate$lambda$0() {
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        WorkManager workManager = WorkManager.getInstance(application);
        Intrinsics.checkNotNullExpressionValue(workManager, "getInstance(...)");
        return workManager;
    }

    public final void setUpdateStatus(int status) {
        Log.i("OTASliceBinder", "update status preStatus:" + this.updateStatus + ",currentStatus:" + status);
        this.updateStatus = status;
    }

    public final void printUpdateStatus() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "current update status is " + this.updateStatus;
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
            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            }
        }
    }

    public final boolean isStart() {
        int i = this.updateStatus;
        return (i == 3 || i == 10 || i == 0 || i == 6 || i == 11 || i == 12) ? false : true;
    }

    public final void startSliceOTA(final String address) {
        TWSDevice twsDevice;
        TWSDevice twsDevice2;
        TWSDevice twsDevice3;
        Intrinsics.checkNotNullParameter(address, "address");
        NetworkUtils networkUtils = NetworkUtils.INSTANCE;
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        if (!networkUtils.isInternetAvailable(application)) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "has not network can't start ota !!".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 5, str, tag, "has not network can't start ota !! " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.w(tag + strComponent1, "has not network can't start ota !! " + strComponent2);
                }
            }
            setUpdateStatus(3);
            return;
        }
        NothingDevice device = NothingDeviceManager.INSTANCE.getDevice(address);
        this.currentNothingDevice = device;
        if (device == null || (device != null && !device.isSupportSliceOTA())) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str2 = "can't find correct Device " + (this.currentNothingDevice == null) + " or can't support slice ota!! ";
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 5, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.w(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            setUpdateStatus(3);
            return;
        }
        NothingDevice nothingDevice = this.currentNothingDevice;
        if (nothingDevice != null && (twsDevice = nothingDevice.getTwsDevice()) != null && !twsDevice.isConnected()) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str5 = "address " + address + " tws is not connected, can't start slice ota try to connect!! ";
                String str6 = str5;
                if (str6 != null && str6.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str7 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    FileLog.print$default(fileLog3, 5, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.w(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            NothingDevice nothingDevice2 = this.currentNothingDevice;
            if (nothingDevice2 != null && (twsDevice3 = nothingDevice2.getTwsDevice()) != null) {
                twsDevice3.register(new TWSDevice.Callback() { // from class: com.nothing.earbase.ota.slice.OTASliceBinder.startSliceOTA.4
                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onConnected() {
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onUpdate(int cmdType, Message data) {
                        Intrinsics.checkNotNullParameter(data, "data");
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void getBesVersionSuccess() {
                        TWSDevice.Callback.DefaultImpls.getBesVersionSuccess(this);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public boolean isIOThread() {
                        return TWSDevice.Callback.DefaultImpls.isIOThread(this);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onConnecting(TWSDevice tWSDevice) {
                        TWSDevice.Callback.DefaultImpls.onConnecting(this, tWSDevice);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onDisconnected(TWSDevice tWSDevice) {
                        TWSDevice.Callback.DefaultImpls.onDisconnected(this, tWSDevice);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onError(TWSDevice tWSDevice) {
                        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onError(TWSDevice tWSDevice, int i, String str8) {
                        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i, str8);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onUpdate(int i, Message message, TWSDevice tWSDevice) {
                        TWSDevice.Callback.DefaultImpls.onUpdate(this, i, message, tWSDevice);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void openBluetooth(TWSDevice tWSDevice) {
                        TWSDevice.Callback.DefaultImpls.openBluetooth(this, tWSDevice);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onConnected(TWSDevice twsDevice4) {
                        TWSDevice twsDevice5;
                        Intrinsics.checkNotNullParameter(twsDevice4, "twsDevice");
                        TWSDevice.Callback.DefaultImpls.onConnected(this, twsDevice4);
                        Logger logger4 = Logger.INSTANCE;
                        String str8 = address;
                        Logger logger5 = logger4;
                        String tag4 = logger5.getTAG();
                        int depth4 = logger5.getDepth();
                        if (logger5.isCanLogger(true)) {
                            String str9 = "address " + str8 + " tws is not connected, onConnected success \uff01" + twsDevice4.getAddress();
                            String str10 = str9;
                            if (str10 != null && str10.length() != 0) {
                                Pair<String, String> trace4 = logger5.getTrace(depth4);
                                String strComponent7 = trace4.component1();
                                String strComponent8 = trace4.component2();
                                FileLog fileLog4 = FileLog.INSTANCE;
                                String str11 = logger5.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                                FileLog.print$default(fileLog4, 5, str11, tag4, str9 + StringUtils.SPACE + strComponent8, null, 16, null);
                                if (logger5.isDebug()) {
                                    Log.w(tag4 + strComponent7, str9 + StringUtils.SPACE + strComponent8);
                                }
                            }
                        }
                        if (Intrinsics.areEqual(twsDevice4.getAddress(), address)) {
                            NothingDevice nothingDevice3 = this.currentNothingDevice;
                            if (nothingDevice3 != null && (twsDevice5 = nothingDevice3.getTwsDevice()) != null) {
                                twsDevice5.unregister(this);
                            }
                            if (this.isStart()) {
                                return;
                            }
                            this.startRealSliceOTA(address);
                        }
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onDisconnected() {
                        TWSDevice twsDevice4;
                        NothingDevice nothingDevice3 = this.currentNothingDevice;
                        if (nothingDevice3 == null || (twsDevice4 = nothingDevice3.getTwsDevice()) == null) {
                            return;
                        }
                        twsDevice4.unregister(this);
                    }

                    @Override // com.nothing.protocol.device.TWSDevice.Callback
                    public void onError(int code, String message) {
                        TWSDevice twsDevice4;
                        NothingDevice nothingDevice3 = this.currentNothingDevice;
                        if (nothingDevice3 == null || (twsDevice4 = nothingDevice3.getTwsDevice()) == null) {
                            return;
                        }
                        twsDevice4.unregister(this);
                    }
                });
            }
            NothingDevice nothingDevice3 = this.currentNothingDevice;
            if (nothingDevice3 == null || (twsDevice2 = nothingDevice3.getTwsDevice()) == null) {
                return;
            }
            TWSDevice.connect$default(twsDevice2, false, null, null, 7, null);
            return;
        }
        startRealSliceOTA(address);
    }

    public final void startRealSliceOTA(String address) {
        OTADevice oTADevice;
        TWSDevice twsDevice;
        NothingDevice nothingDevice;
        OTADevice oTADevice2;
        NothingDevice nothingDevice2;
        TWSDevice twsDevice2;
        Intrinsics.checkNotNullParameter(address, "address");
        setUpdateStatus(1);
        CoroutineScope coroutineScope = this.coroutineIo;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.coroutineIo = null;
        this.coroutineIo = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
        if (this.twsCallBack != null && (nothingDevice2 = this.currentNothingDevice) != null && (twsDevice2 = nothingDevice2.getTwsDevice()) != null) {
            TWSSliceCallBack tWSSliceCallBack = this.twsCallBack;
            Intrinsics.checkNotNull(tWSSliceCallBack);
            twsDevice2.unregister(tWSSliceCallBack);
        }
        if (this.otaCallBack != null && (nothingDevice = this.currentNothingDevice) != null && (oTADevice2 = nothingDevice.getOTADevice()) != null) {
            OTADeviceCallBack oTADeviceCallBack = this.otaCallBack;
            Intrinsics.checkNotNull(oTADeviceCallBack);
            OTADevice.unregister$default(oTADevice2, oTADeviceCallBack, null, 2, null);
        }
        this.twsCallBack = new TWSSliceCallBack(this);
        this.otaCallBack = new OTADeviceCallBack(this);
        NothingDevice nothingDevice3 = this.currentNothingDevice;
        if (nothingDevice3 != null && (twsDevice = nothingDevice3.getTwsDevice()) != null) {
            TWSSliceCallBack tWSSliceCallBack2 = this.twsCallBack;
            Intrinsics.checkNotNull(tWSSliceCallBack2);
            twsDevice.register(tWSSliceCallBack2);
        }
        NothingDevice nothingDevice4 = this.currentNothingDevice;
        if (nothingDevice4 != null && (oTADevice = nothingDevice4.getOTADevice()) != null) {
            OTADeviceCallBack oTADeviceCallBack2 = this.otaCallBack;
            Intrinsics.checkNotNull(oTADeviceCallBack2);
            oTADevice.register(oTADeviceCallBack2);
        }
        CoroutineScope coroutineScope2 = this.coroutineIo;
        if (coroutineScope2 != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass3(address, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.slice.OTASliceBinder$startRealSliceOTA$3, reason: invalid class name */
    /* JADX INFO: compiled from: OTASliceBinder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.slice.OTASliceBinder$startRealSliceOTA$3", f = "OTASliceBinder.kt", i = {0}, l = {161, 167}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$address = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = OTASliceBinder.this.new AnonymousClass3(this.$address, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0051  */
        /* JADX WARN: Code duplicated, block: B:21:0x005f  */
        /* JADX WARN: Code duplicated, block: B:30:0x0088  */
        /* JADX WARN: Code duplicated, block: B:33:0x009e  */
        /* JADX WARN: Code duplicated, block: B:35:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:40:0x0106  */
        /* JADX WARN: Code duplicated, block: B:41:0x0131  */
        /* JADX WARN: Code duplicated, block: B:49:0x0197  */
        /* JADX WARN: Code duplicated, block: B:50:0x01ba  */
        /* JADX WARN: Code duplicated, block: B:53:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:60:0x023b  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        
            if (r2 == r1) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0085, code lost:
        
            if (r17.this$0.startDownloadFirmware(r2, r17) == r1) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ApiResult apiResult;
            Object objCheckDeviceServer;
            Logger logger;
            String tag;
            int depth;
            String str;
            String str2;
            String strComponent1;
            String strComponent2;
            ServerFirmware serverFirmware;
            Logger logger2;
            String tag2;
            int depth2;
            String strComponent3;
            String strComponent4;
            NothingDevice nothingDevice;
            String str3;
            Logger logger3;
            String tag3;
            int depth3;
            String str4;
            String str5;
            String strComponent5;
            String strComponent6;
            TWSDevice twsDevice;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                NothingDevice nothingDevice2 = OTASliceBinder.this.currentNothingDevice;
                if (nothingDevice2 == null) {
                    apiResult = null;
                    if (apiResult instanceof ApiResult.Success) {
                        serverFirmware = (ServerFirmware) ((ApiResult.Success) apiResult).getData();
                        if (serverFirmware.getNeed_update() == 1) {
                            OTASliceBinder.this.setUpdateStatus(2);
                            nothingDevice = OTASliceBinder.this.currentNothingDevice;
                            if (nothingDevice == null && (twsDevice = nothingDevice.getTwsDevice()) != null && twsDevice.isConnected()) {
                                this.L$0 = null;
                                this.label = 2;
                            } else {
                                Logger logger4 = Logger.INSTANCE;
                                str3 = this.$address;
                                logger3 = logger4;
                                tag3 = logger3.getTAG();
                                depth3 = logger3.getDepth();
                                if (logger3.isCanLogger(true)) {
                                    str4 = "address " + str3 + " tws is not connected, can't start slice ota !! ";
                                    str5 = str4;
                                    if (str5 != null && str5.length() != 0) {
                                        Pair<String, String> trace = logger3.getTrace(depth3);
                                        strComponent5 = trace.component1();
                                        strComponent6 = trace.component2();
                                        FileLog fileLog = FileLog.INSTANCE;
                                        String str6 = logger3.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                        FileLog.print$default(fileLog, 5, str6, tag3, str4 + StringUtils.SPACE + strComponent6, null, 16, null);
                                        if (logger3.isDebug()) {
                                            Log.w(tag3 + strComponent5, str4 + StringUtils.SPACE + strComponent6);
                                        }
                                    }
                                }
                            }
                        } else {
                            OTASliceBinder.this.setUpdateStatus(10);
                            logger2 = Logger.INSTANCE;
                            tag2 = logger2.getTAG();
                            depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(true) && "don't need update !!!".length() != 0) {
                                Pair<String, String> trace2 = logger2.getTrace(depth2);
                                strComponent3 = trace2.component1();
                                strComponent4 = trace2.component2();
                                FileLog fileLog2 = FileLog.INSTANCE;
                                String str7 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                FileLog.print$default(fileLog2, 5, str7, tag2, "don't need update !!! " + strComponent4, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.w(tag2 + strComponent3, "don't need update !!! " + strComponent4);
                                }
                            }
                        }
                    } else {
                        OTASliceBinder.this.setUpdateStatus(3);
                        logger = Logger.INSTANCE;
                        tag = logger.getTAG();
                        depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            str = "check device server error " + apiResult + "!!";
                            str2 = str;
                            if (str2 != null && str2.length() != 0) {
                                Pair<String, String> trace3 = logger.getTrace(depth);
                                strComponent1 = trace3.component1();
                                strComponent2 = trace3.component2();
                                FileLog fileLog3 = FileLog.INSTANCE;
                                String str8 = logger.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                                FileLog.print$default(fileLog3, 5, str8, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                if (logger.isDebug()) {
                                    Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                }
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                this.L$0 = coroutineScope;
                this.label = 1;
                objCheckDeviceServer = nothingDevice2.checkDeviceServer(this);
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                objCheckDeviceServer = obj;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            apiResult = (ApiResult) objCheckDeviceServer;
            if (apiResult instanceof ApiResult.Success) {
                serverFirmware = (ServerFirmware) ((ApiResult.Success) apiResult).getData();
                if (serverFirmware.getNeed_update() == 1) {
                    OTASliceBinder.this.setUpdateStatus(2);
                    nothingDevice = OTASliceBinder.this.currentNothingDevice;
                    if (nothingDevice == null) {
                        Logger logger5 = Logger.INSTANCE;
                        str3 = this.$address;
                        logger3 = logger5;
                        tag3 = logger3.getTAG();
                        depth3 = logger3.getDepth();
                        if (logger3.isCanLogger(true)) {
                            str4 = "address " + str3 + " tws is not connected, can't start slice ota !! ";
                            str5 = str4;
                            if (str5 != null) {
                                Pair<String, String> trace4 = logger3.getTrace(depth3);
                                strComponent5 = trace4.component1();
                                strComponent6 = trace4.component2();
                                FileLog fileLog4 = FileLog.INSTANCE;
                                String str9 = logger3.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                FileLog.print$default(fileLog4, 5, str9, tag3, str4 + StringUtils.SPACE + strComponent6, null, 16, null);
                                if (logger3.isDebug()) {
                                    Log.w(tag3 + strComponent5, str4 + StringUtils.SPACE + strComponent6);
                                }
                            }
                        }
                    } else {
                        Logger logger6 = Logger.INSTANCE;
                        str3 = this.$address;
                        logger3 = logger6;
                        tag3 = logger3.getTAG();
                        depth3 = logger3.getDepth();
                        if (logger3.isCanLogger(true)) {
                            str4 = "address " + str3 + " tws is not connected, can't start slice ota !! ";
                            str5 = str4;
                            if (str5 != null) {
                                Pair<String, String> trace5 = logger3.getTrace(depth3);
                                strComponent5 = trace5.component1();
                                strComponent6 = trace5.component2();
                                FileLog fileLog5 = FileLog.INSTANCE;
                                String str10 = logger3.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                                FileLog.print$default(fileLog5, 5, str10, tag3, str4 + StringUtils.SPACE + strComponent6, null, 16, null);
                                if (logger3.isDebug()) {
                                    Log.w(tag3 + strComponent5, str4 + StringUtils.SPACE + strComponent6);
                                }
                            }
                        }
                    }
                } else {
                    OTASliceBinder.this.setUpdateStatus(10);
                    logger2 = Logger.INSTANCE;
                    tag2 = logger2.getTAG();
                    depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        Pair<String, String> trace6 = logger2.getTrace(depth2);
                        strComponent3 = trace6.component1();
                        strComponent4 = trace6.component2();
                        FileLog fileLog6 = FileLog.INSTANCE;
                        String str11 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                        FileLog.print$default(fileLog6, 5, str11, tag2, "don't need update !!! " + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.w(tag2 + strComponent3, "don't need update !!! " + strComponent4);
                        }
                    }
                }
            } else {
                OTASliceBinder.this.setUpdateStatus(3);
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str = "check device server error " + apiResult + "!!";
                    str2 = str;
                    if (str2 != null) {
                        Pair<String, String> trace7 = logger.getTrace(depth);
                        strComponent1 = trace7.component1();
                        strComponent2 = trace7.component2();
                        FileLog fileLog7 = FileLog.INSTANCE;
                        String str12 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                        FileLog.print$default(fileLog7, 5, str12, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:40:0x011c  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x018c, code lost:
    
        if (r4.download(r5, r7, r10, r13, r14, r15, r1, r12) == r2) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object startDownloadFirmware(ServerFirmware serverFirmware, Continuation<? super Unit> continuation) {
        C07061 c07061;
        String file_size;
        String sha_256;
        ServerFirmware serverFirmware2;
        String str;
        String str2;
        OTASliceBinder oTASliceBinder;
        NothingDevice nothingDevice;
        Pair pairCheckStatus$default;
        int iIntValue;
        NothingDevice nothingDevice2;
        OTASliceBinder oTASliceBinder2;
        Pair pair;
        if (continuation instanceof C07061) {
            c07061 = (C07061) continuation;
            if ((c07061.label & Integer.MIN_VALUE) != 0) {
                c07061.label -= Integer.MIN_VALUE;
            } else {
                c07061 = new C07061(continuation);
            }
        } else {
            c07061 = new C07061(continuation);
        }
        C07061 c07062 = c07061;
        Object obj = c07062.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07062.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            setUpdateStatus(4);
            NothingDevice nothingDevice3 = this.currentNothingDevice;
            if (nothingDevice3 != null) {
                String macAddress = nothingDevice3.getMacAddress();
                String version = serverFirmware.getVersion();
                file_size = serverFirmware.getFile_size();
                sha_256 = serverFirmware.getSha_256();
                c07062.L$0 = this;
                serverFirmware2 = serverFirmware;
                c07062.L$1 = serverFirmware2;
                c07062.L$2 = nothingDevice3;
                c07062.L$3 = sha_256;
                c07062.L$4 = file_size;
                c07062.L$5 = version;
                c07062.L$6 = macAddress;
                c07062.label = 1;
                Object firmwareVersion = nothingDevice3.getFirmwareVersion(c07062);
                if (firmwareVersion != coroutine_suspended) {
                    str = macAddress;
                    str2 = version;
                    oTASliceBinder = this;
                    nothingDevice = nothingDevice3;
                    obj = firmwareVersion;
                    pairCheckStatus$default = checkStatus$default(oTASliceBinder, new ServerCheckItem(str, str2, file_size, sha_256, (String) obj, serverFirmware2.getLink()), false, 2, null);
                    iIntValue = ((Number) pairCheckStatus$default.getFirst()).intValue();
                    if (iIntValue != 1) {
                    }
                    oTASliceBinder.setUpdateStatus(5);
                    NetworkLoadRepo networkLoadRepo = NetworkLoadRepo.INSTANCE;
                    String downloadUrl = ((OTAFirmware) pairCheckStatus$default.getSecond()).getDownloadUrl();
                    String filePath = ((OTAFirmware) pairCheckStatus$default.getSecond()).getFilePath();
                    Intrinsics.checkNotNull(filePath);
                    Long fileSize = ((OTAFirmware) pairCheckStatus$default.getSecond()).getFileSize();
                    Intrinsics.checkNotNull(fileSize);
                    long jLongValue = fileSize.longValue();
                    OTASliceBinder$startDownloadFirmware$2$1 oTASliceBinder$startDownloadFirmware$2$1 = new OTASliceBinder$startDownloadFirmware$2$1(nothingDevice, oTASliceBinder, null);
                    OTASliceBinder$startDownloadFirmware$2$2 oTASliceBinder$startDownloadFirmware$2$2 = new OTASliceBinder$startDownloadFirmware$2$2(nothingDevice, null);
                    OTASliceBinder$startDownloadFirmware$2$3 oTASliceBinder$startDownloadFirmware$2$3 = new OTASliceBinder$startDownloadFirmware$2$3(oTASliceBinder, pairCheckStatus$default, nothingDevice, null);
                    OTASliceBinder$startDownloadFirmware$2$4 oTASliceBinder$startDownloadFirmware$2$4 = new OTASliceBinder$startDownloadFirmware$2$4(null);
                    c07062.L$0 = null;
                    c07062.L$1 = null;
                    c07062.L$2 = null;
                    c07062.L$3 = null;
                    c07062.L$4 = null;
                    c07062.L$5 = null;
                    c07062.L$6 = null;
                    c07062.label = 2;
                }
                return coroutine_suspended;
            }
        } else if (i == 1) {
            String str3 = (String) c07062.L$6;
            String str4 = (String) c07062.L$5;
            file_size = (String) c07062.L$4;
            sha_256 = (String) c07062.L$3;
            NothingDevice nothingDevice4 = (NothingDevice) c07062.L$2;
            ServerFirmware serverFirmware3 = (ServerFirmware) c07062.L$1;
            OTASliceBinder oTASliceBinder3 = (OTASliceBinder) c07062.L$0;
            ResultKt.throwOnFailure(obj);
            str2 = str4;
            oTASliceBinder = oTASliceBinder3;
            str = str3;
            nothingDevice = nothingDevice4;
            serverFirmware2 = serverFirmware3;
            pairCheckStatus$default = checkStatus$default(oTASliceBinder, new ServerCheckItem(str, str2, file_size, sha_256, (String) obj, serverFirmware2.getLink()), false, 2, null);
            iIntValue = ((Number) pairCheckStatus$default.getFirst()).intValue();
            if (iIntValue != 1 || iIntValue == 2) {
                oTASliceBinder.setUpdateStatus(5);
                NetworkLoadRepo networkLoadRepo2 = NetworkLoadRepo.INSTANCE;
                String downloadUrl2 = ((OTAFirmware) pairCheckStatus$default.getSecond()).getDownloadUrl();
                String filePath2 = ((OTAFirmware) pairCheckStatus$default.getSecond()).getFilePath();
                Intrinsics.checkNotNull(filePath2);
                Long fileSize2 = ((OTAFirmware) pairCheckStatus$default.getSecond()).getFileSize();
                Intrinsics.checkNotNull(fileSize2);
                long jLongValue2 = fileSize2.longValue();
                OTASliceBinder$startDownloadFirmware$2$1 oTASliceBinder$startDownloadFirmware$2$5 = new OTASliceBinder$startDownloadFirmware$2$1(nothingDevice, oTASliceBinder, null);
                OTASliceBinder$startDownloadFirmware$2$2 oTASliceBinder$startDownloadFirmware$2$6 = new OTASliceBinder$startDownloadFirmware$2$2(nothingDevice, null);
                OTASliceBinder$startDownloadFirmware$2$3 oTASliceBinder$startDownloadFirmware$2$7 = new OTASliceBinder$startDownloadFirmware$2$3(oTASliceBinder, pairCheckStatus$default, nothingDevice, null);
                OTASliceBinder$startDownloadFirmware$2$4 oTASliceBinder$startDownloadFirmware$2$8 = new OTASliceBinder$startDownloadFirmware$2$4(null);
                c07062.L$0 = null;
                c07062.L$1 = null;
                c07062.L$2 = null;
                c07062.L$3 = null;
                c07062.L$4 = null;
                c07062.L$5 = null;
                c07062.L$6 = null;
                c07062.label = 2;
            } else if (iIntValue == 3 || iIntValue == 4) {
                oTASliceBinder.setUpdateStatus(8);
                c07062.L$0 = oTASliceBinder;
                c07062.L$1 = nothingDevice;
                c07062.L$2 = pairCheckStatus$default;
                c07062.L$3 = null;
                c07062.L$4 = null;
                c07062.L$5 = null;
                c07062.L$6 = null;
                c07062.label = 3;
                if (oTASliceBinder.notifyDeviceFindNewVersion(nothingDevice, true, c07062) != coroutine_suspended) {
                    nothingDevice2 = nothingDevice;
                    oTASliceBinder2 = oTASliceBinder;
                    c07062.L$0 = oTASliceBinder2;
                    c07062.L$1 = pairCheckStatus$default;
                    c07062.L$2 = null;
                    c07062.label = 4;
                    if (oTASliceBinder2.notifyDeviceToUpgrade(nothingDevice2, true, c07062) != coroutine_suspended) {
                        pair = pairCheckStatus$default;
                        oTASliceBinder2.currentFirmware = (OTAFirmware) pair.getSecond();
                    }
                }
                return coroutine_suspended;
            }
        } else if (i != 2) {
            if (i == 3) {
                Pair pair2 = (Pair) c07062.L$2;
                nothingDevice2 = (NothingDevice) c07062.L$1;
                OTASliceBinder oTASliceBinder4 = (OTASliceBinder) c07062.L$0;
                ResultKt.throwOnFailure(obj);
                pairCheckStatus$default = pair2;
                oTASliceBinder2 = oTASliceBinder4;
                c07062.L$0 = oTASliceBinder2;
                c07062.L$1 = pairCheckStatus$default;
                c07062.L$2 = null;
                c07062.label = 4;
                if (oTASliceBinder2.notifyDeviceToUpgrade(nothingDevice2, true, c07062) != coroutine_suspended) {
                    pair = pairCheckStatus$default;
                }
                return coroutine_suspended;
            }
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            pair = (Pair) c07062.L$1;
            oTASliceBinder2 = (OTASliceBinder) c07062.L$0;
            ResultKt.throwOnFailure(obj);
            oTASliceBinder2.currentFirmware = (OTAFirmware) pair.getSecond();
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void startTransferOTAData$default(OTASliceBinder oTASliceBinder, boolean z, String str, int i, Object obj) throws Throwable {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            str = "";
        }
        oTASliceBinder.startTransferOTAData(z, str);
    }

    public final void startTransferOTAData(boolean isLocal, String filePath) throws Throwable {
        String filePath2;
        setUpdateStatus(9);
        String str = "";
        if (!isLocal) {
            OTAFirmware oTAFirmware = this.currentFirmware;
            if (oTAFirmware != null && (filePath2 = oTAFirmware.getFilePath()) != null) {
                str = filePath2;
            }
        } else if (filePath != null) {
            str = filePath;
        }
        if (str.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "ota path is null ".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str2 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog, 4, str2, tag, "ota path is null  " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "ota path is null  " + strComponent2);
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
            String str3 = "ota path is " + str + StringUtils.SPACE;
            String str4 = str3;
            if (str4 != null && str4.length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str5 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                FileLog.print$default(fileLog2, 4, str5, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        OTAFileHelper.INSTANCE.setFileMsg(str, isLocal ? 1 : 2);
        UUID uuid = this.currentRemoteJobId;
        if (uuid != null) {
            getWorkManager().cancelWorkById(uuid);
            this.currentRemoteJobId = null;
        }
        NothingDevice nothingDevice = this.currentNothingDevice;
        if (nothingDevice != null) {
            Data dataBuild = new Data.Builder().putString(OTASliceWorker.MAC_ADDRESS, nothingDevice.getMacAddress()).build();
            Intrinsics.checkNotNullExpressionValue(dataBuild, "build(...)");
            OneTimeWorkRequest oneTimeWorkRequestBuild = new OneTimeWorkRequest.Builder(OTASliceWorker.class).setBackoffCriteria(BackoffPolicy.LINEAR, 1L, TimeUnit.SECONDS).setInputData(dataBuild).build();
            this.currentWorkRequest = oneTimeWorkRequestBuild;
            this.currentRemoteJobId = oneTimeWorkRequestBuild != null ? oneTimeWorkRequestBuild.getId() : null;
            WorkManager workManager = getWorkManager();
            OneTimeWorkRequest oneTimeWorkRequest = this.currentWorkRequest;
            Intrinsics.checkNotNull(oneTimeWorkRequest);
            workManager.enqueue(oneTimeWorkRequest);
        }
    }

    public static /* synthetic */ void stopOTA$default(OTASliceBinder oTASliceBinder, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        oTASliceBinder.stopOTA(z);
    }

    public final void stopOTA(boolean isClearMD5) {
        String address;
        UUID id;
        NothingDevice nothingDevice;
        TWSDevice twsDevice;
        TWSSliceCallBack tWSSliceCallBack = this.twsCallBack;
        if (tWSSliceCallBack != null && (nothingDevice = this.currentNothingDevice) != null && (twsDevice = nothingDevice.getTwsDevice()) != null) {
            twsDevice.unregister(tWSSliceCallBack);
        }
        if (isClearMD5) {
            OTAFirmware oTAFirmware = this.currentFirmware;
            if (oTAFirmware != null) {
                oTAFirmware.setFileMD5("");
            }
            OTAFirmware oTAFirmware2 = this.currentFirmware;
            if (oTAFirmware2 != null) {
                oTAFirmware2.setCodes("");
            }
        } else {
            OTAFirmware oTAFirmware3 = this.currentFirmware;
            OTAFirmware oTAFirmware4 = (oTAFirmware3 == null || (address = oTAFirmware3.getAddress()) == null) ? null : (OTAFirmware) CollectionsKt.firstOrNull((List) DatabaseUtils.INSTANCE.getFirmwareDao().getOTAFirmware(address));
            if (oTAFirmware4 != null) {
                OTAFirmware oTAFirmware5 = this.currentFirmware;
                if (oTAFirmware5 != null) {
                    oTAFirmware5.setUpdateStatus(oTAFirmware4.getUpdateStatus());
                }
                OTAFirmware oTAFirmware6 = this.currentFirmware;
                if (oTAFirmware6 != null) {
                    oTAFirmware6.setFileMD5(oTAFirmware4.getFileMD5());
                }
                OTAFirmware oTAFirmware7 = this.currentFirmware;
                if (oTAFirmware7 != null) {
                    oTAFirmware7.setCodes(oTAFirmware4.getCodes());
                }
            }
        }
        OTAFirmware oTAFirmware8 = this.currentFirmware;
        if (oTAFirmware8 != null) {
            DatabaseUtils.INSTANCE.getFirmwareDao().updateOTAFirmware(oTAFirmware8);
        }
        OneTimeWorkRequest oneTimeWorkRequest = this.currentWorkRequest;
        if (oneTimeWorkRequest != null && (id = oneTimeWorkRequest.getId()) != null) {
            getWorkManager().cancelWorkById(id);
        }
        this.currentWorkRequest = null;
        this.currentRemoteJobId = null;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.ota.slice.OTASliceBinder$notifyDeviceToStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OTASliceBinder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.ota.slice.OTASliceBinder$notifyDeviceToStop$1", f = "OTASliceBinder.kt", i = {0}, l = {300}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class C07041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C07041(Continuation<? super C07041> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C07041 c07041 = OTASliceBinder.this.new C07041(continuation);
            c07041.L$0 = obj;
            return c07041;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x005f  */
        /* JADX WARN: Code duplicated, block: B:27:0x00c3  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Boolean bool;
            TWSDevice twsDevice;
            Logger logger;
            String tag;
            int depth;
            String str;
            String str2;
            String strComponent1;
            String strComponent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                NothingDevice nothingDevice = OTASliceBinder.this.currentNothingDevice;
                if (nothingDevice == null || (twsDevice = nothingDevice.getTwsDevice()) == null) {
                    bool = null;
                } else {
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = TWSDevice.syncSet$default(twsDevice, ProtocolConstant.Set.OTA_STOP_ERROR, null, null, false, this, 14, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str = "notifyDeviceToUpgrade result -> " + bool;
                    str2 = str;
                    if (str2 != null && str2.length() != 0) {
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
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            bool = (Boolean) obj;
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "notifyDeviceToUpgrade result -> " + bool;
                str2 = str;
                if (str2 != null) {
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
            return Unit.INSTANCE;
        }
    }

    public final void notifyDeviceToStop() {
        CoroutineScope coroutineScope = this.coroutineIo;
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C07041(null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0075  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object notifyDeviceToUpgrade(NothingDevice nothingDevice, boolean z, Continuation<? super Unit> continuation) {
        C07051 c07051;
        Boolean bool;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        if (continuation instanceof C07051) {
            c07051 = (C07051) continuation;
            if ((c07051.label & Integer.MIN_VALUE) != 0) {
                c07051.label -= Integer.MIN_VALUE;
            } else {
                c07051 = new C07051(continuation);
            }
        } else {
            c07051 = new C07051(continuation);
        }
        C07051 c07052 = c07051;
        Object objSyncSet$default = c07052.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07052.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSyncSet$default);
            TWSDevice twsDevice = nothingDevice.getTwsDevice();
            bool = null;
            if (twsDevice != null) {
                byte[] byteArray$default = DataExtKt.toByteArray$default(z ? 1 : 0, 0, 1, (Object) null);
                c07052.L$0 = this;
                c07052.Z$0 = z;
                c07052.label = 1;
                objSyncSet$default = TWSDevice.syncSet$default(twsDevice, ProtocolConstant.Set.OTA_DOWNLOADED_NEW_VERSION, byteArray$default, null, false, c07052, 12, null);
                if (objSyncSet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "notifyDeviceToUpgrade result -> " + bool + " ,isReady:" + z;
                str2 = str;
                if (str2 != null && str2.length() != 0) {
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
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean z2 = c07052.Z$0;
        ResultKt.throwOnFailure(objSyncSet$default);
        z = z2;
        bool = (Boolean) objSyncSet$default;
        logger = Logger.INSTANCE;
        tag = logger.getTAG();
        depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            str = "notifyDeviceToUpgrade result -> " + bool + " ,isReady:" + z;
            str2 = str;
            if (str2 != null) {
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0075  */
    /* JADX WARN: Code duplicated, block: B:30:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object notifyDeviceFindNewVersion(NothingDevice nothingDevice, boolean z, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Boolean bool;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objSyncSet$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSyncSet$default);
            TWSDevice twsDevice = nothingDevice.getTwsDevice();
            bool = null;
            if (twsDevice != null) {
                byte[] byteArray$default = DataExtKt.toByteArray$default(z ? 1 : 0, 0, 1, (Object) null);
                anonymousClass2.L$0 = this;
                anonymousClass2.Z$0 = z;
                anonymousClass2.label = 1;
                objSyncSet$default = TWSDevice.syncSet$default(twsDevice, ProtocolConstant.Set.OTA_FIND_NEW_VERSION, byteArray$default, null, false, anonymousClass2, 12, null);
                if (objSyncSet$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "notifyDeviceFindNewVersion result -> " + bool + " ,isDownload:" + z;
                str2 = str;
                if (str2 != null && str2.length() != 0) {
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
            return Unit.INSTANCE;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean z2 = anonymousClass2.Z$0;
        ResultKt.throwOnFailure(objSyncSet$default);
        z = z2;
        bool = (Boolean) objSyncSet$default;
        logger = Logger.INSTANCE;
        tag = logger.getTAG();
        depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            str = "notifyDeviceFindNewVersion result -> " + bool + " ,isDownload:" + z;
            str2 = str;
            if (str2 != null) {
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
        return Unit.INSTANCE;
    }

    static /* synthetic */ Pair checkStatus$default(OTASliceBinder oTASliceBinder, ServerCheckItem serverCheckItem, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return oTASliceBinder.checkStatus(serverCheckItem, z);
    }

    private final Pair<Integer, OTAFirmware> checkStatus(ServerCheckItem checkItem, boolean isBin) {
        File externalFilesDir;
        OTAFirmware oTAFirmware = (OTAFirmware) CollectionsKt.firstOrNull((List) DatabaseUtils.INSTANCE.getFirmwareDao().getOTAFirmware(checkItem.getDeviceAddress()));
        if (oTAFirmware == null || !Intrinsics.areEqual(oTAFirmware.getServerVersion(), checkItem.getServerVersion())) {
            NTLog.i("updateStatus: firmwareItem=" + (oTAFirmware == null));
            if (oTAFirmware != null) {
                DatabaseUtils.INSTANCE.getFirmwareDao().deleteOTAFirmware(oTAFirmware);
            }
            String serverVersion = checkItem.getServerVersion();
            String absolutePath = null;
            String strReplace$default = serverVersion != null ? StringsKt.replace$default(serverVersion, ".", "", false, 4, (Object) null) : null;
            String strReplace$default2 = StringsKt.replace$default(checkItem.getDeviceAddress(), TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null);
            long jCurrentTimeMillis = System.currentTimeMillis() % ((long) 1000);
            Application application = AppGlobals.INSTANCE.get();
            if (application != null && (externalFilesDir = application.getExternalFilesDir(null)) != null) {
                absolutePath = externalFilesDir.getAbsolutePath();
            }
            String str = (absolutePath + File.separator) + strReplace$default2 + strReplace$default + jCurrentTimeMillis;
            if (isBin) {
                str = str + ".bin";
            }
            String str2 = str;
            String deviceAddress = checkItem.getDeviceAddress();
            Long lValueOf = Long.valueOf(checkItem.getServerFileSize());
            String serverVersion2 = checkItem.getServerVersion();
            String str3 = serverVersion2 == null ? "" : serverVersion2;
            String serverFileUrl = checkItem.getServerFileUrl();
            OTAFirmware oTAFirmware2 = new OTAFirmware(deviceAddress, 1, lValueOf, str2, str3, serverFileUrl == null ? "" : serverFileUrl, (byte[]) null, "");
            DatabaseUtils.INSTANCE.getFirmwareDao().insertOTAFirmware(oTAFirmware2);
            return TuplesKt.to(1, oTAFirmware2);
        }
        return TuplesKt.to(Integer.valueOf(oTAFirmware.getUpdateStatus()), oTAFirmware);
    }

    public final void onDestroy() {
        NothingDevice nothingDevice;
        TWSDevice twsDevice;
        OTADevice oTADevice;
        OTADevice oTADevice2;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "ota slice binder destroy!!!".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "ota slice binder destroy!!! " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "ota slice binder destroy!!! " + strComponent2);
            }
        }
        OTADeviceCallBack oTADeviceCallBack = this.otaCallBack;
        if (oTADeviceCallBack != null) {
            NothingDevice nothingDevice2 = this.currentNothingDevice;
            if (nothingDevice2 != null && (oTADevice2 = nothingDevice2.getOTADevice()) != null) {
                OTADevice.unregister$default(oTADevice2, oTADeviceCallBack, null, 2, null);
            }
            NothingDevice nothingDevice3 = this.currentNothingDevice;
            if (nothingDevice3 != null && (oTADevice = nothingDevice3.getOTADevice()) != null) {
                oTADevice.release();
            }
        }
        this.otaCallBack = null;
        TWSSliceCallBack tWSSliceCallBack = this.twsCallBack;
        if (tWSSliceCallBack != null && (nothingDevice = this.currentNothingDevice) != null && (twsDevice = nothingDevice.getTwsDevice()) != null) {
            twsDevice.unregister(tWSSliceCallBack);
        }
        this.twsCallBack = null;
        CoroutineScope coroutineScope = this.coroutineIo;
        if (coroutineScope != null) {
            CoroutineScopeKt.cancel$default(coroutineScope, null, 1, null);
        }
        this.coroutineIo = null;
    }
}
