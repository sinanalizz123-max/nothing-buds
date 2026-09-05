package com.nothing.link.bluetooth.sdk.connect;

import android.bluetooth.BluetoothGatt;
import androidx.core.app.NotificationCompat;
import com.nothing.link.bluetooth.sdk.connect.tranform.XBaseCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: XConnectCallback.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u001a\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J\u001a\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J,\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J,\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J@\u0010 \u001a\u00020\u000b28\u0010!\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004J\u0014\u0010\"\u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019J@\u0010#\u001a\u00020\u000b28\u0010!\u001a4\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b0\u0004Jl\u0010$\u001a\u00020\u000b2d\u0010!\u001a`\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b0\u0010Jl\u0010&\u001a\u00020\u000b2d\u0010!\u001a`\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b0\u0010RB\u0010\u0003\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000RB\u0010\f\u001a6\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000Rn\u0010\u000f\u001ab\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000Rn\u0010\u0017\u001ab\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\u0013\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XBaseCallback;", "()V", "connectFail", "Lkotlin/Function2;", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "Lkotlin/ParameterName;", "name", "xBluetoothDevice", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "connectFailType", "", "connectSuccess", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "connectType", "disConnected", "Lkotlin/Function4;", "", "isActiveDisConnected", "Landroid/bluetooth/BluetoothGatt;", "gatt", "", NotificationCompat.CATEGORY_STATUS, "disConnecting", "start", "Lkotlin/Function0;", "callConnectFail", "callConnectStart", "callConnectSuccess", "type", "callDisConnected", "callDisConnecting", "onConnectFail", "value", "onConnectStart", "onConnectSuccess", "onDisConnected", "device", "onDisConnecting", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XConnectCallback extends XBaseCallback {
    private Function2<? super XBluetoothDevice, ? super XConnectFailType, Unit> connectFail;
    private Function2<? super XConnectType, ? super XBluetoothDevice, Unit> connectSuccess;
    private Function4<? super Boolean, ? super XBluetoothDevice, ? super BluetoothGatt, ? super Integer, Unit> disConnected;
    private Function4<? super Boolean, ? super XBluetoothDevice, ? super BluetoothGatt, ? super Integer, Unit> disConnecting;
    private Function0<Unit> start;

    public final void onConnectSuccess(Function2<? super XConnectType, ? super XBluetoothDevice, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.connectSuccess = value;
    }

    public final void onConnectStart(Function0<Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.start = value;
    }

    public final void onConnectFail(Function2<? super XBluetoothDevice, ? super XConnectFailType, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.connectFail = value;
    }

    public final void onDisConnecting(Function4<? super Boolean, ? super XBluetoothDevice, ? super BluetoothGatt, ? super Integer, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.disConnecting = value;
    }

    public final void onDisConnected(Function4<? super Boolean, ? super XBluetoothDevice, ? super BluetoothGatt, ? super Integer, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.disConnected = value;
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnectCallback$callConnectStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XConnectCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnectCallback$callConnectStart$1", f = "XConnectCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08711(Continuation<? super C08711> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XConnectCallback.this.new C08711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function0 function0 = XConnectCallback.this.start;
                if (function0 != null) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callConnectStart() {
        launchInMainThread(new C08711(null));
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnectCallback$callConnectFail$1, reason: invalid class name */
    /* JADX INFO: compiled from: XConnectCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnectCallback$callConnectFail$1", f = "XConnectCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XConnectFailType $connectFailType;
        final /* synthetic */ XBluetoothDevice $xBluetoothDevice;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(XBluetoothDevice xBluetoothDevice, XConnectFailType xConnectFailType, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$xBluetoothDevice = xBluetoothDevice;
            this.$connectFailType = xConnectFailType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XConnectCallback.this.new AnonymousClass1(this.$xBluetoothDevice, this.$connectFailType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 function2 = XConnectCallback.this.connectFail;
                if (function2 != null) {
                    function2.invoke(this.$xBluetoothDevice, this.$connectFailType);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callConnectFail(XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        launchInMainThread(new AnonymousClass1(xBluetoothDevice, connectFailType, null));
    }

    public void callConnectSuccess(XConnectType type, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(type, "type");
        Function2<? super XConnectType, ? super XBluetoothDevice, Unit> function2 = this.connectSuccess;
        if (function2 != null) {
            function2.invoke(type, xBluetoothDevice);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnectCallback$callDisConnecting$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XConnectCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnectCallback$callDisConnecting$1", f = "XConnectCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BluetoothGatt $gatt;
        final /* synthetic */ boolean $isActiveDisConnected;
        final /* synthetic */ int $status;
        final /* synthetic */ XBluetoothDevice $xBluetoothDevice;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08731(boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i, Continuation<? super C08731> continuation) {
            super(2, continuation);
            this.$isActiveDisConnected = z;
            this.$xBluetoothDevice = xBluetoothDevice;
            this.$gatt = bluetoothGatt;
            this.$status = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XConnectCallback.this.new C08731(this.$isActiveDisConnected, this.$xBluetoothDevice, this.$gatt, this.$status, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function4 function4 = XConnectCallback.this.disConnecting;
                if (function4 != null) {
                    function4.invoke(Boxing.boxBoolean(this.$isActiveDisConnected), this.$xBluetoothDevice, this.$gatt, Boxing.boxInt(this.$status));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callDisConnecting(boolean isActiveDisConnected, XBluetoothDevice xBluetoothDevice, BluetoothGatt gatt, int status) {
        launchInMainThread(new C08731(isActiveDisConnected, xBluetoothDevice, gatt, status, null));
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnectCallback$callDisConnected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XConnectCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnectCallback$callDisConnected$1", f = "XConnectCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BluetoothGatt $gatt;
        final /* synthetic */ boolean $isActiveDisConnected;
        final /* synthetic */ int $status;
        final /* synthetic */ XBluetoothDevice $xBluetoothDevice;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08721(boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i, Continuation<? super C08721> continuation) {
            super(2, continuation);
            this.$isActiveDisConnected = z;
            this.$xBluetoothDevice = xBluetoothDevice;
            this.$gatt = bluetoothGatt;
            this.$status = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XConnectCallback.this.new C08721(this.$isActiveDisConnected, this.$xBluetoothDevice, this.$gatt, this.$status, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function4 function4 = XConnectCallback.this.disConnected;
                if (function4 != null) {
                    function4.invoke(Boxing.boxBoolean(this.$isActiveDisConnected), this.$xBluetoothDevice, this.$gatt, Boxing.boxInt(this.$status));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callDisConnected(boolean isActiveDisConnected, XBluetoothDevice xBluetoothDevice, BluetoothGatt gatt, int status) {
        launchInMainThread(new C08721(isActiveDisConnected, xBluetoothDevice, gatt, status, null));
    }
}
