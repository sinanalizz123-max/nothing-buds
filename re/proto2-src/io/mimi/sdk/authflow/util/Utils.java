package io.mimi.sdk.authflow.util;

import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.cardview.widget.CardView;
import io.mimi.sdk.authflow.databinding.MimiIncludeErrorViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0002J\u0011\u0010\n\u001a\u00020\u000b*\u00020\fH\u0000\u00a2\u0006\u0002\b\rJ\u001b\u0010\u000e\u001a\u00020\u000b*\u00020\f2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0000\u00a2\u0006\u0002\b\u0011\u00a8\u0006\u0012"}, d2 = {"Lio/mimi/sdk/authflow/util/Utils;", "", "()V", "animateTo", "Landroid/view/ViewPropertyAnimator;", "Landroid/view/View;", "alpha", "", "duration", "", "hideErrorView", "", "Lio/mimi/sdk/authflow/databinding/MimiIncludeErrorViewBinding;", "hideErrorView$libauthflow_release", "showErrorView", "errorMessage", "", "showErrorView$libauthflow_release", "libauthflow_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public final void showErrorView$libauthflow_release(MimiIncludeErrorViewBinding mimiIncludeErrorViewBinding, int i) {
        Intrinsics.checkNotNullParameter(mimiIncludeErrorViewBinding, "<this>");
        CardView showErrorView$lambda$0 = mimiIncludeErrorViewBinding.errorView;
        mimiIncludeErrorViewBinding.headerErrorTv.setText(i);
        Utils utils = INSTANCE;
        Intrinsics.checkNotNullExpressionValue(showErrorView$lambda$0, "showErrorView$lambda$0");
        animateTo$default(utils, showErrorView$lambda$0, 1.0f, 0L, 2, null);
    }

    public final void hideErrorView$libauthflow_release(MimiIncludeErrorViewBinding mimiIncludeErrorViewBinding) {
        Intrinsics.checkNotNullParameter(mimiIncludeErrorViewBinding, "<this>");
        CardView hideErrorView$lambda$1 = mimiIncludeErrorViewBinding.errorView;
        if (hideErrorView$lambda$1.getAlpha() == 1.0f) {
            Utils utils = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(hideErrorView$lambda$1, "hideErrorView$lambda$1");
            animateTo$default(utils, hideErrorView$lambda$1, 0.0f, 0L, 2, null);
        }
    }

    static /* synthetic */ ViewPropertyAnimator animateTo$default(Utils utils, View view, float f, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 150;
        }
        return utils.animateTo(view, f, j);
    }

    private final ViewPropertyAnimator animateTo(View view, float f, long j) {
        ViewPropertyAnimator duration = view.animate().alpha(f).setDuration(j);
        Intrinsics.checkNotNullExpressionValue(duration, "animate().alpha(alpha).setDuration(duration)");
        return duration;
    }
}
