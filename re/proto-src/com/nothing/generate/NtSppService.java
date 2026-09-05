package com.nothing.generate;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NtBlePigeon.g.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\t\u0010\u001a\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u00a8\u0006\u001c"}, d2 = {"Lcom/nothing/generate/NtSppService;", "", "normalIdentity", "", "otaIdentity", "dialIdentity", "logIdentity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNormalIdentity", "()Ljava/lang/String;", "getOtaIdentity", "getDialIdentity", "getLogIdentity", "toList", "", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "component1", "component2", "component3", "component4", "copy", "toString", "Companion", "nt_ble_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class NtSppService {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String dialIdentity;
    private final String logIdentity;
    private final String normalIdentity;
    private final String otaIdentity;

    public NtSppService() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ NtSppService copy$default(NtSppService ntSppService, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = ntSppService.normalIdentity;
        }
        if ((i & 2) != 0) {
            str2 = ntSppService.otaIdentity;
        }
        if ((i & 4) != 0) {
            str3 = ntSppService.dialIdentity;
        }
        if ((i & 8) != 0) {
            str4 = ntSppService.logIdentity;
        }
        return ntSppService.copy(str, str2, str3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getNormalIdentity() {
        return this.normalIdentity;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOtaIdentity() {
        return this.otaIdentity;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDialIdentity() {
        return this.dialIdentity;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLogIdentity() {
        return this.logIdentity;
    }

    public final NtSppService copy(String normalIdentity, String otaIdentity, String dialIdentity, String logIdentity) {
        return new NtSppService(normalIdentity, otaIdentity, dialIdentity, logIdentity);
    }

    public String toString() {
        return "NtSppService(normalIdentity=" + this.normalIdentity + ", otaIdentity=" + this.otaIdentity + ", dialIdentity=" + this.dialIdentity + ", logIdentity=" + this.logIdentity + ")";
    }

    public NtSppService(String str, String str2, String str3, String str4) {
        this.normalIdentity = str;
        this.otaIdentity = str2;
        this.dialIdentity = str3;
        this.logIdentity = str4;
    }

    public /* synthetic */ NtSppService(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    public final String getNormalIdentity() {
        return this.normalIdentity;
    }

    public final String getOtaIdentity() {
        return this.otaIdentity;
    }

    public final String getDialIdentity() {
        return this.dialIdentity;
    }

    public final String getLogIdentity() {
        return this.logIdentity;
    }

    /* JADX INFO: compiled from: NtBlePigeon.g.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/generate/NtSppService$Companion;", "", "<init>", "()V", "fromList", "Lcom/nothing/generate/NtSppService;", "pigeonVar_list", "", "nt_ble_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final NtSppService fromList(List<? extends Object> pigeonVar_list) {
            Intrinsics.checkNotNullParameter(pigeonVar_list, "pigeonVar_list");
            return new NtSppService((String) pigeonVar_list.get(0), (String) pigeonVar_list.get(1), (String) pigeonVar_list.get(2), (String) pigeonVar_list.get(3));
        }
    }

    public final List<Object> toList() {
        return CollectionsKt.listOf((Object[]) new String[]{this.normalIdentity, this.otaIdentity, this.dialIdentity, this.logIdentity});
    }

    public boolean equals(Object other) {
        if (!(other instanceof NtSppService)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return NtBlePigeonPigeonUtils.INSTANCE.deepEquals(toList(), ((NtSppService) other).toList());
    }

    public int hashCode() {
        return toList().hashCode();
    }
}
