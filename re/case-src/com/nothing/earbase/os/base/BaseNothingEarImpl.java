package com.nothing.earbase.os.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.google.maps.android.BuildConfig;
import com.nothing.base.model.Battery;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.DeviceANCSwitch;
import com.nothing.base.protocol.entity.DeviceExtraFeatureStatus;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTDeviceOsAction;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.anc.entity.DeviceNoiseItem;
import com.nothing.earbase.anc.entity.DeviceNoiseReduction;
import com.nothing.earbase.base.NothingDevice;
import com.nothing.earbase.base.NothingDeviceManager;
import com.nothing.earbase.os.DeviceProtocol;
import com.nothing.earbase.os.OsMemoryCache;
import com.nothing.earbase.os.OsPermissionCheck;
import com.nothing.earbase.os.cache.MacCacheManager;
import com.nothing.earbase.os.cache.entity.MacCacheEntity;
import com.nothing.earbase.os.ext.IntExtKt;
import com.nothing.earbase.ota.entity.DeviceBattery;
import com.nothing.earbase.ota.entity.ServerFirmware;
import com.nothing.event.log.cpp.AppKeyUtils;
import com.nothing.log.FileLog;
import com.nothing.log.feedback.LogFeedback;
import com.nothing.network.core.ApiResult;
import com.nothing.os.device.DeviceConstant;
import com.nothing.os.device.DeviceFunctionItem;
import com.nothing.os.device.IDeviceBitmap;
import com.nothing.os.device.IDeviceServiceCallBack;
import com.nothing.ota.OTAHelper;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BaseNothingEarImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010'\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010(\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010)\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010*\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010+\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010,\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010-\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010.\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010/\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u00100\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u00101\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u00102\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u00103\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u00104\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u00105\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bH\u0016J\u0018\u00107\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000bH\u0016J\u0018\u00109\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010:\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010;\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010<\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010=\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u001c\u0010>\u001a\u00020\u001b2\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u001b0@H\u0016J\u0018\u0010A\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010B\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010C\u001a\u00020\u001b2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010F\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u001a\u0010G\u001a\u00020\u001b2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010H\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010I\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010J\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010K\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010L\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010M\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010Y\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010Z\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#H\u0002J\"\u0010[\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\\\u001a\u00020\u0016H\u0002J\u0016\u0010]\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020#J\b\u0010b\u001a\u00020`H\u0002J\b\u0010c\u001a\u00020`H\u0002J\u0018\u0010d\u001a\u0004\u0018\u00010!2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#J\u0010\u0010e\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020!H\u0016J\u0010\u0010g\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020!H\u0016J \u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020E2\u0006\u0010f\u001a\u00020!H\u0016J\u0018\u0010j\u001a\u00020\u001b2\u0006\u0010k\u001a\u00020#2\u0006\u0010l\u001a\u00020mH\u0002J\b\u0010e\u001a\u00020\u001bH\u0016J\b\u0010g\u001a\u00020\u001bH\u0016J\u001a\u0010n\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020\u001e2\b\u0010D\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010h\u001a\u00020\u001b2\u0006\u0010i\u001a\u00020\u001e2\u0006\u0010^\u001a\u00020EH\u0016J&\u0010p\u001a\u00020\u001b2\u0006\u0010q\u001a\u00020\u000b2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010s\u001a\u00020\u001eH\u0002J\u0018\u0010t\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010u\u001a\u00020\u001bH\u0016J\"\u0010v\u001a\u00020#2\u0006\u0010\"\u001a\u00020#2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010v\u001a\u00020#2\b\u0010q\u001a\u0004\u0018\u00010\u000b2\u0006\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010z\u001a\u00020#2\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010~\u001a\u00020#2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u007f\u001a\u00020mH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020#2\u0006\u0010\"\u001a\u00020#H\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010N\u001a\u0004\u0018\u00010OX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020UX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010V\"\u0004\bW\u0010XR\u000e\u0010_\u001a\u00020`X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010a\u001a\u00020`X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0081\u0001"}, d2 = {"Lcom/nothing/earbase/os/base/BaseNothingEarImpl;", "Lcom/nothing/earbase/os/base/BaseEar;", "Lcom/nothing/earbase/os/base/BaseNothingEar;", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "mModelId", "", "address", "<init>", "(Landroid/os/RemoteCallbackList;Landroid/os/Handler;Lkotlinx/coroutines/CoroutineScope;Ljava/lang/String;Ljava/lang/String;)V", "getMModelId", "()Ljava/lang/String;", "setMModelId", "(Ljava/lang/String;)V", "getAddress", "setAddress", "isSendToSetting", "", "serialNumber", "isDeleteCache", "isDeleteSystemCache", "register", "", "autoConnect", "fromPage", "", "unRegister", "getTwsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "extras", "Landroid/os/Bundle;", "orderSetMacAddress", "command", "orderGetAncLevel", "orderSetLowLatency", "orderSetPersonalisedAnc", "orderGetPersonalisedAnc", "orderGetPersonalisedSound", "orderSetAnc", "orderSetAutoUpdate", "orderSetInEarDetection", "orderConnected", "orderDisconnected", "orderGetFunctionList", "orderGetBattery", "orderGetEqualizer", "orderGetInEarDetection", "orderGetFirmwareUpdate", "checkAutoUpdateItem", "version", "checkUpdateFirmware", "firmwareVersion", "orderGetAutomaticUpdate", "getAutomaticUpdate", "orderGetAnc", "orderGetSerialNumber", "orderGetLowLatency", "getOlderFirmwareVersion", "action", "Lkotlin/Function1;", "getSerialNumber", "getLowLatency", "updateLowLatency", "message", "Lcom/nothing/protocol/model/Message;", "getInEarDetection", "updateInEarDetection", "getOrderAnc", "getEqualizer", "getBattery", "orderGetNTDeviceName", "orderGetEarBitmap", "setEarDetection", "ancJob", "Lkotlinx/coroutines/Job;", "getAncJob", "()Lkotlinx/coroutines/Job;", "setAncJob", "(Lkotlinx/coroutines/Job;)V", "isClick", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setClick", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "setNoiseCancellation", "setLatencyMode", "updateBitmap", "connected", "updateSystemUIBitmap", "data", "connectedBinder", "Landroid/os/Binder;", "systemUIBinder", "convertSystemUIBitmapToBinder", "convertBitmapToBinder", "safeTws", "onConnected", "twsDevice", "onDisconnected", "onUpdate", "cmdType", "responseANCData", "bundle", "entity", "Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;", "onError", "code", "updateFirmware", "macAddress", "newVersion", "showNewCount", "routerJumpToActivity", "onDestroy", "parseBattery", "battery", "Lcom/nothing/earbase/ota/entity/DeviceBattery;", "modelId", "parseEqModel", "context", "Landroid/content/Context;", "type", "parseNoiseCancelModel", "noiseReduction", "getFunctionList", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseNothingEarImpl extends BaseEar implements BaseNothingEar {
    private String address;
    private Job ancJob;
    private final Binder connectedBinder;
    private AtomicBoolean isClick;
    private boolean isDeleteCache;
    private boolean isDeleteSystemCache;
    private boolean isSendToSetting;
    private String mModelId;
    private String serialNumber;
    private final Binder systemUIBinder;

    public void getOlderFirmwareVersion(Function1<? super String, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(int code, String message) {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public void orderGetPersonalisedAnc(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
    }

    public void orderGetPersonalisedSound(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
    }

    public /* synthetic */ BaseNothingEarImpl(RemoteCallbackList remoteCallbackList, Handler handler, CoroutineScope coroutineScope, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : remoteCallbackList, (i & 2) != 0 ? null : handler, (i & 4) != 0 ? null : coroutineScope, str, str2);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void getBesVersionSuccess() {
        BaseNothingEar.DefaultImpls.getBesVersionSuccess(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public boolean isIOThread() {
        return BaseNothingEar.DefaultImpls.isIOThread(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnecting(TWSDevice tWSDevice) {
        BaseNothingEar.DefaultImpls.onConnecting(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice) {
        BaseNothingEar.DefaultImpls.onError(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice, int i, String str) {
        BaseNothingEar.DefaultImpls.onError(this, tWSDevice, i, str);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void openBluetooth(TWSDevice tWSDevice) {
        BaseNothingEar.DefaultImpls.openBluetooth(this, tWSDevice);
    }

    public final String getMModelId() {
        return this.mModelId;
    }

    public final void setMModelId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mModelId = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseNothingEarImpl(RemoteCallbackList<IInterface> remoteCallbackList, Handler handler, CoroutineScope coroutineScope, String mModelId, String address) {
        super(remoteCallbackList, handler, coroutineScope, mModelId);
        Intrinsics.checkNotNullParameter(mModelId, "mModelId");
        Intrinsics.checkNotNullParameter(address, "address");
        this.mModelId = mModelId;
        this.address = address;
        this.isDeleteCache = true;
        this.isDeleteSystemCache = true;
        this.isClick = new AtomicBoolean(false);
        this.connectedBinder = convertBitmapToBinder();
        this.systemUIBinder = convertSystemUIBitmapToBinder();
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void register(boolean autoConnect, int fromPage) {
        String deviceName;
        String address;
        AppKeyUtils.INSTANCE.getSingleInstance();
        this.isSendToSetting = false;
        TWSDevice twsDevice = getTwsDevice();
        if (twsDevice != null) {
            twsDevice.register(this);
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "autoConnect:" + autoConnect + StringUtils.SPACE;
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
        if (autoConnect) {
            String str4 = this.address;
            TWSDevice twsDevice2 = getTwsDevice();
            updateBitmap(str4, fromPage, twsDevice2 != null && twsDevice2.isConnected());
            LogFeedback logFeedback = LogFeedback.INSTANCE;
            TWSDevice twsDevice3 = getTwsDevice();
            if (twsDevice3 == null || (address = twsDevice3.getAddress()) == null) {
                address = "";
            }
            logFeedback.addPoint(address, "OSService starts", "BaseNothingEarImpl  autoConnect");
            TWSDevice twsDevice4 = getTwsDevice();
            if (twsDevice4 != null) {
                TWSDevice.connect$default(twsDevice4, false, null, null, 7, null);
            }
        } else {
            updateBitmap$default(this, this.address, fromPage, false, 4, null);
        }
        List<DeviceItem> deviceItem = DatabaseUtils.INSTANCE.getDeviceDao().getDeviceItem(this.address);
        if ((deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null) == null) {
            TWSDevice twsDevice5 = getTwsDevice();
            if (twsDevice5 == null || (deviceName = twsDevice5.getDeviceName()) == null) {
                deviceName = "";
            }
            if (deviceName.length() > 0) {
                DatabaseUtils.INSTANCE.getDeviceDao().insertDeviceItem(new DeviceItem(deviceName, this.address, autoConnect, "", getModelId(), null, false, false, false, null, false, 0L, 4064, null));
            }
        }
    }

    private final void unRegister() {
        this.isSendToSetting = false;
        TWSDevice twsDevice = getTwsDevice();
        if (twsDevice != null) {
            twsDevice.unregister(this);
        }
    }

    public TWSDevice getTwsDevice() {
        IOTDevice andCreateIOTDevice = IOTDeviceManager.INSTANCE.getAndCreateIOTDevice(this.address, getModelId());
        if (andCreateIOTDevice != null) {
            return andCreateIOTDevice.getTwsDevice();
        }
        return null;
    }

    public TWSDevice getTwsDevice(Bundle extras) {
        IOTDevice andCreateIOTDevice;
        Intrinsics.checkNotNullParameter(extras, "extras");
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        if (this.mModelId.length() == 0 || string.length() == 0 || (andCreateIOTDevice = IOTDeviceManager.INSTANCE.getAndCreateIOTDevice(string, getModelId())) == null) {
            return null;
        }
        return andCreateIOTDevice.getTwsDevice();
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void orderSetMacAddress(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        OsMemoryCache.INSTANCE.updateSelectedMacAddressAndModelId(extras);
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request:setCommand SET_MAC_ADDRESS " + string;
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

    public void orderGetAncLevel(final int command, final Bundle extras) {
        IOTProductDevice productByModelId;
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: GET_ANC_LEVEL " + extras.keySet() + StringUtils.SPACE + extras;
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
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(string);
        final int supportANCLevel = 0;
        if (iOTDeviceByMacAddress != null && iOTDeviceByMacAddress.isSupportAnc(string) && (productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(iOTDeviceByMacAddress.getModelId())) != null) {
            supportANCLevel = productByModelId.getSupportANCLevel();
        }
        if (supportANCLevel != 0) {
            remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseNothingEarImpl.orderGetAncLevel$lambda$4(extras, supportANCLevel, this, command, (IDeviceServiceCallBack) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit orderGetAncLevel$lambda$4(Bundle bundle, int i, BaseNothingEarImpl baseNothingEarImpl, int i2, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(bundle);
        bundleObtainBundle.putInt(DeviceConstant.KEY_VALUE_INT, i);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Response: GET_ANC_LEVEL " + bundleObtainBundle;
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
        it.onSuccess(i2, bundleObtainBundle);
        return Unit.INSTANCE;
    }

    public void orderSetLowLatency(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "Request:setCommand ORDER_LOW_LATENCY".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "Request:setCommand ORDER_LOW_LATENCY " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "Request:setCommand ORDER_LOW_LATENCY " + strComponent2);
            }
        }
        if (safeTws(command, extras) != null) {
            setLatencyMode(extras);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.os.base.BaseNothingEarImpl$orderSetPersonalisedAnc$2, reason: invalid class name */
    /* JADX INFO: compiled from: BaseNothingEarImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.os.base.BaseNothingEarImpl$orderSetPersonalisedAnc$2", f = "BaseNothingEarImpl.kt", i = {0, 0, 0, 0}, l = {195}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u244", "message", "enable", "value"}, s = {"L$1", "L$2", "Z$0", "I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $command;
        final /* synthetic */ Bundle $extras;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, Bundle bundle, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$command = i;
            this.$extras = bundle;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseNothingEarImpl.this.new AnonymousClass2(this.$command, this.$extras, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TWSDevice tWSDeviceSafeTws;
            boolean z;
            boolean z2;
            Object personalizedANC;
            int i;
            Message message;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                tWSDeviceSafeTws = BaseNothingEarImpl.this.safeTws(this.$command, this.$extras);
                if (tWSDeviceSafeTws != null) {
                    Bundle bundle = this.$extras;
                    BaseNothingEarImpl baseNothingEarImpl = BaseNothingEarImpl.this;
                    int i3 = this.$command;
                    Message cacheCommandsManual = tWSDeviceSafeTws.getCacheCommandsManual(ProtocolConstant.Query.GET_PERSONALIZED_ANC);
                    if (cacheCommandsManual == null) {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true) && "orderSetPersonalisedAnc getCacheCommandsManual is null".length() != 0) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            FileLog.print$default(fileLog, 5, str, tag, "orderSetPersonalisedAnc getCacheCommandsManual is null " + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.w(tag + strComponent1, "orderSetPersonalisedAnc getCacheCommandsManual is null " + strComponent2);
                            }
                        }
                    }
                    DeviceANCSwitch deviceANCSwitch = cacheCommandsManual != null ? (DeviceANCSwitch) cacheCommandsManual.obtainPayload(DeviceANCSwitch.class) : null;
                    z = bundle.getBoolean(DeviceConstant.KEY_VALUE_BOOLEAN);
                    if (deviceANCSwitch != null) {
                        z2 = true;
                        if (deviceANCSwitch.getAncCalibration() == 1) {
                            DeviceProtocol deviceProtocol = DeviceProtocol.INSTANCE;
                            this.L$0 = tWSDeviceSafeTws;
                            this.L$1 = tWSDeviceSafeTws;
                            this.L$2 = cacheCommandsManual;
                            this.Z$0 = z;
                            this.I$0 = z ? 1 : 0;
                            this.label = 1;
                            personalizedANC = deviceProtocol.setPersonalizedANC(tWSDeviceSafeTws, z ? 1 : 0, this);
                            if (personalizedANC == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i = z ? 1 : 0;
                            message = cacheCommandsManual;
                        }
                    }
                    if (deviceANCSwitch != null && deviceANCSwitch.getAncCalibration() == 0 && z) {
                        baseNothingEarImpl.routerJumpToActivity(i3, bundle);
                    }
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            boolean z3 = this.Z$0;
            message = (Message) this.L$2;
            tWSDeviceSafeTws = (TWSDevice) this.L$1;
            ResultKt.throwOnFailure(obj);
            z = z3;
            z2 = true;
            personalizedANC = obj;
            Boolean bool = (Boolean) personalizedANC;
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(z2)) {
                String str2 = "Response:setCommand ORDER_PERSONALISED_ANC from:" + z + " ,result:" + bool;
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
            if (Intrinsics.areEqual(bool, Boxing.boxBoolean(true))) {
                byte[] payload = message.getPayload();
                Integer intOrNull = payload != null ? DataExtKt.getIntOrNull(payload, 1) : null;
                if (intOrNull != null) {
                    intOrNull.intValue();
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
                    byteBufferAllocate.put((byte) i);
                    byteBufferAllocate.put((byte) intOrNull.intValue());
                    byteBufferAllocate.rewind();
                    tWSDeviceSafeTws.setCacheCommandsManualPayload(ProtocolConstant.Query.GET_PERSONALIZED_ANC, byteBufferAllocate.array());
                    tWSDeviceSafeTws.updateFromCache(ProtocolConstant.Query.GET_PERSONALIZED_ANC);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public void orderSetPersonalisedAnc(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "Request:setCommand ORDER_PERSONALISED_ANC".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "Request:setCommand ORDER_PERSONALISED_ANC " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "Request:setCommand ORDER_PERSONALISED_ANC " + strComponent2);
            }
        }
        CoroutineScope coroutineScope = getCoroutineScope();
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new AnonymousClass2(command, extras, null), 2, null);
        }
    }

    public void orderSetAnc(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "Request:setCommand ORDER_ANC".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "Request:setCommand ORDER_ANC " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "Request:setCommand ORDER_ANC " + strComponent2);
            }
        }
        if (safeTws(command, extras) != null) {
            setNoiseCancellation(extras);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void orderSetAutoUpdate(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "Request:setCommand AUTOMATIC_UPDATE".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "Request:setCommand AUTOMATIC_UPDATE " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "Request:setCommand AUTOMATIC_UPDATE " + strComponent2);
            }
        }
        boolean z = extras.getBoolean(DeviceConstant.KEY_VALUE_BOOLEAN);
        MacCacheEntity nothingEar$default = MacCacheManager.getNothingEar$default(MacCacheManager.INSTANCE, this.address, false, 2, null);
        if (nothingEar$default != null) {
            nothingEar$default.setAutoUpdate(z ? 1 : 0);
        }
        final boolean zUpdateNothingEntity = MacCacheManager.INSTANCE.updateNothingEntity(nothingEar$default);
        final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
        bundleObtainBundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, z);
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.orderSetAutoUpdate$lambda$11(zUpdateNothingEntity, bundleObtainBundle, (IDeviceServiceCallBack) obj);
            }
        });
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str2 = "Response: setCommand ORDER_AUTOMATIC_UPDATE  " + bundleObtainBundle;
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                return;
            }
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str4 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog2, 4, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit orderSetAutoUpdate$lambda$11(boolean z, Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        if (z) {
            it.onSuccess(1330, bundle);
        } else {
            it.onFail(1330, -1);
        }
        return Unit.INSTANCE;
    }

    public void orderSetInEarDetection(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (safeTws(command, extras) != null) {
            setEarDetection(extras);
        }
    }

    public void orderConnected(int command, Bundle extras) {
        String address;
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "sendCommand DeviceConstant.CONNECT " + extras;
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
        TWSDevice twsDevice = getTwsDevice(extras);
        if (twsDevice == null || twsDevice.isConnected()) {
            return;
        }
        this.isSendToSetting = false;
        LogFeedback logFeedback = LogFeedback.INSTANCE;
        TWSDevice twsDevice2 = getTwsDevice();
        if (twsDevice2 == null || (address = twsDevice2.getAddress()) == null) {
            address = "";
        }
        logFeedback.addPoint(address, "Connect Command", "BaseNothingEarImpl Settings send connected command");
        TWSDevice.connect$default(twsDevice, false, null, null, 7, null);
    }

    public void orderDisconnected(int command, Bundle extras) {
        TWSDevice twsDevice;
        String address;
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "sendCommand DeviceConstant.DISCONNECT " + extras;
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
        if (getTwsDevice(extras) == null || (twsDevice = OsMemoryCache.INSTANCE.getTwsDevice(extras)) == null || !twsDevice.isConnected()) {
            return;
        }
        TWSDevice twsDevice2 = getTwsDevice(extras);
        if (twsDevice2 != null) {
            LogFeedback logFeedback = LogFeedback.INSTANCE;
            TWSDevice twsDevice3 = getTwsDevice();
            if (twsDevice3 == null || (address = twsDevice3.getAddress()) == null) {
                address = "";
            }
            logFeedback.addPoint(address, "Disconnect Command", "BaseNothingEarImpl Settings send disconnect command");
            twsDevice2.disconnect();
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true) && "Response:sendCommand DISCONNECT return KEY_BITMAP".length() != 0) {
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str4 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog2, 3, str4, tag2, "Response:sendCommand DISCONNECT return KEY_BITMAP " + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, "Response:sendCommand DISCONNECT return KEY_BITMAP " + strComponent4);
            }
        }
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        updateBitmap$default(this, string, 0, false, 4, null);
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void orderGetFunctionList(final int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: GET_FUNCTION_LIST  " + extras;
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
        final Bundle functionList = getFunctionList(extras);
        final boolean zCheckPermission = OsPermissionCheck.INSTANCE.checkPermission(getContext());
        if (zCheckPermission) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "Response: GET_FUNCTION_LIST " + functionList;
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
        } else {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str7 = "Response: GET_FUNCTION_LIST ERROR_NO_PERMISSION   " + extras;
                String str8 = str7;
                if (str8 != null && str8.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str9 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                    FileLog.print$default(fileLog3, 6, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.e(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
        }
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.orderGetFunctionList$lambda$22(zCheckPermission, command, functionList, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit orderGetFunctionList$lambda$22(boolean z, int i, Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        if (z) {
            it.onSuccess(i, bundle);
        } else {
            it.onFail(i, -1);
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void orderGetBattery(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: GET_BATTERY  " + extras;
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
        getBattery(command, extras);
    }

    public void orderGetEqualizer(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: ORDER_EQUALIZER  " + extras;
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
        getEqualizer(command, extras);
    }

    public void orderGetInEarDetection(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: ORDER_IN_EAR_DETECTION  " + extras;
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
        getInEarDetection(command, extras);
    }

    public void orderGetFirmwareUpdate(int command, Bundle extras) {
        CoroutineScope coroutineScope;
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: ORDER_FIRMWARE_UPDATE  " + extras;
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
        String string = extras.getString("device_address");
        if (string != null) {
            IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(string);
            String firmwareVersion = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getFirmwareVersion() : null;
            String str4 = firmwareVersion;
            if (str4 == null || str4.length() == 0) {
                String firmVersion = MacCacheManager.INSTANCE.getFirmVersion(string);
                if (firmVersion.length() > 0) {
                    updateFirmware$default(this, string, firmVersion, 0, 4, null);
                }
            } else {
                updateFirmware$default(this, string, firmwareVersion, 0, 4, null);
            }
        }
        TWSDevice tWSDeviceSafeTws = safeTws(command, extras);
        if (tWSDeviceSafeTws == null || (coroutineScope = getCoroutineScope()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new BaseNothingEarImpl$orderGetFirmwareUpdate$3$1(extras, tWSDeviceSafeTws, string, this, null), 2, null);
    }

    public void checkAutoUpdateItem(String address, String version) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(version, "version");
        Bundle bundle = new Bundle();
        bundle.putString("device_address", address);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(getString(R.string.new_version), Arrays.copyOf(new Object[]{""}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String strReplace$default = StringsKt.replace$default(version, str, "", false, 4, (Object) null);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "Request: GET_EXTRA_FUNCTION_LIST  " + address + "," + strReplace$default;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 4, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        final Bundle extraFunctionList = getExtraFunctionList(strReplace$default, bundle);
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str5 = "Response: GET_EXTRA_FUNCTION_LIST  " + extraFunctionList;
            String str6 = str5;
            if (str6 != null && str6.length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str7 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                FileLog.print$default(fileLog2, 4, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        if (extraFunctionList != null) {
            remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseNothingEarImpl.checkAutoUpdateItem$lambda$31(extraFunctionList, (IDeviceServiceCallBack) obj);
                }
            });
            return;
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true) && "Response: GET_EXTRA_FUNCTION_LIST  no response can't support firmware!!!".length() != 0) {
            Pair<String, String> trace3 = logger3.getTrace(depth3);
            String strComponent5 = trace3.component1();
            String strComponent6 = trace3.component2();
            FileLog fileLog3 = FileLog.INSTANCE;
            String str8 = logger3.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
            FileLog.print$default(fileLog3, 4, str8, tag3, "Response: GET_EXTRA_FUNCTION_LIST  no response can't support firmware!!! " + strComponent6, null, 16, null);
            if (logger3.isDebug()) {
                Log.i(tag3 + strComponent5, "Response: GET_EXTRA_FUNCTION_LIST  no response can't support firmware!!! " + strComponent6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit checkAutoUpdateItem$lambda$31(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(11, bundle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.os.base.BaseNothingEarImpl$checkUpdateFirmware$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseNothingEarImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.os.base.BaseNothingEarImpl$checkUpdateFirmware$1", f = "BaseNothingEarImpl.kt", i = {0}, l = {409}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        final /* synthetic */ String $firmwareVersion;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BaseNothingEarImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, BaseNothingEarImpl baseNothingEarImpl, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$address = str;
            this.this$0 = baseNothingEarImpl;
            this.$firmwareVersion = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$address, this.this$0, this.$firmwareVersion, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0046  */
        /* JADX WARN: Code duplicated, block: B:19:0x0054  */
        /* JADX WARN: Code duplicated, block: B:22:0x006a  */
        /* JADX WARN: Code duplicated, block: B:29:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:31:0x0104  */
        /* JADX WARN: Code duplicated, block: B:39:0x0161  */
        /* JADX WARN: Code duplicated, block: B:41:0x018e  */
        /* JADX WARN: Code duplicated, block: B:44:0x01a2  */
        /* JADX WARN: Code duplicated, block: B:51:0x0203  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ApiResult apiResult;
            Logger logger;
            String tag;
            int depth;
            String str;
            String str2;
            String strComponent1;
            String strComponent2;
            Logger logger2;
            String tag2;
            int depth2;
            String strComponent3;
            String strComponent4;
            String str3;
            Logger logger3;
            String tag3;
            int depth3;
            String str4;
            String str5;
            String strComponent5;
            String strComponent6;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                NothingDevice device = NothingDeviceManager.INSTANCE.getDevice(this.$address);
                if (device != null) {
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    obj = device.checkDeviceServer(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    apiResult = null;
                }
                if (apiResult instanceof ApiResult.Success) {
                    if (((ServerFirmware) ((ApiResult.Success) apiResult).getData()).getNeed_update() == 1) {
                        Logger logger4 = Logger.INSTANCE;
                        str3 = this.$address;
                        logger3 = logger4;
                        tag3 = logger3.getTAG();
                        depth3 = logger3.getDepth();
                        if (logger3.isCanLogger(true)) {
                            str4 = str3 + " has new version to update!";
                            str5 = str4;
                            if (str5 != null && str5.length() != 0) {
                                Pair<String, String> trace = logger3.getTrace(depth3);
                                strComponent5 = trace.component1();
                                strComponent6 = trace.component2();
                                FileLog fileLog = FileLog.INSTANCE;
                                String str6 = logger3.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                FileLog.print$default(fileLog, 4, str6, tag3, str4 + StringUtils.SPACE + strComponent6, null, 16, null);
                                if (logger3.isDebug()) {
                                    Log.i(tag3 + strComponent5, str4 + StringUtils.SPACE + strComponent6);
                                }
                            }
                        }
                        this.this$0.updateFirmware(this.$address, this.$firmwareVersion, 1);
                    } else {
                        logger2 = Logger.INSTANCE;
                        tag2 = logger2.getTAG();
                        depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true) && "don't need update!!!".length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            strComponent3 = trace2.component1();
                            strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str7 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                            FileLog.print$default(fileLog2, 4, str7, tag2, "don't need update!!! " + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, "don't need update!!! " + strComponent4);
                            }
                        }
                        this.this$0.updateFirmware(this.$address, this.$firmwareVersion, 0);
                    }
                } else {
                    logger = Logger.INSTANCE;
                    tag = logger.getTAG();
                    depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        str = "check error " + apiResult;
                        str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace3 = logger.getTrace(depth);
                            strComponent1 = trace3.component1();
                            strComponent2 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str8 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                            FileLog.print$default(fileLog3, 5, str8, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            apiResult = (ApiResult) obj;
            if (apiResult instanceof ApiResult.Success) {
                if (((ServerFirmware) ((ApiResult.Success) apiResult).getData()).getNeed_update() == 1) {
                    Logger logger5 = Logger.INSTANCE;
                    str3 = this.$address;
                    logger3 = logger5;
                    tag3 = logger3.getTAG();
                    depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true)) {
                        str4 = str3 + " has new version to update!";
                        str5 = str4;
                        if (str5 != null) {
                            Pair<String, String> trace4 = logger3.getTrace(depth3);
                            strComponent5 = trace4.component1();
                            strComponent6 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str9 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                            FileLog.print$default(fileLog4, 4, str9, tag3, str4 + StringUtils.SPACE + strComponent6, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.i(tag3 + strComponent5, str4 + StringUtils.SPACE + strComponent6);
                            }
                        }
                    }
                    this.this$0.updateFirmware(this.$address, this.$firmwareVersion, 1);
                } else {
                    logger2 = Logger.INSTANCE;
                    tag2 = logger2.getTAG();
                    depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        Pair<String, String> trace5 = logger2.getTrace(depth2);
                        strComponent3 = trace5.component1();
                        strComponent4 = trace5.component2();
                        FileLog fileLog5 = FileLog.INSTANCE;
                        String str10 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                        FileLog.print$default(fileLog5, 4, str10, tag2, "don't need update!!! " + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, "don't need update!!! " + strComponent4);
                        }
                    }
                    this.this$0.updateFirmware(this.$address, this.$firmwareVersion, 0);
                }
            } else {
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str = "check error " + apiResult;
                    str2 = str;
                    if (str2 != null) {
                        Pair<String, String> trace6 = logger.getTrace(depth);
                        strComponent1 = trace6.component1();
                        strComponent2 = trace6.component2();
                        FileLog fileLog6 = FileLog.INSTANCE;
                        String str11 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                        FileLog.print$default(fileLog6, 5, str11, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    public void checkUpdateFirmware(String address, String firmwareVersion) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(firmwareVersion, "firmwareVersion");
        CoroutineScope coroutineScope = getCoroutineScope();
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new AnonymousClass1(address, this, firmwareVersion, null), 2, null);
        }
    }

    public void orderGetAutomaticUpdate(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: ORDER_AUTOMATIC_UPDATE  " + extras;
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
        getAutomaticUpdate(command, extras);
    }

    private final void getAutomaticUpdate(int command, Bundle extras) {
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        boolean z = false;
        MacCacheEntity nothingEar$default = MacCacheManager.getNothingEar$default(MacCacheManager.INSTANCE, string, false, 2, null);
        if (nothingEar$default != null && nothingEar$default.getAutoUpdate() == 1) {
            z = true;
        }
        final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
        bundleObtainBundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, z);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Response: ORDER_AUTOMATIC_UPDATE  " + bundleObtainBundle;
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
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.getAutomaticUpdate$lambda$35(bundleObtainBundle, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAutomaticUpdate$lambda$35(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(1330, bundle);
        return Unit.INSTANCE;
    }

    public void orderGetAnc(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: ORDER_ANC  " + extras;
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
        getOrderAnc(command, extras);
    }

    public void orderGetSerialNumber(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: ORDER_SERIAL_NUMBER  " + extras;
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
        getSerialNumber(command, extras);
    }

    public void orderGetLowLatency(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: ORDER_LOW_LATENCY  " + extras;
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
        getLowLatency(command, extras);
    }

    private final void getSerialNumber(int command, Bundle extras) {
        CoroutineScope coroutineScope;
        String str = this.serialNumber;
        if (str != null && str.length() > 0) {
            final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
            bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, this.serialNumber);
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "Response: ORDER_SERIAL_NUMBER cache " + bundleObtainBundle;
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
            remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseNothingEarImpl.getSerialNumber$lambda$40(this.f$0, bundleObtainBundle, (IDeviceServiceCallBack) obj);
                }
            });
            return;
        }
        if (safeTws(command, extras) == null || (coroutineScope = getCoroutineScope()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new BaseNothingEarImpl$getSerialNumber$3$1(extras, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSerialNumber$lambda$40(BaseNothingEarImpl baseNothingEarImpl, Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        String str = baseNothingEarImpl.serialNumber;
        if (str != null && str.length() > 0) {
            it.onSuccess(1300, bundle);
        } else {
            it.onFail(1300, -1);
        }
        return Unit.INSTANCE;
    }

    private final void getLowLatency(int command, Bundle extras) {
        if (safeTws(command, extras) != null) {
            DeviceProtocol.INSTANCE.getLagMode(OsMemoryCache.INSTANCE.getTwsDevice(extras));
        }
    }

    private final void updateLowLatency(Message message, Bundle extras) {
        final Integer num = message != null ? (Integer) message.obtainPayload(Integer.TYPE) : null;
        boolean z = num == null || num.intValue() != 2;
        final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
        bundleObtainBundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, z);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Response: ORDER_LOW_LATENCY " + bundleObtainBundle;
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
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.updateLowLatency$lambda$44(num, bundleObtainBundle, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateLowLatency$lambda$44(Integer num, Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        if (num != null) {
            it.onSuccess(715, bundle);
        } else {
            it.onFail(715, -1);
        }
        return Unit.INSTANCE;
    }

    private final void getInEarDetection(int command, Bundle extras) {
        if (safeTws(command, extras) != null) {
            DeviceProtocol.INSTANCE.getEarDetect(OsMemoryCache.INSTANCE.getTwsDevice(extras));
        }
    }

    private final void updateInEarDetection(Message message, Bundle extras) {
        final DeviceExtraFeatureStatus deviceExtraFeatureStatus = message != null ? (DeviceExtraFeatureStatus) message.obtainPayload(DeviceExtraFeatureStatus.class) : null;
        boolean zAreEqual = deviceExtraFeatureStatus != null ? Intrinsics.areEqual((Object) deviceExtraFeatureStatus.getEnable(1), (Object) true) : false;
        final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
        bundleObtainBundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, zAreEqual);
        if (deviceExtraFeatureStatus != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "Response: ORDER_IN_EAR_DETECTION " + bundleObtainBundle;
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
        } else {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "Response: ORDER_IN_EAR_DETECTION data = null!".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 6, str4, tag2, "Response: ORDER_IN_EAR_DETECTION data = null! " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.e(tag2 + strComponent3, "Response: ORDER_IN_EAR_DETECTION data = null! " + strComponent4);
                }
            }
        }
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.updateInEarDetection$lambda$48(deviceExtraFeatureStatus, bundleObtainBundle, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateInEarDetection$lambda$48(DeviceExtraFeatureStatus deviceExtraFeatureStatus, Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        if (deviceExtraFeatureStatus != null) {
            it.onSuccess(710, bundle);
        } else {
            it.onFail(710, -1);
        }
        return Unit.INSTANCE;
    }

    private final void getOrderAnc(int command, Bundle extras) {
        TWSDevice tWSDeviceSafeTws = safeTws(command, extras);
        if (tWSDeviceSafeTws != null) {
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.noiseReduction$default(tWSDeviceSafeTws, null, 1, null), false, (byte[]) null, 0, 7, (Object) null);
        }
    }

    private final void getEqualizer(int command, Bundle extras) {
        if (safeTws(command, extras) != null) {
            DeviceProtocol.INSTANCE.getEqMode(OsMemoryCache.INSTANCE.getTwsDevice(extras));
        }
    }

    private final void getBattery(int command, Bundle extras) {
        TWSDevice tWSDeviceSafeTws = safeTws(command, extras);
        if (tWSDeviceSafeTws != null) {
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.battery(tWSDeviceSafeTws), false, (byte[]) null, 0, 7, (Object) null);
        }
    }

    public void orderGetNTDeviceName(final int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: GET_NT_DEVICE_NAME  " + extras;
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
        final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
        IOTDevice infoByModelId = IOTDeviceManager.INSTANCE.getInfoByModelId(this.mModelId);
        bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, infoByModelId != null ? infoByModelId.getDeviceName() : null);
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "Response: GET_NT_DEVICE_NAME " + bundleObtainBundle;
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
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.orderGetNTDeviceName$lambda$54(command, bundleObtainBundle, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit orderGetNTDeviceName$lambda$54(int i, Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(i, bundle);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void orderGetEarBitmap(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request: GET_EAR_BITMAP  " + extras;
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
        getContext().getMainLooper().getQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda10
            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                return BaseNothingEarImpl.orderGetEarBitmap$lambda$56(this.f$0);
            }
        });
        boolean z = extras.getBoolean(DeviceConstant.KEY_EAR_CONNECTED, true);
        boolean zContainsKey = extras.containsKey(DeviceConstant.KEY_EAR_CONNECTED);
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        updateBitmap(string, zContainsKey ? 1 : 0, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean orderGetEarBitmap$lambda$56(BaseNothingEarImpl baseNothingEarImpl) {
        RouterFactory.INSTANCE.getWidgetRouter().freshSqlWidget(baseNothingEarImpl.getContext());
        return false;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.os.base.BaseNothingEarImpl$setEarDetection$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseNothingEarImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.os.base.BaseNothingEarImpl$setEarDetection$2", f = "BaseNothingEarImpl.kt", i = {0, 0}, l = {620}, m = "invokeSuspend", n = {"$this$launch", "enable"}, s = {"L$0", "Z$0"})
    static final class C06892 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $extras;
        private /* synthetic */ Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ BaseNothingEarImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06892(Bundle bundle, BaseNothingEarImpl baseNothingEarImpl, Continuation<? super C06892> continuation) {
            super(2, continuation);
            this.$extras = bundle;
            this.this$0 = baseNothingEarImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06892 c06892 = new C06892(this.$extras, this.this$0, continuation);
            c06892.L$0 = obj;
            return c06892;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06892) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            final CoroutineScope coroutineScope;
            final boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                boolean z2 = this.$extras.getBoolean(DeviceConstant.KEY_VALUE_BOOLEAN);
                this.L$0 = coroutineScope;
                this.Z$0 = z2;
                this.label = 1;
                Object earDetect = DeviceProtocol.INSTANCE.setEarDetect(OsMemoryCache.INSTANCE.getTwsDevice(this.$extras), z2, this);
                if (earDetect == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z = z2;
                obj = earDetect;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = this.Z$0;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            final Boolean bool = (Boolean) obj;
            BaseNothingEarImpl baseNothingEarImpl = this.this$0;
            final Bundle bundle = this.$extras;
            baseNothingEarImpl.remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$setEarDetection$2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BaseNothingEarImpl.C06892.invokeSuspend$lambda$5(bool, bundle, z, coroutineScope, (IDeviceServiceCallBack) obj2);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$5(Boolean bool, Bundle bundle, boolean z, CoroutineScope coroutineScope, IDeviceServiceCallBack iDeviceServiceCallBack) throws RemoteException {
            Message cacheCommandsManual;
            DeviceExtraFeatureStatus deviceExtraFeatureStatus;
            if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(bundle);
                bundleObtainBundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, z);
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "Response: ORDER_IN_EAR_DETECTION " + bundleObtainBundle;
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
                iDeviceServiceCallBack.onSuccess(710, bundleObtainBundle);
                TWSDevice twsDevice = OsMemoryCache.INSTANCE.getTwsDevice(bundle);
                if (twsDevice != null && (cacheCommandsManual = twsDevice.getCacheCommandsManual(ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS)) != null && (deviceExtraFeatureStatus = (DeviceExtraFeatureStatus) cacheCommandsManual.obtainPayload(DeviceExtraFeatureStatus.class)) != null) {
                    deviceExtraFeatureStatus.setEnable(1, z);
                    twsDevice.setCacheCommandsManualPayload(ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS, deviceExtraFeatureStatus.obtainDataPacket());
                    twsDevice.updateFromCache(ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS);
                }
            } else {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true) && "Response: ORDER_IN_EAR_DETECTION Failed".length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 6, str4, tag2, "Response: ORDER_IN_EAR_DETECTION Failed " + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.e(tag2 + strComponent3, "Response: ORDER_IN_EAR_DETECTION Failed " + strComponent4);
                    }
                }
                iDeviceServiceCallBack.onFail(710, 1);
            }
            return Unit.INSTANCE;
        }
    }

    private final void setEarDetection(Bundle extras) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "Request:setCommand ORDER_IN_EAR_DETECTION".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "Request:setCommand ORDER_IN_EAR_DETECTION " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "Request:setCommand ORDER_IN_EAR_DETECTION " + strComponent2);
            }
        }
        CoroutineScope coroutineScope = getCoroutineScope();
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new C06892(extras, this, null), 2, null);
        }
    }

    public final Job getAncJob() {
        return this.ancJob;
    }

    public final void setAncJob(Job job) {
        this.ancJob = job;
    }

    /* JADX INFO: renamed from: isClick, reason: from getter */
    public final AtomicBoolean getIsClick() {
        return this.isClick;
    }

    public final void setClick(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isClick = atomicBoolean;
    }

    private final void setNoiseCancellation(Bundle extras) {
        TWSDevice twsDevice;
        BaseNothingEarImpl baseNothingEarImpl;
        Job job = this.ancJob;
        Job jobLaunch$default = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        String string = extras.getString(DeviceConstant.KEY_VALUE_STRING);
        if (string == null || (twsDevice = getTwsDevice(extras)) == null) {
            return;
        }
        CoroutineScope coroutineScope = getCoroutineScope();
        if (coroutineScope != null) {
            baseNothingEarImpl = this;
            jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new BaseNothingEarImpl$setNoiseCancellation$1$1$1(baseNothingEarImpl, string, twsDevice, extras, null), 2, null);
        } else {
            baseNothingEarImpl = this;
        }
        baseNothingEarImpl.ancJob = jobLaunch$default;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.os.base.BaseNothingEarImpl$setLatencyMode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseNothingEarImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.os.base.BaseNothingEarImpl$setLatencyMode$1", f = "BaseNothingEarImpl.kt", i = {0, 0}, l = {698}, m = "invokeSuspend", n = {"$this$launch", "enable"}, s = {"L$0", "Z$0"})
    static final class C06901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bundle $extras;
        private /* synthetic */ Object L$0;
        boolean Z$0;
        int label;
        final /* synthetic */ BaseNothingEarImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06901(Bundle bundle, BaseNothingEarImpl baseNothingEarImpl, Continuation<? super C06901> continuation) {
            super(2, continuation);
            this.$extras = bundle;
            this.this$0 = baseNothingEarImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C06901 c06901 = new C06901(this.$extras, this.this$0, continuation);
            c06901.L$0 = obj;
            return c06901;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object lagMode;
            final boolean z;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                boolean z2 = this.$extras.getBoolean(DeviceConstant.KEY_VALUE_BOOLEAN);
                this.L$0 = coroutineScope;
                this.Z$0 = z2;
                this.label = 1;
                lagMode = DeviceProtocol.INSTANCE.setLagMode(OsMemoryCache.INSTANCE.getTwsDevice(this.$extras), z2, this);
                if (lagMode == coroutine_suspended) {
                    return coroutine_suspended;
                }
                z = z2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = this.Z$0;
                ResultKt.throwOnFailure(obj);
                lagMode = obj;
            }
            final Boolean bool = (Boolean) lagMode;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "Response:setCommand ORDER_LOW_LATENCY old:" + z + " ,new:" + bool;
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
            final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(this.$extras);
            bundleObtainBundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, z);
            BaseNothingEarImpl baseNothingEarImpl = this.this$0;
            final Bundle bundle = this.$extras;
            baseNothingEarImpl.remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$setLatencyMode$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return BaseNothingEarImpl.C06901.invokeSuspend$lambda$2(bool, bundleObtainBundle, bundle, z, (IDeviceServiceCallBack) obj2);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$2(Boolean bool, Bundle bundle, Bundle bundle2, boolean z, IDeviceServiceCallBack iDeviceServiceCallBack) throws RemoteException {
            byte[] byteArray$default;
            if (Intrinsics.areEqual((Object) bool, (Object) true)) {
                iDeviceServiceCallBack.onSuccess(715, bundle);
                TWSDevice twsDevice = OsMemoryCache.INSTANCE.getTwsDevice(bundle2);
                if (twsDevice != null) {
                    if (z) {
                        byteArray$default = DataExtKt.toByteArray$default(1, 0, 1, (Object) null);
                    } else {
                        byteArray$default = DataExtKt.toByteArray$default(2, 0, 1, (Object) null);
                    }
                    twsDevice.setCacheCommandsManualPayload(ProtocolConstant.Query.GET_HOST_LAG_MODE, byteArray$default);
                    twsDevice.updateFromCache(ProtocolConstant.Query.GET_HOST_LAG_MODE);
                }
            } else {
                iDeviceServiceCallBack.onFail(715, 1);
            }
            return Unit.INSTANCE;
        }
    }

    private final void setLatencyMode(Bundle extras) {
        CoroutineScope coroutineScope = getCoroutineScope();
        if (coroutineScope != null) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new C06901(extras, this, null), 2, null);
        }
    }

    static /* synthetic */ void updateBitmap$default(BaseNothingEarImpl baseNothingEarImpl, String str, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBitmap");
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        baseNothingEarImpl.updateBitmap(str, i, z);
    }

    private final void updateBitmap(String address, int fromPage, boolean connected) {
        final Bundle bundle = new Bundle();
        bundle.putString("device_address", address);
        bundle.putBoolean(DeviceConstant.KEY_EAR_CONNECTED, connected);
        bundle.putString(DeviceConstant.KEY_MODEL_ID, this.mModelId);
        bundle.putInt(DeviceConstant.KEY_FORM_PAGE, fromPage);
        bundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, this.isDeleteCache);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Response: GET_EAR_BITMAP " + bundle + StringUtils.SPACE + this + "  ";
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
        this.isDeleteCache = false;
        bundle.putBinder(DeviceConstant.KEY_BITMAP, this.connectedBinder);
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.updateBitmap$lambda$61(bundle, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateBitmap$lambda$61(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(3, bundle);
        return Unit.INSTANCE;
    }

    public final void updateSystemUIBitmap(final int command, Bundle data) {
        Intrinsics.checkNotNullParameter(data, "data");
        final Bundle bundle = new Bundle();
        bundle.putString("device_address", this.address);
        bundle.putString(DeviceConstant.KEY_MODEL_ID, this.mModelId);
        bundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, this.isDeleteSystemCache);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Response: GET_GET_SMALL_ICON " + bundle + StringUtils.SPACE + this + "  ";
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
        this.isDeleteSystemCache = false;
        bundle.putBinder(DeviceConstant.KEY_BITMAP, this.systemUIBinder);
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.updateSystemUIBitmap$lambda$63(command, bundle, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateSystemUIBitmap$lambda$63(int i, Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(i, bundle);
        return Unit.INSTANCE;
    }

    private final Binder convertSystemUIBitmapToBinder() {
        IOTDevice infoByModelId = IOTDeviceManager.INSTANCE.getInfoByModelId(getModelId());
        final Void r1 = null;
        final Integer numValueOf = infoByModelId != null ? Integer.valueOf(infoByModelId.getOsSystemUIImage()) : null;
        return new IDeviceBitmap.Stub() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$convertSystemUIBitmapToBinder$binder$1
            @Override // com.nothing.os.device.IDeviceBitmap
            public Bitmap getLeftBitmap() {
                Object obj = r1;
                if (obj != null) {
                    return IntExtKt.toBitmap(((Number) obj).intValue());
                }
                return null;
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            public Bitmap getRightBitmap() {
                Integer num = numValueOf;
                if (num != null) {
                    return IntExtKt.toBitmap(num.intValue());
                }
                return null;
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            public Bitmap getCaseBitmap() {
                Object obj = r1;
                if (obj != null) {
                    return IntExtKt.toBitmap(((Number) obj).intValue());
                }
                return null;
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            public Bitmap getDefaultBitmap() {
                Object obj = r1;
                if (obj != null) {
                    return IntExtKt.toBitmap(((Number) obj).intValue());
                }
                return null;
            }
        };
    }

    private final Binder convertBitmapToBinder() {
        IOTDevice infoByModelId = IOTDeviceManager.INSTANCE.getInfoByModelId(getModelId());
        final int osLeftImage = infoByModelId != null ? infoByModelId.getOsLeftImage() : R.drawable.ear_default_left;
        final int osRightImage = infoByModelId != null ? infoByModelId.getOsRightImage() : R.drawable.ear_default_right;
        final int osCaseImage = infoByModelId != null ? infoByModelId.getOsCaseImage() : R.drawable.ear_os_default_case;
        final int osDisconnectedImage = infoByModelId != null ? infoByModelId.getOsDisconnectedImage() : R.drawable.ear_os_default_disconnected;
        return new IDeviceBitmap.Stub() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$convertBitmapToBinder$binder$1
            @Override // com.nothing.os.device.IDeviceBitmap
            public Bitmap getLeftBitmap() {
                return IntExtKt.toBitmap(osLeftImage);
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            public Bitmap getRightBitmap() {
                return IntExtKt.toBitmap(osRightImage);
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            public Bitmap getCaseBitmap() {
                return IntExtKt.toBitmap(osCaseImage);
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            public Bitmap getDefaultBitmap() {
                return IntExtKt.toBitmap(osDisconnectedImage);
            }
        };
    }

    public final TWSDevice safeTws(final int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        TWSDevice twsDevice = getTwsDevice(extras);
        if (twsDevice == null) {
            remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BaseNothingEarImpl.safeTws$lambda$64(command, (IDeviceServiceCallBack) obj);
                }
            });
            return null;
        }
        if (twsDevice.isConnected()) {
            return twsDevice;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = command + " ," + extras;
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
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit safeTws$lambda$64(int i, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onFail(i, 0);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected(TWSDevice twsDevice) {
        Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
        com.nothing.link.bluetooth.sdk.util.Logger logger = com.nothing.link.bluetooth.sdk.util.Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "BaseNothingEarCallBack ---> onConnected " + twsDevice.getAddress();
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
        if (this.isSendToSetting) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "connectedStatusChange ignore CONNECT..." + twsDevice.getAddress();
                String str5 = str4;
                if (str5 == null || str5.length() == 0) {
                    return;
                }
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog2, 5, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.w(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    return;
                }
                return;
            }
            return;
        }
        this.isSendToSetting = true;
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str7 = "connectedStatusChange CONNECT..." + twsDevice.getAddress();
            String str8 = str7;
            if (str8 != null && str8.length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str9 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                FileLog.print$default(fileLog3, 4, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                }
            }
        }
        final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(twsDevice.getAddress());
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.onConnected$lambda$69(bundleObtainBundle, (IDeviceServiceCallBack) obj);
            }
        });
        Bundle bundle = new Bundle();
        bundle.putString("device_address", twsDevice.getAddress());
        orderGetFirmwareUpdate(1310, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onConnected$lambda$69(Bundle bundle, IDeviceServiceCallBack callback) throws RemoteException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onSuccess(0, bundle);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected(TWSDevice twsDevice) {
        Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
        this.isSendToSetting = false;
        OTAHelper oTAHelper = OTAHelper.INSTANCE;
        String address = twsDevice.getAddress();
        if (address == null) {
            address = "";
        }
        oTAHelper.deviceDisconnet(address);
        boolean zCheckPermission = OsPermissionCheck.INSTANCE.checkPermission(getContext());
        String address2 = twsDevice.getAddress();
        if (address2 != null) {
            final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(address2);
            if (zCheckPermission) {
                remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseNothingEarImpl.onDisconnected$lambda$73$lambda$70(bundleObtainBundle, (IDeviceServiceCallBack) obj);
                    }
                });
            } else {
                remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseNothingEarImpl.onDisconnected$lambda$73$lambda$71((IDeviceServiceCallBack) obj);
                    }
                });
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "connectedStatusChange DISCONNECT..." + address2;
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
            updateBitmap$default(this, address2, 0, false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDisconnected$lambda$73$lambda$70(Bundle bundle, IDeviceServiceCallBack callback) throws RemoteException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onSuccess(2, bundle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDisconnected$lambda$73$lambda$71(IDeviceServiceCallBack callback) throws RemoteException {
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.onFail(2, -1);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message message, TWSDevice twsDevice) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
        Bundle bundle = new Bundle();
        bundle.putString("device_address", twsDevice.getAddress());
        z = false;
        boolean z = false;
        switch (cmdType) {
            case 49159:
            case 57345:
                DeviceBattery deviceBattery = (DeviceBattery) message.obtainPayload(DeviceBattery.class);
                if (deviceBattery != null) {
                    final Bundle battery = parseBattery(twsDevice.getAddress(), deviceBattery, this.mModelId);
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "Response: GET_BATTERY notification  " + battery;
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
                    remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BaseNothingEarImpl.onUpdate$lambda$76$lambda$75(battery, (IDeviceServiceCallBack) obj);
                        }
                    });
                }
                break;
            case ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS /* 49166 */:
                updateInEarDetection(message, bundle);
                break;
            case 49182:
            case 57347:
                DeviceNoiseReduction deviceNoiseReduction = (DeviceNoiseReduction) message.obtainPayload(DeviceNoiseReduction.class);
                if (deviceNoiseReduction != null && !this.isClick.get()) {
                    responseANCData(bundle, deviceNoiseReduction);
                    break;
                }
                break;
            case 49183:
                Integer num = (Integer) message.obtainPayload(Integer.TYPE);
                final Bundle eqModel = parseEqModel(getContext(), num != null ? num.intValue() : 0, bundle);
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "Response: ORDER_EQUALIZER notification  " + eqModel;
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
                remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseNothingEarImpl.onUpdate$lambda$79(eqModel, (IDeviceServiceCallBack) obj);
                    }
                });
                break;
            case ProtocolConstant.Query.GET_PERSONALIZED_ANC /* 49184 */:
                final Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(bundle);
                DeviceANCSwitch deviceANCSwitch = (DeviceANCSwitch) message.obtainPayload(DeviceANCSwitch.class);
                if (deviceANCSwitch != null && deviceANCSwitch.getAncSwitch() == 1) {
                    z = true;
                }
                bundleObtainBundle.putBoolean(DeviceConstant.KEY_VALUE_BOOLEAN, z);
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str7 = "Response: GET_PERSONALIZED_ANC " + bundleObtainBundle;
                    String str8 = str7;
                    if (str8 != null && str8.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str9 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                        FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BaseNothingEarImpl.onUpdate$lambda$82(bundleObtainBundle, (IDeviceServiceCallBack) obj);
                    }
                });
                break;
            case ProtocolConstant.Query.GET_HOST_LAG_MODE /* 49217 */:
                updateLowLatency(message, bundle);
                Logger logger4 = Logger.INSTANCE;
                String tag4 = logger4.getTAG();
                int depth4 = logger4.getDepth();
                if (logger4.isCanLogger(true) && "updateFromCache syn app update ".length() != 0) {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str10 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                    FileLog.print$default(fileLog4, 4, str10, tag4, "updateFromCache syn app update  " + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag4 + strComponent7, "updateFromCache syn app update  " + strComponent8);
                    }
                }
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUpdate$lambda$76$lambda$75(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(4, bundle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUpdate$lambda$79(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(620, bundle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onUpdate$lambda$82(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(713, bundle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void responseANCData(Bundle bundle, DeviceNoiseReduction entity) {
        final Bundle noiseCancelModel = parseNoiseCancelModel(bundle, entity);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Response: ORDER_ANC notification  " + noiseCancelModel;
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
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.responseANCData$lambda$84(noiseCancelModel, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit responseANCData$lambda$84(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(610, bundle);
        return Unit.INSTANCE;
    }

    static /* synthetic */ void updateFirmware$default(BaseNothingEarImpl baseNothingEarImpl, String str, String str2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateFirmware");
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            i = -1;
        }
        baseNothingEarImpl.updateFirmware(str, str2, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateFirmware(String macAddress, String newVersion, int showNewCount) {
        if (macAddress.length() == 0 || StringsKt.equals(macAddress, BuildConfig.TRAVIS, true)) {
            return;
        }
        String str = newVersion;
        if (str == null || str.length() == 0) {
            newVersion = MacCacheManager.INSTANCE.getFirmVersion(macAddress);
        }
        if (newVersion.length() == 0) {
            return;
        }
        final Bundle bundle = new Bundle();
        bundle.putString("device_address", macAddress);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format(getString(R.string.new_version), Arrays.copyOf(new Object[]{newVersion}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        bundle.putString(DeviceConstant.KEY_VALUE_STRING, str2);
        if (showNewCount >= 0) {
            bundle.putInt(DeviceConstant.KEY_VALUE_INT, showNewCount);
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str3 = "Response: ORDER_FIRMWARE_UPDATE new or cache " + newVersion + StringUtils.SPACE + bundle;
            String str4 = str3;
            if (str4 != null && str4.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str5 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                FileLog.print$default(fileLog, 3, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        remoteBroadcast(new Function1() { // from class: com.nothing.earbase.os.base.BaseNothingEarImpl$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseNothingEarImpl.updateFirmware$lambda$86(bundle, (IDeviceServiceCallBack) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit updateFirmware$lambda$86(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(1310, bundle);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void routerJumpToActivity(int command, Bundle extras) {
        IOTDeviceOsAction osAction;
        IOTDeviceOsAction osAction2;
        Intrinsics.checkNotNullParameter(extras, "extras");
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        extras.putBoolean("removeTask", true);
        if (command == 660 || command == 670) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "OsRouterActivity  " + command;
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
            IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(string);
            if (productByMacAddress == null || (osAction = productByMacAddress.getOsAction()) == null) {
                return;
            }
            osAction.startActivity(string, 660, getContext());
            return;
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "OsRouterActivity " + command + StringUtils.SPACE + IOTDeviceManager.INSTANCE.getProductByMacAddress(string);
            String str5 = str4;
            if (str5 != null && str5.length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        IOTProductDevice productByMacAddress2 = IOTDeviceManager.INSTANCE.getProductByMacAddress(string);
        if (productByMacAddress2 == null || (osAction2 = productByMacAddress2.getOsAction()) == null) {
            return;
        }
        osAction2.startActivity(string, command, getContext());
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void onDestroy() {
        unRegister();
    }

    private final Bundle parseBattery(Bundle extras, DeviceBattery battery, String modelId) {
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        return parseBattery(string, battery, modelId);
    }

    public Bundle parseBattery(String macAddress, DeviceBattery battery, String modelId) {
        Intrinsics.checkNotNullParameter(battery, "battery");
        MacCacheEntity nothingEar$default = MacCacheManager.getNothingEar$default(MacCacheManager.INSTANCE, macAddress, false, 2, null);
        int caseBattery = nothingEar$default != null ? nothingEar$default.getCaseBattery() : -1;
        if (caseBattery == -10 || caseBattery == 0) {
            caseBattery = -1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("device_address", macAddress);
        Battery left = battery.getLeft();
        int battery2 = left != null ? left.getBattery() : -1;
        Battery right = battery.getRight();
        int battery3 = right != null ? right.getBattery() : -1;
        Battery battery4 = battery.getCase();
        if (battery4 != null) {
            caseBattery = battery4.getBattery();
        }
        if (caseBattery != -1 && nothingEar$default != null) {
            nothingEar$default.setCaseBattery(caseBattery);
        }
        if (battery2 != -1 && nothingEar$default != null) {
            nothingEar$default.setLeftBattery(battery2);
        }
        if (battery3 != -1 && nothingEar$default != null) {
            nothingEar$default.setRightBattery(battery3);
        }
        bundle.putInt(DeviceConstant.KEY_BATTERY_LEFT, battery2);
        bundle.putInt(DeviceConstant.KEY_BATTERY_RIGHT, battery3);
        bundle.putInt(DeviceConstant.KEY_BATTERY_CASE, caseBattery);
        MacCacheManager.INSTANCE.updateNothingEntity(nothingEar$default);
        return bundle;
    }

    private final Bundle parseEqModel(Context context, int type, Bundle extras) {
        String string;
        if (type == 0) {
            string = getString(R.string.sound_balanced);
        } else if (type == 1) {
            string = getString(R.string.sound_more_voice);
        } else if (type == 2) {
            string = getString(R.string.sound_more_treble);
        } else if (type == 3) {
            string = getString(R.string.sound_more_bass);
        } else if (type != 5) {
            string = "";
        } else {
            string = getString(R.string.sound_eq_custom);
        }
        Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
        bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, string);
        return bundleObtainBundle;
    }

    private final Bundle parseNoiseCancelModel(Bundle extras, DeviceNoiseReduction noiseReduction) {
        DeviceNoiseReduction deviceNoiseReduction;
        Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            deviceNoiseReduction = noiseReduction;
            String str = "parseNoiseCancelModel " + deviceNoiseReduction + StringUtils.SPACE;
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
        } else {
            deviceNoiseReduction = noiseReduction;
        }
        DeviceNoiseItem lastNoiseReductionLevel = deviceNoiseReduction.getLastNoiseReductionLevel();
        if (lastNoiseReductionLevel != null) {
            bundleObtainBundle.putInt(DeviceConstant.KEY_VALUE_INT, lastNoiseReductionLevel.getValue());
        }
        DeviceNoiseItem noiseReductionMode = deviceNoiseReduction.getNoiseReductionMode();
        Integer numValueOf = noiseReductionMode != null ? Integer.valueOf(noiseReductionMode.getValue()) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, "1");
            return bundleObtainBundle;
        }
        if (numValueOf != null && numValueOf.intValue() == 3) {
            bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, "3");
            return bundleObtainBundle;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, "2");
            return bundleObtainBundle;
        }
        if (numValueOf != null && numValueOf.intValue() == 4) {
            bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, DeviceConstant.NOISE_CANCELLATION_ADAPTIVE);
            return bundleObtainBundle;
        }
        if ((numValueOf != null && numValueOf.intValue() == 254) || (numValueOf != null && numValueOf.intValue() == 7)) {
            bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, DeviceConstant.NOISE_CANCELLATION_TRANSPARENCY);
            return bundleObtainBundle;
        }
        if ((numValueOf == null || numValueOf.intValue() != 0) && (numValueOf == null || numValueOf.intValue() != 5)) {
            return bundleObtainBundle;
        }
        bundleObtainBundle.putString(DeviceConstant.KEY_VALUE_STRING, DeviceConstant.NOISE_CANCELLATION_OFF);
        return bundleObtainBundle;
    }

    @Override // com.nothing.earbase.os.base.BaseNothingEar
    public Bundle getFunctionList(Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        ArrayList arrayList = new ArrayList();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        arrayList2.add(new DeviceFunctionItem(1, getString(R.string.os_device_sound), "", 601, 0, arrayList));
        String string = extras.getString("device_address");
        Bundle bundleObtainBundle = DeviceProtocol.INSTANCE.obtainBundle(extras);
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(string);
        if (iOTDeviceByMacAddress != null) {
            if (string == null) {
                string = "";
            }
            if (iOTDeviceByMacAddress.isSupportAnc(string)) {
                IOTProductDevice productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(iOTDeviceByMacAddress.getModelId());
                arrayList.add(new DeviceFunctionItem(2, "", "", 610, productByModelId != null ? productByModelId.getSupportANCLevel() : 0, new ArrayList()));
            }
            arrayList.add(new DeviceFunctionItem(3, getString(R.string.equalizer), "", 620, 0, new ArrayList()));
            ArrayList arrayList3 = new ArrayList();
            arrayList2.add(new DeviceFunctionItem(1, getString(R.string.controls), "", 651, 0, arrayList3));
            arrayList3.add(new DeviceFunctionItem(4, getString(R.string.os_device_gesture_controls), "", 660, 0, new ArrayList()));
            ArrayList arrayList4 = new ArrayList();
            arrayList2.add(new DeviceFunctionItem(1, getString(R.string.advanced_features), "", 701, 0, arrayList4));
            if (iOTDeviceByMacAddress.isSupportNoiseReduction()) {
                arrayList4.add(new DeviceFunctionItem(4, getString(R.string.noise_reduction), "", 723, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportInEarDetect()) {
                arrayList4.add(new DeviceFunctionItem(5, getString(R.string.sound_in_ear_detection), getString(R.string.sound_in_ear_detection_tips_less), 710, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportLagLatency()) {
                arrayList4.add(new DeviceFunctionItem(5, getString(R.string.sound_low_latency_mode), getString(R.string.sound_low_latency_mode_tips), 715, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportFindMyDevice()) {
                arrayList4.add(new DeviceFunctionItem(4, getString(R.string.find_my_earbud), getString(R.string.find_my_device_tip), 720, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportEarTipFitTest()) {
                arrayList4.add(new DeviceFunctionItem(4, getString(R.string.os_device_ear_tip_fit_test), getString(R.string.ear_tip_spec_start_fit_msg), 725, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportPersonalSound()) {
                arrayList4.add(new DeviceFunctionItem(8, getString(R.string.ear_personalised_sound), getString(R.string.os_personalised_summary), 716, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportPersonalANC()) {
                arrayList4.add(new DeviceFunctionItem(8, getString(R.string.anc_personalised_title), getString(R.string.anc_personalised_title_summary), 713, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportHighQualityAudio()) {
                arrayList4.add(new DeviceFunctionItem(4, getString(R.string.high_quality_audio), "", 717, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportDual()) {
                arrayList4.add(new DeviceFunctionItem(4, getString(R.string.dual_connection), "", 718, 0, new ArrayList()));
            }
            if (iOTDeviceByMacAddress.isSupportSerialNumber()) {
                arrayList2.add(new DeviceFunctionItem(3, getString(R.string.device_serial_number), "", 1300, 0, new ArrayList()));
            }
            arrayList2.add(new DeviceFunctionItem(3, getString(R.string.firmware_update), "", 1310, 0, new ArrayList()));
        }
        bundleObtainBundle.putParcelableArrayList(DeviceConstant.KEY_FUNCTION_LIST, arrayList2);
        return bundleObtainBundle;
    }
}
