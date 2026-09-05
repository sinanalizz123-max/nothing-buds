package com.nothing.link.bluetooth.sdk.connect.bt;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.content.IntentCompat;
import com.nothing.link.bluetooth.sdk.util.Logger;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BtReceiver.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/bt/BtReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class BtReceiver extends BroadcastReceiver {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("android.bluetooth.profile.extra.STATE", Integer.MIN_VALUE);
        int intExtra2 = intent.getIntExtra("android.bluetooth.profile.extra.PREVIOUS_STATE", Integer.MIN_VALUE);
        BluetoothDevice bluetoothDevice = (BluetoothDevice) IntentCompat.getParcelableExtra(intent, "android.bluetooth.device.extra.DEVICE", BluetoothDevice.class);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = intent.getAction() + " state:" + intExtra + ",prestate:" + intExtra2 + StringUtils.SPACE + bluetoothDevice;
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
        String action = intent.getAction();
        if (action != null) {
            switch (action.hashCode()) {
                case -1765714821:
                    if (action.equals("android.bluetooth.action.LE_AUDIO_CONNECTION_STATE_CHANGED")) {
                        XBTReceiverHelper.INSTANCE.get().leAudioStateChanged(intExtra, intExtra2, bluetoothDevice);
                        break;
                    }
                    break;
                case -1530327060:
                    if (action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                        XBTReceiverHelper.INSTANCE.get().onStateChanged(intent);
                        break;
                    }
                    break;
                case -301431627:
                    if (action.equals("android.bluetooth.device.action.ACL_CONNECTED")) {
                        XBTReceiverHelper.INSTANCE.get().aclStateChanged(true, bluetoothDevice);
                        break;
                    }
                    break;
                case 545516589:
                    if (action.equals("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED")) {
                        XBTReceiverHelper.INSTANCE.get().headsetStateChanged(intExtra, intExtra2, bluetoothDevice);
                        break;
                    }
                    break;
                case 1244161670:
                    if (action.equals("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED")) {
                        XBTReceiverHelper.INSTANCE.get().a2dpStateChanged(intExtra, intExtra2, bluetoothDevice);
                        break;
                    }
                    break;
                case 1821585647:
                    if (action.equals("android.bluetooth.device.action.ACL_DISCONNECTED")) {
                        XBTReceiverHelper.INSTANCE.get().aclStateChanged(false, bluetoothDevice);
                        break;
                    }
                    break;
                case 2116862345:
                    if (action.equals("android.bluetooth.device.action.BOND_STATE_CHANGED")) {
                        XBTReceiverHelper.INSTANCE.get().bondStatusChange(intent);
                        break;
                    }
                    break;
            }
        }
    }
}
