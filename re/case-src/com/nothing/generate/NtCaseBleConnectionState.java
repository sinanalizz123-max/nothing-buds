package com.nothing.generate;

import com.nothing.xservice.XSettingsConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NtCaseBlePigeon.g.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/generate/NtCaseBleConnectionState;", "", "raw", "", "<init>", "(Ljava/lang/String;II)V", "getRaw", "()I", "IDLE", "DISCONNECTED", "CONNECTING", XSettingsConstants.CONNECTED, "FAILED", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum NtCaseBleConnectionState {
    IDLE(0),
    DISCONNECTED(1),
    CONNECTING(2),
    CONNECTED(3),
    FAILED(4);

    private final int raw;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static EnumEntries<NtCaseBleConnectionState> getEntries() {
        return $ENTRIES;
    }

    NtCaseBleConnectionState(int i) {
        this.raw = i;
    }

    public final int getRaw() {
        return this.raw;
    }

    /* JADX INFO: compiled from: NtCaseBlePigeon.g.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/generate/NtCaseBleConnectionState$Companion;", "", "<init>", "()V", "ofRaw", "Lcom/nothing/generate/NtCaseBleConnectionState;", "raw", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NtCaseBleConnectionState ofRaw(int raw) {
            for (NtCaseBleConnectionState ntCaseBleConnectionState : NtCaseBleConnectionState.values()) {
                if (ntCaseBleConnectionState.getRaw() == raw) {
                    return ntCaseBleConnectionState;
                }
            }
            return null;
        }
    }
}
