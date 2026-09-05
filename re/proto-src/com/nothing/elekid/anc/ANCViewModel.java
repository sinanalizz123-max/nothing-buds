package com.nothing.elekid.anc;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.BaseAndroidLifecycleViewModel;
import com.nothing.earbase.anc.entity.DeviceNoiseItem;
import com.nothing.earbase.anc.entity.DeviceNoiseReduction;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ANCViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\bJ\u0010\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020\bH\u0002R(\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$\u00a8\u0006+"}, d2 = {"Lcom/nothing/elekid/anc/ANCViewModel;", "Lcom/nothing/device/BaseAndroidLifecycleViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "noiseModelIndex", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getNoiseModelIndex", "()Landroidx/lifecycle/MutableLiveData;", "setNoiseModelIndex", "(Landroidx/lifecycle/MutableLiveData;)V", "noiseOpenSelectMode", "getNoiseOpenSelectMode", "()I", "setNoiseOpenSelectMode", "(I)V", "noiseLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;", "getNoiseLiveData", "()Landroidx/lifecycle/LiveData;", "setNoiseLiveData", "(Landroidx/lifecycle/LiveData;)V", "ancJob", "Lkotlinx/coroutines/Job;", "getAncJob", "()Lkotlinx/coroutines/Job;", "setAncJob", "(Lkotlinx/coroutines/Job;)V", "isClick", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setClick", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "getNoiseReduction", "", "updateNoiseMode", "type", "updateTabLayoutSelected", "mode", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ANCViewModel extends BaseAndroidLifecycleViewModel {
    private Job ancJob;
    private AtomicBoolean isClick;
    private LiveData<DeviceNoiseReduction> noiseLiveData;
    private MutableLiveData<Integer> noiseModelIndex;
    private int noiseOpenSelectMode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ANCViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.noiseModelIndex = new MutableLiveData<>(-1);
        this.noiseOpenSelectMode = 1;
        this.isClick = new AtomicBoolean(false);
    }

    public final MutableLiveData<Integer> getNoiseModelIndex() {
        return this.noiseModelIndex;
    }

    public final void setNoiseModelIndex(MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.noiseModelIndex = mutableLiveData;
    }

    public final int getNoiseOpenSelectMode() {
        return this.noiseOpenSelectMode;
    }

    public final void setNoiseOpenSelectMode(int i) {
        this.noiseOpenSelectMode = i;
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

    public final void getNoiseReduction() {
        LiveData<DeviceNoiseReduction> map;
        TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default;
        final TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default2;
        removeAllObservers();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "delay time getNoiseReduction".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "delay time getNoiseReduction " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "delay time getNoiseReduction " + strComponent2);
            }
        }
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderNoiseReduction$default2 = TWSDeviceExtKt.noiseReduction$default(tWSDevice, null, 1, null)) == null) {
            map = null;
        } else {
            final Class<DeviceNoiseReduction> cls = DeviceNoiseReduction.class;
            map = Transformations.map(tWSDeviceBuilderNoiseReduction$default2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderNoiseReduction$default2.getGetCommand(), tWSDeviceBuilderNoiseReduction$default2.getNotifyCommand()), new Function1<Message, DeviceNoiseReduction>() { // from class: com.nothing.elekid.anc.ANCViewModel$getNoiseReduction$$inlined$getLiveData$1
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
                    Logger logger2 = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger3 = logger2;
                    String tag2 = logger3.getTAG();
                    int depth2 = logger3.getDepth();
                    if (logger3.isCanLogger(true)) {
                        String str2 = "parseLiveData " + cls3 + StringUtils.SPACE + deviceNoiseReduction + StringUtils.SPACE;
                        String str3 = str2;
                        if (str3 != null && str3.length() != 0) {
                            Pair<String, String> trace2 = logger3.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str4 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                            FileLog.print$default(fileLog2, 4, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                            }
                        }
                    }
                    return deviceNoiseReduction;
                }
            });
        }
        this.noiseLiveData = map;
        if (map != null) {
            map.observe(this, new ANCViewModelKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.anc.ANCViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ANCViewModel.getNoiseReduction$lambda$7(this.f$0, (DeviceNoiseReduction) obj);
                }
            }));
        }
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 == null || (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(tWSDevice2, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderNoiseReduction$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getNoiseReduction$lambda$7(ANCViewModel aNCViewModel, DeviceNoiseReduction deviceNoiseReduction) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "noiseLiveData :" + deviceNoiseReduction + "  isClick:" + aNCViewModel.isClick.get();
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
        if (aNCViewModel.isClick.get()) {
            return Unit.INSTANCE;
        }
        if (deviceNoiseReduction != null) {
            DeviceNoiseItem noiseReductionMode = deviceNoiseReduction.getNoiseReductionMode();
            if (noiseReductionMode != null) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "delay time noiseLiveData getNoiseReductionMode " + noiseReductionMode.getValue();
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
                aNCViewModel.updateTabLayoutSelected(noiseReductionMode.getValue());
            }
            DeviceNoiseItem lastNoiseReductionLevel = deviceNoiseReduction.getLastNoiseReductionLevel();
            if (lastNoiseReductionLevel != null) {
                aNCViewModel.noiseOpenSelectMode = lastNoiseReductionLevel.getValue();
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str7 = "noiseLiveData getLastNoiseReductionLevel " + lastNoiseReductionLevel.getValue();
                    String str8 = str7;
                    if (str8 != null && str8.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str9 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                        FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    public final void updateNoiseMode(int type) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "delay time updateNoiseMode type:" + type;
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
        updateTabLayoutSelected(type);
        Job job = this.ancJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.isClick.set(true);
        this.ancJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(type, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.elekid.anc.ANCViewModel$updateNoiseMode$2, reason: invalid class name */
    /* JADX INFO: compiled from: ANCViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.anc.ANCViewModel$updateNoiseMode$2", f = "ANCViewModel.kt", i = {1, 1}, l = {62, 118, 74}, m = "invokeSuspend", n = {"this_$iv", "needUpdate$iv"}, s = {"L$0", "I$0"})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $type;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ANCViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, ANCViewModel aNCViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$type = i;
            this.this$0 = aNCViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$type, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:52:0x012b  */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x013d, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(1500, r21) == r1) goto L55;
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
            ANCViewModel aNCViewModel;
            int i2;
            Message message;
            DeviceNoiseReduction value;
            DeviceNoiseReduction value2;
            DeviceNoiseItem noiseReductionMode;
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
                ANCViewModel aNCViewModel2 = (ANCViewModel) this.L$1;
                TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDeviceBuilder = tWSDeviceBuilder2;
                aNCViewModel = aNCViewModel2;
                i2 = i4;
                objSyncSetResponse$default = obj;
                message = (Message) objSyncSetResponse$default;
                if (message == null && message.isOk()) {
                    LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                    LiveData<DeviceNoiseReduction> noiseLiveData = aNCViewModel.getNoiseLiveData();
                    if (noiseLiveData != null && (value2 = noiseLiveData.getValue()) != null && (noiseReductionMode = value2.getNoiseReductionMode()) != null) {
                        noiseReductionMode.setValue(i);
                    }
                    LiveData<DeviceNoiseReduction> noiseLiveData2 = aNCViewModel.getNoiseLiveData();
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
            this.this$0.getIsClick().set(false);
            TWSDevice tWSDevice = this.this$0.getTWSDevice();
            if (tWSDevice != null && (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(tWSDevice, null, 1, null)) != null) {
                TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderNoiseReduction$default, false, (byte[]) null, 0, 7, (Object) null);
            }
            return Unit.INSTANCE;
            AppBuriedPointUtils.reportUserData$default(AppBuriedPointUtils.INSTANCE, new EventParams(AppBuriedPointUtils.CHANGE_MODE_EVENT, String.valueOf(this.$type), AppBuriedPointUtils.VALUE_TYPE_INT), false, 2, null);
            TWSDevice tWSDevice2 = this.this$0.getTWSDevice();
            if (tWSDevice2 == null || (tWSDeviceBuilderNoiseReduction = TWSDeviceExtKt.noiseReduction(tWSDevice2, Boxing.boxInt(this.$type))) == null) {
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
            } else {
                ANCViewModel aNCViewModel3 = this.this$0;
                i = this.$type;
                int setCommand = tWSDeviceBuilderNoiseReduction.getSetCommand();
                this.L$0 = tWSDeviceBuilderNoiseReduction;
                this.L$1 = aNCViewModel3;
                this.I$0 = 0;
                this.I$1 = i;
                this.label = 2;
                objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderNoiseReduction.getTwsDevice(), setCommand, tWSDeviceBuilderNoiseReduction.getSetPayload(), tWSDeviceBuilderNoiseReduction.getTimeOut(), tWSDeviceBuilderNoiseReduction.getIsNeedFsn(), false, tWSDeviceBuilderNoiseReduction.getMockResponse(), this, 16, null);
                if (objSyncSetResponse$default != coroutine_suspended) {
                    tWSDeviceBuilder = tWSDeviceBuilderNoiseReduction;
                    aNCViewModel = aNCViewModel3;
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

    private final void updateTabLayoutSelected(int mode) {
        if (mode != 0) {
            if (mode == 1) {
                this.noiseOpenSelectMode = 1;
                this.noiseModelIndex.postValue(1);
                return;
            }
            if (mode == 2) {
                this.noiseOpenSelectMode = 2;
                this.noiseModelIndex.postValue(2);
                return;
            }
            if (mode == 3) {
                this.noiseOpenSelectMode = 3;
                this.noiseModelIndex.postValue(3);
                return;
            } else if (mode == 4) {
                this.noiseOpenSelectMode = 4;
                this.noiseModelIndex.postValue(4);
                return;
            } else if (mode != 5) {
                if (mode == 7 || mode == 254) {
                    this.noiseModelIndex.postValue(7);
                    return;
                }
                return;
            }
        }
        this.noiseModelIndex.postValue(5);
    }
}
