package com.nothing.ear.one.control.os;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.ear.one.control.ControlItemViewModel;
import com.nothing.ear.one.control.ControlViewModel;
import com.nothing.earbase.control.BaseControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.earbase.os.control.ControlOperationActivity;
import com.nothing.earbase.os.control.OsControlActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EarOneControlOperationActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/nothing/ear/one/control/os/EarOneControlOperationActivity;", "Lcom/nothing/earbase/os/control/ControlOperationActivity;", "<init>", "()V", "getControlViewModel", "Lcom/nothing/earbase/control/BaseControlViewModel;", "createGestureViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "operation", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarOneControlOperationActivity extends ControlOperationActivity {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: EarOneControlOperationActivity.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/ear/one/control/os/EarOneControlOperationActivity$Companion;", "", "<init>", "()V", "start", "", "bundle", "Landroid/os/Bundle;", "context", "Lcom/nothing/earbase/os/control/OsControlActivity;", "options", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "isLeft", "", "(Landroid/os/Bundle;Lcom/nothing/earbase/os/control/OsControlActivity;Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;Ljava/lang/Boolean;)V", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
            Intent intent = new Intent(context, (Class<?>) EarOneControlOperationActivity.class);
            intent.putExtras(bundle);
            context.getResultLauncher().launcher(intent, new Function1() { // from class: com.nothing.ear.one.control.os.EarOneControlOperationActivity$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarOneControlOperationActivity.Companion.start$lambda$0(context, (ActivityResult) obj);
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
}
