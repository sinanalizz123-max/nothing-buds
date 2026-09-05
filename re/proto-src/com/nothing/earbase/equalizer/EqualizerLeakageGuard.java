package com.nothing.earbase.equalizer;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LiveData;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.ScenarioModeEntity;
import com.nothing.base.util.Logger;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseFragment;
import com.nothing.base.view.BaseOSActivity;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.unknown.entity.DeviceMappingCache;
import com.nothing.earbase.unknown.entity.UnknownFunction;
import com.nothing.earbase.unknown.entity.WhiteListConfigCache;
import com.nothing.generate.NtEarFlutterApi;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.log.FileLog;
import com.nothing.nt_ear.NtEarPlugin;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import net.openid.appauth.AuthorizationRequest;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0010\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0005J\b\u0010\u0014\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u001c\u001a\u00020\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\tH\u0082@\u00a2\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0082@\u00a2\u0006\u0002\u0010#J\u0018\u0010$\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0082@\u00a2\u0006\u0002\u0010#J\u0018\u0010%\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0086@\u00a2\u0006\u0002\u0010#J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020*H\u0002J\u001c\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020)2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160.J\u001c\u0010+\u001a\u00020\u00162\u0006\u0010/\u001a\u00020*2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160.J\u001a\u00100\u001a\u00020\u00162\u0006\u0010,\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J\u001a\u00100\u001a\u00020\u00162\u0006\u0010/\u001a\u00020*2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000eH\u0002J.\u00101\u001a\u00020\u00162\u0006\u0010,\u001a\u00020)2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00160.H\u0086@\u00a2\u0006\u0002\u00103J.\u00101\u001a\u00020\u00162\u0006\u0010/\u001a\u00020*2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00160.H\u0086@\u00a2\u0006\u0002\u00104R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0011\u00a8\u00065"}, d2 = {"Lcom/nothing/earbase/equalizer/EqualizerLeakageGuard;", "", "<init>", "()V", "SCENARIO_MODE_OFF", "", "BLE_FALLBACK_TIMEOUT_MS", "", "TAG", "", "cachedMode", "cacheReady", "", "observedDevice", "Lcom/nothing/protocol/device/TWSDevice;", "scenarioObserver", "com/nothing/earbase/equalizer/EqualizerLeakageGuard$scenarioObserver$1", "Lcom/nothing/earbase/equalizer/EqualizerLeakageGuard$scenarioObserver$1;", "isLeakageOn", "mode", "isLeakageProtectionSupported", "updateCache", "", "applyScenarioFromMessage", "message", "Lcom/nothing/protocol/model/Message;", "startObserving", "device", "stopObserving", "flutterApi", "Lcom/nothing/generate/NtEarFlutterApi;", "fetchScenarioModeFromFlutterPeek", "realMac", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchScenarioModeFromBleSync", "(Lcom/nothing/protocol/device/TWSDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveScenarioMode", "setScenarioOff", "buildConflictViewModel", "Lcom/nothing/base/dialog/confirm/ConfirmMsgViewModel;", "host", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentActivity;", "showConflictDialog", AuthorizationRequest.ResponseMode.FRAGMENT, "onTurnOff", "Lkotlin/Function0;", "activity", "scheduleTurnOff", "guardEqAction", "action", "(Landroidx/fragment/app/Fragment;Lcom/nothing/protocol/device/TWSDevice;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroidx/fragment/app/FragmentActivity;Lcom/nothing/protocol/device/TWSDevice;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EqualizerLeakageGuard {
    private static final long BLE_FALLBACK_TIMEOUT_MS = 800;
    private static final int SCENARIO_MODE_OFF = 0;
    private static final String TAG = "EqualizerLeakageGuard";
    private static volatile boolean cacheReady;
    private static volatile int cachedMode;
    private static volatile TWSDevice observedDevice;
    public static final EqualizerLeakageGuard INSTANCE = new EqualizerLeakageGuard();
    private static final EqualizerLeakageGuard$scenarioObserver$1 scenarioObserver = new TWSDevice.Callback() { // from class: com.nothing.earbase.equalizer.EqualizerLeakageGuard$scenarioObserver$1
        @Override // com.nothing.protocol.device.TWSDevice.Callback
        public void onConnected() {
        }

        @Override // com.nothing.protocol.device.TWSDevice.Callback
        public void onError(int code, String message) {
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
        public void onConnected(TWSDevice tWSDevice) {
            TWSDevice.Callback.DefaultImpls.onConnected(this, tWSDevice);
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
        public void onError(TWSDevice tWSDevice, int i, String str) {
            TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i, str);
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
        public void onUpdate(int cmdType, Message data) {
            Intrinsics.checkNotNullParameter(data, "data");
            if (cmdType == 49265) {
                EqualizerLeakageGuard.INSTANCE.applyScenarioFromMessage(data);
            }
        }

        @Override // com.nothing.protocol.device.TWSDevice.Callback
        public void onDisconnected() {
            EqualizerLeakageGuard equalizerLeakageGuard = EqualizerLeakageGuard.INSTANCE;
            EqualizerLeakageGuard.cacheReady = false;
        }
    };

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$fetchScenarioModeFromBleSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard", f = "EqualizerLeakageGuard.kt", i = {0}, l = {160}, m = "fetchScenarioModeFromBleSync", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EqualizerLeakageGuard.this.fetchScenarioModeFromBleSync(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard", f = "EqualizerLeakageGuard.kt", i = {1, 1, 1, 1}, l = {267, 270, 273, 276}, m = "guardEqAction", n = {"this", AuthorizationRequest.ResponseMode.FRAGMENT, "device", "action"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C06571 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C06571(Continuation<? super C06571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EqualizerLeakageGuard.this.guardEqAction((Fragment) null, (TWSDevice) null, (Function0<Unit>) null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$6, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard", f = "EqualizerLeakageGuard.kt", i = {1, 1, 1, 1}, l = {289, 292, 295, 298}, m = "guardEqAction", n = {"this", "activity", "device", "action"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass6 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EqualizerLeakageGuard.this.guardEqAction((FragmentActivity) null, (TWSDevice) null, (Function0<Unit>) null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$resolveScenarioMode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard", f = "EqualizerLeakageGuard.kt", i = {0, 0}, l = {183, 188}, m = "resolveScenarioMode", n = {"this", "device"}, s = {"L$0", "L$1"})
    static final class C06591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06591(Continuation<? super C06591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EqualizerLeakageGuard.this.resolveScenarioMode(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$setScenarioOff$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard", f = "EqualizerLeakageGuard.kt", i = {0, 0, 1, 1}, l = {193, 313}, m = "setScenarioOff", n = {"this", "device", "this", "needUpdate$iv"}, s = {"L$0", "L$1", "L$0", "I$0"})
    static final class C06621 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C06621(Continuation<? super C06621> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EqualizerLeakageGuard.this.setScenarioOff(null, this);
        }
    }

    public final boolean isLeakageOn(int mode) {
        return mode == 2;
    }

    private EqualizerLeakageGuard() {
    }

    private final boolean isLeakageProtectionSupported() {
        WhiteListConfigCache whiteListConfigByProductId;
        List<UnknownFunction> configs;
        UnknownFunction unknownFunction;
        IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(SpUtils.INSTANCE.getSelectDeviceMac());
        String productId = productByMacAddress != null ? productByMacAddress.getProductId() : null;
        String str = productId;
        if (str == null || StringsKt.isBlank(str) || (whiteListConfigByProductId = DeviceMappingCache.INSTANCE.getWhiteListConfigByProductId(productId)) == null || (configs = whiteListConfigByProductId.getConfigs()) == null || (unknownFunction = (UnknownFunction) CollectionsKt.firstOrNull((List) configs)) == null) {
            return true;
        }
        return unknownFunction.isSupportLeakageProtection();
    }

    private final void updateCache(int mode) {
        cachedMode = mode;
        cacheReady = true;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "EqualizerLeakageGuard cache updated mode=" + mode;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyScenarioFromMessage(Message message) {
        ScenarioModeEntity scenarioModeEntity = (ScenarioModeEntity) message.obtainPayload(ScenarioModeEntity.class);
        updateCache(scenarioModeEntity != null ? scenarioModeEntity.getMode() : 0);
    }

    public final void startObserving(TWSDevice device) {
        if (device == null) {
            return;
        }
        stopObserving();
        observedDevice = device;
        device.register(scenarioObserver);
        if (!isLeakageProtectionSupported()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "EqualizerLeakageGuard startObserving skipped: leakage protection unsupported".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "EqualizerLeakageGuard startObserving skipped: leakage protection unsupported " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "EqualizerLeakageGuard startObserving skipped: leakage protection unsupported " + strComponent2);
                    return;
                }
                return;
            }
            return;
        }
        Message cacheCommandsManual = device.getCacheCommandsManual(ProtocolConstant.Query.GET_SCENARIO_MODE);
        if (cacheCommandsManual != null) {
            INSTANCE.applyScenarioFromMessage(cacheCommandsManual);
        }
        TWSDevice.sendMessage$default(device, ProtocolConstant.Query.GET_SCENARIO_MODE, null, false, true, null, null, 0, 118, null);
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str2 = "EqualizerLeakageGuard startObserving cacheReady=" + cacheReady + " mode=" + cachedMode;
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                return;
            }
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

    public final void stopObserving() {
        TWSDevice tWSDevice = observedDevice;
        if (tWSDevice != null) {
            tWSDevice.unregister(scenarioObserver);
        }
        observedDevice = null;
        cacheReady = false;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "EqualizerLeakageGuard stopObserving".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "EqualizerLeakageGuard stopObserving " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "EqualizerLeakageGuard stopObserving " + strComponent2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NtEarFlutterApi flutterApi() {
        try {
            FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get("main");
            if (flutterEngine != null) {
                FlutterPlugin flutterPlugin = flutterEngine.getPlugins().get(NtEarPlugin.class);
                NtEarPlugin ntEarPlugin = flutterPlugin instanceof NtEarPlugin ? (NtEarPlugin) flutterPlugin : null;
                if (ntEarPlugin != null) {
                    return ntEarPlugin.getFlutterApi();
                }
            }
            return null;
        } catch (Exception e) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "EqualizerLeakageGuard flutterApi unavailable: " + e;
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
            return null;
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$fetchScenarioModeFromFlutterPeek$2, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$fetchScenarioModeFromFlutterPeek$2", f = "EqualizerLeakageGuard.kt", i = {0}, l = {306}, m = "invokeSuspend", n = {"$this$withContext"}, s = {"L$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
        final /* synthetic */ String $realMac;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$realMac = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$realMac, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0050  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final String selectDeviceMac = this.$realMac;
            this.L$0 = coroutineScope;
            this.L$1 = selectDeviceMac;
            this.label = 1;
            AnonymousClass2 anonymousClass2 = this;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass2), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            if (selectDeviceMac == null) {
                selectDeviceMac = SpUtils.INSTANCE.getSelectDeviceMac();
            } else {
                if (StringsKt.isBlank(selectDeviceMac)) {
                    selectDeviceMac = null;
                }
                if (selectDeviceMac == null) {
                    selectDeviceMac = SpUtils.INSTANCE.getSelectDeviceMac();
                }
            }
            NtEarFlutterApi ntEarFlutterApiFlutterApi = EqualizerLeakageGuard.INSTANCE.flutterApi();
            if (ntEarFlutterApiFlutterApi == null || (str = selectDeviceMac) == null || StringsKt.isBlank(str)) {
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuationImpl2.resumeWith(Result.m6347constructorimpl(null));
            } else {
                ntEarFlutterApiFlutterApi.getEarScenarioMode(selectDeviceMac, new Function1<Result<? extends Long>, Unit>() { // from class: com.nothing.earbase.equalizer.EqualizerLeakageGuard$fetchScenarioModeFromFlutterPeek$2$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Result<? extends Long> result) {
                        m5505invoke(result.getValue());
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Code duplicated, block: B:6:0x002b  */
                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m5505invoke(Object obj2) {
                        CancellableContinuation<Integer> cancellableContinuation;
                        CancellableContinuation<Integer> cancellableContinuation2 = cancellableContinuationImpl2;
                        String str2 = selectDeviceMac;
                        if (Result.m6354isSuccessimpl(obj2)) {
                            long jLongValue = ((Number) obj2).longValue();
                            Logger logger = Logger.INSTANCE;
                            String tag = logger.getTAG();
                            int depth = logger.getDepth();
                            if (logger.isCanLogger(true)) {
                                String str3 = "EqualizerLeakageGuard flutter peek mode=" + jLongValue + " mac=" + str2;
                                String str4 = str3;
                                if (str4 == null || str4.length() == 0) {
                                    cancellableContinuation = cancellableContinuation2;
                                } else {
                                    Pair<String, String> trace = logger.getTrace(depth);
                                    String strComponent1 = trace.component1();
                                    String strComponent2 = trace.component2();
                                    FileLog fileLog = FileLog.INSTANCE;
                                    String str5 = logger.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                    cancellableContinuation = cancellableContinuation2;
                                    FileLog.print$default(fileLog, 3, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                                    if (logger.isDebug()) {
                                        Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                                    }
                                }
                            } else {
                                cancellableContinuation = cancellableContinuation2;
                            }
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m6347constructorimpl(Integer.valueOf((int) jLongValue)));
                        }
                        CancellableContinuation<Integer> cancellableContinuation3 = cancellableContinuationImpl2;
                        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(obj2);
                        if (thM6350exceptionOrNullimpl != null) {
                            Logger logger2 = Logger.INSTANCE;
                            String tag2 = logger2.getTAG();
                            int depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(true)) {
                                String str6 = "EqualizerLeakageGuard flutter peek failed: " + thM6350exceptionOrNullimpl;
                                String str7 = str6;
                                if (str7 != null && str7.length() != 0) {
                                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                                    String strComponent3 = trace2.component1();
                                    String strComponent4 = trace2.component2();
                                    FileLog fileLog2 = FileLog.INSTANCE;
                                    String str8 = logger2.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                                    FileLog.print$default(fileLog2, 3, str8, tag2, str6 + StringUtils.SPACE + strComponent4, null, 16, null);
                                    if (logger2.isDebug()) {
                                        Log.i(tag2 + strComponent3, str6 + StringUtils.SPACE + strComponent4);
                                    }
                                }
                            }
                            Result.Companion companion3 = Result.INSTANCE;
                            cancellableContinuation3.resumeWith(Result.m6347constructorimpl(null));
                        }
                    }
                });
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(anonymousClass2);
            }
            return result == coroutine_suspended ? coroutine_suspended : result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object fetchScenarioModeFromFlutterPeek(String str, Continuation<? super Integer> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetchScenarioModeFromBleSync(TWSDevice tWSDevice, Continuation<? super Integer> continuation) {
        AnonymousClass1 anonymousClass1;
        EqualizerLeakageGuard equalizerLeakageGuard;
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
        Object objSendMessageSync$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSendMessageSync$default);
            if (tWSDevice == null) {
                return Boxing.boxInt(0);
            }
            Long lBoxLong = Boxing.boxLong(800L);
            anonymousClass2.L$0 = this;
            anonymousClass2.label = 1;
            objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_SCENARIO_MODE, null, false, true, lBoxLong, null, anonymousClass2, 38, null);
            if (objSendMessageSync$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            equalizerLeakageGuard = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            equalizerLeakageGuard = (EqualizerLeakageGuard) anonymousClass2.L$0;
            ResultKt.throwOnFailure(objSendMessageSync$default);
        }
        Message message = (Message) objSendMessageSync$default;
        if (message == null) {
            return Boxing.boxInt(0);
        }
        ScenarioModeEntity scenarioModeEntity = (ScenarioModeEntity) message.obtainPayload(ScenarioModeEntity.class);
        int mode = scenarioModeEntity != null ? scenarioModeEntity.getMode() : 0;
        equalizerLeakageGuard.updateCache(mode);
        return Boxing.boxInt(mode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object resolveScenarioMode(TWSDevice tWSDevice, Continuation<? super Integer> continuation) {
        C06591 c06591;
        EqualizerLeakageGuard equalizerLeakageGuard;
        Message cacheCommandsManual;
        if (continuation instanceof C06591) {
            c06591 = (C06591) continuation;
            if ((c06591.label & Integer.MIN_VALUE) != 0) {
                c06591.label -= Integer.MIN_VALUE;
            } else {
                c06591 = new C06591(continuation);
            }
        } else {
            c06591 = new C06591(continuation);
        }
        Object objFetchScenarioModeFromFlutterPeek = c06591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06591.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objFetchScenarioModeFromFlutterPeek);
            if (cacheReady) {
                return Boxing.boxInt(cachedMode);
            }
            TWSDevice tWSDevice2 = observedDevice;
            if (tWSDevice2 != null && (cacheCommandsManual = tWSDevice2.getCacheCommandsManual(ProtocolConstant.Query.GET_SCENARIO_MODE)) != null) {
                INSTANCE.applyScenarioFromMessage(cacheCommandsManual);
                if (cacheReady) {
                    return Boxing.boxInt(cachedMode);
                }
            }
            String selectDeviceMac = SpUtils.INSTANCE.getSelectDeviceMac();
            c06591.L$0 = this;
            c06591.L$1 = tWSDevice;
            c06591.label = 1;
            objFetchScenarioModeFromFlutterPeek = fetchScenarioModeFromFlutterPeek(selectDeviceMac, c06591);
            if (objFetchScenarioModeFromFlutterPeek != coroutine_suspended) {
                equalizerLeakageGuard = this;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objFetchScenarioModeFromFlutterPeek);
            return objFetchScenarioModeFromFlutterPeek;
        }
        tWSDevice = (TWSDevice) c06591.L$1;
        equalizerLeakageGuard = (EqualizerLeakageGuard) c06591.L$0;
        ResultKt.throwOnFailure(objFetchScenarioModeFromFlutterPeek);
        Integer num = (Integer) objFetchScenarioModeFromFlutterPeek;
        if (num != null) {
            equalizerLeakageGuard.updateCache(num.intValue());
            return num;
        }
        c06591.L$0 = null;
        c06591.L$1 = null;
        c06591.label = 2;
        Object objFetchScenarioModeFromBleSync = equalizerLeakageGuard.fetchScenarioModeFromBleSync(tWSDevice, c06591);
        return objFetchScenarioModeFromBleSync == coroutine_suspended ? coroutine_suspended : objFetchScenarioModeFromBleSync;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x011b  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object setScenarioOff(TWSDevice tWSDevice, Continuation<? super Unit> continuation) {
        C06621 c06621;
        TWSDevice tWSDevice2;
        EqualizerLeakageGuard equalizerLeakageGuard;
        EqualizerLeakageGuard equalizerLeakageGuard2;
        TWSDeviceBuilder tWSDeviceBuilderScenarioMode;
        boolean z;
        TWSDeviceBuilder tWSDeviceBuilder;
        int i;
        EqualizerLeakageGuard equalizerLeakageGuard3;
        Message message;
        if (continuation instanceof C06621) {
            c06621 = (C06621) continuation;
            if ((c06621.label & Integer.MIN_VALUE) != 0) {
                c06621.label -= Integer.MIN_VALUE;
            } else {
                c06621 = new C06621(continuation);
            }
        } else {
            c06621 = new C06621(continuation);
        }
        C06621 c06622 = c06621;
        Object obj = c06622.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c06622.label;
        if (i2 != 0) {
            if (i2 == 1) {
                TWSDevice tWSDevice3 = (TWSDevice) c06622.L$1;
                EqualizerLeakageGuard equalizerLeakageGuard4 = (EqualizerLeakageGuard) c06622.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDevice2 = tWSDevice3;
                equalizerLeakageGuard = equalizerLeakageGuard4;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                int i3 = c06622.I$0;
                tWSDeviceBuilder = (TWSDeviceBuilder) c06622.L$1;
                equalizerLeakageGuard3 = (EqualizerLeakageGuard) c06622.L$0;
                ResultKt.throwOnFailure(obj);
                z = true;
                i = i3;
            }
            message = (Message) obj;
            if (message == null && message.isOk() == z) {
                LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                byte[] bArrObtainDataPacket = ScenarioModeEntity.INSTANCE.obtainDataPacket(0);
                Message message2 = (Message) liveDataCommand$default.getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                    tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrObtainDataPacket);
                    if (message2 != null) {
                        message2.setPayload(bArrObtainDataPacket);
                        if (i != 0) {
                            tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message2);
                        }
                    }
                }
                Boxing.boxBoolean(z);
            } else {
                Boxing.boxBoolean(false);
            }
            equalizerLeakageGuard2 = equalizerLeakageGuard3;
            equalizerLeakageGuard2.updateCache(0);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        String selectDeviceMac = SpUtils.INSTANCE.getSelectDeviceMac();
        MainCoroutineDispatcher main = Dispatchers.getMain();
        C06632 c06632 = new C06632(selectDeviceMac, null);
        c06622.L$0 = this;
        tWSDevice2 = tWSDevice;
        c06622.L$1 = tWSDevice2;
        c06622.label = 1;
        if (BuildersKt.withContext(main, c06632, c06622) != coroutine_suspended) {
            equalizerLeakageGuard = this;
        }
        return coroutine_suspended;
        if (tWSDevice2 != null && (tWSDeviceBuilderScenarioMode = TWSDeviceExtKt.scenarioMode(tWSDevice2, Boxing.boxInt(0))) != null) {
            int setCommand = tWSDeviceBuilderScenarioMode.getSetCommand();
            TWSDevice twsDevice = tWSDeviceBuilderScenarioMode.getTwsDevice();
            byte[] setPayload = tWSDeviceBuilderScenarioMode.getSetPayload();
            Long timeOut = tWSDeviceBuilderScenarioMode.getTimeOut();
            boolean isNeedFsn = tWSDeviceBuilderScenarioMode.getIsNeedFsn();
            byte[] mockResponse = tWSDeviceBuilderScenarioMode.getMockResponse();
            c06622.L$0 = equalizerLeakageGuard;
            c06622.L$1 = tWSDeviceBuilderScenarioMode;
            c06622.I$0 = 1;
            c06622.label = 2;
            EqualizerLeakageGuard equalizerLeakageGuard5 = equalizerLeakageGuard;
            z = true;
            Object objSyncSetResponse$default = TWSDevice.syncSetResponse$default(twsDevice, setCommand, setPayload, timeOut, isNeedFsn, false, mockResponse, c06622, 16, null);
            if (objSyncSetResponse$default != coroutine_suspended) {
                tWSDeviceBuilder = tWSDeviceBuilderScenarioMode;
                obj = objSyncSetResponse$default;
                i = 1;
                equalizerLeakageGuard3 = equalizerLeakageGuard5;
                message = (Message) obj;
                if (message == null) {
                    Boxing.boxBoolean(false);
                } else {
                    Boxing.boxBoolean(false);
                }
                equalizerLeakageGuard2 = equalizerLeakageGuard3;
            }
            return coroutine_suspended;
        }
        equalizerLeakageGuard2 = equalizerLeakageGuard;
        equalizerLeakageGuard2.updateCache(0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$setScenarioOff$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$setScenarioOff$2", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06632 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $mac;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06632(String str, Continuation<? super C06632> continuation) {
            super(2, continuation);
            this.$mac = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06632 c06632 = new C06632(this.$mac, continuation);
            c06632.L$0 = obj;
            return c06632;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06632) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                NtEarFlutterApi ntEarFlutterApiFlutterApi = EqualizerLeakageGuard.INSTANCE.flutterApi();
                if (ntEarFlutterApiFlutterApi == null) {
                    return null;
                }
                ntEarFlutterApiFlutterApi.setEarScenarioModeOff(this.$mac, new Function1() { // from class: com.nothing.earbase.equalizer.EqualizerLeakageGuard$setScenarioOff$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return EqualizerLeakageGuard.C06632.invokeSuspend$lambda$2(coroutineScope, (Result) obj2);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(CoroutineScope coroutineScope, Result result) {
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
            if (thM6350exceptionOrNullimpl != null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "EqualizerLeakageGuard flutter setScenarioOff failed: " + thM6350exceptionOrNullimpl;
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
            return Unit.INSTANCE;
        }
    }

    private final ConfirmMsgViewModel buildConflictViewModel(Fragment host) {
        ConfirmMsgViewModel confirmMsgViewModel = new ConfirmMsgViewModel();
        confirmMsgViewModel.getTitle().set(host.getString(R.string.eq_requires_antileakage_off));
        confirmMsgViewModel.getMsg().set(host.getString(R.string.eq_conflict_anti_leakage_prompt));
        confirmMsgViewModel.getPositionBtn().set(host.getString(R.string.turn_off_continue));
        confirmMsgViewModel.getNegativeBtn().set(host.getString(R.string.cancel));
        confirmMsgViewModel.getCancelAble().set(true);
        return confirmMsgViewModel;
    }

    private final ConfirmMsgViewModel buildConflictViewModel(FragmentActivity host) {
        ConfirmMsgViewModel confirmMsgViewModel = new ConfirmMsgViewModel();
        confirmMsgViewModel.getTitle().set(host.getString(R.string.eq_requires_antileakage_off));
        confirmMsgViewModel.getMsg().set(host.getString(R.string.eq_conflict_anti_leakage_prompt));
        confirmMsgViewModel.getPositionBtn().set(host.getString(R.string.turn_off_continue));
        confirmMsgViewModel.getNegativeBtn().set(host.getString(R.string.cancel));
        confirmMsgViewModel.getCancelAble().set(true);
        return confirmMsgViewModel;
    }

    public final void showConflictDialog(Fragment fragment, Function0<Unit> onTurnOff) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(onTurnOff, "onTurnOff");
        ConfirmMsgViewModel confirmMsgViewModelBuildConflictViewModel = buildConflictViewModel(fragment);
        if (fragment instanceof BaseFragment) {
            BaseFragment.showConfirmMsgDialog$default((BaseFragment) fragment, confirmMsgViewModelBuildConflictViewModel, onTurnOff, null, null, 12, null);
            return;
        }
        FragmentActivity activity = fragment.getActivity();
        if (activity instanceof BaseOSActivity) {
            BaseOSActivity.showConfirmMsgDialog$default((BaseOSActivity) activity, confirmMsgViewModelBuildConflictViewModel, onTurnOff, null, null, false, 28, null);
        } else if (activity instanceof BaseActivity) {
            BaseActivity.showConfirmMsgDialog$default((BaseActivity) activity, confirmMsgViewModelBuildConflictViewModel, onTurnOff, null, null, false, 28, null);
        }
    }

    public final void showConflictDialog(FragmentActivity activity, Function0<Unit> onTurnOff) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onTurnOff, "onTurnOff");
        ConfirmMsgViewModel confirmMsgViewModelBuildConflictViewModel = buildConflictViewModel(activity);
        if (activity instanceof BaseOSActivity) {
            BaseOSActivity.showConfirmMsgDialog$default((BaseOSActivity) activity, confirmMsgViewModelBuildConflictViewModel, onTurnOff, null, null, false, 28, null);
        } else if (activity instanceof BaseActivity) {
            BaseActivity.showConfirmMsgDialog$default((BaseActivity) activity, confirmMsgViewModelBuildConflictViewModel, onTurnOff, null, null, false, 28, null);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$scheduleTurnOff$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$scheduleTurnOff$1", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TWSDevice $device;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06601(TWSDevice tWSDevice, Continuation<? super C06601> continuation) {
            super(2, continuation);
            this.$device = tWSDevice;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06601(this.$device, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$scheduleTurnOff$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$scheduleTurnOff$1$1", f = "EqualizerLeakageGuard.kt", i = {}, l = {248}, m = "invokeSuspend", n = {}, s = {})
        static final class C01311 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TWSDevice $device;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01311(TWSDevice tWSDevice, Continuation<? super C01311> continuation) {
                super(2, continuation);
                this.$device = tWSDevice;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01311(this.$device, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01311) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (EqualizerLeakageGuard.INSTANCE.setScenarioOff(this.$device, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C01311(this.$device, null), 3, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleTurnOff(Fragment fragment, TWSDevice device) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(fragment), null, null, new C06601(device, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$scheduleTurnOff$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$scheduleTurnOff$2", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06612 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TWSDevice $device;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06612(TWSDevice tWSDevice, Continuation<? super C06612> continuation) {
            super(2, continuation);
            this.$device = tWSDevice;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06612(this.$device, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06612) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$scheduleTurnOff$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$scheduleTurnOff$2$1", f = "EqualizerLeakageGuard.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ TWSDevice $device;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(TWSDevice tWSDevice, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$device = tWSDevice;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$device, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (EqualizerLeakageGuard.INSTANCE.setScenarioOff(this.$device, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(this.$device, null), 3, null);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleTurnOff(FragmentActivity activity, TWSDevice device) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(activity), null, null, new C06612(device, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00be  */
    /* JADX WARN: Code duplicated, block: B:41:0x013a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0169  */
    /* JADX WARN: Code duplicated, block: B:49:0x018c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4) == r5) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0186, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4) == r5) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01a9, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r2, r7, r4) == r5) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object guardEqAction(Fragment fragment, TWSDevice tWSDevice, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        C06571 c06571;
        Fragment fragment2;
        Object objResolveScenarioMode;
        EqualizerLeakageGuard equalizerLeakageGuard;
        int iIntValue;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        TWSDevice tWSDevice2 = tWSDevice;
        Function0<Unit> function1 = function0;
        if (continuation instanceof C06571) {
            c06571 = (C06571) continuation;
            if ((c06571.label & Integer.MIN_VALUE) != 0) {
                c06571.label -= Integer.MIN_VALUE;
            } else {
                c06571 = new C06571(continuation);
            }
        } else {
            c06571 = new C06571(continuation);
        }
        Object obj = c06571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c06571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!isLeakageProtectionSupported()) {
                MainCoroutineDispatcher main = Dispatchers.getMain();
                C06582 c06582 = new C06582(function1, null);
                c06571.label = 1;
            } else {
                c06571.L$0 = this;
                fragment2 = fragment;
                c06571.L$1 = fragment2;
                c06571.L$2 = tWSDevice2;
                c06571.L$3 = function1;
                c06571.label = 2;
                objResolveScenarioMode = resolveScenarioMode(tWSDevice2, c06571);
                if (objResolveScenarioMode != coroutine_suspended) {
                    equalizerLeakageGuard = this;
                    iIntValue = ((Number) objResolveScenarioMode).intValue();
                    logger = Logger.INSTANCE;
                    tag = logger.getTAG();
                    depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        str = "EqualizerLeakageGuard guardEqAction mode=" + iIntValue + " cacheReady=" + cacheReady;
                        str2 = str;
                        if (str2 != null) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            strComponent1 = trace.component1();
                            strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    if (!equalizerLeakageGuard.isLeakageOn(iIntValue)) {
                        MainCoroutineDispatcher main2 = Dispatchers.getMain();
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(function1, null);
                        c06571.L$0 = null;
                        c06571.L$1 = null;
                        c06571.L$2 = null;
                        c06571.L$3 = null;
                        c06571.label = 3;
                    } else {
                        MainCoroutineDispatcher main3 = Dispatchers.getMain();
                        AnonymousClass5 anonymousClass5 = new AnonymousClass5(fragment2, tWSDevice2, null);
                        c06571.L$0 = null;
                        c06571.L$1 = null;
                        c06571.L$2 = null;
                        c06571.L$3 = null;
                        c06571.label = 4;
                    }
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        if (i != 2) {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        Function0<Unit> function2 = (Function0) c06571.L$3;
        TWSDevice tWSDevice3 = (TWSDevice) c06571.L$2;
        Fragment fragment3 = (Fragment) c06571.L$1;
        equalizerLeakageGuard = (EqualizerLeakageGuard) c06571.L$0;
        ResultKt.throwOnFailure(obj);
        function1 = function2;
        tWSDevice2 = tWSDevice3;
        objResolveScenarioMode = obj;
        fragment2 = fragment3;
        iIntValue = ((Number) objResolveScenarioMode).intValue();
        logger = Logger.INSTANCE;
        tag = logger.getTAG();
        depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            str = "EqualizerLeakageGuard guardEqAction mode=" + iIntValue + " cacheReady=" + cacheReady;
            str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace2 = logger.getTrace(depth);
                strComponent1 = trace2.component1();
                strComponent2 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 3, str4, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (!equalizerLeakageGuard.isLeakageOn(iIntValue)) {
            MainCoroutineDispatcher main4 = Dispatchers.getMain();
            AnonymousClass4 anonymousClass6 = new AnonymousClass4(function1, null);
            c06571.L$0 = null;
            c06571.L$1 = null;
            c06571.L$2 = null;
            c06571.L$3 = null;
            c06571.label = 3;
        } else {
            MainCoroutineDispatcher main5 = Dispatchers.getMain();
            AnonymousClass5 anonymousClass7 = new AnonymousClass5(fragment2, tWSDevice2, null);
            c06571.L$0 = null;
            c06571.L$1 = null;
            c06571.L$2 = null;
            c06571.L$3 = null;
            c06571.label = 4;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$2", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06582 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06582(Function0<Unit> function0, Continuation<? super C06582> continuation) {
            super(2, continuation);
            this.$action = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06582(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06582) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$action.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$4, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$4", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Function0<Unit> function0, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$action = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$action.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$5, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$5", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ TWSDevice $device;
        final /* synthetic */ Fragment $fragment;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Fragment fragment, TWSDevice tWSDevice, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$fragment = fragment;
            this.$device = tWSDevice;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$fragment, this.$device, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            EqualizerLeakageGuard equalizerLeakageGuard = EqualizerLeakageGuard.INSTANCE;
            final Fragment fragment = this.$fragment;
            final TWSDevice tWSDevice = this.$device;
            equalizerLeakageGuard.showConflictDialog(fragment, new Function0() { // from class: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$5$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EqualizerLeakageGuard.AnonymousClass5.invokeSuspend$lambda$0(fragment, tWSDevice);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(Fragment fragment, TWSDevice tWSDevice) {
            EqualizerLeakageGuard.INSTANCE.scheduleTurnOff(fragment, tWSDevice);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00be  */
    /* JADX WARN: Code duplicated, block: B:41:0x013a  */
    /* JADX WARN: Code duplicated, block: B:44:0x0169  */
    /* JADX WARN: Code duplicated, block: B:49:0x018c  */
    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4) == r5) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0186, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r1, r3, r4) == r5) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01a9, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r2, r7, r4) == r5) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object guardEqAction(FragmentActivity fragmentActivity, TWSDevice tWSDevice, Function0<Unit> function0, Continuation<? super Unit> continuation) {
        AnonymousClass6 anonymousClass6;
        FragmentActivity fragmentActivity2;
        Object objResolveScenarioMode;
        EqualizerLeakageGuard equalizerLeakageGuard;
        int iIntValue;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        TWSDevice tWSDevice2 = tWSDevice;
        Function0<Unit> function1 = function0;
        if (continuation instanceof AnonymousClass6) {
            anonymousClass6 = (AnonymousClass6) continuation;
            if ((anonymousClass6.label & Integer.MIN_VALUE) != 0) {
                anonymousClass6.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass6 = new AnonymousClass6(continuation);
            }
        } else {
            anonymousClass6 = new AnonymousClass6(continuation);
        }
        Object obj = anonymousClass6.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass6.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (!isLeakageProtectionSupported()) {
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass7 anonymousClass7 = new AnonymousClass7(function1, null);
                anonymousClass6.label = 1;
            } else {
                anonymousClass6.L$0 = this;
                fragmentActivity2 = fragmentActivity;
                anonymousClass6.L$1 = fragmentActivity2;
                anonymousClass6.L$2 = tWSDevice2;
                anonymousClass6.L$3 = function1;
                anonymousClass6.label = 2;
                objResolveScenarioMode = resolveScenarioMode(tWSDevice2, anonymousClass6);
                if (objResolveScenarioMode != coroutine_suspended) {
                    equalizerLeakageGuard = this;
                    iIntValue = ((Number) objResolveScenarioMode).intValue();
                    logger = Logger.INSTANCE;
                    tag = logger.getTAG();
                    depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        str = "EqualizerLeakageGuard guardEqAction(activity) mode=" + iIntValue + " cacheReady=" + cacheReady;
                        str2 = str;
                        if (str2 != null) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            strComponent1 = trace.component1();
                            strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    if (!equalizerLeakageGuard.isLeakageOn(iIntValue)) {
                        MainCoroutineDispatcher main2 = Dispatchers.getMain();
                        AnonymousClass9 anonymousClass9 = new AnonymousClass9(function1, null);
                        anonymousClass6.L$0 = null;
                        anonymousClass6.L$1 = null;
                        anonymousClass6.L$2 = null;
                        anonymousClass6.L$3 = null;
                        anonymousClass6.label = 3;
                    } else {
                        MainCoroutineDispatcher main3 = Dispatchers.getMain();
                        AnonymousClass10 anonymousClass10 = new AnonymousClass10(fragmentActivity2, tWSDevice2, null);
                        anonymousClass6.L$0 = null;
                        anonymousClass6.L$1 = null;
                        anonymousClass6.L$2 = null;
                        anonymousClass6.L$3 = null;
                        anonymousClass6.label = 4;
                    }
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        if (i != 2) {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        Function0<Unit> function2 = (Function0) anonymousClass6.L$3;
        TWSDevice tWSDevice3 = (TWSDevice) anonymousClass6.L$2;
        FragmentActivity fragmentActivity3 = (FragmentActivity) anonymousClass6.L$1;
        equalizerLeakageGuard = (EqualizerLeakageGuard) anonymousClass6.L$0;
        ResultKt.throwOnFailure(obj);
        function1 = function2;
        tWSDevice2 = tWSDevice3;
        objResolveScenarioMode = obj;
        fragmentActivity2 = fragmentActivity3;
        iIntValue = ((Number) objResolveScenarioMode).intValue();
        logger = Logger.INSTANCE;
        tag = logger.getTAG();
        depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            str = "EqualizerLeakageGuard guardEqAction(activity) mode=" + iIntValue + " cacheReady=" + cacheReady;
            str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace2 = logger.getTrace(depth);
                strComponent1 = trace2.component1();
                strComponent2 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 3, str4, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (!equalizerLeakageGuard.isLeakageOn(iIntValue)) {
            MainCoroutineDispatcher main4 = Dispatchers.getMain();
            AnonymousClass9 anonymousClass11 = new AnonymousClass9(function1, null);
            anonymousClass6.L$0 = null;
            anonymousClass6.L$1 = null;
            anonymousClass6.L$2 = null;
            anonymousClass6.L$3 = null;
            anonymousClass6.label = 3;
        } else {
            MainCoroutineDispatcher main5 = Dispatchers.getMain();
            AnonymousClass10 anonymousClass12 = new AnonymousClass10(fragmentActivity2, tWSDevice2, null);
            anonymousClass6.L$0 = null;
            anonymousClass6.L$1 = null;
            anonymousClass6.L$2 = null;
            anonymousClass6.L$3 = null;
            anonymousClass6.label = 4;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$7, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$7", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Function0<Unit> function0, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.$action = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$action.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$9, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$9", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $action;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass9(Function0<Unit> function0, Continuation<? super AnonymousClass9> continuation) {
            super(2, continuation);
            this.$action = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass9(this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$action.invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$10, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerLeakageGuard.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$10", f = "EqualizerLeakageGuard.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $activity;
        final /* synthetic */ TWSDevice $device;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass10(FragmentActivity fragmentActivity, TWSDevice tWSDevice, Continuation<? super AnonymousClass10> continuation) {
            super(2, continuation);
            this.$activity = fragmentActivity;
            this.$device = tWSDevice;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass10(this.$activity, this.$device, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            EqualizerLeakageGuard equalizerLeakageGuard = EqualizerLeakageGuard.INSTANCE;
            final FragmentActivity fragmentActivity = this.$activity;
            final TWSDevice tWSDevice = this.$device;
            equalizerLeakageGuard.showConflictDialog(fragmentActivity, new Function0() { // from class: com.nothing.earbase.equalizer.EqualizerLeakageGuard$guardEqAction$10$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EqualizerLeakageGuard.AnonymousClass10.invokeSuspend$lambda$0(fragmentActivity, tWSDevice);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(FragmentActivity fragmentActivity, TWSDevice tWSDevice) {
            EqualizerLeakageGuard.INSTANCE.scheduleTurnOff(fragmentActivity, tWSDevice);
            return Unit.INSTANCE;
        }
    }
}
