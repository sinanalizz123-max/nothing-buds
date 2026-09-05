package com.nothing.nt_ble.plugin;

import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.util.Log;
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
import com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector;
import com.nothing.link.bluetooth.sdk.connect.spp.XSppConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.device.XConnectorDevice;
import com.nothing.link.bluetooth.sdk.scan.XBluetoothFlowCallBack;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.link.bluetooth.sdk.util.NTPluginManager;
import com.nothing.log.FileLog;
import com.nothing.network.core.ApiResponseKt;
import com.nothing.nt_ble.EarphonesCommandParser;
import com.nothing.nt_ble.ext.NBleDeviceExtKt;
import com.nothing.nt_ble.ext.NtBtProfileExtKt;
import com.nothing.nt_ble.ext.NtConnectorExtKt;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.mime.MimeTypesReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EarphonesPluginImpl.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00a4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016JJ\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0018\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020\u00160#H\u0016J \u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0018\u0010-\u001a\u00020\u00162\u0006\u0010.\u001a\u00020/2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*H\u0016J \u00101\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016Jh\u00102\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00192\u0006\u00106\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020*2\u001e\u0010\"\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b070$\u0012\u0004\u0012\u00020\u00160#H\u0016J8\u00108\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0006\u00109\u001a\u00020\u001f2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00106\u001a\u00020\u001bH\u0016J:\u0010:\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0006\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020\u00192\u0018\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020\u00160#H\u0016J'\u0010=\u001a\u0013\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u00020\u00160#\u00a2\u0006\u0002\b?2\u0006\u0010)\u001a\u00020*2\u0006\u0010.\u001a\u00020/J\u001f\u0010@\u001a\u0013\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\u00160#\u00a2\u0006\u0002\b?2\u0006\u0010)\u001a\u00020*J*\u0010B\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*2\u0018\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020\u00160#H\u0016J,\u0010C\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u001a\u0010\"\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010D0$\u0012\u0004\u0012\u00020\u00160#H\u0016JJ\u0010E\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0018\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020\u00160#H\u0016J:\u0010G\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010F\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0018\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020\u00160#H\u0016J*\u0010H\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0018\u0010\"\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$\u0012\u0004\u0012\u00020\u00160#H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006I"}, d2 = {"Lcom/nothing/nt_ble/plugin/EarphonesPluginImpl;", "Lcom/nothing/nt_ble/plugin/UnknownImpl;", "<init>", "()V", "commandParser", "Lcom/nothing/nt_ble/EarphonesCommandParser;", "otaService", "Lcom/nothing/generate/NtBleService;", "dataService", "getDataService", "()Lcom/nothing/generate/NtBleService;", "setDataService", "(Lcom/nothing/generate/NtBleService;)V", "sppService", "Lcom/nothing/generate/NtSppService;", "getSppService", "()Lcom/nothing/generate/NtSppService;", "setSppService", "(Lcom/nothing/generate/NtSppService;)V", "flutterApi", "Lcom/nothing/generate/NtBleFlutterApi;", "initPlugin", "", "connectSync", "realMac", "", "timeout", "", "deviceType", "Lcom/nothing/generate/NtDeviceType;", "sendKey", "Lcom/nothing/generate/NtSendKey;", "profile", "Lcom/nothing/generate/NtBtProfile;", "callback", "Lkotlin/Function1;", "Lkotlin/Result;", "", "connect", "connectType", "Lcom/nothing/generate/NtConnectType;", "device", "Lcom/nothing/generate/NtBleDevice;", "set", "Lcom/nothing/generate/NtBleScanSet;", "setDeviceConnectCallback", "connector", "Lcom/nothing/link/bluetooth/sdk/connect/spp/XSppConnector;", DeviceEarImage.DISCONNECT_EAR_IMAGE, "disconnectByType", "writeValueSync", MimeTypesReaderMetKeys.MAGIC_PRIORITY_ATTR, "Lcom/nothing/generate/NtChannelPriority;", "value", "interval", "", "writeValue", "key", "startOta", "filePath", "firmwareVersion", "connectCallback", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;", "Lkotlin/ExtensionFunctionType;", "bluetoothFlowCallBack", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "stopOta", "getBluetoothAlias", "Lcom/nothing/generate/BluetoothInfo;", "turnOnSpp", "type", "turnOffSpp", "iosGetAncsAuthorized", "nt_ble_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EarphonesPluginImpl extends UnknownImpl {
    private NtBleFlutterApi flutterApi;
    private final EarphonesCommandParser commandParser = new EarphonesCommandParser();
    private NtBleService otaService = new NtBleService("FD90", "66666666-6666-6666-6666-666666666666", "77777777-7777-7777-7777-777777777777");
    private NtBleService dataService = new NtBleService("FD90", "CA235943-1810-45E6-8326-FC8CA3BC45CE", "68745353-1810-4B13-83A2-C1B21B652C9B");
    private NtSppService sppService = new NtSppService("AEAC4A03-DFF5-498F-843A-34487CF133EB", "66666666-6666-6666-6666-666666666666", null, null, 12, null);

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void iosGetAncsAuthorized(String realMac, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(callback, "callback");
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

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.nt_ble.plugin.PluginImpl
    public void initPlugin(NtBleFlutterApi flutterApi) {
        this.flutterApi = flutterApi;
        if (flutterApi != null) {
            flutterApi.getEarNormalService(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.initPlugin$lambda$9$lambda$2(this.f$0, (Result) obj);
                }
            });
            flutterApi.getEarSppService(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.initPlugin$lambda$9$lambda$5(this.f$0, (Result) obj);
                }
            });
            flutterApi.getEarOtaService(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.initPlugin$lambda$9$lambda$8(this.f$0, (Result) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initPlugin$lambda$9$lambda$2(EarphonesPluginImpl earphonesPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtBleService ntBleService = (NtBleService) value;
            earphonesPluginImpl.dataService = ntBleService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "DATA serviceUUID=" + ntBleService.getIdentity() + ",notifyUUID=" + ntBleService.getReceiveIdentity() + ",writeUUID=" + ntBleService.getWriteIdentity();
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
    public static final Unit initPlugin$lambda$9$lambda$5(EarphonesPluginImpl earphonesPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtSppService ntSppService = (NtSppService) value;
            earphonesPluginImpl.sppService = ntSppService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "SPP normalIdentity=" + ntSppService.getNormalIdentity() + ",otaIdentity=" + ntSppService.getOtaIdentity();
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
    public static final Unit initPlugin$lambda$9$lambda$8(EarphonesPluginImpl earphonesPluginImpl, Result result) {
        Object value = result.getValue();
        if (Result.m6354isSuccessimpl(value)) {
            NtBleService ntBleService = (NtBleService) value;
            earphonesPluginImpl.otaService = ntBleService;
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "OTA serviceUUID=" + ntBleService.getIdentity() + ",notifyUUID=" + ntBleService.getReceiveIdentity() + ",writeUUID=" + ntBleService.getWriteIdentity();
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
    public void connectSync(String realMac, long timeout, NtDeviceType deviceType, NtSendKey sendKey, NtBtProfile profile, final Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(sendKey, "sendKey");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(callback, "callback");
        XConnector.connect$default(NtConnectorExtKt.getSppConnector$default(sendKey, realMac, this.sppService, this.commandParser, 0, 8, null), Long.valueOf(((long) 1000) * timeout), null, null, null, false, false, false, NtBtProfileExtKt.toProfile(profile), false, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.connectSync$lambda$20(this.f$0, callback, (XConnectCallback) obj);
            }
        }, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.connectSync$lambda$24((XBluetoothFlowCallBack) obj);
            }
        }, 382, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$20(final EarphonesPluginImpl earphonesPluginImpl, final Function1 function1, XConnectCallback connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda32
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EarphonesPluginImpl.connectSync$lambda$20$lambda$13(this.f$0, function1, (XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        connect.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda34
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EarphonesPluginImpl.connectSync$lambda$20$lambda$17(this.f$0, function1, (XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        connect.onDisConnected(new Function4() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda35
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EarphonesPluginImpl.connectSync$lambda$20$lambda$19(((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$20$lambda$13(EarphonesPluginImpl earphonesPluginImpl, final Function1 function1, XConnectType xConnectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(xConnectType, "<unused var>");
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
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda25
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.connectSync$lambda$20$lambda$13$lambda$12(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$20$lambda$13$lambda$12(Function1 function1) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.Companion companion2 = Result.INSTANCE;
            function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(true)));
            Result.m6347constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$20$lambda$17(EarphonesPluginImpl earphonesPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, XConnectFailType connectType) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "spp connectSync -> onConnectFail " + connectType;
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
        if (Intrinsics.areEqual(connectType, XConnectFailType.connectPeerPaired.INSTANCE)) {
            return Unit.INSTANCE;
        }
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.connectSync$lambda$20$lambda$17$lambda$16(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$20$lambda$17$lambda$16(Function1 function1) {
        try {
            Result.Companion companion = Result.INSTANCE;
            Result.Companion companion2 = Result.INSTANCE;
            function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(false)));
            Result.m6347constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion3 = Result.INSTANCE;
            Result.m6347constructorimpl(ResultKt.createFailure(th));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$20$lambda$19(boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
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
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$24(XBluetoothFlowCallBack connect) {
        Intrinsics.checkNotNullParameter(connect, "$this$connect");
        connect.onRequestPermission(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.connectSync$lambda$24$lambda$21((Function1) obj);
            }
        });
        connect.onRequestBluetooth(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.connectSync$lambda$24$lambda$22((Function1) obj);
            }
        });
        connect.onRequestGps(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.connectSync$lambda$24$lambda$23((Function1) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$24$lambda$21(Function1 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.invoke(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$24$lambda$22(Function1 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.invoke(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectSync$lambda$24$lambda$23(Function1 it) {
        Intrinsics.checkNotNullParameter(it, "it");
        it.invoke(false);
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void connect(NtConnectType connectType, final NtBleDevice device, NtBleScanSet set) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(set, "set");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ear connect connectType\uff1a" + connectType + " ,device:" + device.getRealMac() + ",deviceType:" + device.getDeviceType() + "!";
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
        String normalIdentity = this.sppService.getNormalIdentity();
        if (normalIdentity == null) {
            normalIdentity = "";
        }
        XSppConnector xSppConnectorSpp$default = XConnectorDevice.spp$default(XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(realMac)), normalIdentity, null, 0, this.commandParser, 6, null);
        xSppConnectorSpp$default.setMessageReceiveCallback("flutter", new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda42
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.connect$lambda$30(this.f$0, device, (XCommand) obj);
            }
        });
        setDeviceConnectCallback(xSppConnectorSpp$default, device);
        XConnector.connect$default(xSppConnectorSpp$default, null, null, null, null, false, false, false, 0, false, connectCallback(device, xSppConnectorSpp$default), bluetoothFlowCallBack(device), 511, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$30(final EarphonesPluginImpl earphonesPluginImpl, final NtBleDevice ntBleDevice, final XCommand xCommand) {
        String command;
        Object objM6347constructorimpl;
        if (xCommand == null || (command = xCommand.getCommand()) == null) {
            command = "";
        }
        String upperCase = command.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (StringsKt.startsWith$default(upperCase, "0XFC", false, 2, (Object) null) && upperCase.length() >= 6) {
            String strSubstring = upperCase.substring(4, 6);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            try {
                Result.Companion companion = Result.INSTANCE;
                objM6347constructorimpl = Result.m6347constructorimpl(Integer.valueOf(Integer.parseInt(strSubstring, CharsKt.checkRadix(16))));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            Integer num = (Integer) (Result.m6353isFailureimpl(objM6347constructorimpl) ? null : objM6347constructorimpl);
            if (num != null && new IntRange(1, 64).contains(num.intValue())) {
                return Unit.INSTANCE;
            }
        }
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda23
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.connect$lambda$30$lambda$29(this.f$0, xCommand, ntBleDevice);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$30$lambda$29(EarphonesPluginImpl earphonesPluginImpl, XCommand xCommand, NtBleDevice ntBleDevice) {
        String uuid;
        ArrayList arrayListEmptyList;
        byte[] data;
        List<Byte> list;
        NtBleFlutterApi ntBleFlutterApi = earphonesPluginImpl.flutterApi;
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
            ntBleFlutterApi.valueReceived(uuid, ntBleDevice, arrayListEmptyList, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.connect$lambda$30$lambda$29$lambda$28((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connect$lambda$30$lambda$29$lambda$28(Result result) {
        return Unit.INSTANCE;
    }

    private final void setDeviceConnectCallback(XSppConnector connector, final NtBleDevice device) {
        connector.setDeviceConnectCallback("flutter", new Function2() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda43
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EarphonesPluginImpl.setDeviceConnectCallback$lambda$38(this.f$0, device, ((Integer) obj).intValue(), (XConnectFailType) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r5v2, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v9, types: [T, java.util.Map] */
    public static final Unit setDeviceConnectCallback$lambda$38(final EarphonesPluginImpl earphonesPluginImpl, final NtBleDevice ntBleDevice, int i, final XConnectFailType xConnectFailType) {
        int raw = i;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "flutter setDeviceConnectCallback " + raw + StringUtils.SPACE + ntBleDevice.getRealMac() + StringUtils.SPACE + xConnectFailType;
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
        if (raw == 0 || raw == 1 || raw == 2) {
            NTPluginManager nTPluginManager = NTPluginManager.INSTANCE.get();
            Bundle bundle = new Bundle();
            bundle.putString("address", ntBleDevice.getRealMac());
            bundle.putString("fastPairID", ntBleDevice.getFastPairID());
            Unit unit = Unit.INSTANCE;
            nTPluginManager.onCallHandler("invokeConnectCallback", bundle);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = MapsKt.emptyMap();
        if (Intrinsics.areEqual(xConnectFailType, XConnectFailType.KeyMissingPaired.INSTANCE)) {
            objectRef.element = MapsKt.mapOf(new Pair(10000L, "KeyMissingPaired"));
        } else if (Intrinsics.areEqual(xConnectFailType, XConnectFailType.connectPeerPaired.INSTANCE)) {
            return Unit.INSTANCE;
        }
        if (raw == 4) {
            earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda36
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EarphonesPluginImpl.setDeviceConnectCallback$lambda$38$lambda$35(this.f$0, ntBleDevice, objectRef, xConnectFailType);
                }
            });
            raw = NtBleConnectState.DISCONNECTED.getRaw();
        }
        final NtBleConnectState ntBleConnectStateOfRaw = NtBleConnectState.INSTANCE.ofRaw(raw);
        if (ntBleConnectStateOfRaw == null) {
            return Unit.INSTANCE;
        }
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda37
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.setDeviceConnectCallback$lambda$38$lambda$37(this.f$0, ntBleDevice, ntBleConnectStateOfRaw);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDeviceConnectCallback$lambda$38$lambda$35(EarphonesPluginImpl earphonesPluginImpl, NtBleDevice ntBleDevice, Ref.ObjectRef objectRef, final XConnectFailType xConnectFailType) {
        NtBleFlutterApi ntBleFlutterApi = earphonesPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectFail(ntBleDevice, (Map) objectRef.element, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda26
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.setDeviceConnectCallback$lambda$38$lambda$35$lambda$34(xConnectFailType, (Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDeviceConnectCallback$lambda$38$lambda$35$lambda$34(XConnectFailType xConnectFailType, Result result) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "nBleConnectStateChanged CONNECT_FAILURE " + xConnectFailType + " callback";
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
    public static final Unit setDeviceConnectCallback$lambda$38$lambda$37(EarphonesPluginImpl earphonesPluginImpl, NtBleDevice ntBleDevice, NtBleConnectState ntBleConnectState) {
        NtBleFlutterApi ntBleFlutterApi = earphonesPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.SPP, ntBleDevice, ntBleConnectState, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.setDeviceConnectCallback$lambda$38$lambda$37$lambda$36((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setDeviceConnectCallback$lambda$38$lambda$37$lambda$36(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.EarphonesPluginImpl$disconnect$2, reason: invalid class name */
    /* JADX INFO: compiled from: EarphonesPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.EarphonesPluginImpl$disconnect$2", f = "EarphonesPluginImpl.kt", i = {}, l = {222}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtBleDevice $device;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(NtBleDevice ntBleDevice, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$device = ntBleDevice;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EarphonesPluginImpl.this.new AnonymousClass2(this.$device, continuation);
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
                String normalIdentity = EarphonesPluginImpl.this.getSppService().getNormalIdentity();
                if (normalIdentity == null) {
                    normalIdentity = "";
                }
                String str = normalIdentity;
                this.label = 1;
                if (XConnectorDevice.spp$default(XBluetoothManager.INSTANCE.get().getDevice(NBleDeviceExtKt.toLocal(this.$device.getRealMac())), str, null, 0, EarphonesPluginImpl.this.commandParser, 6, null).disconnect(this) == coroutine_suspended) {
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

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void disconnect(NtBleDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "disconnect -> EARPHONE".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "disconnect -> EARPHONE " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "disconnect -> EARPHONE " + strComponent2);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass2(device, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.nt_ble.plugin.EarphonesPluginImpl$disconnectByType$1, reason: invalid class name */
    /* JADX INFO: compiled from: EarphonesPluginImpl.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.nt_ble.plugin.EarphonesPluginImpl$disconnectByType$1", f = "EarphonesPluginImpl.kt", i = {}, l = {ApiResponseKt.CHECK_EMAIL_OK}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ NtConnectType $connectType;
        final /* synthetic */ NtBleDevice $device;
        final /* synthetic */ NtSendKey $sendKey;
        int label;
        final /* synthetic */ EarphonesPluginImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(NtConnectType ntConnectType, NtSendKey ntSendKey, NtBleDevice ntBleDevice, EarphonesPluginImpl earphonesPluginImpl, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$connectType = ntConnectType;
            this.$sendKey = ntSendKey;
            this.$device = ntBleDevice;
            this.this$0 = earphonesPluginImpl;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$connectType, this.$sendKey, this.$device, this.this$0, continuation);
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
                if (this.$connectType == NtConnectType.SPP) {
                    this.label = 1;
                    if (NtConnectorExtKt.getSppConnector$default(this.$sendKey, NBleDeviceExtKt.toLocal(this.$device.getRealMac()), this.this$0.getSppService(), this.this$0.commandParser, 0, 8, null).disconnect(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
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

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void disconnectByType(NtBleDevice device, NtSendKey sendKey, NtConnectType connectType) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(sendKey, "sendKey");
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(connectType, sendKey, device, this, null), 3, null);
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
        XBaseSppConnector sppConnector$default = NtConnectorExtKt.getSppConnector$default(sendKey, realMac, this.sppService, this.commandParser, 0, 8, null);
        XBaseSppConnector xBaseSppConnector = sppConnector$default;
        XConnector.writeWithTask$default((XConnector) xBaseSppConnector, decodeToByteArray(value), 0L, timeout * ((long) 1000), false, false, false, (String) null, (String) null, (byte[]) null, (AtomicInteger) null, false, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda24
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.writeValueSync$lambda$47(this.f$0, callback, (XWriteCallback) obj);
            }
        }, 8186, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$47(final EarphonesPluginImpl earphonesPluginImpl, final Function1 function1, XWriteCallback writeWithTask) {
        Intrinsics.checkNotNullParameter(writeWithTask, "$this$writeWithTask");
        writeWithTask.onWriteSuccess(new Function4() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda10
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EarphonesPluginImpl.writeValueSync$lambda$47$lambda$43(this.f$0, function1, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
            }
        });
        writeWithTask.onWriteFail(new Function4() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda12
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EarphonesPluginImpl.writeValueSync$lambda$47$lambda$46(this.f$0, function1, (XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$47$lambda$43(EarphonesPluginImpl earphonesPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, int i, int i2, final byte[] justWrite) {
        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "writeValueSync NORMAL onWriteSuccess".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "writeValueSync NORMAL onWriteSuccess " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "writeValueSync NORMAL onWriteSuccess " + strComponent2);
            }
        }
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.writeValueSync$lambda$47$lambda$43$lambda$42(function1, justWrite);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$47$lambda$43$lambda$42(Function1 function1, byte[] bArr) {
        Result.Companion companion = Result.INSTANCE;
        List<Byte> list = ArraysKt.toList(bArr);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(((Number) it.next()).byteValue()));
        }
        function1.invoke(Result.m6346boximpl(Result.m6347constructorimpl(CollectionsKt.toList(arrayList))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$47$lambda$46(EarphonesPluginImpl earphonesPluginImpl, final Function1 function1, XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "writeValueSync NORMAL onWriteFail".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "writeValueSync NORMAL onWriteFail " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "writeValueSync NORMAL onWriteFail " + strComponent2);
            }
        }
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda38
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.writeValueSync$lambda$47$lambda$46$lambda$45(function1);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValueSync$lambda$47$lambda$46$lambda$45(Function1 function1) {
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
        XBaseSppConnector sppConnector$default = NtConnectorExtKt.getSppConnector$default(key, NBleDeviceExtKt.toLocal(device.getRealMac()), this.sppService, this.commandParser, 0, 8, null);
        XBaseSppConnector xBaseSppConnector = sppConnector$default;
        XConnector.writeWithTask$default((XConnector) xBaseSppConnector, decodeToByteArray(value), 0L, timeout * ((long) 1000), false, false, false, (String) null, (String) null, (byte[]) null, (AtomicInteger) null, false, (String) null, (ArrayList) null, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda41
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.writeValue$lambda$51((XWriteCallback) obj);
            }
        }, 8186, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$51(XWriteCallback writeWithTask) {
        Intrinsics.checkNotNullParameter(writeWithTask, "$this$writeWithTask");
        writeWithTask.onWriteSuccess(new Function4() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda30
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EarphonesPluginImpl.writeValue$lambda$51$lambda$48((XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (byte[]) obj4);
            }
        });
        writeWithTask.onWriteFail(new Function4() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda31
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EarphonesPluginImpl.writeValue$lambda$51$lambda$50((XBluetoothDevice) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue(), (Throwable) obj4);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$51$lambda$48(XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] justWrite) {
        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit writeValue$lambda$51$lambda$50(XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable throwable) {
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
    public void startOta(NtBleDevice device, String filePath, String firmwareVersion, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(firmwareVersion, "firmwareVersion");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NTPluginManager nTPluginManager = NTPluginManager.INSTANCE.get();
        Bundle bundle = new Bundle();
        String realMac = device.getRealMac();
        if (realMac == null) {
            realMac = "";
        }
        bundle.putString("address", realMac);
        String fastPairID = device.getFastPairID();
        if (fastPairID == null) {
            fastPairID = "";
        }
        bundle.putString("fastPairID", fastPairID);
        bundle.putString("filePath", filePath);
        String modelId = device.getModelId();
        if (modelId == null) {
            modelId = "";
        }
        bundle.putString("modelId", modelId);
        String colorId = device.getColorId();
        bundle.putString("colorId", colorId != null ? colorId : "");
        Unit unit = Unit.INSTANCE;
        nTPluginManager.onCallHandler("invokeStartOTA", bundle);
    }

    public final Function1<XConnectCallback, Unit> connectCallback(final NtBleDevice device, final XSppConnector connector) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(connector, "connector");
        return new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda40
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.connectCallback$lambda$62(this.f$0, connector, device, (XConnectCallback) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectCallback$lambda$62(final EarphonesPluginImpl earphonesPluginImpl, final XSppConnector xSppConnector, final NtBleDevice ntBleDevice, XConnectCallback xConnectCallback) {
        Intrinsics.checkNotNullParameter(xConnectCallback, "<this>");
        xConnectCallback.onConnectStart(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.connectCallback$lambda$62$lambda$54(this.f$0, xSppConnector, ntBleDevice);
            }
        });
        xConnectCallback.onConnectSuccess(new Function2() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EarphonesPluginImpl.connectCallback$lambda$62$lambda$57(xSppConnector, earphonesPluginImpl, ntBleDevice, (XConnectType) obj, (XBluetoothDevice) obj2);
            }
        });
        xConnectCallback.onConnectFail(new Function2() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda15
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return EarphonesPluginImpl.connectCallback$lambda$62$lambda$59((XBluetoothDevice) obj, (XConnectFailType) obj2);
            }
        });
        xConnectCallback.onDisConnected(new Function4() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda16
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return EarphonesPluginImpl.connectCallback$lambda$62$lambda$61(((Boolean) obj).booleanValue(), (XBluetoothDevice) obj2, (BluetoothGatt) obj3, ((Integer) obj4).intValue());
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectCallback$lambda$62$lambda$54(EarphonesPluginImpl earphonesPluginImpl, XSppConnector xSppConnector, NtBleDevice ntBleDevice) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "spp -> onConnectStart".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "spp -> onConnectStart " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "spp -> onConnectStart " + strComponent2);
            }
        }
        earphonesPluginImpl.setDeviceConnectCallback(xSppConnector, ntBleDevice);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectCallback$lambda$62$lambda$57(XSppConnector xSppConnector, final EarphonesPluginImpl earphonesPluginImpl, final NtBleDevice ntBleDevice, XConnectType connectType, XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(connectType, "connectType");
        if (!xSppConnector.hasConnectCallback("flutter")) {
            earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda39
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EarphonesPluginImpl.connectCallback$lambda$62$lambda$57$lambda$56(this.f$0, ntBleDevice);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectCallback$lambda$62$lambda$57$lambda$56(EarphonesPluginImpl earphonesPluginImpl, NtBleDevice ntBleDevice) {
        NtBleFlutterApi ntBleFlutterApi = earphonesPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.SPP, ntBleDevice, NtBleConnectState.CONNECTED, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.connectCallback$lambda$62$lambda$57$lambda$56$lambda$55((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectCallback$lambda$62$lambda$57$lambda$56$lambda$55(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit connectCallback$lambda$62$lambda$59(XBluetoothDevice xBluetoothDevice, XConnectFailType connectFailType) {
        Intrinsics.checkNotNullParameter(connectFailType, "connectFailType");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "spp -> onConnectFail " + connectFailType;
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
    public static final Unit connectCallback$lambda$62$lambda$61(boolean z, XBluetoothDevice xBluetoothDevice, BluetoothGatt bluetoothGatt, int i) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "spp -> onDisConnected".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "spp -> onDisConnected " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "spp -> onDisConnected " + strComponent2);
            }
        }
        return Unit.INSTANCE;
    }

    public final Function1<XBluetoothFlowCallBack, Unit> bluetoothFlowCallBack(final NtBleDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda45
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75(this.f$0, device, (XBluetoothFlowCallBack) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75(final EarphonesPluginImpl earphonesPluginImpl, final NtBleDevice ntBleDevice, XBluetoothFlowCallBack xBluetoothFlowCallBack) {
        Intrinsics.checkNotNullParameter(xBluetoothFlowCallBack, "<this>");
        xBluetoothFlowCallBack.onRequestPermission(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda11
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$66(this.f$0, ntBleDevice, (Function1) obj);
            }
        });
        xBluetoothFlowCallBack.onRequestBluetooth(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda22
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$70(this.f$0, ntBleDevice, (Function1) obj);
            }
        });
        xBluetoothFlowCallBack.onRequestGps(new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda33
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$74(this.f$0, ntBleDevice, (Function1) obj);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$66(final EarphonesPluginImpl earphonesPluginImpl, final NtBleDevice ntBleDevice, Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "spp -> onRequestPermission".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "spp -> onRequestPermission " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "spp -> onRequestPermission " + strComponent2);
            }
        }
        callback.invoke(false);
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$66$lambda$65(this.f$0, ntBleDevice);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$66$lambda$65(EarphonesPluginImpl earphonesPluginImpl, NtBleDevice ntBleDevice) {
        NtBleFlutterApi ntBleFlutterApi = earphonesPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.SPP, ntBleDevice, NtBleConnectState.DISCONNECTED, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$66$lambda$65$lambda$64((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$66$lambda$65$lambda$64(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$70(final EarphonesPluginImpl earphonesPluginImpl, final NtBleDevice ntBleDevice, Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "spp -> onRequestBluetooth".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "spp -> onRequestBluetooth " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "spp -> onRequestBluetooth " + strComponent2);
            }
        }
        callback.invoke(false);
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda17
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$70$lambda$69(this.f$0, ntBleDevice);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$70$lambda$69(EarphonesPluginImpl earphonesPluginImpl, NtBleDevice ntBleDevice) {
        NtBleFlutterApi ntBleFlutterApi = earphonesPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.SPP, ntBleDevice, NtBleConnectState.DISCONNECTED, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$70$lambda$69$lambda$68((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$70$lambda$69$lambda$68(Result result) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$74(final EarphonesPluginImpl earphonesPluginImpl, final NtBleDevice ntBleDevice, Function1 callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "spp -> onRequestGps".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "spp -> onRequestGps " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "spp -> onRequestGps " + strComponent2);
            }
        }
        callback.invoke(false);
        earphonesPluginImpl.callInMainThread(new Function0() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda44
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$74$lambda$73(this.f$0, ntBleDevice);
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$74$lambda$73(EarphonesPluginImpl earphonesPluginImpl, NtBleDevice ntBleDevice) {
        NtBleFlutterApi ntBleFlutterApi = earphonesPluginImpl.flutterApi;
        if (ntBleFlutterApi != null) {
            ntBleFlutterApi.connectStateChanged(NtConnectType.SPP, ntBleDevice, NtBleConnectState.DISCONNECTED, new Function1() { // from class: com.nothing.nt_ble.plugin.EarphonesPluginImpl$$ExternalSyntheticLambda27
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return EarphonesPluginImpl.bluetoothFlowCallBack$lambda$75$lambda$74$lambda$73$lambda$72((Result) obj);
                }
            });
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bluetoothFlowCallBack$lambda$75$lambda$74$lambda$73$lambda$72(Result result) {
        return Unit.INSTANCE;
    }

    @Override // com.nothing.nt_ble.plugin.UnknownImpl, com.nothing.generate.NtBleNativeApi
    public void stopOta(NtBleDevice device, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(callback, "callback");
        NTPluginManager nTPluginManager = NTPluginManager.INSTANCE.get();
        Bundle bundle = new Bundle();
        String realMac = device.getRealMac();
        if (realMac == null) {
            realMac = "";
        }
        bundle.putString("address", realMac);
        Unit unit = Unit.INSTANCE;
        nTPluginManager.onCallHandler("invokeStopOta", bundle);
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
    public void turnOffSpp(String realMac, NtDeviceType type, NtSendKey sendKey, Function1<? super Result<Boolean>, Unit> callback) {
        Intrinsics.checkNotNullParameter(realMac, "realMac");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(sendKey, "sendKey");
        Intrinsics.checkNotNullParameter(callback, "callback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new EarphonesPluginImpl$turnOffSpp$1$1(this, realMac, callback, null), 3, null);
    }
}
