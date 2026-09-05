package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.R;
import com.nothing.ear.twos.control.ControlItemViewModel;
import com.nothing.ear.twos.control.ControlOperationActivity;
import com.nothing.earbase.control.ControlOperationViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class EarTwosControlDialogItemBinding extends ViewDataBinding {

    @Bindable
    protected ControlOperationActivity mEventHandler;

    @Bindable
    protected ControlItemViewModel mItemViewModel;

    @Bindable
    protected ControlOperationViewModel mViewModel;
    public final TextView notTitle;

    public abstract void setEventHandler(ControlOperationActivity eventHandler);

    public abstract void setItemViewModel(ControlItemViewModel itemViewModel);

    public abstract void setViewModel(ControlOperationViewModel viewModel);

    protected EarTwosControlDialogItemBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView notTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.notTitle = notTitle;
    }

    public ControlOperationViewModel getViewModel() {
        return this.mViewModel;
    }

    public ControlItemViewModel getItemViewModel() {
        return this.mItemViewModel;
    }

    public ControlOperationActivity getEventHandler() {
        return this.mEventHandler;
    }

    public static EarTwosControlDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EarTwosControlDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (EarTwosControlDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ear_twos_control_dialog_item, root, attachToRoot, component);
    }

    public static EarTwosControlDialogItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EarTwosControlDialogItemBinding inflate(LayoutInflater inflater, Object component) {
        return (EarTwosControlDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ear_twos_control_dialog_item, null, false, component);
    }

    public static EarTwosControlDialogItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EarTwosControlDialogItemBinding bind(View view, Object component) {
        return (EarTwosControlDialogItemBinding) bind(component, view, R.layout.ear_twos_control_dialog_item);
    }
}
