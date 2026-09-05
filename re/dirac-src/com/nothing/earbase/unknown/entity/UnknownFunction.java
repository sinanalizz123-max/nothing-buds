package com.nothing.earbase.unknown.entity;

import android.util.Log;
import androidx.health.connect.client.records.Vo2MaxRecord;
import com.nothing.base.util.Logger;
import com.nothing.log.FileLog;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: UnknownConfigs.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u00eb\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0006\u00101\u001a\u000202J\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u000202J\u0006\u00105\u001a\u000202J\u0006\u00106\u001a\u000202J\u0006\u00107\u001a\u000202J\u0006\u00108\u001a\u000202J\u0006\u00109\u001a\u000202J\u0006\u0010:\u001a\u000202J\u0006\u0010;\u001a\u000202J\f\u0010<\u001a\b\u0012\u0004\u0012\u00020>0=J\f\u0010?\u001a\b\u0012\u0004\u0012\u00020@0=J\u0006\u0010A\u001a\u000202J\u0006\u0010B\u001a\u000202J\r\u0010C\u001a\u0004\u0018\u000102\u00a2\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010I\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u000b\u0010J\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010M\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010N\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010O\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010P\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010R\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010S\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010T\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010U\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010V\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001bJ\u000b\u0010W\u001a\u0004\u0018\u00010\u0017H\u00c6\u0003J\u00f2\u0001\u0010X\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00c6\u0001\u00a2\u0006\u0002\u0010YJ\u0013\u0010Z\u001a\u0002022\b\u0010[\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\\\u001a\u00020\u0003H\u00d6\u0001J\t\u0010]\u001a\u00020^H\u00d6\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u001bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u001bR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u001bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b \u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b#\u0010\u001bR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b$\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b%\u0010\u001bR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b&\u0010\u001bR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b'\u0010\u001bR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b(\u0010\u001bR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b)\u0010\u001bR\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b*\u0010\u001bR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b+\u0010\u001bR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b,\u0010\u001bR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b-\u0010\u001bR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b.\u0010\u001bR\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100\u00a8\u0006_"}, d2 = {"Lcom/nothing/earbase/unknown/entity/UnknownFunction;", "", "eq", "", "advancedEqTotalGain", "diracOpteoSupport", "advancedEq", "deviceType", "customEQ", "Lcom/nothing/earbase/unknown/entity/CustomEQ;", "mutuallyExclusive", "diracOpteo", "ancLevel", "diracByPowered", "otaProtocol", "otaPacketType", "supportExplore", "spaceOrAdvance", "supportDetailEnhancement", "exclusiveSpaceNightEq", "supportMiddleEq", "supportLeakageProtection", "controls", "Lcom/nothing/earbase/unknown/entity/UnknownControlsConfig;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/nothing/earbase/unknown/entity/CustomEQ;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/nothing/earbase/unknown/entity/UnknownControlsConfig;)V", "getEq", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAdvancedEqTotalGain", "getDiracOpteoSupport", "getAdvancedEq", "getDeviceType", "getCustomEQ", "()Lcom/nothing/earbase/unknown/entity/CustomEQ;", "getMutuallyExclusive", "getDiracOpteo", "getAncLevel", "getDiracByPowered", "getOtaProtocol", "getOtaPacketType", "getSupportExplore", "getSpaceOrAdvance", "getSupportDetailEnhancement", "getExclusiveSpaceNightEq", "getSupportMiddleEq", "getSupportLeakageProtection", "getControls", "()Lcom/nothing/earbase/unknown/entity/UnknownControlsConfig;", "supportAdvanceEq", "", "isExclusive", "isByPowered", "isDiracEq", "isDiracInfo", "isSupportANC", "isSupportExplore", "isSupportDetailEnhancement", "isSupportMiddleEq", "isSupportLeakageProtection", "getEQList", "", "Lcom/nothing/earbase/unknown/entity/EQ;", "getDiracOpteoEQList", "Lcom/nothing/earbase/unknown/entity/DiracOpteoEQ;", "isSpaceEqExclusive", "isExclusiveSpaceNightEq", "isSupportEssentialSpace", "()Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/nothing/earbase/unknown/entity/CustomEQ;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/nothing/earbase/unknown/entity/UnknownControlsConfig;)Lcom/nothing/earbase/unknown/entity/UnknownFunction;", "equals", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final /* data */ class UnknownFunction {
    private final Integer advancedEq;
    private final Integer advancedEqTotalGain;
    private final Integer ancLevel;
    private final UnknownControlsConfig controls;
    private final CustomEQ customEQ;
    private final Integer deviceType;
    private final Integer diracByPowered;
    private final Integer diracOpteo;
    private final Integer diracOpteoSupport;
    private final Integer eq;
    private final Integer exclusiveSpaceNightEq;
    private final Integer mutuallyExclusive;
    private final Integer otaPacketType;
    private final Integer otaProtocol;
    private final Integer spaceOrAdvance;
    private final Integer supportDetailEnhancement;
    private final Integer supportExplore;
    private final Integer supportLeakageProtection;
    private final Integer supportMiddleEq;

    public UnknownFunction() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 524287, null);
    }

    public static /* synthetic */ UnknownFunction copy$default(UnknownFunction unknownFunction, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, CustomEQ customEQ, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, UnknownControlsConfig unknownControlsConfig, int i, Object obj) {
        UnknownControlsConfig unknownControlsConfig2;
        Integer num18;
        Integer num19 = (i & 1) != 0 ? unknownFunction.eq : num;
        Integer num20 = (i & 2) != 0 ? unknownFunction.advancedEqTotalGain : num2;
        Integer num21 = (i & 4) != 0 ? unknownFunction.diracOpteoSupport : num3;
        Integer num22 = (i & 8) != 0 ? unknownFunction.advancedEq : num4;
        Integer num23 = (i & 16) != 0 ? unknownFunction.deviceType : num5;
        CustomEQ customEQ2 = (i & 32) != 0 ? unknownFunction.customEQ : customEQ;
        Integer num24 = (i & 64) != 0 ? unknownFunction.mutuallyExclusive : num6;
        Integer num25 = (i & 128) != 0 ? unknownFunction.diracOpteo : num7;
        Integer num26 = (i & 256) != 0 ? unknownFunction.ancLevel : num8;
        Integer num27 = (i & 512) != 0 ? unknownFunction.diracByPowered : num9;
        Integer num28 = (i & 1024) != 0 ? unknownFunction.otaProtocol : num10;
        Integer num29 = (i & 2048) != 0 ? unknownFunction.otaPacketType : num11;
        Integer num30 = (i & 4096) != 0 ? unknownFunction.supportExplore : num12;
        Integer num31 = (i & 8192) != 0 ? unknownFunction.spaceOrAdvance : num13;
        Integer num32 = num19;
        Integer num33 = (i & 16384) != 0 ? unknownFunction.supportDetailEnhancement : num14;
        Integer num34 = (i & 32768) != 0 ? unknownFunction.exclusiveSpaceNightEq : num15;
        Integer num35 = (i & 65536) != 0 ? unknownFunction.supportMiddleEq : num16;
        Integer num36 = (i & 131072) != 0 ? unknownFunction.supportLeakageProtection : num17;
        if ((i & 262144) != 0) {
            num18 = num36;
            unknownControlsConfig2 = unknownFunction.controls;
        } else {
            unknownControlsConfig2 = unknownControlsConfig;
            num18 = num36;
        }
        return unknownFunction.copy(num32, num20, num21, num22, num23, customEQ2, num24, num25, num26, num27, num28, num29, num30, num31, num33, num34, num35, num18, unknownControlsConfig2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Integer getEq() {
        return this.eq;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final Integer getDiracByPowered() {
        return this.diracByPowered;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Integer getOtaProtocol() {
        return this.otaProtocol;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Integer getOtaPacketType() {
        return this.otaPacketType;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Integer getSupportExplore() {
        return this.supportExplore;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final Integer getSpaceOrAdvance() {
        return this.spaceOrAdvance;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final Integer getSupportDetailEnhancement() {
        return this.supportDetailEnhancement;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final Integer getExclusiveSpaceNightEq() {
        return this.exclusiveSpaceNightEq;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final Integer getSupportMiddleEq() {
        return this.supportMiddleEq;
    }

    /* JADX INFO: renamed from: component18, reason: from getter */
    public final Integer getSupportLeakageProtection() {
        return this.supportLeakageProtection;
    }

    /* JADX INFO: renamed from: component19, reason: from getter */
    public final UnknownControlsConfig getControls() {
        return this.controls;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Integer getAdvancedEqTotalGain() {
        return this.advancedEqTotalGain;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getDiracOpteoSupport() {
        return this.diracOpteoSupport;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getAdvancedEq() {
        return this.advancedEq;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Integer getDeviceType() {
        return this.deviceType;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final CustomEQ getCustomEQ() {
        return this.customEQ;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getMutuallyExclusive() {
        return this.mutuallyExclusive;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getDiracOpteo() {
        return this.diracOpteo;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final Integer getAncLevel() {
        return this.ancLevel;
    }

    public final UnknownFunction copy(Integer eq, Integer advancedEqTotalGain, Integer diracOpteoSupport, Integer advancedEq, Integer deviceType, CustomEQ customEQ, Integer mutuallyExclusive, Integer diracOpteo, Integer ancLevel, Integer diracByPowered, Integer otaProtocol, Integer otaPacketType, Integer supportExplore, Integer spaceOrAdvance, Integer supportDetailEnhancement, Integer exclusiveSpaceNightEq, Integer supportMiddleEq, Integer supportLeakageProtection, UnknownControlsConfig controls) {
        return new UnknownFunction(eq, advancedEqTotalGain, diracOpteoSupport, advancedEq, deviceType, customEQ, mutuallyExclusive, diracOpteo, ancLevel, diracByPowered, otaProtocol, otaPacketType, supportExplore, spaceOrAdvance, supportDetailEnhancement, exclusiveSpaceNightEq, supportMiddleEq, supportLeakageProtection, controls);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnknownFunction)) {
            return false;
        }
        UnknownFunction unknownFunction = (UnknownFunction) other;
        return Intrinsics.areEqual(this.eq, unknownFunction.eq) && Intrinsics.areEqual(this.advancedEqTotalGain, unknownFunction.advancedEqTotalGain) && Intrinsics.areEqual(this.diracOpteoSupport, unknownFunction.diracOpteoSupport) && Intrinsics.areEqual(this.advancedEq, unknownFunction.advancedEq) && Intrinsics.areEqual(this.deviceType, unknownFunction.deviceType) && Intrinsics.areEqual(this.customEQ, unknownFunction.customEQ) && Intrinsics.areEqual(this.mutuallyExclusive, unknownFunction.mutuallyExclusive) && Intrinsics.areEqual(this.diracOpteo, unknownFunction.diracOpteo) && Intrinsics.areEqual(this.ancLevel, unknownFunction.ancLevel) && Intrinsics.areEqual(this.diracByPowered, unknownFunction.diracByPowered) && Intrinsics.areEqual(this.otaProtocol, unknownFunction.otaProtocol) && Intrinsics.areEqual(this.otaPacketType, unknownFunction.otaPacketType) && Intrinsics.areEqual(this.supportExplore, unknownFunction.supportExplore) && Intrinsics.areEqual(this.spaceOrAdvance, unknownFunction.spaceOrAdvance) && Intrinsics.areEqual(this.supportDetailEnhancement, unknownFunction.supportDetailEnhancement) && Intrinsics.areEqual(this.exclusiveSpaceNightEq, unknownFunction.exclusiveSpaceNightEq) && Intrinsics.areEqual(this.supportMiddleEq, unknownFunction.supportMiddleEq) && Intrinsics.areEqual(this.supportLeakageProtection, unknownFunction.supportLeakageProtection) && Intrinsics.areEqual(this.controls, unknownFunction.controls);
    }

    public int hashCode() {
        Integer num = this.eq;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.advancedEqTotalGain;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.diracOpteoSupport;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.advancedEq;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.deviceType;
        int iHashCode5 = (iHashCode4 + (num5 == null ? 0 : num5.hashCode())) * 31;
        CustomEQ customEQ = this.customEQ;
        int iHashCode6 = (iHashCode5 + (customEQ == null ? 0 : customEQ.hashCode())) * 31;
        Integer num6 = this.mutuallyExclusive;
        int iHashCode7 = (iHashCode6 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.diracOpteo;
        int iHashCode8 = (iHashCode7 + (num7 == null ? 0 : num7.hashCode())) * 31;
        Integer num8 = this.ancLevel;
        int iHashCode9 = (iHashCode8 + (num8 == null ? 0 : num8.hashCode())) * 31;
        Integer num9 = this.diracByPowered;
        int iHashCode10 = (iHashCode9 + (num9 == null ? 0 : num9.hashCode())) * 31;
        Integer num10 = this.otaProtocol;
        int iHashCode11 = (iHashCode10 + (num10 == null ? 0 : num10.hashCode())) * 31;
        Integer num11 = this.otaPacketType;
        int iHashCode12 = (iHashCode11 + (num11 == null ? 0 : num11.hashCode())) * 31;
        Integer num12 = this.supportExplore;
        int iHashCode13 = (iHashCode12 + (num12 == null ? 0 : num12.hashCode())) * 31;
        Integer num13 = this.spaceOrAdvance;
        int iHashCode14 = (iHashCode13 + (num13 == null ? 0 : num13.hashCode())) * 31;
        Integer num14 = this.supportDetailEnhancement;
        int iHashCode15 = (iHashCode14 + (num14 == null ? 0 : num14.hashCode())) * 31;
        Integer num15 = this.exclusiveSpaceNightEq;
        int iHashCode16 = (iHashCode15 + (num15 == null ? 0 : num15.hashCode())) * 31;
        Integer num16 = this.supportMiddleEq;
        int iHashCode17 = (iHashCode16 + (num16 == null ? 0 : num16.hashCode())) * 31;
        Integer num17 = this.supportLeakageProtection;
        int iHashCode18 = (iHashCode17 + (num17 == null ? 0 : num17.hashCode())) * 31;
        UnknownControlsConfig unknownControlsConfig = this.controls;
        return iHashCode18 + (unknownControlsConfig != null ? unknownControlsConfig.hashCode() : 0);
    }

    public final boolean isSupportMiddleEq() {
        return false;
    }

    public String toString() {
        return "UnknownFunction(eq=" + this.eq + ", advancedEqTotalGain=" + this.advancedEqTotalGain + ", diracOpteoSupport=" + this.diracOpteoSupport + ", advancedEq=" + this.advancedEq + ", deviceType=" + this.deviceType + ", customEQ=" + this.customEQ + ", mutuallyExclusive=" + this.mutuallyExclusive + ", diracOpteo=" + this.diracOpteo + ", ancLevel=" + this.ancLevel + ", diracByPowered=" + this.diracByPowered + ", otaProtocol=" + this.otaProtocol + ", otaPacketType=" + this.otaPacketType + ", supportExplore=" + this.supportExplore + ", spaceOrAdvance=" + this.spaceOrAdvance + ", supportDetailEnhancement=" + this.supportDetailEnhancement + ", exclusiveSpaceNightEq=" + this.exclusiveSpaceNightEq + ", supportMiddleEq=" + this.supportMiddleEq + ", supportLeakageProtection=" + this.supportLeakageProtection + ", controls=" + this.controls + ")";
    }

    public UnknownFunction(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, CustomEQ customEQ, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, UnknownControlsConfig unknownControlsConfig) {
        this.eq = num;
        this.advancedEqTotalGain = num2;
        this.diracOpteoSupport = num3;
        this.advancedEq = num4;
        this.deviceType = num5;
        this.customEQ = customEQ;
        this.mutuallyExclusive = num6;
        this.diracOpteo = num7;
        this.ancLevel = num8;
        this.diracByPowered = num9;
        this.otaProtocol = num10;
        this.otaPacketType = num11;
        this.supportExplore = num12;
        this.spaceOrAdvance = num13;
        this.supportDetailEnhancement = num14;
        this.exclusiveSpaceNightEq = num15;
        this.supportMiddleEq = num16;
        this.supportLeakageProtection = num17;
        this.controls = unknownControlsConfig;
    }

    public final Integer getEq() {
        return this.eq;
    }

    public final Integer getAdvancedEqTotalGain() {
        return this.advancedEqTotalGain;
    }

    public final Integer getDiracOpteoSupport() {
        return this.diracOpteoSupport;
    }

    public final Integer getAdvancedEq() {
        return this.advancedEq;
    }

    public final Integer getDeviceType() {
        return this.deviceType;
    }

    public final CustomEQ getCustomEQ() {
        return this.customEQ;
    }

    public final Integer getMutuallyExclusive() {
        return this.mutuallyExclusive;
    }

    public /* synthetic */ UnknownFunction(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, CustomEQ customEQ, Integer num6, Integer num7, Integer num8, Integer num9, Integer num10, Integer num11, Integer num12, Integer num13, Integer num14, Integer num15, Integer num16, Integer num17, UnknownControlsConfig unknownControlsConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : num4, (i & 16) != 0 ? null : num5, (i & 32) != 0 ? null : customEQ, (i & 64) != 0 ? null : num6, (i & 128) != 0 ? 0 : num7, (i & 256) != 0 ? null : num8, (i & 512) != 0 ? null : num9, (i & 1024) != 0 ? null : num10, (i & 2048) != 0 ? null : num11, (i & 4096) != 0 ? null : num12, (i & 8192) != 0 ? null : num13, (i & 16384) != 0 ? null : num14, (i & 32768) != 0 ? null : num15, (i & 65536) != 0 ? null : num16, (i & 131072) != 0 ? null : num17, (i & 262144) != 0 ? null : unknownControlsConfig);
    }

    public final Integer getDiracOpteo() {
        return this.diracOpteo;
    }

    public final Integer getAncLevel() {
        return this.ancLevel;
    }

    public final Integer getDiracByPowered() {
        return this.diracByPowered;
    }

    public final Integer getOtaProtocol() {
        return this.otaProtocol;
    }

    public final Integer getOtaPacketType() {
        return this.otaPacketType;
    }

    public final Integer getSupportExplore() {
        return this.supportExplore;
    }

    public final Integer getSpaceOrAdvance() {
        return this.spaceOrAdvance;
    }

    public final Integer getSupportDetailEnhancement() {
        return this.supportDetailEnhancement;
    }

    public final Integer getExclusiveSpaceNightEq() {
        return this.exclusiveSpaceNightEq;
    }

    public final Integer getSupportMiddleEq() {
        return this.supportMiddleEq;
    }

    public final Integer getSupportLeakageProtection() {
        return this.supportLeakageProtection;
    }

    public final UnknownControlsConfig getControls() {
        return this.controls;
    }

    public final boolean supportAdvanceEq() {
        Integer num = this.advancedEq;
        return num != null && num.intValue() == 1;
    }

    public final boolean isExclusive() {
        Integer num = this.mutuallyExclusive;
        return num != null && num.intValue() == 1;
    }

    public final boolean isByPowered() {
        Integer num = this.diracByPowered;
        return num != null && num.intValue() == 1;
    }

    public final boolean isDiracEq() {
        Integer num = this.diracOpteo;
        return (num != null ? num.intValue() : 0) > 0;
    }

    public final boolean isDiracInfo() {
        return getDiracOpteoEQList().contains(DiracOpteoEQ.OPTEO);
    }

    public final boolean isSupportANC() {
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str = "unknown_widget ancLevel:" + this.ancLevel;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        Integer num = this.ancLevel;
        return (num == null || num.intValue() != 0) && this.ancLevel != null;
    }

    public final boolean isSupportExplore() {
        Logger logger = Logger.INSTANCE;
        Logger logger2 = Logger.INSTANCE;
        Logger logger3 = logger;
        String tag = logger3.getTAG();
        int depth = logger3.getDepth();
        if (logger3.isCanLogger(true)) {
            String str = "unknown_widget explore:" + this.supportExplore;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        Integer num = this.supportExplore;
        return (num == null || num == null || num.intValue() != 1) ? false : true;
    }

    public final boolean isSupportDetailEnhancement() {
        Integer num = this.supportDetailEnhancement;
        return num != null && num.intValue() == 1;
    }

    public final boolean isSupportLeakageProtection() {
        Integer num = this.supportLeakageProtection;
        return num != null && num.intValue() == 1;
    }

    public final List<EQ> getEQList() {
        ArrayList arrayList = new ArrayList();
        EQ[] eqArr = (EQ[]) EQ.getEntries().toArray(new EQ[0]);
        int length = eqArr.length;
        for (int i = 0; i < length; i++) {
            Integer num = this.eq;
            if ((num == null || (num.intValue() & (1 << i)) != 0) && this.eq != null) {
                arrayList.add(eqArr[i]);
            }
        }
        return arrayList;
    }

    public final List<DiracOpteoEQ> getDiracOpteoEQList() {
        ArrayList arrayList = new ArrayList();
        DiracOpteoEQ[] diracOpteoEQArr = (DiracOpteoEQ[]) DiracOpteoEQ.getEntries().toArray(new DiracOpteoEQ[0]);
        int length = diracOpteoEQArr.length;
        for (int i = 0; i < length; i++) {
            Integer num = this.diracOpteo;
            if ((num == null || (num.intValue() & (1 << i)) != 0) && this.diracOpteo != null) {
                arrayList.add(diracOpteoEQArr[i]);
            }
        }
        return arrayList;
    }

    public final boolean isSpaceEqExclusive() {
        Integer num = this.spaceOrAdvance;
        return (num != null ? num.intValue() : 0) == 1;
    }

    public final boolean isExclusiveSpaceNightEq() {
        Integer num = this.exclusiveSpaceNightEq;
        return num != null && num.intValue() == 1;
    }

    public final Boolean isSupportEssentialSpace() {
        UnknownControlsConfig unknownControlsConfig = this.controls;
        if (unknownControlsConfig != null) {
            return unknownControlsConfig.isSupportEssentialSpace();
        }
        return null;
    }
}
