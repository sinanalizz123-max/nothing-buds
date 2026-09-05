package com.nothing.ear.flaffy.control.os;

import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import com.nothing.ear.flaffy.control.ControlViewModel;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.os.control.OsControlActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FlaffyControlActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/nothing/ear/flaffy/control/os/FlaffyControlActivity;", "Lcom/nothing/earbase/os/control/OsControlActivity;", "<init>", "()V", "getControlViewModel", "Lcom/nothing/ear/flaffy/control/ControlViewModel;", "startToOperationActivity", "", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlaffyControlActivity extends OsControlActivity {
    @Override // com.nothing.earbase.os.control.OsControlActivity
    public ControlViewModel getControlViewModel() {
        return (ControlViewModel) new ViewModelProvider(this).get(ControlViewModel.class);
    }

    @Override // com.nothing.earbase.os.control.OsControlActivity
    public void startToOperationActivity(ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        FlaffyControlOperationActivity.Companion companion = FlaffyControlOperationActivity.INSTANCE;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        companion.start(extras, this, itemViewModel.getOptions(), itemViewModel.isLeft().get());
    }
}
