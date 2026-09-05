package com.nothing.link.bluetooth.sdk.connect;

import android.util.Log;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.scan.XBluetoothFlowCallBack;
import com.nothing.link.bluetooth.sdk.task.XTask;
import com.nothing.link.bluetooth.sdk.task.XTaskList;
import com.nothing.link.bluetooth.sdk.task.XTaskQueue;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import com.nothing.os.device.DeviceConstant;
import io.grpc.internal.GrpcUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00b2\u00012\u00020\u0001:\u0002\u00b2\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010R\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u0005H\u0016J\b\u0010T\u001a\u00020\u0010H\u0016J\b\u0010U\u001a\u00020\u0010H\u0016J\u0010\u0010V\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010W\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010X\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\u0005H\u0016J\u0006\u0010Z\u001a\u00020 J\u0006\u0010[\u001a\u00020 J\u0006\u0010\\\u001a\u00020 J\u001a\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020 2\b\u0010_\u001a\u0004\u0018\u00010`H\u0016J\b\u0010a\u001a\u00020\u0010H\u0016J\b\u0010b\u001a\u00020\u0010H&J\u00a5\u0001\u0010c\u001a\u00020\u00102\n\b\u0002\u0010d\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010f\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010g\u001a\u0004\u0018\u00010,2\b\b\u0002\u0010$\u001a\u00020 2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010h\u001a\u00020 2\b\b\u0002\u0010i\u001a\u00020\n2\b\b\u0002\u0010j\u001a\u00020 2\u0017\u0010k\u001a\u0013\u0012\u0004\u0012\u00020?\u0012\u0004\u0012\u00020\u00100G\u00a2\u0006\u0002\bl2\u001b\b\u0002\u0010m\u001a\u0015\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u0010\u0018\u00010G\u00a2\u0006\u0002\blH\u0016\u00a2\u0006\u0002\u0010nJ\u0018\u0010o\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\u0005H\u0016J\u001b\u0010p\u001a\u00020\u00102\b\u0010q\u001a\u0004\u0018\u00010rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010sJ\b\u0010t\u001a\u00020\u0010H\u0002J\b\u0010u\u001a\u00020\u0010H\u0016J\n\u0010v\u001a\u0004\u0018\u000109H\u0016J\b\u0010w\u001a\u00020\u0010H&J\u0011\u0010x\u001a\u00020 H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010yJ\b\u0010z\u001a\u00020\u0005H\u0016J\u000e\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\nJ\u0010\u0010}\u001a\u00020M2\u0006\u0010~\u001a\u00020\u0005H\u0016J\u000f\u0010\u007f\u001a\u00020 2\u0007\u0010\u0080\u0001\u001a\u00020\u0005J\u0007\u0010\u0081\u0001\u001a\u00020 J\u0012\u0010\u0082\u0001\u001a\u00020\u00102\u0007\u0010\u0083\u0001\u001a\u00020rH\u0016J\u001e\u0010\u0084\u0001\u001a\u00020 2\t\b\u0002\u0010\u0085\u0001\u001a\u00020 H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0086\u0001J\u001c\u0010\u0087\u0001\u001a\u00020 2\u0007\u0010\u0085\u0001\u001a\u00020 H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0088\u0001\u001a\u00020 2\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0002J\u0015\u0010\u008b\u0001\u001a\u00020\u00102\n\u0010\u0089\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0002J\t\u0010\u008c\u0001\u001a\u00020\u0010H\u0016J\u001b\u0010\u008d\u0001\u001a\u00020\u00102\u0006\u0010I\u001a\u00020\u00052\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H&J\u001b\u0010\u0090\u0001\u001a\u00020\u00102\u0006\u0010I\u001a\u00020H2\b\u0010\u008e\u0001\u001a\u00030\u008f\u0001H&J8\u0010\u0091\u0001\u001a\u00020\u00102\b\u0010\u0092\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u00020H2\u001c\u0010\u0095\u0001\u001a\u0017\u0012\u0005\u0012\u00030\u0096\u0001\u0012\u0006\u0012\u0004\u0018\u00010H\u0012\u0004\u0012\u00020 0\tJK\u0010\u0097\u0001\u001a\u00020\u00102\u0007\u0010\u0080\u0001\u001a\u00020\u000529\u0010\u0098\u0001\u001a4\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tJ6\u0010\u0099\u0001\u001a\u00020\u00102\u0007\u0010\u0080\u0001\u001a\u00020\u00052$\u0010\u0098\u0001\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010H\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u00100GJ\u001d\u0010\u009a\u0001\u001a\u00020\u00102\t\u0010\u009b\u0001\u001a\u0004\u0018\u0001092\u0007\u0010\u0083\u0001\u001a\u00020rH\u0002J\t\u0010\u009c\u0001\u001a\u00020\u0010H\u0016J\u0007\u0010\u009d\u0001\u001a\u00020\u0010J\u001b\u0010\u009e\u0001\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ\u00c1\u0001\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u008f\u00012\b\u0010\u00a0\u0001\u001a\u00030\u008f\u00012\t\b\u0002\u0010\u00a1\u0001\u001a\u00020,2\t\b\u0002\u0010\u00a2\u0001\u001a\u00020,2\t\b\u0002\u0010\u00a3\u0001\u001a\u00020 2\t\b\u0002\u0010\u00a4\u0001\u001a\u00020 2\t\b\u0002\u0010\u00a5\u0001\u001a\u00020 2\t\b\u0002\u0010\u00a6\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u00a7\u0001\u001a\u00020\u00052\f\b\u0002\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u000b\b\u0002\u0010\u00a9\u0001\u001a\u0004\u0018\u00010&2\t\b\u0002\u0010\u00aa\u0001\u001a\u00020 2\u000b\b\u0002\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u00052\u001f\b\u0002\u0010\u00ac\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00ad\u0001j\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00ae\u0001H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00af\u0001J\u00cf\u0001\u0010\u009f\u0001\u001a\u00020\u00102\b\u0010\u00a0\u0001\u001a\u00030\u008f\u00012\t\b\u0002\u0010\u00a1\u0001\u001a\u00020,2\t\b\u0002\u0010\u00a2\u0001\u001a\u00020,2\t\b\u0002\u0010\u00a3\u0001\u001a\u00020 2\t\b\u0002\u0010\u00a4\u0001\u001a\u00020 2\t\b\u0002\u0010\u00a5\u0001\u001a\u00020 2\t\b\u0002\u0010\u00a6\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u00a7\u0001\u001a\u00020\u00052\f\b\u0002\u0010\u00a8\u0001\u001a\u0005\u0018\u00010\u008f\u00012\u000b\b\u0002\u0010\u00a9\u0001\u001a\u0004\u0018\u00010&2\t\b\u0002\u0010\u00aa\u0001\u001a\u00020 2\u000b\b\u0002\u0010\u00ab\u0001\u001a\u0004\u0018\u00010\u00052\u001f\b\u0002\u0010\u00ac\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00ad\u0001j\u000b\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00ae\u00012\u0019\u0010\u00b0\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00b1\u0001\u0012\u0004\u0012\u00020\u00100G\u00a2\u0006\u0002\blH\u0016RL\u0010\u0007\u001a@\u0012\u0004\u0012\u00020\u0005\u00126\u00124\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001a\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u00103\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001aR\u0011\u00105\u001a\u00020,\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u000e\u00107\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010ER7\u0010F\u001a+\u0012\u0004\u0012\u00020\u0005\u0012!\u0012\u001f\u0012\u0015\u0012\u0013\u0018\u00010H\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(I\u0012\u0004\u0012\u00020\u00100G0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR&\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020M0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00b3\u0001"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/XBondConnector;", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", ViewKey.TAG, "", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;Ljava/lang/String;)V", "connectCallbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "state", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "failType", "", "connectJob", "Lkotlinx/coroutines/Job;", "getConnectJob", "()Lkotlinx/coroutines/Job;", "setConnectJob", "(Lkotlinx/coroutines/Job;)V", "createJob", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getCreateJob", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "currentConnectRetryCount", "isActiveDisconnect", "setActiveDisconnect", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isForceConnect", "", "()Z", "setForceConnect", "(Z)V", "isForceConnectRelation", "lastState", "Ljava/util/concurrent/atomic/AtomicInteger;", "getLastState", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setLastState", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "mConnectMillisTimeOut", "", "getMConnectMillisTimeOut", "()J", "setMConnectMillisTimeOut", "(J)V", "mConnectRetryCount", "mConnectRetryInterval", "mIsNeedScan", "getMIsNeedScan", "mOperateInterval", "getMOperateInterval", "mOperationInterval", "mRelationConnector", "Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTConnector;", "getMRelationConnector", "()Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTConnector;", "setMRelationConnector", "(Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTConnector;)V", "mXConnectCallback", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;", "getMXConnectCallback", "()Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;", "setMXConnectCallback", "(Lcom/nothing/link/bluetooth/sdk/connect/XConnectCallback;)V", "getParser", "()Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", "receiveCallbacks", "Lkotlin/Function1;", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "command", "getTag", "()Ljava/lang/String;", "taskQueueMap", "Lcom/nothing/link/bluetooth/sdk/task/XTaskQueue;", "getTaskQueueMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setTaskQueueMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "boundCancel", "code", "boundSuccess", "boundTimeOut", "cancelJobWhenConnected", "cancelJobWhenConnectedFailed", "checkFail", "reason", "checkIsConnectState", "checkIsConnecting", "checkIsIdleState", "checkParameterAndStartConnectJob", "isRetry", "flowCallBack", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "clearTaskQueue", "closeLast", "connect", "connectMillisTimeOut", "connectRetryCount", "connectRetryInterval", "boundMillisTimeOut", "isNeedScan", "profileType", "allowCreateBond", "connectCallback", "Lkotlin/ExtensionFunctionType;", "bluetoothFlowCallback", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;ZZZIZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "connectFail", "connectInternal", "bleDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "(Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectSuccess", "connectTaskQueue", "createRelationConnector", "disConnectInternal", DeviceEarImage.DISCONNECT_EAR_IMAGE, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMacAddress", "getStepStatus", "step", "getTaskQueue", "queueId", "hasConnectCallback", "key", "hasRelationConnector", "initParams", "device", "isConnected", "isSystem", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRelationConnected", "isRetryConnect", "throwable", "", "onCompletion", "onDestroy", "printReceiverLog", "byteArray", "", "printWriterLog", "receiveCallbackCommand", "taskList", "Lcom/nothing/link/bluetooth/sdk/task/XTaskList;", "item", "predicate", "Lcom/nothing/link/bluetooth/sdk/task/XTask;", "setDeviceConnectCallback", "callback", "setMessageReceiveCallback", "setRelationConnector", "connector", "startBound", "stopConnect", "updateLastState", "writeWithTask", "dataArray", "operateInterval", "durationTimeMillis", "needUpdate", "ignoreFrame", "autoDoNextTask", "serviceUUID", "writeUUID", "mockResponse", "retryCount", "successWithComplete", "taskId", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "([BJJZZZLjava/lang/String;Ljava/lang/String;[BLjava/util/concurrent/atomic/AtomicInteger;ZLjava/lang/String;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeCallback", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XConnector extends XBondConnector {
    public static final String TAG = "TAG";
    private ConcurrentHashMap<String, Function2<Integer, XConnectFailType, Unit>> connectCallbacks;
    private Job connectJob;
    private final AtomicBoolean createJob;
    private int currentConnectRetryCount;
    private AtomicBoolean isActiveDisconnect;
    private boolean isForceConnect;
    private boolean isForceConnectRelation;
    private AtomicInteger lastState;
    private long mConnectMillisTimeOut;
    private int mConnectRetryCount;
    private long mConnectRetryInterval;
    private final AtomicBoolean mIsNeedScan;
    private final long mOperateInterval;
    private long mOperationInterval;
    private XBTConnector mRelationConnector;
    private XConnectCallback mXConnectCallback;
    private final XByteArrayParser parser;
    private ConcurrentHashMap<String, Function1<XCommand, Unit>> receiveCallbacks;
    private final String tag;
    private ConcurrentHashMap<String, XTaskQueue> taskQueueMap;

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnector$isRelationConnected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnector", f = "XConnector.kt", i = {}, l = {142}, m = "isRelationConnected", n = {}, s = {})
    static final class C08741 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08741(Continuation<? super C08741> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XConnector.this.isRelationConnected(false, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XConnector() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    static /* synthetic */ Object writeWithTask$suspendImpl(XConnector xConnector, byte[] bArr, long j, long j2, boolean z, boolean z2, boolean z3, String str, String str2, byte[] bArr2, AtomicInteger atomicInteger, boolean z4, String str3, ArrayList<String> arrayList, Continuation<? super byte[]> continuation) {
        return null;
    }

    public abstract void closeLast();

    public abstract Object connectInternal(XBluetoothDevice xBluetoothDevice, Continuation<? super Unit> continuation);

    public void connectTaskQueue() {
    }

    public XBTConnector createRelationConnector() {
        return null;
    }

    public abstract void disConnectInternal();

    public abstract Object isConnected(boolean z, Continuation<? super Boolean> continuation);

    public abstract void printReceiverLog(String command, byte[] byteArray);

    public abstract void printWriterLog(XCommand command, byte[] byteArray);

    public Object writeWithTask(byte[] bArr, long j, long j2, boolean z, boolean z2, boolean z3, String str, String str2, byte[] bArr2, AtomicInteger atomicInteger, boolean z4, String str3, ArrayList<String> arrayList, Continuation<? super byte[]> continuation) {
        return writeWithTask$suspendImpl(this, bArr, j, j2, z, z2, z3, str, str2, bArr2, atomicInteger, z4, str3, arrayList, continuation);
    }

    public void writeWithTask(byte[] dataArray, long operateInterval, long durationTimeMillis, boolean needUpdate, boolean ignoreFrame, boolean autoDoNextTask, String serviceUUID, String writeUUID, byte[] mockResponse, AtomicInteger retryCount, boolean successWithComplete, String taskId, ArrayList<String> resIds, Function1<? super XWriteCallback, Unit> writeCallback) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        Intrinsics.checkNotNullParameter(serviceUUID, "serviceUUID");
        Intrinsics.checkNotNullParameter(writeUUID, "writeUUID");
        Intrinsics.checkNotNullParameter(writeCallback, "writeCallback");
    }

    public /* synthetic */ XConnector(XDefaultParser xDefaultParser, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new XDefaultParser() : xDefaultParser, (i & 2) != 0 ? "Writer" : str);
    }

    public final XByteArrayParser getParser() {
        return this.parser;
    }

    public final String getTag() {
        return this.tag;
    }

    public XConnector(XByteArrayParser parser, String tag) {
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.parser = parser;
        this.tag = tag;
        this.lastState = new AtomicInteger(0);
        this.isActiveDisconnect = new AtomicBoolean(false);
        this.mConnectMillisTimeOut = getMXBluetoothManager().getBluetoothConfig().getConnectMillisTimeOut();
        this.mConnectRetryCount = getMXBluetoothManager().getBluetoothConfig().getConnectRetryCount();
        this.mConnectRetryInterval = getMXBluetoothManager().getBluetoothConfig().getConnectRetryInterval();
        this.mOperationInterval = getMXBluetoothManager().getBluetoothConfig().getBoundMillisTimeOut();
        this.isForceConnectRelation = true;
        this.isForceConnect = true;
        this.mOperateInterval = XBluetoothManager.INSTANCE.get().getBluetoothConfig().getOperateInterval();
        this.taskQueueMap = new ConcurrentHashMap<>();
        this.receiveCallbacks = new ConcurrentHashMap<>();
        this.connectCallbacks = new ConcurrentHashMap<>();
        this.createJob = new AtomicBoolean(false);
        this.mIsNeedScan = new AtomicBoolean(false);
    }

    public final AtomicInteger getLastState() {
        return this.lastState;
    }

    public final void setLastState(AtomicInteger atomicInteger) {
        Intrinsics.checkNotNullParameter(atomicInteger, "<set-?>");
        this.lastState = atomicInteger;
    }

    /* JADX INFO: renamed from: isActiveDisconnect, reason: from getter */
    public final AtomicBoolean getIsActiveDisconnect() {
        return this.isActiveDisconnect;
    }

    public final void setActiveDisconnect(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isActiveDisconnect = atomicBoolean;
    }

    public final long getMConnectMillisTimeOut() {
        return this.mConnectMillisTimeOut;
    }

    public final void setMConnectMillisTimeOut(long j) {
        this.mConnectMillisTimeOut = j;
    }

    /* JADX INFO: renamed from: isForceConnect, reason: from getter */
    public final boolean getIsForceConnect() {
        return this.isForceConnect;
    }

    public final void setForceConnect(boolean z) {
        this.isForceConnect = z;
    }

    public final Job getConnectJob() {
        return this.connectJob;
    }

    public final void setConnectJob(Job job) {
        this.connectJob = job;
    }

    public final long getMOperateInterval() {
        return this.mOperateInterval;
    }

    public final ConcurrentHashMap<String, XTaskQueue> getTaskQueueMap() {
        return this.taskQueueMap;
    }

    public final void setTaskQueueMap(ConcurrentHashMap<String, XTaskQueue> concurrentHashMap) {
        Intrinsics.checkNotNullParameter(concurrentHashMap, "<set-?>");
        this.taskQueueMap = concurrentHashMap;
    }

    public final XConnectCallback getMXConnectCallback() {
        return this.mXConnectCallback;
    }

    public final void setMXConnectCallback(XConnectCallback xConnectCallback) {
        this.mXConnectCallback = xConnectCallback;
    }

    public final XBTConnector getMRelationConnector() {
        return this.mRelationConnector;
    }

    public final void setMRelationConnector(XBTConnector xBTConnector) {
        this.mRelationConnector = xBTConnector;
    }

    public final boolean hasRelationConnector() {
        return (this.isForceConnectRelation && this.mRelationConnector == null) ? false : true;
    }

    public final AtomicBoolean getCreateJob() {
        return this.createJob;
    }

    public final AtomicBoolean getMIsNeedScan() {
        return this.mIsNeedScan;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object isRelationConnected(boolean z, Continuation<? super Boolean> continuation) {
        C08741 c08741;
        if (continuation instanceof C08741) {
            c08741 = (C08741) continuation;
            if ((c08741.label & Integer.MIN_VALUE) != 0) {
                c08741.label -= Integer.MIN_VALUE;
            } else {
                c08741 = new C08741(continuation);
            }
        } else {
            c08741 = new C08741(continuation);
        }
        Object objIsConnected$default = c08741.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08741.label;
        boolean z2 = false;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsConnected$default);
            XBTConnector xBTConnector = this.mRelationConnector;
            if (xBTConnector == null) {
                return Boxing.boxBoolean(true);
            }
            if (xBTConnector != null) {
                c08741.label = 1;
                objIsConnected$default = XBTConnector.isConnected$default(xBTConnector, 0, c08741, 1, null);
                if (objIsConnected$default == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Boxing.boxBoolean(z2);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(objIsConnected$default);
        if (((Boolean) objIsConnected$default).booleanValue()) {
            z2 = true;
        }
        return Boxing.boxBoolean(z2);
    }

    public XTaskQueue getTaskQueue(String queueId) {
        XTaskQueue xTaskQueuePutIfAbsent;
        Intrinsics.checkNotNullParameter(queueId, "queueId");
        ConcurrentHashMap<String, XTaskQueue> concurrentHashMap = this.taskQueueMap;
        XTaskQueue xTaskQueue = concurrentHashMap.get(queueId);
        if (xTaskQueue == null && (xTaskQueuePutIfAbsent = concurrentHashMap.putIfAbsent(queueId, (xTaskQueue = new XTaskQueue(queueId)))) != null) {
            xTaskQueue = xTaskQueuePutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(xTaskQueue, "getOrPut(...)");
        return xTaskQueue;
    }

    public void clearTaskQueue() {
        Iterator<Map.Entry<String, XTaskQueue>> it = this.taskQueueMap.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().clear();
        }
    }

    public final String getStepStatus(int step) {
        int connectTotalStep = getConnectTotalStep();
        XBluetoothDevice mBleDevice = getMBleDevice();
        String deviceAddress = mBleDevice != null ? mBleDevice.getDeviceAddress() : null;
        XBluetoothDevice mBleDevice2 = getMBleDevice();
        return "CONNECT(" + step + "/" + connectTotalStep + ") " + deviceAddress + "/" + (mBleDevice2 != null ? mBleDevice2.getRealAddress() : null) + StringUtils.SPACE + getConnectorType() + StringUtils.SPACE;
    }

    public static /* synthetic */ void updateLastState$default(XConnector xConnector, int i, XConnectFailType xConnectFailType, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateLastState");
        }
        if ((i2 & 2) != 0) {
            xConnectFailType = null;
        }
        xConnector.updateLastState(i, xConnectFailType);
    }

    public final void updateLastState(int state, XConnectFailType failType) {
        XConnectCallback xConnectCallback;
        int i = this.lastState.get();
        boolean z = i == 0 || i == 4;
        boolean z2 = state == 0 || state == 4;
        if (state == 2) {
            XConnectCallback xConnectCallback2 = this.mXConnectCallback;
            if (xConnectCallback2 != null) {
                xConnectCallback2.callConnectSuccess(getConnectorType(), getMBleDevice());
            }
            connectTaskQueue();
        } else if (state == 4 && (xConnectCallback = this.mXConnectCallback) != null) {
            xConnectCallback.callConnectFail(getMBleDevice(), failType == null ? XConnectFailType.Unknown.INSTANCE : failType);
        }
        if (i != state) {
            this.lastState.set(state);
            if (!z2 || !z) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = getConnectorType() + " updateLastState " + XConnectLastState.INSTANCE.getLastStateDesc(state) + StringUtils.SPACE + getMBleDevice();
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
                if (state == 0 || state == 4) {
                    disConnectInternal();
                    clearTaskQueue();
                }
            }
            Iterator<Map.Entry<String, Function2<Integer, XConnectFailType, Unit>>> it = this.connectCallbacks.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().invoke(Integer.valueOf(state), failType);
            }
            return;
        }
        if (this.mXConnectCallback != null && state == 2) {
            Iterator<Map.Entry<String, Function2<Integer, XConnectFailType, Unit>>> it2 = this.connectCallbacks.entrySet().iterator();
            while (it2.hasNext()) {
                it2.next().getValue().invoke(Integer.valueOf(state), failType);
            }
        } else {
            if (state != 4 || failType == null) {
                return;
            }
            Iterator<Map.Entry<String, Function2<Integer, XConnectFailType, Unit>>> it3 = this.connectCallbacks.entrySet().iterator();
            while (it3.hasNext()) {
                it3.next().getValue().invoke(Integer.valueOf(state), failType);
            }
        }
    }

    public final boolean hasConnectCallback(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.connectCallbacks.containsKey(key);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void initParams(XBluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        setMBleDevice(device);
        if (getMContext() == null) {
            setMContext(getMXBluetoothManager().getContext());
            this.mOperationInterval = getMXBluetoothManager().getBluetoothConfig().getOperateInterval();
            setRelationConnector(createRelationConnector(), device);
        } else {
            XBTConnector xBTConnector = this.mRelationConnector;
            if (xBTConnector != null) {
                xBTConnector.initParams(device);
            }
        }
    }

    private final void setRelationConnector(XBTConnector connector, XBluetoothDevice device) {
        this.mRelationConnector = connector;
        if (connector != null) {
            connector.initParams(device);
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public String getMacAddress() {
        String realAddress;
        XBluetoothDevice mBleDevice = getMBleDevice();
        return (mBleDevice == null || (realAddress = mBleDevice.getRealAddress()) == null) ? "" : realAddress;
    }

    public final void setMessageReceiveCallback(String key, Function1<? super XCommand, Unit> callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.receiveCallbacks.containsKey(key)) {
            return;
        }
        this.receiveCallbacks.put(key, callback);
    }

    public final void setDeviceConnectCallback(String key, Function2<? super Integer, ? super XConnectFailType, Unit> callback) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (this.connectCallbacks.containsKey(key)) {
            return;
        }
        this.connectCallbacks.put(key, callback);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void onDestroy() {
        super.onDestroy();
        updateLastState$default(this, 0, null, 2, null);
        this.taskQueueMap.clear();
        this.connectCallbacks.clear();
        this.receiveCallbacks.clear();
    }

    public final boolean checkIsConnecting() {
        return this.lastState.get() == 1 || this.lastState.get() == 5;
    }

    public final boolean checkIsConnectState() {
        return this.lastState.get() == 2;
    }

    public final boolean checkIsIdleState() {
        return this.lastState.get() == -1;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void startBound() {
        updateLastState$default(this, 5, null, 2, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void boundTimeOut() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getConnectorType() + " device bond time out!";
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
        connectFail(XConnectFailType.BoundTimeOut.INSTANCE, "Bound TimeOut");
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void boundCancel(String code) {
        XConnectFailType.UnBound unBound;
        Intrinsics.checkNotNullParameter(code, "code");
        if (Intrinsics.areEqual(code, DeviceConstant.NOISE_CANCELLATION_ADAPTIVE)) {
            unBound = XConnectFailType.PageTimeout.INSTANCE;
        } else {
            unBound = XConnectFailType.UnBound.INSTANCE;
        }
        connectFail(unBound, "Bound Cancel " + code);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void boundSuccess() {
        XBondConnector.Companion companion = XBondConnector.INSTANCE;
        XBluetoothDevice mBleDevice = getMBleDevice();
        companion.clearBondPageTimeoutCooldown(mBleDevice != null ? mBleDevice.getRealAddress() : null);
        XBondConnector.Companion companion2 = XBondConnector.INSTANCE;
        XBluetoothDevice mBleDevice2 = getMBleDevice();
        companion2.clearBondPageTimeoutCooldown(mBleDevice2 != null ? mBleDevice2.getDeviceAddress() : null);
        updateLastState$default(this, -1, null, 2, null);
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnector$boundSuccess$1, reason: invalid class name */
    /* JADX INFO: compiled from: XConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnector$boundSuccess$1", f = "XConnector.kt", i = {}, l = {320}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XConnector.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:11:0x002f  */
        /* JADX WARN: Code duplicated, block: B:13:0x003f  */
        /* JADX WARN: Code duplicated, block: B:14:0x0044  */
        /* JADX WARN: Code duplicated, block: B:17:0x004b  */
        /* JADX WARN: Code duplicated, block: B:19:0x005b  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v12, types: [int] */
        /* JADX WARN: Type inference failed for: r3v13 */
        /* JADX WARN: Type inference failed for: r3v8 */
        /* JADX WARN: Type inference failed for: r4v0 */
        /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r4v11 */
        /* JADX WARN: Type inference failed for: r4v12 */
        /* JADX WARN: Type inference failed for: r4v13 */
        /* JADX WARN: Type inference failed for: r4v15 */
        /* JADX WARN: Type inference failed for: r8v2, types: [com.nothing.log.Logger] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0063 -> B:23:0x0066). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x012d -> B:38:0x0130). Please report as a decompilation issue!!! */
        /*  JADX ERROR: StackOverflowError in pass: RegionMakerVisitor
            java.lang.StackOverflowError
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:731)
            	at jadx.core.utils.BlockUtils.traverseSuccessorsUntil(BlockUtils.java:749)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 453
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.nothing.link.bluetooth.sdk.connect.XConnector.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void connect$default(XConnector xConnector, Long l, Integer num, Long l2, Long l3, boolean z, boolean z2, boolean z3, int i, boolean z4, Function1 function1, Function1 function2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connect");
        }
        xConnector.connect((i2 & 1) != 0 ? 0L : l, (i2 & 2) != 0 ? 0 : num, (i2 & 4) != 0 ? 0L : l2, (i2 & 8) != 0 ? 0L : l3, (i2 & 16) != 0 ? true : z, (i2 & 32) != 0 ? true : z2, (i2 & 64) != 0 ? false : z3, (i2 & 128) != 0 ? 0 : i, (i2 & 256) != 0 ? true : z4, function1, (i2 & 1024) != 0 ? null : function2);
    }

    public void connect(Long connectMillisTimeOut, Integer connectRetryCount, Long connectRetryInterval, Long boundMillisTimeOut, boolean isForceConnectRelation, boolean isForceConnect, boolean isNeedScan, int profileType, boolean allowCreateBond, Function1<? super XConnectCallback, Unit> connectCallback, Function1<? super XBluetoothFlowCallBack, Unit> bluetoothFlowCallback) {
        long jLongValue;
        int iIntValue;
        long jLongValue2;
        Intrinsics.checkNotNullParameter(connectCallback, "connectCallback");
        setProfileType(profileType);
        setAllowCreateBond(allowCreateBond);
        long jLongValue3 = 0;
        if ((connectMillisTimeOut != null ? connectMillisTimeOut.longValue() : 0L) <= 0) {
            jLongValue = getMXBluetoothManager().getBluetoothConfig().getConnectMillisTimeOut();
        } else {
            jLongValue = connectMillisTimeOut != null ? connectMillisTimeOut.longValue() : 0L;
        }
        this.mConnectMillisTimeOut = jLongValue;
        if ((connectRetryCount != null ? connectRetryCount.intValue() : 0) <= 0) {
            iIntValue = getMXBluetoothManager().getBluetoothConfig().getConnectRetryCount();
        } else {
            iIntValue = connectRetryCount != null ? connectRetryCount.intValue() : 0;
        }
        this.mConnectRetryCount = iIntValue;
        if ((connectRetryInterval != null ? connectRetryInterval.longValue() : 0L) <= 0) {
            jLongValue2 = getMXBluetoothManager().getBluetoothConfig().getConnectRetryInterval();
        } else {
            jLongValue2 = connectRetryInterval != null ? connectRetryInterval.longValue() : 0L;
        }
        this.mConnectRetryInterval = jLongValue2;
        if ((boundMillisTimeOut != null ? boundMillisTimeOut.longValue() : 0L) <= 0) {
            jLongValue3 = getMXBluetoothManager().getBluetoothConfig().getBoundMillisTimeOut();
        } else if (boundMillisTimeOut != null) {
            jLongValue3 = boundMillisTimeOut.longValue();
        }
        setMBoundMillisTimeOut(jLongValue3);
        this.isForceConnectRelation = isForceConnectRelation;
        this.isForceConnect = isForceConnect;
        XConnectCallback xConnectCallback = new XConnectCallback();
        connectCallback.invoke(xConnectCallback);
        this.mXConnectCallback = xConnectCallback;
        this.mIsNeedScan.set(isNeedScan);
        if (bluetoothFlowCallback != null) {
            XBluetoothFlowCallBack xBluetoothFlowCallBack = new XBluetoothFlowCallBack();
            bluetoothFlowCallback.invoke(xBluetoothFlowCallBack);
            setMXBluetoothFlowCallBack(xBluetoothFlowCallBack);
        }
        XConnectCallback xConnectCallback2 = this.mXConnectCallback;
        if (xConnectCallback2 != null) {
            xConnectCallback2.callConnectStart();
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            if (!("connect entry".length() == 0)) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "connect entry " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "connect entry " + strComponent2);
                }
            }
        }
        XBondConnector.checkParameterAndStartConnectJob$default(this, false, getMXBluetoothFlowCallBack(), 1, null);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void checkParameterAndStartConnectJob(boolean isRetry, XBluetoothFlowCallBack flowCallBack) {
        Job job;
        if (checkIsConnecting() || this.createJob.get() || ((job = this.connectJob) != null && job.isActive())) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                XConnectType connectorType = getConnectorType();
                boolean z = this.createJob.get();
                Job job2 = this.connectJob;
                String str = connectorType + " createJob=" + z + ",connectJob=" + (job2 != null ? Boolean.valueOf(job2.isActive()) : null) + ",lastState=" + XConnectLastState.INSTANCE.getLastStateDesc(this.lastState.get()) + ",current already start.";
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
        addDeviceSateChange();
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = getConnectorType() + " check job start";
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
        this.createJob.set(true);
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass3(isRetry, this, flowCallBack, null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnector$checkParameterAndStartConnectJob$3, reason: invalid class name */
    /* JADX INFO: compiled from: XConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnector$checkParameterAndStartConnectJob$3", f = "XConnector.kt", i = {}, l = {423, 427, 432, GrpcUtil.DEFAULT_PORT_SSL}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ XBluetoothFlowCallBack $flowCallBack;
        final /* synthetic */ boolean $isRetry;
        int label;
        final /* synthetic */ XConnector this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(boolean z, XConnector xConnector, XBluetoothFlowCallBack xBluetoothFlowCallBack, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$isRetry = z;
            this.this$0 = xConnector;
            this.$flowCallBack = xBluetoothFlowCallBack;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$isRetry, this.this$0, this.$flowCallBack, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:21:0x006b  */
        /* JADX WARN: Code duplicated, block: B:35:0x0131 A[PHI: r2 r20
          0x0131: PHI (r2v16 java.lang.Object) = (r2v7 java.lang.Object), (r2v50 java.lang.Object) binds: [B:33:0x012d, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]
          0x0131: PHI (r20v5 int) = (r20v1 int), (r20v6 int) binds: [B:33:0x012d, B:12:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:37:0x0139  */
        /* JADX WARN: Code duplicated, block: B:39:0x0145  */
        /* JADX WARN: Code duplicated, block: B:42:0x0156 A[PHI: r2
          0x0156: PHI (r2v21 java.lang.Object) = (r2v20 java.lang.Object), (r2v51 java.lang.Object) binds: [B:40:0x0152, B:11:0x0029] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:44:0x015e  */
        /* JADX WARN: Code duplicated, block: B:47:0x017e  */
        /* JADX WARN: Code duplicated, block: B:49:0x019a  */
        /* JADX WARN: Code duplicated, block: B:54:0x01e8  */
        /* JADX WARN: Code duplicated, block: B:57:0x0219  */
        /* JADX WARN: Code duplicated, block: B:60:0x0230  */
        /* JADX WARN: Code duplicated, block: B:62:0x023a  */
        /* JADX WARN: Code duplicated, block: B:63:0x023f  */
        /* JADX WARN: Code duplicated, block: B:66:0x0246  */
        /* JADX WARN: Code duplicated, block: B:67:0x024b  */
        /* JADX WARN: Code duplicated, block: B:70:0x0276  */
        /* JADX WARN: Code duplicated, block: B:75:0x02c4  */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r22.this$0.mConnectRetryInterval, r22) == r1) goto L78;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x030c, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r22.this$0.mOperationInterval, r22) == r1) goto L78;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Object objCheckParameters$default;
            Object objIsConnected$default;
            Logger logger;
            XConnector xConnector;
            String tag;
            int depth;
            XBluetoothDevice mBleDevice;
            String deviceAddress;
            XBluetoothDevice mBleDevice2;
            String realAddress;
            String str;
            String str2;
            String strComponent1;
            String strComponent2;
            Logger logger2;
            XConnector xConnector2;
            String tag2;
            int depth2;
            String str3;
            String str4;
            String strComponent3;
            String strComponent4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (this.$isRetry) {
                    this.label = 1;
                } else {
                    i = 1;
                    this.label = 2;
                    objCheckParameters$default = XBondConnector.checkParameters$default(this.this$0, this.$flowCallBack, false, this, 2, null);
                    if (objCheckParameters$default != coroutine_suspended) {
                        if (!((Boolean) objCheckParameters$default).booleanValue()) {
                            this.this$0.getCreateJob().set(false);
                            return Unit.INSTANCE;
                        }
                        this.label = 3;
                        objIsConnected$default = XConnector.isConnected$default(this.this$0, false, this, i, null);
                        if (objIsConnected$default != coroutine_suspended) {
                            if (((Boolean) objIsConnected$default).booleanValue()) {
                                this.this$0.getCreateJob().set(false);
                                logger2 = Logger.INSTANCE;
                                xConnector2 = this.this$0;
                                tag2 = logger2.getTAG();
                                depth2 = logger2.getDepth();
                                if (logger2.isCanLogger(true)) {
                                    str3 = xConnector2.getConnectorType() + "  current is Connected !";
                                    str4 = str3;
                                    if (str4 != null) {
                                        Pair<String, String> trace = logger2.getTrace(depth2);
                                        strComponent3 = trace.component1();
                                        strComponent4 = trace.component2();
                                        FileLog fileLog = FileLog.INSTANCE;
                                        String str5 = logger2.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                                        FileLog.print$default(fileLog, 4, str5, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                        if (logger2.isDebug()) {
                                            Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                        }
                                    }
                                }
                                XConnector.updateLastState$default(this.this$0, 2, null, 2, null);
                                return Unit.INSTANCE;
                            }
                            logger = Logger.INSTANCE;
                            xConnector = this.this$0;
                            tag = logger.getTAG();
                            depth = logger.getDepth();
                            if (logger.isCanLogger(true)) {
                                XConnectType connectorType = xConnector.getConnectorType();
                                mBleDevice = xConnector.getMBleDevice();
                                if (mBleDevice != null) {
                                    deviceAddress = mBleDevice.getDeviceAddress();
                                } else {
                                    deviceAddress = null;
                                }
                                mBleDevice2 = xConnector.getMBleDevice();
                                if (mBleDevice2 != null) {
                                    realAddress = mBleDevice2.getRealAddress();
                                } else {
                                    realAddress = null;
                                }
                                str = connectorType + StringUtils.SPACE + deviceAddress + "/" + realAddress + " try connect!";
                                str2 = str;
                                if (str2 != null) {
                                    Pair<String, String> trace2 = logger.getTrace(depth);
                                    strComponent1 = trace2.component1();
                                    strComponent2 = trace2.component2();
                                    FileLog fileLog2 = FileLog.INSTANCE;
                                    String str6 = logger.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                    FileLog.print$default(fileLog2, 3, str6, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                    if (logger.isDebug()) {
                                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                    }
                                }
                            }
                            XConnector.updateLastState$default(this.this$0, -1, null, 2, null);
                            this.this$0.getIsActiveDisconnect().set(false);
                            this.label = 4;
                        }
                    }
                }
                return coroutine_suspended;
            }
            if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 == 2) {
                    ResultKt.throwOnFailure(obj);
                    objCheckParameters$default = obj;
                    i = 1;
                    if (!((Boolean) objCheckParameters$default).booleanValue()) {
                        this.this$0.getCreateJob().set(false);
                        return Unit.INSTANCE;
                    }
                    this.label = 3;
                    objIsConnected$default = XConnector.isConnected$default(this.this$0, false, this, i, null);
                    if (objIsConnected$default != coroutine_suspended) {
                        if (((Boolean) objIsConnected$default).booleanValue()) {
                            this.this$0.getCreateJob().set(false);
                            logger2 = Logger.INSTANCE;
                            xConnector2 = this.this$0;
                            tag2 = logger2.getTAG();
                            depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(true)) {
                                str3 = xConnector2.getConnectorType() + "  current is Connected !";
                                str4 = str3;
                                if (str4 != null) {
                                    Pair<String, String> trace3 = logger2.getTrace(depth2);
                                    strComponent3 = trace3.component1();
                                    strComponent4 = trace3.component2();
                                    FileLog fileLog3 = FileLog.INSTANCE;
                                    String str7 = logger2.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                    FileLog.print$default(fileLog3, 4, str7, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                    if (logger2.isDebug()) {
                                        Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                    }
                                }
                            }
                            XConnector.updateLastState$default(this.this$0, 2, null, 2, null);
                            return Unit.INSTANCE;
                        }
                        logger = Logger.INSTANCE;
                        xConnector = this.this$0;
                        tag = logger.getTAG();
                        depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            XConnectType connectorType2 = xConnector.getConnectorType();
                            mBleDevice = xConnector.getMBleDevice();
                            if (mBleDevice != null) {
                                deviceAddress = mBleDevice.getDeviceAddress();
                            } else {
                                deviceAddress = null;
                            }
                            mBleDevice2 = xConnector.getMBleDevice();
                            if (mBleDevice2 != null) {
                                realAddress = mBleDevice2.getRealAddress();
                            } else {
                                realAddress = null;
                            }
                            str = connectorType2 + StringUtils.SPACE + deviceAddress + "/" + realAddress + " try connect!";
                            str2 = str;
                            if (str2 != null) {
                                Pair<String, String> trace4 = logger.getTrace(depth);
                                strComponent1 = trace4.component1();
                                strComponent2 = trace4.component2();
                                FileLog fileLog4 = FileLog.INSTANCE;
                                String str8 = logger.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                                FileLog.print$default(fileLog4, 3, str8, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                                if (logger.isDebug()) {
                                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                                }
                            }
                        }
                        XConnector.updateLastState$default(this.this$0, -1, null, 2, null);
                        this.this$0.getIsActiveDisconnect().set(false);
                        this.label = 4;
                    }
                    return coroutine_suspended;
                }
                if (i2 == 3) {
                    ResultKt.throwOnFailure(obj);
                    objIsConnected$default = obj;
                    if (((Boolean) objIsConnected$default).booleanValue()) {
                        this.this$0.getCreateJob().set(false);
                        logger2 = Logger.INSTANCE;
                        xConnector2 = this.this$0;
                        tag2 = logger2.getTAG();
                        depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true)) {
                            str3 = xConnector2.getConnectorType() + "  current is Connected !";
                            str4 = str3;
                            if (str4 != null && str4.length() != 0) {
                                Pair<String, String> trace5 = logger2.getTrace(depth2);
                                strComponent3 = trace5.component1();
                                strComponent4 = trace5.component2();
                                FileLog fileLog5 = FileLog.INSTANCE;
                                String str9 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                FileLog.print$default(fileLog5, 4, str9, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                }
                            }
                        }
                        XConnector.updateLastState$default(this.this$0, 2, null, 2, null);
                        return Unit.INSTANCE;
                    }
                    logger = Logger.INSTANCE;
                    xConnector = this.this$0;
                    tag = logger.getTAG();
                    depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        XConnectType connectorType3 = xConnector.getConnectorType();
                        mBleDevice = xConnector.getMBleDevice();
                        if (mBleDevice != null) {
                            deviceAddress = mBleDevice.getDeviceAddress();
                        } else {
                            deviceAddress = null;
                        }
                        mBleDevice2 = xConnector.getMBleDevice();
                        if (mBleDevice2 != null) {
                            realAddress = mBleDevice2.getRealAddress();
                        } else {
                            realAddress = null;
                        }
                        str = connectorType3 + StringUtils.SPACE + deviceAddress + "/" + realAddress + " try connect!";
                        str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            Pair<String, String> trace6 = logger.getTrace(depth);
                            strComponent1 = trace6.component1();
                            strComponent2 = trace6.component2();
                            FileLog fileLog6 = FileLog.INSTANCE;
                            String str10 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                            FileLog.print$default(fileLog6, 3, str10, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    XConnector.updateLastState$default(this.this$0, -1, null, 2, null);
                    this.this$0.getIsActiveDisconnect().set(false);
                    this.label = 4;
                } else {
                    if (i2 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            }
            XConnector xConnector3 = this.this$0;
            xConnector3.setConnectJob(BuildersKt__Builders_commonKt.launch$default(xConnector3.connectScope(), null, null, new AnonymousClass4(this.this$0, null), 3, null));
            Job connectJob = this.this$0.getConnectJob();
            if (connectJob != null) {
                final XConnector xConnector4 = this.this$0;
                connectJob.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.XConnector.checkParameterAndStartConnectJob.3.5
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
                        xConnector4.getCreateJob().set(false);
                        xConnector4.onCompletion(th);
                    }
                });
            }
            return Unit.INSTANCE;
            Logger logger3 = Logger.INSTANCE;
            XConnector xConnector5 = this.this$0;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str11 = xConnector5.getConnectorType() + " retry connect, waitConnectJob!";
                String str12 = str11;
                if (str12 == null || str12.length() == 0) {
                    i = 1;
                } else {
                    Pair<String, String> trace7 = logger3.getTrace(depth3);
                    String strComponent5 = trace7.component1();
                    String strComponent6 = trace7.component2();
                    FileLog fileLog7 = FileLog.INSTANCE;
                    i = 1;
                    String str13 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                    FileLog.print$default(fileLog7, 3, str13, tag3, str11 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str11 + StringUtils.SPACE + strComponent6);
                    }
                }
            } else {
                i = 1;
            }
            this.this$0.currentConnectRetryCount++;
            this.label = 2;
            objCheckParameters$default = XBondConnector.checkParameters$default(this.this$0, this.$flowCallBack, false, this, 2, null);
            if (objCheckParameters$default != coroutine_suspended) {
                if (!((Boolean) objCheckParameters$default).booleanValue()) {
                    this.this$0.getCreateJob().set(false);
                    return Unit.INSTANCE;
                }
                this.label = 3;
                objIsConnected$default = XConnector.isConnected$default(this.this$0, false, this, i, null);
                if (objIsConnected$default != coroutine_suspended) {
                    if (((Boolean) objIsConnected$default).booleanValue()) {
                        this.this$0.getCreateJob().set(false);
                        logger2 = Logger.INSTANCE;
                        xConnector2 = this.this$0;
                        tag2 = logger2.getTAG();
                        depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true)) {
                            str3 = xConnector2.getConnectorType() + "  current is Connected !";
                            str4 = str3;
                            if (str4 != null) {
                                Pair<String, String> trace8 = logger2.getTrace(depth2);
                                strComponent3 = trace8.component1();
                                strComponent4 = trace8.component2();
                                FileLog fileLog8 = FileLog.INSTANCE;
                                String str14 = logger2.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                                FileLog.print$default(fileLog8, 4, str14, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                                if (logger2.isDebug()) {
                                    Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                                }
                            }
                        }
                        XConnector.updateLastState$default(this.this$0, 2, null, 2, null);
                        return Unit.INSTANCE;
                    }
                    logger = Logger.INSTANCE;
                    xConnector = this.this$0;
                    tag = logger.getTAG();
                    depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        XConnectType connectorType4 = xConnector.getConnectorType();
                        mBleDevice = xConnector.getMBleDevice();
                        if (mBleDevice != null) {
                            deviceAddress = mBleDevice.getDeviceAddress();
                        } else {
                            deviceAddress = null;
                        }
                        mBleDevice2 = xConnector.getMBleDevice();
                        if (mBleDevice2 != null) {
                            realAddress = mBleDevice2.getRealAddress();
                        } else {
                            realAddress = null;
                        }
                        str = connectorType4 + StringUtils.SPACE + deviceAddress + "/" + realAddress + " try connect!";
                        str2 = str;
                        if (str2 != null) {
                            Pair<String, String> trace9 = logger.getTrace(depth);
                            strComponent1 = trace9.component1();
                            strComponent2 = trace9.component2();
                            FileLog fileLog9 = FileLog.INSTANCE;
                            String str15 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                            FileLog.print$default(fileLog9, 3, str15, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    XConnector.updateLastState$default(this.this$0, -1, null, 2, null);
                    this.this$0.getIsActiveDisconnect().set(false);
                    this.label = 4;
                }
            }
            return coroutine_suspended;
        }

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnector$checkParameterAndStartConnectJob$3$4, reason: invalid class name */
        /* JADX INFO: compiled from: XConnector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnector$checkParameterAndStartConnectJob$3$4", f = "XConnector.kt", i = {}, l = {445}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ XConnector this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass4(XConnector xConnector, Continuation<? super AnonymousClass4> continuation) {
                super(2, continuation);
                this.this$0 = xConnector;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass4(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.XConnector$checkParameterAndStartConnectJob$3$4$1, reason: invalid class name */
            /* JADX INFO: compiled from: XConnector.kt */
            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
            @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.XConnector$checkParameterAndStartConnectJob$3$4$1", f = "XConnector.kt", i = {}, l = {447, 458}, m = "invokeSuspend", n = {}, s = {})
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                int label;
                final /* synthetic */ XConnector this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(XConnector xConnector, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = xConnector;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.this$0, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Code restructure failed: missing block: B:43:0x01cd, code lost:
                
                    if (r2.connectInternal(r2.getMBleDevice(), r17) == r1) goto L44;
                 */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object obj) {
                    Object objIsConnected$default;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        objIsConnected$default = XConnector.isConnected$default(this.this$0, false, this, 1, null);
                        if (objIsConnected$default != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    }
                    if (i == 1) {
                        ResultKt.throwOnFailure(obj);
                        objIsConnected$default = obj;
                    } else {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return Unit.INSTANCE;
                    if (((Boolean) objIsConnected$default).booleanValue()) {
                        Logger logger = Logger.INSTANCE;
                        XConnector xConnector = this.this$0;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = xConnector.getConnectorType() + "  current is Connected !";
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
                        XConnector.updateLastState$default(this.this$0, 2, null, 2, null);
                        return Unit.INSTANCE;
                    }
                    this.this$0.getCreateJob().set(false);
                    Logger logger2 = Logger.INSTANCE;
                    XConnector xConnector2 = this.this$0;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        XBluetoothDevice mBleDevice = xConnector2.getMBleDevice();
                        String str4 = (mBleDevice != null ? mBleDevice.getRealAddress() : null) + " start(" + (xConnector2.currentConnectRetryCount + 1) + ") connectInternal!";
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
                    this.this$0.clearTaskQueue();
                    XConnector xConnector3 = this.this$0;
                    this.label = 2;
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    if (TimeoutKt.withTimeout(this.this$0.getMConnectMillisTimeOut(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
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
    }

    public final Object disconnect(Continuation<? super Boolean> continuation) {
        Job boundJob;
        this.isActiveDisconnect.set(true);
        if (this.lastState.get() == 1 || this.lastState.get() == 5) {
            ActiveDisConnectedException activeDisConnectedException = new ActiveDisConnectedException("disconnect when connecting!");
            Job job = this.connectJob;
            if (job != null && job.isActive()) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    XBluetoothDevice mBleDevice = getMBleDevice();
                    String str = (mBleDevice != null ? mBleDevice.getDeviceAddress() : null) + " ,disconnect when connecting!";
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
                Job job2 = this.connectJob;
                if (job2 != null) {
                    job2.cancel((CancellationException) activeDisConnectedException);
                }
            } else {
                updateLastState$default(this, 0, null, 2, null);
            }
            Job boundJob2 = getBoundJob();
            if (boundJob2 != null && boundJob2.isActive() && (boundJob = getBoundJob()) != null) {
                boundJob.cancel((CancellationException) activeDisConnectedException);
            }
        } else {
            updateLastState$default(this, 0, null, 2, null);
        }
        return Boxing.boxBoolean(true);
    }

    public final void stopConnect() {
        if (this.lastState.get() == -1 || this.lastState.get() == 1 || this.lastState.get() == 5) {
            ActiveStopConnectedException activeStopConnectedException = new ActiveStopConnectedException("Cancel/stop connection during connection");
            Job job = this.connectJob;
            if (job != null) {
                job.cancel((CancellationException) activeStopConnectedException);
            }
            Job boundJob = getBoundJob();
            if (boundJob != null) {
                boundJob.cancel((CancellationException) activeStopConnectedException);
                return;
            }
            return;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "During the non-connection process, canceling/stopping the connection has no effect.".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 4, str, tag, "During the non-connection process, canceling/stopping the connection has no effect. " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "During the non-connection process, canceling/stopping the connection has no effect. " + strComponent2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCompletion(Throwable throwable) {
        if (isRetryConnect(throwable)) {
            updateLastState$default(this, -1, null, 2, null);
            checkParameterAndStartConnectJob(true, getMXBluetoothFlowCallBack());
            return;
        }
        if (throwable instanceof TimeoutCancellationException) {
            connectFail(XConnectFailType.ConnectTimeOut.INSTANCE, "Timeout " + (this.mConnectMillisTimeOut * ((long) (this.mConnectRetryCount + 1))) + " ms");
            return;
        }
        if (throwable instanceof CompleteException) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = getConnectorType() + " connectComplete " + ((CompleteException) throwable).getMessage() + StringUtils.SPACE;
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
            connectSuccess();
            return;
        }
        if (throwable instanceof ActiveDisConnectedException) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String message = ((ActiveDisConnectedException) throwable).getMessage();
                XBluetoothDevice mBleDevice = getMBleDevice();
                String str4 = "ActiveDisConnectedException ,reason:" + message + " ,device:" + (mBleDevice != null ? mBleDevice.getDeviceAddress() : null) + StringUtils.SPACE;
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
                FileLog.print$default(fileLog2, 6, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.e(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    return;
                }
                return;
            }
            return;
        }
        if (throwable instanceof ActiveStopConnectedException) {
            connectFail(new XConnectFailType.ConnectException(throwable), "ActiveStopConnected " + ((ActiveStopConnectedException) throwable).getMessage());
        } else if (throwable instanceof UnPairedException) {
            connectFail(XConnectFailType.UnBound.INSTANCE, "UnPairedException " + ((UnPairedException) throwable).getMessage());
        } else {
            connectFail(new XConnectFailType.ConnectException(new UnConnectedException("Unknown " + (throwable != null ? throwable.getMessage() : null))), "Error " + (throwable != null ? throwable.getMessage() : null));
        }
    }

    public void connectFail(XConnectFailType failType, String reason) {
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
        updateLastState(4, failType);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void checkFail(XConnectFailType failType, String reason) {
        Intrinsics.checkNotNullParameter(failType, "failType");
        Intrinsics.checkNotNullParameter(reason, "reason");
        connectFail(failType, reason);
    }

    public void cancelJobWhenConnected(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        CompleteException completeException = new CompleteException(tag);
        Job job = this.connectJob;
        if (job != null && job.isActive()) {
            Job job2 = this.connectJob;
            if (job2 != null) {
                job2.cancel((CancellationException) completeException);
                return;
            }
            return;
        }
        updateLastState$default(this, 2, null, 2, null);
    }

    public boolean cancelJobWhenConnectedFailed(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Job job = this.connectJob;
        if (job == null || !job.isActive()) {
            return false;
        }
        Job job2 = this.connectJob;
        if (job2 != null) {
            job2.cancel(new CancellationException(tag));
        }
        return true;
    }

    private final void connectSuccess() {
        this.currentConnectRetryCount = 0;
        updateLastState$default(this, 2, null, 2, null);
    }

    private final boolean isRetryConnect(Throwable throwable) {
        if (!(throwable instanceof ActiveDisConnectedException) && !(throwable instanceof CompleteException) && !(throwable instanceof ActiveStopConnectedException) && !this.isActiveDisconnect.get() && this.lastState.get() != 2) {
            closeLast();
            int i = this.mConnectRetryCount;
            if (i > 0 && this.currentConnectRetryCount < i) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    XBluetoothDevice mBleDevice = getMBleDevice();
                    String str = (mBleDevice != null ? mBleDevice.getDeviceAddress() : null) + " -> try connect again,the " + (this.currentConnectRetryCount + 1) + " times";
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
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0176  */
    public final void receiveCallbackCommand(XTaskList taskList, final XCommand item, final Function2<? super XTask, ? super XCommand, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(taskList, "taskList");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        byte[] data = item.getData();
        printReceiverLog(item.getCommand(), data);
        ConcurrentLinkedQueue<XTask> concurrentLinkedQueueListAllWait = taskList.listAllWait();
        Iterator<XTask> it = concurrentLinkedQueueListAllWait.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        XTask xTaskFirstOrNull = taskList.firstOrNull(new Function1<XTask, Boolean>() { // from class: com.nothing.link.bluetooth.sdk.connect.XConnector$receiveCallbackCommand$runTask$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Code duplicated, block: B:9:0x0024  */
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(XTask it2) {
                boolean z;
                Intrinsics.checkNotNullParameter(it2, "it");
                if (predicate.invoke(it2, item).booleanValue()) {
                    z = true;
                    if (it2.currentStatus() != 1 && it2.currentStatus() != 3) {
                        z = false;
                    }
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        });
        while (true) {
            if (it.hasNext()) {
                XTask next = it.next();
                Intrinsics.checkNotNull(next);
                if (predicate.invoke(next, item).booleanValue() && next.currentStatus() == 3) {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = getConnectorType() + " find task " + next;
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
                    next.setSuccess();
                    Job job = next.getTaskJob();
                    if (job != null) {
                        job.cancel((CancellationException) new CompleteException(getConnectorType() + " task done"));
                    }
                    taskList.remove(next);
                    XWriteCallback writeCallback = next.getWriteCallback();
                    if (writeCallback == null) {
                        break;
                    }
                    writeCallback.callWriteSuccess(getMBleDevice(), next.getCurrentPackage(), next.getTotalPackage(), data);
                    break;
                }
            } else {
                Logger logger2 = Logger.INSTANCE;
                boolean zCanWrite = XBluetoothManager.INSTANCE.get().canWrite(item.getData());
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                String str4 = "),";
                if (logger2.isCanLogger(zCanWrite)) {
                    String str5 = getConnectorType() + " can't find wait task,listWait(" + concurrentLinkedQueueListAllWait.size() + ")," + item + " ,runTask:" + xTaskFirstOrNull + StringUtils.SPACE;
                    String str6 = str5;
                    if (str6 == null || str6.length() == 0) {
                        str4 = "),";
                    } else {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        if (zCanWrite) {
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str7 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                            FileLog.print$default(fileLog2, 3, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                        }
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                        }
                    }
                } else {
                    str4 = "),";
                }
                if (xTaskFirstOrNull == null) {
                    break;
                }
                Logger logger3 = Logger.INSTANCE;
                String tag3 = logger3.getTAG();
                int depth3 = logger3.getDepth();
                if (logger3.isCanLogger(true)) {
                    String str8 = getConnectorType() + " find task in list,listWait(" + xTaskFirstOrNull.getStatusDesc(xTaskFirstOrNull.currentStatus()) + str4 + xTaskFirstOrNull + StringUtils.SPACE;
                    String str9 = str8;
                    if (str9 != null && str9.length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str10 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                        FileLog.print$default(fileLog3, 3, str10, tag3, str8 + StringUtils.SPACE + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, str8 + StringUtils.SPACE + strComponent6);
                        }
                    }
                }
                boolean z = xTaskFirstOrNull.currentStatus() == 1 || xTaskFirstOrNull.currentStatus() == 3;
                xTaskFirstOrNull.setSuccess();
                taskList.remove(xTaskFirstOrNull);
                if (z) {
                    Job job2 = xTaskFirstOrNull.getTaskJob();
                    if (job2 != null) {
                        job2.cancel((CancellationException) new NextException(getConnectorType() + " task in ready,auto run next!"));
                    }
                } else {
                    Job job3 = xTaskFirstOrNull.getTaskJob();
                    if (job3 != null) {
                        job3.cancel((CancellationException) new CompleteException(getConnectorType() + " task done"));
                    }
                }
                XWriteCallback writeCallback2 = xTaskFirstOrNull.getWriteCallback();
                if (writeCallback2 == null) {
                    break;
                }
                writeCallback2.callWriteSuccess(getMBleDevice(), xTaskFirstOrNull.getCurrentPackage(), xTaskFirstOrNull.getTotalPackage(), data);
                break;
            }
        }
        Iterator<Map.Entry<String, Function1<XCommand, Unit>>> it2 = this.receiveCallbacks.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().invoke(item);
        }
    }

    public static /* synthetic */ Object isConnected$default(XConnector xConnector, boolean z, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isConnected");
        }
        if ((i & 1) != 0) {
            z = true;
        }
        return xConnector.isConnected(z, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object writeWithTask$default(XConnector xConnector, byte[] bArr, long j, long j2, boolean z, boolean z2, boolean z3, String str, String str2, byte[] bArr2, AtomicInteger atomicInteger, boolean z4, String str3, ArrayList arrayList, Continuation continuation, int i, Object obj) {
        if (obj == null) {
            return xConnector.writeWithTask(bArr, (i & 2) != 0 ? -1L : j, (i & 4) != 0 ? -1L : j2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? true : z3, (i & 64) != 0 ? "" : str, (i & 128) != 0 ? "" : str2, (i & 256) != 0 ? null : bArr2, (i & 512) != 0 ? null : atomicInteger, (i & 1024) != 0 ? false : z4, (i & 2048) != 0 ? null : str3, (ArrayList<String>) ((i & 4096) != 0 ? null : arrayList), (Continuation<? super byte[]>) continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeWithTask");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void writeWithTask$default(XConnector xConnector, byte[] bArr, long j, long j2, boolean z, boolean z2, boolean z3, String str, String str2, byte[] bArr2, AtomicInteger atomicInteger, boolean z4, String str3, ArrayList arrayList, Function1 function1, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: writeWithTask");
        }
        xConnector.writeWithTask(bArr, (i & 2) != 0 ? -1L : j, (i & 4) != 0 ? -1L : j2, (i & 8) != 0 ? true : z, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? true : z3, (i & 64) != 0 ? "" : str, (i & 128) != 0 ? "" : str2, (i & 256) != 0 ? null : bArr2, (i & 512) != 0 ? null : atomicInteger, (i & 1024) != 0 ? false : z4, (i & 2048) != 0 ? null : str3, (ArrayList<String>) ((i & 4096) != 0 ? null : arrayList), (Function1<? super XWriteCallback, Unit>) function1);
    }
}
