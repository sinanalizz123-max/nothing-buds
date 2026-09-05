package com.nothing.earbase.anc.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceNoiseReduction.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016R-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/earbase/anc/entity/DeviceNoiseReduction;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "values", "Ljava/util/HashMap;", "", "Lcom/nothing/earbase/anc/entity/DeviceNoiseItem;", "Lkotlin/collections/HashMap;", "getValues", "()Ljava/util/HashMap;", "updateLastNoiseReductionLevel", "", "value", "obtainDataPacket", "getNoiseReductionMode", "getLastNoiseReductionLevel", "toString", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceNoiseReduction implements ITWSParse {
    public static final int KEY_LEN = 1;
    public static final int MODE_NOISE_COMFORTABLE = 6;
    public static final int MODE_NOISE_REDUCTION_CLOSE = 5;
    public static final int MODE_NOISE_REDUCTION_MEDIUM = 2;
    public static final int MODE_NOISE_REDUCTION_SMART_1 = 4;
    public static final int MODE_NOISE_REDUCTION_SMART_2 = 8;
    public static final int MODE_NOISE_REDUCTION_STRONG = 1;
    public static final int MODE_NOISE_REDUCTION_WEAK = 3;
    public static final int MODE_PASS_THROUGH = 7;
    public static final int NOISE_REDUCTION_LEVEL = 2;
    public static final int NOISE_REDUCTION_MODE = 1;
    public static final int STEP = 3;
    public static final int VALUE_NOISE_COMFORTABLE = 255;
    public static final int VALUE_NOISE_REDUCTION_CLOSE = 0;
    public static final int VALUE_NOISE_REDUCTION_SMART_1 = 253;
    public static final int VALUE_NOISE_REDUCTION_SMART_2 = 252;
    public static final int VALUE_PASS_THROUGH = 254;
    public static final int VALUE_RANGE_MAX = 127;
    public static final int VALUE_RANGE_MIN = 1;
    private final HashMap<Integer, DeviceNoiseItem> values;

    public DeviceNoiseReduction(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.values = new HashMap<>();
        int length = payload.length / 3;
        for (int i = 0; i < length; i++) {
            int i2 = i * 3;
            int i3 = DataExtKt.toInt(payload, i2, 1);
            int i4 = DataExtKt.toInt(payload, i2 + 1, 1);
            int i5 = DataExtKt.toInt(payload, i2 + 2, 1);
            this.values.put(Integer.valueOf(i3), new DeviceNoiseItem(i3, i4, i5));
        }
    }

    public final HashMap<Integer, DeviceNoiseItem> getValues() {
        return this.values;
    }

    public final void updateLastNoiseReductionLevel(int value) {
        DeviceNoiseItem lastNoiseReductionLevel;
        if ((value == 1 || value == 2 || value == 3 || value == 4) && (lastNoiseReductionLevel = getLastNoiseReductionLevel()) != null) {
            lastNoiseReductionLevel.setValue(value);
        }
        DeviceNoiseItem noiseReductionMode = getNoiseReductionMode();
        if (noiseReductionMode != null) {
            noiseReductionMode.setValue(value);
        }
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.values.size() * 3);
        for (Map.Entry<Integer, DeviceNoiseItem> entry : this.values.entrySet()) {
            byteBufferAllocate.put((byte) entry.getValue().getType());
            byteBufferAllocate.put((byte) entry.getValue().getValue());
            byteBufferAllocate.put((byte) entry.getValue().getNone());
        }
        byteBufferAllocate.rewind();
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public final DeviceNoiseItem getNoiseReductionMode() {
        return this.values.get(1);
    }

    public final DeviceNoiseItem getLastNoiseReductionLevel() {
        return this.values.get(2);
    }

    public String toString() {
        return "DeviceNoiseReduction(" + this.values + ")";
    }
}
