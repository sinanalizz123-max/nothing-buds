package com.nothing.ear.twos.equalizer;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.protocol.entity.BasicInt;
import com.nothing.base.wiget.radar.EQLabelItem;
import com.nothing.ear.twos.core.protocol.EarTwosSppProtocol;
import com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
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
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: EqualizerViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\rR\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/nothing/ear/twos/equalizer/EqualizerViewModel;", "Lcom/nothing/earbase/equalizer/viewmodel/BaseEqualizerViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "needHDACWarning", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getNeedHDACWarning", "()Landroidx/lifecycle/MutableLiveData;", "register", "", "getFreq", "", "radarItem", "Lcom/nothing/base/wiget/radar/EQLabelItem;", "getQ", "checkLDACStatus", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EqualizerViewModel extends BaseEqualizerViewModel {
    private final MutableLiveData<Integer> needHDACWarning;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EqualizerViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.needHDACWarning = new MutableLiveData<>(-1);
    }

    public final MutableLiveData<Integer> getNeedHDACWarning() {
        return this.needHDACWarning;
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public void register() {
        setProtocol(new EarTwosSppProtocol(getAddress()));
        super.register();
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public float getFreq(EQLabelItem radarItem) {
        Intrinsics.checkNotNullParameter(radarItem, "radarItem");
        int type = radarItem.getType();
        if (type == 0) {
            return 140.0f;
        }
        if (type != 1) {
            return type != 2 ? 140.0f : 3400.0f;
        }
        return 980.0f;
    }

    @Override // com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel
    public float getQ(EQLabelItem radarItem) {
        Intrinsics.checkNotNullParameter(radarItem, "radarItem");
        int type = radarItem.getType();
        if (type != 0) {
            return (type == 1 || type == 2) ? 0.7f : 0.8f;
        }
        return 0.8f;
    }

    /* JADX INFO: renamed from: com.nothing.ear.twos.equalizer.EqualizerViewModel$checkLDACStatus$1, reason: invalid class name */
    /* JADX INFO: compiled from: EqualizerViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.ear.twos.equalizer.EqualizerViewModel$checkLDACStatus$1", f = "EqualizerViewModel.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EqualizerViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:16:0x004a  */
        /* JADX WARN: Code duplicated, block: B:21:0x0062  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BasicInt basicInt;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = EqualizerViewModel.this.getProtocol().getTWSDevice();
                if (tWSDevice != null) {
                    this.label = 1;
                    obj = TWSDevice.sendMessageSync$default(tWSDevice, ProtocolConstant.Query.GET_LHDC_COMMANDS, null, false, false, null, null, this, 62, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    basicInt = null;
                }
                if (basicInt == null && basicInt.getValue() == 2) {
                    EqualizerViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(1));
                } else {
                    EqualizerViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Message message = (Message) obj;
            if (message != null) {
                basicInt = (BasicInt) message.obtainPayload(BasicInt.class);
            } else {
                basicInt = null;
            }
            if (basicInt == null) {
                EqualizerViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
            } else {
                EqualizerViewModel.this.getNeedHDACWarning().postValue(Boxing.boxInt(0));
            }
            return Unit.INSTANCE;
        }
    }

    public final void checkLDACStatus() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }
}
