package com.nothing.link.bluetooth.sdk.connect;

import androidx.health.connect.client.records.metadata.DeviceTypes;
import com.nothing.xservice.XSettingsConstants;
import kotlin.Metadata;

/* JADX INFO: compiled from: XConnectLastState.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/link/bluetooth/sdk/connect/XConnectLastState;", "", "()V", "BOUNDING", "", XSettingsConstants.CONNECTED, "CONNECTING", "CONNECT_FAILURE", "CONNECT_IDLE", "DISCONNECTED", "DISCONNECTING", "getLastStateDesc", "", "state", "nothinglink-bluetoothsdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class XConnectLastState {
    public static final int BOUNDING = 5;
    public static final int CONNECTED = 2;
    public static final int CONNECTING = 1;
    public static final int CONNECT_FAILURE = 4;
    public static final int CONNECT_IDLE = -1;
    public static final int DISCONNECTED = 0;
    public static final int DISCONNECTING = 3;
    public static final XConnectLastState INSTANCE = new XConnectLastState();

    private XConnectLastState() {
    }

    public final String getLastStateDesc(int state) {
        switch (state) {
            case -1:
                return "CONNECT_IDLE";
            case 0:
                return "DISCONNECTED";
            case 1:
                return "CONNECTING";
            case 2:
                return XSettingsConstants.CONNECTED;
            case 3:
                return "DISCONNECTING";
            case 4:
                return "CONNECT_FAILURE";
            case 5:
                return "BOUNDING";
            default:
                return DeviceTypes.UNKNOWN;
        }
    }
}
