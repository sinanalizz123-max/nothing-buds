package com.nothing.earbase.control.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.log.FileLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: ControlConfigurationEntity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005B!\b\u0016\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u00a2\u0006\u0004\b\u0004\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\u0004\u0010\fJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\n\u00a8\u0006\u001d"}, d2 = {"Lcom/nothing/earbase/control/entity/ControlConfigurationEntity;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "payload", "", "<init>", "([B)V", "operations", "Ljava/util/ArrayList;", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "operation", "(Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;)V", "getPayload", "()[B", "getOperations", "()Ljava/util/ArrayList;", "setOperations", "hashCode", "", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "obtainDataPacket", "toString", "", "Operation", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ControlConfigurationEntity implements ITWSParse {
    public static final int BUTTON_ANC = 4;
    public static final int BUTTON_FUNCTION = 1;
    public static final int BUTTON_SWIPE_DOWN = 6;
    public static final int BUTTON_SWIPE_UP = 5;
    public static final int BUTTON_VOLUME_DOWN = 3;
    public static final int BUTTON_VOLUME_UP = 2;
    public static final int GESTURE_CASE_LOCK = 15;
    public static final int GESTURE_DOUBLE_PRESS = 2;
    public static final int GESTURE_DOUBLE_PRESS_INNER = 13;
    public static final int GESTURE_DOUBLE_TAP = 2;
    public static final int GESTURE_FLASH_SWIPE = 6;
    public static final int GESTURE_LONG_PRESS = 7;
    public static final int GESTURE_LONG_PRESS_1_HALF_5 = 7;
    public static final int GESTURE_LONG_PRESS_INNER = 14;
    public static final int GESTURE_OVERLONG_PRESS = 8;
    public static final int GESTURE_PRESS = 1;
    public static final int GESTURE_PRESS_FIVE = 12;
    public static final int GESTURE_ROTATE = 10;
    public static final int GESTURE_SHOW1_SWIPE = 10;
    public static final int GESTURE_SHOW_SWIPE = 9;
    public static final int GESTURE_SIX_TAP = 4;
    public static final int GESTURE_SLIDE_ON_SYSTEM = 0;
    public static final int GESTURE_SWIPE = 5;
    public static final int GESTURE_TAP = 1;
    public static final int GESTURE_THREE_TAP = 3;
    public static final int GESTURE_THREE_TAP_AND_LONG_PRESS = 9;
    public static final int GESTURE_TRIPLE_PRESS = 3;
    private static final int INDEX_BUTTON = 1;
    private static final int INDEX_DEVICE = 0;
    private static final int INDEX_GESTURE = 2;
    private static final int INDEX_OPERATION = 3;
    public static final int NEW_GESTURE_ROLL = 17;
    public static final int NEW_OPERATION_PRESS = 48;
    public static final int NEW_PADDLE_CLICK = 18;
    public static final int NEW_PADDLE_HOLD = 19;
    public static final int NEW_PADDLE_OPERATION_CLICK = 49;
    public static final int NEW_PADDLE_OPERATION_HOLD = 50;
    public static final int NEW_RADIO_SETTING = 51;
    public static final int OPERATION_ALEXA = 14;
    public static final int OPERATION_ANC_CTRL = 10;
    public static final int OPERATION_ANC_OFF = 20;
    public static final int OPERATION_ANC_TRANS = 22;
    public static final int OPERATION_ANSWER_DECLINE_CALL = 26;
    public static final int OPERATION_BASS_ENHANCEMENT = 28;
    public static final int OPERATION_BISTO = 13;
    public static final int OPERATION_CALL_OR_HUNG_UP = 3;
    public static final int OPERATION_CASE_LOCK = 40;
    public static final int OPERATION_CLOSE = 1;
    public static final int OPERATION_COMFORTABLE_MODE = 16;
    public static final int OPERATION_EQ_PRESET = 34;
    public static final int OPERATION_ESSENTIAL_SPACE = 33;
    public static final int OPERATION_FAVORITE_MUSIC = 15;
    public static final int OPERATION_GAME_MODE = 17;
    public static final int OPERATION_GVA = 12;
    public static final int OPERATION_HOLD_THIRD_PARTY_CALL = 5;
    public static final int OPERATION_KEEP_VOLUME_DOWN = 19;
    public static final int OPERATION_KEEP_VOLUME_UP = 18;
    public static final int OPERATION_MIC = 29;
    public static final int OPERATION_MIC_MUTE = 25;
    public static final int OPERATION_NEWS_WIDGET = 31;
    public static final int OPERATION_NEXT = 9;
    public static final int OPERATION_NOTHING_RADIO = 32;
    public static final int OPERATION_PAIR_MODE = 24;
    public static final int OPERATION_PLAY_OR_PAUSE = 2;
    public static final int OPERATION_PREVIOUS = 8;
    public static final int OPERATION_REJECT = 4;
    public static final int OPERATION_ROTATE_CONTROL = 23;
    public static final int OPERATION_SPATIAL_AUDIO = 27;
    public static final int OPERATION_SWITCH_BLUETOOTH = 39;
    public static final int OPERATION_TRANS_OFF = 21;
    public static final int OPERATION_VOICE_ASSISTANT = 11;
    public static final int OPERATION_VOLUME_DOWN = 7;
    public static final int OPERATION_VOLUME_DOWN_OR_UP = 255;
    public static final int OPERATION_VOLUME_UP = 6;
    private ArrayList<Operation> operations;
    private final byte[] payload;

    public ControlConfigurationEntity(byte[] bArr) {
        List<int[]> multiValues;
        this.payload = bArr;
        this.operations = new ArrayList<>();
        if (bArr == null || (multiValues = DataExtKt.toMultiValues(bArr, 1, 1, 1, 1, 1)) == null) {
            return;
        }
        for (int[] iArr : multiValues) {
            this.operations.add(new Operation(iArr[0], iArr[1], iArr[2], iArr[3]));
        }
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final ArrayList<Operation> getOperations() {
        return this.operations;
    }

    public final void setOperations(ArrayList<Operation> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.operations = arrayList;
    }

    public int hashCode() {
        return Arrays.hashCode(this.payload);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ControlConfigurationEntity)) {
            return false;
        }
        byte[] bArr = this.payload;
        String strContentToHexString = bArr != null ? DataExtKt.contentToHexString(bArr) : null;
        byte[] bArr2 = ((ControlConfigurationEntity) other).payload;
        boolean zAreEqual = Intrinsics.areEqual(strContentToHexString, bArr2 != null ? DataExtKt.contentToHexString(bArr2) : null);
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ControlConfigurationEntity contentEquals " + zAreEqual + StringUtils.SPACE + this.payload + ".con";
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
        return zAreEqual;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ControlConfigurationEntity(ArrayList<Operation> operations) {
        this((byte[]) null);
        Intrinsics.checkNotNullParameter(operations, "operations");
        this.operations.clear();
        this.operations = operations;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ControlConfigurationEntity(Operation operation) {
        this((byte[]) null);
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.operations.clear();
        this.operations = CollectionsKt.arrayListOf(operation);
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        int size = this.operations.size();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((size * 4) + 1);
        byteBufferAllocate.put((byte) size);
        for (Operation operation : this.operations) {
            byteBufferAllocate.put((byte) operation.getDevice()).put((byte) operation.getButton()).put((byte) operation.getGesture()).put((byte) operation.getOperation());
        }
        byteBufferAllocate.rewind();
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public String toString() {
        return "ControlConfigurationEntity(operation=" + CollectionsKt.joinToString$default(this.operations, null, null, null, 0, null, null, 63, null) + ")";
    }

    /* JADX INFO: compiled from: ControlConfigurationEntity.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 #2\u00020\u0001:\u0001#B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u0007\u0010\u000bJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u00d6\u0003J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u0012\u00a8\u0006$"}, d2 = {"Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "Landroid/os/Parcelable;", "device", "", "button", "gesture", "operation", "<init>", "(IIII)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getDevice", "()I", "getButton", "getGesture", "getOperation", "setOperation", "(I)V", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "", "CREATOR", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final /* data */ class Operation implements Parcelable {

        /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int button;
        private final int device;
        private final int gesture;
        private int operation;

        public static /* synthetic */ Operation copy$default(Operation operation, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = operation.device;
            }
            if ((i5 & 2) != 0) {
                i2 = operation.button;
            }
            if ((i5 & 4) != 0) {
                i3 = operation.gesture;
            }
            if ((i5 & 8) != 0) {
                i4 = operation.operation;
            }
            return operation.copy(i, i2, i3, i4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getDevice() {
            return this.device;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getButton() {
            return this.button;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getGesture() {
            return this.gesture;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final int getOperation() {
            return this.operation;
        }

        public final Operation copy(int device, int button, int gesture, int operation) {
            return new Operation(device, button, gesture, operation);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Operation)) {
                return false;
            }
            Operation operation = (Operation) other;
            return this.device == operation.device && this.button == operation.button && this.gesture == operation.gesture && this.operation == operation.operation;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.device) * 31) + Integer.hashCode(this.button)) * 31) + Integer.hashCode(this.gesture)) * 31) + Integer.hashCode(this.operation);
        }

        public String toString() {
            return "Operation(device=" + this.device + ", button=" + this.button + ", gesture=" + this.gesture + ", operation=" + this.operation + ")";
        }

        public Operation(int i, int i2, int i3, int i4) {
            this.device = i;
            this.button = i2;
            this.gesture = i3;
            this.operation = i4;
        }

        public final int getDevice() {
            return this.device;
        }

        public final int getButton() {
            return this.button;
        }

        public final int getGesture() {
            return this.gesture;
        }

        public final int getOperation() {
            return this.operation;
        }

        public final void setOperation(int i) {
            this.operation = i;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Operation(Parcel parcel) {
            this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            Intrinsics.checkNotNullParameter(parcel, "parcel");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.device);
            parcel.writeInt(this.button);
            parcel.writeInt(this.gesture);
            parcel.writeInt(this.operation);
        }

        /* JADX INFO: renamed from: com.nothing.earbase.control.entity.ControlConfigurationEntity$Operation$CREATOR, reason: from kotlin metadata */
        /* JADX INFO: compiled from: ControlConfigurationEntity.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/nothing/earbase/control/entity/ControlConfigurationEntity$Operation;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion implements Parcelable.Creator<Operation> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Operation createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Operation(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Operation[] newArray(int size) {
                return new Operation[size];
            }
        }
    }
}
