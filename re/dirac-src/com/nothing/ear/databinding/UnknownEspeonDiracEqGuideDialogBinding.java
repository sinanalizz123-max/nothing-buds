package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.base.wiget.RoundTextView;
import com.nothing.ear.R;
import com.nothing.earbase.unknown.UnknownDiracEQGuideDialog;
import com.nothing.earbase.unknown.UnknownSimpleActivityViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class UnknownEspeonDiracEqGuideDialogBinding extends ViewDataBinding {
    public final RoundLinearLayout contentView;

    @Bindable
    protected UnknownDiracEQGuideDialog mEventHandler;

    @Bindable
    protected UnknownSimpleActivityViewModel mViewModel;
    public final RoundTextView secondText;
    public final TextView tvSummary;
    public final TextView tvTitle;

    public abstract void setEventHandler(UnknownDiracEQGuideDialog eventHandler);

    public abstract void setViewModel(UnknownSimpleActivityViewModel viewModel);

    protected UnknownEspeonDiracEqGuideDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RoundLinearLayout contentView, RoundTextView secondText, TextView tvSummary, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.contentView = contentView;
        this.secondText = secondText;
        this.tvSummary = tvSummary;
        this.tvTitle = tvTitle;
    }

    public UnknownSimpleActivityViewModel getViewModel() {
        return this.mViewModel;
    }

    public UnknownDiracEQGuideDialog getEventHandler() {
        return this.mEventHandler;
    }

    public static UnknownEspeonDiracEqGuideDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UnknownEspeonDiracEqGuideDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (UnknownEspeonDiracEqGuideDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.unknown_espeon_dirac_eq_guide_dialog, root, attachToRoot, component);
    }

    public static UnknownEspeonDiracEqGuideDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UnknownEspeonDiracEqGuideDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (UnknownEspeonDiracEqGuideDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.unknown_espeon_dirac_eq_guide_dialog, null, false, component);
    }

    public static UnknownEspeonDiracEqGuideDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static UnknownEspeonDiracEqGuideDialogBinding bind(View view, Object component) {
        return (UnknownEspeonDiracEqGuideDialogBinding) bind(component, view, R.layout.unknown_espeon_dirac_eq_guide_dialog);
    }
}
