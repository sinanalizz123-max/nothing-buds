package com.nothing.link.bluetooth.sdk.scan;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.mlkit.common.MlKitException;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.config.Constants;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XScan.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010V\u001a\u00020\u00002\b\u0010W\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010O\u001a\u00020\u000bJ\b\u0010X\u001a\u00020\u000bH\u0002J\b\u0010Y\u001a\u00020\u000bH\u0016J\b\u0010Z\u001a\u00020[H\u0016J\u000e\u0010\\\u001a\u00020[2\u0006\u0010]\u001a\u00020\u0005J\u000e\u0010^\u001a\u00020\u00002\u0006\u0010O\u001a\u00020\u000bJ\b\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u00020\u000bH\u0002J\b\u0010b\u001a\u00020\u000bH\u0002JE\u0010c\u001a\u00020[2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020[0e2#\u0010f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010h\u00a2\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020[0g2\b\u0010l\u001a\u0004\u0018\u00010hH\u0002J\b\u0010m\u001a\u00020[H\u0016J\b\u0010n\u001a\u00020[H\u0016J\b\u0010o\u001a\u00020[H&J!\u0010p\u001a\u00020\u000b2\u0017\u0010q\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020[0g\u00a2\u0006\u0002\brH\u0016J>\u0010p\u001a\u00020\u000b2\u0017\u0010q\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020[0g\u00a2\u0006\u0002\br2\u001b\b\u0002\u0010s\u001a\u0015\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020[\u0018\u00010g\u00a2\u0006\u0002\brH\u0016Ja\u0010p\u001a\u00020\u000b2\b\u0010t\u001a\u0004\u0018\u00010)2\b\u0010u\u001a\u0004\u0018\u00010\u001d2\b\u0010v\u001a\u0004\u0018\u00010)2\u0017\u0010w\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020[0g\u00a2\u0006\u0002\br2\u001b\b\u0002\u0010x\u001a\u0015\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020[\u0018\u00010g\u00a2\u0006\u0002\brH\u0016\u00a2\u0006\u0002\u0010yJV\u0010z\u001a\u00020\u000b2\n\b\u0002\u0010t\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010v\u001a\u0004\u0018\u00010)2\u0017\u0010w\u001a\u0013\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020[0g\u00a2\u0006\u0002\br2\n\b\u0002\u0010x\u001a\u0004\u0018\u000108H\u0016\u00a2\u0006\u0002\u0010{J;\u0010|\u001a\u00020[2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020[0e2#\u0010f\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010h\u00a2\u0006\f\bi\u0012\b\bj\u0012\u0004\b\b(k\u0012\u0004\u0012\u00020[0gH\u0002J\b\u0010}\u001a\u00020[H&J\b\u0010~\u001a\u00020[H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R6\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b`\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001f\"\u0004\b0\u0010!R\u001a\u00101\u001a\u00020)X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R\u001c\u00104\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010%\"\u0004\b6\u0010'R\u001c\u00107\u001a\u0004\u0018\u000108X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020>X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020JX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001a\u0010O\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010\u0007\u00a8\u0006\u007f"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/scan/XScan;", "", "()V", "duplicateRemovalResults", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "getDuplicateRemovalResults", "()Ljava/util/concurrent/ConcurrentLinkedQueue;", "filterAddress", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getFilterAddress", "()Ljava/util/HashMap;", "setFilterAddress", "(Ljava/util/HashMap;)V", "isScanning", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "mCancelScan", "getMCancelScan", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "mCurrentReyCount", "", "getMCurrentReyCount", "()I", "setMCurrentReyCount", "(I)V", "mScanJob", "Lkotlinx/coroutines/Job;", "getMScanJob", "()Lkotlinx/coroutines/Job;", "setMScanJob", "(Lkotlinx/coroutines/Job;)V", "mScanMillisTimeOut", "", "getMScanMillisTimeOut", "()J", "setMScanMillisTimeOut", "(J)V", "mScanRetryCount", "getMScanRetryCount", "setMScanRetryCount", "mScanRetryInterval", "getMScanRetryInterval", "setMScanRetryInterval", "mWaitScanJob", "getMWaitScanJob", "setMWaitScanJob", "mXBluetoothFlowCallBack", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "getMXBluetoothFlowCallBack", "()Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "setMXBluetoothFlowCallBack", "(Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;)V", "mXBluetoothManager", "Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;", "getMXBluetoothManager", "()Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;", "setMXBluetoothManager", "(Lcom/nothing/link/bluetooth/sdk/XBluetoothManager;)V", "mXScanCallback", "Lcom/nothing/link/bluetooth/sdk/scan/XScanCallback;", "getMXScanCallback", "()Lcom/nothing/link/bluetooth/sdk/scan/XScanCallback;", "setMXScanCallback", "(Lcom/nothing/link/bluetooth/sdk/scan/XScanCallback;)V", "nullBundle", "Landroid/os/Bundle;", "getNullBundle", "()Landroid/os/Bundle;", "setNullBundle", "(Landroid/os/Bundle;)V", "paired", "getPaired", "()Z", "setPaired", "(Z)V", "results", "getResults", "addFilterAddress", "address", "checkAndStartScanJob", "checkParameters", "completionInternal", "", "filterData", "bleDevice", "filterPaired", "getScanType", "Lcom/nothing/link/bluetooth/sdk/scan/XScanType;", "ifContinueScan", "isNeedGpsOpen", "onCompletion", "startBlock", "Lkotlin/Function0;", "completionBlock", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "it", "onCreate", "onDestroy", "startInternal", "startScan", "bleScanCallback", "Lkotlin/ExtensionFunctionType;", "sanFlowCallBack", "scanMillisTimeOut", "scanRetryCount", "scanRetryInterval", "xScanCallback", "bluetoothFlowCallback", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Z", "startScan2", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;)Z", "startScanJob", "stop", "stopScan", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XScan {
    private Context mContext;
    private int mCurrentReyCount;
    private Job mScanJob;
    private long mScanMillisTimeOut;
    private int mScanRetryCount;
    private long mScanRetryInterval;
    private Job mWaitScanJob;
    private XBluetoothFlowCallBack mXBluetoothFlowCallBack;
    private XScanCallback mXScanCallback;
    private XBluetoothManager mXBluetoothManager = XBluetoothManager.INSTANCE.get();
    private final AtomicBoolean isScanning = new AtomicBoolean(false);
    private final AtomicBoolean mCancelScan = new AtomicBoolean(false);
    private final ConcurrentLinkedQueue<XBluetoothDevice> results = new ConcurrentLinkedQueue<>();
    private final ConcurrentLinkedQueue<XBluetoothDevice> duplicateRemovalResults = new ConcurrentLinkedQueue<>();
    private Bundle nullBundle = new Bundle();
    private HashMap<String, Boolean> filterAddress = new HashMap<>();
    private boolean paired = true;

    public void completionInternal() {
    }

    public abstract void startInternal();

    public abstract void stop();

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

    /* JADX INFO: renamed from: isScanning, reason: from getter */
    public final AtomicBoolean getIsScanning() {
        return this.isScanning;
    }

    public final AtomicBoolean getMCancelScan() {
        return this.mCancelScan;
    }

    public final Job getMScanJob() {
        return this.mScanJob;
    }

    public final void setMScanJob(Job job) {
        this.mScanJob = job;
    }

    public final Job getMWaitScanJob() {
        return this.mWaitScanJob;
    }

    public final void setMWaitScanJob(Job job) {
        this.mWaitScanJob = job;
    }

    public final int getMCurrentReyCount() {
        return this.mCurrentReyCount;
    }

    public final void setMCurrentReyCount(int i) {
        this.mCurrentReyCount = i;
    }

    public final long getMScanMillisTimeOut() {
        return this.mScanMillisTimeOut;
    }

    public final void setMScanMillisTimeOut(long j) {
        this.mScanMillisTimeOut = j;
    }

    public final int getMScanRetryCount() {
        return this.mScanRetryCount;
    }

    public final void setMScanRetryCount(int i) {
        this.mScanRetryCount = i;
    }

    public final long getMScanRetryInterval() {
        return this.mScanRetryInterval;
    }

    public final void setMScanRetryInterval(long j) {
        this.mScanRetryInterval = j;
    }

    public final XScanCallback getMXScanCallback() {
        return this.mXScanCallback;
    }

    public final void setMXScanCallback(XScanCallback xScanCallback) {
        this.mXScanCallback = xScanCallback;
    }

    public final XBluetoothFlowCallBack getMXBluetoothFlowCallBack() {
        return this.mXBluetoothFlowCallBack;
    }

    public final void setMXBluetoothFlowCallBack(XBluetoothFlowCallBack xBluetoothFlowCallBack) {
        this.mXBluetoothFlowCallBack = xBluetoothFlowCallBack;
    }

    public final ConcurrentLinkedQueue<XBluetoothDevice> getResults() {
        return this.results;
    }

    public final ConcurrentLinkedQueue<XBluetoothDevice> getDuplicateRemovalResults() {
        return this.duplicateRemovalResults;
    }

    public final Bundle getNullBundle() {
        return this.nullBundle;
    }

    public final void setNullBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<set-?>");
        this.nullBundle = bundle;
    }

    public final HashMap<String, Boolean> getFilterAddress() {
        return this.filterAddress;
    }

    public final void setFilterAddress(HashMap<String, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.filterAddress = map;
    }

    public final boolean getPaired() {
        return this.paired;
    }

    public final void setPaired(boolean z) {
        this.paired = z;
    }

    public void onCreate() {
        this.mContext = this.mXBluetoothManager.getContext();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getScanType() + " onCreate";
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
            }
        }
    }

    public XScanType getScanType() {
        return XScanType.BT.INSTANCE;
    }

    public static /* synthetic */ XScan addFilterAddress$default(XScan xScan, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFilterAddress");
        }
        if ((i & 2) != 0) {
            z = true;
        }
        return xScan.addFilterAddress(str, z);
    }

    public final XScan addFilterAddress(String address, boolean paired) {
        if (address == null) {
            return this;
        }
        this.filterAddress.put(address, Boolean.valueOf(paired));
        return this;
    }

    public final XScan filterPaired(boolean paired) {
        this.paired = paired;
        return this;
    }

    public void onDestroy() {
        this.mScanJob = null;
        this.mWaitScanJob = null;
        this.mXScanCallback = null;
        this.results.clear();
        this.duplicateRemovalResults.clear();
        this.filterAddress.clear();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getScanType() + " onDestroy";
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
            }
        }
    }

    public boolean startScan(Function1<? super XScanCallback, Unit> bleScanCallback) {
        Intrinsics.checkNotNullParameter(bleScanCallback, "bleScanCallback");
        return startScan(null, null, null, bleScanCallback, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean startScan$default(XScan xScan, Function1 function1, Function1 function2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startScan");
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        return xScan.startScan(function1, function2);
    }

    public boolean startScan(Function1<? super XScanCallback, Unit> bleScanCallback, Function1<? super XBluetoothFlowCallBack, Unit> sanFlowCallBack) {
        Intrinsics.checkNotNullParameter(bleScanCallback, "bleScanCallback");
        return startScan(null, null, null, bleScanCallback, sanFlowCallBack);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean startScan$default(XScan xScan, Long l, Integer num, Long l2, Function1 function1, Function1 function2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startScan");
        }
        if ((i & 16) != 0) {
            function2 = null;
        }
        return xScan.startScan(l, num, l2, function1, function2);
    }

    public boolean startScan(Long scanMillisTimeOut, Integer scanRetryCount, Long scanRetryInterval, Function1<? super XScanCallback, Unit> xScanCallback, Function1<? super XBluetoothFlowCallBack, Unit> bluetoothFlowCallback) {
        Intrinsics.checkNotNullParameter(xScanCallback, "xScanCallback");
        long jLongValue = scanMillisTimeOut != null ? scanMillisTimeOut.longValue() : 0L;
        this.mScanMillisTimeOut = jLongValue;
        if (jLongValue <= 0) {
            this.mScanMillisTimeOut = this.mXBluetoothManager.getBluetoothConfig().getScanMillisTimeOut();
        }
        int iIntValue = scanRetryCount != null ? scanRetryCount.intValue() : 0;
        this.mScanRetryCount = iIntValue;
        if (iIntValue <= 0) {
            this.mScanRetryCount = this.mXBluetoothManager.getBluetoothConfig().getScanRetryCount();
        }
        long jLongValue2 = scanRetryInterval != null ? scanRetryInterval.longValue() : 0L;
        this.mScanRetryInterval = jLongValue2;
        if (jLongValue2 <= 0) {
            this.mScanRetryInterval = this.mXBluetoothManager.getBluetoothConfig().getScanRetryInterval();
        }
        XScanCallback xScanCallback2 = new XScanCallback();
        xScanCallback.invoke(xScanCallback2);
        this.mXScanCallback = xScanCallback2;
        if (bluetoothFlowCallback != null) {
            XBluetoothFlowCallBack xBluetoothFlowCallBack = new XBluetoothFlowCallBack();
            bluetoothFlowCallback.invoke(xBluetoothFlowCallBack);
            this.mXBluetoothFlowCallBack = xBluetoothFlowCallBack;
        }
        return checkAndStartScanJob();
    }

    public static /* synthetic */ boolean startScan2$default(XScan xScan, Long l, Integer num, Long l2, Function1 function1, XBluetoothFlowCallBack xBluetoothFlowCallBack, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startScan2");
        }
        if ((i & 1) != 0) {
            l = 0L;
        }
        if ((i & 2) != 0) {
            num = 0;
        }
        if ((i & 4) != 0) {
            l2 = 0L;
        }
        if ((i & 16) != 0) {
            xBluetoothFlowCallBack = null;
        }
        XBluetoothFlowCallBack xBluetoothFlowCallBack2 = xBluetoothFlowCallBack;
        Long l3 = l2;
        return xScan.startScan2(l, num, l3, function1, xBluetoothFlowCallBack2);
    }

    public boolean startScan2(Long scanMillisTimeOut, Integer scanRetryCount, Long scanRetryInterval, Function1<? super XScanCallback, Unit> xScanCallback, XBluetoothFlowCallBack bluetoothFlowCallback) {
        Intrinsics.checkNotNullParameter(xScanCallback, "xScanCallback");
        long jLongValue = scanMillisTimeOut != null ? scanMillisTimeOut.longValue() : 0L;
        this.mScanMillisTimeOut = jLongValue;
        if (jLongValue <= 0) {
            this.mScanMillisTimeOut = this.mXBluetoothManager.getBluetoothConfig().getScanMillisTimeOut();
        }
        int iIntValue = scanRetryCount != null ? scanRetryCount.intValue() : 0;
        this.mScanRetryCount = iIntValue;
        if (iIntValue <= 0) {
            this.mScanRetryCount = this.mXBluetoothManager.getBluetoothConfig().getScanRetryCount();
        }
        long jLongValue2 = scanRetryInterval != null ? scanRetryInterval.longValue() : 0L;
        this.mScanRetryInterval = jLongValue2;
        if (jLongValue2 <= 0) {
            this.mScanRetryInterval = this.mXBluetoothManager.getBluetoothConfig().getScanRetryInterval();
        }
        XScanCallback xScanCallback2 = new XScanCallback();
        xScanCallback.invoke(xScanCallback2);
        this.mXScanCallback = xScanCallback2;
        this.mXBluetoothFlowCallBack = bluetoothFlowCallback;
        return checkAndStartScanJob();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkAndStartScanJob() {
        if (!checkParameters()) {
            return false;
        }
        this.results.clear();
        this.duplicateRemovalResults.clear();
        startScanJob(new Function0<Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XScan.checkAndStartScanJob.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                XScan.this.startInternal();
            }
        }, new Function1<Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XScan.checkAndStartScanJob.2
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
                XScan.this.completionInternal();
            }
        });
        return true;
    }

    public void stopScan() {
        this.isScanning.set(false);
        this.mCancelScan.set(true);
        if (this.mScanJob != null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = getScanType() + " stopScan.";
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
        }
        Job job = this.mScanJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.mWaitScanJob;
        if (job2 != null) {
            job2.cancel(new CancellationException(Constants.CANCEL_WAIT_JOB_MESSAGE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startScanJob(final Function0<Unit> startBlock, final Function1<? super Throwable, Unit> completionBlock) {
        this.isScanning.set(true);
        this.mCancelScan.set(false);
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = this.mScanMillisTimeOut;
        if (longRef.element <= 0) {
            longRef.element = 10000L;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getScanType() + " start scan " + (this.mCurrentReyCount + 1) + " times, timeout = " + longRef.element;
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
        XScanCallback xScanCallback = this.mXScanCallback;
        Job jobLaunchInIOThread = xScanCallback != null ? xScanCallback.launchInIOThread(new C09172(longRef, startBlock, null)) : null;
        this.mScanJob = jobLaunchInIOThread;
        if (jobLaunchInIOThread != null) {
            jobLaunchInIOThread.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XScan.startScanJob.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    XScan.this.getIsScanning().set(false);
                    completionBlock.invoke(th);
                    XScan.this.onCompletion(startBlock, completionBlock, th);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.scan.XScan$startScanJob$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XScan.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XScan$startScanJob$2", f = "XScan.kt", i = {}, l = {MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR}, m = "invokeSuspend", n = {}, s = {})
    static final class C09172 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.LongRef $scanTime;
        final /* synthetic */ Function0<Unit> $startBlock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09172(Ref.LongRef longRef, Function0<Unit> function0, Continuation<? super C09172> continuation) {
            super(2, continuation);
            this.$scanTime = longRef;
            this.$startBlock = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09172(this.$scanTime, this.$startBlock, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09172) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.scan.XScan$startScanJob$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: XScan.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XScan$startScanJob$2$1", f = "XScan.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.LongRef $scanTime;
            final /* synthetic */ Function0<Unit> $startBlock;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Function0<Unit> function0, Ref.LongRef longRef, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$startBlock = function0;
                this.$scanTime = longRef;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$startBlock, this.$scanTime, continuation);
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
                    this.$startBlock.invoke();
                    this.label = 1;
                    if (DelayKt.delay(this.$scanTime.element, this) == coroutine_suspended) {
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

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (TimeoutKt.withTimeout(this.$scanTime.element, new AnonymousClass1(this.$startBlock, this.$scanTime, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCompletion(Function0<Unit> startBlock, final Function1<? super Throwable, Unit> completionBlock, Throwable it) {
        stop();
        if (ifContinueScan()) {
            XScanCallback xScanCallback = this.mXScanCallback;
            Job jobLaunchInDefaultThread = xScanCallback != null ? xScanCallback.launchInDefaultThread(new C09141(startBlock, completionBlock, null)) : null;
            this.mWaitScanJob = jobLaunchInDefaultThread;
            if (jobLaunchInDefaultThread != null) {
                jobLaunchInDefaultThread.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XScan.onCompletion.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
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
                        if (Intrinsics.areEqual(Constants.CANCEL_WAIT_JOB_MESSAGE, th != null ? th.getMessage() : null)) {
                            XScan.this.stop();
                            completionBlock.invoke(th);
                        }
                    }
                });
                return;
            }
            return;
        }
        if (it != null && !(it instanceof CancellationException)) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = getScanType() + " scan failed : " + it.getMessage();
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
            XScanCallback xScanCallback2 = this.mXScanCallback;
            if (xScanCallback2 != null) {
                xScanCallback2.callScanFail(new XScanFailType.ScanError(-1, it));
            }
        }
        XScanCallback xScanCallback3 = this.mXScanCallback;
        if (xScanCallback3 != null) {
            xScanCallback3.callScanComplete(CollectionsKt.toMutableList((Collection) this.results), CollectionsKt.toMutableList((Collection) this.duplicateRemovalResults));
        }
        if (this.results.isEmpty()) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = getScanType() + " scan result is empty!";
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
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
        XScanCallback xScanCallback4 = this.mXScanCallback;
        if (xScanCallback4 != null) {
            xScanCallback4.launchInDefaultThread(new C09165(null));
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.scan.XScan$onCompletion$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XScan.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XScan$onCompletion$1", f = "XScan.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
    static final class C09141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Throwable, Unit> $completionBlock;
        final /* synthetic */ Function0<Unit> $startBlock;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09141(Function0<Unit> function0, Function1<? super Throwable, Unit> function1, Continuation<? super C09141> continuation) {
            super(2, continuation);
            this.$startBlock = function0;
            this.$completionBlock = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XScan.this.new C09141(this.$startBlock, this.$completionBlock, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(XScan.this.getMScanRetryInterval(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            XScan xScan = XScan.this;
            xScan.setMCurrentReyCount(xScan.getMCurrentReyCount() + 1);
            XScan.this.startScanJob(this.$startBlock, this.$completionBlock);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.scan.XScan$onCompletion$5, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XScan.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.scan.XScan$onCompletion$5", f = "XScan.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
    static final class C09165 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09165(Continuation<? super C09165> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XScan.this.new C09165(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09165) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Logger logger = Logger.INSTANCE;
            XScan xScan = XScan.this;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = xScan.getScanType() + " scan finish,total scan count " + (xScan.getMCurrentReyCount() + 1) + " times";
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
            XScan.this.setMCurrentReyCount(0);
            return Unit.INSTANCE;
        }
    }

    private final boolean ifContinueScan() {
        int i;
        return !this.mCancelScan.get() && (i = this.mScanRetryCount) > 0 && this.mCurrentReyCount < i;
    }

    public boolean checkParameters() {
        if (this.mXBluetoothManager.getBluetoothAdapter() == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = getScanType() + " bluetoothAdapter is null ,maybe XBluetoothManager is not init!";
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
            XScanCallback xScanCallback = this.mXScanCallback;
            if (xScanCallback != null) {
                xScanCallback.callScanFail(XScanFailType.UnInitManager.INSTANCE);
            }
            return false;
        }
        if (!BleUtil.INSTANCE.isPermission(this.mContext)) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = getScanType() + " context has no permission!";
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
            XScanCallback xScanCallback2 = this.mXScanCallback;
            if (xScanCallback2 != null) {
                xScanCallback2.callScanFail(XScanFailType.NoBluetoothPermission.INSTANCE);
            }
            XBluetoothFlowCallBack xBluetoothFlowCallBack = this.mXBluetoothFlowCallBack;
            if (xBluetoothFlowCallBack != null) {
                xBluetoothFlowCallBack.callRequestPermission(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XScan.checkParameters.3
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
                            XScan.this.checkAndStartScanJob();
                        }
                    }
                });
            }
            return false;
        }
        if (this.mXBluetoothManager.bluetoothUnEnable()) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str7 = getScanType() + " bluetooth is unavailable!";
                String str8 = str7;
                if (str8 != null && str8.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str9 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                    FileLog.print$default(fileLog3, 5, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.w(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            XScanCallback xScanCallback3 = this.mXScanCallback;
            if (xScanCallback3 != null) {
                xScanCallback3.callScanFail(XScanFailType.BluetoothUnable.INSTANCE);
            }
            XBluetoothFlowCallBack xBluetoothFlowCallBack2 = this.mXBluetoothFlowCallBack;
            if (xBluetoothFlowCallBack2 != null) {
                xBluetoothFlowCallBack2.callRequestBluetoothOpen(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XScan.checkParameters.5
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
                            XScan.this.checkAndStartScanJob();
                        }
                    }
                });
            }
            return false;
        }
        if (isNeedGpsOpen()) {
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true)) {
                String str10 = getScanType() + " gps is not open ,please open it or put current device to scan white list!";
                String str11 = str10;
                if (str11 != null && str11.length() != 0) {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str12 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                    FileLog.print$default(fileLog4, 5, str12, tag4, str10 + StringUtils.SPACE + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.w(tag4 + strComponent7, str10 + StringUtils.SPACE + strComponent8);
                    }
                }
            }
            XScanCallback xScanCallback4 = this.mXScanCallback;
            if (xScanCallback4 != null) {
                xScanCallback4.callScanFail(XScanFailType.GPSDisable.INSTANCE);
            }
            XBluetoothFlowCallBack xBluetoothFlowCallBack3 = this.mXBluetoothFlowCallBack;
            if (xBluetoothFlowCallBack3 != null) {
                xBluetoothFlowCallBack3.callRequestGps(new Function1<Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.scan.XScan.checkParameters.7
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
                            XScan.this.checkAndStartScanJob();
                        }
                    }
                });
            }
            return false;
        }
        if (this.isScanning.get()) {
            Logger logger5 = Logger.INSTANCE;
            String tag5 = logger5.getTAG();
            int depth5 = logger5.getDepth();
            if (logger5.isCanLogger(true)) {
                String str13 = getScanType() + " already start scanning .";
                String str14 = str13;
                if (str14 != null && str14.length() != 0) {
                    Pair<String, String> trace5 = logger5.getTrace(depth5);
                    String strComponent9 = trace5.component1();
                    String strComponent10 = trace5.component2();
                    FileLog fileLog5 = FileLog.INSTANCE;
                    String str15 = logger5.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                    FileLog.print$default(fileLog5, 5, str15, tag5, str13 + StringUtils.SPACE + strComponent10, null, 16, null);
                    if (logger5.isDebug()) {
                        Log.w(tag5 + strComponent9, str13 + StringUtils.SPACE + strComponent10);
                    }
                }
            }
            XScanCallback xScanCallback5 = this.mXScanCallback;
            if (xScanCallback5 != null) {
                xScanCallback5.callScanFail(XScanFailType.AlReadyScanning.INSTANCE);
            }
            return false;
        }
        Logger logger6 = Logger.INSTANCE;
        String tag6 = logger6.getTAG();
        int depth6 = logger6.getDepth();
        if (logger6.isCanLogger(true) && "checkParameters successful!".length() != 0) {
            Pair<String, String> trace6 = logger6.getTrace(depth6);
            String strComponent11 = trace6.component1();
            String strComponent12 = trace6.component2();
            FileLog fileLog6 = FileLog.INSTANCE;
            String str16 = logger6.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str16, "format(...)");
            FileLog.print$default(fileLog6, 3, str16, tag6, "checkParameters successful! " + strComponent12, null, 16, null);
            if (logger6.isDebug()) {
                Log.i(tag6 + strComponent11, "checkParameters successful! " + strComponent12);
            }
        }
        return true;
    }

    private final boolean isNeedGpsOpen() {
        return this.mXBluetoothManager.getBluetoothConfig().getGpsWhiteList().isNeedGspOpen() && !BleUtil.INSTANCE.isGpsOpen(this.mContext);
    }

    public final void filterData(XBluetoothDevice bleDevice) {
        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
        this.results.add(bleDevice);
        XScanCallback xScanCallback = this.mXScanCallback;
        if (xScanCallback != null) {
            xScanCallback.callLeScan(bleDevice, this.mCurrentReyCount + 1);
        }
        if (this.duplicateRemovalResults.isEmpty()) {
            this.duplicateRemovalResults.add(bleDevice);
            XScanCallback xScanCallback2 = this.mXScanCallback;
            if (xScanCallback2 != null) {
                xScanCallback2.callLeScanDuplicateRemoval(bleDevice, this.mCurrentReyCount + 1);
                return;
            }
            return;
        }
        Iterator<XBluetoothDevice> it = this.duplicateRemovalResults.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(bleDevice, it.next())) {
                return;
            }
        }
        this.duplicateRemovalResults.add(bleDevice);
        XScanCallback xScanCallback3 = this.mXScanCallback;
        if (xScanCallback3 != null) {
            xScanCallback3.callLeScanDuplicateRemoval(bleDevice, this.mCurrentReyCount + 1);
        }
    }
}
