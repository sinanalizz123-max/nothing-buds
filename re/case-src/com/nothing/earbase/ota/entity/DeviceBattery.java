package com.nothing.earbase.ota.entity;

import android.util.SparseArray;
import androidx.core.util.SparseArrayKt;
import com.nothing.base.model.Battery;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceBattery.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0000J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/nothing/earbase/ota/entity/DeviceBattery;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "battery", "Landroid/util/SparseArray;", "Lcom/nothing/base/model/Battery;", "getBattery", "()Landroid/util/SparseArray;", "watch", "getWatch", "()Lcom/nothing/base/model/Battery;", "left", "getLeft", "right", "getRight", "case", "getCase", "tws", "getTws", "stereo", "getStereo", "obtainDataPacket", "isSameBattery", "", "hasBattery", "hasCaseBattery", "toString", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceBattery implements ITWSParse {
    private static final int BATTERY_MASK = 127;
    private static final int RECHARGING_MASK = 128;
    private final SparseArray<Battery> battery;

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        return new byte[0];
    }

    public DeviceBattery(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.battery = DataExtKt.toSparseArray(DataExtKt.toPairs$default(payload, 0, 0, 0, 7, null), new Function2() { // from class: com.nothing.earbase.ota.entity.DeviceBattery$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DeviceBattery.battery$lambda$0(((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        });
    }

    public final SparseArray<Battery> getBattery() {
        return this.battery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Battery battery$lambda$0(int i, int i2) {
        return new Battery(i, i2 & 127, (i2 & 128) != 0);
    }

    public final Battery getWatch() {
        return this.battery.get(1);
    }

    public final Battery getLeft() {
        return this.battery.get(2);
    }

    public final Battery getRight() {
        return this.battery.get(3);
    }

    public final Battery getCase() {
        return this.battery.get(4);
    }

    public final Battery getTws() {
        return this.battery.get(5);
    }

    public final Battery getStereo() {
        Battery battery = this.battery.get(6);
        return battery == null ? this.battery.get(7) : battery;
    }

    public final boolean isSameBattery(DeviceBattery battery) {
        if (battery == null) {
            return false;
        }
        if (battery.getStereo() != null) {
            Battery stereo = battery.getStereo();
            Integer numValueOf = stereo != null ? Integer.valueOf(stereo.getBattery()) : null;
            Battery stereo2 = getStereo();
            if (Intrinsics.areEqual(numValueOf, stereo2 != null ? Integer.valueOf(stereo2.getBattery()) : null)) {
                Battery stereo3 = battery.getStereo();
                Boolean boolValueOf = stereo3 != null ? Boolean.valueOf(stereo3.isRecharging()) : null;
                Battery stereo4 = getStereo();
                if (Intrinsics.areEqual(boolValueOf, stereo4 != null ? Boolean.valueOf(stereo4.isRecharging()) : null)) {
                    return true;
                }
            }
            return false;
        }
        Battery battery2 = battery.getCase();
        Integer numValueOf2 = battery2 != null ? Integer.valueOf(battery2.getBattery()) : null;
        Battery battery3 = getCase();
        if (Intrinsics.areEqual(numValueOf2, battery3 != null ? Integer.valueOf(battery3.getBattery()) : null)) {
            Battery battery4 = battery.getCase();
            Boolean boolValueOf2 = battery4 != null ? Boolean.valueOf(battery4.isRecharging()) : null;
            Battery battery5 = getCase();
            if (Intrinsics.areEqual(boolValueOf2, battery5 != null ? Boolean.valueOf(battery5.isRecharging()) : null)) {
                Battery left = battery.getLeft();
                Integer numValueOf3 = left != null ? Integer.valueOf(left.getBattery()) : null;
                Battery left2 = getLeft();
                if (Intrinsics.areEqual(numValueOf3, left2 != null ? Integer.valueOf(left2.getBattery()) : null)) {
                    Battery left3 = battery.getLeft();
                    Boolean boolValueOf3 = left3 != null ? Boolean.valueOf(left3.isRecharging()) : null;
                    Battery left4 = getLeft();
                    if (Intrinsics.areEqual(boolValueOf3, left4 != null ? Boolean.valueOf(left4.isRecharging()) : null)) {
                        Battery right = battery.getRight();
                        Integer numValueOf4 = right != null ? Integer.valueOf(right.getBattery()) : null;
                        Battery right2 = getRight();
                        if (Intrinsics.areEqual(numValueOf4, right2 != null ? Integer.valueOf(right2.getBattery()) : null)) {
                            Battery right3 = battery.getRight();
                            Boolean boolValueOf4 = right3 != null ? Boolean.valueOf(right3.isRecharging()) : null;
                            Battery right4 = getRight();
                            if (Intrinsics.areEqual(boolValueOf4, right4 != null ? Boolean.valueOf(right4.isRecharging()) : null)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean hasBattery() {
        return (getCase() == null && getRight() == null && getLeft() == null && getStereo() == null) ? false : true;
    }

    public final boolean hasCaseBattery() {
        return (getCase() == null && getStereo() == null) ? false : true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator itValueIterator = SparseArrayKt.valueIterator(this.battery);
        while (itValueIterator.hasNext()) {
            sb.append(((Battery) itValueIterator.next()).toString()).append(", ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
