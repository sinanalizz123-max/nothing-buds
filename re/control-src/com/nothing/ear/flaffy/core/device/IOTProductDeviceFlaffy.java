package com.nothing.ear.flaffy.core.device;

import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.nothing.base.router.BaseNothingDevice;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.router.device.DeviceType;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.ear.flaffy.base.FlaffyImpl;
import com.nothing.ear.flaffy.core.FlaffyDevice;
import com.nothing.ear.flaffy.core.protocol.device.FlaffyOTAProcess;
import com.nothing.ear.flaffy.core.protocol.device.FlaffyProtocol;
import com.nothing.earbase.widget.TWSWidgetAction;
import com.nothing.os.device.DeviceConstant;
import com.nothing.ota.entity.OTAProcess;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDeviceFlaffy.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J6\u0010\u0019\u001a\u00020\u00132\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u0015H\u0016\u00a8\u0006#"}, d2 = {"Lcom/nothing/ear/flaffy/core/device/IOTProductDeviceFlaffy;", "Lcom/nothing/device/IOTProductDevice;", "<init>", "()V", "initDeviceGesture", "", "getSupportANCLevel", "", "hasFirFunction", "", "hasBassBoostFunction", "hasBassEnhancerFunction", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "initDevice", "getTotalGain", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTProductDeviceFlaffy extends IOTProductDevice {
    public static final String BLUE_EAR_ID = "CC3444";
    public static final String EAR_ID = "FC3AAF";
    public static final float EAR_TWO_Q_HIGH = 0.7f;
    public static final float EAR_TWO_REQ_HIGH = 3400.0f;
    public static final String PRODUCT_ID = "B174";
    public static final float TOTAL_GAIN = -6.0f;

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
        return false;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasBassEnhancerFunction() {
        return false;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasFirFunction() {
        return false;
    }

    public IOTProductDeviceFlaffy() {
        setDeviceName("ear (open)");
        setProductId("B174");
        setProjectId("23291");
        setProductReleaseOrder(DeviceConstant.NOISE_CANCELLATION_OFF);
        setDeviceType(DeviceType.TWS);
        setAction(new IOTFlaffyAction());
        setOsAction(new IOTFlaffyOsAction());
        setGestureAction(new IOTFlaffyGestureAction());
        getDeviceList().add(new IOTFlaffyWhite());
        setWidgetAction(new TWSWidgetAction());
        setIntroduceMsg(R.string.vc_pairing_guide);
        setIntroduceSummary(R.string.pair_guide_question_ear1);
        setCaseLottieJson("lottie/flaffy_case_animal.json");
        setSupportImage(R.drawable.flaffy_support_image);
        setCaseImage(R.drawable.flaffy_case);
        setLeftDoubleGestureLottieJson("lottie/flaffy_double_pinch_left.json");
        setRightDoubleGestureLottieJson("lottie/flaffy_double_pinch_right.json");
        setLeftTripleGestureLottieJson("lottie/flaffy_triple_pinch_left.json");
        setRightTripleGestureLottieJson("lottie/flaffy_triple_pinch_right.json");
        setLeftLongPressGestureLottieJson("lottie/flaffy_pinch_hold_left.json");
        setRightLongPressGestureLottieJson("lottie/flaffy_pinch_hold_right.json");
        setLeftDoublePinchGestureLottieJson("lottie/flaffy_double_pinch_hold_left.json");
        setRightDoublePinchGestureLottieJson("lottie/flaffy_double_pinch_hold_right.json");
        setProtocol(new FlaffyProtocol());
        setBluetoothName("Nothing ear (open)");
        setHelpDeviceName("Ear (open)");
        setPushTopic("ear_color_firmware");
        setHasCurveDebugFunc(true);
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
        RouterFactory.INSTANCE.getTestToolsRouter().initUnknownDevice("B174", this);
        super.initDevice();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOSOTADevice(String address, String modelId) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return new FlaffyDevice(address, modelId);
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        return new FlaffyOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return new FlaffyImpl(callbacks, handler, coroutineScope, modelId, macAddress);
    }
}
