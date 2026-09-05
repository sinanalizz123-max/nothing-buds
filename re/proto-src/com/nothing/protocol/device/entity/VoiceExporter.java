package com.nothing.protocol.device.entity;

import android.util.Log;
import com.nothing.xservice.transform.key.PendingIntentKey;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;

/* JADX INFO: compiled from: VoiceExporter.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0017J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/nothing/protocol/device/entity/VoiceExporter;", "", "fos", "Ljava/io/FileOutputStream;", "sampleRate", "", "numChannels", "bytesPerSample", "fadeMs", "<init>", "(Ljava/io/FileOutputStream;IIII)V", "channel", "Ljava/nio/channels/FileChannel;", "dataSize", "", "frameSize", "fadeSamples", "fadeBytes", "tailBuf", "", "tailWritePos", "tailFilled", "writeData", "", "buffer", "length", PendingIntentKey.FINISH, "writeEmptyHeader", "writeHeader", "dataBytes", "appendTail", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceExporter {
    private static final String TAG = "VoiceExporter";
    private final int bytesPerSample;
    private final FileChannel channel;
    private long dataSize;
    private final int fadeBytes;
    private final int fadeMs;
    private final int fadeSamples;
    private final FileOutputStream fos;
    private final int frameSize;
    private final int numChannels;
    private final int sampleRate;
    private final byte[] tailBuf;
    private int tailFilled;
    private int tailWritePos;

    public VoiceExporter(FileOutputStream fos, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fos, "fos");
        this.fos = fos;
        this.sampleRate = i;
        this.numChannels = i2;
        this.bytesPerSample = i3;
        this.fadeMs = i4;
        FileChannel channel = fos.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "getChannel(...)");
        this.channel = channel;
        int i5 = i2 * i3;
        this.frameSize = i5;
        int iMax = Math.max(1, (i * Math.max(0, i4)) / 1000);
        this.fadeSamples = iMax;
        int i6 = iMax * i5;
        this.fadeBytes = i6;
        this.tailBuf = i6 > 0 ? new byte[i6] : new byte[0];
        try {
            writeEmptyHeader();
        } catch (Exception e) {
            Log.e(TAG, "init write header error", e);
        }
    }

    public /* synthetic */ VoiceExporter(FileOutputStream fileOutputStream, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileOutputStream, i, (i5 & 4) != 0 ? 1 : i2, (i5 & 8) != 0 ? 2 : i3, (i5 & 16) != 0 ? 50 : i4);
    }

    public final synchronized void writeData(byte[] buffer, int length) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        try {
            this.fos.write(buffer, 0, length);
            this.dataSize += (long) length;
            appendTail(buffer, length);
        } catch (Exception e) {
            Log.e(TAG, "writeData error", e);
        }
    }

    public final synchronized void finish() {
        int i;
        int i2;
        try {
            try {
                this.fos.flush();
                if (this.dataSize > 0 && (i = this.fadeBytes) > 0 && (i2 = this.tailFilled) > 0) {
                    int iMin = Math.min(i2, i);
                    byte[] bArr = new byte[iMin];
                    int i3 = this.tailWritePos - this.tailFilled;
                    int i4 = this.fadeBytes;
                    int i5 = (i3 + i4) % i4;
                    for (int i6 = 0; i6 < iMin; i6++) {
                        bArr[i6] = this.tailBuf[(i5 + i6) % this.fadeBytes];
                    }
                    int i7 = iMin / this.bytesPerSample;
                    for (int i8 = 0; i8 < i7; i8++) {
                        int i9 = this.bytesPerSample * i8;
                        int i10 = i9 + 1;
                        int i11 = (bArr[i9] & 255) | (bArr[i10] << 8);
                        if (i11 >= 32768) {
                            i11 -= 65536;
                        }
                        int iCoerceIn = RangesKt.coerceIn(MathKt.roundToInt(i11 * ((i7 - i8) / i7)), -32768, 32767);
                        if (iCoerceIn < 0) {
                            iCoerceIn += 65536;
                        }
                        bArr[i9] = (byte) (iCoerceIn & 255);
                        bArr[i10] = (byte) ((iCoerceIn >> 8) & 255);
                    }
                    this.channel.position(((long) 44) + (this.dataSize - ((long) iMin)));
                    this.channel.write(ByteBuffer.wrap(bArr));
                    this.fos.getFD().sync();
                }
                writeHeader(this.dataSize);
            } catch (Throwable th) {
                try {
                    this.fos.close();
                } catch (Exception unused) {
                }
                throw th;
            }
        } catch (Exception e) {
            Log.e(TAG, "finish error", e);
        }
        try {
            this.fos.close();
        } catch (Exception unused2) {
        }
    }

    private final void writeEmptyHeader() throws IOException {
        writeHeader(0L);
    }

    private final void writeHeader(long dataBytes) throws IOException {
        int i = this.sampleRate * this.numChannels * this.bytesPerSample;
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(44).order(ByteOrder.LITTLE_ENDIAN);
        byte[] bytes = "RIFF".getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byteBufferOrder.put(bytes);
        byteBufferOrder.putInt((int) (36 + dataBytes));
        byte[] bytes2 = "WAVE".getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        byteBufferOrder.put(bytes2);
        byte[] bytes3 = "fmt ".getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes3, "getBytes(...)");
        byteBufferOrder.put(bytes3);
        byteBufferOrder.putInt(16);
        byteBufferOrder.putShort((short) 1);
        byteBufferOrder.putShort((short) this.numChannels);
        byteBufferOrder.putInt(this.sampleRate);
        byteBufferOrder.putInt(i);
        byteBufferOrder.putShort((short) (this.numChannels * this.bytesPerSample));
        byteBufferOrder.putShort((short) (this.bytesPerSample * 8));
        byte[] bytes4 = "data".getBytes(Charsets.US_ASCII);
        Intrinsics.checkNotNullExpressionValue(bytes4, "getBytes(...)");
        byteBufferOrder.put(bytes4);
        byteBufferOrder.putInt((int) dataBytes);
        byteBufferOrder.flip();
        this.channel.position(0L);
        this.channel.write(byteBufferOrder);
    }

    private final void appendTail(byte[] buffer, int length) {
        int i = this.fadeBytes;
        if (i == 0) {
            return;
        }
        int i2 = 0;
        if (length >= i) {
            System.arraycopy(buffer, length - i, this.tailBuf, 0, i);
            this.tailWritePos = 0;
            this.tailFilled = this.fadeBytes;
            return;
        }
        while (length > 0) {
            int iMin = Math.min(length, this.fadeBytes - this.tailWritePos);
            System.arraycopy(buffer, i2, this.tailBuf, this.tailWritePos, iMin);
            int i3 = this.tailWritePos + iMin;
            int i4 = this.fadeBytes;
            this.tailWritePos = i3 % i4;
            this.tailFilled = Math.min(this.tailFilled + iMin, i4);
            i2 += iMin;
            length -= iMin;
        }
    }
}
