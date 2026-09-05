package com.nothing.espeon.equalizer;

import android.app.Activity;
import android.widget.PopupWindow;
import androidx.activity.ComponentActivity;
import com.nothing.base.popupwindow.ForBottomPopupWindow;
import com.nothing.ear.R;
import com.nothing.ear.databinding.EspeonDiracEqGuideDialogBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DiracEQGuideDialog.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J2\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011J\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0011X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/nothing/espeon/equalizer/DiracEQGuideDialog;", "Lcom/nothing/base/popupwindow/ForBottomPopupWindow;", "Lcom/nothing/ear/databinding/EspeonDiracEqGuideDialogBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/espeon/equalizer/EqualizerViewModel;", "onCreate", "", "activity", "Landroid/app/Activity;", "popupWindow", "Landroid/widget/PopupWindow;", "binding", "show", "Landroidx/activity/ComponentActivity;", "action", "Lkotlin/Function0;", "negativeAction", "onClickPositive", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiracEQGuideDialog extends ForBottomPopupWindow<EspeonDiracEqGuideDialogBinding> {
    private Function0<Unit> action;
    private Function0<Unit> negativeAction;
    private EqualizerViewModel viewModel;

    public DiracEQGuideDialog() {
        super(R.layout.espeon_dirac_eq_guide_dialog);
    }

    @Override // com.nothing.base.popupwindow.ForBottomPopupWindow
    public void onCreate(Activity activity, PopupWindow popupWindow, EspeonDiracEqGuideDialogBinding binding) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(popupWindow, "popupWindow");
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.onCreate(activity, popupWindow, binding);
        EqualizerViewModel equalizerViewModel = this.viewModel;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        binding.setViewModel(equalizerViewModel);
        binding.setEventHandler(this);
        binding.executePendingBindings();
    }

    public final void show(ComponentActivity activity, EqualizerViewModel viewModel, Function0<Unit> action, Function0<Unit> negativeAction) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(negativeAction, "negativeAction");
        this.action = action;
        this.negativeAction = negativeAction;
        this.viewModel = viewModel;
        super.show(activity);
        EspeonDiracEqGuideDialogBinding binding = getBinding();
        if (binding != null) {
            binding.setViewModel(viewModel);
        }
        EspeonDiracEqGuideDialogBinding binding2 = getBinding();
        if (binding2 != null) {
            binding2.setEventHandler(this);
        }
        EspeonDiracEqGuideDialogBinding binding3 = getBinding();
        if (binding3 != null) {
            binding3.executePendingBindings();
        }
    }

    public final void onClickPositive() {
        Function0<Unit> function0 = this.action;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("action");
            function0 = null;
        }
        function0.invoke();
        dismiss();
    }
}
