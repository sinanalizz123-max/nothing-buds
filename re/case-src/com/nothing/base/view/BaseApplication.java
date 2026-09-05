package com.nothing.base.view;

import android.app.Application;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blankj.utilcode.util.Utils;
import com.fluttercandies.photo_manager.constant.Methods;
import com.google.firebase.messaging.FirebaseMessageUtil;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.BtWidgetRefreshGate;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.PhoneUtil;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.caseble.NothingCaseParser;
import com.nothing.database.util.SpUtils;
import com.nothing.earbase.essential.skywalk.SkyWalkUtil;
import com.nothing.earbase.os.background.OSBackgroundLifecycle;
import com.nothing.earbase.widget.news.NewsMedia3Manager;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.foreground.models.ForegroundServiceAction;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.config.XBluetoothConfig;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingAudioParser;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingParser;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingWatchParser;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.log.LoggerObserver;
import com.nothing.nt_ear.NtFlutterSharedPreference;
import com.nothing.nt_lifecycle.service.BluetoothDaemonService;
import com.nothing.nt_route.FlutterEngineProvider;
import com.nothing.nt_system_runtime.utils.PreviewUtils;
import com.nothing.supermic.WalkTalkTitleService;
import com.nothing.walktalk.WalkieTalkieHelper;
import io.flutter.FlutterInjector;
import io.flutter.embedding.engine.loader.FlutterLoader;
import java.io.File;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BaseApplication.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0006\b\u0016\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\u0012\u001a\u00020\tH\u0002J\b\u0010\u0013\u001a\u00020\tH\u0002J\b\u0010\u0014\u001a\u00020\tH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001e"}, d2 = {"Lcom/nothing/base/view/BaseApplication;", "Landroid/app/Application;", "Landroidx/lifecycle/ViewModelStoreOwner;", "<init>", "()V", "broadcastReceiver", "com/nothing/base/view/BaseApplication$broadcastReceiver$1", "Lcom/nothing/base/view/BaseApplication$broadcastReceiver$1;", "onCreate", "", "clearStaleFgNotificationAndDaemon", "preloadSkybudsSo", "hasRegister", "", "getHasRegister", "()Z", "setHasRegister", "(Z)V", "registerBroadcastReceiver", "setPhoneUISize", "initRouter", "getViewModelStoreLocal", "Landroidx/lifecycle/ViewModelStore;", "onTrimMemory", "level", "", "viewModelStore", "getViewModelStore", "()Landroidx/lifecycle/ViewModelStore;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseApplication extends Application implements ViewModelStoreOwner {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NothingX";
    private static boolean isAppRunning;
    private static Locale systemLocal;
    private BaseApplication$broadcastReceiver$1 broadcastReceiver = new BroadcastReceiver() { // from class: com.nothing.base.view.BaseApplication$broadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            boolean zAreEqual = Intrinsics.areEqual(action, "android.intent.action.USER_UNLOCKED");
            if ((Intrinsics.areEqual(action, "android.intent.action.USER_PRESENT") || zAreEqual) && context != null) {
                BaseApplication baseApplication = this.this$0;
                String str = Intrinsics.areEqual(action, "android.intent.action.USER_PRESENT") ? "userPresent" : "userUnlocked";
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str2 = "application engine init trigger " + action;
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
                if (FlutterEngineProvider.INSTANCE.getEngineOrNull() == null) {
                    FlutterEngineProvider.INSTANCE.launchGuaranteedEngineInit(context, str);
                    BluetoothDaemonService.INSTANCE.restartService(baseApplication, ForegroundServiceAction.RESTART);
                }
            }
        }
    };
    private boolean hasRegister;

    /* JADX INFO: compiled from: BaseApplication.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lcom/nothing/base/view/BaseApplication$Companion;", "", "<init>", "()V", "systemLocal", "Ljava/util/Locale;", "getSystemLocal", "()Ljava/util/Locale;", "setSystemLocal", "(Ljava/util/Locale;)V", "isAppRunning", "", "()Z", "setAppRunning", "(Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", Methods.log, "", NotificationCompat.CATEGORY_MESSAGE, "initBluetoothManager", "context", "Landroid/content/Context;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Locale getSystemLocal() {
            return BaseApplication.systemLocal;
        }

        public final void setSystemLocal(Locale locale) {
            BaseApplication.systemLocal = locale;
        }

        public final boolean isAppRunning() {
            return BaseApplication.isAppRunning;
        }

        public final void setAppRunning(boolean z) {
            BaseApplication.isAppRunning = z;
        }

        public final String getTAG() {
            return BaseApplication.TAG;
        }

        public final void log(String msg) {
            Log.i(getTAG(), String.valueOf(msg));
        }

        public final void initBluetoothManager(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (XBluetoothManager.INSTANCE.get().getBluetoothManager() != null) {
                return;
            }
            try {
                XBluetoothManager.INSTANCE.get().init(context, XBluetoothConfig.INSTANCE.builder().setMaxConnectNum(6).setConnectMillisTimeOut(40000L).setConnectRetryCountAndInterval(0, 1000L).setOperateInterval(100L).setOperateMillisTimeOut(3000L).setScanMillisTimeOut(300000L).setScanRetryCountAndInterval(0, 1000L).setScanServiceUuid(new String[0]).setScanManufacturerId(NothingParser.NOTHING_MANUFACTURER_ID_NEW, 11454, 65535, 48684).setMtu(511).setScanParser(new NothingWatchParser(), new NothingAudioParser(), new NothingCaseParser()).setEnableLog(false).build());
            } catch (Exception e) {
                log("App initBluetoothManager error " + e.getMessage());
            }
        }
    }

    @Override // android.app.Application
    public void onCreate() {
        Companion companion = INSTANCE;
        companion.log("App running .");
        super.onCreate();
        clearStaleFgNotificationAndDaemon();
        try {
            FlutterLoader flutterLoader = FlutterInjector.instance().flutterLoader();
            Intrinsics.checkNotNullExpressionValue(flutterLoader, "flutterLoader(...)");
            if (!flutterLoader.initialized()) {
                companion.log("flutterLoader start init");
                flutterLoader.startInitialization(this);
                flutterLoader.ensureInitializationComplete(this, null);
                companion.log("flutterLoader end init");
            }
            preloadSkybudsSo();
        } catch (Exception e) {
            e.printStackTrace();
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "Created new error: " + e.getMessage();
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
        }
        BaseApplication baseApplication = this;
        Thread.setDefaultUncaughtExceptionHandler(new NTCrashHandler(baseApplication));
        boolean zIsPreviewMode = NtFlutterSharedPreference.INSTANCE.isPreviewMode(baseApplication);
        SpUtils.INSTANCE.setStartFragmentDialogAgree(NtFlutterSharedPreference.INSTANCE.isChinaPrivacyPolicyAgreed(baseApplication));
        PreviewUtils.INSTANCE.setChangePreviewMode(zIsPreviewMode);
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass2(zIsPreviewMode, null), 3, null);
        FirebaseMessageUtil.INSTANCE.init(baseApplication);
        Companion companion2 = INSTANCE;
        isAppRunning = true;
        systemLocal = null;
        setPhoneUISize();
        WalkTalkTitleService.INSTANCE.setTileEnabled(baseApplication);
        BaseApplication baseApplication2 = this;
        Utils.init(baseApplication2);
        if (!FlutterEngineProvider.INSTANCE.isDeviceLockedAndScreenOff(baseApplication)) {
            RouterFactory.INSTANCE.getWidgetRouter().freshSqlWidget(baseApplication);
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass3(null), 3, null);
        }
        AppBuriedPointUtils.INSTANCE.appUseTimeInit(baseApplication2);
        registerActivityLifecycleCallbacks(new OSBackgroundLifecycle(new Function1() { // from class: com.nothing.base.view.BaseApplication$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseApplication.onCreate$lambda$1(((Boolean) obj).booleanValue());
            }
        }));
        companion2.log("App running done!");
        com.nothing.base.util.Utils.INSTANCE.setProcessIsKill(-1);
    }

    /* JADX INFO: renamed from: com.nothing.base.view.BaseApplication$onCreate$2, reason: invalid class name */
    /* JADX INFO: compiled from: BaseApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.base.view.BaseApplication$onCreate$2", f = "BaseApplication.kt", i = {}, l = {159, 162, 165}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isPreview;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$isPreview = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseApplication.this.new AnonymousClass2(this.$isPreview, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x00aa  */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00c5, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.base.view.BaseApplication.AnonymousClass2.AnonymousClass1(r9.$isPreview, r9.this$0, null), r9) == r0) goto L28;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (NothingOSUtil.INSTANCE.isNothingOS()) {
                    LoggerObserver.INSTANCE.addObserver(BaseApplication.this);
                }
                NtFlutterSharedPreference.INSTANCE.syncDataToFlutter(BaseApplication.this);
                FileLog.INSTANCE.setMaxFileLength(10485760);
                FileLog.INSTANCE.setDir(new File(BaseApplication.this.getFilesDir(), Methods.log));
                com.nothing.base.util.Logger.initDebugFlag(BaseApplication.this);
                BaseApplication.this.initRouter();
                if (!this.$isPreview) {
                    BaseApplication.INSTANCE.initBluetoothManager(BaseApplication.this);
                }
                SkyWalkUtil.INSTANCE.initSkyWalkSdk(BaseApplication.this);
                this.label = 1;
                if (DelayKt.delay(1000L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                this.label = 3;
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (!this.$isPreview && FlutterEngineProvider.INSTANCE.isDeviceReadyForEngineInit(BaseApplication.this)) {
                BaseApplication.INSTANCE.log("schedule guaranteed engine init, elapsedRealtime:" + SystemClock.elapsedRealtime());
                FlutterEngineProvider.INSTANCE.launchGuaranteedEngineInit(BaseApplication.this, "applicationOnCreate");
            } else if (!this.$isPreview) {
                BaseApplication.INSTANCE.log("defer guaranteed engine init until user unlock / screen on");
            }
            return Unit.INSTANCE;
            if (this.$isPreview) {
                this.label = 3;
            } else {
                RouterFactory.INSTANCE.getWidgetRouter().initMediaPlayer(BaseApplication.this);
                this.label = 2;
                if (DelayKt.delay(1000L, this) != coroutine_suspended) {
                    this.label = 3;
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.nothing.base.view.BaseApplication$onCreate$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: BaseApplication.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.base.view.BaseApplication$onCreate$2$1", f = "BaseApplication.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isPreview;
            int label;
            final /* synthetic */ BaseApplication this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(boolean z, BaseApplication baseApplication, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$isPreview = z;
                this.this$0 = baseApplication;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$isPreview, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (!this.$isPreview) {
                    this.this$0.registerBroadcastReceiver();
                    NewsMedia3Manager.initMediaBrowserCompat$default(NewsMedia3Manager.INSTANCE, this.this$0, false, 2, null);
                    WalkieTalkieHelper.INSTANCE.registerBroadCast(this.this$0);
                }
                RouterFactory.INSTANCE.getAudiodoRouter().initAudioDo(this.this$0);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.base.view.BaseApplication$onCreate$3, reason: invalid class name */
    /* JADX INFO: compiled from: BaseApplication.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.base.view.BaseApplication$onCreate$3", f = "BaseApplication.kt", i = {}, l = {199}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseApplication.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(3000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable()) {
                BtWidgetRefreshGate.requestFreshWidget(BaseApplication.this, "boot_bt_resync");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$1(boolean z) {
        return Unit.INSTANCE;
    }

    private final void clearStaleFgNotificationAndDaemon() {
        try {
            stopService(new Intent(this, (Class<?>) BluetoothDaemonService.class));
        } catch (Exception unused) {
        }
        try {
            Object systemService = getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            ((NotificationManager) systemService).cancelAll();
        } catch (Exception unused2) {
        }
    }

    private final void preloadSkybudsSo() {
        try {
            System.loadLibrary("skybuds_processor");
            INSTANCE.log("Skybuds native so preloaded successfully");
        } catch (UnsatisfiedLinkError e) {
            INSTANCE.log("Skybuds native preload failed:" + e);
        }
    }

    public final boolean getHasRegister() {
        return this.hasRegister;
    }

    public final void setHasRegister(boolean z) {
        this.hasRegister = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerBroadcastReceiver() {
        if (this.hasRegister) {
            return;
        }
        this.hasRegister = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        intentFilter.addAction("android.intent.action.USER_UNLOCKED");
        if (Build.VERSION.SDK_INT >= 33) {
            registerReceiver(this.broadcastReceiver, intentFilter, 2);
        } else {
            registerReceiver(this.broadcastReceiver, intentFilter);
        }
    }

    private final void setPhoneUISize() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Configuration configuration = getResources().getConfiguration();
        PhoneUtil.INSTANCE.setDisplayDensity(displayMetrics.density);
        PhoneUtil.INSTANCE.setFontSize(configuration.fontScale);
    }

    public void initRouter() {
        RouterFactory.INSTANCE.initDeviceRouter();
    }

    private final ViewModelStore getViewModelStoreLocal() {
        if (BaseApplicationKt.getViewStore() == null) {
            BaseApplicationKt.setViewStore(new ViewModelStore());
        }
        ViewModelStore viewStore = BaseApplicationKt.getViewStore();
        Intrinsics.checkNotNull(viewStore);
        return viewStore;
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.d("ProcessKill", "level:" + level);
        if (level >= 20) {
            Log.d("ProcessKill", "onTrimMemory");
            com.nothing.base.util.Utils.INSTANCE.setProcessIsKill(-1);
        }
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return getViewModelStoreLocal();
    }
}
