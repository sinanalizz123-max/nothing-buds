package com.nothing.earbase.os.control;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.blankj.utilcode.util.ScreenUtils;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.base.view.BaseDialogFragment;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.OsVoiceAssistantDialogBinding;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.GptProviderHelper;
import com.nothing.earbase.control.VoiceAssistantUtil;
import com.nothing.event.log.AppBuriedPointUtils;
import com.nothing.event.log.database.entity.EventParams;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: OSVoiceAssistantSelectDialog.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020%H\u0002J\u001c\u0010&\u001a\u00020\u00162\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\u0006\u0010$\u001a\u00020%H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006*"}, d2 = {"Lcom/nothing/earbase/os/control/OSVoiceAssistantSelectDialog;", "Lcom/nothing/base/view/BaseDialogFragment;", "Lcom/nothing/ear/databinding/OsVoiceAssistantDialogBinding;", "viewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "eventHandler", "Lcom/nothing/earbase/os/control/ControlOperationActivity;", "address", "", "<init>", "(Lcom/nothing/earbase/control/ControlOperationViewModel;Lcom/nothing/earbase/control/ControlGestureViewModel;Lcom/nothing/earbase/os/control/ControlOperationActivity;Ljava/lang/String;)V", "getViewModel", "()Lcom/nothing/earbase/control/ControlOperationViewModel;", "getItemViewModel", "()Lcom/nothing/earbase/control/ControlGestureViewModel;", "getEventHandler", "()Lcom/nothing/earbase/os/control/ControlOperationActivity;", "getAddress", "()Ljava/lang/String;", "createContentConfig", "", "contentConfig", "Lcom/nothing/base/view/BaseConfig;", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "setDefaultBackground", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "onStart", "onInitContentBinding", "onClickChatGpt", "onClickDefaultVoice", "setSelectChatGpt", "selectGpt", "", "confirmSetSelectChatGpt", "activity", "Lcom/nothing/base/view/BaseActivity;", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OSVoiceAssistantSelectDialog extends BaseDialogFragment<OsVoiceAssistantDialogBinding> {
    public static final float MARGIN = 48.0f;
    private final String address;
    private final ControlOperationActivity eventHandler;
    private final ControlGestureViewModel itemViewModel;
    private final ControlOperationViewModel viewModel;

    @Override // com.nothing.base.view.BaseDialogFragment
    public void setDefaultBackground(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
    }

    public final ControlOperationViewModel getViewModel() {
        return this.viewModel;
    }

    public final ControlGestureViewModel getItemViewModel() {
        return this.itemViewModel;
    }

    public final ControlOperationActivity getEventHandler() {
        return this.eventHandler;
    }

    public final String getAddress() {
        return this.address;
    }

    public OSVoiceAssistantSelectDialog(ControlOperationViewModel viewModel, ControlGestureViewModel itemViewModel, ControlOperationActivity eventHandler, String address) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Intrinsics.checkNotNullParameter(address, "address");
        this.viewModel = viewModel;
        this.itemViewModel = itemViewModel;
        this.eventHandler = eventHandler;
        this.address = address;
    }

    @Override // com.nothing.base.view.BaseDialogFragment
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        contentConfig.setLayoutId(R.layout.os_voice_assistant_dialog).addVariable(BR.viewModel, this.viewModel).addVariable(BR.itemViewModel, this.itemViewModel).addVariable(BR.eventHandler, this);
    }

    public final void show(FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.show(manager, "set_chat_gpt");
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        int screenWidth = ScreenUtils.getScreenWidth();
        Context context = getMBinding().getRoot().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int iDp2px = screenWidth - ContextExtKt.dp2px(context, 48.0f);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(iDp2px, -2);
    }

    @Override // com.nothing.base.view.BaseDialogFragment
    public void onInitContentBinding(BaseActivityBinding rootBinding) {
        Window window;
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        super.onInitContentBinding(rootBinding);
        rootBinding.getRoot().setBackgroundColor(0);
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    public final void onClickChatGpt() {
        if (Intrinsics.areEqual((Object) this.viewModel.getVoiceAssistantEnable().get(), (Object) true) && Intrinsics.areEqual((Object) this.viewModel.getVoiceAssistantChatGptSelected().get(), (Object) false)) {
            setSelectChatGpt(true);
        }
    }

    public final void onClickDefaultVoice() {
        if (Intrinsics.areEqual((Object) this.viewModel.getVoiceAssistantDefaultSelected().get(), (Object) false)) {
            setSelectChatGpt(false);
        }
    }

    private final void setSelectChatGpt(final boolean selectGpt) {
        if (getContext() instanceof BaseActivity) {
            Context context = getContext();
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.nothing.base.view.BaseActivity<*>");
            final BaseActivity<?> baseActivity = (BaseActivity) context;
            if (this.eventHandler.getVoiceAssistantCount() >= 2 && !VoiceAssistantUtil.INSTANCE.isShowDeviceTips()) {
                ConfirmMsgViewModel confirmMsgViewModel = new ConfirmMsgViewModel();
                confirmMsgViewModel.getTitle().set(getString(R.string.voice_ai_title));
                confirmMsgViewModel.getMsg().set(getString(R.string.voice_assistant_summary));
                confirmMsgViewModel.getPositionBtn().set(getString(R.string.understood));
                confirmMsgViewModel.getNegativeBtn().set(getString(R.string.cancel));
                BaseActivity.showConfirmMsgDialog$default(baseActivity, confirmMsgViewModel, new Function0() { // from class: com.nothing.earbase.os.control.OSVoiceAssistantSelectDialog$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OSVoiceAssistantSelectDialog.setSelectChatGpt$lambda$3$lambda$1(this.f$0, baseActivity, selectGpt);
                    }
                }, new Function0() { // from class: com.nothing.earbase.os.control.OSVoiceAssistantSelectDialog$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                }, null, false, 24, null);
                return;
            }
            confirmSetSelectChatGpt(baseActivity, selectGpt);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSelectChatGpt$lambda$3$lambda$1(OSVoiceAssistantSelectDialog oSVoiceAssistantSelectDialog, BaseActivity baseActivity, boolean z) {
        oSVoiceAssistantSelectDialog.confirmSetSelectChatGpt(baseActivity, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.os.control.OSVoiceAssistantSelectDialog$confirmSetSelectChatGpt$1, reason: invalid class name */
    /* JADX INFO: compiled from: OSVoiceAssistantSelectDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.os.control.OSVoiceAssistantSelectDialog$confirmSetSelectChatGpt$1", f = "OSVoiceAssistantSelectDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ BaseActivity<?> $activity;
        final /* synthetic */ boolean $selectGpt;
        int label;
        final /* synthetic */ OSVoiceAssistantSelectDialog this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseActivity<?> baseActivity, OSVoiceAssistantSelectDialog oSVoiceAssistantSelectDialog, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = baseActivity;
            this.this$0 = oSVoiceAssistantSelectDialog;
            this.$selectGpt = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$activity, this.this$0, this.$selectGpt, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GptProviderHelper.INSTANCE.insertOrUpdate(this.$activity, this.this$0.getAddress(), this.$selectGpt, true);
            return Unit.INSTANCE;
        }
    }

    private final void confirmSetSelectChatGpt(BaseActivity<?> activity, boolean selectGpt) {
        String str;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(activity, this, selectGpt, null), 2, null);
        AppBuriedPointUtils appBuriedPointUtils = AppBuriedPointUtils.INSTANCE;
        if (selectGpt) {
            str = "1";
        } else {
            str = "0";
        }
        AppBuriedPointUtils.reportData$default(appBuriedPointUtils, new EventParams(AppBuriedPointUtils.CHANGE_CONTROL_GPT, str, AppBuriedPointUtils.VALUE_TYPE_INT), null, false, null, 14, null);
        for (ControlOperationViewModel controlOperationViewModel : this.itemViewModel.getOperationList()) {
            if (controlOperationViewModel.isVoiceAssistant(controlOperationViewModel.getOperation()) && Intrinsics.areEqual((Object) controlOperationViewModel.getSelected().get(), (Object) true)) {
                controlOperationViewModel.setSelectChatGpt(selectGpt);
                VoiceAssistantUtil.INSTANCE.setSelectChatGpt(selectGpt);
            }
        }
        this.viewModel.getVoiceAssistantChatGptSelected().set(Boolean.valueOf(selectGpt));
        this.viewModel.getVoiceAssistantDefaultSelected().set(Boolean.valueOf(!selectGpt));
    }
}
