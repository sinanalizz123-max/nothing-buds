package com.nothing.elekid.dual;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import androidx.databinding.ObservableField;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.nothing.base.protocol.constant.ProtocolConstant;
import com.nothing.base.util.Logger;
import com.nothing.base.util.ext.DataExtKt;
import com.nothing.database.util.SpUtils;
import com.nothing.device.IOTDeviceManager;
import com.nothing.device.IOTProductDevice;
import com.nothing.earbase.score.GooglePlayScoreUtil;
import com.nothing.elekid.base.BaseViewModel;
import com.nothing.elekid.dual.entity.DualDeviceItem;
import com.nothing.elekid.dual.entity.EarDualList;
import com.nothing.log.FileLog;
import com.nothing.log.NTLog;
import com.nothing.protocol.device.TWSDevice;
import com.nothing.protocol.model.Message;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.apache.tika.utils.StringUtils;

/* JADX INFO: compiled from: DualConnectViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 S2\u00020\u0001:\u0001SB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u000e\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020\bJ\b\u0010@\u001a\u00020;H\u0002J\b\u0010A\u001a\u00020;H\u0002JN\u0010B\u001a\u00020\b2\"\u0010C\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)`*2\"\u0010D\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)`*J\b\u0010E\u001a\u00020;H\u0016J\u0010\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020\bH\u0002J\b\u0010H\u001a\u00020;H\u0014J\u0016\u0010I\u001a\u00020;2\u0006\u0010J\u001a\u00020\b2\u0006\u0010K\u001a\u00020#J\b\u0010L\u001a\u00020;H\u0002J\b\u0010M\u001a\u00020;H\u0002J\u0018\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020RH\u0016R\u001f\u0010\u0006\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001f\u0010\u0012\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\u001f\u0010\"\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010#0#0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u000fR\u001f\u0010%\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u000bR*\u0010'\u001a\u001e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)0(j\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020)`*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0,j\b\u0012\u0004\u0012\u00020)`-\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001f\u00100\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u000bR\u001a\u00102\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R(\u00104\u001a\u0010\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000b\"\u0004\b6\u00107R\u001a\u00108\u001a\u00020\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017\u00a8\u0006T"}, d2 = {"Lcom/nothing/elekid/dual/DualConnectViewModel;", "Lcom/nothing/elekid/base/BaseViewModel;", "application", "Landroid/app/Application;", "<init>", "(Landroid/app/Application;)V", "loadAnimal", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "getLoadAnimal", "()Landroidx/lifecycle/MutableLiveData;", "dualEnable", "Landroidx/databinding/ObservableField;", "getDualEnable", "()Landroidx/databinding/ObservableField;", "listEnable", "getListEnable", "isFail", "setValue", "getSetValue", "()Z", "setSetValue", "(Z)V", "jobSet", "Lkotlinx/coroutines/Job;", "jobGet", "getJobGet", "()Lkotlinx/coroutines/Job;", "setJobGet", "(Lkotlinx/coroutines/Job;)V", "setConnectJob", "getSetConnectJob", "setSetConnectJob", "connectSize", "", "getConnectSize", "freshList", "getFreshList", "dualDeviceList", "Ljava/util/LinkedHashMap;", "Lcom/nothing/elekid/dual/entity/DualDeviceItem;", "Lkotlin/collections/LinkedHashMap;", "rcyDeviceList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getRcyDeviceList", "()Ljava/util/ArrayList;", "gotoHomePage", "getGotoHomePage", "isSupportList", "setSupportList", "setConnectTimeOut", "getSetConnectTimeOut", "setSetConnectTimeOut", "(Landroidx/lifecycle/MutableLiveData;)V", "isSystem", "setSystem", "register", "", "extras", "Landroid/os/Bundle;", "setDualEnable", "enable", "getSupportedFeature", "getDeviceList", "compareTo", "origin", Vo2MaxRecord.MeasurementMethod.OTHER, "onDisconnected", "addScore", "isSuccess", "onCleared", "setDeviceConnect", "connect", "address", "showLoadingList", "cancelJob", "onUpdate", "cmdType", "", "data", "Lcom/nothing/protocol/model/Message;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DualConnectViewModel extends BaseViewModel {
    public static final int BIT6 = 64;
    public static final int BYTE_SIZE = 7;
    public static final long SET_CONNECT_DELAY = 25000;
    private final ObservableField<String> connectSize;
    private final LinkedHashMap<String, DualDeviceItem> dualDeviceList;
    private final ObservableField<Boolean> dualEnable;
    private final MutableLiveData<Boolean> freshList;
    private final MutableLiveData<Boolean> gotoHomePage;
    private final MutableLiveData<Boolean> isFail;
    private boolean isSupportList;
    private boolean isSystem;
    private Job jobGet;
    private Job jobSet;
    private final ObservableField<Boolean> listEnable;
    private final MutableLiveData<Boolean> loadAnimal;
    private final ArrayList<DualDeviceItem> rcyDeviceList;
    private Job setConnectJob;
    private MutableLiveData<Boolean> setConnectTimeOut;
    private boolean setValue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DualConnectViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.loadAnimal = new MutableLiveData<>(false);
        this.dualEnable = new ObservableField<>(false);
        this.listEnable = new ObservableField<>(false);
        this.isFail = new MutableLiveData<>(false);
        this.connectSize = new ObservableField<>(" (1/2)");
        this.freshList = new MutableLiveData<>(false);
        this.dualDeviceList = new LinkedHashMap<>();
        this.rcyDeviceList = new ArrayList<>();
        this.gotoHomePage = new MutableLiveData<>(false);
        this.setConnectTimeOut = new MutableLiveData<>(false);
    }

    public final MutableLiveData<Boolean> getLoadAnimal() {
        return this.loadAnimal;
    }

    public final ObservableField<Boolean> getDualEnable() {
        return this.dualEnable;
    }

    public final ObservableField<Boolean> getListEnable() {
        return this.listEnable;
    }

    public final MutableLiveData<Boolean> isFail() {
        return this.isFail;
    }

    public final boolean getSetValue() {
        return this.setValue;
    }

    public final void setSetValue(boolean z) {
        this.setValue = z;
    }

    public final Job getJobGet() {
        return this.jobGet;
    }

    public final void setJobGet(Job job) {
        this.jobGet = job;
    }

    public final Job getSetConnectJob() {
        return this.setConnectJob;
    }

    public final void setSetConnectJob(Job job) {
        this.setConnectJob = job;
    }

    public final ObservableField<String> getConnectSize() {
        return this.connectSize;
    }

    public final MutableLiveData<Boolean> getFreshList() {
        return this.freshList;
    }

    public final ArrayList<DualDeviceItem> getRcyDeviceList() {
        return this.rcyDeviceList;
    }

    public final MutableLiveData<Boolean> getGotoHomePage() {
        return this.gotoHomePage;
    }

    /* JADX INFO: renamed from: isSupportList, reason: from getter */
    public final boolean getIsSupportList() {
        return this.isSupportList;
    }

    public final void setSupportList(boolean z) {
        this.isSupportList = z;
    }

    public final MutableLiveData<Boolean> getSetConnectTimeOut() {
        return this.setConnectTimeOut;
    }

    public final void setSetConnectTimeOut(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.setConnectTimeOut = mutableLiveData;
    }

    /* JADX INFO: renamed from: isSystem, reason: from getter */
    public final boolean getIsSystem() {
        return this.isSystem;
    }

    public final void setSystem(boolean z) {
        this.isSystem = z;
    }

    @Override // com.nothing.elekid.base.BaseViewModel
    public void register(Bundle extras) {
        super.register(extras);
        GooglePlayScoreUtil.INSTANCE.startControl();
        getSupportedFeature();
    }

    public final void setDualEnable(boolean enable) {
        if (!enable) {
            this.setConnectTimeOut.postValue(false);
            Job job = this.setConnectJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C08091(enable, this, null), 2, null);
    }

    /* JADX INFO: renamed from: com.nothing.elekid.dual.DualConnectViewModel$setDualEnable$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DualConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.dual.DualConnectViewModel$setDualEnable$1", f = "DualConnectViewModel.kt", i = {}, l = {84, 90}, m = "invokeSuspend", n = {}, s = {})
    static final class C08091 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ DualConnectViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08091(boolean z, DualConnectViewModel dualConnectViewModel, Continuation<? super C08091> continuation) {
            super(2, continuation);
            this.$enable = z;
            this.this$0 = dualConnectViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08091(this.$enable, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08091) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x00a6, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.elekid.dual.DualConnectViewModel.C08091.C01591(r5.this$0, null), r5) == r0) goto L23;
         */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
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
                boolean z = this.$enable;
                this.this$0.setSetValue(z);
                this.this$0.getLoadAnimal().postValue(Boxing.boxBoolean(true));
                this.label = 1;
                obj = this.this$0.getProtocol().setDualEnable(z ? 1 : 0, this);
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
            if (this.this$0.getIsSupportList()) {
                this.this$0.getDeviceList();
            }
            return Unit.INSTANCE;
            boolean zBooleanValue = ((Boolean) obj).booleanValue();
            this.this$0.addScore(zBooleanValue);
            if (zBooleanValue) {
                this.this$0.getLoadAnimal().postValue(Boxing.boxBoolean(false));
                this.this$0.getDualEnable().set(Boxing.boxBoolean(this.$enable));
                this.this$0.getListEnable().set(Boxing.boxBoolean(this.$enable && this.this$0.getIsSupportList()));
                this.label = 2;
            } else {
                this.this$0.getLoadAnimal().postValue(Boxing.boxBoolean(false));
                this.this$0.isFail().postValue(Boxing.boxBoolean(true));
                this.this$0.addScore(false);
                NTLog.d("dual_connect 5s timeOut set command");
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.elekid.dual.DualConnectViewModel$setDualEnable$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: DualConnectViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.elekid.dual.DualConnectViewModel$setDualEnable$1$1", f = "DualConnectViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C01591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ DualConnectViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01591(DualConnectViewModel dualConnectViewModel, Continuation<? super C01591> continuation) {
                super(2, continuation);
                this.this$0 = dualConnectViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C01591(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C01591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.this$0.showLoadingList();
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX INFO: renamed from: com.nothing.elekid.dual.DualConnectViewModel$getSupportedFeature$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DualConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.dual.DualConnectViewModel$getSupportedFeature$1", f = "DualConnectViewModel.kt", i = {}, l = {107}, m = "invokeSuspend", n = {}, s = {})
    static final class C08071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08071(Continuation<? super C08071> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DualConnectViewModel.this.new C08071(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0046  */
        /* JADX WARN: Code duplicated, block: B:18:0x0048  */
        /* JADX WARN: Code duplicated, block: B:20:0x004e  */
        /* JADX WARN: Code duplicated, block: B:21:0x0055  */
        /* JADX WARN: Code duplicated, block: B:23:0x0058  */
        /* JADX WARN: Code duplicated, block: B:24:0x005a  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Message message;
            byte[] payload;
            int intOrZero;
            boolean z;
            boolean z2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                TWSDevice tWSDevice = DualConnectViewModel.this.getProtocol().getTWSDevice();
                if (tWSDevice != null) {
                    this.label = 1;
                    obj = TWSDevice.syncSetResponse$default(tWSDevice, ProtocolConstant.Query.GET_SUPPORTED_FEATURE, null, null, false, false, null, this, 54, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    message = null;
                }
                DualConnectViewModel dualConnectViewModel = DualConnectViewModel.this;
                if (message != null) {
                    payload = message.getPayload();
                    if (payload != null) {
                        intOrZero = DataExtKt.getIntOrZero(payload, 1) & 64;
                    } else {
                        intOrZero = 0;
                    }
                    if (intOrZero > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = z;
                }
                dualConnectViewModel.setSupportList(z2);
                NTLog.d("Support List getSupportedFeature support:" + DualConnectViewModel.this.getIsSupportList() + ", ");
                DualConnectViewModel.this.getProtocol().getDualEnable();
                return Unit.INSTANCE;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            message = (Message) obj;
            DualConnectViewModel dualConnectViewModel2 = DualConnectViewModel.this;
            if (message != null) {
                payload = message.getPayload();
                if (payload != null) {
                    intOrZero = DataExtKt.getIntOrZero(payload, 1) & 64;
                } else {
                    intOrZero = 0;
                }
                if (intOrZero > 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                }
            }
            dualConnectViewModel2.setSupportList(z2);
            NTLog.d("Support List getSupportedFeature support:" + DualConnectViewModel.this.getIsSupportList() + ", ");
            DualConnectViewModel.this.getProtocol().getDualEnable();
            return Unit.INSTANCE;
        }
    }

    private final void getSupportedFeature() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C08071(null), 3, null);
    }

    /* JADX INFO: renamed from: com.nothing.elekid.dual.DualConnectViewModel$getDeviceList$1, reason: invalid class name */
    /* JADX INFO: compiled from: DualConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.dual.DualConnectViewModel$getDeviceList$1", f = "DualConnectViewModel.kt", i = {0, 0}, l = {129, 142}, m = "invokeSuspend", n = {"disconnectList", "connectList"}, s = {"L$0", "L$1"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DualConnectViewModel.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0041  */
        /* JADX WARN: Code duplicated, block: B:15:0x004d  */
        /* JADX WARN: Code duplicated, block: B:39:0x0125  */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x006b, code lost:
        
            if (r7 == r1) goto L41;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0161, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.elekid.dual.DualConnectViewModel.AnonymousClass1.AnonymousClass3(r2, r6, r20.this$0, null), r20) == r1) goto L41;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006b -> B:18:0x006f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            ArrayList arrayList2;
            int currentPackage;
            int totalPackage;
            TWSDevice tWSDevice;
            Object objSyncSetResponse$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                arrayList = new ArrayList();
                arrayList2 = new ArrayList();
                currentPackage = 0;
                totalPackage = 1;
                if (currentPackage < totalPackage) {
                    tWSDevice = DualConnectViewModel.this.getProtocol().getTWSDevice();
                    if (tWSDevice != null) {
                        this.L$0 = arrayList;
                        this.L$1 = arrayList2;
                        this.label = 1;
                        objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDevice, ProtocolConstant.Query.GET_DUAL_DEVICE_LIST, DataExtKt.toByteArray$default(currentPackage, 0, 1, (Object) null), null, false, false, null, this, 60, null);
                    }
                    return Unit.INSTANCE;
                }
                NTLog.d("DualConnectViewModel List getDeviceList size:" + DualConnectViewModel.this.dualDeviceList.size());
                this.L$0 = null;
                this.L$1 = null;
                this.label = 2;
                return coroutine_suspended;
            }
            if (i == 1) {
                arrayList2 = (ArrayList) this.L$1;
                arrayList = (ArrayList) this.L$0;
                ResultKt.throwOnFailure(obj);
                objSyncSetResponse$default = obj;
                Message message = (Message) objSyncSetResponse$default;
                if (message != null) {
                    byte[] payload = message.getPayload();
                    if (payload == null) {
                        return Unit.INSTANCE;
                    }
                    EarDualList earDualList = new EarDualList(payload);
                    ArrayList<DualDeviceItem> deviceList = earDualList.getDeviceList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : deviceList) {
                        if (Intrinsics.areEqual(((DualDeviceItem) obj2).getConnected().get(), Boxing.boxBoolean(true))) {
                            arrayList3.add(obj2);
                        }
                    }
                    arrayList2.addAll(arrayList3);
                    ArrayList<DualDeviceItem> deviceList2 = earDualList.getDeviceList();
                    ArrayList arrayList4 = new ArrayList();
                    for (Object obj3 : deviceList2) {
                        if (!Intrinsics.areEqual(((DualDeviceItem) obj3).getConnected().get(), Boxing.boxBoolean(true))) {
                            arrayList4.add(obj3);
                        }
                    }
                    arrayList.addAll(arrayList4);
                    currentPackage = earDualList.getCurrentPackage() + 1;
                    totalPackage = earDualList.getTotalPackage();
                    NTLog.d("dual device list current:" + currentPackage + ",total:" + totalPackage);
                    if (currentPackage < totalPackage) {
                        NTLog.d("DualConnectViewModel List getDeviceList size:" + DualConnectViewModel.this.dualDeviceList.size());
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 2;
                    } else {
                        tWSDevice = DualConnectViewModel.this.getProtocol().getTWSDevice();
                        if (tWSDevice != null) {
                            this.L$0 = arrayList;
                            this.L$1 = arrayList2;
                            this.label = 1;
                            objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDevice, ProtocolConstant.Query.GET_DUAL_DEVICE_LIST, DataExtKt.toByteArray$default(currentPackage, 0, 1, (Object) null), null, false, false, null, this, 60, null);
                        }
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.elekid.dual.DualConnectViewModel$getDeviceList$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: DualConnectViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.elekid.dual.DualConnectViewModel$getDeviceList$1$3", f = "DualConnectViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ArrayList<DualDeviceItem> $connectList;
            final /* synthetic */ ArrayList<DualDeviceItem> $disconnectList;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DualConnectViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(ArrayList<DualDeviceItem> arrayList, ArrayList<DualDeviceItem> arrayList2, DualConnectViewModel dualConnectViewModel, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.$connectList = arrayList;
                this.$disconnectList = arrayList2;
                this.this$0 = dualConnectViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$connectList, this.$disconnectList, this.this$0, continuation);
                anonymousClass3.L$0 = obj;
                return anonymousClass3;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DualConnectViewModel.class);
                ArrayList<DualDeviceItem> arrayList = this.$connectList;
                ArrayList<DualDeviceItem> arrayList2 = this.$disconnectList;
                DualConnectViewModel dualConnectViewModel = this.this$0;
                synchronized (orCreateKotlinClass) {
                    LinkedHashMap<String, DualDeviceItem> linkedHashMap = new LinkedHashMap<>();
                    for (DualDeviceItem dualDeviceItem : arrayList) {
                        LinkedHashMap<String, DualDeviceItem> linkedHashMap2 = linkedHashMap;
                        String str = dualDeviceItem.getAddress().get();
                        if (str == null) {
                            str = "";
                        }
                        linkedHashMap2.put(str, dualDeviceItem);
                    }
                    for (DualDeviceItem dualDeviceItem2 : arrayList2) {
                        LinkedHashMap<String, DualDeviceItem> linkedHashMap3 = linkedHashMap;
                        String str2 = dualDeviceItem2.getAddress().get();
                        if (str2 == null) {
                            str2 = "";
                        }
                        linkedHashMap3.put(str2, dualDeviceItem2);
                    }
                    if (!dualConnectViewModel.compareTo(linkedHashMap, dualConnectViewModel.dualDeviceList)) {
                        dualConnectViewModel.dualDeviceList.clear();
                        dualConnectViewModel.dualDeviceList.putAll(linkedHashMap);
                        arrayList.clear();
                        arrayList2.clear();
                        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                        for (Map.Entry<String, DualDeviceItem> entry : linkedHashMap.entrySet()) {
                            if (Intrinsics.areEqual(entry.getValue().getConnected().get(), Boxing.boxBoolean(true))) {
                                linkedHashMap4.put(entry.getKey(), entry.getValue());
                            }
                        }
                        int size = linkedHashMap4.size();
                        dualConnectViewModel.getRcyDeviceList().clear();
                        dualConnectViewModel.getRcyDeviceList().addAll(dualConnectViewModel.dualDeviceList.values());
                        dualConnectViewModel.getConnectSize().set(" (" + size + "/2)");
                        dualConnectViewModel.getFreshList().postValue(Boxing.boxBoolean(true));
                    } else {
                        Logger logger = Logger.INSTANCE;
                        Logger logger2 = logger;
                        String tag = logger.getTAG();
                        int depth = logger.getDepth();
                        if (logger2.isCanLogger(true) && "getDeviceList same data,ignore update".length() != 0) {
                            Pair<String, String> trace = logger2.getTrace(depth);
                            String strComponent1 = trace.component1();
                            String strComponent2 = trace.component2();
                            FileLog fileLog = FileLog.INSTANCE;
                            String str3 = logger2.getSdf().format(new Date());
                            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                            FileLog.print$default(fileLog, 5, str3, tag, "getDeviceList same data,ignore update" + StringUtils.SPACE + strComponent2, null, 16, null);
                            if (logger2.isDebug()) {
                                Log.w(tag + strComponent1, "getDeviceList same data,ignore update" + StringUtils.SPACE + strComponent2);
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getDeviceList() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    public final boolean compareTo(LinkedHashMap<String, DualDeviceItem> origin, LinkedHashMap<String, DualDeviceItem> other) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(other, "other");
        if (origin.size() != other.size()) {
            return false;
        }
        for (Map.Entry<String, DualDeviceItem> entry : origin.entrySet()) {
            if (!Intrinsics.areEqual(entry.getValue(), other.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.nothing.elekid.base.BaseViewModel, com.nothing.protocol.device.TWSDevice.Callback
    public void onDisconnected() {
        SpUtils.INSTANCE.setNeedAutoConnect(false);
        this.gotoHomePage.postValue(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addScore(boolean isSuccess) {
        String productId;
        GooglePlayScoreUtil googlePlayScoreUtil = GooglePlayScoreUtil.INSTANCE;
        IOTProductDevice productByMacAddress = IOTDeviceManager.INSTANCE.getProductByMacAddress(getProtocol().getAddress());
        if (productByMacAddress == null || (productId = productByMacAddress.getProductId()) == null) {
            productId = "";
        }
        googlePlayScoreUtil.addScore(isSuccess, productId);
    }

    @Override // com.nothing.elekid.base.BaseViewModel, androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        Job job = this.setConnectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        GooglePlayScoreUtil.INSTANCE.endControl();
        cancelJob();
    }

    /* JADX INFO: renamed from: com.nothing.elekid.dual.DualConnectViewModel$setDeviceConnect$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DualConnectViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.elekid.dual.DualConnectViewModel$setDeviceConnect$1", f = "DualConnectViewModel.kt", i = {}, l = {218, 223, 224}, m = "invokeSuspend", n = {}, s = {})
    static final class C08081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $address;
        final /* synthetic */ boolean $connect;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08081(boolean z, String str, Continuation<? super C08081> continuation) {
            super(2, continuation);
            this.$connect = z;
            this.$address = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DualConnectViewModel.this.new C08081(this.$connect, this.$address, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.nothing.elekid.dual.DualConnectViewModel.C08081.AnonymousClass2(r18.this$0, r18.$connect, r18.$address, null), r18) == r1) goto L39;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object next;
            Object objSyncSetResponse$default;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ArrayList<DualDeviceItem> rcyDeviceList = DualConnectViewModel.this.getRcyDeviceList();
                String str = this.$address;
                Iterator<T> it = rcyDeviceList.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((DualDeviceItem) next).getAddress().get(), str));
                DualDeviceItem dualDeviceItem = (DualDeviceItem) next;
                if (dualDeviceItem == null) {
                    return Unit.INSTANCE;
                }
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(7);
                byteBufferAllocate.put(this.$connect ? (byte) 1 : (byte) 0);
                byte[] addressByte = dualDeviceItem.getAddressByte();
                if (addressByte != null) {
                    byteBufferAllocate.put(addressByte);
                }
                TWSDevice tWSDevice = DualConnectViewModel.this.getProtocol().getTWSDevice();
                if (tWSDevice != null) {
                    this.label = 1;
                    objSyncSetResponse$default = TWSDevice.syncSetResponse$default(tWSDevice, ProtocolConstant.Set.SET_CONNECT_DEVICE, byteBufferAllocate.array(), null, false, false, null, this, 60, null);
                    if (objSyncSetResponse$default != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                objSyncSetResponse$default = obj;
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                this.label = 3;
            } else {
                if (i != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
            if (((Message) objSyncSetResponse$default) != null) {
                this.label = 2;
                if (DelayKt.delay(DualConnectViewModel.SET_CONNECT_DELAY, this) != coroutine_suspended) {
                    this.label = 3;
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.nothing.elekid.dual.DualConnectViewModel$setDeviceConnect$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: DualConnectViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.nothing.elekid.dual.DualConnectViewModel$setDeviceConnect$1$2", f = "DualConnectViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $address;
            final /* synthetic */ boolean $connect;
            int label;
            final /* synthetic */ DualConnectViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(DualConnectViewModel dualConnectViewModel, boolean z, String str, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = dualConnectViewModel;
                this.$connect = z;
                this.$address = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$connect, this.$address, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object next;
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ArrayList<DualDeviceItem> rcyDeviceList = this.this$0.getRcyDeviceList();
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : rcyDeviceList) {
                    if (Intrinsics.areEqual(((DualDeviceItem) obj2).isChangeState().get(), Boxing.boxBoolean(true))) {
                        arrayList.add(obj2);
                    }
                }
                if (arrayList.size() > 0) {
                    Iterator<T> it = this.this$0.getRcyDeviceList().iterator();
                    while (it.hasNext()) {
                        ((DualDeviceItem) it.next()).isChangeState().set(Boxing.boxBoolean(false));
                    }
                    this.this$0.getFreshList().postValue(Boxing.boxBoolean(true));
                }
                ArrayList<DualDeviceItem> rcyDeviceList2 = this.this$0.getRcyDeviceList();
                String str = this.$address;
                Iterator<T> it2 = rcyDeviceList2.iterator();
                do {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                } while (!Intrinsics.areEqual(((DualDeviceItem) next).getAddress().get(), str));
                DualDeviceItem dualDeviceItem = (DualDeviceItem) next;
                if (dualDeviceItem == null) {
                    return Unit.INSTANCE;
                }
                this.this$0.addScore(Intrinsics.areEqual(Boxing.boxBoolean(this.$connect), dualDeviceItem.getConnected().get()));
                this.this$0.getSetConnectTimeOut().postValue(Boxing.boxBoolean(!Intrinsics.areEqual(Boxing.boxBoolean(this.$connect), dualDeviceItem.getConnected().get())));
                return Unit.INSTANCE;
            }
        }
    }

    public final void setDeviceConnect(boolean connect, String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        Job job = this.setConnectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.setConnectJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C08081(connect, address, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showLoadingList() {
        this.connectSize.set(" (0/2)");
        this.dualDeviceList.clear();
        this.rcyDeviceList.clear();
        this.freshList.postValue(true);
    }

    private final void cancelJob() {
        Job job = this.jobGet;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.jobSet;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        Job job3 = this.setConnectJob;
        if (job3 != null) {
            Job.DefaultImpls.cancel$default(job3, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.nothing.elekid.base.BaseViewModel, com.nothing.protocol.device.TWSDevice.Callback
    public void onUpdate(int cmdType, Message data) {
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z = true;
        if (cmdType == 49191) {
            Integer num = (Integer) data.obtainPayload(Integer.TYPE);
            ObservableField<Boolean> observableField = this.dualEnable;
            if (num != null && num.intValue() == 0) {
                z = false;
            }
            observableField.set(Boolean.valueOf(z));
            NTLog.d("Support List onUpdate support:" + this.isSupportList + ",dualEnable:" + this.dualEnable.get());
            if (!Intrinsics.areEqual((Object) this.dualEnable.get(), (Object) true) || !this.isSupportList) {
                this.listEnable.set(false);
            } else {
                this.listEnable.set(true);
                NTLog.d("DualConnectViewModel List onUpdate GET_DUAL_ENABLE dualEnable is true get list");
                getDeviceList();
            }
            cancelJob();
            return;
        }
        if (cmdType == 57350) {
            if (this.isSupportList) {
                getProtocol().getDualEnable();
                return;
            }
            return;
        }
        if (cmdType != 57358) {
            return;
        }
        NTLog.d("Support List onUpdate EVENT_DUAL_DEVICE_CONNECT_STATE support:" + this.isSupportList + ",dualEnable:" + this.dualEnable.get());
        NTLog.d("DualConnectViewModel List onUpdate EVENT_DUAL_DEVICE_CONNECT_STATE get list");
        Job job = this.setConnectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        addScore(true);
        if (Intrinsics.areEqual((Object) this.dualEnable.get(), (Object) true) && this.isSupportList) {
            this.listEnable.set(true);
            getDeviceList();
        }
    }
}
