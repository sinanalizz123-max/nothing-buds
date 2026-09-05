package com.nothing.earbase.unknown;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nothing.base.adapter.CommonBindingAdapter;
import com.nothing.base.dialog.confirm.ConfirmMsgDialog;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.recycleview.NoScrollGridLayoutManager;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.ActionViewConfig;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.base.wiget.radar.OnEQChangeListener;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.UnknownEqualizerActivityBinding;
import com.nothing.earbase.equalizer.EqualizerDecoration;
import com.nothing.earbase.equalizer.EqualizerDisconnectGuard;
import com.nothing.earbase.equalizer.EqualizerLeakageGuard;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import com.nothing.earbase.unknown.device.UnknownProduct;
import com.nothing.earbase.unknown.entity.DiracOpteoEQ;
import com.nothing.earbase.unknown.entity.UnknownFunction;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: UnknownEqualizerActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001.B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0014J\b\u0010\u001a\u001a\u00020\rH\u0014J\b\u0010\u001b\u001a\u00020\rH\u0014J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0016J\u0012\u0010\"\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u0002H\u0016J\u000e\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)J\u0018\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006/"}, d2 = {"Lcom/nothing/earbase/unknown/UnknownEqualizerActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/UnknownEqualizerActivityBinding;", "Lcom/nothing/base/wiget/radar/OnEQChangeListener;", "<init>", "()V", "viewModel", "Lcom/nothing/earbase/unknown/UnknownSimpleActivityViewModel;", "hdacWarningDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "hdacWarningViewModel", "Lcom/nothing/base/dialog/confirm/ConfirmMsgViewModel;", "createActionViewConfig", "", "contentConfig", "Lcom/nothing/base/view/ActionViewConfig;", "createContentConfig", "Lcom/nothing/base/view/BaseConfig;", "diracEQGuideDialog", "Lcom/nothing/earbase/unknown/UnknownDiracEQGuideDialog;", "getDiracEQGuideDialog", "()Lcom/nothing/earbase/unknown/UnknownDiracEQGuideDialog;", "setDiracEQGuideDialog", "(Lcom/nothing/earbase/unknown/UnknownDiracEQGuideDialog;)V", "rightLabelClickEvent", "onResume", "onPause", "onDestroy", "onInitStatusBar", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "onInitObserver", "binding", "onClickType", "typeViewModel", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "onChange", "index", "", "value", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnknownEqualizerActivity extends BaseActivity<UnknownEqualizerActivityBinding> implements OnEQChangeListener {
    private static final float BOTTOM_MARGIN = 24.0f;
    private static final float ITEM_DECORATION_GAP = 4.0f;
    private static final int ONE = 1;
    private static final float SCALE_RADAR = 0.8f;
    private static final int THREE = 3;
    private static final int TWO = 2;
    private UnknownDiracEQGuideDialog diracEQGuideDialog;
    private ConfirmMsgDialog hdacWarningDialog;
    private final ConfirmMsgViewModel hdacWarningViewModel = new ConfirmMsgViewModel();
    private UnknownSimpleActivityViewModel viewModel;

    @Override // com.nothing.base.view.BaseActivity
    public void createActionViewConfig(ActionViewConfig contentConfig) {
        List<DiracOpteoEQ> diracOpteoEQList;
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createActionViewConfig(contentConfig);
        contentConfig.setSubTitle(getString(R.string.equalizer));
        IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(SpUtils.INSTANCE.getSelectDeviceMac());
        if (productByMacAddress instanceof UnknownProduct) {
            UnknownProduct unknownProduct = (UnknownProduct) productByMacAddress;
            UnknownFunction lastConfigs = unknownProduct.getLastConfigs();
            boolean z = false;
            if (lastConfigs != null && (diracOpteoEQList = lastConfigs.getDiracOpteoEQList()) != null && diracOpteoEQList.contains(DiracOpteoEQ.IMMERSION_BOOST)) {
                z = true;
            }
            if (!unknownProduct.isHasDiracEqInfo() || z) {
                return;
            }
            contentConfig.setRightIcon(R.drawable.explan_info_icon);
        }
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = (UnknownSimpleActivityViewModel) new ViewModelProvider(this).get(UnknownSimpleActivityViewModel.class);
        this.viewModel = unknownSimpleActivityViewModel;
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel2 = null;
        if (unknownSimpleActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            unknownSimpleActivityViewModel = null;
        }
        unknownSimpleActivityViewModel.setSampleDesignSize(366.0f);
        this.hdacWarningDialog = new ConfirmMsgDialog();
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel3 = this.viewModel;
        if (unknownSimpleActivityViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            unknownSimpleActivityViewModel3 = null;
        }
        unknownSimpleActivityViewModel3.register();
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.unknown_equalizer_activity);
        int i = BR.viewModel;
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel4 = this.viewModel;
        if (unknownSimpleActivityViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            unknownSimpleActivityViewModel2 = unknownSimpleActivityViewModel4;
        }
        layoutId.addVariable(i, unknownSimpleActivityViewModel2).addVariable(BR.eventHandler, this);
    }

    public final UnknownDiracEQGuideDialog getDiracEQGuideDialog() {
        return this.diracEQGuideDialog;
    }

    public final void setDiracEQGuideDialog(UnknownDiracEQGuideDialog unknownDiracEQGuideDialog) {
        this.diracEQGuideDialog = unknownDiracEQGuideDialog;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
        IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(SpUtils.INSTANCE.getSelectDeviceMac());
        if ((productByMacAddress instanceof UnknownProduct) && ((UnknownProduct) productByMacAddress).isHasDiracEqInfo()) {
            UnknownDiracEQGuideDialog unknownDiracEQGuideDialog = this.diracEQGuideDialog;
            if (unknownDiracEQGuideDialog != null) {
                unknownDiracEQGuideDialog.dismiss();
            }
            UnknownDiracEQGuideDialog unknownDiracEQGuideDialog2 = new UnknownDiracEQGuideDialog();
            this.diracEQGuideDialog = unknownDiracEQGuideDialog2;
            UnknownEqualizerActivity unknownEqualizerActivity = this;
            UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = this.viewModel;
            if (unknownSimpleActivityViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                unknownSimpleActivityViewModel = null;
            }
            unknownDiracEQGuideDialog2.show(unknownEqualizerActivity, unknownSimpleActivityViewModel, new Function0() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            }, new Function0() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        EqualizerLeakageGuard equalizerLeakageGuard = EqualizerLeakageGuard.INSTANCE;
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = this.viewModel;
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel2 = null;
        if (unknownSimpleActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            unknownSimpleActivityViewModel = null;
        }
        equalizerLeakageGuard.startObserving(unknownSimpleActivityViewModel.getTWSDevice());
        EqualizerDisconnectGuard equalizerDisconnectGuard = EqualizerDisconnectGuard.INSTANCE;
        UnknownEqualizerActivity unknownEqualizerActivity = this;
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel3 = this.viewModel;
        if (unknownSimpleActivityViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            unknownSimpleActivityViewModel2 = unknownSimpleActivityViewModel3;
        }
        equalizerDisconnectGuard.startObserving(unknownEqualizerActivity, unknownSimpleActivityViewModel2.getTWSDevice());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        EqualizerLeakageGuard.INSTANCE.stopObserving();
        super.onPause();
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        EqualizerDisconnectGuard.stopObserving$default(EqualizerDisconnectGuard.INSTANCE, false, 1, null);
        UnknownDiracEQGuideDialog unknownDiracEQGuideDialog = this.diracEQGuideDialog;
        if (unknownDiracEQGuideDialog != null) {
            unknownDiracEQGuideDialog.dismiss();
        }
        super.onDestroy();
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitStatusBar(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        FrameLayout frameLayout = rootBinding.rootView;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        frameLayout.setPadding(0, ContextExtKt.getStatusBarHeight(resources), 0, 0);
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onConfigurationChanged --> " + newConfig;
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
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        ViewGroup.LayoutParams layoutParams = getMBinding().vBottom.getLayoutParams();
        UnknownEqualizerActivity unknownEqualizerActivity = this;
        if (ContextExtKt.getNavigationBarHeight(unknownEqualizerActivity) == 0) {
            if (layoutParams != null) {
                layoutParams.height = ContextExtKt.dp2px(unknownEqualizerActivity, 24.0f);
            }
        } else if (layoutParams != null) {
            layoutParams.height = ContextExtKt.getNavigationBarHeight(unknownEqualizerActivity);
        }
        getMBinding().vBottom.setLayoutParams(layoutParams);
        NoScrollGridLayoutManager noScrollGridLayoutManager = new NoScrollGridLayoutManager(unknownEqualizerActivity, 2);
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = this.viewModel;
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel2 = null;
        if (unknownSimpleActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            unknownSimpleActivityViewModel = null;
        }
        int size = unknownSimpleActivityViewModel.getEqualizerTypes().size();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        if (size % 2 != 0) {
            intRef.element = size - 1;
        }
        noScrollGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity.onInit.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return position == intRef.element ? 2 : 1;
            }
        });
        getMBinding().rvSound.addItemDecoration(new EqualizerDecoration(ContextExtKt.dp2px(unknownEqualizerActivity, 4.0f)));
        getMBinding().rvSound.setLayoutManager(noScrollGridLayoutManager);
        RecyclerView recyclerView = getMBinding().rvSound;
        CommonBindingAdapter.Builder eventHandler = new CommonBindingAdapter.Builder().setLayoutId(R.layout.unknown_equalizer_item).setEventHandler((Object) this);
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel3 = this.viewModel;
        if (unknownSimpleActivityViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            unknownSimpleActivityViewModel2 = unknownSimpleActivityViewModel3;
        }
        recyclerView.setAdapter(eventHandler.setDataList(unknownSimpleActivityViewModel2.getEqualizerTypes()).build());
        getMBinding().vRadar.setChangeListener(this);
        this.hdacWarningViewModel.getTitle().set(getString(R.string.attention));
        this.hdacWarningViewModel.getMsg().set(getString(R.string.unavailable_msg, new Object[]{"Dirac Opteo", "LDAC"}));
        this.hdacWarningViewModel.getPositionBtn().set(getString(R.string.okay));
        this.hdacWarningViewModel.getNegativeVisible().set(false);
        this.hdacWarningViewModel.getSureButtonColor().set(ContextCompat.getColor(unknownEqualizerActivity, R.color.nt_F0F2F2_06080A));
        this.hdacWarningViewModel.getSureButtonTextColor().set(ContextCompat.getColor(unknownEqualizerActivity, R.color.nt_06080A_F0F2F2));
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitObserver(UnknownEqualizerActivityBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.onInitObserver(binding);
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = this.viewModel;
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel2 = null;
        if (unknownSimpleActivityViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            unknownSimpleActivityViewModel = null;
        }
        UnknownEqualizerActivity unknownEqualizerActivity = this;
        unknownSimpleActivityViewModel.getCustomEqState().observe(unknownEqualizerActivity, new UnknownEqualizerActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnknownEqualizerActivity.onInitObserver$lambda$4(this.f$0, (List) obj);
            }
        }));
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel3 = this.viewModel;
        if (unknownSimpleActivityViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            unknownSimpleActivityViewModel2 = unknownSimpleActivityViewModel3;
        }
        unknownSimpleActivityViewModel2.getNeedHDACWarning().observe(unknownEqualizerActivity, new UnknownEqualizerActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return UnknownEqualizerActivity.onInitObserver$lambda$7(this.f$0, (WarnEqualizerTypeViewModel) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$4(UnknownEqualizerActivity unknownEqualizerActivity, List list) {
        if (list != null) {
            unknownEqualizerActivity.getMBinding().vRadar.setRadarList(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$7(final UnknownEqualizerActivity unknownEqualizerActivity, WarnEqualizerTypeViewModel warnEqualizerTypeViewModel) {
        IOTProductDevice productByModelId;
        if (warnEqualizerTypeViewModel != null && warnEqualizerTypeViewModel.getWarning() && (productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(SpUtils.INSTANCE.getCurrentModel())) != null && productByModelId.hldcOrDiracOne()) {
            ConfirmMsgDialog confirmMsgDialog = unknownEqualizerActivity.hdacWarningDialog;
            if (confirmMsgDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hdacWarningDialog");
                confirmMsgDialog = null;
            }
            confirmMsgDialog.show(unknownEqualizerActivity, unknownEqualizerActivity.hdacWarningViewModel, new Function0() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UnknownEqualizerActivity.onInitObserver$lambda$7$lambda$5(this.f$0);
                }
            }, new Function0() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UnknownEqualizerActivity.onInitObserver$lambda$7$lambda$6(this.f$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$7$lambda$5(UnknownEqualizerActivity unknownEqualizerActivity) {
        ConfirmMsgDialog confirmMsgDialog = unknownEqualizerActivity.hdacWarningDialog;
        if (confirmMsgDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hdacWarningDialog");
            confirmMsgDialog = null;
        }
        confirmMsgDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$7$lambda$6(UnknownEqualizerActivity unknownEqualizerActivity) {
        ConfirmMsgDialog confirmMsgDialog = unknownEqualizerActivity.hdacWarningDialog;
        if (confirmMsgDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hdacWarningDialog");
            confirmMsgDialog = null;
        }
        confirmMsgDialog.dismiss();
        return Unit.INSTANCE;
    }

    public final void onClickType(EqualizerTypeViewModel typeViewModel) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        if (getMBinding().vRadar.isDragging()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C07151(typeViewModel, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownEqualizerActivity$onClickType$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UnknownEqualizerActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownEqualizerActivity$onClickType$1", f = "UnknownEqualizerActivity.kt", i = {}, l = {197}, m = "invokeSuspend", n = {}, s = {})
    static final class C07151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ EqualizerTypeViewModel $typeViewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C07151(EqualizerTypeViewModel equalizerTypeViewModel, Continuation<? super C07151> continuation) {
            super(2, continuation);
            this.$typeViewModel = equalizerTypeViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UnknownEqualizerActivity.this.new C07151(this.$typeViewModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C07151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EqualizerLeakageGuard equalizerLeakageGuard = EqualizerLeakageGuard.INSTANCE;
                UnknownEqualizerActivity unknownEqualizerActivity = UnknownEqualizerActivity.this;
                UnknownEqualizerActivity unknownEqualizerActivity2 = unknownEqualizerActivity;
                UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = unknownEqualizerActivity.viewModel;
                if (unknownSimpleActivityViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    unknownSimpleActivityViewModel = null;
                }
                TWSDevice tWSDevice = unknownSimpleActivityViewModel.getTWSDevice();
                final UnknownEqualizerActivity unknownEqualizerActivity3 = UnknownEqualizerActivity.this;
                final EqualizerTypeViewModel equalizerTypeViewModel = this.$typeViewModel;
                this.label = 1;
                if (equalizerLeakageGuard.guardEqAction(unknownEqualizerActivity2, tWSDevice, new Function0() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity$onClickType$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UnknownEqualizerActivity.C07151.invokeSuspend$lambda$0(unknownEqualizerActivity3, equalizerTypeViewModel);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(UnknownEqualizerActivity unknownEqualizerActivity, EqualizerTypeViewModel equalizerTypeViewModel) {
            UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = unknownEqualizerActivity.viewModel;
            if (unknownSimpleActivityViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                unknownSimpleActivityViewModel = null;
            }
            unknownSimpleActivityViewModel.setEQMode(equalizerTypeViewModel);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.earbase.unknown.UnknownEqualizerActivity$onChange$1, reason: invalid class name */
    /* JADX INFO: compiled from: UnknownEqualizerActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.unknown.UnknownEqualizerActivity$onChange$1", f = "UnknownEqualizerActivity.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $index;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$index = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return UnknownEqualizerActivity.this.new AnonymousClass1(this.$index, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                EqualizerLeakageGuard equalizerLeakageGuard = EqualizerLeakageGuard.INSTANCE;
                UnknownEqualizerActivity unknownEqualizerActivity = UnknownEqualizerActivity.this;
                UnknownEqualizerActivity unknownEqualizerActivity2 = unknownEqualizerActivity;
                UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = unknownEqualizerActivity.viewModel;
                if (unknownSimpleActivityViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    unknownSimpleActivityViewModel = null;
                }
                TWSDevice tWSDevice = unknownSimpleActivityViewModel.getTWSDevice();
                final UnknownEqualizerActivity unknownEqualizerActivity3 = UnknownEqualizerActivity.this;
                final int i2 = this.$index;
                this.label = 1;
                if (equalizerLeakageGuard.guardEqAction(unknownEqualizerActivity2, tWSDevice, new Function0() { // from class: com.nothing.earbase.unknown.UnknownEqualizerActivity$onChange$1$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UnknownEqualizerActivity.AnonymousClass1.invokeSuspend$lambda$0(unknownEqualizerActivity3, i2);
                    }
                }, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0(UnknownEqualizerActivity unknownEqualizerActivity, int i) {
            UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = unknownEqualizerActivity.viewModel;
            if (unknownSimpleActivityViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                unknownSimpleActivityViewModel = null;
            }
            unknownSimpleActivityViewModel.setCustomEQ(i);
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.base.wiget.radar.OnEQChangeListener
    public void onChange(int index, int value) {
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(index, null), 3, null);
    }
}
