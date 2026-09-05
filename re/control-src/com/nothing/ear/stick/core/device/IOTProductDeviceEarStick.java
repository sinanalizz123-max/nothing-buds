package com.nothing.ear.stick.core.device;

import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.nothing.base.router.BaseNothingDevice;
import com.nothing.base.router.device.DeviceType;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.ear.stick.base.EarStickImpl;
import com.nothing.ear.stick.core.EarStickDevice;
import com.nothing.ear.stick.core.protocol.device.EarStickOTAProcess;
import com.nothing.ear.stick.core.protocol.device.EarStickProtocol;
import com.nothing.earbase.widget.TWSWidgetAction;
import com.nothing.ota.entity.OTAProcess;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDeviceEarStick.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\u001a\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J8\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u0010H\u0016\u00a8\u0006\u001e"}, d2 = {"Lcom/nothing/ear/stick/core/device/IOTProductDeviceEarStick;", "Lcom/nothing/device/IOTProductDevice;", "<init>", "()V", "initDeviceGesture", "", "getSupportANCLevel", "", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "getTotalGain", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTProductDeviceEarStick extends IOTProductDevice {
    public static final String EAR_ID = "1016DD";
    public static final String PRODUCT_ID = "B157";
    public static final float STICK_FREQ_HIGH = 3500.0f;
    public static final float STICK_FREQ_LOW = 140.0f;
    public static final float STICK_FREQ_PEAK = 980.0f;
    public static final float STICK_Q_HIGH = 1.0f;
    public static final float STICK_Q_LOW = 0.8f;
    public static final float STICK_Q_PEAK = 0.66f;
    public static final float TOTAL_GAIN = -11.0f;

    @Override // com.nothing.device.IOTProductDevice
    public int getSupportANCLevel() {
        return 255;
    }

    @Override // com.nothing.device.IOTProductDevice
    public float getTotalGain() {
        return -11.0f;
    }

    public IOTProductDeviceEarStick() {
        setDeviceName("ear (stick)");
        setProductId(PRODUCT_ID);
        setProjectId("21231");
        setProductReleaseOrder("1");
        setDeviceType(DeviceType.TWS);
        setAction(new IOTEarStickAction());
        setOsAction(new IOTEarStickOsAction());
        setGestureAction(new IOTEarStickGestureAction());
        getDeviceList().add(new IOTEarStickWhite());
        setWidgetAction(new TWSWidgetAction());
        setIntroduceMsg(R.string.introduce_msg);
        setIntroduceSummary(R.string.pair_guide_question_ear1);
        setCaseLottieJson("lottie/ear_stick__case_pairing_new.json");
        setSupportImage(R.drawable.ear_stick_help_image);
        setCaseImage(R.drawable.ear_stick_case_json);
        setLeftDoubleGestureLottieJson("lottie/ear_stick_double_press_left.json");
        setRightDoubleGestureLottieJson("lottie/ear_stick_double_press_right.json");
        setLeftTripleGestureLottieJson("lottie/ear_stick_triple_press_left.json");
        setRightTripleGestureLottieJson("lottie/ear_stick_triple_press_right.json");
        setLeftLongPressGestureLottieJson("lottie/ear_stick_press_hold_left.json");
        setRightLongPressGestureLottieJson("lottie/ear_stick_press_hold_right.json");
        setLeftDoublePinchGestureLottieJson("lottie/ear_stick_double_press_hold_left.json");
        setRightDoublePinchGestureLottieJson("lottie/ear_stick_double_press_hold_right.json");
        setProtocol(new EarStickProtocol());
        setPushTopic("stick_firmware");
        setBluetoothName("Ear (stick)");
        setHelpDeviceName("Ear (stick)");
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
            return TuplesKt.to(Float.valueOf(980.0f), Float.valueOf(0.66f));
        }
        if (type == 2) {
            return TuplesKt.to(Float.valueOf(3500.0f), Float.valueOf(1.0f));
        }
        return TuplesKt.to(fValueOf2, fValueOf);
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOSOTADevice(String address, String modelId) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return new EarStickDevice(address, modelId);
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        return new EarStickOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return new EarStickImpl(callbacks, handler, coroutineScope, modelId, macAddress);
    }
}
