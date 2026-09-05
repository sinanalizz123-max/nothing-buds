package com.nothing.forretress.core.device;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.databinding.ObservableField;
import androidx.health.platform.client.SdkConfig;
import androidx.lifecycle.LifecycleOwner;
import com.nothing.base.router.BaseNothingDevice;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.router.device.DeviceType;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import com.nothing.elekid.base.ElekidImpl;
import com.nothing.elekid.core.ElekidDevice;
import com.nothing.elekid.core.device.IOTEarElekidGestureAction;
import com.nothing.elekid.core.device.IOTElekidOsAction;
import com.nothing.elekid.core.protocol.device.ElekidOTAProcess;
import com.nothing.elekid.core.protocol.device.ElekidProtocol;
import com.nothing.elekid.widget.IOTElekidWidgetAction;
import com.nothing.os.device.DeviceConstant;
import com.nothing.os.device.bluetooth.components.bassboost.os.SpatialAudioComponents;
import com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents;
import com.nothing.ota.entity.OTAProcess;
import com.nothing.protocol.device.TWSDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: IOTProductDeviceForretress.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 92\u00020\u0001:\u00019B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J6\u0010\u0016\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0012H\u0016JD\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!0 j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020!`\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0006\u0010*\u001a\u00020\u0005J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\u0007H\u0016J\b\u0010.\u001a\u00020\u0007H\u0016J\b\u0010/\u001a\u00020\u0007H\u0016J\b\u00100\u001a\u00020\fH\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\b\u00102\u001a\u00020\u0007H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\u001e\u00104\u001a\b\u0012\u0004\u0012\u000206052\u0006\u00107\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u0007H\u0016\u00a8\u0006:"}, d2 = {"Lcom/nothing/forretress/core/device/IOTProductDeviceForretress;", "Lcom/nothing/device/IOTProductDevice;", "<init>", "()V", "initDeviceGesture", "", "hasBassBoostFunction", "", "getTwsDeviceType", "", "getSimpleCustomEQParameter", "Lkotlin/Pair;", "", "type", "getSupportANCLevel", "createOSOTADevice", "Lcom/nothing/base/router/BaseNothingDevice;", "address", "", "modelId", "createOTAProcess", "Lcom/nothing/ota/entity/OTAProcess;", "createOsDevice", "callbacks", "Landroid/os/RemoteCallbackList;", "Landroid/os/IInterface;", "handler", "Landroid/os/Handler;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "macAddress", "createFunctionComponents", "Ljava/util/HashMap;", "Lcom/nothing/device/BaseFunctionComponents;", "Lkotlin/collections/HashMap;", "context", "Landroid/content/Context;", "iotDevice", "Lcom/nothing/device/IOTDevice;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "twsConnected", "initEQ", "hasMagicButton", "hasHeadTrack", "hasLeFunction", "supportSystemAudio", "hasSpatialAudioFunction", "getTotalGain", "hasNewFirFunction", "hasFirFunction", "eqMutuallyExclusive", "initSimpleEQItem", "", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "isSystemPage", "isSupportCustomEQ", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTProductDeviceForretress extends IOTProductDevice {
    public static final String EAR_BLACK_ID = "1EFB39";
    public static final String EAR_ID = "73C9EB";
    public static final String EAR_ORANGE = "563DA5";
    public static final String PRODUCT_ID = "B175";
    public static final float TOTAL_GAIN = -6.0f;

    @Override // com.nothing.device.IOTProductDevice
    public boolean eqMutuallyExclusive() {
        return false;
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
    /* JADX INFO: renamed from: getTwsDeviceType */
    public int getType() {
        return 6;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasBassBoostFunction() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasFirFunction() {
        return false;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasHeadTrack() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasLeFunction() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasMagicButton() {
        return true;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasNewFirFunction() {
        return false;
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean hasSpatialAudioFunction() {
        return true;
    }

    public final void initEQ() {
    }

    @Override // com.nothing.device.IOTProductDevice
    public boolean supportSystemAudio() {
        return true;
    }

    public IOTProductDeviceForretress() {
        setDeviceName("Headphone Pro");
        setProductId(PRODUCT_ID);
        setProjectId("24211");
        setProductReleaseOrder("1");
        setDeviceType(DeviceType.TWS);
        setAction(new IOTForretressAction());
        setOsAction(new IOTElekidOsAction());
        setGestureAction(new IOTEarElekidGestureAction());
        getDeviceList().add(new IOTForretressGreen());
        getDeviceList().add(new IOTForretressBlack());
        getDeviceList().add(new IOTForretressWhite());
        setWidgetAction(new IOTElekidWidgetAction());
        setIntroduceMsg(R.string.neckband_pair_guide);
        setIntroduceSummary(R.string.pair_guide_question_ear1);
        setCaseLottieJson("lottie/elekid_pairing.json");
        setProtocol(new ElekidProtocol());
        setCaseImage(0);
        setBluetoothName("24211");
        setHelpDeviceName("24211");
        setPushTopic("ear_forretress_firmware");
        setStereo(true);
        setPublishDevice(false);
        setCmfText(false);
        initDeviceGesture();
        setScanHelpTitle(R.string.hold_button_to_pair);
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
        return new ElekidDevice(address, modelId);
    }

    @Override // com.nothing.device.IOTProductDevice
    public OTAProcess createOTAProcess() {
        return new ElekidOTAProcess();
    }

    @Override // com.nothing.device.IOTProductDevice
    public BaseNothingDevice createOsDevice(RemoteCallbackList<IInterface> callbacks, Handler handler, CoroutineScope coroutineScope, String modelId, String macAddress) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(modelId, "modelId");
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        return new ElekidImpl(callbacks, handler, coroutineScope, modelId, macAddress);
    }

    @Override // com.nothing.device.IOTProductDevice
    public HashMap<Integer, BaseFunctionComponents> createFunctionComponents(Context context, IOTDevice iotDevice, LifecycleOwner lifecycleOwner, boolean twsConnected) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iotDevice, "iotDevice");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        if (twsConnected) {
            HashMap<Integer, BaseFunctionComponents> map = new HashMap<>();
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
                map.put(Integer.valueOf(SpatialAudioComponents.ORDER_SPATIAL_AUDIO), new SpatialAudioComponents(context, iotDevice, lifecycleOwner));
            }
            map.put(Integer.valueOf(UltraBassComponents.ORDER_ULTRA_BASS), new UltraBassComponents(context, iotDevice, lifecycleOwner));
            return map;
        }
        return new HashMap<>();
    }

    @Override // com.nothing.device.IOTProductDevice
    public List<EqualizerTypeViewModel> initSimpleEQItem(boolean isSystemPage, boolean isSupportCustomEQ) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        Resources localizedResources = ContextExtKt.getLocalizedResources(application);
        ObservableField observableField = new ObservableField(localizedResources.getString(R.string.eq_advanced_genre_pop));
        if (isSystemPage) {
            i = R.drawable.os_equalizer_pop;
        } else {
            i = R.drawable.equalizer_pop;
        }
        arrayList.add(new EqualizerTypeViewModel(DeviceConstant.NOISE_CANCELLATION_ADAPTIVE, observableField, 3, i, null, null, 0, SdkConfig.SDK_VERSION, null));
        ObservableField observableField2 = new ObservableField(localizedResources.getString(R.string.sound_balanced));
        if (isSystemPage) {
            i2 = R.drawable.os_balanced;
        } else {
            i2 = R.drawable.equalizer_balanced;
        }
        arrayList.add(new EqualizerTypeViewModel("0", observableField2, 0, i2, null, null, 0, SdkConfig.SDK_VERSION, null));
        ObservableField observableField3 = new ObservableField(localizedResources.getString(R.string.eq_advanced_genre_electronic));
        if (isSystemPage) {
            i3 = R.drawable.os_equalizer_electronic;
        } else {
            i3 = R.drawable.equalizer_electronic;
        }
        arrayList.add(new EqualizerTypeViewModel(DeviceConstant.NOISE_CANCELLATION_TRANSPARENCY, observableField3, 2, i3, null, null, 0, SdkConfig.SDK_VERSION, null));
        ObservableField observableField4 = new ObservableField(localizedResources.getString(R.string.sound_more_voice));
        if (isSystemPage) {
            i4 = R.drawable.os_voice;
        } else {
            i4 = R.drawable.equalizer_voice;
        }
        arrayList.add(new EqualizerTypeViewModel("1", observableField4, 1, i4, null, null, 0, SdkConfig.SDK_VERSION, null));
        ObservableField observableField5 = new ObservableField(localizedResources.getString(R.string.eq_advanced_genre_classical));
        if (isSystemPage) {
            i5 = R.drawable.os_equalizer_classical;
        } else {
            i5 = R.drawable.equalizer_classical;
        }
        arrayList.add(new EqualizerTypeViewModel("8", observableField5, 5, i5, null, null, 0, SdkConfig.SDK_VERSION, null));
        return arrayList;
    }
}
