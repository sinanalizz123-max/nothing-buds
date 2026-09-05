package com.nothing.nt_ear_ota;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.media3.extractor.ts.TsExtractor;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector;
import com.nothing.link.bluetooth.sdk.connect.spp.XSppOTAConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.spotify.sdk.android.auth.LoginActivity;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.apache.commons.cli.HelpFormatter;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;

/* JADX INFO: compiled from: OtaEarLinkSession.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u001a\u0010\u0016\u001a\u00020\u000e2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\"\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010\u001eJ6\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\r2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010&J,\u0010'\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\r2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u000e0\fJ\u0016\u0010*\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010+J\"\u0010,\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\r2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\rH\u0086@\u00a2\u0006\u0002\u0010-J\u0006\u0010.\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/nothing/nt_ear_ota/OtaEarLinkSession;", "", "deviceMac", "", "sppUuid", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/nt_ear_ota/ActsSppRawParser;", "otaConnector", "Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "bytesListener", "Lkotlin/Function1;", "", "", "writeMutex", "Lkotlinx/coroutines/sync/Mutex;", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", "deliverRx", "bytes", "source", "attachReceive", "onBytes", "connect", "", "maxAttempts", "", "delayMs", "", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncSend", LoginActivity.RESPONSE_KEY, "", "message", "retryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "durationMs", "(B[BLjava/util/concurrent/atomic/AtomicInteger;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendAsync", "mockResponse", "onResult", "sendRawBesOtaLocked", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOtaLocked", "([B[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroy", "Companion", "nt_ear_ota_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OtaEarLinkSession {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NtEarOtaEarSession";
    private Function1<? super byte[], Unit> bytesListener;
    private final String deviceMac;
    private XConnector otaConnector;
    private final ActsSppRawParser parser;
    private final String sppUuid;
    private final Mutex writeMutex;

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.OtaEarLinkSession$connect$1, reason: invalid class name */
    /* JADX INFO: compiled from: OtaEarLinkSession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.OtaEarLinkSession", f = "OtaEarLinkSession.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3}, l = {ExerciseSessionRecord.EXERCISE_TYPE_STAIR_CLIMBING, 84, 85, 90}, m = "connect", n = {"this", "connector", "maxAttempts", "delayMs", "attempt", "this", "connector", "maxAttempts", "delayMs", "attempt", "this", "connector", "maxAttempts", "delayMs", "attempt", "this"}, s = {"L$0", "L$1", "I$0", "J$0", "I$2", "L$0", "L$1", "I$0", "J$0", "I$2", "L$0", "L$1", "I$0", "J$0", "I$2", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaEarLinkSession.this.connect(0, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.OtaEarLinkSession$sendOtaLocked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OtaEarLinkSession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.OtaEarLinkSession", f = "OtaEarLinkSession.kt", i = {0, 0, 0}, l = {216}, m = "sendOtaLocked", n = {"this", "message", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C09811 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09811(Continuation<? super C09811> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaEarLinkSession.this.sendOtaLocked(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.OtaEarLinkSession$sendRawBesOtaLocked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OtaEarLinkSession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.OtaEarLinkSession", f = "OtaEarLinkSession.kt", i = {0, 0, 0}, l = {216}, m = "sendRawBesOtaLocked", n = {"this", "message", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
    static final class C09821 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C09821(Continuation<? super C09821> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaEarLinkSession.this.sendRawBesOtaLocked(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.OtaEarLinkSession$syncSend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OtaEarLinkSession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.OtaEarLinkSession", f = "OtaEarLinkSession.kt", i = {0, 0, 0, 0}, l = {104}, m = "syncSend", n = {"message", "retry", "op", "dur"}, s = {"L$0", "L$1", "I$0", "J$0"})
    static final class C09831 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C09831(Continuation<? super C09831> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OtaEarLinkSession.this.syncSend((byte) 0, null, null, 0L, this);
        }
    }

    public OtaEarLinkSession(String deviceMac, String sppUuid) {
        Intrinsics.checkNotNullParameter(deviceMac, "deviceMac");
        Intrinsics.checkNotNullParameter(sppUuid, "sppUuid");
        this.deviceMac = deviceMac;
        this.sppUuid = sppUuid;
        this.parser = new ActsSppRawParser();
        this.writeMutex = MutexKt.Mutex$default(false, 1, null);
    }

    private final BluetoothDevice bluetoothDevice() {
        BluetoothAdapter defaultAdapter;
        String strMacToBluetoothAddress = INSTANCE.macToBluetoothAddress(this.deviceMac);
        if (strMacToBluetoothAddress == null || (defaultAdapter = BluetoothAdapter.getDefaultAdapter()) == null) {
            return null;
        }
        return defaultAdapter.getRemoteDevice(strMacToBluetoothAddress);
    }

    private final void deliverRx(byte[] bytes, String source) {
        Byte bFirstOrNull = ArraysKt.firstOrNull(bytes);
        int iByteValue = bFirstOrNull != null ? bFirstOrNull.byteValue() & 255 : -1;
        Byte orNull = ArraysKt.getOrNull(bytes, 1);
        int iByteValue2 = orNull != null ? orNull.byteValue() & 255 : -1;
        if (iByteValue == 9 || CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(TsExtractor.TS_STREAM_TYPE_DTS_UHD), 131, 132, 141, 143, 152, 145}).contains(Integer.valueOf(iByteValue))) {
            String string = Integer.toString(iByteValue, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            String string2 = Integer.toString(iByteValue2, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
            Log.d(TAG, "rx(" + source + ") op=0x" + string + " cmd=0x" + string2 + " len=" + bytes.length + " mac=" + this.deviceMac);
        }
        Function1<? super byte[], Unit> function1 = this.bytesListener;
        if (function1 != null) {
            function1.invoke(bytes);
        }
    }

    public final void attachReceive(Function1<? super byte[], Unit> onBytes) {
        Intrinsics.checkNotNullParameter(onBytes, "onBytes");
        this.bytesListener = onBytes;
        BluetoothDevice bluetoothDevice = bluetoothDevice();
        if (bluetoothDevice != null && this.otaConnector == null) {
            XSppOTAConnector xSppOTAConnectorSppOTA$default = XConnectorDevice.sppOTA$default(XBluetoothManager.INSTANCE.get().getDevice(bluetoothDevice), this.sppUuid, null, 0, this.parser, 6, null);
            this.otaConnector = xSppOTAConnectorSppOTA$default;
            if (xSppOTAConnectorSppOTA$default != null) {
                xSppOTAConnectorSppOTA$default.setMessageReceiveCallback("nt_ear_ota_ear", new Function1() { // from class: com.nothing.nt_ear_ota.OtaEarLinkSession$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OtaEarLinkSession.attachReceive$lambda$1(this.f$0, (XCommand) obj);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit attachReceive$lambda$1(OtaEarLinkSession otaEarLinkSession, XCommand xCommand) {
        byte[] data;
        if (xCommand != null && (data = xCommand.getData()) != null) {
            otaEarLinkSession.deliverRx(data, "callback");
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object connect$default(OtaEarLinkSession otaEarLinkSession, int i, long j, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 2;
        }
        if ((i2 & 2) != 0) {
            j = 1500;
        }
        return otaEarLinkSession.connect(i, j, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0075 A[PHI: r2 r4 r6 r7 r10 r14 r15
      0x0075: PHI (r2v4 com.nothing.nt_ear_ota.OtaEarLinkSession$connect$1) = (r2v5 com.nothing.nt_ear_ota.OtaEarLinkSession$connect$1), (r2v2 com.nothing.nt_ear_ota.OtaEarLinkSession$connect$1) binds: [B:36:0x016b, B:18:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r4v10 int) = (r4v11 int), (r4v19 int) binds: [B:36:0x016b, B:18:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r6v4 int) = (r6v7 int), (r6v13 int) binds: [B:36:0x016b, B:18:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r7v3 long) = (r7v4 long), (r7v9 long) binds: [B:36:0x016b, B:18:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r10v0 int) = (r10v2 int), (r10v7 int) binds: [B:36:0x016b, B:18:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r14v1 com.nothing.link.bluetooth.sdk.connect.XConnector) = (r14v3 com.nothing.link.bluetooth.sdk.connect.XConnector), (r14v10 com.nothing.link.bluetooth.sdk.connect.XConnector) binds: [B:36:0x016b, B:18:0x0061] A[DONT_GENERATE, DONT_INLINE]
      0x0075: PHI (r15v0 com.nothing.nt_ear_ota.OtaEarLinkSession) = (r15v4 com.nothing.nt_ear_ota.OtaEarLinkSession), (r15v13 com.nothing.nt_ear_ota.OtaEarLinkSession) binds: [B:36:0x016b, B:18:0x0061] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:27:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:30:0x0105  */
    /* JADX WARN: Code duplicated, block: B:33:0x0117  */
    /* JADX WARN: Code duplicated, block: B:35:0x0139  */
    /* JADX WARN: Code duplicated, block: B:41:0x0187  */
    /* JADX WARN: Code duplicated, block: B:44:0x0194  */
    /* JADX WARN: Code duplicated, block: B:46:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0187 -> B:42:0x018c). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object connect(int r25, long r26, kotlin.coroutines.Continuation<? super java.lang.Boolean> r28) {
        /*
            Method dump skipped, instruction units count: 516
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.nt_ear_ota.OtaEarLinkSession.connect(int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object syncSend$default(OtaEarLinkSession otaEarLinkSession, byte b, byte[] bArr, AtomicInteger atomicInteger, long j, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            atomicInteger = null;
        }
        AtomicInteger atomicInteger2 = atomicInteger;
        if ((i & 8) != 0) {
            j = 5000;
        }
        return otaEarLinkSession.syncSend(b, bArr, atomicInteger2, j, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object syncSend(byte b, byte[] bArr, AtomicInteger atomicInteger, long j, Continuation<? super byte[]> continuation) {
        C09831 c09831;
        AtomicInteger atomicInteger2;
        long j2;
        int i;
        byte[] bArr2;
        byte[] bArr3;
        int i2;
        if (continuation instanceof C09831) {
            c09831 = (C09831) continuation;
            if ((c09831.label & Integer.MIN_VALUE) != 0) {
                c09831.label -= Integer.MIN_VALUE;
            } else {
                c09831 = new C09831(continuation);
            }
        } else {
            c09831 = new C09831(continuation);
        }
        Object obj = c09831.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c09831.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Byte bFirstOrNull = ArraysKt.firstOrNull(bArr);
            int iByteValue = bFirstOrNull != null ? bFirstOrNull.byteValue() & 255 : -1;
            XConnector xConnector = this.otaConnector;
            if (xConnector != null) {
                c09831.L$0 = bArr;
                c09831.L$1 = atomicInteger;
                c09831.I$0 = iByteValue;
                c09831.J$0 = j;
                c09831.label = 1;
                Object objWriteWithTask$default = XConnector.writeWithTask$default(xConnector, bArr, 0L, j, false, true, false, (String) null, (String) null, (byte[]) null, atomicInteger, false, (String) null, (ArrayList) null, (Continuation) c09831, 7360, (Object) null);
                if (objWriteWithTask$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                bArr3 = bArr;
                atomicInteger2 = atomicInteger;
                i = iByteValue;
                obj = objWriteWithTask$default;
                j2 = j;
            } else {
                atomicInteger2 = atomicInteger;
                j2 = j;
                i = iByteValue;
                bArr2 = null;
                bArr3 = bArr;
            }
            if (i == 133 && i != 130) {
                return bArr2;
            }
            if (bArr2 == null && bArr2.length != 0) {
                return bArr2;
            }
            String string = Integer.toString(i, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
            int length = bArr3.length;
            if (atomicInteger2 != null) {
                i2 = atomicInteger2.get();
            } else {
                i2 = 0;
            }
            Log.w(TAG, "syncSend timeout/empty op=0x" + string + " len=" + length + " dur=" + j2 + "ms retry=" + i2);
            return bArr2;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        j2 = c09831.J$0;
        i = c09831.I$0;
        atomicInteger2 = (AtomicInteger) c09831.L$1;
        bArr3 = (byte[]) c09831.L$0;
        ResultKt.throwOnFailure(obj);
        bArr2 = (byte[]) obj;
        if (i == 133) {
        }
        if (bArr2 == null) {
        }
        String string2 = Integer.toString(i, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
        int length2 = bArr3.length;
        if (atomicInteger2 != null) {
            i2 = atomicInteger2.get();
        } else {
            i2 = 0;
        }
        Log.w(TAG, "syncSend timeout/empty op=0x" + string2 + " len=" + length2 + " dur=" + j2 + "ms retry=" + i2);
        return bArr2;
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.OtaEarLinkSession$sendAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OtaEarLinkSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.OtaEarLinkSession$sendAsync$1", f = "OtaEarLinkSession.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
    static final class C09801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $message;
        final /* synthetic */ byte[] $mockResponse;
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09801(byte[] bArr, byte[] bArr2, Function1<? super Boolean, Unit> function1, Continuation<? super C09801> continuation) {
            super(2, continuation);
            this.$message = bArr;
            this.$mockResponse = bArr2;
            this.$onResult = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OtaEarLinkSession.this.new C09801(this.$message, this.$mockResponse, this.$onResult, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09801) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = OtaEarLinkSession.this.sendOtaLocked(this.$message, this.$mockResponse, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$onResult.invoke(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
            return Unit.INSTANCE;
        }
    }

    public final void sendAsync(byte[] message, byte[] mockResponse, Function1<? super Boolean, Unit> onResult) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09801(message, mockResponse, onResult, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object sendRawBesOtaLocked(byte[] bArr, Continuation<? super Boolean> continuation) {
        C09821 c09821;
        Mutex mutex;
        OtaEarLinkSession otaEarLinkSession;
        if (continuation instanceof C09821) {
            c09821 = (C09821) continuation;
            if ((c09821.label & Integer.MIN_VALUE) != 0) {
                c09821.label -= Integer.MIN_VALUE;
            } else {
                c09821 = new C09821(continuation);
            }
        } else {
            c09821 = new C09821(continuation);
        }
        Object obj = c09821.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09821.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            mutex = this.writeMutex;
            c09821.L$0 = this;
            c09821.L$1 = bArr;
            c09821.L$2 = mutex;
            c09821.label = 1;
            if (mutex.lock(null, c09821) == coroutine_suspended) {
                return coroutine_suspended;
            }
            otaEarLinkSession = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Mutex mutex2 = (Mutex) c09821.L$2;
            byte[] bArr2 = (byte[]) c09821.L$1;
            otaEarLinkSession = (OtaEarLinkSession) c09821.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            bArr = bArr2;
        }
        try {
            Byte bFirstOrNull = ArraysKt.firstOrNull(bArr);
            int iByteValue = bFirstOrNull != null ? bFirstOrNull.byteValue() & 255 : -1;
            XConnector xConnector = otaEarLinkSession.otaConnector;
            XBaseSppConnector xBaseSppConnector = xConnector instanceof XBaseSppConnector ? (XBaseSppConnector) xConnector : null;
            boolean z2 = false;
            if (xBaseSppConnector == null) {
                String str = otaEarLinkSession.deviceMac;
                String string = Integer.toString(iByteValue, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                Log.e(TAG, "sendRawBesOtaLocked: not SPP OTA connector mac=" + str + " op=0x" + string);
            } else {
                try {
                    xBaseSppConnector.write(otaEarLinkSession.parser.getWriterCommand("bes_raw", bArr, null));
                } catch (Exception e) {
                    String string2 = Integer.toString(iByteValue, CharsKt.checkRadix(16));
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
                    Log.e(TAG, "sendRawBesOtaLocked fail op=0x" + string2 + " mac=" + otaEarLinkSession.deviceMac, e);
                    z = false;
                }
                z2 = z;
            }
            Boolean boolBoxBoolean = Boxing.boxBoolean(z2);
            mutex.unlock(null);
            return boolBoxBoolean;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    public static /* synthetic */ Object sendOtaLocked$default(OtaEarLinkSession otaEarLinkSession, byte[] bArr, byte[] bArr2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr2 = null;
        }
        return otaEarLinkSession.sendOtaLocked(bArr, bArr2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0020  */
    public final Object sendOtaLocked(byte[] bArr, byte[] bArr2, Continuation<? super Boolean> continuation) {
        C09811 c09811;
        byte[] bArr3;
        Mutex mutex;
        OtaEarLinkSession otaEarLinkSession;
        boolean z;
        boolean z2;
        if (continuation instanceof C09811) {
            c09811 = (C09811) continuation;
            if ((c09811.label & Integer.MIN_VALUE) != 0) {
                c09811.label -= Integer.MIN_VALUE;
            } else {
                c09811 = new C09811(continuation);
            }
        } else {
            c09811 = new C09811(continuation);
        }
        Object obj = c09811.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09811.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex mutex2 = this.writeMutex;
            c09811.L$0 = this;
            bArr3 = bArr;
            c09811.L$1 = bArr3;
            c09811.L$2 = mutex2;
            c09811.label = 1;
            if (mutex2.lock(null, c09811) == coroutine_suspended) {
                return coroutine_suspended;
            }
            mutex = mutex2;
            otaEarLinkSession = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutex = (Mutex) c09811.L$2;
            bArr3 = (byte[]) c09811.L$1;
            otaEarLinkSession = (OtaEarLinkSession) c09811.L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            Byte bFirstOrNull = ArraysKt.firstOrNull(bArr3);
            int iByteValue = bFirstOrNull != null ? bFirstOrNull.byteValue() & 255 : -1;
            Byte orNull = ArraysKt.getOrNull(bArr3, 1);
            int iByteValue2 = orNull != null ? orNull.byteValue() & 255 : -1;
            if (iByteValue != 9) {
                String string = Integer.toString(iByteValue, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string, "toString(this, checkRadix(radix))");
                Log.e(TAG, "sendOtaLocked: not Acts frame op=0x" + string + " mac=" + otaEarLinkSession.deviceMac);
            } else {
                XConnector xConnector = otaEarLinkSession.otaConnector;
                XBaseSppConnector xBaseSppConnector = xConnector instanceof XBaseSppConnector ? (XBaseSppConnector) xConnector : null;
                if (xBaseSppConnector != null) {
                    try {
                        String string2 = Integer.toString(iByteValue2, CharsKt.checkRadix(16));
                        Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
                        Log.d(TAG, "tx raw op=0x09 cmd=0x" + string2 + " len=" + bArr3.length + " mac=" + otaEarLinkSession.deviceMac);
                        xBaseSppConnector.write(otaEarLinkSession.parser.getWriterCommand("acts", bArr3, null));
                        z = true;
                    } catch (Exception e) {
                        String string3 = Integer.toString(iByteValue2, CharsKt.checkRadix(16));
                        Intrinsics.checkNotNullExpressionValue(string3, "toString(this, checkRadix(radix))");
                        Log.e(TAG, "sendOtaLocked raw write fail cmd=0x" + string3 + " mac=" + otaEarLinkSession.deviceMac, e);
                        z = false;
                    }
                    z2 = z;
                    Boolean boolBoxBoolean = Boxing.boxBoolean(z2);
                    mutex.unlock(null);
                    return boolBoxBoolean;
                }
                Log.e(TAG, "sendOtaLocked: not SPP OTA connector mac=" + otaEarLinkSession.deviceMac);
            }
            z2 = false;
            Boolean boolBoxBoolean2 = Boxing.boxBoolean(z2);
            mutex.unlock(null);
            return boolBoxBoolean2;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    public final void destroy() {
        Log.i(TAG, "destroy mac=" + this.deviceMac + " spp=" + this.sppUuid);
        XConnector xConnector = this.otaConnector;
        if (xConnector != null) {
            xConnector.onDestroy();
        }
        this.otaConnector = null;
        this.bytesListener = null;
    }

    /* JADX INFO: compiled from: OtaEarLinkSession.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/nothing/nt_ear_ota/OtaEarLinkSession$Companion;", "", "<init>", "()V", "TAG", "", "macToBluetoothAddress", "mac", "nt_ear_ota_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String macToBluetoothAddress(String mac) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = mac.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(upperCase, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null), HelpFormatter.DEFAULT_OPT_PREFIX, "", false, 4, (Object) null);
            if (strReplace$default.length() != 12) {
                return null;
            }
            String str = strReplace$default;
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (!Character.isDigit(cCharAt) && ('A' > cCharAt || cCharAt >= 'G')) {
                    return null;
                }
            }
            return CollectionsKt.joinToString$default(StringsKt.chunked(str, 2), TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, null, null, 0, null, null, 62, null);
        }
    }
}
