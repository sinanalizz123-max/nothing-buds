package com.nothing.link.bluetooth.sdk.device;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.cardtransform.key.ViewKey;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: XBluetoothDevice.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u0000 T2\u00020\u0001:\u0001TB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004Bs\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010;\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010(J\u0010\u0010B\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u00107J\u000b\u0010C\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0012H\u00c6\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0092\u0001\u0010F\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\bH\u00c6\u0001\u00a2\u0006\u0002\u0010GJ\u000e\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u0000J\b\u0010K\u001a\u00020\fH\u0016J\u0013\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010OH\u0096\u0002J\b\u0010P\u001a\u00020\fH\u0016J\b\u0010Q\u001a\u00020\bH\u0016J\u0018\u0010R\u001a\u00020I2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010S\u001a\u00020\fH\u0016R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010+\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u00a8\u0006U"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "deviceInfo", "Landroid/bluetooth/BluetoothDevice;", "deviceName", "", "deviceAddress", "realAddress", "rssi", "", "timestampNanos", "", "scanRecord", "", ViewKey.TAG, "Landroid/os/Bundle;", "connectUUID", "otaUUID", NotificationCompat.CATEGORY_STATUS, "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;[BLandroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConnectUUID", "()Ljava/lang/String;", "setConnectUUID", "(Ljava/lang/String;)V", "getDeviceAddress", "setDeviceAddress", "getDeviceInfo", "()Landroid/bluetooth/BluetoothDevice;", "setDeviceInfo", "(Landroid/bluetooth/BluetoothDevice;)V", "getDeviceName", "setDeviceName", "getOtaUUID", "setOtaUUID", "getRealAddress", "setRealAddress", "getRssi", "()Ljava/lang/Integer;", "setRssi", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getScanRecord", "()[B", "setScanRecord", "([B)V", "getStatus", "setStatus", "getTag", "()Landroid/os/Bundle;", "setTag", "(Landroid/os/Bundle;)V", "getTimestampNanos", "()Ljava/lang/Long;", "setTimestampNanos", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Landroid/bluetooth/BluetoothDevice;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;[BLandroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "copyDevice", "", "device", "describeContents", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "toString", "writeToParcel", "flags", "CREATOR", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final /* data */ class XBluetoothDevice implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String connectUUID;
    private String deviceAddress;
    private BluetoothDevice deviceInfo;
    private String deviceName;
    private String otaUUID;
    private String realAddress;
    private Integer rssi;
    private byte[] scanRecord;
    private String status;
    private Bundle tag;
    private Long timestampNanos;

    public static /* synthetic */ XBluetoothDevice copy$default(XBluetoothDevice xBluetoothDevice, BluetoothDevice bluetoothDevice, String str, String str2, String str3, Integer num, Long l, byte[] bArr, Bundle bundle, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            bluetoothDevice = xBluetoothDevice.deviceInfo;
        }
        if ((i & 2) != 0) {
            str = xBluetoothDevice.deviceName;
        }
        if ((i & 4) != 0) {
            str2 = xBluetoothDevice.deviceAddress;
        }
        if ((i & 8) != 0) {
            str3 = xBluetoothDevice.realAddress;
        }
        if ((i & 16) != 0) {
            num = xBluetoothDevice.rssi;
        }
        if ((i & 32) != 0) {
            l = xBluetoothDevice.timestampNanos;
        }
        if ((i & 64) != 0) {
            bArr = xBluetoothDevice.scanRecord;
        }
        if ((i & 128) != 0) {
            bundle = xBluetoothDevice.tag;
        }
        if ((i & 256) != 0) {
            str4 = xBluetoothDevice.connectUUID;
        }
        if ((i & 512) != 0) {
            str5 = xBluetoothDevice.otaUUID;
        }
        if ((i & 1024) != 0) {
            str6 = xBluetoothDevice.status;
        }
        String str7 = str5;
        String str8 = str6;
        Bundle bundle2 = bundle;
        String str9 = str4;
        Long l2 = l;
        byte[] bArr2 = bArr;
        Integer num2 = num;
        String str10 = str2;
        return xBluetoothDevice.copy(bluetoothDevice, str, str10, str3, num2, l2, bArr2, bundle2, str9, str7, str8);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final BluetoothDevice getDeviceInfo() {
        return this.deviceInfo;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getOtaUUID() {
        return this.otaUUID;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getRealAddress() {
        return this.realAddress;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getRssi() {
        return this.rssi;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Long getTimestampNanos() {
        return this.timestampNanos;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final byte[] getScanRecord() {
        return this.scanRecord;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Bundle getTag() {
        return this.tag;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getConnectUUID() {
        return this.connectUUID;
    }

    public final XBluetoothDevice copy(BluetoothDevice deviceInfo, String deviceName, String deviceAddress, String realAddress, Integer rssi, Long timestampNanos, byte[] scanRecord, Bundle tag, String connectUUID, String otaUUID, String status) {
        return new XBluetoothDevice(deviceInfo, deviceName, deviceAddress, realAddress, rssi, timestampNanos, scanRecord, tag, connectUUID, otaUUID, status);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public XBluetoothDevice(BluetoothDevice bluetoothDevice, String str, String str2, String str3, Integer num, Long l, byte[] bArr, Bundle bundle, String str4, String str5, String str6) {
        this.deviceInfo = bluetoothDevice;
        this.deviceName = str;
        this.deviceAddress = str2;
        this.realAddress = str3;
        this.rssi = num;
        this.timestampNanos = l;
        this.scanRecord = bArr;
        this.tag = bundle;
        this.connectUUID = str4;
        this.otaUUID = str5;
        this.status = str6;
    }

    public final BluetoothDevice getDeviceInfo() {
        return this.deviceInfo;
    }

    public final void setDeviceInfo(BluetoothDevice bluetoothDevice) {
        this.deviceInfo = bluetoothDevice;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
    }

    public final String getDeviceAddress() {
        return this.deviceAddress;
    }

    public final void setDeviceAddress(String str) {
        this.deviceAddress = str;
    }

    public final String getRealAddress() {
        return this.realAddress;
    }

    public final void setRealAddress(String str) {
        this.realAddress = str;
    }

    public final Integer getRssi() {
        return this.rssi;
    }

    public final void setRssi(Integer num) {
        this.rssi = num;
    }

    public final Long getTimestampNanos() {
        return this.timestampNanos;
    }

    public final void setTimestampNanos(Long l) {
        this.timestampNanos = l;
    }

    public final byte[] getScanRecord() {
        return this.scanRecord;
    }

    public final void setScanRecord(byte[] bArr) {
        this.scanRecord = bArr;
    }

    public final Bundle getTag() {
        return this.tag;
    }

    public final void setTag(Bundle bundle) {
        this.tag = bundle;
    }

    public final String getConnectUUID() {
        return this.connectUUID;
    }

    public final void setConnectUUID(String str) {
        this.connectUUID = str;
    }

    public final String getOtaUUID() {
        return this.otaUUID;
    }

    public final void setOtaUUID(String str) {
        this.otaUUID = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final void copyDevice(XBluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.deviceInfo = device.deviceInfo;
        this.deviceName = device.deviceName;
        this.deviceAddress = device.deviceAddress;
        this.rssi = device.rssi;
        this.timestampNanos = device.timestampNanos;
        this.scanRecord = device.scanRecord;
        this.tag = device.tag;
        this.connectUUID = device.connectUUID;
        this.otaUUID = device.otaUUID;
        this.status = device.status;
    }

    public String toString() {
        return "realAddress:" + this.realAddress + ",deviceInfo:" + this.deviceInfo + ",deviceName:" + this.deviceName + ",rssi:" + this.rssi + ",tag:" + this.tag;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public XBluetoothDevice(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) parcel.readParcelable(BluetoothDevice.class.getClassLoader());
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        Object value = parcel.readValue(Integer.TYPE.getClassLoader());
        Integer num = value instanceof Integer ? (Integer) value : null;
        Object value2 = parcel.readValue(Long.TYPE.getClassLoader());
        this(bluetoothDevice, string, string2, string3, num, value2 instanceof Long ? (Long) value2 : null, parcel.createByteArray(), parcel.readBundle(Bundle.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeParcelable(this.deviceInfo, flags);
        parcel.writeString(this.deviceName);
        parcel.writeString(this.deviceAddress);
        parcel.writeString(this.realAddress);
        parcel.writeValue(this.rssi);
        parcel.writeValue(this.timestampNanos);
        parcel.writeByteArray(this.scanRecord);
        parcel.writeBundle(this.tag);
        parcel.writeString(this.connectUUID);
        parcel.writeString(this.otaUUID);
        parcel.writeString(this.status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.nothing.link.bluetooth.sdk.device.XBluetoothDevice");
        XBluetoothDevice xBluetoothDevice = (XBluetoothDevice) other;
        return Intrinsics.areEqual(this.deviceName, xBluetoothDevice.deviceName) && Intrinsics.areEqual(this.deviceAddress, xBluetoothDevice.deviceAddress) && Intrinsics.areEqual(this.realAddress, xBluetoothDevice.realAddress);
    }

    public int hashCode() {
        String str = this.deviceName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.deviceAddress;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.realAddress;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    /* JADX INFO: renamed from: com.nothing.link.bluetooth.sdk.device.XBluetoothDevice$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: XBluetoothDevice.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/nothing/link/bluetooth/sdk/device/XBluetoothDevice;", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<XBluetoothDevice> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XBluetoothDevice createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new XBluetoothDevice(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public XBluetoothDevice[] newArray(int size) {
            return new XBluetoothDevice[size];
        }
    }
}
