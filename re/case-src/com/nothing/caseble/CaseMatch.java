package com.nothing.caseble;

import android.bluetooth.le.ScanResult;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NtCaseBleApi.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/caseble/CaseMatch;", "", "caseMac", "", "scanResult", "Landroid/bluetooth/le/ScanResult;", "<init>", "(Ljava/lang/String;Landroid/bluetooth/le/ScanResult;)V", "getCaseMac", "()Ljava/lang/String;", "getScanResult", "()Landroid/bluetooth/le/ScanResult;", "component1", "component2", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final /* data */ class CaseMatch {
    private final String caseMac;
    private final ScanResult scanResult;

    public static /* synthetic */ CaseMatch copy$default(CaseMatch caseMatch, String str, ScanResult scanResult, int i, Object obj) {
        if ((i & 1) != 0) {
            str = caseMatch.caseMac;
        }
        if ((i & 2) != 0) {
            scanResult = caseMatch.scanResult;
        }
        return caseMatch.copy(str, scanResult);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCaseMac() {
        return this.caseMac;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ScanResult getScanResult() {
        return this.scanResult;
    }

    public final CaseMatch copy(String caseMac, ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(caseMac, "caseMac");
        Intrinsics.checkNotNullParameter(scanResult, "scanResult");
        return new CaseMatch(caseMac, scanResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaseMatch)) {
            return false;
        }
        CaseMatch caseMatch = (CaseMatch) other;
        return Intrinsics.areEqual(this.caseMac, caseMatch.caseMac) && Intrinsics.areEqual(this.scanResult, caseMatch.scanResult);
    }

    public int hashCode() {
        return (this.caseMac.hashCode() * 31) + this.scanResult.hashCode();
    }

    public String toString() {
        return "CaseMatch(caseMac=" + this.caseMac + ", scanResult=" + this.scanResult + ")";
    }

    public CaseMatch(String caseMac, ScanResult scanResult) {
        Intrinsics.checkNotNullParameter(caseMac, "caseMac");
        Intrinsics.checkNotNullParameter(scanResult, "scanResult");
        this.caseMac = caseMac;
        this.scanResult = scanResult;
    }

    public final String getCaseMac() {
        return this.caseMac;
    }

    public final ScanResult getScanResult() {
        return this.scanResult;
    }
}
