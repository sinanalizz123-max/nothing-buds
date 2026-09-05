package com.nothing.link.bluetooth.sdk.connect.leaudio;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBTLEAudioConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u001b\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u0015H\u0016J\u0018\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006$"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/leaudio/XBTLEAudioConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "()V", "waitLeAudioBroadcast", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getWaitLeAudioBroadcast", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setWaitLeAudioBroadcast", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "closeLast", "", "connectInternal", "bleDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "(Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disConnectInternal", "getConnectorType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "initParams", "device", "isConnected", "", "isSystem", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLeAudioChange", "Landroid/bluetooth/BluetoothDevice;", "leAudioConnect", "a2dpConnect", "headsetConnect", "printReceiverLog", "command", "", "byteArray", "", "printWriterLog", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBTLEAudioConnector extends XConnector {
    private AtomicBoolean waitLeAudioBroadcast;

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.leaudio.XBTLEAudioConnector$isConnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: XBTLEAudioConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.leaudio.XBTLEAudioConnector", f = "XBTLEAudioConnector.kt", i = {0}, l = {32}, m = "isConnected", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBTLEAudioConnector.this.isConnected(false, this);
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void disConnectInternal() {
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printReceiverLog(String command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void printWriterLog(XCommand command, byte[] byteArray) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
    }

    public XBTLEAudioConnector() {
        super(null, null, 3, null);
        this.waitLeAudioBroadcast = new AtomicBoolean(false);
    }

    public final AtomicBoolean getWaitLeAudioBroadcast() {
        return this.waitLeAudioBroadcast;
    }

    public final void setWaitLeAudioBroadcast(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.waitLeAudioBroadcast = atomicBoolean;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public XConnectType getConnectorType() {
        return XConnectType.LEAudio.INSTANCE;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void initParams(XBluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        super.initParams(device);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public Object isConnected(boolean z, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        XBTLEAudioConnector xBTLEAudioConnector;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objIsRelationConnected = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsRelationConnected);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objIsRelationConnected = isRelationConnected(z, anonymousClass1);
            if (objIsRelationConnected == coroutine_suspended) {
                return coroutine_suspended;
            }
            xBTLEAudioConnector = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            xBTLEAudioConnector = (XBTLEAudioConnector) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objIsRelationConnected);
        }
        if (!((Boolean) objIsRelationConnected).booleanValue()) {
            return Boxing.boxBoolean(false);
        }
        XBluetoothDevice mBleDevice = xBTLEAudioConnector.getMBleDevice();
        if ((mBleDevice != null ? mBleDevice.getDeviceInfo() : null) == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "isConnected BluetoothDevice is null".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 6, str, tag, "isConnected BluetoothDevice is null " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.e(tag + strComponent1, "isConnected BluetoothDevice is null " + strComponent2);
                }
            }
            return Boxing.boxBoolean(false);
        }
        return Boxing.boxBoolean(false);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public Object connectInternal(XBluetoothDevice xBluetoothDevice, Continuation<? super Unit> continuation) {
        XConnector.updateLastState$default(this, 1, null, 2, null);
        if (xBluetoothDevice == null || xBluetoothDevice.getDeviceInfo() == null) {
            return Unit.INSTANCE;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "leAudioProfile isConnected!".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "leAudioProfile isConnected! " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "leAudioProfile isConnected! " + strComponent2);
            }
        }
        if (this.waitLeAudioBroadcast.get()) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "reflect leaudio success wait callback!".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 3, str2, tag2, "reflect leaudio success wait callback! " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "reflect leaudio success wait callback! " + strComponent4);
                }
            }
        } else {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "reflect leaudio failed!".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog3, 6, str3, tag3, "reflect leaudio failed! " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.e(tag3 + strComponent5, "reflect leaudio failed! " + strComponent6);
                }
            }
            cancelJobWhenConnectedFailed("onInternalResult");
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onLeAudioChange(BluetoothDevice device, boolean leAudioConnect, boolean a2dpConnect, boolean headsetConnect) {
        boolean z;
        boolean z2 = true;
        if (leAudioConnect) {
            if (this.waitLeAudioBroadcast.get()) {
                this.waitLeAudioBroadcast.set(false);
            }
            z = false;
        } else {
            if (getLastState().get() == 2) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    if (!("need disconnected ble!".length() == 0)) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        FileLog.print$default(fileLog, 3, str, tag, "need disconnected ble! " + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, "need disconnected ble! " + strComponent2);
                        }
                    }
                }
            }
            if (getLastState().get() == 1 ? cancelJobWhenConnectedFailed(" onLeDisconnected failed!") : false) {
                z = false;
            } else {
                z = false;
                XConnector.updateLastState$default(this, 0, null, 2, null);
            }
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str2 = "onLeConnected waitLeAudioBroadcast:" + this.waitLeAudioBroadcast.get();
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                z2 = z;
            }
            if (z2) {
                return;
            }
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str4 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void closeLast() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "closeLast leaudio close".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "closeLast leaudio close " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "closeLast leaudio close " + strComponent2);
            }
        }
    }
}
