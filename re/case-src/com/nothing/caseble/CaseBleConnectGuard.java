package com.nothing.caseble;

import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: CaseBleConnectGuard.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t\u00a2\u0006\u0002\u0010\f\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/caseble/CaseBleConnectGuard;", "", "<init>", "()V", "decideForCurrentState", "Lcom/nothing/caseble/CaseBleConnectGuard$Decision;", "currentState", "", "startAtMs", "", "nowMs", "staleConnectingTimeoutMs", "(Ljava/lang/Integer;Ljava/lang/Long;JJ)Lcom/nothing/caseble/CaseBleConnectGuard$Decision;", "Decision", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CaseBleConnectGuard {
    public static final CaseBleConnectGuard INSTANCE = new CaseBleConnectGuard();

    /* JADX INFO: compiled from: CaseBleConnectGuard.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001J\t\u0010\u001a\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/nothing/caseble/CaseBleConnectGuard$Decision;", "", "shouldSkipDuplicateConnect", "", "isStaleConnecting", "elapsedMs", "", "reason", "", "<init>", "(ZZJLjava/lang/String;)V", "getShouldSkipDuplicateConnect", "()Z", "getElapsedMs", "()J", "getReason", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Decision {
        private final long elapsedMs;
        private final boolean isStaleConnecting;
        private final String reason;
        private final boolean shouldSkipDuplicateConnect;

        public static /* synthetic */ Decision copy$default(Decision decision, boolean z, boolean z2, long j, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                z = decision.shouldSkipDuplicateConnect;
            }
            if ((i & 2) != 0) {
                z2 = decision.isStaleConnecting;
            }
            if ((i & 4) != 0) {
                j = decision.elapsedMs;
            }
            if ((i & 8) != 0) {
                str = decision.reason;
            }
            String str2 = str;
            return decision.copy(z, z2, j, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getShouldSkipDuplicateConnect() {
            return this.shouldSkipDuplicateConnect;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsStaleConnecting() {
            return this.isStaleConnecting;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final long getElapsedMs() {
            return this.elapsedMs;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getReason() {
            return this.reason;
        }

        public final Decision copy(boolean shouldSkipDuplicateConnect, boolean isStaleConnecting, long elapsedMs, String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Decision(shouldSkipDuplicateConnect, isStaleConnecting, elapsedMs, reason);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Decision)) {
                return false;
            }
            Decision decision = (Decision) other;
            return this.shouldSkipDuplicateConnect == decision.shouldSkipDuplicateConnect && this.isStaleConnecting == decision.isStaleConnecting && this.elapsedMs == decision.elapsedMs && Intrinsics.areEqual(this.reason, decision.reason);
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.shouldSkipDuplicateConnect) * 31) + Boolean.hashCode(this.isStaleConnecting)) * 31) + Long.hashCode(this.elapsedMs)) * 31) + this.reason.hashCode();
        }

        public String toString() {
            return "Decision(shouldSkipDuplicateConnect=" + this.shouldSkipDuplicateConnect + ", isStaleConnecting=" + this.isStaleConnecting + ", elapsedMs=" + this.elapsedMs + ", reason=" + this.reason + ")";
        }

        public Decision(boolean z, boolean z2, long j, String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.shouldSkipDuplicateConnect = z;
            this.isStaleConnecting = z2;
            this.elapsedMs = j;
            this.reason = reason;
        }

        public final boolean getShouldSkipDuplicateConnect() {
            return this.shouldSkipDuplicateConnect;
        }

        public final boolean isStaleConnecting() {
            return this.isStaleConnecting;
        }

        public final long getElapsedMs() {
            return this.elapsedMs;
        }

        public final String getReason() {
            return this.reason;
        }
    }

    private CaseBleConnectGuard() {
    }

    public final Decision decideForCurrentState(Integer currentState, Long startAtMs, long nowMs, long staleConnectingTimeoutMs) {
        if (currentState != null) {
            if (currentState.intValue() == 1) {
                long jLongValue = startAtMs != null ? startAtMs.longValue() : 0L;
                if (jLongValue <= 0) {
                    return new Decision(true, false, 0L, "missing_connect_start_time_assume_in_progress");
                }
                long jCoerceAtLeast = jLongValue > 0 ? RangesKt.coerceAtLeast(nowMs - jLongValue, 0L) : 0L;
                boolean z = jLongValue > 0 && jCoerceAtLeast > staleConnectingTimeoutMs;
                return new Decision(!z, z, jCoerceAtLeast, z ? "connecting_timeout" : "connecting_in_progress");
            }
        }
        return new Decision(false, false, 0L, "not_connecting");
    }
}
