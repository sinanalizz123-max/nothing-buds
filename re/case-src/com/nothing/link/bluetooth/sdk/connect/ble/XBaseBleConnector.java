package com.nothing.link.bluetooth.sdk.connect.ble;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.google.mlkit.common.MlKitException;
import com.nothing.cardtransform.key.ViewKey;
import com.nothing.caseble.NtPeerLinkBleUuids;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.config.Constants;
import com.nothing.link.bluetooth.sdk.connect.ActiveDisConnectedException;
import com.nothing.link.bluetooth.sdk.connect.CancelException;
import com.nothing.link.bluetooth.sdk.connect.CompleteException;
import com.nothing.link.bluetooth.sdk.connect.GetWriteCharacteristicException;
import com.nothing.link.bluetooth.sdk.connect.NoBlePermissionException;
import com.nothing.link.bluetooth.sdk.connect.UnConnectedException;
import com.nothing.link.bluetooth.sdk.connect.UnDefinedException;
import com.nothing.link.bluetooth.sdk.connect.UnPairedException;
import com.nothing.link.bluetooth.sdk.connect.XBondConnector;
import com.nothing.link.bluetooth.sdk.connect.XConnectCallback;
import com.nothing.link.bluetooth.sdk.connect.XConnectFailType;
import com.nothing.link.bluetooth.sdk.connect.XConnectType;
import com.nothing.link.bluetooth.sdk.connect.XConnector;
import com.nothing.link.bluetooth.sdk.connect.bt.XBTConnector;
import com.nothing.link.bluetooth.sdk.connect.tranform.XByteArrayParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XCommand;
import com.nothing.link.bluetooth.sdk.connect.tranform.XDefaultParser;
import com.nothing.link.bluetooth.sdk.connect.tranform.XWriteCallback;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.scan.XBluetoothFlowCallBack;
import com.nothing.link.bluetooth.sdk.scan.XScan;
import com.nothing.link.bluetooth.sdk.scan.XScanCallback;
import com.nothing.link.bluetooth.sdk.scan.XScanFailType;
import com.nothing.link.bluetooth.sdk.scan.XScanType;
import com.nothing.link.bluetooth.sdk.task.XCommonTask;
import com.nothing.link.bluetooth.sdk.task.XCommonTaskCallback;
import com.nothing.link.bluetooth.sdk.task.XCommonTaskQueue;
import com.nothing.link.bluetooth.sdk.task.XTask;
import com.nothing.link.bluetooth.sdk.task.XTaskList;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
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
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.parser.external.ExternalParsersConfigReaderMetKeys;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBaseBleConnector.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u00f2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0012\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010@\u001a\u00020'H\u0003J7\u0010A\u001a\u00020'2\u0006\u00109\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010B\u001a\u00020C2\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020'0E\u00a2\u0006\u0002\bGJ\u0018\u0010H\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0003J\b\u0010I\u001a\u00020'H\u0016J\b\u0010J\u001a\u00020'H\u0016J\u0018\u0010K\u001a\u00020'2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u0006H\u0016J\u001b\u0010O\u001a\u00020'2\b\u0010P\u001a\u0004\u0018\u00010QH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020'H\u0016J\u0014\u0010V\u001a\u0004\u0018\u00010\u000b2\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\b\u0010W\u001a\u00020'H\u0016J\b\u0010X\u001a\u00020'H\u0003J?\u0010Y\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\t2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\\\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010]J_\u0010^\u001a\u00020'2\u0006\u00109\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\t2\u0006\u0010B\u001a\u00020C2\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020'0E\u00a2\u0006\u0002\bG2\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\\\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\b\u0010_\u001a\u00020\"H\u0016J\b\u0010`\u001a\u00020aH\u0016J\u001a\u0010b\u001a\u0004\u0018\u00010c2\u0006\u00109\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0002J\u0010\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020cH\u0002J\u001a\u0010f\u001a\u0004\u0018\u00010c2\u0006\u00109\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u0006H\u0002J\u0010\u0010g\u001a\u00020\"2\u0006\u0010e\u001a\u00020cH\u0002J\u0006\u0010h\u001a\u00020\tJ\u0010\u0010i\u001a\u00020\t2\u0006\u0010e\u001a\u00020cH\u0002J\u0010\u0010j\u001a\u00020\t2\u0006\u0010e\u001a\u00020cH\u0002J\u0019\u0010k\u001a\u00020\t2\u0006\u0010l\u001a\u00020\tH\u0097@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010mJ\b\u0010n\u001a\u00020\tH\u0007J\u0006\u0010o\u001a\u00020\tJ\b\u0010p\u001a\u00020\tH\u0016J\u001a\u0010q\u001a\u00020'2\b\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010t\u001a\u00020\tH\u0016J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u0006J\u0018\u0010v\u001a\u00020\"2\u0006\u0010w\u001a\u00020x2\u0006\u0010Z\u001a\u00020\tH\u0002J\"\u0010y\u001a\u00020'2\b\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010z\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0016J+\u0010|\u001a\u00020'2\u0006\u0010N\u001a\u00020\u00062\n\b\u0002\u0010}\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010M\u00a2\u0006\u0002\u0010~J\u0010\u0010\u007f\u001a\u00020'2\u0006\u0010&\u001a\u00020\"H\u0016J,\u0010\u0080\u0001\u001a\u00020'2\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\u0006\u0010e\u001a\u00020c2\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\u0006\u0010&\u001a\u00020\"H\u0016J&\u0010\u0084\u0001\u001a\u00020'2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010e\u001a\u0004\u0018\u00010c2\u0006\u0010&\u001a\u00020\"H\u0016J%\u0010\u0085\u0001\u001a\u00020'2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\"H\u0017J,\u0010\u0087\u0001\u001a\u00020'2\u0007\u0010\u0081\u0001\u001a\u00020\u000b2\u0006\u0010w\u001a\u00020x2\u0006\u0010&\u001a\u00020\"2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J&\u0010\u0088\u0001\u001a\u00020'2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\b\u0010w\u001a\u0004\u0018\u00010x2\u0006\u0010&\u001a\u00020\"H\u0016J\t\u0010\u0089\u0001\u001a\u00020'H\u0016J\u0018\u0010\u008a\u0001\u001a\u00020'2\u0006\u0010&\u001a\u00020\"2\u0007\u0010\u0086\u0001\u001a\u00020\"J#\u0010\u008b\u0001\u001a\u00020'2\b\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010z\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0016J&\u0010\u008c\u0001\u001a\u00020'2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u0010e\u001a\u00020c2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u001b\u0010\u008d\u0001\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u008e\u0001J,\u0010\u008f\u0001\u001a\u00020'2\b\u0010r\u001a\u0004\u0018\u00010s2\u0007\u0010\u0090\u0001\u001a\u00020\t2\u0006\u0010z\u001a\u00020\t2\u0006\u0010{\u001a\u00020\tH\u0016J$\u0010\u0091\u0001\u001a\u00020'2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"H\u0016J%\u0010\u0092\u0001\u001a\u00020'2\t\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u000b2\u0007\u0010\u0093\u0001\u001a\u00020\"2\u0006\u0010&\u001a\u00020\"H\u0016J\u001a\u0010\u0094\u0001\u001a\u00020'2\u0007\u0010\u0095\u0001\u001a\u00020\t2\u0006\u0010&\u001a\u00020\"H\u0017J>\u0010\u0096\u0001\u001a\u00030\u0097\u00012\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00062\b\u0010\u0099\u0001\u001a\u00030\u0083\u00012\u001d\u0010\u009a\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u009b\u0001j\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u009c\u0001H&J\u0007\u0010\u009d\u0001\u001a\u00020'J\u0010\u0010\u009e\u0001\u001a\u00020\t2\u0007\u0010\u009f\u0001\u001a\u00020sJ\t\u0010\u00a0\u0001\u001a\u00020'H\u0003J \u00107\u001a\u0004\u0018\u00010Q2\n\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u00a2\u0001H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00a3\u0001J\u000e\u00109\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u0006J\u0010\u0010\u00a4\u0001\u001a\u00020\u00002\u0007\u0010\u00a5\u0001\u001a\u00020\tJ?\u0010\u00a6\u0001\u001a\u00020'26\u0010D\u001a2\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'0!J\u000e\u00106\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020\tJ@\u0010\u00a7\u0001\u001a\u00020\t2\b\u0010\u00a8\u0001\u001a\u00030\u0097\u00012\u0006\u00109\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\b\u0010\u00a9\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u00aa\u0001\u001a\u00020CH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00ab\u0001J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010u\u001a\u00020\u0006J\u00a8\u0001\u0010\u00ac\u0001\u001a\u0005\u0018\u00010\u0083\u00012\b\u0010\u0099\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u00aa\u0001\u001a\u00020C2\u0007\u0010\u00ad\u0001\u001a\u00020C2\u0007\u0010\u00ae\u0001\u001a\u00020\t2\u0007\u0010\u00af\u0001\u001a\u00020\t2\u0007\u0010\u00b0\u0001\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\n\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u0083\u00012\n\u0010\u00b2\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\u0007\u0010\u00b4\u0001\u001a\u00020\t2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00062\u001d\u0010\u009a\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u009b\u0001j\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u009c\u0001H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0003\u0010\u00b5\u0001J\u00b6\u0001\u0010\u00ac\u0001\u001a\u00020'2\b\u0010\u0099\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u00aa\u0001\u001a\u00020C2\u0007\u0010\u00ad\u0001\u001a\u00020C2\u0007\u0010\u00ae\u0001\u001a\u00020\t2\u0007\u0010\u00af\u0001\u001a\u00020\t2\u0007\u0010\u00b0\u0001\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00062\u0006\u0010=\u001a\u00020\u00062\n\u0010\u00b1\u0001\u001a\u0005\u0018\u00010\u0083\u00012\n\u0010\u00b2\u0001\u001a\u0005\u0018\u00010\u00b3\u00012\u0007\u0010\u00b4\u0001\u001a\u00020\t2\t\u0010\u0098\u0001\u001a\u0004\u0018\u00010\u00062\u001d\u0010\u009a\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u009b\u0001j\u000b\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u009c\u00012\u0019\u0010\u00b6\u0001\u001a\u0014\u0012\u0005\u0012\u00030\u00b7\u0001\u0012\u0004\u0012\u00020'0E\u00a2\u0006\u0002\bGH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR@\u0010 \u001a4\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\"\u00a2\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'\u0018\u00010!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010/\"\u0004\b6\u00101R\u000e\u00107\u001a\u000208X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010*\"\u0004\b;\u0010,R\u000e\u0010<\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010=\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010*\"\u0004\b?\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u00b8\u0001"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/ble/XBaseBleConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/XConnector;", "Lcom/nothing/link/bluetooth/sdk/connect/ble/BleGattCallback;", ExternalParsersConfigReaderMetKeys.PARSER_TAG, "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;", ViewKey.TAG, "", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XByteArrayParser;Ljava/lang/String;)V", "autoConnect", "", "bluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "commonTask", "Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskQueue;", "disconnectJob", "Lkotlinx/coroutines/Job;", "discoverJob", "entryDiscover", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executor", "Lcom/nothing/link/bluetooth/sdk/connect/ble/OrderedTaskExecutor;", "getExecutor", "()Lcom/nothing/link/bluetooth/sdk/connect/ble/OrderedTaskExecutor;", "setExecutor", "(Lcom/nothing/link/bluetooth/sdk/connect/ble/OrderedTaskExecutor;)V", "highConnectionPriorityApplied", "lastTime", "Ljava/util/concurrent/atomic/AtomicLong;", "getLastTime", "()Ljava/util/concurrent/atomic/AtomicLong;", "setLastTime", "(Ljava/util/concurrent/atomic/AtomicLong;)V", "mtuChangeCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "mtu", NotificationCompat.CATEGORY_STATUS, "", "notifyUUID", "getNotifyUUID", "()Ljava/lang/String;", "setNotifyUUID", "(Ljava/lang/String;)V", "openNotifyChannel", "getOpenNotifyChannel", "()Z", "setOpenNotifyChannel", "(Z)V", "proxyCallback", "Lcom/nothing/link/bluetooth/sdk/connect/ble/XProxyGattCallBack;", "requestHighConnectionPriority", "getRequestHighConnectionPriority", "setRequestHighConnectionPriority", "scan", "Lcom/nothing/link/bluetooth/sdk/scan/XScan;", "serviceUUID", "getServiceUUID", "setServiceUUID", "waitRelationConnector", "writeUUID", "getWriteUUID", "setWriteUUID", "applyHighConnectionPriorityIfNeeded", "checkCharacteristicNotifyWithTask", "interval", "", "callback", "Lkotlin/Function1;", "Lcom/nothing/link/bluetooth/sdk/task/XCommonTaskCallback;", "Lkotlin/ExtensionFunctionType;", "checkNotificationStatus", "clearTaskQueue", "closeLast", "connectFail", "failType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;", "reason", "connectInternal", "bleDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "(Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connectScope", "Lkotlinx/coroutines/CoroutineScope;", "connectTaskQueue", "createGatt", "disConnectInternal", "discoverService", "enableCharacteristicNotify", "enable", "uuidDescriptor", "isConnectFlow", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enableCharacteristicNotifyWithTask", "getConnectTotalStep", "getConnectorType", "Lcom/nothing/link/bluetooth/sdk/connect/XConnectType;", "getNotifyCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "getOperateType", "characteristic", "getWriteCharacteristic", "getWriteType", "isBtConnector", "isCanNotify", "isCanWrite", "isConnected", "isSystem", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isGattConnected", "isLeAudioConnector", "isNeedBound", "keyMissingChanged", "device", "Landroid/bluetooth/BluetoothDevice;", "connected", "uuid", "notifyWriteDescriptor", "descriptor", "Landroid/bluetooth/BluetoothGattDescriptor;", "onA2DPChange", "a2dpConnect", "headsetConnect", "onBleDisconnected", "state", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/nothing/link/bluetooth/sdk/connect/XConnectFailType;)V", "onBluetoothChange", "onCharacteristicRead", "gatt", "value", "", "onCharacteristicWrite", "onConnectionStateChange", "newState", "onDescriptorRead", "onDescriptorWrite", "onDestroy", "onDisconnected", "onHeadSetChange", "onIndicateCharacteristicChanged", "onInternalResult", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLeAudioChange", "leAudioConnect", "onMtuChanged", "onReadRemoteRssi", "rssi", "onServicesDiscoveredChange", "success", "parserWriterCommand", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;", "taskId", "dataArray", "resIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "refreshDeviceCache", "removeBond", "bluetoothDevice", "restoreConnectionPriorityIfNeeded", "flowCallBack", "Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;", "(Lcom/nothing/link/bluetooth/sdk/scan/XBluetoothFlowCallBack;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAutoOpenNotifyChannel", "autoOpen", "setDeviceMtuChangeCallback", "write", "command", "byteArray", "operateInterval", "(Lcom/nothing/link/bluetooth/sdk/connect/tranform/XCommand;Ljava/lang/String;Ljava/lang/String;[BJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeWithTask", "durationTimeMillis", "needUpdate", "ignoreFrame", "autoDoNextTask", "mockResponse", "retryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "successWithComplete", "([BJJZZZLjava/lang/String;Ljava/lang/String;[BLjava/util/concurrent/atomic/AtomicInteger;ZLjava/lang/String;Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeCallback", "Lcom/nothing/link/bluetooth/sdk/connect/tranform/XWriteCallback;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XBaseBleConnector extends XConnector implements BleGattCallback {
    private boolean autoConnect;
    private BluetoothGatt bluetoothGatt;
    private final XCommonTaskQueue commonTask;
    private Job disconnectJob;
    private Job discoverJob;
    private AtomicBoolean entryDiscover;
    private OrderedTaskExecutor executor;
    private boolean highConnectionPriorityApplied;
    private AtomicLong lastTime;
    private Function2<? super Integer, ? super Integer, Unit> mtuChangeCallback;
    private String notifyUUID;
    private boolean openNotifyChannel;
    private final XProxyGattCallBack proxyCallback;
    private boolean requestHighConnectionPriority;
    private final XScan scan;
    private String serviceUUID;
    private final AtomicBoolean waitRelationConnector;
    private String writeUUID;

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$connectInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector", f = "XBaseBleConnector.kt", i = {0}, l = {204, MlKitException.CODE_SCANNER_PIPELINE_INITIALIZATION_ERROR, 213}, m = "connectInternal$suspendImpl", n = {"$this"}, s = {"L$0"})
    static final class C08761 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C08761(Continuation<? super C08761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBaseBleConnector.connectInternal$suspendImpl(XBaseBleConnector.this, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$enableCharacteristicNotify$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector", f = "XBaseBleConnector.kt", i = {0, 0, 0, 0, 0, 0}, l = {892}, m = "enableCharacteristicNotify", n = {"this", "serviceUUID", "notifyUUID", "uuidDescriptor", "enable", "isConnectFlow"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1"})
    static final class C08781 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        C08781(Continuation<? super C08781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBaseBleConnector.this.enableCharacteristicNotify(null, null, false, null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$isConnected$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector", f = "XBaseBleConnector.kt", i = {0, 0}, l = {794}, m = "isConnected$suspendImpl", n = {"$this", "isSystem"}, s = {"L$0", "Z$0"})
    static final class C08801 extends ContinuationImpl {
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C08801(Continuation<? super C08801> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBaseBleConnector.isConnected$suspendImpl(XBaseBleConnector.this, false, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onInternalResult$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector", f = "XBaseBleConnector.kt", i = {0, 0}, l = {220, 244}, m = "onInternalResult", n = {"this", ViewKey.TAG}, s = {"L$0", "L$1"})
    static final class C08841 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C08841(Continuation<? super C08841> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBaseBleConnector.this.onInternalResult(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$writeWithTask$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector", f = "XBaseBleConnector.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {653, 656}, m = "writeWithTask$suspendImpl", n = {"$this", "dataArray", "serviceUUID", "writeUUID", "mockResponse", "retryCount", "taskId", "resIds", "operateInterval", "durationTimeMillis", "needUpdate", "ignoreFrame", "autoDoNextTask", "successWithComplete", "$this", "dataArray", "serviceUUID", "writeUUID", "mockResponse", "retryCount", "taskId", "resIds", "operateInterval", "durationTimeMillis", "needUpdate", "ignoreFrame", "autoDoNextTask", "successWithComplete"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "J$1", "Z$0", "Z$1", "Z$2", "Z$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "J$1", "Z$0", "Z$1", "Z$2", "Z$3"})
    static final class C08891 extends ContinuationImpl {
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        boolean Z$3;
        int label;
        /* synthetic */ Object result;

        C08891(Continuation<? super C08891> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBaseBleConnector.writeWithTask$suspendImpl(XBaseBleConnector.this, (byte[]) null, 0L, 0L, false, false, false, (String) null, (String) null, (byte[]) null, (AtomicInteger) null, false, (String) null, (ArrayList<String>) null, (Continuation<? super byte[]>) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public XBaseBleConnector() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public Object connectInternal(XBluetoothDevice xBluetoothDevice, Continuation<? super Unit> continuation) {
        return connectInternal$suspendImpl(this, xBluetoothDevice, continuation);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public int getConnectTotalStep() {
        return 6;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public Object isConnected(boolean z, Continuation<? super Boolean> continuation) {
        return isConnected$suspendImpl(this, z, continuation);
    }

    public final boolean isLeAudioConnector() {
        return false;
    }

    public abstract XCommand parserWriterCommand(String taskId, byte[] dataArray, ArrayList<String> resIds);

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public Object writeWithTask(byte[] bArr, long j, long j2, boolean z, boolean z2, boolean z3, String str, String str2, byte[] bArr2, AtomicInteger atomicInteger, boolean z4, String str3, ArrayList<String> arrayList, Continuation<? super byte[]> continuation) {
        return writeWithTask$suspendImpl(this, bArr, j, j2, z, z2, z3, str, str2, bArr2, atomicInteger, z4, str3, arrayList, continuation);
    }

    public /* synthetic */ XBaseBleConnector(XDefaultParser xDefaultParser, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new XDefaultParser() : xDefaultParser, (i & 2) != 0 ? "BleWriter" : str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XBaseBleConnector(XByteArrayParser parser, String tag) {
        super(parser, tag);
        Intrinsics.checkNotNullParameter(parser, "parser");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.proxyCallback = new XProxyGattCallBack(this);
        this.serviceUUID = NtPeerLinkBleUuids.SERVICE_UUID;
        this.writeUUID = "";
        this.notifyUUID = NtPeerLinkBleUuids.NOTIFY_UUID;
        this.entryDiscover = new AtomicBoolean(false);
        this.scan = XBluetoothManager.INSTANCE.get().getScan(XScanType.BLE.INSTANCE);
        this.waitRelationConnector = new AtomicBoolean(false);
        this.commonTask = new XCommonTaskQueue("commonBleTask");
        this.openNotifyChannel = true;
        this.executor = new OrderedTaskExecutor();
        this.lastTime = new AtomicLong(0L);
    }

    public final String getServiceUUID() {
        return this.serviceUUID;
    }

    public final void setServiceUUID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.serviceUUID = str;
    }

    public final String getWriteUUID() {
        return this.writeUUID;
    }

    public final void setWriteUUID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.writeUUID = str;
    }

    public final String getNotifyUUID() {
        return this.notifyUUID;
    }

    public final void setNotifyUUID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.notifyUUID = str;
    }

    public final boolean getOpenNotifyChannel() {
        return this.openNotifyChannel;
    }

    public final void setOpenNotifyChannel(boolean z) {
        this.openNotifyChannel = z;
    }

    public final boolean getRequestHighConnectionPriority() {
        return this.requestHighConnectionPriority;
    }

    /* JADX INFO: renamed from: setRequestHighConnectionPriority, reason: collision with other method in class */
    public final void m5806setRequestHighConnectionPriority(boolean z) {
        this.requestHighConnectionPriority = z;
    }

    public final XBaseBleConnector setRequestHighConnectionPriority(boolean enable) {
        this.requestHighConnectionPriority = enable;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String tag2 = getTag();
            XBluetoothDevice mBleDevice = getMBleDevice();
            String str = "[connPriority] setRequestHighConnectionPriority enable=" + enable + " tag=" + tag2 + " addr=" + (mBleDevice != null ? mBleDevice.getDeviceAddress() : null);
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
        return this;
    }

    public final XBaseBleConnector notifyUUID(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.notifyUUID = uuid;
        return this;
    }

    public final XBaseBleConnector serviceUUID(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.serviceUUID = uuid;
        return this;
    }

    public final XBaseBleConnector setAutoOpenNotifyChannel(boolean autoOpen) {
        this.openNotifyChannel = autoOpen;
        return this;
    }

    public final XBaseBleConnector writeUUID(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.writeUUID = uuid;
        return this;
    }

    public final boolean removeBond(BluetoothDevice bluetoothDevice) {
        Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
        try {
            Method method = bluetoothDevice.getClass().getMethod("removeBond", new Class[0]);
            method.setAccessible(true);
            return Intrinsics.areEqual(method.invoke(bluetoothDevice, new Object[0]), (Object) true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return false;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onBluetoothChange(int status) {
        super.onBluetoothChange(status);
        if (10 == status) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "bluetooth off callback disconnected".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 3, str, tag, "bluetooth off callback disconnected " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, "bluetooth off callback disconnected " + strComponent2);
                }
            }
            XConnector.updateLastState$default(this, 0, null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$disConnectInternal$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$disConnectInternal$1", f = "XBaseBleConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08771(Continuation<? super C08771> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new C08771(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08771) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            XBaseBleConnector.this.closeLast();
            boolean z = XBaseBleConnector.this.getIsActiveDisconnect().get();
            XConnectCallback mXConnectCallback = XBaseBleConnector.this.getMXConnectCallback();
            if (mXConnectCallback != null) {
                mXConnectCallback.callDisConnecting(z, XBaseBleConnector.this.getMBleDevice(), null, 0);
            }
            XConnectCallback mXConnectCallback2 = XBaseBleConnector.this.getMXConnectCallback();
            if (mXConnectCallback2 != null) {
                mXConnectCallback2.callDisConnected(z, XBaseBleConnector.this.getMBleDevice(), XBaseBleConnector.this.bluetoothGatt, XBaseBleConnector.this.getConnectorType().getType());
            }
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void disConnectInternal() {
        Job job = this.disconnectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.disconnectJob = BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C08771(null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006e, code lost:
    
        if (r1 == r3) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        if (r0.onInternalResult("relationConnector is connect!", r2) == r3) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0157, code lost:
    
        if (r0.onInternalResult("no relationConnector,direct connect!", r2) == r3) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object connectInternal$suspendImpl(XBaseBleConnector xBaseBleConnector, XBluetoothDevice xBluetoothDevice, Continuation<? super Unit> continuation) {
        C08761 c08761;
        XBaseBleConnector xBaseBleConnector2 = xBaseBleConnector;
        if (continuation instanceof C08761) {
            c08761 = (C08761) continuation;
            if ((c08761.label & Integer.MIN_VALUE) != 0) {
                c08761.label -= Integer.MIN_VALUE;
            } else {
                c08761 = xBaseBleConnector2.new C08761(continuation);
            }
        } else {
            c08761 = xBaseBleConnector2.new C08761(continuation);
        }
        Object objIsConnected$default = c08761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08761.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsConnected$default);
            XConnector.updateLastState$default(xBaseBleConnector2, 1, null, 2, null);
            if (xBaseBleConnector2.hasRelationConnector() && xBaseBleConnector2.isBtConnector()) {
                XBTConnector mRelationConnector = xBaseBleConnector2.getMRelationConnector();
                if (mRelationConnector != null) {
                    c08761.L$0 = xBaseBleConnector2;
                    c08761.label = 1;
                    objIsConnected$default = XBTConnector.isConnected$default(mRelationConnector, 0, c08761, 1, null);
                }
            } else {
                c08761.label = 3;
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            xBaseBleConnector2 = (XBaseBleConnector) c08761.L$0;
            ResultKt.throwOnFailure(objIsConnected$default);
            if (((Boolean) objIsConnected$default).booleanValue()) {
                z = true;
            }
        } else {
            if (i != 2) {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objIsConnected$default);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(objIsConnected$default);
        }
        return Unit.INSTANCE;
        if (z) {
            c08761.L$0 = null;
            c08761.label = 2;
        } else {
            xBaseBleConnector2.waitRelationConnector.set(true);
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                XBTConnector mRelationConnector2 = xBaseBleConnector2.getMRelationConnector();
                String str = (mRelationConnector2 != null ? mRelationConnector2.getConnectorType() : null) + " connecting ,waiting";
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
            XBTConnector mRelationConnector3 = xBaseBleConnector2.getMRelationConnector();
            if (mRelationConnector3 != null) {
                mRelationConnector3.connectInternal(1);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0218  */
    /* JADX WARN: Code duplicated, block: B:73:0x0285  */
    /* JADX WARN: Code duplicated, block: B:76:0x02b3  */
    /* JADX WARN: Code duplicated, block: B:79:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:82:0x02de  */
    /* JADX WARN: Code duplicated, block: B:89:0x034b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0389  */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0383, code lost:
    
        if (kotlinx.coroutines.DelayKt.delay(r4, r2) == r3) goto L92;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onInternalResult(String str, Continuation<? super Unit> continuation) {
        C08841 c08841;
        String str2;
        XBaseBleConnector xBaseBleConnector;
        XBaseBleConnector xBaseBleConnector2;
        Logger logger;
        String tag;
        int depth;
        Job job;
        BluetoothGatt bluetoothGattCreateGatt;
        Logger logger2;
        String tag2;
        int depth2;
        String str3;
        String str4;
        String strComponent1;
        String strComponent2;
        String str5;
        String str6;
        String strComponent3;
        String strComponent4;
        if (continuation instanceof C08841) {
            c08841 = (C08841) continuation;
            if ((c08841.label & Integer.MIN_VALUE) != 0) {
                c08841.label -= Integer.MIN_VALUE;
            } else {
                c08841 = new C08841(continuation);
            }
        } else {
            c08841 = new C08841(continuation);
        }
        Object objScan = c08841.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08841.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objScan);
            if (getMIsNeedScan().get()) {
                XBluetoothFlowCallBack mXBluetoothFlowCallBack = getMXBluetoothFlowCallBack();
                c08841.L$0 = this;
                str2 = str;
                c08841.L$1 = str2;
                c08841.label = 1;
                objScan = scan(mXBluetoothFlowCallBack, c08841);
                if (objScan != coroutine_suspended) {
                    xBaseBleConnector2 = this;
                }
            } else {
                str2 = str;
                xBaseBleConnector = this;
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str5 = xBaseBleConnector.getStepStatus(1) + " create gatt," + str2;
                    str6 = str5;
                    if (str6 != null && str6.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        strComponent3 = trace.component1();
                        strComponent4 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str7 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        FileLog.print$default(fileLog, 3, str7, tag, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                job = xBaseBleConnector.discoverJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                xBaseBleConnector.entryDiscover.set(false);
                bluetoothGattCreateGatt = xBaseBleConnector.createGatt(xBaseBleConnector.getMBleDevice());
                xBaseBleConnector.bluetoothGatt = bluetoothGattCreateGatt;
                if (bluetoothGattCreateGatt != null) {
                    logger2 = Logger.INSTANCE;
                    tag2 = logger2.getTAG();
                    depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        str3 = "create gatt " + xBaseBleConnector.getConnectorType() + " success  wait callback!";
                        str4 = str3;
                        if (str4 != null && str4.length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            strComponent1 = trace2.component1();
                            strComponent2 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str8 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                            FileLog.print$default(fileLog2, 3, str8, tag2, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    long mConnectMillisTimeOut = xBaseBleConnector.getMConnectMillisTimeOut();
                    c08841.L$0 = null;
                    c08841.L$1 = null;
                    c08841.label = 2;
                } else {
                    onBleDisconnected$default(xBaseBleConnector, "gatt connect failed", null, null, 6, null);
                    return Unit.INSTANCE;
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            str2 = (String) c08841.L$1;
            xBaseBleConnector2 = (XBaseBleConnector) c08841.L$0;
            ResultKt.throwOnFailure(objScan);
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objScan);
        }
        return Unit.INSTANCE;
        XBluetoothDevice xBluetoothDevice = (XBluetoothDevice) objScan;
        if (xBluetoothDevice == null) {
            xBaseBleConnector2.cancelJobWhenConnectedFailed("scan failed");
            return Unit.INSTANCE;
        }
        Logger logger3 = Logger.INSTANCE;
        String tag3 = logger3.getTAG();
        int depth3 = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str9 = "scanDevice " + xBluetoothDevice;
            String str10 = str9;
            if (str10 != null && str10.length() != 0) {
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str11 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                FileLog.print$default(fileLog3, 3, str11, tag3, str9 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str9 + StringUtils.SPACE + strComponent6);
                }
            }
        }
        if (Intrinsics.areEqual(xBluetoothDevice.getStatus(), "00")) {
            UnPairedException unPairedException = new UnPairedException(str2);
            Job connectJob = xBaseBleConnector2.getConnectJob();
            if (connectJob != null && connectJob.isActive()) {
                Job connectJob2 = xBaseBleConnector2.getConnectJob();
                if (connectJob2 != null) {
                    connectJob2.cancel((CancellationException) unPairedException);
                }
                return Unit.INSTANCE;
            }
            Logger logger4 = Logger.INSTANCE;
            String tag4 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true)) {
                String str12 = xBaseBleConnector2.getConnectorType() + " cancelJobWhenFailed unpaired  " + str2;
                String str13 = str12;
                if (str13 != null && str13.length() != 0) {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str14 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                    FileLog.print$default(fileLog4, 3, str14, tag4, str12 + StringUtils.SPACE + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag4 + strComponent7, str12 + StringUtils.SPACE + strComponent8);
                    }
                }
            }
            return Unit.INSTANCE;
        }
        xBaseBleConnector = xBaseBleConnector2;
        logger = Logger.INSTANCE;
        tag = logger.getTAG();
        depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            str5 = xBaseBleConnector.getStepStatus(1) + " create gatt," + str2;
            str6 = str5;
            if (str6 != null) {
                Pair<String, String> trace5 = logger.getTrace(depth);
                strComponent3 = trace5.component1();
                strComponent4 = trace5.component2();
                FileLog fileLog5 = FileLog.INSTANCE;
                String str15 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                FileLog.print$default(fileLog5, 3, str15, tag, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                }
            }
        }
        job = xBaseBleConnector.discoverJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        xBaseBleConnector.entryDiscover.set(false);
        bluetoothGattCreateGatt = xBaseBleConnector.createGatt(xBaseBleConnector.getMBleDevice());
        xBaseBleConnector.bluetoothGatt = bluetoothGattCreateGatt;
        if (bluetoothGattCreateGatt != null) {
            logger2 = Logger.INSTANCE;
            tag2 = logger2.getTAG();
            depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                str3 = "create gatt " + xBaseBleConnector.getConnectorType() + " success  wait callback!";
                str4 = str3;
                if (str4 != null) {
                    Pair<String, String> trace6 = logger2.getTrace(depth2);
                    strComponent1 = trace6.component1();
                    strComponent2 = trace6.component2();
                    FileLog fileLog6 = FileLog.INSTANCE;
                    String str16 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str16, "format(...)");
                    FileLog.print$default(fileLog6, 3, str16, tag2, str3 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent1, str3 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            long mConnectMillisTimeOut2 = xBaseBleConnector.getMConnectMillisTimeOut();
            c08841.L$0 = null;
            c08841.L$1 = null;
            c08841.label = 2;
        } else {
            onBleDisconnected$default(xBaseBleConnector, "gatt connect failed", null, null, 6, null);
            return Unit.INSTANCE;
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onConnectionStateChange gatt " + gatt + " status:" + status + ",newState:" + newState + " ,lastState:" + getLastState().get();
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
        if (gatt != null && !Intrinsics.areEqual(this.bluetoothGatt, gatt)) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true) && "onConnected gatt != null".length() != 0) {
                Pair<String, String> trace2 = logger2.getTrace(depth2);
                String strComponent3 = trace2.component1();
                String strComponent4 = trace2.component2();
                FileLog fileLog2 = FileLog.INSTANCE;
                String str4 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                FileLog.print$default(fileLog2, 5, str4, tag2, "onConnected gatt != null " + strComponent4, null, 16, null);
                if (logger2.isDebug()) {
                    Log.w(tag2 + strComponent3, "onConnected gatt != null " + strComponent4);
                }
            }
            this.bluetoothGatt = gatt;
        }
        if (status != 0 || newState != 2) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C08823(status, newState, null), 3, null);
        } else {
            discoverService();
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onConnectionStateChange$3, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onConnectionStateChange$3", f = "XBaseBleConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08823 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $newState;
        final /* synthetic */ int $status;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08823(int i, int i2, Continuation<? super C08823> continuation) {
            super(2, continuation);
            this.$status = i;
            this.$newState = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new C08823(this.$status, this.$newState, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08823) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            XBaseBleConnector.this.closeLast();
            XBaseBleConnector.this.onDisconnected(this.$status, this.$newState);
            return Unit.INSTANCE;
        }
    }

    private final void discoverService() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        if (this.bluetoothGatt == null) {
            XBluetoothDevice mBleDevice = getMBleDevice();
            connectFail(new XConnectFailType.ConnectException(new UnDefinedException((mBleDevice != null ? mBleDevice.getDeviceAddress() : null) + " -> find service failed!", null, 2, null)), "bluetoothGatt is null ,Find service failed!");
            return;
        }
        if (this.entryDiscover.get()) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "already entryDiscover start discoverService..".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 5, str, tag, "already entryDiscover start discoverService.. " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.w(tag + strComponent1, "already entryDiscover start discoverService.. " + strComponent2);
                    return;
                }
                return;
            }
            return;
        }
        this.entryDiscover.set(true);
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str2 = getStepStatus(2) + " discover service!";
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
        Job job = this.discoverJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass3(atomicInteger, null), 3, null);
        this.discoverJob = jobLaunch$default;
        if (jobLaunch$default != null) {
            jobLaunch$default.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector.discoverService.4
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
                    Logger logger3 = Logger.INSTANCE;
                    String tag3 = logger3.getTAG();
                    int depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true) && "discoverJob cancel..".length() != 0) {
                        Pair<String, String> trace3 = logger3.getTrace(depth3);
                        String strComponent5 = trace3.component1();
                        String strComponent6 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str5 = logger3.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                        FileLog.print$default(fileLog3, 3, str5, tag3, "discoverJob cancel.. " + strComponent6, null, 16, null);
                        if (logger3.isDebug()) {
                            Log.i(tag3 + strComponent5, "discoverJob cancel.. " + strComponent6);
                        }
                    }
                    XBaseBleConnector.this.entryDiscover.set(false);
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$discoverService$3, reason: invalid class name */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$discoverService$3", f = "XBaseBleConnector.kt", i = {0, 1}, l = {291, 300}, m = "invokeSuspend", n = {"startSuccess", "startSuccess"}, s = {"L$0", "L$0"})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ AtomicInteger $discoverCount;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(AtomicInteger atomicInteger, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$discoverCount = atomicInteger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new AnonymousClass3(this.$discoverCount, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x003b  */
        /* JADX WARN: Code duplicated, block: B:17:0x005b  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0069, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(1000, r12) == r0) goto L20;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0069 -> B:7:0x0015). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Ref.BooleanRef booleanRef;
            Ref.BooleanRef booleanRef2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                booleanRef = new Ref.BooleanRef();
                if (XBaseBleConnector.this.getLastState().get() != 2) {
                    this.L$0 = booleanRef;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(XBaseBleConnector.this, booleanRef, this.$discoverCount, null), this) != coroutine_suspended) {
                        booleanRef2 = booleanRef;
                        this.L$0 = booleanRef2;
                        this.label = 2;
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i == 1) {
                booleanRef2 = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.L$0 = booleanRef2;
                this.label = 2;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef2 = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            booleanRef = booleanRef2;
            if (this.$discoverCount.incrementAndGet() < 6) {
                if (XBaseBleConnector.this.getLastState().get() != 2) {
                    this.L$0 = booleanRef;
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(XBaseBleConnector.this, booleanRef, this.$discoverCount, null), this) != coroutine_suspended) {
                        booleanRef2 = booleanRef;
                        this.L$0 = booleanRef2;
                        this.label = 2;
                    }
                    return coroutine_suspended;
                }
            } else {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "time out discover service".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 5, str, tag, "time out discover service " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.w(tag + strComponent1, "time out discover service " + strComponent2);
                    }
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$discoverService$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: XBaseBleConnector.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$discoverService$3$1", f = "XBaseBleConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AtomicInteger $discoverCount;
            final /* synthetic */ Ref.BooleanRef $startSuccess;
            int label;
            final /* synthetic */ XBaseBleConnector this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(XBaseBleConnector xBaseBleConnector, Ref.BooleanRef booleanRef, AtomicInteger atomicInteger, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = xBaseBleConnector;
                this.$startSuccess = booleanRef;
                this.$discoverCount = atomicInteger;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$startSuccess, this.$discoverCount, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    BluetoothGatt bluetoothGatt = this.this$0.bluetoothGatt;
                    List<BluetoothGattService> services = bluetoothGatt != null ? bluetoothGatt.getServices() : null;
                    Logger logger = Logger.INSTANCE;
                    AtomicInteger atomicInteger = this.$discoverCount;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = "discover services " + (services != null ? Boxing.boxInt(services.size()) : null) + " ,retry count " + atomicInteger.get();
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
                    if (!this.$startSuccess.element && BleUtil.INSTANCE.checkBluetoothPermissions()) {
                        Ref.BooleanRef booleanRef = this.$startSuccess;
                        BluetoothGatt bluetoothGatt2 = this.this$0.bluetoothGatt;
                        boolean z = false;
                        if (bluetoothGatt2 != null && bluetoothGatt2.discoverServices()) {
                            z = true;
                        }
                        booleanRef.element = z;
                        Logger logger2 = Logger.INSTANCE;
                        Ref.BooleanRef booleanRef2 = this.$startSuccess;
                        String tag2 = logger2.getTAG();
                        int depth2 = logger2.getDepth();
                        if (logger2.isCanLogger(true)) {
                            String str4 = "discover services startSuccess " + booleanRef2.element + StringUtils.SPACE;
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
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onServicesDiscoveredChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onServicesDiscoveredChange$1", f = "XBaseBleConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $status;
        final /* synthetic */ boolean $success;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08871(boolean z, int i, Continuation<? super C08871> continuation) {
            super(2, continuation);
            this.$success = z;
            this.$status = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new C08871(this.$success, this.$status, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08871) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = XBaseBleConnector.this.discoverJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                if (this.$success) {
                    XBaseBleConnector.this.applyHighConnectionPriorityIfNeeded();
                    boolean autoSetMtu = XBaseBleConnector.this.getMXBluetoothManager().getBluetoothConfig().getAutoSetMtu();
                    Logger logger = Logger.INSTANCE;
                    XBaseBleConnector xBaseBleConnector = XBaseBleConnector.this;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        String str = xBaseBleConnector.getStepStatus(3) + ",autoMtu=" + autoSetMtu;
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
                    if (autoSetMtu) {
                        if (BleUtil.INSTANCE.checkBluetoothPermissions()) {
                            BluetoothGatt bluetoothGatt = XBaseBleConnector.this.bluetoothGatt;
                            Boolean boolBoxBoolean = bluetoothGatt != null ? Boxing.boxBoolean(bluetoothGatt.requestMtu(XBaseBleConnector.this.getMXBluetoothManager().getBluetoothConfig().getMtu())) : null;
                            Logger logger2 = Logger.INSTANCE;
                            String tag2 = logger2.getTAG();
                            int depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(true)) {
                                String str4 = "requestMtu result=" + boolBoxBoolean + StringUtils.SPACE;
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
                        } else {
                            Logger logger3 = Logger.INSTANCE;
                            String tag3 = logger3.getTAG();
                            int depth3 = logger3.getDepth();
                            if (logger3.isCanLogger(true) && "requestMtu no permission".length() != 0) {
                                Pair<String, String> trace3 = logger3.getTrace(depth3);
                                String strComponent5 = trace3.component1();
                                String strComponent6 = trace3.component2();
                                FileLog fileLog3 = FileLog.INSTANCE;
                                String str7 = logger3.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                FileLog.print$default(fileLog3, 3, str7, tag3, "requestMtu no permission " + strComponent6, null, 16, null);
                                if (logger3.isDebug()) {
                                    Log.i(tag3 + strComponent5, "requestMtu no permission " + strComponent6);
                                }
                            }
                        }
                    } else if (XBaseBleConnector.this.getOpenNotifyChannel()) {
                        XBaseBleConnector xBaseBleConnector2 = XBaseBleConnector.this;
                        String serviceUUID = xBaseBleConnector2.getServiceUUID();
                        String notifyUUID = XBaseBleConnector.this.getNotifyUUID();
                        final XBaseBleConnector xBaseBleConnector3 = XBaseBleConnector.this;
                        xBaseBleConnector2.enableCharacteristicNotifyWithTask(serviceUUID, notifyUUID, true, 0L, new Function1<XCommonTaskCallback, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector.onServicesDiscoveredChange.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(XCommonTaskCallback xCommonTaskCallback) {
                                invoke2(xCommonTaskCallback);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(XCommonTaskCallback enableCharacteristicNotifyWithTask) {
                                Intrinsics.checkNotNullParameter(enableCharacteristicNotifyWithTask, "$this$enableCharacteristicNotifyWithTask");
                                final XBaseBleConnector xBaseBleConnector4 = xBaseBleConnector3;
                                enableCharacteristicNotifyWithTask.onSuccess(new Function3<XBluetoothDevice, Boolean, Object, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector.onServicesDiscoveredChange.1.4.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Boolean bool, Object obj2) {
                                        invoke(xBluetoothDevice, bool.booleanValue(), obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
                                        Intrinsics.checkNotNullParameter(data, "data");
                                        xBaseBleConnector4.cancelJobWhenConnected("enable notify success!");
                                    }
                                });
                                final XBaseBleConnector xBaseBleConnector5 = xBaseBleConnector3;
                                enableCharacteristicNotifyWithTask.onFail(new Function2<XBluetoothDevice, Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector.onServicesDiscoveredChange.1.4.2
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Throwable th) {
                                        invoke2(xBluetoothDevice, th);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(XBluetoothDevice xBluetoothDevice, Throwable throwable) {
                                        Intrinsics.checkNotNullParameter(throwable, "throwable");
                                        xBaseBleConnector5.cancelJobWhenConnectedFailed(" enableCharacteristicNotify failed!");
                                    }
                                });
                            }
                        }, null, true, "connect");
                    } else {
                        XBaseBleConnector.this.cancelJobWhenConnected("ble no need open channel success!");
                    }
                } else {
                    Logger logger4 = Logger.INSTANCE;
                    int i = this.$status;
                    String tag4 = logger4.getTAG();
                    int depth4 = logger4.getDepth();
                    if (logger4.isCanLogger(true)) {
                        String str8 = "discover service failed!status=" + i;
                        String str9 = str8;
                        if (str9 != null && str9.length() != 0) {
                            Pair<String, String> trace4 = logger4.getTrace(depth4);
                            String strComponent7 = trace4.component1();
                            String strComponent8 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str10 = logger4.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                            FileLog.print$default(fileLog4, 3, str10, tag4, str8 + StringUtils.SPACE + strComponent8, null, 16, null);
                            if (logger4.isDebug()) {
                                Log.i(tag4 + strComponent7, str8 + StringUtils.SPACE + strComponent8);
                            }
                        }
                    }
                    XBaseBleConnector.this.cancelJobWhenConnectedFailed(" discover service failed!");
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onServicesDiscoveredChange(boolean success, int status) {
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C08871(success, status, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyHighConnectionPriorityIfNeeded() {
        XBluetoothDevice mBleDevice = getMBleDevice();
        String deviceAddress = mBleDevice != null ? mBleDevice.getDeviceAddress() : null;
        if (this.requestHighConnectionPriority) {
            if (this.bluetoothGatt == null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "[connPriority] skip HIGH: bluetoothGatt=null tag=" + getTag() + " addr=" + deviceAddress;
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
                    FileLog.print$default(fileLog, 5, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.w(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        return;
                    }
                    return;
                }
                return;
            }
            if (!BleUtil.INSTANCE.checkBluetoothPermissions()) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "[connPriority] skip HIGH: no BLUETOOTH_CONNECT permission tag=" + getTag() + " addr=" + deviceAddress;
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
                    FileLog.print$default(fileLog2, 5, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.w(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        return;
                    }
                    return;
                }
                return;
            }
            BluetoothGatt bluetoothGatt = this.bluetoothGatt;
            boolean z = false;
            if (bluetoothGatt != null && bluetoothGatt.requestConnectionPriority(1)) {
                z = true;
            }
            this.highConnectionPriorityApplied = z;
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String tag4 = getTag();
                BluetoothGatt bluetoothGatt2 = this.bluetoothGatt;
                String str7 = "[connPriority] request HIGH apiAccepted=" + z + " (true=API accepted request, not a guarantee of shorter interval) tag=" + tag4 + " addr=" + deviceAddress + " gatt=" + (bluetoothGatt2 != null ? Integer.valueOf(bluetoothGatt2.hashCode()) : null) + " sdkInt=" + Build.VERSION.SDK_INT;
                String str8 = str7;
                if (str8 != null && str8.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str9 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                    FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            if (z) {
                return;
            }
            Logger logger4 = Logger.INSTANCE;
            String tag5 = logger4.getTAG();
            int depth4 = logger4.getDepth();
            if (logger4.isCanLogger(true)) {
                String str10 = "[connPriority] request HIGH rejected by API (false); stack may ignore. tag=" + getTag() + " addr=" + deviceAddress;
                String str11 = str10;
                if (str11 == null || str11.length() == 0) {
                    return;
                }
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str12 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                FileLog.print$default(fileLog4, 5, str12, tag5, str10 + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.w(tag5 + strComponent7, str10 + StringUtils.SPACE + strComponent8);
                }
            }
        }
    }

    private final void restoreConnectionPriorityIfNeeded() {
        Object objM6347constructorimpl;
        XBluetoothDevice mBleDevice = getMBleDevice();
        String deviceAddress = mBleDevice != null ? mBleDevice.getDeviceAddress() : null;
        if (this.highConnectionPriorityApplied) {
            if (this.bluetoothGatt == null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "[connPriority] skip restore BALANCED: bluetoothGatt=null (was HIGH-applied; clear flag) tag=" + getTag() + " addr=" + deviceAddress;
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
                this.highConnectionPriorityApplied = false;
                return;
            }
            if (!BleUtil.INSTANCE.checkBluetoothPermissions()) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str4 = "[connPriority] skip restore BALANCED: no permission tag=" + getTag() + " addr=" + deviceAddress;
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
                this.highConnectionPriorityApplied = false;
                return;
            }
            try {
                Result.Companion companion = Result.INSTANCE;
                XBaseBleConnector xBaseBleConnector = this;
                BluetoothGatt bluetoothGatt = this.bluetoothGatt;
                objM6347constructorimpl = Result.m6347constructorimpl(bluetoothGatt != null ? Boolean.valueOf(bluetoothGatt.requestConnectionPriority(0)) : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m6353isFailureimpl(objM6347constructorimpl)) {
                objM6347constructorimpl = null;
            }
            boolean zAreEqual = Intrinsics.areEqual(objM6347constructorimpl, (Object) true);
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String tag4 = getTag();
                BluetoothGatt bluetoothGatt2 = this.bluetoothGatt;
                String str7 = "[connPriority] restore BALANCED apiAccepted=" + zAreEqual + " tag=" + tag4 + " addr=" + deviceAddress + " gatt=" + (bluetoothGatt2 != null ? Integer.valueOf(bluetoothGatt2.hashCode()) : null);
                String str8 = str7;
                if (str8 != null && str8.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str9 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                    FileLog.print$default(fileLog3, 3, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            if (!zAreEqual) {
                Logger logger4 = Logger.INSTANCE;
                String tag5 = logger4.getTAG();
                int depth4 = logger4.getDepth();
                if (logger4.isCanLogger(true)) {
                    String str10 = "[connPriority] restore BALANCED rejected by API (false) tag=" + getTag() + " addr=" + deviceAddress;
                    String str11 = str10;
                    if (str11 != null && str11.length() != 0) {
                        Pair<String, String> trace4 = logger4.getTrace(depth4);
                        String strComponent7 = trace4.component1();
                        String strComponent8 = trace4.component2();
                        FileLog fileLog4 = FileLog.INSTANCE;
                        String str12 = logger4.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                        FileLog.print$default(fileLog4, 5, str12, tag5, str10 + StringUtils.SPACE + strComponent8, null, 16, null);
                        if (logger4.isDebug()) {
                            Log.w(tag5 + strComponent7, str10 + StringUtils.SPACE + strComponent8);
                        }
                    }
                }
            }
            this.highConnectionPriorityApplied = false;
        }
    }

    public static /* synthetic */ void onBleDisconnected$default(XBaseBleConnector xBaseBleConnector, String str, Integer num, XConnectFailType xConnectFailType, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBleDisconnected");
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            xConnectFailType = null;
        }
        xBaseBleConnector.onBleDisconnected(str, num, xConnectFailType);
    }

    public final void onBleDisconnected(String reason, Integer state, XConnectFailType failType) {
        Job connectJob;
        Job connectJob2;
        Intrinsics.checkNotNullParameter(reason, "reason");
        getCreateJob().set(false);
        if (getLastState().get() == 1 && (connectJob = getConnectJob()) != null && connectJob.isActive() && (connectJob2 = getConnectJob()) != null) {
            connectJob2.cancel((CancellationException) new ActiveDisConnectedException(reason));
        }
        updateLastState(state != null ? state.intValue() : 0, failType);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void keyMissingChanged(BluetoothDevice device, boolean connected) {
        if (connected) {
            return;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = getConnectorType() + ",reason:keyMissingChanged ,device:" + device + StringUtils.SPACE;
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
        onBleDisconnected("keyMissingChanged", 4, XConnectFailType.KeyMissingPaired.INSTANCE);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onLeAudioChange(BluetoothDevice device, boolean leAudioConnect, boolean a2dpConnect, boolean headsetConnect) {
        if (isLeAudioConnector()) {
            if (!leAudioConnect) {
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass2(null), 3, null);
            } else if (this.waitRelationConnector.get()) {
                this.waitRelationConnector.set(false);
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C08851(null), 3, null);
            } else {
                XBondConnector.checkParameterAndStartConnectJob$default(this, false, null, 1, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onLeAudioChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onLeAudioChange$1", f = "XBaseBleConnector.kt", i = {}, l = {451}, m = "invokeSuspend", n = {}, s = {})
    static final class C08851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08851(Continuation<? super C08851> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new C08851(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08851) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (XBaseBleConnector.this.onInternalResult("waitRelationConnector", this) == coroutine_suspended) {
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

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onLeAudioChange$2, reason: invalid class name */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onLeAudioChange$2", f = "XBaseBleConnector.kt", i = {}, l = {459}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new AnonymousClass2(continuation);
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
                obj = XBaseBleConnector.this.isConnected(true, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            if (((Boolean) obj).booleanValue()) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "ignore leAudioConnect disconnected! gatt is Connected!".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "ignore leAudioConnect disconnected! gatt is Connected! " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "ignore leAudioConnect disconnected! gatt is Connected! " + strComponent2);
                    }
                }
            } else {
                XBaseBleConnector.onBleDisconnected$default(XBaseBleConnector.this, "leAudio disconnect!", null, null, 6, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final boolean isBtConnector() {
        return getMRelationConnector() != null;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onHeadSetChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (isBtConnector()) {
            if (!headsetConnect && !a2dpConnect) {
                onBleDisconnected$default(this, "headset disconnected", null, null, 6, null);
            } else if (this.waitRelationConnector.get()) {
                this.waitRelationConnector.set(false);
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C08831(null), 3, null);
            } else {
                XBondConnector.checkParameterAndStartConnectJob$default(this, false, null, 1, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onHeadSetChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onHeadSetChange$1", f = "XBaseBleConnector.kt", i = {}, l = {485}, m = "invokeSuspend", n = {}, s = {})
    static final class C08831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08831(Continuation<? super C08831> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new C08831(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (XBaseBleConnector.this.onInternalResult("waitRelationConnector", this) == coroutine_suspended) {
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

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector, com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange
    public void onA2DPChange(BluetoothDevice device, boolean a2dpConnect, boolean headsetConnect) {
        if (isBtConnector()) {
            if (!headsetConnect && !a2dpConnect) {
                onBleDisconnected$default(this, "a2dp disconnected", null, null, 6, null);
            } else if (this.waitRelationConnector.get()) {
                this.waitRelationConnector.set(false);
                BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C08811(null), 3, null);
            } else {
                XBondConnector.checkParameterAndStartConnectJob$default(this, false, null, 1, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onA2DPChange$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onA2DPChange$1", f = "XBaseBleConnector.kt", i = {}, l = {TypedValues.PositionType.TYPE_PERCENT_Y}, m = "invokeSuspend", n = {}, s = {})
    static final class C08811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08811(Continuation<? super C08811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new C08811(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (XBaseBleConnector.this.onInternalResult("waitRelationConnector", this) == coroutine_suspended) {
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

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void connectFail(XConnectFailType failType, String reason) {
        Intrinsics.checkNotNullParameter(failType, "failType");
        Intrinsics.checkNotNullParameter(reason, "reason");
        super.connectFail(failType, reason);
        this.scan.stopScan();
        closeLast();
    }

    public final void refreshDeviceCache() {
        try {
            if (this.bluetoothGatt == null || !BleUtil.INSTANCE.checkPermission("android.permission.BLUETOOTH_CONNECT")) {
                return;
            }
            Object objInvoke = BluetoothGatt.class.getMethod("refresh", new Class[0]).invoke(this.bluetoothGatt, new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            boolean zBooleanValue = ((Boolean) objInvoke).booleanValue();
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "refreshDeviceCache, is success:  " + zBooleanValue;
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
                String str4 = "exception occur while refreshing device: " + e.getMessage();
                String str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                    String strComponent3 = trace2.component1();
                    String strComponent4 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str6 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    FileLog.print$default(fileLog2, 6, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.e(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            e.printStackTrace();
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void closeLast() {
        BluetoothGatt bluetoothGatt;
        restoreConnectionPriorityIfNeeded();
        try {
            try {
                try {
                    if (BleUtil.INSTANCE.checkPermission("android.permission.BLUETOOTH_CONNECT")) {
                        BluetoothGatt bluetoothGatt2 = this.bluetoothGatt;
                        if (bluetoothGatt2 != null) {
                            bluetoothGatt2.disconnect();
                        }
                    } else {
                        Logger logger = Logger.INSTANCE;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true) && "closeLast no permission".length() != 0) {
                            Pair<String, String> trace = logger.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                            FileLog.print$default(fileLog, 3, str, tag, "closeLast no permission " + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.i(tag + strComponent1, "closeLast no permission " + strComponent2);
                            }
                        }
                    }
                    Thread.sleep(200L);
                    refreshDeviceCache();
                    if (BleUtil.INSTANCE.checkPermission("android.permission.BLUETOOTH_CONNECT") && (bluetoothGatt = this.bluetoothGatt) != null) {
                        bluetoothGatt.close();
                    }
                } catch (Throwable th) {
                    if (BleUtil.INSTANCE.checkPermission("android.permission.BLUETOOTH_CONNECT")) {
                        try {
                            BluetoothGatt bluetoothGatt3 = this.bluetoothGatt;
                            if (bluetoothGatt3 != null) {
                                bluetoothGatt3.close();
                            }
                        } catch (Exception unused) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (BleUtil.INSTANCE.checkPermission("android.permission.BLUETOOTH_CONNECT") && (bluetoothGatt = this.bluetoothGatt) != null) {
                }
            }
        } catch (Exception unused2) {
        }
        this.bluetoothGatt = null;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public CoroutineScope connectScope() {
        return XBluetoothManager.INSTANCE.get().getMainScope();
    }

    public final OrderedTaskExecutor getExecutor() {
        return this.executor;
    }

    public final void setExecutor(OrderedTaskExecutor orderedTaskExecutor) {
        Intrinsics.checkNotNullParameter(orderedTaskExecutor, "<set-?>");
        this.executor = orderedTaskExecutor;
    }

    private final BluetoothGatt createGatt(XBluetoothDevice bleDevice) {
        BluetoothDevice deviceInfo;
        if (bleDevice == null || (deviceInfo = bleDevice.getDeviceInfo()) == null) {
            return null;
        }
        return deviceInfo.connectGatt(getMContext(), this.autoConnect, this.proxyCallback, 2);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void writeWithTask(byte[] dataArray, long operateInterval, long durationTimeMillis, boolean needUpdate, boolean ignoreFrame, boolean autoDoNextTask, String serviceUUID, String writeUUID, byte[] mockResponse, AtomicInteger retryCount, boolean successWithComplete, String taskId, ArrayList<String> resIds, Function1<? super XWriteCallback, Unit> writeCallback) {
        Intrinsics.checkNotNullParameter(dataArray, "dataArray");
        Intrinsics.checkNotNullParameter(serviceUUID, "serviceUUID");
        Intrinsics.checkNotNullParameter(writeUUID, "writeUUID");
        Intrinsics.checkNotNullParameter(writeCallback, "writeCallback");
        XWriteCallback xWriteCallback = new XWriteCallback();
        writeCallback.invoke(xWriteCallback);
        XCommand xCommand = parserWriterCommand(taskId, dataArray, resIds);
        getTaskQueue(writeUUID).addTask(new XTask(xCommand.getCommand(ignoreFrame), xCommand.getCurrentCount(), xCommand.getTotalCount(), durationTimeMillis, operateInterval, false, autoDoNextTask, null, ignoreFrame, new XBaseBleConnector$writeWithTask$task$1(this, xCommand, serviceUUID, writeUUID, dataArray, operateInterval, null), xWriteCallback, getMBleDevice(), needUpdate, mockResponse, retryCount, successWithComplete, 160, null));
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void clearTaskQueue() {
        super.clearTaskQueue();
        this.executor.shutdown();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    static /* synthetic */ Object writeWithTask$suspendImpl(XBaseBleConnector xBaseBleConnector, byte[] bArr, long j, long j2, boolean z, boolean z2, boolean z3, String str, String str2, byte[] bArr2, AtomicInteger atomicInteger, boolean z4, String str3, ArrayList<String> arrayList, Continuation<? super byte[]> continuation) throws Throwable {
        C08891 c08891;
        String str4;
        String str5;
        byte[] bArr3;
        boolean z5;
        boolean z6;
        ArrayList<String> arrayList2;
        long j3;
        boolean z7;
        Object obj;
        String str6;
        byte[] bArr4;
        boolean z8;
        AtomicInteger atomicInteger2;
        long j4;
        XBaseBleConnector xBaseBleConnector2 = xBaseBleConnector;
        if (continuation instanceof C08891) {
            c08891 = (C08891) continuation;
            if ((c08891.label & Integer.MIN_VALUE) != 0) {
                c08891.label -= Integer.MIN_VALUE;
            } else {
                c08891 = xBaseBleConnector2.new C08891(continuation);
            }
        } else {
            c08891 = xBaseBleConnector2.new C08891(continuation);
        }
        Object obj2 = c08891.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08891.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj2);
            c08891.L$0 = xBaseBleConnector2;
            c08891.L$1 = bArr;
            str4 = str;
            c08891.L$2 = str4;
            str5 = str2;
            c08891.L$3 = str5;
            bArr3 = bArr2;
            c08891.L$4 = bArr3;
            c08891.L$5 = atomicInteger;
            c08891.L$6 = str3;
            c08891.L$7 = arrayList;
            c08891.J$0 = j;
            c08891.J$1 = j2;
            z5 = z;
            c08891.Z$0 = z5;
            z6 = z2;
            c08891.Z$1 = z6;
            c08891.Z$2 = z3;
            c08891.Z$3 = z4;
            c08891.label = 1;
            Object objIsConnected = xBaseBleConnector2.isConnected(true, c08891);
            if (objIsConnected == coroutine_suspended) {
                return coroutine_suspended;
            }
            arrayList2 = arrayList;
            j3 = j;
            z7 = z4;
            obj = objIsConnected;
            str6 = str3;
            bArr4 = bArr;
            z8 = z3;
            atomicInteger2 = atomicInteger;
            j4 = j2;
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                boolean z9 = c08891.Z$3;
                boolean z10 = c08891.Z$2;
                boolean z11 = c08891.Z$1;
                boolean z12 = c08891.Z$0;
                long j5 = c08891.J$1;
                long j6 = c08891.J$0;
                ResultKt.throwOnFailure(obj2);
                return obj2;
            }
            boolean z13 = c08891.Z$3;
            boolean z14 = c08891.Z$2;
            z6 = c08891.Z$1;
            boolean z15 = c08891.Z$0;
            j4 = c08891.J$1;
            j3 = c08891.J$0;
            arrayList2 = (ArrayList) c08891.L$7;
            String str7 = (String) c08891.L$6;
            atomicInteger2 = (AtomicInteger) c08891.L$5;
            byte[] bArr5 = (byte[]) c08891.L$4;
            str5 = (String) c08891.L$3;
            String str8 = (String) c08891.L$2;
            byte[] bArr6 = (byte[]) c08891.L$1;
            xBaseBleConnector2 = (XBaseBleConnector) c08891.L$0;
            ResultKt.throwOnFailure(obj2);
            z5 = z15;
            bArr3 = bArr5;
            z7 = z13;
            obj = obj2;
            str6 = str7;
            bArr4 = bArr6;
            z8 = z14;
            str4 = str8;
        }
        if (!((Boolean) obj).booleanValue()) {
            return null;
        }
        c08891.L$0 = xBaseBleConnector2;
        c08891.L$1 = bArr4;
        c08891.L$2 = str4;
        c08891.L$3 = str5;
        c08891.L$4 = bArr3;
        c08891.L$5 = atomicInteger2;
        c08891.L$6 = str6;
        c08891.L$7 = arrayList2;
        c08891.J$0 = j3;
        c08891.J$1 = j4;
        c08891.Z$0 = z5;
        c08891.Z$1 = z6;
        c08891.Z$2 = z8;
        String str9 = str4;
        c08891.Z$3 = z7;
        c08891.label = 2;
        C08891 c08892 = c08891;
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(c08892));
        XWriteCallback xWriteCallback = new XWriteCallback();
        writeWithTask$lambda$25$callback(safeContinuation).invoke(xWriteCallback);
        XCommand xCommand = xBaseBleConnector2.parserWriterCommand(str6, bArr4, arrayList2);
        String str10 = str5;
        xBaseBleConnector2.getTaskQueue(str10).addTask(new XTask(xCommand.getCommand(z6), xCommand.getCurrentCount(), xCommand.getTotalCount(), j4, j3, false, z8, null, z6, new XBaseBleConnector$writeWithTask$2$task$1(xBaseBleConnector2, xCommand, str9, str10, bArr4, j3, null), xWriteCallback, xBaseBleConnector2.getMBleDevice(), z5, bArr3, atomicInteger2, z7, 160, null));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(c08892);
        }
        return orThrow == coroutine_suspended ? coroutine_suspended : orThrow;
    }

    private static final Function1<XWriteCallback, Unit> writeWithTask$lambda$25$callback(final Continuation<? super byte[]> continuation) {
        return new Function1<XWriteCallback, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$writeWithTask$2$callback$1
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
                xWriteCallback.onWriteComplete(new Function2<XBluetoothDevice, Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$writeWithTask$2$callback$1.1
                    public final void invoke(XBluetoothDevice xBluetoothDevice, boolean z) {
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Boolean bool) {
                        invoke(xBluetoothDevice, bool.booleanValue());
                        return Unit.INSTANCE;
                    }
                });
                final Continuation<byte[]> continuation2 = continuation;
                xWriteCallback.onWriteFail(new Function4<XBluetoothDevice, Integer, Integer, Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$writeWithTask$2$callback$1.2
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

                    public final void invoke(XBluetoothDevice xBluetoothDevice, int i, int i2, Throwable throwable) {
                        Intrinsics.checkNotNullParameter(throwable, "throwable");
                        Continuation<byte[]> continuation3 = continuation2;
                        try {
                            Result.Companion companion = Result.INSTANCE;
                            Result.Companion companion2 = Result.INSTANCE;
                            continuation3.resumeWith(Result.m6347constructorimpl(null));
                            Result.m6347constructorimpl(Unit.INSTANCE);
                        } catch (Throwable th) {
                            Result.Companion companion3 = Result.INSTANCE;
                            Result.m6347constructorimpl(ResultKt.createFailure(th));
                        }
                    }
                });
                final Continuation<byte[]> continuation3 = continuation;
                xWriteCallback.onWriteSuccess(new Function4<XBluetoothDevice, Integer, Integer, byte[], Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$writeWithTask$2$callback$1.3
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

    public final AtomicLong getLastTime() {
        return this.lastTime;
    }

    public final void setLastTime(AtomicLong atomicLong) {
        Intrinsics.checkNotNullParameter(atomicLong, "<set-?>");
        this.lastTime = atomicLong;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector
    public void connectTaskQueue() {
        super.connectTaskQueue();
        this.executor.start();
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$write$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$write$2", f = "XBaseBleConnector.kt", i = {0, 1, 1, 1, 1}, l = {747, 761}, m = "invokeSuspend", n = {"characteristic", "characteristic", "errorCode", "count", "writeType"}, s = {"L$0", "L$0", "L$1", "L$2", "I$0"})
    static final class C08882 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
        final /* synthetic */ byte[] $byteArray;
        final /* synthetic */ XCommand $command;
        final /* synthetic */ long $operateInterval;
        final /* synthetic */ String $serviceUUID;
        final /* synthetic */ String $writeUUID;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ XBaseBleConnector this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08882(String str, String str2, XBaseBleConnector xBaseBleConnector, long j, XCommand xCommand, byte[] bArr, Continuation<? super C08882> continuation) {
            super(1, continuation);
            this.$writeUUID = str;
            this.$serviceUUID = str2;
            this.this$0 = xBaseBleConnector;
            this.$operateInterval = j;
            this.$command = xCommand;
            this.$byteArray = bArr;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C08882(this.$writeUUID, this.$serviceUUID, this.this$0, this.$operateInterval, this.$command, this.$byteArray, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Boolean> continuation) {
            return ((C08882) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x03e2  */
        /* JADX WARN: Code duplicated, block: B:105:0x0430  */
        /* JADX WARN: Code duplicated, block: B:108:0x045d  */
        /* JADX WARN: Code duplicated, block: B:109:0x045f  */
        /* JADX WARN: Code duplicated, block: B:111:0x046f  */
        /* JADX WARN: Code duplicated, block: B:112:0x0474  */
        /* JADX WARN: Code duplicated, block: B:118:0x0390 A[EDGE_INSN: B:118:0x0390->B:93:0x0390 BREAK  A[LOOP:0: B:69:0x02a7->B:121:?], SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:119:0x02de A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:121:? A[LOOP:0: B:69:0x02a7->B:121:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:68:0x0297  */
        /* JADX WARN: Code duplicated, block: B:71:0x02ac  */
        /* JADX WARN: Code duplicated, block: B:74:0x02b9 A[Catch: Exception -> 0x002b, TryCatch #0 {Exception -> 0x002b, blocks: (B:7:0x0026, B:72:0x02b1, B:74:0x02b9, B:76:0x02c1, B:78:0x02c9), top: B:115:0x0026 }] */
        /* JADX WARN: Code duplicated, block: B:75:0x02c0  */
        /* JADX WARN: Code duplicated, block: B:78:0x02c9 A[Catch: Exception -> 0x002b, TRY_LEAVE, TryCatch #0 {Exception -> 0x002b, blocks: (B:7:0x0026, B:72:0x02b1, B:74:0x02b9, B:76:0x02c1, B:78:0x02c9), top: B:115:0x0026 }] */
        /* JADX WARN: Code duplicated, block: B:95:0x0394  */
        /* JADX WARN: Code duplicated, block: B:98:0x03ac  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:92:0x038c -> B:69:0x02a7). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BluetoothGattCharacteristic writeCharacteristic;
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            int writeType;
            BluetoothGatt bluetoothGatt;
            boolean zWriteCharacteristic;
            BluetoothGattCharacteristic bluetoothGattCharacteristic2;
            Ref.IntRef intRef;
            Ref.IntRef intRef2;
            int i;
            Logger logger;
            XCommand xCommand;
            String str;
            String tag;
            int depth;
            String str2;
            String str3;
            String strComponent1;
            String strComponent2;
            BluetoothGatt bluetoothGatt2;
            int iWriteCharacteristic;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            int i3 = -1;
            int i4 = 2;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                String writeUUID = this.$writeUUID;
                XBaseBleConnector xBaseBleConnector = this.this$0;
                if (writeUUID.length() == 0) {
                    writeUUID = xBaseBleConnector.getWriteUUID();
                }
                String str4 = writeUUID;
                String serviceUUID = this.$serviceUUID;
                XBaseBleConnector xBaseBleConnector2 = this.this$0;
                if (serviceUUID.length() == 0) {
                    serviceUUID = xBaseBleConnector2.getServiceUUID();
                }
                String str5 = serviceUUID;
                if (this.this$0.bluetoothGatt == null) {
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true) && "gatt is null!".length() != 0) {
                        Pair<String, String> trace = logger2.getTrace(depth2);
                        String strComponent3 = trace.component1();
                        String strComponent4 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str6 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                        FileLog.print$default(fileLog, 3, str6, tag2, "gatt is null! " + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, "gatt is null! " + strComponent4);
                        }
                    }
                    throw new UnConnectedException("gatt not connect");
                }
                if (BleUtil.INSTANCE.checkBluetoothPermissions()) {
                    writeCharacteristic = this.this$0.getWriteCharacteristic(str5, str4);
                    if (writeCharacteristic == null) {
                        Logger logger3 = Logger.INSTANCE;
                        String tag3 = logger3.getTAG();
                        int depth3 = logger3.getDepth();
                        if (logger3.isCanLogger(true)) {
                            String str7 = "getWriteCharacteristic failed, uuid " + str4;
                            String str8 = str7;
                            if (str8 != null && str8.length() != 0) {
                                Pair<String, String> trace2 = logger3.getTrace(depth3);
                                String strComponent5 = trace2.component1();
                                String strComponent6 = trace2.component2();
                                FileLog fileLog2 = FileLog.INSTANCE;
                                String str9 = logger3.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                FileLog.print$default(fileLog2, 6, str9, tag3, str7 + StringUtils.SPACE + strComponent6, null, 16, null);
                                if (logger3.isDebug()) {
                                    Log.e(tag3 + strComponent5, str7 + StringUtils.SPACE + strComponent6);
                                }
                            }
                        }
                        throw new GetWriteCharacteristicException("getWriteCharacteristic failed!serviceUUID:" + str5 + ",writeUUID:" + str4);
                    }
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.this$0.getLastTime().get();
                    this.this$0.getLastTime().set(System.currentTimeMillis());
                    long j = this.$operateInterval;
                    long j2 = jCurrentTimeMillis - j;
                    long jMin = j2 > 0 ? 0L : Math.min(-j2, j);
                    if (jMin > 0) {
                        this.L$0 = writeCharacteristic;
                        this.label = 1;
                        if (DelayKt.delay(jMin, this) != coroutine_suspended) {
                            bluetoothGattCharacteristic = writeCharacteristic;
                        }
                        return coroutine_suspended;
                    }
                    writeType = this.this$0.getWriteType(writeCharacteristic);
                    this.this$0.printWriterLog(this.$command, this.$byteArray);
                    if (Build.VERSION.SDK_INT >= 33) {
                        Ref.IntRef intRef3 = new Ref.IntRef();
                        intRef3.element = -1;
                        bluetoothGattCharacteristic2 = writeCharacteristic;
                        intRef = new Ref.IntRef();
                        intRef2 = intRef3;
                        i = writeType;
                        while (intRef.element < 3) {
                            intRef.element++;
                            bluetoothGatt2 = this.this$0.bluetoothGatt;
                            if (bluetoothGatt2 != null) {
                                iWriteCharacteristic = bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristic2, this.$byteArray, i);
                            } else {
                                iWriteCharacteristic = i3;
                            }
                            intRef2.element = iWriteCharacteristic;
                            if (intRef2.element != 201) {
                                break;
                                break;
                            }
                            this.L$0 = bluetoothGattCharacteristic2;
                            this.L$1 = intRef2;
                            this.L$2 = intRef;
                            this.I$0 = i;
                            this.label = i4;
                            if (DelayKt.delay(5L, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        if (intRef2.element != 0) {
                            logger = Logger.INSTANCE;
                            xCommand = this.$command;
                            str = this.$writeUUID;
                            tag = logger.getTAG();
                            depth = logger.getDepth();
                            if (logger.isCanLogger(true)) {
                                str2 = "flush error, count:" + intRef.element + " code=" + intRef2.element + ",command=" + xCommand + ",writeUUID=" + str;
                                str3 = str2;
                                if (str3 != null) {
                                    Pair<String, String> trace3 = logger.getTrace(depth);
                                    strComponent1 = trace3.component1();
                                    strComponent2 = trace3.component2();
                                    FileLog fileLog3 = FileLog.INSTANCE;
                                    String str10 = logger.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                                    FileLog.print$default(fileLog3, 6, str10, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                                    if (logger.isDebug()) {
                                        Log.e(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                                    }
                                }
                            }
                        }
                        if (intRef2.element == 0) {
                            zWriteCharacteristic = true;
                        } else {
                            zWriteCharacteristic = false;
                        }
                    } else {
                        writeCharacteristic.setWriteType(writeType);
                        writeCharacteristic.setValue(this.$byteArray);
                        bluetoothGatt = this.this$0.bluetoothGatt;
                        if (bluetoothGatt != null) {
                            zWriteCharacteristic = bluetoothGatt.writeCharacteristic(writeCharacteristic);
                        } else {
                            zWriteCharacteristic = false;
                        }
                    }
                    return Boxing.boxBoolean(zWriteCharacteristic);
                }
                Logger logger4 = Logger.INSTANCE;
                String tag4 = logger4.getTAG();
                int depth4 = logger4.getDepth();
                if (logger4.isCanLogger(true) && "check BLUETOOTH_CONNECT permission failed!".length() != 0) {
                    Pair<String, String> trace4 = logger4.getTrace(depth4);
                    String strComponent7 = trace4.component1();
                    String strComponent8 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str11 = logger4.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                    FileLog.print$default(fileLog4, 3, str11, tag4, "check BLUETOOTH_CONNECT permission failed! " + strComponent8, null, 16, null);
                    if (logger4.isDebug()) {
                        Log.i(tag4 + strComponent7, "check BLUETOOTH_CONNECT permission failed! " + strComponent8);
                    }
                }
                throw new NoBlePermissionException("no BLUETOOTH_CONNECT permission");
            }
            if (i2 == 1) {
                bluetoothGattCharacteristic = (BluetoothGattCharacteristic) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                intRef = (Ref.IntRef) this.L$2;
                intRef2 = (Ref.IntRef) this.L$1;
                bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Exception e) {
                    Logger logger5 = Logger.INSTANCE;
                    String tag5 = logger5.getTAG();
                    int depth5 = logger5.getDepth();
                    if (logger5.isCanLogger(true)) {
                        String str12 = "flush error count:" + intRef.element + StringUtils.SPACE + e;
                        String str13 = str12;
                        if (str13 != null && str13.length() != 0) {
                            Pair<String, String> trace5 = logger5.getTrace(depth5);
                            String strComponent9 = trace5.component1();
                            String strComponent10 = trace5.component2();
                            FileLog fileLog5 = FileLog.INSTANCE;
                            String str14 = logger5.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                            FileLog.print$default(fileLog5, 5, str14, tag5, str12 + StringUtils.SPACE + strComponent10, null, 16, null);
                            if (logger5.isDebug()) {
                                Log.w(tag5 + strComponent9, str12 + StringUtils.SPACE + strComponent10);
                            }
                        }
                    }
                    i3 = -1;
                    i4 = 2;
                }
            }
            while (intRef.element < 3) {
                intRef.element++;
                bluetoothGatt2 = this.this$0.bluetoothGatt;
                if (bluetoothGatt2 != null) {
                    iWriteCharacteristic = bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristic2, this.$byteArray, i);
                } else {
                    iWriteCharacteristic = i3;
                }
                intRef2.element = iWriteCharacteristic;
                if (intRef2.element != 201) {
                    break;
                }
                this.L$0 = bluetoothGattCharacteristic2;
                this.L$1 = intRef2;
                this.L$2 = intRef;
                this.I$0 = i;
                this.label = i4;
                if (DelayKt.delay(5L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            if (intRef2.element != 0) {
                logger = Logger.INSTANCE;
                xCommand = this.$command;
                str = this.$writeUUID;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str2 = "flush error, count:" + intRef.element + " code=" + intRef2.element + ",command=" + xCommand + ",writeUUID=" + str;
                    str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        Pair<String, String> trace6 = logger.getTrace(depth);
                        strComponent1 = trace6.component1();
                        strComponent2 = trace6.component2();
                        FileLog fileLog6 = FileLog.INSTANCE;
                        String str15 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                        FileLog.print$default(fileLog6, 6, str15, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.e(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
            }
            if (intRef2.element == 0) {
                zWriteCharacteristic = true;
            } else {
                zWriteCharacteristic = false;
            }
            return Boxing.boxBoolean(zWriteCharacteristic);
            writeCharacteristic = bluetoothGattCharacteristic;
            writeType = this.this$0.getWriteType(writeCharacteristic);
            this.this$0.printWriterLog(this.$command, this.$byteArray);
            if (Build.VERSION.SDK_INT >= 33) {
                Ref.IntRef intRef4 = new Ref.IntRef();
                intRef4.element = -1;
                bluetoothGattCharacteristic2 = writeCharacteristic;
                intRef = new Ref.IntRef();
                intRef2 = intRef4;
                i = writeType;
                while (intRef.element < 3) {
                    intRef.element++;
                    bluetoothGatt2 = this.this$0.bluetoothGatt;
                    if (bluetoothGatt2 != null) {
                        iWriteCharacteristic = bluetoothGatt2.writeCharacteristic(bluetoothGattCharacteristic2, this.$byteArray, i);
                    } else {
                        iWriteCharacteristic = i3;
                    }
                    intRef2.element = iWriteCharacteristic;
                    if (intRef2.element != 201) {
                        break;
                        break;
                    }
                    this.L$0 = bluetoothGattCharacteristic2;
                    this.L$1 = intRef2;
                    this.L$2 = intRef;
                    this.I$0 = i;
                    this.label = i4;
                    if (DelayKt.delay(5L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                if (intRef2.element != 0) {
                    logger = Logger.INSTANCE;
                    xCommand = this.$command;
                    str = this.$writeUUID;
                    tag = logger.getTAG();
                    depth = logger.getDepth();
                    if (logger.isCanLogger(true)) {
                        str2 = "flush error, count:" + intRef.element + " code=" + intRef2.element + ",command=" + xCommand + ",writeUUID=" + str;
                        str3 = str2;
                        if (str3 != null) {
                            Pair<String, String> trace7 = logger.getTrace(depth);
                            strComponent1 = trace7.component1();
                            strComponent2 = trace7.component2();
                            FileLog fileLog7 = FileLog.INSTANCE;
                            String str16 = logger.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str16, "format(...)");
                            FileLog.print$default(fileLog7, 6, str16, tag, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger.isDebug()) {
                                Log.e(tag + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                }
                if (intRef2.element == 0) {
                    zWriteCharacteristic = true;
                } else {
                    zWriteCharacteristic = false;
                }
            } else {
                writeCharacteristic.setWriteType(writeType);
                writeCharacteristic.setValue(this.$byteArray);
                bluetoothGatt = this.this$0.bluetoothGatt;
                if (bluetoothGatt != null) {
                    zWriteCharacteristic = bluetoothGatt.writeCharacteristic(writeCharacteristic);
                } else {
                    zWriteCharacteristic = false;
                }
            }
            return Boxing.boxBoolean(zWriteCharacteristic);
        }
    }

    public final Object write(XCommand xCommand, String str, String str2, byte[] bArr, long j, Continuation<? super Boolean> continuation) {
        return this.executor.submit(new C08882(str2, str, this, j, xCommand, bArr, null), continuation);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public boolean isNeedBound() {
        if (isBtConnector()) {
            return false;
        }
        isLeAudioConnector();
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:42:0x0098  */
    /* JADX WARN: Code duplicated, block: B:45:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    static /* synthetic */ Object isConnected$suspendImpl(XBaseBleConnector xBaseBleConnector, boolean z, Continuation<? super Boolean> continuation) {
        C08801 c08801;
        boolean z2;
        if (continuation instanceof C08801) {
            c08801 = (C08801) continuation;
            if ((c08801.label & Integer.MIN_VALUE) != 0) {
                c08801.label -= Integer.MIN_VALUE;
            } else {
                c08801 = xBaseBleConnector.new C08801(continuation);
            }
        } else {
            c08801 = xBaseBleConnector.new C08801(continuation);
        }
        Object objIsRelationConnected = c08801.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08801.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objIsRelationConnected);
            c08801.L$0 = xBaseBleConnector;
            c08801.Z$0 = z;
            c08801.label = 1;
            objIsRelationConnected = xBaseBleConnector.isRelationConnected(z, c08801);
            if (objIsRelationConnected == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z = c08801.Z$0;
            xBaseBleConnector = (XBaseBleConnector) c08801.L$0;
            ResultKt.throwOnFailure(objIsRelationConnected);
        }
        if (!((Boolean) objIsRelationConnected).booleanValue()) {
            return Boxing.boxBoolean(false);
        }
        XBluetoothDevice mBleDevice = xBaseBleConnector.getMBleDevice();
        BluetoothDevice deviceInfo = mBleDevice != null ? mBleDevice.getDeviceInfo() : null;
        if (!BleUtil.INSTANCE.checkBluetoothPermissions()) {
            return Boxing.boxBoolean(false);
        }
        if (xBaseBleConnector.bluetoothGatt == null) {
            return Boxing.boxBoolean(false);
        }
        if (z) {
            BluetoothManager bluetoothManager = xBaseBleConnector.getMXBluetoothManager().getBluetoothManager();
            Integer numBoxInt = bluetoothManager != null ? Boxing.boxInt(bluetoothManager.getConnectionState(deviceInfo, 7)) : null;
            if (numBoxInt != null && numBoxInt.intValue() == 2) {
                if (xBaseBleConnector.getLastState().get() == 2) {
                }
            }
        } else {
            z2 = xBaseBleConnector.getLastState().get() == 2;
        }
        return Boxing.boxBoolean(z2);
    }

    public final boolean isGattConnected() {
        if (!BleUtil.INSTANCE.checkBluetoothPermissions()) {
            return false;
        }
        BluetoothManager bluetoothManager = getMXBluetoothManager().getBluetoothManager();
        Integer numValueOf = null;
        if (bluetoothManager != null) {
            XBluetoothDevice mBleDevice = getMBleDevice();
            numValueOf = Integer.valueOf(bluetoothManager.getConnectionState(mBleDevice != null ? mBleDevice.getDeviceInfo() : null, 7));
        }
        return numValueOf != null && numValueOf.intValue() == 2;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public XConnectType getConnectorType() {
        return XConnectType.BLE.INSTANCE;
    }

    public final void onDisconnected(int status, int newState) {
        XConnectFailType xConnectFailType = status == 133 ? XConnectFailType.DeviceBusy.INSTANCE : XConnectFailType.Unknown.INSTANCE;
        int i = getLastState().get();
        if (i == -1 || i == 1) {
            onBleDisconnected$default(this, "status:" + status + " newState:" + newState + " listener gatt disconnect,when connecting", null, xConnectFailType, 2, null);
            return;
        }
        if (i == 4) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "status:" + status + " newState:" + newState + " After the connection fails, the device triggers a disconnection";
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
        onBleDisconnected$default(this, "status:" + status + " newState:" + newState + " system call back disconnected!", null, xConnectFailType, 2, null);
    }

    public static /* synthetic */ Object enableCharacteristicNotify$default(XBaseBleConnector xBaseBleConnector, String str, String str2, boolean z, String str3, boolean z2, Continuation continuation, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableCharacteristicNotify");
        }
        if ((i & 8) != 0) {
            str3 = null;
        }
        String str4 = str3;
        if ((i & 16) != 0) {
            z2 = false;
        }
        return xBaseBleConnector.enableCharacteristicNotify(str, str2, z, str4, z2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0136  */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    public final Object enableCharacteristicNotify(String str, String str2, boolean z, String str3, boolean z2, Continuation<? super Boolean> continuation) {
        C08781 c08781;
        CharSequence charSequence;
        boolean z3;
        String str4;
        String str5;
        XBaseBleConnector xBaseBleConnector;
        String str6 = str;
        String str7 = str2;
        boolean z4 = z;
        boolean z5 = z2;
        if (continuation instanceof C08781) {
            c08781 = (C08781) continuation;
            if ((c08781.label & Integer.MIN_VALUE) != 0) {
                c08781.label -= Integer.MIN_VALUE;
            } else {
                c08781 = new C08781(continuation);
            }
        } else {
            c08781 = new C08781(continuation);
        }
        Object obj = c08781.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08781.label;
        String str8 = "getNotifyCharacteristic failed! no permission or characteristic is null! ";
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (z5) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    z3 = false;
                    String str9 = getStepStatus(4) + " getNotifyCharacteristic notifyUUID=" + str7 + ",serviceUUID=" + str6;
                    String str10 = str9;
                    if (str10 == null || str10.length() == 0) {
                        charSequence = "getNotifyCharacteristic failed! no permission or characteristic is null!";
                    } else {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        charSequence = "getNotifyCharacteristic failed! no permission or characteristic is null!";
                        String str11 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str11, "format(...)");
                        FileLog.print$default(fileLog, 3, str11, tag, str9 + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str9 + StringUtils.SPACE + strComponent2);
                        }
                    }
                } else {
                    charSequence = "getNotifyCharacteristic failed! no permission or characteristic is null!";
                    z3 = false;
                }
            } else {
                charSequence = "getNotifyCharacteristic failed! no permission or characteristic is null!";
                z3 = false;
            }
            BluetoothGattCharacteristic notifyCharacteristic = getNotifyCharacteristic(str, str2);
            if (notifyCharacteristic != null) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    if (z5) {
                        str4 = getStepStatus(5) + " setCharacteristicNotification";
                    } else {
                        str4 = "setCharacteristicNotification " + z4 + " ,device:" + getMBleDevice();
                    }
                    String str12 = str4;
                    if (str12 != null && str12.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str13 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                        FileLog.print$default(fileLog2, 3, str13, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        }
                    }
                } else {
                    str8 = "getNotifyCharacteristic failed! no permission or characteristic is null! ";
                }
                try {
                    BluetoothGatt bluetoothGatt = this.bluetoothGatt;
                    Boolean boolBoxBoolean = bluetoothGatt != null ? Boxing.boxBoolean(bluetoothGatt.setCharacteristicNotification(notifyCharacteristic, z4)) : null;
                    Logger logger3 = Logger.INSTANCE;
                    String tag3 = logger3.getTAG();
                    int depth3 = logger3.getDepth();
                    if (logger3.isCanLogger(true)) {
                        String str14 = "setCharacteristicNotification success=" + boolBoxBoolean + ",device:" + getMBleDevice();
                        String str15 = str14;
                        if (str15 != null && str15.length() != 0) {
                            Pair<String, String> trace3 = logger3.getTrace(depth3);
                            String strComponent5 = trace3.component1();
                            String strComponent6 = trace3.component2();
                            FileLog fileLog3 = FileLog.INSTANCE;
                            String str16 = logger3.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str16, "format(...)");
                            FileLog.print$default(fileLog3, 3, str16, tag3, str14 + StringUtils.SPACE + strComponent6, null, 16, null);
                            if (logger3.isDebug()) {
                                Log.i(tag3 + strComponent5, str14 + StringUtils.SPACE + strComponent6);
                            }
                        }
                    }
                } catch (SecurityException e) {
                    Logger logger4 = Logger.INSTANCE;
                    String tag4 = logger4.getTAG();
                    int depth4 = logger4.getDepth();
                    if (logger4.isCanLogger(true)) {
                        String str17 = "SecurityException on setCharacteristicNotification, ignore: " + e.getMessage();
                        String str18 = str17;
                        if (str18 != null && str18.length() != 0) {
                            Pair<String, String> trace4 = logger4.getTrace(depth4);
                            String strComponent7 = trace4.component1();
                            String strComponent8 = trace4.component2();
                            FileLog fileLog4 = FileLog.INSTANCE;
                            String str19 = logger4.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str19, "format(...)");
                            FileLog.print$default(fileLog4, 3, str19, tag4, str17 + StringUtils.SPACE + strComponent8, null, 16, null);
                            if (logger4.isDebug()) {
                                Log.i(tag4 + strComponent7, str17 + StringUtils.SPACE + strComponent8);
                            }
                        }
                    }
                } catch (Exception e2) {
                    Logger logger5 = Logger.INSTANCE;
                    String tag5 = logger5.getTAG();
                    int depth5 = logger5.getDepth();
                    if (logger5.isCanLogger(true)) {
                        String str20 = "Exception on setCharacteristicNotification, ignore: " + e2.getMessage();
                        String str21 = str20;
                        if (str21 != null && str21.length() != 0) {
                            Pair<String, String> trace5 = logger5.getTrace(depth5);
                            String strComponent9 = trace5.component1();
                            String strComponent10 = trace5.component2();
                            FileLog fileLog5 = FileLog.INSTANCE;
                            String str22 = logger5.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str22, "format(...)");
                            FileLog.print$default(fileLog5, 3, str22, tag5, str20 + StringUtils.SPACE + strComponent10, null, 16, null);
                            if (logger5.isDebug()) {
                                Log.i(tag5 + strComponent9, str20 + StringUtils.SPACE + strComponent10);
                            }
                        }
                    }
                }
                c08781.L$0 = this;
                c08781.L$1 = str6;
                c08781.L$2 = str7;
                str5 = str3;
                c08781.L$3 = str5;
                c08781.Z$0 = z4;
                c08781.Z$1 = z5;
                c08781.label = 1;
                if (DelayKt.delay(100L, c08781) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                xBaseBleConnector = this;
            } else {
                Logger logger6 = Logger.INSTANCE;
                String tag6 = logger6.getTAG();
                int depth6 = logger6.getDepth();
                if (logger6.isCanLogger(true) && charSequence.length() != 0) {
                    Pair<String, String> trace6 = logger6.getTrace(depth6);
                    String strComponent11 = trace6.component1();
                    String strComponent12 = trace6.component2();
                    FileLog fileLog6 = FileLog.INSTANCE;
                    String str23 = logger6.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str23, "format(...)");
                    FileLog.print$default(fileLog6, 3, str23, tag6, "getNotifyCharacteristic failed! no permission or characteristic is null! " + strComponent12, null, 16, null);
                    if (logger6.isDebug()) {
                        Log.i(tag6 + strComponent11, "getNotifyCharacteristic failed! no permission or characteristic is null! " + strComponent12);
                    }
                }
            }
            return Boxing.boxBoolean(z3);
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean z6 = c08781.Z$1;
        boolean z7 = c08781.Z$0;
        String str24 = (String) c08781.L$3;
        String str25 = (String) c08781.L$2;
        String str26 = (String) c08781.L$1;
        xBaseBleConnector = (XBaseBleConnector) c08781.L$0;
        ResultKt.throwOnFailure(obj);
        z5 = z6;
        str6 = str26;
        str5 = str24;
        z4 = z7;
        str7 = str25;
        charSequence = "getNotifyCharacteristic failed! no permission or characteristic is null!";
        str8 = "getNotifyCharacteristic failed! no permission or characteristic is null! ";
        z3 = false;
        String str27 = str5;
        if (str27 == null || str27.length() == 0) {
            str5 = Constants.UUID_CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR;
        }
        if (z5) {
            Logger logger7 = Logger.INSTANCE;
            String tag7 = logger7.getTAG();
            int depth7 = logger7.getDepth();
            if (logger7.isCanLogger(true)) {
                String str28 = xBaseBleConnector.getStepStatus(6) + " notifyWriteDescriptor UUID=" + str5;
                String str29 = str28;
                if (str29 != null && str29.length() != 0) {
                    Pair<String, String> trace7 = logger7.getTrace(depth7);
                    String strComponent13 = trace7.component1();
                    String strComponent14 = trace7.component2();
                    FileLog fileLog7 = FileLog.INSTANCE;
                    String str30 = logger7.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str30, "format(...)");
                    FileLog.print$default(fileLog7, 3, str30, tag7, str28 + StringUtils.SPACE + strComponent14, null, 16, null);
                    if (logger7.isDebug()) {
                        Log.i(tag7 + strComponent13, str28 + StringUtils.SPACE + strComponent14);
                    }
                }
            }
        }
        BluetoothGattCharacteristic notifyCharacteristic2 = xBaseBleConnector.getNotifyCharacteristic(str6, str7);
        BluetoothGattDescriptor descriptor = notifyCharacteristic2 != null ? notifyCharacteristic2.getDescriptor(UUID.fromString(str5)) : null;
        if (descriptor == null) {
            Logger logger8 = Logger.INSTANCE;
            String tag8 = logger8.getTAG();
            int depth8 = logger8.getDepth();
            if (logger8.isCanLogger(true) && charSequence.length() != 0) {
                Pair<String, String> trace8 = logger8.getTrace(depth8);
                String strComponent15 = trace8.component1();
                String strComponent16 = trace8.component2();
                FileLog fileLog8 = FileLog.INSTANCE;
                String str31 = logger8.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str31, "format(...)");
                String str32 = str8;
                FileLog.print$default(fileLog8, 3, str31, tag8, str32 + strComponent16, null, 16, null);
                if (logger8.isDebug()) {
                    Log.i(tag8 + strComponent15, str32 + strComponent16);
                }
            }
            return Boxing.boxBoolean(z3);
        }
        int iNotifyWriteDescriptor = xBaseBleConnector.notifyWriteDescriptor(descriptor, z4);
        if (iNotifyWriteDescriptor == 0) {
            return Boxing.boxBoolean(true);
        }
        Logger logger9 = Logger.INSTANCE;
        String tag9 = logger9.getTAG();
        int depth9 = logger9.getDepth();
        if (logger9.isCanLogger(true)) {
            String str33 = "writeDescriptor enable:" + z4 + ",failed! descriptor = " + descriptor + "  " + iNotifyWriteDescriptor;
            String str34 = str33;
            if (str34 != null && str34.length() != 0) {
                Pair<String, String> trace9 = logger9.getTrace(depth9);
                String strComponent17 = trace9.component1();
                String strComponent18 = trace9.component2();
                FileLog fileLog9 = FileLog.INSTANCE;
                String str35 = logger9.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str35, "format(...)");
                FileLog.print$default(fileLog9, 3, str35, tag9, str33 + StringUtils.SPACE + strComponent18, null, 16, null);
                if (logger9.isDebug()) {
                    Log.i(tag9 + strComponent17, str33 + StringUtils.SPACE + strComponent18);
                }
            }
        }
        return Boxing.boxBoolean(z3);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onDescriptorRead(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status, byte[] value) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        String str = Constants.CHECK_NOTIFY_ID + descriptor.getUuid();
        if (status == 0) {
            if (Arrays.equals(value, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE)) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str2 = "onDescriptorRead descriptor:" + descriptor + ",status:" + status + ",enable " + descriptor.getUuid();
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
                this.commonTask.cancelTaskByCommand(str, true);
                return;
            }
            if (Arrays.equals(value, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str5 = "onDescriptorRead descriptor:" + descriptor + ",status:" + status + ",disable " + descriptor.getUuid();
                    String str6 = str5;
                    if (str6 != null && str6.length() != 0) {
                        Pair<String, String> trace2 = logger2.getTrace(depth2);
                        String strComponent3 = trace2.component1();
                        String strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str7 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                        FileLog.print$default(fileLog2, 3, str7, tag2, str5 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str5 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                this.commonTask.cancelTaskByCommand(str, false);
                return;
            }
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String str8 = "onDescriptorRead descriptor:" + descriptor + ",status:" + status + ",value error " + descriptor.getUuid();
                String str9 = str8;
                if (str9 == null || str9.length() == 0) {
                    return;
                }
                Pair<String, String> trace3 = logger3.getTrace(depth3);
                String strComponent5 = trace3.component1();
                String strComponent6 = trace3.component2();
                FileLog fileLog3 = FileLog.INSTANCE;
                String str10 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                FileLog.print$default(fileLog3, 3, str10, tag3, str8 + StringUtils.SPACE + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, str8 + StringUtils.SPACE + strComponent6);
                    return;
                }
                return;
            }
            return;
        }
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true)) {
            String str11 = "onDescriptorRead descriptor:" + descriptor + ",status:" + status + StringUtils.SPACE + descriptor.getUuid();
            String str12 = str11;
            if (str12 != null && str12.length() != 0) {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str13 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                FileLog.print$default(fileLog4, 3, str13, tag4, str11 + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, str11 + StringUtils.SPACE + strComponent8);
                }
            }
        }
        this.commonTask.cancelTaskByCommand(str, false);
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onDescriptorWrite descriptor:" + descriptor + ",status:" + status + " ," + (descriptor != null ? descriptor.getUuid() : null);
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
        this.commonTask.cancelTaskByCommand(Constants.NOTIFY_ID + (descriptor != null ? descriptor.getUuid() : null), status == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkNotificationStatus(String serviceUUID, String notifyUUID) {
        BluetoothGattDescriptor descriptor;
        BluetoothGatt bluetoothGatt;
        BluetoothGattCharacteristic notifyCharacteristic = getNotifyCharacteristic(serviceUUID, notifyUUID);
        if (notifyCharacteristic == null || (descriptor = notifyCharacteristic.getDescriptor(UUID.fromString(Constants.UUID_CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR))) == null || (bluetoothGatt = this.bluetoothGatt) == null) {
            return false;
        }
        return bluetoothGatt.readDescriptor(descriptor);
    }

    public final void checkCharacteristicNotifyWithTask(String serviceUUID, String notifyUUID, long interval, Function1<? super XCommonTaskCallback, Unit> callback) {
        Intrinsics.checkNotNullParameter(serviceUUID, "serviceUUID");
        Intrinsics.checkNotNullParameter(notifyUUID, "notifyUUID");
        Intrinsics.checkNotNullParameter(callback, "callback");
        XCommonTaskCallback xCommonTaskCallback = new XCommonTaskCallback();
        callback.invoke(xCommonTaskCallback);
        String str = "check-notify-00002902-0000-1000-8000-00805f9b34fb";
        long j = 5000;
        boolean z = true;
        boolean z2 = true;
        this.commonTask.addTask(new XCommonTask(str, j, interval, z, z2, new AnonymousClass1(serviceUUID, notifyUUID, null), xCommonTaskCallback, getMBleDevice(), null, true, 256, null));
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$checkCharacteristicNotifyWithTask$1, reason: invalid class name */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/nothing/link/bluetooth/sdk/task/XCommonTask;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$checkCharacteristicNotifyWithTask$1", f = "XBaseBleConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<XCommonTask, Continuation<? super Boolean>, Object> {
        final /* synthetic */ String $notifyUUID;
        final /* synthetic */ String $serviceUUID;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$serviceUUID = str;
            this.$notifyUUID = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new AnonymousClass1(this.$serviceUUID, this.$notifyUUID, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(XCommonTask xCommonTask, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(xCommonTask, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                return Boxing.boxBoolean(XBaseBleConnector.this.checkNotificationStatus(this.$serviceUUID, this.$notifyUUID));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void enableCharacteristicNotifyWithTask$default(XBaseBleConnector xBaseBleConnector, String str, String str2, boolean z, long j, Function1 function1, String str3, boolean z2, String str4, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: enableCharacteristicNotifyWithTask");
        }
        xBaseBleConnector.enableCharacteristicNotifyWithTask(str, str2, z, j, function1, (i & 32) != 0 ? null : str3, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? "" : str4);
    }

    public final void enableCharacteristicNotifyWithTask(String serviceUUID, String notifyUUID, boolean enable, long interval, Function1<? super XCommonTaskCallback, Unit> callback, String uuidDescriptor, boolean isConnectFlow, String tag) {
        Intrinsics.checkNotNullParameter(serviceUUID, "serviceUUID");
        Intrinsics.checkNotNullParameter(notifyUUID, "notifyUUID");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(tag, "tag");
        XCommonTaskCallback xCommonTaskCallback = new XCommonTaskCallback();
        callback.invoke(xCommonTaskCallback);
        this.commonTask.addTask(new XCommonTask(tag + "notify-00002902-0000-1000-8000-00805f9b34fb", 5000L, interval, true, false, new C08791(serviceUUID, notifyUUID, enable, uuidDescriptor, isConnectFlow, null), xCommonTaskCallback, getMBleDevice(), null, true, 272, null));
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$enableCharacteristicNotifyWithTask$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lcom/nothing/link/bluetooth/sdk/task/XCommonTask;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$enableCharacteristicNotifyWithTask$1", f = "XBaseBleConnector.kt", i = {}, l = {1018}, m = "invokeSuspend", n = {}, s = {})
    static final class C08791 extends SuspendLambda implements Function2<XCommonTask, Continuation<? super Boolean>, Object> {
        final /* synthetic */ boolean $enable;
        final /* synthetic */ boolean $isConnectFlow;
        final /* synthetic */ String $notifyUUID;
        final /* synthetic */ String $serviceUUID;
        final /* synthetic */ String $uuidDescriptor;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08791(String str, String str2, boolean z, String str3, boolean z2, Continuation<? super C08791> continuation) {
            super(2, continuation);
            this.$serviceUUID = str;
            this.$notifyUUID = str2;
            this.$enable = z;
            this.$uuidDescriptor = str3;
            this.$isConnectFlow = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new C08791(this.$serviceUUID, this.$notifyUUID, this.$enable, this.$uuidDescriptor, this.$isConnectFlow, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(XCommonTask xCommonTask, Continuation<? super Boolean> continuation) {
            return ((C08791) create(xCommonTask, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object objEnableCharacteristicNotify = XBaseBleConnector.this.enableCharacteristicNotify(this.$serviceUUID, this.$notifyUUID, this.$enable, this.$uuidDescriptor, this.$isConnectFlow, this);
            return objEnableCharacteristicNotify == coroutine_suspended ? coroutine_suspended : objEnableCharacteristicNotify;
        }
    }

    private final BluetoothGattCharacteristic getNotifyCharacteristic(String serviceUUID, String notifyUUID) {
        BluetoothGatt bluetoothGatt = this.bluetoothGatt;
        BluetoothGattService service = bluetoothGatt != null ? bluetoothGatt.getService(UUID.fromString(serviceUUID)) : null;
        BluetoothGattCharacteristic characteristic = service != null ? service.getCharacteristic(UUID.fromString(notifyUUID)) : null;
        if (characteristic == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "getNotifyCharacteristic is null,serviceUUID:" + serviceUUID + ",notifyUUID:" + notifyUUID;
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
            return null;
        }
        if (isCanNotify(characteristic)) {
            return characteristic;
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "getNotifyCharacteristic uuid:" + notifyUUID + "," + getOperateType(characteristic) + " can't support notify!";
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
        return null;
    }

    private final String getOperateType(BluetoothGattCharacteristic characteristic) {
        StringBuilder sb = new StringBuilder();
        int properties = characteristic.getProperties();
        if ((properties & 2) != 0) {
            sb.append("Read , ");
        }
        if ((properties & 8) != 0) {
            sb.append("Write , ");
        }
        if ((properties & 4) != 0) {
            sb.append("Write No Response , ");
        }
        if ((properties & 16) != 0) {
            sb.append("Notify , ");
        }
        if ((properties & 32) != 0) {
            sb.append("Indicate , ");
        }
        if (sb.length() > 1) {
            sb.delete(sb.length() - 2, sb.length() - 1);
        }
        if (sb.length() > 0) {
            String string = sb.toString();
            Intrinsics.checkNotNull(string);
            return string;
        }
        return "";
    }

    private final boolean isCanNotify(BluetoothGattCharacteristic characteristic) {
        return (characteristic.getProperties() & 16) != 0;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0041  */
    private final int notifyWriteDescriptor(BluetoothGattDescriptor descriptor, boolean enable) {
        int iValueOf;
        Integer num = -1;
        try {
            if (Build.VERSION.SDK_INT < 33) {
                descriptor.setValue(enable ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                BluetoothGatt bluetoothGatt = this.bluetoothGatt;
                if (Intrinsics.areEqual((Object) (bluetoothGatt != null ? Boolean.valueOf(bluetoothGatt.writeDescriptor(descriptor)) : null), (Object) true)) {
                    iValueOf = 0;
                    num = iValueOf;
                }
            } else if (!BleUtil.INSTANCE.checkPermission("android.permission.BLUETOOTH_CONNECT")) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true) && "notifyWriteDescriptor no permission".length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    FileLog.print$default(fileLog, 3, str, tag, "notifyWriteDescriptor no permission " + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, "notifyWriteDescriptor no permission " + strComponent2);
                    }
                }
            } else if (enable) {
                BluetoothGatt bluetoothGatt2 = this.bluetoothGatt;
                if (bluetoothGatt2 != null) {
                    iValueOf = Integer.valueOf(bluetoothGatt2.writeDescriptor(descriptor, BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE));
                    num = iValueOf;
                } else {
                    num = null;
                }
            } else {
                BluetoothGatt bluetoothGatt3 = this.bluetoothGatt;
                if (bluetoothGatt3 != null) {
                    iValueOf = Integer.valueOf(bluetoothGatt3.writeDescriptor(descriptor, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE));
                    num = iValueOf;
                } else {
                    num = null;
                }
            }
        } catch (Exception e) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str2 = "error writeDescriptor " + e;
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
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onCharacteristicRead(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] value, int status) {
        Intrinsics.checkNotNullParameter(gatt, "gatt");
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(value, "value");
        if (status == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "onCharacteristicRead success " + BleUtil.bytesToHex$default(BleUtil.INSTANCE, value, false, 2, null) + " ," + characteristic.getUuid();
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
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "onCharacteristicRead failed " + BleUtil.bytesToHex$default(BleUtil.INSTANCE, value, false, 2, null) + " ," + characteristic.getUuid();
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

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onCharacteristicWrite(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, int status) {
        String string;
        XWriteCallback writeCallback;
        UUID uuid;
        if (characteristic == null || (uuid = characteristic.getUuid()) == null || (string = uuid.toString()) == null) {
            string = "";
        }
        if (string.length() == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "onCharacteristicWrite uuid is null, " + characteristic;
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
        XTaskList taskList = getTaskQueue(string).getTaskList();
        XTask xTaskFirstFlushing = taskList.firstFlushing();
        if (xTaskFirstFlushing == null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "onCharacteristicWrite task is null, " + taskList;
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
                    return;
                }
                return;
            }
            return;
        }
        if (status == 0) {
            if (xTaskFirstFlushing.getMockResponse() != null || xTaskFirstFlushing.getSuccessWithComplete()) {
                xTaskFirstFlushing.setSuccess();
                Job taskJob = xTaskFirstFlushing.getTaskJob();
                if (taskJob != null) {
                    taskJob.cancel((CancellationException) new CompleteException("ble done"));
                }
                getTaskQueue(string).getTaskList().remove(xTaskFirstFlushing);
                getTaskQueue(string).autoRunNextTask(xTaskFirstFlushing);
                XWriteCallback writeCallback2 = xTaskFirstFlushing.getWriteCallback();
                if (writeCallback2 != null) {
                    XBluetoothDevice mBleDevice = getMBleDevice();
                    int currentPackage = xTaskFirstFlushing.getCurrentPackage();
                    int totalPackage = xTaskFirstFlushing.getTotalPackage();
                    byte[] mockResponse = xTaskFirstFlushing.getMockResponse();
                    if (mockResponse == null) {
                        mockResponse = new byte[0];
                    }
                    writeCallback2.callWriteSuccess(mBleDevice, currentPackage, totalPackage, mockResponse);
                }
                if (xTaskFirstFlushing.getCurrentPackage() != xTaskFirstFlushing.getTotalPackage() || (writeCallback = xTaskFirstFlushing.getWriteCallback()) == null) {
                    return;
                }
                writeCallback.callWriteComplete(xTaskFirstFlushing.getDevice(), true);
                return;
            }
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true)) {
                String packageLog = xTaskFirstFlushing.getPackageLog("write success callback ,waiting!");
                String str7 = packageLog;
                if (str7 != null && str7.length() != 0) {
                    Pair<String, String> trace3 = logger3.getTrace(depth3);
                    String strComponent5 = trace3.component1();
                    String strComponent6 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str8 = logger3.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    FileLog.print$default(fileLog3, 3, str8, tag3, packageLog + StringUtils.SPACE + strComponent6, null, 16, null);
                    if (logger3.isDebug()) {
                        Log.i(tag3 + strComponent5, packageLog + StringUtils.SPACE + strComponent6);
                    }
                }
            }
            xTaskFirstFlushing.setWaiting();
            taskList.moveToWaitList(xTaskFirstFlushing);
            getTaskQueue(string).autoRunNextTask(xTaskFirstFlushing);
            return;
        }
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true)) {
            String packageLog2 = xTaskFirstFlushing.getPackageLog("write failed,cancel job!");
            String str9 = packageLog2;
            if (str9 != null && str9.length() != 0) {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                String str10 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                FileLog.print$default(fileLog4, 4, str10, tag4, packageLog2 + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, packageLog2 + StringUtils.SPACE + strComponent8);
                }
            }
        }
        CancelException cancelException = new CancelException(xTaskFirstFlushing.getPackageLog("WRITE GATT_FAILURE:" + status));
        xTaskFirstFlushing.setFailed(cancelException);
        Job taskJob2 = xTaskFirstFlushing.getTaskJob();
        if (taskJob2 != null) {
            taskJob2.cancel((CancellationException) cancelException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:17:0x0047  */
    /* JADX WARN: Code duplicated, block: B:37:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:40:0x0110  */
    /* JADX WARN: Code duplicated, block: B:47:0x017e  */
    public final BluetoothGattCharacteristic getWriteCharacteristic(String serviceUUID, String writeUUID) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic;
        Object objM6347constructorimpl;
        Logger logger;
        String tag;
        int depth;
        String str;
        String str2;
        String strComponent1;
        String strComponent2;
        try {
            Result.Companion companion = Result.INSTANCE;
            BluetoothGatt bluetoothGatt = this.bluetoothGatt;
            BluetoothGattService service = bluetoothGatt != null ? bluetoothGatt.getService(UUID.fromString(serviceUUID)) : null;
            BluetoothGattCharacteristic characteristic = service != null ? service.getCharacteristic(UUID.fromString(writeUUID)) : null;
            if (characteristic == null) {
                return null;
            }
            Intrinsics.checkNotNull(characteristic);
            if (isCanWrite(characteristic)) {
                return characteristic;
            }
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str3 = "characteristic can't write!uuid is " + writeUUID;
                String str4 = str3;
                if (str4 == null || str4.length() == 0) {
                    bluetoothGattCharacteristic = null;
                } else {
                    Pair<String, String> trace = logger2.getTrace(depth2);
                    String strComponent3 = trace.component1();
                    String strComponent4 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str5 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    bluetoothGattCharacteristic = null;
                    try {
                        FileLog.print$default(fileLog, 3, str5, tag2, str3 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str3 + StringUtils.SPACE + strComponent4);
                        }
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion2 = Result.INSTANCE;
                        objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
                    }
                }
                objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
            } else {
                bluetoothGattCharacteristic = null;
                objM6347constructorimpl = Result.m6347constructorimpl(Unit.INSTANCE);
            }
            if (Result.m6350exceptionOrNullimpl(objM6347constructorimpl) != null) {
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str = "serviceUUID:" + serviceUUID + ",writeUUID:" + writeUUID;
                    str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace2 = logger.getTrace(depth);
                        strComponent1 = trace2.component1();
                        strComponent2 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str6 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                        FileLog.print$default(fileLog2, 6, str6, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
            }
            return bluetoothGattCharacteristic;
        } catch (Throwable th2) {
            th = th2;
            bluetoothGattCharacteristic = null;
        }
        Result.Companion companion3 = Result.INSTANCE;
        objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        if (Result.m6350exceptionOrNullimpl(objM6347constructorimpl) != null) {
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "serviceUUID:" + serviceUUID + ",writeUUID:" + writeUUID;
                str2 = str;
                if (str2 != null) {
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
        }
        return bluetoothGattCharacteristic;
    }

    private final boolean isCanWrite(BluetoothGattCharacteristic characteristic) {
        return ((characteristic.getProperties() & 8) == 0 && (characteristic.getProperties() & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getWriteType(BluetoothGattCharacteristic characteristic) {
        return (characteristic.getProperties() & 4) != 0 ? 1 : 2;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onIndicateCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic, byte[] value) {
        Intrinsics.checkNotNullParameter(characteristic, "characteristic");
        Intrinsics.checkNotNullParameter(value, "value");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onIndicateCharacteristicChanged characteristic:" + characteristic + ",value:" + BleUtil.bytesToHex$default(BleUtil.INSTANCE, value, false, 2, null);
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

    @Override // com.nothing.link.bluetooth.sdk.connect.XConnector, com.nothing.link.bluetooth.sdk.connect.XBondConnector
    public void onDestroy() {
        super.onDestroy();
        Job job = this.discoverJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onReadRemoteRssi(BluetoothGatt gatt, int rssi, int status) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onReadRemoteRssi rssi:" + rssi + ",status:" + status;
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

    @Override // com.nothing.link.bluetooth.sdk.connect.ble.BleGattCallback
    public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onMtuChanged mtu:" + mtu + ",status:" + status + " bluetoothGatt isChange " + Intrinsics.areEqual(this.bluetoothGatt, gatt);
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
        Function2<? super Integer, ? super Integer, Unit> function2 = this.mtuChangeCallback;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(mtu), Integer.valueOf(status));
        }
        BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new C08862(null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onMtuChanged$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBaseBleConnector.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$onMtuChanged$2", f = "XBaseBleConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C08862 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08862(Continuation<? super C08862> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBaseBleConnector.this.new C08862(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08862) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                BluetoothGatt bluetoothGatt = XBaseBleConnector.this.bluetoothGatt;
                BluetoothGattService service = bluetoothGatt != null ? bluetoothGatt.getService(UUID.fromString(XBaseBleConnector.this.getServiceUUID())) : null;
                if ((service != null ? service.getCharacteristic(UUID.fromString(XBaseBleConnector.this.getNotifyUUID())) : null) != null) {
                    if (XBaseBleConnector.this.getOpenNotifyChannel()) {
                        XBaseBleConnector xBaseBleConnector = XBaseBleConnector.this;
                        String serviceUUID = xBaseBleConnector.getServiceUUID();
                        String notifyUUID = XBaseBleConnector.this.getNotifyUUID();
                        final XBaseBleConnector xBaseBleConnector2 = XBaseBleConnector.this;
                        xBaseBleConnector.enableCharacteristicNotifyWithTask(serviceUUID, notifyUUID, true, 0L, new Function1<XCommonTaskCallback, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector.onMtuChanged.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(XCommonTaskCallback xCommonTaskCallback) {
                                invoke2(xCommonTaskCallback);
                                return Unit.INSTANCE;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(XCommonTaskCallback enableCharacteristicNotifyWithTask) {
                                Intrinsics.checkNotNullParameter(enableCharacteristicNotifyWithTask, "$this$enableCharacteristicNotifyWithTask");
                                final XBaseBleConnector xBaseBleConnector3 = xBaseBleConnector2;
                                enableCharacteristicNotifyWithTask.onSuccess(new Function3<XBluetoothDevice, Boolean, Object, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector.onMtuChanged.2.1.1
                                    {
                                        super(3);
                                    }

                                    @Override // kotlin.jvm.functions.Function3
                                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Boolean bool, Object obj2) {
                                        invoke(xBluetoothDevice, bool.booleanValue(), obj2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(XBluetoothDevice xBluetoothDevice, boolean z, Object data) {
                                        Intrinsics.checkNotNullParameter(data, "data");
                                        xBaseBleConnector3.cancelJobWhenConnected("enable notify success!");
                                    }
                                });
                                final XBaseBleConnector xBaseBleConnector4 = xBaseBleConnector2;
                                enableCharacteristicNotifyWithTask.onFail(new Function2<XBluetoothDevice, Throwable, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector.onMtuChanged.2.1.2
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Throwable th) {
                                        invoke2(xBluetoothDevice, th);
                                        return Unit.INSTANCE;
                                    }

                                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(XBluetoothDevice xBluetoothDevice, Throwable throwable) {
                                        Intrinsics.checkNotNullParameter(throwable, "throwable");
                                        xBaseBleConnector4.cancelJobWhenConnectedFailed(" enableCharacteristicNotify failed!");
                                    }
                                });
                            }
                        }, null, true, "connect");
                    } else {
                        XBaseBleConnector.this.cancelJobWhenConnected("ble no need open channel success!");
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void setDeviceMtuChangeCallback(Function2<? super Integer, ? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.mtuChangeCallback = callback;
    }

    public final Object scan(XBluetoothFlowCallBack xBluetoothFlowCallBack, Continuation<? super XBluetoothDevice> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        XScan xScan = this.scan;
        XBluetoothDevice mBleDevice = getMBleDevice();
        XScan.addFilterAddress$default(xScan, mBleDevice != null ? mBleDevice.getRealAddress() : null, false, 2, null);
        this.scan.filterPaired(false);
        XScan.startScan2$default(this.scan, null, null, null, new Function1<XScanCallback, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$scan$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XScanCallback xScanCallback) {
                invoke2(xScanCallback);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XScanCallback startScan2) {
                Intrinsics.checkNotNullParameter(startScan2, "$this$startScan2");
                final Ref.BooleanRef booleanRef2 = booleanRef;
                final XBaseBleConnector xBaseBleConnector = this;
                final CancellableContinuation<XBluetoothDevice> cancellableContinuation = cancellableContinuationImpl2;
                startScan2.onScanFail(new Function1<XScanFailType, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$scan$2$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(XScanFailType xScanFailType) {
                        invoke2(xScanFailType);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(XScanFailType it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        if (booleanRef2.element) {
                            return;
                        }
                        booleanRef2.element = true;
                        xBaseBleConnector.scan.stopScan();
                        if (cancellableContinuation.isActive()) {
                            CancellableContinuation<XBluetoothDevice> cancellableContinuation2 = cancellableContinuation;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m6347constructorimpl(null));
                        }
                    }
                });
                final Ref.BooleanRef booleanRef3 = booleanRef;
                final XBaseBleConnector xBaseBleConnector2 = this;
                final CancellableContinuation<XBluetoothDevice> cancellableContinuation2 = cancellableContinuationImpl2;
                startScan2.onScanResult(new Function2<XBluetoothDevice, Integer, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$scan$2$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDevice xBluetoothDevice, Integer num) {
                        invoke(xBluetoothDevice, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(XBluetoothDevice bleDevice, int i) {
                        Intrinsics.checkNotNullParameter(bleDevice, "bleDevice");
                        if (booleanRef3.element) {
                            return;
                        }
                        booleanRef3.element = true;
                        xBaseBleConnector2.scan.stopScan();
                        XBluetoothDevice mBleDevice2 = xBaseBleConnector2.getMBleDevice();
                        if (mBleDevice2 != null) {
                            mBleDevice2.copyDevice(bleDevice);
                        }
                        Logger logger = Logger.INSTANCE;
                        XBaseBleConnector xBaseBleConnector3 = xBaseBleConnector2;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger.isCanLogger(true)) {
                            String str = "onScan success, device=" + xBaseBleConnector3.getMBleDevice() + " ,scanCount=" + i;
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
                        if (cancellableContinuation2.isActive()) {
                            CancellableContinuation<XBluetoothDevice> cancellableContinuation3 = cancellableContinuation2;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation3.resumeWith(Result.m6347constructorimpl(xBaseBleConnector2.getMBleDevice()));
                        }
                    }
                });
                startScan2.onScanComplete(new Function2<List<XBluetoothDevice>, List<XBluetoothDevice>, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.ble.XBaseBleConnector$scan$2$1.3
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(List<XBluetoothDevice> list, List<XBluetoothDevice> list2) {
                        Intrinsics.checkNotNullParameter(list, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(list2, "<anonymous parameter 1>");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(List<XBluetoothDevice> list, List<XBluetoothDevice> list2) {
                        invoke2(list, list2);
                        return Unit.INSTANCE;
                    }
                });
            }
        }, xBluetoothFlowCallBack, 7, null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
