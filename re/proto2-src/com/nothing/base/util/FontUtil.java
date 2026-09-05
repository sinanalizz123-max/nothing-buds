package com.nothing.base.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FontUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/nothing/base/util/FontUtil;", "", "<init>", "()V", "attachBaseContext", "Landroid/content/Context;", "context", "fontScale", "", "getResources", "Landroid/content/res/Resources;", "resources", "recreate", "", "activity", "Landroid/app/Activity;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontUtil {
    public static final FontUtil INSTANCE = new FontUtil();

    private FontUtil() {
    }

    public final Context attachBaseContext(Context context, float fontScale) {
        Intrinsics.checkNotNullParameter(context, "context");
        Configuration configuration = context.getResources().getConfiguration();
        configuration.fontScale = fontScale;
        Context contextCreateConfigurationContext = context.createConfigurationContext(configuration);
        Intrinsics.checkNotNullExpressionValue(contextCreateConfigurationContext, "createConfigurationContext(...)");
        return contextCreateConfigurationContext;
    }

    public final Resources getResources(Context context, Resources resources, float fontScale) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Configuration configuration = resources.getConfiguration();
        if (configuration.fontScale == fontScale) {
            return resources;
        }
        configuration.fontScale = fontScale;
        Resources resources2 = context.createConfigurationContext(configuration).getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        return resources2;
    }

    public final void recreate(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.recreate();
    }
}
