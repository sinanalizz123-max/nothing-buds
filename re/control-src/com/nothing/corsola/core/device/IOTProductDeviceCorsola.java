package com.nothing.corsola.core.device;

import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import com.nothing.base.router.BaseNothingDevice;
import com.nothing.base.router.device.DeviceType;
import com.nothing.corsola.base.CorsolaImpl;
import com.nothing.corsola.core.CorsolaDevice;
import com.nothing.corsola.core.protocol.device.CorsolaOTAProcess;
import com.nothing.corsola.core.protocol.device.CorsolaProtocol;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.widget.TWSWidgetAction;
import com.nothing.ota.entity.OTAProcess;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDeviceCorsola.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J6\u0010\u0013\u001a\u00020\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u000fH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/corsola/core/device/IOTProductDeviceCorsola;", "Lcom/nothing/device/IOTProductDevice;", "<init>", "()V", "initDeviceGesture", "", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "", "getSupportANCLevel", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTProductDeviceCorsola extends IOTProductDevice {
    public static final String EAR_ID = "ADD2C4";
    public static final String EAR_ORANGE_ID = "5F8F82";
    public static final String EAR_WHITE_ID = "2EB1CA";
    public static final String PRODUCT_ID = "B163";

    @Override // com.nothing.device.IOTProductDevice
    public int getSupportANCLevel() {
        return 3;
    }

    public IOTProductDeviceCorsola() {
        setDeviceName("Buds Pro");
        setProductId(PRODUCT_ID);
        setProjectId("22261");
        setProductReleaseOrder("0");
        setDeviceType(DeviceType.TWS);
        setAction(new IOTCorsolaAction());
        setOsAction(new IOTEarCorsolaOsAction());
        setGestureAction(new IOTEarCorsolaGestureAction());
        setCaseImage(R.drawable.corsola_case);
        getDeviceList().add(new IOTCorsolaBlack());
        getDeviceList().add(new IOTCorsolaWhite());
        getDeviceList().add(new IOTCorsolaOrange());
        setIntroduceMsg(R.string.vc_pairing_guide);
        setIntroduceSummary(R.string.pair_guide_question);
        setCaseLottieJson("lottie/corsola_case_help_pairing.json");
        setSupportImage(R.drawable.ear_corsola_help);
        setCaseImage(R.drawable.ear_corsola_help_case);
        setLeftDoubleGestureLottieJson("lottie/ear_two_double_pinch_left.json");
        setRightDoubleGestureLottieJson("lottie/ear_two_double_pinch_right.json");
        setLeftTripleGestureLottieJson("lottie/ear_two_triple_pinch_left.json");
        setRightTripleGestureLottieJson("lottie/ear_two_triple_pinch_right.json");
        setLeftLongPressGestureLottieJson("lottie/ear_two_pinch_hold_left.json");
        setRightLongPressGestureLottieJson("lottie/ear_two_pinch_hold_right.json");
        setLeftDoublePinchGestureLottieJson("lottie/ear_two_double_pinch_hold_left.json");
        setRightDoublePinchGestureLottieJson("lottie/ear_two_double_pinch_hold_right.json");
        setProtocol(new CorsolaProtocol());
        setBluetoothName("Buds Pro");
        setCmfText(true);
        setHelpDeviceName("Buds Pro");
        setPushTopic("ear_corsola_firmware");
        initDeviceGesture();
        setWidgetAction(new TWSWidgetAction());
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
        return new CorsolaDevice(address, modelId);
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        return new CorsolaOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return new CorsolaImpl(callbacks, handler, coroutineScope, modelId, macAddress);
    }
}
