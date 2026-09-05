package com.nothing.link.bluetooth.sdk.connect.tranform;

import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.spotify.sdk.android.auth.LoginActivity;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XCommand.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0011\u00a2\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0011H\u00c6\u0003J\t\u0010$\u001a\u00020\u0005H\u00c6\u0003J\t\u0010%\u001a\u00020\u0005H\u00c6\u0003J\t\u0010&\u001a\u00020\bH\u00c6\u0003J\t\u0010'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\rH\u00c6\u0003J\t\u0010+\u001a\u00020\u0003H\u00c6\u0003J\u0081\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u001c\b\u0002\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0011H\u00c6\u0001J\u0013\u0010-\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0010\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010/\u001a\u00020\bJ\u0006\u00100\u001a\u00020\bJ\t\u00101\u001a\u00020\u0005H\u00d6\u0001J\u0006\u00102\u001a\u00020\bJ\b\u00103\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014\u00a8\u00064"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "", "command", "", "fsn", "", "length", "stick", "", "payloadLength", "totalCount", "currentCount", "data", "", "uuid", LoginActivity.RESPONSE_KEY, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Ljava/lang/String;IIZIII[BLjava/lang/String;Ljava/util/ArrayList;)V", "getCommand", "()Ljava/lang/String;", "getCurrentCount", "()I", "getData", "()[B", "getFsn", "getLength", "getPayloadLength", "getResponse", "()Ljava/util/ArrayList;", "getStick", "()Z", "getTotalCount", "getUuid", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "ignoreFrame", "hasStickData", "hashCode", "isValid", "toString", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class XCommand {
    private final String command;
    private final int currentCount;
    private final byte[] data;
    private final int fsn;
    private final int length;
    private final int payloadLength;
    private final ArrayList<String> response;
    private final boolean stick;
    private final int totalCount;
    private final String uuid;

    public XCommand() {
        this(null, 0, 0, false, 0, 0, 0, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ XCommand copy$default(XCommand xCommand, String str, int i, int i2, boolean z, int i3, int i4, int i5, byte[] bArr, String str2, ArrayList arrayList, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = xCommand.command;
        }
        if ((i6 & 2) != 0) {
            i = xCommand.fsn;
        }
        if ((i6 & 4) != 0) {
            i2 = xCommand.length;
        }
        if ((i6 & 8) != 0) {
            z = xCommand.stick;
        }
        if ((i6 & 16) != 0) {
            i3 = xCommand.payloadLength;
        }
        if ((i6 & 32) != 0) {
            i4 = xCommand.totalCount;
        }
        if ((i6 & 64) != 0) {
            i5 = xCommand.currentCount;
        }
        if ((i6 & 128) != 0) {
            bArr = xCommand.data;
        }
        if ((i6 & 256) != 0) {
            str2 = xCommand.uuid;
        }
        if ((i6 & 512) != 0) {
            arrayList = xCommand.response;
        }
        String str3 = str2;
        ArrayList arrayList2 = arrayList;
        int i7 = i5;
        byte[] bArr2 = bArr;
        int i8 = i3;
        int i9 = i4;
        return xCommand.copy(str, i, i2, z, i8, i9, i7, bArr2, str3, arrayList2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCommand() {
        return this.command;
    }

    public final ArrayList<String> component10() {
        return this.response;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getFsn() {
        return this.fsn;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getLength() {
        return this.length;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getStick() {
        return this.stick;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getPayloadLength() {
        return this.payloadLength;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCurrentCount() {
        return this.currentCount;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final byte[] getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    public final XCommand copy(String command, int fsn, int length, boolean stick, int payloadLength, int totalCount, int currentCount, byte[] data, String uuid, ArrayList<String> response) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new XCommand(command, fsn, length, stick, payloadLength, totalCount, currentCount, data, uuid, response);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof XCommand)) {
            return false;
        }
        XCommand xCommand = (XCommand) other;
        return Intrinsics.areEqual(this.command, xCommand.command) && this.fsn == xCommand.fsn && this.length == xCommand.length && this.stick == xCommand.stick && this.payloadLength == xCommand.payloadLength && this.totalCount == xCommand.totalCount && this.currentCount == xCommand.currentCount && Intrinsics.areEqual(this.data, xCommand.data) && Intrinsics.areEqual(this.uuid, xCommand.uuid) && Intrinsics.areEqual(this.response, xCommand.response);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.command.hashCode() * 31) + Integer.hashCode(this.fsn)) * 31) + Integer.hashCode(this.length)) * 31;
        boolean z = this.stick;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((((((((((iHashCode + r1) * 31) + Integer.hashCode(this.payloadLength)) * 31) + Integer.hashCode(this.totalCount)) * 31) + Integer.hashCode(this.currentCount)) * 31) + Arrays.hashCode(this.data)) * 31) + this.uuid.hashCode()) * 31;
        ArrayList<String> arrayList = this.response;
        return iHashCode2 + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public XCommand(String command, int i, int i2, boolean z, int i3, int i4, int i5, byte[] data, String uuid, ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(command, "command");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.command = command;
        this.fsn = i;
        this.length = i2;
        this.stick = z;
        this.payloadLength = i3;
        this.totalCount = i4;
        this.currentCount = i5;
        this.data = data;
        this.uuid = uuid;
        this.response = arrayList;
    }

    public /* synthetic */ XCommand(String str, int i, int i2, boolean z, int i3, int i4, int i5, byte[] bArr, String str2, ArrayList arrayList, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? "" : str, (i6 & 2) != 0 ? 0 : i, (i6 & 4) != 0 ? 0 : i2, (i6 & 8) != 0 ? false : z, (i6 & 16) != 0 ? 0 : i3, (i6 & 32) != 0 ? 1 : i4, (i6 & 64) != 0 ? 1 : i5, (i6 & 128) != 0 ? new byte[0] : bArr, (i6 & 256) != 0 ? "" : str2, (i6 & 512) != 0 ? null : arrayList);
    }

    public final String getCommand() {
        return this.command;
    }

    public final int getFsn() {
        return this.fsn;
    }

    public final int getLength() {
        return this.length;
    }

    public final boolean getStick() {
        return this.stick;
    }

    public final int getPayloadLength() {
        return this.payloadLength;
    }

    public final int getTotalCount() {
        return this.totalCount;
    }

    public final int getCurrentCount() {
        return this.currentCount;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final ArrayList<String> getResponse() {
        return this.response;
    }

    public static /* synthetic */ String getCommand$default(XCommand xCommand, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return xCommand.getCommand(z);
    }

    public final String getCommand(boolean ignoreFrame) {
        if (ignoreFrame) {
            return this.command;
        }
        return this.command + "_" + this.fsn;
    }

    public final boolean isValid() {
        return this.length > 0;
    }

    public final boolean hasStickData() {
        return this.stick;
    }

    public String toString() {
        return "command:" + this.command + ",response:" + this.response + ",fsn:" + this.fsn + ",length:" + this.length + ",stick:" + this.stick + ",count(" + this.currentCount + "/" + this.totalCount + "),data:[" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, this.data, false, 2, null) + "]";
    }
}
