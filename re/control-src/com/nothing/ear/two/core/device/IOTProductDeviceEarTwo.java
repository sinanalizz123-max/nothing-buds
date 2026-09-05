package com.nothing.ear.two.core.device;

import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.nothing.base.router.BaseNothingDevice;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.router.device.DeviceColor;
import com.nothing.base.router.device.DeviceType;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.ear.two.base.EarTwoImpl;
import com.nothing.ear.two.core.EarTwoDevice;
import com.nothing.ear.two.core.protocol.device.EarTwoOTAProcess;
import com.nothing.ear.two.core.protocol.device.EarTwoProtocol;
import com.nothing.earbase.widget.TWSWidgetAction;
import com.nothing.ota.entity.OTAProcess;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDeviceEarTwo.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\b\u0010\r\u001a\u00020\nH\u0016J$\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010`\u0011H\u0016J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J6\u0010\u0018\u001a\u00020\u00132\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0016J\b\u0010!\u001a\u00020\"H\u0016\u00a8\u0006$"}, d2 = {"Lcom/nothing/ear/two/core/device/IOTProductDeviceEarTwo;", "Lcom/nothing/device/IOTProductDevice;", "<init>", "()V", "initDeviceGesture", "", "getSupportANCLevel", "", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "initDevice", "getTotalGain", "getProductDeviceMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "supportAdvanceEq", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTProductDeviceEarTwo extends IOTProductDevice {
    public static final String EAR_ID = "DEE8C0";
    public static final float EAR_TWO_Q_HIGH = 0.7f;
    public static final float EAR_TWO_REQ_HIGH = 3400.0f;
    public static final String PRODUCT_ID = "B155";
    public static final float TOTAL_GAIN = -6.0f;

    /* JADX INFO: compiled from: IOTProductDeviceEarTwo.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceColor.values().length];
            try {
                iArr[DeviceColor.WHITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceColor.BLACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
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
    public boolean supportAdvanceEq() {
        return true;
    }

    public IOTProductDeviceEarTwo() {
        setDeviceName("ear (2)");
        setProductId(PRODUCT_ID);
        setProjectId("21211");
        setProductReleaseOrder("2");
        setDeviceType(DeviceType.TWS);
        setAction(new IOTEarTwoAction());
        setGestureAction(new IOTEarTwoGestureAction());
        setOsAction(new IOTEarTwoOsAction());
        getDeviceList().add(new IOTEarTwoWhite());
        getDeviceList().add(new IOTEarTwoBlack());
        setWidgetAction(new TWSWidgetAction());
        setIntroduceMsg(R.string.introduce_msg);
        setIntroduceSummary(R.string.pair_guide_question_ear1);
        setCaseLottieJson("lottie/ear_two_case_animal_new.json");
        setSupportImage(R.drawable.ear_two_help_image);
        setCaseImage(R.drawable.ear_two_case);
        setLeftDoubleGestureLottieJson("lottie/ear_two_double_pinch_left.json");
        setRightDoubleGestureLottieJson("lottie/ear_two_double_pinch_right.json");
        setLeftTripleGestureLottieJson("lottie/ear_two_triple_pinch_left.json");
        setRightTripleGestureLottieJson("lottie/ear_two_triple_pinch_right.json");
        setLeftLongPressGestureLottieJson("lottie/ear_two_pinch_hold_left.json");
        setRightLongPressGestureLottieJson("lottie/ear_two_pinch_hold_right.json");
        setLeftDoublePinchGestureLottieJson("lottie/ear_two_double_pinch_hold_left.json");
        setRightDoublePinchGestureLottieJson("lottie/ear_two_double_pinch_hold_right.json");
        setProtocol(new EarTwoProtocol());
        setPushTopic("ear_2_firmware");
        setBluetoothName("Ear (2)");
        setHelpDeviceName("Ear (2)");
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
        RouterFactory.INSTANCE.getTestToolsRouter().initUnknownDevice(PRODUCT_ID, this);
        super.initDevice();
    }

    @Override // com.nothing.device.IOTProductDevice
    public HashMap<String, String> getProductDeviceMap() {
        HashMap<String, String> map = new HashMap<>();
        Iterator<IOTDevice> it = getDeviceList().iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            IOTDevice next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            IOTDevice iOTDevice = next;
            HashMap<String, String> map2 = map;
            map2.put(iOTDevice.getModelId(), iOTDevice.getModelId());
            int i = WhenMappings.$EnumSwitchMapping$0[iOTDevice.getColor().ordinal()];
            if (i == 1) {
                map2.put(iOTDevice.getProductId() + DeviceColor.BLACK.getValue(), iOTDevice.getModelId());
            } else if (i == 2) {
                map2.put(iOTDevice.getProductId() + DeviceColor.WHITE.getValue(), iOTDevice.getModelId());
            } else {
                map2.put(iOTDevice.getProductId() + iOTDevice.getColor().getValue(), iOTDevice.getModelId());
            }
        }
        return map;
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOSOTADevice(String address, String modelId) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return new EarTwoDevice(address, modelId);
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        return new EarTwoOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return new EarTwoImpl(callbacks, handler, coroutineScope, modelId, macAddress);
    }
}
