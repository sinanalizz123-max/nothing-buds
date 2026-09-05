package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import kotlin.Metadata;

/* JADX INFO: compiled from: HapticFeedback.android.kt */
/* JADX INFO: loaded from: /tmp/source/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/DefaultHapticFeedback;", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "performHapticFeedback", "", "hapticFeedbackType", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "performHapticFeedback-CdsT49E", "(I)V", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DefaultHapticFeedback implements HapticFeedback {
    public static final int $stable = 8;
    private final View view;

    public DefaultHapticFeedback(View view) {
        this.view = view;
    }

    @Override // androidx.compose.ui.hapticfeedback.HapticFeedback
    /* JADX INFO: renamed from: performHapticFeedback-CdsT49E */
    public void mo1745performHapticFeedbackCdsT49E(int hapticFeedbackType) {
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1753getConfirm5zf0vsI())) {
            this.view.performHapticFeedback(16);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1754getContextClick5zf0vsI())) {
            this.view.performHapticFeedback(6);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1755getGestureEnd5zf0vsI())) {
            this.view.performHapticFeedback(13);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1756getGestureThresholdActivate5zf0vsI())) {
            this.view.performHapticFeedback(23);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1757getLongPress5zf0vsI())) {
            this.view.performHapticFeedback(0);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1758getReject5zf0vsI())) {
            this.view.performHapticFeedback(17);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1759getSegmentFrequentTick5zf0vsI())) {
            this.view.performHapticFeedback(27);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1760getSegmentTick5zf0vsI())) {
            this.view.performHapticFeedback(26);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1761getTextHandleMove5zf0vsI())) {
            this.view.performHapticFeedback(9);
            return;
        }
        if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1762getToggleOff5zf0vsI())) {
            this.view.performHapticFeedback(22);
        } else if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1763getToggleOn5zf0vsI())) {
            this.view.performHapticFeedback(21);
        } else if (HapticFeedbackType.m1749equalsimpl0(hapticFeedbackType, HapticFeedbackType.INSTANCE.m1764getVirtualKey5zf0vsI())) {
            this.view.performHapticFeedback(1);
        }
    }
}
