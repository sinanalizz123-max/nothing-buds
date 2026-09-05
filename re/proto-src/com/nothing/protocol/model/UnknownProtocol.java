package com.nothing.protocol.model;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.nothing.protocol.device.TWSDevice;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UnknownProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\rH\u0016J\u0016\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\rH\u0016J \u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@\u00a2\u0006\u0002\u0010\u0016J$\u0010\u0017\u001a\u001e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0018j\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e`\u0019H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/nothing/protocol/model/UnknownProtocol;", "Lcom/nothing/protocol/model/ProtocolModel;", "<init>", "()V", "getSppUUID", "Ljava/util/UUID;", "connected", "", "activeMessage", "Lcom/nothing/protocol/model/Message;", "isNeedActivate", "", RemoteConfigComponent.ACTIVATE_FILE_NAME, "Lkotlin/Pair;", "", "", "getDeviceVersion", "parseVersion", "", "message", "device", "Lcom/nothing/protocol/device/TWSDevice;", "(Lcom/nothing/protocol/model/Message;Lcom/nothing/protocol/device/TWSDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCommandList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UnknownProtocol extends ProtocolModel {
    @Override // com.nothing.protocol.model.ProtocolModel
    public void connected(Message activeMessage) {
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public boolean isNeedActivate() {
        return false;
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public UUID getSppUUID() {
        UUID uuidFromString = UUID.fromString("AEAC4A03-DFF5-498F-843A-34487CF133EB");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        return uuidFromString;
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public Pair<Integer, byte[]> activate() {
        return TuplesKt.to(1, null);
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public Pair<Integer, byte[]> getDeviceVersion() {
        return TuplesKt.to(49218, null);
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public Object parseVersion(Message message, TWSDevice tWSDevice, Continuation<? super String> continuation) {
        return "";
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public HashMap<Integer, Integer> getCommandList() {
        return new HashMap<>();
    }
}
