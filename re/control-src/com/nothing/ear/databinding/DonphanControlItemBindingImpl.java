package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableFloat;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.donphan.control.ControlActivity;
import com.nothing.ear.BR;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.earbase.control.ControlGestureViewModel;
import com.nothing.earbase.control.entity.ControlRadius;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class DonphanControlItemBindingImpl extends DonphanControlItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback207;
    private long mDirtyFlags;
    private final RoundLinearLayout mboundView0;
    private final ConstraintLayout mboundView1;
    private final AppCompatTextView mboundView4;

    public DonphanControlItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }

    private DonphanControlItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 6, (AppCompatImageView) bindings[5], (AppCompatImageView) bindings[2], (AppCompatTextView) bindings[3]);
        this.mDirtyFlags = -1L;
        this.ivArrowRight.setTag(null);
        this.ivTitle.setTag(null);
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) bindings[0];
        this.mboundView0 = roundLinearLayout;
        roundLinearLayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[1];
        this.mboundView1 = constraintLayout;
        constraintLayout.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[4];
        this.mboundView4 = appCompatTextView;
        appCompatTextView.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        this.mCallback207 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256L;
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
            setEventHandler((ControlActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlGestureViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.DonphanControlItemBinding
    public void setEventHandler(ControlActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.DonphanControlItemBinding
    public void setViewModel(ControlGestureViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 128;
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
            return onChangeViewModelArrowVisible((ObservableField) object, fieldId);
        }
        if (localFieldId == 3) {
            return onChangeViewModelGestureName((ObservableField) object, fieldId);
        }
        if (localFieldId == 4) {
            return onChangeViewModelItemDesc((ObservableField) object, fieldId);
        }
        if (localFieldId != 5) {
            return false;
        }
        return onChangeViewModelAlphaItem((ObservableFloat) object, fieldId);
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

    private boolean onChangeViewModelArrowVisible(ObservableField<Integer> ViewModelArrowVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelGestureName(ObservableField<String> ViewModelGestureName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelItemDesc(ObservableField<String> ViewModelItemDesc, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelAlphaItem(ObservableFloat ViewModelAlphaItem, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x005f  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00de A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f3  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        float f;
        String str;
        int i;
        Integer num;
        boolean zIsCanClick;
        ControlRadius direction;
        String str2;
        String str3;
        Integer num2;
        String str4;
        int iSafeUnbox;
        ObservableFloat alphaItem;
        ObservableField<String> itemDesc;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlActivity controlActivity = this.mEventHandler;
        ControlGestureViewModel controlGestureViewModel = this.mViewModel;
        long j4 = 392;
        float f2 = 0.0f;
        if ((447 & j) != 0) {
            if ((j & 385) == 0) {
                num2 = null;
            } else {
                ObservableField<Integer> gestureIndexRes = controlGestureViewModel != null ? controlGestureViewModel.getGestureIndexRes() : null;
                updateRegistration(0, gestureIndexRes);
                if (gestureIndexRes != null) {
                    num2 = gestureIndexRes.get();
                } else {
                    num2 = null;
                }
            }
            if ((j & 386) == 0) {
                str4 = null;
            } else {
                ObservableField<String> operationName = controlGestureViewModel != null ? controlGestureViewModel.getOperationName() : null;
                updateRegistration(1, operationName);
                if (operationName != null) {
                    str4 = operationName.get();
                } else {
                    str4 = null;
                }
            }
            if ((j & 388) != 0) {
                ObservableField<Integer> arrowVisible = controlGestureViewModel != null ? controlGestureViewModel.getArrowVisible() : null;
                j3 = 400;
                updateRegistration(2, arrowVisible);
                iSafeUnbox = ViewDataBinding.safeUnbox(arrowVisible != null ? arrowVisible.get() : null);
            } else {
                j3 = 400;
                iSafeUnbox = 0;
            }
            if ((j & 384) == 0 || controlGestureViewModel == null) {
                zIsCanClick = false;
                direction = null;
            } else {
                zIsCanClick = controlGestureViewModel.isCanClick();
                direction = controlGestureViewModel.getDirection();
            }
            if ((j & 392) != 0) {
                ObservableField<String> gestureName = controlGestureViewModel != null ? controlGestureViewModel.getGestureName() : null;
                updateRegistration(3, gestureName);
                str2 = gestureName != null ? gestureName.get() : null;
                if ((j & j3) == 0) {
                    str3 = null;
                } else {
                    if (controlGestureViewModel != null) {
                        itemDesc = controlGestureViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    updateRegistration(4, itemDesc);
                    if (itemDesc != null) {
                        str3 = itemDesc.get();
                    } else {
                        str3 = null;
                    }
                }
                if ((j & 416) != 0) {
                    if (controlGestureViewModel != null) {
                        alphaItem = controlGestureViewModel.getAlphaItem();
                    } else {
                        alphaItem = null;
                    }
                    j2 = 416;
                    updateRegistration(5, alphaItem);
                    if (alphaItem != null) {
                        f2 = alphaItem.get();
                    }
                } else {
                    j2 = 416;
                }
                str = str4;
                i = iSafeUnbox;
                num = num2;
                f = f2;
            } else {
                j4 = 392;
            }
            if ((j & j3) == 0) {
                str3 = null;
            } else {
                if (controlGestureViewModel != null) {
                    itemDesc = controlGestureViewModel.getItemDesc();
                } else {
                    itemDesc = null;
                }
                updateRegistration(4, itemDesc);
                if (itemDesc != null) {
                    str3 = itemDesc.get();
                } else {
                    str3 = null;
                }
            }
            if ((j & 416) != 0) {
                if (controlGestureViewModel != null) {
                    alphaItem = controlGestureViewModel.getAlphaItem();
                } else {
                    alphaItem = null;
                }
                j2 = 416;
                updateRegistration(5, alphaItem);
                if (alphaItem != null) {
                    f2 = alphaItem.get();
                }
            } else {
                j2 = 416;
            }
            str = str4;
            i = iSafeUnbox;
            num = num2;
            f = f2;
        } else {
            j4 = 392;
            j2 = 416;
            j3 = 400;
            f = 0.0f;
            str = null;
            i = 0;
            num = null;
            zIsCanClick = false;
            direction = null;
            str2 = null;
            str3 = null;
        }
        if ((j & 388) != 0) {
            this.ivArrowRight.setVisibility(i);
        }
        if ((j & 385) != 0) {
            BindingAdapter.setRes(this.ivTitle, num);
        }
        if ((j & 384) != 0) {
            BindingAdapter.viewRadius(this.mboundView0, direction);
            ViewBindingAdapter.setOnClick(this.mboundView1, this.mCallback207, zIsCanClick);
        }
        if ((j & j2) != 0 && getBuildSdkInt() >= 11) {
            this.mboundView1.setAlpha(f);
        }
        if ((j & 386) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str);
        }
        if ((256 & j) != 0) {
            BindingAdapter.textLineHeight(this.mboundView4, 22);
            BindingAdapter.textLineHeight(this.tvTitle, 24);
        }
        if ((j & j4) != 0) {
            TextViewBindingAdapter.setText(this.tvTitle, str2);
        }
        if ((j & j3) == 0 || getBuildSdkInt() < 4) {
            return;
        }
        this.tvTitle.setContentDescription(str3);
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        ControlActivity controlActivity = this.mEventHandler;
        ControlGestureViewModel controlGestureViewModel = this.mViewModel;
        if (controlActivity != null) {
            controlActivity.onClickItem(controlGestureViewModel);
        }
    }
}
