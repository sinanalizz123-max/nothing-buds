package com.nothing.os.device.bluetooth.components;

import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.protocol.entity.DeviceExtraFeatureStatus;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import com.nothing.os.device.bluetooth.adapter.SwitchItemViewModel;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.Arrays;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: InEarDetectionComponents.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH\u0096@\u00a2\u0006\u0002\u0010\u001fR\u001b\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006 "}, d2 = {"Lcom/nothing/os/device/bluetooth/components/InEarDetectionComponents;", "Lcom/nothing/device/BaseFunctionComponents;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroid/content/Context;Lcom/nothing/device/IOTDevice;Landroidx/lifecycle/LifecycleOwner;)V", "liveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/base/protocol/entity/DeviceExtraFeatureStatus;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "viewModel", "Lcom/nothing/os/device/bluetooth/adapter/SwitchItemViewModel;", "getViewModel", "()Lcom/nothing/os/device/bluetooth/adapter/SwitchItemViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addListener", "", "clearObserver", "", "refresh", "getComponentsModel", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "onClickSwitchItem", "view", "Landroid/view/View;", "(Landroid/view/View;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InEarDetectionComponents extends BaseFunctionComponents {
    private final LiveData<DeviceExtraFeatureStatus> liveData;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.nothing.os.device.bluetooth.components.InEarDetectionComponents$onClickSwitchItem$1, reason: invalid class name */
    /* JADX INFO: compiled from: InEarDetectionComponents.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.bluetooth.components.InEarDetectionComponents", f = "InEarDetectionComponents.kt", i = {0, 0, 0}, l = {75}, m = "onClickSwitchItem", n = {"this", "open", "needUpdate$iv"}, s = {"L$0", "I$0", "I$1"})
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
            return InEarDetectionComponents.this.onClickSwitchItem(null, this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InEarDetectionComponents(final Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner) {
        final TWSDeviceBuilder tWSDeviceBuilderExtraFeatureStatus$default;
        super(context, iotDevice, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        TWSDevice twsDevice = iotDevice.getTwsDevice();
        LiveData<DeviceExtraFeatureStatus> map = null;
        if (twsDevice != null && (tWSDeviceBuilderExtraFeatureStatus$default = TWSDeviceExtKt.extraFeatureStatus$default(twsDevice, null, 1, null)) != null) {
            final Class<DeviceExtraFeatureStatus> cls = DeviceExtraFeatureStatus.class;
            map = Transformations.map(tWSDeviceBuilderExtraFeatureStatus$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderExtraFeatureStatus$default.getGetCommand(), tWSDeviceBuilderExtraFeatureStatus$default.getNotifyCommand()), new Function1<Message, DeviceExtraFeatureStatus>() { // from class: com.nothing.os.device.bluetooth.components.InEarDetectionComponents$special$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final DeviceExtraFeatureStatus invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    DeviceExtraFeatureStatus deviceExtraFeatureStatus = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    deviceExtraFeatureStatus = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (DeviceExtraFeatureStatus) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (DeviceExtraFeatureStatus) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.DeviceExtraFeatureStatus");
                                }
                                obj = (DeviceExtraFeatureStatus) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (DeviceExtraFeatureStatus) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (DeviceExtraFeatureStatus) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            deviceExtraFeatureStatus = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            deviceExtraFeatureStatus = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + deviceExtraFeatureStatus + StringUtils.SPACE;
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
                    return deviceExtraFeatureStatus;
                }
            });
        }
        this.liveData = map;
        this.viewModel = LazyKt.lazy(new Function0() { // from class: com.nothing.os.device.bluetooth.components.InEarDetectionComponents$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InEarDetectionComponents.viewModel_delegate$lambda$1(context);
            }
        });
        addListener(true);
    }

    public final LiveData<DeviceExtraFeatureStatus> getLiveData() {
        return this.liveData;
    }

    public final SwitchItemViewModel getViewModel() {
        return (SwitchItemViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SwitchItemViewModel viewModel_delegate$lambda$1(Context context) {
        SwitchItemViewModel switchItemViewModel = new SwitchItemViewModel(710);
        switchItemViewModel.getTitle().set(context.getString(R.string.sound_in_ear_detection));
        String string = context.getString(R.string.sound_in_ear_detection_tips);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        switchItemViewModel.setSummary(string);
        return switchItemViewModel;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void addListener(boolean clearObserver) {
        LiveData<DeviceExtraFeatureStatus> liveData;
        if (clearObserver && (liveData = this.liveData) != null) {
            liveData.removeObservers(getLifecycleOwner());
        }
        LiveData<DeviceExtraFeatureStatus> liveData2 = this.liveData;
        if (liveData2 != null) {
            liveData2.observe(getLifecycleOwner(), new InEarDetectionComponents$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.os.device.bluetooth.components.InEarDetectionComponents$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return InEarDetectionComponents.addListener$lambda$2(this.f$0, (DeviceExtraFeatureStatus) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addListener$lambda$2(InEarDetectionComponents inEarDetectionComponents, DeviceExtraFeatureStatus deviceExtraFeatureStatus) {
        inEarDetectionComponents.getViewModel().getChecked().set(Boolean.valueOf(deviceExtraFeatureStatus != null ? Intrinsics.areEqual((Object) deviceExtraFeatureStatus.getEnable(1), (Object) true) : false));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void refresh() {
        TWSDeviceBuilder tWSDeviceBuilderExtraFeatureStatus$default;
        TWSDevice twsDevice = getIotDevice().getTwsDevice();
        if (twsDevice == null || (tWSDeviceBuilderExtraFeatureStatus$default = TWSDeviceExtKt.extraFeatureStatus$default(twsDevice, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderExtraFeatureStatus$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public CommonBindingMoreType getComponentsModel() {
        return getViewModel();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.nothing.device.BaseFunctionComponents
    public Object onClickSwitchItem(View view, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        TWSDeviceBuilder tWSDeviceBuilderExtraFeatureStatus;
        int i;
        InEarDetectionComponents inEarDetectionComponents;
        int i2;
        TWSDeviceBuilder tWSDeviceBuilder;
        DeviceExtraFeatureStatus value;
        DeviceExtraFeatureStatus value2;
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
            Boolean bool = getViewModel().getChecked().get();
            boolean z = !(bool != null ? bool.booleanValue() : false);
            getViewModel().getChecked().set(Boxing.boxBoolean(z));
            TWSDevice twsDevice = getIotDevice().getTwsDevice();
            if (twsDevice != null && (tWSDeviceBuilderExtraFeatureStatus = TWSDeviceExtKt.extraFeatureStatus(twsDevice, Boxing.boxBoolean(z))) != null) {
                int setCommand = tWSDeviceBuilderExtraFeatureStatus.getSetCommand();
                TWSDevice twsDevice2 = tWSDeviceBuilderExtraFeatureStatus.getTwsDevice();
                byte[] setPayload = tWSDeviceBuilderExtraFeatureStatus.getSetPayload();
                Long timeOut = tWSDeviceBuilderExtraFeatureStatus.getTimeOut();
                boolean isNeedFsn = tWSDeviceBuilderExtraFeatureStatus.getIsNeedFsn();
                byte[] mockResponse = tWSDeviceBuilderExtraFeatureStatus.getMockResponse();
                anonymousClass2.L$0 = this;
                anonymousClass2.L$1 = tWSDeviceBuilderExtraFeatureStatus;
                anonymousClass2.I$0 = z ? 1 : 0;
                anonymousClass2.I$1 = 0;
                anonymousClass2.label = 1;
                Object objSyncSetResponse$default = TWSDevice.syncSetResponse$default(twsDevice2, setCommand, setPayload, timeOut, isNeedFsn, false, mockResponse, anonymousClass2, 16, null);
                if (objSyncSetResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = z ? 1 : 0;
                obj = objSyncSetResponse$default;
                inEarDetectionComponents = this;
                i2 = 0;
                tWSDeviceBuilder = tWSDeviceBuilderExtraFeatureStatus;
            }
            return Boxing.boxBoolean(true);
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        i2 = anonymousClass2.I$1;
        i = anonymousClass2.I$0;
        tWSDeviceBuilder = (TWSDeviceBuilder) anonymousClass2.L$1;
        inEarDetectionComponents = (InEarDetectionComponents) anonymousClass2.L$0;
        ResultKt.throwOnFailure(obj);
        Message message = (Message) obj;
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
            LiveData<DeviceExtraFeatureStatus> liveData = inEarDetectionComponents.liveData;
            if (liveData != null && (value2 = liveData.getValue()) != null) {
                Boxing.boxBoolean(value2.setEnable(1, i != 0));
            }
            LiveData<DeviceExtraFeatureStatus> liveData2 = inEarDetectionComponents.liveData;
            byte[] bArrObtainDataPacket = (liveData2 == null || (value = liveData2.getValue()) == null) ? null : value.obtainDataPacket();
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
        return Boxing.boxBoolean(true);
    }
}
