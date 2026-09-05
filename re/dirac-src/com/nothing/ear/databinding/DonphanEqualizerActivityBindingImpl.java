package com.nothing.ear.databinding;

import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.base.wiget.radar.EQDragView;
import com.nothing.donphan.equalizer.EqualizerActivity;
import com.nothing.donphan.equalizer.EqualizerViewModel;
import com.nothing.ear.BR;
import com.nothing.ear.R;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class DonphanEqualizerActivityBindingImpl extends DonphanEqualizerActivityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.v_bottom, 5);
    }

    public DonphanEqualizerActivityBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private DonphanEqualizerActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RecyclerView) bindings[3], (AppCompatTextView) bindings[1], (TextView) bindings[4], (View) bindings[5], (EQDragView) bindings[2]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.rvSound.setTag(null);
        this.tvEqTips.setTag(null);
        this.tvPowerBy.setTag(null);
        this.vRadar.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 32L;
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
        if (BR.eventHandler == variableId) {
            setEventHandler((EqualizerActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((EqualizerViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.DonphanEqualizerActivityBinding
    public void setEventHandler(EqualizerActivity EventHandler) {
        this.mEventHandler = EventHandler;
    }

    @Override // com.nothing.ear.databinding.DonphanEqualizerActivityBinding
    public void setViewModel(EqualizerViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return onChangeViewModelPowerByText((ObservableField) object, fieldId);
        }
        if (localFieldId == 1) {
            return onChangeViewModelHasDiracEq((ObservableField) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return onChangeViewModelRadarResId((ObservableField) object, fieldId);
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

    private boolean onChangeViewModelHasDiracEq(ObservableField<Boolean> ViewModelHasDiracEq, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelRadarResId(ObservableField<Integer> ViewModelRadarResId, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:29:0x005c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x00db  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        ObservableField<Integer> observableField;
        Boolean bool;
        SpannableStringBuilder spannableStringBuilder;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        EqualizerViewModel equalizerViewModel = this.mViewModel;
        int diracEQRes = 0;
        SpannableStringBuilder spannableStringBuilder2 = null;
        radarResId = null;
        ObservableField<Integer> radarResId = null;
        if ((55 & j) != 0) {
            if ((j & 49) == 0) {
                spannableStringBuilder = null;
            } else {
                ObservableField<SpannableStringBuilder> powerByText = equalizerViewModel != null ? equalizerViewModel.getPowerByText() : null;
                updateRegistration(0, powerByText);
                if (powerByText != null) {
                    spannableStringBuilder = powerByText.get();
                } else {
                    spannableStringBuilder = null;
                }
            }
            if ((j & 50) != 0) {
                ObservableField<Boolean> hasDiracEq = equalizerViewModel != null ? equalizerViewModel.getHasDiracEq() : null;
                j2 = 0;
                updateRegistration(1, hasDiracEq);
                if (hasDiracEq != null) {
                    bool = hasDiracEq.get();
                }
                if ((j & 52) != j2) {
                    if (equalizerViewModel != null) {
                        radarResId = equalizerViewModel.getRadarResId();
                        diracEQRes = equalizerViewModel.getDiracEQRes();
                    }
                    updateRegistration(2, radarResId);
                    if (radarResId != null) {
                        radarResId.get();
                    }
                }
                observableField = radarResId;
                spannableStringBuilder2 = spannableStringBuilder;
            } else {
                j2 = 0;
            }
            bool = null;
            if ((j & 52) != j2) {
                if (equalizerViewModel != null) {
                    radarResId = equalizerViewModel.getRadarResId();
                    diracEQRes = equalizerViewModel.getDiracEQRes();
                }
                updateRegistration(2, radarResId);
                if (radarResId != null) {
                    radarResId.get();
                }
            }
            observableField = radarResId;
            spannableStringBuilder2 = spannableStringBuilder;
        } else {
            j2 = 0;
            observableField = null;
            bool = null;
        }
        if ((32 & j) != j2) {
            BindingAdapter.setHeightAdapt(this.rvSound, null, null, 20, null, null, null, false, null, null, null, null);
            BindingAdapter.setHeightAdapt(this.vRadar, null, null, 20, null, null, null, false, null, null, null, null);
            if (getBuildSdkInt() >= 4) {
                this.tvEqTips.setContentDescription(this.tvEqTips.getResources().getString(R.string.desc_prefix, this.tvEqTips.getResources().getString(R.string.sound_equaliser_tips_cus)));
            }
        }
        if ((j & 49) != j2) {
            TextViewBindingAdapter.setText(this.tvPowerBy, spannableStringBuilder2);
        }
        if ((j & 50) != j2) {
            BindingAdapter.goneUnless(this.tvPowerBy, bool);
        }
        if ((j & 52) != j2) {
            EQDragView.setRadaStyle(this.vRadar, observableField, Integer.valueOf(diracEQRes), 0.0f);
        }
    }
}
