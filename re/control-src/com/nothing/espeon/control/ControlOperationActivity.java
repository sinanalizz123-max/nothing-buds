package com.nothing.espeon.control;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.nothing.base.adapter.CommonBindingAdapter;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.view.BaseConfig;
import com.nothing.base.wiget.ActionView;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.EspeonControlOperationActivityBinding;
import com.nothing.earbase.control.BaseControlOperationActivity;
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
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0002J\b\u0010\u0017\u001a\u00020\bH\u0002J\b\u0010\u001a\u001a\u00020\bH\u0002J\u000e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0016\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020$J(\u0010%\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0002J\b\u0010,\u001a\u00020\u000fH\u0002J\u0016\u0010-\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020$J\u0016\u0010.\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020$J\u0016\u0010/\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020$R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/nothing/espeon/control/ControlOperationActivity;", "Lcom/nothing/earbase/control/BaseControlOperationActivity;", "Lcom/nothing/ear/databinding/EspeonControlOperationActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/espeon/control/ControlViewModel;", "isSelectLeft", "", "selectedOperation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "changeOperation", "getVoiceAssistantCount", "", "onBackPressedInner", "", "createContentConfig", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "isRight", "isLeft", "clickTime", "", "checkValid", "onClickLeft", "onClickRight", "refreshGestureData", "onClickChangeData", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "onSelectedOperation", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "Lcom/nothing/espeon/control/ControlItemViewModel;", "scaleSelectedView", "normalView", "Landroid/widget/ImageView;", "selectedView", "normalText", "Landroid/widget/TextView;", "selectedText", "setDefaultScaleSelected", "onClickTransparency", "onClickNoiseCancellation", "onClickOff", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlOperationActivity extends BaseControlOperationActivity<EspeonControlOperationActivityBinding> {
    public static final String CHANGE_OPERATION = "CHANGE_OPERATION";
    public static final String IS_LEFT_SELECTED = "IS_LEFT_SELECTED";
    public static final String SELECTED_OPERATION = "SELECTED_OPERATION";
    private boolean changeOperation;
    private long clickTime;
    private boolean isSelectLeft = true;
    private ControlConfigurationEntity.Operation selectedOperation;
    private ControlViewModel viewModel;

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
    @Override // com.nothing.base.view.BaseActivity
    public void onBackPressedInner() {
        ((EspeonControlOperationActivityBinding) getMBinding()).leftLottie.cancelAnimation();
        ((EspeonControlOperationActivityBinding) getMBinding()).rightLottie.cancelAnimation();
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
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.espeon_control_operation_activity);
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
        ((EspeonControlOperationActivityBinding) getMBinding()).rvOperation.setLayoutManager(new LinearLayoutManager(this));
        ((EspeonControlOperationActivityBinding) getMBinding()).setEventHandler(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isRight() {
        return ((EspeonControlOperationActivityBinding) getMBinding()).ivRight.getScaleX() == 1.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isLeft() {
        return ((EspeonControlOperationActivityBinding) getMBinding()).ivLeft.getScaleX() == 1.0f;
    }

    private final boolean checkValid() {
        if (System.currentTimeMillis() < this.clickTime + 700) {
            return false;
        }
        this.clickTime = System.currentTimeMillis();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onClickLeft(ControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (checkValid()) {
            this.isSelectLeft = true;
            viewModel.getLeftTextVisible().set(true);
            viewModel.getRightTextVisible().set(false);
            if (!isLeft()) {
                AppCompatImageView ivLeft = ((EspeonControlOperationActivityBinding) getMBinding()).ivLeft;
                Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
                AppCompatImageView ivRight = ((EspeonControlOperationActivityBinding) getMBinding()).ivRight;
                Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
                AppCompatTextView tvLeft = ((EspeonControlOperationActivityBinding) getMBinding()).tvLeft;
                Intrinsics.checkNotNullExpressionValue(tvLeft, "tvLeft");
                AppCompatTextView tvRight = ((EspeonControlOperationActivityBinding) getMBinding()).tvRight;
                Intrinsics.checkNotNullExpressionValue(tvRight, "tvRight");
                scaleSelectedView(ivLeft, ivRight, tvLeft, tvRight);
            }
            refreshGestureData(viewModel, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onClickRight(ControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (checkValid()) {
            this.isSelectLeft = false;
            viewModel.getLeftTextVisible().set(false);
            viewModel.getRightTextVisible().set(true);
            if (!isRight()) {
                AppCompatImageView ivRight = ((EspeonControlOperationActivityBinding) getMBinding()).ivRight;
                Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
                AppCompatImageView ivLeft = ((EspeonControlOperationActivityBinding) getMBinding()).ivLeft;
                Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
                AppCompatTextView tvRight = ((EspeonControlOperationActivityBinding) getMBinding()).tvRight;
                Intrinsics.checkNotNullExpressionValue(tvRight, "tvRight");
                AppCompatTextView tvLeft = ((EspeonControlOperationActivityBinding) getMBinding()).tvLeft;
                Intrinsics.checkNotNullExpressionValue(tvLeft, "tvLeft");
                scaleSelectedView(ivRight, ivLeft, tvRight, tvLeft);
            }
            refreshGestureData(viewModel, false);
        }
    }

    private final void refreshGestureData(ControlViewModel viewModel, boolean isLeft) {
        for (CommonBindingMoreType commonBindingMoreType : isLeft ? viewModel.getLeftGestureData() : viewModel.getRightGestureData()) {
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
        Iterator<ControlOperationViewModel> it = itemViewModel.getOperationList().iterator();
        while (it.hasNext()) {
            it.next().setSelectChatGpt(VoiceAssistantUtil.INSTANCE.isSelectChatGpt());
        }
        ((EspeonControlOperationActivityBinding) getMBinding()).rvOperation.setAdapter(new CommonBindingAdapter.Builder().setLayoutId(R.layout.espeon_control_dialog_item).setEventHandler((Object) this).addVariable(BR.itemViewModel, (Object) itemViewModel).setDataList((ObservableArrayList) itemViewModel.getOperationList()).build());
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.setSelectedItem(itemViewModel);
        ((EspeonControlOperationActivityBinding) getMBinding()).leftLottie.setVisibility(8);
        ((EspeonControlOperationActivityBinding) getMBinding()).leftLottie.cancelAnimation();
        ((EspeonControlOperationActivityBinding) getMBinding()).rightLottie.setVisibility(8);
        ((EspeonControlOperationActivityBinding) getMBinding()).rightLottie.cancelAnimation();
        if (Intrinsics.areEqual((Object) itemViewModel.isLeft().get(), (Object) true)) {
            ((EspeonControlOperationActivityBinding) getMBinding()).leftLottie.setVisibility(0);
            ((EspeonControlOperationActivityBinding) getMBinding()).leftLottie.postDelayed(new Runnable() { // from class: com.nothing.espeon.control.ControlOperationActivity$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    ControlOperationActivity.onClickChangeData$lambda$2(this.f$0, itemViewModel);
                }
            }, 500L);
        } else {
            ((EspeonControlOperationActivityBinding) getMBinding()).rightLottie.setVisibility(0);
            ((EspeonControlOperationActivityBinding) getMBinding()).rightLottie.postDelayed(new Runnable() { // from class: com.nothing.espeon.control.ControlOperationActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    ControlOperationActivity.onClickChangeData$lambda$3(this.f$0, itemViewModel);
                }
            }, 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onClickChangeData$lambda$2(ControlOperationActivity controlOperationActivity, ControlGestureViewModel controlGestureViewModel) {
        ((EspeonControlOperationActivityBinding) controlOperationActivity.getMBinding()).leftLottie.setAnimation(controlGestureViewModel.getLottieString().get());
        ((EspeonControlOperationActivityBinding) controlOperationActivity.getMBinding()).leftLottie.setRepeatCount(-1);
        ((EspeonControlOperationActivityBinding) controlOperationActivity.getMBinding()).leftLottie.playAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void onClickChangeData$lambda$3(ControlOperationActivity controlOperationActivity, ControlGestureViewModel controlGestureViewModel) {
        ((EspeonControlOperationActivityBinding) controlOperationActivity.getMBinding()).rightLottie.setAnimation(controlGestureViewModel.getLottieString().get());
        ((EspeonControlOperationActivityBinding) controlOperationActivity.getMBinding()).rightLottie.setRepeatCount(-1);
        ((EspeonControlOperationActivityBinding) controlOperationActivity.getMBinding()).rightLottie.playAnimation();
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

    private final void scaleSelectedView(ImageView normalView, ImageView selectedView, TextView normalText, TextView selectedText) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(normalView, "scaleX", 0.71f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(normalView, "scaleY", 0.71f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(normalView, "alpha", 0.5f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(selectedView, "scaleX", 1.0f, 0.71f);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(selectedView, "scaleY", 1.0f, 0.71f);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(selectedView, "alpha", 1.0f, 0.5f);
        ObjectAnimator objectAnimatorOfFloat7 = ObjectAnimator.ofFloat(normalText, "alpha", 0.38f, 1.0f);
        ObjectAnimator objectAnimatorOfFloat8 = ObjectAnimator.ofFloat(selectedText, "alpha", 1.0f, 0.38f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3, objectAnimatorOfFloat4, objectAnimatorOfFloat5, objectAnimatorOfFloat6, objectAnimatorOfFloat7, objectAnimatorOfFloat8);
        animatorSet.setDuration(200L);
        animatorSet.start();
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
        controlViewModel.getDataUpdate().observe(this, new ControlOperationActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.espeon.control.ControlOperationActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlOperationActivity.setDefaultScaleSelected$lambda$4(this.f$0, (Pair) obj);
            }
        }));
        if (this.isSelectLeft) {
            ((EspeonControlOperationActivityBinding) getMBinding()).ivLeft.setScaleX(1.0f);
            ((EspeonControlOperationActivityBinding) getMBinding()).ivLeft.setScaleY(1.0f);
            ((EspeonControlOperationActivityBinding) getMBinding()).ivRight.setAlpha(0.5f);
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
            return;
        }
        ((EspeonControlOperationActivityBinding) getMBinding()).ivRight.setScaleX(1.0f);
        ((EspeonControlOperationActivityBinding) getMBinding()).ivRight.setScaleY(1.0f);
        ((EspeonControlOperationActivityBinding) getMBinding()).ivLeft.setAlpha(0.5f);
        ControlViewModel controlViewModel5 = this.viewModel;
        if (controlViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel5 = null;
        }
        controlViewModel5.getLeftTextVisible().set(false);
        ControlViewModel controlViewModel6 = this.viewModel;
        if (controlViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel6;
        }
        controlViewModel2.getRightTextVisible().set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDefaultScaleSelected$lambda$4(ControlOperationActivity controlOperationActivity, Pair pair) {
        if (pair != null && ((Number) pair.getFirst()).intValue() == 1) {
            ControlViewModel controlViewModel = null;
            if (controlOperationActivity.isSelectLeft) {
                ControlViewModel controlViewModel2 = controlOperationActivity.viewModel;
                if (controlViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    controlViewModel = controlViewModel2;
                }
                controlOperationActivity.refreshGestureData(controlViewModel, true);
            } else {
                ControlViewModel controlViewModel3 = controlOperationActivity.viewModel;
                if (controlViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    controlViewModel = controlViewModel3;
                }
                controlOperationActivity.refreshGestureData(controlViewModel, false);
            }
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
