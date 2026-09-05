package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.gligar.control.ControlCaseOperationActivity;
import com.nothing.gligar.control.ControlViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class GligarControlCaseOperationActivityBindingImpl extends GligarControlCaseOperationActivityBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_top, 4);
        sparseIntArray.put(R.id.case_lottie, 5);
        sparseIntArray.put(R.id.tv_left, 6);
        sparseIntArray.put(R.id.ll_operation, 7);
        sparseIntArray.put(R.id.rv_operation, 8);
    }

    public GligarControlCaseOperationActivityBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private GligarControlCaseOperationActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (LottieAnimationView) bindings[5], (ConstraintLayout) bindings[4], (AppCompatImageView) bindings[1], (AppCompatImageView) bindings[2], (LinearLayoutCompat) bindings[7], (RecyclerView) bindings[8], (AppCompatTextView) bindings[6], (AppCompatTextView) bindings[3]);
        this.mDirtyFlags = -1L;
        this.ivLeft.setTag(null);
        this.ivTitle.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        this.tvTitle.setTag(null);
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
        if (BR.eventHandler == variableId) {
            setEventHandler((ControlCaseOperationActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.GligarControlCaseOperationActivityBinding
    public void setEventHandler(ControlCaseOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
    }

    @Override // com.nothing.ear.databinding.GligarControlCaseOperationActivityBinding
    public void setViewModel(ControlViewModel ViewModel) {
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
            return onChangeViewModelSelectedItemViewModelGestureName((ObservableField) object, fieldId);
        }
        if (localFieldId == 1) {
            return onChangeViewModelSelectedItemViewModelGestureIndexTitleRes((ObservableField) object, fieldId);
        }
        if (localFieldId == 2) {
            return onChangeViewModelSelectedItemViewModel((ObservableField) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return onChangeViewModelCaseSelectedRes((ObservableField) object, fieldId);
    }

    private boolean onChangeViewModelSelectedItemViewModelGestureName(ObservableField<String> ViewModelSelectedItemViewModelGestureName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelSelectedItemViewModelGestureIndexTitleRes(ObservableField<Integer> ViewModelSelectedItemViewModelGestureIndexTitleRes, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelSelectedItemViewModel(ObservableField<ControlGestureViewModel> ViewModelSelectedItemViewModel, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelCaseSelectedRes(ObservableField<Integer> ViewModelCaseSelectedRes, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0052  */
    /* JADX WARN: Code duplicated, block: B:34:0x006e  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Integer num;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlViewModel controlViewModel = this.mViewModel;
        ObservableField<Integer> caseSelectedRes = null;
        if ((111 & j) != 0) {
            if ((103 & j) != 0) {
                ObservableField<ControlGestureViewModel> selectedItemViewModel = controlViewModel != null ? controlViewModel.getSelectedItemViewModel() : null;
                updateRegistration(2, selectedItemViewModel);
                ControlGestureViewModel controlGestureViewModel = selectedItemViewModel != null ? selectedItemViewModel.get() : null;
                if ((j & 101) == 0) {
                    str = null;
                } else {
                    ObservableField<String> gestureName = controlGestureViewModel != null ? controlGestureViewModel.getGestureName() : null;
                    updateRegistration(0, gestureName);
                    if (gestureName != null) {
                        str = gestureName.get();
                    } else {
                        str = null;
                    }
                }
                if ((j & 102) == 0) {
                    num = null;
                } else {
                    ObservableField<Integer> gestureIndexTitleRes = controlGestureViewModel != null ? controlGestureViewModel.getGestureIndexTitleRes() : null;
                    updateRegistration(1, gestureIndexTitleRes);
                    if (gestureIndexTitleRes != null) {
                        num = gestureIndexTitleRes.get();
                    } else {
                        num = null;
                    }
                }
            } else {
                num = null;
                str = null;
            }
            if ((j & 104) != 0) {
                caseSelectedRes = controlViewModel != null ? controlViewModel.getCaseSelectedRes() : null;
                updateRegistration(3, caseSelectedRes);
                if (caseSelectedRes != null) {
                    caseSelectedRes.get();
                }
            }
        } else {
            num = null;
            str = null;
        }
        if ((104 & j) != 0) {
            BindingAdapter.setGlideImg(this.ivLeft, caseSelectedRes);
        }
        if ((102 & j) != 0) {
            BindingAdapter.setRes(this.ivTitle, num);
        }
        if ((j & 101) != 0) {
            TextViewBindingAdapter.setText(this.tvTitle, str);
        }
    }
}
