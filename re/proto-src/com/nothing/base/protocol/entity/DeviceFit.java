package com.nothing.base.protocol.entity;

import android.util.Log;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.log.FileLog;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: DeviceFit.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/nothing/base/protocol/entity/DeviceFit;", "", "payload", "", "<init>", "([B)V", "leftFitResult", "", "getLeftFitResult", "()I", "setLeftFitResult", "(I)V", "rightFitResult", "getRightFitResult", "setRightFitResult", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceFit {
    private int leftFitResult;
    private int rightFitResult;

    public DeviceFit(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "payload:" + DataExtKt.contentToHexString(payload) + StringUtils.SPACE;
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
        this.leftFitResult = DataExtKt.getIntOrZero(payload, 0);
        this.rightFitResult = DataExtKt.getIntOrZero(payload, 1);
    }

    public final int getLeftFitResult() {
        return this.leftFitResult;
    }

    public final void setLeftFitResult(int i) {
        this.leftFitResult = i;
    }

    public final int getRightFitResult() {
        return this.rightFitResult;
    }

    public final void setRightFitResult(int i) {
        this.rightFitResult = i;
    }
}
