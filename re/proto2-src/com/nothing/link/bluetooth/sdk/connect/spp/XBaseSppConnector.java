package com.nothing.link.bluetooth.sdk.connect.spp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.ActiveDisConnectedException;
import com.nothing.link.bluetooth.sdk.connect.CompleteException;
import com.nothing.link.bluetooth.sdk.connect.UnConnectedException;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectLastState;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.task.XTask;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import io.mimi.sdk.core.api.VersionInterceptorKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.metadata.TikaCoreProperties;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBaseSppConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00a6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0007J\b\u0010\u001c\u001a\u00020\u0016H\u0016J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u000bH\u0002J\u001b\u0010\u001f\u001a\u00020\u00162\b\u0010 \u001a\u0004\u0018\u00010!H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\u001aH\u0002J\n\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010&\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\u001a\u0010'\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\b\u0010(\u001a\u00020\u0016H\u0016J\u0019\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J\u001a\u0010,\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010-\u001a\u00020\u001aH\u0016J\"\u0010.\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001aH\u0016J\"\u00101\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u001aH\u0016J\u0006\u00102\u001a\u00020\u0016J6\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u00032\u0006\u00106\u001a\u0002072\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u000109j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`:H&J\u0018\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u000207H&J\u000e\u0010>\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010?\u001a\u00020\u00162\u0006\u0010@\u001a\u000204J\u0095\u0001\u0010A\u001a\u0004\u0018\u0001072\u0006\u00106\u001a\u0002072\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u0001072\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010\u00032\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u000109j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`:H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010NJ\u00a3\u0001\u0010A\u001a\u00020\u00162\u0006\u00106\u001a\u0002072\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\u001a2\u0006\u0010F\u001a\u00020\u001a2\u0006\u0010G\u001a\u00020\u001a2\u0006\u0010H\u001a\u00020\u00032\u0006\u0010I\u001a\u00020\u00032\b\u0010J\u001a\u0004\u0018\u0001072\b\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010M\u001a\u00020\u001a2\b\u00105\u001a\u0004\u0018\u00010\u00032\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u000109j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`:2\u0017\u0010O\u001a\u0013\u0012\u0004\u0012\u00020Q\u0012\u0004\u0012\u00020\u00160P\u00a2\u0006\u0002\bRH\u0016JG\u0010S\u001a#\b\u0001\u0012\u0004\u0012\u00020U\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0V\u0012\u0006\u0012\u0004\u0018\u00010W0T\u00a2\u0006\u0002\bR*\u00020\u00002\u0006\u0010@\u001a\u0002042\b\u0010J\u001a\u0004\u0018\u000107H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010XR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Y"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/spp/XBaseSppConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "connectUUID", "", ViewKey.TAG, "channel", "", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "(Ljava/lang/String;Ljava/lang/String;ILcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;)V", "bluetoothSocket", "Landroid/bluetooth/BluetoothSocket;", "getChannel", "()I", "getConnectUUID", "()Ljava/lang/String;", "isSppConnecting", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "receiverJob", "Lkotlinx/coroutines/Job;", "actionEncryptionChange", "", "device", "Landroid/bluetooth/BluetoothDevice;", "isSecure", "", "cancelDiscovery", "closeLast", "closeSocket", "socket", "connectInternal", "bleDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "(Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectSocket", "createRelationConnector", "Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTConnector;", "createRfcommSocket", "createRfcommSocketToServiceRecord", "disConnectInternal", "isConnected", "isSystem", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "keyMissingChanged", "connected", "onA2DPChange", "a2dpConnect", "headsetConnect", "onHeadSetChange", "onSppDisconnected", "parserWriterCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "taskId", "dataArray", "", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "receiveByteArray", "readLength", "byteArray", "tryConnectSpp", "write", "command", "writeWithTask", "operateInterval", "", "durationTimeMillis", "needUpdate", "ignoreFrame", "autoDoNextTask", "serviceUUID", "writeUUID", "mockResponse", "retryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "successWithComplete", "([BJJZZZLjava/lang/String;Ljava/lang/String;[BLjava/util/concurrent/atomic/AtomicInteger;ZLjava/lang/String;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeCallback", "Lkotlin/Function1;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;", "Lkotlin/ExtensionFunctionType;", "getTaskBlock", "Lkotlin/Function2;", "Lcom/nothing/link/bluetooth/sdk/task/XTask;", "Lkotlin/coroutines/Continuation;", "", "(Lcom/nothing/link/bluetooth/sdk/connect/spp/XBaseSppConnector;Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;[B)Lkotlin/jvm/functions/Function2;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XBaseSppConnector extends XConnector {
    private BluetoothSocket bluetoothSocket;
    private final int channel;
    private final String connectUUID;
    private final AtomicBoolean isSppConnecting;
    private Job receiverJob;

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$connectInternal$1, reason: invalid class name */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector", f = "XBaseSppConnector.kt", i = {0, 2, 2}, l = {81, 86, 92, 105, ModuleDescriptor.MODULE_VERSION}, m = "connectInternal$suspendImpl", n = {"$this", "$this", "connectResult"}, s = {"L$0", "L$0", "L$1"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBaseSppConnector.connectInternal$suspendImpl(XBaseSppConnector.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$writeWithTask$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector", f = "XBaseSppConnector.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {VersionInterceptorKt.SDK_EXPIRED_CODE, 413}, m = "writeWithTask$suspendImpl", n = {"$this", "dataArray", "mockResponse", "retryCount", "taskId", "resIds", "operateInterval", "durationTimeMillis", "needUpdate", "ignoreFrame", "autoDoNextTask", "successWithComplete", "$this", "dataArray", "mockResponse", "retryCount", "taskId", "resIds", "operateInterval", "durationTimeMillis", "needUpdate", "ignoreFrame", "autoDoNextTask", "successWithComplete"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "Z$0", "Z$1", "Z$2", "Z$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "Z$0", "Z$1", "Z$2", "Z$3"})
    static final class C09051 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        boolean Z$3;
        int label;
        /* synthetic */ Object result;

        C09051(Continuation<? super C09051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBaseSppConnector.writeWithTask$suspendImpl(XBaseSppConnector.this, (byte[]) null, 0L, 0L, false, false, false, (String) null, (String) null, (byte[]) null, (AtomicInteger) null, false, (String) null, (ArrayList<String>) null, (Continuation<? super byte[]>) this);
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void actionEncryptionChange(BluetoothDevice device, boolean isSecure) {
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public Object connectInternal(XBluetoothDevice xBluetoothDevice, Continuation<? super Unit> continuation) {
        return connectInternal$suspendImpl(this, xBluetoothDevice, continuation);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public Object isConnected(boolean z, Continuation<? super Boolean> continuation) {
        return isConnected$suspendImpl(this, z, continuation);
    }

    public abstract XCommand parserWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds);

    public abstract void receiveByteArray(int readLength, byte[] byteArray);

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public Object writeWithTask(byte[] bArr, long j, long j2, boolean z, boolean z2, boolean z3, String str, String str2, byte[] bArr2, AtomicInteger atomicInteger, boolean z4, String str3, ArrayList<String> arrayList, Continuation<? super byte[]> continuation) {
        return writeWithTask$suspendImpl(this, bArr, j, j2, z, z2, z3, str, str2, bArr2, atomicInteger, z4, str3, arrayList, continuation);
    }

    public final String getConnectUUID() {
        return this.connectUUID;
    }

    public final int getChannel() {
        return this.channel;
    }

    public /* synthetic */ XBaseSppConnector(String str, String str2, int i, XDefaultParser xDefaultParser, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 15 : i, (i2 & 8) != 0 ? new XDefaultParser() : xDefaultParser);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XBaseSppConnector(String connectUUID, String tag, int i, XByteArrayParser parser) {
        super(parser, tag);
        Intrinsics.checkNotNullParameter(connectUUID, "connectUUID");
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(parser, "parser");
        this.connectUUID = connectUUID;
        this.channel = i;
        this.isSppConnecting = new AtomicBoolean(false);
    }

    /* JADX INFO: renamed from: isSppConnecting, reason: from getter */
    public final AtomicBoolean getIsSppConnecting() {
        return this.isSppConnecting;
    }

    static /* synthetic */ Object isConnected$suspendImpl(XBaseSppConnector xBaseSppConnector, boolean z, Continuation<? super Boolean> continuation) {
        BluetoothSocket bluetoothSocket = xBaseSppConnector.bluetoothSocket;
        boolean z2 = false;
        if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
            z2 = true;
        }
        return Boxing.boxBoolean(z2);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public XBTConnector createRelationConnector() {
        return new XBTConnector();
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void disConnectInternal() {
        XConnectCallback mXConnectCallback = getMXConnectCallback();
        if (mXConnectCallback != null) {
            mXConnectCallback.callDisConnected(getIsActiveDisconnect().get(), getMBleDevice(), null, getConnectorType().getType());
        }
        closeLast();
        Job job = this.receiverJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0223  */
    /* JADX WARN: Code duplicated, block: B:102:0x0229  */
    /* JADX WARN: Code duplicated, block: B:103:0x0230  */
    /* JADX WARN: Code duplicated, block: B:105:0x0233  */
    /* JADX WARN: Code duplicated, block: B:106:0x023a  */
    /* JADX WARN: Code duplicated, block: B:109:0x0269  */
    /* JADX WARN: Code duplicated, block: B:114:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:120:0x02fa  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b0 A[PHI: r0
      0x00b0: PHI (r0v4 com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector) = 
      (r0v0 com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector)
      (r0v10 com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector)
     binds: [B:35:0x0094, B:40:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:49:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00db  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:60:0x014a  */
    /* JADX WARN: Code duplicated, block: B:66:0x0186  */
    /* JADX WARN: Code duplicated, block: B:68:0x018c  */
    /* JADX WARN: Code duplicated, block: B:70:0x0198  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:78:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Code duplicated, block: B:81:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:85:0x01db  */
    /* JADX WARN: Code duplicated, block: B:86:0x01e0 A[DONT_INVERT, PHI: r0 r1 r11
      0x01e0: PHI (r0v15 com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector) = 
      (r0v6 com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector)
      (r0v19 com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector)
      (r0v20 com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector)
     binds: [B:77:0x01b5, B:85:0x01db, B:84:0x01d6] A[DONT_GENERATE, DONT_INLINE]
      0x01e0: PHI (r1v38 kotlin.Pair<java.lang.Boolean, java.lang.Integer>) = 
      (r1v22 kotlin.Pair<java.lang.Boolean, java.lang.Integer>)
      (r1v51 kotlin.Pair<java.lang.Boolean, java.lang.Integer>)
      (r1v52 kotlin.Pair<java.lang.Boolean, java.lang.Integer>)
     binds: [B:77:0x01b5, B:85:0x01db, B:84:0x01d6] A[DONT_GENERATE, DONT_INLINE]
      0x01e0: PHI (r11v1 boolean) = (r11v0 boolean), (r11v0 boolean), (r11v4 boolean) binds: [B:77:0x01b5, B:85:0x01db, B:84:0x01d6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:89:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:91:0x01f0 A[ADDED_TO_REGION] */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x02f3, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r0, r3) == r4) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x03c9, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r0, r3) == r4) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a2, code lost:
    
        if (r2 == r4) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x017f, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r0, r3) == r4) goto L139;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object connectInternal$suspendImpl(XBaseSppConnector xBaseSppConnector, XBluetoothDevice xBluetoothDevice, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        boolean z;
        XBTConnector mRelationConnector;
        Pair<Boolean, Integer> pairConnectInternal;
        XBTConnector mRelationConnector2;
        XBaseSppConnector xBaseSppConnector2;
        Pair<Boolean, Integer> pair;
        Logger logger;
        String tag;
        int depth;
        XBluetoothDevice mBleDevice;
        String realAddress;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        Logger logger2;
        String tag2;
        int depth2;
        Boolean first;
        Integer second;
        String str3;
        String str4;
        String strComponent3;
        String strComponent4;
        XConnectCallback mXConnectCallback;
        XBaseSppConnector xBaseSppConnector3 = xBaseSppConnector;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = xBaseSppConnector3.new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = xBaseSppConnector3.new AnonymousClass1(continuation);
        }
        Object objIsConnected = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        boolean z2 = false;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsConnected);
            if (xBluetoothDevice == null) {
                return Unit.INSTANCE;
            }
            if (xBaseSppConnector3.hasRelationConnector()) {
                XBTConnector mRelationConnector3 = xBaseSppConnector3.getMRelationConnector();
                if (mRelationConnector3 != null) {
                    mRelationConnector3.initParams(xBluetoothDevice);
                }
                XBTConnector mRelationConnector4 = xBaseSppConnector3.getMRelationConnector();
                if (mRelationConnector4 != null) {
                    mRelationConnector4.initProfileType(xBaseSppConnector3.getProfileType());
                }
                XBTConnector mRelationConnector5 = xBaseSppConnector3.getMRelationConnector();
                if (mRelationConnector5 != null) {
                    int profileType = xBaseSppConnector3.getProfileType();
                    anonymousClass1.L$0 = xBaseSppConnector3;
                    anonymousClass1.label = 1;
                    objIsConnected = mRelationConnector5.isConnected(profileType, anonymousClass1);
                } else {
                    z = false;
                    if (z) {
                        XConnector.updateLastState$default(xBaseSppConnector3, 1, null, 2, null);
                        if (xBaseSppConnector3.tryConnectSpp("connectInternal")) {
                            logger = Logger.INSTANCE;
                            tag = logger.getTAG();
                            depth = logger.getDepth();
                            if (logger.isCanLogger(true)) {
                                mBleDevice = xBaseSppConnector3.getMBleDevice();
                                if (mBleDevice != null) {
                                    realAddress = mBleDevice.getRealAddress();
                                } else {
                                    realAddress = null;
                                }
                                str = realAddress + " Job delay";
                                str2 = str;
                                if (str2 != null) {
                                    Pair<String, String> trace = logger.getTrace(depth);
                                    strComponent1 = trace.component1();
                                    strComponent2 = trace.component2();
                                    FileLog fileLog = FileLog.INSTANCE;
                                    String str5 = logger.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                    FileLog.print$default(fileLog, 3, str5, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                    if (logger.isDebug()) {
                                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                    }
                                }
                            }
                            long mConnectMillisTimeOut = xBaseSppConnector3.getMConnectMillisTimeOut();
                            anonymousClass1.L$0 = null;
                            anonymousClass1.label = 2;
                        }
                        return Unit.INSTANCE;
                    }
                    if (xBaseSppConnector3.getIsForceConnect()) {
                        XConnector.updateLastState$default(xBaseSppConnector3, 1, null, 2, null);
                        mRelationConnector = xBaseSppConnector3.getMRelationConnector();
                        if (mRelationConnector != null) {
                            pairConnectInternal = mRelationConnector.connectInternal(xBaseSppConnector3.getProfileType());
                        } else {
                            pairConnectInternal = null;
                        }
                        if (pairConnectInternal != null) {
                        }
                        mRelationConnector2 = xBaseSppConnector3.getMRelationConnector();
                        if (mRelationConnector2 == null) {
                            if (!z2) {
                                if (xBaseSppConnector3.getProfileType() == 0) {
                                    mXConnectCallback.callConnectFail(xBaseSppConnector3.getMBleDevice(), XConnectFailType.connectPeerPaired.INSTANCE);
                                }
                                logger2 = Logger.INSTANCE;
                                tag2 = logger2.getTAG();
                                depth2 = logger2.getDepth();
                                if (logger2.isCanLogger(true)) {
                                    XConnectType connectorType = xBaseSppConnector3.getConnectorType();
                                    if (pairConnectInternal != null) {
                                        first = pairConnectInternal.getFirst();
                                    } else {
                                        first = null;
                                    }
                                    if (pairConnectInternal != null) {
                                        second = pairConnectInternal.getSecond();
                                    } else {
                                        second = null;
                                    }
                                    str3 = "wait " + connectorType + " broadcast callback,otherwise will timeout " + first + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + second + "!";
                                    str4 = str3;
                                    if (str4 != null) {
                                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                                        strComponent3 = trace2.component1();
                                        strComponent4 = trace2.component2();
                                        FileLog fileLog2 = FileLog.INSTANCE;
                                        String str6 = logger2.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                        FileLog.print$default(fileLog2, 3, str6, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                        if (logger2.isDebug()) {
                                            Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                        }
                                    }
                                }
                                long mConnectMillisTimeOut2 = xBaseSppConnector3.getMConnectMillisTimeOut();
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.label = 4;
                            }
                            XConnector.updateLastState$default(xBaseSppConnector3, 2, null, 2, null);
                            return Unit.INSTANCE;
                        }
                        int profileType2 = xBaseSppConnector3.getProfileType();
                        anonymousClass1.L$0 = xBaseSppConnector3;
                        anonymousClass1.L$1 = pairConnectInternal;
                        anonymousClass1.label = 3;
                        objIsConnected = mRelationConnector2.isConnected(profileType2, anonymousClass1);
                        if (objIsConnected != coroutine_suspended) {
                            Pair<Boolean, Integer> pair2 = pairConnectInternal;
                            xBaseSppConnector2 = xBaseSppConnector3;
                            pair = pair2;
                            if (((Boolean) objIsConnected).booleanValue()) {
                                XBaseSppConnector xBaseSppConnector4 = xBaseSppConnector2;
                                pairConnectInternal = pair;
                                xBaseSppConnector3 = xBaseSppConnector4;
                                z2 = true;
                            } else {
                                XBaseSppConnector xBaseSppConnector5 = xBaseSppConnector2;
                                pairConnectInternal = pair;
                                xBaseSppConnector3 = xBaseSppConnector5;
                            }
                            if (!z2) {
                                if (xBaseSppConnector3.getProfileType() == 0) {
                                    mXConnectCallback.callConnectFail(xBaseSppConnector3.getMBleDevice(), XConnectFailType.connectPeerPaired.INSTANCE);
                                }
                                logger2 = Logger.INSTANCE;
                                tag2 = logger2.getTAG();
                                depth2 = logger2.getDepth();
                                if (logger2.isCanLogger(true)) {
                                    XConnectType connectorType2 = xBaseSppConnector3.getConnectorType();
                                    if (pairConnectInternal != null) {
                                        first = pairConnectInternal.getFirst();
                                    } else {
                                        first = null;
                                    }
                                    if (pairConnectInternal != null) {
                                        second = pairConnectInternal.getSecond();
                                    } else {
                                        second = null;
                                    }
                                    str3 = "wait " + connectorType2 + " broadcast callback,otherwise will timeout " + first + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + second + "!";
                                    str4 = str3;
                                    if (str4 != null) {
                                        Pair<String, String> trace3 = logger2.getTrace(depth2);
                                        strComponent3 = trace3.component1();
                                        strComponent4 = trace3.component2();
                                        FileLog fileLog3 = FileLog.INSTANCE;
                                        String str7 = logger2.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                        FileLog.print$default(fileLog3, 3, str7, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                        if (logger2.isDebug()) {
                                            Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                        }
                                    }
                                }
                                long mConnectMillisTimeOut3 = xBaseSppConnector3.getMConnectMillisTimeOut();
                                anonymousClass1.L$0 = null;
                                anonymousClass1.L$1 = null;
                                anonymousClass1.label = 4;
                            }
                            XConnector.updateLastState$default(xBaseSppConnector3, 2, null, 2, null);
                            return Unit.INSTANCE;
                        }
                    } else {
                        xBaseSppConnector3.cancelJobWhenConnectedFailed("isForceConnect is false, Only classic bluetooth connections trigger connections");
                        return Unit.INSTANCE;
                    }
                }
            } else {
                XConnector.updateLastState$default(xBaseSppConnector3, 1, null, 2, null);
                if (xBaseSppConnector3.tryConnectSpp("no relationConnector,direct connect!")) {
                    Logger logger3 = Logger.INSTANCE;
                    String tag3 = logger3.getTAG();
                    int depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true)) {
                        XBluetoothDevice mBleDevice2 = xBaseSppConnector3.getMBleDevice();
                        String str8 = (mBleDevice2 != null ? mBleDevice2.getRealAddress() : null) + " Job delay";
                        String str9 = str8;
                        if (str9 != null && str9.length() != 0) {
                            Pair<String, String> trace4 = logger3.getTrace(depth3);
                            String strComponent5 = trace4.component1();
                            String strComponent6 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str10 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                            FileLog.print$default(fileLog4, 3, str10, tag3, str8 + StringUtils.SPACE + strComponent6, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.i(tag3 + strComponent5, str8 + StringUtils.SPACE + strComponent6);
                            }
                        }
                    }
                    long mConnectMillisTimeOut4 = xBaseSppConnector3.getMConnectMillisTimeOut();
                    anonymousClass1.label = 5;
                }
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    pair = (Pair) anonymousClass1.L$1;
                    xBaseSppConnector2 = (XBaseSppConnector) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(objIsConnected);
                    if (((Boolean) objIsConnected).booleanValue()) {
                        XBaseSppConnector xBaseSppConnector6 = xBaseSppConnector2;
                        pairConnectInternal = pair;
                        xBaseSppConnector3 = xBaseSppConnector6;
                        z2 = true;
                    } else {
                        XBaseSppConnector xBaseSppConnector7 = xBaseSppConnector2;
                        pairConnectInternal = pair;
                        xBaseSppConnector3 = xBaseSppConnector7;
                    }
                    if (!z2) {
                        if (xBaseSppConnector3.getProfileType() == 0 && pairConnectInternal != null && pairConnectInternal.getSecond().intValue() == 2 && (mXConnectCallback = xBaseSppConnector3.getMXConnectCallback()) != null) {
                            mXConnectCallback.callConnectFail(xBaseSppConnector3.getMBleDevice(), XConnectFailType.connectPeerPaired.INSTANCE);
                        }
                        logger2 = Logger.INSTANCE;
                        tag2 = logger2.getTAG();
                        depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true)) {
                            XConnectType connectorType3 = xBaseSppConnector3.getConnectorType();
                            if (pairConnectInternal != null) {
                                first = pairConnectInternal.getFirst();
                            } else {
                                first = null;
                            }
                            if (pairConnectInternal != null) {
                                second = pairConnectInternal.getSecond();
                            } else {
                                second = null;
                            }
                            str3 = "wait " + connectorType3 + " broadcast callback,otherwise will timeout " + first + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + second + "!";
                            str4 = str3;
                            if (str4 != null && str4.length() != 0) {
                                Pair<String, String> trace5 = logger2.getTrace(depth2);
                                strComponent3 = trace5.component1();
                                strComponent4 = trace5.component2();
                                FileLog fileLog5 = FileLog.INSTANCE;
                                String str11 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                                FileLog.print$default(fileLog5, 3, str11, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                }
                            }
                        }
                        long mConnectMillisTimeOut5 = xBaseSppConnector3.getMConnectMillisTimeOut();
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.label = 4;
                    }
                    XConnector.updateLastState$default(xBaseSppConnector3, 2, null, 2, null);
                    return Unit.INSTANCE;
                }
                if (i != 4) {
                    if (i != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(objIsConnected);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(objIsConnected);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objIsConnected);
            return Unit.INSTANCE;
        }
        xBaseSppConnector3 = (XBaseSppConnector) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objIsConnected);
        if (((Boolean) objIsConnected).booleanValue()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            XConnector.updateLastState$default(xBaseSppConnector3, 1, null, 2, null);
            if (xBaseSppConnector3.tryConnectSpp("connectInternal")) {
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    mBleDevice = xBaseSppConnector3.getMBleDevice();
                    if (mBleDevice != null) {
                        realAddress = mBleDevice.getRealAddress();
                    } else {
                        realAddress = null;
                    }
                    str = realAddress + " Job delay";
                    str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace6 = logger.getTrace(depth);
                        strComponent1 = trace6.component1();
                        strComponent2 = trace6.component2();
                        FileLog fileLog6 = FileLog.INSTANCE;
                        String str12 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                        FileLog.print$default(fileLog6, 3, str12, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                long mConnectMillisTimeOut6 = xBaseSppConnector3.getMConnectMillisTimeOut();
                anonymousClass1.L$0 = null;
                anonymousClass1.label = 2;
            }
            return Unit.INSTANCE;
        }
        if (xBaseSppConnector3.getIsForceConnect()) {
            XConnector.updateLastState$default(xBaseSppConnector3, 1, null, 2, null);
            mRelationConnector = xBaseSppConnector3.getMRelationConnector();
            if (mRelationConnector != null) {
                pairConnectInternal = mRelationConnector.connectInternal(xBaseSppConnector3.getProfileType());
            } else {
                pairConnectInternal = null;
            }
            if (pairConnectInternal != null || !pairConnectInternal.getFirst().booleanValue()) {
                mRelationConnector2 = xBaseSppConnector3.getMRelationConnector();
                if (mRelationConnector2 == null) {
                    int profileType3 = xBaseSppConnector3.getProfileType();
                    anonymousClass1.L$0 = xBaseSppConnector3;
                    anonymousClass1.L$1 = pairConnectInternal;
                    anonymousClass1.label = 3;
                    objIsConnected = mRelationConnector2.isConnected(profileType3, anonymousClass1);
                    if (objIsConnected != coroutine_suspended) {
                        Pair<Boolean, Integer> pair3 = pairConnectInternal;
                        xBaseSppConnector2 = xBaseSppConnector3;
                        pair = pair3;
                        if (((Boolean) objIsConnected).booleanValue()) {
                            XBaseSppConnector xBaseSppConnector8 = xBaseSppConnector2;
                            pairConnectInternal = pair;
                            xBaseSppConnector3 = xBaseSppConnector8;
                            z2 = true;
                        } else {
                            XBaseSppConnector xBaseSppConnector9 = xBaseSppConnector2;
                            pairConnectInternal = pair;
                            xBaseSppConnector3 = xBaseSppConnector9;
                        }
                        if (!z2) {
                            if (xBaseSppConnector3.getProfileType() == 0) {
                                mXConnectCallback.callConnectFail(xBaseSppConnector3.getMBleDevice(), XConnectFailType.connectPeerPaired.INSTANCE);
                            }
                            logger2 = Logger.INSTANCE;
                            tag2 = logger2.getTAG();
                            depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(true)) {
                                XConnectType connectorType4 = xBaseSppConnector3.getConnectorType();
                                if (pairConnectInternal != null) {
                                    first = pairConnectInternal.getFirst();
                                } else {
                                    first = null;
                                }
                                if (pairConnectInternal != null) {
                                    second = pairConnectInternal.getSecond();
                                } else {
                                    second = null;
                                }
                                str3 = "wait " + connectorType4 + " broadcast callback,otherwise will timeout " + first + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + second + "!";
                                str4 = str3;
                                if (str4 != null) {
                                    Pair<String, String> trace7 = logger2.getTrace(depth2);
                                    strComponent3 = trace7.component1();
                                    strComponent4 = trace7.component2();
                                    FileLog fileLog7 = FileLog.INSTANCE;
                                    String str13 = logger2.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                                    FileLog.print$default(fileLog7, 3, str13, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                    if (logger2.isDebug()) {
                                        Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                    }
                                }
                            }
                            long mConnectMillisTimeOut7 = xBaseSppConnector3.getMConnectMillisTimeOut();
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.label = 4;
                        }
                    }
                } else if (!z2) {
                    if (xBaseSppConnector3.getProfileType() == 0) {
                        mXConnectCallback.callConnectFail(xBaseSppConnector3.getMBleDevice(), XConnectFailType.connectPeerPaired.INSTANCE);
                    }
                    logger2 = Logger.INSTANCE;
                    tag2 = logger2.getTAG();
                    depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        XConnectType connectorType5 = xBaseSppConnector3.getConnectorType();
                        if (pairConnectInternal != null) {
                            first = pairConnectInternal.getFirst();
                        } else {
                            first = null;
                        }
                        if (pairConnectInternal != null) {
                            second = pairConnectInternal.getSecond();
                        } else {
                            second = null;
                        }
                        str3 = "wait " + connectorType5 + " broadcast callback,otherwise will timeout " + first + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + second + "!";
                        str4 = str3;
                        if (str4 != null) {
                            Pair<String, String> trace8 = logger2.getTrace(depth2);
                            strComponent3 = trace8.component1();
                            strComponent4 = trace8.component2();
                            FileLog fileLog8 = FileLog.INSTANCE;
                            String str14 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                            FileLog.print$default(fileLog8, 3, str14, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                            }
                        }
                    }
                    long mConnectMillisTimeOut8 = xBaseSppConnector3.getMConnectMillisTimeOut();
                    anonymousClass1.L$0 = null;
                    anonymousClass1.L$1 = null;
                    anonymousClass1.label = 4;
                }
                return coroutine_suspended;
            }
            XConnector.updateLastState$default(xBaseSppConnector3, 2, null, 2, null);
            return Unit.INSTANCE;
        }
        xBaseSppConnector3.cancelJobWhenConnectedFailed("isForceConnect is false, Only classic bluetooth connections trigger connections");
        return Unit.INSTANCE;
    }

    public final boolean tryConnectSpp(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (this.isSppConnecting.get()) {
            Logger logger = Logger.INSTANCE;
            String tag2 = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                XBluetoothDevice mBleDevice = getMBleDevice();
                String str = (mBleDevice != null ? mBleDevice.getRealAddress() : null) + " isSppConnecting ignore !";
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag2, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag2 + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return true;
        }
        this.isSppConnecting.set(true);
        Logger logger2 = Logger.INSTANCE;
        String tag3 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true) && "tryConnectSpp!".length() != 0) {
            Pair<String, String> trace2 = logger2.getTrace(depth2);
            String strComponent3 = trace2.component1();
            String strComponent4 = trace2.component2();
            FileLog fileLog2 = FileLog.INSTANCE;
            String str4 = logger2.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            FileLog.print$default(fileLog2, 3, str4, tag3, "tryConnectSpp! " + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag3 + strComponent3, "tryConnectSpp! " + strComponent4);
            }
        }
        if (connectSocket()) {
            this.isSppConnecting.set(false);
            cancelJobWhenConnected(tag);
        } else {
            this.isSppConnecting.set(false);
            cancelJobWhenConnectedFailed(tag);
        }
        return false;
    }

    public final void onSppDisconnected() {
        if (!cancelJobWhenConnectedFailed("a2dp and headset disconnect!")) {
            XConnector.updateLastState$default(this, 0, null, 2, null);
        }
        closeSocket(this.bluetoothSocket);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void keyMissingChanged(BluetoothDevice device, boolean connected) {
        Job connectJob;
        Job connectJob2 = getConnectJob();
        if (connectJob2 != null && connectJob2.isActive() && (connectJob = getConnectJob()) != null) {
            connectJob.cancel((CancellationException) new ActiveDisConnectedException("keyMissingChanged"));
        }
        updateLastState(4, XConnectFailType.KeyMissingPaired.INSTANCE);
        closeSocket(this.bluetoothSocket);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onHeadSetChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (getProfileType() == 0) {
            if (headsetConnect) {
                if (getLastState().get() == 2) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09031(null), 3, null);
                return;
            } else {
                if (a2dpConnect) {
                    return;
                }
                onSppDisconnected();
                return;
            }
        }
        if (getProfileType() == 1) {
            if (headsetConnect) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "onHeadSetChange headset connect ,try connect!".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "onHeadSetChange headset connect ,try connect! " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "onHeadSetChange headset connect ,try connect! " + strComponent2);
                    }
                }
                Job connectJob = getConnectJob();
                if (connectJob != null && connectJob.isActive()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09043(null), 3, null);
                    return;
                } else {
                    if (checkIsConnectState()) {
                        return;
                    }
                    if (!checkIsConnecting()) {
                        XConnector.updateLastState$default(this, -1, null, 2, null);
                    }
                    checkParameterAndStartConnectJob(false, getMXBluetoothFlowCallBack());
                    return;
                }
            }
            onSppDisconnected();
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onHeadSetChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onHeadSetChange$1", f = "XBaseSppConnector.kt", i = {}, l = {178, 179}, m = "invokeSuspend", n = {}, s = {})
    static final class C09031 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09031(Continuation<? super C09031> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseSppConnector.this.new C09031(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09031) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector.C09031.C01761(r5.this$0, null), r5) == r0) goto L15;
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
                if (DelayKt.delay(400L, this) != coroutine_suspended) {
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
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onHeadSetChange$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: XBaseSppConnector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onHeadSetChange$1$1", f = "XBaseSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01761 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ XBaseSppConnector this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01761(XBaseSppConnector xBaseSppConnector, Continuation<? super C01761> continuation) {
                super(2, continuation);
                this.this$0 = xBaseSppConnector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01761(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01761) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Job connectJob = this.this$0.getConnectJob();
                if (connectJob != null && connectJob.isActive()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C01771(this.this$0, null), 3, null);
                } else {
                    if (this.this$0.getLastState().get() == 2) {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true) && "headset connect,but last is connected,ignore!".length() != 0) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            FileLog.print$default(fileLog, 3, str, tag, "headset connect,but last is connected,ignore! " + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, "headset connect,but last is connected,ignore! " + strComponent2);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    if (this.this$0.getLastState().get() == 5 || this.this$0.getLastState().get() != 1) {
                        XConnector.updateLastState$default(this.this$0, -1, null, 2, null);
                    }
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true) && "onHeadSetChange headset connect ,try connect!".length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str2 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        FileLog.print$default(fileLog2, 3, str2, tag2, "onHeadSetChange headset connect ,try connect! " + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, "onHeadSetChange headset connect ,try connect! " + strComponent4);
                        }
                    }
                    XBaseSppConnector xBaseSppConnector = this.this$0;
                    xBaseSppConnector.checkParameterAndStartConnectJob(false, xBaseSppConnector.getMXBluetoothFlowCallBack());
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onHeadSetChange$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: XBaseSppConnector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onHeadSetChange$1$1$1", f = "XBaseSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C01771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ XBaseSppConnector this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01771(XBaseSppConnector xBaseSppConnector, Continuation<? super C01771> continuation) {
                    super(2, continuation);
                    this.this$0 = xBaseSppConnector;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01771(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.tryConnectSpp("connectJob isActive!");
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onHeadSetChange$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onHeadSetChange$3", f = "XBaseSppConnector.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
    static final class C09043 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09043(Continuation<? super C09043> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseSppConnector.this.new C09043(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09043) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(800L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            XBaseSppConnector.this.tryConnectSpp("connectJob isActive!");
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onA2DPChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (getProfileType() == 0) {
            if (a2dpConnect) {
                if (getLastState().get() == 2) {
                    return;
                }
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09011(null), 3, null);
                return;
            } else {
                if (headsetConnect) {
                    return;
                }
                onSppDisconnected();
                return;
            }
        }
        if (getProfileType() == 2) {
            if (a2dpConnect) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "onA2DPChange a2dp connect ,try connect!".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "onA2DPChange a2dp connect ,try connect! " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "onA2DPChange a2dp connect ,try connect! " + strComponent2);
                    }
                }
                Job connectJob = getConnectJob();
                if (connectJob != null && connectJob.isActive()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C09023(null), 3, null);
                    return;
                } else {
                    if (checkIsConnectState()) {
                        return;
                    }
                    if (!checkIsConnecting()) {
                        XConnector.updateLastState$default(this, -1, null, 2, null);
                    }
                    checkParameterAndStartConnectJob(false, getMXBluetoothFlowCallBack());
                    return;
                }
            }
            onSppDisconnected();
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onA2DPChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onA2DPChange$1", f = "XBaseSppConnector.kt", i = {}, l = {243, 244}, m = "invokeSuspend", n = {}, s = {})
    static final class C09011 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09011(Continuation<? super C09011> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseSppConnector.this.new C09011(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09011) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector.C09011.C01741(r5.this$0, null), r5) == r0) goto L15;
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
                if (DelayKt.delay(800L, this) != coroutine_suspended) {
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
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onA2DPChange$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: XBaseSppConnector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onA2DPChange$1$1", f = "XBaseSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ XBaseSppConnector this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01741(XBaseSppConnector xBaseSppConnector, Continuation<? super C01741> continuation) {
                super(2, continuation);
                this.this$0 = xBaseSppConnector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01741(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Job connectJob = this.this$0.getConnectJob();
                if (connectJob != null && connectJob.isActive()) {
                    BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C01751(this.this$0, null), 3, null);
                } else {
                    if (this.this$0.getLastState().get() == 2) {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true) && "a2dp connect,but last is connected,ignore!".length() != 0) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            FileLog.print$default(fileLog, 3, str, tag, "a2dp connect,but last is connected,ignore! " + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, "a2dp connect,but last is connected,ignore! " + strComponent2);
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    if (this.this$0.getLastState().get() == 5 || this.this$0.getLastState().get() != 1) {
                        XConnector.updateLastState$default(this.this$0, -1, null, 2, null);
                    }
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true) && "onA2DPChange a2dp connect ,try connect!".length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str2 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                        FileLog.print$default(fileLog2, 3, str2, tag2, "onA2DPChange a2dp connect ,try connect! " + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, "onA2DPChange a2dp connect ,try connect! " + strComponent4);
                        }
                    }
                    XBaseSppConnector xBaseSppConnector = this.this$0;
                    xBaseSppConnector.checkParameterAndStartConnectJob(false, xBaseSppConnector.getMXBluetoothFlowCallBack());
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onA2DPChange$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: XBaseSppConnector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onA2DPChange$1$1$1", f = "XBaseSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            static final class C01751 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ XBaseSppConnector this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01751(XBaseSppConnector xBaseSppConnector, Continuation<? super C01751> continuation) {
                    super(2, continuation);
                    this.this$0 = xBaseSppConnector;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01751(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01751) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.tryConnectSpp("connectJob isActive!");
                    return Unit.INSTANCE;
                }
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onA2DPChange$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$onA2DPChange$3", f = "XBaseSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09023 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09023(Continuation<? super C09023> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseSppConnector.this.new C09023(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09023) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            XBaseSppConnector.this.tryConnectSpp("connectJob isActive!");
            return Unit.INSTANCE;
        }
    }

    public final void cancelDiscovery() {
        try {
            BluetoothAdapter bluetoothAdapter = getMXBluetoothManager().getBluetoothAdapter();
            if (bluetoothAdapter != null ? bluetoothAdapter.cancelDiscovery() : false) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    if ("cancelDiscovery success!".length() == 0) {
                        return;
                    }
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "cancelDiscovery success! " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "cancelDiscovery success! " + strComponent2);
                    }
                }
            }
        } catch (Exception e) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str2 = "cancelDiscovery error " + e.getMessage() + "!";
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    return;
                }
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 6, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.e(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [T, android.bluetooth.BluetoothSocket] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, android.bluetooth.BluetoothSocket] */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, android.bluetooth.BluetoothSocket] */
    private final boolean connectSocket() {
        BluetoothDevice deviceInfo;
        XBluetoothDevice mBleDevice = getMBleDevice();
        if (mBleDevice != null && (deviceInfo = mBleDevice.getDeviceInfo()) != null) {
            String str = this.connectUUID;
            BluetoothSocket bluetoothSocket = this.bluetoothSocket;
            if (bluetoothSocket != null && bluetoothSocket.isConnected()) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "socket is already connected!".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str2 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    FileLog.print$default(fileLog, 4, str2, tag, "socket is already connected! " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "socket is already connected! " + strComponent2);
                    }
                }
                return true;
            }
            cancelDiscovery();
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = createRfcommSocketToServiceRecord(deviceInfo, str);
            if (objectRef.element == 0) {
                objectRef.element = createRfcommSocketToServiceRecord(deviceInfo, str);
            }
            if (objectRef.element == 0) {
                objectRef.element = createRfcommSocket(deviceInfo);
            }
            if (objectRef.element == 0 || !((BluetoothSocket) objectRef.element).isConnected()) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str3 = "socket is socket or is not connected,isSppConnecting = " + this.isSppConnecting + "!";
                    String str4 = str3;
                    if (str4 != null && str4.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str5 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        FileLog.print$default(fileLog2, 6, str5, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.e(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                this.isSppConnecting.set(false);
            } else {
                this.bluetoothSocket = (BluetoothSocket) objectRef.element;
                Job job = this.receiverJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.receiverJob = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), Dispatchers.getIO(), null, new AnonymousClass3(objectRef, this, null), 2, null);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$connectSocket$3, reason: invalid class name */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$connectSocket$3", f = "XBaseSppConnector.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<BluetoothSocket> $socket;
        int label;
        final /* synthetic */ XBaseSppConnector this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Ref.ObjectRef<BluetoothSocket> objectRef, XBaseSppConnector xBaseSppConnector, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$socket = objectRef;
            this.this$0 = xBaseSppConnector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$socket, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:54:0x0247  */
        /* JADX WARN: Code duplicated, block: B:57:0x025c  */
        /* JADX WARN: Code duplicated, block: B:64:0x02be  */
        /* JADX WARN: Code duplicated, block: B:73:0x0346  */
        /* JADX WARN: Code duplicated, block: B:76:0x0375 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            Object objM6347constructorimpl;
            Throwable thM6350exceptionOrNullimpl;
            Logger logger;
            String tag;
            int depth;
            String strComponent1;
            String strComponent2;
            Logger logger2;
            String tag2;
            int depth2;
            String str;
            String str2;
            String strComponent3;
            String strComponent4;
            Object objM6347constructorimpl2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true) && "listening socket start".length() != 0) {
                    Pair<String, String> trace = logger3.getTrace(depth3);
                    String strComponent5 = trace.component1();
                    String strComponent6 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag3, "listening socket start " + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, "listening socket start " + strComponent6);
                    }
                }
                byte[] bArr = new byte[8192];
                InputStream inputStream = this.$socket.element.getInputStream();
                XBaseSppConnector xBaseSppConnector = this.this$0;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    while (true) {
                        int i2 = inputStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        byte[] bArrCopyOf = Arrays.copyOf(bArr, i2);
                        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                        try {
                            Result.Companion companion2 = Result.INSTANCE;
                            xBaseSppConnector.receiveByteArray(i2, bArrCopyOf);
                            objM6347constructorimpl2 = Result.m6347constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            objM6347constructorimpl2 = Result.m6347constructorimpl(ResultKt.createFailure(th));
                        }
                        Throwable thM6350exceptionOrNullimpl2 = Result.m6350exceptionOrNullimpl(objM6347constructorimpl2);
                        if (thM6350exceptionOrNullimpl2 != null) {
                            thM6350exceptionOrNullimpl2.printStackTrace();
                            Logger logger4 = Logger.INSTANCE;
                            String tag4 = logger4.getTAG();
                            int depth4 = logger4.getDepth();
                            if (logger4.isCanLogger(true)) {
                                thM6350exceptionOrNullimpl2.printStackTrace();
                                String str4 = "receiveByteArray error!" + thM6350exceptionOrNullimpl2.getMessage();
                                String str5 = str4;
                                if (str5 != null && str5.length() != 0) {
                                    Pair<String, String> trace2 = logger4.getTrace(depth4);
                                    String strComponent7 = trace2.component1();
                                    String strComponent8 = trace2.component2();
                                    FileLog fileLog2 = FileLog.INSTANCE;
                                    String str6 = logger4.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                    FileLog.print$default(fileLog2, 6, str6, tag4, str4 + StringUtils.SPACE + strComponent8, null, 16, null);
                                    if (logger4.isDebug()) {
                                        Log.e(tag4 + strComponent7, str4 + StringUtils.SPACE + strComponent8);
                                    }
                                }
                            }
                        }
                        Result.Companion companion4 = Result.INSTANCE;
                        objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
                        thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
                        if (thM6350exceptionOrNullimpl != null) {
                            logger2 = Logger.INSTANCE;
                            tag2 = logger2.getTAG();
                            depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(true)) {
                                str = "inputStream read error! " + thM6350exceptionOrNullimpl;
                                str2 = str;
                                if (str2 != null && str2.length() != 0) {
                                    Pair<String, String> trace3 = logger2.getTrace(depth2);
                                    strComponent3 = trace3.component1();
                                    strComponent4 = trace3.component2();
                                    FileLog fileLog3 = FileLog.INSTANCE;
                                    String str7 = logger2.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                    FileLog.print$default(fileLog3, 6, str7, tag2, str + StringUtils.SPACE + strComponent4, null, 16, null);
                                    if (logger2.isDebug()) {
                                        Log.e(tag2 + strComponent3, str + StringUtils.SPACE + strComponent4);
                                    }
                                }
                            }
                        }
                        logger = Logger.INSTANCE;
                        tag = logger.getTAG();
                        depth = logger.getDepth();
                        if (logger.isCanLogger(true) && "listening socket end!".length() != 0) {
                            Pair<String, String> trace4 = logger.getTrace(depth);
                            strComponent1 = trace4.component1();
                            strComponent2 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str8 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                            FileLog.print$default(fileLog4, 3, str8, tag, "listening socket end! " + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, "listening socket end! " + strComponent2);
                            }
                        }
                        this.label = 1;
                        if (this.this$0.disconnect(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    Logger logger5 = Logger.INSTANCE;
                    String tag5 = logger5.getTAG();
                    int depth5 = logger5.getDepth();
                    if (logger5.isCanLogger(true) && "Remote device closed the connection".length() != 0) {
                        Pair<String, String> trace5 = logger5.getTrace(depth5);
                        String strComponent9 = trace5.component1();
                        String strComponent10 = trace5.component2();
                        FileLog fileLog5 = FileLog.INSTANCE;
                        String str9 = logger5.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                        FileLog.print$default(fileLog5, 5, str9, tag5, "Remote device closed the connection" + StringUtils.SPACE + strComponent10, null, 16, null);
                        if (logger5.isDebug()) {
                            Log.w(tag5 + strComponent9, "Remote device closed the connection" + StringUtils.SPACE + strComponent10);
                        }
                    }
                    objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
                } catch (Throwable th2) {
                    Result.Companion companion5 = Result.INSTANCE;
                    objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th2));
                }
                thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
                if (thM6350exceptionOrNullimpl != null) {
                    logger2 = Logger.INSTANCE;
                    tag2 = logger2.getTAG();
                    depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        str = "inputStream read error! " + thM6350exceptionOrNullimpl;
                        str2 = str;
                        if (str2 != null) {
                            Pair<String, String> trace6 = logger2.getTrace(depth2);
                            strComponent3 = trace6.component1();
                            strComponent4 = trace6.component2();
                            FileLog fileLog6 = FileLog.INSTANCE;
                            String str10 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                            FileLog.print$default(fileLog6, 6, str10, tag2, str + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.e(tag2 + strComponent3, str + StringUtils.SPACE + strComponent4);
                            }
                        }
                    }
                }
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    Pair<String, String> trace7 = logger.getTrace(depth);
                    strComponent1 = trace7.component1();
                    strComponent2 = trace7.component2();
                    FileLog fileLog7 = FileLog.INSTANCE;
                    String str11 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                    FileLog.print$default(fileLog7, 3, str11, tag, "listening socket end! " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "listening socket end! " + strComponent2);
                    }
                }
                this.label = 1;
                if (this.this$0.disconnect(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.this$0.closeLast();
            return Unit.INSTANCE;
        }
    }

    public final void write(XCommand command) {
        OutputStream outputStream;
        OutputStream outputStream2;
        Intrinsics.checkNotNullParameter(command, "command");
        BluetoothSocket bluetoothSocket = this.bluetoothSocket;
        if (bluetoothSocket != null && !bluetoothSocket.isConnected()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "bluetoothSocket is not connect!".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "bluetoothSocket is not connect! " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "bluetoothSocket is not connect! " + strComponent2);
                }
            }
            throw new UnConnectedException("socket not connect");
        }
        if (getLastState().get() != 2) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str2 = "lastState is " + XConnectLastState.INSTANCE.getLastStateDesc(getLastState().get()) + ",not connected!";
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
            throw new UnConnectedException("lastState " + XConnectLastState.INSTANCE.getLastStateDesc(getLastState().get()));
        }
        byte[] data = command.getData();
        printWriterLog(command, data);
        try {
            BluetoothSocket bluetoothSocket2 = this.bluetoothSocket;
            if (bluetoothSocket2 != null && (outputStream2 = bluetoothSocket2.getOutputStream()) != null) {
                outputStream2.write(data);
            }
            BluetoothSocket bluetoothSocket3 = this.bluetoothSocket;
            if (bluetoothSocket3 == null || (outputStream = bluetoothSocket3.getOutputStream()) == null) {
                return;
            }
            outputStream.flush();
        } catch (Exception e) {
            throw new UnConnectedException("bluetoothSocket error " + e.getMessage() + StringUtils.SPACE + XConnectLastState.INSTANCE.getLastStateDesc(getLastState().get()));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object writeWithTask$suspendImpl(XBaseSppConnector xBaseSppConnector, byte[] bArr, long j, long j2, boolean z, boolean z2, boolean z3, String str, String str2, byte[] bArr2, AtomicInteger atomicInteger, boolean z4, String str3, ArrayList<String> arrayList, Continuation<? super byte[]> continuation) throws Throwable {
        C09051 c09051;
        long mOperateInterval;
        long j3;
        boolean z5;
        String str4;
        boolean z6;
        XBaseSppConnector xBaseSppConnector2;
        Object obj;
        Object obj2;
        boolean z7;
        ArrayList<String> arrayList2;
        byte[] bArr3;
        boolean z8;
        AtomicInteger atomicInteger2;
        byte[] bArr4;
        if (continuation instanceof C09051) {
            c09051 = (C09051) continuation;
            if ((c09051.label & Integer.MIN_VALUE) != 0) {
                c09051.label -= Integer.MIN_VALUE;
            } else {
                c09051 = xBaseSppConnector.new C09051(continuation);
            }
        } else {
            c09051 = xBaseSppConnector.new C09051(continuation);
        }
        Object obj3 = c09051.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c09051.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj3);
            c09051.L$0 = xBaseSppConnector;
            c09051.L$1 = bArr;
            c09051.L$2 = bArr2;
            c09051.L$3 = atomicInteger;
            c09051.L$4 = str3;
            c09051.L$5 = arrayList;
            mOperateInterval = j;
            c09051.J$0 = mOperateInterval;
            j3 = j2;
            c09051.J$1 = j3;
            c09051.Z$0 = z;
            z5 = z2;
            c09051.Z$1 = z5;
            c09051.Z$2 = z3;
            c09051.Z$3 = z4;
            c09051.label = 1;
            Object objIsConnected$default = XConnector.isConnected$default(xBaseSppConnector, false, c09051, 1, null);
            if (objIsConnected$default != coroutine_suspended) {
                str4 = str3;
                z6 = z;
                xBaseSppConnector2 = xBaseSppConnector;
                obj = objIsConnected$default;
                obj2 = null;
                z7 = z3;
                arrayList2 = arrayList;
                bArr3 = bArr;
                z8 = z4;
                atomicInteger2 = atomicInteger;
                bArr4 = bArr2;
            }
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            boolean z9 = c09051.Z$3;
            boolean z10 = c09051.Z$2;
            boolean z11 = c09051.Z$1;
            boolean z12 = c09051.Z$0;
            long j4 = c09051.J$1;
            long j5 = c09051.J$0;
            ResultKt.throwOnFailure(obj3);
            return obj3;
        }
        boolean z13 = c09051.Z$3;
        z7 = c09051.Z$2;
        boolean z14 = c09051.Z$1;
        z6 = c09051.Z$0;
        long j6 = c09051.J$1;
        long j7 = c09051.J$0;
        ArrayList<String> arrayList3 = (ArrayList) c09051.L$5;
        str4 = (String) c09051.L$4;
        AtomicInteger atomicInteger3 = (AtomicInteger) c09051.L$3;
        bArr4 = (byte[]) c09051.L$2;
        byte[] bArr5 = (byte[]) c09051.L$1;
        xBaseSppConnector2 = (XBaseSppConnector) c09051.L$0;
        ResultKt.throwOnFailure(obj3);
        z5 = z14;
        atomicInteger2 = atomicInteger3;
        obj = obj3;
        bArr3 = bArr5;
        arrayList2 = arrayList3;
        obj2 = null;
        z8 = z13;
        mOperateInterval = j7;
        j3 = j6;
        if (!((Boolean) obj).booleanValue()) {
            return obj2;
        }
        c09051.L$0 = xBaseSppConnector2;
        c09051.L$1 = bArr3;
        c09051.L$2 = bArr4;
        c09051.L$3 = atomicInteger2;
        c09051.L$4 = str4;
        c09051.L$5 = arrayList2;
        c09051.J$0 = mOperateInterval;
        c09051.J$1 = j3;
        c09051.Z$0 = z6;
        c09051.Z$1 = z5;
        c09051.Z$2 = z7;
        c09051.Z$3 = z8;
        boolean z15 = z7;
        c09051.label = 2;
        C09051 c09052 = c09051;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(c09052));
        XWriteCallback xWriteCallback = new XWriteCallback();
        writeWithTask$lambda$13$callback(safeContinuation).invoke(xWriteCallback);
        XCommand xCommand = xBaseSppConnector2.parserWriterCommand(str4, bArr3, arrayList2);
        if (mOperateInterval < 0) {
            mOperateInterval = xBaseSppConnector2.getMOperateInterval();
        }
        xBaseSppConnector2.getTaskQueue("TAG").addTask(new XTask(xCommand.getCommand(z5), 0, 0, j3, mOperateInterval, false, z15, null, z5, xBaseSppConnector2.getTaskBlock(xBaseSppConnector2, xCommand, bArr4), xWriteCallback, xBaseSppConnector2.getMBleDevice(), z6, bArr4, atomicInteger2, z8, 166, null));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c09052);
        }
        return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
    }

    private static final Function1<XWriteCallback, Unit> writeWithTask$lambda$13$callback(final Continuation<? super byte[]> continuation) {
        return new Function1<XWriteCallback, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$writeWithTask$2$callback$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XWriteCallback xWriteCallback) {
                invoke2(xWriteCallback);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XWriteCallback xWriteCallback) {
                Intrinsics.checkNotNullParameter(xWriteCallback, "$this$null");
                xWriteCallback.onWriteComplete(new Function2<XBluetoothDevice, Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$writeWithTask$2$callback$1.1
                    public final void invoke(XBluetoothDevice xBluetoothDevice, boolean z) {
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Boolean bool) {
                        invoke(xBluetoothDevice, bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                });
                final Continuation<byte[]> continuation2 = continuation;
                xWriteCallback.onWriteFail(new Function4<XBluetoothDevice, Integer, Integer, Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$writeWithTask$2$callback$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Integer num, Integer num2, Throwable th) {
                        invoke(xBluetoothDevice, num.intValue(), num2.intValue(), th);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable th) {
                        Intrinsics.checkNotNullParameter(th, "<anonymous parameter 3>");
                        Continuation<byte[]> continuation3 = continuation2;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation3.resumeWith(Result.m6347constructorimpl(null));
                            Result.m6347constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th2) {
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m6347constructorimpl(ResultKt.createFailure(th2));
                        }
                    }
                });
                final Continuation<byte[]> continuation3 = continuation;
                xWriteCallback.onWriteSuccess(new Function4<XBluetoothDevice, Integer, Integer, byte[], Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$writeWithTask$2$callback$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Integer num, Integer num2, byte[] bArr) {
                        invoke(xBluetoothDevice, num.intValue(), num2.intValue(), bArr);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(XBluetoothDevice xBluetoothDevice, int i, int i2, byte[] justWrite) {
                        Intrinsics.checkNotNullParameter(justWrite, "justWrite");
                        Continuation<byte[]> continuation4 = continuation3;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation4.resumeWith(Result.m6347constructorimpl(justWrite));
                            Result.m6347constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m6347constructorimpl(ResultKt.createFailure(th));
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$writeWithTask$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$writeWithTask$3", f = "XBaseSppConnector.kt", i = {0, 0}, l = {479}, m = "invokeSuspend", n = {"command", "xWriteCallback"}, s = {"L$0", "L$1"})
    static final class C09063 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $autoDoNextTask;
        final /* synthetic */ byte[] $dataArray;
        final /* synthetic */ long $durationTimeMillis;
        final /* synthetic */ boolean $ignoreFrame;
        final /* synthetic */ byte[] $mockResponse;
        final /* synthetic */ boolean $needUpdate;
        final /* synthetic */ long $operateInterval;
        final /* synthetic */ ArrayList<String> $resIds;
        final /* synthetic */ AtomicInteger $retryCount;
        final /* synthetic */ boolean $successWithComplete;
        final /* synthetic */ String $taskId;
        final /* synthetic */ Function1<XWriteCallback, Unit> $writeCallback;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C09063(String str, byte[] bArr, ArrayList<String> arrayList, Function1<? super XWriteCallback, Unit> function1, long j, boolean z, byte[] bArr2, long j2, boolean z2, boolean z3, AtomicInteger atomicInteger, boolean z4, Continuation<? super C09063> continuation) {
            super(2, continuation);
            this.$taskId = str;
            this.$dataArray = bArr;
            this.$resIds = arrayList;
            this.$writeCallback = function1;
            this.$operateInterval = j;
            this.$ignoreFrame = z;
            this.$mockResponse = bArr2;
            this.$durationTimeMillis = j2;
            this.$autoDoNextTask = z2;
            this.$needUpdate = z3;
            this.$retryCount = atomicInteger;
            this.$successWithComplete = z4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseSppConnector.this.new C09063(this.$taskId, this.$dataArray, this.$resIds, this.$writeCallback, this.$operateInterval, this.$ignoreFrame, this.$mockResponse, this.$durationTimeMillis, this.$autoDoNextTask, this.$needUpdate, this.$retryCount, this.$successWithComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09063) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            XCommand xCommand;
            Object objIsConnected$default;
            XWriteCallback xWriteCallback;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                xCommand = XBaseSppConnector.this.parserWriterCommand(this.$taskId, this.$dataArray, this.$resIds);
                XWriteCallback xWriteCallback2 = new XWriteCallback();
                this.$writeCallback.invoke(xWriteCallback2);
                this.L$0 = xCommand;
                this.L$1 = xWriteCallback2;
                this.label = 1;
                objIsConnected$default = XConnector.isConnected$default(XBaseSppConnector.this, false, this, 1, null);
                if (objIsConnected$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
                xWriteCallback = xWriteCallback2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                xWriteCallback = (XWriteCallback) this.L$1;
                xCommand = (XCommand) this.L$0;
                ResultKt.throwOnFailure(obj);
                objIsConnected$default = obj;
            }
            if (!((Boolean) objIsConnected$default).booleanValue()) {
                xWriteCallback.callWriteFail(XBaseSppConnector.this.getMBleDevice(), 1, 1, new UnConnectedException("spp not connect,command=" + xCommand));
                return Unit.INSTANCE;
            }
            long mOperateInterval = this.$operateInterval;
            if (mOperateInterval < 0) {
                mOperateInterval = XBaseSppConnector.this.getMOperateInterval();
            }
            long j = mOperateInterval;
            String command = xCommand.getCommand(this.$ignoreFrame);
            XBluetoothDevice mBleDevice = XBaseSppConnector.this.getMBleDevice();
            XBaseSppConnector xBaseSppConnector = XBaseSppConnector.this;
            XBaseSppConnector.this.getTaskQueue("TAG").addTask(new XTask(command, 0, 0, this.$durationTimeMillis, j, false, this.$autoDoNextTask, null, this.$ignoreFrame, xBaseSppConnector.getTaskBlock(xBaseSppConnector, xCommand, this.$mockResponse), xWriteCallback, mBleDevice, this.$needUpdate, this.$mockResponse, this.$retryCount, this.$successWithComplete, 166, null));
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void writeWithTask(byte[] dataArray, long operateInterval, long durationTimeMillis, boolean needUpdate, boolean ignoreFrame, boolean autoDoNextTask, String serviceUUID, String writeUUID, byte[] mockResponse, AtomicInteger retryCount, boolean successWithComplete, String taskId, ArrayList<String> resIds, Function1<? super XWriteCallback, Unit> writeCallback) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        Intrinsics.checkNotNullParameter(serviceUUID, "serviceUUID");
        Intrinsics.checkNotNullParameter(writeUUID, "writeUUID");
        Intrinsics.checkNotNullParameter(writeCallback, "writeCallback");
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C09063(taskId, dataArray, resIds, writeCallback, operateInterval, ignoreFrame, mockResponse, durationTimeMillis, autoDoNextTask, needUpdate, retryCount, successWithComplete, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$getTaskBlock$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseSppConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/nothing/link/bluetooth/sdk/task/XTask;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.spp.XBaseSppConnector$getTaskBlock$1", f = "XBaseSppConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C09001 extends SuspendLambda implements Function2<XTask, Continuation<? super Boolean>, Object> {
        final /* synthetic */ XCommand $command;
        final /* synthetic */ byte[] $mockResponse;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09001(XCommand xCommand, byte[] bArr, Continuation<? super C09001> continuation) {
            super(2, continuation);
            this.$command = xCommand;
            this.$mockResponse = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C09001 c09001 = XBaseSppConnector.this.new C09001(this.$command, this.$mockResponse, continuation);
            c09001.L$0 = obj;
            return c09001;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(XTask xTask, Continuation<? super Boolean> continuation) {
            return ((C09001) create(xTask, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            XWriteCallback writeCallback;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            XTask xTask = (XTask) this.L$0;
            XBaseSppConnector.this.write(this.$command);
            if (this.$mockResponse != null) {
                Logger logger = Logger.INSTANCE;
                XCommand xCommand = this.$command;
                byte[] bArr = this.$mockResponse;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "ignore task(" + xCommand + "),response " + BleUtil.bytesToHex$default(BleUtil.INSTANCE, bArr, false, 2, null);
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
                xTask.setSuccess();
                Job taskJob = xTask.getTaskJob();
                if (taskJob != null) {
                    taskJob.cancel((CancellationException) new CompleteException("task done"));
                }
                XWriteCallback writeCallback2 = xTask.getWriteCallback();
                if (writeCallback2 != null) {
                    writeCallback2.callWriteSuccess(XBaseSppConnector.this.getMBleDevice(), xTask.getCurrentPackage(), xTask.getTotalPackage(), this.$mockResponse);
                }
                if (xTask.getCurrentPackage() == xTask.getTotalPackage() && (writeCallback = xTask.getWriteCallback()) != null) {
                    writeCallback.callWriteComplete(xTask.getDevice(), true);
                }
                XBaseSppConnector.this.getTaskQueue("TAG").getTaskList().remove(xTask);
            } else {
                xTask.setWaiting();
                XBaseSppConnector.this.getTaskQueue("TAG").getTaskList().moveToWaitList(xTask);
            }
            XBaseSppConnector.this.getTaskQueue("TAG").autoRunNextTask(xTask);
            return Boxing.boxBoolean(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function2<XTask, Continuation<? super Boolean>, Object> getTaskBlock(XBaseSppConnector xBaseSppConnector, XCommand xCommand, byte[] bArr) {
        return xBaseSppConnector.new C09001(xCommand, bArr, null);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0057  */
    /* JADX WARN: Code duplicated, block: B:48:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:51:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:58:0x021d  */
    /* JADX WARN: Code duplicated, block: B:62:0x0251  */
    /* JADX WARN: Code duplicated, block: B:63:0x0254  */
    private final BluetoothSocket createRfcommSocket(BluetoothDevice device) {
        Object obj;
        Object objInvoke;
        Object objM6347constructorimpl;
        Throwable thM6350exceptionOrNullimpl;
        Object obj2;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        BluetoothSocket bluetoothSocket;
        if (!BleUtil.INSTANCE.checkBluetoothPermissions()) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "reflect socket no permission".length() != 0) {
                Pair<String, String> trace = logger2.getTrace(depth2);
                String strComponent3 = trace.component1();
                String strComponent4 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag2, "reflect socket no permission " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag2 + strComponent3, "reflect socket no permission " + strComponent4);
                }
            }
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Method method = device.getClass().getMethod("createRfcommSocket", Integer.TYPE);
            method.setAccessible(true);
            objInvoke = method.invoke(device, Integer.valueOf(this.channel));
            if (objInvoke != null && (objInvoke instanceof BluetoothSocket)) {
                try {
                    ((BluetoothSocket) objInvoke).connect();
                    Logger logger3 = Logger.INSTANCE;
                    String tag3 = logger3.getTAG();
                    int depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true)) {
                        String str4 = "reflect socket successful!" + ((BluetoothSocket) objInvoke).isConnected();
                        String str5 = str4;
                        if (str5 == null || str5.length() == 0) {
                            obj = null;
                        } else {
                            Pair<String, String> trace2 = logger3.getTrace(depth3);
                            String strComponent5 = trace2.component1();
                            String strComponent6 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str6 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                            obj = null;
                            try {
                                FileLog.print$default(fileLog2, 3, str6, tag3, str4 + StringUtils.SPACE + strComponent6, null, 16, null);
                                if (logger3.isDebug()) {
                                    Log.i(tag3 + strComponent5, str4 + StringUtils.SPACE + strComponent6);
                                }
                            } catch (Throwable th) {
                                th = th;
                                Result.Companion companion2 = Result.INSTANCE;
                                objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
                            }
                        }
                        bluetoothSocket = (BluetoothSocket) objInvoke;
                    } else {
                        obj = null;
                        bluetoothSocket = (BluetoothSocket) objInvoke;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = null;
                    Result.Companion companion3 = Result.INSTANCE;
                    objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
                }
                thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
                if (thM6350exceptionOrNullimpl != null) {
                    logger = Logger.INSTANCE;
                    tag = logger.getTAG();
                    depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        str = "reflect socket failed! message:" + thM6350exceptionOrNullimpl.getMessage();
                        str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace3 = logger.getTrace(depth);
                            strComponent1 = trace3.component1();
                            strComponent2 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str7 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                            FileLog.print$default(fileLog3, 6, str7, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    closeSocket((BluetoothSocket) objInvoke);
                }
                if (Result.m6353isFailureimpl(objM6347constructorimpl)) {
                    obj2 = obj;
                } else {
                    obj2 = objM6347constructorimpl;
                }
                return (BluetoothSocket) obj2;
            }
            obj = null;
            try {
                Logger logger4 = Logger.INSTANCE;
                String tag4 = logger4.getTAG();
                int depth4 = logger4.getDepth();
                if (logger4.isCanLogger(true) && "reflect socket failed!".length() != 0) {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str8 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    FileLog.print$default(fileLog4, 3, str8, tag4, "reflect socket failed! " + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag4 + strComponent7, "reflect socket failed! " + strComponent8);
                    }
                }
                bluetoothSocket = null;
                objInvoke = null;
            } catch (Throwable th3) {
                th = th3;
                objInvoke = obj;
                Result.Companion companion4 = Result.INSTANCE;
                objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            objM6347constructorimpl = Result.m6347constructorimpl(bluetoothSocket);
        } catch (Throwable th4) {
            th = th4;
            obj = null;
        }
        thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "reflect socket failed! message:" + thM6350exceptionOrNullimpl.getMessage();
                str2 = str;
                if (str2 != null) {
                    Pair<String, String> trace5 = logger.getTrace(depth);
                    strComponent1 = trace5.component1();
                    strComponent2 = trace5.component2();
                    FileLog fileLog5 = FileLog.INSTANCE;
                    String str9 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                    FileLog.print$default(fileLog5, 6, str9, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            closeSocket((BluetoothSocket) objInvoke);
        }
        if (Result.m6353isFailureimpl(objM6347constructorimpl)) {
            obj2 = obj;
        } else {
            obj2 = objM6347constructorimpl;
        }
        return (BluetoothSocket) obj2;
    }

    private final void closeSocket(BluetoothSocket socket) {
        if (socket != null) {
            try {
                if (socket.isConnected()) {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true) && "close socket".length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                        FileLog.print$default(fileLog, 3, str, tag, "close socket " + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, "close socket " + strComponent2);
                        }
                    }
                    socket.close();
                }
            } catch (Exception unused) {
            }
        }
    }

    private final BluetoothSocket createRfcommSocketToServiceRecord(BluetoothDevice device, String connectUUID) {
        BluetoothSocket bluetoothSocket;
        BluetoothSocket bluetoothSocketCreateRfcommSocketToServiceRecord;
        if (!BleUtil.INSTANCE.checkBluetoothPermissions()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "create socket no permission".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "create socket no permission " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "create socket no permission " + strComponent2);
                }
            }
            return null;
        }
        try {
            bluetoothSocketCreateRfcommSocketToServiceRecord = device.createRfcommSocketToServiceRecord(UUID.fromString(connectUUID));
            try {
                if (!bluetoothSocketCreateRfcommSocketToServiceRecord.isConnected()) {
                    bluetoothSocketCreateRfcommSocketToServiceRecord.connect();
                }
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str2 = "create socket successful!" + bluetoothSocketCreateRfcommSocketToServiceRecord.isConnected();
                    String str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str4 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                        bluetoothSocket = null;
                        try {
                            FileLog.print$default(fileLog2, 3, str4, tag2, str2 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, str2 + StringUtils.SPACE + strComponent4);
                            }
                        } catch (Exception e) {
                            e = e;
                            Logger logger3 = Logger.INSTANCE;
                            String tag3 = logger3.getTAG();
                            int depth3 = logger3.getDepth();
                            if (logger3.isCanLogger(true)) {
                                String str5 = "create socket failed! message:" + e.getMessage();
                                String str6 = str5;
                                if (str6 != null && str6.length() != 0) {
                                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                                    String strComponent5 = trace3.component1();
                                    String strComponent6 = trace3.component2();
                                    FileLog fileLog3 = FileLog.INSTANCE;
                                    String str7 = logger3.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                    FileLog.print$default(fileLog3, 6, str7, tag3, str5 + StringUtils.SPACE + strComponent6, null, 16, null);
                                    if (logger3.isDebug()) {
                                        Log.e(tag3 + strComponent5, str5 + StringUtils.SPACE + strComponent6);
                                    }
                                }
                            }
                            closeSocket(bluetoothSocketCreateRfcommSocketToServiceRecord);
                            return bluetoothSocket;
                        }
                    }
                    return bluetoothSocketCreateRfcommSocketToServiceRecord;
                }
                return bluetoothSocketCreateRfcommSocketToServiceRecord;
            } catch (Exception e2) {
                e = e2;
                bluetoothSocket = null;
            }
        } catch (Exception e3) {
            e = e3;
            bluetoothSocket = null;
            bluetoothSocketCreateRfcommSocketToServiceRecord = null;
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void closeLast() {
        Job job = this.receiverJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        closeSocket(this.bluetoothSocket);
        this.bluetoothSocket = null;
    }
}
