package com.nothing.caseble;

import android.util.Log;
import com.nothing.generate.NtPeerLinkScanItem;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: NtPeerLinkBleApi.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.caseble.NtPeerLinkBleApi$startScan$cb$1$onScanResult$2", f = "NtPeerLinkBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NtPeerLinkBleApi$startScan$cb$1$onScanResult$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ NtPeerLinkScanItem $item;
    int label;
    final /* synthetic */ NtPeerLinkBleApi this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NtPeerLinkBleApi$startScan$cb$1$onScanResult$2(NtPeerLinkBleApi ntPeerLinkBleApi, NtPeerLinkScanItem ntPeerLinkScanItem, Continuation<? super NtPeerLinkBleApi$startScan$cb$1$onScanResult$2> continuation) {
        super(2, continuation);
        this.this$0 = ntPeerLinkBleApi;
        this.$item = ntPeerLinkScanItem;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NtPeerLinkBleApi$startScan$cb$1$onScanResult$2(this.this$0, this.$item, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NtPeerLinkBleApi$startScan$cb$1$onScanResult$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.flutterApi.onPeerLinkScanItem(this.$item, new Function1() { // from class: com.nothing.caseble.NtPeerLinkBleApi$startScan$cb$1$onScanResult$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NtPeerLinkBleApi$startScan$cb$1$onScanResult$2.invokeSuspend$lambda$1((Result) obj2);
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
                String str = "[PeerLink] onPeerLinkScanItem pigeon error " + (thM6350exceptionOrNullimpl != null ? thM6350exceptionOrNullimpl.getMessage() : null);
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
