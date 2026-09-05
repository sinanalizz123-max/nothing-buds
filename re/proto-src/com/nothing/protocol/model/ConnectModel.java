package com.nothing.protocol.model;

import com.nothing.base.util.ext.DataExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConnectModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/protocol/model/ConnectModel;", "", "payload", "", "<init>", "([B)V", "btModel", "", "getBtModel", "()Z", "setBtModel", "(Z)V", "leaConnect", "getLeaConnect", "setLeaConnect", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConnectModel {
    private boolean btModel;
    private boolean leaConnect;

    public ConnectModel(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.btModel = DataExtKt.getIntOrZero(payload, 0) == 0;
        this.leaConnect = DataExtKt.getIntOrZero(payload, 1) == 1;
    }

    public final boolean getBtModel() {
        return this.btModel;
    }

    public final void setBtModel(boolean z) {
        this.btModel = z;
    }

    public final boolean getLeaConnect() {
        return this.leaConnect;
    }

    public final void setLeaConnect(boolean z) {
        this.leaConnect = z;
    }
}
