package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.os.control.OSVoiceAssistantSelectDialog;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class OsVoiceAssistantDialogBindingImpl extends OsVoiceAssistantDialogBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback217;
    private final View.OnClickListener mCallback218;
    private long mDirtyFlags;
    private final RoundLinearLayout mboundView0;
    private final AppCompatTextView mboundView4;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 6);
    }

    public OsVoiceAssistantDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private OsVoiceAssistantDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 5, (TextView) bindings[1], (AppCompatTextView) bindings[3], (LinearLayout) bindings[2], (AppCompatTextView) bindings[5], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        this.body.setTag(null);
        this.chatGpt.setTag(null);
        this.llChatGpt.setTag(null);
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) bindings[0];
        this.mboundView0 = roundLinearLayout;
        roundLinearLayout.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[4];
        this.mboundView4 = appCompatTextView;
        appCompatTextView.setTag(null);
        this.tvDefault.setTag(null);
        setRootTag(root);
        this.mCallback217 = new OnClickListener(this, 1);
        this.mCallback218 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (BR.eventHandler == variableId) {
            setEventHandler((OSVoiceAssistantSelectDialog) variable);
            return true;
        }
        if (BR.itemViewModel == variableId) {
            setItemViewModel((ControlGestureViewModel) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlOperationViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.OsVoiceAssistantDialogBinding
    public void setEventHandler(OSVoiceAssistantSelectDialog EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.OsVoiceAssistantDialogBinding
    public void setItemViewModel(ControlGestureViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.OsVoiceAssistantDialogBinding
    public void setViewModel(ControlOperationViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return onChangeViewModelChatGptUnableText((ObservableField) object, fieldId);
        }
        if (localFieldId == 1) {
            return onChangeViewModelVoiceAssistantChatGptSelected((ObservableField) object, fieldId);
        }
        if (localFieldId == 2) {
            return onChangeViewModelVoiceAssistantEnable((ObservableField) object, fieldId);
        }
        if (localFieldId == 3) {
            return onChangeViewModelVoiceAssistantDefaultSelected((ObservableField) object, fieldId);
        }
        if (localFieldId != 4) {
            return false;
        }
        return onChangeItemViewModelChatGptSummary((ObservableField) object, fieldId);
    }

    private boolean onChangeViewModelChatGptUnableText(ObservableField<String> ViewModelChatGptUnableText, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantChatGptSelected(ObservableField<Boolean> ViewModelVoiceAssistantChatGptSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantEnable(ObservableField<Boolean> ViewModelVoiceAssistantEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantDefaultSelected(ObservableField<Boolean> ViewModelVoiceAssistantDefaultSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeItemViewModelChatGptSummary(ObservableField<String> ItemViewModelChatGptSummary, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e  */
    /* JADX WARN: Code duplicated, block: B:25:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0079  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        long j2;
        Boolean bool;
        String str2;
        float f;
        Boolean bool2;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        OSVoiceAssistantSelectDialog oSVoiceAssistantSelectDialog = this.mEventHandler;
        ControlGestureViewModel controlGestureViewModel = this.mItemViewModel;
        ControlOperationViewModel controlOperationViewModel = this.mViewModel;
        long j3 = 336;
        Boolean bool3 = null;
        if ((j & 336) == 0) {
            str = null;
        } else {
            ObservableField<String> chatGptSummary = controlGestureViewModel != null ? controlGestureViewModel.getChatGptSummary() : null;
            updateRegistration(4, chatGptSummary);
            if (chatGptSummary != null) {
                str = chatGptSummary.get();
            } else {
                str = null;
            }
        }
        float f2 = 0.0f;
        if ((399 & j) != 0) {
            j2 = 0;
            if ((j & 385) == 0) {
                str2 = null;
            } else {
                ObservableField<String> chatGptUnableText = controlOperationViewModel != null ? controlOperationViewModel.getChatGptUnableText() : null;
                updateRegistration(0, chatGptUnableText);
                if (chatGptUnableText != null) {
                    str2 = chatGptUnableText.get();
                } else {
                    str2 = null;
                }
            }
            if ((j & 386) == 0) {
                bool2 = null;
            } else {
                ObservableField<Boolean> voiceAssistantChatGptSelected = controlOperationViewModel != null ? controlOperationViewModel.getVoiceAssistantChatGptSelected() : null;
                updateRegistration(1, voiceAssistantChatGptSelected);
                if (voiceAssistantChatGptSelected != null) {
                    bool2 = voiceAssistantChatGptSelected.get();
                } else {
                    bool2 = null;
                }
            }
            long j4 = j & 388;
            if (j4 != 0) {
                ObservableField<Boolean> voiceAssistantEnable = controlOperationViewModel != null ? controlOperationViewModel.getVoiceAssistantEnable() : null;
                updateRegistration(2, voiceAssistantEnable);
                boolean z = ViewDataBinding.safeUnbox(voiceAssistantEnable != null ? voiceAssistantEnable.get() : null);
                if (j4 != 0) {
                    j |= z ? 1024L : 512L;
                }
                f2 = z ? 1.0f : 0.38f;
            } else {
                j3 = 336;
            }
            if ((j & 392) != 0) {
                ObservableField<Boolean> voiceAssistantDefaultSelected = controlOperationViewModel != null ? controlOperationViewModel.getVoiceAssistantDefaultSelected() : null;
                updateRegistration(3, voiceAssistantDefaultSelected);
                if (voiceAssistantDefaultSelected != null) {
                    bool3 = voiceAssistantDefaultSelected.get();
                }
            }
            bool = bool3;
            f = f2;
            bool3 = bool2;
        } else {
            j2 = 0;
            j3 = 336;
            bool = null;
            str2 = null;
            f = 0.0f;
        }
        if ((j & j3) != j2) {
            TextViewBindingAdapter.setText(this.body, str);
        }
        if ((j & 386) != j2) {
            BindingAdapter.viewSelected(this.chatGpt, bool3);
        }
        if ((j & 388) != j2 && getBuildSdkInt() >= 11) {
            this.llChatGpt.setAlpha(f);
        }
        if ((256 & j) != j2) {
            BindingAdapter.onClick((ViewGroup) this.llChatGpt, this.mCallback217);
            BindingAdapter.onClick(this.tvDefault, this.mCallback218);
        }
        if ((j & 385) != j2) {
            TextViewBindingAdapter.setText(this.mboundView4, str2);
        }
        if ((j & 392) != j2) {
            BindingAdapter.viewSelected(this.tvDefault, bool);
        }
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        OSVoiceAssistantSelectDialog oSVoiceAssistantSelectDialog;
        if (sourceId != 1) {
            if (sourceId == 2 && (oSVoiceAssistantSelectDialog = this.mEventHandler) != null) {
                oSVoiceAssistantSelectDialog.onClickDefaultVoice();
                return;
            }
            return;
        }
        OSVoiceAssistantSelectDialog oSVoiceAssistantSelectDialog2 = this.mEventHandler;
        if (oSVoiceAssistantSelectDialog2 != null) {
            oSVoiceAssistantSelectDialog2.onClickChatGpt();
        }
    }
}
