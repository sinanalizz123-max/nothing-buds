package com.nothing.link.bluetooth.sdk.scan;

import android.bluetooth.le.ScanResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: XBleScan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XBleScan$scanCallback$1$onScanResult$1$1", f = "XBleScan.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class XBleScan$scanCallback$1$onScanResult$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScanResult $it;
    int label;
    final /* synthetic */ XBleScan$scanCallback$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XBleScan$scanCallback$1$onScanResult$1$1(XBleScan$scanCallback$1 xBleScan$scanCallback$1, ScanResult scanResult, Continuation<? super XBleScan$scanCallback$1$onScanResult$1$1> continuation) {
        super(2, continuation);
        this.this$0 = xBleScan$scanCallback$1;
        this.$it = scanResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new XBleScan$scanCallback$1$onScanResult$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((XBleScan$scanCallback$1$onScanResult$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.checkSameData(this.$it)) {
                return Unit.INSTANCE;
            }
            this.this$0.callResult(this.$it);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
