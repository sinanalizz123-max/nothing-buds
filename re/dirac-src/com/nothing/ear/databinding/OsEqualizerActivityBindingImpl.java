package com.nothing.ear.databinding;

import android.text.SpannableStringBuilder;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.base.wiget.ActionView;
import com.nothing.base.wiget.radar.EQDragView;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.earbase.equalizer.viewmodel.BaseEqualizerViewModel;
import com.nothing.earbase.os.equalizer.OsEqualizerActivity;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class OsEqualizerActivityBindingImpl extends OsEqualizerActivityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.my_action, 5);
    }

    public OsEqualizerActivityBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private OsEqualizerActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (ActionView) bindings[5], (RecyclerView) bindings[3], (AppCompatTextView) bindings[1], (TextView) bindings[4], (EQDragView) bindings[2]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.rvSound.setTag(null);
        this.subtitle.setTag(null);
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
            setEventHandler((OsEqualizerActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((BaseEqualizerViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.OsEqualizerActivityBinding
    public void setEventHandler(OsEqualizerActivity EventHandler) {
        this.mEventHandler = EventHandler;
    }

    @Override // com.nothing.ear.databinding.OsEqualizerActivityBinding
    public void setViewModel(BaseEqualizerViewModel ViewModel) {
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

    /* JADX WARN: Code duplicated, block: B:26:0x004a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x004c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0060  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ObservableField<Integer> observableField;
        int i;
        SpannableStringBuilder spannableStringBuilder;
        boolean z;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        BaseEqualizerViewModel baseEqualizerViewModel = this.mViewModel;
        SpannableStringBuilder spannableStringBuilder2 = null;
        radarResId = null;
        ObservableField<Integer> radarResId = null;
        boolean z2 = false;
        diracEQRes = 0;
        int diracEQRes = 0;
        float sampleDesignSize = 0.0f;
        if ((27 & j) != 0) {
            if ((j & 25) != 0) {
                ObservableField<SpannableStringBuilder> powerByText = baseEqualizerViewModel != null ? baseEqualizerViewModel.getPowerByText() : null;
                updateRegistration(0, powerByText);
                spannableStringBuilder = powerByText != null ? powerByText.get() : null;
                if ((spannableStringBuilder != null ? spannableStringBuilder.length() : 0) != 0) {
                    z = true;
                }
                if ((j & 26) != 0) {
                    if (baseEqualizerViewModel != null) {
                        sampleDesignSize = baseEqualizerViewModel.getSampleDesignSize();
                        radarResId = baseEqualizerViewModel.getRadarResId();
                        diracEQRes = baseEqualizerViewModel.getDiracEQRes();
                    }
                    updateRegistration(1, radarResId);
                    if (radarResId != null) {
                        radarResId.get();
                    }
                }
                observableField = radarResId;
                spannableStringBuilder2 = spannableStringBuilder;
                i = diracEQRes;
                z2 = z;
            } else {
                spannableStringBuilder = null;
            }
            z = false;
            if ((j & 26) != 0) {
                if (baseEqualizerViewModel != null) {
                    sampleDesignSize = baseEqualizerViewModel.getSampleDesignSize();
                    radarResId = baseEqualizerViewModel.getRadarResId();
                    diracEQRes = baseEqualizerViewModel.getDiracEQRes();
                }
                updateRegistration(1, radarResId);
                if (radarResId != null) {
                    radarResId.get();
                }
            }
            observableField = radarResId;
            spannableStringBuilder2 = spannableStringBuilder;
            i = diracEQRes;
            z2 = z;
        } else {
            observableField = null;
            i = 0;
        }
        if ((16 & j) != 0) {
            BindingAdapter.setHeightAdapt(this.rvSound, null, null, 20, null, null, null, false, null, null, null, null);
            BindingAdapter.ndotFont57(this.subtitle, true);
        }
        if ((25 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvPowerBy, spannableStringBuilder2);
            BindingAdapter.goneUnless(this.tvPowerBy, Boolean.valueOf(z2));
        }
        if ((j & 26) != 0) {
            EQDragView.setRadaStyle(this.vRadar, observableField, Integer.valueOf(i), sampleDesignSize);
        }
    }
}
