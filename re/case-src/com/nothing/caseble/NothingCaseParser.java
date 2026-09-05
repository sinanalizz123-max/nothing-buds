package com.nothing.caseble;

import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingParser;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: NothingCaseParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J$\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/caseble/NothingCaseParser;", "Lcom/nothing/link/bluetooth/sdk/scan/parser/NothingParser;", "<init>", "()V", "getDeviceType", "", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Landroid/os/Bundle;", "manufactureStr", "", "manufacturerId", "scanResult", "Landroid/bluetooth/le/ScanResult;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NothingCaseParser extends NothingParser {
    private static final int CASE_MANUFACTURER_PAYLOAD_MIN_HEX_LEN = 22;
    private static final int CASE_MANUFACTURER_PAYLOAD_MIN_LEN = 11;
    public static final int DEVICE_TYPE_CASE = 2;
    public static final String KEY_CASE_MAC_ADDRESS = "device_address";
    public static final String KEY_CONNECTION_FLAG = "connection_flag";
    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_PAIRED_EARPHONE_MAC = "paired_earphone_mac";

    @Override // com.nothing.link.bluetooth.sdk.scan.parser.NothingParser
    public int getDeviceType() {
        return 2;
    }

    @Override // com.nothing.link.bluetooth.sdk.scan.parser.IParser
    public Bundle parser(String manufactureStr, int manufacturerId, ScanResult scanResult) {
        int i;
        boolean z;
        Intrinsics.checkNotNullParameter(scanResult, "scanResult");
        if (manufactureStr == null || manufactureStr.length() < 22) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "[NothingCaseParser] skip: manufactureStr null or len=" + (manufactureStr != null ? manufactureStr.length() : 0) + " < 22";
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
            return null;
        }
        String strSubstring = manufactureStr.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = strSubstring.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        String strSubstring2 = manufactureStr.substring(2, 4);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
        String upperCase2 = strSubstring2.toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        String strSubstring3 = manufactureStr.substring(4, 8);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        Locale locale3 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
        String upperCase3 = strSubstring3.toUpperCase(locale3);
        Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
        String strSubstring4 = manufactureStr.substring(8, 20);
        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
        String strSubstring5 = manufactureStr.substring(20, 22);
        Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
        String address = scanResult.getDevice().getAddress();
        if (address == null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "[NothingCaseParser] skip: device.address is null".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 3, str4, tag2, "[NothingCaseParser] skip: device.address is null " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "[NothingCaseParser] skip: device.address is null " + strComponent4);
                }
            }
            return null;
        }
        if (StringsKt.replace$default(address, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null).length() != 12) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str5 = "[NothingCaseParser] skip: rawAddress length != 12, rawAddress=" + address;
                String str6 = str5;
                if (str6 != null && str6.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str7 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    FileLog.print$default(fileLog3, 3, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            return null;
        }
        Locale locale4 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
        String upperCase4 = address.toUpperCase(locale4);
        Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
        int i2 = Integer.parseInt(strSubstring5, CharsKt.checkRadix(16));
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true)) {
            String str8 = "[NothingCaseParser] parsed manufacturerId=0x" + Integer.toHexString(manufacturerId) + ", manufactureStrLen=" + manufactureStr.length() + ", connection=" + upperCase + ", colorId=" + upperCase2 + ", productId=" + upperCase3 + ", pairedEarphoneAddrHex=" + strSubstring4 + ", deviceTypeHex=" + strSubstring5 + ", deviceType=0x" + Integer.toHexString(i2) + ", rawAddress=" + address + ", caseMac=" + upperCase4 + ", pairedEarphoneMac=" + strSubstring4;
            String str9 = str8;
            if (str9 != null && str9.length() != 0) {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str10 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                FileLog.print$default(fileLog4, 3, str10, tag4, str8 + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, str8 + StringUtils.SPACE + strComponent8);
                }
            }
            i = i2;
            z = true;
        } else {
            z = true;
            i = i2;
        }
        if (i != z) {
            Logger logger5 = Logger.INSTANCE;
            String tag5 = logger5.getTAG();
            int depth5 = logger5.getDepth();
            if (logger5.isCanLogger(z)) {
                String str11 = "[NothingCaseParser] skip: deviceType=0x" + Integer.toHexString(i) + " != 0x01 (not case)";
                String str12 = str11;
                if (str12 != null && str12.length() != 0) {
                    Pair<String, String> trace5 = logger5.getTrace(depth5);
                    String strComponent9 = trace5.component1();
                    String strComponent10 = trace5.component2();
                    FileLog fileLog5 = FileLog.INSTANCE;
                    String str13 = logger5.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                    FileLog.print$default(fileLog5, 3, str13, tag5, str11 + StringUtils.SPACE + strComponent10, null, 16, null);
                    if (logger5.isDebug()) {
                        Log.i(tag5 + strComponent9, str11 + StringUtils.SPACE + strComponent10);
                    }
                }
            }
            return 0;
        }
        Bundle bundleBuildBundle = buildBundle();
        bundleBuildBundle.putString("device_address", upperCase4);
        bundleBuildBundle.putString(NothingParser.PRODUCT_ID, upperCase3);
        bundleBuildBundle.putString(NothingParser.COLOR_ID, upperCase2);
        bundleBuildBundle.putString(NothingParser.PRODUCT_COLOR_ID, upperCase3 + upperCase2);
        bundleBuildBundle.putString(NothingParser.FAST_PAIRED_ID, upperCase3);
        bundleBuildBundle.putBoolean(NothingParser.IS_PAIRED, true);
        bundleBuildBundle.putString(KEY_PAIRED_EARPHONE_MAC, strSubstring4);
        bundleBuildBundle.putString(KEY_CONNECTION_FLAG, upperCase);
        bundleBuildBundle.putInt(KEY_DEVICE_TYPE, i);
        return bundleBuildBundle;
    }
}
