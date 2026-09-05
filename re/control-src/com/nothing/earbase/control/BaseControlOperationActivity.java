package com.nothing.earbase.control;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.BaseActivity;
import com.nothing.database.util.SpUtils;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.earbase.control.entity.ControlConfigurationEntity;
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

/* JADX INFO: compiled from: BaseControlOperationActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0007H\u0014J\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0014\u0010\u0019\u001a\u00020\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0018\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0018\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0016\u0010!\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016\u00a8\u0006\""}, d2 = {"Lcom/nothing/earbase/control/BaseControlOperationActivity;", "Binding", "Landroidx/databinding/ViewDataBinding;", "Lcom/nothing/base/view/BaseActivity;", "<init>", "()V", "onInitStatusBar", "", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "rightLabelClickEvent", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "onInitContentBinding", "getCurrentMacAddress", "", "onDestroy", "onClickChatGpt", "viewModel", "Lcom/nothing/earbase/control/ControlOperationViewModel;", "itemViewModel", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "getVoiceAssistantCount", "", "checkHasSelectAssistant", "gesture", "Landroidx/databinding/ObservableArrayList;", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "setSelectChatGpt", "selectGpt", "", "confirmSelectVoiceAssistant", "onClickDefaultVoiceAssistant", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseControlOperationActivity<Binding extends ViewDataBinding> extends BaseActivity<Binding> {
    public int getVoiceAssistantCount() {
        return 0;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void rightLabelClickEvent() {
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitStatusBar(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        FrameLayout frameLayout = rootBinding.rootView;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        frameLayout.setPadding(0, ContextExtKt.getStatusBarHeight(resources), 0, 0);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitContentBinding(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
        VoiceAssistantUtil.INSTANCE.initParameters(getCurrentMacAddress());
        super.onInitContentBinding(rootBinding);
    }

    public final String getCurrentMacAddress() {
        Bundle extras = getIntent().getExtras();
        String string = extras != null ? extras.getString("device_address") : null;
        String str = string;
        return (str == null || str.length() == 0) ? SpUtils.INSTANCE.getSelectDeviceMac() : string;
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        VoiceAssistantUtil.INSTANCE.resetParameters();
    }

    public final void onClickChatGpt(ControlOperationViewModel viewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        if (Intrinsics.areEqual((Object) viewModel.getVoiceAssistantEnable().get(), (Object) true) && Intrinsics.areEqual((Object) viewModel.getVoiceAssistantChatGptSelected().get(), (Object) false)) {
            setSelectChatGpt(true, itemViewModel);
        }
    }

    public final int checkHasSelectAssistant(ObservableArrayList<CommonBindingMoreType> gesture) {
        Intrinsics.checkNotNullParameter(gesture, "gesture");
        int i = 0;
        for (CommonBindingMoreType commonBindingMoreType : gesture) {
            if (commonBindingMoreType instanceof ControlGestureViewModel) {
                VoiceAssistantUtil voiceAssistantUtil = VoiceAssistantUtil.INSTANCE;
                ControlConfigurationEntity.Operation options = ((ControlGestureViewModel) commonBindingMoreType).getOptions();
                if (voiceAssistantUtil.isVoiceAssistant(options != null ? options.getOperation() : 0)) {
                    i++;
                }
            }
        }
        return i;
    }

    private final void setSelectChatGpt(final boolean selectGpt, final ControlGestureViewModel itemViewModel) {
        if (getVoiceAssistantCount() >= 2 && !VoiceAssistantUtil.INSTANCE.isShowDeviceTips()) {
            ConfirmMsgViewModel confirmMsgViewModel = new ConfirmMsgViewModel();
            confirmMsgViewModel.getTitle().set(getString(R.string.voice_ai_title));
            confirmMsgViewModel.getMsg().set(getString(R.string.voice_assistant_summary));
            confirmMsgViewModel.getPositionBtn().set(getString(R.string.understood));
            confirmMsgViewModel.getNegativeBtn().set(getString(R.string.cancel));
            BaseActivity.showConfirmMsgDialog$default(this, confirmMsgViewModel, new Function0() { // from class: com.nothing.earbase.control.BaseControlOperationActivity$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return BaseControlOperationActivity.setSelectChatGpt$lambda$2(this.f$0, selectGpt, itemViewModel);
                }
            }, new Function0() { // from class: com.nothing.earbase.control.BaseControlOperationActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            }, null, false, 24, null);
            return;
        }
        confirmSelectVoiceAssistant(selectGpt, itemViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setSelectChatGpt$lambda$2(BaseControlOperationActivity baseControlOperationActivity, boolean z, ControlGestureViewModel controlGestureViewModel) {
        baseControlOperationActivity.confirmSelectVoiceAssistant(z, controlGestureViewModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.nothing.earbase.control.BaseControlOperationActivity$confirmSelectVoiceAssistant$1, reason: invalid class name */
    /* JADX INFO: compiled from: BaseControlOperationActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.nothing.earbase.control.BaseControlOperationActivity$confirmSelectVoiceAssistant$1", f = "BaseControlOperationActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $selectGpt;
        int label;
        final /* synthetic */ BaseControlOperationActivity<Binding> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BaseControlOperationActivity<Binding> baseControlOperationActivity, boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = baseControlOperationActivity;
            this.$selectGpt = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$selectGpt, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String str;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            GptProviderHelper.INSTANCE.insertOrUpdate(this.this$0, SpUtils.INSTANCE.getSelectDeviceMac(), this.$selectGpt, true);
            AppBuriedPointUtils appBuriedPointUtils = AppBuriedPointUtils.INSTANCE;
            if (this.$selectGpt) {
                str = "1";
            } else {
                str = "0";
            }
            AppBuriedPointUtils.reportData$default(appBuriedPointUtils, new EventParams(AppBuriedPointUtils.CHANGE_CONTROL_GPT, str, AppBuriedPointUtils.VALUE_TYPE_INT), null, false, null, 14, null);
            return Unit.INSTANCE;
        }
    }

    private final void confirmSelectVoiceAssistant(boolean selectGpt, ControlGestureViewModel itemViewModel) {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, selectGpt, null), 2, null);
        for (ControlOperationViewModel controlOperationViewModel : itemViewModel.getOperationList()) {
            if (controlOperationViewModel.isVoiceAssistant(controlOperationViewModel.getOperation()) && Intrinsics.areEqual((Object) controlOperationViewModel.getSelected().get(), (Object) true)) {
                controlOperationViewModel.setSelectChatGpt(selectGpt);
                VoiceAssistantUtil.INSTANCE.setSelectChatGpt(selectGpt);
            }
        }
    }

    public final void onClickDefaultVoiceAssistant(ControlOperationViewModel viewModel, ControlGestureViewModel itemViewModel) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(itemViewModel, "itemViewModel");
        if (Intrinsics.areEqual((Object) viewModel.getVoiceAssistantDefaultSelected().get(), (Object) false)) {
            setSelectChatGpt(false, itemViewModel);
        }
    }
}
