package com.nothing.generate;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NtCaseBlePigeon.g.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/generate/NtCaseBleFlutterError;", "", "code", "", "message", "details", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "getCode", "()Ljava/lang/String;", "getMessage", "getDetails", "()Ljava/lang/Object;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NtCaseBleFlutterError extends Throwable {
    private final String code;
    private final Object details;
    private final String message;

    public /* synthetic */ NtCaseBleFlutterError(String str, String str2, Object obj, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : obj);
    }

    public final String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final Object getDetails() {
        return this.details;
    }

    public NtCaseBleFlutterError(String code, String str, Object obj) {
        Intrinsics.checkNotNullParameter(code, "code");
        this.code = code;
        this.message = str;
        this.details = obj;
    }
}
