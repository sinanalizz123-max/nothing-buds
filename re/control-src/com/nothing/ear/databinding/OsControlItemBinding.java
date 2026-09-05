package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.os.control.OsControlActivity;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class OsControlItemBinding extends ViewDataBinding {

    @Bindable
    protected OsControlActivity mEventHandler;

    @Bindable
    protected ControlGestureViewModel mViewModel;
    public final AppCompatTextView tvTitle;

    public abstract void setEventHandler(OsControlActivity eventHandler);

    public abstract void setViewModel(ControlGestureViewModel viewModel);

    protected OsControlItemBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.tvTitle = tvTitle;
    }

    public ControlGestureViewModel getViewModel() {
        return this.mViewModel;
    }

    public OsControlActivity getEventHandler() {
        return this.mEventHandler;
    }

    public static OsControlItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (OsControlItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.os_control_item, root, attachToRoot, component);
    }

    public static OsControlItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlItemBinding inflate(LayoutInflater inflater, Object component) {
        return (OsControlItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.os_control_item, null, false, component);
    }

    public static OsControlItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OsControlItemBinding bind(View view, Object component) {
        return (OsControlItemBinding) bind(component, view, R.layout.os_control_item);
    }
}
