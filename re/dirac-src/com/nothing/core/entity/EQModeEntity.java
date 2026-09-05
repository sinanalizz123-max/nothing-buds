package com.nothing.core.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EQModeEntity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u000eB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0004\u0010\bJ\b\u0010\r\u001a\u00020\u0003H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/core/entity/EQModeEntity;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "byteArray", "", "<init>", "([B)V", "mode", "Lcom/nothing/core/entity/EQModeEntity$Mode;", "(Lcom/nothing/core/entity/EQModeEntity$Mode;)V", "model", "getModel", "()Lcom/nothing/core/entity/EQModeEntity$Mode;", "setModel", "obtainDataPacket", "Mode", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EQModeEntity implements ITWSParse {
    private Mode model;

    /* JADX WARN: Multi-variable type inference failed */
    public EQModeEntity() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: compiled from: EQModeEntity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/nothing/core/entity/EQModeEntity$Mode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FLAT_OR_BALANCED", "VOICE", "MORE_TREBLE", "MORE_BASE", "DIRAC_EQ", "SIMPLE_CUSTOM_EQ", "NEW_VOICE", "NEW_INSTRUMENT", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Mode {
        FLAT_OR_BALANCED(0),
        VOICE(1),
        MORE_TREBLE(2),
        MORE_BASE(3),
        DIRAC_EQ(4),
        SIMPLE_CUSTOM_EQ(5),
        NEW_VOICE(6),
        NEW_INSTRUMENT(7);

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

    public EQModeEntity(byte[] bArr) {
        for (Mode mode : Mode.values()) {
            if (bArr != null && mode.getValue() == DataExtKt.getIntOrZero(bArr, 0)) {
                this.model = mode;
            }
        }
        mode = null;
        this.model = mode;
    }

    public /* synthetic */ EQModeEntity(byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EQModeEntity(Mode mode) {
        this(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.model = mode;
    }

    public final Mode getModel() {
        return this.model;
    }

    public final void setModel(Mode mode) {
        this.model = mode;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        Mode mode = this.model;
        if (mode == null) {
            mode = Mode.FLAT_OR_BALANCED;
        }
        return DataExtKt.toByteArray$default(mode.getValue(), 0, 1, (Object) null);
    }
}
