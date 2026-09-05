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
import com.nothing.girafarig.equalizer.DiracEQGuideDialog;
import com.nothing.girafarig.equalizer.EqualizerViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class GirafarigDiracEqGuideDialogBinding extends ViewDataBinding {
    public final RoundLinearLayout contentView;

    @Bindable
    protected DiracEQGuideDialog mEventHandler;

    @Bindable
    protected EqualizerViewModel mViewModel;
    public final RoundTextView secondText;
    public final TextView tvSummary;
    public final TextView tvTitle;

    public abstract void setEventHandler(DiracEQGuideDialog eventHandler);

    public abstract void setViewModel(EqualizerViewModel viewModel);

    protected GirafarigDiracEqGuideDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RoundLinearLayout contentView, RoundTextView secondText, TextView tvSummary, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.contentView = contentView;
        this.secondText = secondText;
        this.tvSummary = tvSummary;
        this.tvTitle = tvTitle;
    }

    public EqualizerViewModel getViewModel() {
        return this.mViewModel;
    }

    public DiracEQGuideDialog getEventHandler() {
        return this.mEventHandler;
    }

    public static GirafarigDiracEqGuideDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GirafarigDiracEqGuideDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (GirafarigDiracEqGuideDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.girafarig_dirac_eq_guide_dialog, root, attachToRoot, component);
    }

    public static GirafarigDiracEqGuideDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GirafarigDiracEqGuideDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (GirafarigDiracEqGuideDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.girafarig_dirac_eq_guide_dialog, null, false, component);
    }

    public static GirafarigDiracEqGuideDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static GirafarigDiracEqGuideDialogBinding bind(View view, Object component) {
        return (GirafarigDiracEqGuideDialogBinding) bind(component, view, R.layout.girafarig_dirac_eq_guide_dialog);
    }
}
