package com.nothing.base.protocol.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScenarioModeEntity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/base/protocol/entity/ScenarioModeEntity;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "mode", "", "getMode", "()I", "setMode", "(I)V", "obtainDataPacket", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScenarioModeEntity implements ITWSParse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private int mode;

    public ScenarioModeEntity(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.mode = DataExtKt.getIntOrZero(payload, 0);
    }

    public final int getMode() {
        return this.mode;
    }

    public final void setMode(int i) {
        this.mode = i;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return new byte[]{(byte) this.mode};
    }

    /* JADX INFO: compiled from: ScenarioModeEntity.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/base/protocol/entity/ScenarioModeEntity$Companion;", "", "<init>", "()V", "obtainDataPacket", "", "mode", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] obtainDataPacket(int mode) {
            return new byte[]{(byte) mode};
        }
    }
}
