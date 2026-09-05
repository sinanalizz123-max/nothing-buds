package com.nothing.caseble;

import android.util.Log;
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

/* JADX INFO: compiled from: NtCaseBleApi.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.caseble.NtCaseBleApi$sendData$4$fireCallback$1", f = "NtCaseBleApi.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NtCaseBleApi$sendData$4$fireCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Result<Unit>, Unit> $callback;
    final /* synthetic */ String $caseMac;
    final /* synthetic */ Throwable $error;
    final /* synthetic */ String $realMac;
    final /* synthetic */ boolean $success;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    NtCaseBleApi$sendData$4$fireCallback$1(boolean z, Function1<? super Result<Unit>, Unit> function1, Throwable th, String str, String str2, Continuation<? super NtCaseBleApi$sendData$4$fireCallback$1> continuation) {
        super(2, continuation);
        this.$success = z;
        this.$callback = function1;
        this.$error = th;
        this.$realMac = str;
        this.$caseMac = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NtCaseBleApi$sendData$4$fireCallback$1(this.$success, this.$callback, this.$error, this.$realMac, this.$caseMac, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NtCaseBleApi$sendData$4$fireCallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$success) {
            Logger logger = Logger.INSTANCE;
            String str = this.$realMac;
            String str2 = this.$caseMac;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str3 = "[CaseBle][NtCaseBleApi] sendData complete realMac=" + str + " caseMac=" + str2 + " success=true";
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
            Function1<Result<Unit>, Unit> function1 = this.$callback;
            Result.Companion companion = Result.INSTANCE;
            function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Unit.INSTANCE)));
        } else {
            Logger logger2 = Logger.INSTANCE;
            String str6 = this.$realMac;
            String str7 = this.$caseMac;
            Throwable th = this.$error;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str8 = "[CaseBle][NtCaseBleApi] sendData complete realMac=" + str6 + " caseMac=" + str7 + " success=false error=" + (th != null ? th.getMessage() : null);
                String str9 = str8;
                if (str9 != null && str9.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str10 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    FileLog.print$default(fileLog2, 6, str10, tag2, str8 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.e(tag2 + strComponent3, str8 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            Function1<Result<Unit>, Unit> function2 = this.$callback;
            Result.Companion companion2 = Result.INSTANCE;
            RuntimeException runtimeException = this.$error;
            if (runtimeException == null) {
                runtimeException = new RuntimeException("Write failed");
            }
            function2.invoke(Result.m6346boximpl(Result.m6347constructorimpl(ResultKt.createFailure(runtimeException))));
        }
        return Unit.INSTANCE;
    }
}
