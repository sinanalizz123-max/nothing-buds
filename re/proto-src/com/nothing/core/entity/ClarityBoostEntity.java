package com.nothing.core.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ClarityBoostEntity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0013B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/nothing/core/entity/ClarityBoostEntity;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "enabled", "", "getEnabled", "()Z", "setEnabled", "(Z)V", "level", "Lcom/nothing/core/entity/ClarityBoostEntity$Level;", "getLevel", "()Lcom/nothing/core/entity/ClarityBoostEntity$Level;", "setLevel", "(Lcom/nothing/core/entity/ClarityBoostEntity$Level;)V", "obtainDataPacket", "Level", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClarityBoostEntity implements ITWSParse {
    private boolean enabled;
    private Level level;

    /* JADX WARN: Multi-variable type inference failed */
    public ClarityBoostEntity() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: compiled from: ClarityBoostEntity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/nothing/core/entity/ClarityBoostEntity$Level;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LOW", "MID", "HIGH", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Level {
        LOW(0),
        MID(1),
        HIGH(2);

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());
        private final int value;

        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }

        Level(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public ClarityBoostEntity(byte[] bArr) {
        Level next;
        boolean z = false;
        if (bArr != null && DataExtKt.getIntOrZero(bArr, 0) == 1) {
            z = true;
        }
        this.enabled = z;
        Iterator<Level> it = Level.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Level level = next;
            if (bArr != null && level.getValue() == DataExtKt.getIntOrZero(bArr, 1)) {
                break;
            }
        }
        Level level2 = next;
        this.level = level2 == null ? Level.MID : level2;
    }

    public /* synthetic */ ClarityBoostEntity(byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr);
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    public final Level getLevel() {
        return this.level;
    }

    public final void setLevel(Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return new byte[]{this.enabled, (byte) this.level.getValue()};
    }
}
