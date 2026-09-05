package com.nothing.link.bluetooth.sdk.scan.parser;

import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import android.os.ParcelUuid;
import com.nothing.ear.one.core.device.IOTProductDeviceEarOne;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;

/* JADX INFO: compiled from: NothingAudioParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/parser/NothingAudioParser;", "Lcom/nothing/link/bluetooth/sdk/scan/parser/NothingParser;", "()V", "SERVER_UUID", "", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Landroid/os/Bundle;", "manufactureStr", "manufacturerId", "", "scanResult", "Landroid/bluetooth/le/ScanResult;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class NothingAudioParser extends NothingParser {
    private final String SERVER_UUID = "0000fe2c-0000-1000-8000-00805f9b34fb";

    @Override // com.nothing.link.bluetooth.sdk.scan.parser.IParser
    public Bundle parser(String manufactureStr, int manufacturerId, ScanResult scanResult) {
        Map<ParcelUuid, byte[]> serviceData;
        Intrinsics.checkNotNullParameter(scanResult, "scanResult");
        byte[] bArr = null;
        if (manufactureStr == null || manufactureStr.length() < 12) {
            return null;
        }
        String strSubstring = manufactureStr.substring(manufactureStr.length() - 12, manufactureStr.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        String realMacAddress = getRealMacAddress(StringsKt.reversed((CharSequence) strSubstring).toString());
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = realMacAddress.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (!isNothingAudioAddress(upperCase)) {
            return null;
        }
        ScanRecord scanRecord = scanResult.getScanRecord();
        if (scanRecord != null && (serviceData = scanRecord.getServiceData()) != null) {
            bArr = serviceData.get(ParcelUuid.fromString(this.SERVER_UUID));
        }
        String upperCase2 = BleUtil.INSTANCE.bytesToHex(bArr, false).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        if (upperCase2.length() != 6) {
            upperCase2 = "";
        }
        String strSubstring2 = manufactureStr.substring(4, 8);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
        String upperCase3 = strSubstring2.toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
        if (Intrinsics.areEqual(upperCase3, IOTProductDeviceEarOne.EAR_COLOR_BLACK_DISCONNECT)) {
            upperCase3 = "B181";
        }
        String strSubstring3 = manufactureStr.substring(2, 4);
        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
        Locale locale3 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale3, "getDefault(...)");
        String upperCase4 = strSubstring3.toUpperCase(locale3);
        Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
        String strSubstring4 = manufactureStr.substring(0, 2);
        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
        Locale locale4 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale4, "getDefault(...)");
        Intrinsics.checkNotNullExpressionValue(strSubstring4.toUpperCase(locale4), "toUpperCase(...)");
        Bundle bundleBuildBundle = buildBundle();
        bundleBuildBundle.putString(NothingParser.PRODUCT_COLOR_ID, ((Object) upperCase3) + upperCase4);
        bundleBuildBundle.putString(NothingParser.PRODUCT_ID, upperCase3);
        bundleBuildBundle.putString(NothingParser.COLOR_ID, upperCase4);
        bundleBuildBundle.putString(NothingParser.MAC_ADDRESS, upperCase);
        bundleBuildBundle.putString(NothingParser.FAST_PAIRED_ID, upperCase2);
        bundleBuildBundle.putBoolean(NothingParser.IS_PAIRED, true);
        return bundleBuildBundle;
    }
}
