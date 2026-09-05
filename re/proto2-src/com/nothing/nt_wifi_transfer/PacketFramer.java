package com.nothing.nt_wifi_transfer;

import android.util.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NtWifiTransferPlugin.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0005J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082D\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/nothing/nt_wifi_transfer/PacketFramer;", "", "onPacket", "Lkotlin/Function1;", "", "", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "cache", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "crcFallbackWaitMs", "", "crcFallbackStartAtMs", "Ljava/lang/Long;", "append", "bytes", "clear", "parseLoop", "u16", "", "start", "nt_wifi_transfer_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PacketFramer {
    private final ArrayList<Byte> cache;
    private Long crcFallbackStartAtMs;
    private final long crcFallbackWaitMs;
    private final Function1<byte[], Unit> onPacket;

    /* JADX WARN: Multi-variable type inference failed */
    public PacketFramer(Function1<? super byte[], Unit> onPacket) {
        Intrinsics.checkNotNullParameter(onPacket, "onPacket");
        this.onPacket = onPacket;
        this.cache = new ArrayList<>();
        this.crcFallbackWaitMs = 80L;
    }

    public final synchronized void clear() {
        this.cache.clear();
        this.crcFallbackStartAtMs = null;
    }

    private final void parseLoop() {
        long jLongValue;
        while (true) {
            int i = 0;
            while (!this.cache.isEmpty() && (this.cache.get(0).byteValue() & 255) != 85) {
                this.cache.remove(0);
                i++;
            }
            if (i > 0) {
                Log.i("NtWifiTransferPlugin", "[Recording][WiFiTCP] parser drop non-sof bytes=" + i + " remain=" + this.cache.size());
            }
            if (this.cache.size() < 8) {
                return;
            }
            byte[] bArrByteListRangeToByteArray = NtWifiTransferPluginKt.byteListRangeToByteArray(this.cache, 0, 8);
            int iU16 = u16(bArrByteListRangeToByteArray, 1);
            int iU17 = u16(bArrByteListRangeToByteArray, 5);
            boolean z = (iU16 & 32) != 0;
            int i2 = iU17 + 8;
            int i3 = (z ? 2 : 0) + i2;
            if (this.cache.size() < i3) {
                if (z && this.cache.size() >= i2) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    Long l = this.crcFallbackStartAtMs;
                    if (l != null) {
                        jLongValue = l.longValue();
                    } else {
                        this.crcFallbackStartAtMs = Long.valueOf(jCurrentTimeMillis);
                        jLongValue = jCurrentTimeMillis;
                    }
                    long j = jCurrentTimeMillis - jLongValue;
                    if (j >= this.crcFallbackWaitMs) {
                        byte[] bArrByteListRangeToByteArray2 = NtWifiTransferPluginKt.byteListRangeToByteArray(this.cache, 0, i2);
                        for (int i4 = 0; i4 < i2; i4++) {
                            this.cache.remove(0);
                        }
                        this.crcFallbackStartAtMs = null;
                        Log.i("NtWifiTransferPlugin", "[Recording][WiFiTCP] parser fallback no-crc after wait=" + j + "ms while crc-bit=1 len=" + i2 + " hex=" + NtWifiTransferPluginKt.toHexPreview(bArrByteListRangeToByteArray2, 64));
                        this.onPacket.invoke(bArrByteListRangeToByteArray2);
                    }
                }
                Log.i("NtWifiTransferPlugin", "[Recording][WiFiTCP] parser wait more bytes have=" + this.cache.size() + " need=" + i3 + " lenField=" + iU17 + " hasCrc=" + z);
                return;
            }
            this.crcFallbackStartAtMs = null;
            byte[] bArrByteListRangeToByteArray3 = NtWifiTransferPluginKt.byteListRangeToByteArray(this.cache, 0, i3);
            for (int i5 = 0; i5 < i3; i5++) {
                this.cache.remove(0);
            }
            if (z) {
                int i6 = i3 - 2;
                byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArrByteListRangeToByteArray3, 0, i6);
                int iU18 = u16(bArrByteListRangeToByteArray3, i6);
                int iObtainCrc16 = PacketCodec.INSTANCE.obtainCrc16(bArrCopyOfRange);
                if (iU18 != iObtainCrc16) {
                    Log.i("NtWifiTransferPlugin", "[Recording][WiFiTCP] parser crc mismatch crc=" + iU18 + " calc=" + iObtainCrc16 + " total=" + i3);
                }
            }
            this.onPacket.invoke(bArrByteListRangeToByteArray3);
        }
    }

    private final int u16(byte[] bytes, int start) {
        return ((bytes[start + 1] & 255) << 8) | (bytes[start] & 255);
    }

    public final synchronized void append(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        for (byte b : bytes) {
            this.cache.add(Byte.valueOf(b));
        }
        parseLoop();
    }
}
