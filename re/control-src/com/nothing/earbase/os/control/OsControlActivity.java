package com.nothing.earbase.os.control;

import android.content.Intent;
import android.os.Bundle;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.nothing.base.adapter.CommonBindingMoreAdapter;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.recycleview.WrapContentLinearLayoutManager;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.base.view.ActionViewConfig;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.OsControlActivityBinding;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlNotCustomisableViewModel;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OsControlActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 72\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"J\b\u0010#\u001a\u00020\bH\u0016J\u0012\u0010$\u001a\u00020\u00162\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u000e\u0010'\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u0014J\b\u0010)\u001a\u00020\u0016H\u0016J\u000e\u0010*\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010+\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010,\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010-\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0002H\u0016J\b\u00100\u001a\u00020\u0016H\u0016J\u0018\u00101\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0014H\u0016J\u001c\u00103\u001a\b\u0012\u0004\u0012\u000205042\f\u00106\u001a\b\u0012\u0004\u0012\u00020504H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u00068"}, d2 = {"Lcom/nothing/earbase/os/control/OsControlActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/OsControlActivityBinding;", "<init>", "()V", "adapter", "Lcom/nothing/base/adapter/CommonBindingMoreAdapter;", "viewModel", "Lcom/nothing/earbase/control/BaseControlViewModel;", "getViewModel", "()Lcom/nothing/earbase/control/BaseControlViewModel;", "setViewModel", "(Lcom/nothing/earbase/control/BaseControlViewModel;)V", "osViewModel", "Lcom/nothing/earbase/os/control/OsControlViewModel;", "getOsViewModel", "()Lcom/nothing/earbase/os/control/OsControlViewModel;", "setOsViewModel", "(Lcom/nothing/earbase/os/control/OsControlViewModel;)V", "isSystemPage", "", "createActionViewConfig", "", "contentConfig", "Lcom/nothing/base/view/ActionViewConfig;", "createContentConfig", "Lcom/nothing/base/view/BaseConfig;", "dotShowNavbarHeightPadding", "onClickItem", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "startToOperationActivity", "onResult", "data", "Landroid/content/Intent;", "getControlViewModel", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "showRestIcon", "isShow", "rightLabelClickEvent", "onClickLeftBuds", "onClickRightBuds", "onClickCaseBuds", "refreshCaseGestureData", "onInitObserver", "binding", "setDefaultSelectBuds", "refreshGestureData", "isLeft", "convertOsAdapterList", "Landroidx/databinding/ObservableArrayList;", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "list", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class OsControlActivity extends BaseActivity<OsControlActivityBinding> {
    public static final String IS_LEFT_SELECTED = "IS_LEFT_SELECTED";
    private CommonBindingMoreAdapter adapter;
    public OsControlViewModel osViewModel;
    public BaseControlViewModel viewModel;

    @Override // com.nothing.base.view.BaseActivity
    public boolean dotShowNavbarHeightPadding() {
        return true;
    }

    @Override // com.nothing.base.view.BaseActivity
    public boolean isSystemPage() {
        return true;
    }

    public void startToOperationActivity(ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
    }

    public final BaseControlViewModel getViewModel() {
        BaseControlViewModel baseControlViewModel = this.viewModel;
        if (baseControlViewModel != null) {
            return baseControlViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(BaseControlViewModel baseControlViewModel) {
        Intrinsics.checkNotNullParameter(baseControlViewModel, "<set-?>");
        this.viewModel = baseControlViewModel;
    }

    public final OsControlViewModel getOsViewModel() {
        OsControlViewModel osControlViewModel = this.osViewModel;
        if (osControlViewModel != null) {
            return osControlViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("osViewModel");
        return null;
    }

    public final void setOsViewModel(OsControlViewModel osControlViewModel) {
        Intrinsics.checkNotNullParameter(osControlViewModel, "<set-?>");
        this.osViewModel = osControlViewModel;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createActionViewConfig(ActionViewConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createActionViewConfig(contentConfig);
        contentConfig.setSubTitle(ContextExtKt.getLocalizedResources(this).getString(R.string.os_device_gesture_controls));
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        setViewModel(getControlViewModel());
        getViewModel().setSystem(true);
        setOsViewModel((OsControlViewModel) new ViewModelProvider(this).get(OsControlViewModel.class));
        getViewModel().register(getIntent().getExtras());
        this.adapter = new ControlMoreAdapter(new CommonBindingMoreAdapter.Builder().addViewType(R.layout.os_control_item, new CommonBindingMoreAdapter.Builder.ItemBuilder().setEventHandler((Object) this)).addViewType(R.layout.os_control_not_custom_item, new CommonBindingMoreAdapter.Builder.ItemBuilder().setEventHandler((Object) this)).addViewType(R.layout.os_control_navivation_item, new CommonBindingMoreAdapter.Builder.ItemBuilder().setEventHandler((Object) this)).addViewType(R.layout.os_control_title_item, new CommonBindingMoreAdapter.Builder.ItemBuilder().setEventHandler((Object) this)));
        contentConfig.setLayoutId(R.layout.os_control_activity).addVariable(BR.viewModel, getOsViewModel()).addVariable(BR.eventHandler, this);
    }

    public final void onClickItem(ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        getViewModel().setSelectedItem(itemViewModel);
        startToOperationActivity(itemViewModel);
    }

    public final void onResult(Intent data) {
        getViewModel().getGestureData(true);
    }

    public BaseControlViewModel getControlViewModel() {
        return (BaseControlViewModel) new ViewModelProvider(this).get(BaseControlViewModel.class);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        getActionBarBinding().headerBar.setRightIcon(R.drawable.os_control_reset);
        getActionBarBinding().headerBar.getRightLabel().setVisibility(8);
        getMBinding().rvControl.setLayoutManager(new WrapContentLinearLayoutManager(this));
        RecyclerView recyclerView = getMBinding().rvControl;
        CommonBindingMoreAdapter commonBindingMoreAdapter = this.adapter;
        if (commonBindingMoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            commonBindingMoreAdapter = null;
        }
        recyclerView.setAdapter(commonBindingMoreAdapter);
    }

    public final void showRestIcon(boolean isShow) {
        getActionBarBinding().headerBar.getRight().setVisibility(isShow ? 0 : 8);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
        ConfirmMsgViewModel confirmMsgViewModel = new ConfirmMsgViewModel();
        OsControlActivity osControlActivity = this;
        confirmMsgViewModel.getTitle().set(ContextExtKt.getLocalizedResources(osControlActivity).getString(R.string.os_reset_gesture_controls_title));
        confirmMsgViewModel.getMsg().set(ContextExtKt.getLocalizedResources(osControlActivity).getString(R.string.os_reset_gesture_controls_summary));
        ObservableField<String> positionBtn = confirmMsgViewModel.getPositionBtn();
        String string = ContextExtKt.getLocalizedResources(osControlActivity).getString(R.string.control_reset_controls);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        positionBtn.set(DataExtKt.firstUpper(lowerCase));
        confirmMsgViewModel.getNegativeBtn().set(ContextExtKt.getLocalizedResources(osControlActivity).getString(R.string.cancel));
        BaseActivity.showConfirmMsgDialog$default(this, confirmMsgViewModel, new Function0() { // from class: com.nothing.earbase.os.control.OsControlActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OsControlActivity.rightLabelClickEvent$lambda$0(this.f$0);
            }
        }, null, null, false, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rightLabelClickEvent$lambda$0(OsControlActivity osControlActivity) {
        osControlActivity.getViewModel().resetGestureData();
        return Unit.INSTANCE;
    }

    public final void onClickLeftBuds(OsControlViewModel osViewModel) {
        Intrinsics.checkNotNullParameter(osViewModel, "osViewModel");
        osViewModel.onClickLeftEarBuds();
        refreshGestureData(getViewModel(), true);
    }

    public final void onClickRightBuds(OsControlViewModel osViewModel) {
        Intrinsics.checkNotNullParameter(osViewModel, "osViewModel");
        osViewModel.onClickRightEarBuds();
        refreshGestureData(getViewModel(), false);
    }

    public final void onClickCaseBuds(OsControlViewModel osViewModel) {
        Intrinsics.checkNotNullParameter(osViewModel, "osViewModel");
        osViewModel.onClickCaseEarBuds();
        refreshCaseGestureData(getViewModel());
    }

    public final void refreshCaseGestureData(BaseControlViewModel viewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        ObservableArrayList<CommonBindingMoreType> observableArrayListConvertOsAdapterList = convertOsAdapterList(viewModel.getCaseGestureData());
        CommonBindingMoreAdapter commonBindingMoreAdapter = this.adapter;
        if (commonBindingMoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            commonBindingMoreAdapter = null;
        }
        commonBindingMoreAdapter.refreshData(observableArrayListConvertOsAdapterList);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitObserver(OsControlActivityBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.onInitObserver(binding);
        setDefaultSelectBuds();
        getViewModel().getDataUpdate().observe(this, new OsControlActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.earbase.os.control.OsControlActivity$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OsControlActivity.onInitObserver$lambda$1(this.f$0, (Pair) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$1(OsControlActivity osControlActivity, Pair pair) {
        if (pair != null) {
            if (((Number) pair.getFirst()).intValue() == 1) {
                osControlActivity.refreshGestureData(osControlActivity.getViewModel(), Intrinsics.areEqual((Object) osControlActivity.getOsViewModel().getLeftSelected().get(), (Object) true));
            }
            if (((Number) pair.getFirst()).intValue() == 4 && osControlActivity.getOsViewModel().isCase()) {
                osControlActivity.refreshGestureData(osControlActivity.getViewModel(), false);
            }
            osControlActivity.showRestIcon(((Boolean) pair.getSecond()).booleanValue());
        }
        return Unit.INSTANCE;
    }

    public void setDefaultSelectBuds() {
        getOsViewModel().onClickLeftEarBuds();
    }

    public void refreshGestureData(BaseControlViewModel viewModel, boolean isLeft) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        ObservableArrayList<CommonBindingMoreType> observableArrayListConvertOsAdapterList = convertOsAdapterList(isLeft ? viewModel.getLeftGestureData() : viewModel.getRightGestureData());
        CommonBindingMoreAdapter commonBindingMoreAdapter = this.adapter;
        if (commonBindingMoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            commonBindingMoreAdapter = null;
        }
        commonBindingMoreAdapter.refreshData(observableArrayListConvertOsAdapterList);
    }

    private final ObservableArrayList<CommonBindingMoreType> convertOsAdapterList(ObservableArrayList<CommonBindingMoreType> list) {
        ObservableArrayList<CommonBindingMoreType> observableArrayList = new ObservableArrayList<>();
        for (CommonBindingMoreType commonBindingMoreType : list) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                observableArrayList.add(commonBindingMoreType);
            } else if (commonBindingMoreType instanceof TitleViewModel) {
                observableArrayList.add(commonBindingMoreType);
            } else if (commonBindingMoreType instanceof ControlNotCustomisableViewModel) {
                observableArrayList.add(commonBindingMoreType);
                observableArrayList.addAll(((ControlNotCustomisableViewModel) commonBindingMoreType).getGestureList());
            }
        }
        observableArrayList.add(new NavigationTextViewModel());
        return observableArrayList;
    }
}
