package com.nothing.protocol.device;

import android.app.Activity;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.MutableLiveData;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.nothing.base.model.BaseDevice;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.DeviceConfiguration;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.broadcase.ext.BluetoothDeviceExtKt;
import com.nothing.broadcase.manager.BluetoothHelper;
import com.nothing.cardwidget.mediaplayer.utils.DisplayConfig;
import com.nothing.database.dao.DeviceItemDao;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.earbase.base.ActivityManager;
import com.nothing.earbase.equalizer.EqualizerDisconnectGuard;
import com.nothing.earbase.essential.RecordingUtils;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.generate.NtDeviceParams;
import com.nothing.generate.NtEarFlutterApi;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.scan.XBluetoothFlowCallBack;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.log.feedback.LogFeedback;
import com.nothing.nt_ear.NtEarPlugin;
import com.nothing.protocol.SPPConnect;
import com.nothing.protocol.connector.HeadsetSppConnector;
import com.nothing.protocol.helper.SppConnectHelper;
import com.nothing.protocol.model.Message;
import com.nothing.protocol.model.ProtocolModel;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.TimeoutKt;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: TWSDevice.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u009e\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0007\u0010\bJ\f\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001f0LJ\u0006\u0010M\u001a\u00020'J\u0006\u0010N\u001a\u00020'J\u0006\u0010O\u001a\u00020PJ\u0010\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020\u001fH\u0016J\n\u0010S\u001a\u0004\u0018\u00010\u0015H\u0002J\u0006\u0010T\u001a\u00020\u0015J\u0006\u0010U\u001a\u00020\u0015J\u0010\u0010V\u001a\u00020'2\b\u0010W\u001a\u0004\u0018\u00010\u0015J\u000e\u0010X\u001a\u00020P2\u0006\u0010Y\u001a\u00020\u0016J\u000e\u0010Z\u001a\u00020P2\u0006\u0010Y\u001a\u00020\u0016J\u0010\u0010[\u001a\u00020P2\b\b\u0002\u0010\\\u001a\u00020'JJ\u0010]\u001a\u00020P2\b\b\u0002\u0010\\\u001a\u00020'2\u001b\b\u0002\u0010^\u001a\u0015\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020P\u0018\u00010_\u00a2\u0006\u0002\ba2\u001b\b\u0002\u0010b\u001a\u0015\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020P\u0018\u00010_\u00a2\u0006\u0002\baJ\b\u0010d\u001a\u00020PH\u0002J\u0018\u0010e\u001a\u00020'2\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010gH\u0002J\u000e\u0010h\u001a\u00020PH\u0082@\u00a2\u0006\u0002\u0010iJ\u0006\u0010j\u001a\u00020PJ\u0006\u0010k\u001a\u00020PJ\u0006\u0010l\u001a\u00020PJ\u0006\u0010m\u001a\u00020PJ&\u0010n\u001a\u00020P2\n\u0010o\u001a\u00020p\"\u00020\u001f2\b\b\u0002\u0010q\u001a\u00020'2\b\b\u0002\u0010r\u001a\u00020'J\u0018\u0010s\u001a\u00020P2\u0006\u0010o\u001a\u00020\u001f2\b\u0010t\u001a\u0004\u0018\u00010uJ \u0010v\u001a\u00020P2\u0006\u0010o\u001a\u00020\u001f2\u0006\u0010w\u001a\u00020 2\b\b\u0002\u0010x\u001a\u00020'J\u0010\u0010y\u001a\u0004\u0018\u00010 2\u0006\u0010o\u001a\u00020\u001fJ\u000e\u0010z\u001a\u00020P2\u0006\u0010o\u001a\u00020\u001fJ\u0006\u0010{\u001a\u00020PJQ\u0010|\u001a\u0004\u0018\u00010 2\u0006\u0010o\u001a\u00020\u001f2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010u2\b\b\u0002\u0010q\u001a\u00020'2\b\b\u0002\u0010r\u001a\u00020'2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~2\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010uH\u0086@\u00a2\u0006\u0003\u0010\u0080\u0001J\u0019\u0010\u0081\u0001\u001a\u00020P2\u0006\u0010o\u001a\u00020\u001f2\u0006\u0010w\u001a\u00020 H\u0002JX\u0010\u0082\u0001\u001a\u00020P2\u0006\u0010o\u001a\u00020\u001f2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010u2\b\b\u0002\u0010q\u001a\u00020'2\b\b\u0002\u0010r\u001a\u00020'2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~2\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010u2\t\b\u0002\u0010\u0083\u0001\u001a\u00020\u001f\u00a2\u0006\u0003\u0010\u0084\u0001J\u0007\u0010\u0085\u0001\u001a\u00020PJ;\u0010\u0086\u0001\u001a\u00020'2\u0006\u0010o\u001a\u00020\u001f2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010u2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~2\t\b\u0002\u0010\u0087\u0001\u001a\u00020'H\u0086@\u00a2\u0006\u0003\u0010\u0088\u0001JT\u0010\u0089\u0001\u001a\u0004\u0018\u00010 2\u0006\u0010o\u001a\u00020\u001f2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010u2\n\b\u0002\u0010}\u001a\u0004\u0018\u00010~2\t\b\u0002\u0010\u0087\u0001\u001a\u00020'2\t\b\u0002\u0010\u008a\u0001\u001a\u00020'2\n\b\u0002\u0010\u007f\u001a\u0004\u0018\u00010uH\u0086@\u00a2\u0006\u0003\u0010\u008b\u0001J\u000f\u0010\u008c\u0001\u001a\u00020PH\u0086@\u00a2\u0006\u0002\u0010iJ\t\u0010\u008d\u0001\u001a\u00020PH\u0016J\u001c\u0010\u008e\u0001\u001a\u00020P2\u0007\u0010\u008f\u0001\u001a\u00020\u001f2\b\u0010w\u001a\u0004\u0018\u00010\u0015H\u0016J\u0011\u0010\u0090\u0001\u001a\u00020P2\u0006\u0010w\u001a\u00020 H\u0016J\u0011\u0010\u0091\u0001\u001a\u00020P2\u0006\u0010w\u001a\u00020 H\u0016J\u001a\u0010\u0092\u0001\u001a\u00020P2\u0007\u0010\u0093\u0001\u001a\u00020\u001f2\u0006\u0010w\u001a\u00020 H\u0002J\u0011\u0010\u0094\u0001\u001a\u00020P2\u0006\u0010w\u001a\u00020 H\u0002J\u0011\u0010\u0095\u0001\u001a\u00020P2\u0006\u0010w\u001a\u00020 H\u0002J\t\u0010\u0096\u0001\u001a\u00020PH\u0016J\u0019\u0010\u0097\u0001\u001a\u00020P2\u0007\u0010\u0093\u0001\u001a\u00020\u001f2\u0007\u0010\u0098\u0001\u001a\u00020 J\u001b\u0010\u0099\u0001\u001a\u00020P2\u0007\u0010\u0093\u0001\u001a\u00020\u001f2\u0007\u0010\u0098\u0001\u001a\u00020 H\u0002J/\u0010\u009a\u0001\u001a\u00020P2$\u0010\u009b\u0001\u001a\u001f\u0012\u0015\u0012\u00130\u0016\u00a2\u0006\u000e\b\u009c\u0001\u0012\t\b*\u0012\u0005\b\b(\u009d\u0001\u0012\u0004\u0012\u00020P0_H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b#\u0010$R\u0011\u0010&\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b&\u0010(R\u0011\u0010)\u001a\u00020'8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010(R\u0011\u0010*\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010\u00158F\u00a2\u0006\u0006\u001a\u0004\b.\u0010,R\u001c\u0010/\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010,\"\u0004\b1\u00102R\u001c\u00103\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010,\"\u0004\b5\u00102R\u001a\u00106\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010,\"\u0004\b8\u00102R\u001c\u00109\u001a\u0004\u0018\u00010:X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010(\"\u0004\b@\u0010AR\u001a\u0010B\u001a\u00020'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010(\"\u0004\bD\u0010AR\u001a\u0010E\u001a\u00020'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010(\"\u0004\bG\u0010AR\u001a\u0010H\u001a\u00020'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010(\"\u0004\bJ\u0010A\u00a8\u0006\u009f\u0001"}, d2 = {"Lcom/nothing/protocol/device/TWSDevice;", "Lcom/nothing/protocol/connector/HeadsetSppConnector$SocketCallback;", "Lcom/nothing/base/model/BaseDevice;", "device", "Landroid/bluetooth/BluetoothDevice;", "protocol", "Lcom/nothing/protocol/model/ProtocolModel;", "<init>", "(Landroid/bluetooth/BluetoothDevice;Lcom/nothing/protocol/model/ProtocolModel;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getProtocol", "()Lcom/nothing/protocol/model/ProtocolModel;", "sppConnector", "Lcom/nothing/protocol/connector/HeadsetSppConnector;", "getSppConnector", "()Lcom/nothing/protocol/connector/HeadsetSppConnector;", "sppConnector$delegate", "Lkotlin/Lazy;", "callbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "getCallbacks", "()Ljava/util/concurrent/ConcurrentHashMap;", "mainHandler", "Landroid/os/Handler;", "getMainHandler", "()Landroid/os/Handler;", "mainHandler$delegate", "cacheMap", "", "Lcom/nothing/protocol/model/Message;", "commandCache", "Lcom/nothing/protocol/device/TWSCommandCache;", "getCommandCache", "()Lcom/nothing/protocol/device/TWSCommandCache;", "commandCache$delegate", "isConnectedWithTimeOut", "", "()Z", "isConnected", "name", "getName", "()Ljava/lang/String;", "address", "getAddress", "version", "getVersion", "setVersion", "(Ljava/lang/String;)V", "sn", "getSn", "setSn", "modelId", "getModelId", "setModelId", "flutterDevice", "Lcom/nothing/generate/NtDeviceParams;", "getFlutterDevice", "()Lcom/nothing/generate/NtDeviceParams;", "setFlutterDevice", "(Lcom/nothing/generate/NtDeviceParams;)V", "isAutoStart", "setAutoStart", "(Z)V", "retryConnect", "getRetryConnect", "setRetryConnect", "queryAudio", "getQueryAudio", "setQueryAudio", "phoneAudio", "getPhoneAudio", "setPhoneAudio", "getConnectedLiveData", "Landroidx/lifecycle/MutableLiveData;", "isClassicConnected", "isClassicConnectedWithTimeOut", "resetFsn", "", "connectStatus", NotificationCompat.CATEGORY_STATUS, "getAlias", "getDeviceName", "getDeviceNameWithTimeOut", "setAlias", MimeTypesReaderMetKeys.ALIAS_TAG, "register", "callback", "unregister", "connectWithTimeout", "isWidgetAutoConnect", "connect", "connectCallback", "Lkotlin/Function1;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;", "Lkotlin/ExtensionFunctionType;", "flowCallBack", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "printBluetoothA2dpStatus", "checkConnectIfNeed", "list", "", "checkDelayRunning", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connecting", DeviceEarImage.DISCONNECT_EAR_IMAGE, "openBluetooth", "release", "sendCommands", "command", "", "ignoreClassicBluetooth", "needCache", "setCacheCommandsManualPayload", "payload", "", "setCacheCommandsManual", "message", "isUpdate", "getCacheCommandsManual", "updateFromCache", "getCurrentAnc", "sendMessageSync", "timeOut", "", "mockResponse", "(I[BZZLjava/lang/Long;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAndRefresh", "sendMessage", "retryCount", "(I[BZZLjava/lang/Long;[BI)V", "clearLogHandlerMessage", "syncSet", "isNeedFsn", "(I[BLjava/lang/Long;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncSetResponse", "needUpdate", "(I[BLjava/lang/Long;ZZ[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestVersion", "onClosed", "onError", "code", "onMessage", "onMessageNew", "getFlutterNoise", "cmdType", "cacheGetCommandData", "interceptorCommand", "sendUtcTime", "onUpdate", "data", "updateSn", "callbackEach", "action", "Lkotlin/ParameterName;", "callBack", "Callback", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TWSDevice extends BaseDevice implements HeadsetSppConnector.SocketCallback {
    private final ConcurrentHashMap<Integer, Message> cacheMap;
    private final ConcurrentHashMap<String, Callback> callbacks;

    /* JADX INFO: renamed from: commandCache$delegate, reason: from kotlin metadata */
    private final Lazy commandCache;
    private final BluetoothDevice device;
    private NtDeviceParams flutterDevice;
    private boolean isAutoStart;

    /* JADX INFO: renamed from: mainHandler$delegate, reason: from kotlin metadata */
    private final Lazy mainHandler;
    private String modelId;
    private boolean phoneAudio;
    private final ProtocolModel protocol;
    private boolean queryAudio;
    private boolean retryConnect;
    private String sn;

    /* JADX INFO: renamed from: sppConnector$delegate, reason: from kotlin metadata */
    private final Lazy sppConnector;
    private String version;

    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\"\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/protocol/device/TWSDevice$Callback;", "", "onConnecting", "", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "isIOThread", "", "onConnected", "onDisconnected", "onError", "code", "", "message", "", "onUpdate", "cmdType", "data", "Lcom/nothing/protocol/model/Message;", "openBluetooth", "getBesVersionSuccess", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface Callback {

        /* JADX INFO: compiled from: TWSDevice.kt */
        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        public static final class DefaultImpls {
            public static void getBesVersionSuccess(Callback callback) {
            }

            public static boolean isIOThread(Callback callback) {
                return false;
            }

            public static void onConnected(Callback callback, TWSDevice twsDevice) {
                Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
            }

            public static void onConnecting(Callback callback, TWSDevice twsDevice) {
                Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
            }

            public static void onDisconnected(Callback callback, TWSDevice twsDevice) {
                Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
            }

            public static void onError(Callback callback, TWSDevice twsDevice) {
                Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
            }

            public static void onError(Callback callback, TWSDevice twsDevice, int i, String str) {
                Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
            }

            public static void onUpdate(Callback callback, int i, Message data, TWSDevice twsDevice) {
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
            }

            public static void openBluetooth(Callback callback, TWSDevice twsDevice) {
                Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
            }
        }

        void getBesVersionSuccess();

        boolean isIOThread();

        void onConnected();

        void onConnected(TWSDevice twsDevice);

        void onConnecting(TWSDevice twsDevice);

        void onDisconnected();

        void onDisconnected(TWSDevice twsDevice);

        void onError(int code, String message);

        void onError(TWSDevice twsDevice);

        void onError(TWSDevice twsDevice, int code, String message);

        void onUpdate(int cmdType, Message data);

        void onUpdate(int cmdType, Message data, TWSDevice twsDevice);

        void openBluetooth(TWSDevice twsDevice);
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$requestVersion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice", f = "TWSDevice.kt", i = {0}, l = {455, 459}, m = "requestVersion", n = {"this"}, s = {"L$0"})
    static final class C10631 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10631(Continuation<? super C10631> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TWSDevice.this.requestVersion(this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$sendMessageSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice", f = "TWSDevice.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 2}, l = {355, 373, 375}, m = "sendMessageSync", n = {"this", "payload", "timeOut", "mockResponse", "command", "ignoreClassicBluetooth", "needCache", "this", "command", "message"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "Z$0", "Z$1", "L$0", "I$0", "L$0"})
    static final class C10641 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C10641(Continuation<? super C10641> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TWSDevice.this.sendMessageSync(0, null, false, false, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$syncSet$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice", f = "TWSDevice.kt", i = {}, l = {426}, m = "syncSet", n = {}, s = {})
    static final class C10651 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10651(Continuation<? super C10651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TWSDevice.this.syncSet(0, null, null, false, this);
        }
    }

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final ProtocolModel getProtocol() {
        return this.protocol;
    }

    public TWSDevice(BluetoothDevice device, ProtocolModel protocol) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        this.device = device;
        this.protocol = protocol;
        this.sppConnector = LazyKt.lazy(new Function0() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TWSDevice.sppConnector_delegate$lambda$0(this.f$0);
            }
        });
        this.callbacks = new ConcurrentHashMap<>();
        this.mainHandler = LazyKt.lazy(new Function0() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TWSDevice.mainHandler_delegate$lambda$1();
            }
        });
        this.cacheMap = new ConcurrentHashMap<>();
        this.commandCache = LazyKt.lazy(new Function0() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TWSDevice.commandCache_delegate$lambda$2();
            }
        });
        this.modelId = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HeadsetSppConnector sppConnector_delegate$lambda$0(TWSDevice tWSDevice) {
        return new HeadsetSppConnector(tWSDevice, tWSDevice.protocol, tWSDevice.device);
    }

    public final HeadsetSppConnector getSppConnector() {
        return (HeadsetSppConnector) this.sppConnector.getValue();
    }

    public final ConcurrentHashMap<String, Callback> getCallbacks() {
        return this.callbacks;
    }

    private final Handler getMainHandler() {
        return (Handler) this.mainHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler mainHandler_delegate$lambda$1() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TWSCommandCache commandCache_delegate$lambda$2() {
        return new TWSCommandCache();
    }

    public final TWSCommandCache getCommandCache() {
        return (TWSCommandCache) this.commandCache.getValue();
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$isConnectedWithTimeOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$isConnectedWithTimeOut$1", f = "TWSDevice.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    static final class C10621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C10621(Continuation<? super C10621> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TWSDevice.this.new C10621(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C10621) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$isConnectedWithTimeOut$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TWSDevice.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$isConnectedWithTimeOut$1$1", f = "TWSDevice.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
        static final class C02141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ TWSDevice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02141(TWSDevice tWSDevice, Continuation<? super C02141> continuation) {
                super(2, continuation);
                this.this$0 = tWSDevice;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02141(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                return ((C02141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i != 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                Object objIsConnect = this.this$0.getSppConnector().isConnect(this);
                return objIsConnect == coroutine_suspended ? coroutine_suspended : objIsConnect;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(100L, new C02141(TWSDevice.this, null), this);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        }
    }

    public final boolean isConnectedWithTimeOut() {
        return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new C10621(null), 1, null)).booleanValue();
    }

    public final boolean isConnected() {
        return isConnectedWithTimeOut();
    }

    public final String getName() {
        return SppConnectHelper.INSTANCE.getInstance().isPermissions() ? getDeviceName() : "";
    }

    public final String getAddress() {
        return this.device.getAddress();
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getSn() {
        return this.sn;
    }

    public final void setSn(String str) {
        this.sn = str;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final void setModelId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.modelId = str;
    }

    public final NtDeviceParams getFlutterDevice() {
        return this.flutterDevice;
    }

    public final void setFlutterDevice(NtDeviceParams ntDeviceParams) {
        this.flutterDevice = ntDeviceParams;
    }

    /* JADX INFO: renamed from: isAutoStart, reason: from getter */
    public final boolean getIsAutoStart() {
        return this.isAutoStart;
    }

    public final void setAutoStart(boolean z) {
        this.isAutoStart = z;
    }

    public final boolean getRetryConnect() {
        return this.retryConnect;
    }

    public final void setRetryConnect(boolean z) {
        this.retryConnect = z;
    }

    public final boolean getQueryAudio() {
        return this.queryAudio;
    }

    public final void setQueryAudio(boolean z) {
        this.queryAudio = z;
    }

    public final boolean getPhoneAudio() {
        return this.phoneAudio;
    }

    public final void setPhoneAudio(boolean z) {
        this.phoneAudio = z;
    }

    public final MutableLiveData<Integer> getConnectedLiveData() {
        return getCommandCache().getConnectStateLiveData();
    }

    public final boolean isClassicConnected() {
        return SPPConnect.INSTANCE.getInstance().isClassicConnected(this.device);
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$isClassicConnectedWithTimeOut$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$isClassicConnectedWithTimeOut$1", f = "TWSDevice.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    static final class C10611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        C10611(Continuation<? super C10611> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TWSDevice.this.new C10611(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C10611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$isClassicConnectedWithTimeOut$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TWSDevice.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$isClassicConnectedWithTimeOut$1$1", f = "TWSDevice.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C02131 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ TWSDevice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02131(TWSDevice tWSDevice, Continuation<? super C02131> continuation) {
                super(2, continuation);
                this.this$0 = tWSDevice;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02131(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                return ((C02131) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(SPPConnect.INSTANCE.getInstance().isClassicConnected(this.this$0.getDevice()));
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(1500L, new C02131(TWSDevice.this, null), this);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        }
    }

    public final boolean isClassicConnectedWithTimeOut() {
        return ((Boolean) BuildersKt__BuildersKt.runBlocking$default(null, new C10611(null), 1, null)).booleanValue();
    }

    public final void resetFsn() {
        getSppConnector().resetFsn();
    }

    @Override // com.nothing.protocol.connector.HeadsetSppConnector.SocketCallback
    public void connectStatus(final int status) {
        Integer value = getCommandCache().getConnectStateLiveData().getValue();
        if (value != null && value.intValue() == status) {
            return;
        }
        getMainHandler().post(new Runnable() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                TWSDevice.connectStatus$lambda$7(this.f$0, status);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void connectStatus$lambda$7(final TWSDevice tWSDevice, int i) {
        tWSDevice.getCommandCache().updateConnectStatus(i);
        if (i != 0) {
            if (i != 2) {
                return;
            }
            for (Map.Entry<String, Callback> entry : tWSDevice.callbacks.entrySet()) {
                entry.getValue().onConnected();
                entry.getValue().onConnected(tWSDevice);
            }
            return;
        }
        tWSDevice.getCommandCache().clearCommandCache();
        tWSDevice.isAutoStart = false;
        for (Map.Entry<String, Callback> entry2 : tWSDevice.callbacks.entrySet()) {
            entry2.getValue().onDisconnected();
            entry2.getValue().onDisconnected(tWSDevice);
        }
        if (Intrinsics.areEqual(SpUtils.INSTANCE.getSelectDeviceMac(), tWSDevice.getAddress())) {
            ActivityManager.INSTANCE.finishAllExcludeActivity(false, new Function1() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(TWSDevice.connectStatus$lambda$7$lambda$6(this.f$0, (Activity) obj));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean connectStatus$lambda$7$lambda$6(TWSDevice tWSDevice, Activity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        boolean z = StringsKt.contains$default((CharSequence) it.toString(), (CharSequence) "MainActivity", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) it.toString(), (CharSequence) "ConfigActivity", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) it.toString(), (CharSequence) "LocalFirmwareActivity", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) it.toString(), (CharSequence) "FeedBackActivity", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) it.toString(), (CharSequence) "TouchDebugActivity", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) it.toString(), (CharSequence) "PressureDebugActivity", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) it.toString(), (CharSequence) "EarDebugToolActivity", false, 2, (Object) null) || EqualizerDisconnectGuard.INSTANCE.shouldKeepAlive(it);
        if (!z) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = tWSDevice.getAddress() + " disconnect need finish page " + it;
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
        }
        return z;
    }

    private final String getAlias() {
        try {
            Method method = this.device.getClass().getMethod("getAlias", new Class[0]);
            method.setAccessible(true);
            Object objInvoke = method.invoke(this.device, new Object[0]);
            if (objInvoke != null) {
                return objInvoke.toString();
            }
            return null;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String getDeviceName() {
        DeviceItem deviceItem;
        String name;
        String alias = getAlias();
        if (alias != null) {
            return alias;
        }
        if (BluetoothBroadcast.INSTANCE.getInstance().bluetoothEnable() && BluetoothBroadcast.INSTANCE.getInstance().hasPermission()) {
            return BluetoothDeviceExtKt.getDeviceName(this.device);
        }
        DeviceItemDao deviceDao = DatabaseUtils.INSTANCE.getDeviceDao();
        String address = getAddress();
        if (address == null) {
            address = "";
        }
        List<DeviceItem> deviceItem2 = deviceDao.getDeviceItem(address);
        return (deviceItem2 == null || (deviceItem = (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem2)) == null || (name = deviceItem.getName()) == null) ? "" : name;
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$getDeviceNameWithTimeOut$1, reason: invalid class name */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$getDeviceNameWithTimeOut$1", f = "TWSDevice.kt", i = {}, l = {194}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TWSDevice.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$getDeviceNameWithTimeOut$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: TWSDevice.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$getDeviceNameWithTimeOut$1$1", f = "TWSDevice.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C02121 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
            int label;
            final /* synthetic */ TWSDevice this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02121(TWSDevice tWSDevice, Continuation<? super C02121> continuation) {
                super(2, continuation);
                this.this$0 = tWSDevice;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02121(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
                return ((C02121) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return this.this$0.getDeviceName();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(500L, new C02121(TWSDevice.this, null), this);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        }
    }

    public final String getDeviceNameWithTimeOut() {
        return (String) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(null), 1, null);
    }

    public final boolean setAlias(String alias) {
        try {
            Method method = this.device.getClass().getMethod("setAlias", String.class);
            method.setAccessible(true);
            return Intrinsics.areEqual(method.invoke(this.device, alias), (Object) true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void register(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.callbacks.contains(callback.toString())) {
            return;
        }
        this.callbacks.put(callback.toString(), callback);
    }

    public final void unregister(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.remove(callback.toString());
    }

    public static /* synthetic */ void connectWithTimeout$default(TWSDevice tWSDevice, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        tWSDevice.connectWithTimeout(z);
    }

    public final void connectWithTimeout(boolean isWidgetAutoConnect) {
        connect$default(this, isWidgetAutoConnect, null, null, 6, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void connect$default(TWSDevice tWSDevice, boolean z, Function1 function1, Function1 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function2 = null;
        }
        tWSDevice.connect(z, function1, function2);
    }

    public final void connect(boolean isWidgetAutoConnect, Function1<? super XConnectCallback, Unit> connectCallback, Function1<? super XBluetoothFlowCallBack, Unit> flowCallBack) {
        getSppConnector().connect(!isWidgetAutoConnect, flowCallBack, connectCallback);
    }

    private final void printBluetoothA2dpStatus() {
        BluetoothHelper helper = BluetoothBroadcast.INSTANCE.getInstance().getHelper();
        if ((helper != null ? helper.getBluetoothA2dp() : null) == null) {
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "instance.helper?.bluetoothA2dp is null".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "instance.helper?.bluetoothA2dp is null " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "instance.helper?.bluetoothA2dp is null " + strComponent2);
                }
            }
        }
    }

    private final boolean checkConnectIfNeed(List<BluetoothDevice> list) {
        if (list != null) {
            List<BluetoothDevice> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((BluetoothDevice) it.next()).getAddress(), getAddress())) {
                        return true;
                    }
                }
            }
        }
        return (!NothingOSUtil.INSTANCE.isNothingOS() && SPPConnect.INSTANCE.getInstance().isClassicConnected(this.device)) || SPPConnect.INSTANCE.getInstance().isClassicConnected(this.device);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object checkDelayRunning(Continuation<? super Unit> continuation) {
        BluetoothHelper helper = BluetoothBroadcast.INSTANCE.getInstance().getHelper();
        if ((helper != null ? helper.getBluetoothA2dp() : null) == null) {
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "connect...  bluetoothA2dp == null ,delay ".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 4, str, tag, "connect...  bluetoothA2dp == null ,delay  " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "connect...  bluetoothA2dp == null ,delay  " + strComponent2);
                }
            }
            Object objDelay = DelayKt.delay(150L, continuation);
            return objDelay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objDelay : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    public final void connecting() {
        Iterator<Map.Entry<String, Callback>> it = this.callbacks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onConnecting(this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$disconnect$2, reason: invalid class name */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$disconnect$2", f = "TWSDevice.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TWSDevice.this.new AnonymousClass2(continuation);
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
                XConnector xSppConnector = TWSDevice.this.getSppConnector().getXSppConnector();
                if (xSppConnector != null) {
                    this.label = 1;
                    obj = xSppConnector.disconnect(this);
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

    public final void disconnect() {
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "disconnect " + isConnected();
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
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass2(null), 3, null);
    }

    public final void openBluetooth() {
        Iterator<Map.Entry<String, Callback>> it = this.callbacks.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().openBluetooth(this);
        }
    }

    public final void release() {
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "release " + isConnected();
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
        LogFeedback logFeedback = LogFeedback.INSTANCE;
        String address = getAddress();
        if (address == null) {
            address = "";
        }
        logFeedback.clearPoint(address, "TWS", "release disconnected");
        disconnect();
        getSppConnector().onDestroyConnect();
        this.callbacks.clear();
    }

    public static /* synthetic */ void sendCommands$default(TWSDevice tWSDevice, int[] iArr, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        tWSDevice.sendCommands(iArr, z, z2);
    }

    public final void sendCommands(int[] command, boolean ignoreClassicBluetooth, boolean needCache) {
        Intrinsics.checkNotNullParameter(command, "command");
        for (int i : command) {
            sendMessage$default(this, i, null, ignoreClassicBluetooth, needCache, null, null, 0, 114, null);
        }
    }

    public final void setCacheCommandsManualPayload(int command, byte[] payload) {
        Message cacheCommandsManual = getCacheCommandsManual(command);
        if (cacheCommandsManual != null) {
            cacheCommandsManual.setPayload(payload);
        }
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "update cache payload command:" + command + ",payload:" + payload;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
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

    public static /* synthetic */ void setCacheCommandsManual$default(TWSDevice tWSDevice, int i, Message message, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        tWSDevice.setCacheCommandsManual(i, message, z);
    }

    public final void setCacheCommandsManual(int command, Message message, boolean isUpdate) {
        Intrinsics.checkNotNullParameter(message, "message");
        Message message2 = this.cacheMap.get(Integer.valueOf(command));
        this.cacheMap.put(Integer.valueOf(command), message);
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "update cache message command:" + command + ",payload:" + message;
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
        if (!isUpdate || message2 == null || Arrays.equals(message2.getPayload(), message.getPayload())) {
            return;
        }
        updateFromCache(command);
    }

    public final Message getCacheCommandsManual(int command) {
        return this.cacheMap.get(Integer.valueOf(command));
    }

    public final void updateFromCache(int command) {
        Message message = this.cacheMap.get(Integer.valueOf(command));
        if (message != null) {
            onUpdate(command, message);
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "updateFromCache: return value " + this.cacheMap.get(Integer.valueOf(command));
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
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
    }

    public final void getCurrentAnc() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(1);
        byteBufferAllocate.put((byte) 3);
        sendMessage$default(this, 49182, byteBufferAllocate.array(), false, false, null, null, 0, 124, null);
    }

    public static /* synthetic */ Object sendMessageSync$default(TWSDevice tWSDevice, int i, byte[] bArr, boolean z, boolean z2, Long l, byte[] bArr2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bArr = null;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        if ((i2 & 16) != 0) {
            l = null;
        }
        if ((i2 & 32) != 0) {
            bArr2 = null;
        }
        return tWSDevice.sendMessageSync(i, bArr, z, z2, l, bArr2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:59:0x022d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:60:0x022e  */
    /* JADX WARN: Code duplicated, block: B:63:0x0247 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object sendMessageSync(int i, byte[] bArr, boolean z, boolean z2, Long l, byte[] bArr2, Continuation<? super Message> continuation) {
        C10641 c10641;
        Long l2;
        boolean z3;
        byte[] bArr3;
        boolean z4;
        byte[] bArr4;
        int i2;
        TWSDevice tWSDevice;
        int i3;
        TWSDevice tWSDevice2;
        Object objSyncSend$default;
        boolean zIsClassicConnected;
        Message message;
        MainCoroutineDispatcher main;
        AnonymousClass4 anonymousClass4;
        if (continuation instanceof C10641) {
            c10641 = (C10641) continuation;
            if ((c10641.label & Integer.MIN_VALUE) != 0) {
                c10641.label -= Integer.MIN_VALUE;
            } else {
                c10641 = new C10641(continuation);
            }
        } else {
            c10641 = new C10641(continuation);
        }
        C10641 c10642 = c10641;
        Object objIsConnect = c10642.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c10642.label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(objIsConnect);
            HeadsetSppConnector sppConnector = getSppConnector();
            c10642.L$0 = this;
            c10642.L$1 = bArr;
            l2 = l;
            c10642.L$2 = l2;
            c10642.L$3 = bArr2;
            c10642.I$0 = i;
            z3 = z;
            c10642.Z$0 = z3;
            c10642.Z$1 = z2;
            c10642.label = 1;
            objIsConnect = sppConnector.isConnect(c10642);
            if (objIsConnect != coroutine_suspended) {
                bArr3 = bArr;
                z4 = z2;
                bArr4 = bArr2;
                i2 = i;
                tWSDevice = this;
            }
            return coroutine_suspended;
        }
        if (i4 == 1) {
            z4 = c10642.Z$1;
            boolean z5 = c10642.Z$0;
            i2 = c10642.I$0;
            bArr4 = (byte[]) c10642.L$3;
            Long l3 = (Long) c10642.L$2;
            bArr3 = (byte[]) c10642.L$1;
            tWSDevice = (TWSDevice) c10642.L$0;
            ResultKt.throwOnFailure(objIsConnect);
            z3 = z5;
            l2 = l3;
        } else {
            if (i4 != 2) {
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Message message2 = (Message) c10642.L$0;
                ResultKt.throwOnFailure(objIsConnect);
                return message2;
            }
            int i5 = c10642.I$0;
            TWSDevice tWSDevice3 = (TWSDevice) c10642.L$0;
            ResultKt.throwOnFailure(objIsConnect);
            tWSDevice2 = tWSDevice3;
            i3 = i5;
            objSyncSend$default = objIsConnect;
        }
        message = (Message) objSyncSend$default;
        if (message == null) {
            return r6;
        }
        main = Dispatchers.getMain();
        anonymousClass4 = tWSDevice2.new AnonymousClass4(i3, message, 0);
        c10642.L$0 = message;
        c10642.label = 3;
        if (BuildersKt.withContext(main, anonymousClass4, c10642) != coroutine_suspended) {
            return coroutine_suspended;
        }
        return message;
        if (!((Boolean) objIsConnect).booleanValue()) {
            com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "spp can't connected !!".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "spp can't connected !! " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "spp can't connected !! " + strComponent2);
                }
            }
            return null;
        }
        if (!z3 && !(zIsClassicConnected = SPPConnect.INSTANCE.getInstance().isClassicConnected(tWSDevice.device))) {
            com.nothing.base.util.Logger logger2 = com.nothing.base.util.Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str2 = "Can't send message ,ignoreClassicBluetooth:" + z3 + ",classicConnected:" + zIsClassicConnected;
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
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
            return null;
        }
        if (tWSDevice.cacheMap.containsKey(Boxing.boxInt(i2)) && z4) {
            tWSDevice.updateFromCache(i2);
        }
        HeadsetSppConnector sppConnector2 = tWSDevice.getSppConnector();
        c10642.L$0 = tWSDevice;
        c10642.L$1 = null;
        c10642.L$2 = null;
        c10642.L$3 = null;
        c10642.I$0 = i2;
        c10642.label = 2;
        i3 = i2;
        tWSDevice2 = tWSDevice;
        objSyncSend$default = HeadsetSppConnector.syncSend$default(sppConnector2, i3, bArr3, l2, false, false, false, bArr4, 0, c10642, DisplayConfig.SecondPage.STANDARD_ALBUM_SMALL_ICON_SIZE, null);
        if (objSyncSend$default != coroutine_suspended) {
            message = (Message) objSyncSend$default;
            if (message == null) {
                return r6;
            }
            main = Dispatchers.getMain();
            anonymousClass4 = tWSDevice2.new AnonymousClass4(i3, message, 0);
            c10642.L$0 = message;
            c10642.label = 3;
            if (BuildersKt.withContext(main, anonymousClass4, c10642) != coroutine_suspended) {
                return message;
            }
        }
        return coroutine_suspended;
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$sendMessageSync$4, reason: invalid class name */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$sendMessageSync$4", f = "TWSDevice.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $command;
        final /* synthetic */ Message $message;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(int i, Message message, Continuation<? super AnonymousClass4> continuation) {
            super(2, continuation);
            this.$command = i;
            this.$message = message;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TWSDevice.this.new AnonymousClass4(this.$command, this.$message, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice.this.checkAndRefresh(this.$command, this.$message);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkAndRefresh(int command, Message message) {
        if (this.cacheMap.containsKey(Integer.valueOf(command))) {
            Message message2 = this.cacheMap.get(Integer.valueOf(command));
            if (!Arrays.equals(message2 != null ? message2.getPayload() : null, message.getPayload())) {
                this.cacheMap.put(Integer.valueOf(command), message);
                onUpdate(command, message);
                com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "checkAndRefresh new value  " + this.cacheMap.get(Integer.valueOf(command));
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        return;
                    }
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        return;
                    }
                    return;
                }
                return;
            }
            com.nothing.base.util.Logger logger2 = com.nothing.base.util.Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "checkAndRefresh ignore cache is same".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 5, str4, tag2, "checkAndRefresh ignore cache is same " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.w(tag2 + strComponent3, "checkAndRefresh ignore cache is same " + strComponent4);
                    return;
                }
                return;
            }
            return;
        }
        onUpdate(command, message);
    }

    public static /* synthetic */ void sendMessage$default(TWSDevice tWSDevice, int i, byte[] bArr, boolean z, boolean z2, Long l, byte[] bArr2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bArr = null;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        if ((i3 & 16) != 0) {
            l = null;
        }
        if ((i3 & 32) != 0) {
            bArr2 = null;
        }
        if ((i3 & 64) != 0) {
            i2 = 0;
        }
        tWSDevice.sendMessage(i, bArr, z, z2, l, bArr2, i2);
    }

    public final void sendMessage(int command, byte[] payload, boolean ignoreClassicBluetooth, boolean needCache, Long timeOut, byte[] mockResponse, int retryCount) {
        if (this.cacheMap.containsKey(Integer.valueOf(command)) && needCache) {
            updateFromCache(command);
        }
        HeadsetSppConnector.sendMessage$default(getSppConnector(), command, payload, this.protocol.sendDataNeedCrc(), false, mockResponse, retryCount, null, 72, null);
    }

    public final void clearLogHandlerMessage() {
        getSppConnector().clearLogHandlerMessage();
    }

    public static /* synthetic */ Object syncSet$default(TWSDevice tWSDevice, int i, byte[] bArr, Long l, boolean z, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bArr = null;
        }
        if ((i2 & 4) != 0) {
            l = null;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        return tWSDevice.syncSet(i, bArr, l, z, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object syncSet(int i, byte[] bArr, Long l, boolean z, Continuation<? super Boolean> continuation) {
        C10651 c10651;
        if (continuation instanceof C10651) {
            c10651 = (C10651) continuation;
            if ((c10651.label & Integer.MIN_VALUE) != 0) {
                c10651.label -= Integer.MIN_VALUE;
            } else {
                c10651 = new C10651(continuation);
            }
        } else {
            c10651 = new C10651(continuation);
        }
        C10651 c10652 = c10651;
        Object objSyncSend$default = c10652.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10652.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objSyncSend$default);
            HeadsetSppConnector sppConnector = getSppConnector();
            c10652.label = 1;
            objSyncSend$default = HeadsetSppConnector.syncSend$default(sppConnector, i, bArr, l, z, false, false, null, 0, c10652, 240, null);
            if (objSyncSend$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSyncSend$default);
        }
        Message message = (Message) objSyncSend$default;
        return Boxing.boxBoolean(message != null ? message.isOk() : false);
    }

    public static /* synthetic */ Object syncSetResponse$default(TWSDevice tWSDevice, int i, byte[] bArr, Long l, boolean z, boolean z2, byte[] bArr2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bArr = null;
        }
        if ((i2 & 4) != 0) {
            l = null;
        }
        if ((i2 & 8) != 0) {
            z = true;
        }
        if ((i2 & 16) != 0) {
            z2 = true;
        }
        if ((i2 & 32) != 0) {
            bArr2 = null;
        }
        return tWSDevice.syncSetResponse(i, bArr, l, z, z2, bArr2, continuation);
    }

    public final Object syncSetResponse(int i, byte[] bArr, Long l, boolean z, boolean z2, byte[] bArr2, Continuation<? super Message> continuation) {
        return HeadsetSppConnector.syncSend$default(getSppConnector(), i, bArr, l, z, false, z2, bArr2, 0, continuation, 144, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object requestVersion(Continuation<? super Unit> continuation) {
        C10631 c10631;
        boolean z;
        Object objSyncSend$default;
        TWSDevice tWSDevice;
        TWSDevice tWSDevice2;
        if (continuation instanceof C10631) {
            c10631 = (C10631) continuation;
            if ((c10631.label & Integer.MIN_VALUE) != 0) {
                c10631.label -= Integer.MIN_VALUE;
            } else {
                c10631 = new C10631(continuation);
            }
        } else {
            c10631 = new C10631(continuation);
        }
        C10631 c10632 = c10631;
        Object version = c10632.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10632.label;
        if (i != 0) {
            if (i == 1) {
                TWSDevice tWSDevice3 = (TWSDevice) c10632.L$0;
                ResultKt.throwOnFailure(version);
                tWSDevice = tWSDevice3;
                objSyncSend$default = version;
                z = true;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                tWSDevice2 = (TWSDevice) c10632.L$0;
                ResultKt.throwOnFailure(version);
            }
            tWSDevice2.version = (String) version;
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(version);
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Device version requestVersion --> " + this.version;
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
        Pair<Integer, byte[]> deviceVersion = this.protocol.getDeviceVersion();
        HeadsetSppConnector sppConnector = getSppConnector();
        int iIntValue = deviceVersion.getFirst().intValue();
        byte[] second = deviceVersion.getSecond();
        c10632.L$0 = this;
        c10632.label = 1;
        z = true;
        objSyncSend$default = HeadsetSppConnector.syncSend$default(sppConnector, iIntValue, second, null, false, false, false, null, 0, c10632, 252, null);
        if (objSyncSend$default != coroutine_suspended) {
            tWSDevice = this;
        }
        return coroutine_suspended;
        Message message = (Message) objSyncSend$default;
        if (message == null) {
            com.nothing.base.util.Logger logger2 = com.nothing.base.util.Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(z) && "Device version Failed to get version number".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 3, str4, tag2, "Device version Failed to get version number " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "Device version Failed to get version number " + strComponent4);
                }
            }
        }
        ProtocolModel protocolModel = tWSDevice.protocol;
        c10632.L$0 = tWSDevice;
        c10632.label = 2;
        version = protocolModel.parseVersion(message, tWSDevice, c10632);
        if (version != coroutine_suspended) {
            tWSDevice2 = tWSDevice;
            tWSDevice2.version = (String) version;
            return Unit.INSTANCE;
        }
        return coroutine_suspended;
    }

    @Override // com.nothing.protocol.connector.HeadsetSppConnector.SocketCallback
    public void onClosed() {
        callbackEach(new Function1() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TWSDevice.onClosed$lambda$25(this.f$0, (TWSDevice.Callback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClosed$lambda$25(TWSDevice tWSDevice, Callback it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onDisconnected();
        it.onDisconnected(tWSDevice);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.protocol.connector.HeadsetSppConnector.SocketCallback
    public void onError(final int code, final String message) {
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Test Send onError " + code + StringUtils.SPACE + message + " name:" + Thread.currentThread().getName();
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
        callbackEach(new Function1() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TWSDevice.onError$lambda$27(code, message, this, (TWSDevice.Callback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onError$lambda$27(int i, String str, TWSDevice tWSDevice, Callback it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onError(i, str);
        it.onError(tWSDevice);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.protocol.connector.HeadsetSppConnector.SocketCallback
    public void onMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        int requestCmd = message.getRequestCmd();
        getFlutterNoise(requestCmd, message);
        onUpdate(requestCmd, message);
        interceptorCommand(message);
        cacheGetCommandData(message);
    }

    @Override // com.nothing.protocol.connector.HeadsetSppConnector.SocketCallback
    public void onMessageNew(final Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
        final int requestCmd = message.getRequestCmd();
        if ((requestCmd & ProtocolConstant.Debug.COMMANDS) == 64512) {
            return;
        }
        if ((requestCmd & ProtocolConstant.Query.QUERY_COMMANDS) == 49152 || (requestCmd & ProtocolConstant.Notification.NOTIFICATION_COMMANDS) == 57344) {
            getMainHandler().post(new Runnable() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    TWSDevice.onMessageNew$lambda$28(this.f$0, requestCmd, message);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onMessageNew$lambda$28(TWSDevice tWSDevice, int i, Message message) {
        tWSDevice.getCommandCache().updateCommand(i, message);
    }

    private final void getFlutterNoise(int cmdType, Message message) {
        IOTProductDevice productByMacAddress;
        if (cmdType != 61455 || (productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(getAddress())) == null || !productByMacAddress.needUpdateNoiseToWidget() || SpUtils.INSTANCE.isBackground()) {
            return;
        }
        com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "need get flutter noise".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "need get flutter noise " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "need get flutter noise " + strComponent2);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C10602(null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDevice$getFlutterNoise$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSDevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDevice$getFlutterNoise$2", f = "TWSDevice.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C10602 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        C10602(Continuation<? super C10602> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C10602 c10602 = TWSDevice.this.new C10602(continuation);
            c10602.L$0 = obj;
            return c10602;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10602) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            NtEarFlutterApi flutterApi;
            PluginRegistry plugins;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get("main");
            FlutterPlugin flutterPlugin = (flutterEngine == null || (plugins = flutterEngine.getPlugins()) == null) ? null : plugins.get(NtEarPlugin.class);
            if ((flutterPlugin instanceof NtEarPlugin) && (flutterApi = ((NtEarPlugin) flutterPlugin).getFlutterApi()) != null) {
                final TWSDevice tWSDevice = TWSDevice.this;
                flutterApi.getAncMsg(new Function1() { // from class: com.nothing.protocol.device.TWSDevice$getFlutterNoise$2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TWSDevice.C10602.invokeSuspend$lambda$8(coroutineScope, tWSDevice, (Result) obj2);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$8(CoroutineScope coroutineScope, TWSDevice tWSDevice, Result result) {
            Object value = result.getValue();
            if (Result.m6354isSuccessimpl(value)) {
                List list = (List) value;
                com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "need get flutter noise data:" + list;
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
                if (list != null && list.size() > 0) {
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(list.size() + 8);
                    ByteBuffer byteBufferPut = byteBufferAllocate.put(new byte[]{85, 96, 1, Ascii.RS, SignedBytes.MAX_POWER_OF_TWO, (byte) list.size(), 0, 1});
                    List list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Integer.valueOf((int) ((Number) it.next()).longValue()));
                    }
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        arrayList3.add(Byte.valueOf((byte) ((Number) it2.next()).intValue()));
                    }
                    byteBufferPut.put(CollectionsKt.toByteArray(arrayList3));
                    Message message = new Message(byteBufferAllocate.array());
                    com.nothing.base.util.Logger logger2 = com.nothing.base.util.Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str4 = "need get flutter noise new message:" + message;
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
                    Iterator<Map.Entry<String, Callback>> it3 = tWSDevice.getCallbacks().entrySet().iterator();
                    while (it3.hasNext()) {
                        it3.next().getValue().onUpdate(49182, message, tWSDevice);
                    }
                }
            }
            if (Result.m6350exceptionOrNullimpl(result.getValue()) != null) {
                com.nothing.base.util.Logger logger3 = com.nothing.base.util.Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true) && "need get flutter noise fail".length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str7 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    FileLog.print$default(fileLog3, 3, str7, tag3, "need get flutter noise fail " + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, "need get flutter noise fail " + strComponent6);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final void cacheGetCommandData(Message message) {
        HashMap<Integer, Integer> commandList = this.protocol.getCommandList();
        if (commandList.containsKey(Integer.valueOf(message.getRequestCmd()))) {
            Integer num = commandList.get(Integer.valueOf(message.getRequestCmd()));
            this.cacheMap.put(Integer.valueOf(num != null ? num.intValue() : 0), message);
        }
    }

    private final void interceptorCommand(Message message) {
        if (message.getRequestCmd() == 49215) {
            sendUtcTime();
        }
    }

    public void sendUtcTime() {
        byte[] byteArray$default = DataExtKt.toByteArray$default(System.currentTimeMillis() / ((long) 1000), 0, 1, (Object) null);
        sendMessage$default(this, ProtocolConstant.Set.SET_UTC_TIME, byteArray$default, true, false, null, byteArray$default, 0, 88, null);
    }

    public final void onUpdate(final int cmdType, final Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
        onMessageNew(data);
        if (cmdType == 49218) {
            ProtocolModel protocolModel = this.protocol;
            String address = getAddress();
            this.version = protocolModel.parseVersion(data, address != null ? address : "");
            return;
        }
        if (cmdType == 57368) {
            if (NothingOSUtil.INSTANCE.isSupportEssential() || NothingOSUtil.INSTANCE.isSupportEssentialVoice()) {
                byte[] payload = data.getPayload();
                Integer intOrNull = payload != null ? DataExtKt.getIntOrNull(payload, 0) : null;
                byte[] payload2 = data.getPayload();
                Integer intOrNull2 = payload2 != null ? DataExtKt.getIntOrNull(payload2, 1) : null;
                RecordingUtils recordingUtils = RecordingUtils.INSTANCE;
                int iIntValue = intOrNull != null ? intOrNull.intValue() : 0;
                int iIntValue2 = intOrNull2 != null ? intOrNull2.intValue() : 0;
                String address2 = getAddress();
                recordingUtils.controlRecording(iIntValue, iIntValue2, address2 != null ? address2 : "");
            } else {
                RecordingUtils.INSTANCE.callbackToEarEssential((byte) 3, this);
            }
        }
        updateSn(cmdType, data);
        callbackEach(new Function1() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TWSDevice.onUpdate$lambda$30(cmdType, data, this, (TWSDevice.Callback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUpdate$lambda$30(int i, Message message, TWSDevice tWSDevice, Callback it) {
        Intrinsics.checkNotNullParameter(it, "it");
        try {
            it.onUpdate(i, message);
            it.onUpdate(i, message, tWSDevice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Unit.INSTANCE;
    }

    private final void updateSn(int cmdType, Message data) {
        DeviceConfiguration deviceConfiguration;
        String serialNumber;
        if (cmdType != 49158 || (deviceConfiguration = (DeviceConfiguration) data.obtainPayload(DeviceConfiguration.class)) == null || (serialNumber = deviceConfiguration.getSerialNumber()) == null || serialNumber.length() <= 0) {
            return;
        }
        DeviceItemDao deviceDao = DatabaseUtils.INSTANCE.getDeviceDao();
        String address = getAddress();
        if (address == null) {
            address = "";
        }
        List<DeviceItem> deviceItem = deviceDao.getDeviceItem(address);
        DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
        if (deviceItem2 != null) {
            String sn = deviceItem2.getSn();
            if (sn == null || sn.length() == 0) {
                String serialNumber2 = deviceConfiguration.getSerialNumber();
                this.sn = serialNumber2;
                deviceItem2.setSn(serialNumber2);
                DatabaseUtils.INSTANCE.getDeviceDao().updateDeviceItem(deviceItem2);
                com.nothing.base.util.Logger logger = com.nothing.base.util.Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "updateSn:" + this.sn;
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        return;
                    }
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
        }
    }

    private final void callbackEach(final Function1<? super Callback, Unit> action) {
        for (final Map.Entry<String, Callback> entry : this.callbacks.entrySet()) {
            try {
                if (entry.getValue().isIOThread()) {
                    action.invoke(entry.getValue());
                } else {
                    getMainHandler().post(new Runnable() { // from class: com.nothing.protocol.device.TWSDevice$$ExternalSyntheticLambda1
                        @Override // java.lang.Runnable
                        public final void run() {
                            TWSDevice.callbackEach$lambda$33$lambda$32(action, entry);
                        }
                    });
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callbackEach$lambda$33$lambda$32(Function1 function1, Map.Entry entry) {
        function1.invoke(entry.getValue());
    }
}
