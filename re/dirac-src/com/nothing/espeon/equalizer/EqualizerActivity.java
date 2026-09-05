package com.nothing.espeon.equalizer;

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
import com.nothing.ear.databinding.EspeonEqualizerActivityBinding;
import com.nothing.earbase.equalizer.EqualizerDecoration;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EqualizerActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 ,2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001,B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0016J\b\u0010\u0019\u001a\u00020\rH\u0014J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0002H\u0016J\u000e\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020'J\u0018\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006-"}, d2 = {"Lcom/nothing/espeon/equalizer/EqualizerActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/EspeonEqualizerActivityBinding;", "Lcom/nothing/base/wiget/radar/OnEQChangeListener;", "<init>", "()V", "viewModel", "Lcom/nothing/espeon/equalizer/EqualizerViewModel;", "hdacWarningDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "hdacWarningViewModel", "Lcom/nothing/base/dialog/confirm/ConfirmMsgViewModel;", "createActionViewConfig", "", "contentConfig", "Lcom/nothing/base/view/ActionViewConfig;", "createContentConfig", "Lcom/nothing/base/view/BaseConfig;", "diracEQGuideDialog", "Lcom/nothing/espeon/equalizer/DiracEQGuideDialog;", "getDiracEQGuideDialog", "()Lcom/nothing/espeon/equalizer/DiracEQGuideDialog;", "setDiracEQGuideDialog", "(Lcom/nothing/espeon/equalizer/DiracEQGuideDialog;)V", "rightLabelClickEvent", "onDestroy", "onInitStatusBar", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "onInitObserver", "binding", "onClickType", "typeViewModel", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "onChange", "index", "", "value", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EqualizerActivity extends BaseActivity<EspeonEqualizerActivityBinding> implements OnEQChangeListener {
    private static final float BOTTOM_MARGIN = 24.0f;
    private static final float ITEM_DECORATION_GAP = 4.0f;
    private static final int ONE = 1;
    private static final float SCALE_RADAR = 0.8f;
    private static final int THREE = 3;
    private static final int TWO = 2;
    private DiracEQGuideDialog diracEQGuideDialog;
    private ConfirmMsgDialog hdacWarningDialog;
    private final ConfirmMsgViewModel hdacWarningViewModel = new ConfirmMsgViewModel();
    private EqualizerViewModel viewModel;

    @Override // com.nothing.base.view.BaseActivity
    public void createActionViewConfig(ActionViewConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createActionViewConfig(contentConfig);
        contentConfig.setSubTitle(getString(R.string.equalizer));
        contentConfig.setRightIcon(R.drawable.explan_info_icon);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        EqualizerViewModel equalizerViewModel = (EqualizerViewModel) new ViewModelProvider(this).get(EqualizerViewModel.class);
        this.viewModel = equalizerViewModel;
        EqualizerViewModel equalizerViewModel2 = null;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        equalizerViewModel.setSampleDesignSize(366.0f);
        this.hdacWarningDialog = new ConfirmMsgDialog();
        EqualizerViewModel equalizerViewModel3 = this.viewModel;
        if (equalizerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel3 = null;
        }
        equalizerViewModel3.register();
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.espeon_equalizer_activity);
        int i = BR.viewModel;
        EqualizerViewModel equalizerViewModel4 = this.viewModel;
        if (equalizerViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            equalizerViewModel2 = equalizerViewModel4;
        }
        layoutId.addVariable(i, equalizerViewModel2).addVariable(BR.eventHandler, this);
    }

    public final DiracEQGuideDialog getDiracEQGuideDialog() {
        return this.diracEQGuideDialog;
    }

    public final void setDiracEQGuideDialog(DiracEQGuideDialog diracEQGuideDialog) {
        this.diracEQGuideDialog = diracEQGuideDialog;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
        DiracEQGuideDialog diracEQGuideDialog = this.diracEQGuideDialog;
        if (diracEQGuideDialog != null) {
            diracEQGuideDialog.dismiss();
        }
        DiracEQGuideDialog diracEQGuideDialog2 = new DiracEQGuideDialog();
        this.diracEQGuideDialog = diracEQGuideDialog2;
        EqualizerActivity equalizerActivity = this;
        EqualizerViewModel equalizerViewModel = this.viewModel;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        diracEQGuideDialog2.show(equalizerActivity, equalizerViewModel, new Function0() { // from class: com.nothing.espeon.equalizer.EqualizerActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        }, new Function0() { // from class: com.nothing.espeon.equalizer.EqualizerActivity$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        DiracEQGuideDialog diracEQGuideDialog = this.diracEQGuideDialog;
        if (diracEQGuideDialog != null) {
            diracEQGuideDialog.dismiss();
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
        EqualizerActivity equalizerActivity = this;
        if (ContextExtKt.getNavigationBarHeight(equalizerActivity) == 0) {
            if (layoutParams != null) {
                layoutParams.height = ContextExtKt.dp2px(equalizerActivity, 24.0f);
            }
        } else if (layoutParams != null) {
            layoutParams.height = ContextExtKt.getNavigationBarHeight(equalizerActivity);
        }
        getMBinding().vBottom.setLayoutParams(layoutParams);
        NoScrollGridLayoutManager noScrollGridLayoutManager = new NoScrollGridLayoutManager(equalizerActivity, 2);
        EqualizerViewModel equalizerViewModel = this.viewModel;
        EqualizerViewModel equalizerViewModel2 = null;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        int size = equalizerViewModel.getEqualizerTypes().size();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        if (size % 2 != 0) {
            intRef.element = size - 1;
        }
        noScrollGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.nothing.espeon.equalizer.EqualizerActivity.onInit.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return position == intRef.element ? 2 : 1;
            }
        });
        getMBinding().rvSound.addItemDecoration(new EqualizerDecoration(ContextExtKt.dp2px(equalizerActivity, 4.0f)));
        getMBinding().rvSound.setLayoutManager(noScrollGridLayoutManager);
        RecyclerView recyclerView = getMBinding().rvSound;
        CommonBindingAdapter.Builder eventHandler = new CommonBindingAdapter.Builder().setLayoutId(R.layout.espeon_equalizer_item).setEventHandler((Object) this);
        EqualizerViewModel equalizerViewModel3 = this.viewModel;
        if (equalizerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            equalizerViewModel2 = equalizerViewModel3;
        }
        recyclerView.setAdapter(eventHandler.setDataList(equalizerViewModel2.getEqualizerTypes()).build());
        getMBinding().vRadar.setChangeListener(this);
        this.hdacWarningViewModel.getTitle().set(getString(R.string.attention));
        this.hdacWarningViewModel.getMsg().set(getString(R.string.unavailable_msg, new Object[]{"Dirac Opteo", "LDAC"}));
        this.hdacWarningViewModel.getPositionBtn().set(getString(R.string.okay));
        this.hdacWarningViewModel.getNegativeVisible().set(false);
        this.hdacWarningViewModel.getSureButtonColor().set(ContextCompat.getColor(equalizerActivity, R.color.nt_F0F2F2_06080A));
        this.hdacWarningViewModel.getSureButtonTextColor().set(ContextCompat.getColor(equalizerActivity, R.color.nt_06080A_F0F2F2));
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitObserver(EspeonEqualizerActivityBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.onInitObserver(binding);
        EqualizerViewModel equalizerViewModel = this.viewModel;
        EqualizerViewModel equalizerViewModel2 = null;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        EqualizerActivity equalizerActivity = this;
        equalizerViewModel.getCustomEqState().observe(equalizerActivity, new EqualizerActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.espeon.equalizer.EqualizerActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EqualizerActivity.onInitObserver$lambda$4(this.f$0, (List) obj);
            }
        }));
        EqualizerViewModel equalizerViewModel3 = this.viewModel;
        if (equalizerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            equalizerViewModel2 = equalizerViewModel3;
        }
        equalizerViewModel2.getNeedHDACWarning().observe(equalizerActivity, new EqualizerActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.espeon.equalizer.EqualizerActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EqualizerActivity.onInitObserver$lambda$7(this.f$0, (WarnEqualizerTypeViewModel) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$4(EqualizerActivity equalizerActivity, List list) {
        if (list != null) {
            equalizerActivity.getMBinding().vRadar.setRadarList(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$7(final EqualizerActivity equalizerActivity, WarnEqualizerTypeViewModel warnEqualizerTypeViewModel) {
        IOTProductDevice productByModelId;
        if (warnEqualizerTypeViewModel != null && warnEqualizerTypeViewModel.getWarning() && (productByModelId = IOTDeviceManager.INSTANCE.getProductByModelId(SpUtils.INSTANCE.getCurrentModel())) != null && productByModelId.hldcOrDiracOne()) {
            ConfirmMsgDialog confirmMsgDialog = equalizerActivity.hdacWarningDialog;
            if (confirmMsgDialog == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hdacWarningDialog");
                confirmMsgDialog = null;
            }
            confirmMsgDialog.show(equalizerActivity, equalizerActivity.hdacWarningViewModel, new Function0() { // from class: com.nothing.espeon.equalizer.EqualizerActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EqualizerActivity.onInitObserver$lambda$7$lambda$5(this.f$0);
                }
            }, new Function0() { // from class: com.nothing.espeon.equalizer.EqualizerActivity$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EqualizerActivity.onInitObserver$lambda$7$lambda$6(this.f$0);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$7$lambda$5(EqualizerActivity equalizerActivity) {
        ConfirmMsgDialog confirmMsgDialog = equalizerActivity.hdacWarningDialog;
        if (confirmMsgDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hdacWarningDialog");
            confirmMsgDialog = null;
        }
        confirmMsgDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$7$lambda$6(EqualizerActivity equalizerActivity) {
        ConfirmMsgDialog confirmMsgDialog = equalizerActivity.hdacWarningDialog;
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
        EqualizerViewModel equalizerViewModel = this.viewModel;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        equalizerViewModel.setEQMode(typeViewModel);
    }

    @Override // com.nothing.base.wiget.radar.OnEQChangeListener
    public void onChange(int index, int value) {
        EqualizerViewModel equalizerViewModel = this.viewModel;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        equalizerViewModel.setCustomEQ(index);
    }
}
