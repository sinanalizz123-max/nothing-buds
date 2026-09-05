package com.nothing.link.bluetooth.sdk.connect.bt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.content.IntentCompat;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.connect.XBluetoothDeviceStateChange;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.TimeoutKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XBTReceiverHelper.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 M2\u00020\u0001:\u0001MB\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0018\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0018\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"J\u000e\u0010(\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015J\u000e\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+J\u000e\u0010,\u001a\u00020-2\u0006\u0010\u001e\u001a\u00020\u001fJ.\u0010.\u001a\u001e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\"0/j\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\"`02\b\b\u0002\u00101\u001a\u00020%H\u0007J\u0019\u00102\u001a\u00020%2\u0006\u0010!\u001a\u00020\"H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00103J \u00104\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u00105\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"J#\u00106\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u00107\u001a\u00020\u001fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00108J\u0010\u00109\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010:\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010;\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"J\u0018\u0010<\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%2\b\u0010!\u001a\u0004\u0018\u00010\"J \u0010=\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\b\u0010!\u001a\u0004\u0018\u00010\"J\u000e\u0010>\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+J\u000e\u0010?\u001a\u00020-2\u0006\u0010@\u001a\u00020\u001fJ\u0006\u0010A\u001a\u00020\u001dJ\u0006\u0010B\u001a\u00020\u001dJ\u000e\u0010C\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+J\u0016\u0010D\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\u0006\u0010F\u001a\u00020\u001dJ\u000e\u0010G\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015J\u0006\u0010H\u001a\u00020\u001dJ\u0006\u0010I\u001a\u00020\u001dJ\u001a\u0010J\u001a\u00020\u001d2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0LJ$\u0010J\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0012\u0010K\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001d0LR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006N"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTReceiverHelper;", "", "()V", "a2dpProfile", "Lcom/nothing/link/bluetooth/sdk/connect/bt/A2dpProfile;", "getA2dpProfile", "()Lcom/nothing/link/bluetooth/sdk/connect/bt/A2dpProfile;", "setA2dpProfile", "(Lcom/nothing/link/bluetooth/sdk/connect/bt/A2dpProfile;)V", "btReceiver", "Landroid/content/BroadcastReceiver;", "getBtReceiver", "()Landroid/content/BroadcastReceiver;", "delayJob", "Lkotlinx/coroutines/Job;", "getDelayJob", "()Lkotlinx/coroutines/Job;", "setDelayJob", "(Lkotlinx/coroutines/Job;)V", "deviceStateList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/nothing/link/bluetooth/sdk/connect/XBluetoothDeviceStateChange;", "headsetProfile", "Lcom/nothing/link/bluetooth/sdk/connect/bt/HeadSetProfile;", "getHeadsetProfile", "()Lcom/nothing/link/bluetooth/sdk/connect/bt/HeadSetProfile;", "setHeadsetProfile", "(Lcom/nothing/link/bluetooth/sdk/connect/bt/HeadSetProfile;)V", "a2dpStateChanged", "", "state", "", "preState", "device", "Landroid/bluetooth/BluetoothDevice;", "aclStateChanged", "connected", "", "actionEncryptionChange", "isSecure", "addDeviceSateChange", "bondStatusChange", "intent", "Landroid/content/Intent;", "getBoundDesc", "", "getConnectedDevice", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "fromDevice", "getConnectedState", "(Landroid/bluetooth/BluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "headsetStateChanged", "isA2dpConnected", "isConnect", "profileType", "(Landroid/bluetooth/BluetoothDevice;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDeviceConnected", "isHeadSetConnected", "isLeConnected", "keyMissingChanged", "leAudioStateChanged", "logIntentExtras", "mapBondFailReason", "reason", "onCreate", "onDestroy", "onStateChanged", "profileConnectedChanged", "profile", "registerReceiver", "removeDeviceStateChange", "setServiceConnect", "unRegisterReceiver", "updateDeviceStateChange", "action", "Lkotlin/Function1;", "Companion", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XBTReceiverHelper {
    public static final String ACTION_ENCRYPTION_CHANGE = "android.bluetooth.device.action.ENCRYPTION_CHANGE";
    public static final String ACTION_KEY_MISSING = "android.bluetooth.device.action.KEY_MISSING";
    public static final String ENCRYPTION_ENABLED = "android.bluetooth.device.extra.ENCRYPTION_ENABLED";
    private Job delayJob;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<XBTReceiverHelper> singleInstance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<XBTReceiverHelper>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$Companion$singleInstance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final XBTReceiverHelper invoke() {
            return new XBTReceiverHelper();
        }
    });
    private A2dpProfile a2dpProfile = new A2dpProfile();
    private HeadSetProfile headsetProfile = new HeadSetProfile();
    private CopyOnWriteArrayList<XBluetoothDeviceStateChange> deviceStateList = new CopyOnWriteArrayList<>();
    private final BroadcastReceiver btReceiver = new BroadcastReceiver() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$btReceiver$1
        /* JADX WARN: Code duplicated, block: B:7:0x0038  */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i;
            if (intent == null) {
                return;
            }
            this.this$0.logIntentExtras(intent);
            int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", Integer.MIN_VALUE);
            int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", Integer.MIN_VALUE);
            BluetoothDevice bluetoothDevice = (BluetoothDevice) IntentCompat.getParcelableExtra(intent, "android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = intent.getAction() + " state:" + intExtra + ",prestate:" + intExtra2 + StringUtils.SPACE + bluetoothDevice;
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    i = intExtra;
                } else {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    i = intExtra;
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            } else {
                i = intExtra;
            }
            String action = intent.getAction();
            if (action != null) {
                switch (action.hashCode()) {
                    case -1765714821:
                        int i2 = i;
                        if (action.equals("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED")) {
                            this.this$0.leAudioStateChanged(i2, intExtra2, bluetoothDevice);
                            break;
                        }
                        break;
                    case -1530327060:
                        if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                            this.this$0.onStateChanged(intent);
                            break;
                        }
                        break;
                    case -301431627:
                        if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                            this.this$0.aclStateChanged(true, bluetoothDevice);
                            break;
                        }
                        break;
                    case 236687053:
                        if (action.equals(XBTReceiverHelper.ACTION_ENCRYPTION_CHANGE)) {
                            this.this$0.actionEncryptionChange(intent.getBooleanExtra(XBTReceiverHelper.ENCRYPTION_ENABLED, false), bluetoothDevice);
                            break;
                        }
                        break;
                    case 545516589:
                        int i3 = i;
                        if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                            this.this$0.headsetStateChanged(i3, intExtra2, bluetoothDevice);
                            break;
                        }
                        break;
                    case 1244161670:
                        if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                            this.this$0.a2dpStateChanged(i, intExtra2, bluetoothDevice);
                            break;
                        }
                        break;
                    case 1695159015:
                        if (action.equals(XBTReceiverHelper.ACTION_KEY_MISSING)) {
                            this.this$0.keyMissingChanged(false, bluetoothDevice);
                            break;
                        }
                        break;
                    case 1821585647:
                        if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                            this.this$0.aclStateChanged(false, bluetoothDevice);
                            break;
                        }
                        break;
                    case 2116862345:
                        if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                            this.this$0.bondStatusChange(intent);
                            break;
                        }
                        break;
                }
            }
        }
    };

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$getConnectedState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBTReceiverHelper.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper", f = "XBTReceiverHelper.kt", i = {}, l = {540}, m = "getConnectedState", n = {}, s = {})
    static final class C08921 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08921(Continuation<? super C08921> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBTReceiverHelper.this.getConnectedState(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$isConnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBTReceiverHelper.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper", f = "XBTReceiverHelper.kt", i = {}, l = {440}, m = "isConnect", n = {}, s = {})
    static final class C08951 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08951(Continuation<? super C08951> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return XBTReceiverHelper.this.isConnect(null, 0, this);
        }
    }

    public final boolean isLeConnected(BluetoothDevice device) {
        return false;
    }

    public final A2dpProfile getA2dpProfile() {
        return this.a2dpProfile;
    }

    public final void setA2dpProfile(A2dpProfile a2dpProfile) {
        Intrinsics.checkNotNullParameter(a2dpProfile, "<set-?>");
        this.a2dpProfile = a2dpProfile;
    }

    public final HeadSetProfile getHeadsetProfile() {
        return this.headsetProfile;
    }

    public final void setHeadsetProfile(HeadSetProfile headSetProfile) {
        Intrinsics.checkNotNullParameter(headSetProfile, "<set-?>");
        this.headsetProfile = headSetProfile;
    }

    /* JADX INFO: compiled from: XBTReceiverHelper.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTReceiverHelper$Companion;", "", "()V", "ACTION_ENCRYPTION_CHANGE", "", "ACTION_KEY_MISSING", "ENCRYPTION_ENABLED", "singleInstance", "Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTReceiverHelper;", "getSingleInstance", "()Lcom/nothing/link/bluetooth/sdk/connect/bt/XBTReceiverHelper;", "singleInstance$delegate", "Lkotlin/Lazy;", "get", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final XBTReceiverHelper getSingleInstance() {
            return (XBTReceiverHelper) XBTReceiverHelper.singleInstance$delegate.getValue();
        }

        public final XBTReceiverHelper get() {
            return getSingleInstance();
        }
    }

    public final void addDeviceSateChange(XBluetoothDeviceStateChange state) {
        Object next;
        Intrinsics.checkNotNullParameter(state, "state");
        Iterator<T> it = this.deviceStateList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(state.toString(), ((XBluetoothDeviceStateChange) next).toString()));
        if (next == null) {
            this.deviceStateList.add(state);
        }
    }

    public final void removeDeviceStateChange(XBluetoothDeviceStateChange state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.deviceStateList.remove(state);
    }

    public final void updateDeviceStateChange(BluetoothDevice device, Function1<? super XBluetoothDeviceStateChange, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        if (device == null) {
            return;
        }
        for (XBluetoothDeviceStateChange xBluetoothDeviceStateChange : this.deviceStateList) {
            if (xBluetoothDeviceStateChange.matchDeviceEvent(device)) {
                Intrinsics.checkNotNull(xBluetoothDeviceStateChange);
                action.invoke(xBluetoothDeviceStateChange);
            }
        }
    }

    public final void updateDeviceStateChange(Function1<? super XBluetoothDeviceStateChange, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        for (XBluetoothDeviceStateChange xBluetoothDeviceStateChange : this.deviceStateList) {
            Intrinsics.checkNotNull(xBluetoothDeviceStateChange);
            action.invoke(xBluetoothDeviceStateChange);
        }
    }

    public final void setServiceConnect() {
        this.a2dpProfile.setServiceConnected(new Function2<Integer, Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.setServiceConnect.1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final int i, final boolean z) {
                XBTReceiverHelper.this.updateDeviceStateChange(new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.setServiceConnect.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                        invoke2(xBluetoothDeviceStateChange);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(XBluetoothDeviceStateChange it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.profileConnectedChanged(i, z);
                    }
                });
            }
        });
        this.headsetProfile.setServiceConnected(new Function2<Integer, Boolean, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.setServiceConnect.2
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, Boolean bool) {
                invoke(num.intValue(), bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(final int i, final boolean z) {
                XBTReceiverHelper.this.updateDeviceStateChange(new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.setServiceConnect.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                        invoke2(xBluetoothDeviceStateChange);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(XBluetoothDeviceStateChange it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.profileConnectedChanged(i, z);
                    }
                });
            }
        });
    }

    public final void onCreate() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "init XBTConnector".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "init XBTConnector " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "init XBTConnector " + strComponent2);
            }
        }
        XBluetoothManager xBluetoothManager = XBluetoothManager.INSTANCE.get();
        BluetoothAdapter bluetoothAdapter = xBluetoothManager.getBluetoothAdapter();
        if (bluetoothAdapter != null) {
            this.a2dpProfile.onCreate(xBluetoothManager.getContext(), bluetoothAdapter);
            this.headsetProfile.onCreate(xBluetoothManager.getContext(), bluetoothAdapter);
            setServiceConnect();
        }
        registerReceiver();
    }

    public final BroadcastReceiver getBtReceiver() {
        return this.btReceiver;
    }

    public final void logIntentExtras(Intent intent) {
        Class<?> cls;
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                Object obj = extras.get(str);
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str2 = str + " = " + obj + " (" + ((obj == null || (cls = obj.getClass()) == null) ? null : cls.getSimpleName()) + ")";
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
            }
        }
    }

    public final void keyMissingChanged(final boolean connected, final BluetoothDevice device) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "keyMissingChanged " + connected + " ,device:" + device;
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
        updateDeviceStateChange(device, new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.keyMissingChanged.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                invoke2(xBluetoothDeviceStateChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XBluetoothDeviceStateChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.keyMissingChanged(device, connected);
            }
        });
    }

    public final void actionEncryptionChange(final boolean isSecure, final BluetoothDevice device) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "actionEncryptionChange " + isSecure + " ,device:" + device;
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
        updateDeviceStateChange(device, new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.actionEncryptionChange.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                invoke2(xBluetoothDeviceStateChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XBluetoothDeviceStateChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.actionEncryptionChange(device, isSecure);
            }
        });
    }

    public final void profileConnectedChanged(final int profile, final boolean connected) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "profileConnectedChanged " + connected + StringUtils.SPACE;
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
        updateDeviceStateChange(new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.profileConnectedChanged.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                invoke2(xBluetoothDeviceStateChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XBluetoothDeviceStateChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.profileConnectedChanged(profile, connected);
            }
        });
    }

    public final void aclStateChanged(final boolean connected, final BluetoothDevice device) {
        updateDeviceStateChange(device, new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.aclStateChanged.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                invoke2(xBluetoothDeviceStateChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XBluetoothDeviceStateChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.aclStateChanged(device, connected);
            }
        });
    }

    public final void leAudioStateChanged(int state, int preState, BluetoothDevice device) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "leAudio StateChanged state:" + state + ",preState:" + preState + ",device:" + device;
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

    public final Job getDelayJob() {
        return this.delayJob;
    }

    public final void setDelayJob(Job job) {
        this.delayJob = job;
    }

    public final void headsetStateChanged(int state, int preState, BluetoothDevice device) {
        Job job;
        if (state == 1 && (job = this.delayJob) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        if (state == 0 || state == 2) {
            if (state == 0 && preState == 1) {
                Job job2 = this.delayJob;
                if (job2 != null) {
                    Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
                }
                this.delayJob = BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C08931(device, null), 3, null);
                return;
            }
            Job job3 = this.delayJob;
            if (job3 != null) {
                Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
            }
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new C08942(device, state, null), 3, null);
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$headsetStateChanged$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBTReceiverHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$headsetStateChanged$1", f = "XBTReceiverHelper.kt", i = {1}, l = {260, 263}, m = "invokeSuspend", n = {"isBtConnect"}, s = {"Z$0"})
    static final class C08931 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BluetoothDevice $device;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08931(BluetoothDevice bluetoothDevice, Continuation<? super C08931> continuation) {
            super(2, continuation);
            this.$device = bluetoothDevice;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBTReceiverHelper.this.new C08931(this.$device, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08931) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0073  */
        /* JADX WARN: Code duplicated, block: B:30:0x00f4  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean zIsDeviceConnected;
            boolean z;
            final boolean zIsA2dpConnected;
            final boolean zIsHeadSetConnected;
            Logger logger;
            BluetoothDevice bluetoothDevice;
            String tag;
            int depth;
            String str;
            String str2;
            String strComponent1;
            String strComponent2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(200L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z = this.Z$0;
                ResultKt.throwOnFailure(obj);
            }
            zIsDeviceConnected = z;
            zIsA2dpConnected = XBTReceiverHelper.this.isA2dpConnected(this.$device);
            zIsHeadSetConnected = XBTReceiverHelper.this.isHeadSetConnected(this.$device);
            logger = Logger.INSTANCE;
            bluetoothDevice = this.$device;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "headsetStateChanged isBtConnect " + zIsDeviceConnected + ",isA2dpConnected:" + zIsA2dpConnected + ",isHeadsetConnected:" + zIsHeadSetConnected + StringUtils.SPACE + bluetoothDevice;
                str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    strComponent1 = trace.component1();
                    strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            XBTReceiverHelper xBTReceiverHelper = XBTReceiverHelper.this;
            BluetoothDevice bluetoothDevice2 = this.$device;
            final BluetoothDevice bluetoothDevice3 = this.$device;
            xBTReceiverHelper.updateDeviceStateChange(bluetoothDevice2, new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.headsetStateChanged.1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                    invoke2(xBluetoothDeviceStateChange);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(XBluetoothDeviceStateChange it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onHeadSetChange(bluetoothDevice3, zIsA2dpConnected, zIsHeadSetConnected);
                }
            });
            return Unit.INSTANCE;
            zIsDeviceConnected = XBTReceiverHelper.this.isDeviceConnected(this.$device);
            if (zIsDeviceConnected) {
                this.Z$0 = zIsDeviceConnected;
                this.label = 2;
                if (DelayKt.delay(600L, this) != coroutine_suspended) {
                    z = zIsDeviceConnected;
                    zIsDeviceConnected = z;
                }
                return coroutine_suspended;
            }
            zIsA2dpConnected = XBTReceiverHelper.this.isA2dpConnected(this.$device);
            zIsHeadSetConnected = XBTReceiverHelper.this.isHeadSetConnected(this.$device);
            logger = Logger.INSTANCE;
            bluetoothDevice = this.$device;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str = "headsetStateChanged isBtConnect " + zIsDeviceConnected + ",isA2dpConnected:" + zIsA2dpConnected + ",isHeadsetConnected:" + zIsHeadSetConnected + StringUtils.SPACE + bluetoothDevice;
                str2 = str;
                if (str2 != null) {
                    Pair<String, String> trace2 = logger.getTrace(depth);
                    strComponent1 = trace2.component1();
                    strComponent2 = trace2.component2();
                    FileLog fileLog2 = FileLog.INSTANCE;
                    String str4 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    FileLog.print$default(fileLog2, 3, str4, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            XBTReceiverHelper xBTReceiverHelper2 = XBTReceiverHelper.this;
            BluetoothDevice bluetoothDevice4 = this.$device;
            final BluetoothDevice bluetoothDevice5 = this.$device;
            xBTReceiverHelper2.updateDeviceStateChange(bluetoothDevice4, new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.headsetStateChanged.1.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                    invoke2(xBluetoothDeviceStateChange);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(XBluetoothDeviceStateChange it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    it.onHeadSetChange(bluetoothDevice5, zIsA2dpConnected, zIsHeadSetConnected);
                }
            });
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$headsetStateChanged$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: XBTReceiverHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$headsetStateChanged$2", f = "XBTReceiverHelper.kt", i = {}, l = {285}, m = "invokeSuspend", n = {}, s = {})
    static final class C08942 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BluetoothDevice $device;
        final /* synthetic */ int $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08942(BluetoothDevice bluetoothDevice, int i, Continuation<? super C08942> continuation) {
            super(2, continuation);
            this.$device = bluetoothDevice;
            this.$state = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBTReceiverHelper.this.new C08942(this.$device, this.$state, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08942) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                boolean zIsDeviceConnected = XBTReceiverHelper.this.isDeviceConnected(this.$device);
                boolean zIsA2dpConnected = XBTReceiverHelper.this.isA2dpConnected(this.$device);
                boolean zIsConnectedState = XBTReceiverHelper.this.getHeadsetProfile().isConnectedState(this.$state);
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "headsetStateChanged isBtConnect " + zIsDeviceConnected + ",isA2dpConnected:" + zIsA2dpConnected + ",isHeadsetConnected:" + zIsConnectedState;
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
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new C01722(XBTReceiverHelper.this, this.$device, zIsA2dpConnected, zIsConnectedState, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$headsetStateChanged$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: XBTReceiverHelper.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$headsetStateChanged$2$2", f = "XBTReceiverHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01722 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ BluetoothDevice $device;
            final /* synthetic */ boolean $isA2dpConnected;
            final /* synthetic */ boolean $isHeadsetConnected;
            int label;
            final /* synthetic */ XBTReceiverHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01722(XBTReceiverHelper xBTReceiverHelper, BluetoothDevice bluetoothDevice, boolean z, boolean z2, Continuation<? super C01722> continuation) {
                super(2, continuation);
                this.this$0 = xBTReceiverHelper;
                this.$device = bluetoothDevice;
                this.$isA2dpConnected = z;
                this.$isHeadsetConnected = z2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01722(this.this$0, this.$device, this.$isA2dpConnected, this.$isHeadsetConnected, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01722) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                XBTReceiverHelper xBTReceiverHelper = this.this$0;
                BluetoothDevice bluetoothDevice = this.$device;
                final BluetoothDevice bluetoothDevice2 = this.$device;
                final boolean z = this.$isA2dpConnected;
                final boolean z2 = this.$isHeadsetConnected;
                xBTReceiverHelper.updateDeviceStateChange(bluetoothDevice, new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.headsetStateChanged.2.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                        invoke2(xBluetoothDeviceStateChange);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(XBluetoothDeviceStateChange it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.onHeadSetChange(bluetoothDevice2, z, z2);
                    }
                });
                return Unit.INSTANCE;
            }
        }
    }

    public final boolean isDeviceConnected(BluetoothDevice device) {
        try {
            Method declaredMethod = BluetoothDevice.class.getDeclaredMethod("isConnected", new Class[0]);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(device, new Object[0]);
            Intrinsics.checkNotNull(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String message = e.getMessage();
                String str = message;
                if (str != null && str.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str2 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    FileLog.print$default(fileLog, 6, str2, tag, message + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.e(tag + strComponent1, message + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$a2dpStateChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: XBTReceiverHelper.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$a2dpStateChanged$1", f = "XBTReceiverHelper.kt", i = {}, l = {325}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BluetoothDevice $device;
        final /* synthetic */ int $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BluetoothDevice bluetoothDevice, int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$device = bluetoothDevice;
            this.$state = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return XBTReceiverHelper.this.new AnonymousClass1(this.$device, this.$state, continuation);
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
                boolean zIsDeviceConnected = XBTReceiverHelper.this.isDeviceConnected(this.$device);
                boolean zIsConnectedState = XBTReceiverHelper.this.getA2dpProfile().isConnectedState(this.$state);
                boolean zIsHeadSetConnected = XBTReceiverHelper.this.isHeadSetConnected(this.$device);
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "a2dpStateChanged isBtConnect " + zIsDeviceConnected + ",isA2dpConnected:" + zIsConnectedState + ",isHeadsetConnected:" + zIsHeadSetConnected;
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
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass2(XBTReceiverHelper.this, this.$device, zIsConnectedState, zIsHeadSetConnected, null), this) == coroutine_suspended) {
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

        /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$a2dpStateChanged$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: XBTReceiverHelper.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper$a2dpStateChanged$1$2", f = "XBTReceiverHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ BluetoothDevice $device;
            final /* synthetic */ boolean $isA2dpConnected;
            final /* synthetic */ boolean $isHeadsetConnected;
            int label;
            final /* synthetic */ XBTReceiverHelper this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(XBTReceiverHelper xBTReceiverHelper, BluetoothDevice bluetoothDevice, boolean z, boolean z2, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = xBTReceiverHelper;
                this.$device = bluetoothDevice;
                this.$isA2dpConnected = z;
                this.$isHeadsetConnected = z2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$device, this.$isA2dpConnected, this.$isHeadsetConnected, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                XBTReceiverHelper xBTReceiverHelper = this.this$0;
                BluetoothDevice bluetoothDevice = this.$device;
                final BluetoothDevice bluetoothDevice2 = this.$device;
                final boolean z = this.$isA2dpConnected;
                final boolean z2 = this.$isHeadsetConnected;
                xBTReceiverHelper.updateDeviceStateChange(bluetoothDevice, new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.a2dpStateChanged.1.2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                        invoke2(xBluetoothDeviceStateChange);
                        return Unit.INSTANCE;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(XBluetoothDeviceStateChange it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.onA2DPChange(bluetoothDevice2, z, z2);
                    }
                });
                return Unit.INSTANCE;
            }
        }
    }

    public final void a2dpStateChanged(int state, int preState, BluetoothDevice device) {
        if (state == 0 || state == 2) {
            BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getIoScope(), null, null, new AnonymousClass1(device, state, null), 3, null);
        }
    }

    public final void bondStatusChange(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        final BluetoothDevice bluetoothDevice = (BluetoothDevice) IntentCompat.getParcelableExtra(intent, "android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
        final int intExtra = intent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", Integer.MIN_VALUE);
        final int intExtra2 = intent.getIntExtra("android.bluetooth.device.extra.PREVIOUS_BOND_STATE", Integer.MIN_VALUE);
        final int intExtra3 = intent.getIntExtra("android.bluetooth.device.extra.REASON", -1);
        updateDeviceStateChange(bluetoothDevice, new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.bondStatusChange.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                invoke2(xBluetoothDeviceStateChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XBluetoothDeviceStateChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onBondStatusChange(bluetoothDevice, intExtra, intExtra2, intExtra3);
            }
        });
    }

    public final String mapBondFailReason(int reason) {
        if (reason == -1) {
            return "";
        }
        if (reason == 8) {
            return "HCI_CONNECTION_TIMEOUT";
        }
        if (reason == 23) {
            return "HCI_ENCRYPTION_MODE_NOT_ACCEPTABLE";
        }
        if (reason == 31) {
            return "HCI_UNSPECIFIED_ERROR";
        }
        if (reason == 34) {
            return "HCI_LMP_RESPONSE_TIMEOUT";
        }
        if (reason == 38) {
            return "HCI_CONNECTION_FAILED_ESTABLISHMENT";
        }
        if (reason == 56) {
            return "HCI_CONTROLLER_BUSY";
        }
        if (reason == 58) {
            return "HCI_UNACCEPTABLE_CONNECTION_INTERVAL";
        }
        if (reason == 1) {
            return "HCI_UNKNOWN_HCI_COMMAND UserCancel";
        }
        if (reason == 2) {
            return "HCI_NO_CONNECTION";
        }
        if (reason == 4) {
            return "HCI_PAGE_TIMEOUT";
        }
        if (reason == 5) {
            return "HCI_AUTHENTICATION_FAILURE";
        }
        if (reason == 62) {
            return "HCI_MIC_FAILURE";
        }
        if (reason != 63) {
            switch (reason) {
                case 13:
                    return "HCI_INVALID_HCI_COMMAND_PARAMETERS";
                case 14:
                    return "HCI_REMOTE_USER_TERMINATED_CONNECTION";
                case 15:
                    return "HCI_REMOTE_DEVICE_TERMINATED_CONNECTION_LOW_RESOURCES";
                case 16:
                    return "HCI_REMOTE_DEVICE_TERMINATED_CONNECTION_POWER_OFF";
                case 17:
                    return "HCI_CONNECTION_TERMINATED_BY_LOCAL_HOST";
                case 18:
                    return "HCI_REPEATED_ATTEMPTS";
                case 19:
                    return "HCI_PAIRING_NOT_ALLOWED";
                default:
                    return "UNKNOWN\uff08code=" + reason + "\uff09";
            }
        }
        return "HCI_CONNECTION_FAILED_TO_BE_ESTABLISHED";
    }

    public final String getBoundDesc(int state) {
        switch (state) {
            case 10:
                return "BOND_NONE";
            case 11:
                return "BOND_BONDING";
            case 12:
                return "BOND_BONDED";
            default:
                return "ERROR";
        }
    }

    public final void onStateChanged(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        final int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
        int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", Integer.MIN_VALUE);
        if (intExtra == 10) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "bluetooth switch state:" + intExtra + " preState:" + intExtra2 + " is off!";
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
        } else if (intExtra == 12) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                String str4 = "bluetooth switch state:" + intExtra + " preState:" + intExtra2 + " is open!";
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
        updateDeviceStateChange(new Function1<XBluetoothDeviceStateChange, Unit>() { // from class: com.nothing.link.bluetooth.sdk.connect.bt.XBTReceiverHelper.onStateChanged.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(XBluetoothDeviceStateChange xBluetoothDeviceStateChange) {
                invoke2(xBluetoothDeviceStateChange);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(XBluetoothDeviceStateChange it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.onBluetoothChange(intExtra);
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c  */
    public final Object isConnect(BluetoothDevice bluetoothDevice, int i, Continuation<? super Boolean> continuation) {
        C08951 c08951;
        boolean zBooleanValue;
        if (continuation instanceof C08951) {
            c08951 = (C08951) continuation;
            if ((c08951.label & Integer.MIN_VALUE) != 0) {
                c08951.label -= Integer.MIN_VALUE;
            } else {
                c08951 = new C08951(continuation);
            }
        } else {
            c08951 = new C08951(continuation);
        }
        Object connectedState = c08951.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c08951.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(connectedState);
            boolean z = false;
            if (bluetoothDevice == null) {
                return Boxing.boxBoolean(false);
            }
            if (this.a2dpProfile.getMProfile() == null && this.headsetProfile.getMProfile() == null) {
                c08951.label = 1;
                connectedState = getConnectedState(bluetoothDevice, c08951);
                if (connectedState == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                boolean zIsA2dpConnected = isA2dpConnected(bluetoothDevice);
                boolean zIsHeadSetConnected = isHeadSetConnected(bluetoothDevice);
                if (i == 1) {
                    z = zIsHeadSetConnected;
                } else if (i == 2) {
                    z = zIsA2dpConnected;
                } else if (zIsA2dpConnected || zIsHeadSetConnected) {
                    z = true;
                }
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "Check bt connected:" + z + ",a2dp:" + zIsA2dpConnected + ",headset:" + zIsHeadSetConnected + StringUtils.SPACE + i;
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
                zBooleanValue = z;
            }
            return Boxing.boxBoolean(zBooleanValue);
        }
        if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(connectedState);
        zBooleanValue = ((Boolean) connectedState).booleanValue();
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "mProfile is null,getConnectedState " + zBooleanValue;
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
        return Boxing.boxBoolean(zBooleanValue);
    }

    public final boolean isA2dpConnected(BluetoothDevice device) {
        return this.a2dpProfile.isConnected(device);
    }

    public final boolean isHeadSetConnected(BluetoothDevice device) {
        return this.headsetProfile.isConnected(device);
    }

    public final void registerReceiver() {
        Context context = XBluetoothManager.INSTANCE.get().getContext();
        if (context != null) {
            BroadcastReceiver broadcastReceiver = this.btReceiver;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
            intentFilter.addAction(ACTION_KEY_MISSING);
            intentFilter.addAction(ACTION_ENCRYPTION_CHANGE);
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            Unit unit = Unit.INSTANCE;
            ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, 2);
        }
    }

    public final void unRegisterReceiver() {
        Context context = XBluetoothManager.INSTANCE.get().getContext();
        if (context != null) {
            context.unregisterReceiver(this.btReceiver);
        }
    }

    public final void onDestroy() {
        unRegisterReceiver();
        this.a2dpProfile.onDestroy();
        this.headsetProfile.onDestroy();
        this.deviceStateList.clear();
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true) && "XbtConnector onDestroy".length() != 0) {
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            FileLog.print$default(fileLog, 3, str, tag, "XbtConnector onDestroy " + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, "XbtConnector onDestroy " + strComponent2);
            }
        }
    }

    public static /* synthetic */ HashMap getConnectedDevice$default(XBTReceiverHelper xBTReceiverHelper, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return xBTReceiverHelper.getConnectedDevice(z);
    }

    public final HashMap<String, BluetoothDevice> getConnectedDevice(boolean fromDevice) {
        HashMap<String, BluetoothDevice> map = new HashMap<>();
        List<BluetoothDevice> connectedDevices = this.a2dpProfile.getConnectedDevices();
        if (connectedDevices != null) {
            for (BluetoothDevice bluetoothDevice : connectedDevices) {
                if (!map.containsKey(bluetoothDevice.getAddress())) {
                    String address = bluetoothDevice.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                    map.put(address, bluetoothDevice);
                }
            }
        }
        List<BluetoothDevice> connectedDevices2 = this.headsetProfile.getConnectedDevices();
        if (connectedDevices2 != null) {
            for (BluetoothDevice bluetoothDevice2 : connectedDevices2) {
                if (!map.containsKey(bluetoothDevice2.getAddress())) {
                    String address2 = bluetoothDevice2.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
                    map.put(address2, bluetoothDevice2);
                }
            }
        }
        if (fromDevice) {
            try {
                Result.Companion companion = Result.INSTANCE;
                BluetoothAdapter bluetoothAdapter = XBluetoothManager.INSTANCE.get().getBluetoothAdapter();
                Unit unit = null;
                Set<BluetoothDevice> bondedDevices = bluetoothAdapter != null ? bluetoothAdapter.getBondedDevices() : null;
                if (bondedDevices != null) {
                    for (BluetoothDevice bluetoothDevice3 : bondedDevices) {
                        if (isDeviceConnected(bluetoothDevice3) && !map.containsKey(bluetoothDevice3.getAddress())) {
                            String address3 = bluetoothDevice3.getAddress();
                            Intrinsics.checkNotNullExpressionValue(address3, "getAddress(...)");
                            Intrinsics.checkNotNull(bluetoothDevice3);
                            map.put(address3, bluetoothDevice3);
                        }
                    }
                    unit = Unit.INSTANCE;
                }
                Result.m6347constructorimpl(unit);
                return map;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.m6347constructorimpl(ResultKt.createFailure(th));
            }
        }
        return map;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getConnectedState(BluetoothDevice bluetoothDevice, Continuation<? super Boolean> continuation) {
        C08921 c08921;
        if (continuation instanceof C08921) {
            c08921 = (C08921) continuation;
            if ((c08921.label & Integer.MIN_VALUE) != 0) {
                c08921.label -= Integer.MIN_VALUE;
            } else {
                c08921 = new C08921(continuation);
            }
        } else {
            c08921 = new C08921(continuation);
        }
        Object obj = c08921.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c08921.label;
        try {
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            Result.Companion companion = Result.INSTANCE;
            XBTReceiverHelper$getConnectedState$2$1 xBTReceiverHelper$getConnectedState$2$1 = new XBTReceiverHelper$getConnectedState$2$1(bluetoothDevice, null);
            c08921.label = 1;
            Object objWithTimeout = TimeoutKt.withTimeout(1000L, xBTReceiverHelper$getConnectedState$2$1, c08921);
            return objWithTimeout == coroutine_suspended ? coroutine_suspended : objWithTimeout;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Object objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            return Result.m6350exceptionOrNullimpl(objM6347constructorimpl) == null ? objM6347constructorimpl : Boxing.boxBoolean(false);
        }
    }
}
