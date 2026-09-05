package com.nothing.base.util;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextClickSpan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/nothing/base/util/TextClickSpan;", "Landroid/text/style/ClickableSpan;", "color", "", "action", "Lkotlin/Function0;", "", "<init>", "(Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "getColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAction", "()Lkotlin/jvm/functions/Function0;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "onClick", "widget", "Landroid/view/View;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TextClickSpan extends ClickableSpan {
    private final Function0<Unit> action;
    private final Integer color;

    public /* synthetic */ TextClickSpan(Integer num, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, function0);
    }

    public final Integer getColor() {
        return this.color;
    }

    public final Function0<Unit> getAction() {
        return this.action;
    }

    public TextClickSpan(Integer num, Function0<Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        this.color = num;
        this.action = action;
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint ds) {
        Integer num;
        Intrinsics.checkNotNullParameter(ds, "ds");
        Integer num2 = this.color;
        if ((num2 != null && num2.intValue() == 0) || (num = this.color) == null) {
            ds.setFlags(8);
        } else {
            ds.setColor(num.intValue());
        }
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.action.invoke();
    }
}
