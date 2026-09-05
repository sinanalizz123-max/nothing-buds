package com.nothing.base.util;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import com.antonkarpenko.ffmpegkit.FFmpegKitFlutterPlugin;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.nothing.account.ServiceBinderHost;
import com.nothing.cardservice.sharewidget.ShareConstantsKt;
import com.nothing.cardwidget.battery.BatteryConfig;
import com.nothing.database.util.SpUtils;
import com.nothing.log.FileLog;
import com.nothing.nt_2fa_dialog.Nt2FADialogActivity;
import com.nothing.sdk.features.NtFeaturesUtils;
import java.util.Date;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.MachineMetadata;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: NothingOSUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0010\u0010\b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\f\u001a\u00020\u0005J\u0006\u0010\r\u001a\u00020\u0005J\u001a\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000f\u001a\u00020\u0005J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0002J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0018J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u0010\u0010\u001b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001c\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001d\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\"\u0010\u001e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J \u0010 \u001a\u00020!2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012J\u0018\u0010\"\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0006\u0010#\u001a\u00020\u0005J\u0006\u0010$\u001a\u00020\u0005J\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010(\u001a\u00020\u0016J\u0006\u0010)\u001a\u00020\u0005J\b\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010,\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0012R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0016X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/nothing/base/util/NothingOSUtil;", "", "<init>", "()V", "isNotGooglePlay", "", "isAlpha", "isBeta", Nt2FADialogActivity.EXTRA_IS_CHINA, "context", "Landroid/content/Context;", "isGooglePlay", "isCanDebug", "isNothingOS", "isNothingLaunch", "isEarWidget", "SYSTEM_PLACEHOLDERS", "", "", "NOTHING_LAUNCHERS", "currentLauncherPackage", "getAppVersionCode", "", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Long;", "isCantOpenApp", "isNeedCollection", "isSupportNews", "isSupportConfig", "settingSupportSpatial", "checkMetaDataSupport", "key", "getMetaDataSupport", "", "isAppInstalled", "isSupportEssential", "isPjMe", "isSupportEssentialVoice", "ESSENTIAL_RECORDER_PACKAGE", "ESSENTIAL_RECORDER_MIN_VERSION_CODE", "getEssentialRecorderVersionCode", "isEssentialRecorderNewProtocol", "checkEssentialVersion", "isSupportNewsConfigs", "getCurrentLauncherPackageIsNothing", "isSupportFeatureOfNothing", "feature", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NothingOSUtil {
    private static final long ESSENTIAL_RECORDER_MIN_VERSION_CODE = 161000;
    private static final String ESSENTIAL_RECORDER_PACKAGE = "com.nothing.ntessentialrecorder";
    public static final NothingOSUtil INSTANCE = new NothingOSUtil();
    private static final Set<String> SYSTEM_PLACEHOLDERS = SetsKt.setOf((Object[]) new String[]{FFmpegKitFlutterPlugin.PLATFORM_NAME, ServiceBinderHost.SETTINGS_PACKAGE_NAME});
    private static final Set<String> NOTHING_LAUNCHERS = SetsKt.setOf((Object[]) new String[]{ShareConstantsKt.PACKAGE_LAUNCHER, "com.nothing.launch"});

    public final boolean isCanDebug() {
        return false;
    }

    private NothingOSUtil() {
    }

    public final boolean isNotGooglePlay() {
        return !StringsKt.contains((CharSequence) "GoogleStore", (CharSequence) "Store", true);
    }

    public final boolean isAlpha() {
        return StringsKt.startsWith("GoogleStore", MachineMetadata.MACHINE_ALPHA, true);
    }

    public final boolean isBeta() {
        return StringsKt.contains((CharSequence) "GoogleStore", (CharSequence) "Beta", true) || StringsKt.equals("GoogleStore", "ChinaBeta", true);
    }

    public final boolean isChina(Context context) {
        String packageName;
        if (context == null || (packageName = context.getPackageName()) == null) {
            return false;
        }
        return StringsKt.contains$default((CharSequence) packageName, (CharSequence) "com.nothing.smartcenter_cn", false, 2, (Object) null);
    }

    public final boolean isGooglePlay() {
        return StringsKt.contains((CharSequence) "GoogleStore", (CharSequence) "Play", true);
    }

    public final boolean isNothingOS() {
        return Intrinsics.areEqual(Build.BRAND, "Nothing");
    }

    public static /* synthetic */ boolean isNothingLaunch$default(NothingOSUtil nothingOSUtil, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return nothingOSUtil.isNothingLaunch(context, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    public final boolean isNothingLaunch(Context context, boolean isEarWidget) {
        NothingOSUtil length;
        try {
            String strCurrentLauncherPackage = currentLauncherPackage(context);
            Logger logger = Logger.INSTANCE;
            Logger logger2 = logger;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger2.isCanLogger(true)) {
                String str = "current launch name:" + strCurrentLauncherPackage;
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger2.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            length = strCurrentLauncherPackage.length();
            try {
                if (length <= 0 || !NOTHING_LAUNCHERS.contains(strCurrentLauncherPackage)) {
                    return strCurrentLauncherPackage.length() == 0 && isNothingOS();
                }
                if (context == null) {
                    return true;
                }
                Long appVersionCode = getAppVersionCode(context, strCurrentLauncherPackage);
                return (appVersionCode != null ? appVersionCode.longValue() : 0L) > 2020100 || isEarWidget;
            } catch (Exception e) {
                e = e;
                Logger logger3 = Logger.INSTANCE;
                String tag2 = logger3.getTAG();
                int depth2 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str4 = "isNothingLaunch exception: " + e.getMessage();
                    String str5 = str4;
                    if (str5 != null && str5.length() != 0) {
                        Pair<String, String> trace2 = logger3.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str6 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                        FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                e.printStackTrace();
                return length.isNothingOS();
            }
        } catch (Exception e2) {
            e = e2;
            length = this;
        }
    }

    private final String currentLauncherPackage(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intentAddCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME");
            Intrinsics.checkNotNullExpressionValue(intentAddCategory, "addCategory(...)");
            ResolveInfo resolveInfoResolveActivity = packageManager.resolveActivity(intentAddCategory, 65536);
            if (resolveInfoResolveActivity == null) {
                return "";
            }
            ActivityInfo activityInfo = resolveInfoResolveActivity.activityInfo;
            String str = activityInfo != null ? activityInfo.packageName : null;
            if (str == null) {
                str = "";
            }
            return (str.length() == 0 || SYSTEM_PLACEHOLDERS.contains(str)) ? "" : str;
        } catch (Exception e) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "currentLauncherPackage exception: " + e.getMessage();
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            e.printStackTrace();
            return "";
        }
    }

    public final Long getAppVersionCode(Context context, String packageName) {
        long longVersionCode;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            if (Build.VERSION.SDK_INT >= 28) {
                longVersionCode = packageInfo.getLongVersionCode();
            } else {
                longVersionCode = packageInfo.versionCode;
            }
            return Long.valueOf(longVersionCode);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public final boolean isCantOpenApp() {
        isNothingOS();
        return false;
    }

    public final boolean isNeedCollection() {
        Application application = AppGlobals.INSTANCE.get();
        return Settings.System.getInt(application != null ? application.getContentResolver() : null, "nt_data_collection", 0) != 0;
    }

    public final boolean isSupportNews(Context context) {
        if (SpUtils.INSTANCE.isSupportNews() != -1) {
            return SpUtils.INSTANCE.isSupportNews() == 1;
        }
        if (checkMetaDataSupport(context, BatteryConfig.DEFAULT_PACKAGE_NAME, "nothingx_call_news_supported")) {
            SpUtils.INSTANCE.setSupportNews(1);
        } else {
            SpUtils.INSTANCE.setSupportNews(0);
        }
        return SpUtils.INSTANCE.isSupportNews() == 1;
    }

    public final boolean isSupportConfig(Context context) {
        return checkMetaDataSupport(context, ServiceBinderHost.SETTINGS_PACKAGE_NAME, "nothingx_call_settings_config_supported");
    }

    public final boolean settingSupportSpatial(Context context) {
        return !isChina(context) && checkMetaDataSupport(context, ServiceBinderHost.SETTINGS_PACKAGE_NAME, "spatial_audio_supported");
    }

    private final boolean checkMetaDataSupport(Context context, String packageName, String key) {
        ApplicationInfo applicationInfo;
        if (!isAppInstalled(packageName, context)) {
            return false;
        }
        PackageManager packageManager = context != null ? context.getPackageManager() : null;
        if (packageManager != null) {
            try {
                applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    e.printStackTrace();
                    String str = "metadata crash:" + Unit.INSTANCE;
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
            }
        } else {
            applicationInfo = null;
        }
        Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
        if (bundle != null) {
            int i = bundle.getInt(key);
            Logger logger2 = Logger.INSTANCE;
            Logger logger3 = logger2;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger3.isCanLogger(true)) {
                String str4 = " isSupport:" + bundle;
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace2 = logger3.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str6 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            return i == 1;
        }
        return false;
    }

    public final int getMetaDataSupport(Context context, String packageName, String key) {
        ApplicationInfo applicationInfo;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(key, "key");
        if (!isAppInstalled(packageName, context)) {
            return -1;
        }
        PackageManager packageManager = context != null ? context.getPackageManager() : null;
        if (packageManager != null) {
            try {
                applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    e.printStackTrace();
                    String str = "getMetaDataSupport " + key + " crash:" + Unit.INSTANCE;
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
            }
        } else {
            applicationInfo = null;
        }
        Bundle bundle = applicationInfo != null ? applicationInfo.metaData : null;
        if (bundle != null) {
            int i = bundle.getInt(key);
            Logger logger2 = Logger.INSTANCE;
            Logger logger3 = logger2;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger3.isCanLogger(true)) {
                String str4 = " getMetaDataSupport " + key + " :" + bundle;
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace2 = logger3.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str6 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            return i;
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0015  */
    public final boolean isAppInstalled(String packageName, Context context) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageInfo = packageManager.getPackageInfo(packageName, 1);
                } else {
                    packageInfo = null;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                return false;
            }
        } else {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public final boolean isSupportEssential() {
        return isNothingOS() && !isChina(AppGlobals.INSTANCE.get()) && isSupportFeatureOfNothing("NTF_EK") && checkEssentialVersion();
    }

    public final boolean isPjMe() {
        if (isNothingOS()) {
            return isSupportFeatureOfNothing("NTF_PJ_ME");
        }
        return false;
    }

    public final boolean isSupportEssentialVoice() {
        if (isNothingOS()) {
            return isSupportFeatureOfNothing("NTF_PJ_COP") || isSupportFeatureOfNothing("NTF_PJ_FRB") || isSupportFeatureOfNothing("NTF_PJ_FRP") || isSupportFeatureOfNothing("NTF_PJ_ME");
        }
        return false;
    }

    public final long getEssentialRecorderVersionCode() {
        PackageManager packageManager;
        PackageInfo packageInfo;
        try {
            Application application = AppGlobals.INSTANCE.get();
            if (application != null && (packageManager = application.getPackageManager()) != null && (packageInfo = packageManager.getPackageInfo(ESSENTIAL_RECORDER_PACKAGE, 0)) != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return packageInfo.getLongVersionCode();
                }
                return packageInfo.versionCode;
            }
            return 0L;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0L;
        }
    }

    public final boolean isEssentialRecorderNewProtocol() {
        PackageManager packageManager;
        PackageInfo packageInfo;
        String str;
        if (getEssentialRecorderVersionCode() >= ESSENTIAL_RECORDER_MIN_VERSION_CODE) {
            return true;
        }
        try {
            Application application = AppGlobals.INSTANCE.get();
            if (application == null || (packageManager = application.getPackageManager()) == null || (packageInfo = packageManager.getPackageInfo(ESSENTIAL_RECORDER_PACKAGE, 0)) == null || (str = packageInfo.versionName) == null) {
                return false;
            }
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            if (listSplit$default.size() != 3) {
                return false;
            }
            return Integer.parseInt((String) listSplit$default.get(0)) > 16 || (Integer.parseInt((String) listSplit$default.get(0)) == 16 && (Integer.parseInt((String) listSplit$default.get(1)) > 1 || (Integer.parseInt((String) listSplit$default.get(1)) == 1 && Integer.parseInt((String) listSplit$default.get(2)) >= 0)));
        } catch (Exception unused) {
        }
        return false;
    }

    private final boolean checkEssentialVersion() {
        String str;
        PackageManager packageManager;
        try {
            Application application = AppGlobals.INSTANCE.get();
            PackageInfo packageInfo = (application == null || (packageManager = application.getPackageManager()) == null) ? null : packageManager.getPackageInfo(ESSENTIAL_RECORDER_PACKAGE, 0);
            if (packageInfo != null && (str = packageInfo.versionName) != null) {
                Logger logger = Logger.INSTANCE;
                Logger logger2 = Logger.INSTANCE;
                Logger logger3 = logger;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str2 = "essential recorder version:" + str;
                    String str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        Pair<String, String> trace = logger3.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str4 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                        FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
                if (listSplit$default.size() != 3) {
                    return false;
                }
                return Integer.parseInt((String) listSplit$default.get(0)) > 15 || (Integer.parseInt((String) listSplit$default.get(0)) == 15 && (Integer.parseInt((String) listSplit$default.get(1)) > 0 || (Integer.parseInt((String) listSplit$default.get(1)) == 0 && Integer.parseInt((String) listSplit$default.get(2)) >= 9)));
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isSupportNewsConfigs(Context context) {
        return checkMetaDataSupport(context, BatteryConfig.DEFAULT_PACKAGE_NAME, "nothingx_call_news_supported_settings_api_level");
    }

    public final boolean getCurrentLauncherPackageIsNothing(Context context) {
        String str;
        ActivityInfo activityInfo;
        PackageManager packageManager;
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveInfoResolveActivity = (context == null || (packageManager = context.getPackageManager()) == null) ? null : packageManager.resolveActivity(intent, 65536);
            if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null || (str = activityInfo.packageName) == null) {
                str = "";
            }
            return StringsKt.contains$default((CharSequence) str, (CharSequence) "com.nothing.", false, 2, (Object) null);
        } catch (Exception e) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "getCurrentLauncherPackageIsNothing exception: " + e.getMessage();
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            e.printStackTrace();
            return false;
        }
    }

    public final boolean isSupportFeatureOfNothing(String feature) {
        Intrinsics.checkNotNullParameter(feature, "feature");
        try {
            return NtFeaturesUtils.isSupport(feature);
        } catch (Exception unused) {
            return false;
        }
    }
}
