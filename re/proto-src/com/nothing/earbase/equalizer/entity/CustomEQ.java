package com.nothing.earbase.equalizer.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import io.mimi.sdk.testflow.analytics.TrackingConstants;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomEQ.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/nothing/earbase/equalizer/entity/CustomEQ;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "totalGain", "", "getTotalGain", "()F", "setTotalGain", "(F)V", "getCustomValues", "", "Lcom/nothing/earbase/equalizer/entity/CustomEQ$EQ;", "obtainDataPacket", "values", "getValues", "()Ljava/util/List;", "toString", "", "EQ", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomEQ implements ITWSParse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int HIGH_PASS = 4;
    public static final int HIGH_SHELF = 2;
    private static final int INDEX_STEP_FIVE = 5;
    private static final int INDEX_STEP_FOUR = 4;
    private static final int INDEX_STEP_ONE = 1;
    private static final int INDEX_STEP_SIXTY = 16;
    private static final int INDEX_STEP_THIRTY = 13;
    public static final int LOW_PASS = 3;
    public static final int LOW_SHELF = 0;
    public static final int PEAK = 1;
    private final byte[] payload;
    private float totalGain;
    private final List<EQ> values;

    public CustomEQ(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.payload = payload;
        this.totalGain = -5.0f;
        this.values = getCustomValues();
    }

    public final float getTotalGain() {
        return this.totalGain;
    }

    public final void setTotalGain(float f) {
        this.totalGain = f;
    }

    private final List<EQ> getCustomValues() {
        int i = DataExtKt.toInt(this.payload, 0, 1);
        this.totalGain = DataExtKt.toFloat$default(this.payload, 1, 4, 0, 4, null);
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 13;
            arrayList.add(new EQ(DataExtKt.toInt(this.payload, i3 + 5, 1), DataExtKt.toFloat$default(this.payload, i3 + 6, 4, 0, 4, null), DataExtKt.toFloat$default(this.payload, i3 + 10, 4, 0, 4, null), DataExtKt.toFloat$default(this.payload, i3 + 14, 4, 0, 4, null)));
        }
        return arrayList;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        int size = this.values.size();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((size * 16) + 5);
        byteBufferAllocate.put((byte) size);
        byteBufferAllocate.put(DataExtKt.toByteArray(this.totalGain));
        for (EQ eq : this.values) {
            byteBufferAllocate.put((byte) eq.getFilterType()).put(DataExtKt.toByteArray(eq.getGain())).put(DataExtKt.toByteArray(eq.getFrequency())).put(DataExtKt.toByteArray(eq.getQuality()));
        }
        byteBufferAllocate.rewind();
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public final List<EQ> getValues() {
        return this.values;
    }

    /* JADX INFO: compiled from: CustomEQ.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/earbase/equalizer/entity/CustomEQ$EQ;", "", "filterType", "", "gain", "", TrackingConstants.TRACKING_PROPERTY_FREQUENCY, "quality", "<init>", "(IFFF)V", "getFilterType", "()I", "getGain", "()F", "setGain", "(F)V", "getFrequency", "getQuality", "toString", "", "buriedInfo", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class EQ {
        private final int filterType;
        private final float frequency;
        private float gain;
        private final float quality;

        public EQ(int i, float f, float f2, float f3) {
            this.filterType = i;
            this.gain = f;
            this.frequency = f2;
            this.quality = f3;
        }

        public final int getFilterType() {
            return this.filterType;
        }

        public final float getGain() {
            return this.gain;
        }

        public final void setGain(float f) {
            this.gain = f;
        }

        public final float getFrequency() {
            return this.frequency;
        }

        public final float getQuality() {
            return this.quality;
        }

        public String toString() {
            return "filterType : " + this.filterType + ",gain : " + this.gain + ",frequency : " + this.frequency + ",quality : " + this.quality;
        }

        public final String buriedInfo() {
            return this.filterType + "_" + this.gain;
        }
    }

    public String toString() {
        return "CustomEQ(values=" + CollectionsKt.joinToString$default(this.values, null, null, null, 0, null, null, 63, null) + ")";
    }

    /* JADX INFO: compiled from: CustomEQ.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/earbase/equalizer/entity/CustomEQ$Companion;", "", "<init>", "()V", "INDEX_STEP_ONE", "", "INDEX_STEP_FOUR", "INDEX_STEP_FIVE", "INDEX_STEP_THIRTY", "INDEX_STEP_SIXTY", "LOW_SHELF", "PEAK", "HIGH_SHELF", "LOW_PASS", "HIGH_PASS", "obtainDataPacket", "", "totalGain", "", "eqList", "", "Lcom/nothing/earbase/equalizer/entity/CustomEQ$EQ;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] obtainDataPacket(float totalGain, List<EQ> eqList) {
            Intrinsics.checkNotNullParameter(eqList, "eqList");
            int size = eqList.size();
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate((size * 16) + 5);
            byteBufferAllocate.put((byte) size);
            byteBufferAllocate.put(DataExtKt.toByteArray(totalGain));
            for (EQ eq : eqList) {
                byteBufferAllocate.put((byte) eq.getFilterType()).put(DataExtKt.toByteArray(eq.getGain())).put(DataExtKt.toByteArray(eq.getFrequency())).put(DataExtKt.toByteArray(eq.getQuality()));
            }
            byteBufferAllocate.rewind();
            byte[] bArrArray = byteBufferAllocate.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
            return bArrArray;
        }
    }
}
