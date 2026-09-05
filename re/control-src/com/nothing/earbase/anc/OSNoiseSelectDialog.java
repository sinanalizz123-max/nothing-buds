package com.nothing.earbase.anc;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.ScreenUtils;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.BaseConfig;
import com.nothing.base.view.BaseDialogFragment;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.OsControlNoiseDialogBinding;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.os.control.ControlOperationActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSNoiseSelectDialog.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Lcom/nothing/earbase/anc/OSNoiseSelectDialog;", "Lcom/nothing/base/view/BaseDialogFragment;", "Lcom/nothing/ear/databinding/OsControlNoiseDialogBinding;", "viewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "eventHandler", "Lcom/nothing/earbase/os/control/ControlOperationActivity;", "<init>", "(Lcom/nothing/earbase/control/ControlOperationViewModel;Lcom/nothing/earbase/control/ControlGestureViewModel;Lcom/nothing/earbase/os/control/ControlOperationActivity;)V", "getViewModel", "()Lcom/nothing/earbase/control/ControlOperationViewModel;", "getItemViewModel", "()Lcom/nothing/earbase/control/ControlGestureViewModel;", "getEventHandler", "()Lcom/nothing/earbase/os/control/ControlOperationActivity;", "createContentConfig", "", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "setDefaultBackground", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "onStart", "onInitContentBinding", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSNoiseSelectDialog extends BaseDialogFragment<OsControlNoiseDialogBinding> {
    public static final float MARGIN = 48.0f;
    private final ControlOperationActivity eventHandler;
    private final ControlGestureViewModel itemViewModel;
    private final ControlOperationViewModel viewModel;

    @Override // com.nothing.base.view.BaseDialogFragment
    public void setDefaultBackground(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
    }

    public final ControlOperationViewModel getViewModel() {
        return this.viewModel;
    }

    public final ControlGestureViewModel getItemViewModel() {
        return this.itemViewModel;
    }

    public final ControlOperationActivity getEventHandler() {
        return this.eventHandler;
    }

    public OSNoiseSelectDialog(ControlOperationViewModel viewModel, ControlGestureViewModel itemViewModel, ControlOperationActivity eventHandler) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        this.viewModel = viewModel;
        this.itemViewModel = itemViewModel;
        this.eventHandler = eventHandler;
    }

    @Override // com.nothing.base.view.BaseDialogFragment
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        contentConfig.setLayoutId(R.layout.os_control_noise_dialog).addVariable(BR.viewModel, this.viewModel).addVariable(BR.itemViewModel, this.itemViewModel);
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.show(manager, "set_noise_dialog");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        int screenWidth = ScreenUtils.getScreenWidth();
        Context context = getMBinding().getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int iDp2px = screenWidth - ContextExtKt.dp2px(context, 48.0f);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(iDp2px, -2);
    }

    @Override // com.nothing.base.view.BaseDialogFragment
    public void onInitContentBinding(BaseActivityBinding rootBinding) {
        Window window;
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        super.onInitContentBinding(rootBinding);
        rootBinding.getRoot().setBackgroundColor(0);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        getMBinding().ancNoiseControl.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.earbase.anc.OSNoiseSelectDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OSNoiseSelectDialog.onInitContentBinding$lambda$0(this.f$0, view);
            }
        });
        getMBinding().ancNoiseOff.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.earbase.anc.OSNoiseSelectDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OSNoiseSelectDialog.onInitContentBinding$lambda$1(this.f$0, view);
            }
        });
        getMBinding().ancNoiseTransparency.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.earbase.anc.OSNoiseSelectDialog$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OSNoiseSelectDialog.onInitContentBinding$lambda$2(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitContentBinding$lambda$0(OSNoiseSelectDialog oSNoiseSelectDialog, View view) {
        if (oSNoiseSelectDialog.eventHandler.onClickNoiseCancellation(oSNoiseSelectDialog.viewModel, oSNoiseSelectDialog.itemViewModel)) {
            return;
        }
        oSNoiseSelectDialog.getMBinding().ancNoiseControl.setChecked(!oSNoiseSelectDialog.getMBinding().ancNoiseControl.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitContentBinding$lambda$1(OSNoiseSelectDialog oSNoiseSelectDialog, View view) {
        if (oSNoiseSelectDialog.eventHandler.onClickOff(oSNoiseSelectDialog.viewModel, oSNoiseSelectDialog.itemViewModel)) {
            return;
        }
        oSNoiseSelectDialog.getMBinding().ancNoiseOff.setChecked(!oSNoiseSelectDialog.getMBinding().ancNoiseOff.isChecked());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitContentBinding$lambda$2(OSNoiseSelectDialog oSNoiseSelectDialog, View view) {
        if (oSNoiseSelectDialog.eventHandler.onClickTransparency(oSNoiseSelectDialog.viewModel, oSNoiseSelectDialog.itemViewModel)) {
            return;
        }
        oSNoiseSelectDialog.getMBinding().ancNoiseTransparency.setChecked(!oSNoiseSelectDialog.getMBinding().ancNoiseTransparency.isChecked());
    }
}
