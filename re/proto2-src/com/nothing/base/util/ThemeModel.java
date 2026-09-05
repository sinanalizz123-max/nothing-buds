package com.nothing.base.util;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: compiled from: EnumUtils.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/nothing/base/util/ThemeModel;", "", "theme", "", "<init>", "(Ljava/lang/String;II)V", "getTheme", "()I", "DARK_MODE", "LIGHT_MODE", "FOLLOW_MODE", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public enum ThemeModel {
    DARK_MODE(1),
    LIGHT_MODE(0),
    FOLLOW_MODE(2);

    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
    private final int theme;

    public static EnumEntries<ThemeModel> getEntries() {
        return $ENTRIES;
    }

    ThemeModel(int i) {
        this.theme = i;
    }

    public final int getTheme() {
        return this.theme;
    }
}
