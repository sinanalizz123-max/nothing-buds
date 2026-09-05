package com.nothing.link.bluetooth.sdk.scan;

import com.nothing.link.bluetooth.sdk.connect.tranform.XBaseCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: XScanCallback.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\u0019\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u001b\u001a\u00020\u000bH\u0016J>\u0010\u001c\u001a\u00020\u000b26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004JJ\u0010\u001e\u001a\u00020\u000b2B\u0010\u001d\u001a>\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\u0004J)\u0010\u001f\u001a\u00020\u000b2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b0\u0012J>\u0010 \u001a\u00020\u000b26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004J\u0014\u0010!\u001a\u00020\u000b2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0016R@\u0010\u0003\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R@\u0010\f\u001a4\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000RL\u0010\r\u001a@\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScanCallback;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XBaseCallback;", "()V", "leScan", "Lkotlin/Function2;", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "Lkotlin/ParameterName;", "name", "bleDevice", "", "currentScanCount", "", "leScanDuplicateRemoval", "scanComplete", "", "bleDeviceList", "bleDeviceDuplicateRemovalList", "scanFail", "Lkotlin/Function1;", "Lcom/nothing/link/bluetooth/sdk/scan/XScanFailType;", "scanFailType", "start", "Lkotlin/Function0;", "callLeScan", "callLeScanDuplicateRemoval", "callScanComplete", "callScanFail", "callScanStart", "onLeScanDuplicateRemoval", "value", "onScanComplete", "onScanFail", "onScanResult", "onScanStart", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XScanCallback extends XBaseCallback {
    private Function2<? super XBluetoothDevice, ? super Integer, Unit> leScan;
    private Function2<? super XBluetoothDevice, ? super Integer, Unit> leScanDuplicateRemoval;
    private Function2<? super List<XBluetoothDevice>, ? super List<XBluetoothDevice>, Unit> scanComplete;
    private Function1<? super XScanFailType, Unit> scanFail;
    private Function0<Unit> start;

    public final void onScanStart(Function0<Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.start = value;
    }

    public final void onScanResult(Function2<? super XBluetoothDevice, ? super Integer, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.leScan = value;
    }

    public final void onLeScanDuplicateRemoval(Function2<? super XBluetoothDevice, ? super Integer, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.leScanDuplicateRemoval = value;
    }

    public final void onScanFail(Function1<? super XScanFailType, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.scanFail = value;
    }

    public final void onScanComplete(Function2<? super List<XBluetoothDevice>, ? super List<XBluetoothDevice>, Unit> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.scanComplete = value;
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.scan.XScanCallback$callScanStart$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XScanCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XScanCallback$callScanStart$1", f = "XScanCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09201(Continuation<? super C09201> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XScanCallback.this.new C09201(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function0 function0 = XScanCallback.this.start;
                if (function0 != null) {
                    function0.invoke();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callScanStart() {
        launchInMainThread(new C09201(null));
    }

    public void callLeScan(XBluetoothDevice bleDevice, int currentScanCount) {
        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
        Function2<? super XBluetoothDevice, ? super Integer, Unit> function2 = this.leScan;
        if (function2 != null) {
            function2.invoke(bleDevice, Integer.valueOf(currentScanCount));
        }
    }

    public void callLeScanDuplicateRemoval(XBluetoothDevice bleDevice, int currentScanCount) {
        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
        Function2<? super XBluetoothDevice, ? super Integer, Unit> function2 = this.leScanDuplicateRemoval;
        if (function2 != null) {
            function2.invoke(bleDevice, Integer.valueOf(currentScanCount));
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.scan.XScanCallback$callScanFail$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XScanCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XScanCallback$callScanFail$1", f = "XScanCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XScanFailType $scanFailType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09191(XScanFailType xScanFailType, Continuation<? super C09191> continuation) {
            super(2, continuation);
            this.$scanFailType = xScanFailType;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XScanCallback.this.new C09191(this.$scanFailType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Function1 function1 = XScanCallback.this.scanFail;
                if (function1 != null) {
                    function1.invoke(this.$scanFailType);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callScanFail(XScanFailType scanFailType) {
        Intrinsics.checkNotNullParameter(scanFailType, "scanFailType");
        launchInMainThread(new C09191(scanFailType, null));
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.scan.XScanCallback$callScanComplete$1, reason: invalid class name */
    /* JADX INFO: compiled from: XScanCallback.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XScanCallback$callScanComplete$1", f = "XScanCallback.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<XBluetoothDevice> $bleDeviceDuplicateRemovalList;
        final /* synthetic */ List<XBluetoothDevice> $bleDeviceList;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<XBluetoothDevice> list, List<XBluetoothDevice> list2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bleDeviceList = list;
            this.$bleDeviceDuplicateRemovalList = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XScanCallback.this.new AnonymousClass1(this.$bleDeviceList, this.$bleDeviceDuplicateRemovalList, continuation);
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
                Function2 function2 = XScanCallback.this.scanComplete;
                if (function2 != null) {
                    function2.invoke(this.$bleDeviceList, this.$bleDeviceDuplicateRemovalList);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public void callScanComplete(List<XBluetoothDevice> bleDeviceList, List<XBluetoothDevice> bleDeviceDuplicateRemovalList) {
        Intrinsics.checkNotNullParameter(bleDeviceList, "bleDeviceList");
        Intrinsics.checkNotNullParameter(bleDeviceDuplicateRemovalList, "bleDeviceDuplicateRemovalList");
        launchInMainThread(new AnonymousClass1(bleDeviceList, bleDeviceDuplicateRemovalList, null));
    }
}
