package com.nothing.base.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.nothing.ear.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ToastUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/base/util/ToastUtil;", "", "<init>", "()V", "mToast", "Landroid/widget/Toast;", "showToast", "", "context", "Landroid/content/Context;", "message", "", "duration", "", "showToastTop", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ToastUtil {
    public static final ToastUtil INSTANCE = new ToastUtil();
    private static Toast mToast;

    private ToastUtil() {
    }

    public static /* synthetic */ void showToast$default(ToastUtil toastUtil, Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 0;
        }
        toastUtil.showToast(context, str, i);
    }

    public final void showToast(Context context, String message, int duration) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        Toast toastMakeText = Toast.makeText(context, message, duration);
        mToast = toastMakeText;
        if (toastMakeText != null) {
            toastMakeText.show();
        }
    }

    public final void showToast(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        Toast toastMakeText = Toast.makeText(AppGlobals.INSTANCE.get(), message, 0);
        mToast = toastMakeText;
        if (toastMakeText != null) {
            toastMakeText.show();
        }
    }

    public final void showToastTop(Context context, String message) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(message, "message");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_custom_toast, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(R.id.toast_text)).setText(message);
        Toast toast = new Toast(context.getApplicationContext());
        mToast = toast;
        toast.setView(viewInflate);
        Toast toast2 = mToast;
        if (toast2 != null) {
            toast2.setDuration(0);
        }
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.toast_margin_top);
        Toast toast3 = mToast;
        if (toast3 != null) {
            toast3.setGravity(49, 0, dimensionPixelOffset);
        }
        Toast toast4 = mToast;
        if (toast4 != null) {
            toast4.show();
        }
    }
}
