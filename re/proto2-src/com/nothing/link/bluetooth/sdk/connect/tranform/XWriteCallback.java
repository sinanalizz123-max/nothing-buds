package com.nothing.link.bluetooth.sdk.connect.tranform;

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
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: XWriteCallback.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0016\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J*\u0010\u0017\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J*\u0010\u0018\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J@\u0010\u0019\u001a\u00020\u000b28\u0010\u001a\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004Jj\u0010\u001b\u001a\u00020\u000b2b\u0010\u001a\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\rJj\u0010\u001c\u001a\u00020\u000b2b\u0010\u001a\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000b0\rRB\u0010\u0003\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000Rl\u0010\f\u001a`\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000Rl\u0010\u0013\u001a`\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u000b\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XBaseCallback;", "()V", "writeComplete", "Lkotlin/Function2;", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "Lkotlin/ParameterName;", "name", "device", "", "allSuccess", "", "writeFail", "Lkotlin/Function4;", "", "current", "total", "", "throwable", "writeSuccess", "", "justWrite", "callWriteComplete", "callWriteFail", "callWriteSuccess", "onWriteComplete", "value", "onWriteFail", "onWriteSuccess", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XWriteCallback extends XBaseCallback {
    private Function2<? super XBluetoothDevice, ? super Boolean, Unit> writeComplete;
    private Function4<? super XBluetoothDevice, ? super Integer, ? super Integer, ? super Throwable, Unit> writeFail;
    private Function4<? super XBluetoothDevice, ? super Integer, ? super Integer, ? super byte[], Unit> writeSuccess;

    public final void onWriteFail(Function4<? super XBluetoothDevice, ? super Integer, ? super Integer, ? super Throwable, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.writeFail = value;
    }

    public final void onWriteSuccess(Function4<? super XBluetoothDevice, ? super Integer, ? super Integer, ? super byte[], Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.writeSuccess = value;
    }

    public final void onWriteComplete(Function2<? super XBluetoothDevice, ? super Boolean, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.writeComplete = value;
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback$callWriteFail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XWriteCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback$callWriteFail$1", f = "XWriteCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $current;
        final /* synthetic */ XBluetoothDevice $device;
        final /* synthetic */ Throwable $throwable;
        final /* synthetic */ int $total;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09091(XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable th, Continuation<? super C09091> continuation) {
            super(2, continuation);
            this.$device = xBluetoothDevice;
            this.$current = i;
            this.$total = i2;
            this.$throwable = th;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XWriteCallback.this.new C09091(this.$device, this.$current, this.$total, this.$throwable, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function4 function4 = XWriteCallback.this.writeFail;
                if (function4 != null) {
                    function4.invoke(this.$device, Boxing.boxInt(this.$current), Boxing.boxInt(this.$total), this.$throwable);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callWriteFail(XBluetoothDevice device, int current, int total, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        launchInMainThread(new C09091(device, current, total, throwable, null));
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback$callWriteSuccess$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XWriteCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback$callWriteSuccess$1", f = "XWriteCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $current;
        final /* synthetic */ XBluetoothDevice $device;
        final /* synthetic */ byte[] $justWrite;
        final /* synthetic */ int $total;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09101(XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] bArr, Continuation<? super C09101> continuation) {
            super(2, continuation);
            this.$device = xBluetoothDevice;
            this.$current = i;
            this.$total = i2;
            this.$justWrite = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XWriteCallback.this.new C09101(this.$device, this.$current, this.$total, this.$justWrite, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function4 function4 = XWriteCallback.this.writeSuccess;
                if (function4 != null) {
                    function4.invoke(this.$device, Boxing.boxInt(this.$current), Boxing.boxInt(this.$total), this.$justWrite);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callWriteSuccess(XBluetoothDevice device, int current, int total, byte[] justWrite) {
        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
        launchInMainThread(new C09101(device, current, total, justWrite, null));
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback$callWriteComplete$1, reason: invalid class name */
    /* JADX INFO: compiled from: XWriteCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback$callWriteComplete$1", f = "XWriteCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $allSuccess;
        final /* synthetic */ XBluetoothDevice $device;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(XBluetoothDevice xBluetoothDevice, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$device = xBluetoothDevice;
            this.$allSuccess = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XWriteCallback.this.new AnonymousClass1(this.$device, this.$allSuccess, continuation);
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
                Function2 function2 = XWriteCallback.this.writeComplete;
                if (function2 != null) {
                    function2.invoke(this.$device, Boxing.boxBoolean(this.$allSuccess));
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callWriteComplete(XBluetoothDevice device, boolean allSuccess) {
        launchInMainThread(new AnonymousClass1(device, allSuccess, null));
    }
}
