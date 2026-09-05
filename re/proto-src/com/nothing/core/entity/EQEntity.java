package com.nothing.core.entity;

import android.util.Log;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.log.FileLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EQEntity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0004\b\u0004\u0010\nB\u001f\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0004\u0010\u000eJ\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\u0007H\u0016J\u0013\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010'H\u0096\u0002J\b\u0010(\u001a\u00020)H\u0016R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"\u00a8\u0006+"}, d2 = {"Lcom/nothing/core/entity/EQEntity;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "index", "", "totalGainF", "", "(IF)V", "arrayList", "", "Lcom/nothing/core/entity/EQValueEntity;", "(FLjava/util/List;)V", "profileIndex", "getProfileIndex", "()I", "setProfileIndex", "(I)V", "totalGain", "getTotalGain", "()F", "setTotalGain", "(F)V", "eqList", "getEqList", "()Ljava/util/List;", "setEqList", "(Ljava/util/List;)V", "isInitializer", "", "()Z", "setInitializer", "(Z)V", "obtainDataPacket", "hashCode", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "", "toString", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EQEntity implements ITWSParse {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Triple<Float, Float, Float>[] DEFAULT_FREQUENCY = {new Triple<>(Float.valueOf(55.0f), Float.valueOf(20.0f), Float.valueOf(99.0f)), new Triple<>(Float.valueOf(110.0f), Float.valueOf(100.0f), Float.valueOf(199.0f)), new Triple<>(Float.valueOf(220.0f), Float.valueOf(200.0f), Float.valueOf(399.0f)), new Triple<>(Float.valueOf(440.0f), Float.valueOf(400.0f), Float.valueOf(999.0f)), new Triple<>(Float.valueOf(1320.0f), Float.valueOf(1000.0f), Float.valueOf(2999.0f)), new Triple<>(Float.valueOf(3300.0f), Float.valueOf(3000.0f), Float.valueOf(5999.0f)), new Triple<>(Float.valueOf(6600.0f), Float.valueOf(6000.0f), Float.valueOf(11999.0f)), new Triple<>(Float.valueOf(13200.0f), Float.valueOf(12000.0f), Float.valueOf(20000.0f))};
    public static final float DEFAULT_Q = 1.0f;
    public static final int HIGH_SHELF = 2;
    public static final int INDEX_STEP_FIVE = 5;
    public static final int INDEX_STEP_FOUR = 4;
    public static final int INDEX_STEP_ONE = 1;
    public static final int INDEX_STEP_SIX = 6;
    public static final int INDEX_STEP_THIRTY = 13;
    public static final int INDEX_STEP_TWO = 2;
    public static final int LOW_SHELF = 0;
    public static final int PEAK = 1;
    public static final int SIZE = 8;
    private List<EQValueEntity> eqList;
    private boolean isInitializer;
    private int profileIndex;
    private float totalGain;

    /* JADX WARN: Multi-variable type inference failed */
    public EQEntity() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: compiled from: EQEntity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R+\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u00a2\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/nothing/core/entity/EQEntity$Companion;", "", "<init>", "()V", "INDEX_STEP_FOUR", "", "INDEX_STEP_ONE", "INDEX_STEP_TWO", "INDEX_STEP_FIVE", "INDEX_STEP_SIX", "SIZE", "INDEX_STEP_THIRTY", "LOW_SHELF", "PEAK", "HIGH_SHELF", "DEFAULT_FREQUENCY", "", "Lkotlin/Triple;", "", "getDEFAULT_FREQUENCY", "()[Lkotlin/Triple;", "[Lkotlin/Triple;", "DEFAULT_Q", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Triple<Float, Float, Float>[] getDEFAULT_FREQUENCY() {
            return EQEntity.DEFAULT_FREQUENCY;
        }
    }

    public EQEntity(byte[] bArr) {
        byte[] bArr2 = bArr;
        if (bArr2 != null) {
            this.profileIndex = DataExtKt.toInt(bArr2, 0, 1);
            int i = DataExtKt.toInt(bArr2, 1, 1);
            if (i == 0) {
                this.isInitializer = true;
                i = 8;
            }
            int i2 = i;
            ArrayList arrayList = new ArrayList(i2);
            int i3 = 0;
            int i4 = 6;
            while (i3 < i2) {
                int i5 = DataExtKt.toInt(bArr2, i4, 1);
                int i6 = i5 == 0 ? 1 : i5;
                float float$default = DataExtKt.toFloat$default(bArr2, i4 + 1, 4, 0, 4, null);
                float float$default2 = DataExtKt.toFloat$default(bArr, i4 + 5, 4, 0, 4, null);
                Triple<Float, Float, Float>[] tripleArr = DEFAULT_FREQUENCY;
                float fFloatValue = tripleArr[i3].getSecond().floatValue();
                float fFloatValue2 = tripleArr[i3].getThird().floatValue();
                float fFloatValue3 = (float$default2 > fFloatValue2 || float$default2 < fFloatValue) ? tripleArr[i3].getFirst().floatValue() : float$default2;
                float float$default3 = DataExtKt.toFloat$default(bArr, i4 + 9, 4, 0, 4, null);
                if (float$default3 == 0.0f) {
                    float$default3 = 1.0f;
                }
                i4 += 13;
                arrayList.add(new EQValueEntity(i6, float$default, fFloatValue3, float$default3, fFloatValue, fFloatValue2));
                i3++;
                bArr2 = bArr;
            }
            this.eqList = arrayList;
        }
    }

    public /* synthetic */ EQEntity(byte[] bArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bArr);
    }

    public final int getProfileIndex() {
        return this.profileIndex;
    }

    public final void setProfileIndex(int i) {
        this.profileIndex = i;
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

    /* JADX INFO: renamed from: isInitializer, reason: from getter */
    public final boolean getIsInitializer() {
        return this.isInitializer;
    }

    public final void setInitializer(boolean z) {
        this.isInitializer = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EQEntity(int i, float f) {
        this(null, 1, 0 == true ? 1 : 0);
        this.totalGain = f;
        this.profileIndex = i;
        int length = DEFAULT_FREQUENCY.length;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            Triple<Float, Float, Float>[] tripleArr = DEFAULT_FREQUENCY;
            arrayList.add(new EQValueEntity(1, 0.0f, tripleArr[i2].getFirst().floatValue(), 1.0f, tripleArr[i2].getSecond().floatValue(), tripleArr[i2].getThird().floatValue()));
        }
        this.eqList = arrayList;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public EQEntity(float f, List<EQValueEntity> arrayList) {
        EQValueEntity eQValueEntity;
        this(null, 1, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(arrayList, "arrayList");
        this.totalGain = f;
        int length = DEFAULT_FREQUENCY.length;
        ArrayList arrayList2 = new ArrayList(length);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            Triple<Float, Float, Float>[] tripleArr = DEFAULT_FREQUENCY;
            arrayList2.add(new EQValueEntity(1, 0.0f, tripleArr[i2].getFirst().floatValue(), 1.0f, tripleArr[i2].getSecond().floatValue(), tripleArr[i2].getThird().floatValue()));
        }
        this.eqList = arrayList2;
        for (Object obj : arrayList) {
            int i3 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            EQValueEntity eQValueEntity2 = (EQValueEntity) obj;
            List<EQValueEntity> list = this.eqList;
            if (list != null && (eQValueEntity = list.get(i)) != null) {
                eQValueEntity.setGain(eQValueEntity2.getGain());
                eQValueEntity.setFrequency(eQValueEntity2.getFrequency());
                eQValueEntity.setQuality(eQValueEntity2.getQuality());
            }
            i = i3;
        }
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "onStopTrack  obtainDataPacket " + this;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        List<EQValueEntity> list = this.eqList;
        int size = list != null ? list.size() : 0;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((size * 13) + 6);
        byteBufferAllocate.put((byte) this.profileIndex);
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

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.profileIndex), this.eqList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EQEntity)) {
            return false;
        }
        EQEntity eQEntity = (EQEntity) other;
        return this.profileIndex == eQEntity.profileIndex && Intrinsics.areEqual(this.eqList, eQEntity.eqList);
    }

    public String toString() {
        int i = this.profileIndex;
        List<EQValueEntity> list = this.eqList;
        return "profileIndex:" + i + ",size:" + (list != null ? Integer.valueOf(list.size()) : null) + ",totalGain:" + this.totalGain + ",eqList:" + this.eqList;
    }
}
