package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.elekid.control.ControlItemViewModel;
import com.nothing.elekid.control.ControlOperationActivity;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class ElekidControlDialogItemBinding extends ViewDataBinding {
    public final AppCompatImageView ivArrowRight;

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

    protected ElekidControlDialogItemBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView ivArrowRight, TextView notTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivArrowRight = ivArrowRight;
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

    public static ElekidControlDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ElekidControlDialogItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ElekidControlDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.elekid_control_dialog_item, root, attachToRoot, component);
    }

    public static ElekidControlDialogItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ElekidControlDialogItemBinding inflate(LayoutInflater inflater, Object component) {
        return (ElekidControlDialogItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.elekid_control_dialog_item, null, false, component);
    }

    public static ElekidControlDialogItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ElekidControlDialogItemBinding bind(View view, Object component) {
        return (ElekidControlDialogItemBinding) bind(component, view, R.layout.elekid_control_dialog_item);
    }
}
