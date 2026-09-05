package com.nothing.elekid.detail;

import android.app.Application;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.BasicBoolean;
import com.nothing.base.protocol.entity.DeviceANCSwitch;
import com.nothing.base.protocol.entity.DeviceConfiguration;
import com.nothing.base.protocol.entity.DeviceExtraFeatureStatus;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.util.ext.ViewModelExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.dao.DeviceItemDao;
import com.nothing.database.entity.DeviceItem;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.database.util.SpUtils;
import com.nothing.device.BaseAndroidLifecycleViewModel;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.ear.R;
import com.nothing.earbase.core.api.EarDeviceRepo;
import com.nothing.earbase.guide.AnimalBaseGuideActivity;
import com.nothing.earbase.ota.entity.ServerFirmware;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.elekid.core.protocol.ElekidSppProtocol;
import com.nothing.elekid.core.protocol.device.ElekidManager;
import com.nothing.log.FileLog;
import com.nothing.log.NTLog;
import com.nothing.network.core.ApiResponseKt;
import com.nothing.network.core.ApiResult;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import com.tekartik.sqflite.Constant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EarDetailViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u0085\u00012\u00020\u00012\u00020\u0002:\u0002\u0085\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010c\u001a\u00020dH\u0002J\b\u0010e\u001a\u00020dH\u0002J\b\u0010f\u001a\u00020dH\u0002J\b\u0010g\u001a\u00020dH\u0002J\u000e\u0010h\u001a\u00020d2\u0006\u0010i\u001a\u00020\tJ\u000e\u0010j\u001a\u00020d2\u0006\u0010i\u001a\u00020\tJ\b\u0010k\u001a\u00020dH\u0002J\u000e\u0010l\u001a\u00020d2\u0006\u0010i\u001a\u00020\tJ\b\u0010m\u001a\u00020dH\u0002J\u0012\u0010n\u001a\u00020d2\b\b\u0002\u0010o\u001a\u00020\tH\u0002J\u0006\u0010p\u001a\u00020dJ\b\u0010q\u001a\u00020\tH\u0016J\b\u0010r\u001a\u00020dH\u0016J\b\u0010s\u001a\u00020dH\u0002J\b\u0010t\u001a\u00020dH\u0016J\u001a\u0010u\u001a\u00020d2\u0006\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010y\u001a\u00020d2\u0006\u0010z\u001a\u00020w2\u0006\u0010{\u001a\u00020|H\u0016J\u000e\u0010}\u001a\u00020d2\u0006\u0010~\u001a\u00020\tJ\u000e\u0010\u007f\u001a\u00020d2\u0006\u0010~\u001a\u00020\tJ\u000f\u0010\u0080\u0001\u001a\u00020d2\u0006\u0010~\u001a\u00020\tJ\u0007\u0010\u0081\u0001\u001a\u00020dJ\u0007\u0010\u0082\u0001\u001a\u00020dJ\u0007\u0010\u0083\u0001\u001a\u00020dJ\t\u0010\u0084\u0001\u001a\u00020dH\u0016R(\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0015\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001f\u0010\u0019\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u001a0\u001a0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u001a0\u001a0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u001f\u0010\u001e\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u001a0\u001a0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u001f\u0010 \u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012R(\u0010\"\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\f\"\u0004\b$\u0010\u000eR\u001f\u0010%\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0012R\u001f\u0010'\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u001a0\u001a0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0012R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R(\u0010/\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R(\u00102\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u0010\u0014R(\u00105\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0012\"\u0004\b7\u0010\u0014R\u001f\u00108\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\fR\u001f\u0010:\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0012R\u001f\u0010;\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0012R(\u0010=\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0012\"\u0004\b?\u0010\u0014R\u001a\u0010@\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010B\"\u0004\bF\u0010DR\u001c\u0010G\u001a\u0004\u0018\u00010HX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001f\u0010M\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010\fR(\u0010O\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0012\"\u0004\bQ\u0010\u0014R\u0018\u0010R\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010T\u0018\u00010SX\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010U\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0012\"\u0004\bW\u0010\u0014R\u0018\u0010X\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010T\u0018\u00010SX\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010Y\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0012\"\u0004\b[\u0010\u0014R\u0018\u0010\\\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010T\u0018\u00010SX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010]\u001a\u00020^8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\ba\u0010b\u001a\u0004\b_\u0010`\u00a8\u0006\u0086\u0001"}, d2 = {"Lcom/nothing/elekid/detail/EarDetailViewModel;", "Lcom/nothing/device/BaseAndroidLifecycleViewModel;", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "logLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getLogLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setLogLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "lowModelChecked", "Landroidx/databinding/ObservableField;", "getLowModelChecked", "()Landroidx/databinding/ObservableField;", "setLowModelChecked", "(Landroidx/databinding/ObservableField;)V", "inEarChecked", "getInEarChecked", "setInEarChecked", "hasNewFirmware", "firmwareVersionStr", "", "getFirmwareVersionStr", "deviceName", "getDeviceName", "deviceMac", "getDeviceMac", "connected", "getConnected", "connectedLiveData", "getConnectedLiveData", "setConnectedLiveData", Constant.METHOD_DEBUG, "getDebug", "deviceSerial", "getDeviceSerial", "featureStatus", "Lcom/nothing/base/protocol/entity/DeviceExtraFeatureStatus;", "getFeatureStatus", "()Lcom/nothing/base/protocol/entity/DeviceExtraFeatureStatus;", "setFeatureStatus", "(Lcom/nothing/base/protocol/entity/DeviceExtraFeatureStatus;)V", "hasUpdate", "getHasUpdate", "setHasUpdate", "personalised", "getPersonalised", "setPersonalised", "ancTest", "getAncTest", "setAncTest", "loadAnimal", "getLoadAnimal", "isHasSerial", "hasSupport", "getHasSupport", "ldacModelChecked", "getLdacModelChecked", "setLdacModelChecked", "setLDACValue", "getSetLDACValue", "()Z", "setSetLDACValue", "(Z)V", "isClickLDAC", "setClickLDAC", "jobSetLDAC", "Lkotlinx/coroutines/Job;", "getJobSetLDAC", "()Lkotlinx/coroutines/Job;", "setJobSetLDAC", "(Lkotlinx/coroutines/Job;)V", "lhdcFailed", "getLhdcFailed", "smartAncChecked", "getSmartAncChecked", "setSmartAncChecked", "smartAncSwitchLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/base/protocol/entity/BasicBoolean;", "smartFreeChecked", "getSmartFreeChecked", "setSmartFreeChecked", "smartFreeSwitchLiveData", "headTrackChecked", "getHeadTrackChecked", "setHeadTrackChecked", "headTrackLiveData", "protocol", "Lcom/nothing/elekid/core/protocol/ElekidSppProtocol;", "getProtocol", "()Lcom/nothing/elekid/core/protocol/ElekidSppProtocol;", "protocol$delegate", "Lkotlin/Lazy;", "updateConnectedLiveData", "", "getLDACStatus", "getSmartAncModel", "getHeadTrackModel", "setSmartAncModel", "state", "setHeadTrackModel", "getSmartFreeModel", "setSmartFreeModel", "updateVersion", "setFirmwareTips", "hasTips", "getConfigInfo", "isIOThread", "onConnected", "cancelJob", "onDisconnected", "onError", "code", "", "message", "onUpdate", "cmdType", "data", "Lcom/nothing/protocol/model/Message;", "setLowModel", TypedValues.Custom.S_BOOLEAN, "setLDACStatus", "setInEarModel", "requestHttp", DeviceEarImage.DISCONNECT_EAR_IMAGE, "forget", "onCleared", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarDetailViewModel extends BaseAndroidLifecycleViewModel implements TWSDevice.Callback {
    public static final float BOTTOM_MARGIN = 26.0f;
    public static final long CONNECT_DELAY = 40000;
    public static final long FRESH_UI_DELAY = 10;
    public static final float MARGIN_TOP_DEFAULT = 12.0f;
    private ObservableField<Boolean> ancTest;
    private final ObservableField<Boolean> connected;
    private MutableLiveData<Boolean> connectedLiveData;
    private final ObservableField<Boolean> debug;
    private final ObservableField<String> deviceMac;
    private final ObservableField<String> deviceName;
    private final ObservableField<String> deviceSerial;
    private DeviceExtraFeatureStatus featureStatus;
    private final ObservableField<String> firmwareVersionStr;
    private final ObservableField<Boolean> hasNewFirmware;
    private final ObservableField<Boolean> hasSupport;
    private ObservableField<Boolean> hasUpdate;
    private ObservableField<Boolean> headTrackChecked;
    private LiveData<BasicBoolean> headTrackLiveData;
    private ObservableField<Boolean> inEarChecked;
    private boolean isClickLDAC;
    private final ObservableField<Boolean> isHasSerial;
    private Job jobSetLDAC;
    private ObservableField<Boolean> ldacModelChecked;
    private final MutableLiveData<Boolean> lhdcFailed;
    private final MutableLiveData<Boolean> loadAnimal;
    private MutableLiveData<Boolean> logLiveData;
    private ObservableField<Boolean> lowModelChecked;
    private ObservableField<Boolean> personalised;

    /* JADX INFO: renamed from: protocol$delegate, reason: from kotlin metadata */
    private final Lazy protocol;
    private boolean setLDACValue;
    private ObservableField<Boolean> smartAncChecked;
    private LiveData<BasicBoolean> smartAncSwitchLiveData;
    private ObservableField<Boolean> smartFreeChecked;
    private LiveData<BasicBoolean> smartFreeSwitchLiveData;

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public boolean isIOThread() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarDetailViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.logLiveData = new MutableLiveData<>(false);
        this.lowModelChecked = new ObservableField<>(false);
        this.inEarChecked = new ObservableField<>(false);
        this.hasNewFirmware = new ObservableField<>(false);
        this.firmwareVersionStr = new ObservableField<>("");
        this.deviceName = new ObservableField<>("");
        String upperCase = SpUtils.INSTANCE.getSelectDeviceMac().toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        ObservableField<String> observableField = new ObservableField<>(upperCase);
        this.deviceMac = observableField;
        ObservableField<Boolean> observableField2 = new ObservableField<>(true);
        this.connected = observableField2;
        this.connectedLiveData = new MutableLiveData<>(false);
        ObservableField<Boolean> observableField3 = new ObservableField<>(true);
        this.debug = observableField3;
        ObservableField<String> observableField4 = new ObservableField<>("");
        this.deviceSerial = observableField4;
        this.hasUpdate = new ObservableField<>(false);
        this.personalised = new ObservableField<>(false);
        this.ancTest = new ObservableField<>(false);
        this.loadAnimal = new MutableLiveData<>(false);
        this.isHasSerial = new ObservableField<>(true);
        this.hasSupport = new ObservableField<>(Boolean.valueOf(RouterFactory.INSTANCE.getGlobalRouter().hasSupport()));
        this.ldacModelChecked = new ObservableField<>(false);
        this.lhdcFailed = new MutableLiveData<>(false);
        this.smartAncChecked = new ObservableField<>(false);
        this.smartFreeChecked = new ObservableField<>(false);
        this.headTrackChecked = new ObservableField<>(false);
        this.protocol = LazyKt.lazy(new Function0() { // from class: com.nothing.elekid.detail.EarDetailViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarDetailViewModel.protocol_delegate$lambda$0();
            }
        });
        observableField3.set(Boolean.valueOf(NothingOSUtil.INSTANCE.isNotGooglePlay()));
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null) {
            tWSDevice.register(this);
        }
        getProtocol().syncUtcTime();
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(SpUtils.INSTANCE.getSelectDeviceMac());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new EarDetailViewModel$1$1(this, iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null, null), 2, null);
        getProtocol().getConfiguration();
        updateVersion();
        setFirmwareTips$default(this, false, 1, null);
        getLDACStatus();
        if (Intrinsics.areEqual((Object) observableField2.get(), (Object) true)) {
            return;
        }
        DeviceItemDao deviceDao = DatabaseUtils.INSTANCE.getDeviceDao();
        String str = observableField.get();
        List<DeviceItem> deviceItem = deviceDao.getDeviceItem(str == null ? "" : str);
        DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
        if (deviceItem2 != null) {
            String sn = deviceItem2.getSn();
            observableField4.set(sn != null ? sn : "");
        }
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void getBesVersionSuccess() {
        TWSDevice.Callback.DefaultImpls.getBesVersionSuccess(this);
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

    public final MutableLiveData<Boolean> getLogLiveData() {
        return this.logLiveData;
    }

    public final void setLogLiveData(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.logLiveData = mutableLiveData;
    }

    public final ObservableField<Boolean> getLowModelChecked() {
        return this.lowModelChecked;
    }

    public final void setLowModelChecked(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.lowModelChecked = observableField;
    }

    public final ObservableField<Boolean> getInEarChecked() {
        return this.inEarChecked;
    }

    public final void setInEarChecked(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.inEarChecked = observableField;
    }

    public final ObservableField<String> getFirmwareVersionStr() {
        return this.firmwareVersionStr;
    }

    public final ObservableField<String> getDeviceName() {
        return this.deviceName;
    }

    public final ObservableField<String> getDeviceMac() {
        return this.deviceMac;
    }

    public final ObservableField<Boolean> getConnected() {
        return this.connected;
    }

    public final MutableLiveData<Boolean> getConnectedLiveData() {
        return this.connectedLiveData;
    }

    public final void setConnectedLiveData(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.connectedLiveData = mutableLiveData;
    }

    public final ObservableField<Boolean> getDebug() {
        return this.debug;
    }

    public final ObservableField<String> getDeviceSerial() {
        return this.deviceSerial;
    }

    public final DeviceExtraFeatureStatus getFeatureStatus() {
        return this.featureStatus;
    }

    public final void setFeatureStatus(DeviceExtraFeatureStatus deviceExtraFeatureStatus) {
        this.featureStatus = deviceExtraFeatureStatus;
    }

    public final ObservableField<Boolean> getHasUpdate() {
        return this.hasUpdate;
    }

    public final void setHasUpdate(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.hasUpdate = observableField;
    }

    public final ObservableField<Boolean> getPersonalised() {
        return this.personalised;
    }

    public final void setPersonalised(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.personalised = observableField;
    }

    public final ObservableField<Boolean> getAncTest() {
        return this.ancTest;
    }

    public final void setAncTest(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.ancTest = observableField;
    }

    public final MutableLiveData<Boolean> getLoadAnimal() {
        return this.loadAnimal;
    }

    public final ObservableField<Boolean> isHasSerial() {
        return this.isHasSerial;
    }

    public final ObservableField<Boolean> getHasSupport() {
        return this.hasSupport;
    }

    public final ObservableField<Boolean> getLdacModelChecked() {
        return this.ldacModelChecked;
    }

    public final void setLdacModelChecked(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.ldacModelChecked = observableField;
    }

    public final boolean getSetLDACValue() {
        return this.setLDACValue;
    }

    public final void setSetLDACValue(boolean z) {
        this.setLDACValue = z;
    }

    /* JADX INFO: renamed from: isClickLDAC, reason: from getter */
    public final boolean getIsClickLDAC() {
        return this.isClickLDAC;
    }

    public final void setClickLDAC(boolean z) {
        this.isClickLDAC = z;
    }

    public final Job getJobSetLDAC() {
        return this.jobSetLDAC;
    }

    public final void setJobSetLDAC(Job job) {
        this.jobSetLDAC = job;
    }

    public final MutableLiveData<Boolean> getLhdcFailed() {
        return this.lhdcFailed;
    }

    public final ObservableField<Boolean> getSmartAncChecked() {
        return this.smartAncChecked;
    }

    public final void setSmartAncChecked(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.smartAncChecked = observableField;
    }

    public final ObservableField<Boolean> getSmartFreeChecked() {
        return this.smartFreeChecked;
    }

    public final void setSmartFreeChecked(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.smartFreeChecked = observableField;
    }

    public final ObservableField<Boolean> getHeadTrackChecked() {
        return this.headTrackChecked;
    }

    public final void setHeadTrackChecked(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.headTrackChecked = observableField;
    }

    public final ElekidSppProtocol getProtocol() {
        return (ElekidSppProtocol) this.protocol.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ElekidSppProtocol protocol_delegate$lambda$0() {
        return new ElekidSppProtocol(null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateConnectedLiveData() {
        this.connectedLiveData.postValue(this.connected.get());
    }

    private final void getLDACStatus() {
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null) {
            TWSDevice.sendCommands$default(tWSDevice, new int[]{ProtocolConstant.Query.GET_LHDC_COMMANDS}, false, false, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getSmartAncModel() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            LiveData<BasicBoolean> liveData = this.smartAncSwitchLiveData;
            if (liveData != null) {
                liveData.removeObservers(this);
            }
            final TWSDeviceBuilder tWSDeviceBuilderSmartAnc$default = TWSDeviceExtKt.smartAnc$default(tWSDevice, null, 1, null);
            final Class<BasicBoolean> cls = BasicBoolean.class;
            LiveData<BasicBoolean> map = Transformations.map(tWSDeviceBuilderSmartAnc$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSmartAnc$default.getGetCommand(), tWSDeviceBuilderSmartAnc$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.elekid.detail.EarDetailViewModel$getSmartAncModel$lambda$3$$inlined$getLiveData$1
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
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                }
                                obj = (BasicBoolean) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
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
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + basicBoolean + StringUtils.SPACE;
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
            });
            this.smartAncSwitchLiveData = map;
            if (map != null) {
                map.observe(this, new EarDetailViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.detail.EarDetailViewModel$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EarDetailViewModel.getSmartAncModel$lambda$3$lambda$2(this.f$0, (BasicBoolean) obj);
                    }
                }));
            }
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.smartAnc$default(tWSDevice, null, 1, null), false, (byte[]) null, 0, 7, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSmartAncModel$lambda$3$lambda$2(EarDetailViewModel earDetailViewModel, BasicBoolean basicBoolean) {
        earDetailViewModel.smartAncChecked.set(basicBoolean != null ? Boolean.valueOf(basicBoolean.getOpen()) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getHeadTrackModel() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            LiveData<BasicBoolean> liveData = this.headTrackLiveData;
            if (liveData != null) {
                liveData.removeObservers(this);
            }
            final TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(tWSDevice, null, null, 3, null);
            final Class<BasicBoolean> cls = BasicBoolean.class;
            LiveData<BasicBoolean> map = Transformations.map(tWSDeviceBuilderSpatialAudio$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default.getGetCommand(), tWSDeviceBuilderSpatialAudio$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.elekid.detail.EarDetailViewModel$getHeadTrackModel$lambda$5$$inlined$getLiveData$1
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
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                }
                                obj = (BasicBoolean) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
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
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + basicBoolean + StringUtils.SPACE;
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
            });
            this.headTrackLiveData = map;
            if (map != null) {
                map.observe(this, new EarDetailViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.detail.EarDetailViewModel$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EarDetailViewModel.getHeadTrackModel$lambda$5$lambda$4(this.f$0, (BasicBoolean) obj);
                    }
                }));
            }
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.spatialAudio$default(tWSDevice, null, null, 3, null), false, (byte[]) null, 0, 7, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getHeadTrackModel$lambda$5$lambda$4(EarDetailViewModel earDetailViewModel, BasicBoolean basicBoolean) {
        earDetailViewModel.headTrackChecked.set(basicBoolean != null ? Boolean.valueOf(basicBoolean.getHead()) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$setSmartAncModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$setSmartAncModel$1", f = "EarDetailViewModel.kt", i = {0}, l = {ApiResponseKt.RESET_PASSWORD_FAIL}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class C08051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $state;
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08051(boolean z, Continuation<? super C08051> continuation) {
            super(2, continuation);
            this.$state = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarDetailViewModel.this.new C08051(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderSmartAnc;
            EarDetailViewModel earDetailViewModel;
            Object objSyncSetResponse$default;
            boolean z;
            int i;
            BasicBoolean basicBoolean;
            BasicBoolean basicBoolean2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = EarDetailViewModel.this.getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderSmartAnc = TWSDeviceExtKt.smartAnc(tWSDevice, Boxing.boxBoolean(this.$state))) != null) {
                    earDetailViewModel = EarDetailViewModel.this;
                    boolean z2 = this.$state;
                    int setCommand = tWSDeviceBuilderSmartAnc.getSetCommand();
                    this.L$0 = tWSDeviceBuilderSmartAnc;
                    this.L$1 = earDetailViewModel;
                    this.I$0 = 1;
                    this.Z$0 = z2;
                    this.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderSmartAnc.getTwsDevice(), setCommand, tWSDeviceBuilderSmartAnc.getSetPayload(), tWSDeviceBuilderSmartAnc.getTimeOut(), tWSDeviceBuilderSmartAnc.getIsNeedFsn(), false, tWSDeviceBuilderSmartAnc.getMockResponse(), this, 16, null);
                    if (objSyncSetResponse$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = z2;
                    i = 1;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = this.Z$0;
            i = this.I$0;
            earDetailViewModel = (EarDetailViewModel) this.L$1;
            tWSDeviceBuilderSmartAnc = (TWSDeviceBuilder) this.L$0;
            ResultKt.throwOnFailure(obj);
            objSyncSetResponse$default = obj;
            Message message = (Message) objSyncSetResponse$default;
            if (message != null && message.isOk()) {
                LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilderSmartAnc.getTwsDevice().getCommandCache(), tWSDeviceBuilderSmartAnc.getGetCommand(), 0, 2, null);
                LiveData liveData = earDetailViewModel.smartAncSwitchLiveData;
                if (liveData != null && (basicBoolean2 = (BasicBoolean) liveData.getValue()) != null) {
                    basicBoolean2.setOpen(z);
                }
                LiveData liveData2 = earDetailViewModel.smartAncSwitchLiveData;
                byte[] bArrObtainDataPacket = (liveData2 == null || (basicBoolean = (BasicBoolean) liveData2.getValue()) == null) ? null : basicBoolean.obtainDataPacket();
                Message message2 = (Message) liveDataCommand$default.getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                    tWSDeviceBuilderSmartAnc.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilderSmartAnc.getGetCommand(), bArrObtainDataPacket);
                    if (message2 != null) {
                        message2.setPayload(bArrObtainDataPacket);
                        if (i != 0) {
                            tWSDeviceBuilderSmartAnc.getTwsDevice().onUpdate(tWSDeviceBuilderSmartAnc.getGetCommand(), message2);
                        }
                    }
                }
                Boxing.boxBoolean(true);
            } else {
                Boxing.boxBoolean(false);
            }
            return Unit.INSTANCE;
        }
    }

    public final void setSmartAncModel(boolean state) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C08051(state, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$setHeadTrackModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$setHeadTrackModel$1", f = "EarDetailViewModel.kt", i = {0, 0}, l = {ApiResponseKt.RESET_PASSWORD_FAIL}, m = "invokeSuspend", n = {"build", "needUpdate$iv"}, s = {"L$0", "I$0"})
    static final class C08011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $state;
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        final /* synthetic */ EarDetailViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08011(boolean z, EarDetailViewModel earDetailViewModel, Continuation<? super C08011> continuation) {
            super(2, continuation);
            this.$state = z;
            this.this$0 = earDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08011(this.$state, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0072  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderSpatialAudio;
            BasicBoolean basicBoolean;
            TWSDeviceBuilder tWSDeviceBuilder;
            EarDetailViewModel earDetailViewModel;
            Object objSyncSetResponse$default;
            boolean z;
            int i;
            BasicBoolean basicBoolean2;
            BasicBoolean basicBoolean3;
            BasicBoolean basicBoolean4;
            BasicBoolean basicBoolean5;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            boolean open = false;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$state) {
                    TWSDevice tWSDevice = this.this$0.getTWSDevice();
                    if (tWSDevice != null) {
                        tWSDeviceBuilderSpatialAudio = TWSDeviceExtKt.spatialAudio(tWSDevice, Boxing.boxBoolean(true), Boxing.boxBoolean(true));
                        tWSDeviceBuilder = tWSDeviceBuilderSpatialAudio;
                    } else {
                        tWSDeviceBuilder = null;
                    }
                } else {
                    TWSDevice tWSDevice2 = this.this$0.getTWSDevice();
                    if (tWSDevice2 != null) {
                        LiveData liveData = this.this$0.headTrackLiveData;
                        tWSDeviceBuilderSpatialAudio = TWSDeviceExtKt.spatialAudio(tWSDevice2, (liveData == null || (basicBoolean = (BasicBoolean) liveData.getValue()) == null) ? null : Boxing.boxBoolean(basicBoolean.getOpen()), Boxing.boxBoolean(false));
                        tWSDeviceBuilder = tWSDeviceBuilderSpatialAudio;
                    } else {
                        tWSDeviceBuilder = null;
                    }
                }
                if (tWSDeviceBuilder != null) {
                    earDetailViewModel = this.this$0;
                    boolean z2 = this.$state;
                    int setCommand = tWSDeviceBuilder.getSetCommand();
                    this.L$0 = tWSDeviceBuilder;
                    this.L$1 = earDetailViewModel;
                    this.I$0 = 1;
                    this.Z$0 = z2;
                    this.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilder.getTwsDevice(), setCommand, tWSDeviceBuilder.getSetPayload(), tWSDeviceBuilder.getTimeOut(), tWSDeviceBuilder.getIsNeedFsn(), false, tWSDeviceBuilder.getMockResponse(), this, 16, null);
                    if (objSyncSetResponse$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = z2;
                    i = 1;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = this.Z$0;
            i = this.I$0;
            earDetailViewModel = (EarDetailViewModel) this.L$1;
            tWSDeviceBuilder = (TWSDeviceBuilder) this.L$0;
            ResultKt.throwOnFailure(obj);
            objSyncSetResponse$default = obj;
            Message message = (Message) objSyncSetResponse$default;
            if (message != null && message.isOk()) {
                LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                LiveData liveData2 = earDetailViewModel.headTrackLiveData;
                if (liveData2 != null && (basicBoolean4 = (BasicBoolean) liveData2.getValue()) != null) {
                    LiveData liveData3 = earDetailViewModel.headTrackLiveData;
                    basicBoolean4.setOpen((liveData3 == null || (basicBoolean5 = (BasicBoolean) liveData3.getValue()) == null) ? false : basicBoolean5.getOpen());
                }
                LiveData liveData4 = earDetailViewModel.headTrackLiveData;
                if (liveData4 != null && (basicBoolean3 = (BasicBoolean) liveData4.getValue()) != null) {
                    basicBoolean3.setHead(z);
                }
                BasicBoolean.Companion companion = BasicBoolean.INSTANCE;
                LiveData liveData5 = earDetailViewModel.headTrackLiveData;
                if (liveData5 != null && (basicBoolean2 = (BasicBoolean) liveData5.getValue()) != null) {
                    open = basicBoolean2.getOpen();
                }
                byte[] bArrObtainDataPacket = companion.obtainDataPacket(open, Boxing.boxBoolean(z));
                Message message2 = (Message) liveDataCommand$default.getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                    tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrObtainDataPacket);
                    if (message2 != null) {
                        message2.setPayload(bArrObtainDataPacket);
                        if (i != 0) {
                            tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message2);
                        }
                    }
                }
                Boxing.boxBoolean(true);
            } else {
                Boxing.boxBoolean(false);
            }
            return Unit.INSTANCE;
        }
    }

    public final void setHeadTrackModel(boolean state) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C08011(state, this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getSmartFreeModel() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            LiveData<BasicBoolean> liveData = this.smartFreeSwitchLiveData;
            if (liveData != null) {
                liveData.removeObservers(this);
            }
            final TWSDeviceBuilder tWSDeviceBuilderSmartFree$default = TWSDeviceExtKt.smartFree$default(tWSDevice, null, 1, null);
            final Class<BasicBoolean> cls = BasicBoolean.class;
            LiveData<BasicBoolean> map = Transformations.map(tWSDeviceBuilderSmartFree$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSmartFree$default.getGetCommand(), tWSDeviceBuilderSmartFree$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.elekid.detail.EarDetailViewModel$getSmartFreeModel$lambda$7$$inlined$getLiveData$1
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
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                }
                                obj = (BasicBoolean) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
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
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + basicBoolean + StringUtils.SPACE;
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
            });
            this.smartFreeSwitchLiveData = map;
            if (map != null) {
                map.observe(this, new EarDetailViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.detail.EarDetailViewModel$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EarDetailViewModel.getSmartFreeModel$lambda$7$lambda$6(this.f$0, (BasicBoolean) obj);
                    }
                }));
            }
            TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.smartFree$default(tWSDevice, null, 1, null), false, (byte[]) null, 0, 7, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getSmartFreeModel$lambda$7$lambda$6(EarDetailViewModel earDetailViewModel, BasicBoolean basicBoolean) {
        earDetailViewModel.smartFreeChecked.set(basicBoolean != null ? Boolean.valueOf(basicBoolean.getOpen()) : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$setSmartFreeModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$setSmartFreeModel$1", f = "EarDetailViewModel.kt", i = {0}, l = {ApiResponseKt.RESET_PASSWORD_FAIL}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class C08061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $state;
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08061(boolean z, Continuation<? super C08061> continuation) {
            super(2, continuation);
            this.$state = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarDetailViewModel.this.new C08061(this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderSmartFree;
            EarDetailViewModel earDetailViewModel;
            Object objSyncSetResponse$default;
            boolean z;
            int i;
            BasicBoolean basicBoolean;
            BasicBoolean basicBoolean2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = EarDetailViewModel.this.getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderSmartFree = TWSDeviceExtKt.smartFree(tWSDevice, Boxing.boxBoolean(this.$state))) != null) {
                    earDetailViewModel = EarDetailViewModel.this;
                    boolean z2 = this.$state;
                    int setCommand = tWSDeviceBuilderSmartFree.getSetCommand();
                    this.L$0 = tWSDeviceBuilderSmartFree;
                    this.L$1 = earDetailViewModel;
                    this.I$0 = 1;
                    this.Z$0 = z2;
                    this.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderSmartFree.getTwsDevice(), setCommand, tWSDeviceBuilderSmartFree.getSetPayload(), tWSDeviceBuilderSmartFree.getTimeOut(), tWSDeviceBuilderSmartFree.getIsNeedFsn(), false, tWSDeviceBuilderSmartFree.getMockResponse(), this, 16, null);
                    if (objSyncSetResponse$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    z = z2;
                    i = 1;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = this.Z$0;
            i = this.I$0;
            earDetailViewModel = (EarDetailViewModel) this.L$1;
            tWSDeviceBuilderSmartFree = (TWSDeviceBuilder) this.L$0;
            ResultKt.throwOnFailure(obj);
            objSyncSetResponse$default = obj;
            Message message = (Message) objSyncSetResponse$default;
            if (message != null && message.isOk()) {
                LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilderSmartFree.getTwsDevice().getCommandCache(), tWSDeviceBuilderSmartFree.getGetCommand(), 0, 2, null);
                LiveData liveData = earDetailViewModel.smartFreeSwitchLiveData;
                if (liveData != null && (basicBoolean2 = (BasicBoolean) liveData.getValue()) != null) {
                    basicBoolean2.setOpen(z);
                }
                LiveData liveData2 = earDetailViewModel.smartFreeSwitchLiveData;
                byte[] bArrObtainDataPacket = (liveData2 == null || (basicBoolean = (BasicBoolean) liveData2.getValue()) == null) ? null : basicBoolean.obtainDataPacket();
                Message message2 = (Message) liveDataCommand$default.getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                    tWSDeviceBuilderSmartFree.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilderSmartFree.getGetCommand(), bArrObtainDataPacket);
                    if (message2 != null) {
                        message2.setPayload(bArrObtainDataPacket);
                        if (i != 0) {
                            tWSDeviceBuilderSmartFree.getTwsDevice().onUpdate(tWSDeviceBuilderSmartFree.getGetCommand(), message2);
                        }
                    }
                }
                Boxing.boxBoolean(true);
            } else {
                Boxing.boxBoolean(false);
            }
            return Unit.INSTANCE;
        }
    }

    public final void setSmartFreeModel(boolean state) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C08061(state, null), 2, null);
    }

    private final void updateVersion() {
        String firmwareVersion;
        ObservableField<String> observableField = this.firmwareVersionStr;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = ViewModelExtKt.getString(this, R.string.firmware_version);
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(SpUtils.INSTANCE.getSelectDeviceMac());
        if (iOTDeviceByMacAddress == null || (firmwareVersion = iOTDeviceByMacAddress.getFirmwareVersion()) == null) {
            firmwareVersion = "";
        }
        String str = String.format(string, Arrays.copyOf(new Object[]{firmwareVersion}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        observableField.set(str);
    }

    static /* synthetic */ void setFirmwareTips$default(EarDetailViewModel earDetailViewModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        earDetailViewModel.setFirmwareTips(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setFirmwareTips(boolean hasTips) {
        this.hasUpdate.set(Boolean.valueOf(hasTips));
    }

    public final void getConfigInfo() {
        getProtocol().getDetailPageData();
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected() {
        this.connected.set(true);
        updateConnectedLiveData();
        this.loadAnimal.postValue(false);
        getProtocol().getDetailPageData();
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AnonymousClass1(null), 2, null);
        cancelJob();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$onConnected$1, reason: invalid class name */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$onConnected$1", f = "EarDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarDetailViewModel.this.new AnonymousClass1(continuation);
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
                EarDetailViewModel.this.getSmartAncModel();
                EarDetailViewModel.this.getSmartFreeModel();
                EarDetailViewModel.this.getHeadTrackModel();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$onConnected$2, reason: invalid class name */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$onConnected$2", f = "EarDetailViewModel.kt", i = {}, l = {246}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarDetailViewModel.this.new AnonymousClass2(continuation);
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
                TWSDevice tWSDevice = EarDetailViewModel.this.getProtocol().getTWSDevice();
                if (tWSDevice != null) {
                    this.label = 1;
                    obj = TWSDevice.syncSetResponse$default(tWSDevice, ProtocolConstant.Query.GET_LHDC_COMMANDS, null, null, false, false, null, this, 54, null);
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
            Message message = (Message) obj;
            if (message != null) {
                Integer num = (Integer) message.obtainPayload(Integer.TYPE);
                EarDetailViewModel.this.getLdacModelChecked().set(Boxing.boxBoolean(num == null || num.intValue() != 0));
                if (EarDetailViewModel.this.getIsClickLDAC()) {
                    EarDetailViewModel.this.setClickLDAC(false);
                    if (!Intrinsics.areEqual(EarDetailViewModel.this.getLdacModelChecked().get(), Boxing.boxBoolean(EarDetailViewModel.this.getSetLDACValue()))) {
                        EarDetailViewModel.this.getLhdcFailed().postValue(Boxing.boxBoolean(true));
                        NTLog.d("HIGH-QUALITY 8s delay set command not equals get command");
                    }
                }
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    private final void cancelJob() {
        Job job = this.jobSetLDAC;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
        this.connected.set(false);
        updateConnectedLiveData();
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(int code, String message) {
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice == null || tWSDevice.isConnected()) {
            return;
        }
        this.connected.set(false);
        updateConnectedLiveData();
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z = false;
        switch (cmdType) {
            case ProtocolConstant.Query.GET_REMOTE_CONFIGURATION /* 49158 */:
                DeviceConfiguration deviceConfiguration = (DeviceConfiguration) data.obtainPayload(DeviceConfiguration.class);
                this.deviceSerial.set(deviceConfiguration != null ? deviceConfiguration.getSerialNumber() : null);
                DeviceItemDao deviceDao = DatabaseUtils.INSTANCE.getDeviceDao();
                String str = this.deviceMac.get();
                if (str == null) {
                    str = "";
                }
                List<DeviceItem> deviceItem = deviceDao.getDeviceItem(str);
                DeviceItem deviceItem2 = deviceItem != null ? (DeviceItem) CollectionsKt.firstOrNull((List) deviceItem) : null;
                if (deviceItem2 != null) {
                    String str2 = this.deviceSerial.get();
                    deviceItem2.setSn(str2 != null ? str2 : "");
                }
                if (deviceItem2 != null) {
                    DatabaseUtils.INSTANCE.getDeviceDao().updateDeviceItem(deviceItem2);
                }
                NTLog.d("sn\uff1a" + (deviceConfiguration != null ? deviceConfiguration.getSerialNumber() : null));
                break;
            case ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS /* 49166 */:
                DeviceExtraFeatureStatus deviceExtraFeatureStatus = (DeviceExtraFeatureStatus) data.obtainPayload(DeviceExtraFeatureStatus.class);
                this.featureStatus = deviceExtraFeatureStatus;
                this.inEarChecked.set(Boolean.valueOf(deviceExtraFeatureStatus != null ? Intrinsics.areEqual((Object) deviceExtraFeatureStatus.getEnable(1), (Object) true) : false));
                break;
            case ProtocolConstant.Query.GET_PERSONALIZED_ANC /* 49184 */:
                DeviceANCSwitch deviceANCSwitch = (DeviceANCSwitch) data.obtainPayload(DeviceANCSwitch.class);
                this.personalised.set(Boolean.valueOf(deviceANCSwitch != null && deviceANCSwitch.getAncSwitch() == 1));
                ObservableField<Boolean> observableField = this.ancTest;
                if (deviceANCSwitch != null && deviceANCSwitch.getAncCalibration() == 1) {
                    z = true;
                }
                observableField.set(Boolean.valueOf(z));
                break;
            case ProtocolConstant.Query.GET_LHDC_COMMANDS /* 49193 */:
                Integer num = (Integer) data.obtainPayload(Integer.TYPE);
                this.ldacModelChecked.set(Boolean.valueOf(num == null || num.intValue() != 0));
                cancelJob();
                break;
            case ProtocolConstant.Query.GET_HOST_LAG_MODE /* 49217 */:
                Integer num2 = (Integer) data.obtainPayload(Integer.TYPE);
                this.lowModelChecked.set(Boolean.valueOf(num2 == null || num2.intValue() != 2));
                break;
        }
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$setLowModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$setLowModel$1", f = "EarDetailViewModel.kt", i = {}, l = {323}, m = "invokeSuspend", n = {}, s = {})
    static final class C08041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $boolean;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08041(boolean z, Continuation<? super C08041> continuation) {
            super(2, continuation);
            this.$boolean = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarDetailViewModel.this.new C08041(this.$boolean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = EarDetailViewModel.this.getProtocol().setLowModeSend(this.$boolean, this);
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
                EarDetailViewModel.this.getLowModelChecked().set(Boxing.boxBoolean(this.$boolean));
                TWSDevice tWSDevice = EarDetailViewModel.this.getProtocol().getTWSDevice();
                if (tWSDevice != null) {
                    tWSDevice.setCacheCommandsManualPayload(ProtocolConstant.Query.GET_HOST_LAG_MODE, this.$boolean ? DataExtKt.toByteArray$default(1, 0, 1, (Object) null) : DataExtKt.toByteArray$default(2, 0, 1, (Object) null));
                }
                TWSDevice tWSDevice2 = EarDetailViewModel.this.getProtocol().getTWSDevice();
                if (tWSDevice2 != null) {
                    tWSDevice2.updateFromCache(ProtocolConstant.Query.GET_HOST_LAG_MODE);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void setLowModel(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C08041(z, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$setLDACStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$setLDACStatus$1", f = "EarDetailViewModel.kt", i = {}, l = {346, AnimalBaseGuideActivity.REPEAT_THREE_START}, m = "invokeSuspend", n = {}, s = {})
    static final class C08031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $boolean;
        final /* synthetic */ int $value;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08031(boolean z, int i, Continuation<? super C08031> continuation) {
            super(2, continuation);
            this.$boolean = z;
            this.$value = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarDetailViewModel.this.new C08031(this.$boolean, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x006d  */
        /* JADX WARN: Code duplicated, block: B:29:0x00c6  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0060, code lost:
        
            if (r14 == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0088, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(40000, r13) == r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            boolean zBooleanValue;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EarDetailViewModel.this.setSetLDACValue(this.$boolean);
                EarDetailViewModel.this.setClickLDAC(true);
                EarDetailViewModel.this.getLoadAnimal().postValue(Boxing.boxBoolean(true));
                TWSDevice tWSDevice = EarDetailViewModel.this.getProtocol().getTWSDevice();
                if (tWSDevice != null) {
                    this.label = 1;
                    obj = TWSDevice.syncSet$default(tWSDevice, ProtocolConstant.Set.SET_LHDC_COMMANDS, DataExtKt.toByteArray$default(this.$value, 0, 1, (Object) null), null, false, this, 12, null);
                } else {
                    zBooleanValue = false;
                    if (zBooleanValue) {
                        EarDetailViewModel.this.getLdacModelChecked().set(Boxing.boxBoolean(this.$boolean));
                        this.label = 2;
                    } else {
                        EarDetailViewModel.this.setClickLDAC(false);
                        EarDetailViewModel.this.getLoadAnimal().postValue(Boxing.boxBoolean(false));
                        EarDetailViewModel.this.getLhdcFailed().postValue(Boxing.boxBoolean(true));
                        NTLog.d("HIGH-QUALITY 5s timeOut set command");
                    }
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            TWSDevice tWSDevice2 = EarDetailViewModel.this.getProtocol().getTWSDevice();
            if ((tWSDevice2 == null || tWSDevice2.isConnected()) ? false : true) {
                EarDetailViewModel.this.getLoadAnimal().postValue(Boxing.boxBoolean(false));
                NTLog.d("HIGH-QUALITY 40s timeOut connect");
                EarDetailViewModel.this.getLhdcFailed().postValue(Boxing.boxBoolean(true));
            }
            return Unit.INSTANCE;
            zBooleanValue = ((Boolean) obj).booleanValue();
            if (zBooleanValue) {
                EarDetailViewModel.this.getLdacModelChecked().set(Boxing.boxBoolean(this.$boolean));
                this.label = 2;
            } else {
                EarDetailViewModel.this.setClickLDAC(false);
                EarDetailViewModel.this.getLoadAnimal().postValue(Boxing.boxBoolean(false));
                EarDetailViewModel.this.getLhdcFailed().postValue(Boxing.boxBoolean(true));
                NTLog.d("HIGH-QUALITY 5s timeOut set command");
            }
            return Unit.INSTANCE;
        }
    }

    public final void setLDACStatus(boolean z) {
        int i = z ? 2 : 0;
        cancelJob();
        this.jobSetLDAC = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C08031(z, i, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$setInEarModel$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$setInEarModel$1", f = "EarDetailViewModel.kt", i = {}, l = {368}, m = "invokeSuspend", n = {}, s = {})
    static final class C08021 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $boolean;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08021(boolean z, Continuation<? super C08021> continuation) {
            super(2, continuation);
            this.$boolean = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarDetailViewModel.this.new C08021(this.$boolean, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08021) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = EarDetailViewModel.this.getProtocol().setEarDetect(this.$boolean, this);
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
                DeviceExtraFeatureStatus featureStatus = EarDetailViewModel.this.getFeatureStatus();
                if (featureStatus != null) {
                    boolean z = this.$boolean;
                    EarDetailViewModel earDetailViewModel = EarDetailViewModel.this;
                    featureStatus.setEnable(1, z);
                    TWSDevice tWSDevice = earDetailViewModel.getProtocol().getTWSDevice();
                    if (tWSDevice != null) {
                        tWSDevice.setCacheCommandsManualPayload(ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS, featureStatus.obtainDataPacket());
                    }
                    TWSDevice tWSDevice2 = earDetailViewModel.getProtocol().getTWSDevice();
                    if (tWSDevice2 != null) {
                        tWSDevice2.updateFromCache(ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS);
                    }
                }
                EarDetailViewModel.this.getInEarChecked().set(Boxing.boxBoolean(this.$boolean));
            }
            return Unit.INSTANCE;
        }
    }

    public final void setInEarModel(boolean z) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C08021(z, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$requestHttp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: EarDetailViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$requestHttp$1", f = "EarDetailViewModel.kt", i = {}, l = {386, 390}, m = "invokeSuspend", n = {}, s = {})
    static final class C08001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08001(Continuation<? super C08001> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarDetailViewModel.this.new C08001(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08001) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x006a, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.elekid.detail.EarDetailViewModel.C08001.C01581((com.nothing.network.core.ApiResult) r13, r12.this$0, null), r12) == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String firmwareVersion;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EarDeviceRepo earDeviceRepo = EarDeviceRepo.INSTANCE;
                IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(SpUtils.INSTANCE.getSelectDeviceMac());
                if (iOTDeviceByMacAddress == null || (firmwareVersion = iOTDeviceByMacAddress.getFirmwareVersion()) == null) {
                    firmwareVersion = "";
                }
                this.label = 1;
                obj = EarDeviceRepo.checkDeviceServer$default(earDeviceRepo, firmwareVersion, 0, null, null, null, this, 30, null);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.elekid.detail.EarDetailViewModel$requestHttp$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: EarDetailViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.elekid.detail.EarDetailViewModel$requestHttp$1$1", f = "EarDetailViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ApiResult<ServerFirmware> $apiResult;
            int label;
            final /* synthetic */ EarDetailViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01581(ApiResult<ServerFirmware> apiResult, EarDetailViewModel earDetailViewModel, Continuation<? super C01581> continuation) {
                super(2, continuation);
                this.$apiResult = apiResult;
                this.this$0 = earDetailViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01581(this.$apiResult, this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ApiResult<ServerFirmware> apiResult = this.$apiResult;
                if (apiResult instanceof ApiResult.Success) {
                    if (((ServerFirmware) ((ApiResult.Success) apiResult).getData()).getNeed_update() == 1) {
                        this.this$0.hasNewFirmware.set(Boxing.boxBoolean(true));
                    } else {
                        this.this$0.hasNewFirmware.set(Boxing.boxBoolean(false));
                    }
                    this.this$0.setFirmwareTips(((ServerFirmware) ((ApiResult.Success) this.$apiResult).getData()).getNeed_update() == 1);
                } else if ((apiResult instanceof ApiResult.Error) || (apiResult instanceof ApiResult.Failure)) {
                    this.this$0.setFirmwareTips(false);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void requestHttp() {
        updateVersion();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C08001(null), 3, null);
    }

    public final void disconnect() {
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null) {
            tWSDevice.disconnect();
        }
    }

    public final void forget() {
        String address;
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null) {
            tWSDevice.disconnect();
        }
        TWSDevice tWSDevice2 = getProtocol().getTWSDevice();
        if (tWSDevice2 == null || (address = tWSDevice2.getAddress()) == null) {
            return;
        }
        ElekidManager.INSTANCE.removeDevice(address);
    }

    @Override // com.nothing.device.BaseAndroidLifecycleViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null) {
            tWSDevice.unregister(this);
        }
    }
}
