package com.nothing.os.device.bluetooth.components.bassboost.os;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.protocol.entity.BasicBoolean;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.log.FileLog;
import com.nothing.os.device.bluetooth.adapter.SwitchItemViewModel;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: SpatialAudioComponents.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001cH\u0096@\u00a2\u0006\u0002\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u0016H\u0016R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/nothing/os/device/bluetooth/components/bassboost/os/SpatialAudioComponents;", "Lcom/nothing/device/BaseFunctionComponents;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/nothing/device/IOTDevice;Landroidx/lifecycle/LifecycleOwner;)V", "spatialViewModel", "Lcom/nothing/os/device/bluetooth/adapter/SwitchItemViewModel;", "getSpatialViewModel", "()Lcom/nothing/os/device/bluetooth/adapter/SwitchItemViewModel;", "spatialLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/base/protocol/entity/BasicBoolean;", "getSpatialLiveData", "()Landroidx/lifecycle/LiveData;", "addListener", "", "clearObserver", "", "refresh", "getComponentsModel", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "onClickSwitchItem", "view", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "needRequest", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SpatialAudioComponents extends BaseFunctionComponents {
    public static final int ORDER_SPATIAL_AUDIO = 630;
    private final LiveData<BasicBoolean> spatialLiveData;
    private final SwitchItemViewModel spatialViewModel;

    /* JADX INFO: renamed from: com.nothing.os.device.bluetooth.components.bassboost.os.SpatialAudioComponents$onClickSwitchItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: SpatialAudioComponents.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.bluetooth.components.bassboost.os.SpatialAudioComponents", f = "SpatialAudioComponents.kt", i = {0, 0, 0}, l = {70}, m = "onClickSwitchItem", n = {"this", "state", "needUpdate$iv"}, s = {"L$0", "I$0", "I$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpatialAudioComponents.this.onClickSwitchItem(null, this);
        }
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public boolean needRequest() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpatialAudioComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner) {
        final TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default;
        super(context, iotDevice, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.spatialViewModel = new SpatialAudioViewModel(context);
        TWSDevice twsDevice = iotDevice.getTwsDevice();
        LiveData<BasicBoolean> map = null;
        if (twsDevice != null && (tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(twsDevice, null, null, 3, null)) != null) {
            final Class<BasicBoolean> cls = BasicBoolean.class;
            map = Transformations.map(tWSDeviceBuilderSpatialAudio$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default.getGetCommand(), tWSDeviceBuilderSpatialAudio$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.os.device.bluetooth.components.bassboost.os.SpatialAudioComponents$special$$inlined$getLiveData$1
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
        this.spatialLiveData = map;
        addListener(true);
    }

    public final SwitchItemViewModel getSpatialViewModel() {
        return this.spatialViewModel;
    }

    public final LiveData<BasicBoolean> getSpatialLiveData() {
        return this.spatialLiveData;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void addListener(boolean clearObserver) {
        LiveData<BasicBoolean> liveData;
        if (clearObserver && (liveData = this.spatialLiveData) != null) {
            liveData.removeObservers(getLifecycleOwner());
        }
        LiveData<BasicBoolean> liveData2 = this.spatialLiveData;
        if (liveData2 != null) {
            liveData2.observe(getLifecycleOwner(), new SpatialAudioComponents$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.os.device.bluetooth.components.bassboost.os.SpatialAudioComponents$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return SpatialAudioComponents.addListener$lambda$0(this.f$0, (BasicBoolean) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addListener$lambda$0(SpatialAudioComponents spatialAudioComponents, BasicBoolean basicBoolean) {
        boolean z = false;
        if (basicBoolean != null && basicBoolean.getOpen()) {
            z = true;
        }
        spatialAudioComponents.spatialViewModel.getChecked().set(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void refresh() {
        TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default;
        TWSDevice twsDevice = getIotDevice().getTwsDevice();
        if (twsDevice == null || (tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(twsDevice, null, null, 3, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderSpatialAudio$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public CommonBindingMoreType getComponentsModel() {
        return this.spatialViewModel;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    @Override // com.nothing.device.BaseFunctionComponents
    public Object onClickSwitchItem(View view, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        boolean z;
        TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default;
        int i;
        SpatialAudioComponents spatialAudioComponents;
        int i2;
        TWSDeviceBuilder tWSDeviceBuilder;
        BasicBoolean value;
        BasicBoolean value2;
        BasicBoolean value3;
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
        int i3 = anonymousClass2.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            LiveData<BasicBoolean> liveData = this.spatialLiveData;
            boolean z2 = !((liveData == null || (value = liveData.getValue()) == null) ? false : value.getOpen());
            TWSDevice twsDevice = getIotDevice().getTwsDevice();
            if (twsDevice == null || (tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(twsDevice, Boxing.boxBoolean(z2), null, 2, null)) == null) {
                z = true;
            } else {
                int setCommand = tWSDeviceBuilderSpatialAudio$default.getSetCommand();
                TWSDevice twsDevice2 = tWSDeviceBuilderSpatialAudio$default.getTwsDevice();
                byte[] setPayload = tWSDeviceBuilderSpatialAudio$default.getSetPayload();
                Long timeOut = tWSDeviceBuilderSpatialAudio$default.getTimeOut();
                boolean isNeedFsn = tWSDeviceBuilderSpatialAudio$default.getIsNeedFsn();
                byte[] mockResponse = tWSDeviceBuilderSpatialAudio$default.getMockResponse();
                anonymousClass2.L$0 = this;
                anonymousClass2.L$1 = tWSDeviceBuilderSpatialAudio$default;
                anonymousClass2.I$0 = z2 ? 1 : 0;
                anonymousClass2.I$1 = 1;
                anonymousClass2.label = 1;
                z = true;
                Object objSyncSetResponse$default = TWSDevice.syncSetResponse$default(twsDevice2, setCommand, setPayload, timeOut, isNeedFsn, false, mockResponse, anonymousClass2, 16, null);
                if (objSyncSetResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = z2 ? 1 : 0;
                obj = objSyncSetResponse$default;
                spatialAudioComponents = this;
                i2 = 1;
                tWSDeviceBuilder = tWSDeviceBuilderSpatialAudio$default;
            }
            return Boxing.boxBoolean(z);
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i4 = anonymousClass2.I$1;
        i = anonymousClass2.I$0;
        tWSDeviceBuilder = (TWSDeviceBuilder) anonymousClass2.L$1;
        spatialAudioComponents = (SpatialAudioComponents) anonymousClass2.L$0;
        ResultKt.throwOnFailure(obj);
        z = true;
        i2 = i4;
        Message message = (Message) obj;
        if (message != null && message.isOk() == z) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
            LiveData<BasicBoolean> liveData2 = spatialAudioComponents.spatialLiveData;
            if (liveData2 != null && (value3 = liveData2.getValue()) != null) {
                value3.setOpen(i != 0 ? z : false);
            }
            LiveData<BasicBoolean> liveData3 = spatialAudioComponents.spatialLiveData;
            byte[] bArrObtainDataPacket = (liveData3 == null || (value2 = liveData3.getValue()) == null) ? null : value2.obtainDataPacket();
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
            Boxing.boxBoolean(z);
        } else {
            Boxing.boxBoolean(false);
        }
        return Boxing.boxBoolean(z);
    }
}
