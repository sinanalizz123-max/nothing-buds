package com.nothing.base.util.ext;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.AndroidViewModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewModelExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b\u001a1\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\f\u001a\u001e\u0010\r\u001a\u00020\u000e*\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0010\u001a\u00020\b\u001a\u001e\u0010\r\u001a\u00020\u000e*\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b\u001a7\u0010\r\u001a\u00020\u000e*\u00020\u00022\b\b\u0001\u0010\u0011\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0012\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"applicationContext", "Landroid/content/Context;", "Landroidx/lifecycle/AndroidViewModel;", "getApplicationContext", "(Landroidx/lifecycle/AndroidViewModel;)Landroid/content/Context;", "getString", "", "res", "", "formatArgs", "", "", "(Landroidx/lifecycle/AndroidViewModel;I[Ljava/lang/Object;)Ljava/lang/String;", "showToast", "", "message", "duration", NotificationCompat.CATEGORY_MESSAGE, "(Landroidx/lifecycle/AndroidViewModel;I[Ljava/lang/Object;I)V", "nt_ear_GoogleStoreRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ViewModelExtKt {
    public static final Context getApplicationContext(AndroidViewModel androidViewModel) {
        Intrinsics.checkNotNullParameter(androidViewModel, "<this>");
        Context applicationContext = androidViewModel.getApplication().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        return applicationContext;
    }

    public static final String getString(AndroidViewModel androidViewModel, int i) {
        Intrinsics.checkNotNullParameter(androidViewModel, "<this>");
        if (i == 0) {
            return "";
        }
        String string = getApplicationContext(androidViewModel).getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static final String getString(AndroidViewModel androidViewModel, int i, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(androidViewModel, "<this>");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        String string = getApplicationContext(androidViewModel).getString(i, Arrays.copyOf(formatArgs, formatArgs.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public static /* synthetic */ void showToast$default(AndroidViewModel androidViewModel, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        showToast(androidViewModel, str, i);
    }

    public static final void showToast(AndroidViewModel androidViewModel, String str, int i) {
        Intrinsics.checkNotNullParameter(androidViewModel, "<this>");
        ContextExtKt.showToast(getApplicationContext(androidViewModel), str, i);
    }

    public static /* synthetic */ void showToast$default(AndroidViewModel androidViewModel, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        showToast(androidViewModel, i, i2);
    }

    public static final void showToast(AndroidViewModel androidViewModel, int i, int i2) {
        Intrinsics.checkNotNullParameter(androidViewModel, "<this>");
        ContextExtKt.showToast(getApplicationContext(androidViewModel), i, i2);
    }

    public static /* synthetic */ void showToast$default(AndroidViewModel androidViewModel, int i, Object[] objArr, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showToast(androidViewModel, i, objArr, i2);
    }

    public static final void showToast(AndroidViewModel androidViewModel, int i, Object[] formatArgs, int i2) {
        Intrinsics.checkNotNullParameter(androidViewModel, "<this>");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        ContextExtKt.showToast$default(getApplicationContext(androidViewModel), i, new Object[]{formatArgs, Integer.valueOf(i2)}, 0, 4, null);
    }
}
