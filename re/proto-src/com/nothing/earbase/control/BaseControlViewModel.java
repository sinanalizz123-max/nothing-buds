package com.nothing.earbase.control;

import android.app.Application;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.MutableLiveData;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.BaseAndroidLifecycleViewModel;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.R;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.control.entity.ControlRadius;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: compiled from: BaseControlViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 e2\u00020\u00012\u00020\u0002:\u0001eB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010GH\u0016J\u000e\u0010H\u001a\u00020E2\u0006\u0010I\u001a\u00020.J\u000e\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020\tJ\u000e\u0010L\u001a\u00020\tH\u0082@\u00a2\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020EH&J\u0018\u0010O\u001a\u00020E2\u0006\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020RH\u0016J\u000e\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020\tJ\u0006\u0010U\u001a\u00020\tJ\u0006\u0010V\u001a\u00020\tJ\b\u0010W\u001a\u00020\tH\u0002J\b\u0010X\u001a\u00020\tH\u0002J\u0014\u0010Y\u001a\u00020E2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00140[J\b\u0010\\\u001a\u00020EH\u0016J\b\u0010]\u001a\u00020EH\u0016J\u001a\u0010^\u001a\u00020E2\u0006\u0010_\u001a\u00020\"2\b\u0010`\u001a\u0004\u0018\u00010?H\u0016J\u0018\u0010a\u001a\u00020E2\u0006\u0010b\u001a\u00020\"2\u0006\u0010c\u001a\u00020dH\u0016R(\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R,\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t0!0 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010'\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\f\"\u0004\b)\u0010\u000eR(\u0010*\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\f\"\u0004\b,\u0010\u000eR \u0010-\u001a\b\u0012\u0004\u0012\u00020.0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\f\"\u0004\b0\u0010\u000eR(\u00101\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\"0\"0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\f\"\u0004\b3\u0010\u000eR(\u00104\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\"0\"0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR(\u00107\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\"0\"0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\f\"\u0004\b9\u0010\u000eR\u001a\u0010:\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020?X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C\u00a8\u0006f"}, d2 = {"Lcom/nothing/earbase/control/BaseControlViewModel;", "Lcom/nothing/device/BaseAndroidLifecycleViewModel;", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "leftTextVisible", "Landroidx/databinding/ObservableField;", "", "kotlin.jvm.PlatformType", "getLeftTextVisible", "()Landroidx/databinding/ObservableField;", "setLeftTextVisible", "(Landroidx/databinding/ObservableField;)V", "rightTextVisible", "getRightTextVisible", "setRightTextVisible", "leftGestureData", "Landroidx/databinding/ObservableArrayList;", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "getLeftGestureData", "()Landroidx/databinding/ObservableArrayList;", "setLeftGestureData", "(Landroidx/databinding/ObservableArrayList;)V", "rightGestureData", "getRightGestureData", "setRightGestureData", "caseGestureData", "getCaseGestureData", "setCaseGestureData", "dataUpdate", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "getDataUpdate", "()Landroidx/lifecycle/MutableLiveData;", "setDataUpdate", "(Landroidx/lifecycle/MutableLiveData;)V", "subOperationVisible", "getSubOperationVisible", "setSubOperationVisible", "gestureVisible", "getGestureVisible", "setGestureVisible", "selectedItemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "getSelectedItemViewModel", "setSelectedItemViewModel", "leftSelectedRes", "getLeftSelectedRes", "setLeftSelectedRes", "rightSelectedRes", "getRightSelectedRes", "setRightSelectedRes", "caseSelectedRes", "getCaseSelectedRes", "setCaseSelectedRes", "isSystem", "()Z", "setSystem", "(Z)V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "register", "", "extras", "Landroid/os/Bundle;", "setSelectedItem", "itemViewModel", "getGestureData", "isAsync", "getKeyConfiguration", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetGestureData", "setGestureData", "viewModel", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "addScore", "isSuccess", "checkHasSetValue", "checkCaseValue", "checkRightValue", "checkLeftValue", "setControlRadius", "list", "", "onConnected", "onDisconnected", "onError", "code", "message", "onUpdate", "cmdType", "data", "Lcom/nothing/protocol/model/Message;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseControlViewModel extends BaseAndroidLifecycleViewModel implements TWSDevice.Callback {
    public static final int CALL_OPERATION_TYPE = 9;
    public static final int CONTROL_RESET = 4;
    public static final int CONTROL_UPDATE = 1;
    public static final long DELAY_ANIMATION = 500;
    public static final long DELAY_SEND = 1500;
    private String address;
    private ObservableArrayList<CommonBindingMoreType> caseGestureData;
    private ObservableField<Integer> caseSelectedRes;
    private MutableLiveData<Pair<Integer, Boolean>> dataUpdate;
    private ObservableField<Boolean> gestureVisible;
    private boolean isSystem;
    private ObservableArrayList<CommonBindingMoreType> leftGestureData;
    private ObservableField<Integer> leftSelectedRes;
    private ObservableField<Boolean> leftTextVisible;
    private ObservableArrayList<CommonBindingMoreType> rightGestureData;
    private ObservableField<Integer> rightSelectedRes;
    private ObservableField<Boolean> rightTextVisible;
    private ObservableField<ControlGestureViewModel> selectedItemViewModel;
    private ObservableField<Boolean> subOperationVisible;

    /* JADX INFO: renamed from: com.nothing.earbase.control.BaseControlViewModel$getKeyConfiguration$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseControlViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.control.BaseControlViewModel", f = "BaseControlViewModel.kt", i = {0}, l = {85}, m = "getKeyConfiguration", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseControlViewModel.this.getKeyConfiguration(this);
        }
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(int code, String message) {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public abstract void resetGestureData();

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void getBesVersionSuccess() {
        TWSDevice.Callback.DefaultImpls.getBesVersionSuccess(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public boolean isIOThread() {
        return TWSDevice.Callback.DefaultImpls.isIOThread(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnected(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnecting(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnecting(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onDisconnected(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice, int i, String str) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i, str);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int i, Message message, TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onUpdate(this, i, message, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void openBluetooth(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.openBluetooth(this, tWSDevice);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseControlViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.leftTextVisible = new ObservableField<>(false);
        this.rightTextVisible = new ObservableField<>(false);
        this.leftGestureData = new ObservableArrayList<>();
        this.rightGestureData = new ObservableArrayList<>();
        this.caseGestureData = new ObservableArrayList<>();
        this.dataUpdate = new MutableLiveData<>();
        this.subOperationVisible = new ObservableField<>(false);
        this.gestureVisible = new ObservableField<>(true);
        this.selectedItemViewModel = new ObservableField<>();
        this.leftSelectedRes = new ObservableField<>(0);
        this.rightSelectedRes = new ObservableField<>(0);
        this.caseSelectedRes = new ObservableField<>(0);
        this.address = "";
    }

    public final ObservableField<Boolean> getLeftTextVisible() {
        return this.leftTextVisible;
    }

    public final void setLeftTextVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.leftTextVisible = observableField;
    }

    public final ObservableField<Boolean> getRightTextVisible() {
        return this.rightTextVisible;
    }

    public final void setRightTextVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.rightTextVisible = observableField;
    }

    public final ObservableArrayList<CommonBindingMoreType> getLeftGestureData() {
        return this.leftGestureData;
    }

    public final void setLeftGestureData(ObservableArrayList<CommonBindingMoreType> observableArrayList) {
        Intrinsics.checkNotNullParameter(observableArrayList, "<set-?>");
        this.leftGestureData = observableArrayList;
    }

    public final ObservableArrayList<CommonBindingMoreType> getRightGestureData() {
        return this.rightGestureData;
    }

    public final void setRightGestureData(ObservableArrayList<CommonBindingMoreType> observableArrayList) {
        Intrinsics.checkNotNullParameter(observableArrayList, "<set-?>");
        this.rightGestureData = observableArrayList;
    }

    public final ObservableArrayList<CommonBindingMoreType> getCaseGestureData() {
        return this.caseGestureData;
    }

    public final void setCaseGestureData(ObservableArrayList<CommonBindingMoreType> observableArrayList) {
        Intrinsics.checkNotNullParameter(observableArrayList, "<set-?>");
        this.caseGestureData = observableArrayList;
    }

    public final MutableLiveData<Pair<Integer, Boolean>> getDataUpdate() {
        return this.dataUpdate;
    }

    public final void setDataUpdate(MutableLiveData<Pair<Integer, Boolean>> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.dataUpdate = mutableLiveData;
    }

    public final ObservableField<Boolean> getSubOperationVisible() {
        return this.subOperationVisible;
    }

    public final void setSubOperationVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.subOperationVisible = observableField;
    }

    public final ObservableField<Boolean> getGestureVisible() {
        return this.gestureVisible;
    }

    public final void setGestureVisible(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.gestureVisible = observableField;
    }

    public final ObservableField<ControlGestureViewModel> getSelectedItemViewModel() {
        return this.selectedItemViewModel;
    }

    public final void setSelectedItemViewModel(ObservableField<ControlGestureViewModel> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.selectedItemViewModel = observableField;
    }

    public final ObservableField<Integer> getLeftSelectedRes() {
        return this.leftSelectedRes;
    }

    public final void setLeftSelectedRes(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.leftSelectedRes = observableField;
    }

    public final ObservableField<Integer> getRightSelectedRes() {
        return this.rightSelectedRes;
    }

    public final void setRightSelectedRes(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.rightSelectedRes = observableField;
    }

    public final ObservableField<Integer> getCaseSelectedRes() {
        return this.caseSelectedRes;
    }

    public final void setCaseSelectedRes(ObservableField<Integer> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.caseSelectedRes = observableField;
    }

    /* JADX INFO: renamed from: isSystem, reason: from getter */
    public final boolean getIsSystem() {
        return this.isSystem;
    }

    public final void setSystem(boolean z) {
        this.isSystem = z;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public void register(Bundle extras) {
        String string = extras != null ? extras.getString("device_address") : null;
        String str = string;
        if (str == null || str.length() == 0) {
            string = SpUtils.INSTANCE.getSelectDeviceMac();
        }
        this.address = string;
        VoiceAssistantUtil.INSTANCE.initParameters(this.address);
    }

    public final void setSelectedItem(ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        this.selectedItemViewModel.set(itemViewModel);
        this.subOperationVisible.set(true);
        this.gestureVisible.set(false);
    }

    public final void getGestureData(boolean isAsync) {
        TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
        Triple triple;
        if (!isAsync) {
            IOTDevice iOTDevice = getIOTDevice(this.address);
            if (iOTDevice != null) {
                triple = new Triple(Integer.valueOf(iOTDevice.getLeftImage()), Integer.valueOf(iOTDevice.getRightImage()), Integer.valueOf(iOTDevice.getCaseImage()));
            } else {
                triple = new Triple(Integer.valueOf(R.drawable.ear_default_left), Integer.valueOf(R.drawable.ear_default_right), Integer.valueOf(R.drawable.ear_default_case_3x));
            }
            this.leftSelectedRes = new ObservableField<>(triple.getFirst());
            this.rightSelectedRes = new ObservableField<>(triple.getSecond());
            this.caseSelectedRes = new ObservableField<>(triple.getThird());
        }
        TWSDevice tWSDevice = getTWSDevice(this.address);
        if (tWSDevice == null || (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(tWSDevice)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderKeyConfiguration, false, (byte[]) null, 1, 3, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getKeyConfiguration(Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        BaseControlViewModel baseControlViewModel;
        TWSDeviceBuilder tWSDeviceBuilderKeyConfiguration;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TWSDevice tWSDevice = getTWSDevice(this.address);
            if (tWSDevice != null && (tWSDeviceBuilderKeyConfiguration = TWSDeviceExtKt.keyConfiguration(tWSDevice)) != null) {
                TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderKeyConfiguration, false, (byte[]) null, 0, 7, (Object) null);
            }
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            if (DelayKt.delay(1500L, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            baseControlViewModel = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            baseControlViewModel = (BaseControlViewModel) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Boxing.boxBoolean(!baseControlViewModel.rightGestureData.isEmpty());
    }

    public void setGestureData(ControlGestureViewModel viewModel, ControlOperationViewModel dialogItemViewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        ControlConfigurationEntity.Operation options = viewModel.getOptions();
        if (options != null) {
            AppBuriedPointUtils.INSTANCE.controlData(options.getDevice(), options.getButton(), options.getGesture(), dialogItemViewModel.getOperation(), this.isSystem);
        }
    }

    public final void addScore(boolean isSuccess) {
        String productId;
        GooglePlayScoreUtil googlePlayScoreUtil = GooglePlayScoreUtil.INSTANCE;
        IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(this.address);
        if (productByMacAddress == null || (productId = productByMacAddress.getProductId()) == null) {
            productId = "";
        }
        googlePlayScoreUtil.addScore(isSuccess, productId);
    }

    public final boolean checkHasSetValue() {
        if (checkLeftValue() || checkCaseValue()) {
            return true;
        }
        return checkRightValue();
    }

    public final boolean checkCaseValue() {
        ControlConfigurationEntity.Operation options;
        if (this.caseGestureData.isEmpty()) {
            return false;
        }
        for (CommonBindingMoreType commonBindingMoreType : this.caseGestureData) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType;
                Integer num = controlGestureViewModel.getArrowVisible().get();
                if (num != null && num.intValue() == 0 && ((options = controlGestureViewModel.getOptions()) == null || 1 != options.getOperation() || (controlGestureViewModel.getCallOperation() != null && 1 != controlGestureViewModel.getCallOperation().getOperation()))) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean checkRightValue() {
        ControlConfigurationEntity.Operation options;
        for (CommonBindingMoreType commonBindingMoreType : this.rightGestureData) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType;
                Integer num = controlGestureViewModel.getArrowVisible().get();
                if (num != null && num.intValue() == 0 && ((options = controlGestureViewModel.getOptions()) == null || controlGestureViewModel.getDefaultOperation() != options.getOperation())) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean checkLeftValue() {
        ControlConfigurationEntity.Operation options;
        for (CommonBindingMoreType commonBindingMoreType : this.leftGestureData) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType;
                Integer num = controlGestureViewModel.getArrowVisible().get();
                if (num != null && num.intValue() == 0 && ((options = controlGestureViewModel.getOptions()) == null || controlGestureViewModel.getDefaultOperation() != options.getOperation())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void setControlRadius(List<? extends CommonBindingMoreType> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.size() == 1) {
            CommonBindingMoreType commonBindingMoreType = list.get(0);
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                ((ControlGestureViewModel) commonBindingMoreType).setDirection(ControlRadius.NONE);
                return;
            }
            return;
        }
        CommonBindingMoreType commonBindingMoreType2 = (CommonBindingMoreType) CollectionsKt.firstOrNull((List) list);
        if (commonBindingMoreType2 instanceof ControlGestureViewModel) {
            ((ControlGestureViewModel) commonBindingMoreType2).setDirection(ControlRadius.HEAD);
        }
        CommonBindingMoreType commonBindingMoreType3 = (CommonBindingMoreType) CollectionsKt.lastOrNull((List) list);
        if (commonBindingMoreType3 instanceof ControlGestureViewModel) {
            ((ControlGestureViewModel) commonBindingMoreType3).setDirection(ControlRadius.END);
        }
    }
}
