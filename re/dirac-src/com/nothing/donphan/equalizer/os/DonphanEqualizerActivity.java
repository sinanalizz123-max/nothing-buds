package com.nothing.donphan.equalizer.os;

import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.donphan.equalizer.DiracEQGuideDialog;
import com.nothing.donphan.equalizer.EqualizerViewModel;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel;
import com.nothing.earbase.os.equalizer.OsEqualizerActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DonphanEqualizerActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0014R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/nothing/donphan/equalizer/os/DonphanEqualizerActivity;", "Lcom/nothing/earbase/os/equalizer/OsEqualizerActivity;", "<init>", "()V", "diracEQGuideDialog", "Lcom/nothing/donphan/equalizer/DiracEQGuideDialog;", "createEqualizerViewModel", "Lcom/nothing/earbase/equalizer/viewmodel/BaseEqualizerViewModel;", "initActionView", "", "onDestroy", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DonphanEqualizerActivity extends OsEqualizerActivity {
    private DiracEQGuideDialog diracEQGuideDialog;

    @Override // com.nothing.earbase.os.equalizer.OsEqualizerActivity
    public BaseEqualizerViewModel createEqualizerViewModel() {
        ViewModel viewModel = new ViewModelProvider(this).get((Class<ViewModel>) EqualizerViewModel.class);
        EqualizerViewModel equalizerViewModel = (EqualizerViewModel) viewModel;
        equalizerViewModel.setPowerByTextBuilder(this);
        equalizerViewModel.setSampleDesignSize(366.0f);
        return (BaseEqualizerViewModel) viewModel;
    }

    @Override // com.nothing.earbase.os.equalizer.OsEqualizerActivity
    public void initActionView() {
        super.initActionView();
        getMBinding().myAction.setRightIcon(R.drawable.explan_info_icon);
        getMBinding().myAction.getRight().setOnClickListener(new View.OnClickListener() { // from class: com.nothing.donphan.equalizer.os.DonphanEqualizerActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DonphanEqualizerActivity.initActionView$lambda$3(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initActionView$lambda$3(DonphanEqualizerActivity donphanEqualizerActivity, View view) {
        DiracEQGuideDialog diracEQGuideDialog;
        DiracEQGuideDialog diracEQGuideDialog2 = donphanEqualizerActivity.diracEQGuideDialog;
        if (diracEQGuideDialog2 != null) {
            diracEQGuideDialog2.dismiss();
        }
        donphanEqualizerActivity.diracEQGuideDialog = new DiracEQGuideDialog();
        if (!(donphanEqualizerActivity.getViewModel() instanceof EqualizerViewModel) || (diracEQGuideDialog = donphanEqualizerActivity.diracEQGuideDialog) == null) {
            return;
        }
        DonphanEqualizerActivity donphanEqualizerActivity2 = donphanEqualizerActivity;
        BaseEqualizerViewModel viewModel = donphanEqualizerActivity.getViewModel();
        Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.donphan.equalizer.EqualizerViewModel");
        diracEQGuideDialog.show(donphanEqualizerActivity2, (EqualizerViewModel) viewModel, new Function0() { // from class: com.nothing.donphan.equalizer.os.DonphanEqualizerActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Unit.INSTANCE;
            }
        }, new Function0() { // from class: com.nothing.donphan.equalizer.os.DonphanEqualizerActivity$$ExternalSyntheticLambda1
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
}
