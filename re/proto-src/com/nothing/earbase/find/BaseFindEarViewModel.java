package com.nothing.earbase.find;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.exoplayer2.Renderer;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.earbase.spp.BaseSppProtocol;
import com.nothing.log.feedback.LogFeedback;
import com.nothing.os.device.bluetooth.components.bassboost.os.UltraBassComponents;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import java.util.HashMap;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: BaseFindEarViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ\u0012\u0010\u0017\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0018\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u000fJ\u0010\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\u0006\u0010\u001b\u001a\u00020\u0015J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0010\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\b\u0010%\u001a\u00020\u0015H\u0016J\u001a\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010(H\u0016J\u0018\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020#H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR-\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000ej\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006-"}, d2 = {"Lcom/nothing/earbase/find/BaseFindEarViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lcom/nothing/protocol/device/TWSDevice$Callback;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "protocol", "Lcom/nothing/earbase/spp/BaseSppProtocol;", "getProtocol", "()Lcom/nothing/earbase/spp/BaseSppProtocol;", "setProtocol", "(Lcom/nothing/earbase/spp/BaseSppProtocol;)V", "timeOutJobMap", "Ljava/util/HashMap;", "", "Lkotlinx/coroutines/Job;", "Lkotlin/collections/HashMap;", "getTimeOutJobMap", "()Ljava/util/HashMap;", "findEar", "", "earType", "connectDevice", "sendFindEarCommand", "stopFindEar", "findEarAutoStop", "getFindEarState", "stateConnecting", "stateNone", "stateRing", "connected", "disconnected", "updateFindEarState", "message", "Lcom/nothing/protocol/model/Message;", "onConnected", "onDisconnected", "onError", "code", "", "onUpdate", "cmdType", "data", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseFindEarViewModel extends AndroidViewModel implements TWSDevice.Callback {
    public static final long CONNECT_DELAY = 15000;
    public static final long RINGING_DELAY = 60000;
    public static final int SET_FAILURE = 0;
    public static final int SET_SUCCESS = 1;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_DISCONNECT = 3;
    public static final int STATE_NONE = 0;
    public static final int STATE_RING = 2;
    public BaseSppProtocol protocol;
    private final HashMap<Integer, Job> timeOutJobMap;

    public void connected() {
    }

    public void disconnected() {
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(int code, String message) {
    }

    public void stateConnecting(int earType) {
    }

    public void stateNone(int earType) {
    }

    public void stateRing(int earType) {
    }

    public void updateFindEarState(Message message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFindEarViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.timeOutJobMap = new HashMap<>();
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void getBesVersionSuccess() {
        TWSDevice.Callback.DefaultImpls.getBesVersionSuccess(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public boolean isIOThread() {
        return TWSDevice.Callback.DefaultImpls.isIOThread(this);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnected(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnecting(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onConnecting(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onDisconnected(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onError(TWSDevice tWSDevice, int i, String str) {
        TWSDevice.Callback.DefaultImpls.onError(this, tWSDevice, i, str);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int i, Message message, TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.onUpdate(this, i, message, tWSDevice);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void openBluetooth(TWSDevice tWSDevice) {
        TWSDevice.Callback.DefaultImpls.openBluetooth(this, tWSDevice);
    }

    public final BaseSppProtocol getProtocol() {
        BaseSppProtocol baseSppProtocol = this.protocol;
        if (baseSppProtocol != null) {
            return baseSppProtocol;
        }
        Intrinsics.throwUninitializedPropertyAccessException("protocol");
        return null;
    }

    public final void setProtocol(BaseSppProtocol baseSppProtocol) {
        Intrinsics.checkNotNullParameter(baseSppProtocol, "<set-?>");
        this.protocol = baseSppProtocol;
    }

    public final HashMap<Integer, Job> getTimeOutJobMap() {
        return this.timeOutJobMap;
    }

    public static /* synthetic */ void findEar$default(BaseFindEarViewModel baseFindEarViewModel, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findEar");
        }
        if ((i2 & 1) != 0) {
            i = 5;
        }
        baseFindEarViewModel.findEar(i);
    }

    public final void findEar(int earType) {
        String address;
        TWSDevice tWSDevice = getProtocol().getTWSDevice();
        if (tWSDevice != null && !tWSDevice.isConnected()) {
            LogFeedback logFeedback = LogFeedback.INSTANCE;
            TWSDevice tWSDevice2 = getProtocol().getTWSDevice();
            if (tWSDevice2 == null || (address = tWSDevice2.getAddress()) == null) {
                address = "";
            }
            logFeedback.addPoint(address, "Find my earbuds", "BaseFindEarViewModel findEar not connected");
            connectDevice(earType);
            return;
        }
        sendFindEarCommand(earType);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.find.BaseFindEarViewModel$connectDevice$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseFindEarViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.find.BaseFindEarViewModel$connectDevice$1", f = "BaseFindEarViewModel.kt", i = {}, l = {63, 64}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $earType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$earType = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFindEarViewModel.this.new AnonymousClass1(this.$earType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0065, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.find.BaseFindEarViewModel.AnonymousClass1.C01401(r10.this$0, r10.$earType, null), r10) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                BaseFindEarViewModel.this.stateConnecting(this.$earType);
                TWSDevice tWSDevice = BaseFindEarViewModel.this.getProtocol().getTWSDevice();
                if (tWSDevice != null) {
                    TWSDevice.connect$default(tWSDevice, false, null, null, 7, null);
                }
                this.label = 1;
                if (DelayKt.delay(15000L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.find.BaseFindEarViewModel$connectDevice$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFindEarViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.find.BaseFindEarViewModel$connectDevice$1$1", f = "BaseFindEarViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01401 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $earType;
            int label;
            final /* synthetic */ BaseFindEarViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01401(BaseFindEarViewModel baseFindEarViewModel, int i, Continuation<? super C01401> continuation) {
                super(2, continuation);
                this.this$0 = baseFindEarViewModel;
                this.$earType = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01401(this.this$0, this.$earType, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01401) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = this.this$0.getProtocol().getTWSDevice();
                if (tWSDevice != null && !tWSDevice.isConnected()) {
                    this.this$0.stateNone(this.$earType);
                }
                return Unit.INSTANCE;
            }
        }
    }

    static /* synthetic */ void connectDevice$default(BaseFindEarViewModel baseFindEarViewModel, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: connectDevice");
        }
        if ((i2 & 1) != 0) {
            i = 5;
        }
        baseFindEarViewModel.connectDevice(i);
    }

    private final void connectDevice(int earType) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(earType, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.find.BaseFindEarViewModel$sendFindEarCommand$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFindEarViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.find.BaseFindEarViewModel$sendFindEarCommand$1", f = "BaseFindEarViewModel.kt", i = {}, l = {UltraBassComponents.BASS_BOOST_LEVEL4_PROGRESS, 78}, m = "invokeSuspend", n = {}, s = {})
    static final class C06831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $earType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06831(int i, Continuation<? super C06831> continuation) {
            super(2, continuation);
            this.$earType = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFindEarViewModel.this.new C06831(this.$earType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06831) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.find.BaseFindEarViewModel.C06831.C01421(r8, r7.this$0, r7.$earType, null), r7) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = BaseFindEarViewModel.this.getProtocol().updateWhereAmI(this.$earType, true, this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.find.BaseFindEarViewModel$sendFindEarCommand$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFindEarViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.find.BaseFindEarViewModel$sendFindEarCommand$1$1", f = "BaseFindEarViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01421 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $earType;
            final /* synthetic */ boolean $result;
            int label;
            final /* synthetic */ BaseFindEarViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01421(boolean z, BaseFindEarViewModel baseFindEarViewModel, int i, Continuation<? super C01421> continuation) {
                super(2, continuation);
                this.$result = z;
                this.this$0 = baseFindEarViewModel;
                this.$earType = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01421(this.$result, this.this$0, this.$earType, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01421) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                if (this.$result) {
                    this.this$0.stateRing(this.$earType);
                    Job job = this.this$0.getTimeOutJobMap().get(Boxing.boxInt(this.$earType));
                    if (job != null) {
                        Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                    }
                    this.this$0.findEarAutoStop(this.$earType);
                } else {
                    this.this$0.stateNone(this.$earType);
                }
                return Unit.INSTANCE;
            }
        }
    }

    public static /* synthetic */ void sendFindEarCommand$default(BaseFindEarViewModel baseFindEarViewModel, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendFindEarCommand");
        }
        if ((i2 & 1) != 0) {
            i = 5;
        }
        baseFindEarViewModel.sendFindEarCommand(i);
    }

    public final void sendFindEarCommand(int earType) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06831(earType, null), 2, null);
    }

    public static /* synthetic */ void stopFindEar$default(BaseFindEarViewModel baseFindEarViewModel, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopFindEar");
        }
        if ((i2 & 1) != 0) {
            i = 5;
        }
        baseFindEarViewModel.stopFindEar(i);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.find.BaseFindEarViewModel$stopFindEar$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFindEarViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.find.BaseFindEarViewModel$stopFindEar$1", f = "BaseFindEarViewModel.kt", i = {}, l = {94}, m = "invokeSuspend", n = {}, s = {})
    static final class C06841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $earType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06841(int i, Continuation<? super C06841> continuation) {
            super(2, continuation);
            this.$earType = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFindEarViewModel.this.new C06841(this.$earType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06841) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Job job = BaseFindEarViewModel.this.getTimeOutJobMap().get(Boxing.boxInt(this.$earType));
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                this.label = 1;
                if (BaseFindEarViewModel.this.getProtocol().updateWhereAmI(this.$earType, false, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void stopFindEar(int earType) {
        stateNone(earType);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06841(earType, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.earbase.find.BaseFindEarViewModel$findEarAutoStop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFindEarViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.find.BaseFindEarViewModel$findEarAutoStop$1", f = "BaseFindEarViewModel.kt", i = {}, l = {Renderer.MSG_SET_WAKEUP_LISTENER, 104}, m = "invokeSuspend", n = {}, s = {})
    static final class C06811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $earType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C06811(int i, Continuation<? super C06811> continuation) {
            super(2, continuation);
            this.$earType = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFindEarViewModel.this.new C06811(this.$earType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06811) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.earbase.find.BaseFindEarViewModel.C06811.C01411(r6.this$0, r6.$earType, null), r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(60000L, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            this.label = 2;
        }

        /* JADX INFO: renamed from: com.nothing.earbase.find.BaseFindEarViewModel$findEarAutoStop$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BaseFindEarViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.earbase.find.BaseFindEarViewModel$findEarAutoStop$1$1", f = "BaseFindEarViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01411 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $earType;
            int label;
            final /* synthetic */ BaseFindEarViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01411(BaseFindEarViewModel baseFindEarViewModel, int i, Continuation<? super C01411> continuation) {
                super(2, continuation);
                this.this$0 = baseFindEarViewModel;
                this.$earType = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01411(this.this$0, this.$earType, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01411) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.stopFindEar(this.$earType);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void findEarAutoStop(int earType) {
        this.timeOutJobMap.put(Integer.valueOf(earType), BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C06811(earType, null), 2, null));
    }

    /* JADX INFO: renamed from: com.nothing.earbase.find.BaseFindEarViewModel$getFindEarState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BaseFindEarViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.find.BaseFindEarViewModel$getFindEarState$1", f = "BaseFindEarViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class C06821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C06821(Continuation<? super C06821> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BaseFindEarViewModel.this.new C06821(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C06821) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            TWSDevice tWSDevice = BaseFindEarViewModel.this.getProtocol().getTWSDevice();
            if (tWSDevice != null) {
                TWSDevice.sendCommands$default(tWSDevice, new int[]{ProtocolConstant.Query.GET_FIND_EAR_STATE}, false, false, 6, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getFindEarState() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C06821(null), 3, null);
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onConnected() {
        connected();
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
        disconnected();
    }

    @Override // com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (cmdType == 49154) {
            updateFindEarState(data);
        }
    }
}
