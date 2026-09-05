package com.nothing.protocol.model;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.nothing.base.model.BaseProtocol;
import com.nothing.protocol.device.TWSDevice;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProtocolModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u000f\u0010\f\u001a\u0004\u0018\u00010\nH\u0016\u00a2\u0006\u0002\u0010\rJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\b\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010\u0015H&J\u0016\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0015H&J \u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001b\u001a\u00020\u001cH\u00a6@\u00a2\u0006\u0002\u0010\u001dJ\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J$\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0 j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`!H&J\b\u0010\"\u001a\u00020\u0013H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006%"}, d2 = {"Lcom/nothing/protocol/model/ProtocolModel;", "Lcom/nothing/base/model/BaseProtocol;", "<init>", "()V", "SPP_UUID", "Ljava/util/UUID;", "getSPP_UUID", "()Ljava/util/UUID;", "getSppUUID", "getDeviceType", "", "getControlFrameDeviceType", "getPayloadEndpointType", "()Ljava/lang/Integer;", "connected", "", "activeMessage", "Lcom/nothing/protocol/model/Message;", "isNeedActivate", "", RemoteConfigComponent.ACTIVATE_FILE_NAME, "Lkotlin/Pair;", "", "getDeviceVersion", "parseVersion", "", "message", "device", "Lcom/nothing/protocol/device/TWSDevice;", "(Lcom/nothing/protocol/model/Message;Lcom/nothing/protocol/device/TWSDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "address", "getCommandList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "sendDataNeedCrc", "supportAudio", "protocolModelKey", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ProtocolModel extends BaseProtocol {
    private final UUID SPP_UUID;

    public abstract Pair<Integer, byte[]> activate();

    public abstract void connected(Message activeMessage);

    public abstract HashMap<Integer, Integer> getCommandList();

    public int getDeviceType() {
        return 1;
    }

    public abstract Pair<Integer, byte[]> getDeviceVersion();

    public Integer getPayloadEndpointType() {
        return null;
    }

    public abstract UUID getSppUUID();

    public abstract boolean isNeedActivate();

    public abstract Object parseVersion(Message message, TWSDevice tWSDevice, Continuation<? super String> continuation);

    public boolean sendDataNeedCrc() {
        return true;
    }

    public boolean supportAudio() {
        return false;
    }

    public ProtocolModel() {
        UUID uuidFromString = UUID.fromString("AEAC4A03-DFF5-498F-843A-34487CF133EB");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        this.SPP_UUID = uuidFromString;
    }

    public final UUID getSPP_UUID() {
        return this.SPP_UUID;
    }

    public int getControlFrameDeviceType() {
        return getDeviceType();
    }

    public String parseVersion(Message message, String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        return "";
    }

    public String protocolModelKey() {
        return "";
    }
}
