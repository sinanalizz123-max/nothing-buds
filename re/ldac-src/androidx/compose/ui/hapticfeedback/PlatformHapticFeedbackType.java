package androidx.compose.ui.hapticfeedback;

import kotlin.Metadata;

/* JADX INFO: compiled from: PlatformHapticFeedback.android.kt */
/* JADX INFO: loaded from: /tmp/source/classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000b\u0010\u0006R\u0019\u0010\f\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0017\u0010\u0006R\u0019\u0010\u0018\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0019\u0010\u0006R\u0019\u0010\u001a\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001b\u0010\u0006R\u0019\u0010\u001c\u001a\u00020\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u001d\u0010\u0006\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u001e"}, d2 = {"Landroidx/compose/ui/hapticfeedback/PlatformHapticFeedbackType;", "", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PlatformHapticFeedbackType {
    public static final int $stable = 0;
    public static final PlatformHapticFeedbackType INSTANCE = new PlatformHapticFeedbackType();
    private static final int Confirm = HapticFeedbackType.m1747constructorimpl(16);
    private static final int ContextClick = HapticFeedbackType.m1747constructorimpl(6);
    private static final int GestureEnd = HapticFeedbackType.m1747constructorimpl(13);
    private static final int GestureThresholdActivate = HapticFeedbackType.m1747constructorimpl(23);
    private static final int LongPress = HapticFeedbackType.m1747constructorimpl(0);
    private static final int Reject = HapticFeedbackType.m1747constructorimpl(17);
    private static final int SegmentFrequentTick = HapticFeedbackType.m1747constructorimpl(27);
    private static final int SegmentTick = HapticFeedbackType.m1747constructorimpl(26);
    private static final int TextHandleMove = HapticFeedbackType.m1747constructorimpl(9);
    private static final int ToggleOff = HapticFeedbackType.m1747constructorimpl(22);
    private static final int ToggleOn = HapticFeedbackType.m1747constructorimpl(21);
    private static final int VirtualKey = HapticFeedbackType.m1747constructorimpl(1);

    private PlatformHapticFeedbackType() {
    }

    /* JADX INFO: renamed from: getConfirm-5zf0vsI, reason: not valid java name */
    public final int m1765getConfirm5zf0vsI() {
        return Confirm;
    }

    /* JADX INFO: renamed from: getContextClick-5zf0vsI, reason: not valid java name */
    public final int m1766getContextClick5zf0vsI() {
        return ContextClick;
    }

    /* JADX INFO: renamed from: getGestureEnd-5zf0vsI, reason: not valid java name */
    public final int m1767getGestureEnd5zf0vsI() {
        return GestureEnd;
    }

    /* JADX INFO: renamed from: getGestureThresholdActivate-5zf0vsI, reason: not valid java name */
    public final int m1768getGestureThresholdActivate5zf0vsI() {
        return GestureThresholdActivate;
    }

    /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
    public final int m1769getLongPress5zf0vsI() {
        return LongPress;
    }

    /* JADX INFO: renamed from: getReject-5zf0vsI, reason: not valid java name */
    public final int m1770getReject5zf0vsI() {
        return Reject;
    }

    /* JADX INFO: renamed from: getSegmentFrequentTick-5zf0vsI, reason: not valid java name */
    public final int m1771getSegmentFrequentTick5zf0vsI() {
        return SegmentFrequentTick;
    }

    /* JADX INFO: renamed from: getSegmentTick-5zf0vsI, reason: not valid java name */
    public final int m1772getSegmentTick5zf0vsI() {
        return SegmentTick;
    }

    /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
    public final int m1773getTextHandleMove5zf0vsI() {
        return TextHandleMove;
    }

    /* JADX INFO: renamed from: getToggleOff-5zf0vsI, reason: not valid java name */
    public final int m1774getToggleOff5zf0vsI() {
        return ToggleOff;
    }

    /* JADX INFO: renamed from: getToggleOn-5zf0vsI, reason: not valid java name */
    public final int m1775getToggleOn5zf0vsI() {
        return ToggleOn;
    }

    /* JADX INFO: renamed from: getVirtualKey-5zf0vsI, reason: not valid java name */
    public final int m1776getVirtualKey5zf0vsI() {
        return VirtualKey;
    }
}
