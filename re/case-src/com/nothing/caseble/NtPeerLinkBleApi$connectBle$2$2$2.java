package com.nothing.caseble;

import com.nothing.generate.NtPeerLinkBleConnectionState;
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

/* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$2$2", f = "NtPeerLinkBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NtPeerLinkBleApi$connectBle$2$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $ck;
    final /* synthetic */ String $pb;
    final /* synthetic */ NtPeerLinkBleConnectionState $pigeon;
    int label;
    final /* synthetic */ NtPeerLinkBleApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NtPeerLinkBleApi$connectBle$2$2$2(NtPeerLinkBleApi ntPeerLinkBleApi, String str, NtPeerLinkBleConnectionState ntPeerLinkBleConnectionState, String str2, Continuation<? super NtPeerLinkBleApi$connectBle$2$2$2> continuation) {
        super(2, continuation);
        this.this$0 = ntPeerLinkBleApi;
        this.$ck = str;
        this.$pigeon = ntPeerLinkBleConnectionState;
        this.$pb = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NtPeerLinkBleApi$connectBle$2$2$2(this.this$0, this.$ck, this.$pigeon, this.$pb, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NtPeerLinkBleApi$connectBle$2$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.flutterApi.onPeerLinkBleConnectionStateChanged(this.$ck, this.$pigeon, this.$pb, new Function1() { // from class: com.nothing.caseble.NtPeerLinkBleApi$connectBle$2$2$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NtPeerLinkBleApi$connectBle$2$2$2.invokeSuspend$lambda$0((Result) obj2);
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
