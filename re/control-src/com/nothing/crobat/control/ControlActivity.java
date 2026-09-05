package com.nothing.crobat.control;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.ActivityCompat;
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
import com.nothing.ear.databinding.CrobatControlActivityBinding;
import com.nothing.earbase.control.ControlAdapter;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\u001c\u0010\"\u001a\u00020\u00102\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020&0$H\u0002J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020&H\u0002J\u000e\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010-\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020\u0010H\u0014J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u00020 H\u0014J\b\u00101\u001a\u00020\u0010H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/nothing/crobat/control/ControlActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/CrobatControlActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/crobat/control/ControlViewModel;", "adapter", "Lcom/nothing/earbase/control/ControlAdapter;", "resetDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "resetString", "", "changeControlBounds", "Lcom/nothing/crobat/control/ChangeControlBounds;", "onInitStatusBar", "", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "rightLabelClickEvent", "onBackPressedInner", "createActionViewConfig", "contentConfig", "Lcom/nothing/base/view/ActionViewConfig;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "fixTranslatePosition", "createContentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "afterOnSuperCreate", "showRightLabel", "pair", "Lkotlin/Pair;", "", "", "refreshGestureData", "isLeft", "onClickItem", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "onClickChangeData", "setDefaultScaleSelected", "onStop", "onSaveInstanceState", "outState", "onDestroy", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlActivity extends BaseActivity<CrobatControlActivityBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IS_LEFT_SELECTED = "IS_LEFT_SELECTED";
    private static final String RIGHT_EAR_IMAGE = "right_ear_image";
    private ControlAdapter adapter;
    private ConfirmMsgDialog resetDialog;
    private ControlViewModel viewModel;
    private String resetString = "";
    private final ChangeControlBounds changeControlBounds = new ChangeControlBounds();

    @Override // com.nothing.base.view.BaseActivity
    public void onInitStatusBar(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        FrameLayout frameLayout = rootBinding.rootView;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        frameLayout.setPadding(0, ContextExtKt.getStatusBarHeight(resources), 0, 0);
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
            confirmMsgDialog.show(this, confirmMsgViewModel, new Function0() { // from class: com.nothing.crobat.control.ControlActivity$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ControlActivity.rightLabelClickEvent$lambda$0(this.f$0);
                }
            }, new Function0() { // from class: com.nothing.crobat.control.ControlActivity$$ExternalSyntheticLambda7
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
    public void createActionViewConfig(ActionViewConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createActionViewConfig(contentConfig);
        contentConfig.setSubTitle(getString(R.string.controls));
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        getMBinding().ivRight.post(new Runnable() { // from class: com.nothing.crobat.control.ControlActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.fixTranslatePosition();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fixTranslatePosition() {
        float offsetX = this.changeControlBounds.getOffsetX();
        float offsetY = this.changeControlBounds.getOffsetY(0.0f);
        AppCompatImageView appCompatImageView = getMBinding().ivRight;
        float translationX = appCompatImageView.getTranslationX();
        float translationY = appCompatImageView.getTranslationY();
        appCompatImageView.setTranslationX(offsetX);
        appCompatImageView.setTranslationY(-offsetY);
        appCompatImageView.setRotation(-10.0f);
        appCompatImageView.setScaleX(3.0f);
        appCompatImageView.setScaleY(3.0f);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "   offsetX " + offsetX + " offsetY " + offsetY + " ,translationX:" + translationX + ",translationY:" + translationY;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str3 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            }
        }
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
        this.adapter = new ControlAdapter(new CommonBindingMoreAdapter.Builder().addViewType(1, new CommonBindingMoreAdapter.Builder.ItemBuilder().setEventHandler((Object) this)).addViewType(2).addViewType(5).addLayoutView(1, R.layout.crobat_control_item).addLayoutView(5, R.layout.empty_bottom_view).addLayoutView(2, R.layout.control_not_customisable_view), this);
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.crobat_control_activity);
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
        setDefaultScaleSelected();
        getMBinding().ivRight.setTransitionName(RIGHT_EAR_IMAGE);
        getMBinding().setEventHandler(this);
        getMBinding().rvControl.setLayoutManager(new WrapContentLinearLayoutManager(this));
        RecyclerView recyclerView = getMBinding().rvControl;
        ControlAdapter controlAdapter = this.adapter;
        if (controlAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            controlAdapter = null;
        }
        recyclerView.setAdapter(controlAdapter);
        getMBinding().ivRight.post(new Runnable() { // from class: com.nothing.crobat.control.ControlActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.fixTranslatePosition();
            }
        });
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

    private final void showRightLabel(Pair<Integer, Boolean> pair) {
        if (pair.getSecond().booleanValue()) {
            TextView rightLabel = getActionBarBinding().headerBar.getRightLabel();
            String lowerCase = this.resetString.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            rightLabel.setText(DataExtKt.firstUpper(lowerCase));
            return;
        }
        getActionBarBinding().headerBar.getRightLabel().setText("");
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

    public final void onClickItem(ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        onClickChangeData(itemViewModel);
    }

    private final void onClickChangeData(ControlGestureViewModel itemViewModel) {
        Intent intent = new Intent(this, (Class<?>) ControlOperationActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("SELECTED_OPERATION", itemViewModel.getOptions());
        intent.putExtras(bundle);
        getResultLauncher().launcher(intent, new Function1() { // from class: com.nothing.crobat.control.ControlActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlActivity.onClickChangeData$lambda$9(this.f$0, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickChangeData$lambda$9(ControlActivity controlActivity, ActivityResult it) {
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

    private final void setDefaultScaleSelected() {
        Bundle extras = getIntent().getExtras();
        ControlViewModel controlViewModel = null;
        if (extras != null ? extras.getBoolean("IS_LEFT_SELECTED") : true) {
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
        controlViewModel.getDataUpdate().observe(this, new ControlActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.crobat.control.ControlActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlActivity.setDefaultScaleSelected$lambda$11(this.f$0, (Pair) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDefaultScaleSelected$lambda$11(final ControlActivity controlActivity, Pair pair) {
        if (pair != null) {
            if (((Number) pair.getFirst()).intValue() == 1) {
                ControlViewModel controlViewModel = controlActivity.viewModel;
                if (controlViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    controlViewModel = null;
                }
                controlActivity.refreshGestureData(controlViewModel, false);
                controlActivity.getMBinding().rvControl.postDelayed(new Runnable() { // from class: com.nothing.crobat.control.ControlActivity$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        ControlActivity.setDefaultScaleSelected$lambda$11$lambda$10(this.f$0);
                    }
                }, 1000L);
            }
            controlActivity.showRightLabel(pair);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDefaultScaleSelected$lambda$11$lambda$10(ControlActivity controlActivity) {
        ControlViewModel controlViewModel = controlActivity.viewModel;
        ControlAdapter controlAdapter = null;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        ObservableArrayList<CommonBindingMoreType> rightGestureData = controlViewModel.getRightGestureData();
        ControlAdapter controlAdapter2 = controlActivity.adapter;
        if (controlAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            controlAdapter = controlAdapter2;
        }
        controlAdapter.refreshData(rightGestureData);
    }

    /* JADX INFO: compiled from: ControlActivity.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/nothing/crobat/control/ControlActivity$Companion;", "", "<init>", "()V", "IS_LEFT_SELECTED", "", "RIGHT_EAR_IMAGE", "start", "", "context", "Landroid/app/Activity;", "rightView", "Landroid/view/View;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Activity context, View rightView) {
            Intrinsics.checkNotNullParameter(rightView, "rightView");
            if (context != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("IS_LEFT_SELECTED", false);
                ActivityTransitionAnimation.startActivityWithAnimation$default(ActivityTransitionAnimation.INSTANCE, context, ControlActivity.class, bundle, new androidx.core.util.Pair[]{new androidx.core.util.Pair(rightView, ControlActivity.RIGHT_EAR_IMAGE)}, false, 16, null);
            }
        }
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
        ActivityTransitionAnimation.INSTANCE.onSaveInstanceState(outState, new Function0() { // from class: com.nothing.crobat.control.ControlActivity$$ExternalSyntheticLambda4
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
