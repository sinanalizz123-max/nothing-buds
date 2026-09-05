package com.nothing.caseble;

import android.bluetooth.le.BluetoothLeScanner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: NtCaseBleApi.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$findCaseMacForEar$2$1", f = "NtCaseBleApi.kt", i = {}, l = {357}, m = "invokeSuspend", n = {}, s = {})
final class NtCaseBleApi$findCaseMacForEar$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NtCaseBleApi$findCaseMacForEar$2$callback$1 $callback;
    final /* synthetic */ CancellableContinuation<CaseMatch> $cont;
    final /* synthetic */ long $scanTimeoutMs;
    final /* synthetic */ BluetoothLeScanner $scanner;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NtCaseBleApi$findCaseMacForEar$2$1(long j, CancellableContinuation<? super CaseMatch> cancellableContinuation, BluetoothLeScanner bluetoothLeScanner, NtCaseBleApi$findCaseMacForEar$2$callback$1 ntCaseBleApi$findCaseMacForEar$2$callback$1, Continuation<? super NtCaseBleApi$findCaseMacForEar$2$1> continuation) {
        super(2, continuation);
        this.$scanTimeoutMs = j;
        this.$cont = cancellableContinuation;
        this.$scanner = bluetoothLeScanner;
        this.$callback = ntCaseBleApi$findCaseMacForEar$2$callback$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NtCaseBleApi$findCaseMacForEar$2$1(this.$scanTimeoutMs, this.$cont, this.$scanner, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NtCaseBleApi$findCaseMacForEar$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.$scanTimeoutMs, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        if (!this.$cont.isCompleted()) {
            this.$scanner.stopScan(this.$callback);
            CancellableContinuation<CaseMatch> cancellableContinuation = this.$cont;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m6347constructorimpl(null));
        }
        return Unit.INSTANCE;
    }
}
