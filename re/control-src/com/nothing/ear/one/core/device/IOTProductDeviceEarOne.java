package com.nothing.ear.one.core.device;

import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.nothing.base.router.BaseNothingDevice;
import com.nothing.base.router.device.DeviceColor;
import com.nothing.base.router.device.DeviceType;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.ear.one.base.EarOneImpl;
import com.nothing.ear.one.core.EarOneDevice;
import com.nothing.ear.one.core.protocol.device.EarOneOTAProcess;
import com.nothing.ear.one.core.protocol.device.EarOneProtocol;
import com.nothing.earbase.widget.TWSWidgetAction;
import com.nothing.ota.entity.OTAProcess;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDeviceEarOne.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J$\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r`\u000eH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\rH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J6\u0010\u0016\u001a\u00020\u00112\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016\u00a8\u0006\""}, d2 = {"Lcom/nothing/ear/one/core/device/IOTProductDeviceEarOne;", "Lcom/nothing/device/IOTProductDevice;", "<init>", "()V", "initDeviceGesture", "", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "", "getProductDeviceMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDeviceModel", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "getModelIdNeedVersion", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTProductDeviceEarOne extends IOTProductDevice {
    public static final String EAR_BLACK_ID = "624011";
    public static final String EAR_COLOR_BLACK_CONNECT = "0101";
    public static final String EAR_COLOR_BLACK_DISCONNECT = "0001";
    public static final String EAR_COLOR_MODEL_BLACK = "000101";
    public static final String EAR_COLOR_MODEL_WHITE = "000102";
    public static final String EAR_COLOR_WHITE_CONNECT = "0102";
    public static final String EAR_COLOR_WHITE_DISCONNECT = "0002";
    public static final String EAR_PRODUCT_ID = "B181";
    public static final String EAR_WHITE_ID = "31D53D";

    /* JADX INFO: compiled from: IOTProductDeviceEarOne.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceColor.values().length];
            try {
                iArr[DeviceColor.BLACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceColor.WHITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean getModelIdNeedVersion() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public IOTProductDeviceEarOne() {
        setDeviceName("ear (1)");
        setProductId("B181");
        setProjectId(EAR_COLOR_BLACK_DISCONNECT);
        setProductReleaseOrder("0");
        setDeviceType(DeviceType.TWS);
        setAction(new IOTEarOneAction());
        setOsAction(new IOTEarOneOsAction());
        setGestureAction(new IOTEarOneGestureAction());
        getDeviceList().add(new IOTEarOneBlack());
        getDeviceList().add(new IOTEarOneWhite());
        setWidgetAction(new TWSWidgetAction());
        setIntroduceMsg(R.string.introduce_msg);
        setIntroduceSummary(R.string.pair_guide_question);
        setCaseLottieJson("lottie/ear_one_case_pairing_new.json");
        setSupportImage(R.drawable.ear_one_help_image);
        setCaseImage(R.drawable.ear_one_case_animal_image);
        setLeftTripleGestureLottieJson("lottie/ear_one_triple_tap_left.json");
        setRightTripleGestureLottieJson("lottie/ear_one_triple_tap_right.json");
        setLeftLongPressGestureLottieJson("lottie/ear_one_tap_hold_left.json");
        setRightLongPressGestureLottieJson("lottie/ear_one_tap_hold_right.json");
        setSupportFetchLog(false);
        setSupportReportIssue(false);
        setSupportCustomEQ(false);
        setProtocol(new EarOneProtocol(null, 1, 0 == true ? 1 : 0));
        setBluetoothName(EarOneProtocol.EAR_NAME);
        setHelpDeviceName("Ear (1)");
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
                map2.put("0101", iOTDevice.getModelId());
                map2.put(EAR_COLOR_BLACK_DISCONNECT, iOTDevice.getModelId());
                map2.put(EAR_COLOR_MODEL_BLACK, iOTDevice.getModelId());
            } else if (i == 2) {
                map2.put("0102", iOTDevice.getModelId());
                map2.put(EAR_COLOR_WHITE_DISCONNECT, iOTDevice.getModelId());
                map2.put(EAR_COLOR_MODEL_WHITE, iOTDevice.getModelId());
            }
        }
        return map;
    }

    @Override // com.nothing.device.IOTProductDevice
    /* JADX INFO: renamed from: getDeviceModel */
    public String getProductId() {
        return "Nothing ear(1)";
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOSOTADevice(String address, String modelId) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        return new EarOneDevice(address, modelId);
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        return new EarOneOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return new EarOneImpl(callbacks, handler, coroutineScope, modelId, macAddress);
    }
}
