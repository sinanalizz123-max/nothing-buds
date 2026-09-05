package com.nothing.link.bluetooth.sdk.connect.bt;

import android.bluetooth.BluetoothDevice;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: XBTReceiverHelper.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$getConnectedState$2$1", f = "XBTReceiverHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class XBTReceiverHelper$getConnectedState$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ BluetoothDevice $device;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    XBTReceiverHelper$getConnectedState$2$1(BluetoothDevice bluetoothDevice, Continuation<? super XBTReceiverHelper$getConnectedState$2$1> continuation) {
        super(2, continuation);
        this.$device = bluetoothDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        XBTReceiverHelper$getConnectedState$2$1 xBTReceiverHelper$getConnectedState$2$1 = new XBTReceiverHelper$getConnectedState$2$1(this.$device, continuation);
        xBTReceiverHelper$getConnectedState$2$1.L$0 = obj;
        return xBTReceiverHelper$getConnectedState$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((XBTReceiverHelper$getConnectedState$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws NoSuchMethodException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Method declaredMethod = this.$device.getClass().getDeclaredMethod("isConnected", new Class[0]);
        declaredMethod.setAccessible(true);
        return Boxing.boxBoolean(Intrinsics.areEqual(declaredMethod.invoke(coroutineScope, new Object[0]), Boxing.boxBoolean(true)));
    }
}
