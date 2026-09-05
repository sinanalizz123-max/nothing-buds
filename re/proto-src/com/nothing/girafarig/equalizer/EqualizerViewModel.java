package com.nothing.girafarig.equalizer;

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
import com.nothing.earbase.guide.AnimalBaseGuideActivity;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.girafarig.core.protocol.GirafarigSppProtocol;
import com.nothing.log.FileLog;
import com.nothing.os.device.DeviceConstant;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
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
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EqualizerViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u0012J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0016J&\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001cH\u0016J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006%"}, d2 = {"Lcom/nothing/girafarig/equalizer/EqualizerViewModel;", "Lcom/nothing/earbase/equalizer/viewmodel/BaseEqualizerViewModel;", "context", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "getContext", "()Landroid/app/Application;", "diracOpteoEQLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/base/protocol/entity/BasicInt;", "needHDACWarning", "Landroidx/lifecycle/MutableLiveData;", "Lcom/nothing/girafarig/equalizer/WarnEqualizerTypeViewModel;", "getNeedHDACWarning", "()Landroidx/lifecycle/MutableLiveData;", "setPowerByTextBuilder", "", "Landroid/content/Context;", "register", "getEQData", "getDiracEQRes", "", "initSoundTypes", "setEQMode", "typeViewModel", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "action", "Lkotlin/Function1;", "sendEqModelData", "getHDACStatus", "getFreq", "", "radarItem", "Lcom/nothing/base/wiget/radar/EQLabelItem;", "getQ", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EqualizerViewModel extends BaseEqualizerViewModel {
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
    private final MutableLiveData<WarnEqualizerTypeViewModel> needHDACWarning;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EqualizerViewModel(Application context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.needHDACWarning = new MutableLiveData<>();
    }

    public final Application getContext() {
        return this.context;
    }

    public final MutableLiveData<WarnEqualizerTypeViewModel> getNeedHDACWarning() {
        return this.needHDACWarning;
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
        setProtocol(new GirafarigSppProtocol(getAddress()));
        super.register();
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void getEQData() {
        LiveData liveDataDistinctUntilChanged;
        final TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ$default;
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderDiracOpteoEQ$default = TWSDeviceExtKt.diracOpteoEQ$default(tWSDevice, 0, 1, null)) != null) {
            final Class<BasicInt> cls = BasicInt.class;
            this.diracOpteoEQLiveData = Transformations.map(tWSDeviceBuilderDiracOpteoEQ$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderDiracOpteoEQ$default.getGetCommand(), tWSDeviceBuilderDiracOpteoEQ$default.getNotifyCommand()), new Function1<Message, BasicInt>() { // from class: com.nothing.girafarig.equalizer.EqualizerViewModel$getEQData$lambda$1$$inlined$getLiveData$1
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
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderDiracOpteoEQ$default, false, (byte[]) null, 0, 7, (Object) null);
        }
        LiveData<BasicInt> liveData = this.diracOpteoEQLiveData;
        if (liveData == null || (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(liveData)) == null) {
            return;
        }
        liveDataDistinctUntilChanged.observe(this, new EqualizerViewModel$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.girafarig.equalizer.EqualizerViewModel$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EqualizerViewModel.getEQData$lambda$2(this.f$0, (BasicInt) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getEQData$lambda$2(EqualizerViewModel equalizerViewModel, BasicInt basicInt) {
        equalizerViewModel.updateEQMode(Integer.valueOf(basicInt != null ? basicInt.getValue() : 0));
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
        Resources localizedResources = ContextExtKt.getLocalizedResources(this.context);
        getEqualizerTypes().add(new EqualizerTypeViewModel("11", new ObservableField(localizedResources.getString(R.string.dirac_eq_opteo_new)), 0, getDiracEQRes(), new ObservableField(false), new ObservableField(true), R.drawable.dirac_eq_selector));
        getEqualizerTypes().add(new EqualizerTypeViewModel(DeviceConstant.NOISE_CANCELLATION_ADAPTIVE, new ObservableField(localizedResources.getString(R.string.eq_advanced_genre_pop)), 3, getIsSystemPage() ? R.drawable.os_equalizer_pop : R.drawable.equalizer_pop, null, null, 0, SdkConfig.SDK_VERSION, null));
        getEqualizerTypes().add(new EqualizerTypeViewModel("6", new ObservableField(localizedResources.getString(R.string.eq_advanced_genre_rock)), 1, getIsSystemPage() ? R.drawable.os_equalizer_rock : R.drawable.equalizer_rock, null, null, 0, SdkConfig.SDK_VERSION, null));
        getEqualizerTypes().add(new EqualizerTypeViewModel("8", new ObservableField(localizedResources.getString(R.string.eq_advanced_genre_classical)), 5, getIsSystemPage() ? R.drawable.os_equalizer_classical : R.drawable.equalizer_classical, null, null, 0, SdkConfig.SDK_VERSION, null));
        getEqualizerTypes().add(new EqualizerTypeViewModel(DeviceConstant.NOISE_CANCELLATION_TRANSPARENCY, new ObservableField(localizedResources.getString(R.string.eq_advanced_genre_electronic)), 2, getIsSystemPage() ? R.drawable.os_equalizer_electronic : R.drawable.equalizer_electronic, null, null, 0, SdkConfig.SDK_VERSION, null));
        getEqualizerTypes().add(new EqualizerTypeViewModel("9", new ObservableField(localizedResources.getString(R.string.dirac_eq_enhance_vocals)), 4, getIsSystemPage() ? R.drawable.os_equalizer_vocals : R.drawable.equalizer_vocals, null, null, 0, SdkConfig.SDK_VERSION, null));
        getEqualizerTypes().add(new EqualizerTypeViewModel(DeviceConstant.NOISE_CANCELLATION_OFF, new ObservableField(localizedResources.getString(R.string.sound_eq_custom)), 6, 0, null, null, 0, SdkConfig.SDK_VERSION, null));
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void setEQMode(EqualizerTypeViewModel typeViewModel, Function1<? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        for (EqualizerTypeViewModel equalizerTypeViewModel : getEqualizerTypes()) {
            if (Intrinsics.areEqual((Object) equalizerTypeViewModel.getSelected().get(), (Object) true) && equalizerTypeViewModel.getType() == typeViewModel.getType()) {
                return;
            }
        }
        if (typeViewModel.getType() == 0) {
            getHDACStatus(typeViewModel);
        } else {
            sendEqModelData(typeViewModel);
        }
    }

    /* JADX INFO: renamed from: com.nothing.girafarig.equalizer.EqualizerViewModel$sendEqModelData$1, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.girafarig.equalizer.EqualizerViewModel$sendEqModelData$1", f = "EqualizerViewModel.kt", i = {0}, l = {269, AnimalBaseGuideActivity.REPEAT_TWO_START}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ EqualizerViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(EqualizerTypeViewModel equalizerTypeViewModel, EqualizerViewModel equalizerViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$typeViewModel = equalizerTypeViewModel;
            this.this$0 = equalizerViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$typeViewModel, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:51:0x0143  */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x0168, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.girafarig.equalizer.EqualizerViewModel.AnonymousClass1.C01641(r2, r19.this$0, r19.$typeViewModel, null), r19) == r1) goto L54;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Boolean boolBoxBoolean;
            TWSDeviceBuilder tWSDeviceBuilderDiracOpteoEQ;
            Object objSyncSetResponse$default;
            TWSDeviceBuilder tWSDeviceBuilder;
            EqualizerViewModel equalizerViewModel;
            EqualizerTypeViewModel equalizerTypeViewModel;
            int i;
            IOTProductDevice productDevice;
            String productId;
            BasicInt basicInt;
            BasicInt basicInt2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                AppBuriedPointUtils.INSTANCE.reportUserData(new EventParams(AppBuriedPointUtils.CHANGE_EQ_EVENT, this.$typeViewModel.getReportType().toString(), AppBuriedPointUtils.VALUE_TYPE_INT), this.this$0.getIsSystemPage());
                TWSDevice tWSDevice = this.this$0.getProtocol().getTWSDevice();
                if (tWSDevice != null && (tWSDeviceBuilderDiracOpteoEQ = TWSDeviceExtKt.diracOpteoEQ(tWSDevice, this.$typeViewModel.getType())) != null) {
                    EqualizerViewModel equalizerViewModel2 = this.this$0;
                    EqualizerTypeViewModel equalizerTypeViewModel2 = this.$typeViewModel;
                    int setCommand = tWSDeviceBuilderDiracOpteoEQ.getSetCommand();
                    this.L$0 = tWSDeviceBuilderDiracOpteoEQ;
                    this.L$1 = equalizerViewModel2;
                    this.L$2 = equalizerTypeViewModel2;
                    this.I$0 = 1;
                    this.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderDiracOpteoEQ.getTwsDevice(), setCommand, tWSDeviceBuilderDiracOpteoEQ.getSetPayload(), tWSDeviceBuilderDiracOpteoEQ.getTimeOut(), tWSDeviceBuilderDiracOpteoEQ.getIsNeedFsn(), false, tWSDeviceBuilderDiracOpteoEQ.getMockResponse(), this, 16, null);
                    if (objSyncSetResponse$default != coroutine_suspended) {
                        tWSDeviceBuilder = tWSDeviceBuilderDiracOpteoEQ;
                        equalizerViewModel = equalizerViewModel2;
                        equalizerTypeViewModel = equalizerTypeViewModel2;
                        i = 1;
                    }
                } else {
                    boolBoxBoolean = null;
                    GooglePlayScoreUtil googlePlayScoreUtil = GooglePlayScoreUtil.INSTANCE;
                    boolean zAreEqual = Intrinsics.areEqual(boolBoxBoolean, Boxing.boxBoolean(true));
                    productDevice = this.this$0.getProductDevice();
                    if (productDevice != null || (productId = productDevice.getProductId()) == null) {
                        productId = "";
                    }
                    googlePlayScoreUtil.addScore(zAreEqual, productId);
                    this.L$0 = null;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 2;
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                int i3 = this.I$0;
                EqualizerTypeViewModel equalizerTypeViewModel3 = (EqualizerTypeViewModel) this.L$2;
                EqualizerViewModel equalizerViewModel3 = (EqualizerViewModel) this.L$1;
                TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDeviceBuilder = tWSDeviceBuilder2;
                equalizerViewModel = equalizerViewModel3;
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
                LiveData liveData = equalizerViewModel.diracOpteoEQLiveData;
                if (liveData != null && (basicInt2 = (BasicInt) liveData.getValue()) != null) {
                    basicInt2.setValue(equalizerTypeViewModel.getType());
                }
                LiveData liveData2 = equalizerViewModel.diracOpteoEQLiveData;
                byte[] bArrObtainDataPacket = (liveData2 == null || (basicInt = (BasicInt) liveData2.getValue()) == null) ? null : basicInt.obtainDataPacket();
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
                boolBoxBoolean = Boxing.boxBoolean(true);
            } else {
                boolBoxBoolean = Boxing.boxBoolean(false);
            }
            GooglePlayScoreUtil googlePlayScoreUtil2 = GooglePlayScoreUtil.INSTANCE;
            boolean zAreEqual2 = Intrinsics.areEqual(boolBoxBoolean, Boxing.boxBoolean(true));
            productDevice = this.this$0.getProductDevice();
            if (productDevice != null) {
                productId = "";
            } else {
                productId = "";
            }
            googlePlayScoreUtil2.addScore(zAreEqual2, productId);
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.girafarig.equalizer.EqualizerViewModel$sendEqModelData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: EqualizerViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.girafarig.equalizer.EqualizerViewModel$sendEqModelData$1$1", f = "EqualizerViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Boolean $success;
            final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
            int label;
            final /* synthetic */ EqualizerViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01641(Boolean bool, EqualizerViewModel equalizerViewModel, EqualizerTypeViewModel equalizerTypeViewModel, Continuation<? super C01641> continuation) {
                super(2, continuation);
                this.$success = bool;
                this.this$0 = equalizerViewModel;
                this.$typeViewModel = equalizerTypeViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01641(this.$success, this.this$0, this.$typeViewModel, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01641) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
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

    public final void sendEqModelData(EqualizerTypeViewModel typeViewModel) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(typeViewModel, this, null), 2, null);
    }

    private final void getHDACStatus(EqualizerTypeViewModel typeViewModel) {
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new EqualizerViewModel$getHDACStatus$1$1(tWSDevice, this, typeViewModel, null), 2, null);
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
