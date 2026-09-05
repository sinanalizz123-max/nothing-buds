package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.espeon.control.ControlCaseOperationActivity;
import com.nothing.espeon.control.ControlItemViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class EspeonControlCaseDialogItemBinding extends ViewDataBinding {

    @Bindable
    protected ControlCaseOperationActivity mEventHandler;

    @Bindable
    protected ControlItemViewModel mItemViewModel;

    @Bindable
    protected ControlOperationViewModel mViewModel;
    public final TextView notTitle;

    public abstract void setEventHandler(ControlCaseOperationActivity eventHandler);

    public abstract void setItemViewModel(ControlItemViewModel itemViewModel);

    public abstract void setViewModel(ControlOperationViewModel viewModel);

    protected EspeonControlCaseDialogItemBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView notTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.notTitle = notTitle;
    }

    public ControlOperationViewModel getViewModel() {
        return this.mViewModel;
    }

    public ControlItemViewModel getItemViewModel() {
        return this.mItemViewModel;
    }

    public ControlCaseOperationActivity getEventHandler() {
        return this.mEventHandler;
    }

    public static EspeonControlCaseDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EspeonControlCaseDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (EspeonControlCaseDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.espeon_control_case_dialog_item, root, attachToRoot, component);
    }

    public static EspeonControlCaseDialogItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EspeonControlCaseDialogItemBinding inflate(LayoutInflater inflater, Object component) {
        return (EspeonControlCaseDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.espeon_control_case_dialog_item, null, false, component);
    }

    public static EspeonControlCaseDialogItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EspeonControlCaseDialogItemBinding bind(View view, Object component) {
        return (EspeonControlCaseDialogItemBinding) bind(component, view, R.layout.espeon_control_case_dialog_item);
    }
}
