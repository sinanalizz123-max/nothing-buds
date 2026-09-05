package com.nothing.link.bluetooth.sdk.task;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: XCommonTaskCallback.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0011\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\"\u0010\u0012\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J@\u0010\u0014\u001a\u00020\u000b28\u0010\u0015\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004JU\u0010\u0016\u001a\u00020\u000b2M\u0010\u0015\u001aI\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\rRB\u0010\u0003\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000RW\u0010\f\u001aK\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskCallback;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XBaseCallback;", "()V", "fail", "Lkotlin/Function2;", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "Lkotlin/ParameterName;", "name", "device", "", "throwable", "", "success", "Lkotlin/Function3;", "", "", "data", "callFail", "callSuccess", "isSuccess", "onFail", "value", "onSuccess", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XCommonTaskCallback extends XBaseCallback {
    private Function2<? super XBluetoothDevice, ? super Throwable, Unit> fail;
    private Function3<? super XBluetoothDevice, ? super Boolean, Object, Unit> success;

    public final void onFail(Function2<? super XBluetoothDevice, ? super Throwable, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.fail = value;
    }

    public final void onSuccess(Function3<? super XBluetoothDevice, ? super Boolean, Object, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.success = value;
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.task.XCommonTaskCallback$callFail$1, reason: invalid class name */
    /* JADX INFO: compiled from: XCommonTaskCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XCommonTaskCallback$callFail$1", f = "XCommonTaskCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XBluetoothDevice $device;
        final /* synthetic */ Throwable $throwable;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(XBluetoothDevice xBluetoothDevice, Throwable th, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$device = xBluetoothDevice;
            this.$throwable = th;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XCommonTaskCallback.this.new AnonymousClass1(this.$device, this.$throwable, continuation);
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
                Function2 function2 = XCommonTaskCallback.this.fail;
                if (function2 != null) {
                    function2.invoke(this.$device, this.$throwable);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callFail(XBluetoothDevice device, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        launchInMainThread(new AnonymousClass1(device, throwable, null));
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.task.XCommonTaskCallback$callSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XCommonTaskCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.task.XCommonTaskCallback$callSuccess$1", f = "XCommonTaskCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Object $data;
        final /* synthetic */ XBluetoothDevice $device;
        final /* synthetic */ boolean $isSuccess;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09211(XBluetoothDevice xBluetoothDevice, boolean z, Object obj, Continuation<? super C09211> continuation) {
            super(2, continuation);
            this.$device = xBluetoothDevice;
            this.$isSuccess = z;
            this.$data = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XCommonTaskCallback.this.new C09211(this.$device, this.$isSuccess, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function3 function3 = XCommonTaskCallback.this.success;
                if (function3 != null) {
                    function3.invoke(this.$device, Boxing.boxBoolean(this.$isSuccess), this.$data);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callSuccess(XBluetoothDevice device, boolean isSuccess, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        launchInMainThread(new C09211(device, isSuccess, data, null));
    }
}
