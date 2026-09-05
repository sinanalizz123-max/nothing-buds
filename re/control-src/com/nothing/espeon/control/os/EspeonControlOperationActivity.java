package com.nothing.espeon.control.os;

import androidx.lifecycle.ViewModelProvider;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.os.control.ControlOperationActivity;
import com.nothing.espeon.control.ControlItemViewModel;
import com.nothing.espeon.control.ControlViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EspeonControlOperationActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/espeon/control/os/EspeonControlOperationActivity;", "Lcom/nothing/earbase/os/control/ControlOperationActivity;", "<init>", "()V", "getControlViewModel", "Lcom/nothing/earbase/control/BaseControlViewModel;", "createGestureViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "onClickTransparency", "", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "itemViewModel", "onClickNoiseCancellation", "onClickOff", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EspeonControlOperationActivity extends ControlOperationActivity {
    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public BaseControlViewModel getControlViewModel() {
        return (BaseControlViewModel) new ViewModelProvider(this).get(ControlViewModel.class);
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public ControlGestureViewModel createGestureViewModel(ControlConfigurationEntity.Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new ControlItemViewModel(operation, this, getViewModel().getAddress(), null, 8, null);
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
