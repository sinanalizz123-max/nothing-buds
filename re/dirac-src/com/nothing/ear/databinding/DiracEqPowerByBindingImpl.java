package com.nothing.ear.databinding;

import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.nothing.donphan.equalizer.EqualizerViewModel;
import com.nothing.ear.BR;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class DiracEqPowerByBindingImpl extends DiracEqPowerByBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    public DiracEqPowerByBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds));
    }

    private DiracEqPowerByBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1, (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.tvPowerBy.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((EqualizerViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.DiracEqPowerByBinding
    public void setViewModel(EqualizerViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId != 0) {
            return false;
        }
        return onChangeViewModelPowerByText((ObservableField) object, fieldId);
    }

    private boolean onChangeViewModelPowerByText(ObservableField<SpannableStringBuilder> ViewModelPowerByText, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        EqualizerViewModel equalizerViewModel = this.mViewModel;
        long j2 = j & 7;
        SpannableStringBuilder spannableStringBuilder = null;
        if (j2 != 0) {
            ObservableField<SpannableStringBuilder> powerByText = equalizerViewModel != null ? equalizerViewModel.getPowerByText() : null;
            updateRegistration(0, powerByText);
            if (powerByText != null) {
                spannableStringBuilder = powerByText.get();
            }
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.tvPowerBy, spannableStringBuilder);
        }
    }
}
