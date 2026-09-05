package com.nothing.ear.one.base;

import android.util.Log;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.router.device.DeviceColor;
import com.nothing.base.util.Logger;
import com.nothing.broadcase.util.BleBroadcastParseUtil;
import com.nothing.earbase.os.cache.MacCacheManager;
import com.nothing.earbase.ota.entity.DeviceColorEntity;
import com.nothing.earbase.ota.entity.DeviceModelEntity;
import com.nothing.log.FileLog;
import com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: EarOneUnknownDevice.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.ear.one.base.EarOneUnknownDevice$getModelIdByTws$2$2", f = "EarOneUnknownDevice.kt", i = {0, 0, 1, 1, 1}, l = {62, UltraBassComponents.BASS_BOOST_LEVEL4_PROGRESS, 91}, m = "invokeSuspend", n = {"$this$launch", "modelId", "$this$launch", "modelId", "colorHex"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
final class EarOneUnknownDevice$getModelIdByTws$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TWSDevice $this_run;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ EarOneUnknownDevice this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EarOneUnknownDevice$getModelIdByTws$2$2(TWSDevice tWSDevice, EarOneUnknownDevice earOneUnknownDevice, Continuation<? super EarOneUnknownDevice$getModelIdByTws$2$2> continuation) {
        super(2, continuation);
        this.$this_run = tWSDevice;
        this.this$0 = earOneUnknownDevice;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        EarOneUnknownDevice$getModelIdByTws$2$2 earOneUnknownDevice$getModelIdByTws$2$2 = new EarOneUnknownDevice$getModelIdByTws$2$2(this.$this_run, this.this$0, continuation);
        earOneUnknownDevice$getModelIdByTws$2$2.L$0 = obj;
        return earOneUnknownDevice$getModelIdByTws$2$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EarOneUnknownDevice$getModelIdByTws$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0464  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x014e  */
    /* JADX WARN: Code duplicated, block: B:74:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:77:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:79:0x030b  */
    /* JADX WARN: Code duplicated, block: B:82:0x0319  */
    /* JADX WARN: Code duplicated, block: B:86:0x0348  */
    /* JADX WARN: Code duplicated, block: B:93:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:97:0x03fd  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope;
        Ref.ObjectRef objectRef;
        Object objSyncSetResponse$default;
        Ref.ObjectRef objectRef2;
        DeviceColor color;
        String colorHex;
        String str;
        Object obj2;
        Object objSyncSetResponse$default2;
        Object obj3;
        T t;
        DeviceColorEntity deviceColorEntity;
        DeviceColorEntity deviceColorEntity2;
        Message message;
        String productId;
        Logger logger;
        String tag;
        int depth;
        Logger logger2;
        String tag2;
        int depth2;
        String str2;
        String str3;
        String strComponent1;
        String strComponent2;
        String str4;
        String str5;
        String strComponent3;
        String strComponent4;
        String str6;
        T t2;
        DeviceModelEntity deviceModelEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            Logger logger3 = Logger.INSTANCE;
            String tag3 = logger3.getTAG();
            int depth3 = logger3.getDepth();
            if (logger3.isCanLogger(true) && "getModelIdByTws".length() != 0) {
                Pair<String, String> trace = logger3.getTrace(depth3);
                String strComponent5 = trace.component1();
                String strComponent6 = trace.component2();
                FileLog fileLog = FileLog.INSTANCE;
                String str7 = logger3.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                FileLog.print$default(fileLog, 4, str7, tag3, "getModelIdByTws " + strComponent6, null, 16, null);
                if (logger3.isDebug()) {
                    Log.i(tag3 + strComponent5, "getModelIdByTws " + strComponent6);
                }
            }
            objectRef = new Ref.ObjectRef();
            objectRef.element = "";
            this.L$0 = coroutineScope;
            this.L$1 = objectRef;
            this.label = 1;
            objSyncSetResponse$default = TWSDevice.syncSetResponse$default(this.$this_run, ProtocolConstant.Query.GET_REMOTE_COLOR_ID, null, null, false, false, null, this, 62, null);
            if (objSyncSetResponse$default == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i == 1) {
                objectRef = (Ref.ObjectRef) this.L$1;
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                objSyncSetResponse$default = obj;
            } else if (i == 2) {
                String str8 = (String) this.L$2;
                objectRef2 = (Ref.ObjectRef) this.L$1;
                ResultKt.throwOnFailure(obj);
                colorHex = str8;
                str = "";
                obj3 = coroutine_suspended;
                objSyncSetResponse$default2 = obj;
                message = (Message) objSyncSetResponse$default2;
                if (message != null || (deviceModelEntity = (DeviceModelEntity) message.obtainPayload(DeviceModelEntity.class)) == null || (productId = deviceModelEntity.getProductId()) == null) {
                    productId = str;
                }
                if (productId.length() > 0) {
                    str6 = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(productId + colorHex);
                    if (str6 == null) {
                        t2 = str6;
                        t2 = str;
                    }
                    t2 = str6;
                    objectRef2.element = t2;
                    if (((CharSequence) objectRef2.element).length() > 0) {
                        MacCacheManager macCacheManager = MacCacheManager.INSTANCE;
                        String address = this.$this_run.getDevice().getAddress();
                        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                        MacCacheManager.saveNothingRevers$default(macCacheManager, address, (String) objectRef2.element, 0, 4, null);
                    }
                }
                logger = Logger.INSTANCE;
                tag = logger.getTAG();
                depth = logger.getDepth();
                if (logger.isCanLogger(true)) {
                    str4 = "productId: " + productId + ",color:" + colorHex + ",modelId:" + objectRef2.element;
                    str5 = str4;
                    if (str5 != null && str5.length() != 0) {
                        Pair<String, String> trace2 = logger.getTrace(depth);
                        strComponent3 = trace2.component1();
                        strComponent4 = trace2.component2();
                        FileLog fileLog2 = FileLog.INSTANCE;
                        String str9 = logger.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                        FileLog.print$default(fileLog2, 4, str9, tag, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                        if (logger.isDebug()) {
                            Log.i(tag + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                        }
                    }
                }
                logger2 = Logger.INSTANCE;
                tag2 = logger2.getTAG();
                depth2 = logger2.getDepth();
                if (logger2.isCanLogger(true)) {
                    str2 = " ParseUtil.deviceModelMap = " + BleBroadcastParseUtil.INSTANCE.getDeviceModelMap();
                    str3 = str2;
                    if (str3 != null && str3.length() != 0) {
                        Pair<String, String> trace3 = logger2.getTrace(depth2);
                        strComponent1 = trace3.component1();
                        strComponent2 = trace3.component2();
                        FileLog fileLog3 = FileLog.INSTANCE;
                        String str10 = logger2.getSdf().format(new Date());
                        Intrinsics.checkNotNullExpressionValue(str10, "format(...)");
                        FileLog.print$default(fileLog3, 4, str10, tag2, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                        if (logger2.isDebug()) {
                            Log.i(tag2 + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                        }
                    }
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass6(this.this$0, objectRef2, null), this) == obj3) {
                    return obj3;
                }
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
        objectRef2 = objectRef;
        Message message2 = (Message) objSyncSetResponse$default;
        if (message2 == null || (deviceColorEntity2 = (DeviceColorEntity) message2.obtainPayload(DeviceColorEntity.class)) == null || (color = deviceColorEntity2.getColor()) == null) {
            color = DeviceColor.WHITE;
        }
        if (message2 == null || (deviceColorEntity = (DeviceColorEntity) message2.obtainPayload(DeviceColorEntity.class)) == null || (colorHex = deviceColorEntity.getColorHex()) == null) {
            colorHex = "02";
        }
        Logger logger4 = Logger.INSTANCE;
        String tag4 = logger4.getTAG();
        int depth4 = logger4.getDepth();
        if (logger4.isCanLogger(true)) {
            String str11 = "end getModelIdByTws color:" + color;
            String str12 = str11;
            if (str12 == null || str12.length() == 0) {
                obj2 = coroutine_suspended;
                str = "";
            } else {
                Pair<String, String> trace4 = logger4.getTrace(depth4);
                String strComponent7 = trace4.component1();
                String strComponent8 = trace4.component2();
                FileLog fileLog4 = FileLog.INSTANCE;
                str = "";
                String str13 = logger4.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                obj2 = coroutine_suspended;
                FileLog.print$default(fileLog4, 4, str13, tag4, str11 + StringUtils.SPACE + strComponent8, null, 16, null);
                if (logger4.isDebug()) {
                    Log.i(tag4 + strComponent7, str11 + StringUtils.SPACE + strComponent8);
                }
            }
        } else {
            obj2 = coroutine_suspended;
            str = "";
        }
        if (this.this$0.isEarOneVersion(this.$this_run.getVersion())) {
            if (color == DeviceColor.WHITE) {
                t = "31D53D";
            } else {
                t = "624011";
            }
            objectRef2.element = t;
            MacCacheManager macCacheManager2 = MacCacheManager.INSTANCE;
            String address2 = this.$this_run.getDevice().getAddress();
            Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
            MacCacheManager.saveNothingRevers$default(macCacheManager2, address2, (String) objectRef2.element, 0, 4, null);
            Logger logger5 = Logger.INSTANCE;
            String tag5 = logger5.getTAG();
            int depth5 = logger5.getDepth();
            if (logger5.isCanLogger(true) && "end getModelIdByTws isEarOneVersion".length() != 0) {
                Pair<String, String> trace5 = logger5.getTrace(depth5);
                String strComponent9 = trace5.component1();
                String strComponent10 = trace5.component2();
                FileLog fileLog5 = FileLog.INSTANCE;
                String str14 = logger5.getSdf().format(new Date());
                Intrinsics.checkNotNullExpressionValue(str14, "format(...)");
                FileLog.print$default(fileLog5, 4, str14, tag5, "end getModelIdByTws isEarOneVersion " + strComponent10, null, 16, null);
                if (logger5.isDebug()) {
                    Log.i(tag5 + strComponent9, "end getModelIdByTws isEarOneVersion " + strComponent10);
                }
            }
            obj3 = obj2;
        } else {
            this.L$0 = coroutineScope;
            this.L$1 = objectRef2;
            this.L$2 = colorHex;
            this.label = 2;
            objSyncSetResponse$default2 = TWSDevice.syncSetResponse$default(this.$this_run, ProtocolConstant.Query.GET_DEVICE_MODEL, null, null, false, false, null, this, 62, null);
            obj3 = obj2;
            if (objSyncSetResponse$default2 == obj3) {
                return obj3;
            }
            message = (Message) objSyncSetResponse$default2;
            if (message != null) {
                productId = str;
            } else {
                productId = str;
            }
            if (productId.length() > 0) {
                str6 = BleBroadcastParseUtil.INSTANCE.getDeviceModelMap().get(productId + colorHex);
                if (str6 == null) {
                    t2 = str6;
                    t2 = str;
                }
                t2 = str6;
                objectRef2.element = t2;
                if (((CharSequence) objectRef2.element).length() > 0) {
                    MacCacheManager macCacheManager3 = MacCacheManager.INSTANCE;
                    String address3 = this.$this_run.getDevice().getAddress();
                    Intrinsics.checkNotNullExpressionValue(address3, "getAddress(...)");
                    MacCacheManager.saveNothingRevers$default(macCacheManager3, address3, (String) objectRef2.element, 0, 4, null);
                }
            }
            logger = Logger.INSTANCE;
            tag = logger.getTAG();
            depth = logger.getDepth();
            if (logger.isCanLogger(true)) {
                str4 = "productId: " + productId + ",color:" + colorHex + ",modelId:" + objectRef2.element;
                str5 = str4;
                if (str5 != null) {
                    Pair<String, String> trace6 = logger.getTrace(depth);
                    strComponent3 = trace6.component1();
                    strComponent4 = trace6.component2();
                    FileLog fileLog6 = FileLog.INSTANCE;
                    String str15 = logger.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str15, "format(...)");
                    FileLog.print$default(fileLog6, 4, str15, tag, str4 + StringUtils.SPACE + strComponent4, null, 16, null);
                    if (logger.isDebug()) {
                        Log.i(tag + strComponent3, str4 + StringUtils.SPACE + strComponent4);
                    }
                }
            }
            logger2 = Logger.INSTANCE;
            tag2 = logger2.getTAG();
            depth2 = logger2.getDepth();
            if (logger2.isCanLogger(true)) {
                str2 = " ParseUtil.deviceModelMap = " + BleBroadcastParseUtil.INSTANCE.getDeviceModelMap();
                str3 = str2;
                if (str3 != null) {
                    Pair<String, String> trace7 = logger2.getTrace(depth2);
                    strComponent1 = trace7.component1();
                    strComponent2 = trace7.component2();
                    FileLog fileLog7 = FileLog.INSTANCE;
                    String str16 = logger2.getSdf().format(new Date());
                    Intrinsics.checkNotNullExpressionValue(str16, "format(...)");
                    FileLog.print$default(fileLog7, 4, str16, tag2, str2 + StringUtils.SPACE + strComponent2, null, 16, null);
                    if (logger2.isDebug()) {
                        Log.i(tag2 + strComponent1, str2 + StringUtils.SPACE + strComponent2);
                    }
                }
            }
        }
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass6(this.this$0, objectRef2, null), this) == obj3) {
            return obj3;
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.ear.one.base.EarOneUnknownDevice$getModelIdByTws$2$2$6, reason: invalid class name */
    /* JADX INFO: compiled from: EarOneUnknownDevice.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.one.base.EarOneUnknownDevice$getModelIdByTws$2$2$6", f = "EarOneUnknownDevice.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<String> $modelId;
        int label;
        final /* synthetic */ EarOneUnknownDevice this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(EarOneUnknownDevice earOneUnknownDevice, Ref.ObjectRef<String> objectRef, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.this$0 = earOneUnknownDevice;
            this.$modelId = objectRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.this$0, this.$modelId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.getAction().invoke(this.$modelId.element);
            return Unit.INSTANCE;
        }
    }
}
