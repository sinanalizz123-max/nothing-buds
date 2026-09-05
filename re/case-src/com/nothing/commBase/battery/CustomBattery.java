package com.nothing.commBase.battery;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CustomBattery.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B\u00a7\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u00a2\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u000eH\u00c6\u0003J\t\u0010,\u001a\u00020\u0010H\u00c6\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u00c6\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u00c6\u0003J\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u00c6\u0003J\u0011\u00100\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0007H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0007H\u00c6\u0003J\t\u00107\u001a\u00020\u0007H\u00c6\u0003J\t\u00108\u001a\u00020\u0007H\u00c6\u0003J\u00bf\u0001\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00122\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012H\u00c6\u0001J\u0013\u0010:\u001a\u00020\u000e2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010<\u001a\u00020\u0007H\u00d6\u0001J\t\u0010=\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0019\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0019\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010$R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0019\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001bR\u0019\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001e\u00a8\u0006>"}, d2 = {"Lcom/nothing/commBase/battery/CustomBattery;", "", "address", "", "deviceType", "deviceName", "mainBattery", "", "batteryStatus", "caseBatteryStatus", "caseBattery", "leftBattery", "rightBattery", "isActive", "", "connectedTime", "", "leftImage", "", "rightImage", "caseImage", "globalImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIZJLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAddress", "()Ljava/lang/String;", "getBatteryStatus", "getCaseBattery", "()I", "getCaseBatteryStatus", "getCaseImage", "()Ljava/util/List;", "getConnectedTime", "()J", "getDeviceName", "getDeviceType", "getGlobalImage", "()Z", "getLeftBattery", "getLeftImage", "getMainBattery", "getRightBattery", "getRightImage", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "CommBaseLib_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class CustomBattery {
    private final String address;
    private final String batteryStatus;
    private final int caseBattery;
    private final String caseBatteryStatus;
    private final List<Integer> caseImage;
    private final long connectedTime;
    private final String deviceName;
    private final String deviceType;
    private final List<Integer> globalImage;
    private final boolean isActive;
    private final int leftBattery;
    private final List<Integer> leftImage;
    private final int mainBattery;
    private final int rightBattery;
    private final List<Integer> rightImage;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CustomBattery copy$default(CustomBattery customBattery, String str, String str2, String str3, int i, String str4, String str5, int i2, int i3, int i4, boolean z, long j, List list, List list2, List list3, List list4, int i5, Object obj) {
        String str6 = (i5 & 1) != 0 ? customBattery.address : str;
        return customBattery.copy(str6, (i5 & 2) != 0 ? customBattery.deviceType : str2, (i5 & 4) != 0 ? customBattery.deviceName : str3, (i5 & 8) != 0 ? customBattery.mainBattery : i, (i5 & 16) != 0 ? customBattery.batteryStatus : str4, (i5 & 32) != 0 ? customBattery.caseBatteryStatus : str5, (i5 & 64) != 0 ? customBattery.caseBattery : i2, (i5 & 128) != 0 ? customBattery.leftBattery : i3, (i5 & 256) != 0 ? customBattery.rightBattery : i4, (i5 & 512) != 0 ? customBattery.isActive : z, (i5 & 1024) != 0 ? customBattery.connectedTime : j, (i5 & 2048) != 0 ? customBattery.leftImage : list, (i5 & 4096) != 0 ? customBattery.rightImage : list2, (i5 & 8192) != 0 ? customBattery.caseImage : list3, (i5 & 16384) != 0 ? customBattery.globalImage : list4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getIsActive() {
        return this.isActive;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final long getConnectedTime() {
        return this.connectedTime;
    }

    public final List<Integer> component12() {
        return this.leftImage;
    }

    public final List<Integer> component13() {
        return this.rightImage;
    }

    public final List<Integer> component14() {
        return this.caseImage;
    }

    public final List<Integer> component15() {
        return this.globalImage;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getMainBattery() {
        return this.mainBattery;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getBatteryStatus() {
        return this.batteryStatus;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getCaseBatteryStatus() {
        return this.caseBatteryStatus;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final int getCaseBattery() {
        return this.caseBattery;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final int getLeftBattery() {
        return this.leftBattery;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getRightBattery() {
        return this.rightBattery;
    }

    public final CustomBattery copy(String address, String deviceType, String deviceName, int mainBattery, String batteryStatus, String caseBatteryStatus, int caseBattery, int leftBattery, int rightBattery, boolean isActive, long connectedTime, List<Integer> leftImage, List<Integer> rightImage, List<Integer> caseImage, List<Integer> globalImage) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(batteryStatus, "batteryStatus");
        Intrinsics.checkNotNullParameter(caseBatteryStatus, "caseBatteryStatus");
        return new CustomBattery(address, deviceType, deviceName, mainBattery, batteryStatus, caseBatteryStatus, caseBattery, leftBattery, rightBattery, isActive, connectedTime, leftImage, rightImage, caseImage, globalImage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CustomBattery)) {
            return false;
        }
        CustomBattery customBattery = (CustomBattery) other;
        return Intrinsics.areEqual(this.address, customBattery.address) && Intrinsics.areEqual(this.deviceType, customBattery.deviceType) && Intrinsics.areEqual(this.deviceName, customBattery.deviceName) && this.mainBattery == customBattery.mainBattery && Intrinsics.areEqual(this.batteryStatus, customBattery.batteryStatus) && Intrinsics.areEqual(this.caseBatteryStatus, customBattery.caseBatteryStatus) && this.caseBattery == customBattery.caseBattery && this.leftBattery == customBattery.leftBattery && this.rightBattery == customBattery.rightBattery && this.isActive == customBattery.isActive && this.connectedTime == customBattery.connectedTime && Intrinsics.areEqual(this.leftImage, customBattery.leftImage) && Intrinsics.areEqual(this.rightImage, customBattery.rightImage) && Intrinsics.areEqual(this.caseImage, customBattery.caseImage) && Intrinsics.areEqual(this.globalImage, customBattery.globalImage);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17, types: [int] */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    public int hashCode() {
        int iHashCode = ((((((((((((((((this.address.hashCode() * 31) + this.deviceType.hashCode()) * 31) + this.deviceName.hashCode()) * 31) + Integer.hashCode(this.mainBattery)) * 31) + this.batteryStatus.hashCode()) * 31) + this.caseBatteryStatus.hashCode()) * 31) + Integer.hashCode(this.caseBattery)) * 31) + Integer.hashCode(this.leftBattery)) * 31) + Integer.hashCode(this.rightBattery)) * 31;
        boolean z = this.isActive;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int iHashCode2 = (((iHashCode + r1) * 31) + Long.hashCode(this.connectedTime)) * 31;
        List<Integer> list = this.leftImage;
        int iHashCode3 = (iHashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<Integer> list2 = this.rightImage;
        int iHashCode4 = (iHashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<Integer> list3 = this.caseImage;
        int iHashCode5 = (iHashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<Integer> list4 = this.globalImage;
        return iHashCode5 + (list4 != null ? list4.hashCode() : 0);
    }

    public String toString() {
        return "CustomBattery(address=" + this.address + ", deviceType=" + this.deviceType + ", deviceName=" + this.deviceName + ", mainBattery=" + this.mainBattery + ", batteryStatus=" + this.batteryStatus + ", caseBatteryStatus=" + this.caseBatteryStatus + ", caseBattery=" + this.caseBattery + ", leftBattery=" + this.leftBattery + ", rightBattery=" + this.rightBattery + ", isActive=" + this.isActive + ", connectedTime=" + this.connectedTime + ", leftImage=" + this.leftImage + ", rightImage=" + this.rightImage + ", caseImage=" + this.caseImage + ", globalImage=" + this.globalImage + ")";
    }

    public CustomBattery(String address, String deviceType, String deviceName, int i, String batteryStatus, String caseBatteryStatus, int i2, int i3, int i4, boolean z, long j, List<Integer> list, List<Integer> list2, List<Integer> list3, List<Integer> list4) {
        Intrinsics.checkNotNullParameter(address, "address");
        Intrinsics.checkNotNullParameter(deviceType, "deviceType");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        Intrinsics.checkNotNullParameter(batteryStatus, "batteryStatus");
        Intrinsics.checkNotNullParameter(caseBatteryStatus, "caseBatteryStatus");
        this.address = address;
        this.deviceType = deviceType;
        this.deviceName = deviceName;
        this.mainBattery = i;
        this.batteryStatus = batteryStatus;
        this.caseBatteryStatus = caseBatteryStatus;
        this.caseBattery = i2;
        this.leftBattery = i3;
        this.rightBattery = i4;
        this.isActive = z;
        this.connectedTime = j;
        this.leftImage = list;
        this.rightImage = list2;
        this.caseImage = list3;
        this.globalImage = list4;
    }

    public /* synthetic */ CustomBattery(String str, String str2, String str3, int i, String str4, String str5, int i2, int i3, int i4, boolean z, long j, List list, List list2, List list3, List list4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i, str4, str5, i2, i3, i4, z, (i5 & 1024) != 0 ? 0L : j, (i5 & 2048) != 0 ? null : list, (i5 & 4096) != 0 ? null : list2, (i5 & 8192) != 0 ? null : list3, (i5 & 16384) != 0 ? null : list4);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final int getMainBattery() {
        return this.mainBattery;
    }

    public final String getBatteryStatus() {
        return this.batteryStatus;
    }

    public final String getCaseBatteryStatus() {
        return this.caseBatteryStatus;
    }

    public final int getCaseBattery() {
        return this.caseBattery;
    }

    public final int getLeftBattery() {
        return this.leftBattery;
    }

    public final int getRightBattery() {
        return this.rightBattery;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final long getConnectedTime() {
        return this.connectedTime;
    }

    public final List<Integer> getLeftImage() {
        return this.leftImage;
    }

    public final List<Integer> getRightImage() {
        return this.rightImage;
    }

    public final List<Integer> getCaseImage() {
        return this.caseImage;
    }

    public final List<Integer> getGlobalImage() {
        return this.globalImage;
    }
}
