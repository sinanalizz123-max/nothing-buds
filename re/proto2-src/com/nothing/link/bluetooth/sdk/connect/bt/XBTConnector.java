package com.nothing.link.bluetooth.sdk.connect.bt;

import android.bluetooth.BluetoothDevice;
import android.os.Build;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XBondConnector;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.scan.XBluetoothFlowCallBack;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.os.device.DeviceConstant;
import java.util.Date;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBTConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 I2\u00020\u0001:\u0001IB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\u0018\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!H\u0016J\u001a\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001e2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016Jo\u0010,\u001a\u00020\u001a2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010/\u001a\u0002002\n\b\u0002\u00101\u001a\u0004\u0018\u0001002\n\b\u0002\u00102\u001a\u0004\u0018\u0001002\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u001a04\u00a2\u0006\u0002\b52\u001b\b\u0002\u00106\u001a\u0015\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020\u001a\u0018\u000104\u00a2\u0006\u0002\b5\u00a2\u0006\u0002\u00107J\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u000200092\u0006\u00101\u001a\u000200J\b\u0010:\u001a\u00020;H\u0016J\u000e\u0010<\u001a\u00020\u001a2\u0006\u0010=\u001a\u000200J\u001b\u0010>\u001a\u00020\u001e2\b\b\u0002\u00101\u001a\u000200H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010?J\u001a\u0010@\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010A\u001a\u00020\u001eH\u0016J\"\u0010B\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u001eH\u0016J\"\u0010E\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u001eH\u0016J\b\u0010F\u001a\u00020\u001aH\u0016J\u001a\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u0002002\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006J"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/XBondConnector;", "()V", "btJob", "Lkotlinx/coroutines/Job;", "getBtJob", "()Lkotlinx/coroutines/Job;", "setBtJob", "(Lkotlinx/coroutines/Job;)V", "createJob", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCreateJob", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "lastState", "Ljava/util/concurrent/atomic/AtomicInteger;", "getLastState", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setLastState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "mXConnectCallback", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;", "getMXConnectCallback", "()Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;", "setMXConnectCallback", "(Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;)V", "actionEncryptionChange", "", "device", "Landroid/bluetooth/BluetoothDevice;", "isSecure", "", "boundCancel", "code", "", "boundSuccess", "boundTimeOut", "checkFail", "failType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "reason", "checkParameterAndStartConnectJob", "isRetry", "flowCallBack", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "connect", "boundMillisTimeOut", "", "retryMaxBondCount", "", "profileType", "unknownTransport", "connectCallback", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "bluetoothFlowCallback", "(Ljava/lang/Long;ILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "connectInternal", "Lkotlin/Pair;", "getConnectorType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "initProfileType", "type", "isConnected", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyMissingChanged", "connected", "onA2DPChange", "a2dpConnect", "headsetConnect", "onHeadSetChange", "startBound", "updateLastState", "state", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class XBTConnector extends XBondConnector {
    public static final int INVOKE_STATUS_FAILED = 3;
    public static final int INVOKE_STATUS_NO_PERMISSION = 2;
    public static final int INVOKE_STATUS_SUCCESS = 1;
    private Job btJob;
    private final AtomicBoolean createJob = new AtomicBoolean(false);
    private AtomicInteger lastState = new AtomicInteger(0);
    private XConnectCallback mXConnectCallback;

    public final AtomicBoolean getCreateJob() {
        return this.createJob;
    }

    public final XConnectCallback getMXConnectCallback() {
        return this.mXConnectCallback;
    }

    public final void setMXConnectCallback(XConnectCallback xConnectCallback) {
        this.mXConnectCallback = xConnectCallback;
    }

    public final AtomicInteger getLastState() {
        return this.lastState;
    }

    public final void setLastState(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
        this.lastState = atomicInteger;
    }

    public final Job getBtJob() {
        return this.btJob;
    }

    public final void setBtJob(Job job) {
        this.btJob = job;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public XConnectType getConnectorType() {
        return XConnectType.BT.INSTANCE;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void startBound() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            XConnectType connectorType = getConnectorType();
            XBluetoothDevice mBleDevice = getMBleDevice();
            String str = connectorType + " startBound " + (mBleDevice != null ? mBleDevice.getRealAddress() : null);
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        updateLastState$default(this, 5, null, 2, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void boundTimeOut() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            XConnectType connectorType = getConnectorType();
            XBluetoothDevice mBleDevice = getMBleDevice();
            String str = connectorType + " boundTimeOut " + (mBleDevice != null ? mBleDevice.getRealAddress() : null);
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        updateLastState(4, XConnectFailType.BoundTimeOut.INSTANCE);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void boundCancel(String code) {
        Intrinsics.checkNotNullParameter(code, "code");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            XConnectType connectorType = getConnectorType();
            XBluetoothDevice mBleDevice = getMBleDevice();
            String str = connectorType + " boundCancel " + (mBleDevice != null ? mBleDevice.getRealAddress() : null) + "  " + code;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        int iHashCode = code.hashCode();
        if (iHashCode != 49) {
            if (iHashCode != 52) {
                if (iHashCode == 57 && code.equals("9")) {
                    updateLastState(4, XConnectFailType.UserFailed.INSTANCE);
                    return;
                }
            } else if (code.equals(DeviceConstant.NOISE_CANCELLATION_ADAPTIVE)) {
                updateLastState(4, XConnectFailType.PageTimeout.INSTANCE);
                return;
            }
        } else if (code.equals("1")) {
            updateLastState(4, XConnectFailType.UserCancel.INSTANCE);
            return;
        }
        updateLastState(4, XConnectFailType.UnBound.INSTANCE);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void boundSuccess() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            XConnectType connectorType = getConnectorType();
            XBluetoothDevice mBleDevice = getMBleDevice();
            String str = connectorType + " boundSuccess " + (mBleDevice != null ? mBleDevice.getRealAddress() : null);
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        XBondConnector.Companion companion = XBondConnector.INSTANCE;
        XBluetoothDevice mBleDevice2 = getMBleDevice();
        companion.clearBondPageTimeoutCooldown(mBleDevice2 != null ? mBleDevice2.getRealAddress() : null);
        XBondConnector.Companion companion2 = XBondConnector.INSTANCE;
        XBluetoothDevice mBleDevice3 = getMBleDevice();
        companion2.clearBondPageTimeoutCooldown(mBleDevice3 != null ? mBleDevice3.getDeviceAddress() : null);
        updateLastState$default(this, -1, null, 2, null);
    }

    public static /* synthetic */ void updateLastState$default(XBTConnector xBTConnector, int i, XConnectFailType xConnectFailType, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLastState");
        }
        if ((i2 & 2) != 0) {
            xConnectFailType = null;
        }
        xBTConnector.updateLastState(i, xConnectFailType);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002b  */
    public final void updateLastState(int state, XConnectFailType failType) {
        String str;
        String str2;
        String str3;
        XConnectFailType xConnectFailType;
        Job job = this.btJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        int i = this.lastState.get();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            XConnectType connectorType = getConnectorType();
            XBluetoothDevice mBleDevice = getMBleDevice();
            String str4 = connectorType + StringUtils.SPACE + (mBleDevice != null ? mBleDevice.getRealAddress() : null) + " updateLastState " + i + " -> " + state + StringUtils.SPACE;
            String str5 = str4;
            if (str5 == null || str5.length() == 0) {
                str = "format(...)";
                str2 = " updateLastState ";
                str3 = StringUtils.SPACE;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str6 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                String str7 = str4 + StringUtils.SPACE + strComponent2;
                str = "format(...)";
                str2 = " updateLastState ";
                str3 = StringUtils.SPACE;
                FileLog.print$default(fileLog, 3, str6, tag, str7, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str4 + str3 + strComponent2);
                }
            }
        } else {
            str = "format(...)";
            str2 = " updateLastState ";
            str3 = StringUtils.SPACE;
        }
        if (i != state) {
            this.lastState.set(state);
            if (state != 0) {
                if (state == 2) {
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        XConnectType connectorType2 = getConnectorType();
                        XBluetoothDevice mBleDevice2 = getMBleDevice();
                        String str8 = connectorType2 + " updateLastState CONNECTED " + (mBleDevice2 != null ? mBleDevice2.getRealAddress() : null);
                        String str9 = str8;
                        if (str9 != null && str9.length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str10 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str10, str);
                            FileLog.print$default(fileLog2, 3, str10, tag2, str8 + str3 + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, str8 + str3 + strComponent4);
                            }
                        }
                    }
                    XConnectCallback xConnectCallback = this.mXConnectCallback;
                    if (xConnectCallback != null) {
                        xConnectCallback.callConnectSuccess(getConnectorType(), getMBleDevice());
                        return;
                    }
                    return;
                }
                if (state != 4) {
                    return;
                }
            }
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                XConnectType connectorType3 = getConnectorType();
                XBluetoothDevice mBleDevice3 = getMBleDevice();
                xConnectFailType = failType;
                String str11 = connectorType3 + str2 + state + "  failType:" + xConnectFailType + str3 + (mBleDevice3 != null ? mBleDevice3.getRealAddress() : null);
                String str12 = str11;
                if (str12 != null && str12.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str13 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str13, str);
                    FileLog.print$default(fileLog3, 3, str13, tag3, str11 + str3 + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str11 + str3 + strComponent6);
                    }
                }
            } else {
                xConnectFailType = failType;
            }
            if (xConnectFailType != null) {
                XConnectCallback xConnectCallback2 = this.mXConnectCallback;
                if (xConnectCallback2 != null) {
                    xConnectCallback2.callConnectFail(getMBleDevice(), xConnectFailType);
                    return;
                }
                return;
            }
            XConnectCallback xConnectCallback3 = this.mXConnectCallback;
            if (xConnectCallback3 != null) {
                xConnectCallback3.callDisConnected(false, getMBleDevice(), null, getConnectorType().getType());
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onHeadSetChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (a2dpConnect || headsetConnect) {
            updateLastState$default(this, 2, null, 2, null);
        } else {
            updateLastState$default(this, 0, null, 2, null);
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onA2DPChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (a2dpConnect || headsetConnect) {
            updateLastState$default(this, 2, null, 2, null);
        } else {
            updateLastState$default(this, 0, null, 2, null);
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void keyMissingChanged(BluetoothDevice device, boolean connected) {
        super.keyMissingChanged(device, connected);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getConnectorType() + ",reason:keyMissingChanged ,device:" + device + StringUtils.SPACE;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 5, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (connected) {
            return;
        }
        updateLastState(4, XConnectFailType.KeyMissingPaired.INSTANCE);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void actionEncryptionChange(BluetoothDevice device, boolean isSecure) {
        super.actionEncryptionChange(device, isSecure);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getConnectorType() + ",reason:actionEncryptionChange ,device:" + device + "  isSecure:" + isSecure;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str3 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog, 5, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void checkFail(XConnectFailType failType, String reason) {
        Intrinsics.checkNotNullParameter(failType, "failType");
        Intrinsics.checkNotNullParameter(reason, "reason");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            XConnectType connectorType = getConnectorType();
            XBluetoothDevice mBleDevice = getMBleDevice();
            String str = connectorType + StringUtils.SPACE + failType + " ,reason:" + reason + " ,device:" + (mBleDevice != null ? mBleDevice.getDeviceAddress() : null) + StringUtils.SPACE;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str3 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog, 5, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void checkParameterAndStartConnectJob(boolean isRetry, XBluetoothFlowCallBack flowCallBack) {
        Job boundJob = getBoundJob();
        if ((boundJob != null && boundJob.isActive()) || this.createJob.get()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                XConnectType connectorType = getConnectorType();
                Job boundJob2 = getBoundJob();
                String str = connectorType + " ,boundJob=" + (boundJob2 != null ? Boolean.valueOf(boundJob2.isActive()) : null) + " createJob:" + this.createJob.get() + ",current already start.";
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    return;
                }
                return;
            }
            return;
        }
        this.createJob.set(true);
        this.lastState.set(0);
        addDeviceSateChange();
        Job job = this.btJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass2(flowCallBack, null), 3, null);
        this.btJob = jobLaunch$default;
        if (jobLaunch$default != null) {
            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector.checkParameterAndStartConnectJob.3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    XBTConnector.this.getCreateJob().set(false);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector$checkParameterAndStartConnectJob$2, reason: invalid class name */
    /* JADX INFO: compiled from: XBTConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector$checkParameterAndStartConnectJob$2", f = "XBTConnector.kt", i = {}, l = {169, 174}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XBluetoothFlowCallBack $flowCallBack;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(XBluetoothFlowCallBack xBluetoothFlowCallBack, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$flowCallBack = xBluetoothFlowCallBack;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBTConnector.this.new AnonymousClass2(this.$flowCallBack, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        
            if (kotlinx.coroutines.TimeoutKt.withTimeout(r12.this$0.getMBoundMillisTimeOut(), new com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector.AnonymousClass2.AnonymousClass1(r12.this$0, null), r12) == r0) goto L24;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = XBondConnector.checkParameters$default(XBTConnector.this, this.$flowCallBack, false, this, 2, null);
                    if (obj != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                if (!((Boolean) obj).booleanValue()) {
                    XBTConnector.this.getCreateJob().set(false);
                    return Unit.INSTANCE;
                }
                this.label = 2;
            } catch (TimeoutCancellationException e) {
                e.printStackTrace();
                XBTConnector.updateLastState$default(XBTConnector.this, 4, null, 2, null);
            } finally {
                XBTConnector.this.getCreateJob().set(false);
            }
        }

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector$checkParameterAndStartConnectJob$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: XBTConnector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector$checkParameterAndStartConnectJob$2$1", f = "XBTConnector.kt", i = {0}, l = {177, 198}, m = "invokeSuspend", n = {"connectResult"}, s = {"L$0"})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            Object L$0;
            int label;
            final /* synthetic */ XBTConnector this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(XBTConnector xBTConnector, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = xBTConnector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:27:0x00b0, code lost:
            
                if (kotlinx.coroutines.DelayKt.delay(r7.this$0.getMBoundMillisTimeOut(), r7) == r0) goto L28;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Pair<Boolean, Integer> pairConnectInternal;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    XBTConnector xBTConnector = this.this$0;
                    pairConnectInternal = xBTConnector.connectInternal(xBTConnector.getProfileType());
                    if (!pairConnectInternal.getFirst().booleanValue()) {
                        XBTConnector xBTConnector2 = this.this$0;
                        this.L$0 = pairConnectInternal;
                        this.label = 1;
                        obj = xBTConnector2.isConnected(xBTConnector2.getProfileType(), this);
                        if (obj != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    XBTConnector.updateLastState$default(this.this$0, 2, null, 2, null);
                    return Unit.INSTANCE;
                }
                if (i == 1) {
                    pairConnectInternal = (Pair) this.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Unit.INSTANCE;
                if (!((Boolean) obj).booleanValue()) {
                    if (pairConnectInternal.getSecond().intValue() == 2) {
                        this.this$0.getCreateJob().set(false);
                        this.this$0.updateLastState(4, XConnectFailType.connectPeerPaired.INSTANCE);
                        return Unit.INSTANCE;
                    }
                    if (pairConnectInternal.getSecond().intValue() == 3) {
                        this.this$0.getCreateJob().set(false);
                        this.this$0.updateLastState(0, XConnectFailType.InvokeFailed.INSTANCE);
                        return Unit.INSTANCE;
                    }
                    this.L$0 = null;
                    this.label = 2;
                }
                XBTConnector.updateLastState$default(this.this$0, 2, null, 2, null);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void connect$default(XBTConnector xBTConnector, Long l, int i, Integer num, Integer num2, Function1 function1, Function1 function2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connect");
        }
        if ((i2 & 1) != 0) {
            l = 0L;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            num2 = null;
        }
        xBTConnector.connect(l, i, num, num2, function1, (i2 & 32) != 0 ? null : function2);
    }

    public final void connect(Long boundMillisTimeOut, int retryMaxBondCount, Integer profileType, Integer unknownTransport, Function1<? super XConnectCallback, Unit> connectCallback, Function1<? super XBluetoothFlowCallBack, Unit> bluetoothFlowCallback) {
        Intrinsics.checkNotNullParameter(connectCallback, "connectCallback");
        if (profileType != null) {
            setProfileType(profileType.intValue());
        }
        if (unknownTransport != null) {
            setUnknownTransport(unknownTransport.intValue());
        }
        setRetryMaxBondCount(retryMaxBondCount <= 0 ? getMXBluetoothManager().getBluetoothConfig().getBondRetryMaxCount() : retryMaxBondCount);
        long jLongValue = 0;
        if ((boundMillisTimeOut != null ? boundMillisTimeOut.longValue() : 0L) <= 0) {
            jLongValue = getMXBluetoothManager().getBluetoothConfig().getBoundMillisTimeOut();
        } else if (boundMillisTimeOut != null) {
            jLongValue = boundMillisTimeOut.longValue();
        }
        setMBoundMillisTimeOut(jLongValue);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getConnectorType() + "  connect timeout is  " + getMBoundMillisTimeOut();
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        XConnectCallback xConnectCallback = new XConnectCallback();
        connectCallback.invoke(xConnectCallback);
        this.mXConnectCallback = xConnectCallback;
        if (bluetoothFlowCallback != null) {
            XBluetoothFlowCallBack xBluetoothFlowCallBack = new XBluetoothFlowCallBack();
            bluetoothFlowCallback.invoke(xBluetoothFlowCallBack);
            setMXBluetoothFlowCallBack(xBluetoothFlowCallBack);
        }
        XConnectCallback xConnectCallback2 = this.mXConnectCallback;
        if (xConnectCallback2 != null) {
            xConnectCallback2.callConnectStart();
        }
        XBondConnector.checkParameterAndStartConnectJob$default(this, false, getMXBluetoothFlowCallBack(), 1, null);
    }

    public final void initProfileType(int type) {
        setProfileType(type);
    }

    public static /* synthetic */ Object isConnected$default(XBTConnector xBTConnector, int i, Continuation continuation, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isConnected");
        }
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return xBTConnector.isConnected(i, continuation);
    }

    public final Object isConnected(int i, Continuation<? super Boolean> continuation) {
        BluetoothDevice remoteDevice = getRemoteDevice();
        if (remoteDevice == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = getConnectorType() + " isConnected BluetoothDevice is null";
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 6, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return Boxing.boxBoolean(false);
        }
        return XBTReceiverHelper.INSTANCE.get().isConnect(remoteDevice, i, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0502  */
    /* JADX WARN: Code duplicated, block: B:110:0x050d  */
    /* JADX WARN: Code duplicated, block: B:119:0x051c  */
    /* JADX WARN: Code duplicated, block: B:37:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:39:0x01b5  */
    /* JADX WARN: Code duplicated, block: B:40:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:44:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:46:0x01c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:49:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:51:0x01cb A[PHI: r2
      0x01cb: PHI (r2v33 boolean) = (r2v31 boolean), (r2v43 boolean) binds: [B:50:0x01c9, B:48:0x01c6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:53:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:54:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:56:0x020f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0296  */
    /* JADX WARN: Code duplicated, block: B:65:0x029a  */
    /* JADX WARN: Code duplicated, block: B:68:0x02af  */
    /* JADX WARN: Code duplicated, block: B:70:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:75:0x0320  */
    /* JADX WARN: Code duplicated, block: B:79:0x035e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0364  */
    /* JADX WARN: Code duplicated, block: B:82:0x0394  */
    /* JADX WARN: Code duplicated, block: B:95:0x0448  */
    public final Pair<Boolean, Integer> connectInternal(int profileType) {
        boolean z;
        int iConnect;
        Logger logger;
        String tag;
        int depth;
        int i;
        boolean z2;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        Logger logger2;
        String str3;
        int i2;
        boolean z3;
        int i3;
        boolean z4;
        boolean z5;
        boolean z6;
        int iConnect2;
        Logger logger3;
        String str4;
        int i4;
        boolean z7;
        int i5;
        boolean z8;
        int i6;
        BluetoothDevice remoteDevice = getRemoteDevice();
        if (profileType == 0 || profileType == 2) {
            if (!XBTReceiverHelper.INSTANCE.get().getA2dpProfile().isConnected(remoteDevice)) {
                iConnect = XBTReceiverHelper.INSTANCE.get().getA2dpProfile().connect(remoteDevice);
                Logger logger4 = Logger.INSTANCE;
                String tag2 = logger4.getTAG();
                int depth2 = logger4.getDepth();
                if (logger4.isCanLogger(true)) {
                    String str5 = getConnectorType() + "  a2dpProfile not connected, try connecting,invoke:" + iConnect;
                    String str6 = str5;
                    if (str6 != null && str6.length() != 0) {
                        Pair<String, String> trace = logger4.getTrace(depth2);
                        String strComponent3 = trace.component1();
                        String strComponent4 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str7 = logger4.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        FileLog.print$default(fileLog, 3, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger4.isDebug()) {
                            Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                z = false;
            } else {
                Logger logger5 = Logger.INSTANCE;
                String tag3 = logger5.getTAG();
                int depth3 = logger5.getDepth();
                if (logger5.isCanLogger(true)) {
                    String str8 = getConnectorType() + " a2dpProfile isConnected!";
                    String str9 = str8;
                    if (str9 != null && str9.length() != 0) {
                        Pair<String, String> trace2 = logger5.getTrace(depth3);
                        String strComponent5 = trace2.component1();
                        String strComponent6 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str10 = logger5.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                        FileLog.print$default(fileLog2, 3, str10, tag3, str8 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger5.isDebug()) {
                            Log.i(tag3 + strComponent5, str8 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                z = true;
            }
            if (profileType != 0 || profileType == 1) {
                if (XBTReceiverHelper.INSTANCE.get().getHeadsetProfile().isConnected(remoteDevice)) {
                    if (iConnect != 0 || Build.VERSION.SDK_INT < 36) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (profileType == 0 || !z5) {
                        z6 = true;
                        if (profileType != 1) {
                            i = 0;
                        }
                        z2 = false;
                    } else {
                        z6 = true;
                    }
                    iConnect2 = XBTReceiverHelper.INSTANCE.get().getHeadsetProfile().connect(remoteDevice);
                    logger3 = Logger.INSTANCE;
                    String tag4 = logger3.getTAG();
                    int depth4 = logger3.getDepth();
                    if (logger3.isCanLogger(z6)) {
                        String str11 = getConnectorType() + " headsetProfile not connected, try connecting,invoke:" + iConnect2;
                        str4 = str11;
                        if (str4 != null || str4.length() == 0) {
                            i4 = iConnect2;
                        } else {
                            Pair<String, String> trace3 = logger3.getTrace(depth4);
                            String strComponent7 = trace3.component1();
                            String strComponent8 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str12 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                            i4 = iConnect2;
                            FileLog.print$default(fileLog3, 3, str12, tag4, str11 + StringUtils.SPACE + strComponent8, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.i(tag4 + strComponent7, str11 + StringUtils.SPACE + strComponent8);
                            }
                        }
                    } else {
                        i4 = iConnect2;
                    }
                    i = i4;
                    z2 = false;
                } else {
                    logger = Logger.INSTANCE;
                    tag = logger.getTAG();
                    depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        str = getConnectorType() + " headsetProfile isConnected!";
                        str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace4 = logger.getTrace(depth);
                            strComponent1 = trace4.component1();
                            strComponent2 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str13 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                            FileLog.print$default(fileLog4, 3, str13, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    i = 0;
                    z2 = true;
                }
                logger2 = Logger.INSTANCE;
                String tag5 = logger2.getTAG();
                int depth5 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str14 = getConnectorType() + " connectInternal status a2dp:" + z + " headset:" + z2 + "!";
                    str3 = str14;
                    if (str3 != null || str3.length() == 0) {
                        i2 = i;
                        z3 = z2;
                    } else {
                        Pair<String, String> trace5 = logger2.getTrace(depth5);
                        String strComponent9 = trace5.component1();
                        String strComponent10 = trace5.component2();
                        FileLog fileLog5 = FileLog.INSTANCE;
                        String str15 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                        i2 = i;
                        z3 = z2;
                        FileLog.print$default(fileLog5, 3, str15, tag5, str14 + StringUtils.SPACE + strComponent10, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag5 + strComponent9, str14 + StringUtils.SPACE + strComponent10);
                        }
                    }
                } else {
                    i2 = i;
                    z3 = z2;
                }
                i3 = i2;
                z4 = z3;
            } else {
                i3 = 0;
                z4 = false;
            }
            if (i3 <= 0 || iConnect > 0 || z4 || z) {
                z7 = true;
                i5 = 1;
            } else {
                boolean zIsDeviceConnected = XBTReceiverHelper.INSTANCE.get().isDeviceConnected(remoteDevice);
                Logger logger6 = Logger.INSTANCE;
                String tag6 = logger6.getTAG();
                int depth6 = logger6.getDepth();
                if (logger6.isCanLogger(true)) {
                    String str16 = getConnectorType() + " invoke failed. isBtConnect " + zIsDeviceConnected + ",headSetInvoke:" + i3 + ",a2dpInvoke:" + iConnect;
                    String str17 = str16;
                    if (str17 == null || str17.length() == 0) {
                        z7 = true;
                    } else {
                        Pair<String, String> trace6 = logger6.getTrace(depth6);
                        String strComponent11 = trace6.component1();
                        String strComponent12 = trace6.component2();
                        FileLog fileLog6 = FileLog.INSTANCE;
                        String str18 = logger6.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str18, "format(...)");
                        z7 = true;
                        FileLog.print$default(fileLog6, 3, str18, tag6, str16 + StringUtils.SPACE + strComponent12, null, 16, null);
                        if (logger6.isDebug()) {
                            Log.i(tag6 + strComponent11, str16 + StringUtils.SPACE + strComponent12);
                        }
                    }
                } else {
                    z7 = true;
                }
                i5 = 3;
            }
            if (!z || z4) {
                z8 = z7;
            } else {
                z8 = false;
            }
            if (iConnect != 3 || iConnect == 4 || i3 == 3 || i3 == 4) {
                i6 = 2;
            } else {
                i6 = i5;
            }
            return new Pair<>(Boolean.valueOf(z8), Integer.valueOf(i6));
        }
        z = false;
        iConnect = 0;
        if (profileType != 0) {
            if (XBTReceiverHelper.INSTANCE.get().getHeadsetProfile().isConnected(remoteDevice)) {
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str = getConnectorType() + " headsetProfile isConnected!";
                    str2 = str;
                    if (str2 != null) {
                        Pair<String, String> trace7 = logger.getTrace(depth);
                        strComponent1 = trace7.component1();
                        strComponent2 = trace7.component2();
                        FileLog fileLog7 = FileLog.INSTANCE;
                        String str19 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str19, "format(...)");
                        FileLog.print$default(fileLog7, 3, str19, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                i = 0;
                z2 = true;
            } else {
                if (iConnect != 0) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (profileType == 0) {
                    z6 = true;
                    if (profileType != 1) {
                        iConnect2 = XBTReceiverHelper.INSTANCE.get().getHeadsetProfile().connect(remoteDevice);
                        logger3 = Logger.INSTANCE;
                        String tag7 = logger3.getTAG();
                        int depth7 = logger3.getDepth();
                        if (logger3.isCanLogger(z6)) {
                            i4 = iConnect2;
                        } else {
                            String str110 = getConnectorType() + " headsetProfile not connected, try connecting,invoke:" + iConnect2;
                            str4 = str110;
                            if (str4 != null) {
                                i4 = iConnect2;
                            } else {
                                i4 = iConnect2;
                            }
                        }
                        i = i4;
                    } else {
                        i = 0;
                    }
                } else {
                    z6 = true;
                    if (profileType != 1) {
                        iConnect2 = XBTReceiverHelper.INSTANCE.get().getHeadsetProfile().connect(remoteDevice);
                        logger3 = Logger.INSTANCE;
                        String tag8 = logger3.getTAG();
                        int depth8 = logger3.getDepth();
                        if (logger3.isCanLogger(z6)) {
                            i4 = iConnect2;
                        } else {
                            String str111 = getConnectorType() + " headsetProfile not connected, try connecting,invoke:" + iConnect2;
                            str4 = str111;
                            if (str4 != null) {
                                i4 = iConnect2;
                            } else {
                                i4 = iConnect2;
                            }
                        }
                        i = i4;
                    } else {
                        i = 0;
                    }
                }
                z2 = false;
            }
            logger2 = Logger.INSTANCE;
            String tag9 = logger2.getTAG();
            int depth9 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                i2 = i;
                z3 = z2;
            } else {
                String str112 = getConnectorType() + " connectInternal status a2dp:" + z + " headset:" + z2 + "!";
                str3 = str112;
                if (str3 != null) {
                    i2 = i;
                    z3 = z2;
                } else {
                    i2 = i;
                    z3 = z2;
                }
            }
            i3 = i2;
            z4 = z3;
        } else {
            if (XBTReceiverHelper.INSTANCE.get().getHeadsetProfile().isConnected(remoteDevice)) {
                if (iConnect != 0) {
                    z5 = true;
                } else {
                    z5 = true;
                }
                if (profileType == 0) {
                    z6 = true;
                    if (profileType != 1) {
                        iConnect2 = XBTReceiverHelper.INSTANCE.get().getHeadsetProfile().connect(remoteDevice);
                        logger3 = Logger.INSTANCE;
                        String tag10 = logger3.getTAG();
                        int depth10 = logger3.getDepth();
                        if (logger3.isCanLogger(z6)) {
                            i4 = iConnect2;
                        } else {
                            String str113 = getConnectorType() + " headsetProfile not connected, try connecting,invoke:" + iConnect2;
                            str4 = str113;
                            if (str4 != null) {
                                i4 = iConnect2;
                            } else {
                                i4 = iConnect2;
                            }
                        }
                        i = i4;
                    } else {
                        i = 0;
                    }
                } else {
                    z6 = true;
                    if (profileType != 1) {
                        iConnect2 = XBTReceiverHelper.INSTANCE.get().getHeadsetProfile().connect(remoteDevice);
                        logger3 = Logger.INSTANCE;
                        String tag11 = logger3.getTAG();
                        int depth11 = logger3.getDepth();
                        if (logger3.isCanLogger(z6)) {
                            i4 = iConnect2;
                        } else {
                            String str114 = getConnectorType() + " headsetProfile not connected, try connecting,invoke:" + iConnect2;
                            str4 = str114;
                            if (str4 != null) {
                                i4 = iConnect2;
                            } else {
                                i4 = iConnect2;
                            }
                        }
                        i = i4;
                    } else {
                        i = 0;
                    }
                }
                z2 = false;
            } else {
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str = getConnectorType() + " headsetProfile isConnected!";
                    str2 = str;
                    if (str2 != null) {
                        Pair<String, String> trace8 = logger.getTrace(depth);
                        strComponent1 = trace8.component1();
                        strComponent2 = trace8.component2();
                        FileLog fileLog8 = FileLog.INSTANCE;
                        String str115 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str115, "format(...)");
                        FileLog.print$default(fileLog8, 3, str115, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                i = 0;
                z2 = true;
            }
            logger2 = Logger.INSTANCE;
            String tag12 = logger2.getTAG();
            int depth12 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                i2 = i;
                z3 = z2;
            } else {
                String str116 = getConnectorType() + " connectInternal status a2dp:" + z + " headset:" + z2 + "!";
                str3 = str116;
                if (str3 != null) {
                    i2 = i;
                    z3 = z2;
                } else {
                    i2 = i;
                    z3 = z2;
                }
            }
            i3 = i2;
            z4 = z3;
        }
        if (i3 <= 0) {
            z7 = true;
            i5 = 1;
        } else {
            z7 = true;
            i5 = 1;
        }
        if (z) {
            z8 = z7;
        } else {
            z8 = z7;
        }
        if (iConnect != 3) {
            i6 = 2;
        } else {
            i6 = 2;
        }
        return new Pair<>(Boolean.valueOf(z8), Integer.valueOf(i6));
    }
}
