package com.nothing.espeon.control;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.nothing.base.adapter.CommonBindingAdapter;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.BaseConfig;
import com.nothing.base.wiget.ActionView;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.EspeonControlCaseOperationActivityBinding;
import com.nothing.earbase.control.BaseControlOperationActivity;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ControlCaseOperationActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\rH\u0002J\u0016\u0010#\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001fJ\u0016\u0010$\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001fJ\u0016\u0010%\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/nothing/espeon/control/ControlCaseOperationActivity;", "Lcom/nothing/earbase/control/BaseControlOperationActivity;", "Lcom/nothing/ear/databinding/EspeonControlCaseOperationActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/espeon/control/ControlViewModel;", "isSelectLeft", "", "selectedOperation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "changeOperation", "onInitStatusBar", "", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "rightLabelClickEvent", "onBackPressedInner", "createContentConfig", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "refreshGestureData", "onClickChangeData", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "onSelectedOperation", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "Lcom/nothing/espeon/control/ControlItemViewModel;", "getVoiceAssistantCount", "", "setDefaultScaleSelected", "onClickTransparency", "onClickNoiseCancellation", "onClickOff", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlCaseOperationActivity extends BaseControlOperationActivity<EspeonControlCaseOperationActivityBinding> {
    public static final String CHANGE_OPERATION = "CHANGE_OPERATION";
    public static final String IS_LEFT_SELECTED = "IS_LEFT_SELECTED";
    public static final String SELECTED_OPERATION = "SELECTED_OPERATION";
    private boolean changeOperation;
    private boolean isSelectLeft = true;
    private ControlConfigurationEntity.Operation selectedOperation;
    private ControlViewModel viewModel;

    @Override // com.nothing.earbase.control.BaseControlOperationActivity, com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
    }

    @Override // com.nothing.earbase.control.BaseControlOperationActivity, com.nothing.base.view.BaseActivity
    public void onInitStatusBar(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        FrameLayout frameLayout = rootBinding.rootView;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        frameLayout.setPadding(0, ContextExtKt.getStatusBarHeight(resources), 0, 0);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onBackPressedInner() {
        setResult(-1, new Intent().putExtra("CHANGE_OPERATION", this.changeOperation));
        super.onBackPressedInner();
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        ControlViewModel controlViewModel = (ControlViewModel) new ViewModelProvider(this).get(ControlViewModel.class);
        this.viewModel = controlViewModel;
        ControlViewModel controlViewModel2 = null;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.register(getIntent().getExtras());
        Bundle extras = getIntent().getExtras();
        this.selectedOperation = extras != null ? (ControlConfigurationEntity.Operation) extras.getParcelable("SELECTED_OPERATION") : null;
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.espeon_control_case_operation_activity);
        int i = BR.viewModel;
        ControlViewModel controlViewModel3 = this.viewModel;
        if (controlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel3;
        }
        layoutId.addVariable(i, controlViewModel2).addVariable(BR.eventHandler, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.nothing.earbase.control.BaseControlOperationActivity, com.nothing.base.view.BaseActivity
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        setDefaultScaleSelected();
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).rvOperation.setLayoutManager(new LinearLayoutManager(this));
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).setEventHandler(this);
    }

    private final void refreshGestureData(ControlViewModel viewModel) {
        for (CommonBindingMoreType commonBindingMoreType : viewModel.getCaseGestureData()) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                ControlConfigurationEntity.Operation operation = this.selectedOperation;
                Integer numValueOf = operation != null ? Integer.valueOf(operation.getGesture()) : null;
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType;
                ControlConfigurationEntity.Operation options = controlGestureViewModel.getOptions();
                if (Intrinsics.areEqual(numValueOf, options != null ? Integer.valueOf(options.getGesture()) : null)) {
                    ActionView actionView = getActionBarBinding().headerBar;
                    String str = controlGestureViewModel.getGestureName().get();
                    if (str == null) {
                        str = "";
                    }
                    actionView.setTitle2(str);
                    onClickChangeData(controlGestureViewModel);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void onClickChangeData(final ControlGestureViewModel itemViewModel) {
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).rvOperation.setAdapter(new CommonBindingAdapter.Builder().setLayoutId(R.layout.espeon_control_case_dialog_item).setEventHandler((Object) this).addVariable(BR.itemViewModel, (Object) itemViewModel).setDataList((ObservableArrayList) itemViewModel.getOperationList()).build());
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setSelectedItem(itemViewModel);
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).caseLottie.setVisibility(8);
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).caseLottie.cancelAnimation();
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).caseLottie.setVisibility(0);
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).caseLottie.postDelayed(new Runnable() { // from class: com.nothing.espeon.control.ControlCaseOperationActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ControlCaseOperationActivity.onClickChangeData$lambda$1(this.f$0, itemViewModel);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onClickChangeData$lambda$1(ControlCaseOperationActivity controlCaseOperationActivity, ControlGestureViewModel controlGestureViewModel) {
        ((EspeonControlCaseOperationActivityBinding) controlCaseOperationActivity.getMBinding()).caseLottie.setAnimation(controlGestureViewModel.getLottieString().get());
        ((EspeonControlCaseOperationActivityBinding) controlCaseOperationActivity.getMBinding()).caseLottie.setRepeatCount(-1);
        ((EspeonControlCaseOperationActivityBinding) controlCaseOperationActivity.getMBinding()).caseLottie.playAnimation();
    }

    public final void onSelectedOperation(ControlOperationViewModel dialogItemViewModel, ControlItemViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setGestureData(itemViewModel, dialogItemViewModel);
        this.changeOperation = true;
    }

    @Override // com.nothing.earbase.control.BaseControlOperationActivity
    public int getVoiceAssistantCount() {
        ControlViewModel controlViewModel = this.viewModel;
        ControlViewModel controlViewModel2 = null;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        int iCheckHasSelectAssistant = checkHasSelectAssistant(controlViewModel.getLeftGestureData());
        ControlViewModel controlViewModel3 = this.viewModel;
        if (controlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel3 = null;
        }
        int iCheckHasSelectAssistant2 = iCheckHasSelectAssistant + checkHasSelectAssistant(controlViewModel3.getRightGestureData());
        ControlViewModel controlViewModel4 = this.viewModel;
        if (controlViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel4;
        }
        return iCheckHasSelectAssistant2 + checkHasSelectAssistant(controlViewModel2.getCaseGestureData());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setDefaultScaleSelected() {
        Bundle extras = getIntent().getExtras();
        this.isSelectLeft = extras != null ? extras.getBoolean("IS_LEFT_SELECTED") : true;
        ControlViewModel controlViewModel = this.viewModel;
        ControlViewModel controlViewModel2 = null;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.getDataUpdate().observe(this, new ControlCaseOperationActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.espeon.control.ControlCaseOperationActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlCaseOperationActivity.setDefaultScaleSelected$lambda$2(this.f$0, (Pair) obj);
            }
        }));
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).ivLeft.setScaleX(1.0f);
        ((EspeonControlCaseOperationActivityBinding) getMBinding()).ivLeft.setScaleY(1.0f);
        ControlViewModel controlViewModel3 = this.viewModel;
        if (controlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel3 = null;
        }
        controlViewModel3.getLeftTextVisible().set(true);
        ControlViewModel controlViewModel4 = this.viewModel;
        if (controlViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel4;
        }
        controlViewModel2.getRightTextVisible().set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDefaultScaleSelected$lambda$2(ControlCaseOperationActivity controlCaseOperationActivity, Pair pair) {
        if (pair != null && ((Number) pair.getFirst()).intValue() == 1) {
            ControlViewModel controlViewModel = controlCaseOperationActivity.viewModel;
            if (controlViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel = null;
            }
            controlCaseOperationActivity.refreshGestureData(controlViewModel);
        }
        return Unit.INSTANCE;
    }

    public final void onClickTransparency(ControlOperationViewModel dialogItemViewModel, ControlItemViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int transparency = dialogItemViewModel.toTransparency();
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setAncGestureData(itemViewModel, transparency, dialogItemViewModel);
        this.changeOperation = true;
    }

    public final void onClickNoiseCancellation(ControlOperationViewModel dialogItemViewModel, ControlItemViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int noiseCancellation = dialogItemViewModel.toNoiseCancellation();
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setAncGestureData(itemViewModel, noiseCancellation, dialogItemViewModel);
        this.changeOperation = true;
    }

    public final void onClickOff(ControlOperationViewModel dialogItemViewModel, ControlItemViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int off = dialogItemViewModel.toOff();
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setAncGestureData(itemViewModel, off, dialogItemViewModel);
        this.changeOperation = true;
    }
}
