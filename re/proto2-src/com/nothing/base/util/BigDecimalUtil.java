package com.nothing.base.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BigDecimalUtil.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\"\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\"\u0010\r\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u000e2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00102\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/nothing/base/util/BigDecimalUtil;", "", "<init>", "()V", "MAX_PROGRESS", "", "add", "d1", "d2", "decimalPoint", "", "sub", "mul", "div", "", "toFloat", "", "toProgress", "maxValue", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BigDecimalUtil {
    public static final BigDecimalUtil INSTANCE = new BigDecimalUtil();
    public static final float MAX_PROGRESS = 100.0f;

    private BigDecimalUtil() {
    }

    public static /* synthetic */ float add$default(float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return add(f, f2, i);
    }

    @JvmStatic
    public static final float add(float d1, float d2, int decimalPoint) {
        return new BigDecimal(String.valueOf(d1)).add(new BigDecimal(String.valueOf(d2))).setScale(decimalPoint, RoundingMode.DOWN).floatValue();
    }

    public static /* synthetic */ float sub$default(float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return sub(f, f2, i);
    }

    @JvmStatic
    public static final float sub(float d1, float d2, int decimalPoint) {
        return new BigDecimal(String.valueOf(d1)).subtract(new BigDecimal(String.valueOf(d2))).setScale(decimalPoint, RoundingMode.DOWN).floatValue();
    }

    public static /* synthetic */ float mul$default(float f, float f2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return mul(f, f2, i);
    }

    @JvmStatic
    public static final float mul(float d1, float d2, int decimalPoint) {
        return new BigDecimal(String.valueOf(d1)).multiply(new BigDecimal(String.valueOf(d2))).setScale(decimalPoint, RoundingMode.DOWN).floatValue();
    }

    public static /* synthetic */ float div$default(double d, double d2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return div(d, d2, i);
    }

    @JvmStatic
    public static final float div(double d1, double d2, int decimalPoint) {
        return new BigDecimal(d1).divide(new BigDecimal(d2)).setScale(decimalPoint, RoundingMode.DOWN).floatValue();
    }

    public static /* synthetic */ float toFloat$default(String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 1;
        }
        return toFloat(str, i);
    }

    @JvmStatic
    public static final float toFloat(String d1, int decimalPoint) {
        Intrinsics.checkNotNullParameter(d1, "d1");
        return new BigDecimal(d1).setScale(decimalPoint, RoundingMode.DOWN).floatValue();
    }

    public static /* synthetic */ String toProgress$default(float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = 100.0f;
        }
        return toProgress(f, f2);
    }

    @JvmStatic
    public static final String toProgress(float d1, float maxValue) {
        return ((d1 / maxValue) * 100) + "%";
    }
}
