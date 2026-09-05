package com.nothing.protocol.connector;

import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: HeadsetSppConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.protocol.connector.HeadsetSppConnector$connect$1$2$3", f = "HeadsetSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HeadsetSppConnector$connect$1$2$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ XConnectType $connectType;
    final /* synthetic */ XBluetoothDevice $xBluetoothDevice;
    final /* synthetic */ Ref.ObjectRef<XConnectCallback> $xConnectCallback;
    int label;
    final /* synthetic */ HeadsetSppConnector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HeadsetSppConnector$connect$1$2$3(Ref.ObjectRef<XConnectCallback> objectRef, XConnectType xConnectType, XBluetoothDevice xBluetoothDevice, HeadsetSppConnector headsetSppConnector, Continuation<? super HeadsetSppConnector$connect$1$2$3> continuation) {
        super(2, continuation);
        this.$xConnectCallback = objectRef;
        this.$connectType = xConnectType;
        this.$xBluetoothDevice = xBluetoothDevice;
        this.this$0 = headsetSppConnector;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeadsetSppConnector$connect$1$2$3(this.$xConnectCallback, this.$connectType, this.$xBluetoothDevice, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HeadsetSppConnector$connect$1$2$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        XConnectCallback xConnectCallback = this.$xConnectCallback.element;
        if (xConnectCallback != null) {
            xConnectCallback.callConnectSuccess(this.$connectType, this.$xBluetoothDevice);
        }
        HeadsetSppConnector.SocketCallback socketCallback = this.this$0.socketCallback;
        if (socketCallback != null) {
            socketCallback.connectStatus(2);
        }
        return Unit.INSTANCE;
    }
}
