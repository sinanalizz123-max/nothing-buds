package com.nothing.nt_ble.plugin;

import android.bluetooth.BluetoothGatt;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.generate.BluetoothInfo;
import com.nothing.generate.NtBleConnectState;
import com.nothing.generate.NtBleDevice;
import com.nothing.generate.NtBleFlutterApi;
import com.nothing.generate.NtBleScanSet;
import com.nothing.generate.NtBleService;
import com.nothing.generate.NtBtProfile;
import com.nothing.generate.NtChannelPriority;
import com.nothing.generate.NtConnectType;
import com.nothing.generate.NtDeviceType;
import com.nothing.generate.NtSendKey;
import com.nothing.generate.NtSppService;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector;
import com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector;
import com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector;
import com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector;
import com.nothing.link.bluetooth.sdk.connect.spp.XSppConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.link.bluetooth.sdk.scan.XBluetoothFlowCallBack;
import com.nothing.link.bluetooth.sdk.task.XCommonTaskCallback;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.nt_ble.NothingWatchCommandParser;
import com.nothing.nt_ble.ext.NBleDeviceExtKt;
import com.nothing.nt_ble.ext.NtBtProfileExtKt;
import com.nothing.nt_ble.ext.NtConnectorExtKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: NothingWatchPluginImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010%\u001a\u00020&2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J \u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020&2\b\u00100\u001a\u0004\u0018\u00010\u001aJ\u001c\u00101\u001a\u00020\u001a2\b\u00100\u001a\u0004\u0018\u00010\u001a2\b\u00102\u001a\u0004\u0018\u00010\u001aH\u0002J\u001a\u00103\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u00104\u001a\u00020\u001bH\u0002Jh\u00105\u001a\u00020&2\u0006\u00100\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u0002072\u0006\u0010*\u001a\u00020+2\u001e\u0010@\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002070C0B\u0012\u0004\u0012\u00020&0AH\u0016J8\u0010D\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010E\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u0010?\u001a\u000207H\u0016J2\u0010F\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00072\u0018\u0010@\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0B\u0012\u0004\u0012\u00020&0AH\u0016J2\u0010H\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010G\u001a\u00020\u00072\u0018\u0010@\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0B\u0012\u0004\u0012\u00020&0AH\u0016JM\u0010I\u001a\u00020&2\u0006\u0010J\u001a\u00020\u001a2\u0006\u0010K\u001a\u00020\u001a2\u0006\u0010L\u001a\u00020\u001a2\b\b\u0002\u0010?\u001a\u0002072\b\b\u0002\u00104\u001a\u00020\u001b2\u0017\u0010@\u001a\u0013\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020&0A\u00a2\u0006\u0002\bNH\u0002J\f\u0010O\u001a\u00020\u001a*\u0004\u0018\u00010\u001aJ,\u0010P\u001a\u00020&2\u0006\u00100\u001a\u00020\u001a2\u001a\u0010@\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010Q0B\u0012\u0004\u0012\u00020&0AH\u0016JJ\u0010R\u001a\u00020&2\u0006\u00100\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010S\u001a\u00020T2\u0018\u0010@\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0B\u0012\u0004\u0012\u00020&0AH\u0016JJ\u0010U\u001a\u00020&2\u0006\u00100\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\u0006\u0010V\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010S\u001a\u00020T2\u0018\u0010@\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0B\u0012\u0004\u0012\u00020&0AH\u0016J \u0010W\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010:\u001a\u00020;2\u0006\u0010(\u001a\u00020)H\u0016J:\u0010X\u001a\u00020&2\u0006\u00100\u001a\u00020\u001a2\u0006\u0010V\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0018\u0010@\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0B\u0012\u0004\u0012\u00020&0AH\u0016J*\u0010Y\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0018\u0010@\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002070B\u0012\u0004\u0012\u00020&0AH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R6\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b`\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R6\u0010!\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\"0\u0019j\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\"`\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 \u00a8\u0006Z"}, d2 = {"Lcom/nothing/nt_ble/plugin/NothingWatchPluginImpl;", "Lcom/nothing/nt_ble/plugin/UnknownImpl;", "<init>", "()V", "watchCommandParser", "Lcom/nothing/nt_ble/NothingWatchCommandParser;", "dataService", "Lcom/nothing/generate/NtBleService;", "getDataService", "()Lcom/nothing/generate/NtBleService;", "setDataService", "(Lcom/nothing/generate/NtBleService;)V", "sppService", "Lcom/nothing/generate/NtSppService;", "getSppService", "()Lcom/nothing/generate/NtSppService;", "setSppService", "(Lcom/nothing/generate/NtSppService;)V", "flutterApi", "Lcom/nothing/generate/NtBleFlutterApi;", "getFlutterApi", "()Lcom/nothing/generate/NtBleFlutterApi;", "setFlutterApi", "(Lcom/nothing/generate/NtBleFlutterApi;)V", "channelMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getChannelMap", "()Ljava/util/HashMap;", "setChannelMap", "(Ljava/util/HashMap;)V", "mtuMap", "", "getMtuMap", "setMtuMap", "initPlugin", "", "connect", "connectType", "Lcom/nothing/generate/NtConnectType;", "device", "Lcom/nothing/generate/NtBleDevice;", "set", "Lcom/nothing/generate/NtBleScanSet;", DeviceEarImage.DISCONNECT_EAR_IMAGE, "clearNotifyChannelCache", "realMac", "notifyChannelKey", "notifyIdentity", "updateChannelStatus", "enable", "writeValueSync", "timeout", "", "deviceType", "Lcom/nothing/generate/NtDeviceType;", "sendKey", "Lcom/nothing/generate/NtSendKey;", MimeTypesReaderMetKeys.MAGIC_PRIORITY_ATTR, "Lcom/nothing/generate/NtChannelPriority;", "value", "interval", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "", "writeValue", "key", "startNotify", NotificationCompat.CATEGORY_SERVICE, "stopNotify", "enableNotification", "address", "serviceUUID", "notifyUUID", "Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskCallback;", "Lkotlin/ExtensionFunctionType;", "toUUID", "getBluetoothAlias", "Lcom/nothing/generate/BluetoothInfo;", "connectSync", "profile", "Lcom/nothing/generate/NtBtProfile;", "turnOnSpp", "type", "disconnectByType", "turnOffSpp", "mtuSize", "nt_ble_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NothingWatchPluginImpl extends UnknownImpl {
    private NtBleFlutterApi flutterApi;
    private final NothingWatchCommandParser watchCommandParser = new NothingWatchCommandParser();
    private NtBleService dataService = new NtBleService("fff0", "fff1", "fff2");
    private NtSppService sppService = new NtSppService("AEAC4A03-DFF5-498F-843A-34487CF133EB", "00006666-0000-1000-8000-00805F9B34FB", "0000CCAA-0000-1000-8000-00805F9B34FB", "00001101-0000-1000-8000-00805F9B34FB");
    private HashMap<String, Boolean> channelMap = new HashMap<>();
    private HashMap<String, Integer> mtuMap = new HashMap<>();

    /* JADX INFO: compiled from: NothingWatchPluginImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NtConnectType.values().length];
            try {
                iArr[NtConnectType.BT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NtConnectType.SPP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NtConnectType.BLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final NtBleService getDataService() {
        return this.dataService;
    }

    public final void setDataService(NtBleService ntBleService) {
        Intrinsics.checkNotNullParameter(ntBleService, "<set-?>");
        this.dataService = ntBleService;
    }

    public final NtSppService getSppService() {
        return this.sppService;
    }

    public final void setSppService(NtSppService ntSppService) {
        Intrinsics.checkNotNullParameter(ntSppService, "<set-?>");
        this.sppService = ntSppService;
    }

    public final NtBleFlutterApi getFlutterApi() {
        return this.flutterApi;
    }

    public final void setFlutterApi(NtBleFlutterApi ntBleFlutterApi) {
        this.flutterApi = ntBleFlutterApi;
    }

    public final HashMap<String, Boolean> getChannelMap() {
        return this.channelMap;
    }

    public final void setChannelMap(HashMap<String, Boolean> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.channelMap = map;
    }

    public final HashMap<String, Integer> getMtuMap() {
        return this.mtuMap;
    }

    public final void setMtuMap(HashMap<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.mtuMap = map;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.nt_ble.plugin.PluginImpl
    public void initPlugin(NtBleFlutterApi flutterApi) {
        this.flutterApi = flutterApi;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void connect(final NtConnectType connectType, final NtBleDevice device, NtBleScanSet set) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(set, "set");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] watch connect connectType\uff1a" + connectType + " ,device:" + device.getRealMac() + ",deviceType:" + device.getDeviceType() + ",fastpairId:" + device.getFastPairID() + "!";
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
        String realMac = device.getRealMac();
        int i = WhenMappings.$EnumSwitchMapping$0[connectType.ordinal()];
        if (i == 1) {
            XBTConnector xBTConnectorBt = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(realMac)).bt();
            Long timeout = set.getTimeout();
            Long lValueOf = Long.valueOf((timeout != null ? timeout.longValue() : 4L) * ((long) 1000));
            Long androidTransport = set.getAndroidTransport();
            XBTConnector.connect$default(xBTConnectorBt, lValueOf, 3, 1, Integer.valueOf(androidTransport != null ? (int) androidTransport.longValue() : 1), new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$28(this.f$0, device, connectType, (XConnectCallback) obj);
                }
            }, null, 32, null);
            return;
        }
        if (i == 2) {
            String dialIdentity = this.sppService.getDialIdentity();
            if (dialIdentity == null) {
                dialIdentity = "";
            }
            XSppConnector xSppConnectorSpp$default = XConnectorDevice.spp$default(XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(realMac)), dialIdentity, null, 0, this.watchCommandParser, 6, null);
            xSppConnectorSpp$default.setDeviceConnectCallback("watch_spp", new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NothingWatchPluginImpl.connect$lambda$34$lambda$33(this.f$0, connectType, device, ((Integer) obj).intValue(), (XConnectFailType) obj2);
                }
            });
            XConnector.connect$default(xSppConnectorSpp$default, null, null, null, null, false, false, false, 0, false, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$41((XConnectCallback) obj);
                }
            }, null, 1471, null);
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        XBleConnector xBleConnectorBle = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(realMac)).ble(this.watchCommandParser, "BleWriter");
        xBleConnectorBle.setAutoOpenNotifyChannel(false);
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true) && "[NothingWatchPluginImpl] ble connect get device success!  ".length() != 0) {
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str4 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog2, 4, str4, tag2, "[NothingWatchPluginImpl] ble connect get device success!   " + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, "[NothingWatchPluginImpl] ble connect get device success!   " + strComponent4);
            }
        }
        xBleConnectorBle.setMessageReceiveCallback("watch", new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$46(this.f$0, device, (XCommand) obj);
            }
        });
        xBleConnectorBle.setDeviceConnectCallback("watch", new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$53(this.f$0, device, connectType, ((Integer) obj).intValue(), (XConnectFailType) obj2);
            }
        });
        xBleConnectorBle.setDeviceMtuChangeCallback(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$58(this.f$0, device, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
        XBaseBleConnector xBaseBleConnectorNotifyUUID = xBleConnectorBle.serviceUUID(toUUID(this.dataService.getIdentity())).writeUUID(toUUID(this.dataService.getWriteIdentity())).notifyUUID(toUUID(this.dataService.getReceiveIdentity()));
        Long timeout2 = set.getTimeout();
        XConnector.connect$default(xBaseBleConnectorNotifyUUID, Long.valueOf((timeout2 != null ? timeout2.longValue() : 8L) * 1000), null, null, null, false, false, false, 0, false, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$65((XConnectCallback) obj);
            }
        }, null, 1470, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28(final NothingWatchPluginImpl nothingWatchPluginImpl, final NtBleDevice ntBleDevice, final NtConnectType ntConnectType, XConnectCallback connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.connect$lambda$28$lambda$15(this.f$0, ntBleDevice, ntConnectType, (XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        connect.onConnectStart(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.connect$lambda$28$lambda$17();
            }
        });
        connect.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.connect$lambda$28$lambda$22(this.f$0, ntBleDevice, (XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        connect.onDisConnected(new Function4() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NothingWatchPluginImpl.connect$lambda$28$lambda$27(this.f$0, ntBleDevice, ntConnectType, ((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15(final NothingWatchPluginImpl nothingWatchPluginImpl, final NtBleDevice ntBleDevice, final NtConnectType ntConnectType, XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onConnectFail " + xBluetoothDevice + "  " + connectFailType;
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
        if (Intrinsics.areEqual(connectFailType, XConnectFailType.KeyMissingPaired.INSTANCE)) {
            nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda43
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$15$lambda$5(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        } else if (Intrinsics.areEqual(connectFailType, XConnectFailType.connectPeerPaired.INSTANCE)) {
            nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$15$lambda$8(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        } else if (Intrinsics.areEqual(connectFailType, XConnectFailType.UserFailed.INSTANCE)) {
            nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$15$lambda$11(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        } else {
            nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$15$lambda$14(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15$lambda$5(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectFail(ntBleDevice, MapsKt.mapOf(new Pair(10000L, "KeyMissingPaired")), new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$15$lambda$5$lambda$4(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15$lambda$5$lambda$4(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] connectFail " + ntConnectType + " callback";
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15$lambda$8(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectFail(ntBleDevice, MapsKt.mapOf(new Pair(14L, "connectPeerPaired")), new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda56
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$15$lambda$8$lambda$7(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15$lambda$8$lambda$7(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] connectFail " + ntConnectType + " callback";
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15$lambda$11(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectFail(ntBleDevice, MapsKt.mapOf(new Pair(9L, "connectPeerPaired")), new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$15$lambda$11$lambda$10(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15$lambda$11$lambda$10(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] connectFail " + ntConnectType + " callback";
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15$lambda$14(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BT, ntBleDevice, NtBleConnectState.CANCEL, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$15$lambda$14$lambda$13(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$15$lambda$14$lambda$13(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] NtBleConnectStateChanged " + ntConnectType + " callback";
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$17() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] onConnectStart".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "[NothingWatchPluginImpl] onConnectStart " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "[NothingWatchPluginImpl] onConnectStart " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$22(final NothingWatchPluginImpl nothingWatchPluginImpl, final NtBleDevice ntBleDevice, final XConnectType currentConnectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(currentConnectType, "currentConnectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onConnectSuccess " + currentConnectType + StringUtils.SPACE + xBluetoothDevice;
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
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.connect$lambda$28$lambda$22$lambda$21(this.f$0, ntBleDevice, currentConnectType);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$22$lambda$21(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, final XConnectType xConnectType) {
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BT, ntBleDevice, NtBleConnectState.CONNECTED, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$22$lambda$21$lambda$20(xConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$22$lambda$21$lambda$20(XConnectType xConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] NtBleConnectStateChanged " + xConnectType + " callback";
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$27(final NothingWatchPluginImpl nothingWatchPluginImpl, final NtBleDevice ntBleDevice, final NtConnectType ntConnectType, boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onDisConnected " + ntConnectType + StringUtils.SPACE + ntBleDevice + StringUtils.SPACE + i;
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
        if (i == XConnectType.BT.INSTANCE.getType()) {
            updateChannelStatus$default(nothingWatchPluginImpl, ntBleDevice, false, 2, null);
            nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$27$lambda$26(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$27$lambda$26(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BT, ntBleDevice, NtBleConnectState.DISCONNECTED, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$28$lambda$27$lambda$26$lambda$25(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$28$lambda$27$lambda$26$lambda$25(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] NtBleConnectStateChanged " + ntConnectType + " callback";
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$34$lambda$33(final NothingWatchPluginImpl nothingWatchPluginImpl, final NtConnectType ntConnectType, final NtBleDevice ntBleDevice, int i, XConnectFailType xConnectFailType) {
        final NtBleConnectState ntBleConnectStateOfRaw = NtBleConnectState.INSTANCE.ofRaw(i);
        if (ntBleConnectStateOfRaw == null) {
            return Unit.INSTANCE;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] setDeviceConnectCallback " + ntConnectType + StringUtils.SPACE + i + StringUtils.SPACE + xConnectFailType;
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
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.connect$lambda$34$lambda$33$lambda$32(this.f$0, ntBleDevice, ntBleConnectStateOfRaw, ntConnectType);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$34$lambda$33$lambda$32(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, NtBleConnectState ntBleConnectState, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BT, ntBleDevice, ntBleConnectState, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda50
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$34$lambda$33$lambda$32$lambda$31(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$34$lambda$33$lambda$32$lambda$31(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] NtBleConnectStateChanged " + ntConnectType + " callback";
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$41(XConnectCallback connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.connect$lambda$41$lambda$36((XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        connect.onConnectStart(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.connect$lambda$41$lambda$38();
            }
        });
        connect.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.connect$lambda$41$lambda$40((XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$41$lambda$36(XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onConnectFail " + xBluetoothDevice + "  " + connectFailType;
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$41$lambda$38() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] onConnectStart".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "[NothingWatchPluginImpl] onConnectStart " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "[NothingWatchPluginImpl] onConnectStart " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$41$lambda$40(XConnectType currentConnectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(currentConnectType, "currentConnectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onConnectSuccess " + currentConnectType + StringUtils.SPACE + xBluetoothDevice;
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$46(final NothingWatchPluginImpl nothingWatchPluginImpl, final NtBleDevice ntBleDevice, final XCommand xCommand) {
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda18
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$46$lambda$45(this.f$0, xCommand, ntBleDevice);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$46$lambda$45(NothingWatchPluginImpl nothingWatchPluginImpl, XCommand xCommand, NtBleDevice ntBleDevice) {
        String uuid;
        ArrayList arrayListEmptyList;
        byte[] data;
        List<Byte> list;
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            if (xCommand == null || (uuid = xCommand.getUuid()) == null) {
                uuid = "";
            }
            if (xCommand == null || (data = xCommand.getData()) == null || (list = ArraysKt.toList(data)) == null) {
                arrayListEmptyList = CollectionsKt.emptyList();
            } else {
                List<Byte> list2 = list;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((Number) it.next()).byteValue()));
                }
                arrayListEmptyList = arrayList;
            }
            ntBleFlutterApi.valueReceived(uuid, ntBleDevice, arrayListEmptyList, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda51
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$66$lambda$46$lambda$45$lambda$44((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$46$lambda$45$lambda$44(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$53(final NothingWatchPluginImpl nothingWatchPluginImpl, final NtBleDevice ntBleDevice, final NtConnectType ntConnectType, int i, XConnectFailType xConnectFailType) {
        final XConnectFailType xConnectFailType2;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            xConnectFailType2 = xConnectFailType;
            String str = "[NothingWatchPluginImpl] setDeviceConnectCallback " + i + StringUtils.SPACE + xConnectFailType2 + StringUtils.SPACE;
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
        } else {
            xConnectFailType2 = xConnectFailType;
        }
        final NtBleConnectState ntBleConnectStateOfRaw = NtBleConnectState.INSTANCE.ofRaw(i);
        if (ntBleConnectStateOfRaw == null) {
            return Unit.INSTANCE;
        }
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$53$lambda$52(ntBleConnectStateOfRaw, nothingWatchPluginImpl, ntBleDevice, xConnectFailType2, ntConnectType);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$53$lambda$52(NtBleConnectState ntBleConnectState, NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, final XConnectFailType xConnectFailType, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi;
        if (ntBleConnectState == NtBleConnectState.CONNECTED) {
            NtBleFlutterApi ntBleFlutterApi2 = nothingWatchPluginImpl.flutterApi;
            if (ntBleFlutterApi2 != null) {
                ntBleFlutterApi2.connectStateChanged(NtConnectType.BLE, ntBleDevice, ntBleConnectState, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda53
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NothingWatchPluginImpl.connect$lambda$66$lambda$53$lambda$52$lambda$48((Result) obj);
                    }
                });
            }
        } else {
            if (Intrinsics.areEqual(xConnectFailType, XConnectFailType.KeyMissingPaired.INSTANCE) && (ntBleFlutterApi = nothingWatchPluginImpl.flutterApi) != null) {
                ntBleFlutterApi.connectFail(ntBleDevice, MapsKt.mapOf(new Pair(20000L, "KeyMissingPaired")), new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda54
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NothingWatchPluginImpl.connect$lambda$66$lambda$53$lambda$52$lambda$50(ntConnectType, xConnectFailType, (Result) obj);
                    }
                });
            }
            NtBleFlutterApi ntBleFlutterApi3 = nothingWatchPluginImpl.flutterApi;
            if (ntBleFlutterApi3 != null) {
                ntBleFlutterApi3.connectStateChanged(NtConnectType.BLE, ntBleDevice, ntBleConnectState, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda55
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NothingWatchPluginImpl.connect$lambda$66$lambda$53$lambda$52$lambda$51((Result) obj);
                    }
                });
            }
            nothingWatchPluginImpl.clearNotifyChannelCache(ntBleDevice.getRealMac());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$53$lambda$52$lambda$48(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$53$lambda$52$lambda$50(NtConnectType ntConnectType, XConnectFailType xConnectFailType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] connectFail " + ntConnectType + StringUtils.SPACE + xConnectFailType + " callback";
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$53$lambda$52$lambda$51(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$58(final NothingWatchPluginImpl nothingWatchPluginImpl, final NtBleDevice ntBleDevice, final int i, int i2) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] setDeviceMtuChangeCallback " + i + StringUtils.SPACE + i2;
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
        HashMap<String, Integer> map = nothingWatchPluginImpl.mtuMap;
        String realMac = ntBleDevice.getRealMac();
        if (realMac == null) {
            realMac = "";
        }
        map.put(realMac, Integer.valueOf(i));
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$58$lambda$57(this.f$0, ntBleDevice, i);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$58$lambda$57(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, int i) {
        NtBleFlutterApi ntBleFlutterApi = nothingWatchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.mtuSizeChanged(ntBleDevice, i, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.connect$lambda$66$lambda$58$lambda$57$lambda$56((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$58$lambda$57$lambda$56(Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] nBleMtuChanged callback".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "[NothingWatchPluginImpl] nBleMtuChanged callback " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "[NothingWatchPluginImpl] nBleMtuChanged callback " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$65(XConnectCallback connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$65$lambda$60((XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        connect.onConnectStart(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$65$lambda$62();
            }
        });
        connect.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.connect$lambda$66$lambda$65$lambda$64((XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$65$lambda$60(XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onConnectFail " + xBluetoothDevice + "  " + connectFailType;
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$65$lambda$62() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] onConnectStart".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "[NothingWatchPluginImpl] onConnectStart " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "[NothingWatchPluginImpl] onConnectStart " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$66$lambda$65$lambda$64(XConnectType connectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onConnectSuccess " + connectType + StringUtils.SPACE + xBluetoothDevice;
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
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void disconnect(NtBleDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        String realMac = device.getRealMac();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] disconnect -> WATCH mac:" + realMac;
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
        clearNotifyChannelCache(realMac);
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass2(realMac, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$disconnect$2, reason: invalid class name */
    /* JADX INFO: compiled from: NothingWatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.NothingWatchPluginImpl$disconnect$2", f = "NothingWatchPluginImpl.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$address = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$address, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (XConnectorDevice.ble$default(XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(this.$address)), null, null, 3, null).disconnect(this) == coroutine_suspended) {
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

    public final void clearNotifyChannelCache(String realMac) {
        String str = realMac;
        if (str == null || str.length() == 0) {
            return;
        }
        String str2 = realMac + "_";
        Set<String> setKeySet = this.channelMap.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "<get-keys>(...)");
        ArrayList arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            String str3 = (String) obj;
            Intrinsics.checkNotNull(str3);
            if (StringsKt.startsWith$default(str3, str2, false, 2, (Object) null)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.channelMap.remove((String) it.next());
        }
        this.mtuMap.remove(realMac);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str4 = "[NothingWatchPluginImpl] clearNotifyChannelCache mac:" + realMac + " removedKeys:" + arrayList2;
            String str5 = str4;
            if (str5 == null || str5.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str6 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            FileLog.print$default(fileLog, 3, str6, tag, str4 + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, str4 + StringUtils.SPACE + strComponent2);
            }
        }
    }

    private final String notifyChannelKey(String realMac, String notifyIdentity) {
        return realMac + "_" + toUUID(notifyIdentity);
    }

    static /* synthetic */ void updateChannelStatus$default(NothingWatchPluginImpl nothingWatchPluginImpl, NtBleDevice ntBleDevice, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        nothingWatchPluginImpl.updateChannelStatus(ntBleDevice, z);
    }

    private final void updateChannelStatus(NtBleDevice device, boolean enable) {
        this.channelMap.put(notifyChannelKey(device.getRealMac(), this.dataService.getReceiveIdentity()), Boolean.valueOf(enable));
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void writeValueSync(String realMac, long timeout, NtDeviceType deviceType, NtSendKey sendKey, NtChannelPriority priority, String value, long interval, NtBleDevice device, final Function1<? super Result<? extends List<Long>>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(sendKey, "sendKey");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NtBleService ntBleService = this.dataService;
        XConnector.writeWithTask$default(NtConnectorExtKt.getConnector$default(priority, NBleDeviceExtKt.toLocal(realMac), sendKey, this.sppService, this.watchCommandParser, 0, 16, null), decodeToByteArray(value), interval, timeout * ((long) 1000), false, false, false, toUUID(ntBleService.getIdentity()), toUUID(ntBleService.getWriteIdentity()), new byte[0], (AtomicInteger) null, true, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NothingWatchPluginImpl.writeValueSync$lambda$77(this.f$0, callback, (XWriteCallback) obj);
            }
        }, 6712, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$77(final NothingWatchPluginImpl nothingWatchPluginImpl, final Function1 function1, XWriteCallback writeWithTask) {
        Intrinsics.checkNotNullParameter(writeWithTask, "$this$writeWithTask");
        writeWithTask.onWriteSuccess(new Function4() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NothingWatchPluginImpl.writeValueSync$lambda$77$lambda$73(this.f$0, function1, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
            }
        });
        writeWithTask.onWriteFail(new Function4() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NothingWatchPluginImpl.writeValueSync$lambda$77$lambda$76(this.f$0, function1, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$77$lambda$73(NothingWatchPluginImpl nothingWatchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] justWrite) {
        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] onWriteSync Success".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "[NothingWatchPluginImpl] onWriteSync Success " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "[NothingWatchPluginImpl] onWriteSync Success " + strComponent2);
            }
        }
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.writeValueSync$lambda$77$lambda$73$lambda$72(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$77$lambda$73$lambda$72(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(CollectionsKt.arrayListOf(1L))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$77$lambda$76(NothingWatchPluginImpl nothingWatchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onWriteSync Fail " + throwable;
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
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.writeValueSync$lambda$77$lambda$76$lambda$75(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$77$lambda$76$lambda$75(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(CollectionsKt.emptyList())));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void writeValue(NtBleDevice device, NtSendKey key, NtChannelPriority priority, String value, long timeout, long interval) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(priority, "priority");
        Intrinsics.checkNotNullParameter(value, "value");
        String realMac = device.getRealMac();
        if (realMac == null || realMac.length() == 0) {
            return;
        }
        NtBleService ntBleService = this.dataService;
        XConnector.writeWithTask$default(NtConnectorExtKt.getConnector$default(priority, NBleDeviceExtKt.toLocal(device.getRealMac()), key, this.sppService, this.watchCommandParser, 0, 16, null), decodeToByteArray(value), interval > 0 ? interval : 10L, timeout * ((long) 1000), false, false, false, toUUID(ntBleService.getIdentity()), toUUID(ntBleService.getWriteIdentity()), new byte[0], (AtomicInteger) null, true, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NothingWatchPluginImpl.writeValue$lambda$81((XWriteCallback) obj);
            }
        }, 6712, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$81(XWriteCallback writeWithTask) {
        Intrinsics.checkNotNullParameter(writeWithTask, "$this$writeWithTask");
        writeWithTask.onWriteSuccess(new Function4() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NothingWatchPluginImpl.writeValue$lambda$81$lambda$78((XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
            }
        });
        writeWithTask.onWriteFail(new Function4() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return NothingWatchPluginImpl.writeValue$lambda$81$lambda$80((XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$81$lambda$78(XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] justWrite) {
        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$81$lambda$80(XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] onWriteFail " + throwable;
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
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void startNotify(NtBleDevice device, final NtBleService service, final Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String strNotifyChannelKey = notifyChannelKey(device.getRealMac(), service.getReceiveIdentity());
        final String realMac = device.getRealMac();
        if (Intrinsics.areEqual((Object) this.channelMap.get(strNotifyChannelKey), (Object) true)) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "[NothingWatchPluginImpl] startNotify cache_hit mac:" + device.getRealMac() + " notify:" + toUUID(service.getReceiveIdentity()) + " \u2192 remove cache and re-enable";
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
            this.channelMap.remove(strNotifyChannelKey);
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "[NothingWatchPluginImpl] startNotify mac:" + device.getRealMac() + " service:" + toUUID(service.getIdentity()) + " notify:" + toUUID(service.getReceiveIdentity());
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
        enableNotification(NBleDeviceExtKt.toLocal(device.getRealMac()), toUUID(service.getIdentity()), toUUID(service.getReceiveIdentity()), 0L, true, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NothingWatchPluginImpl.startNotify$lambda$89(this.f$0, strNotifyChannelKey, callback, realMac, service, (XCommonTaskCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startNotify$lambda$89(final NothingWatchPluginImpl nothingWatchPluginImpl, final String str, final Function1 function1, final String str2, final NtBleService ntBleService, XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return NothingWatchPluginImpl.startNotify$lambda$89$lambda$85(this.f$0, str, function1, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        enableNotification.onFail(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.startNotify$lambda$89$lambda$88(this.f$0, str, str2, ntBleService, function1, (XBluetoothDevice) obj, (Throwable) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startNotify$lambda$89$lambda$85(NothingWatchPluginImpl nothingWatchPluginImpl, String str, final Function1 function1, XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        nothingWatchPluginImpl.channelMap.put(str, true);
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.startNotify$lambda$89$lambda$85$lambda$84(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startNotify$lambda$89$lambda$85$lambda$84(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startNotify$lambda$89$lambda$88(NothingWatchPluginImpl nothingWatchPluginImpl, String str, String str2, NtBleService ntBleService, final Function1 function1, XBluetoothDevice xBluetoothDevice, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        nothingWatchPluginImpl.channelMap.put(str, false);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str3 = "[NothingWatchPluginImpl] startNotify fail mac:" + str2 + " notify:" + nothingWatchPluginImpl.toUUID(ntBleService.getReceiveIdentity()) + " err:" + throwable;
            String str4 = str3;
            if (str4 != null && str4.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str5 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                FileLog.print$default(fileLog, 5, str5, tag, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.w(tag + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                }
            }
        }
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.startNotify$lambda$89$lambda$88$lambda$87(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startNotify$lambda$89$lambda$88$lambda$87(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void stopNotify(NtBleDevice device, NtBleService service, final Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String strNotifyChannelKey = notifyChannelKey(device.getRealMac(), service.getReceiveIdentity());
        final String realMac = device.getRealMac();
        this.channelMap.remove(strNotifyChannelKey);
        enableNotification(NBleDeviceExtKt.toLocal(device.getRealMac()), toUUID(service.getIdentity()), toUUID(service.getReceiveIdentity()), 0L, false, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NothingWatchPluginImpl.stopNotify$lambda$95(this.f$0, callback, realMac, (XCommonTaskCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopNotify$lambda$95(final NothingWatchPluginImpl nothingWatchPluginImpl, final Function1 function1, final String str, XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return NothingWatchPluginImpl.stopNotify$lambda$95$lambda$91(this.f$0, function1, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        enableNotification.onFail(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NothingWatchPluginImpl.stopNotify$lambda$95$lambda$94(this.f$0, str, function1, (XBluetoothDevice) obj, (Throwable) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopNotify$lambda$95$lambda$91(NothingWatchPluginImpl nothingWatchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.stopNotify$lambda$95$lambda$91$lambda$90(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopNotify$lambda$95$lambda$91$lambda$90(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopNotify$lambda$95$lambda$94(NothingWatchPluginImpl nothingWatchPluginImpl, String str, final Function1 function1, XBluetoothDevice xBluetoothDevice, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "[NothingWatchPluginImpl] stopNotify fail mac:" + str + " err:" + throwable;
            String str3 = str2;
            if (str3 != null && str3.length() != 0) {
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
        nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return NothingWatchPluginImpl.stopNotify$lambda$95$lambda$94$lambda$93(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopNotify$lambda$95$lambda$94$lambda$93(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        return Unit.INSTANCE;
    }

    static /* synthetic */ void enableNotification$default(NothingWatchPluginImpl nothingWatchPluginImpl, String str, String str2, String str3, long j, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 0;
        }
        nothingWatchPluginImpl.enableNotification(str, str2, str3, j, (i & 16) != 0 ? true : z, function1);
    }

    private final void enableNotification(String address, String serviceUUID, String notifyUUID, long interval, boolean enable, Function1<? super XCommonTaskCallback, Unit> callback) {
        if (enable) {
            XBaseBleConnector.enableCharacteristicNotifyWithTask$default(XConnectorDevice.ble$default(XBluetoothManager.INSTANCE.get().getDevice(address), null, null, 3, null), serviceUUID, notifyUUID, true, interval, callback, "", false, null, 192, null);
        } else {
            XBaseBleConnector.enableCharacteristicNotifyWithTask$default(XConnectorDevice.ble$default(XBluetoothManager.INSTANCE.get().getDevice(address), null, null, 3, null), serviceUUID, notifyUUID, false, interval, callback, "", false, null, 192, null);
        }
    }

    public final String toUUID(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() != 4) {
            return str;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str2 = String.format("0000%s-0000-1000-8000-00805f9b34fb", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
        return str2;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void getBluetoothAlias(String realMac, Function1<? super Result<BluetoothInfo>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            Result.Companion companion = Result.INSTANCE;
            NothingWatchPluginImpl nothingWatchPluginImpl = this;
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(null)));
            Result.m6347constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: NothingWatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1", f = "NothingWatchPluginImpl.kt", i = {0}, l = {597}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        final /* synthetic */ NtBtProfile $profile;
        final /* synthetic */ String $realMac;
        final /* synthetic */ NtSendKey $sendKey;
        final /* synthetic */ long $timeout;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ NothingWatchPluginImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(NtSendKey ntSendKey, String str, NothingWatchPluginImpl nothingWatchPluginImpl, long j, NtBtProfile ntBtProfile, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sendKey = ntSendKey;
            this.$realMac = str;
            this.this$0 = nothingWatchPluginImpl;
            this.$timeout = j;
            this.$profile = ntBtProfile;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$sendKey, this.$realMac, this.this$0, this.$timeout, this.$profile, this.$callback, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objIsConnected$default;
            Object objM6347constructorimpl;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = (CoroutineScope) this.L$0;
                this.label = 1;
                objIsConnected$default = XConnector.isConnected$default(NtConnectorExtKt.getSppConnector(this.$sendKey, this.$realMac, this.this$0.getSppService(), this.this$0.watchCommandParser, 11), false, this, 1, null);
                if (objIsConnected$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                objIsConnected$default = obj;
            }
            if (((Boolean) objIsConnected$default).booleanValue()) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] Watch connectSync isConnected".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "[NothingWatchPluginImpl] Watch connectSync isConnected " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "[NothingWatchPluginImpl] Watch connectSync isConnected " + strComponent2);
                    }
                }
                Function1<Result<Boolean>, Unit> function1 = this.$callback;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Result.Companion companion2 = Result.INSTANCE;
                    function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boxing.boxBoolean(true))));
                    objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
                }
                Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
                if (thM6350exceptionOrNullimpl != null) {
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str2 = "[NothingWatchPluginImpl] Watch connectSync " + thM6350exceptionOrNullimpl;
                        String str3 = str2;
                        if (str3 != null && str3.length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str4 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                            FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
            XBaseSppConnector sppConnector = NtConnectorExtKt.getSppConnector(this.$sendKey, this.$realMac, this.this$0.getSppService(), this.this$0.watchCommandParser, 11);
            final NothingWatchPluginImpl nothingWatchPluginImpl = this.this$0;
            final String str5 = this.$realMac;
            sppConnector.setMessageReceiveCallback("watch_sync", new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$10$lambda$7(nothingWatchPluginImpl, str5, (XCommand) obj2);
                }
            });
            sppConnector.setDeviceConnectCallback("watch_sync", new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$10$lambda$9(((Integer) obj2).intValue(), (XConnectFailType) obj3);
                }
            });
            XBaseSppConnector xBaseSppConnector = sppConnector;
            Long lBoxLong = Boxing.boxLong(this.$timeout * ((long) 1000));
            int profile = NtBtProfileExtKt.toProfile(this.$profile);
            final Function1<Result<Boolean>, Unit> function2 = this.$callback;
            XConnector.connect$default(xBaseSppConnector, lBoxLong, null, null, null, false, false, false, profile, false, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$23(function2, (XConnectCallback) obj2);
                }
            }, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$27((XBluetoothFlowCallBack) obj2);
                }
            }, 382, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$10$lambda$7(final NothingWatchPluginImpl nothingWatchPluginImpl, final String str, final XCommand xCommand) {
            nothingWatchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$10$lambda$7$lambda$6(nothingWatchPluginImpl, xCommand, str);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$10$lambda$7$lambda$6(NothingWatchPluginImpl nothingWatchPluginImpl, XCommand xCommand, String str) {
            String uuid;
            ArrayList arrayListEmptyList;
            byte[] data;
            List<Byte> list;
            NtBleFlutterApi flutterApi = nothingWatchPluginImpl.getFlutterApi();
            if (flutterApi != null) {
                if (xCommand == null || (uuid = xCommand.getUuid()) == null) {
                    uuid = "";
                }
                NtBleDevice ntBleDevice = new NtBleDevice(null, str, str, null, null, null, NtDeviceType.WATCH, null, null, null, null, null, 4025, null);
                if (xCommand == null || (data = xCommand.getData()) == null || (list = ArraysKt.toList(data)) == null) {
                    arrayListEmptyList = CollectionsKt.emptyList();
                } else {
                    List<Byte> list2 = list;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        arrayList.add(Long.valueOf(((Number) it.next()).byteValue()));
                    }
                    arrayListEmptyList = arrayList;
                }
                flutterApi.valueReceived(uuid, ntBleDevice, arrayListEmptyList, new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$10$lambda$7$lambda$6$lambda$5((Result) obj);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$10$lambda$7$lambda$6$lambda$5(Result result) {
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$10$lambda$9(int i, XConnectFailType xConnectFailType) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "[NothingWatchPluginImpl] watch_sync setDeviceConnectCallback " + i;
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
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$23(final Function1 function1, final XConnectCallback xConnectCallback) {
            xConnectCallback.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$23$lambda$15(xConnectCallback, function1, (XConnectType) obj, (XBluetoothDevice) obj2);
                }
            });
            xConnectCallback.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$23$lambda$17((XBluetoothDevice) obj, (XConnectFailType) obj2);
                }
            });
            xConnectCallback.onDisConnected(new Function4() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$23$lambda$22(xConnectCallback, function1, ((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$23$lambda$15(XConnectCallback xConnectCallback, Function1 function1, XConnectType xConnectType, XBluetoothDevice xBluetoothDevice) {
            Object objM6347constructorimpl;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] spp connectSync -> onConnectSuccess".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "[NothingWatchPluginImpl] spp connectSync -> onConnectSuccess " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "[NothingWatchPluginImpl] spp connectSync -> onConnectSuccess " + strComponent2);
                }
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.Companion companion2 = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
                objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
            if (thM6350exceptionOrNullimpl != null) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str2 = "[NothingWatchPluginImpl] spp connectSync 111-> " + thM6350exceptionOrNullimpl;
                    String str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str4 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                        FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$23$lambda$17(XBluetoothDevice xBluetoothDevice, XConnectFailType xConnectFailType) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] spp connectSync -> onConnectFail".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "[NothingWatchPluginImpl] spp connectSync -> onConnectFail " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "[NothingWatchPluginImpl] spp connectSync -> onConnectFail " + strComponent2);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$23$lambda$22(XConnectCallback xConnectCallback, Function1 function1, boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
            Object objM6347constructorimpl;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "[NothingWatchPluginImpl] spp connectSync -> onDisConnected".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "[NothingWatchPluginImpl] spp connectSync -> onDisConnected " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "[NothingWatchPluginImpl] spp connectSync -> onDisConnected " + strComponent2);
                }
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                Result.Companion companion2 = Result.INSTANCE;
                function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
                objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion3 = Result.INSTANCE;
                objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
            if (thM6350exceptionOrNullimpl != null) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str2 = "[NothingWatchPluginImpl] spp connectSync 111-> " + thM6350exceptionOrNullimpl;
                    String str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str4 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                        FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$27(XBluetoothFlowCallBack xBluetoothFlowCallBack) {
            xBluetoothFlowCallBack.onRequestPermission(new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$27$lambda$24((Function1) obj);
                }
            });
            xBluetoothFlowCallBack.onRequestBluetooth(new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$27$lambda$25((Function1) obj);
                }
            });
            xBluetoothFlowCallBack.onRequestGps(new Function1() { // from class: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$connectSync$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return NothingWatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$27$lambda$26((Function1) obj);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$27$lambda$24(Function1 function1) {
            function1.invoke(false);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$27$lambda$25(Function1 function1) {
            function1.invoke(false);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$27$lambda$26(Function1 function1) {
            function1.invoke(false);
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void connectSync(String realMac, long timeout, NtDeviceType deviceType, NtSendKey sendKey, NtBtProfile profile, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(sendKey, "sendKey");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(sendKey, realMac, this, timeout, profile, callback, null), 3, null);
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void turnOnSpp(String realMac, long timeout, NtDeviceType type, NtSendKey sendKey, NtBtProfile profile, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sendKey, "sendKey");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(callback, "callback");
        connectSync(realMac, timeout, type, sendKey, profile, callback);
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void disconnectByType(NtBleDevice device, NtSendKey sendKey, NtConnectType connectType) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(sendKey, "sendKey");
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "[NothingWatchPluginImpl] close spp connectSync -> " + sendKey.name() + " connectType=" + connectType.name();
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
        if (sendKey == NtSendKey.LOG && connectType == NtConnectType.SPP) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09522(sendKey, device, this, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$disconnectByType$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NothingWatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.NothingWatchPluginImpl$disconnectByType$2", f = "NothingWatchPluginImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09522 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtBleDevice $device;
        final /* synthetic */ NtSendKey $sendKey;
        int label;
        final /* synthetic */ NothingWatchPluginImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09522(NtSendKey ntSendKey, NtBleDevice ntBleDevice, NothingWatchPluginImpl nothingWatchPluginImpl, Continuation<? super C09522> continuation) {
            super(2, continuation);
            this.$sendKey = ntSendKey;
            this.$device = ntBleDevice;
            this.this$0 = nothingWatchPluginImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09522(this.$sendKey, this.$device, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09522) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            XBaseSppConnector sppConnector = NtConnectorExtKt.getSppConnector(this.$sendKey, NBleDeviceExtKt.toLocal(this.$device.getRealMac()), this.this$0.getSppService(), this.this$0.watchCommandParser, 11);
            Logger logger = Logger.INSTANCE;
            NtBleDevice ntBleDevice = this.$device;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "[NothingWatchPluginImpl] close spp do getSppConnector spp=" + sppConnector + " device.realMac=" + ntBleDevice.getRealMac() + StringUtils.SPACE;
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
            sppConnector.closeLast();
            sppConnector.onDestroy();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$turnOffSpp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: NothingWatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.NothingWatchPluginImpl$turnOffSpp$1", f = "NothingWatchPluginImpl.kt", i = {}, l = {712, 730}, m = "invokeSuspend", n = {}, s = {})
    static final class C09531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        final /* synthetic */ String $realMac;
        final /* synthetic */ NtSendKey $sendKey;
        int label;
        final /* synthetic */ NothingWatchPluginImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09531(NtSendKey ntSendKey, String str, NothingWatchPluginImpl nothingWatchPluginImpl, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super C09531> continuation) {
            super(2, continuation);
            this.$sendKey = ntSendKey;
            this.$realMac = str;
            this.this$0 = nothingWatchPluginImpl;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09531(this.$sendKey, this.$realMac, this.this$0, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x0104, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ble.plugin.NothingWatchPluginImpl.C09531.C01891(r7.$callback, null), r7) == r0) goto L41;
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
                if (NtConnectorExtKt.getSppConnector(this.$sendKey, this.$realMac, this.this$0.getSppService(), this.this$0.watchCommandParser, 11).disconnect(this) != coroutine_suspended) {
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
            NtConnectorExtKt.getSppConnector(this.$sendKey, this.$realMac, this.this$0.getSppService(), this.this$0.watchCommandParser, 11).onDestroy();
            if (this.$sendKey == NtSendKey.LOG) {
                String logIdentity = this.this$0.getSppService().getLogIdentity();
                XBluetoothManager.INSTANCE.get().getDevice(this.$realMac).removeSppDevice(logIdentity != null ? logIdentity : "", 11);
            } else if (this.$sendKey == NtSendKey.OTA) {
                String otaIdentity = this.this$0.getSppService().getOtaIdentity();
                XBluetoothManager.INSTANCE.get().getDevice(this.$realMac).removeSppOTADevice(otaIdentity != null ? otaIdentity : "", 11);
            } else if (this.$sendKey == NtSendKey.DIAL) {
                String dialIdentity = this.this$0.getSppService().getDialIdentity();
                XBluetoothManager.INSTANCE.get().getDevice(this.$realMac).removeSppDevice(dialIdentity != null ? dialIdentity : "", 11);
            } else {
                String normalIdentity = this.this$0.getSppService().getNormalIdentity();
                XBluetoothManager.INSTANCE.get().getDevice(this.$realMac).removeSppDevice(normalIdentity != null ? normalIdentity : "", 11);
            }
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.NothingWatchPluginImpl$turnOffSpp$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: NothingWatchPluginImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ble.plugin.NothingWatchPluginImpl$turnOffSpp$1$1", f = "NothingWatchPluginImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01891(Function1<? super Result<Boolean>, Unit> function1, Continuation<? super C01891> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C01891 c01891 = new C01891(this.$callback, continuation);
                c01891.L$0 = obj;
                return c01891;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01891) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Function1<Result<Boolean>, Unit> function1 = this.$callback;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Result.Companion companion2 = Result.INSTANCE;
                    function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Boxing.boxBoolean(true))));
                    Result.m6347constructorimpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion3 = Result.INSTANCE;
                    Result.m6347constructorimpl(ResultKt.createFailure(th));
                }
                return Unit.INSTANCE;
            }
        }
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void turnOffSpp(String realMac, NtDeviceType type, NtSendKey sendKey, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sendKey, "sendKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09531(sendKey, realMac, this, callback, null), 3, null);
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void mtuSize(NtBleDevice device, Function1<? super Result<Long>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Result.Companion companion = Result.INSTANCE;
        Integer num = this.mtuMap.get(device.getRealMac());
        callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(Long.valueOf(num != null ? num.intValue() : 498))));
    }
}
