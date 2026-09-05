package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /tmp/source/classes3.dex */
public final class AdtsReader implements ElementaryStreamReader {
    private static final int CRC_SIZE = 2;
    private static final int HEADER_SIZE = 5;
    private static final int ID3_HEADER_SIZE = 10;
    private static final byte[] ID3_IDENTIFIER = {73, 68, 51};
    private static final int ID3_SIZE_OFFSET = 6;
    private static final int MATCH_STATE_FF = 512;
    private static final int MATCH_STATE_I = 768;
    private static final int MATCH_STATE_ID = 1024;
    private static final int MATCH_STATE_START = 256;
    private static final int MATCH_STATE_VALUE_SHIFT = 8;
    private static final int STATE_CHECKING_ADTS_HEADER = 1;
    private static final int STATE_FINDING_SAMPLE = 0;
    private static final int STATE_READING_ADTS_HEADER = 3;
    private static final int STATE_READING_ID3_HEADER = 2;
    private static final int STATE_READING_SAMPLE = 4;
    private static final String TAG = "AdtsReader";
    private static final int VERSION_UNSET = -1;
    private final ParsableBitArray adtsScratch;
    private int bytesRead;
    private int currentFrameVersion;
    private TrackOutput currentOutput;
    private long currentSampleDuration;
    private final boolean exposeId3;
    private int firstFrameSampleRateIndex;
    private int firstFrameVersion;
    private String formatId;
    private boolean foundFirstFrame;
    private boolean hasCrc;
    private boolean hasOutputFormat;
    private final ParsableByteArray id3HeaderBuffer;
    private TrackOutput id3Output;
    private final String language;
    private int matchState;
    private TrackOutput output;
    private long sampleDurationUs;
    private int sampleSize;
    private int state;
    private long timeUs;

    public static boolean isAdtsSyncWord(int candidateSyncWord) {
        return (candidateSyncWord & 65526) == 65520;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }

    public AdtsReader(boolean exposeId3) {
        this(exposeId3, null);
    }

    public AdtsReader(boolean exposeId3, String language) {
        this.adtsScratch = new ParsableBitArray(new byte[7]);
        this.id3HeaderBuffer = new ParsableByteArray(Arrays.copyOf(ID3_IDENTIFIER, 10));
        setFindingSampleState();
        this.firstFrameVersion = -1;
        this.firstFrameSampleRateIndex = -1;
        this.sampleDurationUs = -9223372036854775807L;
        this.exposeId3 = exposeId3;
        this.language = language;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        resetSync();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator idGenerator) {
        idGenerator.generateNewId();
        this.formatId = idGenerator.getFormatId();
        TrackOutput trackOutputTrack = extractorOutput.track(idGenerator.getTrackId(), 1);
        this.output = trackOutputTrack;
        this.currentOutput = trackOutputTrack;
        if (this.exposeId3) {
            idGenerator.generateNewId();
            TrackOutput trackOutputTrack2 = extractorOutput.track(idGenerator.getTrackId(), 5);
            this.id3Output = trackOutputTrack2;
            trackOutputTrack2.format(new Format.Builder().setId(idGenerator.getFormatId()).setSampleMimeType("application/id3").build());
            return;
        }
        this.id3Output = new DummyTrackOutput();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long pesTimeUs, int flags) {
        this.timeUs = pesTimeUs;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray data) throws ParserException {
        assertTracksCreated();
        while (data.bytesLeft() > 0) {
            int i = this.state;
            if (i == 0) {
                findNextSample(data);
            } else if (i == 1) {
                checkAdtsHeader(data);
            } else if (i != 2) {
                if (i == 3) {
                    if (continueRead(data, this.adtsScratch.data, this.hasCrc ? 7 : 5)) {
                        parseAdtsHeader();
                    }
                } else if (i == 4) {
                    readSample(data);
                } else {
                    throw new IllegalStateException();
                }
            } else if (continueRead(data, this.id3HeaderBuffer.getData(), 10)) {
                parseId3Header();
            }
        }
    }

    public long getSampleDurationUs() {
        return this.sampleDurationUs;
    }

    private void resetSync() {
        this.foundFirstFrame = false;
        setFindingSampleState();
    }

    private boolean continueRead(ParsableByteArray source, byte[] target, int targetLength) {
        int iMin = Math.min(source.bytesLeft(), targetLength - this.bytesRead);
        source.readBytes(target, this.bytesRead, iMin);
        int i = this.bytesRead + iMin;
        this.bytesRead = i;
        return i == targetLength;
    }

    private void setFindingSampleState() {
        this.state = 0;
        this.bytesRead = 0;
        this.matchState = 256;
    }

    private void setReadingId3HeaderState() {
        this.state = 2;
        this.bytesRead = ID3_IDENTIFIER.length;
        this.sampleSize = 0;
        this.id3HeaderBuffer.setPosition(0);
    }

    private void setReadingSampleState(TrackOutput outputToUse, long currentSampleDuration, int priorReadBytes, int sampleSize) {
        this.state = 4;
        this.bytesRead = priorReadBytes;
        this.currentOutput = outputToUse;
        this.currentSampleDuration = currentSampleDuration;
        this.sampleSize = sampleSize;
    }

    private void setReadingAdtsHeaderState() {
        this.state = 3;
        this.bytesRead = 0;
    }

    private void setCheckingAdtsHeaderState() {
        this.state = 1;
        this.bytesRead = 0;
    }

    private void findNextSample(ParsableByteArray pesBuffer) {
        byte[] data = pesBuffer.getData();
        int position = pesBuffer.getPosition();
        int iLimit = pesBuffer.limit();
        while (position < iLimit) {
            int i = position + 1;
            byte b = data[position];
            int i2 = b & 255;
            if (this.matchState == 512 && isAdtsSyncBytes((byte) -1, (byte) i2) && (this.foundFirstFrame || checkSyncPositionValid(pesBuffer, position - 1))) {
                this.currentFrameVersion = (b & 8) >> 3;
                this.hasCrc = (b & 1) == 0;
                if (!this.foundFirstFrame) {
                    setCheckingAdtsHeaderState();
                } else {
                    setReadingAdtsHeaderState();
                }
                pesBuffer.setPosition(i);
                return;
            }
            int i3 = this.matchState;
            int i4 = i2 | i3;
            if (i4 == 329) {
                this.matchState = 768;
            } else if (i4 == 511) {
                this.matchState = 512;
            } else if (i4 == 836) {
                this.matchState = 1024;
            } else if (i4 == 1075) {
                setReadingId3HeaderState();
                pesBuffer.setPosition(i);
                return;
            } else if (i3 != 256) {
                this.matchState = 256;
            }
            position = i;
        }
        pesBuffer.setPosition(position);
    }

    private void checkAdtsHeader(ParsableByteArray buffer) {
        if (buffer.bytesLeft() == 0) {
            return;
        }
        this.adtsScratch.data[0] = buffer.getData()[buffer.getPosition()];
        this.adtsScratch.setPosition(2);
        int bits = this.adtsScratch.readBits(4);
        int i = this.firstFrameSampleRateIndex;
        if (i != -1 && bits != i) {
            resetSync();
            return;
        }
        if (!this.foundFirstFrame) {
            this.foundFirstFrame = true;
            this.firstFrameVersion = this.currentFrameVersion;
            this.firstFrameSampleRateIndex = bits;
        }
        setReadingAdtsHeaderState();
    }

    private boolean checkSyncPositionValid(ParsableByteArray pesBuffer, int syncPositionCandidate) {
        pesBuffer.setPosition(syncPositionCandidate + 1);
        if (!tryRead(pesBuffer, this.adtsScratch.data, 1)) {
            return false;
        }
        this.adtsScratch.setPosition(4);
        int bits = this.adtsScratch.readBits(1);
        int i = this.firstFrameVersion;
        if (i != -1 && bits != i) {
            return false;
        }
        if (this.firstFrameSampleRateIndex != -1) {
            if (!tryRead(pesBuffer, this.adtsScratch.data, 1)) {
                return true;
            }
            this.adtsScratch.setPosition(2);
            if (this.adtsScratch.readBits(4) != this.firstFrameSampleRateIndex) {
                return false;
            }
            pesBuffer.setPosition(syncPositionCandidate + 2);
        }
        if (!tryRead(pesBuffer, this.adtsScratch.data, 4)) {
            return true;
        }
        this.adtsScratch.setPosition(14);
        int bits2 = this.adtsScratch.readBits(13);
        if (bits2 < 7) {
            return false;
        }
        byte[] data = pesBuffer.getData();
        int iLimit = pesBuffer.limit();
        int i2 = syncPositionCandidate + bits2;
        if (i2 >= iLimit) {
            return true;
        }
        byte b = data[i2];
        if (b == -1) {
            int i3 = i2 + 1;
            if (i3 == iLimit) {
                return true;
            }
            return isAdtsSyncBytes((byte) -1, data[i3]) && ((data[i3] & 8) >> 3) == bits;
        }
        if (b != 73) {
            return false;
        }
        int i4 = i2 + 1;
        if (i4 == iLimit) {
            return true;
        }
        if (data[i4] != 68) {
            return false;
        }
        int i5 = i2 + 2;
        return i5 == iLimit || data[i5] == 51;
    }

    private boolean isAdtsSyncBytes(byte firstByte, byte secondByte) {
        return isAdtsSyncWord(((firstByte & 255) << 8) | (secondByte & 255));
    }

    private boolean tryRead(ParsableByteArray source, byte[] target, int targetLength) {
        if (source.bytesLeft() < targetLength) {
            return false;
        }
        source.readBytes(target, 0, targetLength);
        return true;
    }

    @RequiresNonNull({"id3Output"})
    private void parseId3Header() {
        this.id3Output.sampleData(this.id3HeaderBuffer, 10);
        this.id3HeaderBuffer.setPosition(6);
        setReadingSampleState(this.id3Output, 0L, 10, this.id3HeaderBuffer.readSynchSafeInt() + 10);
    }

    @RequiresNonNull({"output"})
    private void parseAdtsHeader() throws ParserException {
        this.adtsScratch.setPosition(0);
        if (!this.hasOutputFormat) {
            int i = 2;
            int bits = this.adtsScratch.readBits(2) + 1;
            if (bits != 2) {
                Log.w(TAG, new StringBuilder(61).append("Detected audio object type: ").append(bits).append(", but assuming AAC LC.").toString());
            } else {
                i = bits;
            }
            this.adtsScratch.skipBits(5);
            byte[] bArrBuildAudioSpecificConfig = AacUtil.buildAudioSpecificConfig(i, this.firstFrameSampleRateIndex, this.adtsScratch.readBits(3));
            AacUtil.Config audioSpecificConfig = AacUtil.parseAudioSpecificConfig(bArrBuildAudioSpecificConfig);
            Format formatBuild = new Format.Builder().setId(this.formatId).setSampleMimeType("audio/mp4a-latm").setCodecs(audioSpecificConfig.codecs).setChannelCount(audioSpecificConfig.channelCount).setSampleRate(audioSpecificConfig.sampleRateHz).setInitializationData(Collections.singletonList(bArrBuildAudioSpecificConfig)).setLanguage(this.language).build();
            this.sampleDurationUs = 1024000000 / ((long) formatBuild.sampleRate);
            this.output.format(formatBuild);
            this.hasOutputFormat = true;
        } else {
            this.adtsScratch.skipBits(10);
        }
        this.adtsScratch.skipBits(4);
        int bits2 = this.adtsScratch.readBits(13);
        int i2 = bits2 - 7;
        if (this.hasCrc) {
            i2 = bits2 - 9;
        }
        setReadingSampleState(this.output, this.sampleDurationUs, 0, i2);
    }

    @RequiresNonNull({"currentOutput"})
    private void readSample(ParsableByteArray data) {
        int iMin = Math.min(data.bytesLeft(), this.sampleSize - this.bytesRead);
        this.currentOutput.sampleData(data, iMin);
        int i = this.bytesRead + iMin;
        this.bytesRead = i;
        int i2 = this.sampleSize;
        if (i == i2) {
            this.currentOutput.sampleMetadata(this.timeUs, 1, i2, 0, null);
            this.timeUs += this.currentSampleDuration;
            setFindingSampleState();
        }
    }

    @EnsuresNonNull({"output", "currentOutput", "id3Output"})
    private void assertTracksCreated() {
        Assertions.checkNotNull(this.output);
        Util.castNonNull(this.currentOutput);
        Util.castNonNull(this.id3Output);
    }
}
