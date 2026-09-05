package com.nothing.earbase.os.base;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.earbase.anc.entity.DeviceNoiseItem;
import com.nothing.earbase.anc.entity.DeviceNoiseReduction;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: BaseNothingEarImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.earbase.os.base.BaseNothingEarImpl$setNoiseCancellation$1$1$1", f = "BaseNothingEarImpl.kt", i = {0, 0, 0}, l = {1418, 685}, m = "invokeSuspend", n = {"noiseEntity", "this_$iv", "needUpdate$iv"}, s = {"L$0", "L$1", "I$0"})
final class BaseNothingEarImpl$setNoiseCancellation$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ TWSDevice $this_apply;
    final /* synthetic */ String $type;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ BaseNothingEarImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseNothingEarImpl$setNoiseCancellation$1$1$1(BaseNothingEarImpl baseNothingEarImpl, String str, TWSDevice tWSDevice, Bundle bundle, Continuation<? super BaseNothingEarImpl$setNoiseCancellation$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = baseNothingEarImpl;
        this.$type = str;
        this.$this_apply = tWSDevice;
        this.$extras = bundle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseNothingEarImpl$setNoiseCancellation$1$1$1(this.this$0, this.$type, this.$this_apply, this.$extras, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseNothingEarImpl$setNoiseCancellation$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x013a, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(2000, r20) == r1) goto L45;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object objSyncSetResponse$default;
        DeviceNoiseReduction deviceNoiseReduction;
        TWSDeviceBuilder tWSDeviceBuilder;
        String str;
        int i;
        DeviceNoiseItem noiseReductionMode;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getIsClick().set(true);
            AppBuriedPointUtils.reportUserData$default(AppBuriedPointUtils.INSTANCE, new EventParams(AppBuriedPointUtils.CHANGE_MODE_EVENT, this.$type.toString(), AppBuriedPointUtils.VALUE_TYPE_INT), false, 2, null);
            Message value = TWSDeviceExtKt.noiseReduction$default(this.$this_apply, null, 1, null).getLiveData().getValue();
            DeviceNoiseReduction deviceNoiseReduction2 = value != null ? (DeviceNoiseReduction) value.obtainPayload(DeviceNoiseReduction.class) : null;
            TWSDeviceBuilder tWSDeviceBuilderNoiseReduction = TWSDeviceExtKt.noiseReduction(this.$this_apply, Boxing.boxInt(Integer.parseInt(this.$type)));
            String str2 = this.$type;
            int setCommand = tWSDeviceBuilderNoiseReduction.getSetCommand();
            this.L$0 = deviceNoiseReduction2;
            this.L$1 = tWSDeviceBuilderNoiseReduction;
            this.L$2 = str2;
            this.I$0 = 0;
            this.label = 1;
            objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderNoiseReduction.getTwsDevice(), setCommand, tWSDeviceBuilderNoiseReduction.getSetPayload(), tWSDeviceBuilderNoiseReduction.getTimeOut(), tWSDeviceBuilderNoiseReduction.getIsNeedFsn(), false, tWSDeviceBuilderNoiseReduction.getMockResponse(), this, 16, null);
            if (objSyncSetResponse$default != coroutine_suspended) {
                deviceNoiseReduction = deviceNoiseReduction2;
                tWSDeviceBuilder = tWSDeviceBuilderNoiseReduction;
                str = str2;
                i = 0;
            }
            return coroutine_suspended;
        }
        if (i2 == 1) {
            int i3 = this.I$0;
            String str3 = (String) this.L$2;
            TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) this.L$1;
            DeviceNoiseReduction deviceNoiseReduction3 = (DeviceNoiseReduction) this.L$0;
            ResultKt.throwOnFailure(obj);
            deviceNoiseReduction = deviceNoiseReduction3;
            tWSDeviceBuilder = tWSDeviceBuilder2;
            str = str3;
            i = i3;
            objSyncSetResponse$default = obj;
        } else {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.this$0.getIsClick().set(false);
        TWSDeviceBuilder.sendMessage$default(TWSDeviceExtKt.noiseReduction$default(this.$this_apply, null, 1, null), false, (byte[]) null, 0, 7, (Object) null);
        return Unit.INSTANCE;
        Message message = (Message) objSyncSetResponse$default;
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
            if (deviceNoiseReduction != null && (noiseReductionMode = deviceNoiseReduction.getNoiseReductionMode()) != null) {
                noiseReductionMode.setValue(Integer.parseInt(str));
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
        if (deviceNoiseReduction != null) {
            this.this$0.responseANCData(this.$extras, deviceNoiseReduction);
        }
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
    }
}
