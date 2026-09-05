package com.nothing.generate;

import android.util.Log;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NtCaseBlePigeon.g.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\u0006\u0010\f\u001a\u00020\r\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/generate/NtCaseBlePigeonPigeonUtils;", "", "<init>", "()V", "createConnectionError", "Lcom/nothing/generate/NtCaseBleFlutterError;", "channelName", "", "wrapResult", "", "result", "wrapError", Constants.EXCEPTION, "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class NtCaseBlePigeonPigeonUtils {
    public static final NtCaseBlePigeonPigeonUtils INSTANCE = new NtCaseBlePigeonPigeonUtils();

    private NtCaseBlePigeonPigeonUtils() {
    }

    public final NtCaseBleFlutterError createConnectionError(String channelName) {
        Intrinsics.checkNotNullParameter(channelName, "channelName");
        return new NtCaseBleFlutterError("channel-error", "Unable to establish connection on channel: '" + channelName + "'.", "");
    }

    public final List<Object> wrapResult(Object result) {
        return CollectionsKt.listOf(result);
    }

    public final List<Object> wrapError(Throwable exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        if (exception instanceof NtCaseBleFlutterError) {
            NtCaseBleFlutterError ntCaseBleFlutterError = (NtCaseBleFlutterError) exception;
            return CollectionsKt.listOf(ntCaseBleFlutterError.getCode(), ntCaseBleFlutterError.getMessage(), ntCaseBleFlutterError.getDetails());
        }
        return CollectionsKt.listOf((Object[]) new String[]{exception.getClass().getSimpleName(), exception.toString(), "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception)});
    }
}
