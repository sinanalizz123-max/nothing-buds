package com.nothing.link.bluetooth.sdk.scan.parser;

import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: NothingWatchParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004J$\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/parser/NothingWatchParser;", "Lcom/nothing/link/bluetooth/sdk/scan/parser/NothingParser;", "()V", "getDeviceType", "", "getRealMacAddress", "", "badMacAddress", "getTotalManufacture", "manufactureStr", "manufacturerId", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Landroid/os/Bundle;", "scanResult", "Landroid/bluetooth/le/ScanResult;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NothingWatchParser extends NothingParser {
    @Override // com.nothing.link.bluetooth.sdk.scan.parser.NothingParser
    public int getDeviceType() {
        return 1;
    }

    public final String getTotalManufacture(String manufactureStr, int manufacturerId) {
        Intrinsics.checkNotNullParameter(manufactureStr, "manufactureStr");
        if (!StringsKt.contains((CharSequence) manufactureStr, (CharSequence) "4A58", true)) {
            return null;
        }
        if (manufacturerId == 3275) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase = manufactureStr.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return upperCase;
        }
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
        String upperCase2 = ("2CBE" + manufactureStr).toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        return upperCase2;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    @Override // com.nothing.link.bluetooth.sdk.scan.parser.IParser
    public Bundle parser(String manufactureStr, int manufacturerId, ScanResult scanResult) {
        String totalManufacture;
        Bundle bundle;
        String realMacAddress;
        String upperCase;
        String upperCase2;
        String upperCase3;
        String str;
        Intrinsics.checkNotNullParameter(scanResult, "scanResult");
        if (manufactureStr == null || (totalManufacture = getTotalManufacture(manufactureStr, manufacturerId)) == null) {
            return null;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "watch " + manufacturerId + " totalManufacture " + totalManufacture + "  " + totalManufacture.length();
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                bundle = null;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                bundle = null;
                FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            bundle = null;
        }
        if (totalManufacture.length() >= 36) {
            String strSubstring = totalManufacture.substring(12, 24);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String upperCase4 = strSubstring.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
            if (!StringsKt.contentEquals(upperCase4, "4A582D495744", true)) {
                return bundle;
            }
            String strSubstring2 = totalManufacture.substring(0, 12);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            realMacAddress = getRealMacAddress(strSubstring2);
            String strSubstring3 = totalManufacture.substring(24, 32);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
            Locale locale2 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
            upperCase2 = strSubstring3.toUpperCase(locale2);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            String strSubstring4 = totalManufacture.substring(32, 34);
            Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
            Locale locale3 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
            upperCase3 = strSubstring4.toUpperCase(locale3);
            Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
            String strSubstring5 = totalManufacture.substring(34, 36);
            Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
            Locale locale4 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
            upperCase = strSubstring5.toUpperCase(locale4);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            str = "1st";
        } else if (totalManufacture.length() < 28) {
            realMacAddress = "";
            upperCase = "";
            upperCase2 = upperCase;
            upperCase3 = upperCase2;
            str = upperCase3;
        } else {
            String strSubstring6 = totalManufacture.substring(0, 12);
            Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
            realMacAddress = getRealMacAddress(strSubstring6);
            String strSubstring7 = totalManufacture.substring(12, 16);
            Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
            Locale locale5 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale5, "getDefault(...)");
            String upperCase5 = strSubstring7.toUpperCase(locale5);
            Intrinsics.checkNotNullExpressionValue(upperCase5, "toUpperCase(...)");
            if (!StringsKt.contentEquals(upperCase5, "4A58", true)) {
                return bundle;
            }
            String strSubstring8 = totalManufacture.substring(16, 24);
            Intrinsics.checkNotNullExpressionValue(strSubstring8, "substring(...)");
            Locale locale6 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale6, "getDefault(...)");
            String upperCase6 = strSubstring8.toUpperCase(locale6);
            Intrinsics.checkNotNullExpressionValue(upperCase6, "toUpperCase(...)");
            String strSubstring9 = totalManufacture.substring(24, 26);
            Intrinsics.checkNotNullExpressionValue(strSubstring9, "substring(...)");
            Locale locale7 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale7, "getDefault(...)");
            String upperCase7 = strSubstring9.toUpperCase(locale7);
            Intrinsics.checkNotNullExpressionValue(upperCase7, "toUpperCase(...)");
            String strSubstring10 = totalManufacture.substring(26, 28);
            Intrinsics.checkNotNullExpressionValue(strSubstring10, "substring(...)");
            Locale locale8 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale8, "getDefault(...)");
            upperCase = strSubstring10.toUpperCase(locale8);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            str = "2nd";
            upperCase3 = upperCase7;
            upperCase2 = upperCase6;
        }
        if (!isNothingAudioAddress(realMacAddress)) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str5 = "watch totalManufacture " + ((Object) realMacAddress);
                String str6 = str5;
                if (str6 != null && str6.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str7 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    FileLog.print$default(fileLog2, 5, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.w(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            return bundle;
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str8 = "watch result totalManufacture " + totalManufacture;
            String str9 = str8;
            if (str9 != null && str9.length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str10 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                FileLog.print$default(fileLog3, 3, str10, tag3, str8 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str8 + StringUtils.SPACE + strComponent6);
                }
            }
        }
        Bundle bundleBuildBundle = buildBundle();
        bundleBuildBundle.putString(NothingParser.PRODUCT_COLOR_ID, new StringBuilder().append((Object) upperCase2).append((Object) upperCase3).toString());
        bundleBuildBundle.putString(NothingParser.PRODUCT_ID, upperCase2);
        bundleBuildBundle.putString(NothingParser.COLOR_ID, upperCase3);
        bundleBuildBundle.putBoolean(NothingParser.IS_PAIRED, Intrinsics.areEqual(upperCase, "00") || Intrinsics.areEqual(upperCase, "02") || Intrinsics.areEqual(upperCase, "01"));
        bundleBuildBundle.putString(NothingParser.MAC_ADDRESS, realMacAddress);
        bundleBuildBundle.putString(NothingParser.MANUFACTURER_DATA, totalManufacture);
        bundleBuildBundle.putString(NothingParser.DEVICE_MODEL, str);
        bundleBuildBundle.putString(NothingParser.FAST_PAIRED_ID, new StringBuilder().append((Object) upperCase2).append((Object) upperCase3).toString());
        return bundleBuildBundle;
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.parser.NothingParser
    public String getRealMacAddress(String badMacAddress) {
        Intrinsics.checkNotNullParameter(badMacAddress, "badMacAddress");
        StringBuilder sb = new StringBuilder();
        int length = badMacAddress.length();
        for (int i = 0; i < length; i++) {
            sb.append(badMacAddress.charAt(i));
            if (i % 2 != 0 && i != length - 1) {
                sb.append(TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER);
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
