package com.nothing.crobat.control.os;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.crobat.control.ControlItemViewModel;
import com.nothing.crobat.control.ControlViewModel;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.os.control.ControlOperationActivity;
import com.nothing.earbase.os.control.OsControlActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CrobatControlOperationActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/crobat/control/os/CrobatControlOperationActivity;", "Lcom/nothing/earbase/os/control/ControlOperationActivity;", "<init>", "()V", "getControlViewModel", "Lcom/nothing/earbase/control/BaseControlViewModel;", "createGestureViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "onClickTransparency", "", "dialogItemViewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "itemViewModel", "onClickNoiseCancellation", "onClickOff", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CrobatControlOperationActivity extends ControlOperationActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: CrobatControlOperationActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/crobat/control/os/CrobatControlOperationActivity$Companion;", "", "<init>", "()V", "start", "", "bundle", "Landroid/os/Bundle;", "context", "Lcom/nothing/earbase/os/control/OsControlActivity;", "options", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "isLeft", "", "(Landroid/os/Bundle;Lcom/nothing/earbase/os/control/OsControlActivity;Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Ljava/lang/Boolean;)V", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void start(Bundle bundle, final OsControlActivity context, ControlConfigurationEntity.Operation options, Boolean isLeft) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(context, "context");
            bundle.putParcelable(ControlOperationActivity.ITEM_DATA, options);
            bundle.putBoolean(ControlOperationActivity.IS_LEFT, isLeft != null ? isLeft.booleanValue() : true);
            Intent intent = new Intent(context, (Class<?>) CrobatControlOperationActivity.class);
            intent.putExtras(bundle);
            context.getResultLauncher().launcher(intent, new Function1() { // from class: com.nothing.crobat.control.os.CrobatControlOperationActivity$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CrobatControlOperationActivity.Companion.start$lambda$0(context, (ActivityResult) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit start$lambda$0(OsControlActivity osControlActivity, ActivityResult it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (it.getResultCode() == -1) {
                osControlActivity.onResult(it.getData());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public BaseControlViewModel getControlViewModel() {
        return (BaseControlViewModel) new ViewModelProvider(this).get(ControlViewModel.class);
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public ControlGestureViewModel createGestureViewModel(ControlConfigurationEntity.Operation operation) {
        Intrinsics.checkNotNullParameter(operation, "operation");
        return new ControlItemViewModel(operation, this, getViewModel().getAddress());
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public boolean onClickTransparency(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int transparency = dialogItemViewModel.toTransparency();
        if (getViewModel() instanceof ControlViewModel) {
            BaseControlViewModel viewModel = getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.crobat.control.ControlViewModel");
            ((ControlViewModel) viewModel).setAncGestureData((ControlItemViewModel) itemViewModel, transparency, dialogItemViewModel);
        }
        return transparency != 0;
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public boolean onClickNoiseCancellation(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int noiseCancellation = dialogItemViewModel.toNoiseCancellation();
        if (getViewModel() instanceof ControlViewModel) {
            BaseControlViewModel viewModel = getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.crobat.control.ControlViewModel");
            ((ControlViewModel) viewModel).setAncGestureData((ControlItemViewModel) itemViewModel, noiseCancellation, dialogItemViewModel);
        }
        return noiseCancellation != 0;
    }

    @Override // com.nothing.earbase.os.control.ControlOperationActivity
    public boolean onClickOff(ControlOperationViewModel dialogItemViewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(dialogItemViewModel, "dialogItemViewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        int off = dialogItemViewModel.toOff();
        if (getViewModel() instanceof ControlViewModel) {
            BaseControlViewModel viewModel = getViewModel();
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type com.nothing.crobat.control.ControlViewModel");
            ((ControlViewModel) viewModel).setAncGestureData((ControlItemViewModel) itemViewModel, off, dialogItemViewModel);
        }
        return off != 0;
    }
}
