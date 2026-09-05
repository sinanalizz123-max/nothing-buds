package com.nothing.earbase.ota.slice;

import android.util.Log;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TWSSliceCallBack.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/earbase/ota/slice/TWSSliceCallBack;", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "binder", "Lcom/nothing/earbase/ota/slice/OTASliceBinder;", "<init>", "(Lcom/nothing/earbase/ota/slice/OTASliceBinder;)V", "onConnected", "", "onDisconnected", "onError", "code", "", "message", "", "onUpdate", "cmdType", "data", "Lcom/nothing/protocol/model/Message;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TWSSliceCallBack implements TWSDevice.Callback {
    private final OTASliceBinder binder;

    public TWSSliceCallBack(OTASliceBinder binder) {
        Intrinsics.checkNotNullParameter(binder, "binder");
        this.binder = binder;
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void getBesVersionSuccess() {
        TWSDevice.Callback.DefaultImpls.getBesVersionSuccess(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public boolean isIOThread() {
        return TWSDevice.Callback.DefaultImpls.isIOThread(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnected(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnecting(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnecting(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onDisconnected(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice, int i, String str) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i, str);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int i, Message message, TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onUpdate(this, i, message, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void openBluetooth(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.openBluetooth(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected() {
        this.binder.setUpdateStatus(0);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
        this.binder.setUpdateStatus(0);
        OTASliceBinder.stopOTA$default(this.binder, false, 1, null);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(int code, String message) {
        this.binder.setUpdateStatus(0);
        OTASliceBinder.stopOTA$default(this.binder, false, 1, null);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) throws Throwable {
        Intrinsics.checkNotNullParameter(data, "data");
        switch (cmdType) {
            case ProtocolConstant.Notification.NOTIFY_DISCONNECT_PROFILE /* 57359 */:
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "NOTIFY_DISCONNECT_PROFILE".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 4, str, tag, "NOTIFY_DISCONNECT_PROFILE " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "NOTIFY_DISCONNECT_PROFILE " + strComponent2);
                    }
                }
                break;
            case ProtocolConstant.Notification.NOTIFY_REQUEST_START_OTA /* 57360 */:
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true) && "NOTIFY_REQUEST_START_OTA".length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str2 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    FileLog.print$default(fileLog2, 4, str2, tag2, "NOTIFY_REQUEST_START_OTA " + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, "NOTIFY_REQUEST_START_OTA " + strComponent4);
                    }
                }
                OTASliceBinder.startTransferOTAData$default(this.binder, false, null, 3, null);
                break;
            case ProtocolConstant.Notification.NOTIFY_REQUEST_STOP_OTA /* 57361 */:
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true) && "NOTIFY_REQUEST_STOP_OTA".length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str3 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog3, 4, str3, tag3, "NOTIFY_REQUEST_STOP_OTA " + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, "NOTIFY_REQUEST_STOP_OTA " + strComponent6);
                    }
                }
                this.binder.setUpdateStatus(0);
                OTASliceBinder.stopOTA$default(this.binder, false, 1, null);
                break;
        }
    }
}
