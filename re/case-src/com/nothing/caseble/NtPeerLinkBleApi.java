package com.nothing.caseble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.util.Log;
import com.nothing.generate.NtPeerLinkBleConnectionState;
import com.nothing.generate.NtPeerLinkFlutterApi;
import com.nothing.generate.NtPeerLinkHostApi;
import com.nothing.generate.NtPeerLinkScanItem;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.commons.cli.HelpFormatter;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0002J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010\u0018\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00192\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001bH\u0002JV\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000b2\b\u0010 \u001a\u0004\u0018\u00010\n2\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001b2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0#\u0012\u0004\u0012\u00020\u001d0\"H\u0017J$\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\nH\u0002J\"\u0010)\u001a\u00020\u001d2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0#\u0012\u0004\u0012\u00020\u001d0\"H\u0016JD\u0010*\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\n2\u0018\u0010\u001a\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u001b2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0#\u0012\u0004\u0012\u00020\u001d0\"H\u0016J*\u0010,\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\n2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0#\u0012\u0004\u0012\u00020\u001d0\"H\u0016J*\u0010-\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\n2\u0018\u0010!\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150#\u0012\u0004\u0012\u00020\u001d0\"H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000f0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/nothing/caseble/NtPeerLinkBleApi;", "Lcom/nothing/generate/NtPeerLinkHostApi;", "flutterApi", "Lcom/nothing/generate/NtPeerLinkFlutterApi;", "<init>", "(Lcom/nothing/generate/NtPeerLinkFlutterApi;)V", "scanCallbackRef", "Landroid/bluetooth/le/ScanCallback;", "scanSeen", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "scanDeadlineJob", "Lkotlinx/coroutines/Job;", "connectorMap", "Lcom/nothing/caseble/XCaseBleConnector;", "connectKeyToPeerBd", "normalizeMacColonUpper", "raw", "normalizeMacBareUpper", "toPigeonState", "Lcom/nothing/generate/NtPeerLinkBleConnectionState;", "sdkState", "", "uuidMap", "Lkotlin/Triple;", "uuids", "", "startScan", "", "expectedProductIdHex", "durationMs", "excludePeerBdAddrNormalized", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "stopScanInternal", "sendFinished", "", "stoppedByHost", "errorMessage", "stopScan", "connectBle", "connectKey", "disconnectBle", "bleConnectionState", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NtPeerLinkBleApi implements NtPeerLinkHostApi {
    private final ConcurrentHashMap<String, String> connectKeyToPeerBd;
    private final ConcurrentHashMap<String, XCaseBleConnector> connectorMap;
    private final NtPeerLinkFlutterApi flutterApi;
    private ScanCallback scanCallbackRef;
    private Job scanDeadlineJob;
    private final ConcurrentHashMap<String, Long> scanSeen;

    public NtPeerLinkBleApi(NtPeerLinkFlutterApi flutterApi) {
        Intrinsics.checkNotNullParameter(flutterApi, "flutterApi");
        this.flutterApi = flutterApi;
        this.scanSeen = new ConcurrentHashMap<>();
        this.connectorMap = new ConcurrentHashMap<>();
        this.connectKeyToPeerBd = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeMacColonUpper(String raw) {
        String string = StringsKt.trim((CharSequence) raw).toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = string.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return StringsKt.replace$default(upperCase, '-', ':', false, 4, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeMacBareUpper(String raw) {
        String str = raw;
        if (str == null || str.length() == 0) {
            return "";
        }
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(raw, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null), HelpFormatter.DEFAULT_OPT_PREFIX, "", false, 4, (Object) null);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = strReplace$default.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NtPeerLinkBleConnectionState toPigeonState(int sdkState) {
        if (sdkState == -1) {
            return NtPeerLinkBleConnectionState.IDLE;
        }
        if (sdkState == 0) {
            return NtPeerLinkBleConnectionState.DISCONNECTED;
        }
        if (sdkState == 1) {
            return NtPeerLinkBleConnectionState.CONNECTING;
        }
        if (sdkState == 2) {
            return NtPeerLinkBleConnectionState.CONNECTED;
        }
        if (sdkState == 4) {
            return NtPeerLinkBleConnectionState.FAILED;
        }
        return NtPeerLinkBleConnectionState.DISCONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Triple<String, String, String> uuidMap(Map<String, String> uuids) {
        String string;
        String string2;
        String str;
        String string3;
        String str2;
        String str3;
        String str4 = null;
        if (uuids == null || (str3 = uuids.get("serviceUuid")) == null || (string = StringsKt.trim((CharSequence) str3).toString()) == null || string.length() <= 0) {
            string = null;
        }
        if (uuids == null || (str2 = uuids.get("writeUuid")) == null || (string2 = StringsKt.trim((CharSequence) str2).toString()) == null || string2.length() <= 0) {
            string2 = null;
        }
        if (uuids != null && (str = uuids.get("notifyUuid")) != null && (string3 = StringsKt.trim((CharSequence) str).toString()) != null && string3.length() > 0) {
            str4 = string3;
        }
        return new Triple<>(string, string2, str4);
    }

    @Override // com.nothing.generate.NtPeerLinkHostApi
    public void startScan(final String expectedProductIdHex, long durationMs, String excludePeerBdAddrNormalized, Map<String, String> uuids, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(expectedProductIdHex, "expectedProductIdHex");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PeerLinkAdvParser.INSTANCE.resetDebugRejectCounter();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[PeerLink] startScan expected=" + expectedProductIdHex + " durationMs=" + durationMs + " exclude=" + excludePeerBdAddrNormalized;
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
        boolean z = this.scanCallbackRef != null;
        stopScanInternal$default(this, false, true, null, 4, null);
        if (z) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "[PeerLink] replaced previous scan without finished callback".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 4, str4, tag2, "[PeerLink] replaced previous scan without finished callback " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "[PeerLink] replaced previous scan without finished callback " + strComponent4);
                }
            }
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Bluetooth unavailable")))));
            return;
        }
        if (!defaultAdapter.isEnabled()) {
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Bluetooth disabled")))));
            return;
        }
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner();
        if (bluetoothLeScanner == null) {
            Result.Companion companion3 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("BLE scanner unavailable")))));
            return;
        }
        final String strNormalizeMacBareUpper = normalizeMacBareUpper(excludePeerBdAddrNormalized);
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).build();
        final Ref.IntRef intRef = new Ref.IntRef();
        final Ref.IntRef intRef2 = new Ref.IntRef();
        final Ref.IntRef intRef3 = new Ref.IntRef();
        ScanCallback scanCallback = new ScanCallback() { // from class: com.nothing.caseble.NtPeerLinkBleApi$startScan$cb$1
            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int callbackType, ScanResult result) {
                String address;
                if (result == null) {
                    return;
                }
                intRef.element++;
                byte[] bArrExtractManufacturerPayload = PeerLinkAdvParser.INSTANCE.extractManufacturerPayload(result.getScanRecord());
                if (bArrExtractManufacturerPayload == null) {
                    return;
                }
                intRef2.element++;
                PeerLinkAdvParser.Parsed parsed = PeerLinkAdvParser.INSTANCE.parse(bArrExtractManufacturerPayload, expectedProductIdHex);
                if (parsed == null) {
                    return;
                }
                intRef3.element++;
                NtPeerLinkBleApi ntPeerLinkBleApi = this;
                BluetoothDevice device = result.getDevice();
                if (device == null || (address = device.getAddress()) == null) {
                    return;
                }
                String strNormalizeMacColonUpper = ntPeerLinkBleApi.normalizeMacColonUpper(address);
                String strNormalizeMacBareUpper2 = this.normalizeMacBareUpper(strNormalizeMacColonUpper);
                if (strNormalizeMacBareUpper.length() <= 0 || !Intrinsics.areEqual(strNormalizeMacBareUpper, strNormalizeMacBareUpper2)) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Long l = (Long) this.scanSeen.get(strNormalizeMacColonUpper);
                    if (jCurrentTimeMillis - (l != null ? l.longValue() : 0L) < 450) {
                        return;
                    }
                    this.scanSeen.put(strNormalizeMacColonUpper, Long.valueOf(jCurrentTimeMillis));
                    ScanRecord scanRecord = result.getScanRecord();
                    NtPeerLinkScanItem ntPeerLinkScanItem = new NtPeerLinkScanItem(strNormalizeMacColonUpper, strNormalizeMacColonUpper, scanRecord != null ? scanRecord.getDeviceName() : null, result.getRssi(), parsed.getProductIdHex(), parsed.getConnectionByte());
                    Logger logger3 = Logger.INSTANCE;
                    String tag3 = logger3.getTAG();
                    int depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true)) {
                        String str5 = "[PeerLink] match addr=" + strNormalizeMacColonUpper + " product=" + parsed.getProductIdHex() + " rssi=" + result.getRssi();
                        String str6 = str5;
                        if (str6 != null && str6.length() != 0) {
                            Pair<String, String> trace3 = logger3.getTrace(depth3);
                            String strComponent5 = trace3.component1();
                            String strComponent6 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str7 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                            FileLog.print$default(fileLog3, 4, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.i(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                            }
                        }
                    }
                    BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new NtPeerLinkBleApi$startScan$cb$1$onScanResult$2(this, ntPeerLinkScanItem, null), 2, null);
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int errorCode) {
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str5 = "[PeerLink] onScanFailed code=" + errorCode;
                    String str6 = str5;
                    if (str6 != null && str6.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str7 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        FileLog.print$default(fileLog3, 6, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.e(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new NtPeerLinkBleApi$startScan$cb$1$onScanFailed$2(this, errorCode, null), 2, null);
            }
        };
        this.scanCallbackRef = scanCallback;
        bluetoothLeScanner.startScan((List<ScanFilter>) null, scanSettingsBuild, scanCallback);
        this.scanDeadlineJob = BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass3(durationMs, this, intRef, intRef2, intRef3, null), 3, null);
        Result.Companion companion4 = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
    }

    /* JADX INFO: renamed from: com.nothing.caseble.NtPeerLinkBleApi$startScan$3, reason: invalid class name */
    /* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$startScan$3", f = "NtPeerLinkBleApi.kt", i = {}, l = {163}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $durationMs;
        final /* synthetic */ Ref.IntRef $mfgHitCount;
        final /* synthetic */ Ref.IntRef $parsedHitCount;
        final /* synthetic */ Ref.IntRef $rawBleCount;
        int label;
        final /* synthetic */ NtPeerLinkBleApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(long j, NtPeerLinkBleApi ntPeerLinkBleApi, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$durationMs = j;
            this.this$0 = ntPeerLinkBleApi;
            this.$rawBleCount = intRef;
            this.$mfgHitCount = intRef2;
            this.$parsedHitCount = intRef3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$durationMs, this.this$0, this.$rawBleCount, this.$mfgHitCount, this.$parsedHitCount, continuation);
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
                if (DelayKt.delay(RangesKt.coerceAtLeast(this.$durationMs, 1000L), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Logger logger = Logger.INSTANCE;
            Ref.IntRef intRef = this.$rawBleCount;
            Ref.IntRef intRef2 = this.$mfgHitCount;
            Ref.IntRef intRef3 = this.$parsedHitCount;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "[PeerLink] scan timeout rawBle=" + intRef.element + " mfg0xCB0C=" + intRef2.element + " parsed=" + intRef3.element;
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
            this.this$0.stopScanInternal(true, false, null);
            return Unit.INSTANCE;
        }
    }

    static /* synthetic */ void stopScanInternal$default(NtPeerLinkBleApi ntPeerLinkBleApi, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        ntPeerLinkBleApi.stopScanInternal(z, z2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopScanInternal(boolean sendFinished, boolean stoppedByHost, String errorMessage) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        BluetoothLeScanner bluetoothLeScanner = defaultAdapter != null ? defaultAdapter.getBluetoothLeScanner() : null;
        ScanCallback scanCallback = this.scanCallbackRef;
        if (bluetoothLeScanner != null && scanCallback != null) {
            try {
                bluetoothLeScanner.stopScan(scanCallback);
            } catch (Throwable unused) {
            }
        }
        this.scanCallbackRef = null;
        this.scanSeen.clear();
        Job job = this.scanDeadlineJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.scanDeadlineJob = null;
        if (sendFinished) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "[PeerLink] emit onScanFinished stoppedByHost=" + stoppedByHost + " err=" + errorMessage;
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
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new C04483(stoppedByHost, errorMessage, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.nothing.caseble.NtPeerLinkBleApi$stopScanInternal$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$stopScanInternal$3", f = "NtPeerLinkBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C04483 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $errorMessage;
        final /* synthetic */ boolean $stoppedByHost;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04483(boolean z, String str, Continuation<? super C04483> continuation) {
            super(2, continuation);
            this.$stoppedByHost = z;
            this.$errorMessage = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtPeerLinkBleApi.this.new C04483(this.$stoppedByHost, this.$errorMessage, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04483) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                NtPeerLinkBleApi.this.flutterApi.onPeerLinkScanFinished(this.$stoppedByHost, this.$errorMessage, new Function1() { // from class: com.nothing.caseble.NtPeerLinkBleApi$stopScanInternal$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtPeerLinkBleApi.C04483.invokeSuspend$lambda$1((Result) obj2);
                    }
                });
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(Result result) {
            if (Result.m6353isFailureimpl(result.getValue())) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
                    String str = "[PeerLink] onScanFinished pigeon error " + (thM6350exceptionOrNullimpl != null ? thM6350exceptionOrNullimpl.getMessage() : null);
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 6, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.generate.NtPeerLinkHostApi
    public void stopScan(Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        stopScanInternal(true, true, null);
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
    }

    @Override // com.nothing.generate.NtPeerLinkHostApi
    public void connectBle(String connectKey, Map<String, String> uuids, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(connectKey, "connectKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[PeerLink] connectBle connectKey=" + connectKey;
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
        if (connectKey.length() != 0) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass2(connectKey, uuids, callback, null), 3, null);
        } else {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalArgumentException("connectKey empty")))));
        }
    }

    /* JADX INFO: renamed from: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2, reason: invalid class name */
    /* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$connectBle$2", f = "NtPeerLinkBleApi.kt", i = {}, l = {264, 269}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
        final /* synthetic */ String $connectKey;
        final /* synthetic */ Map<String, String> $uuids;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, Map<String, String> map, Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$connectKey = str;
            this.$uuids = map;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtPeerLinkBleApi.this.new AnonymousClass2(this.$connectKey, this.$uuids, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x00fd, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.caseble.NtPeerLinkBleApi.AnonymousClass2.AnonymousClass4(r25.$callback, null), r25) == r2) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x01cb, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.caseble.NtPeerLinkBleApi.AnonymousClass2.AnonymousClass6(r25.$callback, r0, null), r25) == r2) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x01cd, code lost:
        
            return r2;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    final String strNormalizeMacColonUpper = NtPeerLinkBleApi.this.normalizeMacColonUpper(this.$connectKey);
                    XConnectorDevice device = XBluetoothManager.INSTANCE.get().getDevice(strNormalizeMacColonUpper);
                    String deviceAddress = device.getXBluetoothDevice().getDeviceAddress();
                    if (deviceAddress == null) {
                        deviceAddress = strNormalizeMacColonUpper;
                    }
                    final String strNormalizeMacColonUpper2 = NtPeerLinkBleApi.this.normalizeMacColonUpper(deviceAddress);
                    NtPeerLinkBleApi.this.connectKeyToPeerBd.put(strNormalizeMacColonUpper, strNormalizeMacColonUpper2);
                    ConcurrentHashMap concurrentHashMap = NtPeerLinkBleApi.this.connectorMap;
                    Object obj2 = concurrentHashMap.get(strNormalizeMacColonUpper);
                    Object obj3 = obj2;
                    if (obj2 == null) {
                        XCaseBleConnector xCaseBleConnector = new XCaseBleConnector(new XCaseBleParser(), "PeerLink_" + strNormalizeMacColonUpper);
                        xCaseBleConnector.onCreate(device.getXBluetoothDevice());
                        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(strNormalizeMacColonUpper, xCaseBleConnector);
                        obj3 = objPutIfAbsent == null ? xCaseBleConnector : objPutIfAbsent;
                    }
                    XCaseBleConnector xCaseBleConnector2 = (XCaseBleConnector) obj3;
                    Triple tripleUuidMap = NtPeerLinkBleApi.this.uuidMap(this.$uuids);
                    xCaseBleConnector2.setUuids((String) tripleUuidMap.component1(), (String) tripleUuidMap.component2(), (String) tripleUuidMap.component3());
                    xCaseBleConnector2.setMessageReceiveCallback("peer_link_rx", new Function1() { // from class: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            return NtPeerLinkBleApi.AnonymousClass2.invokeSuspend$lambda$2((XCommand) obj4);
                        }
                    });
                    final NtPeerLinkBleApi ntPeerLinkBleApi = NtPeerLinkBleApi.this;
                    xCaseBleConnector2.setDeviceConnectCallback("peer_link_conn", new Function2() { // from class: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj4, Object obj5) {
                            return NtPeerLinkBleApi.AnonymousClass2.invokeSuspend$lambda$4(ntPeerLinkBleApi, strNormalizeMacColonUpper, strNormalizeMacColonUpper2, ((Integer) obj4).intValue(), (XConnectFailType) obj5);
                        }
                    });
                    XConnector.connect$default(xCaseBleConnector2, null, null, null, null, false, false, false, 0, false, new Function1() { // from class: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj4) {
                            return NtPeerLinkBleApi.AnonymousClass2.invokeSuspend$lambda$11(strNormalizeMacColonUpper, (XConnectCallback) obj4);
                        }
                    }, null, 1519, null);
                    this.label = 1;
                } else {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "[PeerLink] connectBle error " + e.getMessage();
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 6, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                this.label = 2;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(XCommand xCommand) {
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4(NtPeerLinkBleApi ntPeerLinkBleApi, String str, String str2, int i, XConnectFailType xConnectFailType) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str3 = "[PeerLink] state=" + i + " key=" + str;
                String str4 = str3;
                if (str4 != null && str4.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str5 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    FileLog.print$default(fileLog, 3, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            NtPeerLinkBleConnectionState pigeonState = ntPeerLinkBleApi.toPigeonState(i);
            String str6 = (String) ntPeerLinkBleApi.connectKeyToPeerBd.get(str);
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new NtPeerLinkBleApi$connectBle$2$2$2(ntPeerLinkBleApi, str, pigeonState, str6 == null ? str2 : str6, null), 2, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$11(final String str, XConnectCallback xConnectCallback) {
            xConnectCallback.onConnectSuccess(new Function2() { // from class: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NtPeerLinkBleApi.AnonymousClass2.invokeSuspend$lambda$11$lambda$6(str, (XConnectType) obj, (XBluetoothDevice) obj2);
                }
            });
            xConnectCallback.onConnectFail(new Function2() { // from class: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NtPeerLinkBleApi.AnonymousClass2.invokeSuspend$lambda$11$lambda$8(str, (XBluetoothDevice) obj, (XConnectFailType) obj2);
                }
            });
            xConnectCallback.onDisConnected(new Function4() { // from class: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return NtPeerLinkBleApi.AnonymousClass2.invokeSuspend$lambda$11$lambda$10(str, ((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$11$lambda$6(String str, XConnectType xConnectType, XBluetoothDevice xBluetoothDevice) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "[PeerLink] onConnectSuccess " + str;
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
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$11$lambda$8(String str, XBluetoothDevice xBluetoothDevice, XConnectFailType xConnectFailType) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "[PeerLink] onConnectFail " + str;
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog, 6, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$11$lambda$10(String str, boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "[PeerLink] onDisconnected " + str;
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog, 6, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$4", f = "NtPeerLinkBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$callback, continuation);
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
                Function1<Result<Unit>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$6, reason: invalid class name */
        /* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$6", f = "NtPeerLinkBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ Exception $e;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass6(Function1<? super Result<Unit>, Unit> function1, Exception exc, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.$callback, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Result<Unit>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(this.$e))));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.generate.NtPeerLinkHostApi
    public void disconnectBle(String connectKey, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(connectKey, "connectKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String strNormalizeMacColonUpper = normalizeMacColonUpper(connectKey);
        XCaseBleConnector xCaseBleConnectorRemove = this.connectorMap.remove(strNormalizeMacColonUpper);
        this.connectKeyToPeerBd.remove(strNormalizeMacColonUpper);
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(xCaseBleConnectorRemove, this, strNormalizeMacColonUpper, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.caseble.NtPeerLinkBleApi$disconnectBle$1, reason: invalid class name */
    /* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$disconnectBle$1", f = "NtPeerLinkBleApi.kt", i = {0}, l = {281, 283}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XCaseBleConnector $c;
        final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
        final /* synthetic */ String $ck;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ NtPeerLinkBleApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(XCaseBleConnector xCaseBleConnector, NtPeerLinkBleApi ntPeerLinkBleApi, String str, Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$c = xCaseBleConnector;
            this.this$0 = ntPeerLinkBleApi;
            this.$ck = str;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$c, this.this$0, this.$ck, this.$callback, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x0054 A[Catch: all -> 0x005f, TryCatch #1 {all -> 0x005f, blocks: (B:25:0x0050, B:27:0x0054, B:29:0x005b), top: B:40:0x0050 }] */
        /* JADX WARN: Code duplicated, block: B:28:0x005a  */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.caseble.NtPeerLinkBleApi.AnonymousClass1.AnonymousClass3(r7.this$0, r7.$ck, r7.$callback, null), r7) == r0) goto L35;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            XCaseBleConnector xCaseBleConnector;
            Unit unit;
            Boolean bool;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                        XCaseBleConnector xCaseBleConnector2 = this.$c;
                        Result.Companion companion = Result.INSTANCE;
                        if (xCaseBleConnector2 != null) {
                            this.L$0 = coroutineScope;
                            this.label = 1;
                            obj = xCaseBleConnector2.disconnect(this);
                            if (obj == coroutine_suspended) {
                            }
                        } else {
                            bool = null;
                            Result.m6347constructorimpl(bool);
                            xCaseBleConnector = this.$c;
                            Result.Companion companion2 = Result.INSTANCE;
                            if (xCaseBleConnector != null) {
                                xCaseBleConnector.onDestroy();
                                unit = Unit.INSTANCE;
                            } else {
                                unit = null;
                            }
                            Result.m6347constructorimpl(unit);
                            this.L$0 = null;
                            this.label = 2;
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                    Result.Companion companion3 = Result.INSTANCE;
                    if (xCaseBleConnector != null) {
                        xCaseBleConnector.onDestroy();
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    Result.m6347constructorimpl(unit);
                } catch (Throwable th) {
                    Result.Companion companion4 = Result.INSTANCE;
                    Result.m6347constructorimpl(ResultKt.createFailure(th));
                }
                bool = (Boolean) obj;
                Result.m6347constructorimpl(bool);
            } catch (Throwable th2) {
                Result.Companion companion5 = Result.INSTANCE;
                Result.m6347constructorimpl(ResultKt.createFailure(th2));
            }
            xCaseBleConnector = this.$c;
            this.L$0 = null;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtPeerLinkBleApi$disconnectBle$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$disconnectBle$1$3", f = "NtPeerLinkBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ String $ck;
            int label;
            final /* synthetic */ NtPeerLinkBleApi this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(NtPeerLinkBleApi ntPeerLinkBleApi, String str, Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = ntPeerLinkBleApi;
                this.$ck = str;
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, this.$ck, this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.flutterApi.onPeerLinkBleConnectionStateChanged(this.$ck, NtPeerLinkBleConnectionState.DISCONNECTED, this.$ck, new Function1() { // from class: com.nothing.caseble.NtPeerLinkBleApi$disconnectBle$1$3$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtPeerLinkBleApi.AnonymousClass1.AnonymousClass3.invokeSuspend$lambda$0((Result) obj2);
                    }
                });
                Function1<Result<Unit>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(Result result) {
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.generate.NtPeerLinkHostApi
    public void bleConnectionState(String connectKey, Function1<? super Result<? extends NtPeerLinkBleConnectionState>, Unit> callback) {
        AtomicInteger lastState;
        Intrinsics.checkNotNullParameter(connectKey, "connectKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        XCaseBleConnector xCaseBleConnector = this.connectorMap.get(normalizeMacColonUpper(connectKey));
        int i = (xCaseBleConnector == null || (lastState = xCaseBleConnector.getLastState()) == null) ? -1 : lastState.get();
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(toPigeonState(i))));
    }
}
