package com.nothing.nt_ear_ota;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.media3.extractor.ts.TsExtractor;
import com.bluetrum.fota.abota.ABOta;
import com.fluttercandies.photo_manager.constant.Methods;
import com.nothing.nt_ear_ota.caseble.CaseBleMacUtilsKt;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 82\u00020\u0001:\u000278B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J*\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020!2\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J\u0016\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010#J\u0016\u0010$\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020!H\u0082@\u00a2\u0006\u0002\u0010#J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0010H\u0016J*\u0010'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020(2\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u001e\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J2\u0010)\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020(2 \u0010\u001c\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010+0*0\u001e\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J*\u0010,\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020-2\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J*\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00102\u0018\u0010\u001c\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J,\u00100\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00102\u001a\u0010\u001c\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u001e\u0012\u0004\u0012\u00020\u00190\u001dH\u0016J\u001a\u00101\u001a\u00020\u00192\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0010H\u0002J\u0010\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u000203H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00130\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00150\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/nothing/nt_ear_ota/NtEarOtaHostImpl;", "Lcom/nothing/nt_ear_ota/NtEarOtaNativeHost;", "binaryMessenger", "Lio/flutter/plugin/common/BinaryMessenger;", "<init>", "(Lio/flutter/plugin/common/BinaryMessenger;)V", "flutterCallbacks", "Lcom/nothing/nt_ear_ota/NtEarOtaFlutterCallbacks;", "getFlutterCallbacks", "()Lcom/nothing/nt_ear_ota/NtEarOtaFlutterCallbacks;", "flutterCallbacks$delegate", "Lkotlin/Lazy;", "mainHandler", "Landroid/os/Handler;", "sessionKinds", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/nt_ear_ota/NtEarOtaTransportKind;", "earSessions", "Lcom/nothing/nt_ear_ota/OtaEarLinkSession;", "caseSessions", "Lcom/nothing/nt_ear_ota/NtEarOtaCaseBleSession;", "sdkRuns", "Lcom/nothing/nt_ear_ota/NtEarOtaHostImpl$SdkOtaRun;", "prepareOtaDevice", "", "args", "Lcom/nothing/nt_ear_ota/NtEarOtaPrepareDeviceArgs;", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "", "openTransport", "Lcom/nothing/nt_ear_ota/NtEarOtaTransportOpenArgs;", "openEarTransport", "(Lcom/nothing/nt_ear_ota/NtEarOtaTransportOpenArgs;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openCaseTransport", "closeTransport", "sessionId", "transportWrite", "Lcom/nothing/nt_ear_ota/NtEarOtaTransportWriteArgs;", "syncTransportWrite", "", "", "startSdkOta", "Lcom/nothing/nt_ear_ota/NtEarOtaSdkStartArgs;", "stopSdkOta", "deviceMac", "resolveEarGattIdentifier", "emitSdkFail", "code", "", NotificationCompat.CATEGORY_MESSAGE, "mapAbOtaFail", "errorCode", "SdkOtaRun", "Companion", "nt_ear_ota_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NtEarOtaHostImpl implements NtEarOtaNativeHost {
    private static final String TAG = "NtEarOtaHost";
    private final BinaryMessenger binaryMessenger;
    private final ConcurrentHashMap<String, NtEarOtaCaseBleSession> caseSessions;
    private final ConcurrentHashMap<String, OtaEarLinkSession> earSessions;

    /* JADX INFO: renamed from: flutterCallbacks$delegate, reason: from kotlin metadata */
    private final Lazy flutterCallbacks;
    private final Handler mainHandler;
    private final ConcurrentHashMap<String, SdkOtaRun> sdkRuns;
    private final ConcurrentHashMap<String, NtEarOtaTransportKind> sessionKinds;

    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NtEarOtaTransportKind.values().length];
            try {
                iArr[NtEarOtaTransportKind.EAR_SPP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NtEarOtaTransportKind.EAR_BLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NtEarOtaTransportKind.CASE_BLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NtEarOtaTransportKind.EAR_WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[NtEarOtaTransportKind.CASE_WIFI.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$openCaseTransport$1, reason: invalid class name */
    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl", f = "NtEarOtaHostImpl.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1}, l = {TsExtractor.TS_STREAM_TYPE_DTS_UHD, 176}, m = "openCaseTransport", n = {"this", "args", "caseMac", NotificationCompat.CATEGORY_SERVICE, "write", Methods.notify, "scanMs", "this", "args", "caseMac", "c"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "L$3"})
    static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
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
            return NtEarOtaHostImpl.this.openCaseTransport(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$openEarTransport$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl", f = "NtEarOtaHostImpl.kt", i = {0, 0, 0, 0}, l = {102}, m = "openEarTransport", n = {"this", "args", "spp", "session"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class C09751 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C09751(Continuation<? super C09751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtEarOtaHostImpl.this.openEarTransport(null, this);
        }
    }

    public NtEarOtaHostImpl(BinaryMessenger binaryMessenger) {
        Intrinsics.checkNotNullParameter(binaryMessenger, "binaryMessenger");
        this.binaryMessenger = binaryMessenger;
        this.flutterCallbacks = LazyKt.lazy(new Function0() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NtEarOtaHostImpl.flutterCallbacks_delegate$lambda$0(this.f$0);
            }
        });
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.sessionKinds = new ConcurrentHashMap<>();
        this.earSessions = new ConcurrentHashMap<>();
        this.caseSessions = new ConcurrentHashMap<>();
        this.sdkRuns = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NtEarOtaFlutterCallbacks flutterCallbacks_delegate$lambda$0(NtEarOtaHostImpl ntEarOtaHostImpl) {
        return new NtEarOtaFlutterCallbacks(ntEarOtaHostImpl.binaryMessenger, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final NtEarOtaFlutterCallbacks getFlutterCallbacks() {
        return (NtEarOtaFlutterCallbacks) this.flutterCallbacks.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/nt_ear_ota/NtEarOtaHostImpl$SdkOtaRun;", "", "job", "Lkotlinx/coroutines/Job;", "stop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "(Lkotlinx/coroutines/Job;Ljava/util/concurrent/atomic/AtomicBoolean;)V", "getJob", "()Lkotlinx/coroutines/Job;", "getStop", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "component1", "component2", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "nt_ear_ota_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    static final /* data */ class SdkOtaRun {
        private final Job job;
        private final AtomicBoolean stop;

        public static /* synthetic */ SdkOtaRun copy$default(SdkOtaRun sdkOtaRun, Job job, AtomicBoolean atomicBoolean, int i, Object obj) {
            if ((i & 1) != 0) {
                job = sdkOtaRun.job;
            }
            if ((i & 2) != 0) {
                atomicBoolean = sdkOtaRun.stop;
            }
            return sdkOtaRun.copy(job, atomicBoolean);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Job getJob() {
            return this.job;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final AtomicBoolean getStop() {
            return this.stop;
        }

        public final SdkOtaRun copy(Job job, AtomicBoolean stop) {
            Intrinsics.checkNotNullParameter(job, "job");
            Intrinsics.checkNotNullParameter(stop, "stop");
            return new SdkOtaRun(job, stop);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SdkOtaRun)) {
                return false;
            }
            SdkOtaRun sdkOtaRun = (SdkOtaRun) other;
            return Intrinsics.areEqual(this.job, sdkOtaRun.job) && Intrinsics.areEqual(this.stop, sdkOtaRun.stop);
        }

        public int hashCode() {
            return (this.job.hashCode() * 31) + this.stop.hashCode();
        }

        public String toString() {
            return "SdkOtaRun(job=" + this.job + ", stop=" + this.stop + ")";
        }

        public SdkOtaRun(Job job, AtomicBoolean stop) {
            Intrinsics.checkNotNullParameter(job, "job");
            Intrinsics.checkNotNullParameter(stop, "stop");
            this.job = job;
            this.stop = stop;
        }

        public final Job getJob() {
            return this.job;
        }

        public final AtomicBoolean getStop() {
            return this.stop;
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$prepareOtaDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$prepareOtaDevice$1", f = "NtEarOtaHostImpl.kt", i = {}, l = {43, 48}, m = "invokeSuspend", n = {}, s = {})
    static final class C09771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtEarOtaPrepareDeviceArgs $args;
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09771(NtEarOtaPrepareDeviceArgs ntEarOtaPrepareDeviceArgs, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super C09771> continuation) {
            super(2, continuation);
            this.$args = ntEarOtaPrepareDeviceArgs;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09771(this.$args, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0048  */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ear_ota.NtEarOtaHostImpl.C09771.C01931(r8.$callback, r9, null), r8) == r1) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00a3, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ear_ota.NtEarOtaHostImpl.C09771.AnonymousClass2(r8.$callback, null), r8) == r1) goto L28;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x00a5, code lost:
        
            return r1;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    String strMacToBluetoothAddress = OtaEarLinkSession.INSTANCE.macToBluetoothAddress(this.$args.getDeviceMac());
                    if (strMacToBluetoothAddress == null) {
                        z = false;
                    } else {
                        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                        if ((defaultAdapter != null ? defaultAdapter.getRemoteDevice(strMacToBluetoothAddress) : null) != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    Log.i(NtEarOtaHostImpl.TAG, "prepareOtaDevice mac=" + this.$args.getDeviceMac() + " ok=" + z);
                    this.label = 1;
                } else {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Log.e(NtEarOtaHostImpl.TAG, "prepareOtaDevice failed", e);
                this.label = 2;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$prepareOtaDevice$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$prepareOtaDevice$1$1", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
            final /* synthetic */ boolean $ok;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01931(Function1<? super Result<Boolean>, Unit> function1, boolean z, Continuation<? super C01931> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$ok = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01931(this.$callback, this.$ok, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Result<Boolean>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boxing.boxBoolean(this.$ok))));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$prepareOtaDevice$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$prepareOtaDevice$1$2", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass2(Function1<? super Result<Boolean>, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
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
                Function1<Result<Boolean>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boxing.boxBoolean(false))));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.nt_ear_ota.NtEarOtaNativeHost
    public void prepareOtaDevice(NtEarOtaPrepareDeviceArgs args, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09771(args, callback, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$openTransport$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$openTransport$1", f = "NtEarOtaHostImpl.kt", i = {}, l = {58, 59, 70}, m = "invokeSuspend", n = {}, s = {})
    static final class C09761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtEarOtaTransportOpenArgs $args;
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        int label;
        final /* synthetic */ NtEarOtaHostImpl this$0;

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$openTransport$1$WhenMappings */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[NtEarOtaTransportKind.values().length];
                try {
                    iArr[NtEarOtaTransportKind.EAR_SPP.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[NtEarOtaTransportKind.EAR_BLE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[NtEarOtaTransportKind.CASE_BLE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[NtEarOtaTransportKind.EAR_WIFI.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[NtEarOtaTransportKind.CASE_WIFI.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09761(NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs, NtEarOtaHostImpl ntEarOtaHostImpl, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super C09761> continuation) {
            super(2, continuation);
            this.$args = ntEarOtaTransportOpenArgs;
            this.this$0 = ntEarOtaHostImpl;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09761(this.$args, this.this$0, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
        
            if (r7 == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
        
            if (r7 == r0) goto L37;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00db, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ear_ota.NtEarOtaHostImpl.C09761.C01921(r6.$callback, r4, null), r6) == r0) goto L37;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean zBooleanValue = true;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.$args.getKind().ordinal()];
                if (i2 == 1 || i2 == 2) {
                    this.label = 1;
                    obj = this.this$0.openEarTransport(this.$args, this);
                } else if (i2 == 3) {
                    this.label = 2;
                    obj = this.this$0.openCaseTransport(this.$args, this);
                } else {
                    if (i2 != 4 && i2 != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Log.w(NtEarOtaHostImpl.TAG, "openTransport " + this.$args.getKind() + ": stub true");
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) obj).booleanValue();
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                zBooleanValue = ((Boolean) obj).booleanValue();
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            if (zBooleanValue) {
                this.this$0.sessionKinds.put(this.$args.getSessionId(), this.$args.getKind());
            } else {
                this.this$0.sessionKinds.remove(this.$args.getSessionId());
            }
            this.label = 3;
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$openTransport$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$openTransport$1$1", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
            final /* synthetic */ boolean $ok;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01921(Function1<? super Result<Boolean>, Unit> function1, boolean z, Continuation<? super C01921> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$ok = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01921(this.$callback, this.$ok, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01921) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Result<Boolean>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boxing.boxBoolean(this.$ok))));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.nt_ear_ota.NtEarOtaNativeHost
    public void openTransport(NtEarOtaTransportOpenArgs args, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09761(args, this, callback, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x0066  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object openEarTransport(final NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs, Continuation<? super Boolean> continuation) {
        C09751 c09751;
        String str;
        OtaEarLinkSession otaEarLinkSession;
        String str2;
        NtEarOtaHostImpl ntEarOtaHostImpl;
        if (continuation instanceof C09751) {
            c09751 = (C09751) continuation;
            if ((c09751.label & Integer.MIN_VALUE) != 0) {
                c09751.label -= Integer.MIN_VALUE;
            } else {
                c09751 = new C09751(continuation);
            }
        } else {
            c09751 = new C09751(continuation);
        }
        C09751 c09752 = c09751;
        Object obj = c09752.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09752.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Map<String, String> extras = ntEarOtaTransportOpenArgs.getExtras();
            if (extras == null || (str = extras.get("sppUuid")) == null) {
                str = "00001101-0000-1000-8000-00805F9B34FB";
            } else {
                if (str.length() <= 0) {
                    str = null;
                }
                if (str == null) {
                    str = "00001101-0000-1000-8000-00805F9B34FB";
                }
            }
            otaEarLinkSession = new OtaEarLinkSession(ntEarOtaTransportOpenArgs.getDeviceMac(), str);
            otaEarLinkSession.attachReceive(new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NtEarOtaHostImpl.openEarTransport$lambda$5(this.f$0, ntEarOtaTransportOpenArgs, (byte[]) obj2);
                }
            });
            c09752.L$0 = this;
            c09752.L$1 = ntEarOtaTransportOpenArgs;
            c09752.L$2 = str;
            c09752.L$3 = otaEarLinkSession;
            c09752.label = 1;
            Object objConnect$default = OtaEarLinkSession.connect$default(otaEarLinkSession, 0, 0L, c09752, 3, null);
            if (objConnect$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            str2 = str;
            obj = objConnect$default;
            ntEarOtaHostImpl = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            OtaEarLinkSession otaEarLinkSession2 = (OtaEarLinkSession) c09752.L$3;
            str2 = (String) c09752.L$2;
            NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs2 = (NtEarOtaTransportOpenArgs) c09752.L$1;
            ntEarOtaHostImpl = (NtEarOtaHostImpl) c09752.L$0;
            ResultKt.throwOnFailure(obj);
            otaEarLinkSession = otaEarLinkSession2;
            ntEarOtaTransportOpenArgs = ntEarOtaTransportOpenArgs2;
        }
        if (!((Boolean) obj).booleanValue()) {
            otaEarLinkSession.destroy();
            Log.e(TAG, "openTransport ear failed session=" + ntEarOtaTransportOpenArgs.getSessionId());
            return Boxing.boxBoolean(false);
        }
        ntEarOtaHostImpl.earSessions.put(ntEarOtaTransportOpenArgs.getSessionId(), otaEarLinkSession);
        Log.i(TAG, "openEarTransport ok session=" + ntEarOtaTransportOpenArgs.getSessionId() + " mac=" + ntEarOtaTransportOpenArgs.getDeviceMac() + " spp=" + str2);
        return Boxing.boxBoolean(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openEarTransport$lambda$5$lambda$4(NtEarOtaHostImpl ntEarOtaHostImpl, NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs, List list) {
        try {
            ntEarOtaHostImpl.getFlutterCallbacks().onTransportBytes(ntEarOtaTransportOpenArgs.getSessionId(), list, new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarOtaHostImpl.openEarTransport$lambda$5$lambda$4$lambda$3((Result) obj);
                }
            });
        } catch (Throwable th) {
            Log.w(TAG, "onTransportBytes dropped", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openEarTransport$lambda$5$lambda$4$lambda$3(Result result) {
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
        if (thM6350exceptionOrNullimpl != null) {
            Log.w(TAG, "onTransportBytes ignored: " + thM6350exceptionOrNullimpl.getMessage());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:92:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:94:0x0201  */
    public final Object openCaseTransport(NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        boolean z;
        long jLongValue;
        String str;
        String string;
        String string2;
        String string3;
        String str2;
        String str3;
        final NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs2;
        final NtEarOtaHostImpl ntEarOtaHostImpl;
        String str4;
        String str5;
        String str6;
        String str7;
        String string4;
        String str8;
        Long longOrNull;
        String str9;
        NtEarOtaCaseBleSession ntEarOtaCaseBleSession;
        NtEarOtaHostImpl ntEarOtaHostImpl2;
        NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs3;
        String str10;
        Long longOrNull2;
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
        if (i != 0) {
            if (i == 1) {
                jLongValue = anonymousClass1.J$0;
                string3 = (String) anonymousClass1.L$5;
                string2 = (String) anonymousClass1.L$4;
                string = (String) anonymousClass1.L$3;
                str = (String) anonymousClass1.L$2;
                ntEarOtaTransportOpenArgs2 = (NtEarOtaTransportOpenArgs) anonymousClass1.L$1;
                z = false;
                ntEarOtaHostImpl = (NtEarOtaHostImpl) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ntEarOtaCaseBleSession = (NtEarOtaCaseBleSession) anonymousClass1.L$3;
                str9 = (String) anonymousClass1.L$2;
                ntEarOtaTransportOpenArgs3 = (NtEarOtaTransportOpenArgs) anonymousClass1.L$1;
                ntEarOtaHostImpl2 = (NtEarOtaHostImpl) anonymousClass1.L$0;
                ResultKt.throwOnFailure(obj);
                z = false;
            }
            if (!((Boolean) obj).booleanValue()) {
                ntEarOtaCaseBleSession.close();
                Log.e(TAG, "openTransport caseBle: connect timeout caseMac=" + str9);
                return Boxing.boxBoolean(z);
            }
            ntEarOtaHostImpl2.caseSessions.put(ntEarOtaTransportOpenArgs3.getSessionId(), ntEarOtaCaseBleSession);
            return Boxing.boxBoolean(true);
        }
        z = false;
        ResultKt.throwOnFailure(obj);
        Map<String, String> extras = ntEarOtaTransportOpenArgs.getExtras();
        jLongValue = (extras == null || (str8 = extras.get("scanTimeoutMs")) == null || (longOrNull = StringsKt.toLongOrNull(str8)) == null) ? 15000L : longOrNull.longValue();
        Map<String, String> extras2 = ntEarOtaTransportOpenArgs.getExtras();
        str = (extras2 == null || (str7 = extras2.get("caseMac")) == null || (string4 = StringsKt.trim((CharSequence) str7).toString()) == null || string4.length() <= 0) ? null : string4;
        if (str == null) {
            Log.e(TAG, "openTransport caseBle: extras.caseMac is required (known box MAC)");
            return Boxing.boxBoolean(false);
        }
        Map<String, String> extras3 = ntEarOtaTransportOpenArgs.getExtras();
        string = (extras3 == null || (str6 = extras3.get("serviceUuid")) == null) ? null : StringsKt.trim((CharSequence) str6).toString();
        Map<String, String> extras4 = ntEarOtaTransportOpenArgs.getExtras();
        string2 = (extras4 == null || (str5 = extras4.get("writeUuid")) == null) ? null : StringsKt.trim((CharSequence) str5).toString();
        Map<String, String> extras5 = ntEarOtaTransportOpenArgs.getExtras();
        string3 = (extras5 == null || (str4 = extras5.get("notifyUuid")) == null) ? null : StringsKt.trim((CharSequence) str4).toString();
        String str11 = string;
        if (str11 == null || str11.length() == 0 || (str2 = string2) == null || str2.length() == 0 || (str3 = string3) == null || str3.length() == 0) {
            Log.e(TAG, "openTransport caseBle: extras.serviceUuid, writeUuid, notifyUuid required (OTA GATT UUIDs differ from case recording; fill when product values are ready)");
            return Boxing.boxBoolean(false);
        }
        anonymousClass1.L$0 = this;
        anonymousClass1.L$1 = ntEarOtaTransportOpenArgs;
        anonymousClass1.L$2 = str;
        anonymousClass1.L$3 = string;
        anonymousClass1.L$4 = string2;
        anonymousClass1.L$5 = string3;
        anonymousClass1.J$0 = jLongValue;
        anonymousClass1.label = 1;
        Object objAwaitBleAdvertisementFromMac = CaseBleMacUtilsKt.awaitBleAdvertisementFromMac(str, jLongValue, anonymousClass1);
        if (objAwaitBleAdvertisementFromMac != coroutine_suspended) {
            ntEarOtaTransportOpenArgs2 = ntEarOtaTransportOpenArgs;
            obj = objAwaitBleAdvertisementFromMac;
            ntEarOtaHostImpl = this;
        }
        return coroutine_suspended;
        String str12 = string3;
        String str13 = string2;
        String str14 = string;
        if (!((Boolean) obj).booleanValue()) {
            Log.w(TAG, "openTransport caseBle: no advertisement matched by mac=" + str + " within " + jLongValue + "ms; continue to connect anyway (RPA/private addr possible)");
        }
        Map<String, String> extras6 = ntEarOtaTransportOpenArgs2.getExtras();
        long jLongValue2 = (extras6 == null || (str10 = extras6.get("caseConnectTimeoutMs")) == null || (longOrNull2 = StringsKt.toLongOrNull(str10)) == null) ? 30000L : longOrNull2.longValue();
        String str15 = str;
        NtEarOtaCaseBleSession ntEarOtaCaseBleSession2 = new NtEarOtaCaseBleSession(ntEarOtaTransportOpenArgs2.getSessionId(), str15, str14, str13, str12, new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return NtEarOtaHostImpl.openCaseTransport$lambda$10(this.f$0, ntEarOtaTransportOpenArgs2, (byte[]) obj2);
            }
        });
        str9 = str15;
        anonymousClass1.L$0 = ntEarOtaHostImpl;
        anonymousClass1.L$1 = ntEarOtaTransportOpenArgs2;
        anonymousClass1.L$2 = str9;
        anonymousClass1.L$3 = ntEarOtaCaseBleSession2;
        anonymousClass1.L$4 = null;
        anonymousClass1.L$5 = null;
        anonymousClass1.label = 2;
        Object objOpen = ntEarOtaCaseBleSession2.open(jLongValue2, anonymousClass1);
        if (objOpen != coroutine_suspended) {
            ntEarOtaCaseBleSession = ntEarOtaCaseBleSession2;
            obj = objOpen;
            ntEarOtaHostImpl2 = ntEarOtaHostImpl;
            ntEarOtaTransportOpenArgs3 = ntEarOtaTransportOpenArgs2;
            if (!((Boolean) obj).booleanValue()) {
                ntEarOtaCaseBleSession.close();
                Log.e(TAG, "openTransport caseBle: connect timeout caseMac=" + str9);
                return Boxing.boxBoolean(z);
            }
            ntEarOtaHostImpl2.caseSessions.put(ntEarOtaTransportOpenArgs3.getSessionId(), ntEarOtaCaseBleSession);
            return Boxing.boxBoolean(true);
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openCaseTransport$lambda$10$lambda$9(NtEarOtaHostImpl ntEarOtaHostImpl, NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs, List list) {
        try {
            ntEarOtaHostImpl.getFlutterCallbacks().onTransportBytes(ntEarOtaTransportOpenArgs.getSessionId(), list, new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NtEarOtaHostImpl.openCaseTransport$lambda$10$lambda$9$lambda$8((Result) obj);
                }
            });
        } catch (Throwable th) {
            Log.w(TAG, "onTransportBytes dropped", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openCaseTransport$lambda$10$lambda$9$lambda$8(Result result) {
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(result.getValue());
        if (thM6350exceptionOrNullimpl != null) {
            Log.w(TAG, "onTransportBytes ignored: " + thM6350exceptionOrNullimpl.getMessage());
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ear_ota.NtEarOtaNativeHost
    public void closeTransport(String sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionKinds.remove(sessionId);
        OtaEarLinkSession otaEarLinkSessionRemove = this.earSessions.remove(sessionId);
        if (otaEarLinkSessionRemove != null) {
            otaEarLinkSessionRemove.destroy();
        }
        NtEarOtaCaseBleSession ntEarOtaCaseBleSessionRemove = this.caseSessions.remove(sessionId);
        if (ntEarOtaCaseBleSessionRemove != null) {
            ntEarOtaCaseBleSessionRemove.close();
        }
    }

    @Override // com.nothing.nt_ear_ota.NtEarOtaNativeHost
    public void transportWrite(NtEarOtaTransportWriteArgs args, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NtEarOtaTransportKind ntEarOtaTransportKind = this.sessionKinds.get(args.getSessionId());
        if (ntEarOtaTransportKind == null) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Unknown session " + args.getSessionId())))));
            return;
        }
        List<Long> payload = args.getPayload();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(payload, 10));
        for (Long l : payload) {
            arrayList.add(Byte.valueOf((byte) (l != null ? l.longValue() : 0L)));
        }
        byte[] byteArray = CollectionsKt.toByteArray(arrayList);
        int i = WhenMappings.$EnumSwitchMapping$0[ntEarOtaTransportKind.ordinal()];
        if (i == 1 || i == 2) {
            OtaEarLinkSession otaEarLinkSession = this.earSessions.get(args.getSessionId());
            if (otaEarLinkSession != null) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09791(args.getExpectResponseOpcode(), otaEarLinkSession, byteArray, args, callback, this, null), 3, null);
                return;
            } else {
                Result.Companion companion2 = Result.INSTANCE;
                callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Ear session missing")))));
                return;
            }
        }
        if (i == 3) {
            NtEarOtaCaseBleSession ntEarOtaCaseBleSession = this.caseSessions.get(args.getSessionId());
            if (ntEarOtaCaseBleSession == null) {
                Result.Companion companion3 = Result.INSTANCE;
                callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Case session missing")))));
                return;
            } else {
                ntEarOtaCaseBleSession.sendPayload(byteArray, callback);
                return;
            }
        }
        if (i != 4 && i != 5) {
            throw new NoWhenBranchMatchedException();
        }
        Log.w(TAG, "transportWrite wifi stub session=" + args.getSessionId() + " len=" + byteArray.length);
        Result.Companion companion4 = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1", f = "NtEarOtaHostImpl.kt", i = {6}, l = {210, 214, 223, 228, 239, 240, 257, 258, 289}, m = "invokeSuspend", n = {"op"}, s = {"I$0"})
    static final class C09791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtEarOtaTransportWriteArgs $args;
        final /* synthetic */ byte[] $bytes;
        final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
        final /* synthetic */ Long $opcode;
        final /* synthetic */ OtaEarLinkSession $session;
        int I$0;
        int label;
        final /* synthetic */ NtEarOtaHostImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09791(Long l, OtaEarLinkSession otaEarLinkSession, byte[] bArr, NtEarOtaTransportWriteArgs ntEarOtaTransportWriteArgs, Function1<? super Result<Unit>, Unit> function1, NtEarOtaHostImpl ntEarOtaHostImpl, Continuation<? super C09791> continuation) {
            super(2, continuation);
            this.$opcode = l;
            this.$session = otaEarLinkSession;
            this.$bytes = bArr;
            this.$args = ntEarOtaTransportWriteArgs;
            this.$callback = function1;
            this.this$0 = ntEarOtaHostImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09791(this.$opcode, this.$session, this.$bytes, this.$args, this.$callback, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0093  */
        /* JADX WARN: Code duplicated, block: B:46:0x012f  */
        /* JADX WARN: Code duplicated, block: B:60:0x018f  */
        /* JADX WARN: Code duplicated, block: B:68:0x01c5  */
        /* JADX WARN: Code restructure failed: missing block: B:72:0x01e9, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ear_ota.NtEarOtaHostImpl.C09791.AnonymousClass6(r17.$callback, r0, null), r17) == r2) goto L73;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object objSendRawBesOtaLocked;
            int i;
            Object objSendOtaLocked;
            boolean zBooleanValue;
            boolean zBooleanValue2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        Long l = this.$opcode;
                        if (l != null) {
                            this.label = 1;
                            if (OtaEarLinkSession.syncSend$default(this.$session, (byte) (((int) l.longValue()) & 255), this.$bytes, null, 0L, this, 12, null) != coroutine_suspended) {
                                this.label = 2;
                                if (BuildersKt.withContext(Dispatchers.getMain(), new C01961(this.$callback, null), this) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            }
                        } else {
                            Byte bFirstOrNull = ArraysKt.firstOrNull(this.$bytes);
                            int iByteValue = bFirstOrNull != null ? bFirstOrNull.byteValue() & 255 : -1;
                            Byte orNull = ArraysKt.getOrNull(this.$bytes, 1);
                            int iByteValue2 = orNull != null ? orNull.byteValue() & 255 : -1;
                            if (iByteValue == 155 || iByteValue == 157) {
                                this.label = 3;
                                if (OtaEarLinkSession.syncSend$default(this.$session, (byte) 0, this.$bytes, null, 500L, this, 4, null) != coroutine_suspended) {
                                    this.label = 4;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$callback, null), this) == coroutine_suspended) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            } else if (iByteValue == 9) {
                                String sessionId = this.$args.getSessionId();
                                String string = Integer.toString(iByteValue2, CharsKt.checkRadix(16));
                                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                                Log.d(NtEarOtaHostImpl.TAG, "transportWrite ear session=" + sessionId + " cmd=0x" + string + " len=" + this.$bytes.length);
                                this.label = 5;
                                objSendOtaLocked = this.$session.sendOtaLocked(this.$bytes, null, this);
                                if (objSendOtaLocked != coroutine_suspended) {
                                    zBooleanValue = ((Boolean) objSendOtaLocked).booleanValue();
                                    this.label = 6;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(zBooleanValue, this.$callback, this.$args, null), this) == coroutine_suspended) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            } else if (iByteValue == 130 || iByteValue == 133) {
                                this.I$0 = iByteValue;
                                this.label = 7;
                                objSendRawBesOtaLocked = this.$session.sendRawBesOtaLocked(this.$bytes, this);
                                if (objSendRawBesOtaLocked != coroutine_suspended) {
                                    i = iByteValue;
                                    zBooleanValue2 = ((Boolean) objSendRawBesOtaLocked).booleanValue();
                                    this.label = 8;
                                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass4(zBooleanValue2, this.$callback, i, this.$args, null), this) == coroutine_suspended) {
                                    }
                                    return Unit.INSTANCE;
                                }
                            } else {
                                final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                                OtaEarLinkSession otaEarLinkSession = this.$session;
                                byte[] bArr = this.$bytes;
                                final NtEarOtaHostImpl ntEarOtaHostImpl = this.this$0;
                                final Function1<Result<Unit>, Unit> function1 = this.$callback;
                                final NtEarOtaTransportWriteArgs ntEarOtaTransportWriteArgs = this.$args;
                                otaEarLinkSession.sendAsync(bArr, null, new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj2) {
                                        return NtEarOtaHostImpl.C09791.invokeSuspend$lambda$1(booleanRef, ntEarOtaHostImpl, function1, ntEarOtaTransportWriteArgs, ((Boolean) obj2).booleanValue());
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }
                        return coroutine_suspended;
                    case 1:
                        ResultKt.throwOnFailure(obj);
                        this.label = 2;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new C01961(this.$callback, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 2:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 3:
                        ResultKt.throwOnFailure(obj);
                        this.label = 4;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(this.$callback, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 4:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 5:
                        ResultKt.throwOnFailure(obj);
                        objSendOtaLocked = obj;
                        zBooleanValue = ((Boolean) objSendOtaLocked).booleanValue();
                        this.label = 6;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass3(zBooleanValue, this.$callback, this.$args, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 6:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 7:
                        int i2 = this.I$0;
                        ResultKt.throwOnFailure(obj);
                        i = i2;
                        objSendRawBesOtaLocked = obj;
                        zBooleanValue2 = ((Boolean) objSendRawBesOtaLocked).booleanValue();
                        this.label = 8;
                        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass4(zBooleanValue2, this.$callback, i, this.$args, null), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    case 8:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    case 9:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (Exception e) {
                Log.e(NtEarOtaHostImpl.TAG, "transportWrite ear failed", e);
                this.label = 9;
            }
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$1", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01961 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01961(Function1<? super Result<Unit>, Unit> function1, Continuation<? super C01961> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01961(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01961) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$2", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$3", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ NtEarOtaTransportWriteArgs $args;
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ boolean $ok;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass3(boolean z, Function1<? super Result<Unit>, Unit> function1, NtEarOtaTransportWriteArgs ntEarOtaTransportWriteArgs, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$ok = z;
                this.$callback = function1;
                this.$args = ntEarOtaTransportWriteArgs;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.$ok, this.$callback, this.$args, continuation);
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
                if (this.$ok) {
                    Function1<Result<Unit>, Unit> function1 = this.$callback;
                    Result.Companion companion = Result.INSTANCE;
                    function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
                } else {
                    Log.e(NtEarOtaHostImpl.TAG, "transportWrite Acts send failed session=" + this.$args.getSessionId());
                    Function1<Result<Unit>, Unit> function2 = this.$callback;
                    Result.Companion companion2 = Result.INSTANCE;
                    function2.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("OTA send failed")))));
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$4", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ NtEarOtaTransportWriteArgs $args;
            final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
            final /* synthetic */ boolean $ok;
            final /* synthetic */ int $op;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass4(boolean z, Function1<? super Result<Unit>, Unit> function1, int i, NtEarOtaTransportWriteArgs ntEarOtaTransportWriteArgs, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.$ok = z;
                this.$callback = function1;
                this.$op = i;
                this.$args = ntEarOtaTransportWriteArgs;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.$ok, this.$callback, this.$op, this.$args, continuation);
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
                if (this.$ok) {
                    Function1<Result<Unit>, Unit> function1 = this.$callback;
                    Result.Companion companion = Result.INSTANCE;
                    function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
                } else {
                    String string = Integer.toString(this.$op, CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                    Log.e(NtEarOtaHostImpl.TAG, "transportWrite BES raw send failed op=0x" + string + " session=" + this.$args.getSessionId());
                    Function1<Result<Unit>, Unit> function2 = this.$callback;
                    Result.Companion companion2 = Result.INSTANCE;
                    function2.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("OTA send failed")))));
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1(Ref.BooleanRef booleanRef, NtEarOtaHostImpl ntEarOtaHostImpl, final Function1 function1, final NtEarOtaTransportWriteArgs ntEarOtaTransportWriteArgs, final boolean z) {
            if (booleanRef.element) {
                return Unit.INSTANCE;
            }
            booleanRef.element = true;
            ntEarOtaHostImpl.mainHandler.post(new Runnable() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NtEarOtaHostImpl.C09791.invokeSuspend$lambda$1$lambda$0(z, function1, ntEarOtaTransportWriteArgs);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1$lambda$0(boolean z, Function1 function1, NtEarOtaTransportWriteArgs ntEarOtaTransportWriteArgs) {
            if (z) {
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
            } else {
                Log.e(NtEarOtaHostImpl.TAG, "transportWrite async send failed session=" + ntEarOtaTransportWriteArgs.getSessionId());
                Result.Companion companion2 = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("OTA send failed")))));
            }
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$transportWrite$1$6", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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

    @Override // com.nothing.nt_ear_ota.NtEarOtaNativeHost
    public void syncTransportWrite(NtEarOtaTransportWriteArgs args, Function1<? super Result<? extends List<Long>>, Unit> callback) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Long expectResponseOpcode = args.getExpectResponseOpcode();
        if (expectResponseOpcode == null) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalArgumentException("expectResponseOpcode required")))));
            return;
        }
        NtEarOtaTransportKind ntEarOtaTransportKind = this.sessionKinds.get(args.getSessionId());
        if (ntEarOtaTransportKind == null) {
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Unknown session " + args.getSessionId())))));
            return;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[ntEarOtaTransportKind.ordinal()];
        if (i == 1 || i == 2) {
            OtaEarLinkSession otaEarLinkSession = this.earSessions.get(args.getSessionId());
            if (otaEarLinkSession == null) {
                Result.Companion companion3 = Result.INSTANCE;
                callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("Ear session missing")))));
                return;
            }
            List<Long> payload = args.getPayload();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(payload, 10));
            for (Long l : payload) {
                arrayList.add(Byte.valueOf((byte) (l != null ? l.longValue() : 0L)));
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass2(otaEarLinkSession, expectResponseOpcode, CollectionsKt.toByteArray(arrayList), callback, null), 3, null);
            return;
        }
        if (i == 3) {
            NtEarOtaCaseBleSession ntEarOtaCaseBleSession = this.caseSessions.get(args.getSessionId());
            if (ntEarOtaCaseBleSession == null) {
                Result.Companion companion4 = Result.INSTANCE;
                callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("case transport not ready")))));
                return;
            }
            List<Long> payload2 = args.getPayload();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(payload2, 10));
            for (Long l2 : payload2) {
                arrayList2.add(Byte.valueOf((byte) (l2 != null ? l2.longValue() : 0L)));
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09781(ntEarOtaCaseBleSession, CollectionsKt.toByteArray(arrayList2), callback, null), 3, null);
            return;
        }
        Result.Companion companion5 = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new UnsupportedOperationException("syncTransportWrite for " + ntEarOtaTransportKind + " not supported")))));
        Unit unit = Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$1", f = "NtEarOtaHostImpl.kt", i = {}, l = {329, 331}, m = "invokeSuspend", n = {}, s = {})
    static final class C09781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $bytes;
        final /* synthetic */ NtEarOtaCaseBleSession $c;
        final /* synthetic */ Function1<Result<? extends List<Long>>, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09781(NtEarOtaCaseBleSession ntEarOtaCaseBleSession, byte[] bArr, Function1<? super Result<? extends List<Long>>, Unit> function1, Continuation<? super C09781> continuation) {
            super(2, continuation);
            this.$c = ntEarOtaCaseBleSession;
            this.$bytes = bArr;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09781(this.$c, this.$bytes, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09781) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ear_ota.NtEarOtaHostImpl.C09781.C01941(r7.$callback, r1, null), r7) == r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayListEmptyList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = this.$c.syncSendPayload(this.$bytes, 20000L, this);
                if (obj != coroutine_suspended) {
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
            byte[] bArr = (byte[]) obj;
            if (bArr == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            } else {
                ArrayList arrayList = new ArrayList(bArr.length);
                for (byte b : bArr) {
                    arrayList.add(Boxing.boxLong(b & 255));
                }
                arrayListEmptyList = arrayList;
            }
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$1$1", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<? extends List<Long>>, Unit> $callback;
            final /* synthetic */ List<Long> $out;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01941(Function1<? super Result<? extends List<Long>>, Unit> function1, List<Long> list, Continuation<? super C01941> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$out = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01941(this.$callback, this.$out, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01941) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Result<? extends List<Long>>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(this.$out)));
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$2, reason: invalid class name */
    /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$2", f = "NtEarOtaHostImpl.kt", i = {}, l = {345, 350, 355}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $bytes;
        final /* synthetic */ Function1<Result<? extends List<Long>>, Unit> $callback;
        final /* synthetic */ Long $opcodeArg;
        final /* synthetic */ OtaEarLinkSession $session;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(OtaEarLinkSession otaEarLinkSession, Long l, byte[] bArr, Function1<? super Result<? extends List<Long>>, Unit> function1, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$session = otaEarLinkSession;
            this.$opcodeArg = l;
            this.$bytes = bArr;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$session, this.$opcodeArg, this.$bytes, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x008e, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ear_ota.NtEarOtaHostImpl.AnonymousClass2.AnonymousClass1(r14.$callback, r0, null), r14) == r1) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00b3, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ear_ota.NtEarOtaHostImpl.AnonymousClass2.C01952(r14.$callback, r0, null), r14) == r1) goto L31;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayListEmptyList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = OtaEarLinkSession.syncSend$default(this.$session, (byte) (((int) this.$opcodeArg.longValue()) & 255), this.$bytes, null, 0L, this, 12, null);
                    if (obj == coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2 && i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                byte[] bArr = (byte[]) obj;
                if (bArr == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    ArrayList arrayList = new ArrayList(bArr.length);
                    for (byte b : bArr) {
                        arrayList.add(Boxing.boxLong(b & 255));
                    }
                    arrayListEmptyList = arrayList;
                }
                this.label = 2;
            } catch (Exception e) {
                Log.e(NtEarOtaHostImpl.TAG, "syncTransportWrite failed", e);
                this.label = 3;
            }
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$2$1", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<? extends List<Long>>, Unit> $callback;
            final /* synthetic */ List<Long> $out;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Function1<? super Result<? extends List<Long>>, Unit> function1, List<Long> list, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$out = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$callback, this.$out, continuation);
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
                Function1<Result<? extends List<Long>>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(this.$out)));
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NtEarOtaHostImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaHostImpl$syncTransportWrite$2$2", f = "NtEarOtaHostImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<? extends List<Long>>, Unit> $callback;
            final /* synthetic */ Exception $e;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01952(Function1<? super Result<? extends List<Long>>, Unit> function1, Exception exc, Continuation<? super C01952> continuation) {
                super(2, continuation);
                this.$callback = function1;
                this.$e = exc;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01952(this.$callback, this.$e, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01952) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Result<? extends List<Long>>, Unit> function1 = this.$callback;
                Result.Companion companion = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(this.$e))));
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.nt_ear_ota.NtEarOtaNativeHost
    public void startSdkOta(NtEarOtaSdkStartArgs args, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String firmwarePath = args.getFirmwarePath();
        String str = firmwarePath;
        if (str == null || str.length() == 0) {
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
            return;
        }
        SdkOtaRun sdkOtaRunRemove = this.sdkRuns.remove(args.getDeviceMac());
        if (sdkOtaRunRemove != null) {
            sdkOtaRunRemove.getStop().set(true);
            Job.DefaultImpls.cancel$default(sdkOtaRunRemove.getJob(), (CancellationException) null, 1, (Object) null);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.sdkRuns.put(args.getDeviceMac(), new SdkOtaRun(BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new NtEarOtaHostImpl$startSdkOta$job$1(firmwarePath, this, args, atomicBoolean, null), 3, null), atomicBoolean));
        Result.Companion companion2 = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
    }

    @Override // com.nothing.nt_ear_ota.NtEarOtaNativeHost
    public void stopSdkOta(String deviceMac, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            SdkOtaRun sdkOtaRunRemove = this.sdkRuns.remove(deviceMac);
            if (sdkOtaRunRemove != null) {
                sdkOtaRunRemove.getStop().set(true);
                Job.DefaultImpls.cancel$default(sdkOtaRunRemove.getJob(), (CancellationException) null, 1, (Object) null);
            }
            Result.Companion companion = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
        } catch (Exception e) {
            Log.e(TAG, "stopSdkOta failed", e);
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        }
    }

    @Override // com.nothing.nt_ear_ota.NtEarOtaNativeHost
    public void resolveEarGattIdentifier(String deviceMac, Function1<? super Result<String>, Unit> callback) {
        Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void emitSdkFail(int code, String msg) {
        getFlutterCallbacks().onSdkEvent(new NtEarOtaSdkEvent(NtEarOtaSdkEventKind.FAIL, null, Long.valueOf(code), msg), new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NtEarOtaHostImpl.emitSdkFail$lambda$17((Result) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit emitSdkFail$lambda$17(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String mapAbOtaFail(int errorCode) {
        if (errorCode == 1) {
            return "same firmware";
        }
        if (errorCode == 2) {
            return "key mismatch";
        }
        if (errorCode == 11) {
            return "crc error";
        }
        if (errorCode == 4097) {
            return "device refused";
        }
        switch (errorCode) {
            case 4099:
                return "timeout";
            case 4100:
                return "tws disconnected";
            case ABOta.ERROR_CODE_DATA_READER_ERROR /* 4101 */:
                return "data reader error";
            default:
                return "unknown(" + errorCode + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openEarTransport$lambda$5(final NtEarOtaHostImpl ntEarOtaHostImpl, final NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs, byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            ArrayList arrayList = new ArrayList(bytes.length);
            for (byte b : bytes) {
                arrayList.add(Long.valueOf(b & 255));
            }
            final ArrayList arrayList2 = arrayList;
            ntEarOtaHostImpl.mainHandler.post(new Runnable() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    NtEarOtaHostImpl.openEarTransport$lambda$5$lambda$4(this.f$0, ntEarOtaTransportOpenArgs, arrayList2);
                }
            });
        } catch (Throwable th) {
            Log.w(TAG, "onTransportBytes dropped (no flutter handler?)", th);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openCaseTransport$lambda$10(final NtEarOtaHostImpl ntEarOtaHostImpl, final NtEarOtaTransportOpenArgs ntEarOtaTransportOpenArgs, byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        try {
            ArrayList arrayList = new ArrayList(bytes.length);
            for (byte b : bytes) {
                arrayList.add(Long.valueOf(b & 255));
            }
            final ArrayList arrayList2 = arrayList;
            ntEarOtaHostImpl.mainHandler.post(new Runnable() { // from class: com.nothing.nt_ear_ota.NtEarOtaHostImpl$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    NtEarOtaHostImpl.openCaseTransport$lambda$10$lambda$9(this.f$0, ntEarOtaTransportOpenArgs, arrayList2);
                }
            });
        } catch (Throwable th) {
            Log.w(TAG, "onTransportBytes dropped (no flutter handler?)", th);
        }
        return Unit.INSTANCE;
    }
}
