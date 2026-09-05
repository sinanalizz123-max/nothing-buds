package com.nothing.girafarig.equalizer.os;

import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.view.BaseActivity;
import com.nothing.ear.R;
import com.nothing.ear.databinding.OsEqualizerActivityBinding;
import com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel;
import com.nothing.earbase.os.equalizer.OsEqualizerActivity;
import com.nothing.girafarig.equalizer.DiracEQGuideDialog;
import com.nothing.girafarig.equalizer.EqualizerViewModel;
import com.nothing.girafarig.equalizer.WarnEqualizerTypeViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: GirafarigEqualizerActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/nothing/girafarig/equalizer/os/GirafarigEqualizerActivity;", "Lcom/nothing/earbase/os/equalizer/OsEqualizerActivity;", "<init>", "()V", "diracEQGuideDialog", "Lcom/nothing/girafarig/equalizer/DiracEQGuideDialog;", "hdacWarningViewModel", "Lcom/nothing/base/dialog/confirm/ConfirmMsgViewModel;", "createEqualizerViewModel", "Lcom/nothing/earbase/equalizer/viewmodel/BaseEqualizerViewModel;", "initActionView", "", "onInitObserver", "binding", "Lcom/nothing/ear/databinding/OsEqualizerActivityBinding;", "onDestroy", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GirafarigEqualizerActivity extends OsEqualizerActivity {
    private DiracEQGuideDialog diracEQGuideDialog;
    private final ConfirmMsgViewModel hdacWarningViewModel = new ConfirmMsgViewModel();

    @Override // com.nothing.earbase.os.equalizer.OsEqualizerActivity
    public BaseEqualizerViewModel createEqualizerViewModel() {
        ViewModel viewModel = new ViewModelProvider(this).get((Class<ViewModel>) EqualizerViewModel.class);
        ((EqualizerViewModel) viewModel).setSampleDesignSize(366.0f);
        return (BaseEqualizerViewModel) viewModel;
    }

    @Override // com.nothing.earbase.os.equalizer.OsEqualizerActivity
    public void initActionView() {
        super.initActionView();
        getMBinding().myAction.setRightIcon(R.drawable.explan_info_icon);
        getMBinding().myAction.getRight().setOnClickListener(new View.OnClickListener() { // from class: com.nothing.girafarig.equalizer.os.GirafarigEqualizerActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GirafarigEqualizerActivity.initActionView$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initActionView$lambda$3(GirafarigEqualizerActivity girafarigEqualizerActivity, View view) {
        DiracEQGuideDialog diracEQGuideDialog;
        DiracEQGuideDialog diracEQGuideDialog2 = girafarigEqualizerActivity.diracEQGuideDialog;
        if (diracEQGuideDialog2 != null) {
            diracEQGuideDialog2.dismiss();
        }
        girafarigEqualizerActivity.diracEQGuideDialog = new DiracEQGuideDialog();
        if (!(girafarigEqualizerActivity.getViewModel() instanceof EqualizerViewModel) || (diracEQGuideDialog = girafarigEqualizerActivity.diracEQGuideDialog) == null) {
            return;
        }
        GirafarigEqualizerActivity girafarigEqualizerActivity2 = girafarigEqualizerActivity;
        BaseEqualizerViewModel viewModel = girafarigEqualizerActivity.getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.girafarig.equalizer.EqualizerViewModel");
        diracEQGuideDialog.show(girafarigEqualizerActivity2, (EqualizerViewModel) viewModel, new Function0() { // from class: com.nothing.girafarig.equalizer.os.GirafarigEqualizerActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        }, new Function0() { // from class: com.nothing.girafarig.equalizer.os.GirafarigEqualizerActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.nothing.earbase.os.equalizer.OsEqualizerActivity, com.nothing.base.view.BaseActivity
    public void onInitObserver(OsEqualizerActivityBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.onInitObserver(binding);
        if (getViewModel() instanceof EqualizerViewModel) {
            BaseEqualizerViewModel viewModel = getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.girafarig.equalizer.EqualizerViewModel");
            ((EqualizerViewModel) viewModel).getNeedHDACWarning().observe(this, new GirafarigEqualizerActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.girafarig.equalizer.os.GirafarigEqualizerActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return GirafarigEqualizerActivity.onInitObserver$lambda$5(this.f$0, (WarnEqualizerTypeViewModel) obj);
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$5(GirafarigEqualizerActivity girafarigEqualizerActivity, WarnEqualizerTypeViewModel warnEqualizerTypeViewModel) {
        if (warnEqualizerTypeViewModel != null && warnEqualizerTypeViewModel.getWarning()) {
            girafarigEqualizerActivity.hdacWarningViewModel.getPositionBtn().set(girafarigEqualizerActivity.getString(R.string.okay));
            girafarigEqualizerActivity.hdacWarningViewModel.getTitle().set(girafarigEqualizerActivity.getString(R.string.attention));
            girafarigEqualizerActivity.hdacWarningViewModel.getNegativeVisible().set(false);
            girafarigEqualizerActivity.hdacWarningViewModel.getMsg().set(girafarigEqualizerActivity.getString(R.string.unavailable_msg, new Object[]{"Dirac Opteo", "LDAC"}));
            BaseActivity.showConfirmMsgDialog$default(girafarigEqualizerActivity, girafarigEqualizerActivity.hdacWarningViewModel, new Function0() { // from class: com.nothing.girafarig.equalizer.os.GirafarigEqualizerActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            }, null, null, false, 28, null);
        }
        return Unit.INSTANCE;
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        DiracEQGuideDialog diracEQGuideDialog = this.diracEQGuideDialog;
        if (diracEQGuideDialog != null) {
            diracEQGuideDialog.dismiss();
        }
        super.onDestroy();
    }
}
