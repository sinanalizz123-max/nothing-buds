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
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.earbase.unknown.UnknownEqualizerActivity;
import com.nothing.earbase.unknown.UnknownSimpleActivityViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class UnknownEqualizerActivityBindingImpl extends UnknownEqualizerActivityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.v_bottom, 6);
    }

    public UnknownEqualizerActivityBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private UnknownEqualizerActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3, (RecyclerView) bindings[4], (AppCompatTextView) bindings[1], (TextView) bindings[5], (View) bindings[6], (EQDragView) bindings[2], (EQDragView) bindings[3]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
        this.rvSound.setTag(null);
        this.tvEqTips.setTag(null);
        this.tvPowerBy.setTag(null);
        this.vRadar.setTag(null);
        this.vRadar1.setTag(null);
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
            setEventHandler((UnknownEqualizerActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((UnknownSimpleActivityViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.UnknownEqualizerActivityBinding
    public void setEventHandler(UnknownEqualizerActivity EventHandler) {
        this.mEventHandler = EventHandler;
    }

    @Override // com.nothing.ear.databinding.UnknownEqualizerActivityBinding
    public void setViewModel(UnknownSimpleActivityViewModel ViewModel) {
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
            return onChangeViewModelRadarResId((ObservableField) object, fieldId);
        }
        if (localFieldId != 2) {
            return false;
        }
        return onChangeViewModelIsCmfEq((ObservableField) object, fieldId);
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

    private boolean onChangeViewModelRadarResId(ObservableField<Integer> ViewModelRadarResId, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelIsCmfEq(ObservableField<Boolean> ViewModelIsCmfEq, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0035  */
    /* JADX WARN: Code duplicated, block: B:42:0x00f3  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        int diracEQRes;
        Boolean bool;
        ObservableField<Integer> radarResId;
        SpannableStringBuilder spannableStringBuilder;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        UnknownSimpleActivityViewModel unknownSimpleActivityViewModel = this.mViewModel;
        boolean z = false;
        SpannableStringBuilder spannableStringBuilder2 = null;
        Boolean bool2 = null;
        if ((55 & j) != 0) {
            if ((j & 49) == 0) {
                spannableStringBuilder = null;
            } else {
                ObservableField<SpannableStringBuilder> powerByText = unknownSimpleActivityViewModel != null ? unknownSimpleActivityViewModel.getPowerByText() : null;
                updateRegistration(0, powerByText);
                if (powerByText != null) {
                    spannableStringBuilder = powerByText.get();
                } else {
                    spannableStringBuilder = null;
                }
            }
            j2 = 0;
            if ((j & 50) != 0) {
                if (unknownSimpleActivityViewModel != null) {
                    radarResId = unknownSimpleActivityViewModel.getRadarResId();
                    diracEQRes = unknownSimpleActivityViewModel.getDiracEQRes();
                } else {
                    diracEQRes = 0;
                    radarResId = null;
                }
                updateRegistration(1, radarResId);
                if (radarResId != null) {
                    radarResId.get();
                }
            } else {
                diracEQRes = 0;
                radarResId = null;
            }
            if ((j & 52) != 0) {
                ObservableField<Boolean> observableFieldIsCmfEq = unknownSimpleActivityViewModel != null ? unknownSimpleActivityViewModel.isCmfEq() : null;
                updateRegistration(2, observableFieldIsCmfEq);
                bool2 = observableFieldIsCmfEq != null ? observableFieldIsCmfEq.get() : null;
                z = !ViewDataBinding.safeUnbox(bool2);
            }
            bool = bool2;
            spannableStringBuilder2 = spannableStringBuilder;
        } else {
            j2 = 0;
            diracEQRes = 0;
            bool = null;
            radarResId = null;
        }
        if ((j & 32) != j2) {
            BindingAdapter.setHeightAdapt(this.rvSound, null, null, 20, null, null, null, false, null, null, null, null);
            BindingAdapter.setHeightAdapt(this.vRadar, null, null, 20, null, null, null, false, null, null, null, null);
            BindingAdapter.setHeightAdapt(this.vRadar1, null, null, 20, null, null, null, false, null, null, null, null);
            if (getBuildSdkInt() >= 4) {
                this.tvEqTips.setContentDescription(this.tvEqTips.getResources().getString(R.string.desc_prefix, this.tvEqTips.getResources().getString(R.string.sound_equaliser_tips_cus)));
            }
        }
        if ((j & 49) != j2) {
            TextViewBindingAdapter.setText(this.tvPowerBy, spannableStringBuilder2);
        }
        if ((j & 52) != j2) {
            BindingAdapter.invisibleUnless(this.vRadar, bool);
            BindingAdapter.invisibleUnless(this.vRadar1, Boolean.valueOf(z));
        }
        if ((j & 50) != j2) {
            EQDragView.setRadaStyle(this.vRadar, radarResId, Integer.valueOf(diracEQRes), 0.0f);
            EQDragView.setRadaStyle(this.vRadar1, radarResId, Integer.valueOf(diracEQRes), 0.0f);
        }
    }
}
