package com.nothing.nt_ear_ota;

import android.bluetooth.BluetoothGatt;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.nt_ear_ota.caseble.CaseBleMacUtilsKt;
import com.nothing.nt_ear_ota.caseble.XCaseBleConnector;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NtEarOtaCaseBleSession.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$prepared$1", f = "NtEarOtaCaseBleSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class NtEarOtaCaseBleSession$open$prepared$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ NtEarOtaCaseBleSession this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NtEarOtaCaseBleSession$open$prepared$1(NtEarOtaCaseBleSession ntEarOtaCaseBleSession, Continuation<? super NtEarOtaCaseBleSession$open$prepared$1> continuation) {
        super(2, continuation);
        this.this$0 = ntEarOtaCaseBleSession;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NtEarOtaCaseBleSession$open$prepared$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((NtEarOtaCaseBleSession$open$prepared$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            XConnectorDevice device = XBluetoothManager.INSTANCE.get().getDevice(this.this$0.caseMac);
            String deviceAddress = device.getXBluetoothDevice().getDeviceAddress();
            if (Intrinsics.areEqual(CaseBleMacUtilsKt.normalizeMac(deviceAddress == null ? "" : deviceAddress), CaseBleMacUtilsKt.normalizeMac(this.this$0.caseMac))) {
                this.this$0.connector.onCreate(device.getXBluetoothDevice());
                this.this$0.connector.setUuids(this.this$0.serviceUuid, this.this$0.writeUuid, this.this$0.notifyUuid);
                XCaseBleConnector xCaseBleConnector = this.this$0.connector;
                String str = this.this$0.recvKey;
                final NtEarOtaCaseBleSession ntEarOtaCaseBleSession = this.this$0;
                xCaseBleConnector.setMessageReceiveCallback(str, new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$prepared$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtEarOtaCaseBleSession$open$prepared$1.invokeSuspend$lambda$2(ntEarOtaCaseBleSession, (XCommand) obj2);
                    }
                });
                XConnector.connect$default(this.this$0.connector, null, null, null, null, false, false, false, 0, false, new Function1() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$prepared$1$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return NtEarOtaCaseBleSession$open$prepared$1.invokeSuspend$lambda$6((XConnectCallback) obj2);
                    }
                }, null, 1519, null);
                return Boxing.boxBoolean(true);
            }
            Log.e("NtEarOtaCaseSession", "case getDevice mismatch expected=" + this.this$0.caseMac + " got=" + deviceAddress);
            return Boxing.boxBoolean(false);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(NtEarOtaCaseBleSession ntEarOtaCaseBleSession, XCommand xCommand) {
        byte[] data;
        if (xCommand != null && (data = xCommand.getData()) != null) {
            ntEarOtaCaseBleSession.onRawBytes.invoke(data);
            synchronized (ntEarOtaCaseBleSession.syncLock) {
                CountDownLatch countDownLatch = ntEarOtaCaseBleSession.syncLatch;
                if (countDownLatch != null && ntEarOtaCaseBleSession.syncResult == null) {
                    ntEarOtaCaseBleSession.syncResult = data;
                    countDownLatch.countDown();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$6(XConnectCallback xConnectCallback) {
        xConnectCallback.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$prepared$1$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NtEarOtaCaseBleSession$open$prepared$1.invokeSuspend$lambda$6$lambda$3((XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        xConnectCallback.onConnectFail(new Function2() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$prepared$1$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NtEarOtaCaseBleSession$open$prepared$1.invokeSuspend$lambda$6$lambda$4((XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        xConnectCallback.onDisConnected(new Function4() { // from class: com.nothing.nt_ear_ota.NtEarOtaCaseBleSession$open$prepared$1$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NtEarOtaCaseBleSession$open$prepared$1.invokeSuspend$lambda$6$lambda$5(((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$6$lambda$3(XConnectType xConnectType, XBluetoothDevice xBluetoothDevice) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$6$lambda$4(XBluetoothDevice xBluetoothDevice, XConnectFailType xConnectFailType) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$6$lambda$5(boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
        return Unit.INSTANCE;
    }
}
