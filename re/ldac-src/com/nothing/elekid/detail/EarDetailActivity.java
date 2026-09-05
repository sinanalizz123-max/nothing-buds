package com.nothing.elekid.detail;

import android.content.ComponentCallbacks2;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blankj.utilcode.util.ScreenUtils;
import com.nothing.base.dialog.confirm.ConfirmDialog;
import com.nothing.base.dialog.confirm.ConfirmMsgDialog;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.dialog.confirm.ConfirmViewModel;
import com.nothing.base.router.RouterFactory;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ActivityExtKt;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.ActionViewConfig;
import com.nothing.base.view.ApplicationViewModel;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.ElekidEarDetailActivityBinding;
import com.nothing.earbase.detail.LoadingDialog;
import com.nothing.elekid.dual.DualConnectActivity;
import com.nothing.elekid.find.FindEarActivity;
import com.nothing.elekid.ota.FirmwareActivity;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EarDetailActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0002H\u0016J\u0010\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u001cH\u0016J\u0016\u0010.\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020,J\u0016\u00100\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020,J\u0016\u00101\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020,J\u0016\u00102\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020,J\u0016\u00103\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010/\u001a\u00020,J\u0006\u00104\u001a\u00020\u001cJ\u0006\u00105\u001a\u00020\u001cJ\u0006\u00106\u001a\u00020\u001cJ\u0006\u00107\u001a\u00020\u001cJ\u000e\u00108\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u00109\u001a\u00020\u001cH\u0014J\u0006\u0010:\u001a\u00020\u001cJ\u0006\u0010;\u001a\u00020\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006<"}, d2 = {"Lcom/nothing/elekid/detail/EarDetailActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/ElekidEarDetailActivityBinding;", "<init>", "()V", "viewModel", "Lcom/nothing/elekid/detail/EarDetailViewModel;", "getViewModel", "()Lcom/nothing/elekid/detail/EarDetailViewModel;", "setViewModel", "(Lcom/nothing/elekid/detail/EarDetailViewModel;)V", "loadingDialog", "Lcom/nothing/earbase/detail/LoadingDialog;", "getLoadingDialog", "()Lcom/nothing/earbase/detail/LoadingDialog;", "loadingDialog$delegate", "Lkotlin/Lazy;", "warningDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "warningViewModel", "Lcom/nothing/base/dialog/confirm/ConfirmMsgViewModel;", "forgetDialog", "Lcom/nothing/base/dialog/confirm/ConfirmDialog;", "confirmViewModel", "Lcom/nothing/base/dialog/confirm/ConfirmViewModel;", "applicationViewModel", "Lcom/nothing/base/view/ApplicationViewModel;", "createContentConfig", "", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onInitStatusBar", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "createActionViewConfig", "Lcom/nothing/base/view/ActionViewConfig;", "onInitObserver", "binding", "setBottomViewTopMargin", "isConnect", "", "rightLabelClickEvent", "onClickLowChangeStatus", "state", "onClickSmartAncChangeStatus", "onClickSmartFreeChangeStatus", "onClickHeadTrackChangeStatus", "onClickInEarDetect", "onClickFindEar", "onClickDualConnect", "onClickFirmware", "onClickTipsSupport", "onClickTestLDAC", "onResume", "clickForgetDevice", "clickDisConnect", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarDetailActivity extends BaseActivity<ElekidEarDetailActivityBinding> {
    private ApplicationViewModel applicationViewModel;
    private ConfirmDialog forgetDialog;
    public EarDetailViewModel viewModel;
    private ConfirmMsgDialog warningDialog;

    /* JADX INFO: renamed from: loadingDialog$delegate, reason: from kotlin metadata */
    private final Lazy loadingDialog = LazyKt.lazy(new Function0() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return EarDetailActivity.loadingDialog_delegate$lambda$0();
        }
    });
    private final ConfirmMsgViewModel warningViewModel = new ConfirmMsgViewModel();
    private final ConfirmViewModel confirmViewModel = new ConfirmViewModel();

    public final EarDetailViewModel getViewModel() {
        EarDetailViewModel earDetailViewModel = this.viewModel;
        if (earDetailViewModel != null) {
            return earDetailViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(EarDetailViewModel earDetailViewModel) {
        Intrinsics.checkNotNullParameter(earDetailViewModel, "<set-?>");
        this.viewModel = earDetailViewModel;
    }

    private final LoadingDialog getLoadingDialog() {
        return (LoadingDialog) this.loadingDialog.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LoadingDialog loadingDialog_delegate$lambda$0() {
        return LoadingDialog.INSTANCE.newInstance();
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        setViewModel((EarDetailViewModel) new ViewModelProvider(this).get(EarDetailViewModel.class));
        this.forgetDialog = new ConfirmDialog();
        ComponentCallbacks2 application = getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "getApplication(...)");
        this.applicationViewModel = (ApplicationViewModel) (application instanceof ViewModelStoreOwner ? new ViewModelProvider((ViewModelStoreOwner) application).get(ApplicationViewModel.class) : null);
        contentConfig.setLayoutId(R.layout.elekid_ear_detail_activity).addVariable(BR.viewModel, getViewModel()).addVariable(BR.eventHandler, this);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInit(Bundle savedInstanceState) {
        this.confirmViewModel.getTitle().set(getString(R.string.forget_dialog_msg));
        this.confirmViewModel.getPositionBtn().set(getString(R.string.forget));
        this.confirmViewModel.getNegativeBtn().set(getString(R.string.cancel));
        this.warningDialog = new ConfirmMsgDialog();
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getViewModel().getConfigInfo();
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
        contentConfig.setSubTitle(getString(R.string.device_settings));
        if (RouterFactory.INSTANCE.getTestToolsRouter().showDebugIcon()) {
            contentConfig.setRightIcon(R.drawable.debug_icon);
        }
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitObserver(ElekidEarDetailActivityBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.onInitObserver(binding);
        EarDetailActivity earDetailActivity = this;
        getViewModel().getLogLiveData().observe(earDetailActivity, new EarDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarDetailActivity.onInitObserver$lambda$1(this.f$0, (Boolean) obj);
            }
        }));
        getViewModel().getLoadAnimal().observe(earDetailActivity, new EarDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarDetailActivity.onInitObserver$lambda$2(this.f$0, (Boolean) obj);
            }
        }));
        getViewModel().getConnectedLiveData().observe(earDetailActivity, new EarDetailActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarDetailActivity.onInitObserver$lambda$4(this.f$0, (Boolean) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$1(EarDetailActivity earDetailActivity, Boolean bool) {
        if (bool.booleanValue()) {
            LoadingDialog loadingDialog = earDetailActivity.getLoadingDialog();
            FragmentManager supportFragmentManager = earDetailActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            loadingDialog.show(supportFragmentManager);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$2(EarDetailActivity earDetailActivity, Boolean bool) {
        if (bool.booleanValue()) {
            LoadingDialog loadingDialog = earDetailActivity.getLoadingDialog();
            FragmentManager supportFragmentManager = earDetailActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            loadingDialog.showSwitch(supportFragmentManager, earDetailActivity.getString(R.string.dual_connection_rebooting));
        } else {
            earDetailActivity.getLoadingDialog().dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$4(final EarDetailActivity earDetailActivity, final Boolean bool) {
        earDetailActivity.getActionBarBinding().headerBar.setRightIconVisible(bool.booleanValue() && RouterFactory.INSTANCE.getTestToolsRouter().showDebugIcon());
        earDetailActivity.getMBinding().bottomView.postDelayed(new Runnable() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                EarDetailActivity.onInitObserver$lambda$4$lambda$3(this.f$0, bool);
            }
        }, 10L);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitObserver$lambda$4$lambda$3(EarDetailActivity earDetailActivity, Boolean bool) {
        Intrinsics.checkNotNull(bool);
        earDetailActivity.setBottomViewTopMargin(bool.booleanValue());
    }

    private final void setBottomViewTopMargin(boolean isConnect) {
        int iDp2px;
        ViewGroup.LayoutParams layoutParams = getMBinding().bottomView.getLayoutParams();
        if (isConnect) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "bottomView top = " + ContextExtKt.dp2px(this, 12.0f);
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
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
            iDp2px = ContextExtKt.dp2px(this, 12.0f);
        } else {
            int[] iArr = new int[2];
            getMBinding().tipsCl.getLocationInWindow(iArr);
            int screenHeight = ScreenUtils.getScreenHeight();
            int i = iArr[1];
            int height = getMBinding().tipsCl.getHeight();
            EarDetailActivity earDetailActivity = this;
            int navigationBarHeight = ContextExtKt.getNavigationBarHeight(earDetailActivity) + ContextExtKt.dp2px(earDetailActivity, 26.0f);
            int height2 = getMBinding().bottomView.getHeight();
            int i2 = (((screenHeight - i) - height) - navigationBarHeight) - height2;
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "bottomView top = " + i2 + " tipsHeight=" + height + ",extraHeight=" + navigationBarHeight + ",bottomViewHeight:" + height2;
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str6 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            iDp2px = i2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = iDp2px;
            getMBinding().bottomView.requestLayout();
        }
    }

    @Override // com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
        if (getActionBarBinding().headerBar.isRightIconVisible()) {
            RouterFactory.INSTANCE.getTestToolsRouter().startDebugToolActivity(this);
        }
    }

    public final void onClickLowChangeStatus(EarDetailViewModel viewModel, boolean state) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (Intrinsics.areEqual(Boolean.valueOf(state), viewModel.getLowModelChecked().get())) {
            return;
        }
        Boolean bool = viewModel.getLowModelChecked().get();
        viewModel.setLowModel(!(bool != null ? bool.booleanValue() : false));
    }

    public final void onClickSmartAncChangeStatus(EarDetailViewModel viewModel, boolean state) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (Intrinsics.areEqual(Boolean.valueOf(state), viewModel.getSmartAncChecked().get())) {
            return;
        }
        Boolean bool = viewModel.getSmartAncChecked().get();
        viewModel.setSmartAncModel(!(bool != null ? bool.booleanValue() : false));
    }

    public final void onClickSmartFreeChangeStatus(EarDetailViewModel viewModel, boolean state) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (Intrinsics.areEqual(Boolean.valueOf(state), viewModel.getSmartFreeChecked().get())) {
            return;
        }
        Boolean bool = viewModel.getSmartFreeChecked().get();
        viewModel.setSmartFreeModel(!(bool != null ? bool.booleanValue() : false));
    }

    public final void onClickHeadTrackChangeStatus(EarDetailViewModel viewModel, boolean state) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (Intrinsics.areEqual(Boolean.valueOf(state), viewModel.getHeadTrackChecked().get())) {
            return;
        }
        Boolean bool = viewModel.getHeadTrackChecked().get();
        viewModel.setHeadTrackModel(!(bool != null ? bool.booleanValue() : false));
    }

    public final void onClickInEarDetect(EarDetailViewModel viewModel, boolean state) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (Intrinsics.areEqual(Boolean.valueOf(state), viewModel.getInEarChecked().get())) {
            return;
        }
        Boolean bool = viewModel.getInEarChecked().get();
        viewModel.setInEarModel(!(bool != null ? bool.booleanValue() : false));
    }

    public final void onClickFindEar() {
        ActivityExtKt.startActivity$default(this, FindEarActivity.class, null, 2, null);
    }

    public final void onClickDualConnect() {
        ActivityExtKt.startActivity$default(this, DualConnectActivity.class, null, 2, null);
        ApplicationViewModel applicationViewModel = this.applicationViewModel;
        if (applicationViewModel != null) {
            applicationViewModel.addDetailActivity(this);
        }
    }

    public final void onClickFirmware() {
        ActivityExtKt.startActivity$default(this, FirmwareActivity.class, null, 2, null);
    }

    public final void onClickTipsSupport() {
        RouterFactory.INSTANCE.getFeedBackRouter().startSupport(this);
    }

    public final void onClickTestLDAC(final EarDetailViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (Intrinsics.areEqual((Object) viewModel.getLoadAnimal().getValue(), (Object) true)) {
            return;
        }
        this.warningViewModel.getPositionBtn().set(getString(R.string.dual_connection_reboot));
        this.warningViewModel.getNegativeBtn().set(getString(R.string.cancel));
        this.warningViewModel.getTitle().set(getString(R.string.dual_connection_pop_title));
        this.warningViewModel.getMsg().set(getString(R.string.hight_quality_audio_reboot_body));
        final boolean z = !Intrinsics.areEqual((Object) viewModel.getLdacModelChecked().get(), (Object) true);
        ConfirmMsgDialog confirmMsgDialog = this.warningDialog;
        if (confirmMsgDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            confirmMsgDialog = null;
        }
        confirmMsgDialog.show(this, this.warningViewModel, new Function0() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarDetailActivity.onClickTestLDAC$lambda$7(viewModel, z, this);
            }
        }, new Function0() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarDetailActivity.onClickTestLDAC$lambda$8(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickTestLDAC$lambda$7(EarDetailViewModel earDetailViewModel, boolean z, EarDetailActivity earDetailActivity) {
        earDetailViewModel.setLDACStatus(z);
        ConfirmMsgDialog confirmMsgDialog = earDetailActivity.warningDialog;
        if (confirmMsgDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            confirmMsgDialog = null;
        }
        confirmMsgDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClickTestLDAC$lambda$8(EarDetailActivity earDetailActivity) {
        ConfirmMsgDialog confirmMsgDialog = earDetailActivity.warningDialog;
        if (confirmMsgDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("warningDialog");
            confirmMsgDialog = null;
        }
        confirmMsgDialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        getViewModel().requestHttp();
        ApplicationViewModel applicationViewModel = this.applicationViewModel;
        if (applicationViewModel != null) {
            applicationViewModel.removeDetailActivity();
        }
    }

    public final void clickForgetDevice() {
        ConfirmDialog confirmDialog = this.forgetDialog;
        if (confirmDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forgetDialog");
            confirmDialog = null;
        }
        confirmDialog.show(this, this.confirmViewModel, new Function0() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarDetailActivity.clickForgetDevice$lambda$9(this.f$0);
            }
        }, new Function0() { // from class: com.nothing.elekid.detail.EarDetailActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarDetailActivity.clickForgetDevice$lambda$10(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickForgetDevice$lambda$9(EarDetailActivity earDetailActivity) {
        earDetailActivity.getViewModel().forget();
        ConfirmDialog confirmDialog = earDetailActivity.forgetDialog;
        if (confirmDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forgetDialog");
            confirmDialog = null;
        }
        confirmDialog.dismiss();
        earDetailActivity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit clickForgetDevice$lambda$10(EarDetailActivity earDetailActivity) {
        ConfirmDialog confirmDialog = earDetailActivity.forgetDialog;
        if (confirmDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("forgetDialog");
            confirmDialog = null;
        }
        confirmDialog.dismiss();
        return Unit.INSTANCE;
    }

    public final void clickDisConnect() {
        getViewModel().disconnect();
    }
}
