package com.nothing.ear.stick.core.protocol;

import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.ear.stick.core.device.IOTProductDeviceEarStick;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: EarStickSppProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007\u00a8\u0006\b"}, d2 = {"Lcom/nothing/ear/stick/core/protocol/EarStickSppProtocol;", "Lcom/nothing/earbase/spp/BaseSppProtocol;", "address", "", "<init>", "(Ljava/lang/String;)V", "getDetailPageData", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarStickSppProtocol extends BaseSppProtocol {
    /* JADX WARN: Multi-variable type inference failed */
    public EarStickSppProtocol() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ EarStickSppProtocol(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    public EarStickSppProtocol(String str) {
        super(str, IOTProductDeviceEarStick.EAR_ID);
    }

    public final void getDetailPageData() {
        TWSDeviceBuilder tWSDeviceBuilderLagMode$default;
        TWSDeviceBuilder tWSDeviceBuilderExtraFeatureStatus$default;
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice != null && (tWSDeviceBuilderExtraFeatureStatus$default = TWSDeviceExtKt.extraFeatureStatus$default(tWSDevice, null, 1, null)) != null) {
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderExtraFeatureStatus$default, false, (byte[]) null, 0, 7, (Object) null);
        }
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 == null || (tWSDeviceBuilderLagMode$default = TWSDeviceExtKt.lagMode$default(tWSDevice2, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderLagMode$default, false, (byte[]) null, 0, 7, (Object) null);
    }
}
