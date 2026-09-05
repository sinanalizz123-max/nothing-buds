package com.nothing.protocol.device;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.google.android.exoplayer2.Renderer;
import com.nothing.base.protocol.constant.ITWSParse;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.earbase.guide.AnimalBaseGuideActivity;
import com.nothing.log.FileLog;
import com.nothing.protocol.model.Message;
import com.tekartik.sqflite.Constant;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: TWSDeviceBuilder.kt */
/* JADX INFO: loaded from: /tmp/source/classes7.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 b2\u00020\u0001:\u0001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010/\u001a\u00020\u0000J\u000e\u00102\u001a\u00020\u00002\u0006\u00108\u001a\u00020\tJ\u000e\u0010\u001a\u001a\u0002092\u0006\u0010:\u001a\u00020\u001bJ$\u0010\u001a\u001a\u0002092\u0006\u0010:\u001a\u00020\u001b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<H\u0086\b\u00f8\u0001\u0000J\u000e\u0010 \u001a\u0002092\u0006\u0010:\u001a\u00020\u001bJ$\u0010 \u001a\u0002092\u0006\u0010:\u001a\u00020\u001b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<H\u0086\b\u00f8\u0001\u0000J4\u0010 \u001a\u0002092\u0006\u0010:\u001a\u00020\u001b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<2\u000e\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<H\u0086\b\u00f8\u0001\u0000J\u000e\u0010#\u001a\u0002092\u0006\u0010:\u001a\u00020\u001bJ\u001a\u0010>\u001a\u00020\t2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010'H\u0086@\u00a2\u0006\u0002\u0010@J\u001c\u0010A\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010'H\u0086@\u00a2\u0006\u0002\u0010@J\u001a\u0010C\u001a\u00020\t2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010'H\u0086@\u00a2\u0006\u0002\u0010@J \u0010A\u001a\u0004\u0018\u00010B2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<H\u0086H\u00a2\u0006\u0002\u0010DJ\u001c\u0010E\u001a\u0004\u0018\u00010B2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010'H\u0086@\u00a2\u0006\u0002\u0010@J\u001c\u0010F\u001a\u0002092\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<H\u0086\b\u00f8\u0001\u0000J,\u0010F\u001a\u0002092\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<2\u000e\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<H\u0086\b\u00f8\u0001\u0000J\u0012\u0010F\u001a\u0002092\n\b\u0002\u0010?\u001a\u0004\u0018\u00010'J\u001e\u0010F\u001a\u0002092\n\b\u0002\u0010?\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010'J&\u0010H\u001a\u0002092\b\b\u0002\u0010I\u001a\u00020\t2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010K\u001a\u00020\u001bJ\u000e\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0MJ+\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001HN0M\"\n\b\u0000\u0010N\u0018\u0001*\u00020O2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HN0QH\u0086\bJ8\u0010R\u001a\u000209\"\n\b\u0000\u0010N\u0018\u0001*\u00020O2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010'2\u0010\u0010S\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001HN\u0018\u00010MH\u0086H\u00a2\u0006\u0002\u0010TJ4\u0010R\u001a\u00020\t2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010U\u001a\u00020\t2\u000e\u0010V\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0<H\u0086H\u00a2\u0006\u0002\u0010WJ=\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001HN0M\"\u0006\b\u0000\u0010N\u0018\u00012\b\b\u0002\u0010I\u001a\u00020\t2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010'2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HN0QH\u0086\bJ7\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001HN0M\"\u0006\b\u0000\u0010N\u0018\u00012\u000e\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010B0M2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HN0QH\u0086\bJ0\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020\t2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010'2\u0014\u0010;\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010B\u0012\u0004\u0012\u0002090[JD\u0010\\\u001a\u0002092\u0006\u0010I\u001a\u00020\t2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010'2\u0014\u0010;\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010B\u0012\u0004\u0012\u0002090[2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010'H\u0086@\u00a2\u0006\u0002\u0010]J0\u0010^\u001a\u0004\u0018\u00010B2\u0006\u0010I\u001a\u00020\t2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010'H\u0086@\u00a2\u0006\u0002\u0010_J&\u0010`\u001a\u0002092\n\b\u0002\u0010J\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010I\u001a\u00020\t2\b\b\u0002\u0010a\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\rR\u001a\u00102\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR\u001c\u00105\u001a\u0004\u0018\u00010'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u0010)\"\u0004\b7\u0010+\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006c"}, d2 = {"Lcom/nothing/protocol/device/TWSDeviceBuilder;", "", "twsDevice", "Lcom/nothing/protocol/device/TWSDevice;", "<init>", "(Lcom/nothing/protocol/device/TWSDevice;)V", "getTwsDevice", "()Lcom/nothing/protocol/device/TWSDevice;", "ignoreClassicBluetooth", "", "getIgnoreClassicBluetooth", "()Z", "setIgnoreClassicBluetooth", "(Z)V", "needCache", "getNeedCache", "setNeedCache", "timeOut", "", "getTimeOut", "()Ljava/lang/Long;", "setTimeOut", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isNeedFsn", "setNeedFsn", "getCommand", "", "getGetCommand", "()I", "setGetCommand", "(I)V", "setCommand", "getSetCommand", "setSetCommand", "notifyCommand", "getNotifyCommand", "setNotifyCommand", "getPayload", "", "getGetPayload", "()[B", "setGetPayload", "([B)V", "setPayload", "getSetPayload", "setSetPayload", "foreverUpdate", "getForeverUpdate", "setForeverUpdate", "getSynUpdate", "getGetSynUpdate", "setGetSynUpdate", "mockResponse", "getMockResponse", "setMockResponse", Constant.METHOD_UPDATE, "", "command", "action", "Lkotlin/Function0;", "mockAction", "setSync", "byteArray", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSyncResponse", "Lcom/nothing/protocol/model/Message;", "getSync", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSyncResponse", "setASync", "mock", "sendMessage", "isGetCommand", "payload", "retryCount", "getLiveData", "Landroidx/lifecycle/LiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/nothing/base/protocol/constant/ITWSParse;", "clazz", "Ljava/lang/Class;", "setAndUpdateLiveData", "preLiveData", "([BLandroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "needUpdate", "cachePayload", "([BZLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessageWithLiveData", "parseLiveData", "liveData", "Lkotlin/Function1;", "sendMessageSync", "(Z[BLkotlin/jvm/functions/Function1;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSyncResponse", "(Z[B[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateCache", "isUpdate", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TWSDeviceBuilder {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean foreverUpdate;
    private int getCommand;
    private byte[] getPayload;
    private boolean getSynUpdate;
    private boolean ignoreClassicBluetooth;
    private boolean isNeedFsn;
    private byte[] mockResponse;
    private boolean needCache;
    private int notifyCommand;
    private int setCommand;
    private byte[] setPayload;
    private Long timeOut;
    private final TWSDevice twsDevice;

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDeviceBuilder$getSync$1, reason: invalid class name */
    /* JADX INFO: compiled from: TWSDeviceBuilder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDeviceBuilder", f = "TWSDeviceBuilder.kt", i = {}, l = {Renderer.MSG_SET_WAKEUP_LISTENER}, m = "getSync", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TWSDeviceBuilder.this.getSync(null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDeviceBuilder$sendMessageSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSDeviceBuilder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDeviceBuilder", f = "TWSDeviceBuilder.kt", i = {0}, l = {293}, m = "sendMessageSync", n = {"action"}, s = {"L$0"})
    static final class C10671 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10671(Continuation<? super C10671> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TWSDeviceBuilder.this.sendMessageSync(false, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDeviceBuilder$setAndUpdateLiveData$2, reason: invalid class name */
    /* JADX INFO: compiled from: TWSDeviceBuilder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDeviceBuilder", f = "TWSDeviceBuilder.kt", i = {0, 0, 0}, l = {AnimalBaseGuideActivity.REPEAT_TWO_START}, m = "setAndUpdateLiveData", n = {"this", "cachePayload", "needUpdate"}, s = {"L$0", "L$1", "Z$0"})
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TWSDeviceBuilder.this.setAndUpdateLiveData(null, false, null, this);
        }
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDeviceBuilder$setSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TWSDeviceBuilder.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDeviceBuilder", f = "TWSDeviceBuilder.kt", i = {}, l = {95}, m = "setSync", n = {}, s = {})
    static final class C10681 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C10681(Continuation<? super C10681> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return TWSDeviceBuilder.this.setSync(null, this);
        }
    }

    public TWSDeviceBuilder(TWSDevice twsDevice) {
        Intrinsics.checkNotNullParameter(twsDevice, "twsDevice");
        this.twsDevice = twsDevice;
        this.needCache = true;
        this.isNeedFsn = true;
        this.getSynUpdate = true;
    }

    public final TWSDevice getTwsDevice() {
        return this.twsDevice;
    }

    public final boolean getIgnoreClassicBluetooth() {
        return this.ignoreClassicBluetooth;
    }

    public final void setIgnoreClassicBluetooth(boolean z) {
        this.ignoreClassicBluetooth = z;
    }

    public final boolean getNeedCache() {
        return this.needCache;
    }

    public final void setNeedCache(boolean z) {
        this.needCache = z;
    }

    public final Long getTimeOut() {
        return this.timeOut;
    }

    public final void setTimeOut(Long l) {
        this.timeOut = l;
    }

    /* JADX INFO: renamed from: isNeedFsn, reason: from getter */
    public final boolean getIsNeedFsn() {
        return this.isNeedFsn;
    }

    public final void setNeedFsn(boolean z) {
        this.isNeedFsn = z;
    }

    public final int getGetCommand() {
        return this.getCommand;
    }

    public final void setGetCommand(int i) {
        this.getCommand = i;
    }

    public final int getSetCommand() {
        return this.setCommand;
    }

    public final void setSetCommand(int i) {
        this.setCommand = i;
    }

    public final int getNotifyCommand() {
        return this.notifyCommand;
    }

    public final void setNotifyCommand(int i) {
        this.notifyCommand = i;
    }

    public final byte[] getGetPayload() {
        return this.getPayload;
    }

    public final void setGetPayload(byte[] bArr) {
        this.getPayload = bArr;
    }

    public final byte[] getSetPayload() {
        return this.setPayload;
    }

    public final void setSetPayload(byte[] bArr) {
        this.setPayload = bArr;
    }

    public final boolean getForeverUpdate() {
        return this.foreverUpdate;
    }

    public final void setForeverUpdate(boolean z) {
        this.foreverUpdate = z;
    }

    public final boolean getGetSynUpdate() {
        return this.getSynUpdate;
    }

    public final void setGetSynUpdate(boolean z) {
        this.getSynUpdate = z;
    }

    /* JADX INFO: compiled from: TWSDeviceBuilder.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J2\u0010\u0004\u001a\u0004\u0018\u0001H\u0005\"\u0006\b\u0000\u0010\u0005\u0018\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0086\b\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/nothing/protocol/device/TWSDeviceBuilder$Companion;", "", "<init>", "()V", "parse", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/LiveData;", "Lcom/nothing/protocol/model/Message;", "clazz", "Ljava/lang/Class;", "(Landroidx/lifecycle/LiveData;Ljava/lang/Class;)Ljava/lang/Object;", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final /* synthetic */ <T> T parse(LiveData<Message> liveData, Class<T> clazz) {
            byte[] payload;
            Float f;
            Intrinsics.checkNotNullParameter(liveData, "<this>");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Message value = liveData.getValue();
            T tNewInstance = null;
            if (value != null && (payload = value.getPayload()) != null) {
                byte[] bArr = payload;
                try {
                    if (Intrinsics.areEqual(clazz, Integer.TYPE)) {
                        Integer numValueOf = Integer.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null));
                        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                        f = numValueOf;
                    } else if (Intrinsics.areEqual(clazz, Long.TYPE)) {
                        Long lValueOf = Long.valueOf(DataExtKt.toLong$default(bArr, 0, 0, 3, null));
                        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                        f = lValueOf;
                    } else if (Intrinsics.areEqual(clazz, String.class)) {
                        String strDecodeToString = StringsKt.decodeToString(bArr);
                        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                        f = strDecodeToString;
                    } else if (Intrinsics.areEqual(clazz, Boolean.TYPE)) {
                        Boolean boolValueOf = Boolean.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null) == 1);
                        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                        f = boolValueOf;
                    } else if (Intrinsics.areEqual(clazz, Float.TYPE)) {
                        Float fValueOf = Float.valueOf(DataExtKt.toFloat$default(bArr, 0, 0, 0, 7, null));
                        Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                        f = fValueOf;
                    } else {
                        try {
                            tNewInstance = clazz.getConstructor(byte[].class).newInstance(bArr);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        f = tNewInstance;
                    }
                    tNewInstance = (T) f;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "parseLiveData " + clazz + StringUtils.SPACE + tNewInstance + StringUtils.SPACE;
                String str2 = str;
                if (str2 != null && str2.length() != 0) {
                    Pair<String, String> trace = logger.getTrace(depth);
                    String strComponent1 = trace.component1();
                    String strComponent2 = trace.component2();
                    FileLog fileLog = FileLog.INSTANCE;
                    String str3 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    }
                }
            }
            return tNewInstance;
        }
    }

    public final byte[] getMockResponse() {
        return this.mockResponse;
    }

    public final void setMockResponse(byte[] bArr) {
        this.mockResponse = bArr;
    }

    public final TWSDeviceBuilder foreverUpdate() {
        this.foreverUpdate = true;
        return this;
    }

    public final TWSDeviceBuilder getSynUpdate(boolean update) {
        this.getSynUpdate = update;
        return this;
    }

    public final void getCommand(int command) {
        this.getCommand = command;
    }

    public final void getCommand(int command, Function0<byte[]> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        setGetCommand(command);
        setGetPayload(action.invoke());
    }

    public final void setCommand(int command) {
        this.setCommand = command;
    }

    public final void setCommand(int command, Function0<byte[]> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        setSetCommand(command);
        setSetPayload(action.invoke());
    }

    public final void setCommand(int command, Function0<byte[]> action, Function0<byte[]> mockAction) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(mockAction, "mockAction");
        setSetCommand(command);
        setSetPayload(action.invoke());
        setMockResponse(mockAction.invoke());
    }

    public final void notifyCommand(int command) {
        this.notifyCommand = command;
    }

    public static /* synthetic */ Object setSync$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = null;
        }
        return tWSDeviceBuilder.setSync(bArr, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object setSync(byte[] bArr, Continuation<? super Boolean> continuation) {
        C10681 c10681;
        if (continuation instanceof C10681) {
            c10681 = (C10681) continuation;
            if ((c10681.label & Integer.MIN_VALUE) != 0) {
                c10681.label -= Integer.MIN_VALUE;
            } else {
                c10681 = new C10681(continuation);
            }
        } else {
            c10681 = new C10681(continuation);
        }
        C10681 c10682 = c10681;
        Object objSendSyncResponse$default = c10682.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10682.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSendSyncResponse$default);
            c10682.label = 1;
            objSendSyncResponse$default = sendSyncResponse$default(this, false, bArr, null, c10682, 4, null);
            if (objSendSyncResponse$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSendSyncResponse$default);
        }
        Message message = (Message) objSendSyncResponse$default;
        return Boxing.boxBoolean(message != null ? message.isOk() : false);
    }

    public static /* synthetic */ Object getSyncResponse$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = null;
        }
        return tWSDeviceBuilder.getSyncResponse(bArr, (Continuation<? super Message>) continuation);
    }

    public final Object getSyncResponse(byte[] bArr, Continuation<? super Message> continuation) {
        return sendSyncResponse$default(this, true, bArr, null, continuation, 4, null);
    }

    public static /* synthetic */ Object getSync$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = null;
        }
        return tWSDeviceBuilder.getSync(bArr, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getSync(byte[] bArr, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        AnonymousClass1 anonymousClass2 = anonymousClass1;
        Object objSendSyncResponse$default = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSendSyncResponse$default);
            anonymousClass2.label = 1;
            objSendSyncResponse$default = sendSyncResponse$default(this, true, bArr, null, anonymousClass2, 4, null);
            if (objSendSyncResponse$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objSendSyncResponse$default);
        }
        Message message = (Message) objSendSyncResponse$default;
        return Boxing.boxBoolean(message != null && message.isOk());
    }

    private final Object getSyncResponse$$forInline(Function0<byte[]> function0, Continuation<? super Message> continuation) {
        return sendSyncResponse$default(this, true, function0.invoke(), null, continuation, 4, null);
    }

    public final Object getSyncResponse(Function0<byte[]> function0, Continuation<? super Message> continuation) {
        return sendSyncResponse$default(this, true, function0.invoke(), null, continuation, 4, null);
    }

    public static /* synthetic */ Object setSyncResponse$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = null;
        }
        return tWSDeviceBuilder.setSyncResponse(bArr, continuation);
    }

    public final Object setSyncResponse(byte[] bArr, Continuation<? super Message> continuation) {
        return sendSyncResponse$default(this, false, bArr, null, continuation, 4, null);
    }

    public final void setASync(Function0<byte[]> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        sendMessage$default(this, false, action.invoke(), 0, 4, (Object) null);
    }

    public final void setASync(Function0<byte[]> action, Function0<byte[]> mock) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(mock, "mock");
        setMockResponse(mock.invoke());
        sendMessage$default(this, false, action.invoke(), 0, 4, (Object) null);
    }

    public static /* synthetic */ void setASync$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = null;
        }
        tWSDeviceBuilder.setASync(bArr);
    }

    public final void setASync(byte[] byteArray) {
        sendMessage$default(this, false, byteArray, 0, 4, (Object) null);
    }

    public static /* synthetic */ void setASync$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = null;
        }
        if ((i & 2) != 0) {
            bArr2 = null;
        }
        tWSDeviceBuilder.setASync(bArr, bArr2);
    }

    public final void setASync(byte[] byteArray, byte[] mock) {
        this.mockResponse = mock;
        sendMessage$default(this, false, byteArray, 0, 4, (Object) null);
    }

    public static /* synthetic */ void sendMessage$default(TWSDeviceBuilder tWSDeviceBuilder, boolean z, byte[] bArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            bArr = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        tWSDeviceBuilder.sendMessage(z, bArr, i);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00be  */
    public final void sendMessage(boolean isGetCommand, byte[] payload, int retryCount) {
        byte[] bArr;
        byte[] bArr2;
        int i = isGetCommand ? this.getCommand : this.setCommand;
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "sendMessageGetCommand " + DataExtKt.toHexString(i);
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 3, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        TWSDevice tWSDevice = this.twsDevice;
        if (isGetCommand) {
            if (payload == null) {
                bArr = this.getPayload;
                bArr2 = bArr;
            } else {
                bArr2 = payload;
            }
        } else if (payload == null) {
            bArr = this.setPayload;
            bArr2 = bArr;
        } else {
            bArr2 = payload;
        }
        tWSDevice.sendMessage(i, bArr2, this.ignoreClassicBluetooth, this.needCache, this.timeOut, this.mockResponse, retryCount);
    }

    public final LiveData<Message> getLiveData() {
        return this.twsDevice.getCommandCache().getLiveDataCommand(this.getCommand, this.notifyCommand);
    }

    public final /* synthetic */ <T extends ITWSParse> LiveData<T> getLiveData(final Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        LiveData<Message> liveDataCommand = getTwsDevice().getCommandCache().getLiveDataCommand(getGetCommand(), getNotifyCommand());
        Intrinsics.needClassReification();
        return Transformations.map(liveDataCommand, new Function1<Message, T>() { // from class: com.nothing.protocol.device.TWSDeviceBuilder$getLiveData$$inlined$parseLiveData$1
            @Override // kotlin.jvm.functions.Function1
            public final T invoke(Message message) {
                byte[] payload;
                Float f;
                T tNewInstance = null;
                if (message != null && (payload = message.getPayload()) != null) {
                    Class cls = clazz;
                    byte[] bArr = payload;
                    try {
                        if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                            Integer numValueOf = Integer.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null));
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = numValueOf;
                        } else if (Intrinsics.areEqual(cls, Long.TYPE)) {
                            Long lValueOf = Long.valueOf(DataExtKt.toLong$default(bArr, 0, 0, 3, null));
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = lValueOf;
                        } else if (Intrinsics.areEqual(cls, String.class)) {
                            String strDecodeToString = StringsKt.decodeToString(bArr);
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = strDecodeToString;
                        } else if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                            Boolean boolValueOf = Boolean.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null) == 1);
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = boolValueOf;
                        } else if (Intrinsics.areEqual(cls, Float.TYPE)) {
                            Float fValueOf = Float.valueOf(DataExtKt.toFloat$default(bArr, 0, 0, 0, 7, null));
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = fValueOf;
                        } else {
                            try {
                                tNewInstance = cls.getConstructor(byte[].class).newInstance(bArr);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            f = tNewInstance;
                        }
                        tNewInstance = (T) f;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                Logger logger = Logger.INSTANCE;
                Class cls2 = clazz;
                Logger logger2 = logger;
                String tag = logger2.getTAG();
                int depth = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str = "parseLiveData " + cls2 + StringUtils.SPACE + tNewInstance + StringUtils.SPACE;
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger2.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                return tNewInstance;
            }
        });
    }

    public static /* synthetic */ Object setAndUpdateLiveData$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, LiveData liveData, Continuation continuation, int i, Object obj) {
        ITWSParse iTWSParse;
        if ((i & 1) != 0) {
            bArr = null;
        }
        int setCommand = tWSDeviceBuilder.getSetCommand();
        TWSDevice twsDevice = tWSDeviceBuilder.getTwsDevice();
        if (bArr == null) {
            bArr = tWSDeviceBuilder.getSetPayload();
        }
        Message message = (Message) TWSDevice.syncSetResponse$default(twsDevice, setCommand, bArr, tWSDeviceBuilder.getTimeOut(), tWSDeviceBuilder.getIsNeedFsn(), false, tWSDeviceBuilder.getMockResponse(), continuation, 16, null);
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), setCommand, 0, 2, null);
            byte[] bArrObtainDataPacket = (liveData == null || (iTWSParse = (ITWSParse) liveData.getValue()) == null) ? null : iTWSParse.obtainDataPacket();
            Message message2 = (Message) liveDataCommand$default.getValue();
            if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrObtainDataPacket);
                tWSDeviceBuilder.getTwsDevice().updateFromCache(tWSDeviceBuilder.getGetCommand());
            }
        }
        return Unit.INSTANCE;
    }

    public final /* synthetic */ <T extends ITWSParse> Object setAndUpdateLiveData(byte[] bArr, LiveData<T> liveData, Continuation<? super Unit> continuation) {
        T value;
        int setCommand = getSetCommand();
        TWSDevice twsDevice = getTwsDevice();
        if (bArr == null) {
            bArr = getSetPayload();
        }
        Message message = (Message) TWSDevice.syncSetResponse$default(twsDevice, setCommand, bArr, getTimeOut(), getIsNeedFsn(), false, getMockResponse(), continuation, 16, null);
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(getTwsDevice().getCommandCache(), setCommand, 0, 2, null);
            byte[] bArrObtainDataPacket = (liveData == null || (value = liveData.getValue()) == null) ? null : value.obtainDataPacket();
            Message message2 = (Message) liveDataCommand$default.getValue();
            if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                getTwsDevice().setCacheCommandsManualPayload(getGetCommand(), bArrObtainDataPacket);
                getTwsDevice().updateFromCache(getGetCommand());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0016  */
    public final Object setAndUpdateLiveData(byte[] bArr, boolean z, Function0<byte[]> function0, Continuation<? super Boolean> continuation) {
        AnonymousClass2 anonymousClass2;
        Function0<byte[]> function1;
        boolean z2;
        TWSDeviceBuilder tWSDeviceBuilder;
        if (continuation instanceof AnonymousClass2) {
            anonymousClass2 = (AnonymousClass2) continuation;
            if ((anonymousClass2.label & Integer.MIN_VALUE) != 0) {
                anonymousClass2.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass2 = new AnonymousClass2(continuation);
            }
        } else {
            anonymousClass2 = new AnonymousClass2(continuation);
        }
        AnonymousClass2 anonymousClass3 = anonymousClass2;
        Object obj = anonymousClass3.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass3.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int setCommand = getSetCommand();
            TWSDevice twsDevice = getTwsDevice();
            if (bArr == null) {
                bArr = getSetPayload();
            }
            Long timeOut = getTimeOut();
            boolean isNeedFsn = getIsNeedFsn();
            byte[] mockResponse = getMockResponse();
            anonymousClass3.L$0 = this;
            anonymousClass3.L$1 = function0;
            anonymousClass3.Z$0 = z;
            anonymousClass3.label = 1;
            Object objSyncSetResponse$default = TWSDevice.syncSetResponse$default(twsDevice, setCommand, bArr, timeOut, isNeedFsn, false, mockResponse, anonymousClass3, 16, null);
            if (objSyncSetResponse$default == coroutine_suspended) {
                return coroutine_suspended;
            }
            function1 = function0;
            z2 = z;
            obj = objSyncSetResponse$default;
            tWSDeviceBuilder = this;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            z2 = anonymousClass3.Z$0;
            function1 = (Function0) anonymousClass3.L$1;
            tWSDeviceBuilder = (TWSDeviceBuilder) anonymousClass3.L$0;
            ResultKt.throwOnFailure(obj);
        }
        Message message = (Message) obj;
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
            byte[] bArrInvoke = function1.invoke();
            Message message2 = (Message) liveDataCommand$default.getValue();
            if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrInvoke)) {
                tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArrInvoke);
                if (message2 != null) {
                    message2.setPayload(bArrInvoke);
                    if (z2) {
                        tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message2);
                    }
                }
            }
            return Boxing.boxBoolean(true);
        }
        return Boxing.boxBoolean(false);
    }

    private final Object setAndUpdateLiveData$$forInline(byte[] bArr, boolean z, Function0<byte[]> function0, Continuation<? super Boolean> continuation) {
        int setCommand = getSetCommand();
        TWSDevice twsDevice = getTwsDevice();
        if (bArr == null) {
            bArr = getSetPayload();
        }
        Message message = (Message) TWSDevice.syncSetResponse$default(twsDevice, setCommand, bArr, getTimeOut(), getIsNeedFsn(), false, getMockResponse(), continuation, 16, null);
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(getTwsDevice().getCommandCache(), getGetCommand(), 0, 2, null);
            byte[] bArrInvoke = function0.invoke();
            Message message2 = (Message) liveDataCommand$default.getValue();
            if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrInvoke)) {
                getTwsDevice().setCacheCommandsManualPayload(getGetCommand(), bArrInvoke);
                if (message2 != null) {
                    message2.setPayload(bArrInvoke);
                    if (z) {
                        getTwsDevice().onUpdate(getGetCommand(), message2);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ Object setAndUpdateLiveData$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, boolean z, Function0 function0, Continuation continuation, int i, Object obj) {
        byte[] setPayload = (i & 1) != 0 ? null : bArr;
        boolean z2 = (i & 2) != 0 ? true : z;
        int setCommand = tWSDeviceBuilder.getSetCommand();
        TWSDevice twsDevice = tWSDeviceBuilder.getTwsDevice();
        if (setPayload == null) {
            setPayload = tWSDeviceBuilder.getSetPayload();
        }
        Message message = (Message) TWSDevice.syncSetResponse$default(twsDevice, setCommand, setPayload, tWSDeviceBuilder.getTimeOut(), tWSDeviceBuilder.getIsNeedFsn(), false, tWSDeviceBuilder.getMockResponse(), continuation, 16, null);
        if (message != null && message.isOk()) {
            LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilder.getTwsDevice().getCommandCache(), tWSDeviceBuilder.getGetCommand(), 0, 2, null);
            byte[] bArr2 = (byte[]) function0.invoke();
            Message message2 = (Message) liveDataCommand$default.getValue();
            if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArr2)) {
                tWSDeviceBuilder.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilder.getGetCommand(), bArr2);
                if (message2 != null) {
                    message2.setPayload(bArr2);
                    if (z2) {
                        tWSDeviceBuilder.getTwsDevice().onUpdate(tWSDeviceBuilder.getGetCommand(), message2);
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static /* synthetic */ LiveData sendMessageWithLiveData$default(TWSDeviceBuilder tWSDeviceBuilder, boolean z, byte[] bArr, Class clazz, int i, Object obj) {
        boolean z2 = (i & 1) != 0 ? true : z;
        if ((i & 2) != 0) {
            bArr = null;
        }
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        LiveData<Message> liveDataCommand = tWSDeviceBuilder.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilder.getGetCommand(), tWSDeviceBuilder.getNotifyCommand());
        sendMessage$default(tWSDeviceBuilder, z2, bArr, 0, 4, (Object) null);
        Intrinsics.needClassReification();
        LiveData map = Transformations.map(liveDataCommand, new TWSDeviceBuilder$sendMessageWithLiveData$$inlined$parseLiveData$1(tWSDeviceBuilder, clazz));
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "parseLiveData " + clazz + StringUtils.SPACE + map;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return map;
    }

    public final /* synthetic */ <T> LiveData<T> sendMessageWithLiveData(boolean isGetCommand, byte[] payload, Class<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        LiveData<Message> liveDataCommand = getTwsDevice().getCommandCache().getLiveDataCommand(getGetCommand(), getNotifyCommand());
        sendMessage$default(this, isGetCommand, payload, 0, 4, (Object) null);
        Intrinsics.needClassReification();
        LiveData<T> map = Transformations.map(liveDataCommand, new TWSDeviceBuilder$sendMessageWithLiveData$$inlined$parseLiveData$1(this, clazz));
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "parseLiveData " + clazz + StringUtils.SPACE + map;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        return map;
    }

    public final /* synthetic */ <T> LiveData<T> parseLiveData(LiveData<Message> liveData, final Class<T> clazz) {
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.needClassReification();
        return Transformations.map(liveData, new Function1<Message, T>() { // from class: com.nothing.protocol.device.TWSDeviceBuilder.parseLiveData.1
            @Override // kotlin.jvm.functions.Function1
            public final T invoke(Message message) {
                byte[] payload;
                Float f;
                T tNewInstance = null;
                if (message != null && (payload = message.getPayload()) != null) {
                    Class<T> cls = clazz;
                    byte[] bArr = payload;
                    try {
                        if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                            Integer numValueOf = Integer.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null));
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = numValueOf;
                        } else if (Intrinsics.areEqual(cls, Long.TYPE)) {
                            Long lValueOf = Long.valueOf(DataExtKt.toLong$default(bArr, 0, 0, 3, null));
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = lValueOf;
                        } else if (Intrinsics.areEqual(cls, String.class)) {
                            String strDecodeToString = StringsKt.decodeToString(bArr);
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = strDecodeToString;
                        } else if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                            Boolean boolValueOf = Boolean.valueOf(DataExtKt.toInt$default(bArr, 0, 0, 3, null) == 1);
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = boolValueOf;
                        } else if (Intrinsics.areEqual(cls, Float.TYPE)) {
                            Float fValueOf = Float.valueOf(DataExtKt.toFloat$default(bArr, 0, 0, 0, 7, null));
                            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                            f = fValueOf;
                        } else {
                            try {
                                tNewInstance = cls.getConstructor(byte[].class).newInstance(bArr);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            f = tNewInstance;
                        }
                        tNewInstance = (T) f;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                Logger logger = Logger.INSTANCE;
                Class<T> cls2 = clazz;
                Logger logger2 = logger;
                String tag = logger2.getTAG();
                int depth = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    String str = "parseLiveData " + cls2 + StringUtils.SPACE + tNewInstance + StringUtils.SPACE;
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger2.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                return tNewInstance;
            }
        });
    }

    public static /* synthetic */ void sendMessage$default(TWSDeviceBuilder tWSDeviceBuilder, boolean z, byte[] bArr, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr = null;
        }
        tWSDeviceBuilder.sendMessage(z, bArr, (Function1<? super Message, Unit>) function1);
    }

    public final void sendMessage(boolean isGetCommand, byte[] payload, Function1<? super Message, Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        int i = isGetCommand ? this.getCommand : this.setCommand;
        if (i != 0) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass3(i, isGetCommand, payload, action, null), 3, null);
            return;
        }
        Logger logger = Logger.INSTANCE;
        String tag = logger.getTAG();
        int depth = logger.getDepth();
        if (logger.isCanLogger(true)) {
            String str = "ignore sendMessage isGetCommand:" + isGetCommand + " command:0,payload:" + payload;
            String str2 = str;
            if (str2 != null && str2.length() != 0) {
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                }
            }
        }
        action.invoke(null);
    }

    /* JADX INFO: renamed from: com.nothing.protocol.device.TWSDeviceBuilder$sendMessage$3, reason: invalid class name */
    /* JADX INFO: compiled from: TWSDeviceBuilder.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.protocol.device.TWSDeviceBuilder$sendMessage$3", f = "TWSDeviceBuilder.kt", i = {}, l = {269}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Message, Unit> $action;
        final /* synthetic */ int $command;
        final /* synthetic */ boolean $isGetCommand;
        final /* synthetic */ byte[] $payload;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(int i, boolean z, byte[] bArr, Function1<? super Message, Unit> function1, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$command = i;
            this.$isGetCommand = z;
            this.$payload = bArr;
            this.$action = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TWSDeviceBuilder.this.new AnonymousClass3(this.$command, this.$isGetCommand, this.$payload, this.$action, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            byte[] setPayload;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice twsDevice = TWSDeviceBuilder.this.getTwsDevice();
                int i2 = this.$command;
                if (this.$isGetCommand) {
                    setPayload = this.$payload;
                    if (setPayload == null) {
                        setPayload = TWSDeviceBuilder.this.getGetPayload();
                    }
                } else {
                    setPayload = this.$payload;
                    if (setPayload == null) {
                        setPayload = TWSDeviceBuilder.this.getSetPayload();
                    }
                }
                this.label = 1;
                obj = twsDevice.sendMessageSync(i2, setPayload, TWSDeviceBuilder.this.getIgnoreClassicBluetooth(), TWSDeviceBuilder.this.getNeedCache(), TWSDeviceBuilder.this.getTimeOut(), TWSDeviceBuilder.this.getMockResponse(), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            this.$action.invoke((Message) obj);
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ Object sendMessageSync$default(TWSDeviceBuilder tWSDeviceBuilder, boolean z, byte[] bArr, Function1 function1, byte[] bArr2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr = null;
        }
        if ((i & 8) != 0) {
            bArr2 = null;
        }
        return tWSDeviceBuilder.sendMessageSync(z, bArr, function1, bArr2, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object sendMessageSync(boolean z, byte[] bArr, Function1<? super Message, Unit> function1, byte[] bArr2, Continuation<? super Unit> continuation) {
        C10671 c10671;
        if (continuation instanceof C10671) {
            c10671 = (C10671) continuation;
            if ((c10671.label & Integer.MIN_VALUE) != 0) {
                c10671.label -= Integer.MIN_VALUE;
            } else {
                c10671 = new C10671(continuation);
            }
        } else {
            c10671 = new C10671(continuation);
        }
        C10671 c10672 = c10671;
        Object objSendMessageSync = c10672.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c10672.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objSendMessageSync);
            int i2 = z ? this.getCommand : this.setCommand;
            if (i2 == 0) {
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "ignore sendMessage isGetCommand:" + z + " command:0,payload:" + bArr;
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        Pair<String, String> trace = logger.getTrace(depth);
                        String strComponent1 = trace.component1();
                        String strComponent2 = trace.component2();
                        FileLog fileLog = FileLog.INSTANCE;
                        String str3 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                function1.invoke(null);
                return Unit.INSTANCE;
            }
            TWSDevice tWSDevice = this.twsDevice;
            if (z) {
                if (bArr == null) {
                    bArr = this.getPayload;
                }
            } else if (bArr == null) {
                bArr = this.setPayload;
            }
            boolean z2 = this.ignoreClassicBluetooth;
            boolean z3 = this.needCache;
            Long l = this.timeOut;
            byte[] bArr3 = this.mockResponse;
            c10672.L$0 = function1;
            c10672.label = 1;
            objSendMessageSync = tWSDevice.sendMessageSync(i2, bArr, z2, z3, l, bArr3, c10672);
            if (objSendMessageSync == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) c10672.L$0;
            ResultKt.throwOnFailure(objSendMessageSync);
        }
        function1.invoke((Message) objSendMessageSync);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object sendSyncResponse$default(TWSDeviceBuilder tWSDeviceBuilder, boolean z, byte[] bArr, byte[] bArr2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            bArr = null;
        }
        if ((i & 4) != 0) {
            bArr2 = null;
        }
        return tWSDeviceBuilder.sendSyncResponse(z, bArr, bArr2, continuation);
    }

    public final Object sendSyncResponse(boolean z, byte[] bArr, byte[] bArr2, Continuation<? super Message> continuation) {
        int i = z ? this.getCommand : this.setCommand;
        if (i == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (!logger.isCanLogger(true)) {
                return null;
            }
            String str = "ignore sendMessage isGetCommand:" + z + " command:0,payload:" + bArr;
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                return null;
            }
            Pair<String, String> trace = logger.getTrace(depth);
            String strComponent1 = trace.component1();
            String strComponent2 = trace.component2();
            FileLog fileLog = FileLog.INSTANCE;
            String str3 = logger.getSdf().format(new Date());
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
            if (!logger.isDebug()) {
                return null;
            }
            Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
            return null;
        }
        TWSDevice tWSDevice = this.twsDevice;
        if (z) {
            if (bArr == null) {
                bArr = this.getPayload;
            }
        } else if (bArr == null) {
            bArr = this.setPayload;
        }
        return tWSDevice.syncSetResponse(i, bArr, this.timeOut, this.isNeedFsn, this.getSynUpdate, this.mockResponse, continuation);
    }

    public static /* synthetic */ void updateCache$default(TWSDeviceBuilder tWSDeviceBuilder, byte[] bArr, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        tWSDeviceBuilder.updateCache(bArr, z, z2);
    }

    public final void updateCache(byte[] payload, boolean isGetCommand, boolean isUpdate) {
        int i = isGetCommand ? this.getCommand : this.setCommand;
        if (i == 0) {
            Logger logger = Logger.INSTANCE;
            String tag = logger.getTAG();
            int depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                String str = "ignore updateCache isGetCommand:" + isGetCommand + " command:0,payload:" + payload;
                String str2 = str;
                if (str2 == null || str2.length() == 0) {
                    return;
                }
                Pair<String, String> trace = logger.getTrace(depth);
                String strComponent1 = trace.component1();
                String strComponent2 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str3 = logger.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                FileLog.print$default(fileLog, 4, str3, tag, str + StringUtils.SPACE + strComponent2, null, 16, null);
                if (logger.isDebug()) {
                    Log.i(tag + strComponent1, str + StringUtils.SPACE + strComponent2);
                    return;
                }
                return;
            }
            return;
        }
        this.twsDevice.setCacheCommandsManualPayload(i, payload);
        if (isUpdate) {
            this.twsDevice.updateFromCache(i);
        }
    }
}
