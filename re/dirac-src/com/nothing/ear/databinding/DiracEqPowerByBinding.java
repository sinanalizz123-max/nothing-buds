package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.donphan.equalizer.EqualizerViewModel;
import com.nothing.ear.R;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class DiracEqPowerByBinding extends ViewDataBinding {

    @Bindable
    protected EqualizerViewModel mViewModel;
    public final TextView tvPowerBy;

    public abstract void setViewModel(EqualizerViewModel viewModel);

    protected DiracEqPowerByBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView tvPowerBy) {
        super(_bindingComponent, _root, _localFieldCount);
        this.tvPowerBy = tvPowerBy;
    }

    public EqualizerViewModel getViewModel() {
        return this.mViewModel;
    }

    public static DiracEqPowerByBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiracEqPowerByBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DiracEqPowerByBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dirac_eq_power_by, root, attachToRoot, component);
    }

    public static DiracEqPowerByBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiracEqPowerByBinding inflate(LayoutInflater inflater, Object component) {
        return (DiracEqPowerByBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dirac_eq_power_by, null, false, component);
    }

    public static DiracEqPowerByBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DiracEqPowerByBinding bind(View view, Object component) {
        return (DiracEqPowerByBinding) bind(component, view, R.layout.dirac_eq_power_by);
    }
}
