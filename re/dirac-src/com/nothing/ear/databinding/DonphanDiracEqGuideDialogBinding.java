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
import com.nothing.donphan.equalizer.DiracEQGuideDialog;
import com.nothing.donphan.equalizer.EqualizerViewModel;
import com.nothing.ear.R;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class DonphanDiracEqGuideDialogBinding extends ViewDataBinding {
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

    protected DonphanDiracEqGuideDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, RoundLinearLayout contentView, RoundTextView secondText, TextView tvSummary, TextView tvTitle) {
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

    public static DonphanDiracEqGuideDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DonphanDiracEqGuideDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DonphanDiracEqGuideDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.donphan_dirac_eq_guide_dialog, root, attachToRoot, component);
    }

    public static DonphanDiracEqGuideDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DonphanDiracEqGuideDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (DonphanDiracEqGuideDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.donphan_dirac_eq_guide_dialog, null, false, component);
    }

    public static DonphanDiracEqGuideDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DonphanDiracEqGuideDialogBinding bind(View view, Object component) {
        return (DonphanDiracEqGuideDialogBinding) bind(component, view, R.layout.donphan_dirac_eq_guide_dialog);
    }
}
