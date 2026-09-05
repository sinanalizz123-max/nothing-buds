package com.nothing.os.device.bluetooth.components;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.ear.R;
import com.nothing.earbase.anc.entity.DeviceNoiseItem;
import com.nothing.earbase.anc.entity.DeviceNoiseReduction;
import com.nothing.log.FileLog;
import com.nothing.os.device.bluetooth.adapter.ANCItemViewModel;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ANCComponents.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00019B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010,\u001a\u00020-H\u0016J\u000e\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020'J\u0006\u00100\u001a\u00020\u000fJ\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0016J\n\u00104\u001a\u0004\u0018\u000105H\u0016J\u0015\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u00010'\u00a2\u0006\u0002\u00108R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006:"}, d2 = {"Lcom/nothing/os/device/bluetooth/components/ANCComponents;", "Lcom/nothing/device/BaseFunctionComponents;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Landroid/content/Context;Lcom/nothing/device/IOTDevice;Landroidx/lifecycle/LifecycleOwner;Lkotlinx/coroutines/CoroutineScope;)V", "getViewModelScope", "()Lkotlinx/coroutines/CoroutineScope;", "ancViewModel", "Lcom/nothing/os/device/bluetooth/adapter/ANCItemViewModel;", "getAncViewModel", "()Lcom/nothing/os/device/bluetooth/adapter/ANCItemViewModel;", "ancViewModel$delegate", "Lkotlin/Lazy;", "noiseLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;", "getNoiseLiveData", "()Landroidx/lifecycle/LiveData;", "setNoiseLiveData", "(Landroidx/lifecycle/LiveData;)V", "ancJob", "Lkotlinx/coroutines/Job;", "getAncJob", "()Lkotlinx/coroutines/Job;", "setAncJob", "(Lkotlinx/coroutines/Job;)V", "isClick", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setClick", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "noiseOpenSelectMode", "", "getNoiseOpenSelectMode", "()I", "setNoiseOpenSelectMode", "(I)V", "refresh", "", "updateNoiseMode", "type", "createANC", "addListener", "clearObserver", "", "getComponentsModel", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "updateTabLayoutSelected", "value", "(Ljava/lang/Integer;)V", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ANCComponents extends BaseFunctionComponents {
    public static final long ANC_DELAY = 300;
    private static final long ANC_DELAY_REQUEST = 2000;
    private Job ancJob;

    /* JADX INFO: renamed from: ancViewModel$delegate, reason: from kotlin metadata */
    private final Lazy ancViewModel;
    private AtomicBoolean isClick;
    private LiveData<DeviceNoiseReduction> noiseLiveData;
    private int noiseOpenSelectMode;
    private final CoroutineScope viewModelScope;

    public final CoroutineScope getViewModelScope() {
        return this.viewModelScope;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ANCComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner, CoroutineScope viewModelScope) {
        super(context, iotDevice, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModelScope, "viewModelScope");
        this.viewModelScope = viewModelScope;
        this.ancViewModel = LazyKt.lazy(new Function0() { // from class: com.nothing.os.device.bluetooth.components.ANCComponents$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ANCComponents.ancViewModel_delegate$lambda$0();
            }
        });
        this.isClick = new AtomicBoolean(false);
        this.noiseOpenSelectMode = 1;
        addListener(true);
    }

    private final ANCItemViewModel getAncViewModel() {
        return (ANCItemViewModel) this.ancViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ANCItemViewModel ancViewModel_delegate$lambda$0() {
        return new ANCItemViewModel(610);
    }

    public final LiveData<DeviceNoiseReduction> getNoiseLiveData() {
        return this.noiseLiveData;
    }

    public final void setNoiseLiveData(LiveData<DeviceNoiseReduction> liveData) {
        this.noiseLiveData = liveData;
    }

    public final Job getAncJob() {
        return this.ancJob;
    }

    public final void setAncJob(Job job) {
        this.ancJob = job;
    }

    /* JADX INFO: renamed from: isClick, reason: from getter */
    public final AtomicBoolean getIsClick() {
        return this.isClick;
    }

    public final void setClick(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isClick = atomicBoolean;
    }

    public final int getNoiseOpenSelectMode() {
        return this.noiseOpenSelectMode;
    }

    public final void setNoiseOpenSelectMode(int i) {
        this.noiseOpenSelectMode = i;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void refresh() {
        TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default;
        TWSDevice twsDevice = getIotDevice().getTwsDevice();
        if (twsDevice == null || (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(twsDevice, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderNoiseReduction$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    public final void updateNoiseMode(int type) {
        updateTabLayoutSelected(Integer.valueOf(type));
        Job job = this.ancJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.isClick.set(true);
        this.ancJob = BuildersKt__Builders_commonKt.launch$default(this.viewModelScope, Dispatchers.getIO(), null, new AnonymousClass1(type, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.os.device.bluetooth.components.ANCComponents$updateNoiseMode$1, reason: invalid class name */
    /* JADX INFO: compiled from: ANCComponents.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.bluetooth.components.ANCComponents$updateNoiseMode$1", f = "ANCComponents.kt", i = {1, 1}, l = {57, 223, 63}, m = "invokeSuspend", n = {"this_$iv", "needUpdate$iv"}, s = {"L$0", "I$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $type;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$type = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ANCComponents.this.new AnonymousClass1(this.$type, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:50:0x0114  */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0126, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(2000, r21) == r1) goto L53;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderNoiseReduction;
            int i;
            Object objSyncSetResponse$default;
            TWSDeviceBuilder tWSDeviceBuilder;
            ANCComponents aNCComponents;
            int i2;
            Message message;
            DeviceNoiseReduction value;
            DeviceNoiseReduction value2;
            TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(300L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i3 == 2) {
                i = this.I$1;
                int i4 = this.I$0;
                ANCComponents aNCComponents2 = (ANCComponents) this.L$1;
                TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDeviceBuilder = tWSDeviceBuilder2;
                aNCComponents = aNCComponents2;
                i2 = i4;
                objSyncSetResponse$default = obj;
                message = (Message) objSyncSetResponse$default;
                if (message == null && message.isOk()) {
                    LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                    LiveData<DeviceNoiseReduction> noiseLiveData = aNCComponents.getNoiseLiveData();
                    if (noiseLiveData != null && (value2 = noiseLiveData.getValue()) != null) {
                        value2.updateLastNoiseReductionLevel(i);
                    }
                    LiveData<DeviceNoiseReduction> noiseLiveData2 = aNCComponents.getNoiseLiveData();
                    byte[] bArrObtainDataPacket = (noiseLiveData2 == null || (value = noiseLiveData2.getValue()) == null) ? null : value.obtainDataPacket();
                    Message message2 = (Message) liveDataCommand$default.getValue();
                    if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                        tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrObtainDataPacket);
                        if (message2 != null) {
                            message2.setPayload(bArrObtainDataPacket);
                            if (i2 != 0) {
                                tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message2);
                            }
                        }
                    }
                    Boxing.boxBoolean(true);
                } else {
                    Boxing.boxBoolean(false);
                }
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
            } else {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            ANCComponents.this.getIsClick().set(false);
            TWSDevice twsDevice = ANCComponents.this.getIotDevice().getTwsDevice();
            if (twsDevice != null && (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(twsDevice, null, 1, null)) != null) {
                TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderNoiseReduction$default, false, (byte[]) null, 0, 7, (Object) null);
            }
            return Unit.INSTANCE;
            TWSDevice twsDevice2 = ANCComponents.this.getIotDevice().getTwsDevice();
            if (twsDevice2 == null || (tWSDeviceBuilderNoiseReduction = TWSDeviceExtKt.noiseReduction(twsDevice2, Boxing.boxInt(this.$type))) == null) {
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
            } else {
                ANCComponents aNCComponents3 = ANCComponents.this;
                i = this.$type;
                int setCommand = tWSDeviceBuilderNoiseReduction.getSetCommand();
                this.L$0 = tWSDeviceBuilderNoiseReduction;
                this.L$1 = aNCComponents3;
                this.I$0 = 0;
                this.I$1 = i;
                this.label = 2;
                objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderNoiseReduction.getTwsDevice(), setCommand, tWSDeviceBuilderNoiseReduction.getSetPayload(), tWSDeviceBuilderNoiseReduction.getTimeOut(), tWSDeviceBuilderNoiseReduction.getIsNeedFsn(), false, tWSDeviceBuilderNoiseReduction.getMockResponse(), this, 16, null);
                if (objSyncSetResponse$default != coroutine_suspended) {
                    tWSDeviceBuilder = tWSDeviceBuilderNoiseReduction;
                    aNCComponents = aNCComponents3;
                    i2 = 0;
                    message = (Message) objSyncSetResponse$default;
                    if (message == null) {
                        Boxing.boxBoolean(false);
                    } else {
                        Boxing.boxBoolean(false);
                    }
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 3;
                }
            }
            return coroutine_suspended;
        }
    }

    public final ANCItemViewModel createANC() {
        if (getAncViewModel().getTabNoiseArray().length == 0) {
            ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(new Pair(Integer.valueOf(R.string.anc_noise_high), 1), new Pair(Integer.valueOf(R.string.anc_noise_mid), 2), new Pair(Integer.valueOf(R.string.anc_noise_low), 3), new Pair(Integer.valueOf(R.string.anc_noise_adaptive), 4));
            ArrayList arrayListArrayListOf2 = CollectionsKt.arrayListOf(new Triple(Integer.valueOf(R.string.anc_noise_cancellation_single_line), Integer.valueOf(R.drawable.ic_noise_on_selector), 1), new Triple(Integer.valueOf(R.string.anc_noise_transparency), Integer.valueOf(R.drawable.ic_noise_trans_selector), 7), new Triple(Integer.valueOf(R.string.anc_noise_off), Integer.valueOf(R.drawable.ic_noise_off_selector), 5));
            int aNCLevel = getIotDevice().getANCLevel(getIotDevice().getMacAddress());
            if (aNCLevel == 1) {
                arrayListArrayListOf2.remove(1);
                ArrayList arrayList = arrayListArrayListOf;
                arrayListArrayListOf.remove(CollectionsKt.getLastIndex(arrayList));
                arrayListArrayListOf.remove(CollectionsKt.getLastIndex(arrayList));
                arrayListArrayListOf.remove(CollectionsKt.getLastIndex(arrayList));
            } else if (aNCLevel == 2) {
                arrayListArrayListOf.remove(CollectionsKt.getLastIndex(arrayListArrayListOf));
                arrayListArrayListOf.remove(1);
            } else if (aNCLevel == 3) {
                arrayListArrayListOf.remove(CollectionsKt.getLastIndex(arrayListArrayListOf));
            } else if (aNCLevel == 5) {
                ArrayList arrayList2 = arrayListArrayListOf;
                arrayListArrayListOf.remove(CollectionsKt.getLastIndex(arrayList2));
                arrayListArrayListOf.remove(CollectionsKt.getLastIndex(arrayList2));
                arrayListArrayListOf.remove(CollectionsKt.getLastIndex(arrayList2));
            }
            getAncViewModel().setTabLevelArray((Pair[]) arrayListArrayListOf.toArray(new Pair[0]));
            getAncViewModel().setTabNoiseArray((Triple[]) arrayListArrayListOf2.toArray(new Triple[0]));
        }
        return getAncViewModel();
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void addListener(boolean clearObserver) {
        LiveData liveDataDistinctUntilChanged;
        final TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default;
        if (getIotDevice().isSupportAnc(getIotDevice().getMacAddress())) {
            LiveData<DeviceNoiseReduction> liveData = this.noiseLiveData;
            if (liveData != null) {
                liveData.removeObservers(getLifecycleOwner());
            }
            TWSDevice twsDevice = getIotDevice().getTwsDevice();
            LiveData<DeviceNoiseReduction> map = null;
            if (twsDevice != null && (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(twsDevice, null, 1, null)) != null) {
                final Class<DeviceNoiseReduction> cls = DeviceNoiseReduction.class;
                map = Transformations.map(tWSDeviceBuilderNoiseReduction$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderNoiseReduction$default.getGetCommand(), tWSDeviceBuilderNoiseReduction$default.getNotifyCommand()), new Function1<Message, DeviceNoiseReduction>() { // from class: com.nothing.os.device.bluetooth.components.ANCComponents$addListener$$inlined$getLiveData$1
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
                });
            }
            this.noiseLiveData = map;
            if (map == null || (liveDataDistinctUntilChanged = Transformations.distinctUntilChanged(map)) == null) {
                return;
            }
            liveDataDistinctUntilChanged.observe(getLifecycleOwner(), new ANCComponents$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.os.device.bluetooth.components.ANCComponents$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ANCComponents.addListener$lambda$4(this.f$0, (DeviceNoiseReduction) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addListener$lambda$4(ANCComponents aNCComponents, DeviceNoiseReduction deviceNoiseReduction) {
        DeviceNoiseItem lastNoiseReductionLevel;
        if (aNCComponents.isClick.get()) {
            return Unit.INSTANCE;
        }
        if (deviceNoiseReduction != null) {
            DeviceNoiseItem noiseReductionMode = deviceNoiseReduction.getNoiseReductionMode();
            if (noiseReductionMode != null) {
                aNCComponents.updateTabLayoutSelected(Integer.valueOf(noiseReductionMode.getValue()));
            }
            if (aNCComponents.getIotDevice().getANCLevel(aNCComponents.getIotDevice().getMacAddress()) != 5 && (lastNoiseReductionLevel = deviceNoiseReduction.getLastNoiseReductionLevel()) != null) {
                aNCComponents.noiseOpenSelectMode = lastNoiseReductionLevel.getValue();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public CommonBindingMoreType getComponentsModel() {
        createANC();
        return getAncViewModel();
    }

    public final void updateTabLayoutSelected(Integer value) {
        Triple<Integer, Integer, Integer>[] tabNoiseArray = getAncViewModel().getTabNoiseArray();
        int length = tabNoiseArray.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = i3 + 1;
            int iIntValue = tabNoiseArray[i2].getThird().intValue();
            if (value != null && iIntValue == value.intValue()) {
                i4 = i3;
            }
            i2++;
            i3 = i5;
        }
        Pair<Integer, Integer>[] tabLevelArray = getAncViewModel().getTabLevelArray();
        int length2 = tabLevelArray.length;
        int i6 = 0;
        int i7 = 0;
        while (i < length2) {
            int i8 = i6 + 1;
            int iIntValue2 = tabLevelArray[i].getSecond().intValue();
            if (value != null && iIntValue2 == value.intValue()) {
                i7 = i6;
            }
            i++;
            i6 = i8;
        }
        if (value != null && value.intValue() == 4) {
            this.noiseOpenSelectMode = value.intValue();
            getAncViewModel().getSelectTab().set(0);
            getAncViewModel().getSelectLevel().set(Integer.valueOf(i7));
            return;
        }
        if (value != null && value.intValue() == 3) {
            this.noiseOpenSelectMode = value.intValue();
            getAncViewModel().getSelectTab().set(0);
            getAncViewModel().getSelectLevel().set(Integer.valueOf(i7));
            return;
        }
        if (value != null && value.intValue() == 2) {
            this.noiseOpenSelectMode = value.intValue();
            getAncViewModel().getSelectTab().set(0);
            getAncViewModel().getSelectLevel().set(Integer.valueOf(i7));
        } else if (value != null && value.intValue() == 1) {
            this.noiseOpenSelectMode = value.intValue();
            getAncViewModel().getSelectTab().set(0);
            getAncViewModel().getSelectLevel().set(Integer.valueOf(i7));
        } else if (value != null && value.intValue() == 7) {
            getAncViewModel().getSelectTab().set(Integer.valueOf(i4));
        } else if (value != null && value.intValue() == 5) {
            getAncViewModel().getSelectTab().set(Integer.valueOf(i4));
        }
    }
}
