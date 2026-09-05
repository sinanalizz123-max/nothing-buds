package com.nothing.elekid.control;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ScreenUtils;
import com.nothing.base.adapter.CommonBindingMoreAdapter;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.animation.ActivityTransitionAnimation;
import com.nothing.base.animation.ChangeImageAlphaTransform;
import com.nothing.base.animation.RecyclerSlideInUpAnimator;
import com.nothing.base.dialog.confirm.ConfirmMsgDialog;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.launcher.RequestPermissionsLauncher;
import com.nothing.base.recycleview.WrapContentLinearLayoutManager;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.ActionViewConfig;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.ElekidControlActivityBinding;
import com.nothing.earbase.control.ControlAdapter;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.log.FileLog;
import com.nothing.magicbutton.router.ControlActivityManager;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00162\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u001c\u0010(\u001a\u00020\u00162\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u00140*H\u0002J\u000e\u0010,\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010-\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0016H\u0014J\u000e\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202J\u0010\u00103\u001a\u00020\u00162\u0006\u00101\u001a\u000202H\u0002J\b\u00104\u001a\u00020\u0016H\u0002J\b\u00105\u001a\u00020\u0016H\u0002J\b\u00106\u001a\u00020\u0016H\u0014J\u0010\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u00020'H\u0014J\b\u00109\u001a\u00020\u0016H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006;"}, d2 = {"Lcom/nothing/elekid/control/ControlActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/ElekidControlActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/elekid/control/ControlViewModel;", "adapter", "Lcom/nothing/earbase/control/ControlAdapter;", "resetDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "resetString", "", "getResetString", "()Ljava/lang/String;", "resetString$delegate", "Lkotlin/Lazy;", "changeControlBounds", "Lcom/nothing/elekid/control/ChangeControlBounds;", "firstResume", "", "beforeOnSuperCreate", "", "rightLabelClickEvent", "createActionViewConfig", "contentConfig", "Lcom/nothing/base/view/ActionViewConfig;", "onBackPressedInner", "onInitContentBinding", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "fixTranslatePosition", "createContentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "showRightLabel", "pair", "Lkotlin/Pair;", "", "onClickRight", "refreshGestureData", "isLeft", "onResume", "onClickItem", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "onClickChangeData", "requestPermission", "setDefaultScaleSelected", "onStop", "onSaveInstanceState", "outState", "onDestroy", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlActivity extends BaseActivity<ElekidControlActivityBinding> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String IS_LEFT_SELECTED = "IS_LEFT_SELECTED";
    private static final String LEFT_EAR_IMAGE = "left_ear_image";
    private static final String RIGHT_EAR_IMAGE = "right_ear_image";
    private ControlAdapter adapter;
    private ConfirmMsgDialog resetDialog;
    private ControlViewModel viewModel;

    /* JADX INFO: renamed from: resetString$delegate, reason: from kotlin metadata */
    private final Lazy resetString = LazyKt.lazy(new Function0() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ControlActivity.resetString_delegate$lambda$0(this.f$0);
        }
    });
    private final ChangeControlBounds changeControlBounds = new ChangeControlBounds();
    private boolean firstResume = true;

    private final String getResetString() {
        return (String) this.resetString.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String resetString_delegate$lambda$0(ControlActivity controlActivity) {
        return controlActivity.getString(R.string.control_reset_controls);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void beforeOnSuperCreate() {
        super.beforeOnSuperCreate();
        getWindow().requestFeature(13);
        ChangeImageAlphaTransform.INSTANCE.resetEnter();
        TransitionSet transitionSet = new TransitionSet();
        ChangeControlBounds changeControlBounds = this.changeControlBounds;
        changeControlBounds.setControlTransitionName(RIGHT_EAR_IMAGE);
        transitionSet.addTransition(changeControlBounds);
        TransitionSet transitionSet2 = transitionSet;
        getWindow().setSharedElementEnterTransition(transitionSet2);
        getWindow().setSharedElementExitTransition(transitionSet2);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
        if (Intrinsics.areEqual(getActionBarBinding().headerBar.getRightLabel().getText(), getResetString())) {
            ConfirmMsgViewModel confirmMsgViewModel = new ConfirmMsgViewModel();
            ControlActivity controlActivity = this;
            confirmMsgViewModel.getMsg().set(ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.control_reset_title));
            confirmMsgViewModel.getTitle().set(ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.warning));
            confirmMsgViewModel.getPositionBtn().set(ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.control_reset_controls));
            confirmMsgViewModel.getNegativeBtn().set(ContextExtKt.getLocalizedResources(controlActivity).getString(R.string.cancel));
            ConfirmMsgDialog confirmMsgDialog = this.resetDialog;
            if (confirmMsgDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resetDialog");
                confirmMsgDialog = null;
            }
            confirmMsgDialog.show(this, confirmMsgViewModel, new Function0() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ControlActivity.rightLabelClickEvent$lambda$2(this.f$0);
                }
            }, new Function0() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rightLabelClickEvent$lambda$2(ControlActivity controlActivity) {
        ControlViewModel controlViewModel = controlActivity.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.resetGestureData();
        return Unit.INSTANCE;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createActionViewConfig(ActionViewConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createActionViewConfig(contentConfig);
        contentConfig.setSubTitle(getString(R.string.controls));
        ControlActivityManager.INSTANCE.setOperationBundle(null);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onBackPressedInner() {
        getMBinding().rvControl.setVisibility(8);
        ActivityCompat.finishAfterTransition(this);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitContentBinding(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        super.onInitContentBinding(rootBinding);
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
    }

    private final void fixTranslatePosition() {
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
        this.adapter = new ControlAdapter(new CommonBindingMoreAdapter.Builder().addViewType(1, new CommonBindingMoreAdapter.Builder.ItemBuilder().setEventHandler((Object) this)).addViewType(5).addViewType(2).addLayoutView(1, R.layout.elekid_control_item).addLayoutView(5, R.layout.empty_bottom_view).addLayoutView(2, R.layout.control_not_customisable_view), this);
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.elekid_control_activity);
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
        getMBinding().ivRight.setTransitionName(RIGHT_EAR_IMAGE);
        getMBinding().setEventHandler(this);
        RecyclerSlideInUpAnimator recyclerSlideInUpAnimator = new RecyclerSlideInUpAnimator(ScreenUtils.getAppScreenHeight());
        recyclerSlideInUpAnimator.setAddDuration(500L);
        recyclerSlideInUpAnimator.setRemoveDuration(0L);
        getMBinding().rvControl.setItemAnimator(recyclerSlideInUpAnimator);
        getMBinding().rvControl.setLayoutManager(new WrapContentLinearLayoutManager(this));
        RecyclerView recyclerView = getMBinding().rvControl;
        ControlAdapter controlAdapter = this.adapter;
        if (controlAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            controlAdapter = null;
        }
        recyclerView.setAdapter(controlAdapter);
        ControlActivityManager.INSTANCE.addActivity(this);
        requestPermission();
    }

    private final void showRightLabel(Pair<Integer, Boolean> pair) {
        if (pair.getSecond().booleanValue()) {
            getActionBarBinding().headerBar.getRightLabel().setText(getResetString());
        } else {
            getActionBarBinding().headerBar.getRightLabel().setText("");
        }
    }

    public final void onClickRight(ControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        viewModel.getLeftTextVisible().set(false);
        viewModel.getRightTextVisible().set(true);
        refreshGestureData(viewModel, false);
    }

    private final void refreshGestureData(ControlViewModel viewModel, boolean isLeft) {
        ControlConfigurationEntity.Operation options;
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
                    ControlConfigurationEntity.Operation options2 = controlGestureViewModel.getOptions();
                    Integer numValueOf = options2 != null ? Integer.valueOf(options2.getButton()) : null;
                    ControlGestureViewModel controlGestureViewModel3 = viewModel.getSelectedItemViewModel().get();
                    if (Intrinsics.areEqual(numValueOf, (controlGestureViewModel3 == null || (options = controlGestureViewModel3.getOptions()) == null) ? null : Integer.valueOf(options.getButton()))) {
                        onClickChangeData(controlGestureViewModel);
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.firstResume) {
            this.firstResume = false;
            return;
        }
        ControlViewModel controlViewModel = this.viewModel;
        if (controlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            controlViewModel = null;
        }
        controlViewModel.getGestureData(true);
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
        getResultLauncher().launcher(intent, new Function1() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda0
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

    private final void requestPermission() {
        if (NothingOSUtil.INSTANCE.isSupportEssential()) {
            if (Build.VERSION.SDK_INT >= 34) {
                RequestPermissionsLauncher.required$default(getRequestPermissionsLauncher(), this, new String[]{"android.permission.RECORD_AUDIO", "android.permission.FOREGROUND_SERVICE_MICROPHONE", "android.permission.POST_NOTIFICATIONS"}, new Function0() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, new Function1() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ControlActivity.requestPermission$lambda$9((List) obj);
                    }
                }, new Function1() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ControlActivity.requestPermission$lambda$10((List) obj);
                    }
                }, false, false, 96, null);
            } else if (Build.VERSION.SDK_INT >= 33) {
                RequestPermissionsLauncher.required$default(getRequestPermissionsLauncher(), this, new String[]{"android.permission.RECORD_AUDIO", "android.permission.POST_NOTIFICATIONS"}, new Function0() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, new Function1() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ControlActivity.requestPermission$lambda$12((List) obj);
                    }
                }, new Function1() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ControlActivity.requestPermission$lambda$13((List) obj);
                    }
                }, false, false, 96, null);
            } else {
                RequestPermissionsLauncher.required$default(getRequestPermissionsLauncher(), this, new String[]{"android.permission.RECORD_AUDIO"}, new Function0() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, new Function1() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ControlActivity.requestPermission$lambda$15((List) obj);
                    }
                }, new Function1() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ControlActivity.requestPermission$lambda$16((List) obj);
                    }
                }, false, false, 96, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermission$lambda$9(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermission$lambda$10(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermission$lambda$12(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermission$lambda$13(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermission$lambda$15(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermission$lambda$16(List it) {
        Intrinsics.checkNotNullParameter(it, "it");
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
        controlViewModel.getDataUpdate().observe(this, new ControlActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ControlActivity.setDefaultScaleSelected$lambda$18(this.f$0, (Pair) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDefaultScaleSelected$lambda$18(final ControlActivity controlActivity, Pair pair) {
        if (pair != null) {
            if (((Number) pair.getFirst()).intValue() == 1) {
                ControlViewModel controlViewModel = controlActivity.viewModel;
                if (controlViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    controlViewModel = null;
                }
                controlActivity.refreshGestureData(controlViewModel, false);
                controlActivity.getMBinding().rvControl.postDelayed(new Runnable() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        ControlActivity.setDefaultScaleSelected$lambda$18$lambda$17(this.f$0);
                    }
                }, 1000L);
            }
            controlActivity.showRightLabel(pair);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setDefaultScaleSelected$lambda$18$lambda$17(ControlActivity controlActivity) {
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
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/elekid/control/ControlActivity$Companion;", "", "<init>", "()V", "IS_LEFT_SELECTED", "", "LEFT_EAR_IMAGE", "RIGHT_EAR_IMAGE", "start", "", "context", "Landroid/app/Activity;", "rightView", "Landroid/view/View;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
                ActivityTransitionAnimation.INSTANCE.startActivityWithAnimation(context, ControlActivity.class, bundle, new androidx.core.util.Pair[]{new androidx.core.util.Pair<>(rightView, ControlActivity.RIGHT_EAR_IMAGE)}, false);
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
        ActivityTransitionAnimation.INSTANCE.onSaveInstanceState(outState, new Function0() { // from class: com.nothing.elekid.control.ControlActivity$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        ControlActivityManager.INSTANCE.removeActivity(this);
        super.onDestroy();
    }
}
