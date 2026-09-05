package com.nothing.earbase.os.control;

import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.nothing.base.adapter.CommonBindingAdapter;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.database.util.SpUtils;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.OsControlOperationActivityBinding;
import com.nothing.earbase.anc.OSNoiseSelectDialog;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.VoiceAssistantUtil;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ControlOperationActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0014J\u0014\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fJ\u0006\u0010!\u001a\u00020\u001dJ\u0012\u0010\"\u001a\u00020\u00172\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0018\u0010%\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\fH\u0016J\b\u0010'\u001a\u00020\fH\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0011H\u0016J\u0016\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020)J\b\u0010/\u001a\u00020\u0017H\u0016J\u0018\u00100\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020)H\u0016J\u0018\u00101\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020)H\u0016J\u0018\u00102\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020)H\u0016J\u0018\u00103\u001a\u00020\f2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020)H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u00065"}, d2 = {"Lcom/nothing/earbase/os/control/ControlOperationActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/OsControlOperationActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/earbase/control/BaseControlViewModel;", "getViewModel", "()Lcom/nothing/earbase/control/BaseControlViewModel;", "setViewModel", "(Lcom/nothing/earbase/control/BaseControlViewModel;)V", "isChangeData", "", "()Z", "setChangeData", "(Z)V", "selectOperation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "getSelectOperation", "()Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "setSelectOperation", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;)V", "createContentConfig", "", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "getControlViewModel", "onDestroy", "checkHasSelectAssistant", "", "gesture", "Landroidx/databinding/ObservableArrayList;", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "getVoiceAssistantCount", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "refreshGestureData", "isLeft", "isSystemPage", "createGestureViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "onSelectedOperation", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "itemViewModel", "onBackPressedInner", "onClickNoiseSetting", "onClickTransparency", "onClickNoiseCancellation", "onClickOff", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ControlOperationActivity extends BaseActivity<OsControlOperationActivityBinding> {
    public static final String IS_LEFT = "IS_LEFT";
    public static final String ITEM_DATA = "ITEM_DATA";
    private boolean isChangeData;
    private ControlConfigurationEntity.Operation selectOperation;
    public BaseControlViewModel viewModel;

    @Override // com.nothing.base.view.BaseActivity
    public boolean isSystemPage() {
        return true;
    }

    public final BaseControlViewModel getViewModel() {
        BaseControlViewModel baseControlViewModel = this.viewModel;
        if (baseControlViewModel != null) {
            return baseControlViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(BaseControlViewModel baseControlViewModel) {
        Intrinsics.checkNotNullParameter(baseControlViewModel, "<set-?>");
        this.viewModel = baseControlViewModel;
    }

    /* JADX INFO: renamed from: isChangeData, reason: from getter */
    public final boolean getIsChangeData() {
        return this.isChangeData;
    }

    public final void setChangeData(boolean z) {
        this.isChangeData = z;
    }

    public final ControlConfigurationEntity.Operation getSelectOperation() {
        return this.selectOperation;
    }

    public final void setSelectOperation(ControlConfigurationEntity.Operation operation) {
        this.selectOperation = operation;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        setViewModel(getControlViewModel());
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("device_address") : null;
        String str = string;
        if (str == null || str.length() == 0) {
            string = SpUtils.INSTANCE.getSelectDeviceMac();
        }
        VoiceAssistantUtil.INSTANCE.initParameters(string);
        getViewModel().register(getIntent().getExtras());
        contentConfig.setLayoutId(R.layout.os_control_operation_activity).addVariable(BR.eventHandler, this);
    }

    public BaseControlViewModel getControlViewModel() {
        return (BaseControlViewModel) new ViewModelProvider(this).get(BaseControlViewModel.class);
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VoiceAssistantUtil.INSTANCE.resetParameters();
    }

    public final int checkHasSelectAssistant(ObservableArrayList<CommonBindingMoreType> gesture) {
        Intrinsics.checkNotNullParameter(gesture, "gesture");
        int i = 0;
        for (CommonBindingMoreType commonBindingMoreType : gesture) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                VoiceAssistantUtil voiceAssistantUtil = VoiceAssistantUtil.INSTANCE;
                ControlConfigurationEntity.Operation options = ((ControlGestureViewModel) commonBindingMoreType).getOptions();
                if (voiceAssistantUtil.isVoiceAssistant(options != null ? options.getOperation() : 0)) {
                    i++;
                }
            }
        }
        return i;
    }

    public final int getVoiceAssistantCount() {
        return checkHasSelectAssistant(getViewModel().getLeftGestureData()) + checkHasSelectAssistant(getViewModel().getRightGestureData());
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        getMBinding().rvOperation.setLayoutManager(new LinearLayoutManager(this));
        Bundle extras = getIntent().getExtras();
        this.selectOperation = extras != null ? (ControlConfigurationEntity.Operation) extras.getParcelable(ITEM_DATA) : null;
        Bundle extras2 = getIntent().getExtras();
        final boolean z = extras2 != null ? extras2.getBoolean(IS_LEFT) : true;
        getViewModel().getDataUpdate().observe(this, new ControlOperationActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.os.control.ControlOperationActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlOperationActivity.onInit$lambda$1(z, this, (Pair) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInit$lambda$1(boolean z, ControlOperationActivity controlOperationActivity, Pair pair) {
        if (((Number) pair.getFirst()).intValue() == 1) {
            if (z) {
                controlOperationActivity.refreshGestureData(controlOperationActivity.getViewModel(), true);
            } else {
                controlOperationActivity.refreshGestureData(controlOperationActivity.getViewModel(), false);
            }
        }
        return Unit.INSTANCE;
    }

    public void refreshGestureData(BaseControlViewModel viewModel, boolean isLeft) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        for (CommonBindingMoreType commonBindingMoreType : isLeft ? viewModel.getLeftGestureData() : viewModel.getRightGestureData()) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                ControlConfigurationEntity.Operation operation = this.selectOperation;
                Integer numValueOf = operation != null ? Integer.valueOf(operation.getGesture()) : null;
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType;
                ControlConfigurationEntity.Operation options = controlGestureViewModel.getOptions();
                if (Intrinsics.areEqual(numValueOf, options != null ? Integer.valueOf(options.getGesture()) : null)) {
                    ControlConfigurationEntity.Operation operation2 = this.selectOperation;
                    Integer numValueOf2 = operation2 != null ? Integer.valueOf(operation2.getButton()) : null;
                    ControlConfigurationEntity.Operation options2 = controlGestureViewModel.getOptions();
                    if (Intrinsics.areEqual(numValueOf2, options2 != null ? Integer.valueOf(options2.getButton()) : null)) {
                        Iterator<ControlOperationViewModel> it = controlGestureViewModel.getOperationList().iterator();
                        while (it.hasNext()) {
                            it.next().setSelectChatGpt(VoiceAssistantUtil.INSTANCE.isSelectChatGpt());
                        }
                        getActionBarBinding().headerBar.setTitle2(controlGestureViewModel.getGestureName().get());
                        getMBinding().rvOperation.setAdapter(new CommonBindingAdapter.Builder().setLayoutId(R.layout.os_control_dialog_item).setEventHandler((Object) this).addVariable(BR.itemViewModel, (Object) commonBindingMoreType).setDataList((ObservableArrayList) controlGestureViewModel.getOperationList()).build());
                    }
                }
            }
        }
    }

    public ControlGestureViewModel createGestureViewModel(ControlConfigurationEntity.Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new ControlGestureViewModel(operation, this, getViewModel().getAddress(), null, false, 24, null);
    }

    public final void onSelectedOperation(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        this.isChangeData = true;
        getViewModel().setGestureData(itemViewModel, dialogItemViewModel);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onBackPressedInner() {
        if (this.isChangeData) {
            Intent intent = new Intent();
            intent.putExtra(ITEM_DATA, this.selectOperation);
            setResult(-1, intent);
        }
        super.onBackPressedInner();
    }

    public void onClickNoiseSetting(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        if (VoiceAssistantUtil.INSTANCE.isVoiceAssistant(dialogItemViewModel.getOperation())) {
            OSVoiceAssistantSelectDialog oSVoiceAssistantSelectDialog = new OSVoiceAssistantSelectDialog(dialogItemViewModel, itemViewModel, this, getViewModel().getAddress());
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            oSVoiceAssistantSelectDialog.show(supportFragmentManager);
            return;
        }
        OSNoiseSelectDialog oSNoiseSelectDialog = new OSNoiseSelectDialog(dialogItemViewModel, itemViewModel, this);
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager2, "getSupportFragmentManager(...)");
        oSNoiseSelectDialog.show(supportFragmentManager2);
    }

    public boolean onClickTransparency(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        return dialogItemViewModel.toTransparency() != 0;
    }

    public boolean onClickNoiseCancellation(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        return dialogItemViewModel.toNoiseCancellation() != 0;
    }

    public boolean onClickOff(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        return dialogItemViewModel.toOff() != 0;
    }
}
