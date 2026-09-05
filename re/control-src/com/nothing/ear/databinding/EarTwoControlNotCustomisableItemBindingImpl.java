package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.ear.BR;
import com.nothing.earbase.control.ControlGestureViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class EarTwoControlNotCustomisableItemBindingImpl extends EarTwoControlNotCustomisableItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final AppCompatTextView mboundView3;

    public EarTwoControlNotCustomisableItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }

    private EarTwoControlNotCustomisableItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4, (AppCompatImageView) bindings[4], (AppCompatImageView) bindings[1], (AppCompatTextView) bindings[2]);
        this.mDirtyFlags = -1L;
        this.ivArrowRight.setTag(null);
        this.ivTitle.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[3];
        this.mboundView3 = appCompatTextView;
        appCompatTextView.setTag(null);
        this.tvTitle.setTag(null);
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
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlGestureViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.EarTwoControlNotCustomisableItemBinding
    public void setViewModel(ControlGestureViewModel ViewModel) {
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
            return onChangeViewModelGestureIndexRes((ObservableField) object, fieldId);
        }
        if (localFieldId == 1) {
            return onChangeViewModelOperationName((ObservableField) object, fieldId);
        }
        if (localFieldId == 2) {
            return onChangeViewModelGestureName((ObservableField) object, fieldId);
        }
        if (localFieldId != 3) {
            return false;
        }
        return onChangeViewModelArrowVisible((ObservableField) object, fieldId);
    }

    private boolean onChangeViewModelGestureIndexRes(ObservableField<Integer> ViewModelGestureIndexRes, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelOperationName(ObservableField<String> ViewModelOperationName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelGestureName(ObservableField<String> ViewModelGestureName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelArrowVisible(ObservableField<Integer> ViewModelArrowVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0039  */
    /* JADX WARN: Code duplicated, block: B:29:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x006b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0070  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0081  */
    /* JADX WARN: Code duplicated, block: B:39:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x008d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0092  */
    /* JADX WARN: Code duplicated, block: B:44:0x009a  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        String str;
        String str2;
        Integer num;
        ObservableField<Integer> arrowVisible;
        ObservableField<String> gestureName;
        ObservableField<String> operationName;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlGestureViewModel controlGestureViewModel = this.mViewModel;
        int iSafeUnbox = 0;
        if ((63 & j) != 0) {
            if ((j & 49) == 0) {
                num = null;
            } else {
                ObservableField<Integer> gestureIndexRes = controlGestureViewModel != null ? controlGestureViewModel.getGestureIndexRes() : null;
                updateRegistration(0, gestureIndexRes);
                if (gestureIndexRes != null) {
                    num = gestureIndexRes.get();
                } else {
                    num = null;
                }
            }
            if ((j & 50) != 0) {
                if (controlGestureViewModel != null) {
                    operationName = controlGestureViewModel.getOperationName();
                    j2 = 0;
                } else {
                    j2 = 0;
                    operationName = null;
                }
                updateRegistration(1, operationName);
                if (operationName != null) {
                    str = operationName.get();
                }
                if ((j & 52) != j2) {
                    if (controlGestureViewModel != null) {
                        gestureName = controlGestureViewModel.getGestureName();
                    } else {
                        gestureName = null;
                    }
                    j3 = 52;
                    updateRegistration(2, gestureName);
                    if (gestureName != null) {
                        str2 = gestureName.get();
                    }
                    if ((j & 56) != j2) {
                        if (controlGestureViewModel != null) {
                            arrowVisible = controlGestureViewModel.getArrowVisible();
                        } else {
                            arrowVisible = null;
                        }
                        updateRegistration(3, arrowVisible);
                        iSafeUnbox = ViewDataBinding.safeUnbox(arrowVisible != null ? arrowVisible.get() : null);
                    }
                } else {
                    j3 = 52;
                }
                str2 = null;
                if ((j & 56) != j2) {
                    if (controlGestureViewModel != null) {
                        arrowVisible = controlGestureViewModel.getArrowVisible();
                    } else {
                        arrowVisible = null;
                    }
                    updateRegistration(3, arrowVisible);
                    iSafeUnbox = ViewDataBinding.safeUnbox(arrowVisible != null ? arrowVisible.get() : null);
                }
            } else {
                j2 = 0;
            }
            str = null;
            if ((j & 52) != j2) {
                if (controlGestureViewModel != null) {
                    gestureName = controlGestureViewModel.getGestureName();
                } else {
                    gestureName = null;
                }
                j3 = 52;
                updateRegistration(2, gestureName);
                if (gestureName != null) {
                    str2 = gestureName.get();
                }
                if ((j & 56) != j2) {
                    if (controlGestureViewModel != null) {
                        arrowVisible = controlGestureViewModel.getArrowVisible();
                    } else {
                        arrowVisible = null;
                    }
                    updateRegistration(3, arrowVisible);
                    iSafeUnbox = ViewDataBinding.safeUnbox(arrowVisible != null ? arrowVisible.get() : null);
                }
            } else {
                j3 = 52;
            }
            str2 = null;
            if ((j & 56) != j2) {
                if (controlGestureViewModel != null) {
                    arrowVisible = controlGestureViewModel.getArrowVisible();
                } else {
                    arrowVisible = null;
                }
                updateRegistration(3, arrowVisible);
                iSafeUnbox = ViewDataBinding.safeUnbox(arrowVisible != null ? arrowVisible.get() : null);
            }
        } else {
            j2 = 0;
            j3 = 52;
            str = null;
            str2 = null;
            num = null;
        }
        if ((j & 56) != j2) {
            this.ivArrowRight.setVisibility(iSafeUnbox);
        }
        if ((j & 49) != j2) {
            BindingAdapter.setRes(this.ivTitle, num);
        }
        if ((j & 50) != j2) {
            TextViewBindingAdapter.setText(this.mboundView3, str);
        }
        if ((32 & j) != j2) {
            BindingAdapter.textLineHeight(this.mboundView3, 22);
            BindingAdapter.textLineHeight(this.tvTitle, 24);
        }
        if ((j & j3) != j2) {
            TextViewBindingAdapter.setText(this.tvTitle, str2);
        }
    }
}
