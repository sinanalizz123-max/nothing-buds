package com.nothing.smart.widgets;

import android.util.Log;
import androidx.lifecycle.LiveData;
import com.nothing.base.util.Logger;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.widget.entity.BaseWidgetUIModel;
import com.nothing.device.widget.entity.DeviceNoiseReduction;
import com.nothing.log.FileLog;
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
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: WidgetDeviceDelegate.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.smart.widgets.WidgetDeviceDelegate$sendNoiseLevel$3$1$1", f = "WidgetDeviceDelegate.kt", i = {0, 0, 0, 0, 0}, l = {1288}, m = "invokeSuspend", n = {"twsDevice", "$this$invokeSuspend_u24lambda_u244", "this_$iv", "noiseModel", "needUpdate$iv"}, s = {"L$0", "L$2", "L$3", "I$0", "I$1"})
final class WidgetDeviceDelegate$sendNoiseLevel$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseWidgetUIModel $widgetUIData;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ WidgetDeviceDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WidgetDeviceDelegate$sendNoiseLevel$3$1$1(WidgetDeviceDelegate widgetDeviceDelegate, BaseWidgetUIModel baseWidgetUIModel, Continuation<? super WidgetDeviceDelegate$sendNoiseLevel$3$1$1> continuation) {
        super(2, continuation);
        this.this$0 = widgetDeviceDelegate;
        this.$widgetUIData = baseWidgetUIModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WidgetDeviceDelegate$sendNoiseLevel$3$1$1 widgetDeviceDelegate$sendNoiseLevel$3$1$1 = new WidgetDeviceDelegate$sendNoiseLevel$3$1$1(this.this$0, this.$widgetUIData, continuation);
        widgetDeviceDelegate$sendNoiseLevel$3$1$1.L$0 = obj;
        return widgetDeviceDelegate$sendNoiseLevel$3$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WidgetDeviceDelegate$sendNoiseLevel$3$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        TWSDeviceBuilder tWSDeviceBuilder;
        Object objSyncSetResponse$default;
        int i;
        TWSDevice tWSDevice;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.this$0.getDeviceList().get(this.$widgetUIData.getDeviceAddress()));
            TWSDevice twsDevice = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "click noise event twsDevice is null:" + (twsDevice == null);
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
            if (twsDevice != null) {
                WidgetDeviceDelegate widgetDeviceDelegate = this.this$0;
                BaseWidgetUIModel baseWidgetUIModel = this.$widgetUIData;
                int noiseModel = widgetDeviceDelegate.getNoiseModel(baseWidgetUIModel);
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "send noise level current model=" + noiseModel + ",widgetUIData model:" + baseWidgetUIModel.getNoiseModel();
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
                String address = twsDevice.getAddress();
                if (address == null) {
                    address = "";
                }
                widgetDeviceDelegate.deviceNoiseBuriedPoint(noiseModel, address);
                TWSDeviceBuilder tWSDeviceBuilderNoiseReduction = TWSDeviceExtKt.noiseReduction(twsDevice, Boxing.boxInt(noiseModel));
                int setCommand = tWSDeviceBuilderNoiseReduction.getSetCommand();
                TWSDevice twsDevice2 = tWSDeviceBuilderNoiseReduction.getTwsDevice();
                byte[] setPayload = tWSDeviceBuilderNoiseReduction.getSetPayload();
                Long timeOut = tWSDeviceBuilderNoiseReduction.getTimeOut();
                boolean isNeedFsn = tWSDeviceBuilderNoiseReduction.getIsNeedFsn();
                byte[] mockResponse = tWSDeviceBuilderNoiseReduction.getMockResponse();
                this.L$0 = twsDevice;
                this.L$1 = twsDevice;
                this.L$2 = twsDevice;
                this.L$3 = tWSDeviceBuilderNoiseReduction;
                this.I$0 = noiseModel;
                this.I$1 = 1;
                this.label = 1;
                tWSDeviceBuilder = tWSDeviceBuilderNoiseReduction;
                objSyncSetResponse$default = TWSDevice.syncSetResponse$default(twsDevice2, setCommand, setPayload, timeOut, isNeedFsn, false, mockResponse, this, 16, null);
                if (objSyncSetResponse$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = 1;
                tWSDevice = twsDevice;
                i2 = noiseModel;
            }
            return Unit.INSTANCE;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i4 = this.I$1;
        int i5 = this.I$0;
        TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) this.L$3;
        tWSDevice = (TWSDevice) this.L$0;
        ResultKt.throwOnFailure(obj);
        tWSDeviceBuilder = tWSDeviceBuilder2;
        i2 = i5;
        i = i4;
        objSyncSetResponse$default = obj;
        Message message = (Message) objSyncSetResponse$default;
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "click noise event set successful".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str7 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                FileLog.print$default(fileLog3, 3, str7, tag3, "click noise event set successful " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, "click noise event set successful " + strComponent6);
                }
            }
            Message value = TWSDeviceExtKt.noiseReduction$default(tWSDevice, null, 1, null).getLiveData().getValue();
            DeviceNoiseReduction deviceNoiseReduction = value != null ? (DeviceNoiseReduction) value.obtainPayload(DeviceNoiseReduction.class) : null;
            if (deviceNoiseReduction != null) {
                deviceNoiseReduction.updateLastNoiseReductionLevel(i2);
            }
            byte[] bArrObtainDataPacket = deviceNoiseReduction != null ? deviceNoiseReduction.obtainDataPacket() : null;
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
