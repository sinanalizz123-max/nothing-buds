package com.nothing.link.bluetooth.sdk.device;

import androidx.appcompat.app.AppCompatDelegate;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.link.bluetooth.sdk.connect.ble.XBleAudioConnector;
import com.nothing.link.bluetooth.sdk.connect.ble.XBleBTConnector;
import com.nothing.link.bluetooth.sdk.connect.ble.XBleConnector;
import com.nothing.link.bluetooth.sdk.connect.ble.XBleOTAConnector;
import com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector;
import com.nothing.link.bluetooth.sdk.connect.spp.XSppConnector;
import com.nothing.link.bluetooth.sdk.connect.spp.XSppOTAConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;

/* JADX INFO: compiled from: XConnectorDevice.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\bJ\u0018\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\fJ\u0011\u0010\u001e\u001a\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0006\u0010!\u001a\u00020\u000eJ\u0006\u0010\"\u001a\u00020\u001fJ\u001a\u0010#\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020&J\u001a\u0010'\u001a\u00020\u001f2\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020&J,\u0010(\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010)\u001a\u00020\u001fJ,\u0010*\u001a\u00020\u00142\b\b\u0002\u0010$\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010+\u001a\u00020\u0011H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00140\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/device/XConnectorDevice;", "", "xBluetoothDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "(Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;)V", "bleBTConnector", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleBTConnector;", "bleConnector", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleConnector;", "bleOTAConnector", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleOTAConnector;", "btConnector", "Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTConnector;", "leAudioConnector", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XBleAudioConnector;", "sppConnectorMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/link/bluetooth/sdk/connect/spp/XSppConnector;", "sppOTAConnectorMap", "Lcom/nothing/link/bluetooth/sdk/connect/spp/XSppOTAConnector;", "getXBluetoothDevice", "()Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "ble", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", ViewKey.TAG, "bleBT", "bleOTA", "bt", DeviceEarImage.DISCONNECT_EAR_IMAGE, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "leAudio", "onDestroy", "removeSppDevice", "connectUUID", "channel", "", "removeSppOTADevice", "spp", "sppCloseSocket", "sppOTA", "toString", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XConnectorDevice {
    private XBleBTConnector bleBTConnector;
    private XBleConnector bleConnector;
    private XBleOTAConnector bleOTAConnector;
    private XBTConnector btConnector;
    private XBleAudioConnector leAudioConnector;
    private final ConcurrentHashMap<String, XSppConnector> sppConnectorMap;
    private final ConcurrentHashMap<String, XSppOTAConnector> sppOTAConnectorMap;
    private final XBluetoothDevice xBluetoothDevice;

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.device.XConnectorDevice$disconnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: XConnectorDevice.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.device.XConnectorDevice", f = "XConnectorDevice.kt", i = {0, 1, 1, 2, 2, 3, 4}, l = {99, 101, 105, AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY, 111}, m = DeviceEarImage.DISCONNECT_EAR_IMAGE, n = {"this", "this", "it", "this", "it", "this", "this"}, s = {"L$0", "L$0", "L$2", "L$0", "L$2", "L$0", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XConnectorDevice.this.disconnect(this);
        }
    }

    public XConnectorDevice(XBluetoothDevice xBluetoothDevice) {
        Intrinsics.checkNotNullParameter(xBluetoothDevice, "xBluetoothDevice");
        this.xBluetoothDevice = xBluetoothDevice;
        this.sppConnectorMap = new ConcurrentHashMap<>();
        this.sppOTAConnectorMap = new ConcurrentHashMap<>();
    }

    public final XBluetoothDevice getXBluetoothDevice() {
        return this.xBluetoothDevice;
    }

    public static /* synthetic */ XBleConnector ble$default(XConnectorDevice xConnectorDevice, XByteArrayParser xByteArrayParser, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            xByteArrayParser = new XDefaultParser();
        }
        if ((i & 2) != 0) {
            str = "BleWriter";
        }
        return xConnectorDevice.ble(xByteArrayParser, str);
    }

    public final synchronized XBleConnector ble(XByteArrayParser parser, String tag) {
        XBleConnector xBleConnector;
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(tag, "tag");
        xBleConnector = this.bleConnector;
        if (xBleConnector == null) {
            xBleConnector = new XBleConnector(parser, tag);
            xBleConnector.onCreate(this.xBluetoothDevice);
            this.bleConnector = xBleConnector;
        }
        return xBleConnector;
    }

    public final synchronized XBleConnector bleBT() {
        XBleBTConnector xBleBTConnector;
        xBleBTConnector = this.bleBTConnector;
        if (xBleBTConnector == null) {
            xBleBTConnector = new XBleBTConnector();
            xBleBTConnector.onCreate(this.xBluetoothDevice);
            this.bleBTConnector = xBleBTConnector;
        }
        return xBleBTConnector;
    }

    public final synchronized XBTConnector bt() {
        XBTConnector xBTConnector;
        xBTConnector = this.btConnector;
        if (xBTConnector == null) {
            xBTConnector = new XBTConnector();
            xBTConnector.onCreate(this.xBluetoothDevice);
            this.btConnector = xBTConnector;
        }
        return xBTConnector;
    }

    public static /* synthetic */ XSppConnector spp$default(XConnectorDevice xConnectorDevice, String str, String str2, int i, XByteArrayParser xByteArrayParser, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "AEAC4A03-DFF5-498F-843A-34487CF133EB";
        }
        if ((i2 & 2) != 0) {
            str2 = "SppWriter";
        }
        if ((i2 & 4) != 0) {
            i = 15;
        }
        return xConnectorDevice.spp(str, str2, i, xByteArrayParser);
    }

    public final synchronized XSppConnector spp(String connectUUID, String tag, int channel, XByteArrayParser parser) {
        XSppConnector xSppConnector;
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(parser, "parser");
        String str = connectUUID + channel;
        ConcurrentHashMap<String, XSppConnector> concurrentHashMap = this.sppConnectorMap;
        xSppConnector = concurrentHashMap.get(str);
        if (xSppConnector == null) {
            xSppConnector = new XSppConnector(connectUUID, tag, channel, parser);
            xSppConnector.onCreate(this.xBluetoothDevice);
            XSppConnector xSppConnectorPutIfAbsent = concurrentHashMap.putIfAbsent(str, xSppConnector);
            if (xSppConnectorPutIfAbsent != null) {
                xSppConnector = xSppConnectorPutIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(xSppConnector, "getOrPut(...)");
        return xSppConnector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized XBleAudioConnector leAudio() {
        XBleAudioConnector xBleAudioConnector;
        xBleAudioConnector = this.leAudioConnector;
        if (xBleAudioConnector == null) {
            xBleAudioConnector = new XBleAudioConnector(null, 1, 0 == true ? 1 : 0);
            xBleAudioConnector.onCreate(this.xBluetoothDevice);
            this.leAudioConnector = xBleAudioConnector;
        }
        return xBleAudioConnector;
    }

    public static /* synthetic */ XSppOTAConnector sppOTA$default(XConnectorDevice xConnectorDevice, String str, String str2, int i, XByteArrayParser xByteArrayParser, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "66666666-6666-6666-6666-666666666666";
        }
        if ((i2 & 2) != 0) {
            str2 = "SppOTAWriter";
        }
        if ((i2 & 4) != 0) {
            i = 13;
        }
        return xConnectorDevice.sppOTA(str, str2, i, xByteArrayParser);
    }

    public final synchronized XSppOTAConnector sppOTA(String connectUUID, String tag, int channel, XByteArrayParser parser) {
        XSppOTAConnector xSppOTAConnector;
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(parser, "parser");
        String str = connectUUID + channel;
        ConcurrentHashMap<String, XSppOTAConnector> concurrentHashMap = this.sppOTAConnectorMap;
        xSppOTAConnector = concurrentHashMap.get(str);
        if (xSppOTAConnector == null) {
            xSppOTAConnector = new XSppOTAConnector(connectUUID, tag, channel, parser);
            xSppOTAConnector.onCreate(this.xBluetoothDevice);
            XSppOTAConnector xSppOTAConnectorPutIfAbsent = concurrentHashMap.putIfAbsent(str, xSppOTAConnector);
            if (xSppOTAConnectorPutIfAbsent != null) {
                xSppOTAConnector = xSppOTAConnectorPutIfAbsent;
            }
        }
        Intrinsics.checkNotNullExpressionValue(xSppOTAConnector, "getOrPut(...)");
        return xSppOTAConnector;
    }

    public static /* synthetic */ XBleOTAConnector bleOTA$default(XConnectorDevice xConnectorDevice, XByteArrayParser xByteArrayParser, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "BleOTAWriter";
        }
        return xConnectorDevice.bleOTA(xByteArrayParser, str);
    }

    public final synchronized XBleOTAConnector bleOTA(XByteArrayParser parser, String tag) {
        XBleOTAConnector xBleOTAConnector;
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(tag, "tag");
        xBleOTAConnector = this.bleOTAConnector;
        if (xBleOTAConnector == null) {
            xBleOTAConnector = new XBleOTAConnector(parser, tag);
            xBleOTAConnector.onCreate(this.xBluetoothDevice);
            this.bleOTAConnector = xBleOTAConnector;
        }
        return xBleOTAConnector;
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:43:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00bb -> B:36:0x00bf). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00f8 -> B:44:0x00fa). Please report as a decompilation issue!!! */
    /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
        java.lang.StackOverflowError
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
        	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
        */
    public final java.lang.Object disconnect(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.link.bluetooth.sdk.device.XConnectorDevice.disconnect(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void sppCloseSocket() {
        Iterator<Map.Entry<String, XSppConnector>> it = this.sppConnectorMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().closeLast();
        }
        Iterator<Map.Entry<String, XSppOTAConnector>> it2 = this.sppOTAConnectorMap.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().closeLast();
        }
    }

    public final void onDestroy() {
        XBleOTAConnector xBleOTAConnector = this.bleOTAConnector;
        if (xBleOTAConnector != null) {
            xBleOTAConnector.onDestroy();
        }
        XBleConnector xBleConnector = this.bleConnector;
        if (xBleConnector != null) {
            xBleConnector.onDestroy();
        }
        Iterator<Map.Entry<String, XSppOTAConnector>> it = this.sppOTAConnectorMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onDestroy();
        }
        Iterator<Map.Entry<String, XSppConnector>> it2 = this.sppConnectorMap.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().onDestroy();
        }
        XBleAudioConnector xBleAudioConnector = this.leAudioConnector;
        if (xBleAudioConnector != null) {
            xBleAudioConnector.onDestroy();
        }
    }

    public static /* synthetic */ void removeSppDevice$default(XConnectorDevice xConnectorDevice, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "AEAC4A03-DFF5-498F-843A-34487CF133EB";
        }
        if ((i2 & 2) != 0) {
            i = 15;
        }
        xConnectorDevice.removeSppDevice(str, i);
    }

    public final void removeSppDevice(String connectUUID, int channel) {
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        this.sppConnectorMap.remove(connectUUID + channel);
    }

    public static /* synthetic */ void removeSppOTADevice$default(XConnectorDevice xConnectorDevice, String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "AEAC4A03-DFF5-498F-843A-34487CF133EB";
        }
        if ((i2 & 2) != 0) {
            i = 15;
        }
        xConnectorDevice.removeSppOTADevice(str, i);
    }

    public final void removeSppOTADevice(String connectUUID, int channel) {
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        this.sppOTAConnectorMap.remove(connectUUID + channel);
    }

    public String toString() {
        return this.xBluetoothDevice.toString();
    }
}
