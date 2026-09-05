package com.nothing.link.bluetooth.sdk.util;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import com.nothing.link.bluetooth.sdk.device.XBluetoothDevice;
import com.nothing.link.bluetooth.sdk.scan.parser.NothingParser;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BleUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0011\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0015\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0016\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J)\u0010\u0016\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0012\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0010\"\u00020\u0004\u00a2\u0006\u0002\u0010\u0018J\u0018\u0010\u0016\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000b\u001a\u00020\u0004J#\u0010\u0019\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010\u00a2\u0006\u0002\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007J\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060!2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$\u00a8\u0006%"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/util/BleUtil;", "", "()V", "bytesToHex", "", "bytes", "", "addSpace", "", "checkBluetoothPermissions", "checkPermission", "permission", "getDeviceName", "device", "Landroid/bluetooth/BluetoothDevice;", "getPermission", "", "()[Ljava/lang/String;", "isBleSupport", "context", "Landroid/content/Context;", "isGpsOpen", "isPermission", "permissions", "(Landroid/content/Context;[Ljava/lang/String;)Z", "isPermissionArray", "scanResultToBleDevice", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "scanResult", "Landroid/bluetooth/le/ScanResult;", "parseBundle", "Landroid/os/Bundle;", "subpackage", "Landroid/util/SparseArray;", "data", "packageLength", "", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BleUtil {
    public static final BleUtil INSTANCE = new BleUtil();

    private BleUtil() {
    }

    public final boolean isGpsOpen(Context context) {
        LocationManager locationManager = (LocationManager) (context != null ? context.getSystemService(FirebaseAnalytics.Param.LOCATION) : null);
        return (locationManager != null && locationManager.isProviderEnabled("gps")) || (locationManager != null && locationManager.isProviderEnabled("network"));
    }

    public final boolean isPermission(Context context, String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        return context != null && ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public final boolean checkPermission(String permission) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        if (XBluetoothManager.INSTANCE.get().getContext() == null) {
            return false;
        }
        if (Intrinsics.areEqual("android.permission.BLUETOOTH_CONNECT", permission)) {
            return checkBluetoothPermissions();
        }
        Context context = XBluetoothManager.INSTANCE.get().getContext();
        Intrinsics.checkNotNull(context);
        return ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public final boolean checkBluetoothPermissions() {
        Context context = XBluetoothManager.INSTANCE.get().getContext();
        if (context == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return isPermissionArray(context, new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"});
        }
        if (Build.VERSION.SDK_INT >= 29) {
            String[] strArr = {"android.permission.ACCESS_FINE_LOCATION"};
            if (Build.VERSION.SDK_INT >= 30) {
                ArraysKt.plus(strArr, "android.permission.ACCESS_BACKGROUND_LOCATION");
            }
            return isPermissionArray(context, strArr);
        }
        return isPermissionArray(context, new String[]{"android.permission.ACCESS_FINE_LOCATION"});
    }

    public final boolean isPermissionArray(Context context, String[] permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (context == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "isPermission context is null".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 6, str, tag, "isPermission context is null " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.e(tag + strComponent1, "isPermission context is null " + strComponent2);
                }
            }
            return false;
        }
        for (String str2 : permissions) {
            if (ContextCompat.checkSelfPermission(context, str2) != 0) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str3 = "isPermission permission " + str2 + " not granted!";
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
                return false;
            }
        }
        return true;
    }

    public final boolean isPermission(Context context, String... permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (context == null) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true) && "isPermission context is null".length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FileLog.print$default(fileLog, 6, str, tag, "isPermission context is null " + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.e(tag + strComponent1, "isPermission context is null " + strComponent2);
                }
            }
            return false;
        }
        for (String str2 : permissions) {
            if (ContextCompat.checkSelfPermission(context, str2) != 0) {
                Logger logger2 = Logger.INSTANCE;
                String tag2 = logger2.getTAG();
                int depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str3 = "isPermission permission " + str2 + " not granted!";
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
                return false;
            }
        }
        return true;
    }

    public final boolean isBleSupport(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        return packageManager.hasSystemFeature("android.hardware.bluetooth_le");
    }

    public final boolean isPermission(Context context) {
        return checkBluetoothPermissions();
    }

    public final String[] getPermission() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[]{"android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
        }
        return new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"};
    }

    public final XBluetoothDevice scanResultToBleDevice(ScanResult scanResult, Bundle parseBundle) {
        String string;
        String str;
        Intrinsics.checkNotNullParameter(scanResult, "scanResult");
        if (parseBundle == null || (string = parseBundle.getString(NothingParser.MAC_ADDRESS)) == null) {
            string = "";
        }
        String str2 = string;
        boolean z = false;
        if (parseBundle != null && parseBundle.getBoolean(NothingParser.IS_PAIRED)) {
            z = true;
        }
        BluetoothDevice device = scanResult.getDevice();
        BluetoothDevice device2 = scanResult.getDevice();
        String name = device2 != null ? device2.getName() : null;
        BluetoothDevice device3 = scanResult.getDevice();
        String address = device3 != null ? device3.getAddress() : null;
        Integer numValueOf = Integer.valueOf(scanResult.getRssi());
        Long lValueOf = Long.valueOf(scanResult.getTimestampNanos());
        ScanRecord scanRecord = scanResult.getScanRecord();
        byte[] bytes = scanRecord != null ? scanRecord.getBytes() : null;
        if (z) {
            str = "1";
        } else {
            str = "0";
        }
        return new XBluetoothDevice(device, name, address, str2, numValueOf, lValueOf, bytes, parseBundle, null, null, str);
    }

    public static /* synthetic */ String bytesToHex$default(BleUtil bleUtil, byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return bleUtil.bytesToHex(bArr, z);
    }

    public final String bytesToHex(byte[] bytes, boolean addSpace) {
        if (bytes == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = bytes.length - 1;
        int length2 = bytes.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3 = i2 + 1;
            String hexString = Integer.toHexString(bytes[i] & 255);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
            if (addSpace && length != i2) {
                sb.append(StringUtils.SPACE);
            }
            i++;
            i2 = i3;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String getDeviceName(BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (checkBluetoothPermissions()) {
            String name = device.getName();
            Intrinsics.checkNotNull(name);
            return name;
        }
        return "";
    }

    /* JADX WARN: Code duplicated, block: B:22:0x005a  */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v4 */
    public final SparseArray<byte[]> subpackage(byte[] data, int packageLength) {
        int iRoundToInt;
        byte[] bArr;
        int i;
        int i2 = packageLength;
        Intrinsics.checkNotNullParameter(data, "data");
        ?? r3 = 0;
        boolean z = true;
        if (data.length > i2) {
            if (data.length % i2 == 0) {
                iRoundToInt = data.length / i2;
            } else {
                iRoundToInt = MathKt.roundToInt((data.length / i2) + 1);
            }
            SparseArray<byte[]> sparseArray = new SparseArray<>(iRoundToInt);
            int i3 = 0;
            while (i3 < iRoundToInt) {
                if (iRoundToInt == z || i3 == iRoundToInt - 1) {
                    int length = data.length % i2 == 0 ? i2 : data.length % i2;
                    byte[] bArr2 = new byte[length];
                    Unit unit = Unit.INSTANCE;
                    System.arraycopy(data, i3 * i2, bArr2, r3, length);
                    bArr = bArr2;
                } else {
                    bArr = new byte[i2];
                    Unit unit2 = Unit.INSTANCE;
                    System.arraycopy(data, i3 * i2, bArr, r3, i2);
                }
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(z)) {
                    String str = (i3 + 1) + " data is: " + bytesToHex$default(INSTANCE, bArr, r3, 2, null);
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        i = iRoundToInt;
                    } else {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        i = iRoundToInt;
                        FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                } else {
                    i = iRoundToInt;
                }
                sparseArray.put(i3, bArr);
                i3++;
                i2 = packageLength;
                iRoundToInt = i;
                r3 = 0;
                z = true;
            }
            return sparseArray;
        }
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(1);
        sparseArray2.put(0, data);
        return sparseArray2;
    }
}
