package com.nothing.espeon.control;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
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
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.view.ActionViewConfig;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.EspeonControlActivityBinding;
import com.nothing.earbase.control.ControlAdapter;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.log.FileLog;
import com.nothing.log.NTLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\u0018\u0000 K2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001KB\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0010H\u0016J\b\u0010\u0017\u001a\u00020\u0010H\u0016J\b\u0010\u0018\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016J\u001c\u0010\u001f\u001a\u00020\u00102\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\"0!H\u0002J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010$\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010%\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u000eH\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u000e\u00102\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u000e\u00105\u001a\b\u0012\u0004\u0012\u00020100H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020100H\u0002J&\u00107\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;H\u0002J \u0010=\u001a\u0002012\u0006\u00108\u001a\u0002092\u0006\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020;H\u0002J \u0010@\u001a\u0002012\u0006\u00108\u001a\u0002092\u0006\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020;H\u0002J\b\u0010C\u001a\u00020\u0010H\u0002J\b\u0010D\u001a\u00020\u0010H\u0002J\b\u0010E\u001a\u00020\u0010H\u0002J\u0010\u0010F\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\"H\u0002J\b\u0010G\u001a\u00020\u0010H\u0014J\u0010\u0010H\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u001dH\u0014J\b\u0010J\u001a\u00020\u0010H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/nothing/espeon/control/ControlActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/EspeonControlActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/espeon/control/ControlViewModel;", "adapter", "Lcom/nothing/earbase/control/ControlAdapter;", "resetDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "resetString", "", "currentSelectType", "", "onInitStatusBar", "", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "createActionViewConfig", "contentConfig", "Lcom/nothing/base/view/ActionViewConfig;", "beforeOnSuperCreate", "rightLabelClickEvent", "onBackPressedInner", "createContentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "afterOnSuperCreate", "showRightLabel", "pair", "Lkotlin/Pair;", "", "onClickLeft", "onClickRight", "onClickCase", "refreshGestureData", "isLeft", "refreshCaseGestureData", "onClickItem", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "onClickChangeData", "scaleSelectedView", "clickType", "leftToRightAnimal", "", "Landroid/animation/ObjectAnimator;", "rightToLeftAnimal", "caseToRightAnimal", "caseToLeftAnimal", "rightToCaseAnimal", "leftToCaseAnimal", "getViewScale", "targetView", "Landroid/view/View;", "scaleStart", "", "scaleEnd", "getAlphaAnimator", "alphaStart", "alphaEnd", "getTranslationXAnimator", "translationStart", "translationEnd", "setDefaultScaleSelected", "setCaseSelected", "setCaseMove", "setEarMove", "onStop", "onSaveInstanceState", "outState", "onDestroy", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlActivity extends BaseActivity<EspeonControlActivityBinding> {
    private static final String CASE_IMAGE = "case_image";
    private static final int CASE_SELECTED = 2;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IS_CASE_SELECTED = "IS_CASE_SELECTED";
    public static final String IS_LEFT_SELECTED = "IS_LEFT_SELECTED";
    private static final String LEFT_EAR_IMAGE = "left_ear_image";
    private static final int LEFT_SELECTED = 0;
    private static final String RIGHT_EAR_IMAGE = "right_ear_image";
    private static final int RIGHT_SELECTED = 1;
    private static final float SCALE_ALPHA_NORMAL = 0.5f;
    private static final float SCALE_ALPHA_SELECTED = 1.0f;
    private static final long SCALE_ANIMAL_TIME = 200;
    private static final float SCALE_NORMAL_CASE = 0.6f;
    private static final float SCALE_NORMAL_EAR = 0.8f;
    private static final float SCALE_SELECTED = 1.0f;
    private static final float SCALE_SMALL_EAR = 0.7f;
    private static final long TRANSITION_DURATION = 500;
    private static final float TRANSLATION_CASE_X = 32.0f;
    private static final float TRANSLATION_EAR_X = 9.0f;
    private static final float TRANSLATION_SMALL_EAR_X = 14.0f;
    private static final float TRANSLATION_SMALL_RIGHT_X = 26.0f;
    private ControlAdapter adapter;
    private int currentSelectType;
    private ConfirmMsgDialog resetDialog;
    private String resetString = "";
    private ControlViewModel viewModel;

    /* JADX INFO: compiled from: ControlActivity.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020%J(\u0010&\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/nothing/espeon/control/ControlActivity$Companion;", "", "<init>", "()V", "IS_LEFT_SELECTED", "", ControlActivity.IS_CASE_SELECTED, "LEFT_EAR_IMAGE", "RIGHT_EAR_IMAGE", "CASE_IMAGE", "SCALE_NORMAL_CASE", "", "TRANSITION_DURATION", "", "SCALE_ALPHA_NORMAL", "SCALE_ALPHA_SELECTED", "TRANSLATION_EAR_X", "TRANSLATION_SMALL_EAR_X", "TRANSLATION_SMALL_RIGHT_X", "TRANSLATION_CASE_X", "SCALE_ANIMAL_TIME", "SCALE_SMALL_EAR", "SCALE_NORMAL_EAR", "SCALE_SELECTED", "LEFT_SELECTED", "", "RIGHT_SELECTED", "CASE_SELECTED", "start", "", "context", "Landroid/app/Activity;", "leftView", "Landroid/view/View;", "rightView", "caseView", "isLeft", "", "startCase", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Activity context, View leftView, View rightView, View caseView, boolean isLeft) {
            Intrinsics.checkNotNullParameter(leftView, "leftView");
            Intrinsics.checkNotNullParameter(rightView, "rightView");
            Intrinsics.checkNotNullParameter(caseView, "caseView");
            if (context != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("IS_LEFT_SELECTED", isLeft);
                ActivityTransitionAnimation.startActivityWithAnimation$default(ActivityTransitionAnimation.INSTANCE, context, ControlActivity.class, bundle, new Pair[]{new Pair(leftView, ControlActivity.LEFT_EAR_IMAGE), new Pair(rightView, ControlActivity.RIGHT_EAR_IMAGE), new Pair(caseView, ControlActivity.CASE_IMAGE)}, false, 16, null);
            }
        }

        public final void startCase(Activity context, View leftView, View rightView, View caseView) {
            Intrinsics.checkNotNullParameter(leftView, "leftView");
            Intrinsics.checkNotNullParameter(rightView, "rightView");
            Intrinsics.checkNotNullParameter(caseView, "caseView");
            if (context != null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "smart_dial startCase".length() != 0) {
                    kotlin.Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "smart_dial startCase " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "smart_dial startCase " + strComponent2);
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(ControlActivity.IS_CASE_SELECTED, true);
                ActivityTransitionAnimation.startActivityWithAnimation$default(ActivityTransitionAnimation.INSTANCE, context, ControlActivity.class, bundle, new Pair[]{new Pair(leftView, ControlActivity.LEFT_EAR_IMAGE), new Pair(rightView, ControlActivity.RIGHT_EAR_IMAGE), new Pair(caseView, ControlActivity.CASE_IMAGE)}, false, 16, null);
            }
        }
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
    public void beforeOnSuperCreate() {
        super.beforeOnSuperCreate();
        ActivityTransitionAnimation activityTransitionAnimation = ActivityTransitionAnimation.INSTANCE;
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        ActivityTransitionAnimation.beforeOnSuperCreate$default(activityTransitionAnimation, window, null, null, 6, null);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
        CharSequence text = getActionBarBinding().headerBar.getRightLabel().getText();
        String lowerCase = this.resetString.toLowerCase(Locale.ROOT);
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
            confirmMsgDialog.show(this, confirmMsgViewModel, new Function0() { // from class: com.nothing.espeon.control.ControlActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ControlActivity.rightLabelClickEvent$lambda$0(this.f$0);
                }
            }, new Function0() { // from class: com.nothing.espeon.control.ControlActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rightLabelClickEvent$lambda$0(ControlActivity controlActivity) {
        ControlViewModel controlViewModel = controlActivity.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.resetGestureData();
        return Unit.INSTANCE;
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
        this.adapter = new ControlAdapter(new CommonBindingMoreAdapter.Builder().addViewType(1, new CommonBindingMoreAdapter.Builder.ItemBuilder().setEventHandler((Object) this)).addViewType(2).addLayoutView(1, R.layout.espeon_control_item).addViewType(5).addLayoutView(5, R.layout.empty_bottom_view).addLayoutView(2, R.layout.control_not_customisable_view).addLayoutView(5, R.layout.empty_bottom_view), this);
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.espeon_control_activity);
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
        GooglePlayScoreUtil.INSTANCE.startControl();
        Bundle extras = getIntent().getExtras();
        if (extras != null ? extras.getBoolean(IS_CASE_SELECTED) : false) {
            setCaseSelected();
        } else {
            setDefaultScaleSelected();
        }
        ControlViewModel controlViewModel = this.viewModel;
        ControlViewModel controlViewModel2 = null;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.getDataUpdate().observe(this, new ControlActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.espeon.control.ControlActivity$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlActivity.onInit$lambda$3(this.f$0, (kotlin.Pair) obj);
            }
        }));
        getMBinding().setEventHandler(this);
        getMBinding().rvControl.setLayoutManager(new WrapContentLinearLayoutManager(this));
        RecyclerView recyclerView = getMBinding().rvControl;
        ControlAdapter controlAdapter = this.adapter;
        if (controlAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            controlAdapter = null;
        }
        recyclerView.setAdapter(controlAdapter);
        ControlViewModel controlViewModel3 = this.viewModel;
        if (controlViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            controlViewModel2 = controlViewModel3;
        }
        controlViewModel2.getRightTextVisible().set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInit$lambda$3(ControlActivity controlActivity, kotlin.Pair pair) {
        ControlViewModel controlViewModel;
        if (pair != null) {
            if (((Number) pair.getFirst()).intValue() == 1) {
                if (controlActivity.currentSelectType == 2) {
                    ControlViewModel controlViewModel2 = controlActivity.viewModel;
                    if (controlViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        controlViewModel2 = null;
                    }
                    controlActivity.refreshCaseGestureData(controlViewModel2);
                } else {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "dataUpdate \uff1a" + (controlActivity.getMBinding().ivLeft.getAlpha() == 1.0f);
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            kotlin.Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    ControlViewModel controlViewModel3 = controlActivity.viewModel;
                    if (controlViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        controlViewModel3 = null;
                    }
                    controlActivity.refreshGestureData(controlViewModel3, controlActivity.currentSelectType == 0);
                }
            }
            if (((Number) pair.getFirst()).intValue() == 4 && controlActivity.currentSelectType == 2) {
                ControlViewModel controlViewModel4 = controlActivity.viewModel;
                if (controlViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    controlViewModel = null;
                } else {
                    controlViewModel = controlViewModel4;
                }
                controlActivity.refreshCaseGestureData(controlViewModel);
            }
            controlActivity.showRightLabel(pair);
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void afterOnSuperCreate() {
        Object objM6347constructorimpl;
        super.afterOnSuperCreate();
        try {
            Result.Companion companion = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(getString(R.string.control_reset_controls));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m6350exceptionOrNullimpl(objM6347constructorimpl) != null) {
            objM6347constructorimpl = "";
        }
        this.resetString = (String) objM6347constructorimpl;
    }

    private final void showRightLabel(kotlin.Pair<Integer, Boolean> pair) {
        if (pair.getSecond().booleanValue()) {
            TextView rightLabel = getActionBarBinding().headerBar.getRightLabel();
            String lowerCase = this.resetString.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            rightLabel.setText(DataExtKt.firstUpper(lowerCase));
            return;
        }
        getActionBarBinding().headerBar.getRightLabel().setText("");
    }

    public final void onClickLeft(ControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        scaleSelectedView(0);
        getMBinding().tvRight.setText(getString(R.string.control_left));
        refreshGestureData(viewModel, true);
    }

    public final void onClickRight(ControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        scaleSelectedView(1);
        getMBinding().tvRight.setText(getString(R.string.control_right));
        refreshGestureData(viewModel, false);
    }

    public final void onClickCase(ControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        scaleSelectedView(2);
        getMBinding().tvRight.setText(getString(R.string.knob));
        refreshCaseGestureData(viewModel);
    }

    private final void refreshGestureData(ControlViewModel viewModel, boolean isLeft) {
        ObservableField<String> gestureName;
        ObservableArrayList<CommonBindingMoreType> leftGestureData = isLeft ? viewModel.getLeftGestureData() : viewModel.getRightGestureData();
        NTLog.d("setDefaultScaleSelected refreshGestureData isLeft:" + isLeft);
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

    private final void refreshCaseGestureData(ControlViewModel viewModel) {
        ObservableArrayList<CommonBindingMoreType> caseGestureData = viewModel.getCaseGestureData();
        ControlAdapter controlAdapter = this.adapter;
        if (controlAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            controlAdapter = null;
        }
        controlAdapter.refreshNoAnimalData(caseGestureData);
    }

    public final void onClickItem(ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        onClickChangeData(itemViewModel);
    }

    private final void onClickChangeData(ControlGestureViewModel itemViewModel) {
        Intent intent = new Intent();
        if (Intrinsics.areEqual((Object) itemViewModel.isCase().get(), (Object) true)) {
            intent.setClass(this, ControlCaseOperationActivity.class);
        } else {
            intent.setClass(this, ControlOperationActivity.class);
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("IS_LEFT_SELECTED", this.currentSelectType == 0);
        bundle.putParcelable("SELECTED_OPERATION", itemViewModel.getOptions());
        intent.putExtras(bundle);
        getResultLauncher().launcher(intent, new Function1() { // from class: com.nothing.espeon.control.ControlActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlActivity.onClickChangeData$lambda$7(this.f$0, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickChangeData$lambda$7(ControlActivity controlActivity, ActivityResult it) {
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

    private final void scaleSelectedView(int clickType) {
        int i = this.currentSelectType;
        if (clickType == i) {
            return;
        }
        this.currentSelectType = clickType;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "control_animal currentSelectType:" + this.currentSelectType + ",lastSelect:" + i;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                kotlin.Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        int i2 = this.currentSelectType;
        if (i2 == 2 || i == 2) {
            if (i == 0) {
                arrayList.addAll(leftToCaseAnimal());
            } else if (i == 1) {
                arrayList.addAll(rightToCaseAnimal());
            } else if (i2 == 0) {
                arrayList.addAll(caseToLeftAnimal());
            } else {
                arrayList.addAll(caseToRightAnimal());
            }
        } else if (i2 == 0) {
            arrayList.addAll(rightToLeftAnimal());
        } else {
            arrayList.addAll(leftToRightAnimal());
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setDuration(200L);
        animatorSet.start();
    }

    private final List<ObjectAnimator> leftToRightAnimal() {
        ArrayList arrayList = new ArrayList();
        AppCompatImageView ivLeft = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
        List<ObjectAnimator> viewScale = getViewScale(ivLeft, 1.0f, 0.8f);
        AppCompatImageView ivLeft2 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft2, "ivLeft");
        ObjectAnimator alphaAnimator = getAlphaAnimator(ivLeft2, 1.0f, 0.5f);
        AppCompatImageView ivLeft3 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft3, "ivLeft");
        ControlActivity controlActivity = this;
        ObjectAnimator translationXAnimator = getTranslationXAnimator(ivLeft3, 0.0f, -ContextExtKt.dp2px(controlActivity, TRANSLATION_EAR_X));
        arrayList.addAll(viewScale);
        arrayList.add(alphaAnimator);
        arrayList.add(translationXAnimator);
        AppCompatImageView ivRight = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
        List<ObjectAnimator> viewScale2 = getViewScale(ivRight, 0.8f, 1.0f);
        AppCompatImageView ivRight2 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight2, "ivRight");
        ObjectAnimator alphaAnimator2 = getAlphaAnimator(ivRight2, 0.5f, 1.0f);
        AppCompatImageView ivRight3 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight3, "ivRight");
        ObjectAnimator translationXAnimator2 = getTranslationXAnimator(ivRight3, ContextExtKt.dp2px(controlActivity, TRANSLATION_EAR_X), 0.0f);
        arrayList.addAll(viewScale2);
        arrayList.add(alphaAnimator2);
        arrayList.add(translationXAnimator2);
        return arrayList;
    }

    private final List<ObjectAnimator> rightToLeftAnimal() {
        ArrayList arrayList = new ArrayList();
        AppCompatImageView ivLeft = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
        List<ObjectAnimator> viewScale = getViewScale(ivLeft, 0.8f, 1.0f);
        AppCompatImageView ivLeft2 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft2, "ivLeft");
        ObjectAnimator alphaAnimator = getAlphaAnimator(ivLeft2, 0.5f, 1.0f);
        AppCompatImageView ivLeft3 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft3, "ivLeft");
        ControlActivity controlActivity = this;
        ObjectAnimator translationXAnimator = getTranslationXAnimator(ivLeft3, -ContextExtKt.dp2px(controlActivity, TRANSLATION_EAR_X), 0.0f);
        arrayList.addAll(viewScale);
        arrayList.add(alphaAnimator);
        arrayList.add(translationXAnimator);
        AppCompatImageView ivRight = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
        List<ObjectAnimator> viewScale2 = getViewScale(ivRight, 1.0f, 0.8f);
        AppCompatImageView ivRight2 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight2, "ivRight");
        ObjectAnimator alphaAnimator2 = getAlphaAnimator(ivRight2, 1.0f, 0.5f);
        AppCompatImageView ivRight3 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight3, "ivRight");
        ObjectAnimator translationXAnimator2 = getTranslationXAnimator(ivRight3, 0.0f, ContextExtKt.dp2px(controlActivity, TRANSLATION_EAR_X));
        arrayList.addAll(viewScale2);
        arrayList.add(alphaAnimator2);
        arrayList.add(translationXAnimator2);
        return arrayList;
    }

    private final List<ObjectAnimator> caseToRightAnimal() {
        ArrayList arrayList = new ArrayList();
        AppCompatImageView ivLeft = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
        List<ObjectAnimator> viewScale = getViewScale(ivLeft, 0.7f, 0.8f);
        AppCompatImageView ivLeft2 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft2, "ivLeft");
        ObjectAnimator alphaAnimator = getAlphaAnimator(ivLeft2, 0.5f, 0.5f);
        AppCompatImageView ivLeft3 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft3, "ivLeft");
        ControlActivity controlActivity = this;
        ObjectAnimator translationXAnimator = getTranslationXAnimator(ivLeft3, -ContextExtKt.dp2px(controlActivity, 14.0f), -ContextExtKt.dp2px(controlActivity, TRANSLATION_EAR_X));
        arrayList.addAll(viewScale);
        arrayList.add(alphaAnimator);
        arrayList.add(translationXAnimator);
        AppCompatImageView ivRight = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
        List<ObjectAnimator> viewScale2 = getViewScale(ivRight, 0.7f, 1.0f);
        AppCompatImageView ivRight2 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight2, "ivRight");
        ObjectAnimator alphaAnimator2 = getAlphaAnimator(ivRight2, 0.5f, 1.0f);
        AppCompatImageView ivRight3 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight3, "ivRight");
        ObjectAnimator translationXAnimator2 = getTranslationXAnimator(ivRight3, -ContextExtKt.dp2px(controlActivity, 26.0f), 0.0f);
        arrayList.addAll(viewScale2);
        arrayList.add(alphaAnimator2);
        arrayList.add(translationXAnimator2);
        ImageView caseImage = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage, "caseImage");
        List<ObjectAnimator> viewScale3 = getViewScale(caseImage, 1.0f, 0.6f);
        ImageView caseImage2 = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage2, "caseImage");
        ObjectAnimator alphaAnimator3 = getAlphaAnimator(caseImage2, 1.0f, 0.5f);
        ImageView caseImage3 = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage3, "caseImage");
        ObjectAnimator translationXAnimator3 = getTranslationXAnimator(caseImage3, 0.0f, ContextExtKt.dp2px(controlActivity, 32.0f));
        arrayList.addAll(viewScale3);
        arrayList.add(alphaAnimator3);
        arrayList.add(translationXAnimator3);
        return arrayList;
    }

    private final List<ObjectAnimator> caseToLeftAnimal() {
        ArrayList arrayList = new ArrayList();
        AppCompatImageView ivLeft = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
        List<ObjectAnimator> viewScale = getViewScale(ivLeft, 0.7f, 1.0f);
        AppCompatImageView ivLeft2 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft2, "ivLeft");
        ObjectAnimator alphaAnimator = getAlphaAnimator(ivLeft2, 0.5f, 1.0f);
        AppCompatImageView ivLeft3 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft3, "ivLeft");
        ControlActivity controlActivity = this;
        ObjectAnimator translationXAnimator = getTranslationXAnimator(ivLeft3, -ContextExtKt.dp2px(controlActivity, 14.0f), 0.0f);
        arrayList.addAll(viewScale);
        arrayList.add(alphaAnimator);
        arrayList.add(translationXAnimator);
        AppCompatImageView ivRight = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
        List<ObjectAnimator> viewScale2 = getViewScale(ivRight, 0.7f, 0.8f);
        AppCompatImageView ivRight2 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight2, "ivRight");
        ObjectAnimator alphaAnimator2 = getAlphaAnimator(ivRight2, 0.5f, 0.5f);
        AppCompatImageView ivRight3 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight3, "ivRight");
        ObjectAnimator translationXAnimator2 = getTranslationXAnimator(ivRight3, -ContextExtKt.dp2px(controlActivity, 26.0f), ContextExtKt.dp2px(controlActivity, TRANSLATION_EAR_X));
        arrayList.addAll(viewScale2);
        arrayList.add(alphaAnimator2);
        arrayList.add(translationXAnimator2);
        ImageView caseImage = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage, "caseImage");
        List<ObjectAnimator> viewScale3 = getViewScale(caseImage, 1.0f, 0.6f);
        ImageView caseImage2 = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage2, "caseImage");
        ObjectAnimator alphaAnimator3 = getAlphaAnimator(caseImage2, 1.0f, 0.5f);
        ImageView caseImage3 = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage3, "caseImage");
        ObjectAnimator translationXAnimator3 = getTranslationXAnimator(caseImage3, 0.0f, ContextExtKt.dp2px(controlActivity, 32.0f));
        arrayList.addAll(viewScale3);
        arrayList.add(alphaAnimator3);
        arrayList.add(translationXAnimator3);
        return arrayList;
    }

    private final List<ObjectAnimator> rightToCaseAnimal() {
        ArrayList arrayList = new ArrayList();
        AppCompatImageView ivLeft = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
        List<ObjectAnimator> viewScale = getViewScale(ivLeft, 0.8f, 0.7f);
        AppCompatImageView ivLeft2 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft2, "ivLeft");
        ObjectAnimator alphaAnimator = getAlphaAnimator(ivLeft2, 0.5f, 0.5f);
        AppCompatImageView ivLeft3 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft3, "ivLeft");
        ControlActivity controlActivity = this;
        ObjectAnimator translationXAnimator = getTranslationXAnimator(ivLeft3, -ContextExtKt.dp2px(controlActivity, TRANSLATION_EAR_X), -ContextExtKt.dp2px(controlActivity, 14.0f));
        arrayList.addAll(viewScale);
        arrayList.add(alphaAnimator);
        arrayList.add(translationXAnimator);
        AppCompatImageView ivRight = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
        List<ObjectAnimator> viewScale2 = getViewScale(ivRight, 1.0f, 0.7f);
        AppCompatImageView ivRight2 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight2, "ivRight");
        ObjectAnimator alphaAnimator2 = getAlphaAnimator(ivRight2, 1.0f, 0.5f);
        AppCompatImageView ivRight3 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight3, "ivRight");
        ObjectAnimator translationXAnimator2 = getTranslationXAnimator(ivRight3, 0.0f, -ContextExtKt.dp2px(controlActivity, 26.0f));
        arrayList.addAll(viewScale2);
        arrayList.add(alphaAnimator2);
        arrayList.add(translationXAnimator2);
        ImageView caseImage = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage, "caseImage");
        List<ObjectAnimator> viewScale3 = getViewScale(caseImage, 0.6f, 1.0f);
        ImageView caseImage2 = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage2, "caseImage");
        ObjectAnimator alphaAnimator3 = getAlphaAnimator(caseImage2, 0.5f, 1.0f);
        ImageView caseImage3 = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage3, "caseImage");
        ObjectAnimator translationXAnimator3 = getTranslationXAnimator(caseImage3, ContextExtKt.dp2px(controlActivity, 32.0f), 0.0f);
        arrayList.addAll(viewScale3);
        arrayList.add(alphaAnimator3);
        arrayList.add(translationXAnimator3);
        return arrayList;
    }

    private final List<ObjectAnimator> leftToCaseAnimal() {
        ArrayList arrayList = new ArrayList();
        AppCompatImageView ivLeft = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft, "ivLeft");
        List<ObjectAnimator> viewScale = getViewScale(ivLeft, 1.0f, 0.7f);
        AppCompatImageView ivLeft2 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft2, "ivLeft");
        ObjectAnimator alphaAnimator = getAlphaAnimator(ivLeft2, 1.0f, 0.5f);
        AppCompatImageView ivLeft3 = getMBinding().ivLeft;
        Intrinsics.checkNotNullExpressionValue(ivLeft3, "ivLeft");
        ControlActivity controlActivity = this;
        ObjectAnimator translationXAnimator = getTranslationXAnimator(ivLeft3, 0.0f, -ContextExtKt.dp2px(controlActivity, 14.0f));
        arrayList.addAll(viewScale);
        arrayList.add(alphaAnimator);
        arrayList.add(translationXAnimator);
        AppCompatImageView ivRight = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight, "ivRight");
        List<ObjectAnimator> viewScale2 = getViewScale(ivRight, 0.8f, 0.7f);
        AppCompatImageView ivRight2 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight2, "ivRight");
        ObjectAnimator alphaAnimator2 = getAlphaAnimator(ivRight2, 0.5f, 0.5f);
        AppCompatImageView ivRight3 = getMBinding().ivRight;
        Intrinsics.checkNotNullExpressionValue(ivRight3, "ivRight");
        ObjectAnimator translationXAnimator2 = getTranslationXAnimator(ivRight3, ContextExtKt.dp2px(controlActivity, TRANSLATION_EAR_X), -ContextExtKt.dp2px(controlActivity, 26.0f));
        arrayList.addAll(viewScale2);
        arrayList.add(alphaAnimator2);
        arrayList.add(translationXAnimator2);
        ImageView caseImage = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage, "caseImage");
        List<ObjectAnimator> viewScale3 = getViewScale(caseImage, 0.6f, 1.0f);
        ImageView caseImage2 = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage2, "caseImage");
        ObjectAnimator alphaAnimator3 = getAlphaAnimator(caseImage2, 0.5f, 1.0f);
        ImageView caseImage3 = getMBinding().caseImage;
        Intrinsics.checkNotNullExpressionValue(caseImage3, "caseImage");
        ObjectAnimator translationXAnimator3 = getTranslationXAnimator(caseImage3, ContextExtKt.dp2px(controlActivity, 32.0f), 0.0f);
        arrayList.addAll(viewScale3);
        arrayList.add(alphaAnimator3);
        arrayList.add(translationXAnimator3);
        return arrayList;
    }

    private final List<ObjectAnimator> getViewScale(View targetView, float scaleStart, float scaleEnd) {
        return CollectionsKt.arrayListOf(ObjectAnimator.ofFloat(targetView, "scaleY", scaleStart, scaleEnd), ObjectAnimator.ofFloat(targetView, "scaleX", scaleStart, scaleEnd));
    }

    private final ObjectAnimator getAlphaAnimator(View targetView, float alphaStart, float alphaEnd) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(targetView, "alpha", alphaStart, alphaEnd);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        return objectAnimatorOfFloat;
    }

    private final ObjectAnimator getTranslationXAnimator(View targetView, float translationStart, float translationEnd) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(targetView, "translationX", translationStart, translationEnd);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "ofFloat(...)");
        return objectAnimatorOfFloat;
    }

    private final void setDefaultScaleSelected() {
        Bundle extras = getIntent().getExtras();
        boolean z = extras != null ? extras.getBoolean("IS_LEFT_SELECTED") : true;
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.getRightTextVisible().set(true);
        getMBinding().caseImage.setAlpha(0.5f);
        if (z) {
            this.currentSelectType = 0;
            getMBinding().ivLeft.setScaleX(1.0f);
            getMBinding().ivLeft.setScaleY(1.0f);
            getMBinding().ivLeft.setAlpha(1.0f);
            getMBinding().ivRight.setAlpha(0.5f);
        } else {
            this.currentSelectType = 1;
            getMBinding().ivRight.setScaleX(1.0f);
            getMBinding().ivRight.setScaleY(1.0f);
            getMBinding().ivRight.setAlpha(1.0f);
            getMBinding().ivLeft.setAlpha(0.5f);
        }
        setEarMove(z);
    }

    private final void setCaseSelected() {
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.getRightTextVisible().set(true);
        getMBinding().caseImage.setAlpha(1.0f);
        getMBinding().caseImage.setScaleX(1.0f);
        getMBinding().caseImage.setScaleY(1.0f);
        getMBinding().ivLeft.setAlpha(0.5f);
        getMBinding().ivRight.setAlpha(0.5f);
        getMBinding().ivRight.setScaleX(0.7f);
        getMBinding().ivRight.setScaleY(0.7f);
        getMBinding().ivLeft.setScaleX(0.7f);
        getMBinding().ivLeft.setScaleY(0.7f);
        this.currentSelectType = 2;
        setCaseMove();
    }

    private final void setCaseMove() {
        ControlActivity controlActivity = this;
        getMBinding().ivLeft.setTranslationX(-ContextExtKt.dp2px(controlActivity, 14.0f));
        getMBinding().ivRight.setTranslationX(-ContextExtKt.dp2px(controlActivity, 26.0f));
        getMBinding().caseImage.setTranslationX(0.0f);
        getMBinding().tvRight.setText(getString(R.string.knob));
    }

    private final void setEarMove(boolean isLeft) {
        if (isLeft) {
            getMBinding().ivRight.setTranslationX(ContextExtKt.dp2px(this, TRANSLATION_EAR_X));
            getMBinding().tvRight.setText(getString(R.string.control_left));
        } else {
            getMBinding().ivLeft.setTranslationX(-ContextExtKt.dp2px(this, TRANSLATION_EAR_X));
            getMBinding().tvRight.setText(getString(R.string.control_right));
        }
        getMBinding().caseImage.setTranslationX(ContextExtKt.dp2px(this, 32.0f));
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
        ActivityTransitionAnimation.INSTANCE.onSaveInstanceState(outState, new Function0() { // from class: com.nothing.espeon.control.ControlActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        GooglePlayScoreUtil.INSTANCE.endControl();
    }
}
