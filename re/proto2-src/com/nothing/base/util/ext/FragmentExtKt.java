package com.nothing.base.util.ext;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FragmentExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a8\u0006\u0005"}, d2 = {"startActivity", "", "Landroidx/fragment/app/Fragment;", "cls", "Ljava/lang/Class;", "nt_ear_GoogleStoreRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class FragmentExtKt {
    public static final void startActivity(Fragment fragment, Class<?> cls) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.checkNotNullParameter(cls, "cls");
        fragment.startActivity(new Intent(fragment.getActivity(), cls));
    }
}
