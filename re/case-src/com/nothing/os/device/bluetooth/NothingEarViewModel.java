package com.nothing.os.device.bluetooth;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.model.Battery;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ViewModelExtKt;
import com.nothing.broadcase.ext.BluetoothDeviceExtKt;
import com.nothing.database.util.DatabaseUtils;
import com.nothing.device.BaseFunctionComponents;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.ota.entity.DeviceBattery;
import com.nothing.log.FileLog;
import com.nothing.os.device.bluetooth.adapter.HeaderInfoEntity;
import com.nothing.os.device.bluetooth.adapter.NormalItemViewModel;
import com.nothing.os.device.bluetooth.components.ANCComponents;
import com.nothing.os.device.bluetooth.components.AdvancedComponents;
import com.nothing.os.device.bluetooth.components.BatteryComponents;
import com.nothing.os.device.bluetooth.components.ControlsComponents;
import com.nothing.os.device.bluetooth.components.DualComponents;
import com.nothing.os.device.bluetooth.components.EarFitTestComponents;
import com.nothing.os.device.bluetooth.components.EqualizerComponents;
import com.nothing.os.device.bluetooth.components.FindDeviceComponents;
import com.nothing.os.device.bluetooth.components.FirmwareComponents;
import com.nothing.os.device.bluetooth.components.GestureControlsComponents;
import com.nothing.os.device.bluetooth.components.HighQualityAudioComponents;
import com.nothing.os.device.bluetooth.components.InEarDetectionComponents;
import com.nothing.os.device.bluetooth.components.LowLatencyComponents;
import com.nothing.os.device.bluetooth.components.NoiseReductionComponents;
import com.nothing.os.device.bluetooth.components.PersonalisedSoundComponents;
import com.nothing.os.device.bluetooth.components.PersonalizedANCComponents;
import com.nothing.os.device.bluetooth.components.SerialNumberComponents;
import com.nothing.os.device.bluetooth.components.SoundComponents;
import com.nothing.protocol.device.TWSDevice;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: NothingEarViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\u000fJ\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\n\u0010#\u001a\u0004\u0018\u00010$H\u0002J\u0010\u0010%\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\n\u0010&\u001a\u0004\u0018\u00010'H\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010)\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010*\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010+\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010,\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010-\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010/\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u00100\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u00101\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u00102\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u00103\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\n\u00104\u001a\u0004\u0018\u000105H\u0002J\u0010\u00106\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u00109\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\rH\u0002J\u0010\u0010:\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020\bJ\u0010\u0010=\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020?H\u0002J\u000e\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\bJ\u0006\u0010@\u001a\u00020\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/nothing/os/device/bluetooth/NothingEarViewModel;", "Lcom/nothing/os/device/bluetooth/BluetoothDetailViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "extraComponents", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/device/BaseFunctionComponents;", "cacheFeatureComponents", "cacheCommonComponents", "iOTDevice", "Lcom/nothing/device/IOTDevice;", "setBundleExtras", "", "bundle", "Landroid/os/Bundle;", "addLiveDataListener", "refreshData", "updateHeaderInfo", "headerInfoEntity", "Lcom/nothing/os/device/bluetooth/adapter/HeaderInfoEntity;", "refresh", "initHeaderInfo", "twsConnected", "", "addToListViewModels", "addDefaultComponents", "hasPermission", "addFeatureComponents", "addFunctionComponents", "canShow", "addBattery", "it", "getBatteryComponents", "Lcom/nothing/os/device/bluetooth/components/BatteryComponents;", "addANC", "getANCComponents", "Lcom/nothing/os/device/bluetooth/components/ANCComponents;", "addSound", "addGestureControls", "addControls", "addAdvanced", "addEqualizer", "addFirmware", "addNoiseReduction", "addHighQualityAudio", "addFindDevice", "addEarFitTest", "addDualConnection", "addSerialNumber", "getSerialNumberComponents", "Lcom/nothing/os/device/bluetooth/components/SerialNumberComponents;", "addPersonalisedSound", "addPersonalizedANC", "addInEarDetection", "addLowLatency", "getFunctionComponents", "order", "isUpdateBattery", "updateHeaderBatteryInfo", "battery", "Lcom/nothing/earbase/ota/entity/DeviceBattery;", "updateNoiseMode", "type", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class NothingEarViewModel extends BluetoothDetailViewModel {
    private ConcurrentHashMap<Integer, BaseFunctionComponents> cacheCommonComponents;
    private ConcurrentHashMap<Integer, BaseFunctionComponents> cacheFeatureComponents;
    private ConcurrentHashMap<Integer, BaseFunctionComponents> extraComponents;
    private boolean isUpdateBattery;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NothingEarViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.extraComponents = new ConcurrentHashMap<>();
        this.cacheFeatureComponents = new ConcurrentHashMap<>();
        this.cacheCommonComponents = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IOTDevice iOTDevice() {
        return IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(getMacAddress());
    }

    @Override // com.nothing.os.device.bluetooth.BluetoothDetailViewModel
    public void setBundleExtras(Bundle bundle) {
        super.setBundleExtras(bundle);
        addLiveDataListener();
    }

    public final void addLiveDataListener() {
        IOTDevice iOTDevice = iOTDevice();
        if (iOTDevice != null && iOTDevice.getTwsDevice() != null) {
            for (Map.Entry<Integer, BaseFunctionComponents> entry : this.extraComponents.entrySet()) {
                if (entry.getValue().needRequest()) {
                    entry.getValue().addListener(true);
                }
            }
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass2(null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.os.device.bluetooth.NothingEarViewModel$addLiveDataListener$2, reason: invalid class name */
    /* JADX INFO: compiled from: NothingEarViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.bluetooth.NothingEarViewModel$addLiveDataListener$2", f = "NothingEarViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return NothingEarViewModel.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TWSDevice twsDevice;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            DatabaseUtils databaseUtils = DatabaseUtils.INSTANCE;
            IOTDevice iOTDevice = NothingEarViewModel.this.iOTDevice();
            databaseUtils.updateDeviceNameToAlias((iOTDevice == null || (twsDevice = iOTDevice.getTwsDevice()) == null) ? null : twsDevice.getDevice());
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.os.device.bluetooth.BluetoothDetailViewModel
    public void refreshData() {
        TWSDevice twsDevice;
        IOTDevice iOTDevice = iOTDevice();
        if (iOTDevice == null || (twsDevice = iOTDevice.getTwsDevice()) == null || !twsDevice.isConnected()) {
            return;
        }
        for (Map.Entry<Integer, BaseFunctionComponents> entry : this.extraComponents.entrySet()) {
            if (entry.getValue().needRequest()) {
                entry.getValue().refresh();
            }
        }
    }

    @Override // com.nothing.os.device.bluetooth.BluetoothDetailViewModel
    public void updateHeaderInfo(HeaderInfoEntity headerInfoEntity) {
        super.updateHeaderInfo(headerInfoEntity);
        if (IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(getMacAddress()) != null) {
            return;
        }
        int i = R.drawable.ear_os_default_case;
        int i2 = R.drawable.ear_os_default_disconnected;
        if (headerInfoEntity != null ? Intrinsics.areEqual((Object) headerInfoEntity.getConnected(), (Object) true) : false) {
            getHeaderViewModel().getCaseImage().set(Integer.valueOf(i));
        } else {
            getHeaderViewModel().getCaseImage().set(Integer.valueOf(i2));
        }
    }

    @Override // com.nothing.os.device.bluetooth.BluetoothDetailViewModel
    public void refresh() {
        IOTDevice iOTDevice;
        TWSDevice twsDevice;
        boolean zHasBluetoothPermission = BluetoothDeviceExtKt.hasBluetoothPermission(ViewModelExtKt.getApplicationContext(this));
        boolean z = zHasBluetoothPermission && (iOTDevice = iOTDevice()) != null && (twsDevice = iOTDevice.getTwsDevice()) != null && twsDevice.isConnected();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "refresh hasPermission: " + zHasBluetoothPermission + " twsConnected:" + z;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        getListViewModels().clear();
        this.extraComponents.clear();
        initHeaderInfo(z);
        addFunctionComponents(z);
        addFeatureComponents(z);
        addToListViewModels();
        addDefaultComponents(zHasBluetoothPermission);
        notifyAdapter();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0036  */
    private final void initHeaderInfo(boolean twsConnected) {
        String string;
        getHeaderViewModel();
        getHeaderViewModel().getConnectEnable().set(true);
        getHeaderViewModel().getDisConnectEnable().set(true);
        IOTDevice iOTDevice = iOTDevice();
        if (iOTDevice != null) {
            int caseText = iOTDevice.getCaseText();
            Application application = AppGlobals.INSTANCE.get();
            if (application != null) {
                string = application.getString(caseText);
            } else {
                string = null;
            }
        } else {
            string = null;
        }
        getHeaderViewModel().getCaseText().set(string);
        if (!this.isUpdateBattery || !twsConnected) {
            getHeaderViewModel().getLeftVisible().set(false);
            getHeaderViewModel().getRightVisible().set(false);
            getHeaderViewModel().getCaseBatteryVisible().set(false);
            if (twsConnected) {
                ObservableField<Boolean> caseVisible = getHeaderViewModel().getCaseVisible();
                BatteryComponents batteryComponents = getBatteryComponents();
                caseVisible.set(batteryComponents != null ? Boolean.valueOf(batteryComponents.getHasCaseBatteryShow()) : null);
            } else {
                getHeaderViewModel().getCaseVisible().set(true);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new NothingEarViewModel$initHeaderInfo$1$1(this, null), 2, null);
        String str = string;
        if (str == null || str.length() == 0) {
            getHeaderViewModel().getCaseTextVisible().set(false);
        }
        IOTDevice iOTDevice2 = iOTDevice();
        if (iOTDevice2 != null) {
            getHeaderViewModel().getLeftImage().set(Integer.valueOf(iOTDevice2.getOsLeftImage()));
            getHeaderViewModel().getRightImage().set(Integer.valueOf(iOTDevice2.getOsRightImage()));
            TWSDevice twsDevice = iOTDevice2.getTwsDevice();
            if (twsDevice != null && twsDevice.isClassicConnected()) {
                getHeaderViewModel().getCaseImage().set(Integer.valueOf(iOTDevice2.getOsCaseImage()));
            } else {
                getHeaderViewModel().getCaseImage().set(Integer.valueOf(iOTDevice2.getOsDisconnectedImage()));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addToListViewModels() {
        Iterator<Map.Entry<Integer, BaseFunctionComponents>> it = this.extraComponents.entrySet().iterator();
        while (it.hasNext()) {
            CommonBindingMoreType componentsModel = it.next().getValue().getComponentsModel();
            if (componentsModel instanceof NormalItemViewModel) {
                getListViewModels().add(componentsModel);
            }
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "addToListViewModels extraComponents size " + this.extraComponents.size();
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str3 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            }
        }
    }

    private final void addDefaultComponents(boolean hasPermission) {
        getListViewModels().add(getHeaderViewModel());
        getListViewModels().addAll(getAudioViewModels());
        getListViewModels().add(getUseForViewModel());
        getListViewModels().addAll(getProfilesViewModels());
        getListViewModels().add(getAboutViewModel());
        getListViewModels().add(getBluetoothViewModel());
        if (hasPermission) {
            return;
        }
        getListViewModels().add(getPermissionViewModel());
    }

    private final void addFeatureComponents(boolean twsConnected) {
        IOTDevice iOTDevice;
        HashMap<Integer, BaseFunctionComponents> mapCreateFunctionComponents;
        if (!twsConnected || (iOTDevice = iOTDevice()) == null) {
            return;
        }
        if (this.cacheFeatureComponents.isEmpty()) {
            this.cacheFeatureComponents.clear();
            IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(getMacAddress());
            if (productByMacAddress != null && (mapCreateFunctionComponents = productByMacAddress.createFunctionComponents(ViewModelExtKt.getApplicationContext(this), iOTDevice, this, twsConnected)) != null) {
                this.cacheFeatureComponents.putAll(mapCreateFunctionComponents);
            }
        }
        this.extraComponents.putAll(this.cacheFeatureComponents);
    }

    private final void addFunctionComponents(boolean canShow) {
        IOTDevice iOTDevice;
        if (canShow && (iOTDevice = iOTDevice()) != null) {
            addLowLatency(iOTDevice);
            addInEarDetection(iOTDevice);
            addPersonalizedANC(iOTDevice);
            addPersonalisedSound(iOTDevice);
            addSerialNumber(iOTDevice);
            addDualConnection(iOTDevice);
            addEarFitTest(iOTDevice);
            addFindDevice(iOTDevice);
            addHighQualityAudio(iOTDevice);
            addNoiseReduction(iOTDevice);
            addFirmware(iOTDevice);
            addEqualizer(iOTDevice);
            addAdvanced(iOTDevice);
            addControls(iOTDevice);
            addGestureControls(iOTDevice);
            addSound(iOTDevice);
            addANC(iOTDevice);
            addBattery(iOTDevice);
        }
    }

    private final void addBattery(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
        BatteryComponents batteryComponents = concurrentHashMap2.get(0);
        if (batteryComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(0, (batteryComponents = new BatteryComponents(ViewModelExtKt.getApplicationContext(this), it, this, new Function1() { // from class: com.nothing.os.device.bluetooth.NothingEarViewModel$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NothingEarViewModel.addBattery$lambda$14$lambda$13(this.f$0, (DeviceBattery) obj);
            }
        })))) != null) {
            batteryComponents = baseFunctionComponentsPutIfAbsent;
        }
        concurrentHashMap.put(0, batteryComponents);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addBattery$lambda$14$lambda$13(NothingEarViewModel nothingEarViewModel, DeviceBattery it) {
        Intrinsics.checkNotNullParameter(it, "it");
        nothingEarViewModel.updateHeaderBatteryInfo(it);
        return Unit.INSTANCE;
    }

    private final BatteryComponents getBatteryComponents() {
        BaseFunctionComponents baseFunctionComponents = this.cacheCommonComponents.get(0);
        if (baseFunctionComponents instanceof BatteryComponents) {
            return (BatteryComponents) baseFunctionComponents;
        }
        return null;
    }

    private final void addANC(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportAnc(getMacAddress())) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            ANCComponents aNCComponents = concurrentHashMap2.get(610);
            if (aNCComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(610, (aNCComponents = new ANCComponents(ViewModelExtKt.getApplicationContext(this), it, this, ViewModelKt.getViewModelScope(this))))) != null) {
                aNCComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(610, aNCComponents);
        }
    }

    private final ANCComponents getANCComponents() {
        BaseFunctionComponents baseFunctionComponents = this.cacheCommonComponents.get(610);
        if (baseFunctionComponents instanceof ANCComponents) {
            return (ANCComponents) baseFunctionComponents;
        }
        return null;
    }

    private final void addSound(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
        SoundComponents soundComponents = concurrentHashMap2.get(601);
        if (soundComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(601, (soundComponents = new SoundComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
            soundComponents = baseFunctionComponentsPutIfAbsent;
        }
        concurrentHashMap.put(601, soundComponents);
    }

    private final void addGestureControls(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
        GestureControlsComponents gestureControlsComponents = concurrentHashMap2.get(660);
        if (gestureControlsComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(660, (gestureControlsComponents = new GestureControlsComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
            gestureControlsComponents = baseFunctionComponentsPutIfAbsent;
        }
        concurrentHashMap.put(660, gestureControlsComponents);
    }

    private final void addControls(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
        ControlsComponents controlsComponents = concurrentHashMap2.get(651);
        if (controlsComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(651, (controlsComponents = new ControlsComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
            controlsComponents = baseFunctionComponentsPutIfAbsent;
        }
        concurrentHashMap.put(651, controlsComponents);
    }

    private final void addAdvanced(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
        AdvancedComponents advancedComponents = concurrentHashMap2.get(701);
        if (advancedComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(701, (advancedComponents = new AdvancedComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
            advancedComponents = baseFunctionComponentsPutIfAbsent;
        }
        concurrentHashMap.put(701, advancedComponents);
    }

    private final void addEqualizer(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportEqualizer()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            EqualizerComponents equalizerComponents = concurrentHashMap2.get(620);
            if (equalizerComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(620, (equalizerComponents = new EqualizerComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                equalizerComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(620, equalizerComponents);
        }
    }

    private final void addFirmware(IOTDevice it) {
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
        ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
        BaseFunctionComponents baseFunctionComponents = concurrentHashMap2.get(1310);
        if (baseFunctionComponents == null) {
            FirmwareComponents firmwareComponents = new FirmwareComponents(ViewModelExtKt.getApplicationContext(this), it, this, ViewModelKt.getViewModelScope(this), new Function0() { // from class: com.nothing.os.device.bluetooth.NothingEarViewModel$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NothingEarViewModel.addFirmware$lambda$22$lambda$21(this.f$0);
                }
            });
            BaseFunctionComponents baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(1310, firmwareComponents);
            baseFunctionComponents = baseFunctionComponentsPutIfAbsent == null ? firmwareComponents : baseFunctionComponentsPutIfAbsent;
        }
        concurrentHashMap.put(1310, baseFunctionComponents);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addFirmware$lambda$22$lambda$21(NothingEarViewModel nothingEarViewModel) {
        nothingEarViewModel.refresh();
        nothingEarViewModel.addLiveDataListener();
        return Unit.INSTANCE;
    }

    private final void addNoiseReduction(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportNoiseReduction()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            NoiseReductionComponents noiseReductionComponents = concurrentHashMap2.get(723);
            if (noiseReductionComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(723, (noiseReductionComponents = new NoiseReductionComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                noiseReductionComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(723, noiseReductionComponents);
        }
    }

    private final void addHighQualityAudio(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportHighQualityAudio()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            HighQualityAudioComponents highQualityAudioComponents = concurrentHashMap2.get(717);
            if (highQualityAudioComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(717, (highQualityAudioComponents = new HighQualityAudioComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                highQualityAudioComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(717, highQualityAudioComponents);
        }
    }

    private final void addFindDevice(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportFindMyDevice()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            FindDeviceComponents findDeviceComponents = concurrentHashMap2.get(720);
            if (findDeviceComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(720, (findDeviceComponents = new FindDeviceComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                findDeviceComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(720, findDeviceComponents);
        }
    }

    private final void addEarFitTest(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportEarTipFitTest()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            EarFitTestComponents earFitTestComponents = concurrentHashMap2.get(725);
            if (earFitTestComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(725, (earFitTestComponents = new EarFitTestComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                earFitTestComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(725, earFitTestComponents);
        }
    }

    private final void addDualConnection(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportDual()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            DualComponents dualComponents = concurrentHashMap2.get(718);
            if (dualComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(718, (dualComponents = new DualComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                dualComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(718, dualComponents);
        }
    }

    private final void addSerialNumber(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportSerialNumber()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.cacheCommonComponents;
            SerialNumberComponents serialNumberComponents = concurrentHashMap.get(1300);
            if (serialNumberComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap.putIfAbsent(1300, (serialNumberComponents = new SerialNumberComponents(ViewModelExtKt.getApplicationContext(this), it, this, new Function1() { // from class: com.nothing.os.device.bluetooth.NothingEarViewModel$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingEarViewModel.addSerialNumber$lambda$31$lambda$30(this.f$0, (String) obj);
                }
            })))) != null) {
                serialNumberComponents = baseFunctionComponentsPutIfAbsent;
            }
            BaseFunctionComponents baseFunctionComponents = serialNumberComponents;
            SerialNumberComponents serialNumberComponents2 = getSerialNumberComponents();
            if (serialNumberComponents2 == null || !serialNumberComponents2.hasSerialNUmber()) {
                return;
            }
            this.extraComponents.put(1300, baseFunctionComponents);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit addSerialNumber$lambda$31$lambda$30(NothingEarViewModel nothingEarViewModel, String sn) {
        NormalItemViewModel next;
        Intrinsics.checkNotNullParameter(sn, "sn");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "SerialNumberComponents call back " + sn;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        Iterator<NormalItemViewModel> it = nothingEarViewModel.getListViewModels().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (next.getOrder() != 1300);
        NormalItemViewModel normalItemViewModel = next;
        if (sn.length() == 0) {
            nothingEarViewModel.extraComponents.remove(1300);
            nothingEarViewModel.getListViewModels().remove(normalItemViewModel);
        }
        nothingEarViewModel.notifyAdapter();
        return Unit.INSTANCE;
    }

    private final SerialNumberComponents getSerialNumberComponents() {
        BaseFunctionComponents baseFunctionComponents = this.cacheCommonComponents.get(1300);
        if (baseFunctionComponents instanceof SerialNumberComponents) {
            return (SerialNumberComponents) baseFunctionComponents;
        }
        return null;
    }

    private final void addPersonalisedSound(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportPersonalSound()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            PersonalisedSoundComponents personalisedSoundComponents = concurrentHashMap2.get(716);
            if (personalisedSoundComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(716, (personalisedSoundComponents = new PersonalisedSoundComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                personalisedSoundComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(716, personalisedSoundComponents);
        }
    }

    private final void addPersonalizedANC(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportPersonalANC()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            PersonalizedANCComponents personalizedANCComponents = concurrentHashMap2.get(713);
            if (personalizedANCComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(713, (personalizedANCComponents = new PersonalizedANCComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                personalizedANCComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(713, personalizedANCComponents);
        }
    }

    private final void addInEarDetection(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportInEarDetect()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            InEarDetectionComponents inEarDetectionComponents = concurrentHashMap2.get(710);
            if (inEarDetectionComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(710, (inEarDetectionComponents = new InEarDetectionComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                inEarDetectionComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(710, inEarDetectionComponents);
        }
    }

    private final void addLowLatency(IOTDevice it) {
        BaseFunctionComponents baseFunctionComponentsPutIfAbsent;
        if (it.isSupportLagLatency()) {
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap = this.extraComponents;
            ConcurrentHashMap<Integer, BaseFunctionComponents> concurrentHashMap2 = this.cacheCommonComponents;
            LowLatencyComponents lowLatencyComponents = concurrentHashMap2.get(715);
            if (lowLatencyComponents == null && (baseFunctionComponentsPutIfAbsent = concurrentHashMap2.putIfAbsent(715, (lowLatencyComponents = new LowLatencyComponents(ViewModelExtKt.getApplicationContext(this), it, this)))) != null) {
                lowLatencyComponents = baseFunctionComponentsPutIfAbsent;
            }
            concurrentHashMap.put(715, lowLatencyComponents);
        }
    }

    public final BaseFunctionComponents getFunctionComponents(int order) {
        return this.extraComponents.get(Integer.valueOf(order));
    }

    /* JADX WARN: Code duplicated, block: B:42:0x00d1  */
    private final void updateHeaderBatteryInfo(DeviceBattery battery) {
        Battery stereo;
        Integer numValueOf;
        if (battery.hasBattery()) {
            this.isUpdateBattery = true;
            ObservableField<Boolean> leftCharging = getHeaderViewModel().getLeftCharging();
            Battery left = battery.getLeft();
            leftCharging.set(left != null ? Boolean.valueOf(left.isRecharging()) : null);
            ObservableField<Boolean> rightCharging = getHeaderViewModel().getRightCharging();
            Battery right = battery.getRight();
            rightCharging.set(right != null ? Boolean.valueOf(right.isRecharging()) : null);
            ObservableField<Boolean> caseCharging = getHeaderViewModel().getCaseCharging();
            Battery battery2 = battery.getCase();
            caseCharging.set(Boolean.valueOf((battery2 != null && battery2.isRecharging()) || ((stereo = battery.getStereo()) != null && stereo.isRecharging())));
            Battery left2 = battery.getLeft();
            boolean z = (left2 != null ? Integer.valueOf(left2.getBattery()) : null) != null;
            getHeaderViewModel().getLeftBatteryVisible().set(Boolean.valueOf(z));
            getHeaderViewModel().getLeftVisible().set(Boolean.valueOf(z));
            Battery battery3 = battery.getCase();
            if ((battery3 != null ? Integer.valueOf(battery3.getBattery()) : null) != null) {
                Battery battery4 = battery.getCase();
                if (battery4 != null) {
                    numValueOf = Integer.valueOf(battery4.getBattery());
                } else {
                    numValueOf = null;
                }
            } else {
                Battery stereo2 = battery.getStereo();
                if (stereo2 != null) {
                    numValueOf = Integer.valueOf(stereo2.getBattery());
                } else {
                    numValueOf = null;
                }
            }
            Battery left3 = battery.getLeft();
            Integer numValueOf2 = left3 != null ? Integer.valueOf(left3.getBattery()) : null;
            Battery right2 = battery.getRight();
            Triple<String, String, String> tripleBatterInfo = batterInfo(numValueOf2, numValueOf, right2 != null ? Integer.valueOf(right2.getBattery()) : null);
            Battery left4 = battery.getLeft();
            if (left4 != null) {
                int battery5 = left4.getBattery();
                getHeaderViewModel().getLeftBattery().set(tripleBatterInfo.getFirst());
                getHeaderViewModel().getLeftLevel().set(battery5);
            }
            boolean z2 = numValueOf != null;
            getHeaderViewModel().getCaseBatteryVisible().set(Boolean.valueOf(z2));
            getHeaderViewModel().getCaseVisible().set(Boolean.valueOf(z2));
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                getHeaderViewModel().getCaseBattery().set(tripleBatterInfo.getSecond());
                getHeaderViewModel().getCaseLevel().set(iIntValue);
            }
            Battery right3 = battery.getRight();
            boolean z3 = (right3 != null ? Integer.valueOf(right3.getBattery()) : null) != null;
            getHeaderViewModel().getRightBatteryVisible().set(Boolean.valueOf(z3));
            getHeaderViewModel().getRightVisible().set(Boolean.valueOf(z3));
            Battery right4 = battery.getRight();
            if (right4 != null) {
                int battery6 = right4.getBattery();
                getHeaderViewModel().getRightBattery().set(tripleBatterInfo.getThird());
                getHeaderViewModel().getRightLevel().set(battery6);
            }
        }
    }

    public final void updateNoiseMode(int type) {
        ANCComponents aNCComponents = getANCComponents();
        if (aNCComponents != null) {
            aNCComponents.updateNoiseMode(type);
        }
    }

    public final void updateNoiseMode() {
        ANCComponents aNCComponents = getANCComponents();
        if (aNCComponents != null) {
            int noiseOpenSelectMode = aNCComponents.getNoiseOpenSelectMode();
            ANCComponents aNCComponents2 = getANCComponents();
            if (aNCComponents2 != null) {
                aNCComponents2.updateNoiseMode(noiseOpenSelectMode);
            }
        }
    }
}
