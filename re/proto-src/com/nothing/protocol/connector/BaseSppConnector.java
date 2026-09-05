package com.nothing.protocol.connector;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.os.Looper;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.broadcase.manager.BluetoothHelper;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.log.NTLog;
import com.nothing.log.feedback.LogFeedback;
import com.nothing.protocol.helper.SppConnectHelper;
import com.nothing.protocol.model.Message;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BaseSppConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\n\b\u0016\u0018\u0000 F2\u00020\u0001:\u0003FGHB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000f2\b\u0010+\u001a\u0004\u0018\u00010\rH\u0086@\u00a2\u0006\u0002\u0010,J\u0018\u0010-\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\rH\u0003J \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\rH\u0003J \u0010/\u001a\u00020)2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002012\u0006\u00103\u001a\u000201H\u0002J\u0006\u00104\u001a\u00020)J\u0006\u00105\u001a\u00020)J\u0018\u00107\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u000fH\u0094@\u00a2\u0006\u0002\u00108J\b\u00109\u001a\u00020)H\u0014J\u001a\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u000101H\u0014J\"\u0010>\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020?2\u0006\u0010;\u001a\u00020<2\b\u0010@\u001a\u0004\u0018\u000101H\u0016J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020<H\u0016J\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020?H\u0016J\u001a\u0010E\u001a\u00020)2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u000101H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001c8F\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001d\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u00106\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/nothing/protocol/connector/BaseSppConnector;", "", "<init>", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "connectExecutors", "Ljava/util/concurrent/ExecutorService;", "executors", "sendExecutors", "mUuid", "Ljava/util/UUID;", "mDevice", "Landroid/bluetooth/BluetoothDevice;", "mSocket", "Landroid/bluetooth/BluetoothSocket;", "syncMessageList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/nothing/protocol/model/Message;", "getSyncMessageList", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "messageList", "getMessageList", "atomicState", "Ljava/util/concurrent/atomic/AtomicInteger;", "isConnected", "", "()Z", "isDisConnected", "isRunning", "setRunning", "(Z)V", "connectTime", "", "getConnectTime", "()J", "setConnectTime", "(J)V", "connect", "", "device", "uuid", "(Landroid/bluetooth/BluetoothDevice;Ljava/util/UUID;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectInternal", "socket", "saveTraceLog", "address", "", "key", "value", "reStartSendThread", DeviceEarImage.DISCONNECT_EAR_IMAGE, "lastTime", "onConnected", "(Landroid/bluetooth/BluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosed", "onError", "code", "", "message", "onSendMessageError", "", "error", "onUpdateState", "state", "handleMessage", "byteArray", "handleError", "Companion", "SendRunnable", "ReceiveRunnable", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseSppConnector {
    public static final long CONNECT_TIME = 8000;
    private static final int DEFAULT_BUFFER_SIZE = 1344;
    public static final long SENDRUNNABLE_START_TIME = 1800;
    public static final long SEND_DELAY = 30;
    public static final int STATE_CONNECTED = 2;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_DISCONNECTING = 3;
    private AtomicInteger atomicState;
    private ExecutorService connectExecutors;
    private long connectTime;
    private final ExecutorService executors;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private boolean isRunning;
    private long lastTime;
    private BluetoothDevice mDevice;
    private BluetoothSocket mSocket;
    private UUID mUuid;
    private final CopyOnWriteArrayList<Message> messageList;
    private final ExecutorService sendExecutors;
    private final CopyOnWriteArrayList<Message> syncMessageList;
    private static final UUID DEFAULT_SPP_UUID = UUID.fromString("00001105-0000-1000-8000-00805F9B34FB");

    public void handleMessage(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onClosed() {
    }

    protected Object onConnected(BluetoothDevice bluetoothDevice, Continuation<? super Unit> continuation) {
        return onConnected$suspendImpl(this, bluetoothDevice, continuation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onError(int code, String message) {
    }

    public boolean onSendMessageError(byte[] message, int code, String error) {
        Intrinsics.checkNotNullParameter(message, "message");
        return false;
    }

    public BaseSppConnector() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.connectExecutors = executorServiceNewSingleThreadExecutor;
        ExecutorService executorServiceNewSingleThreadExecutor2 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor2, "newSingleThreadExecutor(...)");
        this.executors = executorServiceNewSingleThreadExecutor2;
        ExecutorService executorServiceNewSingleThreadExecutor3 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor3, "newSingleThreadExecutor(...)");
        this.sendExecutors = executorServiceNewSingleThreadExecutor3;
        UUID DEFAULT_SPP_UUID2 = DEFAULT_SPP_UUID;
        Intrinsics.checkNotNullExpressionValue(DEFAULT_SPP_UUID2, "DEFAULT_SPP_UUID");
        this.mUuid = DEFAULT_SPP_UUID2;
        this.syncMessageList = new CopyOnWriteArrayList<>();
        this.messageList = new CopyOnWriteArrayList<>();
        this.atomicState = new AtomicInteger(0);
        this.isRunning = true;
    }

    protected final Handler getHandler() {
        return this.handler;
    }

    public final CopyOnWriteArrayList<Message> getSyncMessageList() {
        return this.syncMessageList;
    }

    public final CopyOnWriteArrayList<Message> getMessageList() {
        return this.messageList;
    }

    public final boolean isConnected() {
        return this.atomicState.get() == 2;
    }

    public final boolean isDisConnected() {
        return this.atomicState.get() == 0;
    }

    /* JADX INFO: renamed from: isRunning, reason: from getter */
    public final boolean getIsRunning() {
        return this.isRunning;
    }

    public final void setRunning(boolean z) {
        this.isRunning = z;
    }

    public final long getConnectTime() {
        return this.connectTime;
    }

    public final void setConnectTime(long j) {
        this.connectTime = j;
    }

    public final Object connect(BluetoothDevice bluetoothDevice, UUID DEFAULT_SPP_UUID2, Continuation<? super Unit> continuation) throws IOException {
        if (this.atomicState.get() == 1) {
            LogFeedback logFeedback = LogFeedback.INSTANCE;
            String address = bluetoothDevice.getAddress();
            logFeedback.addPoint(address != null ? address : "", "BaseSppConnector", " STATE_CONNECTING");
            return Unit.INSTANCE;
        }
        if (this.atomicState.get() == 2) {
            NTLog.i("connect state is already connected." + this.atomicState + ".get()," + bluetoothDevice);
            LogFeedback logFeedback2 = LogFeedback.INSTANCE;
            String address2 = bluetoothDevice.getAddress();
            logFeedback2.addPoint(address2 != null ? address2 : "", "BaseSppConnector", "STATE_CONNECTED");
            Object objOnConnected = onConnected(bluetoothDevice, continuation);
            return objOnConnected == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objOnConnected : Unit.INSTANCE;
        }
        NTLog.i(" onUpdateState  1");
        onUpdateState(1);
        this.mDevice = bluetoothDevice;
        if (DEFAULT_SPP_UUID2 == null) {
            DEFAULT_SPP_UUID2 = DEFAULT_SPP_UUID;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_SPP_UUID2, "DEFAULT_SPP_UUID");
        }
        this.mUuid = DEFAULT_SPP_UUID2;
        if (!SppConnectHelper.INSTANCE.getInstance().isPermissions()) {
            LogFeedback logFeedback3 = LogFeedback.INSTANCE;
            String address3 = bluetoothDevice.getAddress();
            logFeedback3.addPoint(address3 != null ? address3 : "", "Bluetooth Permission denial", "BaseSppConnector no permission");
            NTLog.i(" onUpdateState  2");
            onUpdateState(0);
            handleError(257, "Missing necessary permissions");
            return Unit.INSTANCE;
        }
        connectInternal(bluetoothDevice, this.mUuid);
        return Unit.INSTANCE;
    }

    private final void connectInternal(BluetoothDevice device, UUID uuid) throws IOException {
        BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
        BluetoothAdapter bluetoothAdapter;
        BluetoothHelper helper = BluetoothBroadcast.INSTANCE.getInstance().getHelper();
        if (helper != null && (bluetoothAdapter = helper.getBluetoothAdapter()) != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        try {
            bluetoothSocketCreateRfcommSocketToServiceRecord = device.createRfcommSocketToServiceRecord(uuid);
            try {
                Intrinsics.checkNotNull(bluetoothSocketCreateRfcommSocketToServiceRecord);
                connect(device, bluetoothSocketCreateRfcommSocketToServiceRecord, uuid);
            } catch (Exception e) {
                e = e;
                LogFeedback logFeedback = LogFeedback.INSTANCE;
                String address = device.getAddress();
                if (address == null) {
                    address = "";
                }
                String message = e.getMessage();
                logFeedback.addPoint(address, "BaseSppConnector", message != null ? message : "");
                e.printStackTrace();
                if (bluetoothSocketCreateRfcommSocketToServiceRecord != null) {
                    bluetoothSocketCreateRfcommSocketToServiceRecord.close();
                }
                try {
                    bluetoothSocketCreateRfcommSocketToServiceRecord = device.createRfcommSocketToServiceRecord(uuid);
                    Intrinsics.checkNotNull(bluetoothSocketCreateRfcommSocketToServiceRecord);
                    connect(device, bluetoothSocketCreateRfcommSocketToServiceRecord, uuid);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (bluetoothSocketCreateRfcommSocketToServiceRecord != null) {
                        bluetoothSocketCreateRfcommSocketToServiceRecord.close();
                    }
                    NTLog.i(" onUpdateState  3");
                    onUpdateState(0);
                    handleError(257, e2.getMessage());
                }
            }
        } catch (Exception e3) {
            e = e3;
            bluetoothSocketCreateRfcommSocketToServiceRecord = null;
        }
    }

    private final void connect(final BluetoothDevice device, final BluetoothSocket socket, final UUID uuid) {
        String str = "";
        if (!SppConnectHelper.INSTANCE.getInstance().isPermissions()) {
            NTLog.i(" onUpdateState  4");
            LogFeedback logFeedback = LogFeedback.INSTANCE;
            String address = device.getAddress();
            logFeedback.addPoint(address != null ? address : "", "Bluetooth Permission denial", "BaseSppConnector no permission connect");
            onUpdateState(0);
            handleError(257, "Missing necessary permissions");
            return;
        }
        NTLog.d("connectExecutors state:" + this.connectExecutors.isShutdown() + "," + this.connectExecutors.isTerminated());
        LogFeedback logFeedback2 = LogFeedback.INSTANCE;
        String address2 = device.getAddress();
        if (address2 == null) {
            address2 = "";
        }
        logFeedback2.addPoint(address2, "BaseSppConnector", "connect start");
        try {
            this.connectExecutors.submit(new Callable() { // from class: com.nothing.protocol.connector.BaseSppConnector$$ExternalSyntheticLambda2
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return BaseSppConnector.connect$lambda$2(this.f$0, socket, device, uuid);
                }
            }).get(8000L, TimeUnit.MILLISECONDS);
            LogFeedback logFeedback3 = LogFeedback.INSTANCE;
            String address3 = device.getAddress();
            if (address3 != null) {
                str = address3;
            }
            logFeedback3.clearPoint(str, "BaseSppConnector", "connect success");
        } catch (Exception e) {
            e.printStackTrace();
            try {
                BluetoothSocket bluetoothSocket = this.mSocket;
                if (bluetoothSocket != null) {
                    bluetoothSocket.close();
                }
            } catch (IOException e2) {
                RouterFactory.INSTANCE.getGlobalRouter().recordException(e2);
                NTLog.e("e:" + e2.getMessage() + " socket close ");
            }
            if (e instanceof TimeoutException) {
                RouterFactory.INSTANCE.getGlobalRouter().recordException(e);
                String address4 = device.getAddress();
                Intrinsics.checkNotNullExpressionValue(address4, "getAddress(...)");
                saveTraceLog(address4, "Connection timeout", "BaseSppConnector connect failed " + e.getMessage());
            } else {
                String address5 = device.getAddress();
                Intrinsics.checkNotNullExpressionValue(address5, "getAddress(...)");
                saveTraceLog(address5, "Other error", "BaseSppConnector connect failed " + e.getMessage());
            }
            onUpdateState(0);
            handleError(257, e.getMessage());
            this.connectExecutors.shutdownNow();
            this.connectExecutors = Executors.newSingleThreadExecutor();
            NTLog.e("e:" + e.getMessage() + "  execute try ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer connect$lambda$2(BaseSppConnector baseSppConnector, BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice, UUID uuid) throws IllegalAccessException, NoSuchMethodException, IOException, InvocationTargetException {
        ReceiveRunnable receiveRunnable;
        ReceiveRunnable receiveRunnable2 = null;
        try {
            baseSppConnector.mSocket = bluetoothSocket;
            bluetoothSocket.connect();
            InputStream inputStreamCreateInputStream = RouterFactory.INSTANCE.getAppRouter().createInputStream(bluetoothDevice, bluetoothSocket, uuid);
            if (inputStreamCreateInputStream == null) {
                inputStreamCreateInputStream = bluetoothSocket.getInputStream();
            }
            NTLog.i(" onUpdateState  5 " + Thread.currentThread().getName());
            baseSppConnector.onUpdateState(2);
            ExecutorService executorService = baseSppConnector.executors;
            if (inputStreamCreateInputStream != null) {
                String address = bluetoothDevice.getAddress();
                if (address == null) {
                    address = "";
                }
                receiveRunnable = new ReceiveRunnable(baseSppConnector, address, inputStreamCreateInputStream);
            } else {
                receiveRunnable = null;
            }
            executorService.execute(receiveRunnable);
            baseSppConnector.sendExecutors.execute(baseSppConnector.new SendRunnable());
        } catch (IOException e) {
            e.printStackTrace();
            bluetoothSocket.close();
            Method method = bluetoothDevice.getClass().getMethod("createRfcommSocket", Integer.TYPE);
            method.setAccessible(true);
            Object objInvoke = method.invoke(bluetoothDevice, 15);
            if (objInvoke != null && (objInvoke instanceof BluetoothSocket)) {
                BluetoothSocket bluetoothSocket2 = (BluetoothSocket) objInvoke;
                baseSppConnector.mSocket = bluetoothSocket2;
                bluetoothSocket2.connect();
                InputStream inputStreamCreateInputStream2 = RouterFactory.INSTANCE.getAppRouter().createInputStream(bluetoothDevice, bluetoothSocket2, uuid);
                if (inputStreamCreateInputStream2 == null) {
                    inputStreamCreateInputStream2 = bluetoothSocket2.getInputStream();
                }
                NTLog.i(" onUpdateState  6");
                baseSppConnector.onUpdateState(2);
                ExecutorService executorService2 = baseSppConnector.executors;
                if (inputStreamCreateInputStream2 != null) {
                    String address2 = bluetoothDevice.getAddress();
                    receiveRunnable2 = new ReceiveRunnable(baseSppConnector, address2 != null ? address2 : "", inputStreamCreateInputStream2);
                }
                executorService2.execute(receiveRunnable2);
                baseSppConnector.sendExecutors.execute(baseSppConnector.new SendRunnable());
            }
        }
        return 2;
    }

    /* JADX INFO: renamed from: com.nothing.protocol.connector.BaseSppConnector$saveTraceLog$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.connector.BaseSppConnector$saveTraceLog$1", f = "BaseSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        final /* synthetic */ String $key;
        final /* synthetic */ String $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10561(String str, String str2, String str3, Continuation<? super C10561> continuation) {
            super(2, continuation);
            this.$address = str;
            this.$key = str2;
            this.$value = str3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10561(this.$address, this.$key, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            DeviceItem deviceItem;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<DeviceItem> deviceItem2 = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(this.$address);
            String modelId = (deviceItem2 == null || (deviceItem = (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem2)) == null) ? null : deviceItem.getModelId();
            LogFeedback logFeedback = LogFeedback.INSTANCE;
            String str = this.$address;
            if (str == null) {
                str = "";
            }
            logFeedback.stopPoint(modelId, str, this.$key, this.$value);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void saveTraceLog(String address, String key, String value) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C10561(address, key, value, null), 3, null);
    }

    public final void reStartSendThread() {
        if (isConnected()) {
            this.sendExecutors.execute(new SendRunnable());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void disconnect() {
        if (this.atomicState.get() == 0) {
            return;
        }
        NTLog.i(" onUpdateState  10");
        onUpdateState(3);
        try {
            try {
                BluetoothSocket bluetoothSocket = this.mSocket;
                if (bluetoothSocket != null) {
                    bluetoothSocket.close();
                }
                NTLog.i(" onUpdateState  11");
                onUpdateState(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.mSocket = null;
            this.mDevice = null;
        }
    }

    /* JADX INFO: compiled from: BaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/nothing/protocol/connector/BaseSppConnector$SendRunnable;", "Ljava/lang/Runnable;", "<init>", "(Lcom/nothing/protocol/connector/BaseSppConnector;)V", "run", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class SendRunnable implements Runnable {
        public SendRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() throws InterruptedException {
            boolean z;
            Message message;
            OutputStream outputStream;
            OutputStream outputStream2;
            BaseSppConnector.this.setRunning(true);
            while (BaseSppConnector.this.getIsRunning()) {
                if (!BaseSppConnector.this.getSyncMessageList().isEmpty()) {
                    message = (Message) CollectionsKt.removeFirstOrNull(BaseSppConnector.this.getSyncMessageList());
                    NTLog.i("SendRunnable get syncMessageList " + message + ",syncMessageList size = " + BaseSppConnector.this.getSyncMessageList().size());
                    z = true;
                } else if (BaseSppConnector.this.getMessageList().isEmpty()) {
                    z = false;
                    message = null;
                } else {
                    message = (Message) CollectionsKt.removeFirstOrNull(BaseSppConnector.this.getMessageList());
                    NTLog.i("SendRunnable get messageList " + message + ",messageList size = " + BaseSppConnector.this.getMessageList().size());
                    z = false;
                }
                if (message != null) {
                    byte[] bArrObtainDataPacket = message.obtainDataPacket();
                    if (z) {
                        try {
                            NTLog.i("SendRunnable Test Send end sync Message " + DataExtKt.contentToHexString(bArrObtainDataPacket));
                        } catch (Exception e) {
                            e.printStackTrace();
                            BaseSppConnector.this.onSendMessageError(bArrObtainDataPacket, 259, e.getMessage());
                            BaseSppConnector.this.handleError(259, e.getMessage());
                            NTLog.e("SendRunnable IOException " + e.getMessage());
                            BluetoothSocket bluetoothSocket = BaseSppConnector.this.mSocket;
                            if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
                                NTLog.e("SendRunnable IOException mSocket connect");
                            } else {
                                NTLog.i(" onUpdateState  12");
                                BaseSppConnector.this.onUpdateState(0);
                                BaseSppConnector.this.setRunning(false);
                            }
                        }
                    } else {
                        NTLog.i("SendRunnable Test Send send async Message " + DataExtKt.contentToHexString(bArrObtainDataPacket));
                    }
                    if (BaseSppConnector.this.isConnected()) {
                        long jCurrentTimeMillis = BaseSppConnector.this.lastTime == 0 ? -1L : System.currentTimeMillis() - BaseSppConnector.this.lastTime;
                        BaseSppConnector.this.lastTime = System.currentTimeMillis();
                        BluetoothSocket bluetoothSocket2 = BaseSppConnector.this.mSocket;
                        NTLog.i("SendRunnable  flush before  async message(" + z + ") , gap is " + jCurrentTimeMillis + " ms,socket state :" + (bluetoothSocket2 != null ? Boolean.valueOf(bluetoothSocket2.isConnected()) : null));
                        NTLog.i("SendRunnable data " + DataExtKt.contentToHexString(bArrObtainDataPacket));
                        BluetoothSocket bluetoothSocket3 = BaseSppConnector.this.mSocket;
                        if (bluetoothSocket3 != null && (outputStream2 = bluetoothSocket3.getOutputStream()) != null) {
                            outputStream2.write(bArrObtainDataPacket);
                        }
                        BluetoothSocket bluetoothSocket4 = BaseSppConnector.this.mSocket;
                        if (bluetoothSocket4 != null && (outputStream = bluetoothSocket4.getOutputStream()) != null) {
                            outputStream.flush();
                        }
                        NTLog.i("SendRunnable  flush Success use " + (System.currentTimeMillis() - BaseSppConnector.this.lastTime) + " ms");
                        Thread.sleep(30L);
                    } else {
                        if (!BaseSppConnector.this.onSendMessageError(bArrObtainDataPacket, 260, null)) {
                            BaseSppConnector.this.handleError(260, null);
                        }
                        NTLog.i("SendRunnable  jump to out side isConnected = false");
                        return;
                    }
                } else {
                    Thread.sleep(30L);
                }
            }
        }
    }

    static /* synthetic */ Object onConnected$suspendImpl(BaseSppConnector baseSppConnector, BluetoothDevice bluetoothDevice, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public void onUpdateState(int state) {
        if (state == this.atomicState.get()) {
            NTLog.w("onUpdateState ignore  state  " + state);
            return;
        }
        this.atomicState.set(state);
        NTLog.w("onUpdateState -->> " + state);
        int i = this.atomicState.get();
        if (i == 0) {
            this.isRunning = false;
            this.handler.post(new Runnable() { // from class: com.nothing.protocol.connector.BaseSppConnector$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.onClosed();
                }
            });
        } else {
            if (i != 2) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.connector.BaseSppConnector$onUpdateState$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.connector.BaseSppConnector$onUpdateState$1", f = "BaseSppConnector.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseSppConnector.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BaseSppConnector baseSppConnector = BaseSppConnector.this;
                this.label = 1;
                if (baseSppConnector.onConnected(baseSppConnector.mDevice, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public void handleError(final int code, final String message) {
        NTLog.e("handleError " + code + StringUtils.SPACE + message);
        this.handler.post(new Runnable() { // from class: com.nothing.protocol.connector.BaseSppConnector$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.onError(code, message);
            }
        });
    }

    /* JADX INFO: compiled from: BaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/protocol/connector/BaseSppConnector$ReceiveRunnable;", "Ljava/lang/Runnable;", "mac", "", "inputStream", "Ljava/io/InputStream;", "<init>", "(Lcom/nothing/protocol/connector/BaseSppConnector;Ljava/lang/String;Ljava/io/InputStream;)V", "getMac", "()Ljava/lang/String;", "getInputStream", "()Ljava/io/InputStream;", "run", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private final class ReceiveRunnable implements Runnable {
        private final InputStream inputStream;
        private final String mac;
        final /* synthetic */ BaseSppConnector this$0;

        public ReceiveRunnable(BaseSppConnector baseSppConnector, String mac, InputStream inputStream) {
            Intrinsics.checkNotNullParameter(mac, "mac");
            Intrinsics.checkNotNullParameter(inputStream, "inputStream");
            this.this$0 = baseSppConnector;
            this.mac = mac;
            this.inputStream = inputStream;
        }

        public final InputStream getInputStream() {
            return this.inputStream;
        }

        public final String getMac() {
            return this.mac;
        }

        @Override // java.lang.Runnable
        public void run() {
            byte[] bArr = new byte[BaseSppConnector.DEFAULT_BUFFER_SIZE];
            while (this.this$0.isConnected()) {
                try {
                    int i = this.inputStream.read(bArr);
                    NTLog.d("message reading len is ..." + i);
                    if (i > 0) {
                        this.this$0.handleMessage(ArraysKt.copyOfRange(bArr, 0, i));
                    } else if (i < 0 && this.this$0.isConnected()) {
                        this.this$0.handleError(258, "close");
                        NTLog.w("disconnect ReceiveRunnable  SPP_RECEIVE_MESSAGE_FAIL 1 " + Thread.currentThread().getName());
                        this.this$0.saveTraceLog(this.mac, "ReceiveRunnable", "len < 0");
                        this.this$0.disconnect();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (this.this$0.isConnected()) {
                        this.this$0.handleError(258, e.getMessage());
                        NTLog.w("disconnect ReceiveRunnable  SPP_RECEIVE_MESSAGE_FAIL 2 " + Thread.currentThread().getName());
                        this.this$0.saveTraceLog(this.mac, "ReceiveRunnable", "IOException " + e.getMessage());
                        this.this$0.disconnect();
                    }
                }
            }
            try {
                this.inputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            NTLog.w(" onUpdateState  13");
            this.this$0.onUpdateState(0);
        }
    }
}
