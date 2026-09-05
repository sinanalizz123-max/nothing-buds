package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.crobat.control.ControlActivity;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class CrobatControlItemBinding extends ViewDataBinding {
    public final AppCompatImageView ivArrowRight;
    public final AppCompatImageView ivTitle;

    @Bindable
    protected ControlActivity mEventHandler;

    @Bindable
    protected ControlGestureViewModel mViewModel;
    public final AppCompatTextView tvTitle;

    public abstract void setEventHandler(ControlActivity eventHandler);

    public abstract void setViewModel(ControlGestureViewModel viewModel);

    protected CrobatControlItemBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView ivArrowRight, AppCompatImageView ivTitle, AppCompatTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivArrowRight = ivArrowRight;
        this.ivTitle = ivTitle;
        this.tvTitle = tvTitle;
    }

    public ControlGestureViewModel getViewModel() {
        return this.mViewModel;
    }

    public ControlActivity getEventHandler() {
        return this.mEventHandler;
    }

    public static CrobatControlItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CrobatControlItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (CrobatControlItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.crobat_control_item, root, attachToRoot, component);
    }

    public static CrobatControlItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CrobatControlItemBinding inflate(LayoutInflater inflater, Object component) {
        return (CrobatControlItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.crobat_control_item, null, false, component);
    }

    public static CrobatControlItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static CrobatControlItemBinding bind(View view, Object component) {
        return (CrobatControlItemBinding) bind(component, view, R.layout.crobat_control_item);
    }
}
