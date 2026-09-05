package com.nothing.caseble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.generate.NtCaseBleConnectionState;
import com.nothing.generate.NtCaseBleFlutterApi;
import com.nothing.generate.NtCaseBleHostApi;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: NtCaseBleApi.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002JD\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0018\u0010\u0017\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00182\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J\"\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\b2\b\b\u0002\u0010\u001f\u001a\u00020\fH\u0082@\u00a2\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0002J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\bJ\u0010\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0002J*\u0010)\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J8\u0010*\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0,2\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J*\u0010-\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J,\u0010.\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u001a\u0010\u0019\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J,\u0010/\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u001a\u0010\u0019\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001b\u0012\u0004\u0012\u00020\u00150\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/nothing/caseble/NtCaseBleApi;", "Lcom/nothing/generate/NtCaseBleHostApi;", "flutterApi", "Lcom/nothing/generate/NtCaseBleFlutterApi;", "<init>", "(Lcom/nothing/generate/NtCaseBleFlutterApi;)V", "connectorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/caseble/XCaseBleConnector;", "earToCaseMacMap", "connectStartAtMap", "", "receiveCallbackKey", "connectCallbackKey", "staleConnectingTimeoutMs", "toPigeonState", "Lcom/nothing/generate/NtCaseBleConnectionState;", "sdkState", "", "connect", "", "realMac", "uuids", "", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "findCaseMacForEar", "Lcom/nothing/caseble/CaseMatch;", "earMac", "scanTimeoutMs", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalizeMac", "mac", "clearBindingForEar", "reason", "bytesToHex", "bytes", "", "extractCommandHex", DeviceEarImage.DISCONNECT_EAR_IMAGE, "sendData", "data", "", "connectionState", "gattIdentifier", "linkedCaseMac", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NtCaseBleApi implements NtCaseBleHostApi {
    private final String connectCallbackKey;
    private final ConcurrentHashMap<String, Long> connectStartAtMap;
    private final ConcurrentHashMap<String, XCaseBleConnector> connectorMap;
    private final ConcurrentHashMap<String, String> earToCaseMacMap;
    private final NtCaseBleFlutterApi flutterApi;
    private final String receiveCallbackKey;
    private final long staleConnectingTimeoutMs;

    public NtCaseBleApi(NtCaseBleFlutterApi flutterApi) {
        Intrinsics.checkNotNullParameter(flutterApi, "flutterApi");
        this.flutterApi = flutterApi;
        this.connectorMap = new ConcurrentHashMap<>();
        this.earToCaseMacMap = new ConcurrentHashMap<>();
        this.connectStartAtMap = new ConcurrentHashMap<>();
        this.receiveCallbackKey = "case_ble_receive";
        this.connectCallbackKey = "case_ble_connect";
        this.staleConnectingTimeoutMs = 20000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NtCaseBleConnectionState toPigeonState(int sdkState) {
        if (sdkState == -1) {
            return NtCaseBleConnectionState.IDLE;
        }
        if (sdkState == 0) {
            return NtCaseBleConnectionState.DISCONNECTED;
        }
        if (sdkState == 1) {
            return NtCaseBleConnectionState.CONNECTING;
        }
        if (sdkState == 2) {
            return NtCaseBleConnectionState.CONNECTED;
        }
        if (sdkState == 4) {
            return NtCaseBleConnectionState.FAILED;
        }
        return NtCaseBleConnectionState.DISCONNECTED;
    }

    @Override // com.nothing.generate.NtCaseBleHostApi
    public void connect(String realMac, Map<String, String> uuids, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str = uuids != null ? uuids.get("serviceUuid") : null;
        String str2 = uuids != null ? uuids.get("writeUuid") : null;
        String str3 = uuids != null ? uuids.get("notifyUuid") : null;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str4 = "[CaseBle][NtCaseBleApi] connect start earMac=" + realMac + " uuids=" + uuids;
            String str5 = str4;
            if (str5 != null && str5.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str6 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog, 3, str6, tag, str4 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str4 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (realMac.length() != 0) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass2(realMac, uuids, str, str2, str3, callback, null), 3, null);
        } else {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalArgumentException("earMac is empty")))));
        }
    }

    /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2, reason: invalid class name */
    /* JADX INFO: compiled from: NtCaseBleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2", f = "NtCaseBleApi.kt", i = {}, l = {78, 102, 117, 126, 132, 156, 193, 207, 281, 287}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
        final /* synthetic */ String $notifyUuid;
        final /* synthetic */ String $realMac;
        final /* synthetic */ String $serviceUuid;
        final /* synthetic */ Map<String, String> $uuids;
        final /* synthetic */ String $writeUuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(String str, Map<String, String> map, String str2, String str3, String str4, Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$realMac = str;
            this.$uuids = map;
            this.$serviceUuid = str2;
            this.$writeUuid = str3;
            this.$notifyUuid = str4;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtCaseBleApi.this.new AnonymousClass2(this.$realMac, this.$uuids, this.$serviceUuid, this.$writeUuid, this.$notifyUuid, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:121:0x04e9 A[Catch: Exception -> 0x030c, TRY_ENTER, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:126:0x0508  */
        /* JADX WARN: Code duplicated, block: B:138:0x0534  */
        /* JADX WARN: Code duplicated, block: B:139:0x0536 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:146:0x059d A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:149:0x05e4  */
        /* JADX WARN: Code duplicated, block: B:154:0x05fe  */
        /* JADX WARN: Code duplicated, block: B:155:0x0600 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:162:0x066f A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:165:0x06b3  */
        /* JADX WARN: Code duplicated, block: B:168:0x06b8 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:173:0x06e9  */
        /* JADX WARN: Code duplicated, block: B:178:0x0700  */
        /* JADX WARN: Code duplicated, block: B:180:0x0703 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:182:0x071a  */
        /* JADX WARN: Code duplicated, block: B:183:0x071e A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:190:0x07a3 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:192:0x07ee  */
        /* JADX WARN: Code duplicated, block: B:194:0x07f4 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:196:0x0809  */
        /* JADX WARN: Code duplicated, block: B:197:0x080b A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:204:0x0882 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:212:0x08cd  */
        /* JADX WARN: Code duplicated, block: B:213:0x08cf A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:220:0x093f A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:223:0x0995  */
        /* JADX WARN: Code duplicated, block: B:227:0x099c  */
        /* JADX WARN: Code duplicated, block: B:235:0x09b0 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:237:0x09c5  */
        /* JADX WARN: Code duplicated, block: B:238:0x09c7 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:240:0x09f1 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:245:0x0a44 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:254:0x0ad1 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:256:0x0ae6  */
        /* JADX WARN: Code duplicated, block: B:257:0x0aec A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:264:0x0b7d A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:266:0x0bce A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:268:0x0be7  */
        /* JADX WARN: Code duplicated, block: B:269:0x0be9 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:276:0x0c75 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:279:0x0cc7  */
        /* JADX WARN: Code duplicated, block: B:284:0x0cec  */
        /* JADX WARN: Code duplicated, block: B:285:0x0cee A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:292:0x0d5b A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:295:0x0d9a  */
        /* JADX WARN: Code duplicated, block: B:296:0x0d9d  */
        /* JADX WARN: Code duplicated, block: B:299:0x0dae A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:301:0x0dc1  */
        /* JADX WARN: Code duplicated, block: B:302:0x0dc3 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:309:0x0e35 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:312:0x0e7b  */
        /* JADX WARN: Code duplicated, block: B:315:0x0e80 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:317:0x0e93  */
        /* JADX WARN: Code duplicated, block: B:318:0x0e95 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:325:0x0f02 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:328:0x0f47 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:330:0x0f5a  */
        /* JADX WARN: Code duplicated, block: B:331:0x0f5c A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:338:0x0fcb A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:341:0x101c  */
        /* JADX WARN: Code duplicated, block: B:342:0x101e  */
        /* JADX WARN: Code duplicated, block: B:345:0x1023 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:347:0x1038  */
        /* JADX WARN: Code duplicated, block: B:348:0x103a A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:355:0x10a1 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:358:0x10ec  */
        /* JADX WARN: Code duplicated, block: B:359:0x10ee A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:366:0x1169 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:369:0x11d3  */
        /* JADX WARN: Code duplicated, block: B:370:0x11d5 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:377:0x1256 A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:380:0x12cd  */
        /* JADX WARN: Code duplicated, block: B:381:0x12cf A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:388:0x132e A[Catch: Exception -> 0x030c, TryCatch #3 {Exception -> 0x030c, blocks: (B:313:0x0e7d, B:280:0x0cc9, B:224:0x0997, B:150:0x05e6, B:166:0x06b5, B:118:0x04e2, B:121:0x04e9, B:123:0x04f9, B:125:0x04ff, B:136:0x051f, B:147:0x05c6, B:139:0x0536, B:141:0x0550, B:144:0x0557, B:146:0x059d, B:133:0x0516, B:152:0x05e9, B:163:0x0698, B:155:0x0600, B:157:0x0622, B:160:0x0629, B:162:0x066f, B:129:0x050c, B:168:0x06b8, B:170:0x06da, B:172:0x06e0, B:175:0x06ec, B:180:0x0703, B:191:0x07cc, B:208:0x08b1, B:210:0x08b8, B:221:0x0968, B:213:0x08cf, B:215:0x08f1, B:218:0x08f8, B:220:0x093f, B:233:0x09a9, B:235:0x09b0, B:246:0x0a6d, B:238:0x09c7, B:240:0x09f1, B:243:0x09f8, B:245:0x0a44, B:229:0x099f, B:250:0x0a8f, B:252:0x0a96, B:254:0x0ad1, B:265:0x0ba6, B:257:0x0aec, B:259:0x0b2a, B:262:0x0b31, B:264:0x0b7d, B:266:0x0bce, B:277:0x0c9e, B:269:0x0be9, B:271:0x0c25, B:274:0x0c2c, B:276:0x0c75, B:282:0x0ccc, B:293:0x0d84, B:297:0x0d9e, B:299:0x0dae, B:310:0x0e5e, B:302:0x0dc3, B:304:0x0de7, B:307:0x0dee, B:309:0x0e35, B:315:0x0e80, B:326:0x0f2b, B:328:0x0f47, B:339:0x0ff4, B:331:0x0f5c, B:333:0x0f78, B:336:0x0f7f, B:338:0x0fcb, B:343:0x101f, B:345:0x1023, B:348:0x103a, B:350:0x104e, B:353:0x1055, B:355:0x10a1, B:356:0x10ca, B:367:0x1192, B:378:0x127f, B:389:0x1357, B:381:0x12cf, B:383:0x12e1, B:386:0x12e8, B:388:0x132e, B:370:0x11d5, B:372:0x1203, B:375:0x120a, B:377:0x1256, B:359:0x10ee, B:361:0x1116, B:364:0x111d, B:366:0x1169, B:318:0x0e95, B:320:0x0eaf, B:323:0x0eb6, B:325:0x0f02, B:285:0x0cee, B:287:0x0d08, B:290:0x0d0f, B:292:0x0d5b, B:183:0x071e, B:185:0x074e, B:188:0x0755, B:190:0x07a3, B:194:0x07f4, B:197:0x080b, B:199:0x082f, B:202:0x0836, B:204:0x0882, B:70:0x0309), top: B:410:0x0062 }] */
        /* JADX WARN: Code duplicated, block: B:397:0x1390  */
        /* JADX WARN: Code duplicated, block: B:399:0x13b2  */
        /* JADX WARN: Code duplicated, block: B:404:0x1401  */
        /* JADX WARN: Code duplicated, block: B:424:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:427:? A[RETURN, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Logger logger;
            String str;
            String tag;
            int depth;
            String str2;
            String str3;
            String strComponent1;
            String strComponent2;
            Object obj2;
            String str4;
            String str5;
            Object obj3;
            Object objFindCaseMacForEar;
            Object obj4;
            String str6;
            Long longOrNull;
            AtomicInteger lastState;
            CaseMatch caseMatch;
            final String caseMac;
            String str7;
            XCaseBleConnector xCaseBleConnector;
            Integer numBoxInt;
            boolean z;
            boolean z2;
            String str8;
            Logger logger2;
            String str9;
            String tag2;
            int depth2;
            String str10;
            String str11;
            String strComponent3;
            String strComponent4;
            Logger logger3;
            String tag3;
            int depth3;
            String str12;
            String str13;
            String strComponent5;
            String strComponent6;
            XConnectorDevice device;
            String deviceAddress;
            NtCaseBleApi ntCaseBleApi;
            String str14;
            Logger logger4;
            String tag4;
            int depth4;
            String str15;
            String str16;
            String strComponent7;
            String strComponent8;
            boolean zContainsKey;
            ConcurrentHashMap concurrentHashMap;
            String str17;
            Object obj5;
            Logger logger5;
            String str18;
            String str19;
            String str20;
            String tag5;
            int depth5;
            String str21;
            String str22;
            String strComponent9;
            String strComponent10;
            String deviceAddress2;
            Logger logger6;
            String str23;
            String tag6;
            int depth6;
            String str24;
            String str25;
            String strComponent11;
            String strComponent12;
            Logger logger7;
            String str26;
            String tag7;
            int depth7;
            String str27;
            String str28;
            String strComponent13;
            String strComponent14;
            Logger logger8;
            String str29;
            String tag8;
            int depth8;
            String str30;
            String str31;
            String strComponent15;
            String strComponent16;
            Logger logger9;
            String tag9;
            int depth9;
            String str32;
            String str33;
            String strComponent17;
            String strComponent18;
            XCaseBleConnector xCaseBleConnector2;
            Object objPutIfAbsent;
            Logger logger10;
            String tag10;
            int depth10;
            String str34;
            String str35;
            String strComponent19;
            String strComponent20;
            CaseBleConnectGuard.Decision decisionDecideForCurrentState;
            String str36;
            Logger logger11;
            String str37;
            String tag11;
            int depth11;
            String str38;
            String str39;
            String strComponent21;
            String strComponent22;
            Logger logger12;
            String str40;
            String tag12;
            int depth12;
            CaseBleConnectGuard.Decision decision;
            String str41;
            String string;
            String str42;
            String strComponent23;
            String strComponent24;
            Logger logger13;
            String str43;
            String tag13;
            int depth13;
            String str44;
            String str45;
            String strComponent25;
            String strComponent26;
            Logger logger14;
            String str46;
            String tag14;
            int depth14;
            String str47;
            String str48;
            String strComponent27;
            String strComponent28;
            Logger logger15;
            String str49;
            String tag15;
            int depth15;
            String str50;
            String str51;
            String strComponent29;
            String strComponent30;
            AtomicInteger lastState2;
            XCaseBleConnector xCaseBleConnector3;
            Integer numBoxInt2;
            Logger logger16;
            String str52;
            String tag16;
            int depth16;
            String str53;
            String str54;
            String strComponent31;
            String strComponent32;
            Logger logger17;
            String str55;
            String tag17;
            int depth17;
            String str56;
            String str57;
            String strComponent33;
            String strComponent34;
            AtomicInteger lastState3;
            Object obj6 = "[CaseBle][NtCaseBleApi] case changed realMac=";
            String str58 = "[CaseBle][NtCaseBleApi] scan no-match but connector state=";
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                try {
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            XCaseBleConnector xCaseBleConnector4 = (XCaseBleConnector) NtCaseBleApi.this.connectorMap.get(this.$realMac);
                            Integer numBoxInt3 = (xCaseBleConnector4 == null || (lastState = xCaseBleConnector4.getLastState()) == null) ? null : Boxing.boxInt(lastState.get());
                            String str59 = (String) NtCaseBleApi.this.earToCaseMacMap.get(this.$realMac);
                            if (numBoxInt3 != null && numBoxInt3.intValue() == 2) {
                                Logger logger18 = Logger.INSTANCE;
                                String str60 = this.$realMac;
                                String tag18 = logger18.getTAG();
                                int depth18 = logger18.getDepth();
                                if (logger18.isCanLogger(true)) {
                                    String str61 = "[CaseBle][NtCaseBleApi] connect skip scan: already connected realMac=" + str60 + " caseMac=" + str59;
                                    String str62 = str61;
                                    if (str62 != null && str62.length() != 0) {
                                        Pair<String, String> trace = logger18.getTrace(depth18);
                                        String strComponent35 = trace.component1();
                                        String strComponent36 = trace.component2();
                                        FileLog fileLog = FileLog.INSTANCE;
                                        String str63 = logger18.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str63, "format(...)");
                                        FileLog.print$default(fileLog, 3, str63, tag18, str61 + StringUtils.SPACE + strComponent36, null, 16, null);
                                        if (logger18.isDebug()) {
                                            Log.i(tag18 + strComponent35, str61 + StringUtils.SPACE + strComponent36);
                                        }
                                    }
                                }
                                this.label = 1;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new C01132(str59, NtCaseBleApi.this, this.$realMac, this.$callback, null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            if (numBoxInt3 != null && numBoxInt3.intValue() == 1) {
                                try {
                                    NtCaseBleApi.this.connectStartAtMap.putIfAbsent(this.$realMac, Boxing.boxLong(System.currentTimeMillis()));
                                    CaseBleConnectGuard.Decision decisionDecideForCurrentState2 = CaseBleConnectGuard.INSTANCE.decideForCurrentState(numBoxInt3, (Long) NtCaseBleApi.this.connectStartAtMap.get(this.$realMac), System.currentTimeMillis(), NtCaseBleApi.this.staleConnectingTimeoutMs);
                                    if (!decisionDecideForCurrentState2.isStaleConnecting()) {
                                        Logger logger19 = Logger.INSTANCE;
                                        String str64 = this.$realMac;
                                        String tag19 = logger19.getTAG();
                                        int depth19 = logger19.getDepth();
                                        if (logger19.isCanLogger(true)) {
                                            obj3 = coroutine_suspended;
                                            try {
                                                String str65 = "[CaseBle][NtCaseBleApi] connect skip scan: already connecting realMac=" + str64 + " caseMac=" + str59 + " elapsed=" + decisionDecideForCurrentState2.getElapsedMs() + "ms reason=" + decisionDecideForCurrentState2.getReason();
                                                String str66 = str65;
                                                if (str66 != null && str66.length() != 0) {
                                                    Pair<String, String> trace2 = logger19.getTrace(depth19);
                                                    String strComponent37 = trace2.component1();
                                                    String strComponent38 = trace2.component2();
                                                    FileLog fileLog2 = FileLog.INSTANCE;
                                                    String str67 = logger19.getSdf().format(new Date());
                                                    Intrinsics.checkNotNullExpressionValue(str67, "format(...)");
                                                    FileLog.print$default(fileLog2, 3, str67, tag19, str65 + StringUtils.SPACE + strComponent38, null, 16, null);
                                                    if (logger19.isDebug()) {
                                                        Log.i(tag19 + strComponent37, str65 + StringUtils.SPACE + strComponent38);
                                                    }
                                                }
                                            } catch (Exception e) {
                                                e = e;
                                                obj6 = obj3;
                                            }
                                        } else {
                                            obj3 = coroutine_suspended;
                                        }
                                        this.label = 2;
                                        Object obj7 = obj3;
                                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass4(this.$callback, null), this) == obj7) {
                                            return obj7;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                    obj6 = coroutine_suspended;
                                    try {
                                        Logger logger20 = Logger.INSTANCE;
                                        String str68 = this.$realMac;
                                        String tag20 = logger20.getTAG();
                                        int depth20 = logger20.getDepth();
                                        if (logger20.isCanLogger(true)) {
                                            str4 = "[CaseBle][NtCaseBleApi] findCaseMacForEar start earMac=";
                                            str5 = "[CaseBle][NtCaseBleApi] Case box not found for ear: ";
                                            obj2 = obj6;
                                            try {
                                                String str69 = "[CaseBle][NtCaseBleApi] connect stale connecting before scan realMac=" + str68 + " caseMac=" + str59 + " elapsed=" + decisionDecideForCurrentState2.getElapsedMs() + "ms reason=" + decisionDecideForCurrentState2.getReason() + ", clear and continue";
                                                String str70 = str69;
                                                if (str70 != null && str70.length() != 0) {
                                                    Pair<String, String> trace3 = logger20.getTrace(depth20);
                                                    String strComponent39 = trace3.component1();
                                                    String strComponent40 = trace3.component2();
                                                    FileLog fileLog3 = FileLog.INSTANCE;
                                                    String str71 = logger20.getSdf().format(new Date());
                                                    Intrinsics.checkNotNullExpressionValue(str71, "format(...)");
                                                    FileLog.print$default(fileLog3, 6, str71, tag20, str69 + StringUtils.SPACE + strComponent40, null, 16, null);
                                                    if (logger20.isDebug()) {
                                                        Log.e(tag20 + strComponent39, str69 + StringUtils.SPACE + strComponent40);
                                                    }
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                                obj6 = obj2;
                                                logger = Logger.INSTANCE;
                                                str = this.$realMac;
                                                tag = logger.getTAG();
                                                depth = logger.getDepth();
                                                if (logger.isCanLogger(true)) {
                                                    str2 = "[CaseBle][NtCaseBleApi] connect error realMac=" + str + ": " + e.getMessage();
                                                    str3 = str2;
                                                    if (str3 != null) {
                                                        Pair<String, String> trace4 = logger.getTrace(depth);
                                                        strComponent1 = trace4.component1();
                                                        strComponent2 = trace4.component2();
                                                        FileLog fileLog4 = FileLog.INSTANCE;
                                                        String str72 = logger.getSdf().format(new Date());
                                                        Intrinsics.checkNotNullExpressionValue(str72, "format(...)");
                                                        FileLog.print$default(fileLog4, 6, str72, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                                                        if (logger.isDebug()) {
                                                            Log.e(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                                                        }
                                                    }
                                                }
                                                e.printStackTrace();
                                                this.label = 10;
                                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass32(this.$callback, e, null), this) == obj6) {
                                                    return obj6;
                                                }
                                            }
                                        } else {
                                            obj2 = obj6;
                                            str4 = "[CaseBle][NtCaseBleApi] findCaseMacForEar start earMac=";
                                            str5 = "[CaseBle][NtCaseBleApi] Case box not found for ear: ";
                                        }
                                        NtCaseBleApi.this.clearBindingForEar(this.$realMac, "stale connecting before scan");
                                    } catch (Exception e3) {
                                        e = e3;
                                        logger = Logger.INSTANCE;
                                        str = this.$realMac;
                                        tag = logger.getTAG();
                                        depth = logger.getDepth();
                                        if (logger.isCanLogger(true)) {
                                            str2 = "[CaseBle][NtCaseBleApi] connect error realMac=" + str + ": " + e.getMessage();
                                            str3 = str2;
                                            if (str3 != null) {
                                                Pair<String, String> trace5 = logger.getTrace(depth);
                                                strComponent1 = trace5.component1();
                                                strComponent2 = trace5.component2();
                                                FileLog fileLog5 = FileLog.INSTANCE;
                                                String str73 = logger.getSdf().format(new Date());
                                                Intrinsics.checkNotNullExpressionValue(str73, "format(...)");
                                                FileLog.print$default(fileLog5, 6, str73, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                                                if (logger.isDebug()) {
                                                    Log.e(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                                                }
                                            }
                                        }
                                        e.printStackTrace();
                                        this.label = 10;
                                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass32(this.$callback, e, null), this) == obj6) {
                                            return obj6;
                                        }
                                    }
                                } catch (Exception e4) {
                                    e = e4;
                                    obj2 = coroutine_suspended;
                                    obj6 = obj2;
                                }
                                logger = Logger.INSTANCE;
                                str = this.$realMac;
                                tag = logger.getTAG();
                                depth = logger.getDepth();
                                if (logger.isCanLogger(true)) {
                                    str2 = "[CaseBle][NtCaseBleApi] connect error realMac=" + str + ": " + e.getMessage();
                                    str3 = str2;
                                    if (str3 != null && str3.length() != 0) {
                                        Pair<String, String> trace6 = logger.getTrace(depth);
                                        strComponent1 = trace6.component1();
                                        strComponent2 = trace6.component2();
                                        FileLog fileLog6 = FileLog.INSTANCE;
                                        String str74 = logger.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str74, "format(...)");
                                        FileLog.print$default(fileLog6, 6, str74, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                                        if (logger.isDebug()) {
                                            Log.e(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                                        }
                                    }
                                }
                                e.printStackTrace();
                                this.label = 10;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass32(this.$callback, e, null), this) == obj6) {
                                    return obj6;
                                }
                                return Unit.INSTANCE;
                            }
                            obj2 = coroutine_suspended;
                            str4 = "[CaseBle][NtCaseBleApi] findCaseMacForEar start earMac=";
                            str5 = "[CaseBle][NtCaseBleApi] Case box not found for ear: ";
                            Map<String, String> map = this.$uuids;
                            long jLongValue = (map == null || (str6 = map.get("scanTimeoutMs")) == null || (longOrNull = StringsKt.toLongOrNull(str6)) == null) ? 15000L : longOrNull.longValue();
                            Logger logger21 = Logger.INSTANCE;
                            String str75 = this.$realMac;
                            String tag21 = logger21.getTAG();
                            int depth21 = logger21.getDepth();
                            if (logger21.isCanLogger(true)) {
                                String str76 = str4 + str75 + " scanTimeoutMs=" + jLongValue;
                                String str77 = str76;
                                if (str77 != null && str77.length() != 0) {
                                    Pair<String, String> trace7 = logger21.getTrace(depth21);
                                    String strComponent41 = trace7.component1();
                                    String strComponent42 = trace7.component2();
                                    FileLog fileLog7 = FileLog.INSTANCE;
                                    String str78 = logger21.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str78, "format(...)");
                                    FileLog.print$default(fileLog7, 3, str78, tag21, str76 + StringUtils.SPACE + strComponent42, null, 16, null);
                                    if (logger21.isDebug()) {
                                        Log.i(tag21 + strComponent41, str76 + StringUtils.SPACE + strComponent42);
                                    }
                                }
                            }
                            this.label = 3;
                            objFindCaseMacForEar = NtCaseBleApi.this.findCaseMacForEar(this.$realMac, jLongValue, this);
                            obj4 = obj2;
                            if (objFindCaseMacForEar == obj4) {
                                return obj4;
                            }
                            caseMatch = (CaseMatch) objFindCaseMacForEar;
                            if (caseMatch == null) {
                                xCaseBleConnector3 = (XCaseBleConnector) NtCaseBleApi.this.connectorMap.get(this.$realMac);
                                if (xCaseBleConnector3 != null || (lastState3 = xCaseBleConnector3.getLastState()) == null) {
                                    numBoxInt2 = null;
                                } else {
                                    numBoxInt2 = Boxing.boxInt(lastState3.get());
                                }
                                if (numBoxInt2 != null || numBoxInt2.intValue() != 2) {
                                    if (numBoxInt2 != null && numBoxInt2.intValue() == 1) {
                                    }
                                    logger17 = Logger.INSTANCE;
                                    str55 = this.$realMac;
                                    tag17 = logger17.getTAG();
                                    depth17 = logger17.getDepth();
                                    if (!logger17.isCanLogger(true)) {
                                        str56 = str5 + str55 + " (case may be closed or out of range)";
                                        str57 = str56;
                                        if (str57 != null && str57.length() != 0) {
                                            Pair<String, String> trace8 = logger17.getTrace(depth17);
                                            strComponent33 = trace8.component1();
                                            strComponent34 = trace8.component2();
                                            FileLog fileLog8 = FileLog.INSTANCE;
                                            String str79 = logger17.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str79, "format(...)");
                                            FileLog.print$default(fileLog8, 6, str79, tag17, str56 + StringUtils.SPACE + strComponent34, null, 16, null);
                                            if (logger17.isDebug()) {
                                                Log.e(tag17 + strComponent33, str56 + StringUtils.SPACE + strComponent34);
                                            }
                                        }
                                    }
                                    this.label = 5;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass10(this.$callback, this.$realMac, null), this) == obj4) {
                                        return obj4;
                                    }
                                    return Unit.INSTANCE;
                                }
                                logger16 = Logger.INSTANCE;
                                str52 = this.$realMac;
                                tag16 = logger16.getTAG();
                                depth16 = logger16.getDepth();
                                if (!logger16.isCanLogger(true)) {
                                    str53 = str58 + numBoxInt2 + " realMac=" + str52 + ", treat as success";
                                    str54 = str53;
                                    if (str54 != null && str54.length() != 0) {
                                        Pair<String, String> trace9 = logger16.getTrace(depth16);
                                        strComponent31 = trace9.component1();
                                        strComponent32 = trace9.component2();
                                        FileLog fileLog9 = FileLog.INSTANCE;
                                        String str80 = logger16.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str80, "format(...)");
                                        FileLog.print$default(fileLog9, 3, str80, tag16, str53 + StringUtils.SPACE + strComponent32, null, 16, null);
                                        if (logger16.isDebug()) {
                                            Log.i(tag16 + strComponent31, str53 + StringUtils.SPACE + strComponent32);
                                        }
                                    }
                                }
                                this.label = 4;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass8(this.$callback, null), this) == obj4) {
                                    return obj4;
                                }
                                return Unit.INSTANCE;
                            }
                            caseMac = caseMatch.getCaseMac();
                            str7 = (String) NtCaseBleApi.this.earToCaseMacMap.get(this.$realMac);
                            xCaseBleConnector = (XCaseBleConnector) NtCaseBleApi.this.connectorMap.get(this.$realMac);
                            if (xCaseBleConnector != null || (lastState2 = xCaseBleConnector.getLastState()) == null) {
                                numBoxInt = null;
                            } else {
                                numBoxInt = Boxing.boxInt(lastState2.get());
                            }
                            if (str7 != null || Intrinsics.areEqual(NtCaseBleApi.this.normalizeMac(str7), NtCaseBleApi.this.normalizeMac(caseMac))) {
                                z = false;
                            } else {
                                z = true;
                            }
                            if (z) {
                                logger15 = Logger.INSTANCE;
                                str49 = this.$realMac;
                                tag15 = logger15.getTAG();
                                depth15 = logger15.getDepth();
                                z2 = z;
                                if (logger15.isCanLogger(true)) {
                                    str8 = "ms reason=";
                                    str50 = "[CaseBle][NtCaseBleApi] case changed realMac=" + str49 + " oldCaseMac=" + str7 + " newCaseMac=" + caseMac + ", destroy old connector first";
                                    str51 = str50;
                                    if (str51 != null && str51.length() != 0) {
                                        Pair<String, String> trace10 = logger15.getTrace(depth15);
                                        strComponent29 = trace10.component1();
                                        strComponent30 = trace10.component2();
                                        FileLog fileLog10 = FileLog.INSTANCE;
                                        String str81 = logger15.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str81, "format(...)");
                                        FileLog.print$default(fileLog10, 3, str81, tag15, str50 + StringUtils.SPACE + strComponent30, null, 16, null);
                                        if (logger15.isDebug()) {
                                            Log.i(tag15 + strComponent29, str50 + StringUtils.SPACE + strComponent30);
                                        }
                                    }
                                } else {
                                    str8 = "ms reason=";
                                }
                                NtCaseBleApi.this.clearBindingForEar(this.$realMac, "case changed: " + str7 + " -> " + caseMac);
                            } else {
                                z2 = z;
                                str8 = "ms reason=";
                                if (numBoxInt != null) {
                                    logger2 = Logger.INSTANCE;
                                    str9 = this.$realMac;
                                    tag2 = logger2.getTAG();
                                    depth2 = logger2.getDepth();
                                    if (!logger2.isCanLogger(true)) {
                                        str10 = "[CaseBle][NtCaseBleApi] existing connector state=" + numBoxInt + " realMac=" + str9 + " caseMac=" + str7;
                                        str11 = str10;
                                        if (str11 != null && str11.length() != 0) {
                                            Pair<String, String> trace11 = logger2.getTrace(depth2);
                                            strComponent3 = trace11.component1();
                                            strComponent4 = trace11.component2();
                                            FileLog fileLog11 = FileLog.INSTANCE;
                                            String str82 = logger2.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str82, "format(...)");
                                            FileLog.print$default(fileLog11, 3, str82, tag2, str10 + StringUtils.SPACE + strComponent4, null, 16, null);
                                            if (logger2.isDebug()) {
                                                Log.i(tag2 + strComponent3, str10 + StringUtils.SPACE + strComponent4);
                                            }
                                        }
                                    }
                                }
                            }
                            if (!z2 && numBoxInt != null && numBoxInt.intValue() == 2) {
                                logger14 = Logger.INSTANCE;
                                str46 = this.$realMac;
                                tag14 = logger14.getTAG();
                                depth14 = logger14.getDepth();
                                if (!logger14.isCanLogger(true)) {
                                    str47 = "[CaseBle][NtCaseBleApi] already connected realMac=" + str46 + " caseMac=" + caseMac + ", skip";
                                    str48 = str47;
                                    if (str48 != null && str48.length() != 0) {
                                        Pair<String, String> trace12 = logger14.getTrace(depth14);
                                        strComponent27 = trace12.component1();
                                        strComponent28 = trace12.component2();
                                        FileLog fileLog12 = FileLog.INSTANCE;
                                        String str83 = logger14.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str83, "format(...)");
                                        FileLog.print$default(fileLog12, 3, str83, tag14, str47 + StringUtils.SPACE + strComponent28, null, 16, null);
                                        if (logger14.isDebug()) {
                                            Log.i(tag14 + strComponent27, str47 + StringUtils.SPACE + strComponent28);
                                        }
                                    }
                                }
                                NtCaseBleApi.this.earToCaseMacMap.put(this.$realMac, caseMac);
                                this.label = 6;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass14(NtCaseBleApi.this, this.$realMac, caseMac, this.$callback, null), this) == obj4) {
                                    return obj4;
                                }
                                return Unit.INSTANCE;
                            }
                            if (!z2) {
                                if (numBoxInt == null || numBoxInt.intValue() != 0) {
                                    if (numBoxInt != null && numBoxInt.intValue() == 4) {
                                        logger13 = Logger.INSTANCE;
                                        str43 = this.$realMac;
                                        tag13 = logger13.getTAG();
                                        depth13 = logger13.getDepth();
                                        if (!logger13.isCanLogger(true)) {
                                            str44 = "[CaseBle][NtCaseBleApi] existing connector is stale state=" + numBoxInt + " realMac=" + str43 + " caseMac=" + caseMac + ", recreate connector before reconnect";
                                            str45 = str44;
                                            if (str45 != null) {
                                                Pair<String, String> trace13 = logger13.getTrace(depth13);
                                                strComponent25 = trace13.component1();
                                                strComponent26 = trace13.component2();
                                                FileLog fileLog13 = FileLog.INSTANCE;
                                                String str84 = logger13.getSdf().format(new Date());
                                                Intrinsics.checkNotNullExpressionValue(str84, "format(...)");
                                                FileLog.print$default(fileLog13, 6, str84, tag13, str44 + StringUtils.SPACE + strComponent26, null, 16, null);
                                                if (logger13.isDebug()) {
                                                    Log.e(tag13 + strComponent25, str44 + StringUtils.SPACE + strComponent26);
                                                }
                                            }
                                        }
                                        NtCaseBleApi.this.clearBindingForEar(this.$realMac, "stale connector state=" + numBoxInt + " before reconnect");
                                    }
                                } else {
                                    logger13 = Logger.INSTANCE;
                                    str43 = this.$realMac;
                                    tag13 = logger13.getTAG();
                                    depth13 = logger13.getDepth();
                                    if (!logger13.isCanLogger(true)) {
                                        str44 = "[CaseBle][NtCaseBleApi] existing connector is stale state=" + numBoxInt + " realMac=" + str43 + " caseMac=" + caseMac + ", recreate connector before reconnect";
                                        str45 = str44;
                                        if (str45 != null && str45.length() != 0) {
                                            Pair<String, String> trace14 = logger13.getTrace(depth13);
                                            strComponent25 = trace14.component1();
                                            strComponent26 = trace14.component2();
                                            FileLog fileLog14 = FileLog.INSTANCE;
                                            String str85 = logger13.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str85, "format(...)");
                                            FileLog.print$default(fileLog14, 6, str85, tag13, str44 + StringUtils.SPACE + strComponent26, null, 16, null);
                                            if (logger13.isDebug()) {
                                                Log.e(tag13 + strComponent25, str44 + StringUtils.SPACE + strComponent26);
                                            }
                                        }
                                    }
                                    NtCaseBleApi.this.clearBindingForEar(this.$realMac, "stale connector state=" + numBoxInt + " before reconnect");
                                }
                            }
                            if (!z2 && numBoxInt != null && numBoxInt.intValue() == 1) {
                                NtCaseBleApi.this.connectStartAtMap.putIfAbsent(this.$realMac, Boxing.boxLong(System.currentTimeMillis()));
                                decisionDecideForCurrentState = CaseBleConnectGuard.INSTANCE.decideForCurrentState(numBoxInt, (Long) NtCaseBleApi.this.connectStartAtMap.get(this.$realMac), System.currentTimeMillis(), NtCaseBleApi.this.staleConnectingTimeoutMs);
                                if (decisionDecideForCurrentState.isStaleConnecting()) {
                                    logger12 = Logger.INSTANCE;
                                    str40 = this.$realMac;
                                    tag12 = logger12.getTAG();
                                    depth12 = logger12.getDepth();
                                    if (logger12.isCanLogger(true)) {
                                        long elapsedMs = decisionDecideForCurrentState.getElapsedMs();
                                        String reason = decisionDecideForCurrentState.getReason();
                                        decision = decisionDecideForCurrentState;
                                        StringBuilder sbAppend = new StringBuilder("[CaseBle][NtCaseBleApi] connecting seems stale realMac=").append(str40).append(" caseMac=").append(caseMac).append(" elapsed=").append(elapsedMs);
                                        str41 = str8;
                                        string = sbAppend.append(str41).append(reason).append(", force clear and reconnect").toString();
                                        str42 = string;
                                        if (str42 != null && str42.length() != 0) {
                                            Pair<String, String> trace15 = logger12.getTrace(depth12);
                                            strComponent23 = trace15.component1();
                                            strComponent24 = trace15.component2();
                                            FileLog fileLog15 = FileLog.INSTANCE;
                                            String str86 = logger12.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str86, "format(...)");
                                            FileLog.print$default(fileLog15, 6, str86, tag12, string + StringUtils.SPACE + strComponent24, null, 16, null);
                                            if (logger12.isDebug()) {
                                                Log.e(tag12 + strComponent23, string + StringUtils.SPACE + strComponent24);
                                            }
                                        }
                                    } else {
                                        decision = decisionDecideForCurrentState;
                                        str41 = str8;
                                    }
                                    NtCaseBleApi.this.clearBindingForEar(this.$realMac, "stale connecting elapsed=" + decision.getElapsedMs() + str41 + decision.getReason());
                                } else {
                                    str36 = str8;
                                    logger11 = Logger.INSTANCE;
                                    str37 = this.$realMac;
                                    tag11 = logger11.getTAG();
                                    depth11 = logger11.getDepth();
                                    if (!logger11.isCanLogger(true)) {
                                        str38 = "[CaseBle][NtCaseBleApi] already connecting realMac=" + str37 + " caseMac=" + caseMac + " elapsed=" + decisionDecideForCurrentState.getElapsedMs() + str36 + decisionDecideForCurrentState.getReason() + ", skip duplicate connect";
                                        str39 = str38;
                                        if (str39 != null && str39.length() != 0) {
                                            Pair<String, String> trace16 = logger11.getTrace(depth11);
                                            strComponent21 = trace16.component1();
                                            strComponent22 = trace16.component2();
                                            FileLog fileLog16 = FileLog.INSTANCE;
                                            String str87 = logger11.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str87, "format(...)");
                                            FileLog.print$default(fileLog16, 3, str87, tag11, str38 + StringUtils.SPACE + strComponent22, null, 16, null);
                                            if (logger11.isDebug()) {
                                                Log.i(tag11 + strComponent21, str38 + StringUtils.SPACE + strComponent22);
                                            }
                                        }
                                    }
                                    NtCaseBleApi.this.earToCaseMacMap.put(this.$realMac, caseMac);
                                    this.label = 7;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass18(this.$callback, null), this) == obj4) {
                                        return obj4;
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            NtCaseBleApi.this.earToCaseMacMap.put(this.$realMac, caseMac);
                            logger3 = Logger.INSTANCE;
                            tag3 = logger3.getTAG();
                            depth3 = logger3.getDepth();
                            if (!logger3.isCanLogger(true)) {
                                str12 = "[CaseBle][NtCaseBleApi] case found caseMac=" + caseMac + ", earToCaseMacMap saved, getting device";
                                str13 = str12;
                                if (str13 != null && str13.length() != 0) {
                                    Pair<String, String> trace17 = logger3.getTrace(depth3);
                                    strComponent5 = trace17.component1();
                                    strComponent6 = trace17.component2();
                                    FileLog fileLog17 = FileLog.INSTANCE;
                                    String str88 = logger3.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str88, "format(...)");
                                    FileLog.print$default(fileLog17, 3, str88, tag3, str12 + StringUtils.SPACE + strComponent6, null, 16, null);
                                    if (logger3.isDebug()) {
                                        Log.i(tag3 + strComponent5, str12 + StringUtils.SPACE + strComponent6);
                                    }
                                }
                            }
                            device = XBluetoothManager.INSTANCE.get().getDevice(caseMac);
                            deviceAddress = device.getXBluetoothDevice().getDeviceAddress();
                            ntCaseBleApi = NtCaseBleApi.this;
                            if (deviceAddress == null) {
                                str14 = "";
                            } else {
                                str14 = deviceAddress;
                            }
                            if (!Intrinsics.areEqual(ntCaseBleApi.normalizeMac(str14), NtCaseBleApi.this.normalizeMac(caseMac))) {
                                logger10 = Logger.INSTANCE;
                                tag10 = logger10.getTAG();
                                depth10 = logger10.getDepth();
                                if (!logger10.isCanLogger(true)) {
                                    str34 = "[CaseBle][NtCaseBleApi] getDevice returned wrong device: address=" + deviceAddress + " expected caseMac=" + caseMac + ", skip to avoid binding to earphone";
                                    str35 = str34;
                                    if (str35 != null && str35.length() != 0) {
                                        Pair<String, String> trace18 = logger10.getTrace(depth10);
                                        strComponent19 = trace18.component1();
                                        strComponent20 = trace18.component2();
                                        FileLog fileLog18 = FileLog.INSTANCE;
                                        String str89 = logger10.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str89, "format(...)");
                                        FileLog.print$default(fileLog18, 6, str89, tag10, str34 + StringUtils.SPACE + strComponent20, null, 16, null);
                                        if (logger10.isDebug()) {
                                            Log.e(tag10 + strComponent19, str34 + StringUtils.SPACE + strComponent20);
                                        }
                                    }
                                }
                                this.label = 8;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass21(this.$callback, caseMac, null), this) == obj4) {
                                    return obj4;
                                }
                                return Unit.INSTANCE;
                            }
                            logger4 = Logger.INSTANCE;
                            tag4 = logger4.getTAG();
                            depth4 = logger4.getDepth();
                            if (!logger4.isCanLogger(true)) {
                                str15 = "[CaseBle][NtCaseBleApi] device obtained, xBluetoothDevice=" + deviceAddress + " (case, not ear)";
                                str16 = str15;
                                if (str16 != null && str16.length() != 0) {
                                    Pair<String, String> trace19 = logger4.getTrace(depth4);
                                    strComponent7 = trace19.component1();
                                    strComponent8 = trace19.component2();
                                    FileLog fileLog19 = FileLog.INSTANCE;
                                    String str90 = logger4.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str90, "format(...)");
                                    FileLog.print$default(fileLog19, 3, str90, tag4, str15 + StringUtils.SPACE + strComponent8, null, 16, null);
                                    if (logger4.isDebug()) {
                                        Log.i(tag4 + strComponent7, str15 + StringUtils.SPACE + strComponent8);
                                    }
                                }
                            }
                            zContainsKey = NtCaseBleApi.this.connectorMap.containsKey(this.$realMac);
                            concurrentHashMap = NtCaseBleApi.this.connectorMap;
                            str17 = this.$realMac;
                            obj5 = concurrentHashMap.get(str17);
                            if (obj5 == null) {
                                logger9 = Logger.INSTANCE;
                                tag9 = logger9.getTAG();
                                depth9 = logger9.getDepth();
                                if (!logger9.isCanLogger(true)) {
                                    str32 = "[CaseBle][NtCaseBleApi] create new XCaseBleConnector for realMac=" + str17 + " caseMac=" + caseMac;
                                    str33 = str32;
                                    if (str33 != null && str33.length() != 0) {
                                        Pair<String, String> trace20 = logger9.getTrace(depth9);
                                        strComponent17 = trace20.component1();
                                        strComponent18 = trace20.component2();
                                        FileLog fileLog20 = FileLog.INSTANCE;
                                        String str91 = logger9.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str91, "format(...)");
                                        FileLog.print$default(fileLog20, 3, str91, tag9, str32 + StringUtils.SPACE + strComponent18, null, 16, null);
                                        if (logger9.isDebug()) {
                                            Log.i(tag9 + strComponent17, str32 + StringUtils.SPACE + strComponent18);
                                        }
                                    }
                                }
                                xCaseBleConnector2 = new XCaseBleConnector(new XCaseBleParser(), "CaseBle_" + str17);
                                xCaseBleConnector2.onCreate(device.getXBluetoothDevice());
                                objPutIfAbsent = concurrentHashMap.putIfAbsent(str17, xCaseBleConnector2);
                                if (objPutIfAbsent == null) {
                                    obj5 = xCaseBleConnector2;
                                } else {
                                    obj5 = objPutIfAbsent;
                                }
                            }
                            XCaseBleConnector xCaseBleConnector5 = (XCaseBleConnector) obj5;
                            if (zContainsKey) {
                                logger8 = Logger.INSTANCE;
                                str29 = this.$realMac;
                                tag8 = logger8.getTAG();
                                depth8 = logger8.getDepth();
                                if (!logger8.isCanLogger(true)) {
                                    str30 = "[CaseBle][NtCaseBleApi] reuse existing connector realMac=" + str29;
                                    str31 = str30;
                                    if (str31 != null && str31.length() != 0) {
                                        Pair<String, String> trace21 = logger8.getTrace(depth8);
                                        strComponent15 = trace21.component1();
                                        strComponent16 = trace21.component2();
                                        FileLog fileLog21 = FileLog.INSTANCE;
                                        String str92 = logger8.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str92, "format(...)");
                                        FileLog.print$default(fileLog21, 3, str92, tag8, str30 + StringUtils.SPACE + strComponent16, null, 16, null);
                                        if (logger8.isDebug()) {
                                            Log.i(tag8 + strComponent15, str30 + StringUtils.SPACE + strComponent16);
                                        }
                                    }
                                }
                            }
                            xCaseBleConnector5.setUuids(this.$serviceUuid, this.$writeUuid, this.$notifyUuid);
                            logger5 = Logger.INSTANCE;
                            str18 = this.$serviceUuid;
                            str19 = this.$writeUuid;
                            str20 = this.$notifyUuid;
                            tag5 = logger5.getTAG();
                            depth5 = logger5.getDepth();
                            if (!logger5.isCanLogger(true)) {
                                str21 = "[CaseBle][NtCaseBleApi] setUuids done serviceUuid=" + str18 + " writeUuid=" + str19 + " notifyUuid=" + str20;
                                str22 = str21;
                                if (str22 != null && str22.length() != 0) {
                                    Pair<String, String> trace22 = logger5.getTrace(depth5);
                                    strComponent9 = trace22.component1();
                                    strComponent10 = trace22.component2();
                                    FileLog fileLog22 = FileLog.INSTANCE;
                                    String str93 = logger5.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str93, "format(...)");
                                    FileLog.print$default(fileLog22, 3, str93, tag5, str21 + StringUtils.SPACE + strComponent10, null, 16, null);
                                    if (logger5.isDebug()) {
                                        Log.i(tag5 + strComponent9, str21 + StringUtils.SPACE + strComponent10);
                                    }
                                }
                            }
                            String str94 = NtCaseBleApi.this.receiveCallbackKey;
                            final String str95 = this.$realMac;
                            final NtCaseBleApi ntCaseBleApi2 = NtCaseBleApi.this;
                            xCaseBleConnector5.setMessageReceiveCallback(str94, new Function1() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj8) {
                                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$23(str95, ntCaseBleApi2, (XCommand) obj8);
                                }
                            });
                            String str96 = NtCaseBleApi.this.connectCallbackKey;
                            final NtCaseBleApi ntCaseBleApi3 = NtCaseBleApi.this;
                            final String str97 = this.$realMac;
                            xCaseBleConnector5.setDeviceConnectCallback(str96, new Function2() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj8, Object obj9) {
                                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$26(ntCaseBleApi3, str97, caseMac, ((Integer) obj8).intValue(), (XConnectFailType) obj9);
                                }
                            });
                            deviceAddress2 = device.getXBluetoothDevice().getDeviceAddress();
                            logger6 = Logger.INSTANCE;
                            str23 = this.$realMac;
                            tag6 = logger6.getTAG();
                            depth6 = logger6.getDepth();
                            if (!logger6.isCanLogger(true)) {
                                str24 = "[CaseBle][NtCaseBleApi] about to connector.connect() ear(realMac)=" + str23 + " -> case(caseMac)=" + caseMac + " connectorTarget=" + deviceAddress2 + " isForceConnectRelation=false(standalone)";
                                str25 = str24;
                                if (str25 != null && str25.length() != 0) {
                                    Pair<String, String> trace23 = logger6.getTrace(depth6);
                                    strComponent11 = trace23.component1();
                                    strComponent12 = trace23.component2();
                                    FileLog fileLog23 = FileLog.INSTANCE;
                                    String str98 = logger6.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str98, "format(...)");
                                    FileLog.print$default(fileLog23, 3, str98, tag6, str24 + StringUtils.SPACE + strComponent12, null, 16, null);
                                    if (logger6.isDebug()) {
                                        Log.i(tag6 + strComponent11, str24 + StringUtils.SPACE + strComponent12);
                                    }
                                }
                            }
                            NtCaseBleApi.this.connectStartAtMap.put(this.$realMac, Boxing.boxLong(System.currentTimeMillis()));
                            final String str99 = this.$realMac;
                            XConnector.connect$default(xCaseBleConnector5, null, null, null, null, false, false, false, 0, false, new Function1() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj8) {
                                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$34(str99, caseMac, (XConnectCallback) obj8);
                                }
                            }, null, 1519, null);
                            logger7 = Logger.INSTANCE;
                            str26 = this.$realMac;
                            tag7 = logger7.getTAG();
                            depth7 = logger7.getDepth();
                            if (!logger7.isCanLogger(true)) {
                                str27 = "[CaseBle][NtCaseBleApi] connect flow done (async connect started), callback.success realMac=" + str26;
                                str28 = str27;
                                if (str28 != null && str28.length() != 0) {
                                    Pair<String, String> trace24 = logger7.getTrace(depth7);
                                    strComponent13 = trace24.component1();
                                    strComponent14 = trace24.component2();
                                    FileLog fileLog24 = FileLog.INSTANCE;
                                    String str100 = logger7.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str100, "format(...)");
                                    FileLog.print$default(fileLog24, 3, str100, tag7, str27 + StringUtils.SPACE + strComponent14, null, 16, null);
                                    if (logger7.isDebug()) {
                                        Log.i(tag7 + strComponent13, str27 + StringUtils.SPACE + strComponent14);
                                    }
                                }
                            }
                            this.label = 9;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass30(this.$callback, null), this) == obj4) {
                                return obj4;
                            }
                            return Unit.INSTANCE;
                        case 1:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 2:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 3:
                            ResultKt.throwOnFailure(obj);
                            obj4 = coroutine_suspended;
                            str58 = "[CaseBle][NtCaseBleApi] scan no-match but connector state=";
                            str5 = "[CaseBle][NtCaseBleApi] Case box not found for ear: ";
                            objFindCaseMacForEar = obj;
                            caseMatch = (CaseMatch) objFindCaseMacForEar;
                            if (caseMatch == null) {
                                xCaseBleConnector3 = (XCaseBleConnector) NtCaseBleApi.this.connectorMap.get(this.$realMac);
                                if (xCaseBleConnector3 != null) {
                                    numBoxInt2 = null;
                                } else {
                                    numBoxInt2 = null;
                                }
                                if (numBoxInt2 != null) {
                                    break;
                                }
                                if (numBoxInt2 != null) {
                                    logger16 = Logger.INSTANCE;
                                    str52 = this.$realMac;
                                    tag16 = logger16.getTAG();
                                    depth16 = logger16.getDepth();
                                    if (!logger16.isCanLogger(true)) {
                                        str53 = str58 + numBoxInt2 + " realMac=" + str52 + ", treat as success";
                                        str54 = str53;
                                        if (str54 != null) {
                                            Pair<String, String> trace25 = logger16.getTrace(depth16);
                                            strComponent31 = trace25.component1();
                                            strComponent32 = trace25.component2();
                                            FileLog fileLog25 = FileLog.INSTANCE;
                                            String str810 = logger16.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str810, "format(...)");
                                            FileLog.print$default(fileLog25, 3, str810, tag16, str53 + StringUtils.SPACE + strComponent32, null, 16, null);
                                            if (logger16.isDebug()) {
                                                Log.i(tag16 + strComponent31, str53 + StringUtils.SPACE + strComponent32);
                                            }
                                        }
                                    }
                                    this.label = 4;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass8(this.$callback, null), this) == obj4) {
                                        return obj4;
                                    }
                                    return Unit.INSTANCE;
                                }
                                logger17 = Logger.INSTANCE;
                                str55 = this.$realMac;
                                tag17 = logger17.getTAG();
                                depth17 = logger17.getDepth();
                                if (!logger17.isCanLogger(true)) {
                                    str56 = str5 + str55 + " (case may be closed or out of range)";
                                    str57 = str56;
                                    if (str57 != null) {
                                        Pair<String, String> trace26 = logger17.getTrace(depth17);
                                        strComponent33 = trace26.component1();
                                        strComponent34 = trace26.component2();
                                        FileLog fileLog26 = FileLog.INSTANCE;
                                        String str710 = logger17.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str710, "format(...)");
                                        FileLog.print$default(fileLog26, 6, str710, tag17, str56 + StringUtils.SPACE + strComponent34, null, 16, null);
                                        if (logger17.isDebug()) {
                                            Log.e(tag17 + strComponent33, str56 + StringUtils.SPACE + strComponent34);
                                        }
                                    }
                                }
                                this.label = 5;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass10(this.$callback, this.$realMac, null), this) == obj4) {
                                    return obj4;
                                }
                                return Unit.INSTANCE;
                            }
                            caseMac = caseMatch.getCaseMac();
                            str7 = (String) NtCaseBleApi.this.earToCaseMacMap.get(this.$realMac);
                            xCaseBleConnector = (XCaseBleConnector) NtCaseBleApi.this.connectorMap.get(this.$realMac);
                            if (xCaseBleConnector != null) {
                                numBoxInt = null;
                            } else {
                                numBoxInt = null;
                            }
                            if (str7 != null) {
                                z = false;
                            } else {
                                z = false;
                            }
                            if (z) {
                                logger15 = Logger.INSTANCE;
                                str49 = this.$realMac;
                                tag15 = logger15.getTAG();
                                depth15 = logger15.getDepth();
                                z2 = z;
                                if (logger15.isCanLogger(true)) {
                                    str8 = "ms reason=";
                                } else {
                                    str8 = "ms reason=";
                                    str50 = "[CaseBle][NtCaseBleApi] case changed realMac=" + str49 + " oldCaseMac=" + str7 + " newCaseMac=" + caseMac + ", destroy old connector first";
                                    str51 = str50;
                                    if (str51 != null) {
                                        Pair<String, String> trace110 = logger15.getTrace(depth15);
                                        strComponent29 = trace110.component1();
                                        strComponent30 = trace110.component2();
                                        FileLog fileLog110 = FileLog.INSTANCE;
                                        String str811 = logger15.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str811, "format(...)");
                                        FileLog.print$default(fileLog110, 3, str811, tag15, str50 + StringUtils.SPACE + strComponent30, null, 16, null);
                                        if (logger15.isDebug()) {
                                            Log.i(tag15 + strComponent29, str50 + StringUtils.SPACE + strComponent30);
                                        }
                                    }
                                }
                                NtCaseBleApi.this.clearBindingForEar(this.$realMac, "case changed: " + str7 + " -> " + caseMac);
                            } else {
                                z2 = z;
                                str8 = "ms reason=";
                                if (numBoxInt != null) {
                                    logger2 = Logger.INSTANCE;
                                    str9 = this.$realMac;
                                    tag2 = logger2.getTAG();
                                    depth2 = logger2.getDepth();
                                    if (!logger2.isCanLogger(true)) {
                                        str10 = "[CaseBle][NtCaseBleApi] existing connector state=" + numBoxInt + " realMac=" + str9 + " caseMac=" + str7;
                                        str11 = str10;
                                        if (str11 != null) {
                                            Pair<String, String> trace111 = logger2.getTrace(depth2);
                                            strComponent3 = trace111.component1();
                                            strComponent4 = trace111.component2();
                                            FileLog fileLog111 = FileLog.INSTANCE;
                                            String str812 = logger2.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str812, "format(...)");
                                            FileLog.print$default(fileLog111, 3, str812, tag2, str10 + StringUtils.SPACE + strComponent4, null, 16, null);
                                            if (logger2.isDebug()) {
                                                Log.i(tag2 + strComponent3, str10 + StringUtils.SPACE + strComponent4);
                                            }
                                        }
                                    }
                                }
                            }
                            if (!z2) {
                                logger14 = Logger.INSTANCE;
                                str46 = this.$realMac;
                                tag14 = logger14.getTAG();
                                depth14 = logger14.getDepth();
                                if (!logger14.isCanLogger(true)) {
                                    str47 = "[CaseBle][NtCaseBleApi] already connected realMac=" + str46 + " caseMac=" + caseMac + ", skip";
                                    str48 = str47;
                                    if (str48 != null) {
                                        Pair<String, String> trace112 = logger14.getTrace(depth14);
                                        strComponent27 = trace112.component1();
                                        strComponent28 = trace112.component2();
                                        FileLog fileLog112 = FileLog.INSTANCE;
                                        String str813 = logger14.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str813, "format(...)");
                                        FileLog.print$default(fileLog112, 3, str813, tag14, str47 + StringUtils.SPACE + strComponent28, null, 16, null);
                                        if (logger14.isDebug()) {
                                            Log.i(tag14 + strComponent27, str47 + StringUtils.SPACE + strComponent28);
                                        }
                                    }
                                }
                                NtCaseBleApi.this.earToCaseMacMap.put(this.$realMac, caseMac);
                                this.label = 6;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass14(NtCaseBleApi.this, this.$realMac, caseMac, this.$callback, null), this) == obj4) {
                                    return obj4;
                                }
                                return Unit.INSTANCE;
                            }
                            if (!z2) {
                                if (numBoxInt == null) {
                                    logger13 = Logger.INSTANCE;
                                    str43 = this.$realMac;
                                    tag13 = logger13.getTAG();
                                    depth13 = logger13.getDepth();
                                    if (!logger13.isCanLogger(true)) {
                                        str44 = "[CaseBle][NtCaseBleApi] existing connector is stale state=" + numBoxInt + " realMac=" + str43 + " caseMac=" + caseMac + ", recreate connector before reconnect";
                                        str45 = str44;
                                        if (str45 != null) {
                                            Pair<String, String> trace113 = logger13.getTrace(depth13);
                                            strComponent25 = trace113.component1();
                                            strComponent26 = trace113.component2();
                                            FileLog fileLog113 = FileLog.INSTANCE;
                                            String str814 = logger13.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str814, "format(...)");
                                            FileLog.print$default(fileLog113, 6, str814, tag13, str44 + StringUtils.SPACE + strComponent26, null, 16, null);
                                            if (logger13.isDebug()) {
                                                Log.e(tag13 + strComponent25, str44 + StringUtils.SPACE + strComponent26);
                                            }
                                        }
                                    }
                                    NtCaseBleApi.this.clearBindingForEar(this.$realMac, "stale connector state=" + numBoxInt + " before reconnect");
                                }
                                if (numBoxInt != null) {
                                    logger13 = Logger.INSTANCE;
                                    str43 = this.$realMac;
                                    tag13 = logger13.getTAG();
                                    depth13 = logger13.getDepth();
                                    if (!logger13.isCanLogger(true)) {
                                        str44 = "[CaseBle][NtCaseBleApi] existing connector is stale state=" + numBoxInt + " realMac=" + str43 + " caseMac=" + caseMac + ", recreate connector before reconnect";
                                        str45 = str44;
                                        if (str45 != null) {
                                            Pair<String, String> trace114 = logger13.getTrace(depth13);
                                            strComponent25 = trace114.component1();
                                            strComponent26 = trace114.component2();
                                            FileLog fileLog114 = FileLog.INSTANCE;
                                            String str815 = logger13.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str815, "format(...)");
                                            FileLog.print$default(fileLog114, 6, str815, tag13, str44 + StringUtils.SPACE + strComponent26, null, 16, null);
                                            if (logger13.isDebug()) {
                                                Log.e(tag13 + strComponent25, str44 + StringUtils.SPACE + strComponent26);
                                            }
                                        }
                                    }
                                    NtCaseBleApi.this.clearBindingForEar(this.$realMac, "stale connector state=" + numBoxInt + " before reconnect");
                                }
                            }
                            if (!z2) {
                                NtCaseBleApi.this.connectStartAtMap.putIfAbsent(this.$realMac, Boxing.boxLong(System.currentTimeMillis()));
                                decisionDecideForCurrentState = CaseBleConnectGuard.INSTANCE.decideForCurrentState(numBoxInt, (Long) NtCaseBleApi.this.connectStartAtMap.get(this.$realMac), System.currentTimeMillis(), NtCaseBleApi.this.staleConnectingTimeoutMs);
                                if (decisionDecideForCurrentState.isStaleConnecting()) {
                                    logger12 = Logger.INSTANCE;
                                    str40 = this.$realMac;
                                    tag12 = logger12.getTAG();
                                    depth12 = logger12.getDepth();
                                    if (logger12.isCanLogger(true)) {
                                        decision = decisionDecideForCurrentState;
                                        str41 = str8;
                                    } else {
                                        long elapsedMs2 = decisionDecideForCurrentState.getElapsedMs();
                                        String reason2 = decisionDecideForCurrentState.getReason();
                                        decision = decisionDecideForCurrentState;
                                        StringBuilder sbAppend2 = new StringBuilder("[CaseBle][NtCaseBleApi] connecting seems stale realMac=").append(str40).append(" caseMac=").append(caseMac).append(" elapsed=").append(elapsedMs2);
                                        str41 = str8;
                                        string = sbAppend2.append(str41).append(reason2).append(", force clear and reconnect").toString();
                                        str42 = string;
                                        if (str42 != null) {
                                            Pair<String, String> trace115 = logger12.getTrace(depth12);
                                            strComponent23 = trace115.component1();
                                            strComponent24 = trace115.component2();
                                            FileLog fileLog115 = FileLog.INSTANCE;
                                            String str816 = logger12.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str816, "format(...)");
                                            FileLog.print$default(fileLog115, 6, str816, tag12, string + StringUtils.SPACE + strComponent24, null, 16, null);
                                            if (logger12.isDebug()) {
                                                Log.e(tag12 + strComponent23, string + StringUtils.SPACE + strComponent24);
                                            }
                                        }
                                    }
                                    NtCaseBleApi.this.clearBindingForEar(this.$realMac, "stale connecting elapsed=" + decision.getElapsedMs() + str41 + decision.getReason());
                                } else {
                                    str36 = str8;
                                    logger11 = Logger.INSTANCE;
                                    str37 = this.$realMac;
                                    tag11 = logger11.getTAG();
                                    depth11 = logger11.getDepth();
                                    if (!logger11.isCanLogger(true)) {
                                        str38 = "[CaseBle][NtCaseBleApi] already connecting realMac=" + str37 + " caseMac=" + caseMac + " elapsed=" + decisionDecideForCurrentState.getElapsedMs() + str36 + decisionDecideForCurrentState.getReason() + ", skip duplicate connect";
                                        str39 = str38;
                                        if (str39 != null) {
                                            Pair<String, String> trace116 = logger11.getTrace(depth11);
                                            strComponent21 = trace116.component1();
                                            strComponent22 = trace116.component2();
                                            FileLog fileLog116 = FileLog.INSTANCE;
                                            String str817 = logger11.getSdf().format(new Date());
                                            Intrinsics.checkNotNullExpressionValue(str817, "format(...)");
                                            FileLog.print$default(fileLog116, 3, str817, tag11, str38 + StringUtils.SPACE + strComponent22, null, 16, null);
                                            if (logger11.isDebug()) {
                                                Log.i(tag11 + strComponent21, str38 + StringUtils.SPACE + strComponent22);
                                            }
                                        }
                                    }
                                    NtCaseBleApi.this.earToCaseMacMap.put(this.$realMac, caseMac);
                                    this.label = 7;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass18(this.$callback, null), this) == obj4) {
                                        return obj4;
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                            NtCaseBleApi.this.earToCaseMacMap.put(this.$realMac, caseMac);
                            logger3 = Logger.INSTANCE;
                            tag3 = logger3.getTAG();
                            depth3 = logger3.getDepth();
                            if (!logger3.isCanLogger(true)) {
                                str12 = "[CaseBle][NtCaseBleApi] case found caseMac=" + caseMac + ", earToCaseMacMap saved, getting device";
                                str13 = str12;
                                if (str13 != null) {
                                    Pair<String, String> trace117 = logger3.getTrace(depth3);
                                    strComponent5 = trace117.component1();
                                    strComponent6 = trace117.component2();
                                    FileLog fileLog117 = FileLog.INSTANCE;
                                    String str818 = logger3.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str818, "format(...)");
                                    FileLog.print$default(fileLog117, 3, str818, tag3, str12 + StringUtils.SPACE + strComponent6, null, 16, null);
                                    if (logger3.isDebug()) {
                                        Log.i(tag3 + strComponent5, str12 + StringUtils.SPACE + strComponent6);
                                    }
                                }
                            }
                            device = XBluetoothManager.INSTANCE.get().getDevice(caseMac);
                            deviceAddress = device.getXBluetoothDevice().getDeviceAddress();
                            ntCaseBleApi = NtCaseBleApi.this;
                            if (deviceAddress == null) {
                                str14 = "";
                            } else {
                                str14 = deviceAddress;
                            }
                            if (!Intrinsics.areEqual(ntCaseBleApi.normalizeMac(str14), NtCaseBleApi.this.normalizeMac(caseMac))) {
                                logger10 = Logger.INSTANCE;
                                tag10 = logger10.getTAG();
                                depth10 = logger10.getDepth();
                                if (!logger10.isCanLogger(true)) {
                                    str34 = "[CaseBle][NtCaseBleApi] getDevice returned wrong device: address=" + deviceAddress + " expected caseMac=" + caseMac + ", skip to avoid binding to earphone";
                                    str35 = str34;
                                    if (str35 != null) {
                                        Pair<String, String> trace118 = logger10.getTrace(depth10);
                                        strComponent19 = trace118.component1();
                                        strComponent20 = trace118.component2();
                                        FileLog fileLog118 = FileLog.INSTANCE;
                                        String str819 = logger10.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str819, "format(...)");
                                        FileLog.print$default(fileLog118, 6, str819, tag10, str34 + StringUtils.SPACE + strComponent20, null, 16, null);
                                        if (logger10.isDebug()) {
                                            Log.e(tag10 + strComponent19, str34 + StringUtils.SPACE + strComponent20);
                                        }
                                    }
                                }
                                this.label = 8;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass21(this.$callback, caseMac, null), this) == obj4) {
                                    return obj4;
                                }
                                return Unit.INSTANCE;
                            }
                            logger4 = Logger.INSTANCE;
                            tag4 = logger4.getTAG();
                            depth4 = logger4.getDepth();
                            if (!logger4.isCanLogger(true)) {
                                str15 = "[CaseBle][NtCaseBleApi] device obtained, xBluetoothDevice=" + deviceAddress + " (case, not ear)";
                                str16 = str15;
                                if (str16 != null) {
                                    Pair<String, String> trace119 = logger4.getTrace(depth4);
                                    strComponent7 = trace119.component1();
                                    strComponent8 = trace119.component2();
                                    FileLog fileLog119 = FileLog.INSTANCE;
                                    String str910 = logger4.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str910, "format(...)");
                                    FileLog.print$default(fileLog119, 3, str910, tag4, str15 + StringUtils.SPACE + strComponent8, null, 16, null);
                                    if (logger4.isDebug()) {
                                        Log.i(tag4 + strComponent7, str15 + StringUtils.SPACE + strComponent8);
                                    }
                                }
                            }
                            zContainsKey = NtCaseBleApi.this.connectorMap.containsKey(this.$realMac);
                            concurrentHashMap = NtCaseBleApi.this.connectorMap;
                            str17 = this.$realMac;
                            obj5 = concurrentHashMap.get(str17);
                            if (obj5 == null) {
                                logger9 = Logger.INSTANCE;
                                tag9 = logger9.getTAG();
                                depth9 = logger9.getDepth();
                                if (!logger9.isCanLogger(true)) {
                                    str32 = "[CaseBle][NtCaseBleApi] create new XCaseBleConnector for realMac=" + str17 + " caseMac=" + caseMac;
                                    str33 = str32;
                                    if (str33 != null) {
                                        Pair<String, String> trace27 = logger9.getTrace(depth9);
                                        strComponent17 = trace27.component1();
                                        strComponent18 = trace27.component2();
                                        FileLog fileLog27 = FileLog.INSTANCE;
                                        String str911 = logger9.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str911, "format(...)");
                                        FileLog.print$default(fileLog27, 3, str911, tag9, str32 + StringUtils.SPACE + strComponent18, null, 16, null);
                                        if (logger9.isDebug()) {
                                            Log.i(tag9 + strComponent17, str32 + StringUtils.SPACE + strComponent18);
                                        }
                                    }
                                }
                                xCaseBleConnector2 = new XCaseBleConnector(new XCaseBleParser(), "CaseBle_" + str17);
                                xCaseBleConnector2.onCreate(device.getXBluetoothDevice());
                                objPutIfAbsent = concurrentHashMap.putIfAbsent(str17, xCaseBleConnector2);
                                if (objPutIfAbsent == null) {
                                    obj5 = xCaseBleConnector2;
                                } else {
                                    obj5 = objPutIfAbsent;
                                }
                            }
                            XCaseBleConnector xCaseBleConnector6 = (XCaseBleConnector) obj5;
                            if (zContainsKey) {
                                logger8 = Logger.INSTANCE;
                                str29 = this.$realMac;
                                tag8 = logger8.getTAG();
                                depth8 = logger8.getDepth();
                                if (!logger8.isCanLogger(true)) {
                                    str30 = "[CaseBle][NtCaseBleApi] reuse existing connector realMac=" + str29;
                                    str31 = str30;
                                    if (str31 != null) {
                                        Pair<String, String> trace28 = logger8.getTrace(depth8);
                                        strComponent15 = trace28.component1();
                                        strComponent16 = trace28.component2();
                                        FileLog fileLog28 = FileLog.INSTANCE;
                                        String str912 = logger8.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str912, "format(...)");
                                        FileLog.print$default(fileLog28, 3, str912, tag8, str30 + StringUtils.SPACE + strComponent16, null, 16, null);
                                        if (logger8.isDebug()) {
                                            Log.i(tag8 + strComponent15, str30 + StringUtils.SPACE + strComponent16);
                                        }
                                    }
                                }
                            }
                            xCaseBleConnector6.setUuids(this.$serviceUuid, this.$writeUuid, this.$notifyUuid);
                            logger5 = Logger.INSTANCE;
                            str18 = this.$serviceUuid;
                            str19 = this.$writeUuid;
                            str20 = this.$notifyUuid;
                            tag5 = logger5.getTAG();
                            depth5 = logger5.getDepth();
                            if (!logger5.isCanLogger(true)) {
                                str21 = "[CaseBle][NtCaseBleApi] setUuids done serviceUuid=" + str18 + " writeUuid=" + str19 + " notifyUuid=" + str20;
                                str22 = str21;
                                if (str22 != null) {
                                    Pair<String, String> trace29 = logger5.getTrace(depth5);
                                    strComponent9 = trace29.component1();
                                    strComponent10 = trace29.component2();
                                    FileLog fileLog29 = FileLog.INSTANCE;
                                    String str913 = logger5.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str913, "format(...)");
                                    FileLog.print$default(fileLog29, 3, str913, tag5, str21 + StringUtils.SPACE + strComponent10, null, 16, null);
                                    if (logger5.isDebug()) {
                                        Log.i(tag5 + strComponent9, str21 + StringUtils.SPACE + strComponent10);
                                    }
                                }
                            }
                            String str914 = NtCaseBleApi.this.receiveCallbackKey;
                            final String str915 = this.$realMac;
                            final NtCaseBleApi ntCaseBleApi4 = NtCaseBleApi.this;
                            xCaseBleConnector6.setMessageReceiveCallback(str914, new Function1() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj8) {
                                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$23(str915, ntCaseBleApi4, (XCommand) obj8);
                                }
                            });
                            String str916 = NtCaseBleApi.this.connectCallbackKey;
                            final NtCaseBleApi ntCaseBleApi5 = NtCaseBleApi.this;
                            final String str917 = this.$realMac;
                            xCaseBleConnector6.setDeviceConnectCallback(str916, new Function2() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj8, Object obj9) {
                                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$26(ntCaseBleApi5, str917, caseMac, ((Integer) obj8).intValue(), (XConnectFailType) obj9);
                                }
                            });
                            deviceAddress2 = device.getXBluetoothDevice().getDeviceAddress();
                            logger6 = Logger.INSTANCE;
                            str23 = this.$realMac;
                            tag6 = logger6.getTAG();
                            depth6 = logger6.getDepth();
                            if (!logger6.isCanLogger(true)) {
                                str24 = "[CaseBle][NtCaseBleApi] about to connector.connect() ear(realMac)=" + str23 + " -> case(caseMac)=" + caseMac + " connectorTarget=" + deviceAddress2 + " isForceConnectRelation=false(standalone)";
                                str25 = str24;
                                if (str25 != null) {
                                    Pair<String, String> trace210 = logger6.getTrace(depth6);
                                    strComponent11 = trace210.component1();
                                    strComponent12 = trace210.component2();
                                    FileLog fileLog210 = FileLog.INSTANCE;
                                    String str918 = logger6.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str918, "format(...)");
                                    FileLog.print$default(fileLog210, 3, str918, tag6, str24 + StringUtils.SPACE + strComponent12, null, 16, null);
                                    if (logger6.isDebug()) {
                                        Log.i(tag6 + strComponent11, str24 + StringUtils.SPACE + strComponent12);
                                    }
                                }
                            }
                            NtCaseBleApi.this.connectStartAtMap.put(this.$realMac, Boxing.boxLong(System.currentTimeMillis()));
                            final String str919 = this.$realMac;
                            XConnector.connect$default(xCaseBleConnector6, null, null, null, null, false, false, false, 0, false, new Function1() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj8) {
                                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$34(str919, caseMac, (XConnectCallback) obj8);
                                }
                            }, null, 1519, null);
                            logger7 = Logger.INSTANCE;
                            str26 = this.$realMac;
                            tag7 = logger7.getTAG();
                            depth7 = logger7.getDepth();
                            if (!logger7.isCanLogger(true)) {
                                str27 = "[CaseBle][NtCaseBleApi] connect flow done (async connect started), callback.success realMac=" + str26;
                                str28 = str27;
                                if (str28 != null) {
                                    Pair<String, String> trace211 = logger7.getTrace(depth7);
                                    strComponent13 = trace211.component1();
                                    strComponent14 = trace211.component2();
                                    FileLog fileLog211 = FileLog.INSTANCE;
                                    String str101 = logger7.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str101, "format(...)");
                                    FileLog.print$default(fileLog211, 3, str101, tag7, str27 + StringUtils.SPACE + strComponent14, null, 16, null);
                                    if (logger7.isDebug()) {
                                        Log.i(tag7 + strComponent13, str27 + StringUtils.SPACE + strComponent14);
                                    }
                                }
                            }
                            this.label = 9;
                            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass30(this.$callback, null), this) == obj4) {
                                return obj4;
                            }
                            return Unit.INSTANCE;
                        case 4:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 5:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 6:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 7:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 8:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 9:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 10:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } catch (Exception e5) {
                    e = e5;
                    obj6 = coroutine_suspended;
                }
            } catch (Exception e6) {
                e = e6;
            }
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$2", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01132 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $cachedCaseMac;
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ String $realMac;
            int label;
            final /* synthetic */ NtCaseBleApi this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01132(String str, NtCaseBleApi ntCaseBleApi, String str2, Function1<? super Result<Unit>, Unit> function1, Continuation<? super C01132> continuation) {
                super(2, continuation);
                this.$cachedCaseMac = str;
                this.this$0 = ntCaseBleApi;
                this.$realMac = str2;
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01132(this.$cachedCaseMac, this.this$0, this.$realMac, this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01132) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                String str = this.$cachedCaseMac;
                if (str != null && str.length() != 0) {
                    this.this$0.flutterApi.onCaseBleConnectionStateChanged(this.$realMac, NtCaseBleConnectionState.CONNECTED, this.$cachedCaseMac, new Function1() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$2$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return NtCaseBleApi.AnonymousClass2.C01132.invokeSuspend$lambda$0((Result) obj2);
                        }
                    });
                }
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

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$4", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$8, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$8", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass8(Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass8> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass8(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$10, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$10", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ String $realMac;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass10(Function1<? super Result<Unit>, Unit> function1, String str, Continuation<? super AnonymousClass10> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$realMac = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass10(this.$callback, this.$realMac, continuation);
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
                Function1<Result<Unit>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Case box not found for ear: " + this.$realMac)))));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$14, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$14", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass14 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ String $caseMac;
            final /* synthetic */ String $realMac;
            int label;
            final /* synthetic */ NtCaseBleApi this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass14(NtCaseBleApi ntCaseBleApi, String str, String str2, Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass14> continuation) {
                super(2, continuation);
                this.this$0 = ntCaseBleApi;
                this.$realMac = str;
                this.$caseMac = str2;
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass14(this.this$0, this.$realMac, this.$caseMac, this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass14) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.flutterApi.onCaseBleConnectionStateChanged(this.$realMac, NtCaseBleConnectionState.CONNECTED, this.$caseMac, new Function1() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$14$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtCaseBleApi.AnonymousClass2.AnonymousClass14.invokeSuspend$lambda$0((Result) obj2);
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

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$18, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$18", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass18 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass18(Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass18> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass18(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass18) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$21, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$21", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass21 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ String $caseMac;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass21(Function1<? super Result<Unit>, Unit> function1, String str, Continuation<? super AnonymousClass21> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$caseMac = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass21(this.$callback, this.$caseMac, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass21) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Device address mismatch for case: " + this.$caseMac)))));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$23(String str, NtCaseBleApi ntCaseBleApi, XCommand xCommand) {
            byte[] data;
            if (xCommand != null && (data = xCommand.getData()) != null) {
                ArrayList arrayList = new ArrayList(data.length);
                for (byte b : data) {
                    arrayList.add(Long.valueOf(b & 255));
                }
                ArrayList arrayList2 = arrayList;
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str2 = "[CaseBle][NtCaseBleApi] onDataReceived realMac=" + str + " len=" + data.length + " command=" + ntCaseBleApi.extractCommandHex(data) + " hex=" + ntCaseBleApi.bytesToHex(data);
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
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new NtCaseBleApi$connect$2$25$1$2(ntCaseBleApi, str, arrayList2, null), 2, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:36:0x018f  */
        public static final Unit invokeSuspend$lambda$26(NtCaseBleApi ntCaseBleApi, String str, String str2, int i, XConnectFailType xConnectFailType) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str3 = "[CaseBle][NtCaseBleApi] connectionStateChanged realMac=" + str + " caseMac=" + str2 + " state=" + i;
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
            if (i == 0 || i == 4) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str6 = "[CaseBle][NtCaseBleApi] case BLE state=" + i + " (disconnected/failed), may be disconnected by SDK/system";
                    String str7 = str6;
                    if (str7 != null && str7.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str8 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                        FileLog.print$default(fileLog2, 6, str8, tag2, str6 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.e(tag2 + strComponent3, str6 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
            }
            if (i == -1 || i == 0) {
                ntCaseBleApi.connectStartAtMap.remove(str);
            } else if (i == 1) {
                ntCaseBleApi.connectStartAtMap.putIfAbsent(str, Long.valueOf(System.currentTimeMillis()));
            } else if (i == 4) {
                ntCaseBleApi.connectStartAtMap.remove(str);
            }
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new NtCaseBleApi$connect$2$26$3(ntCaseBleApi, str, ntCaseBleApi.toPigeonState(i), (String) ntCaseBleApi.earToCaseMacMap.get(str), null), 2, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$34(final String str, final String str2, XConnectCallback xConnectCallback) {
            xConnectCallback.onConnectSuccess(new Function2() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$34$lambda$29(str, str2, (XConnectType) obj, (XBluetoothDevice) obj2);
                }
            });
            xConnectCallback.onConnectFail(new Function2() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$34$lambda$31(str, str2, (XBluetoothDevice) obj, (XConnectFailType) obj2);
                }
            });
            xConnectCallback.onDisConnected(new Function4() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return NtCaseBleApi.AnonymousClass2.invokeSuspend$lambda$34$lambda$33(str, str2, ((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$34$lambda$29(String str, String str2, XConnectType xConnectType, XBluetoothDevice xBluetoothDevice) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str3 = "[CaseBle][NtCaseBleApi] onConnectSuccess realMac=" + str + " caseMac=" + str2;
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
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$34$lambda$31(String str, String str2, XBluetoothDevice xBluetoothDevice, XConnectFailType xConnectFailType) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str3 = "[CaseBle][NtCaseBleApi] onConnectFail realMac=" + str + " caseMac=" + str2;
                String str4 = str3;
                if (str4 != null && str4.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str5 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    FileLog.print$default(fileLog, 6, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$34$lambda$33(String str, String str2, boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str3 = "[CaseBle][NtCaseBleApi] onDisConnected realMac=" + str + " caseMac=" + str2 + " (case BLE disconnected, check SDK relation or system)";
                String str4 = str3;
                if (str4 != null && str4.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str5 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    FileLog.print$default(fileLog, 6, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$30, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$30", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass30 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass30(Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass30> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass30(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass30) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$connect$2$32, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$32", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass32 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ Exception $e;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass32(Function1<? super Result<Unit>, Unit> function1, Exception exc, Continuation<? super AnonymousClass32> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass32(this.$callback, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass32) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

    static /* synthetic */ Object findCaseMacForEar$default(NtCaseBleApi ntCaseBleApi, String str, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 15000;
        }
        return ntCaseBleApi.findCaseMacForEar(str, j, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.nothing.caseble.NtCaseBleApi$findCaseMacForEar$2$callback$1] */
    public final Object findCaseMacForEar(String str, long j, Continuation<? super CaseMatch> continuation) {
        BluetoothAdapter defaultAdapter;
        final BluetoothLeScanner bluetoothLeScanner;
        final String strNormalizeMac = normalizeMac(str);
        if (strNormalizeMac.length() == 0 || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null || !defaultAdapter.isEnabled() || (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) == null) {
            return null;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).build();
        final ?? r9 = new ScanCallback() { // from class: com.nothing.caseble.NtCaseBleApi$findCaseMacForEar$2$callback$1
            /* JADX WARN: Code duplicated, block: B:58:0x02b8  */
            @Override // android.bluetooth.le.ScanCallback
            public void onScanResult(int callbackType, ScanResult result) {
                ScanRecord scanRecord;
                SparseArray<byte[]> sparseArray;
                if (result == null || (scanRecord = result.getScanRecord()) == null) {
                    return;
                }
                SparseArray<byte[]> manufacturerSpecificData = scanRecord.getManufacturerSpecificData();
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    Intrinsics.checkNotNull(manufacturerSpecificData);
                    String str2 = "[CaseBle][findCaseMacForEar] manufacturerData size=" + manufacturerSpecificData.size() + ", device=" + result.getDevice().getAddress();
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
                Intrinsics.checkNotNull(manufacturerSpecificData);
                int size = manufacturerSpecificData.size();
                int i = 0;
                while (i < size) {
                    int iKeyAt = manufacturerSpecificData.keyAt(i);
                    byte[] bArr = manufacturerSpecificData.get(iKeyAt);
                    if (bArr == null) {
                        sparseArray = manufacturerSpecificData;
                    } else {
                        String strBytesToHex = this.this$0.bytesToHex(bArr);
                        Logger logger2 = Logger.INSTANCE;
                        String tag2 = logger2.getTAG();
                        int depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true)) {
                            String str5 = "[CaseBle][findCaseMacForEar] manufacturerData id=0x" + Integer.toHexString(iKeyAt) + ", hex=" + strBytesToHex + ", len=" + bArr.length;
                            String str6 = str5;
                            if (str6 != null && str6.length() != 0) {
                                Pair<String, String> trace2 = logger2.getTrace(depth2);
                                String strComponent3 = trace2.component1();
                                String strComponent4 = trace2.component2();
                                FileLog fileLog2 = FileLog.INSTANCE;
                                String str7 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                FileLog.print$default(fileLog2, 3, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                                }
                            }
                        }
                        Bundle rVar = new NothingCaseParser().parser(strBytesToHex, iKeyAt, result);
                        if (rVar == null) {
                            Logger logger3 = Logger.INSTANCE;
                            String tag3 = logger3.getTAG();
                            int depth3 = logger3.getDepth();
                            if (logger3.isCanLogger(true)) {
                                String str8 = "[CaseBle][findCaseMacForEar] parser returned null (id=0x" + Integer.toHexString(iKeyAt) + ", hexLen=" + strBytesToHex.length() + ")";
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
                            sparseArray = manufacturerSpecificData;
                        } else {
                            int i2 = rVar.getInt(NothingCaseParser.KEY_DEVICE_TYPE, 0);
                            String string = rVar.getString(NothingCaseParser.KEY_PAIRED_EARPHONE_MAC);
                            if (string == null) {
                                string = "";
                            }
                            String string2 = rVar.getString("device_address");
                            String str11 = string2 != null ? string2 : "";
                            Logger logger4 = Logger.INSTANCE;
                            String str12 = strNormalizeMac;
                            String tag4 = logger4.getTAG();
                            int depth4 = logger4.getDepth();
                            if (logger4.isCanLogger(true)) {
                                String str13 = "[CaseBle][findCaseMacForEar] parsed deviceType=0x" + Integer.toHexString(i2) + ", pairedMac=" + string + ", caseMac=" + str11 + ", targetEar=" + str12;
                                String str14 = str13;
                                if (str14 == null || str14.length() == 0) {
                                    sparseArray = manufacturerSpecificData;
                                } else {
                                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                                    String strComponent7 = trace4.component1();
                                    String strComponent8 = trace4.component2();
                                    FileLog fileLog4 = FileLog.INSTANCE;
                                    sparseArray = manufacturerSpecificData;
                                    String str15 = logger4.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                                    FileLog.print$default(fileLog4, 3, str15, tag4, str13 + StringUtils.SPACE + strComponent8, null, 16, null);
                                    if (logger4.isDebug()) {
                                        Log.i(tag4 + strComponent7, str13 + StringUtils.SPACE + strComponent8);
                                    }
                                }
                            } else {
                                sparseArray = manufacturerSpecificData;
                            }
                            if (i2 != 1) {
                                continue;
                            } else if (Intrinsics.areEqual(this.this$0.normalizeMac(string), strNormalizeMac) && str11.length() != 0) {
                                Logger logger5 = Logger.INSTANCE;
                                String str16 = strNormalizeMac;
                                String tag5 = logger5.getTAG();
                                int depth5 = logger5.getDepth();
                                if (logger5.isCanLogger(true)) {
                                    String str17 = "[CaseBle][findCaseMacForEar] match found caseMac=" + str11 + " for ear=" + str16;
                                    String str18 = str17;
                                    if (str18 != null && str18.length() != 0) {
                                        Pair<String, String> trace5 = logger5.getTrace(depth5);
                                        String strComponent9 = trace5.component1();
                                        String strComponent10 = trace5.component2();
                                        FileLog fileLog5 = FileLog.INSTANCE;
                                        String str19 = logger5.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str19, "format(...)");
                                        FileLog.print$default(fileLog5, 3, str19, tag5, str17 + StringUtils.SPACE + strComponent10, null, 16, null);
                                        if (logger5.isDebug()) {
                                            Log.i(tag5 + strComponent9, str17 + StringUtils.SPACE + strComponent10);
                                        }
                                    }
                                }
                                bluetoothLeScanner.stopScan(this);
                                if (cancellableContinuationImpl2.isCompleted()) {
                                    return;
                                }
                                CancellableContinuation<CaseMatch> cancellableContinuation = cancellableContinuationImpl2;
                                Locale locale = Locale.getDefault();
                                Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
                                String upperCase = str11.toUpperCase(locale);
                                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                                CaseMatch caseMatch = new CaseMatch(upperCase, result);
                                Result.Companion companion = Result.INSTANCE;
                                cancellableContinuation.resumeWith(Result.m6347constructorimpl(caseMatch));
                                return;
                            }
                        }
                    }
                    i++;
                    manufacturerSpecificData = sparseArray;
                }
            }

            @Override // android.bluetooth.le.ScanCallback
            public void onScanFailed(int errorCode) {
                bluetoothLeScanner.stopScan(this);
                if (cancellableContinuationImpl2.isCompleted()) {
                    return;
                }
                CancellableContinuation<CaseMatch> cancellableContinuation = cancellableContinuationImpl2;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m6347constructorimpl(null));
            }
        };
        bluetoothLeScanner.startScan((List<ScanFilter>) null, scanSettingsBuild, (ScanCallback) r9);
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new NtCaseBleApi$findCaseMacForEar$2$1(j, cancellableContinuationImpl2, bluetoothLeScanner, r9, null), 3, null);
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.nothing.caseble.NtCaseBleApi$findCaseMacForEar$2$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                bluetoothLeScanner.stopScan(r9);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String normalizeMac(String mac) {
        String strReplace$default = StringsKt.replace$default(mac, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = strReplace$default.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public static /* synthetic */ void clearBindingForEar$default(NtCaseBleApi ntCaseBleApi, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "manual clear";
        }
        ntCaseBleApi.clearBindingForEar(str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:4:0x003c  */
    public final void clearBindingForEar(String realMac, String reason) {
        String str;
        Object objM6347constructorimpl;
        XCaseBleConnector xCaseBleConnector;
        Object objM6347constructorimpl2;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(reason, "reason");
        String strRemove = this.earToCaseMacMap.remove(realMac);
        this.connectStartAtMap.remove(realMac);
        XCaseBleConnector xCaseBleConnectorRemove = this.connectorMap.remove(realMac);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "[CaseBle][NtCaseBleApi] clearBindingForEar realMac=" + realMac + " caseMac=" + strRemove + " hasConnector=" + (xCaseBleConnectorRemove != null) + " reason=" + reason;
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                str = StringUtils.SPACE;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                String str5 = str2 + StringUtils.SPACE + strComponent2;
                str = StringUtils.SPACE;
                FileLog.print$default(fileLog, 3, str4, tag, str5, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + str + strComponent2);
                }
            }
        } else {
            str = StringUtils.SPACE;
        }
        if (xCaseBleConnectorRemove != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                NtCaseBleApi ntCaseBleApi = this;
                objM6347constructorimpl = Result.m6347constructorimpl(BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new NtCaseBleApi$clearBindingForEar$2$1$1(xCaseBleConnectorRemove, null), 3, null));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
            if (thM6350exceptionOrNullimpl != null) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str6 = "[CaseBle][NtCaseBleApi] clearBindingForEar disconnect error realMac=" + realMac + " error=" + thM6350exceptionOrNullimpl.getMessage();
                    String str7 = str6;
                    if (str7 == null || str7.length() == 0) {
                        xCaseBleConnector = xCaseBleConnectorRemove;
                    } else {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str8 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                        xCaseBleConnector = xCaseBleConnectorRemove;
                        FileLog.print$default(fileLog2, 6, str8, tag2, str6 + str + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.e(tag2 + strComponent3, str6 + str + strComponent4);
                        }
                    }
                } else {
                    xCaseBleConnector = xCaseBleConnectorRemove;
                }
            } else {
                xCaseBleConnector = xCaseBleConnectorRemove;
            }
            try {
                Result.Companion companion3 = Result.INSTANCE;
                NtCaseBleApi ntCaseBleApi2 = this;
                xCaseBleConnector.onDestroy();
                objM6347constructorimpl2 = Result.m6347constructorimpl(Unit.INSTANCE);
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objM6347constructorimpl2 = Result.m6347constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable thM6350exceptionOrNullimpl2 = Result.m6350exceptionOrNullimpl(objM6347constructorimpl2);
            if (thM6350exceptionOrNullimpl2 != null) {
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str9 = "[CaseBle][NtCaseBleApi] clearBindingForEar onDestroy error realMac=" + realMac + " error=" + thM6350exceptionOrNullimpl2.getMessage();
                    String str10 = str9;
                    if (str10 != null && str10.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str11 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                        FileLog.print$default(fileLog3, 6, str11, tag3, str9 + str + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.e(tag3 + strComponent5, str9 + str + strComponent6);
                        }
                    }
                }
            }
            Result.m6346boximpl(objM6347constructorimpl2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String string = Integer.toString(b & 255, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            sb.append(StringsKt.padStart(string, 2, '0'));
        }
        String string2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String extractCommandHex(byte[] bytes) {
        if (bytes.length < 5) {
            return "0x----";
        }
        String string = Integer.toString(((bytes[4] & 255) << 8) | (bytes[3] & 255), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        String strPadStart = StringsKt.padStart(string, 4, '0');
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = strPadStart.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return "0x" + upperCase;
    }

    /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$disconnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: NtCaseBleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$disconnect$1", f = "NtCaseBleApi.kt", i = {}, l = {TypedValues.CycleType.TYPE_EASING, TypedValues.CycleType.TYPE_WAVE_OFFSET}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
        final /* synthetic */ String $realMac;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$realMac = str;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtCaseBleApi.this.new AnonymousClass1(this.$realMac, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x00f5, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.caseble.NtCaseBleApi.AnonymousClass1.AnonymousClass2(r18.$callback, null), r18) == r3) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0111, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.caseble.NtCaseBleApi.AnonymousClass1.AnonymousClass3(r18.$callback, r0, null), r18) == r3) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0113, code lost:
        
            return r3;
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
                    Logger logger = Logger.INSTANCE;
                    String str = this.$realMac;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str2 = "[CaseBle][NtCaseBleApi] disconnect realMac=" + str;
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
                    NtCaseBleApi.this.clearBindingForEar(this.$realMac, "host disconnect");
                    this.label = 1;
                } else {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                this.label = 2;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$disconnect$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$disconnect$1$2", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function1<? super Result<Unit>, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$disconnect$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$disconnect$1$3", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ Exception $e;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(Function1<? super Result<Unit>, Unit> function1, Exception exc, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$callback, this.$e, continuation);
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
                Function1<Result<Unit>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(this.$e))));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.generate.NtCaseBleHostApi
    public void disconnect(String realMac, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass1(realMac, callback, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0042  */
    @Override // com.nothing.generate.NtCaseBleHostApi
    public void sendData(String realMac, List<Long> data, Function1<? super Result<Unit>, Unit> callback) {
        String str;
        String str2;
        String str3;
        XCaseBleConnector xCaseBleConnector;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String str4 = this.earToCaseMacMap.get(realMac);
        XCaseBleConnector xCaseBleConnector2 = this.connectorMap.get(realMac);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str5 = "[CaseBle][NtCaseBleApi] sendData start realMac=" + realMac + " caseMac=" + str4 + " len=" + data.size();
            String str6 = str5;
            if (str6 == null || str6.length() == 0) {
                xCaseBleConnector = xCaseBleConnector2;
                str = "format(...)";
                str2 = " caseMac=";
                str3 = StringUtils.SPACE;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str7 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                String str8 = str5 + StringUtils.SPACE + strComponent2;
                str = "format(...)";
                str2 = " caseMac=";
                str3 = StringUtils.SPACE;
                xCaseBleConnector = xCaseBleConnector2;
                FileLog.print$default(fileLog, 3, str7, tag, str8, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str5 + str3 + strComponent2);
                }
            }
        } else {
            xCaseBleConnector = xCaseBleConnector2;
            str = "format(...)";
            str2 = " caseMac=";
            str3 = StringUtils.SPACE;
        }
        if (xCaseBleConnector == null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str9 = "[CaseBle][NtCaseBleApi] sendData connector null realMac=" + realMac + str2 + str4;
                String str10 = str9;
                if (str10 != null && str10.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str11 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str11, str);
                    FileLog.print$default(fileLog2, 6, str11, tag2, str9 + str3 + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.e(tag2 + strComponent3, str9 + str3 + strComponent4);
                    }
                }
            }
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Not connected: " + realMac)))));
            return;
        }
        if (xCaseBleConnector.getLastState().get() != 2) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str12 = "[CaseBle][NtCaseBleApi] sendData not connected realMac=" + realMac + str2 + str4 + " state=" + xCaseBleConnector.getLastState().get();
                String str13 = str12;
                if (str13 != null && str13.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str14 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str14, str);
                    FileLog.print$default(fileLog3, 3, str14, tag3, str12 + str3 + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str12 + str3 + strComponent6);
                    }
                }
            }
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass4(xCaseBleConnector, data, callback, realMac, str4, this, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$sendData$4, reason: invalid class name */
    /* JADX INFO: compiled from: NtCaseBleApi.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$sendData$4", f = "NtCaseBleApi.kt", i = {}, l = {448, 496}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
        final /* synthetic */ String $caseMac;
        final /* synthetic */ XCaseBleConnector $connector;
        final /* synthetic */ List<Long> $data;
        final /* synthetic */ String $realMac;
        int label;
        final /* synthetic */ NtCaseBleApi this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(XCaseBleConnector xCaseBleConnector, List<Long> list, Function1<? super Result<Unit>, Unit> function1, String str, String str2, NtCaseBleApi ntCaseBleApi, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$connector = xCaseBleConnector;
            this.$data = list;
            this.$callback = function1;
            this.$realMac = str;
            this.$caseMac = str2;
            this.this$0 = ntCaseBleApi;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass4(this.$connector, this.$data, this.$callback, this.$realMac, this.$caseMac, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x0278, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.caseble.NtCaseBleApi.AnonymousClass4.AnonymousClass5(r27.$callback, r0, null), r27) == r2) goto L51;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i != 0) {
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                if (this.$connector.getLastState().get() != 2) {
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.$callback, this.$realMac, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                List<Long> list = this.$data;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Boxing.boxByte((byte) (((int) ((Number) it.next()).longValue()) & 255)));
                }
                byte[] byteArray = CollectionsKt.toByteArray(arrayList);
                Logger logger = Logger.INSTANCE;
                String str = this.$realMac;
                String str2 = this.$caseMac;
                NtCaseBleApi ntCaseBleApi = this.this$0;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str3 = "[CaseBle][NtCaseBleApi] sendData bytes realMac=" + str + " caseMac=" + str2 + " len=" + byteArray.length + " command=" + ntCaseBleApi.extractCommandHex(byteArray) + " hex=" + ntCaseBleApi.bytesToHex(byteArray);
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
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                XCaseBleConnector xCaseBleConnector = this.$connector;
                String serviceUUID = xCaseBleConnector.getServiceUUID();
                String writeUUID = this.$connector.getWriteUUID();
                final Function1<Result<Unit>, Unit> function1 = this.$callback;
                final String str6 = this.$realMac;
                final String str7 = this.$caseMac;
                xCaseBleConnector.writeWithTask(byteArray, -1L, -1L, true, true, true, serviceUUID, writeUUID, (byte[]) null, (AtomicInteger) null, true, (String) null, (ArrayList<String>) null, new Function1() { // from class: com.nothing.caseble.NtCaseBleApi$sendData$4$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtCaseBleApi.AnonymousClass4.invokeSuspend$lambda$4(atomicBoolean, function1, str6, str7, (XWriteCallback) obj2);
                    }
                });
                return Unit.INSTANCE;
            } catch (Exception e) {
                Logger logger2 = Logger.INSTANCE;
                String str8 = this.$realMac;
                String str9 = this.$caseMac;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str10 = "[CaseBle][NtCaseBleApi] sendData exception realMac=" + str8 + " caseMac=" + str9 + " error=" + e.getMessage();
                    String str11 = str10;
                    if (str11 != null && str11.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str12 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                        FileLog.print$default(fileLog2, 6, str12, tag2, str10 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.e(tag2 + strComponent3, str10 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                this.label = 2;
            }
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$sendData$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$sendData$4$1", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ String $realMac;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super Result<Unit>, Unit> function1, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$realMac = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$callback, this.$realMac, continuation);
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
                Function1<Result<Unit>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Device not connected: " + this.$realMac)))));
                return Unit.INSTANCE;
            }
        }

        static /* synthetic */ void invokeSuspend$fireCallback$default(AtomicBoolean atomicBoolean, Function1 function1, String str, String str2, boolean z, Throwable th, int i, Object obj) {
            if ((i & 32) != 0) {
                th = null;
            }
            invokeSuspend$fireCallback(atomicBoolean, function1, str, str2, z, th);
        }

        private static final void invokeSuspend$fireCallback(AtomicBoolean atomicBoolean, Function1<? super Result<Unit>, Unit> function1, String str, String str2, boolean z, Throwable th) {
            if (atomicBoolean.compareAndSet(false, true)) {
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new NtCaseBleApi$sendData$4$fireCallback$1(z, function1, th, str, str2, null), 2, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4(final AtomicBoolean atomicBoolean, final Function1 function1, final String str, final String str2, XWriteCallback xWriteCallback) {
            xWriteCallback.onWriteComplete(new Function2() { // from class: com.nothing.caseble.NtCaseBleApi$sendData$4$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NtCaseBleApi.AnonymousClass4.invokeSuspend$lambda$4$lambda$2(atomicBoolean, function1, str, str2, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue());
                }
            });
            xWriteCallback.onWriteFail(new Function4() { // from class: com.nothing.caseble.NtCaseBleApi$sendData$4$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return NtCaseBleApi.AnonymousClass4.invokeSuspend$lambda$4$lambda$3(atomicBoolean, function1, str, str2, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4$lambda$2(AtomicBoolean atomicBoolean, Function1 function1, String str, String str2, XBluetoothDevice xBluetoothDevice, boolean z) {
            invokeSuspend$fireCallback$default(atomicBoolean, function1, str, str2, z, null, 32, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4$lambda$3(AtomicBoolean atomicBoolean, Function1 function1, String str, String str2, XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable th) {
            invokeSuspend$fireCallback(atomicBoolean, function1, str, str2, false, th);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.caseble.NtCaseBleApi$sendData$4$5, reason: invalid class name */
        /* JADX INFO: compiled from: NtCaseBleApi.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$sendData$4$5", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ Exception $e;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass5(Function1<? super Result<Unit>, Unit> function1, Exception exc, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$callback, this.$e, continuation);
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
                Function1<Result<Unit>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(this.$e))));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.generate.NtCaseBleHostApi
    public void connectionState(String realMac, Function1<? super Result<? extends NtCaseBleConnectionState>, Unit> callback) {
        AtomicInteger lastState;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        XCaseBleConnector xCaseBleConnector = this.connectorMap.get(realMac);
        int i = (xCaseBleConnector == null || (lastState = xCaseBleConnector.getLastState()) == null) ? -1 : lastState.get();
        NtCaseBleConnectionState pigeonState = toPigeonState(i);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[CaseBle][NtCaseBleApi] connectionState realMac=" + realMac + " sdkState=" + i + " pigeon=" + pigeonState;
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
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(pigeonState)));
    }

    @Override // com.nothing.generate.NtCaseBleHostApi
    public void gattIdentifier(String realMac, Function1<? super Result<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(null)));
    }

    @Override // com.nothing.generate.NtCaseBleHostApi
    public void linkedCaseMac(String realMac, Function1<? super Result<String>, Unit> callback) {
        String string;
        AtomicInteger lastState;
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        XCaseBleConnector xCaseBleConnector = this.connectorMap.get(realMac);
        boolean z = false;
        if (xCaseBleConnector != null && (lastState = xCaseBleConnector.getLastState()) != null && lastState.get() == 2) {
            z = true;
        }
        String str = this.earToCaseMacMap.get(realMac);
        if (str == null || (string = StringsKt.trim((CharSequence) str).toString()) == null || string.length() <= 0) {
            string = null;
        }
        String str2 = z ? string : null;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str3 = "[CaseBle][NtCaseBleApi] linkedCaseMac realMac=" + realMac + " connected=" + z + " caseMac=" + str2;
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
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(str2)));
    }
}
