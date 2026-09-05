package com.nothing.base.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ContentResolver;
import android.graphics.Point;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.google.firebase.messaging.Constants;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.cli.HelpFormatter;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: PhoneUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u0006\u0010\u0018\u001a\u00020\u0015J\u0006\u0010\u0019\u001a\u00020\u0015J\u0006\u0010\u001a\u001a\u00020\u0015J\u0006\u0010\u001b\u001a\u00020\u0015J\u0006\u0010\u001c\u001a\u00020\u0015J\u0006\u0010\u001d\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020\u0015J\b\u0010\u001f\u001a\u00020\u0015H\u0007J\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000bJ\u0006\u0010$\u001a\u00020\u000bJ\b\u0010%\u001a\u00020\u0007H\u0002J\u000e\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006'"}, d2 = {"Lcom/nothing/base/util/PhoneUtil;", "", "<init>", "()V", "TWO_NUMBER", "", "TEN_NUMBER", "", "BYTE_NUMBER", "SIZE_NUMBER", "fontSize", "", "displaySize", "setFontSize", "", "font", "setDisplayDensity", Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "getFontSize", "getDisplayDensity", "getOsVersion", "", "getCategory", "getBrandName", "getModelName", "getHardWareModel", "getOperatingVersion", "getHardwareDeviceId", "generateUniqueDeviceId", "getLanguage", "getRamSize", "getNetWorkType", "getOperation1", "getSimCode", "setAdapterHeight", "size", "getAdapterHeightRadio", "testHeight", "setAdapterWidth", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhoneUtil {
    private static final int BYTE_NUMBER = 1024;
    private static final double SIZE_NUMBER = 6.8d;
    private static final int TEN_NUMBER = 10;
    private static final double TWO_NUMBER = 2.0d;
    public static final PhoneUtil INSTANCE = new PhoneUtil();
    private static float fontSize = 1.0f;
    private static float displaySize = 1.0f;

    private PhoneUtil() {
    }

    public final void setFontSize(float font) {
        fontSize = font;
    }

    public final void setDisplayDensity(float display) {
        displaySize = display;
    }

    public final float getFontSize() {
        return fontSize;
    }

    public final float getDisplayDensity() {
        return displaySize;
    }

    public final String getOsVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    public final String getCategory() {
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        DisplayMetrics displayMetrics = application.getResources().getDisplayMetrics();
        if (Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d)) >= SIZE_NUMBER) {
            return "tablet";
        }
        return "phone";
    }

    public final String getBrandName() {
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        return BRAND;
    }

    public final String getModelName() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    public final String getHardWareModel() {
        String HARDWARE = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
        return HARDWARE;
    }

    public final String getOperatingVersion() {
        String RELEASE = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(RELEASE, "RELEASE");
        return RELEASE;
    }

    public final String getHardwareDeviceId() {
        String str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10);
        int length = Build.MODEL.length() % 10;
        int length2 = Build.PRODUCT.length() % 10;
        int length3 = Build.TAGS.length() % 10;
        int length4 = Build.TYPE.length() % 10;
        int length5 = Build.USER.length() % 10;
        try {
            return StringsKt.replace$default(new UUID(str.hashCode(), Build.class.getField("SERIAL").get(null).toString().hashCode()).toString(), HelpFormatter.DEFAULT_OPT_PREFIX, "", false, 4, (Object) null);
        } catch (Exception unused) {
            return StringsKt.replace$default(new UUID(str.hashCode(), "serial".hashCode()).toString(), HelpFormatter.DEFAULT_OPT_PREFIX, "", false, 4, (Object) null);
        }
    }

    public final String generateUniqueDeviceId() throws NoSuchAlgorithmException {
        String string;
        Application application = AppGlobals.INSTANCE.get();
        ContentResolver contentResolver = application != null ? application.getContentResolver() : null;
        if (contentResolver == null) {
            string = "";
        } else {
            string = Settings.Secure.getString(contentResolver, "android_id");
        }
        if (TextUtils.isEmpty(string)) {
            String string2 = SPUtils.getInstance().getString("android_id");
            String str = string2;
            if (str != null && str.length() != 0) {
                return string2;
            }
            String string3 = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
            String md5 = DataExtKt.toMD5(StringsKt.replace$default(StringsKt.replace$default(string3, HelpFormatter.DEFAULT_OPT_PREFIX, "", false, 4, (Object) null), StringUtils.SPACE, "", false, 4, (Object) null));
            SPUtils.getInstance().put("android_id", md5);
            return md5;
        }
        return DataExtKt.toMD5(string);
    }

    public final String getLanguage() {
        String language = Locale.getDefault().getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    public final String getRamSize() {
        return (new ActivityManager.MemoryInfo().totalMem / ((long) 1024)) + "MB";
    }

    public final String getNetWorkType() {
        Object networkType;
        try {
            networkType = com.blankj.utilcode.util.NetworkUtils.getNetworkType();
        } catch (Exception unused) {
            networkType = "";
        }
        if (networkType == com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_5G) {
            return "5G";
        }
        if (networkType == com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_4G) {
            return "4G";
        }
        if (networkType == com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_3G) {
            return "3G";
        }
        return networkType == com.blankj.utilcode.util.NetworkUtils.NetworkType.NETWORK_2G ? "2G" : "wifi";
    }

    public final String getOperation1() {
        String simOperatorName = PhoneUtils.getSimOperatorName();
        Intrinsics.checkNotNullExpressionValue(simOperatorName, "getSimOperatorName(...)");
        return simOperatorName;
    }

    public final String getSimCode() {
        String simOperatorByMnc = PhoneUtils.getSimOperatorByMnc();
        Intrinsics.checkNotNullExpressionValue(simOperatorByMnc, "getSimOperatorByMnc(...)");
        return simOperatorByMnc;
    }

    public final int setAdapterHeight(float size) {
        Application application = AppGlobals.INSTANCE.get();
        if (application == null) {
            return (int) size;
        }
        Application application2 = application;
        Triple<Boolean, Integer, Float> tripleCheckIsSmallModel = ContextExtKt.checkIsSmallModel(application2);
        return (int) (ContextExtKt.dp2px(application2, size) * ((((int) (tripleCheckIsSmallModel.getSecond().intValue() / tripleCheckIsSmallModel.getThird().floatValue())) * 1.0f) / 920.0f));
    }

    public final float getAdapterHeightRadio() {
        Application application = AppGlobals.INSTANCE.get();
        if (application == null) {
            return 1.0f;
        }
        Triple<Boolean, Integer, Float> tripleCheckIsSmallModel = ContextExtKt.checkIsSmallModel(application);
        return (((int) (tripleCheckIsSmallModel.getSecond().intValue() / tripleCheckIsSmallModel.getThird().floatValue())) * 1.0f) / 920.0f;
    }

    private final int testHeight() {
        Object systemService = com.blankj.utilcode.util.Utils.getApp().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Point point = new Point();
        ((WindowManager) systemService).getDefaultDisplay().getSize(point);
        return point.y;
    }

    public final int setAdapterWidth(float size) {
        return (int) (size * ((ScreenUtils.getScreenHeight() * 1.0f) / 920.0f));
    }
}
