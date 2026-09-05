package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class EarTwosControlNotCustomisableItemBinding extends ViewDataBinding {
    public final AppCompatImageView ivArrowRight;
    public final AppCompatImageView ivTitle;

    @Bindable
    protected ControlGestureViewModel mViewModel;
    public final AppCompatTextView tvTitle;

    public abstract void setViewModel(ControlGestureViewModel viewModel);

    protected EarTwosControlNotCustomisableItemBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageView ivArrowRight, AppCompatImageView ivTitle, AppCompatTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivArrowRight = ivArrowRight;
        this.ivTitle = ivTitle;
        this.tvTitle = tvTitle;
    }

    public ControlGestureViewModel getViewModel() {
        return this.mViewModel;
    }

    public static EarTwosControlNotCustomisableItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EarTwosControlNotCustomisableItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (EarTwosControlNotCustomisableItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ear_twos_control_not_customisable_item, root, attachToRoot, component);
    }

    public static EarTwosControlNotCustomisableItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EarTwosControlNotCustomisableItemBinding inflate(LayoutInflater inflater, Object component) {
        return (EarTwosControlNotCustomisableItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.ear_twos_control_not_customisable_item, null, false, component);
    }

    public static EarTwosControlNotCustomisableItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EarTwosControlNotCustomisableItemBinding bind(View view, Object component) {
        return (EarTwosControlNotCustomisableItemBinding) bind(component, view, R.layout.ear_twos_control_not_customisable_item);
    }
}
