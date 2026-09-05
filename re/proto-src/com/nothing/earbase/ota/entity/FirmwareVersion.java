package com.nothing.earbase.ota.entity;

import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.protocol.constant.ITWSParse;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: FirmwareVersion.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0013\u001a\u0004\u0018\u00010\rJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/nothing/earbase/ota/entity/FirmwareVersion;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "versionFirmware", "Lcom/nothing/earbase/ota/entity/BaseFirmwareVersion;", "getVersionFirmware", "()Lcom/nothing/earbase/ota/entity/BaseFirmwareVersion;", "setVersionFirmware", "(Lcom/nothing/earbase/ota/entity/BaseFirmwareVersion;)V", "versionStr", "", "getVersionStr", "()Ljava/lang/String;", "setVersionStr", "(Ljava/lang/String;)V", "getFirmwareVersion", "getVersion", "obtainDataPacket", "hashCode", "", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FirmwareVersion implements ITWSParse {
    public static final int NUMBER_A = 0;
    public static final int NUMBER_BCC = 1;
    public static final int NUMBER_D = 2;
    public static final int NUMBER_E = 3;
    private BaseFirmwareVersion versionFirmware;
    private String versionStr;

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return new byte[0];
    }

    public FirmwareVersion(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.versionStr = "";
        String strDecodeToString$default = StringsKt.decodeToString$default(payload, 0, 0, false, 6, null);
        String str = strDecodeToString$default;
        if (str.length() > 0) {
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            if (listSplit$default.size() > 3) {
                this.versionStr = strDecodeToString$default;
                this.versionFirmware = new BaseFirmwareVersion(Integer.parseInt((String) listSplit$default.get(0)), Integer.parseInt((String) listSplit$default.get(1)), Integer.parseInt((String) listSplit$default.get(2)), Integer.parseInt((String) listSplit$default.get(3)));
            }
        }
    }

    public final BaseFirmwareVersion getVersionFirmware() {
        return this.versionFirmware;
    }

    public final void setVersionFirmware(BaseFirmwareVersion baseFirmwareVersion) {
        this.versionFirmware = baseFirmwareVersion;
    }

    public final String getVersionStr() {
        return this.versionStr;
    }

    public final void setVersionStr(String str) {
        this.versionStr = str;
    }

    /* JADX INFO: renamed from: getFirmwareVersion, reason: from getter */
    public final BaseFirmwareVersion getVersionFirmware() {
        return this.versionFirmware;
    }

    /* JADX INFO: renamed from: getVersion, reason: from getter */
    public final String getVersionStr() {
        return this.versionStr;
    }

    public int hashCode() {
        return Objects.hash(getVersionStr());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FirmwareVersion) {
            return Intrinsics.areEqual(getVersionStr(), ((FirmwareVersion) other).getVersionStr());
        }
        return false;
    }
}
