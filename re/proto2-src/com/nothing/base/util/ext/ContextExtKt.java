package com.nothing.base.util.ext;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.window.layout.WindowMetricsCalculator;
import com.antonkarpenko.ffmpegkit.FFmpegKitFlutterPlugin;
import com.blankj.utilcode.util.ScreenUtils;
import com.nothing.base.util.Logger;
import com.nothing.base.util.NothingOSUtil;
import com.nothing.base.util.ThemeModel;
import com.nothing.base.util.ToastUtil;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseApplication;
import com.nothing.database.util.SpUtils;
import com.nothing.ear.R;
import com.nothing.log.FileLog;
import com.nothing.sdk.NothingUtils;
import com.nothing.xhost.cardparser.parser.param.SimulatedIntent;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ContextExt.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u000e\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\t\u001a\u0016\u0010\u000e\u001a\u00020\u000f*\u00020\t2\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u0011\u001a\u001c\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0013*\u00020\t\u001a\u0012\u0010\u0014\u001a\u00020\u0001*\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000f\u001a\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0012\u0010\u001b\u001a\u00020\b*\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000b\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\t\u001a\u001e\u0010\u001e\u001a\u00020\u0003*\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f\u001a\u0012\u0010!\u001a\u00020\u0001*\u00020\t2\u0006\u0010\"\u001a\u00020\u0003\u001a*\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030$*\u00020\t2\b\b\u0002\u0010\u001f\u001a\u00020\u000f2\b\b\u0002\u0010 \u001a\u00020\u000f\u001a\u001e\u0010%\u001a\u00020\b*\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010'\u001a\u00020\u0001\u001a\u001e\u0010%\u001a\u00020\b*\u00020\t2\b\b\u0001\u0010(\u001a\u00020\u00012\b\b\u0002\u0010'\u001a\u00020\u0001\u001a7\u0010%\u001a\u00020\b*\u00020\t2\b\b\u0001\u0010(\u001a\u00020\u00012\u0012\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0*\"\u00020+2\b\b\u0002\u0010'\u001a\u00020\u0001\u00a2\u0006\u0002\u0010,\u001a\u0012\u0010-\u001a\u00020\u0001*\u00020\t2\u0006\u0010.\u001a\u00020\u0001\u001a\u0012\u0010-\u001a\u00020\u0003*\u00020\t2\u0006\u0010.\u001a\u00020\u0003\u001a\u0012\u0010/\u001a\u00020\u0001*\u00020\t2\u0006\u0010\"\u001a\u00020\u0003\u001a\u001a\u0010/\u001a\u00020\u0001*\u00020\t2\u0006\u0010\"\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0003\u001a\u0012\u00101\u001a\u00020\u0003*\u00020\t2\u0006\u0010.\u001a\u00020\u0003\u001a\u001e\u00104\u001a\u0004\u0018\u000105*\u00020\t2\u0006\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f\u001a\u0016\u00108\u001a\u0004\u0018\u000105*\u00020\t2\u0006\u00106\u001a\u00020\u000fH\u0002\u001a\u0016\u00109\u001a\u0004\u0018\u000105*\u00020\t2\u0006\u00106\u001a\u00020\u000fH\u0002\u001a\u0016\u0010:\u001a\u0004\u0018\u000105*\u00020\t2\u0006\u00106\u001a\u00020\u000fH\u0002\u001a\u001e\u0010;\u001a\u0004\u0018\u000105*\u00020\t2\u0006\u00106\u001a\u00020\u000f2\b\b\u0002\u00107\u001a\u00020\u000f\u001a\u0014\u0010<\u001a\u0004\u0018\u000105*\u00020\t2\u0006\u0010=\u001a\u00020>\u001a\u0006\u0010?\u001a\u00020\u000f\u001a\u0012\u0010@\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002\u001a\u0016\u0010A\u001a\u0004\u0018\u000105*\u00020\t2\u0006\u00106\u001a\u00020\u000fH\u0002\u001a!\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0**\u00020\t2\n\u0010G\u001a\u00020H\"\u00020\u0001\u00a2\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\"\u0015\u00102\u001a\u00020\u000f*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b2\u00103\"\u0015\u0010B\u001a\u00020\u000f*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\bB\u00103\"\u0015\u0010C\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\"\u0015\u0010J\u001a\u00020\u0001*\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bK\u0010L\"\u0015\u0010M\u001a\u00020\u0001*\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bN\u0010L\"\u0015\u0010O\u001a\u00020\u0001*\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bP\u0010L\"\u0015\u0010Q\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\bR\u0010E\"\u0015\u0010S\u001a\u00020\u000f*\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\bT\u0010U\u00a8\u0006V"}, d2 = {"RECENT_NUMBER", "", "HALF_FLOAT", "", "DEVIATION_VALUE", "TIME_OUT", "", "startToSettingDetail", "", "Landroid/content/Context;", "address", "", "getLocalizedResources", "Landroid/content/res/Resources;", "isServiceRunning", "", "clz", "Ljava/lang/Class;", "checkIsSmallModel", "Lkotlin/Triple;", "screenCurrentHeight", "isMax", "getRealSize", "windowManager", "Landroid/view/WindowManager;", "point", "Landroid/graphics/Point;", "copyMac", "mac", "getAdapterScreenWidth", "getDesignDensity", "designCompatFolded", "designBaseWidth", "dpByDesign2px", "dp", "getDesignDensityParams", "Lkotlin/Pair;", "showToast", "message", "duration", "msgRes", "formatArgs", "", "", "(Landroid/content/Context;I[Ljava/lang/Object;I)V", "dip", "value", "dp2px", "radio", "sp2px", "isUiModeNight", "(Landroid/content/Context;)Z", "getNdotFont55", "Landroid/graphics/Typeface;", "isBold", "hasFilter", "getMustNdot55", "getMustNdot57", "getNdot55", "getNdotFont57", "getNtype82", "textView", "Landroid/widget/TextView;", "isCurrentLanguageChinese", "setFirstText", "getNdot77", "isNightMode", "screenWidth", "getScreenWidth", "(Landroid/content/Context;)I", "getStringArray", "stringRes", "", "(Landroid/content/Context;[I)[Ljava/lang/String;", "statusBarHeight", "getStatusBarHeight", "(Landroid/content/res/Resources;)I", "taskBarHeight", "getTaskBarHeight", "navBarHeight", "getNavBarHeight", "navigationBarHeight", "getNavigationBarHeight", "hasNavBar", "getHasNavBar", "(Landroid/content/res/Resources;)Z", "nt_ear_GoogleStoreRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ContextExtKt {
    private static final float DEVIATION_VALUE = 50.0f;
    private static final float HALF_FLOAT = 0.5f;
    private static final int RECENT_NUMBER = 100;
    private static final long TIME_OUT = 1500;

    public static final void startToSettingDetail(Context context, String address) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(address, "address");
        Intent intent = new Intent();
        intent.setPackage("com.nothing.smartcenter");
        intent.setAction("com.nothing.os.device.intent.action.BLUETOOTH_DETAIL");
        intent.putExtra("device_address", address);
        intent.addFlags(SimulatedIntent.DEFAULT_FLAG);
        context.startActivity(intent);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "startToSettingDetail " + address + StringUtils.SPACE + context + "  " + context.getApplicationContext();
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str3 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            }
        }
    }

    public static final Resources getLocalizedResources(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "getConfiguration(...)");
        Configuration configuration2 = new Configuration(configuration);
        if (BaseApplication.INSTANCE.getSystemLocal() == null) {
            configuration2.setLocale(LocaleListCompat.getDefault().get(0));
        } else {
            configuration2.setLocale(BaseApplication.INSTANCE.getSystemLocal());
        }
        Resources resources = context.createConfigurationContext(configuration2).getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return resources;
    }

    public static final boolean isServiceRunning(Context context, Class<?> clz) {
        List<ActivityManager.RunningServiceInfo> runningServices;
        ComponentName componentName;
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(clz, "clz");
        Object systemService = context.getSystemService("activity");
        if (systemService != null && (runningServices = ((ActivityManager) systemService).getRunningServices(100)) != null) {
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (Intrinsics.areEqual(clz.getClass().getName(), (runningServiceInfo == null || (componentName = runningServiceInfo.service) == null) ? null : componentName.getClassName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final Triple<Boolean, Integer, Float> checkIsSmallModel(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int iScreenCurrentHeight = screenCurrentHeight(context, false);
        boolean z = iScreenCurrentHeight != screenCurrentHeight(context, true);
        if (z) {
            iScreenCurrentHeight = displayMetrics.heightPixels;
        }
        return new Triple<>(Boolean.valueOf(z), Integer.valueOf(iScreenCurrentHeight), Float.valueOf(displayMetrics.density));
    }

    public static final int screenCurrentHeight(Context context, boolean z) {
        WindowMetrics currentWindowMetrics;
        androidx.window.layout.WindowMetrics windowMetricsComputeCurrentWindowMetrics;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof FragmentActivity) {
            if (z) {
                windowMetricsComputeCurrentWindowMetrics = WindowMetricsCalculator.INSTANCE.getOrCreate().computeMaximumWindowMetrics((Activity) context);
            } else {
                windowMetricsComputeCurrentWindowMetrics = WindowMetricsCalculator.INSTANCE.getOrCreate().computeCurrentWindowMetrics((Activity) context);
            }
            return windowMetricsComputeCurrentWindowMetrics.getBounds().height();
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        if (Build.VERSION.SDK_INT >= 30) {
            if (z) {
                currentWindowMetrics = windowManager.getMaximumWindowMetrics();
                Intrinsics.checkNotNull(currentWindowMetrics);
            } else {
                currentWindowMetrics = windowManager.getCurrentWindowMetrics();
                Intrinsics.checkNotNull(currentWindowMetrics);
            }
            return currentWindowMetrics.getBounds().height();
        }
        Point point = new Point();
        getRealSize(windowManager, point);
        return point.y;
    }

    private static final void getRealSize(WindowManager windowManager, Point point) {
        windowManager.getDefaultDisplay().getRealSize(point);
    }

    public static final void copyMac(Context context, String mac) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        Object systemService = context.getSystemService("clipboard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("Label", mac));
    }

    public static final int getAdapterScreenWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (context instanceof BaseActivity) {
            if (((BaseActivity) context).getWindowType() >= 1) {
                return ScreenUtils.getScreenWidth() / 2;
            }
            return ScreenUtils.getScreenWidth();
        }
        return ScreenUtils.getScreenWidth();
    }

    public static /* synthetic */ float getDesignDensity$default(Context context, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return getDesignDensity(context, z, z2);
    }

    public static final float getDesignDensity(Context context, boolean z, boolean z2) {
        int screenWidth;
        float screenHeight;
        float f;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (z) {
            screenWidth = getAdapterScreenWidth(context);
        } else {
            screenWidth = ScreenUtils.getScreenWidth();
        }
        if (z2) {
            screenHeight = screenWidth;
            f = 414.0f;
        } else {
            screenHeight = ScreenUtils.getScreenHeight();
            f = 920.0f;
        }
        return screenHeight / f;
    }

    public static final int dpByDesign2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) ((f * getDesignDensity$default(context, false, false, 3, null)) + 0.5f);
    }

    public static /* synthetic */ Pair getDesignDensityParams$default(Context context, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return getDesignDensityParams(context, z, z2);
    }

    public static final Pair<Integer, Float> getDesignDensityParams(Context context, boolean z, boolean z2) {
        int screenWidth;
        float screenHeight;
        float f;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (z) {
            screenWidth = getAdapterScreenWidth(context);
        } else {
            screenWidth = ScreenUtils.getScreenWidth();
        }
        if (z2) {
            screenHeight = screenWidth;
            f = 414.0f;
        } else {
            screenHeight = ScreenUtils.getScreenHeight();
            f = 920.0f;
        }
        return TuplesKt.to(Integer.valueOf(screenWidth), Float.valueOf(screenHeight / f));
    }

    public static /* synthetic */ void showToast$default(Context context, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        showToast(context, str, i);
    }

    public static final void showToast(Context context, String str, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return;
        }
        ToastUtil.INSTANCE.showToast(context, str, i);
    }

    public static /* synthetic */ void showToast$default(Context context, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        showToast(context, i, i2);
    }

    public static final void showToast(Context context, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        ToastUtil toastUtil = ToastUtil.INSTANCE;
        String string = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        toastUtil.showToast(context, string, i2);
    }

    public static /* synthetic */ void showToast$default(Context context, int i, Object[] objArr, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        showToast(context, i, objArr, i2);
    }

    public static final void showToast(Context context, int i, Object[] formatArgs, int i2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(formatArgs, "formatArgs");
        ToastUtil toastUtil = ToastUtil.INSTANCE;
        String string = context.getString(i, formatArgs);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        toastUtil.showToast(context, string, i2);
    }

    public static final int dip(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) (i * context.getResources().getDisplayMetrics().density);
    }

    public static final float dip(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return f * context.getResources().getDisplayMetrics().density;
    }

    public static final int dp2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final int dp2px(Context context, float f, float f2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (int) ((f * context.getResources().getDisplayMetrics().density * f2) + 0.5f);
    }

    public static final float sp2px(Context context, float f) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }

    public static final boolean isUiModeNight(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static /* synthetic */ Typeface getNdotFont55$default(Context context, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return getNdotFont55(context, z, z2);
    }

    public static final Typeface getNdotFont55(Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (z2) {
            return getNdot55(context, z);
        }
        return getMustNdot55(context, z);
    }

    private static final Typeface getMustNdot55(Context context, boolean z) {
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), "ja")) {
            return ResourcesCompat.getFont(context, R.font.ndot77_jp);
        }
        if (z) {
            return ResourcesCompat.getFont(context, R.font.ndot_55_caps);
        }
        return ResourcesCompat.getFont(context, R.font.ndot_55);
    }

    private static final Typeface getMustNdot57(Context context, boolean z) {
        if (Intrinsics.areEqual(Locale.getDefault().getLanguage(), "ja")) {
            return ResourcesCompat.getFont(context, R.font.ndot77_jp);
        }
        if (z) {
            return ResourcesCompat.getFont(context, R.font.ndot_57_caps);
        }
        return ResourcesCompat.getFont(context, R.font.ndot_57);
    }

    private static final Typeface getNdot55(Context context, boolean z) {
        String language = Locale.getDefault().getLanguage();
        if (NothingUtils.isSupportNdot(language) && Intrinsics.areEqual(language, "ja")) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "font_type  \u00c8\u00d5\u00d3\u00ef ndot".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "font_type  \u00c8\u00d5\u00d3\u00ef ndot " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "font_type  \u00c8\u00d5\u00d3\u00ef ndot " + strComponent2);
                }
            }
            return ResourcesCompat.getFont(context, R.font.ndot77_jp);
        }
        if (NothingUtils.isSupportNdot(language) && z) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "font_type ndot \u00bc\u00d3\u00b4\u00d6".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 3, str2, tag2, "font_type ndot \u00bc\u00d3\u00b4\u00d6 " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "font_type ndot \u00bc\u00d3\u00b4\u00d6 " + strComponent4);
                }
            }
            return ResourcesCompat.getFont(context, R.font.ndot_55_caps);
        }
        if (NothingUtils.isSupportNdot(language)) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "font_type ndot".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog3, 3, str3, tag3, "font_type ndot " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, "font_type ndot " + strComponent6);
                }
            }
            return ResourcesCompat.getFont(context, R.font.ndot_55);
        }
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true) && "font_type \u00cf\u00b5\u00cd\u00b3\u00c4\u00ac\u00c8\u00cf".length() != 0) {
            Pair<String, String> trace4 = logger4.getTrace(depth4);
            String strComponent7 = trace4.component1();
            String strComponent8 = trace4.component2();
            FileLog fileLog4 = FileLog.INSTANCE;
            String str4 = logger4.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog4, 3, str4, tag4, "font_type \u00cf\u00b5\u00cd\u00b3\u00c4\u00ac\u00c8\u00cf " + strComponent8, null, 16, null);
            if (logger4.isDebug()) {
                Log.i(tag4 + strComponent7, "font_type \u00cf\u00b5\u00cd\u00b3\u00c4\u00ac\u00c8\u00cf " + strComponent8);
            }
        }
        return Typeface.DEFAULT;
    }

    public static /* synthetic */ Typeface getNdotFont57$default(Context context, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return getNdotFont57(context, z, z2);
    }

    public static final Typeface getNdotFont57(Context context, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (z2) {
            return getNdot77(context, z);
        }
        return getMustNdot57(context, z);
    }

    public static final Typeface getNtype82(Context context, TextView textView) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(textView, "textView");
        String language = Locale.getDefault().getLanguage();
        if (NothingUtils.isNotoSerif(language) || (!NothingOSUtil.INSTANCE.isNothingOS() && isCurrentLanguageChinese())) {
            setFirstText(textView);
            return Typeface.create("serif", 0);
        }
        if (!NothingUtils.isSupportNType(language)) {
            Intrinsics.checkNotNull(language);
            String str = language;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "pt", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "hu", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "sl", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) str, (CharSequence) "ro", false, 2, (Object) null)) {
                return Typeface.DEFAULT;
            }
        }
        setFirstText(textView);
        return ResourcesCompat.getFont(context, R.font.ntype82_regular);
    }

    public static final boolean isCurrentLanguageChinese() {
        return Intrinsics.areEqual(Locale.getDefault().getLanguage(), "zh");
    }

    private static final void setFirstText(TextView textView) {
        CharSequence text;
        String string;
        boolean z;
        boolean z2;
        if (textView != null) {
            textView.setAllCaps(false);
        }
        if (textView == null || (text = textView.getText()) == null || (string = text.toString()) == null) {
            return;
        }
        Context context = textView.getContext();
        if (Intrinsics.areEqual(string, context != null ? context.getString(R.string.new_voice_assistant_title) : null)) {
            return;
        }
        String str = string;
        int i = 0;
        while (true) {
            if (i >= str.length()) {
                z = false;
                break;
            } else {
                if (Character.UnicodeScript.of(str.charAt(i)) == Character.UnicodeScript.HAN) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                z2 = false;
                break;
            }
            char cCharAt = str.charAt(i2);
            if (('A' <= cCharAt && cCharAt < '[') || ('a' <= cCharAt && cCharAt < '{')) {
                z2 = true;
                break;
            }
            i2++;
        }
        if (z && z2) {
            return;
        }
        String lowerCase = string.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (lowerCase.length() > 0) {
            StringBuilder sb = new StringBuilder();
            String strValueOf = String.valueOf(lowerCase.charAt(0));
            Intrinsics.checkNotNull(strValueOf, "null cannot be cast to non-null type java.lang.String");
            String upperCase = strValueOf.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            StringBuilder sbAppend = sb.append((Object) upperCase);
            String strSubstring = lowerCase.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            lowerCase = sbAppend.append(strSubstring).toString();
        }
        textView.setText(lowerCase);
    }

    private static final Typeface getNdot77(Context context, boolean z) {
        String language = Locale.getDefault().getLanguage();
        if (NothingUtils.isSupportNdot(language) && Intrinsics.areEqual(language, "ja")) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "font_type  \u00c8\u00d5\u00d3\u00ef ndot".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "font_type  \u00c8\u00d5\u00d3\u00ef ndot " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "font_type  \u00c8\u00d5\u00d3\u00ef ndot " + strComponent2);
                }
            }
            return ResourcesCompat.getFont(context, R.font.ndot77_jp);
        }
        if (NothingUtils.isSupportNdot(language) && z) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "font_type ndot \u00bc\u00d3\u00b4\u00d6".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str2 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog2, 3, str2, tag2, "font_type ndot \u00bc\u00d3\u00b4\u00d6 " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "font_type ndot \u00bc\u00d3\u00b4\u00d6 " + strComponent4);
                }
            }
            return ResourcesCompat.getFont(context, R.font.ndot_57_caps);
        }
        if (NothingUtils.isSupportNdot(language)) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "font_type ndot".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog3, 3, str3, tag3, "font_type ndot " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, "font_type ndot " + strComponent6);
                }
            }
            return ResourcesCompat.getFont(context, R.font.ndot_57);
        }
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true) && "font_type \u00cf\u00b5\u00cd\u00b3\u00c4\u00ac\u00c8\u00cf".length() != 0) {
            Pair<String, String> trace4 = logger4.getTrace(depth4);
            String strComponent7 = trace4.component1();
            String strComponent8 = trace4.component2();
            FileLog fileLog4 = FileLog.INSTANCE;
            String str4 = logger4.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog4, 3, str4, tag4, "font_type \u00cf\u00b5\u00cd\u00b3\u00c4\u00ac\u00c8\u00cf " + strComponent8, null, 16, null);
            if (logger4.isDebug()) {
                Log.i(tag4 + strComponent7, "font_type \u00cf\u00b5\u00cd\u00b3\u00c4\u00ac\u00c8\u00cf " + strComponent8);
            }
        }
        return Typeface.DEFAULT;
    }

    public static final boolean isNightMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        int selectTheme = SpUtils.INSTANCE.getSelectTheme();
        if (selectTheme == ThemeModel.LIGHT_MODE.getTheme()) {
            return false;
        }
        if (selectTheme == ThemeModel.DARK_MODE.getTheme()) {
            return true;
        }
        return selectTheme == ThemeModel.FOLLOW_MODE.getTheme() && (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static final int getScreenWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static final String[] getStringArray(Context context, int... stringRes) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(stringRes, "stringRes");
        int length = stringRes.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String string = context.getString(stringRes[i]);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            strArr[i] = string;
        }
        return strArr;
    }

    public static final int getStatusBarHeight(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        return ((Number) BuildersKt__BuildersKt.runBlocking$default(null, new ContextExtKt$statusBarHeight$1(resources, null), 1, null)).intValue();
    }

    public static final int getTaskBarHeight(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        int identifier = resources.getIdentifier("task_bar_height", "dimen", FFmpegKitFlutterPlugin.PLATFORM_NAME);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static final int getNavBarHeight(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        return ((Number) BuildersKt__BuildersKt.runBlocking$default(null, new ContextExtKt$navBarHeight$1(resources, null), 1, null)).intValue();
    }

    public static final int getNavigationBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        int iDisplayCutout = WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.systemBars();
        if (Build.VERSION.SDK_INT >= 30) {
            return windowManager.getCurrentWindowMetrics().getWindowInsets().getInsets(iDisplayCutout).bottom;
        }
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return getNavBarHeight(resources);
    }

    public static final boolean getHasNavBar(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "<this>");
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", FFmpegKitFlutterPlugin.PLATFORM_NAME);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "sure navbar hasNavBar:" + identifier + "," + resources.getBoolean(identifier);
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (identifier > 0) {
            return resources.getBoolean(identifier);
        }
        return false;
    }
}
