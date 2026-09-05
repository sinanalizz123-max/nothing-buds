package com.nothing.earbase.unknown;

import android.app.Application;
import android.content.res.Resources;
import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.protocol.entity.BasicBoolean;
import com.nothing.base.protocol.entity.BasicInt;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.entity.AdvanceCustomEQEntity;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import com.nothing.earbase.unknown.device.UnknownProduct;
import com.nothing.earbase.unknown.entity.DiracOpteoEQ;
import com.nothing.earbase.unknown.entity.EQ;
import com.nothing.earbase.unknown.entity.UnknownConfigs;
import com.nothing.earbase.unknown.entity.UnknownFunction;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
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
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: UnknownEqualizerViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001eH\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002J\u0006\u0010%\u001a\u00020\u001eJ\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\"J\u0006\u0010(\u001a\u00020\u001eJ\u0006\u0010)\u001a\u00020\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR$\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u0019\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006+"}, d2 = {"Lcom/nothing/earbase/unknown/UnknownEqualizerViewModel;", "Lcom/nothing/earbase/equalizer/viewmodel/BaseEqualizerViewModel;", "context", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "advanceCustomEQLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/core/entity/AdvanceCustomEQEntity;", "getAdvanceCustomEQLiveData", "()Landroidx/lifecycle/LiveData;", "setAdvanceCustomEQLiveData", "(Landroidx/lifecycle/LiveData;)V", "diracOpteoEQLiveData", "Lcom/nothing/base/protocol/entity/BasicInt;", "spatialAudioLiveData", "Lcom/nothing/base/protocol/entity/BasicBoolean;", "getSpatialAudioLiveData", "setSpatialAudioLiveData", "earMutuallyExclusiveLiveData", "getEarMutuallyExclusiveLiveData", "setEarMutuallyExclusiveLiveData", "needHDACWarning", "Landroidx/lifecycle/MutableLiveData;", "Lcom/nothing/earbase/unknown/WarnEqualizerTypeViewModel;", "getNeedHDACWarning", "()Landroidx/lifecycle/MutableLiveData;", "register", "", "getEQData", "initSoundTypes", "conditionalRes", "", "systemRes", "normalRes", "getConfig", "onRequestData", "loadStatus", "markSpatialAudioOffLocally", "setSpatialAudioOff", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnknownEqualizerViewModel extends BaseEqualizerViewModel {
    public static final int CLASSICAL = 5;
    public static final int CUSTOM_EQ = 6;
    public static final float DIRAC_EQ_HEIGHT = 18.0f;
    public static final float DIRAC_EQ_WIDTH = 54.0f;
    public static final int ELECTRONIC = 2;
    public static final int ENHANCE_VOCALS = 4;
    public static final int OPTEO = 0;
    public static final int POP = 3;
    public static final int ROCK = 1;
    public static final float STICK_FREQ_HIGH = 3500.0f;
    public static final float STICK_FREQ_LOW = 140.0f;
    public static final float STICK_FREQ_PEAK = 980.0f;
    public static final float STICK_Q_HIGH = 1.0f;
    public static final float STICK_Q_LOW = 0.8f;
    public static final float STICK_Q_PEAK = 0.66f;
    private LiveData<AdvanceCustomEQEntity> advanceCustomEQLiveData;
    private final Application context;
    private LiveData<BasicInt> diracOpteoEQLiveData;
    private LiveData<BasicBoolean> earMutuallyExclusiveLiveData;
    private final MutableLiveData<WarnEqualizerTypeViewModel> needHDACWarning;
    private LiveData<BasicBoolean> spatialAudioLiveData;

    /* JADX INFO: compiled from: UnknownEqualizerViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DiracOpteoEQ.values().length];
            try {
                iArr[DiracOpteoEQ.IMMERSION_BOOST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DiracOpteoEQ.DIRAC_OPTEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DiracOpteoEQ.OPTEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DiracOpteoEQ.POP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DiracOpteoEQ.ROCK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DiracOpteoEQ.ELECTRONIC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DiracOpteoEQ.ENHANCE_VOCALS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DiracOpteoEQ.CLASSICAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DiracOpteoEQ.CUSTOM_EQ.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[EQ.values().length];
            try {
                iArr2[EQ.FLAT_BALANCED.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[EQ.MORE_BASE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[EQ.MORE_TREBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[EQ.VOICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[EQ.NEW_VOICE.ordinal()] = 5;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[EQ.NEW_INSTRUMENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[EQ.SIMPLE_CUSTOM_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused16) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnknownEqualizerViewModel(Application context) {
        LiveData<AdvanceCustomEQEntity> map;
        TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQMode$default;
        final TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQMode$default2;
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderAdvanceCustomEQMode$default2 = TWSDeviceExtKt.advanceCustomEQMode$default(tWSDevice, null, 1, null)) == null) {
            map = null;
        } else {
            final Class<AdvanceCustomEQEntity> cls = AdvanceCustomEQEntity.class;
            map = Transformations.map(tWSDeviceBuilderAdvanceCustomEQMode$default2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderAdvanceCustomEQMode$default2.getGetCommand(), tWSDeviceBuilderAdvanceCustomEQMode$default2.getNotifyCommand()), new Function1<Message, AdvanceCustomEQEntity>() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$special$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final AdvanceCustomEQEntity invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    AdvanceCustomEQEntity advanceCustomEQEntity = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    advanceCustomEQEntity = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.core.entity.AdvanceCustomEQEntity");
                                }
                                obj = (AdvanceCustomEQEntity) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            advanceCustomEQEntity = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            advanceCustomEQEntity = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + advanceCustomEQEntity + StringUtils.SPACE;
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
                    return advanceCustomEQEntity;
                }
            });
        }
        this.advanceCustomEQLiveData = map;
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 != null && (tWSDeviceBuilderAdvanceCustomEQMode$default = TWSDeviceExtKt.advanceCustomEQMode$default(tWSDevice2, null, 1, null)) != null) {
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderAdvanceCustomEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
        }
        getConfig();
        this.needHDACWarning = new MutableLiveData<>();
    }

    public final Application getContext() {
        return this.context;
    }

    public final LiveData<AdvanceCustomEQEntity> getAdvanceCustomEQLiveData() {
        return this.advanceCustomEQLiveData;
    }

    public final void setAdvanceCustomEQLiveData(LiveData<AdvanceCustomEQEntity> liveData) {
        this.advanceCustomEQLiveData = liveData;
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

    public final MutableLiveData<WarnEqualizerTypeViewModel> getNeedHDACWarning() {
        return this.needHDACWarning;
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void register() {
        setProtocol(new UnknownSppProtocol(getAddress()));
        super.register();
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void getEQData() {
        LiveData liveDataDistinctUntilChanged;
        final TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        List<UnknownFunction> configs;
        UnknownFunction unknownFunction;
        final TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ$default;
        if (getProductDevice() instanceof UnknownProduct) {
            IOTProductDevice productDevice = getProductDevice();
            Intrinsics.checkNotNull(productDevice, "null cannot be cast to non-null type com.nothing.earbase.unknown.device.UnknownProduct");
            UnknownConfigs configs2 = ((UnknownProduct) productDevice).getConfigs();
            if (configs2 != null && (configs = configs2.getConfigs()) != null && (unknownFunction = configs.get(0)) != null && unknownFunction.isDiracEq()) {
                TWSDevice tWSDevice = getProtocol().getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderDiracOpteoEQ$default = TWSDeviceExtKt.diracOpteoEQ$default(tWSDevice, 0, 1, null)) != null) {
                    final Class<BasicInt> cls = BasicInt.class;
                    setEQLiveData(Transformations.map(tWSDeviceBuilderDiracOpteoEQ$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderDiracOpteoEQ$default.getGetCommand(), tWSDeviceBuilderDiracOpteoEQ$default.getNotifyCommand()), new Function1<Message, BasicInt>() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$getEQData$lambda$0$$inlined$getLiveData$1
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
                    }));
                    TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderDiracOpteoEQ$default, false, (byte[]) null, 0, 7, (Object) null);
                }
            } else {
                TWSDevice tWSDevice2 = getProtocol().getTWSDevice();
                if (tWSDevice2 != null && (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice2, 0, 1, null)) != null) {
                    final Class<BasicInt> cls2 = BasicInt.class;
                    setEQLiveData(Transformations.map(tWSDeviceBuilderEQMode$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderEQMode$default.getGetCommand(), tWSDeviceBuilderEQMode$default.getNotifyCommand()), new Function1<Message, BasicInt>() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$getEQData$lambda$1$$inlined$getLiveData$1
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
                                Class cls3 = cls2;
                                try {
                                    if (Intrinsics.areEqual(cls3, Integer.TYPE)) {
                                        obj = (BasicInt) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                                    } else if (Intrinsics.areEqual(cls3, Long.TYPE)) {
                                        obj = (BasicInt) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                                    } else if (Intrinsics.areEqual(cls3, String.class)) {
                                        Object objDecodeToString = StringsKt.decodeToString(payload);
                                        if (objDecodeToString == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicInt");
                                        }
                                        obj = (BasicInt) objDecodeToString;
                                    } else if (Intrinsics.areEqual(cls3, Boolean.TYPE)) {
                                        obj = (BasicInt) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                                    } else if (Intrinsics.areEqual(cls3, Float.TYPE)) {
                                        obj = (BasicInt) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                                    } else {
                                        try {
                                            objNewInstance = cls3.getConstructor(byte[].class).newInstance(payload);
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
                            Class cls4 = cls2;
                            Logger logger2 = logger;
                            String tag = logger2.getTAG();
                            int depth = logger2.getDepth();
                            if (logger2.isCanLogger(true)) {
                                String str = "parseLiveData " + cls4 + StringUtils.SPACE + basicInt + StringUtils.SPACE;
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
                    }));
                    TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
                }
            }
        }
        LiveData<BasicInt> eQLiveData = getEQLiveData();
        if (eQLiveData == null || (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(eQLiveData)) == null) {
            return;
        }
        liveDataDistinctUntilChanged.observe(this, new UnknownEqualizerViewModelKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnknownEqualizerViewModel.getEQData$lambda$3(this.f$0, (BasicInt) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEQData$lambda$3(UnknownEqualizerViewModel unknownEqualizerViewModel, BasicInt basicInt) {
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
        int value = basicInt != null ? basicInt.getValue() : 0;
        ArrayList<EqualizerTypeViewModel> equalizerTypes = unknownEqualizerViewModel.getEqualizerTypes();
        if (equalizerTypes == null || equalizerTypes.isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new UnknownEqualizerViewModel$getEQData$3$2(unknownEqualizerViewModel, value, null), 3, null);
        } else {
            unknownEqualizerViewModel.updateEQMode(Integer.valueOf(value));
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void initSoundTypes() {
        List listSortedWith;
        Triple triple;
        int i;
        Triple triple2;
        List<UnknownFunction> configs;
        Resources localizedResources = ContextExtKt.getLocalizedResources(this.context);
        if (getProductDevice() instanceof UnknownProduct) {
            IOTProductDevice productDevice = getProductDevice();
            Intrinsics.checkNotNull(productDevice, "null cannot be cast to non-null type com.nothing.earbase.unknown.device.UnknownProduct");
            UnknownConfigs configs2 = ((UnknownProduct) productDevice).getConfigs();
            int i2 = 0;
            UnknownFunction unknownFunction = (configs2 == null || (configs = configs2.getConfigs()) == null) ? null : configs.get(0);
            if (unknownFunction == null || !unknownFunction.isDiracEq()) {
                List<EQ> eQList = unknownFunction != null ? unknownFunction.getEQList() : null;
                if (eQList != null && (listSortedWith = CollectionsKt.sortedWith(eQList, new Comparator() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$initSoundTypes$$inlined$compareBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Integer num;
                        Integer num2;
                        switch (UnknownEqualizerViewModel.WhenMappings.$EnumSwitchMapping$1[((EQ) t).ordinal()]) {
                            case 1:
                                num = (Comparable) 0;
                                break;
                            case 2:
                                num = (Comparable) 1;
                                break;
                            case 3:
                                num = (Comparable) 2;
                                break;
                            case 4:
                                num = (Comparable) 3;
                                break;
                            case 5:
                                num = (Comparable) 4;
                                break;
                            case 6:
                                num = (Comparable) 5;
                                break;
                            case 7:
                                num = (Comparable) 6;
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        switch (UnknownEqualizerViewModel.WhenMappings.$EnumSwitchMapping$1[((EQ) t2).ordinal()]) {
                            case 1:
                                num2 = (Comparable) 0;
                                break;
                            case 2:
                                num2 = (Comparable) 1;
                                break;
                            case 3:
                                num2 = (Comparable) 2;
                                break;
                            case 4:
                                num2 = (Comparable) 3;
                                break;
                            case 5:
                                num2 = (Comparable) 4;
                                break;
                            case 6:
                                num2 = (Comparable) 5;
                                break;
                            case 7:
                                num2 = (Comparable) 6;
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        return ComparisonsKt.compareValues(num, num2);
                    }
                })) != null) {
                    Iterator it = listSortedWith.iterator();
                    while (it.hasNext()) {
                        switch (WhenMappings.$EnumSwitchMapping$1[((EQ) it.next()).ordinal()]) {
                            case 1:
                                triple = new Triple(Integer.valueOf(R.string.sound_balanced), Integer.valueOf(conditionalRes(R.drawable.os_balanced, R.drawable.equalizer_balanced)), 0);
                                break;
                            case 2:
                                triple = new Triple(Integer.valueOf(R.string.sound_more_bass), Integer.valueOf(conditionalRes(R.drawable.os_bass, R.drawable.equalizer_bass)), 3);
                                break;
                            case 3:
                                triple = new Triple(Integer.valueOf(R.string.sound_more_treble), Integer.valueOf(conditionalRes(R.drawable.os_treble, R.drawable.equalizer_treble)), 2);
                                break;
                            case 4:
                                triple = new Triple(Integer.valueOf(R.string.sound_more_voice), Integer.valueOf(conditionalRes(R.drawable.os_voice, R.drawable.equalizer_voice)), 1);
                                break;
                            case 5:
                                triple = new Triple(Integer.valueOf(R.string.sound_new_voice), Integer.valueOf(conditionalRes(R.drawable.os_voice, R.drawable.equalizer_voice)), 6);
                                break;
                            case 6:
                                triple = new Triple(Integer.valueOf(R.string.sound_new_instrument), Integer.valueOf(conditionalRes(R.drawable.os_voice, R.drawable.equalizer_voice)), 7);
                                break;
                            case 7:
                                triple = new Triple(Integer.valueOf(R.string.sound_eq_custom), 0, 5);
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        int iIntValue = ((Number) triple.component1()).intValue();
                        int iIntValue2 = ((Number) triple.component2()).intValue();
                        int iIntValue3 = ((Number) triple.component3()).intValue();
                        getEqualizerTypes().add(new EqualizerTypeViewModel(String.valueOf(iIntValue3), new ObservableField(localizedResources.getString(iIntValue)), iIntValue3, iIntValue2, null, null, 0, SdkConfig.SDK_VERSION, null));
                    }
                }
                Logger logger = Logger.INSTANCE;
                Logger logger2 = Logger.INSTANCE;
                Logger logger3 = logger;
                String tag = logger3.getTAG();
                int depth = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str = "unknown_widget_eq simple size:" + getEqualizerTypes().size();
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        return;
                    }
                    Pair<String, String> trace = logger3.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        return;
                    }
                    return;
                }
                return;
            }
            Iterator it2 = CollectionsKt.sortedWith(unknownFunction.getDiracOpteoEQList(), new Comparator() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$initSoundTypes$$inlined$compareBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Integer num;
                    Integer num2;
                    switch (UnknownEqualizerViewModel.WhenMappings.$EnumSwitchMapping$0[((DiracOpteoEQ) t).ordinal()]) {
                        case 1:
                            num = (Comparable) 0;
                            break;
                        case 2:
                            num = (Comparable) 1;
                            break;
                        case 3:
                            num = (Comparable) 2;
                            break;
                        case 4:
                            num = (Comparable) 3;
                            break;
                        case 5:
                            num = (Comparable) 4;
                            break;
                        case 6:
                            num = (Comparable) 5;
                            break;
                        case 7:
                            num = (Comparable) 6;
                            break;
                        case 8:
                            num = (Comparable) 7;
                            break;
                        case 9:
                            num = (Comparable) 8;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    switch (UnknownEqualizerViewModel.WhenMappings.$EnumSwitchMapping$0[((DiracOpteoEQ) t2).ordinal()]) {
                        case 1:
                            num2 = (Comparable) 0;
                            break;
                        case 2:
                            num2 = (Comparable) 1;
                            break;
                        case 3:
                            num2 = (Comparable) 2;
                            break;
                        case 4:
                            num2 = (Comparable) 3;
                            break;
                        case 5:
                            num2 = (Comparable) 4;
                            break;
                        case 6:
                            num2 = (Comparable) 5;
                            break;
                        case 7:
                            num2 = (Comparable) 6;
                            break;
                        case 8:
                            num2 = (Comparable) 7;
                            break;
                        case 9:
                            num2 = (Comparable) 8;
                            break;
                        default:
                            throw new NoWhenBranchMatchedException();
                    }
                    return ComparisonsKt.compareValues(num, num2);
                }
            }).iterator();
            while (it2.hasNext()) {
                switch (WhenMappings.$EnumSwitchMapping$0[((DiracOpteoEQ) it2.next()).ordinal()]) {
                    case 1:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.immersion_boost), Integer.valueOf(conditionalRes(R.drawable.os_dirac_eq_cover, R.drawable.dirac_eq_cover)), new Pair(12, 8));
                        break;
                    case 2:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.dirac_eq_opteo), Integer.valueOf(conditionalRes(R.drawable.equalizer_new_dirac_eq, R.drawable.equalizer_new_dirac_eq)), new Pair(11, 7));
                        break;
                    case 3:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.dirac_eq_opteo_new), Integer.valueOf(conditionalRes(R.drawable.os_dirac_eq_cover, R.drawable.dirac_eq_cover)), new Pair(10, Integer.valueOf(i)));
                        break;
                    case 4:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.eq_advanced_genre_pop), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_pop, R.drawable.equalizer_pop)), new Pair(4, 3));
                        break;
                    case 5:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.eq_advanced_genre_rock), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_rock, R.drawable.equalizer_rock)), new Pair(6, 1));
                        break;
                    case 6:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.eq_advanced_genre_electronic), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_electronic, R.drawable.equalizer_electronic)), new Pair(7, 2));
                        break;
                    case 7:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.dirac_eq_enhance_vocals), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_vocals, R.drawable.equalizer_vocals)), new Pair(9, 4));
                        break;
                    case 8:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.eq_advanced_genre_classical), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_classical, R.drawable.equalizer_classical)), new Pair(8, 5));
                        break;
                    case 9:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.sound_eq_custom), Integer.valueOf(i2), new Pair(5, 6));
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                int iIntValue4 = ((Number) triple2.component1()).intValue();
                int iIntValue5 = ((Number) triple2.component2()).intValue();
                Pair pair = (Pair) triple2.component3();
                getEqualizerTypes().add(new EqualizerTypeViewModel(String.valueOf(((Number) pair.getFirst()).intValue()), new ObservableField(localizedResources.getString(iIntValue4)), ((Number) pair.getSecond()).intValue(), iIntValue5, null, null, 0, SdkConfig.SDK_VERSION, null));
                i2 = i;
            }
            Logger logger4 = Logger.INSTANCE;
            Logger logger5 = Logger.INSTANCE;
            Logger logger6 = logger4;
            String tag2 = logger6.getTAG();
            int depth2 = logger6.getDepth();
            if (logger6.isCanLogger(true)) {
                String str4 = "unknown_widget_eq advanced size:" + getEqualizerTypes().size();
                String str5 = str4;
                if (str5 == null || str5.length() == 0) {
                    return;
                }
                Pair<String, String> trace2 = logger6.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger6.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger6.isDebug()) {
                    Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                }
            }
        }
    }

    private final int conditionalRes(int systemRes, int normalRes) {
        return getIsSystemPage() ? systemRes : normalRes;
    }

    public final void getConfig() {
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
                    map = Transformations.map(tWSDeviceBuilderSpatialAudio$default2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default2.getGetCommand(), tWSDeviceBuilderSpatialAudio$default2.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$getConfig$lambda$12$$inlined$getLiveData$1
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
                    map2 = Transformations.map(tWSDeviceBuilderMutuallyExclusive2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderMutuallyExclusive2.getGetCommand(), tWSDeviceBuilderMutuallyExclusive2.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$getConfig$lambda$12$$inlined$getLiveData$2
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

    public final void markSpatialAudioOffLocally() {
        LiveData map;
        final TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default;
        BasicBoolean basicBoolean = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(false, false));
        LiveData<BasicBoolean> liveData = this.spatialAudioLiveData;
        MutableLiveData mutableLiveData = liveData instanceof MutableLiveData ? (MutableLiveData) liveData : null;
        if (mutableLiveData != null) {
            mutableLiveData.postValue(basicBoolean);
        }
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(tWSDevice, null, null, 3, null)) == null) {
            map = null;
        } else {
            final Class<BasicBoolean> cls = BasicBoolean.class;
            map = Transformations.map(tWSDeviceBuilderSpatialAudio$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default.getGetCommand(), tWSDeviceBuilderSpatialAudio$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$markSpatialAudioOffLocally$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final BasicBoolean invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    BasicBoolean basicBoolean2 = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    basicBoolean2 = 0;
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
                            basicBoolean2 = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            basicBoolean2 = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + basicBoolean2 + StringUtils.SPACE;
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
                    return basicBoolean2;
                }
            });
        }
        MutableLiveData mutableLiveData2 = map instanceof MutableLiveData ? (MutableLiveData) map : null;
        if (mutableLiveData2 != null) {
            mutableLiveData2.postValue(basicBoolean);
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownEqualizerViewModel$setSpatialAudioOff$1, reason: invalid class name */
    /* JADX INFO: compiled from: UnknownEqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownEqualizerViewModel$setSpatialAudioOff$1", f = "UnknownEqualizerViewModel.kt", i = {1}, l = {238, 266}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UnknownEqualizerViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00ed  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.unknown.UnknownEqualizerViewModel.AnonymousClass1.C01531(r17.this$0, null), r17) == r1) goto L21;
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
                    TWSDevice tWSDevice = UnknownEqualizerViewModel.this.getTWSDevice();
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

        /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownEqualizerViewModel$setSpatialAudioOff$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: UnknownEqualizerViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownEqualizerViewModel$setSpatialAudioOff$1$1", f = "UnknownEqualizerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UnknownEqualizerViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01531(UnknownEqualizerViewModel unknownEqualizerViewModel, Continuation<? super C01531> continuation) {
                super(2, continuation);
                this.this$0 = unknownEqualizerViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01531(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        ntEarPlugin.setPhoneSpatialAudio(address, 0L, j, new Function1() { // from class: com.nothing.earbase.unknown.UnknownEqualizerViewModel$setSpatialAudioOff$1$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return UnknownEqualizerViewModel.AnonymousClass1.C01531.invokeSuspend$lambda$0((Result) obj2);
                            }
                        });
                        this.this$0.markSpatialAudioOffLocally();
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
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
