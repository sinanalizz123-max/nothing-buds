package com.nothing.hoothoot.core.device;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.nothing.base.util.APPConstant;
import com.nothing.base.util.Logger;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceAction;
import com.nothing.device.IOTDeviceManager;
import com.nothing.donphan.control.ControlActivity;
import com.nothing.donphan.control.ControlOperationActivity;
import com.nothing.donphan.equalizer.EqualizerActivity;
import com.nothing.donphan.ota.FirmwareActivity;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: IOTDonphanAction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/hoothoot/core/device/IOTDonphanAction;", "Lcom/nothing/device/IOTDeviceAction;", "<init>", "()V", "startControlActivity", "", "activity", "Landroid/app/Activity;", "earView", "Lkotlin/Triple;", "Landroid/view/View;", "isLeft", "", "startEqualizerActivity", "startGestureOperationActivity", "address", "", "startFirmwareActivity", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTDonphanAction extends IOTDeviceAction {
    @Override // com.nothing.device.IOTDeviceAction
    public void startControlActivity(Activity activity, Triple<? extends View, ? extends View, ? extends View> earView, boolean isLeft) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(earView, "earView");
        ControlActivity.INSTANCE.start(activity, earView.getFirst(), earView.getSecond(), isLeft);
    }

    @Override // com.nothing.device.IOTDeviceAction
    public void startEqualizerActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.startActivity(new Intent(activity, (Class<?>) EqualizerActivity.class));
    }

    /* JADX INFO: renamed from: com.nothing.hoothoot.core.device.IOTDonphanAction$startGestureOperationActivity$1, reason: invalid class name */
    /* JADX INFO: compiled from: IOTDonphanAction.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.hoothoot.core.device.IOTDonphanAction$startGestureOperationActivity$1", f = "IOTDonphanAction.kt", i = {0, 0}, l = {49}, m = "invokeSuspend", n = {"$this$launch", "options"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        final /* synthetic */ String $address;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$address = str;
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$address, this.$activity, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0078  */
        /* JADX WARN: Code duplicated, block: B:30:0x00e8  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ControlConfigurationEntity.Operation operation;
            Boolean bool;
            TWSDevice twsDevice;
            TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
            ControlConfigurationEntity.Operation operation2;
            Logger logger;
            String tag;
            int depth;
            String str;
            String str2;
            String strComponent1;
            String strComponent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                operation = new ControlConfigurationEntity.Operation(2, 1, 7, 11);
                ControlConfigurationEntity controlConfigurationEntity = new ControlConfigurationEntity(operation);
                IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(this.$address);
                if (iOTDeviceByMacAddress == null || (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) == null || (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(twsDevice)) == null) {
                    bool = null;
                } else {
                    this.L$0 = coroutineScope;
                    this.L$1 = operation;
                    this.label = 1;
                    obj = tWSDeviceBuilderKeyConfiguration.setSync(controlConfigurationEntity.obtainDataPacket(), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    operation2 = operation;
                }
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str = "startGestureOperationActivity isSuccess " + bool + ",operation :" + operation;
                    str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        strComponent1 = trace.component1();
                        strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                Intent intent = new Intent(this.$activity, (Class<?>) ControlOperationActivity.class);
                Bundle bundle = new Bundle();
                bundle.putBoolean("IS_LEFT_SELECTED", true);
                bundle.putParcelable("SELECTED_OPERATION", operation);
                intent.putExtras(bundle);
                this.$activity.startActivity(intent);
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            operation2 = (ControlConfigurationEntity.Operation) this.L$1;
            ResultKt.throwOnFailure(obj);
            bool = (Boolean) obj;
            operation = operation2;
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "startGestureOperationActivity isSuccess " + bool + ",operation :" + operation;
                str2 = str;
                if (str2 != null) {
                    Pair<String, String> trace2 = logger.getTrace(depth);
                    strComponent1 = trace2.component1();
                    strComponent2 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 4, str4, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            Intent intent2 = new Intent(this.$activity, (Class<?>) ControlOperationActivity.class);
            Bundle bundle2 = new Bundle();
            bundle2.putBoolean("IS_LEFT_SELECTED", true);
            bundle2.putParcelable("SELECTED_OPERATION", operation);
            intent2.putExtras(bundle2);
            this.$activity.startActivity(intent2);
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.device.IOTDeviceAction
    public void startGestureOperationActivity(Activity activity, String address) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(address, activity, null), 3, null);
    }

    @Override // com.nothing.device.IOTDeviceAction
    public void startFirmwareActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Bundle bundle = new Bundle();
        bundle.putBoolean(APPConstant.NOTIFICATION_UPDATE, true);
        activity.startActivity(new Intent(activity, (Class<?>) FirmwareActivity.class).putExtras(bundle));
    }
}
