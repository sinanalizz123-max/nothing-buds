package com.nothing.ear.flaffy.control;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.core.util.Pair;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.nothing.base.adapter.CommonBindingMoreAdapter;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.animation.ActivityTransitionAnimation;
import com.nothing.base.dialog.confirm.ConfirmMsgDialog;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.recycleview.WrapContentLinearLayoutManager;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.view.ActionViewConfig;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.FlaffyControlActivityBinding;
import com.nothing.earbase.control.ControlAdapter;
import com.nothing.earbase.control.ControlGestureViewModel;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ControlActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 =2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0017J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001c\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001d0&H\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\u000e\u0010*\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010+\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010,\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u001dH\u0002J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/J\u0010\u00100\u001a\u00020\u00142\u0006\u0010.\u001a\u000201H\u0002J(\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000207H\u0002J\b\u00109\u001a\u00020\u0014H\u0002J\b\u0010:\u001a\u00020\u0014H\u0014J\u0010\u0010;\u001a\u00020\u00142\u0006\u0010<\u001a\u00020#H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/nothing/ear/flaffy/control/ControlActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/FlaffyControlActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/ear/flaffy/control/ControlViewModel;", "adapter", "Lcom/nothing/earbase/control/ControlAdapter;", "resetDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "resetString", "", "getResetString", "()Ljava/lang/String;", "resetString$delegate", "Lkotlin/Lazy;", "clickTime", "", "beforeOnSuperCreate", "", "onInitStatusBar", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "createActionViewConfig", "contentConfig", "Lcom/nothing/base/view/ActionViewConfig;", "rightLabelClickEvent", "checkValid", "", "onBackPressedInner", "createContentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "showRightLabel", "pair", "Lkotlin/Pair;", "", "isRight", "isLeft", "onClickLeft", "onClickRight", "refreshGestureData", "onClickItem", "itemViewModel", "Lcom/nothing/ear/flaffy/control/ControlItemViewModel;", "onClickChangeData", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "scaleSelectedView", "normalView", "Landroid/widget/ImageView;", "selectedView", "normalText", "Landroid/widget/TextView;", "selectedText", "setDefaultScaleSelected", "onStop", "onSaveInstanceState", "outState", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlActivity extends BaseActivity<FlaffyControlActivityBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IS_LEFT_SELECTED = "IS_LEFT_SELECTED";
    private static final String LEFT_EAR_IMAGE = "left_ear_image";
    private static final String RIGHT_EAR_IMAGE = "right_ear_image";
    private ControlAdapter adapter;
    private long clickTime;
    private ConfirmMsgDialog resetDialog;

    /* JADX INFO: renamed from: resetString$delegate, reason: from kotlin metadata */
    private final Lazy resetString = LazyKt.lazy(new Function0() { // from class: com.nothing.ear.flaffy.control.ControlActivity$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ControlActivity.resetString_delegate$lambda$0(this.f$0);
        }
    });
    private ControlViewModel viewModel;

    private final String getResetString() {
        return (String) this.resetString.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resetString_delegate$lambda$0(ControlActivity controlActivity) {
        return ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.control_reset_controls);
    }

    /* JADX INFO: compiled from: ControlActivity.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J(\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/ear/flaffy/control/ControlActivity$Companion;", "", "<init>", "()V", "IS_LEFT_SELECTED", "", "LEFT_EAR_IMAGE", "RIGHT_EAR_IMAGE", "start", "", "context", "Landroid/app/Activity;", "leftView", "Landroid/view/View;", "rightView", "isLeft", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Activity context, View leftView, View rightView, boolean isLeft) {
            Intrinsics.checkNotNullParameter(leftView, "leftView");
            Intrinsics.checkNotNullParameter(rightView, "rightView");
            if (context != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("IS_LEFT_SELECTED", isLeft);
                ActivityTransitionAnimation.startActivityWithAnimation$default(ActivityTransitionAnimation.INSTANCE, context, ControlActivity.class, bundle, new Pair[]{new Pair(leftView, ControlActivity.LEFT_EAR_IMAGE), new Pair(rightView, ControlActivity.RIGHT_EAR_IMAGE)}, false, 16, null);
            }
        }
    }

    @Override // com.nothing.base.view.BaseActivity
    public void beforeOnSuperCreate() {
        super.beforeOnSuperCreate();
        ActivityTransitionAnimation activityTransitionAnimation = ActivityTransitionAnimation.INSTANCE;
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        ActivityTransitionAnimation.beforeOnSuperCreate$default(activityTransitionAnimation, window, null, null, 6, null);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitStatusBar(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        FrameLayout frameLayout = rootBinding.rootView;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        frameLayout.setPadding(0, ContextExtKt.getStatusBarHeight(resources), 0, 0);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createActionViewConfig(ActionViewConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createActionViewConfig(contentConfig);
        contentConfig.setSubTitle(getString(R.string.controls));
    }

    @Override // com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
        CharSequence text = getActionBarBinding().headerBar.getRightLabel().getText();
        String lowerCase = getResetString().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(text, DataExtKt.firstUpper(lowerCase))) {
            ConfirmMsgViewModel confirmMsgViewModel = new ConfirmMsgViewModel();
            ControlActivity controlActivity = this;
            confirmMsgViewModel.getMsg().set(ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.control_reset_title));
            confirmMsgViewModel.getTitle().set(ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.warning));
            ObservableField<String> positionBtn = confirmMsgViewModel.getPositionBtn();
            String string = ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.control_reset_controls);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String lowerCase2 = string.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            positionBtn.set(DataExtKt.firstUpper(lowerCase2));
            confirmMsgViewModel.getNegativeBtn().set(ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.cancel));
            ConfirmMsgDialog confirmMsgDialog = this.resetDialog;
            if (confirmMsgDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetDialog");
                confirmMsgDialog = null;
            }
            confirmMsgDialog.show(this, confirmMsgViewModel, new Function0() { // from class: com.nothing.ear.flaffy.control.ControlActivity$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ControlActivity.rightLabelClickEvent$lambda$1(this.f$0);
                }
            }, new Function0() { // from class: com.nothing.ear.flaffy.control.ControlActivity$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rightLabelClickEvent$lambda$1(ControlActivity controlActivity) {
        ControlViewModel controlViewModel = controlActivity.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.resetGestureData();
        return Unit.INSTANCE;
    }

    private final boolean checkValid() {
        if (System.currentTimeMillis() < this.clickTime + 700) {
            return false;
        }
        this.clickTime = System.currentTimeMillis();
        return true;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onBackPressedInner() {
        getMBinding().rvControl.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
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
        this.resetDialog = new ConfirmMsgDialog();
        this.adapter = new ControlAdapter(new CommonBindingMoreAdapter.Builder().addViewType(1, new CommonBindingMoreAdapter.Builder.ItemBuilder().setEventHandler((Object) this)).addViewType(2).addViewType(5).addLayoutView(1, R.layout.flaffy_control_item).addLayoutView(5, R.layout.empty_bottom_view).addLayoutView(2, R.layout.control_not_customisable_view), this);
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.flaffy_control_activity);
        int i = BR.viewModel;
        ControlViewModel controlViewModel3 = this.viewModel;
        if (controlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel3;
        }
        layoutId.addVariable(i, controlViewModel2).addVariable(BR.eventHandler, this);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        setDefaultScaleSelected();
        getMBinding().ivLeft.setTransitionName(LEFT_EAR_IMAGE);
        getMBinding().ivRight.setTransitionName(RIGHT_EAR_IMAGE);
        getMBinding().rvControl.setLayoutManager(new WrapContentLinearLayoutManager(this));
        RecyclerView recyclerView = getMBinding().rvControl;
        ControlAdapter controlAdapter = this.adapter;
        if (controlAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            controlAdapter = null;
        }
        recyclerView.setAdapter(controlAdapter);
        getMBinding().setEventHandler(this);
    }

    private final void showRightLabel(kotlin.Pair<Integer, Boolean> pair) {
        if (pair.getSecond().booleanValue()) {
            TextView rightLabel = getActionBarBinding().headerBar.getRightLabel();
            String lowerCase = getResetString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            rightLabel.setText(DataExtKt.firstUpper(lowerCase));
            return;
        }
        getActionBarBinding().headerBar.getRightLabel().setText("");
    }

    private final boolean isRight() {
        return getMBinding().ivRight.getScaleX() == 1.0f;
    }

    private final boolean isLeft() {
        return getMBinding().ivLeft.getScaleX() == 1.0f;
    }

    public final void onClickLeft(ControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (checkValid()) {
            viewModel.getLeftTextVisible().set(true);
            viewModel.getRightTextVisible().set(false);
            if (!isLeft()) {
                AppCompatImageView ivLeft = getMBinding().ivLeft;
                Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
                AppCompatImageView ivRight = getMBinding().ivRight;
                Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
                AppCompatTextView tvLeft = getMBinding().tvLeft;
                Intrinsics.checkNotNullExpressionValue(tvLeft, "tvLeft");
                AppCompatTextView tvRight = getMBinding().tvRight;
                Intrinsics.checkNotNullExpressionValue(tvRight, "tvRight");
                scaleSelectedView(ivLeft, ivRight, tvLeft, tvRight);
            }
            refreshGestureData(viewModel, true);
        }
    }

    public final void onClickRight(ControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (checkValid()) {
            viewModel.getLeftTextVisible().set(false);
            viewModel.getRightTextVisible().set(true);
            if (!isRight()) {
                AppCompatImageView ivRight = getMBinding().ivRight;
                Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
                AppCompatImageView ivLeft = getMBinding().ivLeft;
                Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
                AppCompatTextView tvRight = getMBinding().tvRight;
                Intrinsics.checkNotNullExpressionValue(tvRight, "tvRight");
                AppCompatTextView tvLeft = getMBinding().tvLeft;
                Intrinsics.checkNotNullExpressionValue(tvLeft, "tvLeft");
                scaleSelectedView(ivRight, ivLeft, tvRight, tvLeft);
            }
            refreshGestureData(viewModel, false);
        }
    }

    private final void refreshGestureData(ControlViewModel viewModel, boolean isLeft) {
        ObservableField<String> gestureName;
        ObservableArrayList<CommonBindingMoreType> leftGestureData = isLeft ? viewModel.getLeftGestureData() : viewModel.getRightGestureData();
        ControlAdapter controlAdapter = this.adapter;
        if (controlAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            controlAdapter = null;
        }
        controlAdapter.refreshData(leftGestureData);
        for (CommonBindingMoreType commonBindingMoreType : leftGestureData) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                ControlGestureViewModel controlGestureViewModel = (ControlGestureViewModel) commonBindingMoreType;
                String str = controlGestureViewModel.getGestureName().get();
                ControlGestureViewModel controlGestureViewModel2 = viewModel.getSelectedItemViewModel().get();
                if (Intrinsics.areEqual(str, (controlGestureViewModel2 == null || (gestureName = controlGestureViewModel2.getGestureName()) == null) ? null : gestureName.get())) {
                    onClickChangeData(controlGestureViewModel);
                }
            }
        }
    }

    public final void onClickItem(ControlItemViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        onClickChangeData(itemViewModel);
    }

    private final void onClickChangeData(ControlGestureViewModel itemViewModel) {
        Intent intent = new Intent(this, (Class<?>) ControlOperationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_LEFT_SELECTED", isLeft());
        bundle.putParcelable("SELECTED_OPERATION", itemViewModel.getOptions());
        intent.putExtras(bundle);
        getResultLauncher().launcher(intent, new Function1() { // from class: com.nothing.ear.flaffy.control.ControlActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlActivity.onClickChangeData$lambda$4(this.f$0, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickChangeData$lambda$4(ControlActivity controlActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1) {
            Intent data = it.getData();
            ControlViewModel controlViewModel = null;
            if (Intrinsics.areEqual((Object) (data != null ? Boolean.valueOf(data.getBooleanExtra("CHANGE_OPERATION", false)) : null), (Object) true)) {
                ControlViewModel controlViewModel2 = controlActivity.viewModel;
                if (controlViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    controlViewModel = controlViewModel2;
                }
                controlViewModel.getGestureData(true);
            }
        }
        return Unit.INSTANCE;
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

    private final void setDefaultScaleSelected() {
        Bundle extras = getIntent().getExtras();
        ControlViewModel controlViewModel = null;
        if (extras != null ? extras.getBoolean("IS_LEFT_SELECTED") : true) {
            getMBinding().ivLeft.setScaleX(1.0f);
            getMBinding().ivLeft.setScaleY(1.0f);
            getMBinding().ivRight.setAlpha(0.5f);
            ControlViewModel controlViewModel2 = this.viewModel;
            if (controlViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel2 = null;
            }
            controlViewModel2.getLeftTextVisible().set(true);
            ControlViewModel controlViewModel3 = this.viewModel;
            if (controlViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel3 = null;
            }
            controlViewModel3.getRightTextVisible().set(false);
        } else {
            getMBinding().ivRight.setScaleX(1.0f);
            getMBinding().ivRight.setScaleY(1.0f);
            getMBinding().ivLeft.setAlpha(0.5f);
            ControlViewModel controlViewModel4 = this.viewModel;
            if (controlViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel4 = null;
            }
            controlViewModel4.getLeftTextVisible().set(false);
            ControlViewModel controlViewModel5 = this.viewModel;
            if (controlViewModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel5 = null;
            }
            controlViewModel5.getRightTextVisible().set(true);
        }
        ControlViewModel controlViewModel6 = this.viewModel;
        if (controlViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel = controlViewModel6;
        }
        controlViewModel.getDataUpdate().observe(this, new ControlActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.ear.flaffy.control.ControlActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlActivity.setDefaultScaleSelected$lambda$6(this.f$0, (kotlin.Pair) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDefaultScaleSelected$lambda$6(final ControlActivity controlActivity, kotlin.Pair pair) {
        if (pair != null) {
            if (((Number) pair.getFirst()).intValue() == 1) {
                ControlViewModel controlViewModel = controlActivity.viewModel;
                if (controlViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    controlViewModel = null;
                }
                controlActivity.refreshGestureData(controlViewModel, controlActivity.isLeft());
                controlActivity.getMBinding().rvControl.postDelayed(new Runnable() { // from class: com.nothing.ear.flaffy.control.ControlActivity$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ControlActivity.setDefaultScaleSelected$lambda$6$lambda$5(this.f$0);
                    }
                }, 1000L);
            }
            controlActivity.showRightLabel(pair);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDefaultScaleSelected$lambda$6$lambda$5(ControlActivity controlActivity) {
        ObservableArrayList<CommonBindingMoreType> rightGestureData;
        ControlAdapter controlAdapter = null;
        if (controlActivity.isLeft()) {
            ControlViewModel controlViewModel = controlActivity.viewModel;
            if (controlViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel = null;
            }
            rightGestureData = controlViewModel.getLeftGestureData();
        } else {
            ControlViewModel controlViewModel2 = controlActivity.viewModel;
            if (controlViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                controlViewModel2 = null;
            }
            rightGestureData = controlViewModel2.getRightGestureData();
        }
        ControlAdapter controlAdapter2 = controlActivity.adapter;
        if (controlAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            controlAdapter = controlAdapter2;
        }
        controlAdapter.refreshData(rightGestureData);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        ActivityTransitionAnimation.INSTANCE.onStop(this);
        super.onStop();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        ActivityTransitionAnimation.INSTANCE.onSaveInstanceState(outState, new Function0() { // from class: com.nothing.ear.flaffy.control.ControlActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
    }
}
