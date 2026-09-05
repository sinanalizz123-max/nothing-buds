package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class OsControlNoiseDialogBinding extends ViewDataBinding {
    public final AppCompatCheckBox ancNoiseControl;
    public final AppCompatCheckBox ancNoiseOff;
    public final AppCompatCheckBox ancNoiseTransparency;
    public final TextView body;

    @Bindable
    protected ControlGestureViewModel mItemViewModel;

    @Bindable
    protected ControlOperationViewModel mViewModel;
    public final TextView tvTitle;

    public abstract void setItemViewModel(ControlGestureViewModel itemViewModel);

    public abstract void setViewModel(ControlOperationViewModel viewModel);

    protected OsControlNoiseDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatCheckBox ancNoiseControl, AppCompatCheckBox ancNoiseOff, AppCompatCheckBox ancNoiseTransparency, TextView body, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ancNoiseControl = ancNoiseControl;
        this.ancNoiseOff = ancNoiseOff;
        this.ancNoiseTransparency = ancNoiseTransparency;
        this.body = body;
        this.tvTitle = tvTitle;
    }

    public ControlOperationViewModel getViewModel() {
        return this.mViewModel;
    }

    public ControlGestureViewModel getItemViewModel() {
        return this.mItemViewModel;
    }

    public static OsControlNoiseDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlNoiseDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (OsControlNoiseDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.os_control_noise_dialog, root, attachToRoot, component);
    }

    public static OsControlNoiseDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlNoiseDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (OsControlNoiseDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.os_control_noise_dialog, null, false, component);
    }

    public static OsControlNoiseDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlNoiseDialogBinding bind(View view, Object component) {
        return (OsControlNoiseDialogBinding) bind(component, view, R.layout.os_control_noise_dialog);
    }
}
