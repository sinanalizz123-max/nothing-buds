package com.nothing.link.bluetooth.sdk.connect;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.nothing.elekid.guide.GuideActivity;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.scan.XBluetoothFlowCallBack;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.os.device.DeviceConstant;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBondConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0017\b&\u0018\u0000 z2\u00020\u0001:\u0001zB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u0004H\u0017J\b\u0010G\u001a\u00020CH\u0016J\u0010\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u000204H\u0002J\u0010\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020LH&J\b\u0010M\u001a\u00020CH&J\b\u0010N\u001a\u00020CH&J\u0010\u0010O\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010(J\u001a\u0010P\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010E2\b\b\u0002\u0010Q\u001a\u00020\u001cJ\u0012\u0010R\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010EH\u0002J\u0018\u0010S\u001a\u00020C2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020LH&J\u0012\u0010W\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u001c\u0010X\u001a\u00020C2\b\b\u0002\u0010Y\u001a\u00020\u00042\b\u0010Z\u001a\u0004\u0018\u00010(H&J%\u0010[\u001a\u00020\u00042\b\u0010Z\u001a\u0004\u0018\u00010(2\b\b\u0002\u0010P\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\\J\u0012\u0010]\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010^\u001a\u00020_H\u0016J\u0018\u0010`\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010a\u001a\u000204H\u0007J\b\u0010b\u001a\u000204H\u0016J\b\u0010c\u001a\u00020dH&J\b\u0010e\u001a\u00020LH\u0016J\b\u0010f\u001a\u0004\u0018\u00010EJ\u0010\u0010g\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0016H\u0016J\b\u0010h\u001a\u00020\u0004H\u0016J\b\u0010i\u001a\u00020\u0004H\u0002J\u0012\u0010j\u001a\u00020\u00042\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\"\u0010k\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0004H\u0016J*\u0010n\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010o\u001a\u0002042\u0006\u0010p\u001a\u0002042\u0006\u0010V\u001a\u000204H\u0016J\u0010\u0010q\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016J\u0010\u0010q\u001a\u00020C2\u0006\u0010D\u001a\u00020\u0016H\u0016J\u0010\u0010q\u001a\u00020C2\u0006\u0010r\u001a\u00020LH\u0016J\b\u0010s\u001a\u00020CH\u0016J\"\u0010t\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0004H\u0016J\b\u0010u\u001a\u00020\u001cH\u0002J\b\u0010v\u001a\u000204H\u0002J\u000e\u0010w\u001a\u00020C2\u0006\u0010a\u001a\u000204J\b\u0010x\u001a\u00020CH&J \u0010y\u001a\u00020C2\u0006\u0010Y\u001a\u00020\u00042\u0006\u0010D\u001a\u00020E2\b\b\u0002\u0010Q\u001a\u00020\u001cR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u00109\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u00106\"\u0004\b;\u00108R\u001a\u0010<\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u00106\"\u0004\b>\u00108R\u001a\u0010?\u001a\u000204X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00106\"\u0004\bA\u00108\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006{"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XBondConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/XBluetoothDeviceStateChange;", "()V", "allowCreateBond", "", "getAllowCreateBond", "()Z", "setAllowCreateBond", "(Z)V", "boundJob", "Lkotlinx/coroutines/Job;", "getBoundJob", "()Lkotlinx/coroutines/Job;", "setBoundJob", "(Lkotlinx/coroutines/Job;)V", "mBTHelper", "Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTReceiverHelper;", "getMBTHelper", "()Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTReceiverHelper;", "setMBTHelper", "(Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTReceiverHelper;)V", "mBleDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "getMBleDevice", "()Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "setMBleDevice", "(Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;)V", "mBoundMillisTimeOut", "", "getMBoundMillisTimeOut", "()J", "setMBoundMillisTimeOut", "(J)V", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mXBluetoothFlowCallBack", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "getMXBluetoothFlowCallBack", "()Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "setMXBluetoothFlowCallBack", "(Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;)V", "mXBluetoothManager", "Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;", "getMXBluetoothManager", "()Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;", "setMXBluetoothManager", "(Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;)V", "profileType", "", "getProfileType", "()I", "setProfileType", "(I)V", "retryBondCount", "getRetryBondCount", "setRetryBondCount", "retryMaxBondCount", "getRetryMaxBondCount", "setRetryMaxBondCount", "unknownTransport", "getUnknownTransport", "setUnknownTransport", "aclStateChanged", "", "device", "Landroid/bluetooth/BluetoothDevice;", "connected", "addDeviceSateChange", "bondRetryBackoffMs", "retryAttempt", "boundCancel", "code", "", "boundSuccess", "boundTimeOut", "checkBluetoothEnable", "checkBound", "delay", "checkDevice", "checkFail", "failType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "reason", "checkGps", "checkParameterAndStartConnectJob", "isRetry", "flowCallBack", "checkParameters", "(Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPermission", "connectScope", "Lkotlinx/coroutines/CoroutineScope;", "createBond", NotificationCompat.CATEGORY_TRANSPORT, "getConnectTotalStep", "getConnectorType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "getMacAddress", "getRemoteDevice", "initParams", "isNeedBound", "isNeedGpsOpen", "matchDeviceEvent", "onA2DPChange", "a2dpConnect", "headsetConnect", "onBondStatusChange", NotificationCompat.CATEGORY_STATUS, "preStatus", "onCreate", "address", "onDestroy", "onHeadSetChange", "pageTimeoutCooldownMs", "resolveBondRetryMaxCount", "setUnknownBoundTransport", "startBound", "tryBoundDevice", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XBondConnector implements XBluetoothDeviceStateChange {
    public static final int BOND_REASON_PAGE_TIMEOUT = 4;
    public static final String TAG = "TAG";
    private Job boundJob;
    private XBluetoothDevice mBleDevice;
    private long mBoundMillisTimeOut;
    private Context mContext;
    private XBluetoothFlowCallBack mXBluetoothFlowCallBack;
    private int profileType;
    private int retryBondCount;
    private int unknownTransport;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ConcurrentHashMap<String, Long> bondPageTimeoutCooldownUntil = new ConcurrentHashMap<>();
    private XBluetoothManager mXBluetoothManager = XBluetoothManager.INSTANCE.get();
    private XBTReceiverHelper mBTHelper = XBTReceiverHelper.INSTANCE.get();
    private int retryMaxBondCount = this.mXBluetoothManager.getBluetoothConfig().getBondRetryMaxCount();
    private boolean allowCreateBond = true;

    public abstract void boundCancel(String code);

    public abstract void boundSuccess();

    public abstract void boundTimeOut();

    public abstract void checkFail(XConnectFailType failType, String reason);

    public abstract void checkParameterAndStartConnectJob(boolean isRetry, XBluetoothFlowCallBack flowCallBack);

    public Object checkParameters(XBluetoothFlowCallBack xBluetoothFlowCallBack, boolean z, Continuation<? super Boolean> continuation) {
        return checkParameters$suspendImpl(this, xBluetoothFlowCallBack, z, continuation);
    }

    public int getConnectTotalStep() {
        return 1;
    }

    public abstract XConnectType getConnectorType();

    public boolean isNeedBound() {
        return true;
    }

    public abstract void startBound();

    /* JADX INFO: compiled from: XBondConnector.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u000f\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XBondConnector$Companion;", "", "()V", "BOND_REASON_PAGE_TIMEOUT", "", "TAG", "", "bondPageTimeoutCooldownUntil", "Ljava/util/concurrent/ConcurrentHashMap;", "", "clearBondPageTimeoutCooldown", "", "address", "isBondPageTimeoutCooldown", "", "markBondPageTimeoutCooldown", "cooldownMs", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isBondPageTimeoutCooldown(String address) {
            Long l;
            String str = address;
            if (str == null || str.length() == 0 || (l = (Long) XBondConnector.bondPageTimeoutCooldownUntil.get(address)) == null) {
                return false;
            }
            if (System.currentTimeMillis() < l.longValue()) {
                return true;
            }
            XBondConnector.bondPageTimeoutCooldownUntil.remove(address);
            return false;
        }

        public final void markBondPageTimeoutCooldown(String address, long cooldownMs) {
            String str = address;
            if (str == null || str.length() == 0 || cooldownMs <= 0) {
                return;
            }
            XBondConnector.bondPageTimeoutCooldownUntil.put(address, Long.valueOf(System.currentTimeMillis() + cooldownMs));
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "markBondPageTimeoutCooldown " + address + " for " + cooldownMs + "ms";
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    return;
                }
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 5, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.w(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        }

        public final void clearBondPageTimeoutCooldown(String address) {
            String str = address;
            if (str == null || str.length() == 0) {
                return;
            }
            XBondConnector.bondPageTimeoutCooldownUntil.remove(address);
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void actionEncryptionChange(BluetoothDevice bluetoothDevice, boolean z) {
        XBluetoothDeviceStateChange.DefaultImpls.actionEncryptionChange(this, bluetoothDevice, z);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void keyMissingChanged(BluetoothDevice bluetoothDevice, boolean z) {
        XBluetoothDeviceStateChange.DefaultImpls.keyMissingChanged(this, bluetoothDevice, z);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onBluetoothChange(int i) {
        XBluetoothDeviceStateChange.DefaultImpls.onBluetoothChange(this, i);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onLeAudioChange(BluetoothDevice bluetoothDevice, boolean z, boolean z2, boolean z3) {
        XBluetoothDeviceStateChange.DefaultImpls.onLeAudioChange(this, bluetoothDevice, z, z2, z3);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void profileConnectedChanged(int i, boolean z) {
        XBluetoothDeviceStateChange.DefaultImpls.profileConnectedChanged(this, i, z);
    }

    public final Context getMContext() {
        return this.mContext;
    }

    public final void setMContext(Context context) {
        this.mContext = context;
    }

    public final XBluetoothManager getMXBluetoothManager() {
        return this.mXBluetoothManager;
    }

    public final void setMXBluetoothManager(XBluetoothManager xBluetoothManager) {
        Intrinsics.checkNotNullParameter(xBluetoothManager, "<set-?>");
        this.mXBluetoothManager = xBluetoothManager;
    }

    public final XBTReceiverHelper getMBTHelper() {
        return this.mBTHelper;
    }

    public final void setMBTHelper(XBTReceiverHelper xBTReceiverHelper) {
        Intrinsics.checkNotNullParameter(xBTReceiverHelper, "<set-?>");
        this.mBTHelper = xBTReceiverHelper;
    }

    public final XBluetoothDevice getMBleDevice() {
        return this.mBleDevice;
    }

    public final void setMBleDevice(XBluetoothDevice xBluetoothDevice) {
        this.mBleDevice = xBluetoothDevice;
    }

    public final long getMBoundMillisTimeOut() {
        return this.mBoundMillisTimeOut;
    }

    public final void setMBoundMillisTimeOut(long j) {
        this.mBoundMillisTimeOut = j;
    }

    public final Job getBoundJob() {
        return this.boundJob;
    }

    public final void setBoundJob(Job job) {
        this.boundJob = job;
    }

    public final int getRetryBondCount() {
        return this.retryBondCount;
    }

    public final void setRetryBondCount(int i) {
        this.retryBondCount = i;
    }

    public final int getRetryMaxBondCount() {
        return this.retryMaxBondCount;
    }

    public final void setRetryMaxBondCount(int i) {
        this.retryMaxBondCount = i;
    }

    public final boolean getAllowCreateBond() {
        return this.allowCreateBond;
    }

    public final void setAllowCreateBond(boolean z) {
        this.allowCreateBond = z;
    }

    public final XBluetoothFlowCallBack getMXBluetoothFlowCallBack() {
        return this.mXBluetoothFlowCallBack;
    }

    public final void setMXBluetoothFlowCallBack(XBluetoothFlowCallBack xBluetoothFlowCallBack) {
        this.mXBluetoothFlowCallBack = xBluetoothFlowCallBack;
    }

    public final int getUnknownTransport() {
        return this.unknownTransport;
    }

    public final void setUnknownTransport(int i) {
        this.unknownTransport = i;
    }

    public final void setUnknownBoundTransport(int transport) {
        this.unknownTransport = transport;
    }

    public final int getProfileType() {
        return this.profileType;
    }

    public final void setProfileType(int i) {
        this.profileType = i;
    }

    public void onCreate(XBluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        initParams(device);
    }

    public void onCreate(BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        onCreate(new XBluetoothDevice(device, BleUtil.INSTANCE.getDeviceName(device), device.getAddress(), device.getAddress(), null, null, null, null, null, null, null));
    }

    public void onCreate(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        BluetoothAdapter bluetoothAdapter = this.mXBluetoothManager.getBluetoothAdapter();
        BluetoothDevice remoteDevice = bluetoothAdapter != null ? bluetoothAdapter.getRemoteDevice(address) : null;
        if (remoteDevice != null) {
            onCreate(remoteDevice);
            return;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onCreate address :" + address + " device failed! ";
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
            FileLog.print$default(fileLog, 6, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            }
        }
    }

    public void initParams(XBluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.mBleDevice = device;
        if (this.mContext == null) {
            this.mContext = this.mXBluetoothManager.getContext();
        }
    }

    public void addDeviceSateChange() {
        this.mBTHelper.addDeviceSateChange(this);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public String getMacAddress() {
        String realAddress;
        XBluetoothDevice xBluetoothDevice = this.mBleDevice;
        return (xBluetoothDevice == null || (realAddress = xBluetoothDevice.getRealAddress()) == null) ? "" : realAddress;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public boolean matchDeviceEvent(BluetoothDevice device) {
        BluetoothDevice deviceInfo;
        String address = null;
        String address2 = device != null ? device.getAddress() : null;
        if (address2 == null) {
            return false;
        }
        XBluetoothDevice xBluetoothDevice = this.mBleDevice;
        if (Intrinsics.areEqual(address2, xBluetoothDevice != null ? xBluetoothDevice.getRealAddress() : null)) {
            return true;
        }
        XBluetoothDevice xBluetoothDevice2 = this.mBleDevice;
        if (Intrinsics.areEqual(address2, xBluetoothDevice2 != null ? xBluetoothDevice2.getDeviceAddress() : null)) {
            return true;
        }
        XBluetoothDevice xBluetoothDevice3 = this.mBleDevice;
        if (xBluetoothDevice3 != null && (deviceInfo = xBluetoothDevice3.getDeviceInfo()) != null) {
            address = deviceInfo.getAddress();
        }
        return Intrinsics.areEqual(address2, address) || Intrinsics.areEqual(getMacAddress(), XBluetoothDeviceStateChange.INSTANCE.getIGNORE_ADDRESS());
    }

    public void onDestroy() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getConnectorType() + " onDestroy";
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
        this.mBTHelper.removeDeviceStateChange(this);
        this.mXBluetoothFlowCallBack = null;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onBondStatusChange(BluetoothDevice device, int status, int preStatus, int reason) {
        if (status == 12) {
            CompleteException completeException = new CompleteException("bound successful");
            Job job = this.boundJob;
            if (job != null) {
                job.cancel((CancellationException) completeException);
                return;
            }
            return;
        }
        if (status == 10 && preStatus == 11) {
            if (reason == 1) {
                this.retryBondCount = this.retryMaxBondCount;
                Job job2 = this.boundJob;
                if (job2 != null) {
                    job2.cancel((CancellationException) new CancelException("bound cancel,reason: " + reason));
                    return;
                }
                return;
            }
            if (reason == 4) {
                Job job3 = this.boundJob;
                if (job3 != null) {
                    job3.cancel((CancellationException) new RetryException("bound failed reason is " + reason + ",will retry"));
                    return;
                }
                return;
            }
            this.retryBondCount = this.retryMaxBondCount;
            Job job4 = this.boundJob;
            if (job4 != null) {
                job4.cancel((CancellationException) new UserCancelException("bound reason is " + reason + ",will retry", reason));
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void aclStateChanged(BluetoothDevice device, boolean connected) {
        XBluetoothDeviceStateChange.DefaultImpls.aclStateChanged(this, device, connected);
        Job job = this.boundJob;
        if (job == null || !job.isActive() || connected) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(device, this, connected, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XBondConnector$aclStateChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: XBondConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XBondConnector$aclStateChanged$1", f = "XBondConnector.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $connected;
        final /* synthetic */ BluetoothDevice $device;
        int label;
        final /* synthetic */ XBondConnector this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BluetoothDevice bluetoothDevice, XBondConnector xBondConnector, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$device = bluetoothDevice;
            this.this$0 = xBondConnector;
            this.$connected = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$device, this.this$0, this.$connected, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(5000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            boolean z = this.$device != null && BleUtil.INSTANCE.checkBluetoothPermissions();
            Job boundJob = this.this$0.getBoundJob();
            if (boundJob != null && boundJob.isActive() && z) {
                BluetoothDevice bluetoothDevice = this.$device;
                if (bluetoothDevice != null && bluetoothDevice.getBondState() == 12) {
                    CompleteException completeException = new CompleteException("bound successful delay");
                    Job boundJob2 = this.this$0.getBoundJob();
                    if (boundJob2 != null) {
                        boundJob2.cancel((CancellationException) completeException);
                    }
                } else {
                    BluetoothDevice bluetoothDevice2 = this.$device;
                    if (bluetoothDevice2 != null && bluetoothDevice2.getBondState() == 10) {
                        Job boundJob3 = this.this$0.getBoundJob();
                        if (boundJob3 != null) {
                            boundJob3.cancel((CancellationException) new CancelException("bound cancel,aclStateChanged: " + this.$connected));
                        }
                    } else {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true) && "acl disconnect ,but current is bonding".length() != 0) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            FileLog.print$default(fileLog, 3, str, tag, "acl disconnect ,but current is bonding " + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, "acl disconnect ,but current is bonding " + strComponent2);
                            }
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onA2DPChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        Job job;
        Job job2;
        int i = this.profileType;
        if (i == 0 || i == 2) {
            if ((a2dpConnect || headsetConnect) && (job = this.boundJob) != null && job.isActive() && (job2 = this.boundJob) != null) {
                job2.cancel((CancellationException) new ReleaseException("onA2DPChange a2dpConnect:" + a2dpConnect + " headsetConnect:" + headsetConnect));
            }
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onHeadSetChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        Job job;
        Job job2;
        int i = this.profileType;
        if ((i == 0 || i == 1) && (job = this.boundJob) != null && job.isActive() && (job2 = this.boundJob) != null) {
            job2.cancel((CancellationException) new ReleaseException("onHeadSetChange a2dpConnect:" + a2dpConnect + " headsetConnect:" + headsetConnect));
        }
    }

    public static /* synthetic */ Object checkParameters$default(XBondConnector xBondConnector, XBluetoothFlowCallBack xBluetoothFlowCallBack, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkParameters");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return xBondConnector.checkParameters(xBluetoothFlowCallBack, z, continuation);
    }

    static /* synthetic */ Object checkParameters$suspendImpl(XBondConnector xBondConnector, XBluetoothFlowCallBack xBluetoothFlowCallBack, boolean z, Continuation<? super Boolean> continuation) {
        BluetoothDevice remoteDevice = xBondConnector.getRemoteDevice();
        BluetoothAdapter bluetoothAdapter = xBondConnector.mXBluetoothManager.getBluetoothAdapter();
        BluetoothDevice remoteDevice2 = null;
        if (bluetoothAdapter != null) {
            XBluetoothDevice xBluetoothDevice = xBondConnector.mBleDevice;
            remoteDevice2 = bluetoothAdapter.getRemoteDevice(xBluetoothDevice != null ? xBluetoothDevice.getRealAddress() : null);
        }
        BluetoothDevice bluetoothDevice = remoteDevice2;
        if (xBondConnector.checkDevice(remoteDevice) || xBondConnector.checkPermission(xBluetoothFlowCallBack) || xBondConnector.checkBluetoothEnable(xBluetoothFlowCallBack) || xBondConnector.checkGps(xBluetoothFlowCallBack) || (z && checkBound$default(xBondConnector, bluetoothDevice, 0L, 2, null))) {
            return Boxing.boxBoolean(false);
        }
        return Boxing.boxBoolean(true);
    }

    private final boolean checkDevice(BluetoothDevice device) {
        if (this.mBleDevice != null && device != null && this.mXBluetoothManager.getBluetoothAdapter() != null) {
            return false;
        }
        checkFail(XConnectFailType.NullableBluetoothDevice.INSTANCE, "mBleDevice or device or bluetoothAdapter is null ,cancel connect!");
        return true;
    }

    public final BluetoothDevice getRemoteDevice() {
        BluetoothAdapter bluetoothAdapter = XBluetoothManager.INSTANCE.get().getBluetoothAdapter();
        if (bluetoothAdapter == null) {
            return null;
        }
        XBluetoothDevice xBluetoothDevice = this.mBleDevice;
        return bluetoothAdapter.getRemoteDevice(xBluetoothDevice != null ? xBluetoothDevice.getRealAddress() : null);
    }

    public static /* synthetic */ boolean checkBound$default(XBondConnector xBondConnector, BluetoothDevice bluetoothDevice, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkBound");
        }
        if ((i & 2) != 0) {
            j = 500;
        }
        return xBondConnector.checkBound(bluetoothDevice, j);
    }

    public final boolean checkBound(BluetoothDevice device, long delay) {
        if (!isNeedBound() || device == null || !BleUtil.INSTANCE.checkBluetoothPermissions() || device.getBondState() == 12) {
            return false;
        }
        if (!this.allowCreateBond) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "checkBound skip createBond, allowCreateBond=false device=" + device.getAddress();
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
            checkFail(XConnectFailType.UnBound.INSTANCE, "createBond not allowed");
            return true;
        }
        tryBoundDevice(false, device, delay);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int resolveBondRetryMaxCount() {
        int i = this.retryMaxBondCount;
        return i > 0 ? i : this.mXBluetoothManager.getBluetoothConfig().getBondRetryMaxCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long bondRetryBackoffMs(int retryAttempt) {
        long[] bondRetryBackoffMs = this.mXBluetoothManager.getBluetoothConfig().getBondRetryBackoffMs();
        if (bondRetryBackoffMs.length == 0) {
            return 5000L;
        }
        return bondRetryBackoffMs[RangesKt.coerceIn(retryAttempt - 1, 0, ArraysKt.getLastIndex(bondRetryBackoffMs))];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long pageTimeoutCooldownMs() {
        return this.mXBluetoothManager.getBluetoothConfig().getBondPageTimeoutCooldownMs();
    }

    private final boolean checkPermission(final XBluetoothFlowCallBack mXBluetoothFlowCallBack) {
        if (BleUtil.INSTANCE.isPermission(this.mContext)) {
            return false;
        }
        if (mXBluetoothFlowCallBack != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "need request permission!".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "need request permission! " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "need request permission! " + strComponent2);
                }
            }
            mXBluetoothFlowCallBack.callRequestPermission(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.XBondConnector.checkPermission.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        Logger logger2 = Logger.INSTANCE;
                        String tag2 = logger2.getTAG();
                        int depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true) && "request permission successful!".length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str2 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                            FileLog.print$default(fileLog2, 3, str2, tag2, "request permission successful! " + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, "request permission successful! " + strComponent4);
                            }
                        }
                        XBondConnector.checkParameterAndStartConnectJob$default(XBondConnector.this, false, mXBluetoothFlowCallBack, 1, null);
                        return;
                    }
                    XBondConnector.this.checkFail(XConnectFailType.NoBluetoothPermission.INSTANCE, "Request permission failed!");
                }
            });
        } else {
            checkFail(XConnectFailType.NoBluetoothPermission.INSTANCE, "Request permission failed,No Handler FlowCallBack");
        }
        return true;
    }

    public final boolean checkBluetoothEnable(final XBluetoothFlowCallBack mXBluetoothFlowCallBack) {
        if (!this.mXBluetoothManager.bluetoothUnEnable()) {
            return false;
        }
        if (mXBluetoothFlowCallBack != null) {
            mXBluetoothFlowCallBack.callRequestBluetoothOpen(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.XBondConnector.checkBluetoothEnable.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        Logger logger = Logger.INSTANCE;
                        XBondConnector xBondConnector = XBondConnector.this;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = xBondConnector.getConnectorType() + " request bluetooth switch successful!";
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
                        XBondConnector.checkParameterAndStartConnectJob$default(XBondConnector.this, false, mXBluetoothFlowCallBack, 1, null);
                        return;
                    }
                    XBondConnector.this.checkFail(XConnectFailType.BluetoothUnable.INSTANCE, "Bluetooth is unavailable!");
                }
            });
            return true;
        }
        checkFail(XConnectFailType.BluetoothUnable.INSTANCE, "Bluetooth is unavailable!No Handler FlowCallBack");
        return true;
    }

    private final boolean checkGps(final XBluetoothFlowCallBack mXBluetoothFlowCallBack) {
        if (!isNeedGpsOpen()) {
            return false;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getConnectorType() + " gps is not open ,please open it or put current device to scan white list!";
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
        if (mXBluetoothFlowCallBack != null) {
            mXBluetoothFlowCallBack.callRequestGps(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.XBondConnector.checkGps.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z) {
                    if (z) {
                        Logger logger2 = Logger.INSTANCE;
                        XBondConnector xBondConnector = XBondConnector.this;
                        String tag2 = logger2.getTAG();
                        int depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true)) {
                            String str4 = xBondConnector.getConnectorType() + " request gps is successful!";
                            String str5 = str4;
                            if (str5 != null && str5.length() != 0) {
                                Pair<String, String> trace2 = logger2.getTrace(depth2);
                                String strComponent3 = trace2.component1();
                                String strComponent4 = trace2.component2();
                                FileLog fileLog2 = FileLog.INSTANCE;
                                String str6 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                FileLog.print$default(fileLog2, 5, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.w(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                                }
                            }
                        }
                        XBondConnector.checkParameterAndStartConnectJob$default(XBondConnector.this, false, mXBluetoothFlowCallBack, 1, null);
                        return;
                    }
                    XBondConnector.this.checkFail(XConnectFailType.GPSDisable.INSTANCE, "GPS is unavailable!");
                }
            });
        } else {
            checkFail(XConnectFailType.GPSDisable.INSTANCE, "GPS is unavailable!,No Handler FlowCallBack");
        }
        return true;
    }

    public final void createBond(BluetoothDevice device, int transport) {
        Object objInvoke;
        Intrinsics.checkNotNullParameter(device, "device");
        try {
            if (transport == 0) {
                objInvoke = Boolean.valueOf(device.createBond());
            } else {
                Method method = BluetoothDevice.class.getMethod("createBond", Integer.TYPE);
                method.setAccessible(true);
                objInvoke = method.invoke(device, Integer.valueOf(transport));
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "createBond " + device + " ,transport " + transport + ",type:" + device.getType() + " , result:" + objInvoke;
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
        } catch (Exception e) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "createBond " + device + " ,error " + e.getMessage();
                String str5 = str4;
                if (str5 == null || str5.length() == 0) {
                    return;
                }
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                }
            }
        }
    }

    public static /* synthetic */ void tryBoundDevice$default(XBondConnector xBondConnector, boolean z, BluetoothDevice bluetoothDevice, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryBoundDevice");
        }
        if ((i & 4) != 0) {
            j = 500;
        }
        xBondConnector.tryBoundDevice(z, bluetoothDevice, j);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0022  */
    public final void tryBoundDevice(boolean isRetry, final BluetoothDevice device, long delay) {
        String str;
        Intrinsics.checkNotNullParameter(device, "device");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "tryBoundDevice " + device + " ,isRetry:" + isRetry + ",retryBondCount:" + this.retryBondCount;
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                str = StringUtils.SPACE;
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                String str5 = str2 + StringUtils.SPACE + strComponent2;
                str = StringUtils.SPACE;
                FileLog.print$default(fileLog, 3, str4, tag, str5, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + str + strComponent2);
                }
            }
        } else {
            str = StringUtils.SPACE;
        }
        if (!isRetry) {
            this.retryBondCount = 0;
            if (INSTANCE.isBondPageTimeoutCooldown(device.getAddress())) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str6 = "tryBoundDevice skip createBond, PAGE_TIMEOUT cooldown active: " + device.getAddress();
                    String str7 = str6;
                    if (str7 != null && str7.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str8 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                        FileLog.print$default(fileLog2, 5, str8, tag2, str6 + str + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.w(tag2 + strComponent3, str6 + str + strComponent4);
                        }
                    }
                }
                boundCancel(DeviceConstant.NOISE_CANCELLATION_ADAPTIVE);
                return;
            }
        }
        startBound();
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass3(this.mBoundMillisTimeOut + RangesKt.coerceAtLeast(delay, 0L), delay, this, device, null), 3, null);
        this.boundJob = jobLaunch$default;
        if (jobLaunch$default != null) {
            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.XBondConnector.tryBoundDevice.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    String message;
                    if (th instanceof CompleteException) {
                        XBondConnector.INSTANCE.clearBondPageTimeoutCooldown(device.getAddress());
                        Companion companion = XBondConnector.INSTANCE;
                        XBluetoothDevice mBleDevice = this.getMBleDevice();
                        companion.clearBondPageTimeoutCooldown(mBleDevice != null ? mBleDevice.getRealAddress() : null);
                        this.boundSuccess();
                        return;
                    }
                    if (th instanceof TimeoutCancellationException) {
                        this.boundTimeOut();
                        return;
                    }
                    if (th instanceof ReleaseException) {
                        Logger logger3 = Logger.INSTANCE;
                        String tag3 = logger3.getTAG();
                        int depth3 = logger3.getDepth();
                        if (logger3.isCanLogger(true)) {
                            String str9 = "ReleaseException! " + ((ReleaseException) th).getMessage();
                            String str10 = str9;
                            if (str10 == null || str10.length() == 0) {
                                return;
                            }
                            Pair<String, String> trace3 = logger3.getTrace(depth3);
                            String strComponent5 = trace3.component1();
                            String strComponent6 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str11 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                            FileLog.print$default(fileLog3, 3, str11, tag3, str9 + StringUtils.SPACE + strComponent6, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.i(tag3 + strComponent5, str9 + StringUtils.SPACE + strComponent6);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (th instanceof RetryException) {
                        int iResolveBondRetryMaxCount = this.resolveBondRetryMaxCount();
                        if (this.getRetryBondCount() >= iResolveBondRetryMaxCount) {
                            XBondConnector.INSTANCE.markBondPageTimeoutCooldown(device.getAddress(), this.pageTimeoutCooldownMs());
                            Companion companion2 = XBondConnector.INSTANCE;
                            XBluetoothDevice mBleDevice2 = this.getMBleDevice();
                            companion2.markBondPageTimeoutCooldown(mBleDevice2 != null ? mBleDevice2.getRealAddress() : null, this.pageTimeoutCooldownMs());
                            Logger logger4 = Logger.INSTANCE;
                            XBondConnector xBondConnector = this;
                            String tag4 = logger4.getTAG();
                            int depth4 = logger4.getDepth();
                            if (logger4.isCanLogger(true)) {
                                String str12 = "RetryException! exhausted " + xBondConnector.getRetryBondCount() + "/" + iResolveBondRetryMaxCount;
                                String str13 = str12;
                                if (str13 != null && str13.length() != 0) {
                                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                                    String strComponent7 = trace4.component1();
                                    String strComponent8 = trace4.component2();
                                    FileLog fileLog4 = FileLog.INSTANCE;
                                    String str14 = logger4.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                                    FileLog.print$default(fileLog4, 5, str14, tag4, str12 + StringUtils.SPACE + strComponent8, null, 16, null);
                                    if (logger4.isDebug()) {
                                        Log.w(tag4 + strComponent7, str12 + StringUtils.SPACE + strComponent8);
                                    }
                                }
                            }
                            this.boundCancel(DeviceConstant.NOISE_CANCELLATION_ADAPTIVE);
                            return;
                        }
                        XBondConnector xBondConnector2 = this;
                        xBondConnector2.setRetryBondCount(xBondConnector2.getRetryBondCount() + 1);
                        XBondConnector xBondConnector3 = this;
                        long jBondRetryBackoffMs = xBondConnector3.bondRetryBackoffMs(xBondConnector3.getRetryBondCount());
                        Logger logger5 = Logger.INSTANCE;
                        XBondConnector xBondConnector4 = this;
                        String tag5 = logger5.getTAG();
                        int depth5 = logger5.getDepth();
                        if (logger5.isCanLogger(true)) {
                            String str15 = "RetryException! " + xBondConnector4.getRetryBondCount() + "/" + iResolveBondRetryMaxCount + ", backoff=" + jBondRetryBackoffMs + "ms";
                            String str16 = str15;
                            if (str16 != null && str16.length() != 0) {
                                Pair<String, String> trace5 = logger5.getTrace(depth5);
                                String strComponent9 = trace5.component1();
                                String strComponent10 = trace5.component2();
                                FileLog fileLog5 = FileLog.INSTANCE;
                                String str17 = logger5.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str17, "format(...)");
                                FileLog.print$default(fileLog5, 5, str17, tag5, str15 + StringUtils.SPACE + strComponent10, null, 16, null);
                                if (logger5.isDebug()) {
                                    Log.w(tag5 + strComponent9, str15 + StringUtils.SPACE + strComponent10);
                                }
                            }
                        }
                        this.tryBoundDevice(true, device, jBondRetryBackoffMs);
                        return;
                    }
                    if (th instanceof UserCancelException) {
                        this.boundCancel(String.valueOf(((UserCancelException) th).getCode()));
                        return;
                    }
                    XBondConnector xBondConnector5 = this;
                    if (th == null || (message = th.getMessage()) == null) {
                        message = "";
                    }
                    xBondConnector5.boundCancel(message);
                    Logger logger6 = Logger.INSTANCE;
                    String tag6 = logger6.getTAG();
                    int depth6 = logger6.getDepth();
                    if (logger6.isCanLogger(true) && "boundJob cancel! ".length() != 0) {
                        Pair<String, String> trace6 = logger6.getTrace(depth6);
                        String strComponent11 = trace6.component1();
                        String strComponent12 = trace6.component2();
                        FileLog fileLog6 = FileLog.INSTANCE;
                        String str18 = logger6.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str18, "format(...)");
                        FileLog.print$default(fileLog6, 5, str18, tag6, "boundJob cancel!  " + strComponent12, null, 16, null);
                        if (logger6.isDebug()) {
                            Log.w(tag6 + strComponent11, "boundJob cancel!  " + strComponent12);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XBondConnector$tryBoundDevice$3, reason: invalid class name */
    /* JADX INFO: compiled from: XBondConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XBondConnector$tryBoundDevice$3", f = "XBondConnector.kt", i = {}, l = {466}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $delay;
        final /* synthetic */ BluetoothDevice $device;
        final /* synthetic */ long $jobTimeout;
        int label;
        final /* synthetic */ XBondConnector this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(long j, long j2, XBondConnector xBondConnector, BluetoothDevice bluetoothDevice, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$jobTimeout = j;
            this.$delay = j2;
            this.this$0 = xBondConnector;
            this.$device = bluetoothDevice;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$jobTimeout, this.$delay, this.this$0, this.$device, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XBondConnector$tryBoundDevice$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: XBondConnector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XBondConnector$tryBoundDevice$3$1", f = "XBondConnector.kt", i = {}, l = {467, GuideActivity.PRESS_HOLD_START}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ long $delay;
            final /* synthetic */ BluetoothDevice $device;
            int label;
            final /* synthetic */ XBondConnector this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(long j, XBondConnector xBondConnector, BluetoothDevice bluetoothDevice, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$delay = j;
                this.this$0 = xBondConnector;
                this.$device = bluetoothDevice;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$delay, this.this$0, this.$device, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
            
                if (kotlinx.coroutines.DelayKt.delay(r12.this$0.getMBoundMillisTimeOut(), r12) == r0) goto L17;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (DelayKt.delay(this.$delay, this) != coroutine_suspended) {
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
                if (BleUtil.INSTANCE.checkBluetoothPermissions()) {
                    XBondConnector xBondConnector = this.this$0;
                    xBondConnector.createBond(this.$device, xBondConnector.getUnknownTransport());
                    this.label = 2;
                } else {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true) && "boundJob no permission".length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        FileLog.print$default(fileLog, 3, str, tag, "boundJob no permission " + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, "boundJob no permission " + strComponent2);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (TimeoutKt.withTimeout(this.$jobTimeout, new AnonymousClass1(this.$delay, this.this$0, this.$device, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    private final boolean isNeedGpsOpen() {
        return this.mXBluetoothManager.getBluetoothConfig().getGpsWhiteList().isNeedGspOpen() && !BleUtil.INSTANCE.isGpsOpen(this.mContext);
    }

    public static /* synthetic */ void checkParameterAndStartConnectJob$default(XBondConnector xBondConnector, boolean z, XBluetoothFlowCallBack xBluetoothFlowCallBack, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkParameterAndStartConnectJob");
        }
        if ((i & 1) != 0) {
            z = false;
        }
        xBondConnector.checkParameterAndStartConnectJob(z, xBluetoothFlowCallBack);
    }

    public CoroutineScope connectScope() {
        return XBluetoothManager.INSTANCE.get().getIoScope();
    }
}
