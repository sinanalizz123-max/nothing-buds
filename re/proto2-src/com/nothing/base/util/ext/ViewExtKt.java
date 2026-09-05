package com.nothing.base.util.ext;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.antonkarpenko.ffmpegkit.MediaInformation;
import com.blankj.utilcode.constant.RegexConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.nothing.base.util.TextClickSpan;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.ear.R;
import java.util.Arrays;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\f\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0003\u001a\u0012\u0010\r\u001a\u00020\f*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001a\n\u0010\u0010\u001a\u00020\f*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\f*\u00020\u0011\u001a-\u0010\u0013\u001a\u00020\f*\u00020\u00112!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f0\u0015\u001a-\u0010\u001a\u001a\u00020\f*\u00020\u00112!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f0\u0015\u001a-\u0010\u001b\u001a\u00020\f*\u00020\u00112!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f0\u0015\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u001d\u001a\u001c\u0010\u001e\u001a\u00020\u0001*\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f\u001a\f\u0010!\u001a\u00020\u0001*\u0004\u0018\u00010\u001d\u001a\f\u0010\"\u001a\u00020\u0001*\u0004\u0018\u00010\u001d\u001a\f\u0010#\u001a\u00020\u0001*\u0004\u0018\u00010\u001d\u001a\f\u0010$\u001a\u00020\u0001*\u0004\u0018\u00010\u001d\u001a\u0012\u0010&\u001a\u00020\f*\u00020\u00162\u0006\u0010'\u001a\u00020\u000f\u001a&\u0010(\u001a\u00020\f*\u00020\u00162\b\b\u0001\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010\u001d2\u0006\u0010+\u001a\u00020\u000f\u001a1\u0010,\u001a\u00020\f*\u00020\u00162\b\b\u0001\u0010)\u001a\u00020\u000f2\u0016\u0010-\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010/0.\"\u0004\u0018\u00010/\u00a2\u0006\u0002\u00100\u001ad\u00101\u001a\u00020\f*\u00020\u00162\b\b\u0001\u00102\u001a\u00020\u000f2\b\b\u0001\u00103\u001a\u00020\u000f2\f\b\u0001\u00104\u001a\u000205\"\u00020\u000f26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\f06\u001a\"\u00109\u001a\u00020\f*\u00020\u00162\b\b\u0001\u00102\u001a\u00020\u000f2\f\b\u0001\u00104\u001a\u000205\"\u00020\u000f\u001a-\u00109\u001a\u00020\f*\u00020\u00162\b\b\u0001\u00102\u001a\u00020\u000f2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0.\"\u00020\u001d\u00a2\u0006\u0002\u0010:\u001aV\u0010>\u001a\u00020\f*\u00020\u00162\b\b\u0001\u00102\u001a\u00020\u000f2\b\b\u0001\u00104\u001a\u00020526\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\f06\u001aZ\u0010?\u001a\u00020\f*\u00020\u00162\b\b\u0001\u00102\u001a\u00020\u000f2\f\b\u0001\u00104\u001a\u000205\"\u00020\u000f26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\f06\u001aX\u0010?\u001a\u00020\f*\u00020\u00162\u0006\u00102\u001a\u00020\u001d2\f\b\u0001\u00104\u001a\u000205\"\u00020\u000f26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\f06\u001a\u001c\u00109\u001a\u00020\f*\u00020\u00162\b\b\u0001\u00102\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u001d\u001ak\u00101\u001a\u00020\f*\u00020\u00162\u0006\u0010@\u001a\u00020\u001d2\u0006\u0010+\u001a\u00020\u000f2\u0012\u00104\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0.\"\u00020\u001d26\u0010\u0014\u001a2\u0012\u0013\u0012\u00110\u001d\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(7\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\f06\u00a2\u0006\u0002\u0010A\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\"\u000e\u0010%\u001a\u00020\u000fX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u000fX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u000fX\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\u000fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"value", "", "goneUnless", "Landroid/view/View;", "getGoneUnless", "(Landroid/view/View;)Z", "setGoneUnless", "(Landroid/view/View;Z)V", "invisibleUnless", "getInvisibleUnless", "setInvisibleUnless", "hapticSeekView", "", "updateWidth", "width", "", "closeSoftInput", "Landroid/widget/EditText;", "showSoftInput", "setOnSearchListener", "action", "Lkotlin/Function1;", "Landroid/widget/TextView;", "Lkotlin/ParameterName;", "name", "textView", "setOnSendListener", "setOnDoneListener", "isEmail", "", "checkLength", "minLength", "maxLength", "checkUpperCase", "checkLowerCase", "checkNumberCase", "checkSymbolCase", "TWO", "setLineTextHeight", "lineHeight", "setTextSpannable", MediaInformation.KEY_FORMAT_PROPERTIES, "formatArg", "color", "setTextString", "formatArgs", "", "", "(Landroid/widget/TextView;I[Ljava/lang/Object;)V", "setClickableText", "contentRes", "colorRes", UserMetadata.KEYDATA_FILENAME, "", "Lkotlin/Function2;", "key", "index", "setBoldText", "(Landroid/widget/TextView;I[Ljava/lang/String;)V", "ONE", "THREE", "FOUR", "setBoldClickableTextByIntArray", "setBoldClickableText", FirebaseAnalytics.Param.CONTENT, "(Landroid/widget/TextView;Ljava/lang/String;I[Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "nt_ear_GoogleStoreRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ViewExtKt {
    private static final int FOUR = 4;
    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int TWO = 2;

    public static final boolean getGoneUnless(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final void setGoneUnless(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 8);
    }

    public static final boolean getInvisibleUnless(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return view.getVisibility() == 0;
    }

    public static final void setInvisibleUnless(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setVisibility(z ? 0 : 4);
    }

    public static final void hapticSeekView(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.performHapticFeedback(12, 2);
    }

    public static final void updateWidth(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    public static final void closeSoftInput(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.clearFocus();
        Context context = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 2);
        }
    }

    public static final void showSoftInput(EditText editText) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        editText.setSelection(editText.getText().length());
        Context context = editText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        InputMethodManager inputMethodManager = (InputMethodManager) ContextCompat.getSystemService(context, InputMethodManager.class);
        if (inputMethodManager != null) {
            inputMethodManager.showSoftInput(editText, 0);
        }
    }

    public static final void setOnSearchListener(EditText editText, final Function1<? super TextView, Unit> action) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.nothing.base.util.ext.ViewExtKt$$ExternalSyntheticLambda4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return ViewExtKt.setOnSearchListener$lambda$1(action, textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnSearchListener$lambda$1(Function1 function1, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return true;
        }
        Intrinsics.checkNotNull(textView);
        function1.invoke(textView);
        return true;
    }

    public static final void setOnSendListener(EditText editText, final Function1<? super TextView, Unit> action) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.nothing.base.util.ext.ViewExtKt$$ExternalSyntheticLambda7
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return ViewExtKt.setOnSendListener$lambda$2(action, textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnSendListener$lambda$2(Function1 function1, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 4) {
            return true;
        }
        Intrinsics.checkNotNull(textView);
        function1.invoke(textView);
        return true;
    }

    public static final void setOnDoneListener(EditText editText, final Function1<? super TextView, Unit> action) {
        Intrinsics.checkNotNullParameter(editText, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.nothing.base.util.ext.ViewExtKt$$ExternalSyntheticLambda5
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return ViewExtKt.setOnDoneListener$lambda$3(action, textView, i, keyEvent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean setOnDoneListener$lambda$3(Function1 function1, TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        Intrinsics.checkNotNull(textView);
        function1.invoke(textView);
        return true;
    }

    public static final boolean isEmail(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Pattern.compile(RegexConstants.REGEX_EMAIL).matcher(str).matches();
    }

    public static final boolean checkLength(String str, int i, int i2) {
        int length;
        String str2 = str;
        return str2 != null && str2.length() != 0 && i <= (length = str.length()) && length <= i2;
    }

    public static final boolean checkUpperCase(String str) {
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            for (int i = 0; i < str2.length(); i++) {
                if (Character.isUpperCase(str2.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean checkLowerCase(String str) {
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            for (int i = 0; i < str2.length(); i++) {
                if (Character.isLowerCase(str2.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean checkNumberCase(String str) {
        String str2 = str;
        if (str2 != null && str2.length() != 0) {
            for (int i = 0; i < str2.length(); i++) {
                if (Character.isDigit(str2.charAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean checkSymbolCase(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        return Pattern.compile("\\p{Punct}").matcher(str2).find();
    }

    public static final void setLineTextHeight(TextView textView, int i) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        if (textView.getText() != null && textView.getTag(R.id.text_padding_tag) == null) {
            CharSequence text = textView.getText();
            textView.setText(StringUtils.SPACE);
            textView.measure(0, 0);
            int measuredHeight = textView.getMeasuredHeight();
            textView.setText(text);
            textView.setLineSpacing(i, 0.0f);
            if (measuredHeight < i) {
                int i2 = (i - measuredHeight) / 2;
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop() + i2, textView.getPaddingRight(), textView.getPaddingBottom() + i2);
            }
            textView.setTag(R.id.text_padding_tag, ViewKey.TAG);
        }
    }

    public static final void setTextSpannable(TextView textView, int i, String str, int i2) {
        int iIndexOf$default;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        String string = textView.getContext().getString(i, str);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str2 = string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
        String str3 = str;
        if (str3 != null && str3.length() != 0 && (iIndexOf$default = StringsKt.indexOf$default((CharSequence) str2, str, 0, false, 6, (Object) null)) >= 0) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), iIndexOf$default, str.length() + iIndexOf$default, 17);
        }
        textView.setText(spannableStringBuilder);
    }

    public static final void setTextString(TextView textView, int i, Object... formatArgs) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        textView.setText(textView.getContext().getString(i, Arrays.copyOf(formatArgs, formatArgs.length)));
    }

    public static final void setClickableText(TextView textView, int i, int i2, int[] keys, final Function2<? super String, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(action, "action");
        String string = textView.getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int color = ContextCompat.getColor(textView.getContext(), i2);
        String str = string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = keys.length;
        int i3 = 0;
        final int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            final String string2 = textView.getContext().getString(keys[i3]);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableStringBuilder.setSpan(new TextClickSpan(Integer.valueOf(color), new Function0() { // from class: com.nothing.base.util.ext.ViewExtKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ViewExtKt.setClickableText$lambda$8$lambda$7(action, string2, i4);
                    }
                }), iIndexOf$default, string2.length() + iIndexOf$default, 17);
            }
            i3++;
            i4 = i5;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClickableText$lambda$8$lambda$7(Function2 function2, String str, int i) {
        function2.invoke(str, Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    public static final void setBoldText(TextView textView, int i, int... keys) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        String string = textView.getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i2 : keys) {
            String string2 = textView.getContext().getString(i2);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, string2, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableStringBuilder.setSpan(new StyleSpan(1), iIndexOf$default, string2.length() + iIndexOf$default, 17);
            }
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
    }

    public static final void setBoldText(TextView textView, int i, String... keys) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        String string = textView.getContext().getString(i, keys);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String str = string;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (String str2 : keys) {
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, str2, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableStringBuilder.setSpan(new StyleSpan(1), iIndexOf$default, str2.length() + iIndexOf$default, 17);
            }
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
    }

    public static final void setBoldClickableTextByIntArray(TextView textView, int i, int[] keys, final Function2<? super String, ? super Integer, Unit> action) {
        String string;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = keys.length;
        if (length == 1) {
            string = textView.getContext().getString(i, textView.getContext().getString(keys[0]));
        } else if (length == 2) {
            string = textView.getContext().getString(i, textView.getContext().getString(keys[0]), textView.getContext().getString(keys[1]));
        } else if (length == 3) {
            string = textView.getContext().getString(i, textView.getContext().getString(keys[0]), textView.getContext().getString(keys[1]), textView.getContext().getString(keys[2]));
        } else if (length == 4) {
            string = textView.getContext().getString(i, textView.getContext().getString(keys[0]), textView.getContext().getString(keys[1]), textView.getContext().getString(keys[2]), textView.getContext().getString(keys[3]));
        } else {
            string = textView.getContext().getString(i);
        }
        Intrinsics.checkNotNull(string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((Object) string) + "\u200b");
        int length2 = keys.length;
        int i2 = 0;
        final int i3 = 0;
        while (i2 < length2) {
            int i4 = i3 + 1;
            final String string2 = textView.getContext().getString(keys[i2]);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, string2, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableStringBuilder.setSpan(new TextClickSpan(null, new Function0() { // from class: com.nothing.base.util.ext.ViewExtKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ViewExtKt.setBoldClickableTextByIntArray$lambda$12$lambda$11(action, string2, i3);
                    }
                }, 1, null), iIndexOf$default, string2.length() + iIndexOf$default, 17);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                spannableStringBuilder.setSpan(new StyleSpan(1), iIndexOf$default, string2.length() + iIndexOf$default, 17);
            }
            i2++;
            i3 = i4;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setBoldClickableTextByIntArray$lambda$12$lambda$11(Function2 function2, String str, int i) {
        function2.invoke(str, Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    public static final void setBoldClickableText(TextView textView, int i, int[] keys, final Function2<? super String, ? super Integer, Unit> action) {
        String string;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = keys.length;
        if (length == 1) {
            string = textView.getContext().getString(i, textView.getContext().getString(keys[0]));
        } else if (length == 2) {
            string = textView.getContext().getString(i, textView.getContext().getString(keys[0]), textView.getContext().getString(keys[1]));
        } else if (length == 3) {
            string = textView.getContext().getString(i, textView.getContext().getString(keys[0]), textView.getContext().getString(keys[1]), textView.getContext().getString(keys[2]));
        } else if (length == 4) {
            string = textView.getContext().getString(i, textView.getContext().getString(keys[0]), textView.getContext().getString(keys[1]), textView.getContext().getString(keys[2]), textView.getContext().getString(keys[3]));
        } else {
            string = textView.getContext().getString(i);
        }
        Intrinsics.checkNotNull(string);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(((Object) string) + "\u200b");
        int length2 = keys.length;
        int i2 = 0;
        final int i3 = 0;
        while (i2 < length2) {
            int i4 = i3 + 1;
            final String string2 = textView.getContext().getString(keys[i2]);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, string2, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableStringBuilder.setSpan(new TextClickSpan(null, new Function0() { // from class: com.nothing.base.util.ext.ViewExtKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ViewExtKt.setBoldClickableText$lambda$14$lambda$13(action, string2, i3);
                    }
                }, 1, null), iIndexOf$default, string2.length() + iIndexOf$default, 17);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                spannableStringBuilder.setSpan(new StyleSpan(1), iIndexOf$default, string2.length() + iIndexOf$default, 17);
            }
            i2++;
            i3 = i4;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setBoldClickableText$lambda$14$lambda$13(Function2 function2, String str, int i) {
        function2.invoke(str, Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    public static final void setBoldClickableText(TextView textView, String contentRes, int[] keys, final Function2<? super String, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(contentRes, "contentRes");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(action, "action");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(contentRes + "\u200b");
        int length = keys.length;
        int i = 0;
        final int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            final String string = textView.getContext().getString(keys[i]);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) contentRes, string, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableStringBuilder.setSpan(new TextClickSpan(null, new Function0() { // from class: com.nothing.base.util.ext.ViewExtKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ViewExtKt.setBoldClickableText$lambda$16$lambda$15(action, string, i2);
                    }
                }, 1, null), iIndexOf$default, string.length() + iIndexOf$default, 17);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                spannableStringBuilder.setSpan(new StyleSpan(1), iIndexOf$default, string.length() + iIndexOf$default, 17);
            }
            i++;
            i2 = i3;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setBoldClickableText$lambda$16$lambda$15(Function2 function2, String str, int i) {
        function2.invoke(str, Integer.valueOf(i));
        return Unit.INSTANCE;
    }

    public static final void setBoldText(TextView textView, int i, String keys) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(keys, "keys");
        String string = textView.getContext().getString(i, keys);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + "\u200b");
        int iIndexOf$default = StringsKt.indexOf$default((CharSequence) string, keys, 0, false, 6, (Object) null);
        if (iIndexOf$default >= 0) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            spannableStringBuilder.setSpan(new StyleSpan(1), iIndexOf$default, keys.length() + iIndexOf$default, 17);
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
    }

    public static final void setClickableText(TextView textView, String content, int i, String[] keys, final Function2<? super String, ? super Integer, Unit> action) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(action, "action");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content + "\u200b");
        int length = keys.length;
        int i2 = 0;
        final int i3 = 0;
        while (i2 < length) {
            final String str = keys[i2];
            int i4 = i3 + 1;
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) content, str, 0, false, 6, (Object) null);
            if (iIndexOf$default >= 0) {
                spannableStringBuilder.setSpan(new TextClickSpan(Integer.valueOf(i), new Function0() { // from class: com.nothing.base.util.ext.ViewExtKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ViewExtKt.setClickableText$lambda$18$lambda$17(action, str, i3);
                    }
                }), iIndexOf$default, str.length() + iIndexOf$default, 17);
                spannableStringBuilder.setSpan(new StyleSpan(1), iIndexOf$default, str.length() + iIndexOf$default, 17);
            }
            i2++;
            i3 = i4;
        }
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setHighlightColor(0);
        textView.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setClickableText$lambda$18$lambda$17(Function2 function2, String str, int i) {
        function2.invoke(str, Integer.valueOf(i));
        return Unit.INSTANCE;
    }
}
