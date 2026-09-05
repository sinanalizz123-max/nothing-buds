package com.nothing.protocol.connector;

import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.protocol.SPPConnect;
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
@DebugMetadata(c = "com.nothing.protocol.connector.HeadsetSppConnector$connect$1$2$2", f = "HeadsetSppConnector.kt", i = {}, l = {185, 193}, m = "invokeSuspend", n = {}, s = {})
final class HeadsetSppConnector$connect$1$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ XConnectType $connectType;
    final /* synthetic */ XBluetoothDevice $xBluetoothDevice;
    final /* synthetic */ Ref.ObjectRef<XConnectCallback> $xConnectCallback;
    int label;
    final /* synthetic */ HeadsetSppConnector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HeadsetSppConnector$connect$1$2$2(HeadsetSppConnector headsetSppConnector, Ref.ObjectRef<XConnectCallback> objectRef, XConnectType xConnectType, XBluetoothDevice xBluetoothDevice, Continuation<? super HeadsetSppConnector$connect$1$2$2> continuation) {
        super(2, continuation);
        this.this$0 = headsetSppConnector;
        this.$xConnectCallback = objectRef;
        this.$connectType = xConnectType;
        this.$xBluetoothDevice = xBluetoothDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HeadsetSppConnector$connect$1$2$2(this.this$0, this.$xConnectCallback, this.$connectType, this.$xBluetoothDevice, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HeadsetSppConnector$connect$1$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
    
        if (r5 == r0) goto L27;
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
            if (!SPPConnect.INSTANCE.getInstance().isClassicConnected(this.this$0.getMBluetoothDevice())) {
                this.label = 1;
                obj = this.this$0.connectLeAudio(true, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
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
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        if (((Boolean) obj).booleanValue()) {
            XConnectCallback xConnectCallback2 = this.$xConnectCallback.element;
            if (xConnectCallback2 != null) {
                xConnectCallback2.callConnectSuccess(this.$connectType, this.$xBluetoothDevice);
            }
            HeadsetSppConnector.SocketCallback socketCallback2 = this.this$0.socketCallback;
            if (socketCallback2 != null) {
                socketCallback2.connectStatus(2);
            }
        } else {
            XConnector xSppConnector = this.this$0.getXSppConnector();
            if (xSppConnector != null) {
                this.label = 2;
                obj = xSppConnector.disconnect(this);
            }
        }
        return Unit.INSTANCE;
    }
}
