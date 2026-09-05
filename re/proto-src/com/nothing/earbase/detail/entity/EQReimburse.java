package com.nothing.earbase.detail.entity;

import android.util.Log;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EQReimburse.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/nothing/earbase/detail/entity/EQReimburse;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "reimburseSwitch", "", "getReimburseSwitch", "()Z", "setReimburseSwitch", "(Z)V", "reimburseValue", "", "getReimburseValue", "()I", "setReimburseValue", "(I)V", "obtainDataPacket", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EQReimburse implements ITWSParse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean reimburseSwitch;
    private int reimburseValue;

    public EQReimburse(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.reimburseValue = 5;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "EQReimburse payload:" + DataExtKt.contentToHexString(payload) + StringUtils.SPACE;
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
        this.reimburseSwitch = DataExtKt.getIntOrZero(payload, 0) == 1;
        this.reimburseValue = DataExtKt.getIntOrZero(payload, 1);
    }

    public final boolean getReimburseSwitch() {
        return this.reimburseSwitch;
    }

    public final void setReimburseSwitch(boolean z) {
        this.reimburseSwitch = z;
    }

    public final int getReimburseValue() {
        return this.reimburseValue;
    }

    public final void setReimburseValue(int i) {
        this.reimburseValue = i;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return new byte[]{this.reimburseSwitch, (byte) this.reimburseValue};
    }

    /* JADX INFO: compiled from: EQReimburse.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\n"}, d2 = {"Lcom/nothing/earbase/detail/entity/EQReimburse$Companion;", "", "<init>", "()V", "obtainDataPacket", "", "switch", "", "value", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] obtainDataPacket(boolean z, int value) {
            return new byte[]{z ? (byte) 1 : (byte) 0, (byte) value};
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020  */
    public boolean equals(Object other) {
        boolean z;
        if (this == other) {
            return true;
        }
        if (!(other instanceof EQReimburse)) {
            return false;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            EQReimburse eQReimburse = (EQReimburse) other;
            String str = "EQReimburse equals this switch:" + this.reimburseSwitch + ",this value:" + this.reimburseValue + ",other switch:" + eQReimburse.reimburseSwitch + ",other value:" + eQReimburse.reimburseValue;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = true;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                z = true;
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            z = true;
        }
        EQReimburse eQReimburse2 = (EQReimburse) other;
        if (this.reimburseSwitch == eQReimburse2.reimburseSwitch && this.reimburseValue == eQReimburse2.reimburseValue) {
            return z;
        }
        return false;
    }
}
