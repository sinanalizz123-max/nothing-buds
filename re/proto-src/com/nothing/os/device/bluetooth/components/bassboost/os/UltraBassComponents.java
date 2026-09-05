package com.nothing.os.device.bluetooth.components.bassboost.os;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.util.ext.ViewExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.ear.R;
import com.nothing.earbase.detail.entity.EQReimburse;
import com.nothing.log.FileLog;
import com.nothing.os.device.bluetooth.adapter.SwitchItemGapViewModel;
import com.nothing.os.device.bluetooth.components.bassboost.os.view.UltraBassActivity;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: UltraBassComponents.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 L2\u00020\u0001:\u0001LB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0004\b\b\u0010\fJ\u000e\u00106\u001a\u00020#2\u0006\u00107\u001a\u00020\u0017J\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017092\u0006\u00107\u001a\u00020\u0017J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020\u0017H\u0002J\u000e\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?J\u0010\u0010@\u001a\u00020=2\u0006\u0010A\u001a\u00020#H\u0016J\b\u0010B\u001a\u00020=H\u0016J\b\u0010C\u001a\u00020DH\u0016J\u0016\u0010E\u001a\u00020#2\u0006\u0010>\u001a\u00020FH\u0096@\u00a2\u0006\u0002\u0010GJ\u0016\u0010H\u001a\u00020#2\u0006\u0010>\u001a\u00020FH\u0096@\u00a2\u0006\u0002\u0010GJ\u0016\u0010I\u001a\u00020=2\u0006\u0010J\u001a\u00020#H\u0086@\u00a2\u0006\u0002\u0010KR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010#0#0\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R6\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020#0*j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020#`+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R(\u00100\u001a\u0010\u0012\f\u0012\n $*\u0004\u0018\u00010\u00170\u001701X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006M"}, d2 = {"Lcom/nothing/os/device/bluetooth/components/bassboost/os/UltraBassComponents;", "Lcom/nothing/device/BaseFunctionComponents;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/nothing/device/IOTDevice;Landroidx/lifecycle/LifecycleOwner;)V", AccountsQueryParameters.SCOPE, "Lkotlinx/coroutines/CoroutineScope;", "(Landroid/content/Context;Lcom/nothing/device/IOTDevice;Landroidx/lifecycle/LifecycleOwner;Lkotlinx/coroutines/CoroutineScope;)V", "bassViewModel", "Lcom/nothing/os/device/bluetooth/adapter/SwitchItemGapViewModel;", "getBassViewModel", "()Lcom/nothing/os/device/bluetooth/adapter/SwitchItemGapViewModel;", "bassLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/earbase/detail/entity/EQReimburse;", "getBassLiveData", "()Landroidx/lifecycle/LiveData;", "boostValue", "", "getBoostValue", "()I", "setBoostValue", "(I)V", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "setCoroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "switchLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getSwitchLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setSwitchLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "spotPointProgress", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getSpotPointProgress", "()Ljava/util/HashMap;", "setSpotPointProgress", "(Ljava/util/HashMap;)V", "seekBarProgress", "Landroidx/databinding/ObservableField;", "getSeekBarProgress", "()Landroidx/databinding/ObservableField;", "setSeekBarProgress", "(Landroidx/databinding/ObservableField;)V", "shouldHaptic", "progress", "progressTransformToLevel", "Lkotlin/Pair;", "transformToProgress", "bass", "setSeekBarListener", "", "view", "Landroid/widget/SeekBar;", "addListener", "clearObserver", "refresh", "getComponentsModel", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "onClickSwitchGapContent", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClickSwitchGapSwitch", "setBassBoostValue", "state", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UltraBassComponents extends BaseFunctionComponents {
    public static final int BASS_BOOST_LEVEL1_PROGRESS = 7;
    public static final int BASS_BOOST_LEVEL1_RANGE = 15;
    public static final int BASS_BOOST_LEVEL2_PROGRESS = 30;
    public static final int BASS_BOOST_LEVEL2_RANGE = 38;
    public static final int BASS_BOOST_LEVEL3_PROGRESS = 53;
    public static final int BASS_BOOST_LEVEL3_RANGE = 62;
    public static final int BASS_BOOST_LEVEL4_PROGRESS = 77;
    public static final int BASS_BOOST_LEVEL4_RANGE = 85;
    public static final int BASS_BOOST_LEVEL5_PROGRESS = 100;
    public static final int BASS_BOOST_VALUE = 2;
    public static final int ORDER_ULTRA_BASS = 640;
    private final LiveData<EQReimburse> bassLiveData;
    private final SwitchItemGapViewModel bassViewModel;
    private int boostValue;
    private CoroutineScope coroutineScope;
    private ObservableField<Integer> seekBarProgress;
    private HashMap<Integer, Boolean> spotPointProgress;
    private MutableLiveData<Boolean> switchLiveData;

    /* JADX INFO: renamed from: com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents$onClickSwitchGapSwitch$1, reason: invalid class name */
    /* JADX INFO: compiled from: UltraBassComponents.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents", f = "UltraBassComponents.kt", i = {}, l = {212}, m = "onClickSwitchGapSwitch", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltraBassComponents.this.onClickSwitchGapSwitch(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents$setBassBoostValue$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UltraBassComponents.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents", f = "UltraBassComponents.kt", i = {0, 0, 0}, l = {231}, m = "setBassBoostValue", n = {"this", "state", "needUpdate$iv"}, s = {"L$0", "Z$0", "I$0"})
    static final class C10371 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C10371(Continuation<? super C10371> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UltraBassComponents.this.setBassBoostValue(false, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UltraBassComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner) {
        final TWSDeviceBuilder tWSDeviceBuilderBassBoost$default;
        super(context, iotDevice, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.bassViewModel = new UltraBassViewModel(context);
        TWSDevice twsDevice = iotDevice.getTwsDevice();
        LiveData<EQReimburse> map = null;
        if (twsDevice != null && (tWSDeviceBuilderBassBoost$default = TWSDeviceExtKt.bassBoost$default(twsDevice, null, null, 3, null)) != null) {
            final Class<EQReimburse> cls = EQReimburse.class;
            map = Transformations.map(tWSDeviceBuilderBassBoost$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderBassBoost$default.getGetCommand(), tWSDeviceBuilderBassBoost$default.getNotifyCommand()), new Function1<Message, EQReimburse>() { // from class: com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents$special$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final EQReimburse invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    EQReimburse eQReimburse = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    eQReimburse = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (EQReimburse) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (EQReimburse) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.detail.entity.EQReimburse");
                                }
                                obj = (EQReimburse) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (EQReimburse) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (EQReimburse) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            eQReimburse = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            eQReimburse = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + eQReimburse + StringUtils.SPACE;
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
                    return eQReimburse;
                }
            });
        }
        this.bassLiveData = map;
        this.switchLiveData = new MutableLiveData<>(true);
        this.spotPointProgress = new HashMap<>();
        this.seekBarProgress = new ObservableField<>(0);
        addListener(true);
        this.spotPointProgress.put(7, true);
        this.spotPointProgress.put(30, true);
        this.spotPointProgress.put(53, true);
        this.spotPointProgress.put(77, true);
        this.spotPointProgress.put(100, true);
    }

    public final SwitchItemGapViewModel getBassViewModel() {
        return this.bassViewModel;
    }

    public final LiveData<EQReimburse> getBassLiveData() {
        return this.bassLiveData;
    }

    public final int getBoostValue() {
        return this.boostValue;
    }

    public final void setBoostValue(int i) {
        this.boostValue = i;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final void setCoroutineScope(CoroutineScope coroutineScope) {
        this.coroutineScope = coroutineScope;
    }

    public final MutableLiveData<Boolean> getSwitchLiveData() {
        return this.switchLiveData;
    }

    public final void setSwitchLiveData(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.switchLiveData = mutableLiveData;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UltraBassComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner, CoroutineScope scope) {
        this(context, iotDevice, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.coroutineScope = scope;
    }

    public final HashMap<Integer, Boolean> getSpotPointProgress() {
        return this.spotPointProgress;
    }

    public final void setSpotPointProgress(HashMap<Integer, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.spotPointProgress = map;
    }

    public final ObservableField<Integer> getSeekBarProgress() {
        return this.seekBarProgress;
    }

    public final void setSeekBarProgress(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.seekBarProgress = observableField;
    }

    public final boolean shouldHaptic(int progress) {
        return Intrinsics.areEqual((Object) this.spotPointProgress.get(Integer.valueOf(progress)), (Object) true);
    }

    public final Pair<Integer, Integer> progressTransformToLevel(int progress) {
        if (progress <= 15) {
            return TuplesKt.to(2, 7);
        }
        if (16 <= progress && progress < 39) {
            return TuplesKt.to(4, 30);
        }
        if (39 <= progress && progress < 63) {
            return TuplesKt.to(6, 53);
        }
        if (63 <= progress && progress < 86) {
            return TuplesKt.to(8, 77);
        }
        return TuplesKt.to(10, 100);
    }

    private final int transformToProgress(int bass) {
        int i = bass < 0 ? 2 : (bass / 2) * 2;
        if (i == 2) {
            return 7;
        }
        if (i == 4) {
            return 30;
        }
        if (i != 6) {
            return i != 8 ? 100 : 77;
        }
        return 53;
    }

    public final void setSeekBarListener(final SeekBar view) {
        Intrinsics.checkNotNullParameter(view, "view");
        refresh();
        view.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents.setSeekBarListener.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (UltraBassComponents.this.shouldHaptic(progress)) {
                    ViewExtKt.hapticSeekView(view);
                }
                Pair<Integer, Integer> pairProgressTransformToLevel = UltraBassComponents.this.progressTransformToLevel(seekBar != null ? seekBar.getProgress() : 0);
                SwitchItemGapViewModel bassViewModel = UltraBassComponents.this.getBassViewModel();
                String string = UltraBassComponents.this.getContext().getString(R.string.level, String.valueOf(pairProgressTransformToLevel.getFirst().intValue() / 2));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                bassViewModel.setSummary(string);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "onProgressChanged onStartTrackingTouch".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "onProgressChanged onStartTrackingTouch " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "onProgressChanged onStartTrackingTouch " + strComponent2);
                    }
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "onProgressChanged progress:" + (seekBar != null ? Integer.valueOf(seekBar.getProgress()) : null) + StringUtils.SPACE;
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
                Pair<Integer, Integer> pairProgressTransformToLevel = UltraBassComponents.this.progressTransformToLevel(seekBar != null ? seekBar.getProgress() : 0);
                int iIntValue = pairProgressTransformToLevel.getSecond().intValue();
                UltraBassComponents.this.setBoostValue(pairProgressTransformToLevel.getFirst().intValue());
                Logger logger2 = Logger.INSTANCE;
                UltraBassComponents ultraBassComponents = UltraBassComponents.this;
                Logger logger3 = logger2;
                String tag2 = logger3.getTAG();
                int depth2 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str4 = "onProgressChanged process:" + iIntValue + ",viewModel?.boostValue:" + ultraBassComponents.getBoostValue();
                    String str5 = str4;
                    if (str5 != null && str5.length() != 0) {
                        Pair<String, String> trace2 = logger3.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str6 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                        FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                CoroutineScope coroutineScope = UltraBassComponents.this.getCoroutineScope();
                if (coroutineScope != null) {
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new UltraBassComponents$setSeekBarListener$1$onStopTrackingTouch$3(UltraBassComponents.this, iIntValue, null), 3, null);
                }
            }
        });
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void addListener(boolean clearObserver) {
        LiveData liveDataDistinctUntilChanged;
        if (clearObserver) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "EQReimburse unregister".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "EQReimburse unregister " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "EQReimburse unregister " + strComponent2);
                }
            }
            LiveData<EQReimburse> liveData = this.bassLiveData;
            if (liveData != null) {
                liveData.removeObservers(getLifecycleOwner());
            }
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str2 = "EQReimburse register " + getLifecycleOwner();
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
        LiveData<EQReimburse> liveData2 = this.bassLiveData;
        if (liveData2 == null || (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(liveData2)) == null) {
            return;
        }
        liveDataDistinctUntilChanged.observe(getLifecycleOwner(), new UltraBassComponents$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UltraBassComponents.addListener$lambda$3(this.f$0, (EQReimburse) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addListener$lambda$3(UltraBassComponents ultraBassComponents, EQReimburse eQReimburse) {
        if (eQReimburse != null) {
            ultraBassComponents.bassViewModel.getChecked().set(Boolean.valueOf(eQReimburse.getReimburseSwitch()));
            ultraBassComponents.switchLiveData.postValue(Boolean.valueOf(eQReimburse.getReimburseSwitch()));
            ultraBassComponents.boostValue = eQReimburse.getReimburseValue() < 0 ? 2 : (eQReimburse.getReimburseValue() / 2) * 2;
            eQReimburse.getReimburseSwitch();
            SwitchItemGapViewModel switchItemGapViewModel = ultraBassComponents.bassViewModel;
            String string = ultraBassComponents.getContext().getString(R.string.level, String.valueOf(ultraBassComponents.boostValue / 2));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            switchItemGapViewModel.setSummary(string);
            ultraBassComponents.seekBarProgress.set(Integer.valueOf(ultraBassComponents.transformToProgress(ultraBassComponents.boostValue)));
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void refresh() {
        TWSDeviceBuilder tWSDeviceBuilderBassBoost$default;
        TWSDevice twsDevice = getIotDevice().getTwsDevice();
        if (twsDevice == null || (tWSDeviceBuilderBassBoost$default = TWSDeviceExtKt.bassBoost$default(twsDevice, null, null, 3, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderBassBoost$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public CommonBindingMoreType getComponentsModel() {
        return this.bassViewModel;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public Object onClickSwitchGapContent(View view, Continuation<? super Boolean> continuation) {
        Bundle bundle = getBundle(getIotDevice().getMacAddress());
        Intent intent = new Intent(view.getContext(), (Class<?>) UltraBassActivity.class);
        intent.putExtras(bundle);
        view.getContext().startActivity(intent);
        return Boxing.boxBoolean(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.nothing.device.BaseFunctionComponents
    public Object onClickSwitchGapSwitch(View view, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            boolean zAreEqual = Intrinsics.areEqual(this.bassViewModel.getChecked().get(), Boxing.boxBoolean(false));
            anonymousClass1.label = 1;
            if (setBassBoostValue(zAreEqual, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(true);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setBassBoostValue(boolean z, Continuation<? super Unit> continuation) {
        C10371 c10371;
        TWSDeviceBuilder tWSDeviceBuilderBassBoost;
        Object objSyncSetResponse$default;
        UltraBassComponents ultraBassComponents;
        TWSDeviceBuilder tWSDeviceBuilder;
        int i;
        if (continuation instanceof C10371) {
            c10371 = (C10371) continuation;
            if ((c10371.label & Integer.MIN_VALUE) != 0) {
                c10371.label -= Integer.MIN_VALUE;
            } else {
                c10371 = new C10371(continuation);
            }
        } else {
            c10371 = new C10371(continuation);
        }
        C10371 c10372 = c10371;
        Object obj = c10372.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c10372.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            TWSDevice twsDevice = getIotDevice().getTwsDevice();
            if (twsDevice == null || (tWSDeviceBuilderBassBoost = TWSDeviceExtKt.bassBoost(twsDevice, Boxing.boxBoolean(z), Boxing.boxInt(this.boostValue))) == null) {
                return Unit.INSTANCE;
            }
            int setCommand = tWSDeviceBuilderBassBoost.getSetCommand();
            TWSDevice twsDevice2 = tWSDeviceBuilderBassBoost.getTwsDevice();
            byte[] setPayload = tWSDeviceBuilderBassBoost.getSetPayload();
            Long timeOut = tWSDeviceBuilderBassBoost.getTimeOut();
            boolean isNeedFsn = tWSDeviceBuilderBassBoost.getIsNeedFsn();
            byte[] mockResponse = tWSDeviceBuilderBassBoost.getMockResponse();
            c10372.L$0 = this;
            c10372.L$1 = tWSDeviceBuilderBassBoost;
            c10372.Z$0 = z;
            c10372.I$0 = 1;
            c10372.label = 1;
            objSyncSetResponse$default = TWSDevice.syncSetResponse$default(twsDevice2, setCommand, setPayload, timeOut, isNeedFsn, false, mockResponse, c10372, 16, null);
            if (objSyncSetResponse$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            ultraBassComponents = this;
            tWSDeviceBuilder = tWSDeviceBuilderBassBoost;
            i = 1;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i3 = c10372.I$0;
            boolean z2 = c10372.Z$0;
            TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) c10372.L$1;
            ultraBassComponents = (UltraBassComponents) c10372.L$0;
            ResultKt.throwOnFailure(obj);
            i = i3;
            z = z2;
            tWSDeviceBuilder = tWSDeviceBuilder2;
            objSyncSetResponse$default = obj;
        }
        Message message = (Message) objSyncSetResponse$default;
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
            byte[] bArrObtainDataPacket = EQReimburse.INSTANCE.obtainDataPacket(z, ultraBassComponents.boostValue);
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
        }
        return Unit.INSTANCE;
    }
}
