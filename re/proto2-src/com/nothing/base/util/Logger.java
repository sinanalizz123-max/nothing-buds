package com.nothing.base.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.nothing.log.FileLog;
import com.nothing.news_service.util.NewsServiceDebugUtil;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.MachineMetadata;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007J\u001e\u0010\n\u001a\u00020\u0005*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000J\u001e\u0010\u000f\u001a\u00020\u0005*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000J\u001e\u0010\u0010\u001a\u00020\u0005*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000J\u001e\u0010\u0011\u001a\u00020\u0005*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0012"}, d2 = {"Lcom/nothing/base/util/Logger;", "Lcom/nothing/log/Logger;", "<init>", "()V", "initDebugFlag", "", "context", "Landroid/content/Context;", "getDebugFromCtx", "", "logI", "", "action", "Lkotlin/Function0;", "", "logD", "logW", "logE", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Logger extends com.nothing.log.Logger {
    public static final Logger INSTANCE;

    private Logger() {
    }

    @JvmStatic
    public static final void initDebugFlag(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Logger logger = INSTANCE;
        boolean debugFromCtx = logger.getDebugFromCtx(context);
        logger.initLogger(context, debugFromCtx);
        Logger logger2 = logger;
        String tag = logger2.getTAG();
        int depth = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str = "news_test isDebug:" + debugFromCtx;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger2.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        NewsServiceDebugUtil.INSTANCE.setDebuggable(debugFromCtx);
    }

    public final boolean getDebugFromCtx(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z = false;
        try {
            Result.Companion companion = Result.INSTANCE;
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String str2 = packageInfo.versionName;
            if ((str2 != null && StringsKt.contains$default((CharSequence) str2, (CharSequence) "Beta", false, 2, (Object) null)) || ((str = packageInfo.versionName) != null && StringsKt.contains$default((CharSequence) str, (CharSequence) MachineMetadata.MACHINE_ALPHA, false, 2, (Object) null))) {
                z = true;
            }
            Result.m6347constructorimpl(Unit.INSTANCE);
            return z;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m6347constructorimpl(ResultKt.createFailure(th));
            return z;
        }
    }

    static {
        Logger logger = new Logger();
        INSTANCE = logger;
        logger.setTAG("NtLog");
    }

    public final void logI(Object obj, Function0<String> action) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Logger logger = this;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String strInvoke = action.invoke();
            String str = strInvoke;
            if (str == null || str.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str2 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            FileLog.print$default(fileLog, 4, str2, tag, strInvoke + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, strInvoke + StringUtils.SPACE + strComponent2);
            }
        }
    }

    public final void logD(Object obj, Function0<String> action) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Logger logger = this;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String strInvoke = action.invoke();
            String str = strInvoke;
            if (str == null || str.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str2 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            FileLog.print$default(fileLog, 3, str2, tag, strInvoke + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.i(tag + strComponent1, strInvoke + StringUtils.SPACE + strComponent2);
            }
        }
    }

    public final void logW(Object obj, Function0<String> action) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Logger logger = this;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String strInvoke = action.invoke();
            String str = strInvoke;
            if (str == null || str.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str2 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            FileLog.print$default(fileLog, 5, str2, tag, strInvoke + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.w(tag + strComponent1, strInvoke + StringUtils.SPACE + strComponent2);
            }
        }
    }

    public final void logE(Object obj, Function0<String> action) {
        Intrinsics.checkNotNullParameter(obj, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        Logger logger = this;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String strInvoke = action.invoke();
            String str = strInvoke;
            if (str == null || str.length() == 0) {
                return;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str2 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            FileLog.print$default(fileLog, 6, str2, tag, strInvoke + StringUtils.SPACE + strComponent2, null, 16, null);
            if (logger.isDebug()) {
                Log.e(tag + strComponent1, strInvoke + StringUtils.SPACE + strComponent2);
            }
        }
    }
}
