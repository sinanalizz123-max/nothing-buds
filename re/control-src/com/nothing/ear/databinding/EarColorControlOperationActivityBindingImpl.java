package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Space;
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
import com.nothing.ear.color.control.ControlOperationActivity;
import com.nothing.ear.color.control.ControlViewModel;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.earbase.control.ControlGestureViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class EarColorControlOperationActivityBindingImpl extends EarColorControlOperationActivityBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private final View.OnClickListener mCallback87;
    private final View.OnClickListener mCallback88;
    private final View.OnClickListener mCallback89;
    private final View.OnClickListener mCallback90;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.cl_top, 7);
        sparseIntArray.put(R.id.left_lottie, 8);
        sparseIntArray.put(R.id.space_left, 9);
        sparseIntArray.put(R.id.space_right, 10);
        sparseIntArray.put(R.id.right_lottie, 11);
        sparseIntArray.put(R.id.center_line, 12);
        sparseIntArray.put(R.id.ll_operation, 13);
        sparseIntArray.put(R.id.rv_operation, 14);
    }

    public EarColorControlOperationActivityBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private EarColorControlOperationActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 7, (View) bindings[12], (ConstraintLayout) bindings[7], (AppCompatImageView) bindings[1], (AppCompatImageView) bindings[2], (AppCompatImageView) bindings[5], (LottieAnimationView) bindings[8], (LinearLayoutCompat) bindings[13], (LottieAnimationView) bindings[11], (RecyclerView) bindings[14], (Space) bindings[9], (Space) bindings[10], (AppCompatTextView) bindings[3], (AppCompatTextView) bindings[4], (AppCompatTextView) bindings[6]);
        this.mDirtyFlags = -1L;
        this.ivLeft.setTag(null);
        this.ivRight.setTag(null);
        this.ivTitle.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        this.tvLeft.setTag(null);
        this.tvRight.setTag(null);
        this.tvTitle.setTag(null);
        setRootTag(root);
        this.mCallback89 = new OnClickListener(this, 3);
        this.mCallback87 = new OnClickListener(this, 1);
        this.mCallback90 = new OnClickListener(this, 4);
        this.mCallback88 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 512L;
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
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.EarColorControlOperationActivityBinding
    public void setEventHandler(ControlOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.EarColorControlOperationActivityBinding
    public void setViewModel(ControlViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelRightTextVisible((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelLeftTextVisible((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelSelectedItemViewModel((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelSelectedItemViewModelGestureName((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelLeftSelectedRes((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelSelectedItemViewModelGestureIndexTitleRes((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelRightSelectedRes((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelRightTextVisible(ObservableField<Boolean> ViewModelRightTextVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelLeftTextVisible(ObservableField<Boolean> ViewModelLeftTextVisible, int fieldId) {
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

    private boolean onChangeViewModelSelectedItemViewModelGestureName(ObservableField<String> ViewModelSelectedItemViewModelGestureName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelLeftSelectedRes(ObservableField<Integer> ViewModelLeftSelectedRes, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelSelectedItemViewModelGestureIndexTitleRes(ObservableField<Integer> ViewModelSelectedItemViewModelGestureIndexTitleRes, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelRightSelectedRes(ObservableField<Integer> ViewModelRightSelectedRes, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0049 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x004b  */
    /* JADX WARN: Code duplicated, block: B:22:0x0050  */
    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:26:0x005f  */
    /* JADX WARN: Code duplicated, block: B:29:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x006b  */
    /* JADX WARN: Code duplicated, block: B:31:0x0070  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0081  */
    /* JADX WARN: Code duplicated, block: B:38:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x008b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0098  */
    /* JADX WARN: Code duplicated, block: B:44:0x009f  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:52:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:62:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:71:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:72:0x0103  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        long j4;
        ObservableField<Integer> rightSelectedRes;
        Boolean bool;
        Boolean bool2;
        Integer num;
        String str;
        ObservableField<Integer> leftSelectedRes;
        ObservableField<ControlGestureViewModel> selectedItemViewModel;
        ControlGestureViewModel controlGestureViewModel;
        ObservableField<Integer> gestureIndexTitleRes;
        ObservableField<String> gestureName;
        ObservableField<Boolean> leftTextVisible;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlOperationActivity controlOperationActivity = this.mEventHandler;
        ControlViewModel controlViewModel = this.mViewModel;
        if ((895 & j) != 0) {
            if ((j & 769) != 0) {
                ObservableField<Boolean> rightTextVisible = controlViewModel != null ? controlViewModel.getRightTextVisible() : null;
                j2 = 0;
                updateRegistration(0, rightTextVisible);
                if (rightTextVisible != null) {
                    bool = rightTextVisible.get();
                }
                if ((j & 770) == j2) {
                    bool2 = null;
                } else {
                    if (controlViewModel != null) {
                        leftTextVisible = controlViewModel.getLeftTextVisible();
                    } else {
                        leftTextVisible = null;
                    }
                    updateRegistration(1, leftTextVisible);
                    if (leftTextVisible != null) {
                        bool2 = leftTextVisible.get();
                    } else {
                        bool2 = null;
                    }
                }
                if ((j & 812) != j2) {
                    if (controlViewModel != null) {
                        selectedItemViewModel = controlViewModel.getSelectedItemViewModel();
                    } else {
                        selectedItemViewModel = null;
                    }
                    j4 = 780;
                    updateRegistration(2, selectedItemViewModel);
                    if (selectedItemViewModel != null) {
                        controlGestureViewModel = selectedItemViewModel.get();
                    } else {
                        controlGestureViewModel = null;
                    }
                    if ((j & 780) == j2) {
                        str = null;
                    } else {
                        if (controlGestureViewModel != null) {
                            gestureName = controlGestureViewModel.getGestureName();
                        } else {
                            gestureName = null;
                        }
                        updateRegistration(3, gestureName);
                        if (gestureName != null) {
                            str = gestureName.get();
                        } else {
                            str = null;
                        }
                    }
                    if ((j & 804) == j2) {
                        num = null;
                    } else {
                        if (controlGestureViewModel != null) {
                            gestureIndexTitleRes = controlGestureViewModel.getGestureIndexTitleRes();
                        } else {
                            gestureIndexTitleRes = null;
                        }
                        updateRegistration(5, gestureIndexTitleRes);
                        if (gestureIndexTitleRes != null) {
                            num = gestureIndexTitleRes.get();
                        } else {
                            num = null;
                        }
                    }
                } else {
                    j4 = 780;
                    num = null;
                    str = null;
                }
                if ((j & 784) != j2) {
                    if (controlViewModel != null) {
                        leftSelectedRes = controlViewModel.getLeftSelectedRes();
                    } else {
                        leftSelectedRes = null;
                    }
                    j3 = 804;
                    updateRegistration(4, leftSelectedRes);
                    if (leftSelectedRes != null) {
                        leftSelectedRes.get();
                    }
                } else {
                    j3 = 804;
                    leftSelectedRes = null;
                }
                if ((j & 832) != j2) {
                    if (controlViewModel != null) {
                        rightSelectedRes = controlViewModel.getRightSelectedRes();
                    } else {
                        rightSelectedRes = null;
                    }
                    updateRegistration(6, rightSelectedRes);
                    if (rightSelectedRes != null) {
                        rightSelectedRes.get();
                    }
                } else {
                    rightSelectedRes = null;
                }
            } else {
                j2 = 0;
            }
            bool = null;
            if ((j & 770) == j2) {
                bool2 = null;
            } else {
                if (controlViewModel != null) {
                    leftTextVisible = controlViewModel.getLeftTextVisible();
                } else {
                    leftTextVisible = null;
                }
                updateRegistration(1, leftTextVisible);
                if (leftTextVisible != null) {
                    bool2 = leftTextVisible.get();
                } else {
                    bool2 = null;
                }
            }
            if ((j & 812) != j2) {
                if (controlViewModel != null) {
                    selectedItemViewModel = controlViewModel.getSelectedItemViewModel();
                } else {
                    selectedItemViewModel = null;
                }
                j4 = 780;
                updateRegistration(2, selectedItemViewModel);
                if (selectedItemViewModel != null) {
                    controlGestureViewModel = selectedItemViewModel.get();
                } else {
                    controlGestureViewModel = null;
                }
                if ((j & 780) == j2) {
                    str = null;
                } else {
                    if (controlGestureViewModel != null) {
                        gestureName = controlGestureViewModel.getGestureName();
                    } else {
                        gestureName = null;
                    }
                    updateRegistration(3, gestureName);
                    if (gestureName != null) {
                        str = gestureName.get();
                    } else {
                        str = null;
                    }
                }
                if ((j & 804) == j2) {
                    num = null;
                } else {
                    if (controlGestureViewModel != null) {
                        gestureIndexTitleRes = controlGestureViewModel.getGestureIndexTitleRes();
                    } else {
                        gestureIndexTitleRes = null;
                    }
                    updateRegistration(5, gestureIndexTitleRes);
                    if (gestureIndexTitleRes != null) {
                        num = gestureIndexTitleRes.get();
                    } else {
                        num = null;
                    }
                }
            } else {
                j4 = 780;
                num = null;
                str = null;
            }
            if ((j & 784) != j2) {
                if (controlViewModel != null) {
                    leftSelectedRes = controlViewModel.getLeftSelectedRes();
                } else {
                    leftSelectedRes = null;
                }
                j3 = 804;
                updateRegistration(4, leftSelectedRes);
                if (leftSelectedRes != null) {
                    leftSelectedRes.get();
                }
            } else {
                j3 = 804;
                leftSelectedRes = null;
            }
            if ((j & 832) != j2) {
                if (controlViewModel != null) {
                    rightSelectedRes = controlViewModel.getRightSelectedRes();
                } else {
                    rightSelectedRes = null;
                }
                updateRegistration(6, rightSelectedRes);
                if (rightSelectedRes != null) {
                    rightSelectedRes.get();
                }
            } else {
                rightSelectedRes = null;
            }
        } else {
            j2 = 0;
            j3 = 804;
            j4 = 780;
            rightSelectedRes = null;
            bool = null;
            bool2 = null;
            num = null;
            str = null;
            leftSelectedRes = null;
        }
        if ((512 & j) != j2) {
            BindingAdapter.onClick(this.ivLeft, this.mCallback87);
            BindingAdapter.onClick(this.ivRight, this.mCallback88);
            BindingAdapter.onClick(this.tvLeft, this.mCallback89);
            BindingAdapter.onClick(this.tvRight, this.mCallback90);
        }
        if ((j & 784) != j2) {
            BindingAdapter.setGlideImg(this.ivLeft, leftSelectedRes);
        }
        if ((j & 832) != j2) {
            BindingAdapter.setGlideImg(this.ivRight, rightSelectedRes);
        }
        if ((j & j3) != j2) {
            BindingAdapter.setRes(this.ivTitle, num);
        }
        if ((j & 770) != j2) {
            BindingAdapter.goneUnless(this.tvLeft, bool2);
        }
        if ((j & 769) != j2) {
            BindingAdapter.goneUnless(this.tvRight, bool);
        }
        if ((j & j4) != j2) {
            TextViewBindingAdapter.setText(this.tvTitle, str);
        }
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            ControlOperationActivity controlOperationActivity = this.mEventHandler;
            ControlViewModel controlViewModel = this.mViewModel;
            if (controlOperationActivity != null) {
                controlOperationActivity.onClickLeft(controlViewModel);
                return;
            }
            return;
        }
        if (sourceId == 2) {
            ControlOperationActivity controlOperationActivity2 = this.mEventHandler;
            ControlViewModel controlViewModel2 = this.mViewModel;
            if (controlOperationActivity2 != null) {
                controlOperationActivity2.onClickRight(controlViewModel2);
                return;
            }
            return;
        }
        if (sourceId == 3) {
            ControlOperationActivity controlOperationActivity3 = this.mEventHandler;
            ControlViewModel controlViewModel3 = this.mViewModel;
            if (controlOperationActivity3 != null) {
                controlOperationActivity3.onClickLeft(controlViewModel3);
                return;
            }
            return;
        }
        if (sourceId != 4) {
            return;
        }
        ControlOperationActivity controlOperationActivity4 = this.mEventHandler;
        ControlViewModel controlViewModel4 = this.mViewModel;
        if (controlOperationActivity4 != null) {
            controlOperationActivity4.onClickRight(controlViewModel4);
        }
    }
}
