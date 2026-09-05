package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.nothing.ear.BR;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.os.control.ControlOperationActivity;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class OsControlDialogItemBindingImpl extends OsControlDialogItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback310;
    private final View.OnClickListener mCallback311;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayoutCompat mboundView2;
    private final RadioButton mboundView3;
    private final ImageView mboundView4;
    private final ImageView mboundView5;
    private final TextView mboundView6;

    public OsControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }

    private OsControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (View) bindings[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[2];
        this.mboundView2 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        RadioButton radioButton = (RadioButton) bindings[3];
        this.mboundView3 = radioButton;
        radioButton.setTag(null);
        ImageView imageView = (ImageView) bindings[4];
        this.mboundView4 = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) bindings[5];
        this.mboundView5 = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) bindings[6];
        this.mboundView6 = textView;
        textView.setTag(null);
        this.rectangle5.setTag(null);
        setRootTag(root);
        this.mCallback310 = new OnClickListener(this, 1);
        this.mCallback311 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 2048L;
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
            setEventHandler((ControlOperationActivity) variable);
            return true;
        }
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

    @Override // com.nothing.ear.databinding.OsControlDialogItemBinding
    public void setEventHandler(ControlOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.OsControlDialogItemBinding
    public void setItemViewModel(ControlGestureViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.OsControlDialogItemBinding
    public void setViewModel(ControlOperationViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelOperationName((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelNewsPromptName((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelSelected((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelCallEnable((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelNewsPromptVisibility((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelNoiseControlVisible((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelEnable((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelVoiceAssistantVisible((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelOperationName(ObservableField<String> ViewModelOperationName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelNewsPromptName(ObservableField<String> ViewModelNewsPromptName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelSelected(ObservableField<Boolean> ViewModelSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelCallEnable(ObservableField<Boolean> ViewModelCallEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelNewsPromptVisibility(ObservableField<Boolean> ViewModelNewsPromptVisibility, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseControlVisible(ObservableField<Boolean> ViewModelNoiseControlVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelEnable(ObservableField<Boolean> ViewModelEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantVisible(ObservableField<Boolean> ViewModelVoiceAssistantVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r14v1 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException
        */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nothing.ear.databinding.OsControlDialogItemBindingImpl.executeBindings():void");
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            ControlGestureViewModel controlGestureViewModel = this.mItemViewModel;
            ControlOperationActivity controlOperationActivity = this.mEventHandler;
            ControlOperationViewModel controlOperationViewModel = this.mViewModel;
            if (controlOperationActivity != null) {
                controlOperationActivity.onSelectedOperation(controlOperationViewModel, controlGestureViewModel);
                return;
            }
            return;
        }
        if (sourceId != 2) {
            return;
        }
        ControlGestureViewModel controlGestureViewModel2 = this.mItemViewModel;
        ControlOperationActivity controlOperationActivity2 = this.mEventHandler;
        ControlOperationViewModel controlOperationViewModel2 = this.mViewModel;
        if (controlOperationActivity2 != null) {
            controlOperationActivity2.onClickNoiseSetting(controlOperationViewModel2, controlGestureViewModel2);
        }
    }
}
