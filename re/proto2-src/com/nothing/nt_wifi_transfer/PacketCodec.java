package com.nothing.nt_wifi_transfer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NtWifiTransferPlugin.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003JB\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0005\u00a8\u0006\u0011"}, d2 = {"Lcom/nothing/nt_wifi_transfer/PacketCodec;", "", "<init>", "()V", "assemblePacket", "", "command", "", "payload", "fsn", "crc", "", "multiFrames", "deviceType", "rspCode", "obtainCrc16", "data", "nt_wifi_transfer_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PacketCodec {
    public static final PacketCodec INSTANCE = new PacketCodec();

    private PacketCodec() {
    }

    public static /* synthetic */ byte[] assemblePacket$default(PacketCodec packetCodec, int i, byte[] bArr, int i2, boolean z, boolean z2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 32) != 0) {
            i3 = 1;
        }
        return packetCodec.assemblePacket(i, bArr, i2, z, z2, i3, (i5 & 64) != 0 ? 0 : i4);
    }

    public final byte[] assemblePacket(int command, byte[] payload, int fsn, boolean crc, boolean multiFrames, int deviceType, int rspCode) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        int i = rspCode & 31;
        if (crc) {
            i |= 32;
        }
        if (multiFrames) {
            i |= 64;
        }
        int i2 = ((deviceType << 8) & 3840) | i;
        int length = payload.length & 65535;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(payload.length + 8).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.put((byte) 85);
        byteBufferOrder.putShort((short) i2);
        byteBufferOrder.putShort((short) (command & 65535));
        byteBufferOrder.putShort((short) length);
        byteBufferOrder.put((byte) (fsn & 255));
        byteBufferOrder.put(payload);
        byte[] bArrArray = byteBufferOrder.array();
        if (!crc) {
            Intrinsics.checkNotNull(bArrArray);
            return bArrArray;
        }
        Intrinsics.checkNotNull(bArrArray);
        int iObtainCrc16 = obtainCrc16(bArrArray);
        ByteBuffer byteBufferOrder2 = ByteBuffer.allocate(bArrArray.length + 2).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder2.put(bArrArray);
        byteBufferOrder2.putShort((short) iObtainCrc16);
        byte[] bArrArray2 = byteBufferOrder2.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray2, "array(...)");
        return bArrArray2;
    }

    public final int obtainCrc16(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        int i = 65535;
        for (byte b : data) {
            i = (i & 65535) ^ (b & 255);
            for (int i2 = 0; i2 < 8; i2++) {
                i = (i & 1) > 0 ? (i >> 1) ^ 40961 : i >> 1;
            }
        }
        return i & 65535;
    }
}
