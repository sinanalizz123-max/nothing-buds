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
import com.nothing.ear.BR;
import com.nothing.ear.generated.callback.OnClickListener;
import com.nothing.ear.stick.control.ControlItemViewModel;
import com.nothing.ear.stick.control.ControlOperationActivity;
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlRadius;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class EarStickControlDialogItemBindingImpl extends EarStickControlDialogItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback6;
    private final View.OnClickListener mCallback7;
    private final View.OnClickListener mCallback8;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView10;
    private final RoundLinearLayout mboundView2;
    private final LinearLayoutCompat mboundView3;
    private final AppCompatTextView mboundView4;
    private final AppCompatImageView mboundView5;
    private final LinearLayoutCompat mboundView6;
    private final LinearLayout mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    public EarStickControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private EarStickControlDialogItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 9, (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        RoundLinearLayout roundLinearLayout = (RoundLinearLayout) bindings[2];
        this.mboundView2 = roundLinearLayout;
        roundLinearLayout.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[3];
        this.mboundView3 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        AppCompatTextView appCompatTextView = (AppCompatTextView) bindings[4];
        this.mboundView4 = appCompatTextView;
        appCompatTextView.setTag(null);
        AppCompatImageView appCompatImageView = (AppCompatImageView) bindings[5];
        this.mboundView5 = appCompatImageView;
        appCompatImageView.setTag(null);
        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) bindings[6];
        this.mboundView6 = linearLayoutCompat2;
        linearLayoutCompat2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[7];
        this.mboundView7 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) bindings[8];
        this.mboundView8 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[9];
        this.mboundView9 = textView3;
        textView3.setTag(null);
        this.notTitle.setTag(null);
        setRootTag(root);
        this.mCallback8 = new OnClickListener(this, 3);
        this.mCallback6 = new OnClickListener(this, 1);
        this.mCallback7 = new OnClickListener(this, 2);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4096L;
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
            setItemViewModel((ControlItemViewModel) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlOperationViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.EarStickControlDialogItemBinding
    public void setEventHandler(ControlOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.EarStickControlDialogItemBinding
    public void setItemViewModel(ControlItemViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.EarStickControlDialogItemBinding
    public void setViewModel(ControlOperationViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 2048;
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
                return onChangeViewModelSelected((ObservableField) object, fieldId);
            case 2:
                return onChangeViewModelChatGptUnableText((ObservableField) object, fieldId);
            case 3:
                return onChangeViewModelVoiceAssistantChatGptSelected((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelVoiceAssistantEnable((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelVoiceAssistantDefaultSelected((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelItemDesc((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelEnable((ObservableField) object, fieldId);
            case 8:
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

    private boolean onChangeViewModelSelected(ObservableField<Boolean> ViewModelSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelChatGptUnableText(ObservableField<String> ViewModelChatGptUnableText, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantChatGptSelected(ObservableField<Boolean> ViewModelVoiceAssistantChatGptSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantEnable(ObservableField<Boolean> ViewModelVoiceAssistantEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantDefaultSelected(ObservableField<Boolean> ViewModelVoiceAssistantDefaultSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelItemDesc(ObservableField<String> ViewModelItemDesc, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelEnable(ObservableField<Boolean> ViewModelEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantVisible(ObservableField<Boolean> ViewModelVoiceAssistantVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0145  */
    /* JADX WARN: Code duplicated, block: B:101:0x014c  */
    /* JADX WARN: Code duplicated, block: B:103:0x0154  */
    /* JADX WARN: Code duplicated, block: B:106:0x015e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:107:0x0160  */
    /* JADX WARN: Code duplicated, block: B:108:0x0165  */
    /* JADX WARN: Code duplicated, block: B:111:0x016d  */
    /* JADX WARN: Code duplicated, block: B:112:0x0177  */
    /* JADX WARN: Code duplicated, block: B:16:0x0045  */
    /* JADX WARN: Code duplicated, block: B:25:0x0063  */
    /* JADX WARN: Code duplicated, block: B:38:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:39:0x008e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0093  */
    /* JADX WARN: Code duplicated, block: B:43:0x009c  */
    /* JADX WARN: Code duplicated, block: B:44:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:50:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:58:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:60:0x00cf A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00da  */
    /* JADX WARN: Code duplicated, block: B:66:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ed A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:77:0x0102  */
    /* JADX WARN: Code duplicated, block: B:80:0x0109 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:82:0x0110  */
    /* JADX WARN: Code duplicated, block: B:85:0x0117 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0119  */
    /* JADX WARN: Code duplicated, block: B:87:0x011e  */
    /* JADX WARN: Code duplicated, block: B:90:0x0127  */
    /* JADX WARN: Code duplicated, block: B:91:0x012e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0137 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:96:0x0139  */
    /* JADX WARN: Code duplicated, block: B:97:0x013e  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        float f;
        Boolean bool;
        boolean z;
        Boolean bool2;
        String str;
        Boolean bool3;
        Boolean bool4;
        ControlRadius direction;
        Boolean bool5;
        String str2;
        String str3;
        boolean z2;
        Boolean bool6;
        boolean z3;
        long j6;
        Boolean bool7;
        boolean zSafeUnbox;
        ObservableField<Boolean> voiceAssistantVisible;
        ObservableField<Boolean> enable;
        ObservableField<String> itemDesc;
        ObservableField<Boolean> voiceAssistantDefaultSelected;
        ObservableField<Boolean> voiceAssistantEnable;
        boolean z4;
        float f2;
        long j7;
        ObservableField<Boolean> voiceAssistantChatGptSelected;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlOperationActivity controlOperationActivity = this.mEventHandler;
        ControlItemViewModel controlItemViewModel = this.mItemViewModel;
        ControlOperationViewModel controlOperationViewModel = this.mViewModel;
        float f3 = 0.0f;
        if ((6655 & j) != 0) {
            if ((j & 6145) == 0) {
                str = null;
            } else {
                ObservableField<String> operationName = controlOperationViewModel != null ? controlOperationViewModel.getOperationName() : null;
                updateRegistration(0, operationName);
                if (operationName != null) {
                    str = operationName.get();
                } else {
                    str = null;
                }
            }
            if ((j & 6146) == 0) {
                bool = null;
            } else {
                ObservableField<Boolean> selected = controlOperationViewModel != null ? controlOperationViewModel.getSelected() : null;
                updateRegistration(1, selected);
                if (selected != null) {
                    bool = selected.get();
                } else {
                    bool = null;
                }
            }
            if ((j & 6148) != 0) {
                ObservableField<String> chatGptUnableText = controlOperationViewModel != null ? controlOperationViewModel.getChatGptUnableText() : null;
                j3 = 6400;
                updateRegistration(2, chatGptUnableText);
                str2 = chatGptUnableText != null ? chatGptUnableText.get() : null;
                if ((j & 6152) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantChatGptSelected = controlOperationViewModel.getVoiceAssistantChatGptSelected();
                    } else {
                        voiceAssistantChatGptSelected = null;
                    }
                    j4 = 6160;
                    updateRegistration(3, voiceAssistantChatGptSelected);
                    bool4 = voiceAssistantChatGptSelected != null ? voiceAssistantChatGptSelected.get() : null;
                    j6 = j & j4;
                    if (j6 != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantEnable = controlOperationViewModel.getVoiceAssistantEnable();
                        } else {
                            voiceAssistantEnable = null;
                        }
                        updateRegistration(4, voiceAssistantEnable);
                        if (voiceAssistantEnable != null) {
                            bool5 = voiceAssistantEnable.get();
                        } else {
                            bool5 = null;
                        }
                        j5 = 6272;
                        boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(bool5);
                        z2 = !zSafeUnbox2;
                        z4 = zSafeUnbox2;
                        if (j6 != 0) {
                            if (z4) {
                                j7 = 16384;
                            } else {
                                j7 = 8192;
                            }
                            j |= j7;
                        }
                        if (z4) {
                            f2 = 1.0f;
                        } else {
                            f2 = 0.38f;
                        }
                        f3 = f2;
                    } else {
                        j5 = 6272;
                        bool5 = null;
                        z2 = false;
                    }
                    if ((j & 6176) == 0) {
                        bool7 = null;
                    } else {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        updateRegistration(5, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool7 = voiceAssistantDefaultSelected.get();
                        } else {
                            bool7 = null;
                        }
                    }
                    if ((j & 6144) != 0 || controlOperationViewModel == null) {
                        direction = null;
                    } else {
                        direction = controlOperationViewModel.getDirection();
                    }
                    if ((j & 6208) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j2 = 6152;
                        updateRegistration(6, itemDesc);
                        str3 = itemDesc != null ? itemDesc.get() : null;
                        if ((j & j5) != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            updateRegistration(7, enable);
                            if (enable != null) {
                                bool6 = enable.get();
                            } else {
                                bool6 = null;
                            }
                            zSafeUnbox = ViewDataBinding.safeUnbox(bool6);
                            z3 = !zSafeUnbox;
                        } else {
                            bool6 = null;
                            zSafeUnbox = false;
                            z3 = false;
                        }
                        if ((j & j3) == 0) {
                            bool3 = null;
                        } else {
                            if (controlOperationViewModel != null) {
                                voiceAssistantVisible = controlOperationViewModel.getVoiceAssistantVisible();
                            } else {
                                voiceAssistantVisible = null;
                            }
                            updateRegistration(8, voiceAssistantVisible);
                            if (voiceAssistantVisible != null) {
                                bool3 = voiceAssistantVisible.get();
                            } else {
                                bool3 = null;
                            }
                        }
                        bool2 = bool7;
                        z = zSafeUnbox;
                        f = f3;
                    } else {
                        j2 = 6152;
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(7, enable);
                        if (enable != null) {
                            bool6 = enable.get();
                        } else {
                            bool6 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool6);
                        z3 = !zSafeUnbox;
                    } else {
                        bool6 = null;
                        zSafeUnbox = false;
                        z3 = false;
                    }
                    if ((j & j3) == 0) {
                        bool3 = null;
                    } else {
                        if (controlOperationViewModel != null) {
                            voiceAssistantVisible = controlOperationViewModel.getVoiceAssistantVisible();
                        } else {
                            voiceAssistantVisible = null;
                        }
                        updateRegistration(8, voiceAssistantVisible);
                        if (voiceAssistantVisible != null) {
                            bool3 = voiceAssistantVisible.get();
                        } else {
                            bool3 = null;
                        }
                    }
                    bool2 = bool7;
                    z = zSafeUnbox;
                    f = f3;
                } else {
                    j4 = 6160;
                }
                j6 = j & j4;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantEnable = controlOperationViewModel.getVoiceAssistantEnable();
                    } else {
                        voiceAssistantEnable = null;
                    }
                    updateRegistration(4, voiceAssistantEnable);
                    if (voiceAssistantEnable != null) {
                        bool5 = voiceAssistantEnable.get();
                    } else {
                        bool5 = null;
                    }
                    j5 = 6272;
                    boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(bool5);
                    z2 = !zSafeUnbox3;
                    if (zSafeUnbox3) {
                    }
                    if (j6 != 0) {
                        if (z4) {
                            j7 = 16384;
                        } else {
                            j7 = 8192;
                        }
                        j |= j7;
                    }
                    if (z4) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.38f;
                    }
                    f3 = f2;
                } else {
                    j5 = 6272;
                    bool5 = null;
                    z2 = false;
                }
                if ((j & 6176) == 0) {
                    bool7 = null;
                } else {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    updateRegistration(5, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool7 = voiceAssistantDefaultSelected.get();
                    } else {
                        bool7 = null;
                    }
                }
                if ((j & 6144) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6208) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j2 = 6152;
                    updateRegistration(6, itemDesc);
                    if (itemDesc != null) {
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(7, enable);
                        if (enable != null) {
                            bool6 = enable.get();
                        } else {
                            bool6 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool6);
                        z3 = !zSafeUnbox;
                    } else {
                        bool6 = null;
                        zSafeUnbox = false;
                        z3 = false;
                    }
                    if ((j & j3) == 0) {
                        bool3 = null;
                    } else {
                        if (controlOperationViewModel != null) {
                            voiceAssistantVisible = controlOperationViewModel.getVoiceAssistantVisible();
                        } else {
                            voiceAssistantVisible = null;
                        }
                        updateRegistration(8, voiceAssistantVisible);
                        if (voiceAssistantVisible != null) {
                            bool3 = voiceAssistantVisible.get();
                        } else {
                            bool3 = null;
                        }
                    }
                    bool2 = bool7;
                    z = zSafeUnbox;
                    f = f3;
                } else {
                    j2 = 6152;
                }
                if ((j & j5) != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(7, enable);
                    if (enable != null) {
                        bool6 = enable.get();
                    } else {
                        bool6 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool6);
                    z3 = !zSafeUnbox;
                } else {
                    bool6 = null;
                    zSafeUnbox = false;
                    z3 = false;
                }
                if ((j & j3) == 0) {
                    bool3 = null;
                } else {
                    if (controlOperationViewModel != null) {
                        voiceAssistantVisible = controlOperationViewModel.getVoiceAssistantVisible();
                    } else {
                        voiceAssistantVisible = null;
                    }
                    updateRegistration(8, voiceAssistantVisible);
                    if (voiceAssistantVisible != null) {
                        bool3 = voiceAssistantVisible.get();
                    } else {
                        bool3 = null;
                    }
                }
                bool2 = bool7;
                z = zSafeUnbox;
                f = f3;
            } else {
                j3 = 6400;
            }
            if ((j & 6152) != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantChatGptSelected = controlOperationViewModel.getVoiceAssistantChatGptSelected();
                } else {
                    voiceAssistantChatGptSelected = null;
                }
                j4 = 6160;
                updateRegistration(3, voiceAssistantChatGptSelected);
                if (voiceAssistantChatGptSelected != null) {
                }
                j6 = j & j4;
                if (j6 != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantEnable = controlOperationViewModel.getVoiceAssistantEnable();
                    } else {
                        voiceAssistantEnable = null;
                    }
                    updateRegistration(4, voiceAssistantEnable);
                    if (voiceAssistantEnable != null) {
                        bool5 = voiceAssistantEnable.get();
                    } else {
                        bool5 = null;
                    }
                    j5 = 6272;
                    boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(bool5);
                    z2 = !zSafeUnbox4;
                    if (zSafeUnbox4) {
                    }
                    if (j6 != 0) {
                        if (z4) {
                            j7 = 16384;
                        } else {
                            j7 = 8192;
                        }
                        j |= j7;
                    }
                    if (z4) {
                        f2 = 1.0f;
                    } else {
                        f2 = 0.38f;
                    }
                    f3 = f2;
                } else {
                    j5 = 6272;
                    bool5 = null;
                    z2 = false;
                }
                if ((j & 6176) == 0) {
                    bool7 = null;
                } else {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    updateRegistration(5, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool7 = voiceAssistantDefaultSelected.get();
                    } else {
                        bool7 = null;
                    }
                }
                if ((j & 6144) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 6208) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j2 = 6152;
                    updateRegistration(6, itemDesc);
                    if (itemDesc != null) {
                    }
                    if ((j & j5) != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        updateRegistration(7, enable);
                        if (enable != null) {
                            bool6 = enable.get();
                        } else {
                            bool6 = null;
                        }
                        zSafeUnbox = ViewDataBinding.safeUnbox(bool6);
                        z3 = !zSafeUnbox;
                    } else {
                        bool6 = null;
                        zSafeUnbox = false;
                        z3 = false;
                    }
                    if ((j & j3) == 0) {
                        bool3 = null;
                    } else {
                        if (controlOperationViewModel != null) {
                            voiceAssistantVisible = controlOperationViewModel.getVoiceAssistantVisible();
                        } else {
                            voiceAssistantVisible = null;
                        }
                        updateRegistration(8, voiceAssistantVisible);
                        if (voiceAssistantVisible != null) {
                            bool3 = voiceAssistantVisible.get();
                        } else {
                            bool3 = null;
                        }
                    }
                    bool2 = bool7;
                    z = zSafeUnbox;
                    f = f3;
                } else {
                    j2 = 6152;
                }
                if ((j & j5) != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(7, enable);
                    if (enable != null) {
                        bool6 = enable.get();
                    } else {
                        bool6 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool6);
                    z3 = !zSafeUnbox;
                } else {
                    bool6 = null;
                    zSafeUnbox = false;
                    z3 = false;
                }
                if ((j & j3) == 0) {
                    bool3 = null;
                } else {
                    if (controlOperationViewModel != null) {
                        voiceAssistantVisible = controlOperationViewModel.getVoiceAssistantVisible();
                    } else {
                        voiceAssistantVisible = null;
                    }
                    updateRegistration(8, voiceAssistantVisible);
                    if (voiceAssistantVisible != null) {
                        bool3 = voiceAssistantVisible.get();
                    } else {
                        bool3 = null;
                    }
                }
                bool2 = bool7;
                z = zSafeUnbox;
                f = f3;
            } else {
                j4 = 6160;
            }
            j6 = j & j4;
            if (j6 != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantEnable = controlOperationViewModel.getVoiceAssistantEnable();
                } else {
                    voiceAssistantEnable = null;
                }
                updateRegistration(4, voiceAssistantEnable);
                if (voiceAssistantEnable != null) {
                    bool5 = voiceAssistantEnable.get();
                } else {
                    bool5 = null;
                }
                j5 = 6272;
                boolean zSafeUnbox5 = ViewDataBinding.safeUnbox(bool5);
                z2 = !zSafeUnbox5;
                if (zSafeUnbox5) {
                }
                if (j6 != 0) {
                    if (z4) {
                        j7 = 16384;
                    } else {
                        j7 = 8192;
                    }
                    j |= j7;
                }
                if (z4) {
                    f2 = 1.0f;
                } else {
                    f2 = 0.38f;
                }
                f3 = f2;
            } else {
                j5 = 6272;
                bool5 = null;
                z2 = false;
            }
            if ((j & 6176) == 0) {
                bool7 = null;
            } else {
                if (controlOperationViewModel != null) {
                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                } else {
                    voiceAssistantDefaultSelected = null;
                }
                updateRegistration(5, voiceAssistantDefaultSelected);
                if (voiceAssistantDefaultSelected != null) {
                    bool7 = voiceAssistantDefaultSelected.get();
                } else {
                    bool7 = null;
                }
            }
            if ((j & 6144) != 0) {
                direction = null;
            } else {
                direction = null;
            }
            if ((j & 6208) != 0) {
                if (controlOperationViewModel != null) {
                    itemDesc = controlOperationViewModel.getItemDesc();
                } else {
                    itemDesc = null;
                }
                j2 = 6152;
                updateRegistration(6, itemDesc);
                if (itemDesc != null) {
                }
                if ((j & j5) != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    updateRegistration(7, enable);
                    if (enable != null) {
                        bool6 = enable.get();
                    } else {
                        bool6 = null;
                    }
                    zSafeUnbox = ViewDataBinding.safeUnbox(bool6);
                    z3 = !zSafeUnbox;
                } else {
                    bool6 = null;
                    zSafeUnbox = false;
                    z3 = false;
                }
                if ((j & j3) == 0) {
                    bool3 = null;
                } else {
                    if (controlOperationViewModel != null) {
                        voiceAssistantVisible = controlOperationViewModel.getVoiceAssistantVisible();
                    } else {
                        voiceAssistantVisible = null;
                    }
                    updateRegistration(8, voiceAssistantVisible);
                    if (voiceAssistantVisible != null) {
                        bool3 = voiceAssistantVisible.get();
                    } else {
                        bool3 = null;
                    }
                }
                bool2 = bool7;
                z = zSafeUnbox;
                f = f3;
            } else {
                j2 = 6152;
            }
            if ((j & j5) != 0) {
                if (controlOperationViewModel != null) {
                    enable = controlOperationViewModel.getEnable();
                } else {
                    enable = null;
                }
                updateRegistration(7, enable);
                if (enable != null) {
                    bool6 = enable.get();
                } else {
                    bool6 = null;
                }
                zSafeUnbox = ViewDataBinding.safeUnbox(bool6);
                z3 = !zSafeUnbox;
            } else {
                bool6 = null;
                zSafeUnbox = false;
                z3 = false;
            }
            if ((j & j3) == 0) {
                bool3 = null;
            } else {
                if (controlOperationViewModel != null) {
                    voiceAssistantVisible = controlOperationViewModel.getVoiceAssistantVisible();
                } else {
                    voiceAssistantVisible = null;
                }
                updateRegistration(8, voiceAssistantVisible);
                if (voiceAssistantVisible != null) {
                    bool3 = voiceAssistantVisible.get();
                } else {
                    bool3 = null;
                }
            }
            bool2 = bool7;
            z = zSafeUnbox;
            f = f3;
        } else {
            j2 = 6152;
            j3 = 6400;
            j4 = 6160;
            j5 = 6272;
            f = 0.0f;
            bool = null;
            z = false;
            bool2 = null;
            str = null;
            bool3 = null;
            bool4 = null;
            direction = null;
            bool5 = null;
            str2 = null;
            str3 = null;
            z2 = false;
            bool6 = null;
            z3 = false;
        }
        if ((j & 4096) != 0) {
            BindingAdapter.onClick(this.mboundView10, this.mCallback8);
            BindingAdapter.textLineHeight(this.mboundView4, 22);
            BindingAdapter.onClick((ViewGroup) this.mboundView7, this.mCallback7);
        }
        if ((j & 6176) != 0) {
            BindingAdapter.viewSelected(this.mboundView10, bool2);
        }
        if ((j & 6144) != 0) {
            BindingAdapter.viewRadius(this.mboundView2, direction);
        }
        if ((j & 6208) != 0 && getBuildSdkInt() >= 4) {
            this.mboundView3.setContentDescription(str3);
        }
        if ((j & j5) != 0) {
            ViewBindingAdapter.setOnClick(this.mboundView3, this.mCallback6, z);
            BindingAdapter.invisibleUnless(this.mboundView5, bool6);
            BindingAdapter.goneUnless(this.notTitle, Boolean.valueOf(z3));
        }
        if ((j & 6145) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str);
        }
        if ((j & 6146) != 0) {
            BindingAdapter.viewSelected(this.mboundView5, bool);
        }
        if ((j & j3) != 0) {
            BindingAdapter.goneUnless(this.mboundView6, bool3);
        }
        if ((j & j4) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView7.setAlpha(f);
            }
            BindingAdapter.chatGptOption(this.mboundView8, bool5);
            BindingAdapter.goneUnless(this.mboundView9, Boolean.valueOf(z2));
        }
        if ((j & j2) != 0) {
            BindingAdapter.viewSelected(this.mboundView8, bool4);
        }
        if ((j & 6148) != 0) {
            TextViewBindingAdapter.setText(this.mboundView9, str2);
        }
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        if (sourceId == 1) {
            ControlItemViewModel controlItemViewModel = this.mItemViewModel;
            ControlOperationActivity controlOperationActivity = this.mEventHandler;
            ControlOperationViewModel controlOperationViewModel = this.mViewModel;
            if (controlOperationActivity != null) {
                controlOperationActivity.onSelectedOperation(controlOperationViewModel, controlItemViewModel);
                return;
            }
            return;
        }
        if (sourceId == 2) {
            ControlItemViewModel controlItemViewModel2 = this.mItemViewModel;
            ControlOperationActivity controlOperationActivity2 = this.mEventHandler;
            ControlOperationViewModel controlOperationViewModel2 = this.mViewModel;
            if (controlOperationActivity2 != null) {
                controlOperationActivity2.onClickChatGpt(controlOperationViewModel2, controlItemViewModel2);
                return;
            }
            return;
        }
        if (sourceId != 3) {
            return;
        }
        ControlItemViewModel controlItemViewModel3 = this.mItemViewModel;
        ControlOperationActivity controlOperationActivity3 = this.mEventHandler;
        ControlOperationViewModel controlOperationViewModel3 = this.mViewModel;
        if (controlOperationActivity3 != null) {
            controlOperationActivity3.onClickDefaultVoiceAssistant(controlOperationViewModel3, controlItemViewModel3);
        }
    }
}
