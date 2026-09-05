package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.os.control.OSVoiceAssistantSelectDialog;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class OsVoiceAssistantDialogBinding extends ViewDataBinding {
    public final TextView body;
    public final AppCompatTextView chatGpt;
    public final LinearLayout llChatGpt;

    @Bindable
    protected OSVoiceAssistantSelectDialog mEventHandler;

    @Bindable
    protected ControlGestureViewModel mItemViewModel;

    @Bindable
    protected ControlOperationViewModel mViewModel;
    public final AppCompatTextView tvDefault;
    public final TextView tvTitle;

    public abstract void setEventHandler(OSVoiceAssistantSelectDialog eventHandler);

    public abstract void setItemViewModel(ControlGestureViewModel itemViewModel);

    public abstract void setViewModel(ControlOperationViewModel viewModel);

    protected OsVoiceAssistantDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView body, AppCompatTextView chatGpt, LinearLayout llChatGpt, AppCompatTextView tvDefault, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.body = body;
        this.chatGpt = chatGpt;
        this.llChatGpt = llChatGpt;
        this.tvDefault = tvDefault;
        this.tvTitle = tvTitle;
    }

    public ControlOperationViewModel getViewModel() {
        return this.mViewModel;
    }

    public ControlGestureViewModel getItemViewModel() {
        return this.mItemViewModel;
    }

    public OSVoiceAssistantSelectDialog getEventHandler() {
        return this.mEventHandler;
    }

    public static OsVoiceAssistantDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsVoiceAssistantDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (OsVoiceAssistantDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.os_voice_assistant_dialog, root, attachToRoot, component);
    }

    public static OsVoiceAssistantDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsVoiceAssistantDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (OsVoiceAssistantDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.os_voice_assistant_dialog, null, false, component);
    }

    public static OsVoiceAssistantDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsVoiceAssistantDialogBinding bind(View view, Object component) {
        return (OsVoiceAssistantDialogBinding) bind(component, view, R.layout.os_voice_assistant_dialog);
    }
}
