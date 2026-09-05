package com.nothing.core.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SimpleEQEntity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/nothing/core/entity/SimpleEQEntity;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "totalGain", "", "getTotalGain", "()F", "setTotalGain", "(F)V", "eqList", "", "Lcom/nothing/core/entity/EQValueEntity;", "getEqList", "()Ljava/util/List;", "setEqList", "(Ljava/util/List;)V", "obtainDataPacket", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleEQEntity implements ITWSParse {
    public static final int INDEX_STEP_FIVE = 5;
    public static final int INDEX_STEP_FOUR = 4;
    public static final int INDEX_STEP_ONE = 1;
    public static final int INDEX_STEP_SIX = 6;
    public static final int INDEX_STEP_THIRTY = 13;
    public static final int INDEX_STEP_TWO = 2;
    private List<EQValueEntity> eqList;
    private float totalGain;

    /* JADX WARN: Multi-variable type inference failed */
    public SimpleEQEntity() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public SimpleEQEntity(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 != null) {
            int i = DataExtKt.toInt(bArr2, 0, 1);
            this.totalGain = DataExtKt.toFloat$default(bArr2, 1, 4, 0, 4, null);
            ArrayList arrayList = new ArrayList(i);
            int i2 = 5;
            for (int i3 = 0; i3 < i; i3++) {
                int i4 = i2 + (i3 * 13);
                int i5 = DataExtKt.toInt(bArr2, i4, 1);
                float float$default = DataExtKt.toFloat$default(bArr2, i4 + 1, 4, 0, 4, null);
                bArr2 = bArr;
                i2 = i4 + 9;
                arrayList.add(new EQValueEntity(i5, float$default, DataExtKt.toFloat$default(bArr2, i4 + 5, 4, 0, 4, null), DataExtKt.toFloat$default(bArr2, i2, 4, 0, 4, null), 0.0f, 0.0f, 48, null));
            }
            this.eqList = arrayList;
        }
    }

    public /* synthetic */ SimpleEQEntity(byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr);
    }

    public final float getTotalGain() {
        return this.totalGain;
    }

    public final void setTotalGain(float f) {
        this.totalGain = f;
    }

    public final List<EQValueEntity> getEqList() {
        return this.eqList;
    }

    public final void setEqList(List<EQValueEntity> list) {
        this.eqList = list;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        List<EQValueEntity> list = this.eqList;
        int size = list != null ? list.size() : 0;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((size * 13) + 5);
        byteBufferAllocate.put((byte) size);
        byteBufferAllocate.put(DataExtKt.toByteArray(this.totalGain));
        List<EQValueEntity> list2 = this.eqList;
        if (list2 != null) {
            for (EQValueEntity eQValueEntity : list2) {
                byteBufferAllocate.put((byte) eQValueEntity.getFilterType());
                byteBufferAllocate.put(DataExtKt.toByteArray(eQValueEntity.getGain()));
                byteBufferAllocate.put(DataExtKt.toByteArray(eQValueEntity.getFrequency()));
                byteBufferAllocate.put(DataExtKt.toByteArray(eQValueEntity.getQuality()));
            }
        }
        byteBufferAllocate.rewind();
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }
}
