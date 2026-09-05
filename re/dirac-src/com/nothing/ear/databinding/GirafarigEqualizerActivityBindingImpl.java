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
import com.nothing.girafarig.equalizer.EqualizerActivity;
import com.nothing.girafarig.equalizer.EqualizerViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class GirafarigEqualizerActivityBindingImpl extends GirafarigEqualizerActivityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.v_bottom, 5);
    }

    public GirafarigEqualizerActivityBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private GirafarigEqualizerActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (RecyclerView) bindings[3], (AppCompatTextView) bindings[1], (TextView) bindings[4], (View) bindings[5], (EQDragView) bindings[2]);
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
            this.mDirtyFlags = 16L;
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

    @Override // com.nothing.ear.databinding.GirafarigEqualizerActivityBinding
    public void setEventHandler(EqualizerActivity EventHandler) {
        this.mEventHandler = EventHandler;
    }

    @Override // com.nothing.ear.databinding.GirafarigEqualizerActivityBinding
    public void setViewModel(EqualizerViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        if (localFieldId == 0) {
            return onChangeViewModelPowerByText((ObservableField) object, fieldId);
        }
        if (localFieldId != 1) {
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

    private boolean onChangeViewModelRadarResId(ObservableField<Integer> ViewModelRadarResId, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b8  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ObservableField<Integer> observableField;
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
        if ((27 & j) != 0) {
            if ((j & 25) == 0) {
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
            if ((j & 26) != 0) {
                if (equalizerViewModel != null) {
                    radarResId = equalizerViewModel.getRadarResId();
                    diracEQRes = equalizerViewModel.getDiracEQRes();
                }
                updateRegistration(1, radarResId);
                if (radarResId != null) {
                    radarResId.get();
                }
            }
            observableField = radarResId;
            spannableStringBuilder2 = spannableStringBuilder;
        } else {
            observableField = null;
        }
        if ((16 & j) != 0) {
            BindingAdapter.setHeightAdapt(this.rvSound, null, null, 20, null, null, null, false, null, null, null, null);
            BindingAdapter.setHeightAdapt(this.vRadar, null, null, 20, null, null, null, false, null, null, null, null);
            if (getBuildSdkInt() >= 4) {
                this.tvEqTips.setContentDescription(this.tvEqTips.getResources().getString(R.string.desc_prefix, this.tvEqTips.getResources().getString(R.string.sound_equaliser_tips_cus)));
            }
        }
        if ((j & 25) != r4) {
            TextViewBindingAdapter.setText(this.tvPowerBy, spannableStringBuilder2);
        }
        if ((j & 26) != 0) {
            EQDragView.setRadaStyle(this.vRadar, observableField, Integer.valueOf(diracEQRes), 0.0f);
        }
    }
}
