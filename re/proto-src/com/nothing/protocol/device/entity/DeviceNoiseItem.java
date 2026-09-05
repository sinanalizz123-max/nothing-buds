package com.nothing.protocol.device.entity;

import kotlin.Metadata;

/* JADX INFO: compiled from: DeviceNoiseItem.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/nothing/protocol/device/entity/DeviceNoiseItem;", "", "type", "", "value", "none", "<init>", "(III)V", "getType", "()I", "getValue", "setValue", "(I)V", "getNone", "toString", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceNoiseItem {
    private final int none;
    private final int type;
    private int value;

    public DeviceNoiseItem(int i, int i2, int i3) {
        this.type = i;
        this.value = i2;
        this.none = i3;
    }

    public final int getNone() {
        return this.none;
    }

    public final int getType() {
        return this.type;
    }

    public final int getValue() {
        return this.value;
    }

    public final void setValue(int i) {
        this.value = i;
    }

    public String toString() {
        return "type:" + this.type + ",value:" + this.value + ",none:" + this.none;
    }
}
