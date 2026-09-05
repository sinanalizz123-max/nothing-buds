package com.nothing.protocol.utils;

import kotlin.Metadata;

/* JADX INFO: compiled from: ErrorCode.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/protocol/utils/ErrorCode;", "", "<init>", "()V", "SPP_UNKNOWN", "", "SPP_UNABLE_TO_CONNECT", "SPP_RECEIVE_MESSAGE_FAIL", "SPP_SEND_MESSAGE_FAIL", "SPP_DISCONNECTED", "HEADSET_SPP_UNKNOWN", "HEADSET_SPP_GET_PROTOCOL_VERSION_NULL", "HEADSET_SPP_SET_PROTOCOL_ACTIVATED_NULL", "HEADSET_RSP_ERROR", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ErrorCode {
    public static final int HEADSET_RSP_ERROR = 768;
    public static final int HEADSET_SPP_GET_PROTOCOL_VERSION_NULL = 513;
    public static final int HEADSET_SPP_SET_PROTOCOL_ACTIVATED_NULL = 514;
    private static final int HEADSET_SPP_UNKNOWN = 512;
    public static final ErrorCode INSTANCE = new ErrorCode();
    public static final int SPP_DISCONNECTED = 260;
    public static final int SPP_RECEIVE_MESSAGE_FAIL = 258;
    public static final int SPP_SEND_MESSAGE_FAIL = 259;
    public static final int SPP_UNABLE_TO_CONNECT = 257;
    private static final int SPP_UNKNOWN = 256;

    private ErrorCode() {
    }
}
