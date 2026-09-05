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
import com.nothing.earbase.control.ControlOperationViewModel;
import com.nothing.earbase.control.entity.ControlRadius;
import com.nothing.gligar.control.ControlCaseOperationActivity;
import com.nothing.gligar.control.ControlItemViewModel;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class GligarControlCaseDialogItemBindingImpl extends GligarControlCaseDialogItemBinding implements OnClickListener.Listener {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds = null;
    private final View.OnClickListener mCallback303;
    private final View.OnClickListener mCallback304;
    private final View.OnClickListener mCallback305;
    private final View.OnClickListener mCallback306;
    private final View.OnClickListener mCallback307;
    private final View.OnClickListener mCallback308;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;
    private final TextView mboundView10;
    private final LinearLayoutCompat mboundView11;
    private final LinearLayout mboundView12;
    private final TextView mboundView13;
    private final TextView mboundView14;
    private final TextView mboundView15;
    private final RoundLinearLayout mboundView2;
    private final LinearLayoutCompat mboundView3;
    private final AppCompatTextView mboundView4;
    private final AppCompatImageView mboundView5;
    private final TextView mboundView6;
    private final LinearLayoutCompat mboundView7;
    private final TextView mboundView8;
    private final TextView mboundView9;

    public GligarControlCaseDialogItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private GligarControlCaseDialogItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 16, (TextView) bindings[1]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[10];
        this.mboundView10 = textView;
        textView.setTag(null);
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[11];
        this.mboundView11 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[12];
        this.mboundView12 = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) bindings[13];
        this.mboundView13 = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) bindings[14];
        this.mboundView14 = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) bindings[15];
        this.mboundView15 = textView4;
        textView4.setTag(null);
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
        TextView textView5 = (TextView) bindings[6];
        this.mboundView6 = textView5;
        textView5.setTag(null);
        LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) bindings[7];
        this.mboundView7 = linearLayoutCompat3;
        linearLayoutCompat3.setTag(null);
        TextView textView6 = (TextView) bindings[8];
        this.mboundView8 = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) bindings[9];
        this.mboundView9 = textView7;
        textView7.setTag(null);
        this.notTitle.setTag(null);
        setRootTag(root);
        this.mCallback306 = new OnClickListener(this, 4);
        this.mCallback303 = new OnClickListener(this, 1);
        this.mCallback307 = new OnClickListener(this, 5);
        this.mCallback304 = new OnClickListener(this, 2);
        this.mCallback308 = new OnClickListener(this, 6);
        this.mCallback305 = new OnClickListener(this, 3);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 524288L;
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
            setEventHandler((ControlCaseOperationActivity) variable);
            return true;
        }
        if (BR.viewModel != variableId) {
            return false;
        }
        setViewModel((ControlOperationViewModel) variable);
        return true;
    }

    @Override // com.nothing.ear.databinding.GligarControlCaseDialogItemBinding
    public void setItemViewModel(ControlItemViewModel ItemViewModel) {
        this.mItemViewModel = ItemViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 65536;
        }
        notifyPropertyChanged(BR.itemViewModel);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.GligarControlCaseDialogItemBinding
    public void setEventHandler(ControlCaseOperationActivity EventHandler) {
        this.mEventHandler = EventHandler;
        synchronized (this) {
            this.mDirtyFlags |= 131072;
        }
        notifyPropertyChanged(BR.eventHandler);
        super.requestRebind();
    }

    @Override // com.nothing.ear.databinding.GligarControlCaseDialogItemBinding
    public void setViewModel(ControlOperationViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized (this) {
            this.mDirtyFlags |= 262144;
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
                return onChangeViewModelNewsPromptVisibility((ObservableField) object, fieldId);
            case 4:
                return onChangeViewModelVoiceAssistantVisible((ObservableField) object, fieldId);
            case 5:
                return onChangeViewModelOperationName((ObservableField) object, fieldId);
            case 6:
                return onChangeViewModelNewsPromptName((ObservableField) object, fieldId);
            case 7:
                return onChangeViewModelSelected((ObservableField) object, fieldId);
            case 8:
                return onChangeViewModelVoiceAssistantChatGptSelected((ObservableField) object, fieldId);
            case 9:
                return onChangeViewModelIsCallGesture((ObservableField) object, fieldId);
            case 10:
                return onChangeViewModelOffSelected((ObservableField) object, fieldId);
            case 11:
                return onChangeViewModelNoiseControlVisible((ObservableField) object, fieldId);
            case 12:
                return onChangeViewModelNoiseCancellationSelected((ObservableField) object, fieldId);
            case 13:
                return onChangeViewModelVoiceAssistantDefaultSelected((ObservableField) object, fieldId);
            case 14:
                return onChangeViewModelItemDesc((ObservableField) object, fieldId);
            case 15:
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

    private boolean onChangeViewModelNewsPromptVisibility(ObservableField<Boolean> ViewModelNewsPromptVisibility, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantVisible(ObservableField<Boolean> ViewModelVoiceAssistantVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        return true;
    }

    private boolean onChangeViewModelOperationName(ObservableField<String> ViewModelOperationName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        return true;
    }

    private boolean onChangeViewModelNewsPromptName(ObservableField<String> ViewModelNewsPromptName, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 64;
        }
        return true;
    }

    private boolean onChangeViewModelSelected(ObservableField<Boolean> ViewModelSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 128;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantChatGptSelected(ObservableField<Boolean> ViewModelVoiceAssistantChatGptSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 256;
        }
        return true;
    }

    private boolean onChangeViewModelIsCallGesture(ObservableField<Boolean> ViewModelIsCallGesture, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 512;
        }
        return true;
    }

    private boolean onChangeViewModelOffSelected(ObservableField<Boolean> ViewModelOffSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 1024;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseControlVisible(ObservableField<Boolean> ViewModelNoiseControlVisible, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 2048;
        }
        return true;
    }

    private boolean onChangeViewModelNoiseCancellationSelected(ObservableField<Boolean> ViewModelNoiseCancellationSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 4096;
        }
        return true;
    }

    private boolean onChangeViewModelVoiceAssistantDefaultSelected(ObservableField<Boolean> ViewModelVoiceAssistantDefaultSelected, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 8192;
        }
        return true;
    }

    private boolean onChangeViewModelItemDesc(ObservableField<String> ViewModelItemDesc, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 16384;
        }
        return true;
    }

    private boolean onChangeViewModelEnable(ObservableField<Boolean> ViewModelEnable, int fieldId) {
        if (fieldId != BR._all) {
            return false;
        }
        synchronized (this) {
            this.mDirtyFlags |= 32768;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x019d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:110:0x019f  */
    /* JADX WARN: Code duplicated, block: B:111:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:114:0x01af  */
    /* JADX WARN: Code duplicated, block: B:115:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:119:0x01c3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:121:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:125:0x01dc  */
    /* JADX WARN: Code duplicated, block: B:129:0x01e6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:131:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:135:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:139:0x020c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:140:0x020e  */
    /* JADX WARN: Code duplicated, block: B:141:0x0213  */
    /* JADX WARN: Code duplicated, block: B:144:0x021e  */
    /* JADX WARN: Code duplicated, block: B:145:0x0225  */
    /* JADX WARN: Code duplicated, block: B:149:0x0232 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:150:0x0234  */
    /* JADX WARN: Code duplicated, block: B:151:0x0239  */
    /* JADX WARN: Code duplicated, block: B:154:0x0244  */
    /* JADX WARN: Code duplicated, block: B:155:0x024b  */
    /* JADX WARN: Code duplicated, block: B:159:0x0255 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:160:0x0257  */
    /* JADX WARN: Code duplicated, block: B:161:0x025c  */
    /* JADX WARN: Code duplicated, block: B:164:0x0267  */
    /* JADX WARN: Code duplicated, block: B:165:0x026e  */
    /* JADX WARN: Code duplicated, block: B:169:0x0278 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:16:0x005c  */
    /* JADX WARN: Code duplicated, block: B:171:0x027f  */
    /* JADX WARN: Code duplicated, block: B:174:0x028a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:175:0x028c  */
    /* JADX WARN: Code duplicated, block: B:176:0x0297  */
    /* JADX WARN: Code duplicated, block: B:179:0x02a4  */
    /* JADX WARN: Code duplicated, block: B:180:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:184:0x02b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:185:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:186:0x02be  */
    /* JADX WARN: Code duplicated, block: B:189:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:192:0x02d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:194:0x02df  */
    /* JADX WARN: Code duplicated, block: B:195:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:197:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:25:0x007b  */
    /* JADX WARN: Code duplicated, block: B:78:0x0135  */
    /* JADX WARN: Code duplicated, block: B:87:0x0155  */
    /* JADX WARN: Code duplicated, block: B:96:0x0173  */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ControlOperationViewModel controlOperationViewModel;
        long j2;
        long j3;
        long j4;
        long j5;
        String str;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        String str2;
        Boolean bool5;
        Boolean bool6;
        String str3;
        String str4;
        ControlRadius direction;
        Boolean bool7;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        boolean zSafeUnbox;
        float f;
        float f2;
        boolean z;
        boolean z2;
        Boolean bool12;
        boolean zSafeUnbox2;
        boolean z3;
        float f3;
        boolean zSafeUnbox3;
        String str5;
        Boolean bool13;
        Boolean bool14;
        Boolean bool15;
        Boolean bool16;
        Boolean bool17;
        Boolean bool18;
        Boolean bool19;
        Boolean bool20;
        long j6;
        String str6;
        long j7;
        ObservableField<Boolean> enable;
        long j8;
        ObservableField<String> itemDesc;
        ObservableField<Boolean> voiceAssistantDefaultSelected;
        ObservableField<Boolean> noiseCancellationSelected;
        ObservableField<Boolean> noiseControlVisible;
        ObservableField<Boolean> offSelected;
        ObservableField<Boolean> observableFieldIsCallGesture;
        ObservableField<Boolean> voiceAssistantChatGptSelected;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        ControlItemViewModel controlItemViewModel = this.mItemViewModel;
        ControlCaseOperationActivity controlCaseOperationActivity = this.mEventHandler;
        ControlOperationViewModel controlOperationViewModel2 = this.mViewModel;
        ObservableField<Boolean> newsPromptVisibility = null;
        if ((851967 & j) != 0) {
            if ((j & 786433) == 0) {
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
            if ((j & 786434) == 0) {
                bool9 = null;
            } else {
                ObservableField<Boolean> transSelected = controlOperationViewModel2 != null ? controlOperationViewModel2.getTransSelected() : null;
                updateRegistration(1, transSelected);
                if (transSelected != null) {
                    bool9 = transSelected.get();
                } else {
                    bool9 = null;
                }
            }
            long j9 = j & 786436;
            if (j9 != 0) {
                ObservableField<Boolean> voiceAssistantEnable = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantEnable() : null;
                j2 = 794624;
                updateRegistration(2, voiceAssistantEnable);
                bool5 = voiceAssistantEnable != null ? voiceAssistantEnable.get() : null;
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(bool5);
                z2 = !zSafeUnbox4;
                boolean z4 = zSafeUnbox4;
                if (j9 != 0) {
                    j |= z4 ? 33554432L : 16777216L;
                }
                f3 = z4 ? 1.0f : 0.38f;
            } else {
                j2 = 794624;
                bool5 = null;
                f3 = 0.0f;
                z2 = false;
            }
            long j10 = j & 786440;
            if (j10 != 0) {
                newsPromptVisibility = controlOperationViewModel2 != null ? controlOperationViewModel2.getNewsPromptVisibility() : null;
                j3 = 786560;
                updateRegistration(3, newsPromptVisibility);
                bool8 = newsPromptVisibility != null ? newsPromptVisibility.get() : null;
                j4 = 786496;
                zSafeUnbox3 = ViewDataBinding.safeUnbox(bool8);
                boolean z5 = zSafeUnbox3;
                if (j10 != 0) {
                    j |= z5 ? 2097152L : 1048576L;
                }
                f2 = z5 ? 0.4f : 1.0f;
            } else {
                j3 = 786560;
                j4 = 786496;
                newsPromptVisibility = null;
                bool8 = null;
                zSafeUnbox3 = false;
                f2 = 0.0f;
            }
            if ((j & 786448) == 0) {
                bool4 = null;
            } else {
                ObservableField<Boolean> voiceAssistantVisible = controlOperationViewModel2 != null ? controlOperationViewModel2.getVoiceAssistantVisible() : null;
                updateRegistration(4, voiceAssistantVisible);
                if (voiceAssistantVisible != null) {
                    bool4 = voiceAssistantVisible.get();
                } else {
                    bool4 = null;
                }
            }
            if ((j & 786464) == 0) {
                str = null;
            } else {
                ObservableField<String> operationName = controlOperationViewModel2 != null ? controlOperationViewModel2.getOperationName() : null;
                updateRegistration(5, operationName);
                if (operationName != null) {
                    str = operationName.get();
                } else {
                    str = null;
                }
            }
            if ((j & j4) == 0) {
                str5 = null;
            } else {
                ObservableField<String> newsPromptName = controlOperationViewModel2 != null ? controlOperationViewModel2.getNewsPromptName() : null;
                updateRegistration(6, newsPromptName);
                if (newsPromptName != null) {
                    str5 = newsPromptName.get();
                } else {
                    str5 = null;
                }
            }
            if ((j & j3) != 0) {
                ObservableField<Boolean> selected = controlOperationViewModel2 != null ? controlOperationViewModel2.getSelected() : null;
                controlOperationViewModel = controlOperationViewModel2;
                updateRegistration(7, selected);
                if (selected != null) {
                    bool13 = selected.get();
                }
                if ((j & 786688) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantChatGptSelected = controlOperationViewModel.getVoiceAssistantChatGptSelected();
                    } else {
                        voiceAssistantChatGptSelected = null;
                    }
                    bool = bool13;
                    updateRegistration(8, voiceAssistantChatGptSelected);
                    if (voiceAssistantChatGptSelected != null) {
                        bool14 = voiceAssistantChatGptSelected.get();
                    }
                    if ((j & 786944) != 0) {
                        if (controlOperationViewModel != null) {
                            observableFieldIsCallGesture = controlOperationViewModel.isCallGesture();
                        } else {
                            observableFieldIsCallGesture = null;
                        }
                        bool3 = bool14;
                        updateRegistration(9, observableFieldIsCallGesture);
                        if (observableFieldIsCallGesture != null) {
                            bool15 = observableFieldIsCallGesture.get();
                        }
                        if ((j & 787456) != 0) {
                            if (controlOperationViewModel != null) {
                                offSelected = controlOperationViewModel.getOffSelected();
                            } else {
                                offSelected = null;
                            }
                            bool11 = bool15;
                            updateRegistration(10, offSelected);
                            if (offSelected != null) {
                                bool16 = offSelected.get();
                            }
                            if ((j & 788480) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                                } else {
                                    noiseControlVisible = null;
                                }
                                bool2 = bool16;
                                updateRegistration(11, noiseControlVisible);
                                if (noiseControlVisible != null) {
                                    bool17 = noiseControlVisible.get();
                                }
                                if ((j & 790528) != 0) {
                                    if (controlOperationViewModel != null) {
                                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                    } else {
                                        noiseCancellationSelected = null;
                                    }
                                    bool18 = bool17;
                                    updateRegistration(12, noiseCancellationSelected);
                                    if (noiseCancellationSelected != null) {
                                        bool19 = noiseCancellationSelected.get();
                                    }
                                    if ((j & j2) != 0) {
                                        if (controlOperationViewModel != null) {
                                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                        } else {
                                            voiceAssistantDefaultSelected = null;
                                        }
                                        bool10 = bool19;
                                        updateRegistration(13, voiceAssistantDefaultSelected);
                                        if (voiceAssistantDefaultSelected != null) {
                                            bool20 = voiceAssistantDefaultSelected.get();
                                        }
                                        if ((j & 786432) != 0 || controlOperationViewModel == null) {
                                            direction = null;
                                        } else {
                                            direction = controlOperationViewModel.getDirection();
                                        }
                                        if ((j & 802816) != 0) {
                                            if (controlOperationViewModel != null) {
                                                itemDesc = controlOperationViewModel.getItemDesc();
                                            } else {
                                                itemDesc = null;
                                            }
                                            j6 = j;
                                            updateRegistration(14, itemDesc);
                                            if (itemDesc != null) {
                                                str6 = itemDesc.get();
                                            }
                                            j7 = j6 & 819208;
                                            if (j7 != 0) {
                                                if (controlOperationViewModel != null) {
                                                    enable = controlOperationViewModel.getEnable();
                                                } else {
                                                    enable = null;
                                                }
                                                String str7 = str6;
                                                updateRegistration(15, enable);
                                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                                if (j7 != 0) {
                                                    j8 = j6;
                                                } else if (zSafeUnbox) {
                                                    j8 = j6 | 8388608;
                                                } else {
                                                    j8 = j6 | 4194304;
                                                }
                                                str3 = str7;
                                                j5 = j8;
                                            } else {
                                                str3 = str6;
                                                zSafeUnbox = false;
                                                j5 = j6;
                                            }
                                            str4 = str5;
                                            f = f3;
                                            z = zSafeUnbox3;
                                            bool7 = bool18;
                                            bool6 = bool20;
                                        } else {
                                            bool20 = bool20;
                                            j6 = j;
                                        }
                                        str6 = null;
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str8 = str6;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            str3 = str8;
                                            j5 = j8;
                                        } else {
                                            str3 = str6;
                                            zSafeUnbox = false;
                                            j5 = j6;
                                        }
                                        str4 = str5;
                                        f = f3;
                                        z = zSafeUnbox3;
                                        bool7 = bool18;
                                        bool6 = bool20;
                                    } else {
                                        bool10 = bool19;
                                    }
                                    bool20 = null;
                                    if ((j & 786432) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 802816) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j6 = j;
                                        updateRegistration(14, itemDesc);
                                        if (itemDesc != null) {
                                            str6 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str9 = str6;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            str3 = str9;
                                            j5 = j8;
                                        } else {
                                            str3 = str6;
                                            zSafeUnbox = false;
                                            j5 = j6;
                                        }
                                        str4 = str5;
                                        f = f3;
                                        z = zSafeUnbox3;
                                        bool7 = bool18;
                                        bool6 = bool20;
                                    } else {
                                        bool20 = bool20;
                                        j6 = j;
                                    }
                                    str6 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str10 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str10;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool18 = bool17;
                                }
                                bool19 = null;
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool10 = bool19;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool20 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 786432) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 802816) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j6 = j;
                                        updateRegistration(14, itemDesc);
                                        if (itemDesc != null) {
                                            str6 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str11 = str6;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            str3 = str11;
                                            j5 = j8;
                                        } else {
                                            str3 = str6;
                                            zSafeUnbox = false;
                                            j5 = j6;
                                        }
                                        str4 = str5;
                                        f = f3;
                                        z = zSafeUnbox3;
                                        bool7 = bool18;
                                        bool6 = bool20;
                                    } else {
                                        bool20 = bool20;
                                        j6 = j;
                                    }
                                    str6 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str12 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str12;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool10 = bool19;
                                }
                                bool20 = null;
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str13 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str13;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str14 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str14;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool2 = bool16;
                            }
                            bool17 = null;
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool18 = bool17;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool19 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool10 = bool19;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool20 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 786432) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 802816) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j6 = j;
                                        updateRegistration(14, itemDesc);
                                        if (itemDesc != null) {
                                            str6 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str15 = str6;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            str3 = str15;
                                            j5 = j8;
                                        } else {
                                            str3 = str6;
                                            zSafeUnbox = false;
                                            j5 = j6;
                                        }
                                        str4 = str5;
                                        f = f3;
                                        z = zSafeUnbox3;
                                        bool7 = bool18;
                                        bool6 = bool20;
                                    } else {
                                        bool20 = bool20;
                                        j6 = j;
                                    }
                                    str6 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str16 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str16;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool10 = bool19;
                                }
                                bool20 = null;
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str17 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str17;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str18 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str18;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool18 = bool17;
                            }
                            bool19 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str19 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str19;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str110 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str110;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool11 = bool15;
                        }
                        bool16 = null;
                        if ((j & 788480) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool2 = bool16;
                            updateRegistration(11, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool17 = noiseControlVisible.get();
                            }
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool18 = bool17;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool19 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool10 = bool19;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool20 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 786432) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 802816) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j6 = j;
                                        updateRegistration(14, itemDesc);
                                        if (itemDesc != null) {
                                            str6 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str113 = str6;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            str3 = str113;
                                            j5 = j8;
                                        } else {
                                            str3 = str6;
                                            zSafeUnbox = false;
                                            j5 = j6;
                                        }
                                        str4 = str5;
                                        f = f3;
                                        z = zSafeUnbox3;
                                        bool7 = bool18;
                                        bool6 = bool20;
                                    } else {
                                        bool20 = bool20;
                                        j6 = j;
                                    }
                                    str6 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str114 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str114;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool10 = bool19;
                                }
                                bool20 = null;
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str115 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str115;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str116 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str116;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool18 = bool17;
                            }
                            bool19 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str117 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str117;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str118 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str118;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str119 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str119;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1110 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1110;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool2 = bool16;
                        }
                        bool17 = null;
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str1111 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str1111;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1112 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1112;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1113 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1113;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1114 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1114;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1115 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1115;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1116 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1116;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool3 = bool14;
                    }
                    bool15 = null;
                    if ((j & 787456) != 0) {
                        if (controlOperationViewModel != null) {
                            offSelected = controlOperationViewModel.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        bool11 = bool15;
                        updateRegistration(10, offSelected);
                        if (offSelected != null) {
                            bool16 = offSelected.get();
                        }
                        if ((j & 788480) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool2 = bool16;
                            updateRegistration(11, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool17 = noiseControlVisible.get();
                            }
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool18 = bool17;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool19 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool10 = bool19;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool20 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 786432) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 802816) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j6 = j;
                                        updateRegistration(14, itemDesc);
                                        if (itemDesc != null) {
                                            str6 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str1119 = str6;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            str3 = str1119;
                                            j5 = j8;
                                        } else {
                                            str3 = str6;
                                            zSafeUnbox = false;
                                            j5 = j6;
                                        }
                                        str4 = str5;
                                        f = f3;
                                        z = zSafeUnbox3;
                                        bool7 = bool18;
                                        bool6 = bool20;
                                    } else {
                                        bool20 = bool20;
                                        j6 = j;
                                    }
                                    str6 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11110 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11110;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool10 = bool19;
                                }
                                bool20 = null;
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11112 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11112;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool18 = bool17;
                            }
                            bool19 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11113 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11113;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11114 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11114;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11115 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11115;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11116 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11116;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool2 = bool16;
                        }
                        bool17 = null;
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11117 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11117;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11118 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11118;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11119 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11119;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111110 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111110;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111113 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111113;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111114 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111114;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool11 = bool15;
                    }
                    bool16 = null;
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool2 = bool16;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool17 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111115 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str111115;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111116 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111116;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111117 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111117;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111118 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111118;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111119 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111119;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111110 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111110;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111112 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111112;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool2 = bool16;
                    }
                    bool17 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111113 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111113;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111114 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111114;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111115 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111115;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111116 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111116;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111119 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111119;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111110 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111110;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool = bool13;
                }
                bool14 = null;
                if ((j & 786944) != 0) {
                    if (controlOperationViewModel != null) {
                        observableFieldIsCallGesture = controlOperationViewModel.isCallGesture();
                    } else {
                        observableFieldIsCallGesture = null;
                    }
                    bool3 = bool14;
                    updateRegistration(9, observableFieldIsCallGesture);
                    if (observableFieldIsCallGesture != null) {
                        bool15 = observableFieldIsCallGesture.get();
                    }
                    if ((j & 787456) != 0) {
                        if (controlOperationViewModel != null) {
                            offSelected = controlOperationViewModel.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        bool11 = bool15;
                        updateRegistration(10, offSelected);
                        if (offSelected != null) {
                            bool16 = offSelected.get();
                        }
                        if ((j & 788480) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool2 = bool16;
                            updateRegistration(11, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool17 = noiseControlVisible.get();
                            }
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool18 = bool17;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool19 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool10 = bool19;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool20 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 786432) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 802816) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j6 = j;
                                        updateRegistration(14, itemDesc);
                                        if (itemDesc != null) {
                                            str6 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str11111111 = str6;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            str3 = str11111111;
                                            j5 = j8;
                                        } else {
                                            str3 = str6;
                                            zSafeUnbox = false;
                                            j5 = j6;
                                        }
                                        str4 = str5;
                                        f = f3;
                                        z = zSafeUnbox3;
                                        bool7 = bool18;
                                        bool6 = bool20;
                                    } else {
                                        bool20 = bool20;
                                        j6 = j;
                                    }
                                    str6 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111112 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111112;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool10 = bool19;
                                }
                                bool20 = null;
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111113 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111113;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111114 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111114;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool18 = bool17;
                            }
                            bool19 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111115 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111115;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111116 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111116;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111117 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111117;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111118 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111118;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool2 = bool16;
                        }
                        bool17 = null;
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111119 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111119;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111110 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111110;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111113 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111113;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111114 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111114;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111115 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111115;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111116 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111116;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool11 = bool15;
                    }
                    bool16 = null;
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool2 = bool16;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool17 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111111117 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str111111117;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111118 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111118;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111119 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111119;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111110 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111110;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111111111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111113 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111113;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111114 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111114;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool2 = bool16;
                    }
                    bool17 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111115 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111111115;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111116 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111116;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111119 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111119;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111110 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111110;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111112 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111112;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool3 = bool14;
                }
                bool15 = null;
                if ((j & 787456) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool11 = bool15;
                    updateRegistration(10, offSelected);
                    if (offSelected != null) {
                        bool16 = offSelected.get();
                    }
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool2 = bool16;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool17 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111113 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111111113;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111114 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111111114;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111115 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111111115;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111116 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111111116;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111117 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111111117;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111118 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111111118;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111119 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111111119;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111110 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111110;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool2 = bool16;
                    }
                    bool17 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111113 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111113;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111114 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111114;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111115 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111115;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111116 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111116;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111117 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111117;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str111111111118 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str111111111118;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool11 = bool15;
                }
                bool16 = null;
                if ((j & 788480) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool2 = bool16;
                    updateRegistration(11, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool17 = noiseControlVisible.get();
                    }
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111119 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111119;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111110 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111110;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111112 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111112;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111113 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111113;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111114 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111114;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111115 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111115;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111116 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str1111111111116;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool2 = bool16;
                }
                bool17 = null;
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool18 = bool17;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool19 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111119 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111119;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111110 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111110;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool18 = bool17;
                }
                bool19 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool10 = bool19;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool20 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111112 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111112;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool10 = bool19;
                }
                bool20 = null;
                if ((j & 786432) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 802816) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j6 = j;
                    updateRegistration(14, itemDesc);
                    if (itemDesc != null) {
                        str6 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111113 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111113;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool20 = bool20;
                    j6 = j;
                }
                str6 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str11111111111114 = str6;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    str3 = str11111111111114;
                    j5 = j8;
                } else {
                    str3 = str6;
                    zSafeUnbox = false;
                    j5 = j6;
                }
                str4 = str5;
                f = f3;
                z = zSafeUnbox3;
                bool7 = bool18;
                bool6 = bool20;
            } else {
                controlOperationViewModel = controlOperationViewModel2;
            }
            bool13 = null;
            if ((j & 786688) != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantChatGptSelected = controlOperationViewModel.getVoiceAssistantChatGptSelected();
                } else {
                    voiceAssistantChatGptSelected = null;
                }
                bool = bool13;
                updateRegistration(8, voiceAssistantChatGptSelected);
                if (voiceAssistantChatGptSelected != null) {
                    bool14 = voiceAssistantChatGptSelected.get();
                }
                if ((j & 786944) != 0) {
                    if (controlOperationViewModel != null) {
                        observableFieldIsCallGesture = controlOperationViewModel.isCallGesture();
                    } else {
                        observableFieldIsCallGesture = null;
                    }
                    bool3 = bool14;
                    updateRegistration(9, observableFieldIsCallGesture);
                    if (observableFieldIsCallGesture != null) {
                        bool15 = observableFieldIsCallGesture.get();
                    }
                    if ((j & 787456) != 0) {
                        if (controlOperationViewModel != null) {
                            offSelected = controlOperationViewModel.getOffSelected();
                        } else {
                            offSelected = null;
                        }
                        bool11 = bool15;
                        updateRegistration(10, offSelected);
                        if (offSelected != null) {
                            bool16 = offSelected.get();
                        }
                        if ((j & 788480) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                            } else {
                                noiseControlVisible = null;
                            }
                            bool2 = bool16;
                            updateRegistration(11, noiseControlVisible);
                            if (noiseControlVisible != null) {
                                bool17 = noiseControlVisible.get();
                            }
                            if ((j & 790528) != 0) {
                                if (controlOperationViewModel != null) {
                                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                                } else {
                                    noiseCancellationSelected = null;
                                }
                                bool18 = bool17;
                                updateRegistration(12, noiseCancellationSelected);
                                if (noiseCancellationSelected != null) {
                                    bool19 = noiseCancellationSelected.get();
                                }
                                if ((j & j2) != 0) {
                                    if (controlOperationViewModel != null) {
                                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                    } else {
                                        voiceAssistantDefaultSelected = null;
                                    }
                                    bool10 = bool19;
                                    updateRegistration(13, voiceAssistantDefaultSelected);
                                    if (voiceAssistantDefaultSelected != null) {
                                        bool20 = voiceAssistantDefaultSelected.get();
                                    }
                                    if ((j & 786432) != 0) {
                                        direction = null;
                                    } else {
                                        direction = null;
                                    }
                                    if ((j & 802816) != 0) {
                                        if (controlOperationViewModel != null) {
                                            itemDesc = controlOperationViewModel.getItemDesc();
                                        } else {
                                            itemDesc = null;
                                        }
                                        j6 = j;
                                        updateRegistration(14, itemDesc);
                                        if (itemDesc != null) {
                                            str6 = itemDesc.get();
                                        }
                                        j7 = j6 & 819208;
                                        if (j7 != 0) {
                                            if (controlOperationViewModel != null) {
                                                enable = controlOperationViewModel.getEnable();
                                            } else {
                                                enable = null;
                                            }
                                            String str11111111111115 = str6;
                                            updateRegistration(15, enable);
                                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                            if (j7 != 0) {
                                                j8 = j6;
                                            } else if (zSafeUnbox) {
                                                j8 = j6 | 8388608;
                                            } else {
                                                j8 = j6 | 4194304;
                                            }
                                            str3 = str11111111111115;
                                            j5 = j8;
                                        } else {
                                            str3 = str6;
                                            zSafeUnbox = false;
                                            j5 = j6;
                                        }
                                        str4 = str5;
                                        f = f3;
                                        z = zSafeUnbox3;
                                        bool7 = bool18;
                                        bool6 = bool20;
                                    } else {
                                        bool20 = bool20;
                                        j6 = j;
                                    }
                                    str6 = null;
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111116 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111111111116;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool10 = bool19;
                                }
                                bool20 = null;
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111117 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111111111117;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111111118 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111111111118;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool18 = bool17;
                            }
                            bool19 = null;
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111119 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111111111119;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111110 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111110;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool2 = bool16;
                        }
                        bool17 = null;
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str111111111111113 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str111111111111113;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111114 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111114;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111115 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111115;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111116 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111116;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111117 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111117;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111118 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111118;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111119 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111119;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111110 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111110;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool11 = bool15;
                    }
                    bool16 = null;
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool2 = bool16;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool17 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str1111111111111111 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str1111111111111111;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111112 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111111111111112;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111113 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111111111111113;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111114 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111114;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111115 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111111111111115;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111116 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111116;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool2 = bool16;
                    }
                    bool17 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111119 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111111111111119;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111110 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111111111111110;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111111 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111111111111111;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111112 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111112;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111113 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111111111111113;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111114 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111114;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111115 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111115;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111116 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111116;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool3 = bool14;
                }
                bool15 = null;
                if ((j & 787456) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool11 = bool15;
                    updateRegistration(10, offSelected);
                    if (offSelected != null) {
                        bool16 = offSelected.get();
                    }
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool2 = bool16;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool17 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111111117 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111111111111117;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111111111118 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111111111111118;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str11111111111111119 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str11111111111111119;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111110 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111110;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111111111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111113 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111113;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111114 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111111111114;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool2 = bool16;
                    }
                    bool17 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111115 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111111115;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111116 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111116;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111111111118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111119 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111119;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111110 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111110;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111112 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str1111111111111111112;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool11 = bool15;
                }
                bool16 = null;
                if ((j & 788480) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool2 = bool16;
                    updateRegistration(11, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool17 = noiseControlVisible.get();
                    }
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111111113 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111111111111111113;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111114 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111111114;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111115 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111111115;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111116 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111116;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111111117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111119 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111119;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111110 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111110;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool2 = bool16;
                }
                bool17 = null;
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool18 = bool17;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool19 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111111111 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111111111111111111;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111112 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111112;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111113 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111113;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111114 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111114;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool18 = bool17;
                }
                bool19 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool10 = bool19;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool20 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111115 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111115;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111116 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111116;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool10 = bool19;
                }
                bool20 = null;
                if ((j & 786432) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 802816) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j6 = j;
                    updateRegistration(14, itemDesc);
                    if (itemDesc != null) {
                        str6 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111117 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111117;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool20 = bool20;
                    j6 = j;
                }
                str6 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str11111111111111111118 = str6;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    str3 = str11111111111111111118;
                    j5 = j8;
                } else {
                    str3 = str6;
                    zSafeUnbox = false;
                    j5 = j6;
                }
                str4 = str5;
                f = f3;
                z = zSafeUnbox3;
                bool7 = bool18;
                bool6 = bool20;
            } else {
                bool = bool13;
            }
            bool14 = null;
            if ((j & 786944) != 0) {
                if (controlOperationViewModel != null) {
                    observableFieldIsCallGesture = controlOperationViewModel.isCallGesture();
                } else {
                    observableFieldIsCallGesture = null;
                }
                bool3 = bool14;
                updateRegistration(9, observableFieldIsCallGesture);
                if (observableFieldIsCallGesture != null) {
                    bool15 = observableFieldIsCallGesture.get();
                }
                if ((j & 787456) != 0) {
                    if (controlOperationViewModel != null) {
                        offSelected = controlOperationViewModel.getOffSelected();
                    } else {
                        offSelected = null;
                    }
                    bool11 = bool15;
                    updateRegistration(10, offSelected);
                    if (offSelected != null) {
                        bool16 = offSelected.get();
                    }
                    if ((j & 788480) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                        } else {
                            noiseControlVisible = null;
                        }
                        bool2 = bool16;
                        updateRegistration(11, noiseControlVisible);
                        if (noiseControlVisible != null) {
                            bool17 = noiseControlVisible.get();
                        }
                        if ((j & 790528) != 0) {
                            if (controlOperationViewModel != null) {
                                noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                            } else {
                                noiseCancellationSelected = null;
                            }
                            bool18 = bool17;
                            updateRegistration(12, noiseCancellationSelected);
                            if (noiseCancellationSelected != null) {
                                bool19 = noiseCancellationSelected.get();
                            }
                            if ((j & j2) != 0) {
                                if (controlOperationViewModel != null) {
                                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                                } else {
                                    voiceAssistantDefaultSelected = null;
                                }
                                bool10 = bool19;
                                updateRegistration(13, voiceAssistantDefaultSelected);
                                if (voiceAssistantDefaultSelected != null) {
                                    bool20 = voiceAssistantDefaultSelected.get();
                                }
                                if ((j & 786432) != 0) {
                                    direction = null;
                                } else {
                                    direction = null;
                                }
                                if ((j & 802816) != 0) {
                                    if (controlOperationViewModel != null) {
                                        itemDesc = controlOperationViewModel.getItemDesc();
                                    } else {
                                        itemDesc = null;
                                    }
                                    j6 = j;
                                    updateRegistration(14, itemDesc);
                                    if (itemDesc != null) {
                                        str6 = itemDesc.get();
                                    }
                                    j7 = j6 & 819208;
                                    if (j7 != 0) {
                                        if (controlOperationViewModel != null) {
                                            enable = controlOperationViewModel.getEnable();
                                        } else {
                                            enable = null;
                                        }
                                        String str11111111111111111119 = str6;
                                        updateRegistration(15, enable);
                                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                        if (j7 != 0) {
                                            j8 = j6;
                                        } else if (zSafeUnbox) {
                                            j8 = j6 | 8388608;
                                        } else {
                                            j8 = j6 | 4194304;
                                        }
                                        str3 = str11111111111111111119;
                                        j5 = j8;
                                    } else {
                                        str3 = str6;
                                        zSafeUnbox = false;
                                        j5 = j6;
                                    }
                                    str4 = str5;
                                    f = f3;
                                    z = zSafeUnbox3;
                                    bool7 = bool18;
                                    bool6 = bool20;
                                } else {
                                    bool20 = bool20;
                                    j6 = j;
                                }
                                str6 = null;
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111110 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111111111110;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool10 = bool19;
                            }
                            bool20 = null;
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111111111111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool18 = bool17;
                        }
                        bool19 = null;
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111113 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111111111113;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111114 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111114;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111115 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111115;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111116 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111111111111116;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool2 = bool16;
                    }
                    bool17 = null;
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111117 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111111111117;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111118 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111118;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111119 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111119;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111110 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111110;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111111 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111111111111;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111112 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111112;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111113 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111113;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111114 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str1111111111111111111114;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool11 = bool15;
                }
                bool16 = null;
                if ((j & 788480) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool2 = bool16;
                    updateRegistration(11, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool17 = noiseControlVisible.get();
                    }
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str1111111111111111111115 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str1111111111111111111115;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111116 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111111111116;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111111111117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111119 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111111111119;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111110 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111111110;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111111 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111111111;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111112 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111112;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool2 = bool16;
                }
                bool17 = null;
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool18 = bool17;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool19 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str11111111111111111111113 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str11111111111111111111113;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111114 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111111114;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111115 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111111115;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111116 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111116;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool18 = bool17;
                }
                bool19 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool10 = bool19;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool20 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111117 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111111117;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111118 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111118;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool10 = bool19;
                }
                bool20 = null;
                if ((j & 786432) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 802816) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j6 = j;
                    updateRegistration(14, itemDesc);
                    if (itemDesc != null) {
                        str6 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111119 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111119;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool20 = bool20;
                    j6 = j;
                }
                str6 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111110 = str6;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    str3 = str111111111111111111111110;
                    j5 = j8;
                } else {
                    str3 = str6;
                    zSafeUnbox = false;
                    j5 = j6;
                }
                str4 = str5;
                f = f3;
                z = zSafeUnbox3;
                bool7 = bool18;
                bool6 = bool20;
            } else {
                bool3 = bool14;
            }
            bool15 = null;
            if ((j & 787456) != 0) {
                if (controlOperationViewModel != null) {
                    offSelected = controlOperationViewModel.getOffSelected();
                } else {
                    offSelected = null;
                }
                bool11 = bool15;
                updateRegistration(10, offSelected);
                if (offSelected != null) {
                    bool16 = offSelected.get();
                }
                if ((j & 788480) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                    } else {
                        noiseControlVisible = null;
                    }
                    bool2 = bool16;
                    updateRegistration(11, noiseControlVisible);
                    if (noiseControlVisible != null) {
                        bool17 = noiseControlVisible.get();
                    }
                    if ((j & 790528) != 0) {
                        if (controlOperationViewModel != null) {
                            noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                        } else {
                            noiseCancellationSelected = null;
                        }
                        bool18 = bool17;
                        updateRegistration(12, noiseCancellationSelected);
                        if (noiseCancellationSelected != null) {
                            bool19 = noiseCancellationSelected.get();
                        }
                        if ((j & j2) != 0) {
                            if (controlOperationViewModel != null) {
                                voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                            } else {
                                voiceAssistantDefaultSelected = null;
                            }
                            bool10 = bool19;
                            updateRegistration(13, voiceAssistantDefaultSelected);
                            if (voiceAssistantDefaultSelected != null) {
                                bool20 = voiceAssistantDefaultSelected.get();
                            }
                            if ((j & 786432) != 0) {
                                direction = null;
                            } else {
                                direction = null;
                            }
                            if ((j & 802816) != 0) {
                                if (controlOperationViewModel != null) {
                                    itemDesc = controlOperationViewModel.getItemDesc();
                                } else {
                                    itemDesc = null;
                                }
                                j6 = j;
                                updateRegistration(14, itemDesc);
                                if (itemDesc != null) {
                                    str6 = itemDesc.get();
                                }
                                j7 = j6 & 819208;
                                if (j7 != 0) {
                                    if (controlOperationViewModel != null) {
                                        enable = controlOperationViewModel.getEnable();
                                    } else {
                                        enable = null;
                                    }
                                    String str111111111111111111111111 = str6;
                                    updateRegistration(15, enable);
                                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                    if (j7 != 0) {
                                        j8 = j6;
                                    } else if (zSafeUnbox) {
                                        j8 = j6 | 8388608;
                                    } else {
                                        j8 = j6 | 4194304;
                                    }
                                    str3 = str111111111111111111111111;
                                    j5 = j8;
                                } else {
                                    str3 = str6;
                                    zSafeUnbox = false;
                                    j5 = j6;
                                }
                                str4 = str5;
                                f = f3;
                                z = zSafeUnbox3;
                                bool7 = bool18;
                                bool6 = bool20;
                            } else {
                                bool20 = bool20;
                                j6 = j;
                            }
                            str6 = null;
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111111112 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111111112;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool10 = bool19;
                        }
                        bool20 = null;
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111111113 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111111113;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111111114 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111111111111111114;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool18 = bool17;
                    }
                    bool19 = null;
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111111115 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111111115;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111111116 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111111111111111116;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str111111111111111111111117 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str111111111111111111111117;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str111111111111111111111118 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str111111111111111111111118;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool2 = bool16;
                }
                bool17 = null;
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool18 = bool17;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool19 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str111111111111111111111119 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str111111111111111111111119;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111110 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111111110;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111111 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111111111;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111112 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str1111111111111111111111112;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool18 = bool17;
                }
                bool19 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool10 = bool19;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool20 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111113 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111111113;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111114 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str1111111111111111111111114;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool10 = bool19;
                }
                bool20 = null;
                if ((j & 786432) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 802816) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j6 = j;
                    updateRegistration(14, itemDesc);
                    if (itemDesc != null) {
                        str6 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str1111111111111111111111115 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str1111111111111111111111115;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool20 = bool20;
                    j6 = j;
                }
                str6 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str1111111111111111111111116 = str6;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    str3 = str1111111111111111111111116;
                    j5 = j8;
                } else {
                    str3 = str6;
                    zSafeUnbox = false;
                    j5 = j6;
                }
                str4 = str5;
                f = f3;
                z = zSafeUnbox3;
                bool7 = bool18;
                bool6 = bool20;
            } else {
                bool11 = bool15;
            }
            bool16 = null;
            if ((j & 788480) != 0) {
                if (controlOperationViewModel != null) {
                    noiseControlVisible = controlOperationViewModel.getNoiseControlVisible();
                } else {
                    noiseControlVisible = null;
                }
                bool2 = bool16;
                updateRegistration(11, noiseControlVisible);
                if (noiseControlVisible != null) {
                    bool17 = noiseControlVisible.get();
                }
                if ((j & 790528) != 0) {
                    if (controlOperationViewModel != null) {
                        noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                    } else {
                        noiseCancellationSelected = null;
                    }
                    bool18 = bool17;
                    updateRegistration(12, noiseCancellationSelected);
                    if (noiseCancellationSelected != null) {
                        bool19 = noiseCancellationSelected.get();
                    }
                    if ((j & j2) != 0) {
                        if (controlOperationViewModel != null) {
                            voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                        } else {
                            voiceAssistantDefaultSelected = null;
                        }
                        bool10 = bool19;
                        updateRegistration(13, voiceAssistantDefaultSelected);
                        if (voiceAssistantDefaultSelected != null) {
                            bool20 = voiceAssistantDefaultSelected.get();
                        }
                        if ((j & 786432) != 0) {
                            direction = null;
                        } else {
                            direction = null;
                        }
                        if ((j & 802816) != 0) {
                            if (controlOperationViewModel != null) {
                                itemDesc = controlOperationViewModel.getItemDesc();
                            } else {
                                itemDesc = null;
                            }
                            j6 = j;
                            updateRegistration(14, itemDesc);
                            if (itemDesc != null) {
                                str6 = itemDesc.get();
                            }
                            j7 = j6 & 819208;
                            if (j7 != 0) {
                                if (controlOperationViewModel != null) {
                                    enable = controlOperationViewModel.getEnable();
                                } else {
                                    enable = null;
                                }
                                String str1111111111111111111111117 = str6;
                                updateRegistration(15, enable);
                                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                                if (j7 != 0) {
                                    j8 = j6;
                                } else if (zSafeUnbox) {
                                    j8 = j6 | 8388608;
                                } else {
                                    j8 = j6 | 4194304;
                                }
                                str3 = str1111111111111111111111117;
                                j5 = j8;
                            } else {
                                str3 = str6;
                                zSafeUnbox = false;
                                j5 = j6;
                            }
                            str4 = str5;
                            f = f3;
                            z = zSafeUnbox3;
                            bool7 = bool18;
                            bool6 = bool20;
                        } else {
                            bool20 = bool20;
                            j6 = j;
                        }
                        str6 = null;
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111118 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111111118;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool10 = bool19;
                    }
                    bool20 = null;
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str1111111111111111111111119 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str1111111111111111111111119;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111110 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111111110;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool18 = bool17;
                }
                bool19 = null;
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool10 = bool19;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool20 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111111111 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111111111111;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111112 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111111112;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool10 = bool19;
                }
                bool20 = null;
                if ((j & 786432) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 802816) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j6 = j;
                    updateRegistration(14, itemDesc);
                    if (itemDesc != null) {
                        str6 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111113 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111111113;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool20 = bool20;
                    j6 = j;
                }
                str6 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str11111111111111111111111114 = str6;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    str3 = str11111111111111111111111114;
                    j5 = j8;
                } else {
                    str3 = str6;
                    zSafeUnbox = false;
                    j5 = j6;
                }
                str4 = str5;
                f = f3;
                z = zSafeUnbox3;
                bool7 = bool18;
                bool6 = bool20;
            } else {
                bool2 = bool16;
            }
            bool17 = null;
            if ((j & 790528) != 0) {
                if (controlOperationViewModel != null) {
                    noiseCancellationSelected = controlOperationViewModel.getNoiseCancellationSelected();
                } else {
                    noiseCancellationSelected = null;
                }
                bool18 = bool17;
                updateRegistration(12, noiseCancellationSelected);
                if (noiseCancellationSelected != null) {
                    bool19 = noiseCancellationSelected.get();
                }
                if ((j & j2) != 0) {
                    if (controlOperationViewModel != null) {
                        voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                    } else {
                        voiceAssistantDefaultSelected = null;
                    }
                    bool10 = bool19;
                    updateRegistration(13, voiceAssistantDefaultSelected);
                    if (voiceAssistantDefaultSelected != null) {
                        bool20 = voiceAssistantDefaultSelected.get();
                    }
                    if ((j & 786432) != 0) {
                        direction = null;
                    } else {
                        direction = null;
                    }
                    if ((j & 802816) != 0) {
                        if (controlOperationViewModel != null) {
                            itemDesc = controlOperationViewModel.getItemDesc();
                        } else {
                            itemDesc = null;
                        }
                        j6 = j;
                        updateRegistration(14, itemDesc);
                        if (itemDesc != null) {
                            str6 = itemDesc.get();
                        }
                        j7 = j6 & 819208;
                        if (j7 != 0) {
                            if (controlOperationViewModel != null) {
                                enable = controlOperationViewModel.getEnable();
                            } else {
                                enable = null;
                            }
                            String str11111111111111111111111115 = str6;
                            updateRegistration(15, enable);
                            zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                            if (j7 != 0) {
                                j8 = j6;
                            } else if (zSafeUnbox) {
                                j8 = j6 | 8388608;
                            } else {
                                j8 = j6 | 4194304;
                            }
                            str3 = str11111111111111111111111115;
                            j5 = j8;
                        } else {
                            str3 = str6;
                            zSafeUnbox = false;
                            j5 = j6;
                        }
                        str4 = str5;
                        f = f3;
                        z = zSafeUnbox3;
                        bool7 = bool18;
                        bool6 = bool20;
                    } else {
                        bool20 = bool20;
                        j6 = j;
                    }
                    str6 = null;
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111116 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111111116;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool10 = bool19;
                }
                bool20 = null;
                if ((j & 786432) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 802816) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j6 = j;
                    updateRegistration(14, itemDesc);
                    if (itemDesc != null) {
                        str6 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111117 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111111117;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool20 = bool20;
                    j6 = j;
                }
                str6 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str11111111111111111111111118 = str6;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    str3 = str11111111111111111111111118;
                    j5 = j8;
                } else {
                    str3 = str6;
                    zSafeUnbox = false;
                    j5 = j6;
                }
                str4 = str5;
                f = f3;
                z = zSafeUnbox3;
                bool7 = bool18;
                bool6 = bool20;
            } else {
                bool18 = bool17;
            }
            bool19 = null;
            if ((j & j2) != 0) {
                if (controlOperationViewModel != null) {
                    voiceAssistantDefaultSelected = controlOperationViewModel.getVoiceAssistantDefaultSelected();
                } else {
                    voiceAssistantDefaultSelected = null;
                }
                bool10 = bool19;
                updateRegistration(13, voiceAssistantDefaultSelected);
                if (voiceAssistantDefaultSelected != null) {
                    bool20 = voiceAssistantDefaultSelected.get();
                }
                if ((j & 786432) != 0) {
                    direction = null;
                } else {
                    direction = null;
                }
                if ((j & 802816) != 0) {
                    if (controlOperationViewModel != null) {
                        itemDesc = controlOperationViewModel.getItemDesc();
                    } else {
                        itemDesc = null;
                    }
                    j6 = j;
                    updateRegistration(14, itemDesc);
                    if (itemDesc != null) {
                        str6 = itemDesc.get();
                    }
                    j7 = j6 & 819208;
                    if (j7 != 0) {
                        if (controlOperationViewModel != null) {
                            enable = controlOperationViewModel.getEnable();
                        } else {
                            enable = null;
                        }
                        String str11111111111111111111111119 = str6;
                        updateRegistration(15, enable);
                        zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                        if (j7 != 0) {
                            j8 = j6;
                        } else if (zSafeUnbox) {
                            j8 = j6 | 8388608;
                        } else {
                            j8 = j6 | 4194304;
                        }
                        str3 = str11111111111111111111111119;
                        j5 = j8;
                    } else {
                        str3 = str6;
                        zSafeUnbox = false;
                        j5 = j6;
                    }
                    str4 = str5;
                    f = f3;
                    z = zSafeUnbox3;
                    bool7 = bool18;
                    bool6 = bool20;
                } else {
                    bool20 = bool20;
                    j6 = j;
                }
                str6 = null;
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111111110 = str6;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    str3 = str111111111111111111111111110;
                    j5 = j8;
                } else {
                    str3 = str6;
                    zSafeUnbox = false;
                    j5 = j6;
                }
                str4 = str5;
                f = f3;
                z = zSafeUnbox3;
                bool7 = bool18;
                bool6 = bool20;
            } else {
                bool10 = bool19;
            }
            bool20 = null;
            if ((j & 786432) != 0) {
                direction = null;
            } else {
                direction = null;
            }
            if ((j & 802816) != 0) {
                if (controlOperationViewModel != null) {
                    itemDesc = controlOperationViewModel.getItemDesc();
                } else {
                    itemDesc = null;
                }
                j6 = j;
                updateRegistration(14, itemDesc);
                if (itemDesc != null) {
                    str6 = itemDesc.get();
                }
                j7 = j6 & 819208;
                if (j7 != 0) {
                    if (controlOperationViewModel != null) {
                        enable = controlOperationViewModel.getEnable();
                    } else {
                        enable = null;
                    }
                    String str111111111111111111111111111 = str6;
                    updateRegistration(15, enable);
                    zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                    if (j7 != 0) {
                        j8 = j6;
                    } else if (zSafeUnbox) {
                        j8 = j6 | 8388608;
                    } else {
                        j8 = j6 | 4194304;
                    }
                    str3 = str111111111111111111111111111;
                    j5 = j8;
                } else {
                    str3 = str6;
                    zSafeUnbox = false;
                    j5 = j6;
                }
                str4 = str5;
                f = f3;
                z = zSafeUnbox3;
                bool7 = bool18;
                bool6 = bool20;
            } else {
                bool20 = bool20;
                j6 = j;
            }
            str6 = null;
            j7 = j6 & 819208;
            if (j7 != 0) {
                if (controlOperationViewModel != null) {
                    enable = controlOperationViewModel.getEnable();
                } else {
                    enable = null;
                }
                String str111111111111111111111111112 = str6;
                updateRegistration(15, enable);
                zSafeUnbox = ViewDataBinding.safeUnbox(enable != null ? enable.get() : null);
                if (j7 != 0) {
                    j8 = j6;
                } else if (zSafeUnbox) {
                    j8 = j6 | 8388608;
                } else {
                    j8 = j6 | 4194304;
                }
                str3 = str111111111111111111111111112;
                j5 = j8;
            } else {
                str3 = str6;
                zSafeUnbox = false;
                j5 = j6;
            }
            str4 = str5;
            f = f3;
            z = zSafeUnbox3;
            bool7 = bool18;
            bool6 = bool20;
        } else {
            controlOperationViewModel = controlOperationViewModel2;
            j2 = 794624;
            j3 = 786560;
            j4 = 786496;
            j5 = j;
            str = null;
            bool = null;
            bool2 = null;
            bool3 = null;
            bool4 = null;
            str2 = null;
            bool5 = null;
            bool6 = null;
            str3 = null;
            str4 = null;
            direction = null;
            bool7 = null;
            bool8 = null;
            bool9 = null;
            bool10 = null;
            bool11 = null;
            zSafeUnbox = false;
            f = 0.0f;
            f2 = 0.0f;
            z = false;
            z2 = false;
        }
        if ((j5 & 4194304) != 0) {
            if (controlOperationViewModel != null) {
                newsPromptVisibility = controlOperationViewModel.getNewsPromptVisibility();
            }
            ObservableField<Boolean> observableField = newsPromptVisibility;
            updateRegistration(3, observableField);
            bool12 = observableField != null ? observableField.get() : bool8;
            zSafeUnbox2 = ViewDataBinding.safeUnbox(bool12);
        } else {
            bool12 = bool8;
            zSafeUnbox2 = z;
        }
        long j11 = j5 & 819208;
        if (j11 != 0) {
            z3 = zSafeUnbox ? true : zSafeUnbox2;
        } else {
            z3 = false;
        }
        if ((j5 & 524288) != 0) {
            BindingAdapter.onClick(this.mboundView10, this.mCallback306);
            BindingAdapter.onClick((ViewGroup) this.mboundView12, this.mCallback307);
            BindingAdapter.onClick(this.mboundView15, this.mCallback308);
            BindingAdapter.onClick(this.mboundView8, this.mCallback304);
            BindingAdapter.onClick(this.mboundView9, this.mCallback305);
        }
        if ((j5 & 787456) != 0) {
            BindingAdapter.viewSelected(this.mboundView10, bool2);
        }
        if ((j5 & 786448) != 0) {
            BindingAdapter.goneUnless(this.mboundView11, bool4);
        }
        if ((j5 & 786436) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView12.setAlpha(f);
            }
            BindingAdapter.chatGptOption(this.mboundView13, bool5);
            BindingAdapter.goneUnless(this.mboundView14, Boolean.valueOf(z2));
        }
        if ((j5 & 786688) != 0) {
            BindingAdapter.viewSelected(this.mboundView13, bool3);
        }
        if ((j5 & 786433) != 0) {
            TextViewBindingAdapter.setText(this.mboundView14, str2);
        }
        if ((j5 & j2) != 0) {
            BindingAdapter.viewSelected(this.mboundView15, bool6);
        }
        if ((j5 & 786432) != 0) {
            BindingAdapter.viewRadius(this.mboundView2, direction);
        }
        if ((j5 & 786440) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.mboundView3.setAlpha(f2);
            }
            BindingAdapter.goneUnless(this.mboundView6, bool12);
        }
        if ((j5 & 802816) != 0 && getBuildSdkInt() >= 4) {
            this.mboundView3.setContentDescription(str3);
        }
        if ((j5 & 819200) != 0) {
            ViewBindingAdapter.setOnClick(this.mboundView3, this.mCallback303, zSafeUnbox);
        }
        if ((j5 & 786464) != 0) {
            TextViewBindingAdapter.setText(this.mboundView4, str);
        }
        if (j11 != 0) {
            BindingAdapter.invisibleUnless(this.mboundView5, Boolean.valueOf(z3));
        }
        if ((j5 & j3) != 0) {
            BindingAdapter.viewSelected(this.mboundView5, bool);
        }
        if ((j5 & j4) != 0) {
            TextViewBindingAdapter.setText(this.mboundView6, str4);
        }
        if ((j5 & 788480) != 0) {
            BindingAdapter.goneUnless(this.mboundView7, bool7);
        }
        if ((j5 & 786434) != 0) {
            BindingAdapter.viewSelected(this.mboundView8, bool9);
        }
        if ((j5 & 790528) != 0) {
            BindingAdapter.viewSelected(this.mboundView9, bool10);
        }
        if ((j5 & 786944) != 0) {
            BindingAdapter.goneUnless(this.notTitle, bool11);
        }
    }

    @Override // com.nothing.ear.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int sourceId, View callbackArg_0) {
        switch (sourceId) {
            case 1:
                ControlItemViewModel controlItemViewModel = this.mItemViewModel;
                ControlCaseOperationActivity controlCaseOperationActivity = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel = this.mViewModel;
                if (controlCaseOperationActivity != null) {
                    controlCaseOperationActivity.onSelectedOperation(controlOperationViewModel, controlItemViewModel);
                }
                break;
            case 2:
                ControlItemViewModel controlItemViewModel2 = this.mItemViewModel;
                ControlCaseOperationActivity controlCaseOperationActivity2 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel2 = this.mViewModel;
                if (controlCaseOperationActivity2 != null) {
                    controlCaseOperationActivity2.onClickTransparency(controlOperationViewModel2, controlItemViewModel2);
                }
                break;
            case 3:
                ControlItemViewModel controlItemViewModel3 = this.mItemViewModel;
                ControlCaseOperationActivity controlCaseOperationActivity3 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel3 = this.mViewModel;
                if (controlCaseOperationActivity3 != null) {
                    controlCaseOperationActivity3.onClickNoiseCancellation(controlOperationViewModel3, controlItemViewModel3);
                }
                break;
            case 4:
                ControlItemViewModel controlItemViewModel4 = this.mItemViewModel;
                ControlCaseOperationActivity controlCaseOperationActivity4 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel4 = this.mViewModel;
                if (controlCaseOperationActivity4 != null) {
                    controlCaseOperationActivity4.onClickOff(controlOperationViewModel4, controlItemViewModel4);
                }
                break;
            case 5:
                ControlItemViewModel controlItemViewModel5 = this.mItemViewModel;
                ControlCaseOperationActivity controlCaseOperationActivity5 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel5 = this.mViewModel;
                if (controlCaseOperationActivity5 != null) {
                    controlCaseOperationActivity5.onClickChatGpt(controlOperationViewModel5, controlItemViewModel5);
                }
                break;
            case 6:
                ControlItemViewModel controlItemViewModel6 = this.mItemViewModel;
                ControlCaseOperationActivity controlCaseOperationActivity6 = this.mEventHandler;
                ControlOperationViewModel controlOperationViewModel6 = this.mViewModel;
                if (controlCaseOperationActivity6 != null) {
                    controlCaseOperationActivity6.onClickDefaultVoiceAssistant(controlOperationViewModel6, controlItemViewModel6);
                }
                break;
        }
    }
}
