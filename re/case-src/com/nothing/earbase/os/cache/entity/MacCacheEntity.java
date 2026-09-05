package com.nothing.earbase.os.cache.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MacCacheEntity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u0000 C2\u00020\u0001:\u0001CBm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0004\b\u000f\u0010\u0010B\u0011\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0004\b\u000f\u0010\u0013J\b\u0010-\u001a\u00020\u0003H\u0016J\u0006\u0010.\u001a\u00020/J\u0018\u00100\u001a\u0002012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0006H\u0016J\b\u00103\u001a\u00020\u0006H\u0016J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0006H\u00c6\u0003J\t\u00107\u001a\u00020\u0006H\u00c6\u0003J\t\u00108\u001a\u00020\u0006H\u00c6\u0003J\t\u00109\u001a\u00020\u0006H\u00c6\u0003J\t\u0010:\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0006H\u00c6\u0003J\t\u0010=\u001a\u00020\u000eH\u00c6\u0003Jq\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000eH\u00c6\u0001J\u0013\u0010?\u001a\u00020/2\b\u0010@\u001a\u0004\u0018\u00010AH\u00d6\u0003J\t\u0010B\u001a\u00020\u0006H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0015\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0018R\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001a\"\u0004\b(\u0010\u001cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006D"}, d2 = {"Lcom/nothing/earbase/os/cache/entity/MacCacheEntity;", "Landroid/os/Parcelable;", "address", "", "modelId", "modelInt", "", "deviceType", "leftBattery", "rightBattery", "caseBattery", "firmwareVersion", "autoUpdate", "timestap", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIIIILjava/lang/String;IJ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAddress", "()Ljava/lang/String;", "getModelId", "setModelId", "(Ljava/lang/String;)V", "getModelInt", "()I", "setModelInt", "(I)V", "getDeviceType", "setDeviceType", "getLeftBattery", "setLeftBattery", "getRightBattery", "setRightBattery", "getCaseBattery", "setCaseBattery", "getFirmwareVersion", "setFirmwareVersion", "getAutoUpdate", "setAutoUpdate", "getTimestap", "()J", "setTimestap", "(J)V", "toString", "isUndefine", "", "writeToParcel", "", "flags", "describeContents", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "CREATOR", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class MacCacheEntity implements Parcelable {

    /* JADX INFO: renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String address;
    private int autoUpdate;
    private int caseBattery;
    private int deviceType;
    private String firmwareVersion;
    private int leftBattery;
    private String modelId;
    private int modelInt;
    private int rightBattery;
    private long timestap;

    public static /* synthetic */ MacCacheEntity copy$default(MacCacheEntity macCacheEntity, String str, String str2, int i, int i2, int i3, int i4, int i5, String str3, int i6, long j, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = macCacheEntity.address;
        }
        if ((i7 & 2) != 0) {
            str2 = macCacheEntity.modelId;
        }
        if ((i7 & 4) != 0) {
            i = macCacheEntity.modelInt;
        }
        if ((i7 & 8) != 0) {
            i2 = macCacheEntity.deviceType;
        }
        if ((i7 & 16) != 0) {
            i3 = macCacheEntity.leftBattery;
        }
        if ((i7 & 32) != 0) {
            i4 = macCacheEntity.rightBattery;
        }
        if ((i7 & 64) != 0) {
            i5 = macCacheEntity.caseBattery;
        }
        if ((i7 & 128) != 0) {
            str3 = macCacheEntity.firmwareVersion;
        }
        if ((i7 & 256) != 0) {
            i6 = macCacheEntity.autoUpdate;
        }
        if ((i7 & 512) != 0) {
            j = macCacheEntity.timestap;
        }
        long j2 = j;
        String str4 = str3;
        int i8 = i6;
        int i9 = i4;
        int i10 = i5;
        int i11 = i3;
        int i12 = i;
        return macCacheEntity.copy(str, str2, i12, i2, i11, i9, i10, str4, i8, j2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final long getTimestap() {
        return this.timestap;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getModelInt() {
        return this.modelInt;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getLeftBattery() {
        return this.leftBattery;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final int getRightBattery() {
        return this.rightBattery;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCaseBattery() {
        return this.caseBattery;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getAutoUpdate() {
        return this.autoUpdate;
    }

    public final MacCacheEntity copy(String address, String modelId, int modelInt, int deviceType, int leftBattery, int rightBattery, int caseBattery, String firmwareVersion, int autoUpdate, long timestap) {
        Intrinsics.checkNotNullParameter(address, "address");
        return new MacCacheEntity(address, modelId, modelInt, deviceType, leftBattery, rightBattery, caseBattery, firmwareVersion, autoUpdate, timestap);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MacCacheEntity)) {
            return false;
        }
        MacCacheEntity macCacheEntity = (MacCacheEntity) other;
        return Intrinsics.areEqual(this.address, macCacheEntity.address) && Intrinsics.areEqual(this.modelId, macCacheEntity.modelId) && this.modelInt == macCacheEntity.modelInt && this.deviceType == macCacheEntity.deviceType && this.leftBattery == macCacheEntity.leftBattery && this.rightBattery == macCacheEntity.rightBattery && this.caseBattery == macCacheEntity.caseBattery && Intrinsics.areEqual(this.firmwareVersion, macCacheEntity.firmwareVersion) && this.autoUpdate == macCacheEntity.autoUpdate && this.timestap == macCacheEntity.timestap;
    }

    public int hashCode() {
        int iHashCode = this.address.hashCode() * 31;
        String str = this.modelId;
        int iHashCode2 = (((((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.modelInt)) * 31) + Integer.hashCode(this.deviceType)) * 31) + Integer.hashCode(this.leftBattery)) * 31) + Integer.hashCode(this.rightBattery)) * 31) + Integer.hashCode(this.caseBattery)) * 31;
        String str2 = this.firmwareVersion;
        return ((((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.autoUpdate)) * 31) + Long.hashCode(this.timestap);
    }

    public MacCacheEntity(String address, String str, int i, int i2, int i3, int i4, int i5, String str2, int i6, long j) {
        Intrinsics.checkNotNullParameter(address, "address");
        this.address = address;
        this.modelId = str;
        this.modelInt = i;
        this.deviceType = i2;
        this.leftBattery = i3;
        this.rightBattery = i4;
        this.caseBattery = i5;
        this.firmwareVersion = str2;
        this.autoUpdate = i6;
        this.timestap = j;
    }

    public /* synthetic */ MacCacheEntity(String str, String str2, int i, int i2, int i3, int i4, int i5, String str3, int i6, long j, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i7 & 2) != 0 ? "" : str2, (i7 & 4) != 0 ? 0 : i, (i7 & 8) != 0 ? 0 : i2, (i7 & 16) != 0 ? 0 : i3, (i7 & 32) != 0 ? 0 : i4, (i7 & 64) != 0 ? 0 : i5, (i7 & 128) != 0 ? "" : str3, (i7 & 256) != 0 ? 0 : i6, (i7 & 512) != 0 ? System.currentTimeMillis() : j);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final void setModelId(String str) {
        this.modelId = str;
    }

    public final int getModelInt() {
        return this.modelInt;
    }

    public final void setModelInt(int i) {
        this.modelInt = i;
    }

    public final int getDeviceType() {
        return this.deviceType;
    }

    public final void setDeviceType(int i) {
        this.deviceType = i;
    }

    public final int getLeftBattery() {
        return this.leftBattery;
    }

    public final void setLeftBattery(int i) {
        this.leftBattery = i;
    }

    public final int getRightBattery() {
        return this.rightBattery;
    }

    public final void setRightBattery(int i) {
        this.rightBattery = i;
    }

    public final int getCaseBattery() {
        return this.caseBattery;
    }

    public final void setCaseBattery(int i) {
        this.caseBattery = i;
    }

    public final String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public final void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public final int getAutoUpdate() {
        return this.autoUpdate;
    }

    public final void setAutoUpdate(int i) {
        this.autoUpdate = i;
    }

    public final long getTimestap() {
        return this.timestap;
    }

    public final void setTimestap(long j) {
        this.timestap = j;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MacCacheEntity(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        String string = parcel.readString();
        this(string == null ? "" : string, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), 0L, 512, null);
    }

    public String toString() {
        return "MacEntity:address=" + this.address + ",modelId:" + this.modelId + ",modelInt:" + this.modelInt + ",deviceType:" + this.deviceType + ",leftBattery:" + this.leftBattery + ",rightBattery:" + this.rightBattery + ",caseBattery:" + this.caseBattery + ",firmwareVersion:" + this.firmwareVersion + ",autoUpdate:" + this.autoUpdate;
    }

    public final boolean isUndefine() {
        return this.modelInt != 0 && this.deviceType == 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.address);
        parcel.writeString(this.modelId);
        parcel.writeInt(this.modelInt);
        parcel.writeInt(this.deviceType);
        parcel.writeInt(this.leftBattery);
        parcel.writeInt(this.rightBattery);
        parcel.writeInt(this.caseBattery);
        parcel.writeString(this.firmwareVersion);
        parcel.writeInt(this.autoUpdate);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.os.cache.entity.MacCacheEntity$CREATOR, reason: from kotlin metadata */
    /* JADX INFO: compiled from: MacCacheEntity.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/nothing/earbase/os/cache/entity/MacCacheEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/nothing/earbase/os/cache/entity/MacCacheEntity;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/nothing/earbase/os/cache/entity/MacCacheEntity;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion implements Parcelable.Creator<MacCacheEntity> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MacCacheEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new MacCacheEntity(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MacCacheEntity[] newArray(int size) {
            return new MacCacheEntity[size];
        }
    }
}
