package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.donphan.control.ControlItemViewModel;
import com.nothing.donphan.control.ControlOperationActivity;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlOperationViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class DonphanControlDialogItemBinding extends ViewDataBinding {

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

    protected DonphanControlDialogItemBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView notTitle) {
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

    public static DonphanControlDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DonphanControlDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DonphanControlDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.donphan_control_dialog_item, root, attachToRoot, component);
    }

    public static DonphanControlDialogItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DonphanControlDialogItemBinding inflate(LayoutInflater inflater, Object component) {
        return (DonphanControlDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.donphan_control_dialog_item, null, false, component);
    }

    public static DonphanControlDialogItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DonphanControlDialogItemBinding bind(View view, Object component) {
        return (DonphanControlDialogItemBinding) bind(component, view, R.layout.donphan_control_dialog_item);
    }
}
