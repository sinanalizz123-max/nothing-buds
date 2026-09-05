package com.nothing.base.util;

import android.app.Application;
import androidx.core.text.util.LocalePreferences;
import com.google.common.net.HttpHeaders;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.cli.HelpFormatter;

/* JADX INFO: compiled from: LanguageUtils.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\u0006J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0006\u0010\r\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/base/util/LanguageUtils;", "", "<init>", "()V", "languageMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "supportLanguageMap", "supportTicketLanguageMap", "supportCategoryLanguageMap", "getSupportCategoryLanguage", "matchLanguage", "getLanguage", "getSupportLanguage", "isTicket", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LanguageUtils {
    public static final LanguageUtils INSTANCE = new LanguageUtils();
    private static final HashMap<String, String> languageMap = MapsKt.hashMapOf(new Pair("AF", "af"), new Pair("AM", "am"), new Pair("AR", "ar"), new Pair("AZ-AZ", "az-AZ"), new Pair("AZ", "az-AZ"), new Pair("BG", "bg"), new Pair("BN-BD", "bn-BD"), new Pair("BN", "bn-BD"), new Pair("CA", "ca"), new Pair("CS-CZ", "cs-CZ"), new Pair("CS", "cs-CZ"), new Pair("DA-DK", "da-DK"), new Pair("DA", "da-DK"), new Pair("DE-DE", "de-DE"), new Pair("DE", "de-DE"), new Pair("el-GR", "el-GR"), new Pair("el", "el-GR"), new Pair("EN-AU", "en-AU"), new Pair("EN-CA", "en-CA"), new Pair("EN-GB", "en-GB"), new Pair("EN-IN", "en-IN"), new Pair("EN-SG", "en-SG"), new Pair("EN-US", "en-US"), new Pair("EN", "en-US"), new Pair("ES-419", "es-419"), new Pair("ES-ES", "es-ES"), new Pair("ES-US", "es-US"), new Pair("ES", "es-US"), new Pair("ET", "et"), new Pair("FA", "fa"), new Pair("FI-FI", "fi-FI"), new Pair("FI", "fi-FI"), new Pair("FIL", "fil"), new Pair("FR-CA", "fr-CA"), new Pair("FR-FR", "fr-FR"), new Pair("FR", "fr-FR"), new Pair("HI-IN", "hi-IN"), new Pair("HI", "hi-IN"), new Pair("HR", "hr"), new Pair("HU-HU", "hu-HU"), new Pair("HU", "hu-HU"), new Pair("HY-AM", "hy-AM"), new Pair("HY", "hy-AM"), new Pair("ID", "id"), new Pair("IS-IS", "is-IS"), new Pair("IS", "is-IS"), new Pair("IT-IT", "it-IT"), new Pair("IT", "it-IT"), new Pair("IW-IL", "iw-IL"), new Pair("IW", "iw-IL"), new Pair("JA-JP", "ja-JP"), new Pair("JA", "ja-JP"), new Pair("KM-KH", "km-KH"), new Pair("KM", "km-KH"), new Pair("KN-IN", "kn-IN"), new Pair("KN", "kn-IN"), new Pair("KO-KR", "ko-KR"), new Pair("KO", "ko-KR"), new Pair("lo-LA", "lo-LA"), new Pair("lo", "lo-LA"), new Pair("LT", "lt"), new Pair("LV", "lv"), new Pair("ML-IN", "ml-IN"), new Pair("ML", "ml-IN"), new Pair("MR-IN", "mr-IN"), new Pair("MR", "mr-IN"), new Pair("MS", "ms"), new Pair("NE-NP", "ne-NP"), new Pair("NE", "ne-NP"), new Pair("NL-NL", "nl-NL"), new Pair("NL", "nl-NL"), new Pair("NO-NO", "no-NO"), new Pair("NO", "no-NO"), new Pair("PL-PL", "pl-PL"), new Pair("PL", "pl-PL"), new Pair("PT-BR", "pt-BR"), new Pair("PT-PT", "pt-PT"), new Pair("PT", "pt-PT"), new Pair("RO", "ro"), new Pair("RU-RU", "ru-RU"), new Pair("RU", "ru-RU"), new Pair("SK", "sk"), new Pair("SL", "sl"), new Pair("SR", "sr"), new Pair("SV-SE", "sv-SE"), new Pair("SV", "sv-SE"), new Pair("SW", "sw"), new Pair("TA-IN", "ta-IN"), new Pair("TA", "ta-IN"), new Pair("TE-IN", "te-IN"), new Pair(HttpHeaders.TE, "te-IN"), new Pair("TH", "th"), new Pair("TR-TR", "tr-TR"), new Pair("TR", "tr-TR"), new Pair("UK", "uk"), new Pair("VI", "vi"), new Pair("ZH-CN", "zh-CN"), new Pair("ZH-HK", "zh-HK"), new Pair("ZH-TW", "zh-TW"), new Pair("ZH", "zh-CN"));
    private static final HashMap<String, String> supportLanguageMap = MapsKt.hashMapOf(new Pair("en", "en-us"), new Pair("es", "es-es"), new Pair("fr", "fr-fr"), new Pair("it", "it-it"), new Pair("zh", "zh-tw"), new Pair("ko", "ko"), new Pair("ja", "ja"), new Pair("de", "de"));
    private static final HashMap<String, String> supportTicketLanguageMap = MapsKt.hashMapOf(new Pair("en", "english"), new Pair("es", "spanish"), new Pair("fr", "french"), new Pair("it", "italian"), new Pair("zh", LocalePreferences.CalendarType.CHINESE), new Pair("ko", "korean"), new Pair("ja", "japanese"), new Pair("de", "german"));
    private static final HashMap<String, String> supportCategoryLanguageMap = MapsKt.hashMapOf(new Pair("en", "en-us"), new Pair("es", "es-es"), new Pair("fr", "fr-fr"), new Pair("it", "it-it"), new Pair("zh-tw", "zh-tw"), new Pair("ko", "ko"), new Pair("ja", "ja"), new Pair("de", "de"), new Pair("zh-cn", "zh-cn"), new Pair("zh-hk", "zh-hk"), new Pair("ar", "ar"), new Pair("uk", "uk"), new Pair("ru", "ru"), new Pair("he", "he"), new Pair("iw", "he"));

    private LanguageUtils() {
    }

    public final String getSupportCategoryLanguage() {
        String str;
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        String language = application.getResources().getConfiguration().locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String lowerCase = language.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, "zh")) {
            Application application2 = AppGlobals.INSTANCE.get();
            Intrinsics.checkNotNull(application2);
            String lowerCase2 = (lowerCase + HelpFormatter.DEFAULT_OPT_PREFIX + application2.getResources().getConfiguration().locale.getCountry()).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            str = supportCategoryLanguageMap.get(lowerCase2);
        } else {
            str = supportCategoryLanguageMap.get(lowerCase);
        }
        String str2 = str;
        return (str2 == null || str2.length() == 0) ? "en-us" : str;
    }

    private final String matchLanguage() {
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        String language = application.getResources().getConfiguration().locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String upperCase = language.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        Application application2 = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application2);
        String str = upperCase + HelpFormatter.DEFAULT_OPT_PREFIX + application2.getResources().getConfiguration().locale.getCountry();
        HashMap<String, String> map = languageMap;
        String str2 = map.get(str);
        String str3 = str2;
        if (str3 != null && str3.length() != 0) {
            return str2;
        }
        String str4 = map.get(upperCase);
        String str5 = str4;
        return (str5 == null || str5.length() == 0) ? "en-US" : str4;
    }

    public final String getLanguage() {
        return matchLanguage();
    }

    public static /* synthetic */ String getSupportLanguage$default(LanguageUtils languageUtils, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return languageUtils.getSupportLanguage(z);
    }

    public final String getSupportLanguage(boolean isTicket) {
        Application application = AppGlobals.INSTANCE.get();
        Intrinsics.checkNotNull(application);
        String language = application.getResources().getConfiguration().locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        String lowerCase = language.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String str = (isTicket ? supportTicketLanguageMap : supportLanguageMap).get(lowerCase);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return isTicket ? "english" : "en-us";
        }
        return str;
    }
}
