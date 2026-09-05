package com.nothing.ear.one.core.protocol.entity;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableField;
import com.nothing.ear.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ItemCaseLight.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0018\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/nothing/ear/one/core/protocol/entity/ItemCaseLight;", "", "context", "Landroid/content/Context;", "type", "", "color", "<init>", "(Landroid/content/Context;II)V", "getType", "()I", "name", "", "getName", "()Ljava/lang/String;", NotificationCompat.CATEGORY_MESSAGE, "getMsg", "default", "getDefault", "value", "Landroidx/databinding/ObservableField;", "getValue", "()Landroidx/databinding/ObservableField;", "getColor", "setColor", "(I)V", "iconColor", "getIconColor", "setIconColor", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemCaseLight {
    public static final int COLOR_BLUE = -16773056;
    public static final int COLOR_GREEN = -16179200;
    public static final int COLOR_ORANGE = -10483200;
    public static final int COLOR_RED = -11795968;
    public static final int COLOR_WHITE = -1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int color;
    private final int default;
    private int iconColor;
    private final String msg;
    private final String name;
    private final int type;
    private final ObservableField<String> value;

    public ItemCaseLight(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.type = i;
        Companion companion = INSTANCE;
        this.name = Companion.getLightName$default(companion, context, i, false, 4, null);
        this.msg = companion.getLightName(context, i, true);
        this.default = DeviceBoxLed.INSTANCE.obtainDefault(i);
        this.value = new ObservableField<>();
        setColor(context, i2);
    }

    public final int getType() {
        return this.type;
    }

    public final String getName() {
        return this.name;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getDefault() {
        return this.default;
    }

    public final ObservableField<String> getValue() {
        return this.value;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i) {
        this.color = i;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    public final void setIconColor(int i) {
        this.iconColor = i;
    }

    public final void setColor(Context context, int color) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.color = color;
        if (color == -16773056) {
            this.value.set(context.getString(R.string.egg_color_blue));
            this.iconColor = ContextCompat.getColor(context, R.color.nt_4487EC);
            return;
        }
        if (color == -16179200) {
            this.value.set(context.getString(R.string.egg_color_green));
            this.iconColor = ContextCompat.getColor(context, R.color.nt_1DC661);
            return;
        }
        if (color == -11795968) {
            this.value.set(context.getString(R.string.egg_color_red));
            this.iconColor = ContextCompat.getColor(context, R.color.nt_E82526);
        } else if (color == -10483200) {
            this.value.set(context.getString(R.string.egg_color_orange));
            this.iconColor = ContextCompat.getColor(context, R.color.nt_F47F2A);
        } else if (color == -1) {
            this.value.set(context.getString(R.string.egg_color_white));
            this.iconColor = ContextCompat.getColor(context, R.color.nt_F0EFE6);
        } else {
            this.value.set(context.getString(R.string.egg_color_default));
            this.iconColor = color;
        }
    }

    /* JADX INFO: compiled from: ItemCaseLight.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/ear/one/core/protocol/entity/ItemCaseLight$Companion;", "", "<init>", "()V", "COLOR_RED", "", "COLOR_ORANGE", "COLOR_GREEN", "COLOR_BLUE", "COLOR_WHITE", "getLightName", "", "context", "Landroid/content/Context;", "type", "isMsg", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        static /* synthetic */ String getLightName$default(Companion companion, Context context, int i, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            return companion.getLightName(context, i, z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getLightName(Context context, int type, boolean isMsg) {
            switch (type) {
                case 1:
                    if (isMsg) {
                        String string = context.getString(R.string.egg_level_summary_3);
                        Intrinsics.checkNotNull(string);
                        return string;
                    }
                    String string2 = context.getString(R.string.egg_low_level);
                    Intrinsics.checkNotNull(string2);
                    return string2;
                case 2:
                    if (isMsg) {
                        String string3 = context.getString(R.string.egg_level_summary_2);
                        Intrinsics.checkNotNull(string3);
                        return string3;
                    }
                    String string4 = context.getString(R.string.egg_medium_level);
                    Intrinsics.checkNotNull(string4);
                    return string4;
                case 3:
                    if (isMsg) {
                        String string5 = context.getString(R.string.egg_level_summary);
                        Intrinsics.checkNotNull(string5);
                        return string5;
                    }
                    String string6 = context.getString(R.string.egg_high_level);
                    Intrinsics.checkNotNull(string6);
                    return string6;
                case 4:
                    if (isMsg) {
                        String string7 = context.getString(R.string.egg_level_summary_4);
                        Intrinsics.checkNotNull(string7);
                        return string7;
                    }
                    String string8 = context.getString(R.string.egg_charging);
                    Intrinsics.checkNotNull(string8);
                    return string8;
                case 5:
                    if (isMsg) {
                        String string9 = context.getString(R.string.egg_level_summary_5);
                        Intrinsics.checkNotNull(string9);
                        return string9;
                    }
                    String string10 = context.getString(R.string.egg_charge_full);
                    Intrinsics.checkNotNull(string10);
                    return string10;
                case 6:
                    String string11 = context.getString(R.string.egg_pairing);
                    Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                    return string11;
                default:
                    String string12 = context.getString(R.string.egg_unknown);
                    Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                    return string12;
            }
        }
    }
}
