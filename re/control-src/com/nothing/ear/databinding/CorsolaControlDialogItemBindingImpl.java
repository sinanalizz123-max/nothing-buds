package com.nothing.ear.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.nothing.base.binding.BindingAdapter;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.corsola.control.ControlItemViewModel;
import com.nothing.corsola.control.ControlOperationActivity;
import com.nothing.ear.BR;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlRadius;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class CorsolaControlDialogItemBindingImpl extends CorsolaControlDialogItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback292;
    private final View.OnClickListener mCallback293;
    private final View.OnClickListener mCallback294;
    private final View.OnClickListener mCallback295;
    private final View.OnClickListener mCallback296;
    private final View.OnClickListener mCallback297;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final LinearLayoutCompat mboundView10;
    private final LinearLayout mboundView11;
    private final TextView mboundView12;
    private final TextView mboundView13;
    private final TextView mboundView14;
    private final RoundLinearLayout mboundView2;
    private final LinearLayoutCompat mboundView3;
    private final AppCompatTextView mboundView4;
    private final AppCompatImageView mboundView5;
    private final LinearLayoutCompat mboundView6;
    private final TextView mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    public CorsolaControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private CorsolaControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 13, (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[10];
        this.mboundView10 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[11];
        this.mboundView11 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView = (TextView) bindings[12];
        this.mboundView12 = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) bindings[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[14];
        this.mboundView14 = textView3;
        textView3.setTag(null);
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) bindings[2];
        this.mboundView2 = roundLinearLayout;
        roundLinearLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) bindings[3];
        this.mboundView3 = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[4];
        this.mboundView4 = appCompatTextView;
        appCompatTextView.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) bindings[5];
        this.mboundView5 = appCompatImageView;
        appCompatImageView.setTag(null);
        LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) bindings[6];
        this.mboundView6 = linearLayoutCompat3;
        linearLayoutCompat3.setTag(null);
        TextView textView4 = (TextView) bindings[7];
        this.mboundView7 = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) bindings[8];
        this.mboundView8 = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[9];
        this.mboundView9 = textView6;
        textView6.setTag(null);
        this.notTitle.setTag(null);
        setRootTag(root);
        this.mCallback297 = new OnClickListener(this, 6);
        this.mCallback293 = new OnClickListener(this, 2);
        this.mCallback294 = new OnClickListener(this, 3);
        this.mCallback295 = new OnClickListener(this, 4);
        this.mCallback296 = new OnClickListener(this, 5);
        this.mCallback292 = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 65536L;
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
        if (BR.itemViewModel == variableId) {
            setItemViewModel((ControlItemViewModel) variable);
            return true;
        }
        if (BR.eventHandler == variableId) {
            setEventHandler((ControlOperationActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlOperationViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.CorsolaControlDialogItemBinding
    public void setItemViewModel(ControlItemViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.CorsolaControlDialogItemBinding
    public void setEventHandler(ControlOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.CorsolaControlDialogItemBinding
    public void setViewModel(ControlOperationViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return onChangeViewModelChatGptUnableText((ObservableField) object, fieldId);
            case 1:
                return onChangeViewModelTransSelected((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelVoiceAssistantEnable((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelVoiceAssistantVisible((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelOperationName((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelSelected((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelVoiceAssistantChatGptSelected((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelOffSelected((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelNoiseControlVisible((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelNoiseCancellationSelected((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelVoiceAssistantDefaultSelected((ObservableField) object, fieldId);
            case 11:
                return onChangeViewModelItemDesc((ObservableField) object, fieldId);
            case 12:
                return onChangeViewModelEnable((ObservableField) object, fieldId);
            default:
                return false;
        }
    }

    private boolean onChangeViewModelChatGptUnableText(ObservableField<String> ViewModelChatGptUnableText, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        return true;
    }

    private boolean onChangeViewModelTransSelected(ObservableField<Boolean> ViewModelTransSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantEnable(ObservableField<Boolean> ViewModelVoiceAssistantEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantVisible(ObservableField<Boolean> ViewModelVoiceAssistantVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelOperationName(ObservableField<String> ViewModelOperationName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelSelected(ObservableField<Boolean> ViewModelSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantChatGptSelected(ObservableField<Boolean> ViewModelVoiceAssistantChatGptSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelOffSelected(ObservableField<Boolean> ViewModelOffSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseControlVisible(ObservableField<Boolean> ViewModelNoiseControlVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseCancellationSelected(ObservableField<Boolean> ViewModelNoiseCancellationSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantDefaultSelected(ObservableField<Boolean> ViewModelVoiceAssistantDefaultSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelItemDesc(ObservableField<String> ViewModelItemDesc, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelEnable(ObservableField<Boolean> ViewModelEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0166  */
    /* JADX WARN: Code duplicated, block: B:101:0x016b  */
    /* JADX WARN: Code duplicated, block: B:104:0x0173  */
    /* JADX WARN: Code duplicated, block: B:105:0x017a  */
    /* JADX WARN: Code duplicated, block: B:108:0x0181 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x0183  */
    /* JADX WARN: Code duplicated, block: B:110:0x0188  */
    /* JADX WARN: Code duplicated, block: B:113:0x0190  */
    /* JADX WARN: Code duplicated, block: B:114:0x0197  */
    /* JADX WARN: Code duplicated, block: B:117:0x019e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:118:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:119:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:122:0x01af  */
    /* JADX WARN: Code duplicated, block: B:123:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:127:0x01bf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:129:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:132:0x01cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:133:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:134:0x01da  */
    /* JADX WARN: Code duplicated, block: B:137:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:142:0x01f8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:143:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:147:0x0207  */
    /* JADX WARN: Code duplicated, block: B:148:0x020e  */
    /* JADX WARN: Code duplicated, block: B:150:0x0231  */
    /* JADX WARN: Code duplicated, block: B:16:0x0056  */
    /* JADX WARN: Code duplicated, block: B:25:0x0074  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:70:0x0104 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:71:0x0106  */
    /* JADX WARN: Code duplicated, block: B:72:0x010b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0115  */
    /* JADX WARN: Code duplicated, block: B:76:0x011c  */
    /* JADX WARN: Code duplicated, block: B:80:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0128  */
    /* JADX WARN: Code duplicated, block: B:82:0x012d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0134  */
    /* JADX WARN: Code duplicated, block: B:86:0x013b  */
    /* JADX WARN: Code duplicated, block: B:89:0x0142 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:90:0x0144  */
    /* JADX WARN: Code duplicated, block: B:91:0x0149  */
    /* JADX WARN: Code duplicated, block: B:94:0x0153  */
    /* JADX WARN: Code duplicated, block: B:95:0x015a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0164 A[DONT_INVERT] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        float f;
        boolean z;
        Boolean bool;
        String str;
        String str2;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        String str3;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        ControlRadius direction;
        boolean z2;
        boolean z3;
        Boolean bool8;
        long j6;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        boolean z4;
        Boolean bool12;
        Boolean bool13;
        Boolean bool14;
        Boolean bool15;
        ControlOperationViewModel controlOperationViewModel;
        Boolean bool16;
        long j7;
        String str4;
        ObservableField<Boolean> enable;
        Boolean bool17;
        ObservableField<String> itemDesc;
        ObservableField<Boolean> voiceAssistantDefaultSelected;
        ObservableField<Boolean> noiseCancellationSelected;
        ObservableField<Boolean> noiseControlVisible;
        ObservableField<Boolean> offSelected;
        ObservableField<Boolean> voiceAssistantChatGptSelected;
        ObservableField<Boolean> selected;
        ObservableField<String> operationName;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlItemViewModel controlItemViewModel = this.mItemViewModel;
        ControlOperationActivity controlOperationActivity = this.mEventHandler;
        ControlOperationViewModel controlOperationViewModel2 = this.mViewModel;
        float f2 = 0.0f;
        if ((106495 & j) != 0) {
            if ((j & 98305) == 0) {
                str2 = null;
            } else {
                ObservableField<String> chatGptUnableText = controlOperationViewModel2 != null ? controlOperationViewModel2.getChatGptUnableText() : null;
                updateRegistration(0, chatGptUnableText);
                if (chatGptUnableText != null) {
                    str2 = chatGptUnableText.get();
                } else {
                    str2 = null;
                }
            }
            if ((j & 98306) == 0) {
                bool11 = null;
            } else {
                ObservableField<Boolean> transSelected = controlOperationViewModel2 != null ? controlOperationViewModel2.getTransSelected() : null;
                updateRegistration(1, transSelected);
                if (transSelected != null) {
                    bool11 = transSelected.get();
                } else {
                    bool11 = null;
                }
            }
            long j8 = j & 98308;
            if (j8 != 0) {
                ObservableField<Boolean> voiceAssistantEnable = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantEnable() : null;
                j2 = 98560;
                updateRegistration(2, voiceAssistantEnable);
                bool3 = voiceAssistantEnable != null ? voiceAssistantEnable.get() : null;
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(bool3);
                boolean z5 = !zSafeUnbox;
                boolean z6 = zSafeUnbox;
                if (j8 != 0) {
                    j |= z6 ? 262144L : 131072L;
                }
                f2 = z6 ? 1.0f : 0.38f;
                z4 = z5;
            } else {
                j2 = 98560;
                z4 = false;
                bool3 = null;
            }
            if ((j & 98312) != 0) {
                ObservableField<Boolean> voiceAssistantVisible = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantVisible() : null;
                j3 = 102400;
                updateRegistration(3, voiceAssistantVisible);
                bool12 = voiceAssistantVisible != null ? voiceAssistantVisible.get() : null;
                if ((j & 98320) == 0) {
                    str3 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        operationName = controlOperationViewModel2.getOperationName();
                    } else {
                        operationName = null;
                    }
                    updateRegistration(4, operationName);
                    if (operationName != null) {
                        str3 = operationName.get();
                    } else {
                        str3 = null;
                    }
                }
                if ((j & 98336) != 0) {
                    if (controlOperationViewModel2 != null) {
                        selected = controlOperationViewModel2.getSelected();
                    } else {
                        selected = null;
                    }
                    j4 = 98432;
                    updateRegistration(5, selected);
                    bool5 = selected != null ? selected.get() : null;
                    if ((j & 98368) == 0) {
                        bool6 = null;
                    } else {
                        if (controlOperationViewModel2 != null) {
                            voiceAssistantChatGptSelected = controlOperationViewModel2.getVoiceAssistantChatGptSelected();
                        } else {
                            voiceAssistantChatGptSelected = null;
                        }
                        updateRegistration(6, voiceAssistantChatGptSelected);
                        if (voiceAssistantChatGptSelected != null) {
                            bool6 = voiceAssistantChatGptSelected.get();
                        } else {
                            bool6 = null;
                        }
                    }
                    if ((j & j4) != 0) {
                        if (controlOperationViewModel2 != null) {
                            offSelected = controlOperationViewModel2.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        j5 = 100352;
                        updateRegistration(7, offSelected);
                        bool13 = offSelected != null ? offSelected.get() : null;
                        if ((j & j2) == 0) {
                            bool14 = null;
                        } else {
                            if (controlOperationViewModel2 != null) {
                                noiseControlVisible = controlOperationViewModel2.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            updateRegistration(8, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool14 = noiseControlVisible.get();
                            } else {
                                bool14 = null;
                            }
                        }
                        if ((j & 98816) == 0) {
                            bool15 = null;
                        } else {
                            if (controlOperationViewModel2 != null) {
                                noiseCancellationSelected = controlOperationViewModel2.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            updateRegistration(9, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool15 = noiseCancellationSelected.get();
                            } else {
                                bool15 = null;
                            }
                        }
                        if ((j & 99328) != 0) {
                            if (controlOperationViewModel2 != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel2.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            controlOperationViewModel = controlOperationViewModel2;
                            updateRegistration(10, voiceAssistantDefaultSelected);
                            bool16 = voiceAssistantDefaultSelected != null ? voiceAssistantDefaultSelected.get() : null;
                            if ((j & 98304) != 0 || controlOperationViewModel == null) {
                                direction = null;
                            } else {
                                direction = controlOperationViewModel.getDirection();
                            }
                            if ((j & j5) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j7 = j;
                                updateRegistration(11, itemDesc);
                                str4 = itemDesc != null ? itemDesc.get() : null;
                                if ((j7 & j3) != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    updateRegistration(12, enable);
                                    if (enable != null) {
                                        bool17 = enable.get();
                                    } else {
                                        bool17 = null;
                                    }
                                    boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(bool17);
                                    boolean z7 = !zSafeUnbox2;
                                    Boolean bool18 = bool15;
                                    str = str4;
                                    z = zSafeUnbox2;
                                    bool10 = bool18;
                                    Boolean bool19 = bool12;
                                    bool4 = bool17;
                                    bool9 = bool11;
                                    bool2 = bool19;
                                    Boolean bool20 = bool13;
                                    bool7 = bool14;
                                    bool = bool16;
                                    bool8 = bool20;
                                    z3 = z4;
                                    f = f2;
                                    z2 = z7;
                                    j6 = j7;
                                } else {
                                    Boolean bool21 = bool13;
                                    bool7 = bool14;
                                    bool = bool16;
                                    bool8 = bool21;
                                    bool10 = bool15;
                                    z3 = z4;
                                    bool9 = bool11;
                                    bool2 = bool12;
                                    f = f2;
                                    j6 = j7;
                                    bool4 = null;
                                    z2 = false;
                                    str = str4;
                                    z = false;
                                }
                            } else {
                                bool16 = bool16;
                                j7 = j;
                            }
                            if ((j7 & j3) != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(12, enable);
                                if (enable != null) {
                                    bool17 = enable.get();
                                } else {
                                    bool17 = null;
                                }
                                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(bool17);
                                boolean z8 = !zSafeUnbox3;
                                Boolean bool110 = bool15;
                                str = str4;
                                z = zSafeUnbox3;
                                bool10 = bool110;
                                Boolean bool111 = bool12;
                                bool4 = bool17;
                                bool9 = bool11;
                                bool2 = bool111;
                                Boolean bool22 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool22;
                                z3 = z4;
                                f = f2;
                                z2 = z8;
                                j6 = j7;
                            } else {
                                Boolean bool23 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool23;
                                bool10 = bool15;
                                z3 = z4;
                                bool9 = bool11;
                                bool2 = bool12;
                                f = f2;
                                j6 = j7;
                                bool4 = null;
                                z2 = false;
                                str = str4;
                                z = false;
                            }
                        } else {
                            controlOperationViewModel = controlOperationViewModel2;
                        }
                        if ((j & 98304) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & j5) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(11, itemDesc);
                            if (itemDesc != null) {
                            }
                            if ((j7 & j3) != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(12, enable);
                                if (enable != null) {
                                    bool17 = enable.get();
                                } else {
                                    bool17 = null;
                                }
                                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(bool17);
                                boolean z9 = !zSafeUnbox4;
                                Boolean bool112 = bool15;
                                str = str4;
                                z = zSafeUnbox4;
                                bool10 = bool112;
                                Boolean bool113 = bool12;
                                bool4 = bool17;
                                bool9 = bool11;
                                bool2 = bool113;
                                Boolean bool24 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool24;
                                z3 = z4;
                                f = f2;
                                z2 = z9;
                                j6 = j7;
                            } else {
                                Boolean bool25 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool25;
                                bool10 = bool15;
                                z3 = z4;
                                bool9 = bool11;
                                bool2 = bool12;
                                f = f2;
                                j6 = j7;
                                bool4 = null;
                                z2 = false;
                                str = str4;
                                z = false;
                            }
                        } else {
                            bool16 = bool16;
                            j7 = j;
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox5 = ViewDataBinding.safeUnbox(bool17);
                            boolean z10 = !zSafeUnbox5;
                            Boolean bool114 = bool15;
                            str = str4;
                            z = zSafeUnbox5;
                            bool10 = bool114;
                            Boolean bool115 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool115;
                            Boolean bool26 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool26;
                            z3 = z4;
                            f = f2;
                            z2 = z10;
                            j6 = j7;
                        } else {
                            Boolean bool27 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool27;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        j5 = 100352;
                    }
                    if ((j & j2) == 0) {
                        bool14 = null;
                    } else {
                        if (controlOperationViewModel2 != null) {
                            noiseControlVisible = controlOperationViewModel2.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        updateRegistration(8, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool14 = noiseControlVisible.get();
                        } else {
                            bool14 = null;
                        }
                    }
                    if ((j & 98816) == 0) {
                        bool15 = null;
                    } else {
                        if (controlOperationViewModel2 != null) {
                            noiseCancellationSelected = controlOperationViewModel2.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        updateRegistration(9, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool15 = noiseCancellationSelected.get();
                        } else {
                            bool15 = null;
                        }
                    }
                    if ((j & 99328) != 0) {
                        if (controlOperationViewModel2 != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel2.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        controlOperationViewModel = controlOperationViewModel2;
                        updateRegistration(10, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                        }
                        if ((j & 98304) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & j5) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(11, itemDesc);
                            if (itemDesc != null) {
                            }
                            if ((j7 & j3) != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(12, enable);
                                if (enable != null) {
                                    bool17 = enable.get();
                                } else {
                                    bool17 = null;
                                }
                                boolean zSafeUnbox6 = ViewDataBinding.safeUnbox(bool17);
                                boolean z11 = !zSafeUnbox6;
                                Boolean bool116 = bool15;
                                str = str4;
                                z = zSafeUnbox6;
                                bool10 = bool116;
                                Boolean bool117 = bool12;
                                bool4 = bool17;
                                bool9 = bool11;
                                bool2 = bool117;
                                Boolean bool28 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool28;
                                z3 = z4;
                                f = f2;
                                z2 = z11;
                                j6 = j7;
                            } else {
                                Boolean bool29 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool29;
                                bool10 = bool15;
                                z3 = z4;
                                bool9 = bool11;
                                bool2 = bool12;
                                f = f2;
                                j6 = j7;
                                bool4 = null;
                                z2 = false;
                                str = str4;
                                z = false;
                            }
                        } else {
                            bool16 = bool16;
                            j7 = j;
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox7 = ViewDataBinding.safeUnbox(bool17);
                            boolean z12 = !zSafeUnbox7;
                            Boolean bool118 = bool15;
                            str = str4;
                            z = zSafeUnbox7;
                            bool10 = bool118;
                            Boolean bool119 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool119;
                            Boolean bool210 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool210;
                            z3 = z4;
                            f = f2;
                            z2 = z12;
                            j6 = j7;
                        } else {
                            Boolean bool211 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool211;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        controlOperationViewModel = controlOperationViewModel2;
                    }
                    if ((j & 98304) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(11, itemDesc);
                        if (itemDesc != null) {
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox8 = ViewDataBinding.safeUnbox(bool17);
                            boolean z13 = !zSafeUnbox8;
                            Boolean bool1110 = bool15;
                            str = str4;
                            z = zSafeUnbox8;
                            bool10 = bool1110;
                            Boolean bool1111 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool1111;
                            Boolean bool212 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool212;
                            z3 = z4;
                            f = f2;
                            z2 = z13;
                            j6 = j7;
                        } else {
                            Boolean bool213 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool213;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        bool16 = bool16;
                        j7 = j;
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox9 = ViewDataBinding.safeUnbox(bool17);
                        boolean z14 = !zSafeUnbox9;
                        Boolean bool1112 = bool15;
                        str = str4;
                        z = zSafeUnbox9;
                        bool10 = bool1112;
                        Boolean bool1113 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool1113;
                        Boolean bool214 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool214;
                        z3 = z4;
                        f = f2;
                        z2 = z14;
                        j6 = j7;
                    } else {
                        Boolean bool215 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool215;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    j4 = 98432;
                }
                if ((j & 98368) == 0) {
                    bool6 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        voiceAssistantChatGptSelected = controlOperationViewModel2.getVoiceAssistantChatGptSelected();
                    } else {
                        voiceAssistantChatGptSelected = null;
                    }
                    updateRegistration(6, voiceAssistantChatGptSelected);
                    if (voiceAssistantChatGptSelected != null) {
                        bool6 = voiceAssistantChatGptSelected.get();
                    } else {
                        bool6 = null;
                    }
                }
                if ((j & j4) != 0) {
                    if (controlOperationViewModel2 != null) {
                        offSelected = controlOperationViewModel2.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    j5 = 100352;
                    updateRegistration(7, offSelected);
                    if (offSelected != null) {
                    }
                    if ((j & j2) == 0) {
                        bool14 = null;
                    } else {
                        if (controlOperationViewModel2 != null) {
                            noiseControlVisible = controlOperationViewModel2.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        updateRegistration(8, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool14 = noiseControlVisible.get();
                        } else {
                            bool14 = null;
                        }
                    }
                    if ((j & 98816) == 0) {
                        bool15 = null;
                    } else {
                        if (controlOperationViewModel2 != null) {
                            noiseCancellationSelected = controlOperationViewModel2.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        updateRegistration(9, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool15 = noiseCancellationSelected.get();
                        } else {
                            bool15 = null;
                        }
                    }
                    if ((j & 99328) != 0) {
                        if (controlOperationViewModel2 != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel2.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        controlOperationViewModel = controlOperationViewModel2;
                        updateRegistration(10, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                        }
                        if ((j & 98304) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & j5) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(11, itemDesc);
                            if (itemDesc != null) {
                            }
                            if ((j7 & j3) != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(12, enable);
                                if (enable != null) {
                                    bool17 = enable.get();
                                } else {
                                    bool17 = null;
                                }
                                boolean zSafeUnbox10 = ViewDataBinding.safeUnbox(bool17);
                                boolean z15 = !zSafeUnbox10;
                                Boolean bool1114 = bool15;
                                str = str4;
                                z = zSafeUnbox10;
                                bool10 = bool1114;
                                Boolean bool1115 = bool12;
                                bool4 = bool17;
                                bool9 = bool11;
                                bool2 = bool1115;
                                Boolean bool216 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool216;
                                z3 = z4;
                                f = f2;
                                z2 = z15;
                                j6 = j7;
                            } else {
                                Boolean bool217 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool217;
                                bool10 = bool15;
                                z3 = z4;
                                bool9 = bool11;
                                bool2 = bool12;
                                f = f2;
                                j6 = j7;
                                bool4 = null;
                                z2 = false;
                                str = str4;
                                z = false;
                            }
                        } else {
                            bool16 = bool16;
                            j7 = j;
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox11 = ViewDataBinding.safeUnbox(bool17);
                            boolean z16 = !zSafeUnbox11;
                            Boolean bool1116 = bool15;
                            str = str4;
                            z = zSafeUnbox11;
                            bool10 = bool1116;
                            Boolean bool1117 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool1117;
                            Boolean bool218 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool218;
                            z3 = z4;
                            f = f2;
                            z2 = z16;
                            j6 = j7;
                        } else {
                            Boolean bool219 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool219;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        controlOperationViewModel = controlOperationViewModel2;
                    }
                    if ((j & 98304) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(11, itemDesc);
                        if (itemDesc != null) {
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox12 = ViewDataBinding.safeUnbox(bool17);
                            boolean z17 = !zSafeUnbox12;
                            Boolean bool1118 = bool15;
                            str = str4;
                            z = zSafeUnbox12;
                            bool10 = bool1118;
                            Boolean bool1119 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool1119;
                            Boolean bool2110 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool2110;
                            z3 = z4;
                            f = f2;
                            z2 = z17;
                            j6 = j7;
                        } else {
                            Boolean bool2111 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool2111;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        bool16 = bool16;
                        j7 = j;
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox13 = ViewDataBinding.safeUnbox(bool17);
                        boolean z18 = !zSafeUnbox13;
                        Boolean bool11110 = bool15;
                        str = str4;
                        z = zSafeUnbox13;
                        bool10 = bool11110;
                        Boolean bool11111 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool11111;
                        Boolean bool2112 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2112;
                        z3 = z4;
                        f = f2;
                        z2 = z18;
                        j6 = j7;
                    } else {
                        Boolean bool2113 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2113;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    j5 = 100352;
                }
                if ((j & j2) == 0) {
                    bool14 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        noiseControlVisible = controlOperationViewModel2.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    updateRegistration(8, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool14 = noiseControlVisible.get();
                    } else {
                        bool14 = null;
                    }
                }
                if ((j & 98816) == 0) {
                    bool15 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        noiseCancellationSelected = controlOperationViewModel2.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    updateRegistration(9, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool15 = noiseCancellationSelected.get();
                    } else {
                        bool15 = null;
                    }
                }
                if ((j & 99328) != 0) {
                    if (controlOperationViewModel2 != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel2.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    controlOperationViewModel = controlOperationViewModel2;
                    updateRegistration(10, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                    }
                    if ((j & 98304) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(11, itemDesc);
                        if (itemDesc != null) {
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox14 = ViewDataBinding.safeUnbox(bool17);
                            boolean z19 = !zSafeUnbox14;
                            Boolean bool11112 = bool15;
                            str = str4;
                            z = zSafeUnbox14;
                            bool10 = bool11112;
                            Boolean bool11113 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool11113;
                            Boolean bool2114 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool2114;
                            z3 = z4;
                            f = f2;
                            z2 = z19;
                            j6 = j7;
                        } else {
                            Boolean bool2115 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool2115;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        bool16 = bool16;
                        j7 = j;
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox15 = ViewDataBinding.safeUnbox(bool17);
                        boolean z110 = !zSafeUnbox15;
                        Boolean bool11114 = bool15;
                        str = str4;
                        z = zSafeUnbox15;
                        bool10 = bool11114;
                        Boolean bool11115 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool11115;
                        Boolean bool2116 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2116;
                        z3 = z4;
                        f = f2;
                        z2 = z110;
                        j6 = j7;
                    } else {
                        Boolean bool2117 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2117;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    controlOperationViewModel = controlOperationViewModel2;
                }
                if ((j & 98304) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & j5) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(11, itemDesc);
                    if (itemDesc != null) {
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox16 = ViewDataBinding.safeUnbox(bool17);
                        boolean z111 = !zSafeUnbox16;
                        Boolean bool11116 = bool15;
                        str = str4;
                        z = zSafeUnbox16;
                        bool10 = bool11116;
                        Boolean bool11117 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool11117;
                        Boolean bool2118 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2118;
                        z3 = z4;
                        f = f2;
                        z2 = z111;
                        j6 = j7;
                    } else {
                        Boolean bool2119 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2119;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    bool16 = bool16;
                    j7 = j;
                }
                if ((j7 & j3) != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(12, enable);
                    if (enable != null) {
                        bool17 = enable.get();
                    } else {
                        bool17 = null;
                    }
                    boolean zSafeUnbox17 = ViewDataBinding.safeUnbox(bool17);
                    boolean z112 = !zSafeUnbox17;
                    Boolean bool11118 = bool15;
                    str = str4;
                    z = zSafeUnbox17;
                    bool10 = bool11118;
                    Boolean bool11119 = bool12;
                    bool4 = bool17;
                    bool9 = bool11;
                    bool2 = bool11119;
                    Boolean bool21110 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool21110;
                    z3 = z4;
                    f = f2;
                    z2 = z112;
                    j6 = j7;
                } else {
                    Boolean bool21111 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool21111;
                    bool10 = bool15;
                    z3 = z4;
                    bool9 = bool11;
                    bool2 = bool12;
                    f = f2;
                    j6 = j7;
                    bool4 = null;
                    z2 = false;
                    str = str4;
                    z = false;
                }
            } else {
                j3 = 102400;
            }
            if ((j & 98320) == 0) {
                str3 = null;
            } else {
                if (controlOperationViewModel2 != null) {
                    operationName = controlOperationViewModel2.getOperationName();
                } else {
                    operationName = null;
                }
                updateRegistration(4, operationName);
                if (operationName != null) {
                    str3 = operationName.get();
                } else {
                    str3 = null;
                }
            }
            if ((j & 98336) != 0) {
                if (controlOperationViewModel2 != null) {
                    selected = controlOperationViewModel2.getSelected();
                } else {
                    selected = null;
                }
                j4 = 98432;
                updateRegistration(5, selected);
                if (selected != null) {
                }
                if ((j & 98368) == 0) {
                    bool6 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        voiceAssistantChatGptSelected = controlOperationViewModel2.getVoiceAssistantChatGptSelected();
                    } else {
                        voiceAssistantChatGptSelected = null;
                    }
                    updateRegistration(6, voiceAssistantChatGptSelected);
                    if (voiceAssistantChatGptSelected != null) {
                        bool6 = voiceAssistantChatGptSelected.get();
                    } else {
                        bool6 = null;
                    }
                }
                if ((j & j4) != 0) {
                    if (controlOperationViewModel2 != null) {
                        offSelected = controlOperationViewModel2.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    j5 = 100352;
                    updateRegistration(7, offSelected);
                    if (offSelected != null) {
                    }
                    if ((j & j2) == 0) {
                        bool14 = null;
                    } else {
                        if (controlOperationViewModel2 != null) {
                            noiseControlVisible = controlOperationViewModel2.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        updateRegistration(8, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool14 = noiseControlVisible.get();
                        } else {
                            bool14 = null;
                        }
                    }
                    if ((j & 98816) == 0) {
                        bool15 = null;
                    } else {
                        if (controlOperationViewModel2 != null) {
                            noiseCancellationSelected = controlOperationViewModel2.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        updateRegistration(9, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool15 = noiseCancellationSelected.get();
                        } else {
                            bool15 = null;
                        }
                    }
                    if ((j & 99328) != 0) {
                        if (controlOperationViewModel2 != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel2.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        controlOperationViewModel = controlOperationViewModel2;
                        updateRegistration(10, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                        }
                        if ((j & 98304) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & j5) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j7 = j;
                            updateRegistration(11, itemDesc);
                            if (itemDesc != null) {
                            }
                            if ((j7 & j3) != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                updateRegistration(12, enable);
                                if (enable != null) {
                                    bool17 = enable.get();
                                } else {
                                    bool17 = null;
                                }
                                boolean zSafeUnbox18 = ViewDataBinding.safeUnbox(bool17);
                                boolean z113 = !zSafeUnbox18;
                                Boolean bool111110 = bool15;
                                str = str4;
                                z = zSafeUnbox18;
                                bool10 = bool111110;
                                Boolean bool111111 = bool12;
                                bool4 = bool17;
                                bool9 = bool11;
                                bool2 = bool111111;
                                Boolean bool21112 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool21112;
                                z3 = z4;
                                f = f2;
                                z2 = z113;
                                j6 = j7;
                            } else {
                                Boolean bool21113 = bool13;
                                bool7 = bool14;
                                bool = bool16;
                                bool8 = bool21113;
                                bool10 = bool15;
                                z3 = z4;
                                bool9 = bool11;
                                bool2 = bool12;
                                f = f2;
                                j6 = j7;
                                bool4 = null;
                                z2 = false;
                                str = str4;
                                z = false;
                            }
                        } else {
                            bool16 = bool16;
                            j7 = j;
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox19 = ViewDataBinding.safeUnbox(bool17);
                            boolean z114 = !zSafeUnbox19;
                            Boolean bool111112 = bool15;
                            str = str4;
                            z = zSafeUnbox19;
                            bool10 = bool111112;
                            Boolean bool111113 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool111113;
                            Boolean bool21114 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool21114;
                            z3 = z4;
                            f = f2;
                            z2 = z114;
                            j6 = j7;
                        } else {
                            Boolean bool21115 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool21115;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        controlOperationViewModel = controlOperationViewModel2;
                    }
                    if ((j & 98304) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(11, itemDesc);
                        if (itemDesc != null) {
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox110 = ViewDataBinding.safeUnbox(bool17);
                            boolean z115 = !zSafeUnbox110;
                            Boolean bool111114 = bool15;
                            str = str4;
                            z = zSafeUnbox110;
                            bool10 = bool111114;
                            Boolean bool111115 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool111115;
                            Boolean bool21116 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool21116;
                            z3 = z4;
                            f = f2;
                            z2 = z115;
                            j6 = j7;
                        } else {
                            Boolean bool21117 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool21117;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        bool16 = bool16;
                        j7 = j;
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox111 = ViewDataBinding.safeUnbox(bool17);
                        boolean z116 = !zSafeUnbox111;
                        Boolean bool111116 = bool15;
                        str = str4;
                        z = zSafeUnbox111;
                        bool10 = bool111116;
                        Boolean bool111117 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool111117;
                        Boolean bool21118 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool21118;
                        z3 = z4;
                        f = f2;
                        z2 = z116;
                        j6 = j7;
                    } else {
                        Boolean bool21119 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool21119;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    j5 = 100352;
                }
                if ((j & j2) == 0) {
                    bool14 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        noiseControlVisible = controlOperationViewModel2.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    updateRegistration(8, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool14 = noiseControlVisible.get();
                    } else {
                        bool14 = null;
                    }
                }
                if ((j & 98816) == 0) {
                    bool15 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        noiseCancellationSelected = controlOperationViewModel2.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    updateRegistration(9, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool15 = noiseCancellationSelected.get();
                    } else {
                        bool15 = null;
                    }
                }
                if ((j & 99328) != 0) {
                    if (controlOperationViewModel2 != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel2.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    controlOperationViewModel = controlOperationViewModel2;
                    updateRegistration(10, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                    }
                    if ((j & 98304) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(11, itemDesc);
                        if (itemDesc != null) {
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox112 = ViewDataBinding.safeUnbox(bool17);
                            boolean z117 = !zSafeUnbox112;
                            Boolean bool111118 = bool15;
                            str = str4;
                            z = zSafeUnbox112;
                            bool10 = bool111118;
                            Boolean bool111119 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool111119;
                            Boolean bool211110 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool211110;
                            z3 = z4;
                            f = f2;
                            z2 = z117;
                            j6 = j7;
                        } else {
                            Boolean bool211111 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool211111;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        bool16 = bool16;
                        j7 = j;
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox113 = ViewDataBinding.safeUnbox(bool17);
                        boolean z118 = !zSafeUnbox113;
                        Boolean bool1111110 = bool15;
                        str = str4;
                        z = zSafeUnbox113;
                        bool10 = bool1111110;
                        Boolean bool1111111 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool1111111;
                        Boolean bool211112 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool211112;
                        z3 = z4;
                        f = f2;
                        z2 = z118;
                        j6 = j7;
                    } else {
                        Boolean bool211113 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool211113;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    controlOperationViewModel = controlOperationViewModel2;
                }
                if ((j & 98304) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & j5) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(11, itemDesc);
                    if (itemDesc != null) {
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox114 = ViewDataBinding.safeUnbox(bool17);
                        boolean z119 = !zSafeUnbox114;
                        Boolean bool1111112 = bool15;
                        str = str4;
                        z = zSafeUnbox114;
                        bool10 = bool1111112;
                        Boolean bool1111113 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool1111113;
                        Boolean bool211114 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool211114;
                        z3 = z4;
                        f = f2;
                        z2 = z119;
                        j6 = j7;
                    } else {
                        Boolean bool211115 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool211115;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    bool16 = bool16;
                    j7 = j;
                }
                if ((j7 & j3) != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(12, enable);
                    if (enable != null) {
                        bool17 = enable.get();
                    } else {
                        bool17 = null;
                    }
                    boolean zSafeUnbox115 = ViewDataBinding.safeUnbox(bool17);
                    boolean z1110 = !zSafeUnbox115;
                    Boolean bool1111114 = bool15;
                    str = str4;
                    z = zSafeUnbox115;
                    bool10 = bool1111114;
                    Boolean bool1111115 = bool12;
                    bool4 = bool17;
                    bool9 = bool11;
                    bool2 = bool1111115;
                    Boolean bool211116 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool211116;
                    z3 = z4;
                    f = f2;
                    z2 = z1110;
                    j6 = j7;
                } else {
                    Boolean bool211117 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool211117;
                    bool10 = bool15;
                    z3 = z4;
                    bool9 = bool11;
                    bool2 = bool12;
                    f = f2;
                    j6 = j7;
                    bool4 = null;
                    z2 = false;
                    str = str4;
                    z = false;
                }
            } else {
                j4 = 98432;
            }
            if ((j & 98368) == 0) {
                bool6 = null;
            } else {
                if (controlOperationViewModel2 != null) {
                    voiceAssistantChatGptSelected = controlOperationViewModel2.getVoiceAssistantChatGptSelected();
                } else {
                    voiceAssistantChatGptSelected = null;
                }
                updateRegistration(6, voiceAssistantChatGptSelected);
                if (voiceAssistantChatGptSelected != null) {
                    bool6 = voiceAssistantChatGptSelected.get();
                } else {
                    bool6 = null;
                }
            }
            if ((j & j4) != 0) {
                if (controlOperationViewModel2 != null) {
                    offSelected = controlOperationViewModel2.getOffSelected();
                } else {
                    offSelected = null;
                }
                j5 = 100352;
                updateRegistration(7, offSelected);
                if (offSelected != null) {
                }
                if ((j & j2) == 0) {
                    bool14 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        noiseControlVisible = controlOperationViewModel2.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    updateRegistration(8, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool14 = noiseControlVisible.get();
                    } else {
                        bool14 = null;
                    }
                }
                if ((j & 98816) == 0) {
                    bool15 = null;
                } else {
                    if (controlOperationViewModel2 != null) {
                        noiseCancellationSelected = controlOperationViewModel2.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    updateRegistration(9, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool15 = noiseCancellationSelected.get();
                    } else {
                        bool15 = null;
                    }
                }
                if ((j & 99328) != 0) {
                    if (controlOperationViewModel2 != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel2.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    controlOperationViewModel = controlOperationViewModel2;
                    updateRegistration(10, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                    }
                    if ((j & 98304) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j7 = j;
                        updateRegistration(11, itemDesc);
                        if (itemDesc != null) {
                        }
                        if ((j7 & j3) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(12, enable);
                            if (enable != null) {
                                bool17 = enable.get();
                            } else {
                                bool17 = null;
                            }
                            boolean zSafeUnbox116 = ViewDataBinding.safeUnbox(bool17);
                            boolean z1111 = !zSafeUnbox116;
                            Boolean bool1111116 = bool15;
                            str = str4;
                            z = zSafeUnbox116;
                            bool10 = bool1111116;
                            Boolean bool1111117 = bool12;
                            bool4 = bool17;
                            bool9 = bool11;
                            bool2 = bool1111117;
                            Boolean bool211118 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool211118;
                            z3 = z4;
                            f = f2;
                            z2 = z1111;
                            j6 = j7;
                        } else {
                            Boolean bool211119 = bool13;
                            bool7 = bool14;
                            bool = bool16;
                            bool8 = bool211119;
                            bool10 = bool15;
                            z3 = z4;
                            bool9 = bool11;
                            bool2 = bool12;
                            f = f2;
                            j6 = j7;
                            bool4 = null;
                            z2 = false;
                            str = str4;
                            z = false;
                        }
                    } else {
                        bool16 = bool16;
                        j7 = j;
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox117 = ViewDataBinding.safeUnbox(bool17);
                        boolean z1112 = !zSafeUnbox117;
                        Boolean bool1111118 = bool15;
                        str = str4;
                        z = zSafeUnbox117;
                        bool10 = bool1111118;
                        Boolean bool1111119 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool1111119;
                        Boolean bool2111110 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2111110;
                        z3 = z4;
                        f = f2;
                        z2 = z1112;
                        j6 = j7;
                    } else {
                        Boolean bool2111111 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2111111;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    controlOperationViewModel = controlOperationViewModel2;
                }
                if ((j & 98304) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & j5) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(11, itemDesc);
                    if (itemDesc != null) {
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox118 = ViewDataBinding.safeUnbox(bool17);
                        boolean z1113 = !zSafeUnbox118;
                        Boolean bool11111110 = bool15;
                        str = str4;
                        z = zSafeUnbox118;
                        bool10 = bool11111110;
                        Boolean bool11111111 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool11111111;
                        Boolean bool2111112 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2111112;
                        z3 = z4;
                        f = f2;
                        z2 = z1113;
                        j6 = j7;
                    } else {
                        Boolean bool2111113 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2111113;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    bool16 = bool16;
                    j7 = j;
                }
                if ((j7 & j3) != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(12, enable);
                    if (enable != null) {
                        bool17 = enable.get();
                    } else {
                        bool17 = null;
                    }
                    boolean zSafeUnbox119 = ViewDataBinding.safeUnbox(bool17);
                    boolean z1114 = !zSafeUnbox119;
                    Boolean bool11111112 = bool15;
                    str = str4;
                    z = zSafeUnbox119;
                    bool10 = bool11111112;
                    Boolean bool11111113 = bool12;
                    bool4 = bool17;
                    bool9 = bool11;
                    bool2 = bool11111113;
                    Boolean bool2111114 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool2111114;
                    z3 = z4;
                    f = f2;
                    z2 = z1114;
                    j6 = j7;
                } else {
                    Boolean bool2111115 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool2111115;
                    bool10 = bool15;
                    z3 = z4;
                    bool9 = bool11;
                    bool2 = bool12;
                    f = f2;
                    j6 = j7;
                    bool4 = null;
                    z2 = false;
                    str = str4;
                    z = false;
                }
            } else {
                j5 = 100352;
            }
            if ((j & j2) == 0) {
                bool14 = null;
            } else {
                if (controlOperationViewModel2 != null) {
                    noiseControlVisible = controlOperationViewModel2.getNoiseControlVisible();
                } else {
                    noiseControlVisible = null;
                }
                updateRegistration(8, noiseControlVisible);
                if (noiseControlVisible != null) {
                    bool14 = noiseControlVisible.get();
                } else {
                    bool14 = null;
                }
            }
            if ((j & 98816) == 0) {
                bool15 = null;
            } else {
                if (controlOperationViewModel2 != null) {
                    noiseCancellationSelected = controlOperationViewModel2.getNoiseCancellationSelected();
                } else {
                    noiseCancellationSelected = null;
                }
                updateRegistration(9, noiseCancellationSelected);
                if (noiseCancellationSelected != null) {
                    bool15 = noiseCancellationSelected.get();
                } else {
                    bool15 = null;
                }
            }
            if ((j & 99328) != 0) {
                if (controlOperationViewModel2 != null) {
                    voiceAssistantDefaultSelected = controlOperationViewModel2.getVoiceAssistantDefaultSelected();
                } else {
                    voiceAssistantDefaultSelected = null;
                }
                controlOperationViewModel = controlOperationViewModel2;
                updateRegistration(10, voiceAssistantDefaultSelected);
                if (voiceAssistantDefaultSelected != null) {
                }
                if ((j & 98304) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & j5) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j7 = j;
                    updateRegistration(11, itemDesc);
                    if (itemDesc != null) {
                    }
                    if ((j7 & j3) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(12, enable);
                        if (enable != null) {
                            bool17 = enable.get();
                        } else {
                            bool17 = null;
                        }
                        boolean zSafeUnbox1110 = ViewDataBinding.safeUnbox(bool17);
                        boolean z1115 = !zSafeUnbox1110;
                        Boolean bool11111114 = bool15;
                        str = str4;
                        z = zSafeUnbox1110;
                        bool10 = bool11111114;
                        Boolean bool11111115 = bool12;
                        bool4 = bool17;
                        bool9 = bool11;
                        bool2 = bool11111115;
                        Boolean bool2111116 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2111116;
                        z3 = z4;
                        f = f2;
                        z2 = z1115;
                        j6 = j7;
                    } else {
                        Boolean bool2111117 = bool13;
                        bool7 = bool14;
                        bool = bool16;
                        bool8 = bool2111117;
                        bool10 = bool15;
                        z3 = z4;
                        bool9 = bool11;
                        bool2 = bool12;
                        f = f2;
                        j6 = j7;
                        bool4 = null;
                        z2 = false;
                        str = str4;
                        z = false;
                    }
                } else {
                    bool16 = bool16;
                    j7 = j;
                }
                if ((j7 & j3) != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(12, enable);
                    if (enable != null) {
                        bool17 = enable.get();
                    } else {
                        bool17 = null;
                    }
                    boolean zSafeUnbox1111 = ViewDataBinding.safeUnbox(bool17);
                    boolean z1116 = !zSafeUnbox1111;
                    Boolean bool11111116 = bool15;
                    str = str4;
                    z = zSafeUnbox1111;
                    bool10 = bool11111116;
                    Boolean bool11111117 = bool12;
                    bool4 = bool17;
                    bool9 = bool11;
                    bool2 = bool11111117;
                    Boolean bool2111118 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool2111118;
                    z3 = z4;
                    f = f2;
                    z2 = z1116;
                    j6 = j7;
                } else {
                    Boolean bool2111119 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool2111119;
                    bool10 = bool15;
                    z3 = z4;
                    bool9 = bool11;
                    bool2 = bool12;
                    f = f2;
                    j6 = j7;
                    bool4 = null;
                    z2 = false;
                    str = str4;
                    z = false;
                }
            } else {
                controlOperationViewModel = controlOperationViewModel2;
            }
            if ((j & 98304) != 0) {
                direction = null;
            } else {
                direction = null;
            }
            if ((j & j5) != 0) {
                if (controlOperationViewModel != null) {
                    itemDesc = controlOperationViewModel.getItemDesc();
                } else {
                    itemDesc = null;
                }
                j7 = j;
                updateRegistration(11, itemDesc);
                if (itemDesc != null) {
                }
                if ((j7 & j3) != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(12, enable);
                    if (enable != null) {
                        bool17 = enable.get();
                    } else {
                        bool17 = null;
                    }
                    boolean zSafeUnbox1112 = ViewDataBinding.safeUnbox(bool17);
                    boolean z1117 = !zSafeUnbox1112;
                    Boolean bool11111118 = bool15;
                    str = str4;
                    z = zSafeUnbox1112;
                    bool10 = bool11111118;
                    Boolean bool11111119 = bool12;
                    bool4 = bool17;
                    bool9 = bool11;
                    bool2 = bool11111119;
                    Boolean bool21111110 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool21111110;
                    z3 = z4;
                    f = f2;
                    z2 = z1117;
                    j6 = j7;
                } else {
                    Boolean bool21111111 = bool13;
                    bool7 = bool14;
                    bool = bool16;
                    bool8 = bool21111111;
                    bool10 = bool15;
                    z3 = z4;
                    bool9 = bool11;
                    bool2 = bool12;
                    f = f2;
                    j6 = j7;
                    bool4 = null;
                    z2 = false;
                    str = str4;
                    z = false;
                }
            } else {
                bool16 = bool16;
                j7 = j;
            }
            if ((j7 & j3) != 0) {
                if (controlOperationViewModel != null) {
                    enable = controlOperationViewModel.getEnable();
                } else {
                    enable = null;
                }
                updateRegistration(12, enable);
                if (enable != null) {
                    bool17 = enable.get();
                } else {
                    bool17 = null;
                }
                boolean zSafeUnbox1113 = ViewDataBinding.safeUnbox(bool17);
                boolean z1118 = !zSafeUnbox1113;
                Boolean bool111111110 = bool15;
                str = str4;
                z = zSafeUnbox1113;
                bool10 = bool111111110;
                Boolean bool111111111 = bool12;
                bool4 = bool17;
                bool9 = bool11;
                bool2 = bool111111111;
                Boolean bool21111112 = bool13;
                bool7 = bool14;
                bool = bool16;
                bool8 = bool21111112;
                z3 = z4;
                f = f2;
                z2 = z1118;
                j6 = j7;
            } else {
                Boolean bool21111113 = bool13;
                bool7 = bool14;
                bool = bool16;
                bool8 = bool21111113;
                bool10 = bool15;
                z3 = z4;
                bool9 = bool11;
                bool2 = bool12;
                f = f2;
                j6 = j7;
                bool4 = null;
                z2 = false;
                str = str4;
                z = false;
            }
        } else {
            j2 = 98560;
            j3 = 102400;
            j4 = 98432;
            j5 = 100352;
            f = 0.0f;
            z = false;
            bool = null;
            str = null;
            str2 = null;
            bool2 = null;
            bool3 = null;
            bool4 = null;
            str3 = null;
            bool5 = null;
            bool6 = null;
            bool7 = null;
            direction = null;
            z2 = false;
            z3 = false;
            bool8 = null;
            j6 = j;
            bool9 = null;
            bool10 = null;
        }
        if ((j6 & 98312) != 0) {
            BindingAdapter.goneUnless(this.mboundView10, bool2);
        }
        if ((j6 & 98308) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView11.setAlpha(f);
            }
            BindingAdapter.chatGptOption(this.mboundView12, bool3);
            BindingAdapter.goneUnless(this.mboundView13, Boolean.valueOf(z3));
        }
        if ((j6 & 65536) != 0) {
            BindingAdapter.onClick((ViewGroup) this.mboundView11, this.mCallback296);
            BindingAdapter.onClick(this.mboundView14, this.mCallback297);
            BindingAdapter.textLineHeight(this.mboundView4, 22);
            BindingAdapter.onClick(this.mboundView7, this.mCallback293);
            BindingAdapter.onClick(this.mboundView8, this.mCallback294);
            BindingAdapter.onClick(this.mboundView9, this.mCallback295);
        }
        if ((j6 & 98368) != 0) {
            BindingAdapter.viewSelected(this.mboundView12, bool6);
        }
        if ((j6 & 98305) != 0) {
            TextViewBindingAdapter.setText(this.mboundView13, str2);
        }
        if ((j6 & 99328) != 0) {
            BindingAdapter.viewSelected(this.mboundView14, bool);
        }
        if ((j6 & 98304) != 0) {
            BindingAdapter.viewRadius(this.mboundView2, direction);
        }
        if ((j6 & j5) != 0 && getBuildSdkInt() >= 4) {
            this.mboundView3.setContentDescription(str);
        }
        if ((j6 & j3) != 0) {
            ViewBindingAdapter.setOnClick(this.mboundView3, this.mCallback292, z);
            BindingAdapter.invisibleUnless(this.mboundView5, bool4);
            BindingAdapter.goneUnless(this.notTitle, Boolean.valueOf(z2));
        }
        if ((j6 & 98320) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str3);
        }
        if ((j6 & 98336) != 0) {
            BindingAdapter.viewSelected(this.mboundView5, bool5);
        }
        if ((j6 & j2) != 0) {
            BindingAdapter.goneUnless(this.mboundView6, bool7);
        }
        if ((j6 & 98306) != 0) {
            BindingAdapter.viewSelected(this.mboundView7, bool9);
        }
        if ((j6 & 98816) != 0) {
            BindingAdapter.viewSelected(this.mboundView8, bool10);
        }
        if ((j6 & j4) != 0) {
            BindingAdapter.viewSelected(this.mboundView9, bool8);
        }
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                ControlItemViewModel controlItemViewModel = this.mItemViewModel;
                ControlOperationActivity controlOperationActivity = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel = this.mViewModel;
                if (controlOperationActivity != null) {
                    controlOperationActivity.onSelectedOperation(controlOperationViewModel, controlItemViewModel);
                }
                break;
            case 2:
                ControlItemViewModel controlItemViewModel2 = this.mItemViewModel;
                ControlOperationActivity controlOperationActivity2 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel2 = this.mViewModel;
                if (controlOperationActivity2 != null) {
                    controlOperationActivity2.onClickTransparency(controlOperationViewModel2, controlItemViewModel2);
                }
                break;
            case 3:
                ControlItemViewModel controlItemViewModel3 = this.mItemViewModel;
                ControlOperationActivity controlOperationActivity3 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel3 = this.mViewModel;
                if (controlOperationActivity3 != null) {
                    controlOperationActivity3.onClickNoiseCancellation(controlOperationViewModel3, controlItemViewModel3);
                }
                break;
            case 4:
                ControlItemViewModel controlItemViewModel4 = this.mItemViewModel;
                ControlOperationActivity controlOperationActivity4 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel4 = this.mViewModel;
                if (controlOperationActivity4 != null) {
                    controlOperationActivity4.onClickOff(controlOperationViewModel4, controlItemViewModel4);
                }
                break;
            case 5:
                ControlItemViewModel controlItemViewModel5 = this.mItemViewModel;
                ControlOperationActivity controlOperationActivity5 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel5 = this.mViewModel;
                if (controlOperationActivity5 != null) {
                    controlOperationActivity5.onClickChatGpt(controlOperationViewModel5, controlItemViewModel5);
                }
                break;
            case 6:
                ControlItemViewModel controlItemViewModel6 = this.mItemViewModel;
                ControlOperationActivity controlOperationActivity6 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel6 = this.mViewModel;
                if (controlOperationActivity6 != null) {
                    controlOperationActivity6.onClickDefaultVoiceAssistant(controlOperationViewModel6, controlItemViewModel6);
                }
                break;
        }
    }
}
