package com.nothing.earbase.ota.entity;

import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EarphoneStatus.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/earbase/ota/entity/EarphoneStatus;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", NotificationCompat.CATEGORY_STATUS, "Landroid/util/SparseArray;", "Lcom/nothing/earbase/ota/entity/EarphoneStatus$Status;", "getStatus", "()Landroid/util/SparseArray;", "watch", "getWatch", "()Lcom/nothing/earbase/ota/entity/EarphoneStatus$Status;", "left", "getLeft", "right", "getRight", "case", "getCase", "tws", "getTws", "stereo", "getStereo", "obtainDataPacket", "toString", "", "Status", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarphoneStatus implements ITWSParse {
    private static final int MASK_CALL_EAR = 16;
    private static final int MASK_CASE_IN_OPEN = 1;
    private static final int MASK_CONNECT_EAR = 128;
    private static final int MASK_IN_CASE = 1;
    private static final int MASK_IN_EAR = 4;
    private static final int MASK_OTA = 32;
    private final SparseArray<Status> status;

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return new byte[0];
    }

    public EarphoneStatus(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.status = DataExtKt.toSparseArray(DataExtKt.toPairs$default(payload, 0, 0, 0, 7, null), new Function2() { // from class: com.nothing.earbase.ota.entity.EarphoneStatus$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EarphoneStatus.status$lambda$0(((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
    }

    public final SparseArray<Status> getStatus() {
        return this.status;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Status status$lambda$0(int i, int i2) {
        int i3 = i2 & 1;
        return new Status(i, i3 != 0, (i2 & 4) != 0, (i2 & 128) != 0, (i2 & 32) != 0, i3 != 0, (i2 & 16) != 0);
    }

    public final Status getWatch() {
        return this.status.get(1);
    }

    public final Status getLeft() {
        return this.status.get(2);
    }

    public final Status getRight() {
        return this.status.get(3);
    }

    public final Status getCase() {
        return this.status.get(4);
    }

    public final Status getTws() {
        return this.status.get(5);
    }

    public final Status getStereo() {
        return this.status.get(6);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getWatch() != null) {
            sb.append("watch:" + getWatch()).append(", ");
        }
        if (getLeft() != null) {
            Status left = getLeft();
            if (left == null || !left.getInCase()) {
                Status left2 = getLeft();
                if (left2 == null || !left2.getInEar()) {
                    sb.append("The left ear compartment is not outside the ear");
                } else {
                    sb.append("left ear canal extrinsic ear");
                }
            } else {
                sb.append("left ear in warehouse");
            }
            sb.append(", ");
        }
        if (getRight() != null) {
            Status right = getRight();
            if (right == null || !right.getInCase()) {
                Status right2 = getRight();
                if (right2 == null || !right2.getInEar()) {
                    sb.append("The right ear canal is not outside the ear");
                } else {
                    sb.append("Right ear canal extrinsic ear");
                }
            } else {
                sb.append("right ear in warehouse");
            }
            sb.append(", ");
        }
        if (getCase() != null) {
            Status status = getCase();
            if (status == null || !status.getCaseIsOpen()) {
                sb.append("box not opened");
            } else {
                sb.append("box is open");
            }
            sb.append(". ");
        }
        if (getTws() != null) {
            sb.append("tws:" + getTws()).append(", ");
        }
        if (getStereo() != null) {
            sb.append("stereo:" + getStereo()).append(", ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: EarphoneStatus.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0005H\u00c6\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/nothing/earbase/ota/entity/EarphoneStatus$Status;", "", "type", "", "inCase", "", "inEar", "isConnect", "isOTA", "caseIsOpen", "isCalling", "<init>", "(IZZZZZZ)V", "getType", "()I", "getInCase", "()Z", "getInEar", "getCaseIsOpen", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Status {
        private final boolean caseIsOpen;
        private final boolean inCase;
        private final boolean inEar;
        private final boolean isCalling;
        private final boolean isConnect;
        private final boolean isOTA;
        private final int type;

        public static /* synthetic */ Status copy$default(Status status, int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = status.type;
            }
            if ((i2 & 2) != 0) {
                z = status.inCase;
            }
            if ((i2 & 4) != 0) {
                z2 = status.inEar;
            }
            if ((i2 & 8) != 0) {
                z3 = status.isConnect;
            }
            if ((i2 & 16) != 0) {
                z4 = status.isOTA;
            }
            if ((i2 & 32) != 0) {
                z5 = status.caseIsOpen;
            }
            if ((i2 & 64) != 0) {
                z6 = status.isCalling;
            }
            boolean z7 = z5;
            boolean z8 = z6;
            boolean z9 = z4;
            boolean z10 = z2;
            return status.copy(i, z, z10, z3, z9, z7, z8);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getInCase() {
            return this.inCase;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getInEar() {
            return this.inEar;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsConnect() {
            return this.isConnect;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsOTA() {
            return this.isOTA;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCaseIsOpen() {
            return this.caseIsOpen;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsCalling() {
            return this.isCalling;
        }

        public final Status copy(int type, boolean inCase, boolean inEar, boolean isConnect, boolean isOTA, boolean caseIsOpen, boolean isCalling) {
            return new Status(type, inCase, inEar, isConnect, isOTA, caseIsOpen, isCalling);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Status)) {
                return false;
            }
            Status status = (Status) other;
            return this.type == status.type && this.inCase == status.inCase && this.inEar == status.inEar && this.isConnect == status.isConnect && this.isOTA == status.isOTA && this.caseIsOpen == status.caseIsOpen && this.isCalling == status.isCalling;
        }

        public int hashCode() {
            return (((((((((((Integer.hashCode(this.type) * 31) + Boolean.hashCode(this.inCase)) * 31) + Boolean.hashCode(this.inEar)) * 31) + Boolean.hashCode(this.isConnect)) * 31) + Boolean.hashCode(this.isOTA)) * 31) + Boolean.hashCode(this.caseIsOpen)) * 31) + Boolean.hashCode(this.isCalling);
        }

        public String toString() {
            return "Status(type=" + this.type + ", inCase=" + this.inCase + ", inEar=" + this.inEar + ", isConnect=" + this.isConnect + ", isOTA=" + this.isOTA + ", caseIsOpen=" + this.caseIsOpen + ", isCalling=" + this.isCalling + ")";
        }

        public Status(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
            this.type = i;
            this.inCase = z;
            this.inEar = z2;
            this.isConnect = z3;
            this.isOTA = z4;
            this.caseIsOpen = z5;
            this.isCalling = z6;
        }

        public final int getType() {
            return this.type;
        }

        public final boolean getInCase() {
            return this.inCase;
        }

        public final boolean getInEar() {
            return this.inEar;
        }

        public final boolean isConnect() {
            return this.isConnect;
        }

        public final boolean isOTA() {
            return this.isOTA;
        }

        public final boolean getCaseIsOpen() {
            return this.caseIsOpen;
        }

        public final boolean isCalling() {
            return this.isCalling;
        }
    }
}
