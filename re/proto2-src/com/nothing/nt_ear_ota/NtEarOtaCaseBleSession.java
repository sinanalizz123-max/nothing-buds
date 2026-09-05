package com.nothing.nt_ear_ota;

import android.util.Log;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.nt_ear_ota.caseble.XCaseBleConnector;
import com.nothing.nt_ear_ota.caseble.XCaseBleParser;
import com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: compiled from: NtEarOtaCaseBleSession.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u000bJ\u0006\u0010\u001b\u001a\u00020\u0016J(\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\n2\u0018\u0010\u001e\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001f\u0012\u0004\u0012\u00020\u000b0\tJ \u0010 \u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0018H\u0086@\u00a2\u0006\u0002\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/nothing/nt_ear_ota/NtEarOtaCaseBleSession;", "", "sessionId", "", "caseMac", "serviceUuid", "writeUuid", "notifyUuid", "onRawBytes", "Lkotlin/Function1;", "", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "connector", "Lcom/nothing/nt_ear_ota/caseble/XCaseBleConnector;", "recvKey", "syncLock", "syncLatch", "Ljava/util/concurrent/CountDownLatch;", "syncResult", "open", "", "waitConnectedMs", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "isConnected", "sendPayload", "bytes", "callback", "Lkotlin/Result;", "syncSendPayload", "awaitMs", "([BJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "nt_ear_ota_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NtEarOtaCaseBleSession {
    private static final String TAG = "NtEarOtaCaseSession";
    private final String caseMac;
    private final XCaseBleConnector connector;
    private final String notifyUuid;
    private final Function1<byte[], Unit> onRawBytes;
    private final String recvKey;
    private final String serviceUuid;
    private final String sessionId;
    private CountDownLatch syncLatch;
    private final Object syncLock;
    private byte[] syncResult;
    private final String writeUuid;

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarOtaCaseBleSession.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaCaseBleSession", f = "NtEarOtaCaseBleSession.kt", i = {0, 0}, l = {33, 65}, m = "open", n = {"this", "waitConnectedMs"}, s = {"L$0", "J$0"})
    static final class C09721 extends ContinuationImpl {
        long J$0;
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C09721(Continuation<? super C09721> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NtEarOtaCaseBleSession.this.open(0L, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NtEarOtaCaseBleSession(String sessionId, String caseMac, String str, String str2, String str3, Function1<? super byte[], Unit> onRawBytes) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(caseMac, "caseMac");
        Intrinsics.checkNotNullParameter(onRawBytes, "onRawBytes");
        this.sessionId = sessionId;
        this.caseMac = caseMac;
        this.serviceUuid = str;
        this.writeUuid = str2;
        this.notifyUuid = str3;
        this.onRawBytes = onRawBytes;
        this.connector = new XCaseBleConnector(new XCaseBleParser(), "nt_ear_ota_case_" + sessionId);
        this.recvKey = "nt_ear_ota_case_recv_" + sessionId;
        this.syncLock = new Object();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object open(long j, Continuation<? super Boolean> continuation) {
        C09721 c09721;
        NtEarOtaCaseBleSession ntEarOtaCaseBleSession;
        if (continuation instanceof C09721) {
            c09721 = (C09721) continuation;
            if ((c09721.label & Integer.MIN_VALUE) != 0) {
                c09721.label -= Integer.MIN_VALUE;
            } else {
                c09721 = new C09721(continuation);
            }
        } else {
            c09721 = new C09721(continuation);
        }
        Object objWithContext = c09721.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09721.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objWithContext);
            MainCoroutineDispatcher main = Dispatchers.getMain();
            NtEarOtaCaseBleSession$open$prepared$1 ntEarOtaCaseBleSession$open$prepared$1 = new NtEarOtaCaseBleSession$open$prepared$1(this, null);
            c09721.L$0 = this;
            c09721.J$0 = j;
            c09721.label = 1;
            objWithContext = BuildersKt.withContext(main, ntEarOtaCaseBleSession$open$prepared$1, c09721);
            if (objWithContext != coroutine_suspended) {
                ntEarOtaCaseBleSession = this;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objWithContext);
            return objWithContext;
        }
        j = c09721.J$0;
        ntEarOtaCaseBleSession = (NtEarOtaCaseBleSession) c09721.L$0;
        ResultKt.throwOnFailure(objWithContext);
        if (!((Boolean) objWithContext).booleanValue()) {
            return Boxing.boxBoolean(false);
        }
        CoroutineDispatcher io2 = Dispatchers.getIO();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(j, ntEarOtaCaseBleSession, null);
        c09721.L$0 = null;
        c09721.label = 2;
        Object objWithContext2 = BuildersKt.withContext(io2, anonymousClass2, c09721);
        return objWithContext2 == coroutine_suspended ? coroutine_suspended : objWithContext2;
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$2, reason: invalid class name */
    /* JADX INFO: compiled from: NtEarOtaCaseBleSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$2", f = "NtEarOtaCaseBleSession.kt", i = {0}, l = {69}, m = "invokeSuspend", n = {"deadline"}, s = {"J$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ long $waitConnectedMs;
        long J$0;
        int label;
        final /* synthetic */ NtEarOtaCaseBleSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(long j, NtEarOtaCaseBleSession ntEarOtaCaseBleSession, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$waitConnectedMs = j;
            this.this$0 = ntEarOtaCaseBleSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$waitConnectedMs, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            long jCurrentTimeMillis;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                jCurrentTimeMillis = System.currentTimeMillis() + this.$waitConnectedMs;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jCurrentTimeMillis = this.J$0;
                ResultKt.throwOnFailure(obj);
            }
            while (System.currentTimeMillis() < jCurrentTimeMillis) {
                if (this.this$0.connector.getLastState().get() == 2) {
                    return Boxing.boxBoolean(true);
                }
                this.J$0 = jCurrentTimeMillis;
                this.label = 1;
                if (DelayKt.delay(100L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(false);
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: NtEarOtaCaseBleSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$close$1", f = "NtEarOtaCaseBleSession.kt", i = {}, l = {UltraBassComponents.BASS_BOOST_LEVEL4_PROGRESS}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = NtEarOtaCaseBleSession.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    NtEarOtaCaseBleSession ntEarOtaCaseBleSession = NtEarOtaCaseBleSession.this;
                    Result.Companion companion = Result.INSTANCE;
                    XCaseBleConnector xCaseBleConnector = ntEarOtaCaseBleSession.connector;
                    this.label = 1;
                    obj = xCaseBleConnector.disconnect(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Result.m6347constructorimpl(Boxing.boxBoolean(((Boolean) obj).booleanValue()));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }

    public final void close() {
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(null), 3, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            NtEarOtaCaseBleSession ntEarOtaCaseBleSession = this;
            this.connector.onDestroy();
            Result.m6347constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
    }

    public final boolean isConnected() {
        return this.connector.getLastState().get() == 2;
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$sendPayload$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarOtaCaseBleSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$sendPayload$1", f = "NtEarOtaCaseBleSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $bytes;
        final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09731(Function1<? super Result<Unit>, Unit> function1, byte[] bArr, Continuation<? super C09731> continuation) {
            super(2, continuation);
            this.$callback = function1;
            this.$bytes = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarOtaCaseBleSession.this.new C09731(this.$callback, this.$bytes, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                if (!NtEarOtaCaseBleSession.this.isConnected()) {
                    Log.e(NtEarOtaCaseBleSession.TAG, "case send ignored: not connected session=" + NtEarOtaCaseBleSession.this.sessionId);
                    Function1<Result<Unit>, Unit> function1 = this.$callback;
                    Result.Companion companion = Result.INSTANCE;
                    function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(new IllegalStateException("case BLE not connected")))));
                    return Unit.INSTANCE;
                }
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                XCaseBleConnector xCaseBleConnector = NtEarOtaCaseBleSession.this.connector;
                byte[] bArr = this.$bytes;
                String serviceUUID = NtEarOtaCaseBleSession.this.connector.getServiceUUID();
                String writeUUID = NtEarOtaCaseBleSession.this.connector.getWriteUUID();
                final Function1<Result<Unit>, Unit> function2 = this.$callback;
                final NtEarOtaCaseBleSession ntEarOtaCaseBleSession = NtEarOtaCaseBleSession.this;
                xCaseBleConnector.writeWithTask(bArr, -1L, -1L, true, true, true, serviceUUID, writeUUID, (byte[]) null, (AtomicInteger) null, true, (String) null, (ArrayList<String>) null, new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$sendPayload$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtEarOtaCaseBleSession.C09731.invokeSuspend$lambda$2(atomicBoolean, function2, ntEarOtaCaseBleSession, (XWriteCallback) obj2);
                    }
                });
                return Unit.INSTANCE;
            } catch (Exception e) {
                String str = NtEarOtaCaseBleSession.this.sessionId;
                String message = e.getMessage();
                Exception exc = e;
                Log.e(NtEarOtaCaseBleSession.TAG, "case send exception session=" + str + " err=" + message, exc);
                Function1<Result<Unit>, Unit> function3 = this.$callback;
                Result.Companion companion2 = Result.INSTANCE;
                function3.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(exc))));
            }
        }

        static /* synthetic */ void invokeSuspend$fire$default(AtomicBoolean atomicBoolean, Function1 function1, NtEarOtaCaseBleSession ntEarOtaCaseBleSession, boolean z, Throwable th, int i, Object obj) {
            if ((i & 16) != 0) {
                th = null;
            }
            invokeSuspend$fire(atomicBoolean, function1, ntEarOtaCaseBleSession, z, th);
        }

        private static final void invokeSuspend$fire(AtomicBoolean atomicBoolean, Function1<? super Result<Unit>, Unit> function1, NtEarOtaCaseBleSession ntEarOtaCaseBleSession, boolean z, Throwable th) {
            if (atomicBoolean.compareAndSet(false, true)) {
                if (!z) {
                    Log.e(NtEarOtaCaseBleSession.TAG, "case write failed session=" + ntEarOtaCaseBleSession.sessionId + " err=" + (th != null ? th.getMessage() : null), th);
                    Result.Companion companion = Result.INSTANCE;
                    if (th == null) {
                        th = new RuntimeException("case write failed");
                    }
                    function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(th))));
                    return;
                }
                Result.Companion companion2 = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(final AtomicBoolean atomicBoolean, final Function1 function1, final NtEarOtaCaseBleSession ntEarOtaCaseBleSession, XWriteCallback xWriteCallback) {
            xWriteCallback.onWriteComplete(new Function2() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$sendPayload$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NtEarOtaCaseBleSession.C09731.invokeSuspend$lambda$2$lambda$0(atomicBoolean, function1, ntEarOtaCaseBleSession, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue());
                }
            });
            xWriteCallback.onWriteFail(new Function4() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$sendPayload$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return NtEarOtaCaseBleSession.C09731.invokeSuspend$lambda$2$lambda$1(atomicBoolean, function1, ntEarOtaCaseBleSession, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2$lambda$0(AtomicBoolean atomicBoolean, Function1 function1, NtEarOtaCaseBleSession ntEarOtaCaseBleSession, XBluetoothDevice xBluetoothDevice, boolean z) {
            invokeSuspend$fire$default(atomicBoolean, function1, ntEarOtaCaseBleSession, z, null, 16, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2$lambda$1(AtomicBoolean atomicBoolean, Function1 function1, NtEarOtaCaseBleSession ntEarOtaCaseBleSession, XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable th) {
            invokeSuspend$fire(atomicBoolean, function1, ntEarOtaCaseBleSession, false, th);
            return Unit.INSTANCE;
        }
    }

    public final void sendPayload(byte[] bytes, Function1<? super Result<Unit>, Unit> callback) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new C09731(callback, bytes, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$syncSendPayload$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NtEarOtaCaseBleSession.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$syncSendPayload$2", f = "NtEarOtaCaseBleSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        final /* synthetic */ long $awaitMs;
        final /* synthetic */ byte[] $bytes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09742(long j, byte[] bArr, Continuation<? super C09742> continuation) {
            super(2, continuation);
            this.$awaitMs = j;
            this.$bytes = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NtEarOtaCaseBleSession.this.new C09742(this.$awaitMs, this.$bytes, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((C09742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte[] bArr;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Object obj2 = NtEarOtaCaseBleSession.this.syncLock;
            NtEarOtaCaseBleSession ntEarOtaCaseBleSession = NtEarOtaCaseBleSession.this;
            synchronized (obj2) {
                ntEarOtaCaseBleSession.syncResult = null;
                ntEarOtaCaseBleSession.syncLatch = countDownLatch;
                Unit unit = Unit.INSTANCE;
            }
            CountDownLatch countDownLatch2 = new CountDownLatch(1);
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), Dispatchers.getMain(), null, new C01912(NtEarOtaCaseBleSession.this, booleanRef, countDownLatch2, countDownLatch, this.$bytes, null), 2, null);
            try {
                long j = 2;
                if (countDownLatch2.await(this.$awaitMs / j, TimeUnit.MILLISECONDS) && !booleanRef.element) {
                    if (!countDownLatch.await(this.$awaitMs / j, TimeUnit.MILLISECONDS)) {
                        Object obj3 = NtEarOtaCaseBleSession.this.syncLock;
                        NtEarOtaCaseBleSession ntEarOtaCaseBleSession2 = NtEarOtaCaseBleSession.this;
                        synchronized (obj3) {
                            ntEarOtaCaseBleSession2.syncLatch = null;
                            ntEarOtaCaseBleSession2.syncResult = null;
                            Unit unit2 = Unit.INSTANCE;
                        }
                        return null;
                    }
                    Object obj4 = NtEarOtaCaseBleSession.this.syncLock;
                    NtEarOtaCaseBleSession ntEarOtaCaseBleSession3 = NtEarOtaCaseBleSession.this;
                    synchronized (obj4) {
                        bArr = ntEarOtaCaseBleSession3.syncResult;
                    }
                    Object obj5 = NtEarOtaCaseBleSession.this.syncLock;
                    NtEarOtaCaseBleSession ntEarOtaCaseBleSession4 = NtEarOtaCaseBleSession.this;
                    synchronized (obj5) {
                        ntEarOtaCaseBleSession4.syncLatch = null;
                        ntEarOtaCaseBleSession4.syncResult = null;
                        Unit unit3 = Unit.INSTANCE;
                    }
                    return bArr;
                }
                Object obj6 = NtEarOtaCaseBleSession.this.syncLock;
                NtEarOtaCaseBleSession ntEarOtaCaseBleSession5 = NtEarOtaCaseBleSession.this;
                synchronized (obj6) {
                    ntEarOtaCaseBleSession5.syncLatch = null;
                    ntEarOtaCaseBleSession5.syncResult = null;
                    Unit unit4 = Unit.INSTANCE;
                }
                return null;
            } catch (Throwable th) {
                Object obj7 = NtEarOtaCaseBleSession.this.syncLock;
                NtEarOtaCaseBleSession ntEarOtaCaseBleSession6 = NtEarOtaCaseBleSession.this;
                synchronized (obj7) {
                    ntEarOtaCaseBleSession6.syncLatch = null;
                    ntEarOtaCaseBleSession6.syncResult = null;
                    Unit unit5 = Unit.INSTANCE;
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$syncSendPayload$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NtEarOtaCaseBleSession.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$syncSendPayload$2$2", f = "NtEarOtaCaseBleSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01912 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ byte[] $bytes;
            final /* synthetic */ CountDownLatch $responseLatch;
            final /* synthetic */ Ref.BooleanRef $sendFailed;
            final /* synthetic */ CountDownLatch $sendLatch;
            int label;
            final /* synthetic */ NtEarOtaCaseBleSession this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01912(NtEarOtaCaseBleSession ntEarOtaCaseBleSession, Ref.BooleanRef booleanRef, CountDownLatch countDownLatch, CountDownLatch countDownLatch2, byte[] bArr, Continuation<? super C01912> continuation) {
                super(2, continuation);
                this.this$0 = ntEarOtaCaseBleSession;
                this.$sendFailed = booleanRef;
                this.$sendLatch = countDownLatch;
                this.$responseLatch = countDownLatch2;
                this.$bytes = bArr;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01912(this.this$0, this.$sendFailed, this.$sendLatch, this.$responseLatch, this.$bytes, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01912) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                try {
                    if (this.this$0.isConnected()) {
                        XCaseBleConnector xCaseBleConnector = this.this$0.connector;
                        byte[] bArr = this.$bytes;
                        String serviceUUID = this.this$0.connector.getServiceUUID();
                        String writeUUID = this.this$0.connector.getWriteUUID();
                        final Ref.BooleanRef booleanRef = this.$sendFailed;
                        final CountDownLatch countDownLatch = this.$sendLatch;
                        final CountDownLatch countDownLatch2 = this.$responseLatch;
                        xCaseBleConnector.writeWithTask(bArr, -1L, -1L, true, true, true, serviceUUID, writeUUID, (byte[]) null, (AtomicInteger) null, true, (String) null, (ArrayList<String>) null, new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$syncSendPayload$2$2$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return NtEarOtaCaseBleSession.C09742.C01912.invokeSuspend$lambda$2(booleanRef, countDownLatch, countDownLatch2, (XWriteCallback) obj2);
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    this.$sendFailed.element = true;
                    this.$sendLatch.countDown();
                    this.$responseLatch.countDown();
                    return Unit.INSTANCE;
                } catch (Exception unused) {
                    this.$sendFailed.element = true;
                    this.$sendLatch.countDown();
                    this.$responseLatch.countDown();
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$2(final Ref.BooleanRef booleanRef, final CountDownLatch countDownLatch, final CountDownLatch countDownLatch2, XWriteCallback xWriteCallback) {
                xWriteCallback.onWriteComplete(new Function2() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$syncSendPayload$2$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NtEarOtaCaseBleSession.C09742.C01912.invokeSuspend$lambda$2$lambda$0(booleanRef, countDownLatch, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue());
                    }
                });
                xWriteCallback.onWriteFail(new Function4() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$syncSendPayload$2$2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return NtEarOtaCaseBleSession.C09742.C01912.invokeSuspend$lambda$2$lambda$1(booleanRef, countDownLatch, countDownLatch2, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
                    }
                });
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$2$lambda$0(Ref.BooleanRef booleanRef, CountDownLatch countDownLatch, XBluetoothDevice xBluetoothDevice, boolean z) {
                if (!z) {
                    booleanRef.element = true;
                }
                countDownLatch.countDown();
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$2$lambda$1(Ref.BooleanRef booleanRef, CountDownLatch countDownLatch, CountDownLatch countDownLatch2, XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable th) {
                booleanRef.element = true;
                countDownLatch.countDown();
                countDownLatch2.countDown();
                return Unit.INSTANCE;
            }
        }
    }

    public final Object syncSendPayload(byte[] bArr, long j, Continuation<? super byte[]> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C09742(j, bArr, null), continuation);
    }
}
