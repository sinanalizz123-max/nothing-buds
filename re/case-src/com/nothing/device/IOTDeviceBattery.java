package com.nothing.device;

import kotlin.Metadata;

/* JADX INFO: compiled from: IOTDeviceBattery.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/nothing/device/IOTDeviceBattery;", "", "<init>", "()V", "leftBattery", "", "getLeftBattery", "()I", "rightBattery", "getRightBattery", "caseBattery", "getCaseBattery", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOTDeviceBattery {
    private final int caseBattery;
    private final int leftBattery;
    private final int rightBattery;

    public final int getLeftBattery() {
        return this.leftBattery;
    }

    public final int getRightBattery() {
        return this.rightBattery;
    }

    public final int getCaseBattery() {
        return this.caseBattery;
    }
}
