package com.nothing.espeon.control.os;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.base.view.BaseConfig;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.os.control.ControlOperationActivity;
import com.nothing.earbase.os.control.OsControlActivity;
import com.nothing.espeon.control.ControlViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EspeonControlActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/espeon/control/os/EspeonControlActivity;", "Lcom/nothing/earbase/os/control/OsControlActivity;", "<init>", "()V", "getControlViewModel", "Lcom/nothing/espeon/control/ControlViewModel;", "createContentConfig", "", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "refreshGestureData", "viewModel", "Lcom/nothing/earbase/control/BaseControlViewModel;", "isLeft", "", "startToOperationActivity", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EspeonControlActivity extends OsControlActivity {
    @Override // com.nothing.earbase.os.control.OsControlActivity
    public ControlViewModel getControlViewModel() {
        return (ControlViewModel) new ViewModelProvider(this).get(ControlViewModel.class);
    }

    @Override // com.nothing.earbase.os.control.OsControlActivity, com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createContentConfig(contentConfig);
        getOsViewModel().setTripleButton();
    }

    @Override // com.nothing.earbase.os.control.OsControlActivity
    public void refreshGestureData(BaseControlViewModel viewModel, boolean isLeft) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        if (getOsViewModel().isCase()) {
            refreshCaseGestureData(viewModel);
        } else {
            super.refreshGestureData(viewModel, isLeft);
        }
    }

    @Override // com.nothing.earbase.os.control.OsControlActivity
    public void startToOperationActivity(ControlGestureViewModel itemViewModel) {
        Class cls;
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        extras.putParcelable(ControlOperationActivity.ITEM_DATA, itemViewModel.getOptions());
        Boolean bool = itemViewModel.isLeft().get();
        extras.putBoolean(ControlOperationActivity.IS_LEFT, bool != null ? bool.booleanValue() : true);
        if (Intrinsics.areEqual((Object) itemViewModel.isCase().get(), (Object) true)) {
            cls = EspeonCaseControlOperationActivity.class;
        } else {
            cls = EspeonControlOperationActivity.class;
        }
        Intent intent = new Intent(this, (Class<?>) cls);
        intent.putExtras(extras);
        getResultLauncher().launcher(intent, new Function1() { // from class: com.nothing.espeon.control.os.EspeonControlActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EspeonControlActivity.startToOperationActivity$lambda$0(this.f$0, (ActivityResult) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startToOperationActivity$lambda$0(EspeonControlActivity espeonControlActivity, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.getResultCode() == -1) {
            espeonControlActivity.onResult(it.getData());
        }
        return Unit.INSTANCE;
    }
}
