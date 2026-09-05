package defpackage;

import com.google.android.gms.stats.CodePackage;
import com.nothing.network.core.NetWorkConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NtRoutePigeon.g.kt */
/* JADX INFO: loaded from: /tmp/source/classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001cB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b\u00a8\u0006\u001d"}, d2 = {"LNativeRoute;", "", "raw", "", "<init>", "(Ljava/lang/String;II)V", "getRaw", "()I", "TEST", "FEEDBACK", "APP_STORE", "RATE_APP", "HEALTH", CodePackage.OTA, "EQUALIZER", "GESTURE", "GPT_GESTURE", "FIND_DEVICE", "DUAL_CONNECT", "FITTEST", "LHDC", "DEVICE_DETAIL", "PERSONALISED_ANC", "MIMI", "NOISE_REDUCTION", "MAGIC_BUTTON", NetWorkConstant.DEBUG, "NEWS_REPORT_ANDROID", "Companion", "nt_route_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum NativeRoute {
    TEST(0),
    FEEDBACK(1),
    APP_STORE(2),
    RATE_APP(3),
    HEALTH(4),
    OTA(5),
    EQUALIZER(6),
    GESTURE(7),
    GPT_GESTURE(8),
    FIND_DEVICE(9),
    DUAL_CONNECT(10),
    FITTEST(11),
    LHDC(12),
    DEVICE_DETAIL(13),
    PERSONALISED_ANC(14),
    MIMI(15),
    NOISE_REDUCTION(16),
    MAGIC_BUTTON(17),
    DEBUG(18),
    NEWS_REPORT_ANDROID(19);

    private final int raw;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<NativeRoute> getEntries() {
        return $ENTRIES;
    }

    NativeRoute(int i) {
        this.raw = i;
    }

    public final int getRaw() {
        return this.raw;
    }

    /* JADX INFO: compiled from: NtRoutePigeon.g.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2 = {"LNativeRoute$Companion;", "", "<init>", "()V", "ofRaw", "LNativeRoute;", "raw", "", "nt_route_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NativeRoute ofRaw(int raw) {
            for (NativeRoute nativeRoute : NativeRoute.values()) {
                if (nativeRoute.getRaw() == raw) {
                    return nativeRoute;
                }
            }
            return null;
        }
    }
}
