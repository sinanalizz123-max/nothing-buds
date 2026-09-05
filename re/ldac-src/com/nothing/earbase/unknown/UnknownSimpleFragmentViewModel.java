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
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.BasicBoolean;
import com.nothing.base.protocol.entity.BasicInt;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.util.ext.ViewModelExtKt;
import com.nothing.base.wiget.radar.EQLabelItem;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.BaseAndroidLifecycleViewModel;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.entity.CustomEQ;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.earbase.unknown.device.UnknownProduct;
import com.nothing.earbase.unknown.entity.DiracOpteoEQ;
import com.nothing.earbase.unknown.entity.EQ;
import com.nothing.earbase.unknown.entity.UnknownConfigs;
import com.nothing.earbase.unknown.entity.UnknownFunction;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
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
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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

/* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 S2\u00020\u0001:\u0001SB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010?J\u0006\u0010@\u001a\u00020=J\u001e\u0010A\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0006\u0012\u0004\u0018\u0001060BH\u0086@\u00a2\u0006\u0002\u0010CJ\u0006\u0010D\u001a\u00020=J\u000e\u0010E\u001a\u00020=2\u0006\u0010F\u001a\u00020\u0010J&\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020\b2\u0014\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020=\u0018\u00010JH\u0016J\u0010\u0010G\u001a\u00020=2\u0006\u0010H\u001a\u00020\bH\u0016J\u0006\u0010K\u001a\u00020=J\u0010\u0010L\u001a\u00020=2\u0006\u0010M\u001a\u00020\u0010H\u0016J\u0006\u0010N\u001a\u00020=J\b\u0010O\u001a\u00020=H\u0016J\u0018\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020\u0010H\u0002R*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0018\u0010!\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u0012\u0012\u0004\u0012\u00020%0\u0007j\b\u0012\u0004\u0012\u00020%`\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0(0'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001f\u00103\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100'\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010*R$\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u00100\"\u0004\b8\u00102R$\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u000106\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00100\"\u0004\b;\u00102\u00a8\u0006T"}, d2 = {"Lcom/nothing/earbase/unknown/UnknownSimpleFragmentViewModel;", "Lcom/nothing/device/BaseAndroidLifecycleViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "equalizerTypes", "Ljava/util/ArrayList;", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "Lkotlin/collections/ArrayList;", "getEqualizerTypes", "()Ljava/util/ArrayList;", "setEqualizerTypes", "(Ljava/util/ArrayList;)V", "radarResId", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getRadarResId", "()Landroidx/databinding/ObservableField;", "setRadarResId", "(Landroidx/databinding/ObservableField;)V", "isSystemPage", "", "()Z", "setSystemPage", "(Z)V", "eqModeJob", "Lkotlinx/coroutines/Job;", "getEqModeJob", "()Lkotlinx/coroutines/Job;", "setEqModeJob", "(Lkotlinx/coroutines/Job;)V", "diracOpteoEQLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/base/protocol/entity/BasicInt;", "radarItemList", "Lcom/nothing/base/wiget/radar/EQLabelItem;", "customEqState", "Landroidx/lifecycle/MutableLiveData;", "", "getCustomEqState", "()Landroidx/lifecycle/MutableLiveData;", "setCustomEqState", "(Landroidx/lifecycle/MutableLiveData;)V", "eqModelLiveData", "Lcom/nothing/protocol/model/Message;", "getEqModelLiveData", "()Landroidx/lifecycle/LiveData;", "setEqModelLiveData", "(Landroidx/lifecycle/LiveData;)V", "needHDACWarning", "getNeedHDACWarning", "spatialAudioLiveData", "Lcom/nothing/base/protocol/entity/BasicBoolean;", "getSpatialAudioLiveData", "setSpatialAudioLiveData", "earMutuallyExclusiveLiveData", "getEarMutuallyExclusiveLiveData", "setEarMutuallyExclusiveLiveData", "updateEQMode", "", "eqMode", "(Ljava/lang/Integer;)V", "getConfig", "syncSpatialStateForEq", "Lkotlin/Pair;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markSpatialAudioOffLocally", "onRequestData", "loadStatus", "setEQMode", "typeViewModel", "action", "Lkotlin/Function1;", "setSpatialAudioOff", "setCustomEQ", "index", "checkLDACStatus", "initSoundTypes", "conditionalRes", "systemRes", "normalRes", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class UnknownSimpleFragmentViewModel extends BaseAndroidLifecycleViewModel {
    public static final long DELAY_TIME = 300;
    private MutableLiveData<List<EQLabelItem>> customEqState;
    private LiveData<BasicInt> diracOpteoEQLiveData;
    private LiveData<BasicBoolean> earMutuallyExclusiveLiveData;
    private Job eqModeJob;
    private LiveData<Message> eqModelLiveData;
    private ArrayList<EqualizerTypeViewModel> equalizerTypes;
    private boolean isSystemPage;
    private final MutableLiveData<Integer> needHDACWarning;
    private ArrayList<EQLabelItem> radarItemList;
    private ObservableField<Integer> radarResId;
    private LiveData<BasicBoolean> spatialAudioLiveData;

    /* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
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

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$syncSpatialStateForEq$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel", f = "UnknownSimpleFragmentViewModel.kt", i = {0, 0, 0, 1, 1}, l = {200, 209}, m = "syncSpatialStateForEq", n = {"this", "product", "tws", "this", "spatialPayload"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class C07201 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C07201(Continuation<? super C07201> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UnknownSimpleFragmentViewModel.this.syncSpatialStateForEq(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnknownSimpleFragmentViewModel(Application application) {
        final TWSDeviceBuilder tWSDeviceBuilderCustomEQValue;
        final TWSDeviceBuilder tWSDeviceBuilderEQMode$default;
        LiveData map;
        LiveData liveDataDistinctUntilChanged;
        LiveData liveDataDistinctUntilChanged2;
        final TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ$default;
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
        IOTProductDevice productDevice = getProductDevice();
        if (productDevice instanceof UnknownProduct) {
            if (((UnknownProduct) productDevice).isSupportDiracEq()) {
                Logger logger = Logger.INSTANCE;
                Logger logger2 = Logger.INSTANCE;
                Logger logger3 = logger;
                String tag = logger3.getTAG();
                int depth = logger3.getDepth();
                if (logger3.isCanLogger(true) && "unknown_widget_eq fragment viewmodel get dirac eq".length() != 0) {
                    Pair<String, String> trace = logger3.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "unknown_widget_eq fragment viewmodel get dirac eq " + strComponent2, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag + strComponent1, "unknown_widget_eq fragment viewmodel get dirac eq " + strComponent2);
                    }
                }
                TWSDevice tWSDevice = getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderDiracOpteoEQ$default = TWSDeviceExtKt.diracOpteoEQ$default(tWSDevice, 0, 1, null)) != null) {
                    final Class<BasicInt> cls = BasicInt.class;
                    this.diracOpteoEQLiveData = Transformations.map(tWSDeviceBuilderDiracOpteoEQ$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderDiracOpteoEQ$default.getGetCommand(), tWSDeviceBuilderDiracOpteoEQ$default.getNotifyCommand()), new Function1<Message, BasicInt>() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$_init_$lambda$1$$inlined$getLiveData$1
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
                    liveDataDistinctUntilChanged2.observe(this, new UnknownSimpleFragmentViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return UnknownSimpleFragmentViewModel._init_$lambda$2(this.f$0, (BasicInt) obj);
                        }
                    }));
                }
            } else {
                Logger logger4 = Logger.INSTANCE;
                Logger logger5 = Logger.INSTANCE;
                Logger logger6 = logger4;
                String tag2 = logger6.getTAG();
                int depth2 = logger6.getDepth();
                if (logger6.isCanLogger(true) && "unknown_widget_eq fragment viewmodel get common eq".length() != 0) {
                    Pair<String, String> trace2 = logger6.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str2 = logger6.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    FileLog.print$default(fileLog2, 3, str2, tag2, "unknown_widget_eq fragment viewmodel get common eq " + strComponent4, null, 16, null);
                    if (logger6.isDebug()) {
                        Log.i(tag2 + strComponent3, "unknown_widget_eq fragment viewmodel get common eq " + strComponent4);
                    }
                }
                TWSDevice tWSDevice2 = getTWSDevice();
                if (tWSDevice2 != null && (tWSDeviceBuilderEQMode$default = TWSDeviceExtKt.eQMode$default(tWSDevice2, 0, 1, null)) != null) {
                    LiveData<Message> liveData2 = tWSDeviceBuilderEQMode$default.getLiveData();
                    this.eqModelLiveData = liveData2;
                    if (liveData2 != null && (map = Transformations.map(liveData2, new Function1() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return UnknownSimpleFragmentViewModel.lambda$7$lambda$4((Message) obj);
                        }
                    })) != null && (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(map)) != null) {
                        liveDataDistinctUntilChanged.observe(this, new UnknownSimpleFragmentViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return UnknownSimpleFragmentViewModel.lambda$7$lambda$6(tWSDeviceBuilderEQMode$default, this, (Integer) obj);
                            }
                        }));
                    }
                    TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
                }
            }
        }
        TWSDevice tWSDevice3 = getTWSDevice();
        if (tWSDevice3 != null && (tWSDeviceBuilderCustomEQValue = TWSDeviceExtKt.customEQValue(tWSDevice3)) != null) {
            final Class<CustomEQ> cls2 = CustomEQ.class;
            Transformations.map(tWSDeviceBuilderCustomEQValue.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderCustomEQValue.getGetCommand(), tWSDeviceBuilderCustomEQValue.getNotifyCommand()), new Function1<Message, CustomEQ>() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$_init_$lambda$13$$inlined$getLiveData$1
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
                        Class cls3 = cls2;
                        try {
                            if (Intrinsics.areEqual(cls3, Integer.TYPE)) {
                                obj = (CustomEQ) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls3, Long.TYPE)) {
                                obj = (CustomEQ) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls3, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.equalizer.entity.CustomEQ");
                                }
                                obj = (CustomEQ) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls3, Boolean.TYPE)) {
                                obj = (CustomEQ) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls3, Float.TYPE)) {
                                obj = (CustomEQ) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls3.getConstructor(byte[].class).newInstance(payload);
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
                    Logger logger7 = Logger.INSTANCE;
                    Class cls4 = cls2;
                    Logger logger8 = logger7;
                    String tag3 = logger8.getTAG();
                    int depth3 = logger8.getDepth();
                    if (logger8.isCanLogger(true)) {
                        String str3 = "parseLiveData " + cls4 + StringUtils.SPACE + customEQ + StringUtils.SPACE;
                        String str4 = str3;
                        if (str4 != null && str4.length() != 0) {
                            Pair<String, String> trace3 = logger8.getTrace(depth3);
                            String strComponent5 = trace3.component1();
                            String strComponent6 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str5 = logger8.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                            FileLog.print$default(fileLog3, 4, str5, tag3, str3 + StringUtils.SPACE + strComponent6, null, 16, null);
                            if (logger8.isDebug()) {
                                Log.i(tag3 + strComponent5, str3 + StringUtils.SPACE + strComponent6);
                            }
                        }
                    }
                    return customEQ;
                }
            }).observe(this, new UnknownSimpleFragmentViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return UnknownSimpleFragmentViewModel.lambda$13$lambda$12(this.f$0, tWSDeviceBuilderCustomEQValue, (CustomEQ) obj);
                }
            }));
        }
        getConfig();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$2(UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel, BasicInt basicInt) {
        int value = basicInt != null ? basicInt.getValue() : 0;
        ArrayList<EqualizerTypeViewModel> arrayList = unknownSimpleFragmentViewModel.equalizerTypes;
        if (arrayList == null || arrayList.isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new UnknownSimpleFragmentViewModel$3$1(unknownSimpleFragmentViewModel, value, null), 3, null);
        } else {
            unknownSimpleFragmentViewModel.updateEQMode(Integer.valueOf(value));
        }
        return Unit.INSTANCE;
    }

    static final Integer lambda$7$lambda$4(Message message) {
        if (message != null) {
            return (Integer) message.obtainPayload(Integer.TYPE);
        }
        return null;
    }

    static final Unit lambda$7$lambda$6(TWSDeviceBuilder tWSDeviceBuilder, UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel, Integer num) {
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
        ArrayList<EqualizerTypeViewModel> arrayList = unknownSimpleFragmentViewModel.equalizerTypes;
        if (arrayList == null || arrayList.isEmpty()) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new UnknownSimpleFragmentViewModel$5$2$2(unknownSimpleFragmentViewModel, num, null), 3, null);
        } else {
            unknownSimpleFragmentViewModel.updateEQMode(num);
        }
        return Unit.INSTANCE;
    }

    static final Unit lambda$13$lambda$12(UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel, TWSDeviceBuilder tWSDeviceBuilder, CustomEQ customEQ) {
        List<CustomEQ.EQ> values = customEQ != null ? customEQ.getValues() : null;
        List<CustomEQ.EQ> list = values;
        if (list == null || list.isEmpty()) {
            Iterator<T> it = unknownSimpleFragmentViewModel.radarItemList.iterator();
            while (it.hasNext()) {
                ((EQLabelItem) it.next()).setGain(0.0f);
            }
        } else {
            for (CustomEQ.EQ eq : values) {
                for (EQLabelItem eQLabelItem : unknownSimpleFragmentViewModel.radarItemList) {
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
        unknownSimpleFragmentViewModel.customEqState.postValue(unknownSimpleFragmentViewModel.radarItemList);
        return Unit.INSTANCE;
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
                    map = Transformations.map(tWSDeviceBuilderSpatialAudio$default2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default2.getGetCommand(), tWSDeviceBuilderSpatialAudio$default2.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$getConfig$lambda$20$$inlined$getLiveData$1
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
                    map2 = Transformations.map(tWSDeviceBuilderMutuallyExclusive2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderMutuallyExclusive2.getGetCommand(), tWSDeviceBuilderMutuallyExclusive2.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$getConfig$lambda$20$$inlined$getLiveData$2
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

    /* JADX WARN: Code duplicated, block: B:79:0x018e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code duplicated, block: B:80:0x0198  */
    /* JADX WARN: Code duplicated, block: B:82:0x019b  */
    /* JADX WARN: Code duplicated, block: B:84:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:87:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:90:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:92:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:93:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:98:0x01dc  */
    public final Object syncSpatialStateForEq(Continuation<? super Pair<BasicBoolean, BasicBoolean>> continuation) {
        C07201 c07201;
        TWSDevice tWSDevice;
        LiveData<BasicBoolean> map;
        LiveData<BasicBoolean> map2;
        IOTProductDevice iOTProductDevice;
        UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel;
        BasicBoolean value;
        BasicBoolean value2;
        BasicBoolean basicBoolean;
        UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel2;
        LiveData<BasicBoolean> liveData;
        LiveData<BasicBoolean> liveData2;
        Message message;
        BasicBoolean basicBoolean2;
        LiveData<BasicBoolean> liveData3;
        MutableLiveData mutableLiveData;
        if (continuation instanceof C07201) {
            c07201 = (C07201) continuation;
            if ((c07201.label & Integer.MIN_VALUE) != 0) {
                c07201.label -= Integer.MIN_VALUE;
            } else {
                c07201 = new C07201(continuation);
            }
        } else {
            c07201 = new C07201(continuation);
        }
        C07201 c07202 = c07201;
        Object obj = c07202.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c07202.label;
        BasicBoolean value3 = null;
        if (i != 0) {
            if (i == 1) {
                tWSDevice = (TWSDevice) c07202.L$2;
                iOTProductDevice = (IOTProductDevice) c07202.L$1;
                UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel3 = (UnknownSimpleFragmentViewModel) c07202.L$0;
                ResultKt.throwOnFailure(obj);
                unknownSimpleFragmentViewModel = unknownSimpleFragmentViewModel3;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                basicBoolean = (BasicBoolean) c07202.L$1;
                unknownSimpleFragmentViewModel2 = (UnknownSimpleFragmentViewModel) c07202.L$0;
                ResultKt.throwOnFailure(obj);
            }
            message = (Message) obj;
            if (message != null) {
                value2 = (BasicBoolean) message.obtainPayload(BasicBoolean.class);
            } else {
                value2 = null;
            }
            if (value2 != null) {
                basicBoolean2 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(value2.getOpen(), Boxing.boxBoolean(false)));
                liveData3 = unknownSimpleFragmentViewModel2.earMutuallyExclusiveLiveData;
                if (liveData3 instanceof MutableLiveData) {
                    mutableLiveData = (MutableLiveData) liveData3;
                } else {
                    mutableLiveData = null;
                }
                if (mutableLiveData != null) {
                    mutableLiveData.postValue(basicBoolean2);
                }
            }
            value = basicBoolean;
            unknownSimpleFragmentViewModel = unknownSimpleFragmentViewModel2;
            if (value == null) {
                liveData2 = unknownSimpleFragmentViewModel.spatialAudioLiveData;
                if (liveData2 != null) {
                    value = liveData2.getValue();
                } else {
                    value = null;
                }
            }
            if (value2 == null) {
                liveData = unknownSimpleFragmentViewModel.earMutuallyExclusiveLiveData;
                if (liveData != null) {
                    value3 = liveData.getValue();
                }
            } else {
                value3 = value2;
            }
            return TuplesKt.to(value, value3);
        }
        ResultKt.throwOnFailure(obj);
        IOTProductDevice productDevice = getProductDevice();
        if (productDevice == null) {
            LiveData<BasicBoolean> liveData4 = this.spatialAudioLiveData;
            BasicBoolean value4 = liveData4 != null ? liveData4.getValue() : null;
            LiveData<BasicBoolean> liveData5 = this.earMutuallyExclusiveLiveData;
            return TuplesKt.to(value4, liveData5 != null ? liveData5.getValue() : null);
        }
        if (!productDevice.eqMutuallyExclusive() && !productDevice.spaceEqExclusive()) {
            LiveData<BasicBoolean> liveData6 = this.spatialAudioLiveData;
            BasicBoolean value5 = liveData6 != null ? liveData6.getValue() : null;
            LiveData<BasicBoolean> liveData7 = this.earMutuallyExclusiveLiveData;
            return TuplesKt.to(value5, liveData7 != null ? liveData7.getValue() : null);
        }
        tWSDevice = getTWSDevice();
        if (tWSDevice == null) {
            return TuplesKt.to(null, null);
        }
        final TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(tWSDevice, null, null, 3, null);
        if (tWSDeviceBuilderSpatialAudio$default != null) {
            final Class<BasicBoolean> cls = BasicBoolean.class;
            map = Transformations.map(tWSDeviceBuilderSpatialAudio$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default.getGetCommand(), tWSDeviceBuilderSpatialAudio$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$syncSpatialStateForEq$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final BasicBoolean invoke(Message message2) {
                    byte[] payload;
                    Object obj2;
                    BasicBoolean basicBoolean3 = 0;
                    Object obj3 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    basicBoolean3 = 0;
                    if (message2 != null && (payload = message2.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj2 = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj2 = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                }
                                obj2 = (BasicBoolean) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj2 = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj2 = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj3 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj2 = obj3;
                            }
                            basicBoolean3 = obj2;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            basicBoolean3 = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + basicBoolean3 + StringUtils.SPACE;
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
                    return basicBoolean3;
                }
            });
        } else {
            map = null;
        }
        this.spatialAudioLiveData = map;
        final TWSDeviceBuilder tWSDeviceBuilderMutuallyExclusive = TWSDeviceExtKt.mutuallyExclusive(tWSDevice);
        if (tWSDeviceBuilderMutuallyExclusive != null) {
            final Class<BasicBoolean> cls2 = BasicBoolean.class;
            map2 = Transformations.map(tWSDeviceBuilderMutuallyExclusive.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderMutuallyExclusive.getGetCommand(), tWSDeviceBuilderMutuallyExclusive.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$syncSpatialStateForEq$$inlined$getLiveData$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final BasicBoolean invoke(Message message2) {
                    byte[] payload;
                    Object obj2;
                    BasicBoolean basicBoolean3 = 0;
                    Object obj3 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    basicBoolean3 = 0;
                    if (message2 != null && (payload = message2.getPayload()) != null) {
                        Class cls3 = cls2;
                        try {
                            if (Intrinsics.areEqual(cls3, Integer.TYPE)) {
                                obj2 = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls3, Long.TYPE)) {
                                obj2 = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls3, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                }
                                obj2 = (BasicBoolean) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls3, Boolean.TYPE)) {
                                obj2 = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls3, Float.TYPE)) {
                                obj2 = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls3.getConstructor(byte[].class).newInstance(payload);
                                    obj3 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj2 = obj3;
                            }
                            basicBoolean3 = obj2;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            basicBoolean3 = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls4 = cls2;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls4 + StringUtils.SPACE + basicBoolean3 + StringUtils.SPACE;
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
                    return basicBoolean3;
                }
            });
        } else {
            map2 = null;
        }
        this.earMutuallyExclusiveLiveData = map2;
        c07202.L$0 = this;
        c07202.L$1 = productDevice;
        c07202.L$2 = tWSDevice;
        c07202.label = 1;
        Object objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_SPATIAL_AUDIO, null, false, false, null, null, c07202, 62, null);
        if (objSendMessageSync$default != coroutine_suspended) {
            iOTProductDevice = productDevice;
            obj = objSendMessageSync$default;
            unknownSimpleFragmentViewModel = this;
        }
        return coroutine_suspended;
        Message message2 = (Message) obj;
        value = message2 != null ? (BasicBoolean) message2.obtainPayload(BasicBoolean.class) : null;
        if (value != null) {
            BasicBoolean basicBoolean3 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(value.getOpen(), Boxing.boxBoolean(value.getHead())));
            LiveData<BasicBoolean> liveData8 = unknownSimpleFragmentViewModel.spatialAudioLiveData;
            MutableLiveData mutableLiveData2 = liveData8 instanceof MutableLiveData ? (MutableLiveData) liveData8 : null;
            if (mutableLiveData2 != null) {
                mutableLiveData2.postValue(basicBoolean3);
            }
        }
        LiveData<BasicBoolean> liveData9 = unknownSimpleFragmentViewModel.earMutuallyExclusiveLiveData;
        value2 = liveData9 != null ? liveData9.getValue() : null;
        if (iOTProductDevice.spaceEqExclusive()) {
            Long lBoxLong = Boxing.boxLong(300L);
            c07202.L$0 = unknownSimpleFragmentViewModel;
            c07202.L$1 = value;
            c07202.L$2 = null;
            c07202.label = 2;
            Object objSendMessageSync$default2 = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_MUTUALLY_EXCLUSIVE, null, false, false, lBoxLong, null, c07202, 46, null);
            if (objSendMessageSync$default2 != coroutine_suspended) {
                basicBoolean = value;
                obj = objSendMessageSync$default2;
                unknownSimpleFragmentViewModel2 = unknownSimpleFragmentViewModel;
                message = (Message) obj;
                if (message != null) {
                    value2 = (BasicBoolean) message.obtainPayload(BasicBoolean.class);
                } else {
                    value2 = null;
                }
                if (value2 != null) {
                    basicBoolean2 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(value2.getOpen(), Boxing.boxBoolean(false)));
                    liveData3 = unknownSimpleFragmentViewModel2.earMutuallyExclusiveLiveData;
                    if (liveData3 instanceof MutableLiveData) {
                        mutableLiveData = (MutableLiveData) liveData3;
                    } else {
                        mutableLiveData = null;
                    }
                    if (mutableLiveData != null) {
                        mutableLiveData.postValue(basicBoolean2);
                    }
                }
                value = basicBoolean;
                unknownSimpleFragmentViewModel = unknownSimpleFragmentViewModel2;
            }
            return coroutine_suspended;
        }
        if (value == null) {
            liveData2 = unknownSimpleFragmentViewModel.spatialAudioLiveData;
            if (liveData2 != null) {
                value = liveData2.getValue();
            } else {
                value = null;
            }
        }
        if (value2 == null) {
            liveData = unknownSimpleFragmentViewModel.earMutuallyExclusiveLiveData;
            if (liveData != null) {
                value3 = liveData.getValue();
            }
        } else {
            value3 = value2;
        }
        return TuplesKt.to(value, value3);
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
            map = Transformations.map(tWSDeviceBuilderSpatialAudio$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default.getGetCommand(), tWSDeviceBuilderSpatialAudio$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$markSpatialAudioOffLocally$$inlined$getLiveData$1
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
        this.eqModeJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C07182(typeViewModel, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setEQMode$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setEQMode$2", f = "UnknownSimpleFragmentViewModel.kt", i = {0, 1}, l = {455, 490, 267}, m = "invokeSuspend", n = {"needUpdate$iv", "needUpdate$iv"}, s = {"I$0", "I$0"})
    static final class C07182 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ UnknownSimpleFragmentViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07182(EqualizerTypeViewModel equalizerTypeViewModel, UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel, Continuation<? super C07182> continuation) {
            super(2, continuation);
            this.$typeViewModel = equalizerTypeViewModel;
            this.this$0 = unknownSimpleFragmentViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C07182(this.$typeViewModel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07182) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:51:0x0148  */
        /* JADX WARN: Code duplicated, block: B:76:0x01f0  */
        /* JADX WARN: Code duplicated, block: B:77:0x01f5  */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0216, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel.C07182.AnonymousClass1(r2, r21.this$0, r21.$typeViewModel, null), r21) == r1) goto L80;
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
            UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel;
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
                        TWSDevice tWSDevice = this.this$0.getTWSDevice();
                        if (tWSDevice == null || (tWSDeviceBuilderDiracOpteoEQ = TWSDeviceExtKt.diracOpteoEQ(tWSDevice, this.$typeViewModel.getType())) == null) {
                            boolBoxBoolean = null;
                        } else {
                            UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel2 = this.this$0;
                            EqualizerTypeViewModel equalizerTypeViewModel3 = this.$typeViewModel;
                            int setCommand = tWSDeviceBuilderDiracOpteoEQ.getSetCommand();
                            this.L$0 = tWSDeviceBuilderDiracOpteoEQ;
                            this.L$1 = unknownSimpleFragmentViewModel2;
                            this.L$2 = equalizerTypeViewModel3;
                            this.I$0 = 1;
                            this.label = 1;
                            objSyncSetResponse$default2 = TWSDevice.syncSetResponse$default(tWSDeviceBuilderDiracOpteoEQ.getTwsDevice(), setCommand, tWSDeviceBuilderDiracOpteoEQ.getSetPayload(), tWSDeviceBuilderDiracOpteoEQ.getTimeOut(), tWSDeviceBuilderDiracOpteoEQ.getIsNeedFsn(), false, tWSDeviceBuilderDiracOpteoEQ.getMockResponse(), this, 16, null);
                            if (objSyncSetResponse$default2 != coroutine_suspended) {
                                tWSDeviceBuilder2 = tWSDeviceBuilderDiracOpteoEQ;
                                unknownSimpleFragmentViewModel = unknownSimpleFragmentViewModel2;
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
                UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel3 = (UnknownSimpleFragmentViewModel) this.L$1;
                TWSDeviceBuilder tWSDeviceBuilder3 = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDeviceBuilder2 = tWSDeviceBuilder3;
                unknownSimpleFragmentViewModel = unknownSimpleFragmentViewModel3;
                equalizerTypeViewModel2 = equalizerTypeViewModel5;
                i2 = i4;
                objSyncSetResponse$default2 = obj;
                message = (Message) objSyncSetResponse$default2;
                if (message == null && message.isOk()) {
                    LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder2.getTwsDevice().getCommandCache(), tWSDeviceBuilder2.getGetCommand(), 0, 2, null);
                    LiveData liveData = unknownSimpleFragmentViewModel.diracOpteoEQLiveData;
                    if (liveData != null && (basicInt2 = (BasicInt) liveData.getValue()) != null) {
                        basicInt2.setValue(equalizerTypeViewModel2.getType());
                    }
                    LiveData liveData2 = unknownSimpleFragmentViewModel.diracOpteoEQLiveData;
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

        /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setEQMode$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setEQMode$2$1", f = "UnknownSimpleFragmentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Boolean $success;
            final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
            int label;
            final /* synthetic */ UnknownSimpleFragmentViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Boolean bool, UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel, EqualizerTypeViewModel equalizerTypeViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$success = bool;
                this.this$0 = unknownSimpleFragmentViewModel;
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

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setSpatialAudioOff$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setSpatialAudioOff$1", f = "UnknownSimpleFragmentViewModel.kt", i = {1}, l = {290, 455}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class C07191 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;

        C07191(Continuation<? super C07191> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UnknownSimpleFragmentViewModel.this.new C07191(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07191) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00ed  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel.C07191.C01541(r17.this$0, null), r17) == r1) goto L21;
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
                    TWSDevice tWSDevice = UnknownSimpleFragmentViewModel.this.getTWSDevice();
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

        /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setSpatialAudioOff$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setSpatialAudioOff$1$1", f = "UnknownSimpleFragmentViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ UnknownSimpleFragmentViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01541(UnknownSimpleFragmentViewModel unknownSimpleFragmentViewModel, Continuation<? super C01541> continuation) {
                super(2, continuation);
                this.this$0 = unknownSimpleFragmentViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01541(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        ntEarPlugin.setPhoneSpatialAudio(address, 0L, j, new Function1() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setSpatialAudioOff$1$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return UnknownSimpleFragmentViewModel.C07191.C01541.invokeSuspend$lambda$0((Result) obj2);
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
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C07191(null), 3, null);
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

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setCustomEQ$2, reason: invalid class name */
    /* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$setCustomEQ$2", f = "UnknownSimpleFragmentViewModel.kt", i = {0}, l = {455}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
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
            return UnknownSimpleFragmentViewModel.this.new AnonymousClass2(this.$byteArray, continuation);
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
                TWSDevice tWSDevice = UnknownSimpleFragmentViewModel.this.getTWSDevice();
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

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$checkLDACStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: UnknownSimpleFragmentViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$checkLDACStatus$1", f = "UnknownSimpleFragmentViewModel.kt", i = {}, l = {348}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UnknownSimpleFragmentViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                TWSDevice tWSDevice = UnknownSimpleFragmentViewModel.this.getTWSDevice();
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
                    UnknownSimpleFragmentViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(1));
                } else {
                    UnknownSimpleFragmentViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
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
                UnknownSimpleFragmentViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
            } else {
                UnknownSimpleFragmentViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
            }
            return Unit.INSTANCE;
        }
    }

    public final void checkLDACStatus() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public void initSoundTypes() {
        List listSortedWith;
        Triple triple;
        int i;
        Triple triple2;
        List<UnknownFunction> configs;
        Resources localizedResources = ContextExtKt.getLocalizedResources(ViewModelExtKt.getApplicationContext(this));
        if (getProductDevice() instanceof UnknownProduct) {
            IOTProductDevice productDevice = getProductDevice();
            Intrinsics.checkNotNull(productDevice, "null cannot be cast to non-null type com.nothing.earbase.unknown.device.UnknownProduct");
            UnknownProduct unknownProduct = (UnknownProduct) productDevice;
            UnknownConfigs configs2 = unknownProduct.getConfigs();
            int i2 = 0;
            UnknownFunction unknownFunction = (configs2 == null || (configs = configs2.getConfigs()) == null) ? null : configs.get(0);
            if (unknownFunction == null || !unknownFunction.isDiracEq()) {
                List<EQ> eQList = unknownFunction != null ? unknownFunction.getEQList() : null;
                if (eQList != null && (listSortedWith = CollectionsKt.sortedWith(eQList, new Comparator() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$initSoundTypes$$inlined$compareBy$2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        Integer num;
                        Integer num2;
                        switch (UnknownSimpleFragmentViewModel.WhenMappings.$EnumSwitchMapping$1[((EQ) t).ordinal()]) {
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
                        switch (UnknownSimpleFragmentViewModel.WhenMappings.$EnumSwitchMapping$1[((EQ) t2).ordinal()]) {
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
                        this.equalizerTypes.add(new EqualizerTypeViewModel(String.valueOf(iIntValue3), new ObservableField(localizedResources.getString(iIntValue)), iIntValue3, iIntValue2, null, null, 0, SdkConfig.SDK_VERSION, null));
                    }
                }
                Logger logger = Logger.INSTANCE;
                Logger logger2 = Logger.INSTANCE;
                Logger logger3 = logger;
                String tag = logger3.getTAG();
                int depth = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str = "unknown_widget_eq simple size:" + this.equalizerTypes.size();
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
            Iterator it2 = CollectionsKt.sortedWith(unknownFunction.getDiracOpteoEQList(), new Comparator() { // from class: com.nothing.earbase.unknown.UnknownSimpleFragmentViewModel$initSoundTypes$$inlined$compareBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Integer num;
                    Integer num2;
                    switch (UnknownSimpleFragmentViewModel.WhenMappings.$EnumSwitchMapping$0[((DiracOpteoEQ) t).ordinal()]) {
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
                    switch (UnknownSimpleFragmentViewModel.WhenMappings.$EnumSwitchMapping$0[((DiracOpteoEQ) t2).ordinal()]) {
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
                        triple2 = new Triple(Integer.valueOf(R.string.dirac_eq_opteo), Integer.valueOf(conditionalRes(R.drawable.dirac_eq, R.drawable.equalizer_new_dirac_eq)), new Pair(10, 7));
                        break;
                    case 3:
                        i = i2;
                        triple2 = new Triple(Integer.valueOf(R.string.dirac_eq_opteo_new), Integer.valueOf(conditionalRes(R.drawable.os_dirac_eq_cover, R.drawable.dirac_eq_cover)), new Pair(11, Integer.valueOf(i)));
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
                this.equalizerTypes.add(new EqualizerTypeViewModel(String.valueOf(((Number) pair.getFirst()).intValue()), new ObservableField(localizedResources.getString(iIntValue4)), ((Number) pair.getSecond()).intValue(), iIntValue5, null, new ObservableField(Boolean.valueOf(unknownProduct.diracByPowered())), 0, 80, null));
                i2 = i;
            }
            Logger logger4 = Logger.INSTANCE;
            Logger logger5 = Logger.INSTANCE;
            Logger logger6 = logger4;
            String tag2 = logger6.getTAG();
            int depth2 = logger6.getDepth();
            if (logger6.isCanLogger(true)) {
                String str4 = "unknown_widget_eq advanced size:" + this.equalizerTypes.size();
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
        return this.isSystemPage ? systemRes : normalRes;
    }
}
