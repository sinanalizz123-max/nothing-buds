package com.nothing.base.util;

import android.app.Application;
import android.util.Log;
import com.fluttercandies.photo_manager.constant.Methods;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BtToggleDiag.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u001c\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/nothing/base/util/BtToggleDiag;", "", "<init>", "()V", "TAG", "", "enabled", "", Methods.log, "", "source", "extra", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BtToggleDiag {
    public static final BtToggleDiag INSTANCE = new BtToggleDiag();
    private static final String TAG = "NX_BT_DIAG";

    private BtToggleDiag() {
    }

    @JvmStatic
    public static final boolean enabled() {
        Application application = AppGlobals.INSTANCE.get();
        if (application == null) {
            return false;
        }
        return Logger.INSTANCE.getDebugFromCtx(application);
    }

    public static /* synthetic */ void log$default(String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        log(str, str2);
    }

    @JvmStatic
    public static final void log(String source, String extra) {
        String str;
        Intrinsics.checkNotNullParameter(source, "source");
        if (enabled()) {
            String str2 = extra;
            String str3 = (str2 == null || str2.length() == 0) ? "" : StringUtils.SPACE + extra;
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 1) {
                str = stackTrace[1].getFileName() + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + stackTrace[1].getLineNumber();
            } else {
                str = "unknown";
            }
            Log.i(TAG, source + str3 + " @ " + str);
        }
    }
}
