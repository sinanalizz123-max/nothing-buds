package com.nothing.ear.one.core.protocol.entity;

import android.graphics.Color;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.util.ext.DataExtKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.tika.metadata.TikaCoreProperties;

/* JADX INFO: compiled from: DeviceBoxLed.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\f2\n\u0010\r\u001a\u00020\u000e\"\u00020\u000fJ\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0018H\u0016R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u001b"}, d2 = {"Lcom/nothing/ear/one/core/protocol/entity/DeviceBoxLed;", "", "payload", "", "<init>", "([B)V", "ledList", "Ljava/util/ArrayList;", "Lcom/nothing/ear/one/core/protocol/entity/DeviceBoxLed$BoxLed;", "Lkotlin/collections/ArrayList;", "getLedList", "()Ljava/util/ArrayList;", "", "types", "", "", "getLed", "type", "(I)Ljava/lang/Integer;", "setLed", "", "rgb", "obtainDataPacket", "toString", "", "BoxLed", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceBoxLed {
    public static final int BATTERY_CHARGING = 4;
    public static final int BATTERY_CHARGING_FULL = 5;
    public static final int BATTERY_HIGH = 3;
    public static final int BATTERY_LOW = 1;
    public static final int BATTERY_MEDIUM = 2;
    public static final int BATTERY_PAIRING = 6;
    public static final int COLOR_BLUE = -16773056;
    public static final int COLOR_GREEN = -16179200;
    public static final int COLOR_ORANGE = -10483200;
    public static final int COLOR_RED = -11795968;
    public static final int COLOR_WHITE = -1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int INDEX_BLUE = 3;
    private static final int INDEX_GREEN = 2;
    private static final int INDEX_RED = 1;
    private static final int INDEX_TYPE = 0;
    private final ArrayList<BoxLed> ledList;

    public DeviceBoxLed(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.ledList = new ArrayList<>();
        for (int[] iArr : DataExtKt.toMultiValues(payload, 1, 1, 1, 1, 1)) {
            this.ledList.add(new BoxLed(iArr[0], iArr[1], iArr[2], iArr[3]));
        }
    }

    public final ArrayList<BoxLed> getLedList() {
        return this.ledList;
    }

    public final Integer getLed(int type) {
        Object next;
        Iterator<T> it = this.ledList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((BoxLed) next).getType() != type);
        BoxLed boxLed = (BoxLed) next;
        if (boxLed != null) {
            return Integer.valueOf(boxLed.getRgb());
        }
        return null;
    }

    public final void setLed(int type, int rgb) {
        Object next;
        Iterator<T> it = this.ledList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((BoxLed) next).getType() != type);
        BoxLed boxLed = (BoxLed) next;
        if (boxLed != null) {
            boxLed.setRgb(rgb);
        }
    }

    public final byte[] obtainDataPacket() {
        int size = this.ledList.size();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((size * 4) + 1);
        byteBufferAllocate.put((byte) size);
        for (BoxLed boxLed : this.ledList) {
            byteBufferAllocate.put((byte) boxLed.getType()).put((byte) boxLed.getRed()).put((byte) boxLed.getGreen()).put((byte) boxLed.getBlue());
        }
        byteBufferAllocate.rewind();
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = this.ledList.iterator();
        while (it.hasNext()) {
            sb.append(((BoxLed) it.next()).toString());
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: DeviceBoxLed.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0003J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\n\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\n\u00a8\u0006$"}, d2 = {"Lcom/nothing/ear/one/core/protocol/entity/DeviceBoxLed$BoxLed;", "", "type", "", "red", "green", "blue", "<init>", "(IIII)V", "getType", "()I", "getRed", "setRed", "(I)V", "getGreen", "setGreen", "getBlue", "setBlue", "color", "getColor", "getRgb", "getRgbStr", "", "setRgb", "", "rgb", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class BoxLed {
        private int blue;
        private int green;
        private int red;
        private final int type;

        public static /* synthetic */ BoxLed copy$default(BoxLed boxLed, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = boxLed.type;
            }
            if ((i5 & 2) != 0) {
                i2 = boxLed.red;
            }
            if ((i5 & 4) != 0) {
                i3 = boxLed.green;
            }
            if ((i5 & 8) != 0) {
                i4 = boxLed.blue;
            }
            return boxLed.copy(i, i2, i3, i4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getRed() {
            return this.red;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getGreen() {
            return this.green;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getBlue() {
            return this.blue;
        }

        public final BoxLed copy(int type, int red, int green, int blue) {
            return new BoxLed(type, red, green, blue);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BoxLed)) {
                return false;
            }
            BoxLed boxLed = (BoxLed) other;
            return this.type == boxLed.type && this.red == boxLed.red && this.green == boxLed.green && this.blue == boxLed.blue;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.red)) * 31) + Integer.hashCode(this.green)) * 31) + Integer.hashCode(this.blue);
        }

        public BoxLed(int i, int i2, int i3, int i4) {
            this.type = i;
            this.red = i2;
            this.green = i3;
            this.blue = i4;
            if (i2 == i - 1 && i3 == i - 1 && i4 == i - 1) {
                setRgb(DeviceBoxLed.INSTANCE.obtainDefault(i));
            }
        }

        public final int getBlue() {
            return this.blue;
        }

        public final int getGreen() {
            return this.green;
        }

        public final int getRed() {
            return this.red;
        }

        public final int getType() {
            return this.type;
        }

        public final void setBlue(int i) {
            this.blue = i;
        }

        public final void setGreen(int i) {
            this.green = i;
        }

        public final void setRed(int i) {
            this.red = i;
        }

        public final int getColor() {
            return Color.rgb(this.red, this.green, this.blue);
        }

        public final int getRgb() {
            return (this.red << 16) + (this.green << 8) + this.blue;
        }

        public final String getRgbStr() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(getRgb())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }

        public final void setRgb(int rgb) {
            this.red = (rgb >> 16) & 255;
            this.green = (rgb >> 8) & 255;
            this.blue = rgb & 255;
        }

        public String toString() {
            int i = this.type;
            switch (i) {
                case 1:
                    return "\u4f4e\u7535\u91cf:" + getRgbStr();
                case 2:
                    return "\u4e2d\u7535\u91cf:" + getRgbStr();
                case 3:
                    return "\u9ad8\u7535\u91cf:" + getRgbStr();
                case 4:
                    return "\u5145\u7535\u4e2d:" + getRgbStr();
                case 5:
                    return "\u5145\u6ee1\u7535:" + getRgbStr();
                case 6:
                    return "\u914d\u5bf9:" + getRgbStr();
                default:
                    return "\u672a\u77e5(" + i + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + getRgbStr() + ")";
            }
        }
    }

    /* JADX INFO: compiled from: DeviceBoxLed.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/ear/one/core/protocol/entity/DeviceBoxLed$Companion;", "", "<init>", "()V", "INDEX_TYPE", "", "INDEX_RED", "INDEX_GREEN", "INDEX_BLUE", "COLOR_RED", "COLOR_ORANGE", "COLOR_GREEN", "COLOR_BLUE", "COLOR_WHITE", "BATTERY_LOW", "BATTERY_MEDIUM", "BATTERY_HIGH", "BATTERY_CHARGING", "BATTERY_CHARGING_FULL", "BATTERY_PAIRING", "obtainDefault", "type", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int obtainDefault(int type) {
            if (type == 1) {
                return -11795968;
            }
            if (type != 2) {
                return (type == 3 || type != 4) ? -16179200 : -11795968;
            }
            return -10483200;
        }

        private Companion() {
        }
    }

    public final List<BoxLed> getLedList(int... types) {
        Object next;
        Intrinsics.checkNotNullParameter(types, "types");
        ArrayList arrayList = new ArrayList(types.length);
        for (int i : types) {
            Iterator<T> it = this.ledList.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (((BoxLed) next).getType() != i);
            arrayList.add((BoxLed) next);
        }
        return CollectionsKt.filterNotNull(arrayList);
    }
}
