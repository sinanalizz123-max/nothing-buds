package com.nothing.protocol.connector;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.caseble.NtPeerLinkBleUuids;
import com.nothing.earbase.essential.skywalk.SkyWalkUtil;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.spp.XSppConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.link.bluetooth.sdk.scan.XBluetoothFlowCallBack;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.log.NTLog;
import com.nothing.protocol.model.Message;
import com.nothing.protocol.model.ProtocolModel;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: HeadsetSppConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\b\u0016\u0018\u0000 _2\u00020\u0001:\u0003]^_B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003B!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\u0002\u0010\nJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0006\u0010+\u001a\u00020*J\u0006\u0010,\u001a\u00020*J\u0006\u0010-\u001a\u00020\fJ\u0006\u0010.\u001a\u00020*J\u000e\u0010/\u001a\u000200H\u0086@\u00a2\u0006\u0002\u00101J\u000e\u00102\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u00103\u001a\u000200JJ\u00104\u001a\u00020*2\b\b\u0002\u00105\u001a\u0002002\u001b\b\u0002\u00106\u001a\u0015\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020*\u0018\u000107\u00a2\u0006\u0002\b92\u001b\b\u0002\u0010:\u001a\u0015\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020*\u0018\u000107\u00a2\u0006\u0002\b9J\u0016\u0010<\u001a\u0002002\u0006\u00104\u001a\u000200H\u0086@\u00a2\u0006\u0002\u0010=J_\u0010>\u001a\u00020*2\u0006\u0010?\u001a\u00020\f2\b\u0010@\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010A\u001a\u0002002\b\b\u0002\u0010B\u001a\u0002002\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010D\u001a\u00020\f2\u001b\b\u0002\u0010E\u001a\u0015\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020*\u0018\u000107\u00a2\u0006\u0002\b9J \u0010G\u001a\u0002002\u0006\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\f2\b\u0010J\u001a\u0004\u0018\u00010KJ\u0010\u0010L\u001a\u00020K2\u0006\u0010H\u001a\u00020MH\u0002Jd\u0010N\u001a\u0004\u0018\u00010M2\u0006\u0010?\u001a\u00020\f2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010O\u001a\u0004\u0018\u00010P2\b\b\u0002\u0010Q\u001a\u0002002\b\b\u0002\u0010A\u001a\u0002002\b\b\u0002\u0010R\u001a\u0002002\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010D\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010SJ\u0018\u0010T\u001a\u00020*2\u0006\u0010I\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010KJ\u0018\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020K2\u0006\u0010W\u001a\u00020KH\u0002J\u0006\u0010X\u001a\u00020*J\u0010\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020MH\u0002J\u0018\u0010[\u001a\u00020*2\u0006\u0010I\u001a\u00020\f2\b\u0010H\u001a\u0004\u0018\u00010KJ\u0010\u0010\\\u001a\u00020*2\u0006\u0010H\u001a\u00020MH\u0002R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u00020\u001bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(\u00a8\u0006`"}, d2 = {"Lcom/nothing/protocol/connector/HeadsetSppConnector;", "", "<init>", "()V", "callback", "Lcom/nothing/protocol/connector/HeadsetSppConnector$SocketCallback;", "protocol", "Lcom/nothing/protocol/model/ProtocolModel;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/nothing/protocol/connector/HeadsetSppConnector$SocketCallback;Lcom/nothing/protocol/model/ProtocolModel;Landroid/bluetooth/BluetoothDevice;)V", "controlFrameDeviceType", "", "getControlFrameDeviceType", "()I", "payloadWithEndpoint", "", "raw", "socketCallback", "protocolModel", "fsn", "Ljava/util/concurrent/atomic/AtomicInteger;", "handlerReceiveThread", "Landroid/os/HandlerThread;", "dealMessageHandler", "Lcom/nothing/protocol/connector/DealMessageHandler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "xSppConnector", "Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "getXSppConnector", "()Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "setXSppConnector", "(Lcom/nothing/link/bluetooth/sdk/connect/XConnector;)V", "mBluetoothDevice", "getMBluetoothDevice", "()Landroid/bluetooth/BluetoothDevice;", "setMBluetoothDevice", "(Landroid/bluetooth/BluetoothDevice;)V", "initReceiveHandlerThread", "", "onDestroyConnect", "clearLogHandlerMessage", "createFsn", "resetFsn", "isConnect", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSocketCallback", "isLeAudioConnect", "connect", "isForceConnect", "flowCallBack", "Lkotlin/Function1;", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "Lkotlin/ExtensionFunctionType;", "connectCallback", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;", "connectLeAudio", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "command", "payload", "isSync", "isNeedCrc", "mockResponse", "retryCount", "writeCallback", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;", "onSendMessageError", "message", "code", "error", "", "getFsnKey", "Lcom/nothing/protocol/model/Message;", "syncSend", "timeOut", "", "isNeedFsn", "needUpdate", "(I[BLjava/lang/Long;ZZZ[BILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleError", "printCmd", "action", "key", "onClosed", "callBackMessage", NotificationCompat.CATEGORY_MESSAGE, "onError", "onMessage", "SocketCallback", "MessageCallback", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class HeadsetSppConnector {
    public static final long ASYNC_TIME_OUT = 15000;
    public static final int COUNT_ACTIVATE = 3;
    public static final long DELAY = 200;
    private static final int ERROR_COMPACTNESS_DETECT_FAILURE_CALL = 11;
    private static final int ERROR_COMPACTNESS_DETECT_FAILURE_MUSIC = 10;
    private static final int ERROR_FAILURE = 1;
    private static final int ERROR_INVALID_PARAMETER = 4;
    private static final int ERROR_NOT_ACTIVATED = 2;
    private static final int ERROR_NOT_SUPPORT = 3;
    private static final int ERROR_NO_SPACE = 12;
    public static final int ERROR_SUCCESS = 0;
    private static final int ERROR_TIME_OUT = 8;
    private static final int ERROR_TIME_OUT_WITHOUT_ACK = 7;
    private static final int ERROR_VALIDATION_FAILURE = 6;
    private static final int ERROR_VERIFICATION_FAILURE = 5;
    private static final int ERROR_WRITING_FAILURE = 9;
    private static final int FSN_MAX = 254;
    public static final long SEND_DELAY = 40;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = 3;
    public static final long TIME_OUT = 5000;
    public static final long VERSION_TIME_OUT = 1000;
    private DealMessageHandler dealMessageHandler;
    private AtomicInteger fsn;
    private final Handler handler;
    private HandlerThread handlerReceiveThread;
    private BluetoothDevice mBluetoothDevice;
    private ProtocolModel protocolModel;
    private SocketCallback socketCallback;
    private XConnector xSppConnector;
    private static final Map<Integer, String> errorMap = MapsKt.mapOf(TuplesKt.to(1, "Failure"), TuplesKt.to(12, "No Space"), TuplesKt.to(11, "Compactness Detect Failure when call"), TuplesKt.to(10, "Compactness Detect Failure when play music"), TuplesKt.to(9, "Writing Failure"), TuplesKt.to(8, "Time out"), TuplesKt.to(7, "Time out without Ack "), TuplesKt.to(6, "Validation Failure"), TuplesKt.to(5, "Verification Failure"), TuplesKt.to(4, "Invalid Parameter"), TuplesKt.to(3, "Not Support"), TuplesKt.to(2, "Not Activated"));

    /* JADX INFO: compiled from: HeadsetSppConnector.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/nothing/protocol/connector/HeadsetSppConnector$MessageCallback;", "", "onMessage", "", "message", "Lcom/nothing/protocol/model/Message;", "onError", "code", "", "", "isSyncMessage", "", "isNeedUpdate", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface MessageCallback {

        /* JADX INFO: compiled from: HeadsetSppConnector.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            public static boolean isNeedUpdate(MessageCallback messageCallback) {
                return true;
            }

            public static boolean isSyncMessage(MessageCallback messageCallback) {
                return true;
            }
        }

        boolean isNeedUpdate();

        boolean isSyncMessage();

        void onError(int code, String message);

        void onMessage(Message message);
    }

    /* JADX INFO: compiled from: HeadsetSppConnector.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\nH&\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/protocol/connector/HeadsetSppConnector$SocketCallback;", "", "onClosed", "", "onMessage", "message", "Lcom/nothing/protocol/model/Message;", "onMessageNew", "onError", "code", "", "", "connectStatus", NotificationCompat.CATEGORY_STATUS, "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface SocketCallback {
        void connectStatus(int status);

        void onClosed();

        void onError(int code, String message);

        void onMessage(Message message);

        void onMessageNew(Message message);
    }

    /* JADX INFO: renamed from: com.nothing.protocol.connector.HeadsetSppConnector$connectLeAudio$1, reason: invalid class name */
    /* JADX INFO: compiled from: HeadsetSppConnector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.connector.HeadsetSppConnector", f = "HeadsetSppConnector.kt", i = {}, l = {232}, m = "connectLeAudio", n = {}, s = {})
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
            return HeadsetSppConnector.this.connectLeAudio(false, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.connector.HeadsetSppConnector$isConnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HeadsetSppConnector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.connector.HeadsetSppConnector", f = "HeadsetSppConnector.kt", i = {}, l = {144}, m = "isConnect", n = {}, s = {})
    static final class C10571 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10571(Continuation<? super C10571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HeadsetSppConnector.this.isConnect(this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.connector.HeadsetSppConnector$syncSend$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HeadsetSppConnector.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.connector.HeadsetSppConnector", f = "HeadsetSppConnector.kt", i = {}, l = {329}, m = "syncSend", n = {}, s = {})
    static final class C10591 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10591(Continuation<? super C10591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return HeadsetSppConnector.this.syncSend(0, null, null, false, false, false, null, 0, this);
        }
    }

    public final boolean isLeAudioConnect() {
        return false;
    }

    public final boolean onSendMessageError(byte[] message, int code, String error) {
        Intrinsics.checkNotNullParameter(message, "message");
        return false;
    }

    public HeadsetSppConnector() {
        this.fsn = new AtomicInteger(0);
        this.handler = new Handler(Looper.getMainLooper());
    }

    private final int getControlFrameDeviceType() {
        ProtocolModel protocolModel = this.protocolModel;
        if (protocolModel != null) {
            return protocolModel.getControlFrameDeviceType();
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0018, code lost:
    
        if ((r5.length == 0) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final byte[] payloadWithEndpoint(byte[] raw) {
        Integer payloadEndpointType;
        ProtocolModel protocolModel = this.protocolModel;
        if (protocolModel != null && (payloadEndpointType = protocolModel.getPayloadEndpointType()) != null) {
            int iIntValue = payloadEndpointType.intValue();
            if (raw != null) {
            }
            return new byte[]{(byte) iIntValue};
        }
        return raw;
    }

    protected final Handler getHandler() {
        return this.handler;
    }

    public final XConnector getXSppConnector() {
        return this.xSppConnector;
    }

    public final void setXSppConnector(XConnector xConnector) {
        this.xSppConnector = xConnector;
    }

    public final BluetoothDevice getMBluetoothDevice() {
        return this.mBluetoothDevice;
    }

    public final void setMBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.mBluetoothDevice = bluetoothDevice;
    }

    private final void initReceiveHandlerThread() {
        HandlerThread handlerThread = this.handlerReceiveThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        DealMessageHandler dealMessageHandler = this.dealMessageHandler;
        if (dealMessageHandler != null) {
            dealMessageHandler.removeCallbacksAndMessages(null);
        }
        HandlerThread handlerThread2 = new HandlerThread("message_deal_thread");
        this.handlerReceiveThread = handlerThread2;
        handlerThread2.start();
        Looper looper = handlerThread2.getLooper();
        Intrinsics.checkNotNullExpressionValue(looper, "getLooper(...)");
        this.dealMessageHandler = new DealMessageHandler(looper, new Function1() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeadsetSppConnector.initReceiveHandlerThread$lambda$1$lambda$0(this.f$0, (Message) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initReceiveHandlerThread$lambda$1$lambda$0(HeadsetSppConnector headsetSppConnector, Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        headsetSppConnector.onMessage(msg);
        return Unit.INSTANCE;
    }

    public final void onDestroyConnect() {
        BluetoothDevice bluetoothDevice = this.mBluetoothDevice;
        if (bluetoothDevice != null) {
            XBluetoothManager.INSTANCE.get().getDevice(bluetoothDevice).onDestroy();
        }
        HandlerThread handlerThread = this.handlerReceiveThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    public final void clearLogHandlerMessage() {
        DealMessageHandler dealMessageHandler = this.dealMessageHandler;
        if (dealMessageHandler != null) {
            dealMessageHandler.removeCallbacksAndMessages(null);
        }
    }

    public final int createFsn() {
        if (this.fsn.incrementAndGet() >= 254) {
            this.fsn.set(0);
        }
        return this.fsn.get();
    }

    public final void resetFsn() {
        this.fsn.set(-1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HeadsetSppConnector(SocketCallback callback, ProtocolModel protocol, final BluetoothDevice device) {
        this();
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(device, "device");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "constructor HeadsetSppConnector " + device;
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
        this.mBluetoothDevice = device;
        this.socketCallback = callback;
        this.protocolModel = protocol;
        final String str4 = "tws_" + device.getAddress() + "_" + protocol.protocolModelKey();
        XSppConnector xSppConnectorSpp$default = XConnectorDevice.spp$default(XBluetoothManager.INSTANCE.get().getDevice(device), null, null, 0, new XDefaultParser(), 7, null);
        xSppConnectorSpp$default.setMessageReceiveCallback(str4, new Function1() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return HeadsetSppConnector._init_$lambda$8$lambda$4(this.f$0, (XCommand) obj);
            }
        });
        xSppConnectorSpp$default.setDeviceConnectCallback(str4, new Function2() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HeadsetSppConnector._init_$lambda$8$lambda$7(this.f$0, device, str4, ((Integer) obj).intValue(), (XConnectFailType) obj2);
            }
        });
        this.xSppConnector = xSppConnectorSpp$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$8$lambda$4(HeadsetSppConnector headsetSppConnector, XCommand xCommand) {
        headsetSppConnector.onMessage(new Message(xCommand != null ? xCommand.getData() : null));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:32:0x00fd  */
    public static final Unit _init_$lambda$8$lambda$7(final HeadsetSppConnector headsetSppConnector, BluetoothDevice bluetoothDevice, String str, int i, XConnectFailType xConnectFailType) {
        SocketCallback socketCallback;
        if (Intrinsics.areEqual(xConnectFailType, XConnectFailType.connectPeerPaired.INSTANCE)) {
            return Unit.INSTANCE;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "SkyWalk-Record tws setDeviceConnectCallback " + str + "  " + i + StringUtils.SPACE + headsetSppConnector.socketCallback;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (i == 0) {
            headsetSppConnector.handler.post(new Runnable() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onClosed();
                }
            });
            socketCallback = headsetSppConnector.socketCallback;
            if (socketCallback != null) {
                socketCallback.connectStatus(0);
            }
            SkyWalkUtil skyWalkUtil = SkyWalkUtil.INSTANCE;
            String address = bluetoothDevice.getAddress();
            Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
            skyWalkUtil.disconnect(address);
        } else if (i == 2) {
            SocketCallback socketCallback2 = headsetSppConnector.socketCallback;
            if (socketCallback2 != null) {
                socketCallback2.connectStatus(2);
            }
            SkyWalkUtil.connectToDevice$default(SkyWalkUtil.INSTANCE, AppGlobals.INSTANCE.get(), bluetoothDevice, false, 4, null);
        } else if (i == 4) {
            headsetSppConnector.handler.post(new Runnable() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onClosed();
                }
            });
            socketCallback = headsetSppConnector.socketCallback;
            if (socketCallback != null) {
                socketCallback.connectStatus(0);
            }
            SkyWalkUtil skyWalkUtil2 = SkyWalkUtil.INSTANCE;
            String address2 = bluetoothDevice.getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
            skyWalkUtil2.disconnect(address2);
        } else {
            SocketCallback socketCallback3 = headsetSppConnector.socketCallback;
            if (socketCallback3 != null) {
                socketCallback3.connectStatus(i);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isConnect(Continuation<? super Boolean> continuation) {
        C10571 c10571;
        boolean zBooleanValue;
        if (continuation instanceof C10571) {
            c10571 = (C10571) continuation;
            if ((c10571.label & Integer.MIN_VALUE) != 0) {
                c10571.label -= Integer.MIN_VALUE;
            } else {
                c10571 = new C10571(continuation);
            }
        } else {
            c10571 = new C10571(continuation);
        }
        Object objIsConnected$default = c10571.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10571.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsConnected$default);
            XConnector xConnector = this.xSppConnector;
            zBooleanValue = false;
            if (xConnector != null) {
                c10571.label = 1;
                objIsConnected$default = XConnector.isConnected$default(xConnector, false, c10571, 1, null);
                if (objIsConnected$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objIsConnected$default);
        zBooleanValue = ((Boolean) objIsConnected$default).booleanValue();
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final void setSocketCallback(SocketCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.socketCallback = callback;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void connect$default(HeadsetSppConnector headsetSppConnector, boolean z, Function1 function1, Function1 function2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connect");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        headsetSppConnector.connect(z, function1, function2);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [T, com.nothing.link.bluetooth.sdk.connect.XConnectCallback] */
    public final void connect(boolean isForceConnect, Function1<? super XBluetoothFlowCallBack, Unit> flowCallBack, Function1<? super XConnectCallback, Unit> connectCallback) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (connectCallback != null) {
            objectRef.element = new XConnectCallback();
            connectCallback.invoke(objectRef.element);
        }
        XConnector xConnector = this.xSppConnector;
        if (xConnector != null) {
            XConnector.connect$default(xConnector, null, null, null, null, false, isForceConnect, isLeAudioConnect(), 0, false, new Function1() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return HeadsetSppConnector.connect$lambda$16(objectRef, this, (XConnectCallback) obj);
                }
            }, flowCallBack, 415, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$16(final Ref.ObjectRef objectRef, final HeadsetSppConnector headsetSppConnector, XConnectCallback connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onConnectStart(new Function0() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return HeadsetSppConnector.connect$lambda$16$lambda$9(objectRef);
            }
        });
        connect.onConnectSuccess(new Function2() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HeadsetSppConnector.connect$lambda$16$lambda$11(this.f$0, objectRef, (XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        connect.onConnectFail(new Function2() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return HeadsetSppConnector.connect$lambda$16$lambda$13(objectRef, (XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        connect.onDisConnected(new Function4() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return HeadsetSppConnector.connect$lambda$16$lambda$15(objectRef, ((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit connect$lambda$16$lambda$9(Ref.ObjectRef objectRef) {
        XConnectCallback xConnectCallback = (XConnectCallback) objectRef.element;
        if (xConnectCallback != null) {
            xConnectCallback.callConnectStart();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$16$lambda$11(HeadsetSppConnector headsetSppConnector, Ref.ObjectRef objectRef, XConnectType connectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "connect success".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "connect success " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "connect success " + strComponent2);
            }
        }
        if (headsetSppConnector.isLeAudioConnect()) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new HeadsetSppConnector$connect$1$2$2(headsetSppConnector, objectRef, connectType, xBluetoothDevice, null), 3, null);
        } else {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new HeadsetSppConnector$connect$1$2$3(objectRef, connectType, xBluetoothDevice, headsetSppConnector, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit connect$lambda$16$lambda$13(Ref.ObjectRef objectRef, XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "connect onConnectFail " + connectFailType;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        XConnectCallback xConnectCallback = (XConnectCallback) objectRef.element;
        if (xConnectCallback != null) {
            xConnectCallback.callConnectFail(xBluetoothDevice, connectFailType);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit connect$lambda$16$lambda$15(Ref.ObjectRef objectRef, boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "connect onDisConnected".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "connect onDisConnected " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "connect onDisConnected " + strComponent2);
            }
        }
        XConnectCallback xConnectCallback = (XConnectCallback) objectRef.element;
        if (xConnectCallback != null) {
            xConnectCallback.callDisConnected(z, xBluetoothDevice, bluetoothGatt, i);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object connectLeAudio(boolean z, Continuation<? super Boolean> continuation) {
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
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objSyncSend$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSyncSend$default);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(7);
            byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
            byte[] bArrArray = byteBufferAllocate.array();
            anonymousClass2.label = 1;
            objSyncSend$default = syncSend$default(this, ProtocolConstant.Set.SET_CONNECT_DEVICE, bArrArray, null, false, false, false, null, 0, anonymousClass2, 252, null);
            if (objSyncSend$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSyncSend$default);
        }
        Message message = (Message) objSyncSend$default;
        return Boxing.boxBoolean(message != null && message.isOk());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void sendMessage$default(HeadsetSppConnector headsetSppConnector, int i, byte[] bArr, boolean z, boolean z2, byte[] bArr2, int i2, Function1 function1, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessage");
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        if ((i3 & 16) != 0) {
            bArr2 = null;
        }
        if ((i3 & 32) != 0) {
            i2 = 0;
        }
        if ((i3 & 64) != 0) {
            function1 = null;
        }
        headsetSppConnector.sendMessage(i, bArr, z, z2, bArr2, i2, function1);
    }

    /* JADX WARN: Type inference failed for: r8v4, types: [T, com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback] */
    public final void sendMessage(int command, byte[] payload, boolean isSync, boolean isNeedCrc, byte[] mockResponse, int retryCount, Function1<? super XWriteCallback, Unit> writeCallback) {
        Message message = new Message(getControlFrameDeviceType(), command, true, createFsn(), payloadWithEndpoint(payload), isNeedCrc);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (writeCallback != null) {
            objectRef.element = new XWriteCallback();
            writeCallback.invoke(objectRef.element);
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C10581(message, this, retryCount, mockResponse, objectRef, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.protocol.connector.HeadsetSppConnector$sendMessage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: HeadsetSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.connector.HeadsetSppConnector$sendMessage$1", f = "HeadsetSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Message $message;
        final /* synthetic */ byte[] $mockResponse;
        final /* synthetic */ int $retryCount;
        final /* synthetic */ Ref.ObjectRef<XWriteCallback> $writeBack;
        int label;
        final /* synthetic */ HeadsetSppConnector this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10581(Message message, HeadsetSppConnector headsetSppConnector, int i, byte[] bArr, Ref.ObjectRef<XWriteCallback> objectRef, Continuation<? super C10581> continuation) {
            super(2, continuation);
            this.$message = message;
            this.this$0 = headsetSppConnector;
            this.$retryCount = i;
            this.$mockResponse = bArr;
            this.$writeBack = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10581(this.$message, this.this$0, this.$retryCount, this.$mockResponse, this.$writeBack, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            byte[] bArrObtainDataPacket = this.$message.obtainDataPacket();
            XConnector xSppConnector = this.this$0.getXSppConnector();
            if (xSppConnector != null) {
                AtomicInteger atomicInteger = new AtomicInteger(this.$retryCount);
                byte[] bArr = this.$mockResponse;
                final Ref.ObjectRef<XWriteCallback> objectRef = this.$writeBack;
                XConnector.writeWithTask$default(xSppConnector, bArrObtainDataPacket, 100L, 5000L, true, true, true, NtPeerLinkBleUuids.SERVICE_UUID, NtPeerLinkBleUuids.WRITE_UUID, bArr, atomicInteger, false, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$sendMessage$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return HeadsetSppConnector.C10581.invokeSuspend$lambda$3(objectRef, (XWriteCallback) obj2);
                    }
                }, 7168, (Object) null);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$3(final Ref.ObjectRef objectRef, XWriteCallback xWriteCallback) {
            xWriteCallback.onWriteSuccess(new Function4() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$sendMessage$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return HeadsetSppConnector.C10581.invokeSuspend$lambda$3$lambda$0(objectRef, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
                }
            });
            xWriteCallback.onWriteFail(new Function4() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$sendMessage$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return HeadsetSppConnector.C10581.invokeSuspend$lambda$3$lambda$2(objectRef, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final Unit invokeSuspend$lambda$3$lambda$0(Ref.ObjectRef objectRef, XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] bArr) {
            XWriteCallback xWriteCallback = (XWriteCallback) objectRef.element;
            if (xWriteCallback != null) {
                xWriteCallback.callWriteSuccess(xBluetoothDevice, i, i2, bArr);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final Unit invokeSuspend$lambda$3$lambda$2(Ref.ObjectRef objectRef, XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable th) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "sendMessage failed " + th;
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
            XWriteCallback xWriteCallback = (XWriteCallback) objectRef.element;
            if (xWriteCallback != null) {
                xWriteCallback.callWriteFail(xBluetoothDevice, i, i2, th);
            }
            return Unit.INSTANCE;
        }
    }

    private final String getFsnKey(Message message) {
        if (message.getIsNeedFsn()) {
            return message.getResponseCmd() + "_" + message.getFsn();
        }
        return String.valueOf(message.getResponseCmd());
    }

    public static /* synthetic */ Object syncSend$default(HeadsetSppConnector headsetSppConnector, int i, byte[] bArr, Long l, boolean z, boolean z2, boolean z3, byte[] bArr2, int i2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: syncSend");
        }
        if ((i3 & 2) != 0) {
            bArr = null;
        }
        if ((i3 & 4) != 0) {
            l = null;
        }
        if ((i3 & 8) != 0) {
            z = true;
        }
        if ((i3 & 16) != 0) {
            z2 = true;
        }
        if ((i3 & 32) != 0) {
            z3 = true;
        }
        if ((i3 & 64) != 0) {
            bArr2 = null;
        }
        if ((i3 & 128) != 0) {
            i2 = 0;
        }
        return headsetSppConnector.syncSend(i, bArr, l, z, z2, z3, bArr2, i2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object syncSend(int i, byte[] bArr, Long l, boolean z, boolean z2, boolean z3, byte[] bArr2, int i2, Continuation<? super Message> continuation) {
        C10591 c10591;
        if (continuation instanceof C10591) {
            c10591 = (C10591) continuation;
            if ((c10591.label & Integer.MIN_VALUE) != 0) {
                c10591.label -= Integer.MIN_VALUE;
            } else {
                c10591 = new C10591(continuation);
            }
        } else {
            c10591 = new C10591(continuation);
        }
        Object obj = c10591.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c10591.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Message message = new Message(getControlFrameDeviceType(), i, true, createFsn(), payloadWithEndpoint(bArr), false, 32, null);
            message.setIsNeedFsn(z);
            XConnector xConnector = this.xSppConnector;
            if (xConnector == null) {
                return null;
            }
            long jLongValue = l != null ? l.longValue() : 5000L;
            byte[] bArrObtainDataPacket = message.obtainDataPacket();
            AtomicInteger atomicInteger = new AtomicInteger(i2);
            c10591.label = 1;
            Object objWriteWithTask$default = XConnector.writeWithTask$default(xConnector, bArrObtainDataPacket, 100L, jLongValue, z3, false, false, NtPeerLinkBleUuids.SERVICE_UUID, NtPeerLinkBleUuids.WRITE_UUID, bArr2, atomicInteger, false, (String) null, (ArrayList) null, (Continuation) c10591, 7216, (Object) null);
            if (objWriteWithTask$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            obj = objWriteWithTask$default;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        byte[] bArr3 = (byte[]) obj;
        if (bArr3 != null) {
            return new Message(bArr3);
        }
        return null;
    }

    public final void handleError(final int code, final String message) {
        NTLog.e("handleError " + code + StringUtils.SPACE + message);
        this.handler.post(new Runnable() { // from class: com.nothing.protocol.connector.HeadsetSppConnector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onError(code, message);
            }
        });
    }

    private final void printCmd(String action, String key) {
        String hexString;
        List listSplit$default = StringsKt.split$default((CharSequence) key, new String[]{"_"}, false, 0, 6, (Object) null);
        String hexString2 = "";
        try {
            hexString = DataExtKt.toHexString(Integer.parseInt((String) listSplit$default.get(0)));
        } catch (Exception unused) {
            hexString = "";
        }
        try {
            hexString2 = DataExtKt.toHexString(Integer.parseInt((String) listSplit$default.get(1)));
        } catch (Exception unused2) {
        }
        NTLog.e("action:" + action + " , command: " + hexString + ",fsn:" + hexString2);
    }

    public final void onClosed() {
        SocketCallback socketCallback = this.socketCallback;
        if (socketCallback != null) {
            socketCallback.onClosed();
        }
    }

    private final void callBackMessage(Message msg) {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = msg;
        HandlerThread handlerThread = this.handlerReceiveThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                HandlerThread handlerThread2 = this.handlerReceiveThread;
                String str = "message_deal_thread isAlive " + (handlerThread2 != null && handlerThread2.isAlive()) + "! reInit thread.";
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            initReceiveHandlerThread();
        }
        DealMessageHandler dealMessageHandler = this.dealMessageHandler;
        if (dealMessageHandler != null) {
            dealMessageHandler.sendMessage(messageObtain);
        }
    }

    public final void onError(int code, String message) {
        SocketCallback socketCallback = this.socketCallback;
        if (socketCallback != null) {
            socketCallback.onError(code, message);
        }
    }

    private final void onMessage(Message message) {
        SocketCallback socketCallback = this.socketCallback;
        if (socketCallback != null) {
            socketCallback.onMessage(message);
        }
    }
}
