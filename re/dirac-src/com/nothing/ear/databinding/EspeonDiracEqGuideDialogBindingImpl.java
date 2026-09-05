package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.base.wiget.RoundTextView;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.espeon.equalizer.DiracEQGuideDialog;
import com.nothing.espeon.equalizer.EqualizerViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class EspeonDiracEqGuideDialogBindingImpl extends EspeonDiracEqGuideDialogBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback138;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.content_view, 2);
        sparseIntArray.put(R.id.tv_title, 3);
        sparseIntArray.put(R.id.tv_summary, 4);
    }

    public EspeonDiracEqGuideDialogBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private EspeonDiracEqGuideDialogBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (RoundLinearLayout) bindings[2], (RoundTextView) bindings[1], (TextView) bindings[4], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        this.secondText.setTag(null);
        setRootTag(root);
        this.mCallback138 = new OnClickListener(this, 1);
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
        if (BR.eventHandler == variableId) {
            setEventHandler((DiracEQGuideDialog) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((EqualizerViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.EspeonDiracEqGuideDialogBinding
    public void setEventHandler(DiracEQGuideDialog EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.EspeonDiracEqGuideDialogBinding
    public void setViewModel(EqualizerViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        DiracEQGuideDialog diracEQGuideDialog = this.mEventHandler;
        if ((j & 4) != 0) {
            BindingAdapter.onClick(this.secondText, this.mCallback138);
        }
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        DiracEQGuideDialog diracEQGuideDialog = this.mEventHandler;
        if (diracEQGuideDialog != null) {
            diracEQGuideDialog.onClickPositive();
        }
    }
}
