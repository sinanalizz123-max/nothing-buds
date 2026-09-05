package com.nothing.link.bluetooth.sdk.connect.bt;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothLeAudio;
import android.bluetooth.BluetoothProfile;
import android.os.Build;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: LeAudioProfile.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/bt/LeAudioProfile;", "Lcom/nothing/link/bluetooth/sdk/connect/bt/XProfile;", "()V", "getProfileType", "", "isSupportLeAudio", "", "onServiceConnected", "", "profile", "proxy", "Landroid/bluetooth/BluetoothProfile;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class LeAudioProfile extends XProfile {
    @Override // com.nothing.link.bluetooth.sdk.connect.bt.XProfile
    public int getProfileType() {
        return isSupportLeAudio() ? 22 : 0;
    }

    private final boolean isSupportLeAudio() {
        BluetoothAdapter bluetoothAdapter;
        return Build.VERSION.SDK_INT >= 33 && (bluetoothAdapter = getBluetoothAdapter()) != null && bluetoothAdapter.isLeAudioSupported() == 10;
    }

    @Override // com.nothing.link.bluetooth.sdk.connect.bt.XProfile, android.bluetooth.BluetoothProfile.ServiceListener
    public void onServiceConnected(int profile, BluetoothProfile proxy) {
        if (Build.VERSION.SDK_INT < 31 || !(proxy instanceof BluetoothLeAudio)) {
            return;
        }
        super.onServiceConnected(profile, proxy);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "service connected:" + profile + "," + proxy;
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
        setMProfile(proxy);
    }
}
