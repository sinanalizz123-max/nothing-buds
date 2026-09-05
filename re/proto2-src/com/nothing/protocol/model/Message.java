package com.nothing.protocol.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.nothing.base.model.BaseMessage;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.Utils;
import com.nothing.base.util.ext.DataExtKt;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Message.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u0000 K2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001KB\u0011\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0006\u0010\u0007BC\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0006\u0010\u0010J\u000e\u00104\u001a\u0002052\u0006\u0010\u0014\u001a\u00020\tJ&\u00106\u001a\u0002052\u0006\u0010(\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ\u000e\u00107\u001a\u0002052\u0006\u0010\n\u001a\u00020\tJ\u0010\u00108\u001a\u0002052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005J\u000e\u00109\u001a\u0002052\u0006\u0010\r\u001a\u00020\tJ\u000e\u0010:\u001a\u0002052\u0006\u0010;\u001a\u00020\fJ\u0006\u0010<\u001a\u00020\tJ\u0006\u0010=\u001a\u00020\fJ%\u0010>\u001a\u0004\u0018\u0001H?\"\b\b\u0000\u0010?*\u00020#2\f\u0010@\u001a\b\u0012\u0004\u0012\u0002H?0A\u00a2\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020\u0005H\u0016J\b\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\tH\u0016J\u0018\u0010G\u001a\u0002052\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\tH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u001e\u0010\r\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u001e\u0010 \u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0011\u0010(\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b*\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u001eR\u0011\u0010\b\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b,\u0010\u0016R\u0011\u0010-\u001a\u00020\f8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010\u001eR\u0011\u0010.\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\u0016R\u0011\u00100\u001a\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b1\u0010\u0016R\u001e\u00102\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0016\u00a8\u0006L"}, d2 = {"Lcom/nothing/protocol/model/Message;", "Lcom/nothing/base/model/BaseMessage;", "Landroid/os/Parcelable;", "Lcom/nothing/base/protocol/constant/ITWSParse;", "byteArray", "", "<init>", "([B)V", "deviceType", "", "command", "multiFrames", "", "fsn", "payload", "crc", "(IIZI[BZ)V", "getByteArray", "()[B", "value", "sof", "getSof", "()I", "control", "getControl", "getCommand", "length", "getLength", "getFsn", "isNeedFsn", "()Z", "getPayload", "checkSum", "getCheckSum", "data", "", "getData", "()Ljava/lang/Object;", "setData", "(Ljava/lang/Object;)V", "rspCode", "getRspCode", "getCrc", "getMultiFrames", "getDeviceType", "isOk", "requestCmd", "getRequestCmd", "responseCmd", "getResponseCmd", "packetLength", "getPacketLength", "setSof", "", "setControl", "setCommand", "setPayload", "setFsn", "setIsNeedFsn", "need", "obtainCrc16", "checkPacket", "obtainPayload", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "obtainDataPacket", "toString", "", "describeContents", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class Message extends BaseMessage implements Parcelable, ITWSParse {
    private static final int CONTROL_CRC = 32;
    public static final int CONTROL_DEVICE_TYPE_TWS_HEADSET = 1;
    public static final int CONTROL_DEVICE_TYPE_WATCH = 2;
    private static final int CONTROL_MULTI_FRAMES = 64;
    public static final int DEFAULT_RSP_CODE = 0;
    public static final int DEFAULT_SOF = 85;
    private static final int MASK_BYTE = 255;
    private static final int MASK_CRC = 32;
    private static final int MASK_DEVICE_TYPE = 3840;
    private static final int MASK_MULTI_FRAMES = 64;
    private static final int MASK_REQUEST_CMD = 32768;
    private static final int MASK_RESPONSE_CMD = 32767;
    private static final int MASK_RSP_CODE = 31;
    private static final int MASK_SHORT = 65535;
    public static final int PAYLOAD_ENDPOINT_TYPE_SPEAKER = 7;
    private final byte[] byteArray;
    private int checkSum;
    private int command;
    private int control;
    private Object data;
    private int fsn;
    private boolean isNeedFsn;
    private int length;
    private int packetLength;
    private byte[] payload;
    private int sof;
    public static final Parcelable.Creator<Message> CREATOR = new Creator();

    /* JADX INFO: compiled from: Message.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Message> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Message createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Message(parcel.createByteArray());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Message[] newArray(int i) {
            return new Message[i];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeByteArray(this.byteArray);
    }

    public Message(byte[] bArr) {
        this.byteArray = bArr;
        this.sof = 85;
        this.isNeedFsn = true;
        if (bArr != null) {
            this.sof = DataExtKt.toInt(bArr, 0, 1);
            this.control = DataExtKt.toInt(bArr, 1, 2);
            this.command = DataExtKt.toInt(bArr, 3, 2);
            this.length = DataExtKt.toInt(bArr, 5, 2);
            this.fsn = DataExtKt.toInt(bArr, 7, 1);
            int i = this.length;
            if (i > 0 && i + 8 <= bArr.length) {
                this.payload = ArraysKt.copyOfRange(bArr, 8, i + 8);
            }
            this.packetLength = this.length + 8;
            if (getCrc()) {
                this.checkSum = DataExtKt.toInt(bArr, this.length + 8, 2);
                this.packetLength += 2;
            }
        }
    }

    public final byte[] getByteArray() {
        return this.byteArray;
    }

    public final int getSof() {
        return this.sof;
    }

    public final int getControl() {
        return this.control;
    }

    public final int getCommand() {
        return this.command;
    }

    public final int getLength() {
        return this.length;
    }

    public final int getFsn() {
        return this.fsn;
    }

    /* JADX INFO: renamed from: isNeedFsn, reason: from getter */
    public final boolean getIsNeedFsn() {
        return this.isNeedFsn;
    }

    public final byte[] getPayload() {
        return this.payload;
    }

    public final int getCheckSum() {
        return this.checkSum;
    }

    public final Object getData() {
        return this.data;
    }

    public final void setData(Object obj) {
        this.data = obj;
    }

    public final int getRspCode() {
        return this.control & 31;
    }

    public final boolean getCrc() {
        return (this.control & 32) != 0;
    }

    public final boolean getMultiFrames() {
        return (this.control & 64) != 0;
    }

    public final int getDeviceType() {
        return (this.control & MASK_DEVICE_TYPE) >> 8;
    }

    public final boolean isOk() {
        return getRspCode() == 0;
    }

    public final int getRequestCmd() {
        return this.command | 32768;
    }

    public final int getResponseCmd() {
        return this.command & 32767;
    }

    public final int getPacketLength() {
        return this.packetLength;
    }

    public /* synthetic */ Message(int i, int i2, boolean z, int i3, byte[] bArr, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i4 & 4) != 0 ? false : z, (i4 & 8) != 0 ? 0 : i3, (i4 & 16) != 0 ? null : bArr, (i4 & 32) != 0 ? true : z2);
    }

    public Message(int i, int i2, boolean z, int i3, byte[] bArr, boolean z2) {
        this(null);
        setControl(0, z2, z, i);
        setCommand(i2);
        setFsn(i3);
        setPayload(bArr);
    }

    public final void setSof(int sof) {
        this.sof = sof & 255;
    }

    public final void setControl(int rspCode, boolean crc, boolean multiFrames, int deviceType) {
        int i = rspCode & 31;
        this.control = i;
        if (crc) {
            this.control = i + 32;
        }
        if (multiFrames) {
            this.control += 64;
        }
        this.control += (deviceType << 8) & MASK_DEVICE_TYPE;
    }

    public final void setCommand(int command) {
        this.command = command & 65535;
    }

    public final void setPayload(byte[] payload) {
        byte[] bArrCopyOf;
        int length = (payload != null ? payload.length : 0) & 65535;
        this.length = length;
        if (payload != null) {
            bArrCopyOf = Arrays.copyOf(payload, length);
            Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        } else {
            bArrCopyOf = null;
        }
        this.payload = bArrCopyOf;
    }

    public final void setFsn(int fsn) {
        this.fsn = fsn & 255;
    }

    public final void setIsNeedFsn(boolean need) {
        this.isNeedFsn = need;
    }

    public final int obtainCrc16() {
        if (!getCrc()) {
            return 0;
        }
        byte b = (byte) this.sof;
        byte b2 = (byte) this.fsn;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.length + 8);
        byteBufferAllocate.put(b).put(DataExtKt.toByteArray$default(this.control, 0, 1, (Object) null)).put(DataExtKt.toByteArray$default(this.command, 0, 1, (Object) null)).put(DataExtKt.toByteArray$default(this.length, 0, 1, (Object) null)).put(b2);
        byte[] bArr = this.payload;
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                Intrinsics.checkNotNull(bArr);
                byteBufferAllocate.put(bArr);
            }
        }
        byteBufferAllocate.rewind();
        Utils utils = Utils.INSTANCE;
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return utils.obtainCrc16(bArrArray);
    }

    public final boolean checkPacket() {
        return obtainCrc16() == this.checkSum;
    }

    public final <T> T obtainPayload(Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        byte[] bArr = this.payload;
        if (bArr == null) {
            return null;
        }
        if (Intrinsics.areEqual(clazz, Integer.TYPE)) {
            return (T) Integer.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null));
        }
        if (Intrinsics.areEqual(clazz, Long.TYPE)) {
            return (T) Long.valueOf(DataExtKt.toLong$default(bArr, 0, 0, 3, null));
        }
        if (Intrinsics.areEqual(clazz, String.class)) {
            CharSequence charSequenceDecodeToString = StringsKt.decodeToString(bArr);
            Intrinsics.checkNotNull(charSequenceDecodeToString, "null cannot be cast to non-null type T of com.nothing.protocol.model.Message.obtainPayload");
            return (T) charSequenceDecodeToString;
        }
        if (Intrinsics.areEqual(clazz, Boolean.TYPE)) {
            return (T) Boolean.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null) == 1);
        }
        if (Intrinsics.areEqual(clazz, Float.TYPE)) {
            return (T) Float.valueOf(DataExtKt.toFloat$default(bArr, 0, 0, 0, 7, null));
        }
        try {
            return clazz.getConstructor(byte[].class).newInstance(bArr);
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    @Override // com.nothing.base.protocol.constant.ITWSParse
    public byte[] obtainDataPacket() {
        byte[] bArr = this.byteArray;
        if (bArr != null) {
            if (!(bArr.length == 0)) {
                return bArr;
            }
        }
        int i = this.length + 8 + (getCrc() ? 2 : 0);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i);
        byteBufferAllocate.put((byte) this.sof).put(DataExtKt.toByteArray$default(this.control, 0, 1, (Object) null)).put(DataExtKt.toByteArray$default(this.command, 0, 1, (Object) null)).put(DataExtKt.toByteArray$default(this.length, 0, 1, (Object) null)).put((byte) this.fsn);
        byte[] bArr2 = this.payload;
        if (bArr2 != null) {
            if (!(bArr2.length == 0)) {
                Intrinsics.checkNotNull(bArr2);
                byteBufferAllocate.put(bArr2);
            }
        }
        if (getCrc()) {
            byteBufferAllocate.rewind();
            byte[] bArr3 = new byte[i - 2];
            byteBufferAllocate.get(bArr3);
            byteBufferAllocate.put(DataExtKt.toByteArray$default(Utils.INSTANCE.obtainCrc16(bArr3), 0, 1, (Object) null));
        }
        byteBufferAllocate.rewind();
        byte[] bArrArray = byteBufferAllocate.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public String toString() {
        byte[] bArr = this.byteArray;
        String strContentToHexString = bArr != null ? DataExtKt.contentToHexString(bArr) : null;
        String hexString = DataExtKt.toHexString(this.sof);
        String hexString2 = DataExtKt.toHexString(this.control);
        String hexString3 = DataExtKt.toHexString(this.command);
        String hexString4 = DataExtKt.toHexString(this.length);
        String hexString5 = DataExtKt.toHexString(this.fsn);
        byte[] bArr2 = this.payload;
        return "Message(byteArray=" + strContentToHexString + ", sof=" + hexString + ", control=" + hexString2 + ", command=" + hexString3 + ", length=" + hexString4 + ", fsn=" + hexString5 + ", payload=" + (bArr2 != null ? DataExtKt.contentToHexString(bArr2) : null) + ", checksum=" + DataExtKt.toHexString(this.checkSum) + ", deviceType=" + DataExtKt.toHexString(getDeviceType()) + ", rspCode=" + DataExtKt.toHexString(getRspCode()) + ", crc=" + getCrc() + ", multiFrames=" + getMultiFrames() + ")";
    }
}
