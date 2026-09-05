package com.nothing.core.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MidUnitAdvanceCustomEQModeEntity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\rB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/core/entity/MidUnitAdvanceCustomEQModeEntity;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "mode", "Lcom/nothing/core/entity/MidUnitAdvanceCustomEQModeEntity$Mode;", "getMode", "()Lcom/nothing/core/entity/MidUnitAdvanceCustomEQModeEntity$Mode;", "setMode", "(Lcom/nothing/core/entity/MidUnitAdvanceCustomEQModeEntity$Mode;)V", "obtainDataPacket", "Mode", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MidUnitAdvanceCustomEQModeEntity implements ITWSParse {
    private Mode mode;

    /* JADX WARN: Multi-variable type inference failed */
    public MidUnitAdvanceCustomEQModeEntity() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: compiled from: MidUnitAdvanceCustomEQModeEntity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/nothing/core/entity/MidUnitAdvanceCustomEQModeEntity$Mode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "OFF", "ON", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Mode {
        OFF(0),
        ON(1);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final int value;

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        Mode(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public MidUnitAdvanceCustomEQModeEntity(byte[] bArr) {
        Mode next;
        Iterator<Mode> it = Mode.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Mode mode = next;
            if (bArr != null && mode.getValue() == DataExtKt.getIntOrZero(bArr, 0)) {
                break;
            }
        }
        Mode mode2 = next;
        this.mode = mode2 == null ? Mode.OFF : mode2;
    }

    public /* synthetic */ MidUnitAdvanceCustomEQModeEntity(byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr);
    }

    public final Mode getMode() {
        return this.mode;
    }

    public final void setMode(Mode mode) {
        Intrinsics.checkNotNullParameter(mode, "<set-?>");
        this.mode = mode;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return DataExtKt.toByteArray$default(this.mode.getValue(), 0, 1, (Object) null);
    }
}
