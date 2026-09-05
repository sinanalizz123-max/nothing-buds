package com.nothing.ear.one.core.protocol;

import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.protocol.device.TWSDevice;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EarOneSppProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/ear/one/core/protocol/EarOneSppProtocol;", "Lcom/nothing/earbase/spp/BaseSppProtocol;", "address", "", "<init>", "(Ljava/lang/String;)V", "getDetailPageData", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarOneSppProtocol extends BaseSppProtocol {
    /* JADX WARN: Multi-variable type inference failed */
    public EarOneSppProtocol() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ EarOneSppProtocol(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public EarOneSppProtocol(String str) {
        super(str, "31D53D");
    }

    public final void getDetailPageData() {
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null) {
            TWSDevice.sendCommands$default(tWSDevice, new int[]{ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS, ProtocolConstant.Query.GET_HOST_LAG_MODE, ProtocolConstant.Debug.GET_DEBUG_INFO}, false, false, 6, null);
        }
    }
}
