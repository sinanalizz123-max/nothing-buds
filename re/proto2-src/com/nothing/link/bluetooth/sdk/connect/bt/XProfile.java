package com.nothing.link.bluetooth.sdk.connect.bt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import android.util.Log;
import com.nothing.earbase.unknown.DeviceEarImage;
import com.nothing.link.bluetooth.sdk.util.BleUtil;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: XProfile.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#J\u0019\u0010$\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%J\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010'J\b\u0010(\u001a\u00020\u000bH&J\u0010\u0010)\u001a\u00020\u000f2\b\u0010*\u001a\u0004\u0018\u00010#J\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000bJ\u000e\u0010-\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020\u000bJ\u001a\u0010.\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010/\u001a\u00020\u0011H\u0016J\u001a\u00100\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000b2\b\u00101\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u00102\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J@\u00103\u001a\u00020\u001128\u00104\u001a4\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bRL\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/bt/XProfile;", "Landroid/bluetooth/BluetoothProfile$ServiceListener;", "()V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "setBluetoothAdapter", "(Landroid/bluetooth/BluetoothAdapter;)V", "connectedCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "profile", "", "connect", "", "getConnectedCallback", "()Lkotlin/jvm/functions/Function2;", "setConnectedCallback", "(Lkotlin/jvm/functions/Function2;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "mProfile", "Landroid/bluetooth/BluetoothProfile;", "getMProfile", "()Landroid/bluetooth/BluetoothProfile;", "setMProfile", "(Landroid/bluetooth/BluetoothProfile;)V", "bluetoothDevice", "Landroid/bluetooth/BluetoothDevice;", DeviceEarImage.DISCONNECT_EAR_IMAGE, "(Landroid/bluetooth/BluetoothDevice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getConnectedDevices", "", "getProfileType", "isConnected", "device", "isConnectedState", "state", "isDisconnectedState", "onCreate", "onDestroy", "onServiceConnected", "proxy", "onServiceDisconnected", "setServiceConnected", "serviceConnected", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class XProfile implements BluetoothProfile.ServiceListener {
    private BluetoothAdapter bluetoothAdapter;
    private Function2<? super Integer, ? super Boolean, Unit> connectedCallback;
    private Context context;
    private BluetoothProfile mProfile;

    public abstract int getProfileType();

    public final boolean isConnectedState(int state) {
        return state == 2;
    }

    public final boolean isDisconnectedState(int state) {
        return state == 0;
    }

    public final BluetoothAdapter getBluetoothAdapter() {
        return this.bluetoothAdapter;
    }

    public final void setBluetoothAdapter(BluetoothAdapter bluetoothAdapter) {
        this.bluetoothAdapter = bluetoothAdapter;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    public final BluetoothProfile getMProfile() {
        return this.mProfile;
    }

    public final void setMProfile(BluetoothProfile bluetoothProfile) {
        this.mProfile = bluetoothProfile;
    }

    public final Function2<Integer, Boolean, Unit> getConnectedCallback() {
        return this.connectedCallback;
    }

    public final void setConnectedCallback(Function2<? super Integer, ? super Boolean, Unit> function2) {
        this.connectedCallback = function2;
    }

    public void onCreate(Context context, BluetoothAdapter bluetoothAdapter) {
        Intrinsics.checkNotNullParameter(bluetoothAdapter, "bluetoothAdapter");
        this.context = context;
        this.bluetoothAdapter = bluetoothAdapter;
        int profileType = getProfileType();
        if (profileType > 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "getProfileProxy " + profileType;
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
            bluetoothAdapter.getProfileProxy(context, this, profileType);
            return;
        }
        Logger logger2 = Logger.INSTANCE;
        String tag2 = logger2.getTAG();
        int depth2 = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str4 = "unSupport profile " + profileType;
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
            FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
            if (logger2.isDebug()) {
                Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
            }
        }
    }

    public void onDestroy() {
        int profileType = getProfileType();
        if (profileType > 0) {
            BluetoothAdapter bluetoothAdapter = this.bluetoothAdapter;
            if (bluetoothAdapter != null) {
                bluetoothAdapter.closeProfileProxy(profileType, this.mProfile);
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "release " + this;
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
            this.mProfile = null;
        }
    }

    public final boolean isConnected(BluetoothDevice device) {
        List<BluetoothDevice> connectedDevices;
        if (BleUtil.INSTANCE.checkBluetoothPermissions()) {
            BluetoothProfile bluetoothProfile = this.mProfile;
            Object obj = null;
            if (bluetoothProfile != null && (connectedDevices = bluetoothProfile.getConnectedDevices()) != null) {
                for (Object obj2 : connectedDevices) {
                    if (Intrinsics.areEqual(((BluetoothDevice) obj2).getAddress(), device != null ? device.getAddress() : null)) {
                        obj = obj2;
                        break;
                    }
                }
                obj = (BluetoothDevice) obj;
            }
            if (obj != null) {
                return true;
            }
        }
        return false;
    }

    public final int connect(BluetoothDevice bluetoothDevice) {
        String message;
        if (bluetoothDevice == null) {
            return -1;
        }
        int profileType = getProfileType();
        try {
            Result.Companion companion = Result.INSTANCE;
            BluetoothProfile bluetoothProfile = this.mProfile;
            try {
                if (bluetoothProfile == null) {
                    Logger logger = Logger.INSTANCE;
                    String tag = logger.getTAG();
                    int depth = logger.getDepth();
                    if (!logger.isCanLogger(true)) {
                        return -2;
                    }
                    String str = profileType + " mProfile is null";
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (!logger.isDebug()) {
                            return -2;
                        }
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        return -2;
                    }
                    return -2;
                }
                Intrinsics.checkNotNull(bluetoothProfile);
                Method declaredMethod = bluetoothProfile.getClass().getDeclaredMethod("connect", BluetoothDevice.class);
                declaredMethod.setAccessible(true);
                return Intrinsics.areEqual(declaredMethod.invoke(this.mProfile, bluetoothDevice), (Object) true) ? 1 : 0;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        Result.Companion companion2 = Result.INSTANCE;
        Object objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
        Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        if (thM6350exceptionOrNullimpl != null) {
            Logger logger2 = Logger.INSTANCE;
            String tag2 = logger2.getTAG();
            int depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                Throwable cause = thM6350exceptionOrNullimpl.getCause();
                String str4 = "connect reflect failed! " + (cause != null ? cause.getMessage() : null) + StringUtils.SPACE;
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
            Throwable cause2 = thM6350exceptionOrNullimpl.getCause();
            if (cause2 != null && (message = cause2.getMessage()) != null && StringsKt.contains$default((CharSequence) message, (CharSequence) "MODIFY_PHONE_STATE", false, 2, (Object) null)) {
                return 3;
            }
        }
        Throwable thM6350exceptionOrNullimpl2 = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
        Object obj = objM6347constructorimpl;
        if (thM6350exceptionOrNullimpl2 != null) {
            obj = -3;
        }
        return ((Number) obj).intValue();
    }

    public final Object disconnect(BluetoothDevice bluetoothDevice, Continuation<? super Boolean> continuation) {
        int profileType = getProfileType();
        try {
            Result.Companion companion = Result.INSTANCE;
            BluetoothProfile bluetoothProfile = this.mProfile;
            if (bluetoothProfile == null) {
                return Boxing.boxBoolean(false);
            }
            Intrinsics.checkNotNull(bluetoothProfile);
            Method declaredMethod = bluetoothProfile.getClass().getDeclaredMethod(DeviceEarImage.DISCONNECT_EAR_IMAGE, new Class[0]);
            declaredMethod.setAccessible(true);
            return Boxing.boxBoolean(Intrinsics.areEqual(declaredMethod.invoke(this.mProfile, bluetoothDevice), Boxing.boxBoolean(true)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Object objM6347constructorimpl = Result.m6347constructorimpl(ResultKt.createFailure(th));
            Throwable thM6350exceptionOrNullimpl = Result.m6350exceptionOrNullimpl(objM6347constructorimpl);
            if (thM6350exceptionOrNullimpl != null) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = profileType + " disconnect reflect failed! " + thM6350exceptionOrNullimpl;
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 6, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.e(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
            }
            return Result.m6350exceptionOrNullimpl(objM6347constructorimpl) == null ? objM6347constructorimpl : Boxing.boxBoolean(false);
        }
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceDisconnected(int profile) {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onServiceDisconnected profile:" + profile + "," + this;
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
        Function2<? super Integer, ? super Boolean, Unit> function2 = this.connectedCallback;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(profile), false);
        }
        this.mProfile = null;
    }

    public final void setServiceConnected(Function2<? super Integer, ? super Boolean, Unit> serviceConnected) {
        this.connectedCallback = serviceConnected;
    }

    @Override // android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int profile, BluetoothProfile proxy) {
        Function2<? super Integer, ? super Boolean, Unit> function2 = this.connectedCallback;
        if (function2 != null) {
            function2.invoke(Integer.valueOf(profile), true);
        }
    }

    public final List<BluetoothDevice> getConnectedDevices() {
        BluetoothProfile bluetoothProfile = this.mProfile;
        if (bluetoothProfile != null) {
            return bluetoothProfile.getConnectedDevices();
        }
        return null;
    }
}
