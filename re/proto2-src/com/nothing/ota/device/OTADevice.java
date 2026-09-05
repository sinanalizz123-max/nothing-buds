package com.nothing.ota.device;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.util.Log;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.ota.entity.OTAProcess;
import com.spotify.sdk.android.auth.LoginActivity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: OTADevice.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001WB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010.\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010/J\u000e\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0017J\u0006\u00103\u001a\u00020\u0017J\u000e\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u001bJ\u001f\u00106\u001a\u0002012\u0006\u00105\u001a\u00020\u001b2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0002\u00108J,\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020:2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?H\u0086@\u00a2\u0006\u0002\u0010@J\u0012\u0010A\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<H\u0002J2\u0010B\u001a\u0002012\u0006\u0010=\u001a\u00020:2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010:2\u0016\b\u0002\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u000201\u0018\u00010EJ\u0006\u0010F\u001a\u000201J\u0006\u0010G\u001a\u00020'J\u0016\u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020'2\u0006\u0010J\u001a\u00020\u0017J\u000e\u0010F\u001a\u0002012\u0006\u0010I\u001a\u00020'J\u0006\u0010K\u001a\u000201J\u0006\u0010L\u001a\u000201J\u0006\u0010M\u001a\u000201J\u0006\u0010N\u001a\u000201J\u0018\u0010O\u001a\u0002012\u0006\u0010P\u001a\u00020'2\b\u0010=\u001a\u0004\u0018\u00010\rJ\u0006\u0010Q\u001a\u00020\u0017J\u0006\u0010R\u001a\u000201J\u000e\u0010S\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010/J\u0006\u0010T\u001a\u000201J\u0006\u0010U\u001a\u000201J\u0006\u0010V\u001a\u000201R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001eR\u000e\u0010%\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001e\u00a8\u0006X"}, d2 = {"Lcom/nothing/ota/device/OTADevice;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "protocol", "Lcom/nothing/ota/entity/OTAProcess;", "<init>", "(Landroid/bluetooth/BluetoothDevice;Lcom/nothing/ota/entity/OTAProcess;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getProtocol", "()Lcom/nothing/ota/entity/OTAProcess;", "address", "", "getAddress", "()Ljava/lang/String;", "otaConnector", "Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "getOtaConnector", "()Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "setOtaConnector", "(Lcom/nothing/link/bluetooth/sdk/connect/XConnector;)V", "isBluetoothConnected", "", "()Z", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/nothing/ota/device/OTADevice$Callback;", "isTransfer", "setTransfer", "(Z)V", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XDefaultParser;", "getParser", "()Lcom/nothing/link/bluetooth/sdk/connect/tranform/XDefaultParser;", "isFlutter", "setFlutter", "isOTATryAgain", "caseProgress", "", "getCaseProgress", "()I", "setCaseProgress", "(I)V", "isFail", "setFail", "isConnected", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setOTATryAgain", "", "tryAgain", "getOTATryAgain", "register", "callback", "unregister", "needDestroy", "(Lcom/nothing/ota/device/OTADevice$Callback;Ljava/lang/Boolean;)V", "syncSend", "", LoginActivity.RESPONSE_KEY, "", "message", "retryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "(B[BLjava/util/concurrent/atomic/AtomicInteger;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMockResponse", "send", "mockResponse", "onResult", "Lkotlin/Function1;", "updateProcess", "getCurrentProcess", "updateCaseProgress", "progress", "isInvite", "onSuccess", "onFail", "onConnected", "onClosed", "onError", "code", "isLeAudioConnect", "connect", "starOTA", DeviceEarImage.DISCONNECT_EAR_IMAGE, "release", "userDisconnect", "Callback", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OTADevice {
    private final CopyOnWriteArrayList<Callback> callbacks;
    private int caseProgress;
    private final BluetoothDevice device;
    private boolean isFail;
    private boolean isFlutter;
    private boolean isOTATryAgain;
    private boolean isTransfer;
    private XConnector otaConnector;
    private final XDefaultParser parser;
    private final OTAProcess protocol;

    /* JADX INFO: renamed from: com.nothing.ota.device.OTADevice$isConnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: OTADevice.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ota.device.OTADevice", f = "OTADevice.kt", i = {}, l = {35}, m = "isConnected", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OTADevice.this.isConnected(this);
        }
    }

    public final boolean isLeAudioConnect() {
        return false;
    }

    public OTADevice(BluetoothDevice device, OTAProcess protocol) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.device = device;
        this.protocol = protocol;
        this.callbacks = new CopyOnWriteArrayList<>();
        this.parser = new XDefaultParser();
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final OTAProcess getProtocol() {
        return this.protocol;
    }

    public final String getAddress() {
        return this.device.getAddress();
    }

    public final XConnector getOtaConnector() {
        return this.otaConnector;
    }

    public final void setOtaConnector(XConnector xConnector) {
        this.otaConnector = xConnector;
    }

    public final boolean isBluetoothConnected() {
        return BluetoothBroadcast.INSTANCE.getInstance().isClassicConnected(this.device);
    }

    /* JADX INFO: renamed from: isTransfer, reason: from getter */
    public final boolean getIsTransfer() {
        return this.isTransfer;
    }

    public final void setTransfer(boolean z) {
        this.isTransfer = z;
    }

    public final XDefaultParser getParser() {
        return this.parser;
    }

    /* JADX INFO: renamed from: isFlutter, reason: from getter */
    public final boolean getIsFlutter() {
        return this.isFlutter;
    }

    public final void setFlutter(boolean z) {
        this.isFlutter = z;
    }

    public final int getCaseProgress() {
        return this.caseProgress;
    }

    public final void setCaseProgress(int i) {
        this.caseProgress = i;
    }

    /* JADX INFO: renamed from: isFail, reason: from getter */
    public final boolean getIsFail() {
        return this.isFail;
    }

    public final void setFail(boolean z) {
        this.isFail = z;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isConnected(Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objIsConnected$default = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsConnected$default);
            XConnector xConnector = this.otaConnector;
            if (xConnector != null) {
                anonymousClass1.label = 1;
                objIsConnected$default = XConnector.isConnected$default(xConnector, false, anonymousClass1, 1, null);
                if (objIsConnected$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(z);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objIsConnected$default);
        if (((Boolean) objIsConnected$default).booleanValue()) {
            z = true;
        }
        return Boxing.boxBoolean(z);
    }

    public final void setOTATryAgain(boolean tryAgain) {
        this.isOTATryAgain = false;
    }

    /* JADX INFO: renamed from: getOTATryAgain, reason: from getter */
    public final boolean getIsOTATryAgain() {
        return this.isOTATryAgain;
    }

    public final void register(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        XConnectorDevice device = XBluetoothManager.INSTANCE.get().getDevice(this.device);
        String string = this.protocol.getSppUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        this.otaConnector = XConnectorDevice.sppOTA$default(device, string, null, 0, this.parser, 6, null);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "OTADevice register".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "OTADevice register " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "OTADevice register " + strComponent2);
            }
        }
        XConnector xConnector = this.otaConnector;
        if (xConnector != null) {
            xConnector.setMessageReceiveCallback("ota", new Function1() { // from class: com.nothing.ota.device.OTADevice$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OTADevice.register$lambda$3(this.f$0, (XCommand) obj);
                }
            });
        }
        this.callbacks.add(callback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit register$lambda$3(OTADevice oTADevice, XCommand xCommand) {
        byte[] data;
        for (Callback callback : oTADevice.callbacks) {
            if (xCommand != null && (data = xCommand.getData()) != null) {
                callback.updateMessage(data);
            }
        }
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void unregister$default(OTADevice oTADevice, Callback callback, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = false;
        }
        oTADevice.unregister(callback, bool);
    }

    public final void unregister(Callback callback, Boolean needDestroy) {
        XConnector xConnector;
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.remove(callback);
        if (!Intrinsics.areEqual((Object) needDestroy, (Object) true) || (xConnector = this.otaConnector) == null) {
            return;
        }
        xConnector.onDestroy();
    }

    public static /* synthetic */ Object syncSend$default(OTADevice oTADevice, byte b, byte[] bArr, AtomicInteger atomicInteger, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            atomicInteger = null;
        }
        return oTADevice.syncSend(b, bArr, atomicInteger, continuation);
    }

    public final Object syncSend(byte b, byte[] bArr, AtomicInteger atomicInteger, Continuation<? super byte[]> continuation) {
        XConnector xConnector = this.otaConnector;
        if (xConnector != null) {
            return XConnector.writeWithTask$default(xConnector, bArr, 0L, this.protocol.getIsCaseUpdate() ? 10000L : 5000L, false, true, false, (String) null, (String) null, (byte[]) null, atomicInteger, false, (String) null, (ArrayList) null, (Continuation) continuation, 7360, (Object) null);
        }
        return null;
    }

    private final byte[] getMockResponse(byte response) {
        if (response == -117) {
            return new byte[]{-117, 0, 0, 0, 0};
        }
        return null;
    }

    /* JADX INFO: renamed from: com.nothing.ota.device.OTADevice$send$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OTADevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ota.device.OTADevice$send$1", f = "OTADevice.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $message;
        final /* synthetic */ byte[] $mockResponse;
        final /* synthetic */ Function1<Boolean, Unit> $onResult;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10491(byte[] bArr, byte[] bArr2, Function1<? super Boolean, Unit> function1, Continuation<? super C10491> continuation) {
            super(2, continuation);
            this.$message = bArr;
            this.$mockResponse = bArr2;
            this.$onResult = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OTADevice.this.new C10491(this.$message, this.$mockResponse, this.$onResult, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            XConnector otaConnector = OTADevice.this.getOtaConnector();
            if (otaConnector != null) {
                byte[] bArr = this.$message;
                byte[] bArr2 = this.$mockResponse;
                final Function1<Boolean, Unit> function1 = this.$onResult;
                XConnector.writeWithTask$default(otaConnector, bArr, 0L, 5000L, false, true, false, (String) null, (String) null, bArr2, (AtomicInteger) null, false, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.ota.device.OTADevice$send$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return OTADevice.C10491.invokeSuspend$lambda$4(function1, (XWriteCallback) obj2);
                    }
                }, 7872, (Object) null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4(final Function1 function1, XWriteCallback xWriteCallback) {
            xWriteCallback.onWriteSuccess(new Function4() { // from class: com.nothing.ota.device.OTADevice$send$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return OTADevice.C10491.invokeSuspend$lambda$4$lambda$1(function1, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
                }
            });
            xWriteCallback.onWriteFail(new Function4() { // from class: com.nothing.ota.device.OTADevice$send$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return OTADevice.C10491.invokeSuspend$lambda$4$lambda$3(function1, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4$lambda$1(Function1 function1, XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] bArr) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "ota send callback success " + BleUtil.bytesToHex$default(BleUtil.INSTANCE, bArr, false, 2, null);
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            if (function1 != null) {
                function1.invoke(true);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$4$lambda$3(Function1 function1, XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable th) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "ota send callback failed " + th;
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 6, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            if (function1 != null) {
                function1.invoke(false);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void send$default(OTADevice oTADevice, byte[] bArr, byte[] bArr2, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr2 = null;
        }
        if ((i & 4) != 0) {
            function1 = null;
        }
        oTADevice.send(bArr, bArr2, function1);
    }

    public final void send(byte[] message, byte[] mockResponse, Function1<? super Boolean, Unit> onResult) {
        Intrinsics.checkNotNullParameter(message, "message");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C10491(message, mockResponse, onResult, null), 3, null);
    }

    public final void updateProcess() {
        this.isTransfer = true;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "OTA_Progress OTADevice onUpdateProgress progress:" + this.protocol.getSendProcess();
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).onUpdateProgress(this.protocol.getSendProcess(), false, false);
        }
    }

    public final int getCurrentProcess() {
        return this.protocol.getSendProcess();
    }

    public final void updateCaseProgress(int progress, boolean isInvite) {
        this.caseProgress = progress;
        if (progress == 0) {
            return;
        }
        this.isFail = !isInvite;
        if (!isInvite) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "OTA_Progress OTADevice updateCaseProgress onFail".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "OTA_Progress OTADevice updateCaseProgress onFail " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "OTA_Progress OTADevice updateCaseProgress onFail " + strComponent2);
                }
            }
            onFail();
            return;
        }
        if (progress == 100) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "OTA_Progress OTADevice updateCaseProgress onSuccess".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 3, str2, tag2, "OTA_Progress OTADevice updateCaseProgress onSuccess " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "OTA_Progress OTADevice updateCaseProgress onSuccess " + strComponent4);
                }
            }
            onSuccess();
            return;
        }
        this.isTransfer = true;
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str3 = "OTA_Progress OTADevice updateCaseProgress progress: local --> " + progress;
            String str4 = str3;
            if (str4 != null && str4.length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str5 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                FileLog.print$default(fileLog3, 3, str5, tag3, str3 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str3 + StringUtils.SPACE + strComponent6);
                }
            }
        }
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).onUpdateProgress(progress, false, true);
        }
    }

    public final void updateProcess(int progress) {
        this.isTransfer = true;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "OTA_Progress OTADevice onUpdateProgress progress: local --> " + progress;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).onUpdateProgress(progress, false, false);
        }
    }

    public final void onSuccess() {
        this.isTransfer = false;
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).onSuccess();
        }
    }

    public final void onFail() {
        this.isTransfer = false;
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).onFail();
        }
    }

    public final void onConnected() {
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).onConnected();
        }
    }

    public final void onClosed() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "OTADevice onClosed size:" + this.callbacks.size();
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        for (Callback callback : this.callbacks) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "OTADevice onClosed it:" + callback;
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str6 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            callback.onDisconnected();
        }
    }

    public final void onError(int code, String message) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "OTADevice callback size:" + this.callbacks.size();
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 6, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        Iterator<T> it = this.callbacks.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).onError(code, message);
        }
    }

    /* JADX INFO: renamed from: com.nothing.ota.device.OTADevice$connect$2, reason: invalid class name */
    /* JADX INFO: compiled from: OTADevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ota.device.OTADevice$connect$2", f = "OTADevice.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OTADevice.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = OTADevice.this.isConnected(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                return Unit.INSTANCE;
            }
            XConnector otaConnector = OTADevice.this.getOtaConnector();
            if (otaConnector != null) {
                boolean zIsLeAudioConnect = OTADevice.this.isLeAudioConnect();
                final OTADevice oTADevice = OTADevice.this;
                XConnector.connect$default(otaConnector, null, null, null, null, false, false, zIsLeAudioConnect, 0, false, new Function1() { // from class: com.nothing.ota.device.OTADevice$connect$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return OTADevice.AnonymousClass2.invokeSuspend$lambda$5(oTADevice, (XConnectCallback) obj2);
                    }
                }, null, 1471, null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$5(final OTADevice oTADevice, XConnectCallback xConnectCallback) {
            xConnectCallback.onConnectSuccess(new Function2() { // from class: com.nothing.ota.device.OTADevice$connect$2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OTADevice.AnonymousClass2.invokeSuspend$lambda$5$lambda$0(oTADevice, (XConnectType) obj, (XBluetoothDevice) obj2);
                }
            });
            xConnectCallback.onDisConnected(new Function4() { // from class: com.nothing.ota.device.OTADevice$connect$2$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return OTADevice.AnonymousClass2.invokeSuspend$lambda$5$lambda$2(oTADevice, ((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
                }
            });
            xConnectCallback.onConnectFail(new Function2() { // from class: com.nothing.ota.device.OTADevice$connect$2$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OTADevice.AnonymousClass2.invokeSuspend$lambda$5$lambda$4(oTADevice, (XBluetoothDevice) obj, (XConnectFailType) obj2);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$5$lambda$0(OTADevice oTADevice, XConnectType xConnectType, XBluetoothDevice xBluetoothDevice) {
            oTADevice.onConnected();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$5$lambda$2(OTADevice oTADevice, boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "OTADevice onDisConnected isActiveDisConnected".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "OTADevice onDisConnected isActiveDisConnected " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "OTADevice onDisConnected isActiveDisConnected " + strComponent2);
                }
            }
            oTADevice.onClosed();
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$5$lambda$4(OTADevice oTADevice, XBluetoothDevice xBluetoothDevice, XConnectFailType xConnectFailType) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "OTADevice onConnectFail".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "OTADevice onConnectFail " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "OTADevice onConnectFail " + strComponent2);
                }
            }
            oTADevice.onClosed();
            return Unit.INSTANCE;
        }
    }

    public final void connect() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "OTADevice connect".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 6, str, tag, "OTADevice connect " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.e(tag + strComponent1, "OTADevice connect " + strComponent2);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass2(null), 3, null);
    }

    public final Object starOTA(Continuation<? super Boolean> continuation) {
        return this.protocol.process(continuation);
    }

    public final void disconnect() {
        this.isTransfer = false;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "OTADevice disconnect".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "OTADevice disconnect " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "OTADevice disconnect " + strComponent2);
            }
        }
    }

    public final void release() {
        this.isTransfer = false;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "OTADevice release".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "OTADevice release " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "OTADevice release " + strComponent2);
            }
        }
        XConnector xConnector = this.otaConnector;
        if (xConnector != null) {
            xConnector.onDestroy();
        }
        disconnect();
        this.callbacks.clear();
    }

    /* JADX INFO: renamed from: com.nothing.ota.device.OTADevice$userDisconnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: OTADevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ota.device.OTADevice$userDisconnect$1", f = "OTADevice.kt", i = {}, l = {253}, m = "invokeSuspend", n = {}, s = {})
    static final class C10501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10501(Continuation<? super C10501> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OTADevice.this.new C10501(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                XConnector otaConnector = OTADevice.this.getOtaConnector();
                if (otaConnector != null) {
                    this.label = 1;
                    obj = otaConnector.disconnect(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
    }

    public final void userDisconnect() {
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C10501(null), 3, null);
    }

    /* JADX INFO: compiled from: OTADevice.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0003H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/ota/device/OTADevice$Callback;", "", "onConnected", "", "onDisconnected", "onUpdateState", "state", "", "onUpdateProgress", "progress", "isStart", "", "isCase", "onError", "code", "message", "", "onFail", "onSuccess", "updateMessage", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Callback {
        void onConnected();

        void onDisconnected();

        void onError(int code, String message);

        void onFail();

        void onSuccess();

        void onUpdateProgress(int progress, boolean isStart, boolean isCase);

        void onUpdateState(int state);

        void updateMessage(byte[] message);

        /* JADX INFO: compiled from: OTADevice.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void onError(Callback callback, int i, String str) {
            }

            public static void onUpdateProgress(Callback callback, int i, boolean z, boolean z2) {
            }

            public static void onUpdateState(Callback callback, int i) {
            }

            public static /* synthetic */ void onUpdateProgress$default(Callback callback, int i, boolean z, boolean z2, int i2, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUpdateProgress");
                }
                if ((i2 & 2) != 0) {
                    z = false;
                }
                callback.onUpdateProgress(i, z, z2);
            }
        }
    }
}
