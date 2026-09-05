package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.os.control.ControlOperationActivity;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class OsControlDialogItemBinding extends ViewDataBinding {

    @Bindable
    protected ControlOperationActivity mEventHandler;

    @Bindable
    protected ControlGestureViewModel mItemViewModel;

    @Bindable
    protected ControlOperationViewModel mViewModel;
    public final View rectangle5;

    public abstract void setEventHandler(ControlOperationActivity eventHandler);

    public abstract void setItemViewModel(ControlGestureViewModel itemViewModel);

    public abstract void setViewModel(ControlOperationViewModel viewModel);

    protected OsControlDialogItemBinding(Object _bindingComponent, View _root, int _localFieldCount, View rectangle5) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rectangle5 = rectangle5;
    }

    public ControlOperationViewModel getViewModel() {
        return this.mViewModel;
    }

    public ControlGestureViewModel getItemViewModel() {
        return this.mItemViewModel;
    }

    public ControlOperationActivity getEventHandler() {
        return this.mEventHandler;
    }

    public static OsControlDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (OsControlDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.os_control_dialog_item, root, attachToRoot, component);
    }

    public static OsControlDialogItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlDialogItemBinding inflate(LayoutInflater inflater, Object component) {
        return (OsControlDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.os_control_dialog_item, null, false, component);
    }

    public static OsControlDialogItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlDialogItemBinding bind(View view, Object component) {
        return (OsControlDialogItemBinding) bind(component, view, R.layout.os_control_dialog_item);
    }
}
