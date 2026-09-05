package com.nothing.earbase.home;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.nothing.base.model.Battery;
import com.nothing.base.protocol.entity.BasicBoolean;
import com.nothing.base.protocol.entity.DeviceConfiguration;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.router.os.OsRouter;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.ToastUtil;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.dao.DeviceItemDao;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.anc.entity.DeviceNoiseItem;
import com.nothing.earbase.anc.entity.DeviceNoiseReduction;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.ota.entity.DeviceBattery;
import com.nothing.earbase.ota.entity.EarphoneStatus;
import com.nothing.earbase.widget.news.NewsMedia3Manager;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ConnectViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001/\u0018\u0000 H2\u00020\u0001:\u0001HB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0-J\f\u00101\u001a\u00020)*\u00020+H\u0002J\u0012\u00102\u001a\u00020)2\b\u00103\u001a\u0004\u0018\u000104H\u0002J\u001a\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u00010\n2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00107\u001a\u00020)2\b\u00108\u001a\u0004\u0018\u000109J\u001a\u0010:\u001a\u00020)2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010?\u001a\u00020)H\u0086@\u00a2\u0006\u0002\u0010@J\u0006\u0010A\u001a\u00020)J\u0006\u0010B\u001a\u00020)J\u0006\u0010C\u001a\u00020\u0011J\u0006\u0010D\u001a\u00020)J\n\u0010E\u001a\u0004\u0018\u00010FH\u0002J\n\u0010G\u001a\u0004\u0018\u00010+H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001f\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\u0015\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001f\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u001a0\u001a0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u001f\u0010\u001e\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u001a0\u001a0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u001f\u0010 \u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u001f\u0010\"\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0014R\u001f\u0010$\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\t\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\fR\u001f\u0010&\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\t\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\fR\u0010\u0010.\u001a\u00020/X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u00100\u00a8\u0006I"}, d2 = {"Lcom/nothing/earbase/home/ConnectViewModel;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "mBattery", "Landroidx/lifecycle/MutableLiveData;", "Lcom/nothing/earbase/ota/entity/DeviceBattery;", "getMBattery", "()Landroidx/lifecycle/MutableLiveData;", "setMBattery", "(Landroidx/lifecycle/MutableLiveData;)V", "leftConnect", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getLeftConnect", "()Landroidx/databinding/ObservableField;", "rightConnect", "getRightConnect", "hasANC", "getHasANC", "noiseImage", "", "getNoiseImage", "hasBassBoot", "getHasBassBoot", "spatialAudioImage", "getSpatialAudioImage", "hasSpatialAudio", "getHasSpatialAudio", "spatialVisible", "getSpatialVisible", "spatialSwitch", "getSpatialSwitch", "head", "getHead", "registerListener", "", "iotDevice", "Lcom/nothing/device/IOTDevice;", "firmwareVersionAction", "Lkotlin/Function0;", "magicButtonCallback", "com/nothing/earbase/home/ConnectViewModel$magicButtonCallback$1", "Lcom/nothing/earbase/home/ConnectViewModel$magicButtonCallback$1;", "initDeviceFeatureMsg", "updateNoiseImage", "noiseReduction", "Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;", "updateBattery", "battery", "updateEarConnectStatus", NotificationCompat.CATEGORY_STATUS, "Lcom/nothing/earbase/ota/entity/EarphoneStatus;", "updateSNNumber", "configuration", "Lcom/nothing/base/protocol/entity/DeviceConfiguration;", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "setSpatialAudio", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getNoiseModel", "resetDeviceMsg", "isNeedShowSpatialTips", "updateShowSpatialPop", "getProductDevice", "Lcom/nothing/device/IOTProductDevice;", "getIOTDevice", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectViewModel {
    public static final String CONNECT_VIEWMODEL = "ConnectViewModel";
    private final ObservableField<Boolean> hasANC;
    private final ObservableField<Boolean> hasBassBoot;
    private final ObservableField<Boolean> hasSpatialAudio;
    private final MutableLiveData<Boolean> head;
    private final ObservableField<Boolean> leftConnect;
    private final LifecycleOwner lifecycleOwner;
    private MutableLiveData<DeviceBattery> mBattery;
    private final ConnectViewModel$magicButtonCallback$1 magicButtonCallback;
    private final ObservableField<Integer> noiseImage;
    private final ObservableField<Boolean> rightConnect;
    private final ObservableField<Integer> spatialAudioImage;
    private final MutableLiveData<Boolean> spatialSwitch;
    private final ObservableField<Boolean> spatialVisible;

    /* JADX INFO: renamed from: com.nothing.earbase.home.ConnectViewModel$setSpatialAudio$1, reason: invalid class name */
    /* JADX INFO: compiled from: ConnectViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.home.ConnectViewModel", f = "ConnectViewModel.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {353, 388}, m = "setSpatialAudio", n = {"this", "$this$iv", "state", "needUpdate$iv", "$this$iv", "state", "needUpdate$iv"}, s = {"L$0", "L$2", "I$0", "I$1", "L$1", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ConnectViewModel.this.setSpatialAudio(this);
        }
    }

    /* JADX WARN: Type inference failed for: r3v12, types: [com.nothing.earbase.home.ConnectViewModel$magicButtonCallback$1] */
    public ConnectViewModel(LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.lifecycleOwner = lifecycleOwner;
        this.mBattery = new MutableLiveData<>();
        this.leftConnect = new ObservableField<>(false);
        this.rightConnect = new ObservableField<>(false);
        this.hasANC = new ObservableField<>(false);
        this.noiseImage = new ObservableField<>(Integer.valueOf(R.drawable.ic_ear_home_noise));
        this.hasBassBoot = new ObservableField<>(false);
        this.spatialAudioImage = new ObservableField<>(Integer.valueOf(R.drawable.spatial_audio_close));
        this.hasSpatialAudio = new ObservableField<>(false);
        this.spatialVisible = new ObservableField<>(true);
        this.spatialSwitch = new MutableLiveData<>(false);
        this.head = new MutableLiveData<>(false);
        this.magicButtonCallback = new TWSDevice.Callback() { // from class: com.nothing.earbase.home.ConnectViewModel$magicButtonCallback$1
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
            public void getBesVersionSuccess() {
                TWSDevice.Callback.DefaultImpls.getBesVersionSuccess(this);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public boolean isIOThread() {
                return TWSDevice.Callback.DefaultImpls.isIOThread(this);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onConnected(TWSDevice tWSDevice) {
                TWSDevice.Callback.DefaultImpls.onConnected(this, tWSDevice);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onConnecting(TWSDevice tWSDevice) {
                TWSDevice.Callback.DefaultImpls.onConnecting(this, tWSDevice);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onDisconnected(TWSDevice tWSDevice) {
                TWSDevice.Callback.DefaultImpls.onDisconnected(this, tWSDevice);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onError(TWSDevice tWSDevice) {
                TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onError(TWSDevice tWSDevice, int i, String str) {
                TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i, str);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onUpdate(int i, Message message, TWSDevice tWSDevice) {
                TWSDevice.Callback.DefaultImpls.onUpdate(this, i, message, tWSDevice);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void openBluetooth(TWSDevice tWSDevice) {
                TWSDevice.Callback.DefaultImpls.openBluetooth(this, tWSDevice);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onUpdate(int cmdType, Message data) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (cmdType == 57364) {
                    Integer num = (Integer) data.obtainPayload(Integer.TYPE);
                    if (num != null && num.intValue() == 31) {
                        NewsMedia3Manager.INSTANCE.playNothingWidget();
                    } else {
                        ToastUtil.INSTANCE.showToast("command:E014,value:" + num);
                    }
                }
            }
        };
    }

    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    public final MutableLiveData<DeviceBattery> getMBattery() {
        return this.mBattery;
    }

    public final void setMBattery(MutableLiveData<DeviceBattery> mutableLiveData) {
        this.mBattery = mutableLiveData;
    }

    public final ObservableField<Boolean> getLeftConnect() {
        return this.leftConnect;
    }

    public final ObservableField<Boolean> getRightConnect() {
        return this.rightConnect;
    }

    public final ObservableField<Boolean> getHasANC() {
        return this.hasANC;
    }

    public final ObservableField<Integer> getNoiseImage() {
        return this.noiseImage;
    }

    public final ObservableField<Boolean> getHasBassBoot() {
        return this.hasBassBoot;
    }

    public final ObservableField<Integer> getSpatialAudioImage() {
        return this.spatialAudioImage;
    }

    public final ObservableField<Boolean> getHasSpatialAudio() {
        return this.hasSpatialAudio;
    }

    public final ObservableField<Boolean> getSpatialVisible() {
        return this.spatialVisible;
    }

    public final MutableLiveData<Boolean> getSpatialSwitch() {
        return this.spatialSwitch;
    }

    public final MutableLiveData<Boolean> getHead() {
        return this.head;
    }

    public final void registerListener(final IOTDevice iotDevice, final Function0<Unit> firmwareVersionAction) {
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(firmwareVersionAction, "firmwareVersionAction");
        final TWSDevice twsDevice = iotDevice.getTwsDevice();
        if (twsDevice != null) {
            TWSDeviceExtKt.firmwareVersion(twsDevice).getLiveData().observe(this.lifecycleOwner, new ConnectViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.home.ConnectViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConnectViewModel.registerListener$lambda$12$lambda$11$lambda$2(iotDevice, firmwareVersionAction, twsDevice, this, (Message) obj);
                }
            }));
            final TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(twsDevice, null, 1, null);
            final Class<DeviceNoiseReduction> cls = DeviceNoiseReduction.class;
            Transformations.map(tWSDeviceBuilderNoiseReduction$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderNoiseReduction$default.getGetCommand(), tWSDeviceBuilderNoiseReduction$default.getNotifyCommand()), new Function1<Message, DeviceNoiseReduction>() { // from class: com.nothing.earbase.home.ConnectViewModel$registerListener$lambda$12$lambda$11$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final DeviceNoiseReduction invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    DeviceNoiseReduction deviceNoiseReduction = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    deviceNoiseReduction = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (DeviceNoiseReduction) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (DeviceNoiseReduction) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.anc.entity.DeviceNoiseReduction");
                                }
                                obj = (DeviceNoiseReduction) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (DeviceNoiseReduction) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (DeviceNoiseReduction) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            deviceNoiseReduction = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            deviceNoiseReduction = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + deviceNoiseReduction + StringUtils.SPACE;
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    return deviceNoiseReduction;
                }
            }).observe(this.lifecycleOwner, new ConnectViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.home.ConnectViewModel$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConnectViewModel.registerListener$lambda$12$lambda$11$lambda$3(this.f$0, (DeviceNoiseReduction) obj);
                }
            }));
            final TWSDeviceBuilder tWSDeviceBuilderForeverUpdate = TWSDeviceExtKt.battery(twsDevice).foreverUpdate();
            final Class<DeviceBattery> cls2 = DeviceBattery.class;
            Transformations.map(tWSDeviceBuilderForeverUpdate.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderForeverUpdate.getGetCommand(), tWSDeviceBuilderForeverUpdate.getNotifyCommand()), new Function1<Message, DeviceBattery>() { // from class: com.nothing.earbase.home.ConnectViewModel$registerListener$lambda$12$lambda$11$$inlined$getLiveData$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final DeviceBattery invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    DeviceBattery deviceBattery = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    deviceBattery = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls3 = cls2;
                        try {
                            if (Intrinsics.areEqual(cls3, Integer.TYPE)) {
                                obj = (DeviceBattery) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls3, Long.TYPE)) {
                                obj = (DeviceBattery) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls3, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.ota.entity.DeviceBattery");
                                }
                                obj = (DeviceBattery) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls3, Boolean.TYPE)) {
                                obj = (DeviceBattery) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls3, Float.TYPE)) {
                                obj = (DeviceBattery) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls3.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            deviceBattery = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            deviceBattery = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls4 = cls2;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls4 + StringUtils.SPACE + deviceBattery + StringUtils.SPACE;
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    return deviceBattery;
                }
            }).observe(this.lifecycleOwner, new ConnectViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.home.ConnectViewModel$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConnectViewModel.registerListener$lambda$12$lambda$11$lambda$4(this.f$0, iotDevice, (DeviceBattery) obj);
                }
            }));
            final TWSDeviceBuilder tWSDeviceBuilderForeverUpdate2 = TWSDeviceExtKt.earphoneStatus(twsDevice).foreverUpdate();
            final Class<EarphoneStatus> cls3 = EarphoneStatus.class;
            Transformations.map(tWSDeviceBuilderForeverUpdate2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderForeverUpdate2.getGetCommand(), tWSDeviceBuilderForeverUpdate2.getNotifyCommand()), new Function1<Message, EarphoneStatus>() { // from class: com.nothing.earbase.home.ConnectViewModel$registerListener$lambda$12$lambda$11$$inlined$getLiveData$3
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final EarphoneStatus invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    EarphoneStatus earphoneStatus = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    earphoneStatus = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls4 = cls3;
                        try {
                            if (Intrinsics.areEqual(cls4, Integer.TYPE)) {
                                obj = (EarphoneStatus) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls4, Long.TYPE)) {
                                obj = (EarphoneStatus) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls4, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.ota.entity.EarphoneStatus");
                                }
                                obj = (EarphoneStatus) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls4, Boolean.TYPE)) {
                                obj = (EarphoneStatus) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls4, Float.TYPE)) {
                                obj = (EarphoneStatus) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls4.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            earphoneStatus = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            earphoneStatus = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls5 = cls3;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls5 + StringUtils.SPACE + earphoneStatus + StringUtils.SPACE;
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    return earphoneStatus;
                }
            }).observe(this.lifecycleOwner, new ConnectViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.home.ConnectViewModel$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConnectViewModel.registerListener$lambda$12$lambda$11$lambda$5(iotDevice, this, (EarphoneStatus) obj);
                }
            }));
            final TWSDeviceBuilder tWSDeviceBuilderRemoteConfiguration = TWSDeviceExtKt.remoteConfiguration(twsDevice);
            final Class<DeviceConfiguration> cls4 = DeviceConfiguration.class;
            Transformations.map(tWSDeviceBuilderRemoteConfiguration.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderRemoteConfiguration.getGetCommand(), tWSDeviceBuilderRemoteConfiguration.getNotifyCommand()), new Function1<Message, DeviceConfiguration>() { // from class: com.nothing.earbase.home.ConnectViewModel$registerListener$lambda$12$lambda$11$$inlined$getLiveData$4
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final DeviceConfiguration invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    DeviceConfiguration deviceConfiguration = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    deviceConfiguration = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls5 = cls4;
                        try {
                            if (Intrinsics.areEqual(cls5, Integer.TYPE)) {
                                obj = (DeviceConfiguration) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls5, Long.TYPE)) {
                                obj = (DeviceConfiguration) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls5, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.DeviceConfiguration");
                                }
                                obj = (DeviceConfiguration) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls5, Boolean.TYPE)) {
                                obj = (DeviceConfiguration) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls5, Float.TYPE)) {
                                obj = (DeviceConfiguration) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls5.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            deviceConfiguration = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            deviceConfiguration = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls6 = cls4;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls6 + StringUtils.SPACE + deviceConfiguration + StringUtils.SPACE;
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    return deviceConfiguration;
                }
            }).observe(this.lifecycleOwner, new ConnectViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.home.ConnectViewModel$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConnectViewModel.registerListener$lambda$12$lambda$11$lambda$6(this.f$0, twsDevice, (DeviceConfiguration) obj);
                }
            }));
            if (!twsDevice.getQueryAudio()) {
                OsRouter osRouter = RouterFactory.INSTANCE.getOsRouter();
                String address = twsDevice.getAddress();
                if (address == null) {
                    address = "";
                }
                twsDevice.setPhoneAudio(osRouter.getSupportAudio(address));
                twsDevice.setQueryAudio(true);
            }
            IOTProductDevice productDevice = getProductDevice();
            if (productDevice != null && productDevice.hasSpatialAudioFunction() && (!NothingOSUtil.INSTANCE.isNothingOS() || !twsDevice.getPhoneAudio())) {
                final TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(twsDevice, null, null, 3, null);
                final Class<BasicBoolean> cls5 = BasicBoolean.class;
                Transformations.distinctUntilChanged(Transformations.map(tWSDeviceBuilderSpatialAudio$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default.getGetCommand(), tWSDeviceBuilderSpatialAudio$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.home.ConnectViewModel$registerListener$lambda$12$lambda$11$$inlined$getLiveData$5
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function1
                    public final BasicBoolean invoke(Message message) {
                        byte[] payload;
                        Object obj;
                        BasicBoolean basicBoolean = 0;
                        Object obj2 = null;
                        objNewInstance = null;
                        Object objNewInstance = null;
                        basicBoolean = 0;
                        if (message != null && (payload = message.getPayload()) != null) {
                            Class cls6 = cls5;
                            try {
                                if (Intrinsics.areEqual(cls6, Integer.TYPE)) {
                                    obj = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                                } else if (Intrinsics.areEqual(cls6, Long.TYPE)) {
                                    obj = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                                } else if (Intrinsics.areEqual(cls6, String.class)) {
                                    Object objDecodeToString = StringsKt.decodeToString(payload);
                                    if (objDecodeToString == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                    }
                                    obj = (BasicBoolean) objDecodeToString;
                                } else if (Intrinsics.areEqual(cls6, Boolean.TYPE)) {
                                    obj = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                                } else if (Intrinsics.areEqual(cls6, Float.TYPE)) {
                                    obj = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                                } else {
                                    try {
                                        objNewInstance = cls6.getConstructor(byte[].class).newInstance(payload);
                                        obj2 = objNewInstance;
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    obj = obj2;
                                }
                                basicBoolean = obj;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                basicBoolean = objNewInstance;
                            }
                        }
                        Logger logger = Logger.INSTANCE;
                        Class cls7 = cls5;
                        Logger logger2 = logger;
                        String tag = logger2.getTAG();
                        int depth = logger2.getDepth();
                        if (logger2.isCanLogger(true)) {
                            String str = "parseLiveData " + cls7 + StringUtils.SPACE + basicBoolean + StringUtils.SPACE;
                            String str2 = str;
                            if (str2 != null && str2.length() != 0) {
                                Pair<String, String> trace = logger2.getTrace(depth);
                                String strComponent1 = trace.component1();
                                String strComponent2 = trace.component2();
                                FileLog fileLog = FileLog.INSTANCE;
                                String str3 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                }
                            }
                        }
                        return basicBoolean;
                    }
                })).observe(this.lifecycleOwner, new ConnectViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.home.ConnectViewModel$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ConnectViewModel.registerListener$lambda$12$lambda$11$lambda$7(this.f$0, iotDevice, (BasicBoolean) obj);
                    }
                }));
            }
            final TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(twsDevice);
            final Class<ControlConfigurationEntity> cls6 = ControlConfigurationEntity.class;
            Transformations.distinctUntilChanged(Transformations.map(tWSDeviceBuilderKeyConfiguration.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderKeyConfiguration.getGetCommand(), tWSDeviceBuilderKeyConfiguration.getNotifyCommand()), new Function1<Message, ControlConfigurationEntity>() { // from class: com.nothing.earbase.home.ConnectViewModel$registerListener$lambda$12$lambda$11$$inlined$getLiveData$6
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final ControlConfigurationEntity invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    ControlConfigurationEntity controlConfigurationEntity = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    controlConfigurationEntity = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls7 = cls6;
                        try {
                            if (Intrinsics.areEqual(cls7, Integer.TYPE)) {
                                obj = (ControlConfigurationEntity) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls7, Long.TYPE)) {
                                obj = (ControlConfigurationEntity) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls7, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.control.entity.ControlConfigurationEntity");
                                }
                                obj = (ControlConfigurationEntity) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls7, Boolean.TYPE)) {
                                obj = (ControlConfigurationEntity) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls7, Float.TYPE)) {
                                obj = (ControlConfigurationEntity) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls7.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            controlConfigurationEntity = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            controlConfigurationEntity = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls8 = cls6;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls8 + StringUtils.SPACE + controlConfigurationEntity + StringUtils.SPACE;
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    return controlConfigurationEntity;
                }
            })).observe(this.lifecycleOwner, new ConnectViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.home.ConnectViewModel$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ConnectViewModel.registerListener$lambda$12$lambda$11$lambda$10(iotDevice, twsDevice, (ControlConfigurationEntity) obj);
                }
            }));
            twsDevice.unregister(this.magicButtonCallback);
            twsDevice.register(this.magicButtonCallback);
        }
        initDeviceFeatureMsg(iotDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListener$lambda$12$lambda$11$lambda$2(IOTDevice iOTDevice, Function0 function0, TWSDevice tWSDevice, ConnectViewModel connectViewModel, Message message) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ConnectViewModel firmwareVersion update anc status " + IOTDevice.isSupportAnc$default(iOTDevice, null, 1, null);
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
        connectViewModel.hasANC.set(Boolean.valueOf(IOTDevice.isSupportAnc$default(iOTDevice, null, 1, null)));
        if (iOTDevice.getFirmwareVersion().length() == 0) {
            return Unit.INSTANCE;
        }
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListener$lambda$12$lambda$11$lambda$3(ConnectViewModel connectViewModel, DeviceNoiseReduction deviceNoiseReduction) {
        connectViewModel.updateNoiseImage(deviceNoiseReduction);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListener$lambda$12$lambda$11$lambda$4(ConnectViewModel connectViewModel, IOTDevice iOTDevice, DeviceBattery deviceBattery) {
        connectViewModel.updateBattery(deviceBattery, iOTDevice);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListener$lambda$12$lambda$11$lambda$5(IOTDevice iOTDevice, ConnectViewModel connectViewModel, EarphoneStatus earphoneStatus) {
        if (iOTDevice.isSupportEarConnectState()) {
            connectViewModel.updateEarConnectStatus(earphoneStatus);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListener$lambda$12$lambda$11$lambda$6(ConnectViewModel connectViewModel, TWSDevice tWSDevice, DeviceConfiguration deviceConfiguration) {
        connectViewModel.updateSNNumber(deviceConfiguration, tWSDevice);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListener$lambda$12$lambda$11$lambda$7(ConnectViewModel connectViewModel, IOTDevice iOTDevice, BasicBoolean basicBoolean) {
        connectViewModel.spatialSwitch.postValue(Boolean.valueOf(basicBoolean != null && basicBoolean.getOpen()));
        if (iOTDevice.hasHeadTrack()) {
            connectViewModel.head.postValue(Boolean.valueOf(basicBoolean != null && basicBoolean.getHead()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit registerListener$lambda$12$lambda$11$lambda$10(IOTDevice iOTDevice, TWSDevice tWSDevice, ControlConfigurationEntity controlConfigurationEntity) {
        if (controlConfigurationEntity == null) {
            return Unit.INSTANCE;
        }
        boolean z = false;
        for (ControlConfigurationEntity.Operation operation : controlConfigurationEntity.getOperations()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "service_run keyConfiguration".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "service_run keyConfiguration " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "service_run keyConfiguration " + strComponent2);
                }
            }
            if (operation.getOperation() == 31 && NothingOSUtil.INSTANCE.isNothingOS()) {
                NewsMedia3Manager.INSTANCE.addSupportDevice(iOTDevice.getMacAddress());
                z = true;
            }
        }
        if (!z && NothingOSUtil.INSTANCE.isNothingOS()) {
            NewsMedia3Manager.INSTANCE.removeSupportDevice(iOTDevice.getMacAddress());
        }
        return Unit.INSTANCE;
    }

    private final void initDeviceFeatureMsg(IOTDevice iOTDevice) {
        TWSDevice twsDevice;
        this.hasANC.set(Boolean.valueOf(IOTDevice.isSupportAnc$default(iOTDevice, null, 1, null)));
        ObservableField<Boolean> observableField = this.hasBassBoot;
        IOTProductDevice productDevice = getProductDevice();
        observableField.set(productDevice != null ? Boolean.valueOf(productDevice.hasBassBoostFunction()) : null);
        TWSDevice twsDevice2 = iOTDevice.getTwsDevice();
        if (twsDevice2 != null && !twsDevice2.getQueryAudio()) {
            TWSDevice twsDevice3 = iOTDevice.getTwsDevice();
            if (twsDevice3 != null) {
                OsRouter osRouter = RouterFactory.INSTANCE.getOsRouter();
                String macAddress = iOTDevice.getMacAddress();
                if (macAddress == null) {
                    macAddress = "";
                }
                twsDevice3.setPhoneAudio(osRouter.getSupportAudio(macAddress));
            }
            TWSDevice twsDevice4 = iOTDevice.getTwsDevice();
            if (twsDevice4 != null) {
                twsDevice4.setQueryAudio(true);
            }
        }
        ObservableField<Boolean> observableField2 = this.hasSpatialAudio;
        IOTProductDevice productDevice2 = getProductDevice();
        observableField2.set(Boolean.valueOf((productDevice2 == null || !productDevice2.hasSpatialAudioFunction() || (NothingOSUtil.INSTANCE.isNothingOS() && ((twsDevice = iOTDevice.getTwsDevice()) == null || twsDevice.getPhoneAudio()))) ? false : true));
        this.spatialVisible.set(true);
        if (Intrinsics.areEqual((Object) this.hasSpatialAudio.get(), (Object) false)) {
            this.spatialSwitch.postValue(false);
        }
    }

    private final void updateNoiseImage(DeviceNoiseReduction noiseReduction) {
        DeviceNoiseItem noiseReductionMode;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ConnectViewModel updateNoiseImage " + noiseReduction + StringUtils.SPACE;
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
        if (noiseReduction == null || (noiseReductionMode = noiseReduction.getNoiseReductionMode()) == null) {
            return;
        }
        int value = noiseReductionMode.getValue();
        if (value != 0) {
            if (value == 1) {
                this.noiseImage.set(Integer.valueOf(R.drawable.ic_noise_on_normal));
                return;
            }
            if (value == 2) {
                this.noiseImage.set(Integer.valueOf(R.drawable.ic_noise_on_normal));
                return;
            }
            if (value == 3) {
                this.noiseImage.set(Integer.valueOf(R.drawable.ic_noise_on_normal));
                return;
            }
            if (value == 4) {
                this.noiseImage.set(Integer.valueOf(R.drawable.ic_noise_on_normal));
                return;
            } else if (value != 5) {
                if (value == 7 || value == 254) {
                    this.noiseImage.set(Integer.valueOf(R.drawable.ic_noise_trans_normal));
                    return;
                }
                return;
            }
        }
        this.noiseImage.set(Integer.valueOf(R.drawable.ic_noise_off_normal));
    }

    private final void updateBattery(DeviceBattery battery, IOTDevice iotDevice) {
        Battery right;
        Battery left;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ConnectViewModel updateBattery battery " + battery + StringUtils.SPACE;
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
        MutableLiveData<DeviceBattery> mutableLiveData = this.mBattery;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(battery);
        }
        if (iotDevice.isSupportEarConnectState()) {
            return;
        }
        this.leftConnect.set(Boolean.valueOf(((battery == null || (left = battery.getLeft()) == null) ? 0 : left.getBattery()) > 0));
        this.rightConnect.set(Boolean.valueOf(((battery == null || (right = battery.getRight()) == null) ? 0 : right.getBattery()) > 0));
    }

    /* JADX WARN: Code duplicated, block: B:27:0x00dd  */
    public final void updateEarConnectStatus(EarphoneStatus status) {
        boolean zIsConnect;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ConnectViewModel updateEarConnectStatus " + status;
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
        if (status == null) {
            this.leftConnect.set(false);
            this.rightConnect.set(false);
            return;
        }
        IOTProductDevice productDevice = getProductDevice();
        if (productDevice != null && productDevice.getType() == 6) {
            EarphoneStatus.Status stereo = status.getStereo();
            if (stereo != null) {
                zIsConnect = stereo.isConnect();
            } else {
                zIsConnect = false;
            }
        } else {
            EarphoneStatus.Status right = status.getRight();
            if (right != null) {
                zIsConnect = right.isConnect();
            } else {
                zIsConnect = false;
            }
        }
        ObservableField<Boolean> observableField = this.leftConnect;
        EarphoneStatus.Status left = status.getLeft();
        observableField.set(Boolean.valueOf(left != null ? left.isConnect() : false));
        this.rightConnect.set(Boolean.valueOf(zIsConnect));
    }

    private final void updateSNNumber(DeviceConfiguration configuration, TWSDevice twsDevice) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ConnectViewModel updateSNNumber remoteConfiguration " + configuration + StringUtils.SPACE;
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
        twsDevice.setSn(configuration != null ? configuration.getSerialNumber() : null);
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0101  */
    /* JADX WARN: Code duplicated, block: B:42:0x0116  */
    /* JADX WARN: Code duplicated, block: B:45:0x0120  */
    /* JADX WARN: Code duplicated, block: B:47:0x012d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0132  */
    /* JADX WARN: Code duplicated, block: B:61:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:71:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    public final Object setSpatialAudio(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        TWSDevice twsDevice;
        boolean z;
        int i;
        int i2;
        TWSDeviceBuilder tWSDeviceBuilder;
        boolean z2;
        int i3;
        ConnectViewModel connectViewModel;
        int i4;
        TWSDeviceBuilder tWSDeviceBuilder2;
        Message message;
        byte[] bArrObtainDataPacket;
        Message message2;
        Message message3;
        byte[] bArrObtainDataPacket$default;
        Message message4;
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
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = anonymousClass2.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Boolean value = this.spatialSwitch.getValue();
            boolean z3 = !(value != null ? value.booleanValue() : false);
            IOTDevice iOTDevice = getIOTDevice();
            if (iOTDevice != null && (twsDevice = iOTDevice.getTwsDevice()) != null) {
                IOTDevice iOTDevice2 = getIOTDevice();
                if (iOTDevice2 != null && iOTDevice2.hasHeadTrack()) {
                    TWSDeviceBuilder tWSDeviceBuilderSpatialAudio = TWSDeviceExtKt.spatialAudio(twsDevice, Boxing.boxBoolean(z3), this.head.getValue());
                    int setCommand = tWSDeviceBuilderSpatialAudio.getSetCommand();
                    TWSDevice twsDevice2 = tWSDeviceBuilderSpatialAudio.getTwsDevice();
                    byte[] setPayload = tWSDeviceBuilderSpatialAudio.getSetPayload();
                    Long timeOut = tWSDeviceBuilderSpatialAudio.getTimeOut();
                    boolean isNeedFsn = tWSDeviceBuilderSpatialAudio.getIsNeedFsn();
                    byte[] mockResponse = tWSDeviceBuilderSpatialAudio.getMockResponse();
                    anonymousClass2.L$0 = this;
                    anonymousClass2.L$1 = twsDevice;
                    anonymousClass2.L$2 = tWSDeviceBuilderSpatialAudio;
                    anonymousClass2.I$0 = z3 ? 1 : 0;
                    anonymousClass2.I$1 = 1;
                    anonymousClass2.label = 1;
                    z2 = true;
                    Object objSyncSetResponse$default = TWSDevice.syncSetResponse$default(twsDevice2, setCommand, setPayload, timeOut, isNeedFsn, false, mockResponse, anonymousClass2, 16, null);
                    if (objSyncSetResponse$default != coroutine_suspended) {
                        i3 = z3 ? 1 : 0;
                        obj = objSyncSetResponse$default;
                        connectViewModel = this;
                        i4 = 1;
                        tWSDeviceBuilder2 = tWSDeviceBuilderSpatialAudio;
                        message = (Message) obj;
                        if (message != null) {
                            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder2.getTwsDevice().getCommandCache(), tWSDeviceBuilder2.getGetCommand(), 0, 2, null);
                            BasicBoolean.Companion companion = BasicBoolean.INSTANCE;
                            if (i3 == 0) {
                                z2 = false;
                            }
                            bArrObtainDataPacket = companion.obtainDataPacket(z2, connectViewModel.head.getValue());
                            message2 = (Message) liveDataCommand$default.getValue();
                            if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                                tWSDeviceBuilder2.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder2.getGetCommand(), bArrObtainDataPacket);
                                if (message2 != null) {
                                    message2.setPayload(bArrObtainDataPacket);
                                    if (i4 != 0) {
                                        tWSDeviceBuilder2.getTwsDevice().onUpdate(tWSDeviceBuilder2.getGetCommand(), message2);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    z = true;
                    TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(twsDevice, Boxing.boxBoolean(z3), null, 2, null);
                    int setCommand2 = tWSDeviceBuilderSpatialAudio$default.getSetCommand();
                    TWSDevice twsDevice3 = tWSDeviceBuilderSpatialAudio$default.getTwsDevice();
                    byte[] setPayload2 = tWSDeviceBuilderSpatialAudio$default.getSetPayload();
                    Long timeOut2 = tWSDeviceBuilderSpatialAudio$default.getTimeOut();
                    boolean isNeedFsn2 = tWSDeviceBuilderSpatialAudio$default.getIsNeedFsn();
                    byte[] mockResponse2 = tWSDeviceBuilderSpatialAudio$default.getMockResponse();
                    anonymousClass2.L$0 = twsDevice;
                    anonymousClass2.L$1 = tWSDeviceBuilderSpatialAudio$default;
                    anonymousClass2.I$0 = z3 ? 1 : 0;
                    anonymousClass2.I$1 = 1;
                    anonymousClass2.label = 2;
                    Object objSyncSetResponse$default2 = TWSDevice.syncSetResponse$default(twsDevice3, setCommand2, setPayload2, timeOut2, isNeedFsn2, false, mockResponse2, anonymousClass2, 16, null);
                    if (objSyncSetResponse$default2 != coroutine_suspended) {
                        i = z3 ? 1 : 0;
                        obj = objSyncSetResponse$default2;
                        i2 = 1;
                        tWSDeviceBuilder = tWSDeviceBuilderSpatialAudio$default;
                        message3 = (Message) obj;
                        if (message3 != null) {
                            LiveData liveDataCommand$default2 = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                            BasicBoolean.Companion companion2 = BasicBoolean.INSTANCE;
                            if (i == 0) {
                                z = false;
                            }
                            bArrObtainDataPacket$default = BasicBoolean.Companion.obtainDataPacket$default(companion2, z, null, 2, null);
                            message4 = (Message) liveDataCommand$default2.getValue();
                            if (!Arrays.equals(message4 != null ? message4.getPayload() : null, bArrObtainDataPacket$default)) {
                                tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrObtainDataPacket$default);
                                if (message4 != null) {
                                    message4.setPayload(bArrObtainDataPacket$default);
                                    if (i2 != 0) {
                                        tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message4);
                                    }
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            }
        } else if (i5 == 1) {
            int i6 = anonymousClass2.I$1;
            i3 = anonymousClass2.I$0;
            tWSDeviceBuilder2 = (TWSDeviceBuilder) anonymousClass2.L$2;
            connectViewModel = (ConnectViewModel) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            z2 = true;
            i4 = i6;
            message = (Message) obj;
            if (message != null && message.isOk() == z2) {
                LiveData liveDataCommand$default3 = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder2.getTwsDevice().getCommandCache(), tWSDeviceBuilder2.getGetCommand(), 0, 2, null);
                BasicBoolean.Companion companion3 = BasicBoolean.INSTANCE;
                if (i3 == 0) {
                    z2 = false;
                }
                bArrObtainDataPacket = companion3.obtainDataPacket(z2, connectViewModel.head.getValue());
                message2 = (Message) liveDataCommand$default3.getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                    tWSDeviceBuilder2.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder2.getGetCommand(), bArrObtainDataPacket);
                    if (message2 != null) {
                        message2.setPayload(bArrObtainDataPacket);
                        if (i4 != 0) {
                            tWSDeviceBuilder2.getTwsDevice().onUpdate(tWSDeviceBuilder2.getGetCommand(), message2);
                        }
                    }
                }
            }
        } else {
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i7 = anonymousClass2.I$1;
            i = anonymousClass2.I$0;
            tWSDeviceBuilder = (TWSDeviceBuilder) anonymousClass2.L$1;
            ResultKt.throwOnFailure(obj);
            z = true;
            i2 = i7;
            message3 = (Message) obj;
            if (message3 != null && message3.isOk() == z) {
                LiveData liveDataCommand$default4 = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                BasicBoolean.Companion companion4 = BasicBoolean.INSTANCE;
                if (i == 0) {
                    z = false;
                }
                bArrObtainDataPacket$default = BasicBoolean.Companion.obtainDataPacket$default(companion4, z, null, 2, null);
                message4 = (Message) liveDataCommand$default4.getValue();
                if (!Arrays.equals(message4 != null ? message4.getPayload() : null, bArrObtainDataPacket$default)) {
                    tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrObtainDataPacket$default);
                    if (message4 != null) {
                        message4.setPayload(bArrObtainDataPacket$default);
                        if (i2 != 0) {
                            tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message4);
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    public final void getNoiseModel() {
        TWSDevice twsDevice;
        IOTDevice iOTDevice = getIOTDevice();
        if (iOTDevice == null || (twsDevice = iOTDevice.getTwsDevice()) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.noiseReduction$default(twsDevice, null, 1, null), false, (byte[]) null, 0, 7, (Object) null);
    }

    public final void resetDeviceMsg() {
        IOTDevice iOTDevice = getIOTDevice();
        if (iOTDevice != null) {
            updateBattery(null, iOTDevice);
            updateEarConnectStatus(null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0051  */
    public final boolean isNeedShowSpatialTips() {
        IOTDevice iOTDevice;
        TWSDevice twsDevice;
        if (!Intrinsics.areEqual((Object) this.hasSpatialAudio.get(), (Object) true) || (iOTDevice = getIOTDevice()) == null || (twsDevice = iOTDevice.getTwsDevice()) == null) {
            return false;
        }
        DeviceItemDao deviceDao = DatabaseUtils.INSTANCE.getDeviceDao();
        String address = twsDevice.getAddress();
        if (address == null) {
            address = "";
        }
        List<DeviceItem> deviceItem = deviceDao.getDeviceItem(address);
        DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ConnectViewModel isShowTips :" + (deviceItem2 != null ? Boolean.valueOf(deviceItem2.getHomeTips()) : null);
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
        return !(deviceItem2 != null ? deviceItem2.getHomeTips() : false);
    }

    public final void updateShowSpatialPop() {
        IOTDevice iOTDevice;
        TWSDevice twsDevice;
        if (!Intrinsics.areEqual((Object) this.hasSpatialAudio.get(), (Object) true) || (iOTDevice = getIOTDevice()) == null || (twsDevice = iOTDevice.getTwsDevice()) == null) {
            return;
        }
        DeviceItemDao deviceDao = DatabaseUtils.INSTANCE.getDeviceDao();
        String address = twsDevice.getAddress();
        if (address == null) {
            address = "";
        }
        List<DeviceItem> deviceItem = deviceDao.getDeviceItem(address);
        DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
        if (deviceItem2 != null) {
            deviceItem2.setHomeTips(true);
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ConnectViewModel  updateShowTips:" + (deviceItem2 != null ? Boolean.valueOf(deviceItem2.getHomeTips()) : null);
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
        if (deviceItem2 != null) {
            DatabaseUtils.INSTANCE.getDeviceDao().updateDeviceItem(deviceItem2);
        }
    }

    private final IOTProductDevice getProductDevice() {
        return IOTDeviceManager.INSTANCE.getProductByModelId(SpUtils.INSTANCE.getCurrentModel());
    }

    private final IOTDevice getIOTDevice() {
        return IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(SpUtils.INSTANCE.getSelectDeviceMac());
    }
}
