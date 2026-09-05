package com.nothing.protocol.device;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.log.FileLog;
import com.nothing.protocol.model.Message;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: TWSDeviceBuilder.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
public final class TWSDeviceBuilder$sendMessageWithLiveData$$inlined$parseLiveData$1<T> implements Function1<Message, T> {
    final /* synthetic */ Class $clazz;
    final /* synthetic */ TWSDeviceBuilder this$0;

    public TWSDeviceBuilder$sendMessageWithLiveData$$inlined$parseLiveData$1(TWSDeviceBuilder tWSDeviceBuilder, Class cls) {
        this.this$0 = tWSDeviceBuilder;
        this.$clazz = cls;
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(Message message) {
        byte[] payload;
        Float f;
        T tNewInstance = null;
        if (message != null && (payload = message.getPayload()) != null) {
            Class cls = this.$clazz;
            byte[] bArr = payload;
            try {
                if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                    Integer numValueOf = Integer.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null));
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    f = numValueOf;
                } else if (Intrinsics.areEqual(cls, Long.TYPE)) {
                    Long lValueOf = Long.valueOf(DataExtKt.toLong$default(bArr, 0, 0, 3, null));
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    f = lValueOf;
                } else if (Intrinsics.areEqual(cls, String.class)) {
                    String strDecodeToString = StringsKt.decodeToString(bArr);
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    f = strDecodeToString;
                } else if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                    Boolean boolValueOf = Boolean.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null) == 1);
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    f = boolValueOf;
                } else if (Intrinsics.areEqual(cls, Float.TYPE)) {
                    Float fValueOf = Float.valueOf(DataExtKt.toFloat$default(bArr, 0, 0, 0, 7, null));
                    Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                    f = fValueOf;
                } else {
                    try {
                        tNewInstance = cls.getConstructor(byte[].class).newInstance(bArr);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    f = tNewInstance;
                }
                tNewInstance = (T) f;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        Logger logger = Logger.INSTANCE;
        Class cls2 = this.$clazz;
        Logger logger2 = logger;
        String tag = logger2.getTAG();
        int depth = logger2.getDepth();
        if (logger2.isCanLogger(true)) {
            String str = "parseLiveData " + cls2 + StringUtils.SPACE + tNewInstance + StringUtils.SPACE;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger2.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger2.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger2.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return tNewInstance;
    }
}
