package androidx.compose.ui.hapticfeedback;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: HapticFeedbackType.kt */
/* JADX INFO: loaded from: /tmp/source/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003H\u00d6\u0001\u00a2\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004\u00a2\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u00a8\u0006\u0012"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class HapticFeedbackType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int value;

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m1746boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m1747constructorimpl(int i) {
        return i;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m1748equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).getValue();
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1749equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m1750hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object obj) {
        return m1748equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1750hashCodeimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    public String toString() {
        return m1751toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m1751toStringimpl(int i) {
        Companion companion = INSTANCE;
        if (m1749equalsimpl0(i, companion.m1753getConfirm5zf0vsI())) {
            return "Confirm";
        }
        if (m1749equalsimpl0(i, companion.m1754getContextClick5zf0vsI())) {
            return "ContextClick";
        }
        if (m1749equalsimpl0(i, companion.m1755getGestureEnd5zf0vsI())) {
            return "GestureEnd";
        }
        if (m1749equalsimpl0(i, companion.m1756getGestureThresholdActivate5zf0vsI())) {
            return "GestureThresholdActivate";
        }
        if (m1749equalsimpl0(i, companion.m1757getLongPress5zf0vsI())) {
            return "LongPress";
        }
        if (m1749equalsimpl0(i, companion.m1758getReject5zf0vsI())) {
            return "Reject";
        }
        if (m1749equalsimpl0(i, companion.m1759getSegmentFrequentTick5zf0vsI())) {
            return "SegmentFrequentTick";
        }
        if (m1749equalsimpl0(i, companion.m1760getSegmentTick5zf0vsI())) {
            return "SegmentTick";
        }
        if (m1749equalsimpl0(i, companion.m1761getTextHandleMove5zf0vsI())) {
            return "TextHandleMove";
        }
        if (m1749equalsimpl0(i, companion.m1762getToggleOff5zf0vsI())) {
            return "ToggleOff";
        }
        if (m1749equalsimpl0(i, companion.m1763getToggleOn5zf0vsI())) {
            return "ToggleOn";
        }
        return m1749equalsimpl0(i, companion.m1764getVirtualKey5zf0vsI()) ? "VirtualKey" : "Invalid";
    }

    /* JADX INFO: compiled from: HapticFeedbackType.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eR\u0017\u0010\u0003\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0017\u0010\u000f\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006R\u0017\u0010\u0011\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0017\u0010\u0013\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R\u0017\u0010\u0015\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0006R\u0017\u0010\u0017\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006R\u0017\u0010\u0019\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0006R\u0017\u0010\u001b\u001a\u00020\u00048F\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u0006\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006\u001f"}, d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "()V", "Confirm", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getConfirm-5zf0vsI", "()I", "ContextClick", "getContextClick-5zf0vsI", "GestureEnd", "getGestureEnd-5zf0vsI", "GestureThresholdActivate", "getGestureThresholdActivate-5zf0vsI", "LongPress", "getLongPress-5zf0vsI", "Reject", "getReject-5zf0vsI", "SegmentFrequentTick", "getSegmentFrequentTick-5zf0vsI", "SegmentTick", "getSegmentTick-5zf0vsI", "TextHandleMove", "getTextHandleMove-5zf0vsI", "ToggleOff", "getToggleOff-5zf0vsI", "ToggleOn", "getToggleOn-5zf0vsI", "VirtualKey", "getVirtualKey-5zf0vsI", "values", "", "ui_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: getConfirm-5zf0vsI, reason: not valid java name */
        public final int m1753getConfirm5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1765getConfirm5zf0vsI();
        }

        /* JADX INFO: renamed from: getContextClick-5zf0vsI, reason: not valid java name */
        public final int m1754getContextClick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1766getContextClick5zf0vsI();
        }

        /* JADX INFO: renamed from: getGestureEnd-5zf0vsI, reason: not valid java name */
        public final int m1755getGestureEnd5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1767getGestureEnd5zf0vsI();
        }

        /* JADX INFO: renamed from: getGestureThresholdActivate-5zf0vsI, reason: not valid java name */
        public final int m1756getGestureThresholdActivate5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1768getGestureThresholdActivate5zf0vsI();
        }

        /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
        public final int m1757getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1769getLongPress5zf0vsI();
        }

        /* JADX INFO: renamed from: getReject-5zf0vsI, reason: not valid java name */
        public final int m1758getReject5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1770getReject5zf0vsI();
        }

        /* JADX INFO: renamed from: getSegmentFrequentTick-5zf0vsI, reason: not valid java name */
        public final int m1759getSegmentFrequentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1771getSegmentFrequentTick5zf0vsI();
        }

        /* JADX INFO: renamed from: getSegmentTick-5zf0vsI, reason: not valid java name */
        public final int m1760getSegmentTick5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1772getSegmentTick5zf0vsI();
        }

        /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
        public final int m1761getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1773getTextHandleMove5zf0vsI();
        }

        /* JADX INFO: renamed from: getToggleOff-5zf0vsI, reason: not valid java name */
        public final int m1762getToggleOff5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1774getToggleOff5zf0vsI();
        }

        /* JADX INFO: renamed from: getToggleOn-5zf0vsI, reason: not valid java name */
        public final int m1763getToggleOn5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1775getToggleOn5zf0vsI();
        }

        /* JADX INFO: renamed from: getVirtualKey-5zf0vsI, reason: not valid java name */
        public final int m1764getVirtualKey5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m1776getVirtualKey5zf0vsI();
        }

        public final List<HapticFeedbackType> values() {
            return CollectionsKt.listOf((Object[]) new HapticFeedbackType[]{HapticFeedbackType.m1746boximpl(m1753getConfirm5zf0vsI()), HapticFeedbackType.m1746boximpl(m1754getContextClick5zf0vsI()), HapticFeedbackType.m1746boximpl(m1755getGestureEnd5zf0vsI()), HapticFeedbackType.m1746boximpl(m1756getGestureThresholdActivate5zf0vsI()), HapticFeedbackType.m1746boximpl(m1757getLongPress5zf0vsI()), HapticFeedbackType.m1746boximpl(m1758getReject5zf0vsI()), HapticFeedbackType.m1746boximpl(m1759getSegmentFrequentTick5zf0vsI()), HapticFeedbackType.m1746boximpl(m1760getSegmentTick5zf0vsI()), HapticFeedbackType.m1746boximpl(m1761getTextHandleMove5zf0vsI()), HapticFeedbackType.m1746boximpl(m1762getToggleOff5zf0vsI()), HapticFeedbackType.m1746boximpl(m1763getToggleOn5zf0vsI()), HapticFeedbackType.m1746boximpl(m1764getVirtualKey5zf0vsI())});
        }
    }
}
