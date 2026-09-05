package com.nothing.os.device.earpods.core;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import com.nothing.base.util.Logger;
import com.nothing.broadcase.BluetoothBroadcast;
import com.nothing.broadcase.ext.BluetoothDeviceExtKt;
import com.nothing.broadcase.manager.BluetoothHelper;
import com.nothing.ear.R;
import com.nothing.earbase.os.DeviceProtocol;
import com.nothing.earbase.os.OsMemoryCache;
import com.nothing.earbase.os.base.BaseEar;
import com.nothing.earbase.os.base.BaseEarPods;
import com.nothing.earbase.os.cache.entity.MacCacheEntity;
import com.nothing.earbase.os.ext.IntExtKt;
import com.nothing.log.FileLog;
import com.nothing.os.device.DeviceConstant;
import com.nothing.os.device.DeviceFunctionItem;
import com.nothing.os.device.IDeviceBitmap;
import com.nothing.os.device.IDeviceServiceCallBack;
import com.nothing.os.device.cache.MacCachePodsManager;
import com.nothing.os.device.earpods.AirpodsSelectModelActivity;
import com.nothing.os.device.earpods.data.BasePods;
import com.nothing.os.device.earpods.data.PodsItem;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: PodsEar.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0017J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010\"\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010#\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010$\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u001cJ*\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0019H\u0002J\u001c\u00101\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!022\u0006\u00103\u001a\u00020)H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00103\u001a\u00020)H\u0002J\u0012\u00104\u001a\u00020!2\b\u00103\u001a\u0004\u0018\u000105H\u0002J\u001e\u00101\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!022\b\u00103\u001a\u0004\u0018\u000105H\u0002J\u0018\u00106\u001a\u00020\u00152\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020\u001cJ&\u0010:\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!02H\u0002J\u0018\u0010<\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006>"}, d2 = {"Lcom/nothing/os/device/earpods/core/PodsEar;", "Lcom/nothing/earbase/os/base/BaseEar;", "Lcom/nothing/earbase/os/base/BaseEarPods;", "device", "Landroid/bluetooth/BluetoothDevice;", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "podsManager", "Lcom/nothing/os/device/earpods/core/PodsManager;", "<init>", "(Landroid/bluetooth/BluetoothDevice;Landroid/os/RemoteCallbackList;Landroid/os/Handler;Lkotlinx/coroutines/CoroutineScope;Lcom/nothing/os/device/earpods/core/PodsManager;)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getPodsManager", "()Lcom/nothing/os/device/earpods/core/PodsManager;", "register", "", "autoConnect", "", "fromPage", "", "updateCacheAirpodsData", "address", "", "force", "orderSetMacAddress", "command", "extras", "Landroid/os/Bundle;", "orderGetBattery", "routerJumpToActivity", "orderGetFunctionList", "startSelectModelActivity", "context", "Landroid/content/Context;", "getAirpodsBatteryFromCache", "Lcom/nothing/earbase/os/cache/entity/MacCacheEntity;", "macAddress", "createAirpodsBitmapReal", "Landroid/os/Binder;", "leftResId", "rightResId", "caseResId", "defaultResId", "parsePodsBatteryAndBitmap", "Lkotlin/Pair;", "item", "parsePodsBitmap", "Lcom/nothing/os/device/earpods/data/BasePods;", "successUpdateAirPods", "battery", "Lcom/nothing/os/device/earpods/core/PodsBattery;", "currentMacAddress", "responseAirPods", "parseBattery", "orderGetEarBitmap", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PodsEar extends BaseEar implements BaseEarPods {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BluetoothDevice device;
    private final PodsManager podsManager;

    public final BluetoothDevice getDevice() {
        return this.device;
    }

    public final PodsManager getPodsManager() {
        return this.podsManager;
    }

    /* JADX INFO: compiled from: PodsEar.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/nothing/os/device/earpods/core/PodsEar$Companion;", "", "<init>", "()V", "parsePodsPairBattery", "Lkotlin/Pair;", "Lcom/nothing/os/device/earpods/core/AirPodsModel;", "Landroid/os/Bundle;", "item", "Lcom/nothing/earbase/os/cache/entity/MacCacheEntity;", "parsePodsBattery", "Lcom/nothing/os/device/earpods/data/BasePods;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Pair<AirPodsModel, Bundle> parsePodsPairBattery(MacCacheEntity item) {
            Intrinsics.checkNotNullParameter(item, "item");
            Bundle bundle = new Bundle();
            AirPodsModel model_unknown = AirPodsModel.INSTANCE.getMODEL_UNKNOWN();
            for (AirPodsModel airPodsModel : AirPodsModel.Companion.values$default(AirPodsModel.INSTANCE, false, 1, null)) {
                if (Intrinsics.areEqual(item.getModelId(), airPodsModel.getModelName()) || Intrinsics.areEqual(item.getModelId(), airPodsModel.getModelId())) {
                    model_unknown = airPodsModel;
                }
            }
            boolean single = model_unknown.getSingle();
            bundle.putInt(DeviceConstant.KEY_BATTERY_LEFT, single ? -1 : item.getLeftBattery());
            bundle.putInt(DeviceConstant.KEY_BATTERY_RIGHT, single ? -1 : item.getRightBattery());
            bundle.putInt(DeviceConstant.KEY_BATTERY_CASE, item.getCaseBattery());
            bundle.putString(DeviceConstant.KEY_VALUE_STRING, item.getModelId());
            return TuplesKt.to(model_unknown, bundle);
        }

        public final Bundle parsePodsBattery(MacCacheEntity item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return parsePodsPairBattery(item).getSecond();
        }

        public final Bundle parsePodsBattery(BasePods item) {
            int iIntValue;
            Bundle bundle = new Bundle();
            if (item != null) {
                PodsItem leftPod = item.getLeftPod();
                if (leftPod != null) {
                    Integer cacheBattery = leftPod.getCacheBattery();
                    int iIntValue2 = cacheBattery != null ? cacheBattery.intValue() : -1;
                    int i = leftPod.isLowBattery() ? 0 : 2;
                    if (item.isSingle() || !leftPod.isConnected()) {
                        iIntValue2 = -1;
                    }
                    bundle.putInt(DeviceConstant.KEY_BATTERY_LEFT, iIntValue2);
                    bundle.putInt(DeviceConstant.KEY_BATTERY_LEFT_MODE, i);
                }
                PodsItem rightPod = item.getRightPod();
                if (rightPod != null) {
                    Integer cacheBattery2 = rightPod.getCacheBattery();
                    iIntValue = cacheBattery2 != null ? cacheBattery2.intValue() : -1;
                    int i2 = rightPod.isLowBattery() ? 0 : 2;
                    bundle.putInt(DeviceConstant.KEY_BATTERY_RIGHT, (item.isSingle() || !rightPod.isConnected()) ? -1 : iIntValue);
                    bundle.putInt(DeviceConstant.KEY_BATTERY_RIGHT_MODE, i2);
                } else {
                    iIntValue = 0;
                }
                PodsItem casePod = item.getCasePod();
                if (casePod != null) {
                    Integer cacheBattery3 = casePod.getCacheBattery();
                    int iIntValue3 = cacheBattery3 != null ? cacheBattery3.intValue() : -1;
                    int i3 = casePod.isLowBattery() ? 0 : 2;
                    if (!item.isSingle()) {
                        iIntValue = iIntValue3;
                    }
                    bundle.putInt(DeviceConstant.KEY_BATTERY_CASE, iIntValue);
                    bundle.putInt(DeviceConstant.KEY_BATTERY_CASE_MODE, i3);
                }
                bundle.putString(DeviceConstant.KEY_VALUE_STRING, item.getModel().getModelName());
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "parsePodsBattery  :" + bundle;
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
            return bundle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PodsEar(BluetoothDevice device, RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, PodsManager podsManager) {
        super(callbacks, handler, coroutineScope, null, 8, null);
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.device = device;
        this.podsManager = podsManager;
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void register(boolean autoConnect, int fromPage) {
        List<BluetoothDevice> connectedDevice;
        ConcurrentHashMap<String, ConnectedPods> connectedAirPods;
        BluetoothHelper helper = BluetoothBroadcast.INSTANCE.getInstance().getHelper();
        if (helper != null && (connectedDevice = helper.getConnectedDevice()) != null) {
            for (BluetoothDevice bluetoothDevice : connectedDevice) {
                PodsManager podsManager = this.podsManager;
                if (podsManager != null && (connectedAirPods = podsManager.getConnectedAirPods()) != null) {
                    connectedAirPods.clear();
                }
                OsMemoryCache.INSTANCE.setCurrentMacAddress(this.device.getAddress());
                PodsManager podsManager2 = this.podsManager;
                if (podsManager2 != null) {
                    podsManager2.connectedStatusChange(bluetoothDevice, true);
                }
            }
        }
        String address = this.device.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        updateCacheAirpodsData(address, true);
    }

    public static /* synthetic */ void updateCacheAirpodsData$default(PodsEar podsEar, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        podsEar.updateCacheAirpodsData(str, z);
    }

    public final void updateCacheAirpodsData(String address, boolean force) {
        PodsManager podsManager;
        ConcurrentHashMap<String, ConnectedPods> connectedAirPods;
        ConnectedPods connectedPods;
        CoroutineScope coroutineScope;
        ConcurrentHashMap<String, ConnectedPods> connectedAirPods2;
        ConcurrentHashMap<String, ConnectedPods> lastCacheConnectedAirPods;
        Intrinsics.checkNotNullParameter(address, "address");
        PodsManager podsManager2 = this.podsManager;
        ConnectedPods connectedPods2 = (podsManager2 == null || (lastCacheConnectedAirPods = podsManager2.getLastCacheConnectedAirPods()) == null) ? null : lastCacheConnectedAirPods.get(address);
        if (connectedPods2 != null) {
            Log.i("PodsBattery", "lastCacheConnectedAirPods");
            PodsEar airpodsDevice = PodsManager.INSTANCE.getAirpodsDevice(connectedPods2.getMacAddress());
            if (airpodsDevice != null) {
                airpodsDevice.successUpdateAirPods(connectedPods2.getLastPodsBattery(), connectedPods2.getMacAddress());
            }
            String deviceName = BluetoothDeviceExtKt.getDeviceName(this.device);
            PodsManager podsManager3 = this.podsManager;
            if (podsManager3 == null || (connectedAirPods2 = podsManager3.getConnectedAirPods()) == null) {
                return;
            }
            String address2 = this.device.getAddress();
            String address3 = this.device.getAddress();
            Intrinsics.checkNotNullExpressionValue(address3, "getAddress(...)");
            connectedAirPods2.put(address2, new ConnectedPods(deviceName, address3, connectedPods2.getModelName()));
            return;
        }
        MacCacheEntity airpodsBatteryFromCache = getAirpodsBatteryFromCache(address);
        Log.i("PodsBattery", "getAirpodsBatteryFromCache " + airpodsBatteryFromCache);
        if (airpodsBatteryFromCache == null) {
            if (!force || (coroutineScope = getCoroutineScope()) == null) {
                return;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
            return;
        }
        for (AirPodsModel airPodsModel : AirPodsModel.Companion.values$default(AirPodsModel.INSTANCE, false, 1, null)) {
            if (Intrinsics.areEqual(airpodsBatteryFromCache.getModelId(), airPodsModel.getModelName()) && (podsManager = this.podsManager) != null && (connectedAirPods = podsManager.getConnectedAirPods()) != null && (connectedPods = connectedAirPods.get(address)) != null) {
                connectedPods.setModelName(airPodsModel);
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.os.device.earpods.core.PodsEar$updateCacheAirpodsData$2, reason: invalid class name */
    /* JADX INFO: compiled from: PodsEar.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.earpods.core.PodsEar$updateCacheAirpodsData$2", f = "PodsEar.kt", i = {}, l = {186}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PodsEar.this.new AnonymousClass2(continuation);
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
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            PodsManager podsManager = PodsEar.this.getPodsManager();
            if (podsManager != null) {
                podsManager.setStartScanner(false);
            }
            PodsManager podsManager2 = PodsEar.this.getPodsManager();
            if (podsManager2 != null) {
                podsManager2.startScanner(PodsEar.this.getContext());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void orderSetMacAddress(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        PodsManager podsManager = this.podsManager;
        if (podsManager != null) {
            podsManager.startScanner(getContext());
        }
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void orderGetBattery(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        String string = extras.getString("device_address");
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            return;
        }
        updateCacheAirpodsData$default(this, string, false, 2, null);
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void routerJumpToActivity(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (command == 1320) {
            startSelectModelActivity(getContext(), DeviceProtocol.INSTANCE.obtainBundle(extras));
        }
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void orderGetFunctionList(final int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        if (PodsUtil.INSTANCE.isSupportAirpods()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "Request: GET_FUNCTION_LIST airpods  " + extras;
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
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            arrayList.add(new DeviceFunctionItem(4, getString(R.string.os_device_select_model), "", 1320, 0, new ArrayList()));
            bundleObtainBundle.putParcelableArrayList(DeviceConstant.KEY_FUNCTION_LIST, arrayList);
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "Response: GET_FUNCTION_LIST   " + arrayList;
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
            remoteBroadcast(new Function1() { // from class: com.nothing.os.device.earpods.core.PodsEar$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PodsEar.orderGetFunctionList$lambda$5(command, bundleObtainBundle, (IDeviceServiceCallBack) obj);
                }
            });
            return;
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str7 = "Request: GET_FUNCTION_LIST cant support airpods  " + extras;
            String str8 = str7;
            if (str8 == null || str8.length() == 0) {
                return;
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit orderGetFunctionList$lambda$5(int i, Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(i, bundle);
        return Unit.INSTANCE;
    }

    private final void startSelectModelActivity(Context context, Bundle extras) {
        Intent intent = new Intent(context, (Class<?>) AirpodsSelectModelActivity.class);
        intent.putExtras(extras);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public final MacCacheEntity getAirpodsBatteryFromCache(String macAddress) {
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        if (macAddress.length() == 0) {
            return null;
        }
        MacCacheEntity airpods = MacCachePodsManager.INSTANCE.getAirpods(macAddress);
        if (airpods == null) {
            PodsManager podsManager = this.podsManager;
            AirPodsModel airPodsModelFindBestAirpodsModel = podsManager != null ? podsManager.findBestAirpodsModel(this.device) : null;
            Log.i("PodsBattery", "getAirpodsBatteryFromCache only update bitmap : " + airPodsModelFindBestAirpodsModel + StringUtils.SPACE);
            if (airPodsModelFindBestAirpodsModel == null) {
                airPodsModelFindBestAirpodsModel = AirPodsModel.INSTANCE.getMODEL_UNKNOWN();
            }
            responseAirPods(macAddress, parsePodsBatteryAndBitmap(PodsBattery.Companion.parseBatteryByModel$default(PodsBattery.INSTANCE, airPodsModelFindBestAirpodsModel.getModelName(), null, null, null, null, 30, null)));
            return airpods;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "getAirpodsBatteryFromCache update bitmap and battery : " + airpods;
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
        responseAirPods(macAddress, parsePodsBatteryAndBitmap(airpods));
        return airpods;
    }

    private final Binder createAirpodsBitmapReal(int leftResId, int rightResId, int caseResId, int defaultResId) {
        final Bitmap bitmap = IntExtKt.toBitmap(leftResId);
        final Bitmap bitmap2 = IntExtKt.toBitmap(rightResId);
        final Bitmap bitmap3 = IntExtKt.toBitmap(caseResId);
        final Bitmap bitmap4 = IntExtKt.toBitmap(defaultResId);
        return new IDeviceBitmap.Stub() { // from class: com.nothing.os.device.earpods.core.PodsEar.createAirpodsBitmapReal.1
            @Override // com.nothing.os.device.IDeviceBitmap
            /* JADX INFO: renamed from: getLeftBitmap, reason: from getter */
            public Bitmap get$leftBitmap() {
                return bitmap;
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            /* JADX INFO: renamed from: getRightBitmap, reason: from getter */
            public Bitmap get$rightBitmap() {
                return bitmap2;
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            /* JADX INFO: renamed from: getCaseBitmap, reason: from getter */
            public Bitmap get$caseBitmap() {
                return bitmap3;
            }

            @Override // com.nothing.os.device.IDeviceBitmap
            /* JADX INFO: renamed from: getDefaultBitmap, reason: from getter */
            public Bitmap get$defaultBitmap() {
                return bitmap4;
            }
        };
    }

    private final Pair<Bundle, Bundle> parsePodsBatteryAndBitmap(MacCacheEntity item) {
        return TuplesKt.to(INSTANCE.parsePodsBattery(item), parsePodsBitmap(item));
    }

    private final Bundle parsePodsBitmap(MacCacheEntity item) {
        Bundle bundle = new Bundle();
        AirPodsModel model_unknown = AirPodsModel.INSTANCE.getMODEL_UNKNOWN();
        for (AirPodsModel airPodsModel : AirPodsModel.Companion.values$default(AirPodsModel.INSTANCE, false, 1, null)) {
            if (Intrinsics.areEqual(item.getModelId(), airPodsModel.getModelName())) {
                model_unknown = airPodsModel;
            }
        }
        model_unknown.getSingle();
        bundle.putBinder(DeviceConstant.KEY_BITMAP, createAirpodsBitmapReal(model_unknown.getLeftResId(), model_unknown.getRightResId(), model_unknown.getCaseResId(), model_unknown.getDefaultResId()));
        bundle.putString(DeviceConstant.KEY_VALUE_STRING, item.getModelId());
        return bundle;
    }

    private final Bundle parsePodsBitmap(BasePods item) {
        Bundle bundle = new Bundle();
        if (item != null) {
            bundle.putBinder(DeviceConstant.KEY_BITMAP, createAirpodsBitmapReal(item.getLeftDrawable(), item.getRightDrawable(), item.getCaseDrawable(), item.getDefaultDrawable()));
            bundle.putString(DeviceConstant.KEY_VALUE_STRING, item.getModel().getModelName());
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "parsePodsBitmap  :" + bundle;
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
        return bundle;
    }

    private final Pair<Bundle, Bundle> parsePodsBatteryAndBitmap(BasePods item) {
        return TuplesKt.to(INSTANCE.parsePodsBattery(item), parsePodsBitmap(item));
    }

    public final void successUpdateAirPods(PodsBattery battery, String currentMacAddress) {
        Intrinsics.checkNotNullParameter(currentMacAddress, "currentMacAddress");
        if (battery == null) {
            return;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "successUpdateAirPods  " + currentMacAddress + StringUtils.SPACE + battery;
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
        responseAirPods(currentMacAddress, parsePodsBatteryAndBitmap(battery.getPods()));
    }

    private final void responseAirPods(String address, Pair<Bundle, Bundle> parseBattery) {
        if (PodsUtil.INSTANCE.isSupportAirpods()) {
            final Bundle second = parseBattery.getSecond();
            second.putString("device_address", address);
            remoteBroadcast(new Function1() { // from class: com.nothing.os.device.earpods.core.PodsEar$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PodsEar.responseAirPods$lambda$12(second, (IDeviceServiceCallBack) obj);
                }
            });
            final Bundle first = parseBattery.getFirst();
            first.putString("device_address", address);
            remoteBroadcast(new Function1() { // from class: com.nothing.os.device.earpods.core.PodsEar$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return PodsEar.responseAirPods$lambda$13(first, (IDeviceServiceCallBack) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit responseAirPods$lambda$12(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(3, bundle);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit responseAirPods$lambda$13(Bundle bundle, IDeviceServiceCallBack it) throws RemoteException {
        Intrinsics.checkNotNullParameter(it, "it");
        it.onSuccess(4, bundle);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.earbase.os.base.BaseEar
    public void orderGetEarBitmap(int command, Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Request:Get Ear bitmap " + extras;
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
        extras.getBoolean(DeviceConstant.KEY_EAR_CONNECTED, true);
        if (extras.getBoolean(DeviceConstant.KEY_IS_AIRPODS) && PodsUtil.INSTANCE.isSupportAirpods()) {
            if (string == null) {
                string = "";
            }
            updateCacheAirpodsData$default(this, string, false, 2, null);
        }
    }
}
