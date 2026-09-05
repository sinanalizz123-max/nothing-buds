package com.nothing.base.protocol.entity;

import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.ext.DataExtKt;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.tika.metadata.TikaCoreProperties;

/* JADX INFO: compiled from: DeviceExtraFeatureStatus.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\fJ\u0012\u0010\u0012\u001a\u00020\u00032\n\u0010\r\u001a\u00020\u0013\"\u00020\u000eJ\b\u0010\u0012\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/nothing/base/protocol/entity/DeviceExtraFeatureStatus;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "values", "", "Lcom/nothing/base/protocol/entity/DeviceExtraFeatureStatus$Function;", "getValues", "()Ljava/util/List;", "getEnable", "", "type", "", "(I)Ljava/lang/Boolean;", "setEnable", "enable", "obtainDataPacket", "", "toString", "", "Function", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceExtraFeatureStatus implements ITWSParse {
    public static final int FEATURE_ALEXA = 6;
    public static final int FEATURE_AUTO_ANSWER = 11;
    public static final int FEATURE_AUTO_RECONNECT = 12;
    public static final int FEATURE_AV = 3;
    public static final int FEATURE_BISTO = 5;
    public static final int FEATURE_COMFORTABLE_MODE = 16;
    public static final int FEATURE_DENOISE_ANC = 14;
    public static final int FEATURE_DENOISE_ENC = 18;
    public static final int FEATURE_GAME_MODE = 2;
    public static final int FEATURE_GAV = 4;
    public static final int FEATURE_GOOGLE_FAST_PAIR = 7;
    public static final int FEATURE_INHOUSE_FAST_PAIR = 8;
    public static final int FEATURE_MULTI_SPLIT = 10;
    public static final int FEATURE_MUSIC_SHARE = 13;
    public static final int FEATURE_NEW_MOBILE = 9;
    public static final int FEATURE_SONG_SWITCH = 22;
    public static final int FEATURE_VOLUME_ADJUST = 21;
    public static final int FEATURE_WEAR_DETECT = 1;
    public static final int LOW_MODE_CLOSE = 2;
    public static final int LOW_MODE_OPEN = 1;
    public static final int WEAR_DETECT_CLOSE = 0;
    public static final int WEAR_DETECT_OPEN = 1;
    private final List<Function> values;

    public DeviceExtraFeatureStatus(byte[] bArr) {
        ArrayList arrayList;
        List pairs$default;
        if (bArr == null || (pairs$default = DataExtKt.toPairs$default(bArr, 0, 0, 0, 7, null)) == null) {
            arrayList = new ArrayList();
        } else {
            List<Pair> list = pairs$default;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Pair pair : list) {
                int iIntValue = ((Number) pair.getFirst()).intValue();
                boolean z = true;
                if (((Number) pair.getSecond()).intValue() != 1) {
                    z = false;
                }
                arrayList2.add(new Function(iIntValue, z));
            }
            arrayList = arrayList2;
        }
        this.values = arrayList;
    }

    public final List<Function> getValues() {
        return this.values;
    }

    public final Boolean getEnable(int type) {
        Object next;
        Iterator<T> it = this.values.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Function) next).getType() != type);
        Function function = (Function) next;
        if (function != null) {
            return Boolean.valueOf(function.getEnable());
        }
        return null;
    }

    public final boolean setEnable(int type, boolean enable) {
        Object next;
        Iterator<T> it = this.values.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (((Function) next).getType() != type);
        Function function = (Function) next;
        if (function == null) {
            return false;
        }
        function.setEnable(enable);
        return true;
    }

    public final byte[] obtainDataPacket(int... type) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<Function> list = this.values;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (ArraysKt.contains(type, ((Function) obj).getType())) {
                arrayList.add(obj);
            }
        }
        ArrayList<Function> arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            return new byte[0];
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((arrayList2.size() * 2) + 1);
        byteBufferAllocate.put((byte) arrayList2.size());
        for (Function function : arrayList2) {
            byteBufferAllocate.put((byte) function.getType()).put(function.getEnable() ? (byte) 1 : (byte) 0);
        }
        byteBufferAllocate.rewind();
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNull(bArrArray);
        return bArrArray;
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((this.values.size() * 2) + 1);
        byteBufferAllocate.put((byte) this.values.size());
        for (Function function : this.values) {
            byteBufferAllocate.put((byte) function.getType()).put(function.getEnable() ? (byte) 1 : (byte) 0);
        }
        byteBufferAllocate.rewind();
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = this.values.iterator();
        while (it.hasNext()) {
            sb.append(((Function) it.next()).toString()).append(", ");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX INFO: compiled from: DeviceExtraFeatureStatus.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/nothing/base/protocol/entity/DeviceExtraFeatureStatus$Function;", "", "type", "", "enable", "", "<init>", "(IZ)V", "getType", "()I", "getEnable", "()Z", "setEnable", "(Z)V", "toString", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Function {
        private boolean enable;
        private final int type;

        public Function(int i, boolean z) {
            this.type = i;
            this.enable = z;
        }

        public final boolean getEnable() {
            return this.enable;
        }

        public final int getType() {
            return this.type;
        }

        public final void setEnable(boolean z) {
            this.enable = z;
        }

        public String toString() {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02X", Arrays.copyOf(new Object[]{Integer.valueOf(this.type)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str + TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER + this.enable;
        }
    }
}
