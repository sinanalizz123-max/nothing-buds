package com.nothing.os.device.xservice;

import android.app.Application;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.nothing.base.util.AppGlobals;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.broadcase.ext.BluetoothDeviceExtKt;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.device.IOTDevice;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.OSXViewController;
import com.nothing.ear.R;
import com.nothing.earbase.anc.entity.DeviceNoiseItem;
import com.nothing.earbase.anc.entity.DeviceNoiseReduction;
import com.nothing.earbase.ota.entity.DeviceBattery;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.earbase.unknown.NewSkuDevice;
import com.nothing.earbase.unknown.device.UnknownDevice;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.log.FileLog;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import com.nothing.xservice.XViewType;
import com.nothing.xservice.transform.key.ViewKey;
import com.nothing.xview.cardtransform.CardInfo;
import com.nothing.xview.cardtransform.info.ActionInfo;
import com.nothing.xview.cardtransform.info.ImageInfo;
import com.nothing.xview.cardtransform.info.ResultInfo;
import com.nothing.xview.cardtransform.info.TextViewInfo;
import com.nothing.xview.cardtransform.info.ViewInfo;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;
import org.json.JSONException;

/* JADX INFO: compiled from: ViewTypeController.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001=\b&\u0018\u0000 Y2\u00020\u0001:\u0001YB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J8\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001062\u0014\u00108\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0004\u0012\u00020209H\u0016J\u0010\u0010:\u001a\u0002022\u0006\u00105\u001a\u000206H\u0016J6\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030$2\u0006\u00105\u001a\u0002062\u0014\u00108\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u000106\u0012\u0004\u0012\u000202092\b\u00107\u001a\u0004\u0018\u000106H\u0002J6\u0010?\u001a\u0004\u0018\u00010@2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010@2\b\u0010B\u001a\u0004\u0018\u0001062\u0006\u0010C\u001a\u00020DH\u0016J\u0012\u0010E\u001a\u00020D2\b\u0010F\u001a\u0004\u0018\u00010GH\u0002J*\u0010H\u001a\u0002062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010C\u001a\u00020DH\u0016J,\u0010I\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010J\u001a\u00020\u00032\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u0002022\u0006\u00105\u001a\u000206H\u0002J\u0016\u0010N\u001a\u00020\u00032\u0006\u00105\u001a\u0002062\u0006\u0010O\u001a\u00020\u0003J\"\u0010P\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\b\u0002\u0010\u0012\u001a\u00020DJ\u0018\u0010Q\u001a\u0002062\b\u0010F\u001a\u0004\u0018\u00010G2\u0006\u00103\u001a\u000204J\u0016\u0010R\u001a\u0002062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0016\u0010S\u001a\u00020T2\u0006\u00103\u001a\u0002042\u0006\u0010U\u001a\u00020\u0003J\u0016\u0010V\u001a\u0002062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J \u0010W\u001a\u0002062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010)\u001a\u00020\u0013H&J,\u0010X\u001a\u0004\u0018\u0001062\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010J\u001a\u00020\u0003H&R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0014\"\u0004\b*\u0010\u0016R\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0010\u0010<\u001a\u00020=X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010>\u00a8\u0006Z"}, d2 = {"Lcom/nothing/os/device/xservice/ViewTypeController;", "Lcom/nothing/device/OSXViewController;", "type", "", "<init>", "(I)V", "lastDeviceNoiseReduction", "Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;", "getLastDeviceNoiseReduction", "()Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;", "setLastDeviceNoiseReduction", "(Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;)V", "batteryValue", "Lcom/nothing/earbase/ota/entity/DeviceBattery;", "getBatteryValue", "()Lcom/nothing/earbase/ota/entity/DeviceBattery;", "setBatteryValue", "(Lcom/nothing/earbase/ota/entity/DeviceBattery;)V", "isClick", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setClick", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "clickJob", "Lkotlinx/coroutines/Job;", "getClickJob", "()Lkotlinx/coroutines/Job;", "setClickJob", "(Lkotlinx/coroutines/Job;)V", "firstAddObserver", "Ljava/util/concurrent/atomic/AtomicInteger;", "getFirstAddObserver", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setFirstAddObserver", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "connectObserver", "Landroidx/lifecycle/Observer;", "getConnectObserver", "()Landroidx/lifecycle/Observer;", "setConnectObserver", "(Landroidx/lifecycle/Observer;)V", "isExpand", ViewKey.setExpand, "mainCoroutine", "Lkotlinx/coroutines/CoroutineScope;", "getMainCoroutine", "()Lkotlinx/coroutines/CoroutineScope;", "setMainCoroutine", "(Lkotlinx/coroutines/CoroutineScope;)V", "addObserver", "", "context", "Landroid/content/Context;", "address", "", "viewType", "action", "Lkotlin/Function1;", "removeObserver", "addConnectListener", "twsDeviceCallback", "com/nothing/os/device/xservice/ViewTypeController$twsDeviceCallback$1", "Lcom/nothing/os/device/xservice/ViewTypeController$twsDeviceCallback$1;", "getTextInfo", "Landroid/os/Bundle;", "extras", "textType", "autoConnect", "", "isSppConnected", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "getViewInfo", "buildClickViewInfo", "viewId", "resultInfo", "Lcom/nothing/xview/cardtransform/info/ResultInfo;", "connectDevice", "setNoiseMode", "lastSelectLevel", "unSupportConnectedInfo", "getSubTitle", "disConnectedInfo", "createCardInfo", "Lcom/nothing/xview/cardtransform/CardInfo;", "resId", "connectingInfo", "connectedInfo", "clickConnectedInfo", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ViewTypeController extends OSXViewController {
    public static final long ANIMATION_DURATION = 200;
    public static final int ANIMATOR_INDEX_1 = 1;
    public static final int ANIMATOR_INDEX_10 = 10;
    public static final int ANIMATOR_INDEX_11 = 11;
    public static final int ANIMATOR_INDEX_2 = 3;
    public static final int ANIMATOR_INDEX_3 = 3;
    public static final int ANIMATOR_INDEX_4 = 4;
    public static final int ANIMATOR_INDEX_5 = 5;
    public static final int ANIMATOR_INDEX_6 = 6;
    public static final int ANIMATOR_INDEX_7 = 7;
    public static final int ANIMATOR_INDEX_8 = 8;
    public static final int ANIMATOR_INDEX_9 = 9;
    public static final String BATTERY = "BATTERY";
    public static final float CONNECTED_ALPHA = 1.0f;
    public static final float CONNECTING_ALPHA = 0.33f;
    public static final String CURRENT_MODE = "CURRENT_MODE";
    public static final String IS_EXPAND = "IS_EXPAND";
    public static final String LAST_LEVEL_MODE = "LAST_LEVEL_MODE";
    public static final String NOISE = "NOISE";
    public static final long SEND_DELAY = 2000;
    private DeviceBattery batteryValue;
    private Job clickJob;
    private Observer<Integer> connectObserver;
    private AtomicInteger firstAddObserver;
    private AtomicBoolean isClick;
    private AtomicBoolean isExpand;
    private DeviceNoiseReduction lastDeviceNoiseReduction;
    private CoroutineScope mainCoroutine;
    private final ViewTypeController$twsDeviceCallback$1 twsDeviceCallback;

    public abstract String clickConnectedInfo(Context context, String address, ResultInfo resultInfo, int viewId);

    public abstract String connectedInfo(Context context, String address, AtomicBoolean isExpand);

    /* JADX WARN: Type inference failed for: r2v7, types: [com.nothing.os.device.xservice.ViewTypeController$twsDeviceCallback$1] */
    public ViewTypeController(int i) {
        super(i);
        this.isClick = new AtomicBoolean(false);
        this.firstAddObserver = new AtomicInteger(0);
        this.isExpand = new AtomicBoolean(false);
        this.mainCoroutine = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.twsDeviceCallback = new TWSDevice.Callback() { // from class: com.nothing.os.device.xservice.ViewTypeController$twsDeviceCallback$1
            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onConnected() {
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onError(int code, String message) {
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onUpdate(int cmdType, Message data) {
                Intrinsics.checkNotNullParameter(data, "data");
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
            public void onError(TWSDevice tWSDevice, int i2, String str) {
                TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i2, str);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void openBluetooth(TWSDevice tWSDevice) {
                TWSDevice.Callback.DefaultImpls.openBluetooth(this, tWSDevice);
            }

            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onDisconnected() {
                this.this$0.setLastDeviceNoiseReduction(null);
            }

            /* JADX WARN: Code duplicated, block: B:12:0x0045  */
            /* JADX WARN: Code duplicated, block: B:25:0x0118  */
            /* JADX WARN: Code duplicated, block: B:6:0x0021  */
            /* JADX WARN: Code duplicated, block: B:72:0x028a  */
            @Override // com.nothing.protocol.device.TWSDevice.Callback
            public void onUpdate(int cmdType, Message data, TWSDevice twsDevice) {
                boolean z;
                String str;
                String address;
                String strUniqueId;
                String str2;
                DeviceNoiseItem noiseReductionMode;
                DeviceNoiseItem noiseReductionMode2;
                String address2;
                String strUniqueId2;
                AppHost appHostLookupByUniqueId;
                DeviceNoiseItem lastNoiseReductionLevel;
                DeviceNoiseItem lastNoiseReductionLevel2;
                DeviceNoiseItem lastNoiseReductionLevel3;
                DeviceNoiseItem lastNoiseReductionLevel4;
                DeviceNoiseItem noiseReductionMode3;
                DeviceNoiseItem noiseReductionMode4;
                Intrinsics.checkNotNullParameter(data, "data");
                Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
                if (cmdType != 49159 && cmdType != 57345) {
                    str = "format(...)";
                } else {
                    DeviceBattery deviceBattery = (DeviceBattery) data.obtainPayload(DeviceBattery.class);
                    if (deviceBattery == null) {
                        return;
                    }
                    Logger logger = Logger.INSTANCE;
                    ViewTypeController viewTypeController = this.this$0;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str3 = "addBatteryListener Observer into isClick:" + viewTypeController.getIsClick() + "-->";
                        String str4 = str3;
                        if (str4 == null || str4.length() == 0) {
                            z = true;
                        } else {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str5 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                            z = true;
                            FileLog.print$default(fileLog, 3, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                            }
                        }
                    } else {
                        z = true;
                    }
                    if (this.this$0.getIsClick().get()) {
                        str = "format(...)";
                    } else {
                        boolean z2 = !deviceBattery.isSameBattery(this.this$0.getBatteryValue());
                        Logger logger2 = Logger.INSTANCE;
                        String tag2 = logger2.getTAG();
                        int depth2 = logger2.getDepth();
                        if (!logger2.isCanLogger(z)) {
                            str = "format(...)";
                        } else {
                            String str6 = "addBatteryListener Observer -->" + twsDevice.getAddress() + "  iNotSame:" + z2 + StringUtils.SPACE + deviceBattery;
                            String str7 = str6;
                            if (str7 == null || str7.length() == 0) {
                                str = "format(...)";
                            } else {
                                Pair<String, String> trace2 = logger2.getTrace(depth2);
                                String strComponent3 = trace2.component1();
                                String strComponent4 = trace2.component2();
                                FileLog fileLog2 = FileLog.INSTANCE;
                                String str8 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                                str = "format(...)";
                                FileLog.print$default(fileLog2, 3, str8, tag2, str6 + StringUtils.SPACE + strComponent4, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.i(tag2 + strComponent3, str6 + StringUtils.SPACE + strComponent4);
                                }
                            }
                        }
                        this.this$0.setBatteryValue(deviceBattery);
                        Application application = AppGlobals.INSTANCE.get();
                        if (application != null && (address = twsDevice.getAddress()) != null && (strUniqueId = XView.INSTANCE.uniqueId(address, "BATTERY")) != null) {
                            XViewServiceImpl.INSTANCE.getInstance(application).callbackEarBattery(strUniqueId, twsDevice);
                        }
                    }
                }
                if (cmdType == 49182 || cmdType == 57347) {
                    DeviceNoiseReduction deviceNoiseReduction = (DeviceNoiseReduction) data.obtainPayload(DeviceNoiseReduction.class);
                    if (this.this$0.getIsClick().get()) {
                        return;
                    }
                    DeviceNoiseReduction lastDeviceNoiseReduction = this.this$0.getLastDeviceNoiseReduction();
                    boolean zAreEqual = Intrinsics.areEqual((lastDeviceNoiseReduction == null || (noiseReductionMode4 = lastDeviceNoiseReduction.getNoiseReductionMode()) == null) ? null : Integer.valueOf(noiseReductionMode4.getValue()), (deviceNoiseReduction == null || (noiseReductionMode3 = deviceNoiseReduction.getNoiseReductionMode()) == null) ? null : Integer.valueOf(noiseReductionMode3.getValue()));
                    boolean z3 = !zAreEqual;
                    DeviceNoiseReduction lastDeviceNoiseReduction2 = this.this$0.getLastDeviceNoiseReduction();
                    boolean zAreEqual2 = Intrinsics.areEqual((lastDeviceNoiseReduction2 == null || (lastNoiseReductionLevel4 = lastDeviceNoiseReduction2.getLastNoiseReductionLevel()) == null) ? null : Integer.valueOf(lastNoiseReductionLevel4.getValue()), (deviceNoiseReduction == null || (lastNoiseReductionLevel3 = deviceNoiseReduction.getLastNoiseReductionLevel()) == null) ? null : Integer.valueOf(lastNoiseReductionLevel3.getValue()));
                    boolean z4 = !zAreEqual2;
                    Logger logger3 = Logger.INSTANCE;
                    ViewTypeController viewTypeController2 = this.this$0;
                    String tag3 = logger3.getTAG();
                    int depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true)) {
                        DeviceNoiseReduction lastDeviceNoiseReduction3 = viewTypeController2.getLastDeviceNoiseReduction();
                        String str9 = "addNoiseListener Observer lastDeviceNoiseReduction:" + ((lastDeviceNoiseReduction3 == null || (noiseReductionMode2 = lastDeviceNoiseReduction3.getNoiseReductionMode()) == null) ? null : Integer.valueOf(noiseReductionMode2.getValue())) + ",new:" + ((deviceNoiseReduction == null || (noiseReductionMode = deviceNoiseReduction.getNoiseReductionMode()) == null) ? null : Integer.valueOf(noiseReductionMode.getValue()));
                        String str10 = str9;
                        if (str10 == null || str10.length() == 0) {
                            str2 = str;
                        } else {
                            Pair<String, String> trace3 = logger3.getTrace(depth3);
                            String strComponent5 = trace3.component1();
                            String strComponent6 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str11 = logger3.getSdf().format(new Date());
                            str2 = str;
                            Intrinsics.checkNotNullExpressionValue(str11, str2);
                            FileLog.print$default(fileLog3, 3, str11, tag3, str9 + StringUtils.SPACE + strComponent6, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.i(tag3 + strComponent5, str9 + StringUtils.SPACE + strComponent6);
                            }
                        }
                    } else {
                        str2 = str;
                    }
                    Logger logger4 = Logger.INSTANCE;
                    ViewTypeController viewTypeController3 = this.this$0;
                    String tag4 = logger4.getTAG();
                    int depth4 = logger4.getDepth();
                    if (logger4.isCanLogger(true)) {
                        DeviceNoiseReduction lastDeviceNoiseReduction4 = viewTypeController3.getLastDeviceNoiseReduction();
                        String str12 = "addNoiseListener Observer getLastNoiseReductionLevel:" + ((lastDeviceNoiseReduction4 == null || (lastNoiseReductionLevel2 = lastDeviceNoiseReduction4.getLastNoiseReductionLevel()) == null) ? null : Integer.valueOf(lastNoiseReductionLevel2.getValue())) + ",new:" + ((deviceNoiseReduction == null || (lastNoiseReductionLevel = deviceNoiseReduction.getLastNoiseReductionLevel()) == null) ? null : Integer.valueOf(lastNoiseReductionLevel.getValue()));
                        String str13 = str12;
                        if (str13 != null && str13.length() != 0) {
                            Pair<String, String> trace4 = logger4.getTrace(depth4);
                            String strComponent7 = trace4.component1();
                            String strComponent8 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str14 = logger4.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str14, str2);
                            FileLog.print$default(fileLog4, 3, str14, tag4, str12 + StringUtils.SPACE + strComponent8, null, 16, null);
                            if (logger4.isDebug()) {
                                Log.i(tag4 + strComponent7, str12 + StringUtils.SPACE + strComponent8);
                            }
                        }
                    }
                    Logger logger5 = Logger.INSTANCE;
                    String tag5 = logger5.getTAG();
                    int depth5 = logger5.getDepth();
                    if (logger5.isCanLogger(true)) {
                        String str15 = "addNoiseListener Observer isDifferentMode:" + z3 + ",isDifferentLevel:" + z4;
                        String str16 = str15;
                        if (str16 != null && str16.length() != 0) {
                            Pair<String, String> trace5 = logger5.getTrace(depth5);
                            String strComponent9 = trace5.component1();
                            String strComponent10 = trace5.component2();
                            FileLog fileLog5 = FileLog.INSTANCE;
                            String str17 = logger5.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str17, str2);
                            FileLog.print$default(fileLog5, 3, str17, tag5, str15 + StringUtils.SPACE + strComponent10, null, 16, null);
                            if (logger5.isDebug()) {
                                Log.i(tag5 + strComponent9, str15 + StringUtils.SPACE + strComponent10);
                            }
                        }
                    }
                    if (zAreEqual && zAreEqual2) {
                        return;
                    }
                    this.this$0.setLastDeviceNoiseReduction(deviceNoiseReduction);
                    Application application2 = AppGlobals.INSTANCE.get();
                    if (application2 == null || (address2 = twsDevice.getAddress()) == null || (strUniqueId2 = XView.INSTANCE.uniqueId(address2, XViewType.ANC_VIEW_TYPE)) == null || (appHostLookupByUniqueId = XViewServiceImpl.INSTANCE.getInstance(application2).lookupByUniqueId(strUniqueId2)) == null) {
                        return;
                    }
                    appHostLookupByUniqueId.notifyViewDataChange(strUniqueId2);
                }
            }
        };
    }

    public final DeviceNoiseReduction getLastDeviceNoiseReduction() {
        return this.lastDeviceNoiseReduction;
    }

    public final void setLastDeviceNoiseReduction(DeviceNoiseReduction deviceNoiseReduction) {
        this.lastDeviceNoiseReduction = deviceNoiseReduction;
    }

    public final DeviceBattery getBatteryValue() {
        return this.batteryValue;
    }

    public final void setBatteryValue(DeviceBattery deviceBattery) {
        this.batteryValue = deviceBattery;
    }

    /* JADX INFO: renamed from: isClick, reason: from getter */
    public final AtomicBoolean getIsClick() {
        return this.isClick;
    }

    public final void setClick(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isClick = atomicBoolean;
    }

    public final Job getClickJob() {
        return this.clickJob;
    }

    public final void setClickJob(Job job) {
        this.clickJob = job;
    }

    public final AtomicInteger getFirstAddObserver() {
        return this.firstAddObserver;
    }

    public final void setFirstAddObserver(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
        this.firstAddObserver = atomicInteger;
    }

    public final Observer<Integer> getConnectObserver() {
        return this.connectObserver;
    }

    public final void setConnectObserver(Observer<Integer> observer) {
        this.connectObserver = observer;
    }

    /* JADX INFO: renamed from: isExpand, reason: from getter */
    public final AtomicBoolean getIsExpand() {
        return this.isExpand;
    }

    public final void setExpand(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isExpand = atomicBoolean;
    }

    public final CoroutineScope getMainCoroutine() {
        return this.mainCoroutine;
    }

    public final void setMainCoroutine(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.mainCoroutine = coroutineScope;
    }

    @Override // com.nothing.device.OSXViewController
    public void addObserver(Context context, String address, String viewType, Function1<? super String, Unit> action) {
        TWSDevice twsDevice;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(action, "action");
        if (this.connectObserver == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "addObserver connectObserver".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 4, str, tag, "addObserver connectObserver " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "addObserver connectObserver " + strComponent2);
                }
            }
            this.connectObserver = addConnectListener(address, action, viewType);
            IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
            if (iOTDeviceByMacAddress == null || (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) == null) {
                return;
            }
            twsDevice.register(this.twsDeviceCallback);
        }
    }

    /* JADX INFO: renamed from: com.nothing.os.device.xservice.ViewTypeController$removeObserver$1, reason: invalid class name */
    /* JADX INFO: compiled from: ViewTypeController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.xservice.ViewTypeController$removeObserver$1", f = "ViewTypeController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$address = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ViewTypeController.this.new AnonymousClass1(this.$address, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            TWSDevice twsDevice;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$address;
            ViewTypeController viewTypeController = ViewTypeController.this;
            try {
                Result.Companion companion = Result.INSTANCE;
                IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(str);
                if (iOTDeviceByMacAddress == null || (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) == null) {
                    twsDevice = null;
                } else {
                    Observer<Integer> connectObserver = viewTypeController.getConnectObserver();
                    if (connectObserver != null) {
                        twsDevice.getConnectedLiveData().removeObserver(connectObserver);
                    }
                    twsDevice.unregister(viewTypeController.twsDeviceCallback);
                }
                Result.m6347constructorimpl(twsDevice);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            Logger logger = Logger.INSTANCE;
            String str2 = this.$address;
            Logger logger2 = logger;
            String tag = logger2.getTAG();
            int depth = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str3 = "removeObserver " + str2;
                String str4 = str3;
                if (str4 != null && str4.length() != 0) {
                    Pair<String, String> trace = logger2.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str5 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    FileLog.print$default(fileLog, 4, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            ViewTypeController.this.setConnectObserver(null);
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.device.OSXViewController
    public void removeObserver(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        BuildersKt__Builders_commonKt.launch$default(this.mainCoroutine, null, null, new AnonymousClass1(address, null), 3, null);
    }

    private final Observer<Integer> addConnectListener(final String address, final Function1<? super String, Unit> action, final String viewType) {
        TWSDevice twsDevice;
        MutableLiveData<Integer> connectedLiveData;
        Observer<Integer> observer = new Observer() { // from class: com.nothing.os.device.xservice.ViewTypeController$$ExternalSyntheticLambda0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ViewTypeController.addConnectListener$lambda$3(this.f$0, address, action, viewType, ((Integer) obj).intValue());
            }
        };
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        if (iOTDeviceByMacAddress != null && (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) != null && (connectedLiveData = twsDevice.getConnectedLiveData()) != null) {
            connectedLiveData.observeForever(observer);
        }
        return observer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addConnectListener$lambda$3(ViewTypeController viewTypeController, String str, Function1 function1, String str2, int i) {
        IOTDevice iOTDeviceByMacAddress;
        TWSDevice twsDevice;
        TWSDeviceBuilder tWSDeviceBuilderBattery;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str3 = "addConnectListener connected Observer  " + i + StringUtils.SPACE + str + StringUtils.SPACE + str2;
            String str4 = str3;
            if (str4 != null && str4.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str5 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                FileLog.print$default(fileLog, 4, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        if (i == 2 && (iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(str)) != null && (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) != null && (tWSDeviceBuilderBattery = TWSDeviceExtKt.battery(twsDevice)) != null) {
            tWSDeviceBuilderBattery.getLiveData();
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderBattery, false, (byte[]) null, 0, 7, (Object) null);
        }
        if (viewTypeController.firstAddObserver.incrementAndGet() > 2) {
            function1.invoke(str2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x020d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x020e  */
    /* JADX WARN: Code duplicated, block: B:55:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:56:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:63:0x0347  */
    /* JADX WARN: Code duplicated, block: B:65:0x0372  */
    /* JADX WARN: Code duplicated, block: B:68:0x03a2  */
    /* JADX WARN: Code duplicated, block: B:75:0x0403  */
    /* JADX WARN: Code duplicated, block: B:77:0x042d A[RETURN] */
    @Override // com.nothing.device.OSXViewController
    public Bundle getTextInfo(Context context, String address, Bundle extras, String textType, boolean autoConnect) {
        String str;
        String str2;
        String str3;
        Bundle bundle;
        boolean z;
        String str4;
        String str5;
        Logger logger;
        String tag;
        int depth;
        TWSDevice tWSDevice;
        String str6;
        String str7;
        String strComponent1;
        String strComponent2;
        Bundle batteryStatus;
        Logger logger2;
        String tag2;
        int depth2;
        String str8;
        String str9;
        String strComponent3;
        String strComponent4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        TWSDevice twsDevice = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null;
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str10 = "getTextInfo textType " + textType + StringUtils.SPACE + address + StringUtils.SPACE + textType + StringUtils.SPACE + autoConnect + " isClassicConnected:" + (twsDevice != null ? Boolean.valueOf(twsDevice.isClassicConnectedWithTimeOut()) : null);
            String str11 = str10;
            if (str11 == null || str11.length() == 0) {
                str = "getTextInfo textType ";
                str2 = "format(...)";
                str3 = StringUtils.SPACE;
                bundle = null;
            } else {
                Pair<String, String> trace = logger3.getTrace(depth3);
                String strComponent5 = trace.component1();
                String strComponent6 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                bundle = null;
                String str12 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                String str13 = str10 + StringUtils.SPACE + strComponent6;
                str = "getTextInfo textType ";
                str2 = "format(...)";
                str3 = StringUtils.SPACE;
                FileLog.print$default(fileLog, 4, str12, tag3, str13, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str10 + str3 + strComponent6);
                }
            }
        } else {
            str = "getTextInfo textType ";
            str2 = "format(...)";
            str3 = StringUtils.SPACE;
            bundle = null;
        }
        boolean zIsSppConnected = isSppConnected(twsDevice);
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true)) {
            String str14 = str + textType + str3 + address + str3 + textType + " \uff1aisSppConnect\uff1a" + zIsSppConnected + " ,autoConnect:" + autoConnect;
            String str15 = str14;
            if (str15 == null || str15.length() == 0) {
                z = autoConnect;
            } else {
                Pair<String, String> trace2 = logger4.getTrace(depth4);
                String strComponent7 = trace2.component1();
                String strComponent8 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str16 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str16, str2);
                twsDevice = twsDevice;
                z = autoConnect;
                str4 = str2;
                FileLog.print$default(fileLog2, 4, str16, tag4, str14 + str3 + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, str14 + str3 + strComponent8);
                }
            }
            if (!Intrinsics.areEqual(textType, "BATTERY")) {
                return bundle;
            }
            if (twsDevice == null && !twsDevice.isConnectedWithTimeOut()) {
                Logger logger5 = Logger.INSTANCE;
                String tag5 = logger5.getTAG();
                int depth5 = logger5.getDepth();
                if (logger5.isCanLogger(true)) {
                    String str17 = "getTextInfo skip BATTERY, spp not connected address=" + address + " autoConnect=" + z + " isSppConnect=" + zIsSppConnected;
                    String str18 = str17;
                    if (str18 != null && str18.length() != 0) {
                        Pair<String, String> trace3 = logger5.getTrace(depth5);
                        String strComponent9 = trace3.component1();
                        String strComponent10 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str19 = logger5.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str19, str4);
                        FileLog.print$default(fileLog3, 4, str19, tag5, str17 + str3 + strComponent10, null, 16, null);
                        if (logger5.isDebug()) {
                            Log.i(tag5 + strComponent9, str17 + str3 + strComponent10);
                        }
                    }
                }
                return bundle;
            }
            str5 = str4;
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                tWSDevice = twsDevice;
                str6 = "getTextInfo twsDevice " + tWSDevice;
                str7 = str6;
                if (str7 != null && str7.length() != 0) {
                    Pair<String, String> trace4 = logger.getTrace(depth);
                    strComponent1 = trace4.component1();
                    strComponent2 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str20 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str20, str5);
                    FileLog.print$default(fileLog4, 4, str20, tag, str6 + str3 + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str6 + str3 + strComponent2);
                    }
                }
            } else {
                tWSDevice = twsDevice;
            }
            if (tWSDevice != null) {
                return bundle;
            }
            TWSDeviceBuilder tWSDeviceBuilderBattery = TWSDeviceExtKt.battery(tWSDevice);
            tWSDeviceBuilderBattery.getLiveData();
            TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderBattery, false, (byte[]) null, 0, 7, (Object) null);
            batteryStatus = XViewServiceImpl.INSTANCE.getInstance(context).getBatteryStatus(context, tWSDevice);
            logger2 = Logger.INSTANCE;
            tag2 = logger2.getTAG();
            depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                str8 = "getTextInfo batteryBundle " + batteryStatus;
                str9 = str8;
                if (str9 != null && str9.length() != 0) {
                    Pair<String, String> trace5 = logger2.getTrace(depth2);
                    strComponent3 = trace5.component1();
                    strComponent4 = trace5.component2();
                    FileLog fileLog5 = FileLog.INSTANCE;
                    String str21 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str21, str5);
                    FileLog.print$default(fileLog5, 4, str21, tag2, str8 + str3 + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str8 + str3 + strComponent4);
                    }
                }
            }
            return batteryStatus;
        }
        z = autoConnect;
        str4 = str2;
        if (!Intrinsics.areEqual(textType, "BATTERY")) {
            return bundle;
        }
        if (twsDevice == null) {
        }
        str5 = str4;
        logger = Logger.INSTANCE;
        tag = logger.getTAG();
        depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            tWSDevice = twsDevice;
        } else {
            tWSDevice = twsDevice;
            str6 = "getTextInfo twsDevice " + tWSDevice;
            str7 = str6;
            if (str7 != null) {
                Pair<String, String> trace6 = logger.getTrace(depth);
                strComponent1 = trace6.component1();
                strComponent2 = trace6.component2();
                FileLog fileLog6 = FileLog.INSTANCE;
                String str22 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str22, str5);
                FileLog.print$default(fileLog6, 4, str22, tag, str6 + str3 + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str6 + str3 + strComponent2);
                }
            }
        }
        if (tWSDevice != null) {
            return bundle;
        }
        TWSDeviceBuilder tWSDeviceBuilderBattery2 = TWSDeviceExtKt.battery(tWSDevice);
        tWSDeviceBuilderBattery2.getLiveData();
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderBattery2, false, (byte[]) null, 0, 7, (Object) null);
        batteryStatus = XViewServiceImpl.INSTANCE.getInstance(context).getBatteryStatus(context, tWSDevice);
        logger2 = Logger.INSTANCE;
        tag2 = logger2.getTAG();
        depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            str8 = "getTextInfo batteryBundle " + batteryStatus;
            str9 = str8;
            if (str9 != null) {
                Pair<String, String> trace7 = logger2.getTrace(depth2);
                strComponent3 = trace7.component1();
                strComponent4 = trace7.component2();
                FileLog fileLog7 = FileLog.INSTANCE;
                String str23 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str23, str5);
                FileLog.print$default(fileLog7, 4, str23, tag2, str8 + str3 + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, str8 + str3 + strComponent4);
                }
            }
        }
        return batteryStatus;
    }

    private final boolean isSppConnected(TWSDevice twsDevice) {
        AtomicInteger lastState;
        Integer numValueOf = null;
        String address = twsDevice != null ? twsDevice.getAddress() : null;
        if (twsDevice == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "isSppConnected " + address + " twsDevice=null -> false";
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
            return false;
        }
        boolean zIsConnectedWithTimeOut = twsDevice.isConnectedWithTimeOut();
        if (zIsConnectedWithTimeOut) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "isSppConnected " + address + " socketConnected=true -> true";
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
            return true;
        }
        XConnector xSppConnector = twsDevice.getSppConnector().getXSppConnector();
        boolean z = xSppConnector != null && xSppConnector.checkIsConnectState();
        if (xSppConnector != null && (lastState = xSppConnector.getLastState()) != null) {
            numValueOf = Integer.valueOf(lastState.get());
        }
        if (z) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str7 = "isSppConnected " + address + " lastStateConnected=true lastState=" + numValueOf + " -> true";
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
            return true;
        }
        Integer value = twsDevice.getCommandCache().getConnectStateLiveData().getValue();
        if (value != null && value.intValue() == 2) {
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true)) {
                String str10 = "isSppConnected " + address + " liveStateConnected=true liveState=" + value + " -> true";
                String str11 = str10;
                if (str11 != null && str11.length() != 0) {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str12 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                    FileLog.print$default(fileLog4, 4, str12, tag4, str10 + StringUtils.SPACE + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag4 + strComponent7, str10 + StringUtils.SPACE + strComponent8);
                    }
                }
            }
            return true;
        }
        Logger logger5 = Logger.INSTANCE;
        String tag5 = logger5.getTAG();
        int depth5 = logger5.getDepth();
        if (logger5.isCanLogger(true)) {
            String str13 = "isSppConnected " + address + " -> false (socketConnected=" + zIsConnectedWithTimeOut + ", lastState=" + numValueOf + ", liveState=" + value + ")";
            String str14 = str13;
            if (str14 != null && str14.length() != 0) {
                Pair<String, String> trace5 = logger5.getTrace(depth5);
                String strComponent9 = trace5.component1();
                String strComponent10 = trace5.component2();
                FileLog fileLog5 = FileLog.INSTANCE;
                String str15 = logger5.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                FileLog.print$default(fileLog5, 4, str15, tag5, str13 + StringUtils.SPACE + strComponent10, null, 16, null);
                if (logger5.isDebug()) {
                    Log.i(tag5 + strComponent9, str13 + StringUtils.SPACE + strComponent10);
                }
            }
        }
        return false;
    }

    @Override // com.nothing.device.OSXViewController
    public String getViewInfo(Context context, String address, Bundle extras, boolean autoConnect) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        if (getType() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "buildGetViewInfo unSupportConnectedInfo " + address;
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
            String strUnSupportConnectedInfo$default = unSupportConnectedInfo$default(this, context, address, false, 4, null);
            return strUnSupportConnectedInfo$default == null ? "" : strUnSupportConnectedInfo$default;
        }
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        TWSDevice twsDevice = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null;
        if (twsDevice != null && twsDevice.isConnectedWithTimeOut()) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "buildGetViewInfo twsDevice isConnected " + address + StringUtils.SPACE + this.isExpand.get() + StringUtils.SPACE;
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
            if (autoConnect) {
                TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(twsDevice, null, 1, null);
                tWSDeviceBuilderNoiseReduction$default.getLiveData();
                TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderNoiseReduction$default, false, (byte[]) null, 0, 7, (Object) null);
                TWSDeviceBuilder tWSDeviceBuilderBattery = TWSDeviceExtKt.battery(twsDevice);
                tWSDeviceBuilderBattery.getLiveData();
                TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderBattery, false, (byte[]) null, 0, 7, (Object) null);
                String string = extras != null ? extras.getString("device_address") : null;
                this.isExpand.set(Intrinsics.areEqual(string, address));
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str7 = "getViewInfo selectMac " + string + " ,currentAddress " + address + ", isExpand  " + this.isExpand.get();
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
            }
            return connectedInfo(context, address, this.isExpand);
        }
        if (twsDevice != null && twsDevice.isClassicConnectedWithTimeOut() && autoConnect) {
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true)) {
                String str10 = "buildGetViewInfo twsDevice isClassicConnectedWithTimeOut " + address;
                String str11 = str10;
                if (str11 != null && str11.length() != 0) {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str12 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                    FileLog.print$default(fileLog4, 4, str12, tag4, str10 + StringUtils.SPACE + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag4 + strComponent7, str10 + StringUtils.SPACE + strComponent8);
                    }
                }
            }
            connectDevice(address);
        }
        Logger logger5 = Logger.INSTANCE;
        String tag5 = logger5.getTAG();
        int depth5 = logger5.getDepth();
        if (logger5.isCanLogger(true)) {
            String str13 = "buildGetViewInfo twsDevice disConnectedInfo " + address;
            String str14 = str13;
            if (str14 != null && str14.length() != 0) {
                Pair<String, String> trace5 = logger5.getTrace(depth5);
                String strComponent9 = trace5.component1();
                String strComponent10 = trace5.component2();
                FileLog fileLog5 = FileLog.INSTANCE;
                String str15 = logger5.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                FileLog.print$default(fileLog5, 4, str15, tag5, str13 + StringUtils.SPACE + strComponent10, null, 16, null);
                if (logger5.isDebug()) {
                    Log.i(tag5 + strComponent9, str13 + StringUtils.SPACE + strComponent10);
                }
            }
        }
        return disConnectedInfo(context, address);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003a  */
    @Override // com.nothing.device.OSXViewController
    public String buildClickViewInfo(Context context, String address, int viewId, ResultInfo resultInfo) {
        TWSDevice tWSDevice;
        String str;
        boolean z;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        if (viewId == R.id.disconnected_content) {
            IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
            TWSDevice twsDevice = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "ANCViewController " + (twsDevice != null ? Boolean.valueOf(twsDevice.isConnectedWithTimeOut()) : null);
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    tWSDevice = twsDevice;
                    z = true;
                    str = "format(...)";
                } else {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    tWSDevice = twsDevice;
                    str = "format(...)";
                    z = true;
                    FileLog.print$default(fileLog, 4, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            } else {
                tWSDevice = twsDevice;
                z = true;
                str = "format(...)";
            }
            BluetoothDevice bluetoothDevice = BluetoothDeviceExtKt.toBluetoothDevice(address);
            if (bluetoothDevice != null && !BluetoothDeviceExtKt.isBondedState(bluetoothDevice)) {
                return connectingInfo(context, address);
            }
            if (tWSDevice != null && !tWSDevice.isConnectedWithTimeOut()) {
                connectDevice(address);
                return connectingInfo(context, address);
            }
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(z) && "click content ,then connected".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str5 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, str);
                FileLog.print$default(fileLog2, 4, str5, tag2, "click content ,then connected " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "click content ,then connected " + strComponent4);
                }
            }
            if (getType() == 0) {
                return unSupportConnectedInfo(context, address, z);
            }
            return clickConnectedInfo(context, address, resultInfo, viewId);
        }
        if (getType() == 0) {
            return unSupportConnectedInfo$default(this, context, address, false, 4, null);
        }
        return clickConnectedInfo(context, address, resultInfo, viewId);
    }

    private final void connectDevice(String address) {
        TWSDevice twsDevice;
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        if (iOTDeviceByMacAddress == null || (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) == null) {
            return;
        }
        TWSDevice.connectWithTimeout$default(twsDevice, false, 1, null);
    }

    public final int setNoiseMode(String address, int lastSelectLevel) {
        TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default;
        LiveData<Message> liveData;
        byte[] payload;
        Object obj;
        Intrinsics.checkNotNullParameter(address, "address");
        this.isClick.set(true);
        Job job = this.clickJob;
        DeviceNoiseReduction deviceNoiseReduction = null;
        objNewInstance = null;
        objNewInstance = null;
        objNewInstance = null;
        objNewInstance = null;
        Object objNewInstance = null;
        deviceNoiseReduction = null;
        deviceNoiseReduction = null;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        TWSDevice twsDevice = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null;
        if (twsDevice != null && (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(twsDevice, null, 1, null)) != null && (liveData = tWSDeviceBuilderNoiseReduction$default.getLiveData()) != null) {
            TWSDeviceBuilder.Companion companion = TWSDeviceBuilder.INSTANCE;
            Message value = liveData.getValue();
            if (value != null && (payload = value.getPayload()) != null) {
                try {
                    if (Intrinsics.areEqual(DeviceNoiseReduction.class, Integer.TYPE)) {
                        obj = (DeviceNoiseReduction) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                    } else if (Intrinsics.areEqual(DeviceNoiseReduction.class, Long.TYPE)) {
                        obj = (DeviceNoiseReduction) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                    } else if (Intrinsics.areEqual(DeviceNoiseReduction.class, String.class)) {
                        Object objDecodeToString = StringsKt.decodeToString(payload);
                        if (objDecodeToString == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.nothing.earbase.anc.entity.DeviceNoiseReduction");
                        }
                        obj = (DeviceNoiseReduction) objDecodeToString;
                    } else if (Intrinsics.areEqual(DeviceNoiseReduction.class, Boolean.TYPE)) {
                        obj = (DeviceNoiseReduction) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                    } else if (Intrinsics.areEqual(DeviceNoiseReduction.class, Float.TYPE)) {
                        obj = (DeviceNoiseReduction) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                    } else {
                        try {
                            objNewInstance = DeviceNoiseReduction.class.getConstructor(byte[].class).newInstance(payload);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        obj = objNewInstance;
                    }
                    objNewInstance = obj;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "parseLiveData " + DeviceNoiseReduction.class + StringUtils.SPACE + objNewInstance + StringUtils.SPACE;
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
            deviceNoiseReduction = (DeviceNoiseReduction) objNewInstance;
        }
        this.clickJob = BuildersKt__Builders_commonKt.launch$default(getCoroutineIOScope(), null, null, new C10481(twsDevice, lastSelectLevel == -1 ? 1 : lastSelectLevel, this, deviceNoiseReduction, null), 3, null);
        return lastSelectLevel;
    }

    /* JADX INFO: renamed from: com.nothing.os.device.xservice.ViewTypeController$setNoiseMode$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: ViewTypeController.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.os.device.xservice.ViewTypeController$setNoiseMode$1", f = "ViewTypeController.kt", i = {0, 0}, l = {582, 342}, m = "invokeSuspend", n = {"this_$iv", "needUpdate$iv"}, s = {"L$0", "I$0"})
    static final class C10481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DeviceNoiseReduction $deviceNoiseReduction;
        final /* synthetic */ int $level;
        final /* synthetic */ TWSDevice $twsDevice;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ ViewTypeController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10481(TWSDevice tWSDevice, int i, ViewTypeController viewTypeController, DeviceNoiseReduction deviceNoiseReduction, Continuation<? super C10481> continuation) {
            super(2, continuation);
            this.$twsDevice = tWSDevice;
            this.$level = i;
            this.this$0 = viewTypeController;
            this.$deviceNoiseReduction = deviceNoiseReduction;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C10481(this.$twsDevice, this.$level, this.this$0, this.$deviceNoiseReduction, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:42:0x00ef, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(2000, r20) == r1) goto L43;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderNoiseReduction;
            int i;
            Object objSyncSetResponse$default;
            TWSDeviceBuilder tWSDeviceBuilder;
            DeviceNoiseReduction deviceNoiseReduction;
            int i2;
            TWSDeviceBuilder tWSDeviceBuilderNoiseReduction$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = this.$twsDevice;
                if (tWSDevice == null || (tWSDeviceBuilderNoiseReduction = TWSDeviceExtKt.noiseReduction(tWSDevice, Boxing.boxInt(this.$level))) == null) {
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                } else {
                    DeviceNoiseReduction deviceNoiseReduction2 = this.$deviceNoiseReduction;
                    i = this.$level;
                    int setCommand = tWSDeviceBuilderNoiseReduction.getSetCommand();
                    this.L$0 = tWSDeviceBuilderNoiseReduction;
                    this.L$1 = deviceNoiseReduction2;
                    this.I$0 = 0;
                    this.I$1 = i;
                    this.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderNoiseReduction.getTwsDevice(), setCommand, tWSDeviceBuilderNoiseReduction.getSetPayload(), tWSDeviceBuilderNoiseReduction.getTimeOut(), tWSDeviceBuilderNoiseReduction.getIsNeedFsn(), false, tWSDeviceBuilderNoiseReduction.getMockResponse(), this, 16, null);
                    if (objSyncSetResponse$default != coroutine_suspended) {
                        tWSDeviceBuilder = tWSDeviceBuilderNoiseReduction;
                        deviceNoiseReduction = deviceNoiseReduction2;
                        i2 = 0;
                    }
                }
                return coroutine_suspended;
            }
            if (i3 == 1) {
                i = this.I$1;
                int i4 = this.I$0;
                DeviceNoiseReduction deviceNoiseReduction3 = (DeviceNoiseReduction) this.L$1;
                TWSDeviceBuilder tWSDeviceBuilder2 = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                tWSDeviceBuilder = tWSDeviceBuilder2;
                deviceNoiseReduction = deviceNoiseReduction3;
                i2 = i4;
                objSyncSetResponse$default = obj;
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.getIsClick().set(false);
            Logger logger = Logger.INSTANCE;
            Logger logger2 = Logger.INSTANCE;
            Logger logger3 = logger;
            String tag = logger3.getTAG();
            int depth = logger3.getDepth();
            if (logger3.isCanLogger(true) && "setNoiseMode sendMessage".length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "setNoiseMode sendMessage " + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, "setNoiseMode sendMessage " + strComponent2);
                }
            }
            TWSDevice tWSDevice2 = this.$twsDevice;
            if (tWSDevice2 != null && (tWSDeviceBuilderNoiseReduction$default = TWSDeviceExtKt.noiseReduction$default(tWSDevice2, null, 1, null)) != null) {
                TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderNoiseReduction$default, false, (byte[]) null, 0, 7, (Object) null);
            }
            return Unit.INSTANCE;
            Message message = (Message) objSyncSetResponse$default;
            if (message != null && message.isOk()) {
                LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
                if (deviceNoiseReduction != null) {
                    deviceNoiseReduction.updateLastNoiseReductionLevel(i);
                }
                byte[] bArrObtainDataPacket = deviceNoiseReduction != null ? deviceNoiseReduction.obtainDataPacket() : null;
                Message message2 = (Message) liveDataCommand$default.getValue();
                if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                    tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrObtainDataPacket);
                    if (message2 != null) {
                        message2.setPayload(bArrObtainDataPacket);
                        if (i2 != 0) {
                            tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message2);
                        }
                    }
                }
                Boxing.boxBoolean(true);
            } else {
                Boxing.boxBoolean(false);
            }
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
        }
    }

    public static /* synthetic */ String unSupportConnectedInfo$default(ViewTypeController viewTypeController, Context context, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unSupportConnectedInfo");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return viewTypeController.unSupportConnectedInfo(context, str, z);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x006f  */
    /* JADX WARN: Code duplicated, block: B:78:0x02f5  */
    /* JADX WARN: Code duplicated, block: B:80:0x02fc  */
    /* JADX WARN: Code duplicated, block: B:81:0x02fe  */
    public final String unSupportConnectedInfo(Context context, String address, boolean isClick) throws JSONException {
        String str;
        CardInfo cardInfo;
        String deviceName;
        boolean z;
        ViewTypeController viewTypeController;
        BluetoothDevice bluetoothDevice;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        TWSDevice twsDevice = iOTDeviceByMacAddress != null ? iOTDeviceByMacAddress.getTwsDevice() : null;
        if (twsDevice != null && twsDevice.isConnectedWithTimeOut() && isClick) {
            ContextExtKt.startToSettingDetail(context, address);
            return null;
        }
        String str2 = context.getApplicationContext().getPackageName() + ".ui.event.provider.authority";
        int i2 = R.layout.os_anc_default_view;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        CardInfo cardInfo2 = new CardInfo(i2, packageName, str2, 0, 8, null);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str3 = "unknown_widget_systemui unSupportConnectedInfo address:" + address;
            String str4 = str3;
            if (str4 == null || str4.length() == 0) {
                cardInfo = cardInfo2;
                str = "format(...)";
            } else {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str5 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                str = "format(...)";
                cardInfo = cardInfo2;
                FileLog.print$default(fileLog, 4, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                }
            }
        } else {
            cardInfo = cardInfo2;
            str = "format(...)";
        }
        ImageInfo imageInfo = new ImageInfo(R.id.disconnected_icon_title, null, 2, null);
        IOTDevice iOTDeviceByMacAddress2 = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        if ((iOTDeviceByMacAddress2 instanceof UnknownDevice) || (iOTDeviceByMacAddress2 instanceof NewSkuDevice)) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "unknown_widget_systemui unSupportConnectedInfo is Unknown device".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str6 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, str);
                FileLog.print$default(fileLog2, 3, str6, tag2, "unknown_widget_systemui unSupportConnectedInfo is Unknown device " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "unknown_widget_systemui unSupportConnectedInfo is Unknown device " + strComponent4);
                }
            }
            Pair<Uri, Integer> newsEarImage = ((DeviceEarImage) iOTDeviceByMacAddress2).getNewsEarImage(DeviceEarImage.DISCONNECT_EAR_IMAGE);
            if (newsEarImage.getFirst() != null) {
                Uri first = newsEarImage.getFirst();
                Intrinsics.checkNotNull(first);
                imageInfo.setImageURI(first);
            } else {
                imageInfo.setImageResource(newsEarImage.getSecond().intValue());
            }
        } else {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "unknown_widget_systemui unSupportConnectedInfo is not Unknown device".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str7 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str7, str);
                FileLog.print$default(fileLog3, 3, str7, tag3, "unknown_widget_systemui unSupportConnectedInfo is not Unknown device " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, "unknown_widget_systemui unSupportConnectedInfo is not Unknown device " + strComponent6);
                }
            }
            IOTDevice iOTDeviceByMacAddress3 = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
            imageInfo.setImageResource(iOTDeviceByMacAddress3 != null ? iOTDeviceByMacAddress3.getOsDisconnectedImage() : 0);
        }
        if (twsDevice == null || (deviceName = twsDevice.getDeviceName()) == null) {
            deviceName = "";
        }
        TextViewInfo textViewInfo = new TextViewInfo(R.id.title, null, 2, null);
        String str8 = deviceName;
        if (str8.length() == 0) {
            textViewInfo.setText(address);
        } else {
            textViewInfo.setText(str8);
        }
        textViewInfo.setAlpha(1.0f);
        TextViewInfo textViewInfo2 = new TextViewInfo(R.id.summary, null, 2, null);
        int i3 = 8;
        if (twsDevice != null) {
            z = true;
            if (twsDevice.isConnectedWithTimeOut()) {
                viewTypeController = this;
                textViewInfo2.setText(viewTypeController.getSubTitle(twsDevice, context));
                textViewInfo2.setVisibility(0);
            }
            textViewInfo2.setAlpha(1.0f);
            TextViewInfo textViewInfo3 = new TextViewInfo(R.id.action_view, null, 2, null);
            bluetoothDevice = BluetoothDeviceExtKt.toBluetoothDevice(address);
            if (bluetoothDevice != null) {
                i = 1;
                if (BluetoothDeviceExtKt.isBondedState(bluetoothDevice)) {
                    i3 = 0;
                }
            } else {
                i = 1;
            }
            textViewInfo3.setVisibility(i3);
            ViewInfo[] viewInfoArr = new ViewInfo[4];
            viewInfoArr[0] = textViewInfo;
            viewInfoArr[i] = textViewInfo2;
            viewInfoArr[2] = imageInfo;
            viewInfoArr[3] = textViewInfo3;
            CardInfo cardInfo3 = cardInfo;
            cardInfo3.setViewInfo(viewInfoArr);
            ActionInfo[] actionInfoArr = new ActionInfo[i];
            ActionInfo actionInfo = new ActionInfo(R.id.disconnected_content);
            actionInfo.setOnClickListener(new ResultInfo());
            Unit unit = Unit.INSTANCE;
            actionInfoArr[0] = actionInfo;
            cardInfo3.setActionInfo(actionInfoArr);
            ActionInfo[] actionInfoArr2 = new ActionInfo[i];
            ActionInfo actionInfo2 = new ActionInfo(R.id.disconnected_icon_title);
            actionInfo2.setOnClickListener(new ResultInfo());
            Unit unit2 = Unit.INSTANCE;
            actionInfoArr2[0] = actionInfo2;
            cardInfo3.setActionInfo(actionInfoArr2);
            ActionInfo[] actionInfoArr3 = new ActionInfo[i];
            ActionInfo actionInfo3 = new ActionInfo(R.id.action_view);
            actionInfo3.setOnClickListener(viewTypeController.detailPendingIntentInfo(address));
            Unit unit3 = Unit.INSTANCE;
            actionInfoArr3[0] = actionInfo3;
            cardInfo3.setActionInfo(actionInfoArr3);
            return cardInfo3.build();
        }
        z = true;
        viewTypeController = this;
        if (twsDevice != null && twsDevice.isClassicConnectedWithTimeOut() == z) {
            String string = context.getString(R.string.connected);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textViewInfo2.setText(string);
            textViewInfo2.setVisibility(0);
        } else {
            textViewInfo2.setVisibility(8);
        }
        textViewInfo2.setAlpha(1.0f);
        TextViewInfo textViewInfo4 = new TextViewInfo(R.id.action_view, null, 2, null);
        bluetoothDevice = BluetoothDeviceExtKt.toBluetoothDevice(address);
        if (bluetoothDevice != null) {
            i = 1;
            if (BluetoothDeviceExtKt.isBondedState(bluetoothDevice)) {
                i3 = 0;
            }
        } else {
            i = 1;
        }
        textViewInfo4.setVisibility(i3);
        ViewInfo[] viewInfoArr2 = new ViewInfo[4];
        viewInfoArr2[0] = textViewInfo;
        viewInfoArr2[i] = textViewInfo2;
        viewInfoArr2[2] = imageInfo;
        viewInfoArr2[3] = textViewInfo4;
        CardInfo cardInfo4 = cardInfo;
        cardInfo4.setViewInfo(viewInfoArr2);
        ActionInfo[] actionInfoArr4 = new ActionInfo[i];
        ActionInfo actionInfo4 = new ActionInfo(R.id.disconnected_content);
        actionInfo4.setOnClickListener(new ResultInfo());
        Unit unit4 = Unit.INSTANCE;
        actionInfoArr4[0] = actionInfo4;
        cardInfo4.setActionInfo(actionInfoArr4);
        ActionInfo[] actionInfoArr5 = new ActionInfo[i];
        ActionInfo actionInfo5 = new ActionInfo(R.id.disconnected_icon_title);
        actionInfo5.setOnClickListener(new ResultInfo());
        Unit unit5 = Unit.INSTANCE;
        actionInfoArr5[0] = actionInfo5;
        cardInfo4.setActionInfo(actionInfoArr5);
        ActionInfo[] actionInfoArr6 = new ActionInfo[i];
        ActionInfo actionInfo6 = new ActionInfo(R.id.action_view);
        actionInfo6.setOnClickListener(viewTypeController.detailPendingIntentInfo(address));
        Unit unit6 = Unit.INSTANCE;
        actionInfoArr6[0] = actionInfo6;
        cardInfo4.setActionInfo(actionInfoArr6);
        return cardInfo4.build();
    }

    public final String getSubTitle(TWSDevice twsDevice, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String earBatteryText = XViewServiceImpl.INSTANCE.getInstance(context).getEarBatteryText(context, twsDevice);
        if (earBatteryText != null) {
            return earBatteryText;
        }
        String string = context.getString(R.string.connected);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    public final String disConnectedInfo(Context context, String address) throws JSONException {
        String deviceName;
        int i;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        String str = context.getApplicationContext().getPackageName() + ".ui.event.provider.authority";
        int i2 = R.layout.os_anc_default_view;
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        CardInfo cardInfo = new CardInfo(i2, packageName, str, 0, 8, null);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "disConnectedInfo address:" + address;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str4 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog, 4, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        ImageInfo imageInfo = new ImageInfo(R.id.disconnected_icon_title, null, 2, null);
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true) && "unknown_widget_systemui disConnectedInfo viewType".length() != 0) {
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str5 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            FileLog.print$default(fileLog2, 3, str5, tag2, "unknown_widget_systemui disConnectedInfo viewType " + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, "unknown_widget_systemui disConnectedInfo viewType " + strComponent4);
            }
        }
        if ((iOTDeviceByMacAddress instanceof UnknownDevice) || (iOTDeviceByMacAddress instanceof NewSkuDevice)) {
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "unknown_widget_systemui disConnectedInfo is Unknown device".length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str6 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                FileLog.print$default(fileLog3, 3, str6, tag3, "unknown_widget_systemui disConnectedInfo is Unknown device " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, "unknown_widget_systemui disConnectedInfo is Unknown device " + strComponent6);
                }
            }
            Pair<Uri, Integer> newsEarImage = ((DeviceEarImage) iOTDeviceByMacAddress).getNewsEarImage(DeviceEarImage.DISCONNECT_EAR_IMAGE);
            if (newsEarImage.getFirst() != null) {
                Uri first = newsEarImage.getFirst();
                Intrinsics.checkNotNull(first);
                imageInfo.setImageURI(first);
            } else {
                imageInfo.setImageResource(newsEarImage.getSecond().intValue());
            }
        } else {
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true) && "unknown_widget_systemui disConnectedInfo is not Unknown device".length() != 0) {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str7 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                FileLog.print$default(fileLog4, 3, str7, tag4, "unknown_widget_systemui disConnectedInfo is not Unknown device " + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, "unknown_widget_systemui disConnectedInfo is not Unknown device " + strComponent8);
                }
            }
            IOTDevice iOTDeviceByMacAddress2 = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
            imageInfo.setImageResource(iOTDeviceByMacAddress2 != null ? iOTDeviceByMacAddress2.getOsDisconnectedImage() : 0);
        }
        IOTDevice iOTDeviceByMacAddress3 = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        TWSDevice twsDevice = iOTDeviceByMacAddress3 != null ? iOTDeviceByMacAddress3.getTwsDevice() : null;
        if (twsDevice == null || (deviceName = twsDevice.getDeviceName()) == null) {
            deviceName = address;
        }
        TextViewInfo textViewInfo = new TextViewInfo(R.id.title, null, 2, null);
        String str8 = deviceName;
        if (str8.length() == 0) {
            textViewInfo.setText(address);
        } else {
            textViewInfo.setText(str8);
        }
        textViewInfo.setAlpha(1.0f);
        TextViewInfo textViewInfo2 = new TextViewInfo(R.id.summary, null, 2, null);
        textViewInfo2.setAlpha(1.0f);
        if (twsDevice != null && twsDevice.isClassicConnectedWithTimeOut()) {
            textViewInfo2.setVisibility(0);
            String string = context.getString(R.string.connected);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            textViewInfo2.setText(string);
        }
        TextViewInfo textViewInfo3 = new TextViewInfo(R.id.action_view, null, 2, null);
        BluetoothDevice bluetoothDevice = BluetoothDeviceExtKt.toBluetoothDevice(address);
        if (bluetoothDevice != null) {
            i = 1;
            int i3 = BluetoothDeviceExtKt.isBondedState(bluetoothDevice) ? 0 : 8;
            textViewInfo3.setVisibility(i3);
            ViewInfo[] viewInfoArr = new ViewInfo[4];
            viewInfoArr[0] = textViewInfo;
            viewInfoArr[i] = textViewInfo2;
            viewInfoArr[2] = imageInfo;
            viewInfoArr[3] = textViewInfo3;
            cardInfo.setViewInfo(viewInfoArr);
            ActionInfo[] actionInfoArr = new ActionInfo[i];
            ActionInfo actionInfo = new ActionInfo(R.id.disconnected_content);
            actionInfo.setOnClickListener(new ResultInfo());
            Unit unit = Unit.INSTANCE;
            actionInfoArr[0] = actionInfo;
            cardInfo.setActionInfo(actionInfoArr);
            ActionInfo[] actionInfoArr2 = new ActionInfo[i];
            ActionInfo actionInfo2 = new ActionInfo(R.id.action_view);
            actionInfo2.setOnClickListener(detailPendingIntentInfo(address));
            Unit unit2 = Unit.INSTANCE;
            actionInfoArr2[0] = actionInfo2;
            cardInfo.setActionInfo(actionInfoArr2);
            return cardInfo.build();
        }
        i = 1;
        textViewInfo3.setVisibility(i3);
        ViewInfo[] viewInfoArr2 = new ViewInfo[4];
        viewInfoArr2[0] = textViewInfo;
        viewInfoArr2[i] = textViewInfo2;
        viewInfoArr2[2] = imageInfo;
        viewInfoArr2[3] = textViewInfo3;
        cardInfo.setViewInfo(viewInfoArr2);
        ActionInfo[] actionInfoArr3 = new ActionInfo[i];
        ActionInfo actionInfo3 = new ActionInfo(R.id.disconnected_content);
        actionInfo3.setOnClickListener(new ResultInfo());
        Unit unit3 = Unit.INSTANCE;
        actionInfoArr3[0] = actionInfo3;
        cardInfo.setActionInfo(actionInfoArr3);
        ActionInfo[] actionInfoArr4 = new ActionInfo[i];
        ActionInfo actionInfo4 = new ActionInfo(R.id.action_view);
        actionInfo4.setOnClickListener(detailPendingIntentInfo(address));
        Unit unit4 = Unit.INSTANCE;
        actionInfoArr4[0] = actionInfo4;
        cardInfo.setActionInfo(actionInfoArr4);
        return cardInfo.build();
    }

    public final CardInfo createCardInfo(Context context, int resId) {
        Intrinsics.checkNotNullParameter(context, "context");
        String packageName = context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return new CardInfo(resId, packageName, context.getApplicationContext().getPackageName() + ".ui.event.provider.authority", 0, 8, null);
    }

    public final String connectingInfo(Context context, String address) throws JSONException {
        String deviceName;
        int i;
        TWSDevice twsDevice;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(address, "address");
        CardInfo cardInfoCreateCardInfo = createCardInfo(context, R.layout.os_anc_default_view);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "connectingInfo address:" + address;
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
        IOTDevice iOTDeviceByMacAddress = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        if (iOTDeviceByMacAddress == null || (twsDevice = iOTDeviceByMacAddress.getTwsDevice()) == null || (deviceName = twsDevice.getDeviceName()) == null) {
            deviceName = address;
        }
        ImageInfo imageInfo = new ImageInfo(R.id.disconnected_icon_title, null, 2, null);
        IOTDevice iOTDeviceByMacAddress2 = IOTDeviceManager.INSTANCE.getIOTDeviceByMacAddress(address);
        imageInfo.setImageResource(iOTDeviceByMacAddress2 != null ? iOTDeviceByMacAddress2.getOsDisconnectedImage() : 0);
        TextViewInfo textViewInfo = new TextViewInfo(R.id.title, null, 2, null);
        String str4 = deviceName;
        if (str4.length() == 0) {
            textViewInfo.setText(address);
        } else {
            textViewInfo.setText(str4);
        }
        textViewInfo.setAlpha(0.33f);
        TextViewInfo textViewInfo2 = new TextViewInfo(R.id.summary, null, 2, null);
        String string = context.getString(R.string.connecting);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        textViewInfo2.setText(string);
        textViewInfo2.setAlpha(0.33f);
        textViewInfo2.setVisibility(0);
        TextViewInfo textViewInfo3 = new TextViewInfo(R.id.action_view, null, 2, null);
        BluetoothDevice bluetoothDevice = BluetoothDeviceExtKt.toBluetoothDevice(address);
        if (bluetoothDevice != null) {
            i = 1;
            int i2 = BluetoothDeviceExtKt.isBondedState(bluetoothDevice) ? 0 : 8;
            textViewInfo3.setVisibility(i2);
            ViewInfo[] viewInfoArr = new ViewInfo[4];
            viewInfoArr[0] = textViewInfo;
            viewInfoArr[i] = textViewInfo2;
            viewInfoArr[2] = imageInfo;
            viewInfoArr[3] = textViewInfo3;
            cardInfoCreateCardInfo.setViewInfo(viewInfoArr);
            ActionInfo[] actionInfoArr = new ActionInfo[i];
            ActionInfo actionInfo = new ActionInfo(R.id.action_view);
            actionInfo.setOnClickListener(detailPendingIntentInfo(address));
            Unit unit = Unit.INSTANCE;
            actionInfoArr[0] = actionInfo;
            cardInfoCreateCardInfo.setActionInfo(actionInfoArr);
            return cardInfoCreateCardInfo.build();
        }
        i = 1;
        textViewInfo3.setVisibility(i2);
        ViewInfo[] viewInfoArr2 = new ViewInfo[4];
        viewInfoArr2[0] = textViewInfo;
        viewInfoArr2[i] = textViewInfo2;
        viewInfoArr2[2] = imageInfo;
        viewInfoArr2[3] = textViewInfo3;
        cardInfoCreateCardInfo.setViewInfo(viewInfoArr2);
        ActionInfo[] actionInfoArr2 = new ActionInfo[i];
        ActionInfo actionInfo2 = new ActionInfo(R.id.action_view);
        actionInfo2.setOnClickListener(detailPendingIntentInfo(address));
        Unit unit2 = Unit.INSTANCE;
        actionInfoArr2[0] = actionInfo2;
        cardInfoCreateCardInfo.setActionInfo(actionInfoArr2);
        return cardInfoCreateCardInfo.build();
    }
}
