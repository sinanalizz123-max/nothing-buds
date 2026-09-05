package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class OsControlNoiseDialogBindingImpl extends OsControlNoiseDialogBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final RoundLinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 5);
    }

    public OsControlNoiseDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private OsControlNoiseDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (AppCompatCheckBox) bindings[3], (AppCompatCheckBox) bindings[4], (AppCompatCheckBox) bindings[2], (TextView) bindings[1], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        this.ancNoiseControl.setTag(null);
        this.ancNoiseOff.setTag(null);
        this.ancNoiseTransparency.setTag(null);
        this.body.setTag(null);
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) bindings[0];
        this.mboundView0 = roundLinearLayout;
        roundLinearLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
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
        if (BR.itemViewModel == variableId) {
            setItemViewModel((ControlGestureViewModel) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlOperationViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.OsControlNoiseDialogBinding
    public void setItemViewModel(ControlGestureViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.OsControlNoiseDialogBinding
    public void setViewModel(ControlOperationViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return onChangeViewModelOffSelected((ObservableField) object, fieldId);
        }
        if (localFieldId == 1) {
            return onChangeViewModelNoiseCancellationSelected((ObservableField) object, fieldId);
        }
        if (localFieldId == 2) {
            return onChangeItemViewModelNoiseSummary((ObservableField) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return onChangeViewModelTransSelected((ObservableField) object, fieldId);
    }

    private boolean onChangeViewModelOffSelected(ObservableField<Boolean> ViewModelOffSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseCancellationSelected(ObservableField<Boolean> ViewModelNoiseCancellationSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeItemViewModelNoiseSummary(ObservableField<String> ItemViewModelNoiseSummary, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelTransSelected(ObservableField<Boolean> ViewModelTransSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002b  */
    /* JADX WARN: Code duplicated, block: B:52:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        boolean zSafeUnbox;
        boolean zSafeUnbox2;
        boolean zSafeUnbox3;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlGestureViewModel controlGestureViewModel = this.mItemViewModel;
        ControlOperationViewModel controlOperationViewModel = this.mViewModel;
        long j2 = 84 & j;
        if (j2 == 0) {
            str = null;
        } else {
            ObservableField<String> noiseSummary = controlGestureViewModel != null ? controlGestureViewModel.getNoiseSummary() : null;
            updateRegistration(2, noiseSummary);
            if (noiseSummary != null) {
                str = noiseSummary.get();
            } else {
                str = null;
            }
        }
        if ((107 & j) != 0) {
            if ((j & 97) != 0) {
                ObservableField<Boolean> offSelected = controlOperationViewModel != null ? controlOperationViewModel.getOffSelected() : null;
                updateRegistration(0, offSelected);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(offSelected != null ? offSelected.get() : null);
            } else {
                zSafeUnbox2 = false;
            }
            if ((j & 98) != 0) {
                ObservableField<Boolean> noiseCancellationSelected = controlOperationViewModel != null ? controlOperationViewModel.getNoiseCancellationSelected() : null;
                updateRegistration(1, noiseCancellationSelected);
                zSafeUnbox = ViewDataBinding.safeUnbox(noiseCancellationSelected != null ? noiseCancellationSelected.get() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 104) != 0) {
                ObservableField<Boolean> transSelected = controlOperationViewModel != null ? controlOperationViewModel.getTransSelected() : null;
                updateRegistration(3, transSelected);
                zSafeUnbox3 = ViewDataBinding.safeUnbox(transSelected != null ? transSelected.get() : null);
            }
            if ((j & 98) != 0) {
                CompoundButtonBindingAdapter.setChecked(this.ancNoiseControl, zSafeUnbox);
            }
            if ((j & 97) != 0) {
                CompoundButtonBindingAdapter.setChecked(this.ancNoiseOff, zSafeUnbox2);
            }
            if ((j & 104) != 0) {
                CompoundButtonBindingAdapter.setChecked(this.ancNoiseTransparency, zSafeUnbox3);
            }
            if (j2 != 0) {
                TextViewBindingAdapter.setText(this.body, str);
            }
        }
        zSafeUnbox = false;
        zSafeUnbox2 = false;
        zSafeUnbox3 = false;
        if ((j & 98) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.ancNoiseControl, zSafeUnbox);
        }
        if ((j & 97) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.ancNoiseOff, zSafeUnbox2);
        }
        if ((j & 104) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.ancNoiseTransparency, zSafeUnbox3);
        }
        if (j2 != 0) {
            TextViewBindingAdapter.setText(this.body, str);
        }
    }
}
