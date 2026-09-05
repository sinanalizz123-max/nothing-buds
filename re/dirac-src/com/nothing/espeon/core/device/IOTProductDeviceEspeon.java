package com.nothing.espeon.core.device;

import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.lifecycle.LifecycleOwner;
import com.nothing.base.router.BaseNothingDevice;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.router.device.DeviceType;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.widget.TWSWidgetAction;
import com.nothing.espeon.base.EspeonImpl;
import com.nothing.espeon.core.EspeonDevice;
import com.nothing.espeon.core.protocol.device.EspeonOTAProcess;
import com.nothing.espeon.core.protocol.device.EspeonProtocol;
import com.nothing.espeon.equalizer.os.EqualizerComponents;
import com.nothing.os.device.bluetooth.components.bassboost.os.SpatialAudioComponents;
import com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents;
import com.nothing.ota.entity.OTAProcess;
import com.nothing.protocol.device.TWSDevice;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDeviceEspeon.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0016J\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J6\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0016JD\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020!`\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020\u0005H\u0016\u00a8\u0006-"}, d2 = {"Lcom/nothing/espeon/core/device/IOTProductDeviceEspeon;", "Lcom/nothing/device/IOTProductDevice;", "<init>", "()V", "supportSmartDial", "", "initDeviceGesture", "", "hasBassBoostFunction", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "", "getSupportANCLevel", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "createFunctionComponents", "Ljava/util/HashMap;", "Lcom/nothing/device/BaseFunctionComponents;", "Lkotlin/collections/HashMap;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "twsConnected", "hasSpatialAudioFunction", "hldcOrDiracOne", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTProductDeviceEspeon extends IOTProductDevice {
    public static final String EAR_BLUE_ID = "2B353E";
    public static final String EAR_ID = "F29566";
    public static final String EAR_ORANGE_ID = "A7B220";
    public static final String EAR_WHITE_ID = "CA36A6";
    public static final String PRODUCT_ID = "B172";

    @Override // com.nothing.device.IOTProductDevice
    public int getSupportANCLevel() {
        return 4;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasBassBoostFunction() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasSpatialAudioFunction() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hldcOrDiracOne() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean supportSmartDial() {
        return true;
    }

    public IOTProductDeviceEspeon() {
        setDeviceName("Buds Pro 2");
        setProductId("B172");
        setProjectId("23272");
        setProductReleaseOrder("3");
        setDeviceType(DeviceType.TWS);
        setAction(new IOTEspeonAction());
        setOsAction(new IOTEspeonOsAction());
        setGestureAction(new IOTEarEspeonGestureAction());
        getDeviceList().add(new IOTEspeonBlack());
        getDeviceList().add(new IOTEspeonWhite());
        getDeviceList().add(new IOTEspeonOrange());
        getDeviceList().add(new IOTEspeonBlue());
        setIntroduceMsg(R.string.vc_pairing_guide);
        setIntroduceSummary(R.string.pair_guide_question);
        setWidgetAction(new TWSWidgetAction());
        setCaseLottieJson("lottie/espeon_case_help_pairing.json");
        setCaseImage(R.drawable.espeon_case);
        setSupportImage(R.drawable.espeon_support_image);
        setProtocol(new EspeonProtocol());
        setBluetoothName("CMF Buds Pro 2");
        setHasFeedback(true);
        setHelpDeviceName("Buds Pro 2");
        setPushTopic("ear_espeon_firmware");
        setPublishDevice(false);
        setCmfText(true);
        initDeviceGesture();
    }

    private final void initDeviceGesture() {
        Iterator<T> it = getDeviceList().iterator();
        while (it.hasNext()) {
            ((IOTDevice) it.next()).addAllGesturesItem(getGestureAction().getGesturesList());
        }
    }

    @Override // com.nothing.device.IOTProductDevice
    public Pair<Float, Float> getSimpleCustomEQParameter(int type) {
        Float fValueOf = Float.valueOf(0.8f);
        Float fValueOf2 = Float.valueOf(140.0f);
        if (type == 0) {
            return TuplesKt.to(fValueOf2, fValueOf);
        }
        if (type == 1) {
            return TuplesKt.to(Float.valueOf(980.0f), Float.valueOf(0.7f));
        }
        if (type == 2) {
            return TuplesKt.to(Float.valueOf(6900.0f), Float.valueOf(1.0f));
        }
        return TuplesKt.to(fValueOf2, fValueOf);
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOSOTADevice(String address, String modelId) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return new EspeonDevice(address, modelId);
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        return new EspeonOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return new EspeonImpl(callbacks, handler, coroutineScope, modelId, macAddress);
    }

    @Override // com.nothing.device.IOTProductDevice
    public HashMap<Integer, BaseFunctionComponents> createFunctionComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner, boolean twsConnected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (twsConnected) {
            HashMap<Integer, BaseFunctionComponents> map = new HashMap<>();
            HashMap<Integer, BaseFunctionComponents> map2 = map;
            map2.put(Integer.valueOf(UltraBassComponents.ORDER_ULTRA_BASS), new UltraBassComponents(context, iotDevice, lifecycleOwner));
            map2.put(620, new EqualizerComponents(context, iotDevice, lifecycleOwner));
            TWSDevice twsDevice = iotDevice.getTwsDevice();
            if (twsDevice != null && !twsDevice.getQueryAudio()) {
                TWSDevice twsDevice2 = iotDevice.getTwsDevice();
                if (twsDevice2 != null) {
                    twsDevice2.setPhoneAudio(RouterFactory.INSTANCE.getOsRouter().getSupportAudio(iotDevice.getMacAddress()));
                }
                TWSDevice twsDevice3 = iotDevice.getTwsDevice();
                if (twsDevice3 != null) {
                    twsDevice3.setQueryAudio(true);
                }
            }
            TWSDevice twsDevice4 = iotDevice.getTwsDevice();
            if (twsDevice4 != null && !twsDevice4.getPhoneAudio()) {
                map2.put(Integer.valueOf(SpatialAudioComponents.ORDER_SPATIAL_AUDIO), new SpatialAudioComponents(context, iotDevice, lifecycleOwner));
            }
            return map;
        }
        return new HashMap<>();
    }
}
