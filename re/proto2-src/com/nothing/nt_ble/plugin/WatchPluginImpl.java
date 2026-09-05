package com.nothing.nt_ble.plugin;

import android.bluetooth.BluetoothGatt;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.fluttercandies.photo_manager.constant.Methods;
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
import com.nothing.nt_ble.WatchCommandParser;
import com.nothing.nt_ble.ext.NBleDeviceExtKt;
import com.nothing.nt_ble.ext.NtBtProfileExtKt;
import com.nothing.nt_ble.ext.NtConnectorExtKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: WatchPluginImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010-\u001a\u00020.2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J \u0010/\u001a\u00020.2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0016J\u0010\u00106\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0016J\n\u00107\u001a\u00020\u0007*\u000208Jh\u00109\u001a\u00020.2\u0006\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u0002082\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020<2\u0006\u00102\u001a\u0002032\u001e\u0010D\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0G0F\u0012\u0004\u0012\u00020.0EH\u0016J8\u0010H\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u0010I\u001a\u0002082\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020&2\u0006\u0010;\u001a\u00020<2\u0006\u0010C\u001a\u00020<H\u0016J \u0010J\u001a\u00020.2\u0006\u0010@\u001a\u00020A2\u0006\u00102\u001a\u0002032\u0006\u0010B\u001a\u00020&H\u0002J0\u0010K\u001a\u00020.2\u0006\u0010@\u001a\u00020A2\u0006\u00102\u001a\u0002032\u0006\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020<2\u0006\u0010;\u001a\u00020<H\u0002J:\u0010L\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020&2\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016J*\u0010O\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016J*\u0010P\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016J*\u0010Q\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016J\u001a\u0010R\u001a\u00020.2\u0006\u00102\u001a\u0002032\b\b\u0002\u0010S\u001a\u00020'H\u0002J*\u0010T\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016J*\u0010U\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016JM\u0010V\u001a\u00020.2\u0006\u0010W\u001a\u00020&2\u0006\u0010X\u001a\u00020&2\u0006\u0010Y\u001a\u00020&2\b\b\u0002\u0010C\u001a\u00020<2\b\b\u0002\u0010S\u001a\u00020'2\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020.0E\u00a2\u0006\u0002\b[H\u0002J\u0010\u0010\\\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0016J\f\u0010]\u001a\u00020&*\u0004\u0018\u00010&J,\u0010^\u001a\u00020.2\u0006\u0010:\u001a\u00020&2\u001a\u0010D\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010_0F\u0012\u0004\u0012\u00020.0EH\u0016JJ\u0010`\u001a\u00020.2\u0006\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u0002082\u0006\u0010a\u001a\u00020b2\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016JJ\u0010c\u001a\u00020.2\u0006\u0010:\u001a\u00020&2\u0006\u0010;\u001a\u00020<2\u0006\u0010d\u001a\u00020>2\u0006\u0010?\u001a\u0002082\u0006\u0010a\u001a\u00020b2\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016J \u0010e\u001a\u00020.2\u0006\u00102\u001a\u0002032\u0006\u0010?\u001a\u0002082\u0006\u00100\u001a\u000201H\u0016J:\u0010f\u001a\u00020.2\u0006\u0010:\u001a\u00020&2\u0006\u0010d\u001a\u00020>2\u0006\u0010?\u001a\u0002082\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016J*\u0010g\u001a\u00020.2\u0006\u0010:\u001a\u00020&2\u0018\u0010D\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020'0F\u0012\u0004\u0012\u00020.0EH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R6\u0010$\u001a\u001e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%j\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'`(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006h"}, d2 = {"Lcom/nothing/nt_ble/plugin/WatchPluginImpl;", "Lcom/nothing/nt_ble/plugin/UnknownImpl;", "<init>", "()V", "watchCommandParser", "Lcom/nothing/nt_ble/WatchCommandParser;", "otaService", "Lcom/nothing/generate/NtBleService;", "getOtaService", "()Lcom/nothing/generate/NtBleService;", "setOtaService", "(Lcom/nothing/generate/NtBleService;)V", "dataService", "getDataService", "setDataService", "pairService", "getPairService", "setPairService", "dialService", "getDialService", "setDialService", "sppService", "Lcom/nothing/generate/NtSppService;", "getSppService", "()Lcom/nothing/generate/NtSppService;", "setSppService", "(Lcom/nothing/generate/NtSppService;)V", "logService", "getLogService", "setLogService", "flutterApi", "Lcom/nothing/generate/NtBleFlutterApi;", "getFlutterApi", "()Lcom/nothing/generate/NtBleFlutterApi;", "setFlutterApi", "(Lcom/nothing/generate/NtBleFlutterApi;)V", "channelMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "getChannelMap", "()Ljava/util/HashMap;", "setChannelMap", "(Ljava/util/HashMap;)V", "initPlugin", "", "connect", "connectType", "Lcom/nothing/generate/NtConnectType;", "device", "Lcom/nothing/generate/NtBleDevice;", "set", "Lcom/nothing/generate/NtBleScanSet;", DeviceEarImage.DISCONNECT_EAR_IMAGE, "toNtBleService", "Lcom/nothing/generate/NtSendKey;", "writeValueSync", "realMac", "timeout", "", "deviceType", "Lcom/nothing/generate/NtDeviceType;", "sendKey", MimeTypesReaderMetKeys.MAGIC_PRIORITY_ATTR, "Lcom/nothing/generate/NtChannelPriority;", "value", "interval", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "", "writeValue", "key", "writeLogData", "writeOTAData", "startOta", "filePath", "firmwareVersion", "stopOta", "startDial", "stopDial", "updateChannelStatus", "enable", "startLog", "stopLog", "enableNotification", "address", "serviceUUID", "notifyUUID", "Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskCallback;", "Lkotlin/ExtensionFunctionType;", "bindFinished", "toUUID", "getBluetoothAlias", "Lcom/nothing/generate/BluetoothInfo;", "connectSync", "profile", "Lcom/nothing/generate/NtBtProfile;", "turnOnSpp", "type", "disconnectByType", "turnOffSpp", "iosGetAncsAuthorized", "nt_ble_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatchPluginImpl extends UnknownImpl {
    private NtBleFlutterApi flutterApi;
    private final WatchCommandParser watchCommandParser = new WatchCommandParser();
    private NtBleService otaService = new NtBleService("02f00000-0000-0000-0000-00000000fe00", "02f00000-0000-0000-0000-00000000ff02", "02f00000-0000-0000-0000-00000000ff01");
    private NtBleService dataService = new NtBleService("fff0", "fff1", "fff2");
    private NtBleService pairService = new NtBleService("ffd0", "ffd1", "ffd2");
    private NtBleService dialService = new NtBleService("02f00000-0000-0000-0000-00000000ffe0", "02f00000-0000-0000-0000-00000000ffe2", "02f00000-0000-0000-0000-00000000ffe1");
    private NtSppService sppService = new NtSppService("AEAC4A03-DFF5-498F-843A-34487CF133EB", "00006666-0000-1000-8000-00805F9B34FB", "0000CCAA-0000-1000-8000-00805F9B34FB", "00001101-0000-1000-8000-00805F9B34FB");
    private NtBleService logService = new NtBleService("E49A3001-F69A-11E8-8EB2-F2801F1B9FD1", "E49A3003-F69A-11E8-8EB2-F2801F1B9FD1", "E49A3002-F69A-11E8-8EB2-F2801F1B9FD1");
    private HashMap<String, Boolean> channelMap = new HashMap<>();

    /* JADX INFO: compiled from: WatchPluginImpl.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

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
            int[] iArr2 = new int[NtSendKey.values().length];
            try {
                iArr2[NtSendKey.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[NtSendKey.DIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[NtSendKey.OTA.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[NtSendKey.LOG.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void iosGetAncsAuthorized(String realMac, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    public final NtBleService getOtaService() {
        return this.otaService;
    }

    public final void setOtaService(NtBleService ntBleService) {
        Intrinsics.checkNotNullParameter(ntBleService, "<set-?>");
        this.otaService = ntBleService;
    }

    public final NtBleService getDataService() {
        return this.dataService;
    }

    public final void setDataService(NtBleService ntBleService) {
        Intrinsics.checkNotNullParameter(ntBleService, "<set-?>");
        this.dataService = ntBleService;
    }

    public final NtBleService getPairService() {
        return this.pairService;
    }

    public final void setPairService(NtBleService ntBleService) {
        Intrinsics.checkNotNullParameter(ntBleService, "<set-?>");
        this.pairService = ntBleService;
    }

    public final NtBleService getDialService() {
        return this.dialService;
    }

    public final void setDialService(NtBleService ntBleService) {
        Intrinsics.checkNotNullParameter(ntBleService, "<set-?>");
        this.dialService = ntBleService;
    }

    public final NtSppService getSppService() {
        return this.sppService;
    }

    public final void setSppService(NtSppService ntSppService) {
        Intrinsics.checkNotNullParameter(ntSppService, "<set-?>");
        this.sppService = ntSppService;
    }

    public final NtBleService getLogService() {
        return this.logService;
    }

    public final void setLogService(NtBleService ntBleService) {
        Intrinsics.checkNotNullParameter(ntBleService, "<set-?>");
        this.logService = ntBleService;
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

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.nt_ble.plugin.PluginImpl
    public void initPlugin(NtBleFlutterApi flutterApi) {
        this.flutterApi = flutterApi;
        if (flutterApi != null) {
            flutterApi.getOtaService(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda71
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.initPlugin$lambda$18$lambda$2(this.f$0, (Result) obj);
                }
            });
            flutterApi.getDialService(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda72
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.initPlugin$lambda$18$lambda$5(this.f$0, (Result) obj);
                }
            });
            flutterApi.getPairService(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda73
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.initPlugin$lambda$18$lambda$8(this.f$0, (Result) obj);
                }
            });
            flutterApi.getNormalService(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda74
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.initPlugin$lambda$18$lambda$11(this.f$0, (Result) obj);
                }
            });
            flutterApi.getWatchSppService(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda75
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.initPlugin$lambda$18$lambda$14(this.f$0, (Result) obj);
                }
            });
            flutterApi.getLogService(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda76
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.initPlugin$lambda$18$lambda$17(this.f$0, (Result) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initPlugin$lambda$18$lambda$2(WatchPluginImpl watchPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtBleService ntBleService = (NtBleService) value;
            watchPluginImpl.otaService = ntBleService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "otaService serviceUUID=" + ntBleService.getIdentity() + ",notifyUUID=" + ntBleService.getReceiveIdentity() + ",writeUUID=" + ntBleService.getWriteIdentity();
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initPlugin$lambda$18$lambda$5(WatchPluginImpl watchPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtBleService ntBleService = (NtBleService) value;
            watchPluginImpl.dialService = ntBleService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "dialService serviceUUID=" + ntBleService.getIdentity() + ",notifyUUID=" + ntBleService.getReceiveIdentity() + ",writeUUID=" + ntBleService.getWriteIdentity();
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initPlugin$lambda$18$lambda$8(WatchPluginImpl watchPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtBleService ntBleService = (NtBleService) value;
            watchPluginImpl.pairService = ntBleService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "pairService serviceUUID=" + ntBleService.getIdentity() + ",notifyUUID=" + ntBleService.getReceiveIdentity() + ",writeUUID=" + ntBleService.getWriteIdentity();
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initPlugin$lambda$18$lambda$11(WatchPluginImpl watchPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtBleService ntBleService = (NtBleService) value;
            watchPluginImpl.dataService = ntBleService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "dataService serviceUUID=" + ntBleService.getIdentity() + ",notifyUUID=" + ntBleService.getReceiveIdentity() + ",writeUUID=" + ntBleService.getWriteIdentity();
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initPlugin$lambda$18$lambda$14(WatchPluginImpl watchPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtSppService ntSppService = (NtSppService) value;
            watchPluginImpl.sppService = ntSppService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "getWatchSppService normalIdentity=" + ntSppService.getNormalIdentity() + ",otaIdentity=" + ntSppService.getOtaIdentity() + ",dialIdentity=" + ntSppService.getDialIdentity();
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initPlugin$lambda$18$lambda$17(WatchPluginImpl watchPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtBleService ntBleService = (NtBleService) value;
            watchPluginImpl.logService = ntBleService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "dataService serviceUUID=" + ntBleService.getIdentity() + ",notifyUUID=" + ntBleService.getReceiveIdentity() + ",writeUUID=" + ntBleService.getWriteIdentity();
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
        return Unit.INSTANCE;
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
            String str = "watch connect connectType\uff1a" + connectType + " ,device:" + device.getRealMac() + ",deviceType:" + device.getDeviceType() + ",fastpairId:" + device.getFastPairID() + "!";
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
        final String realMac = device.getRealMac();
        int i = WhenMappings.$EnumSwitchMapping$0[connectType.ordinal()];
        if (i == 1) {
            XBTConnector xBTConnectorBt = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(realMac)).bt();
            Long timeout = set.getTimeout();
            Long lValueOf = Long.valueOf((timeout != null ? timeout.longValue() : 4L) * ((long) 1000));
            Long androidTransport = set.getAndroidTransport();
            XBTConnector.connect$default(xBTConnectorBt, lValueOf, 3, 1, Integer.valueOf(androidTransport != null ? (int) androidTransport.longValue() : 1), new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda45
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$46(this.f$0, device, connectType, (XConnectCallback) obj);
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
            xSppConnectorSpp$default.setDeviceConnectCallback("watch_spp", new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda46
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatchPluginImpl.connect$lambda$52$lambda$51(this.f$0, connectType, device, ((Integer) obj).intValue(), (XConnectFailType) obj2);
                }
            });
            XConnector.connect$default(xSppConnectorSpp$default, null, null, null, null, false, false, false, 0, false, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda47
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$59((XConnectCallback) obj);
                }
            }, null, 1471, null);
            return;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        XBleConnector xBleConnectorBle = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(realMac)).ble(this.watchCommandParser, "BleWriter");
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true) && "ble connect get device success!  ".length() != 0) {
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str4 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog2, 4, str4, tag2, "ble connect get device success!   " + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, "ble connect get device success!   " + strComponent4);
            }
        }
        xBleConnectorBle.setMessageReceiveCallback("watch", new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda48
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.connect$lambda$83$lambda$64(this.f$0, device, (XCommand) obj);
            }
        });
        xBleConnectorBle.setDeviceConnectCallback("watch", new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda49
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.connect$lambda$83$lambda$70(this.f$0, realMac, device, ((Integer) obj).intValue(), (XConnectFailType) obj2);
            }
        });
        xBleConnectorBle.setDeviceMtuChangeCallback(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda50
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.connect$lambda$83$lambda$75(this.f$0, device, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
        XBaseBleConnector xBaseBleConnectorNotifyUUID = xBleConnectorBle.serviceUUID(toUUID(this.dataService.getIdentity())).writeUUID(toUUID(this.dataService.getWriteIdentity())).notifyUUID(toUUID(this.dataService.getReceiveIdentity()));
        Long timeout2 = set.getTimeout();
        XConnector.connect$default(xBaseBleConnectorNotifyUUID, Long.valueOf((timeout2 != null ? timeout2.longValue() : 8L) * 1000), null, null, null, false, false, false, 0, false, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda51
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.connect$lambda$83$lambda$82((XConnectCallback) obj);
            }
        }, null, 1470, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46(final WatchPluginImpl watchPluginImpl, final NtBleDevice ntBleDevice, final NtConnectType ntConnectType, XConnectCallback connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda52
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.connect$lambda$46$lambda$33(this.f$0, ntBleDevice, ntConnectType, (XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        connect.onConnectStart(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda53
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.connect$lambda$46$lambda$35();
            }
        });
        connect.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda54
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.connect$lambda$46$lambda$40(this.f$0, ntBleDevice, (XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        connect.onDisConnected(new Function4() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda56
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WatchPluginImpl.connect$lambda$46$lambda$45(this.f$0, ntBleDevice, ntConnectType, ((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$33(final WatchPluginImpl watchPluginImpl, final NtBleDevice ntBleDevice, final NtConnectType ntConnectType, XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onConnectFail " + xBluetoothDevice + "  " + connectFailType;
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
            watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda67
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WatchPluginImpl.connect$lambda$46$lambda$33$lambda$23(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        } else if (Intrinsics.areEqual(connectFailType, XConnectFailType.connectPeerPaired.INSTANCE)) {
            watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda68
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WatchPluginImpl.connect$lambda$46$lambda$33$lambda$26(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        } else if (Intrinsics.areEqual(connectFailType, XConnectFailType.UserFailed.INSTANCE)) {
            watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda69
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WatchPluginImpl.connect$lambda$46$lambda$33$lambda$29(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        } else {
            watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda70
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WatchPluginImpl.connect$lambda$46$lambda$33$lambda$32(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$33$lambda$23(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectFail(ntBleDevice, MapsKt.mapOf(new Pair(10000L, "KeyMissingPaired")), new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda37
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$46$lambda$33$lambda$23$lambda$22(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$33$lambda$23$lambda$22(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "connectFail " + ntConnectType + " callback";
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
    public static final Unit connect$lambda$46$lambda$33$lambda$26(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectFail(ntBleDevice, MapsKt.mapOf(new Pair(14L, "connectPeerPaired")), new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda78
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$46$lambda$33$lambda$26$lambda$25(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$33$lambda$26$lambda$25(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "connectFail " + ntConnectType + " callback";
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
    public static final Unit connect$lambda$46$lambda$33$lambda$29(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectFail(ntBleDevice, MapsKt.mapOf(new Pair(9L, "connectPeerPaired")), new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda28
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$46$lambda$33$lambda$29$lambda$28(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$33$lambda$29$lambda$28(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "connectFail " + ntConnectType + " callback";
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
    public static final Unit connect$lambda$46$lambda$33$lambda$32(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BT, ntBleDevice, NtBleConnectState.CANCEL, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda40
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$46$lambda$33$lambda$32$lambda$31(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$33$lambda$32$lambda$31(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "NtBleConnectStateChanged " + ntConnectType + " callback";
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
    public static final Unit connect$lambda$46$lambda$35() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "onConnectStart".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "onConnectStart " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "onConnectStart " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$40(final WatchPluginImpl watchPluginImpl, final NtBleDevice ntBleDevice, final XConnectType connectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onConnectSuccess " + connectType + StringUtils.SPACE + xBluetoothDevice;
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
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda62
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.connect$lambda$46$lambda$40$lambda$39(this.f$0, ntBleDevice, connectType);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$40$lambda$39(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, final XConnectType xConnectType) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BT, ntBleDevice, NtBleConnectState.CONNECTED, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda29
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$46$lambda$40$lambda$39$lambda$38(xConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$40$lambda$39$lambda$38(XConnectType xConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "NtBleConnectStateChanged " + xConnectType + " callback";
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
    public static final Unit connect$lambda$46$lambda$45(final WatchPluginImpl watchPluginImpl, final NtBleDevice ntBleDevice, final NtConnectType ntConnectType, boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onDisConnected " + ntConnectType + StringUtils.SPACE + ntBleDevice + StringUtils.SPACE + i;
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
            updateChannelStatus$default(watchPluginImpl, ntBleDevice, false, 2, null);
            watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda38
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WatchPluginImpl.connect$lambda$46$lambda$45$lambda$44(this.f$0, ntBleDevice, ntConnectType);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$45$lambda$44(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BT, ntBleDevice, NtBleConnectState.DISCONNECTED, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$46$lambda$45$lambda$44$lambda$43(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$46$lambda$45$lambda$44$lambda$43(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "NtBleConnectStateChanged " + ntConnectType + " callback";
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
    public static final Unit connect$lambda$52$lambda$51(final WatchPluginImpl watchPluginImpl, final NtConnectType ntConnectType, final NtBleDevice ntBleDevice, int i, XConnectFailType xConnectFailType) {
        final NtBleConnectState ntBleConnectStateOfRaw = NtBleConnectState.INSTANCE.ofRaw(i);
        if (ntBleConnectStateOfRaw == null) {
            return Unit.INSTANCE;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "setDeviceConnectCallback " + ntConnectType + StringUtils.SPACE + i + StringUtils.SPACE + xConnectFailType;
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
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.connect$lambda$52$lambda$51$lambda$50(this.f$0, ntBleDevice, ntBleConnectStateOfRaw, ntConnectType);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$52$lambda$51$lambda$50(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, NtBleConnectState ntBleConnectState, final NtConnectType ntConnectType) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BT, ntBleDevice, ntBleConnectState, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda79
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$52$lambda$51$lambda$50$lambda$49(ntConnectType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$52$lambda$51$lambda$50$lambda$49(NtConnectType ntConnectType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "NtBleConnectStateChanged " + ntConnectType + " callback";
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
    public static final Unit connect$lambda$59(XConnectCallback connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda21
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.connect$lambda$59$lambda$54((XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        connect.onConnectStart(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.connect$lambda$59$lambda$56();
            }
        });
        connect.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.connect$lambda$59$lambda$58((XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$59$lambda$54(XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onConnectFail " + xBluetoothDevice + "  " + connectFailType;
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
    public static final Unit connect$lambda$59$lambda$56() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "onConnectStart".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "onConnectStart " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "onConnectStart " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$59$lambda$58(XConnectType connectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onConnectSuccess " + connectType + StringUtils.SPACE + xBluetoothDevice;
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
    public static final Unit connect$lambda$83$lambda$64(final WatchPluginImpl watchPluginImpl, final NtBleDevice ntBleDevice, final XCommand xCommand) {
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda80
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.connect$lambda$83$lambda$64$lambda$63(this.f$0, xCommand, ntBleDevice);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$64$lambda$63(WatchPluginImpl watchPluginImpl, XCommand xCommand, NtBleDevice ntBleDevice) {
        String uuid;
        ArrayList arrayListEmptyList;
        byte[] data;
        List<Byte> list;
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
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
            ntBleFlutterApi.valueReceived(uuid, ntBleDevice, arrayListEmptyList, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$83$lambda$64$lambda$63$lambda$62((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$64$lambda$63$lambda$62(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$70(final WatchPluginImpl watchPluginImpl, final String str, final NtBleDevice ntBleDevice, int i, XConnectFailType xConnectFailType) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str2 = "setDeviceConnectCallback " + i + StringUtils.SPACE + xConnectFailType + StringUtils.SPACE;
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
        final NtBleConnectState ntBleConnectStateOfRaw = NtBleConnectState.INSTANCE.ofRaw(i);
        if (ntBleConnectStateOfRaw == null) {
            return Unit.INSTANCE;
        }
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.connect$lambda$83$lambda$70$lambda$69(ntBleConnectStateOfRaw, watchPluginImpl, str, ntBleDevice);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$70$lambda$69(final NtBleConnectState ntBleConnectState, final WatchPluginImpl watchPluginImpl, String str, final NtBleDevice ntBleDevice) {
        if (ntBleConnectState == NtBleConnectState.CONNECTED) {
            watchPluginImpl.startDial(new NtBleDevice(null, null, str, null, null, null, null, null, null, null, null, null, 4091, null), new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$83$lambda$70$lambda$69$lambda$67(this.f$0, ntBleDevice, ntBleConnectState, (Result) obj);
                }
            });
        } else {
            NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
            if (ntBleFlutterApi != null) {
                ntBleFlutterApi.connectStateChanged(NtConnectType.BLE, ntBleDevice, ntBleConnectState, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WatchPluginImpl.connect$lambda$83$lambda$70$lambda$69$lambda$68((Result) obj);
                    }
                });
            }
            updateChannelStatus$default(watchPluginImpl, ntBleDevice, false, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$70$lambda$69$lambda$67(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, NtBleConnectState ntBleConnectState, Result result) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.BLE, ntBleDevice, ntBleConnectState, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$83$lambda$70$lambda$69$lambda$67$lambda$66((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$70$lambda$69$lambda$67$lambda$66(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$70$lambda$69$lambda$68(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$75(final WatchPluginImpl watchPluginImpl, final NtBleDevice ntBleDevice, final int i, int i2) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "setDeviceMtuChangeCallback " + i + StringUtils.SPACE + i2;
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
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.connect$lambda$83$lambda$75$lambda$74(this.f$0, ntBleDevice, i);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$75$lambda$74(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, int i) {
        NtBleFlutterApi ntBleFlutterApi = watchPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.mtuSizeChanged(ntBleDevice, i, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.connect$lambda$83$lambda$75$lambda$74$lambda$73((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$75$lambda$74$lambda$73(Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "nBleMtuChanged callback".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "nBleMtuChanged callback " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "nBleMtuChanged callback " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$82(XConnectCallback connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda59
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.connect$lambda$83$lambda$82$lambda$77((XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        connect.onConnectStart(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda60
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.connect$lambda$83$lambda$82$lambda$79();
            }
        });
        connect.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda61
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.connect$lambda$83$lambda$82$lambda$81((XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$82$lambda$77(XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onConnectFail " + xBluetoothDevice + "  " + connectFailType;
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
    public static final Unit connect$lambda$83$lambda$82$lambda$79() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "onConnectStart".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "onConnectStart " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "onConnectStart " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$83$lambda$82$lambda$81(XConnectType connectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onConnectSuccess " + connectType + StringUtils.SPACE + xBluetoothDevice;
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
        if (logger.isCanLogger(true) && "disconnect -> WATCH".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "disconnect -> WATCH " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "disconnect -> WATCH " + strComponent2);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new AnonymousClass2(realMac, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.WatchPluginImpl$disconnect$2, reason: invalid class name */
    /* JADX INFO: compiled from: WatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.WatchPluginImpl$disconnect$2", f = "WatchPluginImpl.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
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

    public final NtBleService toNtBleService(NtSendKey ntSendKey) {
        Intrinsics.checkNotNullParameter(ntSendKey, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$1[ntSendKey.ordinal()];
        if (i == 1) {
            return this.dataService;
        }
        if (i == 2) {
            return this.dialService;
        }
        if (i == 3) {
            return this.otaService;
        }
        if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
        return this.logService;
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
        NtBleService ntBleService = toNtBleService(sendKey);
        XConnector.writeWithTask$default(NtConnectorExtKt.getConnector$default(priority, NBleDeviceExtKt.toLocal(realMac), sendKey, this.sppService, this.watchCommandParser, 0, 16, null), decodeToByteArray(value), interval, timeout * ((long) 1000), false, false, false, toUUID(ntBleService.getIdentity()), toUUID(ntBleService.getWriteIdentity()), new byte[0], (AtomicInteger) null, true, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.writeValueSync$lambda$91(this.f$0, callback, (XWriteCallback) obj);
            }
        }, 6712, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$91(final WatchPluginImpl watchPluginImpl, final Function1 function1, XWriteCallback writeWithTask) {
        Intrinsics.checkNotNullParameter(writeWithTask, "$this$writeWithTask");
        writeWithTask.onWriteSuccess(new Function4() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda19
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WatchPluginImpl.writeValueSync$lambda$91$lambda$87(this.f$0, function1, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
            }
        });
        writeWithTask.onWriteFail(new Function4() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda20
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WatchPluginImpl.writeValueSync$lambda$91$lambda$90(this.f$0, function1, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$91$lambda$87(WatchPluginImpl watchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] justWrite) {
        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "onWriteSync Success".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "onWriteSync Success " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "onWriteSync Success " + strComponent2);
            }
        }
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda63
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.writeValueSync$lambda$91$lambda$87$lambda$86(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$91$lambda$87$lambda$86(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(CollectionsKt.arrayListOf(1L))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$91$lambda$90(WatchPluginImpl watchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onWriteSync Fail " + throwable;
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
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.writeValueSync$lambda$91$lambda$90$lambda$89(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$91$lambda$90$lambda$89(Function1 function1) {
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
        if (NtSendKey.OTA == key) {
            writeOTAData(priority, device, value, interval, timeout);
        } else if (NtSendKey.LOG == key) {
            writeLogData(priority, device, value);
        } else {
            NtBleService ntBleService = toNtBleService(key);
            XConnector.writeWithTask$default(NtConnectorExtKt.getConnector$default(priority, NBleDeviceExtKt.toLocal(device.getRealMac()), key, this.sppService, this.watchCommandParser, 0, 16, null), decodeToByteArray(value), interval > 0 ? interval : 10L, timeout * ((long) 1000), false, false, false, toUUID(ntBleService.getIdentity()), toUUID(ntBleService.getWriteIdentity()), new byte[0], (AtomicInteger) null, true, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.writeValue$lambda$95((XWriteCallback) obj);
                }
            }, 6712, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$95(XWriteCallback writeWithTask) {
        Intrinsics.checkNotNullParameter(writeWithTask, "$this$writeWithTask");
        writeWithTask.onWriteSuccess(new Function4() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda77
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WatchPluginImpl.writeValue$lambda$95$lambda$92((XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
            }
        });
        writeWithTask.onWriteFail(new Function4() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda82
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WatchPluginImpl.writeValue$lambda$95$lambda$94((XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$95$lambda$92(XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] justWrite) {
        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$95$lambda$94(XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onWriteFail " + throwable;
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

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.WatchPluginImpl$writeLogData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.WatchPluginImpl$writeLogData$1", f = "WatchPluginImpl.kt", i = {}, l = {486}, m = "invokeSuspend", n = {}, s = {})
    static final class C09561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtBleDevice $device;
        final /* synthetic */ NtChannelPriority $priority;
        final /* synthetic */ String $value;
        int label;
        final /* synthetic */ WatchPluginImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09561(NtChannelPriority ntChannelPriority, NtBleDevice ntBleDevice, WatchPluginImpl watchPluginImpl, String str, Continuation<? super C09561> continuation) {
            super(2, continuation);
            this.$priority = ntChannelPriority;
            this.$device = ntBleDevice;
            this.this$0 = watchPluginImpl;
            this.$value = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09561(this.$priority, this.$device, this.this$0, this.$value, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$priority == NtChannelPriority.ONLY_SPP || this.$priority == NtChannelPriority.SPP_FIRST) {
                    XConnectorDevice device = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(this.$device.getRealMac()));
                    String logIdentity = this.this$0.getSppService().getLogIdentity();
                    if (logIdentity == null) {
                        logIdentity = "";
                    }
                    if (device.spp(logIdentity, "LogSppWriter", 11, this.this$0.watchCommandParser).checkIsConnectState()) {
                        XConnectorDevice device2 = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(this.$device.getRealMac()));
                        String logIdentity2 = this.this$0.getSppService().getLogIdentity();
                        device2.spp(logIdentity2 != null ? logIdentity2 : "", "LogSppWriter", 11, this.this$0.watchCommandParser).write(new XCommand("logSpp", 0, 0, false, 0, 0, 0, this.this$0.decodeToByteArray(this.$value), null, null, 894, null));
                        Unit unit = Unit.INSTANCE;
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "writeValue sppLog  " + unit + StringUtils.SPACE;
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
                    if (this.$priority == NtChannelPriority.ONLY_SPP) {
                        return Unit.INSTANCE;
                    }
                }
                XBleConnector xBleConnectorBle = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(this.$device.getRealMac())).ble(this.this$0.watchCommandParser, "BleWriter");
                XCommand xCommand = new XCommand(Methods.log, 0, 0, false, 0, 0, 0, this.this$0.decodeToByteArray(this.$value), null, null, 894, null);
                WatchPluginImpl watchPluginImpl = this.this$0;
                String uuid = watchPluginImpl.toUUID(watchPluginImpl.getLogService().getIdentity());
                WatchPluginImpl watchPluginImpl2 = this.this$0;
                this.label = 1;
                if (xBleConnectorBle.write(xCommand, uuid, watchPluginImpl2.toUUID(watchPluginImpl2.getLogService().getWriteIdentity()), this.this$0.decodeToByteArray(this.$value), 10L, this) == coroutine_suspended) {
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

    private final void writeLogData(NtChannelPriority priority, NtBleDevice device, String value) {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09561(priority, device, this, value, null), 3, null);
    }

    private final void writeOTAData(NtChannelPriority priority, NtBleDevice device, String value, long interval, long timeout) {
        if (priority == NtChannelPriority.ONLY_SPP || priority == NtChannelPriority.SPP_FIRST) {
            XConnectorDevice device2 = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(device.getRealMac()));
            String otaIdentity = this.sppService.getOtaIdentity();
            if (otaIdentity == null) {
                otaIdentity = "";
            }
            if (device2.sppOTA(otaIdentity, "OTASppWriter", 11, this.watchCommandParser).checkIsConnectState()) {
                XConnectorDevice device3 = XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(device.getRealMac()));
                String otaIdentity2 = this.sppService.getOtaIdentity();
                device3.sppOTA(otaIdentity2 != null ? otaIdentity2 : "", "OTASppWriter", 11, this.watchCommandParser).write(new XCommand("otaSpp", 0, 0, false, 0, 0, 0, decodeToByteArray(value), null, null, 894, null));
                Unit unit = Unit.INSTANCE;
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "writeValue sppOTA  " + unit + StringUtils.SPACE;
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
            if (priority == NtChannelPriority.ONLY_SPP) {
                return;
            }
        }
        XConnector.writeWithTask$default((XConnector) XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(device.getRealMac())).ble(this.watchCommandParser, "BleWriter"), decodeToByteArray(value), interval > 0 ? interval : 10L, timeout * ((long) 1000), false, false, false, toUUID(this.otaService.getIdentity()), toUUID(this.otaService.getWriteIdentity()), new byte[0], (AtomicInteger) null, true, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.writeOTAData$lambda$100((XWriteCallback) obj);
            }
        }, 6712, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeOTAData$lambda$100(XWriteCallback writeWithTask) {
        Intrinsics.checkNotNullParameter(writeWithTask, "$this$writeWithTask");
        writeWithTask.onWriteSuccess(new Function4() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WatchPluginImpl.writeOTAData$lambda$100$lambda$97((XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
            }
        });
        writeWithTask.onWriteFail(new Function4() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda36
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return WatchPluginImpl.writeOTAData$lambda$100$lambda$99((XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeOTAData$lambda$100$lambda$97(XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] justWrite) {
        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeOTAData$lambda$100$lambda$99(XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onWriteFail " + throwable;
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
    public void startOta(NtBleDevice device, String filePath, String firmwareVersion, final Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(firmwareVersion, "firmwareVersion");
        Intrinsics.checkNotNullParameter(callback, "callback");
        enableNotification(NBleDeviceExtKt.toLocal(device.getMac()), toUUID(this.otaService.getIdentity()), toUUID(this.otaService.getReceiveIdentity()), 0L, true, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.startOta$lambda$106(this.f$0, callback, (XCommonTaskCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startOta$lambda$106(final WatchPluginImpl watchPluginImpl, final Function1 function1, XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda64
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WatchPluginImpl.startOta$lambda$106$lambda$103(this.f$0, function1, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        enableNotification.onFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda65
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.startOta$lambda$106$lambda$105(this.f$0, function1, (XBluetoothDevice) obj, (Throwable) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startOta$lambda$106$lambda$103(WatchPluginImpl watchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "SendKey.OTA enableNotification " + z;
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
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.startOta$lambda$106$lambda$103$lambda$102(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startOta$lambda$106$lambda$103$lambda$102(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startOta$lambda$106$lambda$105(WatchPluginImpl watchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda81
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.startOta$lambda$106$lambda$105$lambda$104(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startOta$lambda$106$lambda$105$lambda$104(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void stopOta(NtBleDevice device, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callback, "callback");
        enableNotification(NBleDeviceExtKt.toLocal(device.getMac()), toUUID(this.otaService.getIdentity()), toUUID(this.otaService.getReceiveIdentity()), 0L, false, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.stopOta$lambda$109((XCommonTaskCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopOta$lambda$109(XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda83
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WatchPluginImpl.stopOta$lambda$109$lambda$108((XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopOta$lambda$109$lambda$108(XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "SendKey.OTA enableNotification " + z;
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

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void startDial(NtBleDevice device, final Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String str = device.getRealMac() + "_" + toUUID(this.dialService.getReceiveIdentity());
        if (Intrinsics.areEqual((Object) this.channelMap.get(str), (Object) true)) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "[Dial] start dial channel in cache".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str2 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                FileLog.print$default(fileLog, 3, str2, tag, "[Dial] start dial channel in cache " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "[Dial] start dial channel in cache " + strComponent2);
                }
            }
            callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda44
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WatchPluginImpl.startDial$lambda$111(callback);
                }
            });
            return;
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true) && "[Dial] start dial channel by ble ".length() != 0) {
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str3 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog2, 3, str3, tag2, "[Dial] start dial channel by ble  " + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, "[Dial] start dial channel by ble  " + strComponent4);
            }
        }
        enableNotification(NBleDeviceExtKt.toLocal(device.getRealMac()), toUUID(this.dialService.getIdentity()), toUUID(this.dialService.getReceiveIdentity()), 0L, true, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda55
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.startDial$lambda$117(this.f$0, str, callback, (XCommonTaskCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDial$lambda$111(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDial$lambda$117(final WatchPluginImpl watchPluginImpl, final String str, final Function1 function1, XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WatchPluginImpl.startDial$lambda$117$lambda$114(this.f$0, str, function1, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        enableNotification.onFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.startDial$lambda$117$lambda$116(this.f$0, str, function1, (XBluetoothDevice) obj, (Throwable) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDial$lambda$117$lambda$114(WatchPluginImpl watchPluginImpl, String str, final Function1 function1, XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        watchPluginImpl.channelMap.put(str, true);
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.startDial$lambda$117$lambda$114$lambda$113(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDial$lambda$117$lambda$114$lambda$113(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDial$lambda$117$lambda$116(WatchPluginImpl watchPluginImpl, String str, final Function1 function1, XBluetoothDevice xBluetoothDevice, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        watchPluginImpl.channelMap.put(str, false);
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda39
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.startDial$lambda$117$lambda$116$lambda$115(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startDial$lambda$117$lambda$116$lambda$115(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void stopDial(NtBleDevice device, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callback, "callback");
        updateChannelStatus$default(this, device, false, 2, null);
        enableNotification(NBleDeviceExtKt.toLocal(device.getRealMac()), toUUID(this.dialService.getIdentity()), toUUID(this.dialService.getReceiveIdentity()), 0L, false, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.stopDial$lambda$119((XCommonTaskCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopDial$lambda$119(XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WatchPluginImpl.stopDial$lambda$119$lambda$118((XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopDial$lambda$119$lambda$118(XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Unit.INSTANCE;
    }

    static /* synthetic */ void updateChannelStatus$default(WatchPluginImpl watchPluginImpl, NtBleDevice ntBleDevice, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        watchPluginImpl.updateChannelStatus(ntBleDevice, z);
    }

    private final void updateChannelStatus(NtBleDevice device, boolean enable) {
        this.channelMap.put(device.getRealMac() + "_" + toUUID(this.dialService.getReceiveIdentity()), Boolean.valueOf(enable));
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void startLog(NtBleDevice device, final Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.startLog(device, callback);
        enableNotification(NBleDeviceExtKt.toLocal(device.getMac()), toUUID(this.logService.getIdentity()), toUUID(this.logService.getReceiveIdentity()), 0L, true, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.startLog$lambda$124(this.f$0, callback, (XCommonTaskCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startLog$lambda$124(final WatchPluginImpl watchPluginImpl, final Function1 function1, XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda57
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WatchPluginImpl.startLog$lambda$124$lambda$121(this.f$0, function1, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        enableNotification.onFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda58
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.startLog$lambda$124$lambda$123(this.f$0, function1, (XBluetoothDevice) obj, (Throwable) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startLog$lambda$124$lambda$121(WatchPluginImpl watchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.startLog$lambda$124$lambda$121$lambda$120(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startLog$lambda$124$lambda$121$lambda$120(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startLog$lambda$124$lambda$123(WatchPluginImpl watchPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return WatchPluginImpl.startLog$lambda$124$lambda$123$lambda$122(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startLog$lambda$124$lambda$123$lambda$122(Function1 function1) {
        Result.Companion companion = Result.INSTANCE;
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void stopLog(NtBleDevice device, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callback, "callback");
        super.stopLog(device, callback);
        enableNotification(NBleDeviceExtKt.toLocal(device.getMac()), toUUID(this.logService.getIdentity()), toUUID(this.logService.getReceiveIdentity()), 0L, false, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.stopLog$lambda$126((XCommonTaskCallback) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopLog$lambda$126(XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WatchPluginImpl.stopLog$lambda$126$lambda$125((XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopLog$lambda$126$lambda$125(XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return Unit.INSTANCE;
    }

    static /* synthetic */ void enableNotification$default(WatchPluginImpl watchPluginImpl, String str, String str2, String str3, long j, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            j = 0;
        }
        watchPluginImpl.enableNotification(str, str2, str3, j, (i & 16) != 0 ? true : z, function1);
    }

    private final void enableNotification(String address, String serviceUUID, String notifyUUID, long interval, boolean enable, Function1<? super XCommonTaskCallback, Unit> callback) {
        if (enable) {
            XBaseBleConnector.enableCharacteristicNotifyWithTask$default(XConnectorDevice.ble$default(XBluetoothManager.INSTANCE.get().getDevice(address), null, null, 3, null), serviceUUID, notifyUUID, true, interval, callback, "", false, null, 192, null);
        } else {
            XBaseBleConnector.enableCharacteristicNotifyWithTask$default(XConnectorDevice.ble$default(XBluetoothManager.INSTANCE.get().getDevice(address), null, null, 3, null), serviceUUID, notifyUUID, false, interval, callback, "", false, null, 192, null);
        }
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void bindFinished(final NtBleDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        enableNotification$default(this, NBleDeviceExtKt.toLocal(device.getMac()), toUUID(this.pairService.getIdentity()), toUUID(this.pairService.getReceiveIdentity()), 0L, true, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda66
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.bindFinished$lambda$136(device, this, (XCommonTaskCallback) obj);
            }
        }, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindFinished$lambda$136(final NtBleDevice ntBleDevice, final WatchPluginImpl watchPluginImpl, XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WatchPluginImpl.bindFinished$lambda$136$lambda$133(ntBleDevice, watchPluginImpl, (XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        enableNotification.onFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.bindFinished$lambda$136$lambda$135((XBluetoothDevice) obj, (Throwable) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindFinished$lambda$136$lambda$133(NtBleDevice ntBleDevice, WatchPluginImpl watchPluginImpl, XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "bindFinished notify true success!" + xBluetoothDevice + StringUtils.SPACE + z + StringUtils.SPACE + data;
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
        watchPluginImpl.enableNotification(NBleDeviceExtKt.toLocal(ntBleDevice.getMac()), watchPluginImpl.toUUID(watchPluginImpl.pairService.getIdentity()), watchPluginImpl.toUUID(watchPluginImpl.pairService.getReceiveIdentity()), 2000L, false, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WatchPluginImpl.bindFinished$lambda$136$lambda$133$lambda$132((XCommonTaskCallback) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindFinished$lambda$136$lambda$133$lambda$132(XCommonTaskCallback enableNotification) {
        Intrinsics.checkNotNullParameter(enableNotification, "$this$enableNotification");
        enableNotification.onFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return WatchPluginImpl.bindFinished$lambda$136$lambda$133$lambda$132$lambda$129((XBluetoothDevice) obj, (Throwable) obj2);
            }
        });
        enableNotification.onSuccess(new Function3() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return WatchPluginImpl.bindFinished$lambda$136$lambda$133$lambda$132$lambda$131((XBluetoothDevice) obj, ((Boolean) obj2).booleanValue(), obj3);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindFinished$lambda$136$lambda$133$lambda$132$lambda$129(XBluetoothDevice xBluetoothDevice, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "2.bindFinished notify false failed! " + xBluetoothDevice + StringUtils.SPACE + throwable;
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
    public static final Unit bindFinished$lambda$136$lambda$133$lambda$132$lambda$131(XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "2.bindFinished notify false success!" + xBluetoothDevice + StringUtils.SPACE + z + StringUtils.SPACE + data;
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
    public static final Unit bindFinished$lambda$136$lambda$135(XBluetoothDevice xBluetoothDevice, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "enableNotification failed when bindFinished".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 5, str, tag, "enableNotification failed when bindFinished " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.w(tag + strComponent1, "enableNotification failed when bindFinished " + strComponent2);
            }
        }
        return Unit.INSTANCE;
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
            Result.Companion companion2 = Result.INSTANCE;
            callback.invoke(Result.m6346boximpl(Result.m6347constructorimpl(null)));
            Result.m6347constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: WatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1", f = "WatchPluginImpl.kt", i = {}, l = {789}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        final /* synthetic */ NtBtProfile $profile;
        final /* synthetic */ String $realMac;
        final /* synthetic */ NtSendKey $sendKey;
        final /* synthetic */ long $timeout;
        int label;
        final /* synthetic */ WatchPluginImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(NtSendKey ntSendKey, String str, WatchPluginImpl watchPluginImpl, long j, NtBtProfile ntBtProfile, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$sendKey = ntSendKey;
            this.$realMac = str;
            this.this$0 = watchPluginImpl;
            this.$timeout = j;
            this.$profile = ntBtProfile;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$sendKey, this.$realMac, this.this$0, this.$timeout, this.$profile, this.$callback, continuation);
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
                if (logger.isCanLogger(true) && "Watch connectSync isConnected".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "Watch connectSync isConnected " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "Watch connectSync isConnected " + strComponent2);
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
                        String str2 = "Watch connectSync " + thM6350exceptionOrNullimpl;
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
            final WatchPluginImpl watchPluginImpl = this.this$0;
            final String str5 = this.$realMac;
            sppConnector.setMessageReceiveCallback("watch_sync", new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$10$lambda$7(watchPluginImpl, str5, (XCommand) obj2);
                }
            });
            sppConnector.setDeviceConnectCallback("watch_sync", new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$10$lambda$9(((Integer) obj2).intValue(), (XConnectFailType) obj3);
                }
            });
            XBaseSppConnector xBaseSppConnector = sppConnector;
            Long lBoxLong = Boxing.boxLong(this.$timeout * ((long) 1000));
            int profile = NtBtProfileExtKt.toProfile(this.$profile);
            final Function1<Result<Boolean>, Unit> function2 = this.$callback;
            XConnector.connect$default(xBaseSppConnector, lBoxLong, null, null, null, false, false, false, profile, false, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$23(function2, (XConnectCallback) obj2);
                }
            }, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$27((XBluetoothFlowCallBack) obj2);
                }
            }, 382, null);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$10$lambda$7(final WatchPluginImpl watchPluginImpl, final String str, final XCommand xCommand) {
            watchPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$10$lambda$7$lambda$6(watchPluginImpl, xCommand, str);
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$10$lambda$7$lambda$6(WatchPluginImpl watchPluginImpl, XCommand xCommand, String str) {
            String uuid;
            ArrayList arrayListEmptyList;
            byte[] data;
            List<Byte> list;
            NtBleFlutterApi flutterApi = watchPluginImpl.getFlutterApi();
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
                flutterApi.valueReceived(uuid, ntBleDevice, arrayListEmptyList, new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$10$lambda$7$lambda$6$lambda$5((Result) obj);
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
                String str = "watch_sync setDeviceConnectCallback " + i;
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
        public static final Unit invokeSuspend$lambda$23(final Function1 function1, XConnectCallback xConnectCallback) {
            xConnectCallback.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$23$lambda$15(function1, (XConnectType) obj, (XBluetoothDevice) obj2);
                }
            });
            xConnectCallback.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$23$lambda$17((XBluetoothDevice) obj, (XConnectFailType) obj2);
                }
            });
            xConnectCallback.onDisConnected(new Function4() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$23$lambda$22(function1, ((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
                }
            });
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$23$lambda$15(Function1 function1, XConnectType xConnectType, XBluetoothDevice xBluetoothDevice) {
            Object objM6347constructorimpl;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "spp connectSync -> onConnectSuccess".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "spp connectSync -> onConnectSuccess " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "spp connectSync -> onConnectSuccess " + strComponent2);
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
                    String str2 = "spp connectSync 111-> " + thM6350exceptionOrNullimpl;
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
            if (logger.isCanLogger(true) && "spp connectSync -> onConnectFail".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "spp connectSync -> onConnectFail " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "spp connectSync -> onConnectFail " + strComponent2);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$23$lambda$22(Function1 function1, boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
            Object objM6347constructorimpl;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "spp connectSync -> onDisConnected".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "spp connectSync -> onDisConnected " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "spp connectSync -> onDisConnected " + strComponent2);
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
                    String str2 = "spp connectSync 111-> " + thM6350exceptionOrNullimpl;
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
            xBluetoothFlowCallBack.onRequestPermission(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$27$lambda$24((Function1) obj);
                }
            });
            xBluetoothFlowCallBack.onRequestBluetooth(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$27$lambda$25((Function1) obj);
                }
            });
            xBluetoothFlowCallBack.onRequestGps(new Function1() { // from class: com.nothing.nt_ble.plugin.WatchPluginImpl$connectSync$1$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return WatchPluginImpl.AnonymousClass1.invokeSuspend$lambda$27$lambda$26((Function1) obj);
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
            String str = "close spp connectSync -> " + sendKey.name() + " connectType=" + connectType.name();
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
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09542(sendKey, device, this, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.WatchPluginImpl$disconnectByType$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.WatchPluginImpl$disconnectByType$2", f = "WatchPluginImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09542 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtBleDevice $device;
        final /* synthetic */ NtSendKey $sendKey;
        int label;
        final /* synthetic */ WatchPluginImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09542(NtSendKey ntSendKey, NtBleDevice ntBleDevice, WatchPluginImpl watchPluginImpl, Continuation<? super C09542> continuation) {
            super(2, continuation);
            this.$sendKey = ntSendKey;
            this.$device = ntBleDevice;
            this.this$0 = watchPluginImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09542(this.$sendKey, this.$device, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09542) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                String str = "close spp do getSppConnector spp=" + sppConnector + " device.realMac=" + ntBleDevice.getRealMac() + StringUtils.SPACE;
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

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.WatchPluginImpl$turnOffSpp$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: WatchPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.WatchPluginImpl$turnOffSpp$1", f = "WatchPluginImpl.kt", i = {}, l = {TypedValues.Custom.TYPE_BOOLEAN, 922}, m = "invokeSuspend", n = {}, s = {})
    static final class C09551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
        final /* synthetic */ String $realMac;
        final /* synthetic */ NtSendKey $sendKey;
        int label;
        final /* synthetic */ WatchPluginImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09551(NtSendKey ntSendKey, String str, WatchPluginImpl watchPluginImpl, Function1<? super Result<Boolean>, Unit> function1, Continuation<? super C09551> continuation) {
            super(2, continuation);
            this.$sendKey = ntSendKey;
            this.$realMac = str;
            this.this$0 = watchPluginImpl;
            this.$callback = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C09551(this.$sendKey, this.$realMac, this.this$0, this.$callback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:40:0x0104, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.nt_ble.plugin.WatchPluginImpl.C09551.C01901(r7.$callback, null), r7) == r0) goto L41;
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

        /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.WatchPluginImpl$turnOffSpp$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WatchPluginImpl.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.nt_ble.plugin.WatchPluginImpl$turnOffSpp$1$1", f = "WatchPluginImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Result<Boolean>, Unit> $callback;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01901(Function1<? super Result<Boolean>, Unit> function1, Continuation<? super C01901> continuation) {
                super(2, continuation);
                this.$callback = function1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01901(this.$callback, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01901) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09551(sendKey, realMac, this, callback, null), 3, null);
    }
}
