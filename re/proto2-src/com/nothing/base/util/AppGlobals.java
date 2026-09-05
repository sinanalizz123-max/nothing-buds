package com.nothing.base.util;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppGlobals.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/nothing/base/util/AppGlobals;", "", "<init>", "()V", "application", "Landroid/app/Application;", "get", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppGlobals {
    public static final AppGlobals INSTANCE = new AppGlobals();
    private static Application application;

    private AppGlobals() {
    }

    public final Application get() {
        if (application == null) {
            try {
                Object objInvoke = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
                Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type android.app.Application");
                application = (Application) objInvoke;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return application;
    }
}
