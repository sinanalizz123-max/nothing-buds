package com.nothing.caseble;

import android.bluetooth.le.ScanRecord;
import android.util.Log;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingParser;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: PeerLinkAdvParser.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0006\u0010\u0014\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/caseble/PeerLinkAdvParser;", "", "<init>", "()V", "MANUFACTURER_ID_CB0C", "", "debugRejectLogCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "extractManufacturerPayload", "", "record", "Landroid/bluetooth/le/ScanRecord;", "parse", "Lcom/nothing/caseble/PeerLinkAdvParser$Parsed;", "manufacturerPayload", "expectedProductIdHex", "", "logReject", "", "reason", "resetDebugRejectCounter", "Parsed", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PeerLinkAdvParser {
    public static final int MANUFACTURER_ID_CB0C = 51980;
    public static final PeerLinkAdvParser INSTANCE = new PeerLinkAdvParser();
    private static final AtomicInteger debugRejectLogCount = new AtomicInteger(0);

    private PeerLinkAdvParser() {
    }

    /* JADX INFO: compiled from: PeerLinkAdvParser.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/nothing/caseble/PeerLinkAdvParser$Parsed;", "", "connectionByte", "", "productIdHex", "", "advPeerMacColonUpper", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getConnectionByte", "()I", "getProductIdHex", "()Ljava/lang/String;", "getAdvPeerMacColonUpper", "component1", "component2", "component3", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Parsed {
        private final String advPeerMacColonUpper;
        private final int connectionByte;
        private final String productIdHex;

        public static /* synthetic */ Parsed copy$default(Parsed parsed, int i, String str, String str2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = parsed.connectionByte;
            }
            if ((i2 & 2) != 0) {
                str = parsed.productIdHex;
            }
            if ((i2 & 4) != 0) {
                str2 = parsed.advPeerMacColonUpper;
            }
            return parsed.copy(i, str, str2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getConnectionByte() {
            return this.connectionByte;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getProductIdHex() {
            return this.productIdHex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getAdvPeerMacColonUpper() {
            return this.advPeerMacColonUpper;
        }

        public final Parsed copy(int connectionByte, String productIdHex, String advPeerMacColonUpper) {
            Intrinsics.checkNotNullParameter(productIdHex, "productIdHex");
            Intrinsics.checkNotNullParameter(advPeerMacColonUpper, "advPeerMacColonUpper");
            return new Parsed(connectionByte, productIdHex, advPeerMacColonUpper);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Parsed)) {
                return false;
            }
            Parsed parsed = (Parsed) other;
            return this.connectionByte == parsed.connectionByte && Intrinsics.areEqual(this.productIdHex, parsed.productIdHex) && Intrinsics.areEqual(this.advPeerMacColonUpper, parsed.advPeerMacColonUpper);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.connectionByte) * 31) + this.productIdHex.hashCode()) * 31) + this.advPeerMacColonUpper.hashCode();
        }

        public String toString() {
            return "Parsed(connectionByte=" + this.connectionByte + ", productIdHex=" + this.productIdHex + ", advPeerMacColonUpper=" + this.advPeerMacColonUpper + ")";
        }

        public Parsed(int i, String productIdHex, String advPeerMacColonUpper) {
            Intrinsics.checkNotNullParameter(productIdHex, "productIdHex");
            Intrinsics.checkNotNullParameter(advPeerMacColonUpper, "advPeerMacColonUpper");
            this.connectionByte = i;
            this.productIdHex = productIdHex;
            this.advPeerMacColonUpper = advPeerMacColonUpper;
        }

        public final int getConnectionByte() {
            return this.connectionByte;
        }

        public final String getProductIdHex() {
            return this.productIdHex;
        }

        public final String getAdvPeerMacColonUpper() {
            return this.advPeerMacColonUpper;
        }
    }

    public final byte[] extractManufacturerPayload(ScanRecord record) {
        if (record == null) {
            return null;
        }
        byte[] manufacturerSpecificData = record.getManufacturerSpecificData(MANUFACTURER_ID_CB0C);
        if (manufacturerSpecificData != null) {
            if (!(manufacturerSpecificData.length == 0)) {
                return manufacturerSpecificData;
            }
        }
        byte[] manufacturerSpecificData2 = record.getManufacturerSpecificData(new int[]{NothingParser.NOTHING_MANUFACTURER_ID_NEW}[0]);
        if (manufacturerSpecificData2 != null) {
            if (!(manufacturerSpecificData2.length == 0)) {
                return manufacturerSpecificData2;
            }
        }
        return null;
    }

    public final Parsed parse(byte[] manufacturerPayload, String expectedProductIdHex) {
        Intrinsics.checkNotNullParameter(manufacturerPayload, "manufacturerPayload");
        Intrinsics.checkNotNullParameter(expectedProductIdHex, "expectedProductIdHex");
        if (manufacturerPayload.length < 10) {
            logReject("payload too short len=" + manufacturerPayload.length);
            return null;
        }
        int i = manufacturerPayload[0] & 255;
        int i2 = (i >> 1) & 7;
        if (i2 != 5) {
            String string = Integer.toString(i, CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            logReject("connection triple=" + i2 + " (need 5) b0=0x" + string);
            return null;
        }
        int i3 = manufacturerPayload[2] & 255;
        int i4 = manufacturerPayload[3] & 255;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(Locale.US, "%02X%02X", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        String string2 = StringsKt.trim((CharSequence) expectedProductIdHex).toString();
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = string2.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (upperCase.length() > 0 && !Intrinsics.areEqual(str, upperCase)) {
            logReject("product mismatch adv=" + str + " expected=" + upperCase);
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = manufacturerPayload.length;
        for (int length2 = manufacturerPayload.length - 6; length2 < length; length2++) {
            if (sb.length() > 0) {
                sb.append(':');
            }
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String str2 = String.format(Locale.US, "%02X", Arrays.copyOf(new Object[]{Integer.valueOf(manufacturerPayload[length2] & 255)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            sb.append(str2);
        }
        String string3 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
        return new Parsed(i, str, string3);
    }

    private final void logReject(String reason) {
        int iIncrementAndGet = debugRejectLogCount.incrementAndGet();
        if (iIncrementAndGet <= 30 || iIncrementAndGet % 50 == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "[PeerLink] adv filter reject#" + iIncrementAndGet + ": " + reason;
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
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
    }

    public final void resetDebugRejectCounter() {
        debugRejectLogCount.set(0);
    }
}
