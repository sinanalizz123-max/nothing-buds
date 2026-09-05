package com.nothing.database.entity;

import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeviceItem.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0006H\u00c6\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0006H\u00c6\u0003J\t\u00107\u001a\u00020\u0006H\u00c6\u0003J\t\u00108\u001a\u00020\u0006H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\u0006H\u00c6\u0003J\t\u0010;\u001a\u00020\u0010H\u00c6\u0003J\u0089\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u0010=\u001a\u00020\u00062\b\u0010>\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010?\u001a\u00020@H\u00d6\u0001J\t\u0010A\u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\f\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0014\"\u0004\b)\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/\u00a8\u0006B"}, d2 = {"Lcom/nothing/database/entity/DeviceItem;", "", "name", "", "address", "connected", "", "deviceVersion", "modelId", "sn", "tipsShow", "guideShow", "homeTips", "otaTips", "smartDialTips", "otaTipsTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;ZJ)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getAddress", "getConnected", "()Z", "setConnected", "(Z)V", "getDeviceVersion", "setDeviceVersion", "getModelId", "setModelId", "getSn", "setSn", "getTipsShow", "setTipsShow", "getGuideShow", "setGuideShow", "getHomeTips", "setHomeTips", "getOtaTips", "setOtaTips", "getSmartDialTips", "setSmartDialTips", "getOtaTipsTime", "()J", "setOtaTipsTime", "(J)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class DeviceItem {
    private final String address;
    private boolean connected;
    private String deviceVersion;
    private boolean guideShow;
    private boolean homeTips;
    private String modelId;
    private String name;
    private String otaTips;
    private long otaTipsTime;
    private boolean smartDialTips;
    private String sn;
    private boolean tipsShow;

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final String getOtaTips() {
        return this.otaTips;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final boolean getSmartDialTips() {
        return this.smartDialTips;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final long getOtaTipsTime() {
        return this.otaTipsTime;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getConnected() {
        return this.connected;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getDeviceVersion() {
        return this.deviceVersion;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getModelId() {
        return this.modelId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getSn() {
        return this.sn;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getTipsShow() {
        return this.tipsShow;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getGuideShow() {
        return this.guideShow;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final boolean getHomeTips() {
        return this.homeTips;
    }

    public final DeviceItem copy(String name, String address, boolean connected, String deviceVersion, String modelId, String sn, boolean tipsShow, boolean guideShow, boolean homeTips, String otaTips, boolean smartDialTips, long otaTipsTime) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        return new DeviceItem(name, address, connected, deviceVersion, modelId, sn, tipsShow, guideShow, homeTips, otaTips, smartDialTips, otaTipsTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceItem)) {
            return false;
        }
        DeviceItem deviceItem = (DeviceItem) other;
        return Intrinsics.areEqual(this.name, deviceItem.name) && Intrinsics.areEqual(this.address, deviceItem.address) && this.connected == deviceItem.connected && Intrinsics.areEqual(this.deviceVersion, deviceItem.deviceVersion) && Intrinsics.areEqual(this.modelId, deviceItem.modelId) && Intrinsics.areEqual(this.sn, deviceItem.sn) && this.tipsShow == deviceItem.tipsShow && this.guideShow == deviceItem.guideShow && this.homeTips == deviceItem.homeTips && Intrinsics.areEqual(this.otaTips, deviceItem.otaTips) && this.smartDialTips == deviceItem.smartDialTips && this.otaTipsTime == deviceItem.otaTipsTime;
    }

    public int hashCode() {
        int iHashCode = ((((this.name.hashCode() * 31) + this.address.hashCode()) * 31) + Boolean.hashCode(this.connected)) * 31;
        String str = this.deviceVersion;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.modelId;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sn;
        int iHashCode4 = (((((((iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.tipsShow)) * 31) + Boolean.hashCode(this.guideShow)) * 31) + Boolean.hashCode(this.homeTips)) * 31;
        String str4 = this.otaTips;
        return ((((iHashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + Boolean.hashCode(this.smartDialTips)) * 31) + Long.hashCode(this.otaTipsTime);
    }

    public String toString() {
        return "DeviceItem(name=" + this.name + ", address=" + this.address + ", connected=" + this.connected + ", deviceVersion=" + this.deviceVersion + ", modelId=" + this.modelId + ", sn=" + this.sn + ", tipsShow=" + this.tipsShow + ", guideShow=" + this.guideShow + ", homeTips=" + this.homeTips + ", otaTips=" + this.otaTips + ", smartDialTips=" + this.smartDialTips + ", otaTipsTime=" + this.otaTipsTime + ")";
    }

    public DeviceItem(String name, String address, boolean z, String str, String str2, String str3, boolean z2, boolean z3, boolean z4, String str4, boolean z5, long j) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(address, "address");
        this.name = name;
        this.address = address;
        this.connected = z;
        this.deviceVersion = str;
        this.modelId = str2;
        this.sn = str3;
        this.tipsShow = z2;
        this.guideShow = z3;
        this.homeTips = z4;
        this.otaTips = str4;
        this.smartDialTips = z5;
        this.otaTipsTime = j;
    }

    public /* synthetic */ DeviceItem(String str, String str2, boolean z, String str3, String str4, String str5, boolean z2, boolean z3, boolean z4, String str6, boolean z5, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) != 0 ? "" : str5, (i & 64) != 0 ? false : z2, (i & 128) != 0 ? false : z3, (i & 256) != 0 ? false : z4, (i & 512) != 0 ? "" : str6, (i & 1024) != 0 ? false : z5, (i & 2048) != 0 ? 0L : j);
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getAddress() {
        return this.address;
    }

    public final boolean getConnected() {
        return this.connected;
    }

    public final void setConnected(boolean z) {
        this.connected = z;
    }

    public final String getDeviceVersion() {
        return this.deviceVersion;
    }

    public final void setDeviceVersion(String str) {
        this.deviceVersion = str;
    }

    public final String getModelId() {
        return this.modelId;
    }

    public final void setModelId(String str) {
        this.modelId = str;
    }

    public final String getSn() {
        return this.sn;
    }

    public final void setSn(String str) {
        this.sn = str;
    }

    public final boolean getTipsShow() {
        return this.tipsShow;
    }

    public final void setTipsShow(boolean z) {
        this.tipsShow = z;
    }

    public final boolean getGuideShow() {
        return this.guideShow;
    }

    public final void setGuideShow(boolean z) {
        this.guideShow = z;
    }

    public final boolean getHomeTips() {
        return this.homeTips;
    }

    public final void setHomeTips(boolean z) {
        this.homeTips = z;
    }

    public final String getOtaTips() {
        return this.otaTips;
    }

    public final void setOtaTips(String str) {
        this.otaTips = str;
    }

    public final boolean getSmartDialTips() {
        return this.smartDialTips;
    }

    public final void setSmartDialTips(boolean z) {
        this.smartDialTips = z;
    }

    public final long getOtaTipsTime() {
        return this.otaTipsTime;
    }

    public final void setOtaTipsTime(long j) {
        this.otaTipsTime = j;
    }
}
