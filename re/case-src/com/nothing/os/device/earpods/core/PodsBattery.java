package com.nothing.os.device.earpods.core;

import android.util.Log;
import com.nothing.os.device.earpods.data.BasePods;
import com.nothing.os.device.earpods.data.PodsItem;
import com.nothing.os.device.earpods.data.PodsMax;
import com.nothing.os.device.earpods.data.PodsOne;
import com.nothing.os.device.earpods.data.PodsPro;
import com.nothing.os.device.earpods.data.PodsPro2;
import com.nothing.os.device.earpods.data.PodsThree;
import com.nothing.os.device.earpods.data.PodsTwo;
import com.nothing.os.device.earpods.data.PodsUnknown;
import com.nothing.xservicecore.XDevice;
import io.flutter.plugins.firebase.crashlytics.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: PodsBattery.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0004\b\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u0012\u001a\u00020\rJ\u0006\u0010\u0013\u001a\u00020\u000fJ\b\u0010\u0014\u001a\u00020\bH\u0016R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/os/device/earpods/core/PodsBattery;", "", "<init>", "()V", "xDevice", "Lcom/nothing/xservicecore/XDevice;", "(Lcom/nothing/xservicecore/XDevice;)V", "manufacturerStr", "", "(Ljava/lang/String;)V", "pods", "Lcom/nothing/os/device/earpods/data/BasePods;", Constants.TIMESTAMP, "", "isFlipped", "", "str", "getAirpods", "getTimestamp", "isDisconnecting", "toString", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PodsBattery {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PodsBattery DISCONNECTED = new PodsBattery();
    private static final int INDEX_1 = 1;
    private static final int INDEX_10 = 10;
    private static final int INDEX_11 = 11;
    private static final int INDEX_12 = 12;
    private static final int INDEX_13 = 13;
    private static final int INDEX_14 = 14;
    private static final int INDEX_15 = 15;
    private static final int INDEX_16 = 16;
    private static final int INDEX_2 = 2;
    private static final int INDEX_4 = 4;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private BasePods pods;
    private final long timestamp;

    /* JADX INFO: compiled from: PodsBattery.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J:\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\u001bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/nothing/os/device/earpods/core/PodsBattery$Companion;", "", "<init>", "()V", "DISCONNECTED", "Lcom/nothing/os/device/earpods/core/PodsBattery;", "getDISCONNECTED", "()Lcom/nothing/os/device/earpods/core/PodsBattery;", "INDEX_15", "", "INDEX_13", "INDEX_16", "INDEX_14", "INDEX_1", "INDEX_10", "INDEX_2", "INDEX_7", "INDEX_6", "INDEX_4", "INDEX_12", "INDEX_11", "INDEX_8", "parseBatteryByModel", "Lcom/nothing/os/device/earpods/data/BasePods;", "modelId", "", "leftPod", "Lcom/nothing/os/device/earpods/data/PodsItem;", "rightPod", "casePod", "singlePod", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PodsBattery getDISCONNECTED() {
            return PodsBattery.DISCONNECTED;
        }

        public static /* synthetic */ BasePods parseBatteryByModel$default(Companion companion, String str, PodsItem podsItem, PodsItem podsItem2, PodsItem podsItem3, PodsItem podsItem4, int i, Object obj) {
            if ((i & 2) != 0) {
                podsItem = new PodsItem(1, false, false, null, 8, null);
            }
            if ((i & 4) != 0) {
                podsItem2 = new PodsItem(1, false, false, null, 8, null);
            }
            if ((i & 8) != 0) {
                podsItem3 = new PodsItem(1, false, false, null, 8, null);
            }
            if ((i & 16) != 0) {
                podsItem4 = new PodsItem(1, false, false, null, 8, null);
            }
            return companion.parseBatteryByModel(str, podsItem, podsItem2, podsItem3, podsItem4);
        }

        public final BasePods parseBatteryByModel(String modelId, PodsItem leftPod, PodsItem rightPod, PodsItem casePod, PodsItem singlePod) {
            Intrinsics.checkNotNullParameter(leftPod, "leftPod");
            Intrinsics.checkNotNullParameter(rightPod, "rightPod");
            Intrinsics.checkNotNullParameter(casePod, "casePod");
            Intrinsics.checkNotNullParameter(singlePod, "singlePod");
            casePod.setCacheBattery(100);
            singlePod.setCacheBattery(100);
            Log.i("PodsBattery", "can't hit airpods return default airpods");
            return new PodsUnknown(leftPod, rightPod, casePod);
        }
    }

    public PodsBattery() {
        this.timestamp = System.currentTimeMillis();
    }

    public PodsBattery(XDevice xDevice) {
        Intrinsics.checkNotNullParameter(xDevice, "xDevice");
        this.timestamp = System.currentTimeMillis();
        BasePods batteryByModel$default = Companion.parseBatteryByModel$default(INSTANCE, xDevice.getModeId(), null, null, null, null, 30, null);
        if (batteryByModel$default != null) {
            PodsItem leftPod = batteryByModel$default.getLeftPod();
            if (leftPod != null) {
                leftPod.setStatus(Integer.valueOf(xDevice.getLeftBattery()));
                leftPod.setCharging(Boolean.valueOf(xDevice.isLeftCharging()));
            }
            PodsItem rightPod = batteryByModel$default.getRightPod();
            if (rightPod != null) {
                rightPod.setStatus(Integer.valueOf(xDevice.getRightBattery()));
                rightPod.setCharging(Boolean.valueOf(xDevice.isRightCharging()));
            }
            PodsItem casePod = batteryByModel$default.getCasePod();
            if (casePod != null) {
                casePod.setStatus(Integer.valueOf(xDevice.getCaseBattery()));
                casePod.setCharging(Boolean.valueOf(xDevice.isCaseCharging()));
            }
        } else {
            batteryByModel$default = null;
        }
        this.pods = batteryByModel$default;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00e1 A[PHI: r2 r4 r5 r7 r11
      0x00e1: PHI (r2v17 int) = (r2v6 int), (r2v21 int) binds: [B:39:0x012a, B:24:0x00df] A[DONT_GENERATE, DONT_INLINE]
      0x00e1: PHI (r4v19 int) = (r4v3 int), (r4v21 int) binds: [B:39:0x012a, B:24:0x00df] A[DONT_GENERATE, DONT_INLINE]
      0x00e1: PHI (r5v12 boolean) = (r5v8 boolean), (r5v18 boolean) binds: [B:39:0x012a, B:24:0x00df] A[DONT_GENERATE, DONT_INLINE]
      0x00e1: PHI (r7v12 boolean) = (r7v9 boolean), (r7v14 boolean) binds: [B:39:0x012a, B:24:0x00df] A[DONT_GENERATE, DONT_INLINE]
      0x00e1: PHI (r11v6 boolean) = (r11v3 boolean), (r11v9 boolean) binds: [B:39:0x012a, B:24:0x00df] A[DONT_GENERATE, DONT_INLINE]] */
    public PodsBattery(String manufacturerStr) {
        int i;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        Intrinsics.checkNotNullParameter(manufacturerStr, "manufacturerStr");
        this.timestamp = System.currentTimeMillis();
        boolean zIsFlipped = isFlipped(manufacturerStr);
        int i3 = Integer.parseInt(new StringBuilder().append(manufacturerStr.charAt(15)).toString(), CharsKt.checkRadix(16));
        int i4 = Integer.parseInt(new StringBuilder().append(manufacturerStr.charAt(13)).toString(), CharsKt.checkRadix(16));
        int i5 = Integer.parseInt(new StringBuilder().append(manufacturerStr.charAt(14)).toString(), CharsKt.checkRadix(16));
        boolean z4 = false;
        boolean z5 = (i5 & 4) != 0;
        int i6 = i5 & 1;
        boolean z6 = i6 != 0;
        int i7 = Integer.parseInt(new StringBuilder().append(manufacturerStr.charAt(11)).toString(), CharsKt.checkRadix(16));
        if (zIsFlipped) {
            i = Integer.parseInt(new StringBuilder().append(manufacturerStr.charAt(12)).toString(), CharsKt.checkRadix(16));
            i2 = Integer.parseInt(new StringBuilder().append(manufacturerStr.charAt(13)).toString(), CharsKt.checkRadix(16));
            z = (i5 & 2) != 0;
            z2 = i6 != 0;
            z3 = (i7 & 8) != 0;
            if ((i7 & 2) != 0) {
                z4 = true;
            }
        } else {
            i = Integer.parseInt(new StringBuilder().append(manufacturerStr.charAt(13)).toString(), CharsKt.checkRadix(16));
            i2 = Integer.parseInt(new StringBuilder().append(manufacturerStr.charAt(12)).toString(), CharsKt.checkRadix(16));
            z = i6 != 0;
            z2 = (i5 & 2) != 0;
            z3 = (i7 & 2) != 0;
            if ((i7 & 8) != 0) {
                z4 = true;
            }
        }
        PodsItem podsItem = new PodsItem(Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z3), null, 8, null);
        PodsItem podsItem2 = new PodsItem(Integer.valueOf(i2), Boolean.valueOf(z2), Boolean.valueOf(z4), null, 8, null);
        PodsItem podsItem3 = new PodsItem(Integer.valueOf(i3), Boolean.valueOf(z5), null, null, 12, null);
        PodsItem podsItem4 = new PodsItem(Integer.valueOf(i4), Boolean.valueOf(z6), null, null, 12, null);
        String strSubstring = manufacturerStr.substring(6, 10);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        char cCharAt = manufacturerStr.charAt(7);
        if (Intrinsics.areEqual("0220", strSubstring)) {
            this.pods = new PodsOne(podsItem, podsItem2, podsItem3);
            Log.i("PodsBattery", "parse hit  Airpods 1st gen");
            return;
        }
        if (Intrinsics.areEqual("0F20", strSubstring)) {
            this.pods = new PodsTwo(podsItem, podsItem2, podsItem3);
            Log.i("PodsBattery", "parse hit  Airpods 2nd gen");
            return;
        }
        if (Intrinsics.areEqual("1320", strSubstring)) {
            this.pods = new PodsThree(podsItem, podsItem2, podsItem3);
            Log.i("PodsBattery", "parse hit  Airpods 3rd gen");
            return;
        }
        if (Intrinsics.areEqual("0E20", strSubstring)) {
            this.pods = new PodsPro(podsItem, podsItem2, podsItem3);
            Log.i("PodsBattery", "parse hit  Airpods Pro 1");
            return;
        }
        if (Intrinsics.areEqual("1420", strSubstring)) {
            this.pods = new PodsPro2(podsItem, podsItem2, podsItem3);
            Log.i("PodsBattery", "parse hit  Airpods Pro 2");
            return;
        }
        if ('A' == cCharAt) {
            this.pods = new PodsMax(podsItem4);
            Log.i("PodsBattery", "parse hit  Airpods Max");
        } else {
            if ('B' == cCharAt || Intrinsics.areEqual("0520", strSubstring) || Intrinsics.areEqual("1020", strSubstring) || Intrinsics.areEqual("0620", strSubstring) || '9' == cCharAt) {
                return;
            }
            Intrinsics.areEqual("0320", strSubstring);
        }
    }

    private final boolean isFlipped(String str) {
        return (Integer.parseInt(new StringBuilder().append(str.charAt(10)).toString(), CharsKt.checkRadix(16)) & 2) == 0;
    }

    /* JADX INFO: renamed from: getAirpods, reason: from getter */
    public final BasePods getPods() {
        return this.pods;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final boolean isDisconnecting() {
        PodsItem leftPod;
        Integer status;
        BasePods basePods;
        PodsItem rightPod;
        Integer status2;
        BasePods basePods2;
        PodsItem casePod;
        Integer status3;
        BasePods basePods3 = this.pods;
        return (basePods3 == null || (leftPod = basePods3.getLeftPod()) == null || (status = leftPod.getStatus()) == null || status.intValue() != 1 || (basePods = this.pods) == null || (rightPod = basePods.getRightPod()) == null || (status2 = rightPod.getStatus()) == null || status2.intValue() != 1 || (basePods2 = this.pods) == null || (casePod = basePods2.getCasePod()) == null || (status3 = casePod.getStatus()) == null || status3.intValue() != 1) ? false : true;
    }

    public String toString() {
        BasePods pods = getPods();
        return String.valueOf(pods != null ? pods.parseStatusForLogger() : null);
    }
}
