package com.nothing.earbase.equalizer.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.BasicBoolean;
import com.nothing.base.protocol.entity.BasicInt;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.wiget.radar.EQLabelItem;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.BaseAndroidLifecycleViewModel;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.entity.CustomEQ;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.log.FileLog;
import com.nothing.nt_ear.NtEarPlugin;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: SimpleEqualizerViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 I2\u00020\u0001:\u0001IB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010:\u001a\u00020;H\u0002J\u000e\u0010<\u001a\u00020;H\u0086@\u00a2\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020\u0010J&\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020\b2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020;\u0018\u00010CH\u0016J\u0010\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020\bH\u0016J\u0006\u0010D\u001a\u00020;J\u0010\u0010E\u001a\u00020;2\u0006\u0010F\u001a\u00020\u0010H\u0016J\u0006\u0010G\u001a\u00020;J\b\u0010H\u001a\u00020;H\u0016R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\"0\u0007j\b\u0012\u0004\u0012\u00020\"`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0%0$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001f\u00101\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100$\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010'R$\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u000104\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R$\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u000104\u0018\u00010+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010.\"\u0004\b9\u00100\u00a8\u0006J"}, d2 = {"Lcom/nothing/earbase/equalizer/viewmodel/SimpleEqualizerViewModel;", "Lcom/nothing/device/BaseAndroidLifecycleViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "equalizerTypes", "Ljava/util/ArrayList;", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "Lkotlin/collections/ArrayList;", "getEqualizerTypes", "()Ljava/util/ArrayList;", "setEqualizerTypes", "(Ljava/util/ArrayList;)V", "radarResId", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getRadarResId", "()Landroidx/databinding/ObservableField;", "setRadarResId", "(Landroidx/databinding/ObservableField;)V", "isSystemPage", "", "()Z", "setSystemPage", "(Z)V", "eqModeJob", "Lkotlinx/coroutines/Job;", "getEqModeJob", "()Lkotlinx/coroutines/Job;", "setEqModeJob", "(Lkotlinx/coroutines/Job;)V", "radarItemList", "Lcom/nothing/base/wiget/radar/EQLabelItem;", "customEqState", "Landroidx/lifecycle/MutableLiveData;", "", "getCustomEqState", "()Landroidx/lifecycle/MutableLiveData;", "setCustomEqState", "(Landroidx/lifecycle/MutableLiveData;)V", "eqModelLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/protocol/model/Message;", "getEqModelLiveData", "()Landroidx/lifecycle/LiveData;", "setEqModelLiveData", "(Landroidx/lifecycle/LiveData;)V", "needHDACWarning", "getNeedHDACWarning", "spatialAudioLiveData", "Lcom/nothing/base/protocol/entity/BasicBoolean;", "getSpatialAudioLiveData", "setSpatialAudioLiveData", "earMutuallyExclusiveLiveData", "getEarMutuallyExclusiveLiveData", "setEarMutuallyExclusiveLiveData", "getConfig", "", "checkConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onRequestData", "loadStatus", "setEQMode", "typeViewModel", "action", "Lkotlin/Function1;", "setSpatialAudioOff", "setCustomEQ", "index", "checkLDACStatus", "initSoundTypes", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class SimpleEqualizerViewModel extends BaseAndroidLifecycleViewModel {
    public static final long DELAY_TIME = 300;
    private MutableLiveData<List<EQLabelItem>> customEqState;
    private LiveData<BasicBoolean> earMutuallyExclusiveLiveData;
    private Job eqModeJob;
    private LiveData<Message> eqModelLiveData;
    private ArrayList<EqualizerTypeViewModel> equalizerTypes;
    private boolean isSystemPage;
    private final MutableLiveData<Integer> needHDACWarning;
    private ArrayList<EQLabelItem> radarItemList;
    private ObservableField<Integer> radarResId;
    private LiveData<BasicBoolean> spatialAudioLiveData;

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$checkConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: SimpleEqualizerViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel", f = "SimpleEqualizerViewModel.kt", i = {0, 0, 1}, l = {133, 148}, m = "checkConfig", n = {"this", "$this$checkConfig_u24lambda_u2417", "this"}, s = {"L$0", "L$2", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return SimpleEqualizerViewModel.this.checkConfig(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleEqualizerViewModel(Application application) {
        final TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
        final TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        LiveData map;
        LiveData liveDataDistinctUntilChanged;
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.equalizerTypes = new ArrayList<>();
        this.radarResId = new ObservableField<>(-1);
        Application application2 = application;
        String string = ContextExtKt.getLocalizedResources(application2).getString(R.string.sound_mid);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = ContextExtKt.getLocalizedResources(application2).getString(R.string.sound_treble);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = ContextExtKt.getLocalizedResources(application2).getString(R.string.sound_bass);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.radarItemList = CollectionsKt.arrayListOf(new EQLabelItem(string, 0.0f, 1), new EQLabelItem(string2, 0.0f, 2), new EQLabelItem(string3, 0.0f, 0));
        this.customEqState = new MutableLiveData<>();
        this.needHDACWarning = new MutableLiveData<>(-1);
        initSoundTypes();
        getConfig();
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice, 0, 1, null)) != null) {
            LiveData<Message> liveData = tWSDeviceBuilderEQMode$default.getLiveData();
            this.eqModelLiveData = liveData;
            if (liveData != null && (map = Transformations.map(liveData, new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SimpleEqualizerViewModel.lambda$4$lambda$0((Message) obj);
                }
            })) != null && (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(map)) != null) {
                liveDataDistinctUntilChanged.observe(this, new SimpleEqualizerViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SimpleEqualizerViewModel.lambda$4$lambda$3(tWSDeviceBuilderEQMode$default, this, (Integer) obj);
                    }
                }));
            }
        }
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 == null || (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice2)) == null) {
            return;
        }
        final Class<CustomEQ> cls = CustomEQ.class;
        Transformations.map(tWSDeviceBuilderCustomEQValue.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderCustomEQValue.getGetCommand(), tWSDeviceBuilderCustomEQValue.getNotifyCommand()), new Function1<Message, CustomEQ>() { // from class: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$_init_$lambda$10$$inlined$getLiveData$1
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
        }).observe(this, new SimpleEqualizerViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SimpleEqualizerViewModel.lambda$10$lambda$9(this.f$0, tWSDeviceBuilderCustomEQValue, (CustomEQ) obj);
            }
        }));
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

    public final Job getEqModeJob() {
        return this.eqModeJob;
    }

    public final void setEqModeJob(Job job) {
        this.eqModeJob = job;
    }

    public final MutableLiveData<List<EQLabelItem>> getCustomEqState() {
        return this.customEqState;
    }

    public final void setCustomEqState(MutableLiveData<List<EQLabelItem>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.customEqState = mutableLiveData;
    }

    public final LiveData<Message> getEqModelLiveData() {
        return this.eqModelLiveData;
    }

    public final void setEqModelLiveData(LiveData<Message> liveData) {
        this.eqModelLiveData = liveData;
    }

    public final MutableLiveData<Integer> getNeedHDACWarning() {
        return this.needHDACWarning;
    }

    public final LiveData<BasicBoolean> getSpatialAudioLiveData() {
        return this.spatialAudioLiveData;
    }

    public final void setSpatialAudioLiveData(LiveData<BasicBoolean> liveData) {
        this.spatialAudioLiveData = liveData;
    }

    public final LiveData<BasicBoolean> getEarMutuallyExclusiveLiveData() {
        return this.earMutuallyExclusiveLiveData;
    }

    public final void setEarMutuallyExclusiveLiveData(LiveData<BasicBoolean> liveData) {
        this.earMutuallyExclusiveLiveData = liveData;
    }

    static final Integer lambda$4$lambda$0(Message message) {
        if (message != null) {
            return (Integer) message.obtainPayload(Integer.TYPE);
        }
        return null;
    }

    static final Unit lambda$4$lambda$3(TWSDeviceBuilder tWSDeviceBuilder, SimpleEqualizerViewModel simpleEqualizerViewModel, Integer num) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Simple EQ_MODE GET_EQ_MODE " + num;
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
        for (EqualizerTypeViewModel equalizerTypeViewModel : simpleEqualizerViewModel.equalizerTypes) {
            int type = equalizerTypeViewModel.getType();
            if (num != null && num.intValue() == type) {
                equalizerTypeViewModel.getSelected().set(true);
                simpleEqualizerViewModel.radarResId.set(Integer.valueOf(equalizerTypeViewModel.getResId()));
            } else {
                equalizerTypeViewModel.getSelected().set(false);
            }
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$10$lambda$9(SimpleEqualizerViewModel simpleEqualizerViewModel, TWSDeviceBuilder tWSDeviceBuilder, CustomEQ customEQ) {
        List<CustomEQ.EQ> values = customEQ != null ? customEQ.getValues() : null;
        List<CustomEQ.EQ> list = values;
        if (list == null || list.isEmpty()) {
            Iterator<T> it = simpleEqualizerViewModel.radarItemList.iterator();
            while (it.hasNext()) {
                ((EQLabelItem) it.next()).setGain(0.0f);
            }
        } else {
            for (CustomEQ.EQ eq : values) {
                for (EQLabelItem eQLabelItem : simpleEqualizerViewModel.radarItemList) {
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
            String str = "EQ_MODE GET_CUSTOM_EQ_VALUE " + customEQ;
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
        simpleEqualizerViewModel.customEqState.postValue(simpleEqualizerViewModel.radarItemList);
        return Unit.INSTANCE;
    }

    private final void getConfig() {
        LiveData<BasicBoolean> map;
        LiveData<BasicBoolean> map2;
        TWSDeviceBuilder tWSDeviceBuilderMutuallyExclusive;
        final TWSDeviceBuilder tWSDeviceBuilderMutuallyExclusive2;
        TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default;
        final TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default2;
        IOTProductDevice productDevice = getProductDevice();
        if (productDevice != null) {
            if (productDevice.eqMutuallyExclusive() || productDevice.spaceEqExclusive()) {
                TWSDevice tWSDevice = getTWSDevice();
                if (tWSDevice == null || (tWSDeviceBuilderSpatialAudio$default2 = TWSDeviceExtKt.spatialAudio$default(tWSDevice, null, null, 3, null)) == null) {
                    map = null;
                } else {
                    final Class<BasicBoolean> cls = BasicBoolean.class;
                    map = Transformations.map(tWSDeviceBuilderSpatialAudio$default2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default2.getGetCommand(), tWSDeviceBuilderSpatialAudio$default2.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$getConfig$lambda$13$$inlined$getLiveData$1
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
                }
                this.spatialAudioLiveData = map;
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "base_eq spatialAudioLiveData is null:" + (this.spatialAudioLiveData == null);
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
                TWSDevice tWSDevice2 = getTWSDevice();
                if (tWSDevice2 != null && (tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(tWSDevice2, null, null, 3, null)) != null) {
                    TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderSpatialAudio$default, false, (byte[]) null, 0, 7, (Object) null);
                }
                TWSDevice tWSDevice3 = getTWSDevice();
                if (tWSDevice3 == null || (tWSDeviceBuilderMutuallyExclusive2 = TWSDeviceExtKt.mutuallyExclusive(tWSDevice3)) == null) {
                    map2 = null;
                } else {
                    final Class<BasicBoolean> cls2 = BasicBoolean.class;
                    map2 = Transformations.map(tWSDeviceBuilderMutuallyExclusive2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderMutuallyExclusive2.getGetCommand(), tWSDeviceBuilderMutuallyExclusive2.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$getConfig$lambda$13$$inlined$getLiveData$2
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
                                Class cls3 = cls2;
                                try {
                                    if (Intrinsics.areEqual(cls3, Integer.TYPE)) {
                                        obj = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                                    } else if (Intrinsics.areEqual(cls3, Long.TYPE)) {
                                        obj = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                                    } else if (Intrinsics.areEqual(cls3, String.class)) {
                                        Object objDecodeToString = StringsKt.decodeToString(payload);
                                        if (objDecodeToString == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                        }
                                        obj = (BasicBoolean) objDecodeToString;
                                    } else if (Intrinsics.areEqual(cls3, Boolean.TYPE)) {
                                        obj = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                                    } else if (Intrinsics.areEqual(cls3, Float.TYPE)) {
                                        obj = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                                    } else {
                                        try {
                                            objNewInstance = cls3.getConstructor(byte[].class).newInstance(payload);
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
                            Logger logger2 = Logger.INSTANCE;
                            Class cls4 = cls2;
                            Logger logger3 = logger2;
                            String tag2 = logger3.getTAG();
                            int depth2 = logger3.getDepth();
                            if (logger3.isCanLogger(true)) {
                                String str4 = "parseLiveData " + cls4 + StringUtils.SPACE + basicBoolean + StringUtils.SPACE;
                                String str5 = str4;
                                if (str5 != null && str5.length() != 0) {
                                    Pair<String, String> trace2 = logger3.getTrace(depth2);
                                    String strComponent3 = trace2.component1();
                                    String strComponent4 = trace2.component2();
                                    FileLog fileLog2 = FileLog.INSTANCE;
                                    String str6 = logger3.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                    FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                                    if (logger3.isDebug()) {
                                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                                    }
                                }
                            }
                            return basicBoolean;
                        }
                    });
                }
                this.earMutuallyExclusiveLiveData = map2;
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    LiveData<BasicBoolean> liveData = this.earMutuallyExclusiveLiveData;
                    String str4 = "base_eq earMutuallyExclusiveLiveData is :" + (liveData != null ? liveData.getValue() : null);
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
                TWSDevice tWSDevice4 = getTWSDevice();
                if (tWSDevice4 == null || (tWSDeviceBuilderMutuallyExclusive = TWSDeviceExtKt.mutuallyExclusive(tWSDevice4)) == null) {
                    return;
                }
                TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderMutuallyExclusive, false, (byte[]) null, 0, 7, (Object) null);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:33:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:34:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:36:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:37:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:40:0x00df  */
    /* JADX WARN: Code duplicated, block: B:41:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:52:0x0110  */
    /* JADX WARN: Code duplicated, block: B:59:0x0181  */
    /* JADX WARN: Code duplicated, block: B:62:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:64:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:67:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:69:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:73:0x01f4  */
    /* JADX WARN: Code duplicated, block: B:74:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:77:0x0210  */
    /* JADX WARN: Code duplicated, block: B:78:0x0213  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:80:0x0216  */
    /* JADX WARN: Code duplicated, block: B:83:0x021d  */
    /* JADX WARN: Code duplicated, block: B:89:0x023e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0252  */
    /* JADX WARN: Code duplicated, block: B:96:0x02a0  */
    public final Object checkConfig(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        IOTProductDevice productDevice;
        boolean z;
        SimpleEqualizerViewModel simpleEqualizerViewModel;
        IOTProductDevice iOTProductDevice;
        Message message;
        SimpleEqualizerViewModel simpleEqualizerViewModel2;
        IOTProductDevice iOTProductDevice2;
        TWSDevice tWSDevice;
        MutableLiveData mutableLiveData;
        Message message2;
        SimpleEqualizerViewModel simpleEqualizerViewModel3;
        Object objSendMessageSync$default;
        SimpleEqualizerViewModel simpleEqualizerViewModel4;
        BasicBoolean basicBoolean;
        boolean open;
        boolean head;
        BasicBoolean basicBoolean2;
        LiveData<BasicBoolean> liveData;
        MutableLiveData mutableLiveData2;
        LiveData<BasicBoolean> liveData2;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        BasicBoolean value;
        BasicBoolean basicBoolean3;
        boolean open2;
        BasicBoolean basicBoolean4;
        LiveData<BasicBoolean> liveData3;
        MutableLiveData mutableLiveData3;
        LiveData<BasicBoolean> liveData4;
        Logger logger2;
        String tag2;
        int depth2;
        String str3;
        String str4;
        String strComponent3;
        String strComponent4;
        BasicBoolean value2;
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
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            productDevice = getProductDevice();
            if (productDevice != null && (productDevice.eqMutuallyExclusive() || productDevice.spaceEqExclusive())) {
                TWSDevice tWSDevice2 = getTWSDevice();
                if (tWSDevice2 != null) {
                    anonymousClass2.L$0 = this;
                    anonymousClass2.L$1 = productDevice;
                    anonymousClass2.L$2 = productDevice;
                    anonymousClass2.label = 1;
                    z = true;
                    Object objSendMessageSync$default2 = TWSDevice.sendMessageSync$default(tWSDevice2, ProtocolConstant.Query.GET_SPATIAL_AUDIO, null, false, false, null, null, anonymousClass2, 62, null);
                    if (objSendMessageSync$default2 != coroutine_suspended) {
                        simpleEqualizerViewModel2 = this;
                        iOTProductDevice2 = productDevice;
                        obj = objSendMessageSync$default2;
                        iOTProductDevice = iOTProductDevice2;
                    }
                } else {
                    z = true;
                    simpleEqualizerViewModel = this;
                    iOTProductDevice = productDevice;
                    message = null;
                    if (message != null) {
                        basicBoolean = (BasicBoolean) message.obtainPayload(BasicBoolean.class);
                        if (basicBoolean != null) {
                            open = basicBoolean.getOpen();
                        } else {
                            open = false;
                        }
                        if (basicBoolean != null) {
                            head = basicBoolean.getHead();
                        } else {
                            head = false;
                        }
                        basicBoolean2 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(open, Boxing.boxBoolean(head)));
                        liveData = simpleEqualizerViewModel.spatialAudioLiveData;
                        if (liveData instanceof MutableLiveData) {
                            mutableLiveData2 = (MutableLiveData) liveData;
                        } else {
                            mutableLiveData2 = null;
                        }
                        if (mutableLiveData2 != null) {
                            mutableLiveData2.postValue(basicBoolean2);
                        }
                        liveData2 = simpleEqualizerViewModel.spatialAudioLiveData;
                        if (liveData2 != null && (value = liveData2.getValue()) != null) {
                            value.setOpen(open);
                            value.setHead(head);
                        }
                        Logger logger3 = Logger.INSTANCE;
                        Logger logger4 = Logger.INSTANCE;
                        logger = logger3;
                        tag = logger.getTAG();
                        depth = logger.getDepth();
                        if (logger.isCanLogger(z)) {
                            str = "Test_check SimpleEqualizerViewModel spatialAudioLiveData:" + head + "," + open;
                            str2 = str;
                            if (str2 != null && str2.length() != 0) {
                                Pair<String, String> trace = logger.getTrace(depth);
                                strComponent1 = trace.component1();
                                strComponent2 = trace.component2();
                                FileLog fileLog = FileLog.INSTANCE;
                                String str5 = logger.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                FileLog.print$default(fileLog, 3, str5, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                if (logger.isDebug()) {
                                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                }
                            }
                        }
                    }
                    if (iOTProductDevice.spaceEqExclusive()) {
                        tWSDevice = simpleEqualizerViewModel.getTWSDevice();
                        if (tWSDevice != null) {
                            Long lBoxLong = Boxing.boxLong(300L);
                            anonymousClass2.L$0 = simpleEqualizerViewModel;
                            anonymousClass2.L$1 = productDevice;
                            mutableLiveData = null;
                            anonymousClass2.L$2 = null;
                            anonymousClass2.label = 2;
                            simpleEqualizerViewModel3 = simpleEqualizerViewModel;
                            objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_MUTUALLY_EXCLUSIVE, null, false, false, lBoxLong, null, anonymousClass2, 46, null);
                            if (objSendMessageSync$default != coroutine_suspended) {
                                simpleEqualizerViewModel4 = simpleEqualizerViewModel3;
                                message2 = (Message) objSendMessageSync$default;
                                simpleEqualizerViewModel = simpleEqualizerViewModel4;
                            }
                        } else {
                            mutableLiveData = null;
                            message2 = null;
                        }
                        if (message2 != null) {
                            basicBoolean3 = (BasicBoolean) message2.obtainPayload(BasicBoolean.class);
                            if (basicBoolean3 != null) {
                                open2 = basicBoolean3.getOpen();
                            } else {
                                open2 = false;
                            }
                            basicBoolean4 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(open2, Boxing.boxBoolean(false)));
                            liveData3 = simpleEqualizerViewModel.earMutuallyExclusiveLiveData;
                            if (liveData3 instanceof MutableLiveData) {
                                mutableLiveData3 = (MutableLiveData) liveData3;
                            } else {
                                mutableLiveData3 = mutableLiveData;
                            }
                            if (mutableLiveData3 != null) {
                                mutableLiveData3.postValue(basicBoolean4);
                            }
                            liveData4 = simpleEqualizerViewModel.earMutuallyExclusiveLiveData;
                            if (liveData4 != null) {
                                value2.setOpen(open2);
                            }
                            Logger logger5 = Logger.INSTANCE;
                            Logger logger6 = Logger.INSTANCE;
                            logger2 = logger5;
                            tag2 = logger2.getTAG();
                            depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(z)) {
                                str3 = "Test_check SimpleEqualizerViewModel earMutuallyExclusiveLiveData:" + open2;
                                str4 = str3;
                                if (str4 != null) {
                                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                                    strComponent3 = trace2.component1();
                                    strComponent4 = trace2.component2();
                                    FileLog fileLog2 = FileLog.INSTANCE;
                                    String str6 = logger2.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                    FileLog.print$default(fileLog2, 3, str6, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                    if (logger2.isDebug()) {
                                        Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                    }
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            iOTProductDevice = (IOTProductDevice) anonymousClass2.L$2;
            iOTProductDevice2 = (IOTProductDevice) anonymousClass2.L$1;
            simpleEqualizerViewModel2 = (SimpleEqualizerViewModel) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            z = true;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            simpleEqualizerViewModel4 = (SimpleEqualizerViewModel) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            objSendMessageSync$default = obj;
            z = true;
            mutableLiveData = null;
        }
        message2 = (Message) objSendMessageSync$default;
        simpleEqualizerViewModel = simpleEqualizerViewModel4;
        if (message2 != null) {
            basicBoolean3 = (BasicBoolean) message2.obtainPayload(BasicBoolean.class);
            if (basicBoolean3 != null) {
                open2 = basicBoolean3.getOpen();
            } else {
                open2 = false;
            }
            basicBoolean4 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(open2, Boxing.boxBoolean(false)));
            liveData3 = simpleEqualizerViewModel.earMutuallyExclusiveLiveData;
            if (liveData3 instanceof MutableLiveData) {
                mutableLiveData3 = (MutableLiveData) liveData3;
            } else {
                mutableLiveData3 = mutableLiveData;
            }
            if (mutableLiveData3 != null) {
                mutableLiveData3.postValue(basicBoolean4);
            }
            liveData4 = simpleEqualizerViewModel.earMutuallyExclusiveLiveData;
            if (liveData4 != null && (value2 = liveData4.getValue()) != null) {
                value2.setOpen(open2);
            }
            Logger logger7 = Logger.INSTANCE;
            Logger logger8 = Logger.INSTANCE;
            logger2 = logger7;
            tag2 = logger2.getTAG();
            depth2 = logger2.getDepth();
            if (logger2.isCanLogger(z)) {
                str3 = "Test_check SimpleEqualizerViewModel earMutuallyExclusiveLiveData:" + open2;
                str4 = str3;
                if (str4 != null && str4.length() != 0) {
                    Pair<String, String> trace3 = logger2.getTrace(depth2);
                    strComponent3 = trace3.component1();
                    strComponent4 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str7 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    FileLog.print$default(fileLog3, 3, str7, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
        }
        return Unit.INSTANCE;
        message = (Message) obj;
        productDevice = iOTProductDevice2;
        simpleEqualizerViewModel = simpleEqualizerViewModel2;
        if (message != null) {
            basicBoolean = (BasicBoolean) message.obtainPayload(BasicBoolean.class);
            if (basicBoolean != null) {
                open = basicBoolean.getOpen();
            } else {
                open = false;
            }
            if (basicBoolean != null) {
                head = basicBoolean.getHead();
            } else {
                head = false;
            }
            basicBoolean2 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(open, Boxing.boxBoolean(head)));
            liveData = simpleEqualizerViewModel.spatialAudioLiveData;
            if (liveData instanceof MutableLiveData) {
                mutableLiveData2 = (MutableLiveData) liveData;
            } else {
                mutableLiveData2 = null;
            }
            if (mutableLiveData2 != null) {
                mutableLiveData2.postValue(basicBoolean2);
            }
            liveData2 = simpleEqualizerViewModel.spatialAudioLiveData;
            if (liveData2 != null) {
                value.setOpen(open);
                value.setHead(head);
            }
            Logger logger9 = Logger.INSTANCE;
            Logger logger10 = Logger.INSTANCE;
            logger = logger9;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(z)) {
                str = "Test_check SimpleEqualizerViewModel spatialAudioLiveData:" + head + "," + open;
                str2 = str;
                if (str2 != null) {
                    Pair<String, String> trace4 = logger.getTrace(depth);
                    strComponent1 = trace4.component1();
                    strComponent2 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str8 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    FileLog.print$default(fileLog4, 3, str8, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
        }
        if (iOTProductDevice.spaceEqExclusive()) {
            tWSDevice = simpleEqualizerViewModel.getTWSDevice();
            if (tWSDevice != null) {
                Long lBoxLong2 = Boxing.boxLong(300L);
                anonymousClass2.L$0 = simpleEqualizerViewModel;
                anonymousClass2.L$1 = productDevice;
                mutableLiveData = null;
                anonymousClass2.L$2 = null;
                anonymousClass2.label = 2;
                simpleEqualizerViewModel3 = simpleEqualizerViewModel;
                objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_MUTUALLY_EXCLUSIVE, null, false, false, lBoxLong2, null, anonymousClass2, 46, null);
                if (objSendMessageSync$default != coroutine_suspended) {
                    simpleEqualizerViewModel4 = simpleEqualizerViewModel3;
                    message2 = (Message) objSendMessageSync$default;
                    simpleEqualizerViewModel = simpleEqualizerViewModel4;
                }
                return coroutine_suspended;
            }
            mutableLiveData = null;
            message2 = null;
            if (message2 != null) {
                basicBoolean3 = (BasicBoolean) message2.obtainPayload(BasicBoolean.class);
                if (basicBoolean3 != null) {
                    open2 = basicBoolean3.getOpen();
                } else {
                    open2 = false;
                }
                basicBoolean4 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(open2, Boxing.boxBoolean(false)));
                liveData3 = simpleEqualizerViewModel.earMutuallyExclusiveLiveData;
                if (liveData3 instanceof MutableLiveData) {
                    mutableLiveData3 = (MutableLiveData) liveData3;
                } else {
                    mutableLiveData3 = mutableLiveData;
                }
                if (mutableLiveData3 != null) {
                    mutableLiveData3.postValue(basicBoolean4);
                }
                liveData4 = simpleEqualizerViewModel.earMutuallyExclusiveLiveData;
                if (liveData4 != null) {
                    value2.setOpen(open2);
                }
                Logger logger11 = Logger.INSTANCE;
                Logger logger12 = Logger.INSTANCE;
                logger2 = logger11;
                tag2 = logger2.getTAG();
                depth2 = logger2.getDepth();
                if (logger2.isCanLogger(z)) {
                    str3 = "Test_check SimpleEqualizerViewModel earMutuallyExclusiveLiveData:" + open2;
                    str4 = str3;
                    if (str4 != null) {
                        Pair<String, String> trace5 = logger2.getTrace(depth2);
                        strComponent3 = trace5.component1();
                        strComponent4 = trace5.component2();
                        FileLog fileLog5 = FileLog.INSTANCE;
                        String str9 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                        FileLog.print$default(fileLog5, 3, str9, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    public final void onRequestData(int loadStatus) {
        TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
        TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice, 0, 1, null)) != null) {
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
        }
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 == null || (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice2)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderCustomEQValue, false, (byte[]) null, 0, 7, (Object) null);
    }

    public void setEQMode(EqualizerTypeViewModel typeViewModel, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        for (EqualizerTypeViewModel equalizerTypeViewModel : this.equalizerTypes) {
            if (Intrinsics.areEqual((Object) equalizerTypeViewModel.getSelected().get(), (Object) true) && equalizerTypeViewModel.getType() == typeViewModel.getType()) {
                return;
            }
        }
        Job job = this.eqModeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.eqModeJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06762(typeViewModel, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setEQMode$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SimpleEqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setEQMode$2", f = "SimpleEqualizerViewModel.kt", i = {0}, l = {291, 185}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class C06762 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
        int I$0;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ SimpleEqualizerViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06762(EqualizerTypeViewModel equalizerTypeViewModel, SimpleEqualizerViewModel simpleEqualizerViewModel, Continuation<? super C06762> continuation) {
            super(2, continuation);
            this.$typeViewModel = equalizerTypeViewModel;
            this.this$0 = simpleEqualizerViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C06762(this.$typeViewModel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06762) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x0114, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel.C06762.AnonymousClass1(r2, r18.this$0, r18.$typeViewModel, null), r18) == r1) goto L38;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Boolean boolBoxBoolean;
            TWSDeviceBuilder tWSDeviceBuilderEQMode;
            Object objSyncSetResponse$default;
            TWSDeviceBuilder tWSDeviceBuilder;
            EqualizerTypeViewModel equalizerTypeViewModel;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                AppBuriedPointUtils.INSTANCE.reportUserData(new EventParams(AppBuriedPointUtils.CHANGE_EQ_EVENT, this.$typeViewModel.getReportType(), AppBuriedPointUtils.VALUE_TYPE_INT), this.this$0.getIsSystemPage());
                TWSDevice tWSDevice = this.this$0.getTWSDevice();
                if (tWSDevice == null || (tWSDeviceBuilderEQMode = TWSDeviceExtKt.eQMode(tWSDevice, this.$typeViewModel.getType())) == null) {
                    boolBoxBoolean = null;
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                } else {
                    EqualizerTypeViewModel equalizerTypeViewModel2 = this.$typeViewModel;
                    int setCommand = tWSDeviceBuilderEQMode.getSetCommand();
                    this.L$0 = tWSDeviceBuilderEQMode;
                    this.L$1 = equalizerTypeViewModel2;
                    this.I$0 = 1;
                    this.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderEQMode.getTwsDevice(), setCommand, tWSDeviceBuilderEQMode.getSetPayload(), tWSDeviceBuilderEQMode.getTimeOut(), tWSDeviceBuilderEQMode.getIsNeedFsn(), false, tWSDeviceBuilderEQMode.getMockResponse(), this, 16, null);
                    if (objSyncSetResponse$default != coroutine_suspended) {
                        tWSDeviceBuilder = tWSDeviceBuilderEQMode;
                        equalizerTypeViewModel = equalizerTypeViewModel2;
                        i = 1;
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                int i3 = this.I$0;
                EqualizerTypeViewModel equalizerTypeViewModel3 = (EqualizerTypeViewModel) this.L$1;
                TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDeviceBuilder = tWSDeviceBuilder2;
                equalizerTypeViewModel = equalizerTypeViewModel3;
                i = i3;
                objSyncSetResponse$default = obj;
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            Message message = (Message) objSyncSetResponse$default;
            if (message != null && message.isOk()) {
                LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                byte[] byteArray$default = DataExtKt.toByteArray$default(equalizerTypeViewModel.getType(), 0, 1, (Object) null);
                Message message2 = (Message) liveDataCommand$default.getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, byteArray$default)) {
                    tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), byteArray$default);
                    if (message2 != null) {
                        message2.setPayload(byteArray$default);
                        if (i != 0) {
                            tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message2);
                        }
                    }
                }
                boolBoxBoolean = Boxing.boxBoolean(true);
            } else {
                boolBoxBoolean = Boxing.boxBoolean(false);
            }
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setEQMode$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: SimpleEqualizerViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setEQMode$2$1", f = "SimpleEqualizerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Boolean $success;
            final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
            int label;
            final /* synthetic */ SimpleEqualizerViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Boolean bool, SimpleEqualizerViewModel simpleEqualizerViewModel, EqualizerTypeViewModel equalizerTypeViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$success = bool;
                this.this$0 = simpleEqualizerViewModel;
                this.$typeViewModel = equalizerTypeViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$success, this.this$0, this.$typeViewModel, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                String productId;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                GooglePlayScoreUtil googlePlayScoreUtil = GooglePlayScoreUtil.INSTANCE;
                boolean zAreEqual = Intrinsics.areEqual(this.$success, Boxing.boxBoolean(true));
                IOTProductDevice productDevice = this.this$0.getProductDevice();
                if (productDevice == null || (productId = productDevice.getProductId()) == null) {
                    productId = "";
                }
                googlePlayScoreUtil.addScore(zAreEqual, productId);
                if (Intrinsics.areEqual(this.$success, Boxing.boxBoolean(true))) {
                    ArrayList<EqualizerTypeViewModel> equalizerTypes = this.this$0.getEqualizerTypes();
                    EqualizerTypeViewModel equalizerTypeViewModel = this.$typeViewModel;
                    for (EqualizerTypeViewModel equalizerTypeViewModel2 : equalizerTypes) {
                        equalizerTypeViewModel2.getSelected().set(Boxing.boxBoolean(equalizerTypeViewModel.getType() == equalizerTypeViewModel2.getType()));
                    }
                    this.this$0.getRadarResId().set(Boxing.boxInt(this.$typeViewModel.getResId()));
                }
                return Unit.INSTANCE;
            }
        }
    }

    public void setEQMode(EqualizerTypeViewModel typeViewModel) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        setEQMode(typeViewModel, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setSpatialAudioOff$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SimpleEqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setSpatialAudioOff$1", f = "SimpleEqualizerViewModel.kt", i = {1}, l = {207, 291}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class C06771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;

        C06771(Continuation<? super C06771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SimpleEqualizerViewModel.this.new C06771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00ed  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel.C06771.C01361(r17.this$0, null), r17) == r1) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderSpatialAudio;
            Object objSyncSetResponse$default;
            int i;
            Message message;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (SpUtils.INSTANCE.getPhoneSupportSpatial() == 1) {
                    this.label = 1;
                } else {
                    TWSDevice tWSDevice = SimpleEqualizerViewModel.this.getTWSDevice();
                    if (tWSDevice != null && (tWSDeviceBuilderSpatialAudio = TWSDeviceExtKt.spatialAudio(tWSDevice, Boxing.boxBoolean(false), Boxing.boxBoolean(false))) != null) {
                        int setCommand = tWSDeviceBuilderSpatialAudio.getSetCommand();
                        this.L$0 = tWSDeviceBuilderSpatialAudio;
                        this.I$0 = 1;
                        this.label = 2;
                        objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderSpatialAudio.getTwsDevice(), setCommand, tWSDeviceBuilderSpatialAudio.getSetPayload(), tWSDeviceBuilderSpatialAudio.getTimeOut(), tWSDeviceBuilderSpatialAudio.getIsNeedFsn(), false, tWSDeviceBuilderSpatialAudio.getMockResponse(), this, 16, null);
                        if (objSyncSetResponse$default != coroutine_suspended) {
                            i = 1;
                            message = (Message) objSyncSetResponse$default;
                            if (message == null) {
                                Boxing.boxBoolean(false);
                            } else {
                                Boxing.boxBoolean(false);
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            } else if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                tWSDeviceBuilderSpatialAudio = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                objSyncSetResponse$default = obj;
                message = (Message) objSyncSetResponse$default;
                if (message == null && message.isOk()) {
                    LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilderSpatialAudio.getTwsDevice().getCommandCache(), tWSDeviceBuilderSpatialAudio.getGetCommand(), 0, 2, null);
                    byte[] bArrObtainDataPacket = BasicBoolean.INSTANCE.obtainDataPacket(false, Boxing.boxBoolean(false));
                    Message message2 = (Message) liveDataCommand$default.getValue();
                    if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                        tWSDeviceBuilderSpatialAudio.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilderSpatialAudio.getGetCommand(), bArrObtainDataPacket);
                        if (message2 != null) {
                            message2.setPayload(bArrObtainDataPacket);
                            if (i != 0) {
                                tWSDeviceBuilderSpatialAudio.getTwsDevice().onUpdate(tWSDeviceBuilderSpatialAudio.getGetCommand(), message2);
                            }
                        }
                    }
                    Boxing.boxBoolean(true);
                } else {
                    Boxing.boxBoolean(false);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setSpatialAudioOff$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SimpleEqualizerViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setSpatialAudioOff$1$1", f = "SimpleEqualizerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01361 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ SimpleEqualizerViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01361(SimpleEqualizerViewModel simpleEqualizerViewModel, Continuation<? super C01361> continuation) {
                super(2, continuation);
                this.this$0 = simpleEqualizerViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01361(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01361) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                String address;
                BasicBoolean value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get("main");
                if (flutterEngine != null) {
                    FlutterPlugin flutterPlugin = flutterEngine.getPlugins().get(NtEarPlugin.class);
                    LiveData<BasicBoolean> spatialAudioLiveData = this.this$0.getSpatialAudioLiveData();
                    long j = (spatialAudioLiveData == null || (value = spatialAudioLiveData.getValue()) == null || !value.getHead()) ? 1L : 2L;
                    if (flutterPlugin instanceof NtEarPlugin) {
                        NtEarPlugin ntEarPlugin = (NtEarPlugin) flutterPlugin;
                        TWSDevice tWSDevice = this.this$0.getTWSDevice();
                        if (tWSDevice == null || (address = tWSDevice.getAddress()) == null) {
                            address = "";
                        }
                        ntEarPlugin.setPhoneSpatialAudio(address, 0L, j, new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setSpatialAudioOff$1$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return SimpleEqualizerViewModel.C06771.C01361.invokeSuspend$lambda$0((Result) obj2);
                            }
                        });
                        LiveData<BasicBoolean> spatialAudioLiveData2 = this.this$0.getSpatialAudioLiveData();
                        MutableLiveData mutableLiveData = spatialAudioLiveData2 instanceof MutableLiveData ? (MutableLiveData) spatialAudioLiveData2 : null;
                        if (mutableLiveData != null) {
                            mutableLiveData.postValue(new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(false, Boxing.boxBoolean(false))));
                        }
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(Result result) {
                return Unit.INSTANCE;
            }
        }
    }

    public final void setSpatialAudioOff() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C06771(null), 3, null);
    }

    public void setCustomEQ(int index) {
        String productId;
        ArrayList arrayList = new ArrayList();
        IOTProductDevice productDevice = getProductDevice();
        if (productDevice == null) {
            return;
        }
        float gain = 0.0f;
        int i = 0;
        for (Object obj : this.radarItemList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            EQLabelItem eQLabelItem = (EQLabelItem) obj;
            Pair<Float, Float> simpleCustomEQParameter = productDevice.getSimpleCustomEQParameter(eQLabelItem.getType());
            CustomEQ.EQ eq = new CustomEQ.EQ(eQLabelItem.getType(), eQLabelItem.getGain(), simpleCustomEQParameter.getFirst().floatValue(), simpleCustomEQParameter.getSecond().floatValue());
            if (eQLabelItem.getGain() > gain) {
                gain = eQLabelItem.getGain();
            }
            arrayList.add(eq);
            if (index == i) {
                AppBuriedPointUtils.INSTANCE.reportUserData(new EventParams(AppBuriedPointUtils.CHANGE_CUSTOM_EQ_EVENT, eq.buriedInfo(), "string"), this.isSystemPage);
            }
            i = i2;
        }
        byte[] bArrObtainDataPacket = CustomEQ.INSTANCE.obtainDataPacket(-gain, arrayList);
        GooglePlayScoreUtil googlePlayScoreUtil = GooglePlayScoreUtil.INSTANCE;
        IOTProductDevice productDevice2 = getProductDevice();
        if (productDevice2 == null || (productId = productDevice2.getProductId()) == null) {
            productId = "";
        }
        googlePlayScoreUtil.addScore(true, productId);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(bArrObtainDataPacket, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setCustomEQ$2, reason: invalid class name */
    /* JADX INFO: compiled from: SimpleEqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$setCustomEQ$2", f = "SimpleEqualizerViewModel.kt", i = {0}, l = {291}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $byteArray;
        int I$0;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(byte[] bArr, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$byteArray = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SimpleEqualizerViewModel.this.new AnonymousClass2(this.$byteArray, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
            byte[] bArr;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = SimpleEqualizerViewModel.this.getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice)) != null) {
                    bArr = this.$byteArray;
                    int setCommand = tWSDeviceBuilderCustomEQValue.getSetCommand();
                    TWSDevice twsDevice = tWSDeviceBuilderCustomEQValue.getTwsDevice();
                    byte[] setPayload = bArr == null ? tWSDeviceBuilderCustomEQValue.getSetPayload() : bArr;
                    this.L$0 = tWSDeviceBuilderCustomEQValue;
                    this.L$1 = bArr;
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
            bArr = (byte[]) this.L$1;
            tWSDeviceBuilderCustomEQValue = (TWSDeviceBuilder) this.L$0;
            ResultKt.throwOnFailure(obj);
            Message message = (Message) obj;
            if (message != null && message.isOk()) {
                Message message2 = (Message) TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilderCustomEQValue.getTwsDevice().getCommandCache(), tWSDeviceBuilderCustomEQValue.getGetCommand(), 0, 2, null).getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArr)) {
                    tWSDeviceBuilderCustomEQValue.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilderCustomEQValue.getGetCommand(), bArr);
                    if (message2 != null) {
                        message2.setPayload(bArr);
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

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$checkLDACStatus$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SimpleEqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.SimpleEqualizerViewModel$checkLDACStatus$1", f = "SimpleEqualizerViewModel.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, s = {})
    static final class C06751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06751(Continuation<? super C06751> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SimpleEqualizerViewModel.this.new C06751(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0046  */
        /* JADX WARN: Code duplicated, block: B:21:0x005e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BasicInt basicInt;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = SimpleEqualizerViewModel.this.getTWSDevice();
                if (tWSDevice != null) {
                    this.label = 1;
                    obj = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_LHDC_COMMANDS, null, false, false, null, null, this, 62, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    basicInt = null;
                }
                if (basicInt == null && basicInt.getValue() == 2) {
                    SimpleEqualizerViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(1));
                } else {
                    SimpleEqualizerViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Message message = (Message) obj;
            if (message != null) {
                basicInt = (BasicInt) message.obtainPayload(BasicInt.class);
            } else {
                basicInt = null;
            }
            if (basicInt == null) {
                SimpleEqualizerViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
            } else {
                SimpleEqualizerViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
            }
            return Unit.INSTANCE;
        }
    }

    public final void checkLDACStatus() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06751(null), 2, null);
    }

    public void initSoundTypes() {
        IOTProductDevice productDevice = getProductDevice();
        if (productDevice != null) {
            boolean z = this.isSystemPage;
            IOTProductDevice productDevice2 = getProductDevice();
            boolean z2 = false;
            if (productDevice2 != null && productDevice2.getIsSupportCustomEQ()) {
                z2 = true;
            }
            List<EqualizerTypeViewModel> listInitSimpleEQItem = productDevice.initSimpleEQItem(z, z2);
            if (listInitSimpleEQItem != null) {
                this.equalizerTypes.addAll(listInitSimpleEQItem);
            }
        }
    }
}
