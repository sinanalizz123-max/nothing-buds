package com.nothing.ear.twos.core.device;

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
import com.nothing.ear.twos.base.EarTwosImpl;
import com.nothing.ear.twos.core.EarTwosDevice;
import com.nothing.ear.twos.core.protocol.device.EarTwosOTAProcess;
import com.nothing.ear.twos.core.protocol.device.EarTwosProtocol;
import com.nothing.earbase.widget.TWSWidgetAction;
import com.nothing.os.device.DeviceConstant;
import com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents;
import com.nothing.ota.entity.OTAProcess;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDeviceEarTwos.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J6\u0010\u0018\u001a\u00020\u00122\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0014H\u0016JD\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020#0\"j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020#`$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\tH\u0016J\b\u0010-\u001a\u00020\tH\u0016\u00a8\u0006/"}, d2 = {"Lcom/nothing/ear/twos/core/device/IOTProductDeviceEarTwos;", "Lcom/nothing/device/IOTProductDevice;", "<init>", "()V", "initDeviceGesture", "", "getSupportANCLevel", "", "hasFirFunction", "", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "initDevice", "hasBassBoostFunction", "getTotalGain", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "createFunctionComponents", "Ljava/util/HashMap;", "Lcom/nothing/device/BaseFunctionComponents;", "Lkotlin/collections/HashMap;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "twsConnected", "getColorNeedCrcCheck", "supportAdvanceEq", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTProductDeviceEarTwos extends IOTProductDevice {
    public static final String EAR_BLACK_ID = "A20444";
    public static final String EAR_ID = "FEB1C7";
    public static final float EAR_TWO_Q_HIGH = 0.7f;
    public static final float EAR_TWO_REQ_HIGH = 3400.0f;
    public static final String PRODUCT_ID = "B171";
    public static final float TOTAL_GAIN = -6.0f;

    @Override // com.nothing.device.IOTProductDevice
    public boolean getColorNeedCrcCheck() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public int getSupportANCLevel() {
        return 4;
    }

    @Override // com.nothing.device.IOTProductDevice
    public float getTotalGain() {
        return -6.0f;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasBassBoostFunction() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasFirFunction() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean supportAdvanceEq() {
        return true;
    }

    public IOTProductDeviceEarTwos() {
        setDeviceName("ear");
        setProductId("B171");
        setProjectId("23262");
        setProductReleaseOrder(DeviceConstant.NOISE_CANCELLATION_ADAPTIVE);
        setDeviceType(DeviceType.TWS);
        setAction(new IOTEarTwosAction());
        setGestureAction(new IOTEarTwosGestureAction());
        setOsAction(new IOTEarTwosOsAction());
        getDeviceList().add(new IOTEarTwosWhite());
        getDeviceList().add(new IOTEarTwosBlack());
        setWidgetAction(new TWSWidgetAction());
        setIntroduceMsg(R.string.introduce_msg);
        setIntroduceSummary(R.string.pair_guide_question_ear1);
        setCaseLottieJson("lottie/ear_twos_case_animal_new.json");
        setSupportImage(R.drawable.ear_twos_support_image);
        setCaseImage(R.drawable.ear_twos_help_case);
        setLeftDoubleGestureLottieJson("lottie/ear_twos_double_pinch_left.json");
        setRightDoubleGestureLottieJson("lottie/ear_twos_double_pinch_right.json");
        setLeftTripleGestureLottieJson("lottie/ear_twos_triple_pinch_left.json");
        setRightTripleGestureLottieJson("lottie/ear_twos_triple_pinch_right.json");
        setLeftLongPressGestureLottieJson("lottie/ear_twos_pinch_hold_left.json");
        setRightLongPressGestureLottieJson("lottie/ear_twos_pinch_hold_right.json");
        setLeftDoublePinchGestureLottieJson("lottie/ear_twos_double_pinch_hold_left.json");
        setRightDoublePinchGestureLottieJson("lottie/ear_twos_double_pinch_hold_right.json");
        setProtocol(new EarTwosProtocol());
        setPushTopic("ear_2s_firmware");
        setBluetoothName("Nothing Ear");
        setHelpDeviceName("Ear");
        setPublishDevice(false);
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
            return TuplesKt.to(Float.valueOf(3400.0f), Float.valueOf(0.7f));
        }
        return TuplesKt.to(fValueOf2, fValueOf);
    }

    @Override // com.nothing.device.IOTProductDevice
    public void initDevice() {
        RouterFactory.INSTANCE.getTestToolsRouter().initUnknownDevice("B171", this);
        super.initDevice();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOSOTADevice(String address, String modelId) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return new EarTwosDevice(address, modelId);
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        return new EarTwosOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return new EarTwosImpl(callbacks, handler, coroutineScope, modelId, macAddress);
    }

    @Override // com.nothing.device.IOTProductDevice
    public HashMap<Integer, BaseFunctionComponents> createFunctionComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner, boolean twsConnected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (twsConnected) {
            HashMap<Integer, BaseFunctionComponents> map = new HashMap<>();
            map.put(Integer.valueOf(UltraBassComponents.ORDER_ULTRA_BASS), new UltraBassComponents(context, iotDevice, lifecycleOwner));
            return map;
        }
        return new HashMap<>();
    }
}
