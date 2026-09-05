package com.nothing.protocol.device;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.entity.DeviceNoiseItem;
import com.nothing.protocol.device.entity.DeviceNoiseReduction;
import com.nothing.protocol.model.Message;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: TWSCommandCache.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\bJ/\u0010\u0014\u001a\u00020\u000e\"\n\b\u0000\u0010\u0015\u0018\u0001*\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00062\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0015\u0018\u00010\u0007H\u0086\bJ \u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0006R\"\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/nothing/protocol/device/TWSCommandCache;", "", "<init>", "()V", "cacheCommand", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/protocol/model/Message;", "connectStateLiveData", "Landroidx/lifecycle/MutableLiveData;", "getConnectStateLiveData", "()Landroidx/lifecycle/MutableLiveData;", "updateConnectStatus", "", NotificationCompat.CATEGORY_STATUS, "clearCommandCache", "updateCommand", "command", "message", "updateCommandCache", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/nothing/base/protocol/constant/ITWSParse;", "preLiveData", "getLiveDataCommand", "notifyCommand", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TWSCommandCache {
    private final ConcurrentHashMap<Integer, LiveData<Message>> cacheCommand = new ConcurrentHashMap<>();
    private final MutableLiveData<Integer> connectStateLiveData = new MutableLiveData<>();

    public final MutableLiveData<Integer> getConnectStateLiveData() {
        return this.connectStateLiveData;
    }

    public final void updateConnectStatus(int status) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "updateConnectStatus " + status;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        this.connectStateLiveData.setValue(Integer.valueOf(status));
    }

    public final void clearCommandCache() {
        this.cacheCommand.clear();
    }

    public final void updateCommand(int command, Message message) {
        DeviceNoiseItem noiseReductionMode;
        Intrinsics.checkNotNullParameter(message, "message");
        Integer numValueOf = null;
        LiveData liveDataCommand$default = getLiveDataCommand$default(this, command, 0, 2, null);
        Message message2 = (Message) liveDataCommand$default.getValue();
        if (command == 57347) {
            DeviceNoiseReduction deviceNoiseReduction = message2 != null ? (DeviceNoiseReduction) message2.obtainPayload(DeviceNoiseReduction.class) : null;
            if (deviceNoiseReduction != null) {
                DeviceNoiseReduction deviceNoiseReduction2 = (DeviceNoiseReduction) message.obtainPayload(DeviceNoiseReduction.class);
                if (deviceNoiseReduction2 != null && (noiseReductionMode = deviceNoiseReduction2.getNoiseReductionMode()) != null) {
                    numValueOf = Integer.valueOf(noiseReductionMode.getValue());
                }
                if (numValueOf != null) {
                    deviceNoiseReduction.updateLastNoiseReductionLevel(numValueOf.intValue());
                    message2.setPayload(deviceNoiseReduction.obtainDataPacket());
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "updateCommandCache " + liveDataCommand$default + "  " + DataExtKt.toHexString(command) + StringUtils.SPACE + message2;
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    Intrinsics.checkNotNull(liveDataCommand$default, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.nothing.protocol.model.Message?>");
                    ((MutableLiveData) liveDataCommand$default).setValue(message2);
                    return;
                }
            }
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "updateCommandCache  " + DataExtKt.toHexString(command) + StringUtils.SPACE;
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str6 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            Intrinsics.checkNotNull(liveDataCommand$default, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.nothing.protocol.model.Message?>");
            ((MutableLiveData) liveDataCommand$default).setValue(message);
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str7 = "updateCommandCache  " + DataExtKt.toHexString(command) + StringUtils.SPACE + message;
            String str8 = str7;
            if (str8 != null && str8.length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str9 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                FileLog.print$default(fileLog3, 4, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                }
            }
        }
        Intrinsics.checkNotNull(liveDataCommand$default, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.nothing.protocol.model.Message?>");
        ((MutableLiveData) liveDataCommand$default).setValue(message);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003c  */
    public final /* synthetic */ <T extends ITWSParse> void updateCommandCache(int command, LiveData<T> preLiveData) {
        T value;
        boolean z;
        if (preLiveData == null || (value = preLiveData.getValue()) == null) {
            return;
        }
        LiveData liveDataCommand$default = getLiveDataCommand$default(this, command, 0, 2, null);
        byte[] bArrObtainDataPacket = value.obtainDataPacket();
        Message message = (Message) liveDataCommand$default.getValue();
        boolean zEquals = Arrays.equals(message != null ? message.getPayload() : null, bArrObtainDataPacket);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "updateCommandCache  isSame:" + zEquals + StringUtils.SPACE + DataExtKt.toHexString(command) + StringUtils.SPACE;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z = zEquals;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                z = zEquals;
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            z = zEquals;
        }
        if (z) {
            return;
        }
        Message message2 = (Message) liveDataCommand$default.getValue();
        if (message2 != null) {
            message2.setPayload(bArrObtainDataPacket);
        }
        Intrinsics.checkNotNull(liveDataCommand$default, "null cannot be cast to non-null type androidx.lifecycle.MutableLiveData<com.nothing.protocol.model.Message?>");
        MutableLiveData mutableLiveData = (MutableLiveData) liveDataCommand$default;
        mutableLiveData.postValue(mutableLiveData.getValue());
    }

    public static /* synthetic */ LiveData getLiveDataCommand$default(TWSCommandCache tWSCommandCache, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = -1;
        }
        return tWSCommandCache.getLiveDataCommand(i, i2);
    }

    public final LiveData<Message> getLiveDataCommand(int command, int notifyCommand) {
        MutableLiveData mutableLiveData = this.cacheCommand.get(Integer.valueOf(command));
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData();
            this.cacheCommand.put(Integer.valueOf(command), mutableLiveData);
        }
        if (notifyCommand != -1) {
            this.cacheCommand.put(Integer.valueOf(notifyCommand), mutableLiveData);
        }
        return mutableLiveData;
    }
}
