package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.base.wiget.radar.EQInnerCircle;
import com.nothing.base.wiget.radar.EQLabelViewModel;
import com.nothing.base.wiget.radar.EQSeekBar;
import com.nothing.ear.BR;
import com.nothing.ear.R;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class EqRadarSeekLayoutBindingImpl extends EqRadarSeekLayoutBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;
    private final ConstraintLayout mboundView15;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.iv_cover, 16);
        sparseIntArray.put(R.id.iv_center, 17);
        sparseIntArray.put(R.id.iv_mask, 18);
        sparseIntArray.put(R.id.ll_pop, 19);
        sparseIntArray.put(R.id.tv_title, 20);
        sparseIntArray.put(R.id.tv_summary, 21);
        sparseIntArray.put(R.id.place_holder, 22);
        sparseIntArray.put(R.id.iv_triangle, 23);
        sparseIntArray.put(R.id.iv_mimi, 24);
    }

    public EqRadarSeekLayoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 25, sIncludes, sViewsWithIds));
    }

    private EqRadarSeekLayoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 10, (EQInnerCircle) bindings[3], (ConstraintLayout) bindings[2], (ConstraintLayout) bindings[4], (AppCompatImageView) bindings[10], (AppCompatImageView) bindings[1], (ImageView) bindings[17], (AppCompatImageView) bindings[16], (View) bindings[18], (ImageView) bindings[24], (ImageView) bindings[23], (AppCompatImageView) bindings[9], (EQSeekBar) bindings[13], (RoundLinearLayout) bindings[19], (ConstraintLayout) bindings[8], (Space) bindings[22], (EQSeekBar) bindings[12], (EQSeekBar) bindings[11], (AppCompatTextView) bindings[6], (AppCompatTextView) bindings[5], (TextView) bindings[14], (TextView) bindings[21], (TextView) bindings[20], (AppCompatTextView) bindings[7]);
        this.mDirtyFlags = -1L;
        this.circle.setTag(null);
        this.clCircle.setTag(null);
        this.clLabel.setTag(null);
        this.diracEq.setTag(null);
        this.ivBg.setTag(null);
        this.ivTripleBg.setTag(null);
        this.leftSeek.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) bindings[15];
        this.mboundView15 = constraintLayout2;
        constraintLayout2.setTag(null);
        this.parent.setTag(null);
        this.rightSeek.setTag(null);
        this.topSeek.setTag(null);
        this.tvBass.setTag(null);
        this.tvMid.setTag(null);
        this.tvShowValue.setTag(null);
        this.tvTreble.setTag(null);
        setRootTag(root);
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
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((EQLabelViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.EqRadarSeekLayoutBinding
    public void setViewModel(EQLabelViewModel ViewModel) {
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
                return onChangeViewModelTrebleSelected((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelShowValue((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelShowValueVisible((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelBassSelected((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelTrebleText((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelBassText((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelSelectBgImage((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelMidSelected((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelShowCustom((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelMidText((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelTrebleSelected(ObservableField<Boolean> ViewModelTrebleSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelShowValue(ObservableField<String> ViewModelShowValue, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelShowValueVisible(ObservableField<Boolean> ViewModelShowValueVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelBassSelected(ObservableField<Boolean> ViewModelBassSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelTrebleText(ObservableField<String> ViewModelTrebleText, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelBassText(ObservableField<String> ViewModelBassText, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelSelectBgImage(ObservableField<Integer> ViewModelSelectBgImage, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelMidSelected(ObservableField<Boolean> ViewModelMidSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelShowCustom(ObservableField<Boolean> ViewModelShowCustom, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelMidText(ObservableField<String> ViewModelMidText, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x015b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x015d  */
    /* JADX WARN: Code duplicated, block: B:103:0x0162  */
    /* JADX WARN: Code duplicated, block: B:106:0x016a  */
    /* JADX WARN: Code duplicated, block: B:107:0x0172  */
    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:34:0x0081 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x0088  */
    /* JADX WARN: Code duplicated, block: B:39:0x0091  */
    /* JADX WARN: Code duplicated, block: B:40:0x0098  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:49:0x00af  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:54:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:55:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:63:0x00da  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:68:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x0100  */
    /* JADX WARN: Code duplicated, block: B:74:0x0105  */
    /* JADX WARN: Code duplicated, block: B:77:0x010e  */
    /* JADX WARN: Code duplicated, block: B:78:0x0115  */
    /* JADX WARN: Code duplicated, block: B:82:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x0120  */
    /* JADX WARN: Code duplicated, block: B:84:0x0125  */
    /* JADX WARN: Code duplicated, block: B:87:0x012c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0133  */
    /* JADX WARN: Code duplicated, block: B:91:0x013a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x013c  */
    /* JADX WARN: Code duplicated, block: B:93:0x0141  */
    /* JADX WARN: Code duplicated, block: B:96:0x014b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0152  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        float f;
        float scale;
        String str;
        Boolean bool;
        Boolean bool2;
        String str2;
        Boolean bool3;
        Boolean bool4;
        String str3;
        String str4;
        Integer num;
        Boolean bool5;
        long j7;
        Boolean bool6;
        ObservableField<String> midText;
        ObservableField<Boolean> showCustom;
        ObservableField<Boolean> midSelected;
        ObservableField<Integer> selectBgImage;
        ObservableField<String> bassText;
        ObservableField<String> trebleText;
        ObservableField<Boolean> bassSelected;
        ObservableField<Boolean> showValueVisible;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        EQLabelViewModel eQLabelViewModel = this.mViewModel;
        float scaleInner = 0.0f;
        if ((4095 & j) != 0) {
            if ((j & 3073) == 0) {
                bool6 = null;
            } else {
                ObservableField<Boolean> trebleSelected = eQLabelViewModel != null ? eQLabelViewModel.getTrebleSelected() : null;
                updateRegistration(0, trebleSelected);
                if (trebleSelected != null) {
                    bool6 = trebleSelected.get();
                } else {
                    bool6 = null;
                }
            }
            if ((j & 3072) == 0 || eQLabelViewModel == null) {
                scale = 0.0f;
            } else {
                scaleInner = eQLabelViewModel.getScaleInner();
                scale = eQLabelViewModel.getScale();
            }
            if ((j & 3074) != 0) {
                ObservableField<String> showValue = eQLabelViewModel != null ? eQLabelViewModel.getShowValue() : null;
                j5 = 3200;
                updateRegistration(1, showValue);
                str2 = showValue != null ? showValue.get() : null;
                if ((j & 3076) != 0) {
                    if (eQLabelViewModel != null) {
                        showValueVisible = eQLabelViewModel.getShowValueVisible();
                    } else {
                        showValueVisible = null;
                    }
                    j6 = 3584;
                    updateRegistration(2, showValueVisible);
                    bool3 = showValueVisible != null ? showValueVisible.get() : null;
                    if ((j & 3080) == 0) {
                        bool4 = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            bassSelected = eQLabelViewModel.getBassSelected();
                        } else {
                            bassSelected = null;
                        }
                        updateRegistration(3, bassSelected);
                        if (bassSelected != null) {
                            bool4 = bassSelected.get();
                        } else {
                            bool4 = null;
                        }
                    }
                    if ((j & 3088) == 0) {
                        str3 = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            trebleText = eQLabelViewModel.getTrebleText();
                        } else {
                            trebleText = null;
                        }
                        updateRegistration(4, trebleText);
                        if (trebleText != null) {
                            str3 = trebleText.get();
                        } else {
                            str3 = null;
                        }
                    }
                    if ((j & 3104) != 0) {
                        if (eQLabelViewModel != null) {
                            bassText = eQLabelViewModel.getBassText();
                            j2 = 3088;
                        } else {
                            j2 = 3088;
                            bassText = null;
                        }
                        updateRegistration(5, bassText);
                        str4 = bassText != null ? bassText.get() : null;
                        if ((j & 3136) != 0) {
                            if (eQLabelViewModel != null) {
                                selectBgImage = eQLabelViewModel.getSelectBgImage();
                            } else {
                                selectBgImage = null;
                            }
                            j3 = 3080;
                            updateRegistration(6, selectBgImage);
                            num = selectBgImage != null ? selectBgImage.get() : null;
                            if ((j & j5) == 0) {
                                bool5 = null;
                            } else {
                                if (eQLabelViewModel != null) {
                                    midSelected = eQLabelViewModel.getMidSelected();
                                } else {
                                    midSelected = null;
                                }
                                updateRegistration(7, midSelected);
                                if (midSelected != null) {
                                    bool5 = midSelected.get();
                                } else {
                                    bool5 = null;
                                }
                            }
                            if ((j & 3328) != 0) {
                                if (eQLabelViewModel != null) {
                                    showCustom = eQLabelViewModel.getShowCustom();
                                } else {
                                    showCustom = null;
                                }
                                j4 = 3104;
                                updateRegistration(8, showCustom);
                                Boolean bool7 = showCustom != null ? showCustom.get() : null;
                                if ((j & j6) == 0) {
                                    str = null;
                                } else {
                                    if (eQLabelViewModel != null) {
                                        midText = eQLabelViewModel.getMidText();
                                    } else {
                                        midText = null;
                                    }
                                    updateRegistration(9, midText);
                                    if (midText != null) {
                                        str = midText.get();
                                    } else {
                                        str = null;
                                    }
                                }
                                bool2 = bool6;
                                bool = bool7;
                                f = scaleInner;
                            } else {
                                j4 = 3104;
                            }
                            if ((j & j6) == 0) {
                                str = null;
                            } else {
                                if (eQLabelViewModel != null) {
                                    midText = eQLabelViewModel.getMidText();
                                } else {
                                    midText = null;
                                }
                                updateRegistration(9, midText);
                                if (midText != null) {
                                    str = midText.get();
                                } else {
                                    str = null;
                                }
                            }
                            bool2 = bool6;
                            bool = bool7;
                            f = scaleInner;
                        } else {
                            j3 = 3080;
                        }
                        if ((j & j5) == 0) {
                            bool5 = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midSelected = eQLabelViewModel.getMidSelected();
                            } else {
                                midSelected = null;
                            }
                            updateRegistration(7, midSelected);
                            if (midSelected != null) {
                                bool5 = midSelected.get();
                            } else {
                                bool5 = null;
                            }
                        }
                        if ((j & 3328) != 0) {
                            if (eQLabelViewModel != null) {
                                showCustom = eQLabelViewModel.getShowCustom();
                            } else {
                                showCustom = null;
                            }
                            j4 = 3104;
                            updateRegistration(8, showCustom);
                            if (showCustom != null) {
                            }
                            if ((j & j6) == 0) {
                                str = null;
                            } else {
                                if (eQLabelViewModel != null) {
                                    midText = eQLabelViewModel.getMidText();
                                } else {
                                    midText = null;
                                }
                                updateRegistration(9, midText);
                                if (midText != null) {
                                    str = midText.get();
                                } else {
                                    str = null;
                                }
                            }
                            bool2 = bool6;
                            bool = bool7;
                            f = scaleInner;
                        } else {
                            j4 = 3104;
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j2 = 3088;
                    }
                    if ((j & 3136) != 0) {
                        if (eQLabelViewModel != null) {
                            selectBgImage = eQLabelViewModel.getSelectBgImage();
                        } else {
                            selectBgImage = null;
                        }
                        j3 = 3080;
                        updateRegistration(6, selectBgImage);
                        if (selectBgImage != null) {
                        }
                        if ((j & j5) == 0) {
                            bool5 = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midSelected = eQLabelViewModel.getMidSelected();
                            } else {
                                midSelected = null;
                            }
                            updateRegistration(7, midSelected);
                            if (midSelected != null) {
                                bool5 = midSelected.get();
                            } else {
                                bool5 = null;
                            }
                        }
                        if ((j & 3328) != 0) {
                            if (eQLabelViewModel != null) {
                                showCustom = eQLabelViewModel.getShowCustom();
                            } else {
                                showCustom = null;
                            }
                            j4 = 3104;
                            updateRegistration(8, showCustom);
                            if (showCustom != null) {
                            }
                            if ((j & j6) == 0) {
                                str = null;
                            } else {
                                if (eQLabelViewModel != null) {
                                    midText = eQLabelViewModel.getMidText();
                                } else {
                                    midText = null;
                                }
                                updateRegistration(9, midText);
                                if (midText != null) {
                                    str = midText.get();
                                } else {
                                    str = null;
                                }
                            }
                            bool2 = bool6;
                            bool = bool7;
                            f = scaleInner;
                        } else {
                            j4 = 3104;
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j3 = 3080;
                    }
                    if ((j & j5) == 0) {
                        bool5 = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midSelected = eQLabelViewModel.getMidSelected();
                        } else {
                            midSelected = null;
                        }
                        updateRegistration(7, midSelected);
                        if (midSelected != null) {
                            bool5 = midSelected.get();
                        } else {
                            bool5 = null;
                        }
                    }
                    if ((j & 3328) != 0) {
                        if (eQLabelViewModel != null) {
                            showCustom = eQLabelViewModel.getShowCustom();
                        } else {
                            showCustom = null;
                        }
                        j4 = 3104;
                        updateRegistration(8, showCustom);
                        if (showCustom != null) {
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j4 = 3104;
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j6 = 3584;
                }
                if ((j & 3080) == 0) {
                    bool4 = null;
                } else {
                    if (eQLabelViewModel != null) {
                        bassSelected = eQLabelViewModel.getBassSelected();
                    } else {
                        bassSelected = null;
                    }
                    updateRegistration(3, bassSelected);
                    if (bassSelected != null) {
                        bool4 = bassSelected.get();
                    } else {
                        bool4 = null;
                    }
                }
                if ((j & 3088) == 0) {
                    str3 = null;
                } else {
                    if (eQLabelViewModel != null) {
                        trebleText = eQLabelViewModel.getTrebleText();
                    } else {
                        trebleText = null;
                    }
                    updateRegistration(4, trebleText);
                    if (trebleText != null) {
                        str3 = trebleText.get();
                    } else {
                        str3 = null;
                    }
                }
                if ((j & 3104) != 0) {
                    if (eQLabelViewModel != null) {
                        bassText = eQLabelViewModel.getBassText();
                        j2 = 3088;
                    } else {
                        j2 = 3088;
                        bassText = null;
                    }
                    updateRegistration(5, bassText);
                    if (bassText != null) {
                    }
                    if ((j & 3136) != 0) {
                        if (eQLabelViewModel != null) {
                            selectBgImage = eQLabelViewModel.getSelectBgImage();
                        } else {
                            selectBgImage = null;
                        }
                        j3 = 3080;
                        updateRegistration(6, selectBgImage);
                        if (selectBgImage != null) {
                        }
                        if ((j & j5) == 0) {
                            bool5 = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midSelected = eQLabelViewModel.getMidSelected();
                            } else {
                                midSelected = null;
                            }
                            updateRegistration(7, midSelected);
                            if (midSelected != null) {
                                bool5 = midSelected.get();
                            } else {
                                bool5 = null;
                            }
                        }
                        if ((j & 3328) != 0) {
                            if (eQLabelViewModel != null) {
                                showCustom = eQLabelViewModel.getShowCustom();
                            } else {
                                showCustom = null;
                            }
                            j4 = 3104;
                            updateRegistration(8, showCustom);
                            if (showCustom != null) {
                            }
                            if ((j & j6) == 0) {
                                str = null;
                            } else {
                                if (eQLabelViewModel != null) {
                                    midText = eQLabelViewModel.getMidText();
                                } else {
                                    midText = null;
                                }
                                updateRegistration(9, midText);
                                if (midText != null) {
                                    str = midText.get();
                                } else {
                                    str = null;
                                }
                            }
                            bool2 = bool6;
                            bool = bool7;
                            f = scaleInner;
                        } else {
                            j4 = 3104;
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j3 = 3080;
                    }
                    if ((j & j5) == 0) {
                        bool5 = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midSelected = eQLabelViewModel.getMidSelected();
                        } else {
                            midSelected = null;
                        }
                        updateRegistration(7, midSelected);
                        if (midSelected != null) {
                            bool5 = midSelected.get();
                        } else {
                            bool5 = null;
                        }
                    }
                    if ((j & 3328) != 0) {
                        if (eQLabelViewModel != null) {
                            showCustom = eQLabelViewModel.getShowCustom();
                        } else {
                            showCustom = null;
                        }
                        j4 = 3104;
                        updateRegistration(8, showCustom);
                        if (showCustom != null) {
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j4 = 3104;
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j2 = 3088;
                }
                if ((j & 3136) != 0) {
                    if (eQLabelViewModel != null) {
                        selectBgImage = eQLabelViewModel.getSelectBgImage();
                    } else {
                        selectBgImage = null;
                    }
                    j3 = 3080;
                    updateRegistration(6, selectBgImage);
                    if (selectBgImage != null) {
                    }
                    if ((j & j5) == 0) {
                        bool5 = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midSelected = eQLabelViewModel.getMidSelected();
                        } else {
                            midSelected = null;
                        }
                        updateRegistration(7, midSelected);
                        if (midSelected != null) {
                            bool5 = midSelected.get();
                        } else {
                            bool5 = null;
                        }
                    }
                    if ((j & 3328) != 0) {
                        if (eQLabelViewModel != null) {
                            showCustom = eQLabelViewModel.getShowCustom();
                        } else {
                            showCustom = null;
                        }
                        j4 = 3104;
                        updateRegistration(8, showCustom);
                        if (showCustom != null) {
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j4 = 3104;
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j3 = 3080;
                }
                if ((j & j5) == 0) {
                    bool5 = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midSelected = eQLabelViewModel.getMidSelected();
                    } else {
                        midSelected = null;
                    }
                    updateRegistration(7, midSelected);
                    if (midSelected != null) {
                        bool5 = midSelected.get();
                    } else {
                        bool5 = null;
                    }
                }
                if ((j & 3328) != 0) {
                    if (eQLabelViewModel != null) {
                        showCustom = eQLabelViewModel.getShowCustom();
                    } else {
                        showCustom = null;
                    }
                    j4 = 3104;
                    updateRegistration(8, showCustom);
                    if (showCustom != null) {
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j4 = 3104;
                }
                if ((j & j6) == 0) {
                    str = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midText = eQLabelViewModel.getMidText();
                    } else {
                        midText = null;
                    }
                    updateRegistration(9, midText);
                    if (midText != null) {
                        str = midText.get();
                    } else {
                        str = null;
                    }
                }
                bool2 = bool6;
                bool = bool7;
                f = scaleInner;
            } else {
                j5 = 3200;
            }
            if ((j & 3076) != 0) {
                if (eQLabelViewModel != null) {
                    showValueVisible = eQLabelViewModel.getShowValueVisible();
                } else {
                    showValueVisible = null;
                }
                j6 = 3584;
                updateRegistration(2, showValueVisible);
                if (showValueVisible != null) {
                }
                if ((j & 3080) == 0) {
                    bool4 = null;
                } else {
                    if (eQLabelViewModel != null) {
                        bassSelected = eQLabelViewModel.getBassSelected();
                    } else {
                        bassSelected = null;
                    }
                    updateRegistration(3, bassSelected);
                    if (bassSelected != null) {
                        bool4 = bassSelected.get();
                    } else {
                        bool4 = null;
                    }
                }
                if ((j & 3088) == 0) {
                    str3 = null;
                } else {
                    if (eQLabelViewModel != null) {
                        trebleText = eQLabelViewModel.getTrebleText();
                    } else {
                        trebleText = null;
                    }
                    updateRegistration(4, trebleText);
                    if (trebleText != null) {
                        str3 = trebleText.get();
                    } else {
                        str3 = null;
                    }
                }
                if ((j & 3104) != 0) {
                    if (eQLabelViewModel != null) {
                        bassText = eQLabelViewModel.getBassText();
                        j2 = 3088;
                    } else {
                        j2 = 3088;
                        bassText = null;
                    }
                    updateRegistration(5, bassText);
                    if (bassText != null) {
                    }
                    if ((j & 3136) != 0) {
                        if (eQLabelViewModel != null) {
                            selectBgImage = eQLabelViewModel.getSelectBgImage();
                        } else {
                            selectBgImage = null;
                        }
                        j3 = 3080;
                        updateRegistration(6, selectBgImage);
                        if (selectBgImage != null) {
                        }
                        if ((j & j5) == 0) {
                            bool5 = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midSelected = eQLabelViewModel.getMidSelected();
                            } else {
                                midSelected = null;
                            }
                            updateRegistration(7, midSelected);
                            if (midSelected != null) {
                                bool5 = midSelected.get();
                            } else {
                                bool5 = null;
                            }
                        }
                        if ((j & 3328) != 0) {
                            if (eQLabelViewModel != null) {
                                showCustom = eQLabelViewModel.getShowCustom();
                            } else {
                                showCustom = null;
                            }
                            j4 = 3104;
                            updateRegistration(8, showCustom);
                            if (showCustom != null) {
                            }
                            if ((j & j6) == 0) {
                                str = null;
                            } else {
                                if (eQLabelViewModel != null) {
                                    midText = eQLabelViewModel.getMidText();
                                } else {
                                    midText = null;
                                }
                                updateRegistration(9, midText);
                                if (midText != null) {
                                    str = midText.get();
                                } else {
                                    str = null;
                                }
                            }
                            bool2 = bool6;
                            bool = bool7;
                            f = scaleInner;
                        } else {
                            j4 = 3104;
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j3 = 3080;
                    }
                    if ((j & j5) == 0) {
                        bool5 = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midSelected = eQLabelViewModel.getMidSelected();
                        } else {
                            midSelected = null;
                        }
                        updateRegistration(7, midSelected);
                        if (midSelected != null) {
                            bool5 = midSelected.get();
                        } else {
                            bool5 = null;
                        }
                    }
                    if ((j & 3328) != 0) {
                        if (eQLabelViewModel != null) {
                            showCustom = eQLabelViewModel.getShowCustom();
                        } else {
                            showCustom = null;
                        }
                        j4 = 3104;
                        updateRegistration(8, showCustom);
                        if (showCustom != null) {
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j4 = 3104;
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j2 = 3088;
                }
                if ((j & 3136) != 0) {
                    if (eQLabelViewModel != null) {
                        selectBgImage = eQLabelViewModel.getSelectBgImage();
                    } else {
                        selectBgImage = null;
                    }
                    j3 = 3080;
                    updateRegistration(6, selectBgImage);
                    if (selectBgImage != null) {
                    }
                    if ((j & j5) == 0) {
                        bool5 = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midSelected = eQLabelViewModel.getMidSelected();
                        } else {
                            midSelected = null;
                        }
                        updateRegistration(7, midSelected);
                        if (midSelected != null) {
                            bool5 = midSelected.get();
                        } else {
                            bool5 = null;
                        }
                    }
                    if ((j & 3328) != 0) {
                        if (eQLabelViewModel != null) {
                            showCustom = eQLabelViewModel.getShowCustom();
                        } else {
                            showCustom = null;
                        }
                        j4 = 3104;
                        updateRegistration(8, showCustom);
                        if (showCustom != null) {
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j4 = 3104;
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j3 = 3080;
                }
                if ((j & j5) == 0) {
                    bool5 = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midSelected = eQLabelViewModel.getMidSelected();
                    } else {
                        midSelected = null;
                    }
                    updateRegistration(7, midSelected);
                    if (midSelected != null) {
                        bool5 = midSelected.get();
                    } else {
                        bool5 = null;
                    }
                }
                if ((j & 3328) != 0) {
                    if (eQLabelViewModel != null) {
                        showCustom = eQLabelViewModel.getShowCustom();
                    } else {
                        showCustom = null;
                    }
                    j4 = 3104;
                    updateRegistration(8, showCustom);
                    if (showCustom != null) {
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j4 = 3104;
                }
                if ((j & j6) == 0) {
                    str = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midText = eQLabelViewModel.getMidText();
                    } else {
                        midText = null;
                    }
                    updateRegistration(9, midText);
                    if (midText != null) {
                        str = midText.get();
                    } else {
                        str = null;
                    }
                }
                bool2 = bool6;
                bool = bool7;
                f = scaleInner;
            } else {
                j6 = 3584;
            }
            if ((j & 3080) == 0) {
                bool4 = null;
            } else {
                if (eQLabelViewModel != null) {
                    bassSelected = eQLabelViewModel.getBassSelected();
                } else {
                    bassSelected = null;
                }
                updateRegistration(3, bassSelected);
                if (bassSelected != null) {
                    bool4 = bassSelected.get();
                } else {
                    bool4 = null;
                }
            }
            if ((j & 3088) == 0) {
                str3 = null;
            } else {
                if (eQLabelViewModel != null) {
                    trebleText = eQLabelViewModel.getTrebleText();
                } else {
                    trebleText = null;
                }
                updateRegistration(4, trebleText);
                if (trebleText != null) {
                    str3 = trebleText.get();
                } else {
                    str3 = null;
                }
            }
            if ((j & 3104) != 0) {
                if (eQLabelViewModel != null) {
                    bassText = eQLabelViewModel.getBassText();
                    j2 = 3088;
                } else {
                    j2 = 3088;
                    bassText = null;
                }
                updateRegistration(5, bassText);
                if (bassText != null) {
                }
                if ((j & 3136) != 0) {
                    if (eQLabelViewModel != null) {
                        selectBgImage = eQLabelViewModel.getSelectBgImage();
                    } else {
                        selectBgImage = null;
                    }
                    j3 = 3080;
                    updateRegistration(6, selectBgImage);
                    if (selectBgImage != null) {
                    }
                    if ((j & j5) == 0) {
                        bool5 = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midSelected = eQLabelViewModel.getMidSelected();
                        } else {
                            midSelected = null;
                        }
                        updateRegistration(7, midSelected);
                        if (midSelected != null) {
                            bool5 = midSelected.get();
                        } else {
                            bool5 = null;
                        }
                    }
                    if ((j & 3328) != 0) {
                        if (eQLabelViewModel != null) {
                            showCustom = eQLabelViewModel.getShowCustom();
                        } else {
                            showCustom = null;
                        }
                        j4 = 3104;
                        updateRegistration(8, showCustom);
                        if (showCustom != null) {
                        }
                        if ((j & j6) == 0) {
                            str = null;
                        } else {
                            if (eQLabelViewModel != null) {
                                midText = eQLabelViewModel.getMidText();
                            } else {
                                midText = null;
                            }
                            updateRegistration(9, midText);
                            if (midText != null) {
                                str = midText.get();
                            } else {
                                str = null;
                            }
                        }
                        bool2 = bool6;
                        bool = bool7;
                        f = scaleInner;
                    } else {
                        j4 = 3104;
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j3 = 3080;
                }
                if ((j & j5) == 0) {
                    bool5 = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midSelected = eQLabelViewModel.getMidSelected();
                    } else {
                        midSelected = null;
                    }
                    updateRegistration(7, midSelected);
                    if (midSelected != null) {
                        bool5 = midSelected.get();
                    } else {
                        bool5 = null;
                    }
                }
                if ((j & 3328) != 0) {
                    if (eQLabelViewModel != null) {
                        showCustom = eQLabelViewModel.getShowCustom();
                    } else {
                        showCustom = null;
                    }
                    j4 = 3104;
                    updateRegistration(8, showCustom);
                    if (showCustom != null) {
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j4 = 3104;
                }
                if ((j & j6) == 0) {
                    str = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midText = eQLabelViewModel.getMidText();
                    } else {
                        midText = null;
                    }
                    updateRegistration(9, midText);
                    if (midText != null) {
                        str = midText.get();
                    } else {
                        str = null;
                    }
                }
                bool2 = bool6;
                bool = bool7;
                f = scaleInner;
            } else {
                j2 = 3088;
            }
            if ((j & 3136) != 0) {
                if (eQLabelViewModel != null) {
                    selectBgImage = eQLabelViewModel.getSelectBgImage();
                } else {
                    selectBgImage = null;
                }
                j3 = 3080;
                updateRegistration(6, selectBgImage);
                if (selectBgImage != null) {
                }
                if ((j & j5) == 0) {
                    bool5 = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midSelected = eQLabelViewModel.getMidSelected();
                    } else {
                        midSelected = null;
                    }
                    updateRegistration(7, midSelected);
                    if (midSelected != null) {
                        bool5 = midSelected.get();
                    } else {
                        bool5 = null;
                    }
                }
                if ((j & 3328) != 0) {
                    if (eQLabelViewModel != null) {
                        showCustom = eQLabelViewModel.getShowCustom();
                    } else {
                        showCustom = null;
                    }
                    j4 = 3104;
                    updateRegistration(8, showCustom);
                    if (showCustom != null) {
                    }
                    if ((j & j6) == 0) {
                        str = null;
                    } else {
                        if (eQLabelViewModel != null) {
                            midText = eQLabelViewModel.getMidText();
                        } else {
                            midText = null;
                        }
                        updateRegistration(9, midText);
                        if (midText != null) {
                            str = midText.get();
                        } else {
                            str = null;
                        }
                    }
                    bool2 = bool6;
                    bool = bool7;
                    f = scaleInner;
                } else {
                    j4 = 3104;
                }
                if ((j & j6) == 0) {
                    str = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midText = eQLabelViewModel.getMidText();
                    } else {
                        midText = null;
                    }
                    updateRegistration(9, midText);
                    if (midText != null) {
                        str = midText.get();
                    } else {
                        str = null;
                    }
                }
                bool2 = bool6;
                bool = bool7;
                f = scaleInner;
            } else {
                j3 = 3080;
            }
            if ((j & j5) == 0) {
                bool5 = null;
            } else {
                if (eQLabelViewModel != null) {
                    midSelected = eQLabelViewModel.getMidSelected();
                } else {
                    midSelected = null;
                }
                updateRegistration(7, midSelected);
                if (midSelected != null) {
                    bool5 = midSelected.get();
                } else {
                    bool5 = null;
                }
            }
            if ((j & 3328) != 0) {
                if (eQLabelViewModel != null) {
                    showCustom = eQLabelViewModel.getShowCustom();
                } else {
                    showCustom = null;
                }
                j4 = 3104;
                updateRegistration(8, showCustom);
                if (showCustom != null) {
                }
                if ((j & j6) == 0) {
                    str = null;
                } else {
                    if (eQLabelViewModel != null) {
                        midText = eQLabelViewModel.getMidText();
                    } else {
                        midText = null;
                    }
                    updateRegistration(9, midText);
                    if (midText != null) {
                        str = midText.get();
                    } else {
                        str = null;
                    }
                }
                bool2 = bool6;
                bool = bool7;
                f = scaleInner;
            } else {
                j4 = 3104;
            }
            if ((j & j6) == 0) {
                str = null;
            } else {
                if (eQLabelViewModel != null) {
                    midText = eQLabelViewModel.getMidText();
                } else {
                    midText = null;
                }
                updateRegistration(9, midText);
                if (midText != null) {
                    str = midText.get();
                } else {
                    str = null;
                }
            }
            bool2 = bool6;
            bool = bool7;
            f = scaleInner;
        } else {
            j2 = 3088;
            j3 = 3080;
            j4 = 3104;
            j5 = 3200;
            j6 = 3584;
            f = 0.0f;
            scale = 0.0f;
            str = null;
            bool = null;
            bool2 = null;
            str2 = null;
            bool3 = null;
            bool4 = null;
            str3 = null;
            str4 = null;
            num = null;
            bool5 = null;
        }
        if ((j & 2048) != 0) {
            BindingAdapter.viewAdaptWithDesign(this.circle, 414.0f, 414.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.clCircle, 414.0f, 414.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.clLabel, 380.0f, 366.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.diracEq, 366.0f, 366.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.ivBg, 366.0f, 366.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.ivTripleBg, 366.0f, 366.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.leftSeek, 118.0f, 62.0f, 0.0f, 110.0f, 52.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.mboundView15, 380.0f, 366.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.parent, 366.0f, 366.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.rightSeek, 118.0f, 62.0f, 0.0f, 110.0f, 0.0f, 52.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.topSeek, 118.0f, 62.0f, 69.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.tvBass, 100.0f, 40.0f, 0.0f, 80.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.tvMid, 100.0f, 40.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
            BindingAdapter.viewAdaptWithDesign(this.tvTreble, 100.0f, 40.0f, 0.0f, 80.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, false, false, 0.0f, false);
        }
        if ((j & 3072) != 0) {
            j7 = j;
            if (getBuildSdkInt() >= 11) {
                this.clCircle.setScaleX(f);
                this.clCircle.setScaleY(f);
                this.clLabel.setScaleX(f);
                this.clLabel.setScaleY(f);
                this.ivBg.setScaleX(scale);
                this.ivBg.setScaleY(scale);
                this.mboundView15.setScaleX(scale);
                this.mboundView15.setScaleY(scale);
                this.parent.setScaleX(f);
                this.parent.setScaleY(f);
            }
        } else {
            j7 = j;
        }
        if ((j7 & 3328) != 0) {
            BindingAdapter.invisibleUnless(this.clCircle, bool);
            BindingAdapter.invisibleUnless(this.leftSeek, bool);
            BindingAdapter.invisibleUnless(this.rightSeek, bool);
            BindingAdapter.invisibleUnless(this.topSeek, bool);
        }
        if ((j7 & 3136) != 0) {
            BindingAdapter.setRes(this.ivTripleBg, num);
        }
        if ((j7 & j4) != 0) {
            if (getBuildSdkInt() >= 4) {
                this.tvBass.setContentDescription(str4);
            }
            TextViewBindingAdapter.setText(this.tvBass, str4);
        }
        if ((j7 & j3) != 0) {
            BindingAdapter.viewSelected(this.tvBass, bool4);
        }
        if ((j7 & j6) != 0) {
            if (getBuildSdkInt() >= 4) {
                this.tvMid.setContentDescription(str);
            }
            TextViewBindingAdapter.setText(this.tvMid, str);
        }
        if ((j7 & j5) != 0) {
            BindingAdapter.viewSelected(this.tvMid, bool5);
        }
        if ((j7 & 3074) != 0) {
            TextViewBindingAdapter.setText(this.tvShowValue, str2);
        }
        if ((j7 & 3076) != 0) {
            BindingAdapter.goneUnless(this.tvShowValue, bool3);
        }
        if ((j7 & j2) != 0) {
            if (getBuildSdkInt() >= 4) {
                this.tvTreble.setContentDescription(str3);
            }
            TextViewBindingAdapter.setText(this.tvTreble, str3);
        }
        if ((j7 & 3073) != 0) {
            BindingAdapter.viewSelected(this.tvTreble, bool2);
        }
    }
}
