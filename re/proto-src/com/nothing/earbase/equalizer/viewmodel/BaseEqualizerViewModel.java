package com.nothing.earbase.equalizer.viewmodel;

import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.protocol.entity.BasicInt;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.wiget.radar.EQLabelItem;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.BaseAndroidLifecycleViewModel;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.entity.CustomEQ;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.log.FileLog;
import com.nothing.os.device.DeviceConstant;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BaseEqualizerViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0001hB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010E\u001a\u00020\u001dH\u0016J\u0010\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IJ\b\u0010K\u001a\u00020GH\u0016J\b\u0010L\u001a\u00020GH\u0002J\b\u0010M\u001a\u00020GH\u0016J\b\u0010N\u001a\u00020GH\u0016J\b\u0010O\u001a\u00020GH\u0016J\u0010\u0010P\u001a\u00020/2\u0006\u0010Q\u001a\u000207H\u0016J\u0010\u0010R\u001a\u00020/2\u0006\u0010Q\u001a\u000207H\u0016J&\u0010S\u001a\u00020G2\u0006\u0010T\u001a\u00020\u00152\u0014\u0010U\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020G\u0018\u00010VH\u0016J\u0010\u0010S\u001a\u00020G2\u0006\u0010T\u001a\u00020\u0015H\u0016J\u0010\u0010W\u001a\u00020G2\u0006\u0010X\u001a\u00020\u001dH\u0016J\b\u0010Y\u001a\u00020GH\u0016J\u0012\u0010Z\u001a\u00020G2\b\u0010[\u001a\u0004\u0018\u00010DH\u0002J\u0015\u0010\\\u001a\u00020G2\b\u0010]\u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0002\u0010^J\b\u0010_\u001a\u00020GH\u0016J\b\u0010`\u001a\u00020GH\u0016J\u001a\u0010a\u001a\u00020G2\u0006\u0010b\u001a\u00020\u001d2\b\u0010c\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010d\u001a\u00020G2\u0006\u0010e\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020gH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001b\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001d0\u001d0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R \u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010 \"\u0004\b-\u0010\"R\u001a\u0010.\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070605X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010<\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010>\u0018\u00010=X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u0018\u0010C\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010D\u0018\u00010=X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010J\u001a\u0012\u0012\u0004\u0012\u0002070\u0014j\b\u0012\u0004\u0012\u000207`\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006i"}, d2 = {"Lcom/nothing/earbase/equalizer/viewmodel/BaseEqualizerViewModel;", "Lcom/nothing/device/BaseAndroidLifecycleViewModel;", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "protocol", "Lcom/nothing/earbase/spp/BaseSppProtocol;", "getProtocol", "()Lcom/nothing/earbase/spp/BaseSppProtocol;", "setProtocol", "(Lcom/nothing/earbase/spp/BaseSppProtocol;)V", "equalizerTypes", "Ljava/util/ArrayList;", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "Lkotlin/collections/ArrayList;", "getEqualizerTypes", "()Ljava/util/ArrayList;", "setEqualizerTypes", "(Ljava/util/ArrayList;)V", "radarResId", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getRadarResId", "()Landroidx/databinding/ObservableField;", "setRadarResId", "(Landroidx/databinding/ObservableField;)V", "isSystemPage", "", "()Z", "setSystemPage", "(Z)V", "isFirstInto", "setFirstInto", "powerByText", "Landroid/text/SpannableStringBuilder;", "getPowerByText", "setPowerByText", "sampleDesignSize", "", "getSampleDesignSize", "()F", "setSampleDesignSize", "(F)V", "customEqState", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/nothing/base/wiget/radar/EQLabelItem;", "getCustomEqState", "()Landroidx/lifecycle/MutableLiveData;", "setCustomEqState", "(Landroidx/lifecycle/MutableLiveData;)V", "eQLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/base/protocol/entity/BasicInt;", "getEQLiveData", "()Landroidx/lifecycle/LiveData;", "setEQLiveData", "(Landroidx/lifecycle/LiveData;)V", "customEQLiveData", "Lcom/nothing/earbase/equalizer/entity/CustomEQ;", "getDiracEQRes", "setNewAddress", "", "extra", "Landroid/os/Bundle;", "radarItemList", "register", "getCustomEQData", "getEQData", "onCleared", "unRegister", "getFreq", "radarItem", "getQ", "setEQMode", "typeViewModel", "action", "Lkotlin/Function1;", "setCustomEQ", "index", "initSoundTypes", "updateCustomEQValue", "eqValues", "updateEQMode", "eqMode", "(Ljava/lang/Integer;)V", "onConnected", "onDisconnected", "onError", "code", "message", "onUpdate", "cmdType", "data", "Lcom/nothing/protocol/model/Message;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseEqualizerViewModel extends BaseAndroidLifecycleViewModel implements TWSDevice.Callback {
    public static final float COVER_WIDTH = 240.0f;
    public static final int DEFAULT_DIRAC_EQ = -10;
    public static final float DIRAC_COVER_WIDTH = 366.0f;
    private String address;
    private LiveData<CustomEQ> customEQLiveData;
    private MutableLiveData<List<EQLabelItem>> customEqState;
    private LiveData<BasicInt> eQLiveData;
    private ArrayList<EqualizerTypeViewModel> equalizerTypes;
    private boolean isFirstInto;
    private boolean isSystemPage;
    private ObservableField<SpannableStringBuilder> powerByText;
    public BaseSppProtocol protocol;
    private ArrayList<EQLabelItem> radarItemList;
    private ObservableField<Integer> radarResId;
    private float sampleDesignSize;

    public int getDiracEQRes() {
        return -10;
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

    public void unRegister() {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseEqualizerViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.address = SpUtils.INSTANCE.getSelectDeviceMac();
        this.equalizerTypes = new ArrayList<>();
        this.radarResId = new ObservableField<>(-1);
        this.isFirstInto = true;
        this.powerByText = new ObservableField<>();
        this.sampleDesignSize = 240.0f;
        this.customEqState = new MutableLiveData<>();
        Application application2 = application;
        String string = ContextExtKt.getLocalizedResources(application2).getString(R.string.sound_mid);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = ContextExtKt.getLocalizedResources(application2).getString(R.string.sound_treble);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = ContextExtKt.getLocalizedResources(application2).getString(R.string.sound_bass);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.radarItemList = CollectionsKt.arrayListOf(new EQLabelItem(string, 0.0f, 1), new EQLabelItem(string2, 0.0f, 2), new EQLabelItem(string3, 0.0f, 0));
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final BaseSppProtocol getProtocol() {
        BaseSppProtocol baseSppProtocol = this.protocol;
        if (baseSppProtocol != null) {
            return baseSppProtocol;
        }
        Intrinsics.throwUninitializedPropertyAccessException("protocol");
        return null;
    }

    public final void setProtocol(BaseSppProtocol baseSppProtocol) {
        Intrinsics.checkNotNullParameter(baseSppProtocol, "<set-?>");
        this.protocol = baseSppProtocol;
    }

    public final ArrayList<EqualizerTypeViewModel> getEqualizerTypes() {
        return this.equalizerTypes;
    }

    public final void setEqualizerTypes(ArrayList<EqualizerTypeViewModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.equalizerTypes = arrayList;
    }

    public final ObservableField<Integer> getRadarResId() {
        return this.radarResId;
    }

    public final void setRadarResId(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.radarResId = observableField;
    }

    /* JADX INFO: renamed from: isSystemPage, reason: from getter */
    public final boolean getIsSystemPage() {
        return this.isSystemPage;
    }

    public final void setSystemPage(boolean z) {
        this.isSystemPage = z;
    }

    /* JADX INFO: renamed from: isFirstInto, reason: from getter */
    public final boolean getIsFirstInto() {
        return this.isFirstInto;
    }

    public final void setFirstInto(boolean z) {
        this.isFirstInto = z;
    }

    public final ObservableField<SpannableStringBuilder> getPowerByText() {
        return this.powerByText;
    }

    public final void setPowerByText(ObservableField<SpannableStringBuilder> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.powerByText = observableField;
    }

    public final float getSampleDesignSize() {
        return this.sampleDesignSize;
    }

    public final void setSampleDesignSize(float f) {
        this.sampleDesignSize = f;
    }

    public final MutableLiveData<List<EQLabelItem>> getCustomEqState() {
        return this.customEqState;
    }

    public final void setCustomEqState(MutableLiveData<List<EQLabelItem>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.customEqState = mutableLiveData;
    }

    public final LiveData<BasicInt> getEQLiveData() {
        return this.eQLiveData;
    }

    public final void setEQLiveData(LiveData<BasicInt> liveData) {
        this.eQLiveData = liveData;
    }

    public final void setNewAddress(Bundle extra) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "setNewAddress " + extra;
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
        String string = extra != null ? extra.getString("device_address") : null;
        String str4 = string;
        if (str4 == null || str4.length() == 0) {
            return;
        }
        this.address = string;
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str5 = "setNewAddress " + string;
            String str6 = str5;
            if (str6 == null || str6.length() == 0) {
                return;
            }
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

    public void register() {
        if (this.isFirstInto) {
            this.isFirstInto = false;
            getEQData();
            getCustomEQData();
            initSoundTypes();
        }
        GooglePlayScoreUtil.INSTANCE.startControl();
    }

    private final void getCustomEQData() {
        LiveData liveDataDistinctUntilChanged;
        final TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice)) != null) {
            final Class<CustomEQ> cls = CustomEQ.class;
            this.customEQLiveData = Transformations.map(tWSDeviceBuilderCustomEQValue.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderCustomEQValue.getGetCommand(), tWSDeviceBuilderCustomEQValue.getNotifyCommand()), new Function1<Message, CustomEQ>() { // from class: com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$getCustomEQData$lambda$2$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final CustomEQ invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    CustomEQ customEQ = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    customEQ = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (CustomEQ) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (CustomEQ) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.equalizer.entity.CustomEQ");
                                }
                                obj = (CustomEQ) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (CustomEQ) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (CustomEQ) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            customEQ = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            customEQ = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + customEQ + StringUtils.SPACE;
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
                    return customEQ;
                }
            });
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderCustomEQValue, false, (byte[]) null, 0, 7, (Object) null);
        }
        LiveData<CustomEQ> liveData = this.customEQLiveData;
        if (liveData == null || (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(liveData)) == null) {
            return;
        }
        liveDataDistinctUntilChanged.observe(this, new BaseEqualizerViewModelKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseEqualizerViewModel.getCustomEQData$lambda$3(this.f$0, (CustomEQ) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getCustomEQData$lambda$3(BaseEqualizerViewModel baseEqualizerViewModel, CustomEQ customEQ) {
        baseEqualizerViewModel.updateCustomEQValue(customEQ);
        return Unit.INSTANCE;
    }

    public void getEQData() {
        LiveData liveDataDistinctUntilChanged;
        final TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice, 0, 1, null)) != null) {
            final Class<BasicInt> cls = BasicInt.class;
            this.eQLiveData = Transformations.map(tWSDeviceBuilderEQMode$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderEQMode$default.getGetCommand(), tWSDeviceBuilderEQMode$default.getNotifyCommand()), new Function1<Message, BasicInt>() { // from class: com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$getEQData$lambda$4$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final BasicInt invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    BasicInt basicInt = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    basicInt = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (BasicInt) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (BasicInt) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicInt");
                                }
                                obj = (BasicInt) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (BasicInt) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (BasicInt) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            basicInt = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            basicInt = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + basicInt + StringUtils.SPACE;
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
                    return basicInt;
                }
            });
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
        }
        LiveData<BasicInt> liveData = this.eQLiveData;
        if (liveData == null || (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(liveData)) == null) {
            return;
        }
        liveDataDistinctUntilChanged.observe(this, new BaseEqualizerViewModelKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseEqualizerViewModel.getEQData$lambda$6(this.f$0, (BasicInt) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEQData$lambda$6(BaseEqualizerViewModel baseEqualizerViewModel, BasicInt basicInt) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "eq_register eQLiveData distinctUntilChanged".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "eq_register eQLiveData distinctUntilChanged " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "eq_register eQLiveData distinctUntilChanged " + strComponent2);
            }
        }
        baseEqualizerViewModel.updateEQMode(Integer.valueOf(basicInt != null ? basicInt.getValue() : 0));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.device.BaseAndroidLifecycleViewModel, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "eq_register onCleared".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "eq_register onCleared " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "eq_register onCleared " + strComponent2);
            }
        }
        unRegister();
    }

    public float getFreq(EQLabelItem radarItem) {
        Intrinsics.checkNotNullParameter(radarItem, "radarItem");
        int type = radarItem.getType();
        if (type == 0) {
            return 140.0f;
        }
        if (type != 1) {
            return type != 2 ? 140.0f : 6900.0f;
        }
        return 980.0f;
    }

    public float getQ(EQLabelItem radarItem) {
        Intrinsics.checkNotNullParameter(radarItem, "radarItem");
        int type = radarItem.getType();
        if (type == 0) {
            return 0.8f;
        }
        if (type != 1) {
            return type != 2 ? 0.8f : 1.0f;
        }
        return 0.7f;
    }

    public void setEQMode(EqualizerTypeViewModel typeViewModel, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        for (EqualizerTypeViewModel equalizerTypeViewModel : this.equalizerTypes) {
            if (Intrinsics.areEqual((Object) equalizerTypeViewModel.getSelected().get(), (Object) true) && equalizerTypeViewModel.getType() == typeViewModel.getType()) {
                return;
            }
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06742(typeViewModel, this, action, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$setEQMode$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseEqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$setEQMode$2", f = "BaseEqualizerViewModel.kt", i = {}, l = {198, 203}, m = "invokeSuspend", n = {}, s = {})
    static final class C06742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Integer, Unit> $action;
        final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
        int label;
        final /* synthetic */ BaseEqualizerViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C06742(EqualizerTypeViewModel equalizerTypeViewModel, BaseEqualizerViewModel baseEqualizerViewModel, Function1<? super Integer, Unit> function1, Continuation<? super C06742> continuation) {
            super(2, continuation);
            this.$typeViewModel = equalizerTypeViewModel;
            this.this$0 = baseEqualizerViewModel;
            this.$action = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06742(this.$typeViewModel, this.this$0, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06742) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel.C06742.AnonymousClass1(r4, r9.this$0, r9.$typeViewModel, r9.$action, null), r9) == r0) goto L20;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            String productId;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppBuriedPointUtils.INSTANCE.reportUserData(new EventParams(AppBuriedPointUtils.CHANGE_EQ_EVENT, this.$typeViewModel.getReportType(), AppBuriedPointUtils.VALUE_TYPE_INT), this.this$0.getIsSystemPage());
                this.label = 1;
                obj = this.this$0.getProtocol().setEQMode(this.$typeViewModel.getType(), this);
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
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            GooglePlayScoreUtil googlePlayScoreUtil = GooglePlayScoreUtil.INSTANCE;
            IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(this.this$0.getAddress());
            if (productByMacAddress == null || (productId = productByMacAddress.getProductId()) == null) {
                productId = "";
            }
            googlePlayScoreUtil.addScore(zBooleanValue, productId);
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$setEQMode$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: BaseEqualizerViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$setEQMode$2$1", f = "BaseEqualizerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Integer, Unit> $action;
            final /* synthetic */ boolean $success;
            final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
            int label;
            final /* synthetic */ BaseEqualizerViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(boolean z, BaseEqualizerViewModel baseEqualizerViewModel, EqualizerTypeViewModel equalizerTypeViewModel, Function1<? super Integer, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$success = z;
                this.this$0 = baseEqualizerViewModel;
                this.$typeViewModel = equalizerTypeViewModel;
                this.$action = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$success, this.this$0, this.$typeViewModel, this.$action, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                TWSDevice tWSDevice;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.$success) {
                    TWSDevice tWSDevice2 = this.this$0.getProtocol().getTWSDevice();
                    if (tWSDevice2 != null) {
                        tWSDevice2.setCacheCommandsManualPayload(49183, DataExtKt.toByteArray$default(this.$typeViewModel.getType(), 0, 1, (Object) null));
                    }
                    ArrayList<EqualizerTypeViewModel> equalizerTypes = this.this$0.getEqualizerTypes();
                    EqualizerTypeViewModel equalizerTypeViewModel = this.$typeViewModel;
                    for (EqualizerTypeViewModel equalizerTypeViewModel2 : equalizerTypes) {
                        equalizerTypeViewModel2.getSelected().set(Boxing.boxBoolean(equalizerTypeViewModel.getType() == equalizerTypeViewModel2.getType()));
                    }
                    this.this$0.getRadarResId().set(Boxing.boxInt(this.$typeViewModel.getResId()));
                    if (this.$action != null && (tWSDevice = this.this$0.getProtocol().getTWSDevice()) != null) {
                        tWSDevice.updateFromCache(49183);
                    }
                }
                return Unit.INSTANCE;
            }
        }
    }

    public void setEQMode(EqualizerTypeViewModel typeViewModel) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        setEQMode(typeViewModel, null);
    }

    public void setCustomEQ(int index) {
        ArrayList arrayList = new ArrayList();
        Ref.FloatRef floatRef = new Ref.FloatRef();
        int i = 0;
        for (Object obj : this.radarItemList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            EQLabelItem eQLabelItem = (EQLabelItem) obj;
            CustomEQ.EQ eq = new CustomEQ.EQ(eQLabelItem.getType(), eQLabelItem.getGain(), getFreq(eQLabelItem), getQ(eQLabelItem));
            if (eQLabelItem.getGain() > floatRef.element) {
                floatRef.element = eQLabelItem.getGain();
            }
            arrayList.add(eq);
            if (index == i) {
                AppBuriedPointUtils.INSTANCE.reportUserData(new EventParams(AppBuriedPointUtils.CHANGE_CUSTOM_EQ_EVENT, eq.buriedInfo(), "string"), this.isSystemPage);
            }
            i = i2;
        }
        try {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(floatRef, arrayList, this, null), 2, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$setCustomEQ$2, reason: invalid class name */
    /* JADX INFO: compiled from: BaseEqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel$setCustomEQ$2", f = "BaseEqualizerViewModel.kt", i = {0, 0, 0}, l = {367}, m = "invokeSuspend", n = {"byteArray", "this_$iv", "needUpdate$iv"}, s = {"L$0", "L$1", "I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.FloatRef $cacTotalGain;
        final /* synthetic */ ArrayList<CustomEQ.EQ> $eqList;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ BaseEqualizerViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.FloatRef floatRef, ArrayList<CustomEQ.EQ> arrayList, BaseEqualizerViewModel baseEqualizerViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$cacTotalGain = floatRef;
            this.$eqList = arrayList;
            this.this$0 = baseEqualizerViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$cacTotalGain, this.$eqList, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte[] bArrObtainDataPacket;
            TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                bArrObtainDataPacket = CustomEQ.INSTANCE.obtainDataPacket(-this.$cacTotalGain.element, this.$eqList);
                TWSDevice tWSDevice = this.this$0.getProtocol().getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice)) != null) {
                    int setCommand = tWSDeviceBuilderCustomEQValue.getSetCommand();
                    TWSDevice twsDevice = tWSDeviceBuilderCustomEQValue.getTwsDevice();
                    byte[] setPayload = bArrObtainDataPacket == null ? tWSDeviceBuilderCustomEQValue.getSetPayload() : bArrObtainDataPacket;
                    this.L$0 = bArrObtainDataPacket;
                    this.L$1 = tWSDeviceBuilderCustomEQValue;
                    this.I$0 = 1;
                    this.label = 1;
                    obj = TWSDevice.syncSetResponse$default(twsDevice, setCommand, setPayload, tWSDeviceBuilderCustomEQValue.getTimeOut(), tWSDeviceBuilderCustomEQValue.getIsNeedFsn(), false, tWSDeviceBuilderCustomEQValue.getMockResponse(), this, 16, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i = 1;
                }
                return Unit.INSTANCE;
            }
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.I$0;
            tWSDeviceBuilderCustomEQValue = (TWSDeviceBuilder) this.L$1;
            bArrObtainDataPacket = (byte[]) this.L$0;
            ResultKt.throwOnFailure(obj);
            Message message = (Message) obj;
            if (message != null && message.isOk()) {
                Message message2 = (Message) TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilderCustomEQValue.getTwsDevice().getCommandCache(), tWSDeviceBuilderCustomEQValue.getGetCommand(), 0, 2, null).getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                    tWSDeviceBuilderCustomEQValue.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilderCustomEQValue.getGetCommand(), bArrObtainDataPacket);
                    if (message2 != null) {
                        message2.setPayload(bArrObtainDataPacket);
                        if (i != 0) {
                            tWSDeviceBuilderCustomEQValue.getTwsDevice().onUpdate(tWSDeviceBuilderCustomEQValue.getGetCommand(), message2);
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

    public void initSoundTypes() {
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        Resources localizedResources = ContextExtKt.getLocalizedResources(application);
        this.equalizerTypes.add(new EqualizerTypeViewModel("0", new ObservableField(localizedResources.getString(R.string.sound_balanced)), 0, this.isSystemPage ? R.drawable.os_balanced : R.drawable.equalizer_balanced, null, null, 0, SdkConfig.SDK_VERSION, null));
        this.equalizerTypes.add(new EqualizerTypeViewModel("3", new ObservableField(localizedResources.getString(R.string.sound_more_bass)), 3, this.isSystemPage ? R.drawable.os_bass : R.drawable.equalizer_bass, null, null, 0, SdkConfig.SDK_VERSION, null));
        this.equalizerTypes.add(new EqualizerTypeViewModel("2", new ObservableField(localizedResources.getString(R.string.sound_more_treble)), 2, this.isSystemPage ? R.drawable.os_treble : R.drawable.equalizer_treble, null, null, 0, SdkConfig.SDK_VERSION, null));
        this.equalizerTypes.add(new EqualizerTypeViewModel("1", new ObservableField(localizedResources.getString(R.string.sound_more_voice)), 1, this.isSystemPage ? R.drawable.os_voice : R.drawable.equalizer_voice, null, null, 0, SdkConfig.SDK_VERSION, null));
        this.equalizerTypes.add(new EqualizerTypeViewModel(DeviceConstant.NOISE_CANCELLATION_OFF, new ObservableField(localizedResources.getString(R.string.sound_eq_custom)), 5, 0, null, null, 0, SdkConfig.SDK_VERSION, null));
    }

    private final void updateCustomEQValue(CustomEQ eqValues) {
        List<CustomEQ.EQ> values;
        if (eqValues != null && (values = eqValues.getValues()) != null) {
            for (CustomEQ.EQ eq : values) {
                for (EQLabelItem eQLabelItem : this.radarItemList) {
                    if (eQLabelItem.getType() == eq.getFilterType()) {
                        eQLabelItem.setGain(eq.getGain());
                    }
                }
            }
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "EQ_MODE GET_CUSTOM_EQ_VALUE " + eqValues;
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
        this.customEqState.postValue(this.radarItemList);
    }

    public final void updateEQMode(Integer eqMode) {
        Object next;
        ObservableField<Boolean> selected;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Base EQ_MODE GET_EQ_MODE " + eqMode;
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
        Iterator<T> it = this.equalizerTypes.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(eqMode != null && ((EqualizerTypeViewModel) next).getType() == eqMode.intValue()));
        EqualizerTypeViewModel equalizerTypeViewModel = (EqualizerTypeViewModel) next;
        if ((equalizerTypeViewModel == null || (selected = equalizerTypeViewModel.getSelected()) == null) ? false : Intrinsics.areEqual((Object) selected.get(), (Object) true)) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                if ("eq_register updateEQMode same".length() == 0) {
                    return;
                }
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 3, str4, tag2, "eq_register updateEQMode same " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "eq_register updateEQMode same " + strComponent4);
                    return;
                }
                return;
            }
            return;
        }
        for (EqualizerTypeViewModel equalizerTypeViewModel2 : this.equalizerTypes) {
            int type = equalizerTypeViewModel2.getType();
            if (eqMode != null && eqMode.intValue() == type) {
                equalizerTypeViewModel2.getSelected().set(true);
                this.radarResId.set(Integer.valueOf(equalizerTypeViewModel2.getResId()));
            } else {
                equalizerTypeViewModel2.getSelected().set(false);
            }
        }
    }
}
