package com.nothing.link.bluetooth.sdk.device;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.google.android.exoplayer2.Renderer;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBluetoothHashMap.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0007J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0007J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\bJ\u000e\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u0003R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/device/XBluetoothHashMap;", "", "maxSize", "", "(I)V", "deviceMaps", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/nothing/link/bluetooth/sdk/device/XConnectorDevice;", "lruCache", "Lcom/nothing/link/bluetooth/sdk/device/LruCacheImpl;", "getDeviceMaps", "", "getOrPut", "device", "Landroid/bluetooth/BluetoothDevice;", "bleDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "address", "onDestroy", "", "removeConnectedDevice", "key", "toString", "updateConnectedDevice", "value", "updateMaxSize", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBluetoothHashMap {
    private final ConcurrentHashMap<String, XConnectorDevice> deviceMaps = new ConcurrentHashMap<>();
    private LruCacheImpl<String, String> lruCache;

    public XBluetoothHashMap(int i) {
        this.lruCache = new LruCacheImpl<>(i, new Function1<String, Unit>() { // from class: com.nothing.link.bluetooth.sdk.device.XBluetoothHashMap$lruCache$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.device.XBluetoothHashMap$lruCache$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: XBluetoothHashMap.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.device.XBluetoothHashMap$lruCache$1$2", f = "XBluetoothHashMap.kt", i = {}, l = {20}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ String $address;
                int label;
                final /* synthetic */ XBluetoothHashMap this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(XBluetoothHashMap xBluetoothHashMap, String str, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = xBluetoothHashMap;
                    this.$address = str;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$address, continuation);
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
                        XConnectorDevice xConnectorDevice = (XConnectorDevice) this.this$0.deviceMaps.get(this.$address);
                        if (xConnectorDevice != null) {
                            this.label = 1;
                            if (xConnectorDevice.disconnect(this) == coroutine_suspended) {
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

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String address) {
                Intrinsics.checkNotNullParameter(address, "address");
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "lru entry remove " + address + "!";
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
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass2(this.this$0, address, null), 3, null);
            }
        });
    }

    public final List<String> getDeviceMaps() {
        Enumeration<String> enumerationKeys = this.deviceMaps.keys();
        Intrinsics.checkNotNullExpressionValue(enumerationKeys, "keys(...)");
        ArrayList list = Collections.list(enumerationKeys);
        Intrinsics.checkNotNullExpressionValue(list, "list(...)");
        return list;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x003f  */
    /* JADX WARN: Code duplicated, block: B:18:0x0053  */
    public final XConnectorDevice getOrPut(String address) {
        String str;
        BluetoothDevice bluetoothDevice;
        Intrinsics.checkNotNullParameter(address, "address");
        ConcurrentHashMap<String, XConnectorDevice> concurrentHashMap = this.deviceMaps;
        XConnectorDevice xConnectorDevicePutIfAbsent = concurrentHashMap.get(address);
        if (xConnectorDevicePutIfAbsent == null) {
            BluetoothAdapter bluetoothAdapter = XBluetoothManager.INSTANCE.get().getBluetoothAdapter();
            BluetoothDevice remoteDevice = bluetoothAdapter != null ? bluetoothAdapter.getRemoteDevice(address) : null;
            if (BleUtil.INSTANCE.checkBluetoothPermissions()) {
                String name = remoteDevice != null ? remoteDevice.getName() : null;
                if (name == null) {
                    str = "";
                } else {
                    Intrinsics.checkNotNull(name);
                    str = name;
                }
            } else {
                str = "";
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "create address " + remoteDevice;
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    bluetoothDevice = remoteDevice;
                } else {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    bluetoothDevice = remoteDevice;
                    FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            } else {
                bluetoothDevice = remoteDevice;
            }
            XConnectorDevice xConnectorDevice = new XConnectorDevice(new XBluetoothDevice(bluetoothDevice, str, address, address, null, null, null, null, null, null, null));
            xConnectorDevicePutIfAbsent = concurrentHashMap.putIfAbsent(address, xConnectorDevice);
            if (xConnectorDevicePutIfAbsent == null) {
                xConnectorDevicePutIfAbsent = xConnectorDevice;
            }
        }
        Intrinsics.checkNotNullExpressionValue(xConnectorDevicePutIfAbsent, "getOrPut(...)");
        return xConnectorDevicePutIfAbsent;
    }

    public final XConnectorDevice getOrPut(BluetoothDevice device) {
        String name;
        Intrinsics.checkNotNullParameter(device, "device");
        String address = device.getAddress();
        ConcurrentHashMap<String, XConnectorDevice> concurrentHashMap = this.deviceMaps;
        XConnectorDevice xConnectorDevicePutIfAbsent = concurrentHashMap.get(address);
        if (xConnectorDevicePutIfAbsent == null) {
            String str = "";
            if (BleUtil.INSTANCE.checkBluetoothPermissions() && (name = device.getName()) != null) {
                Intrinsics.checkNotNull(name);
                str = name;
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str2 = "create BluetoothDevice " + device;
                String str3 = str2;
                if (str3 != null && str3.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog, 3, str4, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            XConnectorDevice xConnectorDevice = new XConnectorDevice(new XBluetoothDevice(device, str, address, address, null, null, null, null, null, null, null));
            xConnectorDevicePutIfAbsent = concurrentHashMap.putIfAbsent(address, xConnectorDevice);
            if (xConnectorDevicePutIfAbsent == null) {
                xConnectorDevicePutIfAbsent = xConnectorDevice;
            }
        }
        Intrinsics.checkNotNullExpressionValue(xConnectorDevicePutIfAbsent, "getOrPut(...)");
        return xConnectorDevicePutIfAbsent;
    }

    public final XConnectorDevice getOrPut(XBluetoothDevice bleDevice) {
        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
        ConcurrentHashMap<String, XConnectorDevice> concurrentHashMap = this.deviceMaps;
        String realAddress = bleDevice.getRealAddress();
        XConnectorDevice xConnectorDevice = concurrentHashMap.get(realAddress);
        if (xConnectorDevice == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "create XBluetoothDevice " + bleDevice;
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
            XConnectorDevice xConnectorDevice2 = new XConnectorDevice(bleDevice);
            XConnectorDevice xConnectorDevicePutIfAbsent = concurrentHashMap.putIfAbsent(realAddress, xConnectorDevice2);
            xConnectorDevice = xConnectorDevicePutIfAbsent == null ? xConnectorDevice2 : xConnectorDevicePutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(xConnectorDevice, "getOrPut(...)");
        return xConnectorDevice;
    }

    public final void updateMaxSize(int maxSize) {
        this.lruCache.resize(maxSize);
    }

    public final void updateConnectedDevice(String key, XConnectorDevice value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        LruCacheImpl<String, String> lruCacheImpl = this.lruCache;
        String realAddress = value.getXBluetoothDevice().getRealAddress();
        if (realAddress == null) {
            realAddress = "";
        }
        lruCacheImpl.put(key, realAddress);
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.device.XBluetoothHashMap$removeConnectedDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: XBluetoothHashMap.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.device.XBluetoothHashMap$removeConnectedDevice$1", f = "XBluetoothHashMap.kt", i = {}, l = {Renderer.MSG_SET_WAKEUP_LISTENER}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $key;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$key = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBluetoothHashMap.this.new AnonymousClass1(this.$key, continuation);
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
                XConnectorDevice xConnectorDevice = (XConnectorDevice) XBluetoothHashMap.this.deviceMaps.remove(this.$key);
                if (xConnectorDevice != null) {
                    this.label = 1;
                    if (xConnectorDevice.disconnect(this) == coroutine_suspended) {
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

    public final void removeConnectedDevice(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.lruCache.remove(key);
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(key, null), 3, null);
    }

    public final void onDestroy() {
        Iterator<Map.Entry<String, XConnectorDevice>> it = this.deviceMaps.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onDestroy();
        }
    }

    public String toString() {
        String str = this.lruCache.toString() + this.deviceMaps.toString();
        Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        return str;
    }
}
