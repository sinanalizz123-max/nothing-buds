package com.nothing.base.protocol.entity;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.nothing.base.util.ext.DataExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: compiled from: DeviceSupportFeature.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 22\u00020\u0001:\u00012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u00100\u001a\u000201H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0016\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\rR\u0011\u0010\u0018\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\rR\u0011\u0010\u001c\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0011\u0010 \u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\rR\u0011\u0010\"\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010\rR\u0011\u0010$\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b%\u0010\rR\u0011\u0010&\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b'\u0010\rR\u0011\u0010(\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b)\u0010\rR\u0011\u0010*\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\rR\u0011\u0010,\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b-\u0010\rR\u0011\u0010.\u001a\u00020\u000b8F\u00a2\u0006\u0006\u001a\u0004\b/\u0010\r\u00a8\u00063"}, d2 = {"Lcom/nothing/base/protocol/entity/DeviceSupportFeature;", "", "payload", "", "<init>", "([B)V", "features", "", "getFeatures", "()I", "wearDetect", "", "getWearDetect", "()Z", "gameMode", "getGameMode", CmcdData.OBJECT_TYPE_MUXED_AUDIO_AND_VIDEO, "getAv", "gav", "getGav", "bisto", "getBisto", "alexa", "getAlexa", "googleFastPair", "getGoogleFastPair", "inhouseFastPair", "getInhouseFastPair", "newMobile", "getNewMobile", "multiSplit", "getMultiSplit", "autoAnswer", "getAutoAnswer", "autoReconnect", "getAutoReconnect", "musicShare", "getMusicShare", "denoiseAnc", "getDenoiseAnc", "comfortableMode", "getComfortableMode", "denoiseEnc", "getDenoiseEnc", "volumeAdjust", "getVolumeAdjust", "songSwitch", "getSongSwitch", "toString", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeviceSupportFeature {
    public static final int FEATURE_ALEXA = 32;
    public static final int FEATURE_AUTO_ANSWER = 1024;
    public static final int FEATURE_AUTO_RECONNECT = 2048;
    public static final int FEATURE_AV = 4;
    public static final int FEATURE_BISTO = 16;
    public static final int FEATURE_COMFORTABLE_MODE = 32768;
    public static final int FEATURE_DENOISE_ANC = 8192;
    public static final int FEATURE_DENOISE_ENC = 131072;
    public static final int FEATURE_GAME_MODE = 2;
    public static final int FEATURE_GAV = 8;
    public static final int FEATURE_GOOGLE_FAST_PAIR = 64;
    public static final int FEATURE_INHOUSE_FAST_PAIR = 128;
    public static final int FEATURE_MULTI_SPLIT = 512;
    public static final int FEATURE_MUSIC_SHARE = 4096;
    public static final int FEATURE_NEW_MOBILE = 256;
    public static final int FEATURE_SONG_SWITCH = 2097152;
    public static final int FEATURE_VOLUME_ADJUST = 1048576;
    public static final int FEATURE_WEAR_DETECT = 1;
    private final int features;

    public DeviceSupportFeature(byte[] payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        this.features = DataExtKt.toInt$default(payload, 0, 0, 3, null);
    }

    public final int getFeatures() {
        return this.features;
    }

    public final boolean getWearDetect() {
        return DataExtKt.mask(this.features, 1);
    }

    public final boolean getGameMode() {
        return DataExtKt.mask(this.features, 2);
    }

    public final boolean getAv() {
        return DataExtKt.mask(this.features, 4);
    }

    public final boolean getGav() {
        return DataExtKt.mask(this.features, 8);
    }

    public final boolean getBisto() {
        return DataExtKt.mask(this.features, 16);
    }

    public final boolean getAlexa() {
        return DataExtKt.mask(this.features, 32);
    }

    public final boolean getGoogleFastPair() {
        return DataExtKt.mask(this.features, 64);
    }

    public final boolean getInhouseFastPair() {
        return DataExtKt.mask(this.features, 128);
    }

    public final boolean getNewMobile() {
        return DataExtKt.mask(this.features, 256);
    }

    public final boolean getMultiSplit() {
        return DataExtKt.mask(this.features, 512);
    }

    public final boolean getAutoAnswer() {
        return DataExtKt.mask(this.features, 1024);
    }

    public final boolean getAutoReconnect() {
        return DataExtKt.mask(this.features, 2048);
    }

    public final boolean getMusicShare() {
        return DataExtKt.mask(this.features, 4096);
    }

    public final boolean getDenoiseAnc() {
        return DataExtKt.mask(this.features, 8192);
    }

    public final boolean getComfortableMode() {
        return DataExtKt.mask(this.features, 32768);
    }

    public final boolean getDenoiseEnc() {
        return DataExtKt.mask(this.features, 131072);
    }

    public final boolean getVolumeAdjust() {
        return DataExtKt.mask(this.features, 1048576);
    }

    public final boolean getSongSwitch() {
        return DataExtKt.mask(this.features, 2097152);
    }

    public String toString() {
        String string = Integer.toString(this.features, CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }
}
