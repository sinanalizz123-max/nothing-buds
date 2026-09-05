package com.nothing.earbase.unknown;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.google.android.material.tabs.TabLayout;
import com.nothing.base.protocol.entity.BasicBoolean;
import com.nothing.earbase.equalizer.EqualizerLeakageGuard;
import com.nothing.protocol.device.TWSDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: UnknownBaseEqualiserActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.nothing.earbase.unknown.UnknownBaseEqualiserActivity$addEQTab$2$1", f = "UnknownBaseEqualiserActivity.kt", i = {1}, l = {365, 370, 389}, m = "invokeSuspend", n = {"spatialLatest"}, s = {"L$0"})
final class UnknownBaseEqualiserActivity$addEQTab$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ boolean $isExplorer;
    final /* synthetic */ boolean $isSimple;
    final /* synthetic */ TabLayout.Tab $newTab;
    Object L$0;
    int label;
    final /* synthetic */ UnknownBaseEqualiserActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UnknownBaseEqualiserActivity$addEQTab$2$1(UnknownBaseEqualiserActivity unknownBaseEqualiserActivity, TabLayout.Tab tab, boolean z, boolean z2, Function0<Unit> function0, Continuation<? super UnknownBaseEqualiserActivity$addEQTab$2$1> continuation) {
        super(2, continuation);
        this.this$0 = unknownBaseEqualiserActivity;
        this.$newTab = tab;
        this.$isSimple = z;
        this.$isExplorer = z2;
        this.$action = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UnknownBaseEqualiserActivity$addEQTab$2$1(this.this$0, this.$newTab, this.$isSimple, this.$isExplorer, this.$action, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((UnknownBaseEqualiserActivity$addEQTab$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0078  */
    /* JADX WARN: Code duplicated, block: B:22:0x009d  */
    /* JADX WARN: Code duplicated, block: B:23:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:27:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:29:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:30:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:32:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:34:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00ea A[PHI: r1
      0x00ea: PHI (r1v6 com.nothing.base.protocol.entity.BasicBoolean) = (r1v5 com.nothing.base.protocol.entity.BasicBoolean), (r1v14 com.nothing.base.protocol.entity.BasicBoolean) binds: [B:33:0x00d3, B:36:0x00e1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:43:0x0100  */
    /* JADX WARN: Code duplicated, block: B:44:0x0102 A[PHI: r15
      0x0102: PHI (r15v12 com.nothing.base.protocol.entity.BasicBoolean) = (r15v11 com.nothing.base.protocol.entity.BasicBoolean), (r15v19 com.nothing.base.protocol.entity.BasicBoolean) binds: [B:39:0x00eb, B:42:0x00f9] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012c, code lost:
    
        if (r15.guardEqAction(r3, r1, new com.nothing.earbase.unknown.UnknownBaseEqualiserActivity$addEQTab$2$1$$ExternalSyntheticLambda0(r7, r8, r9, r10, r11, r12, r13), r14) == r0) goto L47;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        BasicBoolean value;
        BasicBoolean value2;
        final BasicBoolean basicBoolean;
        final BasicBoolean basicBoolean2;
        LiveData<BasicBoolean> earMutuallyExclusiveLiveData;
        LiveData<BasicBoolean> spatialAudioLiveData;
        BasicBoolean basicBoolean3;
        LiveData<BasicBoolean> earMutuallyExclusiveLiveData2;
        MutableLiveData mutableLiveData;
        BasicBoolean basicBoolean4;
        LiveData<BasicBoolean> spatialAudioLiveData2;
        MutableLiveData mutableLiveData2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getViewModel().getConfig();
            this.label = 1;
            obj = BuildersKt.withContext(Dispatchers.getIO(), new UnknownBaseEqualiserActivity$addEQTab$2$1$spatialLatest$1(this.this$0, null), this);
            if (obj != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            value = (BasicBoolean) this.L$0;
            ResultKt.throwOnFailure(obj);
            value2 = (BasicBoolean) obj;
            if (value != null) {
                UnknownBaseEqualiserActivity unknownBaseEqualiserActivity = this.this$0;
                basicBoolean4 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(value.getOpen(), Boxing.boxBoolean(value.getHead())));
                spatialAudioLiveData2 = unknownBaseEqualiserActivity.getViewModel().getSpatialAudioLiveData();
                if (spatialAudioLiveData2 instanceof MutableLiveData) {
                    mutableLiveData2 = (MutableLiveData) spatialAudioLiveData2;
                } else {
                    mutableLiveData2 = null;
                }
                if (mutableLiveData2 != null) {
                    mutableLiveData2.postValue(basicBoolean4);
                }
            }
            if (value2 != null) {
                UnknownBaseEqualiserActivity unknownBaseEqualiserActivity2 = this.this$0;
                basicBoolean3 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(value2.getOpen(), Boxing.boxBoolean(false)));
                earMutuallyExclusiveLiveData2 = unknownBaseEqualiserActivity2.getViewModel().getEarMutuallyExclusiveLiveData();
                if (earMutuallyExclusiveLiveData2 instanceof MutableLiveData) {
                    mutableLiveData = (MutableLiveData) earMutuallyExclusiveLiveData2;
                } else {
                    mutableLiveData = null;
                }
                if (mutableLiveData != null) {
                    mutableLiveData.postValue(basicBoolean3);
                }
            }
            if (value != null) {
                basicBoolean = value;
            } else {
                spatialAudioLiveData = this.this$0.getViewModel().getSpatialAudioLiveData();
                if (spatialAudioLiveData != null) {
                    value = spatialAudioLiveData.getValue();
                    basicBoolean = value;
                } else {
                    basicBoolean = null;
                }
            }
            if (value2 != null) {
                basicBoolean2 = value2;
            } else {
                earMutuallyExclusiveLiveData = this.this$0.getViewModel().getEarMutuallyExclusiveLiveData();
                if (earMutuallyExclusiveLiveData != null) {
                    value2 = earMutuallyExclusiveLiveData.getValue();
                    basicBoolean2 = value2;
                } else {
                    basicBoolean2 = null;
                }
            }
            EqualizerLeakageGuard equalizerLeakageGuard = EqualizerLeakageGuard.INSTANCE;
            UnknownBaseEqualiserActivity unknownBaseEqualiserActivity3 = this.this$0;
            UnknownBaseEqualiserActivity unknownBaseEqualiserActivity4 = unknownBaseEqualiserActivity3;
            TWSDevice tWSDevice = unknownBaseEqualiserActivity3.getViewModel().getTWSDevice();
            final UnknownBaseEqualiserActivity unknownBaseEqualiserActivity5 = this.this$0;
            final TabLayout.Tab tab = this.$newTab;
            final boolean z = this.$isSimple;
            final boolean z2 = this.$isExplorer;
            final Function0<Unit> function0 = this.$action;
            this.L$0 = null;
            this.label = 3;
        } else {
            if (i != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
        value = (BasicBoolean) obj;
        this.L$0 = value;
        this.label = 2;
        obj = BuildersKt.withContext(Dispatchers.getIO(), new UnknownBaseEqualiserActivity$addEQTab$2$1$exclusiveLatest$1(this.this$0, null), this);
        if (obj != coroutine_suspended) {
            value2 = (BasicBoolean) obj;
            if (value != null) {
                UnknownBaseEqualiserActivity unknownBaseEqualiserActivity6 = this.this$0;
                basicBoolean4 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(value.getOpen(), Boxing.boxBoolean(value.getHead())));
                spatialAudioLiveData2 = unknownBaseEqualiserActivity6.getViewModel().getSpatialAudioLiveData();
                if (spatialAudioLiveData2 instanceof MutableLiveData) {
                    mutableLiveData2 = (MutableLiveData) spatialAudioLiveData2;
                } else {
                    mutableLiveData2 = null;
                }
                if (mutableLiveData2 != null) {
                    mutableLiveData2.postValue(basicBoolean4);
                }
            }
            if (value2 != null) {
                UnknownBaseEqualiserActivity unknownBaseEqualiserActivity7 = this.this$0;
                basicBoolean3 = new BasicBoolean(BasicBoolean.INSTANCE.obtainDataPacket(value2.getOpen(), Boxing.boxBoolean(false)));
                earMutuallyExclusiveLiveData2 = unknownBaseEqualiserActivity7.getViewModel().getEarMutuallyExclusiveLiveData();
                if (earMutuallyExclusiveLiveData2 instanceof MutableLiveData) {
                    mutableLiveData = (MutableLiveData) earMutuallyExclusiveLiveData2;
                } else {
                    mutableLiveData = null;
                }
                if (mutableLiveData != null) {
                    mutableLiveData.postValue(basicBoolean3);
                }
            }
            if (value != null) {
                basicBoolean = value;
            } else {
                spatialAudioLiveData = this.this$0.getViewModel().getSpatialAudioLiveData();
                if (spatialAudioLiveData != null) {
                    value = spatialAudioLiveData.getValue();
                    basicBoolean = value;
                } else {
                    basicBoolean = null;
                }
            }
            if (value2 != null) {
                basicBoolean2 = value2;
            } else {
                earMutuallyExclusiveLiveData = this.this$0.getViewModel().getEarMutuallyExclusiveLiveData();
                if (earMutuallyExclusiveLiveData != null) {
                    value2 = earMutuallyExclusiveLiveData.getValue();
                    basicBoolean2 = value2;
                } else {
                    basicBoolean2 = null;
                }
            }
            EqualizerLeakageGuard equalizerLeakageGuard2 = EqualizerLeakageGuard.INSTANCE;
            UnknownBaseEqualiserActivity unknownBaseEqualiserActivity8 = this.this$0;
            UnknownBaseEqualiserActivity unknownBaseEqualiserActivity9 = unknownBaseEqualiserActivity8;
            TWSDevice tWSDevice2 = unknownBaseEqualiserActivity8.getViewModel().getTWSDevice();
            final UnknownBaseEqualiserActivity unknownBaseEqualiserActivity10 = this.this$0;
            final TabLayout.Tab tab2 = this.$newTab;
            final boolean z3 = this.$isSimple;
            final boolean z4 = this.$isExplorer;
            final Function0<Unit> function1 = this.$action;
            this.L$0 = null;
            this.label = 3;
        }
        return coroutine_suspended;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$2(UnknownBaseEqualiserActivity unknownBaseEqualiserActivity, TabLayout.Tab tab, boolean z, boolean z2, Function0 function0, BasicBoolean basicBoolean, BasicBoolean basicBoolean2) {
        unknownBaseEqualiserActivity.applyUnknownEqTabClick(tab, z, z2, function0, basicBoolean, basicBoolean2);
        return Unit.INSTANCE;
    }
}
