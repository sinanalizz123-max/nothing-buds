package com.nothing.earbase.equalizer.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.BasicBoolean;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.core.entity.AdvanceCustomEQEntity;
import com.nothing.core.ext.TWSDeviceExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.BaseAndroidLifecycleViewModel;
import com.nothing.device.IOTProductDevice;
import com.nothing.log.FileLog;
import com.nothing.nt_ear.NtEarPlugin;
import com.nothing.protocol.device.TWSCommandCache;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.device.TWSDeviceBuilder;
import com.nothing.protocol.model.Message;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import java.util.Arrays;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: BaseEQViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010\u0016\u001a\u00020\u0015H\u0086@\u00a2\u0006\u0002\u0010\u0017J\u0006\u0010\u0018\u001a\u00020\u0015R$\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR$\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\n\"\u0004\b\u0013\u0010\f\u00a8\u0006\u0019"}, d2 = {"Lcom/nothing/earbase/equalizer/viewmodel/BaseEQViewModel;", "Lcom/nothing/device/BaseAndroidLifecycleViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "advanceCustomEQLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/nothing/core/entity/AdvanceCustomEQEntity;", "getAdvanceCustomEQLiveData", "()Landroidx/lifecycle/LiveData;", "setAdvanceCustomEQLiveData", "(Landroidx/lifecycle/LiveData;)V", "spatialAudioLiveData", "Lcom/nothing/base/protocol/entity/BasicBoolean;", "getSpatialAudioLiveData", "setSpatialAudioLiveData", "earMutuallyExclusiveLiveData", "getEarMutuallyExclusiveLiveData", "setEarMutuallyExclusiveLiveData", "getConfig", "", "checkConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setSpatialAudioOff", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BaseEQViewModel extends BaseAndroidLifecycleViewModel {
    private LiveData<AdvanceCustomEQEntity> advanceCustomEQLiveData;
    private LiveData<BasicBoolean> earMutuallyExclusiveLiveData;
    private LiveData<BasicBoolean> spatialAudioLiveData;

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$checkConfig$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseEQViewModel.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel", f = "BaseEQViewModel.kt", i = {0, 0, 1}, l = {55, 62}, m = "checkConfig", n = {"this", "$this$checkConfig_u24lambda_u245", "this"}, s = {"L$0", "L$2", "L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BaseEQViewModel.this.checkConfig(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseEQViewModel(Application application) {
        LiveData<AdvanceCustomEQEntity> map;
        TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQMode$default;
        final TWSDeviceBuilder tWSDeviceBuilderAdvanceCustomEQMode$default2;
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        getConfig();
        TWSDevice tWSDevice = getTWSDevice();
        if (tWSDevice == null || (tWSDeviceBuilderAdvanceCustomEQMode$default2 = TWSDeviceExtKt.advanceCustomEQMode$default(tWSDevice, null, 1, null)) == null) {
            map = null;
        } else {
            final Class<AdvanceCustomEQEntity> cls = AdvanceCustomEQEntity.class;
            map = Transformations.map(tWSDeviceBuilderAdvanceCustomEQMode$default2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderAdvanceCustomEQMode$default2.getGetCommand(), tWSDeviceBuilderAdvanceCustomEQMode$default2.getNotifyCommand()), new Function1<Message, AdvanceCustomEQEntity>() { // from class: com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$special$$inlined$getLiveData$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final AdvanceCustomEQEntity invoke(Message message) {
                    byte[] payload;
                    Object obj;
                    AdvanceCustomEQEntity advanceCustomEQEntity = 0;
                    Object obj2 = null;
                    objNewInstance = null;
                    Object objNewInstance = null;
                    advanceCustomEQEntity = 0;
                    if (message != null && (payload = message.getPayload()) != null) {
                        Class cls2 = cls;
                        try {
                            if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                            } else if (Intrinsics.areEqual(cls2, String.class)) {
                                Object objDecodeToString = StringsKt.decodeToString(payload);
                                if (objDecodeToString == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type com.nothing.core.entity.AdvanceCustomEQEntity");
                                }
                                obj = (AdvanceCustomEQEntity) objDecodeToString;
                            } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                            } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                obj = (AdvanceCustomEQEntity) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                            } else {
                                try {
                                    objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                    obj2 = objNewInstance;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                obj = obj2;
                            }
                            advanceCustomEQEntity = obj;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            advanceCustomEQEntity = objNewInstance;
                        }
                    }
                    Logger logger = Logger.INSTANCE;
                    Class cls3 = cls;
                    Logger logger2 = logger;
                    String tag = logger2.getTAG();
                    int depth = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        String str = "parseLiveData " + cls3 + StringUtils.SPACE + advanceCustomEQEntity + StringUtils.SPACE;
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
                    return advanceCustomEQEntity;
                }
            });
        }
        this.advanceCustomEQLiveData = map;
        TWSDevice tWSDevice2 = getTWSDevice();
        if (tWSDevice2 == null || (tWSDeviceBuilderAdvanceCustomEQMode$default = TWSDeviceExtKt.advanceCustomEQMode$default(tWSDevice2, null, 1, null)) == null) {
            return;
        }
        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderAdvanceCustomEQMode$default, false, (byte[]) null, 0, 7, (Object) null);
    }

    public final LiveData<AdvanceCustomEQEntity> getAdvanceCustomEQLiveData() {
        return this.advanceCustomEQLiveData;
    }

    public final void setAdvanceCustomEQLiveData(LiveData<AdvanceCustomEQEntity> liveData) {
        this.advanceCustomEQLiveData = liveData;
    }

    public final LiveData<BasicBoolean> getSpatialAudioLiveData() {
        return this.spatialAudioLiveData;
    }

    public final void setSpatialAudioLiveData(LiveData<BasicBoolean> liveData) {
        this.spatialAudioLiveData = liveData;
    }

    public final LiveData<BasicBoolean> getEarMutuallyExclusiveLiveData() {
        return this.earMutuallyExclusiveLiveData;
    }

    public final void setEarMutuallyExclusiveLiveData(LiveData<BasicBoolean> liveData) {
        this.earMutuallyExclusiveLiveData = liveData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.lifecycle.LiveData<com.nothing.base.protocol.entity.BasicBoolean>] */
    private final void getConfig() {
        LiveData<BasicBoolean> map;
        BasicBoolean value;
        ?? map2;
        TWSDeviceBuilder tWSDeviceBuilderMutuallyExclusive;
        final TWSDeviceBuilder tWSDeviceBuilderMutuallyExclusive2;
        final TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default;
        IOTProductDevice productDevice = getProductDevice();
        if (productDevice != null) {
            if (productDevice.eqMutuallyExclusive() || productDevice.spaceEqExclusive()) {
                TWSDevice tWSDevice = getTWSDevice();
                if (tWSDevice == null || (tWSDeviceBuilderSpatialAudio$default = TWSDeviceExtKt.spatialAudio$default(tWSDevice, null, null, 3, null)) == null) {
                    map = null;
                } else {
                    final Class<BasicBoolean> cls = BasicBoolean.class;
                    map = Transformations.map(tWSDeviceBuilderSpatialAudio$default.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderSpatialAudio$default.getGetCommand(), tWSDeviceBuilderSpatialAudio$default.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$getConfig$lambda$2$$inlined$getLiveData$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // kotlin.jvm.functions.Function1
                        public final BasicBoolean invoke(Message message) {
                            byte[] payload;
                            Object obj;
                            BasicBoolean basicBoolean = 0;
                            Object obj2 = null;
                            objNewInstance = null;
                            Object objNewInstance = null;
                            basicBoolean = 0;
                            if (message != null && (payload = message.getPayload()) != null) {
                                Class cls2 = cls;
                                try {
                                    if (Intrinsics.areEqual(cls2, Integer.TYPE)) {
                                        obj = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                                    } else if (Intrinsics.areEqual(cls2, Long.TYPE)) {
                                        obj = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                                    } else if (Intrinsics.areEqual(cls2, String.class)) {
                                        Object objDecodeToString = StringsKt.decodeToString(payload);
                                        if (objDecodeToString == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                        }
                                        obj = (BasicBoolean) objDecodeToString;
                                    } else if (Intrinsics.areEqual(cls2, Boolean.TYPE)) {
                                        obj = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                                    } else if (Intrinsics.areEqual(cls2, Float.TYPE)) {
                                        obj = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                                    } else {
                                        try {
                                            objNewInstance = cls2.getConstructor(byte[].class).newInstance(payload);
                                            obj2 = objNewInstance;
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        obj = obj2;
                                    }
                                    basicBoolean = obj;
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                    basicBoolean = objNewInstance;
                                }
                            }
                            Logger logger = Logger.INSTANCE;
                            Class cls3 = cls;
                            Logger logger2 = logger;
                            String tag = logger2.getTAG();
                            int depth = logger2.getDepth();
                            if (logger2.isCanLogger(true)) {
                                String str = "parseLiveData " + cls3 + StringUtils.SPACE + basicBoolean + StringUtils.SPACE;
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
                            return basicBoolean;
                        }
                    });
                }
                this.spatialAudioLiveData = map;
                Logger logger = Logger.INSTANCE;
                String tag = logger.getTAG();
                int depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    String str = "base_eq spatialAudioLiveData is null:" + (this.spatialAudioLiveData == null);
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
                TWSDevice tWSDevice2 = getTWSDevice();
                if (tWSDevice2 != null) {
                    value = null;
                    TWSDeviceBuilder tWSDeviceBuilderSpatialAudio$default2 = TWSDeviceExtKt.spatialAudio$default(tWSDevice2, null, null, 3, null);
                    if (tWSDeviceBuilderSpatialAudio$default2 != null) {
                        TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderSpatialAudio$default2, false, (byte[]) null, 0, 7, (Object) null);
                    }
                } else {
                    value = null;
                }
                if (productDevice.spaceEqExclusive()) {
                    TWSDevice tWSDevice3 = getTWSDevice();
                    if (tWSDevice3 == null || (tWSDeviceBuilderMutuallyExclusive2 = TWSDeviceExtKt.mutuallyExclusive(tWSDevice3)) == null) {
                        map2 = value;
                    } else {
                        final Class<BasicBoolean> cls2 = BasicBoolean.class;
                        map2 = Transformations.map(tWSDeviceBuilderMutuallyExclusive2.getTwsDevice().getCommandCache().getLiveDataCommand(tWSDeviceBuilderMutuallyExclusive2.getGetCommand(), tWSDeviceBuilderMutuallyExclusive2.getNotifyCommand()), new Function1<Message, BasicBoolean>() { // from class: com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$getConfig$lambda$2$$inlined$getLiveData$2
                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final BasicBoolean invoke(Message message) {
                                byte[] payload;
                                Object obj;
                                BasicBoolean basicBoolean = 0;
                                Object obj2 = null;
                                objNewInstance = null;
                                Object objNewInstance = null;
                                basicBoolean = 0;
                                if (message != null && (payload = message.getPayload()) != null) {
                                    Class cls3 = cls2;
                                    try {
                                        if (Intrinsics.areEqual(cls3, Integer.TYPE)) {
                                            obj = (BasicBoolean) Integer.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null));
                                        } else if (Intrinsics.areEqual(cls3, Long.TYPE)) {
                                            obj = (BasicBoolean) Long.valueOf(DataExtKt.toLong$default(payload, 0, 0, 3, null));
                                        } else if (Intrinsics.areEqual(cls3, String.class)) {
                                            Object objDecodeToString = StringsKt.decodeToString(payload);
                                            if (objDecodeToString == null) {
                                                throw new NullPointerException("null cannot be cast to non-null type com.nothing.base.protocol.entity.BasicBoolean");
                                            }
                                            obj = (BasicBoolean) objDecodeToString;
                                        } else if (Intrinsics.areEqual(cls3, Boolean.TYPE)) {
                                            obj = (BasicBoolean) Boolean.valueOf(DataExtKt.toInt$default(payload, 0, 0, 3, null) == 1);
                                        } else if (Intrinsics.areEqual(cls3, Float.TYPE)) {
                                            obj = (BasicBoolean) Float.valueOf(DataExtKt.toFloat$default(payload, 0, 0, 0, 7, null));
                                        } else {
                                            try {
                                                objNewInstance = cls3.getConstructor(byte[].class).newInstance(payload);
                                                obj2 = objNewInstance;
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                            obj = obj2;
                                        }
                                        basicBoolean = obj;
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                        basicBoolean = objNewInstance;
                                    }
                                }
                                Logger logger2 = Logger.INSTANCE;
                                Class cls4 = cls2;
                                Logger logger3 = logger2;
                                String tag2 = logger3.getTAG();
                                int depth2 = logger3.getDepth();
                                if (logger3.isCanLogger(true)) {
                                    String str4 = "parseLiveData " + cls4 + StringUtils.SPACE + basicBoolean + StringUtils.SPACE;
                                    String str5 = str4;
                                    if (str5 != null && str5.length() != 0) {
                                        Pair<String, String> trace2 = logger3.getTrace(depth2);
                                        String strComponent3 = trace2.component1();
                                        String strComponent4 = trace2.component2();
                                        FileLog fileLog2 = FileLog.INSTANCE;
                                        String str6 = logger3.getSdf().format(new Date());
                                        Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                        FileLog.print$default(fileLog2, 4, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                                        if (logger3.isDebug()) {
                                            Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                                        }
                                    }
                                }
                                return basicBoolean;
                            }
                        });
                    }
                    this.earMutuallyExclusiveLiveData = map2;
                    Logger logger2 = Logger.INSTANCE;
                    String tag2 = logger2.getTAG();
                    int depth2 = logger2.getDepth();
                    if (logger2.isCanLogger(true)) {
                        LiveData<BasicBoolean> liveData = this.earMutuallyExclusiveLiveData;
                        if (liveData != null) {
                            value = liveData.getValue();
                        }
                        String str4 = "base_eq earMutuallyExclusiveLiveData is :" + value;
                        String str5 = str4;
                        if (str5 != null && str5.length() != 0) {
                            Pair<String, String> trace2 = logger2.getTrace(depth2);
                            String strComponent3 = trace2.component1();
                            String strComponent4 = trace2.component2();
                            FileLog fileLog2 = FileLog.INSTANCE;
                            String str6 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                            FileLog.print$default(fileLog2, 3, str6, tag2, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.i(tag2 + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                            }
                        }
                    }
                    TWSDevice tWSDevice4 = getTWSDevice();
                    if (tWSDevice4 == null || (tWSDeviceBuilderMutuallyExclusive = TWSDeviceExtKt.mutuallyExclusive(tWSDevice4)) == null) {
                        return;
                    }
                    TWSDeviceBuilder.sendMessage$default(tWSDeviceBuilderMutuallyExclusive, false, (byte[]) null, 0, 7, (Object) null);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x025a  */
    /* JADX WARN: Code duplicated, block: B:103:0x026f  */
    /* JADX WARN: Code duplicated, block: B:108:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:52:0x0108  */
    /* JADX WARN: Code duplicated, block: B:57:0x011d  */
    /* JADX WARN: Code duplicated, block: B:63:0x0133  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:76:0x01da  */
    /* JADX WARN: Code duplicated, block: B:79:0x0203  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Code duplicated, block: B:81:0x020a  */
    /* JADX WARN: Code duplicated, block: B:83:0x0210  */
    /* JADX WARN: Code duplicated, block: B:85:0x0214  */
    /* JADX WARN: Code duplicated, block: B:89:0x0226  */
    /* JADX WARN: Code duplicated, block: B:90:0x022b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0245  */
    /* JADX WARN: Code duplicated, block: B:97:0x0249  */
    public final Object checkConfig(Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        IOTProductDevice productDevice;
        String str;
        boolean z;
        BaseEQViewModel baseEQViewModel;
        IOTProductDevice iOTProductDevice;
        Message message;
        BaseEQViewModel baseEQViewModel2;
        IOTProductDevice iOTProductDevice2;
        TWSDevice tWSDevice;
        Boolean bool;
        Message message2;
        BaseEQViewModel baseEQViewModel3;
        Object objSendMessageSync$default;
        BaseEQViewModel baseEQViewModel4;
        LiveData<BasicBoolean> liveData;
        LiveData<BasicBoolean> liveData2;
        Logger logger;
        String tag;
        int depth;
        LiveData<BasicBoolean> liveData3;
        Boolean boolBoxBoolean;
        LiveData<BasicBoolean> liveData4;
        Boolean boolBoxBoolean2;
        String str2;
        String str3;
        String strComponent1;
        String strComponent2;
        BasicBoolean value;
        BasicBoolean value2;
        BasicBoolean value3;
        BasicBoolean basicBoolean;
        boolean open;
        BasicBoolean value4;
        BasicBoolean basicBoolean2;
        boolean head;
        LiveData<BasicBoolean> liveData5;
        Logger logger2;
        String tag2;
        int depth2;
        LiveData<BasicBoolean> liveData6;
        Boolean boolBoxBoolean3;
        String str4;
        String str5;
        String strComponent3;
        String strComponent4;
        BasicBoolean value5;
        BasicBoolean value6;
        BasicBoolean basicBoolean3;
        boolean open2;
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
        Object obj = anonymousClass2.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass2.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            productDevice = getProductDevice();
            if (productDevice != null && (productDevice.eqMutuallyExclusive() || productDevice.spaceEqExclusive())) {
                TWSDevice tWSDevice2 = getTWSDevice();
                if (tWSDevice2 != null) {
                    anonymousClass2.L$0 = this;
                    anonymousClass2.L$1 = productDevice;
                    anonymousClass2.L$2 = productDevice;
                    anonymousClass2.label = 1;
                    str = StringUtils.SPACE;
                    z = true;
                    Object objSendMessageSync$default2 = TWSDevice.sendMessageSync$default(tWSDevice2, ProtocolConstant.Query.GET_SPATIAL_AUDIO, null, false, false, null, null, anonymousClass2, 62, null);
                    if (objSendMessageSync$default2 != coroutine_suspended) {
                        baseEQViewModel2 = this;
                        iOTProductDevice2 = productDevice;
                        obj = objSendMessageSync$default2;
                        iOTProductDevice = iOTProductDevice2;
                    }
                } else {
                    str = StringUtils.SPACE;
                    z = true;
                    baseEQViewModel = this;
                    iOTProductDevice = productDevice;
                    message = null;
                    if (message != null) {
                        liveData = baseEQViewModel.spatialAudioLiveData;
                        if (liveData != null && (value4 = liveData.getValue()) != null) {
                            basicBoolean2 = (BasicBoolean) message.obtainPayload(BasicBoolean.class);
                            if (basicBoolean2 != null) {
                                head = basicBoolean2.getHead();
                            } else {
                                head = false;
                            }
                            value4.setHead(head);
                        }
                        liveData2 = baseEQViewModel.spatialAudioLiveData;
                        if (liveData2 != null && (value3 = liveData2.getValue()) != null) {
                            basicBoolean = (BasicBoolean) message.obtainPayload(BasicBoolean.class);
                            if (basicBoolean != null) {
                                open = basicBoolean.getOpen();
                            } else {
                                open = false;
                            }
                            value3.setOpen(open);
                        }
                        Logger logger3 = Logger.INSTANCE;
                        Logger logger4 = Logger.INSTANCE;
                        logger = logger3;
                        tag = logger.getTAG();
                        depth = logger.getDepth();
                        if (logger.isCanLogger(z)) {
                            liveData3 = baseEQViewModel.spatialAudioLiveData;
                            if (liveData3 != null || (value2 = liveData3.getValue()) == null) {
                                boolBoxBoolean = null;
                            } else {
                                boolBoxBoolean = Boxing.boxBoolean(value2.getHead());
                            }
                            liveData4 = baseEQViewModel.spatialAudioLiveData;
                            if (liveData4 != null || (value = liveData4.getValue()) == null) {
                                boolBoxBoolean2 = null;
                            } else {
                                boolBoxBoolean2 = Boxing.boxBoolean(value.getOpen());
                            }
                            str2 = "Test_check checkConfig spatialAudioLiveData:" + boolBoxBoolean + "," + boolBoxBoolean2;
                            str3 = str2;
                            if (str3 != null && str3.length() != 0) {
                                Pair<String, String> trace = logger.getTrace(depth);
                                strComponent1 = trace.component1();
                                strComponent2 = trace.component2();
                                FileLog fileLog = FileLog.INSTANCE;
                                String str6 = logger.getSdf().format(new Date());
                                Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                                FileLog.print$default(fileLog, 3, str6, tag, str2 + str + strComponent2, null, 16, null);
                                if (logger.isDebug()) {
                                    Log.i(tag + strComponent1, str2 + str + strComponent2);
                                }
                            }
                        }
                    }
                    if (iOTProductDevice.spaceEqExclusive()) {
                        tWSDevice = baseEQViewModel.getTWSDevice();
                        if (tWSDevice != null) {
                            Long lBoxLong = Boxing.boxLong(300L);
                            anonymousClass2.L$0 = baseEQViewModel;
                            anonymousClass2.L$1 = productDevice;
                            bool = null;
                            anonymousClass2.L$2 = null;
                            anonymousClass2.label = 2;
                            baseEQViewModel3 = baseEQViewModel;
                            objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_MUTUALLY_EXCLUSIVE, null, false, false, lBoxLong, null, anonymousClass2, 46, null);
                            if (objSendMessageSync$default != coroutine_suspended) {
                                baseEQViewModel4 = baseEQViewModel3;
                                message2 = (Message) objSendMessageSync$default;
                                baseEQViewModel = baseEQViewModel4;
                            }
                        } else {
                            bool = null;
                            message2 = null;
                        }
                        if (message2 != null) {
                            liveData5 = baseEQViewModel.earMutuallyExclusiveLiveData;
                            if (liveData5 != null) {
                                basicBoolean3 = (BasicBoolean) message2.obtainPayload(BasicBoolean.class);
                                if (basicBoolean3 != null) {
                                    open2 = basicBoolean3.getOpen();
                                } else {
                                    open2 = false;
                                }
                                value6.setOpen(open2);
                            }
                            Logger logger5 = Logger.INSTANCE;
                            Logger logger6 = Logger.INSTANCE;
                            logger2 = logger5;
                            tag2 = logger2.getTAG();
                            depth2 = logger2.getDepth();
                            if (logger2.isCanLogger(z)) {
                                liveData6 = baseEQViewModel.earMutuallyExclusiveLiveData;
                                if (liveData6 != null) {
                                    boolBoxBoolean3 = bool;
                                } else {
                                    boolBoxBoolean3 = bool;
                                }
                                str4 = "Test_check checkConfig earMutuallyExclusiveLiveData:" + boolBoxBoolean3;
                                str5 = str4;
                                if (str5 != null) {
                                    Pair<String, String> trace2 = logger2.getTrace(depth2);
                                    strComponent3 = trace2.component1();
                                    strComponent4 = trace2.component2();
                                    FileLog fileLog2 = FileLog.INSTANCE;
                                    String str7 = logger2.getSdf().format(new Date());
                                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                                    FileLog.print$default(fileLog2, 3, str7, tag2, str4 + str + strComponent4, null, 16, null);
                                    if (logger2.isDebug()) {
                                        Log.i(tag2 + strComponent3, str4 + str + strComponent4);
                                    }
                                }
                            }
                        }
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        if (i == 1) {
            iOTProductDevice = (IOTProductDevice) anonymousClass2.L$2;
            iOTProductDevice2 = (IOTProductDevice) anonymousClass2.L$1;
            baseEQViewModel2 = (BaseEQViewModel) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            str = StringUtils.SPACE;
            z = true;
        } else {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            baseEQViewModel4 = (BaseEQViewModel) anonymousClass2.L$0;
            ResultKt.throwOnFailure(obj);
            objSendMessageSync$default = obj;
            str = StringUtils.SPACE;
            z = true;
            bool = null;
        }
        message2 = (Message) objSendMessageSync$default;
        baseEQViewModel = baseEQViewModel4;
        if (message2 != null) {
            liveData5 = baseEQViewModel.earMutuallyExclusiveLiveData;
            if (liveData5 != null && (value6 = liveData5.getValue()) != null) {
                basicBoolean3 = (BasicBoolean) message2.obtainPayload(BasicBoolean.class);
                if (basicBoolean3 != null) {
                    open2 = basicBoolean3.getOpen();
                } else {
                    open2 = false;
                }
                value6.setOpen(open2);
            }
            Logger logger7 = Logger.INSTANCE;
            Logger logger8 = Logger.INSTANCE;
            logger2 = logger7;
            tag2 = logger2.getTAG();
            depth2 = logger2.getDepth();
            if (logger2.isCanLogger(z)) {
                liveData6 = baseEQViewModel.earMutuallyExclusiveLiveData;
                if (liveData6 != null || (value5 = liveData6.getValue()) == null) {
                    boolBoxBoolean3 = bool;
                } else {
                    boolBoxBoolean3 = Boxing.boxBoolean(value5.getOpen());
                }
                str4 = "Test_check checkConfig earMutuallyExclusiveLiveData:" + boolBoxBoolean3;
                str5 = str4;
                if (str5 != null && str5.length() != 0) {
                    Pair<String, String> trace3 = logger2.getTrace(depth2);
                    strComponent3 = trace3.component1();
                    strComponent4 = trace3.component2();
                    FileLog fileLog3 = FileLog.INSTANCE;
                    String str8 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    FileLog.print$default(fileLog3, 3, str8, tag2, str4 + str + strComponent4, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent3, str4 + str + strComponent4);
                    }
                }
            }
        }
        return Unit.INSTANCE;
        message = (Message) obj;
        productDevice = iOTProductDevice2;
        baseEQViewModel = baseEQViewModel2;
        if (message != null) {
            liveData = baseEQViewModel.spatialAudioLiveData;
            if (liveData != null) {
                basicBoolean2 = (BasicBoolean) message.obtainPayload(BasicBoolean.class);
                if (basicBoolean2 != null) {
                    head = basicBoolean2.getHead();
                } else {
                    head = false;
                }
                value4.setHead(head);
            }
            liveData2 = baseEQViewModel.spatialAudioLiveData;
            if (liveData2 != null) {
                basicBoolean = (BasicBoolean) message.obtainPayload(BasicBoolean.class);
                if (basicBoolean != null) {
                    open = basicBoolean.getOpen();
                } else {
                    open = false;
                }
                value3.setOpen(open);
            }
            Logger logger9 = Logger.INSTANCE;
            Logger logger10 = Logger.INSTANCE;
            logger = logger9;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(z)) {
                liveData3 = baseEQViewModel.spatialAudioLiveData;
                if (liveData3 != null) {
                    boolBoxBoolean = null;
                } else {
                    boolBoxBoolean = null;
                }
                liveData4 = baseEQViewModel.spatialAudioLiveData;
                if (liveData4 != null) {
                    boolBoxBoolean2 = null;
                } else {
                    boolBoxBoolean2 = null;
                }
                str2 = "Test_check checkConfig spatialAudioLiveData:" + boolBoxBoolean + "," + boolBoxBoolean2;
                str3 = str2;
                if (str3 != null) {
                    Pair<String, String> trace4 = logger.getTrace(depth);
                    strComponent1 = trace4.component1();
                    strComponent2 = trace4.component2();
                    FileLog fileLog4 = FileLog.INSTANCE;
                    String str9 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                    FileLog.print$default(fileLog4, 3, str9, tag, str2 + str + strComponent2, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent1, str2 + str + strComponent2);
                    }
                }
            }
        }
        if (iOTProductDevice.spaceEqExclusive()) {
            tWSDevice = baseEQViewModel.getTWSDevice();
            if (tWSDevice != null) {
                Long lBoxLong2 = Boxing.boxLong(300L);
                anonymousClass2.L$0 = baseEQViewModel;
                anonymousClass2.L$1 = productDevice;
                bool = null;
                anonymousClass2.L$2 = null;
                anonymousClass2.label = 2;
                baseEQViewModel3 = baseEQViewModel;
                objSendMessageSync$default = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_MUTUALLY_EXCLUSIVE, null, false, false, lBoxLong2, null, anonymousClass2, 46, null);
                if (objSendMessageSync$default != coroutine_suspended) {
                    baseEQViewModel4 = baseEQViewModel3;
                    message2 = (Message) objSendMessageSync$default;
                    baseEQViewModel = baseEQViewModel4;
                }
                return coroutine_suspended;
            }
            bool = null;
            message2 = null;
            if (message2 != null) {
                liveData5 = baseEQViewModel.earMutuallyExclusiveLiveData;
                if (liveData5 != null) {
                    basicBoolean3 = (BasicBoolean) message2.obtainPayload(BasicBoolean.class);
                    if (basicBoolean3 != null) {
                        open2 = basicBoolean3.getOpen();
                    } else {
                        open2 = false;
                    }
                    value6.setOpen(open2);
                }
                Logger logger11 = Logger.INSTANCE;
                Logger logger12 = Logger.INSTANCE;
                logger2 = logger11;
                tag2 = logger2.getTAG();
                depth2 = logger2.getDepth();
                if (logger2.isCanLogger(z)) {
                    liveData6 = baseEQViewModel.earMutuallyExclusiveLiveData;
                    if (liveData6 != null) {
                        boolBoxBoolean3 = bool;
                    } else {
                        boolBoxBoolean3 = bool;
                    }
                    str4 = "Test_check checkConfig earMutuallyExclusiveLiveData:" + boolBoxBoolean3;
                    str5 = str4;
                    if (str5 != null) {
                        Pair<String, String> trace5 = logger2.getTrace(depth2);
                        strComponent3 = trace5.component1();
                        strComponent4 = trace5.component2();
                        FileLog fileLog5 = FileLog.INSTANCE;
                        String str10 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                        FileLog.print$default(fileLog5, 3, str10, tag2, str4 + str + strComponent4, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent3, str4 + str + strComponent4);
                        }
                    }
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$setSpatialAudioOff$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseEQViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$setSpatialAudioOff$1", f = "BaseEQViewModel.kt", i = {1}, l = {75, 101}, m = "invokeSuspend", n = {"needUpdate$iv"}, s = {"I$0"})
    static final class C06731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;

        C06731(Continuation<? super C06731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseEQViewModel.this.new C06731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00ed  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel.C06731.C01351(r17.this$0, null), r17) == r1) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            TWSDeviceBuilder tWSDeviceBuilderSpatialAudio;
            Object objSyncSetResponse$default;
            int i;
            Message message;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                if (SpUtils.INSTANCE.getPhoneSupportSpatial() == 1) {
                    this.label = 1;
                } else {
                    TWSDevice tWSDevice = BaseEQViewModel.this.getTWSDevice();
                    if (tWSDevice != null && (tWSDeviceBuilderSpatialAudio = TWSDeviceExtKt.spatialAudio(tWSDevice, Boxing.boxBoolean(false), Boxing.boxBoolean(false))) != null) {
                        int setCommand = tWSDeviceBuilderSpatialAudio.getSetCommand();
                        this.L$0 = tWSDeviceBuilderSpatialAudio;
                        this.I$0 = 1;
                        this.label = 2;
                        objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDeviceBuilderSpatialAudio.getTwsDevice(), setCommand, tWSDeviceBuilderSpatialAudio.getSetPayload(), tWSDeviceBuilderSpatialAudio.getTimeOut(), tWSDeviceBuilderSpatialAudio.getIsNeedFsn(), false, tWSDeviceBuilderSpatialAudio.getMockResponse(), this, 16, null);
                        if (objSyncSetResponse$default != coroutine_suspended) {
                            i = 1;
                            message = (Message) objSyncSetResponse$default;
                            if (message == null) {
                                Boxing.boxBoolean(false);
                            } else {
                                Boxing.boxBoolean(false);
                            }
                        }
                        return coroutine_suspended;
                    }
                }
            } else if (i2 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i = this.I$0;
                tWSDeviceBuilderSpatialAudio = (TWSDeviceBuilder) this.L$0;
                ResultKt.throwOnFailure(obj);
                objSyncSetResponse$default = obj;
                message = (Message) objSyncSetResponse$default;
                if (message == null && message.isOk()) {
                    LiveData liveDataCommand$default = TWSCommandCache.getLiveDataCommand$default(tWSDeviceBuilderSpatialAudio.getTwsDevice().getCommandCache(), tWSDeviceBuilderSpatialAudio.getGetCommand(), 0, 2, null);
                    byte[] bArrObtainDataPacket = BasicBoolean.INSTANCE.obtainDataPacket(false, Boxing.boxBoolean(false));
                    Message message2 = (Message) liveDataCommand$default.getValue();
                    if (!Arrays.equals(message2 != null ? message2.getPayload() : null, bArrObtainDataPacket)) {
                        tWSDeviceBuilderSpatialAudio.getTwsDevice().setCacheCommandsManualPayload(tWSDeviceBuilderSpatialAudio.getGetCommand(), bArrObtainDataPacket);
                        if (message2 != null) {
                            message2.setPayload(bArrObtainDataPacket);
                            if (i != 0) {
                                tWSDeviceBuilderSpatialAudio.getTwsDevice().onUpdate(tWSDeviceBuilderSpatialAudio.getGetCommand(), message2);
                            }
                        }
                    }
                    Boxing.boxBoolean(true);
                } else {
                    Boxing.boxBoolean(false);
                }
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$setSpatialAudioOff$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseEQViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$setSpatialAudioOff$1$1", f = "BaseEQViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ BaseEQViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01351(BaseEQViewModel baseEQViewModel, Continuation<? super C01351> continuation) {
                super(2, continuation);
                this.this$0 = baseEQViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01351(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                String address;
                BasicBoolean value;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                FlutterEngine flutterEngine = FlutterEngineCache.getInstance().get("main");
                if (flutterEngine != null) {
                    FlutterPlugin flutterPlugin = flutterEngine.getPlugins().get(NtEarPlugin.class);
                    LiveData<BasicBoolean> spatialAudioLiveData = this.this$0.getSpatialAudioLiveData();
                    long j = (spatialAudioLiveData == null || (value = spatialAudioLiveData.getValue()) == null || !value.getHead()) ? 1L : 2L;
                    if (flutterPlugin instanceof NtEarPlugin) {
                        NtEarPlugin ntEarPlugin = (NtEarPlugin) flutterPlugin;
                        TWSDevice tWSDevice = this.this$0.getTWSDevice();
                        if (tWSDevice == null || (address = tWSDevice.getAddress()) == null) {
                            address = "";
                        }
                        ntEarPlugin.setPhoneSpatialAudio(address, 0L, j, new Function1() { // from class: com.nothing.earbase.equalizer.viewmodel.BaseEQViewModel$setSpatialAudioOff$1$1$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj2) {
                                return BaseEQViewModel.C06731.C01351.invokeSuspend$lambda$0((Result) obj2);
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final Unit invokeSuspend$lambda$0(Result result) {
                return Unit.INSTANCE;
            }
        }
    }

    public final void setSpatialAudioOff() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C06731(null), 3, null);
    }
}
