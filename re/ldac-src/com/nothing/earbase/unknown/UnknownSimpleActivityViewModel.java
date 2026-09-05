package com.nothing.earbase.unknown;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import androidx.media3.exoplayer.RendererCapabilities;
import com.nothing.base.protocol.entity.BasicInt;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.wiget.radar.EQLabelItem;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.earbase.unknown.device.UnknownProduct;
import com.nothing.earbase.unknown.entity.DiracOpteoEQ;
import com.nothing.earbase.unknown.entity.EQ;
import com.nothing.earbase.unknown.entity.UnknownConfigs;
import com.nothing.earbase.unknown.entity.UnknownFunction;
import com.nothing.espeon.core.protocol.EspeonSppProtocol;
import com.nothing.espeon.equalizer.CenteredImageSpan;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: UnknownSimpleActivityViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 82\u00020\u0001:\u00018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\u0018\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020!H\u0002J&\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.2\u0014\u0010/\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001c\u0018\u000100H\u0016J\u000e\u00101\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.J\u0010\u00102\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016J\u0010\u00107\u001a\u0002042\u0006\u00105\u001a\u000206H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R$\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001f\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u001aR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u00069"}, d2 = {"Lcom/nothing/earbase/unknown/UnknownSimpleActivityViewModel;", "Lcom/nothing/earbase/equalizer/viewmodel/BaseEqualizerViewModel;", "context", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "diracOpteoEQLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/base/protocol/entity/BasicInt;", "eqModelLiveData", "Lcom/nothing/protocol/model/Message;", "getEqModelLiveData", "()Landroidx/lifecycle/LiveData;", "setEqModelLiveData", "(Landroidx/lifecycle/LiveData;)V", "needHDACWarning", "Landroidx/lifecycle/MutableLiveData;", "Lcom/nothing/earbase/unknown/WarnEqualizerTypeViewModel;", "getNeedHDACWarning", "()Landroidx/lifecycle/MutableLiveData;", "isCmfEq", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "()Landroidx/databinding/ObservableField;", "setPowerByTextBuilder", "", "Landroid/content/Context;", "register", "getEQData", "getDiracEQRes", "", "initSoundTypes", "conditionalRes", "systemRes", "normalRes", "eqModeJob", "Lkotlinx/coroutines/Job;", "getEqModeJob", "()Lkotlinx/coroutines/Job;", "setEqModeJob", "(Lkotlinx/coroutines/Job;)V", "setEQMode", "typeViewModel", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "action", "Lkotlin/Function1;", "sendEqModelData", "getHDACStatus", "getFreq", "", "radarItem", "Lcom/nothing/base/wiget/radar/EQLabelItem;", "getQ", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnknownSimpleActivityViewModel extends BaseEqualizerViewModel {
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
    private final Application context;
    private LiveData<BasicInt> diracOpteoEQLiveData;
    private Job eqModeJob;
    private LiveData<Message> eqModelLiveData;
    private final ObservableField<Boolean> isCmfEq;
    private final MutableLiveData<WarnEqualizerTypeViewModel> needHDACWarning;

    /* JADX INFO: compiled from: UnknownSimpleActivityViewModel.kt */
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
    public UnknownSimpleActivityViewModel(Application context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.needHDACWarning = new MutableLiveData<>();
        this.isCmfEq = new ObservableField<>(true);
    }

    public final Application getContext() {
        return this.context;
    }

    public final LiveData<Message> getEqModelLiveData() {
        return this.eqModelLiveData;
    }

    public final void setEqModelLiveData(LiveData<Message> liveData) {
        this.eqModelLiveData = liveData;
    }

    public final MutableLiveData<WarnEqualizerTypeViewModel> getNeedHDACWarning() {
        return this.needHDACWarning;
    }

    public final ObservableField<Boolean> isCmfEq() {
        return this.isCmfEq;
    }

    public final void setPowerByTextBuilder(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String string = context.getString(R.string.dirac_eq_powered_by);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, "%s", 0, false, 6, (Object) null);
        int length = "%s".length() + iIndexOf$default;
        int iDp2px = ContextExtKt.dp2px(context, 54.0f);
        int iDp2px2 = ContextExtKt.dp2px(context, 18.0f);
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.dirac_eq);
        if (drawable != null) {
            drawable.setBounds(0, 0, iDp2px, iDp2px2);
            spannableStringBuilder.setSpan(new CenteredImageSpan(drawable, 1), iIndexOf$default, length, 33);
        }
        getPowerByText().set(spannableStringBuilder);
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void register() {
        setProtocol(new EspeonSppProtocol(getAddress()));
        super.register();
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void getEQData() {
        final TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        LiveData map;
        LiveData liveDataDistinctUntilChanged;
        LiveData liveDataDistinctUntilChanged2;
        final TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ$default;
        IOTProductDevice productDevice = getProductDevice();
        if (productDevice instanceof UnknownProduct) {
            UnknownProduct unknownProduct = (UnknownProduct) productDevice;
            if (unknownProduct.isSupportDiracEq()) {
                this.isCmfEq.set(true);
                Logger logger = Logger.INSTANCE;
                Logger logger2 = Logger.INSTANCE;
                Logger logger3 = logger;
                String tag = logger3.getTAG();
                int depth = logger3.getDepth();
                if (logger3.isCanLogger(true) && "unknown_widget_eq activity viewmodel get dirac eq".length() != 0) {
                    Pair<String, String> trace = logger3.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "unknown_widget_eq activity viewmodel get dirac eq " + strComponent2, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag + strComponent1, "unknown_widget_eq activity viewmodel get dirac eq " + strComponent2);
                    }
                }
                TWSDevice tWSDevice = getProtocol().getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderDiracOpteoEQ$default = TWSDeviceExtKt.diracOpteoEQ$default(tWSDevice, 0, 1, null)) != null) {
                    final Class<BasicInt> cls = BasicInt.class;
                    this.diracOpteoEQLiveData = Transformations.map(tWSDeviceBuilderDiracOpteoEQ$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderDiracOpteoEQ$default.getGetCommand(), tWSDeviceBuilderDiracOpteoEQ$default.getNotifyCommand()), new Function1<Message, BasicInt>() { // from class: com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$getEQData$lambda$2$$inlined$getLiveData$1
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
                            Logger logger4 = Logger.INSTANCE;
                            Class cls3 = cls;
                            Logger logger5 = logger4;
                            String tag2 = logger5.getTAG();
                            int depth2 = logger5.getDepth();
                            if (logger5.isCanLogger(true)) {
                                String str2 = "parseLiveData " + cls3 + StringUtils.SPACE + basicInt + StringUtils.SPACE;
                                String str3 = str2;
                                if (str3 != null && str3.length() != 0) {
                                    Pair<String, String> trace2 = logger5.getTrace(depth2);
                                    String strComponent3 = trace2.component1();
                                    String strComponent4 = trace2.component2();
                                    FileLog fileLog2 = FileLog.INSTANCE;
                                    String str4 = logger5.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                                    FileLog.print$default(fileLog2, 4, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                                    if (logger5.isDebug()) {
                                        Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                                    }
                                }
                            }
                            return basicInt;
                        }
                    });
                    TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderDiracOpteoEQ$default, false, (byte[]) null, 0, 7, (Object) null);
                }
                LiveData<BasicInt> liveData = this.diracOpteoEQLiveData;
                if (liveData != null && (liveDataDistinctUntilChanged2 = Transformations.distinctUntilChanged(liveData)) != null) {
                    liveDataDistinctUntilChanged2.observe(this, new UnknownSimpleActivityViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return UnknownSimpleActivityViewModel.getEQData$lambda$3(this.f$0, (BasicInt) obj);
                        }
                    }));
                }
            } else {
                Logger logger4 = Logger.INSTANCE;
                Logger logger5 = Logger.INSTANCE;
                Logger logger6 = logger4;
                String tag2 = logger6.getTAG();
                int depth2 = logger6.getDepth();
                if (logger6.isCanLogger(true) && "unknown_widget_eq activity viewmodel get common eq".length() != 0) {
                    Pair<String, String> trace2 = logger6.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str2 = logger6.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    FileLog.print$default(fileLog2, 3, str2, tag2, "unknown_widget_eq activity viewmodel get common eq " + strComponent4, null, 16, null);
                    if (logger6.isDebug()) {
                        Log.i(tag2 + strComponent3, "unknown_widget_eq activity viewmodel get common eq " + strComponent4);
                    }
                }
                this.isCmfEq.set(false);
                TWSDevice tWSDevice2 = getProtocol().getTWSDevice();
                if (tWSDevice2 != null && (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice2, 0, 1, null)) != null) {
                    LiveData<Message> liveData2 = tWSDeviceBuilderEQMode$default.getLiveData();
                    this.eqModelLiveData = liveData2;
                    if (liveData2 != null && (map = Transformations.map(liveData2, new Function1() { // from class: com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return UnknownSimpleActivityViewModel.getEQData$lambda$8$lambda$5((Message) obj);
                        }
                    })) != null && (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(map)) != null) {
                        liveDataDistinctUntilChanged.observe(this, new UnknownSimpleActivityViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return UnknownSimpleActivityViewModel.getEQData$lambda$8$lambda$7(tWSDeviceBuilderEQMode$default, this, (Integer) obj);
                            }
                        }));
                    }
                    TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
                }
            }
            if (unknownProduct.diracByPowered()) {
                setPowerByTextBuilder(this.context);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEQData$lambda$3(UnknownSimpleActivityViewModel unknownSimpleActivityViewModel, BasicInt basicInt) {
        int value = basicInt != null ? basicInt.getValue() : 0;
        ArrayList<EqualizerTypeViewModel> equalizerTypes = unknownSimpleActivityViewModel.getEqualizerTypes();
        if (equalizerTypes == null || equalizerTypes.isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new UnknownSimpleActivityViewModel$getEQData$3$1(unknownSimpleActivityViewModel, value, null), 3, null);
        } else {
            unknownSimpleActivityViewModel.updateEQMode(Integer.valueOf(value));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer getEQData$lambda$8$lambda$5(Message message) {
        if (message != null) {
            return (Integer) message.obtainPayload(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEQData$lambda$8$lambda$7(TWSDeviceBuilder tWSDeviceBuilder, UnknownSimpleActivityViewModel unknownSimpleActivityViewModel, Integer num) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "Unknown EQ_MODE GET_EQ_MODE " + num;
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
        ArrayList<EqualizerTypeViewModel> equalizerTypes = unknownSimpleActivityViewModel.getEqualizerTypes();
        if (equalizerTypes == null || equalizerTypes.isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new UnknownSimpleActivityViewModel$getEQData$5$2$2(unknownSimpleActivityViewModel, num, null), 3, null);
        } else {
            unknownSimpleActivityViewModel.updateEQMode(num);
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public int getDiracEQRes() {
        if (getIsSystemPage()) {
            return R.drawable.os_dirac_eq_cover;
        }
        return R.drawable.dirac_eq_cover;
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void initSoundTypes() {
        List listSortedWith;
        Triple triple;
        boolean z;
        int i;
        Triple triple2;
        ObservableField observableField;
        int i2;
        List<UnknownFunction> configs;
        Resources localizedResources = ContextExtKt.getLocalizedResources(this.context);
        if (getProductDevice() instanceof UnknownProduct) {
            IOTProductDevice productDevice = getProductDevice();
            Intrinsics.checkNotNull(productDevice, "null cannot be cast to non-null type com.nothing.earbase.unknown.device.UnknownProduct");
            UnknownProduct unknownProduct = (UnknownProduct) productDevice;
            UnknownConfigs configs2 = unknownProduct.getConfigs();
            boolean z2 = false;
            UnknownFunction unknownFunction = (configs2 == null || (configs = configs2.getConfigs()) == null) ? null : configs.get(0);
            int i3 = 5;
            int i4 = 6;
            if (unknownFunction == null || !unknownFunction.isDiracEq()) {
                List<EQ> eQList = unknownFunction != null ? unknownFunction.getEQList() : null;
                if (eQList != null && (listSortedWith = CollectionsKt.sortedWith(eQList, new Comparator() { // from class: com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$initSoundTypes$$inlined$compareBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Integer num;
                        Integer num2;
                        switch (UnknownSimpleActivityViewModel.WhenMappings.$EnumSwitchMapping$1[((EQ) t).ordinal()]) {
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
                        switch (UnknownSimpleActivityViewModel.WhenMappings.$EnumSwitchMapping$1[((EQ) t2).ordinal()]) {
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
            for (DiracOpteoEQ diracOpteoEQ : CollectionsKt.sortedWith(unknownFunction.getDiracOpteoEQList(), new Comparator() { // from class: com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$initSoundTypes$$inlined$compareBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Integer num;
                    Integer num2;
                    switch (UnknownSimpleActivityViewModel.WhenMappings.$EnumSwitchMapping$0[((DiracOpteoEQ) t).ordinal()]) {
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
                    switch (UnknownSimpleActivityViewModel.WhenMappings.$EnumSwitchMapping$0[((DiracOpteoEQ) t2).ordinal()]) {
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
            })) {
                switch (WhenMappings.$EnumSwitchMapping$0[diracOpteoEQ.ordinal()]) {
                    case 1:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(R.string.immersion_boost), Integer.valueOf(conditionalRes(R.drawable.os_dirac_eq_cover, R.drawable.dirac_eq_cover)), new Pair(12, 8));
                        break;
                    case 2:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(R.string.dirac_eq), Integer.valueOf(conditionalRes(R.drawable.equalizer_new_dirac_eq, R.drawable.equalizer_new_dirac_eq)), new Pair(11, 7));
                        break;
                    case 3:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(unknownProduct.diracByPowered() ? R.string.dirac_eq_opteo : R.string.dirac_eq_opteo_new), Integer.valueOf(conditionalRes(R.drawable.os_dirac_eq_cover, R.drawable.dirac_eq_cover)), new Pair(10, Integer.valueOf(z ? 1 : 0)));
                        break;
                    case 4:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(R.string.eq_advanced_genre_pop), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_pop, R.drawable.equalizer_pop)), new Pair(4, 3));
                        break;
                    case 5:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(R.string.eq_advanced_genre_rock), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_rock, R.drawable.equalizer_rock)), new Pair(Integer.valueOf(i4), 1));
                        break;
                    case 6:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(R.string.eq_advanced_genre_electronic), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_electronic, R.drawable.equalizer_electronic)), new Pair(7, 2));
                        break;
                    case 7:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(R.string.dirac_eq_enhance_vocals), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_vocals, R.drawable.equalizer_vocals)), new Pair(9, 4));
                        break;
                    case 8:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(R.string.eq_advanced_genre_classical), Integer.valueOf(conditionalRes(R.drawable.os_equalizer_classical, R.drawable.equalizer_classical)), new Pair(8, Integer.valueOf(i)));
                        break;
                    case 9:
                        z = z2;
                        i = i3;
                        triple2 = new Triple(Integer.valueOf(R.string.sound_eq_custom), Integer.valueOf(z ? 1 : 0), new Pair(Integer.valueOf(i3), Integer.valueOf(i4)));
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                int iIntValue4 = ((Number) triple2.component1()).intValue();
                int iIntValue5 = ((Number) triple2.component2()).intValue();
                Pair pair = (Pair) triple2.component3();
                if (diracOpteoEQ != DiracOpteoEQ.OPTEO || unknownProduct.diracByPowered()) {
                    observableField = new ObservableField(Boolean.valueOf(z));
                } else {
                    observableField = new ObservableField(true);
                }
                ObservableField observableField2 = observableField;
                Logger logger4 = Logger.INSTANCE;
                Logger logger5 = Logger.INSTANCE;
                Logger logger6 = logger4;
                String tag2 = logger6.getTAG();
                int depth2 = logger6.getDepth();
                if (logger6.isCanLogger(true)) {
                    i2 = i4;
                    String str4 = "unknown_widget_eq diracOpteoEQ:" + diracOpteoEQ + " iconVisible :" + observableField2.get();
                    String str5 = str4;
                    if (str5 != null && str5.length() != 0) {
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
                } else {
                    i2 = i4;
                }
                getEqualizerTypes().add(new EqualizerTypeViewModel(String.valueOf(((Number) pair.getFirst()).intValue()), new ObservableField(localizedResources.getString(iIntValue4)), ((Number) pair.getSecond()).intValue(), iIntValue5, null, observableField2, 0, 80, null));
                i4 = i2;
                z2 = z;
                i3 = i;
            }
            Logger logger7 = Logger.INSTANCE;
            Logger logger8 = Logger.INSTANCE;
            Logger logger9 = logger7;
            String tag3 = logger9.getTAG();
            int depth3 = logger9.getDepth();
            if (logger9.isCanLogger(true)) {
                String str7 = "unknown_widget_eq advanced size:" + getEqualizerTypes().size();
                String str8 = str7;
                if (str8 == null || str8.length() == 0) {
                    return;
                }
                Pair<String, String> trace3 = logger9.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str9 = logger9.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger9.isDebug()) {
                    Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                }
            }
        }
    }

    private final int conditionalRes(int systemRes, int normalRes) {
        return getIsSystemPage() ? systemRes : normalRes;
    }

    public final Job getEqModeJob() {
        return this.eqModeJob;
    }

    public final void setEqModeJob(Job job) {
        this.eqModeJob = job;
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void setEQMode(EqualizerTypeViewModel typeViewModel, Function1<? super Integer, Unit> action) {
        IOTProductDevice productDevice;
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        for (EqualizerTypeViewModel equalizerTypeViewModel : getEqualizerTypes()) {
            if (Intrinsics.areEqual((Object) equalizerTypeViewModel.getSelected().get(), (Object) true) && equalizerTypeViewModel.getType() == typeViewModel.getType()) {
                return;
            }
        }
        if (typeViewModel.getType() == 0 && (productDevice = getProductDevice()) != null && productDevice.hldcOrDiracOne()) {
            getHDACStatus(typeViewModel);
        } else {
            sendEqModelData(typeViewModel);
        }
    }

    public final void sendEqModelData(EqualizerTypeViewModel typeViewModel) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        for (EqualizerTypeViewModel equalizerTypeViewModel : getEqualizerTypes()) {
            if (Intrinsics.areEqual((Object) equalizerTypeViewModel.getSelected().get(), (Object) true) && equalizerTypeViewModel.getType() == typeViewModel.getType()) {
                return;
            }
        }
        Job job = this.eqModeJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.eqModeJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(typeViewModel, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$sendEqModelData$2, reason: invalid class name */
    /* JADX INFO: compiled from: UnknownSimpleActivityViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$sendEqModelData$2", f = "UnknownSimpleActivityViewModel.kt", i = {0, 1}, l = {RendererCapabilities.DECODER_SUPPORT_MASK, 419, 303}, m = "invokeSuspend", n = {"needUpdate$iv", "needUpdate$iv"}, s = {"I$0", "I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ UnknownSimpleActivityViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(EqualizerTypeViewModel equalizerTypeViewModel, UnknownSimpleActivityViewModel unknownSimpleActivityViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$typeViewModel = equalizerTypeViewModel;
            this.this$0 = unknownSimpleActivityViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$typeViewModel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:51:0x014c  */
        /* JADX WARN: Code duplicated, block: B:76:0x01f4  */
        /* JADX WARN: Code duplicated, block: B:77:0x01f9  */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x021a, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.unknown.UnknownSimpleActivityViewModel.AnonymousClass2.AnonymousClass1(r2, r21.this$0, r21.$typeViewModel, null), r21) == r1) goto L80;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderEQMode;
            Object objSyncSetResponse$default;
            TWSDeviceBuilder tWSDeviceBuilder;
            EqualizerTypeViewModel equalizerTypeViewModel;
            int i;
            Boolean boolBoxBoolean;
            TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ;
            Object objSyncSetResponse$default2;
            TWSDeviceBuilder tWSDeviceBuilder2;
            UnknownSimpleActivityViewModel unknownSimpleActivityViewModel;
            EqualizerTypeViewModel equalizerTypeViewModel2;
            int i2;
            Message message;
            BasicInt basicInt;
            BasicInt basicInt2;
            Message message2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                AppBuriedPointUtils.INSTANCE.reportUserData(new EventParams(AppBuriedPointUtils.CHANGE_EQ_EVENT, this.$typeViewModel.getReportType(), AppBuriedPointUtils.VALUE_TYPE_INT), this.this$0.getIsSystemPage());
                IOTProductDevice productDevice = this.this$0.getProductDevice();
                if (productDevice instanceof UnknownProduct) {
                    if (((UnknownProduct) productDevice).isSupportDiracEq()) {
                        TWSDevice tWSDevice = this.this$0.getProtocol().getTWSDevice();
                        if (tWSDevice == null || (tWSDeviceBuilderDiracOpteoEQ = TWSDeviceExtKt.diracOpteoEQ(tWSDevice, this.$typeViewModel.getType())) == null) {
                            boolBoxBoolean = null;
                        } else {
                            UnknownSimpleActivityViewModel unknownSimpleActivityViewModel2 = this.this$0;
                            EqualizerTypeViewModel equalizerTypeViewModel3 = this.$typeViewModel;
                            int setCommand = tWSDeviceBuilderDiracOpteoEQ.getSetCommand();
                            this.L$0 = tWSDeviceBuilderDiracOpteoEQ;
                            this.L$1 = unknownSimpleActivityViewModel2;
                            this.L$2 = equalizerTypeViewModel3;
                            this.I$0 = 1;
                            this.label = 1;
                            objSyncSetResponse$default2 = TWSDevice.syncSetResponse$default(tWSDeviceBuilderDiracOpteoEQ.getTwsDevice(), setCommand, tWSDeviceBuilderDiracOpteoEQ.getSetPayload(), tWSDeviceBuilderDiracOpteoEQ.getTimeOut(), tWSDeviceBuilderDiracOpteoEQ.getIsNeedFsn(), false, tWSDeviceBuilderDiracOpteoEQ.getMockResponse(), this, 16, null);
                            if (objSyncSetResponse$default2 != coroutine_suspended) {
                                tWSDeviceBuilder2 = tWSDeviceBuilderDiracOpteoEQ;
                                unknownSimpleActivityViewModel = unknownSimpleActivityViewModel2;
                                equalizerTypeViewModel2 = equalizerTypeViewModel3;
                                i2 = 1;
                                message = (Message) objSyncSetResponse$default2;
                                if (message == null) {
                                    boolBoxBoolean = Boxing.boxBoolean(false);
                                } else {
                                    boolBoxBoolean = Boxing.boxBoolean(false);
                                }
                            }
                        }
                    } else {
                        TWSDevice tWSDevice2 = this.this$0.getTWSDevice();
                        if (tWSDevice2 == null || (tWSDeviceBuilderEQMode = TWSDeviceExtKt.eQMode(tWSDevice2, this.$typeViewModel.getType())) == null) {
                            boolBoxBoolean = null;
                        } else {
                            EqualizerTypeViewModel equalizerTypeViewModel4 = this.$typeViewModel;
                            int setCommand2 = tWSDeviceBuilderEQMode.getSetCommand();
                            this.L$0 = tWSDeviceBuilderEQMode;
                            this.L$1 = equalizerTypeViewModel4;
                            this.I$0 = 1;
                            this.label = 2;
                            objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderEQMode.getTwsDevice(), setCommand2, tWSDeviceBuilderEQMode.getSetPayload(), tWSDeviceBuilderEQMode.getTimeOut(), tWSDeviceBuilderEQMode.getIsNeedFsn(), false, tWSDeviceBuilderEQMode.getMockResponse(), this, 16, null);
                            if (objSyncSetResponse$default != coroutine_suspended) {
                                tWSDeviceBuilder = tWSDeviceBuilderEQMode;
                                equalizerTypeViewModel = equalizerTypeViewModel4;
                                i = 1;
                                message2 = (Message) objSyncSetResponse$default;
                                if (message2 == null) {
                                    boolBoxBoolean = Boxing.boxBoolean(false);
                                } else {
                                    boolBoxBoolean = Boxing.boxBoolean(false);
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i3 == 1) {
                int i4 = this.I$0;
                EqualizerTypeViewModel equalizerTypeViewModel5 = (EqualizerTypeViewModel) this.L$2;
                UnknownSimpleActivityViewModel unknownSimpleActivityViewModel3 = (UnknownSimpleActivityViewModel) this.L$1;
                TWSDeviceBuilder tWSDeviceBuilder3 = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDeviceBuilder2 = tWSDeviceBuilder3;
                unknownSimpleActivityViewModel = unknownSimpleActivityViewModel3;
                equalizerTypeViewModel2 = equalizerTypeViewModel5;
                i2 = i4;
                objSyncSetResponse$default2 = obj;
                message = (Message) objSyncSetResponse$default2;
                if (message == null && message.isOk()) {
                    LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder2.getTwsDevice().getCommandCache(), tWSDeviceBuilder2.getGetCommand(), 0, 2, null);
                    LiveData liveData = unknownSimpleActivityViewModel.diracOpteoEQLiveData;
                    if (liveData != null && (basicInt2 = (BasicInt) liveData.getValue()) != null) {
                        basicInt2.setValue(equalizerTypeViewModel2.getType());
                    }
                    LiveData liveData2 = unknownSimpleActivityViewModel.diracOpteoEQLiveData;
                    byte[] bArrObtainDataPacket = (liveData2 == null || (basicInt = (BasicInt) liveData2.getValue()) == null) ? null : basicInt.obtainDataPacket();
                    Message message3 = (Message) liveDataCommand$default.getValue();
                    if (!Arrays.equals(message3 != null ? message3.getPayload() : null, bArrObtainDataPacket)) {
                        tWSDeviceBuilder2.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder2.getGetCommand(), bArrObtainDataPacket);
                        if (message3 != null) {
                            message3.setPayload(bArrObtainDataPacket);
                            if (i2 != 0) {
                                tWSDeviceBuilder2.getTwsDevice().onUpdate(tWSDeviceBuilder2.getGetCommand(), message3);
                            }
                        }
                    }
                    boolBoxBoolean = Boxing.boxBoolean(true);
                } else {
                    boolBoxBoolean = Boxing.boxBoolean(false);
                }
            } else if (i3 == 2) {
                int i5 = this.I$0;
                EqualizerTypeViewModel equalizerTypeViewModel6 = (EqualizerTypeViewModel) this.L$1;
                TWSDeviceBuilder tWSDeviceBuilder4 = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDeviceBuilder = tWSDeviceBuilder4;
                equalizerTypeViewModel = equalizerTypeViewModel6;
                i = i5;
                objSyncSetResponse$default = obj;
                message2 = (Message) objSyncSetResponse$default;
                if (message2 == null && message2.isOk()) {
                    LiveData liveDataCommand$default2 = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                    byte[] byteArray$default = DataExtKt.toByteArray$default(equalizerTypeViewModel.getType(), 0, 1, (Object) null);
                    Message message4 = (Message) liveDataCommand$default2.getValue();
                    if (!Arrays.equals(message4 != null ? message4.getPayload() : null, byteArray$default)) {
                        tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), byteArray$default);
                        if (message4 != null) {
                            message4.setPayload(byteArray$default);
                            if (i != 0) {
                                tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message4);
                            }
                        }
                    }
                    boolBoxBoolean = Boxing.boxBoolean(true);
                } else {
                    boolBoxBoolean = Boxing.boxBoolean(false);
                }
            } else {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 3;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$sendEqModelData$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: UnknownSimpleActivityViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleActivityViewModel$sendEqModelData$2$1", f = "UnknownSimpleActivityViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Boolean $success;
            final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
            int label;
            final /* synthetic */ UnknownSimpleActivityViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Boolean bool, UnknownSimpleActivityViewModel unknownSimpleActivityViewModel, EqualizerTypeViewModel equalizerTypeViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$success = bool;
                this.this$0 = unknownSimpleActivityViewModel;
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

    private final void getHDACStatus(EqualizerTypeViewModel typeViewModel) {
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new UnknownSimpleActivityViewModel$getHDACStatus$1$1(tWSDevice, this, typeViewModel, null), 2, null);
        }
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public float getFreq(EQLabelItem radarItem) {
        Intrinsics.checkNotNullParameter(radarItem, "radarItem");
        int type = radarItem.getType();
        if (type == 0) {
            return 140.0f;
        }
        if (type != 1) {
            return type != 2 ? 140.0f : 3500.0f;
        }
        return 980.0f;
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public float getQ(EQLabelItem radarItem) {
        Intrinsics.checkNotNullParameter(radarItem, "radarItem");
        int type = radarItem.getType();
        if (type == 0) {
            return 0.8f;
        }
        if (type != 1) {
            return type != 2 ? 0.8f : 1.0f;
        }
        return 0.66f;
    }
}
