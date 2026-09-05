package com.nothing.base.util.ext;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.net.MailTo;
import androidx.core.os.LocaleListCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blankj.utilcode.util.ToastUtils;
import com.nothing.base.util.Logger;
import com.nothing.base.view.WebActivity;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import com.nothing.xhost.cardparser.parser.param.SimulatedPendingIntent;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a \u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u001a\u0014\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\t\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t\u001a\u0012\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t\u001a\u0012\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t\u001a\n\u0010\u0018\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t\u001a\u0012\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\t\u001a\u001c\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0002\u001a\f\u0010\u001d\u001a\u00020\t*\u00020\u0002H\u0002\u001a\f\u0010\u001e\u001a\u00020\t*\u00020\u0002H\u0002\u001a\"\u0010\u001f\u001a\u00020\u0001*\u00020 2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u001a*\u0010\u001f\u001a\u00020\u0001*\u00020 2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020\u0004\u001a \u0010&\u001a\u0004\u0018\u0001H'\"\n\b\u0000\u0010'\u0018\u0001*\u00020(*\u00020)H\u0086\b\u00a2\u0006\u0002\u0010*\u001a\n\u0010+\u001a\u00020\u0001*\u00020)\u001a\u001e\u0010&\u001a\u0002H'\"\n\b\u0000\u0010'\u0018\u0001*\u00020(*\u00020 H\u0086\b\u00a2\u0006\u0002\u0010,\u001a\u001e\u0010&\u001a\u0002H'\"\n\b\u0000\u0010'\u0018\u0001*\u00020(*\u00020-H\u0086\b\u00a2\u0006\u0002\u0010.\u001a\u001e\u0010&\u001a\u0002H'\"\n\b\u0000\u0010'\u0018\u0001*\u00020(*\u00020/H\u0086\b\u00a2\u0006\u0002\u00100\u00a8\u00061"}, d2 = {"translucentStatusAndNav", "", "Landroid/app/Activity;", "lightStatus", "", "startWebActivity", "titleRes", "", "url", "", "startImprovementProgramWebActivity", "startUserAgreementWebActivity", "startTermServiceWebActivity", "startOpenSourceLicences", "startEmailActivity", "data", "startTelActivity", "startPrivacyPolicyWebActivity", "startExperiencePlan", "startServiceTerms", "title", "startPermissionDescription", "startUserAgreementChina", "startAIService", "startPrivacyPolicy", "startSensitiveInformation", "startPrivacyAgreement", "startFunCWebView", "func", "getDarkSuffix", "getLanguageSuffix", "startActivity", "Landroidx/activity/ComponentActivity;", "cls", "Ljava/lang/Class;", "bundle", "Landroid/os/Bundle;", "newTask", "obtainViewModel", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "Landroid/app/Application;", "(Landroid/app/Application;)Landroidx/lifecycle/ViewModel;", "removeViewModel", "(Landroidx/activity/ComponentActivity;)Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)Landroidx/lifecycle/ViewModel;", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Landroidx/lifecycle/ViewModel;", "nt_ear_GoogleStoreRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ActivityExtKt {
    public static final void translucentStatusAndNav(Activity activity, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(SimulatedPendingIntent.DEFAULT_FLAG);
        activity.getWindow().setStatusBarColor(0);
        activity.getWindow().setNavigationBarColor(0);
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (z) {
            decorView.setSystemUiVisibility(10000);
        } else {
            decorView.setSystemUiVisibility(1792);
        }
    }

    public static /* synthetic */ void startWebActivity$default(Activity activity, int i, String str, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = null;
        }
        startWebActivity(activity, i, str);
    }

    public static final void startWebActivity(Activity activity, int i, String str) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra("title", activity.getString(i)).putExtra("url", str));
    }

    public static final void startImprovementProgramWebActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Activity activity2 = activity;
        activity.startActivity(new Intent(activity2, (Class<?>) WebActivity.class).putExtra("title", activity.getString(R.string.improvement_program_details)).putExtra("url", "file:///android_asset/policy/join_improvement_plan" + (ContextExtKt.isUiModeNight(activity2) ? "_dark" : "_light") + ".html"));
    }

    public static final void startUserAgreementWebActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra("title", activity.getString(R.string.user_agreement)).putExtra("url", "https://nothing.tech/pages/user-agreement"));
    }

    public static final void startTermServiceWebActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra("title", activity.getString(R.string.terms_of_service_title)).putExtra("url", "file:///android_asset/policy/terms_service_" + getLanguageSuffix(activity) + ".html").putExtra(WebActivity.HAS_PADDING, true));
    }

    public static final void startOpenSourceLicences(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Activity activity2 = activity;
        activity.startActivity(new Intent(activity2, (Class<?>) WebActivity.class).putExtra("title", activity.getString(R.string.open_source_licences)).putExtra("url", "file:///android_asset/policy/" + (ContextExtKt.isUiModeNight(activity2) ? "open_source_licences_dark" : "open_source_licences_light") + ".html").putExtra(WebActivity.HAS_PADDING, true).putExtra(WebActivity.NEED_JUMP, false));
    }

    public static final void startEmailActivity(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME + str));
        intent.putExtra("android.intent.extra.EMAIL", str);
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }

    public static final void startTelActivity(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str));
        intent.setFlags(268435456);
        activity.startActivity(intent);
    }

    public static final void startPrivacyPolicyWebActivity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        String str = "file:///android_asset/policy/privacy_notice_" + getLanguageSuffix(activity) + ".html";
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "startPrivacyPolicyWebActivity URL".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str2 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            FileLog.print$default(fileLog, 4, str2, tag, "startPrivacyPolicyWebActivity URL " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "startPrivacyPolicyWebActivity URL " + strComponent2);
            }
        }
        activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra("title", activity.getString(R.string.privacy_notice_title)).putExtra("url", str).putExtra(WebActivity.HAS_PADDING, true).addFlags(268435456));
    }

    public static final void startExperiencePlan(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        String string = activity.getString(R.string.improvement_program_details);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        startFunCWebView(activity, "experience_plan", string);
    }

    public static final void startServiceTerms(Activity activity, String title) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        String string = title;
        if (string.length() == 0) {
            string = activity.getString(R.string.terms_of_service_title);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        startFunCWebView(activity, "service_terms", string);
    }

    public static final void startPermissionDescription(Activity activity, String title) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        startFunCWebView(activity, "permission_description", title);
    }

    public static final void startUserAgreementChina(Activity activity, String title) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Activity activity2 = activity;
        if (ContextExtKt.isUiModeNight(activity2)) {
            str = "https://d35vc3c3b1esnf.cloudfront.net/user_agreement_dark.html";
        } else {
            str = "https://d35vc3c3b1esnf.cloudfront.net/user_agreement_light.html";
        }
        activity.startActivity(new Intent(activity2, (Class<?>) WebActivity.class).putExtra("title", title).putExtra("url", str).putExtra(WebActivity.HAS_PADDING, true).addFlags(268435456));
    }

    public static final void startAIService(Activity activity, String title) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Activity activity2 = activity;
        if (ContextExtKt.isUiModeNight(activity2)) {
            str = "https://provision.nothingtech.link/news_reporter_widget/dark.html";
        } else {
            str = "https://provision.nothingtech.link/news_reporter_widget/light.html";
        }
        activity.startActivity(new Intent(activity2, (Class<?>) WebActivity.class).putExtra("title", title).putExtra("url", str).putExtra(WebActivity.HAS_PADDING, true).addFlags(268435456));
    }

    public static final void startPrivacyPolicy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra("url", "https://nothing.tech/pages/privacy-policy").putExtra(WebActivity.HAS_PADDING, true).addFlags(268435456));
    }

    public static final void startSensitiveInformation(Activity activity, String title) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        startFunCWebView(activity, "sensitive_information", title);
    }

    public static final void startPrivacyAgreement(Activity activity, String title) {
        String str;
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(title, "title");
        Activity activity2 = activity;
        if (ContextExtKt.isUiModeNight(activity2)) {
            str = "https://d35vc3c3b1esnf.cloudfront.net/NothingX_privacy_dark.html";
        } else {
            str = "https://d35vc3c3b1esnf.cloudfront.net/NothingX_privacy_light.html";
        }
        activity.startActivity(new Intent(activity2, (Class<?>) WebActivity.class).putExtra("title", title).putExtra("url", str).putExtra(WebActivity.HAS_PADDING, true).addFlags(268435456));
    }

    private static final void startFunCWebView(Activity activity, String str, String str2) {
        activity.startActivity(new Intent(activity, (Class<?>) WebActivity.class).putExtra("title", str2).putExtra("url", "file:///android_asset/policy/" + str + getDarkSuffix(activity)).putExtra(WebActivity.HAS_PADDING, true).addFlags(268435456));
    }

    private static final String getDarkSuffix(Activity activity) {
        if (ContextExtKt.isUiModeNight(activity)) {
            return "_dark.html";
        }
        return "_light.html";
    }

    private static final String getLanguageSuffix(Activity activity) {
        String str;
        String language;
        String country;
        if (ContextExtKt.isUiModeNight(activity)) {
            str = ToastUtils.MODE.DARK;
        } else {
            str = "light";
        }
        Locale locale = LocaleListCompat.getDefault().get(0);
        if (locale == null || (language = locale.getLanguage()) == null) {
            language = "";
        }
        String language2 = null;
        if (Intrinsics.areEqual(language, Locale.GERMAN.getLanguage()) || Intrinsics.areEqual(language, Locale.FRENCH.getLanguage()) || Intrinsics.areEqual(language, "es") || Intrinsics.areEqual(language, "sr") || Intrinsics.areEqual(language, Locale.ITALIAN.getLanguage()) || Intrinsics.areEqual(language, Locale.JAPAN.getLanguage()) || Intrinsics.areEqual(language, Locale.KOREA.getLanguage())) {
            if (locale != null) {
                language2 = locale.getLanguage();
            }
        } else if (Intrinsics.areEqual(language, Locale.SIMPLIFIED_CHINESE.getLanguage())) {
            if (locale != null && (country = locale.getCountry()) != null) {
                language2 = country.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(language2, "toLowerCase(...)");
            }
            if (Intrinsics.areEqual(language2, "hk")) {
                language2 = "zh_hk";
            } else {
                language2 = "zh_tw";
            }
        } else {
            language2 = "en";
        }
        String lowerCase = (language2 != null ? language2 : "en").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase + "_" + str;
    }

    public static /* synthetic */ void startActivity$default(ComponentActivity componentActivity, Class cls, Bundle bundle, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        startActivity(componentActivity, cls, bundle);
    }

    public static final void startActivity(ComponentActivity componentActivity, Class<?> cls, Bundle bundle) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(cls, "cls");
        Intent intent = new Intent(componentActivity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        componentActivity.startActivity(intent);
    }

    public static /* synthetic */ void startActivity$default(ComponentActivity componentActivity, Class cls, Bundle bundle, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            bundle = null;
        }
        startActivity(componentActivity, cls, bundle, z);
    }

    public static final void startActivity(ComponentActivity componentActivity, Class<?> cls, Bundle bundle, boolean z) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        Intrinsics.checkNotNullParameter(cls, "cls");
        Intent intent = new Intent(componentActivity, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (z) {
            intent.addFlags(268435456);
        }
        componentActivity.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <T extends ViewModel> T obtainViewModel(Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        if (!(application instanceof ViewModelStoreOwner)) {
            return null;
        }
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) application);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) viewModelProvider.get(ViewModel.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void removeViewModel(Application application) {
        Intrinsics.checkNotNullParameter(application, "<this>");
        if (application instanceof ViewModelStoreOwner) {
            ((ViewModelStoreOwner) application).getViewModelStore().clear();
        }
    }

    public static final /* synthetic */ <T extends ViewModel> T obtainViewModel(ComponentActivity componentActivity) {
        Intrinsics.checkNotNullParameter(componentActivity, "<this>");
        ViewModelProvider viewModelProvider = new ViewModelProvider(componentActivity);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) viewModelProvider.get(ViewModel.class);
    }

    public static final /* synthetic */ <T extends ViewModel> T obtainViewModel(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragmentActivity);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) viewModelProvider.get(ViewModel.class);
    }

    public static final /* synthetic */ <T extends ViewModel> T obtainViewModel(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        ViewModelProvider viewModelProvider = new ViewModelProvider(fragment);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) viewModelProvider.get(ViewModel.class);
    }
}
