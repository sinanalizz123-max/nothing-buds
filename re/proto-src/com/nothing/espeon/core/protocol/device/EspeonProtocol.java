package com.nothing.espeon.core.protocol.device;

import android.util.Log;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.util.Logger;
import com.nothing.espeon.core.protocol.entity.FirmwareVersion;
import com.nothing.log.FileLog;
import com.nothing.log.NTLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import com.nothing.protocol.model.ProtocolModel;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: EspeonProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000fH\u0016J\u0016\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0016J \u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0013H\u0016J$\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001aj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u001bH\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/espeon/core/protocol/device/EspeonProtocol;", "Lcom/nothing/protocol/model/ProtocolModel;", "<init>", "()V", "getSppUUID", "Ljava/util/UUID;", "getDeviceType", "", "connected", "", "activeMessage", "Lcom/nothing/protocol/model/Message;", "isNeedActivate", "", RemoteConfigComponent.ACTIVATE_FILE_NAME, "Lkotlin/Pair;", "", "getDeviceVersion", "parseVersion", "", "message", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "(Lcom/nothing/protocol/model/Message;Lcom/nothing/protocol/device/TWSDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "address", "getCommandList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EspeonProtocol extends ProtocolModel {
    public static final int DEVICE_TYPE = 1;
    public static final String EAR_NAME = "Espeon";
    public static final int EVENT_BATTERY_CHANGED = 57345;
    public static final int EVENT_DEVICE_STATUS_CHANGED = 57346;
    public static final int EVENT_NOISE_REDUCTION_LEVEL_CHANGED = 57347;
    public static final int GET_CURRENT_NOISE_REDUCTION = 49182;
    public static final int GET_EARPHONE_STATUS = 49162;
    public static final int GET_EQ_MODE = 49183;
    public static final int GET_HOST_VERSION_DEVICE = 49218;
    public static final int GET_PROTOCOL_VERSION = 49153;
    public static final int GET_REMOTE_BATTERY_LEVEL = 49159;
    private static final int NOTIFICATION_COMMANDS = 57344;
    private static final int QUERY_COMMANDS = 49152;

    @Override // com.nothing.protocol.model.ProtocolModel
    public int getDeviceType() {
        return 1;
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public boolean isNeedActivate() {
        return true;
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public UUID getSppUUID() {
        return getSPP_UUID();
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public void connected(Message activeMessage) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "send_command_source connected".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "send_command_source connected " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "send_command_source connected " + strComponent2);
            }
        }
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public Pair<Integer, byte[]> activate() {
        return TuplesKt.to(49153, null);
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public Pair<Integer, byte[]> getDeviceVersion() {
        return TuplesKt.to(49218, null);
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public Object parseVersion(Message message, TWSDevice tWSDevice, Continuation<? super String> continuation) {
        String address = tWSDevice.getAddress();
        if (address == null) {
            address = "";
        }
        return parseVersion(message, address);
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public String parseVersion(Message message, String address) {
        String versionStr;
        Intrinsics.checkNotNullParameter(address, "address");
        FirmwareVersion firmwareVersion = message != null ? (FirmwareVersion) message.obtainPayload(FirmwareVersion.class) : null;
        if (firmwareVersion == null || (versionStr = firmwareVersion.getVersionStr()) == null) {
            versionStr = "";
        }
        if (versionStr.length() > 0) {
            EspeonManager.INSTANCE.updateDeviceDaoVersion(versionStr, address);
        }
        NTLog.d("Device version string:" + (firmwareVersion != null ? firmwareVersion.getVersionStr() : null));
        return versionStr;
    }

    @Override // com.nothing.protocol.model.ProtocolModel
    public HashMap<Integer, Integer> getCommandList() {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = map;
        map2.put(49183, 49183);
        Integer numValueOf = Integer.valueOf(ProtocolConstant.Query.GET_HOST_LAG_MODE);
        map2.put(numValueOf, numValueOf);
        Integer numValueOf2 = Integer.valueOf(ProtocolConstant.Debug.GET_DEBUG_INFO);
        map2.put(numValueOf2, numValueOf2);
        Integer numValueOf3 = Integer.valueOf(ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS);
        map2.put(numValueOf3, numValueOf3);
        Integer numValueOf4 = Integer.valueOf(ProtocolConstant.Query.GET_REMOTE_CONFIGURATION);
        map2.put(numValueOf4, numValueOf4);
        return map;
    }
}
