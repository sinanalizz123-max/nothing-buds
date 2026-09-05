package com.nothing.nt_ble.plugin;

import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.network.core.ApiResponseKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: EarphonesPluginImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.nt_ble.plugin.EarphonesPluginImpl$turnOffSpp$1$1", f = "EarphonesPluginImpl.kt", i = {}, l = {ApiResponseKt.LOGIN_FAIL, ApiResponseKt.CHECK_NEW_USER_NAME_FAIL}, m = "invokeSuspend", n = {}, s = {})
final class EarphonesPluginImpl$turnOffSpp$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
    final /* synthetic */ String $realMac;
    int label;
    final /* synthetic */ EarphonesPluginImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    EarphonesPluginImpl$turnOffSpp$1$1(EarphonesPluginImpl earphonesPluginImpl, String str, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super EarphonesPluginImpl$turnOffSpp$1$1> continuation) {
        super(2, continuation);
        this.this$0 = earphonesPluginImpl;
        this.$realMac = str;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarphonesPluginImpl$turnOffSpp$1$1(this.this$0, this.$realMac, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EarphonesPluginImpl$turnOffSpp$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0072, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ble.plugin.EarphonesPluginImpl$turnOffSpp$1$1.AnonymousClass1(r11.$callback, null), r11) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String otaIdentity = this.this$0.getSppService().getOtaIdentity();
            if (otaIdentity == null) {
                otaIdentity = "";
            }
            String str = otaIdentity;
            this.label = 1;
            if (XConnectorDevice.sppOTA$default(XBluetoothManager.INSTANCE.get().getDevice(this.$realMac), str, null, 0, this.this$0.commandParser, 6, null).disconnect(this) != coroutine_suspended) {
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
        this.label = 2;
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.EarphonesPluginImpl$turnOffSpp$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: EarphonesPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.EarphonesPluginImpl$turnOffSpp$1$1$1", f = "EarphonesPluginImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Function1<? super Result<Boolean>, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$callback, continuation);
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
            Function1<Result<Boolean>, Unit> function1 = this.$callback;
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.Companion companion2 = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boxing.boxBoolean(true))));
                Result.m6347constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            return Unit.INSTANCE;
        }
    }
}
