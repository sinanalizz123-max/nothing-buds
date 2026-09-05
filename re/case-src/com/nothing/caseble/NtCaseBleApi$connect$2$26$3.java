package com.nothing.caseble;

import com.nothing.generate.NtCaseBleConnectionState;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NtCaseBleApi.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$connect$2$26$3", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NtCaseBleApi$connect$2$26$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $currentCaseMac;
    final /* synthetic */ NtCaseBleConnectionState $pigeonState;
    final /* synthetic */ String $realMac;
    int label;
    final /* synthetic */ NtCaseBleApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NtCaseBleApi$connect$2$26$3(NtCaseBleApi ntCaseBleApi, String str, NtCaseBleConnectionState ntCaseBleConnectionState, String str2, Continuation<? super NtCaseBleApi$connect$2$26$3> continuation) {
        super(2, continuation);
        this.this$0 = ntCaseBleApi;
        this.$realMac = str;
        this.$pigeonState = ntCaseBleConnectionState;
        this.$currentCaseMac = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NtCaseBleApi$connect$2$26$3(this.this$0, this.$realMac, this.$pigeonState, this.$currentCaseMac, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NtCaseBleApi$connect$2$26$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.flutterApi.onCaseBleConnectionStateChanged(this.$realMac, this.$pigeonState, this.$currentCaseMac, new Function1() { // from class: com.nothing.caseble.NtCaseBleApi$connect$2$26$3$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NtCaseBleApi$connect$2$26$3.invokeSuspend$lambda$0((Result) obj2);
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Result result) {
        return Unit.INSTANCE;
    }
}
