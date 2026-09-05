package com.nothing.link.bluetooth.sdk.util;

import android.content.Context;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/util/Logger;", "Lcom/nothing/log/Logger;", "()V", "changeDebugFlag", "", "isLogSwitchOn", "", "initDebugFlag", "context", "Landroid/content/Context;", Constant.METHOD_DEBUG, "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Logger extends com.nothing.log.Logger {
    public static final Logger INSTANCE;

    private Logger() {
    }

    static {
        Logger logger = new Logger();
        INSTANCE = logger;
        logger.setTAG("XBluetooth-");
    }

    @JvmStatic
    public static final void initDebugFlag(Context context, boolean debug) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.initLogger(context, debug);
    }

    @JvmStatic
    public static final void changeDebugFlag(boolean isLogSwitchOn) {
        INSTANCE.changeDebug(isLogSwitchOn);
    }
}
