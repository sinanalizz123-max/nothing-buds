package com.nothing.link.bluetooth.sdk.scan.parser;

import android.bluetooth.le.ScanResult;
import android.os.Bundle;
import kotlin.Metadata;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;

/* JADX INFO: compiled from: IParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\n"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/parser/IParser;", "", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Landroid/os/Bundle;", "manufactureStr", "", "manufacturerId", "", "scanResult", "Landroid/bluetooth/le/ScanResult;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface IParser {
    Bundle parser(String manufactureStr, int manufacturerId, ScanResult scanResult);
}
