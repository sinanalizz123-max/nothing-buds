package com.nothing.earbase.os;

import android.os.Bundle;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceProtocol.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\u0004\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\"\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\u0019\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086@\u00a2\u0006\u0002\u0010\u0017J\"\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0005J*\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010!J\u000e\u0010\"\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0005J\"\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010$\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010%\u001a\u00020\u00142\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u001a\u0010&\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0086@\u00a2\u0006\u0002\u0010\u0017J\"\u0010'\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006("}, d2 = {"Lcom/nothing/earbase/os/DeviceProtocol;", "", "<init>", "()V", "obtainBundle", "Landroid/os/Bundle;", "extras", "address", "", "setEarDetect", "", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "enable", "(Lcom/nothing/protocol/device/TWSDevice;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setNoiseReduction", "value", "", "(Lcom/nothing/protocol/device/TWSDevice;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEarDetect", "", "getVersion", "Lcom/nothing/protocol/model/Message;", "(Lcom/nothing/protocol/device/TWSDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEqMode", "getLagMode", "getSerialNumber", "setLagMode", "getGestureData", "setGestureData", "it", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "operation", "(Landroid/os/Bundle;Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSoundPageData", "setEQMode", "eqMode", "getPersonalizedAnc", "getMimiFittingFetchLevel", "setPersonalizedANC", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceProtocol {
    public static final DeviceProtocol INSTANCE = new DeviceProtocol();

    private DeviceProtocol() {
    }

    public final Bundle obtainBundle(Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        String string = extras.getString("device_address");
        String str = string;
        if (str == null || str.length() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        bundle.putString("device_address", string);
        return bundle;
    }

    public final Bundle obtainBundle(String address) {
        String str = address;
        if (str == null || str.length() == 0) {
            return new Bundle();
        }
        Bundle bundle = new Bundle();
        bundle.putString("device_address", address);
        return bundle;
    }

    public final Object setEarDetect(TWSDevice tWSDevice, boolean z, Continuation<? super Boolean> continuation) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(3);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
        if (tWSDevice == null) {
            return null;
        }
        Object objSyncSet$default = TWSDevice.syncSet$default(tWSDevice, ProtocolConstant.Set.SET_EXTRA_FEATURE_STATUS, byteBufferAllocate.array(), null, false, continuation, 12, null);
        return objSyncSet$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSyncSet$default : (Boolean) objSyncSet$default;
    }

    public final Object setNoiseReduction(TWSDevice tWSDevice, int i, Continuation<? super Boolean> continuation) {
        if (tWSDevice == null) {
            return null;
        }
        Object objSyncSet$default = TWSDevice.syncSet$default(tWSDevice, ProtocolConstant.Set.SET_CURRENT_NOISE_REDUCTION, new byte[]{1, (byte) i, 0}, null, false, continuation, 12, null);
        return objSyncSet$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSyncSet$default : (Boolean) objSyncSet$default;
    }

    public final void getEarDetect(TWSDevice twsDevice) {
        if (twsDevice != null) {
            TWSDevice.sendMessage$default(twsDevice, ProtocolConstant.Query.GET_EXTRA_FEATURE_STATUS, null, false, false, null, null, 0, 126, null);
        }
    }

    public final Object getVersion(TWSDevice tWSDevice, Continuation<? super Message> continuation) {
        if (tWSDevice != null) {
            return TWSDevice.syncSetResponse$default(tWSDevice, 49218, null, null, false, false, null, continuation, 62, null);
        }
        return null;
    }

    public final void getEqMode(TWSDevice twsDevice) {
        if (twsDevice != null) {
            TWSDevice.sendMessage$default(twsDevice, 49183, null, false, false, null, null, 0, 126, null);
        }
    }

    public final void getLagMode(TWSDevice twsDevice) {
        if (twsDevice != null) {
            TWSDevice.sendMessage$default(twsDevice, ProtocolConstant.Query.GET_HOST_LAG_MODE, null, false, false, null, null, 0, 126, null);
        }
    }

    public final Object getSerialNumber(TWSDevice tWSDevice, Continuation<? super Message> continuation) {
        if (tWSDevice != null) {
            return TWSDevice.syncSetResponse$default(tWSDevice, ProtocolConstant.Query.GET_REMOTE_CONFIGURATION, null, null, false, false, null, continuation, 62, null);
        }
        return null;
    }

    public final Object setLagMode(TWSDevice tWSDevice, boolean z, Continuation<? super Boolean> continuation) {
        int i = z ? 1 : 2;
        if (tWSDevice == null) {
            return null;
        }
        Object objSyncSet$default = TWSDevice.syncSet$default(tWSDevice, ProtocolConstant.Set.SET_LAG_MODE, DataExtKt.toByteArray$default(i, 0, 1, (Object) null), null, false, continuation, 12, null);
        return objSyncSet$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSyncSet$default : (Boolean) objSyncSet$default;
    }

    public final void getGestureData(Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        TWSDevice twsDevice = OsMemoryCache.INSTANCE.getTwsDevice(extras);
        if (twsDevice != null) {
            TWSDevice.sendCommands$default(twsDevice, new int[]{ProtocolConstant.Query.GET_KEY_CONFIGURATION}, false, false, 6, null);
        }
    }

    public final Object setGestureData(Bundle bundle, ControlConfigurationEntity.Operation operation, int i, Continuation<? super Boolean> continuation) {
        TWSDevice twsDevice;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(5);
        byteBufferAllocate.put((byte) 1);
        byteBufferAllocate.put((byte) operation.getDevice()).put((byte) operation.getButton()).put((byte) operation.getGesture()).put((byte) i);
        if (bundle == null || (twsDevice = OsMemoryCache.INSTANCE.getTwsDevice(bundle)) == null) {
            return null;
        }
        Object objSyncSet$default = TWSDevice.syncSet$default(twsDevice, ProtocolConstant.Set.SET_KEY_CONFIGURATION, byteBufferAllocate.array(), null, false, continuation, 12, null);
        return objSyncSet$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSyncSet$default : (Boolean) objSyncSet$default;
    }

    public final void getSoundPageData(Bundle extras) {
        Intrinsics.checkNotNullParameter(extras, "extras");
        TWSDevice twsDevice = OsMemoryCache.INSTANCE.getTwsDevice(extras);
        if (twsDevice != null) {
            TWSDevice.sendCommands$default(twsDevice, new int[]{49183, ProtocolConstant.Query.GET_CUSTOM_EQ_VALUE}, false, false, 6, null);
        }
    }

    public final Object setEQMode(TWSDevice tWSDevice, int i, Continuation<? super Boolean> continuation) {
        if (tWSDevice == null) {
            return null;
        }
        Object objSyncSet$default = TWSDevice.syncSet$default(tWSDevice, ProtocolConstant.Set.SET_EQ_MODE, DataExtKt.toByteArray$default(i, 0, 1, (Object) null), null, false, continuation, 12, null);
        return objSyncSet$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSyncSet$default : (Boolean) objSyncSet$default;
    }

    public final void getPersonalizedAnc(TWSDevice twsDevice) {
        if (twsDevice != null) {
            TWSDevice.sendMessage$default(twsDevice, ProtocolConstant.Query.GET_PERSONALIZED_ANC, null, false, false, null, null, 0, 126, null);
        }
    }

    public final Object getMimiFittingFetchLevel(TWSDevice tWSDevice, Continuation<? super Message> continuation) {
        if (tWSDevice != null) {
            return TWSDevice.syncSetResponse$default(tWSDevice, ProtocolConstant.Query.GET_MIMI_FITTING_TECH_LEVEL, null, null, false, false, null, continuation, 62, null);
        }
        return null;
    }

    public final Object setPersonalizedANC(TWSDevice tWSDevice, int i, Continuation<? super Boolean> continuation) {
        if (tWSDevice == null) {
            return null;
        }
        Object objSyncSet$default = TWSDevice.syncSet$default(tWSDevice, ProtocolConstant.Set.SET_PERSONALIZED, new byte[]{(byte) i}, null, false, continuation, 12, null);
        return objSyncSet$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSyncSet$default : (Boolean) objSyncSet$default;
    }
}
