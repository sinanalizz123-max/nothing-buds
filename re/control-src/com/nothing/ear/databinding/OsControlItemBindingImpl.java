package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.nothing.ear.BR;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.os.control.OsControlActivity;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class OsControlItemBindingImpl extends OsControlItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback40;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;
    private final AppCompatTextView mboundView2;

    public OsControlItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }

    private OsControlItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2, (AppCompatTextView) bindings[1]);
        this.mDirtyFlags = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[2];
        this.mboundView2 = appCompatTextView;
        appCompatTextView.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        this.mCallback40 = new OnClickListener(this, 1);
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
            setEventHandler((OsControlActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlGestureViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.OsControlItemBinding
    public void setEventHandler(OsControlActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.OsControlItemBinding
    public void setViewModel(ControlGestureViewModel ViewModel) {
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
            return onChangeViewModelGestureName((ObservableField) object, fieldId);
        }
        if (localFieldId != 1) {
            return false;
        }
        return onChangeViewModelOperationName((ObservableField) object, fieldId);
    }

    private boolean onChangeViewModelGestureName(ObservableField<String> ViewModelGestureName, int fieldId) {
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

    /* JADX WARN: Code duplicated, block: B:16:0x0037  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        OsControlActivity osControlActivity = this.mEventHandler;
        ControlGestureViewModel controlGestureViewModel = this.mViewModel;
        boolean zIsCanClick = false;
        String str2 = null;
        if ((27 & j) != 0) {
            if ((j & 25) == 0) {
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
            if ((j & 26) != 0) {
                ObservableField<String> operationName = controlGestureViewModel != null ? controlGestureViewModel.getOperationName() : null;
                j2 = 0;
                updateRegistration(1, operationName);
                if (operationName != null) {
                    str2 = operationName.get();
                }
            } else {
                j2 = 0;
            }
            if ((j & 24) != j2 && controlGestureViewModel != null) {
                zIsCanClick = controlGestureViewModel.isCanClick();
            }
        } else {
            j2 = 0;
            str = null;
        }
        if ((j & 24) != j2) {
            ViewBindingAdapter.setOnClick(this.mboundView0, this.mCallback40, zIsCanClick);
            this.tvTitle.setEnabled(zIsCanClick);
        }
        if ((j & 26) != j2) {
            TextViewBindingAdapter.setText(this.mboundView2, str2);
        }
        if ((j & 25) != j2) {
            TextViewBindingAdapter.setText(this.tvTitle, str);
        }
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        OsControlActivity osControlActivity = this.mEventHandler;
        ControlGestureViewModel controlGestureViewModel = this.mViewModel;
        if (osControlActivity != null) {
            osControlActivity.onClickItem(controlGestureViewModel);
        }
    }
}
