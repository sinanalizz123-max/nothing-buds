package com.nothing.espeon.control.os;

import androidx.databinding.ObservableArrayList;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.base.adapter.CommonBindingAdapter;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.earbase.anc.OSNoiseSelectDialog;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.VoiceAssistantUtil;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.os.control.ControlOperationActivity;
import com.nothing.earbase.os.control.OSVoiceAssistantSelectDialog;
import com.nothing.espeon.control.ControlItemViewModel;
import com.nothing.espeon.control.ControlViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EspeonCaseControlOperationActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/espeon/control/os/EspeonCaseControlOperationActivity;", "Lcom/nothing/earbase/os/control/ControlOperationActivity;", "<init>", "()V", "getControlViewModel", "Lcom/nothing/earbase/control/BaseControlViewModel;", "refreshGestureData", "", "viewModel", "isLeft", "", "createGestureViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "onClickNoiseSetting", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "itemViewModel", "onClickTransparency", "onClickNoiseCancellation", "onClickOff", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EspeonCaseControlOperationActivity extends ControlOperationActivity {
    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public BaseControlViewModel getControlViewModel() {
        return (BaseControlViewModel) new ViewModelProvider(this).get(ControlViewModel.class);
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public void refreshGestureData(BaseControlViewModel viewModel, boolean isLeft) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        for (CommonBindingMoreType commonBindingMoreType : viewModel.getCaseGestureData()) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                ControlConfigurationEntity.Operation selectOperation = getSelectOperation();
                Integer numValueOf = selectOperation != null ? Integer.valueOf(selectOperation.getGesture()) : null;
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType;
                ControlConfigurationEntity.Operation options = controlGestureViewModel.getOptions();
                if (Intrinsics.areEqual(numValueOf, options != null ? Integer.valueOf(options.getGesture()) : null)) {
                    getActionBarBinding().headerBar.setTitle2(controlGestureViewModel.getGestureName().get());
                    getMBinding().rvOperation.setAdapter(new CommonBindingAdapter.Builder().setLayoutId(R.layout.os_control_dialog_item).setEventHandler((Object) this).addVariable(BR.itemViewModel, (Object) commonBindingMoreType).setDataList((ObservableArrayList) controlGestureViewModel.getOperationList()).build());
                }
            }
        }
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public ControlGestureViewModel createGestureViewModel(ControlConfigurationEntity.Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new ControlItemViewModel(operation, this, getViewModel().getAddress(), null, 8, null);
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
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

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public boolean onClickTransparency(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int transparency = dialogItemViewModel.toTransparency();
        if (getViewModel() instanceof ControlViewModel) {
            BaseControlViewModel viewModel = getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.espeon.control.ControlViewModel");
            ((ControlViewModel) viewModel).setAncGestureData((ControlItemViewModel) itemViewModel, transparency, dialogItemViewModel);
        }
        return transparency != 0;
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public boolean onClickNoiseCancellation(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int noiseCancellation = dialogItemViewModel.toNoiseCancellation();
        if (getViewModel() instanceof ControlViewModel) {
            BaseControlViewModel viewModel = getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.espeon.control.ControlViewModel");
            ((ControlViewModel) viewModel).setAncGestureData((ControlItemViewModel) itemViewModel, noiseCancellation, dialogItemViewModel);
        }
        return noiseCancellation != 0;
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public boolean onClickOff(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int off = dialogItemViewModel.toOff();
        if (getViewModel() instanceof ControlViewModel) {
            BaseControlViewModel viewModel = getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.espeon.control.ControlViewModel");
            ((ControlViewModel) viewModel).setAncGestureData((ControlItemViewModel) itemViewModel, off, dialogItemViewModel);
        }
        return off != 0;
    }
}
