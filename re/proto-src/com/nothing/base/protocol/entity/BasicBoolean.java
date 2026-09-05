package com.nothing.base.protocol.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicBoolean.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/nothing/base/protocol/entity/BasicBoolean;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "open", "", "getOpen", "()Z", "setOpen", "(Z)V", "head", "getHead", "setHead", "hasHead", "getHasHead", "setHasHead", "obtainDataPacket", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BasicBoolean implements ITWSParse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean hasHead;
    private boolean head;
    private boolean open;

    public BasicBoolean(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        boolean z = false;
        this.open = DataExtKt.getIntOrZero(payload, 0) == 1;
        if (payload.length > 1) {
            this.hasHead = true;
            if (DataExtKt.getIntOrZero(payload, 1) == 1) {
                z = true;
            }
        }
        this.head = z;
    }

    public final boolean getOpen() {
        return this.open;
    }

    public final void setOpen(boolean z) {
        this.open = z;
    }

    public final boolean getHead() {
        return this.head;
    }

    public final void setHead(boolean z) {
        this.head = z;
    }

    public final boolean getHasHead() {
        return this.hasHead;
    }

    public final void setHasHead(boolean z) {
        this.hasHead = z;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return this.hasHead ? new byte[]{this.open, this.head} : new byte[]{this.open};
    }

    /* JADX INFO: compiled from: BasicBoolean.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/nothing/base/protocol/entity/BasicBoolean$Companion;", "", "<init>", "()V", "obtainDataPacket", "", "switch", "", "head", "(ZLjava/lang/Boolean;)[B", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ byte[] obtainDataPacket$default(Companion companion, boolean z, Boolean bool, int i, Object obj) {
            if ((i & 2) != 0) {
                bool = null;
            }
            return companion.obtainDataPacket(z, bool);
        }

        public final byte[] obtainDataPacket(boolean z, Boolean head) {
            if (head == null) {
                return new byte[]{z ? (byte) 1 : (byte) 0};
            }
            return new byte[]{z ? (byte) 1 : (byte) 0, head.booleanValue()};
        }
    }
}
