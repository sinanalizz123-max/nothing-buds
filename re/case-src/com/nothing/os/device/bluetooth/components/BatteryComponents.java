package com.nothing.os.device.bluetooth.components;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.earbase.ota.entity.DeviceBattery;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BatteryComponents.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/nothing/os/device/bluetooth/components/BatteryComponents;", "Lcom/nothing/device/BaseFunctionComponents;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "action", "Lkotlin/Function1;", "Lcom/nothing/earbase/ota/entity/DeviceBattery;", "", "<init>", "(Landroid/content/Context;Lcom/nothing/device/IOTDevice;Landroidx/lifecycle/LifecycleOwner;Lkotlin/jvm/functions/Function1;)V", "getAction", "()Lkotlin/jvm/functions/Function1;", "hasBatteryShow", "", "getHasBatteryShow", "()Z", "setHasBatteryShow", "(Z)V", "hasCaseBatteryShow", "getHasCaseBatteryShow", "setHasCaseBatteryShow", "refresh", "addListener", "clearObserver", "getComponentsModel", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BatteryComponents extends BaseFunctionComponents {
    public static final int ORDER_BATTERY = 0;
    private final Function1<DeviceBattery, Unit> action;
    private boolean hasBatteryShow;
    private boolean hasCaseBatteryShow;

    @Override // com.nothing.device.BaseFunctionComponents
    public CommonBindingMoreType getComponentsModel() {
        return null;
    }

    public final Function1<DeviceBattery, Unit> getAction() {
        return this.action;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BatteryComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner, Function1<? super DeviceBattery, Unit> action) {
        TWSDeviceBuilder tWSDeviceBuilderBattery;
        LiveData<Message> liveData;
        Message value;
        DeviceBattery deviceBattery;
        super(context, iotDevice, lifecycleOwner);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(action, "action");
        this.action = action;
        TWSDevice twsDevice = iotDevice.getTwsDevice();
        this.hasCaseBatteryShow = (twsDevice == null || (tWSDeviceBuilderBattery = TWSDeviceExtKt.battery(twsDevice)) == null || (liveData = tWSDeviceBuilderBattery.getLiveData()) == null || (value = liveData.getValue()) == null || (deviceBattery = (DeviceBattery) value.obtainPayload(DeviceBattery.class)) == null) ? false : deviceBattery.hasCaseBattery();
        addListener(true);
    }

    public final boolean getHasBatteryShow() {
        return this.hasBatteryShow;
    }

    public final void setHasBatteryShow(boolean z) {
        this.hasBatteryShow = z;
    }

    public final boolean getHasCaseBatteryShow() {
        return this.hasCaseBatteryShow;
    }

    public final void setHasCaseBatteryShow(boolean z) {
        this.hasCaseBatteryShow = z;
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void refresh() {
        TWSDeviceBuilder tWSDeviceBuilderBattery;
        TWSDevice twsDevice = getIotDevice().getTwsDevice();
        if (twsDevice == null || (tWSDeviceBuilderBattery = TWSDeviceExtKt.battery(twsDevice)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderBattery, false, (byte[]) null, 0, 7, (Object) null);
    }

    @Override // com.nothing.device.BaseFunctionComponents
    public void addListener(boolean clearObserver) {
        TWSDeviceBuilder tWSDeviceBuilderBattery;
        LiveData<Message> liveData;
        TWSDevice twsDevice;
        TWSDeviceBuilder tWSDeviceBuilderBattery2;
        LiveData<Message> liveData2;
        if (clearObserver && (twsDevice = getIotDevice().getTwsDevice()) != null && (tWSDeviceBuilderBattery2 = TWSDeviceExtKt.battery(twsDevice)) != null && (liveData2 = tWSDeviceBuilderBattery2.getLiveData()) != null) {
            liveData2.removeObservers(getLifecycleOwner());
        }
        TWSDevice twsDevice2 = getIotDevice().getTwsDevice();
        if (twsDevice2 == null || (tWSDeviceBuilderBattery = TWSDeviceExtKt.battery(twsDevice2)) == null || (liveData = tWSDeviceBuilderBattery.getLiveData()) == null) {
            return;
        }
        liveData.observe(getLifecycleOwner(), new BatteryComponents$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.os.device.bluetooth.components.BatteryComponents$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BatteryComponents.addListener$lambda$1(this.f$0, (Message) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addListener$lambda$1(BatteryComponents batteryComponents, Message message) {
        DeviceBattery deviceBattery;
        if (message != null && (deviceBattery = (DeviceBattery) message.obtainPayload(DeviceBattery.class)) != null) {
            batteryComponents.hasCaseBatteryShow = deviceBattery.hasCaseBattery();
            batteryComponents.action.invoke(deviceBattery);
            batteryComponents.hasBatteryShow = true;
        }
        return Unit.INSTANCE;
    }
}
